package rockstar.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import globals.client.api.RockNetClient;
import globals.shared.proto.Packet;
import globals.shared.proto.Packets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import pyrock.events.render.HudRenderEvent;

public class iiiiIiI_Class123 {
   private static final int I_field_49 = 4;
   private final Queue<String> I_field_f2700bf6 = new ConcurrentLinkedQueue<>();
   private final IiIIIiII_Class69<HudRenderEvent> I_field_3d936f41 = var1 -> {
      String var2 = this.I_field_f2700bf6.poll();
      if (var2 != null) {
         i_method_3b51059d(() -> this.I_method_b89c1f2b(var2, true));
      }
   };

   public iiiiIiI_Class123() {
      RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
   }

   public void I_method_80c5740f(Packets.Nested1_c489107f var1) {
      if (var1 != null && var1.reqId() != null && !var1.reqId().isBlank()) {
         String var2 = var1.action();
         switch (var2) {
            case "state":
               I_method_bb1f29bd(() -> this.i_method_ad6180a9(var1.reqId()));
               break;
            case "set":
               I_method_bb1f29bd(() -> {
                  this.i_method_b5fa37ef(var1);
                  this.i_method_ad6180a9(var1.reqId());
               });
               break;
            case "inventory":
               I_method_bb1f29bd(() -> this.I_method_dcaa2cc9(var1.reqId()));
         }
      }
   }

   private static void I_method_bb1f29bd(Runnable var0) {
      MinecraftClient.getInstance().execute(() -> i_method_3b51059d(var0));
   }

   private static void i_method_3b51059d(Runnable var0) {
      try {
         var0.run();
      } catch (Throwable var2) {
         RockstarClient.I_field_ab0f6068
            .error(
               "[AutoFarm] \u0437\u0430\u043f\u0440\u043e\u0441 \u0441 \u0441\u0430\u0439\u0442\u0430 \u043d\u0435 \u0432\u044b\u043f\u043e\u043b\u043d\u0435\u043d",
               var2
            );
      }
   }

   private void I_method_dcaa2cc9(String var1) {
      MinecraftClient var2 = MinecraftClient.getInstance();
      if (var2.player != null && !var2.options.hudHidden) {
         while (this.I_field_f2700bf6.size() >= 4) {
            this.I_field_f2700bf6.poll();
         }

         this.I_field_f2700bf6.add(var1);
      } else {
         this.I_method_b89c1f2b(var1, false);
      }
   }

   private void i_method_ad6180a9(String var1) {
      JsonObject var2 = new JsonObject();
      var2.addProperty("reqId", var1);
      MinecraftClient var3 = MinecraftClient.getInstance();
      var2.addProperty("inGame", var3.player != null && var3.world != null);
      AutoFarmModule var4 = I_method_bfa83175();
      boolean var5 = var4 != null && var4.isEnabled();
      var2.addProperty("enabled", var5);
      ModeSetting var6 = var4 == null ? null : I_method_fa0934bd(var4);
      ModeSetting.Nested1_42765c60 var7 = var6 == null ? null : var6.i_method_f85f3850();
      var2.addProperty("mode", var7 == null ? "" : IiIiIIII_Class81.I_method_f25a980a(var7.getName()));
      JsonArray var8 = new JsonArray();
      if (var4 != null && var5) {
         for (Setting var10 : List.copyOf(var4.getSettings())) {
            if (var10 != var6 && var10.isVisible()) {
               JsonObject var11 = I_method_291650db(var10);
               if (var11 != null) {
                  var8.add(var11);
               }
            }
         }
      }

      var2.add("settings", var8);
      I_method_7652e0e8(new Packets.Nested1_e8939e81(var2));
   }

