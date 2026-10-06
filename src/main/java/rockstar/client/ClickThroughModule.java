package rockstar.client;

import java.util.HashSet;
import java.util.Set;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import rockstar.client.ModuleCategory;
import rockstar.client.ModuleInfo;
import rockstar.client.iIIIIiiiI_Class271;
import rockstar.client.Module;

@ModuleInfo(name="Click Through", category=ModuleCategory.PLAYER)
public class ClickThroughModule
extends Module {
    private final Set<BlockPos> I_field_a56a8dc5 = new HashSet<BlockPos>();

    @Override
    public void II_method_6642fd22() {
        if (ClickThroughModule.I_field_3a9bda27.player == null || ClickThroughModule.I_field_3a9bda27.world == null || ClickThroughModule.I_field_3a9bda27.interactionManager == null) {
            return;
        }
        if (!ClickThroughModule.I_field_3a9bda27.options.useKey.isPressed() || ClickThroughModule.I_field_3a9bda27.options.sneakKey.isPressed()) {
            return;
        }
        this.I_field_a56a8dc5.clear();
        for (int i = 1; i < 16; ++i) {
            Vec3d vec3d = ClickThroughModule.I_field_3a9bda27.player.getRotationVec(1.0f);
            Vec3d vec3d2 = this.I_method_9c10e93b(I_field_3a9bda27.getRenderTickCounter().getTickDelta(true)).add(vec3d.multiply((double)i * 0.25));
            BlockPos blockPos = BlockPos.ofFloored((Position)vec3d2);
            if (this.I_field_a56a8dc5.contains(blockPos)) continue;
            this.I_field_a56a8dc5.add(blockPos);
            if (ClickThroughModule.I_field_3a9bda27.player.getPos().distanceTo(Vec3d.ofCenter((Vec3i)blockPos)) > 4.25 || iIIIIiiiI_Class271.I_method_2e3e4b92(blockPos) == null) continue;
            Vec3d vec3d3 = this.I_method_9c10e93b(I_field_3a9bda27.getRenderTickCounter().getTickDelta(true));
            Direction direction = Direction.getFacing((double)(vec3d3.x - (double)blockPos.getX()), (double)(vec3d3.y - (double)blockPos.getY()), (double)(vec3d3.z - (double)blockPos.getZ()));
            if (direction == Direction.UP || direction == Direction.DOWN) {
                direction = Direction.NORTH;
            }
            BlockHitResult blockHitResult = new BlockHitResult(Vec3d.ofCenter((Vec3i)blockPos), direction, blockPos, true);
            ClickThroughModule.I_field_3a9bda27.interactionManager.interactBlock(ClickThroughModule.I_field_3a9bda27.player, Hand.MAIN_HAND, blockHitResult);
            ClickThroughModule.I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
            return;
        }
    }

    public Vec3d I_method_9c10e93b(float f) {
        if (ClickThroughModule.I_field_3a9bda27.player == null) {
            return Vec3d.ZERO;
        }
        double d = MathHelper.lerp((double)f, (double)ClickThroughModule.I_field_3a9bda27.player.prevX, (double)ClickThroughModule.I_field_3a9bda27.player.getX());
        double d2 = MathHelper.lerp((double)f, (double)ClickThroughModule.I_field_3a9bda27.player.prevY, (double)ClickThroughModule.I_field_3a9bda27.player.getY()) + (double)ClickThroughModule.I_field_3a9bda27.player.getEyeHeight(ClickThroughModule.I_field_3a9bda27.player.getPose());
        double d3 = MathHelper.lerp((double)f, (double)ClickThroughModule.I_field_3a9bda27.player.prevZ, (double)ClickThroughModule.I_field_3a9bda27.player.getZ());
        return new Vec3d(d, d2, d3);
    }
}

