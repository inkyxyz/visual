package rockstar.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

public final class IiIiiIiI_Class91 {
   public static final String I_field_523beb0a = "Rockstar \u2014 \u0447\u0438\u0442-\u043a\u043b\u0438\u0435\u043d\u0442 Minecraft. \u0427\u0435\u0440\u0435\u0437 \u044d\u0442\u0438 \u0438\u043d\u0441\u0442\u0440\u0443\u043c\u0435\u043d\u0442\u044b \u0432\u0438\u0434\u043d\u043e \u0441\u043e\u0441\u0442\u043e\u044f\u043d\u0438\u0435 \u0438\u0433\u0440\u044b \u0438 \u043a\u043b\u0438\u0435\u043d\u0442\u0430 \u0438 \u043c\u043e\u0436\u043d\u043e \u0438\u043c \u0443\u043f\u0440\u0430\u0432\u043b\u044f\u0442\u044c.\n\u041f\u043e\u0440\u044f\u0434\u043e\u043a \u0440\u0430\u0431\u043e\u0442\u044b: game_state \u2014 \u0447\u0442\u043e \u043f\u0440\u043e\u0438\u0441\u0445\u043e\u0434\u0438\u0442; screenshot \u2014 \u043a\u0430\u043a \u044d\u0442\u043e \u0432\u044b\u0433\u043b\u044f\u0434\u0438\u0442; mouse/keyboard \u2014 \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u044f \u043f\u043e \u043a\u0430\u0440\u0442\u0438\u043d\u043a\u0435.\n\u041a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u044b \u0434\u043b\u044f mouse \u043f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e \u0441\u0447\u0438\u0442\u0430\u044e\u0442\u0441\u044f \u0432 \u043f\u0438\u043a\u0441\u0435\u043b\u044f\u0445 \u043f\u043e\u0441\u043b\u0435\u0434\u043d\u0435\u0433\u043e \u0441\u043a\u0440\u0438\u043d\u0448\u043e\u0442\u0430, \u043f\u043e\u044d\u0442\u043e\u043c\u0443 \u043a\u043b\u0438\u043a\u0430\u0442\u044c \u043d\u0443\u0436\u043d\u043e \u043f\u043e \u0442\u043e\u043c\u0443, \u0447\u0442\u043e \u0432\u0438\u0434\u043d\u043e \u043d\u0430 \u043d\u0451\u043c (space \u043c\u0435\u043d\u044f\u0435\u0442 \u0441\u0438\u0441\u0442\u0435\u043c\u0443 \u043a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442).\n\u041c\u043e\u0434\u0443\u043b\u0438 \u043c\u0435\u043d\u044f\u044e\u0442\u0441\u044f \u0447\u0435\u0440\u0435\u0437 module_control \u0438 setting_set: \u0438\u043c\u0435\u043d\u0430 \u043d\u0430\u0441\u0442\u0440\u043e\u0435\u043a \u0431\u0435\u0440\u0443\u0442\u0441\u044f \u0438\u0437 module_info.\n\u0421\u043a\u0440\u0438\u043f\u0442\u044b \u043a\u043b\u0438\u0435\u043d\u0442\u0430 \u2014 Python \u043f\u043e \u043d\u0430\u0448\u0435\u043c\u0443 API, \u0438 \u043f\u043e \u043f\u0430\u043c\u044f\u0442\u0438 \u043e\u043d \u043d\u0435 \u043f\u0438\u0448\u0435\u0442\u0441\u044f: \u043f\u0435\u0440\u0435\u0434 scripts write \u043e\u0431\u044f\u0437\u0430\u0442\u0435\u043b\u044c\u043d\u043e \u043f\u0440\u043e\u0447\u0438\u0442\u0430\u0439 script_api (\u0440\u0430\u0437\u0434\u0435\u043b basics, \u0434\u0430\u043b\u044c\u0448\u0435 \u043f\u043e \u0435\u0433\u043e \u043a\u0430\u0440\u0442\u0435 \u0440\u0430\u0437\u0434\u0435\u043b\u043e\u0432).";
   private static final Gson I_field_fbd77e28 = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
   private static final Map<String, IiIiiIiI_Class91.Nested1_427794f3> I_field_a567c40b = new LinkedHashMap<>();

   private IiIiiIiI_Class91() {
   }

   public static JsonObject I_method_542796f6() {
      JsonArray var0 = new JsonArray();

      for (IiIiiIiI_Class91.Nested1_427794f3 var2 : I_field_a567c40b.values()) {
         JsonObject var3 = new JsonObject();
         var3.addProperty("name", var2.I_method_5059a8d9());
         var3.addProperty("description", var2.i_method_e37858f9());
         var3.add("inputSchema", var2.I_method_9c67143b());
         var0.add(var3);
      }

      JsonObject var4 = new JsonObject();
      var4.add("tools", var0);
      return var4;
   }

   public static JsonObject I_method_8ee9b3c0(String var0, JsonObject var1) {
      IiIiiIiI_Class91.Nested1_427794f3 var2 = I_field_a567c40b.get(var0);
      if (var2 == null) {
         return I_method_418a84(
            "\u043d\u0435\u0442 \u0438\u043d\u0441\u0442\u0440\u0443\u043c\u0435\u043d\u0442\u0430 \""
               + var0
               + "\"; \u0435\u0441\u0442\u044c: "
               + String.join(", ", I_field_a567c40b.keySet()),
            true
         );
      } else {
         try {
            Object var3 = var2.I_method_de788eab()
               ? IiIiiIII_Class89.I_method_d4c57540(() -> var2.I_method_682bf129().apply(var1))
               : var2.I_method_682bf129().apply(var1);
            return I_method_8ba989a(var3);
         } catch (IiIiiIII_Class89.Nested1_426908f3 var4) {
            return I_method_418a84(var4.getMessage(), true);
         } catch (Exception var5) {
            RockstarClient.I_field_ab0f6068.error("[MCP] \u0438\u043d\u0441\u0442\u0440\u0443\u043c\u0435\u043d\u0442 {} \u0443\u043f\u0430\u043b", var0, var5);
            return I_method_418a84("\u0438\u043d\u0441\u0442\u0440\u0443\u043c\u0435\u043d\u0442 \u0443\u043f\u0430\u043b: " + var5, true);
         }
      }
   }

