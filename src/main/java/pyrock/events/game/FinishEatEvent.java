package pyrock.events.game;

import lombok.Generated;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import rockstar.client.IiIIIIIi_Class66;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="finish_eat")
public class FinishEatEvent
extends IiIIIIIi_Class66 {
    private final PlayerEntity user;
    private final ItemStack stack;

    @Generated
    public PlayerEntity getUser() {
        return this.user;
    }

    @Generated
    public ItemStack getStack() {
        return this.stack;
    }

    @Generated
    public FinishEatEvent(PlayerEntity playerEntity, ItemStack itemStack) {
        this.user = playerEntity;
        this.stack = itemStack;
    }
}

