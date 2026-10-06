package pyrock.events.game;

import lombok.Generated;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import pyrock.events.EventCancellable;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="collision_shape")
public class CollisionShapeEvent
extends EventCancellable {
    private final BlockState state;
    private final BlockPos pos;
    private VoxelShape shape;

    @Generated
    public CollisionShapeEvent(BlockState blockState, BlockPos blockPos, VoxelShape voxelShape) {
        this.state = blockState;
        this.pos = blockPos;
        this.shape = voxelShape;
    }

    @Generated
    public BlockState getState() {
        return this.state;
    }

    @Generated
    public BlockPos getPos() {
        return this.pos;
    }

    @Generated
    public VoxelShape getShape() {
        return this.shape;
    }

    @Generated
    public void setShape(VoxelShape voxelShape) {
        this.shape = voxelShape;
    }
}

