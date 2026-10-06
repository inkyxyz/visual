package rockstar.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.slot.SlotActionType;
import pyrock.events.game.WorldChangeEvent;
import pyrock.events.network.ReceivePacketEvent;
import rockstar.client.ModeSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.ModuleInfo;
import rockstar.client.Module;
import rockstar.client.iiIiIIiii_Class424;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Auto Duels", category=ModuleCategory.OTHER, III_method_a89e5834="modules.descriptions.auto_duels")
public class AutoDuelsModule
extends Module {
    private ModeSetting I_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 I_field_500d0627;
    private ModeSetting.Nested1_42765c60 i_field_500d0627;
    private ModeSetting.Nested1_42765c60 II_field_500d0627;
    private ModeSetting i_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 Ii_field_500d0627;
    private ModeSetting.Nested1_42765c60 iI_field_500d0627;
    private ModeSetting.Nested1_42765c60 ii_field_500d0627;
    private ModeSetting.Nested1_42765c60 III_field_500d0627;
    private ModeSetting.Nested1_42765c60 IIi_field_500d0627;
    private ModeSetting.Nested1_42765c60 IiI_field_500d0627;
    private ModeSetting.Nested1_42765c60 Iii_field_500d0627;
    private ModeSetting.Nested1_42765c60 iII_field_500d0627;
    private ModeSetting.Nested1_42765c60 iIi_field_500d0627;
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
    private final List<String> I_field_7865b31 = new ArrayList<String>();
    private final IiIIIiII_Class69<ReceivePacketEvent> I_field_3d936f41 = receivePacketEvent -> {
        Object object = receivePacketEvent.getPacket();
        if (object instanceof GameMessageS2CPacket) {
            GameMessageS2CPacket gameMessageS2CPacket = (GameMessageS2CPacket)object;
            if (((String)(object = gameMessageS2CPacket.content().getString())).contains("\u043f\u0440\u0438\u043d\u044f\u043b") && !((String)object).contains("\u043d\u0435 \u043f\u0440\u0438\u043d\u044f\u043b") || ((String)object).contains("\u043a\u043e\u043c\u0430\u043d\u0434\u044b")) {
                this.I_field_7865b31.clear();
                this.toggle();
            }
            if (((String)object).contains("\u0411\u0430\u043b\u0430\u043d\u0441") || ((String)object).contains("\u043e\u0442\u043a\u043b\u044e\u0447\u0438\u043b \u0437\u0430\u043f\u0440\u043e\u0441\u044b")) {
                receivePacketEvent.cancel();
            }
        }
    };
    private final IiIIIiII_Class69<WorldChangeEvent> i_field_3d936f41 = worldChangeEvent -> this.disable();

    public AutoDuelsModule() {
        this.IiI_method_7984f6bf();
    }

    @Compile(obfuscation=4)
    private void IiI_method_7984f6bf() {
        this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.auto_duels.prefer");
        this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.auto_duels.prefer.soft");
        this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.auto_duels.prefer.ansoft");
        this.II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.auto_duels.prefer.random");
        this.i_field_bbe33e6c = new ModeSetting(this, "modules.settings.auto_duels.kit");
        this.Ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.auto_duels.kit.shield");
        this.iI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.auto_duels.kit.thorns3");
        this.ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.auto_duels.kit.bow");
        this.III_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.auto_duels.kit.totem");
        this.IIi_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.auto_duels.kit.nodebuff");
        this.IiI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.auto_duels.kit.balls");
        this.Iii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.auto_duels.kit.classic");
        this.iII_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.auto_duels.kit.cheats");
        this.iIi_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.auto_duels.kit.nether");
    }

    @Override
    @Compile(obfuscation=1)
    public void II_method_6642fd22() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (PlayerListEntry object : AutoDuelsModule.I_field_3a9bda27.player.networkHandler.getPlayerList()) {
            arrayList.add(object.getProfile().getName());
        }
        if (this.II_field_500d0627.isSelected()) {
            Collections.shuffle(arrayList);
        } else if (this.I_field_500d0627.isSelected()) {
            Collections.reverse(arrayList);
        }
        for (String string : arrayList) {
            if (!this.I_field_991c1e8c.I_method_58432069(750L) || this.I_field_7865b31.contains(string) || string.equals(AutoDuelsModule.I_field_3a9bda27.player.getNameForScoreboard())) continue;
            AutoDuelsModule.I_field_3a9bda27.player.networkHandler.sendChatCommand("duel " + string);
            this.I_field_7865b31.add(string);
            this.I_field_991c1e8c.I_method_23e11e3f();
        }
        if (AutoDuelsModule.I_field_3a9bda27.player.currentScreenHandler instanceof GenericContainerScreenHandler) {
            String string = AutoDuelsModule.I_field_3a9bda27.currentScreen.getTitle().getString();
            if (string.contains("\u0412\u044b\u0431\u043e\u0440 \u043d\u0430\u0431\u043e\u0440\u0430")) {
                AutoDuelsModule.I_field_3a9bda27.interactionManager.clickSlot(AutoDuelsModule.I_field_3a9bda27.player.currentScreenHandler.syncId, this.i_field_bbe33e6c.I_method_e1d4a248().indexOf(this.i_field_bbe33e6c.I_method_f2573c70()), 0, SlotActionType.PICKUP, (PlayerEntity)AutoDuelsModule.I_field_3a9bda27.player);
                AutoDuelsModule.I_field_3a9bda27.player.currentScreenHandler.onSlotClick(this.i_field_bbe33e6c.I_method_e1d4a248().indexOf(this.i_field_bbe33e6c.I_method_f2573c70()), 0, SlotActionType.PICKUP, (PlayerEntity)AutoDuelsModule.I_field_3a9bda27.player);
            } else if (string.contains("\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0430 \u043f\u043e\u0435\u0434\u0438\u043d\u043a\u0430")) {
                AutoDuelsModule.I_field_3a9bda27.interactionManager.clickSlot(AutoDuelsModule.I_field_3a9bda27.player.currentScreenHandler.syncId, 0, 0, SlotActionType.PICKUP, (PlayerEntity)AutoDuelsModule.I_field_3a9bda27.player);
                AutoDuelsModule.I_field_3a9bda27.player.currentScreenHandler.onSlotClick(0, 0, SlotActionType.PICKUP, (PlayerEntity)AutoDuelsModule.I_field_3a9bda27.player);
            }
        }
        super.II_method_6642fd22();
    }

    @Override
    public void onEnable() {
        this.I_field_991c1e8c.I_method_23e11e3f();
        super.onEnable();
    }
}

