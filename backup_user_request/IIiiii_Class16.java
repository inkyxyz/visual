package rockstar.client;

import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Generated;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;

public final class IIiiii_Class16 {
   public static final float I_field_46 = 0.05F;
   public static final float i_field_46 = 0.0F;
   private static final FontRenderContext I_field_2dfe65ff = new FontRenderContext(null, false, true);
   private static volatile IIiiii_Class16 I_field_857c0621;
   private final String I_field_523beb0a;
   private final Identifier I_field_6a3d6525;
   private final Map<Integer, IiIIII_Class17> I_field_a567c40b = new ConcurrentHashMap<>();
   private Font I_field_26d34efa;
   private float II_field_46 = 0.7F;
   private float Ii_field_46 = 0.75F;
   private float iI_field_46 = -0.25F;
   private float ii_field_46 = 1.0F;
   private static final int I_field_49 = 4096;
   private final ConcurrentHashMap<IIiiii_Class16.Nested1_8a0e0796, Float> I_field_3cacdad0 = new ConcurrentHashMap<>();
   private final ConcurrentHashMap<Integer, IIiIIi_Class10> i_field_3cacdad0 = new ConcurrentHashMap<>();

   public static float I_method_a798bec4(float var0) {
      return 0.025F * var0;
   }

   private IIiiii_Class16(String var1, Identifier var2) {
      this.I_field_523beb0a = var1;
      this.I_field_6a3d6525 = var2;
   }

   public static IIiiii_Class16 I_method_e983174b() {
      IIiiii_Class16 var0 = I_field_857c0621;
      if (var0 != null) {
         return var0;
      } else {
         synchronized (IIiiii_Class16.class) {
            if (I_field_857c0621 == null) {
               IIiiii_Class16 var2 = new IIiiii_Class16("fallback", null);
               var2.I_field_26d34efa = I_method_d3d90717("Segoe UI", "Helvetica Neue", "DejaVu Sans", "Arial", "SansSerif");
               var2.Ii_method_a7b5da55();
               I_field_857c0621 = var2;
            }

            return I_field_857c0621;
         }
      }
   }

   private static Font I_method_d3d90717(String... var0) {
      for (String var4 : var0) {
         Font var5 = new Font(var4, 0, 1).deriveFont(2048.0F);
         if (var5.canDisplay('\u1d00') || var4.equals("SansSerif")) {
            return var5;
         }
      }

      return new Font("SansSerif", 0, 1).deriveFont(2048.0F);
   }

   public synchronized void I_method_3f36766c() {
      this.I_field_a567c40b.clear();
      this.I_field_3cacdad0.clear();
      if (this.I_field_6a3d6525 != null) {
         try (InputStream var1 = MinecraftClient.getInstance().getResourceManager().open(this.I_field_6a3d6525)) {
            this.I_field_26d34efa = Font.createFont(0, var1).deriveFont(2048.0F);
         } catch (Exception var6) {
            RockstarClient.I_field_ab0f6068
               .error(
                  "[slug] \u043d\u0435 \u0447\u0438\u0442\u0430\u0435\u0442\u0441\u044f \u0448\u0440\u0438\u0444\u0442 {}: {}",
                  this.I_field_6a3d6525,
                  var6.toString()
               );
            this.I_field_26d34efa = I_method_e983174b().I_field_26d34efa;
         }

         this.Ii_method_a7b5da55();
      }
   }

   private void II_method_a7a74e75() {
      if (this.I_field_26d34efa == null && this.I_field_6a3d6525 != null) {
         this.I_method_3f36766c();
      }
   }

