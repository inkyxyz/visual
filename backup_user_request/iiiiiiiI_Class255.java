package rockstar.client;

public final class iiiiiiiI_Class255 {
    public static final double I_field_44 = -4096.0;
    private final double[] I_field_b49;
    private final double i_field_44;
    private int I_field_49;

    public iiiiiiiI_Class255(int n, double d) {
        this.I_field_b49 = new double[n];
        this.i_field_44 = d;
    }

    public void I_method_437a20ec() {
        this.I_field_49 = 0;
    }

    public void I_method_2bca5cd2(double d) {
        if (this.I_field_49 < this.I_field_b49.length) {
            this.I_field_b49[this.I_field_49++] = d;
        }
    }

    public int I_method_437a20df() {
        return this.I_field_b49.length;
    }

    public double I_method_437a20da() {
        return this.i_field_44;
    }

    public double I_method_2bca5cc0(double d) {
        if (this.I_field_49 == 0) {
            return -4096.0;
        }
        int n = this.I_method_2bca5cc5(d);
        if (n < 0) {
            return this.I_field_b49[0];
        }
        if (n >= this.I_field_49 - 1) {
            return this.I_field_b49[this.I_field_49 - 1];
        }
        return Math.min(this.I_field_b49[n], this.I_field_b49[n + 1]);
    }

    public double i_method_2d8d4ce0(double d) {
        if (this.I_field_49 == 0) {
            return -4096.0;
        }
        int n = this.I_method_2bca5cc5(d);
        if (n < 0) {
            return this.I_field_b49[0];
        }
        if (n >= this.I_field_49 - 1) {
            return this.I_field_b49[this.I_field_49 - 1];
        }
        return Math.max(this.I_field_b49[n], this.I_field_b49[n + 1]);
    }

    private int I_method_2bca5cc5(double d) {
        double d2 = d / this.i_field_44;
        return d2 <= 0.0 ? -1 : (int)d2;
    }
}

