package globals.client.messages;

import globals.client.messages.Message;
import globals.shared.proto.Packets;
import lombok.Generated;
import pyrock.utility.render.Rect;

public class ShareMessage
extends Message {
    public static final String KIND_CONFIG = "config";
    public static final String KIND_SWING = "swing";
    public static final String KIND_INVBUILDER = "invbuilder";
    private final long shareId;
    private final String shareKind;
    private Rect actionRect = Rect.EMPTY;

    public ShareMessage(Packets.Nested1_e38dcab6 nested1_e38dcab6, String string, boolean bl, long l, String string2) {
        super(nested1_e38dcab6, string, bl);
        this.shareId = l;
        this.shareKind = string2;
    }

    public boolean swing() {
        return KIND_SWING.equals(this.shareKind);
    }

    public String titleKey() {
        return ShareMessage.titleKey(this.shareKind);
    }

    public String icon() {
        return ShareMessage.icon(this.shareKind);
    }

    public static String titleKey(String string) {
        return switch (string == null ? "" : string) {
            case KIND_SWING -> "rocknet.share.swing";
            case KIND_INVBUILDER -> "rocknet.share.invbuilder";
            default -> "rocknet.share.config";
        };
    }

    public static String icon(String string) {
        return switch (string == null ? "" : string) {
            case KIND_SWING -> "hud/target";
            case KIND_INVBUILDER -> "menu/builder";
            default -> "setting";
        };
    }

    @Generated
    public long shareId() {
        return this.shareId;
    }

    @Generated
    public String shareKind() {
        return this.shareKind;
    }

    @Generated
    public Rect actionRect() {
        return this.actionRect;
    }

    @Generated
    public ShareMessage actionRect(Rect rect) {
        this.actionRect = rect;
        return this;
    }
}

