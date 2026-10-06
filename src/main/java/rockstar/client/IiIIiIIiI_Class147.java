package rockstar.client;

import net.minecraft.util.math.MathHelper;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;

public final class IiIIiIIiI_Class147 {
   private IiIIiIIiI_Class147() {
   }

   public static void I_method_856ade58(CustomDrawContext var0, String var1, double var2, ColorRGBA var4, float var5) {
      float var6 = MathHelper.clamp(var5, 0.0F, 1.0F);
      if (!(var6 <= 0.01F)) {
         String var7 = I_method_aa1e24c1(var2);
         float var8 = var6 * InterfaceModule.I_method_fdcdb22f();
         float var9 = var6 * InterfaceModule.i_method_fddc3e0f();
         if (var8 > 0.01F) {
            I_method_65163d12(var0, var1, var7, var4, var8);
         }

         if (var9 > 0.01F) {
            i_method_94a8f532(var0, var1, var7, var4, var9);
         }
      }
   }

   public static IiIIiIIiI_Class147.Nested1_ea18c20 I_method_ccaff086(String var0, double var1) {
      String var3 = I_method_aa1e24c1(var1);
      float var4 = 0.0F;
      float var5 = 0.0F;
      float var6 = 0.0F;
      float var7 = 0.0F;
      boolean var8 = false;
      if (InterfaceModule.I_method_fdcdb22f() > 0.01F) {
         IIiIIi_Class10 var9 = IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(10.0F);
         IIiIIi_Class10 var10 = IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(9.0F);
         float var11 = 6.0F;
         float var12 = 21.0F;
         float var13 = 18.0F;
         float var14 = 8.0F;
         float var15 = Math.max(var14 * 2.0F + var11 + 8.0F + var9.I_method_2c375926(var0), 52.0F) - 1.0F;
         float var16 = Math.max(var10.I_method_2c375926(var3) + 16.0F, 32.0F) + 1.0F;
         float var17 = 4.0F;
         float var18 = var17 + var12 + 3.0F;
         float var19 = Math.max(var15, var16) / 2.0F;
         var4 = -var19;
         var5 = var19;
         var6 = var17;
         var7 = var18 + var13;
         var8 = true;
      }

      if (InterfaceModule.i_method_fddc3e0f() > 0.01F) {
         IIiIIi_Class10 var24 = IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(9.0F);
         IIiIIi_Class10 var25 = IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(8.0F);
         float var26 = 21.0F;
         float var27 = 6.0F;
         float var28 = 8.0F;
         float var29 = 6.0F;
         float var30 = 6.0F;
         float var31 = 7.0F;
         float var32 = I_method_9de22d31(var24.I_method_2c375926(var0));
         float var33 = I_method_9de22d31(var25.I_method_2c375926(var3));
         float var34 = I_method_9de22d31(var33 + var31 * 2.0F);
         float var20 = var27 + var29 + var32 + var30 + var34;
         float var21 = I_method_9de22d31(var20 + var28 * 2.0F) - 7.0F;
         float var22 = var21 / 2.0F;
         float var23 = 5.5F;
         if (!var8) {
            var4 = -var22;
            var5 = var22;
            var6 = var23;
            var7 = var23 + var26;
            var8 = true;
         } else {
            var4 = Math.min(var4, -var22);
            var5 = Math.max(var5, var22);
            var6 = Math.min(var6, var23);
            var7 = Math.max(var7, var23 + var26);
         }
      }

      if (!var8) {
         var4 = -26.0F;
         var5 = 26.0F;
         var6 = 0.0F;
         var7 = 27.0F;
      }

      return new IiIIiIIiI_Class147.Nested1_ea18c20(var4, var6, var5 - var4, var7 - var6);
   }

   public static ColorRGBA I_method_264078d8(String var0) {
      int var1 = var0 == null ? 0 : var0.hashCode();
      float var2 = (var1 & 2147483647) % 360 / 360.0F;
      return ColorRGBA.fromHSB(var2, 0.48F, 0.95F);
   }

