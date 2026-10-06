package rockstar.client;

import java.util.Locale;
import lombok.Generated;
import moscow.rockstar.mixin.accessors.EntityMovementMultiplierAccessor;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MaceItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.TridentItem;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.scoreboard.ReadableScoreboardScore;
import net.minecraft.scoreboard.ScoreHolder;
import net.minecraft.scoreboard.ScoreboardCriterion;
import net.minecraft.scoreboard.ScoreboardDisplaySlot;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.scoreboard.number.NumberFormat;
import net.minecraft.scoreboard.number.StyledNumberFormat;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import rockstar.client.iIIIiiIii_Class284;
import rockstar.client.iIIIiiiII_Class285;
import rockstar.client.iIIiIIiIi_Class294;

public final class IiiiiiiII_Class253
implements iIIiIIiIi_Class294 {
    private static float I_field_46 = 1.0f;

    public static void I_method_1cb61e3f() {
        I_field_46 = 1.0f;
    }

    public static Block I_method_37e734f9() {
        return IiiiiiiII_Class253.I_method_59c3e499(0.0, 0.0, 0.0);
    }

    public static Block I_method_59c3e499(double d, double d2, double d3) {
        return !IiiiiiiII_Class253.i_method_1cc4aa23() ? Blocks.AIR : IiiiiiiII_Class253.I_field_3a9bda27.world.getBlockState(BlockPos.ofFloored((Position)IiiiiiiII_Class253.I_field_3a9bda27.player.getPos().add(d, d2, d3))).getBlock();
    }

    public static boolean I_method_7a0e09e3(double d) {
        return IiiiiiiII_Class253.I_method_59c3e499(0.3, d, 0.3) != Blocks.AIR || IiiiiiiII_Class253.I_method_59c3e499(-0.3, d, 0.3) != Blocks.AIR || IiiiiiiII_Class253.I_method_59c3e499(0.3, d, -0.3) != Blocks.AIR || IiiiiiiII_Class253.I_method_59c3e499(-0.3, d, -0.3) != Blocks.AIR;
    }

    public static boolean I_method_cf852202(LivingEntity livingEntity) {
        return IiiiiiiII_Class253.I_method_211f8586(livingEntity, 0.0f);
    }

    public static boolean I_method_211f8586(LivingEntity livingEntity, float f) {
        Box box = IiiiiiiII_Class253.I_field_3a9bda27.player.getBoundingBox().expand((double)f, 0.0, (double)f);
        return livingEntity.getBoundingBox().intersects(box);
    }

    public static boolean I_method_6e525578(LivingEntity livingEntity, Vec3d vec3d, float f) {
        return IiiiiiiII_Class253.I_method_1ccff55f(livingEntity.getBoundingBox().offset(-livingEntity.getX(), -livingEntity.getY(), -livingEntity.getZ()).offset(vec3d), f);
    }

    public static boolean I_method_1ccff55f(Box box, float f) {
        Box box2 = IiiiiiiII_Class253.I_field_3a9bda27.player.getBoundingBox().expand((double)f, 0.0, (double)f);
        return box.intersects(box2);
    }

    public static StatusEffectInstance I_method_a2497e13(RegistryEntry<StatusEffect> registryEntry, int n, int n2) {
        return new StatusEffectInstance(registryEntry, n, n2, false, false, false);
    }

    public static boolean I_method_d4e81454(StatusEffectInstance statusEffectInstance) {
        return statusEffectInstance != null && !statusEffectInstance.shouldShowParticles() && !statusEffectInstance.shouldShowIcon();
    }

    public static void I_method_c7b3e4d5(double d, boolean bl) {
        double d2 = IiiiiiiII_Class253.I_field_3a9bda27.player.input.movementForward;
        double d3 = IiiiiiiII_Class253.I_field_3a9bda27.player.input.movementSideways;
        float f = IiiiiiiII_Class253.I_field_3a9bda27.player.getYaw();
        if (!(d2 != 0.0 || d3 != 0.0 || bl && (IiiiiiiII_Class253.I_field_3a9bda27.options.jumpKey.isPressed() || IiiiiiiII_Class253.I_field_3a9bda27.options.sneakKey.isPressed()))) {
            IiiiiiiII_Class253.I_field_3a9bda27.player.setVelocity(0.0, IiiiiiiII_Class253.I_field_3a9bda27.player.getVelocity().y, 0.0);
            return;
        }
        if (d2 != 0.0) {
            if (d3 > 0.0) {
                f += (float)(d2 > 0.0 ? -45 : 45);
            } else if (d3 < 0.0) {
                f += (float)(d2 > 0.0 ? 45 : -45);
            }
            d3 = 0.0;
            d2 = d2 > 0.0 ? 1.0 : -1.0;
        }
        double d4 = Math.sin(Math.toRadians((double)f + 90.0));
        double d5 = Math.cos(Math.toRadians((double)f + 90.0));
        double d6 = d2 * d * d5 + d3 * d * d4;
        double d7 = d2 * d * d4 - d3 * d * d5;
        double d8 = 0.0;
        if (IiiiiiiII_Class253.I_field_3a9bda27.options.jumpKey.isPressed()) {
            d8 += d;
        }
        if (IiiiiiiII_Class253.I_field_3a9bda27.options.sneakKey.isPressed()) {
            d8 -= d;
        }
        IiiiiiiII_Class253.I_field_3a9bda27.player.setVelocity(d6, bl ? d8 / 2.0 : IiiiiiiII_Class253.I_field_3a9bda27.player.getVelocity().y, d7);
    }

    public static boolean i_method_efa40a22(LivingEntity livingEntity) {
        double d;
        if (IiiiiiiII_Class253.I_field_3a9bda27.player == null) {
            return false;
        }
        double d2 = Math.sqrt(livingEntity.getVelocity().x * livingEntity.getVelocity().x + livingEntity.getVelocity().z * livingEntity.getVelocity().z);
        if (d2 < 0.1) {
            return false;
        }
        double d3 = livingEntity.getX() - IiiiiiiII_Class253.I_field_3a9bda27.player.getX();
        double d4 = Math.sqrt(d3 * d3 + (d = livingEntity.getZ() - IiiiiiiII_Class253.I_field_3a9bda27.player.getZ()) * d);
        if (d4 < 0.1) {
            return false;
        }
        double d5 = d3 / d4;
        double d6 = livingEntity.getVelocity().x;
        double d7 = d / d4;
        double d8 = livingEntity.getVelocity().z;
        double d9 = d5 * d6 + d7 * d8;
        return d9 > 0.15;
    }

    public static boolean I_method_1cb61e43() {
        if (IiiiiiiII_Class253.I_field_3a9bda27.player == null || IiiiiiiII_Class253.I_field_3a9bda27.world == null || IiiiiiiII_Class253.I_field_3a9bda27.player.input == null) {
            return false;
        }
        return (double)IiiiiiiII_Class253.I_field_3a9bda27.player.forwardSpeed != 0.0 || (double)IiiiiiiII_Class253.I_field_3a9bda27.player.input.movementSideways != 0.0;
    }

    public static Block I_method_b7dc7ce1(Entity entity) {
        if (entity == null) {
            return null;
        }
        BlockPos blockPos = entity.getBlockPos().down();
        return IiiiiiiII_Class253.I_method_498d07a1(blockPos, entity.getWorld());
    }

    public static Block i_method_ce961501(Entity entity) {
        if (entity == null) {
            return null;
        }
        BlockPos blockPos = entity.getBlockPos().add(0, Math.round(entity.getHeight()), 0).up();
        return IiiiiiiII_Class253.I_method_498d07a1(blockPos, entity.getWorld());
    }

    public static Block i_method_4d7ca8d9() {
        if (IiiiiiiII_Class253.I_field_3a9bda27.player == null || IiiiiiiII_Class253.I_field_3a9bda27.world == null) {
            return null;
        }
        BlockPos blockPos = IiiiiiiII_Class253.I_field_3a9bda27.player.getBlockPos().down().up();
        return IiiiiiiII_Class253.I_method_498d07a1(blockPos, (World)IiiiiiiII_Class253.I_field_3a9bda27.world);
    }

    public static Block II_method_d50ef9fc() {
        if (IiiiiiiII_Class253.I_field_3a9bda27.player == null || IiiiiiiII_Class253.I_field_3a9bda27.world == null) {
            return null;
        }
        BlockPos blockPos = IiiiiiiII_Class253.I_field_3a9bda27.player.getBlockPos().up();
        return IiiiiiiII_Class253.I_method_498d07a1(blockPos, (World)IiiiiiiII_Class253.I_field_3a9bda27.world);
    }

    public static Block II_method_422cdabe(Entity entity) {
        if (entity == null) {
            return null;
        }
        BlockPos blockPos = entity.getBlockPos();
        return IiiiiiiII_Class253.I_method_498d07a1(blockPos, entity.getWorld());
    }

    public static double I_method_1cb61e2d() {
        return Math.hypot(IiiiiiiII_Class253.I_field_3a9bda27.player.getVelocity().x, IiiiiiiII_Class253.I_field_3a9bda27.player.getVelocity().z);
    }

    public static Block Ii_method_eaa46ddc() {
        if (IiiiiiiII_Class253.I_field_3a9bda27.player == null || IiiiiiiII_Class253.I_field_3a9bda27.world == null) {
            return null;
        }
        BlockPos blockPos = IiiiiiiII_Class253.I_field_3a9bda27.player.getBlockPos();
        return IiiiiiiII_Class253.I_method_498d07a1(blockPos, (World)IiiiiiiII_Class253.I_field_3a9bda27.world);
    }

    public static Block I_method_498d07a1(BlockPos blockPos, World world) {
        return world.getBlockState(blockPos).getBlock();
    }

    public static double I_method_2edb44cf(float f, double d, double d2) {
        if (d < 0.0) {
            f += 180.0f;
        }
        float f2 = 1.0f;
        if (d < 0.0) {
            f2 = -0.5f;
        } else if (d > 0.0) {
            f2 = 0.5f;
        }
        if (d2 > 0.0) {
            f -= 90.0f * f2;
        }
        if (d2 < 0.0) {
            f += 90.0f * f2;
        }
        return Math.toRadians(f);
    }

    public static boolean i_method_1cc4aa23() {
        return IiiiiiiII_Class253.I_field_3a9bda27.player != null && IiiiiiiII_Class253.I_field_3a9bda27.world != null;
    }

    public static float I_method_6c00a1c4(PlayerEntity playerEntity) {
        if (playerEntity == null) {
            return 0.0f;
        }
        ScoreboardObjective scoreboardObjective = playerEntity.getScoreboard().getObjectiveForSlot(ScoreboardDisplaySlot.BELOW_NAME);
        if (scoreboardObjective != null) {
            ReadableScoreboardScore readableScoreboardScore = playerEntity.getScoreboard().getScore((ScoreHolder)playerEntity, scoreboardObjective);
            String string = ReadableScoreboardScore.getFormattedScore((ReadableScoreboardScore)readableScoreboardScore, (NumberFormat)scoreboardObjective.getNumberFormatOr((NumberFormat)StyledNumberFormat.EMPTY)).getString();
            Float f = IiiiiiiII_Class253.I_method_9ef45892(string);
            if (IiiiiiiII_Class253.I_method_2ab189be(scoreboardObjective, string)) {
                return f != null ? f.floatValue() : (readableScoreboardScore != null ? (float)readableScoreboardScore.getScore() : playerEntity.getHealth());
            }
        }
        return playerEntity.getHealth();
    }

    private static Float I_method_9ef45892(String string) {
        int n = -1;
        int n2 = -1;
        boolean bl = false;
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (Character.isDigit(c)) {
                if (n == -1) {
                    n = i;
                }
                n2 = i + 1;
                continue;
            }
            if (!(c != '.' && c != ',' || n == -1 || bl)) {
                bl = true;
                n2 = i + 1;
                continue;
            }
            if (n != -1) break;
        }
        if (n == -1) {
            return null;
        }
        try {
            return Float.valueOf(Float.parseFloat(string.substring(n, n2).replace(',', '.')));
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    private static boolean I_method_2ab189be(ScoreboardObjective scoreboardObjective, String string) {
        if (iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.ii_field_ac164e6c)) {
            return true;
        }
        if (iIIIiiiII_Class285.i_method_f55209e3()) {
            return true;
        }
        if (scoreboardObjective.getRenderType() == ScoreboardCriterion.RenderType.HEARTS) {
            return true;
        }
        String string2 = (scoreboardObjective.getName() + " " + scoreboardObjective.getDisplayName().getString() + " " + string).toLowerCase(Locale.ROOT);
        if (string2.contains("hp") || string2.contains("\u0445\u043f") || string2.contains("\u0437\u0434\u043e\u0440\u043e\u0432") || string2.contains("\u2764") || string2.contains("\u2665")) {
            return true;
        }
        return string2.contains("funtime") || string2.contains("fun time") || string2.contains("\u0444\u0430\u043d\u0442\u0430\u0439\u043c");
    }

    public static boolean II_method_7a1ca106() {
        if (IiiiiiiII_Class253.I_field_3a9bda27.player == null) {
            return false;
        }
        ItemStack itemStack = IiiiiiiII_Class253.I_field_3a9bda27.player.getMainHandStack();
        Item item = itemStack.getItem();
        if (itemStack.isEmpty()) {
            return false;
        }
        return item instanceof SwordItem || item instanceof AxeItem || item instanceof TridentItem || item instanceof MaceItem;
    }

    public static boolean Ii_method_7a2b2ce6() {
        return IiiiiiiII_Class253.I_method_3c21782b((Entity)IiiiiiiII_Class253.I_field_3a9bda27.player);
    }

    public static boolean I_method_3c21782b(Entity entity) {
        if (!(entity instanceof EntityMovementMultiplierAccessor)) {
            return false;
        }
        EntityMovementMultiplierAccessor entityMovementMultiplierAccessor = (EntityMovementMultiplierAccessor)(Object)entity;
        Vec3d vec3d = entityMovementMultiplierAccessor.getMovementMultiplier();
        if (vec3d == null) {
            return false;
        }
        return IiiiiiiII_Class253.I_method_658f476f(vec3d);
    }

    private static boolean I_method_658f476f(Vec3d vec3d) {
        return IiiiiiiII_Class253.I_method_9dfd4d37(vec3d, 0.25, 0.05, 0.25) || IiiiiiiII_Class253.I_method_9dfd4d37(vec3d, 0.5, 0.25, 0.5);
    }

    private static boolean I_method_9dfd4d37(Vec3d vec3d, double d, double d2, double d3) {
        double d4 = 1.0E-6;
        return Math.abs(vec3d.x - d) < d4 && Math.abs(vec3d.y - d2) < d4 && Math.abs(vec3d.z - d3) < d4;
    }

    @Generated
    private IiiiiiiII_Class253() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    @Generated
    public static void I_method_7a0e1161(float f) {
        I_field_46 = f;
    }

    @Generated
    public static float I_method_1cb61e2f() {
        return I_field_46;
    }
}

