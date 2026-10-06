package pyrock.events.game;

import lombok.Generated;
import net.minecraft.entity.LivingEntity;
import pyrock.events.EventCancellable;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="entity_jump")
public class EntityJumpEvent
extends EventCancellable {
    private final LivingEntity entity;

    @Generated
    public LivingEntity getEntity() {
        return this.entity;
    }

    @Generated
    public EntityJumpEvent(LivingEntity livingEntity) {
        this.entity = livingEntity;
    }
}

