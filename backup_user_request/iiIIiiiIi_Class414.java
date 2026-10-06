package rockstar.client;

import java.time.LocalTime;
import java.util.Random;
import lombok.Generated;
import rockstar.client.SoundsModule;
import rockstar.client.RockstarClient;
import rockstar.client.iiIIiiiii_Class416;
import rockstar.client.iiIiIIIII_Class417;

public final class iiIIiiiIi_Class414 {
    private static final Random I_field_6ece06ac = new Random();

    public static void I_method_fc3f61ff() {
        iiIIiiiii_Class416 iiIIiiiii_Class4162 = switch (I_field_6ece06ac.nextInt(4)) {
            case 0 -> iiIiIIIII_Class417.iiI_field_34b2ba6c;
            case 1 -> iiIiIIIII_Class417.iii_field_34b2ba6c;
            default -> iiIiIIIII_Class417.IIII_field_34b2ba6c;
        };
        iiIIiiiii_Class4162.I_method_87d2e181(iiIIiiiIi_Class414.I_method_fc3f61ef());
    }

    public static void i_method_fc4deddf() {
        iiIIiiiii_Class416 iiIIiiiii_Class4162 = switch (I_field_6ece06ac.nextInt(4)) {
            case 0 -> iiIiIIIII_Class417.iiii_field_34b2ba6c;
            case 1 -> iiIiIIIII_Class417.IIIII_field_34b2ba6c;
            default -> iiIIiiiIi_Class414.I_method_de0eead5();
        };
        iiIIiiiii_Class4162.I_method_87d2e181(iiIIiiiIi_Class414.I_method_fc3f61ef());
    }

    public static void II_method_8bbbd542() {
        iiIIiiiii_Class416 iiIIiiiii_Class4162 = switch (I_field_6ece06ac.nextInt(8)) {
            case 0 -> iiIiIIIII_Class417.IIIi_field_34b2ba6c;
            case 1 -> iiIiIIIII_Class417.IIiI_field_34b2ba6c;
            case 2 -> iiIiIIIII_Class417.IIii_field_34b2ba6c;
            case 3 -> iiIiIIIII_Class417.IiII_field_34b2ba6c;
            case 4 -> iiIiIIIII_Class417.IiIi_field_34b2ba6c;
            case 5 -> iiIiIIIII_Class417.Iiii_field_34b2ba6c;
            case 6 -> iiIiIIIII_Class417.iIII_field_34b2ba6c;
            default -> iiIiIIIII_Class417.IiiI_field_34b2ba6c;
        };
        iiIIiiiii_Class4162.I_method_87d2e181(iiIIiiiIi_Class414.I_method_fc3f61ef());
    }

    public static void Ii_method_8bca6122() {
        iiIIiiiii_Class416 iiIIiiiii_Class4162 = switch (I_field_6ece06ac.nextInt(4)) {
            case 0 -> iiIiIIIII_Class417.IIIiI_field_34b2ba6c;
            case 1 -> iiIiIIIII_Class417.IIIii_field_34b2ba6c;
            default -> iiIiIIIII_Class417.IIiII_field_34b2ba6c;
        };
        iiIIiiiii_Class4162.I_method_87d2e181(iiIIiiiIi_Class414.I_method_fc3f61ef());
    }

    public static void iI_method_8d7ec562() {
        iiIIiiiii_Class416 iiIIiiiii_Class4162 = switch (I_field_6ece06ac.nextInt(4)) {
            case 0 -> iiIiIIIII_Class417.iIIi_field_34b2ba6c;
            case 1 -> iiIiIIIII_Class417.iIiI_field_34b2ba6c;
            default -> iiIiIIIII_Class417.iIii_field_34b2ba6c;
        };
        iiIIiiiii_Class4162.I_method_87d2e181(iiIIiiiIi_Class414.I_method_fc3f61ef());
    }

    private static float I_method_fc3f61ef() {
        return RockstarClient.getInstance().getModuleManager().getModule(SoundsModule.class).I_method_45ee5ef();
    }

    private static iiIIiiiii_Class416 I_method_de0eead5() {
        LocalTime localTime = LocalTime.now();
        int n = localTime.getHour();
        if (n >= 6 && n < 12) {
            return iiIiIIIII_Class417.iiII_field_34b2ba6c;
        }
        if (n >= 12 && n < 18) {
            return iiIiIIIII_Class417.iiIi_field_34b2ba6c;
        }
        return iiIiIIIII_Class417.iiiI_field_34b2ba6c;
    }

    @Generated
    private iiIIiiiIi_Class414() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

