package pyrock.events.window;

import lombok.Generated;
import rockstar.client.IiIIIIIi_Class66;

public class MouseEvent
extends IiIIIIIi_Class66 {
    private final int button;
    private final int action;

    @Generated
    public int getButton() {
        return this.button;
    }

    @Generated
    public int getAction() {
        return this.action;
    }

    @Generated
    public MouseEvent(int n, int n2) {
        this.button = n;
        this.action = n2;
    }
}

