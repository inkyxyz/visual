package moscow.rockstar.mixin.minecraft.render.entity;

import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import rockstar.client.iIiIiiiII_Class349;

@Mixin(value={EntityRenderState.class})
public abstract class EntityRenderStateMixin
implements iIiIiiiII_Class349 {
    @Unique
    private Entity rockstar$entity;

    @Override
    @Unique
    public void rockstar$setEntity(Entity entity) {
        this.rockstar$entity = entity;
    }

    @Override
    @Unique
    public Entity rockstar$getEntity() {
        return this.rockstar$entity;
    }
}