   private void Ii_method_a7b5da55() {
      LineMetrics var1 = this.I_field_26d34efa.getLineMetrics("Hg", I_field_2dfe65ff);
      this.Ii_field_46 = var1.getAscent() / 2048.0F;
      this.iI_field_46 = -var1.getDescent() / 2048.0F;
      this.ii_field_46 = var1.getHeight() / 2048.0F;
      Rectangle2D var2 = this.I_field_26d34efa.createGlyphVector(I_field_2dfe65ff, "H").getOutline().getBounds2D();
      this.II_field_46 = var2.getHeight() > 0.0 ? (float)(-var2.getMinY() / 2048.0) : Math.max(0.1F, this.Ii_field_46 * 0.72F);
   }

   public IiIIII_Class17 I_method_3e06ef20(int var1) {
      IiIIII_Class17 var2 = this.I_field_a567c40b.get(var1);
      if (var2 != null) {
         return var2;
      } else {
         this.II_method_a7a74e75();
         if (this.I_field_26d34efa != null && this.I_field_26d34efa.canDisplay(var1)) {
            IiIIii_Class20 var3 = IiIIii_Class20.I_method_2b013b05(this.I_field_26d34efa, I_field_2dfe65ff, var1);
            int var4 = var3.I_method_43b11e50() ? -1 : IiIiIi_Class22.I_method_bdb4d34b().I_method_5c3c5ae0(IiIIiI_Class19.I_method_2760596a(var3));
            IiIIII_Class17 var5 = new IiIIII_Class17(var1, var4, var3.ii_field_46, var3.i_field_46, var3.II_field_46, var3.Ii_field_46, var3.iI_field_46);
            IiIIII_Class17 var6 = this.I_field_a567c40b.putIfAbsent(var1, var5);
            return var6 != null ? var6 : var5;
         } else {
            return null;
         }
      }
   }

   public IiIIII_Class17 i_method_5827db00(int var1) {
      IiIIII_Class17 var2 = this.I_method_3e06ef20(var1);
      if (var2 != null) {
         return var2;
      } else {
         IIiiii_Class16 var3 = I_method_e983174b();
         return var3 == this ? null : var3.I_method_3e06ef20(var1);
      }
   }

   public boolean I_method_a798b395(char var1) {
      return this.i_method_5827db00(var1) != null;
   }

   public boolean I_method_b398d2fc(Matrix4f var1, VertexConsumer var2, int var3, float var4, float var5, float var6, int var7) {
      IiIIII_Class17 var8 = this.i_method_5827db00(var3);
      if (var8 == null) {
         return false;
      } else {
         var8.I_method_4afb96f1(var1, var2, var4, var5, var6, var7);
         return true;
      }
   }

   public void I_method_ed6b5d36(String var1) {
      for (int var2 = 0; var2 < var1.length(); var2++) {
         this.i_method_5827db00(var1.charAt(var2));
      }
   }

   public float I_method_3f36765c() {
      this.II_method_a7a74e75();
      return this.II_field_46;
   }

   public float i_method_3f45023c() {
      this.II_method_a7a74e75();
      return this.Ii_field_46;
   }

   public float II_method_a7a74e65() {
      this.II_method_a7a74e75();
      return this.iI_field_46;
   }

   public float Ii_method_a7b5da45() {
      this.II_method_a7a74e75();
      return this.ii_field_46;
   }

   public float i_method_a95baee4(float var1) {
      return this.I_method_3f36765c() * var1;
   }

   public float II_method_4d42e7db(float var1) {
      return this.Ii_method_a7b5da45() * var1;
   }

   public float I_method_4b7f835c(float var1, float var2) {
      return var1 + this.I_method_3f36765c() * var2;
   }

   public static String I_method_f519ea2a(String var0) {
      return var0;
   }

   private float I_method_e71fc7e2(String var1, float var2, float var3, IIiiii_Class16.Nested1_ebaddf53 var4) {
      float var5 = I_method_a798bec4(var2);
      float var6 = var3;
      boolean var7 = false;

      for (int var8 = 0; var8 < var1.length(); var8++) {
         char var9 = var1.charAt(var8);
         if (var7) {
            var7 = false;
         } else if (var9 == 167) {
            var7 = true;
         } else {
            IiIIII_Class17 var10 = this.i_method_5827db00(var9);
            if (var10 != null) {
               if (var4 != null) {
                  var4.place(var10, var6);
               }

               var6 += var10.I_method_704ea23c() * var2 + var5;
            }
         }
      }

      return var6;
   }

