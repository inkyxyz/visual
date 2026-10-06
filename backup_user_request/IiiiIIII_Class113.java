package rockstar.client;

import java.util.List;
import rockstar.client.III;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IiiIiiii_Class112;
import rockstar.client.IiiiIIiI_Class115;
import rockstar.client.IiiiIIii_Class116;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIiIIIiI_Class291;
import rockstar.client.iIiiiIiII_Class373;

public class IiiiIIII_Class113 {
    private final float I_field_46 = 30.0f;
    private final float i_field_46 = 34.0f;
    private final float II_field_46 = 36.0f;
    private final float Ii_field_46 = 10.0f;
    private float iI_field_46 = 0.0f;
    private float ii_field_46 = 0.0f;

    public void I_method_838c03ac(III iII, List<IiiiIIii_Class116.Nested1_f85009b6> list, IiiiIIiI_Class115 iiiiIIiI_Class115, float f, float f2, float f3, float f4) {
        iIiiiIiII_Class373.I_method_d5a5ee51(iII.getMatrices(), f, f2, f3, f4);
        float f5 = f2 - this.iI_field_46;
        float f6 = 0.0f;
        boolean bl = false;
        for (IiiiIIii_Class116.Nested1_f85009b6 nested1_f85009b6 : list) {
            int n = this.I_method_5d496a53(nested1_f85009b6, iiiiIIiI_Class115);
            if (n == 0) continue;
            bl = true;
            if (f5 > f2 + f4) {
                f6 += 12.0f + this.I_method_e22f9bc7(n);
                continue;
            }
            if (f5 + 12.0f >= f2) {
                iII.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), nested1_f85009b6.i_method_2489897c(), f + 10.0f, f5, IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(0.9f));
            }
            f5 += 12.0f;
            f5 = this.I_method_c6c6af42(iII, nested1_f85009b6, iiiiIIiI_Class115, f5, f, f2, f4);
            f6 = f5 - (f2 - this.iI_field_46);
        }
        if (!bl) {
            String string = "\u041d\u0435\u0442 \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u043e\u0432";
            float f7 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f).I_method_2c375926(string);
            float f8 = f + (f3 - f7) / 2.0f;
            float f9 = f2 + (f4 - IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f).I_method_a649725c()) / 2.0f;
            iII.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f), string, f8, f9, IiiiiIIIi_Class242.Ii_field_d0c8ec5.withAlpha(0.7f));
        }
        this.ii_field_46 = Math.max(0.0f, f6 - f4);
        this.iI_field_46 = Math.max(0.0f, Math.min(this.iI_field_46, this.ii_field_46));
        iIiiiIiII_Class373.I_method_ff80a1df();
    }

    public void I_method_93822d62(double d, double d2, List<IiiiIIii_Class116.Nested1_f85009b6> list, IiiiIIiI_Class115 iiiiIIiI_Class115, float f, float f2, float f3) {
        if (d2 < (double)f2 || d2 > (double)(f2 + f3)) {
            return;
        }
        float f4 = f2 - this.iI_field_46;
        for (IiiiIIii_Class116.Nested1_f85009b6 nested1_f85009b6 : list) {
            if (this.I_method_5d496a53(nested1_f85009b6, iiiiIIiI_Class115) == 0) continue;
            if (this.I_method_99034a24(nested1_f85009b6, iiiiIIiI_Class115, d, d2, f4 += 12.0f, f)) {
                return;
            }
            f4 += this.I_method_e22f9bc7(this.I_method_5d496a53(nested1_f85009b6, iiiiIIiI_Class115));
        }
    }

    public void I_method_e8d30b52(double d, double d2, double d3, float f, float f2, float f3, float f4) {
        if (iIIiIIIiI_Class291.I_method_c3f86263(f, f2, f3, f4, d, d2)) {
            this.iI_field_46 = Math.max(0.0f, Math.min(this.iI_field_46 - (float)d3 * 20.0f, this.ii_field_46));
        }
    }

    public void I_method_519e6cac() {
        this.iI_field_46 = 0.0f;
        this.ii_field_46 = 0.0f;
    }

    private float I_method_c6c6af42(III iII, IiiiIIii_Class116.Nested1_f85009b6 nested1_f85009b6, IiiiIIiI_Class115 iiiiIIiI_Class115, float f, float f2, float f3, float f4) {
        int n = 0;
        int n2 = 0;
        for (IiiiIIii_Class116.Nested1_8029513 nested1_8029513 : nested1_f85009b6.I_method_f3e0b603()) {
            if (iiiiIIiI_Class115.i_method_8b196aec(nested1_8029513)) continue;
            int n3 = n % 5;
            int n4 = n / 5;
            n2 = Math.max(n2, n4);
            float f5 = f2 + 10.0f + (float)n3 * 36.0f;
            float f6 = f + (float)n4 * 36.0f;
            if (f6 + 34.0f >= f3 && f6 <= f3 + f4) {
                IiiIiiii_Class112.I_method_24761bd(iII, IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.0f), nested1_8029513, f5, f6, 30.0f, 34.0f, iiiiIIiI_Class115.I_method_85116f0c(nested1_8029513));
            }
            ++n;
        }
        return f + (float)(n2 + 1) * 36.0f + 8.0f;
    }

    private boolean I_method_99034a24(IiiiIIii_Class116.Nested1_f85009b6 nested1_f85009b6, IiiiIIiI_Class115 iiiiIIiI_Class115, double d, double d2, float f, float f2) {
        int n = 0;
        for (IiiiIIii_Class116.Nested1_8029513 nested1_8029513 : nested1_f85009b6.I_method_f3e0b603()) {
            if (iiiiIIiI_Class115.i_method_8b196aec(nested1_8029513)) continue;
            int n2 = n % 5;
            float f3 = f2 + 10.0f + (float)n2 * 36.0f;
            int n3 = n / 5;
            float f4 = f + (float)n3 * 36.0f;
            if (iIIiIIIiI_Class291.I_method_c3f86263(f3, f4, 30.0, 34.0, d, d2)) {
                iiiiIIiI_Class115.I_method_85116f08(nested1_8029513);
                return true;
            }
            ++n;
        }
        return false;
    }

    private int I_method_5d496a53(IiiiIIii_Class116.Nested1_f85009b6 nested1_f85009b6, IiiiIIiI_Class115 iiiiIIiI_Class115) {
        int n = 0;
        for (IiiiIIii_Class116.Nested1_8029513 nested1_8029513 : nested1_f85009b6.I_method_f3e0b603()) {
            if (iiiiIIiI_Class115.i_method_8b196aec(nested1_8029513)) continue;
            ++n;
        }
        return n;
    }

    private float I_method_e22f9bc7(int n) {
        int n2 = (n + 5 - 1) / 5;
        return (float)n2 * 36.0f + 8.0f;
    }
}

