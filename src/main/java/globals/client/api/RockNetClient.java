package globals.client.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import globals.client.RocknetHandler;
import globals.client.auth.ProfileSync;
import globals.client.auth.SessionManager;
import globals.client.crypto.ClientCrypto;
import globals.client.net.PacketCodec;
import globals.client.net.StompConnection;
import globals.shared.proto.Packet;
import globals.shared.proto.Packets;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.Generated;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Request.Builder;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.RockstarClient;

public final class RockNetClient {
   private static final MediaType JSON = MediaType.parse("application/json");
   private static final String PINNED_PUBKEY = "";
   private static volatile boolean serverVerified = false;
   private final String httpBase;
   private final String wsUrl;
   private String activity = "main_menu";
   private Packets.Nested1_242f4d2b gameInfo;
   private volatile RockNetClient.Nested1_fb6c9cf listener;
   private final OkHttpClient http = new OkHttpClient();
   private final ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor(var0 -> {
      Thread var1x = new Thread(var0, "Globals-Net");
      var1x.setDaemon(true);
      return var1x;
   });
   private volatile boolean sessionAuth;
   private volatile String jwt;
   volatile ClientCrypto crypto;
   volatile StompConnection stomp;
   final AtomicBoolean handshakeDone = new AtomicBoolean(false);
   final AtomicInteger reconnectAttempts = new AtomicInteger();
   final AtomicBoolean initialSyncDone = new AtomicBoolean(false);

   public static boolean isServerVerified() {
      return serverVerified;
   }

   private RockNetClient(String var1, int var2, boolean var3) {
      String var4 = var2 == (var3 ? 443 : 80) ? var1 : var1 + ":" + var2;
      this.httpBase = (var3 ? "https://" : "http://") + var4 + "/api/v1";
      this.wsUrl = (var3 ? "wss://" : "ws://") + var4 + "/ws";
      new RocknetHandler();
   }

   public static RockNetClient init(String var0, int var1) {
      return new RockNetClient(var0, var1, false);
   }

   public static RockNetClient init(String var0, int var1, boolean var2) {
      return new RockNetClient(var0, var1, var2);
   }

   public void connect() {
      if (this.sessionAuth) {
         this.exec.submit(this::establish);
      }
   }

   public void loginWithSession() {
      this.sessionAuth = true;
      this.jwt = null;
      ProfileSync.invalidate();
      this.initialSyncDone.set(false);
      this.exec.submit(this::establish);
   }

   public void send(Packet var1) {
      if (!(var1 instanceof Packets.Nested1_8daaedde) && !(var1 instanceof Packets.Nested1_6483a00e)) {
         JsonObject var2 = PacketCodec.toOp(var1);
         if (var2 != null) {
            this.sendSecure(var2);
         }
      } else {
         this.authResult(IiIiIIII_Class81.I_method_f25a980a("rocknet.auth.launcher_only"));
      }
   }

   public synchronized void update(String var1) {
      if (var1 != null && !var1.isBlank()) {
         this.activity = var1;
         this.send(new Packets.Nested1_a4f5c5e3(var1));
      }
   }

   public synchronized void updateVisibility(String var1) {
      if (var1 != null && !var1.isBlank()) {
         this.send(new Packets.Nested1_cff648e6(var1));
      }
   }

   public synchronized void info(String var1, String var2, String var3, String var4, String var5, String var6, String var7) {
      this.gameInfo = new Packets.Nested1_242f4d2b(var1, var2, var3, var4, var5, var6, var7);
      this.send(new Packets.Nested1_bed2a5d4(var1, var2, var3, var4, var5, var6, var7));
   }

   public void close() {
      StompConnection var1 = this.stomp;
      if (var1 != null) {
         var1.disconnect();
      }

      this.handshakeDone.set(false);
      this.initialSyncDone.set(false);
   }

   void sendSecure(JsonObject var1) {
      ClientCrypto var2 = this.crypto;
      StompConnection var3 = this.stomp;
      if (var2 != null && var3 != null && this.handshakeDone.get()) {
         try {
            ClientCrypto.Nested1_11c7cefe var4 = var2.encrypt(var1.toString().getBytes(StandardCharsets.UTF_8));
            JsonObject var5 = new JsonObject();
            var5.addProperty("n", var4.n());
            var5.addProperty("ct", var4.ct());
            var3.sendJson("/app/globals/secure", var5.toString());
         } catch (Exception var6) {
         }
      }
   }

