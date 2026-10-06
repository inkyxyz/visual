package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import rockstar.client.IiIIii_Class20;

public final class IiIIiI_Class19 {
    private static final int II_field_49 = 4;
    private static final int Ii_field_49 = 32;
    public final IiIIii_Class20 I_field_ba459e01;
    public final int I_field_49;
    public final int i_field_49;
    public final int[][] I_field_160e9;
    public final int[][] i_field_160e9;
    public final float I_field_46;
    public final float i_field_46;
    public final float II_field_46;
    public final float Ii_field_46;

    private IiIIiI_Class19(IiIIii_Class20 iiIIii_Class20, int n, int n2, int[][] nArray, int[][] nArray2, float f, float f2, float f3, float f4) {
        this.I_field_ba459e01 = iiIIii_Class20;
        this.I_field_49 = n;
        this.i_field_49 = n2;
        this.I_field_160e9 = nArray;
        this.i_field_160e9 = nArray2;
        this.I_field_46 = f;
        this.i_field_46 = f2;
        this.II_field_46 = f3;
        this.Ii_field_46 = f4;
    }

    public int I_method_d160a5f() {
        int n = this.i_field_49 + this.I_field_49;
        for (int[] nArray : this.I_field_160e9) {
            n += nArray.length;
        }
        for (int[] nArray : this.i_field_160e9) {
            n += nArray.length;
        }
        return n;
    }

    public static IiIIiI_Class19 I_method_2760596a(IiIIii_Class20 iiIIii_Class20) {
        int n = iiIIii_Class20.I_field_49;
        float f = Math.max(iiIIii_Class20.I_method_43b11e3c(), 1.0E-6f);
        float f2 = Math.max(iiIIii_Class20.i_method_43bfaa1c(), 1.0E-6f);
        float f3 = Math.max(f, f2);
        int n2 = Math.max(1, Math.min(32, (n + 4 - 1) / 4));
        int n3 = Math.max(1, Math.min(32, Math.round((float)n2 * f / f3)));
        int n4 = Math.max(1, Math.min(32, Math.round((float)n2 * f2 / f3)));
        ArrayList<List<Integer>> arrayList = new ArrayList<List<Integer>>(n4);
        for (int i = 0; i < n4; ++i) {
            arrayList.add(new ArrayList());
        }
        ArrayList<List<Integer>> arrayList2 = new ArrayList<List<Integer>>(n3);
        for (int i = 0; i < n3; ++i) {
            arrayList2.add(new ArrayList());
        }
        float f4 = (float)n3 / f;
        float f5 = (float)n4 / f2;
        for (int i = 0; i < n; ++i) {
            int n5;
            int n6;
            int n7;
            int n8 = i * 6;
            float f6 = iiIIii_Class20.I_field_b4b[n8];
            float f7 = iiIIii_Class20.I_field_b4b[n8 + 1];
            float f8 = iiIIii_Class20.I_field_b4b[n8 + 2];
            float f9 = iiIIii_Class20.I_field_b4b[n8 + 3];
            float f10 = iiIIii_Class20.I_field_b4b[n8 + 4];
            float f11 = iiIIii_Class20.I_field_b4b[n8 + 5];
            float f12 = Math.min(f6, Math.min(f8, f10));
            float f13 = Math.max(f6, Math.max(f8, f10));
            float f14 = Math.min(f7, Math.min(f9, f11));
            float f15 = Math.max(f7, Math.max(f9, f11));
            if (f7 != f9 || f9 != f11) {
                n7 = IiIIiI_Class19.I_method_1fca22a2((f14 - iiIIii_Class20.II_field_46) * f5, n4);
                n6 = IiIIiI_Class19.I_method_1fca22a2((f15 - iiIIii_Class20.II_field_46) * f5, n4);
                for (n5 = n7; n5 <= n6; ++n5) {
                    ((List)arrayList.get(n5)).add(i);
                }
            }
            if (f6 == f8 && f8 == f10) continue;
            n7 = IiIIiI_Class19.I_method_1fca22a2((f12 - iiIIii_Class20.i_field_46) * f4, n3);
            n6 = IiIIiI_Class19.I_method_1fca22a2((f13 - iiIIii_Class20.i_field_46) * f4, n3);
            for (n5 = n7; n5 <= n6; ++n5) {
                ((List)arrayList2.get(n5)).add(i);
            }
        }
        return new IiIIiI_Class19(iiIIii_Class20, n3, n4, IiIIiI_Class19.I_method_576c3e09(arrayList, iiIIii_Class20, true), IiIIiI_Class19.I_method_576c3e09(arrayList2, iiIIii_Class20, false), f4, f5, -iiIIii_Class20.i_field_46 * f4, -iiIIii_Class20.II_field_46 * f5);
    }

    private static int I_method_1fca22a2(float f, int n) {
        return Math.max(0, Math.min(n - 1, (int)f));
    }

    private static int[][] I_method_576c3e09(List<List<Integer>> list, IiIIii_Class20 iiIIii_Class20, boolean bl) {
        int[][] nArrayArray = new int[list.size()][];
        for (int i = 0; i < list.size(); ++i) {
            List<Integer> list2 = list.get(i);
            list2.sort((n, n2) -> Float.compare(IiIIiI_Class19.I_method_8632080e(iiIIii_Class20, n2, bl), IiIIiI_Class19.I_method_8632080e(iiIIii_Class20, n, bl)));
            int[] nArray = new int[list2.size()];
            for (int j = 0; j < nArray.length; ++j) {
                nArray[j] = list2.get(j);
            }
            nArrayArray[i] = nArray;
        }
        return nArrayArray;
    }

    private static float I_method_8632080e(IiIIii_Class20 iiIIii_Class20, int n, boolean bl) {
        int n2 = n * 6 + (bl ? 0 : 1);
        return Math.max(iiIIii_Class20.I_field_b4b[n2], Math.max(iiIIii_Class20.I_field_b4b[n2 + 2], iiIIii_Class20.I_field_b4b[n2 + 4]));
    }
}

