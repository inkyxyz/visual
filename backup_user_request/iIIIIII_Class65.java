package rockstar.client;

import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.CookieManager;
import java.net.URL;
import java.util.HashMap;
import java.util.Optional;

public class iIIIIII_Class65 extends Iiiiiii_Class64 {
   private final IiiIiii_Class56 I_field_c5093bcc;

   public iIIIIII_Class65(iIIIII_Class33 var1, IiiIiiI_Class55 var2, IiiIiii_Class56 var3) {
      super(var1, var2);
      this.I_field_c5093bcc = var3;
   }

   @Override
   public IiiiIIi_Class58 I_method_a2a3535() throws IOException {
      return this.I_method_9feed3bd(this.I_field_c5093bcc);
   }

   public IiiiIIi_Class58 I_method_9feed3bd(IiiIiii_Class56 var1) throws IOException {
      CookieManager var2 = new CookieManager();
      IIIIIii_Class4 var3 = this.I_method_17d90842(var1, var2);
      iIIIiI_Class35 var4 = this.I_method_6260ab17(var3);
      String var5 = var4.I_method_a5598def("Location").orElseThrow(() -> new IllegalStateException("Failed to get redirect url"));
      String var6 = IIIiiII_Class13.II_method_3a54c182(var5)
         .I_method_1c698690()
         .I_method_d9c92b41("code")
         .orElseThrow(() -> new IllegalStateException("Failed to extract auth code from redirect url"));
      return this.I_field_20717641.I_method_fc2df765(new IiiiIiI_Class59(this.I_field_c50937ec, var6));
   }

   private IIIIIii_Class4 I_method_17d90842(IiiIiii_Class56 var1, CookieManager var2) throws IOException {
      URL var3 = IIIiiII_Class13.i_method_6e1bdf1f(this.I_field_c50937ec.I_method_37e8d915().i_method_e3089621())
         .I_method_1c698690()
         .I_method_3c2cdd7c(this.I_field_c50937ec.I_method_15b03494())
         .I_method_e8ddf150()
         .I_method_56a838d6();
      IIIIIIi_Class2 var4 = new IIIIIIi_Class2(var3);
      var4.I_method_1877e926(var2);
      var4.i_method_33057dd7("Accept", iIIIii_Class36.IIii_field_58cf7a41.I_method_c05e0394());
      IiiiIi_Class30 var5 = this.I_field_20717641.I_method_9ec8aba4(var4, var1x -> {
         if (var1x.I_method_207e3e9f() >= 300) {
            Optional var2x = var1x.I_method_a5598def("Location");
            if (var2x.isPresent()) {
               IIIiiII_Class13.Nested1_ed389a00 var3x = IIIiiII_Class13.II_method_3a54c182((String)var2x.get()).I_method_1c698690();
               Optional var4x = var3x.I_method_d9c92b41("error");
               Optional var5x = var3x.I_method_d9c92b41("error_description");
               if (var4x.isPresent() && var5x.isPresent()) {
                  throw new IiiIiIi_Class54(var1x, (String)var4x.get(), (String)var5x.get());
               }
            }

            throw new iIiiii_Class48(var1x);
         } else {
            return this.I_method_1e6e204e(var1x.I_method_5d16674b().I_method_963beb74());
         }
      });
      HashMap var7 = new HashMap();
      String var6;
      switch (this.I_field_c50937ec.I_method_37e8d915()) {
         case I_field_c508bfcc:
            var6 = var5.i_method_7caa7e8a("urlPost");
            String var8 = var5.i_method_7caa7e8a("sFTTag");
            String var9 = var8.substring(var8.indexOf("value=\"") + 7);
            var9 = var9.substring(0, var9.indexOf("\""));
            String var10 = var8.substring(var8.indexOf("name=\"") + 6);
            var10 = var10.substring(0, var10.indexOf("\""));
            var7.put("login", var1.I_method_164eea01());
            var7.put("loginfmt", var1.I_method_164eea01());
            var7.put("passwd", var1.i_method_a96d9a21());
            var7.put(var10, var9);
            break;
         case i_field_c508bfcc:
         case II_field_c508bfcc:
            var6 = IIIiiII_Class13.II_method_3a54c182(var5.i_method_7caa7e8a("urlPost"))
               .Ii_method_69467562(var3.getProtocol())
               .iI_method_e99989a2(var3.getHost())
               .I_method_56a838d6()
               .toString();
            var7.put("login", var1.I_method_164eea01());
            var7.put("loginfmt", var1.I_method_164eea01());
            var7.put("passwd", var1.i_method_a96d9a21());
            var7.put("ctx", var5.i_method_7caa7e8a("sCtx"));
            var7.put(var5.i_method_7caa7e8a("sFTName"), var5.i_method_7caa7e8a("sFT"));
            break;
         default:
            throw new IllegalStateException("Unsupported MsaEnvironment: " + this.I_field_c50937ec.I_method_37e8d915());
      }

      IIIIIii_Class4 var11 = new IIIIIii_Class4(var6);
      var11.I_method_1877e926(var2);
      var11.i_method_33057dd7("Accept", iIIIii_Class36.IIii_field_58cf7a41.I_method_c05e0394());
      var11.I_method_ef32890a(new iIiiiI_Class47(var7));
      return var11;
   }

