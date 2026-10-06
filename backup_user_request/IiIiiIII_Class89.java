package rockstar.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.HexFormat;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Supplier;

public final class IiIiiIII_Class89 {
   public static final String I_field_523beb0a = "2025-06-18";
   private static final Set<String> I_field_a56a8dc5 = Set.of("2025-06-18", "2025-03-26", "2024-11-05");
   public static final int I_field_49 = 8420;
   private static final int i_field_49 = 10;
   private static final int II_field_49 = 8388608;
   private static final long I_field_4a = 10000L;
   private static final Gson I_field_fbd77e28 = new GsonBuilder().disableHtmlEscaping().create();
   private static IiIiiIII_Class89 I_field_75e2e761;
   private ServerSocket I_field_fe985f2;
   private ExecutorService I_field_331d0885;
   private volatile boolean I_field_5a;
   private volatile int Ii_field_49;
   private volatile String i_field_523beb0a;

   private IiIiiIII_Class89() {
   }

   public static IiIiiIII_Class89 I_method_fc295fcb() {
      if (I_field_75e2e761 == null) {
         I_field_75e2e761 = new IiIiiIII_Class89();
      }

      return I_field_75e2e761;
   }

   public boolean I_method_3d95f4b0() {
      return this.I_field_5a;
   }

   public int I_method_3d95f49f() {
      return this.Ii_field_49;
   }

   public String I_method_65ce6d74() {
      return this.i_field_523beb0a;
   }

   public String i_method_f8ed1d94() {
      return "http://127.0.0.1:" + this.Ii_field_49 + "/mcp";
   }

   public static File I_method_84ddc7e1() {
      return new File(IiIIiIII_Class73.I_field_3a58077, "mcp.json");
   }

   public void I_method_3d95f4ac() {
      Thread var1 = new Thread(() -> {
         try {
            this.i_method_3da4808c();
         } catch (Exception var2) {
            RockstarClient.I_field_ab0f6068.error("[MCP] \u0441\u0435\u0440\u0432\u0435\u0440 \u043d\u0435 \u043f\u043e\u0434\u043d\u044f\u043b\u0441\u044f", var2);
         }
      }, "Rockstar-MCP-Boot");
      var1.setDaemon(true);
      var1.start();
   }

   public synchronized void i_method_3da4808c() throws IOException {
      if (!this.I_field_5a) {
         this.i_field_523beb0a = this.Ii_method_ec77dd2b();
         IOException var1 = null;

         for (int var2 = 0; var2 < 10; var2++) {
            try {
               this.I_field_fe985f2 = new ServerSocket(8420 + var2, 16, InetAddress.getLoopbackAddress());
               this.Ii_field_49 = 8420 + var2;
               var1 = null;
               break;
            } catch (IOException var4) {
               var1 = var4;
            }
         }

         if (this.I_field_fe985f2 == null) {
            throw var1 == null
               ? new IOException("\u043d\u0435\u0442 \u0441\u0432\u043e\u0431\u043e\u0434\u043d\u043e\u0433\u043e \u043f\u043e\u0440\u0442\u0430")
               : var1;
         } else {
            this.I_field_5a = true;
            this.I_field_331d0885 = Executors.newCachedThreadPool(var0 -> {
               Thread var1x = new Thread(var0, "Rockstar-MCP");
               var1x.setDaemon(true);
               return var1x;
            });
            Thread var5 = new Thread(this::iI_method_76fa8855, "Rockstar-MCP-Accept");
            var5.setDaemon(true);
            var5.start();
            this.ii_method_77091435();
            RockstarClient.I_field_ab0f6068
               .info(
                  "[MCP] \u0441\u043b\u0443\u0448\u0430\u044e {} (\u0442\u043e\u043a\u0435\u043d \u0432 {})",
                  this.i_method_f8ed1d94(),
                  I_method_84ddc7e1().getAbsolutePath()
               );
         }
      }
   }

   public synchronized void II_method_75379835() {
      this.I_field_5a = false;

      try {
         if (this.I_field_fe985f2 != null) {
            this.I_field_fe985f2.close();
         }
      } catch (IOException var2) {
      }

      this.I_field_fe985f2 = null;
      if (this.I_field_331d0885 != null) {
         this.I_field_331d0885.shutdownNow();
         this.I_field_331d0885 = null;
      }

      this.Ii_field_49 = 0;
   }

   public synchronized void Ii_method_75462415() throws IOException {
      this.II_method_75379835();
      this.i_method_3da4808c();
   }

