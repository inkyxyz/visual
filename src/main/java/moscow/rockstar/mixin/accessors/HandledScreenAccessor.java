package moscow.rockstar.mixin.accessors;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.screen.slot.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={HandledScreen.class})
public interface HandledScreenAccessor {
    @Accessor(value="x")
    public int getX();

    @Accessor(value="y")
    public int getY();

    @Accessor(value="focusedSlot")
    public Slot getFocusedSlot();
}

