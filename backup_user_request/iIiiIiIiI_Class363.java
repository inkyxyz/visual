package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.IdentityHashMap;
import java.util.Map;
import moscow.rockstar.mixin.accessors.DrawContextAccessor;
import moscow.rockstar.mixin.accessors.MultiPhaseParametersAccessor;
import moscow.rockstar.mixin.accessors.RenderLayerMultiPhaseAccessor;
import moscow.rockstar.mixin.accessors.RenderPhaseAccessor;
import moscow.rockstar.mixin.accessors.RenderPhaseTextureAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.DiffuseLighting;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider.Immediate;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.util.Identifier;

public final class iIiiIiIiI_Class363 {
   private static final Map<RenderLayer, RenderLayer> I_field_a567c40b = new IdentityHashMap<>();

   private iIiiIiIiI_Class363() {
   }

   public static void I_method_5e6be269(DrawContext var0, ItemStack var1, float var2, float var3, float var4, float var5) {
      if (!var1.isEmpty() && !(var5 <= 0.01F)) {
         MinecraftClient var6 = MinecraftClient.getInstance();
         ItemRenderState var7 = ((DrawContextAccessor)(Object)var0).getItemRenderState();
         Immediate var8 = ((DrawContextAccessor)(Object)var0).getVertexConsumers();
         var6.getItemModelManager().update(var7, var1, ModelTransformationMode.GUI, false, var6.world, var6.player, 0);
         if (!var7.isEmpty()) {
            iIiiiiIii_Class380.I_method_5f4b621f();
            MatrixStack var9 = var0.getMatrices();
            var9.push();
            var9.translate(var2, var3, 0.0F);
            var9.scale(var4, var4, var4);
            var9.translate(8.0F, 8.0F, 150.0F);
            var9.scale(16.0F, -16.0F, 16.0F);
            boolean var10 = !var7.isSideLit();
            var8.draw();
            if (var10) {
               DiffuseLighting.disableGuiDepthLighting();
            } else {
               DiffuseLighting.enableGuiDepthLighting();
            }

            float[] var11 = (float[])RenderSystem.getShaderColor().clone();
            RenderSystem.setShaderColor(var11[0], var11[1], var11[2], var5);
            iIiiiIiiI_Class375.I_method_7f08e4f9(var7, var9, var8, 15728880, OverlayTexture.DEFAULT_UV, iIiiIiIiI_Class363::I_method_6bd16b0f);
            var8.draw();
            RenderSystem.setShaderColor(var11[0], var11[1], var11[2], var11[3]);
            if (var10) {
               DiffuseLighting.enableGuiDepthLighting();
            }

            var9.pop();
         }
      }
   }

   private static RenderLayer I_method_6bd16b0f(RenderLayer var0) {
      RenderLayer var1 = I_field_a567c40b.get(var0);
      if (var1 != null) {
         return var1;
      } else {
         RenderLayer var2 = var0;
         if (var0 instanceof RenderLayerMultiPhaseAccessor var3) {
            MultiPhaseParametersAccessor var4 = (MultiPhaseParametersAccessor)(Object)var3.rockstar$getPhases();
            if (var4.rockstar$getTransparency() == RenderPhaseAccessor.rockstar$getNoTransparency()
               && var4.rockstar$getTexture() instanceof RenderPhaseTextureAccessor var5) {
               Identifier var7 = var5.rockstar$getId().orElse(null);
               if (var7 != null) {
                  var2 = RenderLayer.getItemEntityTranslucentCull(var7);
               }
            }
         }

         I_field_a567c40b.put(var0, var2);
         return var2;
      }
   }
}
