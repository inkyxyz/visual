package moscow.rockstar.mixin.blaze3d;

import com.mojang.blaze3d.platform.GlStateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rockstar.client.iIiiIIiiI_Class359;

@Mixin(value={GlStateManager.class})
public class GlStateManagerMixin {
    @Inject(method={"_drawElements(IIIJ)V"}, at={@At(value="HEAD")})
    private static void rockstar$countDrawCall(int n, int n2, int n3, long l, CallbackInfo callbackInfo) {
        iIiiIIiiI_Class359.I_method_1319e61f();
    }
}

