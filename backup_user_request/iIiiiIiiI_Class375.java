package rockstar.client;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.function.UnaryOperator;
import moscow.rockstar.mixin.accessors.SpriteAtlasTextureAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.SmoothItemLayers;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public final class iIiiiIiiI_Class375 {
   private static final Map<BakedQuad, BakedQuad> I_field_a567c40b = new WeakHashMap<>();
   private static SpriteAtlasTexture I_field_98c2a12e;
   private static boolean I_field_5a;
   static boolean i_field_5a;

   private iIiiiIiiI_Class375() {
   }

   public static void I_method_2953ca26(ItemRenderState var0, MatrixStack var1, VertexConsumerProvider var2, int var3, int var4) {
      I_method_7f08e4f9(var0, var1, var2, var3, var4, UnaryOperator.identity());
   }

   public static void I_method_7f08e4f9(
      ItemRenderState var0, MatrixStack var1, VertexConsumerProvider var2, int var3, int var4, UnaryOperator<RenderLayer> var5
   ) {
      if (i_field_5a) {
         var0.render(var1, var2, var3, var4);
      } else {
         boolean var6 = I_field_5a;
         I_field_5a = true;

         try {
            var0.render(var1, var2x -> var2.getBuffer(I_method_53ffbf6f(var5.apply(var2x))), var3, var4);
         } finally {
            I_field_5a = var6;
         }
      }
   }

   public static iIiiiIiiI_Class375.Nested1_a8802c80 I_method_a04b9c30() {
      return new iIiiiIiiI_Class375.Nested1_a8802c80();
   }

   public static RenderLayer I_method_53ffbf6f(RenderLayer var0) {
      if (!SmoothItemLayers.ready()) {
         return var0;
      } else if (var0 == TexturedRenderLayers.getItemEntityTranslucentCull()) {
         I_method_9c4809ff();
         return SmoothItemLayers.translucent(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE);
      } else if (var0 == TexturedRenderLayers.getEntityCutout()) {
         I_method_9c4809ff();
         return SmoothItemLayers.cutout(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE);
      } else {
         return var0;
      }
   }

   public static BakedQuad I_method_948c1ecd(BakedQuad var0) {
      if (I_field_5a && SmoothItemLayers.ready()) {
         BakedQuad var1 = I_field_a567c40b.get(var0);
         if (var1 == null) {
            var1 = i_method_49f7aeed(var0);
            I_field_a567c40b.put(var0, var1);
         }

         return var1;
      } else {
         return var0;
      }
   }

   private static BakedQuad i_method_49f7aeed(BakedQuad var0) {
      Sprite var1 = var0.getSprite();
      int[] var2 = (int[])var0.getVertexData().clone();
      int var3 = var2.length / 8;
      float var4;
      float var5;
      float var6;
      float var7;
      if (var1 != null) {
         float var8 = (var1.getMaxU() - var1.getMinU()) / (2.0F * Math.max(1, var1.getContents().getWidth()));
         float var9 = (var1.getMaxV() - var1.getMinV()) / (2.0F * Math.max(1, var1.getContents().getHeight()));
         var4 = var1.getMinU() + var8;
         var5 = var1.getMaxU() - var8;
         var6 = var1.getMinV() + var9;
         var7 = var1.getMaxV() - var9;
      } else {
         if (I_field_98c2a12e == null) {
            return var0;
         }

         float var17 = 0.5F / Math.max(1, ((SpriteAtlasTextureAccessor)(Object)I_field_98c2a12e).rockstar$getWidth());
         float var19 = 0.5F / Math.max(1, ((SpriteAtlasTextureAccessor)(Object)I_field_98c2a12e).rockstar$getHeight());
         var4 = Float.MAX_VALUE;
         var5 = -Float.MAX_VALUE;
         var6 = Float.MAX_VALUE;
         var7 = -Float.MAX_VALUE;

         for (int var10 = 0; var10 < var3; var10++) {
            float var11 = Float.intBitsToFloat(var2[var10 * 8 + 4]);
            float var12 = Float.intBitsToFloat(var2[var10 * 8 + 5]);
            var4 = Math.min(var4, var11);
            var5 = Math.max(var5, var11);
            var6 = Math.min(var6, var12);
            var7 = Math.max(var7, var12);
         }

         var4 += var17;
         var5 -= var17;
         var6 += var19;
         var7 -= var19;
      }

      if (var4 > var5) {
         var4 = var5 = (var4 + var5) * 0.5F;
      }

      if (var6 > var7) {
         var6 = var7 = (var6 + var7) * 0.5F;
      }

      for (int var18 = 0; var18 < var3; var18++) {
         int var20 = var18 * 8 + 4;
         int var21 = var18 * 8 + 5;
         var2[var20] = Float.floatToRawIntBits(MathHelper.clamp(Float.intBitsToFloat(var2[var20]), var4, var5));
         var2[var21] = Float.floatToRawIntBits(MathHelper.clamp(Float.intBitsToFloat(var2[var21]), var6, var7));
      }

      return new BakedQuad(var2, var0.getTintIndex(), var0.getFace(), var1, var0.hasShade(), var0.getLightEmission());
   }

   private static void I_method_9c4809ff() {
      SpriteAtlasTexture var0 = MinecraftClient.getInstance().getBakedModelManager().getAtlas(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE);
      if (var0 != I_field_98c2a12e) {
         I_field_98c2a12e = var0;
         I_field_a567c40b.clear();
      }
   }

   public static final class Nested1_a8802c80 implements AutoCloseable {
      private final boolean I_field_5a = iIiiiIiiI_Class375.i_field_5a;

      Nested1_a8802c80() {
         iIiiiIiiI_Class375.i_field_5a = true;
      }

      @Override
      public void close() {
         iIiiiIiiI_Class375.i_field_5a = this.I_field_5a;
      }
   }
}
