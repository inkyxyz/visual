package pyrock.events.window;

import lombok.Generated;
import rockstar.client.IiIIIIIi_Class66;

public class ChatTypeEvent
extends IiIIIIIi_Class66 {
    private final char text;
    private final int modifiers;

    @Generated
    public char getText() {
        return this.text;
    }

    @Generated
    public int getModifiers() {
        return this.modifiers;
    }

    @Generated
    public ChatTypeEvent(char c, int n) {
        this.text = c;
        this.modifiers = n;
    }
}

