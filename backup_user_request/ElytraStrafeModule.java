package rockstar.client;

import net.minecraft.entity.Entity;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.util.Hand;
import pyrock.events.player.InputEvent;
import rockstar.client.BooleanSetting;
import rockstar.client.SliderSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.IiiiiiiII_Class253;
import rockstar.client.iIIiIiIiI_Class299;
import rockstar.client.iIIiiIiII_Class309;
import rockstar.client.iIIiiIiIi_Class310;
import rockstar.client.iIIiiiIii_Class316;
import rockstar.client.iIIiiiiII_Class317;
import rockstar.client.iiIIiIIIi_Class402;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.iiIIiIiiI_Class407;
import rockstar.client.Module;
import rockstar.client.iiIiIIiii_Class424;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Elytra Strafe", category=ModuleCategory.MOVEMENT)
public class ElytraStrafeModule
extends Module {
    private SliderSetting I_field_73178e8c;
    private SliderSetting i_field_73178e8c;
    private BooleanSetting I_field_ba20ca4c;
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
    private final IiIIIiII_Class69<InputEvent> I_field_3d936f41 = inputEvent -> {
        if (ElytraStrafeModule.I_field_3a9bda27.player == null || !ElytraStrafeModule.I_field_3a9bda27.player.isGliding()) {
            return;
        }
        float f2 = (float)Math.toDegrees(IiiiiiiII_Class253.I_method_2edb44cf(ElytraStrafeModule.I_field_3a9bda27.player.getYaw(), inputEvent.getForward(), inputEvent.getStrafe()));
        float f = ElytraStrafeModule.I_field_3a9bda27.options.sneakKey.isPressed() || ElytraStrafeModule.I_field_3a9bda27.options.jumpKey.isPressed()
            ? (inputEvent.getStrafe() + inputEvent.getForward() > 0.1f ? -45.0f : -90.0f)
            : 0.0f;
        if (ElytraStrafeModule.I_field_3a9bda27.options.sneakKey.isPressed()) {
            f *= -1.0f;
        }
        RockstarClient.getInstance().I_method_58785402().I_method_1acbf705(new iiIIiIIii_Class404(f2, f), iiIIiIIIi_Class402.i_field_32e0c64c, 180.0f, 180.0f, 180.0f, iiIIiIiiI_Class407.I_field_32efc66c);
    };

    public ElytraStrafeModule() {
        this.IiI_method_5708622c();
    }

    @Compile(obfuscation=4)
    private void IiI_method_5708622c() {
        this.I_field_73178e8c = new SliderSetting(this, "modules.settings.elytra_target.fireworkSlot").I_method_c8c9a7d7(1.0f).i_method_65e2aff7(9.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(7.0f).I_method_d41e7abf(" slot");
        this.i_field_73178e8c = new SliderSetting(this, "modules.settings.elytra_target.fireworkDelay").I_method_c8c9a7d7(0.1f).i_method_65e2aff7(2.0f).II_method_b0f56334(0.1f).Ii_method_4e0e6b54(1.0f).I_method_d41e7abf(" sec");
        this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.elytra_strafe.autoTakeoff").I_method_decd82b5();
    }

    @Override
    public void II_method_6642fd22() {
        if (ElytraStrafeModule.I_field_3a9bda27.player == null) {
            return;
        }
        if (this.I_field_ba20ca4c.i_method_9b12da03()) {
            boolean bl;
            boolean bl2 = bl = iIIiIiIiI_Class299.i_method_e5bad375().I_method_158af795() == Items.ELYTRA;
            if (!ElytraStrafeModule.I_field_3a9bda27.player.isGliding() && bl && !ElytraStrafeModule.I_field_3a9bda27.player.isOnGround() && !ElytraStrafeModule.I_field_3a9bda27.player.isInFluid()) {
                ElytraStrafeModule.I_field_3a9bda27.player.startGliding();
                ElytraStrafeModule.I_field_3a9bda27.player.networkHandler.sendPacket((Packet)new ClientCommandC2SPacket((Entity)ElytraStrafeModule.I_field_3a9bda27.player, ClientCommandC2SPacket.Mode.START_FALL_FLYING));
            } else if (ElytraStrafeModule.I_field_3a9bda27.player.isOnGround() && bl && !ElytraStrafeModule.I_field_3a9bda27.player.isInFluid() && !ElytraStrafeModule.I_field_3a9bda27.player.isGliding()) {
                ElytraStrafeModule.I_field_3a9bda27.player.jump();
            }
        }
        if (!ElytraStrafeModule.I_field_3a9bda27.player.isGliding()) {
            return;
        }
        if (this.I_field_991c1e8c.I_method_58432069((long)(this.i_field_73178e8c.Ii_method_a20abcd2() * 1000.0f)) && !ElytraStrafeModule.I_field_3a9bda27.player.isUsingItem()) {
            this.Iii_method_5716ee0c();
        }
    }

    private void Iii_method_5716ee0c() {
        iIIiiIiII_Class309<iIIiiiIii_Class316> iIIiiIiII_Class3092 = iIIiiIiIi_Class310.I_method_6a489695();
        iIIiiiIii_Class316 iIIiiiIii_Class3162 = iIIiiIiII_Class3092.I_method_5d34dd7d(Items.FIREWORK_ROCKET);
        if (iIIiiiIii_Class3162 != null) {
            ElytraStrafeModule.I_field_3a9bda27.player.networkHandler.sendPacket((Packet)new UpdateSelectedSlotC2SPacket(iIIiiiIii_Class3162.II_method_b9cf08f5()));
            ElytraStrafeModule.I_field_3a9bda27.interactionManager.sendSequencedPacket(ElytraStrafeModule.I_field_3a9bda27.world, n -> new PlayerInteractItemC2SPacket(Hand.MAIN_HAND, n, ElytraStrafeModule.I_field_3a9bda27.player.getYaw(), ElytraStrafeModule.I_field_3a9bda27.player.getPitch()));
            ElytraStrafeModule.I_field_3a9bda27.player.networkHandler.sendPacket((Packet)new UpdateSelectedSlotC2SPacket(ElytraStrafeModule.I_field_3a9bda27.player.getInventory().selectedSlot));
            this.I_field_991c1e8c.I_method_23e11e3f();
            return;
        }
        iIIiiIiII_Class309<iIIiiiiII_Class317> iIIiiIiII_Class3093 = iIIiiIiIi_Class310.i_method_7fde0a75();
        iIIiiiiII_Class317 iIIiiiiII_Class3172 = iIIiiIiII_Class3093.I_method_5d34dd7d(Items.FIREWORK_ROCKET);
        if (iIIiiiiII_Class3172 != null) {
            iIIiIiIiI_Class299.iI_method_c617e8c2(iIIiiiiII_Class3172.I_method_dfe89252(), (int)(this.I_field_73178e8c.Ii_method_a20abcd2() - 1.0f));
            this.I_field_991c1e8c.I_method_23e11e3f();
        }
    }
}
