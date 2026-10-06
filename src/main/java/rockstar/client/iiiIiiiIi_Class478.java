package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import rockstar.client.iiiIIIiIi_Class454;
import rockstar.client.iiiIIiIIi_Class458;
import rockstar.client.iiiIiIIII_Class465;
import rockstar.client.iiiIiIIIi_Class466;
import rockstar.client.iiiIiIIiI_Class467;
import rockstar.client.iiiIiIIii_Class468;
import rockstar.client.iiiIiIiII_Class469;
import rockstar.client.iiiIiIiIi_Class470;
import rockstar.client.iiiIiIiiI_Class471;
import rockstar.client.iiiIiIiii_Class472;
import rockstar.client.iiiIiiIII_Class473;
import rockstar.client.iiiIiiIIi_Class474;
import rockstar.client.iiiIiiIiI_Class475;
import rockstar.client.iiiIiiIii_Class476;
import rockstar.client.iiiIiiiII_Class477;

public final class iiiIiiiIi_Class478 {
    private static final int[][] I_field_160e9 = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static final int[][] i_field_160e9 = new int[][]{{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    private iiiIiiiIi_Class478() {
    }

    public static List<iiiIiIIII_Class465> I_method_80268bc8(iiiIIiIIi_Class458 iiiIIiIIi_Class4582, iiiIIIiIi_Class454 iiiIIIiIi_Class4542) {
        ArrayList<iiiIiIIII_Class465> arrayList = new ArrayList<iiiIiIIII_Class465>(24);
        boolean bl = iiiIIIiIi_Class4542.IiI_method_5d0a23e8(iiiIIiIIi_Class4582.I_method_6d204e12(), iiiIIiIIi_Class4582.i_method_6d2ed9f2(), iiiIIiIIi_Class4582.II_method_36f86d15());
        boolean bl2 = iiiIIIiIi_Class4542.Ii_method_bbfd4a25(iiiIIiIIi_Class4582.I_method_6d204e12(), iiiIIiIIi_Class4582.i_method_6d2ed9f2(), iiiIIiIIi_Class4582.II_method_36f86d15());
        boolean bl3 = iiiIIIiIi_Class4542.iI_method_1b5b7de5(iiiIIiIIi_Class4582.I_method_6d204e12(), iiiIIiIIi_Class4582.i_method_6d2ed9f2(), iiiIIiIIi_Class4582.II_method_36f86d15());
        if (bl) {
            iiiIiiiIi_Class478.I_method_5f650390(iiiIIiIIi_Class4582, iiiIIIiIi_Class4542, arrayList);
        }
        if (bl3) {
            iiiIiiiIi_Class478.I_method_8d3c2144(iiiIIiIIi_Class4582, iiiIIIiIi_Class4542, arrayList, bl);
        }
        if (bl2) {
            iiiIiiiIi_Class478.i_method_3017964(iiiIIiIIi_Class4582, iiiIIIiIi_Class4542, arrayList, bl);
        }
        if (!(bl || bl2 || bl3)) {
            iiiIiiiIi_Class478.I_method_5f650390(iiiIIiIIi_Class4582, iiiIIIiIi_Class4542, arrayList);
            iiiIiiiIi_Class478.i_method_3017964(iiiIIiIIi_Class4582, iiiIIIiIi_Class4542, arrayList, false);
        }
        return arrayList;
    }

    private static void I_method_5f650390(iiiIIiIIi_Class458 iiiIIiIIi_Class4582, iiiIIIiIi_Class454 iiiIIIiIi_Class4542, List<iiiIiIIII_Class465> list) {
        int n;
        int n2;
        int n3 = iiiIIiIIi_Class4582.I_method_6d204e12();
        double d = iiiIIIiIi_Class4542.I_method_ca82d452(n3, n2 = iiiIIiIIi_Class4582.i_method_6d2ed9f2(), n = iiiIIiIIi_Class4582.II_method_36f86d15());
        if (Double.isNaN(d)) {
            d = n2;
        }
        for (int[] nArray : I_field_160e9) {
            int n4;
            int n5;
            int n6 = n3 + nArray[0];
            int n7 = n + nArray[1];
            boolean bl = false;
            for (n5 = 1; n5 >= -1; --n5) {
                n4 = n2 + n5;
                double d2 = iiiIIIiIi_Class4542.I_method_ca82d452(n6, n4, n7);
                if (Double.isNaN(d2)) continue;
                double d3 = d2 - d;
                iiiIIiIIi_Class458 iiiIIiIIi_Class4583 = new iiiIIiIIi_Class458(n6, n4, n7);
                if (Math.abs(d3) <= 0.62) {
                    bl |= iiiIiiiIi_Class478.I_method_ec4f2fb4(new iiiIiiiII_Class477(iiiIIiIIi_Class4582, iiiIIiIIi_Class4583), iiiIIIiIi_Class4542, list);
                    continue;
                }
                if (d3 > 0.62 && d3 <= 1.3) {
                    bl |= iiiIiiiIi_Class478.I_method_ec4f2fb4(new iiiIiIIIi_Class466(iiiIIiIIi_Class4582, iiiIIiIIi_Class4583), iiiIIIiIi_Class4542, list);
                    continue;
                }
                if (!(d3 < -0.62) || !(d3 >= -1.3)) continue;
                bl |= iiiIiiiIi_Class478.I_method_ec4f2fb4(new iiiIiIiii_Class472(iiiIIiIIi_Class4582, iiiIIiIIi_Class4583), iiiIIIiIi_Class4542, list);
            }
            if (!bl) {
                if (iiiIIIiIi_Class4542.I_method_e0b809e3()) {
                    iiiIiiiIi_Class478.I_method_ec4f2fb4(new iiiIiIIii_Class468(iiiIIiIIi_Class4582, new iiiIIiIIi_Class458(n6, n2 + 1, n7)), iiiIIIiIi_Class4542, list);
                    iiiIiiiIi_Class478.I_method_ec4f2fb4(new iiiIiIIiI_Class467(iiiIIiIIi_Class4582, new iiiIIiIIi_Class458(n6, n2, n7)), iiiIIIiIi_Class4542, list);
                }
                n5 = 0;
                for (n4 = 2; n4 <= 12; ++n4) {
                    if (!iiiIiiiIi_Class478.I_method_ec4f2fb4(new iiiIiiIIi_Class474(iiiIIiIIi_Class4582, new iiiIIiIIi_Class458(n6, n2 - n4, n7)), iiiIIIiIi_Class4542, list)) continue;
                    n5 = 1;
                    break;
                }
                if (n5 == 0 && iiiIIIiIi_Class4542.I_method_e0b809e3()) {
                    iiiIiiiIi_Class478.I_method_ec4f2fb4(new iiiIiIiII_Class469(iiiIIiIIi_Class4582, new iiiIIiIIi_Class458(n6, n2 - 1, n7)), iiiIIIiIi_Class4542, list);
                }
                iiiIiiiIi_Class478.I_method_ec4f2fb4(new iiiIiiIii_Class476(iiiIIiIIi_Class4582, new iiiIIiIIi_Class458(n6, n2, n7), iiiIiiIii_Class476.Nested1_6a615060.Ii_field_25809227), iiiIIIiIi_Class4542, list);
                iiiIiiiIi_Class478.I_method_ec4f2fb4(new iiiIiiIii_Class476(iiiIIiIIi_Class4582, new iiiIIiIIi_Class458(n6, n2 - 1, n7), iiiIiiIii_Class476.Nested1_6a615060.Ii_field_25809227), iiiIIIiIi_Class4542, list);
                iiiIiiiIi_Class478.I_method_ec4f2fb4(new iiiIiiiII_Class477(iiiIIiIIi_Class4582, new iiiIIiIIi_Class458(n6, n2, n7), true), iiiIIIiIi_Class4542, list);
                iiiIiiiIi_Class478.I_method_ec4f2fb4(new iiiIiiiII_Class477(iiiIIiIIi_Class4582, new iiiIIiIIi_Class458(n6, n2 - 1, n7), true), iiiIIIiIi_Class4542, list);
            }
            iiiIiiiIi_Class478.I_method_ec4f2fb4(new iiiIiiIiI_Class475(iiiIIiIIi_Class4582, new iiiIIiIIi_Class458(n3 + nArray[0] * 2, n2, n + nArray[1] * 2)), iiiIIIiIi_Class4542, list);
            iiiIiiiIi_Class478.I_method_ec4f2fb4(new iiiIiiIiI_Class475(iiiIIiIIi_Class4582, new iiiIIiIIi_Class458(n3 + nArray[0] * 3, n2, n + nArray[1] * 3)), iiiIIIiIi_Class4542, list);
        }
        for (int[] nArray : i_field_160e9) {
            iiiIiiiIi_Class478.I_method_ec4f2fb4(new iiiIiiIII_Class473(iiiIIiIIi_Class4582, new iiiIIiIIi_Class458(n3 + nArray[0], n2, n + nArray[1])), iiiIIIiIi_Class4542, list);
        }
        if (iiiIIIiIi_Class4542.I_method_e0b809e3()) {
            iiiIiiiIi_Class478.I_method_ec4f2fb4(new iiiIiIiIi_Class470(iiiIIiIIi_Class4582, new iiiIIiIIi_Class458(n3, n2 - 1, n)), iiiIIIiIi_Class4542, list);
        }
        if (iiiIIIiIi_Class4542.iI_method_1b5b7de5(n3, n2, n)) {
            iiiIiiiIi_Class478.I_method_ec4f2fb4(new iiiIiIiiI_Class471(iiiIIiIIi_Class4582, new iiiIIiIIi_Class458(n3, n2 + 1, n), iiiIiIiiI_Class471.Nested1_3588b480.I_field_bf45b207), iiiIIIiIi_Class4542, list);
        }
    }

    private static void I_method_8d3c2144(iiiIIiIIi_Class458 iiiIIiIIi_Class4582, iiiIIIiIi_Class454 iiiIIIiIi_Class4542, List<iiiIiIIII_Class465> list, boolean bl) {
        int n;
        int n2;
        int n3 = iiiIIiIIi_Class4582.I_method_6d204e12();
        boolean bl2 = iiiIiiiIi_Class478.I_method_ec4f2fb4(new iiiIiIiiI_Class471(iiiIIiIIi_Class4582, new iiiIIiIIi_Class458(n3, (n2 = iiiIIiIIi_Class4582.i_method_6d2ed9f2()) + 1, n = iiiIIiIIi_Class4582.II_method_36f86d15()), iiiIiIiiI_Class471.Nested1_3588b480.I_field_bf45b207), iiiIIIiIi_Class4542, list);
        if (!bl2) {
            for (int[] nArray : I_field_160e9) {
                iiiIiiiIi_Class478.I_method_ec4f2fb4(new iiiIiIiiI_Class471(iiiIIiIIi_Class4582, new iiiIIiIIi_Class458(n3 + nArray[0], n2 + 1, n + nArray[1]), iiiIiIiiI_Class471.Nested1_3588b480.II_field_bf45b207), iiiIIIiIi_Class4542, list);
            }
        }
        if (!bl) {
            iiiIiiiIi_Class478.I_method_ec4f2fb4(new iiiIiIiiI_Class471(iiiIIiIIi_Class4582, new iiiIIiIIi_Class458(n3, n2 - 1, n), iiiIiIiiI_Class471.Nested1_3588b480.i_field_bf45b207), iiiIIIiIi_Class4542, list);
            for (int[] nArray : I_field_160e9) {
                iiiIiiiIi_Class478.I_method_ec4f2fb4(new iiiIiiiII_Class477(iiiIIiIIi_Class4582, new iiiIIiIIi_Class458(n3 + nArray[0], n2, n + nArray[1])), iiiIIIiIi_Class4542, list);
                iiiIiiiIi_Class478.I_method_ec4f2fb4(new iiiIiIiii_Class472(iiiIIiIIi_Class4582, new iiiIIiIIi_Class458(n3 + nArray[0], n2 - 1, n + nArray[1])), iiiIIIiIi_Class4542, list);
            }
        }
    }

    private static void i_method_3017964(iiiIIiIIi_Class458 iiiIIiIIi_Class4582, iiiIIIiIi_Class454 iiiIIIiIi_Class4542, List<iiiIiIIII_Class465> list, boolean bl) {
        int n = iiiIIiIIi_Class4582.I_method_6d204e12();
        int n2 = iiiIIiIIi_Class4582.i_method_6d2ed9f2();
        int n3 = iiiIIiIIi_Class4582.II_method_36f86d15();
        for (int[] nArray : I_field_160e9) {
            int n4 = n + nArray[0];
            int n5 = n3 + nArray[1];
            iiiIiiiIi_Class478.I_method_ec4f2fb4(new iiiIiiIii_Class476(iiiIIiIIi_Class4582, new iiiIIiIIi_Class458(n4, n2, n5), iiiIiiIii_Class476.Nested1_6a615060.I_field_25809227), iiiIIIiIi_Class4542, list);
            if (!bl) {
                iiiIiiiIi_Class478.I_method_ec4f2fb4(new iiiIiiIii_Class476(iiiIIiIIi_Class4582, new iiiIIiIIi_Class458(n4, n2, n5), iiiIiiIii_Class476.Nested1_6a615060.iI_field_25809227), iiiIIIiIi_Class4542, list);
            }
            iiiIiiiIi_Class478.I_method_ec4f2fb4(new iiiIiiIii_Class476(iiiIIiIIi_Class4582, new iiiIIiIIi_Class458(n4, n2 + 1, n5), iiiIiiIii_Class476.Nested1_6a615060.ii_field_25809227), iiiIIIiIi_Class4542, list);
        }
        for (int[] nArray : i_field_160e9) {
            iiiIiiiIi_Class478.I_method_ec4f2fb4(new iiiIiiIii_Class476(iiiIIiIIi_Class4582, new iiiIIiIIi_Class458(n + nArray[0], n2, n3 + nArray[1]), iiiIiiIii_Class476.Nested1_6a615060.I_field_25809227), iiiIIIiIi_Class4542, list);
        }
        iiiIiiiIi_Class478.I_method_ec4f2fb4(new iiiIiiIii_Class476(iiiIIiIIi_Class4582, new iiiIIiIIi_Class458(n, n2 + 1, n3), iiiIiiIii_Class476.Nested1_6a615060.i_field_25809227), iiiIIIiIi_Class4542, list);
        iiiIiiiIi_Class478.I_method_ec4f2fb4(new iiiIiiIii_Class476(iiiIIiIIi_Class4582, new iiiIIiIIi_Class458(n, n2 - 1, n3), iiiIiiIii_Class476.Nested1_6a615060.II_field_25809227), iiiIIIiIi_Class4542, list);
    }

    private static boolean I_method_ec4f2fb4(iiiIiIIII_Class465 iiiIiIIII_Class4652, iiiIIIiIi_Class454 iiiIIIiIi_Class4542, List<iiiIiIIII_Class465> list) {
        boolean bl;
        if (!iiiIiIIII_Class4652.I_method_a7f2ac8b(iiiIIIiIi_Class4542)) {
            return false;
        }
        iiiIIiIIi_Class458 iiiIIiIIi_Class4582 = iiiIiIIII_Class4652.i_method_5e5afeb5();
        iiiIiIIII_Class4652.I_method_ad8aa21f(iiiIIIiIi_Class4542.i_method_674a3c72(iiiIIiIIi_Class4582.I_method_6d204e12(), iiiIIiIIi_Class4582.i_method_6d2ed9f2(), iiiIIiIIi_Class4582.II_method_36f86d15()));
        boolean bl2 = bl = iiiIiIIII_Class4652 instanceof iiiIiiiII_Class477 || iiiIiIIII_Class4652 instanceof iiiIiiIII_Class473 || iiiIiIIII_Class4652 instanceof iiiIiIIIi_Class466 || iiiIiIIII_Class4652 instanceof iiiIiIiii_Class472;
        if (bl && iiiIIIiIi_Class4542.II_method_1f35e205(iiiIIiIIi_Class4582.I_method_6d204e12(), iiiIIiIIi_Class4582.i_method_6d2ed9f2(), iiiIIiIIi_Class4582.II_method_36f86d15())) {
            iiiIIiIIi_Class458 iiiIIiIIi_Class4583 = iiiIiIIII_Class4652.I_method_48c58ad5();
            double d = Math.max(1.0, Math.hypot(iiiIIiIIi_Class4582.I_method_6d204e12() - iiiIIiIIi_Class4583.I_method_6d204e12(), iiiIIiIIi_Class4582.II_method_36f86d15() - iiiIIiIIi_Class4583.II_method_36f86d15()));
            iiiIiIIII_Class4652.I_method_ad8aa21f((iiiIIIiIi_Class4542.II_method_1f35e205(iiiIIiIIi_Class4582.I_method_6d204e12(), iiiIIiIIi_Class4582.i_method_6d2ed9f2() + 1, iiiIIiIIi_Class4582.II_method_36f86d15()) ? 5.0 : 0.8) * d);
        }
        list.add(iiiIiIIII_Class4652);
        return true;
    }
}

