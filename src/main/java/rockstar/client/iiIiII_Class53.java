package rockstar.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.net.ssl.HttpsURLConnection;

public class iiIiII_Class53 extends iiIIii_Class52 {
   public iiIiII_Class53(iIIIII_Class33 var1) {
      super(var1);
   }

   @Nonnull
   @Override
   public iIIIiI_Class35 I_method_70c9916a(@Nonnull iiiiii_Class64 var1) throws IOException {
      CookieManager var2 = this.I_method_a35505ee(var1);
      iiiIiI_Class59 var3 = this.I_field_20717641.I_method_7e1c7f6b();
      iiiiIi_Class62 var4 = null;
      if (var3.I_method_323a42b0()) {
         var4 = var3.I_method_54bf86eb();
      }

      iIIIiI_Class35 var6;
      try {
         if (var4 != null) {
            var4.I_method_de05d00f(false);
         }

         HttpURLConnection var5 = this.I_method_43409dcc(var1, var2, var4 == null ? null : var3);
         var6 = this.I_method_b1bad9bc(var5, var2, var1);
      } finally {
         if (var4 != null) {
            var4.i_method_f826bbef(false);
         }
      }

      return var6;
   }

   private HttpURLConnection I_method_43409dcc(iiiiii_Class64 var1, CookieManager var2, iiiIiI_Class59 var3) throws IOException {
      URL var4 = var1.I_method_816b7c29();
      HttpURLConnection var5;
      if (var3 == null) {
         var5 = (HttpURLConnection)var4.openConnection();
      } else {
         var5 = (HttpURLConnection)var4.openConnection(var3.I_method_f476cf8a());
      }

      if (this.i_method_44853331(var1) && var5 instanceof HttpsURLConnection) {
         HttpsURLConnection var6 = (HttpsURLConnection)var5;
         var6.setSSLSocketFactory(IIIiIIi_Class10.I_method_862f0695().getSocketFactory());
      }

      this.I_method_c32fff5b(var5, var2, var1);
      var5.connect();
      return var5;
   }

   private void I_method_c32fff5b(HttpURLConnection var1, @Nullable CookieManager var2, iiiiii_Class64 var3) throws IOException {
      this.I_method_4b3d5439(this.I_method_2a21787(var3, var2), var1::setRequestProperty, var1::addRequestProperty);
      iiiiiI_Class63 var4 = var3 instanceof iiiiiI_Class63 ? (iiiiiI_Class63)var3 : null;
      iIiIII_Class41 var5 = var4 != null ? var4.I_method_bb2eeb6b() : null;
      var1.setConnectTimeout(this.I_field_20717641.I_method_83b6d67f());
      var1.setReadTimeout(this.I_field_20717641.i_method_83c5625f());
      var1.setRequestMethod(var3.I_method_ccca7b4());
      var1.setDoInput(true);
      if (var4 != null && var5 != null) {
         var1.setDoOutput(true);
         if (var3.i_method_65097e50()) {
            if (var5.I_method_533eee5f() >= 0) {
               var1.setFixedLengthStreamingMode(var5.I_method_533eee5f());
            } else {
               var1.setChunkedStreamingMode(0);
            }
         }
      } else {
         var1.setDoOutput(false);
      }

      switch (var3.I_method_7ccca346()) {
         case I_field_9b46309c:
            var1.setInstanceFollowRedirects(this.I_field_20717641.I_method_83b6d690());
            break;
         case i_field_9b46309c:
            var1.setInstanceFollowRedirects(true);
            break;
         case II_field_9b46309c:
            var1.setInstanceFollowRedirects(false);
      }
   }

   private iIIIiI_Class35 I_method_b1bad9bc(HttpURLConnection var1, @Nullable CookieManager var2, iiiiii_Class64 var3) throws IOException {
      boolean var4 = true;

      iIIIiI_Class35 var18;
      try {
         if (var1.getDoOutput()) {
            iIiIII_Class41 var5 = ((iiiiiI_Class63)var3).I_method_bb2eeb6b();
            OutputStream var6 = var1.getOutputStream();

            try {
               var5.I_method_f7462b9e(var6);
            } catch (Throwable var14) {
               if (var6 != null) {
                  try {
                     var6.close();
                  } catch (Throwable var13) {
                     var14.addSuppressed(var13);
                  }
               }

               throw var14;
            }

            if (var6 != null) {
               var6.close();
            }
         }

         HashMap var16 = new HashMap<>(var1.getHeaderFields());
         var16.remove(null);
         InputStream var7 = this.I_method_d37b0978(var1);
         iIIIiI_Class35 var17;
         if (var3.II_method_3a725279()) {
            var17 = new iIIIiI_Class35(var3.I_method_816b7c29(), var1.getResponseCode(), var7, var16);
            var4 = false;
         } else {
            byte[] var8 = this.I_method_b9ae7441(var7, var1.getContentLength());
            var17 = new iIIIiI_Class35(var3.I_method_816b7c29(), var1.getResponseCode(), var8, var16);
         }

         this.I_method_c7fcbed5(var2, var3.I_method_816b7c29(), var1.getHeaderFields());
         var18 = var17;
      } finally {
         if (var4) {
            var1.disconnect();
         }
      }

      return var18;
   }

   private InputStream I_method_d37b0978(HttpURLConnection var1) throws IOException {
      Object var2;
      if (var1.getResponseCode() >= 400) {
         var2 = var1.getErrorStream();
      } else {
         var2 = var1.getInputStream();
      }

      if (var2 == null) {
         var2 = new ByteArrayInputStream(new byte[0]);
      }

      return (InputStream)var2;
   }

   private byte[] I_method_b9ae7441(InputStream var1, int var2) throws IOException {
      ByteArrayOutputStream var3 = new ByteArrayOutputStream(var2 >= 0 ? var2 : 1024);
      byte[] var4 = new byte[1024];

      int var5;
      while ((var5 = var1.read(var4)) >= 0) {
         var3.write(var4, 0, var5);
      }

      return var3.toByteArray();
   }
}
