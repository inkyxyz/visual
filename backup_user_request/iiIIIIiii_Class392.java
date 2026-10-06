package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gl.ShaderProgram;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.text.Text;
import org.joml.Matrix4f;
import pyrock.utility.render.ColorRGBA;

public class iiIIIIiii_Class392 {
   private static final float I_field_46 = 0.0F;
   private static final float i_field_46 = 0.5F;
   private final IIiiii_Class16 I_field_857c0621;
   private final float II_field_46;
   private final List<iiIIIIiii_Class392.Nested1_1033e480> I_field_7865b31 = new ArrayList<>();
   private final List<iiIIIIiii_Class392.Nested1_1033e460> i_field_7865b31 = new ArrayList<>();
   private final List<iiIIIIiii_Class392.Nested1_f648a7e9> II_field_7865b31 = new ArrayList<>();
   private final List<iiIIIIiii_Class392.Nested1_f648a7e9> Ii_field_7865b31 = new ArrayList<>();
   private boolean I_field_5a;
   private final List<iiIIIIiii_Class392.Nested1_1033e480> iI_field_7865b31 = new ArrayList<>();
   private int I_field_49 = 0;
   private float Ii_field_46 = 0.0F;
   private float iI_field_46 = 0.0F;

   public iiIIIIiii_Class392(IIiiii_Class16 var1, float var2) {
      this.I_field_857c0621 = var1;
      this.II_field_46 = var2;
   }

   public void I_method_184247c4(int var1, float var2, float var3) {
      this.I_field_49 = var1;
      this.Ii_field_46 = var2;
      this.iI_field_46 = var3;
   }

   public void I_method_97950030(Matrix4f var1, float var2, float var3, float var4, float var5, ColorRGBA var6) {
      this.I_method_662ac30(var1, var2, var3, var4, var5, var6, var2, var4);
   }

   public void I_method_662ac30(Matrix4f var1, float var2, float var3, float var4, float var5, ColorRGBA var6, float var7, float var8) {
      this.I_field_7865b31.add(new iiIIIIiii_Class392.Nested1_1033e480(new Matrix4f(var1), var2, var3, var4, var5, var6.getRGB(), var7, var8));
   }

   public void I_method_67f0d71(Matrix4f var1, float var2, float var3, float var4, float var5, float var6) {
      this.I_method_c963086f(var1, var2, var3, var4, var5, var6, var2);
   }

   public void I_method_df2d602f(Matrix4f var1, float var2, float var3, float var4, float var5) {
      this.iI_field_7865b31.add(new iiIIIIiii_Class392.Nested1_1033e480(new Matrix4f(var1), var2, var3, var4, var5, 0, var2, var4));
   }

   public void I_method_c963086f(Matrix4f var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.i_field_7865b31.add(new iiIIIIiii_Class392.Nested1_1033e460(new Matrix4f(var1), var2, var3, var4, var5, var6, var7));
   }

   public void I_method_2cf0d2ea(Matrix4f var1, String var2, float var3, float var4, float var5, float var6, int var7) {
      Matrix4f var8 = new Matrix4f(var1);
      String var9 = IIIiIiIi_Class22.I_method_7f49082a(var2);
      this.II_field_7865b31.add(new iiIIIIiii_Class392.Nested1_f648a7e9(var8, var9, var3, var4, var5, var6, var7));
      if (IIIiIiIi_Class22.II_method_40fdec79()) {
         this.Ii_field_7865b31
            .add(var9 == var2 ? this.II_field_7865b31.getLast() : new iiIIIIiii_Class392.Nested1_f648a7e9(var8, var2, var3, var4, var5, var6, var7));
         this.I_field_5a |= var9 != var2;
      }
   }

   public void I_method_5538aef7(Matrix4f var1, Text var2, float var3, float var4, float var5, float var6) {
      this.I_method_51dd97a9(var1, var2, var3, var4, var5, var6, var4);
   }

