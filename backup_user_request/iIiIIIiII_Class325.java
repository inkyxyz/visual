package rockstar.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import rockstar.client.iIiIIIIiI_Class323;
import rockstar.client.iIiIIIiii_Class328;
import rockstar.client.iIiIIiIII_Class329;
import rockstar.client.iIiIIiIIi_Class330;
import rockstar.client.iIiIIiIiI_Class331;
import rockstar.client.iIiIIiiii_Class336;
import rockstar.client.iIiIiIIII_Class337;
import rockstar.client.iIiIiIIiI_Class339;
import rockstar.client.iIiIiIIii_Class340;
import rockstar.client.iIiIiIiiI_Class343;

public class iIiIIIiII_Class325 {
    private final iIiIiIIii_Class340[] I_field_40c698f1;
    private final Map<String, Double> I_field_a567c40b;
    private final Set<String> I_field_a56a8dc5;

    private static Map<String, Double> I_method_92eb05d4() {
        HashMap<String, Double> hashMap = new HashMap<String, Double>(4);
        hashMap.put("pi", Math.PI);
        hashMap.put("\u03c0", Math.PI);
        hashMap.put("\u03c6", 1.61803398874);
        hashMap.put("e", Math.E);
        return hashMap;
    }

    public iIiIIIiII_Class325(iIiIIIiII_Class325 iIiIIIiII_Class3252) {
        this.I_field_40c698f1 = Arrays.copyOf(iIiIIIiII_Class3252.I_field_40c698f1, iIiIIIiII_Class3252.I_field_40c698f1.length);
        this.I_field_a567c40b = new HashMap<String, Double>();
        this.I_field_a567c40b.putAll(iIiIIIiII_Class3252.I_field_a567c40b);
        this.I_field_a56a8dc5 = new HashSet<String>(iIiIIIiII_Class3252.I_field_a56a8dc5);
    }

    iIiIIIiII_Class325(iIiIiIIii_Class340[] iIiIiIIii_Class340Array) {
        this.I_field_40c698f1 = iIiIiIIii_Class340Array;
        this.I_field_a567c40b = iIiIIIiII_Class325.I_method_92eb05d4();
        this.I_field_a56a8dc5 = Collections.emptySet();
    }

    iIiIIIiII_Class325(iIiIiIIii_Class340[] iIiIiIIii_Class340Array, Set<String> set) {
        this.I_field_40c698f1 = iIiIiIIii_Class340Array;
        this.I_field_a567c40b = iIiIIIiII_Class325.I_method_92eb05d4();
        this.I_field_a56a8dc5 = set;
    }

    public void I_method_f499e775(String string, double d) {
        this.I_method_ad0d35e9(string);
        this.I_field_a567c40b.put(string, d);
    }

    private void I_method_ad0d35e9(String string) {
        if (this.I_field_a56a8dc5.contains(string) || iIiIIiIIi_Class330.I_method_8be9965f(string) != null) {
            throw new IllegalArgumentException("The variable name '" + string + "' is invalid. Since there exists a function with the same name");
        }
    }

