package rockstar.client;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.math.BlockPos;

public final class iIIiIiiII_Class301 {
    public static volatile boolean I_field_5a = false;
    public static volatile BlockPos I_field_670402ba = null;
    public static volatile Class<? extends Screen> I_field_5a7e2503 = null;
    public static volatile long I_field_4a = 0L;

    private iIIiIiiII_Class301() {
    }

    public static void I_method_c9363664(BlockPos blockPos, Class<? extends Screen> clazz) {
        I_field_670402ba = blockPos;
        I_field_5a7e2503 = clazz;
        I_field_4a = System.currentTimeMillis();
        I_field_5a = true;
    }

    public static void I_method_8abb23f() {
        I_field_5a = false;
        I_field_670402ba = null;
        I_field_5a7e2503 = null;
        I_field_4a = 0L;
    }

    public static boolean I_method_83d556c7(Screen screen) {
        if (!I_field_5a || screen == null || I_field_5a7e2503 == null) {
            return false;
        }
        return I_field_5a7e2503.isInstance(screen);
    }
}

