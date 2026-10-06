package pyrock.events.client;

import lombok.Generated;
import rockstar.client.IiIIIIIi_Class66;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="notification")
public class NotificationEvent
extends IiIIIIIi_Class66 {
    private final String style;
    private final String type;
    private final String title;
    private final String text;

    @Generated
    public String getStyle() {
        return this.style;
    }

    @Generated
    public String getType() {
        return this.type;
    }

    @Generated
    public String getTitle() {
        return this.title;
    }

    @Generated
    public String getText() {
        return this.text;
    }

    @Generated
    public NotificationEvent(String string, String string2, String string3, String string4) {
        this.style = string;
        this.type = string2;
        this.title = string3;
        this.text = string4;
    }
}

