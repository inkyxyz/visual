package rockstar.client;

import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.iI_Class3;

public class IiIIiIiIi_Class150
extends iI_Class3 {
    private boolean I_field_5a;
    private ColorRGBA I_field_d0c8ec5 = ColorRGBA.WHITE;
    private final float iI_field_46;
    private final IIiIIi_Class10 I_field_856d0221;
    private final String[] I_field_6dccaaa5 = new String[]{"", ""};
    private final String[] i_field_6dccaaa5 = new String[]{"", ""};
    private final IiiiIiIii_Class236[] I_field_a8159991;
    private float ii_field_46;

    public IiIIiIiIi_Class150(IIiIIi_Class10 iIiIIi_Class10, float f, long l, IiiiIiiII_Class237 iiiiIiiII_Class237) {
        this.I_field_856d0221 = iIiIIi_Class10;
        this.iI_field_46 = f;
        this.I_field_a8159991 = new IiiiIiIii_Class236[2];
        for (int i = 0; i < this.I_field_a8159991.length; ++i) {
            this.I_field_a8159991[i] = new IiiiIiIii_Class236(l, iiiiIiiII_Class237);
        }
    }

    @Override
    public void i_method_bdd4e0ec(III iII) {
        for (IiiiIiIii_Class236 iiiiIiIii_Class236 : this.I_field_a8159991) {
            iiiiIiIii_Class236.I_method_edd6dd11(1.0f);
        }
        iII.drawText(this.I_field_856d0221, this.i_field_6dccaaa5[0], this.I_field_46, this.i_field_46 + this.iI_field_46 * this.I_field_a8159991[0].I_method_6ac4da6f(), this.I_field_d0c8ec5.withAlpha(this.I_field_d0c8ec5.getAlpha() * (1.0f - this.I_field_a8159991[0].I_method_6ac4da6f())));
        iII.drawText(this.I_field_856d0221, this.I_field_6dccaaa5[0], this.I_field_46, this.i_field_46 - this.iI_field_46 + this.iI_field_46 * this.I_field_a8159991[0].I_method_6ac4da6f(), this.I_field_d0c8ec5.withAlpha(this.I_field_d0c8ec5.getAlpha() * this.I_field_a8159991[0].I_method_6ac4da6f()));
        iII.drawText(this.I_field_856d0221, this.i_field_6dccaaa5[1], this.I_field_46 + this.ii_field_46, this.i_field_46 + this.iI_field_46 * this.I_field_a8159991[1].I_method_6ac4da6f(), this.I_field_d0c8ec5.withAlpha(this.I_field_d0c8ec5.getAlpha() * (1.0f - this.I_field_a8159991[1].I_method_6ac4da6f())));
        iII.drawText(this.I_field_856d0221, this.I_field_6dccaaa5[1], this.I_field_46 + this.I_field_856d0221.I_method_2c375926(this.I_field_6dccaaa5[0]), this.i_field_46 - this.iI_field_46 + this.iI_field_46 * this.I_field_a8159991[1].I_method_6ac4da6f(), this.I_field_d0c8ec5.withAlpha(this.I_field_d0c8ec5.getAlpha() * this.I_field_a8159991[1].I_method_6ac4da6f()));
    }

    @Override
    public float II_method_c7206932() {
        return this.I_field_856d0221.I_method_2c375926(this.I_field_6dccaaa5[0] + this.I_field_6dccaaa5[1]);
    }

    public void I_method_c711e4e4(int n) {
        String string = String.valueOf(n / 10);
        String string2 = String.valueOf(n % 10);
        if (!string2.equals(this.I_field_6dccaaa5[1])) {
            this.ii_field_46 = this.I_field_856d0221.I_method_2c375926(this.I_field_6dccaaa5[0]);
            this.i_field_6dccaaa5[1] = this.I_field_6dccaaa5[1];
            this.I_field_6dccaaa5[1] = string2;
            this.I_field_a8159991[1].I_method_edd6dd21(0.0f);
        }
        if (!string.equals(this.I_field_6dccaaa5[0])) {
            this.i_field_6dccaaa5[0] = this.I_field_6dccaaa5[0];
            this.I_field_6dccaaa5[0] = this.I_field_5a ? string : (string.equals("0") ? "" : string);
            this.I_field_a8159991[0].I_method_edd6dd21(0.0f);
        }
    }

    public void I_method_8cf9646a(boolean bl, ColorRGBA colorRGBA) {
        this.I_field_5a = bl;
        this.I_field_d0c8ec5 = colorRGBA;
    }
}