   public synchronized String II_method_59592d0b() {
      this.i_field_523beb0a = HexFormat.of().formatHex(I_method_7528a1b1());
      this.ii_method_77091435();
      return this.i_field_523beb0a;
   }

   private void iI_method_76fa8855() {
      while (this.I_field_5a) {
         try {
            Socket var1 = this.I_field_fe985f2.accept();
            if (!var1.getInetAddress().isLoopbackAddress()) {
               var1.close();
            } else {
               this.I_field_331d0885.submit(() -> this.I_method_c870c303(var1));
            }
         } catch (IOException var2) {
            if (this.I_field_5a) {
               RockstarClient.I_field_ab0f6068.warn("[MCP] accept: {}", var2.toString());
            }
         }
      }
   }

   private void I_method_c870c303(Socket var1) {
      try {
         Socket var2 = var1;

         label61: {
            try {
               var1.setSoTimeout(300000);
               var1.setTcpNoDelay(true);
               BufferedInputStream var3 = new BufferedInputStream(var1.getInputStream());
               BufferedOutputStream var4 = new BufferedOutputStream(var1.getOutputStream());

               while (this.I_field_5a) {
                  IiIiiIII_Class89.Nested1_42690913 var5 = this.I_method_f8126e0b(var3);
                  if (var5 == null || !this.I_method_92946ade(var5, var4)) {
                     break label61;
                  }
               }
            } catch (Throwable var7) {
               if (var1 != null) {
                  try {
                     var2.close();
                  } catch (Throwable var6) {
                     var7.addSuppressed(var6);
                  }
               }

               throw var7;
            }

            if (var1 != null) {
               var1.close();
            }

            return;
         }

         if (var1 != null) {
            var1.close();
         }

         return;
      } catch (IOException var8) {
      } catch (Exception var9) {
         RockstarClient.I_field_ab0f6068.error("[MCP] \u0441\u043e\u0435\u0434\u0438\u043d\u0435\u043d\u0438\u0435 \u0443\u043f\u0430\u043b\u043e", var9);
      }
   }

   private boolean I_method_92946ade(IiIiiIII_Class89.Nested1_42690913 var1, OutputStream var2) throws IOException {
      boolean var3 = !"close".equalsIgnoreCase(var1.I_method_af09487c().get("connection"));
      String var4 = var1.i_method_a84df519();
      int var5 = var4.indexOf(63);
      String var6 = var5 < 0 ? "" : var4.substring(var5 + 1);
      if (var5 >= 0) {
         var4 = var4.substring(0, var5);
      }

      if ("OPTIONS".equals(var1.I_method_152f44f9())) {
         this.I_method_70463cde(var2, 204, "text/plain", new byte[0], var3);
         return var3;
      } else if (!"/health".equals(var4)) {
         if (!"/mcp".equals(var4) && !"/".equals(var4)) {
            this.I_method_70463cde(var2, 404, "text/plain", "not found".getBytes(StandardCharsets.UTF_8), var3);
            return var3;
         } else if (!this.I_method_5de94ab6(var1, var6)) {
            this.I_method_70463cde(var2, 401, "text/plain", "unauthorized".getBytes(StandardCharsets.UTF_8), false);
            return false;
         } else if (!"POST".equals(var1.I_method_152f44f9())) {
            this.I_method_70463cde(var2, 405, "text/plain", "use POST".getBytes(StandardCharsets.UTF_8), var3);
            return var3;
         } else {
            JsonElement var10;
            try {
               var10 = this.I_method_ff145a96(JsonParser.parseString(new String(var1.I_method_676b2336(), StandardCharsets.UTF_8)));
            } catch (Exception var9) {
               var10 = this.I_method_8868d09(null, -32700, "\u043d\u0435 \u0440\u0430\u0437\u043e\u0431\u0440\u0430\u043b JSON: " + var9.getMessage());
            }

            if (var10 == null) {
               this.I_method_70463cde(var2, 202, "text/plain", new byte[0], var3);
               return var3;
            } else {
               this.I_method_626b7830(var2, 200, var10, var3);
               return var3;
            }
         }
      } else {
         JsonObject var7 = new JsonObject();
         var7.addProperty("ok", true);
         var7.addProperty("name", "Rockstar");
         var7.addProperty("version", "2.1");
         var7.addProperty("protocol", "2025-06-18");
         var7.addProperty("port", this.Ii_field_49);
         var7.addProperty("inGame", iIIiIIiIi_Class294.I_field_3a9bda27.player != null && iIIiIIiIi_Class294.I_field_3a9bda27.world != null);
         this.I_method_626b7830(var2, 200, var7, var3);
         return var3;
      }
   }

