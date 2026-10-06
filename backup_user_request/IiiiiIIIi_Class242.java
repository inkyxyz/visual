package rockstar.client;

import com.google.gson.JsonObject;
import java.awt.Color;
import java.util.Arrays;
import lombok.Generated;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.IiIIIiIii_Class140;
import rockstar.client.IiIIIiiII_Class141;
import rockstar.client.IiIIIiiIi_Class142;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiIiiIi_Class238;

public final class IiiiiIIIi_Class242 {
    public static final ColorRGBA I_field_d0c8ec5 = new ColorRGBA(255.0f, 0.0f, 0.0f);
    public static final ColorRGBA i_field_d0c8ec5 = new ColorRGBA(0.0f, 255.0f, 0.0f);
    public static final ColorRGBA II_field_d0c8ec5 = new ColorRGBA(0.0f, 0.0f, 255.0f);
    public static final ColorRGBA Ii_field_d0c8ec5 = new ColorRGBA(255.0f, 255.0f, 255.0f);
    public static final ColorRGBA iI_field_d0c8ec5 = new ColorRGBA(0.0f, 0.0f, 0.0f);
    public static final int I_field_49 = 2;
    private static final ColorRGBA iiI_field_d0c8ec5 = new ColorRGBA(144.0f, 107.0f, 255.0f);
    private static final int i_field_49 = 0;
    private static final int II_field_49 = 1;
    private static final int Ii_field_49 = 2;
    private static final int iI_field_49 = 3;
    private static final int ii_field_49 = 4;
    private static final int III_field_49 = 5;
    private static final int IIi_field_49 = 6;
    private static final int IiI_field_49 = 7;
    private static final int Iii_field_49 = 8;
    private static final ColorRGBA iii_field_d0c8ec5 = new ColorRGBA(255.0f, 255.0f, 255.0f);
    private static final ColorRGBA IIII_field_d0c8ec5 = new ColorRGBA(16.0f, 14.0f, 20.0f);
    private static final float I_field_46 = 0.58f;
    private static final float i_field_46 = 0.7f;
    private static final ColorRGBA[] I_field_c75745ca = new ColorRGBA[]{iiI_field_d0c8ec5, new ColorRGBA(24.0f, 21.0f, 29.0f, 229.5f), new ColorRGBA(24.0f, 21.0f, 29.0f, 102.0f), new ColorRGBA(61.0f, 54.0f, 71.0f, 63.75f), new ColorRGBA(77.0f, 0.0f, 255.0f), new ColorRGBA(255.0f, 255.0f, 255.0f), new ColorRGBA(26.0f, 23.0f, 31.0f), new ColorRGBA(5.0f, 4.0f, 7.0f)};
    public static final ColorRGBA ii_field_d0c8ec5 = new Nested1_9346f460(0);
    public static final ColorRGBA III_field_d0c8ec5 = new Nested1_9346f460(1);
    public static final ColorRGBA IIi_field_d0c8ec5 = new Nested1_9346f460(2);
    public static final ColorRGBA IiI_field_d0c8ec5 = new Nested1_9346f460(3);
    public static final ColorRGBA Iii_field_d0c8ec5 = new Nested1_9346f460(4);
    public static final ColorRGBA iII_field_d0c8ec5 = new Nested1_9346f460(5);
    public static final ColorRGBA iIi_field_d0c8ec5 = new Nested1_9346f460(8);
    private static final IiIIIiiIi_Class142 I_field_74e90a8c = new IiIIIiiIi_Class142(iiI_field_d0c8ec5, I_field_c75745ca[1], I_field_c75745ca[6], I_field_c75745ca[5], I_field_c75745ca[3], I_field_c75745ca[7], I_field_c75745ca[5], I_field_c75745ca[5], 7.0f, 0.5f, 0.8f, 0.2f, 25.0f, 0.08f, 2.0f, 0.0f, 1.0f, 1.0f);
    private static final IiiiIiiIi_Class238 I_field_dd60e8c = new IiiiIiiIi_Class238(500L, iiI_field_d0c8ec5);
    private static final float[] I_field_b4b = IiiiiIIIi_Class242.I_method_d159e0a1(iiI_field_d0c8ec5);
    private static final ColorRGBA[] i_field_c75745ca = IiiiiIIIi_Class242.I_method_73f52d21();
    private static final ColorRGBA[] II_field_c75745ca = IiiiiIIIi_Class242.I_method_73f52d21();
    private static ColorRGBA IIIi_field_d0c8ec5 = iiI_field_d0c8ec5;
    private static long I_field_4a;
    private static int iII_field_49;

