package pyrock.events.window;

import lombok.Generated;
import pyrock.events.EventCancellable;
import rockstar.client.IiIIIIiI_Class67;
import rockstar.client.iIIiIIiIi_Class294;

@IiIIIIiI_Class67(I_method_80b3cd54="scroll")
public class ScrollEvent
extends EventCancellable
implements iIIiIIiIi_Class294 {
    private final double horizontal;
    private final double vertical;
    private final float x;
    private final float y;

    public ScrollEvent(double d, double d2) {
        this.horizontal = d;
        this.vertical = d2;
        double d3 = I_field_3a9bda27.getWindow().getScaleFactor();
        this.x = (float)(ScrollEvent.I_field_3a9bda27.mouse.getX() / d3);
        this.y = (float)(ScrollEvent.I_field_3a9bda27.mouse.getY() / d3);
    }

    public boolean isUp() {
        return this.vertical > 0.0;
    }

    public boolean isDown() {
        return this.vertical < 0.0;
    }

    public boolean isScreenOpen() {
        return ScrollEvent.I_field_3a9bda27.currentScreen != null;
    }

    @Generated
    public double getHorizontal() {
        return this.horizontal;
    }

    @Generated
    public double getVertical() {
        return this.vertical;
    }

    @Generated
    public float getX() {
        return this.x;
    }

    @Generated
    public float getY() {
        return this.y;
    }
}