   public void I_method_51dd97a9(Matrix4f var1, Text var2, float var3, float var4, float var5, float var6, float var7) {
      Matrix4f var8 = new Matrix4f(var1);
      boolean var9 = IIIiIiIi_Class22.II_method_40fdec79();
      float var10 = var4;
      float var11 = var7;

      for (IIiIii_Class12.Nested1_e9eaef13 var13 : IIiIii_Class12.I_method_8847bf1e(var2, IiiiiIIIi_Class242.Ii_field_d0c8ec5.getRGB())) {
         String var14 = IIIiIiIi_Class22.I_method_7f49082a(var13.I_field_523beb0a);
         this.II_field_7865b31.add(new iiIIIIiii_Class392.Nested1_f648a7e9(var8, var14, var3, var10, var5, var6, var13.I_field_49));
         var10 += this.I_field_857c0621.I_method_c000b13a(var14, var3);
         if (var9) {
            this.Ii_field_7865b31.add(new iiIIIIiii_Class392.Nested1_f648a7e9(var8, var13.I_field_523beb0a, var3, var11, var5, var6, var13.I_field_49));
            var11 += this.I_field_857c0621.I_method_c000b13a(var13.I_field_523beb0a, var3);
            this.I_field_5a = this.I_field_5a | var14 != var13.I_field_523beb0a;
         }
      }
   }

   public float I_method_4f299e89(Text var1, float var2) {
      return I_method_e4abc32a(this.I_field_857c0621, var1, var2);
   }

   public static float I_method_e4abc32a(IIiiii_Class16 var0, Text var1, float var2) {
      float var3 = 0.0F;

      for (IIiIii_Class12.Nested1_e9eaef13 var5 : IIiIii_Class12.I_method_8847bf1e(var1, IiiiiIIIi_Class242.Ii_field_d0c8ec5.getRGB())) {
         var3 += var0.I_method_c000b13a(IIIiIiIi_Class22.I_method_7f49082a(var5.I_field_523beb0a), var2);
      }

      return var3;
   }

   public void I_method_874ac61f() {
      if (!this.I_field_7865b31.isEmpty() || !this.i_field_7865b31.isEmpty() || !this.II_field_7865b31.isEmpty()) {
         iIiiiiIii_Class380.I_method_5f4b621f();
         if (this.I_field_5a) {
            IIIiIiIi_Class22.I_method_3ee425f8(
               this.I_method_620dfea5(), () -> this.I_method_3ac4422(this.I_field_7865b31, this.i_field_7865b31, this.Ii_field_7865b31, true)
            );
         }

         this.I_method_3ac4422(this.I_field_7865b31, this.i_field_7865b31, this.II_field_7865b31, false);
         this.I_field_7865b31.clear();
         this.i_field_7865b31.clear();
         this.II_field_7865b31.clear();
         this.Ii_field_7865b31.clear();
         this.iI_field_7865b31.clear();
         this.I_field_5a = false;
      }
   }

   private int[] I_method_620dfea5() {
      if (!this.I_field_5a) {
         return null;
      } else {
         int[] var1 = null;

         for (iiIIIIiii_Class392.Nested1_1033e480 var3 : this.I_field_7865b31) {
            var1 = IIIiIiIi_Class22.I_method_db730cdc(
               var1,
               IIIiIiIi_Class22.I_method_a0f921e2(
                  var3.I_field_d754d74,
                  var3.I_field_46 - 2.0F,
                  var3.i_field_46 - 2.0F,
                  var3.I_field_46 + var3.II_field_46 + 2.0F,
                  var3.i_field_46 + var3.Ii_field_46 + 2.0F
               )
            );
            var1 = IIIiIiIi_Class22.I_method_db730cdc(
               var1,
               IIIiIiIi_Class22.I_method_a0f921e2(
                  var3.I_field_d754d74,
                  var3.iI_field_46 - 2.0F,
                  var3.i_field_46 - 2.0F,
                  var3.iI_field_46 + var3.ii_field_46 + 2.0F,
                  var3.i_field_46 + var3.Ii_field_46 + 2.0F
               )
            );
         }

         for (iiIIIIiii_Class392.Nested1_1033e460 var10 : this.i_field_7865b31) {
            var1 = IIIiIiIi_Class22.I_method_db730cdc(
               var1,
               IIIiIiIi_Class22.I_method_a0f921e2(
                  var10.I_field_d754d74,
                  var10.I_field_46 - 2.0F,
                  var10.i_field_46 - 2.0F,
                  var10.I_field_46 + this.Ii_field_46 + 2.0F,
                  var10.i_field_46 + this.Ii_field_46 + 2.0F
               )
            );
            var1 = IIIiIiIi_Class22.I_method_db730cdc(
               var1,
               IIIiIiIi_Class22.I_method_a0f921e2(
                  var10.I_field_d754d74,
                  var10.ii_field_46 - 2.0F,
                  var10.i_field_46 - 2.0F,
                  var10.ii_field_46 + this.Ii_field_46 + 2.0F,
                  var10.i_field_46 + this.Ii_field_46 + 2.0F
               )
            );
         }

         for (iiIIIIiii_Class392.Nested1_f648a7e9 var11 : this.II_field_7865b31) {
            var1 = IIIiIiIi_Class22.I_method_db730cdc(var1, this.I_method_238977bf(var11));
         }

         for (iiIIIIiii_Class392.Nested1_f648a7e9 var12 : this.Ii_field_7865b31) {
            var1 = IIIiIiIi_Class22.I_method_db730cdc(var1, this.I_method_238977bf(var12));
         }

         for (iiIIIIiii_Class392.Nested1_1033e480 var13 : this.iI_field_7865b31) {
            var1 = IIIiIiIi_Class22.I_method_db730cdc(
               var1,
               IIIiIiIi_Class22.I_method_a0f921e2(
                  var13.I_field_d754d74,
                  var13.I_field_46 - 2.0F,
                  var13.i_field_46 - 2.0F,
                  var13.I_field_46 + var13.II_field_46 + 2.0F,
                  var13.i_field_46 + var13.Ii_field_46 + 2.0F
               )
            );
         }

         return var1;
      }
   }

