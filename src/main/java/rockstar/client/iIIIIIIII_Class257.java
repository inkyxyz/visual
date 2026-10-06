package rockstar.client;

import lombok.Generated;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import rockstar.client.AssistModule;
import rockstar.client.Setting;
import rockstar.client.KeybindSetting;
import rockstar.client.IiIiIIii_Class84;
import rockstar.client.IiIiIiII_Class85;
import rockstar.client.ModuleEntry;
import rockstar.client.ModuleManager;
import rockstar.client.RockstarClient;
import rockstar.client.iIiIIiII_Class165;

public final class iIIIIIIII_Class257 {
    public static final int I_field_49 = -1;
    public static final int i_field_49 = Integer.MIN_VALUE;
    private static final int II_field_49 = 16;
    private static final int Ii_field_49 = 15;
    private static final int iI_field_49 = 65535;
    private static final long I_field_4a = 50L;
    private static int ii_field_49 = Integer.MIN_VALUE;
    private static int III_field_49;
    private static boolean I_field_5a;
    private static long i_field_4a;

    public static int I_method_967132b2(int n, int n2) {
        if (n <= -1) {
            return -1;
        }
        return n & 0xFFFF | (n2 & 0xF) << 16;
    }

    public static int I_method_4da58b7(int n) {
        return n <= -1 ? -1 : n & 0xFFFF;
    }

    public static int i_method_69d48d7(int n) {
        return n <= -1 ? 0 : n >> 16 & 0xF;
    }

    public static boolean I_method_4da58c8(int n) {
        int n2 = iIIIIIIII_Class257.I_method_4da58b7(n);
        return n2 >= 0 && n2 <= 7;
    }

    public static boolean i_method_69d48e8(int n) {
        return iIIIIIIII_Class257.II_method_98333a14(n) != 0;
    }

    public static int II_method_98333a14(int n) {
        return switch (n) {
            case 340, 344 -> 1;
            case 341, 345 -> 2;
            case 342, 346 -> 4;
            case 343, 347 -> 8;
            default -> 0;
        };
    }

    public static int i_method_cd0c4692(int n, int n2) {
        if (iIIIIIIII_Class257.i_method_69d48e8(n)) {
            return Integer.MIN_VALUE;
        }
        return iIIIIIIII_Class257.I_method_967132b2(n, n2);
    }

    public static int II_method_6e347cf5(int n, int n2) {
        if (!iIIIIIIII_Class257.i_method_69d48e8(n)) {
            return Integer.MIN_VALUE;
        }
        return iIIIIIIII_Class257.I_method_967132b2(n, n2 & ~iIIIIIIII_Class257.II_method_98333a14(n));
    }

    public static int Ii_method_99f62a34(int n) {
        return iIIIIIIII_Class257.I_method_967132b2(n, iIIIIIIII_Class257.I_method_e761de12());
    }

