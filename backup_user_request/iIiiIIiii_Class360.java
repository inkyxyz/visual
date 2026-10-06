package rockstar.client;

import com.mojang.blaze3d.systems.ProjectionType;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.List;
import lombok.Generated;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.BlockGhostLayers;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.GlowRenderLayers;
import net.minecraft.client.render.SmoothItemLayers;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MatrixUtil;
import net.minecraft.util.math.Vec2f;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;
import org.joml.Vector3f;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.Rect;
import ua.mintantileak.spk.Compile;

public final class iIiiIIiii_Class360 implements iIIiIIiIi_Class294, iIIiIIiii_Class296 {
   public static final float I_field_46 = 0.5F;
   public static final iIiiIiiiI_Class367 I_field_e76c68c = new iIiiIiiiI_Class367(true);
   public static IiiIi_Class14 I_field_2f5b1d2c;
   private static IiiIi_Class14 ii_field_2f5b1d2c;
   private static IiiIi_Class14 III_field_2f5b1d2c;
   private static IiiIi_Class14 IIi_field_2f5b1d2c;
   private static IiiIi_Class14 IiI_field_2f5b1d2c;
   private static IiiIi_Class14 Iii_field_2f5b1d2c;
   private static IiiIi_Class14 iII_field_2f5b1d2c;
   private static IiiIi_Class14 iIi_field_2f5b1d2c;
   private static IiiIi_Class14 iiI_field_2f5b1d2c;
   private static IiiIi_Class14 iii_field_2f5b1d2c;
   private static IiiIi_Class14 IIII_field_2f5b1d2c;
   private static IiiIi_Class14 IIIi_field_2f5b1d2c;
   public static iIIiI_Class19 I_field_6425294c;
   public static iIIII_Class17 I_field_6424b12c;
   public static iIiiI_Class23 I_field_6433b52c;
   public static iIiIi_Class22 I_field_643340ec;
   public static IIIIiI_Class3 I_field_83aa8641;
   public static IIIIiI_Class3 i_field_83aa8641;
   public static IIIIiI_Class3 II_field_83aa8641;
   public static IIIIiI_Class3 Ii_field_83aa8641;
   public static iIIii_Class20 I_field_64252d2c;
   public static iIIii_Class20 i_field_64252d2c;
   public static IIIIIi_Class2 I_field_83aa1201;
   public static IIiIII_Class9 I_field_856cfe41;
   public static iiiiI_Class31 I_field_65f6a54c;
   public static iiiIi_Class30 I_field_65f6310c;
   public static iiIIi_Class26 I_field_65e7a52c;
   public static iiIIi_Class26 i_field_65e7a52c;
   public static iiIIi_Class26 II_field_65e7a52c;
   private static IiiIi_Class14 IIiI_field_2f5b1d2c;
   private static IiiIi_Class14 IIii_field_2f5b1d2c;
   private static IiiIi_Class14 IiII_field_2f5b1d2c;
   public static IiiIi_Class14 i_field_2f5b1d2c;
   public static IiiIi_Class14 II_field_2f5b1d2c;
   public static IiiIi_Class14 Ii_field_2f5b1d2c;
   public static IiiiI_Class15 I_field_2f5b916c;
   private static IiiIi_Class14 IiIi_field_2f5b1d2c;
   public static IiiIi_Class14 iI_field_2f5b1d2c;
   private static final iIiiIIiII_Class357 I_field_cb35e4c = new iIiiIIiII_Class357(false);
   private static int I_field_49 = -1;

   public static void I_method_eceab8e4(int var0) {
      I_field_49 = var0;
   }

   public static void I_method_49b4f9ff() {
      I_field_49 = -1;
   }

   private static int I_method_49b4f9f2() {
      return I_field_49 >= 0 && !iIiiiiIii_Class380.I_field_5a && I_field_6424b12c.I_method_5711f408(I_field_49)
         ? I_field_6424b12c.I_method_5711f3f7(I_field_49)
         : iIIiI_Class19.I_method_af142f2();
   }

   private static boolean I_method_7ff3e064(ColorRGBA var0) {
      return var0 == null || var0.getAlpha() <= 0.5F;
   }

   private static boolean I_method_b06b6e43(float var0, float var1) {
      return var0 <= 0.0F || var1 <= 0.0F;
   }

   @Compile(
      obfuscation = 4
   )
   public static void i_method_49c385df() {
      I_field_2f5b1d2c = new IiiIi_Class14(RockstarClient.id("rectangle/data"), VertexFormats.POSITION_COLOR);
      ii_field_2f5b1d2c = new IiiIi_Class14(RockstarClient.id("squircle/data"), VertexFormats.POSITION_COLOR);
      IIi_field_2f5b1d2c = new IiiIi_Class14(RockstarClient.id("squircle_texture/data"), VertexFormats.POSITION_TEXTURE_COLOR);
      IiI_field_2f5b1d2c = new IiiIi_Class14(RockstarClient.id("proj_squircle/data"), VertexFormats.POSITION_TEXTURE_COLOR);
      III_field_2f5b1d2c = new IiiIi_Class14(RockstarClient.id("texture/data"), VertexFormats.POSITION_TEXTURE_COLOR);
      Iii_field_2f5b1d2c = new IiiIi_Class14(RockstarClient.id("border/data"), VertexFormats.POSITION_COLOR);
      iII_field_2f5b1d2c = new IiiIi_Class14(RockstarClient.id("dashed_border/data"), VertexFormats.POSITION_COLOR);
      iIi_field_2f5b1d2c = new IiiIi_Class14(RockstarClient.id("bezier/data"), VertexFormats.POSITION_COLOR);
      iiI_field_2f5b1d2c = new IiiIi_Class14(RockstarClient.id("squircle_border/data"), VertexFormats.POSITION_COLOR);
      iii_field_2f5b1d2c = new IiiIi_Class14(RockstarClient.id("loading/data"), VertexFormats.POSITION_COLOR);
      IIII_field_2f5b1d2c = new IiiIi_Class14(RockstarClient.id("liquidglass/data"), VertexFormats.POSITION_TEXTURE_COLOR);
      IIIi_field_2f5b1d2c = new IiiIi_Class14(RockstarClient.id("gradient_rectangle/data"), VertexFormats.POSITION_COLOR);
      IIiI_field_2f5b1d2c = new IiiIi_Class14(RockstarClient.id("metaball/data"), VertexFormats.POSITION_TEXTURE_COLOR);
      IIii_field_2f5b1d2c = new IiiIi_Class14(RockstarClient.id("islandblob/data"), VertexFormats.POSITION_COLOR);
      i_field_2f5b1d2c = new IiiIi_Class14(RockstarClient.id("mapped_texture/data"), VertexFormats.POSITION_TEXTURE_COLOR);
      II_field_2f5b1d2c = new IiiIi_Class14(RockstarClient.id("ui_universal/data"), VertexFormats.POSITION_TEXTURE_COLOR_LIGHT);
      Ii_field_2f5b1d2c = new IiiIi_Class14(RockstarClient.id("adaptive_ui/data"), VertexFormats.POSITION_TEXTURE_COLOR_LIGHT);
      I_field_2f5b916c = new IiiiI_Class15();
      I_field_2f5b916c.I_method_6769b1f();
      IiIi_field_2f5b1d2c = new IiiIi_Class14(RockstarClient.id("backdrop_blur/data"), VertexFormats.POSITION_TEXTURE_COLOR);
      iI_field_2f5b1d2c = new IiiIi_Class14(RockstarClient.id("ui_stream/data"), VertexFormats.POSITION_TEXTURE_COLOR);
      IiII_field_2f5b1d2c = new IiiIi_Class14(RockstarClient.id("arc/data"), VertexFormats.POSITION_COLOR);
      I_field_6425294c = new iIIiI_Class19();
      I_field_6425294c.I_method_af142ff();
      I_field_6424b12c = new iIIII_Class17();
      I_field_6424b12c.I_method_6e29dadf();
      I_field_65f6a54c = new iiiiI_Class31();
      I_field_65f6a54c.I_method_8fa4beff();
      I_field_6433b52c = new iIiiI_Class23();
      I_field_6433b52c.I_method_716dedf();
      I_field_643340ec = new iIiIi_Class22(RockstarClient.id("glow/entity_solid/data"));
      GlowRenderLayers.initShader(I_field_643340ec);
      I_field_83aa8641 = new IIIIiI_Class3(RockstarClient.id("sky_nebula/data"));
      iIiiiIiIi_Class374.I_method_aaaff9c0(I_field_83aa8641);
      i_field_83aa8641 = new IIIIiI_Class3(RockstarClient.id("sky_sunset/data"));
      iIiiiIiIi_Class374.I_method_aaaff9c0(i_field_83aa8641);
      II_field_83aa8641 = new IIIIiI_Class3(RockstarClient.id("sky_radiant/data"));
      iIiiiIiIi_Class374.I_method_aaaff9c0(II_field_83aa8641);
      Ii_field_83aa8641 = new IIIIiI_Class3(RockstarClient.id("sky_caustic/data"));
      iIiiiIiIi_Class374.I_method_aaaff9c0(Ii_field_83aa8641);
      I_field_64252d2c = new iIIii_Class20(RockstarClient.id("sky_galaxy/bake/data"), RockstarClient.id("sky_galaxy/view/data"));
      iIiiiIiIi_Class374.I_method_55fe86c7(I_field_64252d2c);
      i_field_64252d2c = new iIIii_Class20(RockstarClient.id("sky_space/bake/data"), RockstarClient.id("sky_space/view/data"));
      iIiiiIiIi_Class374.I_method_55fe86c7(i_field_64252d2c);
      I_field_83aa1201 = new IIIIIi_Class2(RockstarClient.id("saturation/data"));
      I_field_856cfe41 = new IIiIII_Class9(RockstarClient.id("wet_world/data"));
      I_field_65f6310c = new iiiIi_Class30(RockstarClient.id("mirror_composite/data"));
      I_field_65e7a52c = new iiIIi_Class26(RockstarClient.id("item_caustic/data"));
      i_field_65e7a52c = new iiIIi_Class26(RockstarClient.id("item_plasma/data"));
      II_field_65e7a52c = new iiIIi_Class26(RockstarClient.id("item_lava/data"));
      SmoothItemLayers.initShaders(
         new IiiIi_Class14(RockstarClient.id("item_smooth/translucent/data"), VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL),
         new IiiIi_Class14(RockstarClient.id("item_smooth/cutout/data"), VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL)
      );
      BlockGhostLayers.initShader(new IiiIi_Class14(RockstarClient.id("block_ghost/data"), VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL));
   }

   public static void II_method_ecf93d42() {
      I_field_cb35e4c.setClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      I_field_cb35e4c.I_method_76527dff();
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      I_field_3a9bda27.getFramebuffer().beginRead();
      RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
      RenderSystem.setShaderTexture(0, I_field_3a9bda27.getFramebuffer().getColorAttachment());
      I_method_27653035(0.0F, 0.0F, I_field_587075c2.getScaledWidth(), I_field_587075c2.getScaledHeight(), true);
      I_field_3a9bda27.getFramebuffer().endRead();
      RenderSystem.disableBlend();
      I_field_3a9bda27.getFramebuffer().beginWrite(true);
      I_field_cb35e4c.i_method_766109df();
   }

   public static void Ii_method_ed07c922() {
      Framebuffer var0 = I_field_3a9bda27.getFramebuffer();
      if (var0 != null) {
         int var1 = I_field_587075c2.getScaledWidth();
         int var2 = I_field_587075c2.getScaledHeight();
         RenderSystem.backupProjectionMatrix();
         Matrix4f var3 = new Matrix4f().setOrtho(0.0F, var1, var2, 0.0F, 1000.0F, 21000.0F);
         RenderSystem.setProjectionMatrix(var3, ProjectionType.ORTHOGRAPHIC);
         Matrix4fStack var4 = RenderSystem.getModelViewStack();
         var4.pushMatrix();
         var4.identity().translate(0.0F, 0.0F, -11000.0F);
         I_field_cb35e4c.I_method_53fdf4b5(true);
         RenderSystem.disableBlend();
         RenderSystem.disableDepthTest();
         RenderSystem.disableCull();
         RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         RenderSystem.setShaderTexture(0, var0.getColorAttachment());
         I_method_27653035(0.0F, 0.0F, var1, var2, true);
         RenderSystem.setShaderTexture(0, 0);
         I_field_cb35e4c.i_method_766109df();
         var4.popMatrix();
         RenderSystem.restoreProjectionMatrix();
      }
   }

