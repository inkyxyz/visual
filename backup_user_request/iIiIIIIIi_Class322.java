package rockstar.client;

import java.util.Random;

public class iIiIIIIIi_Class322 {
    private final int[] I_field_b4e = new int[512];

    public iIiIIIIIi_Class322() {
        this(System.currentTimeMillis());
    }

    public iIiIIIIIi_Class322(long l) {
        int n;
        Random random = new Random(l);
        int[] nArray = new int[256];
        for (n = 0; n < 256; ++n) {
            nArray[n] = n;
        }
        for (n = 0; n < 256; ++n) {
            int n2 = random.nextInt(256 - n) + n;
            int n3 = nArray[n];
            nArray[n] = nArray[n2];
            nArray[n2] = n3;
        }
        for (n = 0; n < 256; ++n) {
            int n4 = nArray[n];
            this.I_field_b4e[n + 256] = n4;
            this.I_field_b4e[n] = n4;
        }
    }

    public double I_method_72027e2d(double d) {
        return this.I_method_fb67f22d(d, 0.0, 0.0);
    }

    public double I_method_ce4da9cd(double d, double d2) {
        return this.I_method_fb67f22d(d, d2, 0.0);
    }

    public double I_method_fb67f22d(double d, double d2, double d3) {
        int n = (int)Math.floor(d) & 0xFF;
        int n2 = (int)Math.floor(d2) & 0xFF;
        int n3 = (int)Math.floor(d3) & 0xFF;
        d -= Math.floor(d);
        d2 -= Math.floor(d2);
        d3 -= Math.floor(d3);
        double d4 = iIiIIIIIi_Class322.i_method_73c56e4d(d);
        double d5 = iIiIIIIIi_Class322.i_method_73c56e4d(d2);
        double d6 = iIiIIIIIi_Class322.i_method_73c56e4d(d3);
        int n4 = this.I_field_b4e[n] + n2;
        int n5 = this.I_field_b4e[n4] + n3;
        int n6 = this.I_field_b4e[n4 + 1] + n3;
        int n7 = this.I_field_b4e[n + 1] + n2;
        int n8 = this.I_field_b4e[n7] + n3;
        int n9 = this.I_field_b4e[n7 + 1] + n3;
        return iIiIIIIIi_Class322.i_method_982f5a4d(d6, iIiIIIIIi_Class322.i_method_982f5a4d(d5, iIiIIIIIi_Class322.i_method_982f5a4d(d4, iIiIIIIIi_Class322.I_method_7a1ef0e8(this.I_field_b4e[n5], d, d2, d3), iIiIIIIIi_Class322.I_method_7a1ef0e8(this.I_field_b4e[n8], d - 1.0, d2, d3)), iIiIIIIIi_Class322.i_method_982f5a4d(d4, iIiIIIIIi_Class322.I_method_7a1ef0e8(this.I_field_b4e[n6], d, d2 - 1.0, d3), iIiIIIIIi_Class322.I_method_7a1ef0e8(this.I_field_b4e[n9], d - 1.0, d2 - 1.0, d3))), iIiIIIIIi_Class322.i_method_982f5a4d(d5, iIiIIIIIi_Class322.i_method_982f5a4d(d4, iIiIIIIIi_Class322.I_method_7a1ef0e8(this.I_field_b4e[n5 + 1], d, d2, d3 - 1.0), iIiIIIIIi_Class322.I_method_7a1ef0e8(this.I_field_b4e[n8 + 1], d - 1.0, d2, d3 - 1.0)), iIiIIIIIi_Class322.i_method_982f5a4d(d4, iIiIIIIIi_Class322.I_method_7a1ef0e8(this.I_field_b4e[n6 + 1], d, d2 - 1.0, d3 - 1.0), iIiIIIIIi_Class322.I_method_7a1ef0e8(this.I_field_b4e[n9 + 1], d - 1.0, d2 - 1.0, d3 - 1.0))));
    }

    private static double i_method_73c56e4d(double d) {
        return d * d * d * (d * (d * 6.0 - 15.0) + 10.0);
    }

    private static double i_method_982f5a4d(double d, double d2, double d3) {
        return d2 + d * (d3 - d2);
    }

    private static double I_method_7a1ef0e8(int n, double d, double d2, double d3) {
        double d4;
        int n2 = n & 0xF;
        double d5 = d4 = n2 < 8 ? d : d2;
        double d6 = n2 < 4 ? d2 : (n2 == 12 || n2 == 14 ? d : d3);
        return ((n2 & 1) == 0 ? d4 : -d4) + ((n2 & 2) == 0 ? d6 : -d6);
    }
}

