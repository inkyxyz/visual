package pyrock.utility.render;

import com.mojang.blaze3d.systems.RenderSystem;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import jep.python.PyObject;
import net.minecraft.client.gl.ShaderProgram;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.MatrixStack.Entry;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import pyrock.events.render.Render3DEvent;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiiii_Class16;
import rockstar.client.IiIIIi_Class18;
import rockstar.client.iIiiIIiIi_Class358;
import rockstar.client.iIiiiIIiI_Class371;

public class PyRender3D {
   private static final int BILLBOARD_STRIDE = 8;
   private static final int LINE_STRIDE = 10;
   private static final int TEXT_STRIDE = 11;
   private static final float TEXT_SIZE = 32.0F;
   private static final float TEXT_SOFTNESS = 0.5F;
   private static final float[] OUTLINE_STEPS = new float[]{
      -1.0F, 0.0F, 1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 1.0F, -0.7071F, -0.7071F, 0.7071F, -0.7071F, -0.7071F, 0.7071F, 0.7071F, 0.7071F
   };
   private static final double[] EMPTY = new double[0];

   public void line(Render3DEvent var1, double var2, double var4, double var6, double var8, double var10, double var12, ColorRGBA var14) {
      this.withLines(
         var1,
         true,
         var15 -> iIiiIIiIi_Class358.I_method_d5d64e01(
            var1.getMatrices(), var15, new Vec3d(var2, var4, var6), new Vec3d(var8, var10, var12), this.safeColor(var14)
         )
      );
   }

   public void marker(Render3DEvent var1, double var2, double var4, double var6, double var8, ColorRGBA var10) {
      double var11 = Math.max(0.01, var8);
      ColorRGBA var13 = this.safeColor(var10);
      this.withLines(var1, true, var10x -> {
         MatrixStack var11x = var1.getMatrices();
         Vec3d var12 = new Vec3d(var2, var4, var6);
         iIiiIIiIi_Class358.I_method_d5d64e01(var11x, var10x, var12.add(-var11, 0.0, 0.0), var12.add(var11, 0.0, 0.0), var13);
         iIiiIIiIi_Class358.I_method_d5d64e01(var11x, var10x, var12.add(0.0, -var11, 0.0), var12.add(0.0, var11, 0.0), var13);
         iIiiIIiIi_Class358.I_method_d5d64e01(var11x, var10x, var12.add(0.0, 0.0, -var11), var12.add(0.0, 0.0, var11), var13);
      });
   }

   public void box(Render3DEvent var1, Object var2, ColorRGBA var3) {
      Box var4 = this.boxOf(var2);
      if (var4 != null) {
         this.withLines(var1, true, var4x -> iIiiIIiIi_Class358.Ii_method_c1caf816(var1.getMatrices(), var4x, var4, this.safeColor(var3)));
      }
   }

   public void boxGradient(Render3DEvent var1, Object var2, ColorRGBA var3, ColorRGBA var4) {
      Box var5 = this.boxOf(var2);
      if (var5 != null) {
         this.withLines(var1, true, var5x -> iIiiIIiIi_Class358.i_method_c95b01e6(var1.getMatrices(), var5x, var5, this.safeColor(var3), this.safeColor(var4)));
      }
   }

   public void filledBox(Render3DEvent var1, Object var2, ColorRGBA var3) {
      Box var4 = this.boxOf(var2);
      if (var4 != null) {
         this.withQuads(var1, false, var4x -> iIiiIIiIi_Class358.i_method_5e35f7b9(var1.getMatrices(), var4x, var4, this.safeColor(var3)));
      }
   }

   public void filledBoxGradient(Render3DEvent var1, Object var2, ColorRGBA var3, ColorRGBA var4) {
      Box var5 = this.boxOf(var2);
      if (var5 != null) {
         this.withQuads(var1, false, var5x -> iIiiIIiIi_Class358.I_method_b5d61e06(var1.getMatrices(), var5x, var5, this.safeColor(var3), this.safeColor(var4)));
      }
   }

