package rockstar.client;

import lombok.Generated;

public abstract class iIiIIiIII_Class329 {
    private final String I_field_523beb0a;
    protected final int I_field_49;

    public iIiIIiIII_Class329(String string, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The number of function arguments can not be less than 0 for '" + string + "'");
        }
        if (!iIiIIiIII_Class329.I_method_9c04ea2d(string)) {
            throw new IllegalArgumentException("The function name '" + string + "' is invalid");
        }
        this.I_field_523beb0a = string;
        this.I_field_49 = n;
    }

    public iIiIIiIII_Class329(String string) {
        this(string, 1);
    }

    public abstract double I_method_6ec8da96(double ... var1);

    public static boolean I_method_9c04ea2d(String string) {
        if (string == null) {
            return false;
        }
        int n = string.length();
        if (n == 0) {
            return false;
        }
        for (int i = 0; i < n; ++i) {
            char c = string.charAt(i);
            if (Character.isLetter(c) || c == '_' || Character.isDigit(c) && i > 0) continue;
            return false;
        }
        return true;
    }

    @Generated
    public String I_method_a4e12c61() {
        return this.I_field_523beb0a;
    }

    @Generated
    public int I_method_66246a12() {
        return this.I_field_49;
    }
}

