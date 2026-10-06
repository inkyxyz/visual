package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Predicate;
import pyrock.utility.render.ColorRGBA;

public class iIIiIIIi_Class146 {
   public iIIiIIIi_Class146.Nested1_c6eb0f3 I_method_ef600438(
      III var1,
      float var2,
      float var3,
      float var4,
      float var5,
      IiiiIiIii_Class236 var6,
      IiiiIiIii_Class236 var7,
      IiiiIiIii_Class236 var8,
      IiIiIIIII_Class161 var9
   ) {
      IIiIIi_Class10 var10 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F);
      float var11 = 14.0F;
      float var12 = 176.0F;
      float var13 = var2 + 7.0F;
      float var14 = var3 + 7.0F;
      float var15 = 4.0F;
      float var16 = 6.0F;
      float var17 = var13 + var15;
      var7.I_method_edd72835(var9.I_method_189fd283());
      float var18 = (0.55F + 0.35F * var7.I_method_6ac4da6f()) * var6.I_method_6ac4da6f() * var5;
      var1.drawRoundedRect(var13, var14, var12, var11, IIiii_Class8.I_method_893b2757(4.0F), IiiiiIIIi_Class242.Ii_method_a0f56f71().mulAlpha(var18));
      float var19 = var6.I_method_6ac4da6f() * var5;
      var1.drawIcon("search", var17, var14 + var15, var16, ColorRGBA.WHITE.withAlpha(255.0F * var19));
      var9.I_method_b043bcc(var13 + 9.0F, var14, var12 - 5.0F, var11);
      var9.I_method_13a617e0(IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(var6.I_method_6ac4da6f() * var5));
      var9.iI_method_a8609f1e(var5);
      var9.I_method_7ae26dda(var1);
      String var20 = "\u041e\u0442\u043c\u0435\u043d\u0430";
      float var21 = var10.I_method_2c375926(var20) + 16.0F;
      float var22 = 14.0F;
      float var23 = var2 + var4 - 7.0F - var21;
      boolean var25 = iIIiIIIiI_Class291.I_method_da20b32b(var23, var14, var21, var22, var1);
      var8.I_method_edd72835(var25);
      float var26 = (0.6F + 0.25F * var8.I_method_6ac4da6f()) * var6.I_method_6ac4da6f() * var5;
      var1.drawRoundedRect(var23, var14, var21, var22, IIiii_Class8.I_method_893b2757(3.0F), IiiiiIIIi_Class242.Ii_method_a0f56f71().mulAlpha(var26));
      var1.drawText(
         var10,
         var20,
         var23 + 8.0F,
         var14 + (var22 - var10.I_method_a649725c()) / 2.0F,
         IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(0.9F * var6.I_method_6ac4da6f() * var5)
      );
      return new iIIiIIIi_Class146.Nested1_c6eb0f3(var23, var14, var21, var22);
   }

   public final void I_method_11523625(
      III var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      IiiiIiIii_Class236 var7,
      List<iIIiiIii_Class156> var8,
      iIIiIIIii_Class292 var9,
      Map<iIIiiIiI_Class155, IiiiIiIii_Class236> var10,
      IiIiIIIII_Class161 var11,
      Predicate<iIIiiIiI_Class155> var12
   ) {
      IIiIIi_Class10 var13 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F);
      IIiIIi_Class10 var14 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F);
      float var15 = var2 + 7.0F;
      float var16 = var3 + 30.0F;
      float var17 = var4 - 14.0F;
      float var18 = var5 - 30.0F - 3.0F;
      float var19 = 4.0F;
      float var20 = 20.0F;
      float var21 = 4.0F;
      float var22 = (var17 - var19) / 2.0F;
      iIiiiIiII_Class373.I_method_d5a5ee51(var1.getMatrices(), var15, var16 - 2.0F, var17, var18);
      float var23 = var16 - (float)var9.I_method_575ab22d();
      String var24 = var11.I_method_d2579001().trim().toLowerCase(Locale.ROOT);

      for (iIIiiIii_Class156 var26 : var8) {
         ArrayList var27 = new ArrayList();

         for (iIIiiIiI_Class155 var29 : var26.I_method_6f9f47db()) {
            if ((var24.isEmpty() || var29.I_method_d1992d14().toLowerCase(Locale.ROOT).contains(var24)) && !var12.test(var29)) {
               var27.add(var29);
            }
         }

         if (!var27.isEmpty()) {
            var1.drawText(
               var13, var26.I_method_17cc5534(), var15, var23, IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(0.95F * var7.I_method_6ac4da6f() * var6)
            );
            var23 += var13.I_method_a649725c() + 8.0F;

            for (int var52 = 0; var52 < var27.size(); var52++) {
               int var56 = var52 / 2;
               int var30 = var52 % 2;
               float var31 = var15 + var30 * (var22 + var19);
               float var32 = var23 + var56 * (var20 + var21);
               iIIiiIiI_Class155 var33 = (iIIiiIiI_Class155)var27.get(var52);
               boolean var34 = iIIiIIIiI_Class291.I_method_da20b32b(var31, var32, var22, var20, var1);
               IiiiIiIii_Class236 var35 = var10.computeIfAbsent(var33, var0 -> new IiiiIiIii_Class236(200L, 0.0F, IiiiIiiII_Class237.III_field_dd60aac));
               var35.I_method_edd72835(var34);
               float var36 = (0.55F + 0.25F * var35.I_method_6ac4da6f()) * var7.I_method_6ac4da6f() * var6;
               var1.drawRoundedRect(var31, var32, var22, var20, IIiii_Class8.I_method_893b2757(5.0F), IiiiiIIIi_Class242.Ii_method_a0f56f71().mulAlpha(var36));
               float var37 = 0.75F;
               float var38 = 14.0F;
               float var39 = 16.0F * var37;
               float var40 = var31 + 5.0F;
               float var41 = var32 + (var20 - var38) / 2.0F;
               float var42 = var40 + (var38 - var39) / 2.0F;
               float var43 = var41 + (var38 - var39) / 2.0F;
               float var44 = var7.I_method_6ac4da6f() * var6;
               RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var44);
               var1.drawItem(var33.I_method_671bd82c().getItem(), var42, var43, var37);
               RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
               var1.drawText(
                  var14,
                  var33.I_method_d1992d14(),
                  var40 + var38 + 5.0F,
                  var32 + (var20 - var14.I_method_a649725c()) / 2.0F,
                  IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(0.92F * var7.I_method_6ac4da6f() * var6)
               );
            }

            int var53 = (int)Math.ceil(var27.size() / 2.0F);
            var23 += var53 * var20 + Math.max(0, var53 - 1) * var21 + 14.0F;
         }
      }

      if (!var24.isEmpty()) {
         boolean var46 = false;

         for (iIIiiIii_Class156 var50 : var8) {
            for (iIIiiIiI_Class155 var57 : var50.I_method_6f9f47db()) {
               if (var57.I_method_d1992d14().toLowerCase(Locale.ROOT).contains(var24) && !var12.test(var57)) {
                  var46 = true;
                  break;
               }
            }

            if (var46) {
               break;
            }
         }

         if (!var46) {
            IIiIIi_Class10 var49 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F);
            String var51 = "\u041d\u0438\u0447\u0435\u0433\u043e \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d\u043e";
            float var55 = var49.I_method_2c375926(var51);
            var1.drawText(
               var49,
               var51,
               var2 + (var4 - var55) / 2.0F,
               var3 + var5 / 2.0F,
               IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(0.45F * var7.I_method_6ac4da6f() * var6)
            );
         }
      }

      iIiiiIiII_Class373.I_method_ff80a1df();
      float var47 = this.I_method_b0caf87(var24, var13, var20, var21, var8, var12);
      var9.i_method_95bee5ff(Math.min(0.0F, var18 - var47));
   }

   public final iIIiiiII_Class157 I_method_194485ed(
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      iIIiIIIii_Class292 var7,
      List<iIIiiIii_Class156> var8,
      IiIiIIIII_Class161 var9,
      Predicate<iIIiiIiI_Class155> var10
   ) {
      float var11 = var3 + 7.0F;
      float var12 = var4 + 30.0F;
      float var13 = var5 - 14.0F;
      float var14 = var6 - 30.0F - 3.0F;
      if (!iIIiIIIiI_Class291.I_method_c3fabb03(var11, var12, var13, var14, (int)var1, (int)var2)) {
         return null;
      } else {
         float var15 = 4.0F;
         float var16 = 20.0F;
         float var17 = 4.0F;
         float var18 = (var13 - var15) / 2.0F;
         float var19 = var12 - (float)var7.I_method_575ab22d();
         String var20 = var9.I_method_d2579001().trim().toLowerCase(Locale.ROOT);

         for (iIIiiIii_Class156 var22 : var8) {
            ArrayList var23 = new ArrayList();

            for (iIIiiIiI_Class155 var25 : var22.I_method_6f9f47db()) {
               if ((var20.isEmpty() || var25.I_method_d1992d14().toLowerCase(Locale.ROOT).contains(var20)) && !var10.test(var25)) {
                  var23.add(var25);
               }
            }

            if (!var23.isEmpty()) {
               var19 += IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F).I_method_a649725c() + 8.0F;

               for (int var30 = 0; var30 < var23.size(); var30++) {
                  int var32 = var30 / 2;
                  int var26 = var30 % 2;
                  float var27 = var11 + var26 * (var18 + var15);
                  float var28 = var19 + var32 * (var16 + var17);
                  if (iIIiIIIiI_Class291.I_method_c3fabb03(var27, var28, var18, var16, (int)var1, (int)var2)) {
                     return new iIIiiiII_Class157((iIIiiIiI_Class155)var23.get(var30));
                  }
               }

               int var31 = (int)Math.ceil(var23.size() / 2.0F);
               var19 += var31 * var16 + Math.max(0, var31 - 1) * var17 + 14.0F;
            }
         }

         return null;
      }
   }

   private float I_method_b0caf87(String var1, IIiIIi_Class10 var2, float var3, float var4, List<iIIiiIii_Class156> var5, Predicate<iIIiiIiI_Class155> var6) {
      float var7 = 0.0F;
      String var8 = var1 == null ? "" : var1;

      for (iIIiiIii_Class156 var10 : var5) {
         ArrayList var11 = new ArrayList();

         for (iIIiiIiI_Class155 var13 : var10.I_method_6f9f47db()) {
            if ((var8.isEmpty() || var13.I_method_d1992d14().toLowerCase(Locale.ROOT).contains(var8)) && !var6.test(var13)) {
               var11.add(var13);
            }
         }

         if (!var11.isEmpty()) {
            var7 += var2.I_method_a649725c() + 8.0F;
            int var15 = (int)Math.ceil(var11.size() / 2.0F);
            var7 += var15 * var3 + Math.max(0, var15 - 1) * var4 + 14.0F;
         }
      }

      return var7;
   }

   public static final class Nested1_c6eb0f3 {
      private final float I_field_46;
      private final float i_field_46;
      private final float II_field_46;
      private final float Ii_field_46;

      public Nested1_c6eb0f3(float var1, float var2, float var3, float var4) {
         this.I_field_46 = var1;
         this.i_field_46 = var2;
         this.II_field_46 = var3;
         this.Ii_field_46 = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_c6eb0f3[x=" + this.I_field_46 + ", y=" + this.i_field_46 + ", w=" + this.II_field_46 + ", h=" + this.Ii_field_46 + "]";
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
         iIIiIIIi_Class146.Nested1_c6eb0f3 other = (iIIiIIIi_Class146.Nested1_c6eb0f3) var1;
         return java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46);
      }

      public float I_method_7e92f297() {
         return this.I_field_46;
      }

      public float i_method_7ea17e77() {
         return this.i_field_46;
      }

      public float II_method_53da598a() {
         return this.II_field_46;
      }

      public float Ii_method_53e8e56a() {
         return this.Ii_field_46;
      }
   }
}
