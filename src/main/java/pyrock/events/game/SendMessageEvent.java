package pyrock.events.game;

import lombok.Generated;
import pyrock.events.EventCancellable;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="send_message")
public class SendMessageEvent
extends EventCancellable {
    private String message;

    @Generated
    public void setMessage(String string) {
        this.message = string;
    }

    @Generated
    public String getMessage() {
        return this.message;
    }

    @Generated
    public SendMessageEvent(String string) {
        this.message = string;
    }
}

