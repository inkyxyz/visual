package rockstar.client;

import lombok.Generated;

public enum IiiiIiii_Class120 {
   I_field_10f66741("held", "esp.targets.items.held"),
   i_field_10f66741("dropped", "esp.targets.items.dropped");

   private final String I_field_523beb0a;
   private final String i_field_523beb0a;

   private IiiiIiii_Class120(String var3, String var4) {
      this.I_field_523beb0a = var3;
      this.i_field_523beb0a = var4;
   }

   public static IiiiIiii_Class120 I_method_cd53a441(String var0) {
      for (IiiiIiii_Class120 var4 : values()) {
         if (var4.I_field_523beb0a.equals(var0)) {
            return var4;
         }
      }

      return null;
   }

   @Generated
   public String I_method_91339994() {
      return this.I_field_523beb0a;
   }

   @Generated
   public String i_method_245249b4() {
      return this.i_field_523beb0a;
   }
}