   public void glowingBox(Render3DEvent var1, Object var2, ColorRGBA var3) {
      Box var4 = this.boxOf(var2);
      if (var4 != null) {
         this.withQuads(var1, true, var4x -> iIiiIIiIi_Class358.I_method_9a4e5799(var1.getMatrices(), var4x, var4, this.safeColor(var3)));
      }
   }

   public void boxAt(Render3DEvent var1, double var2, double var4, double var6, double var8, double var10, double var12, ColorRGBA var14) {
      this.box(var1, new Box(var2, var4, var6, var2 + var8, var4 + var10, var6 + var12), var14);
   }

   public void filledBoxAt(Render3DEvent var1, double var2, double var4, double var6, double var8, double var10, double var12, ColorRGBA var14) {
      this.filledBox(var1, new Box(var2, var4, var6, var2 + var8, var4 + var10, var6 + var12), var14);
   }

   public void ring(Render3DEvent var1, Object var2, double var3, double var5, int var7, ColorRGBA var8) {
      Vec3d var9 = this.centerOf(var2);
      if (var9 != null) {
         int var10 = Math.max(8, var7);
         double var11 = Math.max(0.01, var3);
         double var13 = var9.y + var5;
         ColorRGBA var15 = this.safeColor(var8);
         this.withLines(var1, true, var8x -> {
            MatrixStack var9x = var1.getMatrices();

            for (int var10x = 0; var10x < var10; var10x++) {
               double var11x = (Math.PI * 2) * var10x / var10;
               double var13x = (Math.PI * 2) * (var10x + 1) / var10;
               Vec3d var15x = new Vec3d(var9.x + Math.cos(var11x) * var11, var13, var9.z + Math.sin(var11x) * var11);
               Vec3d var16 = new Vec3d(var9.x + Math.cos(var13x) * var11, var13, var9.z + Math.sin(var13x) * var11);
               iIiiIIiIi_Class358.I_method_d5d64e01(var9x, var8x, var15x, var16, var15);
            }
         });
      }
   }

   public void target(Render3DEvent var1, Object var2, ColorRGBA var3) {
      Box var4 = this.boxOf(var2);
      if (var4 != null) {
         ColorRGBA var5 = this.safeColor(var3);
         ColorRGBA var6 = var5.mulAlpha(0.16F);
         this.filledBox(var1, var4, var6);
         this.box(var1, var4, var5);
         this.marker(var1, var4.getCenter().x, var4.maxY + 0.25, var4.getCenter().z, 0.22, var5);
         this.ring(var1, var4, Math.max(var4.getLengthX(), var4.getLengthZ()) * 0.75, -var4.getLengthY() * 0.5 + 0.04, 48, var5);
      }
   }

   public void billboard(
      Render3DEvent var1, Identifier var2, double var3, double var5, double var7, double var9, double var11, double var13, ColorRGBA var15, boolean var16
   ) {
      if (var1 != null && var2 != null && !(var9 <= 0.0) && !(var11 <= 0.0)) {
         MatrixStack var17 = var1.getMatrices();
         var17.push();

         try {
            iIiiiIIiI_Class371.I_method_642c0895(var16);
            iIiiiIIiI_Class371.i_method_49a476f1(var17);
            var17.translate(var3, var5, var7);
            var17.multiply(var1.getCamera().getRotation());
            if (var13 != 0.0) {
               var17.multiply(RotationAxis.POSITIVE_Z.rotationDegrees((float)var13));
            }

            RenderSystem.setShaderTexture(0, var2);
            RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
            BufferBuilder var18 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
            Matrix4f var19 = var17.peek().getPositionMatrix();
            float var20 = (float)(var9 / 2.0);
            float var21 = (float)(var11 / 2.0);
            int var22 = this.safeColor(var15).getRGB();
            var18.vertex(var19, -var20, -var21, 0.0F).texture(0.0F, 1.0F).color(var22);
            var18.vertex(var19, var20, -var21, 0.0F).texture(1.0F, 1.0F).color(var22);
            var18.vertex(var19, var20, var21, 0.0F).texture(1.0F, 0.0F).color(var22);
            var18.vertex(var19, -var20, var21, 0.0F).texture(0.0F, 0.0F).color(var22);
            iIiiiIIiI_Class371.I_method_c59155f0(var18);
         } finally {
            RenderSystem.setShaderTexture(0, 0);
            iIiiiIIiI_Class371.I_method_a0226e1f();
            var17.pop();
         }
      }
   }

