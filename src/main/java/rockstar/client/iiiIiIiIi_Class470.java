package rockstar.client;

import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import rockstar.client.iiIiiIiIi_Class438;
import rockstar.client.iiIiiiiii_Class448;
import rockstar.client.iiiIIIIII_Class449;
import rockstar.client.iiiIIIIIi_Class450;
import rockstar.client.iiiIIIiIi_Class454;
import rockstar.client.iiiIIiIIi_Class458;
import rockstar.client.iiiIiIIII_Class465;
import rockstar.client.iiiIiIIiI_Class467;

public class iiiIiIiIi_Class470
extends iiiIiIIII_Class465 {
    private static final double Ii_field_44 = 1.5;
    private static final double iI_field_44 = 0.4;
    private double ii_field_44 = Double.POSITIVE_INFINITY;
    private int I_field_49;
    private BlockPos I_field_670402ba;
    private boolean I_field_5a;
    private final iiiIIIIIi_Class450 I_field_f86b4e4c = new iiiIIIIIi_Class450();

    public iiiIiIiIi_Class470(iiiIIiIIi_Class458 iiiIIiIIi_Class4582, iiiIIiIIi_Class458 iiiIIiIIi_Class4583) {
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
        if (this.i_field_fa2e3e6c.I_method_6d204e12() != this.I_field_fa2e3e6c.I_method_6d204e12() || this.i_field_fa2e3e6c.II_method_36f86d15() != this.I_field_fa2e3e6c.II_method_36f86d15()) {
            return false;
        }
        if (this.i_field_fa2e3e6c.i_method_6d2ed9f2() != this.I_field_fa2e3e6c.i_method_6d2ed9f2() - 1) {
            return false;
        }
        int n = iiiIIIiIi_Class4542.I_method_ca82d457(this.I_field_fa2e3e6c.I_method_6d204e12(), this.I_field_fa2e3e6c.i_method_6d2ed9f2() - 1, this.I_field_fa2e3e6c.II_method_36f86d15());
        if (n == Integer.MAX_VALUE || n == 0) {
            return false;
        }
        if (!iiiIIIiIi_Class4542.i_method_674a3c88(this.I_field_fa2e3e6c.I_method_6d204e12(), this.I_field_fa2e3e6c.i_method_6d2ed9f2() - 2, this.I_field_fa2e3e6c.II_method_36f86d15())) {
            return false;
        }
        if (iiiIIIiIi_Class4542.ii_method_b822e605(this.I_field_fa2e3e6c.I_method_6d204e12(), this.I_field_fa2e3e6c.i_method_6d2ed9f2() - 2, this.I_field_fa2e3e6c.II_method_36f86d15())) {
            return false;
        }
        this.I_field_49 = n;
        double d = (double)n / 20.0;
        this.ii_field_44 = 1.0 + d * 1.5 + 0.4;
        return true;
    }

    @Override
    public iiiIiIIII_Class465.Nested1_33b738a0 I_method_8cdd8810() {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (clientPlayerEntity == null || minecraftClient.world == null || minecraftClient.interactionManager == null) {
            return iiiIiIIII_Class465.Nested1_33b738a0.II_field_86e7b1e7;
        }
        BlockPos blockPos = new BlockPos(this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15());
        BlockState blockState = minecraftClient.world.getBlockState(blockPos);
        boolean bl = !iiiIiIIiI_Class467.I_method_a51b9bd8(blockState);
        iiIiiiiii_Class448 iiIiiiiii_Class4482 = iiIiiIiIi_Class438.I_method_12f562b5().I_method_14b8caf5();
        iiIiiiiii_Class4482.I_method_359d223f();
        iiIiiiiii_Class4482.I_method_7e07d875(false);
        iiIiiiiii_Class4482.i_method_7fcac895(false);
        iiIiiiiii_Class4482.II_method_44ae3612(false);
        iiIiiiiii_Class4482.Ii_method_46712632(false);
        iiIiiiiii_Class4482.iI_method_7b4949f2(false);
        iiIiiiiii_Class4482.ii_method_7d0c3a12(false);
        iiIiiiiii_Class4482.III_method_52d38c15(false);
        if (!bl) {
            if (this.I_field_5a) {
                minecraftClient.interactionManager.cancelBlockBreaking();
                this.I_field_5a = false;
                this.I_field_670402ba = null;
                this.I_field_f86b4e4c.I_method_e4926dff();
            }
            if (clientPlayerEntity.isOnGround() && Math.abs(clientPlayerEntity.getY() - (double)this.i_field_fa2e3e6c.i_method_6d2ed9f2()) < 0.1) {
                return iiiIiIIII_Class465.Nested1_33b738a0.i_field_86e7b1e7;
            }
            return iiiIiIIII_Class465.Nested1_33b738a0.I_field_86e7b1e7;
        }
        iiiIIIIII_Class449.I_method_98560fd8(blockState);
        if (this.I_field_670402ba != null && !this.I_field_670402ba.equals((Object)blockPos)) {
            minecraftClient.interactionManager.cancelBlockBreaking();
            this.I_field_f86b4e4c.I_method_e4926dff();
        }
        this.I_field_670402ba = blockPos;
        this.I_field_5a = true;
        if (!this.I_field_f86b4e4c.I_method_b97a0d1b(blockPos, Direction.UP)) {
            return iiiIiIIII_Class465.Nested1_33b738a0.I_field_86e7b1e7;
        }
        minecraftClient.interactionManager.updateBlockBreakingProgress(blockPos, Direction.UP);
        clientPlayerEntity.swingHand(clientPlayerEntity.getActiveHand());
        return iiiIiIIII_Class465.Nested1_33b738a0.I_field_86e7b1e7;
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