   private iIIIiI_Class35 I_method_6260ab17(iiiiii_Class64 var1) throws IOException {
      iIIIiI_Class35 var2 = this.I_field_20717641.I_method_7ad89d6a(var1);
      if (var2.I_method_207e3e9f() != 302) {
         if (!var2.I_method_5d16674b().i_method_ae461b4b().I_method_c05e0394().equals(iIIIii_Class36.IIii_field_58cf7a41.I_method_c05e0394())) {
            throw new iIiiIii_Class92(var2, "Wrong content type");
         } else {
            String var3 = var2.I_method_5d16674b().I_method_963beb74();
            if (var3.contains("<body onload=\"javascript:DoSubmit();\">")) {
               String var7 = var3.substring(var3.indexOf("action=\"") + 8);
               var7 = var7.substring(0, var7.indexOf("\""));
               String var5 = IIIiiII_Class13.i_method_6e1bdf1f(var7).I_method_1c698690().I_method_d9c92b41("ru").orElse(null);
               if (var5 == null) {
                  throw new IllegalStateException("Failed to extract return url from html");
               } else {
                  IIIIIIi_Class2 var6 = new IIIIIIi_Class2(var5);
                  var6.I_method_1877e926(var1.I_method_6e9e47ef());
                  var6.i_method_33057dd7("Accept", iIIIii_Class36.IIii_field_58cf7a41.I_method_c05e0394());
                  return this.I_method_6260ab17(var6);
               }
            } else {
               IiiiIi_Class30 var4 = this.I_method_1e6e204e(var3);
               switch (this.I_field_c50937ec.I_method_37e8d915()) {
                  case I_field_c508bfcc:
                     if (var4.III_method_15e7b21a("sErrorCode") && var4.III_method_15e7b21a("sErrTxt")) {
                        throw new IiiIiIi_Class54(var2, var4.i_method_7caa7e8a("sErrorCode"), var4.i_method_7caa7e8a("sErrTxt"));
                     }
                     break;
                  case i_field_c508bfcc:
                  case II_field_c508bfcc:
                     if (var4.III_method_15e7b21a("iErrorCode") && var4.III_method_15e7b21a("strServiceExceptionMessage")) {
                        throw new IiiIiIi_Class54(var2, var4.i_method_7caa7e8a("iErrorCode"), var4.i_method_7caa7e8a("strServiceExceptionMessage"));
                     }
                     break;
                  default:
                     throw new IllegalStateException("Unsupported MsaEnvironment: " + this.I_field_c50937ec.I_method_37e8d915());
               }

               throw new IllegalStateException(
                  "Failed to extract config from html. This most likely indicates that the application config or credentials are not valid"
               );
            }
         }
      } else {
         return var2;
      }
   }

   private IiiiIi_Class30 I_method_1e6e204e(String var1) {
      String var2;
      switch (this.I_field_c50937ec.I_method_37e8d915()) {
         case I_field_c508bfcc:
            int var5 = var1.indexOf("var ServerData = ");
            if (var5 == -1) {
               throw new IllegalStateException("Failed to find config start in html");
            }

            var2 = var1.substring(var5 + 17);
            break;
         case i_field_c508bfcc:
         case II_field_c508bfcc:
            int var3 = var1.indexOf("$Config=");
            if (var3 == -1) {
               throw new IllegalStateException("Failed to find config start in html");
            }

            var2 = var1.substring(var3 + 8);
            break;
         default:
            throw new IllegalStateException("Unsupported MsaEnvironment: " + this.I_field_c50937ec.I_method_37e8d915());
      }

      try {
         JsonReader var6 = new JsonReader(new StringReader(var2));
         var6.setLenient(true);
         return IiiIiI_Class27.I_method_1e56a3a0(var6).I_method_9b832f2b();
      } catch (Throwable var4) {
         throw new IllegalStateException(
            "Failed to extract config from html. This most likely indicates that the application config or credentials are not valid", var4
         );
      }
   }
}
