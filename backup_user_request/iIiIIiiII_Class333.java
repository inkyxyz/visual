package rockstar.client;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import rockstar.client.iIiIIiIII_Class329;
import rockstar.client.iIiIIiIiI_Class331;
import rockstar.client.iIiIiIIiI_Class339;
import rockstar.client.iIiIiIIii_Class340;
import rockstar.client.iIiIiIiII_Class341;

public class iIiIIiiII_Class333 {
    public static iIiIiIIii_Class340[] I_method_f0b894a9(String string, Map<String, iIiIIiIII_Class329> map, Map<String, iIiIIiIiI_Class331> map2, Set<String> set, boolean bl) {
        iIiIiIIii_Class340 iIiIiIIii_Class3402;
        Stack<iIiIiIIii_Class340> stack = new Stack<iIiIiIIii_Class340>();
        ArrayList<iIiIiIIii_Class340> arrayList = new ArrayList<iIiIiIIii_Class340>();
        iIiIiIiII_Class341 iIiIiIiII_Class3412 = new iIiIiIiII_Class341(string, map, map2, set, bl);
        block8: while (iIiIiIiII_Class3412.I_method_62ea49c3()) {
            iIiIiIIii_Class3402 = iIiIiIiII_Class3412.I_method_78e9e255();
            switch (iIiIiIIii_Class3402.I_method_3a2729d2()) {
                case 1: 
                case 6: {
                    arrayList.add(iIiIiIIii_Class3402);
                    continue block8;
                }
                case 3: {
                    stack.add(iIiIiIIii_Class3402);
                    continue block8;
                }
                case 7: {
                    while (!stack.empty() && ((iIiIiIIii_Class340)stack.peek()).I_method_3a2729d2() != 4) {
                        arrayList.add((iIiIiIIii_Class340)stack.pop());
                    }
                    if (!stack.empty() && ((iIiIiIIii_Class340)stack.peek()).I_method_3a2729d2() == 4) continue block8;
                    throw new IllegalArgumentException("Misplaced function separator ',' or mismatched parentheses");
                }
                case 2: {
                    while (!stack.empty() && ((iIiIiIIii_Class340)stack.peek()).I_method_3a2729d2() == 2) {
                        iIiIiIIiI_Class339 iIiIiIIiI_Class3392 = (iIiIiIIiI_Class339)iIiIiIIii_Class3402;
                        iIiIiIIiI_Class339 iIiIiIIiI_Class3393 = (iIiIiIIiI_Class339)stack.peek();
                        if (iIiIiIIiI_Class3392.I_method_5b10b6f5().I_method_2ebd232() == 1 && iIiIiIIiI_Class3393.I_method_5b10b6f5().I_method_2ebd232() == 2 || (!iIiIiIIiI_Class3392.I_method_5b10b6f5().I_method_2ebd243() || iIiIiIIiI_Class3392.I_method_5b10b6f5().i_method_2fa5e12() > iIiIiIIiI_Class3393.I_method_5b10b6f5().i_method_2fa5e12()) && iIiIiIIiI_Class3392.I_method_5b10b6f5().i_method_2fa5e12() >= iIiIiIIiI_Class3393.I_method_5b10b6f5().i_method_2fa5e12()) break;
                        arrayList.add((iIiIiIIii_Class340)stack.pop());
                    }
                    stack.push(iIiIiIIii_Class3402);
                    continue block8;
                }
                case 4: {
                    stack.push(iIiIiIIii_Class3402);
                    continue block8;
                }
                case 5: {
                    while (((iIiIiIIii_Class340)stack.peek()).I_method_3a2729d2() != 4) {
                        arrayList.add((iIiIiIIii_Class340)stack.pop());
                    }
                    stack.pop();
                    if (stack.isEmpty() || ((iIiIiIIii_Class340)stack.peek()).I_method_3a2729d2() != 3) continue block8;
                    arrayList.add((iIiIiIIii_Class340)stack.pop());
                    continue block8;
                }
            }
            throw new IllegalArgumentException("Unknown Token type encountered. This should not happen");
        }
        while (!stack.empty()) {
            iIiIiIIii_Class3402 = (iIiIiIIii_Class340)stack.pop();
            if (iIiIiIIii_Class3402.I_method_3a2729d2() == 5 || iIiIiIIii_Class3402.I_method_3a2729d2() == 4) {
                throw new IllegalArgumentException("Mismatched parentheses detected. Please check the expression");
            }
            arrayList.add(iIiIiIIii_Class3402);
        }
        return arrayList.toArray(new iIiIiIIii_Class340[0]);
    }
}