   private static JsonObject I_method_8ba989a(Object var0) {
      if (var0 instanceof IiIiIiii_Class88.Nested1_d9fe933 var6) {
         JsonObject var2 = new JsonObject();
         var2.addProperty("type", "image");
         var2.addProperty("data", Base64.getEncoder().encodeToString(var6.I_method_82c16b56()));
         var2.addProperty("mimeType", var6.I_method_a0314d19());
         JsonObject var3 = new JsonObject();
         var3.addProperty("imageWidth", var6.I_method_909ae25a());
         var3.addProperty("imageHeight", var6.i_method_90a96e3a());
         var3.addProperty("frameWidth", var6.II_method_82d061cd());
         var3.addProperty("frameHeight", var6.Ii_method_82deedad());
         var3.addProperty(
            "hint",
            "\u043a\u043b\u0438\u043a\u0438 \u043f\u043e \u044d\u0442\u043e\u043c\u0443 \u043a\u0430\u0434\u0440\u0443: mouse \u0441\u043e space=image (\u043f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e)"
         );
         JsonArray var4 = new JsonArray();
         var4.add(var2);
         var4.add(I_method_bf9299ec(I_field_fbd77e28.toJson(var3)));
         JsonObject var5 = new JsonObject();
         var5.add("content", var4);
         return var5;
      } else {
         return var0 instanceof JsonElement var1 ? I_method_418a84(I_field_fbd77e28.toJson(var1), false) : I_method_418a84(String.valueOf(var0), false);
      }
   }

   private static JsonObject I_method_418a84(String var0, boolean var1) {
      JsonArray var2 = new JsonArray();
      var2.add(I_method_bf9299ec(var0));
      JsonObject var3 = new JsonObject();
      var3.add("content", var2);
      if (var1) {
         var3.addProperty("isError", true);
      }

      return var3;
   }

   private static JsonObject I_method_bf9299ec(String var0) {
      JsonObject var1 = new JsonObject();
      var1.addProperty("type", "text");
      var1.addProperty("text", var0);
      return var1;
   }

   private static void I_method_3d38e00a(String var0, String var1, JsonObject var2, boolean var3, Function<JsonObject, Object> var4) {
      I_field_a567c40b.put(var0, new IiIiiIiI_Class91.Nested1_427794f3(var0, var1, var2, var3, var4));
   }

   private static String I_method_66c8fa94(JsonObject var0, String var1, String var2) {
      JsonElement var3 = var0.get(var1);
      return var3 != null && !var3.isJsonNull() ? var3.getAsString() : var2;
   }

   private static double I_method_183b022a(JsonObject var0, String var1, double var2) {
      JsonElement var4 = var0.get(var1);
      if (var4 != null && !var4.isJsonNull()) {
         try {
            return var4.getAsDouble();
         } catch (Exception var6) {
            throw new IiIiiIII_Class89.Nested1_426908f3(
               var1 + " \u0434\u043e\u043b\u0436\u0435\u043d \u0431\u044b\u0442\u044c \u0447\u0438\u0441\u043b\u043e\u043c"
            );
         }
      } else {
         return var2;
      }
   }

   private static Double I_method_68be36de(JsonObject var0, String var1) {
      JsonElement var2 = var0.get(var1);
      return var2 != null && !var2.isJsonNull() ? var2.getAsDouble() : null;
   }

   private static int I_method_183b14f4(JsonObject var0, String var1, int var2) {
      return (int)Math.round(I_method_183b022a(var0, var1, var2));
   }

   private static boolean I_method_183b54d6(JsonObject var0, String var1, boolean var2) {
      JsonElement var3 = var0.get(var1);
      if (var3 != null && !var3.isJsonNull()) {
         return var3.getAsJsonPrimitive().isBoolean() ? var3.getAsBoolean() : Boolean.parseBoolean(var3.getAsString());
      } else {
         return var2;
      }
   }

   private static List<String> I_method_90c61fc5(JsonObject var0, String var1) {
      ArrayList var2 = new ArrayList();
      JsonElement var3 = var0.get(var1);
      if (var3 != null && !var3.isJsonNull()) {
         if (var3.isJsonArray()) {
            var3.getAsJsonArray().forEach(var1x -> var2.add(var1x.getAsString()));
         } else {
            var2.add(var3.getAsString());
         }

         return var2;
      } else {
         return var2;
      }
   }

   private static IiIiiIiI_Class91.Nested1_427794d3 I_method_3d0bbfc6() {
      return new IiIiiIiI_Class91.Nested1_427794d3();
   }

