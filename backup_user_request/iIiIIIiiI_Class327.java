package rockstar.client;

public class iIiIIIiiI_Class327 {
    private double I_field_44 = 1.0;
    private double i_field_44 = 0.0;
    private double II_field_44 = 1.0;
    private double Ii_field_44;
    private double iI_field_44;
    private double ii_field_44 = Double.NaN;
    private double III_field_44 = Double.NaN;

    public iIiIIIiiI_Class327(double d, double d2, double d3, double d4, double d5) {
        this.Ii_field_44 = d;
        this.iI_field_44 = d2;
        this.I_field_44 = d3;
        this.i_field_44 = d4;
        this.II_field_44 = d5;
    }

    public iIiIIIiiI_Class327(double d, double d2) {
        this.Ii_field_44 = d;
        this.iI_field_44 = d2;
    }

    public double I_method_e3e411ed(double d, double d2) {
        if (Double.isNaN(this.III_field_44)) {
            this.III_field_44 = 1.0 / this.II_field_44 * d;
            this.ii_field_44 = 1.0 / this.II_field_44 * this.iI_field_44 * (1.0 / this.II_field_44);
        } else {
            double d3 = this.I_field_44 * this.III_field_44 + this.i_field_44 * d2;
            double d4 = this.I_field_44 * this.ii_field_44 * this.I_field_44 + this.Ii_field_44;
            double d5 = d4 * this.II_field_44 * (1.0 / (this.II_field_44 * d4 * this.II_field_44 + this.iI_field_44));
            this.III_field_44 = d3 + d5 * (d - this.II_field_44 * d3);
            this.ii_field_44 = d4 - d5 * this.II_field_44 * d4;
        }
        return this.III_field_44;
    }

    public double I_method_59ee920d(double d) {
        return this.I_method_e3e411ed(d, 0.0);
    }

    public double I_method_76838ded() {
        return this.III_field_44;
    }

    public void I_method_59ee921f(double d) {
        this.iI_field_44 = d;
    }

    public void i_method_5bb1823f(double d) {
        this.Ii_field_44 = d;
    }
}

