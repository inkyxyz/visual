package moscow.rockstar.mixin.minecraft.client.render.entity;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import moscow.rockstar.mixin.accessors.BipedEntityModelAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.GlowRenderLayers;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.FreeCameraModule;
import rockstar.client.AntiInvisibleModule;
import rockstar.client.BeautifullyModule;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.IiiiiiiI_Class127;
import rockstar.client.iIIIIIIi_Class130;
import rockstar.client.iIIIIIiI_Class131;
import rockstar.client.iIiIiiiII_Class349;
import rockstar.client.iiIIiIiII_Class405;
import rockstar.client.HitColorModule;
import rockstar.client.EzzVisualModule;

@Mixin({LivingEntityRenderer.class})
public abstract class LivingEntityRendererMixin<T extends LivingEntity, S extends LivingEntityRenderState, M extends EntityModel<? super S>> {
   private Entity currentEntity;
   @Shadow
   protected EntityModel<?> field_4737;

   @Shadow
   public abstract Identifier method_3885(LivingEntityRenderState var1);

   @ModifyExpressionValue(
      method = {"updateRenderState(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/client/render/entity/state/LivingEntityRenderState;F)V"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/render/entity/LivingEntityRenderer;clampBodyYaw(Lnet/minecraft/entity/LivingEntity;FF)F"
      )}
   )
   public float changeYaw(float var1, LivingEntity var2) {
      if (!(var2 instanceof ClientPlayerEntity)) {
         return var1;
      } else {
         iiIIiIiII_Class405 var3 = RockstarClient.getInstance().I_method_58785402();
         float var4 = var3.I_method_3d166e03() ? var1 : var3.ii_method_a3477458().I_method_14534e0f();
         var3.Ii_method_62e6c38().I_method_7616dd81(var4);
         return var4;
      }
   }

   @ModifyExpressionValue(
      method = {"updateRenderState(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/client/render/entity/state/LivingEntityRenderState;F)V"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/util/math/MathHelper;lerpAngleDegrees(FFF)F"
      )}
   )
   public float changeHeadYaw(float var1, LivingEntity var2) {
      if (!(var2 instanceof ClientPlayerEntity)) {
         return var1;
      } else {
         iiIIiIiII_Class405 var3 = RockstarClient.getInstance().I_method_58785402();
         float var4 = var3.I_method_3d166e03() ? var1 : var3.ii_method_a3477458().I_method_14534e0f();
         var3.Ii_method_62e6c38().I_method_7616dd81(var4);
         return var4;
      }
   }

   @ModifyExpressionValue(
      method = {"updateRenderState(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/client/render/entity/state/LivingEntityRenderState;F)V"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/entity/LivingEntity;getLerpedPitch(F)F"
      )}
   )
   public float changePitch(float var1, LivingEntity var2) {
      if (!(var2 instanceof ClientPlayerEntity)) {
         return var1;
      } else {
         iiIIiIiII_Class405 var3 = RockstarClient.getInstance().I_method_58785402();
         float var4 = var3.I_method_3d166e03() ? var1 : var3.ii_method_a3477458().i_method_1461d9ef();
         var3.Ii_method_62e6c38().i_method_77d9cda1(var4);
         return var4;
      }
   }

   @WrapOperation(
      method = {"render(Lnet/minecraft/client/render/entity/state/LivingEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/render/entity/model/EntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;III)V"
      )}
   )
   private void changeModelColor(
      EntityModel<?> var1, MatrixStack var2, VertexConsumer var3, int var4, int var5, int var6, Operation<Void> var7, @Local(argsOnly = true) S var8
   ) {
      AntiInvisibleModule var9 = RockstarClient.getInstance().getModuleManager().getModule(AntiInvisibleModule.class);
      Entity var10 = ((iIiIiiiII_Class349)var8).rockstar$getEntity();
      if (var9.isEnabled() && var9.I_method_e24c5ddb(var8)) {
         var6 = var10 instanceof ArmorStandEntity
            ? IiiiiIIIi_Class242.Ii_field_d0c8ec5.withAlpha(0.0F).getRGB()
            : IiiiiIIIi_Class242.Ii_field_d0c8ec5.withAlpha(var9.I_method_94dacf15().Ii_method_a20abcd2() / 100.0F * 255.0F).getRGB();
      }

      BeautifullyModule var11 = RockstarClient.getInstance().getModuleManager().getModule(BeautifullyModule.class);
      if (var11.isEnabled()
         && var11.I_method_b3cc4850().isSelected()
         && !var11.i_method_4b28ab15().I_method_6ac4da83()
         && var10 == MinecraftClient.getInstance().player) {
         var6 = ColorRGBA.applyOpacity(var6, var11.i_method_4b28ab15().I_method_6ac4da6f()).getRGB();
      }

      FreeCameraModule var12 = RockstarClient.getInstance().getModuleManager().getModule(FreeCameraModule.class);
      if (var12.Iii_method_4619eea3() && var10 == MinecraftClient.getInstance().player) {
         var6 = ColorRGBA.applyOpacity(var6, var12.I_method_17c71a2f()).getRGB();
      }

      HitColorModule hitColorMod = RockstarClient.getInstance().getModuleManager().getModule(HitColorModule.class);
      if (hitColorMod != null && hitColorMod.shouldTintEntity(var10)) {
         var6 = hitColorMod.getTintColor(var10);
      }

      iIIIIIIi_Class130 var13 = IiiiiiiI_Class127.I_method_e1e653cb().I_method_b8f96026(iIIIIIIi_Class130.class);
      boolean var14 = var13 != null && var13.i_method_3cafb4b0();
      if (var10 instanceof PlayerEntity var15 && var1 instanceof BipedEntityModel var16) {
         BipedEntityModelAccessor accessor = (BipedEntityModelAccessor)(Object)var16;
         if (var14) {
            boolean var17 = RockstarClient.getInstance().I_method_7a5acaeb().I_method_19c9437a(var15.getName().getString());
            boolean var18 = iIIIIIIi_Class130.II_method_5792e819();
            if (var17 || var18) {
               float var20 = 1.05F;
               accessor.rockstar$getHead().scale(new Vector3f(var20, var20, var20));
            }
         }

         EzzVisualModule ezz = RockstarClient.getInstance().getModuleManager().getModule(EzzVisualModule.class);
         if (ezz != null && ezz.isEnabled()) {
            if (var15 != MinecraftClient.getInstance().player || ezz.shouldAffectSelf()) {
               float surrenderPitch = ezz.getAngleRadians();
               float tickDelta = MinecraftClient.getInstance().getRenderTickCounter().getTickDelta(false);
               float wave = ezz.isSurrenderWave()
                  ? (float)Math.sin((var15.age + tickDelta) * 0.22F) * 0.08F
                  : 0.0F;
               float jitter = ezz.isPanicTremble()
                  ? (float)Math.sin((var15.age + tickDelta) * 1.8F) * 0.09F
                  : 0.0F;
               accessor.rockstar$getRightArm().pitch = surrenderPitch + wave + jitter;
               accessor.rockstar$getLeftArm().pitch = surrenderPitch - wave - jitter;
               accessor.rockstar$getRightArm().roll = 0.22F;
               accessor.rockstar$getLeftArm().roll = -0.22F;

               if (ezz.isPanicTremble()) {
                  accessor.rockstar$getHead().yaw += (float)Math.sin((var15.age + tickDelta) * 2.2F) * 0.07F;
               }
               if (ezz.isCowerPosture()) {
                  accessor.rockstar$getHead().pitch += 0.22F;
                  accessor.rockstar$getBody().pitch += 0.12F;
               }
            }
         }

         float animDelta = MinecraftClient.getInstance().getRenderTickCounter().getTickDelta(false);
         if (var15 == MinecraftClient.getInstance().player) {
            rockstar.client.AnimationWheelModule.applyTransforms(var15, accessor, animDelta);
         }
      }

      var7.call(new Object[]{var1, var2, var3, var4, var5, var6});
   }

   @ModifyReturnValue(
      method = {"getRenderLayer"},
      at = {@At("RETURN")}
   )
   private RenderLayer changeRenderLayer(RenderLayer var1, S var2, boolean var3, boolean var4, boolean var5) {
      AntiInvisibleModule var6 = RockstarClient.getInstance().getModuleManager().getModule(AntiInvisibleModule.class);
      if (var6.isEnabled() && !var3 && !var4 && !var5) {
         var2.invisible = false;
         return RenderLayer.getItemEntityTranslucentCull(this.method_3885(var2));
      } else {
         BeautifullyModule var7 = RockstarClient.getInstance().getModuleManager().getModule(BeautifullyModule.class);
         if (var7.isEnabled() && var7.I_method_b3cc4850().isSelected() && !var7.i_method_4b28ab15().I_method_6ac4da83()) {
            Entity var8 = ((iIiIiiiII_Class349)var2).rockstar$getEntity();
            if (var8 == MinecraftClient.getInstance().player) {
               return RenderLayer.getItemEntityTranslucentCull(this.method_3885(var2));
            }
         }

         FreeCameraModule var10 = RockstarClient.getInstance().getModuleManager().getModule(FreeCameraModule.class);
         if (var10.Iii_method_4619eea3()) {
            Entity var9 = ((iIiIiiiII_Class349)var2).rockstar$getEntity();
            if (var9 == MinecraftClient.getInstance().player) {
               return RenderLayer.getItemEntityTranslucentCull(this.method_3885(var2));
            }
         }

         return var1;
      }
   }

   @Inject(
      method = {"render(Lnet/minecraft/client/render/entity/state/LivingEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
      at = {@At("HEAD")}
   )
   private void captureEntity(LivingEntityRenderState var1, MatrixStack var2, VertexConsumerProvider var3, int var4, CallbackInfo var5) {
      this.currentEntity = ((iIiIiiiII_Class349)var1).rockstar$getEntity();
      RockstarClient.I_field_77e0818c = this.currentEntity;
   }

   @Inject(
      method = {"render(Lnet/minecraft/client/render/entity/state/LivingEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
      at = {@At("RETURN")}
   )
   private void releaseEntity(LivingEntityRenderState var1, MatrixStack var2, VertexConsumerProvider var3, int var4, CallbackInfo var5) {
      RockstarClient.I_field_77e0818c = null;
   }

   @WrapWithCondition(
      method = {"render(Lnet/minecraft/client/render/entity/state/LivingEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/render/entity/model/EntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;III)V"
      )}
   )
   private boolean render$render(
      M var1, MatrixStack var2, VertexConsumer var3, int var4, int var5, int var6, S var7, MatrixStack var8, VertexConsumerProvider var9, int var10
   ) {
      Entity var11 = ((iIiIiiiII_Class349)var7).rockstar$getEntity();
      if (var1 instanceof BipedEntityModel var12) {
         iIIIIIIi_Class130 var13 = IiiiiiiI_Class127.I_method_e1e653cb().I_method_b8f96026(iIIIIIIi_Class130.class);
         boolean var14 = var13 != null && var13.i_method_3cafb4b0();
         if (var14) {
            boolean var15 = RockstarClient.getInstance().I_method_7a5acaeb().I_method_19c9437a(var11.getName().getString());
            boolean var16 = var13 != null && iIIIIIIi_Class130.II_method_5792e819();
            if (var15 || var16) {
               BipedEntityModelAccessor var17 = (BipedEntityModelAccessor)(Object)var12;
               float var18 = 1.05F;
               var17.rockstar$getHead().scale(new Vector3f(var18, var18, var18));
            }
         }
      }

      if (iIIIIIiI_Class131.I_field_5a) {
         iIIIIIiI_Class131 var19 = IiiiiiiI_Class127.I_method_e1e653cb().I_method_b8f96026(iIIIIIiI_Class131.class);
         if (var19 != null && var19.I_method_d2b4487e(var11)) {
            ColorRGBA var20 = var19.I_method_6ef746e9(var11);
            if (var20 != null) {
               var1.render(var2, var3, var4, var5, var20.getRGB());
               return false;
            }
         }
      }

      return true;
   }

   @ModifyReturnValue(
      method = {"getRenderLayer"},
      at = {@At("RETURN")}
   )
   private RenderLayer getRenderPlayer(RenderLayer var1, S var2, boolean var3, boolean var4, boolean var5) {
      iIIIIIiI_Class131 var6 = IiiiiiiI_Class127.I_method_e1e653cb().I_method_b8f96026(iIIIIIiI_Class131.class);
      Entity var7 = ((iIiIiiiII_Class349)var2).rockstar$getEntity();
      if (var6 != null && var6.I_method_d2b4487e(var7) && iIIIIIiI_Class131.I_field_5a) {
         ColorRGBA var8 = var6.I_method_6ef746e9(var7);
         return var8 == null ? var1 : GlowRenderLayers.get(this.method_3885(var2));
      } else {
         return var1;
      }
   }

   @ModifyArg(
      method = {"render(Lnet/minecraft/client/render/entity/state/LivingEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/render/entity/model/EntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;III)V"
      ),
      index = 2
   )
   private int forceModelFullbright(int var1) {
      iIIIIIiI_Class131 var2 = IiiiiiiI_Class127.I_method_e1e653cb().I_method_b8f96026(iIIIIIiI_Class131.class);
      return var2 != null && var2.I_method_d2b4487e(this.currentEntity) && iIIIIIiI_Class131.I_field_5a ? 15728880 : var1;
   }
}