   public void billboards(Render3DEvent var1, Identifier var2, Object var3, boolean var4) {
      if (var1 != null && var2 != null) {
         double[] var5 = unpack(var3, "billboards");
         if (var5.length >= 8) {
            MatrixStack var6 = var1.getMatrices();
            var6.push();

            try {
               iIiiiIIiI_Class371.I_method_642c0895(var4);
               iIiiiIIiI_Class371.i_method_49a476f1(var6);
               RenderSystem.setShaderTexture(0, var2);
               RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
               Quaternionf var7 = var1.getCamera().getRotation();
               Vector3f var8 = var7.transform(new Vector3f(1.0F, 0.0F, 0.0F));
               Vector3f var9 = var7.transform(new Vector3f(0.0F, 1.0F, 0.0F));
               Matrix4f var10 = var6.peek().getPositionMatrix();
               BufferBuilder var11 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);

               for (int var12 = 0; var12 + 8 <= var5.length; var12 += 8) {
                  float var13 = (float)var5[var12 + 3] * 0.5F;
                  if (!(var13 <= 0.0F)) {
                     int var14 = packColor(var5[var12 + 4], var5[var12 + 5], var5[var12 + 6], var5[var12 + 7]);
                     if (var14 >>> 24 != 0) {
                        float var15 = (float)var5[var12];
                        float var16 = (float)var5[var12 + 1];
                        float var17 = (float)var5[var12 + 2];
                        float var18 = var8.x * var13;
                        float var19 = var8.y * var13;
                        float var20 = var8.z * var13;
                        float var21 = var9.x * var13;
                        float var22 = var9.y * var13;
                        float var23 = var9.z * var13;
                        var11.vertex(var10, var15 - var18 - var21, var16 - var19 - var22, var17 - var20 - var23).texture(0.0F, 1.0F).color(var14);
                        var11.vertex(var10, var15 + var18 - var21, var16 + var19 - var22, var17 + var20 - var23).texture(1.0F, 1.0F).color(var14);
                        var11.vertex(var10, var15 + var18 + var21, var16 + var19 + var22, var17 + var20 + var23).texture(1.0F, 0.0F).color(var14);
                        var11.vertex(var10, var15 - var18 + var21, var16 - var19 + var22, var17 - var20 + var23).texture(0.0F, 0.0F).color(var14);
                     }
                  }
               }

               iIiiiIIiI_Class371.I_method_c59155f0(var11);
            } finally {
               RenderSystem.setShaderTexture(0, 0);
               iIiiiIIiI_Class371.I_method_a0226e1f();
               var6.pop();
            }
         }
      }
   }

   public void lines(Render3DEvent var1, Object var2, boolean var3) {
      if (var1 != null) {
         double[] var4 = unpack(var2, "lines");
         if (var4.length >= 10) {
            MatrixStack var5 = var1.getMatrices();
            var5.push();

            try {
               iIiiiIIiI_Class371.I_method_642c0895(var3);
               iIiiiIIiI_Class371.i_method_49a476f1(var5);
               RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
               Entry var6 = var5.peek();
               Matrix4f var7 = var6.getPositionMatrix();
               BufferBuilder var8 = RenderSystem.renderThreadTesselator().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);

               for (int var9 = 0; var9 + 10 <= var4.length; var9 += 10) {
                  int var10 = packColor(var4[var9 + 6], var4[var9 + 7], var4[var9 + 8], var4[var9 + 9]);
                  if (var10 >>> 24 != 0) {
                     float var11 = (float)var4[var9];
                     float var12 = (float)var4[var9 + 1];
                     float var13 = (float)var4[var9 + 2];
                     float var14 = (float)var4[var9 + 3];
                     float var15 = (float)var4[var9 + 4];
                     float var16 = (float)var4[var9 + 5];
                     float var17 = var14 - var11;
                     float var18 = var15 - var12;
                     float var19 = var16 - var13;
                     float var20 = (float)Math.sqrt(var17 * var17 + var18 * var18 + var19 * var19);
                     if (!(var20 <= 0.0F)) {
                        var17 /= var20;
                        var18 /= var20;
                        var19 /= var20;
                        var8.vertex(var7, var11, var12, var13).color(var10).normal(var6, var17, var18, var19);
                        var8.vertex(var7, var14, var15, var16).color(var10).normal(var6, var17, var18, var19);
                     }
                  }
               }

               iIiiiIIiI_Class371.I_method_c59155f0(var8);
            } finally {
               iIiiiIIiI_Class371.I_method_a0226e1f();
               var5.pop();
            }
         }
      }
   }

   public void texts(
      Render3DEvent var1,
      Object var2,
      Object var3,
      Object var4,
      ColorRGBA var5,
      double var6,
      int var8,
      ColorRGBA var9,
      double var10,
      double var12,
      int var14,
      int var15,
      boolean var16,
      boolean var17
   ) {
      if (var1 != null) {
         List var18 = strings(var2);
         if (!var18.isEmpty()) {
            double[] var19 = unpack(var3, "texts");
            int var20 = Math.min(var18.size(), var19.length / 11);
            if (var20 > 0) {
               IIiiii_Class16 var21 = this.fontOf(var4);
               float var22 = var21.i_method_a95baee4(32.0F);
               if (!(var22 <= 0.0F)) {
                  Vec3d var23 = var1.getCamera().getPos();
                  Vector3f var24 = var1.getCamera().getRotation().transform(new Vector3f(0.0F, 0.0F, -1.0F));
                  boolean[] var25 = new boolean[var20];
                  float[] var26 = new float[var20];

                  for (int var27 = 0; var27 < var20; var27++) {
                     int var28 = var27 * 11;
                     double var29 = var19[var28 + 3];
                     double var31 = var19[var28] - var23.x;
                     double var33 = var19[var28 + 1] - var23.y;
                     double var35 = var19[var28 + 2] - var23.z;
                     if (!(var31 * var24.x + var33 * var24.y + var35 * var24.z < -var29 * 2.0 - 0.5)) {
                        var25[var27] = true;
                        var26[var27] = var21.I_method_c000b13a((String)var18.get(var27), 32.0F);
                     }
                  }

                  MatrixStack var55 = var1.getMatrices();
                  var55.push();

                  try {
                     iIiiiIIiI_Class371.I_method_642c0895(var17);
                     if (!var16) {
                        RenderSystem.enableDepthTest();
                     }

                     iIiiiIIiI_Class371.i_method_49a476f1(var55);
                     ShaderProgram var56 = IiIIIi_Class18.I_method_1a4fabf8(0.0F, 0.5F);
                     var56.getUniform("EnableFadeout").set(0);
                     var56.getUniform("FadeoutStart").set(0.0F);
                     var56.getUniform("FadeoutEnd").set(1.0F);
                     var56.getUniform("FadeinStart").set(0.0F);
                     var56.getUniform("FadeinEnd").set(0.0F);
                     var56.getUniform("MaxWidth").set(0.0F);
                     var56.getUniform("TextPosX").set(0.0F);
                     BufferBuilder var57 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR_LIGHT);
                     float var30 = (float)(var6 * var22);
                     int var58 = Math.min(OUTLINE_STEPS.length, Math.max(0, var8) * 2);
                     boolean var32 = var5 != null && var30 > 0.0F && var58 > 0;
                     boolean var59 = var9 != null;

                     for (int var34 = 0; var34 < var20; var34++) {
                        if (var25[var34]) {
                           int var60 = var34 * 11;
                           String var36 = (String)var18.get(var34);
                           if (!var36.isEmpty()) {
                              float var37 = (float)var19[var60 + 3];
                              int var38 = packColor(var19[var60 + 4], var19[var60 + 5], var19[var60 + 6], var19[var60 + 7]);
                              if (!(var37 <= 0.0F) && var38 >>> 24 != 0) {
                                 var55.push();

                                 try {
                                    var55.translate(var19[var60], var19[var60 + 1], var19[var60 + 2]);
                                    this.face(var55, var1, var14, var19[var60 + 8], var19[var60 + 9]);
                                    float var39 = (float)var19[var60 + 10];
                                    if (var39 != 0.0F) {
                                       var55.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(var39));
                                    }

                                    float var40 = var37 / var22;
                                    var55.scale(var40, -var40, var40);
                                    Matrix4f var41 = var55.peek().getPositionMatrix();
                                    float var42 = var15 == 1 ? 0.0F : (var15 == 2 ? -var26[var34] : -var26[var34] * 0.5F);
                                    float var43 = -var22 * 0.5F;
                                    float var44 = (var38 >>> 24 & 0xFF) / 255.0F;
                                    if (var59) {
                                       var21.I_method_aaa2eff5(
                                          var41,
                                          var57,
                                          var36,
                                          32.0F,
                                          var42 + (float)(var10 * var22),
                                          var43 + (float)(var12 * var22),
                                          0.0F,
                                          faded(var9, var44),
                                          0.5F
                                       );
                                    }

                                    if (var32) {
                                       int var45 = faded(var5, var44);

                                       for (int var46 = 0; var46 < var58; var46 += 2) {
                                          var21.I_method_aaa2eff5(
                                             var41,
                                             var57,
                                             var36,
                                             32.0F,
                                             var42 + OUTLINE_STEPS[var46] * var30,
                                             var43 + OUTLINE_STEPS[var46 + 1] * var30,
                                             0.0F,
                                             var45,
                                             0.5F
                                          );
                                       }
                                    }

                                    var21.I_method_aaa2eff5(var41, var57, var36, 32.0F, var42, var43, 0.0F, var38, 0.5F);
                                 } finally {
                                    var55.pop();
                                 }
                              }
                           }
                        }
                     }

                     iIiiiIIiI_Class371.I_method_c59155f0(var57);
                  } finally {
                     IiIIIi_Class18.I_method_a6e9b62c();
                     iIiiiIIiI_Class371.I_method_a0226e1f();
                     var55.pop();
                  }
               }
            }
         }
      }
   }

   public double textWidth(String var1, double var2, Object var4) {
      IIiiii_Class16 var5 = this.fontOf(var4);
      float var6 = var5.i_method_a95baee4(32.0F);
      return !(var6 <= 0.0F) && var1 != null && !var1.isEmpty() ? var5.I_method_c000b13a(var1, 32.0F) / var6 * var2 : 0.0;
   }

   public double lineHeight(double var1, Object var3) {
      IIiiii_Class16 var4 = this.fontOf(var3);
      float var5 = var4.i_method_a95baee4(32.0F);
      return var5 <= 0.0F ? var1 : var4.II_method_4d42e7db(32.0F) / var5 * var1;
   }

   public double[] letters(String var1, double var2, Object var4) {
      if (var1 != null && !var1.isEmpty()) {
         IIiiii_Class16 var5 = this.fontOf(var4);
         float var6 = var5.i_method_a95baee4(32.0F);
         if (var6 <= 0.0F) {
            return EMPTY;
         } else {
            double var7 = var2 / var6;
            ArrayList var9 = new ArrayList();
            var5.I_method_ebff3dc7(var1, 32.0F, 0.0F, 0.0F, null, (var3, var4x, var5x, var6x, var7x) -> {
               if (var4x != null) {
                  var9.add(new double[]{var5x, var6x * var7, var4x.I_method_704ea23c() * 32.0F * var7});
               }
            });
            double[] var10 = new double[var9.size() * 3];

            for (int var11 = 0; var11 < var9.size(); var11++) {
               double[] var12 = (double[])var9.get(var11);
               var10[var11 * 3] = var12[0];
               var10[var11 * 3 + 1] = var12[1];
               var10[var11 * 3 + 2] = var12[2];
            }

            return var10;
         }
      } else {
         return EMPTY;
      }
   }

   private void face(MatrixStack var1, Render3DEvent var2, int var3, double var4, double var6) {
      switch (var3) {
         case 1:
            var1.multiply(var2.getCamera().getRotation());
            break;
         case 2:
            var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F - var2.getCamera().getYaw()));
            break;
         default:
            var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F - (float)var4));
            if (var6 != 0.0) {
               var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-((float)var6)));
            }
      }
   }

   private static int faded(ColorRGBA var0, float var1) {
      return var0.mulAlpha(var1).getRGB();
   }

   private IIiiii_Class16 fontOf(Object var1) {
      if (var1 instanceof IIiiii_Class16 var4) {
         return var4;
      } else if (var1 instanceof IIiIIi_Class10 var3) {
         return var3.I_method_36d49b4b();
      } else {
         return var1 instanceof String var2 && !var2.isBlank() ? PyAssets.slugFont(var2) : IIiIiI_Class11.i_field_857c0621;
      }
   }

   private static List<String> strings(Object var0) {
      if (var0 == null) {
         return List.of();
      } else if (var0 instanceof String var11) {
         return List.of(var11);
      } else if (var0 instanceof List var10) {
         ArrayList var13 = new ArrayList(var10.size());

         for (Object var17 : var10) {
            var13.add(var17 == null ? "" : var17.toString());
         }

         return var13;
      } else if (var0 instanceof Object[] var9) {
         ArrayList var12 = new ArrayList(var9.length);

         for (Object var6 : var9) {
            var12.add(var6 == null ? "" : var6.toString());
         }

         return var12;
      } else if (var0 instanceof Iterable var8) {
         ArrayList var2 = new ArrayList();

         for (Object var4 : var8) {
            var2.add(var4 == null ? "" : var4.toString());
         }

         return var2;
      } else {
         if (var0 instanceof PyObject var1) {
            try {
               return strings(var1.as(List.class));
            } catch (Exception var7) {
            }
         }

         throw new IllegalArgumentException(
            "texts \u0436\u0434\u0451\u0442 \u0441\u043f\u0438\u0441\u043e\u043a \u0441\u0442\u0440\u043e\u043a, \u0430 \u043f\u043e\u043b\u0443\u0447\u0438\u043b "
               + var0.getClass().getName()
         );
      }
   }

   private static double[] unpack(Object var0, String var1) {
      if (var0 == null) {
         return EMPTY;
      } else if (var0 instanceof double[] var13) {
         return var13;
      } else if (var0 instanceof byte[] var12) {
         FloatBuffer var19 = ByteBuffer.wrap(var12).order(ByteOrder.LITTLE_ENDIAN).asFloatBuffer();
         double[] var25 = new double[var19.remaining()];

         for (int var27 = 0; var27 < var25.length; var27++) {
            var25[var27] = var19.get(var27);
         }

         return var25;
      } else if (var0 instanceof float[] var11) {
         double[] var18 = new double[var11.length];

         for (int var24 = 0; var24 < var11.length; var24++) {
            var18[var24] = var11[var24];
         }

         return var18;
      } else if (var0 instanceof int[] var10) {
         double[] var17 = new double[var10.length];

         for (int var23 = 0; var23 < var10.length; var23++) {
            var17[var23] = var10[var23];
         }

         return var17;
      } else if (var0 instanceof List var9) {
         double[] var16 = new double[var9.size()];

         for (int var22 = 0; var22 < var16.length; var22++) {
            var16[var22] = number(var9.get(var22), var1);
         }

         return var16;
      } else if (var0 instanceof Object[] var8) {
         double[] var15 = new double[var8.length];

         for (int var21 = 0; var21 < var8.length; var21++) {
            var15[var21] = number(var8[var21], var1);
         }

         return var15;
      } else if (!(var0 instanceof Iterable var2)) {
         if (var0 instanceof PyObject var7) {
            List var14 = null;

            try {
               var14 = (List)var7.as(List.class);
            } catch (Exception var6) {
            }

            if (var14 != null) {
               return unpack(var14, var1);
            }
         }

         throw new IllegalArgumentException(
            var1
               + " \u0436\u0434\u0451\u0442 \u043f\u043b\u043e\u0441\u043a\u0438\u0439 \u0441\u043f\u0438\u0441\u043e\u043a \u0447\u0438\u0441\u0435\u043b, \u0430 \u043f\u043e\u043b\u0443\u0447\u0438\u043b "
               + var0.getClass().getName()
         );
      } else {
         ArrayList var3 = new ArrayList();

         for (Object var5 : var2) {
            var3.add(var5);
         }

         double[] var20 = new double[var3.size()];

         for (int var26 = 0; var26 < var20.length; var26++) {
            var20[var26] = number(var3.get(var26), var1);
         }

         return var20;
      }
   }

   private static double number(Object var0, String var1) {
      if (var0 instanceof Number var2) {
         return var2.doubleValue();
      } else {
         throw new IllegalArgumentException(
            var1
               + " \u0436\u0434\u0451\u0442 \u043f\u043b\u043e\u0441\u043a\u0438\u0439 \u0441\u043f\u0438\u0441\u043e\u043a \u0447\u0438\u0441\u0435\u043b, \u0430 \u0432 \u043d\u0451\u043c \u043b\u0435\u0436\u0438\u0442 "
               + (var0 == null ? "None" : var0.getClass().getName())
         );
      }
   }

   private static int packColor(double var0, double var2, double var4, double var6) {
      return channel(var6) << 24 | channel(var0) << 16 | channel(var2) << 8 | channel(var4);
   }

   private static int channel(double var0) {
      int var2 = (int)Math.round(var0);
      return var2 < 0 ? 0 : Math.min(var2, 255);
   }

   private void withLines(Render3DEvent var1, boolean var2, Consumer<BufferBuilder> var3) {
      this.withBuffer(var1, DrawMode.DEBUG_LINES, var2, var3);
   }

   private void withQuads(Render3DEvent var1, boolean var2, Consumer<BufferBuilder> var3) {
      this.withBuffer(var1, DrawMode.QUADS, var2, var3);
   }

   private void withBuffer(Render3DEvent var1, DrawMode var2, boolean var3, Consumer<BufferBuilder> var4) {
      if (var1 != null) {
         MatrixStack var5 = var1.getMatrices();
         var5.push();

         try {
            iIiiiIIiI_Class371.I_method_642c0895(var3);
            iIiiiIIiI_Class371.i_method_49a476f1(var5);
            RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
            BufferBuilder var6 = RenderSystem.renderThreadTesselator().begin(var2, VertexFormats.POSITION_COLOR);
            var4.accept(var6);
            iIiiiIIiI_Class371.I_method_c59155f0(var6);
         } finally {
            iIiiiIIiI_Class371.I_method_a0226e1f();
            var5.pop();
         }
      }
   }

   private Box boxOf(Object var1) {
      if (var1 instanceof Box var4) {
         return var4;
      } else if (var1 instanceof Entity var3) {
         return var3.getBoundingBox();
      } else {
         return var1 instanceof Vec3d var2 ? new Box(var2, var2).expand(0.1) : null;
      }
   }

   private Vec3d centerOf(Object var1) {
      if (var1 instanceof Vec3d var3) {
         return var3;
      } else {
         Box var2 = this.boxOf(var1);
         return var2 == null ? null : var2.getCenter();
      }
   }

   private ColorRGBA safeColor(ColorRGBA var1) {
      return var1 == null ? ColorRGBA.WHITE : var1;
   }
}
