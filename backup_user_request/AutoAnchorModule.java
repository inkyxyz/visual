package rockstar.client;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RespawnAnchorBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.state.property.Property;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.BlockView;
import net.minecraft.world.Difficulty;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import pyrock.events.network.SendPacketEvent;
import pyrock.events.player.ClientPlayerTickEvent;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.BooleanSetting;
import rockstar.client.SliderSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.iiIIiIIIi_Class402;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.iiIIiIiIi_Class406;
import rockstar.client.iiIIiIiiI_Class407;
import rockstar.client.Module;
import rockstar.client.iiIiIIiii_Class424;
import rockstar.client.iiiIIII_Class113;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Auto Anchor", category=ModuleCategory.COMBAT, III_method_a89e5834="modules.descriptions.auto_anchor")
public class AutoAnchorModule
extends Module {
    private BooleanSetting I_field_ba20ca4c;
    private SliderSetting I_field_73178e8c;
    private SliderSetting i_field_73178e8c;
    private static final float I_field_46 = 4.5f;
    private static final float i_field_46 = 0.5f;
    private static final float II_field_46 = 5.0f;
    private static final double I_field_44 = 5.0;
    private static final int I_field_49 = 4;
    private static final float Ii_field_46 = 180.0f;
    private static final long I_field_4a = 4000L;
    private static final long i_field_4a = 25L;
    private static final long II_field_4a = 1L;
    private static final long Ii_field_4a = 5000L;
    private final Map<BlockPos, Nested1_950aa4d3> I_field_a567c40b = new ConcurrentHashMap<BlockPos, Nested1_950aa4d3>();
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
    private final iiIiIIiii_Class424 i_field_991c1e8c = new iiIiIIiii_Class424();
    private final iiIiIIiii_Class424 II_field_991c1e8c = new iiIiIIiii_Class424();
    private int i_field_49 = Integer.MIN_VALUE;
    private final IiIIIiII_Class69<SendPacketEvent> I_field_3d936f41 = sendPacketEvent -> {
        if (!this.isEnabled()) {
            return;
        }
        if (sendPacketEvent.isCancelled()) {
            return;
        }
        Packet<?> packet = sendPacketEvent.getPacket();
        if (!(packet instanceof UpdateSelectedSlotC2SPacket)) {
            return;
        }
        UpdateSelectedSlotC2SPacket updateSelectedSlotC2SPacket = (UpdateSelectedSlotC2SPacket)packet;
        this.i_field_49 = updateSelectedSlotC2SPacket.getSelectedSlot();
    };
    private final IiIIIiII_Class69<ClientPlayerTickEvent> i_field_3d936f41 = clientPlayerTickEvent -> {
        if (AutoAnchorModule.I_field_3a9bda27.player == null || AutoAnchorModule.I_field_3a9bda27.world == null || AutoAnchorModule.I_field_3a9bda27.interactionManager == null || I_field_3a9bda27.getNetworkHandler() == null) {
            return;
        }
        if (RespawnAnchorBlock.isNether((World)AutoAnchorModule.I_field_3a9bda27.world)) {
            return;
        }
        this.Iii_method_5b00b1ec();
        BlockPos blockPos = this.I_method_e5b19d04();
        if (blockPos != null) {
            this.I_method_6ef3e946(blockPos);
            return;
        }
        if (this.I_field_ba20ca4c.i_method_9b12da03()) {
            this.iII_method_8fca49cc();
        }
    };

    public AutoAnchorModule() {
        this.IiI_method_5af2260c();
    }

    @Compile(obfuscation=4)
    private void IiI_method_5af2260c() {
        this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.auto_anchor.place").I_method_a4d009eb(true);
        this.I_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.auto_anchor.min_damage", "modules.settings.auto_anchor.min_damage.desc").I_method_c8c9a7d7(1.0f).i_method_65e2aff7(20.0f).II_method_b0f56334(0.5f).Ii_method_4e0e6b54(4.0f);
        this.i_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.auto_anchor.max_self_damage", "modules.settings.auto_anchor.max_self_damage.desc").I_method_c8c9a7d7(0.0f).i_method_65e2aff7(36.0f).II_method_b0f56334(0.5f).Ii_method_4e0e6b54(12.0f);
    }

    @Override
    public void onEnable() {
        this.i_field_49 = AutoAnchorModule.I_field_3a9bda27.player != null ? AutoAnchorModule.I_field_3a9bda27.player.getInventory().selectedSlot : Integer.MIN_VALUE;
    }

    @Override
    public void onDisable() {
        super.onDisable();
        this.I_field_a567c40b.clear();
        this.i_field_49 = Integer.MIN_VALUE;
    }

    private void Iii_method_5b00b1ec() {
        long l = System.currentTimeMillis();
        Iterator<Map.Entry<BlockPos, Nested1_950aa4d3>> iterator = this.I_field_a567c40b.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<BlockPos, Nested1_950aa4d3> entry = iterator.next();
            if (l - entry.getValue().I_field_4a > 4000L) {
                iterator.remove();
                continue;
            }
            if (AutoAnchorModule.I_field_3a9bda27.world.getBlockState(entry.getKey()).getBlock() instanceof RespawnAnchorBlock || l - entry.getValue().I_field_4a <= 500L) continue;
            iterator.remove();
        }
    }

    private void I_method_6ef3e946(BlockPos blockPos2) {
        BlockState blockState = AutoAnchorModule.I_field_3a9bda27.world.getBlockState(blockPos2);
        if (!(blockState.getBlock() instanceof RespawnAnchorBlock)) {
            return;
        }
        Nested1_950aa4d3 nested1_950aa4d3 = this.I_field_a567c40b.computeIfAbsent(blockPos2.toImmutable(), blockPos -> new Nested1_950aa4d3());
        int n = Math.max((Integer)blockState.get((Property)RespawnAnchorBlock.CHARGES), nested1_950aa4d3.I_field_49);
        boolean bl = n >= 4;
        int n2 = this.I_method_3609982d(Items.GLOWSTONE);
        boolean bl2 = AutoAnchorModule.I_field_3a9bda27.player.getMainHandStack().isOf(Items.GLOWSTONE);
        boolean bl3 = AutoAnchorModule.I_field_3a9bda27.player.getOffHandStack().isOf(Items.GLOWSTONE);
        if (!(bl || bl2 || bl3 || n2 != -1)) {
            this.I_method_971a0be0("auto_anchor.no_glowstone", Items.GLOWSTONE.getName().getString());
            return;
        }
        if (!this.I_field_991c1e8c.I_method_58432069(25L)) {
            return;
        }
        Vec3d vec3d = new Vec3d((double)blockPos2.getX() + 0.5, (double)blockPos2.getY() + 1.0, (double)blockPos2.getZ() + 0.5);
        if (AutoAnchorModule.I_field_3a9bda27.player.getEyePos().distanceTo(vec3d) > 4.5) {
            return;
        }
        if (!this.II_method_c9ade6d9(vec3d)) {
            return;
        }
        this.I_method_dee2873e(vec3d);
        Hand hand = Hand.MAIN_HAND;
        int n3 = AutoAnchorModule.I_field_3a9bda27.player.getInventory().selectedSlot;
        boolean bl4 = false;
        if (bl2) {
            hand = Hand.MAIN_HAND;
        } else if (bl3) {
            hand = Hand.OFF_HAND;
        } else if (n2 != -1 && !bl) {
            AutoAnchorModule.I_field_3a9bda27.player.getInventory().selectedSlot = n2;
            this.II_method_5920b18e(n2);
            bl4 = true;
        }
        BlockHitResult blockHitResult = new BlockHitResult(vec3d, Direction.UP, blockPos2, false);
        AutoAnchorModule.I_field_3a9bda27.interactionManager.interactBlock(AutoAnchorModule.I_field_3a9bda27.player, hand, blockHitResult);
        AutoAnchorModule.I_field_3a9bda27.player.swingHand(hand);
        if (!bl) {
            ++nested1_950aa4d3.I_field_49;
        }
        nested1_950aa4d3.I_field_4a = System.currentTimeMillis();
        this.I_field_991c1e8c.I_method_23e11e3f();
        if (bl4) {
            AutoAnchorModule.I_field_3a9bda27.player.getInventory().selectedSlot = n3;
            this.II_method_5920b18e(n3);
        }
    }

    @Nullable
    private BlockPos I_method_e5b19d04() {
        BlockPos blockPos = AutoAnchorModule.I_field_3a9bda27.player.getBlockPos();
        int n = (int)Math.ceil(4.5);
        float f = -1.0f;
        double d = Double.MAX_VALUE;
        BlockPos blockPos2 = null;
        for (int i = -n; i <= n; ++i) {
            for (int j = -n; j <= n; ++j) {
                for (int k = -n; k <= n; ++k) {
                    Vec3d vec3d;
                    BlockPos blockPos3 = blockPos.add(i, j, k);
                    if (!(AutoAnchorModule.I_field_3a9bda27.world.getBlockState(blockPos3).getBlock() instanceof RespawnAnchorBlock)) continue;
                    Vec3d vec3d2 = new Vec3d((double)blockPos3.getX() + 0.5, (double)blockPos3.getY() + 1.0, (double)blockPos3.getZ() + 0.5);
                    if (AutoAnchorModule.I_field_3a9bda27.player.getEyePos().distanceTo(vec3d2) > 4.5 || !this.II_method_c9ade6d9(vec3d2) || !this.I_method_6ef3e94a(blockPos3) || this.i_method_99477d2a(blockPos3) || !this.i_method_b9fa7f62(vec3d = blockPos3.toCenterPos())) continue;
                    float f2 = this.I_method_dee2872e(vec3d);
                    if (!this.I_method_dee28742(vec3d)) continue;
                    double d2 = AutoAnchorModule.I_field_3a9bda27.player.squaredDistanceTo(vec3d);
                    if (!(f2 > f) && (f2 != f || !(d2 < d))) continue;
                    f = f2;
                    d = d2;
                    blockPos2 = blockPos3.toImmutable();
                }
            }
        }
        return blockPos2;
    }

    private void iII_method_8fca49cc() {
        Hand hand;
        boolean bl;
        int n = this.I_method_3609982d(Items.RESPAWN_ANCHOR);
        boolean bl2 = bl = AutoAnchorModule.I_field_3a9bda27.player.getMainHandStack().isOf(Items.RESPAWN_ANCHOR) || AutoAnchorModule.I_field_3a9bda27.player.getOffHandStack().isOf(Items.RESPAWN_ANCHOR);
        if (n == -1 && !bl) {
            this.I_method_971a0be0("auto_anchor.no_anchor", Items.RESPAWN_ANCHOR.getName().getString());
            return;
        }
        if (this.i_method_6006284d(Items.GLOWSTONE) < 4) {
            this.I_method_971a0be0("auto_anchor.no_glowstone", Items.GLOWSTONE.getName().getString());
            return;
        }
        BlockPos blockPos = this.i_method_5aac0d24();
        if (blockPos == null) {
            return;
        }
        if (!this.i_field_991c1e8c.I_method_58432069(1L)) {
            return;
        }
        Vec3d vec3d = new Vec3d((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 1.0, (double)blockPos.getZ() + 0.5);
        this.I_method_dee2873e(vec3d);
        int n2 = AutoAnchorModule.I_field_3a9bda27.player.getInventory().selectedSlot;
        boolean bl3 = false;
        Hand hand2 = hand = AutoAnchorModule.I_field_3a9bda27.player.getOffHandStack().isOf(Items.RESPAWN_ANCHOR) ? Hand.OFF_HAND : Hand.MAIN_HAND;
        if (hand == Hand.MAIN_HAND && !AutoAnchorModule.I_field_3a9bda27.player.getMainHandStack().isOf(Items.RESPAWN_ANCHOR)) {
            AutoAnchorModule.I_field_3a9bda27.player.getInventory().selectedSlot = n;
            this.II_method_5920b18e(n);
            bl3 = true;
        }
        BlockHitResult blockHitResult = new BlockHitResult(vec3d, Direction.UP, blockPos, false);
        AutoAnchorModule.I_field_3a9bda27.interactionManager.interactBlock(AutoAnchorModule.I_field_3a9bda27.player, hand, blockHitResult);
        AutoAnchorModule.I_field_3a9bda27.player.swingHand(hand);
        this.I_field_a567c40b.put(blockPos.up().toImmutable(), new Nested1_950aa4d3());
        this.i_field_991c1e8c.I_method_23e11e3f();
        if (bl3) {
            AutoAnchorModule.I_field_3a9bda27.player.getInventory().selectedSlot = n2;
            this.II_method_5920b18e(n2);
        }
    }

    @Nullable
    private BlockPos i_method_5aac0d24() {
        BlockPos blockPos = AutoAnchorModule.I_field_3a9bda27.player.getBlockPos();
        int n = (int)Math.ceil(4.5);
        BlockState blockState = Blocks.RESPAWN_ANCHOR.getDefaultState();
        float f = -1.0f;
        double d = Double.MAX_VALUE;
        BlockPos blockPos2 = null;
        for (int i = -n; i <= n; ++i) {
            for (int j = -4; j <= 2; ++j) {
                for (int k = -n; k <= n; ++k) {
                    Vec3d vec3d;
                    BlockPos blockPos3 = blockPos.add(i, j, k);
                    BlockPos blockPos4 = blockPos3.up();
                    if (!AutoAnchorModule.I_field_3a9bda27.world.getBlockState(blockPos3).isSolidBlock((BlockView)AutoAnchorModule.I_field_3a9bda27.world, blockPos3) || !AutoAnchorModule.I_field_3a9bda27.world.getBlockState(blockPos4).isReplaceable() || !AutoAnchorModule.I_field_3a9bda27.world.canPlace(blockState, blockPos4, ShapeContext.absent())) continue;
                    Vec3d vec3d2 = new Vec3d((double)blockPos3.getX() + 0.5, (double)blockPos3.getY() + 1.0, (double)blockPos3.getZ() + 0.5);
                    if (AutoAnchorModule.I_field_3a9bda27.player.getEyePos().distanceTo(vec3d2) > 4.5 || !this.II_method_c9ade6d9(vec3d2) || !this.I_method_6ef3e94a(blockPos4) || this.i_method_99477d2a(blockPos4) || !this.i_method_b9fa7f62(vec3d = blockPos4.toCenterPos()) || !this.I_method_dee28742(vec3d)) continue;
                    float f2 = this.I_method_dee2872e(vec3d);
                    double d2 = AutoAnchorModule.I_field_3a9bda27.player.squaredDistanceTo(vec3d);
                    if (!(f2 > f) && (f2 != f || !(d2 < d))) continue;
                    f = f2;
                    d = d2;
                    blockPos2 = blockPos3.toImmutable();
                }
            }
        }
        return blockPos2;
    }

    private boolean I_method_dee28742(Vec3d vec3d) {
        float f = this.I_field_73178e8c.Ii_method_a20abcd2();
        LivingEntity livingEntity = RockstarClient.getInstance().I_method_9a638462().I_method_4517f36c();
        if (livingEntity != null && livingEntity.isAlive() && livingEntity != AutoAnchorModule.I_field_3a9bda27.player) {
            if (livingEntity instanceof PlayerEntity) {
                PlayerEntity playerEntity = (PlayerEntity)livingEntity;
                if (RockstarClient.getInstance().I_method_7a5acaeb().I_method_19c9437a(playerEntity.getName().getString())) {
                    return this.I_method_dee2872e(vec3d) >= f;
                }
            }
            return this.I_method_f7b8e08f(vec3d, livingEntity) >= f;
        }
        return this.I_method_dee2872e(vec3d) >= f;
    }

    private boolean i_method_b9fa7f62(Vec3d vec3d) {
        float f = this.I_method_f7b8e08f(vec3d, (LivingEntity)AutoAnchorModule.I_field_3a9bda27.player);
        if (f > this.i_field_73178e8c.Ii_method_a20abcd2()) {
            return false;
        }
        return f < AutoAnchorModule.I_field_3a9bda27.player.getHealth() + AutoAnchorModule.I_field_3a9bda27.player.getAbsorptionAmount();
    }

    private float I_method_dee2872e(Vec3d vec3d) {
        float f = 0.0f;
        for (PlayerEntity playerEntity : AutoAnchorModule.I_field_3a9bda27.world.getPlayers()) {
            if (playerEntity == AutoAnchorModule.I_field_3a9bda27.player || !playerEntity.isAlive() || RockstarClient.getInstance().I_method_7a5acaeb().I_method_19c9437a(playerEntity.getName().getString())) continue;
            f = Math.max(f, this.I_method_f7b8e08f(vec3d, (LivingEntity)playerEntity));
        }
        return f;
    }

    private float I_method_f7b8e08f(Vec3d vec3d, LivingEntity livingEntity) {
        Vec3d vec3d2 = livingEntity.getBoundingBox().getCenter();
        double d = vec3d2.distanceTo(vec3d);
        if (d > 5.0) {
            return 0.0f;
        }
        double d2 = this.I_method_9fe57e90(vec3d, vec3d2) ? 1.0 : 0.35;
        double d3 = (1.0 - d / 5.0) * d2;
        float f = (float)((d3 * d3 + d3) / 2.0 * 7.0 * 10.0 + 1.0);
        Difficulty difficulty = AutoAnchorModule.I_field_3a9bda27.world.getDifficulty();
        f *= (switch (difficulty) {
            case Difficulty.PEACEFUL -> 0.0f;
            case Difficulty.EASY -> 0.5f;
            case Difficulty.HARD -> 1.5f;
            default -> 1.0f;
        });
        float f2 = livingEntity.getArmor();
        return Math.max(0.0f, f *= 1.0f - Math.min(f2 / (f2 + 20.0f), 0.8f));
    }

    private boolean I_method_6ef3e94a(BlockPos blockPos) {
        return (double)blockPos.getY() + 0.5 - AutoAnchorModule.I_field_3a9bda27.player.getY() >= 0.5;
    }

    private boolean i_method_99477d2a(BlockPos blockPos) {
        Vec3d vec3d = Vec3d.ofCenter((Vec3i)blockPos);
        Box box = new Box(vec3d, vec3d).expand(5.0);
        for (PlayerEntity playerEntity2 : AutoAnchorModule.I_field_3a9bda27.world.getEntitiesByClass(PlayerEntity.class, box, playerEntity -> playerEntity != AutoAnchorModule.I_field_3a9bda27.player)) {
            if (!playerEntity2.isAlive() || !RockstarClient.getInstance().I_method_7a5acaeb().I_method_19c9437a(playerEntity2.getName().getString())) continue;
            return true;
        }
        return false;
    }

    private boolean I_method_9fe57e90(Vec3d vec3d, Vec3d vec3d2) {
        return AutoAnchorModule.I_field_3a9bda27.world.raycast(new RaycastContext(vec3d, vec3d2, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, (Entity)AutoAnchorModule.I_field_3a9bda27.player)).getType() == HitResult.Type.MISS;
    }

    private boolean II_method_c9ade6d9(Vec3d vec3d) {
        BlockHitResult blockHitResult = AutoAnchorModule.I_field_3a9bda27.world.raycast(new RaycastContext(AutoAnchorModule.I_field_3a9bda27.player.getEyePos(), vec3d, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, (Entity)AutoAnchorModule.I_field_3a9bda27.player));
        return blockHitResult.getType() == HitResult.Type.MISS;
    }

    private int I_method_3609982d(Item item) {
        for (int i = 0; i < 9; ++i) {
            if (!AutoAnchorModule.I_field_3a9bda27.player.getInventory().getStack(i).isOf(item)) continue;
            return i;
        }
        return -1;
    }

    private int i_method_6006284d(Item item) {
        int n = 0;
        for (int i = 0; i < 9; ++i) {
            ItemStack itemStack = AutoAnchorModule.I_field_3a9bda27.player.getInventory().getStack(i);
            if (!itemStack.isOf(item)) continue;
            n += itemStack.getCount();
        }
        ItemStack itemStack = AutoAnchorModule.I_field_3a9bda27.player.getOffHandStack();
        if (itemStack.isOf(item)) {
            n += itemStack.getCount();
        }
        return n;
    }

    private void I_method_971a0be0(String string, String string2) {
        if (!this.II_field_991c1e8c.I_method_58432069(5000L)) {
            return;
        }
        this.II_field_991c1e8c.I_method_23e11e3f();
        RockstarClient.getInstance().I_method_5cb1af22().I_method_20d0f49b(iiiIIII_Class113.i_field_c11fcfcc, IiIiIIII_Class81.I_method_f25a980a(string), IiIiIIII_Class81.I_method_1410d1e5("auto_anchor.need_item", string2));
    }

    private void II_method_5920b18e(int n) {
        if (I_field_3a9bda27.getNetworkHandler() == null || n < 0 || n > 8) {
            return;
        }
        if (n == this.i_field_49) {
            return;
        }
        I_field_3a9bda27.getNetworkHandler().sendPacket((Packet)new UpdateSelectedSlotC2SPacket(n));
    }

    private void I_method_dee2873e(Vec3d vec3d) {
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = iiIIiIiIi_Class406.I_method_bc8095a1(vec3d);
        RockstarClient.getInstance().I_method_58785402().I_method_1acbf705(iiIIiIIii_Class4042, iiIIiIIIi_Class402.Ii_field_32e0c64c, 180.0f, 180.0f, 180.0f, iiIIiIiiI_Class407.ii_field_32efc66c);
    }

    static final class Nested1_950aa4d3 {
        int I_field_49;
        long I_field_4a = System.currentTimeMillis();

        Nested1_950aa4d3() {
        }
    }
}

