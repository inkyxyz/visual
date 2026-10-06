package rockstar.client;

import rockstar.client.iiiiiiIi_Class254;
import rockstar.client.iiiiiiiI_Class255;

public final class iiiiiIii_Class252 {
    private static final float[] I_field_b4b = new float[]{-60.0f, -35.0f, -15.0f, 0.0f, 15.0f, 40.0f, 65.0f, 90.0f};
    private static final double I_field_44 = 50.0;
    private static final double i_field_44 = 100.0;
    private static final double II_field_44 = Double.NEGATIVE_INFINITY;
    private final iiiiiiIi_Class254.Nested1_c98030f3[] I_field_93fa57b7 = iiiiiIii_Class252.I_method_143ed378(I_field_b4b.length);
    private final iiiiiiIi_Class254.Nested1_c98030f3[] i_field_93fa57b7 = iiiiiIii_Class252.I_method_143ed378(I_field_b4b.length);
    private final double[] I_field_b49 = new double[I_field_b4b.length];
    private final double[] i_field_b49 = new double[I_field_b4b.length];
    private final float[] i_field_b4b = new float[I_field_b4b.length];
    private final float[] II_field_b4b = new float[I_field_b4b.length];
    private final float[] Ii_field_b4b = new float[I_field_b4b.length];
    private final int I_field_49;
    private final iiiiiiIi_Class254.Nested1_c98030f3 I_field_e4941ddc = new iiiiiiIi_Class254.Nested1_c98030f3();

    public iiiiiIii_Class252(int n) {
        this.I_field_49 = Math.max(2, n);
    }

    private static iiiiiiIi_Class254.Nested1_c98030f3[] I_method_143ed378(int n) {
        iiiiiiIi_Class254.Nested1_c98030f3[] nested1_c98030f3Array = new iiiiiiIi_Class254.Nested1_c98030f3[n];
        for (int i = 0; i < n; ++i) {
            nested1_c98030f3Array[i] = new iiiiiiIi_Class254.Nested1_c98030f3();
        }
        return nested1_c98030f3Array;
    }

    public float I_method_37c8332a(iiiiiiIi_Class254.Nested1_c98030f3 nested1_c98030f3, float f, float f2, iiiiiiiI_Class255 iiiiiiiI_Class2552, int n) {
        float f3 = f;
        double d = Double.NEGATIVE_INFINITY;
        int n2 = 0;
        for (float f4 : I_field_b4b) {
            float f5 = iiiiiIii_Class252.I_method_4ec71f44(f, f4, f2);
            boolean bl = false;
            for (int i = 0; i < n2; ++i) {
                if (this.Ii_field_b4b[i] != f5) continue;
                bl = true;
                break;
            }
            if (bl) continue;
            this.Ii_field_b4b[n2++] = f5;
            double d2 = this.I_method_37c83328(nested1_c98030f3, f5, f2, iiiiiiiI_Class2552, n);
            if (!(d2 > d)) continue;
            d = d2;
            f3 = f5;
        }
        return f3;
    }

    private double I_method_37c83328(iiiiiiIi_Class254.Nested1_c98030f3 nested1_c98030f3, float f, float f2, iiiiiiiI_Class255 iiiiiiiI_Class2552, int n) {
        int n2;
        for (n2 = 0; n2 < I_field_b4b.length; ++n2) {
            this.I_field_b49[n2] = Double.NEGATIVE_INFINITY;
        }
        this.I_field_93fa57b7[0].I_method_27565e83(nested1_c98030f3);
        this.I_field_b49[0] = iiiiiIii_Class252.I_method_4f64c0f8(this.I_field_93fa57b7[0], f, iiiiiiiI_Class2552, n);
        this.i_field_b4b[0] = f;
        for (n2 = 1; n2 < this.I_field_49; ++n2) {
            int n3;
            for (n3 = 0; n3 < I_field_b4b.length; ++n3) {
                this.i_field_b49[n3] = Double.NEGATIVE_INFINITY;
            }
            for (n3 = 0; n3 < I_field_b4b.length; ++n3) {
                if (this.I_field_b49[n3] == Double.NEGATIVE_INFINITY) continue;
                for (int i = 0; i < I_field_b4b.length; ++i) {
                    float f3 = iiiiiIii_Class252.I_method_4ec71f44(this.i_field_b4b[n3], I_field_b4b[i], f2);
                    this.I_field_e4941ddc.I_method_27565e83(this.I_field_93fa57b7[n3]);
                    double d = this.I_field_b49[n3] + iiiiiIii_Class252.I_method_4f64c0f8(this.I_field_e4941ddc, f3, iiiiiiiI_Class2552, n);
                    if (!(d > this.i_field_b49[i])) continue;
                    this.i_field_b49[i] = d;
                    this.II_field_b4b[i] = f3;
                    this.i_field_93fa57b7[i].I_method_27565e83(this.I_field_e4941ddc);
                }
            }
            for (n3 = 0; n3 < I_field_b4b.length; ++n3) {
                this.I_field_b49[n3] = this.i_field_b49[n3];
                this.i_field_b4b[n3] = this.II_field_b4b[n3];
                if (this.i_field_b49[n3] == Double.NEGATIVE_INFINITY) continue;
                this.I_field_93fa57b7[n3].I_method_27565e83(this.i_field_93fa57b7[n3]);
            }
        }
        double d = Double.NEGATIVE_INFINITY;
        for (double d2 : this.I_field_b49) {
            d = Math.max(d, d2);
        }
        return d;
    }

    private static double I_method_4f64c0f8(iiiiiiIi_Class254.Nested1_c98030f3 nested1_c98030f3, float f, iiiiiiiI_Class255 iiiiiiiI_Class2552, int n) {
        double d = nested1_c98030f3.I_field_44;
        double d2 = d + nested1_c98030f3.II_field_44;
        double d3 = nested1_c98030f3.II_field_44;
        boolean bl = iiiiiiIi_Class254.I_method_fa24397f(nested1_c98030f3, f, iiiiiiiI_Class2552.I_method_2bca5cc0(d), iiiiiiiI_Class2552.I_method_2bca5cc0(d2), iiiiiiiI_Class2552.i_method_2d8d4ce0(d2), n);
        double d4 = bl ? 50.0 + 100.0 * Math.max(0.0, d3) : 0.0;
        return nested1_c98030f3.I_field_44 - d - d4;
    }

    private static float I_method_4ec71f44(float f, float f2, float f3) {
        float f4 = f2 - f;
        if (f4 > f3) {
            return f + f3;
        }
        if (f4 < -f3) {
            return f - f3;
        }
        return f2;
    }
}

