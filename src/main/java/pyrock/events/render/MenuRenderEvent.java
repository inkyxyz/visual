package pyrock.events.render;

import lombok.Generated;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.IiIIIIIi_Class66;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="menu_render")
public class MenuRenderEvent
extends IiIIIIIi_Class66 {
    private final CustomDrawContext context;
    private final float tickDelta;
    private final String menu;
    private final float progress;
    private final boolean capture;

    @Generated
    public CustomDrawContext getContext() {
        return this.context;
    }

    @Generated
    public float getTickDelta() {
        return this.tickDelta;
    }

    @Generated
    public String getMenu() {
        return this.menu;
    }

    @Generated
    public float getProgress() {
        return this.progress;
    }

    @Generated
    public boolean isCapture() {
        return this.capture;
    }

    @Generated
    public MenuRenderEvent(CustomDrawContext customDrawContext, float f, String string, float f2, boolean bl) {
        this.context = customDrawContext;
        this.tickDelta = f;
        this.menu = string;
        this.progress = f2;
        this.capture = bl;
    }
}

