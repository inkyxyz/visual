package globals.client.ui;

import globals.client.Cosmetics;
import globals.shared.proto.Packets;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.util.Identifier;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.IIIiIiIi_Class22;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IiIiiIIiI_Class179;

public final class CosmeticRender {
    private static final Pattern GRAPHEMES = Pattern.compile("\\X");
    private static final float SHIFT_MS = 3000.0f;
    private static final float SHIFT_SHINE_MS = 1500.0f;
    private static final float SHIFT_SHIMMER_MS = 2600.0f;
    private static final float PULSE_MIN = 1.0f;
    private static final float PULSE_MAX = 1.55f;
    private static final float SPAN = 0.5f;
    private static final float BADGE_GAP = 3.0f;
    private static final float FADE_START = 0.7f;

    private CosmeticRender() {
    }

    public static float width(IIiIIi_Class10 iIiIIi_Class10, String string, String string2, float f) {
        float f2 = CosmeticRender.textWidth(iIiIIi_Class10, string);
        if (Cosmetics.badge(string2) != null) {
            f2 += 3.0f + f;
        }
        return f2;
    }

    public static float draw(CustomDrawContext customDrawContext, IIiIIi_Class10 iIiIIi_Class10, String string, float f, float f2, String string2, String string3, ColorRGBA colorRGBA, float f3) {
        return CosmeticRender.draw(customDrawContext, iIiIIi_Class10, string, f, f2, string2, string3, colorRGBA, f3, 0.0f);
    }

    public static float draw(CustomDrawContext customDrawContext, IIiIIi_Class10 iIiIIi_Class10, String string, float f, float f2, String string2, String string3, ColorRGBA colorRGBA, float f3, float f4) {
        float f5;
        float f6;
        Identifier identifier = Cosmetics.badge(string3);
        float f7 = identifier != null ? 3.0f + f3 : 0.0f;
        float f8 = f4 > 0.0f ? Math.max(0.0f, f4 - f7) : 0.0f;
        Packets.Nested1_d6cfc997 nested1_d6cfc997 = Cosmetics.nick(string2);
        String string4 = IIIiIiIi_Class22.I_method_7f49082a(string);
        if (string4 != string) {
            f6 = Math.max(CosmeticRender.textWidth(iIiIIi_Class10, string), CosmeticRender.textWidth(iIiIIi_Class10, string4));
            int[] nArray = IIIiIiIi_Class22.I_method_a0f921e2(customDrawContext.getMatrices().peek().getPositionMatrix(), f - 1.0f, f2 - iIiIIi_Class10.iI_method_24b6c285() * 0.35f, f + f6 + 2.0f, f2 + iIiIIi_Class10.iI_method_24b6c285() * 1.45f);
            IIIiIiIi_Class22.I_method_3ee425f8(nArray, () -> IIIiIiIi_Class22.I_method_4d8e94ea(() -> CosmeticRender.drawName(customDrawContext, iIiIIi_Class10, string, f, f2, nested1_d6cfc997, colorRGBA, f8)));
            IIIiIiIi_Class22.I_method_4d8e94ea(() -> CosmeticRender.drawName(customDrawContext, iIiIIi_Class10, string4, f, f2, nested1_d6cfc997, colorRGBA, f8));
        } else {
            CosmeticRender.drawName(customDrawContext, iIiIIi_Class10, string, f, f2, nested1_d6cfc997, colorRGBA, f8);
        }
        f6 = CosmeticRender.textWidth(iIiIIi_Class10, string);
        float f9 = f5 = f8 > 0.0f ? Math.min(f6, f8) : f6;
        if (identifier != null) {
            float f10 = f2 + (iIiIIi_Class10.I_method_a649725c() - f3) / 2.0f;
            customDrawContext.drawTexture(identifier, f + f5 + 3.0f, f10, f3, f3, ColorRGBA.WHITE.withAlpha(colorRGBA.getAlpha()));
            return f5 + f7;
        }
        return f5;
    }

