package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderProgram;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.text.Text;
import org.joml.Matrix4f;

public class iiIIIIIII_Class385 {
   private static final MinecraftClient I_field_3a9bda27 = MinecraftClient.getInstance();
   private final IIiiii_Class16 I_field_857c0621;
   private final IIiiii_Class16 i_field_857c0621;
   private final List<iiIIIIIII_Class385.Nested1_e61f040> I_field_7865b31 = new ArrayList<>();
   private final List<iiIIIIIII_Class385.Nested1_e61f040> i_field_7865b31 = new ArrayList<>();
   private boolean I_field_5a;
   private DrawContext I_field_c442d8e8;

   public iiIIIIIII_Class385(IIiiii_Class16 var1, IIiiii_Class16 var2) {
      this.I_field_857c0621 = var1;
      this.i_field_857c0621 = var2;
   }

   public void I_method_3a5ea7a7(DrawContext var1) {
      this.I_field_c442d8e8 = var1;
   }

   public void I_method_cd34930a(Matrix4f var1, String var2, float var3, float var4, float var5, float var6, int var7) {
      Matrix4f var8 = new Matrix4f(var1);
      String var9 = IIIiIiIi_Class22.I_method_7f49082a(var2);
      this.I_field_7865b31.add(new iiIIIIIII_Class385.Nested1_e61f040(var8, var9, var3, var4, var5, var6, var7));
      if (IIIiIiIi_Class22.II_method_40fdec79()) {
         this.i_field_7865b31
            .add(var9 == var2 ? this.I_field_7865b31.getLast() : new iiIIIIIII_Class385.Nested1_e61f040(var8, var2, var3, var4, var5, var6, var7));
         this.I_field_5a |= var9 != var2;
      }
   }

   public void I_method_c073d717(Matrix4f var1, Text var2, float var3, float var4, float var5, float var6) {
      int var7 = IiiiiIIIi_Class242.Ii_field_d0c8ec5.getRGB();
      List var8 = IIiIii_Class12.I_method_8847bf1e(var2, var7);
      boolean var9 = IIIiIiIi_Class22.II_method_40fdec79();
      float var10 = var4;
      float var11 = var4;
      Matrix4f var12 = new Matrix4f(var1);

      for (IIiIii_Class12.Nested1_e9eaef13 var14 : (Iterable<IIiIii_Class12.Nested1_e9eaef13>)(Iterable<?>)var8) {
         String var15 = IIIiIiIi_Class22.I_method_7f49082a(var14.I_field_523beb0a);
         this.I_field_7865b31.add(new iiIIIIIII_Class385.Nested1_e61f040(var12, var15, var3, var10, var5, var6, var14.I_field_49));
         var10 += this.i_method_7999f2a7(var15, var3);
         if (var9) {
            this.i_field_7865b31.add(new iiIIIIIII_Class385.Nested1_e61f040(var12, var14.I_field_523beb0a, var3, var11, var5, var6, var14.I_field_49));
            var11 += this.i_method_7999f2a7(var14.I_field_523beb0a, var3);
            this.I_field_5a = this.I_field_5a | var15 != var14.I_field_523beb0a;
         }
      }
   }

   public void I_method_b7c2ae3f() {
      if (!this.I_field_7865b31.isEmpty()) {
         if (this.I_field_5a) {
            IIIiIiIi_Class22.I_method_3ee425f8(this.I_method_40931a85(), () -> this.I_method_ed62dd30(this.i_field_7865b31));
         }

         this.I_method_ed62dd30(this.I_field_7865b31);
         this.I_field_7865b31.clear();
         this.i_field_7865b31.clear();
         this.I_field_5a = false;
      }
   }

   private int[] I_method_40931a85() {
      int var1 = -1;

      for (int var2 = 0; var2 < this.i_field_7865b31.size() && var1 < 0; var2++) {
         iiIIIIIII_Class385.Nested1_e61f040 var3 = var2 < this.I_field_7865b31.size() ? this.I_field_7865b31.get(var2) : this.i_field_7865b31.get(var2);
         if (!this.i_field_7865b31.get(var2).I_field_523beb0a.equals(var3.I_field_523beb0a)) {
            var1 = var2;
         }
      }

      if (var1 < 0) {
         return null;
      } else {
         int[] var4 = null;

         for (int var5 = var1; var5 < this.i_field_7865b31.size(); var5++) {
            var4 = IIIiIiIi_Class22.I_method_db730cdc(var4, this.I_method_5d983302(this.i_field_7865b31.get(var5)));
            if (var5 < this.I_field_7865b31.size()) {
               var4 = IIIiIiIi_Class22.I_method_db730cdc(var4, this.I_method_5d983302(this.I_field_7865b31.get(var5)));
            }
         }

         return var4;
      }
   }

   private int[] I_method_5d983302(iiIIIIIII_Class385.Nested1_e61f040 var1) {
      return IIIiIiIi_Class22.I_method_a0f921e2(
         var1.I_field_d754d74,
         var1.i_field_46 - 1.0F,
         var1.II_field_46 - var1.I_field_46 * 0.35F,
         var1.i_field_46 + this.i_method_7999f2a7(var1.I_field_523beb0a, var1.I_field_46) + 1.0F,
         var1.II_field_46 + var1.I_field_46 * 1.45F
      );
   }

