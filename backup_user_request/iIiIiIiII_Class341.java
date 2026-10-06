package rockstar.client;

import java.util.Map;
import java.util.Set;
import rockstar.client.iIiIIiIII_Class329;
import rockstar.client.iIiIIiIIi_Class330;
import rockstar.client.iIiIIiIiI_Class331;
import rockstar.client.iIiIIiIii_Class332;
import rockstar.client.iIiIIiiIi_Class334;
import rockstar.client.iIiIIiiiI_Class335;
import rockstar.client.iIiIIiiii_Class336;
import rockstar.client.iIiIiIIII_Class337;
import rockstar.client.iIiIiIIIi_Class338;
import rockstar.client.iIiIiIIiI_Class339;
import rockstar.client.iIiIiIIii_Class340;
import rockstar.client.iIiIiIiIi_Class342;
import rockstar.client.iIiIiIiiI_Class343;

public class iIiIiIiII_Class341 {
    private final char[] I_field_b48;
    private final int I_field_49;
    private final Map<String, iIiIIiIII_Class329> I_field_a567c40b;
    private final Map<String, iIiIIiIiI_Class331> i_field_a567c40b;
    private final Set<String> I_field_a56a8dc5;
    private final boolean I_field_5a;
    private int i_field_49 = 0;
    private iIiIiIIii_Class340 I_field_a678fa2c;

    public iIiIiIiII_Class341(String string, Map<String, iIiIIiIII_Class329> map, Map<String, iIiIIiIiI_Class331> map2, Set<String> set, boolean bl) {
        this.I_field_b48 = string.trim().toCharArray();
        this.I_field_49 = this.I_field_b48.length;
        this.I_field_a567c40b = map;
        this.i_field_a567c40b = map2;
        this.I_field_a56a8dc5 = set;
        this.I_field_5a = bl;
    }

    public iIiIiIiII_Class341(String string, Map<String, iIiIIiIII_Class329> map, Map<String, iIiIIiIiI_Class331> map2, Set<String> set) {
        this.I_field_b48 = string.trim().toCharArray();
        this.I_field_49 = this.I_field_b48.length;
        this.I_field_a567c40b = map;
        this.i_field_a567c40b = map2;
        this.I_field_a56a8dc5 = set;
        this.I_field_5a = true;
    }

    public boolean I_method_62ea49c3() {
        return this.I_field_b48.length > this.i_field_49;
    }

    public iIiIiIIii_Class340 I_method_78e9e255() {
        char c = this.I_field_b48[this.i_field_49];
        while (Character.isWhitespace(c)) {
            c = this.I_field_b48[++this.i_field_49];
        }
        if (Character.isDigit(c) || c == '.') {
            if (this.I_field_a678fa2c != null) {
                if (this.I_field_a678fa2c.I_method_3a2729d2() == 1) {
                    throw new IllegalArgumentException("Unable to parse char '" + c + "' (Code:" + c + ") at [" + this.i_field_49 + "]");
                }
                if (this.I_field_5a && this.I_field_a678fa2c.I_method_3a2729d2() != 2 && this.I_field_a678fa2c.I_method_3a2729d2() != 4 && this.I_field_a678fa2c.I_method_3a2729d2() != 3 && this.I_field_a678fa2c.I_method_3a2729d2() != 7) {
                    this.I_field_a678fa2c = new iIiIiIIiI_Class339(iIiIIiIii_Class332.I_method_181465fb('*', 2));
                    return this.I_field_a678fa2c;
                }
            }
            return this.i_method_82d58294(c);
        }
        if (this.I_method_fa5f4aa2(c)) {
            return this.i_method_8e7f5635();
        }
        if (this.i_method_fc223ac2(c)) {
            if (this.I_field_a678fa2c != null && this.I_field_5a && this.I_field_a678fa2c.I_method_3a2729d2() != 2 && this.I_field_a678fa2c.I_method_3a2729d2() != 4 && this.I_field_a678fa2c.I_method_3a2729d2() != 3 && this.I_field_a678fa2c.I_method_3a2729d2() != 7) {
                this.I_field_a678fa2c = new iIiIiIIiI_Class339(iIiIIiIii_Class332.I_method_181465fb('*', 2));
                return this.I_field_a678fa2c;
            }
            return this.I_method_9bea020b(true);
        }
        if (this.II_method_534f273f(c)) {
            return this.I_method_9bea020b(false);
        }
        if (iIiIIiIiI_Class331.I_method_5a8ed222(c)) {
            return this.I_method_e5bc7a74(c);
        }
        if (iIiIiIiII_Class341.I_method_fa5f6128(c) || c == '_') {
            if (this.I_field_a678fa2c != null && this.I_field_5a && this.I_field_a678fa2c.I_method_3a2729d2() != 2 && this.I_field_a678fa2c.I_method_3a2729d2() != 4 && this.I_field_a678fa2c.I_method_3a2729d2() != 3 && this.I_field_a678fa2c.I_method_3a2729d2() != 7) {
                this.I_field_a678fa2c = new iIiIiIIiI_Class339(iIiIIiIii_Class332.I_method_181465fb('*', 2));
                return this.I_field_a678fa2c;
            }
            return this.II_method_a0918058();
        }
        throw new IllegalArgumentException("Unable to parse char '" + c + "' (Code:" + c + ") at [" + this.i_field_49 + "]");
    }

