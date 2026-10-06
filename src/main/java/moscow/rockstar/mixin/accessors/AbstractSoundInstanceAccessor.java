package moscow.rockstar.mixin.accessors;

import net.minecraft.client.sound.AbstractSoundInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={AbstractSoundInstance.class})
public interface AbstractSoundInstanceAccessor {
    @Accessor(value="volume")
    public float rockstar$getVolume();

    @Accessor(value="pitch")
    public float rockstar$getPitch();
}

