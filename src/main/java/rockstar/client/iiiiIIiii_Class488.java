package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.List;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;

public final class iiiiIIiii_Class488 {
   private static final Identifier I_field_6a3d6525 = Identifier.of("rockstar", "textures/pathfinder/bloom.png");
   private static final ColorRGBA I_field_d0c8ec5 = new ColorRGBA(80.0F, 220.0F, 255.0F);
   private static final ColorRGBA i_field_d0c8ec5 = new ColorRGBA(120.0F, 130.0F, 150.0F);
   private static final int I_field_49 = 10;
   private final IiIIIiII_Class69<Render3DEvent> I_field_3d936f41 = var1 -> this.I_method_297cf292(var1.getMatrices(), var1.getCamera());

   public static iiiiIIiii_Class488 I_method_39ba135d(iiIiiIiIi_Class438 var0) {
      iiiiIIiii_Class488 var1 = new iiiiIIiii_Class488();
      var0.I_method_ab199998().I_method_2257cd48(var1);
      return var1;
   }

   private void I_method_297cf292(MatrixStack var1, Camera var2) {
      iiiIIIiii_Class456 var3 = iiIiiIiIi_Class438.I_method_12f562b5().I_method_3bb8fab5();
      iiiIiiiii_Class480 var4 = iiIiiIiIi_Class438.I_method_12f562b5()
         .I_method_d87feab5()
         .I_method_82bc9266()
         .filter(iiiIiiiii_Class480.class::isInstance)
         .map(iiiIiiiii_Class480.class::cast)
         .orElse(null);
      iiiIIIiiI_Class455 var5 = var3 != null ? var3.I_method_24228ed5() : null;
      iiiIIiiii_Class464 var6 = var3 != null ? var3.I_method_25e582d5() : null;
      boolean var7 = var5 != null && var5.I_method_b5439248().size() > 1;
      Vec3d var8 = var6 != null ? var6.I_method_f4d54579() : null;
      List var9 = var4 != null ? var4.I_method_4e9dbe68() : List.of();
      Vec3d var10 = var4 != null ? var4.I_method_2e6f539() : null;
      if (var7 || var8 != null || var9.size() >= 2 || var10 != null) {
         Vec3d var11 = var2.getPos();
         RenderSystem.enableBlend();
         RenderSystem.disableDepthTest();
         RenderSystem.disableCull();
         RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE);
         RenderSystem.setShaderTexture(0, I_field_6a3d6525);
         RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
         BufferBuilder var12 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
         var1.push();
         var1.translate(-var11.x, -var11.y, -var11.z);
         if (var9.size() >= 2) {
            ColorRGBA var13 = IiiiiIIIi_Class242.i_method_5dfec6e();

            for (int var14 = 0; var14 < var9.size() - 1; var14++) {
               Vec3d var15 = (Vec3d)var9.get(var14);
               Vec3d var16 = (Vec3d)var9.get(var14 + 1);

               for (int var17 = 0; var17 <= 10; var17++) {
                  float var18 = var17 / 10.0F;
                  Vec3d var19 = var15.add(var16.subtract(var15).multiply(var18));
                  this.I_method_31220912(var1, var2, var12, var19, 0.35F, 1.0F, var13);
                  this.I_method_31220912(var1, var2, var12, var19, 1.6F, 0.06F, var13);
               }
            }
         }

         if (var10 != null) {
            this.I_method_31220912(var1, var2, var12, var10, 0.8F, 1.0F, IiiiiIIIi_Class242.i_method_5dfec6e());
            this.I_method_31220912(var1, var2, var12, var10, 3.2F, 0.12F, IiiiiIIIi_Class242.i_method_5dfec6e());
         }

         if (var7) {
            int var24 = var3.I_method_7d7f71f2();

            for (int var26 = 0; var26 < var5.I_method_b5439248().size() - 1; var26++) {
               iiiIIiIIi_Class458 var27 = var5.I_method_b5439248().get(var26);
               iiiIIiIIi_Class458 var28 = var5.I_method_b5439248().get(var26 + 1);
               Vec3d var29 = new Vec3d(var27.I_method_6d204e12() + 0.5, var27.i_method_6d2ed9f2() + 0.5, var27.II_method_36f86d15() + 0.5);
               Vec3d var30 = new Vec3d(var28.I_method_6d204e12() + 0.5, var28.i_method_6d2ed9f2() + 0.5, var28.II_method_36f86d15() + 0.5);
               float var31 = (float)var29.distanceTo(var30);
               ColorRGBA var20 = IiiiiIIIi_Class242.i_method_5dfec6e();

               for (int var21 = 0; var21 <= 10; var21++) {
                  float var22 = var21 / 10.0F;
                  Vec3d var23 = var29.add(var30.subtract(var29).multiply(var22));
                  this.I_method_31220912(var1, var2, var12, var23, var31 / 3.0F, 1.0F, var20);
                  this.I_method_31220912(var1, var2, var12, var23, var31 * 2.0F, 0.05F, var20);
               }
            }
         }

         if (var8 != null) {
            Vec3d var25 = new Vec3d(var8.x, var8.y + 0.5, var8.z);
            this.I_method_31220912(var1, var2, var12, var25, 0.7F, 1.0F, IiiiiIIIi_Class242.i_method_5dfec6e());
            this.I_method_31220912(var1, var2, var12, var25, 3.0F, 0.12F, IiiiiIIIi_Class242.i_method_5dfec6e());
         }

         var1.pop();
         BufferRenderer.drawWithGlobalProgram(var12.end());
         RenderSystem.enableCull();
         RenderSystem.enableDepthTest();
         RenderSystem.disableBlend();
      }
   }

   private void I_method_31220912(MatrixStack var1, Camera var2, BufferBuilder var3, Vec3d var4, float var5, float var6, ColorRGBA var7) {
      var1.push();
      var1.translate(var4.x, var4.y, var4.z);
      var1.multiply(var2.getRotation());
      int var8 = var7.withAlpha(255.0F * var6).getRGB();
      float var9 = var5 / 2.0F;
      Matrix4f var10 = var1.peek().getPositionMatrix();
      var3.vertex(var10, -var9, var9, 0.0F).texture(0.0F, 1.0F).color(var8);
      var3.vertex(var10, var9, var9, 0.0F).texture(1.0F, 1.0F).color(var8);
      var3.vertex(var10, var9, -var9, 0.0F).texture(1.0F, 0.0F).color(var8);
      var3.vertex(var10, -var9, -var9, 0.0F).texture(0.0F, 0.0F).color(var8);
      var1.pop();
   }
}
