package rockstar.client;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import globals.client.auth.SessionManager;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HexFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.OkHttpClient.Builder;

public final class IiIIiiIi_Class78 {
   private static final String I_field_523beb0a = "MCowBQYDK2VwAyEAvJLys8zcJoiWNwdStMVZRHLiXhJoxqYLw8vZS6aBpIs=";
   private static final String i_field_523beb0a = "https://rockstar.pub/api/v1/client/gate";
   private static final MediaType I_field_d5903de9 = MediaType.parse("application/json");
   private static final OkHttpClient I_field_c872e00 = new Builder().callTimeout(20L, TimeUnit.SECONDS).build();
   private static final SecureRandom I_field_ec5bca73 = new SecureRandom();
   private static final long I_field_4a = 120000L;
   private static final long i_field_4a = 60000L;
   private static final long II_field_4a = 5000L;
   private static final long Ii_field_4a = 60000L;
   private static final long iI_field_4a = 500L;
   private static final AtomicBoolean I_field_1232aa16 = new AtomicBoolean(false);
   private static final CountDownLatch I_field_7e15e03c = new CountDownLatch(1);
   private static volatile byte[] I_field_b47;
   private static volatile long ii_field_4a;
   private static final AtomicBoolean i_field_1232aa16 = new AtomicBoolean(false);

   private IiIIiiIi_Class78() {
   }

   public static void I_method_e728808c() {
      I_field_b47 = new byte[]{
         14, -44, 37, -40, 125, -2, -35, -11, -23, 93, -31, -78, -114, 78, -33, -117, -22, -47, -127, 86, 24, -109, 97, 80, -6, 6, 38, 70, -34, 11, -87, -8
      };
      I_field_7e15e03c.countDown();
      ii_field_4a = System.currentTimeMillis();
   }

   public static byte[] I_method_fde791d1() {
      byte[] var0 = I_field_b47;
      if (var0 != null) {
         return var0;
      } else {
         try {
            I_field_7e15e03c.await(120000L, TimeUnit.MILLISECONDS);
         } catch (InterruptedException var2) {
            Thread.currentThread().interrupt();
         }

         return I_field_b47;
      }
   }

   public static boolean I_method_e7288090() {
      return ii_field_4a > 0L && System.currentTimeMillis() - ii_field_4a < 60000L;
   }

   private static void i_method_e7370c6c() {
      String var0 = I_method_7e91d94();
      if (var0 == null) {
         I_method_fde843c8(true);
      } else {
         IiIIiiIi_Class78.Nested1_a7650913 var1 = I_method_fb99a81e("https://rockstar.pub/api/v1/client/gate", var0, true);
         if (var1 == null) {
            I_method_fde843c8(false);
         } else {
            I_method_c27a06c8(var1);
            ii_field_4a = System.currentTimeMillis();
            I_method_fde803f7(var1.I_field_49);
         }
      }
   }

   private static String I_method_7e91d94() {
      long var0 = System.currentTimeMillis() + 60000L;

      while (System.currentTimeMillis() < var0) {
         String var2 = SessionManager.accessToken();
         if (var2 != null) {
            return var2;
         }

         if (!SessionManager.isAvailable()) {
            return null;
         }

         try {
            Thread.sleep(500L);
         } catch (InterruptedException var4) {
            Thread.currentThread().interrupt();
            return null;
         }
      }

      return SessionManager.accessToken();
   }

   private static void I_method_fde803f7(int var0) {
      long var1 = Math.max(5, var0) * 1000L;

      while (!i_field_1232aa16.get()) {
         I_method_fde807b8(var1);
         String var3 = SessionManager.accessToken();
         if (var3 == null && !SessionManager.isAvailable()) {
            I_method_fde843c8(true);
            return;
         }

         IiIIiiIi_Class78.Nested1_a7650913 var4 = var3 == null ? null : I_method_fb99a81e("https://rockstar.pub/api/v1/client/gate/beat", var3, false);
         if (var4 != null) {
            ii_field_4a = System.currentTimeMillis();
            var1 = Math.max(5, var4.I_field_49) * 1000L;
         } else {
            long var5 = System.currentTimeMillis() - ii_field_4a;
            if (var5 > 60000L) {
               I_method_fde843c8(false);
               return;
            }

            I_method_fde807b8(5000L);
         }
      }
   }

