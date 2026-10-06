package rockstar.client;

import rockstar.client.IiIIiI_Class19;
import rockstar.client.IiIIii_Class20;

public final class IiIiII_Class21 {
    public static final int I_field_49 = 4096;
    public static final int i_field_49 = 12;
    public static final int II_field_49 = 1024;
    private static final int Ii_field_49 = 16;
    private float[] I_field_b4b = new float[262144];
    private int[] I_field_b4e = new int[131072];
    private float[] i_field_b4b = new float[131072];
    private int iI_field_49 = 16;
    private int ii_field_49 = 16;
    private int III_field_49 = 16;
    private int IIi_field_49;
    private int IiI_field_49;
    private int Iii_field_49;
    private int iII_field_49;
    private int iIi_field_49;
    private int iiI_field_49;
    private int iii_field_49;
    private int IIII_field_49;
    private boolean I_field_5a;
    private boolean i_field_5a;
    private boolean II_field_5a;

    public int I_method_6c743e1f() {
        return this.iIi_field_49;
    }

    public float[] I_method_22138835() {
        return this.I_field_b4b;
    }

    public int[] I_method_22138838() {
        return this.I_field_b4e;
    }

    public float[] i_method_23d67855() {
        return this.i_field_b4b;
    }

    public int i_method_6c82c9ff() {
        return this.iI_field_49;
    }

    public int II_method_22227ea8() {
        return this.ii_field_49;
    }

    public int Ii_method_22310a88() {
        return this.III_field_49;
    }

    public int iI_method_23e56ec8() {
        return this.iiI_field_49;
    }

    public int ii_method_23f3faa8() {
        return this.iii_field_49;
    }

    public int III_method_223c4f3f() {
        return this.IIII_field_49;
    }

    public boolean I_method_6c743e30() {
        return this.I_field_5a;
    }

    public boolean i_method_6c82ca10() {
        return this.i_field_5a;
    }

    public boolean II_method_22227eb9() {
        return this.II_field_5a;
    }

    public void I_method_6c743e2c() {
        this.IIII_field_49 = 0;
        this.iii_field_49 = 0;
        this.iiI_field_49 = 0;
        this.II_field_5a = false;
        this.i_field_5a = false;
        this.I_field_5a = false;
    }

    public int I_method_46a6e700(IiIIiI_Class19 iiIIiI_Class19) {
        int n;
        int n2;
        int n3;
        IiIIii_Class20 iiIIii_Class20 = iiIIiI_Class19.I_field_ba459e01;
        int n4 = iiIIii_Class20.I_field_49;
        int[] nArray = new int[n4];
        int[] nArray2 = new int[n4];
        for (n3 = 0; n3 < n4; ++n3) {
            if (this.IIi_field_49 + 2 > 4096) {
                this.IIi_field_49 = 0;
                ++this.IiI_field_49;
            }
            this.I_method_2213fa57(this.IiI_field_49 + 1);
            nArray[n3] = this.IIi_field_49;
            nArray2[n3] = this.IiI_field_49;
            n2 = (this.IiI_field_49 * 4096 + this.IIi_field_49) * 4;
            n = n3 * 6;
            this.I_field_b4b[n2] = iiIIii_Class20.I_field_b4b[n];
            this.I_field_b4b[n2 + 1] = iiIIii_Class20.I_field_b4b[n + 1];
            this.I_field_b4b[n2 + 2] = iiIIii_Class20.I_field_b4b[n + 2];
            this.I_field_b4b[n2 + 3] = iiIIii_Class20.I_field_b4b[n + 3];
            this.I_field_b4b[n2 + 4] = iiIIii_Class20.I_field_b4b[n + 4];
            this.I_field_b4b[n2 + 5] = iiIIii_Class20.I_field_b4b[n + 5];
            this.I_field_b4b[n2 + 6] = 0.0f;
            this.I_field_b4b[n2 + 7] = 0.0f;
            this.iiI_field_49 = Math.max(this.iiI_field_49, this.IiI_field_49 + 1);
            this.IIi_field_49 += 2;
        }
        n3 = iiIIiI_Class19.i_field_49 + iiIIiI_Class19.I_field_49;
        if (this.Iii_field_49 + n3 > 4096) {
            this.Iii_field_49 = 0;
            ++this.iII_field_49;
        }
        n2 = iiIIiI_Class19.I_method_d160a5f();
        this.i_method_23d6ea77(this.iII_field_49 + (this.Iii_field_49 + n2) / 4096 + 1);
        n = this.Iii_field_49;
        int n5 = this.iII_field_49;
        int n6 = n3;
        int n7 = 0;
        for (int[] nArray3 : iiIIiI_Class19.I_field_160e9) {
            n6 = this.I_method_7e3ea0ed(n, n5, n7++, nArray3, n6, nArray, nArray2);
        }
        for (int[] nArray3 : iiIIiI_Class19.i_field_160e9) {
            n6 = this.I_method_7e3ea0ed(n, n5, n7++, nArray3, n6, nArray, nArray2);
        }
        int n8 = n + n6;
        this.Iii_field_49 = n8 & 0xFFF;
        this.iII_field_49 = n5 + (n8 >> 12);
        this.iii_field_49 = Math.max(this.iii_field_49, this.iII_field_49 + 1);
        int n9 = this.iIi_field_49++;
        this.II_method_222dcaee(n9 / 1024 + 1);
        int n10 = n9 * 8;
        this.i_field_b4b[n10] = iiIIiI_Class19.I_field_46;
        this.i_field_b4b[n10 + 1] = iiIIiI_Class19.i_field_46;
        this.i_field_b4b[n10 + 2] = iiIIiI_Class19.II_field_46;
        this.i_field_b4b[n10 + 3] = iiIIiI_Class19.Ii_field_46;
        this.i_field_b4b[n10 + 4] = n;
        this.i_field_b4b[n10 + 5] = n5;
        this.i_field_b4b[n10 + 6] = iiIIiI_Class19.I_field_49 - 1;
        this.i_field_b4b[n10 + 7] = iiIIiI_Class19.i_field_49 - 1;
        this.IIII_field_49 = Math.max(this.IIII_field_49, n9 / 1024 + 1);
        return n9;
    }

