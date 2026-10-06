package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.client.gl.ShaderProgram;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import org.joml.Matrix4f;
import org.joml.Vector3f;

public class iIiiiiiiI_Class383 {
   private static final float I_field_46 = 0.0F;
   private static final float i_field_46 = 0.5F;
   private static final float II_field_46 = 0.0F;
   private final Map<iIiiiiiiI_Class383.Nested1_df1b4060, List<iIiiiiiiI_Class383.Nested1_44ccbe9>> I_field_a567c40b = new LinkedHashMap<>();
   private final Map<IIiiii_Class16, Map<iIiiiiiiI_Class383.Nested1_df1b4060, List<iIiiiiiiI_Class383.Nested1_44ccc09>>> i_field_a567c40b = new LinkedHashMap<>();
   private final Map<iIiiiiiiI_Class383.Nested1_df1b4060, List<iIiiiiiiI_Class383.Nested1_df1b4080>> II_field_a567c40b = new LinkedHashMap<>();
   private iIiiiiiiI_Class383.Nested1_df1b4060 I_field_4804a227;
   private float Ii_field_46;
   private float iI_field_46 = 3.0F;
   private float ii_field_46 = 0.3F;
   private float III_field_46 = 0.42F;
   private int I_field_49 = -1;
   private int i_field_49 = -15856114;

   public iIiiiiiiI_Class383 I_method_56782bd7(float var1) {
      this.Ii_field_46 = var1;
      return this;
   }

   public iIiiiiiiI_Class383 i_method_f39133f7(float var1) {
      this.iI_field_46 = var1;
      return this;
   }

   public iIiiiiiiI_Class383 I_method_9ffcc735(float var1, float var2) {
      this.ii_field_46 = var1;
      this.III_field_46 = var2;
      return this;
   }

   public iIiiiiiiI_Class383 I_method_1df27795(int var1, int var2) {
      this.I_field_49 = var1;
      this.i_field_49 = var2;
      return this;
   }

   public iIiiiiiiI_Class383 I_method_8cf520c5(Matrix4f var1, float var2, float var3) {
      this.I_field_4804a227 = i_method_cb85e660(var1, var2, var3);
      return this;
   }

   public iIiiiiiiI_Class383 I_method_228caaf5() {
      this.I_field_4804a227 = null;
      return this;
   }

   public iIiiiiiiI_Class383 I_method_2aebfd1e(IIiiii_Class16 var1, String var2, float var3, Matrix4f var4, float var5, float var6, float var7) {
      if (var1 != null && var2 != null && !var2.isEmpty() && !(var7 <= 0.0F)) {
         iIiiiiiiI_Class383.Nested1_df1b4060 var8 = this.I_method_242fb640(
            var4, var5 + var1.I_method_c000b13a(var2, var3) / 2.0F, var6 + var1.i_method_a95baee4(var3) / 2.0F
         );
         this.i_field_a567c40b
            .computeIfAbsent(var1, var0 -> new LinkedHashMap<>())
            .computeIfAbsent(var8, var0 -> new ArrayList<>())
            .add(new iIiiiiiiI_Class383.Nested1_44ccc09(new Matrix4f(var4), var2, var3, var5, var6, var7));
         return this;
      } else {
         return this;
      }
   }

   public iIiiiiiiI_Class383 I_method_59318fc7(Matrix4f var1, float var2, float var3, float var4, float var5, float var6) {
      if (!(var4 <= 0.0F) && !(var5 <= 0.0F) && !(var6 <= 0.0F)) {
         this.I_field_a567c40b
            .computeIfAbsent(this.I_method_242fb640(var1, var2 + var4 / 2.0F, var3 + var5 / 2.0F), var0 -> new ArrayList<>())
            .add(new iIiiiiiiI_Class383.Nested1_44ccbe9(new Matrix4f(var1), var2, var3, var4, var5, var6));
         return this;
      } else {
         return this;
      }
   }

   public iIiiiiiiI_Class383 I_method_694f063b(String var1, Matrix4f var2, float var3, float var4, float var5, float var6) {
      Integer var7 = IIiiII_Class13.I_method_d04bdedd(var1);
      if (var7 != null && !(var5 <= 0.0F) && !(var6 <= 0.0F) && IIiiII_Class13.I_method_6bd3fa70()) {
         this.II_field_a567c40b
            .computeIfAbsent(this.I_method_242fb640(var2, var3 + var5 / 2.0F, var4 + var5 / 2.0F), var0 -> new ArrayList<>())
            .add(new iIiiiiiiI_Class383.Nested1_df1b4080(new Matrix4f(var2), var7, var3, var4, var5, var6));
         return this;
      } else {
         return this;
      }
   }

