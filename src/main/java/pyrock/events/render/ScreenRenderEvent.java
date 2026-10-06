package pyrock.events.render;

import lombok.Generated;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.IiIIIIIi_Class66;

public class ScreenRenderEvent
extends IiIIIIIi_Class66 {
    private final CustomDrawContext context;
    private final float tickDelta;

    @Generated
    public CustomDrawContext getContext() {
        return this.context;
    }

    @Generated
    public float getTickDelta() {
        return this.tickDelta;
    }

    @Generated
    public ScreenRenderEvent(CustomDrawContext customDrawContext, float f) {
        this.context = customDrawContext;
        this.tickDelta = f;
    }
}

