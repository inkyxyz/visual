package rockstar.client;

import java.awt.Font;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.PathIterator;
import java.util.ArrayList;
import java.util.List;

public final class IiIIii_Class20 {
    public static final float I_field_46 = 2048.0f;
    private static final double I_field_44 = 2.44140625E-4;
    public final float[] I_field_b4b;
    public final int I_field_49;
    public final float i_field_46;
    public final float II_field_46;
    public final float Ii_field_46;
    public final float iI_field_46;
    public final float ii_field_46;

    private IiIIii_Class20(float[] fArray, int n, float f, float f2, float f3, float f4, float f5) {
        this.I_field_b4b = fArray;
        this.I_field_49 = n;
        this.i_field_46 = f;
        this.II_field_46 = f2;
        this.Ii_field_46 = f3;
        this.iI_field_46 = f4;
        this.ii_field_46 = f5;
    }

    public boolean I_method_43b11e50() {
        return this.I_field_49 == 0;
    }

    public float I_method_43b11e3c() {
        return this.Ii_field_46 - this.i_field_46;
    }

    public float i_method_43bfaa1c() {
        return this.iI_field_46 - this.II_field_46;
    }

    public static IiIIii_Class20 I_method_2b013b05(Font font, FontRenderContext fontRenderContext, int n) {
        Font font2 = font.getSize2D() == 2048.0f ? font : font.deriveFont(2048.0f);
        GlyphVector glyphVector = font2.createGlyphVector(fontRenderContext, new String(Character.toChars(n)));
        float f = glyphVector.getGlyphMetrics(0).getAdvanceX() / 2048.0f;
        return IiIIii_Class20.I_method_e96b4def(glyphVector.getOutline(), f);
    }

    public static IiIIii_Class20 I_method_e96b4def(Shape shape, float f) {
        ArrayList<double[]> arrayList = new ArrayList<double[]>();
        PathIterator pathIterator = shape.getPathIterator(null);
        double[] dArray = new double[6];
        double d = 0.0;
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        while (!pathIterator.isDone()) {
            switch (pathIterator.currentSegment(dArray)) {
                case 0: {
                    IiIIii_Class20.I_method_9ea0cc3d(arrayList, d3, d4, d, d2);
                    d = d3 = dArray[0] / 2048.0;
                    d2 = d4 = -dArray[1] / 2048.0;
                    break;
                }
                case 1: {
                    double d5 = dArray[0] / 2048.0;
                    double d6 = -dArray[1] / 2048.0;
                    IiIIii_Class20.i_method_1ed2a81d(arrayList, d3, d4, d5, d6);
                    d3 = d5;
                    d4 = d6;
                    break;
                }
                case 2: {
                    double d5 = dArray[0] / 2048.0;
                    double d6 = -dArray[1] / 2048.0;
                    double d7 = dArray[2] / 2048.0;
                    double d8 = -dArray[3] / 2048.0;
                    IiIIii_Class20.I_method_79aab8bd(arrayList, d3, d4, d5, d6, d7, d8);
                    d3 = d7;
                    d4 = d8;
                    break;
                }
                case 3: {
                    double d5 = dArray[0] / 2048.0;
                    double d6 = -dArray[1] / 2048.0;
                    double d7 = dArray[2] / 2048.0;
                    double d8 = -dArray[3] / 2048.0;
                    double d9 = dArray[4] / 2048.0;
                    double d10 = -dArray[5] / 2048.0;
                    IiIIii_Class20.I_method_b9eb853d(arrayList, d3, d4, d5, d6, d7, d8, d9, d10);
                    d3 = d9;
                    d4 = d10;
                    break;
                }
                case 4: {
                    IiIIii_Class20.I_method_9ea0cc3d(arrayList, d3, d4, d, d2);
                    d3 = d;
                    d4 = d2;
                    break;
                }
            }
            pathIterator.next();
        }
        IiIIii_Class20.I_method_9ea0cc3d(arrayList, d3, d4, d, d2);
        float[] fArray = new float[arrayList.size() * 6];
        float f2 = Float.MAX_VALUE;
        float f3 = Float.MAX_VALUE;
        float f4 = -3.4028235E38f;
        float f5 = -3.4028235E38f;
        for (int i = 0; i < arrayList.size(); ++i) {
            int n;
            double[] dArray2 = (double[])arrayList.get(i);
            for (n = 0; n < 6; ++n) {
                fArray[i * 6 + n] = (float)dArray2[n];
            }
            for (n = 0; n < 6; n += 2) {
                f2 = Math.min(f2, fArray[i * 6 + n]);
                f4 = Math.max(f4, fArray[i * 6 + n]);
                f3 = Math.min(f3, fArray[i * 6 + n + 1]);
                f5 = Math.max(f5, fArray[i * 6 + n + 1]);
            }
        }
        if (arrayList.isEmpty()) {
            f5 = 0.0f;
            f4 = 0.0f;
            f3 = 0.0f;
            f2 = 0.0f;
        }
        return new IiIIii_Class20(fArray, arrayList.size(), f2, f3, f4, f5, f);
    }

