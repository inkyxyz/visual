package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import net.minecraft.item.ItemStack;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiiIiiiI_Class111;
import rockstar.client.IiiiIIII_Class113;
import rockstar.client.IiiiIIIi_Class114;
import rockstar.client.IiiiIIiI_Class115;
import rockstar.client.IiiiIIii_Class116;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIiIIiIi_Class294;

public class IiiIiIii_Class108
implements iIIiIIiIi_Class294 {
    private final float I_field_46 = 10.0f;
    private float i_field_46;
    private float II_field_46;
    private float Ii_field_46;
    private float iI_field_46;
    private final IiiIiiiI_Class111 I_field_dc1e3fa1 = new IiiIiiiI_Class111();
    private final IiiiIIIi_Class114 I_field_10e76341 = new IiiiIIIi_Class114();
    private final IiiiIIII_Class113 I_field_10e75f61 = new IiiiIIII_Class113();
    private final IiiiIIiI_Class115 I_field_10e7d781 = new IiiiIIiI_Class115();
    private List<IiiiIIii_Class116.Nested1_f85009b6> I_field_7865b31 = new ArrayList<IiiiIIii_Class116.Nested1_f85009b6>();
    private List<IiiiIIii_Class116.Nested1_f85009b6> i_field_7865b31 = new ArrayList<IiiiIIii_Class116.Nested1_f85009b6>();
    private ItemStack I_field_f2735522;

    public IiiIiIii_Class108() {
        this.i_method_246f30cc();
    }

    public String I_method_1c324534() {
        return this.I_field_10e7d781.I_method_c4f6d154();
    }

    public String i_method_af50f554() {
        return this.I_field_10e7d781.i_method_58158174();
    }

    private void i_method_246f30cc() {
        this.I_field_7865b31 = IiiiIIii_Class116.I_method_5efe7a3f(this.I_field_dc1e3fa1.I_method_b951df86());
        this.i_field_7865b31 = this.I_field_10e76341.I_method_679132a(this.I_field_7865b31);
        this.I_field_10e75f61.I_method_519e6cac();
    }

    public float I_method_2460a4dc() {
        float f = 30.0f;
        float f2 = 36.0f;
        return 20.0f + f + 4.0f * f2;
    }

    public void I_method_2460a4ec() {
        this.I_field_10e7d781.I_method_ee65d4cc();
        this.I_field_f2735522 = null;
    }

    public void I_method_f047594e(ItemStack itemStack) {
        this.I_field_10e7d781.I_method_2bff812e(itemStack);
        this.I_field_f2735522 = this.I_field_10e7d781.I_method_c7e51c6c();
    }

    public void I_method_a8e311ba(III iII, float f, float f2, float f3, float f4) {
        this.i_field_46 = f;
        this.II_field_46 = f2;
        this.Ii_field_46 = f3;
        this.iI_field_46 = f4;
        this.i_method_d2dfa1da(iII, f, f2, f3, f4);
        float f5 = f2 + 10.0f;
        this.I_field_dc1e3fa1.I_method_37f5b6c6(iII, f, f5, f3);
        float f6 = f5 + this.I_field_dc1e3fa1.I_method_e9eb2cdc() + 4.0f;
        this.I_field_10e76341.I_method_7ef743c8(this.I_field_dc1e3fa1.I_method_b951df86() == IiiiIIii_Class116.Nested1_80294f3.I_field_765e39dc);
        this.I_field_10e76341.I_method_936b2a66(iII, f, f6, f3);
        float f7 = f6 + this.I_field_10e76341.I_method_8839807c() + (this.I_field_10e76341.I_method_88398090() ? 4.0f : 10.0f);
        float f8 = f4 - (f7 - f2);
        this.I_field_10e75f61.I_method_838c03ac(iII, this.i_field_7865b31, this.I_field_10e7d781, f, f7, f3, f8);
        this.I_field_f2735522 = this.I_field_10e7d781.I_method_c7e51c6c();
    }

    public void I_method_eddc507a(double d, double d2, IiIII_Class9 iiIII_Class9) {
        if (iiIII_Class9 != IiIII_Class9.I_field_2f4c8d6c) {
            return;
        }
        float f = this.II_field_46 + 10.0f;
        if (this.I_field_dc1e3fa1.I_method_b2745698(d, d2, this.i_field_46, f, this.Ii_field_46)) {
            this.i_method_246f30cc();
            this.I_method_2460a4ec();
            return;
        }
        float f2 = f + this.I_field_dc1e3fa1.I_method_e9eb2cdc() + 4.0f;
        this.I_field_10e76341.I_method_1ef3c8da(d, d2, iiIII_Class9);
        float f3 = f2 + this.I_field_10e76341.I_method_8839807c() + (this.I_field_10e76341.I_method_88398090() ? 4.0f : 10.0f);
        float f4 = this.iI_field_46 - (f3 - this.II_field_46);
        this.I_field_10e75f61.I_method_93822d62(d, d2, this.i_field_7865b31, this.I_field_10e7d781, this.i_field_46, f3, f4);
        this.I_field_f2735522 = this.I_field_10e7d781.I_method_c7e51c6c();
    }

    public void I_method_4c0d7412(double d, double d2, double d3) {
        this.I_field_10e75f61.I_method_e8d30b52(d, d2, d3, this.i_field_46, this.II_field_46, this.Ii_field_46, this.iI_field_46);
    }

    public void I_method_4c564237(int n, int n2, int n3) {
        this.I_field_10e76341.I_method_9d544297(n, n2, n3);
        this.i_field_7865b31 = this.I_field_10e76341.I_method_679132a(this.I_field_7865b31);
    }

    public void I_method_8ed6c012(char c, int n) {
        this.I_field_10e76341.I_method_5fe733b2(c, n);
        this.i_field_7865b31 = this.I_field_10e76341.I_method_679132a(this.I_field_7865b31);
    }

    public void i_method_17d8e09a(double d, double d2, IiIII_Class9 iiIII_Class9) {
        this.I_field_10e76341.i_method_48f058fa(d, d2, iiIII_Class9);
    }

    private void i_method_d2dfa1da(III iII, float f, float f2, float f3, float f4) {
        iII.drawBlurredRect(f, f2, f3, f4, 45.0f, 5.0f, IIiii_Class8.I_method_893b2757(8.0f), ColorRGBA.WHITE.withAlpha(255.0f));
        iII.drawSquircle(f, f2, f3, f4, 2.0f, IIiii_Class8.I_method_893b2757(8.0f), IiiiiIIIi_Class242.II_method_190e6391().withAlpha(255.0f * IiiiiIIIi_Class242.I_method_5ac4a715().II_method_b3b834f2()));
    }

    @Generated
    public ItemStack I_method_ad31c04c() {
        return this.I_field_f2735522;
    }
}