   private static IiIIiiIi_Class78.Nested1_a7650913 I_method_fb99a81e(String var0, String var1, boolean var2) {
      byte[] var3 = new byte[24];
      I_field_ec5bca73.nextBytes(var3);
      String var4 = Base64.getUrlEncoder().withoutPadding().encodeToString(var3);
      JsonObject var5 = new JsonObject();
      var5.addProperty("nonce", var4);
      var5.addProperty("hwid", i_method_9b07cdb4());
      var5.addProperty("version", "2.1");
      Request var6 = new okhttp3.Request.Builder()
         .url(var0)
         .addHeader("Authorization", "Bearer " + var1)
         .post(RequestBody.create(I_field_d5903de9, var5.toString()))
         .build();

      try {
         Response var7 = I_field_c872e00.newCall(var6).execute();

         IiIIiiIi_Class78.Nested1_a7650913 var16;
         label65: {
            label66: {
               Object var8;
               try {
                  if (var7.isSuccessful() && var7.body() != null) {
                     JsonObject var15 = JsonParser.parseString(var7.body().string()).getAsJsonObject();
                     byte[] var9 = Base64.getDecoder().decode(var15.get("payload").getAsString());
                     byte[] var10 = Base64.getDecoder().decode(var15.get("signature").getAsString());
                     if (!I_method_7b002e5e(var9, var10)) {
                        var16 = null;
                        break label65;
                     }

                     var16 = I_method_d77bd85b(var9, var4, var2);
                     break label66;
                  }

                  var8 = null;
               } catch (Throwable var13) {
                  if (var7 != null) {
                     try {
                        var7.close();
                     } catch (Throwable var12) {
                        var13.addSuppressed(var12);
                     }
                  }

                  throw var13;
               }

               if (var7 != null) {
                  var7.close();
               }

               return (IiIIiiIi_Class78.Nested1_a7650913)var8;
            }

            if (var7 != null) {
               var7.close();
            }

            return var16;
         }

         if (var7 != null) {
            var7.close();
         }

         return var16;
      } catch (Exception var14) {
         return null;
      }
   }

