package rockstar.client;

public enum IIiIIIIIi_Class66 {
   I_field_e6af4a4c("idle"),
   i_field_e6af4a4c("working"),
   II_field_e6af4a4c("moving"),
   Ii_field_e6af4a4c("planting"),
   iI_field_e6af4a4c("growing"),
   ii_field_e6af4a4c("pickup"),
   III_field_e6af4a4c("deposit"),
   IIi_field_e6af4a4c("selling"),
   IiI_field_e6af4a4c("buying"),
   Iii_field_e6af4a4c("crafting"),
   iII_field_e6af4a4c("repairing"),
   iIi_field_e6af4a4c("restocking");

   private final String I_field_523beb0a;

   private IIiIIIIIi_Class66(String var3) {
      this.I_field_523beb0a = "modules.auto_farm.phase." + var3;
   }

   public String I_method_12d0e881() {
      return IiIiIIII_Class81.I_method_f25a980a(this.I_field_523beb0a);
   }
}
