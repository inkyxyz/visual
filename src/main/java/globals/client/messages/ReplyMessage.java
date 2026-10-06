package globals.client.messages;

import globals.client.messages.Message;
import globals.shared.proto.Packets;
import lombok.Generated;
import pyrock.utility.render.Rect;

public class ReplyMessage
extends Message {
    private final long reply;
    private Rect quoteRect = Rect.EMPTY;

    public ReplyMessage(Packets.Nested1_e38dcab6 nested1_e38dcab6, String string, boolean bl, long l) {
        super(nested1_e38dcab6, string, bl);
        this.reply = l;
    }

    @Generated
    public long reply() {
        return this.reply;
    }

    @Generated
    public Rect quoteRect() {
        return this.quoteRect;
    }

    @Generated
    public ReplyMessage quoteRect(Rect rect) {
        this.quoteRect = rect;
        return this;
    }
}

