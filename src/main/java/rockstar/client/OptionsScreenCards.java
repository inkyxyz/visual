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

    public static void renderCards(CustomDrawContext custom, int screenWidth, int screenHeight, int mx, int my) {
        if (!hasLayout) return;

        ColorRGBA theme = ThemeAndBackgroundManager.getInstance().getThemeColor();
        ColorRGBA themeSec = ThemeAndBackgroundManager.getInstance().getThemeSecondaryColor();
        IIiIIi_Class10 font = IIiIiI_Class11.II_field_857c0621 != null ? IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.2F) : null;

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
}
