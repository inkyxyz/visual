package rockstar.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public final class IIiiiiIi_Class62 {
   private static final Map<String, JsonObject> I_field_a567c40b = new ConcurrentHashMap<>();
   private static final Map<String, JsonObject> i_field_a567c40b = new ConcurrentHashMap<>();

   private IIiiiiIi_Class62() {
   }

   private static Collection<ModuleEntry> I_method_17bd4f9b() {
      return RockstarClient.getInstance().getModuleManager().getModules();
   }

   public static JsonObject I_method_50733716() {
      JsonObject var0 = new JsonObject();
      var0.add("modules", I_method_3e2e3788());
      var0.add("espElements", IiiiiiiI_Class127.I_method_e1e653cb().I_method_1d714fa8());
      var0.add("macroMenu", i_method_53c3ab68());
      return var0;
   }

   private static JsonArray I_method_3e2e3788() {
      JsonArray var0 = new JsonArray();
      HashSet var1 = new HashSet();

      for (ModuleEntry var3 : I_method_17bd4f9b()) {
         var1.add(var3.getName());
         var0.add(I_method_8acdbc15(var3));
      }

      for (Entry var5 : I_field_a567c40b.entrySet()) {
         if (!var1.contains(var5.getKey())) {
            var0.add(((JsonObject)var5.getValue()).deepCopy());
         }
      }

      return var0;
   }

   private static JsonObject I_method_8acdbc15(ModuleEntry var0) {
      JsonObject var1 = new JsonObject();
      var1.addProperty("name", var0.getName());
      var1.addProperty("enabled", var0.isEnabled() && !i_method_45e34af1(var0));
      var1.addProperty("key", var0.getKeybind());
      var1.add("settings", I_method_609390bb(var0.getSettings(), var0.getName()));
      return var1;
   }

   public static void I_method_304dd70d(ModuleEntry var0) {
      if (var0 != null) {
         I_field_a567c40b.put(var0.getName(), I_method_8acdbc15(var0));
      }
   }

   public static void I_method_c807f2f9(ModuleEntry var0, Setting var1) {
      if (var0 != null && var1 != null) {
         try {
            I_method_a3fb6669(var0.getName(), var1.getName(), var1.toJson());
         } catch (Exception var3) {
            RockstarClient.I_field_ab0f6068
               .warn(
                  "Config: \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0441\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0443 {} \u043c\u043e\u0434\u0443\u043b\u044f {}",
                  new Object[]{var1.getName(), var0.getName(), var3}
               );
         }
      }
   }

   private static JsonObject I_method_609390bb(List<Setting> var0, String var1) {
      JsonObject var2 = new JsonObject();

      for (Setting var4 : var0) {
         var2.add(var4.getName(), var4.toJson());
      }

      JsonObject var9 = i_field_a567c40b.get(var1);
      if (var9 != null) {
         synchronized (var9) {
            for (Entry var6 : var9.entrySet()) {
               if (!var2.has((String)var6.getKey())) {
                  var2.add((String)var6.getKey(), ((JsonElement)var6.getValue()).deepCopy());
               }
            }
         }
      }

      return var2;
   }

   private static JsonArray i_method_53c3ab68() {
      JsonArray var0 = new JsonArray();
      AssistModule var1 = RockstarClient.getInstance().getModuleManager().getModule(AssistModule.class);
      if (var1 == null) {
         return var0;
      } else {
         for (iIiIIiII_Class165 var3 : var1.II_method_6ba8ace5()) {
            JsonObject var4 = new JsonObject();
            var4.addProperty("name", var3.I_method_cca0c514());
            var4.addProperty("key", var3.I_method_75fee8ff());
            var4.add("settings", I_method_609390bb(var3.getSettings(), var3.I_method_cca0c514()));
            var0.add(var4);
         }

         return var0;
      }
   }

   public static IIiiiiIi_Class62.Nested1_b7c42cf3 I_method_f332e29a(JsonObject var0) {
      if (var0 == null) {
         return IIiiiiIi_Class62.Nested1_b7c42cf3.II_field_becfa1dc;
      } else {
         JsonArray var1 = I_method_10f0f634(var0);
         if (var1 == null) {
            RockstarClient.I_field_ab0f6068
               .warn(
                  "Config: \u043e\u0442\u0441\u0443\u0442\u0441\u0442\u0432\u0443\u0435\u0442 \u043c\u0430\u0441\u0441\u0438\u0432 \u043c\u043e\u0434\u0443\u043b\u0435\u0439"
               );
            return IIiiiiIi_Class62.Nested1_b7c42cf3.II_field_becfa1dc;
         } else {
            I_field_a567c40b.clear();
            i_field_a567c40b.clear();

            try {
               I_method_16b850ac();
               boolean var2 = true;

               for (JsonElement var4 : var1) {
                  if (var4.isJsonObject()) {
                     if (!I_method_dbe60e5c(var4.getAsJsonObject())) {
                        var2 = false;
                     }
                  } else {
                     var2 = false;
                  }
               }

               if (var0.has("espElements")) {
                  if (var0.get("espElements").isJsonArray()) {
                     try {
                        IiiiiiiI_Class127.I_method_e1e653cb().I_method_5aa9e4a0(var0.getAsJsonArray("espElements"));
                     } catch (Exception var5) {
                        RockstarClient.I_field_ab0f6068
                           .warn(
                              "Config: \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0437\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044c \u044d\u043b\u0435\u043c\u0435\u043d\u0442\u044b ESP",
                              var5
                           );
                        var2 = false;
                     }
                  } else {
                     var2 = false;
                  }
               }

               if (var0.has("macroMenu")) {
                  if (var0.get("macroMenu").isJsonArray()) {
                     if (!I_method_5189f8c4(var0.getAsJsonArray("macroMenu"))) {
                        var2 = false;
                     }
                  } else {
                     var2 = false;
                  }
               }

               return var2 ? IIiiiiIi_Class62.Nested1_b7c42cf3.I_field_becfa1dc : IIiiiiIi_Class62.Nested1_b7c42cf3.i_field_becfa1dc;
            } catch (Exception var6) {
               RockstarClient.I_field_ab0f6068
                  .error(
                     "Config: \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u043f\u0440\u0438\u043c\u0435\u043d\u0438\u0442\u044c \u043a\u043e\u043d\u0444\u0438\u0433",
                     var6
                  );
               I_field_a567c40b.clear();
               i_field_a567c40b.clear();
               return IIiiiiIi_Class62.Nested1_b7c42cf3.II_field_becfa1dc;
            }
         }
      }
   }

   public static boolean I_method_304dd711(ModuleEntry var0) {
      if (var0 == null) {
         return false;
      } else {
         JsonObject var1 = I_field_a567c40b.remove(var0.getName());
         return var1 == null ? false : I_method_dbe60e5c(var1);
      }
   }

   public static boolean I_method_c807f2fd(ModuleEntry var0, Setting var1) {
      if (var0 != null && var1 != null) {
         JsonObject var2 = i_field_a567c40b.get(var0.getName());
         if (var2 == null) {
            return false;
         } else {
            JsonElement var3;
            synchronized (var2) {
               var3 = var2.remove(var1.getName());
            }

            if (var3 != null && var1.isValidJson(var3)) {
               try {
                  var1.fromJson(var3);
                  return true;
               } catch (Exception var6) {
                  RockstarClient.I_field_ab0f6068
                     .warn(
                        "Config: \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0437\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044c \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0443 {} \u043c\u043e\u0434\u0443\u043b\u044f {}",
                        new Object[]{var1.getName(), var0.getName(), var6}
                     );
                  return false;
               }
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }

   public static List<String> I_method_624941b() {
      return new ArrayList<>(I_field_a567c40b.keySet());
   }

   public static void I_method_31095b9(JsonObject var0, ModuleEntry var1) {
      if (var0 != null && var1 != null) {
         JsonArray var2 = I_method_10f0f634(var0);
         if (var2 != null) {
            for (JsonElement var4 : var2) {
               if (var4.isJsonObject()) {
                  JsonObject var5 = var4.getAsJsonObject();
                  if (var5.has("name")) {
                     String var6 = var5.get("name").getAsString();
                     if (var6.equalsIgnoreCase(var1.getName()) || var6.replace(" ", "").equalsIgnoreCase(var1.getName().replace(" ", ""))) {
                        if (!(var1 instanceof MenuModule) && var1 instanceof Module var7) {
                           var7.IIi_method_fbc509ec();
                        }

                        I_method_dbe60e5c(var5);
                        return;
                     }
                  }
               }
            }
         }
      }
   }

   private static boolean I_method_dbe60e5c(JsonObject var0) {
      if (var0.has("name") && var0.get("name").isJsonPrimitive()) {
         String var1 = var0.get("name").getAsString();

         try {
            ModuleEntry var2 = RockstarClient.getInstance().getModuleManager().getModuleByName(var1);
            boolean var3 = false;
            if (var0.has("enabled")) {
               JsonElement var4 = var0.get("enabled");
               if (!var4.isJsonPrimitive() || !var4.getAsJsonPrimitive().isBoolean()) {
                  return false;
               }

               var3 = var4.getAsBoolean() && !i_method_45e34af1(var2);
            }

            int var10 = -1;
            if (var0.has("key")) {
               JsonElement var5 = var0.get("key");
               if (!var5.isJsonPrimitive() || !var5.getAsJsonPrimitive().isNumber()) {
                  return false;
               }

               double var6 = var5.getAsDouble();
               if (!Double.isFinite(var6) || var6 < -2.1474836E9F || var6 > 2.147483647E9) {
                  return false;
               }

               var10 = var5.getAsInt();
            }

            if (!(var2 instanceof MenuModule)) {
               var2.setEnabled(var3, true);
            }

            var2.setKeybind(var10);
            if (var0.has("settings") && var0.get("settings").isJsonObject()) {
               JsonObject var11 = var0.getAsJsonObject("settings");
               return I_method_88280957(var2.getSettings(), var11, var2.getName());
            } else {
               return !var0.has("settings");
            }
         } catch (iiIIiIiI_Class203 var8) {
            I_field_a567c40b.put(var1, var0.deepCopy());
            RockstarClient.I_field_ab0f6068
               .warn("Config: \u043d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u044b\u0439 \u043c\u043e\u0434\u0443\u043b\u044c {}", var1);
            return false;
         } catch (Exception var9) {
            RockstarClient.I_field_ab0f6068
               .warn(
                  "Config: \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0437\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044c \u043c\u043e\u0434\u0443\u043b\u044c {}",
                  var1,
                  var9
               );
            return false;
         }
      } else {
         return false;
      }
   }

   private static boolean I_method_88280957(List<Setting> var0, JsonObject var1, String var2) {
      boolean var3 = true;
      HashSet var4 = new HashSet();

      for (Setting var6 : var0) {
         var4.add(var6.getName());
      }

      for (Entry var11 : var1.entrySet()) {
         if (!var4.contains(var11.getKey())) {
            I_method_a3fb6669(var2, (String)var11.getKey(), (JsonElement)var11.getValue());
         }
      }

      for (Setting var12 : var0) {
         if (var1.has(var12.getName())) {
            if (!var12.isValidJson(var1.get(var12.getName()))) {
               RockstarClient.I_field_ab0f6068
                  .warn(
                     "Config: \u043f\u0440\u043e\u043f\u0443\u0449\u0435\u043d\u0430 \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0430 {} \u043c\u043e\u0434\u0443\u043b\u044f {} \u0438\u0437-\u0437\u0430 \u043d\u0435\u0432\u0435\u0440\u043d\u043e\u0433\u043e \u0444\u043e\u0440\u043c\u0430\u0442\u0430",
                     var12.getName(),
                     var2
                  );
               I_method_a3fb6669(var2, var12.getName(), var1.get(var12.getName()));
               var3 = false;
            } else {
               try {
                  var12.fromJson(var1.get(var12.getName()));
               } catch (Exception var8) {
                  RockstarClient.I_field_ab0f6068
                     .warn(
                        "Config: \u043f\u0440\u043e\u043f\u0443\u0449\u0435\u043d\u0430 \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0430 {} \u043c\u043e\u0434\u0443\u043b\u044f {}",
                        new Object[]{var12.getName(), var2, var8}
                     );
                  I_method_a3fb6669(var2, var12.getName(), var1.get(var12.getName()));
                  var3 = false;
               }
            }
         }
      }

      return var3;
   }

   private static void I_method_a3fb6669(String var0, String var1, JsonElement var2) {
      if (var0 != null && var2 != null) {
         JsonObject var3 = i_field_a567c40b.computeIfAbsent(var0, var0x -> new JsonObject());
         synchronized (var3) {
            var3.add(var1, var2.deepCopy());
         }
      }
   }

   public static void I_method_16b850ac() {
      for (ModuleEntry var1 : I_method_17bd4f9b()) {
         if (!(var1 instanceof MenuModule) && var1 instanceof Module var2) {
            var2.IIi_method_fbc509ec();
         }
      }
   }

   private static boolean I_method_5189f8c4(JsonArray var0) {
      AssistModule var1 = RockstarClient.getInstance().getModuleManager().getModule(AssistModule.class);
      if (var1 != null && var0 != null) {
         HashMap var2 = new HashMap();

         for (iIiIIiII_Class165 var4 : var1.i_method_78846a68()) {
            var2.put(var4.I_method_cca0c514(), var4);
         }

         ArrayList var12 = new ArrayList();
         boolean var13 = true;

         for (JsonElement var6 : var0) {
            if (!var6.isJsonObject()) {
               var13 = false;
            } else {
               JsonObject var7 = var6.getAsJsonObject();
               if (var7.has("name") && var7.get("name").isJsonPrimitive()) {
                  iIiIIiII_Class165 var8 = (iIiIIiII_Class165)var2.get(var7.get("name").getAsString());
                  if (var8 == null) {
                     var13 = false;
                  } else {
                     if (var7.has("key")) {
                        JsonElement var9 = var7.get("key");
                        if (!var9.isJsonPrimitive() || !var9.getAsJsonPrimitive().isNumber()) {
                           var13 = false;
                           continue;
                        }

                        double var10 = var9.getAsDouble();
                        if (!Double.isFinite(var10) || var10 < -2.1474836E9F || var10 > 2.147483647E9) {
                           var13 = false;
                           continue;
                        }

                        var8.I_method_49deab77(var9.getAsInt());
                     }

                     if (var7.has("settings")) {
                        if (!var7.get("settings").isJsonObject()) {
                           var13 = false;
                           continue;
                        }

                        if (!I_method_88280957(var8.getSettings(), var7.getAsJsonObject("settings"), var8.I_method_cca0c514())) {
                           var13 = false;
                        }
                     }

                     var12.add(var8);
                  }
               } else {
                  var13 = false;
               }
            }
         }

         var1.i_method_72c2f8f0(var12);
         return var13;
      } else {
         return false;
      }
   }

   private static JsonArray I_method_10f0f634(JsonObject var0) {
      return var0.has("modules") && var0.get("modules").isJsonArray() ? var0.getAsJsonArray("modules") : null;
   }

   private static boolean i_method_45e34af1(ModuleEntry var0) {
      ModuleInfo var1 = var0.getClass().getAnnotation(ModuleInfo.class);
      return var1 != null && var1.enabledByDefault();
   }

   public static enum Nested1_b7c42cf3 {
      I_field_becfa1dc,
      i_field_becfa1dc,
      II_field_becfa1dc;
   }
}
