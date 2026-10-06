package moscow.rockstar.mixin.accessors;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={InGameHud.class})
public interface InGameHudAccessor {
    @Invoker(value="renderOverlay")
    public void rockstar$renderOverlay(DrawContext var1, Identifier var2, float var3);
}

