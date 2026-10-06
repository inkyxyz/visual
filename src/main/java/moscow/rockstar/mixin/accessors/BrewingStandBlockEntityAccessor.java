package moscow.rockstar.mixin.accessors;

import net.minecraft.block.entity.BrewingStandBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={BrewingStandBlockEntity.class})
public interface BrewingStandBlockEntityAccessor {
    @Accessor(value="brewTime")
    public int getBrewTime();

    @Accessor(value="fuel")
    public int getFuelLevel();
}