    private iIiIiIIii_Class340 i_method_8e7f5635() {
        ++this.i_field_49;
        this.I_field_a678fa2c = new iIiIIiiIi_Class334();
        return this.I_field_a678fa2c;
    }

    private boolean I_method_fa5f4aa2(char c) {
        return c == ',';
    }

    private iIiIiIIii_Class340 I_method_9bea020b(boolean bl) {
        this.I_field_a678fa2c = bl ? new iIiIiIIIi_Class338() : new iIiIIiiiI_Class335();
        ++this.i_field_49;
        return this.I_field_a678fa2c;
    }

    private boolean i_method_fc223ac2(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private boolean II_method_534f273f(char c) {
        return c == ')' || c == '}' || c == ']';
    }

    private iIiIiIIii_Class340 II_method_a0918058() {
        int n = this.i_field_49++;
        int n2 = 1;
        iIiIiIIii_Class340 iIiIiIIii_Class3402 = null;
        int n3 = 1;
        if (this.II_method_534f3dc5(n)) {
            // empty if block
        }
        int n4 = n + n3 - 1;
        while (!this.II_method_534f3dc5(n4) && iIiIiIiII_Class341.i_method_fc225148(this.I_field_b48[n4])) {
            String string = new String(this.I_field_b48, n, n3);
            if (this.I_field_a56a8dc5 != null && this.I_field_a56a8dc5.contains(string)) {
                n2 = n3;
                iIiIiIIii_Class3402 = new iIiIiIiiI_Class343(string);
            } else {
                iIiIIiIII_Class329 iIiIIiIII_Class3292 = this.I_method_ade1c21f(string);
                if (iIiIIiIII_Class3292 != null) {
                    n2 = n3;
                    iIiIiIIii_Class3402 = new iIiIIiiii_Class336(iIiIIiIII_Class3292);
                }
            }
            n4 = n + ++n3 - 1;
        }
        if (iIiIiIIii_Class3402 == null) {
            throw new iIiIiIiIi_Class342(new String(this.I_field_b48), this.i_field_49, n3);
        }
        this.i_field_49 += n2;
        this.I_field_a678fa2c = iIiIiIIii_Class3402;
        return this.I_field_a678fa2c;
    }

    private iIiIIiIII_Class329 I_method_ade1c21f(String string) {
        iIiIIiIII_Class329 iIiIIiIII_Class3292 = null;
        if (this.I_field_a567c40b != null) {
            iIiIIiIII_Class3292 = this.I_field_a567c40b.get(string);
        }
        if (iIiIIiIII_Class3292 == null) {
            iIiIIiIII_Class3292 = iIiIIiIIi_Class330.I_method_8be9965f(string);
        }
        return iIiIIiIII_Class3292;
    }

    private iIiIiIIii_Class340 I_method_e5bc7a74(char c) {
        int n = this.i_field_49;
        int n2 = 1;
        StringBuilder stringBuilder = new StringBuilder();
        iIiIIiIiI_Class331 iIiIIiIiI_Class3312 = null;
        stringBuilder.append(c);
        while (!this.II_method_534f3dc5(n + n2) && iIiIIiIiI_Class331.I_method_5a8ed222(this.I_field_b48[n + n2])) {
            stringBuilder.append(this.I_field_b48[n + n2++]);
        }
        while (!stringBuilder.isEmpty()) {
            iIiIIiIiI_Class331 iIiIIiIiI_Class3313 = this.I_method_ade23a3f(stringBuilder.toString());
            if (iIiIIiIiI_Class3313 == null) {
                stringBuilder.setLength(stringBuilder.length() - 1);
                continue;
            }
            iIiIIiIiI_Class3312 = iIiIIiIiI_Class3313;
            break;
        }
        this.i_field_49 += stringBuilder.length();
        this.I_field_a678fa2c = new iIiIiIIiI_Class339(iIiIIiIiI_Class3312);
        return this.I_field_a678fa2c;
    }

    private iIiIIiIiI_Class331 I_method_ade23a3f(String string) {
        iIiIIiIiI_Class331 iIiIIiIiI_Class3312 = null;
        if (this.i_field_a567c40b != null) {
            iIiIIiIiI_Class3312 = this.i_field_a567c40b.get(string);
        }
        if (iIiIIiIiI_Class3312 == null && string.length() == 1) {
            int n = 2;
            if (this.I_field_a678fa2c == null) {
                n = 1;
            } else {
                iIiIIiIiI_Class331 iIiIIiIiI_Class3313;
                int n2 = this.I_field_a678fa2c.I_method_3a2729d2();
                if (n2 == 4 || n2 == 7) {
                    n = 1;
                } else if (n2 == 2 && ((iIiIIiIiI_Class3313 = ((iIiIiIIiI_Class339)this.I_field_a678fa2c).I_method_5b10b6f5()).I_method_2ebd232() == 2 || iIiIIiIiI_Class3313.I_method_2ebd232() == 1 && !iIiIIiIiI_Class3313.I_method_2ebd243())) {
                    n = 1;
                }
            }
            iIiIIiIiI_Class3312 = iIiIIiIii_Class332.I_method_181465fb(string.charAt(0), n);
        }
        return iIiIIiIiI_Class3312;
    }

    private iIiIiIIii_Class340 i_method_82d58294(char c) {
        int n;
        int n2 = 1;
        if (this.II_method_534f3dc5((n = this.i_field_49++) + n2)) {
            this.I_field_a678fa2c = new iIiIiIIII_Class337(Double.parseDouble(String.valueOf(c)));
            return this.I_field_a678fa2c;
        }
        while (!this.II_method_534f3dc5(n + n2) && iIiIiIiII_Class341.I_method_518abbfa(this.I_field_b48[n + n2], this.I_field_b48[n + n2 - 1] == 'e' || this.I_field_b48[n + n2 - 1] == 'E')) {
            ++n2;
            ++this.i_field_49;
        }
        if (this.I_field_b48[n + n2 - 1] == 'e' || this.I_field_b48[n + n2 - 1] == 'E') {
            --n2;
            --this.i_field_49;
        }
        this.I_field_a678fa2c = new iIiIiIIII_Class337(this.I_field_b48, n, n2);
        return this.I_field_a678fa2c;
    }

    private static boolean I_method_518abbfa(char c, boolean bl) {
        return Character.isDigit(c) || c == '.' || c == 'e' || c == 'E' || bl && (c == '-' || c == '+');
    }

    public static boolean I_method_fa5f6128(int n) {
        return Character.isLetter(n);
    }

    public static boolean i_method_fc225148(int n) {
        return iIiIiIiII_Class341.I_method_fa5f6128(n) || Character.isDigit(n) || n == 95 || n == 46;
    }

    private boolean II_method_534f3dc5(int n) {
        return this.I_field_49 <= n;
    }
}

