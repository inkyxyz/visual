package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.BlockState;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider.Immediate;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerModelPart;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.util.Arm;
import net.minecraft.util.Identifier;
import org.joml.Matrix4f;

public final class IiiiiIii_Class124 implements iIIiIIiIi_Class294, iIIiIIiii_Class296 {
   public static boolean I_field_5a;
   public static boolean i_field_5a;
   public static boolean II_field_5a;
   private static final iIiiIIiII_Class357 I_field_cb35e4c = new iIiiIIiII_Class357(true).I_method_cc37aab5().I_method_7d3fafd7(1.0F);
   private static final int I_field_49 = 15728880;
   private static final List<IiiiiIii_Class124.Nested1_951771d6> I_field_7865b31 = new ArrayList<>();
   private static final List<IiiiiIii_Class124.Nested1_3e9da8f3> i_field_7865b31 = new ArrayList<>();
   private static final List<IiiiiIii_Class124.Nested1_3e9da8d3> II_field_7865b31 = new ArrayList<>();
   private static boolean Ii_field_5a;

   private IiiiiIii_Class124() {
   }

   public static boolean I_method_ad8ec8d0() {
      IiiiiiiI_Class127 var0 = IiiiiiiI_Class127.I_method_e1e653cb();
      return var0 == null
         ? false
         : I_method_93f36731(var0.I_method_b8f96026(iIIIIIiI_Class131.class))
            || I_method_93f36731(var0.I_method_b8f96026(iIIIIIII_Class129.class))
            || I_method_93f36731(var0.I_method_b8f96026(Iiiiiiii_Class128.class));
   }

   private static boolean I_method_93f36731(IiiiIiiI_Class119 var0) {
      return var0 != null && var0.i_method_6c6ff6d1(IiiiIiii_Class120.I_field_10f66741);
   }

   public static void I_method_ad8ec8cc() {
      i_field_5a = true;
      II_field_5a = false;
      Ii_field_5a = false;
      I_field_7865b31.clear();
      i_field_7865b31.clear();
      II_field_7865b31.clear();
   }

   public static void i_method_ad9d54ac() {
      i_field_5a = false;
   }

   public static void I_method_20b25b16(ItemStack var0, ModelTransformationMode var1, boolean var2, MatrixStack var3) {
      if (I_method_ad8ec8d0() && var0 != null && !var0.isEmpty()) {
         I_field_7865b31.add(new IiiiiIii_Class124.Nested1_951771d6(var0.copy(), var1, var2, new Matrix4f(var3.peek().getPositionMatrix())));
      }
   }

   public static void I_method_65dc8d14(BlockState var0, int var1, MatrixStack var2) {
      if (I_method_ad8ec8d0() && var0 != null) {
         i_field_7865b31.add(new IiiiiIii_Class124.Nested1_3e9da8f3(var0, var1, new Matrix4f(var2.peek().getPositionMatrix())));
      }
   }

   public static void I_method_4209348a(Arm var0, MatrixStack var1) {
      if (I_method_ad8ec8d0()) {
         II_field_7865b31.add(new IiiiiIii_Class124.Nested1_3e9da8d3(var0, new Matrix4f(var1.peek().getPositionMatrix())));
      }
   }

   public static void II_method_4594815() {
      if (!II_field_7865b31.isEmpty() && I_method_ad8ec8d0()) {
         ClientPlayerEntity var0 = I_field_3a9bda27.player;
         if (var0 != null) {
            if (I_field_3a9bda27.getEntityRenderDispatcher().getRenderer(var0) instanceof PlayerEntityRenderer var2) {
               I_field_5a = true;
               I_field_cb35e4c.I_method_53fdf4b5(true);

               try {
                  Immediate var3 = I_field_3a9bda27.getBufferBuilders().getEntityVertexConsumers();

                  for (IiiiiIii_Class124.Nested1_951771d6 var5 : I_field_7865b31) {
                     MatrixStack var6 = new MatrixStack();
                     var6.multiplyPositionMatrix(var5.I_method_c9b99d42());
                     I_field_3a9bda27.getItemRenderer()
                        .renderItem(
                           var0,
                           var5.I_method_a6aab894(),
                           var5.I_method_d68b1bf4(),
                           var5.I_method_44be47a8(),
                           var6,
                           var3,
                           var0.getWorld(),
                           15728880,
                           OverlayTexture.DEFAULT_UV,
                           var0.getId() + var5.I_method_d68b1bf4().ordinal()
                        );
                  }

                  for (IiiiiIii_Class124.Nested1_3e9da8f3 var11 : i_field_7865b31) {
                     MatrixStack var13 = new MatrixStack();
                     var13.multiplyPositionMatrix(var11.I_method_ab52b585());
                     I_field_3a9bda27.getBlockRenderManager().renderBlockAsEntity(var11.I_method_a81a6284(), var13, var3, 15728880, var11.I_method_aafefa9a());
                  }

                  var3.draw();
                  RenderSystem.clearColor(0.0F, 0.0F, 0.0F, 0.0F);
                  RenderSystem.clear(16384);
                  Identifier var10 = var0.getSkinTextures().texture();

                  for (IiiiiIii_Class124.Nested1_3e9da8d3 var14 : II_field_7865b31) {
                     MatrixStack var7 = new MatrixStack();
                     var7.multiplyPositionMatrix(var14.I_method_2b20d9a5());
                     if (var14.I_method_21a98abb() == Arm.LEFT) {
                        var2.renderLeftArm(var7, var3, 15728880, var10, var0.isPartVisible(PlayerModelPart.LEFT_SLEEVE));
                     } else {
                        var2.renderRightArm(var7, var3, 15728880, var10, var0.isPartVisible(PlayerModelPart.RIGHT_SLEEVE));
                     }
                  }

                  var3.draw();
                  Ii_field_5a = true;
               } catch (Exception var8) {
               }

               I_field_cb35e4c.i_method_766109df();
               I_field_5a = false;
               I_field_7865b31.clear();
               i_field_7865b31.clear();
               II_field_7865b31.clear();
            }
         }
      }
   }

