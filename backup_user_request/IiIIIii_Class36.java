package rockstar.client;

import java.io.IOException;
import java.net.MalformedURLException;

public class IiIIIii_Class36 extends IIIIIIi_Class2 implements iiIiiI_Class55<String> {
   public IiIIIii_Class36(String var1) throws MalformedURLException {
      super("https://" + var1 + "/mco/client/compatible");
      this.i_method_33057dd7("Accept", iIIIii_Class36.IiII_field_58cf7a41.I_method_c05e0394());
   }

   @Override
   public String handle(iIIIiI_Class35 var1) throws IOException {
      if (var1.I_method_207e3e9f() >= 300) {
         throw new iIiiii_Class48(var1);
      } else {
         return var1.I_method_5d16674b().I_method_963beb74();
      }
   }
}
