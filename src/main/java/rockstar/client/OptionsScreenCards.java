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

        // Section Headers
        IIiIIi_Class10 font = null;
        try {
            if (IIiIiI_Class11.i_field_857c0621 != null) {
                font = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.5F);
            }
        } catch (Throwable ignored) {}

        if (font != null) {
            ColorRGBA headerCol = new ColorRGBA(160.0F, 175.0F, 205.0F, 210.0F);
            if (cardLeftH > 0) {
                custom.drawText(font, "\u041d\u0410\u0421\u0422\u0420\u041e\u0419\u041a\u0418 \u0418\u0413\u0420\u042b", cardLeftX, cardTopY - 15.0F, headerCol);
            }
            if (cardRightH > 0) {
                custom.drawText(font, "\u041e\u0421\u041d\u041e\u0412\u041d\u042b\u0415 \u041d\u0410\u0421\u0422\u0420\u041e\u0419\u041a\u0418", cardRightX, cardTopY - 15.0F, headerCol);
            }
        }
    }
}