   public static void I_method_710529b2(
      MatrixStack var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8, Runnable var9
   ) {
      if (!I_method_b06b6e43(var3, var4)) {
         I_field_cb35e4c.I_method_53fdf4b5(true);
         var9.run();
         I_field_cb35e4c.i_method_766109df();
         Matrix4f var10 = var0.peek().getPositionMatrix();
         ii_method_eecab942();
         RenderSystem.disableCull();
         RenderSystem.setShaderTexture(0, I_field_cb35e4c.getColorAttachment());
         IIiI_field_2f5b1d2c.I_method_33f6c16b();
         IIiI_field_2f5b1d2c.I_method_cb7dbe45("Size").set(var3, var4);
         IIiI_field_2f5b1d2c.I_method_cb7dbe45("Threshold").set(var5);
         IIiI_field_2f5b1d2c.I_method_cb7dbe45("Smooth").set(var6);
         IIiI_field_2f5b1d2c.I_method_cb7dbe45("RadiusPx").set(var7);
         IIiI_field_2f5b1d2c.I_method_cb7dbe45("Iterations").set(var8);
         int var11 = I_field_587075c2.getScaledWidth();
         int var12 = I_field_587075c2.getScaledHeight();
         float var13 = var1 / var11;
         float var14 = (var12 - var2 - var4) / var12;
         float var15 = var3 / var11;
         float var16 = var4 / var12;
         byte var17 = -1;
         BufferBuilder var18 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
         var18.vertex(var10, var1, var2, 0.0F).texture(var13, var14 + var16).color(var17);
         var18.vertex(var10, var1, var2 + var4, 0.0F).texture(var13, var14).color(var17);
         var18.vertex(var10, var1 + var3, var2 + var4, 0.0F).texture(var13 + var15, var14).color(var17);
         var18.vertex(var10, var1 + var3, var2, 0.0F).texture(var13 + var15, var14 + var16).color(var17);
         BufferRenderer.drawWithGlobalProgram(var18.end());
         RenderSystem.setShaderTexture(0, 0);
         RenderSystem.enableCull();
         III_method_b23d625f();
      }
   }

   private static void I_method_27653035(float var0, float var1, float var2, float var3, boolean var4) {
      BufferBuilder var5 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
      byte var6 = -1;
      float var7 = var4 ? 0.0F : 1.0F;
      float var8 = var4 ? 1.0F : 0.0F;
      var5.vertex(var0, var1, 0.0F).texture(0.0F, var8).color(-1);
      var5.vertex(var0, var1 + var3, 0.0F).texture(0.0F, var7).color(-1);
      var5.vertex(var0 + var2, var1 + var3, 0.0F).texture(1.0F, var7).color(-1);
      var5.vertex(var0 + var2, var1, 0.0F).texture(1.0F, var8).color(-1);
      BufferRenderer.drawWithGlobalProgram(var5.end());
   }

   public static void I_method_4c7ece4e(MatrixStack var0, Vec2f var1, Vec2f var2, ColorRGBA var3) {
      var0.push();

      try {
         Matrix4f var4 = var0.peek().getPositionMatrix();
         RenderSystem.enableBlend();
         RenderSystem.defaultBlendFunc();
         RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
         RenderSystem.lineWidth(1.0F);
         ii_method_eecab942();
         BufferBuilder var5 = RenderSystem.renderThreadTesselator().begin(DrawMode.DEBUG_LINE_STRIP, VertexFormats.POSITION_COLOR);
         var5.vertex(var4, var1.x, var1.y, 0.0F).color(var3.getRGB());
         var5.vertex(var4, var2.x, var2.y, 0.0F).color(var3.getRGB());
         BufferRenderer.drawWithGlobalProgram(var5.end());
         III_method_b23d625f();
      } finally {
         RenderSystem.disableBlend();
         RenderSystem.lineWidth(1.0F);
         var0.pop();
      }
   }

   public static void I_method_b485d5d5(MatrixStack var0, Vec2f var1, Vec2f var2, Vec2f var3, Vec2f var4, ColorRGBA var5, int var6) {
      var0.push();

      try {
         Matrix4f var7 = var0.peek().getPositionMatrix();
         int var8 = I_method_d3347317(var1, var2, var3, var4, var6);
         RenderSystem.enableBlend();
         RenderSystem.defaultBlendFunc();
         RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
         RenderSystem.lineWidth(1.0F);
         ii_method_eecab942();
         BufferBuilder var9 = RenderSystem.renderThreadTesselator().begin(DrawMode.DEBUG_LINE_STRIP, VertexFormats.POSITION_COLOR);

         for (int var10 = 0; var10 <= var8; var10++) {
            float var11 = (float)var10 / var8;
            float var12 = (float)iIIiiiiiI_Class319.I_method_7f6601cd(var11, var1.x, var2.x, var3.x, var4.x);
            float var13 = (float)iIIiiiiiI_Class319.I_method_7f6601cd(var11, var1.y, var2.y, var3.y, var4.y);
            var9.vertex(var7, var12, var13, 0.0F).color(var5.getRGB());
         }

         BufferRenderer.drawWithGlobalProgram(var9.end());
         III_method_b23d625f();
      } finally {
         RenderSystem.disableBlend();
         RenderSystem.lineWidth(1.0F);
         var0.pop();
      }
   }

   public static void I_method_7154cfb0(
      MatrixStack var0, float var1, float var2, float var3, float var4, Vec2f var5, Vec2f var6, Vec2f var7, Vec2f var8, float var9, ColorRGBA var10
   ) {
      if (!I_method_b06b6e43(var3, var4) && !(var9 <= 0.0F) && !I_method_7ff3e064(var10)) {
         var0.push();
         Matrix4f var11 = var0.peek().getPositionMatrix();
         iIi_field_2f5b1d2c.I_method_33f6c16b();
         iIi_field_2f5b1d2c.I_method_cb7dbe45("Size").set(var3, var4);
         iIi_field_2f5b1d2c.I_method_cb7dbe45("P0").set(var5.x - var1, var5.y - var2);
         iIi_field_2f5b1d2c.I_method_cb7dbe45("P1").set(var6.x - var1, var6.y - var2);
         iIi_field_2f5b1d2c.I_method_cb7dbe45("P2").set(var7.x - var1, var7.y - var2);
         iIi_field_2f5b1d2c.I_method_cb7dbe45("P3").set(var8.x - var1, var8.y - var2);
         iIi_field_2f5b1d2c.I_method_cb7dbe45("Thickness").set(var9);
         ii_method_eecab942();
         BufferBuilder var12 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
         var12.vertex(var11, var1, var2, 0.0F).color(var10.getRGB());
         var12.vertex(var11, var1, var2 + var4, 0.0F).color(var10.getRGB());
         var12.vertex(var11, var1 + var3, var2 + var4, 0.0F).color(var10.getRGB());
         var12.vertex(var11, var1 + var3, var2, 0.0F).color(var10.getRGB());
         BufferRenderer.drawWithGlobalProgram(var12.end());
         III_method_b23d625f();
         var0.pop();
      }
   }

   public static void I_method_fce64af9(MatrixStack var0, float[] var1, float[] var2, float var3, ColorRGBA var4, ColorRGBA var5) {
      if (var1 != null && var2 != null && var1.length >= 2 && var1.length == var2.length) {
         if (!I_method_7ff3e064(var4) || !I_method_7ff3e064(var5)) {
            iIiiiiIii_Class380.I_method_5f4b621f();
            var0.push();

            try {
               Matrix4f var6 = var0.peek().getPositionMatrix();
               RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
               ii_method_eecab942();
               BufferBuilder var7 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
               int var8 = var4.getRGB();
               int var9 = var5.getRGB();

               for (int var10 = 0; var10 < var1.length - 1; var10++) {
                  float var11 = var1[var10];
                  float var12 = var1[var10 + 1];
                  float var13 = Math.min(var2[var10], var3);
                  float var14 = Math.min(var2[var10 + 1], var3);
                  var7.vertex(var6, var11, var13, 0.0F).color(var8);
                  var7.vertex(var6, var11, var3, 0.0F).color(var9);
                  var7.vertex(var6, var12, var3, 0.0F).color(var9);
                  var7.vertex(var6, var12, var14, 0.0F).color(var8);
               }

               BufferRenderer.drawWithGlobalProgram(var7.end());
               III_method_b23d625f();
            } finally {
               var0.pop();
            }
         }
      }
   }

   private static int I_method_d3347317(Vec2f var0, Vec2f var1, Vec2f var2, Vec2f var3, int var4) {
      if (var4 <= 1) {
         return 1;
      } else {
         float var5 = I_method_93c5dccf(var0, var1) + I_method_93c5dccf(var1, var2) + I_method_93c5dccf(var2, var3);
         if (Float.isFinite(var5) && !(var5 <= 0.0F)) {
            int var6 = Math.max(1, Math.round(var5));
            int var7 = Math.max(1, I_field_587075c2.getScaledWidth() + I_field_587075c2.getScaledHeight());
            return Math.min(var4, Math.min(var6, var7));
         } else {
            return 1;
         }
      }
   }

   private static float I_method_93c5dccf(Vec2f var0, Vec2f var1) {
      return (float)Math.hypot(var1.x - var0.x, var1.y - var0.y);
   }

   private static float I_method_2764e511(float var0, float var1, float var2, float var3, float var4) {
      float var5 = 1.0F - var0;
      float var6 = var0 * var0;
      float var7 = var5 * var5;
      return var7 * var5 * var1 + 3.0F * var7 * var0 * var2 + 3.0F * var5 * var6 * var3 + var6 * var0 * var4;
   }

   public static void I_method_64122a2e(MatrixStack var0, float var1, float var2, float var3, float var4, ColorRGBA var5) {
      if (!I_method_b06b6e43(var3, var4) && !I_method_7ff3e064(var5)) {
         if (iIiiiiIiI_Class379.i_method_941b0f15() instanceof iiIIIIIii_Class388 var9) {
            BufferBuilder var11 = var9.I_method_b8b8cc9e();
            Matrix4f var12 = var9.I_method_6b24b2e9().peek().getPositionMatrix();
            var11.vertex(var12, var1, var2 + var4, 0.0F).color(var5.getRGB());
            var11.vertex(var12, var1 + var3, var2 + var4, 0.0F).color(var5.getRGB());
            var11.vertex(var12, var1 + var3, var2, 0.0F).color(var5.getRGB());
            var11.vertex(var12, var1, var2, 0.0F).color(var5.getRGB());
         } else {
            iIiiiiIii_Class380 var6 = iIiiiiIii_Class380.II_method_752e8438();
            if (var6 != null) {
               var6.I_method_a5119c30(var0.peek().getPositionMatrix(), var1, var2, var3, var4, var5);
            } else {
               var0.push();
               Matrix4f var10 = var0.peek().getPositionMatrix();
               RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
               ii_method_eecab942();
               BufferBuilder var8 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
               var8.vertex(var10, var1, var2 + var4, 0.0F).color(var5.getRGB());
               var8.vertex(var10, var1 + var3, var2 + var4, 0.0F).color(var5.getRGB());
               var8.vertex(var10, var1 + var3, var2, 0.0F).color(var5.getRGB());
               var8.vertex(var10, var1, var2, 0.0F).color(var5.getRGB());
               BufferRenderer.drawWithGlobalProgram(var8.end());
               III_method_b23d625f();
               var0.pop();
            }
         }
      }
   }

   public static void I_method_9215be48(MatrixStack var0, float var1, float var2, float var3, float var4, float var5, IIiii_Class8 var6, ColorRGBA var7) {
      if (!I_method_b06b6e43(var3, var4) && !I_method_7ff3e064(var7)) {
         var0.push();
         Matrix4f var8 = var0.peek().getPositionMatrix();
         float var9 = 0.5F;
         if (iIiiiiIiI_Class379.i_method_941b0f15() instanceof iiIIIIiiI_Class391 var18) {
            var18.I_method_f92c6454(
               var8,
               var1,
               var2,
               var3,
               var4,
               var6.I_method_b483cecf() * var5 / 2.0F,
               var6.Ii_method_dc139032() * var5 / 2.0F,
               var6.i_method_b4925aaf() * var5 / 2.0F,
               var6.II_method_dc050452() * var5 / 2.0F,
               var7.getRGB()
            );
            var0.pop();
         } else {
            iIiiiiIii_Class380 var10 = iIiiiiIii_Class380.II_method_752e8438();
            if (var10 != null) {
               var10.I_method_10bfca4a(var8, var1, var2, var3, var4, var5, var6, var7);
               var0.pop();
            } else {
               ii_field_2f5b1d2c.I_method_33f6c16b();
               ii_field_2f5b1d2c.I_method_cb7dbe45("Size").set(var3, var4);
               ii_field_2f5b1d2c.I_method_cb7dbe45("Radius")
                  .set(
                     var6.I_method_b483cecf() * var5 / 2.0F,
                     var6.Ii_method_dc139032() * var5 / 2.0F,
                     var6.i_method_b4925aaf() * var5 / 2.0F,
                     var6.II_method_dc050452() * var5 / 2.0F
                  );
               ii_field_2f5b1d2c.I_method_cb7dbe45("Smoothness").set(var9);
               ii_field_2f5b1d2c.I_method_cb7dbe45("CornerSmoothness").set(var5);
               ii_method_eecab942();
               float var19 = -var9 / 2.0F + var9 * 2.0F;
               float var12 = var9 / 2.0F + var9;
               float var13 = var1 - var19 / 2.0F;
               float var14 = var2 - var12 / 2.0F;
               float var15 = var3 + var19;
               float var16 = var4 + var12;
               BufferBuilder var17 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
               var17.vertex(var8, var13, var14, 0.0F).color(var7.getRGB());
               var17.vertex(var8, var13, var14 + var16, 0.0F).color(var7.getRGB());
               var17.vertex(var8, var13 + var15, var14 + var16, 0.0F).color(var7.getRGB());
               var17.vertex(var8, var13 + var15, var14, 0.0F).color(var7.getRGB());
               BufferRenderer.drawWithGlobalProgram(var17.end());
               III_method_b23d625f();
               var0.pop();
            }
         }
      }
   }