   private iIiiiiiiI_Class383.Nested1_df1b4060 I_method_242fb640(Matrix4f var1, float var2, float var3) {
      return this.I_field_4804a227 != null ? this.I_field_4804a227 : i_method_cb85e660(var1, var2, var3);
   }

   private static iIiiiiiiI_Class383.Nested1_df1b4060 i_method_cb85e660(Matrix4f var0, float var1, float var2) {
      Vector3f var3 = var0.transformPosition(new Vector3f(var1, var2, 0.0F));
      return new iIiiiiiiI_Class383.Nested1_df1b4060(var3.x, var3.y);
   }

   public void I_method_24d5ea1f() {
      this.I_field_4804a227 = null;
      if (!this.I_field_a567c40b.isEmpty() || !this.i_field_a567c40b.isEmpty() || !this.II_field_a567c40b.isEmpty()) {
         iIiiiiIii_Class380.I_method_5f4b621f();
         iIiiIIiii_Class360.I_field_2f5b916c.I_method_25e00c41(this.ii_field_46, this.III_field_46, this.iI_field_46);
         iIiiiiIii_Class380.Ii_method_8a3e6502();
         RenderSystem.disableCull();
         IiIIIi_Class18.I_method_d904a8f7(0, 2, 3);
         RenderSystem.setShaderTexture(1, iIiiIIiii_Class360.I_field_2f5b916c.I_method_6769b12());
         ShaderProgram var1 = iIiiIIiii_Class360.Ii_field_2f5b1d2c.I_method_33f6c16b();
         I_method_6d17c1fc(var1, "LightColor", this.I_field_49);
         I_method_6d17c1fc(var1, "DarkColor", this.i_field_49);
         var1.getUniform("Radius").set(this.Ii_field_46, this.Ii_field_46, this.Ii_field_46, this.Ii_field_46);
         var1.getUniform("RectSmoothness").set(0.5F);

         for (Entry var3 : this.I_field_a567c40b.entrySet()) {
            I_method_7d96f7a4(var1, (iIiiiiiiI_Class383.Nested1_df1b4060)var3.getKey());
            BufferBuilder var4 = I_method_eded907e();
            this.I_method_3a6506e1(var4, (List<iIiiiiiiI_Class383.Nested1_44ccbe9>)var3.getValue());
            I_method_f20859f0(var4);
         }

         for (Entry var12 : this.i_field_a567c40b.entrySet()) {
            IIiiii_Class16 var14 = (IIiiii_Class16)var12.getKey();
            var1.getUniform("Thickness").set(0.0F);

            for (Entry var6 : (Iterable<Entry>)(Iterable<?>)((Map)var12.getValue()).entrySet()) {
               I_method_7d96f7a4(var1, (iIiiiiiiI_Class383.Nested1_df1b4060)var6.getKey());
               BufferBuilder var7 = I_method_eded907e();

               for (iIiiiiiiI_Class383.Nested1_44ccc09 var9 : (Iterable<iIiiiiiiI_Class383.Nested1_44ccc09>)(Iterable<?>)(List)var6.getValue()) {
                  var14.I_method_5811d2b(
                     var9.I_field_d754d74,
                     var7,
                     var9.I_field_523beb0a,
                     var9.I_field_46,
                     var9.i_field_46,
                     var9.II_field_46,
                     0.0F,
                     I_method_75e7c174(var9.Ii_field_46)
                  );
               }

               I_method_f20859f0(var7);
            }
         }

         if (!this.II_field_a567c40b.isEmpty()) {
            IIiiii_Class16 var11 = IIiiII_Class13.I_method_a9f1134b();
            if (var11 != null) {
               var1.getUniform("Thickness").set(0.0F);

               for (Entry var15 : this.II_field_a567c40b.entrySet()) {
                  I_method_7d96f7a4(var1, (iIiiiiiiI_Class383.Nested1_df1b4060)var15.getKey());
                  BufferBuilder var16 = I_method_eded907e();

                  for (iIiiiiiiI_Class383.Nested1_df1b4080 var18 : (Iterable<iIiiiiiiI_Class383.Nested1_df1b4080>)(Iterable<?>)(List)var15.getValue()) {
                     var11.I_method_b398d2fc(
                        var18.I_field_d754d74,
                        var16,
                        var18.I_field_49,
                        var18.I_field_46,
                        var18.i_field_46,
                        var18.II_field_46,
                        I_method_75e7c174(var18.Ii_field_46)
                     );
                  }

                  I_method_f20859f0(var16);
               }
            }
         }

         RenderSystem.setShaderTexture(0, 0);
         RenderSystem.setShaderTexture(1, 0);
         RenderSystem.enableCull();
         RenderSystem.disableBlend();
         this.I_field_a567c40b.clear();
         this.i_field_a567c40b.clear();
         this.II_field_a567c40b.clear();
      }
   }