    private static void drawName(CustomDrawContext customDrawContext, IIiIIi_Class10 iIiIIi_Class10, String string, float f, float f2, Packets.Nested1_d6cfc997 nested1_d6cfc997, ColorRGBA colorRGBA, float f3) {
        if (IiIiiIIiI_Class179.I_method_bd85868d(string)) {
            CosmeticRender.drawEmojiName(customDrawContext, iIiIIi_Class10, string, f, f2, nested1_d6cfc997, colorRGBA, f3);
            return;
        }
        if (nested1_d6cfc997 == null) {
            if (f3 > 0.0f) {
                customDrawContext.drawFadeoutText(iIiIIi_Class10, string, f, f2, colorRGBA, 0.7f, 1.0f, f3);
            } else {
                customDrawContext.drawText(iIiIIi_Class10, string, f, f2, colorRGBA);
            }
            return;
        }
        CosmeticRender.drawGradient(customDrawContext, iIiIIi_Class10, string, f, f2, nested1_d6cfc997, colorRGBA.getAlpha(), f3);
    }

    private static void drawEmojiName(CustomDrawContext customDrawContext, IIiIIi_Class10 iIiIIi_Class10, String string, float f, float f2, Packets.Nested1_d6cfc997 nested1_d6cfc997, ColorRGBA colorRGBA, float f3) {
        float f4 = IiIiiIIiI_Class179.I_method_cc1ab81a(iIiIIi_Class10, string);
        if (f4 <= 0.0f) {
            return;
        }
        float f5 = nested1_d6cfc997 == null ? 0.0f : CosmeticRender.phase(nested1_d6cfc997.effect());
        float f6 = nested1_d6cfc997 != null && "shimmer".equals(nested1_d6cfc997.effect()) ? CosmeticRender.pulse() : 1.0f;
        Matcher matcher = GRAPHEMES.matcher(string);
        float f7 = 0.0f;
        while (matcher.find()) {
            ColorRGBA colorRGBA2;
            String string2 = matcher.group();
            if (f3 > 0.0f && f7 >= f3) break;
            float f8 = IiIiiIIiI_Class179.I_method_cc1ab81a(iIiIIi_Class10, string2);
            ColorRGBA colorRGBA3 = colorRGBA2 = nested1_d6cfc997 == null ? colorRGBA.withAlpha(colorRGBA.getAlpha() * CosmeticRender.fade(f7, f3)) : CosmeticRender.colorAt(nested1_d6cfc997.stops(), CosmeticRender.frac((f7 + f8 / 2.0f) / f4 * 0.5f + f5)).withAlpha(colorRGBA.getAlpha() * CosmeticRender.fade(f7, f3));
            if (f6 != 1.0f) {
                colorRGBA2 = CosmeticRender.brighten(colorRGBA2, f6);
            }
            IiIiiIIiI_Class179.I_method_d5fb8067(customDrawContext, iIiIIi_Class10, string2, f + f7, f2, iIiIIi_Class10.I_method_a649725c(), colorRGBA2);
            f7 += f8;
        }
    }

    private static void drawGradient(CustomDrawContext customDrawContext, IIiIIi_Class10 iIiIIi_Class10, String string, float f, float f2, Packets.Nested1_d6cfc997 nested1_d6cfc997, float f3, float f4) {
        float f5 = iIiIIi_Class10.I_method_2c375926(string);
        if (f5 <= 0.0f) {
            return;
        }
        float f6 = CosmeticRender.phase(nested1_d6cfc997.effect());
        float f7 = "shimmer".equals(nested1_d6cfc997.effect()) ? CosmeticRender.pulse() : 1.0f;
        for (int i = 0; i < string.length(); ++i) {
            String string2 = String.valueOf(string.charAt(i));
            float f8 = iIiIIi_Class10.I_method_2c375926(string.substring(0, i));
            if (f4 > 0.0f && f8 >= f4) break;
            float f9 = (f8 + iIiIIi_Class10.I_method_2c375926(string2) / 2.0f) / f5;
            ColorRGBA colorRGBA = CosmeticRender.colorAt(nested1_d6cfc997.stops(), CosmeticRender.frac(f9 * 0.5f + f6)).withAlpha(f3 * CosmeticRender.fade(f8, f4));
            if (f7 != 1.0f) {
                colorRGBA = CosmeticRender.brighten(colorRGBA, f7);
            }
            customDrawContext.drawText(iIiIIi_Class10, string2, f + f8, f2, colorRGBA);
        }
    }

