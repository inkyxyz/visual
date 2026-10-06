package pyrock.events.game;

import lombok.Generated;
import pyrock.events.EventCancellable;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="rotate_camera")
public class RotateCameraEvent
extends EventCancellable {
    private float deltaYaw;
    private float deltaPitch;

    @Generated
    public void setDeltaYaw(float f) {
        this.deltaYaw = f;
    }

    @Generated
    public void setDeltaPitch(float f) {
        this.deltaPitch = f;
    }

    @Generated
    public float getDeltaYaw() {
        return this.deltaYaw;
    }

    @Generated
    public float getDeltaPitch() {
        return this.deltaPitch;
    }

    @Generated
    public RotateCameraEvent(float f, float f2) {
        this.deltaYaw = f;
        this.deltaPitch = f2;
    }
}