   public static void I_method_43fbeb57(
      MatrixStack var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      IIiii_Class8 var6,
      ColorRGBA var7,
      ColorRGBA var8,
      ColorRGBA var9,
      ColorRGBA var10
   ) {
      if (!I_method_b06b6e43(var3, var4) && (!I_method_7ff3e064(var7) || !I_method_7ff3e064(var8) || !I_method_7ff3e064(var9) || !I_method_7ff3e064(var10))) {
         iIiiiiIii_Class380 var11 = iIiiiiIii_Class380.II_method_752e8438();
         if (var11 != null && var11.II_method_8a2fd926()) {
            var0.push();
            Matrix4f var21 = var0.peek().getPositionMatrix();
            IIiii_Class8 var22 = new IIiii_Class8(
               var6.I_method_b483cecf() * var5 / 2.0F,
               var6.i_method_b4925aaf() * var5 / 2.0F,
               var6.II_method_dc050452() * var5 / 2.0F,
               var6.Ii_method_dc139032() * var5 / 2.0F
            );
            var11.I_method_873c50e1(var21, var1, var2, var3, var4, var22, 0.5F, var5, var7, var8, var9, var10, false);
            var0.pop();
         } else {
            iIiiiiIii_Class380.I_method_5f4b621f();
            var0.push();
            Matrix4f var12 = var0.peek().getPositionMatrix();
            float var13 = 0.5F;
            ii_field_2f5b1d2c.I_method_33f6c16b();
            ii_field_2f5b1d2c.I_method_cb7dbe45("Size").set(var3, var4);
            ii_field_2f5b1d2c.I_method_cb7dbe45("Radius")
               .set(
                  var6.I_method_b483cecf() * var5 / 2.0F,
                  var6.Ii_method_dc139032() * var5 / 2.0F,
                  var6.i_method_b4925aaf() * var5 / 2.0F,
                  var6.II_method_dc050452() * var5 / 2.0F
               );
            ii_field_2f5b1d2c.I_method_cb7dbe45("Smoothness").set(var13);
            ii_field_2f5b1d2c.I_method_cb7dbe45("CornerSmoothness").set(var5);
            ii_method_eecab942();
            float var14 = -var13 / 2.0F + var13 * 2.0F;
            float var15 = var13 / 2.0F + var13;
            float var16 = var1 - var14 / 2.0F;
            float var17 = var2 - var15 / 2.0F;
            float var18 = var3 + var14;
            float var19 = var4 + var15;
            BufferBuilder var20 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
            var20.vertex(var12, var16, var17, 0.0F).color(var7.getRGB());
            var20.vertex(var12, var16, var17 + var19, 0.0F).color(var8.getRGB());
            var20.vertex(var12, var16 + var18, var17 + var19, 0.0F).color(var9.getRGB());
            var20.vertex(var12, var16 + var18, var17, 0.0F).color(var10.getRGB());
            BufferRenderer.drawWithGlobalProgram(var20.end());
            III_method_b23d625f();
            var0.pop();
         }
      }
   }

   public static void I_method_8fd5f68f(MatrixStack var0, float var1, float var2, float var3, float var4, float var5, IIiii_Class8 var6, IiIIi_Class10 var7) {
      I_method_43fbeb57(
         var0, var1, var2, var3, var4, var5, var6, var7.I_method_7774556e(), var7.i_method_ff5b614e(), var7.Ii_method_d6e89691(), var7.II_method_4f018ab1()
      );
   }

   public static void i_method_b39d0e68(MatrixStack var0, float var1, float var2, float var3, float var4, float var5, IIiii_Class8 var6, ColorRGBA var7) {
      if (!I_method_b06b6e43(var3, var4) && !I_method_7ff3e064(var7)) {
         iIiiiiIii_Class380.I_method_5f4b621f();
         var0.push();
         Matrix4f var8 = var0.peek().getPositionMatrix();
         float var9 = 0.5F;
         iii_field_2f5b1d2c.I_method_33f6c16b();
         iii_field_2f5b1d2c.I_method_cb7dbe45("Size").set(var3, var4);
         iii_field_2f5b1d2c.I_method_cb7dbe45("Radius")
            .set(var6.I_method_b483cecf(), var6.Ii_method_dc139032(), var6.i_method_b4925aaf(), var6.II_method_dc050452());
         iii_field_2f5b1d2c.I_method_cb7dbe45("Smoothness").set(var9);
         iii_field_2f5b1d2c.I_method_cb7dbe45("Progress").set(var5);
         iii_field_2f5b1d2c.I_method_cb7dbe45("StripeWidth").set(0.0F);
         iii_field_2f5b1d2c.I_method_cb7dbe45("Fade").set(0.5F);
         ii_method_eecab942();
         float var10 = -var9 / 2.0F + var9 * 2.0F;
         float var11 = var9 / 2.0F + var9;
         float var12 = var1 - var10 / 2.0F;
         float var13 = var2 - var11 / 2.0F;
         float var14 = var3 + var10;
         float var15 = var4 + var11;
         BufferBuilder var16 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
         var16.vertex(var8, var12, var13, 0.0F).color(var7.getRGB());
         var16.vertex(var8, var12, var13 + var15, 0.0F).color(var7.getRGB());
         var16.vertex(var8, var12 + var14, var13 + var15, 0.0F).color(var7.getRGB());
         var16.vertex(var8, var12 + var14, var13, 0.0F).color(var7.getRGB());
         BufferRenderer.drawWithGlobalProgram(var16.end());
         III_method_b23d625f();
         var0.pop();
      }
   }

   public static void I_method_78e2b35d(
      MatrixStack var0,
      float var1,
      float var2,
      float var3,
      float var4,
      IIiii_Class8 var5,
      ColorRGBA var6,
      float var7,
      float var8,
      ColorRGBA var9,
      float var10,
      boolean var11,
      float var12,
      float var13,
      float var14,
      boolean var15
   ) {
      if (!I_method_b06b6e43(var3, var4) && !I_method_7ff3e064(var6) && !(var7 <= 0.0F)) {
         iIiiiiIii_Class380.I_method_5f4b621f();
         Matrix4f var16 = var0.peek().getPositionMatrix();
         IIII_field_2f5b1d2c.I_method_33f6c16b();
         RenderSystem.setShaderTexture(0, var15 ? I_field_cb35e4c.getColorAttachment() : I_method_49b4f9f2());
         IIII_field_2f5b1d2c.I_method_cb7dbe45("GlobalAlpha").set(var7);
         IIII_field_2f5b1d2c.I_method_cb7dbe45("Size").set(var3, var4);
         IIII_field_2f5b1d2c.I_method_cb7dbe45("Radius")
            .set(var5.I_method_b483cecf(), var5.Ii_method_dc139032(), var5.i_method_b4925aaf(), var5.II_method_dc050452());
         IIII_field_2f5b1d2c.I_method_cb7dbe45("Smoothness").set(0.5F);
         IIII_field_2f5b1d2c.I_method_cb7dbe45("FresnelPower").set(var8);
         IIII_field_2f5b1d2c.I_method_cb7dbe45("FresnelColor").set(iIiiIIIiI_Class355.i_method_61b3b89d(var9.getRGB()));
         IIII_field_2f5b1d2c.I_method_cb7dbe45("FresnelAlpha").set(iIiiIIIiI_Class355.Ii_method_2e9e0e51(var9.getRGB()));
         IIII_field_2f5b1d2c.I_method_cb7dbe45("BaseAlpha").set(var10);
         IIII_field_2f5b1d2c.I_method_cb7dbe45("FresnelInvert").set(var11 ? 1 : 0);
         IIII_field_2f5b1d2c.I_method_cb7dbe45("FresnelMix").set(var12);
         IIII_field_2f5b1d2c.I_method_cb7dbe45("DistortStrength").set(InterfaceModule.II_method_bbf78cf2());
         IIII_field_2f5b1d2c.I_method_cb7dbe45("DistortRadius").set(InterfaceModule.Ii_method_bc0618d2());
         IIII_field_2f5b1d2c.I_method_cb7dbe45("Aberration").set(InterfaceModule.iI_method_bdba7d12());
         IIII_field_2f5b1d2c.I_method_cb7dbe45("Saturation").set(InterfaceModule.ii_method_bdc908f2());
         IIII_field_2f5b1d2c.I_method_cb7dbe45("CornerSmoothness").set(var14);
         ii_method_eecab942();
         RenderSystem.disableCull();
         int var17 = I_field_587075c2.getScaledWidth();
         int var18 = I_field_587075c2.getScaledHeight();
         float var19;
         float var20;
         float var21;
         float var22;
         if (!MatrixUtil.isIdentity(var16)) {
            Vector3f var23 = new Vector3f(var1, var2, 0.0F);
            Vector3f var24 = new Vector3f(var1 + var3, var2 + var4, 0.0F);
            var16.transformPosition(var23);
            var16.transformPosition(var24);
            var19 = var23.x / var17;
            var20 = (var18 - var23.y - (var24.y - var23.y)) / var18;
            var21 = (var24.x - var23.x) / var17;
            var22 = (var24.y - var23.y) / var18;
         } else {
            var19 = var1 / var17;
            var20 = (var18 - var2 - var4) / var18;
            var21 = var3 / var17;
            var22 = var4 / var18;
         }

         BufferBuilder var25 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
         var25.vertex(var16, var1, var2, 0.0F).texture(var19, var20 + var22).color(var6.getRGB());
         var25.vertex(var16, var1, var2 + var4, 0.0F).texture(var19, var20).color(var6.getRGB());
         var25.vertex(var16, var1 + var3, var2 + var4, 0.0F).texture(var19 + var21, var20).color(var6.getRGB());
         var25.vertex(var16, var1 + var3, var2, 0.0F).texture(var19 + var21, var20 + var22).color(var6.getRGB());
         BufferRenderer.drawWithGlobalProgram(var25.end());
         RenderSystem.setShaderTexture(0, 0);
         RenderSystem.enableCull();
         III_method_b23d625f();
      }
   }

