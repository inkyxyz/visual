package rockstar.client;

import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.InterfaceModule;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.BooleanSetting;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiiIiiIii_Class220;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiIiiIi_Class238;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iIIIiIIiI_Class275;
import rockstar.client.iIIiIIIiI_Class291;
import rockstar.client.iI_Class3;
import ua.mintantileak.spk.Compile;

public class IiiIiiiii_Class224
extends IiiIiiIii_Class220<BooleanSetting> {
    private IiiiIiIii_Class236 i_field_dc7facc;
    private IiiiIiIii_Class236 II_field_dc7facc;
    private IiiiIiiIi_Class238 I_field_dd60e8c;

    public IiiIiiiii_Class224(BooleanSetting iIiiiIiii_Class120, iI_Class3 iI_Class32) {
        super(iIiiiIiii_Class120, iI_Class32);
    }

    @Override
    public void I_method_575ca63f() {
        this.i_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0f, IiiiIiiII_Class237.III_field_dd60aac);
        this.II_field_dc7facc = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.I_field_dd60aac);
        this.I_field_dd60e8c = new IiiiIiiIi_Class238(300L, new ColorRGBA(24.0f, 24.0f, 27.0f), IiiiIiiII_Class237.III_field_dd60aac);
        this.II_field_46 = 13.0f;
        this.Ii_field_46 = 8.0f;
        super.I_method_575ca63f();
    }

    @Override
    public void II_method_b98d0c44(III iII) {
        super.II_method_b98d0c44(iII);
    }

    @Override
    protected void i_method_bdd4e0ec(III iII) {
        this.i_field_dc7facc.I_method_edd6dd11(((BooleanSetting)this.I_field_ba11c26c).i_method_9b12da03() ? 1.0f : 0.75f);
        this.II_field_dc7facc.I_method_edd6dd11(((BooleanSetting)this.I_field_ba11c26c).i_method_9b12da03() ? 1.0f : 0.0f);
        this.I_field_dd60e8c.I_method_8895420(((BooleanSetting)this.I_field_ba11c26c).i_method_9b12da03() ? IiiiiIIIi_Class242.i_method_5dfec6e() : IiiiiIIIi_Class242.Ii_method_a0f56f71());
        this.I_field_dc7facc.I_method_edd72835(this.I_method_a74dc6d0(iII.I_method_b1c3e152(), iII.i_method_b1d26d32()));
        if (this.I_method_7ae26dde(iII) && (float)iII.i_method_b1d26d32() > this.III_method_f4aafe8f() && (float)iII.i_method_b1d26d32() < this.III_method_f4aafe8f() + this.IIi_method_f4b98a6f()) {
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
        }
        float f = 13.0f;
        float f2 = 8.0f;
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f);
        float f3 = 10.0f;
        float f4 = iIiIIi_Class10.I_method_a649725c();
        float f5 = 19.0f;
        this.I_method_2d447471(iII, iIiIIi_Class10, IiIiIIII_Class81.I_method_f25a980a(((BooleanSetting)this.I_field_ba11c26c).getName()), this.I_field_46 + f3, this.i_field_46 + iIIiIIIiI_Class291.I_method_ef5e7a8f(iIiIIi_Class10.I_method_a649725c(), f5) - 0.5f, this.II_field_46 - f - 20.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * (0.75f + 0.25f * this.II_field_dc7facc.I_method_6ac4da6f() + 0.25f * this.I_field_dc7facc.I_method_6ac4da6f())), 0.7f, 0.99f);
        ColorRGBA colorRGBA = this.I_field_dd60e8c.I_method_915b8ae().withAlpha(!((BooleanSetting)this.I_field_ba11c26c).i_method_9b12da03() ? 255.0f - 100.0f * InterfaceModule.I_method_fdcdb22f() : 255.0f);
        iII.drawRoundedRect(this.I_field_46 + this.II_field_46 - f - 9.0f, this.i_field_46 + 5.0f, f, f2, IIiii_Class8.I_method_893b2757(3.0f), colorRGBA);
        iII.drawRoundedRect(this.I_field_46 + this.II_field_46 - f - 8.5f + 5.0f * this.II_field_dc7facc.I_method_6ac4da6f(), this.i_field_46 + 5.5f, 7.0f, 7.0f, IIiii_Class8.I_method_893b2757(4.0f), IiiiiIIIi_Class242.I_method_35ed8eaf(colorRGBA).withAlpha(this.i_field_dc7facc.I_method_6ac4da6f() * 255.0f));
    }

    @Override
    public void Ii_method_6b12c484(III iII) {
    }

    @Override
    public void iI_method_20338844(III iII) {
        float f = 0.5f;
        iII.drawRect(this.I_field_46, this.i_field_46 + this.Ii_field_46, this.II_field_46, f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(5.1f));
    }

    @Override
    @Compile
    public void I_method_400ceaa7(double d, double d2, IiIII_Class9 iiIII_Class9) {
        if (this.I_method_a74cd690(d, d2) && iiIII_Class9 == IiIII_Class9.I_field_2f4c8d6c) {
            ((BooleanSetting)this.I_field_ba11c26c).toggle();
        }
        super.i_method_6a097ac7(d, d2, iiIII_Class9);
    }

    @Override
    public float Ii_method_2047ead7() {
        this.Ii_field_46 = 18.0f;
        return 18.0f;
    }
}

