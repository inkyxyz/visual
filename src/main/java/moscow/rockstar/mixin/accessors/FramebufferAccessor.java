package moscow.rockstar.mixin.accessors;

import net.minecraft.client.gl.Framebuffer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={Framebuffer.class})
public interface FramebufferAccessor {
    @Accessor(value="depthAttachment")
    public void setDepthAttachment(int var1);
}