    public static int I_method_e761de12() {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient == null || minecraftClient.getWindow() == null) {
            return 0;
        }
        long l = minecraftClient.getWindow().getHandle();
        int n = 0;
        if (iIIIIIIII_Class257.I_method_9671a722(l, 340) || iIIIIIIII_Class257.I_method_9671a722(l, 344)) {
            n |= 1;
        }
        if (iIIIIIIII_Class257.I_method_9671a722(l, 341) || iIIIIIIII_Class257.I_method_9671a722(l, 345)) {
            n |= 2;
        }
        if (iIIIIIIII_Class257.I_method_9671a722(l, 342) || iIIIIIIII_Class257.I_method_9671a722(l, 346)) {
            n |= 4;
        }
        if (iIIIIIIII_Class257.I_method_9671a722(l, 343) || iIIIIIIII_Class257.I_method_9671a722(l, 347)) {
            n |= 8;
        }
        return n;
    }

    public static boolean I_method_967132c3(int n, int n2) {
        return iIIIIIIII_Class257.I_method_37b59828(n, n2, iIIIIIIII_Class257.I_method_e761de12());
    }

    public static boolean I_method_37b59828(int n, int n2, int n3) {
        if (n == -1 || iIIIIIIII_Class257.I_method_4da58b7(n) != n2) {
            return false;
        }
        int n4 = iIIIIIIII_Class257.i_method_69d48d7(n);
        if ((n3 & n4) != n4) {
            return false;
        }
        return n4 != 0 || n3 == 0 || !iIIIIIIII_Class257.i_method_cd0c46a3(n2, n3);
    }

    public static boolean II_method_98333a25(int n) {
        if (n == -1) {
            return false;
        }
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient == null || minecraftClient.getWindow() == null) {
            return false;
        }
        int n2 = iIIIIIIII_Class257.i_method_69d48d7(n);
        if ((iIIIIIIII_Class257.I_method_e761de12() & n2) != n2) {
            return false;
        }
        long l = minecraftClient.getWindow().getHandle();
        int n3 = iIIIIIIII_Class257.I_method_4da58b7(n);
        return iIIIIIIII_Class257.I_method_4da58c8(n) ? GLFW.glfwGetMouseButton((long)l, (int)n3) == 1 : iIIIIIIII_Class257.I_method_9671a722(l, n3);
    }

    public static String I_method_f90bbc5c(int n) {
        if ((n & 0xF) == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        if ((n & 2) != 0) {
            stringBuilder.append("CTRL + ");
        }
        if ((n & 1) != 0) {
            stringBuilder.append("SHIFT + ");
        }
        if ((n & 4) != 0) {
            stringBuilder.append("ALT + ");
        }
        if ((n & 8) != 0) {
            stringBuilder.append("WIN + ");
        }
        return stringBuilder.toString();
    }

    private static boolean I_method_9671a722(long l, int n) {
        return n > -1 && InputUtil.isKeyPressed((long)l, (int)n);
    }

    private static boolean i_method_cd0c46a3(int n, int n2) {
        long l = System.currentTimeMillis();
        if (n == ii_field_49 && n2 == III_field_49 && l - i_field_4a < 50L) {
            return I_field_5a;
        }
        ii_field_49 = n;
        III_field_49 = n2;
        i_field_4a = l;
        I_field_5a = iIIIIIIII_Class257.II_method_6e347d06(n, n2);
        return I_field_5a;
    }

    private static boolean II_method_6e347d06(int n, int n2) {
        Object object;
        RockstarClient ii_Class2 = RockstarClient.getInstance();
        if (ii_Class2 == null) {
            return false;
        }
        ModuleManager iiIiiiIi_Class94 = ii_Class2.getModuleManager();
        if (iiIiiiIi_Class94 != null) {
            for (ModuleEntry object2 : iiIiiiIi_Class94.getModules()) {
                if (!object2.isAvailable()) continue;
                if (iIIIIIIII_Class257.i_method_d47d0048(object2.getKeybind(), n, n2)) {
                    return true;
                }
                for (Setting iIiiiIIII_Class113 : object2.getSettings()) {
                    KeybindSetting iIiiiIiIi_Class118;
                    if (!(iIiiiIIII_Class113 instanceof KeybindSetting) || !(iIiiiIiIi_Class118 = (KeybindSetting)iIiiiIIII_Class113).isVisible() || !iIIIIIIII_Class257.i_method_d47d0048(iIiiiIiIi_Class118.I_method_fa6281d2(), n, n2)) continue;
                    return true;
                }
            }
            object = iiIiiiIi_Class94.getModule(AssistModule.class);
            if (object != null) {
                for (iIiIIiII_Class165 iIiIIiII_Class1652 : ((AssistModule)object).i_method_78846a68()) {
                    if (!iIIIIIIII_Class257.i_method_d47d0048(iIiIIiII_Class1652.I_method_75fee8ff(), n, n2)) continue;
                    return true;
                }
            }
        }
        if ((object = ii_Class2.I_method_af32eeab()) != null) {
            for (IiIiIIii_Class84 iiIiIIii_Class84 : ((IiIiIiII_Class85)object).I_method_e1cbbc5b()) {
                if (!iIIIIIIII_Class257.i_method_d47d0048(iiIiIIii_Class84.I_method_886a907f(), n, n2)) continue;
                return true;
            }
        }
        return false;
    }

    private static boolean i_method_d47d0048(int n, int n2, int n3) {
        int n4 = iIIIIIIII_Class257.i_method_69d48d7(n);
        return n4 != 0 && iIIIIIIII_Class257.I_method_4da58b7(n) == n2 && (n3 & n4) == n4;
    }

    @Generated
    private iIIIIIIII_Class257() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

