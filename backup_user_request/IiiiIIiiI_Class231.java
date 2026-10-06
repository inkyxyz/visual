package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.RangeSetting;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiiIiiIii_Class220;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIIiIiI_Class267;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iIIIiIIiI_Class275;
import rockstar.client.iIIiIIIiI_Class291;
import rockstar.client.iI_Class3;

public class IiiiIIiiI_Class231
extends IiiIiiIii_Class220<RangeSetting> {
    private final IiiiIiIii_Class236 i_field_dc7facc = new IiiiIiIii_Class236(500L, IiiiIiiII_Class237.II_field_dd60aac);
    private final IiiiIiIii_Class236 II_field_dc7facc = new IiiiIiIii_Class236(500L, IiiiIiiII_Class237.II_field_dd60aac);
    private boolean I_field_5a;
    private boolean i_field_5a;
    private int I_field_49;

    public IiiiIIiiI_Class231(RangeSetting iIiiiiiiI_Class127, iI_Class3 iI_Class32) {
        super(iIiiiiiiI_Class127, iI_Class32);
    }

    @Override
    protected void i_method_bdd4e0ec(III iII) {
        float f;
        float f2 = this.I_field_46 + 9.0f;
        float f3 = this.i_field_46 + 2.0f;
        float f4 = this.II_field_46 - 18.0f;
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f);
        float f5 = 10.0f;
        float f6 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f).I_method_a649725c();
        float f7 = ((RangeSetting)this.I_field_ba11c26c).i_method_e92b420f();
        if (f7 >= (f = ((RangeSetting)this.I_field_ba11c26c).II_method_3a8908f2())) {
            f7 = ((RangeSetting)this.I_field_ba11c26c).II_method_3a8908f2();
            f = ((RangeSetting)this.I_field_ba11c26c).i_method_e92b420f();
        }
        this.i_field_dc7facc.I_method_edd6dd11(f7);
        this.II_field_dc7facc.I_method_edd6dd11(f);
        this.I_field_dc7facc.I_method_edd72835(this.I_method_a74dc6d0(iII.I_method_b1c3e152(), iII.i_method_b1d26d32()));
        iII.drawRoundedRect(f2, f3 + this.Ii_field_46 - 12.0f, f4, 2.0f, IIiii_Class8.I_method_893b2757(0.25f), IiiiiIIIi_Class242.Ii_method_a0f56f71().withAlpha(178.5f));
        iII.drawRoundedRect(f2 + f4 * iIIiIIIiI_Class291.I_method_fc7140f1(this.i_field_dc7facc.I_method_6ac4da6f(), ((RangeSetting)this.I_field_ba11c26c).Ii_method_3a9794d2(), ((RangeSetting)this.I_field_ba11c26c).iI_method_3c4bf912()), f3 + this.Ii_field_46 - 12.0f, f4 * iIIiIIIiI_Class291.I_method_fc7140f1(this.II_field_dc7facc.I_method_6ac4da6f(), ((RangeSetting)this.I_field_ba11c26c).Ii_method_3a9794d2(), ((RangeSetting)this.I_field_ba11c26c).iI_method_3c4bf912()) - f4 * iIIiIIIiI_Class291.I_method_fc7140f1(this.i_field_dc7facc.I_method_6ac4da6f(), ((RangeSetting)this.I_field_ba11c26c).Ii_method_3a9794d2(), ((RangeSetting)this.I_field_ba11c26c).iI_method_3c4bf912()), 2.0f, IIiii_Class8.I_method_893b2757(0.25f), IiiiiIIIi_Class242.i_method_5dfec6e());
        iII.drawShadow(f2 + f4 * iIIiIIIiI_Class291.I_method_fc7140f1(this.i_field_dc7facc.I_method_6ac4da6f(), ((RangeSetting)this.I_field_ba11c26c).Ii_method_3a9794d2(), ((RangeSetting)this.I_field_ba11c26c).iI_method_3c4bf912()) - 3.0f, f3 + this.Ii_field_46 - 14.0f, 6.0f, 6.0f, 10.0f, IIiii_Class8.I_method_893b2757(3.0f), ColorRGBA.BLACK.withAlpha(63.75f));
        iII.drawRoundedRect(f2 + f4 * iIIiIIIiI_Class291.I_method_fc7140f1(this.i_field_dc7facc.I_method_6ac4da6f(), ((RangeSetting)this.I_field_ba11c26c).Ii_method_3a9794d2(), ((RangeSetting)this.I_field_ba11c26c).iI_method_3c4bf912()) - 3.0f, f3 + this.Ii_field_46 - 14.0f, 6.0f, 6.0f, IIiii_Class8.I_method_893b2757(3.0f), ColorRGBA.WHITE);
        iII.drawShadow(f2 + f4 * iIIiIIIiI_Class291.I_method_fc7140f1(this.i_field_dc7facc.I_method_6ac4da6f(), ((RangeSetting)this.I_field_ba11c26c).Ii_method_3a9794d2(), ((RangeSetting)this.I_field_ba11c26c).iI_method_3c4bf912()) + f4 * iIIiIIIiI_Class291.I_method_fc7140f1(this.II_field_dc7facc.I_method_6ac4da6f(), ((RangeSetting)this.I_field_ba11c26c).Ii_method_3a9794d2(), ((RangeSetting)this.I_field_ba11c26c).iI_method_3c4bf912()) - f4 * iIIiIIIiI_Class291.I_method_fc7140f1(this.i_field_dc7facc.I_method_6ac4da6f(), ((RangeSetting)this.I_field_ba11c26c).Ii_method_3a9794d2(), ((RangeSetting)this.I_field_ba11c26c).iI_method_3c4bf912()) - 3.0f, f3 + this.Ii_field_46 - 14.0f, 6.0f, 6.0f, 10.0f, IIiii_Class8.I_method_893b2757(3.0f), ColorRGBA.BLACK.withAlpha(63.75f));
        iII.drawRoundedRect(f2 + f4 * iIIiIIIiI_Class291.I_method_fc7140f1(this.i_field_dc7facc.I_method_6ac4da6f(), ((RangeSetting)this.I_field_ba11c26c).Ii_method_3a9794d2(), ((RangeSetting)this.I_field_ba11c26c).iI_method_3c4bf912()) + f4 * iIIiIIIiI_Class291.I_method_fc7140f1(this.II_field_dc7facc.I_method_6ac4da6f(), ((RangeSetting)this.I_field_ba11c26c).Ii_method_3a9794d2(), ((RangeSetting)this.I_field_ba11c26c).iI_method_3c4bf912()) - f4 * iIIiIIIiI_Class291.I_method_fc7140f1(this.i_field_dc7facc.I_method_6ac4da6f(), ((RangeSetting)this.I_field_ba11c26c).Ii_method_3a9794d2(), ((RangeSetting)this.I_field_ba11c26c).iI_method_3c4bf912()) - 3.0f, f3 + this.Ii_field_46 - 14.0f, 6.0f, 6.0f, IIiii_Class8.I_method_893b2757(3.0f), ColorRGBA.WHITE);
        String string = IiIiIIII_Class81.I_method_1410d1e5("ui.range_format", iIIIIiIiI_Class267.i_method_f3c598a1(this.i_field_dc7facc.I_method_6ac4da6f()), iIIIIiIiI_Class267.i_method_f3c598a1(this.II_field_dc7facc.I_method_6ac4da6f()));
        this.I_method_2d447471(iII, iIiIIi_Class10, IiIiIIII_Class81.I_method_f25a980a(((RangeSetting)this.I_field_ba11c26c).getName()), this.I_field_46 + f5, f3 + 11.0f - iIiIIi_Class10.I_method_a649725c(), this.I_method_c4c8e2f8().II_method_c7206932() - f5 - IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f).I_method_2c375926(string) - 10.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * (0.75f + 0.25f * this.I_field_dc7facc.I_method_6ac4da6f())), 0.8f, 1.0f);
        if (this.I_method_7ae26dde(iII) && (float)iII.i_method_b1d26d32() > this.III_method_f4aafe8f() && (float)iII.i_method_b1d26d32() < this.III_method_f4aafe8f() + this.IIi_method_f4b98a6f()) {
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
        }
        if ((this.I_field_5a || this.i_field_5a) && !iIIiIIIiI_Class291.I_method_f734a088(this.I_field_49)) {
            this.I_field_5a = false;
            this.i_field_5a = false;
        }
        if (this.I_field_5a) {
            float f8 = iIIiIIIiI_Class291.I_method_a531f52f(((RangeSetting)this.I_field_ba11c26c).Ii_method_3a9794d2(), ((RangeSetting)this.I_field_ba11c26c).iI_method_3c4bf912(), f2, f4, iII.I_method_b1c3e152());
            ((RangeSetting)this.I_field_ba11c26c).I_method_3a7a7961(f8);
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.II_field_aa52e62c);
        } else if (this.i_field_5a) {
            float f9 = iIIiIIIiI_Class291.I_method_a531f52f(((RangeSetting)this.I_field_ba11c26c).Ii_method_3a9794d2(), ((RangeSetting)this.I_field_ba11c26c).iI_method_3c4bf912(), f2, f4, iII.I_method_b1c3e152());
            ((RangeSetting)this.I_field_ba11c26c).i_method_3c3d6981(f9);
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.II_field_aa52e62c);
        }
    }

    @Override
    public void Ii_method_6b12c484(III iII) {
        float f = this.I_field_46 + 9.0f;
        float f2 = this.i_field_46 + 2.0f;
        float f3 = this.II_field_46 - 18.0f;
        float f4 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f).I_method_a649725c();
        String string = IiIiIIII_Class81.I_method_1410d1e5("ui.range_format", iIIIIiIiI_Class267.i_method_f3c598a1(this.i_field_dc7facc.I_method_6ac4da6f()), iIIIIiIiI_Class267.i_method_f3c598a1(this.II_field_dc7facc.I_method_6ac4da6f()));
        iII.drawRightText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), string, f + f3, f2 + 11.0f - f4, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * (0.75f + 0.25f * this.I_field_dc7facc.I_method_6ac4da6f()) * RenderSystem.getShaderColor()[3]));
    }

    @Override
    public void iI_method_20338844(III iII) {
        float f = 0.5f;
        iII.drawRect(this.I_field_46, this.i_field_46 + this.Ii_field_46, this.II_field_46, f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(5.1f));
    }

    @Override
    public void I_method_400ceaa7(double d, double d2, IiIII_Class9 iiIII_Class9) {
        float f = this.I_field_46 + 9.0f;
        float f2 = this.II_field_46 - 18.0f;
        if (this.I_method_a74cd690(d, d2)) {
            float f3;
            float f4 = (float)Math.abs(d - (double)(f + f2 * iIIiIIIiI_Class291.I_method_fc7140f1(((RangeSetting)this.I_field_ba11c26c).i_method_e92b420f(), ((RangeSetting)this.I_field_ba11c26c).Ii_method_3a9794d2(), ((RangeSetting)this.I_field_ba11c26c).iI_method_3c4bf912())));
            if (f4 < (f3 = (float)Math.abs(d - (double)(f + f2 * iIIiIIIiI_Class291.I_method_fc7140f1(((RangeSetting)this.I_field_ba11c26c).II_method_3a8908f2(), ((RangeSetting)this.I_field_ba11c26c).Ii_method_3a9794d2(), ((RangeSetting)this.I_field_ba11c26c).iI_method_3c4bf912()))))) {
                this.I_field_5a = true;
            } else {
                this.i_field_5a = true;
            }
            this.I_field_49 = iiIII_Class9.I_method_6d899712();
        }
        super.I_method_400ceaa7(d, d2, iiIII_Class9);
    }

    @Override
    public void i_method_6a097ac7(double d, double d2, IiIII_Class9 iiIII_Class9) {
        this.I_field_5a = false;
        this.i_field_5a = false;
        super.i_method_6a097ac7(d, d2, iiIII_Class9);
    }

    @Override
    public float Ii_method_2047ead7() {
        this.Ii_field_46 = 29.0f;
        return 29.0f;
    }
}