   public static void I_method_a75705ba(iIiiIIiII_Class357 var0) {
      if (Ii_field_5a && var0 != null) {
         var0.beginWrite(true);
         RenderSystem.enableBlend();
         RenderSystem.blendFuncSeparate(SrcFactor.ZERO, DstFactor.ONE_MINUS_SRC_ALPHA, SrcFactor.ZERO, DstFactor.ONE_MINUS_SRC_ALPHA);
         RenderSystem.disableDepthTest();
         RenderSystem.disableCull();
         RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         RenderSystem.setShaderTexture(0, I_field_cb35e4c.getColorAttachment());
         iIiiIIiii_Class360.I_method_4355d27f(0.0F, 0.0F, I_field_587075c2.getScaledWidth(), I_field_587075c2.getScaledHeight());
         RenderSystem.setShaderTexture(0, 0);
         RenderSystem.defaultBlendFunc();
         RenderSystem.enableCull();
         I_field_3a9bda27.getFramebuffer().beginWrite(true);
      }
   }

   static final class Nested1_3e9da8d3 {
      private final Arm I_field_3260204c;
      private final Matrix4f I_field_d754d74;

      Nested1_3e9da8d3(Arm var1, Matrix4f var2) {
         this.I_field_3260204c = var1;
         this.I_field_d754d74 = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_3e9da8d3[arm=" + this.I_field_3260204c + ", pose=" + this.I_field_d754d74 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_3260204c);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_d754d74);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiiiiIii_Class124.Nested1_3e9da8d3 other = (IiiiiIii_Class124.Nested1_3e9da8d3) var1;
         return java.util.Objects.equals(this.I_field_3260204c, other.I_field_3260204c)
            && java.util.Objects.equals(this.I_field_d754d74, other.I_field_d754d74);
      }

      public Arm I_method_21a98abb() {
         return this.I_field_3260204c;
      }

      public Matrix4f I_method_2b20d9a5() {
         return this.I_field_d754d74;
      }
   }

   static final class Nested1_3e9da8f3 {
      private final BlockState I_field_fd3466f5;
      private final int I_field_49;
      private final Matrix4f I_field_d754d74;

      Nested1_3e9da8f3(BlockState var1, int var2, Matrix4f var3) {
         this.I_field_fd3466f5 = var1;
         this.I_field_49 = var2;
         this.I_field_d754d74 = var3;
      }

      @Override
      public final String toString() {
         return "Nested1_3e9da8f3[state=" + this.I_field_fd3466f5 + ", overlay=" + this.I_field_49 + ", pose=" + this.I_field_d754d74 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_fd3466f5);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_d754d74);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiiiiIii_Class124.Nested1_3e9da8f3 other = (IiiiiIii_Class124.Nested1_3e9da8f3) var1;
         return java.util.Objects.equals(this.I_field_fd3466f5, other.I_field_fd3466f5)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.I_field_d754d74, other.I_field_d754d74);
      }

      public BlockState I_method_a81a6284() {
         return this.I_field_fd3466f5;
      }

      public int I_method_aafefa9a() {
         return this.I_field_49;
      }

      public Matrix4f I_method_ab52b585() {
         return this.I_field_d754d74;
      }
   }

   static final class Nested1_951771d6 {
      private final ItemStack I_field_f2735522;
      private final ModelTransformationMode I_field_70c7a802;
      private final boolean I_field_5a;
      private final Matrix4f I_field_d754d74;

      Nested1_951771d6(ItemStack var1, ModelTransformationMode var2, boolean var3, Matrix4f var4) {
         this.I_field_f2735522 = var1;
         this.I_field_70c7a802 = var2;
         this.I_field_5a = var3;
         this.I_field_d754d74 = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_951771d6[stack=" + this.I_field_f2735522 + ", mode=" + this.I_field_70c7a802 + ", leftHanded=" + this.I_field_5a + ", pose=" + this.I_field_d754d74 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_f2735522);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_70c7a802);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_d754d74);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiiiiIii_Class124.Nested1_951771d6 other = (IiiiiIii_Class124.Nested1_951771d6) var1;
         return java.util.Objects.equals(this.I_field_f2735522, other.I_field_f2735522)
            && java.util.Objects.equals(this.I_field_70c7a802, other.I_field_70c7a802)
            && java.util.Objects.equals(this.I_field_5a, other.I_field_5a)
            && java.util.Objects.equals(this.I_field_d754d74, other.I_field_d754d74);
      }

      public ItemStack I_method_a6aab894() {
         return this.I_field_f2735522;
      }

      public ModelTransformationMode I_method_d68b1bf4() {
         return this.I_field_70c7a802;
      }

      public boolean I_method_44be47a8() {
         return this.I_field_5a;
      }

      public Matrix4f I_method_c9b99d42() {
         return this.I_field_d754d74;
      }
   }
}