    public iIiIIIiII_Class325 I_method_2fcee59c(Map<String, Double> map) {
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            this.I_method_f499e775(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public iIiIIIiII_Class325 I_method_ba75d275() {
        this.I_field_a567c40b.clear();
        return this;
    }

    public Set<String> I_method_92edcf8e() {
        HashSet<String> hashSet = new HashSet<String>();
        for (iIiIiIIii_Class340 iIiIiIIii_Class3402 : this.I_field_40c698f1) {
            if (iIiIiIIii_Class3402.I_method_3a2729d2() != 6) continue;
            hashSet.add(((iIiIiIiiI_Class343)iIiIiIIii_Class3402).I_method_9a145ca1());
        }
        return hashSet;
    }

    public iIiIIIiii_Class328 I_method_f06309eb(boolean bl) {
        ArrayList<String> arrayList = new ArrayList<String>(0);
        if (bl) {
            for (iIiIiIIii_Class340 iIiIiIIii_Class3402 : this.I_field_40c698f1) {
                String object;
                if (iIiIiIIii_Class3402.I_method_3a2729d2() != 6 || this.I_field_a567c40b.containsKey(object = ((iIiIiIiiI_Class343)iIiIiIIii_Class3402).I_method_9a145ca1())) continue;
                arrayList.add("The setVariable '" + object + "' has not been set");
            }
        }
        int n = 0;
        for (iIiIiIIii_Class340 iIiIiIIii_Class3402 : this.I_field_40c698f1) {
            switch (iIiIiIIii_Class3402.I_method_3a2729d2()) {
                case 1: 
                case 6: {
                    ++n;
                    break;
                }
                case 3: {
                    iIiIIiIII_Class329 iIiIIiIII_Class3292 = ((iIiIIiiii_Class336)iIiIiIIii_Class3402).I_method_5841aad5();
                    int n2 = iIiIIiIII_Class3292.I_method_66246a12();
                    if (n2 > n) {
                        arrayList.add("Not enough arguments for '" + iIiIIiIII_Class3292.I_method_a4e12c61() + "'");
                    }
                    if (n2 > 1) {
                        n -= n2 - 1;
                        break;
                    }
                    if (n2 != 0) break;
                    ++n;
                    break;
                }
                case 2: {
                    iIiIIiIiI_Class331 iIiIIiIiI_Class3312 = ((iIiIiIIiI_Class339)iIiIiIIii_Class3402).I_method_5b10b6f5();
                    if (iIiIIiIiI_Class3312.I_method_2ebd232() != 2) break;
                    --n;
                }
            }
            if (n >= 1) continue;
            arrayList.add("Too many operators");
            return new iIiIIIiii_Class328(false, arrayList);
        }
        if (n > 1) {
            arrayList.add("Too many operands");
        }
        return arrayList.isEmpty() ? iIiIIIiii_Class328.I_field_6fec722c : new iIiIIIiii_Class328(false, arrayList);
    }

    public iIiIIIiii_Class328 I_method_ba764e75() {
        return this.I_method_f06309eb(true);
    }

    public Future<Double> I_method_dd3253a(ExecutorService executorService) {
        return executorService.submit(this::I_method_d9bc25cd);
    }

    public double I_method_d9bc25cd() {
        iIiIIIIiI_Class323 iIiIIIIiI_Class3232 = new iIiIIIIiI_Class323();
        for (iIiIiIIii_Class340 iIiIiIIii_Class3402 : this.I_field_40c698f1) {
            Object object;
            if (iIiIiIIii_Class3402.I_method_3a2729d2() == 1) {
                iIiIIIIiI_Class3232.I_method_d160b1ff(((iIiIiIIII_Class337)iIiIiIIii_Class3402).I_method_66c4adcd());
                continue;
            }
            if (iIiIiIIii_Class3402.I_method_3a2729d2() == 6) {
                object = ((iIiIiIiiI_Class343)iIiIiIIii_Class3402).I_method_9a145ca1();
                Double d = this.I_field_a567c40b.get(object);
                if (d == null) {
                    throw new IllegalArgumentException("No value has been set for the setVariable '" + (String)object + "'.");
                }
                iIiIIIIiI_Class3232.I_method_d160b1ff(d);
                continue;
            }
            if (iIiIiIIii_Class3402.I_method_3a2729d2() == 2) {
                object = (iIiIiIIiI_Class339)iIiIiIIii_Class3402;
                if (iIiIIIIiI_Class3232.I_method_7a5df212() < ((iIiIiIIiI_Class339)object).I_method_5b10b6f5().I_method_2ebd232()) {
                    throw new IllegalArgumentException("Invalid number of operands available for '" + ((iIiIiIIiI_Class339)object).I_method_5b10b6f5().I_method_25130841() + "' operator");
                }
                if (((iIiIiIIiI_Class339)object).I_method_5b10b6f5().I_method_2ebd232() == 2) {
                    double d = iIiIIIIiI_Class3232.i_method_7a6c7ded();
                    double d2 = iIiIIIIiI_Class3232.i_method_7a6c7ded();
                    iIiIIIIiI_Class3232.I_method_d160b1ff(((iIiIiIIiI_Class339)object).I_method_5b10b6f5().I_method_f756bab6(d2, d));
                    continue;
                }
                if (((iIiIiIIiI_Class339)object).I_method_5b10b6f5().I_method_2ebd232() != 1) continue;
                double d = iIiIIIIiI_Class3232.i_method_7a6c7ded();
                iIiIIIIiI_Class3232.I_method_d160b1ff(((iIiIiIIiI_Class339)object).I_method_5b10b6f5().I_method_f756bab6(d));
                continue;
            }
            if (iIiIiIIii_Class3402.I_method_3a2729d2() != 3) continue;
            object = (iIiIIiiii_Class336)iIiIiIIii_Class3402;
            int n = ((iIiIIiiii_Class336)object).I_method_5841aad5().I_method_66246a12();
            if (iIiIIIIiI_Class3232.I_method_7a5df212() < n) {
                throw new IllegalArgumentException("Invalid number of arguments available for '" + ((iIiIIiiii_Class336)object).I_method_5841aad5().I_method_a4e12c61() + "' function");
            }
            double[] dArray = new double[n];
            for (int i = n - 1; i >= 0; --i) {
                dArray[i] = iIiIIIIiI_Class3232.i_method_7a6c7ded();
            }
            iIiIIIIiI_Class3232.I_method_d160b1ff(((iIiIIiiii_Class336)object).I_method_5841aad5().I_method_6ec8da96(dArray));
        }
        if (iIiIIIIiI_Class3232.I_method_7a5df212() > 1) {
            throw new IllegalArgumentException("Invalid number of items on the output queue. Might be caused by an invalid number of arguments for a function.");
        }
        return iIiIIIIiI_Class3232.i_method_7a6c7ded();
    }
}

