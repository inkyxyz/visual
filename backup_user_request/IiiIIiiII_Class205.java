package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIIIi_Class2;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiIIiiii_Class80;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiIiiIi_Class238;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIIiIiI_Class267;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iIIIiIIiI_Class275;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiiiiiI_Class319;
import rockstar.client.iiIiIIiii_Class424;
import ua.mintantileak.profile.Profile;

public class IiiIIiiII_Class205
implements iIIiIIiIi_Class294 {
    public static final float I_field_46 = 22.0f;
    private static final float i_field_46 = 12.0f;
    private static final float II_field_46 = 8.0f;
    private static final float Ii_field_46 = 0.5f;
    private static final float iI_field_46 = 19.0f;
    private static final float ii_field_46 = 106.0f;
    private static final float III_field_46 = 18.0f;
    private static final float IIi_field_46 = 5.0f;
    private static final float IiI_field_46 = 7.0f;
    private static final float Iii_field_46 = 7.0f;
    private final Runnable I_field_bac0a97e;
    private final List<Nested1_32b77c40> I_field_7865b31 = new ArrayList<Nested1_32b77c40>();
    private boolean I_field_5a;
    private float iII_field_46;
    private float iIi_field_46;
    private boolean i_field_5a;
    private float iiI_field_46;
    private float iii_field_46;
    private final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(220L, 0.0f, IiiiIiiII_Class237.III_field_dd60aac);
    private static final ColorRGBA I_field_d0c8ec5 = new ColorRGBA(28.0f, 28.0f, 30.0f);
    private static final ColorRGBA i_field_d0c8ec5 = new ColorRGBA(255.0f, 255.0f, 255.0f);
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
    private boolean II_field_5a;
    private boolean Ii_field_5a;
    private final IiiiIiiIi_Class238 I_field_dd60e8c = new IiiiIiiIi_Class238(300L, new ColorRGBA(255.0f, 255.0f, 255.0f), IiiiIiiII_Class237.Iii_field_dd60aac);
    private final IiiiIiiIi_Class238 i_field_dd60e8c = new IiiiIiiIi_Class238(300L, new ColorRGBA(255.0f, 255.0f, 255.0f), IiiiIiiII_Class237.Iii_field_dd60aac);
    private float IIII_field_46;
    private float IIIi_field_46;
    private float IIiI_field_46;

    public IiiIIiiII_Class205(Runnable runnable) {
        this.I_field_bac0a97e = runnable;
        this.I_field_7865b31.add(new Nested1_32b77c40("Смена обоев", () -> {
            this.i_field_5a = false;
            this.I_field_bac0a97e.run();
        }, () -> false));
        this.I_field_7865b31.add(new Nested1_32b77c40("Alt Manager", () -> {
            this.i_field_5a = false;
            net.minecraft.client.MinecraftClient.getInstance().setScreen(new AltManagerScreen(net.minecraft.client.MinecraftClient.getInstance().currentScreen));
        }, () -> false));
    }

    public void I_method_201c6b9(III iII, int n, int n2, float f) {
        this.I_method_3e377827(iII, n, n2, f, 1.0f);
    }

    public void I_method_3e377827(III iII, int n, int n2, float f, float f2) {
        this.iii_field_46 = f;
        this.I_method_e74318a4(n);
        ColorRGBA colorRGBA = this.I_field_dd60e8c.I_method_915b8ae();
        ColorRGBA colorRGBA2 = this.i_field_dd60e8c.I_method_915b8ae();
        this.I_method_7f8d9863(iII, n, f, f2, colorRGBA2);
        float f3 = f * f2;
        if (f < 0.5f) {
            this.i_field_5a = false;
        }
        this.iiI_field_46 = f3;
        this.I_method_4f5bb347(iII);
        if (f3 <= 0.003f) {
            return;
        }
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f);
        float f4 = (1.0f - f2) * -5.0f;
        float f5 = 12.0f;
        float f6 = 8.0f;
        float f7 = 11.0f - f5 / 2.0f + f4;
        iII.drawIcon("logo", f6, f7, f5, colorRGBA.withAlpha(255.0f * f3));
        float f8 = f6 + f5 + 12.0f;
        for (Nested1_32b77c40 nested1_32b77c40 : this.I_field_7865b31) {
            String txt = nested1_32b77c40.I_field_523beb0a.startsWith("mainmenu.") ? IiIiIIII_Class81.I_method_f25a980a(nested1_32b77c40.I_field_523beb0a) : nested1_32b77c40.I_field_523beb0a;
            nested1_32b77c40.ii_field_46 = iIiIIi_Class10.I_method_2c375926(txt);
            nested1_32b77c40.iI_field_46 = f8;
            nested1_32b77c40.I_field_46 = f8 - 6.0f;
            nested1_32b77c40.i_field_46 = 0.0f;
            nested1_32b77c40.II_field_46 = nested1_32b77c40.ii_field_46 + 12.0f;
            nested1_32b77c40.Ii_field_46 = 22.0f;
            f8 += nested1_32b77c40.ii_field_46 + 12.0f;
        }
        int n3 = iII.I_method_b1c3e152();
        int n4 = iII.i_method_b1d26d32();
        for (Nested1_32b77c40 nested1_32b77c40 : this.I_field_7865b31) {
            String string = nested1_32b77c40.I_field_523beb0a.startsWith("mainmenu.") ? IiIiIIII_Class81.I_method_f25a980a(nested1_32b77c40.I_field_523beb0a) : nested1_32b77c40.I_field_523beb0a;
            boolean bl = f3 > 0.5f && (float)n3 >= nested1_32b77c40.I_field_46 && (float)n3 <= nested1_32b77c40.I_field_46 + nested1_32b77c40.II_field_46 && (float)n4 >= nested1_32b77c40.i_field_46 && (float)n4 <= nested1_32b77c40.i_field_46 + nested1_32b77c40.Ii_field_46;
            boolean bl2 = nested1_32b77c40.I_field_7bf34412.getAsBoolean();
            nested1_32b77c40.I_field_dc7facc.I_method_edd72835(bl || bl2);
            if (bl) {
                iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
            }
            float f9 = iIIiiiiiI_Class319.I_method_5f7ff5cf(0.83f, 1.0, nested1_32b77c40.I_field_dc7facc.I_method_6ac4da6f());
            float f10 = nested1_32b77c40.i_field_46 + nested1_32b77c40.Ii_field_46 / 2.0f - iIiIIi_Class10.I_method_a649725c() / 2.0f + 0.5f + f4;
            iII.drawText(iIiIIi_Class10, string, nested1_32b77c40.iI_field_46, f10, colorRGBA.withAlpha(255.0f * f9 * f3));
        }
    }

    private void I_method_7f8d9863(III iII, int n, float f, float f2, ColorRGBA colorRGBA) {
        float f3;
        if (f <= 0.003f) {
            this.IIiI_field_46 = 0.0f;
            return;
        }
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0f);
        float f4 = 11.0f;
        float f5 = f4 - iIiIIi_Class10.I_method_a649725c() / 2.0f + 0.5f;
        float f6 = 10.0f;
        float f7 = 6.0f;
        float f8 = 13.0f;
        float f9 = 12.0f;
        float f10 = f;
        float f11 = f * f2;
        String string = iIIIIiIiI_Class267.II_method_6d1277fe() + "  " + iIIIIiIiI_Class267.i_method_8e352841();
        String string2 = Profile.getUsername();
        float f12 = iIiIIi_Class10.I_method_2c375926(string);
        float f13 = iIiIIi_Class10.I_method_2c375926(string2);
        float f14 = (float)n - f6;
        float f15 = f14 - f12;
        f14 = f15 - (f7 + 4.0f);
        float f16 = f14 - f9;
        f14 = f16 - f7;
        float f17 = f14 - f8;
        f14 = f17 - f7;
        float f18 = f14 - f13;
        float f19 = f12 + (f7 + 4.0f);
        float f20 = f19 * (1.0f - f2);
        iII.drawText(iIiIIi_Class10, string, f15 + f20, f5, colorRGBA.withAlpha(255.0f * f11));
        this.IIII_field_46 = f3 = f16 + f20;
        this.IIIi_field_46 = f4 - f9 / 2.0f;
        this.IIiI_field_46 = f9;
        iII.drawIcon("language", f3, this.IIIi_field_46, f9, colorRGBA.withAlpha(255.0f * f10));
        float f21 = f4 - f8 / 2.0f;
        if (IIIIi_Class2.Ii_method_57601446()) {
            iII.drawRoundedTexture(IIIIi_Class2.I_method_79e9d9ee(), f17 + f20, f21, f8, f8, IIiii_Class8.I_method_893b2757(f8 / 2.0f), ColorRGBA.WHITE.withAlpha(255.0f * f11));
        } else {
            iII.drawRoundedRect(f17 + f20, f21, f8, f8, IIiii_Class8.I_method_893b2757(f8 / 2.0f), colorRGBA.withAlpha(60.0f * f11));
        }
        iII.drawText(iIiIIi_Class10, string2, f18 + f20, f5, colorRGBA.withAlpha(255.0f * f11));
        this.iII_field_46 = Math.max(4.0f, this.IIII_field_46 + f9 - 106.0f);
        this.iIi_field_46 = 26.0f;
    }

    private void I_method_e74318a4(int n) {
        if (this.I_field_991c1e8c.I_method_58432069(250L)) {
            double d = I_field_3a9bda27.getWindow().getScaleFactor();
            float f = 11.0f;
            this.II_field_5a = this.I_method_22c229a3(40.0f, f, d);
            this.Ii_field_5a = this.I_method_22c229a3((float)n - 70.0f, f, d);
            this.I_field_991c1e8c.I_method_23e11e3f();
        }
        this.I_field_dd60e8c.I_method_8895420(this.II_field_5a ? I_field_d0c8ec5 : i_field_d0c8ec5);
        this.i_field_dd60e8c.I_method_8895420(this.Ii_field_5a ? I_field_d0c8ec5 : i_field_d0c8ec5);
    }

    private boolean I_method_22c229a3(float f, float f2, double d) {
        ColorRGBA colorRGBA = ColorRGBA.fromPixel(f * (float)d, (float)I_field_3a9bda27.getWindow().getHeight() - f2 * (float)d);
        return (colorRGBA.getRed() + colorRGBA.getGreen() + colorRGBA.getBlue()) / 3.0f > 120.0f;
    }

    private boolean I_method_11e1643(double d, double d2) {
        return this.IIiI_field_46 > 0.0f && d >= (double)(this.IIII_field_46 - 2.0f) && d <= (double)(this.IIII_field_46 + this.IIiI_field_46 + 2.0f) && d2 >= (double)(this.IIIi_field_46 - 2.0f) && d2 <= (double)(this.IIIi_field_46 + this.IIiI_field_46 + 2.0f);
    }

    private void I_method_4f5bb347(III iII) {
        this.I_field_dc7facc.I_method_edd72835(this.i_field_5a);
        float f = this.I_field_dc7facc.I_method_6ac4da6f();
        if (f <= 0.003f) {
            return;
        }
        IiIIiiii_Class80[] iiIIiiii_Class80Array = IiIIiiii_Class80.values();
        float f2 = this.iII_field_46;
        float f3 = this.iIi_field_46;
        float f4 = (float)iiIIiiii_Class80Array.length * 18.0f + 10.0f;
        float f5 = IiiiiIIIi_Class242.I_method_5ac4a715().I_method_37580a2f();
        float f6 = Math.max(2.0f, f5 - 3.0f);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)f);
        iII.drawShadow(f2, f3, 106.0f, f4, 12.0f, IIiii_Class8.I_method_893b2757(f5), ColorRGBA.BLACK.withAlpha(120.0f));
        iII.drawClientRect(f2, f3, 106.0f, f4, f, 0.0f, 7.0f);
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f);
        int n = iII.I_method_b1c3e152();
        int n2 = iII.i_method_b1d26d32();
        for (int i = 0; i < iiIIiiii_Class80Array.length; ++i) {
            IiIIiiii_Class80 iiIIiiii_Class80 = iiIIiiii_Class80Array[i];
            float f7 = f3 + 5.0f + (float)i * 18.0f;
            boolean bl = (float)n >= f2 + 5.0f && (float)n <= f2 + 106.0f - 5.0f && (float)n2 >= f7 && (float)n2 <= f7 + 18.0f;
            boolean bl2 = IiIiIIII_Class81.I_method_21a4cfeb() == iiIIiiii_Class80;
            ColorRGBA colorRGBA = IiiiiIIIi_Class242.iI_method_8e08d3b1();
            if (bl) {
                iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
                iII.drawSquircle(f2 + 5.0f, f7, 96.0f, 18.0f, 7.0f, IIiii_Class8.I_method_893b2757(f6), colorRGBA.withAlpha(13.0f));
            }
            iII.drawText(iIiIIi_Class10, IiiIIiiII_Class205.I_method_ae4591c0(iiIIiiii_Class80), f2 + 5.0f + 7.0f, f7 + 9.0f - iIiIIi_Class10.I_method_a649725c() / 2.0f, colorRGBA.withAlpha(bl2 ? 255.0f : 150.0f));
            if (!bl2) continue;
            float f8 = 4.0f;
            iII.drawRoundedRect(f2 + 106.0f - 5.0f - 7.0f - f8, f7 + 9.0f - f8 / 2.0f, f8, f8, IIiii_Class8.I_method_893b2757(f8 / 2.0f), ColorRGBA.WHITE);
        }
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    public boolean I_method_22a524a8(double d, double d2, int n) {
        if (this.iii_field_46 > 0.5f && this.I_method_11e1643(d, d2)) {
            if (n == 0) {
                this.i_field_5a = !this.i_field_5a;
            }
            return true;
        }
        if (this.i_field_5a) {
            IiIIiiii_Class80[] iiIIiiii_Class80Array = IiIIiiii_Class80.values();
            float f = this.iII_field_46;
            float f2 = this.iIi_field_46;
            float f3 = (float)iiIIiiii_Class80Array.length * 18.0f + 10.0f;
            if (d >= (double)f && d <= (double)(f + 106.0f) && d2 >= (double)f2 && d2 <= (double)(f2 + f3)) {
                int n2 = (int)((d2 - (double)f2 - 5.0) / 18.0);
                if (n == 0 && n2 >= 0 && n2 < iiIIiiii_Class80Array.length) {
                    IiIiIIII_Class81.I_method_9b03faed(iiIIiiii_Class80Array[n2]);
                }
            }
            this.i_field_5a = false;
            return true;
        }
        if (this.iiI_field_46 <= 0.5f) {
            return false;
        }
        for (Nested1_32b77c40 nested1_32b77c40 : this.I_field_7865b31) {
            if (!(d >= (double)nested1_32b77c40.I_field_46) || !(d <= (double)(nested1_32b77c40.I_field_46 + nested1_32b77c40.II_field_46)) || !(d2 >= (double)nested1_32b77c40.i_field_46) || !(d2 <= (double)(nested1_32b77c40.i_field_46 + nested1_32b77c40.Ii_field_46))) continue;
            if (n == 0) {
                nested1_32b77c40.I_field_bac0a97e.run();
            }
            return true;
        }
        return false;
    }

    public boolean I_method_22ede008(int n, int n2, int n3) {
        if (this.i_field_5a && n == 256) {
            this.i_field_5a = false;
            return true;
        }
        return false;
    }

    private static String I_method_ae4591c0(IiIIiiii_Class80 iiIIiiii_Class80) {
        return switch (iiIIiiii_Class80) {
            default -> throw new MatchException(null, null);
            case IiIIiiii_Class80.I_field_3f56db61 -> "English";
            case IiIIiiii_Class80.i_field_3f56db61 -> "\u0420\u0443\u0441\u0441\u043a\u0438\u0439";
            case IiIIiiii_Class80.II_field_3f56db61 -> "\u0423\u043a\u0440\u0430\u0457\u043d\u0441\u044c\u043a\u0430";
            case IiIIiiii_Class80.Ii_field_3f56db61 -> "Polski";
        };
    }

    static final class Nested1_32b77c40 {
        final String I_field_523beb0a;
        final Runnable I_field_bac0a97e;
        final BooleanSupplier I_field_7bf34412;
        final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(220L, 0.0f, IiiiIiiII_Class237.III_field_dd60aac);
        float I_field_46;
        float i_field_46;
        float II_field_46;
        float Ii_field_46;
        float iI_field_46;
        float ii_field_46;

        Nested1_32b77c40(String string, Runnable runnable, BooleanSupplier booleanSupplier) {
            this.I_field_523beb0a = string;
            this.I_field_bac0a97e = runnable;
            this.I_field_7bf34412 = booleanSupplier;
        }
    }
}

