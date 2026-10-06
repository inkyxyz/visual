package rockstar.client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class I {
   private final String I_field_523beb0a;
   private final String i_field_523beb0a;
   private final Gson I_field_fbd77e28;

   public I(String var1) {
      this("https://events.felon.su/api", var1);
   }

   public I(String var1, String var2) {
      this.I_field_523beb0a = var1.endsWith("/") ? var1.substring(0, var1.length() - 1) : var1;
      this.i_field_523beb0a = var2;
      this.I_field_fbd77e28 = new Gson();
   }

   public List<i_Class2> I_method_a7fcd8a8() throws IOException, InterruptedException {
      String var1 = this.I_method_e31563f7("/events");
      Type var2 = (new TypeToken<List<i_Class2>>() {}).getType();
      return (List<i_Class2>)this.I_field_fbd77e28.fromJson(var1, var2);
   }

   public List<II> i_method_5d4910c8() throws IOException, InterruptedException {
      String var1 = this.I_method_e31563f7("/mines");
      Type var2 = (new TypeToken<List<II>>() {}).getType();
      return (List<II>)this.I_field_fbd77e28.fromJson(var1, var2);
   }

   private String I_method_e31563f7(String var1) throws IOException {
      iIiIiiiiI_Class351.Nested1_e2f5a480 var2 = iIiIiiiiI_Class351.I_method_59510627(
         this.I_field_523beb0a + var1, "X-System-Token", this.i_field_523beb0a, "Accept", "application/json"
      );
      if (var2.I_method_66072f2d() == 401) {
         throw new SecurityException("Authentication failed: Invalid system API token.");
      } else if (var2.I_method_66072f2d() == 403) {
         throw new SecurityException("Access denied: Forbidden resource.");
      } else if (!var2.I_method_66072f3e()) {
         throw new IOException("Server error: HTTP " + var2.I_method_66072f2d() + " - " + var2.I_method_23a3e0a6());
      } else {
         return var2.I_method_23a3e0a6();
      }
   }
}
