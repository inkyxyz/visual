package rockstar.client;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Builder;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.Nonnull;

public class iiIIiI_Class51 extends iiIIii_Class52 {
   public iiIIiI_Class51(iIIIII_Class33 var1) {
      super(var1);
   }

   @Nonnull
   @Override
   public iIIIiI_Class35 I_method_70c9916a(@Nonnull iiiiii_Class64 var1) throws IOException {
      ExecutorService var2 = Executors.newCachedThreadPool();
      HttpClient var3 = null;
      boolean var4 = true;

      iIIIiI_Class35 var8;
      try {
         var3 = this.I_method_3c5dc0e1(var1, var2);
         HttpRequest var5 = this.I_method_dc3693ff(var1);
         if (!var1.II_method_3a725279()) {
            HttpResponse var12 = this.I_method_cd1afb38(var3, var5, BodyHandlers.ofByteArray());
            return new iIIIiI_Class35(new IIIiiII_Class13(var12.uri()).I_method_56a838d6(), var12.statusCode(), (byte[])var12.body(), var12.headers().map());
         }

         HttpResponse var6 = this.I_method_cd1afb38(var3, var5, BodyHandlers.ofInputStream());
         IIIiiIi_Class14 var7 = new IIIiiIi_Class14((InputStream)var6.body(), this.I_method_8e204936(var2, var3));
         var4 = false;
         var8 = new iIIIiI_Class35(new IIIiiII_Class13(var6.uri()).I_method_56a838d6(), var6.statusCode(), var7, var6.headers().map());
      } finally {
         if (var4) {
            this.I_method_8e204936(var2, var3).close();
         }
      }

      return var8;
   }

   private HttpClient I_method_3c5dc0e1(iiiiii_Class64 var1, Executor var2) throws IOException {
      Builder var3 = HttpClient.newBuilder().executor(var2);
      CookieManager var4 = this.I_method_a35505ee(var1);
      if (var4 != null) {
         var3.cookieHandler(var4);
      }

      if (this.i_method_44853331(var1)) {
         var3.sslContext(IIIiIIi_Class10.I_method_862f0695());
      }

      var3.connectTimeout(Duration.ofMillis(this.I_field_20717641.I_method_83b6d67f()));
      switch (var1.I_method_7ccca346()) {
         case I_field_9b46309c:
            var3.followRedirects(this.I_field_20717641.I_method_83b6d690() ? Redirect.NORMAL : Redirect.NEVER);
            break;
         case i_field_9b46309c:
            var3.followRedirects(Redirect.NORMAL);
            break;
         case II_field_9b46309c:
            var3.followRedirects(Redirect.NEVER);
      }

      if (this.I_field_20717641.I_method_7e1c7f6b().I_method_323a42b0()) {
         if (!iiiIii_Class60.I_field_58cff641.equals(this.I_field_20717641.I_method_7e1c7f6b().I_method_54b1732b())) {
            throw new UnsupportedOperationException("The Java 11 HttpClient only supports HTTP proxies");
         }

         var3.proxy(this.I_field_20717641.I_method_7e1c7f6b().I_method_54bf86eb());
         if (this.I_field_20717641.I_method_7e1c7f6b().I_method_408fdf74() != null && this.I_field_20717641.I_method_7e1c7f6b().i_method_d3ae8f94() != null) {
            var3.authenticator(this.I_field_20717641.I_method_7e1c7f6b().I_method_54bf830b());
         }
      }

      return var3.build();
   }

   private HttpRequest I_method_dc3693ff(iiiiii_Class64 var1) throws IOException {
      java.net.http.HttpRequest.Builder var2 = HttpRequest.newBuilder();
      var2.uri(new IIIiiII_Class13(var1.I_method_816b7c29()).I_method_56a83879());
      var2.timeout(Duration.ofMillis(this.I_field_20717641.i_method_83c5625f()));
      BodyPublisher var3;
      if (var1 instanceof iiiiiI_Class63 && ((iiiiiI_Class63)var1).I_method_2e5fde90()) {
         iIiIII_Class41 var4 = ((iiiiiI_Class63)var1).I_method_bb2eeb6b();
         if (var1.i_method_65097e50()) {
            InputStream var5 = var4.i_method_4e61bf8f();
            var3 = BodyPublishers.ofInputStream(() -> var5);
         } else {
            var3 = BodyPublishers.ofByteArray(var4.I_method_7c521fb1());
         }
      } else {
         var3 = BodyPublishers.noBody();
      }

      var2.method(var1.I_method_ccca7b4(), var3);

      for (Entry var9 : this.I_method_2a21787(var1, null).entrySet()) {
         if (!((String)var9.getKey()).equalsIgnoreCase("Content-Length")) {
            for (String var7 : (Iterable<String>)(Iterable<?>)(List)var9.getValue()) {
               var2.header((String)var9.getKey(), var7);
            }
         }
      }

      return var2.build();
   }

   private <T> HttpResponse<T> I_method_cd1afb38(HttpClient var1, HttpRequest var2, BodyHandler<T> var3) throws IOException {
      try {
         return var1.send(var2, var3);
      } catch (InterruptedException var5) {
         throw new IOException("Request interrupted", var5);
      }
   }

   private IIIiiIi_Class14.Nested1_ed391200 I_method_8e204936(ExecutorService var1, HttpClient var2) {
      return () -> {
         var1.shutdownNow();
         if (var2 instanceof Closeable) {
            ((Closeable)var2).close();
         }
      };
   }
}
