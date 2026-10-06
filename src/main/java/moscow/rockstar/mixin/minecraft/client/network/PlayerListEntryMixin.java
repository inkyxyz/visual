package moscow.rockstar.mixin.minecraft.client.network;

import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.util.SkinTextures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rockstar.client.IiIIIIiiI_Class135;

@Mixin(value={PlayerListEntry.class})
public class PlayerListEntryMixin {
    @Inject(method={"getSkinTextures"}, at={@At(value="RETURN")}, cancellable=true)
    private void rockstar$swapSkin(CallbackInfoReturnable<SkinTextures> callbackInfoReturnable) {
        if (IiIIIIiiI_Class135.I_method_14f67e63()) {
            return;
        }
        PlayerListEntry playerListEntry = (PlayerListEntry)(Object)this;
        SkinTextures skinTextures = IiIIIIiiI_Class135.I_method_9cfd572d(playerListEntry.getProfile().getName(), (SkinTextures)callbackInfoReturnable.getReturnValue());
        if (skinTextures != callbackInfoReturnable.getReturnValue()) {
            callbackInfoReturnable.setReturnValue(skinTextures);
        }
    }
}

