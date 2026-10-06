package rockstar.client;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.EmptyBlockView;
import rockstar.client.IIIIiIII_Class9;
import rockstar.client.iiiiiii_Class128;

public class IIIIiiiI_Class15
implements IIIIiIII_Class9 {
    private BlockPos I_field_670402ba;
    private Direction I_field_3b03ad36 = Direction.UP;
    private long I_field_4a;
    private boolean I_field_5a;

    @Override
    public void I_method_f2de637a(iiiiiii_Class128 iiiiiii_Class1282) {
        long l;
        if (iiiiiii_Class1282 == null || !iiiiiii_Class1282.Ii_method_16f24ea6()) {
            return;
        }
        iiiiiii_Class128.Nested1_ec28200 nested1_ec28200 = iiiiiii_Class1282.I_method_4a21e990(iiiiiii_Class1282.I_method_e08ecf78().iii_method_206639ba());
        if (nested1_ec28200 == null || !this.I_method_a9ae6058(iiiiiii_Class1282, nested1_ec28200.I_method_a5de6273().getBlockPos())) {
            this.I_field_5a = false;
            iiiiiii_Class1282.Iii_method_c77508df();
            return;
        }
        BlockPos blockPos = nested1_ec28200.I_method_a5de6273().getBlockPos().toImmutable();
        Direction direction = nested1_ec28200.I_method_a5de6273().getSide();
        if (!blockPos.equals((Object)this.I_field_670402ba)) {
            this.I_field_670402ba = blockPos;
            this.I_field_5a = false;
        }
        this.I_field_3b03ad36 = direction == null ? this.I_field_3b03ad36 : direction;
        iiiiiii_Class1282.I_method_b644c79f(blockPos.toCenterPos().x, blockPos.toCenterPos().y, blockPos.toCenterPos().z);
        iiiiiii_Class1282.Iii_method_c77508df();
        if (!iiiiiii_Class1282.I_method_331eac77(blockPos.toCenterPos(), iiiiiii_Class1282.I_method_e08ecf78().IiiI_method_4fa88ee3())) {
            return;
        }
        if (!this.I_field_5a) {
            iiiiiii_Class1282.I_method_dbaec697(blockPos, this.I_field_3b03ad36);
            this.I_field_5a = true;
        }
        if ((l = System.currentTimeMillis()) - this.I_field_4a >= iiiiiii_Class1282.I_method_e08ecf78().III_method_e7f9a9e0()) {
            iiiiiii_Class1282.i_method_bd2ba6b7(blockPos, this.I_field_3b03ad36);
            this.I_field_4a = l;
        }
    }

    private boolean I_method_a9ae6058(iiiiiii_Class128 iiiiiii_Class1282, BlockPos blockPos) {
        if (blockPos == null || !iiiiiii_Class1282.I_method_1729e358().I_method_747b892a(blockPos) && !iiiiiii_Class1282.I_method_1729e358().i_method_9ecf1d0a(blockPos)) {
            return false;
        }
        BlockState blockState = iiiiiii_Class1282.I_method_1729e358().I_method_27bc425(blockPos);
        return !blockState.isAir() && blockState.getHardness((BlockView)EmptyBlockView.INSTANCE, blockPos) >= 0.0f;
    }

    @Override
    public String I_method_dcc0dd54() {
        return this.I_field_670402ba == null ? "InstantRebreak" : "InstantRebreak " + this.I_field_670402ba.getX() + " " + this.I_field_670402ba.getY() + " " + this.I_field_670402ba.getZ();
    }
}

