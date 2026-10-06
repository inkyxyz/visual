package rockstar.client;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.RaycastContext;
import pyrock.events.player.ClientPlayerTickEvent;
import rockstar.client.SliderSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.iIIIiiiII_Class285;
import rockstar.client.iiIIiIIIi_Class402;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.iiIIiIiiI_Class407;
import rockstar.client.Module;
import rockstar.client.iiIiIIiii_Class424;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Nuker", category=ModuleCategory.PLAYER, III_method_a89e5834="modules.descriptions.nuker")
public class NukerModule
extends Module {
    private SliderSetting I_field_73178e8c;
    private BlockPos I_field_670402ba = null;
    private BlockPos i_field_670402ba = null;
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
    private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = clientPlayerTickEvent -> {
        if (NukerModule.I_field_3a9bda27.player == null || NukerModule.I_field_3a9bda27.world == null || NukerModule.I_field_3a9bda27.interactionManager == null) {
            return;
        }
        NukerModule.I_field_3a9bda27.options.attackKey.setPressed(false);
        this.I_field_670402ba = this.I_method_9097e611();
        if (this.I_field_670402ba == null) {
            this.i_field_670402ba = null;
            return;
        }
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = this.I_method_c654522f(this.I_field_670402ba);
        RockstarClient.getInstance().I_method_58785402().I_method_1acbf705(iiIIiIIii_Class4042, iiIIiIIIi_Class402.Ii_field_32e0c64c, 180.0f, 180.0f, 180.0f, iiIIiIiiI_Class407.i_field_32efc66c);
        if (this.i_field_670402ba == null || !this.i_field_670402ba.equals((Object)this.I_field_670402ba)) {
            this.i_field_670402ba = this.I_field_670402ba;
            this.I_field_991c1e8c.I_method_23e11e3f();
        }
        if (!this.I_field_991c1e8c.I_method_58432069((long)this.I_field_73178e8c.Ii_method_a20abcd2())) {
            return;
        }
        iiIIiIIii_Class404 iiIIiIIii_Class4043 = RockstarClient.getInstance().I_method_58785402().II_method_f098f858();
        if (iiIIiIIii_Class4043 != null && iiIIiIIii_Class4043.I_method_24e31c97(iiIIiIIii_Class4042) > 3.0f) {
            return;
        }
        Direction direction = this.I_method_afd44df9(this.I_field_670402ba);
        NukerModule.I_field_3a9bda27.interactionManager.updateBlockBreakingProgress(this.I_field_670402ba, direction);
        NukerModule.I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
    };

    public NukerModule() {
        this.IiI_method_2a840a9f();
    }

    @Compile(obfuscation=4)
    private void IiI_method_2a840a9f() {
        this.I_field_73178e8c = new SliderSetting(this, "modules.settings.nuker.swap_delay").II_method_b0f56334(1.0f).I_method_c8c9a7d7(0.0f).i_method_65e2aff7(500.0f).Ii_method_4e0e6b54(5.0f);
    }

    private int I_method_20d6c1cc(BlockPos blockPos) {
        Block block = NukerModule.I_field_3a9bda27.world.getBlockState(blockPos).getBlock();
        if (block == Blocks.ANCIENT_DEBRIS) {
            return 10;
        }
        if (block == Blocks.DIAMOND_ORE || block == Blocks.DEEPSLATE_DIAMOND_ORE) {
            return 9;
        }
        if (block == Blocks.EMERALD_ORE || block == Blocks.DEEPSLATE_EMERALD_ORE) {
            return 8;
        }
        if (block == Blocks.GOLD_ORE || block == Blocks.DEEPSLATE_GOLD_ORE || block == Blocks.NETHER_GOLD_ORE) {
            return 7;
        }
        if (block == Blocks.LAPIS_ORE || block == Blocks.DEEPSLATE_LAPIS_ORE) {
            return 6;
        }
        if (block == Blocks.REDSTONE_ORE || block == Blocks.DEEPSLATE_REDSTONE_ORE) {
            return 5;
        }
        if (block == Blocks.IRON_ORE || block == Blocks.DEEPSLATE_IRON_ORE) {
            return 4;
        }
        if (block == Blocks.COPPER_ORE || block == Blocks.DEEPSLATE_COPPER_ORE) {
            return 3;
        }
        if (block == Blocks.COAL_ORE || block == Blocks.DEEPSLATE_COAL_ORE) {
            return 2;
        }
        if (block == Blocks.NETHER_QUARTZ_ORE) {
            return 1;
        }
        return 0;
    }

    private boolean I_method_d88da18f(Block block) {
        if (!iIIIiiiII_Class285.II_method_b33b3946()) {
            return true;
        }
        return block == Blocks.DIAMOND_ORE || block == Blocks.DEEPSLATE_DIAMOND_ORE || block == Blocks.EMERALD_ORE || block == Blocks.DEEPSLATE_EMERALD_ORE || block == Blocks.GOLD_ORE || block == Blocks.DEEPSLATE_GOLD_ORE || block == Blocks.NETHER_GOLD_ORE || block == Blocks.LAPIS_ORE || block == Blocks.DEEPSLATE_LAPIS_ORE || block == Blocks.REDSTONE_ORE || block == Blocks.DEEPSLATE_REDSTONE_ORE || block == Blocks.IRON_ORE || block == Blocks.DEEPSLATE_IRON_ORE || block == Blocks.COPPER_ORE || block == Blocks.DEEPSLATE_COPPER_ORE || block == Blocks.COAL_ORE || block == Blocks.DEEPSLATE_COAL_ORE || block == Blocks.NETHER_QUARTZ_ORE || block == Blocks.ANCIENT_DEBRIS || block == Blocks.COBBLESTONE || block == Blocks.STONE || block == Blocks.GRANITE || block == Blocks.DIORITE || block == Blocks.ANDESITE || block == Blocks.DEEPSLATE || block == Blocks.COBBLED_DEEPSLATE;
    }

    private BlockPos I_method_9097e611() {
        double d = NukerModule.I_field_3a9bda27.player.getBlockInteractionRange();
        int n = (int)Math.ceil(d);
        Vec3d vec3d = NukerModule.I_field_3a9bda27.player.getEyePos();
        BlockPos blockPos = NukerModule.I_field_3a9bda27.player.getBlockPos();
        BlockPos blockPos2 = null;
        int n2 = -1;
        double d2 = Double.MAX_VALUE;
        for (int i = 0; i <= n; ++i) {
            for (int j = -n; j <= n; ++j) {
                for (int k = -n; k <= n; ++k) {
                    int n3;
                    double d3;
                    BlockPos blockPos3 = blockPos.add(j, i, k);
                    Block block = NukerModule.I_field_3a9bda27.world.getBlockState(blockPos3).getBlock();
                    if (block == Blocks.AIR || block.getHardness() < 0.0f || !this.I_method_d88da18f(block) || (d3 = vec3d.squaredDistanceTo(Vec3d.ofCenter((Vec3i)blockPos3))) > d * d || !this.I_method_fa01d989(blockPos3, d) || (n3 = this.I_method_20d6c1cc(blockPos3)) <= n2 && (n3 != n2 || !(d3 < d2))) continue;
                    n2 = n3;
                    d2 = d3;
                    blockPos2 = blockPos3;
                }
            }
        }
        return blockPos2;
    }

    private boolean I_method_fa01d989(BlockPos blockPos, double d) {
        Vec3d vec3d = NukerModule.I_field_3a9bda27.player.getEyePos();
        Vec3d vec3d2 = Vec3d.ofCenter((Vec3i)blockPos);
        double d2 = vec3d2.x - vec3d.x;
        double d3 = vec3d2.y - vec3d.y;
        double d4 = vec3d2.z - vec3d.z;
        double d5 = Math.sqrt(d2 * d2 + d3 * d3 + d4 * d4);
        Vec3d vec3d3 = new Vec3d(d2 / d5, d3 / d5, d4 / d5);
        BlockHitResult blockHitResult = NukerModule.I_field_3a9bda27.world.raycast(new RaycastContext(vec3d, vec3d.add(vec3d3.multiply(d + 0.5)), RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, (Entity)NukerModule.I_field_3a9bda27.player));
        if (blockHitResult == null || blockHitResult.getType() == HitResult.Type.MISS) {
            return false;
        }
        BlockPos blockPos2 = blockHitResult.getBlockPos();
        return blockPos2 != null && blockPos2.equals((Object)blockPos);
    }

    private iiIIiIIii_Class404 I_method_c654522f(BlockPos blockPos) {
        Vec3d vec3d = Vec3d.ofCenter((Vec3i)blockPos);
        Vec3d vec3d2 = NukerModule.I_field_3a9bda27.player.getEyePos();
        double d = vec3d.x - vec3d2.x;
        double d2 = vec3d.y - vec3d2.y;
        double d3 = vec3d.z - vec3d2.z;
        double d4 = Math.sqrt(d * d + d3 * d3);
        float f = (float)Math.toDegrees(Math.atan2(d3, d)) - 90.0f;
        float f2 = (float)(-Math.toDegrees(Math.atan2(d2, d4)));
        return new iiIIiIIii_Class404(f, f2);
    }

    private Direction I_method_afd44df9(BlockPos blockPos) {
        Vec3d vec3d = NukerModule.I_field_3a9bda27.player.getEyePos();
        BlockHitResult blockHitResult = NukerModule.I_field_3a9bda27.world.raycast(new RaycastContext(vec3d, Vec3d.ofCenter((Vec3i)blockPos), RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, (Entity)NukerModule.I_field_3a9bda27.player));
        if (blockHitResult.getType() == HitResult.Type.BLOCK && blockHitResult.getBlockPos().equals((Object)blockPos)) {
            return blockHitResult.getSide();
        }
        Vec3d vec3d2 = Vec3d.ofCenter((Vec3i)blockPos);
        double d = vec3d.x - vec3d2.x;
        double d2 = vec3d.y - vec3d2.y;
        double d3 = vec3d.z - vec3d2.z;
        double d4 = Math.abs(d);
        double d5 = Math.abs(d2);
        double d6 = Math.abs(d3);
        if (d5 >= d4 && d5 >= d6) {
            return d2 >= 0.0 ? Direction.UP : Direction.DOWN;
        }
        if (d4 >= d6) {
            return d >= 0.0 ? Direction.EAST : Direction.WEST;
        }
        return d3 >= 0.0 ? Direction.SOUTH : Direction.NORTH;
    }

    @Override
    public void onDisable() {
        super.onDisable();
        NukerModule.I_field_3a9bda27.options.attackKey.setPressed(false);
        this.I_field_670402ba = null;
        this.i_field_670402ba = null;
    }
}

