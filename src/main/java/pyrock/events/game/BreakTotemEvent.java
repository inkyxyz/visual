package pyrock.events.game;

import lombok.Generated;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import rockstar.client.IiIIIIIi_Class66;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="break_totem")
public class BreakTotemEvent
extends IiIIIIIi_Class66 {
    private final LivingEntity entity;
    private final ItemStack stack;

    @Generated
    public LivingEntity getEntity() {
        return this.entity;
    }

    @Generated
    public ItemStack getStack() {
        return this.stack;
    }

    @Generated
    public BreakTotemEvent(LivingEntity livingEntity, ItemStack itemStack) {
        this.entity = livingEntity;
        this.stack = itemStack;
    }
}

