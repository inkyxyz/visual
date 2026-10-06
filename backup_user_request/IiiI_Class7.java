package rockstar.client;

import rockstar.client.iiI_Class7;

public interface IiiI_Class7 {
    public static final IiiI_Class7 I_field_f94500c1 = (f, iiI_Class72, nested1_28a19593) -> {};
    public static final IiiI_Class7 i_field_f94500c1 = (f, iiI_Class72, nested1_28a19593) -> {
        nested1_28a19593.I_field_46 = 0.0f;
    };
    public static final IiiI_Class7 II_field_f94500c1 = (f, iiI_Class72, nested1_28a19593) -> {
        nested1_28a19593.I_field_46 = f;
    };
    public static final IiiI_Class7 Ii_field_f94500c1 = (f, iiI_Class72, nested1_28a19593) -> {
        nested1_28a19593.I_field_46 = f;
        nested1_28a19593.II_field_46 = (1.0f - f) * 14.0f;
    };
    public static final IiiI_Class7 iI_field_f94500c1 = (f, iiI_Class72, nested1_28a19593) -> {
        nested1_28a19593.I_field_46 = f;
        nested1_28a19593.II_field_46 = (1.0f - f) * 16.0f;
    };
    public static final IiiI_Class7 ii_field_f94500c1 = (f, iiI_Class72, nested1_28a19593) -> {
        nested1_28a19593.I_field_46 = f;
        nested1_28a19593.II_field_46 = -(1.0f - f) * 16.0f;
    };
    public static final IiiI_Class7 III_field_f94500c1 = (f, iiI_Class72, nested1_28a19593) -> {
        nested1_28a19593.I_field_46 = f;
        nested1_28a19593.i_field_46 = (1.0f - f) * 16.0f;
    };
    public static final IiiI_Class7 IIi_field_f94500c1 = (f, iiI_Class72, nested1_28a19593) -> {
        nested1_28a19593.I_field_46 = f;
        nested1_28a19593.i_field_46 = -(1.0f - f) * 16.0f;
    };
    public static final IiiI_Class7 IiI_field_f94500c1 = (f, iiI_Class72, nested1_28a19593) -> {
        nested1_28a19593.I_field_46 = f;
        nested1_28a19593.Ii_field_46 = 0.92f + 0.08f * f;
    };
    public static final IiiI_Class7 Iii_field_f94500c1 = (f, iiI_Class72, nested1_28a19593) -> {
        nested1_28a19593.I_field_46 = f;
        nested1_28a19593.Ii_field_46 = 0.85f + 0.15f * f;
        nested1_28a19593.II_field_46 = (1.0f - f) * 8.0f;
    };

    public void apply(float var1, iiI_Class7 var2, Nested1_28a19593 var3);

    public static IiiI_Class7 I_method_540512a3(float f) {
        return (f2, iiI_Class72, nested1_28a19593) -> {
            nested1_28a19593.I_field_46 = f2;
            nested1_28a19593.II_field_46 = (1.0f - f2) * f;
        };
    }

    public static IiiI_Class7 i_method_8f2f7683(float f) {
        return (f2, iiI_Class72, nested1_28a19593) -> {
            nested1_28a19593.I_field_46 = f2;
            nested1_28a19593.i_field_46 = (1.0f - f2) * f;
        };
    }

    public static IiiI_Class7 II_method_240096ac(float f) {
        return (f2, iiI_Class72, nested1_28a19593) -> {
            nested1_28a19593.I_field_46 = f2;
            nested1_28a19593.II_field_46 = (1.0f - f2) * iiI_Class72.h() * f;
        };
    }

    public static final class Nested1_28a19593 {
        public float I_field_46 = 1.0f;
        public float i_field_46 = 0.0f;
        public float II_field_46 = 0.0f;
        public float Ii_field_46 = 1.0f;

        public void I_method_5395f207() {
            this.I_field_46 = 1.0f;
            this.i_field_46 = 0.0f;
            this.II_field_46 = 0.0f;
            this.Ii_field_46 = 1.0f;
        }
    }
}

