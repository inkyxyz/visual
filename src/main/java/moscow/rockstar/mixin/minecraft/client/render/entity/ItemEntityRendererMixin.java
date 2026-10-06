package moscow.rockstar.mixin.minecraft.client.render.entity;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ItemEntityRenderer;
import net.minecraft.client.render.entity.state.ItemEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rockstar.client.ItemPhysicsModule;
import rockstar.client.iIiIiiiII_Class349;

@Mixin(ItemEntityRenderer.class)
public abstract class ItemEntityRendererMixin extends EntityRenderer<ItemEntity, ItemEntityRenderState> {
    @Shadow
    @Final
    private Random random;

    protected ItemEntityRendererMixin(EntityRendererFactory.Context context) {
        super(context);
    }

    @Inject(method = "render(Lnet/minecraft/client/render/entity/state/ItemEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V", at = @At("HEAD"), cancellable = true)
    private void rockstar$renderCustomItemPhysics(ItemEntityRenderState itemEntityRenderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (!ItemPhysicsModule.isActive()) {
            return;
        }

        ci.cancel();
        if (itemEntityRenderState.itemRenderState.isEmpty()) {
            return;
        }

        matrixStack.push();

        Entity entity = null;
        if (itemEntityRenderState instanceof iIiIiiiII_Class349 duck) {
            entity = duck.rockstar$getEntity();
        }

        if (entity instanceof ItemEntity itemEntity) {
            ItemPhysicsModule.applyCustomPhysics(itemEntity, itemEntityRenderState, matrixStack);
        } else {
            ItemPhysicsModule.applyCustomPhysics(null, itemEntityRenderState, matrixStack);
        }

        ItemEntityRenderer.renderStack(matrixStack, vertexConsumerProvider, i, itemEntityRenderState, this.random);
        matrixStack.pop();

        super.render(itemEntityRenderState, matrixStack, vertexConsumerProvider, i);
    }
}
