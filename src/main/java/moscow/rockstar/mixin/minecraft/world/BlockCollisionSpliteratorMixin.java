package moscow.rockstar.mixin.minecraft.world;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockCollisionSpliterator;
import net.minecraft.world.CollisionView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import pyrock.events.game.CollisionShapeEvent;
import rockstar.client.RockstarClient;

@Mixin(value={BlockCollisionSpliterator.class})
public abstract class BlockCollisionSpliteratorMixin {
    @WrapOperation(method={"computeNext"}, at={@At(value="INVOKE", target="Lnet/minecraft/block/ShapeContext;getCollisionShape(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/CollisionView;Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/util/shape/VoxelShape;")})
    private VoxelShape onComputeNextCollisionBox(ShapeContext shapeContext, BlockState blockState, CollisionView collisionView, BlockPos blockPos, Operation<VoxelShape> operation) {
        VoxelShape voxelShape = (VoxelShape)operation.call(new Object[]{shapeContext, blockState, collisionView, blockPos});
        if (collisionView != MinecraftClient.getInstance().world) {
            return voxelShape;
        }
        CollisionShapeEvent collisionShapeEvent = new CollisionShapeEvent(blockState, blockPos, voxelShape);
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(collisionShapeEvent);
        return collisionShapeEvent.isCancelled() ? VoxelShapes.empty() : collisionShapeEvent.getShape();
    }
}

