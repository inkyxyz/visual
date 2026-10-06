package globals.client.auth;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import globals.client.GlobalsUser;
import globals.client.Information;
import globals.client.api.RockNetClient;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.OkHttpClient.Builder;

public final class SessionManager {
   private static final String ENV_HANDOFF = "ROCKSTAR_SESSION";
   private static final String PROP_HANDOFF = "rockstar.session";
   private static final MediaType JSON = MediaType.parse("application/json");
   private static final OkHttpClient HTTP = new Builder().callTimeout(10L, TimeUnit.SECONDS).build();
   private static final int RESTORE_ATTEMPTS = 3;
   private static final long RESTORE_RETRY_MS = 4000L;
   private static volatile String httpBase;
   private static volatile Session session;
   private static volatile boolean failed;
   private static volatile boolean handoffUsed;
   private static volatile Runnable passwordFallback;
   private static volatile Thread early;

   private SessionManager() {
   }

   public static boolean isAvailable() {
      return failed ? false : session != null || handoffToken() != null || SessionStore.exists();
   }

   public static synchronized void setPasswordFallback(Runnable var0) {
      if (failed) {
         var0.run();
      } else {
         passwordFallback = var0;
      }
   }

   private static synchronized void giveUp() {
      failed = true;
      Runnable var0 = passwordFallback;
      passwordFallback = null;
      if (var0 != null) {
         var0.run();
      }
   }

   public static boolean isActive() {
      return session != null;
   }

   public static String username() {
      Session var0 = session;
      return var0 == null ? null : var0.username();
   }

   public static void bootstrapEarly(String var0) {
      httpBase = var0;
      Thread var1 = new Thread(() -> {
         Session var0x = restoreWithRetry();
         if (var0x == null) {
            giveUp();
         } else {
            apply(var0x);
         }
      }, "Globals-Auth-Early");
      var1.setDaemon(true);
      early = var1;
      var1.start();
   }

   public static void bootstrapAsync(RockNetClient var0) {
      httpBase = var0.getHttpBase();
      Thread var1 = new Thread(() -> {
         Thread var1x = early;
         if (var1x != null) {
            try {
               var1x.join();
            } catch (InterruptedException var3) {
               Thread.currentThread().interrupt();
               return;
            }
         }

         if (session != null) {
            var0.loginWithSession();
         } else if (!failed) {
            Session var2 = restoreWithRetry();
            if (var2 == null) {
               giveUp();
            } else {
               apply(var2);
               var0.loginWithSession();
            }
         }
      }, "Globals-Auth");
      var1.setDaemon(true);
      var1.start();
   }

   public static synchronized String accessToken() {
      Session var0 = session;
      if (var0 == null) {
         return null;
      } else if (var0.access() != null && !var0.stale()) {
         return var0.access();
      } else {
         SessionManager.Nested1_38fd3dff var1 = refresh(var0.refresh());
         if (var1.session() != null) {
            apply(var1.session());
            return var1.session().access();
         } else if (var1.rejected()) {
            clear();
            return null;
         } else {
            return var0.access() != null && System.currentTimeMillis() < var0.expiresAt() ? var0.access() : null;
         }
      }
   }

   public static synchronized void clear() {
      session = null;
      SessionStore.clear();
   }

   private static Session restoreWithRetry() {
      int var0 = 1;

      while (true) {
         SessionManager.Nested1_38fd3dff var1 = restore();
         if (var1.session() != null) {
            return var1.session();
         }

         if (var1.rejected() || var0 >= 3) {
            return null;
         }

         try {
            Thread.sleep(4000L);
         } catch (InterruptedException var3) {
            Thread.currentThread().interrupt();
            return null;
         }

         var0++;
      }
   }

   private static SessionManager.Nested1_38fd3dff restore() {
      boolean var0 = false;
      String var1 = handoffToken();
      if (var1 != null) {
         SessionManager.Nested1_38fd3dff var2 = exchange(var1);
         if (var2.session() != null) {
            handoffUsed = true;
            return var2;
         }

         if (var2.rejected()) {
            handoffUsed = true;
         } else {
            var0 = true;
         }
      }

      Session var4 = SessionStore.load();
      if (var4 != null && var4.refresh() != null) {
         SessionManager.Nested1_38fd3dff var3 = refresh(var4.refresh());
         if (var3.session() != null) {
            return var3;
         }

         if (var3.rejected()) {
            SessionStore.clear();
         } else {
            var0 = true;
         }
      }

      return new SessionManager.Nested1_38fd3dff(null, !var0);
   }

