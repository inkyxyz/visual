package rockstar.client;

import rockstar.client.iIiIIiIII_Class329;

public class iIiIIiIIi_Class330 {
    private static final int I_field_49 = 0;
    private static final int i_field_49 = 1;
    private static final int II_field_49 = 2;
    private static final int Ii_field_49 = 3;
    private static final int iI_field_49 = 4;
    private static final int ii_field_49 = 5;
    private static final int III_field_49 = 6;
    private static final int IIi_field_49 = 7;
    private static final int IiI_field_49 = 8;
    private static final int Iii_field_49 = 9;
    private static final int iII_field_49 = 10;
    private static final int iIi_field_49 = 11;
    private static final int iiI_field_49 = 12;
    private static final int iii_field_49 = 13;
    private static final int IIII_field_49 = 14;
    private static final int IIIi_field_49 = 15;
    private static final int IIiI_field_49 = 16;
    private static final int IIii_field_49 = 17;
    private static final int IiII_field_49 = 18;
    private static final int IiIi_field_49 = 19;
    private static final int IiiI_field_49 = 20;
    private static final int Iiii_field_49 = 21;
    private static final int iIII_field_49 = 22;
    private static final int iIIi_field_49 = 23;
    private static final int iIiI_field_49 = 24;
    private static final int iIii_field_49 = 25;
    private static final int iiII_field_49 = 26;
    private static final int iiIi_field_49 = 27;
    private static final int iiiI_field_49 = 28;
    private static final int iiii_field_49 = 29;
    private static final int IIIII_field_49 = 30;
    private static final iIiIIiIII_Class329[] I_field_bedf931 = new iIiIIiIII_Class329[31];

    public static iIiIIiIII_Class329 I_method_8be9965f(String string) {
        return switch (string) {
            case "sin" -> I_field_bedf931[0];
            case "cos" -> I_field_bedf931[1];
            case "tan" -> I_field_bedf931[2];
            case "cot" -> I_field_bedf931[5];
            case "asin" -> I_field_bedf931[12];
            case "acos" -> I_field_bedf931[13];
            case "atan" -> I_field_bedf931[14];
            case "sinh" -> I_field_bedf931[6];
            case "cosh" -> I_field_bedf931[7];
            case "tanh" -> I_field_bedf931[8];
            case "abs" -> I_field_bedf931[17];
            case "log" -> I_field_bedf931[25];
            case "log10" -> I_field_bedf931[23];
            case "log2" -> I_field_bedf931[24];
            case "log1p" -> I_field_bedf931[26];
            case "ceil" -> I_field_bedf931[18];
            case "floor" -> I_field_bedf931[19];
            case "sqrt" -> I_field_bedf931[15];
            case "cbrt" -> I_field_bedf931[16];
            case "pow" -> I_field_bedf931[20];
            case "exp" -> I_field_bedf931[21];
            case "expm1" -> I_field_bedf931[22];
            case "signum" -> I_field_bedf931[28];
            case "csc" -> I_field_bedf931[3];
            case "sec" -> I_field_bedf931[4];
            case "csch" -> I_field_bedf931[9];
            case "sech" -> I_field_bedf931[10];
            case "coth" -> I_field_bedf931[11];
            case "toradian" -> I_field_bedf931[29];
            case "todegree" -> I_field_bedf931[30];
            default -> null;
        };
    }

    static {
        iIiIIiIIi_Class330.I_field_bedf931[0] = new iIiIIiIII_Class329("sin"){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                return Math.sin(dArray[0]);
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[1] = new iIiIIiIII_Class329("cos"){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                return Math.cos(dArray[0]);
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[2] = new iIiIIiIII_Class329("tan"){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                return Math.tan(dArray[0]);
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[5] = new iIiIIiIII_Class329("cot"){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                double d = Math.tan(dArray[0]);
                if (d == 0.0) {
                    throw new ArithmeticException("Division by zero in cotangent!");
                }
                return 1.0 / d;
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[25] = new iIiIIiIII_Class329("log"){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                return Math.log(dArray[0]);
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[24] = new iIiIIiIII_Class329("log2"){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                return Math.log(dArray[0]) / Math.log(2.0);
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[23] = new iIiIIiIII_Class329("log10"){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                return Math.log10(dArray[0]);
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[26] = new iIiIIiIII_Class329("log1p"){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                return Math.log1p(dArray[0]);
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[17] = new iIiIIiIII_Class329("abs"){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                return Math.abs(dArray[0]);
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[13] = new iIiIIiIII_Class329("acos"){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                return Math.acos(dArray[0]);
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[12] = new iIiIIiIII_Class329("asin"){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                return Math.asin(dArray[0]);
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[14] = new iIiIIiIII_Class329("atan"){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                return Math.atan(dArray[0]);
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[16] = new iIiIIiIII_Class329("cbrt"){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                return Math.cbrt(dArray[0]);
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[19] = new iIiIIiIII_Class329("floor"){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                return Math.floor(dArray[0]);
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[6] = new iIiIIiIII_Class329("sinh"){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                return Math.sinh(dArray[0]);
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[15] = new iIiIIiIII_Class329("sqrt"){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                return Math.sqrt(dArray[0]);
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[8] = new iIiIIiIII_Class329("tanh"){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                return Math.tanh(dArray[0]);
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[7] = new iIiIIiIII_Class329("cosh"){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                return Math.cosh(dArray[0]);
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[18] = new iIiIIiIII_Class329("ceil"){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                return Math.ceil(dArray[0]);
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[20] = new iIiIIiIII_Class329("pow", 2){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                return Math.pow(dArray[0], dArray[1]);
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[21] = new iIiIIiIII_Class329("exp", 1){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                return Math.exp(dArray[0]);
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[22] = new iIiIIiIII_Class329("expm1", 1){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                return Math.expm1(dArray[0]);
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[28] = new iIiIIiIII_Class329("signum", 1){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                if (dArray[0] > 0.0) {
                    return 1.0;
                }
                if (dArray[0] < 0.0) {
                    return -1.0;
                }
                return 0.0;
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[3] = new iIiIIiIII_Class329("csc"){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                double d = Math.sin(dArray[0]);
                if (d == 0.0) {
                    throw new ArithmeticException("Division by zero in cosecant!");
                }
                return 1.0 / d;
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[4] = new iIiIIiIII_Class329("sec"){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                double d = Math.cos(dArray[0]);
                if (d == 0.0) {
                    throw new ArithmeticException("Division by zero in secant!");
                }
                return 1.0 / d;
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[9] = new iIiIIiIII_Class329("csch"){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                if (dArray[0] == 0.0) {
                    return 0.0;
                }
                return 1.0 / Math.sinh(dArray[0]);
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[10] = new iIiIIiIII_Class329("sech"){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                return 1.0 / Math.cosh(dArray[0]);
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[11] = new iIiIIiIII_Class329("coth"){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                return Math.cosh(dArray[0]) / Math.sinh(dArray[0]);
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[27] = new iIiIIiIII_Class329("logb", 2){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                return Math.log(dArray[1]) / Math.log(dArray[0]);
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[29] = new iIiIIiIII_Class329("toradian"){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                return Math.toRadians(dArray[0]);
            }
        };
        iIiIIiIIi_Class330.I_field_bedf931[30] = new iIiIIiIII_Class329("todegree"){

            @Override
            public double I_method_6ec8da96(double ... dArray) {
                return Math.toDegrees(dArray[0]);
            }
        };
    }
}

