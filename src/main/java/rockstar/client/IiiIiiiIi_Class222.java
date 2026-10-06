package rockstar.client;

import lombok.Generated;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.KeybindSetting;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiiIiiIii_Class220;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiIiiIi_Class238;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIIiIiI_Class267;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iIIIiIIiI_Class275;
import rockstar.client.iIIiIIIiI_Class291;
import rockstar.client.iI_Class3;
import rockstar.client.iIiiiIiII_Class373;
import ua.mintantileak.spk.Compile;

public class IiiIiiiIi_Class222
extends IiiIiiIii_Class220<KeybindSetting> {
    private final IiiiIiiIi_Class238 I_field_dd60e8c = new IiiiIiiIi_Class238(300L, new ColorRGBA(24.0f, 24.0f, 27.0f), IiiiIiiII_Class237.III_field_dd60aac);
    private final IiiiIiIii_Class236 i_field_dc7facc = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.III_field_dd60aac);
    private IiiiIiIii_Class236 II_field_dc7facc = new IiiiIiIii_Class236(300L, 1.0f, IiiiIiiII_Class237.III_field_dd60aac);
    private int I_field_49;
    private boolean I_field_5a;

    public boolean i_method_b6c965e3() {
        return this.I_field_5a;
    }

    public IiiIiiiIi_Class222(KeybindSetting iIiiiIiIi_Class118, iI_Class3 iI_Class32) {
        super(iIiiiIiIi_Class118, iI_Class32);
    }

    @Override
    protected void i_method_bdd4e0ec(III iII) {
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f);
        IIiIIi_Class10 iIiIIi_Class102 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f);
        float f = 10.0f;
        float f2 = 19.0f;
        this.I_field_dd60e8c.I_method_8895420(this.I_field_5a ? IiiiiIIIi_Class242.i_method_5dfec6e() : IiiiiIIIi_Class242.iI_method_8e08d3b1());
        this.II_field_dc7facc.I_method_edd6ec25(500L);
        this.II_field_dc7facc.I_method_edd6dd11(1.0f);
        String string = iIIIIiIiI_Class267.I_method_a937749c(((KeybindSetting)this.I_field_ba11c26c).I_method_fa6281d2());
        String string2 = iIIIIiIiI_Class267.I_method_a937749c(this.I_field_49);
        float f3 = iIiIIi_Class102.I_method_2c375926(string) + 7.0f;
        this.i_field_dc7facc.I_method_edd6dd11(f3);
        iII.drawRoundedRect(this.I_field_46 + this.II_field_46 - 9.0f - this.i_field_dc7facc.I_method_6ac4da6f(), this.i_field_46 + 4.0f, this.i_field_dc7facc.I_method_6ac4da6f(), 11.0f, IIiii_Class8.I_method_893b2757(3.0f), IiiiiIIIi_Class242.Ii_method_a0f56f71());
        iIiiiIiII_Class373.I_method_d5a5ee51(iII.getMatrices(), this.I_field_46 + this.II_field_46 - 9.0f - this.i_field_dc7facc.I_method_6ac4da6f(), this.i_field_46 + 4.0f, this.i_field_dc7facc.I_method_6ac4da6f(), 11.0f);
        iII.drawText(iIiIIi_Class102, string2, this.I_field_46 + this.II_field_46 - 9.0f - this.i_field_dc7facc.I_method_6ac4da6f() + 4.0f + 4.0f * this.II_field_dc7facc.I_method_6ac4da6f(), this.i_field_46 + 7.0f, this.I_field_dd60e8c.I_method_915b8ae().withAlpha(255.0f * (0.75f + 0.25f * this.I_field_dc7facc.I_method_6ac4da6f()) * (1.0f - this.II_field_dc7facc.I_method_6ac4da6f())));
        iII.drawText(iIiIIi_Class102, string, this.I_field_46 + this.II_field_46 - 9.0f - this.i_field_dc7facc.I_method_6ac4da6f() + 4.0f - 4.0f + 4.0f * this.II_field_dc7facc.I_method_6ac4da6f(), this.i_field_46 + 7.0f, this.I_field_dd60e8c.I_method_915b8ae().withAlpha(255.0f * (0.75f + 0.25f * this.I_field_dc7facc.I_method_6ac4da6f()) * this.II_field_dc7facc.I_method_6ac4da6f()));
        iIiiiIiII_Class373.I_method_ff80a1df();
        this.I_method_2d447471(iII, iIiIIi_Class10, IiIiIIII_Class81.I_method_f25a980a(((KeybindSetting)this.I_field_ba11c26c).getName()), this.I_field_46 + f, this.i_field_46 + iIIiIIIiI_Class291.I_method_ef5e7a8f(iIiIIi_Class10.I_method_a649725c(), f2), this.II_field_46 - this.i_field_dc7facc.I_method_6ac4da6f() - 20.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * (0.75f + 0.25f * this.I_field_dc7facc.I_method_6ac4da6f())), 0.7f, 0.99f);
        if (this.I_method_7ae26dde(iII) && (float)iII.i_method_b1d26d32() > this.III_method_f4aafe8f() && (float)iII.i_method_b1d26d32() < this.III_method_f4aafe8f() + this.IIi_method_f4b98a6f()) {
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
        }
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
            boolean bl = this.I_field_5a = !this.I_field_5a;
        }
        if (this.I_field_5a && iiIII_Class9 != IiIII_Class9.I_field_2f4c8d6c) {
            int n = iiIII_Class9.I_method_6d899712();
            ((KeybindSetting)this.I_field_ba11c26c).I_method_51ee2d04(n);
            this.I_field_5a = false;
        }
        super.I_method_400ceaa7(d, d2, iiIII_Class9);
    }

    @Override
    @Compile
    public void I_method_c1acbc24(int n, int n2, int n3) {
        if (this.I_field_5a) {
            this.I_field_49 = ((KeybindSetting)this.I_field_ba11c26c).I_method_fa6281d2();
            if (n == 256 || n == 261) {
                ((KeybindSetting)this.I_field_ba11c26c).I_method_51ee2d04(-1);
            } else {
                ((KeybindSetting)this.I_field_ba11c26c).I_method_51ee2d04(n);
            }
            this.II_field_dc7facc = new IiiiIiIii_Class236(500L, 0.0f, IiiiIiiII_Class237.III_field_dd60aac);
            this.I_field_5a = false;
            return;
        }
        super.I_method_c1acbc24(n, n2, n3);
    }

    @Override
    public float Ii_method_2047ead7() {
        this.Ii_field_46 = 19.0f;
        return 19.0f;
    }

    @Generated
    public void I_method_20a118b5(boolean bl) {
        this.I_field_5a = bl;
    }
}

