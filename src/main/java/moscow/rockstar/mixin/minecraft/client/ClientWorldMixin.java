package moscow.rockstar.mixin.minecraft.client;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rockstar.client.AmbienceModule;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiiIIIi_Class242;

@Mixin(value={ClientWorld.class})
public class ClientWorldMixin {
    @Inject(method={"getSkyColor"}, at={@At(value="HEAD")}, cancellable=true)
    private void onGetSkyColor(Vec3d vec3d, float f, CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        if (RockstarClient.getInstance().getModuleManager() == null) return;
        AmbienceModule iIiIIIiIi_Class70 = RockstarClient.getInstance().getModuleManager().getModule(AmbienceModule.class);
        if (iIiIIIiIi_Class70 != null && iIiIIIiIi_Class70.isEnabled()) {
            if (iIiIIIiIi_Class70.isPresetActive() || iIiIIIiIi_Class70.I_method_d8b45030().isSelected()) {
                callbackInfoReturnable.setReturnValue(iIiIIIiIi_Class70.getPresetSkyColor().getRGB());
            }
        }
    }

    @Inject(method={"getCloudsColor"}, at={@At(value="HEAD")}, cancellable=true)
    private void onGetCloudsColor(float f, CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        if (RockstarClient.getInstance().getModuleManager() == null) return;
        AmbienceModule iIiIIIiIi_Class70 = RockstarClient.getInstance().getModuleManager().getModule(AmbienceModule.class);
        if (iIiIIIiIi_Class70 != null && iIiIIIiIi_Class70.isEnabled()) {
            if (iIiIIIiIi_Class70.isPresetActive() || iIiIIIiIi_Class70.i_method_debc4c10().isSelected()) {
                callbackInfoReturnable.setReturnValue(iIiIIIiIi_Class70.getPresetCloudColor().getRGB());
            }
        }
    }
}

