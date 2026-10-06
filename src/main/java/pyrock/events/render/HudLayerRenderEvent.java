package pyrock.events.render;

import lombok.Generated;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.IiIIIIIi_Class66;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="hud_render")
public class HudLayerRenderEvent
extends IiIIIIIi_Class66 {
    private final CustomDrawContext context;
    private final float tickDelta;
    private final int count;
    private final boolean editing;

    @Generated
    public CustomDrawContext getContext() {
        return this.context;
    }

    @Generated
    public float getTickDelta() {
        return this.tickDelta;
    }

    @Generated
    public int getCount() {
        return this.count;
    }

    @Generated
    public boolean isEditing() {
        return this.editing;
    }

    @Generated
    public HudLayerRenderEvent(CustomDrawContext customDrawContext, float f, int n, boolean bl) {
        this.context = customDrawContext;
        this.tickDelta = f;
        this.count = n;
        this.editing = bl;
    }
}

