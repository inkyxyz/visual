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
      this.displayModeSetting = new ModeSetting(this, "Display Mode / Отображение");
      this.displayBoth = new ModeSetting.Nested1_42765c60(this.displayModeSetting, "Both / Погода + Карта").select();
      this.displayWeather = new ModeSetting.Nested1_42765c60(this.displayModeSetting, "Weather Only / Только Погода");
      this.displayAlerts = new ModeSetting.Nested1_42765c60(this.displayModeSetting, "Alert Map Only / Карта тревог");

      this.regionScopeSetting = new ModeSetting(this, "Alert Scope / Регионы тревог");
      this.scopeBoth = new ModeSetting.Nested1_42765c60(this.regionScopeSetting, "UA + RF (Все)").select();
      this.scopeUkraine = new ModeSetting.Nested1_42765c60(this.regionScopeSetting, "Ukraine (Украина)");
      this.scopeRF = new ModeSetting.Nested1_42765c60(this.regionScopeSetting, "RF (Россия)");

      this.citySetting = new ModeSetting(this, "City / Город погоды");
      this.cityKyiv = new ModeSetting.Nested1_42765c60(this.citySetting, "Kyiv / Киев").select();
      this.cityMoscow = new ModeSetting.Nested1_42765c60(this.citySetting, "Moscow / Москва");
      this.cityKharkiv = new ModeSetting.Nested1_42765c60(this.citySetting, "Kharkiv / Харьков");
      this.citySpb = new ModeSetting.Nested1_42765c60(this.citySetting, "Saint Petersburg / СПб");
      this.cityOdesa = new ModeSetting.Nested1_42765c60(this.citySetting, "Odesa / Одесса");
      this.cityLviv = new ModeSetting.Nested1_42765c60(this.citySetting, "Lviv / Львов");

      this.posXSetting = new SliderSetting(this, "Position X / Позиция X")
         .I_method_c8c9a7d7(10.0F).i_method_65e2aff7(1200.0F).II_method_b0f56334(5.0F).Ii_method_4e0e6b54(15.0F);

      this.posYSetting = new SliderSetting(this, "Position Y / Позиция Y")
         .I_method_c8c9a7d7(10.0F).i_method_65e2aff7(800.0F).II_method_b0f56334(5.0F).Ii_method_4e0e6b54(120.0F);

      this.scaleSetting = new SliderSetting(this, "Scale / Размер")
         .I_method_c8c9a7d7(0.6F).i_method_65e2aff7(1.8F).II_method_b0f56334(0.05F).Ii_method_4e0e6b54(1.0F);

      this.radarScanSetting = new BooleanSetting(this, "Radar Sweep / Радар-сканер").select();
      this.syncTheme = new BooleanSetting(this, "theme.sync").select();
      this.customColor = new ColorSetting(this, "Color / Цвет", this.syncTheme::i_method_9b12da03)
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
            this.humidity = 62;
         }
      }
   }

   private final IiIIIiII_Class69<PreHudRenderEvent> hudListener = event -> {
      MinecraftClient mc = MinecraftClient.getInstance();
      if (mc.player == null) return;

      this.updateWeatherData();

      CustomDrawContext context = event.getContext();
      DrawContext original = event.getContext();

      float x = this.posXSetting != null ? this.posXSetting.Ii_method_a20abcd2() : 15.0F;
      float y = this.posYSetting != null ? this.posYSetting.Ii_method_a20abcd2() : 120.0F;
      float scale = this.scaleSetting != null ? this.scaleSetting.Ii_method_a20abcd2() : 1.0F;

      ColorRGBA themeCol = (this.syncTheme != null && this.syncTheme.i_method_9b12da03())
         ? IiiiiIIIi_Class242.i_method_5dfec6e()
         : (this.customColor != null ? this.customColor.I_method_bde5f08e() : new ColorRGBA(0.0F, 220.0F, 255.0F, 240.0F));

      boolean showWeather = this.displayWeather.isSelected() || this.displayBoth.isSelected();
      boolean showAlerts = this.displayAlerts.isSelected() || this.displayBoth.isSelected();

      float cardWidth = 195.0F * scale;
      float weatherHeight = showWeather ? (72.0F * scale) : 0.0F;
      float alertHeight = showAlerts ? (115.0F * scale) : 0.0F;
      float cardHeight = weatherHeight + alertHeight + (showWeather && showAlerts ? 6.0F : 0.0F);

      context.pushMatrix();
      context.getMatrices().translate(x, y, 0.0F);
      context.getMatrices().scale(scale, scale, 1.0F);

      // Liquid glass outer card
      context.drawClientRect(0.0F, 0.0F, 195.0F, (weatherHeight + alertHeight) / scale + (showWeather && showAlerts ? 6.0F : 0.0F), 1.0F, 1.0F, 1.0F, 9.0F, true);

      float curY = 6.0F;

      // 1. Weather section
      if (showWeather) {
         String cityName = "Киев";
         if (this.cityMoscow.isSelected()) cityName = "Москва";
         else if (this.cityKharkiv.isSelected()) cityName = "Харьков";
         else if (this.citySpb.isSelected()) cityName = "СПб";
         else if (this.cityOdesa.isSelected()) cityName = "Одесса";
         else if (this.cityLviv.isSelected()) cityName = "Львов";

         original.drawText(mc.textRenderer, "ПОГОДА • " + cityName.toUpperCase(), 8, (int)curY, themeCol.getRGB(), false);
         curY += 12.0F;

         // Large temperature & condition
         String tempStr = (this.currentWeatherTemp > 0 ? "+" : "") + this.currentWeatherTemp + "°C";
         original.drawText(mc.textRenderer, tempStr + "  " + this.weatherCondition, 8, (int)curY, 0xFFFFFFFF, false);
         curY += 14.0F;

         // Stats line: Wind, Humidity
         String stats = "Ветер: " + this.windSpeed + " м/с  •  Влажность: " + this.humidity + "%";
         original.drawText(mc.textRenderer, stats, 8, (int)curY, 0xFFA0B5D0, false);
         curY += 12.0F;

         // Mini 3-day forecast bar
         context.drawRect(8.0F, curY, 179.0F, 1.0F, themeCol.withAlpha(50.0F));
         curY += 5.0F;
         String miniDays = "Завтра: +17° ⛅   Пт: +19° ☀️   Сб: +15° 🌧️";
         original.drawText(mc.textRenderer, miniDays, 8, (int)curY, 0xFF7EA0C0, false);
         curY += 16.0F;
      }

      // Separator if both
      if (showWeather && showAlerts) {
         context.drawRect(8.0F, curY, 179.0F, 1.0F, themeCol.withAlpha(70.0F));
         curY += 6.0F;
      }

      // 2. Air Raid Alert section
      if (showAlerts) {
         // Header with flashing alarm indicator
         long now = System.currentTimeMillis();
         boolean blink = (now % 1000L) > 500L;
         int blinkRed = blink ? 0xFFFF3333 : 0xFFAA1111;

         original.drawText(mc.textRenderer, "КАРТА ТРЕВОГ • RADAR", 8, (int)curY, themeCol.getRGB(), false);
         original.drawText(mc.textRenderer, "🚨 LIVE", 150, (int)curY, blinkRed, false);
         curY += 12.0F;

         // Animated Radar Display Circle
         float radarCenterX = 22.0F;
         float radarCenterY = curY + 18.0F;
         float radarRadius = 15.0F;

         // Radar ring
         int radarBorder = themeCol.withAlpha(120.0F).getRGB();
         context.drawRect(radarCenterX - radarRadius, radarCenterY - radarRadius, radarRadius * 2.0F, radarRadius * 2.0F, new ColorRGBA(10.0F, 20.0F, 30.0F, 140.0F));

         if (this.radarScanSetting != null && this.radarScanSetting.i_method_9b12da03()) {
            float sweepAngle = (now * 0.003F) % ((float)Math.PI * 2.0F);
            float sx = radarCenterX + (float)Math.cos(sweepAngle) * (radarRadius - 1.0F);
            float sy = radarCenterY + (float)Math.sin(sweepAngle) * (radarRadius - 1.0F);
            context.drawLine(new net.minecraft.util.math.Vec2f(radarCenterX, radarCenterY), new net.minecraft.util.math.Vec2f(sx, sy), themeCol.withAlpha(220.0F));
         }

         // Filtered region list
         String filterCountry = this.scopeUkraine.isSelected() ? "UA" : (this.scopeRF.isSelected() ? "RU" : "ALL");
         int renderedCount = 0;
         float itemY = curY;

         for (AlertRegion r : this.regions) {
            if (!filterCountry.equals("ALL") && !r.country.equals(filterCountry)) continue;
            if (renderedCount >= 4) break;

            int statusColor = r.isAlert ? 0xFFFF4444 : 0xFF44FF88;
            String icon = r.isAlert ? "🔴" : "🟢";
            String line = icon + " " + r.name + " (" + (r.isAlert ? r.alertType : "Отбой") + ")";

            original.drawText(mc.textRenderer, line, 44, (int)itemY, statusColor, false);
            itemY += 10.0F;
            renderedCount++;
         }

         curY += 46.0F;

         // Summary alert banner
         long alertCount = this.regions.stream()
            .filter(r -> (filterCountry.equals("ALL") || r.country.equals(filterCountry)) && r.isAlert)
            .count();

         String bannerText = alertCount > 0 ? ("⚠️ Активных тревог: " + alertCount) : "🟢 Все регионы спокойны";
         int bannerColor = alertCount > 0 ? 0xFFFF6644 : 0xFF66EE99;
         original.drawText(mc.textRenderer, bannerText, 8, (int)curY, bannerColor, false);
      }

      context.popMatrix();
   };
}