   private void I_method_3a6506e1(BufferBuilder var1, List<iIiiiiiiI_Class383.Nested1_44ccbe9> var2) {
      float var3 = 0.5F;
      float var4 = -var3 / 2.0F + var3 * 2.0F;
      float var5 = var3 / 2.0F + var3;

      for (iIiiiiiiI_Class383.Nested1_44ccbe9 var7 : var2) {
         float var8 = var7.I_field_46 - var4 / 2.0F;
         float var9 = var7.i_field_46 - var5 / 2.0F;
         float var10 = var7.II_field_46 + var4;
         float var11 = var7.Ii_field_46 + var5;
         int var12 = I_method_75e7c174(var7.iI_field_46);
         var1.vertex(var7.I_field_d754d74, var8, var9, 0.0F).texture(var7.II_field_46, var7.Ii_field_46).color(var12).light(0);
         var1.vertex(var7.I_field_d754d74, var8, var9 + var11, 0.0F).texture(var7.II_field_46, var7.Ii_field_46).color(var12).light(0);
         var1.vertex(var7.I_field_d754d74, var8 + var10, var9 + var11, 0.0F).texture(var7.II_field_46, var7.Ii_field_46).color(var12).light(0);
         var1.vertex(var7.I_field_d754d74, var8 + var10, var9, 0.0F).texture(var7.II_field_46, var7.Ii_field_46).color(var12).light(0);
      }
   }

