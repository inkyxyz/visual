package pyrock.events.game;

import lombok.Generated;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import org.jetbrains.annotations.Nullable;
import rockstar.client.IiIIIIIi_Class66;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="entity_death")
public class EntityDeathEvent
extends IiIIIIIi_Class66 {
    private final LivingEntity entity;
    private final DamageSource source;

    public EntityDeathEvent(LivingEntity livingEntity, DamageSource damageSource) {
        this.entity = livingEntity;
        this.source = damageSource;
    }

    public EntityDeathEvent(LivingEntity livingEntity) {
        this.entity = livingEntity;
        this.source = null;
    }

    @Nullable
    public LivingEntity getKillerEntity() {
        return this.entity.getPrimeAdversary();
    }

    @Generated
    public LivingEntity getEntity() {
        return this.entity;
    }

    @Generated
    public DamageSource getSource() {
        return this.source;
    }
}

