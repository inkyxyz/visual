package rockstar.client;

import java.util.Optional;
import lombok.Generated;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.util.math.Vec3d;
import pyrock.events.game.PostAttackEvent;
import pyrock.events.game.WorldChangeEvent;
import pyrock.events.player.InputEvent;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.BooleanSetting;
import rockstar.client.ModeSetting;
import rockstar.client.SliderSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.IiiiiIiII_Class245;
import rockstar.client.IiiiiiIiI_Class251;
import rockstar.client.IiiiiiIii_Class252;
import rockstar.client.iIIiIiIiI_Class299;
import rockstar.client.iiIIiIIIi_Class402;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.iiIIiIiII_Class405;
import rockstar.client.iiIIiIiIi_Class406;
import rockstar.client.iiIIiIiiI_Class407;
import rockstar.client.Module;
import rockstar.client.AuraModule;
import rockstar.client.ElytraStrafeModule;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Elytra Target", category=ModuleCategory.COMBAT, III_method_a89e5834="modules.descriptions.elytra_target")
public class ElytraTargetModule
extends Module {
    private BooleanSetting I_field_ba20ca4c;
    private BooleanSetting i_field_ba20ca4c;
    private SliderSetting I_field_73178e8c;
    private SliderSetting i_field_73178e8c;
    private SliderSetting II_field_73178e8c;
    private ModeSetting I_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 I_field_500d0627;
    private ModeSetting.Nested1_42765c60 i_field_500d0627;
    private SliderSetting Ii_field_73178e8c;
    private BooleanSetting II_field_ba20ca4c;
    private SliderSetting iI_field_73178e8c;
    private LivingEntity I_field_966247a3;
    private Vec3d I_field_5bba0d50 = Vec3d.ZERO;
    private double I_field_44 = Double.NaN;
    private boolean I_field_5a = false;
    private Vec3d i_field_5bba0d50 = Vec3d.ZERO;
    private final IiIIIiII_Class69<InputEvent> I_field_3d936f41 = inputEvent -> {
        if (!this.II_field_ba20ca4c.i_method_9b12da03()) {
            this.I_field_5a = false;
            this.I_field_44 = Double.NaN;
            this.i_field_5bba0d50 = Vec3d.ZERO;
            return;
        }
        if (ElytraTargetModule.I_field_3a9bda27.player == null || !ElytraTargetModule.I_field_3a9bda27.player.isGliding()) {
            this.I_field_5a = false;
            this.I_field_44 = Double.NaN;
            this.i_field_5bba0d50 = Vec3d.ZERO;
            return;
        }
        if (this.I_field_966247a3 == null) {
            this.I_field_5a = false;
            this.I_field_44 = Double.NaN;
            this.i_field_5bba0d50 = Vec3d.ZERO;
            return;
        }
        boolean inRange = ElytraTargetModule.I_field_3a9bda27.player.distanceTo((Entity)this.I_field_966247a3) < this.iI_field_73178e8c.Ii_method_a20abcd2();
        if (!inRange) {
            this.I_field_5a = false;
            this.I_field_44 = Double.NaN;
            this.i_field_5bba0d50 = Vec3d.ZERO;
            return;
        }
        double d = ElytraTargetModule.I_field_3a9bda27.player.getY();
        if (ElytraTargetModule.I_field_3a9bda27.player.isOnGround()) {
            this.I_field_44 = Double.NaN;
            this.I_field_5a = false;
        } else if (!this.I_field_5a) {
            if (Double.isNaN(this.I_field_44)) {
                this.I_field_44 = d;
            } else if (d > this.I_field_44) {
                this.I_field_44 = d;
            } else if (d < this.I_field_44) {
                this.I_field_5a = true;
                this.i_field_5bba0d50 = ElytraTargetModule.I_field_3a9bda27.player.getPos();
                this.I_field_44 = d;
            }
        }
        if (this.I_field_5a) {
            inputEvent.setForward(0.0f);
            inputEvent.setStrafe(0.0f);
            ElytraTargetModule.I_field_3a9bda27.player.setVelocity(Vec3d.ZERO);
            ElytraTargetModule.I_field_3a9bda27.player.setPosition(this.i_field_5bba0d50);
        }
    };
    private final IiIIIiII_Class69<PostAttackEvent> i_field_3d936f41 = postAttackEvent -> {
        long l;
        LivingEntity livingEntity;
        if (!this.iII_method_28863dd0()) {
            return;
        }
        if (IiiiiIiII_Class245.I_method_cca9db15() != null) {
            IiiiiiIiI_Class251.I_method_eda61835(false);
            if (ElytraTargetModule.I_field_3a9bda27.player.isSprinting() && ElytraTargetModule.I_field_3a9bda27.player.input.hasForwardMovement() && ElytraTargetModule.I_field_3a9bda27.player.checkGliding()) {
                I_field_3a9bda27.getNetworkHandler().sendPacket((Packet)new ClientCommandC2SPacket((Entity)ElytraTargetModule.I_field_3a9bda27.player, ClientCommandC2SPacket.Mode.START_FALL_FLYING));
            }
        }
        if ((livingEntity = Optional.ofNullable(this.I_field_966247a3).orElseGet(this::i_method_a3a77e79)) != null) {
            IiiiiiIiI_Class251.I_method_6fc3f32b(IiiiiiIiI_Class251.i_method_411e84d8(livingEntity));
        }
        if (this.I_field_ba20ca4c.i_method_9b12da03() && this.I_method_49cf4f7c(l = this.I_method_adc91e01(livingEntity, livingEntity != null ? (double)ElytraTargetModule.I_field_3a9bda27.player.distanceTo((Entity)livingEntity) : Double.MAX_VALUE))) {
            IiiiiiIiI_Class251.I_method_eda5cd21(this.I_field_73178e8c.Ii_method_a20abcd2());
        }
    };
    private final IiIIIiII_Class69<WorldChangeEvent> II_field_3d936f41 = worldChangeEvent -> this.disable();

    public ElytraTargetModule() {
        this.IiI_method_f3ae1a0c();
    }

    @Compile(obfuscation=4)
    private void IiI_method_f3ae1a0c() {
        this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.elytra_target.auto_fireworks").I_method_decd82b5();
        this.i_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "modules.settings.elytra_target.smart_fireworks", () -> !this.I_field_ba20ca4c.i_method_9b12da03()).I_method_decd82b5();
        this.I_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.elytra_target.fireworkSlot", () -> !this.I_field_ba20ca4c.i_method_9b12da03()).I_method_c8c9a7d7(1.0f).i_method_65e2aff7(9.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(7.0f).I_method_d41e7abf(" slot");
        this.i_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.elytra_target.fireworkDelay", () -> !this.I_field_ba20ca4c.i_method_9b12da03() && this.i_field_ba20ca4c.i_method_9b12da03()).I_method_c8c9a7d7(0.25f).i_method_65e2aff7(3.0f).II_method_b0f56334(0.05f).Ii_method_4e0e6b54(0.45f).I_method_d41e7abf(" s");
        this.II_field_73178e8c = new SliderSetting(this, "modules.settings.elytra_target.engageRange").I_method_c8c9a7d7(6.0f).i_method_65e2aff7(50.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(24.0f).I_method_d41e7abf(" blocks");
        this.I_field_bbe33e6c = new ModeSetting((IIiiiIIiI_Class115)this, "modules.settings.elytra_target.prediction_mode", "motion");
        this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.elytra_target.prediction_mode.motion");
        this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.elytra_target.prediction_mode.server_pos").select();
        this.Ii_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.elytra_target.lead_strength", () -> !this.I_field_bbe33e6c.I_method_ce989e26(this.I_field_500d0627)).I_method_c8c9a7d7(0.0f).i_method_65e2aff7(5.0f).II_method_b0f56334(0.1f).Ii_method_4e0e6b54(3.0f).I_method_d41e7abf(" ticks");
        this.II_field_ba20ca4c = new BooleanSetting(this, "modules.settings.elytra_target.air_freeze");
        this.iI_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.elytra_target.freeze_distance", () -> !this.II_field_ba20ca4c.i_method_9b12da03()).I_method_c8c9a7d7(1.0f).i_method_65e2aff7(10.0f).II_method_b0f56334(0.1f).Ii_method_4e0e6b54(3.0f).I_method_d41e7abf(" blocks");
    }

    @Override
    public void II_method_6642fd22() {
        if (!RockstarClient.getInstance().getModuleManager().getModule(AuraModule.class).isEnabled()) {
            this.iII_method_28863dcc();
            return;
        }
        if (!this.iII_method_28863dd0()) {
            this.iII_method_28863dcc();
            return;
        }
        this.I_field_966247a3 = this.i_method_a3a77e79();
        this.i_method_fc6fb471(this.I_field_966247a3);
        if (this.I_field_ba20ca4c.i_method_9b12da03()) {
            this.I_method_dc50cc51(this.I_field_966247a3);
        }
        if (this.I_field_966247a3 != null) {
            this.Iii_method_f3bca5ec();
        }
    }

    private LivingEntity i_method_a3a77e79() {
        LivingEntity livingEntity = RockstarClient.getInstance().I_method_9a638462().I_method_4517f36c();
        return livingEntity instanceof PlayerEntity ? livingEntity : null;
    }

    private void I_method_dc50cc51(LivingEntity livingEntity) {
        PlayerEntity playerEntity;
        if (ElytraTargetModule.I_field_3a9bda27.player == null || !ElytraTargetModule.I_field_3a9bda27.player.isGliding()) {
            return;
        }
        if (RockstarClient.getInstance().getModuleManager().getModule(ElytraStrafeModule.class).isEnabled()) {
            return;
        }
        double d = livingEntity == null ? Double.MAX_VALUE : (double)ElytraTargetModule.I_field_3a9bda27.player.distanceTo((Entity)livingEntity);
        boolean bl2 = livingEntity instanceof PlayerEntity && this.I_method_aaa34425(playerEntity = (PlayerEntity)livingEntity);
        boolean bl3 = ElytraTargetModule.I_field_3a9bda27.player.getY() < (livingEntity != null ? livingEntity.getY() + 3.0 : ElytraTargetModule.I_field_3a9bda27.player.getY() + 5.0);
        long l = this.I_method_adc91e01(livingEntity, d);
        boolean shouldUseFirework = this.i_field_ba20ca4c.i_method_9b12da03() ? d > 15.0 || bl2 || this.Iii_method_f3bca5f0() || bl3 : d > 15.0 || bl2;
        if (shouldUseFirework && this.I_method_49cf4f7c(l)) {
            IiiiiiIiI_Class251.I_method_eda5cd21(this.I_field_73178e8c.Ii_method_a20abcd2());
        }
    }

    private long I_method_adc91e01(LivingEntity livingEntity, double d) {
        PlayerEntity playerEntity;
        long l = (long)(this.i_field_73178e8c.Ii_method_a20abcd2() * 1000.0f);
        if (!this.i_field_ba20ca4c.i_method_9b12da03()) {
            return l;
        }
        if (livingEntity instanceof PlayerEntity && this.I_method_aaa34425(playerEntity = (PlayerEntity)livingEntity)) {
            return (long)((float)l * 0.68f);
        }
        if (d < 8.0) {
            return (long)((float)l * 1.35f);
        }
        if (this.Iii_method_f3bca5f0()) {
            return (long)((float)l * 0.78f);
        }
        return l;
    }

    private boolean Iii_method_f3bca5f0() {
        return ElytraTargetModule.I_field_3a9bda27.player.getY() < (this.I_field_966247a3 != null ? this.I_field_966247a3.getY() + 2.0 : (double)ElytraTargetModule.I_field_3a9bda27.world.getSeaLevel());
    }

    private void i_method_fc6fb471(LivingEntity livingEntity) {
        if (livingEntity == null || !ElytraTargetModule.I_field_3a9bda27.player.isGliding()) {
            this.I_field_5bba0d50 = Vec3d.ZERO;
            return;
        }
        Vec3d vec3d = Nested1_cba630d3.I_method_ceeef1a8(livingEntity, this.I_field_bbe33e6c, this.I_field_500d0627, this.i_field_500d0627, this.Ii_field_73178e8c.Ii_method_a20abcd2());
        if (vec3d == null) {
            this.I_field_5bba0d50 = Vec3d.ZERO;
            return;
        }
        this.I_field_5bba0d50 = vec3d;
        iiIIiIiII_Class405 iiIIiIiII_Class4052 = RockstarClient.getInstance().I_method_58785402();
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = iiIIiIiIi_Class406.I_method_bc8095a1(this.I_field_5bba0d50);
        iiIIiIiII_Class4052.I_method_1acbf705(iiIIiIIii_Class4042, iiIIiIIIi_Class402.Ii_field_32e0c64c, 180.0f, 180.0f, 180.0f, iiIIiIiiI_Class407.II_field_32efc66c);
    }

    private void Iii_method_f3bca5ec() {
        if (iIIiIiIiI_Class299.i_method_e5bad375().I_method_158af795() == Items.ELYTRA && ElytraTargetModule.I_field_3a9bda27.player.isSprinting() && ElytraTargetModule.I_field_3a9bda27.player.input.hasForwardMovement() && ElytraTargetModule.I_field_3a9bda27.player.checkGliding()) {
            I_field_3a9bda27.getNetworkHandler().sendPacket((Packet)new ClientCommandC2SPacket((Entity)ElytraTargetModule.I_field_3a9bda27.player, ClientCommandC2SPacket.Mode.START_FALL_FLYING));
        }
    }

    private boolean I_method_aaa34425(PlayerEntity playerEntity) {
        double d;
        double d2 = ElytraTargetModule.I_field_3a9bda27.player.getVelocity().horizontalLengthSquared();
        return d2 + 1.0E-4 < (d = playerEntity.getVelocity().horizontalLengthSquared());
    }

    private boolean I_method_49cf4f7c(long l) {
        return IiiiiiIiI_Class251.I_method_eff3775().I_method_58432069(l);
    }

    private boolean iII_method_28863dd0() {
        return ElytraTargetModule.I_field_3a9bda27.player.getInventory().getArmorStack(2).getItem() == Items.ELYTRA;
    }

    private void iII_method_28863dcc() {
        this.I_field_966247a3 = null;
        this.I_field_5bba0d50 = Vec3d.ZERO;
    }

    @Override
    public void onDisable() {
        this.iII_method_28863dcc();
    }

    @Generated
    public BooleanSetting I_method_ddc7c342() {
        return this.I_field_ba20ca4c;
    }

    @Generated
    public BooleanSetting i_method_f35d3722() {
        return this.i_field_ba20ca4c;
    }

    @Generated
    public SliderSetting I_method_96be8782() {
        return this.I_field_73178e8c;
    }

    @Generated
    public SliderSetting i_method_ac53fb62() {
        return this.i_field_73178e8c;
    }

    @Generated
    public SliderSetting II_method_42bc1d8b() {
        return this.II_field_73178e8c;
    }

    @Generated
    public ModeSetting I_method_df8a3762() {
        return this.I_field_bbe33e6c;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 I_method_25d9999d() {
        return this.I_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 i_method_2be1957d() {
        return this.i_field_500d0627;
    }

    @Generated
    public SliderSetting Ii_method_5851916b() {
        return this.Ii_field_73178e8c;
    }

    @Generated
    public BooleanSetting II_method_89c5594b() {
        return this.II_field_ba20ca4c;
    }

    @Generated
    public SliderSetting iI_method_dfd525ab() {
        return this.iI_field_73178e8c;
    }

    @Generated
    public LivingEntity I_method_7953ea99() {
        return this.I_field_966247a3;
    }

    @Generated
    public double I_method_e15940ba() {
        return this.I_field_44;
    }

    @Generated
    public boolean IiI_method_f3ae1a10() {
        return this.I_field_5a;
    }

    @Generated
    public Vec3d I_method_f0af9b46() {
        return this.i_field_5bba0d50;
    }

    @Generated
    public IiIIIiII_Class69<InputEvent> I_method_914e7f8b() {
        return this.I_field_3d936f41;
    }

    @Generated
    public IiIIIiII_Class69<PostAttackEvent> i_method_bb4b0fab() {
        return this.i_field_3d936f41;
    }

    @Generated
    public IiIIIiII_Class69<WorldChangeEvent> II_method_f1b18462() {
        return this.II_field_3d936f41;
    }

    @Generated
    public Vec3d i_method_94a81f26() {
        return this.I_field_5bba0d50;
    }

    static class Nested1_cba630d3 {
        private Nested1_cba630d3() {
        }

        public static Vec3d I_method_ceeef1a8(LivingEntity livingEntity, ModeSetting iIiiiiiII_Class125, ModeSetting.Nested1_42765c60 nested1_42765c60, ModeSetting.Nested1_42765c60 nested1_42765c602, double d) {
            if (livingEntity == null) {
                return null;
            }
            if (iIiiiiiII_Class125.I_method_ce989e26(nested1_42765c60)) {
                if (livingEntity instanceof PlayerEntity) {
                    PlayerEntity playerEntity = (PlayerEntity)livingEntity;
                    Vec3d vec3d = playerEntity.getPos().subtract(new Vec3d(playerEntity.prevX, playerEntity.prevY, playerEntity.prevZ));
                    return playerEntity.getEyePos().add(vec3d.multiply(d));
                }
                return livingEntity.getEyePos();
            }
            if (iIiiiiiII_Class125.I_method_ce989e26(nested1_42765c602)) {
                return IiiiiiIii_Class252.I_method_34ed4d41((Entity)livingEntity);
            }
            return livingEntity.getPos();
        }
    }
}
