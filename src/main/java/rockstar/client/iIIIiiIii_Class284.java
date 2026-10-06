package rockstar.client;

public enum iIIIiiIii_Class284 {
   I_field_ac164e6c("funtime", "playft"),
   i_field_ac164e6c("spooky"),
   II_field_ac164e6c("reallyworld", "playrw"),
   Ii_field_ac164e6c("holy", "holly", "playhw"),
   iI_field_ac164e6c("cherry.pizza"),
   ii_field_ac164e6c("funtime", "playft", "reallyworld", "playrw", "funsky", "slimeworld"),
   III_field_ac164e6c("mineblaze", "dexland"),
   IIi_field_ac164e6c("funtime", "playft", "spooky", "funsky", "holytime"),
   IiI_field_ac164e6c("saturn"),
   Iii_field_ac164e6c("funsky"),
   iII_field_ac164e6c("funtime", "playft", "spooky", "funsky", "slimeworld", "cakeworld", "holytime"),
   iIi_field_ac164e6c("holyworld", "playhw", "hollyworld"),
   iiI_field_ac164e6c("reallyworld", "playrw", "slimeworld", "cakeworld");

   private final String[] I_field_6dccaaa5;

   private iIIIiiIii_Class284(String... var3) {
      this.I_field_6dccaaa5 = var3;
   }

   public boolean I_method_a6cbde2d(String var1) {
      var1 = var1.toLowerCase();

      for (String var5 : this.I_field_6dccaaa5) {
         if (var1.contains(var5)) {
            return true;
         }
      }

      return false;
   }
}
