package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.math.MathHelper;
import pyrock.events.render.PreHudRenderEvent;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Weather & Alerts",
   category = ModuleCategory.OTHER,
   iI_method_476ab839 = false,
   III_method_a89e5834 = "modules.descriptions.weather_alerts"
)
public class WeatherAlertModule extends Module {

   public static class AlertRegion {
      public final String name;
      public final String country; // "UA" or "RU"
      public boolean isAlert;
      public String alertType; // "Ракетная опасность", "БПЛА", "Воздушная тревога", "Отбой"
      public long lastChangeTime;

      public AlertRegion(String name, String country, boolean isAlert, String alertType) {
         this.name = name;
         this.country = country;
         this.isAlert = isAlert;
         this.alertType = alertType;
         this.lastChangeTime = System.currentTimeMillis();
      }
   }

   private ModeSetting displayModeSetting;
   private ModeSetting.Nested1_42765c60 displayBoth;
   private ModeSetting.Nested1_42765c60 displayWeather;
   private ModeSetting.Nested1_42765c60 displayAlerts;

   private ModeSetting regionScopeSetting;
   private ModeSetting.Nested1_42765c60 scopeUkraine;
   private ModeSetting.Nested1_42765c60 scopeRF;
   private ModeSetting.Nested1_42765c60 scopeBoth;

   private ModeSetting citySetting;
   private ModeSetting.Nested1_42765c60 cityKyiv;
   private ModeSetting.Nested1_42765c60 cityMoscow;
   private ModeSetting.Nested1_42765c60 cityKharkiv;
   private ModeSetting.Nested1_42765c60 citySpb;
   private ModeSetting.Nested1_42765c60 cityOdesa;
   private ModeSetting.Nested1_42765c60 cityLviv;

   private SliderSetting posXSetting;
   private SliderSetting posYSetting;
   private SliderSetting scaleSetting;
   private BooleanSetting radarScanSetting;
   private BooleanSetting syncTheme;
   private ColorSetting customColor;

   private final List<AlertRegion> regions = new ArrayList<>();
   private long lastWeatherUpdate = 0L;
   private int currentWeatherTemp = 16;
   private String weatherCondition = "Облачно ⛅";
   private float windSpeed = 3.8F;
   private int humidity = 64;

   public WeatherAlertModule() {
      this.initSettings();
      this.initDefaultRegions();
      this.i_method_aefc2388(true);
   }

   private void initDefaultRegions() {
      this.regions.clear();
      // Ukraine regions
      this.regions.add(new AlertRegion("Киевская обл.", "UA", true, "Воздушная тревога"));
      this.regions.add(new AlertRegion("Харьковская обл.", "UA", true, "Ракетная угроза"));
      this.regions.add(new AlertRegion("Днепропетровская", "UA", true, "Угроза БПЛА"));
      this.regions.add(new AlertRegion("Одесская обл.", "UA", false, "Отбой"));
      this.regions.add(new AlertRegion("Львовская обл.", "UA", false, "Отбой"));
      this.regions.add(new AlertRegion("Запорожская обл.", "UA", true, "Воздушная тревога"));
      this.regions.add(new AlertRegion("Полтавская обл.", "UA", false, "Отбой"));

      // RF regions
      this.regions.add(new AlertRegion("Белгородская обл.", "RU", true, "Ракетная опасность"));
      this.regions.add(new AlertRegion("Курская обл.", "RU", true, "Опасность БПЛА"));
      this.regions.add(new AlertRegion("Брянская обл.", "RU", false, "Отбой"));
      this.regions.add(new AlertRegion("Воронежская обл.", "RU", true, "Опасность БПЛА"));
      this.regions.add(new AlertRegion("Ростовская обл.", "RU", false, "Отбой"));
      this.regions.add(new AlertRegion("Московская обл.", "RU", false, "Отбой"));
   }

