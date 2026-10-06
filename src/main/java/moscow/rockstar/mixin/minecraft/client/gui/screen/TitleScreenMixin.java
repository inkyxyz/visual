package moscow.rockstar.mixin.minecraft.client.gui.screen;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rockstar.client.RockstarClient;
import rockstar.client.IiiIIiIii_Class204;
import rockstar.client.iIIiIIiIi_Class294;

@Mixin(value={TitleScreen.class})
public class TitleScreenMixin
implements iIIiIIiIi_Class294 {
    @Inject(method={"init"}, at={@At(value="HEAD")}, cancellable=true)
    public void setCustomScreen(CallbackInfo callbackInfo) {
        if (RockstarClient.I_field_502d1741.i_method_e8604970()) {
            return;
        }
        callbackInfo.cancel();
        I_field_3a9bda27.setScreen((Screen)new IiiIIiIii_Class204());
    }
}

