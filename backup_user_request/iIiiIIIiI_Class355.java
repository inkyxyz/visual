package rockstar.client;

import lombok.Generated;

public final class iIiiIIIiI_Class355 {
    public static int I_method_c7957097(int n) {
        return n >> 16 & 0xFF;
    }

    public static int i_method_c95860b7(int n) {
        return n >> 8 & 0xFF;
    }

    public static int II_method_2cdb1e34(int n) {
        return n & 0xFF;
    }

    public static int Ii_method_2e9e0e54(int n) {
        return n >> 24 & 0xFF;
    }

    public static float I_method_c7957094(int n) {
        return (float)iIiiIIIiI_Class355.I_method_c7957097(n) / 255.0f;
    }

    public static float i_method_c95860b4(int n) {
        return (float)iIiiIIIiI_Class355.i_method_c95860b7(n) / 255.0f;
    }

    public static float II_method_2cdb1e31(int n) {
        return (float)iIiiIIIiI_Class355.II_method_2cdb1e34(n) / 255.0f;
    }

    public static float Ii_method_2e9e0e51(int n) {
        return (float)iIiiIIIiI_Class355.Ii_method_2e9e0e54(n) / 255.0f;
    }

    public static int[] I_method_2b18a4c0(int n) {
        return new int[]{iIiiIIIiI_Class355.I_method_c7957097(n), iIiiIIIiI_Class355.i_method_c95860b7(n), iIiiIIIiI_Class355.II_method_2cdb1e34(n), iIiiIIIiI_Class355.Ii_method_2e9e0e54(n)};
    }

    public static int[] i_method_61b3b8a0(int n) {
        return new int[]{iIiiIIIiI_Class355.I_method_c7957097(n), iIiiIIIiI_Class355.i_method_c95860b7(n), iIiiIIIiI_Class355.II_method_2cdb1e34(n)};
    }

    public static float[] I_method_2b18a4bd(int n) {
        return new float[]{iIiiIIIiI_Class355.I_method_c7957094(n), iIiiIIIiI_Class355.i_method_c95860b4(n), iIiiIIIiI_Class355.II_method_2cdb1e31(n), iIiiIIIiI_Class355.Ii_method_2e9e0e51(n)};
    }

    public static float[] i_method_61b3b89d(int n) {
        return new float[]{iIiiIIIiI_Class355.I_method_c7957094(n), iIiiIIIiI_Class355.i_method_c95860b4(n), iIiiIIIiI_Class355.II_method_2cdb1e31(n)};
    }

    @Generated
    private iIiiIIIiI_Class355() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

