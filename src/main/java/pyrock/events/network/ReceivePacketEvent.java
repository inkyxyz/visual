package pyrock.events.network;

import lombok.Generated;
import net.minecraft.network.packet.Packet;
import pyrock.events.EventCancellable;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="receive_packet")
public class ReceivePacketEvent
extends EventCancellable {
    private final Packet<?> packet;

    @Generated
    public Packet<?> getPacket() {
        return this.packet;
    }

    @Generated
    public ReceivePacketEvent(Packet<?> packet) {
        this.packet = packet;
    }
}

