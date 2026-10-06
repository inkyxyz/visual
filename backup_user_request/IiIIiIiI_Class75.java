package rockstar.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Generated;
import net.minecraft.util.math.Vec3d;
import pyrock.utility.render.ColorRGBA;

@IiIIiIIi_Class74(
   I_method_81df7d74 = "client"
)
public class IiIIiIiI_Class75 extends IiIIIiii_Class72 implements iIIiIIiIi_Class294 {
   private static final Map<String, JsonObject> I_field_a567c40b = new ConcurrentHashMap<>();
   private int I_field_49;
   private int i_field_49;
   private volatile boolean I_field_5a;
   private volatile boolean i_field_5a;

   @Override
   public void I_method_fb62088c() {
      try {
         IiIIiIII_Class73.I_method_3b2973c6(this.I_field_3a58077, this.i_field_5a ? new JsonObject() : this.I_method_df2d26d6());
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }

   public JsonObject I_method_df2d26d6() {
      JsonObject var1 = new JsonObject();
      var1.addProperty("username", I_field_3a9bda27.getSession().getUsername());
      var1.addProperty("language", IiIiIIII_Class81.I_method_21a4cfeb().name());
      var1.addProperty("themeMode", RockstarClient.getInstance().I_method_9a720c62().I_method_ac8a0395().name());
      var1.add("themeData", IiiiiIIIi_Class242.I_method_5ac4a715().I_method_1acf19a3());
      var1.addProperty("swing", RockstarClient.getInstance().I_method_11732eb().I_method_5c4a8d74());
      var1.add("hudElements", this.I_method_7c974fc8());
      var1.add("friends", this.ii_method_75a14591());
      var1.add("staff", this.i_method_922cc3a8());
      var1.add("colorPickerPresets", this.IIi_method_5d9bfcc8());
      var1.add("password", this.III_method_480688e8());
      var1.add("waypoints", this.II_method_c2f2c991());
      var1.add("macros", this.iI_method_600bd1b1());
      var1.add("enabledScripts", this.Ii_method_d8883d71());
      String var2 = RockstarClient.getInstance().I_method_5198232b().I_method_5c2e4534();
      if (var2 != null) {
         var1.addProperty("lastConfig", var2);
      }

      var1.addProperty("autoSaveConfigs", RockstarClient.getInstance().I_method_5198232b().I_method_7ce4a4f0());
      var1.addProperty("hitIslandBestScore", this.I_field_49);
      var1.addProperty("hitIslandGamesPlayed", this.i_field_49);
      return var1;
   }

   public JsonObject i_method_7c462ef6() {
      return this.I_method_df2d26d6();
   }

   @Override
   public void i_method_fb70946c() {
      try {
         try (FileReader var1 = new FileReader(this.I_method_aa990001())) {
            JsonObject var2 = (JsonObject)IiIIiIII_Class73.I_field_fbd77e28.fromJson(var1, JsonObject.class);
            if (var2 != null) {
               IiIIiIiI_Class75.Nested1_a5b02cb3 var3 = this.i_method_1af942ba(var2);
               if (var3.I_method_b1a8ceeb() && !var3.i_method_b1b75acb()) {
                  this.I_method_fb62088c();
               }

               return;
            }

            this.Ii_method_d4d567d5();
         }
      } catch (Exception var6) {
         this.Ii_method_d4d567d5();
         RockstarClient.I_field_ab0f6068.error("Failed to read client data", var6);
      }
   }

   public IiIIiIiI_Class75.Nested1_a5b02cb3 I_method_43faa9a(JsonObject var1) {
      return this.i_method_1af942ba(var1);
   }

   public IiIIiIiI_Class75.Nested1_a5b02cb3 i_method_1af942ba(JsonObject var1) {
      if (var1 == null) {
         this.I_field_5a = true;
         return new IiIIiIiI_Class75.Nested1_a5b02cb3(false, true);
      } else {
         boolean var2 = false;
         boolean var3 = false;
         if (var1.has("password")) {
            try {
               this.II_method_6557a7d7(var1.getAsJsonArray("password"));
            } catch (Exception var22) {
               var3 = true;
               this.I_method_daa5f564("password", var1, var22);
            }
         }

         if (var1.has("swing")) {
            try {
               String var4 = var1.get("swing").getAsString();
               iiIIIIIi_Class194 var5 = RockstarClient.getInstance().I_method_11732eb();
               iiIIiIII_Class201 var6 = RockstarClient.getInstance().I_method_2da230b().I_method_9c83fef9(var4, true);
               if (var6 != null) {
                  var6.I_method_84c8a0ec();
               } else {
                  for (iiIIIiii_Class200 var8 : var5.I_method_c2ce901b()) {
                     if (var8.I_method_62860974().equals(var4)) {
                        var5.I_method_3912c30d(var8);
                     }
                  }
               }
            } catch (Exception var27) {
               var3 = true;
               this.I_method_daa5f564("swing", var1, var27);
            }
         }

         if (var1.has("language")) {
            try {
               try {
                  IiIiIIII_Class81.I_method_9b03faed(IiIIiiii_Class80.valueOf(var1.get("language").getAsString()));
               } catch (IllegalArgumentException var20) {
               }
            } catch (Exception var21) {
               var3 = true;
               this.I_method_daa5f564("language", var1, var21);
            }
         }

         if (var1.has("themeMode") || var1.has("theme")) {
            try {
               String var28 = var1.has("themeMode") ? var1.get("themeMode").getAsString() : null;
               if (var28 != null) {
                  try {
                     RockstarClient.getInstance().I_method_9a720c62().I_method_ca5f6cc7(IiIIIiIii_Class140.valueOf(var28));
                  } catch (IllegalArgumentException var18) {
                     RockstarClient.I_field_ab0f6068.warn("Unknown theme mode in client data: {}", var28);
                  }
               } else {
                  try {
                     RockstarClient.getInstance().I_method_9a720c62().I_method_ca5f6cc7(IiIIIiIii_Class140.valueOf(var1.get("theme").getAsString()));
                  } catch (IllegalArgumentException var17) {
                  }
               }
            } catch (Exception var19) {
               var3 = true;
               this.I_method_daa5f564("theme", var1, var19);
            }
         }

         if (var1.has("friends")) {
            try {
               JsonArray var29 = var1.getAsJsonArray("friends");
               ArrayList var33 = new ArrayList();

               for (JsonElement var42 : var29) {
                  var33.add(var42 != null && !var42.isJsonNull() ? var42.getAsString() : null);
               }

               var2 = RockstarClient.getInstance().I_method_7a5acaeb().I_method_7d4521a1(var33);
            } catch (Exception var26) {
               var3 = true;
               this.I_method_daa5f564("friends", var1, var26);
            }
         }

         if (var1.has("staff")) {
            try {
               JsonArray var30 = var1.getAsJsonArray("staff");
               IiIIIiii_Class72 var34 = RockstarClient.getInstance().I_method_7a4c3f0b().I_method_3272b401("staff");
               if (var34 == null || !var34.I_method_aa990001().exists()) {
                  ArrayList var39 = new ArrayList();

                  for (JsonElement var44 : var30) {
                     if (var44.isJsonObject()) {
                        JsonObject var9 = var44.getAsJsonObject();
                        var39.add(
                           new IiIIIIiii_Class136.Nested1_739d8c40(
                              var9.has("name") ? var9.get("name").getAsString() : "", var9.has("prefix") ? var9.get("prefix").getAsString() : ""
                           )
                        );
                     } else if (var44.isJsonPrimitive()) {
                        var39.add(new IiIIIIiii_Class136.Nested1_739d8c40(var44.getAsString(), "MODER"));
                     }
                  }

                  RockstarClient.getInstance().I_method_98af9842().i_method_74e1fa90(var39);
                  if (var34 != null) {
                     RockstarClient.getInstance().I_method_7a4c3f0b().i_method_6702f2ed(var34);
                  }
               }
            } catch (Exception var25) {
               var3 = true;
               this.I_method_daa5f564("staff", var1, var25);
            }
         }

         if (var1.has("colorPickerPresets")) {
            try {
               this.i_method_7d5cf0a0(var1.getAsJsonArray("colorPickerPresets"));
            } catch (Exception var16) {
               var3 = true;
               this.I_method_daa5f564("colorPickerPresets", var1, var16);
            }
         }

         if (var1.has("waypoints")) {
            try {
               this.I_method_e043e880(var1.getAsJsonArray("waypoints"));
            } catch (Exception var15) {
               var3 = true;
               this.I_method_daa5f564("waypoints", var1, var15);
            }
         }

         if (var1.has("macros")) {
            try {
               this.Ii_method_270aff7(var1.getAsJsonArray("macros"));
            } catch (Exception var14) {
               var3 = true;
               this.I_method_daa5f564("macros", var1, var14);
            }
         }

         if (var1.has("enabledScripts")) {
            try {
               ArrayList var31 = new ArrayList();

               for (JsonElement var40 : var1.getAsJsonArray("enabledScripts")) {
                  if (var40 != null && var40.isJsonPrimitive()) {
                     var31.add(var40.getAsString());
                  }
               }

               IIiiIIiiI_Class103 var36 = RockstarClient.getInstance().I_method_a90eb842();
               if (var36 != null) {
                  var36.I_method_a36eb6b0(var31);
               }
            } catch (Exception var24) {
               var3 = true;
               this.I_method_daa5f564("enabledScripts", var1, var24);
            }
         }

         if (var1.has("hudElements")) {
            try {
               for (JsonElement var41 : var1.getAsJsonArray("hudElements")) {
                  this.I_method_246a169c(var41.getAsJsonObject());
               }
            } catch (Exception var23) {
               var3 = true;
               this.I_method_daa5f564("hudElements", var1, var23);
            }
         }

         if (var1.has("hitIslandBestScore")) {
            try {
               this.I_field_49 = var1.get("hitIslandBestScore").getAsInt();
            } catch (Exception var13) {
               var3 = true;
               this.I_method_daa5f564("hitIslandBestScore", var1, var13);
            }
         }

         if (var1.has("hitIslandGamesPlayed")) {
            try {
               this.i_field_49 = var1.get("hitIslandGamesPlayed").getAsInt();
            } catch (Exception var12) {
               var3 = true;
               this.I_method_daa5f564("hitIslandGamesPlayed", var1, var12);
            }
         }

         if (var1.has("themeData")) {
            try {
               IiiiiIIIi_Class242.I_method_169cf8c7(IiIIIiiIi_Class142.I_method_3f43a761(var1.getAsJsonObject("themeData")));
            } catch (Exception var11) {
               var3 = true;
               this.I_method_daa5f564("themeData", var1, var11);
            }
         }

         if (var1.has("autoSaveConfigs")) {
            try {
               RockstarClient.getInstance().I_method_5198232b().I_method_1fb0ab68(var1.get("autoSaveConfigs").getAsBoolean());
            } catch (Exception var10) {
               var3 = true;
               this.I_method_daa5f564("autoSaveConfigs", var1, var10);
            }
         }

         if (var1.has("lastConfig")) {
            try {
               RockstarClient.getInstance().I_method_5198232b().i_method_9f123f96(var1.get("lastConfig").getAsString());
            } catch (Exception var9x) {
               var3 = true;
               this.I_method_daa5f564("lastConfig", var1, var9x);
            }
         }

         return new IiIIiIiI_Class75.Nested1_a5b02cb3(var2, var3);
      }
   }

   public void II_method_d4c6dbf5() {
      this.I_field_5a = false;
   }

   private void I_method_daa5f564(String var1, JsonObject var2, Exception var3) {
      this.I_field_5a = true;
      this.I_method_246a1698(var2);
      RockstarClient.I_field_ab0f6068.error("Failed to load {} from client data", var1, var3);
   }

   private void I_method_246a1698(JsonObject var1) {
      try {
         IiIIiIII_Class73.I_method_3b2973c6(new File(this.I_method_aa990001().getPath() + ".broken"), var1);
      } catch (IOException var3) {
         RockstarClient.I_field_ab0f6068.error("Failed to preserve broken client data", var3);
      }
   }

   private void Ii_method_d4d567d5() {
      this.I_field_5a = true;

      try {
         Files.copy(this.I_method_aa990001().toPath(), new File(this.I_method_aa990001().getPath() + ".broken").toPath(), StandardCopyOption.REPLACE_EXISTING);
      } catch (IOException var2) {
         RockstarClient.I_field_ab0f6068.error("Failed to preserve broken client data", var2);
      }
   }

   private JsonArray I_method_7c974fc8() {
      JsonArray var1 = new JsonArray();
      HashSet var2 = new HashSet();

      for (IiIiIIiII_Class165 var4 : RockstarClient.getInstance().I_method_35687482().III_method_812fc188()) {
         var2.add(var4.getName());
         var1.add(this.I_method_936b1d08(var4));
      }

      for (Entry var6 : I_field_a567c40b.entrySet()) {
         if (!var2.contains(var6.getKey())) {
            var1.add(((JsonObject)var6.getValue()).deepCopy());
         }
      }

      return var1;
   }

   public static void I_method_64a87fb6(String var0) {
      if (var0 != null) {
         I_field_a567c40b.remove(var0);
      }
   }

   private JsonObject I_method_936b1d08(IiIiIIiII_Class165 var1) {
      JsonObject var2 = new JsonObject();
      var2.addProperty("name", var1.getName());
      var2.addProperty("x", var1.getX());
      var2.addProperty("y", var1.getY());
      var2.addProperty("showing", var1.isShowing());
      var2.addProperty("scale", var1.getScale());
      var2.add("settings", this.i_method_310e00e8(var1));
      return var2;
   }

   public static void I_method_6a4509fa(IiIiIIiII_Class165 var0) {
      if (var0 != null) {
         if (RockstarClient.getInstance().I_method_7a4c3f0b().I_method_3272b401("client") instanceof IiIIiIiI_Class75 var1) {
            try {
               I_field_a567c40b.put(var0.getName(), var1.I_method_936b1d08(var0));
            } catch (Exception var3) {
               RockstarClient.I_field_ab0f6068
                  .warn(
                     "\u041d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0441\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c \u0441\u043e\u0441\u0442\u043e\u044f\u043d\u0438\u0435 hud-\u044d\u043b\u0435\u043c\u0435\u043d\u0442\u0430 {}",
                     var0.getName(),
                     var3
                  );
            }
         }
      }
   }

   public boolean I_method_6a4509fe(IiIiIIiII_Class165 var1) {
      if (var1 == null) {
         return false;
      } else {
         JsonObject var2 = I_field_a567c40b.get(var1.getName());
         if (var2 != null) {
            return this.I_method_a29900d2(var2, var1);
         } else if (this.I_method_aa990001() != null && this.I_method_aa990001().exists()) {
            try (FileReader var3 = new FileReader(this.I_method_aa990001())) {
               JsonObject var4 = (JsonObject)IiIIiIII_Class73.I_field_fbd77e28.fromJson(var3, JsonObject.class);
               if (var4 == null || !var4.has("hudElements")) {
                  return false;
               } else {
                  for (JsonElement var7 : var4.getAsJsonArray("hudElements")) {
                     JsonObject var8 = var7.getAsJsonObject();
                     if (var8.has("name")) {
                        String var9 = var8.get("name").getAsString();
                        if (var1.getName().equalsIgnoreCase(var9)) {
                           return this.I_method_a29900d2(var8, var1);
                        }
                     }
                  }

                  return false;
               }
            } catch (Exception var13) {
               RockstarClient.I_field_ab0f6068.error("Failed to apply saved HUD state for {}", var1.getName(), var13);
               return false;
            }
         } else {
            return false;
         }
      }
   }

   public void I_method_759d87f5(Iterable<? extends IiIiIIiII_Class165> var1) {
      if (var1 != null) {
         ArrayList var2 = new ArrayList();

         for (IiIiIIiII_Class165 var4 : var1) {
            if (var4 != null) {
               JsonObject var5 = I_field_a567c40b.get(var4.getName());
               if (var5 != null) {
                  this.I_method_a29900d2(var5, var4);
               } else {
                  var2.add(var4);
               }
            }
         }

         if (!var2.isEmpty() && this.I_method_aa990001() != null && this.I_method_aa990001().exists()) {
            try {
               try (FileReader var14 = new FileReader(this.I_method_aa990001())) {
                  JsonObject var15 = (JsonObject)IiIIiIII_Class73.I_field_fbd77e28.fromJson(var14, JsonObject.class);
                  if (var15 != null && var15.has("hudElements")) {
                     JsonArray var16 = var15.getAsJsonArray("hudElements");

                     for (IiIiIIiII_Class165 var7 : (Iterable<IiIiIIiII_Class165>)(Iterable<?>)var2) {
                        for (JsonElement var9 : var16) {
                           JsonObject var10 = var9.getAsJsonObject();
                           if (var10.has("name") && var7.getName().equalsIgnoreCase(var10.get("name").getAsString())) {
                              this.I_method_a29900d2(var10, var7);
                              break;
                           }
                        }
                     }

                     return;
                  }
               }
            } catch (Exception var13) {
               RockstarClient.I_field_ab0f6068.error("Failed to apply saved HUD settings", var13);
            }
         }
      }
   }

   private boolean I_method_246a169c(JsonObject var1) {
      if (var1 != null && var1.has("name")) {
         String var2 = var1.get("name").getAsString();
         I_field_a567c40b.put(var2, var1.deepCopy());
         IiIiIIiII_Class165 var3 = RockstarClient.getInstance().I_method_35687482().I_method_ce2cb1f(var2);
         return var3 != null && this.I_method_a29900d2(var1, var3);
      } else {
         return false;
      }
   }

   private boolean I_method_a29900d2(JsonObject var1, IiIiIIiII_Class165 var2) {
      if (var1 != null && var2 != null) {
         if (var1.has("x")) {
            var2.setX(var1.get("x").getAsFloat());
         }

         if (var1.has("y")) {
            var2.setY(var1.get("y").getAsFloat());
         }

         if (var1.has("showing")) {
            var2.setShowing(var1.get("showing").getAsBoolean());
         }

         if (var1.has("scale")) {
            var2.setScale(var1.get("scale").getAsFloat());
         }

         if (var1.has("settings")) {
            JsonObject var3 = var1.getAsJsonObject("settings");

            for (Setting var5 : var2.getSettings()) {
               if (var3.has(var5.getName())) {
                  var5.fromJson(var3.get(var5.getName()));
               }
            }
         }

         return true;
      } else {
         return false;
      }
   }

   private JsonObject i_method_310e00e8(IiIiIIiII_Class165 var1) {
      JsonObject var2 = new JsonObject();

      for (Setting var4 : var1.getSettings()) {
         var2.add(var4.getName(), var4.toJson());
      }

      return var2;
   }

   private JsonArray i_method_922cc3a8() {
      JsonArray var1 = new JsonArray();

      for (IiIIIIiii_Class136.Nested1_739d8c40 var3 : RockstarClient.getInstance().I_method_98af9842().I_method_f4439a28()) {
         if (var3.I_method_13877866() != null && !var3.I_method_13877866().isBlank()) {
            JsonObject var4 = new JsonObject();
            var4.addProperty("name", var3.I_method_13877866());
            var4.addProperty("prefix", var3.i_method_a6a62886());
            var1.add(var4);
         }
      }

      return var1;
   }

   private JsonArray II_method_c2f2c991() {
      JsonArray var1 = new JsonArray();
      IiIIiIIII_Class145 var2 = RockstarClient.getInstance().I_method_cf3ba442();
      if (var2 == null) {
         return var1;
      } else {
         for (Entry var4 : var2.I_method_173f1fee()) {
            JsonObject var5 = new JsonObject();
            var5.addProperty("name", (String)var4.getKey());
            var5.addProperty("x", ((Vec3d)var4.getValue()).x);
            var5.addProperty("y", ((Vec3d)var4.getValue()).y);
            var5.addProperty("z", ((Vec3d)var4.getValue()).z);
            var1.add(var5);
         }

         return var1;
      }
   }

   private JsonArray Ii_method_d8883d71() {
      JsonArray var1 = new JsonArray();
      IIiiIIiiI_Class103 var2 = RockstarClient.getInstance().I_method_a90eb842();
      if (var2 != null) {
         for (String var4 : var2.I_method_ac507a28()) {
            var1.add(var4);
         }
      }

      return var1;
   }

   private JsonArray iI_method_600bd1b1() {
      JsonArray var1 = new JsonArray();
      if (RockstarClient.getInstance().I_method_af32eeab() == null) {
         return var1;
      } else {
         for (IiIiIIii_Class84 var3 : RockstarClient.getInstance().I_method_af32eeab().I_method_e1cbbc5b()) {
            JsonObject var4 = new JsonObject();
            var4.addProperty("key", var3.I_method_886a907f());
            var4.addProperty("command", var3.I_method_f1090d94());
            var1.add(var4);
         }

         return var1;
      }
   }

   private void I_method_e043e880(JsonArray var1) {
      IiIIiIIII_Class145 var2 = RockstarClient.getInstance().I_method_cf3ba442();
      if (var2 != null) {
         HashMap var3 = new HashMap();

         for (JsonElement var5 : var1) {
            JsonObject var6 = var5.getAsJsonObject();
            String var7 = var6.get("name").getAsString();
            double var8 = var6.get("x").getAsDouble();
            double var10 = var6.get("y").getAsDouble();
            double var12 = var6.get("z").getAsDouble();
            var3.put(var7, new Vec3d(var8, var10, var12));
         }

         var2.I_method_c8101766(var3);
      }
   }

   private JsonArray ii_method_75a14591() {
      JsonArray var1 = new JsonArray();

      for (String var3 : RockstarClient.getInstance().I_method_7a5acaeb().I_method_dbf3f81b()) {
         if (var3 != null && !var3.isBlank()) {
            var1.add(var3);
         }
      }

      return var1;
   }

   private JsonArray III_method_480688e8() {
      JsonArray var1 = new JsonArray();

      for (Entry var3 : RockstarClient.getInstance().getModuleManager().getModule(AutoAuthModule.class).i_method_cfdbf9f4().entrySet()) {
         JsonObject var4 = new JsonObject();
         var4.addProperty("nick", (String)var3.getKey());
         var4.addProperty("pass", (String)var3.getValue());
         var1.add(var4);
      }

      return var1;
   }

   private JsonArray IIi_method_5d9bfcc8() {
      JsonArray var1 = new JsonArray();

      for (IiIIiIiII_Class149.Nested1_1055f060 var4 : IiIIiIiII_Class149.I_field_7865b31) {
         if (var4.I_method_e5b4f5e()) {
            JsonObject var5 = new JsonObject();
            ColorRGBA var6 = var4.I_method_79cacdc9();
            var5.addProperty("red", var6.getRed());
            var5.addProperty("green", var6.getGreen());
            var5.addProperty("blue", var6.getBlue());
            var5.addProperty("alpha", var6.getAlpha());
            var1.add(var5);
         }
      }

      return var1;
   }

   private void i_method_7d5cf0a0(JsonArray var1) {
      ArrayList var2 = new ArrayList();

      for (JsonElement var4 : var1) {
         JsonObject var5 = var4.getAsJsonObject();
         float var6 = var5.get("red").getAsFloat();
         float var7 = var5.get("green").getAsFloat();
         float var8 = var5.get("blue").getAsFloat();
         float var9 = var5.get("alpha").getAsFloat();
         ColorRGBA var10 = new ColorRGBA(var6, var7, var8, var9);
         var2.add(new IiIIiIiII_Class149.Nested1_1055f060(var10));
      }

      IiIIiIiII_Class149.I_method_9329a910(var2);
   }

   private void II_method_6557a7d7(JsonArray var1) {
      for (JsonElement var3 : var1) {
         JsonObject var4 = var3.getAsJsonObject();
         String var5 = var4.get("nick").getAsString();
         String var6 = var4.get("pass").getAsString();
         RockstarClient.getInstance().getModuleManager().getModule(AutoAuthModule.class).I_method_ee5917b3(var5, var6);
      }
   }

   private void Ii_method_270aff7(JsonArray var1) {
      if (RockstarClient.getInstance().I_method_af32eeab() != null) {
         ArrayList var2 = new ArrayList();

         for (JsonElement var4 : var1) {
            JsonObject var5 = var4.getAsJsonObject();
            int var6 = var5.get("key").getAsInt();
            String var7 = var5.get("command").getAsString();
            var2.add(new IiIiIIii_Class84(var6, var7));
         }

         RockstarClient.getInstance().I_method_af32eeab().I_method_3265e55d(var2);
      }
   }

   @Generated
   public int I_method_512f38df() {
      return this.I_field_49;
   }

   @Generated
   public int i_method_513dc4bf() {
      return this.i_field_49;
   }

   @Generated
   public boolean I_method_512f38f0() {
      return this.I_field_5a;
   }

   @Generated
   public boolean i_method_513dc4d0() {
      return this.i_field_5a;
   }

   @Generated
   public void I_method_d4b85797(int var1) {
      this.I_field_49 = var1;
   }

   @Generated
   public void i_method_d67b47b7(int var1) {
      this.i_field_49 = var1;
   }

   @Generated
   public void I_method_d4b89768(boolean var1) {
      this.I_field_5a = var1;
   }

   @Generated
   public void i_method_d67b8788(boolean var1) {
      this.i_field_5a = var1;
   }

   public static final class Nested1_a5b02cb3 {
      private final boolean I_field_5a;
      private final boolean i_field_5a;

      public Nested1_a5b02cb3(boolean var1, boolean var2) {
         this.I_field_5a = var1;
         this.i_field_5a = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_a5b02cb3[cleanedFriends=" + this.I_field_5a + ", failed=" + this.i_field_5a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_5a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiIIiIiI_Class75.Nested1_a5b02cb3 other = (IiIIiIiI_Class75.Nested1_a5b02cb3) var1;
         return java.util.Objects.equals(this.I_field_5a, other.I_field_5a)
            && java.util.Objects.equals(this.i_field_5a, other.i_field_5a);
      }

      public boolean I_method_b1a8ceeb() {
         return this.I_field_5a;
      }

      public boolean i_method_b1b75acb() {
         return this.i_field_5a;
      }
   }
}
