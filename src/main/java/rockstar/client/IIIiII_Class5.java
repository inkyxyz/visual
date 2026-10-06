package rockstar.client;

import com.mojang.blaze3d.systems.ProjectionType;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.List;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.ShaderProgramKeys;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;

public class IIIiII_Class5 implements iIIiIIiIi_Class294, iIIiIIiii_Class296 {
   private final iIiiIIiII_Class357 I_field_cb35e4c = new iIiiIIiII_Class357(false).I_method_cc37aab5();
   private final iIiiIIiII_Class357 i_field_cb35e4c = new iIiiIIiII_Class357(false).I_method_cc37aab5();
   private IIIiIi_Class6 I_field_83b89de1;

   public void I_method_e3461a4c() {
      if (this.I_field_83b89de1 == null) {
         this.I_field_83b89de1 = new IIIiIi_Class6(RockstarClient.id("target_lens/data"));
      }
   }

   public void I_method_dc54243d(float var1, float var2, List<IIIiII_Class5.Nested1_b503c753> var3) {
      if (this.I_field_83b89de1 != null && var3 != null && !var3.isEmpty() && !(var2 <= 0.001F)) {
         Framebuffer var4 = I_field_3a9bda27.getFramebuffer();
         if (var4 != null && var4.getDepthAttachment() != 0) {
            int var5 = I_field_587075c2.getScaledWidth();
            int var6 = I_field_587075c2.getScaledHeight();
            if (var5 > 0 && var6 > 0) {
               int var7 = var4.getDepthAttachment();
               RenderSystem.disableBlend();
               RenderSystem.depthMask(false);
               RenderSystem.backupProjectionMatrix();
               Matrix4f var8 = new Matrix4f().setOrtho(0.0F, var5, var6, 0.0F, 1000.0F, 21000.0F);
               RenderSystem.setProjectionMatrix(var8, ProjectionType.ORTHOGRAPHIC);
               Matrix4fStack var9 = RenderSystem.getModelViewStack();
               var9.pushMatrix();
               var9.identity().translate(0.0F, 0.0F, -11000.0F);
               this.I_field_cb35e4c.I_method_76527dff();
               this.I_field_83b89de1.I_method_33f6c16b();
               this.I_field_83b89de1.I_method_5c86001d(var1, var2, List.of());
               var4.beginRead();
               RenderSystem.setShaderTexture(0, var4.getColorAttachment());
               RenderSystem.setShaderTexture(1, var7);
               iIiiIIiii_Class360.I_method_4355d27f(0.0F, 0.0F, var5, var6);
               var4.endRead();
               this.I_field_cb35e4c.i_method_766109df();
               this.i_field_cb35e4c.I_method_76527dff();
               this.I_field_83b89de1.I_method_33f6c16b();
               this.I_field_83b89de1.I_method_5c86001d(var1, var2, var3);
               this.I_field_cb35e4c.beginRead();
               RenderSystem.setShaderTexture(0, this.I_field_cb35e4c.getColorAttachment());
               RenderSystem.setShaderTexture(1, var7);
               iIiiIIiii_Class360.I_method_4355d27f(0.0F, 0.0F, var5, var6);
               this.I_field_cb35e4c.endRead();
               this.i_field_cb35e4c.i_method_766109df();
               RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
               RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
               this.i_field_cb35e4c.beginRead();
               RenderSystem.setShaderTexture(0, this.i_field_cb35e4c.getColorAttachment());
               iIiiIIiii_Class360.I_method_4355d27f(0.0F, 0.0F, var5, var6);
               this.i_field_cb35e4c.endRead();
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

   public static final class Nested1_b503c753 {
      private final float I_field_46;
      private final float i_field_46;
      private final float II_field_46;
      private final float Ii_field_46;

      public Nested1_b503c753(float var1, float var2, float var3, float var4) {
         this.I_field_46 = var1;
         this.i_field_46 = var2;
         this.II_field_46 = var3;
         this.Ii_field_46 = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_b503c753[u=" + this.I_field_46 + ", v=" + this.i_field_46 + ", depth=" + this.II_field_46 + ", radius=" + this.Ii_field_46 + "]";
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
         IIIiII_Class5.Nested1_b503c753 other = (IIIiII_Class5.Nested1_b503c753) var1;
         return java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46);
      }

      public float I_method_198cd837() {
         return this.I_field_46;
      }

      public float i_method_199b6417() {
         return this.i_field_46;
      }

      public float II_method_181d27ea() {
         return this.II_field_46;
      }

      public float Ii_method_182bb3ca() {
         return this.Ii_field_46;
      }
   }
}
