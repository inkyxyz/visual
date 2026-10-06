package moscow.rockstar.mixin.minecraft.render.item;

import net.minecraft.client.render.item.ItemRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import rockstar.client.Iiiiiiii_Class128;
import rockstar.client.iIIIIIII_Class129;
import rockstar.client.iIIIIIiI_Class131;

@Mixin(value={ItemRenderState.LayerRenderState.class})
public class ItemRenderStateMixin {
    @ModifyArg(method={"render"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/render/item/ItemRenderer;renderItem(Lnet/minecraft/item/ModelTransformationMode;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;II[ILnet/minecraft/client/render/model/BakedModel;Lnet/minecraft/client/render/RenderLayer;Lnet/minecraft/client/render/item/ItemRenderState$Glint;)V"), index=3)
    private int chams$modifyItemLight(int n) {
        if (iIIIIIiI_Class131.i_field_5a || iIIIIIII_Class129.I_field_5a || Iiiiiiii_Class128.I_field_5a) {
            return 0xF000F0;
        }
        return n;
    }

    @ModifyArg(method={"render"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/render/item/model/special/SpecialModelRenderer;render(Ljava/lang/Object;Lnet/minecraft/item/ModelTransformationMode;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IIZ)V"), index=4)
    private int chams$modifySpecialModelLight(int n) {
        if (iIIIIIiI_Class131.i_field_5a || iIIIIIII_Class129.I_field_5a || Iiiiiiii_Class128.I_field_5a) {
            return 0xF000F0;
        }
        return n;
    }
}

