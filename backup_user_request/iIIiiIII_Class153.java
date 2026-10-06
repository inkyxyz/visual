package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;

class iIIiiIII_Class153 implements iIIiIIiiI_Class295 {
   public iIIiiIII_Class153.Nested1_43094cd3 I_method_c0d27454(
      III var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      IiiiIiIii_Class236 var9,
      IiiiIiIii_Class236 var10,
      IiiiIiIii_Class236 var11,
      iIIiIiii_Class152 var12,
      iIiIIiII_Class165 var13,
      float var14
   ) {
      float var16 = var12.I_method_5ebc509c();
      float var17 = var7 + var8 * 2.0F + var16 - 2.0F;
      float var18 = var2 + var4 + var5;
      boolean var19 = var18 + var6 <= I_field_73c6d26c.I_method_804ee20f() - 6.0F;
      float var20 = var19 ? var18 : var2 - var6 - var5;
      float var21 = Math.max(6.0F, Math.min(var3, I_field_73c6d26c.i_method_805d6def() - var17 - 6.0F));
      var12.I_method_34d3f6b().I_method_b043bcc(var20, var21, var6, var17);
      float var22 = var9.I_method_6ac4da6f() * var14 * var10.I_method_6ac4da6f();
      float var23;
      float var24;
      if (var19) {
         var23 = var2 + var4;
         var24 = I_field_73c6d26c.I_method_804ee20f() - var23;
      } else {
         var23 = 0.0F;
         var24 = var2;
      }

      iIiiiIiII_Class373.I_method_d5a5ee51(var1.getMatrices(), var23, 0.0F, var24, I_field_73c6d26c.i_method_805d6def());
      var1.drawShadow(var20, var21, var6, var17, 25.0F, IIiii_Class8.I_method_893b2757(11.0F), IiiiiIIIi_Class242.iI_field_d0c8ec5.mulAlpha(0.5F * var22));
      var1.drawBlurredRect(var20, var21, var6, var17, 5.0F, 3.0F, IIiii_Class8.I_method_893b2757(11.0F), IiiiiIIIi_Class242.Ii_field_d0c8ec5.mulAlpha(var22));
      var1.drawSquircle(var20, var21, var6, var17, 3.0F, IIiii_Class8.I_method_893b2757(11.0F), IiiiiIIIi_Class242.III_field_d0c8ec5.mulAlpha(var22));
      var1.drawSquircleBorder(
         var20, var21, var6, var17, 0.5F, 3.0F, IIiii_Class8.I_method_893b2757(11.0F), IiiiiIIIi_Class242.IiI_field_d0c8ec5.mulAlpha(var22)
      );
      iIIiiIII_Class153.Nested1_43094cb3 var25 = this.I_method_7bd69568(var1, var12, var13, var22, var20, var21, var6, var7, var8, var11);
      float var26 = var20;
      float var27 = var21 + var7 + var8 + 1.0F;
      float var28 = var6;
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var22);

      for (IiiIiiIii_Class220 var30 : var12.I_method_35a0941b()) {
         var30.I_method_b043bcc(var26, var27, var28, var30.Ii_method_2047ead7());
         var30.iI_method_2b3782de(var21);
         var30.ii_method_2cfa72fe(var17);
         var30.I_method_7ae26dda(var1);
         var27 += var30.Ii_method_2047ead7();
      }

