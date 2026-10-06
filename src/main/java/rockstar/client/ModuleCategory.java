package rockstar.client;

import lombok.Generated;

public enum ModuleCategory {
   VISUALS("Visuals"),
   INTERFACE("Interface"),
   UTILS("Utils"),
   COMBAT("Combat"),
   MOVEMENT("Movement"),
   PLAYER("Player"),
   OTHER("Other");

   private final String I_field_523beb0a;

   public static ModuleCategory I_method_a9f2a441(String var0) {
      for (ModuleCategory var4 : values()) {
         if (var4.name().equalsIgnoreCase(var0) || var4.I_field_523beb0a.equalsIgnoreCase(var0)) {
            return var4;
         }
      }

      return null;
   }

   @Generated
   public String I_method_b23d1194() {
      return this.I_field_523beb0a;
   }

   @Generated
   private ModuleCategory(String var3) {
      this.I_field_523beb0a = var3;
   }
}
