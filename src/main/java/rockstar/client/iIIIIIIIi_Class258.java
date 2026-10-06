package rockstar.client;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;
import lombok.Generated;
import org.lwjgl.glfw.GLFW;
import rockstar.client.iIIIIIIII_Class257;

public final class iIIIIIIIi_Class258 {
    public static int I_method_dc7f39fc(String string) {
        if (string == null || string.isBlank()) {
            return -1;
        }
        String[] stringArray = string.split("\\+");
        if (stringArray.length > 1) {
            int n;
            int n2 = 0;
            for (n = 0; n < stringArray.length - 1; ++n) {
                int n3 = iIIIIIIIi_Class258.II_method_abb627f(iIIIIIIIi_Class258.I_method_10f6edb7(stringArray[n]));
                if (n3 == 0) {
                    return -1;
                }
                n2 |= n3;
            }
            n = iIIIIIIIi_Class258.i_method_ad368ddc(stringArray[stringArray.length - 1]);
            return n == -1 ? -1 : iIIIIIIII_Class257.I_method_967132b2(n, n2);
        }
        return iIIIIIIIi_Class258.i_method_ad368ddc(string);
    }

    private static int i_method_ad368ddc(String string) {
        if (string == null || string.isBlank()) {
            return -1;
        }
        String string2 = iIIIIIIIi_Class258.I_method_10f6edb7(string);
        int n = iIIIIIIIi_Class258.Ii_method_db72b65f(string2);
        if (n != -1) {
            return n;
        }
        try {
            return (Integer)GLFW.class.getField("GLFW_KEY_" + string2).get(null);
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            return -1;
        }
    }

    private static int II_method_abb627f(String string) {
        return switch (string) {
            case "CTRL", "CONTROL", "LCTRL", "RCTRL", "LEFT_CONTROL", "RIGHT_CONTROL" -> 2;
            case "SHIFT", "LSHIFT", "RSHIFT", "LEFT_SHIFT", "RIGHT_SHIFT" -> 1;
            case "ALT", "LALT", "RALT", "LEFT_ALT", "RIGHT_ALT" -> 4;
            case "SUPER", "WIN", "CMD", "LEFT_SUPER", "RIGHT_SUPER" -> 8;
            default -> 0;
        };
    }

    public static List<String> I_method_ed34c268() {
        return Stream.of(GLFW.class.getFields()).map(Field::getName).filter(string -> string.startsWith("GLFW_KEY_")).map(string -> string.substring("GLFW_KEY_".length())).filter(string -> !string.matches("LAST|UNKNOWN|WORLD_\\d+")).toList();
    }

    private static String I_method_10f6edb7(String string) {
        return string.trim().toUpperCase(Locale.ROOT).replace(" ", "_").replace("-", "_");
    }

    private static int Ii_method_db72b65f(String string) {
        switch (string) {
            case "LMB": {
                return 0;
            }
            case "RMB": {
                return 1;
            }
            case "MMB": {
                return 2;
            }
        }
        if (string.startsWith("MOUSE")) {
            String string2 = string.replace("MOUSE_BUTTON_", "").replace("MOUSE", "");
            try {
                int n = Integer.parseInt(string2);
                if (n >= 1 && n <= 8) {
                    return 0 + (n - 1);
                }
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
        return -1;
    }

    @Generated
    private iIIIIIIIi_Class258() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

