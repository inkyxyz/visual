package rockstar.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.Nullable;
import rockstar.client.iiiIiIIi_Class234;
import rockstar.client.iiiIiiII_Class237;

public final class iiIiiIiii_Class440 {
    private static final float I_field_46 = 3.5f;
    private static final float i_field_46 = 0.6f;
    private static final float II_field_46 = 1.8f;
    private static final float Ii_field_46 = 0.3f;
    private static final int I_field_49 = 4;
    private static final int i_field_49 = 12;
    private static final float iI_field_46 = 1.0f;
    private static final float ii_field_46 = 25.0f;
    private static final float III_field_46 = 90.0f;
    private static final float IIi_field_46 = 30.0f;
    private static final iiIiiIiii_Class440 I_field_cfb7326c = new iiIiiIiii_Class440();
    private final iiiIiIIi_Class234 I_field_649d1fa1 = new iiiIiIIi_Class234();
    private final float[] I_field_b4b = new float[2];
    private int II_field_49 = Integer.MIN_VALUE;

    private iiIiiIiii_Class440() {
    }

    public static boolean I_method_ad0f4223() {
        return iiiIiiII_Class237.I_method_7d0c47cb() != null;
    }

    @Nullable
    public static String I_method_e6015461() {
        return iiiIiiII_Class237.I_method_7d0c47cb() == null ? null : iiiIiiII_Class237.I_method_f16c5534();
    }

    public static boolean I_method_1a8d62ae(float f, float f2, float f3, float f4, float[] fArray) {
        return I_field_cfb7326c.i_method_a3bb868e(f, f2, f3, f4, fArray);
    }

    private boolean i_method_a3bb868e(float f, float f2, float f3, float f4, float[] fArray) {
        iiiIiiII_Class237 iiiIiiII_Class2372 = iiiIiiII_Class237.I_method_7d0c47cb();
        if (iiiIiiII_Class2372 == null) {
            return false;
        }
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (clientPlayerEntity == null || minecraftClient.world == null) {
            return false;
        }
        if (Math.abs(MathHelper.wrapDegrees((float)(f3 - f))) > 90.0f || Math.abs(f4) > 30.0f) {
            this.I_field_649d1fa1.I_method_57fa0cec();
            return false;
        }
        if (clientPlayerEntity.age - this.II_field_49 > 3) {
            this.I_field_649d1fa1.I_method_57fa0cec();
        }
        this.II_field_49 = clientPlayerEntity.age;
        double d = 3.5 * Math.max(Math.cos(Math.toRadians(f4)), 0.05);
        float f5 = (float)Math.max(Math.toDegrees(Math.atan2(0.3f, d)), 0.5);
        float f6 = (float)Math.max(Math.toDegrees(Math.atan2(0.9f, d)), 0.5);
        if (!this.I_field_649d1fa1.I_method_57fa0cf0()) {
            this.I_field_649d1fa1.I_method_e9d4590d(iiiIiiII_Class2372, f, f2, f3, f4);
        }
        if (!this.I_field_649d1fa1.I_method_5863bed8(iiiIiiII_Class2372, f, f2, f3, f4, f5, f6, 3.5, 0.0f, 12, 0.3f, 4, 1.0f, this.I_field_b4b)) {
            return false;
        }
        this.I_field_649d1fa1.II_method_a75687f5();
        float f7 = MathHelper.clamp((float)this.I_field_b4b[0], (float)-25.0f, (float)25.0f);
        float f8 = MathHelper.clamp((float)this.I_field_b4b[1], (float)-25.0f, (float)25.0f);
        if (Float.isNaN(f7) || Float.isNaN(f8)) {
            this.I_field_649d1fa1.I_method_57fa0cec();
            return false;
        }
        fArray[0] = f7;
        fArray[1] = f8;
        return true;
    }
}