    private int I_method_7e3ea0ed(int n, int n2, int n3, int[] nArray, int n4, int[] nArray2, int[] nArray3) {
        int n5 = n + n4 & 0xFFF;
        if (n5 + nArray.length > 4096) {
            n4 += 4096 - n5;
        }
        this.I_method_de571f97(n, n2, n3, nArray.length, n4);
        for (int i = 0; i < nArray.length; ++i) {
            this.I_method_de571f97(n, n2, n4 + i, nArray2[nArray[i]], nArray3[nArray[i]]);
        }
        return n4 + nArray.length;
    }

    private void I_method_de571f97(int n, int n2, int n3, int n4, int n5) {
        int n6 = n + n3;
        int n7 = n2 + (n6 >> 12);
        this.i_method_23d6ea77(n7 + 1);
        int n8 = (n7 * 4096 + (n6 &= 0xFFF)) * 2;
        this.I_field_b4e[n8] = n4;
        this.I_field_b4e[n8 + 1] = n5;
        this.iii_field_49 = Math.max(this.iii_field_49, n7 + 1);
    }

    private void I_method_2213fa57(int n) {
        int n2;
        if (n <= this.iI_field_49) {
            return;
        }
        for (n2 = this.iI_field_49; n2 < n; n2 *= 2) {
        }
        float[] fArray = new float[4096 * n2 * 4];
        System.arraycopy(this.I_field_b4b, 0, fArray, 0, this.I_field_b4b.length);
        this.I_field_b4b = fArray;
        this.iI_field_49 = n2;
        this.I_field_5a = true;
        this.iiI_field_49 = Math.max(this.iiI_field_49, this.IiI_field_49 + 1);
    }

    private void i_method_23d6ea77(int n) {
        int n2;
        if (n <= this.ii_field_49) {
            return;
        }
        for (n2 = this.ii_field_49; n2 < n; n2 *= 2) {
        }
        int[] nArray = new int[4096 * n2 * 2];
        System.arraycopy(this.I_field_b4e, 0, nArray, 0, this.I_field_b4e.length);
        this.I_field_b4e = nArray;
        this.ii_field_49 = n2;
        this.i_field_5a = true;
        this.iii_field_49 = Math.max(this.iii_field_49, this.iII_field_49 + 1);
    }

    private void II_method_222dcaee(int n) {
        int n2;
        if (n <= this.III_field_49) {
            return;
        }
        for (n2 = this.III_field_49; n2 < n; n2 *= 2) {
        }
        float[] fArray = new float[2048 * n2 * 4];
        System.arraycopy(this.i_field_b4b, 0, fArray, 0, this.i_field_b4b.length);
        this.i_field_b4b = fArray;
        this.III_field_49 = n2;
        this.II_field_5a = true;
    }
}

