package rockstar.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import pyrock.events.render.HudRenderEvent;

@ModuleInfo(
    name = "Aim Assist",
    category = ModuleCategory.COMBAT,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.aimassist"
)
public class AimAssistModule extends Module {
    private final SliderSetting speed = new SliderSetting(this, "modules.settings.aimassist.speed")
        .I_method_c8c9a7d7(1.0F)
        .i_method_65e2aff7(10.0F)
        .II_method_b0f56334(0.5F)
        .Ii_method_4e0e6b54(3.5F);

    private final SliderSetting fov = new SliderSetting(this, "modules.settings.aimassist.fov")
        .I_method_c8c9a7d7(10.0F)
        .i_method_65e2aff7(180.0F)
        .II_method_b0f56334(5.0F)
        .Ii_method_4e0e6b54(90.0F);

    private final SliderSetting distance = new SliderSetting(this, "modules.settings.aimassist.distance")
        .I_method_c8c9a7d7(1.0F)
        .i_method_65e2aff7(7.0F)
        .II_method_b0f56334(0.2F)
        .Ii_method_4e0e6b54(4.5F);

    private final ModeSetting priority = new ModeSetting(this, "modules.settings.aimassist.priority");
    private final ModeSetting.Nested1_42765c60 prioDistance = new ModeSetting.Nested1_42765c60(this.priority, "Distance");
    private final ModeSetting.Nested1_42765c60 prioHealth = new ModeSetting.Nested1_42765c60(this.priority, "Health");
    private final ModeSetting.Nested1_42765c60 prioAngle = new ModeSetting.Nested1_42765c60(this.priority, "Angle");

    private final BooleanSetting onlyWeapon = new BooleanSetting(this, "modules.settings.aimassist.only_weapon").I_method_decd82b5();
    private final BooleanSetting targetPlayers = new BooleanSetting(this, "modules.settings.aimassist.players").I_method_decd82b5();
    private final BooleanSetting targetMobs = new BooleanSetting(this, "modules.settings.aimassist.mobs");

    private final IiIIIiII_Class69<HudRenderEvent> onRender = var1 -> {
        if (!this.isEnabled()) return;
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc == null || mc.player == null || mc.world == null || mc.currentScreen != null) return;

        if (this.onlyWeapon.i_method_9b12da03()) {
            ItemStack stack = mc.player.getMainHandStack();
            if (stack == null || stack.isEmpty()) return;
            if (!(stack.getItem() instanceof SwordItem) && !(stack.getItem() instanceof AxeItem)) return;
        }

        LivingEntity bestTarget = null;
        double bestScore = Double.MAX_VALUE;
        float maxFov = this.fov.Ii_method_a20abcd2();
        float maxDist = this.distance.Ii_method_a20abcd2();
        Vec3d eyePos = mc.player.getEyePos();

        for (Entity ent : mc.world.getEntities()) {
            if (!(ent instanceof LivingEntity living) || living == mc.player || !living.isAlive() || living.isInvisible()) continue;
            if (living instanceof PlayerEntity && !this.targetPlayers.i_method_9b12da03()) continue;
            if (!(living instanceof PlayerEntity) && !this.targetMobs.i_method_9b12da03()) continue;

            double dist = mc.player.distanceTo(living);
            if (dist > maxDist) continue;

            Vec3d targetCenter = living.getPos().add(0.0, living.getHeight() * 0.5, 0.0);
            double dx = targetCenter.x - eyePos.x;
            double dy = targetCenter.y - eyePos.y;
            double dz = targetCenter.z - eyePos.z;
            double distH = Math.sqrt(dx * dx + dz * dz);

            float targetYaw = (float)Math.toDegrees(Math.atan2(-dx, dz));
            float targetPitch = (float)Math.toDegrees(-Math.atan2(dy, distH));

            float deltaYaw = MathHelper.wrapDegrees(targetYaw - mc.player.getYaw());
            float deltaPitch = targetPitch - mc.player.getPitch();
            double angle = Math.hypot(deltaYaw, deltaPitch);

            if (angle > maxFov / 2.0) continue;

            double score = dist;
            if (this.prioHealth.isSelected()) {
                score = living.getHealth();
            } else if (this.prioAngle.isSelected()) {
                score = angle;
            }

            if (score < bestScore) {
                bestScore = score;
                bestTarget = living;
            }
        }

        if (bestTarget != null) {
            Vec3d targetCenter = bestTarget.getPos().add(0.0, bestTarget.getHeight() * 0.5, 0.0);
            double dx = targetCenter.x - eyePos.x;
            double dy = targetCenter.y - eyePos.y;
            double dz = targetCenter.z - eyePos.z;
            double distH = Math.sqrt(dx * dx + dz * dz);

            float targetYaw = (float)Math.toDegrees(Math.atan2(-dx, dz));
            float targetPitch = (float)Math.toDegrees(-Math.atan2(dy, distH));

            float deltaYaw = MathHelper.wrapDegrees(targetYaw - mc.player.getYaw());
            float deltaPitch = targetPitch - mc.player.getPitch();

            float spd = this.speed.Ii_method_a20abcd2();
            float step = MathHelper.clamp(spd * 0.04F, 0.01F, 0.5F);

            mc.player.setYaw(mc.player.getYaw() + deltaYaw * step);
            mc.player.setPitch(MathHelper.clamp(mc.player.getPitch() + deltaPitch * step, -90.0F, 90.0F));
        }
    };

    public AimAssistModule() {
        this.prioDistance.select();
    }
}
