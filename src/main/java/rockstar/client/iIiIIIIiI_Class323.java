package rockstar.client;

import java.util.EmptyStackException;

class iIiIIIIiI_Class323 {
    private double[] I_field_b49;
    private int I_field_49;

    iIiIIIIiI_Class323() {
        this(5);
    }

    iIiIIIIiI_Class323(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Stack's capacity must be positive");
        }
        this.I_field_b49 = new double[n];
        this.I_field_49 = -1;
    }

    void I_method_d160b1ff(double d) {
        if (this.I_field_49 + 1 == this.I_field_b49.length) {
            double[] dArray = new double[(int)((double)this.I_field_b49.length * 1.2) + 1];
            System.arraycopy(this.I_field_b49, 0, dArray, 0, this.I_field_b49.length);
            this.I_field_b49 = dArray;
        }
        this.I_field_b49[++this.I_field_49] = d;
    }

    double I_method_7a5df20d() {
        if (this.I_field_49 == -1) {
            throw new EmptyStackException();
        }
        return this.I_field_b49[this.I_field_49];
    }

    double i_method_7a6c7ded() {
        if (this.I_field_49 == -1) {
            throw new EmptyStackException();
        }
        return this.I_field_b49[this.I_field_49--];
    }

    boolean I_method_7a5df223() {
        return this.I_field_49 == -1;
    }

    int I_method_7a5df212() {
        return this.I_field_49 + 1;
    }
}

