package moscow.rockstar.mixin.minecraft.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.iIiiiIiiI_Class375;

@Mixin(value={DrawContext.class})
public class DrawContextMixin {
    @Redirect(method={"drawItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/world/World;Lnet/minecraft/item/ItemStack;IIII)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/render/item/ItemRenderState;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;II)V"))
    private void rockstar$smoothItem(ItemRenderState itemRenderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int n, int n2) {
        if ((Object)(Object)(Object)(Object)(Object)(Object)this instanceof CustomDrawContext) {
            iIiiiIiiI_Class375.I_method_2953ca26(itemRenderState, matrixStack, vertexConsumerProvider, n, n2);
        } else {
            itemRenderState.render(matrixStack, vertexConsumerProvider, n, n2);
        }
    }
}

