package rockstar.client;

import lombok.Generated;

public abstract class iIiIIiIiI_Class331 {
    public static final int I_field_49 = 500;
    public static final int i_field_49 = 500;
    public static final int II_field_49 = 1000;
    public static final int Ii_field_49 = 1000;
    public static final int iI_field_49 = 1000;
    public static final int ii_field_49 = 10000;
    public static final int III_field_49 = 5000;
    public static final int IIi_field_49 = 5000;
    public static final char[] I_field_b48 = new char[]{'+', '-', '*', '/', '%', '^', '!', '#', '\u00a7', '$', '&', ';', ':', '~', '<', '>', '|', '=', '\u00f7', '\u221a', '\u221b', '\u2308', '\u230a'};
    private final int IiI_field_49;
    private final boolean I_field_5a;
    private final String I_field_523beb0a;
    private final int Iii_field_49;

    public iIiIIiIiI_Class331(String string, int n, boolean bl, int n2) {
        this.IiI_field_49 = n;
        this.I_field_5a = bl;
        this.I_field_523beb0a = string;
        this.Iii_field_49 = n2;
    }

    public static boolean I_method_5a8ed222(char c) {
        for (char c2 : I_field_b48) {
            if (c != c2) continue;
            return true;
        }
        return false;
    }

    public abstract double I_method_f756bab6(double ... var1);

    @Generated
    public int I_method_2ebd232() {
        return this.IiI_field_49;
    }

    @Generated
    public boolean I_method_2ebd243() {
        return this.I_field_5a;
    }

    @Generated
    public String I_method_25130841() {
        return this.I_field_523beb0a;
    }

    @Generated
    public int i_method_2fa5e12() {
        return this.Iii_field_49;
    }
}

