package rockstar.client;

import lombok.Generated;
import rockstar.client.iIIiIIiIi_Class294;

public class iIIiIIIii_Class292
implements iIIiIIiIi_Class294 {
    private double I_field_44;
    private double i_field_44 = 0.0;
    private double II_field_44 = 0.0;
    private double Ii_field_44 = 0.95;
    private double iI_field_44 = 0.08;
    private double ii_field_44 = 0.7;

    public void I_method_575ab23f() {
        this.i_field_44 += this.II_field_44;
        this.II_field_44 *= this.Ii_field_44;
        if (Math.abs(this.II_field_44) < 0.01) {
            this.II_field_44 = 0.0;
        }
        if (this.I_field_44 >= 0.0) {
            this.i_field_44 = 0.0;
            this.II_field_44 = 0.0;
            return;
        }
        if (this.i_field_44 > 0.0) {
            double d = -this.i_field_44 * this.iI_field_44;
            this.II_field_44 += d;
            this.II_field_44 *= this.ii_field_44;
        } else if (this.i_field_44 < this.I_field_44) {
            double d = (this.I_field_44 - this.i_field_44) * this.iI_field_44;
            this.II_field_44 += d;
            this.II_field_44 *= this.ii_field_44;
        }
    }

    public double I_method_575ab22d() {
        return -this.i_field_44;
    }

    public void i_method_57693e1f() {
        this.i_field_44 = 0.0;
        this.II_field_44 = 0.0;
    }

    public void I_method_93fbf5df(double d) {
        this.II_field_44 += d;
    }

    public boolean I_method_575ab243() {
        if (this.II_field_44 > 0.5) {
            return true;
        }
        return this.i_field_44 > 0.0 || this.i_field_44 < this.I_field_44;
    }

    public void I_method_93fc08a4(int n) {
        if (n == 265) {
            this.I_method_93fbf5df(1.0);
        } else if (n == 264) {
            this.I_method_93fbf5df(-1.0);
        }
    }

    @Generated
    public double i_method_57693e0d() {
        return this.I_field_44;
    }

    @Generated
    public double II_method_940a8cf0() {
        return this.II_field_44;
    }

    @Generated
    public double Ii_method_941918d0() {
        return this.Ii_field_44;
    }

    @Generated
    public double iI_method_95cd7d10() {
        return this.iI_field_44;
    }

    @Generated
    public double ii_method_95dc08f0() {
        return this.ii_field_44;
    }

    @Generated
    public void i_method_95bee5ff(double d) {
        this.I_field_44 = d;
    }

    @Generated
    public void II_method_ed47737c(double d) {
        this.i_field_44 = d;
    }

    @Generated
    public void Ii_method_ef0a639c(double d) {
        this.II_field_44 = d;
    }

    @Generated
    public void iI_method_23e2875c(double d) {
        this.Ii_field_44 = d;
    }

    @Generated
    public void ii_method_25a5777c(double d) {
        this.iI_field_44 = d;
    }

    @Generated
    public void III_method_bd6ba97f(double d) {
        this.ii_field_44 = d;
    }
}

