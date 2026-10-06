package rockstar.client;

import lombok.Generated;
import rockstar.client.IiiiIiiII_Class237;

public class IiiiIiIii_Class236 {
    private long I_field_4a;
    private float I_field_46;
    private IiiiIiiII_Class237 I_field_dd60aac;
    private long i_field_4a;
    private float i_field_46;
    private float II_field_46;
    private boolean I_field_5a;
    private boolean i_field_5a;

    public IiiiIiIii_Class236(long l, float f, IiiiIiiII_Class237 iiiiIiiII_Class237) {
        this.I_field_4a = l;
        this.I_field_dd60aac = iiiiIiiII_Class237;
        this.I_field_46 = f;
        this.i_field_46 = f;
        this.II_field_46 = f;
        this.I_field_5a = true;
    }

    public IiiiIiIii_Class236(long l, IiiiIiiII_Class237 iiiiIiiII_Class237) {
        this(l, 0.0f, iiiiIiiII_Class237);
    }

    public void I_method_edd72835(boolean bl) {
        this.I_method_edd6dd11(bl ? 1.0f : 0.0f);
    }

    public float I_method_edd6dd11(float f) {
        long l;
        long l2 = System.currentTimeMillis();
        if (f != this.II_field_46) {
            this.i_field_46 = this.I_field_46;
            this.II_field_46 = f;
            this.i_field_4a = l2;
            this.I_field_5a = false;
        }
        if ((l = l2 - this.i_field_4a) >= this.I_field_4a) {
            this.I_field_46 = this.II_field_46;
            this.I_field_5a = true;
            return this.I_field_46;
        }
        float f2 = (float)l / (float)this.I_field_4a;
        float f3 = this.I_field_dd60aac.ease(f2, 0.0f, 1.0f, 1.0f);
        this.I_field_46 = this.i_field_46 + (this.II_field_46 - this.i_field_46) * f3;
        return this.I_field_46;
    }

    public boolean I_method_edd72839(boolean bl) {
        return bl ? this.I_field_46 == this.II_field_46 : this.I_field_46 == 0.0f;
    }

    public void I_method_edd6dd21(float f) {
        this.I_field_46 = f;
        this.i_field_46 = f;
        this.II_field_46 = f;
        this.I_field_5a = true;
    }

    public void i_method_ef99cd41(float f) {
        this.I_field_46 = f;
        this.i_field_46 = f;
        this.II_field_46 = f;
        this.I_field_5a = true;
    }

    public void I_method_6ac4da7f() {
        this.i_method_ef99cd41(0.0f);
    }

    public void i_method_6ad3665f() {
        if (this.i_field_5a) {
            this.I_method_edd6dd11(1.0f);
        } else {
            this.I_method_edd6dd11(0.0f);
        }
        if (this.I_field_46 == 1.0f) {
            this.i_field_5a = false;
        } else if (this.I_field_46 == 0.0f) {
            this.i_field_5a = true;
        }
    }

    @Generated
    public long I_method_6ac4da73() {
        return this.I_field_4a;
    }

    @Generated
    public float I_method_6ac4da6f() {
        return this.I_field_46;
    }

    @Generated
    public IiiiIiiII_Class237 I_method_1da1395() {
        return this.I_field_dd60aac;
    }

    @Generated
    public long i_method_6ad36653() {
        return this.i_field_4a;
    }

    @Generated
    public float i_method_6ad3664f() {
        return this.i_field_46;
    }

    @Generated
    public float II_method_ede56cb2() {
        return this.II_field_46;
    }

    @Generated
    public boolean I_method_6ac4da83() {
        return this.I_field_5a;
    }

    @Generated
    public boolean i_method_6ad36663() {
        return this.i_field_5a;
    }

    @Generated
    public void I_method_edd6ec25(long l) {
        this.I_field_4a = l;
    }

    @Generated
    public void I_method_df2f9087(IiiiIiiII_Class237 iiiiIiiII_Class237) {
        this.I_field_dd60aac = iiiiIiiII_Class237;
    }

    @Generated
    public void i_method_ef99dc45(long l) {
        this.i_field_4a = l;
    }

    @Generated
    public void II_method_cec8933e(float f) {
        this.i_field_46 = f;
    }

    @Generated
    public void Ii_method_d08b835e(float f) {
        this.II_field_46 = f;
    }

    @Generated
    public void i_method_ef9a1855(boolean bl) {
        this.I_field_5a = bl;
    }

    @Generated
    public void II_method_cec8de52(boolean bl) {
        this.i_field_5a = bl;
    }
}

