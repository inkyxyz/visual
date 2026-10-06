package rockstar.client;

import lombok.Generated;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;

public class IiiiIiiiI_Class239 {
    private float I_field_46;
    private IiiiIiiII_Class237 I_field_dd60aac = IiiiIiiII_Class237.IIi_field_dd60aac;
    private IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(0L, IiiiIiiII_Class237.IIi_field_dd60aac);

    public float I_method_5a0dc1f2(float f, int n) {
        n = Math.max(1, n);
        if (this.I_field_dc7facc.II_method_ede56cb2() != f) {
            float f2 = this.I_field_dc7facc.I_method_edd6dd11(this.I_field_dc7facc.II_method_ede56cb2());
            this.I_field_dc7facc = new IiiiIiIii_Class236(n, f2, this.I_field_dd60aac);
            this.I_field_dc7facc.I_method_edd6dd11(f);
        }
        this.I_field_46 = this.I_field_dc7facc.I_method_edd6dd11(this.I_field_dc7facc.II_method_ede56cb2());
        return this.I_field_46;
    }

    public boolean I_method_304f6283() {
        return this.I_field_dc7facc.I_method_6ac4da83();
    }

    public float I_method_304f626f() {
        this.I_field_46 = this.I_field_dc7facc.I_method_edd6dd11(this.I_field_dc7facc.II_method_ede56cb2());
        return this.I_field_46;
    }

    public IiiiIiiiI_Class239 I_method_a30bfbd(IiiiIiiII_Class237 iiiiIiiII_Class237) {
        this.I_field_dd60aac = iiiiIiiII_Class237;
        return this;
    }

    @Generated
    public float i_method_305dee4f() {
        return this.I_field_46;
    }

    @Generated
    public IiiiIiiII_Class237 I_method_9fca9b95() {
        return this.I_field_dd60aac;
    }

    @Generated
    public IiiiIiIii_Class236 I_method_9fbc8bb5() {
        return this.I_field_dc7facc;
    }

    @Generated
    public void I_method_ff500887(IiiiIiiII_Class237 iiiiIiiII_Class237) {
        this.I_field_dd60aac = iiiiIiiII_Class237;
    }
}

