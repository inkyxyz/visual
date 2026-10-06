package moscow.rockstar.mixin.minecraft.client.network;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.util.SkinTextures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rockstar.client.IiIIIIiiI_Class135;

@Mixin(value={AbstractClientPlayerEntity.class})
public class AbstractClientPlayerEntityMixin {
    @Inject(method={"getSkinTextures"}, at={@At(value="RETURN")}, cancellable=true)
    private void rockstar$swapSkin(CallbackInfoReturnable<SkinTextures> callbackInfoReturnable) {
        if (IiIIIIiiI_Class135.I_method_14f67e63()) {
            return;
        }
        AbstractClientPlayerEntity abstractClientPlayerEntity = (AbstractClientPlayerEntity)(Object)this;
        SkinTextures skinTextures = IiIIIIiiI_Class135.I_method_9cfd572d(abstractClientPlayerEntity.getGameProfile().getName(), (SkinTextures)callbackInfoReturnable.getReturnValue());
        if (skinTextures != callbackInfoReturnable.getReturnValue()) {
            callbackInfoReturnable.setReturnValue(skinTextures);
        }
    }
}

