package pyrock.events.window;

import lombok.Generated;
import rockstar.client.IiIIIIIi_Class66;
import rockstar.client.IiIIIIiI_Class67;
import rockstar.client.iIIiIIiIi_Class294;

@IiIIIIiI_Class67(I_method_80b3cd54="mouse_move")
public class MouseMoveEvent
extends IiIIIIIi_Class66
implements iIIiIIiIi_Class294 {
    private final float x;
    private final float y;
    private final float dx;
    private final float dy;

    public MouseMoveEvent(double d, double d2, double d3, double d4) {
        double d5 = I_field_3a9bda27.getWindow().getScaleFactor();
        this.x = (float)(d / d5);
        this.y = (float)(d2 / d5);
        this.dx = (float)(d3 / d5);
        this.dy = (float)(d4 / d5);
    }

    public boolean isScreenOpen() {
        return MouseMoveEvent.I_field_3a9bda27.currentScreen != null;
    }

    @Generated
    public float getX() {
        return this.x;
    }

    @Generated
    public float getY() {
        return this.y;
    }

    @Generated
    public float getDx() {
        return this.dx;
    }

    @Generated
    public float getDy() {
        return this.dy;
    }
}

