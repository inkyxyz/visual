package rockstar.client;

import com.mojang.blaze3d.systems.ProjectionType;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.List;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.ShaderProgramKeys;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;

public class iiIiI_Class27 implements iIIiIIiIi_Class294, iIIiIIiii_Class296 {
   private final iIiiIIiII_Class357 I_field_cb35e4c = new iIiiIIiII_Class357(false).I_method_cc37aab5();
   private final iIiiIIiII_Class357 i_field_cb35e4c = new iIiiIIiII_Class357(false).I_method_cc37aab5();
   private iiIii_Class28 I_field_65e81d4c;

   public void I_method_937f231f() {
      if (this.I_field_65e81d4c == null) {
         this.I_field_65e81d4c = new iiIii_Class28(RockstarClient.id("jump_shockwave/data"));
      }
   }

   public void I_method_338cb1a0(Matrix4f var1, List<iiIiI_Class27.Nested1_86a4a760> var2) {
      if (this.I_field_65e81d4c != null && var2 != null && !var2.isEmpty()) {
         Framebuffer var3 = I_field_3a9bda27.getFramebuffer();
         if (var3 != null && var3.getDepthAttachment() != 0) {
            int var4 = I_field_587075c2.getScaledWidth();
            int var5 = I_field_587075c2.getScaledHeight();
            if (var4 > 0 && var5 > 0) {
               int var6 = var3.getDepthAttachment();
               int var7 = Math.min(var2.size(), 12);
               RenderSystem.disableBlend();
               RenderSystem.depthMask(false);
               RenderSystem.backupProjectionMatrix();
               Matrix4f var8 = new Matrix4f().setOrtho(0.0F, var4, var5, 0.0F, 1000.0F, 21000.0F);
               RenderSystem.setProjectionMatrix(var8, ProjectionType.ORTHOGRAPHIC);
               Matrix4fStack var9 = RenderSystem.getModelViewStack();
               var9.pushMatrix();
               var9.identity().translate(0.0F, 0.0F, -11000.0F);
               iIiiIIiII_Class357[] var10 = new iIiiIIiII_Class357[]{this.I_field_cb35e4c, this.i_field_cb35e4c};
               Object var11 = var3;
               byte var12 = 0;

               for (int var13 = 0; var13 < var7; var13++) {
                  iIiiIIiII_Class357 var14 = var10[var12];
                  var14.I_method_76527dff();
                  this.I_field_65e81d4c.I_method_33f6c16b();
                  this.I_field_65e81d4c.I_method_9a795172(var1, (iiIiI_Class27.Nested1_86a4a760)var2.get(var13));
                  ((net.minecraft.client.gl.Framebuffer)var11).beginRead();
                  RenderSystem.setShaderTexture(0, ((net.minecraft.client.gl.Framebuffer)var11).getColorAttachment());
                  RenderSystem.setShaderTexture(1, var6);
                  iIiiIIiii_Class360.I_method_4355d27f(0.0F, 0.0F, var4, var5);
                  ((net.minecraft.client.gl.Framebuffer)var11).endRead();
                  var14.i_method_766109df();
                  var11 = var14;
                  var12 ^= 1;
               }

               RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
               RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
               ((net.minecraft.client.gl.Framebuffer)var11).beginRead();
               RenderSystem.setShaderTexture(0, ((net.minecraft.client.gl.Framebuffer)var11).getColorAttachment());
               iIiiIIiii_Class360.I_method_4355d27f(0.0F, 0.0F, var4, var5);
               ((net.minecraft.client.gl.Framebuffer)var11).endRead();
               RenderSystem.setShaderTexture(1, 0);
               RenderSystem.setShaderTexture(0, 0);
               var9.popMatrix();
               RenderSystem.restoreProjectionMatrix();
               RenderSystem.depthMask(true);
               RenderSystem.enableBlend();
            }
         }
      }
   }

   public static final class Nested1_86a4a760 {
      private final float I_field_46;
      private final float i_field_46;
      private final float II_field_46;
      private final float Ii_field_46;
      private final float iI_field_46;
      private final float ii_field_46;
      private final float III_field_46;
      private final float IIi_field_46;
      private final float IiI_field_46;
      private final float Iii_field_46;

      public Nested1_86a4a760(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10) {
         this.I_field_46 = var1;
         this.i_field_46 = var2;
         this.II_field_46 = var3;
         this.Ii_field_46 = var4;
         this.iI_field_46 = var5;
         this.ii_field_46 = var6;
         this.III_field_46 = var7;
         this.IIi_field_46 = var8;
         this.IiI_field_46 = var9;
         this.Iii_field_46 = var10;
      }

      @Override
      public final String toString() {
         return "Nested1_86a4a760[cx=" + this.I_field_46 + ", cy=" + this.i_field_46 + ", cz=" + this.II_field_46 + ", worldRadius=" + this.Ii_field_46 + ", thickness=" + this.iI_field_46 + ", r=" + this.ii_field_46 + ", g=" + this.III_field_46 + ", b=" + this.IIi_field_46 + ", intensity=" + this.IiI_field_46 + ", strength=" + this.Iii_field_46 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.Ii_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.iI_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.ii_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.III_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.IIi_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.IiI_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.Iii_field_46);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iiIiI_Class27.Nested1_86a4a760 other = (iiIiI_Class27.Nested1_86a4a760) var1;
         return java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46)
            && java.util.Objects.equals(this.iI_field_46, other.iI_field_46)
            && java.util.Objects.equals(this.ii_field_46, other.ii_field_46)
            && java.util.Objects.equals(this.III_field_46, other.III_field_46)
            && java.util.Objects.equals(this.IIi_field_46, other.IIi_field_46)
            && java.util.Objects.equals(this.IiI_field_46, other.IiI_field_46)
            && java.util.Objects.equals(this.Iii_field_46, other.Iii_field_46);
      }

      public float I_method_9fa6f84a() {
         return this.I_field_46;
      }

      public float i_method_9fb5842a() {
         return this.i_field_46;
      }

      public float II_method_55470a37() {
         return this.II_field_46;
      }

      public float Ii_method_55559617() {
         return this.Ii_field_46;
      }

      public float iI_method_5709fa57() {
         return this.iI_field_46;
      }

      public float ii_method_57188637() {
         return this.ii_field_46;
      }

      public float III_method_53a935ea() {
         return this.III_field_46;
      }

      public float IIi_method_53b7c1ca() {
         return this.IIi_field_46;
      }

      public float IiI_method_556c260a() {
         return this.IiI_field_46;
      }

      public float Iii_method_557ab1ea() {
         return this.Iii_field_46;
      }
   }
}