   public void I_method_5811d2b(Matrix4f var1, VertexConsumer var2, String var3, float var4, float var5, float var6, float var7, int var8) {
      this.I_method_aaa2eff5(var1, var2, var3, var4, var5, var6, var7, var8, 1.0F);
   }

   public void I_method_aaa2eff5(Matrix4f var1, VertexConsumer var2, String var3, float var4, float var5, float var6, float var7, int var8, float var9) {
      float var10 = this.I_method_4b7f835c(var6, var4);
      this.I_method_e71fc7e2(var3, var4, var5, (var7x, var8x) -> var7x.I_method_7a55ad3b(var1, var2, var4, var8x, var10, var7, var8, var9));
   }

   public void I_method_7bba9b9e(String var1, float var2, float var3, float var4, float var5, int var6, IIiiii_Class16.Nested1_8a0e0776 var7) {
      float var8 = this.I_method_4b7f835c(var4, var2);
      this.I_method_e71fc7e2(var1, var2, var3, (var5x, var6x) -> var7.I_method_61cd0f5e(var5x, var2, var6x, var8, var5, var6));
   }

   public void I_method_ebff3dc7(String var1, float var2, float var3, float var4, IIiiii_Class16 var5, IIiiii_Class16.Nested1_ebaddf33 var6) {
      float var7 = this.I_method_4b7f835c(var4, var2);
      float var8 = I_method_a798bec4(var2);
      float var9 = var3;
      boolean var10 = false;

      for (int var11 = 0; var11 < var1.length(); var11++) {
         char var12 = var1.charAt(var11);
         if (var10) {
            var10 = false;
         } else if (var12 == 167) {
            var10 = true;
         } else {
            IiIIII_Class17 var13 = this.I_method_3e06ef20(var12);
            IIiiii_Class16 var14 = this;
            if (var13 == null) {
               var14 = I_method_e983174b();
               var13 = var14.I_method_3e06ef20(var12);
            }

            var6.visit(var14, var13, var12, var9, var7);
            if (var13 != null) {
               var9 += var13.I_method_704ea23c() * var2 + var8;
            }
         }
      }
   }

   public float I_method_bdbecc1b(String var1, float var2, IIiiii_Class16 var3) {
      return this.I_method_c000b13a(var1, var2);
   }

   public void I_method_5a5b6f48(
      Matrix4f var1, VertexConsumer var2, String var3, float var4, float var5, float var6, float var7, int var8, IIiiii_Class16 var9, boolean var10
   ) {
      if (!var10) {
         this.I_method_5811d2b(var1, var2, var3, var4, var5, var6, var7, var8);
      }
   }

   public float I_method_c000b13a(@Nullable String var1, float var2) {
      if (var1 != null && !var1.isEmpty()) {
         IIiiii_Class16.Nested1_8a0e0796 var3 = new IIiiii_Class16.Nested1_8a0e0796(var1, var2);
         Float var4 = this.I_field_3cacdad0.get(var3);
         if (var4 != null) {
            return var4;
         } else {
            float var5 = this.I_method_e71fc7e2(var1, var2, 0.0F, null);
            if (this.I_field_3cacdad0.size() >= 4096) {
               this.I_field_3cacdad0.clear();
            }

            this.I_field_3cacdad0.put(var3, var5);
            return var5;
         }
      } else {
         return 0.0F;
      }
   }

   public void i_method_3f45024c() {
      this.I_field_3cacdad0.clear();
   }

   public float I_method_a03b5896(Text var1, float var2) {
      return this.I_method_c000b13a(var1.getString(), var2);
   }

