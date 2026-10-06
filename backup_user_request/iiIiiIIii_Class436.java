package rockstar.client;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import org.jetbrains.annotations.Nullable;

public final class iiIiiIIii_Class436 {
    private static final iiIiiIIii_Class436 I_field_cfa8a68c = new iiIiiIIii_Class436();
    @Nullable
    private BlockPos I_field_670402ba;
    @Nullable
    private BlockPos i_field_670402ba;

    public static iiIiiIIii_Class436 I_method_29e64b35() {
        return I_field_cfa8a68c;
    }

    private iiIiiIIii_Class436() {
    }

    public int I_method_9d7525ec(BlockPos blockPos) {
        if (this.I_field_670402ba == null) {
            this.I_field_670402ba = blockPos;
            return 1;
        }
        if (this.i_field_670402ba == null) {
            this.i_field_670402ba = blockPos;
            return 2;
        }
        this.I_field_670402ba = blockPos;
        this.i_field_670402ba = null;
        return 1;
    }

    public void I_method_9d7525f9(BlockPos blockPos) {
        this.I_field_670402ba = blockPos;
    }

    public void i_method_c7c8b9d9(BlockPos blockPos) {
        this.i_field_670402ba = blockPos;
    }

    public void I_method_b0e9a63f() {
        this.I_field_670402ba = null;
        this.i_field_670402ba = null;
    }

    @Nullable
    public BlockPos I_method_528c7df1() {
        return this.I_field_670402ba;
    }

    @Nullable
    public BlockPos i_method_c786ee11() {
        return this.i_field_670402ba;
    }

    public boolean I_method_b0e9a643() {
        return this.I_field_670402ba != null && this.i_field_670402ba != null;
    }

    public BlockPos II_method_79a4af8e() {
        return new BlockPos(Math.min(this.I_field_670402ba.getX(), this.i_field_670402ba.getX()), Math.min(this.I_field_670402ba.getY(), this.i_field_670402ba.getY()), Math.min(this.I_field_670402ba.getZ(), this.i_field_670402ba.getZ()));
    }

    public BlockPos Ii_method_ee9f1fae() {
        return new BlockPos(Math.max(this.I_field_670402ba.getX(), this.i_field_670402ba.getX()), Math.max(this.I_field_670402ba.getY(), this.i_field_670402ba.getY()), Math.max(this.I_field_670402ba.getZ(), this.i_field_670402ba.getZ()));
    }

    @Nullable
    public Box I_method_7f661a53() {
        if (this.I_field_670402ba == null) {
            return null;
        }
        BlockPos blockPos = this.I_field_670402ba;
        BlockPos blockPos2 = this.i_field_670402ba != null ? this.i_field_670402ba : this.I_field_670402ba;
        int n = Math.min(blockPos.getX(), blockPos2.getX());
        int n2 = Math.min(blockPos.getY(), blockPos2.getY());
        int n3 = Math.min(blockPos.getZ(), blockPos2.getZ());
        int n4 = Math.max(blockPos.getX(), blockPos2.getX());
        int n5 = Math.max(blockPos.getY(), blockPos2.getY());
        int n6 = Math.max(blockPos.getZ(), blockPos2.getZ());
        return new Box((double)n, (double)n2, (double)n3, (double)(n4 + 1), (double)(n5 + 1), (double)(n6 + 1));
    }
}