   private static void I_method_65163d12(CustomDrawContext var0, String var1, String var2, ColorRGBA var3, float var4) {
      IIiIIi_Class10 var5 = IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(10.0F);
      IIiIIi_Class10 var6 = IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(9.0F);
      float var7 = 6.0F;
      float var8 = 21.0F;
      float var9 = 18.0F;
      float var10 = 8.0F;
      float var11 = Math.max(var10 * 2.0F + var7 + 8.0F + var5.I_method_2c375926(var1), 52.0F) - 1.0F;
      float var12 = Math.max(var6.I_method_2c375926(var2) + 16.0F, 32.0F) + 1.0F;
      float var13 = -var11 / 2.0F;
      float var14 = 4.0F;
      float var15 = -var12 / 2.0F + 0.5F;
      float var16 = var14 + var8 + 3.0F;
      IIiii_Class8 var17 = IIiii_Class8.I_method_893b2757(var8 / 2.0F);
      IIiii_Class8 var18 = IIiii_Class8.I_method_893b2757(var9 / 2.0F);
      ColorRGBA var19 = IiiiiIIIi_Class242.Ii_method_a0f56f71().withAlpha(60.0F * var4);
      ColorRGBA var20 = IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(45.0F * var4);
      ColorRGBA var21 = IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0F * var4);
      var0.drawLiquidGlass(var13, var14, var11, var8, 2.0F, 0.08F, var17, ColorRGBA.WHITE.withAlpha(191.0F));
      var0.drawRoundedRect(var13, var14, var11, var8, var17, var19);
      var0.drawLiquidGlass(var15, var16, var12, var9, 2.0F, 0.08F, var18, ColorRGBA.WHITE.withAlpha(191.0F));
      var0.drawRoundedRect(var15, var16, var12, var9, var18, var19.mulAlpha(0.82F));
      float var22 = var13 + var10;
      float var23 = var14 + (var8 - var7) / 2.0F;
      var0.drawRoundedRect(var22, var23, var7, var7, IIiii_Class8.I_method_893b2757(var7 / 2.0F), var3.withAlpha(245.0F * var4));
      var0.drawText(var5, var1, var22 + var7 + 6.0F, var14 + (var8 - var5.I_method_a649725c()) / 2.0F, var21);
      var0.drawCenteredText(var6, var2, 1.0F, var16 + (var9 - var6.I_method_a649725c()) / 2.0F, var21.mulAlpha(0.88F));
   }

   private static void i_method_94a8f532(CustomDrawContext var0, String var1, String var2, ColorRGBA var3, float var4) {
      IIiIIi_Class10 var5 = IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(9.0F);
      IIiIIi_Class10 var6 = IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(8.0F);
      float var7 = 21.0F;
      float var8 = 6.0F;
      float var9 = 8.0F;
      float var10 = 6.0F;
      float var11 = 6.0F;
      float var12 = 14.0F;
      float var13 = 7.0F;
      float var14 = I_method_9de22d31(var5.I_method_2c375926(var1));
      float var15 = I_method_9de22d31(var6.I_method_2c375926(var2));
      float var16 = I_method_9de22d31(var15 + var13 * 2.0F);
      float var17 = var8 + var10 + var14 + var11 + var16;
      float var18 = I_method_9de22d31(var17 + var9 * 2.0F) - 7.0F;
      float var19 = I_method_9de22d31(-var18 / 2.0F);
      float var20 = 5.5F;
      IIiii_Class8 var21 = IIiii_Class8.I_method_893b2757(var7 / 2.0F);
      ColorRGBA var22 = new ColorRGBA(13.0F, 18.0F, 20.0F, 238.0F * var4);
      ColorRGBA var23 = var3.mix(ColorRGBA.BLACK, 0.68F).withAlpha(130.0F * var4);
      var0.drawRoundedRect(var19, var20, var18, var7, var21, var22);
      float var24 = var19 + var9;
      float var25 = I_method_ae18d8f1(var20, var7, var8);
      var0.drawRoundedRect(var24, var25, var8, var8, IIiii_Class8.I_method_893b2757(var8 / 2.0F), var3.withAlpha(245.0F * var4));
      float var26 = var24 + var8 + var10;
      float var27 = I_method_9de22d31(var20 + (var7 - var5.I_method_a649725c()) / 2.0F - 0.5F);
      var0.drawText(var5, var1, var26, var27, ColorRGBA.WHITE.withAlpha(250.0F * var4));
      float var28 = var26 + var14 + var10;
      float var29 = I_method_ae18d8f1(var20, var7, var12);
      var0.drawRoundedRect(var28, var29, var16 - 4.0F, var12, IIiii_Class8.I_method_893b2757(var12 / 2.0F), var23);
      var0.drawCenteredText(
         var6, var2, var28 + var16 / 2.0F - 1.0F, I_method_9de22d31(var20 + (var7 - var6.I_method_a649725c()) / 2.0F), var3.withAlpha(255.0F * var4)
      );
   }

   private static float I_method_ae18d8f1(float var0, float var1, float var2) {
      return I_method_9de22d31(var0 + (var1 - var2) / 2.0F);
   }

   private static float I_method_9de22d31(float var0) {
      return Math.round(var0 * 2.0F) / 2.0F;
   }

   private static String I_method_aa1e24c1(double var0) {
      String var2 = iIIIIiIiI_Class267.i_method_f3c598a1(var0);
      IiIIiiii_Class80 var3 = IiIiIIII_Class81.I_method_21a4cfeb();
      if (var3 != IiIIiiii_Class80.i_field_3f56db61 && var3 != IiIIiiii_Class80.II_field_3f56db61) {
         return var2 + " m";
      } else {
         var2 = var2.replace(".", ",");
         return var2 + " \u043c";
      }
   }

   public static final class Nested1_ea18c20 {
      private final float I_field_46;
      private final float i_field_46;
      private final float II_field_46;
      private final float Ii_field_46;

      public Nested1_ea18c20(float var1, float var2, float var3, float var4) {
         this.I_field_46 = var1;
         this.i_field_46 = var2;
         this.II_field_46 = var3;
         this.Ii_field_46 = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_ea18c20[x=" + this.I_field_46 + ", y=" + this.i_field_46 + ", w=" + this.II_field_46 + ", h=" + this.Ii_field_46 + "]";
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
         IiIIiIIiI_Class147.Nested1_ea18c20 other = (IiIIiIIiI_Class147.Nested1_ea18c20) var1;
         return java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46);
      }

      public float I_method_dbb0b8a() {
         return this.I_field_46;
      }

      public float i_method_dc9976a() {
         return this.i_field_46;
      }

      public float II_method_a9b55ef7() {
         return this.II_field_46;
      }

      public float Ii_method_a9c3ead7() {
         return this.Ii_field_46;
      }
   }
}
