package rockstar.client;

import rockstar.client.iIiIIiIiI_Class331;

public abstract class iIiIIiIii_Class332 {
    private static final int I_field_49 = 0;
    private static final int i_field_49 = 1;
    private static final int II_field_49 = 2;
    private static final int Ii_field_49 = 3;
    private static final int iI_field_49 = 4;
    private static final int ii_field_49 = 5;
    private static final int III_field_49 = 6;
    private static final int IIi_field_49 = 7;
    private static final iIiIIiIiI_Class331[] I_field_bee7151 = new iIiIIiIiI_Class331[8];

    public static iIiIIiIiI_Class331 I_method_181465fb(char c, int n) {
        switch (c) {
            case '+': {
                if (n != 1) {
                    return I_field_bee7151[0];
                }
                return I_field_bee7151[7];
            }
            case '-': {
                if (n != 1) {
                    return I_field_bee7151[1];
                }
                return I_field_bee7151[6];
            }
            case '*': {
                return I_field_bee7151[2];
            }
            case '/': 
            case '\u00f7': {
                return I_field_bee7151[3];
            }
            case '^': {
                return I_field_bee7151[4];
            }
            case '%': {
                return I_field_bee7151[5];
            }
        }
        return null;
    }

    static {
        iIiIIiIii_Class332.I_field_bee7151[0] = new iIiIIiIiI_Class331("+", 2, true, 500){

            @Override
            public double I_method_f756bab6(double ... dArray) {
                return dArray[0] + dArray[1];
            }
        };
        iIiIIiIii_Class332.I_field_bee7151[1] = new iIiIIiIiI_Class331("-", 2, true, 500){

            @Override
            public double I_method_f756bab6(double ... dArray) {
                return dArray[0] - dArray[1];
            }
        };
        iIiIIiIii_Class332.I_field_bee7151[6] = new iIiIIiIiI_Class331("-", 1, false, 5000){

            @Override
            public double I_method_f756bab6(double ... dArray) {
                return -dArray[0];
            }
        };
        iIiIIiIii_Class332.I_field_bee7151[7] = new iIiIIiIiI_Class331("+", 1, false, 5000){

            @Override
            public double I_method_f756bab6(double ... dArray) {
                return dArray[0];
            }
        };
        iIiIIiIii_Class332.I_field_bee7151[2] = new iIiIIiIiI_Class331("*", 2, true, 1000){

            @Override
            public double I_method_f756bab6(double ... dArray) {
                return dArray[0] * dArray[1];
            }
        };
        iIiIIiIii_Class332.I_field_bee7151[3] = new iIiIIiIiI_Class331("/", 2, true, 1000){

            @Override
            public double I_method_f756bab6(double ... dArray) {
                if (dArray[1] == 0.0) {
                    throw new ArithmeticException("Division by zero!");
                }
                return dArray[0] / dArray[1];
            }
        };
        iIiIIiIii_Class332.I_field_bee7151[4] = new iIiIIiIiI_Class331("^", 2, false, 10000){

            @Override
            public double I_method_f756bab6(double ... dArray) {
                return Math.pow(dArray[0], dArray[1]);
            }
        };
        iIiIIiIii_Class332.I_field_bee7151[5] = new iIiIIiIiI_Class331("%", 2, true, 1000){

            @Override
            public double I_method_f756bab6(double ... dArray) {
                if (dArray[1] == 0.0) {
                    throw new ArithmeticException("Division by zero!");
                }
                return dArray[0] % dArray[1];
            }
        };
    }
}

