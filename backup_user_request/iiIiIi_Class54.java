package rockstar.client;

import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.ssl.SslContextBuilder;
import java.io.IOException;
import java.net.CookieManager;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nonnull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.ByteBufFlux;
import reactor.netty.http.client.HttpClient;
import reactor.netty.http.client.HttpClient.RequestSender;
import reactor.netty.tcp.SslProvider;
import reactor.netty.transport.ProxyProvider.AddressSpec;
import reactor.netty.transport.ProxyProvider.Builder;
import reactor.netty.transport.ProxyProvider.Proxy;

public class iiIiIi_Class54 extends iiIIii_Class52 {
   private static final byte[] I_field_b47 = new byte[0];

   public iiIiIi_Class54(iIIIII_Class33 var1) {
      super(var1);
   }

   @Nonnull
   @Override
   public iIIIiI_Class35 I_method_70c9916a(@Nonnull iiiiii_Class64 var1) throws IOException {
      CookieManager var2 = this.I_method_a35505ee(var1);
      HttpClient var3 = this.I_method_f4827549(var1, var2);
      RequestSender var4 = (RequestSender)var3.request(HttpMethod.valueOf(var1.I_method_ccca7b4()))
         .uri(IIIiiII_Class13.I_method_79b3b74(var1.I_method_816b7c29()).I_method_56a83879());
      HttpClient.ResponseReceiver<?> var5 = var4;
      if (var1 instanceof iiiiiI_Class63) {
         iiiiiI_Class63 var6 = (iiiiiI_Class63)var1;
         if (var6.I_method_bb2eeb6b() != null) {
            var5 = var4.send(ByteBufFlux.fromInbound(Flux.just(var6.I_method_bb2eeb6b().I_method_7c521fb1())));
         }
      }

      try {
         return (iIIIiI_Class35)var5.responseSingle((var2x, var3x) -> {
            try {
               URL var4x = IIIiiII_Class13.i_method_6e1bdf1f(var2x.resourceUrl()).I_method_56a838d6();
               Map var5x = this.I_method_53c86cdf(var2x.responseHeaders());
               this.I_method_c7fcbed5(var2, var4x, var5x);
               return var3x.asByteArray().defaultIfEmpty(I_field_b47).map(var3xx -> new iIIIiI_Class35(var4x, var2x.status().code(), var3xx, var5x));
            } catch (Throwable var6x) {
               return Mono.error(var6x);
            }
         }).blockOptional().orElseThrow(() -> new IOException("Response is null"));
      } catch (Throwable var8) {
         for (Throwable var7 = var8; var7 != null; var7 = var7.getCause()) {
            if (var7 instanceof IOException) {
               throw (IOException)var7;
            }
         }

         throw new IOException("Failed to execute request", var8);
      }
   }

   private HttpClient I_method_f4827549(iiiiii_Class64 var1, CookieManager var2) throws IOException {
      Map var3 = this.I_method_2a21787(var1, var2);
      HttpClient var4 = HttpClient.create()
         .responseTimeout(Duration.ofMillis(this.I_field_20717641.i_method_83c5625f()))
         .followRedirect(this.I_method_2a644751(var1))
         .headers(var2x -> this.I_method_4b3d5439(var3, var2x::set, var2x::add));
      if (this.i_method_44853331(var1)) {
         var4 = var4.secure(SslProvider.builder().sslContext(SslContextBuilder.forClient().trustManager(new IIIiIIi_Class10()).build()).build());
      }

      if (this.I_field_20717641.I_method_7e1c7f6b().I_method_323a42b0()) {
         iiiIiI_Class59 var5 = this.I_field_20717641.I_method_7e1c7f6b();
         var4 = (HttpClient)var4.proxy(var1x -> {
            AddressSpec var2x;
            switch (var5.I_method_54b1732b()) {
               case I_field_58cff641:
                  var2x = var1x.type(Proxy.HTTP);
                  break;
               case i_field_58cff641:
                  var2x = var1x.type(Proxy.SOCKS4);
                  break;
               case II_field_58cff641:
                  var2x = var1x.type(Proxy.SOCKS5);
                  break;
               default:
                  throw new IllegalArgumentException("Unsupported proxy type: " + var5.I_method_54b1732b());
            }

            Builder var3x = var2x.address((java.net.InetSocketAddress)var5.I_method_f7f14257());
            if (var5.I_method_408fdf74() != null) {
               var3x.username(var5.I_method_408fdf74());
            }

            if (var5.i_method_d3ae8f94() != null) {
               var3x.password(var1xx -> var5.i_method_d3ae8f94());
            }
         });
      }

      return var4;
   }

   private Map<String, List<String>> I_method_53c86cdf(HttpHeaders var1) {
      HashMap<String, List<String>> var2 = new HashMap<>();

      for (Entry var4 : var1.entries()) {
         var2.computeIfAbsent((String)var4.getKey(), var0 -> new ArrayList<>()).add((String)var4.getValue());
      }

      return var2;
   }
}
