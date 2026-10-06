package pyrock.events.render;

import lombok.Generated;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.Entity;
import rockstar.client.IiIIIIIi_Class66;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="camera_update")
public class CameraUpdateEvent
extends IiIIIIIi_Class66 {
    private final Camera camera;
    private final Entity focusedEntity;
    private final boolean thirdPerson;
    private final boolean inverseView;
    private final float tickDelta;

    @Generated
    public Camera getCamera() {
        return this.camera;
    }

    @Generated
    public Entity getFocusedEntity() {
        return this.focusedEntity;
    }

    @Generated
    public boolean isThirdPerson() {
        return this.thirdPerson;
    }

    @Generated
    public boolean isInverseView() {
        return this.inverseView;
    }

    @Generated
    public float getTickDelta() {
        return this.tickDelta;
    }

    @Generated
    public CameraUpdateEvent(Camera camera, Entity entity, boolean bl, boolean bl2, float f) {
        this.camera = camera;
        this.focusedEntity = entity;
        this.thirdPerson = bl;
        this.inverseView = bl2;
        this.tickDelta = f;
    }
}

