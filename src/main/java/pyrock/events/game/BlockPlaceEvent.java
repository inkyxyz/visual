package pyrock.events.game;

import lombok.Generated;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import rockstar.client.IiIIIIIi_Class66;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="block_place")
public class BlockPlaceEvent
extends IiIIIIIi_Class66 {
    private final BlockPos placePos;
    private final BlockPos hitPos;
    private final Direction side;
    private final Hand hand;
    private final ItemStack stack;

    @Generated
    public BlockPos getPlacePos() {
        return this.placePos;
    }

    @Generated
    public BlockPos getHitPos() {
        return this.hitPos;
    }

    @Generated
    public Direction getSide() {
        return this.side;
    }

    @Generated
    public Hand getHand() {
        return this.hand;
    }

    @Generated
    public ItemStack getStack() {
        return this.stack;
    }

    @Generated
    public BlockPlaceEvent(BlockPos blockPos, BlockPos blockPos2, Direction direction, Hand hand, ItemStack itemStack) {
        this.placePos = blockPos;
        this.hitPos = blockPos2;
        this.side = direction;
        this.hand = hand;
        this.stack = itemStack;
    }
}