   @Compile(obfuscation = 4)
   private void initSettings() {
      this.displayModeSetting = new ModeSetting(this, "Отображение");
      this.displayBoth = new ModeSetting.Nested1_42765c60(this.displayModeSetting, "Погода + Карта").select();
      this.displayWeather = new ModeSetting.Nested1_42765c60(this.displayModeSetting, "Только погода");
      this.displayAlerts = new ModeSetting.Nested1_42765c60(this.displayModeSetting, "Карта тревог");

      this.regionScopeSetting = new ModeSetting(this, "Регионы тревог");
      this.scopeBoth = new ModeSetting.Nested1_42765c60(this.regionScopeSetting, "Все регионы").select();
      this.scopeUkraine = new ModeSetting.Nested1_42765c60(this.regionScopeSetting, "Украина");
      this.scopeRF = new ModeSetting.Nested1_42765c60(this.regionScopeSetting, "Россия");

      this.citySetting = new ModeSetting(this, "Город погоды");
      this.cityKyiv = new ModeSetting.Nested1_42765c60(this.citySetting, "Киев").select();
      this.cityMoscow = new ModeSetting.Nested1_42765c60(this.citySetting, "Москва");
      this.cityKharkiv = new ModeSetting.Nested1_42765c60(this.citySetting, "Харьков");
      this.citySpb = new ModeSetting.Nested1_42765c60(this.citySetting, "СПб");
      this.cityOdesa = new ModeSetting.Nested1_42765c60(this.citySetting, "Одесса");
      this.cityLviv = new ModeSetting.Nested1_42765c60(this.citySetting, "Львов");

      this.posXSetting = new SliderSetting(this, "Позиция X")
         .I_method_c8c9a7d7(10.0F).i_method_65e2aff7(1200.0F).II_method_b0f56334(5.0F).Ii_method_4e0e6b54(15.0F);

      this.posYSetting = new SliderSetting(this, "Позиция Y")
         .I_method_c8c9a7d7(10.0F).i_method_65e2aff7(800.0F).II_method_b0f56334(5.0F).Ii_method_4e0e6b54(120.0F);

      this.scaleSetting = new SliderSetting(this, "Размер")
         .I_method_c8c9a7d7(0.6F).i_method_65e2aff7(1.8F).II_method_b0f56334(0.05F).Ii_method_4e0e6b54(1.0F);

      this.radarScanSetting = new BooleanSetting(this, "Радар-сканер").select();
      this.syncTheme = new BooleanSetting(this, "theme.sync").select();
      this.customColor = new ColorSetting(this, "Цвет", this.syncTheme::i_method_9b12da03)
         .I_method_a62f5dd6(new ColorRGBA(0.0F, 220.0F, 255.0F, 240.0F));
   }

   private String lastRequestedCity = "";
   private boolean isFetchingWeather = false;

   public void setCity(String cityName) {
      if (cityName == null) return;
      this.lastWeatherUpdate = System.currentTimeMillis();

      // Immediate heuristic defaults while live data is streaming
      switch (cityName) {
         case "Москва" -> { this.currentWeatherTemp = 12; this.weatherCondition = "Пасмурно ☁️"; this.windSpeed = 4.5F; this.humidity = 70; }
         case "Харьков" -> { this.currentWeatherTemp = 15; this.weatherCondition = "Ясно ☀️"; this.windSpeed = 3.2F; this.humidity = 58; }
         case "СПб", "Санкт-Петербург" -> { this.currentWeatherTemp = 10; this.weatherCondition = "Дождь 🌧️"; this.windSpeed = 6.1F; this.humidity = 84; }
         case "Одесса" -> { this.currentWeatherTemp = 19; this.weatherCondition = "Ясно ☀️"; this.windSpeed = 5.0F; this.humidity = 55; }
         case "Львов" -> { this.currentWeatherTemp = 14; this.weatherCondition = "Облачно ⛅"; this.windSpeed = 3.5F; this.humidity = 66; }
         case "Казань" -> { this.currentWeatherTemp = 11; this.weatherCondition = "Переменная облачность ⛅"; this.windSpeed = 4.0F; this.humidity = 68; }
         case "Екатеринбург" -> { this.currentWeatherTemp = 9; this.weatherCondition = "Пасмурно ☁️"; this.windSpeed = 5.2F; this.humidity = 62; }
         case "Ростов" -> { this.currentWeatherTemp = 18; this.weatherCondition = "Ясно ☀️"; this.windSpeed = 4.2F; this.humidity = 52; }
         default -> { this.currentWeatherTemp = 17; this.weatherCondition = "Малооблачно 🌤️"; this.windSpeed = 3.8F; this.humidity = 64; }
      }

      this.fetchLiveWeatherDataAsync(cityName);
   }

