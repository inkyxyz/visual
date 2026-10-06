package moscow.rockstar.mixin.accessors;

import javax.annotation.Nullable;
import net.minecraft.client.gui.hud.PlayerListHud;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={PlayerListHud.class})
public interface PlayerListHudAccessor {
    @Accessor(value="header")
    @Nullable
    public Text getHeader();
}