      for (IiiIiiIii_Class220 var32 : var12.I_method_35a0941b()) {
         var32.Ii_method_6b12c484(var1);
      }

      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      iIiiiIiII_Class373.I_method_ff80a1df();
      return new iIIiiIII_Class153.Nested1_43094cd3(
         var20, var21, var6, var17, var25.I_method_1f03aed7(), var25.i_method_1f123ab7(), var25.II_method_c181254a(), var25.Ii_method_c18fb12a()
      );
   }

   private iIIiiIII_Class153.Nested1_43094cb3 I_method_7bd69568(
      III var1,
      iIIiIiii_Class152 var2,
      iIiIIiII_Class165 var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      IiiiIiIii_Class236 var10
   ) {
      IIiIIi_Class10 var11 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F);
      IIiIIi_Class10 var12 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.0F);
      float var13 = var5 + var9;
      float var14 = var6 + var9;
      float var15 = var7 - var9 * 2.0F;
      var1.drawRoundedRect(var13, var14, var15, var8, IIiii_Class8.I_method_893b2757(5.0F), IiiiiIIIi_Class242.Ii_method_a0f56f71().mulAlpha(0.4F * var4));
      float var17 = 10.0F;
      float var18 = 0.6875F;
      float var19 = 16.0F * var18;
      float var20 = var13 + 4.0F;
      float var21 = var14 + (var8 - var17) / 2.0F;
      float var22 = var20 + (var17 - var19) / 2.0F;
      float var23 = var21 + (var17 - var19) / 2.0F;
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var4);
      var1.drawItem(var3.I_method_db7f702c().getItem(), var22, var23, var18);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      String var24 = var2.I_method_5ebc50b0()
         ? iIIIIIIII_Class257.I_method_f90bbc5c(iIIIIIIII_Class257.I_method_e761de12()) + "..."
         : iIIIIiIiI_Class267.I_method_a937749c(var2.I_method_5ebc509f());
      if (var24 == null || var24.isEmpty()) {
         var24 = "-";
      }

      float var25 = 4.0F;
      float var26 = 2.0F;
      float var27 = var12.I_method_2c375926(var24);
      float var28 = Math.max(12.0F, var27 + var25 * 2.0F);
      float var29 = var12.I_method_a649725c() + var26 * 2.0F;
      float var30 = var13 + var15 - 5.0F - var28;
      float var31 = var14 + (var8 - var29) / 2.0F;
      boolean var32 = iIIiIIIiI_Class291.I_method_da20b32b(var30, var31, var28, var29, var1);
      var10.I_method_edd72835(var32 || var2.I_method_5ebc50b0());
      var1.drawRoundedRect(
         var30,
         var31,
         var28,
         var29,
         IIiii_Class8.I_method_893b2757(3.0F),
         IiiiiIIIi_Class242.Ii_method_a0f56f71().mulAlpha((0.45F + 0.25F * var10.I_method_6ac4da6f()) * var4)
      );
      var1.drawText(
         var12, var24, var30 + var25, var31 + (var29 - var12.I_method_a649725c()) / 2.0F, IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(0.75F * var4)
      );
      String var33 = IiIiIIII_Class81.I_method_f25a980a(var3.I_method_cca0c514());
      float var34 = var20 + var17 + 6.0F;
      float var35 = var14 + (var8 - var11.I_method_a649725c()) / 2.0F;
      float var36 = Math.max(10.0F, var30 - 6.0F - var34);
      var1.drawFadeoutText(var11, var33, var34, var35, IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(0.9F * var4), 0.85F, 1.0F, var36);
      return new iIIiiIII_Class153.Nested1_43094cb3(var30, var31, var28, var29);
   }

   static final class Nested1_43094cb3 {
      private final float I_field_46;
      private final float i_field_46;
      private final float II_field_46;
      private final float Ii_field_46;

      Nested1_43094cb3(float var1, float var2, float var3, float var4) {
         this.I_field_46 = var1;
         this.i_field_46 = var2;
         this.II_field_46 = var3;
         this.Ii_field_46 = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_43094cb3[x=" + this.I_field_46 + ", y=" + this.i_field_46 + ", w=" + this.II_field_46 + ", h=" + this.Ii_field_46 + "]";
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
         iIIiiIII_Class153.Nested1_43094cb3 other = (iIIiiIII_Class153.Nested1_43094cb3) var1;
         return java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46);
      }

      public float I_method_1f03aed7() {
         return this.I_field_46;
      }

      public float i_method_1f123ab7() {
         return this.i_field_46;
      }

      public float II_method_c181254a() {
         return this.II_field_46;
      }

      public float Ii_method_c18fb12a() {
         return this.Ii_field_46;
      }
   }

   public static final class Nested1_43094cd3 {
      private final float I_field_46;
      private final float i_field_46;
      private final float II_field_46;
      private final float Ii_field_46;
      private final float iI_field_46;
      private final float ii_field_46;
      private final float III_field_46;
      private final float IIi_field_46;

      public Nested1_43094cd3(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
         this.I_field_46 = var1;
         this.i_field_46 = var2;
         this.II_field_46 = var3;
         this.Ii_field_46 = var4;
         this.iI_field_46 = var5;
         this.ii_field_46 = var6;
         this.III_field_46 = var7;
         this.IIi_field_46 = var8;
      }

      @Override
      public final String toString() {
         return "Nested1_43094cd3[x=" + this.I_field_46 + ", y=" + this.i_field_46 + ", w=" + this.II_field_46 + ", h=" + this.Ii_field_46 + ", bindX=" + this.iI_field_46 + ", bindY=" + this.ii_field_46 + ", bindW=" + this.III_field_46 + ", bindH=" + this.IIi_field_46 + "]";
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
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIIiiIII_Class153.Nested1_43094cd3 other = (iIIiiIII_Class153.Nested1_43094cd3) var1;
         return java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46)
            && java.util.Objects.equals(this.iI_field_46, other.iI_field_46)
            && java.util.Objects.equals(this.ii_field_46, other.ii_field_46)
            && java.util.Objects.equals(this.III_field_46, other.III_field_46)
            && java.util.Objects.equals(this.IIi_field_46, other.IIi_field_46);
      }

      public float I_method_559ec2b7() {
         return this.I_field_46;
      }

      public float i_method_55ad4e97() {
         return this.i_field_46;
      }

      public float II_method_5e488d6a() {
         return this.II_field_46;
      }

      public float Ii_method_5e57194a() {
         return this.Ii_field_46;
      }

      public float iI_method_600b7d8a() {
         return this.iI_field_46;
      }

      public float ii_method_601a096a() {
         return this.ii_field_46;
      }

      public float III_method_6ad81917() {
         return this.III_field_46;
      }

      public float IIi_method_6ae6a4f7() {
         return this.IIi_field_46;
      }
   }
}
