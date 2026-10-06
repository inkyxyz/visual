package rockstar.client;

public final class IIII {
    public static final IIII I_field_f935fcc1 = new IIII(0.0f, 0.0f, 0.0f, 0.0f);
    public final float I_field_46;
    public final float i_field_46;
    public final float II_field_46;
    public final float Ii_field_46;

    private IIII(float f, float f2, float f3, float f4) {
        this.I_field_46 = Math.max(0.0f, f);
        this.i_field_46 = Math.max(0.0f, f2);
        this.II_field_46 = Math.max(0.0f, f3);
        this.Ii_field_46 = Math.max(0.0f, f4);
    }

    public static IIII I_method_14640aa3(float f) {
        return f <= 0.0f ? I_field_f935fcc1 : new IIII(f, f, f, f);
    }

    public static IIII I_method_12c9a0cb(float f, float f2, float f3, float f4) {
        return new IIII(f, f2, f3, f4);
    }

    public static IIII I_method_b1e865cb(float f, float f2) {
        return new IIII(f, f2, f, f2);
    }

    public static IIII i_method_4f8e6e83(float f) {
        return new IIII(0.0f, f, 0.0f, f);
    }

    public static IIII II_method_714316ac(float f) {
        return new IIII(f, 0.0f, f, 0.0f);
    }

    public float I_method_b35d9ffc() {
        return this.Ii_field_46 + this.i_field_46;
    }

    public float i_method_b36c2bdc() {
        return this.I_field_46 + this.II_field_46;
    }
}

