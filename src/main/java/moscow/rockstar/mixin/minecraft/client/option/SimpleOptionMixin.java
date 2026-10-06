package moscow.rockstar.mixin.minecraft.client.option;

import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rockstar.client.AmbienceModule;
import rockstar.client.RockstarClient;

@Mixin(value={SimpleOption.class})
public class SimpleOptionMixin<T> {
    @Shadow
    @Final
    Text field_38280;
    @Shadow
    T field_37868;

    @Inject(method={"getValue"}, at={@At(value="HEAD")}, cancellable=true)
    public void getGammaValue(CallbackInfoReturnable<Double> callbackInfoReturnable) {
        if (RockstarClient.getInstance().getModuleManager() == null) {
            return;
        }
        AmbienceModule iIiIIIiIi_Class70 = RockstarClient.getInstance().getModuleManager().getModule(AmbienceModule.class);
        if (iIiIIIiIi_Class70 != null && iIiIIIiIi_Class70.isEnabled() && iIiIIIiIi_Class70.IiI_method_28d5e663() && iIiIIIiIi_Class70.iIII_method_e7b14cf3().isSelected() && this.field_38280.equals((Object)Text.translatable((String)"options.gamma"))) {
            callbackInfoReturnable.setReturnValue(1337.0);
        }
    }

    @Inject(method={"setValue"}, at={@At(value="HEAD")}, cancellable=true)
    public void setGammaValue(T t, CallbackInfo callbackInfo) {
        if (RockstarClient.getInstance().getModuleManager() == null) {
            return;
        }
        AmbienceModule iIiIIIiIi_Class70 = RockstarClient.getInstance().getModuleManager().getModule(AmbienceModule.class);
        if (iIiIIIiIi_Class70 != null && iIiIIIiIi_Class70.isEnabled() && iIiIIIiIi_Class70.iIII_method_e7b14cf3().isSelected() && this.field_38280.equals((Object)Text.translatable((String)"options.gamma"))) {
            this.field_37868 = t;
            callbackInfo.cancel();
        }
    }
}

