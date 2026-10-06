package moscow.rockstar.mixin.minecraft.client.render.chunk;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.chunk.ChunkRendererRegion;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rockstar.client.iIiiIIIIi_Class354;

@Mixin(value={ChunkRendererRegion.class})
public class ChunkRendererRegionMixin {
    @Inject(method={"getBlockState"}, at={@At(value="HEAD")}, cancellable=true)
    private void hideCameraClipBlocks(BlockPos blockPos, CallbackInfoReturnable<BlockState> callbackInfoReturnable) {
        if (iIiiIIIIi_Class354.I_method_2b8f85bd(blockPos)) {
            callbackInfoReturnable.setReturnValue(Blocks.AIR.getDefaultState());
        }
    }
}

