package pyrock.events.game;

import lombok.Generated;
import net.minecraft.entity.Entity;
import pyrock.events.EventCancellable;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="after_attack")
public class AfterAttackEvent
extends EventCancellable {
    private final Entity entity;

    @Generated
    public Entity getEntity() {
        return this.entity;
    }

    @Generated
    public AfterAttackEvent(Entity entity) {
        this.entity = entity;
    }
}