   private static BufferBuilder I_method_eded907e() {
      return Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR_LIGHT);
   }

   private static void I_method_f20859f0(BufferBuilder var0) {
      BuiltBuffer var1 = var0.endNullable();
      if (var1 != null) {
         BufferRenderer.drawWithGlobalProgram(var1);
      }
   }

   private static int I_method_75e7c174(float var0) {
      int var1 = Math.round(Math.min(1.0F, Math.max(0.0F, var0)) * 255.0F);
      return var1 << 24 | 16777215;
   }

   private static void I_method_7d96f7a4(ShaderProgram var0, iIiiiiiiI_Class383.Nested1_df1b4060 var1) {
      var0.getUniform("Anchor").set(var1.I_method_3667ff4a(), var1.i_method_36768b2a());
   }

   private static void I_method_6d17c1fc(ShaderProgram var0, String var1, int var2) {
      var0.getUniform(var1).set((var2 >> 16 & 0xFF) / 255.0F, (var2 >> 8 & 0xFF) / 255.0F, (var2 & 0xFF) / 255.0F, (var2 >>> 24 & 0xFF) / 255.0F);
   }

   static final class Nested1_44ccbe9 {
      final Matrix4f I_field_d754d74;
      final float I_field_46;
      final float i_field_46;
      final float II_field_46;
      final float Ii_field_46;
      final float iI_field_46;

      Nested1_44ccbe9(Matrix4f var1, float var2, float var3, float var4, float var5, float var6) {
         this.I_field_d754d74 = var1;
         this.I_field_46 = var2;
         this.i_field_46 = var3;
         this.II_field_46 = var4;
         this.Ii_field_46 = var5;
         this.iI_field_46 = var6;
      }

      @Override
      public final String toString() {
         return "Nested1_44ccbe9[matrix=" + this.I_field_d754d74 + ", x=" + this.I_field_46 + ", y=" + this.i_field_46 + ", width=" + this.II_field_46 + ", height=" + this.Ii_field_46 + ", alpha=" + this.iI_field_46 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_d754d74);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.Ii_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.iI_field_46);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIiiiiiiI_Class383.Nested1_44ccbe9 other = (iIiiiiiiI_Class383.Nested1_44ccbe9) var1;
         return java.util.Objects.equals(this.I_field_d754d74, other.I_field_d754d74)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46)
            && java.util.Objects.equals(this.iI_field_46, other.iI_field_46);
      }

      public Matrix4f I_method_4f3c9dcf() {
         return this.I_field_d754d74;
      }

      public float I_method_c33d4161() {
         return this.I_field_46;
      }

      public float i_method_c34bcd41() {
         return this.i_field_46;
      }

      public float II_method_a479e400() {
         return this.II_field_46;
      }

      public float Ii_method_a4886fe0() {
         return this.Ii_field_46;
      }

      public float iI_method_a63cd420() {
         return this.iI_field_46;
      }
   }

   static final class Nested1_44ccc09 {
      final Matrix4f I_field_d754d74;
      final String I_field_523beb0a;
      final float I_field_46;
      final float i_field_46;
      final float II_field_46;
      final float Ii_field_46;

      Nested1_44ccc09(Matrix4f var1, String var2, float var3, float var4, float var5, float var6) {
         this.I_field_d754d74 = var1;
         this.I_field_523beb0a = var2;
         this.I_field_46 = var3;
         this.i_field_46 = var4;
         this.II_field_46 = var5;
         this.Ii_field_46 = var6;
      }

      @Override
      public final String toString() {
         return "Nested1_44ccc09[matrix=" + this.I_field_d754d74 + ", text=" + this.I_field_523beb0a + ", size=" + this.I_field_46 + ", x=" + this.i_field_46 + ", y=" + this.II_field_46 + ", alpha=" + this.Ii_field_46 + "]";
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
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIiiiiiiI_Class383.Nested1_44ccc09 other = (iIiiiiiiI_Class383.Nested1_44ccc09) var1;
         return java.util.Objects.equals(this.I_field_d754d74, other.I_field_d754d74)
            && java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46);
      }

      public Matrix4f I_method_cf6e79af() {
         return this.I_field_d754d74;
      }

      public String I_method_dc9ecb6f() {
         return this.I_field_523beb0a;
      }

      public float I_method_f9d85541() {
         return this.I_field_46;
      }

      public float i_method_f9e6e121() {
         return this.i_field_46;
      }

      public float II_method_41414c20() {
         return this.II_field_46;
      }

      public float Ii_method_414fd800() {
         return this.Ii_field_46;
      }
   }

   static final class Nested1_df1b4060 {
      private final float I_field_46;
      private final float i_field_46;

      Nested1_df1b4060(float var1, float var2) {
         this.I_field_46 = var1;
         this.i_field_46 = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_df1b4060[x=" + this.I_field_46 + ", y=" + this.i_field_46 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_46);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIiiiiiiI_Class383.Nested1_df1b4060 other = (iIiiiiiiI_Class383.Nested1_df1b4060) var1;
         return java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46);
      }

      public float I_method_3667ff4a() {
         return this.I_field_46;
      }

      public float i_method_36768b2a() {
         return this.i_field_46;
      }
   }

   static final class Nested1_df1b4080 {
      final Matrix4f I_field_d754d74;
      final int I_field_49;
      final float I_field_46;
      final float i_field_46;
      final float II_field_46;
      final float Ii_field_46;

      Nested1_df1b4080(Matrix4f var1, int var2, float var3, float var4, float var5, float var6) {
         this.I_field_d754d74 = var1;
         this.I_field_49 = var2;
         this.I_field_46 = var3;
         this.i_field_46 = var4;
         this.II_field_46 = var5;
         this.Ii_field_46 = var6;
      }

      @Override
      public final String toString() {
         return "Nested1_df1b4080[matrix=" + this.I_field_d754d74 + ", codepoint=" + this.I_field_49 + ", x=" + this.I_field_46 + ", y=" + this.i_field_46 + ", size=" + this.II_field_46 + ", alpha=" + this.Ii_field_46 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_d754d74);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
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
         iIiiiiiiI_Class383.Nested1_df1b4080 other = (iIiiiiiiI_Class383.Nested1_df1b4080) var1;
         return java.util.Objects.equals(this.I_field_d754d74, other.I_field_d754d74)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46);
      }

      public Matrix4f I_method_8656ef58() {
         return this.I_field_d754d74;
      }

      public int I_method_6d03132d() {
         return this.I_field_49;
      }

      public float I_method_6d03132a() {
         return this.I_field_46;
      }

      public float i_method_6d119f0a() {
         return this.i_field_46;
      }

      public float II_method_336e4b57() {
         return this.II_field_46;
      }

      public float Ii_method_337cd737() {
         return this.Ii_field_46;
      }
   }
}