   private void I_method_ed62dd30(List<iiIIIIIII_Class385.Nested1_e61f040> var1) {
      float var2 = 0.0F;
      float var3 = 0.5F;
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      RenderSystem.disableCull();
      ShaderProgram var4 = IiIIIi_Class18.I_method_fb4921e0(var2);
      var4.getUniform("EnableFadeout").set(0);
      BufferBuilder var5 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR_LIGHT);

      for (iiIIIIIII_Class385.Nested1_e61f040 var7 : var1) {
         this.I_field_857c0621
            .I_method_5811d2b(
               var7.I_field_d754d74, var5, var7.I_field_523beb0a, var7.I_field_46, var7.i_field_46, var7.II_field_46, var7.Ii_field_46, var7.I_field_49
            );
      }

      BuiltBuffer var8 = var5.endNullable();
      if (var8 != null) {
         BufferRenderer.drawWithGlobalProgram(var8);
      }

      IiIIIi_Class18.I_method_a6e9b62c();
      RenderSystem.enableCull();
      RenderSystem.disableBlend();
      if (this.I_field_c442d8e8 != null) {
         this.i_method_e19da910(var1);
      }
   }

   private void i_method_e19da910(List<iiIIIIIII_Class385.Nested1_e61f040> var1) {
      for (iiIIIIIII_Class385.Nested1_e61f040 var3 : var1) {
         float var4 = var3.I_field_46 / 9.0F;
         this.I_field_857c0621
            .I_method_ebff3dc7(
               var3.I_field_523beb0a, var3.I_field_46, var3.i_field_46, var3.II_field_46, this.i_field_857c0621, (var3x, var4x, var5, var6, var7) -> {
                  if (var4x == null) {
                     this.I_field_c442d8e8.getMatrices().push();
                     this.I_field_c442d8e8.getMatrices().multiplyPositionMatrix(var3.I_field_d754d74);
                     this.I_field_c442d8e8.getMatrices().scale(var4, var4, 1.0F);
                     float var8 = var6 / var4;
                     float var9 = (var3.II_field_46 + var3.I_field_46 * 0.15F) / var4 - 0.5F;
                     this.I_field_c442d8e8.drawText(I_field_3a9bda27.textRenderer, String.valueOf(var5), (int)var8, (int)var9, var3.I_field_49, false);
                     this.I_field_c442d8e8.getMatrices().pop();
                  }
               }
            );
      }
   }

   public float I_method_3366ca87(String var1, float var2) {
      return I_method_44b27a85(this.I_field_857c0621, this.i_field_857c0621, var1, var2);
   }

   public float I_method_ea319ea9(Text var1, float var2) {
      return I_method_44b27a85(this.I_field_857c0621, this.i_field_857c0621, var1.getString(), var2);
   }

   private float i_method_7999f2a7(String var1, float var2) {
      return this.I_field_857c0621.I_method_bdbecc1b(var1, var2, this.i_field_857c0621);
   }

   public static float I_method_44b27a85(IIiiii_Class16 var0, IIiiii_Class16 var1, String var2, float var3) {
      return var0.I_method_bdbecc1b(IIIiIiIi_Class22.I_method_7f49082a(var2), var3, var1);
   }

   static final class Nested1_e61f040 {
      final Matrix4f I_field_d754d74;
      final String I_field_523beb0a;
      final float I_field_46;
      final float i_field_46;
      final float II_field_46;
      final float Ii_field_46;
      final int I_field_49;

      Nested1_e61f040(Matrix4f var1, String var2, float var3, float var4, float var5, float var6, int var7) {
         this.I_field_d754d74 = var1;
         this.I_field_523beb0a = var2;
         this.I_field_46 = var3;
         this.i_field_46 = var4;
         this.II_field_46 = var5;
         this.Ii_field_46 = var6;
         this.I_field_49 = var7;
      }

      @Override
      public final String toString() {
         return "Nested1_e61f040[matrix=" + this.I_field_d754d74 + ", text=" + this.I_field_523beb0a + ", size=" + this.I_field_46 + ", x=" + this.i_field_46 + ", y=" + this.II_field_46 + ", z=" + this.Ii_field_46 + ", color=" + this.I_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_d754d74);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.Ii_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iiIIIIIII_Class385.Nested1_e61f040 other = (iiIIIIIII_Class385.Nested1_e61f040) var1;
         return java.util.Objects.equals(this.I_field_d754d74, other.I_field_d754d74)
            && java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49);
      }

      public Matrix4f I_method_9a268798() {
         return this.I_field_d754d74;
      }

      public String I_method_e328dc66() {
         return this.I_field_523beb0a;
      }

      public float I_method_c1343b6a() {
         return this.I_field_46;
      }

      public float i_method_c142c74a() {
         return this.i_field_46;
      }

      public float II_method_65622b17() {
         return this.II_field_46;
      }

      public float Ii_method_6570b6f7() {
         return this.Ii_field_46;
      }

      public int I_method_c1343b6d() {
         return this.I_field_49;
      }
   }
}
