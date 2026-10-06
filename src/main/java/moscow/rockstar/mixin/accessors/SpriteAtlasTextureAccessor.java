package moscow.rockstar.mixin.accessors;

import net.minecraft.client.texture.SpriteAtlasTexture;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={SpriteAtlasTexture.class})
public interface SpriteAtlasTextureAccessor {
    @Accessor(value="width")
    public int rockstar$getWidth();

    @Accessor(value="height")
    public int rockstar$getHeight();
}

