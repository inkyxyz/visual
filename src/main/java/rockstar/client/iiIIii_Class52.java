package rockstar.client;

import java.io.IOException;
import java.net.CookieManager;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class iiIIii_Class52 {
   @Nonnull
   protected final iIIIII_Class33 I_field_20717641;

   public iiIIii_Class52(@Nonnull iIIIII_Class33 var1) {
      this.I_field_20717641 = var1;
   }

   @Nonnull
   public abstract iIIIiI_Class35 I_method_70c9916a(@Nonnull iiiiii_Class64 var1) throws IOException, InterruptedException;

   protected final boolean I_method_2a644751(@Nonnull iiiiii_Class64 var1) {
      switch (var1.I_method_7ccca346()) {
         case I_field_9b46309c:
            return this.I_field_20717641.I_method_83b6d690();
         case i_field_9b46309c:
            return true;
         case II_field_9b46309c:
            return false;
         default:
            throw new IllegalStateException("Unexpected value: " + var1.I_method_7ccca346());
      }
   }

   @Nullable
   protected final CookieManager I_method_a35505ee(@Nonnull iiiiii_Class64 var1) {
      return var1.Ii_method_3a80de59() ? var1.I_method_6e9e47ef() : this.I_field_20717641.I_method_d0f3bfcf();
   }

   protected final boolean i_method_44853331(@Nonnull iiiiii_Class64 var1) {
      return var1.ii_method_3c43ce79() ? var1.III_method_13e6f390() : this.I_field_20717641.i_method_83c56270();
   }

   protected final Map<String, List<String>> I_method_2a21787(@Nonnull iiiiii_Class64 var1, @Nullable CookieManager var2) throws IOException {
      return this.I_method_8057e6f7(var1, var2, true);
   }

   protected final Map<String, List<String>> I_method_8057e6f7(@Nonnull iiiiii_Class64 var1, @Nullable CookieManager var2, boolean var3) throws IOException {
      HashMap var4 = new HashMap();
      if (var2 != null) {
         try {
            Map var5 = var2.get(var1.I_method_816b7c29().toURI(), Collections.emptyMap());

            for (Entry var7 : (Iterable<Entry>)(Iterable<?>)var5.entrySet()) {
               if (!((List)var7.getValue()).isEmpty()) {
                  var4.put(((String)var7.getKey()).toLowerCase(), (List)var7.getValue());
               }
            }
         } catch (URISyntaxException var8) {
            throw new IOException("Failed to parse URL as URI", var8);
         }
      }

      if (var1 instanceof iiiiiI_Class63 && var3) {
         iIiIII_Class41 var9 = ((iiiiiI_Class63)var1).I_method_bb2eeb6b();
         if (var9 != null) {
            var4.put("Content-Type".toLowerCase(), Collections.singletonList(var9.i_method_ae461b4b().toString()));
            if (var9.I_method_533eee5f() < 0) {
               var4.put("Content-Length".toLowerCase(), Collections.singletonList(String.valueOf(var9.I_method_533eee5f())));
            }
         }
      }

      for (Entry var12 : this.I_field_20717641.I_method_6a24b781().entrySet()) {
         if (!((List)var12.getValue()).isEmpty()) {
            var4.put(((String)var12.getKey()).toLowerCase(), (List)var12.getValue());
         }
      }

      for (Entry var13 : var1.I_method_6a24b781().entrySet()) {
         if (!((List)var13.getValue()).isEmpty()) {
            var4.put(((String)var13.getKey()).toLowerCase(), (List)var13.getValue());
         }
      }

      return var4;
   }

   protected final void I_method_c7fcbed5(@Nullable CookieManager var1, URL var2, Map<String, List<String>> var3) throws IOException {
      if (var1 != null) {
         try {
            var1.put(var2.toURI(), var3);
         } catch (URISyntaxException var5) {
            throw new IOException("Failed to parse URL as URI", var5);
         }
      }
   }

   protected final void I_method_4b3d5439(Map<String, List<String>> var1, BiConsumer<String, String> var2, BiConsumer<String, String> var3) {
      for (Entry var5 : var1.entrySet()) {
         if ("Cookie".equalsIgnoreCase((String)var5.getKey())) {
            var2.accept((String)var5.getKey(), String.join("; ", (Iterable<? extends CharSequence>)var5.getValue()));
         } else {
            boolean var6 = true;

            for (String var8 : (Iterable<String>)(Iterable<?>)(List)var5.getValue()) {
               if (var6) {
                  var6 = false;
                  var2.accept((String)var5.getKey(), var8);
               } else {
                  var3.accept((String)var5.getKey(), var8);
               }
            }
         }
      }
   }
}
