package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import net.minecraft.block.BlockState;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import org.joml.FrustumIntersection;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "World",
   category = ModuleCategory.VISUALS,
   III_method_a89e5834 = "modules.descriptions.world"
)
public class WorldModule extends Module {
   private final List<WorldModule.Nested1_4650c0a0> I_field_7865b31 = new ArrayList<>();
   private BooleanSetting I_field_ba20ca4c;
   private ColorSetting I_field_bbd4b66c;
   private BooleanSetting i_field_ba20ca4c;
   private SliderSetting I_field_73178e8c;
   private SliderSetting i_field_73178e8c;
   private static final int I_field_49 = 100;
   private static final float I_field_46 = 20.0F;
   private static final float i_field_46 = 1.6F;
   private static final float II_field_46 = 6.0F;
   private static final double I_field_44 = 1.2;
   private static final float Ii_field_46 = 1.0F;
   private static final int i_field_49 = 32;
   private int II_field_49;
   private final IiIIIiII_Class69<Render3DEvent> I_field_3d936f41 = var1 -> {
      if (!this.I_field_7865b31.isEmpty()) {
         ColorRGBA var2 = this.I_field_ba20ca4c.i_method_9b12da03() ? IiiiiIIIi_Class242.i_method_5dfec6e() : this.I_field_bbd4b66c.I_method_bde5f08e();
         MatrixStack var3 = var1.getMatrices();
         Camera var4 = I_field_3a9bda27.gameRenderer.getCamera();
         Vec3d var5 = var4.getPos();

         for (WorldModule.Nested1_4650c0a0 var7 : this.I_field_7865b31) {
            var7.I_field_dc7facc.I_method_edd72835(!var7.I_method_e1d8a71e());
            var7.i_field_dc7facc.I_method_edd72835(!var7.i_field_5a);
         }

         this.I_method_3c36296a(var1, var2, var5);
         var3.push();
         RenderSystem.enableBlend();
         RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE);
         RenderSystem.enableDepthTest();
         RenderSystem.disableCull();
         RenderSystem.depthMask(false);
         Identifier var14 = RockstarClient.id("textures/bloom.png");
         RenderSystem.setShaderTexture(0, var14);
         RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
         BufferBuilder var15 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);

         for (WorldModule.Nested1_4650c0a0 var9 : this.I_field_7865b31) {
            Vec3d var10 = iIiiiiIII_Class377.I_method_156f92bb(var9.I_field_5bba0d50, var9.II_field_5bba0d50, var1.getTickDelta());
            float var11 = 4.0F * var9.I_field_46;
            var3.push();
            iIiiiIIiI_Class371.I_method_7d461059(var3, var10);
            var3.multiply(var4.getRotation());
            iIiiIIiii_Class360.I_method_a9f124df(
               var3, var15, -var11 / 2.0F, -var11 / 2.0F, 0.0, var11, var11, var2.withAlpha(255.0F * var9.I_field_dc7facc.I_method_6ac4da6f() * 0.4F)
            );
            var3.pop();
         }

         BuiltBuffer var16 = var15.endNullable();
         if (var16 != null) {
            BufferRenderer.drawWithGlobalProgram(var16);
         }

