package rockstar.client;

import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.TextSetting;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiIiIIIII_Class161;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiiIiiIii_Class220;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iIIIiIIiI_Class275;
import rockstar.client.iIIiIIIiI_Class291;
import rockstar.client.iI_Class3;

public class IiiiIiIIi_Class234
extends IiiIiiIii_Class220<TextSetting> {
    private IiIiIIIII_Class161 I_field_fdef2cc;
    private final IiiiIiIii_Class236 i_field_dc7facc = new IiiiIiIii_Class236(150L, IiiiIiiII_Class237.III_field_dd60aac);

    public IiiiIiIIi_Class234(TextSetting iiIIIIIiI_Class131, iI_Class3 iI_Class32) {
        super(iiIIIIIiI_Class131, iI_Class32);
    }

    @Override
    public void I_method_575ca63f() {
        this.II_field_46 = 13.0f;
        this.Ii_field_46 = 8.0f;
        this.I_field_fdef2cc = new IiIiIIIII_Class161(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f));
        this.I_field_fdef2cc.I_method_fb5af064(((TextSetting)this.I_field_ba11c26c).I_method_18d0e272());
        this.I_field_fdef2cc.i_method_ee124e69(((TextSetting)this.I_field_ba11c26c).II_method_da016c1e());
        this.I_field_fdef2cc.i_method_fd1e2055(((TextSetting)this.I_field_ba11c26c).i_method_9b12da03());
        this.I_field_fdef2cc.II_method_e557b20c(IiIiIIII_Class81.I_method_f25a980a("type_text"));
        this.i_field_dc7facc.I_method_edd6dd21(((TextSetting)this.I_field_ba11c26c).isVisible() ? 1.0f : 0.0f);
        super.I_method_575ca63f();
    }

    @Override
    public void II_method_b98d0c44(III iII) {
        this.i_field_dc7facc.I_method_edd72835(((TextSetting)this.I_field_ba11c26c).isVisible());
        super.II_method_b98d0c44(iII);
    }

    @Override
    protected void i_method_bdd4e0ec(III iII) {
        float f = this.I_field_46 + 8.0f;
        float f2 = this.i_field_46 + 15.0f;
        float f3 = this.II_field_46 - 16.0f;
        float f4 = this.Ii_field_46 - 20.0f;
        this.I_field_dc7facc.I_method_edd72835(this.I_method_a74dc6d0(iII.I_method_b1c3e152(), iII.i_method_b1d26d32()));
        if (this.I_method_7ae26dde(iII) && ((TextSetting)this.I_field_ba11c26c).isVisible() && this.I_method_c4c8e2f8().I_method_7ae26dde(iII)) {
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
        }
        float f5 = 13.0f;
        float f6 = 8.0f;
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f);
        float f7 = 10.0f;
        float f8 = iIiIIi_Class10.I_method_a649725c();
        float f9 = 19.0f;
        this.I_method_2d447471(iII, iIiIIi_Class10, IiIiIIII_Class81.I_method_f25a980a(((TextSetting)this.I_field_ba11c26c).getName()), this.I_field_46 + f7, this.i_field_46 + iIIiIIIiI_Class291.I_method_ef5e7a8f(iIiIIi_Class10.I_method_a649725c(), f9) - 0.5f, f3 - f5 - 20.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * (0.75f + 0.25f * this.I_field_dc7facc.I_method_6ac4da6f())), 0.7f, 0.99f);
        iII.drawRoundedRect(f, f2, f3, f4, IIiii_Class8.I_method_893b2757(4.0f), IiiiiIIIi_Class242.II_method_190e6391().withAlpha(76.5f));
        this.I_field_fdef2cc.I_method_b043bcc(f, f2, f3, f4);
        this.I_field_fdef2cc.iI_method_a8609f1e(this.i_field_dc7facc.I_method_6ac4da6f());
        this.I_field_fdef2cc.I_method_13a617e0(IiiiiIIIi_Class242.iI_method_8e08d3b1());
        this.I_field_fdef2cc.I_method_7ae26dda(iII);
        ((TextSetting)this.I_field_ba11c26c).I_method_104de33f(this.I_field_fdef2cc.I_method_d2579001());
    }

    @Override
    public void iI_method_20338844(III iII) {
        float f = 0.5f;
        iII.drawRect(this.I_field_46, this.i_field_46 + this.Ii_field_46, this.II_field_46, f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(5.1f));
    }

    @Override
    public void I_method_c1acbc24(int n, int n2, int n3) {
        this.I_field_fdef2cc.I_method_c1acbc24(n, n2, n3);
    }

    @Override
    public boolean I_method_b71e84c9(char c, int n) {
        return this.I_field_fdef2cc.I_method_b71e84c9(c, n);
    }

    @Override
    public void I_method_400ceaa7(double d, double d2, IiIII_Class9 iiIII_Class9) {
        this.I_field_fdef2cc.I_method_400ceaa7(d, d2, iiIII_Class9);
        super.i_method_6a097ac7(d, d2, iiIII_Class9);
    }

    @Override
    public void i_method_6a097ac7(double d, double d2, IiIII_Class9 iiIII_Class9) {
        this.I_field_fdef2cc.i_method_6a097ac7(d, d2, iiIII_Class9);
    }

    @Override
    public float Ii_method_2047ead7() {
        this.Ii_field_46 = 35.0f;
        return 35.0f;
    }
}

