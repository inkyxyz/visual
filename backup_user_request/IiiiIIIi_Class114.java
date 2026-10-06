package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import lombok.Generated;
import rockstar.client.III;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiIiIIIII_Class161;
import rockstar.client.IiiiIIii_Class116;
import rockstar.client.IiiiiIIIi_Class242;

public class IiiiIIIi_Class114 {
    private final float I_field_46 = 10.0f;
    private final IiIiIIIII_Class161 I_field_fdef2cc = new IiIiIIIII_Class161(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f));
    private boolean I_field_5a = false;

    public IiiiIIIi_Class114() {
        this.I_field_fdef2cc.II_method_e557b20c("\u041f\u043e\u0438\u0441\u043a...");
    }

    public void I_method_7ef743c8(boolean bl) {
        this.I_field_5a = bl;
        if (!bl) {
            this.I_field_fdef2cc.I_method_1d5afa89("");
        }
    }

    public void I_method_936b2a66(III iII, float f, float f2, float f3) {
        if (!this.I_field_5a) {
            return;
        }
        float f4 = f + 10.0f;
        float f5 = f3 - 20.0f;
        iII.drawRoundedRect(f4, f2, f5, 16.0f, IIiii_Class8.I_method_893b2757(3.0f), IiiiiIIIi_Class242.Ii_method_a0f56f71().mulAlpha(0.6f));
        this.I_field_fdef2cc.I_method_b043bcc(f4 + 4.0f, f2 + 2.0f, f5 - 8.0f, 12.0f);
        this.I_field_fdef2cc.I_method_13a617e0(IiiiiIIIi_Class242.iI_method_8e08d3b1());
        this.I_field_fdef2cc.I_method_7ae26dda(iII);
    }

    public List<IiiiIIii_Class116.Nested1_f85009b6> I_method_679132a(List<IiiiIIii_Class116.Nested1_f85009b6> list) {
        if (!this.I_field_5a || this.i_method_88480c70()) {
            return list;
        }
        String string = this.I_field_fdef2cc.I_method_d2579001().toLowerCase(Locale.ROOT);
        ArrayList<IiiiIIii_Class116.Nested1_f85009b6> arrayList = new ArrayList<IiiiIIii_Class116.Nested1_f85009b6>();
        for (IiiiIIii_Class116.Nested1_f85009b6 nested1_f85009b6 : list) {
            List<IiiiIIii_Class116.Nested1_8029513> list2 = this.I_method_da7a8960(nested1_f85009b6.I_method_f3e0b603(), string);
            if (list2.isEmpty()) continue;
            arrayList.add(new IiiiIIii_Class116.Nested1_f85009b6(nested1_f85009b6.I_method_916ad95c(), nested1_f85009b6.i_method_2489897c(), list2));
        }
        return arrayList;
    }

    public void I_method_1ef3c8da(double d, double d2, IiIII_Class9 iiIII_Class9) {
        if (this.I_field_5a) {
            this.I_field_fdef2cc.I_method_400ceaa7(d, d2, iiIII_Class9);
        }
    }

    public void I_method_9d544297(int n, int n2, int n3) {
        if (this.I_field_5a) {
            this.I_field_fdef2cc.I_method_c1acbc24(n, n2, n3);
        }
    }

    public void I_method_5fe733b2(char c, int n) {
        if (this.I_field_5a) {
            this.I_field_fdef2cc.I_method_b71e84c9(c, n);
        }
    }

    public void i_method_48f058fa(double d, double d2, IiIII_Class9 iiIII_Class9) {
        if (this.I_field_5a) {
            this.I_field_fdef2cc.i_method_6a097ac7(d, d2, iiIII_Class9);
        }
    }

    public float I_method_8839807c() {
        return this.I_field_5a ? 16.0f : 0.0f;
    }

    private boolean i_method_88480c70() {
        String string = this.I_field_fdef2cc.I_method_d2579001();
        return string == null || string.trim().isEmpty();
    }

    private List<IiiiIIii_Class116.Nested1_8029513> I_method_da7a8960(List<IiiiIIii_Class116.Nested1_8029513> list, String string) {
        ArrayList<IiiiIIii_Class116.Nested1_8029513> arrayList = new ArrayList<IiiiIIii_Class116.Nested1_8029513>();
        for (IiiiIIii_Class116.Nested1_8029513 nested1_8029513 : list) {
            String string2 = nested1_8029513.I_method_d1d7d0f9() != null ? nested1_8029513.I_method_d1d7d0f9() : nested1_8029513.I_method_c2b2cc91().getName().getString();
            if (!string2.toLowerCase(Locale.ROOT).contains(string)) continue;
            arrayList.add(nested1_8029513);
        }
        return arrayList;
    }

    @Generated
    public boolean I_method_88398090() {
        return this.I_field_5a;
    }
}