   public static void I_method_34145f56(
      Rect var0,
      MatrixStack var1,
      float var2,
      float var3,
      float var4,
      float var5,
      IIiii_Class8 var6,
      ColorRGBA var7,
      float var8,
      float var9,
      ColorRGBA var10,
      float var11,
      boolean var12,
      float var13,
      float var14,
      float var15,
      int var16
   ) {
      iIiiiiIii_Class380.I_method_5f4b621f();
      Matrix4f var17 = var1.peek().getPositionMatrix();
      IIII_field_2f5b1d2c.I_method_33f6c16b();
      RenderSystem.setShaderTexture(0, var16);
      IIII_field_2f5b1d2c.I_method_cb7dbe45("GlobalAlpha").set(var8);
      IIII_field_2f5b1d2c.I_method_cb7dbe45("Size").set(var4, var5);
      IIII_field_2f5b1d2c.I_method_cb7dbe45("Radius")
         .set(var6.I_method_b483cecf(), var6.Ii_method_dc139032(), var6.i_method_b4925aaf(), var6.II_method_dc050452());
      IIII_field_2f5b1d2c.I_method_cb7dbe45("Smoothness").set(0.5F);
      IIII_field_2f5b1d2c.I_method_cb7dbe45("FresnelPower").set(var9);
      IIII_field_2f5b1d2c.I_method_cb7dbe45("FresnelColor").set(iIiiIIIiI_Class355.i_method_61b3b89d(var10.getRGB()));
      IIII_field_2f5b1d2c.I_method_cb7dbe45("FresnelAlpha").set(iIiiIIIiI_Class355.Ii_method_2e9e0e51(var10.getRGB()));
      IIII_field_2f5b1d2c.I_method_cb7dbe45("BaseAlpha").set(var11);
      IIII_field_2f5b1d2c.I_method_cb7dbe45("FresnelInvert").set(var12 ? 1 : 0);
      IIII_field_2f5b1d2c.I_method_cb7dbe45("FresnelMix").set(var13);
      IIII_field_2f5b1d2c.I_method_cb7dbe45("DistortStrength").set(InterfaceModule.II_method_bbf78cf2());
      IIII_field_2f5b1d2c.I_method_cb7dbe45("DistortRadius").set(InterfaceModule.Ii_method_bc0618d2());
      IIII_field_2f5b1d2c.I_method_cb7dbe45("Aberration").set(InterfaceModule.iI_method_bdba7d12());
      IIII_field_2f5b1d2c.I_method_cb7dbe45("Saturation").set(InterfaceModule.ii_method_bdc908f2());
      IIII_field_2f5b1d2c.I_method_cb7dbe45("CornerSmoothness").set(var15);
      ii_method_eecab942();
      RenderSystem.disableCull();
      float var18 = var0.getWidth();
      float var19 = var0.getHeight();
      float var20;
      float var21;
      float var22;
      float var23;
      if (!MatrixUtil.isIdentity(var17)) {
         Vector3f var24 = new Vector3f(var2, var3, 0.0F);
         Vector3f var25 = new Vector3f(var2 + var4, var3 + var5, 0.0F);
         var17.transformPosition(var24);
         var17.transformPosition(var25);
         float var26 = var24.x;
         float var27 = var24.y;
         float var28 = var25.x - var24.x;
         float var29 = var25.y - var24.y;
         var20 = (var26 - var0.getX()) / var18;
         var21 = (var27 - var0.getY()) / var19 + var29 / var19;
         var22 = var28 / var18;
         var23 = -var29 / var19;
      } else {
         var20 = (var2 - var0.getX()) / var18;
         var21 = (var3 - var0.getY()) / var19 + var5 / var19;
         var22 = var4 / var18;
         var23 = -var5 / var19;
      }

      BufferBuilder var30 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
      var30.vertex(var17, var2, var3, 0.0F).texture(var20, var21 + var23).color(var7.getRGB());
      var30.vertex(var17, var2, var3 + var5, 0.0F).texture(var20, var21).color(var7.getRGB());
      var30.vertex(var17, var2 + var4, var3 + var5, 0.0F).texture(var20 + var22, var21).color(var7.getRGB());
      var30.vertex(var17, var2 + var4, var3, 0.0F).texture(var20 + var22, var21 + var23).color(var7.getRGB());
      BufferRenderer.drawWithGlobalProgram(var30.end());
      RenderSystem.setShaderTexture(0, 0);
      RenderSystem.enableCull();
      III_method_b23d625f();
   }

   public static void I_method_4e16a74a(MatrixStack var0, float var1, float var2, float var3, float var4, IIiii_Class8 var5, ColorRGBA var6) {
      if (!I_method_b06b6e43(var3, var4) && !I_method_7ff3e064(var6)) {
         var0.push();
         Matrix4f var7 = var0.peek().getPositionMatrix();
         float var8 = 0.5F;
         iIiiiiIiI_Class379 var9 = iIiiiiIiI_Class379.i_method_941b0f15();
         if (var9 != null && var9.I_method_27af5b70(var7, var1, var2, var3, var4, var5, var6.getRGB())) {
            var0.pop();
         } else {
            iIiiiiIii_Class380 var10 = iIiiiiIii_Class380.II_method_752e8438();
            if (var10 != null) {
               var10.I_method_7da1308(var7, var1, var2, var3, var4, var5, var6);
               var0.pop();
            } else {
               I_field_2f5b1d2c.I_method_33f6c16b();
               I_field_2f5b1d2c.I_method_cb7dbe45("Size").set(var3, var4);
               I_field_2f5b1d2c.I_method_cb7dbe45("Radius")
                  .set(var5.I_method_b483cecf(), var5.Ii_method_dc139032(), var5.i_method_b4925aaf(), var5.II_method_dc050452());
               I_field_2f5b1d2c.I_method_cb7dbe45("Smoothness").set(var8);
               ii_method_eecab942();
               float var11 = -var8 / 2.0F + var8 * 2.0F;
               float var12 = var8 / 2.0F + var8;
               float var13 = var1 - var11 / 2.0F;
               float var14 = var2 - var12 / 2.0F;
               float var15 = var3 + var11;
               float var16 = var4 + var12;
               BufferBuilder var17 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
               var17.vertex(var7, var13, var14, 0.0F).color(var6.getRGB());
               var17.vertex(var7, var13, var14 + var16, 0.0F).color(var6.getRGB());
               var17.vertex(var7, var13 + var15, var14 + var16, 0.0F).color(var6.getRGB());
               var17.vertex(var7, var13 + var15, var14, 0.0F).color(var6.getRGB());
               BufferRenderer.drawWithGlobalProgram(var17.end());
               III_method_b23d625f();
               var0.pop();
            }
         }
      }
   }

   public static void I_method_942be315(
      MatrixStack var0, float var1, float var2, float var3, float var4, IIiii_Class8 var5, ColorRGBA var6, ColorRGBA var7, ColorRGBA var8, ColorRGBA var9
   ) {
      if (!I_method_b06b6e43(var3, var4) && (!I_method_7ff3e064(var6) || !I_method_7ff3e064(var7) || !I_method_7ff3e064(var8) || !I_method_7ff3e064(var9))) {
         iIiiiiIii_Class380 var10 = iIiiiiIii_Class380.II_method_752e8438();
         if (var10 != null && var10.II_method_8a2fd926()) {
            var0.push();
            Matrix4f var20 = var0.peek().getPositionMatrix();
            var10.I_method_873c50e1(var20, var1, var2, var3, var4, var5, 0.5F, 2.0F, var6, var7, var8, var9, true);
            var0.pop();
         } else {
            iIiiiiIii_Class380.I_method_5f4b621f();
            var0.push();
            Matrix4f var11 = var0.peek().getPositionMatrix();
            float var12 = 0.5F;
            IIIi_field_2f5b1d2c.I_method_33f6c16b();
            IIIi_field_2f5b1d2c.I_method_cb7dbe45("Size").set(var3, var4);
            IIIi_field_2f5b1d2c.I_method_cb7dbe45("Radius")
               .set(var5.I_method_b483cecf(), var5.Ii_method_dc139032(), var5.i_method_b4925aaf(), var5.II_method_dc050452());
            IIIi_field_2f5b1d2c.I_method_cb7dbe45("Smoothness").set(var12);
            IIIi_field_2f5b1d2c.I_method_cb7dbe45("TopLeftColor")
               .set(var6.getRed() / 255.0F, var6.getGreen() / 255.0F, var6.getBlue() / 255.0F, var6.getAlpha() / 255.0F);
            IIIi_field_2f5b1d2c.I_method_cb7dbe45("BottomLeftColor")
               .set(var7.getRed() / 255.0F, var7.getGreen() / 255.0F, var7.getBlue() / 255.0F, var7.getAlpha() / 255.0F);
            IIIi_field_2f5b1d2c.I_method_cb7dbe45("BottomRightColor")
               .set(var8.getRed() / 255.0F, var8.getGreen() / 255.0F, var8.getBlue() / 255.0F, var8.getAlpha() / 255.0F);
            IIIi_field_2f5b1d2c.I_method_cb7dbe45("TopRightColor")
               .set(var9.getRed() / 255.0F, var9.getGreen() / 255.0F, var9.getBlue() / 255.0F, var9.getAlpha() / 255.0F);
            ii_method_eecab942();
            float var13 = -var12 / 2.0F + var12 * 2.0F;
            float var14 = var12 / 2.0F + var12;
            float var15 = var1 - var13 / 2.0F;
            float var16 = var2 - var14 / 2.0F;
            float var17 = var3 + var13;
            float var18 = var4 + var14;
            BufferBuilder var19 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
            var19.vertex(var11, var15, var16, 0.0F).color(var6.getRGB());
            var19.vertex(var11, var15, var16 + var18, 0.0F).color(var7.getRGB());
            var19.vertex(var11, var15 + var17, var16 + var18, 0.0F).color(var8.getRGB());
            var19.vertex(var11, var15 + var17, var16, 0.0F).color(var9.getRGB());
            BufferRenderer.drawWithGlobalProgram(var19.end());
            III_method_b23d625f();
            var0.pop();
         }
      }
   }

   public static void I_method_8573da11(MatrixStack var0, float var1, float var2, float var3, float var4, IIiii_Class8 var5, IiIIi_Class10 var6) {
      I_method_942be315(
         var0, var1, var2, var3, var4, var5, var6.I_method_7774556e(), var6.i_method_ff5b614e(), var6.Ii_method_d6e89691(), var6.II_method_4f018ab1()
      );
   }

   public static void II_method_a4465a65(MatrixStack var0, float var1, float var2, float var3, float var4, float var5, IIiii_Class8 var6, ColorRGBA var7) {
      if (!I_method_b06b6e43(var3, var4) && !(var5 <= 0.0F) && !I_method_7ff3e064(var7)) {
         var0.push();
         Matrix4f var8 = var0.peek().getPositionMatrix();
         float var9 = 0.5F;
         float var10 = 1.0F;
         iIiiiiIii_Class380 var11 = iIiiiiIii_Class380.II_method_752e8438();
         if (var11 != null) {
            var11.II_method_dc0a434d(var8, var1, var2, var3, var4, var5, var6, var7);
            var0.pop();
         } else {
            Iii_field_2f5b1d2c.I_method_33f6c16b();
            Iii_field_2f5b1d2c.I_method_cb7dbe45("Size").set(var3, var4);
            Iii_field_2f5b1d2c.I_method_cb7dbe45("Radius")
               .set(var6.I_method_b483cecf(), var6.Ii_method_dc139032(), var6.i_method_b4925aaf(), var6.II_method_dc050452());
            Iii_field_2f5b1d2c.I_method_cb7dbe45("Smoothness").set(var9, var10);
            Iii_field_2f5b1d2c.I_method_cb7dbe45("Thickness").set(var5);
            ii_method_eecab942();
            float var12 = -var10 / 2.0F + var10 * 2.0F;
            float var13 = var10 / 2.0F + var10;
            float var14 = var1 - var12 / 2.0F;
            float var15 = var2 - var13 / 2.0F;
            float var16 = var3 + var12;
            float var17 = var4 + var13;
            BufferBuilder var18 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
            var18.vertex(var8, var14, var15, 0.0F).color(var7.getRGB());
            var18.vertex(var8, var14, var15 + var17, 0.0F).color(var7.getRGB());
            var18.vertex(var8, var14 + var16, var15 + var17, 0.0F).color(var7.getRGB());
            var18.vertex(var8, var14 + var16, var15, 0.0F).color(var7.getRGB());
            BufferRenderer.drawWithGlobalProgram(var18.end());
            III_method_b23d625f();
            var0.pop();
         }
      }
   }

   public static void I_method_36dfa408(
      MatrixStack var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      IIiii_Class8 var6,
      float var7,
      float var8,
      ColorRGBA var9,
      float var10,
      float var11,
      float var12,
      float var13
   ) {
      if (!I_method_b06b6e43(var3, var4) && !(var5 <= 0.0F) && !I_method_7ff3e064(var9)) {
         var0.push();
         Matrix4f var14 = var0.peek().getPositionMatrix();
         float var15 = 0.5F;
         float var16 = 1.0F;
         iII_field_2f5b1d2c.I_method_33f6c16b();
         iII_field_2f5b1d2c.I_method_cb7dbe45("Size").set(var3, var4);
         iII_field_2f5b1d2c.I_method_cb7dbe45("Radius")
            .set(var6.I_method_b483cecf(), var6.Ii_method_dc139032(), var6.i_method_b4925aaf(), var6.II_method_dc050452());
         iII_field_2f5b1d2c.I_method_cb7dbe45("Smoothness").set(var15, var16);
         iII_field_2f5b1d2c.I_method_cb7dbe45("Thickness").set(var5);
         iII_field_2f5b1d2c.I_method_cb7dbe45("DashLength").set(var7);
         iII_field_2f5b1d2c.I_method_cb7dbe45("GapLength").set(var8);
         iII_field_2f5b1d2c.I_method_cb7dbe45("Dashed").set(var10, var11, var12, var13);
         ii_method_eecab942();
         float var17 = -var16 / 2.0F + var16 * 2.0F;
         float var18 = var16 / 2.0F + var16;
         float var19 = var1 - var17 / 2.0F;
         float var20 = var2 - var18 / 2.0F;
         float var21 = var3 + var17;
         float var22 = var4 + var18;
         BufferBuilder var23 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
         var23.vertex(var14, var19, var20, 0.0F).color(var9.getRGB());
         var23.vertex(var14, var19, var20 + var22, 0.0F).color(var9.getRGB());
         var23.vertex(var14, var19 + var21, var20 + var22, 0.0F).color(var9.getRGB());
         var23.vertex(var14, var19 + var21, var20, 0.0F).color(var9.getRGB());
         BufferRenderer.drawWithGlobalProgram(var23.end());
         III_method_b23d625f();
         var0.pop();
      }
   }

