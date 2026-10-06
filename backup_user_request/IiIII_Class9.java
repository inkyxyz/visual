package rockstar.client;

import lombok.Generated;

public enum IiIII_Class9 {
   I_field_2f4c8d6c(0),
   i_field_2f4c8d6c(1),
   II_field_2f4c8d6c(2),
   Ii_field_2f4c8d6c(3),
   iI_field_2f4c8d6c(4),
   ii_field_2f4c8d6c(5),
   III_field_2f4c8d6c(6),
   IIi_field_2f4c8d6c(7);

   private final int I_field_49;

   public static IiIII_Class9 I_method_40dce65a(int var0) {
      for (IiIII_Class9 var4 : values()) {
         if (var4.I_method_6d899712() == var0) {
            return var4;
         }
      }

      return I_field_2f4c8d6c;
   }

   @Generated
   private IiIII_Class9(int var3) {
      this.I_field_49 = var3;
   }

   @Generated
   public int I_method_6d899712() {
      return this.I_field_49;
   }
}
