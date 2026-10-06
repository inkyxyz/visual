package rockstar.client;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rockstar.client.iIiIIIiII_Class325;
import rockstar.client.iIiIIiIII_Class329;
import rockstar.client.iIiIIiIIi_Class330;
import rockstar.client.iIiIIiIiI_Class331;
import rockstar.client.iIiIIiiII_Class333;

public class iIiIIIiIi_Class326 {
    private final String I_field_523beb0a;
    private final Map<String, iIiIIiIII_Class329> I_field_a567c40b;
    private final Map<String, iIiIIiIiI_Class331> i_field_a567c40b;
    private final Set<String> I_field_a56a8dc5;
    private boolean I_field_5a = true;

    public iIiIIIiIi_Class326(String string) {
        if (string == null || string.trim().isEmpty()) {
            throw new IllegalArgumentException("Expression can not be empty");
        }
        this.I_field_523beb0a = string;
        this.i_field_a567c40b = new HashMap<String, iIiIIiIiI_Class331>(4);
        this.I_field_a567c40b = new HashMap<String, iIiIIiIII_Class329>(4);
        this.I_field_a56a8dc5 = new HashSet<String>(4);
    }

    public iIiIIIiIi_Class326 I_method_750f977d(iIiIIiIII_Class329 iIiIIiIII_Class3292) {
        this.I_field_a567c40b.put(iIiIIiIII_Class3292.I_method_a4e12c61(), iIiIIiIII_Class3292);
        return this;
    }

    public iIiIIIiIi_Class326 I_method_475588e6(iIiIIiIII_Class329 ... iIiIIiIII_Class329Array) {
        for (iIiIIiIII_Class329 iIiIIiIII_Class3292 : iIiIIiIII_Class329Array) {
            this.I_field_a567c40b.put(iIiIIiIII_Class3292.I_method_a4e12c61(), iIiIIiIII_Class3292);
        }
        return this;
    }

    public iIiIIIiIi_Class326 I_method_87aa45e6(List<iIiIIiIII_Class329> list) {
        for (iIiIIiIII_Class329 iIiIIiIII_Class3292 : list) {
            this.I_field_a567c40b.put(iIiIIiIII_Class3292.I_method_a4e12c61(), iIiIIiIII_Class3292);
        }
        return this;
    }

    public iIiIIIiIi_Class326 I_method_668b0056(Set<String> set) {
        this.I_field_a56a8dc5.addAll(set);
        return this;
    }

    public iIiIIIiIi_Class326 I_method_a4787636(String ... stringArray) {
        Collections.addAll(this.I_field_a56a8dc5, stringArray);
        return this;
    }

    public iIiIIIiIi_Class326 I_method_9df251bf(String string) {
        this.I_field_a56a8dc5.add(string);
        return this;
    }

    public iIiIIIiIi_Class326 I_method_ab5a11eb(boolean bl) {
        this.I_field_5a = bl;
        return this;
    }

    public void I_method_b093f927(iIiIIiIiI_Class331 iIiIIiIiI_Class3312) {
        this.i_method_4dad0147(iIiIIiIiI_Class3312);
        this.i_field_a567c40b.put(iIiIIiIiI_Class3312.I_method_25130841(), iIiIIiIiI_Class3312);
    }

    private void i_method_4dad0147(iIiIIiIiI_Class331 iIiIIiIiI_Class3312) {
        String string = iIiIIiIiI_Class3312.I_method_25130841();
        for (char c : string.toCharArray()) {
            if (iIiIIiIiI_Class331.I_method_5a8ed222(c)) continue;
            throw new IllegalArgumentException("The operator symbol '" + string + "' is invalid");
        }
    }

    public iIiIIIiIi_Class326 I_method_e46e9106(iIiIIiIiI_Class331 ... iIiIIiIiI_Class331Array) {
        for (iIiIIiIiI_Class331 iIiIIiIiI_Class3312 : iIiIIiIiI_Class331Array) {
            this.I_method_b093f927(iIiIIiIiI_Class3312);
        }
        return this;
    }

    public iIiIIIiIi_Class326 i_method_b69bf9c6(List<iIiIIiIiI_Class331> list) {
        for (iIiIIiIiI_Class331 iIiIIiIiI_Class3312 : list) {
            this.I_method_b093f927(iIiIIiIiI_Class3312);
        }
        return this;
    }

    public iIiIIIiII_Class325 I_method_c07dce55() {
        if (this.I_field_523beb0a.isEmpty()) {
            throw new IllegalArgumentException("The expression can not be empty");
        }
        this.I_field_a56a8dc5.add("pi");
        this.I_field_a56a8dc5.add("\u03c0");
        this.I_field_a56a8dc5.add("e");
        this.I_field_a56a8dc5.add("\u03c6");
        for (String string : this.I_field_a56a8dc5) {
            if (iIiIIiIIi_Class330.I_method_8be9965f(string) == null && !this.I_field_a567c40b.containsKey(string)) continue;
            throw new IllegalArgumentException("A variable can not have the same name as a function [" + string + "]");
        }
        return new iIiIIIiII_Class325(iIiIIiiII_Class333.I_method_f0b894a9(this.I_field_523beb0a, this.I_field_a567c40b, this.i_field_a567c40b, this.I_field_a56a8dc5, this.I_field_5a), this.I_field_a567c40b.keySet());
    }
}