   static {
      I_method_3d38e00a(
         "game_state",
         "\u0421\u043e\u0441\u0442\u043e\u044f\u043d\u0438\u0435 \u0438\u0433\u0440\u044b \u0438 \u043a\u043b\u0438\u0435\u043d\u0442\u0430: \u0438\u0433\u0440\u043e\u043a (\u043d\u0438\u043a, \u043a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u044b, \u0437\u0434\u043e\u0440\u043e\u0432\u044c\u0435, \u0435\u0434\u0430, \u044d\u0444\u0444\u0435\u043a\u0442\u044b, \u0440\u0443\u043a\u0438, \u0431\u0440\u043e\u043d\u044f), \u043c\u0438\u0440, \u0441\u0435\u0440\u0432\u0435\u0440 (\u0430\u0434\u0440\u0435\u0441, \u043f\u0438\u043d\u0433, TPS, \u043e\u043d\u043b\u0430\u0439\u043d), \u043a\u043b\u0438\u0435\u043d\u0442 (\u0432\u0435\u0440\u0441\u0438\u044f, FPS, \u043a\u043e\u043d\u0444\u0438\u0433, \u0432\u043a\u043b\u044e\u0447\u0451\u043d\u043d\u044b\u0435 \u043c\u043e\u0434\u0443\u043b\u0438) \u0438 \u044d\u043a\u0440\u0430\u043d (\u0440\u0430\u0437\u043c\u0435\u0440 \u043e\u043a\u043d\u0430, gui-scale, \u043e\u0442\u043a\u0440\u044b\u0442\u044b\u0439 \u044d\u043a\u0440\u0430\u043d).",
         I_method_3d0bbfc6()
            .I_method_6def038d(
               "sections",
               "\u041a\u0430\u043a\u0438\u0435 \u0440\u0430\u0437\u0434\u0435\u043b\u044b \u0432\u0435\u0440\u043d\u0443\u0442\u044c: player, world, server, client, screen, inventory, chat. \u041f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e \u0432\u0441\u0435, \u043a\u0440\u043e\u043c\u0435 inventory \u0438 chat.",
               "string"
            )
            .I_method_e16f941b(),
         true,
         var0 -> {
            List var1 = I_method_90c61fc5(var0, "sections");
            if (var1.isEmpty()) {
               var1 = List.of("player", "world", "server", "client", "screen");
            }

            JsonObject var2 = new JsonObject();

            for (String var4 : (Iterable<String>)(Iterable<?>)var1) {
               String var5 = var4.toLowerCase(Locale.ROOT);
               switch (var5) {
                  case "player":
                     var2.add("player", IiIiiIIi_Class90.I_method_6b269336());
                     break;
                  case "world":
                     var2.add("world", IiIiiIIi_Class90.i_method_83f9b56());
                     break;
                  case "server":
                     var2.add("server", IiIiiIIi_Class90.II_method_577505cd());
                     break;
                  case "client":
                     var2.add("client", IiIiiIIi_Class90.Ii_method_f48e0ded());
                     break;
                  case "screen":
                     var2.add("screen", IiIiiIIi_Class90.iI_method_5d7d01ad());
                     break;
                  case "inventory":
                     var2.add("inventory", IiIiiIIi_Class90.II_method_4eec35f1());
                     break;
                  case "chat":
                     var2.add("chat", IiIiiIIi_Class90.I_method_8bf68b13(30));
                     break;
                  default:
                     throw new IiIiiIII_Class89.Nested1_426908f3(
                        "\u043d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u044b\u0439 \u0440\u0430\u0437\u0434\u0435\u043b: " + var4
                     );
               }
            }

            return var2;
         }
      );
      I_method_3d38e00a(
         "entities_nearby",
         "\u041a\u0442\u043e \u0440\u044f\u0434\u043e\u043c: \u0438\u0433\u0440\u043e\u043a\u0438 \u0438 \u043c\u043e\u0431\u044b \u0441 \u0440\u0430\u0441\u0441\u0442\u043e\u044f\u043d\u0438\u0435\u043c, \u0437\u0434\u043e\u0440\u043e\u0432\u044c\u0435\u043c \u0438 \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u043e\u043c \u0432 \u0440\u0443\u043a\u0435.",
         I_method_3d0bbfc6()
            .i_method_6ddbaf7(
               "radius",
               "\u0420\u0430\u0434\u0438\u0443\u0441 \u043f\u043e\u0438\u0441\u043a\u0430 \u0432 \u0431\u043b\u043e\u043a\u0430\u0445 (\u043f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e 32)"
            )
            .II_method_e77d5dc4(
               "limit",
               "\u0421\u043a\u043e\u043b\u044c\u043a\u043e \u0441\u0443\u0449\u043d\u043e\u0441\u0442\u0435\u0439 \u0432\u0435\u0440\u043d\u0443\u0442\u044c (\u043f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e 20)"
            )
            .I_method_8eae42d7(
               "type",
               "players (\u0442\u043e\u043b\u044c\u043a\u043e \u0438\u0433\u0440\u043e\u043a\u0438), living (\u0436\u0438\u0432\u044b\u0435), all (\u0432\u0441\u0435). \u041f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e living"
            )
            .I_method_e16f941b(),
         true,
         var0 -> IiIiiIIi_Class90.I_method_cb9e432c(
            "entities",
            IiIiiIIi_Class90.I_method_7fafe1b7(
               I_method_183b022a(var0, "radius", 32.0), I_method_183b14f4(var0, "limit", 20), I_method_66c8fa94(var0, "type", "living")
            )
         )
      );
      I_method_3d38e00a(
         "chat_history",
         "\u041f\u043e\u0441\u043b\u0435\u0434\u043d\u0438\u0435 \u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u044f \u0438\u0433\u0440\u043e\u0432\u043e\u0433\u043e \u0447\u0430\u0442\u0430, \u0441\u0432\u0435\u0436\u0438\u0435 \u0441\u0432\u0435\u0440\u0445\u0443.",
         I_method_3d0bbfc6()
            .II_method_e77d5dc4(
               "limit",
               "\u0421\u043a\u043e\u043b\u044c\u043a\u043e \u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0439 \u0432\u0435\u0440\u043d\u0443\u0442\u044c (\u043f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e 30)"
            )
            .I_method_e16f941b(),
         true,
         var0 -> IiIiiIIi_Class90.I_method_cb9e432c("chat", IiIiiIIi_Class90.I_method_8bf68b13(I_method_183b14f4(var0, "limit", 30)))
      );
      I_method_3d38e00a(
         "chat_send",
         "\u041e\u0442\u043f\u0440\u0430\u0432\u0438\u0442\u044c \u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435 \u0432 \u0447\u0430\u0442. \u0422\u0435\u043a\u0441\u0442 \u0441 / \u0443\u0445\u043e\u0434\u0438\u0442 \u043a\u043e\u043c\u0430\u043d\u0434\u043e\u0439 \u0441\u0435\u0440\u0432\u0435\u0440\u0443, \u0442\u0435\u043a\u0441\u0442 \u0441 \u043f\u0440\u0435\u0444\u0438\u043a\u0441\u043e\u043c \u043a\u043b\u0438\u0435\u043d\u0442\u0430 (\u043f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e \u0442\u043e\u0447\u043a\u0430) \u0432\u044b\u043f\u043e\u043b\u043d\u044f\u0435\u0442\u0441\u044f \u043a\u0430\u043a \u043a\u043e\u043c\u0430\u043d\u0434\u0430 \u0441\u0430\u043c\u043e\u0433\u043e Rockstar.",
         I_method_3d0bbfc6()
            .I_method_8eae42d7("message", "\u0427\u0442\u043e \u043e\u0442\u043f\u0440\u0430\u0432\u0438\u0442\u044c")
            .I_method_2e39a0a1("message")
            .I_method_e16f941b(),
         true,
         var0 -> IiIiIiIi_Class86.I_method_d9c9626c(I_method_66c8fa94(var0, "message", null))
      );
      I_method_3d38e00a(
         "modules_list",
         "\u0421\u043f\u0438\u0441\u043e\u043a \u043c\u043e\u0434\u0443\u043b\u0435\u0439 \u043a\u043b\u0438\u0435\u043d\u0442\u0430: \u0438\u043c\u044f, \u043a\u0430\u0442\u0435\u0433\u043e\u0440\u0438\u044f, \u0432\u043a\u043b\u044e\u0447\u0451\u043d \u043b\u0438, \u0431\u0438\u043d\u0434, \u0447\u0438\u0441\u043b\u043e \u043d\u0430\u0441\u0442\u0440\u043e\u0435\u043a.",
         I_method_3d0bbfc6()
            .I_method_8eae42d7("category", "COMBAT, MOVEMENT, VISUALS, PLAYER \u0438\u043b\u0438 OTHER")
            .Ii_method_5facd5e4("enabled_only", "\u0422\u043e\u043b\u044c\u043a\u043e \u0432\u043a\u043b\u044e\u0447\u0451\u043d\u043d\u044b\u0435")
            .I_method_8eae42d7("query", "\u0424\u0438\u043b\u044c\u0442\u0440 \u043f\u043e \u0447\u0430\u0441\u0442\u0438 \u0438\u043c\u0435\u043d\u0438")
            .Ii_method_5facd5e4(
               "include_hidden",
               "\u041f\u043e\u043a\u0430\u0437\u0430\u0442\u044c \u0438 \u0441\u043a\u0440\u044b\u0442\u044b\u0435 \u043c\u043e\u0434\u0443\u043b\u0438"
            )
            .I_method_e16f941b(),
         true,
         var0 -> IiIiiIIi_Class90.I_method_cb9e432c(
            "modules",
            IiIiiIIi_Class90.I_method_5c6bd628(
               I_method_66c8fa94(var0, "category", null),
               I_method_183b54d6(var0, "enabled_only", false),
               I_method_66c8fa94(var0, "query", null),
               I_method_183b54d6(var0, "include_hidden", false)
            )
         )
      );
      I_method_3d38e00a(
         "module_info",
         "\u041c\u043e\u0434\u0443\u043b\u044c \u0446\u0435\u043b\u0438\u043a\u043e\u043c: \u0441\u043e\u0441\u0442\u043e\u044f\u043d\u0438\u0435, \u0431\u0438\u043d\u0434 \u0438 \u0432\u0441\u0435 \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u0441 \u0442\u0438\u043f\u0430\u043c\u0438, \u0442\u0435\u043a\u0443\u0449\u0438\u043c\u0438 \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u044f\u043c\u0438, \u0434\u0438\u0430\u043f\u0430\u0437\u043e\u043d\u0430\u043c\u0438 \u0438 \u0441\u043f\u0438\u0441\u043a\u0430\u043c\u0438 \u0432\u0430\u0440\u0438\u0430\u043d\u0442\u043e\u0432. \u0418\u043c\u0435\u043d\u0430 \u043d\u0430\u0441\u0442\u0440\u043e\u0435\u043a \u043e\u0442\u0441\u044e\u0434\u0430 \u0438\u0434\u0443\u0442 \u0432 setting_set.",
         I_method_3d0bbfc6()
            .I_method_8eae42d7("module", "\u0418\u043c\u044f \u043c\u043e\u0434\u0443\u043b\u044f, \u043d\u0430\u043f\u0440\u0438\u043c\u0435\u0440 Aura")
            .I_method_2e39a0a1("module")
            .I_method_e16f941b(),
         true,
         var0 -> {
            ModuleEntry var1 = IiIiIiIi_Class86.I_method_b99c08a1(I_method_66c8fa94(var0, "module", null));
            return IiIiiIIi_Class90.I_method_a29ebd5b(var1, true);
         }
      );
      I_method_3d38e00a(
         "module_control",
         "\u0412\u043a\u043b\u044e\u0447\u0438\u0442\u044c, \u0432\u044b\u043a\u043b\u044e\u0447\u0438\u0442\u044c \u0438\u043b\u0438 \u043f\u0435\u0440\u0435\u043a\u043b\u044e\u0447\u0438\u0442\u044c \u043c\u043e\u0434\u0443\u043b\u044c, \u043b\u0438\u0431\u043e \u043f\u043e\u0432\u0435\u0441\u0438\u0442\u044c \u043d\u0430 \u043d\u0435\u0433\u043e \u043a\u043b\u0430\u0432\u0438\u0448\u0443.",
         I_method_3d0bbfc6()
            .I_method_8eae42d7("module", "\u0418\u043c\u044f \u043c\u043e\u0434\u0443\u043b\u044f")
            .I_method_2e39a0a1("module")
            .I_method_8eae42d7(
               "action", "enable, disable, toggle \u0438\u043b\u0438 bind (\u043f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e toggle)"
            )
            .iI_method_753ce9a4(
               "key",
               "\u0414\u043b\u044f action=bind: \u0438\u043c\u044f \u043a\u043b\u0430\u0432\u0438\u0448\u0438 (\"R\", \"MOUSE4\", \"none\") \u0438\u043b\u0438 GLFW-\u043a\u043e\u0434"
            )
            .I_method_e16f941b(),
         true,
         var0 -> {
            String var1 = I_method_66c8fa94(var0, "action", "toggle");
            return "bind".equalsIgnoreCase(var1)
               ? IiIiIiIi_Class86.I_method_bbe7cc8f(I_method_66c8fa94(var0, "module", null), var0.get("key"))
               : IiIiIiIi_Class86.I_method_6700b3e2(I_method_66c8fa94(var0, "module", null), var1);
         }
      );
      I_method_3d38e00a(
         "setting_set",
         "\u0418\u0437\u043c\u0435\u043d\u0438\u0442\u044c \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0443 \u043c\u043e\u0434\u0443\u043b\u044f. \u0417\u043d\u0430\u0447\u0435\u043d\u0438\u0435 \u0432 \u0447\u0435\u043b\u043e\u0432\u0435\u0447\u0435\u0441\u043a\u043e\u043c \u0432\u0438\u0434\u0435: true/false, \u0447\u0438\u0441\u043b\u043e, \u0438\u043c\u044f \u0440\u0435\u0436\u0438\u043c\u0430, \u043c\u0430\u0441\u0441\u0438\u0432 \u043f\u0443\u043d\u043a\u0442\u043e\u0432 \u0434\u043b\u044f \u043c\u0443\u043b\u044c\u0442\u0438\u0432\u044b\u0431\u043e\u0440\u0430, #rrggbbaa \u0434\u043b\u044f \u0446\u0432\u0435\u0442\u0430, \u0438\u043c\u044f \u043a\u043b\u0430\u0432\u0438\u0448\u0438 \u0434\u043b\u044f \u0431\u0438\u043d\u0434\u0430, \"click\" \u0434\u043b\u044f \u043a\u043d\u043e\u043f\u043a\u0438.",
         I_method_3d0bbfc6()
            .I_method_8eae42d7("module", "\u0418\u043c\u044f \u043c\u043e\u0434\u0443\u043b\u044f")
            .I_method_2e39a0a1("module")
            .I_method_8eae42d7("setting", "\u0418\u043c\u044f \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u0438\u0437 module_info")
            .I_method_2e39a0a1("setting")
            .iI_method_753ce9a4("value", "\u041d\u043e\u0432\u043e\u0435 \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u0435")
            .I_method_2e39a0a1("value")
            .I_method_e16f941b(),
         true,
         var0 -> IiIiIiIi_Class86.I_method_1ff536d9(I_method_66c8fa94(var0, "module", null), I_method_66c8fa94(var0, "setting", null), var0.get("value"))
      );
      I_method_3d38e00a(
         "binds_list",
         "\u0412\u0441\u0435 \u043d\u0430\u0437\u043d\u0430\u0447\u0435\u043d\u043d\u044b\u0435 \u043a\u043b\u0430\u0432\u0438\u0448\u0438: \u0431\u0438\u043d\u0434\u044b \u043c\u043e\u0434\u0443\u043b\u0435\u0439, \u0431\u0438\u043d\u0434\u044b \u0432\u043d\u0443\u0442\u0440\u0438 \u043d\u0430\u0441\u0442\u0440\u043e\u0435\u043a \u0438 \u043c\u0430\u043a\u0440\u043e\u0441\u044b.",
         I_method_3d0bbfc6().I_method_e16f941b(),
         true,
         var0 -> IiIiiIIi_Class90.ii_method_fa9609cd()
      );
      I_method_3d38e00a(
         "macros",
         "\u041c\u0430\u043a\u0440\u043e\u0441\u044b: \u043a\u043e\u043c\u0430\u043d\u0434\u0430 \u0447\u0430\u0442\u0430 \u043d\u0430 \u043a\u043b\u0430\u0432\u0438\u0448\u0435. \u0414\u0435\u0439\u0441\u0442\u0432\u0438\u044f list, add, remove.",
         I_method_3d0bbfc6()
            .I_method_8eae42d7("action", "list, add \u0438\u043b\u0438 remove (\u043f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e list)")
            .I_method_8eae42d7(
               "command", "\u041a\u043e\u043c\u0430\u043d\u0434\u0430, \u043d\u0430\u043f\u0440\u0438\u043c\u0435\u0440 /spawn \u0438\u043b\u0438 .toggle aura"
            )
            .iI_method_753ce9a4("key", "\u041a\u043b\u0430\u0432\u0438\u0448\u0430: \u0438\u043c\u044f (\"G\") \u0438\u043b\u0438 GLFW-\u043a\u043e\u0434")
            .I_method_e16f941b(),
         true,
         var0 -> {
            String var1 = I_method_66c8fa94(var0, "action", "list").toLowerCase(Locale.ROOT);

            return switch (var1) {
               case "add" -> IiIiiIIi_Class90.I_method_cb9e432c(
                  "macros", IiIiIiIi_Class86.I_method_bd848eef(I_method_66c8fa94(var0, "command", null), var0.get("key"))
               );
               case "remove" -> IiIiiIIi_Class90.I_method_cb9e432c(
                  "macros", IiIiIiIi_Class86.i_method_d7545f0f(I_method_66c8fa94(var0, "command", null), var0.get("key"))
               );
               default -> IiIiiIIi_Class90.I_method_cb9e432c("macros", IiIiiIIi_Class90.I_method_4f8ed768());
            };
         }
      );
      I_method_3d38e00a(
         "configs",
         "\u041a\u043e\u043d\u0444\u0438\u0433\u0438 \u043a\u043b\u0438\u0435\u043d\u0442\u0430 (\u0436\u0438\u0432\u0443\u0442 \u043d\u0430 \u0441\u0435\u0440\u0432\u0435\u0440\u0435 \u0430\u043a\u043a\u0430\u0443\u043d\u0442\u0430): list, save, load, delete, rename, duplicate, reset.",
         I_method_3d0bbfc6()
            .I_method_8eae42d7(
               "action",
               "\u0427\u0442\u043e \u0441\u0434\u0435\u043b\u0430\u0442\u044c (\u043f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e list)"
            )
            .I_method_8eae42d7("name", "\u0418\u043c\u044f \u043a\u043e\u043d\u0444\u0438\u0433\u0430")
            .I_method_8eae42d7("new_name", "\u041d\u043e\u0432\u043e\u0435 \u0438\u043c\u044f \u0434\u043b\u044f rename")
            .I_method_e16f941b(),
         true,
         var0 -> IiIiIiIi_Class86.I_method_69eed3d8(
            I_method_66c8fa94(var0, "action", "list"), I_method_66c8fa94(var0, "name", null), I_method_66c8fa94(var0, "new_name", null)
         )
      );
      I_method_3d38e00a(
         "script_api",
         "\u0421\u043f\u0440\u0430\u0432\u043e\u0447\u043d\u0438\u043a \u043f\u043e Python-API \u0441\u043a\u0440\u0438\u043f\u0442\u043e\u0432 \u043a\u043b\u0438\u0435\u043d\u0442\u0430: \u043c\u043e\u0434\u0443\u043b\u0438, \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438, \u0441\u043e\u0431\u044b\u0442\u0438\u044f, HUD, \u043c\u0435\u043d\u044e, \u0440\u0435\u043d\u0434\u0435\u0440, \u0433\u043e\u0442\u043e\u0432\u044b\u0435 \u043f\u0440\u0438\u043c\u0435\u0440\u044b. \u0427\u0438\u0442\u0430\u0439 \u0415\u0413\u041e, \u0430 \u043d\u0435 \u043f\u0430\u043c\u044f\u0442\u044c: \u043a\u043b\u0438\u0435\u043d\u0442\u0441\u043a\u043e\u0433\u043e API \u043d\u0435\u0442 \u0432 \u043e\u0442\u043a\u0440\u044b\u0442\u044b\u0445 \u0438\u0441\u0442\u043e\u0447\u043d\u0438\u043a\u0430\u0445, \u0438 \u0432\u044b\u0434\u0443\u043c\u0430\u043d\u043d\u044b\u0435 \u043c\u0435\u0442\u043e\u0434\u044b \u0438 \u0441\u043e\u0431\u044b\u0442\u0438\u044f \u043f\u0440\u043e\u0441\u0442\u043e \u043d\u0435 \u0440\u0430\u0431\u043e\u0442\u0430\u044e\u0442. \u0420\u0430\u0437\u0434\u0435\u043b\u044b: basics (\u043d\u0430\u0447\u043d\u0438 \u0441 \u043d\u0435\u0433\u043e), api, events, ui, recipes.",
         I_method_3d0bbfc6()
            .I_method_8eae42d7(
               "section",
               "\u0420\u0430\u0437\u0434\u0435\u043b: basics (\u043f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e), api, events, ui, recipes"
            )
            .I_method_8eae42d7(
               "query",
               "\u041d\u0435\u043e\u0431\u044f\u0437\u0430\u0442\u0435\u043b\u044c\u043d\u043e: \u0441\u043b\u043e\u0432\u043e \u0438\u043b\u0438 \u0438\u043c\u044f \u043c\u0435\u0442\u043e\u0434\u0430 \u2014 \u0442\u043e\u0433\u0434\u0430 \u043f\u0440\u0438\u0434\u0443\u0442 \u0442\u043e\u043b\u044c\u043a\u043e \u043f\u043e\u0434\u0440\u0430\u0437\u0434\u0435\u043b\u044b \u0441 \u043d\u0438\u043c"
            )
            .I_method_e16f941b(),
         false,
         var0 -> IiIiIiiI_Class87.I_method_d6803100(I_method_66c8fa94(var0, "section", "basics"), I_method_66c8fa94(var0, "query", null))
      );
      I_method_3d38e00a(
         "scripts",
         "Python-\u0441\u043a\u0440\u0438\u043f\u0442\u044b \u043a\u043b\u0438\u0435\u043d\u0442\u0430: list, read, write (\u0441\u043e\u0437\u0434\u0430\u0451\u0442 \u0438\u043b\u0438 \u043f\u0435\u0440\u0435\u0437\u0430\u043f\u0438\u0441\u044b\u0432\u0430\u0435\u0442), delete, enable, disable, reload. \u041f\u0435\u0440\u0435\u0434 write \u0432\u043e\u0437\u044c\u043c\u0438 API \u0438\u0437 script_api. \u041e\u0442\u0432\u0435\u0442 \u043d\u0430 write \u0433\u043e\u0432\u043e\u0440\u0438\u0442, \u0437\u0430\u0433\u0440\u0443\u0437\u0438\u043b\u0441\u044f \u043b\u0438 \u0441\u043a\u0440\u0438\u043f\u0442, \u0438 \u043f\u0440\u0438\u043d\u043e\u0441\u0438\u0442 \u043e\u0448\u0438\u0431\u043a\u0443 \u0437\u0430\u0433\u0440\u0443\u0437\u043a\u0438, \u0435\u0441\u043b\u0438 \u0443\u043f\u0430\u043b. \u041a\u0443\u043f\u043b\u0435\u043d\u043d\u044b\u0435 \u0437\u0430\u0449\u0438\u0449\u0451\u043d\u043d\u044b\u0435 \u0441\u043a\u0440\u0438\u043f\u0442\u044b \u0447\u0438\u0442\u0430\u0442\u044c \u043d\u0435\u043b\u044c\u0437\u044f \u2014 \u0438\u0441\u0445\u043e\u0434\u043d\u0438\u043a\u0430 \u043d\u0430 \u0434\u0438\u0441\u043a\u0435 \u043d\u0435\u0442.",
         I_method_3d0bbfc6()
            .I_method_8eae42d7(
               "action",
               "\u0427\u0442\u043e \u0441\u0434\u0435\u043b\u0430\u0442\u044c (\u043f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e list)"
            )
            .I_method_8eae42d7("name", "\u0418\u043c\u044f \u0441\u043a\u0440\u0438\u043f\u0442\u0430 \u0431\u0435\u0437 .py")
            .I_method_8eae42d7("content", "\u0421\u043e\u0434\u0435\u0440\u0436\u0438\u043c\u043e\u0435 \u0434\u043b\u044f write")
            .I_method_e16f941b(),
         true,
         var0 -> IiIiIiIi_Class86.i_method_677c83f8(
            I_method_66c8fa94(var0, "action", "list"), I_method_66c8fa94(var0, "name", null), I_method_66c8fa94(var0, "content", null)
         )
      );
      I_method_3d38e00a(
         "swing",
         "\u0410\u043d\u0438\u043c\u0430\u0446\u0438\u044f \u0437\u0430\u043c\u0430\u0445\u0430: state (\u0442\u0435\u043a\u0443\u0449\u0438\u0435 \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u044f \u0438 \u0441\u043f\u0438\u0441\u043e\u043a \u043f\u0440\u0435\u0441\u0435\u0442\u043e\u0432), apply (\u0432\u043a\u043b\u044e\u0447\u0438\u0442\u044c \u043f\u0440\u0435\u0441\u0435\u0442), set (\u043f\u043e\u043c\u0435\u043d\u044f\u0442\u044c \u043e\u0434\u043d\u0443 \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0443 \u0444\u0430\u0437\u044b).",
         I_method_3d0bbfc6()
            .I_method_8eae42d7("action", "state, apply \u0438\u043b\u0438 set (\u043f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e state)")
            .I_method_8eae42d7("preset", "\u0418\u043c\u044f \u043f\u0440\u0435\u0441\u0435\u0442\u0430 \u0434\u043b\u044f apply")
            .I_method_8eae42d7("phase", "\u0414\u043b\u044f set: shared, start \u0438\u043b\u0438 end")
            .I_method_8eae42d7(
               "setting",
               "\u0414\u043b\u044f set: \u0438\u043c\u044f \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438, \u043d\u0430\u043f\u0440\u0438\u043c\u0435\u0440 swing.rotateX"
            )
            .iI_method_753ce9a4("value", "\u0414\u043b\u044f set: \u043d\u043e\u0432\u043e\u0435 \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u0435")
            .I_method_e16f941b(),
         true,
         var0 -> IiIiIiIi_Class86.I_method_c81fefed(
            I_method_66c8fa94(var0, "action", "state"),
            I_method_66c8fa94(var0, "preset", null),
            I_method_66c8fa94(var0, "phase", null),
            I_method_66c8fa94(var0, "setting", null),
            var0.get("value")
         )
      );
      I_method_3d38e00a(
         "menu",
         "\u041c\u0435\u043d\u044e \u043a\u043b\u0438\u0435\u043d\u0442\u0430: open, close, toggle. \u041e\u0442\u043a\u0440\u044b\u0442\u043e\u0435 \u043c\u0435\u043d\u044e \u2014 \u043e\u0431\u044b\u0447\u043d\u044b\u0439 \u044d\u043a\u0440\u0430\u043d, \u043f\u043e \u043d\u0435\u043c\u0443 \u043c\u043e\u0436\u043d\u043e \u043a\u043b\u0438\u043a\u0430\u0442\u044c.",
         I_method_3d0bbfc6()
            .I_method_8eae42d7("action", "open, close \u0438\u043b\u0438 toggle (\u043f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e open)")
            .I_method_e16f941b(),
         true,
         var0 -> IiIiIiIi_Class86.i_method_cafca28c(I_method_66c8fa94(var0, "action", "open"))
      );
      I_method_3d38e00a(
         "screenshot",
         "\u041a\u0430\u0434\u0440 \u0438\u0433\u0440\u044b \u043a\u0430\u043a \u043a\u0430\u0440\u0442\u0438\u043d\u043a\u0430. \u0412\u043e\u0437\u0432\u0440\u0430\u0449\u0430\u0435\u0442 \u0435\u0449\u0451 \u0438 \u0440\u0430\u0437\u043c\u0435\u0440\u044b: \u043a\u043b\u0438\u043a\u0438 \u0438\u043d\u0441\u0442\u0440\u0443\u043c\u0435\u043d\u0442\u043e\u043c mouse \u0441\u0447\u0438\u0442\u0430\u044e\u0442\u0441\u044f \u0432 \u043f\u0438\u043a\u0441\u0435\u043b\u044f\u0445 \u044d\u0442\u043e\u0433\u043e \u043a\u0430\u0434\u0440\u0430.",
         I_method_3d0bbfc6()
            .II_method_e77d5dc4(
               "max_width",
               "\u0428\u0438\u0440\u0438\u043d\u0430 \u043a\u0430\u0440\u0442\u0438\u043d\u043a\u0438, \u043a\u0430\u0434\u0440 \u0443\u0436\u0438\u043c\u0430\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u043f\u043e\u0440\u0446\u0438\u043e\u043d\u0430\u043b\u044c\u043d\u043e (\u043f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e 1280)"
            )
            .I_method_8eae42d7("format", "jpeg (\u043f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e) \u0438\u043b\u0438 png")
            .i_method_6ddbaf7(
               "quality",
               "\u041a\u0430\u0447\u0435\u0441\u0442\u0432\u043e JPEG \u043e\u0442 0.1 \u0434\u043e 1.0 (\u043f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e 0.75)"
            )
            .I_method_e16f941b(),
         false,
         var0 -> IiIiIiii_Class88.I_method_3133ee93(
            I_method_183b14f4(var0, "max_width", 1280), I_method_66c8fa94(var0, "format", "jpeg"), (float)I_method_183b022a(var0, "quality", 0.75)
         )
      );
      I_method_3d38e00a(
         "mouse",
         "\u041c\u044b\u0448\u044c: move, click, drag, scroll. \u041a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u044b \u043f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e \u2014 \u043f\u0438\u043a\u0441\u0435\u043b\u0438 \u043f\u043e\u0441\u043b\u0435\u0434\u043d\u0435\u0433\u043e \u0441\u043a\u0440\u0438\u043d\u0448\u043e\u0442\u0430. \u0415\u0441\u043b\u0438 \u043e\u0442\u043a\u0440\u044b\u0442\u043e\u0433\u043e \u044d\u043a\u0440\u0430\u043d\u0430 \u043d\u0435\u0442, \u043a\u043b\u0438\u043a \u0443\u0445\u043e\u0434\u0438\u0442 \u0432 \u0438\u0433\u0440\u0443 (\u043b\u0435\u0432\u0430\u044f \u2014 \u0443\u0434\u0430\u0440, \u043f\u0440\u0430\u0432\u0430\u044f \u2014 \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435).",
         I_method_3d0bbfc6()
            .I_method_8eae42d7(
               "action", "move, click, drag \u0438\u043b\u0438 scroll (\u043f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e click)"
            )
            .i_method_6ddbaf7("x", "\u041a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u0430 X")
            .i_method_6ddbaf7("y", "\u041a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u0430 Y")
            .i_method_6ddbaf7("to_x", "\u041a\u0443\u0434\u0430 \u0442\u044f\u043d\u0443\u0442\u044c \u0434\u043b\u044f drag")
            .i_method_6ddbaf7("to_y", "\u041a\u0443\u0434\u0430 \u0442\u044f\u043d\u0443\u0442\u044c \u0434\u043b\u044f drag")
            .I_method_8eae42d7("button", "left, right \u0438\u043b\u0438 middle (\u043f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e left)")
            .II_method_e77d5dc4(
               "clicks",
               "\u0421\u043a\u043e\u043b\u044c\u043a\u043e \u043a\u043b\u0438\u043a\u043e\u0432 \u043f\u043e\u0434\u0440\u044f\u0434 (\u043f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e 1)"
            )
            .i_method_6ddbaf7(
               "amount",
               "\u0412\u0435\u043b\u0438\u0447\u0438\u043d\u0430 \u043f\u0440\u043e\u043a\u0440\u0443\u0442\u043a\u0438, \u043f\u043b\u044e\u0441 \u0432\u0432\u0435\u0440\u0445"
            )
            .II_method_e77d5dc4(
               "hold_ms",
               "\u0421\u043a\u043e\u043b\u044c\u043a\u043e \u0434\u0435\u0440\u0436\u0430\u0442\u044c \u043a\u043d\u043e\u043f\u043a\u0443, \u043c\u0441"
            )
            .I_method_8eae42d7(
               "space",
               "image (\u043f\u0438\u043a\u0441\u0435\u043b\u0438 \u0441\u043a\u0440\u0438\u043d\u0448\u043e\u0442\u0430, \u043f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e), pixels (\u043f\u0438\u043a\u0441\u0435\u043b\u0438 \u043a\u0430\u0434\u0440\u0430) \u0438\u043b\u0438 gui"
            )
            .I_method_e16f941b(),
         true,
         var0 -> IiIiIiii_Class88.I_method_2975ac1c(
            I_method_66c8fa94(var0, "action", "click"),
            I_method_183b022a(var0, "x", 0.0),
            I_method_183b022a(var0, "y", 0.0),
            I_method_66c8fa94(var0, "button", "left"),
            I_method_183b14f4(var0, "clicks", 1),
            I_method_183b022a(var0, "amount", 0.0),
            I_method_183b14f4(var0, "hold_ms", 0),
            I_method_68be36de(var0, "to_x"),
            I_method_68be36de(var0, "to_y"),
            I_method_66c8fa94(var0, "space", "image")
         )
      );
      I_method_3d38e00a(
         "keyboard",
         "\u041a\u043b\u0430\u0432\u0438\u0430\u0442\u0443\u0440\u0430: press (\u043d\u0430\u0436\u0430\u0442\u044c \u043a\u043b\u0430\u0432\u0438\u0448\u0443, \u0432 \u0442\u043e\u043c \u0447\u0438\u0441\u043b\u0435 \u0431\u0438\u043d\u0434 \u043c\u043e\u0434\u0443\u043b\u044f) \u0438\u043b\u0438 type (\u043d\u0430\u043f\u0435\u0447\u0430\u0442\u0430\u0442\u044c \u0442\u0435\u043a\u0441\u0442 \u0432 \u043e\u0442\u043a\u0440\u044b\u0442\u043e\u0435 \u043f\u043e\u043b\u0435 \u0432\u0432\u043e\u0434\u0430).",
         I_method_3d0bbfc6()
            .I_method_8eae42d7("action", "press \u0438\u043b\u0438 type (\u043f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e press)")
            .I_method_8eae42d7("key", "\u0418\u043c\u044f \u043a\u043b\u0430\u0432\u0438\u0448\u0438: R, ESCAPE, F3, LEFT_SHIFT")
            .I_method_8eae42d7("text", "\u0422\u0435\u043a\u0441\u0442 \u0434\u043b\u044f type")
            .I_method_6def038d("modifiers", "shift, ctrl, alt", "string")
            .II_method_e77d5dc4(
               "hold_ms",
               "\u0421\u043a\u043e\u043b\u044c\u043a\u043e \u0434\u0435\u0440\u0436\u0430\u0442\u044c \u043a\u043b\u0430\u0432\u0438\u0448\u0443, \u043c\u0441"
            )
            .I_method_e16f941b(),
         true,
         var0 -> IiIiIiii_Class88.I_method_1ffe9e1a(
            I_method_66c8fa94(var0, "action", "press"),
            I_method_66c8fa94(var0, "key", null),
            I_method_66c8fa94(var0, "text", null),
            I_method_90c61fc5(var0, "modifiers"),
            I_method_183b14f4(var0, "hold_ms", 0)
         )
      );
   }