   private static JsonObject I_method_291650db(Setting var0) {
      JsonObject var1 = new JsonObject();
      var1.addProperty("key", var0.getName());
      var1.addProperty("label", IiIiIIII_Class81.I_method_f25a980a(var0.getName()));
      if (var0 instanceof BooleanSetting var10) {
         var1.addProperty("type", "boolean");
         var1.addProperty("value", var10.i_method_9b12da03());
         return var1;
      } else if (var0 instanceof SliderSetting var9) {
         var1.addProperty("type", "slider");
         var1.addProperty("value", var9.Ii_method_a20abcd2());
         var1.addProperty("min", var9.I_method_b2a48e2f());
         var1.addProperty("max", var9.i_method_b2b31a0f());
         var1.addProperty("step", var9.II_method_a1fc30f2());
         var1.addProperty("suffix", var9.II_method_d429a7de().trim());
         return var1;
      } else if (var0 instanceof TextSetting var8) {
         var1.addProperty("type", "string");
         var1.addProperty("value", var8.II_method_da016c1e() == null ? "" : var8.II_method_da016c1e());
         var1.addProperty("numberOnly", var8.i_method_9b12da03());
         return var1;
      } else if (var0 instanceof MultiSelectSetting var7) {
         var1.addProperty("type", "select");
         var1.addProperty("min", var7.I_method_1fb7ca12());
         JsonArray var11 = new JsonArray();

         for (MultiSelectSetting.Nested1_42856060 var13 : List.copyOf(var7.I_method_45aaa648())) {
            if (!var13.isHidden()) {
               var11.add(I_method_44515137(var13.getName(), var7.i_method_faf6de68().contains(var13)));
            }
         }

         var1.add("options", var11);
         return var1;
      } else if (var0 instanceof ModeSetting var2) {
         var1.addProperty("type", "mode");
         ModeSetting.Nested1_42765c60 var3 = var2.i_method_f85f3850();
         var1.addProperty("value", var3 == null ? "" : IiIiIIII_Class81.I_method_f25a980a(var3.getName()));
         JsonArray var4 = new JsonArray();

         for (ModeSetting.Nested1_42765c60 var6 : List.copyOf(var2.I_method_e1d4a248())) {
            if (!var6.isHidden()) {
               var4.add(I_method_44515137(var6.getName(), var6 == var3));
            }
         }

         var1.add("options", var4);
         return var1;
      } else {
         return null;
      }
   }

   private static JsonObject I_method_44515137(String var0, boolean var1) {
      JsonObject var2 = new JsonObject();
      var2.addProperty("name", var0);
      var2.addProperty("label", IiIiIIII_Class81.I_method_f25a980a(var0));
      var2.addProperty("on", var1);
      return var2;
   }

   private void i_method_b5fa37ef(Packets.Nested1_c489107f var1) {
      AutoFarmModule var2 = I_method_bfa83175();
      if (var2 != null && var2.isEnabled()) {
         ModeSetting var3 = I_method_fa0934bd(var2);
         Setting var4 = null;

         for (Setting var6 : List.copyOf(var2.getSettings())) {
            if (var6 != var3 && var6.isVisible() && var6.getName().equals(var1.key())) {
               var4 = var6;
               break;
            }
         }

         if (var4 != null) {
            JsonElement var13 = var1.value();
            if (var4 instanceof BooleanSetting var7) {
               var7.I_method_4e1408b5(I_method_e63c064e(var13, !var7.i_method_9b12da03()));
            } else if (var4 instanceof SliderSetting var8) {
               var8.I_method_a1eda161((float)I_method_e63bb3a2(var13, var8.Ii_method_a20abcd2()));
            } else if (var4 instanceof TextSetting var9) {
               var9.I_method_79680a89(I_method_c6f74e0c(var13, var9.II_method_da016c1e()));
            } else if (var4 instanceof MultiSelectSetting var10) {
               MultiSelectSetting.Nested1_42856060 var11 = I_method_1aa5ef62(var10, var1.option());
               if (var11 != null && var10.i_method_faf6de68().contains(var11) != I_method_e63c064e(var13, false)) {
                  var11.toggle();
               }
            } else {
               if (!(var4 instanceof ModeSetting var14)) {
                  return;
               }

               for (ModeSetting.Nested1_42765c60 var12 : List.copyOf(var14.I_method_e1d4a248())) {
                  if (var12.getName().equals(var1.option())) {
                     var12.select();
                     break;
                  }
               }
            }

            RockstarClient.getInstance().I_method_5198232b().II_method_1fbeeff5();
         }
      }
   }

   private static MultiSelectSetting.Nested1_42856060 I_method_1aa5ef62(MultiSelectSetting var0, String var1) {
      for (MultiSelectSetting.Nested1_42856060 var3 : List.copyOf(var0.I_method_45aaa648())) {
         if (var3.getName().equals(var1)) {
            return var3;
         }
      }

      return null;
   }

