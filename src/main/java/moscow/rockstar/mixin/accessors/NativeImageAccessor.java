package moscow.rockstar.mixin.accessors;

import net.minecraft.client.texture.NativeImage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={NativeImage.class})
public interface NativeImageAccessor {
    @Accessor(value="pointer")
    public long getPointer();

    @Invoker(value="setColor")
    public void invokeSetColor(int var1, int var2, int var3);
}