   private int[] I_method_238977bf(iiIIIIiii_Class392.Nested1_f648a7e9 var1) {
      return IIIiIiIi_Class22.I_method_a0f921e2(
         var1.I_field_d754d74,
         var1.i_field_46 - 1.0F,
         var1.II_field_46 - var1.I_field_46 * 0.35F,
         var1.i_field_46 + this.I_field_857c0621.I_method_c000b13a(var1.I_field_523beb0a, var1.I_field_46) + 1.0F,
         var1.II_field_46 + var1.I_field_46 * 1.45F
      );
   }

   private void I_method_3ac4422(
      List<iiIIIIiii_Class392.Nested1_1033e480> var1,
      List<iiIIIIiii_Class392.Nested1_1033e460> var2,
      List<iiIIIIiii_Class392.Nested1_f648a7e9> var3,
      boolean var4
   ) {
      if (!var1.isEmpty() || !var2.isEmpty() || !var3.isEmpty()) {
         RenderSystem.enableBlend();
         RenderSystem.defaultBlendFunc();
         RenderSystem.disableCull();
         IiIIIi_Class18.I_method_d904a8f7(0, 2, 3);
         RenderSystem.setShaderTexture(1, this.I_field_49);
         ShaderProgram var5 = iIiiIIiii_Class360.II_field_2f5b1d2c.I_method_33f6c16b();
         var5.getUniform("Radius").set(this.II_field_46, this.II_field_46, this.II_field_46, this.II_field_46);
         var5.getUniform("RectSmoothness").set(0.5F);
         var5.getUniform("CornerSmoothness").set(2.0F);
         var5.getUniform("TextThickness").set(0.0F);
         var5.getUniform("HeadSize").set(this.Ii_field_46, this.Ii_field_46);
         var5.getUniform("HeadRadius").set(this.iI_field_46, this.iI_field_46, this.iI_field_46, this.iI_field_46);
         var5.getUniform("HeadSmoothness").set(0.5F);
         BufferBuilder var6 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR_LIGHT);
         float var7 = 0.5F;
         float var8 = -var7 / 2.0F + var7 * 2.0F;
         float var9 = var7 / 2.0F + var7;

         for (iiIIIIiii_Class392.Nested1_1033e480 var11 : var1) {
            float var12 = var4 ? var11.iI_field_46 : var11.I_field_46;
            float var13 = var4 ? var11.ii_field_46 : var11.II_field_46;
            float var14 = var12 - var8 / 2.0F;
            float var15 = var11.i_field_46 - var9 / 2.0F;
            float var16 = var13 + var8;
            float var17 = var11.Ii_field_46 + var9;
            var6.vertex(var11.I_field_d754d74, var14, var15, 0.0F).texture(var13, var11.Ii_field_46).color(var11.I_field_49).light(0);
            var6.vertex(var11.I_field_d754d74, var14, var15 + var17, 0.0F).texture(var13, var11.Ii_field_46).color(var11.I_field_49).light(0);
            var6.vertex(var11.I_field_d754d74, var14 + var16, var15 + var17, 0.0F).texture(var13, var11.Ii_field_46).color(var11.I_field_49).light(0);
            var6.vertex(var11.I_field_d754d74, var14 + var16, var15, 0.0F).texture(var13, var11.Ii_field_46).color(var11.I_field_49).light(0);
         }

         for (iiIIIIiii_Class392.Nested1_1033e460 var23 : var2) {
            float var25 = (var4 ? var23.ii_field_46 : var23.I_field_46) - var8 / 2.0F;
            float var26 = var23.i_field_46 - var9 / 2.0F;
            float var27 = this.Ii_field_46 + var8;
            float var28 = this.Ii_field_46 + var9;
            float var29 = var23.II_field_46 - 2.0F;
            float var30 = var23.Ii_field_46 - 2.0F;
            float var18 = var23.II_field_46 + var23.iI_field_46 - 2.0F;
            float var19 = var23.Ii_field_46 + var23.iI_field_46 - 2.0F;
            var6.vertex(var23.I_field_d754d74, var25, var26, 0.0F).texture(var29, var30).color(-1).light(0);
            var6.vertex(var23.I_field_d754d74, var25, var26 + var28, 0.0F).texture(var29, var19).color(-1).light(0);
            var6.vertex(var23.I_field_d754d74, var25 + var27, var26 + var28, 0.0F).texture(var18, var19).color(-1).light(0);
            var6.vertex(var23.I_field_d754d74, var25 + var27, var26, 0.0F).texture(var18, var30).color(-1).light(0);
         }

         for (iiIIIIiii_Class392.Nested1_f648a7e9 var24 : var3) {
            this.I_field_857c0621
               .I_method_5811d2b(
                  var24.I_field_d754d74,
                  var6,
                  var24.I_field_523beb0a,
                  var24.I_field_46,
                  var24.i_field_46,
                  var24.II_field_46,
                  var24.Ii_field_46,
                  var24.I_field_49
               );
         }

         BuiltBuffer var22 = var6.endNullable();
         if (var22 != null) {
            BufferRenderer.drawWithGlobalProgram(var22);
         }

         RenderSystem.setShaderTexture(0, 0);
         RenderSystem.setShaderTexture(1, 0);
         RenderSystem.enableCull();
         RenderSystem.disableBlend();
      }
   }

   static final class Nested1_1033e460 {
      final Matrix4f I_field_d754d74;
      final float I_field_46;
      final float i_field_46;
      final float II_field_46;
      final float Ii_field_46;
      final float iI_field_46;
      final float ii_field_46;

      Nested1_1033e460(Matrix4f var1, float var2, float var3, float var4, float var5, float var6, float var7) {
         this.I_field_d754d74 = var1;
         this.I_field_46 = var2;
         this.i_field_46 = var3;
         this.II_field_46 = var4;
         this.Ii_field_46 = var5;
         this.iI_field_46 = var6;
         this.ii_field_46 = var7;
      }

      @Override
      public final String toString() {
         return "Nested1_1033e460[matrix=" + this.I_field_d754d74 + ", x=" + this.I_field_46 + ", y=" + this.i_field_46 + ", u0=" + this.II_field_46 + ", v0=" + this.Ii_field_46 + ", uv=" + this.iI_field_46 + ", realX=" + this.ii_field_46 + "]";
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
         result = 31 * result + java.util.Objects.hashCode(this.ii_field_46);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iiIIIIiii_Class392.Nested1_1033e460 other = (iiIIIIiii_Class392.Nested1_1033e460) var1;
         return java.util.Objects.equals(this.I_field_d754d74, other.I_field_d754d74)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46)
            && java.util.Objects.equals(this.iI_field_46, other.iI_field_46)
            && java.util.Objects.equals(this.ii_field_46, other.ii_field_46);
      }

      public Matrix4f I_method_1993ef78() {
         return this.I_field_d754d74;
      }

      public float I_method_cf15db4a() {
         return this.I_field_46;
      }

      public float i_method_cf24672a() {
         return this.i_field_46;
      }

      public float II_method_13b48737() {
         return this.II_field_46;
      }

      public float Ii_method_13c31317() {
         return this.Ii_field_46;
      }

      public float iI_method_15777757() {
         return this.iI_field_46;
      }

      public float ii_method_15860337() {
         return this.ii_field_46;
      }
   }

   static final class Nested1_1033e480 {
      final Matrix4f I_field_d754d74;
      final float I_field_46;
      final float i_field_46;
      final float II_field_46;
      final float Ii_field_46;
      final int I_field_49;
      final float iI_field_46;
      final float ii_field_46;

      Nested1_1033e480(Matrix4f var1, float var2, float var3, float var4, float var5, int var6, float var7, float var8) {
         this.I_field_d754d74 = var1;
         this.I_field_46 = var2;
         this.i_field_46 = var3;
         this.II_field_46 = var4;
         this.Ii_field_46 = var5;
         this.I_field_49 = var6;
         this.iI_field_46 = var7;
         this.ii_field_46 = var8;
      }

      @Override
      public final String toString() {
         return "Nested1_1033e480[matrix=" + this.I_field_d754d74 + ", x=" + this.I_field_46 + ", y=" + this.i_field_46 + ", width=" + this.II_field_46 + ", height=" + this.Ii_field_46 + ", rgba=" + this.I_field_49 + ", realX=" + this.iI_field_46 + ", realWidth=" + this.ii_field_46 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_d754d74);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.Ii_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.iI_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.ii_field_46);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iiIIIIiii_Class392.Nested1_1033e480 other = (iiIIIIiii_Class392.Nested1_1033e480) var1;
         return java.util.Objects.equals(this.I_field_d754d74, other.I_field_d754d74)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.iI_field_46, other.iI_field_46)
            && java.util.Objects.equals(this.ii_field_46, other.ii_field_46);
      }

      public Matrix4f I_method_99c5cb58() {
         return this.I_field_d754d74;
      }

      public float I_method_5b0ef2a() {
         return this.I_field_46;
      }

      public float i_method_5bf7b0a() {
         return this.i_field_46;
      }

      public float II_method_b07bef57() {
         return this.II_field_46;
      }

      public float Ii_method_b08a7b37() {
         return this.Ii_field_46;
      }

      public int I_method_5b0ef2d() {
         return this.I_field_49;
      }

      public float iI_method_b23edf77() {
         return this.iI_field_46;
      }

      public float ii_method_b24d6b57() {
         return this.ii_field_46;
      }
   }

   static final class Nested1_f648a7e9 {
      final Matrix4f I_field_d754d74;
      final String I_field_523beb0a;
      final float I_field_46;
      final float i_field_46;
      final float II_field_46;
      final float Ii_field_46;
      final int I_field_49;

      Nested1_f648a7e9(Matrix4f var1, String var2, float var3, float var4, float var5, float var6, int var7) {
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
         return "Nested1_f648a7e9[matrix=" + this.I_field_d754d74 + ", text=" + this.I_field_523beb0a + ", size=" + this.I_field_46 + ", x=" + this.i_field_46 + ", y=" + this.II_field_46 + ", z=" + this.Ii_field_46 + ", color=" + this.I_field_49 + "]";
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
         iiIIIIiii_Class392.Nested1_f648a7e9 other = (iiIIIIiii_Class392.Nested1_f648a7e9) var1;
         return java.util.Objects.equals(this.I_field_d754d74, other.I_field_d754d74)
            && java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49);
      }

      public Matrix4f I_method_a9a941cf() {
         return this.I_field_d754d74;
      }

      public String I_method_a9da7f4f() {
         return this.I_field_523beb0a;
      }

      public float I_method_404ae561() {
         return this.I_field_46;
      }

      public float i_method_40597141() {
         return this.i_field_46;
      }

      public float II_method_c920c000() {
         return this.II_field_46;
      }

      public float Ii_method_c92f4be0() {
         return this.Ii_field_46;
      }

      public int I_method_404ae564() {
         return this.I_field_49;
      }
   }
}
