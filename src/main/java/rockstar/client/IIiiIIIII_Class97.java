package rockstar.client;

import lombok.Generated;
import pyrock.utility.render.ColorRGBA;

public enum IIiiIIIII_Class97 {
   I_field_8376ae8c(
      "success",
      new ColorRGBA(237.0F, 255.0F, 249.0F),
      new ColorRGBA(98.0F, 255.0F, 0.0F),
      new ColorRGBA(171.0F, 255.0F, 132.0F),
      iiIIIiIII_Class393.iII_field_fe089eac
   ),
   i_field_8376ae8c("error", ColorRGBA.RED, ColorRGBA.RED, ColorRGBA.RED, iiIIIiIII_Class393.iIi_field_fe089eac),
   II_field_8376ae8c(
      "info",
      new ColorRGBA(234.0F, 179.0F, 8.0F),
      new ColorRGBA(234.0F, 179.0F, 8.0F),
      new ColorRGBA(234.0F, 179.0F, 8.0F),
      iiIIIiIII_Class393.iiI_field_fe089eac
   );

   private final String I_field_523beb0a;
   private final ColorRGBA I_field_d0c8ec5;
   private final ColorRGBA i_field_d0c8ec5;
   private final ColorRGBA II_field_d0c8ec5;
   private final iiIIIiIII_Class393 I_field_fe089eac;

   public static IIiiIIIII_Class97 I_method_4e1cbabf(String var0) {
      for (IIiiIIIII_Class97 var4 : values()) {
         if (var4.I_method_e6beac41().equalsIgnoreCase(var0)) {
            return var4;
         }
      }

      return II_field_8376ae8c;
   }

   @Generated
   public String I_method_e6beac41() {
      return this.I_field_523beb0a;
   }

   @Generated
   public ColorRGBA I_method_12e658ae() {
      return this.I_field_d0c8ec5;
   }

   @Generated
   public ColorRGBA i_method_9acd648e() {
      return this.i_field_d0c8ec5;
   }

   @Generated
   public ColorRGBA II_method_21cfef71() {
      return this.II_field_d0c8ec5;
   }

   @Generated
   public iiIIIiIII_Class393 I_method_35d64b55() {
      return this.I_field_fe089eac;
   }

   @Generated
   private IIiiIIIII_Class97(String var3, ColorRGBA var4, ColorRGBA var5, ColorRGBA var6, iiIIIiIII_Class393 var7) {
      this.I_field_523beb0a = var3;
      this.I_field_d0c8ec5 = var4;
      this.i_field_d0c8ec5 = var5;
      this.II_field_d0c8ec5 = var6;
      this.I_field_fe089eac = var7;
   }
}