   public static void I_method_cdf9870a(
      MatrixStack var0, float var1, float var2, float var3, float var4, float var5, float var6, IIiii_Class8 var7, ColorRGBA var8
   ) {
      if (!I_method_b06b6e43(var3, var4) && !(var5 <= 0.0F) && !I_method_7ff3e064(var8)) {
         var0.push();
         Matrix4f var9 = var0.peek().getPositionMatrix();
         float var10 = 0.5F;
         float var11 = 0.5F;
         iIiiiiIii_Class380 var12 = iIiiiiIii_Class380.II_method_752e8438();
         if (var12 != null) {
            var12.I_method_2490fb48(var9, var1, var2, var3, var4, var5, var6, var7, var8);
            var0.pop();
         } else {
            iiI_field_2f5b1d2c.I_method_33f6c16b();
            iiI_field_2f5b1d2c.I_method_cb7dbe45("Size").set(var3, var4);
            iiI_field_2f5b1d2c.I_method_cb7dbe45("Radius")
               .set(
                  var7.I_method_b483cecf() * var6 / 2.0F,
                  var7.Ii_method_dc139032() * var6 / 2.0F,
                  var7.i_method_b4925aaf() * var6 / 2.0F,
                  var7.II_method_dc050452() * var6 / 2.0F
               );
            iiI_field_2f5b1d2c.I_method_cb7dbe45("Smoothness").set(var10, var11);
            iiI_field_2f5b1d2c.I_method_cb7dbe45("Thickness").set(var5);
            iiI_field_2f5b1d2c.I_method_cb7dbe45("CornerSmoothness").set(var6);
            ii_method_eecab942();
            float var13 = -var11 / 2.0F + var11 * 2.0F;
            float var14 = var11 / 2.0F + var11;
            float var15 = var1 - var13 / 2.0F;
            float var16 = var2 - var14 / 2.0F;
            float var17 = var3 + var13;
            float var18 = var4 + var14;
            BufferBuilder var19 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
            var19.vertex(var9, var15, var16, 0.0F).color(var8.getRGB());
            var19.vertex(var9, var15, var16 + var18, 0.0F).color(var8.getRGB());
            var19.vertex(var9, var15 + var17, var16 + var18, 0.0F).color(var8.getRGB());
            var19.vertex(var9, var15 + var17, var16, 0.0F).color(var8.getRGB());
            BufferRenderer.drawWithGlobalProgram(var19.end());
            III_method_b23d625f();
            var0.pop();
         }
      }
   }

   public static void I_method_1c6a5031(MatrixStack var0, Identifier var1, float var2, float var3, float var4, float var5, ColorRGBA var6) {
      if (var1 != null && !I_method_b06b6e43(var4, var5) && !I_method_7ff3e064(var6)) {
         if (iIiiiiIiI_Class379.i_method_941b0f15() instanceof iiIIIIIiI_Class387 var10) {
            BufferBuilder var12 = var10.I_method_b8b8cc9e();
            Matrix4f var13 = var10.I_method_79f172c9().peek().getPositionMatrix();
            RenderSystem.setShaderTexture(0, var1);
            var12.vertex(var13, var2, var3, 0.0F).texture(0.0F, 0.0F).color(var6.getRGB());
            var12.vertex(var13, var2, var3 + var5, 0.0F).texture(0.0F, 1.0F).color(var6.getRGB());
            var12.vertex(var13, var2 + var4, var3 + var5, 0.0F).texture(1.0F, 1.0F).color(var6.getRGB());
            var12.vertex(var13, var2 + var4, var3, 0.0F).texture(1.0F, 0.0F).color(var6.getRGB());
         } else {
            iIiiiiIii_Class380 var7 = iIiiiiIii_Class380.II_method_752e8438();
            if (var7 != null) {
               var7.I_method_51cad0d5(
                  I_field_3a9bda27.getTextureManager().getTexture(var1).getGlId(),
                  var0.peek().getPositionMatrix(),
                  var2,
                  var3,
                  var4,
                  var5,
                  0.0F,
                  0.0F,
                  1.0F,
                  1.0F,
                  var6
               );
            } else {
               var0.push();
               Matrix4f var11 = var0.peek().getPositionMatrix();
               RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
               RenderSystem.setShaderTexture(0, var1);
               ii_method_eecab942();
               BufferBuilder var9 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
               var9.vertex(var11, var2, var3, 0.0F).texture(0.0F, 0.0F).color(var6.getRGB());
               var9.vertex(var11, var2, var3 + var5, 0.0F).texture(0.0F, 1.0F).color(var6.getRGB());
               var9.vertex(var11, var2 + var4, var3 + var5, 0.0F).texture(1.0F, 1.0F).color(var6.getRGB());
               var9.vertex(var11, var2 + var4, var3, 0.0F).texture(1.0F, 0.0F).color(var6.getRGB());
               BufferRenderer.drawWithGlobalProgram(var9.end());
               III_method_b23d625f();
               RenderSystem.setShaderTexture(0, 0);
               var0.pop();
            }
         }
      }
   }

   public static void I_method_30d83731(
      MatrixStack var0, Identifier var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, ColorRGBA var10
   ) {
      if (var1 != null && !I_method_b06b6e43(var4, var5) && !I_method_7ff3e064(var10)) {
         if (iIiiiiIiI_Class379.i_method_941b0f15() instanceof iiIIIIIiI_Class387 var17) {
            BufferBuilder var19 = var17.I_method_b8b8cc9e();
            Matrix4f var20 = var17.I_method_79f172c9().peek().getPositionMatrix();
            RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
            RenderSystem.setShaderTexture(0, var1);
            int var21 = var10.getRGB();
            float var22 = var2 + var4;
            float var23 = var3 + var5;
            var19.vertex(var20, var2, var3, 0.0F).texture(var6, var8).color(var21);
            var19.vertex(var20, var2, var23, 0.0F).texture(var6, var9).color(var21);
            var19.vertex(var20, var22, var23, 0.0F).texture(var7, var9).color(var21);
            var19.vertex(var20, var22, var3, 0.0F).texture(var7, var8).color(var21);
         } else {
            iIiiiiIii_Class380 var11 = iIiiiiIii_Class380.II_method_752e8438();
            if (var11 != null) {
               var11.I_method_51cad0d5(
                  I_field_3a9bda27.getTextureManager().getTexture(var1).getGlId(),
                  var0.peek().getPositionMatrix(),
                  var2,
                  var3,
                  var4,
                  var5,
                  var6,
                  var8,
                  var7,
                  var9,
                  var10
               );
            } else {
               RenderSystem.enableBlend();
               RenderSystem.defaultBlendFunc();
               var0.push();
               int var18 = var10.getRGB();
               Matrix4f var13 = var0.peek().getPositionMatrix();
               float var14 = var2 + var4;
               float var15 = var3 + var5;
               RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
               RenderSystem.setShaderTexture(0, var1);
               BufferBuilder var16 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
               var16.vertex(var13, var2, var3, 0.0F).texture(var6, var8).color(var18);
               var16.vertex(var13, var2, var15, 0.0F).texture(var6, var9).color(var18);
               var16.vertex(var13, var14, var15, 0.0F).texture(var7, var9).color(var18);
               var16.vertex(var13, var14, var3, 0.0F).texture(var7, var8).color(var18);
               BufferRenderer.drawWithGlobalProgram(var16.end());
               III_method_b23d625f();
               RenderSystem.setShaderTexture(0, 0);
               var0.pop();
               RenderSystem.disableBlend();
            }
         }
      }
   }

   public static void I_method_e888eaca(MatrixStack var0, iiIIIiiiI_Class399 var1, float var2, float var3, float var4, float var5, ColorRGBA var6) {
      if (var1 != null) {
         I_method_30d83731(
            var0,
            var1.I_method_b91e816e(),
            var2,
            var3,
            var4,
            var5,
            var1.I_method_d93d924f(),
            var1.II_method_4e83b0d2(),
            var1.i_method_d94c1e2f(),
            var1.Ii_method_4e923cb2(),
            var6
         );
      }
   }

   public static void I_method_53b46eca(MatrixStack var0, iiIIIiIII_Class393 var1, float var2, float var3, float var4, float var5, ColorRGBA var6) {
      I_method_30d83731(
         var0,
         RockstarClient.id(var1.I_method_757dbb95().I_method_10abec01()),
         var2,
         var3,
         var4,
         var5,
         var1.I_field_46 / var1.I_method_757dbb95().I_method_dd17f66f(),
         (var1.I_field_46 + var1.I_method_757dbb95().II_method_c5f5d0b2()) / var1.I_method_757dbb95().I_method_dd17f66f(),
         0.0F,
         1.0F,
         var6
      );
   }

   public static void I_method_df29c398(MatrixStack var0, Identifier var1, float var2, float var3, float var4, float var5, IIiii_Class8 var6) {
      I_method_e1f86de7(var0, var1, var2, var3, var4, var5, var6, IiiiiIIIi_Class242.Ii_field_d0c8ec5);
   }

   public static void I_method_e1f86de7(MatrixStack var0, Identifier var1, float var2, float var3, float var4, float var5, IIiii_Class8 var6, ColorRGBA var7) {
      if (var1 != null && !I_method_b06b6e43(var4, var5) && !I_method_7ff3e064(var7)) {
         var0.push();
         Matrix4f var8 = var0.peek().getPositionMatrix();
         float var9 = 0.5F;
         float var10 = -var9 / 2.0F + var9 * 2.0F;
         float var11 = var9 / 2.0F + var9;
         float var12 = var2 - var10 / 2.0F;
         float var13 = var3 - var11 / 2.0F;
         float var14 = var4 + var10;
         float var15 = var5 + var11;
         iIiiiiIii_Class380 var16 = iIiiiiIii_Class380.II_method_752e8438();
         if (var16 != null) {
            var16.I_method_1f4737a9(
               I_field_3a9bda27.getTextureManager().getTexture(var1).getGlId(),
               var8,
               var12,
               var13,
               var14,
               var15,
               0.0F,
               0.0F,
               1.0F,
               1.0F,
               var4,
               var5,
               var6.I_method_b483cecf(),
               var6.Ii_method_dc139032(),
               var6.i_method_b4925aaf(),
               var6.II_method_dc050452(),
               var9,
               var7
            );
            var0.pop();
         } else {
            iIiiiiIii_Class380.I_method_5f4b621f();
            III_field_2f5b1d2c.I_method_33f6c16b();
            RenderSystem.setShaderTexture(0, var1);
            III_field_2f5b1d2c.I_method_cb7dbe45("Size").set(var4, var5);
            III_field_2f5b1d2c.I_method_cb7dbe45("Radius")
               .set(var6.I_method_b483cecf(), var6.Ii_method_dc139032(), var6.i_method_b4925aaf(), var6.II_method_dc050452());
            III_field_2f5b1d2c.I_method_cb7dbe45("Smoothness").set(var9);
            ii_method_eecab942();
            BufferBuilder var17 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
            var17.vertex(var8, var12, var13, 0.0F).texture(0.0F, 0.0F).color(var7.getRGB());
            var17.vertex(var8, var12, var13 + var15, 0.0F).texture(0.0F, 1.0F).color(var7.getRGB());
            var17.vertex(var8, var12 + var14, var13 + var15, 0.0F).texture(1.0F, 1.0F).color(var7.getRGB());
            var17.vertex(var8, var12 + var14, var13, 0.0F).texture(1.0F, 0.0F).color(var7.getRGB());
            BufferRenderer.drawWithGlobalProgram(var17.end());
            III_method_b23d625f();
            RenderSystem.setShaderTexture(0, 0);
            var0.pop();
         }
      }
   }

