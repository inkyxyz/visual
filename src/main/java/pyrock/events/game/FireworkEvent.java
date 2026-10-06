package pyrock.events.game;

import lombok.Generated;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.util.math.Vec3d;
import rockstar.client.IiIIIIIi_Class66;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="firework")
public class FireworkEvent
extends IiIIIIIi_Class66 {
    private final LivingEntity entity;
    private Vec3d velocity;
    private final FireworkRocketEntity rocketEntity;

    @Generated
    public LivingEntity getEntity() {
        return this.entity;
    }

    @Generated
    public Vec3d getVelocity() {
        return this.velocity;
    }

    @Generated
    public FireworkRocketEntity getRocketEntity() {
        return this.rocketEntity;
    }

    @Generated
    public void setVelocity(Vec3d vec3d) {
        this.velocity = vec3d;
    }

    @Generated
    public FireworkEvent(LivingEntity livingEntity, Vec3d vec3d, FireworkRocketEntity fireworkRocketEntity) {
        this.entity = livingEntity;
        this.velocity = vec3d;
        this.rocketEntity = fireworkRocketEntity;
    }
}

