package moscow.rockstar.mixin.accessors;

import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={ScreenHandler.class})
public interface ScreenHandlerAccessor {
    @Accessor(value="trackedStacks")
    public DefaultedList<ItemStack> getTrackedStacks();
}

