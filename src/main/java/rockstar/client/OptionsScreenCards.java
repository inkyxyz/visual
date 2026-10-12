package rockstar.client;

import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;

public class OptionsScreenCards {
    public static float cardLeftX = 0;
    public static float cardRightX = 0;
    public static float cardTopY = 0;
    public static float cardW = 0;
    public static float cardLeftH = 0;
    public static float cardRightH = 0;
    public static boolean hasLayout = false;

    // Top Bar Layout Cache
    public static float topBarX = 0;
    public static float topBarY = 0;
    public static float topBarW = 0;
    public static float topBarH = 0;

    public static float pillThemeX = 0, pillThemeW = 0;
    public static float pillBgX = 0, pillBgW = 0;
    public static float pillIconX = 0, pillIconW = 0;

    public static void renderCards(CustomDrawContext custom, int screenWidth, int screenHeight, int mx, int my) {
        ColorRGBA theme = ThemeAndBackgroundManager.getInstance().getThemeColor();
        ColorRGBA themeSec = ThemeAndBackgroundManager.getInstance().getThemeSecondaryColor();

        // 1. Top iOS Control Capsule: [ 🎨 Тема ] | [ 🖼 Фон ] | [ 📱 Иконки ]
        topBarH = 26.0F;
        topBarW = Math.min(480.0F, screenWidth - 32.0F);
        topBarX = (screenWidth - topBarW) / 2.0F;
        topBarY = Math.max(6.0F, cardTopY - 32.0F);
        IIiii_Class8 barRad = IIiii_Class8.I_method_893b2757(topBarH / 2.0F);

        // Ambient glow & container
        custom.drawShadow(topBarX, topBarY, topBarW, topBarH, 12.0F, barRad, theme.withAlpha(45.0F));
        custom.drawRoundedRect(topBarX, topBarY, topBarW, topBarH, barRad, new ColorRGBA(16.0F, 20.0F, 32.0F, 210.0F));
        custom.drawRoundedBorder(topBarX, topBarY, topBarW, topBarH, 0.7F, barRad, theme.withAlpha(120.0F));

        IIiIIi_Class10 font = IIiIiI_Class11.II_field_857c0621 != null ? IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.2F) : null;

        // 3 Pills
        float gap = 6.0F;
        float pillW = (topBarW - 12.0F - gap * 2.0F) / 3.0F;
        float pillH = topBarH - 6.0F;
        float py = topBarY + 3.0F;
        IIiii_Class8 pRad = IIiii_Class8.I_method_893b2757(pillH / 2.0F);

        // Pill 1: Theme
        pillThemeX = topBarX + 6.0F;
        pillThemeW = pillW;
        boolean tHov = (mx >= pillThemeX && mx <= pillThemeX + pillThemeW && my >= py && my <= py + pillH);
        custom.drawRoundedRect(pillThemeX, py, pillThemeW, pillH, pRad, tHov ? theme.withAlpha(50.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 14.0F));
        custom.drawRoundedBorder(pillThemeX, py, pillThemeW, pillH, 0.6F, pRad, tHov ? theme : new ColorRGBA(255.0F, 255.0F, 255.0F, 22.0F));
        // Theme indicator dot
        custom.drawRoundedRect(pillThemeX + 7.0F, py + (pillH - 8.0F) / 2.0F, 8.0F, 8.0F, IIiii_Class8.I_method_893b2757(4.0F), theme);
        String themeText = "Тема: " + ThemeAndBackgroundManager.getInstance().getCurrentTheme().name();
        if (font != null) {
            custom.drawText(font, themeText, pillThemeX + 19.0F, py + (pillH - 7.2F) / 2.0F, tHov ? ColorRGBA.WHITE : new ColorRGBA(235.0F, 240.0F, 255.0F, 220.0F));
        }

        // Pill 2: Background / Wallpaper
        pillBgX = pillThemeX + pillThemeW + gap;
        pillBgW = pillW;
        boolean bgHov = (mx >= pillBgX && mx <= pillBgX + pillBgW && my >= py && my <= py + pillH);
        custom.drawRoundedRect(pillBgX, py, pillBgW, pillH, pRad, bgHov ? themeSec.withAlpha(50.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 14.0F));
        custom.drawRoundedBorder(pillBgX, py, pillBgW, pillH, 0.6F, pRad, bgHov ? themeSec : new ColorRGBA(255.0F, 255.0F, 255.0F, 22.0F));
        String bgName = ThemeAndBackgroundManager.getInstance().getCurrentBackgroundName();
        if (bgName.length() > 16) bgName = bgName.substring(0, 14) + "..";
        String bgText = "Фон: " + bgName;
        if (font != null) {
            float bw = font.I_method_2c375926(bgText);
            custom.drawText(font, bgText, pillBgX + (pillBgW - bw) / 2.0F, py + (pillH - 7.2F) / 2.0F, bgHov ? ColorRGBA.WHITE : new ColorRGBA(235.0F, 240.0F, 255.0F, 220.0F));
        }

