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

    public static void renderCards(CustomDrawContext custom) {
        if (!hasLayout) return;

        IIiii_Class8 cardRad = IIiii_Class8.I_method_893b2757(12.0F);
        ColorRGBA cardBg = new ColorRGBA(16.0F, 20.0F, 30.0F, 120.0F);
        ColorRGBA cardBorder = new ColorRGBA(255.0F, 255.0F, 255.0F, 22.0F);

        float padX = 8.0F;
        float padY = 22.0F;
        float botPad = 8.0F;

        // Left iOS Card Container ("НАСТРОЙКИ ИГРЫ")
        if (cardLeftH > 0) {
            float cx = cardLeftX - padX;
            float cy = cardTopY - padY;
            float cw = cardW + padX * 2;
            float ch = cardLeftH + padY + botPad;
            custom.drawRoundedRect(cx, cy, cw, ch, cardRad, cardBg);
            custom.drawRoundedBorder(cx, cy, cw, ch, 1.0F, cardRad, cardBorder);
        }

        // Right iOS Card Container ("ОСНОВНЫЕ НАСТРОЙКИ")
        if (cardRightH > 0) {
            float cx = cardRightX - padX;
            float cy = cardTopY - padY;
            float cw = cardW + padX * 2;
            float ch = cardRightH + padY + botPad;
            custom.drawRoundedRect(cx, cy, cw, ch, cardRad, cardBg);
            custom.drawRoundedBorder(cx, cy, cw, ch, 1.0F, cardRad, cardBorder);
        }
    }
}