   private static String handoffToken() {
      if (handoffUsed) {
         return null;
      } else {
         String var0 = blankToNull(System.getProperty("rockstar.session"));
         return var0 != null ? var0 : blankToNull(System.getenv("ROCKSTAR_SESSION"));
      }
   }

   private static String blankToNull(String var0) {
      return var0 != null && !var0.isBlank() ? var0 : null;
   }

   private static void apply(Session var0) {
      session = var0;
      SessionStore.save(var0);
      if (var0.username() != null) {
         Information.setPreferUser(new GlobalsUser(var0.username(), null, "Rockstar".toLowerCase()));
      }
   }

   private static SessionManager.Nested1_38fd3dff exchange(String var0) {
      JsonObject var1 = new JsonObject();
      var1.addProperty("token", var0);
      return post("/auth/game/exchange", var1);
   }

   private static SessionManager.Nested1_38fd3dff refresh(String var0) {
      if (var0 == null) {
         return new SessionManager.Nested1_38fd3dff(null, true);
      } else {
         JsonObject var1 = new JsonObject();
         var1.addProperty("refresh", var0);
         return post("/auth/game/refresh", var1);
      }
   }

   private static SessionManager.Nested1_38fd3dff post(String var0, JsonObject var1) {
      String var2 = httpBase;
      if (var2 == null) {
         return new SessionManager.Nested1_38fd3dff(null, false);
      } else {
         Request var3 = new okhttp3.Request.Builder().url(var2 + var0).post(RequestBody.create(JSON, var1.toString())).build();

         try {
            Response var4 = HTTP.newCall(var3).execute();

            SessionManager.Nested1_38fd3dff var8;
            label96: {
               SessionManager.Nested1_38fd3dff var6;
               try {
                  if (var4.isSuccessful() && var4.body() != null) {
                     JsonObject var12 = JsonParser.parseString(var4.body().string()).getAsJsonObject();
                     long var13 = var12.has("expiresIn") ? var12.get("expiresIn").getAsLong() : 900L;
                     var8 = new SessionManager.Nested1_38fd3dff(
                        new Session(
                           var12.get("access").getAsString(),
                           var12.has("refresh") && !var12.get("refresh").isJsonNull() ? var12.get("refresh").getAsString() : null,
                           System.currentTimeMillis() + var13 * 1000L,
                           var12.has("username") ? var12.get("username").getAsString() : null,
                           var12.has("uid") ? var12.get("uid").getAsInt() : null,
                           var12.has("role") ? var12.get("role").getAsString() : null
                        ),
                        false
                     );
                     break label96;
                  }

                  boolean var5 = var4.code() >= 400 && var4.code() < 500;
                  var6 = new SessionManager.Nested1_38fd3dff(null, var5);
               } catch (Throwable var10) {
                  if (var4 != null) {
                     try {
                        var4.close();
                     } catch (Throwable var9) {
                        var10.addSuppressed(var9);
                     }
                  }

                  throw var10;
               }

               if (var4 != null) {
                  var4.close();
               }

               return var6;
            }

            if (var4 != null) {
               var4.close();
            }

            return var8;
         } catch (Exception var11) {
            return new SessionManager.Nested1_38fd3dff(null, false);
         }
      }
   }

   static final class Nested1_38fd3dff {
      private final Session session;
      private final boolean rejected;

      Nested1_38fd3dff(Session var1, boolean var2) {
         this.session = var1;
         this.rejected = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_38fd3dff[session=" + this.session() + ", rejected=" + this.rejected() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.session());
         result = 31 * result + java.util.Objects.hashCode(this.rejected());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         SessionManager.Nested1_38fd3dff other = (SessionManager.Nested1_38fd3dff) var1;
         return java.util.Objects.equals(this.session(), other.session())
            && java.util.Objects.equals(this.rejected(), other.rejected());
      }

      public Session session() {
         return this.session;
      }

      public boolean rejected() {
         return this.rejected;
      }
   }
}
