package pyrock.events.game;

import lombok.Generated;
import net.minecraft.entity.Entity;
import rockstar.client.IiIIIIIi_Class66;

public class PostAttackEvent
extends IiIIIIIi_Class66 {
    private final Entity entity;

    public PostAttackEvent(Entity entity) {
        this.entity = entity;
    }

    @Generated
    public Entity getEntity() {
        return this.entity;
    }
}

