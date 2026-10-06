package pyrock.events.window;

import lombok.Generated;
import rockstar.client.IiIIIIIi_Class66;

public class ChatClickEvent
extends IiIIIIIi_Class66 {
    private final float x;
    private final float y;
    private final int button;

    @Generated
    public float getX() {
        return this.x;
    }

    @Generated
    public float getY() {
        return this.y;
    }

    @Generated
    public int getButton() {
        return this.button;
    }

    @Generated
    public ChatClickEvent(float f, float f2, int n) {
        this.x = f;
        this.y = f2;
        this.button = n;
    }
}

