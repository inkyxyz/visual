package moscow.rockstar.mixin.minecraft.client.gui.overlay;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.DebugHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rockstar.client.NameProtectModule;
import rockstar.client.RockstarClient;

@Mixin(value={DebugHud.class})
public class DebugHudMixin {
    @Inject(method={"render"}, at={@At(value="HEAD")}, cancellable=true)
    private void hideDebugHud(DrawContext drawContext, CallbackInfo callbackInfo) {
        NameProtectModule iIIIiIiII_Class21 = RockstarClient.getInstance().getModuleManager().getModule(NameProtectModule.class);
        if (iIIIiIiII_Class21 != null && iIIIiIiII_Class21.IiI_method_e72bc283()) {
            callbackInfo.cancel();
        }
    }
}

