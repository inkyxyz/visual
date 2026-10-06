package moscow.rockstar.mixin.minecraft.render.entity;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rockstar.client.IiIIIIiiI_Class135;

@Mixin(value={PlayerEntityRenderer.class})
public class PlayerEntityRendererMixin {
    @Inject(method={"updateRenderState(Lnet/minecraft/client/network/AbstractClientPlayerEntity;Lnet/minecraft/client/render/entity/state/PlayerEntityRenderState;F)V"}, at={@At(value="TAIL")})
    private void rockstar$forceCape(AbstractClientPlayerEntity abstractClientPlayerEntity, PlayerEntityRenderState playerEntityRenderState, float f, CallbackInfo callbackInfo) {
        if (IiIIIIiiI_Class135.I_method_14f67e63()) {
            return;
        }
        if (IiIIIIiiI_Class135.I_method_b4926e6d(abstractClientPlayerEntity.getGameProfile().getName())) {
            playerEntityRenderState.capeVisible = true;
        }
    }
}

