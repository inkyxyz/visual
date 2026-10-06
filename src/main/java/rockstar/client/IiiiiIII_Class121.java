package rockstar.client;

import lombok.Generated;

public enum IiiiiIII_Class121 {
   I_field_12aa4f81("others", "esp.targets.players.others"),
   i_field_12aa4f81("local", "esp.targets.players.local"),
   II_field_12aa4f81("friends", "esp.targets.players.friends"),
   Ii_field_12aa4f81("rockstar_users", "esp.targets.players.rockstar_users");

   private final String I_field_523beb0a;
   private final String i_field_523beb0a;

   private IiiiiIII_Class121(String var3, String var4) {
      this.I_field_523beb0a = var3;
      this.i_field_523beb0a = var4;
   }

   public static IiiiiIII_Class121 I_method_f24f1c41(String var0) {
      for (IiiiiIII_Class121 var4 : values()) {
         if (var4.I_field_523beb0a.equals(var0)) {
            return var4;
         }
      }

      return null;
   }

   @Generated
   public String I_method_7fef5954() {
      return this.I_field_523beb0a;
   }

   @Generated
   public String i_method_130e0974() {
      return this.i_field_523beb0a;
   }
}