        // Pill 3: iOS Icon Style
        pillIconX = pillBgX + pillBgW + gap;
        pillIconW = pillW;
        boolean icHov = (mx >= pillIconX && mx <= pillIconX + pillIconW && my >= py && my <= py + pillH);
        custom.drawRoundedRect(pillIconX, py, pillIconW, pillH, pRad, icHov ? theme.withAlpha(50.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 14.0F));
        custom.drawRoundedBorder(pillIconX, py, pillIconW, pillH, 0.6F, pRad, icHov ? theme : new ColorRGBA(255.0F, 255.0F, 255.0F, 22.0F));
        String icText = "Иконки: " + ThemeAndBackgroundManager.getInstance().getCurrentIconStyleName();
        if (font != null) {
            float iw = font.I_method_2c375926(icText);
            custom.drawText(font, icText, pillIconX + (pillIconW - iw) / 2.0F, py + (pillH - 7.2F) / 2.0F, icHov ? ColorRGBA.WHITE : new ColorRGBA(235.0F, 240.0F, 255.0F, 220.0F));
        }

        // 2. Settings Cards
        if (!hasLayout) return;

        IIiii_Class8 cardRad = IIiii_Class8.I_method_893b2757(14.0F);
        ColorRGBA cardBg = new ColorRGBA(16.0F, 20.0F, 30.0F, 130.0F);
        ColorRGBA cardBorder = theme.withAlpha(45.0F);

        float padX = 8.0F;
        float padY = 22.0F;
        float botPad = 8.0F;

        // Left iOS Card Container ("НАСТРОЙКИ ИГРЫ")
        if (cardLeftH > 0) {
            float cx = cardLeftX - padX;
            float cy = cardTopY - padY;
            float cw = cardW + padX * 2;
            float ch = cardLeftH + padY + botPad;
            custom.drawShadow(cx, cy, cw, ch, 14.0F, cardRad, theme.withAlpha(25.0F));
            custom.drawRoundedRect(cx, cy, cw, ch, cardRad, cardBg);
            custom.drawRoundedBorder(cx, cy, cw, ch, 0.8F, cardRad, cardBorder);

            // Card Header Label
            if (font != null) {
                custom.drawText(font, "НАСТРОЙКИ ИГРЫ", cx + 12.0F, cy + 7.0F, themeSec);
            }
        }

        // Right iOS Card Container ("ОСНОВНЫЕ НАСТРОЙКИ")
        if (cardRightH > 0) {
            float cx = cardRightX - padX;
            float cy = cardTopY - padY;
            float cw = cardW + padX * 2;
            float ch = cardRightH + padY + botPad;
            custom.drawShadow(cx, cy, cw, ch, 14.0F, cardRad, theme.withAlpha(25.0F));
            custom.drawRoundedRect(cx, cy, cw, ch, cardRad, cardBg);
            custom.drawRoundedBorder(cx, cy, cw, ch, 0.8F, cardRad, cardBorder);

            // Card Header Label
            if (font != null) {
                custom.drawText(font, "ОСНОВНЫЕ НАСТРОЙКИ", cx + 12.0F, cy + 7.0F, themeSec);
            }
        }
    }

    public static boolean handleTopBarClick(double mx, double my, int button) {
        float py = topBarY + 3.0F;
        float pillH = topBarH - 6.0F;

        if (my < py || my > py + pillH) return false;

        // 1. Theme Pill Click
        if (mx >= pillThemeX && mx <= pillThemeX + pillThemeW) {
            UISoundManager.playButtonClick();
            ThemeAndBackgroundManager.getInstance().nextTheme();
            return true;
        }

        // 2. Background Pill Click
        if (mx >= pillBgX && mx <= pillBgX + pillBgW) {
            UISoundManager.playButtonClick();
            ThemeAndBackgroundManager.getInstance().nextBackground();
            return true;
        }

        // 3. Icon Style Pill Click
        if (mx >= pillIconX && mx <= pillIconX + pillIconW) {
            UISoundManager.playButtonClick();
            ThemeAndBackgroundManager.getInstance().nextIconStyle();
            return true;
        }

        return false;
    }
}
