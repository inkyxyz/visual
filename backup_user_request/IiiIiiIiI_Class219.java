package rockstar.client;

import java.text.Normalizer;
import java.util.Locale;

public final class IiiIiiIiI_Class219 {
    public static final int I_field_49 = Integer.MAX_VALUE;

    private IiiIiiIiI_Class219() {
    }

    public static String I_method_12a37157(String string) {
        if (string == null || string.isBlank()) {
            return "";
        }
        String string2 = Normalizer.normalize(string, Normalizer.Form.NFKD).toLowerCase(Locale.ROOT);
        StringBuilder stringBuilder = new StringBuilder(string2.length());
        boolean bl = false;
        for (int i = 0; i < string2.length(); ++i) {
            char c = string2.charAt(i);
            if (Character.getType(c) == 6) continue;
            if (Character.isLetterOrDigit(c)) {
                if (bl && !stringBuilder.isEmpty()) {
                    stringBuilder.append(' ');
                }
                stringBuilder.append(c);
                bl = false;
                continue;
            }
            bl = true;
        }
        return stringBuilder.toString();
    }

    public static int I_method_e68b43e6(String string, String string2) {
        return IiiIiiIiI_Class219.i_method_ca495fc6(IiiIiiIiI_Class219.I_method_12a37157(string), IiiIiiIiI_Class219.I_method_12a37157(string2));
    }

    public static int i_method_ca495fc6(String string, String string2) {
        int n;
        String string3;
        if (string.isEmpty() || string2.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        if (string.equals(string2)) {
            return 0;
        }
        String string4 = IiiIiiIiI_Class219.i_method_32c25977(string);
        if (string4.equals(string3 = IiiIiiIiI_Class219.i_method_32c25977(string2))) {
            return 10;
        }
        if (string.startsWith(string2)) {
            return 20 + string.length() - string2.length();
        }
        if (string4.startsWith(string3)) {
            return 40 + string4.length() - string3.length();
        }
        int n2 = IiiIiiIiI_Class219.II_method_6ff39ce9(string, string2);
        if (n2 >= 0) {
            return 80 + n2;
        }
        int n3 = string.indexOf(string2);
        if (n3 >= 0) {
            return 120 + n3;
        }
        int n4 = string4.indexOf(string3);
        if (n4 >= 0) {
            return 160 + n4;
        }
        int n5 = IiiIiiIiI_Class219.Ii_method_53b1b8c9(string, string2);
        if (n5 != Integer.MAX_VALUE) {
            return 220 + n5;
        }
        int n6 = Math.abs(string4.length() - string3.length());
        n = string3.length() >= 8 ? 2 : (string3.length() >= 4 ? 1 : 0);
        if (n == 0 || n6 > n) {
            return Integer.MAX_VALUE;
        }
        int n8 = IiiIiiIiI_Class219.I_method_eaddad63(string4, string3, n);
        return n8 <= n ? 300 + n8 * 10 + n6 : Integer.MAX_VALUE;
    }

    private static String i_method_32c25977(String string) {
        return string.indexOf(32) < 0 ? string : string.replace(" ", "");
    }

    private static int II_method_6ff39ce9(String string, String string2) {
        int n = string.indexOf(string2);
        while (n >= 0) {
            if (n == 0 || string.charAt(n - 1) == ' ') {
                return n;
            }
            n = string.indexOf(string2, n + 1);
        }
        return -1;
    }

    private static int Ii_method_53b1b8c9(String string, String string2) {
        int n = 0;
        int n2 = 0;
        while (n2 < string2.length()) {
            String string3;
            int n3;
            int n4 = string2.indexOf(32, n2);
            if (n4 < 0) {
                n4 = string2.length();
            }
            if ((n3 = string.indexOf(string3 = string2.substring(n2, n4))) < 0) {
                return Integer.MAX_VALUE;
            }
            n += n3;
            n2 = n4 + 1;
        }
        return n;
    }

    private static int I_method_eaddad63(String string, String string2, int n) {
        int n2;
        int[] nArray = null;
        int[] nArray2 = new int[string2.length() + 1];
        int[] nArray3 = new int[string2.length() + 1];
        for (n2 = 0; n2 <= string2.length(); ++n2) {
            nArray2[n2] = n2;
        }
        for (n2 = 1; n2 <= string.length(); ++n2) {
            nArray3[0] = n2;
            for (int i = 1; i <= string2.length(); ++i) {
                int n3 = nArray2[i - 1] + (string.charAt(n2 - 1) == string2.charAt(i - 1) ? 0 : 1);
                nArray3[i] = Math.min(Math.min(nArray2[i] + 1, nArray3[i - 1] + 1), n3);
                if (nArray == null || i <= 1 || string.charAt(n2 - 1) != string2.charAt(i - 2) || string.charAt(n2 - 2) != string2.charAt(i - 1)) continue;
                nArray3[i] = Math.min(nArray3[i], nArray[i - 2] + 1);
            }
            int[] nArray4 = nArray;
            nArray = nArray2;
            nArray2 = nArray3;
            nArray3 = nArray4 == null ? new int[string2.length() + 1] : nArray4;
        }
        return nArray2[string2.length()];
    }
}
