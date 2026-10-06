package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.List;
import java.util.Map;
import java.util.function.ToDoubleFunction;
import pyrock.utility.render.ColorRGBA;

public class iIIiIiIi_Class150 {
   public iIIiIiIi_Class150.Nested1_e31a113 I_method_5a1b20c4(
      III var1,
      float var2,
      float var3,
      float var4,
      float var5,
      IiiiIiIii_Class236 var6,
      iIIiIIii_Class148 var7,
      Map<iIIiIIii_Class148, IiiiIiIii_Class236> var8,
      IiiiIiIii_Class236 var9
   ) {
      IIiIIi_Class10 var10 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F);
      float var11 = var2 + 7.0F;
      float var12 = var3 + 24.0F;
      var1.drawText(
         IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F),
         "\u041c\u0430\u043a\u0440\u043e\u0441\u044b",
         var11 + 1.0F,
         var12 - 14.0F,
         IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(0.95F * var6.I_method_6ac4da6f() * var5)
      );

      for (iIIiIIii_Class148 var16 : iIIiIIii_Class148.values()) {
         String var17 = var16.I_method_dca1f154();
         float var18 = var10.I_method_2c375926(var17);
         float var19 = var18 + 8.0F;
         boolean var20 = var7 == var16;
         boolean var21 = iIIiIIIiI_Class291.I_method_da20b32b(var11, var12, var19, 13.0, var1);
         IiiiIiIii_Class236 var22 = var8.computeIfAbsent(var16, var0 -> new IiiiIiIii_Class236(200L, 0.0F, IiiiIiiII_Class237.III_field_dd60aac));
         var22.I_method_edd6dd11(var20 ? 1.0F : (var21 ? 0.67F : 0.0F));
         float var23 = 0.4F + 0.6F * var22.I_method_6ac4da6f();
         float var24 = var20 ? 1.0F : 0.75F;
         var1.drawRoundedRect(
            var11,
            var12,
            var19,
            13.0F,
            IIiii_Class8.I_method_893b2757(3.0F),
            IiiiiIIIi_Class242.Ii_method_a0f56f71().mulAlpha(var23 * var6.I_method_6ac4da6f() * var5)
         );
         var1.drawText(
            var10,
            var17,
            var11 + 4.0F,
            var12 + (13.0F - var10.I_method_a649725c()) / 2.0F,
            IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(var24 * var6.I_method_6ac4da6f() * var5)
         );
         var11 += var19 + 4.0F;
      }

      String var25 = "\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c";
      float var26 = var10.I_method_2c375926(var25);
      float var27 = var26 + 8.0F;
      float var28 = 13.0F;
      float var29 = var2 + var4 - var27 - 7.0F;
      float var30 = var3 + 24.0F;
      boolean var31 = iIIiIIIiI_Class291.I_method_da20b32b(var29, var30, var27, var28, var1);
      var9.I_method_edd72835(var31);
      float var32 = 0.4F + 0.6F * var9.I_method_6ac4da6f();
      var1.drawRoundedRect(
         var29,
         var30,
         var27,
         var28,
         IIiii_Class8.I_method_893b2757(3.0F),
         IiiiiIIIi_Class242.Ii_method_a0f56f71().mulAlpha(var32 * var6.I_method_6ac4da6f() * var5)
      );
      var1.drawText(
         var10,
         var25,
         var29 + 4.0F,
         var30 + (var28 - var10.I_method_a649725c()) / 2.0F,
         IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha((0.75F + 0.25F * var9.I_method_6ac4da6f()) * var6.I_method_6ac4da6f() * var5)
      );
      return new iIIiIiIi_Class150.Nested1_e31a113(var29, var30, var27, var28);
   }

   public void I_method_414139bb(
      III var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      IiiiIiIii_Class236 var7,
      iIIiIIIii_Class292 var8,
      iIIiIIii_Class148 var9,
      List<iIiIIiII_Class165> var10,
      iIiIIiII_Class165 var11,
      iIiIIiII_Class165 var12,
      int var13,
      int var14,
      Map<iIiIIiII_Class165, iIIiiIIi_Class154> var15,
      Map<iIiIIiII_Class165, IiiiIiIii_Class236> var16,
      Map<iIiIIiII_Class165, IiiiIiIii_Class236> var17,
      ToDoubleFunction<iIiIIiII_Class165> var18
   ) {
      IIiIIi_Class10 var19 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F);
      IIiIIi_Class10 var20 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F);
      IIiIIi_Class10 var21 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.0F);
      float var22 = var2 + 7.0F;
      float var23 = var3 + 44.0F;
      float var24 = var4 - 14.0F;
      float var25 = var5 - 30.0F - 10.0F;
      if (var10.isEmpty()) {
         String var47 = "\u041f\u0443\u0441\u0442\u043e";
         float var48 = var20.I_method_2c375926(var47);
         var1.drawText(
            var20,
            var47,
            var22 + (var24 - var48) / 2.0F,
            var23 + var25 / 2.0F - var20.I_method_a649725c() / 2.0F,
            IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(0.35F * var6)
         );
      } else {
         float var26 = 4.0F;
         float var27 = 20.0F;
         float var28 = 4.0F;
         float var29 = (var24 - var26) / 2.0F;
         float var30 = 2.0F;
         iIiiiIiII_Class373.I_method_d5a5ee51(var1.getMatrices(), var22, var23 - var30, var24, var25 - var30 * 2.0F);
         float var31 = var23 - (float)var8.I_method_575ab22d();
         if (var9 == iIIiIIii_Class148.I_field_88b781) {
            for (iIIiIIii_Class148 var35 : iIIiIIii_Class148.values()) {
               if (var35 != iIIiIIii_Class148.I_field_88b781) {
                  List var36 = var10.stream().filter(var1x -> var1x.I_method_e81fe78b() == var35).toList();
                  if (!var36.isEmpty()) {
                     var1.drawText(
                        var19,
                        var35.I_method_dca1f154(),
                        var22 + 1.0F,
                        var31 + 2.0F,
                        IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(0.95F * var7.I_method_6ac4da6f() * var6)
                     );
                     var31 += var19.I_method_a649725c() + 10.0F;

                     for (int var37 = 0; var37 < var36.size(); var37++) {
                        int var38 = var37 / 2;
                        int var39 = var37 % 2;
                        float var40 = var22 + var39 * (var29 + var26);
                        float var41 = var31 + var38 * (var27 + var28);
                        if (var41 + var27 >= var23 - 10.0F && var41 <= var23 + var25 + 10.0F) {
                           iIiIIiII_Class165 var42 = (iIiIIiII_Class165)var36.get(var37);
                           boolean var43 = iIIiIIIiI_Class291.I_method_da20b32b(var40, var41, var29, var27, var1);
                           boolean var44 = var42 == var11;
                           float var45 = (float)var18.applyAsDouble(var42);
                           IiiiIiIii_Class236 var46 = var16.computeIfAbsent(
                              var42, var0 -> new IiiiIiIii_Class236(200L, 0.0F, IiiiIiiII_Class237.III_field_dd60aac)
                           );
                           var46.I_method_edd72835(var43 || var44);
                           this.I_method_2f91ccba(
                              var1,
                              var40,
                              var41,
                              var29,
                              var27,
                              var42,
                              var46.I_method_6ac4da6f(),
                              var20,
                              var21,
                              var44,
                              var45,
                              var6,
                              var7,
                              var12,
                              var13,
                              var14,
                              var15,
                              var17
                           );
                        }
                     }

                     int var58 = (int)Math.ceil(var36.size() / 2.0F);
                     var31 += var58 * var27 + Math.max(0, var58 - 1) * var28 + 14.0F;
                  }
               }
            }
         } else {
            List var50 = var10.stream().filter(var1x -> var1x.I_method_e81fe78b() == var9).toList();
            if (var50.isEmpty()) {
               String var52 = "\u041f\u0443\u0441\u0442\u043e";
               float var54 = var20.I_method_2c375926(var52);
               var1.drawText(
                  var20,
                  var52,
                  var22 + (var24 - var54) / 2.0F,
                  var23 + var25 / 2.0F - var20.I_method_a649725c() / 2.0F,
                  IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(0.35F * var6)
               );
            } else {
               for (int var53 = 0; var53 < var50.size(); var53++) {
                  int var55 = var53 / 2;
                  int var56 = var53 % 2;
                  float var57 = var22 + var56 * (var29 + var26);
                  float var59 = var31 + var55 * (var27 + var28);
                  if (var59 + var27 >= var23 - 10.0F && var59 <= var23 + var25 + 10.0F) {
                     iIiIIiII_Class165 var60 = (iIiIIiII_Class165)var50.get(var53);
                     float var61 = (float)var18.applyAsDouble(var60);
                     boolean var62 = iIIiIIIiI_Class291.I_method_da20b32b(var57, var59, var29, var27, var1);
                     boolean var63 = var60 == var11;
                     IiiiIiIii_Class236 var64 = var16.computeIfAbsent(var60, var0 -> new IiiiIiIii_Class236(200L, 0.0F, IiiiIiiII_Class237.III_field_dd60aac));
                     var64.I_method_edd72835(var62 || var63);
                     this.I_method_2f91ccba(
                        var1,
                        var57,
                        var59,
                        var29,
                        var27,
                        var60,
                        var64.I_method_6ac4da6f(),
                        var20,
                        var21,
                        var63,
                        var61,
                        var6,
                        var7,
                        var12,
                        var13,
                        var14,
                        var15,
                        var17
                     );
                  }
               }
            }
         }

         iIiiiIiII_Class373.I_method_ff80a1df();
         float var51 = this.I_method_7df26d0f(var9, var10, var19, var27, var28);
         var8.i_method_95bee5ff(Math.min(0.0F, var25 - var51));
      }
   }

   public iIIiIiII_Class149 I_method_e1908d4b(
      float var1, float var2, float var3, float var4, float var5, float var6, iIIiIIIii_Class292 var7, iIIiIIii_Class148 var8, List<iIiIIiII_Class165> var9
   ) {
      float var10 = var3 + 7.0F;
      float var11 = var4 + 44.0F;
      float var12 = var5 - 14.0F;
      float var13 = var6 - 30.0F - 10.0F;
      if (!iIIiIIIiI_Class291.I_method_c3fabb03(var10, var11, var12, var13, (int)var1, (int)var2)) {
         return null;
      } else {
         IIiIIi_Class10 var14 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F);
         IIiIIi_Class10 var15 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.0F);
         float var16 = 4.0F;
         float var17 = 20.0F;
         float var18 = 4.0F;
         float var19 = (var12 - var16) / 2.0F;
         float var20 = var11 - (float)var7.I_method_575ab22d();
         if (var8 == iIIiIIii_Class148.I_field_88b781) {
            for (iIIiIIii_Class148 var24 : iIIiIIii_Class148.values()) {
               if (var24 != iIIiIIii_Class148.I_field_88b781) {
                  List var25 = var9.stream().filter(var1x -> var1x.I_method_e81fe78b() == var24).toList();
                  if (!var25.isEmpty()) {
                     var20 += var14.I_method_a649725c() + 10.0F;

                     for (int var26 = 0; var26 < var25.size(); var26++) {
                        int var27 = var26 / 2;
                        int var28 = var26 % 2;
                        float var29 = var10 + var28 * (var19 + var16);
                        float var30 = var20 + var27 * (var17 + var18);
                        if (iIIiIIIiI_Class291.I_method_c3fabb03(var29, var30, var19, var17, (int)var1, (int)var2)) {
                           iIiIIiII_Class165 var31 = (iIiIIiII_Class165)var25.get(var26);
                           String var32 = iIIIIiIiI_Class267.I_method_a937749c(var31.I_method_75fee8ff());
                           float var33 = 12.0F;
                           float var34 = Math.max(16.0F, var15.I_method_2c375926(var32) + 8.0F);
                           float var35 = var29 + var19 - var34 - 5.0F;
                           float var36 = var30 + (var17 - var33) / 2.0F;
                           return new iIIiIiII_Class149(var31, var29, var30, var19, var17, var35, var36, var34, var33);
                        }
                     }

                     int var43 = (int)Math.ceil(var25.size() / 2.0F);
                     var20 += var43 * var17 + Math.max(0, var43 - 1) * var18 + 14.0F;
                  }
               }
            }
         } else {
            List var38 = var9.stream().filter(var1x -> var1x.I_method_e81fe78b() == var8).toList();

            for (int var39 = 0; var39 < var38.size(); var39++) {
               int var40 = var39 / 2;
               int var41 = var39 % 2;
               float var42 = var10 + var41 * (var19 + var16);
               float var44 = var20 + var40 * (var17 + var18);
               if (iIIiIIIiI_Class291.I_method_c3fabb03(var42, var44, var19, var17, (int)var1, (int)var2)) {
                  iIiIIiII_Class165 var45 = (iIiIIiII_Class165)var38.get(var39);
                  String var46 = iIIIIiIiI_Class267.I_method_a937749c(var45.I_method_75fee8ff());
                  float var47 = 12.0F;
                  float var48 = Math.max(16.0F, var15.I_method_2c375926(var46) + 8.0F);
                  float var49 = var42 + var19 - var48 - 5.0F;
                  float var50 = var44 + (var17 - var47) / 2.0F;
                  return new iIIiIiII_Class149(var45, var42, var44, var19, var17, var49, var50, var48, var47);
               }
            }
         }

         return null;
      }
   }

   private void I_method_2f91ccba(
      III var1,
      float var2,
      float var3,
      float var4,
      float var5,
      iIiIIiII_Class165 var6,
      float var7,
      IIiIIi_Class10 var8,
      IIiIIi_Class10 var9,
      boolean var10,
      float var11,
      float var12,
      IiiiIiIii_Class236 var13,
      iIiIIiII_Class165 var14,
      int var15,
      int var16,
      Map<iIiIIiII_Class165, iIIiiIIi_Class154> var17,
      Map<iIiIIiII_Class165, IiiiIiIii_Class236> var18
   ) {
      float var19 = (var10 ? 0.85F : 0.55F + 0.3F * var7) * var13.I_method_6ac4da6f() * var11 * var12;
      ColorRGBA var20 = IiiiiIIIi_Class242.Ii_method_a0f56f71().mulAlpha(var19);
      iIiiiIIiI_Class371.II_method_e18635ac(var1.getMatrices(), var2 + var4 / 2.0F, var3 + var5 / 2.0F, 0.85F + 0.15F * var11);
      var1.drawRoundedRect(var2, var3, var4, var5, IIiii_Class8.I_method_893b2757(5.0F), var20);
      float var21 = 14.0F;
      float var22 = 0.75F;
      float var23 = 16.0F * var22;
      float var24 = var2 + 4.0F;
      float var25 = var3 + (var5 - var21) / 2.0F;
      float var26 = var24 + (var21 - var23) / 2.0F;
      float var27 = var25 + (var21 - var23) / 2.0F;
      float var28 = var13.I_method_6ac4da6f() * var11 * var12;
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var28);
      var1.drawItem(var6.I_method_db7f702c().getItem(), var26, var27, var22);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      boolean var29 = var14 == var6;
      String var30 = var29
         ? iIIIIIIII_Class257.I_method_f90bbc5c(iIIIIIIII_Class257.I_method_e761de12()) + "..."
         : iIIIIiIiI_Class267.I_method_a937749c(var6.I_method_75fee8ff());
      float var31 = 12.0F;
      float var32 = Math.max(16.0F, var9.I_method_2c375926(var30) + 8.0F);
      float var33 = var2 + var4 - var32 - 5.0F;
      float var34 = var3 + (var5 - var31) / 2.0F;
      boolean var35 = iIIiIIIiI_Class291.I_method_c3fabb03(var33, var34, var32, var31, var15, var16);
      IiiiIiIii_Class236 var36 = var18.computeIfAbsent(var6, var0 -> new IiiiIiIii_Class236(200L, 0.0F, IiiiIiiII_Class237.III_field_dd60aac));
      var36.I_method_edd72835(var35 || var29);
      float var37 = (0.6F + 0.4F * var36.I_method_6ac4da6f()) * var13.I_method_6ac4da6f() * var11 * var12;
      var1.drawRoundedRect(var33, var34, var32, var31, IIiii_Class8.I_method_893b2757(4.0F), IiiiiIIIi_Class242.Ii_method_a0f56f71().mulAlpha(var37));
      var1.drawText(
         var9,
         var30,
         var33 + (var32 - var9.I_method_2c375926(var30)) / 2.0F,
         var34 + (var31 - var9.I_method_a649725c()) / 2.0F,
         IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(0.95F * var13.I_method_6ac4da6f() * var11 * var12)
      );
      float var38 = var24 + var21 + 2.0F;
      float var39 = var33 - 4.0F - var38;
      this.I_method_b1a70f6c(
         var1,
         var17,
         var6,
         var8,
         IiIiIIII_Class81.I_method_f25a980a(var6.I_method_cca0c514()),
         var38,
         var3 + (var5 - var8.I_method_a649725c()) / 2.0F,
         var39,
         var5,
         IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha((0.75F + 0.25F * var7) * var13.I_method_6ac4da6f() * var11 * var12),
         var7 > 0.05F
      );
      iIiiiIIiI_Class371.I_method_10503b11(var1.getMatrices());
   }

   private void I_method_b1a70f6c(
      III var1,
      Map<iIiIIiII_Class165, iIIiiIIi_Class154> var2,
      iIiIIiII_Class165 var3,
      IIiIIi_Class10 var4,
      String var5,
      float var6,
      float var7,
      float var8,
      float var9,
      ColorRGBA var10,
      boolean var11
   ) {
      float var12 = Math.max(1.0F, var8);
      float var13 = var4.I_method_2c375926(var5);
      long var14 = System.currentTimeMillis();
      iIIiiIIi_Class154 var16 = var2.computeIfAbsent(var3, var0 -> new iIIiiIIi_Class154());
      float var17 = Math.max(0.0F, var13 - var12);
      float var18 = (float)(var14 - var16.I_field_4a) / 1000.0F;
      var16.I_field_4a = var14;
      if (var17 <= 0.0F) {
         var16.I_method_7d48e378(var14);
      } else if (var11) {
         var16.I_field_46 = Math.min(var16.I_field_46, var17);
         if (var14 >= var16.i_field_4a) {
            float var19 = var18 * 35.0F;
            if (var16.I_field_5a) {
               var16.I_field_46 = Math.min(var16.I_field_46 + var19, var17);
               if (var16.I_field_46 >= var17) {
                  var16.I_field_5a = false;
                  var16.i_field_4a = var14 + 600L;
               }
            } else {
               var16.I_field_46 = Math.max(var16.I_field_46 - var19, 0.0F);
               if (var16.I_field_46 <= 0.0F) {
                  var16.I_field_5a = true;
                  var16.i_field_4a = var14 + 600L;
               }
            }
         }
      } else if (var16.I_field_46 > 0.0F) {
         var16.I_field_46 = Math.max(0.0F, var16.I_field_46 - var18 * 35.0F);
         if (var16.I_field_46 == 0.0F) {
            var16.I_field_5a = true;
            var16.i_field_4a = var14;
         }
      }

      iIiiiIiII_Class373.I_method_d5a5ee51(var1.getMatrices(), var6 - 3.0F, var7 - 3.0F, var12 + 6.0F, var9 + 6.0F);
      var1.pushMatrix();
      var1.getMatrices().translate(-var16.I_field_46, 0.0F, 0.0F);
      var1.drawFadeoutText(var4, var5, var6, var7, var10, 0.95F, 1.0F, var12 + 10.0F);
      var1.popMatrix();
      iIiiiIiII_Class373.I_method_ff80a1df();
   }

   private float I_method_7df26d0f(iIIiIIii_Class148 var1, List<iIiIIiII_Class165> var2, IIiIIi_Class10 var3, float var4, float var5) {
      float var6 = 0.0F;
      if (var1 == iIIiIIii_Class148.I_field_88b781) {
         for (iIIiIIii_Class148 var10 : iIIiIIii_Class148.values()) {
            if (var10 != iIIiIIii_Class148.I_field_88b781) {
               List var11 = var2.stream().filter(var1x -> var1x.I_method_e81fe78b() == var10).toList();
               if (!var11.isEmpty()) {
                  var6 += var3.I_method_a649725c() + 8.0F;
                  int var12 = (int)Math.ceil(var11.size() / 2.0F);
                  var6 += var12 * var4 + Math.max(0, var12 - 1) * var5 + 14.0F;
               }
            }
         }
      } else {
         List var14 = var2.stream().filter(var1x -> var1x.I_method_e81fe78b() == var1).toList();
         int var15 = (int)Math.ceil(var14.size() / 2.0F);
         var6 += var15 * var4 + Math.max(0, var15 - 1) * var5;
      }

      return var6;
   }

   public static final class Nested1_e31a113 {
      private final float I_field_46;
      private final float i_field_46;
      private final float II_field_46;
      private final float Ii_field_46;

      public Nested1_e31a113(float var1, float var2, float var3, float var4) {
         this.I_field_46 = var1;
         this.i_field_46 = var2;
         this.II_field_46 = var3;
         this.Ii_field_46 = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_e31a113[x=" + this.I_field_46 + ", y=" + this.i_field_46 + ", w=" + this.II_field_46 + ", h=" + this.Ii_field_46 + "]";
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
         iIIiIiIi_Class150.Nested1_e31a113 other = (iIIiIiIi_Class150.Nested1_e31a113) var1;
         return java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46);
      }

      public float I_method_7c11677() {
         return this.I_field_46;
      }

      public float i_method_7cfa257() {
         return this.i_field_46;
      }

      public float II_method_f070b1aa() {
         return this.II_field_46;
      }

      public float Ii_method_f07f3d8a() {
         return this.Ii_field_46;
      }
   }
}
