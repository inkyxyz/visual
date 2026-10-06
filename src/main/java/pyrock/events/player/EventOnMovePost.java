package pyrock.events.player;

import net.minecraft.util.math.Vec3d;
import rockstar.client.IiIIIIIi_Class66;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="move_post")
public class EventOnMovePost
extends IiIIIIIi_Class66 {
    private final float speed;
    private final Vec3d movementInput;

    public EventOnMovePost(float f, Vec3d vec3d) {
        this.speed = f;
        this.movementInput = vec3d;
    }

    public float getSpeed() {
        return this.speed;
    }

    public Vec3d getMovementInput() {
        return this.movementInput;
    }
}

