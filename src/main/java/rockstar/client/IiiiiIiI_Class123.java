package rockstar.client;

import lombok.Generated;

public enum IiiiiIiI_Class123 {
   I_field_12aac7a1("players", "esp.targets.players", true),
   i_field_12aac7a1("mobs", "esp.targets.mobs", false),
   II_field_12aac7a1("animals", "esp.targets.animals", false),
   Ii_field_12aac7a1("items", "esp.targets.items", true);

   private final String I_field_523beb0a;
   private final String i_field_523beb0a;
   private final boolean I_field_5a;

   private IiiiiIiI_Class123(String var3, String var4, boolean var5) {
      this.I_field_523beb0a = var3;
      this.i_field_523beb0a = var4;
      this.I_field_5a = var5;
   }

   public boolean I_method_76f3b4f0() {
      return this.I_field_5a;
   }

   public static IiiiiIiI_Class123 I_method_27845841(String var0) {
      for (IiiiiIiI_Class123 var4 : values()) {
         if (var4.I_field_523beb0a.equals(var0)) {
            return var4;
         }
      }

      return null;
   }

   @Generated
   public String I_method_213534() {
      return this.I_field_523beb0a;
   }

   @Generated
   public String i_method_933fe554() {
      return this.i_field_523beb0a;
   }

   @Generated
   public boolean i_method_770240d0() {
      return this.I_field_5a;
   }
}
