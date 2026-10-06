package rockstar.client;

import java.util.HashSet;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import rockstar.client.IIIIIIii_Class4;
import rockstar.client.IIIIiIII_Class9;
import rockstar.client.iiiiiii_Class128;

public class IIIIiiii_Class16
implements IIIIiIII_Class9 {
    private final Set<Block> I_field_a56a8dc5 = new HashSet<Block>();
    private BlockPos I_field_670402ba;
    private Direction I_field_3b03ad36 = Direction.UP;
    private long I_field_4a;
    private int I_field_49;

    public void I_method_ba4b5abe(Block block) {
        if (block != null) {
            this.I_field_a56a8dc5.add(block);
        }
    }

    public void I_method_8dbb3ccc() {
        this.I_field_a56a8dc5.clear();
        this.I_field_670402ba = null;
    }

    @Override
    public void I_method_f2de637a(iiiiiii_Class128 iiiiiii_Class1282) {
        if (iiiiiii_Class1282 == null || this.I_field_a56a8dc5.isEmpty()) {
            return;
        }
        if (this.I_field_670402ba == null || !this.I_method_619d6078(iiiiiii_Class1282, this.I_field_670402ba)) {
            this.I_field_670402ba = this.I_method_ed858816(iiiiiii_Class1282);
        }
        if (this.I_field_670402ba == null) {
            iiiiiii_Class1282.Iii_method_c77508df();
            return;
        }
        Vec3d vec3d = this.I_field_670402ba.toCenterPos();
        iiiiiii_Class1282.I_method_b644c79f(vec3d.x, vec3d.y, vec3d.z);
        double d = iiiiiii_Class1282.I_method_e09ce338().I_method_d573f06().add(0.0, iiiiiii_Class1282.I_method_e08ecf78().iiIi_method_eabb92c3(), 0.0).distanceTo(vec3d);
        if (d > iiiiiii_Class1282.I_method_e08ecf78().IIii_method_191c06e3()) {
            iiiiiii_Class1282.I_method_331eac73(vec3d, iiiiiii_Class1282.I_method_e08ecf78().IIii_method_191c06e3() * 0.8);
            return;
        }
        iiiiiii_Class1282.Iii_method_c77508df();
        this.I_field_3b03ad36 = this.I_method_4aaf85d4(iiiiiii_Class1282, this.I_field_670402ba);
        if (!this.I_method_6e7a0ed4(iiiiiii_Class1282, vec3d)) {
            return;
        }
        long l = System.currentTimeMillis();
        if (l - this.I_field_4a < iiiiiii_Class1282.I_method_e08ecf78().Ii_method_180ddbe9()) {
            return;
        }
        iiiiiii_Class1282.i_method_b1654e4a(new BlockHitResult(vec3d, this.I_field_3b03ad36, this.I_field_670402ba, false));
        this.I_field_4a = l;
    }

    private BlockPos I_method_ed858816(iiiiiii_Class128 iiiiiii_Class1282) {
        if (this.I_field_49 > 0) {
            --this.I_field_49;
            return this.I_field_670402ba;
        }
        this.I_field_49 = Math.max(1, iiiiiii_Class1282.I_method_e08ecf78().II_method_17ff5008());
        IIIIIIii_Class4 iIIIIIii_Class4 = iiiiiii_Class1282.I_method_e08ecf78();
        BlockPos blockPos = BlockPos.ofFloored((Position)iiiiiii_Class1282.I_method_e09ce338().I_method_d573f06());
        int n = Math.max(1, iIIIIIii_Class4.I_method_907c0bf());
        int n2 = Math.max(1, iIIIIIii_Class4.i_method_9164c9f());
        BlockPos blockPos2 = null;
        double d = Double.MAX_VALUE;
        for (int i = -n; i <= n; ++i) {
            for (int j = -n2; j <= n2; ++j) {
                for (int k = -n; k <= n; ++k) {
                    double d2;
                    BlockPos blockPos3 = blockPos.add(i, j, k);
                    if (!this.I_method_619d6078(iiiiiii_Class1282, blockPos3) || !((d2 = blockPos3.getSquaredDistance((Vec3i)blockPos)) < d)) continue;
                    blockPos2 = blockPos3.toImmutable();
                    d = d2;
                }
            }
        }
        return blockPos2;
    }

    private boolean I_method_619d6078(iiiiiii_Class128 iiiiiii_Class1282, BlockPos blockPos) {
        if (iiiiiii_Class1282 == null || blockPos == null) {
            return false;
        }
        if (!iiiiiii_Class1282.I_method_1729e358().I_method_747b892a(blockPos) && !iiiiiii_Class1282.I_method_1729e358().i_method_9ecf1d0a(blockPos)) {
            return false;
        }
        BlockState blockState = iiiiiii_Class1282.I_method_1729e358().I_method_27bc425(blockPos);
        return !blockState.isAir() && this.I_field_a56a8dc5.contains(blockState.getBlock());
    }

    private Direction I_method_4aaf85d4(iiiiiii_Class128 iiiiiii_Class1282, BlockPos blockPos) {
        Vec3d vec3d = iiiiiii_Class1282.I_method_e09ce338().I_method_d573f06().add(0.0, iiiiiii_Class1282.I_method_e08ecf78().iiIi_method_eabb92c3(), 0.0);
        Vec3d vec3d2 = blockPos.toCenterPos();
        return Direction.getFacing((double)(vec3d.x - vec3d2.x), (double)(vec3d.y - vec3d2.y), (double)(vec3d.z - vec3d2.z));
    }

    private boolean I_method_6e7a0ed4(iiiiiii_Class128 iiiiiii_Class1282, Vec3d vec3d) {
        Vec3d vec3d2 = iiiiiii_Class1282.I_method_e09ce338().I_method_d573f06().add(0.0, iiiiiii_Class1282.I_method_e08ecf78().iiIi_method_eabb92c3(), 0.0);
        double d = vec3d.x - vec3d2.x;
        double d2 = vec3d.y - vec3d2.y;
        double d3 = vec3d.z - vec3d2.z;
        double d4 = Math.sqrt(d * d + d3 * d3);
        float f = (float)Math.toDegrees(Math.atan2(-d, d3));
        float f2 = (float)Math.toDegrees(-Math.atan2(d2, d4));
        double d5 = Math.abs(MathHelper.wrapDegrees((float)(f - iiiiiii_Class1282.I_method_e09ce338().I_method_6865f47c())));
        double d6 = Math.abs(f2 - iiiiiii_Class1282.I_method_e09ce338().i_method_6874805c());
        return d5 <= iiiiiii_Class1282.I_method_e08ecf78().IiII_method_4de59ec3() && d6 <= iiiiiii_Class1282.I_method_e08ecf78().IiII_method_4de59ec3();
    }

    @Override
    public String I_method_dcc0dd54() {
        return "Mining " + this.I_field_a56a8dc5.size();
    }
}

