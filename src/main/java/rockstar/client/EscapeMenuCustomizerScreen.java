package rockstar.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import org.lwjgl.glfw.GLFW;
import pyrock.utility.render.ColorRGBA;

public class EscapeMenuCustomizerScreen extends ii_Class4 {

    private final Screen parentScreen;

    public static final String[] WEATHER_CITIES = {
        "Киев", "Москва", "Харьков", "СПб", "Одесса", "Львов", "Казань", "Ростов", "Екатеринбург"
    };

    public static final String[] ALERT_SCOPES = {
        "Все", "Украина", "Россия"
    };

    public EscapeMenuCustomizerScreen(Screen parent) {
        this.parentScreen = parent;
    }

    public EscapeMenuCustomizerScreen() {
        this(null);
    }

    @Override
    public void render(III custom) {
        float cx = this.width / 2.0F;
        float cy = this.height / 2.0F;

        // Frosted minimal translucent backdrop
        custom.drawRect(0.0F, 0.0F, (float)this.width, (float)this.height, new ColorRGBA(8.0F, 12.0F, 20.0F, 145.0F));

        IIiIIi_Class10 font = null;
        IIiIIi_Class10 boldFont = null;
        IIiIIi_Class10 subFont = null;
        IIiIIi_Class10 tinyFont = null;
        try {
            if (IIiIiI_Class11.i_field_857c0621 != null) {
                boldFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(13.0F);
                font = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(9.5F);
                subFont = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F);
                tinyFont = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F);
            }
        } catch (Throwable ignored) {}

        // Main Frosted Glass Dialog Card
        float cardW = Math.min(490.0F, this.width - 30.0F);
        float cardH = Math.min(390.0F, this.height - 30.0F);
        float cardX = cx - cardW / 2.0F;
        float cardY = cy - cardH / 2.0F;
        IIiii_Class8 cRad = IIiii_Class8.I_method_893b2757(14.0F);

        custom.drawShadow(cardX, cardY, cardW, cardH, 24.0F, cRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 100.0F));
        custom.drawBlurredRect(cardX, cardY, cardW, cardH, 24.0F, 3.5F, cRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F));
        custom.drawRoundedRect(cardX, cardY, cardW, cardH, cRad, new ColorRGBA(18.0F, 22.0F, 32.0F, 215.0F));
        custom.drawRoundedBorder(cardX, cardY, cardW, cardH, 1.2F, cRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F));

        // Header
        float hY = cardY + 12.0F;
        if (boldFont != null) {
            custom.drawText(boldFont, "✦ Настройки Control Center (iOS)", cardX + 18.0F, hY + 1.0F, ColorRGBA.WHITE);
        }

        // Circular Close Button [✕]
        float closeSz = 22.0F;
        float closeX = cardX + cardW - closeSz - 14.0F;
        float closeY = hY - 1.0F;
        boolean closeHov = (custom.I_method_b1c3e152() >= closeX && custom.I_method_b1c3e152() <= closeX + closeSz && custom.i_method_b1d26d32() >= closeY && custom.i_method_b1d26d32() <= closeY + closeSz);
        IIiii_Class8 closeRad = IIiii_Class8.I_method_893b2757(closeSz / 2.0F);
        custom.drawRoundedRect(closeX, closeY, closeSz, closeSz, closeRad, closeHov ? new ColorRGBA(239.0F, 68.0F, 68.0F, 240.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 30.0F));
        custom.drawRoundedBorder(closeX, closeY, closeSz, closeSz, 1.0F, closeRad, closeHov ? new ColorRGBA(255.0F, 255.0F, 255.0F, 150.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 45.0F));
        if (font != null) {
            float xW = font.I_method_2c375926("✕");
            custom.drawText(font, "✕", closeX + (closeSz - xW) / 2.0F, closeY + 5.5F, ColorRGBA.WHITE);
        }

        // Divider
        float divY = cardY + 36.0F;
        custom.drawRect(cardX + 16.0F, divY, cardW - 32.0F, 1.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));

        EscapeMenuConfig cfg = EscapeMenuConfig.getInstance();

        // Section 1: Toggle switches (2 compact columns)
        float itemY = divY + 8.0F;
        float colGap = 10.0F;
        float colW = (cardW - 32.0F - colGap) / 2.0F;
        float itemH = 25.0F;
        float rowGap = 5.0F;

        float c1X = cardX + 16.0F;
        float c2X = c1X + colW + colGap;

        // Col 1
        renderToggleItem(custom, c1X, itemY + 0 * (itemH + rowGap), colW, itemH, "🎵 Медиаплеер", cfg.showMediaPlayer, font);
        renderToggleItem(custom, c1X, itemY + 1 * (itemH + rowGap), colW, itemH, "🧮 Калькулятор", cfg.showCalculator, font);
        renderToggleItem(custom, c1X, itemY + 2 * (itemH + rowGap), colW, itemH, "🔊 Ползунок звука", cfg.showVolume, font);
        renderToggleItem(custom, c1X, itemY + 3 * (itemH + rowGap), colW, itemH, "📸 Быстрые плитки", cfg.showCamera, font);

        // Col 2
        renderToggleItem(custom, c2X, itemY + 0 * (itemH + rowGap), colW, itemH, "🌦️ Погода и БПЛА", cfg.showWeatherAlerts, font);
        renderToggleItem(custom, c2X, itemY + 1 * (itemH + rowGap), colW, itemH, "✦ Agravity AI", cfg.showAIChat, font);
        renderToggleItem(custom, c2X, itemY + 2 * (itemH + rowGap), colW, itemH, "📝 Заметки", cfg.showNotes, font);
        renderToggleItem(custom, c2X, itemY + 3 * (itemH + rowGap), colW, itemH, "🎮 Мини-игры", cfg.showGames, font);

        // Section 2 Divider: Weather City Selection (Prominent and Clear!)
        float citySecY = itemY + 4 * (itemH + rowGap) + 8.0F;
        custom.drawRect(cardX + 16.0F, citySecY, cardW - 32.0F, 1.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));

        citySecY += 6.0F;
        if (font != null) {
            custom.drawText(font, "📍 Город погоды (выберите город):", cardX + 18.0F, citySecY + 2.0F, new ColorRGBA(200.0F, 220.0F, 255.0F, 240.0F));
        }

        // Render City Pills (Row 1: 5 cities, Row 2: 4 cities)
        float cityGridY = citySecY + 18.0F;
        float cityPillH = 22.0F;
        float curCityX = cardX + 16.0F;
        String curCity = (cfg.weatherCity != null) ? cfg.weatherCity : "Киев";

        for (int i = 0; i < WEATHER_CITIES.length; i++) {
            String city = WEATHER_CITIES[i];
            boolean isSel = city.equalsIgnoreCase(curCity);

            float pillW = 48.0F;
            if (subFont != null) {
                pillW = subFont.I_method_2c375926(city) + 16.0F;
            }

            if (i == 5) {
                // New row
                cityGridY += cityPillH + 5.0F;
                curCityX = cardX + 16.0F;
            }

            boolean hov = (custom.I_method_b1c3e152() >= curCityX && custom.I_method_b1c3e152() <= curCityX + pillW &&
                           custom.i_method_b1d26d32() >= cityGridY && custom.i_method_b1d26d32() <= cityGridY + cityPillH);

            IIiii_Class8 pRad = IIiii_Class8.I_method_893b2757(cityPillH / 2.0F);

            ColorRGBA bg = isSel ? new ColorRGBA(0.0F, 122.0F, 255.0F, 225.0F) :
                                  (hov ? new ColorRGBA(255.0F, 255.0F, 255.0F, 28.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 10.0F));
            ColorRGBA border = isSel ? new ColorRGBA(255.0F, 255.0F, 255.0F, 140.0F) :
                                      (hov ? new ColorRGBA(255.0F, 255.0F, 255.0F, 70.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));

            custom.drawRoundedRect(curCityX, cityGridY, pillW, cityPillH, pRad, bg);
            custom.drawRoundedBorder(curCityX, cityGridY, pillW, cityPillH, 1.0F, pRad, border);

            if (subFont != null) {
                float tw = subFont.I_method_2c375926(city);
                custom.drawText(subFont, city, curCityX + (pillW - tw) / 2.0F, cityGridY + 6.5F, isSel ? ColorRGBA.WHITE : (hov ? ColorRGBA.WHITE : new ColorRGBA(210.0F, 220.0F, 235.0F, 210.0F)));
            }

            curCityX += pillW + 6.0F;
        }

        // Section 3: Drone Danger Scope Selector
        float scopeSecY = cityGridY + cityPillH + 10.0F;
        custom.drawRect(cardX + 16.0F, scopeSecY, cardW - 32.0F, 1.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));

        scopeSecY += 6.0F;
        if (font != null) {
            custom.drawText(font, "🛡️ Фильтр тревог БПЛА:", cardX + 18.0F, scopeSecY + 5.0F, new ColorRGBA(200.0F, 220.0F, 255.0F, 240.0F));
        }

        float scX = cardX + 195.0F;
        for (String sc : ALERT_SCOPES) {
            boolean isSel = sc.equalsIgnoreCase(cfg.alertScope);
            float btnW = 72.0F;
            float btnH = 22.0F;
            boolean hov = (custom.I_method_b1c3e152() >= scX && custom.I_method_b1c3e152() <= scX + btnW &&
                           custom.i_method_b1d26d32() >= scopeSecY + 1.0F && custom.i_method_b1d26d32() <= scopeSecY + 1.0F + btnH);

            IIiii_Class8 sRad = IIiii_Class8.I_method_893b2757(btnH / 2.0F);
            ColorRGBA bg = isSel ? new ColorRGBA(16.0F, 185.0F, 129.0F, 220.0F) :
                                  (hov ? new ColorRGBA(255.0F, 255.0F, 255.0F, 28.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 10.0F));
            ColorRGBA border = isSel ? new ColorRGBA(255.0F, 255.0F, 255.0F, 140.0F) :
                                      (hov ? new ColorRGBA(255.0F, 255.0F, 255.0F, 70.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));

            custom.drawRoundedRect(scX, scopeSecY + 1.0F, btnW, btnH, sRad, bg);
            custom.drawRoundedBorder(scX, scopeSecY + 1.0F, btnW, btnH, 1.0F, sRad, border);

            if (subFont != null) {
                float tw = subFont.I_method_2c375926(sc);
                custom.drawText(subFont, sc, scX + (btnW - tw) / 2.0F, scopeSecY + 6.5F, ColorRGBA.WHITE);
            }
            scX += btnW + 6.0F;
        }
    }

    private void renderToggleItem(III custom, float x, float y, float w, float h, String title, boolean enabled, IIiIIi_Class10 font) {
        boolean hov = (custom.I_method_b1c3e152() >= x && custom.I_method_b1c3e152() <= x + w && custom.i_method_b1d26d32() >= y && custom.i_method_b1d26d32() <= y + h);
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(6.0F);
        custom.drawRoundedRect(x, y, w, h, rad, hov ? new ColorRGBA(255.0F, 255.0F, 255.0F, 14.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 5.0F));
        custom.drawRoundedBorder(x, y, w, h, 1.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, hov ? 35.0F : 18.0F));

        if (font != null) {
            custom.drawText(font, title, x + 8.0F, y + 7.0F, ColorRGBA.WHITE);
        }

        // iOS Toggle Switch Pill
        float pillW = 32.0F;
        float pillH = 16.0F;
        float pillX = x + w - pillW - 6.0F;
        float pillY = y + (h - pillH) / 2.0F;
        IIiii_Class8 pRad = IIiii_Class8.I_method_893b2757(pillH / 2.0F);

        ColorRGBA pBg = enabled ? new ColorRGBA(52.0F, 199.0F, 89.0F, 230.0F) : new ColorRGBA(75.0F, 85.0F, 99.0F, 180.0F);
        custom.drawRoundedRect(pillX, pillY, pillW, pillH, pRad, pBg);

        float knobSz = 12.0F;
        float knobX = enabled ? (pillX + pillW - knobSz - 2.0F) : (pillX + 2.0F);
        float knobY = pillY + 2.0F;
        custom.drawRoundedRect(knobX, knobY, knobSz, knobSz, IIiii_Class8.I_method_893b2757(knobSz / 2.0F), ColorRGBA.WHITE);
    }

    @Override
    public void onMouseClicked(double mouseX, double mouseY, IiIII_Class9 button) {
        if (button != IiIII_Class9.I_field_2f4c8d6c) return;

        float cx = this.width / 2.0F;
        float cy = this.height / 2.0F;
        float cardW = Math.min(490.0F, this.width - 30.0F);
        float cardH = Math.min(390.0F, this.height - 30.0F);
        float cardX = cx - cardW / 2.0F;
        float cardY = cy - cardH / 2.0F;
        float hY = cardY + 12.0F;

        // Close Button
        float closeSz = 22.0F;
        float closeX = cardX + cardW - closeSz - 14.0F;
        float closeY = hY - 1.0F;
        if (mouseX >= closeX && mouseX <= closeX + closeSz && mouseY >= closeY && mouseY <= closeY + closeSz) {
            EscapeMenuConfig.getInstance().save();
            UISoundManager.playButtonClick();
            this.close();
            return;
        }

        EscapeMenuConfig cfg = EscapeMenuConfig.getInstance();
        float divY = cardY + 36.0F;
        float itemY = divY + 8.0F;
        float colGap = 10.0F;
        float colW = (cardW - 32.0F - colGap) / 2.0F;
        float itemH = 25.0F;
        float rowGap = 5.0F;

        float c1X = cardX + 16.0F;
        float c2X = c1X + colW + colGap;

        // Col 1 toggles
        if (mouseX >= c1X && mouseX <= c1X + colW) {
            for (int r = 0; r < 4; r++) {
                float rY = itemY + r * (itemH + rowGap);
                if (mouseY >= rY && mouseY <= rY + itemH) {
                    if (r == 0) cfg.showMediaPlayer = !cfg.showMediaPlayer;
                    else if (r == 1) cfg.showCalculator = !cfg.showCalculator;
                    else if (r == 2) cfg.showVolume = !cfg.showVolume;
                    else if (r == 3) {
                        cfg.showCamera = !cfg.showCamera;
                        cfg.showFullscreen = cfg.showCamera;
                    }
                    cfg.save();
                    UISoundManager.playButtonClick();
                    return;
                }
            }
        }

        // Col 2 toggles
        if (mouseX >= c2X && mouseX <= c2X + colW) {
            for (int r = 0; r < 4; r++) {
                float rY = itemY + r * (itemH + rowGap);
                if (mouseY >= rY && mouseY <= rY + itemH) {
                    if (r == 0) cfg.showWeatherAlerts = !cfg.showWeatherAlerts;
                    else if (r == 1) cfg.showAIChat = !cfg.showAIChat;
                    else if (r == 2) cfg.showNotes = !cfg.showNotes;
                    else if (r == 3) cfg.showGames = !cfg.showGames;
                    cfg.save();
                    UISoundManager.playButtonClick();
                    return;
                }
            }
        }

        // Weather City Selection Clicks
        float citySecY = itemY + 4 * (itemH + rowGap) + 14.0F;
        float cityGridY = citySecY + 18.0F;
        float cityPillH = 22.0F;
        float curCityX = cardX + 16.0F;

        IIiIIi_Class10 subFont = null;
        try {
            if (IIiIiI_Class11.II_field_857c0621 != null) {
                subFont = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F);
            }
        } catch (Throwable ignored) {}

        for (int i = 0; i < WEATHER_CITIES.length; i++) {
            String city = WEATHER_CITIES[i];
            float pillW = 48.0F;
            if (subFont != null) {
                pillW = subFont.I_method_2c375926(city) + 16.0F;
            }

            if (i == 5) {
                cityGridY += cityPillH + 5.0F;
                curCityX = cardX + 16.0F;
            }

            if (mouseX >= curCityX && mouseX <= curCityX + pillW && mouseY >= cityGridY && mouseY <= cityGridY + cityPillH) {
                cfg.weatherCity = city;
                cfg.save();
                WeatherAlertModule wMod = RockstarClient.getInstance().getModuleManager().getModule(WeatherAlertModule.class);
                if (wMod != null) {
                    wMod.setCity(city);
                }
                UISoundManager.playButtonClick();
                return;
            }

            curCityX += pillW + 6.0F;
        }

        // Drone Danger Scope Selection Clicks
        float scopeSecY = cityGridY + cityPillH + 16.0F;
        float scX = cardX + 195.0F;
        for (String sc : ALERT_SCOPES) {
            float btnW = 72.0F;
            float btnH = 22.0F;
            if (mouseX >= scX && mouseX <= scX + btnW && mouseY >= scopeSecY + 1.0F && mouseY <= scopeSecY + 1.0F + btnH) {
                cfg.alertScope = sc;
                cfg.save();
                UISoundManager.playButtonClick();
                return;
            }
            scX += btnW + 6.0F;
        }
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            EscapeMenuConfig.getInstance().save();
            this.close();
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public void close() {
        EscapeMenuConfig.getInstance().save();
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc != null) {
            mc.setScreen(this.parentScreen);
        }
    }
}