   public static void Ii_method_c5cdaa85(MatrixStack var0, float var1, float var2, float var3, float var4, float var5, IIiii_Class8 var6, ColorRGBA var7) {
      if (!I_method_b06b6e43(var3, var4) && !(var5 <= 0.0F) && !I_method_7ff3e064(var7)) {
         var0.push();
         Matrix4f var8 = var0.peek().getPositionMatrix();
         if (iIiiiiIiI_Class379.i_method_941b0f15() instanceof iiIIIIIiI_Class387 var17) {
            BufferBuilder var19 = var17.I_method_b8b8cc9e();
            float var20 = -var5 / 2.0F + var5 * 2.0F;
            float var21 = var5 / 2.0F + var5;
            float var22 = var1 - var20 / 2.0F;
            float var23 = var2 - var21 / 2.0F;
            float var24 = var3 + var20;
            float var25 = var4 + var21;
            var19.vertex(var8, var22, var23, 0.0F).color(var7.getRGB());
            var19.vertex(var8, var22, var23 + var25, 0.0F).color(var7.getRGB());
            var19.vertex(var8, var22 + var24, var23 + var25, 0.0F).color(var7.getRGB());
            var19.vertex(var8, var22 + var24, var23, 0.0F).color(var7.getRGB());
            var0.pop();
         } else {
            iIiiiiIii_Class380 var9 = iIiiiiIii_Class380.II_method_752e8438();
            if (var9 != null) {
               var9.i_method_10ab962a(var8, var1, var2, var3, var4, var5, var6, var7);
               var0.pop();
            } else {
               I_field_2f5b1d2c.I_method_33f6c16b();
               I_field_2f5b1d2c.I_method_cb7dbe45("Size").set(var3, var4);
               I_field_2f5b1d2c.I_method_cb7dbe45("Radius")
                  .set(var6.I_method_b483cecf() * 3.0F, var6.Ii_method_dc139032() * 3.0F, var6.i_method_b4925aaf() * 3.0F, var6.II_method_dc050452() * 3.0F);
               I_field_2f5b1d2c.I_method_cb7dbe45("Smoothness").set(var5);
               ii_method_eecab942();
               float var18 = -var5 / 2.0F + var5 * 2.0F;
               float var11 = var5 / 2.0F + var5;
               float var12 = var1 - var18 / 2.0F;
               float var13 = var2 - var11 / 2.0F;
               float var14 = var3 + var18;
               float var15 = var4 + var11;
               BufferBuilder var16 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
               var16.vertex(var8, var12, var13, 0.0F).color(var7.getRGB());
               var16.vertex(var8, var12, var13 + var15, 0.0F).color(var7.getRGB());
               var16.vertex(var8, var12 + var14, var13 + var15, 0.0F).color(var7.getRGB());
               var16.vertex(var8, var12 + var14, var13, 0.0F).color(var7.getRGB());
               BufferRenderer.drawWithGlobalProgram(var16.end());
               III_method_b23d625f();
               var0.pop();
            }
         }
      }
   }

   public static void I_method_cbcb647(float var0, float var1, IIiii_Class8 var2) {
      if (!(var0 <= 0.0F)) {
         I_field_6425294c.i_method_54fa74c1(2.0F);
         IiI_field_2f5b1d2c.I_method_33f6c16b();
         RenderSystem.setShaderTexture(0, I_method_49b4f9f2());
         IiI_field_2f5b1d2c.I_method_cb7dbe45("Size")
            .set(I_field_3a9bda27.getWindow().getScaledWidth() * 2.0F, I_field_3a9bda27.getWindow().getScaledHeight() * 2.0F);
         IiI_field_2f5b1d2c.I_method_cb7dbe45("Radius")
            .set(
               var2.I_method_b483cecf() * var1 / 2.0F,
               var2.Ii_method_dc139032() * var1 / 2.0F,
               var2.i_method_b4925aaf() * var1 / 2.0F,
               var2.II_method_dc050452() * var1 / 2.0F
            );
         IiI_field_2f5b1d2c.I_method_cb7dbe45("Smoothness").set(0.1F);
         IiI_field_2f5b1d2c.I_method_cb7dbe45("CornerSmoothness").set(var1);
         IiI_field_2f5b1d2c.I_method_cb7dbe45("ScreenSize").set(I_field_3a9bda27.getWindow().getScaledWidth(), I_field_3a9bda27.getWindow().getScaledHeight());
         ii_method_eecab942();
         RenderSystem.enableDepthTest();
         RenderSystem.disableCull();
         RenderSystem.depthMask(false);
      }
   }

   public static void iI_method_eebc2d62() {
      III_method_b23d625f();
      RenderSystem.depthMask(true);
      RenderSystem.setShaderTexture(0, 0);
      RenderSystem.disableBlend();
      RenderSystem.setShaderTexture(0, 0);
   }

   public static void i_method_619fda4e(MatrixStack var0, float var1, float var2, float var3, float var4, ColorRGBA var5) {
      Matrix4f var6 = var0.peek().getPositionMatrix();
      float var7 = 0.03F;
      float var8 = -var7 / 2.0F + var7 * 2.0F;
      float var9 = var7 / 2.0F + var7;
      float var10 = var1 - var8 / 2.0F;
      float var11 = var2 - var9 / 2.0F;
      float var12 = var3 + var8;
      float var13 = var4 + var9;
      int var14 = I_field_3a9bda27.getWindow().getScaledWidth();
      int var15 = I_field_3a9bda27.getWindow().getScaledHeight();
      float var16 = var10 / var14;
      float var17 = (var15 - var11 - var13) / var15;
      float var18 = var12 / var14;
      float var19 = var13 / var15;
      BufferBuilder var20 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
      var20.vertex(var6, var10, var11, 0.0F).texture(var16, var17 + var19).color(var5.getRGB());
      var20.vertex(var6, var10, var11 + var13, 0.0F).texture(var16, var17).color(var5.getRGB());
      var20.vertex(var6, var10 + var12, var11 + var13, 0.0F).texture(var16 + var18, var17).color(var5.getRGB());
      var20.vertex(var6, var10 + var12, var11, 0.0F).texture(var16 + var18, var17 + var19).color(var5.getRGB());
      BufferRenderer.drawWithGlobalProgram(var20.end());
   }

