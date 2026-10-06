package globals.client.net;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class Gz {
   private Gz() {
   }

   public static String deflateBase64(String var0) {
      if (var0 == null) {
         return null;
      } else {
         try {
            String var10;
            try (ByteArrayOutputStream var1 = new ByteArrayOutputStream()) {
               try (GZIPOutputStream var2 = new GZIPOutputStream(var1)) {
                  var2.write(var0.getBytes(StandardCharsets.UTF_8));
               }

               var10 = Base64.getEncoder().encodeToString(var1.toByteArray());
            }

            return var10;
         } catch (Exception var9) {
            return null;
         }
      }
   }

   public static String inflateBase64(String var0, int var1) {
      if (var0 != null && !var0.isBlank()) {
         try {
            byte[] var2 = Base64.getDecoder().decode(var0);

            String var13;
            try (
               GZIPInputStream var3 = new GZIPInputStream(new ByteArrayInputStream(var2));
               ByteArrayOutputStream var4 = new ByteArrayOutputStream();
            ) {
               byte[] var5 = new byte[8192];

               int var6;
               while ((var6 = var3.read(var5)) != -1) {
                  if (var4.size() + var6 > var1) {
                     return null;
                  }

                  var4.write(var5, 0, var6);
               }

               var13 = var4.toString(StandardCharsets.UTF_8);
            }

            return var13;
         } catch (Exception var12) {
            return null;
         }
      } else {
         return null;
      }
   }
}
