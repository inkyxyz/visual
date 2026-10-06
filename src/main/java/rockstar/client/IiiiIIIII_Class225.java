package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.ButtonSetting;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiiIiiIii_Class220;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iIIIiIIiI_Class275;
import rockstar.client.iIIiIIIiI_Class291;
import rockstar.client.iI_Class3;
import ua.mintantileak.spk.Compile;

public class IiiiIIIII_Class225
extends IiiIiiIii_Class220<ButtonSetting> {
    public IiiiIIIII_Class225(ButtonSetting iIiiiiIII_Class121, iI_Class3 iI_Class32) {
        super(iIiiiiIII_Class121, iI_Class32);
    }

    @Override
    public void I_method_575ca63f() {
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
        this.I_field_dc7facc.I_method_edd72835(this.I_method_a74dc6d0(iII.I_method_b1c3e152(), iII.i_method_b1d26d32()));
        if (this.I_method_7ae26dde(iII) && (float)iII.i_method_b1d26d32() > this.III_method_f4aafe8f() && (float)iII.i_method_b1d26d32() < this.III_method_f4aafe8f() + this.IIi_method_f4b98a6f()) {
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
        }
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f);
        iII.drawRoundedRect(this.I_field_46 + 7.0f, this.i_field_46 + 4.0f, this.II_field_46 - 14.0f, this.Ii_field_46 - 7.0f, IIiii_Class8.I_method_893b2757(6.0f), IiiiiIIIi_Class242.II_method_190e6391().withAlpha(255.0f * (0.3f + 0.2f * this.I_field_dc7facc.I_method_6ac4da6f())));
    }

    @Override
    public void Ii_method_6b12c484(III iII) {
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f);
        iII.drawCenteredText(iIiIIi_Class10, IiIiIIII_Class81.I_method_f25a980a(((ButtonSetting)this.I_field_ba11c26c).getName()), this.I_field_46 + 8.0f + (this.II_field_46 - 14.0f) / 2.0f, this.i_field_46 + iIIiIIIiI_Class291.I_method_ef5e7a8f(iIiIIi_Class10.I_method_a649725c(), this.Ii_field_46) - 0.5f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * (0.75f + 0.25f * this.I_field_dc7facc.I_method_6ac4da6f()) * RenderSystem.getShaderColor()[3]));
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
            ((ButtonSetting)this.I_field_ba11c26c).I_method_7db574f5().run();
        }
        super.i_method_6a097ac7(d, d2, iiIII_Class9);
    }

    @Override
    public float Ii_method_2047ead7() {
        this.Ii_field_46 = 24.0f;
        return 24.0f;
    }
}

