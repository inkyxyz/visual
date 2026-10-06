package moscow.rockstar.mixin.minecraft.world;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import rockstar.client.iIIiIIiIi_Class294;

@Mixin(value={AbstractBlock.AbstractBlockState.class})
public abstract class AbstractBlockStateMixin
implements iIIiIIiIi_Class294 {
    @Shadow
    public abstract Block method_26204();
}

