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
        ColorRGBA fontCol = new ColorRGBA(225.0F, 230.0F, 245.0F, 210.0F);
        IIiIIi_Class10 font = IIiIiI_Class11.II_field_857c0621 != null ? IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.2F) : null;

        IIiii_Class8 cardRad = IIiii_Class8.I_method_893b2757(14.0F);
        ColorRGBA cardBg = new ColorRGBA(16.0F, 20.0F, 30.0F, 140.0F);
        ColorRGBA cardBorder = new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F);

        float padX = 8.0F;
        float padY = 22.0F;
        float botPad = 8.0F;

        // Left iOS Card Container ("Game Settings")
        if (cardLeftH > 0) {
            float cx = cardLeftX - padX;
            float cy = cardTopY - padY;
            float cw = cardW + padX * 2;
            float ch = cardLeftH + padY + botPad;
            custom.drawShadow(cx, cy, cw, ch, 14.0F, cardRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 35.0F));
            custom.drawRoundedRect(cx, cy, cw, ch, cardRad, cardBg);
            custom.drawRoundedBorder(cx, cy, cw, ch, 0.7F, cardRad, cardBorder);
            custom.drawRoundedRect(cx + 12.0F, cy + 1.0F, cw - 24.0F, 1.0F, IIiii_Class8.I_method_893b2757(0.5F), new ColorRGBA(255.0F, 255.0F, 255.0F, 30.0F));

            // Card Header Label
            if (font != null) {
                custom.drawText(font, "Game Settings", cx + 12.0F, cy + 7.0F, fontCol);
            }
        }

        // Right iOS Card Container ("General Settings")
        if (cardRightH > 0) {
            float cx = cardRightX - padX;
            float cy = cardTopY - padY;
            float cw = cardW + padX * 2;
            float ch = cardRightH + padY + botPad;
            custom.drawShadow(cx, cy, cw, ch, 14.0F, cardRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 35.0F));
            custom.drawRoundedRect(cx, cy, cw, ch, cardRad, cardBg);
            custom.drawRoundedBorder(cx, cy, cw, ch, 0.7F, cardRad, cardBorder);
            custom.drawRoundedRect(cx + 12.0F, cy + 1.0F, cw - 24.0F, 1.0F, IIiii_Class8.I_method_893b2757(0.5F), new ColorRGBA(255.0F, 255.0F, 255.0F, 30.0F));

            // Card Header Label
            if (font != null) {
                custom.drawText(font, "General Settings", cx + 12.0F, cy + 7.0F, fontCol);
            }
        }

        // Top Title Pill: "Настройки"
        if (IIiIiI_Class11.II_field_857c0621 != null) {
            IIiIIi_Class10 titleFont = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(9.5F);
            String titleStr = "Настройки";
            float tw = titleFont.I_method_2c375926(titleStr);
            float tx = (screenWidth - tw) / 2.0F;
            float ty = 14.0F;
            custom.drawRoundedRect(tx - 14.0F, ty - 3.0F, tw + 28.0F, 18.0F, IIiii_Class8.I_method_893b2757(9.0F), new ColorRGBA(16.0F, 20.0F, 30.0F, 220.0F));
            custom.drawRoundedBorder(tx - 14.0F, ty - 3.0F, tw + 28.0F, 18.0F, 0.6F, IIiii_Class8.I_method_893b2757(9.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, 28.0F));
            custom.drawText(titleFont, titleStr, tx, ty + 2.5F, ColorRGBA.WHITE);
        }
    }
}