   public static void I_method_35d20793(iIiiiiIii_Class380.Nested1_ea483980 var0, List<iIiiiiIii_Class380.Nested1_ea4839a0> var1) {
      if (var0 != null && var1 != null && !var1.isEmpty()) {
         if (var0.I_method_6409ba3e()) {
            IIi_field_2f5b1d2c.I_method_33f6c16b();
            IIi_field_2f5b1d2c.I_method_cb7dbe45("Size").set(var0.I_method_6409ba2a(), var0.i_method_6418460a());
            IIi_field_2f5b1d2c.I_method_cb7dbe45("Radius")
               .set(var0.II_method_1d3c8457(), var0.Ii_method_1d4b1037(), var0.iI_method_1eff7477(), var0.ii_method_1f0e0057());
            IIi_field_2f5b1d2c.I_method_cb7dbe45("Smoothness").set(var0.III_method_8a62ffca());
            IIi_field_2f5b1d2c.I_method_cb7dbe45("CornerSmoothness").set(var0.IIi_method_8a718baa());
         } else {
            III_field_2f5b1d2c.I_method_33f6c16b();
            III_field_2f5b1d2c.I_method_cb7dbe45("Size").set(var0.I_method_6409ba2a(), var0.i_method_6418460a());
            III_field_2f5b1d2c.I_method_cb7dbe45("Radius")
               .set(var0.II_method_1d3c8457(), var0.Ii_method_1d4b1037(), var0.iI_method_1eff7477(), var0.ii_method_1f0e0057());
            III_field_2f5b1d2c.I_method_cb7dbe45("Smoothness").set(var0.III_method_8a62ffca());
         }

         RenderSystem.setShaderTexture(0, var0.I_method_6409ba2d());
         ii_method_eecab942();
         BufferBuilder var2 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);

         for (iIiiiiIii_Class380.Nested1_ea4839a0 var4 : var1) {
            var2.vertex(var4.I_method_add3b238(), var4.I_method_9aa4ce0a(), var4.i_method_9ab359ea(), 0.0F)
               .texture(var4.iI_method_bbc6dc97(), var4.ii_method_bbd56877())
               .color(var4.I_method_9aa4ce0d());
            var2.vertex(var4.I_method_add3b238(), var4.I_method_9aa4ce0a(), var4.i_method_9ab359ea() + var4.Ii_method_ba127857(), 0.0F)
               .texture(var4.iI_method_bbc6dc97(), var4.IIi_method_8697278a())
               .color(var4.I_method_9aa4ce0d());
            var2.vertex(
                  var4.I_method_add3b238(), var4.I_method_9aa4ce0a() + var4.II_method_ba03ec77(), var4.i_method_9ab359ea() + var4.Ii_method_ba127857(), 0.0F
               )
               .texture(var4.III_method_86889baa(), var4.IIi_method_8697278a())
               .color(var4.I_method_9aa4ce0d());
            var2.vertex(var4.I_method_add3b238(), var4.I_method_9aa4ce0a() + var4.II_method_ba03ec77(), var4.i_method_9ab359ea(), 0.0F)
               .texture(var4.III_method_86889baa(), var4.ii_method_bbd56877())
               .color(var4.I_method_9aa4ce0d());
         }

         BufferRenderer.drawWithGlobalProgram(var2.end());
         III_method_b23d625f();
         RenderSystem.setShaderTexture(0, 0);
      }
   }

   public static void I_method_3ed5d708(
      MatrixStack var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      IIiii_Class8 var12,
      ColorRGBA var13
   ) {
      I_method_63dda827(var0, 0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13);
   }

   public static void I_method_63dda827(
      MatrixStack var0,
      int var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      IIiii_Class8 var13,
      ColorRGBA var14
   ) {
      if (!I_method_b06b6e43(var4, var5) && !I_method_7ff3e064(var14) && I_field_6424b12c.I_method_5711f408(var1)) {
         if (!iIiiiiIii_Class380.I_field_5a) {
            var0.push();
            Matrix4f var15 = var0.peek().getPositionMatrix();
            int var16 = I_field_3a9bda27.getWindow().getScaledWidth();
            int var17 = I_field_3a9bda27.getWindow().getScaledHeight();
            float var18;
            float var19;
            float var20;
            float var21;
            if (!MatrixUtil.isIdentity(var15)) {
               Vector3f var22 = new Vector3f(var2, var3, 0.0F);
               Vector3f var23 = new Vector3f(var2 + var4, var3 + var5, 0.0F);
               var15.transformPosition(var22);
               var15.transformPosition(var23);
               var18 = var22.x / var16;
               var19 = (var17 - var22.y - (var23.y - var22.y)) / var17;
               var20 = (var23.x - var22.x) / var16;
               var21 = (var23.y - var22.y) / var17;
            } else {
               var18 = var2 / var16;
               var19 = (var17 - var3 - var5) / var17;
               var20 = var4 / var16;
               var21 = var5 / var17;
            }

            IiIi_field_2f5b1d2c.I_method_33f6c16b();
            RenderSystem.setShaderTexture(0, I_field_6424b12c.I_method_5711f3f7(var1));
            IiIi_field_2f5b1d2c.I_method_cb7dbe45("Size").set(var4, var5);
            IiIi_field_2f5b1d2c.I_method_cb7dbe45("Radius")
               .set(var13.I_method_b483cecf(), var13.Ii_method_dc139032(), var13.i_method_b4925aaf(), var13.II_method_dc050452());
            IiIi_field_2f5b1d2c.I_method_cb7dbe45("Smoothness").set(var6);
            IiIi_field_2f5b1d2c.I_method_cb7dbe45("FadeStart").set(var7);
            IiIi_field_2f5b1d2c.I_method_cb7dbe45("FadeEnd").set(var8);
            IiIi_field_2f5b1d2c.I_method_cb7dbe45("ClampMin").set(var9 / var16, (var17 - (var10 + var12)) / var17);
            IiIi_field_2f5b1d2c.I_method_cb7dbe45("ClampMax").set((var9 + var11) / var16, (var17 - var10) / var17);
            ii_method_eecab942();
            BufferBuilder var24 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
            var24.vertex(var15, var2, var3, 0.0F).texture(var18, var19 + var21).color(var14.getRGB());
            var24.vertex(var15, var2, var3 + var5, 0.0F).texture(var18, var19).color(var14.getRGB());
            var24.vertex(var15, var2 + var4, var3 + var5, 0.0F).texture(var18 + var20, var19).color(var14.getRGB());
            var24.vertex(var15, var2 + var4, var3, 0.0F).texture(var18 + var20, var19 + var21).color(var14.getRGB());
            BufferRenderer.drawWithGlobalProgram(var24.end());
            III_method_b23d625f();
            RenderSystem.setShaderTexture(0, 0);
            var0.pop();
         }
      }
   }

   public static void i_method_dd5c3aea(
      MatrixStack var0, float var1, float var2, float var3, float var4, float var5, float var6, IIiii_Class8 var7, ColorRGBA var8
   ) {
      if (!I_method_b06b6e43(var3, var4) && !(var5 <= 0.0F) && !I_method_7ff3e064(var8)) {
         var5 /= 22.5F;
         if (!(var5 <= 0.0F)) {
            var0.push();
            Matrix4f var9 = var0.peek().getPositionMatrix();
            float var10 = 0.03F;
            float var11 = -var10 / 2.0F + var10 * 2.0F;
            float var12 = var10 / 2.0F + var10;
            float var13 = var1 - var11 / 2.0F;
            float var14 = var2 - var12 / 2.0F;
            float var15 = var3 + var11;
            float var16 = var4 + var12;
            int var17 = I_field_3a9bda27.getWindow().getScaledWidth();
            int var18 = I_field_3a9bda27.getWindow().getScaledHeight();
            float var19;
            float var20;
            float var21;
            float var22;
            if (!MatrixUtil.isIdentity(var9)) {
               Vector3f var23 = new Vector3f(var13, var14, 0.0F);
               Vector3f var24 = new Vector3f(var13 + var15, var14 + var16, 0.0F);
               var9.transformPosition(var23);
               var9.transformPosition(var24);
               var19 = var23.x / var17;
               var20 = (var18 - var23.y - (var24.y - var23.y)) / var18;
               var21 = (var24.x - var23.x) / var17;
               var22 = (var24.y - var23.y) / var18;
            } else {
               var19 = var13 / var17;
               var20 = (var18 - var14 - var16) / var18;
               var21 = var15 / var17;
               var22 = var16 / var18;
            }

            I_field_6425294c.i_method_54fa74c1(2.0F);
            iIiiiiIii_Class380 var26 = iIiiiiIii_Class380.II_method_752e8438();
            if (var26 != null) {
               var26.I_method_6b23ad5(
                  I_method_49b4f9f2(),
                  var9,
                  var13,
                  var14,
                  var15,
                  var16,
                  var19,
                  var20 + var22,
                  var19 + var21,
                  var20,
                  var3,
                  var4,
                  var7.I_method_b483cecf() * var6 / 2.0F,
                  var7.Ii_method_dc139032() * var6 / 2.0F,
                  var7.i_method_b4925aaf() * var6 / 2.0F,
                  var7.II_method_dc050452() * var6 / 2.0F,
                  0.1F,
                  var6,
                  var8
               );
               var0.pop();
            } else {
               IIi_field_2f5b1d2c.I_method_33f6c16b();
               RenderSystem.setShaderTexture(0, I_method_49b4f9f2());
               IIi_field_2f5b1d2c.I_method_cb7dbe45("Size").set(var3, var4);
               IIi_field_2f5b1d2c.I_method_cb7dbe45("Radius")
                  .set(
                     var7.I_method_b483cecf() * var6 / 2.0F,
                     var7.Ii_method_dc139032() * var6 / 2.0F,
                     var7.i_method_b4925aaf() * var6 / 2.0F,
                     var7.II_method_dc050452() * var6 / 2.0F
                  );
               IIi_field_2f5b1d2c.I_method_cb7dbe45("Smoothness").set(0.1F);
               IIi_field_2f5b1d2c.I_method_cb7dbe45("CornerSmoothness").set(var6);
               ii_method_eecab942();
               BufferBuilder var27 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
               var27.vertex(var9, var13, var14, 0.0F).texture(var19, var20 + var22).color(var8.getRGB());
               var27.vertex(var9, var13, var14 + var16, 0.0F).texture(var19, var20).color(var8.getRGB());
               var27.vertex(var9, var13 + var15, var14 + var16, 0.0F).texture(var19 + var21, var20).color(var8.getRGB());
               var27.vertex(var9, var13 + var15, var14, 0.0F).texture(var19 + var21, var20 + var22).color(var8.getRGB());
               BufferRenderer.drawWithGlobalProgram(var27.end());
               III_method_b23d625f();
               RenderSystem.setShaderTexture(0, 0);
               var0.pop();
            }
         }
      }
   }

   public static void iI_method_b3a90e45(MatrixStack var0, float var1, float var2, float var3, float var4, float var5, IIiii_Class8 var6, ColorRGBA var7) {
      if (!I_method_b06b6e43(var3, var4) && !(var5 <= 0.0F) && !I_method_7ff3e064(var7)) {
         var5 /= 22.5F;
         if (!(var5 <= 0.0F)) {
            var0.push();
            Matrix4f var8 = var0.peek().getPositionMatrix();
            int var9 = I_field_3a9bda27.getWindow().getScaledWidth();
            int var10 = I_field_3a9bda27.getWindow().getScaledHeight();
            float var11;
            float var12;
            float var13;
            float var14;
            if (!MatrixUtil.isIdentity(var8)) {
               Vector3f var15 = new Vector3f(var1, var2, 0.0F);
               Vector3f var16 = new Vector3f(var1 + var3, var2 + var4, 0.0F);
               var8.transformPosition(var15);
               var8.transformPosition(var16);
               var11 = var15.x / var9;
               var12 = (var10 - var15.y - (var16.y - var15.y)) / var10;
               var13 = (var16.x - var15.x) / var9;
               var14 = (var16.y - var15.y) / var10;
            } else {
               var11 = var1 / var9;
               var12 = (var10 - var2 - var4) / var10;
               var13 = var3 / var9;
               var14 = var4 / var10;
            }

            I_field_6425294c.i_method_54fa74c1(2.0F);
            iIiiiiIii_Class380 var18 = iIiiiiIii_Class380.II_method_752e8438();
            if (var18 != null) {
               var18.I_method_1f4737a9(
                  I_method_49b4f9f2(),
                  var8,
                  var1,
                  var2,
                  var3,
                  var4,
                  var11,
                  var12 + var14,
                  var11 + var13,
                  var12,
                  var3,
                  var4,
                  var6.I_method_b483cecf(),
                  var6.Ii_method_dc139032(),
                  var6.i_method_b4925aaf(),
                  var6.II_method_dc050452(),
                  0.01F,
                  var7
               );
               var0.pop();
            } else {
               III_field_2f5b1d2c.I_method_33f6c16b();
               RenderSystem.setShaderTexture(0, I_method_49b4f9f2());
               III_field_2f5b1d2c.I_method_cb7dbe45("Size").set(var3, var4);
               III_field_2f5b1d2c.I_method_cb7dbe45("Radius")
                  .set(var6.I_method_b483cecf(), var6.Ii_method_dc139032(), var6.i_method_b4925aaf(), var6.II_method_dc050452());
               III_field_2f5b1d2c.I_method_cb7dbe45("Smoothness").set(0.01F);
               ii_method_eecab942();
               BufferBuilder var19 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
               var19.vertex(var8, var1, var2, 0.0F).texture(var11, var12 + var14).color(var7.getRGB());
               var19.vertex(var8, var1, var2 + var4, 0.0F).texture(var11, var12).color(var7.getRGB());
               var19.vertex(var8, var1 + var3, var2 + var4, 0.0F).texture(var11 + var13, var12).color(var7.getRGB());
               var19.vertex(var8, var1 + var3, var2, 0.0F).texture(var11 + var13, var12 + var14).color(var7.getRGB());
               BufferRenderer.drawWithGlobalProgram(var19.end());
               III_method_b23d625f();
               RenderSystem.setShaderTexture(0, 0);
               var0.pop();
            }
         }
      }
   }

   public static void I_method_bc6b2f81(MatrixStack var0, Rect var1, float var2, float var3, float var4, float var5, IIiii_Class8 var6, float var7) {
      if (!I_method_b06b6e43(var4, var5) && !(var7 <= 0.0F)) {
         ColorRGBA var8 = ColorRGBA.WHITE.mulAlpha(var7);
         var0.push();
         Matrix4f var9 = var0.peek().getPositionMatrix();
         I_field_6425294c.i_method_54fa74c1(2.0F);
         III_field_2f5b1d2c.I_method_33f6c16b();
         RenderSystem.setShaderTexture(0, RockstarClient.id("rocknet/blur.png"));
         III_field_2f5b1d2c.I_method_cb7dbe45("Size").set(var4, var5);
         III_field_2f5b1d2c.I_method_cb7dbe45("Radius")
            .set(var6.I_method_b483cecf(), var6.Ii_method_dc139032(), var6.i_method_b4925aaf(), var6.II_method_dc050452());
         III_field_2f5b1d2c.I_method_cb7dbe45("Smoothness").set(0.5F);
         ii_method_eecab942();
         float var10 = var1.getWidth();
         float var11 = var1.getHeight();
         float var12;
         float var13;
         float var14;
         float var15;
         if (!MatrixUtil.isIdentity(var9)) {
            Vector3f var16 = new Vector3f(var2, var3, 0.0F);
            Vector3f var17 = new Vector3f(var2 + var4, var3 + var5, 0.0F);
            var9.transformPosition(var16);
            var9.transformPosition(var17);
            float var18 = var16.x;
            float var19 = var16.y;
            float var20 = var17.x - var16.x;
            float var21 = var17.y - var16.y;
            var12 = (var18 - var1.getX()) / var10;
            var13 = (var19 - var1.getY()) / var11 + var21 / var11;
            var14 = var20 / var10;
            var15 = -var21 / var11;
         } else {
            var12 = (var2 - var1.getX()) / var10;
            var13 = (var3 - var1.getY()) / var11 + var5 / var11;
            var14 = var4 / var10;
            var15 = -var5 / var11;
         }

         BufferBuilder var22 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
         var22.vertex(var9, var2, var3, 0.0F).texture(var12, var13 + var15).color(var8.getRGB());
         var22.vertex(var9, var2, var3 + var5, 0.0F).texture(var12, var13).color(var8.getRGB());
         var22.vertex(var9, var2 + var4, var3 + var5, 0.0F).texture(var12 + var14, var13).color(var8.getRGB());
         var22.vertex(var9, var2 + var4, var3, 0.0F).texture(var12 + var14, var13 + var15).color(var8.getRGB());
         BufferRenderer.drawWithGlobalProgram(var22.end());
         III_method_b23d625f();
         RenderSystem.setShaderTexture(0, 0);
         var0.pop();
      }
   }

   public static void I_method_a9f124df(MatrixStack var0, BufferBuilder var1, double var2, double var4, double var6, double var8, double var10, ColorRGBA var12) {
      if (!(var8 <= 0.0) && !(var10 <= 0.0) && !I_method_7ff3e064(var12)) {
         Matrix4f var13 = var0.peek().getPositionMatrix();
         var1.vertex(var13, (float)var2, (float)(var4 + var10), (float)var6).texture(0.0F, 1.0F).color(var12.getRGB());
         var1.vertex(var13, (float)(var2 + var8), (float)(var4 + var10), (float)var6).texture(1.0F, 1.0F).color(var12.getRGB());
         var1.vertex(var13, (float)(var2 + var8), (float)var4, (float)var6).texture(1.0F, 0.0F).color(var12.getRGB());
         var1.vertex(var13, (float)var2, (float)var4, (float)var6).texture(0.0F, 0.0F).color(var12.getRGB());
      }
   }

   public static void I_method_9433ea04(
      MatrixStack var0, BufferBuilder var1, double var2, double var4, double var6, double var8, double var10, ColorRGBA var12, int var13
   ) {
      if (!(var8 <= 0.0) && !(var10 <= 0.0) && !I_method_7ff3e064(var12)) {
         Matrix4f var14 = var0.peek().getPositionMatrix();
         float var15 = (float)var2;
         float var16 = (float)(var2 + var8);
         float var17 = (float)var4;
         float var18 = (float)(var4 + var10);
         float var19 = (float)var6;
         float var20 = 0.0F;
         float var21 = 0.0F;
         float var22 = 1.0F;
         float var23 = 1.0F;
         var13 = (var13 % 360 + 360) % 360;
         switch (var13) {
            case 0:
               var1.vertex(var14, var15, var18, var19).texture(var20, var23).color(var12.getRGB());
               var1.vertex(var14, var16, var18, var19).texture(var22, var23).color(var12.getRGB());
               var1.vertex(var14, var16, var17, var19).texture(var22, var21).color(var12.getRGB());
               var1.vertex(var14, var15, var17, var19).texture(var20, var21).color(var12.getRGB());
               break;
            case 180:
               var1.vertex(var14, var15, var18, var19).texture(var22, var21).color(var12.getRGB());
               var1.vertex(var14, var16, var18, var19).texture(var20, var21).color(var12.getRGB());
               var1.vertex(var14, var16, var17, var19).texture(var20, var23).color(var12.getRGB());
               var1.vertex(var14, var15, var17, var19).texture(var22, var23).color(var12.getRGB());
         }
      }
   }

   public static void I_method_9b41120f(MatrixStack var0, Identifier var1, double var2, double var4, double var6, double var8, double var10, ColorRGBA var12) {
      if (var1 != null && !(var8 <= 0.0) && !(var10 <= 0.0) && !I_method_7ff3e064(var12)) {
         RenderSystem.setShaderTexture(0, var1);
         BufferBuilder var13 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
         Matrix4f var14 = var0.peek().getPositionMatrix();
         var13.vertex(var14, (float)var2, (float)(var4 + var10), (float)var6).texture(0.0F, 1.0F).color(var12.getRGB());
         var13.vertex(var14, (float)(var2 + var8), (float)(var4 + var10), (float)var6).texture(1.0F, 1.0F).color(var12.getRGB());
         var13.vertex(var14, (float)(var2 + var8), (float)var4, (float)var6).texture(1.0F, 0.0F).color(var12.getRGB());
         var13.vertex(var14, (float)var2, (float)var4, (float)var6).texture(0.0F, 0.0F).color(var12.getRGB());
         BufferRenderer.drawWithGlobalProgram(var13.end());
      }
   }

   public static void I_method_2f76388b(
      MatrixStack var0, AbstractClientPlayerEntity var1, float var2, float var3, float var4, IIiii_Class8 var5, ColorRGBA var6
   ) {
      if (var1 != null && !(var4 <= 0.0F) && !I_method_7ff3e064(var6)) {
         Identifier var7 = var1.getSkinTextures().texture();
         I_method_276007cb(var0, var7, var2, var3, var4, var5, var6);
         i_method_32702bab(var0, var7, var2, var3, var4, var5, var6);
      }
   }

   public static <T extends LivingEntity, S extends LivingEntityRenderState, M extends EntityModel<? super S>> void I_method_84c2640d(
      MatrixStack var0, T var1, float var2, float var3, float var4, IIiii_Class8 var5, ColorRGBA var6
   ) {
      if (var1 != null && !(var4 <= 0.0F) && !I_method_7ff3e064(var6)) {
         EntityRenderer var7 = I_field_3a9bda27.getEntityRenderDispatcher().getRenderer(var1);
         if (var7 instanceof LivingEntityRenderer var9) {
            LivingEntityRenderer var10 = (LivingEntityRenderer)var7;
            LivingEntityRenderState var11 = (LivingEntityRenderState)var10.createRenderState();
            Identifier var8 = var10.getTexture(var11);
            I_method_276007cb(var0, var8, var2, var3, var4, var5, var6);
            i_method_32702bab(var0, var8, var2, var3, var4, var5, var6);
         }
      }
   }

   public static void I_method_276007cb(MatrixStack var0, Identifier var1, float var2, float var3, float var4, IIiii_Class8 var5, ColorRGBA var6) {
      if (var1 != null && !(var4 <= 0.0F) && !I_method_7ff3e064(var6)) {
         I_method_636d1267(var0, var1, var2, var3, var4, var4, var5, var6, 0.125F, 0.125F, 0.25F, 0.25F);
      }
   }

   private static void i_method_32702bab(MatrixStack var0, Identifier var1, float var2, float var3, float var4, IIiii_Class8 var5, ColorRGBA var6) {
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      I_method_636d1267(var0, var1, var2, var3, var4, var4, var5, var6, 0.625F, 0.125F, 0.75F, 0.25F);
      RenderSystem.disableBlend();
   }

   public static void I_method_636d1267(
      MatrixStack var0,
      Identifier var1,
      float var2,
      float var3,
      float var4,
      float var5,
      IIiii_Class8 var6,
      ColorRGBA var7,
      float var8,
      float var9,
      float var10,
      float var11
   ) {
      if (var1 != null && !I_method_b06b6e43(var4, var5) && !I_method_7ff3e064(var7)) {
         var0.push();
         Matrix4f var12 = var0.peek().getPositionMatrix();
         float var13 = 0.5F;
         float var14 = -var13 / 2.0F + var13 * 2.0F;
         float var15 = var13 / 2.0F + var13;
         float var16 = var2 - var14 / 2.0F;
         float var17 = var3 - var15 / 2.0F;
         float var18 = var4 + var14;
         float var19 = var5 + var15;
         iIiiiiIii_Class380 var20 = iIiiiiIii_Class380.II_method_752e8438();
         if (var20 != null) {
            var20.I_method_1f4737a9(
               I_field_3a9bda27.getTextureManager().getTexture(var1).getGlId(),
               var12,
               var16,
               var17,
               var18,
               var19,
               var8,
               var9,
               var10,
               var11,
               var4,
               var5,
               var6.I_method_b483cecf(),
               var6.Ii_method_dc139032(),
               var6.i_method_b4925aaf(),
               var6.II_method_dc050452(),
               var13,
               var7
            );
            var0.pop();
         } else {
            III_field_2f5b1d2c.I_method_33f6c16b();
            RenderSystem.setShaderTexture(0, var1);
            III_field_2f5b1d2c.I_method_cb7dbe45("Size").set(var4, var5);
            III_field_2f5b1d2c.I_method_cb7dbe45("Radius")
               .set(var6.I_method_b483cecf(), var6.Ii_method_dc139032(), var6.i_method_b4925aaf(), var6.II_method_dc050452());
            III_field_2f5b1d2c.I_method_cb7dbe45("Smoothness").set(var13);
            ii_method_eecab942();
            BufferBuilder var21 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
            var21.vertex(var12, var16, var17, 0.0F).texture(var8, var9).color(var7.getRGB());
            var21.vertex(var12, var16, var17 + var19, 0.0F).texture(var8, var11).color(var7.getRGB());
            var21.vertex(var12, var16 + var18, var17 + var19, 0.0F).texture(var10, var11).color(var7.getRGB());
            var21.vertex(var12, var16 + var18, var17, 0.0F).texture(var10, var9).color(var7.getRGB());
            BufferRenderer.drawWithGlobalProgram(var21.end());
            III_method_b23d625f();
            RenderSystem.setShaderTexture(0, 0);
            var0.pop();
         }
      }
   }

   public static void I_method_a5fd8671(MatrixStack var0, float var1, float var2, float var3, float var4) {
      if (!I_method_b06b6e43(var3, var4)) {
         byte var5 = -1;
         Matrix4f var6 = var0.peek().getPositionMatrix();
         BufferBuilder var7 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
         var7.vertex(var6, var1, var2, 0.0F).texture(0.0F, 1.0F).color(var5);
         var7.vertex(var6, var1, var2 + var4, 0.0F).texture(0.0F, 0.0F).color(var5);
         var7.vertex(var6, var1 + var3, var2 + var4, 0.0F).texture(1.0F, 0.0F).color(var5);
         var7.vertex(var6, var1 + var3, var2, 0.0F).texture(1.0F, 1.0F).color(var5);
         BufferRenderer.drawWithGlobalProgram(var7.end());
      }
   }

   public static void I_method_4355d27f(float var0, float var1, float var2, float var3) {
      if (!I_method_b06b6e43(var2, var3)) {
         byte var4 = -1;
         BufferBuilder var5 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
         var5.vertex(var0, var1, 0.0F).texture(0.0F, 1.0F).color(var4);
         var5.vertex(var0, var1 + var3, 0.0F).texture(0.0F, 0.0F).color(var4);
         var5.vertex(var0 + var2, var1 + var3, 0.0F).texture(1.0F, 0.0F).color(var4);
         var5.vertex(var0 + var2, var1, 0.0F).texture(1.0F, 1.0F).color(var4);
         BufferRenderer.drawWithGlobalProgram(var5.end());
      }
   }

   public static void ii_method_eecab942() {
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
   }

   public static void I_method_4a80026e(MatrixStack var0, float var1, float var2, float var3, float var4, float var5, float var6, ColorRGBA var7) {
      if (!(var3 <= 0.0F) && !(var4 <= 0.0F) && !I_method_7ff3e064(var7)) {
         iIiiiiIii_Class380.I_method_5f4b621f();
         var0.push();
         Matrix4f var8 = var0.peek().getPositionMatrix();
         float var9 = 0.5F;
         IiII_field_2f5b1d2c.I_method_33f6c16b();
         IiII_field_2f5b1d2c.I_method_cb7dbe45("Size").set(var3, var3);
         IiII_field_2f5b1d2c.I_method_cb7dbe45("Thickness").set(var4);
         IiII_field_2f5b1d2c.I_method_cb7dbe45("StartAngle").set(var5);
         IiII_field_2f5b1d2c.I_method_cb7dbe45("EndAngle").set(var6);
         IiII_field_2f5b1d2c.I_method_cb7dbe45("Smoothness").set(var9);
         ii_method_eecab942();
         float var10 = var4 + var9 * 2.0F;
         float var11 = var1 - var10 / 2.0F;
         float var12 = var2 - var10 / 2.0F;
         float var13 = var3 + var10;
         float var14 = var3 + var10;
         BufferBuilder var15 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
         var15.vertex(var8, var11, var12, 0.0F).color(var7.getRGB());
         var15.vertex(var8, var11, var12 + var14, 0.0F).color(var7.getRGB());
         var15.vertex(var8, var11 + var13, var12 + var14, 0.0F).color(var7.getRGB());
         var15.vertex(var8, var11 + var13, var12, 0.0F).color(var7.getRGB());
         BufferRenderer.drawWithGlobalProgram(var15.end());
         III_method_b23d625f();
         var0.pop();
      }
   }

   public static void I_method_580fe26(MatrixStack var0, float var1, float var2, float var3, float var4, float var5, float var6, ColorRGBA var7, boolean var8) {
      if (var8) {
         float var9 = var3 * 2.0F;
         float var10 = (float)Math.toRadians(var5 - 90.0F);
         float var11 = (float)Math.toRadians(var6 - 90.0F);
         I_method_4a80026e(var0, var1 - var3, var2 - var3, var9, var4, var10, var11, var7);
      } else {
         float var12 = (float)Math.toRadians(var5 - 90.0F);
         float var13 = (float)Math.toRadians(var6 - 90.0F);
         I_method_4a80026e(var0, var1, var2, var3 * 2.0F, var4, var12, var13, var7);
      }
   }

   public static void I_method_5b4598f0(MatrixStack var0, float var1, float var2, float var3, float var4, float var5, ColorRGBA var6) {
      float var7 = 0.0F;
      float var8 = var5 * 360.0F;
      I_method_580fe26(var0, var1, var2, var3, var4, var7, var8, var6, true);
   }

   public static void I_method_b629410f(
      MatrixStack var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13,
      float var14,
      ColorRGBA var15,
      ColorRGBA var16,
      float var17
   ) {
      if (!I_method_b06b6e43(var3, var4)) {
         iIiiiiIii_Class380.I_method_5f4b621f();
         var0.push();
         Matrix4f var18 = var0.peek().getPositionMatrix();
         IIii_field_2f5b1d2c.I_method_33f6c16b();
         IIii_field_2f5b1d2c.I_method_cb7dbe45("Size").set(var3, var4);
         IIii_field_2f5b1d2c.I_method_cb7dbe45("RectCenter").set(var5, var6);
         IIii_field_2f5b1d2c.I_method_cb7dbe45("RectHalf").set(var7, var8);
         IIii_field_2f5b1d2c.I_method_cb7dbe45("RectRadius").set(var9, var9, var9, var9);
         IIii_field_2f5b1d2c.I_method_cb7dbe45("CircleCenter").set(var10, var11);
         IIii_field_2f5b1d2c.I_method_cb7dbe45("CircleRadius").set(var12);
         IIii_field_2f5b1d2c.I_method_cb7dbe45("Smooth").set(var13);
         IIii_field_2f5b1d2c.I_method_cb7dbe45("Outline").set(var14);
         IIii_field_2f5b1d2c.I_method_cb7dbe45("FillColor")
            .set(var15.getRed() / 255.0F, var15.getGreen() / 255.0F, var15.getBlue() / 255.0F, var15.getAlpha() / 255.0F);
         IIii_field_2f5b1d2c.I_method_cb7dbe45("OutlineColor")
            .set(var16.getRed() / 255.0F, var16.getGreen() / 255.0F, var16.getBlue() / 255.0F, var16.getAlpha() / 255.0F);
         IIii_field_2f5b1d2c.I_method_cb7dbe45("GlobalAlpha").set(var17);
         ii_method_eecab942();
         byte var19 = -1;
         BufferBuilder var20 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
         var20.vertex(var18, var1, var2, 0.0F).color(var19);
         var20.vertex(var18, var1, var2 + var4, 0.0F).color(var19);
         var20.vertex(var18, var1 + var3, var2 + var4, 0.0F).color(var19);
         var20.vertex(var18, var1 + var3, var2, 0.0F).color(var19);
         BufferRenderer.drawWithGlobalProgram(var20.end());
         III_method_b23d625f();
         var0.pop();
      }
   }

   public static void III_method_b23d625f() {
      RenderSystem.disableBlend();
   }

   @Generated
   private iIiiIIiii_Class360() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }

   @Generated
   public static IiiIi_Class14 I_method_b2dd8215() {
      return ii_field_2f5b1d2c;
   }

   static final class Nested1_bb93c80 {
      private final float I_field_46;
      private final float i_field_46;
      private final float II_field_46;
      private final float Ii_field_46;

      Nested1_bb93c80(float var1, float var2, float var3, float var4) {
         this.I_field_46 = var1;
         this.i_field_46 = var2;
         this.II_field_46 = var3;
         this.Ii_field_46 = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_bb93c80[u1=" + this.I_field_46 + ", v1=" + this.i_field_46 + ", uSize=" + this.II_field_46 + ", vSize=" + this.Ii_field_46 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.Ii_field_46);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIiiIIiii_Class360.Nested1_bb93c80 other = (iIiiIIiii_Class360.Nested1_bb93c80) var1;
         return java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46);
      }

      public float I_method_9fc2972a() {
         return this.I_field_46;
      }

      public float i_method_9fd1230a() {
         return this.i_field_46;
      }

      public float II_method_589f4757() {
         return this.II_field_46;
      }

      public float Ii_method_58add337() {
         return this.Ii_field_46;
      }
   }
}
