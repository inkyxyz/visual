package rockstar.client;

public final class iiiiiiIi_Class254 {
    public static final double I_field_44 = 0.08;
    private static final double iI_field_44 = 0.13;
    private static final double ii_field_44 = 0.546;
    private static final double III_field_44 = 0.026;
    private static final double IIi_field_44 = 0.91;
    public static final double i_field_44 = 0.42;
    public static final double II_field_44 = 0.2;
    public static final double Ii_field_44 = 0.6;

    private iiiiiiIi_Class254() {
    }

    public static boolean I_method_fa24397f(Nested1_c98030f3 nested1_c98030f3, double d, double d2, double d3, double d4, int n) {
        double d5;
        boolean bl;
        boolean bl2;
        boolean bl3 = nested1_c98030f3.i_field_5a || !nested1_c98030f3.I_field_5a;
        boolean bl4 = bl2 = bl3 && !nested1_c98030f3.II_field_5a;
        if (bl2 && nested1_c98030f3.i_field_5a) {
            nested1_c98030f3.Ii_field_44 = Math.max(0.42, nested1_c98030f3.Ii_field_44);
            nested1_c98030f3.II_field_44 += 0.2;
        }
        if (bl2 && !nested1_c98030f3.i_field_5a && !nested1_c98030f3.I_field_5a) {
            nested1_c98030f3.I_field_5a = true;
        }
        if (nested1_c98030f3.I_field_5a) {
            iiiiiiIi_Class254.I_method_4bcf1236(nested1_c98030f3, d);
        } else if (nested1_c98030f3.i_field_5a) {
            nested1_c98030f3.II_field_44 = (nested1_c98030f3.II_field_44 + 0.13) * 0.546;
            nested1_c98030f3.Ii_field_44 = (nested1_c98030f3.Ii_field_44 - 0.08) * 0.98;
        } else {
            nested1_c98030f3.II_field_44 = (nested1_c98030f3.II_field_44 + 0.026) * 0.91;
            nested1_c98030f3.Ii_field_44 = (nested1_c98030f3.Ii_field_44 - 0.08) * 0.98;
        }
        if (nested1_c98030f3.I_field_49 >= 0 && --nested1_c98030f3.I_field_49 < 0) {
            nested1_c98030f3.I_field_5a = false;
        }
        double d6 = nested1_c98030f3.i_field_44 + nested1_c98030f3.Ii_field_44;
        boolean bl5 = bl = d4 > d2 + 0.6 && d4 > Math.max(nested1_c98030f3.i_field_44, d6);
        if (bl) {
            nested1_c98030f3.II_field_44 = 0.0;
        } else {
            nested1_c98030f3.I_field_44 += nested1_c98030f3.II_field_44;
        }
        double d7 = d5 = bl ? d2 : d3;
        if (d6 <= d5) {
            nested1_c98030f3.i_field_44 = d5;
            nested1_c98030f3.Ii_field_44 = 0.0;
            nested1_c98030f3.i_field_5a = true;
            if (nested1_c98030f3.I_field_49 < 0 && nested1_c98030f3.I_field_5a) {
                nested1_c98030f3.I_field_49 = n;
            }
        } else {
            nested1_c98030f3.i_field_44 = d6;
            nested1_c98030f3.i_field_5a = false;
        }
        nested1_c98030f3.II_field_5a = bl2;
        return bl;
    }

    private static void I_method_4bcf1236(Nested1_c98030f3 nested1_c98030f3, double d) {
        double d2;
        double d3 = Math.toRadians(d);
        double d4 = Math.cos(d3);
        double d5 = d4 * d4;
        double d6 = Math.abs(nested1_c98030f3.II_field_44);
        nested1_c98030f3.Ii_field_44 += 0.08 * (-1.0 + d5 * 0.75);
        if (nested1_c98030f3.Ii_field_44 < 0.0 && d4 > 0.0) {
            d2 = nested1_c98030f3.Ii_field_44 * -0.1 * d5;
            nested1_c98030f3.II_field_44 += d2;
            nested1_c98030f3.Ii_field_44 += d2;
        }
        if (d3 < 0.0 && d4 > 0.0) {
            d2 = d6 * -Math.sin(d3) * 0.04;
            nested1_c98030f3.II_field_44 -= d2;
            nested1_c98030f3.Ii_field_44 += d2 * 3.2;
        }
        if (d4 > 0.0) {
            nested1_c98030f3.II_field_44 += (d6 - nested1_c98030f3.II_field_44) * 0.1;
        }
        nested1_c98030f3.II_field_44 *= 0.99;
        nested1_c98030f3.Ii_field_44 *= 0.98;
    }

    public static final class Nested1_c98030f3 {
        public double I_field_44;
        public double i_field_44;
        public double II_field_44;
        public double Ii_field_44;
        public boolean I_field_5a;
        public boolean i_field_5a;
        public boolean II_field_5a;
        public int I_field_49;

        public void I_method_27565e83(Nested1_c98030f3 nested1_c98030f3) {
            this.I_field_44 = nested1_c98030f3.I_field_44;
            this.i_field_44 = nested1_c98030f3.i_field_44;
            this.II_field_44 = nested1_c98030f3.II_field_44;
            this.Ii_field_44 = nested1_c98030f3.Ii_field_44;
            this.I_field_5a = nested1_c98030f3.I_field_5a;
            this.i_field_5a = nested1_c98030f3.i_field_5a;
            this.II_field_5a = nested1_c98030f3.II_field_5a;
            this.I_field_49 = nested1_c98030f3.I_field_49;
        }
    }
}

