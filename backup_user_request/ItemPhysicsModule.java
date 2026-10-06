package rockstar.client;

import net.minecraft.client.render.entity.state.ItemEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.ItemEntity;
import net.minecraft.util.math.RotationAxis;

@ModuleInfo(
    name = "Item Physics",
    category = ModuleCategory.VISUALS,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.item_physics"
)
public class ItemPhysicsModule extends Module {

    private final BooleanSetting layFlat = new BooleanSetting(this, "Лежать на блоках").I_method_decd82b5();
    private final BooleanSetting rotateFalling = new BooleanSetting(this, "Вращение в падении").I_method_decd82b5();
    private final SliderSetting rotateSpeed = new SliderSetting(this, "Скорость вращения")
        .I_method_c8c9a7d7(0.2F).i_method_65e2aff7(3.0F).II_method_b0f56334(0.1F).Ii_method_4e0e6b54(1.0F);

    private static ItemPhysicsModule INSTANCE;

    public ItemPhysicsModule() {
        INSTANCE = this;
    }

    public static boolean isActive() {
        return INSTANCE != null && INSTANCE.isEnabled();
    }

    public static void applyCustomPhysics(ItemEntity entity, ItemEntityRenderState state, MatrixStack matrices) {
        if (!isActive()) return;

        float speedMultiplier = INSTANCE.rotateSpeed.Ii_method_a20abcd2();

        if (entity != null && entity.isOnGround()) {
            if (INSTANCE.layFlat.i_method_9b12da03()) {
                // Lay completely flat on top of the block without clipping or floating
                matrices.translate(0.0F, 0.032F, 0.0F);
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F));
                float randomYaw = (float) ((entity.getId() * 37) % 360);
                matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(randomYaw));
            }
        } else if (entity != null && entity.isSubmergedInWater()) {
            float age = state.age;
            float bobAngle = (float) Math.sin(age * 0.12F * speedMultiplier) * 10.0F;
            float bobY = 0.05F + (float) Math.sin(age * 0.16F * speedMultiplier) * 0.025F;
            matrices.translate(0.0F, bobY, 0.0F);
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F + bobAngle));
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees((float) Math.cos(age * 0.08F) * 8.0F));
        } else if (INSTANCE.rotateFalling.i_method_9b12da03()) {
            float age = state.age;
            float vx = entity != null ? (float) entity.getVelocity().x : 0.0F;
            float vy = entity != null ? (float) entity.getVelocity().y : 0.0F;
            float vz = entity != null ? (float) entity.getVelocity().z : 0.0F;
            float velLen = (float) Math.sqrt(vx * vx + vy * vy + vz * vz);
            float rollSpeed = Math.max(0.6F, velLen * 2.8F) * speedMultiplier * 14.0F;

            matrices.translate(0.0F, 0.15F, 0.0F);
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(age * rollSpeed));
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(age * rollSpeed * 0.7F));
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(age * rollSpeed * 0.5F));
        } else {
            matrices.translate(0.0F, 0.08F, 0.0F);
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F));
        }
    }
}