    private static void I_method_9ea0cc3d(List<double[]> list, double d, double d2, double d3, double d4) {
        if (d != d3 || d2 != d4) {
            IiIIii_Class20.i_method_1ed2a81d(list, d, d2, d3, d4);
        }
    }

    private static void i_method_1ed2a81d(List<double[]> list, double d, double d2, double d3, double d4) {
        if (d == d3 && d2 == d4) {
            return;
        }
        list.add(new double[]{d, d2, (d + d3) * 0.5, (d2 + d4) * 0.5, d3, d4});
    }

    private static void I_method_79aab8bd(List<double[]> list, double d, double d2, double d3, double d4, double d5, double d6) {
        if (d == d5 && d2 == d6 && d == d3 && d2 == d4) {
            return;
        }
        list.add(new double[]{d, d2, d3, d4, d5, d6});
    }

    private static void I_method_b9eb853d(List<double[]> list, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = d7 - 3.0 * d5 + 3.0 * d3 - d;
        double d10 = d8 - 3.0 * d6 + 3.0 * d4 - d2;
        double d11 = Math.sqrt(d9 * d9 + d10 * d10) * Math.sqrt(3.0) / 18.0;
        int n = d11 <= 2.44140625E-4 ? 1 : (int)Math.ceil(Math.cbrt(d11 / 2.44140625E-4));
        n = Math.max(1, Math.min(n, 16));
        double d12 = d;
        double d13 = d2;
        for (int i = 1; i <= n; ++i) {
            double d14 = ((double)i - 1.0) / (double)n;
            double d15 = (double)i / (double)n;
            double d16 = IiIIii_Class20.I_method_8f7121e0(d, d3, d5, d7, d15);
            double d17 = IiIIii_Class20.I_method_8f7121e0(d2, d4, d6, d8, d15);
            double d18 = (d15 - d14) * 0.5;
            double d19 = d12 + IiIIii_Class20.i_method_17ff0200(d, d3, d5, d7, d14) * d18;
            double d20 = d13 + IiIIii_Class20.i_method_17ff0200(d2, d4, d6, d8, d14) * d18;
            IiIIii_Class20.I_method_79aab8bd(list, d12, d13, d19, d20, d16, d17);
            d12 = d16;
            d13 = d17;
        }
    }

    private static double I_method_8f7121e0(double d, double d2, double d3, double d4, double d5) {
        double d6 = 1.0 - d5;
        return d6 * d6 * d6 * d + 3.0 * d6 * d6 * d5 * d2 + 3.0 * d6 * d5 * d5 * d3 + d5 * d5 * d5 * d4;
    }

    private static double i_method_17ff0200(double d, double d2, double d3, double d4, double d5) {
        double d6 = 1.0 - d5;
        return 3.0 * (d6 * d6 * (d2 - d) + 2.0 * d6 * d5 * (d3 - d2) + d5 * d5 * (d4 - d3));
    }
}

