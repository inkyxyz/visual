package moscow.rockstar.mixin.minecraft.render.item;

import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedQuad;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import rockstar.client.iIiiiIiiI_Class375;

@Mixin(value={ItemRenderer.class})
public class ItemRendererMixin {
    @ModifyArg(method={"renderBakedItemQuads"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/render/VertexConsumer;quad(Lnet/minecraft/client/util/math/MatrixStack$Entry;Lnet/minecraft/client/render/model/BakedQuad;FFFFII)V"), index=1)
    private static BakedQuad rockstar$insetUv(BakedQuad bakedQuad) {
        return iIiiiIiiI_Class375.I_method_948c1ecd(bakedQuad);
    }
}