    public static ColorRGBA I_method_7df8e08e() {
        return IIIi_field_d0c8ec5;
    }

    public static void I_method_300b2840(ColorRGBA colorRGBA) {
        if (colorRGBA != null) {
            IIIi_field_d0c8ec5 = colorRGBA.withAlpha(255.0f);
            I_field_dd60e8c.i_method_7d83c440(IIIi_field_d0c8ec5);
            iII_field_49 = -1;
        }
    }

    public static void I_method_169cf8c7(IiIIIiiIi_Class142 iiIIIiiIi_Class142) {
        if (iiIIIiiIi_Class142 == null) {
            return;
        }
        if (iiIIIiiIi_Class142.I_method_35ab4ae() != null && iiIIIiiIi_Class142.I_method_35ab4ae().getAlpha() > 0.0f) {
            IiiiiIIIi_Class242.I_method_300b2840(iiIIIiiIi_Class142.I_method_35ab4ae());
        }
        I_field_dd60e8c.i_method_7d83c440(IIIi_field_d0c8ec5);
        iII_field_49 = -1;
        I_field_74e90a8c.I_method_2d9a27d7(iiIIIiiIi_Class142.I_method_37580a2f()).i_method_cab32ff7(iiIIIiiIi_Class142.i_method_3766960f()).II_method_afa85b34(iiIIIiiIi_Class142.II_method_b3b834f2()).Ii_method_4cc16354(iiIIIiiIi_Class142.Ii_method_b3c6c0d2()).iI_method_b5b05714(iiIIIiiIi_Class142.iI_method_b57b2512()).ii_method_52c95f34(iiIIIiiIi_Class142.ii_method_b589b0f2()).III_method_6f609377(iiIIIiiIi_Class142.III_method_c35d628f()).IIi_method_c799b97(iiIIIiiIi_Class142.IIi_method_c36bee6f()).IiI_method_75688f57(iiIIIiiIi_Class142.IiI_method_c52052af()).Iii_method_12819777(iiIIIiiIi_Class142.Iii_method_c52ede8f());
    }

    public static IiIIIiiIi_Class142 I_method_5ac4a715() {
        IiiiiIIIi_Class242.I_method_ce9db61f();
        return I_field_74e90a8c;
    }

    public static ColorRGBA i_method_5dfec6e() {
        return IiiiiIIIi_Class242.I_method_5ed8d733(0);
    }

    public static ColorRGBA II_method_190e6391() {
        return IiiiiIIIi_Class242.I_method_5ed8d733(1);
    }

    public static ColorRGBA Ii_method_a0f56f71() {
        return IiiiiIIIi_Class242.I_method_5ed8d733(6);
    }

    public static ColorRGBA iI_method_8e08d3b1() {
        return IiiiiIIIi_Class242.I_method_5ed8d733(5);
    }

    public static ColorRGBA ii_method_15efdf91() {
        return IiiiiIIIi_Class242.I_method_5ed8d733(7);
    }

    public static ColorRGBA III_method_e0a940ee() {
        return IiiiiIIIi_Class242.I_method_5ed8d733(8);
    }

    public static ColorRGBA I_method_35ed8eaf(ColorRGBA colorRGBA) {
        return IiiiiIIIi_Class242.I_method_85e10a8f(colorRGBA, iii_field_d0c8ec5, IIII_field_d0c8ec5);
    }

    public static ColorRGBA I_method_85e10a8f(ColorRGBA colorRGBA, ColorRGBA colorRGBA2, ColorRGBA colorRGBA3) {
        return colorRGBA2.mix(colorRGBA3, IiiiiIIIi_Class242.I_method_300b2830(colorRGBA));
    }

    public static float I_method_300b2830(ColorRGBA colorRGBA) {
        return IiiiiIIIi_Class242.I_method_76ac3e2f(colorRGBA, IiiiiIIIi_Class242.II_method_190e6391());
    }

