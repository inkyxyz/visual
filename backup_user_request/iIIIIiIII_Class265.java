package rockstar.client;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

public final class iIIIIiIII_Class265 {
    private static PlayerEntity I_field_88955355;
    private static Runnable I_field_bac0a97e;
    private static Runnable i_field_bac0a97e;
    private static boolean I_field_5a;

    private iIIIIiIII_Class265() {
    }

    public static void I_method_6fefbe3f() {
        if (i_field_bac0a97e == null) {
            return;
        }
        Runnable runnable = i_field_bac0a97e;
        i_field_bac0a97e = null;
        runnable.run();
    }

    public static void I_method_8d3241d4(PlayerEntity playerEntity) {
        iIIIIiIII_Class265.I_method_8ba1fa52(playerEntity, null);
    }

    public static void I_method_8ba1fa52(PlayerEntity playerEntity, Runnable runnable) {
        iIIIIiIII_Class265.I_method_e89e02c2(playerEntity, runnable, false);
    }

    public static void I_method_e89e02c2(PlayerEntity playerEntity, Runnable runnable, boolean bl) {
        I_field_88955355 = playerEntity;
        I_field_bac0a97e = runnable;
        I_field_5a = bl;
    }

    public static boolean I_method_eacbd82b(Entity entity) {
        return I_field_88955355 != null && entity == I_field_88955355;
    }

    public static void I_method_eacbd827(Entity entity) {
        if (!iIIIIiIII_Class265.I_method_eacbd82b(entity)) {
            return;
        }
        Runnable runnable = I_field_bac0a97e;
        boolean bl = I_field_5a;
        iIIIIiIII_Class265.i_method_a5c35847(entity);
        if (runnable != null) {
            if (bl) {
                runnable.run();
            } else {
                i_field_bac0a97e = runnable;
            }
        }
    }

    public static boolean I_method_6fefbe43() {
        return i_field_bac0a97e != null;
    }

    public static void i_method_a5c35847(Entity entity) {
        if (I_field_88955355 != null && entity == I_field_88955355) {
            I_field_88955355 = null;
            I_field_bac0a97e = null;
            I_field_5a = false;
        }
    }

    public static boolean i_method_a5c3584b(Entity entity) {
        return iIIIIiIII_Class265.I_method_eacbd82b(entity) && I_field_5a;
    }
}