   static final class Nested1_427794d3 {
      private final JsonObject I_field_a1a50d2c = new JsonObject();
      private final JsonArray I_field_6fe46b2 = new JsonArray();
      private String I_field_523beb0a;

      private IiIiiIiI_Class91.Nested1_427794d3 i_method_6b7cb3ad(String var1, String var2, String var3) {
         JsonObject var4 = new JsonObject();
         if (var2 != null) {
            var4.addProperty("type", var2);
         }

         var4.addProperty("description", var3);
         this.I_field_a1a50d2c.add(var1, var4);
         this.I_field_523beb0a = var1;
         return this;
      }

      IiIiiIiI_Class91.Nested1_427794d3 I_method_8eae42d7(String var1, String var2) {
         return this.i_method_6b7cb3ad(var1, "string", var2);
      }

      IiIiiIiI_Class91.Nested1_427794d3 i_method_6ddbaf7(String var1, String var2) {
         return this.i_method_6b7cb3ad(var1, "number", var2);
      }

      IiIiiIiI_Class91.Nested1_427794d3 II_method_e77d5dc4(String var1, String var2) {
         return this.i_method_6b7cb3ad(var1, "integer", var2);
      }

      IiIiiIiI_Class91.Nested1_427794d3 Ii_method_5facd5e4(String var1, String var2) {
         return this.i_method_6b7cb3ad(var1, "boolean", var2);
      }

