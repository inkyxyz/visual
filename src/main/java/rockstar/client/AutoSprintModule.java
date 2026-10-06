package rockstar.client;

import lombok.Generated;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SplashPotionItem;
import net.minecraft.item.consume.UseAction;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.util.Hand;
import pyrock.events.network.SendPacketEvent;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.player.KeepSprintEvent;
import rockstar.client.BooleanSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.ModuleInfo;
import rockstar.client.iIIIiiIii_Class284;
import rockstar.client.iIIIiiiII_Class285;
import rockstar.client.iIiIiiIii_Class348;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Auto Sprint", category=ModuleCategory.UTILS, iI_method_476ab839=true)
public class AutoSprintModule
extends Module {
    private BooleanSetting I_field_ba20ca4c;
    private BooleanSetting i_field_ba20ca4c;
    private int I_field_49;
    private final IiIIIiII_Class69<KeepSprintEvent> I_field_3d936f41 = keepSprintEvent -> {
        if (this.I_field_ba20ca4c.i_method_9b12da03()) {
            keepSprintEvent.cancel();
        }
    };
    private final IiIIIiII_Class69<ClientPlayerTickEvent> i_field_3d936f41 = clientPlayerTickEvent -> {
        if (this.I_field_49 > 0) {
            AutoSprintModule.I_field_3a9bda27.options.sprintKey.setPressed(false);
            --this.I_field_49;
            return;
        }
        AutoSprintModule.I_field_3a9bda27.options.sprintKey.setPressed(true);
    };
    private final IiIIIiII_Class69<SendPacketEvent> II_field_3d936f41 = sendPacketEvent -> {
        if (AutoSprintModule.I_field_3a9bda27.player == null || !this.I_field_ba20ca4c.i_method_9b12da03()) {
            return;
        }
        if (sendPacketEvent.getPacket() instanceof UpdateSelectedSlotC2SPacket && this.IiI_method_5ae2c650()) {
            this.Iii_method_5af1522c();
            return;
        }
        Packet<?> packet = sendPacketEvent.getPacket();
        if (packet instanceof PlayerInteractItemC2SPacket) {
            PlayerInteractItemC2SPacket playerInteractItemC2SPacket = (PlayerInteractItemC2SPacket)packet;
            if (iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.i_field_ac164e6c) && this.I_method_db0111cb(playerInteractItemC2SPacket.getHand()).getItem() instanceof SplashPotionItem) {
                this.Iii_method_5af1522c();
            }
        }
    };

    public AutoSprintModule() {
        this.IiI_method_5ae2c64c();
    }

    @Compile(obfuscation=4)
    private void IiI_method_5ae2c64c() {
        this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.keepSprint");
        this.i_field_ba20ca4c = new BooleanSetting(this, "modules.settings.auto_sprint.ignore_hunger");
    }

    private boolean IiI_method_5ae2c650() {
        if (!AutoSprintModule.I_field_3a9bda27.player.isUsingItem()) {
            return false;
        }
        UseAction useAction = AutoSprintModule.I_field_3a9bda27.player.getActiveItem().getUseAction();
        return useAction == UseAction.EAT || useAction == UseAction.DRINK;
    }

    private ItemStack I_method_db0111cb(Hand hand) {
        return hand == Hand.OFF_HAND ? AutoSprintModule.I_field_3a9bda27.player.getOffHandStack() : AutoSprintModule.I_field_3a9bda27.player.getMainHandStack();
    }

    private void Iii_method_5af1522c() {
        this.I_field_49 = 2;
        AutoSprintModule.I_field_3a9bda27.options.sprintKey.setPressed(false);
        if (!AutoSprintModule.I_field_3a9bda27.player.isSprinting()) {
            return;
        }
        AutoSprintModule.I_field_3a9bda27.player.setSprinting(false);
        ((iIiIiiIii_Class348)AutoSprintModule.I_field_3a9bda27.player).rockstar$syncSprinting();
    }

    @Override
    public void onDisable() {
        this.I_field_49 = 0;
    }

    @Generated
    public BooleanSetting I_method_68cbaf82() {
        return this.i_field_ba20ca4c;
    }
}

