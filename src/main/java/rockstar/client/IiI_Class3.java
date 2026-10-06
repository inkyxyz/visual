package rockstar.client;

import rockstar.client.IIii_Class4;

public final class IiI_Class3 {
    float I_field_46;
    float i_field_46;
    float II_field_46;
    float Ii_field_46;
    float iI_field_46;
    boolean I_field_5a;
    private IIii_Class4 I_field_f93678c1;

    public IiI_Class3(IIii_Class4 iIii_Class4) {
        this.I_field_f93678c1 = iIii_Class4;
    }

    public IiI_Class3(float f, IIii_Class4 iIii_Class4) {
        this.I_field_f93678c1 = iIii_Class4;
        this.i_method_84a13e41(f);
    }

    public IiI_Class3 I_method_15cf9df6(IIii_Class4 iIii_Class4) {
        this.I_field_f93678c1 = iIii_Class4;
        return this;
    }

    public IIii_Class4 I_method_6d2db338() {
        return this.I_field_f93678c1;
    }

    public void I_method_82de4e21(float f) {
        if (!this.I_field_5a) {
            this.i_method_84a13e41(f);
            return;
        }
        if (f != this.i_field_46) {
            this.i_field_46 = f;
            if (this.I_field_f93678c1 != null) {
                this.I_field_f93678c1.I_method_ecef089f(this);
            }
        }
    }

    public void i_method_84a13e41(float f) {
        this.i_field_46 = this.Ii_field_46 = f;
        this.I_field_46 = this.Ii_field_46;
        this.II_field_46 = 0.0f;
        this.iI_field_46 = 0.0f;
        this.I_field_5a = true;
    }

    void II_method_daaf423e(float f) {
        if (!this.I_field_5a || f == 0.0f) {
            return;
        }
        this.I_field_46 += f;
        this.i_field_46 += f;
        this.Ii_field_46 += f;
    }

    public void Ii_method_dc72325e(float f) {
        if (this.I_field_f93678c1 != null) {
            this.I_field_f93678c1.I_method_b0f27301(this, f);
        }
    }

    public float I_method_4e8b496f() {
        return this.I_field_46;
    }

    public float i_method_4e99d54f() {
        return this.i_field_46;
    }

    public boolean I_method_4e8b4983() {
        return this.I_field_f93678c1 == null || this.I_field_f93678c1.I_method_171120c3(this);
    }
}

