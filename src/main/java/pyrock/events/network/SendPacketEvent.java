package pyrock.events.network;

import lombok.Generated;
import net.minecraft.network.packet.Packet;
import pyrock.events.EventCancellable;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="send_packet")
public class SendPacketEvent
extends EventCancellable {
    private Packet<?> packet;

    @Generated
    public Packet<?> getPacket() {
        return this.packet;
    }

    @Generated
    public void setPacket(Packet<?> packet) {
        this.packet = packet;
    }

    @Generated
    public SendPacketEvent(Packet<?> packet) {
        this.packet = packet;
    }
}

