package rockstar.client;

import rockstar.client.iiIiIiIIi_Class426;

public final class iiIiIiIii_Class428 {
    private static volatile iiIiIiIIi_Class426 I_field_9ad00aac;

    private iiIiIiIii_Class428() {
    }

    public static iiIiIiIIi_Class426 I_method_483e9b95() {
        iiIiIiIIi_Class426 iiIiIiIIi_Class4262 = I_field_9ad00aac;
        if (iiIiIiIIi_Class4262 == null) {
            throw new IllegalStateException("Newton API is not initialised yet (initialise after Newton mod is loaded)");
        }
        return iiIiIiIIi_Class4262;
    }

    public static boolean I_method_b0496283() {
        return I_field_9ad00aac != null;
    }

    public static void I_method_89900887(iiIiIiIIi_Class426 iiIiIiIIi_Class4262) {
        if (I_field_9ad00aac != null) {
            throw new IllegalStateException("Newton API already installed");
        }
        I_field_9ad00aac = iiIiIiIIi_Class4262;
    }
}

