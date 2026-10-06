package rockstar.client;

import globals.client.Information;
import globals.shared.proto.Packets;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import pyrock.events.network.ReceivePacketEvent;
import rockstar.client.MultiSelectSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.iIIIiiiII_Class285;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Auto Accept", category=ModuleCategory.OTHER, III_method_a89e5834="modules.descriptions.auto_accept")
public class AutoAcceptModule
extends Module {
    private MultiSelectSetting I_field_bbe3ba6c;
    private MultiSelectSetting.Nested1_42856060 I_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 i_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 II_field_51de8227;
    private final IiIIIiII_Class69<ReceivePacketEvent> I_field_3d936f41 = receivePacketEvent -> {
        Packet<?> packet = receivePacketEvent.getPacket();
        if (packet instanceof GameMessageS2CPacket) {
            GameMessageS2CPacket gameMessageS2CPacket = (GameMessageS2CPacket)packet;
            if (AutoAcceptModule.I_field_3a9bda27.player != null && (gameMessageS2CPacket.content().getString().contains("\u0442\u0435\u043b\u0435\u043f\u043e\u0440\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c\u0441\u044f") || gameMessageS2CPacket.content().getString().contains("\u0437\u0430\u043f\u0440\u0430\u0448\u0438\u0432\u0430\u0435\u0442 \u0442\u0435\u043b\u0435\u043f\u043e\u0440\u0442")) && !iIIIiiiII_Class285.I_field_5a && this.I_method_5c80de4d(gameMessageS2CPacket.content().getString())) {
                AutoAcceptModule.I_field_3a9bda27.player.networkHandler.sendChatCommand("tpaccept");
            }
        }
    };

    public AutoAcceptModule() {
        this.IiI_method_ec7c6ebf();
    }

    @Compile(obfuscation=4)
    private void IiI_method_ec7c6ebf() {
        this.I_field_bbe3ba6c = new MultiSelectSetting(this, "modules.settings.auto_accept.mode");
        this.I_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.auto_accept.mode.all");
        this.i_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "rockUsers", this.I_field_51de8227::isSelected);
        this.II_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.auto_accept.mode.friends_only", this.I_field_51de8227::isSelected).select();
    }

    private boolean I_method_5c80de4d(String string) {
        if (this.I_field_51de8227.isSelected()) {
            return true;
        }
        String string2 = string.replaceAll("\u00a7[0-9a-fklmnor]", "").trim();
        String string3 = this.i_method_2c893997(string2);
        if (string3 == null) {
            return false;
        }
        if (this.i_field_51de8227.isSelected()) {
            for (Packets.Nested1_1da0dac9 nested1_1da0dac9 : Information.getVisiblePlayers()) {
                if (nested1_1da0dac9.gameInfo() == null || nested1_1da0dac9.gameInfo().nickname() == null || !nested1_1da0dac9.gameInfo().nickname().equals(string3)) continue;
                return true;
            }
        }
        if (this.II_field_51de8227.isSelected()) {
            return RockstarClient.getInstance().I_method_7a5acaeb().I_method_19c9437a(string3);
        }
        return false;
    }

    private String i_method_2c893997(String string) {
        String[] stringArray;
        if (string.contains("\u043f\u0440\u043e\u0441\u0438\u0442 \u0442\u0435\u043b\u0435\u043f\u043e\u0440\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c\u0441\u044f") && (stringArray = string.split(" ")).length > 0) {
            return stringArray[0];
        }
        if (string.contains("\u0445\u043e\u0447\u0435\u0442 \u0442\u0435\u043b\u0435\u043f\u043e\u0440\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c\u0441\u044f \u043a") && (stringArray = string.split(" ")).length > 1) {
            return stringArray[1];
        }
        if (string.contains("\u0a77 \u043f\u0440\u043e\u0441\u0438\u0442 \u0442\u0435\u043b\u0435\u043f\u043e\u0440\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c\u0441\u044f") && (stringArray = string.split(" ")).length >= 2) {
            return stringArray[1];
        }
        if (string.contains("\u279d \u041d\u0438\u043a:") && (stringArray = string.split(":")).length >= 2) {
            return stringArray[1].trim();
        }
        if (string.contains("\u0442\u0435\u043b\u0435\u043f\u043e\u0440\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c\u0441\u044f")) {
            stringArray = string.split(" ");
            for (int i = 0; i < stringArray.length - 1; ++i) {
                if (!stringArray[i].equals("\u043f\u0440\u043e\u0441\u0438\u0442") && !stringArray[i].equals("\u0437\u0430\u043f\u0440\u0430\u0448\u0438\u0432\u0430\u0435\u0442")) continue;
                return stringArray[i - 1];
            }
        }
        return null;
    }
}

