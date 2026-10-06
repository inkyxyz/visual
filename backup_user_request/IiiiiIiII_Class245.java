package rockstar.client;

import lombok.Generated;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MaceItem;
import net.minecraft.item.ShieldItem;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiiiIii_Class252;
import rockstar.client.IiiiiiiII_Class253;
import rockstar.client.iIIIiIiiI_Class279;
import rockstar.client.iIIIiiIii_Class284;
import rockstar.client.iIIIiiiII_Class285;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiIiIIi_Class298;
import rockstar.client.iIIiiIiII_Class309;
import rockstar.client.iIIiiIiIi_Class310;
import rockstar.client.iIIiiiIii_Class316;
import rockstar.client.iIiIiiIiI_Class347;
import rockstar.client.AuraModule;
import rockstar.client.BackTrackModule;
import rockstar.client.CriticalsModule;
import rockstar.client.iiiIIII_Class113;

public final class IiiiiIiII_Class245
implements iIIiIIiIi_Class294 {
    public static iIIiiiIii_Class316 I_method_cca9db15() {
        iIIiiIiII_Class309<iIIiiiIii_Class316> iIIiiIiII_Class3092 = iIIiiIiIi_Class310.I_method_6a489695();
        RegistryKey<Enchantment> preferredEnchantment = IiiiiIiII_Class245.I_field_3a9bda27.player.fallDistance > 2.0f
            ? Enchantments.WIND_BURST
            : Enchantments.BREACH;
        iIIiiiIii_Class316 iIIiiiIii_Class3162 = iIIiiIiII_Class3092.I_method_77fa4424(stack -> IiiiiIiII_Class245.I_method_d2902f70(preferredEnchantment, stack));
        if (iIIiiiIii_Class3162 == null) {
            iIIiiiIii_Class3162 = iIIiiIiII_Class3092.I_method_5d34dd7d(Items.MACE);
        }
        return iIIiiiIii_Class3162;
    }

    public static Vec3d I_method_34612227(Entity entity, boolean bl) {
        Vec3d vec3d;
        BackTrackModule iiIiiIRockstarClient182 = RockstarClient.getInstance().getModuleManager().getModule(BackTrackModule.class);
        if (iiIiiIRockstarClient182.isEnabled() && entity instanceof iIiIiiIiI_Class347 && (vec3d = iiIiiIRockstarClient182.I_method_73e25ed4(entity)) != null) {
            return vec3d;
        }
        vec3d = IiiiiiIii_Class252.I_method_34ed4d41(entity);
        Vec3d vec3d2 = entity.getPos();
        return IiiiiIiII_Class245.I_field_3a9bda27.player.getEyePos().distanceTo(vec3d) < IiiiiIiII_Class245.I_field_3a9bda27.player.getEyePos().distanceTo(vec3d2) && bl ? vec3d : vec3d2;
    }

    public static Box I_method_96435a81(Entity entity, boolean bl) {
        return entity.getBoundingBox().offset(-entity.getX(), -entity.getY(), -entity.getZ()).offset(IiiiiIiII_Class245.I_method_34612227(entity, bl));
    }

    public static double I_method_27ef575b(Entity entity, boolean bl) {
        return entity.getEyeY() - entity.getY() + IiiiiIiII_Class245.I_method_34612227((Entity)entity, (boolean)bl).y;
    }

    public static float I_method_71f7f60e(LivingEntity livingEntity) {
        AuraModule iiIiIIRockstarClient102 = RockstarClient.getInstance().getModuleManager().getModule(AuraModule.class);
        return iIIIiiiII_Class285.Ii_method_b349c526() || iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.Iii_field_ac164e6c) || iIIIiiiII_Class285.I_method_dbbac60d("cakeworld") || iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.i_field_ac164e6c) || iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c) ? iiIiIIRockstarClient102.i_method_bc12845c() : 0.0f;
    }

    public static boolean I_method_94283e23() {
        AuraModule iiIiIIRockstarClient102 = RockstarClient.getInstance().getModuleManager().getModule(AuraModule.class);
        if (IiiiiiiII_Class253.I_method_59c3e499(0.0, 2.0, 0.0) != Blocks.AIR && IiiiiiiII_Class253.I_method_59c3e499(0.0, -1.0, 0.0) != Blocks.AIR && iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.i_field_ac164e6c) && iiIiIIRockstarClient102.II_method_c48a1048() % 5 == 0) {
            return false;
        }
        return IiiiiIiII_Class245.I_field_3a9bda27.player.fallDistance > 1.2f || IiiiiIiII_Class245.I_field_3a9bda27.player.fallDistance < 0.76f;
    }

    public static boolean I_method_cd07807a(LivingEntity livingEntity, boolean bl) {
        if (IiiiiIiII_Class245.I_field_3a9bda27.world == null || IiiiiIiII_Class245.I_field_3a9bda27.player == null) {
            return false;
        }
        Block block = IiiiiIiII_Class245.I_field_3a9bda27.world.getBlockState(IiiiiIiII_Class245.I_field_3a9bda27.player.getBlockPos().up(2)).getBlock();
        AuraModule iiIiIIRockstarClient102 = RockstarClient.getInstance().getModuleManager().getModule(AuraModule.class);
        CriticalsModule iiIiiIiI_Class2192 = RockstarClient.getInstance().getModuleManager().getModule(CriticalsModule.class);
        double d = (double)((int)IiiiiIiII_Class245.I_field_3a9bda27.player.getY()) - IiiiiIiII_Class245.I_field_3a9bda27.player.getY();
        boolean bl2 = d == -0.01250004768371582;
        boolean bl3 = d == -0.1875;
        return IiiiiIiII_Class245.I_field_3a9bda27.player.isClimbing() || IiiiiIiII_Class245.I_field_3a9bda27.player.isTouchingWater() && IiiiiiiII_Class253.I_method_59c3e499(0.0, 1.0, 0.0) == Blocks.WATER && IiiiiIiII_Class245.I_field_3a9bda27.player.fallDistance <= 0.0f || IiiiiIiII_Class245.I_field_3a9bda27.player.isSwimming() || iiIiiIiI_Class2192.iiI_method_2e239210() || IiiiiIiII_Class245.I_field_3a9bda27.player.isInLava() || iiIiIIRockstarClient102.I_method_d5c7315d().isSelected() || IiiiiIiII_Class245.I_field_3a9bda27.player.getAbilities().flying || IiiiiIiII_Class245.I_field_3a9bda27.player.hasStatusEffect(StatusEffects.BLINDNESS) || IiiiiIiII_Class245.I_field_3a9bda27.player.hasStatusEffect(StatusEffects.LEVITATION) || IiiiiIiII_Class245.I_field_3a9bda27.player.hasStatusEffect(StatusEffects.SLOW_FALLING) || IiiiiIiII_Class245.I_field_3a9bda27.player.hasVehicle() || IiiiiIiII_Class245.I_field_3a9bda27.player.fallDistance > IiiiiIiII_Class245.I_method_71f7f60e(livingEntity) && !IiiiiIiII_Class245.I_field_3a9bda27.player.isOnGround() && IiiiiIiII_Class245.I_method_94283e23() || iiIiiIiI_Class2192.iII_method_2c60a1f0() || IiiiiiiII_Class253.I_method_59c3e499(0.0, 2.0, 0.0) != Blocks.AIR && IiiiiiiII_Class253.I_method_59c3e499(0.0, -1.0, 0.0) != Blocks.AIR && iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.i_field_ac164e6c) && IiiiiIiII_Class245.I_field_3a9bda27.player.isOnGround() && iiIiIIRockstarClient102.II_method_c48a1048() % 5 == 0;
    }

    public static boolean I_method_71f7f622(LivingEntity livingEntity) {
        if (IiiiiIiII_Class245.I_field_3a9bda27.world == null || IiiiiIiII_Class245.I_field_3a9bda27.player == null) {
            return false;
        }
        AuraModule iiIiIIRockstarClient102 = RockstarClient.getInstance().getModuleManager().getModule(AuraModule.class);
        CriticalsModule iiIiiIiI_Class2192 = RockstarClient.getInstance().getModuleManager().getModule(CriticalsModule.class);
        double d = (double)((int)IiiiiIiII_Class245.I_field_3a9bda27.player.getY()) - IiiiiIiII_Class245.I_field_3a9bda27.player.getY();
        return IiiiiIiII_Class245.I_field_3a9bda27.player.isClimbing() || IiiiiIiII_Class245.I_field_3a9bda27.player.isTouchingWater() && IiiiiiiII_Class253.I_method_59c3e499(0.0, 1.0, 0.0) == Blocks.WATER && IiiiiIiII_Class245.I_field_3a9bda27.player.fallDistance <= 0.0f || IiiiiIiII_Class245.I_field_3a9bda27.player.isSwimming() || iiIiiIiI_Class2192.iiI_method_2e239210() || IiiiiIiII_Class245.I_field_3a9bda27.player.isInLava() || iiIiIIRockstarClient102.I_method_d5c7315d().isSelected() || IiiiiIiII_Class245.I_field_3a9bda27.player.getAbilities().flying || IiiiiIiII_Class245.I_field_3a9bda27.player.hasStatusEffect(StatusEffects.BLINDNESS) || IiiiiIiII_Class245.I_field_3a9bda27.player.hasStatusEffect(StatusEffects.LEVITATION) || IiiiiIiII_Class245.I_field_3a9bda27.player.hasStatusEffect(StatusEffects.SLOW_FALLING) || IiiiiIiII_Class245.I_field_3a9bda27.player.hasVehicle() || iIIIiIiiI_Class279.I_method_5a6fa1f8(IiiiiIiII_Class245.I_field_3a9bda27.player).I_method_9e608586(IiiiiIiII_Class245.I_method_71f7f60e(livingEntity), 2) && !IiiiiIiII_Class245.I_field_3a9bda27.player.isOnGround() || iiIiiIiI_Class2192.iII_method_2c60a1f0();
    }

    public static boolean i_method_9216de42(LivingEntity livingEntity) {
        if (!(livingEntity instanceof PlayerEntity)) {
            return false;
        }
        PlayerEntity playerEntity = (PlayerEntity)livingEntity;
        if (!playerEntity.isUsingItem()) {
            return false;
        }
        return playerEntity.getActiveItem().getItem() instanceof ShieldItem;
    }

    public static boolean II_method_1b0f003f(LivingEntity livingEntity) {
        if (IiiiiIiII_Class245.I_field_3a9bda27.player == null || IiiiiIiII_Class245.I_field_3a9bda27.player.isDead()) {
            return false;
        }
        if (livingEntity.isDead()) {
            return false;
        }
        iIIiiiIii_Class316 iIIiiiIii_Class3162 = iIIiiIiIi_Class310.I_method_6a489695().I_method_77fa4424(itemStack -> itemStack.getItem() instanceof AxeItem);
        if (iIIiiiIii_Class3162 == null) {
            return false;
        }
        Vec3d vec3d = livingEntity.getRotationVector(0.0f, livingEntity.getYaw());
        Vec3d vec3d2 = new Vec3d(IiiiiIiII_Class245.I_field_3a9bda27.player.getX() - livingEntity.getX(), 0.0, IiiiiIiII_Class245.I_field_3a9bda27.player.getZ() - livingEntity.getZ());
        double d = vec3d2.length();
        if (d < 0.01) {
            return true;
        }
        return vec3d2.dotProduct(vec3d) > 0.0;
    }

    public static boolean Ii_method_3b2de85f(LivingEntity livingEntity) {
        boolean bl;
        if (IiiiiIiII_Class245.I_field_3a9bda27.player == null || IiiiiIiII_Class245.I_field_3a9bda27.interactionManager == null) {
            return false;
        }
        if (!IiiiiIiII_Class245.i_method_9216de42(livingEntity)) {
            return false;
        }
        iIIiiiIii_Class316 iIIiiiIii_Class3162 = iIIiiIiIi_Class310.I_method_6a489695().I_method_77fa4424(itemStack -> itemStack.getItem() instanceof AxeItem);
        if (iIIiiiIii_Class3162 == null) {
            return false;
        }
        int n = IiiiiIiII_Class245.I_field_3a9bda27.player.getInventory().selectedSlot;
        boolean bl2 = bl = iIIiiiIii_Class3162.II_method_b9cf08f5() != n;
        if (bl) {
            IiiiiIiII_Class245.I_field_3a9bda27.player.networkHandler.sendPacket((Packet)new UpdateSelectedSlotC2SPacket(iIIiiiIii_Class3162.II_method_b9cf08f5()));
        }
        IiiiiIiII_Class245.I_field_3a9bda27.interactionManager.attackEntity((PlayerEntity)IiiiiIiII_Class245.I_field_3a9bda27.player, (Entity)livingEntity);
        IiiiiIiII_Class245.I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
        if (bl) {
            IiiiiIiII_Class245.I_field_3a9bda27.player.networkHandler.sendPacket((Packet)new UpdateSelectedSlotC2SPacket(n));
        }
        RockstarClient.getInstance().I_method_5cb1af22().I_method_20d0f49b(iiiIIII_Class113.I_field_c11fcfcc, IiIiIIII_Class81.I_method_f25a980a("shieldbreaker.title"), IiIiIIII_Class81.I_method_f25a980a("shieldbreaker.desc"));
        return true;
    }

    public static boolean iI_method_fecd1c1f(LivingEntity livingEntity) {
        Vec3d vec3d = livingEntity.getPos();
        Box box = livingEntity.getBoundingBox();
        float f = 0.05f;
        return !IiiiiIiII_Class245.I_method_388a6a03(box.minX - (double)f, vec3d.y, box.minZ - (double)f) || !IiiiiIiII_Class245.I_method_388a6a03(box.maxX + (double)f, vec3d.y, box.minZ - (double)f) || !IiiiiIiII_Class245.I_method_388a6a03(box.minX - (double)f, vec3d.y, box.maxZ + (double)f) || !IiiiiIiII_Class245.I_method_388a6a03(box.maxX + (double)f, vec3d.y, box.maxZ + (double)f);
    }

    private static boolean I_method_388a6a03(double d, double d2, double d3) {
        return IiiiiIiII_Class245.I_field_3a9bda27.world.getBlockState(new BlockPos((int)d, (int)d2, (int)d3)).getBlock() == Blocks.AIR;
    }

    @Generated
    private IiiiiIiII_Class245() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    private static /* synthetic */ boolean I_method_d2902f70(RegistryKey registryKey, ItemStack itemStack) {
        if (!(itemStack.getItem() instanceof MaceItem)) {
            return false;
        }
        return iIIiIiIIi_Class298.I_method_7ea237bf(itemStack, (RegistryKey<Enchantment>)registryKey) > 0;
    }
}
