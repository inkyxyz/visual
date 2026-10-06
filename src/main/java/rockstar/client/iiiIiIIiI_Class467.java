package rockstar.client;

import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.BlockView;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.iiIiiIiII_Class437;
import rockstar.client.iiIiiIiIi_Class438;
import rockstar.client.iiIiiiiii_Class448;
import rockstar.client.iiiIIIIII_Class449;
import rockstar.client.iiiIIIIIi_Class450;
import rockstar.client.iiiIIIiIi_Class454;
import rockstar.client.iiiIIiIIi_Class458;
import rockstar.client.iiiIiIIII_Class465;

public class iiiIiIIiI_Class467
extends iiiIiIIII_Class465 {
    private static final double Ii_field_44 = 1.5;
    private static final double iI_field_44 = 0.4;
    private boolean I_field_5a;
    private BlockPos I_field_670402ba;
    private final iiiIIIIIi_Class450 I_field_f86b4e4c = new iiiIIIIIi_Class450();
    private double ii_field_44 = Double.POSITIVE_INFINITY;
    private int I_field_49;

    public iiiIiIIiI_Class467(iiiIIiIIi_Class458 iiiIIiIIi_Class4582, iiiIIiIIi_Class458 iiiIIiIIi_Class4583) {
        super(iiiIIiIIi_Class4582, iiiIIiIIi_Class4583);
    }

    @Override
    protected double i_method_373409cd() {
        return this.ii_field_44;
    }

    @Override
    public int I_method_37257df2() {
        return Math.min(600, this.I_field_49 * 2 + 120);
    }

    @Override
    public boolean I_method_a7f2ac8b(iiiIIIiIi_Class454 iiiIIIiIi_Class4542) {
        int n;
        if (this.i_field_fa2e3e6c.i_method_6d2ed9f2() != this.I_field_fa2e3e6c.i_method_6d2ed9f2()) {
            return false;
        }
        int n2 = this.i_field_fa2e3e6c.I_method_6d204e12() - this.I_field_fa2e3e6c.I_method_6d204e12();
        int n3 = this.i_field_fa2e3e6c.II_method_36f86d15() - this.I_field_fa2e3e6c.II_method_36f86d15();
        if (Math.abs(n2) + Math.abs(n3) != 1) {
            return false;
        }
        if (!iiiIIIiIi_Class4542.i_method_674a3c88(this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2() - 1, this.i_field_fa2e3e6c.II_method_36f86d15())) {
            return false;
        }
        if (iiiIIIiIi_Class4542.ii_method_b822e605(this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2() - 1, this.i_field_fa2e3e6c.II_method_36f86d15())) {
            return false;
        }
        int n4 = iiiIIIiIi_Class4542.I_method_70883fb2(this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15(), this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15());
        int n5 = iiiIIIiIi_Class4542.I_method_70883fb2(this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15(), this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2() + 1, this.i_field_fa2e3e6c.II_method_36f86d15());
        if (n4 == Integer.MAX_VALUE || n5 == Integer.MAX_VALUE) {
            return false;
        }
        if (n4 == 0 && n5 == 0) {
            return false;
        }
        this.I_field_49 = n = n4 + n5;
        int n6 = (n4 > 0 ? 1 : 0) + (n5 > 0 ? 1 : 0);
        double d = (double)n / 20.0;
        this.ii_field_44 = 1.0 + d * 1.5 + (double)n6 * 0.4;
        return true;
    }

    @Override
    public iiiIiIIII_Class465.Nested1_33b738a0 I_method_8cdd8810() {
        BlockState blockState;
        boolean bl;
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (clientPlayerEntity == null || minecraftClient.world == null || minecraftClient.interactionManager == null) {
            return iiiIiIIII_Class465.Nested1_33b738a0.II_field_86e7b1e7;
        }
        BlockPos blockPos = new BlockPos(this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2() + 1, this.i_field_fa2e3e6c.II_method_36f86d15());
        BlockPos blockPos2 = new BlockPos(this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15());
        BlockState blockState2 = minecraftClient.world.getBlockState(blockPos);
        BlockState blockState3 = minecraftClient.world.getBlockState(blockPos2);
        boolean bl2 = !iiiIIIiIi_Class454.I_method_c621a877((BlockView)minecraftClient.world, blockState2, blockPos, this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15());
        boolean bl3 = bl = !iiiIIIiIi_Class454.I_method_c621a877((BlockView)minecraftClient.world, blockState3, blockPos2, this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15());
        if (!bl2 && !bl) {
            return this.i_method_6dfd7c10();
        }
        iiIiiiiii_Class448 iiIiiiiii_Class4482 = iiIiiIiIi_Class438.I_method_12f562b5().I_method_14b8caf5();
        iiIiiiiii_Class4482.I_method_359d223f();
        iiIiiiiii_Class4482.I_method_7e07d875(false);
        iiIiiiiii_Class4482.i_method_7fcac895(false);
        iiIiiiiii_Class4482.II_method_44ae3612(false);
        iiIiiiiii_Class4482.Ii_method_46712632(false);
        iiIiiiiii_Class4482.iI_method_7b4949f2(false);
        iiIiiiiii_Class4482.ii_method_7d0c3a12(false);
        iiIiiiiii_Class4482.III_method_52d38c15(false);
        BlockPos blockPos3 = bl2 ? blockPos : blockPos2;
        BlockState blockState4 = blockState = bl2 ? blockState2 : blockState3;
        if (this.I_field_670402ba != null && !this.I_field_670402ba.equals((Object)blockPos3)) {
            minecraftClient.interactionManager.cancelBlockBreaking();
            this.I_field_f86b4e4c.I_method_e4926dff();
        }
        this.I_field_670402ba = blockPos3;
        this.I_field_5a = true;
        double d = Math.hypot(clientPlayerEntity.getX() - ((double)this.I_field_fa2e3e6c.I_method_6d204e12() + 0.5), clientPlayerEntity.getZ() - ((double)this.I_field_fa2e3e6c.II_method_36f86d15() + 0.5));
        if (d > 1.5) {
            return iiiIiIIII_Class465.Nested1_33b738a0.II_field_86e7b1e7;
        }
        iiiIIIIII_Class449.I_method_98560fd8(blockState);
        Direction direction = iiiIiIIiI_Class467.I_method_4b16413c(clientPlayerEntity, blockPos3);
        if (!this.I_field_f86b4e4c.I_method_b97a0d1b(blockPos3, direction)) {
            return iiiIiIIII_Class465.Nested1_33b738a0.I_field_86e7b1e7;
        }
        minecraftClient.interactionManager.updateBlockBreakingProgress(blockPos3, direction);
        clientPlayerEntity.swingHand(clientPlayerEntity.getActiveHand());
        return iiiIiIIII_Class465.Nested1_33b738a0.I_field_86e7b1e7;
    }

    private iiiIiIIII_Class465.Nested1_33b738a0 i_method_6dfd7c10() {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (clientPlayerEntity == null) {
            return iiiIiIIII_Class465.Nested1_33b738a0.II_field_86e7b1e7;
        }
        if (this.I_field_5a) {
            minecraftClient.interactionManager.cancelBlockBreaking();
            this.I_field_5a = false;
            this.I_field_670402ba = null;
            this.I_field_f86b4e4c.I_method_e4926dff();
        }
        if (this.i_method_af4d9243(0.4) && Math.abs(clientPlayerEntity.getY() - (double)this.i_field_fa2e3e6c.i_method_6d2ed9f2()) < 0.6 && clientPlayerEntity.isOnGround()) {
            return iiiIiIIII_Class465.Nested1_33b738a0.i_field_86e7b1e7;
        }
        Vec3d vec3d = new Vec3d((double)this.i_field_fa2e3e6c.I_method_6d204e12() + 0.5, (double)this.i_field_fa2e3e6c.i_method_6d2ed9f2(), (double)this.i_field_fa2e3e6c.II_method_36f86d15() + 0.5);
        double d = vec3d.x - clientPlayerEntity.getX();
        double d2 = vec3d.z - clientPlayerEntity.getZ();
        float f = (float)Math.toDegrees(Math.atan2(d2, d)) - 90.0f;
        iiIiiIiII_Class437.I_method_cb5ea4a7(new iiIIiIIii_Class404(f, 0.0f));
        iiIiiiiii_Class448 iiIiiiiii_Class4482 = iiIiiIiIi_Class438.I_method_12f562b5().I_method_14b8caf5();
        iiIiiiiii_Class4482.I_method_359d223f();
        iiIiiiiii_Class4482.I_method_7e07d875(true);
        iiIiiiiii_Class4482.i_method_7fcac895(false);
        iiIiiiiii_Class4482.II_method_44ae3612(false);
        iiIiiiiii_Class4482.Ii_method_46712632(false);
        iiIiiiiii_Class4482.iI_method_7b4949f2(false);
        iiIiiiiii_Class4482.ii_method_7d0c3a12(false);
        iiIiiiiii_Class4482.III_method_52d38c15(false);
        return iiiIiIIII_Class465.Nested1_33b738a0.I_field_86e7b1e7;
    }

    static boolean I_method_a51b9bd8(BlockState blockState) {
        return iiiIiIIiI_Class467.i_method_2d02a7b8(blockState);
    }

    private static boolean i_method_2d02a7b8(BlockState blockState) {
        if (blockState.isAir()) {
            return true;
        }
        if (blockState.isReplaceable()) {
            return true;
        }
        if (!blockState.getFluidState().isEmpty()) {
            return false;
        }
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.world == null) {
            return false;
        }
        return blockState.getCollisionShape((BlockView)minecraftClient.world, BlockPos.ORIGIN).isEmpty();
    }

    private static Direction I_method_4b16413c(ClientPlayerEntity clientPlayerEntity, BlockPos blockPos) {
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        Direction direction = Direction.UP;
        double d = -1.7976931348623157E308;
        for (Direction direction2 : Direction.values()) {
            Vec3d vec3d2 = Vec3d.ofCenter((Vec3i)blockPos).add((double)direction2.getOffsetX() * 0.5, (double)direction2.getOffsetY() * 0.5, (double)direction2.getOffsetZ() * 0.5);
            Vec3d vec3d3 = vec3d2.subtract(vec3d).normalize();
            double d2 = vec3d3.x * (double)direction2.getOffsetX() + vec3d3.y * (double)direction2.getOffsetY() + vec3d3.z * (double)direction2.getOffsetZ();
            double d3 = -d2;
            if (!(d3 > d)) continue;
            d = d3;
            direction = direction2;
        }
        return direction;
    }

    @Override
    public void I_method_37257dff() {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.interactionManager != null && this.I_field_5a) {
            minecraftClient.interactionManager.cancelBlockBreaking();
        }
        this.I_field_5a = false;
        this.I_field_670402ba = null;
        this.I_field_f86b4e4c.I_method_e4926dff();
        iiIiiiiii_Class448 iiIiiiiii_Class4482 = iiIiiIiIi_Class438.I_method_12f562b5().I_method_14b8caf5();
        iiIiiiiii_Class4482.I_method_7e07d875(false);
        iiIiiiiii_Class4482.III_method_52d38c15(false);
    }
}

