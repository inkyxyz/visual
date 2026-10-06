package moscow.rockstar.mixin.accessors;

import java.util.Optional;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={RenderPhase.Texture.class})
public interface RenderPhaseTextureAccessor {
    @Accessor(value="id")
    public Optional<Identifier> rockstar$getId();
}

