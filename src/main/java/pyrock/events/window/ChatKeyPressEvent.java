package pyrock.events.window;

import lombok.Generated;
import rockstar.client.IiIIIIIi_Class66;

public class ChatKeyPressEvent
extends IiIIIIIi_Class66 {
    private final int keyCode;
    private final int scanCode;
    private final int modifiers;

    @Generated
    public ChatKeyPressEvent(int n, int n2, int n3) {
        this.keyCode = n;
        this.scanCode = n2;
        this.modifiers = n3;
    }

    @Generated
    public int getKeyCode() {
        return this.keyCode;
    }

    @Generated
    public int getScanCode() {
        return this.scanCode;
    }

    @Generated
    public int getModifiers() {
        return this.modifiers;
    }
}

