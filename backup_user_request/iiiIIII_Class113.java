package rockstar.client;

import lombok.Generated;
import pyrock.utility.render.ColorRGBA;

public enum iiiIIII_Class113 {
   I_field_c11fcfcc(
      "success",
      new ColorRGBA(237.0F, 255.0F, 249.0F),
      new ColorRGBA(98.0F, 255.0F, 0.0F),
      new ColorRGBA(171.0F, 255.0F, 132.0F),
      iiIIIiIII_Class393.iII_field_fe089eac
   ),
   i_field_c11fcfcc("error", ColorRGBA.RED, ColorRGBA.RED, ColorRGBA.RED, iiIIIiIII_Class393.iIi_field_fe089eac),
   II_field_c11fcfcc(
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

   public static iiiIIII_Class113 I_method_c219aff(String var0) {
      for (iiiIIII_Class113 var4 : values()) {
         if (var4.I_method_f3dcd601().equalsIgnoreCase(var0)) {
            return var4;
         }
      }

      return II_field_c11fcfcc;
   }

   @Generated
   public String I_method_f3dcd601() {
      return this.I_field_523beb0a;
   }

   @Generated
   public ColorRGBA I_method_eff776ee() {
      return this.I_field_d0c8ec5;
   }

   @Generated
   public ColorRGBA i_method_77de82ce() {
      return this.i_field_d0c8ec5;
   }

   @Generated
   public ColorRGBA II_method_e6e29931() {
      return this.II_field_d0c8ec5;
   }

   @Generated
   public iiIIIiIII_Class393 I_method_4ab1995() {
      return this.I_field_fe089eac;
   }

   @Generated
   private iiiIIII_Class113(String var3, ColorRGBA var4, ColorRGBA var5, ColorRGBA var6, iiIIIiIII_Class393 var7) {
      this.I_field_523beb0a = var3;
      this.I_field_d0c8ec5 = var4;
      this.i_field_d0c8ec5 = var5;
      this.II_field_d0c8ec5 = var6;
      this.I_field_fe089eac = var7;
   }
}
