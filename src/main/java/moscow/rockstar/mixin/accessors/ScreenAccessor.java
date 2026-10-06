package moscow.rockstar.mixin.accessors;

import java.util.List;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={Screen.class})
public interface ScreenAccessor {
    @Accessor(value="children")
    public List<Element> getChildren();

    @Invoker(value="addDrawableChild")
    public <T extends Element & Drawable> T invokeAddDrawableChild(T var1);
}

