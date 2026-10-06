package rockstar.client;

import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldView;
import pyrock.events.player.ClientPlayerTickEvent;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.iIIiIiIiI_Class299;
import rockstar.client.iIIiiIiIi_Class310;
import rockstar.client.iIIiiiIii_Class316;
import rockstar.client.iIIiiiiIi_Class318;
import rockstar.client.iiIIiIIIi_Class402;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.iiIIiIiiI_Class407;
import rockstar.client.Module;

@ModuleInfo(name="AntiAim", category=ModuleCategory.OTHER)
public class AntiAimModule
extends Module {
    private int I_field_49 = -1;
    private int i_field_49 = -1;
    private int II_field_49 = -1;
    private int Ii_field_49 = -1;
    private int iI_field_49;
    private int ii_field_49 = -1000;
    private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = clientPlayerTickEvent -> {
        if (AntiAimModule.I_field_3a9bda27.player == null || AntiAimModule.I_field_3a9bda27.world == null || AntiAimModule.I_field_3a9bda27.interactionManager == null || AntiAimModule.I_field_3a9bda27.player.isSpectator()) {
            return;
        }
        if (this.Ii_field_49 >= 0) {
            if (AntiAimModule.I_field_3a9bda27.player.age >= this.Ii_field_49) {
                this.IiI_method_67c8f2bf();
            }
            return;
        }
        if (!this.IiI_method_67c8f2c3()) {
            this.IiI_method_67c8f2bf();
            return;
        }
        BlockPos blockPos = AntiAimModule.I_field_3a9bda27.player.getBlockPos();
        if (!this.I_method_8b7329fd(blockPos)) {
            this.iI_field_49 = 0;
            this.IiI_method_67c8f2bf();
            return;
        }
        if (AntiAimModule.I_field_3a9bda27.player.age - this.ii_field_49 < 3) {
            return;
        }
        iIIiiiiIi_Class318 iIIiiiiIi_Class3182 = iIIiiIiIi_Class310.Ii_method_1c02fc38().I_method_5d34dd7d(Items.LILAC);
        if (iIIiiiiIi_Class3182 != null) {
            this.I_method_8f5a7ac0(blockPos, Hand.OFF_HAND);
            return;
        }
        iIIiiiIii_Class316 iIIiiiIii_Class3162 = iIIiiIiIi_Class310.I_method_6a489695().I_method_5d34dd7d(Items.LILAC);
        if (iIIiiiIii_Class3162 == null) {
            return;
        }
        if (!this.I_method_61f41cab(iIIiiiIii_Class3162)) {
            return;
        }
        this.I_method_8f5a7ac0(blockPos, Hand.MAIN_HAND);
    };

    @Override
    public void onDisable() {
        this.IiI_method_67c8f2bf();
    }

    private boolean IiI_method_67c8f2c3() {
        for (PlayerEntity playerEntity : AntiAimModule.I_field_3a9bda27.world.getPlayers()) {
            Vec3d vec3d;
            if (playerEntity == AntiAimModule.I_field_3a9bda27.player || !playerEntity.isAlive() || playerEntity.isSpectator() || playerEntity.squaredDistanceTo((Entity)AntiAimModule.I_field_3a9bda27.player) > 36.0 || playerEntity.isOnGround() || playerEntity.isSwimming() || playerEntity.isClimbing() || (vec3d = AntiAimModule.I_field_3a9bda27.player.getBoundingBox().getCenter().subtract(playerEntity.getEyePos())).lengthSquared() == 0.0 || !(playerEntity.getRotationVec(1.0f).dotProduct(vec3d.normalize()) >= 0.9)) continue;
            return true;
        }
        return false;
    }

    private boolean I_method_8b7329fd(BlockPos blockPos) {
        return AntiAimModule.I_field_3a9bda27.world.getBlockState(blockPos).isAir() && AntiAimModule.I_field_3a9bda27.world.getBlockState(blockPos.up()).isAir() && Blocks.LILAC.getDefaultState().canPlaceAt((WorldView)AntiAimModule.I_field_3a9bda27.world, blockPos);
    }

    private boolean I_method_61f41cab(iIIiiiIii_Class316 iIIiiiIii_Class3162) {
        int n = AntiAimModule.I_field_3a9bda27.player.getInventory().selectedSlot;
        if (this.i_field_49 != iIIiiiIii_Class3162.II_method_b9cf08f5() || n != iIIiiiIii_Class3162.II_method_b9cf08f5()) {
            if (this.I_field_49 == -1) {
                this.I_field_49 = n;
            }
            this.i_field_49 = iIIiiiIii_Class3162.II_method_b9cf08f5();
            this.II_field_49 = AntiAimModule.I_field_3a9bda27.player.age;
            this.iI_field_49 = 0;
            iIIiIiIiI_Class299.i_method_8225b484(this.i_field_49);
            return false;
        }
        return AntiAimModule.I_field_3a9bda27.player.age > this.II_field_49;
    }

    private void I_method_8f5a7ac0(BlockPos blockPos, Hand hand) {
        BlockPos blockPos2 = blockPos.down();
        Vec3d vec3d = blockPos2.toCenterPos().add(0.0, 0.5, 0.0);
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = this.I_method_6e65a195(AntiAimModule.I_field_3a9bda27.player.getEyePos(), vec3d);
        RockstarClient.getInstance().I_method_58785402().I_method_1acbf705(iiIIiIIii_Class4042, iiIIiIIIi_Class402.Ii_field_32e0c64c, 45.0f, 45.0f, 45.0f, iiIIiIiiI_Class407.iI_field_32efc66c);
        iiIIiIIii_Class404 iiIIiIIii_Class4043 = RockstarClient.getInstance().I_method_58785402().II_method_f098f858();
        if (Math.abs(MathHelper.wrapDegrees((float)(iiIIiIIii_Class4043.I_method_14534e0f() - iiIIiIIii_Class4042.I_method_14534e0f()))) > 3.0f || Math.abs(iiIIiIIii_Class4043.i_method_1461d9ef() - iiIIiIIii_Class4042.i_method_1461d9ef()) > 3.0f) {
            this.iI_field_49 = 0;
            return;
        }
        if (++this.iI_field_49 < 2) {
            return;
        }
        AntiAimModule.I_field_3a9bda27.interactionManager.interactBlock(AntiAimModule.I_field_3a9bda27.player, hand, new BlockHitResult(vec3d, Direction.UP, blockPos2, false));
        AntiAimModule.I_field_3a9bda27.player.swingHand(hand);
        this.ii_field_49 = AntiAimModule.I_field_3a9bda27.player.age;
        this.iI_field_49 = 0;
        if (this.I_field_49 != -1) {
            this.Ii_field_49 = AntiAimModule.I_field_3a9bda27.player.age + 1;
        }
    }

    private iiIIiIIii_Class404 I_method_6e65a195(Vec3d vec3d, Vec3d vec3d2) {
        double d = vec3d2.x - vec3d.x;
        double d2 = vec3d2.y - vec3d.y;
        double d3 = vec3d2.z - vec3d.z;
        double d4 = Math.sqrt(d * d + d3 * d3);
        return new iiIIiIIii_Class404((float)Math.toDegrees(Math.atan2(d3, d)) - 90.0f, (float)(-Math.toDegrees(Math.atan2(d2, d4))));
    }

    private void IiI_method_67c8f2bf() {
        if (AntiAimModule.I_field_3a9bda27.player != null && this.I_field_49 != -1 && AntiAimModule.I_field_3a9bda27.player.getInventory().selectedSlot != this.I_field_49) {
            iIIiIiIiI_Class299.i_method_8225b484(this.I_field_49);
        }
        this.I_field_49 = -1;
        this.i_field_49 = -1;
        this.II_field_49 = -1;
        this.Ii_field_49 = -1;
        this.iI_field_49 = 0;
    }
}

