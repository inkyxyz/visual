package rockstar.client;

import net.minecraft.network.packet.c2s.play.ChatCommandSignedC2SPacket;
import pyrock.events.network.SendPacketEvent;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.RockstarClient;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiiiiiI_Class319;

public class iIiIIIIii_Class324
implements iIIiIIiIi_Class294 {
    private final IiIIIiII_Class69<SendPacketEvent> I_field_3d936f41 = sendPacketEvent -> {
        Object object = sendPacketEvent.getPacket();
        if (object instanceof ChatCommandSignedC2SPacket) {
            ChatCommandSignedC2SPacket chatCommandSignedC2SPacket = (ChatCommandSignedC2SPacket)object;
            if (iIiIIIIii_Class324.I_field_3a9bda27.player == null) {
                return;
            }
            object = chatCommandSignedC2SPacket.command();
            if (((String)object).startsWith("ah me")) {
                iIiIIIIii_Class324.I_field_3a9bda27.player.networkHandler.sendChatMessage("/ah " + iIiIIIIii_Class324.I_field_3a9bda27.player.getName().getString());
                sendPacketEvent.cancel();
            }
            if (((String)object).startsWith("ah sell ")) {
                String string = ((String)object).replaceFirst("ah sell ", "");
                String string2 = iIIiiiiiI_Class319.I_method_f25d3977(string);
                iIiIIIIii_Class324.I_field_3a9bda27.player.networkHandler.sendChatMessage("/ah sell " + Math.round(Float.parseFloat(string2)));
                sendPacketEvent.cancel();
            }
        }
    };

    public iIiIIIIii_Class324() {
        RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
    }
}