    private static float I_method_76ac3e2f(ColorRGBA colorRGBA, ColorRGBA colorRGBA2) {
        float f = Math.clamp(colorRGBA.getAlpha() / 255.0f, 0.0f, 1.0f);
        float f2 = colorRGBA.getRed() * f + colorRGBA2.getRed() * (1.0f - f);
        float f3 = colorRGBA.getGreen() * f + colorRGBA2.getGreen() * (1.0f - f);
        float f4 = colorRGBA.getBlue() * f + colorRGBA2.getBlue() * (1.0f - f);
        float f5 = (0.299f * f2 + 0.587f * f3 + 0.114f * f4) / 255.0f;
        return Math.clamp((f5 - 0.58f) / 0.120000005f, 0.0f, 1.0f);
    }

    public static ColorRGBA IIi_method_68904cce() {
        return ColorRGBA.BLACK.withAlpha(255.0f * (IiiiiIIIi_Class242.I_method_5ab69355() == IiIIIiIii_Class140.I_field_74daf6cc ? 0.08f : 0.05f));
    }

    private static IiIIIiIii_Class140 I_method_5ab69355() {
        IiIIIiiII_Class141 iiIIIiiII_Class141 = RockstarClient.getInstance().I_method_9a720c62();
        return iiIIIiiII_Class141 == null ? IiIIIiIii_Class140.I_field_74daf6cc : iiIIIiiII_Class141.I_method_ac8a0395();
    }

    static ColorRGBA I_method_5ed8d733(int n) {
        IiiiiIIIi_Class242.I_method_ce9db61f();
        return II_field_c75745ca[n];
    }

    private static void I_method_ce9db61f() {
        InterfaceModule.checkTheme();
        long l = System.currentTimeMillis();
        if (l == I_field_4a) {
            return;
        }
        I_field_4a = l;
        I_field_dd60e8c.I_method_8895420(IIIi_field_d0c8ec5);
        ColorRGBA colorRGBA = I_field_dd60e8c.I_method_915b8ae();
        IiIIIiIii_Class140 iiIIIiIii_Class140 = IiiiiIIIi_Class242.I_method_5ab69355();
        int n = 31 * colorRGBA.getRGB() + iiIIIiIii_Class140.ordinal();
        if (n == iII_field_49) {
            return;
        }
        iII_field_49 = n;
        float[] fArray = IiiiiIIIi_Class242.I_method_d159e0a1(colorRGBA);
        float f = fArray[0] - I_field_b4b[0];
        float f2 = I_field_b4b[1] == 0.0f ? 1.0f : fArray[1] / I_field_b4b[1];
        IiiiiIIIi_Class242.i_field_c75745ca[0] = colorRGBA;
        for (int i = 1; i < I_field_c75745ca.length; ++i) {
            ColorRGBA colorRGBA2 = I_field_c75745ca[i];
            float[] fArray2 = IiiiiIIIi_Class242.I_method_d159e0a1(colorRGBA2);
            if (fArray2[1] == 0.0f) {
                IiiiiIIIi_Class242.i_field_c75745ca[i] = colorRGBA2;
                continue;
            }
            float f3 = fArray2[0] + f;
            IiiiiIIIi_Class242.i_field_c75745ca[i] = ColorRGBA.fromHSB(f3 - (float)Math.floor(f3), Math.clamp(fArray2[1] * f2, 0.0f, 1.0f), fArray2[2]).withAlpha(colorRGBA2.getAlpha());
        }
        System.arraycopy(i_field_c75745ca, 0, II_field_c75745ca, 0, i_field_c75745ca.length);
        if (iiIIIiIii_Class140 == IiIIIiIii_Class140.i_field_74daf6cc) {
            IiiiiIIIi_Class242.II_field_c75745ca[1] = IiIIIiIii_Class140.i_field_74daf6cc.i_method_c7a28cce().withAlpha(i_field_c75745ca[1].getAlpha());
            IiiiiIIIi_Class242.II_field_c75745ca[2] = IiIIIiIii_Class140.i_field_74daf6cc.i_method_c7a28cce().withAlpha(i_field_c75745ca[2].getAlpha());
            IiiiiIIIi_Class242.II_field_c75745ca[3] = IiIIIiIii_Class140.i_field_74daf6cc.Ii_method_1786db11().withAlpha(i_field_c75745ca[3].getAlpha());
            IiiiiIIIi_Class242.II_field_c75745ca[5] = IiIIIiIii_Class140.i_field_74daf6cc.I_method_3fbb80ee().withAlpha(i_field_c75745ca[5].getAlpha());
            IiiiiIIIi_Class242.II_field_c75745ca[6] = IiIIIiIii_Class140.i_field_74daf6cc.II_method_8f9fcf31().withAlpha(i_field_c75745ca[6].getAlpha());
            IiiiiIIIi_Class242.II_field_c75745ca[7] = IiIIIiIii_Class140.i_field_74daf6cc.iI_method_49a3f51().withAlpha(i_field_c75745ca[7].getAlpha());
        }
        IiiiiIIIi_Class242.II_field_c75745ca[8] = iii_field_d0c8ec5.mix(IIII_field_d0c8ec5, IiiiiIIIi_Class242.I_method_76ac3e2f(II_field_c75745ca[0], II_field_c75745ca[1]));
        I_field_74e90a8c.I_method_751559d6(IIIi_field_d0c8ec5).i_method_e705e1f6(II_field_c75745ca[1]).II_method_f0f6d933(II_field_c75745ca[6]).Ii_method_62e76153(II_field_c75745ca[5]).iI_method_bd175513(II_field_c75745ca[3]).ii_method_2f07dd33(II_field_c75745ca[7]).III_method_f1454576(II_field_c75745ca[5]).IIi_method_6335cd96(II_field_c75745ca[5]);
    }

