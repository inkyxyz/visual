package pyrock.events.game;

import lombok.Generated;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import rockstar.client.IiIIIIIi_Class66;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="pickup")
public class PickupEvent
extends IiIIIIIi_Class66 {
    private Entity entity;
    private ItemStack itemStack;
    private int count;

    @Generated
    public Entity getEntity() {
        return this.entity;
    }

    @Generated
    public ItemStack getItemStack() {
        return this.itemStack;
    }

    @Generated
    public int getCount() {
        return this.count;
    }

    @Generated
    public PickupEvent(Entity entity, ItemStack itemStack, int n) {
        this.entity = entity;
        this.itemStack = itemStack;
        this.count = n;
    }
}

