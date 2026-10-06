package rockstar.client;

import java.util.UUID;

public class iIiIIii_Class84 {
    private static final String I_field_523beb0a = "(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)";
    private static final String i_field_523beb0a = "(\\p{XDigit}{8})-(\\p{XDigit}{4})-(\\p{XDigit}{4})-(\\p{XDigit}{4})-(\\p{XDigit}+)";

    public static UUID I_method_3ea58b61(String string) {
        if (string != null) {
            return UUID.fromString(string.replaceFirst(I_field_523beb0a, "$1-$2-$3-$4-$5"));
        }
        return null;
    }

    public static String I_method_380805cd(UUID uUID) {
        if (uUID != null) {
            return uUID.toString().replace("-", "");
        }
        return null;
    }

    public static boolean I_method_8bd606d(String string) {
        return string.matches(I_field_523beb0a);
    }

    public static boolean i_method_d974b44d(String string) {
        return string.matches(i_field_523beb0a);
    }
}