      IiIiiIiI_Class91.Nested1_427794d3 iI_method_753ce9a4(String var1, String var2) {
         return this.i_method_6b7cb3ad(var1, null, var2);
      }

      IiIiiIiI_Class91.Nested1_427794d3 I_method_6def038d(String var1, String var2, String var3) {
         this.i_method_6b7cb3ad(var1, "array", var2);
         JsonObject var4 = new JsonObject();
         var4.addProperty("type", var3);
         this.I_field_a1a50d2c.getAsJsonObject(var1).add("items", var4);
         return this;
      }

      IiIiiIiI_Class91.Nested1_427794d3 I_method_2e39a0a1(String var1) {
         this.I_field_6fe46b2.add(var1 == null ? this.I_field_523beb0a : var1);
         return this;
      }

      JsonObject I_method_e16f941b() {
         JsonObject var1 = new JsonObject();
         var1.addProperty("type", "object");
         var1.add("properties", this.I_field_a1a50d2c);
         if (!this.I_field_6fe46b2.isEmpty()) {
            var1.add("required", this.I_field_6fe46b2);
         }

         return var1;
      }
   }

   static final class Nested1_427794f3 {
      private final String I_field_523beb0a;
      private final String i_field_523beb0a;
      private final JsonObject I_field_a1a50d2c;
      private final boolean I_field_5a;
      private final Function<JsonObject, Object> I_field_aad1658;

