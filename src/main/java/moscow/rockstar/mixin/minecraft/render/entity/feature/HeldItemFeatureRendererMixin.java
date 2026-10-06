package moscow.rockstar.mixin.minecraft.render.entity.feature;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.client.render.entity.state.ArmedEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rockstar.client.FreeCameraModule;
import rockstar.client.BeautifullyModule;
import rockstar.client.RockstarClient;
import rockstar.client.iIiIiiiII_Class349;

@Mixin(value={HeldItemFeatureRenderer.class})
public abstract class HeldItemFeatureRendererMixin {
    @Inject(method={"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/render/entity/state/ArmedEntityRenderState;FF)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void rockstar$hideDuringFade(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int n, ArmedEntityRenderState armedEntityRenderState, float f, float f2, CallbackInfo callbackInfo) {
        Entity entity = ((iIiIiiiII_Class349)armedEntityRenderState).rockstar$getEntity();
        if (entity != MinecraftClient.getInstance().player) {
            return;
        }
        FreeCameraModule iIIiIIiii_Class40 = RockstarClient.getInstance().getModuleManager().getModule(FreeCameraModule.class);
        if (iIIiIIiii_Class40.Iii_method_4619eea3()) {
            callbackInfo.cancel();
            return;
        }
        BeautifullyModule iIiIIIiii_Class72 = RockstarClient.getInstance().getModuleManager().getModule(BeautifullyModule.class);
        if (iIiIIIiii_Class72.isEnabled() && iIiIIIiii_Class72.I_method_b3cc4850().isSelected() && !iIiIIIiii_Class72.i_method_4b28ab15().I_method_6ac4da83()) {
            callbackInfo.cancel();
        }
    }
}

