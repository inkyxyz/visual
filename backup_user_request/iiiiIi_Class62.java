package rockstar.client;

import java.io.IOException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.net.Authenticator;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import lombok.SneakyThrows;

public class iiiiIi_Class62 extends ProxySelector {
   private static final MethodHandle I_field_d3da909b;
   private final Proxy I_field_bfbcc8a0;
   private final String I_field_523beb0a;
   private final String i_field_523beb0a;
   private final ProxySelector I_field_4a9f3b81;
   private final Authenticator I_field_b3ca7b3b;

   @SneakyThrows(Throwable.class)
   public iiiiIi_Class62(Proxy var1, String var2, String var3) {
      this.I_field_bfbcc8a0 = var1;
      this.I_field_523beb0a = var2;
      this.i_field_523beb0a = var3;
      this.I_field_4a9f3b81 = ProxySelector.getDefault();
      this.I_field_b3ca7b3b = (Authenticator)I_field_d3da909b.invokeExact();
   }

   public iiiiIi_Class62 I_method_de05d00f(boolean var1) {
      if (var1) {
         ProxySelector.setDefault(this);
      }

      if (this.I_field_523beb0a != null && this.i_field_523beb0a != null) {
         Authenticator.setDefault(new iiiiII_Class61(this.I_field_523beb0a, this.i_field_523beb0a));
      }

      return this;
   }

   public iiiiIi_Class62 i_method_f826bbef(boolean var1) {
      if (var1) {
         ProxySelector.setDefault(this.I_field_4a9f3b81);
      }

      if (this.I_field_523beb0a != null && this.i_field_523beb0a != null) {
         Authenticator.setDefault(this.I_field_b3ca7b3b);
      }

      return this;
   }

   @Override
   public List<Proxy> select(URI var1) {
      return Collections.singletonList(this.I_field_bfbcc8a0);
   }

   @Override
   public void connectFailed(URI var1, SocketAddress var2, IOException var3) {
   }

   static {
      MethodHandle var0;
      try {
         var0 = MethodHandles.lookup().findStatic(Authenticator.class, "getDefault", MethodType.methodType(Authenticator.class));
      } catch (Throwable var4) {
         try {
            Field var2 = Authenticator.class.getDeclaredField("theAuthenticator");
            var2.setAccessible(true);
            var0 = MethodHandles.lookup().unreflectGetter(var2);
         } catch (Throwable var3) {
            var0 = MethodHandles.constant(Authenticator.class, null);
         }
      }

      I_field_d3da909b = var0;
   }
}
