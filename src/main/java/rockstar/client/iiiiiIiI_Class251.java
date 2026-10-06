package rockstar.client;

import lombok.Generated;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import pyrock.events.player.InputEvent;
import rockstar.client.RockstarClient;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iiIIiIIIi_Class402;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.iiIIiIiII_Class405;
import rockstar.client.iiIIiIiiI_Class407;
import rockstar.client.iiiiiIii_Class252;
import rockstar.client.iiiiiiIi_Class254;
import rockstar.client.iiiiiiiI_Class255;

public final class iiiiiIiI_Class251
implements iIIiIIiIi_Class294 {
    private static final int I_field_49 = 11;
    private static final float I_field_46 = 90.0f;
    private static final int i_field_49 = 24;
    private static final double I_field_44 = 2.0;
    private static final double i_field_44 = 2.5;
    private static final double II_field_44 = 24.0;
    private static final double Ii_field_44 = 32.0;
    private static final int II_field_49 = 10;
    private final iiiiiIii_Class252 I_field_9b38aba1 = new iiiiiIii_Class252(11);
    private final iiiiiiiI_Class255 I_field_9b4733a1 = new iiiiiiiI_Class255(24, 2.0);
    private final iiiiiiIi_Class254.Nested1_c98030f3 I_field_e4941ddc = new iiiiiiIi_Class254.Nested1_c98030f3();
    private boolean I_field_5a;
    private boolean i_field_5a;
    private boolean II_field_5a;
    private boolean Ii_field_5a;
    private boolean iI_field_5a;
    private int Ii_field_49;

    public boolean I_method_edcacb99(ClientPlayerEntity clientPlayerEntity) {
        return this.II_field_5a && clientPlayerEntity.input.hasForwardMovement() && (clientPlayerEntity.getHungerManager().getFoodLevel() > 6 || clientPlayerEntity.getAbilities().allowFlying);
    }

    public void I_method_4754850c() {
        this.II_field_5a = false;
        this.I_field_5a = false;
        this.i_field_5a = false;
        ClientPlayerEntity clientPlayerEntity = iiiiiIiI_Class251.I_field_3a9bda27.player;
        if (clientPlayerEntity == null || iiiiiIiI_Class251.I_field_3a9bda27.world == null || clientPlayerEntity.networkHandler == null) {
            return;
        }
        if (!this.i_method_9520fbb9(clientPlayerEntity)) {
            this.II_method_a34b13d5();
            return;
        }
        boolean bl = clientPlayerEntity.isGliding();
        boolean bl2 = clientPlayerEntity.isOnGround();
        if (bl) {
            this.Ii_field_49 = 10;
        } else if (this.Ii_field_49 > 0) {
            --this.Ii_field_49;
        }
        if (!clientPlayerEntity.input.hasForwardMovement()) {
            this.II_method_a34b13d5();
            return;
        }
        boolean bl3 = bl2 || !bl && this.II_method_6ced6bf0(clientPlayerEntity);
        boolean bl4 = this.iI_field_5a ? this.Ii_field_5a : iiiiiIiI_Class251.I_field_3a9bda27.options.jumpKey.isPressed();
        this.II_field_5a = true;
        this.iI_field_5a = true;
        this.I_field_5a = bl3 && !bl4;
        this.i_field_5a = true;
        this.Ii_field_5a = this.I_field_5a;
        if (bl || this.Ii_field_49 > 0) {
            this.I_method_a65c94d5(clientPlayerEntity, bl, bl2);
        }
    }

    public void I_method_57d50c0c(InputEvent inputEvent) {
        if (!this.II_field_5a) {
            return;
        }
        inputEvent.setJump(this.I_field_5a);
        inputEvent.setSprint(inputEvent.isSprint() || this.i_field_5a);
    }

    public void i_method_476310ec() {
        this.II_field_5a = false;
        this.I_field_5a = false;
        this.i_field_5a = false;
        this.Ii_field_49 = 0;
        this.II_method_a34b13d5();
    }

    public void II_method_a34b13d5() {
        this.Ii_field_5a = false;
        this.iI_field_5a = false;
    }

    private void I_method_a65c94d5(ClientPlayerEntity clientPlayerEntity, boolean bl, boolean bl2) {
        iiIIiIiII_Class405 iiIIiIiII_Class4052 = RockstarClient.getInstance().I_method_58785402();
        if (iiIIiIiII_Class4052 == null) {
            return;
        }
        float f = iiIIiIiII_Class4052.I_method_3d166e03() ? clientPlayerEntity.getPitch() : iiIIiIiII_Class4052.II_method_f098f858().i_method_1461d9ef();
        double d = Math.toRadians(clientPlayerEntity.getYaw());
        double d2 = -Math.sin(d);
        double d3 = Math.cos(d);
        this.I_method_a6524215(clientPlayerEntity, d2, d3);
        this.I_method_8196bb55(clientPlayerEntity, bl, bl2, d2, d3);
        float f2 = this.I_field_9b38aba1.I_method_37c8332a(this.I_field_e4941ddc, f, 90.0f, this.I_field_9b4733a1, this.I_method_475484ff());
        iiIIiIiII_Class4052.I_method_1acbf705(new iiIIiIIii_Class404(clientPlayerEntity.getYaw(), MathHelper.clamp((float)f2, (float)-90.0f, (float)90.0f)), iiIIiIIIi_Class402.II_field_32e0c64c, 180.0f, 180.0f, 180.0f, iiIIiIiiI_Class407.i_field_32efc66c);
    }

    private void I_method_8196bb55(ClientPlayerEntity clientPlayerEntity, boolean bl, boolean bl2, double d, double d2) {
        Vec3d vec3d = clientPlayerEntity.getVelocity();
        this.I_field_e4941ddc.I_field_44 = 0.0;
        this.I_field_e4941ddc.i_field_44 = clientPlayerEntity.getY();
        this.I_field_e4941ddc.II_field_44 = Math.max(0.0, vec3d.x * d + vec3d.z * d2);
        this.I_field_e4941ddc.Ii_field_44 = vec3d.y;
        this.I_field_e4941ddc.I_field_5a = bl;
        this.I_field_e4941ddc.i_field_5a = bl2;
        this.I_field_e4941ddc.II_field_5a = this.Ii_field_5a;
        this.I_field_e4941ddc.I_field_49 = -1;
    }

    private int I_method_475484ff() {
        PlayerListEntry playerListEntry;
        int n = 0;
        if (I_field_3a9bda27.getNetworkHandler() != null && iiiiiIiI_Class251.I_field_3a9bda27.player != null && (playerListEntry = I_field_3a9bda27.getNetworkHandler().getPlayerListEntry(iiiiiIiI_Class251.I_field_3a9bda27.player.getUuid())) != null) {
            n = playerListEntry.getLatency();
        }
        return MathHelper.clamp((int)(1 + n / 50), (int)1, (int)6);
    }

    private void I_method_a6524215(ClientPlayerEntity clientPlayerEntity, double d, double d2) {
        this.I_field_9b4733a1.I_method_437a20ec();
        Vec3d vec3d = clientPlayerEntity.getPos();
        for (int i = 0; i < this.I_field_9b4733a1.I_method_437a20df(); ++i) {
            double d3 = (double)i * 2.0;
            this.I_field_9b4733a1.I_method_2bca5cd2(this.I_method_23f660b7(clientPlayerEntity, vec3d.x + d * d3, vec3d.y, vec3d.z + d2 * d3));
        }
    }

    private double I_method_23f660b7(ClientPlayerEntity clientPlayerEntity, double d, double d2, double d3) {
        double d4 = this.I_method_5ad61883(clientPlayerEntity, d, d2 + 2.5, d3, 32.0);
        if (!Double.isNaN(d4)) {
            return d4;
        }
        if (iiiiiIiI_Class251.I_field_3a9bda27.world.getBlockState(BlockPos.ofFloored((double)d, (double)(d2 + 2.5), (double)d3)).isAir()) {
            return -4096.0;
        }
        double d5 = this.I_method_5ad61883(clientPlayerEntity, d, d2 + 24.0, d3, 21.5);
        return Double.isNaN(d5) ? d2 + 24.0 : d5;
    }

    private double I_method_5ad61883(ClientPlayerEntity clientPlayerEntity, double d, double d2, double d3, double d4) {
        Vec3d vec3d = new Vec3d(d, d2, d3);
        BlockHitResult blockHitResult = iiiiiIiI_Class251.I_field_3a9bda27.world.raycast(new RaycastContext(vec3d, vec3d.add(0.0, -d4, 0.0), RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.ANY, (Entity)clientPlayerEntity));
        return blockHitResult.getType() == HitResult.Type.MISS ? Double.NaN : blockHitResult.getPos().y;
    }

    private boolean i_method_9520fbb9(ClientPlayerEntity clientPlayerEntity) {
        return iiiiiIiI_Class251.I_field_3a9bda27.currentScreen == null && !clientPlayerEntity.isSpectator() && !clientPlayerEntity.hasVehicle() && !clientPlayerEntity.isClimbing() && !clientPlayerEntity.isTouchingWater() && !clientPlayerEntity.isInLava() && !clientPlayerEntity.getAbilities().flying && !this.I_method_a77ea643(clientPlayerEntity).isEmpty();
    }

    private boolean II_method_6ced6bf0(ClientPlayerEntity clientPlayerEntity) {
        return !clientPlayerEntity.isOnGround() && !clientPlayerEntity.isTouchingWater() && !this.I_method_a77ea643(clientPlayerEntity).isEmpty();
    }

    private ItemStack I_method_a77ea643(ClientPlayerEntity clientPlayerEntity) {
        for (EquipmentSlot equipmentSlot : EquipmentSlot.VALUES) {
            ItemStack itemStack = clientPlayerEntity.getEquippedStack(equipmentSlot);
            if (!LivingEntity.canGlideWith((ItemStack)itemStack, (EquipmentSlot)equipmentSlot)) continue;
            return itemStack;
        }
        return ItemStack.EMPTY;
    }

    @Generated
    public boolean I_method_47548510() {
        return this.I_field_5a;
    }

    @Generated
    public boolean i_method_476310f0() {
        return this.i_field_5a;
    }

    @Generated
    public boolean II_method_a34b13d9() {
        return this.II_field_5a;
    }
}

