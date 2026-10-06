package pyrock.events.game;

import lombok.Generated;
import net.minecraft.entity.Entity;
import pyrock.events.EventCancellable;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="attack")
public class InternalAttackEvent
extends EventCancellable {
    private final Entity entity;

    @Generated
    public Entity getEntity() {
        return this.entity;
    }

    @Generated
    public InternalAttackEvent(Entity entity) {
        this.entity = entity;
    }
}