   public float I_method_4b7e263f(char var1, float var2) {
      IiIIII_Class17 var3 = this.i_method_5827db00(var1);
      return var3 == null ? 0.0F : var3.I_method_704ea23c() * var2 + I_method_a798bec4(var2);
   }

   public IIiIIi_Class10 I_method_3a2d5e3(float var1) {
      return this.i_field_3cacdad0.computeIfAbsent(Float.floatToIntBits(var1), var2 -> new IIiIIi_Class10(this, var1));
   }

   public static IIiiii_Class16 I_method_6047f1b7(String var0, String var1) {
      return new IIiiii_Class16(var0, Identifier.of(RockstarClient.II_field_523beb0a, "fonts/" + var1 + ".otf"));
   }

   public static IIiiii_Class16 I_method_c0662d41(String var0) {
      return new IIiiii_Class16(var0, null);
   }

   public IiIIII_Class17 I_method_49bd623f(int var1, IiIIii_Class20 var2) {
      int var3 = var2.I_method_43b11e50() ? -1 : IiIiIi_Class22.I_method_bdb4d34b().I_method_5c3c5ae0(IiIIiI_Class19.I_method_2760596a(var2));
      IiIIII_Class17 var4 = new IiIIII_Class17(var1, var3, var2.ii_field_46, var2.i_field_46, var2.II_field_46, var2.Ii_field_46, var2.iI_field_46);
      this.I_field_a567c40b.put(var1, var4);
      return var4;
   }

   public static IIiiii_Class16 i_method_147e7d61(String var0) {
      IIiiii_Class16 var1 = new IIiiii_Class16(var0, null);
      var1.I_field_26d34efa = I_method_e983174b().I_field_26d34efa;
      var1.Ii_method_a7b5da55();
      return var1;
   }

   public synchronized void I_method_20decac8(Font var1) {
      this.I_field_a567c40b.clear();
      this.I_field_3cacdad0.clear();
      this.I_field_26d34efa = var1.getSize2D() == 2048.0F ? var1 : var1.deriveFont(2048.0F);
      this.Ii_method_a7b5da55();
   }

   public Font getFont() {
      this.II_method_a7a74e75();
      return this.I_field_26d34efa;
   }

   public static IIiiii_Class16 I_method_9e671ab9(String var0, Font var1) {
      IIiiii_Class16 var2 = new IIiiii_Class16(var0, null);
      var2.I_field_26d34efa = var1.getSize2D() == 2048.0F ? var1 : var1.deriveFont(2048.0F);
      var2.Ii_method_a7b5da55();
      return var2;
   }

   @Generated
   public String I_method_c889a3b4() {
      return this.I_field_523beb0a;
   }

   @FunctionalInterface
   public interface Nested1_8a0e0776 {
      void I_method_61cd0f5e(IiIIII_Class17 var1, float var2, float var3, float var4, float var5, int var6);
   }

   static final class Nested1_8a0e0796 {
      private final String I_field_523beb0a;
      private final float I_field_46;

      Nested1_8a0e0796(String var1, float var2) {
         this.I_field_523beb0a = var1;
         this.I_field_46 = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_8a0e0796[text=" + this.I_field_523beb0a + ", size=" + this.I_field_46 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IIiiii_Class16.Nested1_8a0e0796 other = (IIiiii_Class16.Nested1_8a0e0796) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46);
      }

      public String I_method_77432f3c() {
         return this.I_field_523beb0a;
      }

      public float I_method_833f49d4() {
         return this.I_field_46;
      }
   }

   @FunctionalInterface
   public interface Nested1_ebaddf33 {
      void visit(IIiiii_Class16 var1, IiIIII_Class17 var2, char var3, float var4, float var5);
   }

   @FunctionalInterface
   interface Nested1_ebaddf53 {
      void place(IiIIII_Class17 var1, float var2);
   }
}