      Nested1_427794f3(String var1, String var2, JsonObject var3, boolean var4, Function<JsonObject, Object> var5) {
         this.I_field_523beb0a = var1;
         this.i_field_523beb0a = var2;
         this.I_field_a1a50d2c = var3;
         this.I_field_5a = var4;
         this.I_field_aad1658 = var5;
      }

      @Override
      public final String toString() {
         return "Nested1_427794f3[name=" + this.I_field_523beb0a + ", description=" + this.i_field_523beb0a + ", schema=" + this.I_field_a1a50d2c + ", onClient=" + this.I_field_5a + ", handler=" + this.I_field_aad1658 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_a1a50d2c);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_aad1658);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiIiiIiI_Class91.Nested1_427794f3 other = (IiIiiIiI_Class91.Nested1_427794f3) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.i_field_523beb0a, other.i_field_523beb0a)
            && java.util.Objects.equals(this.I_field_a1a50d2c, other.I_field_a1a50d2c)
            && java.util.Objects.equals(this.I_field_5a, other.I_field_5a)
            && java.util.Objects.equals(this.I_field_aad1658, other.I_field_aad1658);
      }

      public String I_method_5059a8d9() {
         return this.I_field_523beb0a;
      }

      public String i_method_e37858f9() {
         return this.i_field_523beb0a;
      }

      public JsonObject I_method_9c67143b() {
         return this.I_field_a1a50d2c;
      }

      public boolean I_method_de788eab() {
         return this.I_field_5a;
      }

      public Function<JsonObject, Object> I_method_682bf129() {
         return this.I_field_aad1658;
      }
   }
}
