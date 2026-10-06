package rockstar.client;

import lombok.Generated;

class iIiIiIiIi_Class342
extends IllegalArgumentException {
    private static final long I_field_4a = 1L;
    private final String I_field_523beb0a;
    private final String i_field_523beb0a;
    private final String II_field_523beb0a;
    private final int I_field_49;

    public iIiIiIiIi_Class342(String string, int n, int n2) {
        this.i_field_523beb0a = string;
        this.II_field_523beb0a = iIiIiIiIi_Class342.I_method_d35fc7f7(string, n, n2);
        this.I_field_49 = n;
        this.I_field_523beb0a = "Unknown function or variable '" + this.II_field_523beb0a + "' at pos " + n + " in expression '" + string + "'";
    }

    private static String I_method_d35fc7f7(String string, int n, int n2) {
        int n3;
        int n4 = string.length();
        if (n4 < (n3 = n + n2 - 1)) {
            n3 = n4;
        }
        return string.substring(n, n3);
    }

    @Override
    public String getMessage() {
        return this.I_field_523beb0a;
    }

    @Generated
    public String I_method_6015a8e1() {
        return this.i_field_523beb0a;
    }

    @Generated
    public String i_method_f3345901() {
        return this.II_field_523beb0a;
    }

    @Generated
    public int I_method_99855d92() {
        return this.I_field_49;
    }
}

