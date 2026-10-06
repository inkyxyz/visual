package rockstar.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;

public final class iIiIiiiiI_Class351 {
   private static final int I_field_49 = 5000;
   private static final int i_field_49 = 6000;
   private static final int II_field_49 = 33554432;

   private iIiIiiiiI_Class351() {
   }

   public static iIiIiiiiI_Class351.Nested1_e2f5a480 I_method_59510627(String var0, String... var1) throws IOException {
      HttpURLConnection var2 = (HttpURLConnection)URI.create(var0).toURL().openConnection();

      iIiIiiiiI_Class351.Nested1_e2f5a480 var5;
      try {
         var2.setRequestMethod("GET");
         var2.setConnectTimeout(5000);
         var2.setReadTimeout(6000);
         var2.setInstanceFollowRedirects(true);

         for (int var3 = 0; var3 + 1 < var1.length; var3 += 2) {
            var2.setRequestProperty(var1[var3], var1[var3 + 1]);
         }

         int var15 = var2.getResponseCode();
         InputStream var4 = var15 >= 400 ? var2.getErrorStream() : var2.getInputStream();
         if (var4 != null) {
            InputStream var16 = var4;

            iIiIiiiiI_Class351.Nested1_e2f5a480 var6;
            try {
               var6 = new iIiIiiiiI_Class351.Nested1_e2f5a480(var15, new String(var4.readAllBytes(), I_method_afc077fc(var2)));
            } catch (Throwable var13) {
               if (var4 != null) {
                  try {
                     var16.close();
                  } catch (Throwable var12) {
                     var13.addSuppressed(var12);
                  }
               }

               throw var13;
            }

            if (var4 != null) {
               var4.close();
            }

            return var6;
         }

         var5 = new iIiIiiiiI_Class351.Nested1_e2f5a480(var15, "");
      } finally {
         var2.disconnect();
      }

      return var5;
   }

   public static byte[] I_method_b8c2db27(String var0, String... var1) throws IOException {
      return I_method_f77328b8(var0, 33554432, var1);
   }

   public static byte[] I_method_f77328b8(String var0, int var1, String... var2) throws IOException {
      HttpURLConnection var3 = (HttpURLConnection)URI.create(var0).toURL().openConnection();

      byte[] var6;
      try {
         var3.setRequestMethod("GET");
         var3.setConnectTimeout(5000);
         var3.setReadTimeout(6000);
         var3.setInstanceFollowRedirects(true);

         for (int var4 = 0; var4 + 1 < var2.length; var4 += 2) {
            var3.setRequestProperty(var2[var4], var2[var4 + 1]);
         }

         int var15 = var3.getResponseCode();
         if (var15 != 200) {
            throw new IOException("HTTP " + var15 + " \u043e\u0442 " + var0);
         }

         try (InputStream var5 = var3.getInputStream()) {
            var6 = I_method_32ab7c64(var5, var1, var0);
         }
      } finally {
         var3.disconnect();
      }

      return var6;
   }

   private static byte[] I_method_32ab7c64(InputStream var0, int var1, String var2) throws IOException {
      ByteArrayOutputStream var3 = new ByteArrayOutputStream();
      byte[] var4 = new byte[16384];

      int var5;
      while ((var5 = var0.read(var4)) != -1) {
         if (var3.size() + var5 > var1) {
            throw new IOException("\u043e\u0442\u0432\u0435\u0442 \u0431\u043e\u043b\u044c\u0448\u0435 " + var1 / 1048576 + " \u041c\u0411: " + var2);
         }

         var3.write(var4, 0, var5);
      }

      return var3.toByteArray();
   }

   private static Charset I_method_afc077fc(HttpURLConnection var0) {
      String var1 = var0.getContentType();
      if (var1 == null) {
         return StandardCharsets.UTF_8;
      } else {
         for (String var5 : var1.split(";")) {
            String var6 = var5.trim();
            if (var6.regionMatches(true, 0, "charset=", 0, 8)) {
               String var7 = var6.substring(8).replace("\"", "").trim();

               try {
                  return Charset.forName(var7);
               } catch (UnsupportedCharsetException | IllegalCharsetNameException var9) {
                  return StandardCharsets.UTF_8;
               }
            }
         }

         return StandardCharsets.UTF_8;
      }
   }

   public static final class Nested1_e2f5a480 {
      private final int I_field_49;
      private final String I_field_523beb0a;

      public Nested1_e2f5a480(int var1, String var2) {
         this.I_field_49 = var1;
         this.I_field_523beb0a = var2;
      }

      public boolean I_method_66072f3e() {
         return this.I_field_49 == 200;
      }

      @Override
      public final String toString() {
         return "Nested1_e2f5a480[status=" + this.I_field_49 + ", body=" + this.I_field_523beb0a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIiIiiiiI_Class351.Nested1_e2f5a480 other = (iIiIiiiiI_Class351.Nested1_e2f5a480) var1;
         return java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a);
      }

      public int I_method_66072f2d() {
         return this.I_field_49;
      }

      public String I_method_23a3e0a6() {
         return this.I_field_523beb0a;
      }
   }
}