   private static boolean I_method_7b002e5e(byte[] var0, byte[] var1) {
      if ("MCowBQYDK2VwAyEAvJLys8zcJoiWNwdStMVZRHLiXhJoxqYLw8vZS6aBpIs=".isEmpty()) {
         return true;
      } else {
         try {
            PublicKey var2 = KeyFactory.getInstance("Ed25519")
               .generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode("MCowBQYDK2VwAyEAvJLys8zcJoiWNwdStMVZRHLiXhJoxqYLw8vZS6aBpIs=")));
            Signature var3 = Signature.getInstance("Ed25519");
            var3.initVerify(var2);
            var3.update(var0);
            return var3.verify(var1);
         } catch (Exception var4) {
            return false;
         }
      }
   }

   private static IiIIiiIi_Class78.Nested1_a7650913 I_method_d77bd85b(byte[] var0, String var1, boolean var2) {
      JsonObject var3 = JsonParser.parseString(new String(var0, StandardCharsets.UTF_8)).getAsJsonObject();
      if (var3.get("v").getAsInt() != 1) {
         return null;
      } else if (!var1.equals(var3.get("nonce").getAsString())) {
         return null;
      } else {
         long var4 = System.currentTimeMillis() / 1000L;
         long var6 = var3.get("expiresAt").getAsLong();
         if (var6 <= var4 - 30L) {
            return null;
         } else {
            IiIIiiIi_Class78.Nested1_a7650913 var8 = new IiIIiiIi_Class78.Nested1_a7650913();
            var8.I_field_49 = var3.has("beat") ? var3.get("beat").getAsInt() : 30;
            if (var2) {
               if (!var3.has("key")) {
                  return null;
               }

               var8.I_field_b47 = HexFormat.of().parseHex(var3.get("key").getAsString());
               if (var8.I_field_b47.length != 32) {
                  return null;
               }
            }

            return var8;
         }
      }
   }

   private static void I_method_c27a06c8(IiIIiiIi_Class78.Nested1_a7650913 var0) {
      I_field_b47 = var0.I_field_b47;
      I_field_7e15e03c.countDown();
   }

   private static String i_method_9b07cdb4() {
      String var0 = System.getenv("MINT_PROFILE_HWID");
      return var0 == null ? "" : var0.trim();
   }

   private static void I_method_fde843c8(boolean var0) {
      if (i_field_1232aa16.compareAndSet(false, true)) {
         I_field_7e15e03c.countDown();
         boolean var1 = IiIIiiiI_Class79.I_method_4d54d4d0();
         if (var0 || var1) {
            System.out.println("=".repeat(70));
            if (var0) {
               System.out
                  .println(
                     " Rockstar: \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0432\u043e\u0439\u0442\u0438 \u0432 \u0430\u043a\u043a\u0430\u0443\u043d\u0442."
                  );
               System.out
                  .println(
                     " \u0417\u0430\u043f\u0443\u0441\u0442\u0438\u0442\u0435 \u0438\u0433\u0440\u0443 \u0447\u0435\u0440\u0435\u0437 \u043b\u0430\u0443\u043d\u0447\u0435\u0440 \u0437\u0430\u043d\u043e\u0432\u043e."
                  );
               if (!var1) {
                  System.out
                     .println(
                        " \u0417\u0430\u043f\u0443\u0441\u043a \u0438\u0437 IDE: \u0432\u044b\u043f\u0443\u0441\u0442\u0438\u0442\u0435 \u043d\u043e\u0432\u044b\u0439 \u0442\u043e\u043a\u0435\u043d \u0432 \u0430\u0434\u043c\u0438\u043d\u043a\u0435 (\u00ab\u0417\u0430\u043f\u0443\u0441\u043a \u043a\u043b\u0438\u0435\u043d\u0442\u0430 \u0438\u0437 IDE\u00bb) \u0438 \u0432\u0441\u0442\u0430\u0432\u044c\u0442\u0435 \u0435\u0433\u043e \u0432 -Drockstar.session."
                     );
                  System.out
                     .println(
                        " \u0427\u0430\u0441\u0442\u0430\u044f \u043f\u0440\u0438\u0447\u0438\u043d\u0430: \u0434\u0432\u0430 \u043a\u043b\u0438\u0435\u043d\u0442\u0430 \u0441 \u043e\u0434\u043d\u0438\u043c \u0430\u043a\u043a\u0430\u0443\u043d\u0442\u043e\u043c \u0438\u0437 \u043e\u0434\u043d\u043e\u0439 \u043f\u0430\u043f\u043a\u0438 run \u2014 \u0432\u0442\u043e\u0440\u043e\u0439 \u0433\u0430\u0441\u0438\u0442 \u0441\u0435\u0441\u0441\u0438\u044e \u043f\u0435\u0440\u0432\u043e\u0433\u043e."
                     );
               }
            } else {
               System.out.println(" Rockstar: \u043d\u0435\u0442 \u0441\u0432\u044f\u0437\u0438 \u0441 \u0441\u0435\u0440\u0432\u0435\u0440\u043e\u043c.");
               System.out
                  .println(
                     " \u041f\u0440\u043e\u0432\u0435\u0440\u044c\u0442\u0435 \u043f\u043e\u0434\u043a\u043b\u044e\u0447\u0435\u043d\u0438\u0435 \u043a \u0438\u043d\u0442\u0435\u0440\u043d\u0435\u0442\u0443 \u0438 \u0437\u0430\u043f\u0443\u0441\u0442\u0438\u0442\u0435 \u0438\u0433\u0440\u0443 \u0437\u0430\u043d\u043e\u0432\u043e."
                  );
            }

            System.out.println("=".repeat(70));
            if (var0) {
               Thread var2 = new Thread(() -> {
                  Thread var0x = new Thread(() -> {
                     I_method_fde807b8(5000L);
                     Runtime.getRuntime().halt(3);
                  }, "Rockstar-Worker-3");
                  var0x.setDaemon(true);
                  var0x.start();
                  System.exit(3);
               }, "Rockstar-Worker-2");
               var2.setDaemon(false);
               var2.start();
            }
         }
      }
   }

   private static void I_method_fde807b8(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         Thread.currentThread().interrupt();
      }
   }

   static final class Nested1_a7650913 {
      byte[] I_field_b47;
      int I_field_49 = 30;
   }
}
