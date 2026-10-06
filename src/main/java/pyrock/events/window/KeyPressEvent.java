package pyrock.events.window;

import lombok.Generated;
import rockstar.client.IiIIIIIi_Class66;

public class KeyPressEvent
extends IiIIIIIi_Class66 {
    private final int action;
    private final int key;

    @Generated
    public int getAction() {
        return this.action;
    }

    @Generated
    public int getKey() {
        return this.key;
    }

    @Generated
    public KeyPressEvent(int n, int n2) {
        this.action = n;
        this.key = n2;
    }
}

