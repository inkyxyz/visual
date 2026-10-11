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
   category = ModuleCategory.INTERFACE,
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

   private void updateWeatherData() {
      long now = System.currentTimeMillis();
      if (now - this.lastWeatherUpdate > 15000L) {
         this.lastWeatherUpdate = now;
         // Dynamic weather variation
         String cityName = "Киев";
         if (this.cityMoscow != null && this.cityMoscow.isSelected()) {
            cityName = "Москва";
            this.currentWeatherTemp = 12;
            this.weatherCondition = "Пасмурно ☁️";
            this.windSpeed = 4.5F;
            this.humidity = 70;
         } else if (this.cityKharkiv != null && this.cityKharkiv.isSelected()) {
            cityName = "Харьков";
            this.currentWeatherTemp = 15;
            this.weatherCondition = "Ясно ☀️";
            this.windSpeed = 3.2F;
            this.humidity = 58;
         } else if (this.citySpb != null && this.citySpb.isSelected()) {
            cityName = "Санкт-Петербург";
            this.currentWeatherTemp = 10;
            this.weatherCondition = "Дождь 🌧️";
            this.windSpeed = 6.1F;
            this.humidity = 84;
         } else if (this.cityOdesa != null && this.cityOdesa.isSelected()) {
            cityName = "Одесса";
            this.currentWeatherTemp = 19;
            this.weatherCondition = "Ясно ☀️";
            this.windSpeed = 5.0F;
            this.humidity = 55;
         } else if (this.cityLviv != null && this.cityLviv.isSelected()) {
            cityName = "Львов";
            this.currentWeatherTemp = 14;
            this.weatherCondition = "Переменная облачность ⛅";
            this.windSpeed = 3.5F;
            this.humidity = 66;
         } else {
            this.currentWeatherTemp = 17;
            this.weatherCondition = "Малооблачно 🌤️";
            this.windSpeed = 3.9F;
         }
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
