package rockstar.client;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import rockstar.client.iiiIIiii_Class232;
import rockstar.client.iiiIiIIi_Class234;
import rockstar.client.iiiIiiII_Class237;

public final class iiiIiIII_Class233 {
    private static final float I_field_46 = 0.5f;
    private static final float i_field_46 = 0.45f;
    private static final int I_field_49 = 4;
    private static final int i_field_49 = 12;
    private static final float II_field_46 = 1.0f;
    private final iiiIiIIi_Class234 I_field_649d1fa1 = new iiiIiIIi_Class234();
    private final float[] I_field_b4b = new float[2];
    private int II_field_49 = -1;
    private boolean I_field_5a;

    public boolean I_method_215ef910() {
        return iiiIiiII_Class237.I_method_7d0c47cb() != null;
    }

    public void I_method_215ef90c() {
        this.I_field_5a = true;
    }

    public void i_method_216d84ec() {
        this.I_field_649d1fa1.I_method_57fa0cec();
        this.II_field_49 = -1;
        this.I_field_5a = false;
    }

    public boolean I_method_8e4c985c(ClientPlayerEntity clientPlayerEntity, ClientWorld clientWorld, LivingEntity livingEntity, float f, float[] fArray) {
        iiiIiiII_Class237 iiiIiiII_Class2372 = iiiIiiII_Class237.I_method_7d0c47cb();
        if (iiiIiiII_Class2372 == null || clientPlayerEntity == null || clientWorld == null || livingEntity == null) {
            return false;
        }
        Box box = livingEntity.getBoundingBox();
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        Vec3d vec3d2 = box.getCenter().subtract(vec3d);
        double d = Math.max(Math.hypot(vec3d2.x, vec3d2.z), 0.05);
        float f2 = (float)Math.toDegrees(Math.atan2(vec3d2.z, vec3d2.x)) - 90.0f;
        float f3 = (float)(-Math.toDegrees(Math.atan2(vec3d2.y, d)));
        float f4 = Math.max((float)Math.toDegrees(Math.atan2(box.getLengthX() / 2.0, d)), 0.5f);
        float f5 = Math.max((float)Math.toDegrees(Math.atan2(box.getLengthY() / 2.0, d)), 0.5f);
        if (livingEntity.getId() != this.II_field_49 || !this.I_field_649d1fa1.I_method_57fa0cf0()) {
            this.I_field_649d1fa1.I_method_e9d4590d(iiiIiiII_Class2372, clientPlayerEntity.getYaw(), clientPlayerEntity.getPitch(), f2, f3);
            this.II_field_49 = livingEntity.getId();
        }
        float f6 = 0.45f * iiiIiiII_Class2372.I_method_930e7044(ThreadLocalRandom.current().nextFloat());
        if (!this.I_field_649d1fa1.I_method_5863bed8(iiiIiiII_Class2372, clientPlayerEntity.getYaw(), clientPlayerEntity.getPitch(), f2, f3, f4, f5, iiiIIiii_Class232.I_method_60b14254(vec3d, box), f6, 12, f, 4, 1.0f, this.I_field_b4b)) {
            return false;
        }
        if (this.I_field_5a) {
            this.I_field_5a = false;
            this.I_field_649d1fa1.i_method_580898cc();
        } else {
            this.I_field_649d1fa1.II_method_a75687f5();
        }
        fArray[0] = this.I_field_b4b[0];
        fArray[1] = this.I_field_b4b[1];
        return true;
    }
}