         RenderSystem.depthMask(true);
         RenderSystem.setShaderTexture(0, 0);
         RenderSystem.disableBlend();
         RenderSystem.enableCull();
         RenderSystem.disableDepthTest();
         var3.pop();
         RenderSystem.enableBlend();
         RenderSystem.disableDepthTest();
         RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE);
         RenderSystem.enableDepthTest();
         RenderSystem.disableCull();
         RenderSystem.depthMask(false);
         RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
         BufferBuilder var17 = RenderSystem.renderThreadTesselator().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);

         for (WorldModule.Nested1_4650c0a0 var20 : this.I_field_7865b31) {
            Vec3d var12 = iIiiiiIII_Class377.I_method_156f92bb(var20.I_field_5bba0d50, var20.II_field_5bba0d50, var1.getTickDelta());
            Vec3d var13 = iIiiiiIII_Class377.I_method_156f92bb(var20.i_field_5bba0d50, var20.Ii_field_5bba0d50, var1.getTickDelta());
            var3.push();
            var3.translate(var12.add(-var5.getX(), -var5.getY(), -var5.getZ()));
            var3.multiply(new Quaternionf().rotationXYZ((float)var13.x, (float)var13.y, (float)var13.z));
            var3.scale(var20.I_field_46, var20.I_field_46, var20.I_field_46);
            iIiiIIiIi_Class358.II_method_fde357f6(
               var3, var17, new Box(-0.5, -0.5, -0.5, 0.5, 0.5, 0.5), var2.withAlpha(255.0F * var20.I_field_dc7facc.I_method_6ac4da6f() * 0.4F)
            );
            iIiiIIiIi_Class358.Ii_method_c1caf816(
               var3, var17, new Box(-0.5, -0.5, -0.5, 0.5, 0.5, 0.5), var2.withAlpha(205.0F * var20.I_field_dc7facc.I_method_6ac4da6f())
            );
            var3.pop();
         }

         BuiltBuffer var19 = var17.endNullable();
         if (var19 != null) {
            BufferRenderer.drawWithGlobalProgram(var19);
         }

         RenderSystem.depthMask(true);
         RenderSystem.defaultBlendFunc();
         RenderSystem.enableCull();
         RenderSystem.enableDepthTest();
         RenderSystem.disableBlend();
      }
   };
   private static final double i_field_44 = 48.0;
   private static final int Ii_field_49 = 40;
   private static final float iI_field_46 = 0.35F;
   private static final float ii_field_46 = 2.0F;
   private static final double II_field_44 = 0.5;
   private static final int iI_field_49 = 16;

   public WorldModule() {
      this.IiI_method_bf7b4e7f();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_bf7b4e7f() {
      this.I_field_ba20ca4c = new BooleanSetting(this, "theme.sync").I_method_decd82b5();
      this.I_field_bbd4b66c = new ColorSetting(this, "modules.settings.world.color", this.I_field_ba20ca4c::i_method_9b12da03)
         .I_method_a62f5dd6(IiiiiIIIi_Class242.i_method_5dfec6e());
      this.i_field_ba20ca4c = new BooleanSetting(this, "modules.settings.world.lighting");
      this.I_field_73178e8c = new SliderSetting(this, "modules.settings.world.lighting.radius", () -> !this.i_field_ba20ca4c.i_method_9b12da03())
         .I_method_c8c9a7d7(2.0F)
         .i_method_65e2aff7(7.0F)
         .II_method_b0f56334(0.5F)
         .Ii_method_4e0e6b54(4.0F)
         .I_method_d41e7abf(" blocks");
      this.i_field_73178e8c = new SliderSetting(this, "modules.settings.world.lighting.strength", () -> !this.i_field_ba20ca4c.i_method_9b12da03())
         .I_method_c8c9a7d7(0.0F)
         .i_method_65e2aff7(150.0F)
         .II_method_b0f56334(10.0F)
         .Ii_method_4e0e6b54(100.0F)
         .I_method_d41e7abf("%");
   }

   @Override
   public void onDisable() {
      this.I_field_7865b31.clear();
   }

   @Override
   public void II_method_6642fd22() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         this.I_field_7865b31.removeIf(var0 -> var0.I_field_dc7facc.I_method_6ac4da6f() == 0.0F && var0.I_method_e1d8a71e());

         for (WorldModule.Nested1_4650c0a0 var2 : this.I_field_7865b31) {
            var2.I_method_e1d8a71a();
         }

         int var5 = 0;

         for (WorldModule.Nested1_4650c0a0 var3 : this.I_field_7865b31) {
            if (!var3.I_field_5a) {
               var5++;
            }
         }

         for (int var7 = this.I_field_7865b31.size() - 1; var7 >= 0 && var5 > 100; var7--) {
            WorldModule.Nested1_4650c0a0 var9 = this.I_field_7865b31.get(var7);
            if (!var9.I_field_5a) {
               var9.I_field_5a = true;
               var5--;
            }
         }

         for (int var8 = 0; var8 < 4 && var5 < 100; var8++) {
            Vec3d var10 = this.I_method_4a7539();
            if (var10 == null) {
               break;
            }

            WorldModule.Nested1_4650c0a0 var4 = new WorldModule.Nested1_4650c0a0(
               var10,
               Vec3d.ZERO,
               new Vec3d(
                  iIIiiiiiI_Class319.I_method_b56b22f(-1.0, 1.0), iIIiiiiiI_Class319.I_method_b56b22f(0.0, 2.0), iIIiiiiiI_Class319.I_method_b56b22f(-1.0, 1.0)
               ),
               new Vec3d(
                  iIIiiiiiI_Class319.I_method_b56b22f(-1.0, 1.0),
                  iIIiiiiiI_Class319.I_method_b56b22f(-1.0, 1.0),
                  iIIiiiiiI_Class319.I_method_b56b22f(-1.0, 1.0)
               ),
               (long)iIIiiiiiI_Class319.I_method_b56b22f(1500.0, 4500.0),
               iIIiiiiiI_Class319.I_method_b56b22f(0.1F, 0.3F)
            );
            this.I_method_4e52b602(var4);
            this.I_field_7865b31.add(var4);
            var5++;
         }

         this.Iii_method_bf89da5f();
      } else {
         this.I_field_7865b31.clear();
      }
   }

   private Vec3d I_method_4a7539() {
      Vec3d var1 = null;

      for (int var2 = 0; var2 < 8; var2++) {
         Vec3d var3 = I_field_3a9bda27.player
            .getPos()
            .add(
               iIIiiiiiI_Class319.I_method_b56b22f(-20.0, 20.0),
               iIIiiiiiI_Class319.I_method_b56b22f(1.6F, 6.0),
               iIIiiiiiI_Class319.I_method_b56b22f(-20.0, 20.0)
            );
         if (!this.I_method_1b5b77af(var3)) {
            if (var1 == null) {
               var1 = var3;
            }

            if (!this.I_method_1b5b77af(var3.subtract(0.0, 1.2, 0.0))) {
               return var3;
            }
         }
      }

      return var1;
   }

   private boolean I_method_1b5b77af(Vec3d var1) {
      BlockPos var2 = BlockPos.ofFloored(var1);
      if (I_field_3a9bda27.world.isOutOfHeightLimit(var2.getY())) {
         return true;
      } else {
         BlockState var3 = I_field_3a9bda27.world.getBlockState(var2);
         if (var3.isAir()) {
            return false;
         } else {
            VoxelShape var4 = var3.getCollisionShape(I_field_3a9bda27.world, var2);
            if (var4.isEmpty()) {
               return false;
            } else {
               Vec3d var5 = var1.subtract(var2.getX(), var2.getY(), var2.getZ());

               for (Box var7 : var4.getBoundingBoxes()) {
                  if (var7.expand(0.01).contains(var5)) {
                     return true;
                  }
               }

               return false;
            }
         }
      }
   }

   private void Iii_method_bf89da5f() {
      if (!this.i_field_ba20ca4c.i_method_9b12da03()) {
         for (WorldModule.Nested1_4650c0a0 var9 : this.I_field_7865b31) {
            var9.i_field_5a = false;
         }
      } else {
         Camera var1 = I_field_3a9bda27.gameRenderer.getCamera();
         if (var1 != null) {
            Vec3d var2 = var1.getPos();
            int var3 = this.I_field_7865b31.size();
            if (var3 != 0) {
               int var4 = Math.min(var3, 40);

               for (WorldModule.Nested1_4650c0a0 var6 : this.I_field_7865b31) {
                  if (var6.II_field_5a && var4 > 0) {
                     var4--;
                     var6.i_field_5a = this.I_method_cd9c083(var2, var6.II_field_5bba0d50);
                  }
               }

               int var10 = 0;

               for (int var11 = 0; var11 < var3 && var4 > 0; var11++) {
                  WorldModule.Nested1_4650c0a0 var7 = this.I_field_7865b31.get((this.II_field_49 + var11) % var3);
                  var10++;
                  if (!var7.II_field_5a) {
                     var4--;
                     var7.i_field_5a = this.I_method_cd9c083(var2, var7.II_field_5bba0d50);
                  }
               }

               this.II_field_49 = (this.II_field_49 + var10) % var3;
            }
         }
      }
   }

   private void I_method_4e52b602(WorldModule.Nested1_4650c0a0 var1) {
      if (this.i_field_ba20ca4c.i_method_9b12da03()) {
         Camera var2 = I_field_3a9bda27.gameRenderer.getCamera();
         if (var2 != null) {
            var1.i_field_5a = this.I_method_cd9c083(var2.getPos(), var1.II_field_5bba0d50);
            var1.i_field_dc7facc.I_method_edd6dd21(var1.i_field_5a ? 0.0F : 1.0F);
         }
      }
   }

   private boolean I_method_cd9c083(Vec3d var1, Vec3d var2) {
      return var2.squaredDistanceTo(var1) > 2304.0
         ? true
         : I_field_3a9bda27.world.raycast(new RaycastContext(var1, var2, ShapeType.COLLIDER, FluidHandling.NONE, I_field_3a9bda27.player)).getType()
            != Type.MISS;
   }

   private void I_method_3c36296a(Render3DEvent var1, ColorRGBA var2, Vec3d var3) {
      if (this.i_field_ba20ca4c.i_method_9b12da03()) {
         float var4 = this.I_field_73178e8c.Ii_method_a20abcd2();
         float var5 = this.i_field_73178e8c.Ii_method_a20abcd2() / 100.0F;
         int var6 = Math.min(32, 48);
         if (!(var4 <= 0.0F) && !(var5 <= 0.0F) && var6 > 0) {
            Matrix4f var7 = new Matrix4f(var1.getProjectionMatrix()).mul(var1.getPositionMatrix());
            FrustumIntersection var8 = new FrustumIntersection(var7);
            ArrayList var9 = new ArrayList();

            for (WorldModule.Nested1_4650c0a0 var11 : this.I_field_7865b31) {
               float var12 = var11.I_field_dc7facc.I_method_6ac4da6f() * var11.i_field_dc7facc.I_method_6ac4da6f();
               if (var12 <= 0.01F) {
                  var11.II_field_5a = false;
                  var11.II_field_dc7facc.I_method_edd72835(false);
               } else {
                  Vec3d var13 = iIiiiiIII_Class377.I_method_156f92bb(var11.I_field_5bba0d50, var11.II_field_5bba0d50, var1.getTickDelta());
                  float var14 = (float)(var13.x - var3.x);
                  float var15 = (float)(var13.y - var3.y);
                  float var16 = (float)(var13.z - var3.z);
                  double var17 = Math.sqrt(var14 * var14 + var15 * var15 + var16 * var16);
                  if (!(var17 - var4 > 48.0) && var8.testSphere(var14, var15, var16, var4)) {
                     var9.add(new WorldModule.Nested1_4650c080(var11, var14, var15, var16, var12 * var5, var17));
                  } else {
                     var11.II_field_5a = false;
                     var11.II_field_dc7facc.I_method_edd72835(false);
                  }
               }
            }

            if (!var9.isEmpty()) {
               var9.sort(Comparator.comparingDouble(WorldModule.Nested1_4650c080::I_method_ab3d9328));

               for (WorldModule.Nested1_4650c080 var22 : (Iterable<WorldModule.Nested1_4650c080>)(Iterable<?>)var9) {
                  var22.I_method_c0b53ecb().II_field_5a = false;
               }

               float var21 = var4 * 0.35F;
               float var23 = var5 * 2.0F;
               ArrayList var24 = new ArrayList(var6);
               ArrayList var25 = new ArrayList();

               for (WorldModule.Nested1_4650c080 var28 : (Iterable<WorldModule.Nested1_4650c080>)(Iterable<?>)var9) {
                  if (var24.size() >= var6) {
                     var25.add(var28);
                  } else {
                     int var31 = -1;
                     float var35 = 0.0F;
                     int var18 = 0;

                     while (true) {
                        if (var18 < var24.size()) {
                           float var19 = var28.I_method_b8923ab7((WorldModule.Nested1_4650c080)var24.get(var18));
                           if (!(var19 < var21)) {
                              var18++;
                              continue;
                           }

                           var31 = var18;
                           var35 = var19;
                        }

                        if (var31 < 0) {
                           var24.add(var28);
                        } else {
                           WorldModule.Nested1_4650c080 var37 = (WorldModule.Nested1_4650c080)var24.get(var31);
                           if (var37.Ii_method_bc925737() < var23) {
                              float var39 = var28.Ii_method_bc925737()
                                 * 0.35F
                                 * (1.0F - var35 / var21)
                                 * (1.0F - var28.I_method_c0b53ecb().II_field_dc7facc.I_method_6ac4da6f());
                              if (var39 > 0.0F) {
                                 var24.set(var31, var37.I_method_6f11d977(Math.min(var39, var23 - var37.Ii_method_bc925737())));
                              }
                           }

                           var25.add(var28);
                        }
                        break;
                     }
                  }
               }

               ArrayList var27 = new ArrayList(var24.size() + 16);

               for (WorldModule.Nested1_4650c080 var32 : (Iterable<WorldModule.Nested1_4650c080>)(Iterable<?>)var24) {
                  var32.I_method_c0b53ecb().II_field_5a = true;
                  this.I_method_f93a6c52(var27, var32, var2, var4, var32.I_method_c0b53ecb().II_field_dc7facc.I_method_edd6dd11(1.0F));
               }

               int var30 = 0;

               for (WorldModule.Nested1_4650c080 var36 : (Iterable<WorldModule.Nested1_4650c080>)(Iterable<?>)var25) {
                  float var38 = var36.I_method_c0b53ecb().II_field_dc7facc.I_method_edd6dd11(0.0F);
                  if (!(var38 <= 0.001F) && var30 < 16 && this.I_method_f93a6c52(var27, var36, var2, var4, var38)) {
                     var30++;
                  }
               }

               if (!var27.isEmpty()) {
                  Matrix4f var34 = new Matrix4f(var7).invert();
                  iIiiIIiii_Class360.I_field_65f6a54c.I_method_6b5b11c2(var34, 1.0F, var27);
               }
            }
         }
      }
   }

   private boolean I_method_f93a6c52(List<iiiii_Class32.Nested1_88680fa0> var1, WorldModule.Nested1_4650c080 var2, ColorRGBA var3, float var4, float var5) {
      float var6 = var2.Ii_method_bc925737() * var5;
      if (var6 <= 0.001F) {
         return false;
      } else {
         var1.add(
            new iiiii_Class32.Nested1_88680fa0(
               var2.I_method_ab3d932a(),
               var2.i_method_ab4c1f0a(),
               var2.II_method_bc83cb57(),
               var4,
               var3.getRed() / 255.0F,
               var3.getGreen() / 255.0F,
               var3.getBlue() / 255.0F,
               var6
            )
         );
         return true;
      }
   }

   static final class Nested1_4650c080 {
      private final WorldModule.Nested1_4650c0a0 I_field_c77f29e7;
      private final float I_field_46;
      private final float i_field_46;
      private final float II_field_46;
      private final float Ii_field_46;
      private final double I_field_44;

      Nested1_4650c080(WorldModule.Nested1_4650c0a0 var1, float var2, float var3, float var4, float var5, double var6) {
         this.I_field_c77f29e7 = var1;
         this.I_field_46 = var2;
         this.i_field_46 = var3;
         this.II_field_46 = var4;
         this.Ii_field_46 = var5;
         this.I_field_44 = var6;
      }

      double I_method_ab3d9328() {
         return this.I_field_c77f29e7.II_field_5a ? this.I_field_44 * 0.5 : this.I_field_44;
      }

      float I_method_b8923ab7(WorldModule.Nested1_4650c080 var1) {
         float var2 = this.I_field_46 - var1.I_field_46;
         float var3 = this.i_field_46 - var1.i_field_46;
         float var4 = this.II_field_46 - var1.II_field_46;
         return (float)Math.sqrt(var2 * var2 + var3 * var3 + var4 * var4);
      }

      WorldModule.Nested1_4650c080 I_method_6f11d977(float var1) {
         return new WorldModule.Nested1_4650c080(
            this.I_field_c77f29e7, this.I_field_46, this.i_field_46, this.II_field_46, this.Ii_field_46 + var1, this.I_field_44
         );
      }

      @Override
      public final String toString() {
         return "Nested1_4650c080[particle=" + this.I_field_c77f29e7 + ", x=" + this.I_field_46 + ", y=" + this.i_field_46 + ", z=" + this.II_field_46 + ", intensity=" + this.Ii_field_46 + ", distance=" + this.I_field_44 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_c77f29e7);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.Ii_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_44);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         WorldModule.Nested1_4650c080 other = (WorldModule.Nested1_4650c080) var1;
         return java.util.Objects.equals(this.I_field_c77f29e7, other.I_field_c77f29e7)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46)
            && java.util.Objects.equals(this.I_field_44, other.I_field_44);
      }

      public WorldModule.Nested1_4650c0a0 I_method_c0b53ecb() {
         return this.I_field_c77f29e7;
      }

      public float I_method_ab3d932a() {
         return this.I_field_46;
      }

      public float i_method_ab4c1f0a() {
         return this.i_field_46;
      }

      public float II_method_bc83cb57() {
         return this.II_field_46;
      }

      public float Ii_method_bc925737() {
         return this.Ii_field_46;
      }

      public double i_method_ab4c1f08() {
         return this.I_field_44;
      }
   }

   static class Nested1_4650c0a0 {
      Vec3d I_field_5bba0d50;
      Vec3d i_field_5bba0d50;
      Vec3d II_field_5bba0d50;
      Vec3d Ii_field_5bba0d50;
      Vec3d iI_field_5bba0d50;
      Vec3d ii_field_5bba0d50;
      final long I_field_4a;
      float I_field_46;
      boolean I_field_5a;
      boolean i_field_5a;
      boolean II_field_5a;
      final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
      final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.III_field_dd60aac);
      final IiiiIiIii_Class236 i_field_dc7facc = new IiiiIiIii_Class236(200L, 1.0F, IiiiIiiII_Class237.III_field_dd60aac);
      final IiiiIiIii_Class236 II_field_dc7facc = new IiiiIiIii_Class236(220L, IiiiIiiII_Class237.III_field_dd60aac);

      public Nested1_4650c0a0(Vec3d var1, Vec3d var2, Vec3d var3, Vec3d var4, long var5, float var7) {
         this.II_field_5bba0d50 = var1;
         this.Ii_field_5bba0d50 = var2;
         this.iI_field_5bba0d50 = var3.multiply(0.04F);
         this.ii_field_5bba0d50 = var4.multiply(0.04F);
         this.I_field_4a = var5;
         this.I_field_46 = var7;
         this.i_field_5bba0d50 = var2;
         this.I_field_5bba0d50 = var1;
         this.I_field_dc7facc.I_method_edd6ec25(1000L);
      }

      boolean I_method_e1d8a71e() {
         return this.I_field_5a || this.I_field_991c1e8c.I_method_58432069(this.I_field_4a);
      }

      void I_method_e1d8a71a() {
         this.I_field_5bba0d50 = this.II_field_5bba0d50;
         this.i_field_5bba0d50 = this.Ii_field_5bba0d50;
         this.II_field_5bba0d50 = this.II_field_5bba0d50.add(this.iI_field_5bba0d50);
         this.Ii_field_5bba0d50 = this.Ii_field_5bba0d50.add(this.ii_field_5bba0d50);
         this.iI_field_5bba0d50 = this.iI_field_5bba0d50.multiply(0.98);
         this.ii_field_5bba0d50 = this.ii_field_5bba0d50.multiply(0.98);
      }
   }
}
