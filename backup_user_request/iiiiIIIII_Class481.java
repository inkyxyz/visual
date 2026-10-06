package rockstar.client;

import java.util.HashSet;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.BlockView;
import net.minecraft.world.RaycastContext;
import org.jetbrains.annotations.Nullable;
import rockstar.client.iiIiiIiII_Class437;
import rockstar.client.iiIiiIiIi_Class438;
import rockstar.client.iiIiiiiii_Class448;
import rockstar.client.iiiIIIIII_Class449;
import rockstar.client.iiiIIIIIi_Class450;
import rockstar.client.iiiIIIIii_Class452;
import rockstar.client.iiiIIiiII_Class461;
import rockstar.client.iiiiIIIiI_Class483;
import rockstar.client.iiiiIIiII_Class485;

public final class iiiiIIIII_Class481
implements iiiiIIiII_Class485 {
    private final BlockPos I_field_670402ba;
    private final BlockPos i_field_670402ba;
    @Nullable
    private final Block I_field_d9031850;
    private final int I_field_49;
    private int i_field_49;
    @Nullable
    private BlockPos II_field_670402ba;
    @Nullable
    private iiiiIIIiI_Class483 I_field_95332aac;
    private boolean I_field_5a;
    private final iiiIIIIIi_Class450 I_field_f86b4e4c = new iiiIIIIIi_Class450();
    private boolean i_field_5a;
    private boolean II_field_5a;
    private int II_field_49;
    private final Set<BlockPos> I_field_a56a8dc5 = new HashSet<BlockPos>();

    public iiiiIIIII_Class481(BlockPos blockPos, BlockPos blockPos2, @Nullable Block block) {
        this.I_field_670402ba = blockPos;
        this.i_field_670402ba = blockPos2;
        this.I_field_d9031850 = block;
        this.I_field_49 = this.I_method_4a8db232();
    }

    private int I_method_4a8db232() {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.world == null) {
            return 0;
        }
        int n = 0;
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int i = this.I_field_670402ba.getY(); i <= this.i_field_670402ba.getY(); ++i) {
            for (int j = this.I_field_670402ba.getX(); j <= this.i_field_670402ba.getX(); ++j) {
                for (int k = this.I_field_670402ba.getZ(); k <= this.i_field_670402ba.getZ(); ++k) {
                    mutable.set(j, i, k);
                    if (!this.I_method_95d85f24(minecraftClient, (BlockPos)mutable)) continue;
                    ++n;
                }
            }
        }
        return n;
    }

    private boolean I_method_95d85f24(MinecraftClient minecraftClient, BlockPos blockPos) {
        if (minecraftClient.world == null) {
            return false;
        }
        BlockState blockState = minecraftClient.world.getBlockState(blockPos);
        if (blockState.isAir()) {
            return false;
        }
        if (blockState.getBlock() instanceof FluidBlock) {
            return false;
        }
        if (blockState.getHardness((BlockView)minecraftClient.world, blockPos) < 0.0f) {
            return false;
        }
        return this.I_field_d9031850 == null || blockState.getBlock() == this.I_field_d9031850;
    }

    @Override
    public String I_method_31075c81() {
        return "excavate";
    }

    @Override
    public String i_method_c4260ca1() {
        if (this.i_field_5a) {
            return "\u043f\u0430\u0443\u0437\u0430";
        }
        if (this.II_field_5a) {
            return "\u0433\u043e\u0442\u043e\u0432\u043e";
        }
        String string = this.i_field_49 + "/" + this.I_field_49;
        if (this.I_field_5a) {
            return "\u043a\u043e\u043f\u0430\u0435\u043c " + String.valueOf(this.II_field_670402ba) + " (" + string + ")";
        }
        if (this.I_field_95332aac != null) {
            return "\u0438\u0434\u0451\u043c \u043a " + String.valueOf(this.II_field_670402ba) + " (" + string + ")";
        }
        return "\u0440\u0430\u0441\u043a\u043e\u043f " + string;
    }

    @Override
    public boolean I_method_8f3b7603() {
        boolean bl;
        if (this.i_field_5a) {
            return false;
        }
        if (this.II_field_5a) {
            return true;
        }
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.player == null || minecraftClient.world == null || minecraftClient.interactionManager == null) {
            return false;
        }
        iiIiiIiII_Class437.I_method_d9acc61f();
        if (this.I_field_5a && this.II_field_670402ba != null) {
            if (!this.I_method_95d85f24(minecraftClient, this.II_field_670402ba)) {
                if (minecraftClient.world.getBlockState(this.II_field_670402ba).isAir()) {
                    ++this.i_field_49;
                }
                this.I_field_5a = false;
                this.II_field_670402ba = null;
                this.Ii_method_74618e2();
                return false;
            }
            Vec3d vec3d = Vec3d.ofCenter((Vec3i)this.II_field_670402ba);
            double d = minecraftClient.player.getEyePos().distanceTo(vec3d);
            if (d > 5.0) {
                this.I_field_5a = false;
                this.Ii_method_74618e2();
                this.I_field_95332aac = new iiiiIIIiI_Class483(new iiiIIiiII_Class461(this.II_field_670402ba, 2));
                return false;
            }
            if (!iiiiIIIII_Class481.i_method_d8be0b04(minecraftClient, this.II_field_670402ba)) {
                this.I_field_5a = false;
                this.Ii_method_74618e2();
                ++this.II_field_49;
                if (this.II_field_49 >= 3) {
                    this.I_field_a56a8dc5.add(this.II_field_670402ba);
                    this.II_field_670402ba = null;
                    this.II_field_49 = 0;
                    return false;
                }
                this.I_field_95332aac = new iiiiIIIiI_Class483(new iiiIIiiII_Class461(this.II_field_670402ba, 1));
                return false;
            }
            this.II_field_49 = 0;
            iiiIIIIII_Class449.I_method_98560fd8(minecraftClient.world.getBlockState(this.II_field_670402ba));
            Direction direction = this.I_method_184bd980(minecraftClient, this.II_field_670402ba);
            if (!this.I_field_f86b4e4c.I_method_b97a0d1b(this.II_field_670402ba, direction)) {
                return false;
            }
            minecraftClient.interactionManager.updateBlockBreakingProgress(this.II_field_670402ba, direction);
            minecraftClient.player.swingHand(minecraftClient.player.getActiveHand());
            return false;
        }
        if (this.I_field_95332aac != null) {
            boolean bl2 = this.I_field_95332aac.I_method_8f3b7603();
            if (bl2) {
                this.I_field_95332aac = null;
                if (this.II_field_670402ba != null) {
                    double d = minecraftClient.player.getEyePos().distanceTo(Vec3d.ofCenter((Vec3i)this.II_field_670402ba));
                    if (d > 5.0) {
                        this.I_field_a56a8dc5.add(this.II_field_670402ba);
                        this.II_field_670402ba = null;
                    } else {
                        this.I_field_5a = true;
                    }
                }
            }
            return false;
        }
        BlockPos blockPos = this.I_method_83da03ea(minecraftClient);
        if (blockPos == null) {
            iiiIIIIii_Class452.I_method_15375629("\u0420\u0430\u0441\u043a\u043e\u043f \u0437\u0430\u0432\u0435\u0440\u0448\u0451\u043d (" + this.i_field_49 + " \u0431\u043b\u043e\u043a\u043e\u0432)");
            this.I_method_8f3b75ff();
            this.II_field_5a = true;
            return true;
        }
        this.II_field_670402ba = blockPos;
        Vec3d vec3d = Vec3d.ofCenter((Vec3i)blockPos);
        boolean bl3 = bl = minecraftClient.player.getEyePos().distanceTo(vec3d) <= 4.5;
        if (bl && iiiiIIIII_Class481.i_method_d8be0b04(minecraftClient, blockPos)) {
            this.I_field_5a = true;
        } else {
            this.I_field_95332aac = new iiiiIIIiI_Class483(new iiiIIiiII_Class461(blockPos, 2));
        }
        return false;
    }

    @Nullable
    private BlockPos I_method_83da03ea(MinecraftClient minecraftClient) {
        if (minecraftClient.player == null) {
            return null;
        }
        double d = minecraftClient.player.getX();
        double d2 = minecraftClient.player.getZ();
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int i = this.i_field_670402ba.getY(); i >= this.I_field_670402ba.getY(); --i) {
            BlockPos blockPos = null;
            double d3 = Double.MAX_VALUE;
            for (int j = this.I_field_670402ba.getX(); j <= this.i_field_670402ba.getX(); ++j) {
                for (int k = this.I_field_670402ba.getZ(); k <= this.i_field_670402ba.getZ(); ++k) {
                    double d4;
                    double d5;
                    double d6;
                    mutable.set(j, i, k);
                    if (this.I_field_a56a8dc5.contains(mutable) || !this.I_method_95d85f24(minecraftClient, (BlockPos)mutable) || !((d6 = (d5 = (double)j + 0.5 - d) * d5 + (d4 = (double)k + 0.5 - d2) * d4) < d3)) continue;
                    d3 = d6;
                    blockPos = mutable.toImmutable();
                }
            }
            if (blockPos == null) continue;
            return blockPos;
        }
        return null;
    }

    private static boolean i_method_d8be0b04(MinecraftClient minecraftClient, BlockPos blockPos) {
        Vec3d[] vec3dArray;
        if (minecraftClient.world == null || minecraftClient.player == null) {
            return false;
        }
        Vec3d vec3d = minecraftClient.player.getEyePos();
        Vec3d vec3d2 = Vec3d.ofCenter((Vec3i)blockPos);
        for (Vec3d vec3d3 : vec3dArray = new Vec3d[]{vec3d2, vec3d2.add(0.49, 0.0, 0.0), vec3d2.add(-0.49, 0.0, 0.0), vec3d2.add(0.0, 0.49, 0.0), vec3d2.add(0.0, -0.49, 0.0), vec3d2.add(0.0, 0.0, 0.49), vec3d2.add(0.0, 0.0, -0.49)}) {
            RaycastContext raycastContext = new RaycastContext(vec3d, vec3d3, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, (Entity)minecraftClient.player);
            BlockHitResult blockHitResult = minecraftClient.world.raycast(raycastContext);
            if (blockHitResult.getType() != HitResult.Type.BLOCK) {
                return true;
            }
            if (!blockHitResult.getBlockPos().equals((Object)blockPos)) continue;
            return true;
        }
        return false;
    }

    private Direction I_method_184bd980(MinecraftClient minecraftClient, BlockPos blockPos) {
        Vec3d vec3d = minecraftClient.player.getEyePos();
        Direction direction = Direction.UP;
        double d = -1.0;
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

    private void Ii_method_74618e2() {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.interactionManager != null) {
            minecraftClient.interactionManager.cancelBlockBreaking();
        }
    }

    @Override
    public void I_method_8f3b75ff() {
        if (this.I_field_95332aac != null) {
            this.I_field_95332aac.I_method_8f3b75ff();
            this.I_field_95332aac = null;
        }
        this.Ii_method_74618e2();
        iiIiiiiii_Class448 iiIiiiiii_Class4482 = iiIiiIiIi_Class438.I_method_12f562b5().I_method_14b8caf5();
        iiIiiiiii_Class4482.i_method_35abae1f();
        this.II_field_670402ba = null;
        this.I_field_5a = false;
    }

    @Override
    public void i_method_8f4a01df() {
        this.i_field_5a = true;
        if (this.I_field_95332aac != null) {
            this.I_field_95332aac.i_method_8f4a01df();
        }
        this.Ii_method_74618e2();
        iiIiiIiIi_Class438.I_method_12f562b5().I_method_14b8caf5().i_method_35abae1f();
    }

    @Override
    public void II_method_58424142() {
        this.i_field_5a = false;
        if (this.I_field_95332aac != null) {
            this.I_field_95332aac.II_method_58424142();
        }
    }

    @Override
    public boolean i_method_8f4a01e3() {
        return this.i_field_5a;
    }

    @Override
    public boolean II_method_58424146() {
        return this.II_field_5a;
    }
}

