package moscow.rockstar.mixin.minecraft.render.entity;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import net.minecraft.world.WorldView;
import org.joml.Quaternionf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rockstar.client.BeautifullyModule;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIIiI_Class131;
import rockstar.client.iIiIiiiII_Class349;
import rockstar.client.iIiiIiIII_Class361;

@Environment(value=EnvType.CLIENT)
@Mixin(value={EntityRenderDispatcher.class})
public abstract class EntityRenderDispatcherMixin {
    @Inject(method={"renderShadow"}, at={@At(value="HEAD")}, cancellable=true)
    private static void chams$noShadow(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, EntityRenderState entityRenderState, float f, float f2, WorldView worldView, float f3, CallbackInfo callbackInfo) {
        if (iIIIIIiI_Class131.I_field_5a || iIIIIIiI_Class131.i_field_5a) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"getLight"}, at={@At(value="RETURN")}, cancellable=true)
    private void rockstar$applyDynamicLight(Entity entity, float f, CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        callbackInfoReturnable.setReturnValue(iIiiIiIII_Class361.I_method_fe9701d(BlockPos.ofFloored((Position)entity.getClientCameraPosVec(f)), callbackInfoReturnable.getReturnValueI()));
    }

    @WrapWithCondition(method={"render(Lnet/minecraft/entity/Entity;DDDFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/render/entity/EntityRenderer;)V"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/render/entity/EntityRenderDispatcher;renderFire(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/client/render/entity/state/EntityRenderState;Lorg/joml/Quaternionf;)V")})
    private boolean rockstar$skipFireDuringF5(EntityRenderDispatcher entityRenderDispatcher, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, EntityRenderState entityRenderState, Quaternionf quaternionf) {
        Entity entity;
        BeautifullyModule iIiIIIiii_Class72 = RockstarClient.getInstance().getModuleManager().getModule(BeautifullyModule.class);
        return !iIiIIIiii_Class72.isEnabled() || !iIiIIIiii_Class72.I_method_b3cc4850().isSelected() || iIiIIIiii_Class72.i_method_4b28ab15().I_method_6ac4da83() || (entity = ((iIiIiiiII_Class349)entityRenderState).rockstar$getEntity()) != MinecraftClient.getInstance().player;
    }
}

