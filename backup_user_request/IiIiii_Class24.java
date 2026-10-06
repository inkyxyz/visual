package rockstar.client;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ua.mintantileak.profile.Profile;
import ua.mintantileak.spk.Compile;

public class IiIiii_Class24 {
   @Compile(
      obfuscation = 4
   )
   public static void I_method_3fd6ba2c() {
      RockstarClient.I_field_502d1741.initialize();
   }

   public static void i_method_3fe5460c() {
      RockstarClient.I_field_502d1741.shutdown();
   }

   public static void I_method_e10e7018(CallbackInfoReturnable<String> var0) {
      if (!RockstarClient.I_field_502d1741.i_method_e8604970()) {
         String var1 = "Agravity 1.0 alpha";
         var0.setReturnValue(var1);
      }
   }
}