   private void I_method_b89c1f2b(String var1, boolean var2) {
      JsonObject var3 = new JsonObject();
      var3.addProperty("reqId", var1);
      ClientPlayerEntity var4 = MinecraftClient.getInstance().player;
      if (var4 == null) {
         var3.addProperty("ok", false);
         var3.addProperty("error", "NO_PLAYER");
         I_method_7652e0e8(new Packets.Nested1_24ba7b4c(var3));
      } else {
         var3.addProperty("ok", true);
         var3.addProperty("nickname", var4.getName().getString());
         if (var2) {
            try {
               var3.addProperty("png", Base64.getEncoder().encodeToString(iiiiIii_Class124.I_method_c64ba0bb(var4)));
            } catch (Throwable var7) {
               RockstarClient.I_field_ab0f6068
                  .error(
                     "[AutoFarm] \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u043e\u0442\u0440\u0438\u0441\u043e\u0432\u0430\u0442\u044c \u0438\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044c",
                     var7
                  );
               var3.addProperty("imageError", "RENDER_FAILED");
            }
         } else {
            var3.addProperty("imageError", "HUD_HIDDEN");
         }

         int var5 = 0;

         for (int var6 = 0; var6 < var4.getInventory().main.size(); var6++) {
            if (!((ItemStack)var4.getInventory().main.get(var6)).isEmpty()) {
               var5++;
            }
         }

         var3.addProperty("used", var5);
         var3.addProperty("total", var4.getInventory().main.size());
         var3.add("items", I_method_9fc33b9e(var4));
         I_method_7652e0e8(new Packets.Nested1_24ba7b4c(var3));
      }
   }

   private static JsonArray I_method_9fc33b9e(ClientPlayerEntity var0) {
      LinkedHashMap var1 = new LinkedHashMap();
      ArrayList var2 = new ArrayList(var0.getInventory().main);
      var2.addAll(var0.getInventory().armor);
      var2.addAll(var0.getInventory().offHand);

      for (ItemStack var4 : (Iterable<ItemStack>)(Iterable<?>)var2) {
         if (var4 != null && !var4.isEmpty()) {
            var1.merge(var4.getName().getString(), var4.getCount(), (left, right) -> (Integer)left + (Integer)right);
         }
      }

      JsonArray var5 = new JsonArray();
      var1.entrySet().stream().sorted(Entry.comparingByValue().reversed()).forEach(var1x -> {
         JsonObject var2x = new JsonObject();
         var2x.addProperty("name", (String)((java.util.Map.Entry)var1x).getKey());
         var2x.addProperty("count", (Number)((java.util.Map.Entry)var1x).getValue());
         var5.add(var2x);
      });
      return var5;
   }

   private static AutoFarmModule I_method_bfa83175() {
      return RockstarClient.getInstance().getModuleManager().getModule(AutoFarmModule.class);
   }

   private static ModeSetting I_method_fa0934bd(AutoFarmModule var0) {
      for (Setting var2 : List.copyOf(var0.getSettings())) {
         if (var2 instanceof ModeSetting var3) {
            for (ModeSetting.Nested1_42765c60 var5 : List.copyOf(var3.I_method_e1d4a248())) {
               if (var5 instanceof IIIiiiIii_Class60) {
                  return var3;
               }
            }
         }
      }

      return null;
   }

   private static boolean I_method_e63c064e(JsonElement var0, boolean var1) {
      try {
         return var0 != null && var0.isJsonPrimitive() ? var0.getAsBoolean() : var1;
      } catch (RuntimeException var3) {
         return var1;
      }
   }

   private static double I_method_e63bb3a2(JsonElement var0, double var1) {
      try {
         return var0 != null && var0.isJsonPrimitive() ? var0.getAsDouble() : var1;
      } catch (RuntimeException var4) {
         return var1;
      }
   }

   private static String I_method_c6f74e0c(JsonElement var0, String var1) {
      try {
         return var0 != null && var0.isJsonPrimitive() ? var0.getAsString() : var1;
      } catch (RuntimeException var3) {
         return var1;
      }
   }

   private static void I_method_7652e0e8(Packet var0) {
      RockNetClient var1 = RockstarClient.getInstance().I_method_cd3d46d0();
      if (var1 != null) {
         var1.send(var0);
      }
   }
}
