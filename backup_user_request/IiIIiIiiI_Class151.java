package rockstar.client;

import lombok.Generated;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.iI_Class3;

public class IiIIiIiiI_Class151
extends iI_Class3 {
    private final float iI_field_46;
    private final IIiIIi_Class10 I_field_856d0221;
    private String I_field_523beb0a = "";
    private String i_field_523beb0a = "";
    private final IiiiIiIii_Class236 I_field_dc7facc;
    private boolean I_field_5a;

    public IiIIiIiiI_Class151(IIiIIi_Class10 iIiIIi_Class10, float f, long l, IiiiIiiII_Class237 iiiiIiiII_Class237) {
        this.I_field_856d0221 = iIiIIi_Class10;
        this.iI_field_46 = f;
        this.I_field_dc7facc = new IiiiIiIii_Class236(l, iiiiIiiII_Class237);
    }

    @Override
    public void i_method_bdd4e0ec(III iII) {
        this.I_field_dc7facc.I_method_edd6dd11(1.0f);
        iII.drawText(this.I_field_856d0221, this.I_field_523beb0a, this.I_field_46 - (this.I_field_5a ? this.I_field_856d0221.I_method_2c375926(this.I_field_523beb0a) / 2.0f : 0.0f), this.i_field_46 + this.iI_field_46 * this.I_field_dc7facc.I_method_6ac4da6f(), ColorRGBA.WHITE.withAlpha(255.0f * (1.0f - this.I_field_dc7facc.I_method_6ac4da6f())));
        iII.drawText(this.I_field_856d0221, this.i_field_523beb0a, this.I_field_46 - (this.I_field_5a ? this.I_field_856d0221.I_method_2c375926(this.i_field_523beb0a) / 2.0f : 0.0f), this.i_field_46 - this.iI_field_46 + this.iI_field_46 * this.I_field_dc7facc.I_method_6ac4da6f(), ColorRGBA.WHITE.withAlpha(255.0f * this.I_field_dc7facc.I_method_6ac4da6f()));
    }

    public IiIIiIiiI_Class151 I_method_49374335() {
        this.I_field_5a = true;
        return this;
    }

    public void I_method_ceb35a49(String string) {
        if (this.i_field_523beb0a.equals(string)) {
            return;
        }
        this.I_field_523beb0a = this.i_field_523beb0a;
        this.i_field_523beb0a = string;
        this.I_field_dc7facc.I_method_edd6dd21(0.0f);
    }

    @Generated
    public IIiIIi_Class10 I_method_970e4a18() {
        return this.I_field_856d0221;
    }
}