   private void establish() {
      try {
         if (this.sessionAuth) {
            String var1 = SessionManager.accessToken();
            if (var1 == null) {
               this.sessionAuth = false;
               this.authResult("session_expired");
               return;
            }

            this.jwt = var1;
         } else if (this.jwt == null) {
            this.authResult(IiIiIIII_Class81.I_method_f25a980a("rocknet.auth.launcher_only"));
            return;
         }

         ProfileSync.refresh(this.httpBase, this.jwt);
         String var5 = this.httpPost(this.httpBase + "/ws-ticket", "ticket");
         String var2 = this.httpGet(this.httpBase + "/globals/pubkey", "key");
         if (!"".isEmpty() && !"".equals(var2.trim())) {
            serverVerified = false;
            this.authResult("key_mismatch");
            this.scheduleReconnect();
            return;
         }

         serverVerified = !"".isEmpty();
         this.crypto = new ClientCrypto(var2);
         this.handshakeDone.set(false);
         StompConnection var3 = new StompConnection(new StompConnection.Nested1_98864bfe() {
            @Override
            public void onConnected() {
               try {
                  JsonObject var1 = new JsonObject();
                  var1.addProperty("wrapped", RockNetClient.this.crypto.wrapMaster());
                  RockNetClient.this.stomp.sendJson("/app/globals/key-exchange", var1.toString());
                  RockNetClient.this.stomp.subscribe("/user/queue/globals", "sub-globals");
                  RockNetClient.this.stomp.subscribe("/topic/globals.online", "sub-online");
                  RockNetClient.this.handshakeDone.set(true);
                  RockNetClient.this.reconnectAttempts.set(0);
                  JsonObject var2x = new JsonObject();
                  var2x.addProperty("op", "sync");
                  RockNetClient.this.sendSecure(var2x);
                  boolean var3x = RockNetClient.this.initialSyncDone.compareAndSet(false, true);
                  RockNetClient.this.authResult(var3x ? "success" : "reconnected");
               } catch (Exception var4x) {
                  this.onError(var4x);
               }
            }

            @Override
            public void onMessage(String var1, String var2x) {
               RockNetClient.this.handleIncoming(var1, var2x);
            }

            @Override
            public void onClosed() {
               RockNetClient.this.handshakeDone.set(false);
               RockNetClient.this.fireClosed();
               RockNetClient.this.scheduleReconnect();
            }

            @Override
            public void onError(Throwable var1) {
               RockNetClient.this.handshakeDone.set(false);
               RockNetClient.this.fireError(var1);
               RockNetClient.this.scheduleReconnect();
            }
         });
         this.stomp = var3;
         var3.connect(this.wsUrl, var5);
      } catch (Exception var4) {
         logFailure("\u043f\u043e\u0434\u043a\u043b\u044e\u0447\u0435\u043d\u0438\u0435 \u043a " + this.wsUrl, var4);
         this.jwt = null;
         this.authResult("connection_error");
         this.scheduleReconnect();
      }
   }

   private static void logFailure(String var0, Exception var1) {
      System.out
         .println("[Globals] " + var0 + " \u043d\u0435 \u0443\u0434\u0430\u043b\u0441\u044f: " + var1.getClass().getSimpleName() + ": " + var1.getMessage());
   }

   void handleIncoming(String var1, String var2) {
      try {
         JsonObject var3;
         if (var1 != null && var1.contains("globals.online")) {
            var3 = JsonParser.parseString(var2).getAsJsonObject();
         } else {
            JsonObject var4 = JsonParser.parseString(var2).getAsJsonObject();
            byte[] var5 = this.crypto.decrypt(var4.get("n").getAsLong(), var4.get("ct").getAsString());
            if (var5 == null) {
               return;
            }

            var3 = JsonParser.parseString(new String(var5, StandardCharsets.UTF_8)).getAsJsonObject();
         }

         Packet var7 = PacketCodec.fromMessage(var3);
         if (var7 != null && this.listener != null) {
            this.listener.onPacket(var7);
         }
      } catch (Exception var6) {
         RockstarClient.I_field_ab0f6068
            .warn(
               "[Globals] \u043d\u0435 \u0440\u0430\u0437\u043e\u0431\u0440\u0430\u0442\u044c \u0432\u0445\u043e\u0434\u044f\u0449\u0438\u0439 \u043f\u0430\u043a\u0435\u0442 ({})",
               var1,
               var6
            );
      }
   }

   void scheduleReconnect() {
      if (this.sessionAuth) {
         int var1 = Math.min(this.reconnectAttempts.incrementAndGet(), 4);
         long var2 = Math.min(30L, 3L << var1 - 1);
         long var4 = var2 + ThreadLocalRandom.current().nextLong(var2 / 2L + 1L);
         this.exec.schedule(this::establish, var4, TimeUnit.SECONDS);
      }
   }

   void authResult(String var1) {
      if (this.listener != null) {
         this.listener.onPacket(new Packets.Nested1_35ee7690(var1));
      }
   }

   void fireClosed() {
      if (this.listener != null) {
         this.listener.onClosed();
      }
   }

   void fireError(Throwable var1) {
      if (this.listener != null) {
         this.listener.onError((Exception)(var1 instanceof Exception var2 ? var2 : new RuntimeException(var1)));
      }
   }

   private String httpPost(String var1, String var2) throws Exception {
      Request var3 = new Builder().url(var1).addHeader("Authorization", "Bearer " + this.jwt).post(RequestBody.create(JSON, "{}")).build();
      return this.readField(var3, var2);
   }

   private String httpGet(String var1, String var2) throws Exception {
      Request var3 = new Builder().url(var1).addHeader("Authorization", "Bearer " + this.jwt).get().build();
      return this.readField(var3, var2);
   }

   private String readField(Request var1, String var2) throws Exception {
      Response var3 = this.http.newCall(var1).execute();

      String var5;
      try {
         if (!var3.isSuccessful() || var3.body() == null) {
            throw new RuntimeException("HTTP " + var3.code());
         }

         JsonObject var4 = JsonParser.parseString(var3.body().string()).getAsJsonObject();
         var5 = var4.get(var2).getAsString();
      } catch (Throwable var7) {
         if (var3 != null) {
            try {
               var3.close();
            } catch (Throwable var6) {
               var7.addSuppressed(var6);
            }
         }

         throw var7;
      }

      if (var3 != null) {
         var3.close();
      }

      return var5;
   }

   @Generated
   public String getHttpBase() {
      return this.httpBase;
   }

   @Generated
   public String getActivity() {
      return this.activity;
   }

   @Generated
   public Packets.Nested1_242f4d2b getGameInfo() {
      return this.gameInfo;
   }

   @Generated
   public void setListener(RockNetClient.Nested1_fb6c9cf var1) {
      this.listener = var1;
   }

   public interface Nested1_fb6c9cf {
      void onPacket(Packet var1);

      default void onError(Exception var1) {
      }

      default void onClosed() {
      }
   }
}
