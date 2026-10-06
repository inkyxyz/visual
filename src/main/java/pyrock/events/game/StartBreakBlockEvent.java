package pyrock.events.game;

import lombok.Generated;
import net.minecraft.util.math.BlockPos;
import pyrock.events.EventCancellable;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="start_break_block")
public class StartBreakBlockEvent
extends EventCancellable {
    private final BlockPos blockPos;

    public StartBreakBlockEvent(BlockPos blockPos) {
        this.blockPos = blockPos;
    }

    @Generated
    public BlockPos getBlockPos() {
        return this.blockPos;
    }
}

