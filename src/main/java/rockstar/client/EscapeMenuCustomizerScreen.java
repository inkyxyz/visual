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

    public static final ColorRGBA[] THEME_PRESETS = {
        new ColorRGBA(99.0F, 102.0F, 241.0F),  // Indigo (Agravity)
        new ColorRGBA(0.0F, 122.0F, 255.0F),   // Apple Blue
        new ColorRGBA(16.0F, 185.0F, 129.0F),  // Emerald
        new ColorRGBA(244.0F, 63.0F, 94.0F),   // Coral Rose
        new ColorRGBA(168.0F, 85.0F, 247.0F),  // Electric Purple
        new ColorRGBA(245.0F, 158.0F, 11.0F),  // Sunset Amber
        new ColorRGBA(6.0F, 182.0F, 212.0F),   // Cyan Sky
        new ColorRGBA(248.0F, 250.0F, 252.0F)  // Pure Ice White
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
        custom.drawRect(0.0F, 0.0F, (float)this.width, (float)this.height, new ColorRGBA(6.0F, 8.0F, 16.0F, 140.0F));

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

        ColorRGBA activeTheme = IiiiiIIIi_Class242.I_method_7df8e08e();

        // Main Frosted Glass Dialog Card
        float cardW = Math.min(500.0F, this.width - 24.0F);
        float cardH = Math.min(420.0F, this.height - 24.0F);
        float cardX = cx - cardW / 2.0F;
        float cardY = cy - cardH / 2.0F;
        IIiii_Class8 cRad = IIiii_Class8.I_method_893b2757(14.0F);

        custom.drawShadow(cardX, cardY, cardW, cardH, 24.0F, cRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 55.0F));
        custom.drawBlurredRect(cardX, cardY, cardW, cardH, 20.0F, 3.5F, cRad, activeTheme.withAlpha(12.0F));
        custom.drawRoundedRect(cardX, cardY, cardW, cardH, cRad, new ColorRGBA(16.0F, 20.0F, 30.0F, 125.0F));
        custom.drawRoundedBorder(cardX, cardY, cardW, cardH, 0.5F, cRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F));

        // Header Title
        float hY = cardY + 12.0F;
        if (boldFont != null) {
            custom.drawText(boldFont, "✦ Настройки Control Center (iOS)", cardX + 18.0F, hY + 1.0F, ColorRGBA.WHITE);
        }

        // Circular Close Button [xmark]
        float closeSz = 22.0F;
        float closeX = cardX + cardW - closeSz - 14.0F;
        float closeY = hY - 1.0F;
        boolean closeHov = (custom.I_method_b1c3e152() >= closeX && custom.I_method_b1c3e152() <= closeX + closeSz && custom.i_method_b1d26d32() >= closeY && custom.i_method_b1d26d32() <= closeY + closeSz);
        IIiii_Class8 closeRad = IIiii_Class8.I_method_893b2757(closeSz / 2.0F);
        custom.drawRoundedRect(closeX, closeY, closeSz, closeSz, closeRad, closeHov ? new ColorRGBA(239.0F, 68.0F, 68.0F, 200.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F));
        custom.drawRoundedBorder(closeX, closeY, closeSz, closeSz, 0.5F, closeRad, new ColorRGBA(255.0F, 255.0F, 255.0F, closeHov ? 100.0F : 20.0F));
        custom.drawIcon("xmark", closeX + (closeSz - 10.0F) / 2.0F, closeY + (closeSz - 10.0F) / 2.0F, 10.0F, ColorRGBA.WHITE);

        // Divider 1
        float divY = cardY + 36.0F;
        custom.drawRect(cardX + 16.0F, divY, cardW - 32.0F, 1.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 14.0F));

        // Section 0: Theme Color Palette Picker
        float themeSecY = divY + 8.0F;
        if (subFont != null) {
            custom.drawText(subFont, "Тема оформления (акцент):", cardX + 18.0F, themeSecY + 4.0F, new ColorRGBA(210.0F, 225.0F, 250.0F, 220.0F));
        }

        float pCircleSz = 18.0F;
        float pStartX = cardX + cardW - (THEME_PRESETS.length * (pCircleSz + 6.0F)) - 10.0F;
        for (int i = 0; i < THEME_PRESETS.length; i++) {
            ColorRGBA pc = THEME_PRESETS[i];
            float px = pStartX + i * (pCircleSz + 6.0F);
            boolean isCur = Math.abs(pc.getRed() - activeTheme.getRed()) < 5.0F &&
                            Math.abs(pc.getGreen() - activeTheme.getGreen()) < 5.0F &&
                            Math.abs(pc.getBlue() - activeTheme.getBlue()) < 5.0F;
            boolean pHov = (custom.I_method_b1c3e152() >= px && custom.I_method_b1c3e152() <= px + pCircleSz &&
                            custom.i_method_b1d26d32() >= themeSecY && custom.i_method_b1d26d32() <= themeSecY + pCircleSz);

            IIiii_Class8 cirRad = IIiii_Class8.I_method_893b2757(pCircleSz / 2.0F);
            custom.drawRoundedRect(px, themeSecY, pCircleSz, pCircleSz, cirRad, pc);
            if (isCur) {
                custom.drawRoundedBorder(px - 2.0F, themeSecY - 2.0F, pCircleSz + 4.0F, pCircleSz + 4.0F, 1.0F, IIiii_Class8.I_method_893b2757((pCircleSz + 4.0F) / 2.0F), ColorRGBA.WHITE);
            } else if (pHov) {
                custom.drawRoundedBorder(px - 1.0F, themeSecY - 1.0F, pCircleSz + 2.0F, pCircleSz + 2.0F, 0.5F, IIiii_Class8.I_method_893b2757((pCircleSz + 2.0F) / 2.0F), ColorRGBA.WHITE.withAlpha(160.0F));
            }
        }

        // Divider 2
        float divY2 = themeSecY + pCircleSz + 8.0F;
        custom.drawRect(cardX + 16.0F, divY2, cardW - 32.0F, 1.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 14.0F));

        EscapeMenuConfig cfg = EscapeMenuConfig.getInstance();

        // Section 1: Toggle switches (2 compact columns, 5 rows)
        float itemY = divY2 + 8.0F;
        float colGap = 10.0F;
        float colW = (cardW - 32.0F - colGap) / 2.0F;
        float itemH = 24.0F;
        float rowGap = 5.0F;

        float c1X = cardX + 16.0F;
        float c2X = c1X + colW + colGap;

        // Col 1
        renderToggleItem(custom, c1X, itemY + 0 * (itemH + rowGap), colW, itemH, "Медиаплеер", cfg.showMediaPlayer, font, activeTheme);
        renderToggleItem(custom, c1X, itemY + 1 * (itemH + rowGap), colW, itemH, "Калькулятор", cfg.showCalculator, font, activeTheme);
        renderToggleItem(custom, c1X, itemY + 2 * (itemH + rowGap), colW, itemH, "Ползунок звука", cfg.showVolume, font, activeTheme);
        renderToggleItem(custom, c1X, itemY + 3 * (itemH + rowGap), colW, itemH, "Быстрые плитки", cfg.showCamera, font, activeTheme);
        renderToggleItem(custom, c1X, itemY + 4 * (itemH + rowGap), colW, itemH, "Свободная RAM", cfg.showRamUsage, font, activeTheme);

        // Col 2
        renderToggleItem(custom, c2X, itemY + 0 * (itemH + rowGap), colW, itemH, "Погода и БПЛА", cfg.showWeatherAlerts, font, activeTheme);
        renderToggleItem(custom, c2X, itemY + 1 * (itemH + rowGap), colW, itemH, "Agravity AI", cfg.showAIChat, font, activeTheme);
        renderToggleItem(custom, c2X, itemY + 2 * (itemH + rowGap), colW, itemH, "Заметки", cfg.showNotes, font, activeTheme);
        renderToggleItem(custom, c2X, itemY + 3 * (itemH + rowGap), colW, itemH, "Мини-игры", cfg.showGames, font, activeTheme);
        renderToggleItem(custom, c2X, itemY + 4 * (itemH + rowGap), colW, itemH, "Затемнение фона", cfg.dimBackground, font, activeTheme);

        // Section 2 Divider: Weather City Selection
        float citySecY = itemY + 5 * (itemH + rowGap) + 8.0F;
        custom.drawRect(cardX + 16.0F, citySecY, cardW - 32.0F, 1.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 14.0F));

        citySecY += 6.0F;
        if (subFont != null) {
            custom.drawText(subFont, "Город погоды (выберите город):", cardX + 18.0F, citySecY + 2.0F, new ColorRGBA(200.0F, 220.0F, 255.0F, 220.0F));
        }

        // Render City Pills (Row 1: 5 cities, Row 2: 4 cities)
        float cityGridY = citySecY + 16.0F;
        float cityPillH = 20.0F;
        float curCityX = cardX + 16.0F;
        String curCity = (cfg.weatherCity != null) ? cfg.weatherCity : "Киев";

        for (int i = 0; i < WEATHER_CITIES.length; i++) {
            String city = WEATHER_CITIES[i];
            boolean isSel = city.equalsIgnoreCase(curCity);

            float pillW = 48.0F;
            if (tinyFont != null) {
                pillW = tinyFont.I_method_2c375926(city) + 16.0F;
            }

            if (i == 5) {
                cityGridY += cityPillH + 5.0F;
                curCityX = cardX + 16.0F;
            }

            boolean hov = (custom.I_method_b1c3e152() >= curCityX && custom.I_method_b1c3e152() <= curCityX + pillW &&
                           custom.i_method_b1d26d32() >= cityGridY && custom.i_method_b1d26d32() <= cityGridY + cityPillH);

            IIiii_Class8 pRad = IIiii_Class8.I_method_893b2757(cityPillH / 2.0F);

            ColorRGBA bg = isSel ? activeTheme.withAlpha(200.0F) :
                                  (hov ? new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 10.0F));

            custom.drawRoundedRect(curCityX, cityGridY, pillW, cityPillH, pRad, bg);
            custom.drawRoundedBorder(curCityX, cityGridY, pillW, cityPillH, 0.5F, pRad, isSel ? ColorRGBA.WHITE.withAlpha(120.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 15.0F));

            if (tinyFont != null) {
                float tw = tinyFont.I_method_2c375926(city);
                custom.drawText(tinyFont, city, curCityX + (pillW - tw) / 2.0F, cityGridY + 6.0F, isSel ? ColorRGBA.WHITE : (hov ? ColorRGBA.WHITE : new ColorRGBA(210.0F, 220.0F, 235.0F, 200.0F)));
            }

            curCityX += pillW + 6.0F;
        }

        // Section 3: Drone Danger Scope Selector
        float scopeSecY = cityGridY + cityPillH + 8.0F;
        custom.drawRect(cardX + 16.0F, scopeSecY, cardW - 32.0F, 1.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 14.0F));

        scopeSecY += 6.0F;
        if (subFont != null) {
            custom.drawText(subFont, "Фильтр тревог БПЛА:", cardX + 18.0F, scopeSecY + 4.0F, new ColorRGBA(200.0F, 220.0F, 255.0F, 220.0F));
        }

        float scX = cardX + 165.0F;
        for (String sc : ALERT_SCOPES) {
            boolean isSel = sc.equalsIgnoreCase(cfg.alertScope);
            float btnW = 68.0F;
            float btnH = 20.0F;
            boolean hov = (custom.I_method_b1c3e152() >= scX && custom.I_method_b1c3e152() <= scX + btnW &&
                           custom.i_method_b1d26d32() >= scopeSecY + 1.0F && custom.i_method_b1d26d32() <= scopeSecY + 1.0F + btnH);

            IIiii_Class8 sRad = IIiii_Class8.I_method_893b2757(btnH / 2.0F);
            ColorRGBA bg = isSel ? activeTheme.withAlpha(200.0F) :
                                  (hov ? new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 10.0F));

            custom.drawRoundedRect(scX, scopeSecY + 1.0F, btnW, btnH, sRad, bg);
            custom.drawRoundedBorder(scX, scopeSecY + 1.0F, btnW, btnH, 0.5F, sRad, isSel ? ColorRGBA.WHITE.withAlpha(120.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 15.0F));

            if (tinyFont != null) {
                float tw = tinyFont.I_method_2c375926(sc);
                custom.drawText(tinyFont, sc, scX + (btnW - tw) / 2.0F, scopeSecY + 6.0F, ColorRGBA.WHITE);
            }
            scX += btnW + 6.0F;
        }
    }

    private void renderToggleItem(III custom, float x, float y, float w, float h, String title, boolean enabled, IIiIIi_Class10 font, ColorRGBA theme) {
        boolean hov = (custom.I_method_b1c3e152() >= x && custom.I_method_b1c3e152() <= x + w && custom.i_method_b1d26d32() >= y && custom.i_method_b1d26d32() <= y + h);
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(6.0F);
        custom.drawRoundedRect(x, y, w, h, rad, hov ? new ColorRGBA(255.0F, 255.0F, 255.0F, 14.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 5.0F));
        custom.drawRoundedBorder(x, y, w, h, 0.5F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, hov ? 30.0F : 14.0F));

        if (font != null) {
            custom.drawText(font, title, x + 8.0F, y + 6.5F, ColorRGBA.WHITE);
        }

        // iOS Toggle Switch Pill
        float pillW = 30.0F;
        float pillH = 15.0F;
        float pillX = x + w - pillW - 6.0F;
        float pillY = y + (h - pillH) / 2.0F;
        IIiii_Class8 pRad = IIiii_Class8.I_method_893b2757(pillH / 2.0F);

        ColorRGBA pBg = enabled ? theme.withAlpha(220.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 22.0F);
        custom.drawRoundedRect(pillX, pillY, pillW, pillH, pRad, pBg);
        custom.drawRoundedBorder(pillX, pillY, pillW, pillH, 0.5F, pRad, enabled ? theme.withAlpha(150.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F));

        float knobSz = 11.0F;
        float knobX = enabled ? (pillX + pillW - knobSz - 2.0F) : (pillX + 2.0F);
        float knobY = pillY + 2.0F;
        custom.drawRoundedRect(knobX, knobY, knobSz, knobSz, IIiii_Class8.I_method_893b2757(knobSz / 2.0F), ColorRGBA.WHITE);
    }

    @Override
    public void onMouseClicked(double mouseX, double mouseY, IiIII_Class9 button) {
        if (button != IiIII_Class9.I_field_2f4c8d6c) return;

        float cx = this.width / 2.0F;
        float cy = this.height / 2.0F;
        float cardW = Math.min(500.0F, this.width - 24.0F);
        float cardH = Math.min(420.0F, this.height - 24.0F);
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

        // Theme Palette Selector Clicks
        float divY = cardY + 36.0F;
        float themeSecY = divY + 8.0F;
        float pCircleSz = 18.0F;
        float pStartX = cardX + cardW - (THEME_PRESETS.length * (pCircleSz + 6.0F)) - 10.0F;
        for (int i = 0; i < THEME_PRESETS.length; i++) {
            float px = pStartX + i * (pCircleSz + 6.0F);
            if (mouseX >= px && mouseX <= px + pCircleSz && mouseY >= themeSecY && mouseY <= themeSecY + pCircleSz) {
                IiiiiIIIi_Class242.I_method_300b2840(THEME_PRESETS[i]);
                UISoundManager.playButtonClick();
                return;
            }
        }

        EscapeMenuConfig cfg = EscapeMenuConfig.getInstance();
        float divY2 = themeSecY + pCircleSz + 8.0F;
        float itemY = divY2 + 8.0F;
        float colGap = 10.0F;
        float colW = (cardW - 32.0F - colGap) / 2.0F;
        float itemH = 24.0F;
        float rowGap = 5.0F;

        float c1X = cardX + 16.0F;
        float c2X = c1X + colW + colGap;

        // Col 1 toggles (5 items)
        if (mouseX >= c1X && mouseX <= c1X + colW) {
            for (int r = 0; r < 5; r++) {
                float rY = itemY + r * (itemH + rowGap);
                if (mouseY >= rY && mouseY <= rY + itemH) {
                    if (r == 0) cfg.showMediaPlayer = !cfg.showMediaPlayer;
                    else if (r == 1) cfg.showCalculator = !cfg.showCalculator;
                    else if (r == 2) cfg.showVolume = !cfg.showVolume;
                    else if (r == 3) {
                        cfg.showCamera = !cfg.showCamera;
                        cfg.showFullscreen = cfg.showCamera;
                    } else if (r == 4) {
                        cfg.showRamUsage = !cfg.showRamUsage;
                    }
                    cfg.save();
                    UISoundManager.playButtonClick();
                    return;
                }
            }
        }

        // Col 2 toggles (5 items)
        if (mouseX >= c2X && mouseX <= c2X + colW) {
            for (int r = 0; r < 5; r++) {
                float rY = itemY + r * (itemH + rowGap);
                if (mouseY >= rY && mouseY <= rY + itemH) {
                    if (r == 0) cfg.showWeatherAlerts = !cfg.showWeatherAlerts;
                    else if (r == 1) cfg.showAIChat = !cfg.showAIChat;
                    else if (r == 2) cfg.showNotes = !cfg.showNotes;
                    else if (r == 3) cfg.showGames = !cfg.showGames;
                    else if (r == 4) cfg.dimBackground = !cfg.dimBackground;
                    cfg.save();
                    UISoundManager.playButtonClick();
                    return;
                }
            }
        }

        // Weather City Selection Clicks
        float citySecY = itemY + 5 * (itemH + rowGap) + 8.0F;
        float cityGridY = citySecY + 16.0F;
        float cityPillH = 20.0F;
        float curCityX = cardX + 16.0F;

        IIiIIi_Class10 tinyFont = null;
        try {
            if (IIiIiI_Class11.II_field_857c0621 != null) {
                tinyFont = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F);
            }
        } catch (Throwable ignored) {}

        for (int i = 0; i < WEATHER_CITIES.length; i++) {
            String city = WEATHER_CITIES[i];
            float pillW = 48.0F;
            if (tinyFont != null) {
                pillW = tinyFont.I_method_2c375926(city) + 16.0F;
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
        float scopeSecY = cityGridY + cityPillH + 8.0F;
        float scX = cardX + 165.0F;
        for (String sc : ALERT_SCOPES) {
            float btnW = 68.0F;
            float btnH = 20.0F;
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