    private static float textWidth(IIiIIi_Class10 iIiIIi_Class10, String string) {
        return IiIiiIIiI_Class179.I_method_bd85868d(string) ? IiIiiIIiI_Class179.I_method_cc1ab81a(iIiIIi_Class10, string) : iIiIIi_Class10.I_method_2c375926(string);
    }

    private static float fade(float f, float f2) {
        if (f2 <= 0.0f) {
            return 1.0f;
        }
        float f3 = f / f2;
        if (f3 <= 0.7f) {
            return 1.0f;
        }
        return Math.max(0.0f, 1.0f - (f3 - 0.7f) / 0.3f);
    }

    private static ColorRGBA colorAt(List<Packets.Nested1_bdbb1f3d> list, float f) {
        Packets.Nested1_bdbb1f3d nested1_bdbb1f3d = list.get(0);
        Packets.Nested1_bdbb1f3d nested1_bdbb1f3d2 = list.get(list.size() - 1);
        if ((double)f <= nested1_bdbb1f3d.offset()) {
            return CosmeticRender.rgb(nested1_bdbb1f3d.color());
        }
        if ((double)f >= nested1_bdbb1f3d2.offset()) {
            return CosmeticRender.rgb(nested1_bdbb1f3d2.color());
        }
        for (int i = 1; i < list.size(); ++i) {
            Packets.Nested1_bdbb1f3d nested1_bdbb1f3d3 = list.get(i - 1);
            Packets.Nested1_bdbb1f3d nested1_bdbb1f3d4 = list.get(i);
            if ((double)f > nested1_bdbb1f3d4.offset()) continue;
            float f2 = (float)(nested1_bdbb1f3d4.offset() - nested1_bdbb1f3d3.offset());
            float f3 = f2 <= 0.0f ? 0.0f : (float)(((double)f - nested1_bdbb1f3d3.offset()) / (double)f2);
            return CosmeticRender.rgb(nested1_bdbb1f3d3.color()).mix(CosmeticRender.rgb(nested1_bdbb1f3d4.color()), f3);
        }
        return CosmeticRender.rgb(nested1_bdbb1f3d2.color());
    }

    private static float phase(String string) {
        float f = switch (string == null ? "" : string) {
            case "shine" -> 1500.0f;
            case "shimmer" -> 2600.0f;
            default -> 3000.0f;
        };
        return CosmeticRender.frac((float)(System.currentTimeMillis() % (long)f) / f);
    }

    private static float pulse() {
        float f = CosmeticRender.frac((float)(System.currentTimeMillis() % 2600L) / 2600.0f);
        float f2 = (float)(0.5 - 0.5 * Math.cos(Math.PI * 2 * (double)f));
        return 1.0f + 0.54999995f * f2;
    }

    private static ColorRGBA brighten(ColorRGBA colorRGBA, float f) {
        return new ColorRGBA(colorRGBA.getRed() * f, colorRGBA.getGreen() * f, colorRGBA.getBlue() * f, colorRGBA.getAlpha());
    }

    private static ColorRGBA rgb(int n) {
        return new ColorRGBA(n >> 16 & 0xFF, n >> 8 & 0xFF, n & 0xFF);
    }

    private static float frac(float f) {
        float f2 = f % 1.0f;
        return f2 < 0.0f ? f2 + 1.0f : f2;
    }
}