   private boolean I_method_5de94ab6(IiIiiIII_Class89.Nested1_42690913 var1, String var2) {
      String var3 = this.i_field_523beb0a;
      if (var3 != null && !var3.isBlank()) {
         String var4 = var1.I_method_af09487c().get("authorization");
         if (var4 != null) {
            String var5 = var4.trim();
            if (var5.regionMatches(true, 0, "bearer ", 0, 7)) {
               var5 = var5.substring(7).trim();
            }

            if (var3.equals(var5)) {
               return true;
            }
         }

         for (String var8 : var2.split("&")) {
            int var9 = var8.indexOf(61);
            if (var9 > 0 && "token".equals(var8.substring(0, var9)) && var3.equals(var8.substring(var9 + 1))) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }

   private JsonElement I_method_ff145a96(JsonElement var1) {
      if (var1 != null && var1.isJsonArray()) {
         JsonArray var2 = new JsonArray();

         for (JsonElement var4 : var1.getAsJsonArray()) {
            JsonElement var5 = this.i_method_4dc86ab6(var4);
            if (var5 != null) {
               var2.add(var5);
            }
         }

         return var2.isEmpty() ? null : var2;
      } else {
         return this.i_method_4dc86ab6(var1);
      }
   }

   private JsonElement i_method_4dc86ab6(JsonElement var1) {
      if (var1 != null && var1.isJsonObject()) {
         JsonObject var2 = var1.getAsJsonObject();
         JsonElement var3 = var2.get("id");
         String var4 = var2.has("method") ? var2.get("method").getAsString() : "";
         JsonObject var5 = var2.has("params") && var2.get("params").isJsonObject() ? var2.getAsJsonObject("params") : new JsonObject();

         try {
            JsonObject var6 = this.I_method_d07cf7e0(var4, var5);
            if (var3 != null && !var3.isJsonNull()) {
               JsonObject var7 = new JsonObject();
               var7.addProperty("jsonrpc", "2.0");
               var7.add("id", var3);
               var7.add("result", var6 == null ? new JsonObject() : var6);
               return var7;
            } else {
               return null;
            }
         } catch (IiIiiIII_Class89.Nested1_426908f3 var8) {
            return this.I_method_8868d09(var3, var8.I_method_1f4f9a9a(), var8.getMessage());
         } catch (Exception var9) {
            RockstarClient.I_field_ab0f6068.error("[MCP] {} \u0443\u043f\u0430\u043b", var4, var9);
            return this.I_method_8868d09(var3, -32603, String.valueOf(var9));
         }
      } else {
         return this.I_method_8868d09(null, -32600, "\u043e\u0436\u0438\u0434\u0430\u043b\u0441\u044f \u043e\u0431\u044a\u0435\u043a\u0442 JSON-RPC");
      }
   }

   private JsonObject I_method_d07cf7e0(String var1, JsonObject var2) {
      switch (var1) {
         case "initialize":
            String var12 = var2.has("protocolVersion") ? var2.get("protocolVersion").getAsString() : "2025-06-18";
            JsonObject var13 = new JsonObject();
            JsonObject var7 = new JsonObject();
            var7.addProperty("listChanged", false);
            var13.add("tools", var7);
            JsonObject var8 = new JsonObject();
            var8.addProperty("name", "rockstar");
            var8.addProperty("title", "Rockstar 2.1");
            var8.addProperty("version", "2.1");
            JsonObject var9 = new JsonObject();
            var9.addProperty("protocolVersion", I_field_a56a8dc5.contains(var12) ? var12 : "2025-06-18");
            var9.add("capabilities", var13);
            var9.add("serverInfo", var8);
            var9.addProperty(
               "instructions",
               "Rockstar \u2014 \u0447\u0438\u0442-\u043a\u043b\u0438\u0435\u043d\u0442 Minecraft. \u0427\u0435\u0440\u0435\u0437 \u044d\u0442\u0438 \u0438\u043d\u0441\u0442\u0440\u0443\u043c\u0435\u043d\u0442\u044b \u0432\u0438\u0434\u043d\u043e \u0441\u043e\u0441\u0442\u043e\u044f\u043d\u0438\u0435 \u0438\u0433\u0440\u044b \u0438 \u043a\u043b\u0438\u0435\u043d\u0442\u0430 \u0438 \u043c\u043e\u0436\u043d\u043e \u0438\u043c \u0443\u043f\u0440\u0430\u0432\u043b\u044f\u0442\u044c.\n\u041f\u043e\u0440\u044f\u0434\u043e\u043a \u0440\u0430\u0431\u043e\u0442\u044b: game_state \u2014 \u0447\u0442\u043e \u043f\u0440\u043e\u0438\u0441\u0445\u043e\u0434\u0438\u0442; screenshot \u2014 \u043a\u0430\u043a \u044d\u0442\u043e \u0432\u044b\u0433\u043b\u044f\u0434\u0438\u0442; mouse/keyboard \u2014 \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u044f \u043f\u043e \u043a\u0430\u0440\u0442\u0438\u043d\u043a\u0435.\n\u041a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u044b \u0434\u043b\u044f mouse \u043f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e \u0441\u0447\u0438\u0442\u0430\u044e\u0442\u0441\u044f \u0432 \u043f\u0438\u043a\u0441\u0435\u043b\u044f\u0445 \u043f\u043e\u0441\u043b\u0435\u0434\u043d\u0435\u0433\u043e \u0441\u043a\u0440\u0438\u043d\u0448\u043e\u0442\u0430, \u043f\u043e\u044d\u0442\u043e\u043c\u0443 \u043a\u043b\u0438\u043a\u0430\u0442\u044c \u043d\u0443\u0436\u043d\u043e \u043f\u043e \u0442\u043e\u043c\u0443, \u0447\u0442\u043e \u0432\u0438\u0434\u043d\u043e \u043d\u0430 \u043d\u0451\u043c (space \u043c\u0435\u043d\u044f\u0435\u0442 \u0441\u0438\u0441\u0442\u0435\u043c\u0443 \u043a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442).\n\u041c\u043e\u0434\u0443\u043b\u0438 \u043c\u0435\u043d\u044f\u044e\u0442\u0441\u044f \u0447\u0435\u0440\u0435\u0437 module_control \u0438 setting_set: \u0438\u043c\u0435\u043d\u0430 \u043d\u0430\u0441\u0442\u0440\u043e\u0435\u043a \u0431\u0435\u0440\u0443\u0442\u0441\u044f \u0438\u0437 module_info.\n\u0421\u043a\u0440\u0438\u043f\u0442\u044b \u043a\u043b\u0438\u0435\u043d\u0442\u0430 \u2014 Python \u043f\u043e \u043d\u0430\u0448\u0435\u043c\u0443 API, \u0438 \u043f\u043e \u043f\u0430\u043c\u044f\u0442\u0438 \u043e\u043d \u043d\u0435 \u043f\u0438\u0448\u0435\u0442\u0441\u044f: \u043f\u0435\u0440\u0435\u0434 scripts write \u043e\u0431\u044f\u0437\u0430\u0442\u0435\u043b\u044c\u043d\u043e \u043f\u0440\u043e\u0447\u0438\u0442\u0430\u0439 script_api (\u0440\u0430\u0437\u0434\u0435\u043b basics, \u0434\u0430\u043b\u044c\u0448\u0435 \u043f\u043e \u0435\u0433\u043e \u043a\u0430\u0440\u0442\u0435 \u0440\u0430\u0437\u0434\u0435\u043b\u043e\u0432)."
            );
            return var9;
         case "ping":
            return new JsonObject();
         case "tools/list":
            return IiIiiIiI_Class91.I_method_542796f6();
         case "tools/call":
            String var11 = var2.has("name") ? var2.get("name").getAsString() : "";
            JsonObject var6 = var2.has("arguments") && var2.get("arguments").isJsonObject() ? var2.getAsJsonObject("arguments") : new JsonObject();
            return IiIiiIiI_Class91.I_method_8ee9b3c0(var11, var6);
         case "resources/list":
         case "resources/templates/list":
            JsonObject var10 = new JsonObject();
            var10.add("resources", new JsonArray());
            return var10;
         case "prompts/list":
            JsonObject var5 = new JsonObject();
            var5.add("prompts", new JsonArray());
            return var5;
         default:
            if (var1.startsWith("notifications/")) {
               return new JsonObject();
            } else {
               throw new IiIiiIII_Class89.Nested1_426908f3(
                  -32601, "\u043d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u044b\u0439 \u043c\u0435\u0442\u043e\u0434: " + var1
               );
            }
      }
   }

   private JsonElement I_method_8868d09(JsonElement var1, int var2, String var3) {
      JsonObject var4 = new JsonObject();
      var4.addProperty("code", var2);
      var4.addProperty("message", var3 == null ? "\u043e\u0448\u0438\u0431\u043a\u0430" : var3);
      JsonObject var5 = new JsonObject();
      var5.addProperty("jsonrpc", "2.0");
      var5.add("id", (JsonElement)(var1 == null ? JsonNull.INSTANCE : var1));
      var5.add("error", var4);
      return var5;
   }

   public static <T> T I_method_d4c57540(Supplier<T> var0) {
      if (iIIiIIiIi_Class294.I_field_3a9bda27.isOnThread()) {
         return (T)var0.get();
      } else {
         CompletableFuture var1 = new CompletableFuture();
         iIIiIIiIi_Class294.I_field_3a9bda27.execute(() -> {
            try {
               var1.complete(var0.get());
            } catch (Throwable var3x) {
               var1.completeExceptionally(var3x);
            }
         });

         try {
            return (T)var1.get(10000L, TimeUnit.MILLISECONDS);
         } catch (TimeoutException var5) {
            throw new IiIiiIII_Class89.Nested1_426908f3(
               -32603,
               "\u0438\u0433\u0440\u0430 \u043d\u0435 \u043e\u0442\u0432\u0435\u0442\u0438\u043b\u0430 \u0437\u0430 10 \u0441 \u2014 \u043e\u043d\u0430 \u0433\u0440\u0443\u0437\u0438\u0442\u0441\u044f \u0438\u043b\u0438 \u0432\u0438\u0441\u0438\u0442"
            );
         } catch (Exception var6) {
            Object var3 = var6.getCause() == null ? var6 : var6.getCause();
            if (var3 instanceof IiIiiIII_Class89.Nested1_426908f3 var4) {
               throw var4;
            } else {
               throw new IiIiiIII_Class89.Nested1_426908f3(-32603, String.valueOf(var3));
            }
         }
      }
   }

   private String Ii_method_ec77dd2b() {
      File var1 = I_method_84ddc7e1();
      if (var1.isFile()) {
         try {
            JsonElement var2 = JsonParser.parseString(Files.readString(var1.toPath()));
            if (var2.isJsonObject()) {
               JsonObject var3 = var2.getAsJsonObject();
               if (var3.has("token") && !var3.get("token").getAsString().isBlank()) {
                  return var3.get("token").getAsString();
               }
            }
         } catch (Exception var4) {
         }
      }

      return HexFormat.of().formatHex(I_method_7528a1b1());
   }

   private static byte[] I_method_7528a1b1() {
      byte[] var0 = new byte[24];
      new SecureRandom().nextBytes(var0);
      return var0;
   }

   private void ii_method_77091435() {
      JsonObject var1 = new JsonObject();
      var1.addProperty("url", this.i_method_f8ed1d94());
      var1.addProperty("port", this.Ii_field_49);
      var1.addProperty("token", this.i_field_523beb0a);
      var1.addProperty("protocol", "2025-06-18");
      var1.addProperty("client", "Rockstar 2.1");

      try {
         IiIIiIII_Class73.I_method_3b2973c6(I_method_84ddc7e1(), var1);
      } catch (IOException var3) {
         RockstarClient.I_field_ab0f6068.warn("[MCP] \u043d\u0435 \u0437\u0430\u043f\u0438\u0441\u0430\u043b {}: {}", I_method_84ddc7e1(), var3.toString());
      }
   }

   private IiIiiIII_Class89.Nested1_42690913 I_method_f8126e0b(InputStream var1) throws IOException {
      String var2 = I_method_d02b5619(var1);
      if (var2 != null && !var2.isEmpty()) {
         String[] var3 = var2.split(" ");
         if (var3.length < 2) {
            return null;
         } else {
            HashMap var4 = new HashMap();

            String var5;
            while ((var5 = I_method_d02b5619(var1)) != null && !var5.isEmpty()) {
               int var6 = var5.indexOf(58);
               if (var6 > 0) {
                  var4.put(var5.substring(0, var6).trim().toLowerCase(Locale.ROOT), var5.substring(var6 + 1).trim());
               }
            }

            int var9 = 0;

            try {
                 var9 = Integer.parseInt((String)var4.getOrDefault("content-length", "0"));
            } catch (NumberFormatException var8) {
            }

            if (var9 >= 0 && var9 <= 8388608) {
               byte[] var7 = var1.readNBytes(var9);
               return var7.length < var9 ? null : new IiIiiIII_Class89.Nested1_42690913(var3[0], var3[1], var4, var7);
            } else {
               throw new IOException(
                  "\u0442\u0435\u043b\u043e \u0437\u0430\u043f\u0440\u043e\u0441\u0430 "
                     + var9
                     + " \u0431\u0430\u0439\u0442 \u2014 \u0441\u043b\u0438\u0448\u043a\u043e\u043c \u0431\u043e\u043b\u044c\u0448\u043e\u0435"
               );
            }
         }
      } else {
         return null;
      }
   }

   private static String I_method_d02b5619(InputStream var0) throws IOException {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream(128);

      int var2;
      while ((var2 = var0.read()) != -1) {
         if (var2 == 10) {
            String var3 = var1.toString(StandardCharsets.UTF_8);
            return var3.endsWith("\r") ? var3.substring(0, var3.length() - 1) : var3;
         }

         var1.write(var2);
         if (var1.size() > 8192) {
            throw new IOException(
               "\u0441\u043b\u0438\u0448\u043a\u043e\u043c \u0434\u043b\u0438\u043d\u043d\u044b\u0439 \u0437\u0430\u0433\u043e\u043b\u043e\u0432\u043e\u043a"
            );
         }
      }

      return var1.size() == 0 ? null : var1.toString(StandardCharsets.UTF_8);
   }

   private void I_method_626b7830(OutputStream var1, int var2, JsonElement var3, boolean var4) throws IOException {
      this.I_method_70463cde(var1, var2, "application/json; charset=utf-8", I_field_fbd77e28.toJson(var3).getBytes(StandardCharsets.UTF_8), var4);
   }

   private void I_method_70463cde(OutputStream var1, int var2, String var3, byte[] var4, boolean var5) throws IOException {
      String var6 = "HTTP/1.1 "
         + var2
         + " "
         + I_method_957e29a9(var2)
         + "\r\nContent-Type: "
         + var3
         + "\r\nContent-Length: "
         + var4.length
         + "\r\nConnection: "
         + (var5 ? "keep-alive" : "close")
         + "\r\n\r\n";
      var1.write(var6.getBytes(StandardCharsets.UTF_8));
      var1.write(var4);
      var1.flush();
   }

   private static String I_method_957e29a9(int var0) {
      return switch (var0) {
         case 202 -> "Accepted";
         case 204 -> "No Content";
         case 401 -> "Unauthorized";
         case 404 -> "Not Found";
         case 405 -> "Method Not Allowed";
         default -> "OK";
      };
   }

   public static final class Nested1_426908f3 extends RuntimeException {
      private final int I_field_49;

      public Nested1_426908f3(String var1) {
         this(-32602, var1);
      }

      public Nested1_426908f3(int var1, String var2) {
         super(var2);
         this.I_field_49 = var1;
      }

      public int I_method_1f4f9a9a() {
         return this.I_field_49;
      }
   }

   static final class Nested1_42690913 {
      private final String I_field_523beb0a;
      private final String i_field_523beb0a;
      private final Map<String, String> I_field_a567c40b;
      private final byte[] I_field_b47;

      Nested1_42690913(String var1, String var2, Map<String, String> var3, byte[] var4) {
         this.I_field_523beb0a = var1;
         this.i_field_523beb0a = var2;
         this.I_field_a567c40b = var3;
         this.I_field_b47 = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_42690913[method=" + this.I_field_523beb0a + ", path=" + this.i_field_523beb0a + ", headers=" + this.I_field_a567c40b + ", body=" + this.I_field_b47 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_a567c40b);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_b47);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiIiiIII_Class89.Nested1_42690913 other = (IiIiiIII_Class89.Nested1_42690913) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.i_field_523beb0a, other.i_field_523beb0a)
            && java.util.Objects.equals(this.I_field_a567c40b, other.I_field_a567c40b)
            && java.util.Objects.equals(this.I_field_b47, other.I_field_b47);
      }

      public String I_method_152f44f9() {
         return this.I_field_523beb0a;
      }

      public String i_method_a84df519() {
         return this.i_field_523beb0a;
      }

      public Map<String, String> I_method_af09487c() {
         return this.I_field_a567c40b;
      }

      public byte[] I_method_676b2336() {
         return this.I_field_b47;
      }
   }
}
