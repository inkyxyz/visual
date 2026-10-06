package moscow.rockstar.mixin.minecraft.network;

import net.minecraft.network.ClientConnection;
import net.minecraft.network.listener.PacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.CloseScreenS2CPacket;
import net.minecraft.network.packet.s2c.play.TeamS2CPacket;
import net.minecraft.scoreboard.Team;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pyrock.events.network.ReceivePacketEvent;
import pyrock.events.network.SendPacketEvent;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiiIIiI_Class243;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.ii_Class4;

@Mixin(value={ClientConnection.class})
public class ClientConnectionMixin
implements iIIiIIiIi_Class294 {
    @Unique
    private static boolean stackOverflowFix;

    @Inject(method={"handlePacket"}, at={@At(value="HEAD")}, cancellable=true)
    private static <T extends PacketListener> void triggerReceivePacketEvent(Packet<T> packet, PacketListener packetListener, CallbackInfo callbackInfo) {
        if (packet instanceof CloseScreenS2CPacket && ClientConnectionMixin.I_field_3a9bda27.currentScreen instanceof ii_Class4) {
            callbackInfo.cancel();
            return;
        }
        ReceivePacketEvent receivePacketEvent = new ReceivePacketEvent(packet);
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(receivePacketEvent);
        if (receivePacketEvent.isCancelled()) {
            callbackInfo.cancel();
        }
        if (packet instanceof TeamS2CPacket) {
            TeamS2CPacket teamS2CPacket = (TeamS2CPacket)packet;
            try {
                if (teamS2CPacket.getTeamName() != null && teamS2CPacket.getTeamName().startsWith("collideRule_") && ClientConnectionMixin.I_field_3a9bda27.player != null && ClientConnectionMixin.I_field_3a9bda27.player.getScoreboard() != null) {
                    Team team = ClientConnectionMixin.I_field_3a9bda27.player.getScoreboard().getTeam(teamS2CPacket.getTeamName());
                    if (teamS2CPacket.getPlayerNames() != null && !teamS2CPacket.getPlayerNames().isEmpty()) {
                        if (team == null) {
                            callbackInfo.cancel();
                            return;
                        }
                        for (String string : teamS2CPacket.getPlayerNames()) {
                            if (team.getPlayerList().contains(string)) continue;
                            callbackInfo.cancel();
                            return;
                        }
                    }
                }
            }
            catch (Exception exception) {
                System.err.println("NetworkFix: \u041e\u0442\u043c\u0435\u043d\u0435\u043d \u043f\u0440\u043e\u0431\u043b\u0435\u043c\u043d\u044b\u0439 TeamS2CPacket: " + exception.getMessage());
                callbackInfo.cancel();
            }
        }
    }

    @Inject(method={"send(Lnet/minecraft/network/packet/Packet;)V"}, at={@At(value="HEAD")}, cancellable=true)
    public void triggerSendPacketEvent(Packet<?> packet, CallbackInfo callbackInfo) {
        Packet<?> packet2;
        SendPacketEvent sendPacketEvent = new SendPacketEvent(packet);
        if (stackOverflowFix) {
            return;
        }
        IiiiiIIiI_Class243.I_method_c378d368(packet);
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(sendPacketEvent);
        if (sendPacketEvent.isCancelled()) {
            callbackInfo.cancel();
        }
        if ((packet2 = sendPacketEvent.getPacket()) != packet) {
            callbackInfo.cancel();
            stackOverflowFix = true;
            I_field_3a9bda27.getNetworkHandler().sendPacket(packet2);
            stackOverflowFix = false;
        }
    }
}

