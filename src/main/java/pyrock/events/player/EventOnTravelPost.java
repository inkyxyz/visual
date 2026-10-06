package pyrock.events.player;

import net.minecraft.util.math.Vec3d;
import rockstar.client.IiIIIIIi_Class66;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="travel_post")
public class EventOnTravelPost
extends IiIIIIIi_Class66 {
    private Vec3d oldVelocity;

    public EventOnTravelPost(Vec3d vec3d) {
        this.oldVelocity = vec3d;
    }

    public Vec3d getOldVelocity() {
        return this.oldVelocity;
    }

    public void setOldVelocity(Vec3d vec3d) {
        this.oldVelocity = vec3d;
    }
}

