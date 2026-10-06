package rockstar.client;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.consume.UseAction;
import net.minecraft.util.Hand;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.BooleanSetting;
import rockstar.client.ModeSetting;
import rockstar.client.MultiSelectSetting;
import rockstar.client.IiIIIiIiI_Class139;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.IiiiiIiII_Class245;
import rockstar.client.iIIIIIiii_Class264;
import rockstar.client.iIIIIiIII_Class265;
import rockstar.client.iIIIiIiiI_Class279;
import rockstar.client.iIIIiiIii_Class284;
import rockstar.client.iIIIiiiII_Class285;
import rockstar.client.iIIiiiiiI_Class319;
import rockstar.client.Module;
import rockstar.client.AntiBotModule;
import rockstar.client.AuraModule;
import rockstar.client.iiIiIIiii_Class424;
import rockstar.client.CriticalsModule;
import rockstar.client.KnockbackTweaksModule;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Trigger Bot", category=ModuleCategory.COMBAT, III_method_a89e5834="modules.descriptions.trigger_bot")
public class TriggerBotModule
extends Module {
    private BooleanSetting I_field_ba20ca4c;
    private BooleanSetting i_field_ba20ca4c;
    private BooleanSetting II_field_ba20ca4c;
    private MultiSelectSetting I_field_bbe3ba6c;
    private MultiSelectSetting.Nested1_42856060 I_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 i_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 II_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 Ii_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 iI_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 ii_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 III_field_51de8227;
    private ModeSetting I_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 I_field_500d0627;
    private ModeSetting.Nested1_42765c60 i_field_500d0627;
    private ModeSetting.Nested1_42765c60 II_field_500d0627;
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();

    public TriggerBotModule() {
        this.IiI_method_80b6a20c();
    }

    @Compile(obfuscation=4)
    private void IiI_method_80b6a20c() {
        this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.aura.onlyCrits").I_method_decd82b5();
        this.i_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "modules.settings.aura.smart_criticals", () -> !this.I_field_ba20ca4c.i_method_9b12da03());
        this.II_field_ba20ca4c = new BooleanSetting(this, "modules.settings.aura.useHit");
        this.I_field_bbe3ba6c = new MultiSelectSetting(this, "modules.settings.aura.targets");
        this.I_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.aura.targets.players").select();
        this.i_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.aura.targets.animals").select();
        this.II_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.aura.targets.mobs").select();
        this.Ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.aura.targets.invisibles").select();
        this.iI_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.aura.targets.nakedPlayers").select();
        this.ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.aura.targets.rockUsers");
        this.III_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.aura.targets.friends");
        this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.aura.sprint_reset");
        this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.aura.sprint_reset.smart").select();
        this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.aura.sprint_reset.normal");
        this.II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.aura.sprint_reset.packet");
    }

    @Override
    @Compile(obfuscation=1)
    public void II_method_6642fd22() {
        if (TriggerBotModule.I_field_3a9bda27.player == null || TriggerBotModule.I_field_3a9bda27.interactionManager == null) {
            return;
        }
        if (this.Iii_method_80c52df0()) {
            super.II_method_6642fd22();
            return;
        }
        Entity entity = TriggerBotModule.I_field_3a9bda27.targetedEntity;
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            if (this.I_method_367273e2().I_method_b72bafcb((Entity)livingEntity)) {
                if (iIIIIiIII_Class265.I_method_6fefbe43()) {
                    super.II_method_6642fd22();
                    return;
                }
                if (this.iII_method_b58ec5d0() && iIIIIIiii_Class264.i_method_aa7c7d78((PlayerEntity)TriggerBotModule.I_field_3a9bda27.player)) {
                    iIIIIiIII_Class265.I_method_8d3241d4((PlayerEntity)TriggerBotModule.I_field_3a9bda27.player);
                    super.II_method_6642fd22();
                    return;
                }
                if (this.I_method_f0794455(livingEntity)) {
                    if (this.II_method_6cb7786c(livingEntity)) {
                        super.II_method_6642fd22();
                        return;
                    }
                    this.I_method_f0794451(livingEntity);
                }
            }
        }
        super.II_method_6642fd22();
    }

    @Compile(obfuscation=1)
    private boolean I_method_f0794455(LivingEntity livingEntity) {
        if (TriggerBotModule.I_field_3a9bda27.player == null) {
            return false;
        }
        if (this.Iii_method_80c52df0()) {
            return false;
        }
        if (AntiBotModule.I_method_fe179c75(livingEntity)) {
            return false;
        }
        if (livingEntity == TriggerBotModule.I_field_3a9bda27.player || livingEntity.isRemoved() || !livingEntity.isAlive()) {
            return false;
        }
        if (!this.I_method_367273e2().I_method_b72bafcb((Entity)livingEntity)) {
            return false;
        }
        if (TriggerBotModule.I_field_3a9bda27.player.getAttackCooldownProgress(0.0f) < 0.8f || !this.I_field_991c1e8c.I_method_58432069(500L)) {
            return false;
        }
        CriticalsModule iiIiiIiI_Class2192 = RockstarClient.getInstance().getModuleManager().getModule(CriticalsModule.class);
        if (iiIiiIiI_Class2192.iII_method_2c60a1f0() && !iiIiiIiI_Class2192.IiI_method_f7887e30()) {
            return false;
        }
        return !this.iII_method_b58ec5d0() || !this.i_method_10982c75(livingEntity) || IiiiiIiII_Class245.I_method_cd07807a(livingEntity, true);
    }

    private boolean Iii_method_80c52df0() {
        if (!this.II_field_ba20ca4c.i_method_9b12da03() || TriggerBotModule.I_field_3a9bda27.player == null || !TriggerBotModule.I_field_3a9bda27.player.isUsingItem()) {
            return false;
        }
        return TriggerBotModule.I_field_3a9bda27.player.getActiveItem().getItem().getUseAction(TriggerBotModule.I_field_3a9bda27.player.getActiveItem()) == UseAction.EAT;
    }

    private IiIIIiIiI_Class139 I_method_367273e2() {
        return new IiIIIiIiI_Class139.Nested1_a87537e0().I_method_1f3a928b(this.I_field_51de8227.isSelected()).i_method_da3212ab(this.i_field_51de8227.isSelected()).II_method_9a5032be(this.II_field_51de8227.isSelected()).iI_method_3e48b69e(this.Ii_field_51de8227.isSelected()).ii_method_f94036be(this.iI_field_51de8227.isSelected()).III_method_81ee98eb(this.III_field_51de8227.isSelected()).Ii_method_5547b2de(this.ii_field_51de8227.isSelected()).IiI_method_25e71ccb(false).I_method_7ebd8d70();
    }

    private boolean i_method_10982c75(LivingEntity livingEntity) {
        float f = RockstarClient.getInstance().getModuleManager().getModule(AuraModule.class).I_method_921cfc81(livingEntity);
        return f <= livingEntity.getHealth();
    }

    private void I_method_f0794451(LivingEntity livingEntity) {
        TriggerBotModule.I_field_3a9bda27.interactionManager.attackEntity((PlayerEntity)TriggerBotModule.I_field_3a9bda27.player, (Entity)livingEntity);
        TriggerBotModule.I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
        this.I_field_991c1e8c.I_method_23e11e3f();
    }

    private boolean iII_method_b58ec5d0() {
        if (this.i_field_ba20ca4c.i_method_9b12da03()) {
            return TriggerBotModule.I_field_3a9bda27.options != null && TriggerBotModule.I_field_3a9bda27.options.jumpKey.isPressed() || !TriggerBotModule.I_field_3a9bda27.player.isOnGround();
        }
        return this.I_field_ba20ca4c.i_method_9b12da03();
    }

    private boolean II_method_6cb7786c(LivingEntity livingEntity) {
        boolean bl = this.I_field_bbe33e6c.I_method_ce989e26(this.i_field_500d0627);
        boolean bl2 = this.I_field_bbe33e6c.I_method_ce989e26(this.II_field_500d0627);
        if (RockstarClient.getInstance().getModuleManager().getModule(KnockbackTweaksModule.class).isEnabled()) {
            return false;
        }
        if (!bl && !bl2 || TriggerBotModule.I_field_3a9bda27.player == null) {
            return false;
        }
        if (iIIIIiIII_Class265.I_method_6fefbe43() || iIIIIiIII_Class265.I_method_eacbd82b((Entity)TriggerBotModule.I_field_3a9bda27.player)) {
            return true;
        }
        if (!TriggerBotModule.I_field_3a9bda27.player.isSprinting()) {
            iIIIIiIII_Class265.i_method_a5c35847((Entity)TriggerBotModule.I_field_3a9bda27.player);
            return false;
        }
        iIIIIiIII_Class265.I_method_e89e02c2((PlayerEntity)TriggerBotModule.I_field_3a9bda27.player, () -> this.i_method_10982c71(livingEntity), bl2);
        return true;
    }

    private void i_method_10982c71(LivingEntity livingEntity) {
        if (!this.isEnabled() || TriggerBotModule.I_field_3a9bda27.player == null || TriggerBotModule.I_field_3a9bda27.interactionManager == null || livingEntity == null || livingEntity.isRemoved() || !livingEntity.isAlive()) {
            return;
        }
        if (this.I_method_f0794455(livingEntity)) {
            this.I_method_f0794451(livingEntity);
        }
    }

    public boolean IiI_method_80b6a210() {
        boolean bl;
        LivingEntity livingEntity;
        Object object;
        block8: {
            block7: {
                if (!this.I_field_bbe33e6c.I_method_ce989e26(this.I_field_500d0627)) {
                    return false;
                }
                if (RockstarClient.getInstance().getModuleManager().getModule(KnockbackTweaksModule.class).isEnabled()) {
                    return false;
                }
                object = TriggerBotModule.I_field_3a9bda27.targetedEntity;
                if (!(object instanceof LivingEntity)) break block7;
                livingEntity = (LivingEntity)object;
                if (TriggerBotModule.I_field_3a9bda27.player != null) break block8;
            }
            return false;
        }
        if (!this.I_method_367273e2().I_method_b72bafcb((Entity)livingEntity)) {
            return false;
        }
        if (TriggerBotModule.I_field_3a9bda27.player.isSubmergedInWater()) {
            return false;
        }
        object = RockstarClient.getInstance().getModuleManager().getModule(CriticalsModule.class);
        bl = ((CriticalsModule)object).iII_method_2c60a1f0()
            && (
                ((CriticalsModule)object).Iii_method_f7970a10() && this.I_field_991c1e8c.I_method_58432069(500L)
                    || TriggerBotModule.I_field_3a9bda27.player.isOnGround()
                    || !TriggerBotModule.I_field_3a9bda27.player.isOnGround()
                        && iIIIiIiiI_Class279.I_method_5a6fa1f8(TriggerBotModule.I_field_3a9bda27.player)
                            .I_method_9e608586(
                                IiiiiIiII_Class245.I_method_71f7f60e(livingEntity),
                                iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c)
                                        || iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.Iii_field_ac164e6c)
                                        || iIIIiiiII_Class285.Ii_method_b349c526()
                                    ? iIIiiiiiI_Class319.I_field_ec5bca73.nextInt(3)
                                    : 1
                            )
            );
        return this.iII_method_b58ec5d0() && this.i_method_10982c75(livingEntity) && (bl || IiiiiIiII_Class245.I_method_cd07807a(livingEntity, true) || !this.I_field_991c1e8c.I_method_58432069(iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.i_field_ac164e6c) || iIIIiiiII_Class285.Ii_method_b349c526() ? (long)iIIiiiiiI_Class319.iI_method_330da892(50.0f, 150.0f) : 50L));
    }

    @Override
    public void onEnable() {
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
        if (TriggerBotModule.I_field_3a9bda27.player != null) {
            iIIIIiIII_Class265.i_method_a5c35847((Entity)TriggerBotModule.I_field_3a9bda27.player);
        }
    }
}
