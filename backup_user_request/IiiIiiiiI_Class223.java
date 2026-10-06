package rockstar.client;

import java.util.List;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.RegistryListSetting;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiIiIIIII_Class161;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiiIiiIii_Class220;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iIIIiIIiI_Class275;
import rockstar.client.iIIiIIIiI_Class291;
import rockstar.client.iI_Class3;
import rockstar.client.iiIIIIiII_Class389;

public class IiiIiiiiI_Class223
extends IiiIiiIii_Class220<RegistryListSetting> {
    private static final float III_field_46 = 19.0f;
    private static final float IIi_field_46 = 6.0f;
    private static final float IiI_field_46 = 20.0f;
    private static final float Iii_field_46 = 2.0f;
    private static final float iII_field_46 = 16.0f;
    private static final float iIi_field_46 = 0.9f;
    private static final float iiI_field_46 = 14.0f;
    private static final float iii_field_46 = 5.0f;
    private final IiIiIIIII_Class161 I_field_fdef2cc = new IiIiIIIII_Class161(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f));
    private IIiIIi_Class10 I_field_856d0221;
    private IIiIIi_Class10 i_field_856d0221;

    public IiiIiiiiI_Class223(RegistryListSetting iIiiiIiiI_Class119, iI_Class3 iI_Class32) {
        super(iIiiiIiiI_Class119, iI_Class32);
        this.I_field_fdef2cc.I_method_1d5afa89(iIiiiIiiI_Class119.II_method_d1c5b7be());
    }

    @Override
    public final void I_method_575ca63f() {
        this.I_field_fdef2cc.II_method_e557b20c(IiIiIIII_Class81.I_method_f25a980a("search"));
        this.I_field_856d0221 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0f);
        this.i_field_856d0221 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0f);
        super.I_method_575ca63f();
    }

    @Override
    protected final void i_method_bdd4e0ec(III iII) {
        boolean bl;
        float f;
        float f2;
        float f3;
        float f4;
        int n;
        float f5 = this.I_field_46 + 9.0f;
        float f6 = this.i_field_46 + 1.0f;
        float f7 = this.II_field_46 - 18.0f;
        this.I_field_dc7facc.I_method_edd72835(this.I_method_a74dc6d0(iII.I_method_b1c3e152(), iII.i_method_b1d26d32()));
        float f8 = 10.0f;
        String string = "%d/%d".formatted(((RegistryListSetting)this.I_field_ba11c26c).I_method_608ed612(), ((RegistryListSetting)this.I_field_ba11c26c).II_method_e0c3c4e5().size());
        this.I_method_2d447471(iII, this.I_field_856d0221, IiIiIIII_Class81.I_method_f25a980a(((RegistryListSetting)this.I_field_ba11c26c).getName()), this.I_field_46 + f8, f6 - 1.0f + iIIiIIIiI_Class291.I_method_ef5e7a8f(this.I_field_856d0221.I_method_a649725c(), 19.0f), this.I_method_c4c8e2f8().II_method_c7206932() - f8 - 10.0f - this.i_field_856d0221.I_method_2c375926(string), IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * (0.75f + 0.25f * this.I_field_dc7facc.I_method_6ac4da6f())), 0.8f, 1.0f);
        iII.drawRightText(this.i_field_856d0221, string, f5 + f7, f6 - 1.0f + iIIiIIIiI_Class291.I_method_ef5e7a8f(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f).I_method_a649725c(), 19.0f), IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * (0.6f + 0.4f * this.I_field_dc7facc.I_method_6ac4da6f())));
        this.I_field_fdef2cc.II_method_e557b20c(IiIiIIII_Class81.I_method_f25a980a("search"));
        ((RegistryListSetting)this.I_field_ba11c26c).I_method_712c5629(this.I_field_fdef2cc.I_method_d2579001());
        List<RegistryListSetting.Nested1_be9d460> list = ((RegistryListSetting)this.I_field_ba11c26c).I_method_325a1a48();
        int n2 = this.I_method_7fff0154(f7);
        int n3 = list.size();
        int n4 = Math.max(1, (int)Math.ceil((float)n3 / (float)n2));
        float f9 = f5 - 1.0f;
        float f10 = f6 + 17.0f;
        float f11 = f5 + 6.0f;
        float f12 = f10 + 5.0f;
        float f13 = Math.max(0.0f, f7 - 12.0f);
        float f14 = f5 + 6.0f;
        float f15 = f12 + 14.0f + 6.0f;
        float f16 = (float)n4 * 20.0f;
        float f17 = 25.0f + f16 + 6.0f;
        iII.drawRoundedRect(f9, f10, f7 + 2.0f, f17, IIiii_Class8.I_method_893b2757(6.0f), IiiiiIIIi_Class242.II_method_190e6391().withAlpha(76.5f));
        this.I_field_fdef2cc.I_method_b043bcc(f11, f12, f13, 14.0f);
        this.I_field_fdef2cc.I_method_13a617e0(IiiiiIIIi_Class242.iI_method_8e08d3b1());
        this.I_field_fdef2cc.iI_method_a8609f1e(1.0f);
        this.I_field_fdef2cc.I_method_7ae26dda(iII);
        float f18 = this.i_field_46;
        float f19 = this.i_field_46 + this.Ii_field_46;
        iiIIIIiII_Class389 iiIIIIiII_Class3892 = new iiIIIIiII_Class389();
        for (int i = 0; i < n3; ++i) {
            RegistryListSetting.Nested1_be9d460 nested1_be9d460 = list.get(i);
            int n5 = i % n2;
            n = i / n2;
            float f20 = f14 + (float)n5 * 20.0f;
            f4 = f15 + (float)n * 20.0f;
            f3 = f20 + 2.0f;
            f2 = f4 + 2.0f;
            f = 0.8000002f;
            if (f2 + 16.0f < this.iI_field_46 || f2 > this.iI_field_46 + this.ii_field_46 * 2.0f) continue;
            boolean bl2 = iIIiIIIiI_Class291.I_method_da20b32b(f20, f4, 20.0, 20.0, iII);
            bl = ((RegistryListSetting)this.I_field_ba11c26c).I_method_40659e26(nested1_be9d460);
            ColorRGBA colorRGBA = IiiiiIIIi_Class242.II_method_190e6391().mulAlpha(0.22f + (bl2 ? 0.08f : 0.0f));
            ColorRGBA colorRGBA2 = IiiiiIIIi_Class242.i_method_5dfec6e().mulAlpha(0.7f);
            nested1_be9d460.I_method_c4d07c90().I_method_8895420(bl ? colorRGBA2 : colorRGBA);
            if (bl2 && (float)iII.i_method_b1d26d32() > this.III_method_f4aafe8f() && (float)iII.i_method_b1d26d32() < this.III_method_f4aafe8f() + this.IIi_method_f4b98a6f()) {
                iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
            }
            iII.drawRoundedRect(f3, f2, 16.0f, 16.0f, IIiii_Class8.I_method_893b2757(4.0f), nested1_be9d460.I_method_c4d07c90().I_method_915b8ae());
        }
        iiIIIIiII_Class3892.II_method_ed687102();
        try (CustomDrawContext.Nested1_f061f568 nested1_f061f568 = iII.beginItemBatch();){
            for (int i = 0; i < n3; ++i) {
                RegistryListSetting.Nested1_be9d460 nested1_be9d460 = list.get(i);
                n = i % n2;
                int n6 = i / n2;
                f4 = f14 + (float)n * 20.0f;
                f3 = f15 + (float)n6 * 20.0f;
                f2 = f4 + 2.0f;
                f = f3 + 2.0f;
                float f21 = 0.8000002f;
                if (f + 16.0f < this.iI_field_46 || f > this.iI_field_46 + this.ii_field_46 * 2.0f) continue;
                bl = iIIiIIIiI_Class291.I_method_da20b32b(f4, f3, 20.0, 20.0, iII);
                if (bl) {
                    iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
                }
                iII.drawBatchItem(nested1_be9d460.I_method_533bf89e(), f2 + f21, f + f21, 0.9f);
            }
        }
        for (int i = 0; i < n3; ++i) {
            RegistryListSetting.Nested1_be9d460 nested1_be9d460 = list.get(i);
            int n7 = i % n2;
            n = i / n2;
            float f22 = f14 + (float)n7 * 20.0f;
            f4 = f15 + (float)n * 20.0f;
            f3 = f22 + 2.0f;
            f2 = f4 + 2.0f;
            if (f2 + 16.0f < this.iI_field_46 || f2 > this.iI_field_46 + this.ii_field_46 * 2.0f) continue;
            boolean bl3 = iIIiIIIiI_Class291.I_method_da20b32b(f22, f4, 20.0, 20.0, iII);
            boolean bl4 = ((RegistryListSetting)this.I_field_ba11c26c).I_method_40659e26(nested1_be9d460);
            nested1_be9d460.I_method_c4c268d0().I_method_edd6dd11(bl3 ? 0.6f : 0.0f);
            if (bl3) {
                iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
            }
            iII.drawRoundedBorder(f3, f2, 16.0f, 16.0f, 1.2f, IIiii_Class8.I_method_893b2757(4.0f), IiiiiIIIi_Class242.i_method_5dfec6e().mulAlpha(nested1_be9d460.I_method_c4c268d0().I_method_6ac4da6f()));
        }
    }

    @Override
    public final void I_method_400ceaa7(double d, double d2, IiIII_Class9 iiIII_Class9) {
        this.I_field_fdef2cc.I_method_400ceaa7(d, d2, iiIII_Class9);
        if (iiIII_Class9 != IiIII_Class9.I_field_2f4c8d6c) {
            super.I_method_400ceaa7(d, d2, iiIII_Class9);
            return;
        }
        float f = this.I_field_46 + 9.0f;
        float f2 = f + 6.0f;
        float f3 = this.i_field_46 + 17.0f;
        float f4 = f3 + 5.0f;
        float f5 = this.II_field_46 - 18.0f;
        float f6 = Math.max(0.0f, f5 - 12.0f);
        if (iIIiIIIiI_Class291.I_method_c3f86263(f2, f4, f6, 14.0, d, d2)) {
            super.I_method_400ceaa7(d, d2, iiIII_Class9);
            return;
        }
        int n = this.I_method_7fff0154(f5);
        float f7 = f + 6.0f;
        float f8 = f4 + 14.0f + 6.0f;
        List<RegistryListSetting.Nested1_be9d460> list = ((RegistryListSetting)this.I_field_ba11c26c).I_method_325a1a48();
        for (int i = 0; i < list.size(); ++i) {
            RegistryListSetting.Nested1_be9d460 nested1_be9d460 = list.get(i);
            int n2 = i % n;
            float f9 = f7 + (float)n2 * 20.0f;
            int n3 = i / n;
            float f10 = f8 + (float)n3 * 20.0f;
            if (!iIIiIIIiI_Class291.I_method_c3f86263(f9, f10, 20.0, 20.0, d, d2)) continue;
            ((RegistryListSetting)this.I_field_ba11c26c).I_method_40659e22(nested1_be9d460);
            break;
        }
        super.I_method_400ceaa7(d, d2, iiIII_Class9);
    }

    @Override
    public final void i_method_6a097ac7(double d, double d2, IiIII_Class9 iiIII_Class9) {
        this.I_field_fdef2cc.i_method_6a097ac7(d, d2, iiIII_Class9);
        super.i_method_6a097ac7(d, d2, iiIII_Class9);
    }

    @Override
    public final void I_method_c1acbc24(int n, int n2, int n3) {
        this.I_field_fdef2cc.I_method_c1acbc24(n, n2, n3);
        super.I_method_c1acbc24(n, n2, n3);
    }

    @Override
    public final boolean I_method_b71e84c9(char c, int n) {
        if (this.I_field_fdef2cc.I_method_b71e84c9(c, n)) {
            return true;
        }
        return super.I_method_b71e84c9(c, n);
    }

    @Override
    public final void iI_method_20338844(III iII) {
        float f = 0.5f;
        iII.drawRect(this.I_field_46, this.i_field_46 + this.Ii_field_46, this.II_field_46, f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(5.1f));
    }

    @Override
    public final float Ii_method_2047ead7() {
        float f = this.II_field_46 - 18.0f;
        int n = this.I_method_7fff0154(f);
        int n2 = ((RegistryListSetting)this.I_field_ba11c26c).I_method_325a1a48().size();
        int n3 = Math.max(1, (int)Math.ceil((float)n2 / (float)n));
        float f2 = (float)n3 * 20.0f;
        float f3 = 25.0f + f2 + 6.0f;
        this.Ii_field_46 = 23.0f + f3;
        return this.Ii_field_46;
    }

    private int I_method_7fff0154(float f) {
        float f2 = Math.max(f - 12.0f, 20.0f);
        int n = (int)Math.floor(f2 / 20.0f);
        return Math.max(1, n);
    }
}

