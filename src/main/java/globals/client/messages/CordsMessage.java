package globals.client.messages;

import globals.client.messages.Message;
import globals.shared.proto.Packets;
import lombok.Generated;
import net.minecraft.util.math.BlockPos;

public class CordsMessage
extends Message {
    private final BlockPos pos;

    public CordsMessage(Packets.Nested1_e38dcab6 nested1_e38dcab6, String string, boolean bl, BlockPos blockPos) {
        super(nested1_e38dcab6, string, bl);
        this.pos = blockPos;
    }

    @Generated
    public BlockPos pos() {
        return this.pos;
    }
}

