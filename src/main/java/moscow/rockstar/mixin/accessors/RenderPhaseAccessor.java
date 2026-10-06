package moscow.rockstar.mixin.accessors;

import net.minecraft.client.render.RenderPhase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={RenderPhase.class})
public interface RenderPhaseAccessor {
    @Accessor(value="NO_TRANSPARENCY")
    public static RenderPhase.Transparency rockstar$getNoTransparency() {
        throw new AssertionError();
    }
}