   private void fetchLiveWeatherDataAsync(String cityName) {
      if (this.isFetchingWeather) return;
      this.isFetchingWeather = true;

      Thread thread = new Thread(() -> {
         try {
            double lat = 50.4501;
            double lon = 30.5234;
            switch (cityName) {
               case "Москва" -> { lat = 55.7558; lon = 37.6173; }
               case "СПб", "Санкт-Петербург" -> { lat = 59.9343; lon = 30.3351; }
               case "Харьков" -> { lat = 49.9935; lon = 36.2304; }
               case "Одесса" -> { lat = 46.4825; lon = 30.7233; }
               case "Львов" -> { lat = 49.8397; lon = 24.0297; }
               case "Казань" -> { lat = 55.7887; lon = 49.1221; }
               case "Екатеринбург" -> { lat = 56.8389; lon = 60.6057; }
               case "Ростов" -> { lat = 47.2357; lon = 39.7015; }
               default -> { lat = 50.4501; lon = 30.5234; }
            }

            String urlStr = "https://api.open-meteo.com/v1/forecast?latitude=" + lat + "&longitude=" + lon + "&current=temperature_2m,relative_humidity_2m,weather_code,wind_speed_10m";
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) new java.net.URI(urlStr).toURL().openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(3500);
            conn.setReadTimeout(3500);
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");

            if (conn.getResponseCode() == 200) {
               try (java.io.InputStream is = conn.getInputStream()) {
                  String jsonStr = new String(is.readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
                  com.google.gson.JsonObject root = com.google.gson.JsonParser.parseString(jsonStr).getAsJsonObject();
                  if (root.has("current")) {
                     com.google.gson.JsonObject curr = root.getAsJsonObject("current");
                     if (curr.has("temperature_2m")) {
                        this.currentWeatherTemp = (int) Math.round(curr.get("temperature_2m").getAsDouble());
                     }
                     if (curr.has("wind_speed_10m")) {
                        this.windSpeed = (float) curr.get("wind_speed_10m").getAsDouble();
                     }
                     if (curr.has("relative_humidity_2m")) {
                        this.humidity = curr.get("relative_humidity_2m").getAsInt();
                     }
                     if (curr.has("weather_code")) {
                        int code = curr.get("weather_code").getAsInt();
                        this.weatherCondition = mapWeatherCodeToCondition(code);
                     }
                  }
               }
            }
         } catch (Throwable ignored) {
         } finally {
            this.isFetchingWeather = false;
         }
      }, "Rockstar-Weather-Fetcher");
      thread.setDaemon(true);
      thread.start();
   }

   private static String mapWeatherCodeToCondition(int code) {
      return switch (code) {
         case 0 -> "Ясно ☀️";
         case 1 -> "Малооблачно 🌤️";
         case 2 -> "Облачно ⛅";
         case 3 -> "Пасмурно ☁️";
         case 45, 48 -> "Туман 🌫️";
         case 51, 53, 55 -> "Морось 🌦️";
         case 61, 63, 65 -> "Дождь 🌧️";
         case 71, 73, 75, 77 -> "Снег ❄️";
         case 80, 81, 82 -> "Ливень 🌧️";
         case 85, 86 -> "Снегопад ❄️";
         case 95, 96, 99 -> "Гроза ⚡";
         default -> "Переменная облачность ⛅";
      };
   }

   private void updateWeatherData() {
      long now = System.currentTimeMillis();
      if (now - this.lastWeatherUpdate > 120000L) {
         EscapeMenuConfig cfg = EscapeMenuConfig.getInstance();
         String cName = (cfg != null && cfg.weatherCity != null) ? cfg.weatherCity : "Киев";
         this.setCity(cName);
      }
   }

   public int getCurrentWeatherTemp() { return this.currentWeatherTemp; }
   public String getWeatherCondition() { return this.weatherCondition; }
   public float getWindSpeed() { return this.windSpeed; }
   public int getHumidity() { return this.humidity; }
   public List<AlertRegion> getRegions() { return this.regions; }
   public void refresh() { this.updateWeatherData(); }

   private final IiIIIiII_Class69<PreHudRenderEvent> hudListener = event -> {
      // In-game HUD rendering disabled per user request: widgets rendered inside Escape Menu!
      this.updateWeatherData();
   };
}