    private static ColorRGBA[] I_method_73f52d21() {
        ColorRGBA[] colorRGBAArray = Arrays.copyOf(I_field_c75745ca, 9);
        colorRGBAArray[8] = iii_field_d0c8ec5;
        return colorRGBAArray;
    }

    private static float[] I_method_d159e0a1(ColorRGBA colorRGBA) {
        return Color.RGBtoHSB(Math.round(colorRGBA.getRed()), Math.round(colorRGBA.getGreen()), Math.round(colorRGBA.getBlue()), null);
    }

    @Generated
    private IiiiiIIIi_Class242() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    static {
        iII_field_49 = -1;
    }

    static final class Nested1_9346f460
    extends ColorRGBA {
        private final int I_field_49;

        Nested1_9346f460(int n) {
            super(0.0f, 0.0f, 0.0f);
            this.I_field_49 = n;
        }

        private ColorRGBA I_method_f3ec49c9() {
            return IiiiiIIIi_Class242.I_method_5ed8d733(this.I_field_49);
        }

        @Override
        public float getRed() {
            return this.I_method_f3ec49c9().getRed();
        }

        @Override
        public float getGreen() {
            return this.I_method_f3ec49c9().getGreen();
        }

        @Override
        public float getBlue() {
            return this.I_method_f3ec49c9().getBlue();
        }

        @Override
        public float getAlpha() {
            return this.I_method_f3ec49c9().getAlpha();
        }

        @Override
        public int getRGB() {
            return this.I_method_f3ec49c9().getRGB();
        }

        @Override
        public String toHex() {
            return this.I_method_f3ec49c9().toHex();
        }

        @Override
        public ColorRGBA withAlpha(float f) {
            return this.I_method_f3ec49c9().withAlpha(f);
        }

        @Override
        public ColorRGBA mulAlpha(float f) {
            return this.I_method_f3ec49c9().mulAlpha(f);
        }

        @Override
        public ColorRGBA mix(ColorRGBA colorRGBA, float f) {
            return this.I_method_f3ec49c9().mix(colorRGBA, f);
        }

        @Override
        public float getHue() {
            return this.I_method_f3ec49c9().getHue();
        }

        @Override
        public float getSaturation() {
            return this.I_method_f3ec49c9().getSaturation();
        }

        @Override
        public float getBrightness() {
            return this.I_method_f3ec49c9().getBrightness();
        }

        @Override
        public JsonObject toJson() {
            return this.I_method_f3ec49c9().toJson();
        }

        @Override
        public boolean equals(Object object) {
            return this.I_method_f3ec49c9().equals(object);
        }

        @Override
        public int hashCode() {
            return this.I_method_f3ec49c9().hashCode();
        }

        @Override
        public String toString() {
            return this.I_method_f3ec49c9().toString();
        }
    }
}

