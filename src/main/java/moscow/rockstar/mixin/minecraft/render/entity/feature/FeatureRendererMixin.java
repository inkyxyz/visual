package moscow.rockstar.mixin.minecraft.render.entity.feature;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.render.GlowRenderLayers;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.AntiInvisibleModule;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.IiiiiiiI_Class127;
import rockstar.client.iIIIIIiI_Class131;
import rockstar.client.iIiIiiiII_Class349;

@Mixin({FeatureRenderer.class})
public abstract class FeatureRendererMixin {
   @Unique
   private static final AntiInvisibleModule ANTI_INVISIBLE_MODULE = RockstarClient.getInstance().getModuleManager().getModule(AntiInvisibleModule.class);

   @WrapOperation(
      method = {"renderModel"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/render/entity/model/EntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;III)V"
      )}
   )
   private static void changeModelColor(
      EntityModel<?> var0,
      MatrixStack var1,
      VertexConsumer var2,
      int var3,
      int var4,
      int var5,
      Operation<Void> var6,
      @Local(argsOnly = true) LivingEntityRenderState var7
   ) {
      if (ANTI_INVISIBLE_MODULE.isEnabled() && ANTI_INVISIBLE_MODULE.I_method_e24c5ddb(var7)) {
         Entity var8 = ((iIiIiiiII_Class349)var7).rockstar$getEntity();
         var5 = var8 instanceof ArmorStandEntity
            ? IiiiiIIIi_Class242.Ii_field_d0c8ec5.withAlpha(0.0F).getRGB()
            : IiiiiIIIi_Class242.Ii_field_d0c8ec5.withAlpha(ANTI_INVISIBLE_MODULE.I_method_94dacf15().Ii_method_a20abcd2() / 100.0F * 255.0F).getRGB();
      }

      if (iIIIIIiI_Class131.I_field_5a) {
         iIIIIIiI_Class131 var11 = IiiiiiiI_Class127.I_method_e1e653cb().I_method_b8f96026(iIIIIIiI_Class131.class);
         Entity var9 = ((iIiIiiiII_Class349)var7).rockstar$getEntity();
         if (var11 != null && var11.I_method_d2b4487e(var9)) {
            ColorRGBA var10 = var11.I_method_6ef746e9(var9);
            if (var10 != null) {
               var5 = var10.getRGB();
            }
         }
      }

      var6.call(new Object[]{var0, var1, var2, var3, var4, var5});
   }

   @WrapOperation(
      method = {"renderModel"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/render/RenderLayer;getEntityCutoutNoCull(Lnet/minecraft/util/Identifier;)Lnet/minecraft/client/render/RenderLayer;"
      )}
   )
   private static RenderLayer changeModelRenderLayer(Identifier var0, Operation<RenderLayer> var1, @Local(argsOnly = true) LivingEntityRenderState var2) {
      if (ANTI_INVISIBLE_MODULE.isEnabled() && ANTI_INVISIBLE_MODULE.I_method_e24c5ddb(var2)) {
         return RenderLayer.getItemEntityTranslucentCull(var0);
      } else {
         if (iIIIIIiI_Class131.I_field_5a) {
            iIIIIIiI_Class131 var3 = IiiiiiiI_Class127.I_method_e1e653cb().I_method_b8f96026(iIIIIIiI_Class131.class);
            Entity var4 = ((iIiIiiiII_Class349)var2).rockstar$getEntity();
            if (var3 != null && var3.I_method_d2b4487e(var4) && var3.I_method_6ef746e9(var4) != null) {
               return GlowRenderLayers.get(var0);
            }
         }

         return (RenderLayer)var1.call(new Object[]{var0});
      }
   }
}
