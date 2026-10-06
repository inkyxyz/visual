package rockstar.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import moscow.rockstar.mixin.accessors.ChatHudAccessor;
import net.minecraft.SharedConstants;
import net.minecraft.client.gui.hud.ChatHudLine;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Vec3d;

public final class IiIiiIIi_Class90 {
   private IiIiiIIi_Class90() {
   }

   public static JsonObject I_method_6b269336() {
      JsonObject var0 = new JsonObject();
      if (iIIiIIiIi_Class294.I_field_3a9bda27.player != null && iIIiIIiIi_Class294.I_field_3a9bda27.world != null) {
         var0.addProperty("inGame", true);
         var0.addProperty("name", iIIiIIiIi_Class294.I_field_3a9bda27.player.getName().getString());
         var0.addProperty("uuid", iIIiIIiIi_Class294.I_field_3a9bda27.player.getUuidAsString());
         Vec3d var1 = iIIiIIiIi_Class294.I_field_3a9bda27.player.getPos();
         var0.add("pos", I_method_53b80104(var1));
         JsonObject var2 = new JsonObject();
         var2.addProperty("x", iIIiIIiIi_Class294.I_field_3a9bda27.player.getBlockX());
         var2.addProperty("y", iIIiIIiIi_Class294.I_field_3a9bda27.player.getBlockY());
         var2.addProperty("z", iIIiIIiIi_Class294.I_field_3a9bda27.player.getBlockZ());
         var0.add("blockPos", var2);
         var0.addProperty("yaw", I_method_2c1e18bf(iIIiIIiIi_Class294.I_field_3a9bda27.player.getYaw(), 2));
         var0.addProperty("pitch", I_method_2c1e18bf(iIIiIIiIi_Class294.I_field_3a9bda27.player.getPitch(), 2));
         var0.addProperty("facing", iIIiIIiIi_Class294.I_field_3a9bda27.player.getHorizontalFacing().asString());
         var0.add("velocity", I_method_53b80104(iIIiIIiIi_Class294.I_field_3a9bda27.player.getVelocity()));
         var0.addProperty("health", I_method_2c1e18bf(iIIiIIiIi_Class294.I_field_3a9bda27.player.getHealth(), 2));
         var0.addProperty("maxHealth", I_method_2c1e18bf(iIIiIIiIi_Class294.I_field_3a9bda27.player.getMaxHealth(), 2));
         var0.addProperty("absorption", I_method_2c1e18bf(iIIiIIiIi_Class294.I_field_3a9bda27.player.getAbsorptionAmount(), 2));
         var0.addProperty("armor", iIIiIIiIi_Class294.I_field_3a9bda27.player.getArmor());
         var0.addProperty("food", iIIiIIiIi_Class294.I_field_3a9bda27.player.getHungerManager().getFoodLevel());
         var0.addProperty("saturation", I_method_2c1e18bf(iIIiIIiIi_Class294.I_field_3a9bda27.player.getHungerManager().getSaturationLevel(), 2));
         var0.addProperty("air", iIIiIIiIi_Class294.I_field_3a9bda27.player.getAir());
         var0.addProperty("xpLevel", iIIiIIiIi_Class294.I_field_3a9bda27.player.experienceLevel);
         var0.addProperty(
            "gameMode",
            iIIiIIiIi_Class294.I_field_3a9bda27.interactionManager == null
               ? "unknown"
               : iIIiIIiIi_Class294.I_field_3a9bda27.interactionManager.getCurrentGameMode().getName()
         );
         var0.addProperty("onGround", iIIiIIiIi_Class294.I_field_3a9bda27.player.isOnGround());
         var0.addProperty("sneaking", iIIiIIiIi_Class294.I_field_3a9bda27.player.isSneaking());
         var0.addProperty("sprinting", iIIiIIiIi_Class294.I_field_3a9bda27.player.isSprinting());
         var0.addProperty("inWater", iIIiIIiIi_Class294.I_field_3a9bda27.player.isTouchingWater());
         var0.addProperty("flying", iIIiIIiIi_Class294.I_field_3a9bda27.player.getAbilities().flying);
         var0.addProperty("alive", iIIiIIiIi_Class294.I_field_3a9bda27.player.isAlive());
         var0.add("hands", IiI_method_fafce1f6());
         var0.add("armorItems", Ii_method_6481a9d1());
         var0.add("effects", I_method_b84508d9(iIIiIIiIi_Class294.I_field_3a9bda27.player.getStatusEffects()));
         LivingEntity var3 = RockstarClient.getInstance().I_method_9a638462().I_method_4517f36c();
         if (var3 != null) {
            JsonObject var4 = new JsonObject();
            var4.addProperty("name", var3.getName().getString());
            var4.addProperty("health", I_method_2c1e18bf(var3.getHealth(), 2));
            var4.addProperty("distance", I_method_2c1e18bf(iIIiIIiIi_Class294.I_field_3a9bda27.player.distanceTo(var3), 2));
            var0.add("combatTarget", var4);
         }

         return var0;
      } else {
         var0.addProperty("inGame", false);
         var0.addProperty(
            "account", iIIiIIiIi_Class294.I_field_3a9bda27.getSession() == null ? "?" : iIIiIIiIi_Class294.I_field_3a9bda27.getSession().getUsername()
         );
         return var0;
      }
   }

   public static JsonObject i_method_83f9b56() {
      JsonObject var0 = new JsonObject();
      if (iIIiIIiIi_Class294.I_field_3a9bda27.world == null) {
         var0.addProperty("loaded", false);
         return var0;
      } else {
         var0.addProperty("loaded", true);
         var0.addProperty("dimension", iIIiIIiIi_Class294.I_field_3a9bda27.world.getRegistryKey().getValue().toString());
         var0.addProperty("time", iIIiIIiIi_Class294.I_field_3a9bda27.world.getTimeOfDay() % 24000L);
         var0.addProperty("day", iIIiIIiIi_Class294.I_field_3a9bda27.world.getTimeOfDay() / 24000L);
         var0.addProperty("raining", iIIiIIiIi_Class294.I_field_3a9bda27.world.isRaining());
         var0.addProperty("thundering", iIIiIIiIi_Class294.I_field_3a9bda27.world.isThundering());
         var0.addProperty("difficulty", iIIiIIiIi_Class294.I_field_3a9bda27.world.getDifficulty().getName());
         var0.addProperty("playersAround", iIIiIIiIi_Class294.I_field_3a9bda27.world.getPlayers().size());
         if (iIIiIIiIi_Class294.I_field_3a9bda27.player != null) {
            var0.addProperty(
               "biome", iIIiIIiIi_Class294.I_field_3a9bda27.world.getBiome(iIIiIIiIi_Class294.I_field_3a9bda27.player.getBlockPos()).getIdAsString()
            );
            var0.addProperty("light", iIIiIIiIi_Class294.I_field_3a9bda27.world.getLightLevel(iIIiIIiIi_Class294.I_field_3a9bda27.player.getBlockPos()));
         }

         return var0;
      }
   }

   public static JsonObject II_method_577505cd() {
      JsonObject var0 = new JsonObject();
      var0.addProperty("connected", iIIiIIiIi_Class294.I_field_3a9bda27.getNetworkHandler() != null);
      var0.addProperty("singleplayer", iIIiIIiIi_Class294.I_field_3a9bda27.isInSingleplayer());
      ServerInfo var1 = iIIiIIiIi_Class294.I_field_3a9bda27.getCurrentServerEntry();
      if (var1 != null) {
         var0.addProperty("address", var1.address);
         var0.addProperty("name", var1.name);
         var0.addProperty("ping", var1.ping);
         if (var1.version != null) {
            var0.addProperty("version", var1.version.getString());
         }
      }

      if (iIIiIIiIi_Class294.I_field_3a9bda27.getNetworkHandler() != null) {
         Collection var2 = iIIiIIiIi_Class294.I_field_3a9bda27.getNetworkHandler().getPlayerList();
         var0.addProperty("online", var2.size());
         PlayerListEntry var3 = iIIiIIiIi_Class294.I_field_3a9bda27.player == null
            ? null
            : iIIiIIiIi_Class294.I_field_3a9bda27.getNetworkHandler().getPlayerListEntry(iIIiIIiIi_Class294.I_field_3a9bda27.player.getUuid());
         if (var3 != null) {
            var0.addProperty("ownPing", var3.getLatency());
         }
      }

      var0.addProperty("tps", I_method_2c1e18bf(RockstarClient.getInstance().I_method_d1ad67e2().I_method_2bde91cf(), 2));
      return var0;
   }

   public static JsonObject Ii_method_f48e0ded() {
      JsonObject var0 = new JsonObject();
      var0.addProperty("client", "Rockstar 2.1");
      var0.addProperty("minecraft", SharedConstants.getGameVersion().getName());
      var0.addProperty(
         "account", iIIiIIiIi_Class294.I_field_3a9bda27.getSession() == null ? "?" : iIIiIIiIi_Class294.I_field_3a9bda27.getSession().getUsername()
      );
      var0.addProperty("fps", iIIiIIiIi_Class294.I_field_3a9bda27.getCurrentFps());
      var0.addProperty("language", IiIiIIII_Class81.I_method_21a4cfeb().name());
      var0.addProperty("theme", RockstarClient.getInstance().I_method_9a720c62().I_method_ac8a0395().name());
      var0.addProperty("config", RockstarClient.getInstance().I_method_5198232b().I_method_5c2e4534());
      var0.addProperty("commandPrefix", RockstarClient.getInstance().I_method_b4d046cb().I_method_80ea594());
      var0.addProperty("swingPreset", RockstarClient.getInstance().I_method_11732eb().I_method_5c4a8d74());
      List var1 = RockstarClient.getInstance().getModuleManager().getModules();
      JsonArray var2 = new JsonArray();

      for (ModuleEntry var4 : (Iterable<ModuleEntry>)(Iterable<?>)var1) {
         if (var4.isEnabled()) {
            var2.add(var4.getName());
         }
      }

      var0.addProperty("modulesTotal", var1.size());
      var0.add("modulesEnabled", var2);
      JsonArray var6 = new JsonArray();

      for (IIiiIIiii_Class104 var5 : RockstarClient.getInstance().I_method_a90eb842().i_method_619cb248()) {
         if (var5.II_method_b18bf526()) {
            var6.add(var5.I_method_332d5061());
         }
      }

      var0.add("scriptsLoaded", var6);
      return var0;
   }

   public static JsonObject iI_method_5d7d01ad() {
      JsonObject var0 = new JsonObject();
      var0.addProperty("framebufferWidth", iIIiIIiIi_Class294.I_field_3a9bda27.getWindow().getFramebufferWidth());
      var0.addProperty("framebufferHeight", iIIiIIiIi_Class294.I_field_3a9bda27.getWindow().getFramebufferHeight());
      var0.addProperty("guiWidth", iIIiIIiIi_Class294.I_field_3a9bda27.getWindow().getScaledWidth());
      var0.addProperty("guiHeight", iIIiIIiIi_Class294.I_field_3a9bda27.getWindow().getScaledHeight());
      var0.addProperty("guiScale", iIIiIIiIi_Class294.I_field_3a9bda27.getWindow().getScaleFactor());
      var0.addProperty("cursorLocked", iIIiIIiIi_Class294.I_field_3a9bda27.mouse.isCursorLocked());
      var0.addProperty("hudHidden", iIIiIIiIi_Class294.I_field_3a9bda27.options != null && iIIiIIiIi_Class294.I_field_3a9bda27.options.hudHidden);
      JsonObject var1 = new JsonObject();
      var1.addProperty("x", I_method_2c1e18bf((float)iIIiIIiIi_Class294.I_field_3a9bda27.mouse.getX(), 1));
      var1.addProperty("y", I_method_2c1e18bf((float)iIIiIIiIi_Class294.I_field_3a9bda27.mouse.getY(), 1));
      var0.add("cursor", var1);
      if (iIIiIIiIi_Class294.I_field_3a9bda27.currentScreen == null) {
         var0.add("screen", JsonNull.INSTANCE);
         var0.add("screenType", JsonNull.INSTANCE);
      } else {
         var0.addProperty(
            "screen",
            iIIiIIiIi_Class294.I_field_3a9bda27.currentScreen.getTitle() == null
               ? ""
               : iIIiIIiIi_Class294.I_field_3a9bda27.currentScreen.getTitle().getString()
         );
         var0.addProperty("screenType", iIIiIIiIi_Class294.I_field_3a9bda27.currentScreen.getClass().getSimpleName());
      }

      return var0;
   }

   public static JsonArray I_method_7fafe1b7(double var0, int var2, String var3) {
      JsonArray var4 = new JsonArray();
      if (iIIiIIiIi_Class294.I_field_3a9bda27.world != null && iIIiIIiIi_Class294.I_field_3a9bda27.player != null) {
         ArrayList var5 = new ArrayList();

         for (Entity var7 : iIIiIIiIi_Class294.I_field_3a9bda27.world.getEntities()) {
            if (var7 != iIIiIIiIi_Class294.I_field_3a9bda27.player
               && !var7.isRemoved()
               && !(var7.distanceTo(iIIiIIiIi_Class294.I_field_3a9bda27.player) > var0)) {
               boolean var8 = switch (var3) {
                  case "players" -> var7 instanceof PlayerEntity;
                  case "living" -> var7 instanceof LivingEntity;
                  default -> true;
               };
               if (var8) {
                  var5.add(var7);
               }
            }
         }

         var5.sort(
            (var0x, var1) -> Float.compare(
               ((net.minecraft.entity.Entity)var0x).distanceTo(iIIiIIiIi_Class294.I_field_3a9bda27.player), ((net.minecraft.entity.Entity)var1).distanceTo(iIIiIIiIi_Class294.I_field_3a9bda27.player)
            )
         );

         for (Entity var12 : (Iterable<Entity>)(Iterable<?>)var5.subList(0, Math.min(var2, var5.size()))) {
            JsonObject var13 = new JsonObject();
            var13.addProperty("name", var12.getName().getString());
            var13.addProperty("type", Registries.ENTITY_TYPE.getId(var12.getType()).toString());
            var13.addProperty("distance", I_method_2c1e18bf(var12.distanceTo(iIIiIIiIi_Class294.I_field_3a9bda27.player), 2));
            var13.add("pos", I_method_53b80104(var12.getPos()));
            if (var12 instanceof LivingEntity var9) {
               var13.addProperty("health", I_method_2c1e18bf(var9.getHealth(), 1));
               var13.addProperty("maxHealth", I_method_2c1e18bf(var9.getMaxHealth(), 1));
            }

            if (var12 instanceof PlayerEntity var14) {
               var13.addProperty("player", true);
               var13.addProperty("friend", RockstarClient.getInstance().I_method_7a5acaeb().I_method_19c9437a(var14.getName().getString()));
               var13.add("hand", I_method_554994(var14.getMainHandStack()));
            }

            var4.add(var13);
         }

         return var4;
      } else {
         return var4;
      }
   }

   public static JsonArray I_method_8bf68b13(int var0) {
      JsonArray var1 = new JsonArray();
      if (iIIiIIiIi_Class294.I_field_3a9bda27.inGameHud == null) {
         return var1;
      } else {
         List var2 = ((ChatHudAccessor)(Object)iIIiIIiIi_Class294.I_field_3a9bda27.inGameHud.getChatHud()).getMessages();
         int var3 = Math.max(0, var2.size() - var0);

         for (int var4 = var2.size() - 1; var4 >= var3; var4--) {
            var1.add(((ChatHudLine)var2.get(var4)).content().getString());
         }

         return var1;
      }
   }

   public static JsonArray I_method_5c6bd628(String var0, boolean var1, String var2, boolean var3) {
      JsonArray var4 = new JsonArray();

      for (ModuleEntry var6 : RockstarClient.getInstance().getModuleManager().getModules()) {
         if ((var3 || !var6.II_method_e249c39() && var6.isAvailable())
            && (!var1 || var6.isEnabled())
            && (var0 == null || var0.isBlank() || var6.getCategory() == ModuleCategory.I_method_a9f2a441(var0))
            && (var2 == null || var2.isBlank() || var6.getName().toLowerCase(Locale.ROOT).contains(var2.toLowerCase(Locale.ROOT)))) {
            var4.add(I_method_a29ebd5b(var6, false));
         }
      }

      return var4;
   }

   public static JsonObject I_method_a29ebd5b(ModuleEntry var0, boolean var1) {
      JsonObject var2 = new JsonObject();
      var2.addProperty("name", var0.getName());
      var2.addProperty("category", var0.getCategory().name());
      var2.addProperty("enabled", var0.isEnabled());
      var2.addProperty("hidden", var0.II_method_e249c39());
      var2.addProperty("key", var0.getKeybind());
      var2.addProperty("keyName", var0.getKeybind() <= 0 ? null : iIIIIiIiI_Class267.I_method_a937749c(var0.getKeybind()));
      var2.addProperty("description", var0.i_method_bf522194());
      if (var1) {
         JsonArray var3 = new JsonArray();

         for (Setting var5 : var0.getSettings()) {
            var3.add(I_method_3c1848e8(var5));
         }

         var2.add("settings", var3);
      } else {
         var2.addProperty("settings", var0.getSettings().size());
      }

      return var2;
   }

   public static JsonObject I_method_3c1848e8(Setting var0) {
      JsonObject var1 = new JsonObject();
      var1.addProperty("name", var0.getName());
      var1.addProperty("label", IiIiIIII_Class81.I_method_f25a980a(var0.getName()));
      var1.addProperty("type", I_method_801761c6(var0));
      var1.addProperty("visible", var0.isVisible());
      if (var0 instanceof BooleanSetting var2) {
         var1.addProperty("value", var2.i_method_9b12da03());
      } else if (var0 instanceof SliderSetting var3) {
         var1.addProperty("value", I_method_2c1e18bf(var3.Ii_method_a20abcd2(), 3));
         var1.addProperty("min", var3.I_method_b2a48e2f());
         var1.addProperty("max", var3.i_method_b2b31a0f());
         var1.addProperty("step", var3.II_method_a1fc30f2());
      } else if (var0 instanceof RangeSetting var4) {
         JsonObject var10 = new JsonObject();
         var10.addProperty("first", I_method_2c1e18bf(var4.i_method_e92b420f(), 3));
         var10.addProperty("second", I_method_2c1e18bf(var4.II_method_3a8908f2(), 3));
         var1.add("value", var10);
         var1.addProperty("min", var4.Ii_method_3a9794d2());
         var1.addProperty("max", var4.iI_method_3c4bf912());
         var1.addProperty("step", var4.ii_method_3c5a84f2());
      } else if (var0 instanceof ModeSetting var5) {
         var1.addProperty("value", var5.i_method_f85f3850() == null ? null : var5.i_method_f85f3850().getName());
         var1.addProperty("valueLabel", var5.i_method_f85f3850() == null ? null : IiIiIIII_Class81.I_method_f25a980a(var5.i_method_f85f3850().getName()));
         var1.add("options", I_method_40961f76(var5));
         var1.add("optionLabels", I_method_f02da2bc(I_method_40961f76(var5)));
      } else if (var0 instanceof MultiSelectSetting var6) {
         JsonArray var13 = new JsonArray();

         for (MultiSelectSetting.Nested1_42856060 var12 : var6.I_method_45aaa648()) {
            if (var12.isSelected()) {
               var13.add(var12.getName());
            }
         }

         var1.add("value", var13);
         var1.add("options", I_method_f3449b76(var6));
         var1.add("optionLabels", I_method_f02da2bc(I_method_f3449b76(var6)));
      } else if (var0 instanceof ColorSetting var7) {
         var1.addProperty("value", var7.I_method_bde5f08e().toHex());
      } else if (var0 instanceof KeybindSetting var8) {
         var1.addProperty("value", var8.I_method_fa6281d2());
         var1.addProperty("keyName", var8.I_method_fa6281d2() <= 0 ? null : iIIIIiIiI_Class267.I_method_a937749c(var8.I_method_fa6281d2()));
      } else if (var0 instanceof TextSetting var9) {
         var1.addProperty("value", var9.II_method_da016c1e());
      } else if (var0 instanceof ButtonSetting) {
         var1.addProperty(
            "value", "\u043a\u043d\u043e\u043f\u043a\u0430: setting_set \u0441\u043e \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u0435\u043c \"click\""
         );
      } else {
         var1.add("raw", var0.toJson());
      }

      return var1;
   }

   public static String I_method_801761c6(Setting var0) {
      if (var0 instanceof BooleanSetting) {
         return "boolean";
      } else if (var0 instanceof SliderSetting) {
         return "slider";
      } else if (var0 instanceof RangeSetting) {
         return "range";
      } else if (var0 instanceof ModeSetting) {
         return "mode";
      } else if (var0 instanceof MultiSelectSetting) {
         return "select";
      } else if (var0 instanceof ColorSetting) {
         return "color";
      } else if (var0 instanceof KeybindSetting) {
         return "bind";
      } else if (var0 instanceof TextSetting) {
         return "text";
      } else {
         return var0 instanceof ButtonSetting ? "button" : "raw";
      }
   }

   public static JsonObject ii_method_fa9609cd() {
      JsonObject var0 = new JsonObject();
      JsonArray var1 = new JsonArray();

      for (ModuleEntry var3 : RockstarClient.getInstance().getModuleManager().getModules()) {
         if (var3.getKeybind() > 0) {
            JsonObject var4 = new JsonObject();
            var4.addProperty("module", var3.getName());
            var4.addProperty("key", var3.getKeybind());
            var4.addProperty("keyName", iIIIIiIiI_Class267.I_method_a937749c(var3.getKeybind()));
            var4.addProperty("enabled", var3.isEnabled());
            var1.add(var4);
         }
      }

      var0.add("modules", var1);
      JsonArray var9 = new JsonArray();

      for (ModuleEntry var11 : RockstarClient.getInstance().getModuleManager().getModules()) {
         for (Setting var6 : var11.getSettings()) {
            if (var6 instanceof KeybindSetting var7 && var7.I_method_fa6281d2() > 0) {
               JsonObject var8 = new JsonObject();
               var8.addProperty("module", var11.getName());
               var8.addProperty("setting", var6.getName());
               var8.addProperty("key", var7.I_method_fa6281d2());
               var8.addProperty("keyName", iIIIIiIiI_Class267.I_method_a937749c(var7.I_method_fa6281d2()));
               var9.add(var8);
            }
         }
      }

      var0.add("settings", var9);
      var0.add("macros", I_method_4f8ed768());
      return var0;
   }

   public static JsonArray I_method_4f8ed768() {
      JsonArray var0 = new JsonArray();

      for (IiIiIIii_Class84 var2 : RockstarClient.getInstance().I_method_af32eeab().I_method_e1cbbc5b()) {
         JsonObject var3 = new JsonObject();
         var3.addProperty("command", var2.I_method_f1090d94());
         var3.addProperty("key", var2.I_method_886a907f());
         var3.addProperty("keyName", iIIIIiIiI_Class267.I_method_a937749c(var2.I_method_886a907f()));
         var0.add(var3);
      }

      return var0;
   }

   public static JsonObject III_method_f4f4e616() {
      JsonObject var0 = new JsonObject();
      var0.addProperty("active", RockstarClient.getInstance().I_method_5198232b().I_method_5c2e4534());
      var0.addProperty("autoSave", RockstarClient.getInstance().I_method_5198232b().I_method_7ce4a4f0());
      JsonArray var1 = new JsonArray();
      RockstarClient.getInstance().I_method_5198232b().i_method_f9096ffb().forEach(var1::add);
      var0.add("configs", var1);
      return var0;
   }

   public static JsonArray i_method_65244b48() {
      JsonArray var0 = new JsonArray();

      for (IIiiIIiii_Class104 var2 : RockstarClient.getInstance().I_method_a90eb842().i_method_619cb248()) {
         JsonObject var3 = new JsonObject();
         var3.addProperty("name", var2.I_method_332d5061());
         var3.addProperty("loaded", var2.II_method_b18bf526());
         var3.addProperty("protected", var2.I_method_c8d5294e() == null);
         if (var2.II_method_37d6a7be() != null) {
            var3.addProperty("error", var2.II_method_37d6a7be());
         }

         if (var2.I_method_c8d5294e() != null) {
            var3.addProperty("path", var2.I_method_c8d5294e().getAbsolutePath());
         }

         JsonArray var4 = new JsonArray();
         var2.I_method_3f6f2a48().forEach(var1 -> var4.add(var1.getName()));
         var3.add("modules", var4);
         var0.add(var3);
      }

      return var0;
   }

   public static JsonObject IIi_method_920dee36() {
      iiIIIIIi_Class194 var0 = RockstarClient.getInstance().I_method_11732eb();
      JsonObject var1 = new JsonObject();
      var1.addProperty("current", var0.I_method_5c4a8d74());
      JsonArray var2 = new JsonArray();

      for (iiIIIiii_Class200 var4 : var0.I_method_c2ce901b()) {
         JsonObject var5 = new JsonObject();
         var5.addProperty("name", var4.I_method_62860974());
         var5.addProperty("label", IiIiIIII_Class81.I_method_f25a980a(var4.I_method_62860974()));
         var5.addProperty("source", "builtin");
         var2.add(var5);
      }

      for (iiIIiIII_Class201 var7 : RockstarClient.getInstance().I_method_2da230b().I_method_43006bfb()) {
         JsonObject var8 = new JsonObject();
         var8.addProperty("name", var7.I_method_5141c934());
         var8.addProperty("label", var7.I_method_5141c934());
         var8.addProperty("source", "file");
         var2.add(var8);
      }

      var1.add("presets", var2);
      var1.add("shared", I_method_dfda9119(var0.I_method_94c3e7cb().getSettings()));
      var1.add("start", I_method_dfda9119(var0.I_method_94b5d40b().getSettings()));
      var1.add("end", I_method_dfda9119(var0.i_method_beb2642b().getSettings()));
      return var1;
   }

   public static JsonArray I_method_dfda9119(List<Setting> var0) {
      JsonArray var1 = new JsonArray();

      for (Setting var3 : var0) {
         var1.add(I_method_3c1848e8(var3));
      }

      return var1;
   }

   private static JsonArray I_method_f02da2bc(JsonArray var0) {
      JsonArray var1 = new JsonArray();
      var0.forEach(var1x -> var1.add(IiIiIIII_Class81.I_method_f25a980a(var1x.getAsString())));
      return var1;
   }

   private static JsonArray I_method_40961f76(ModeSetting var0) {
      JsonArray var1 = new JsonArray();

      for (ModeSetting.Nested1_42765c60 var3 : var0.I_method_e1d4a248()) {
         var1.add(var3.getName());
      }

      return var1;
   }

   private static JsonArray I_method_f3449b76(MultiSelectSetting var0) {
      JsonArray var1 = new JsonArray();

      for (MultiSelectSetting.Nested1_42856060 var3 : var0.I_method_45aaa648()) {
         var1.add(var3.getName());
      }

      return var1;
   }

   private static JsonObject IiI_method_fafce1f6() {
      JsonObject var0 = new JsonObject();
      var0.add("main", I_method_554994(iIIiIIiIi_Class294.I_field_3a9bda27.player.getMainHandStack()));
      var0.add("off", I_method_554994(iIIiIIiIi_Class294.I_field_3a9bda27.player.getOffHandStack()));
      var0.addProperty("selectedSlot", iIIiIIiIi_Class294.I_field_3a9bda27.player.getInventory().selectedSlot);
      return var0;
   }

   private static JsonArray Ii_method_6481a9d1() {
      JsonArray var0 = new JsonArray();

      for (ItemStack var2 : iIIiIIiIi_Class294.I_field_3a9bda27.player.getInventory().armor) {
         var0.add(I_method_554994(var2));
      }

      return var0;
   }

   public static JsonArray II_method_4eec35f1() {
      JsonArray var0 = new JsonArray();
      if (iIIiIIiIi_Class294.I_field_3a9bda27.player == null) {
         return var0;
      } else {
         DefaultedList var1 = iIIiIIiIi_Class294.I_field_3a9bda27.player.getInventory().main;

         for (int var2 = 0; var2 < var1.size(); var2++) {
            ItemStack var3 = (ItemStack)var1.get(var2);
            if (!var3.isEmpty()) {
               JsonObject var4 = I_method_554994(var3);
               var4.addProperty("slot", var2);
               var4.addProperty("hotbar", var2 < 9);
               var0.add(var4);
            }
         }

         return var0;
      }
   }

   private static JsonObject I_method_554994(ItemStack var0) {
      JsonObject var1 = new JsonObject();
      if (var0 != null && !var0.isEmpty()) {
         var1.addProperty("id", Registries.ITEM.getId(var0.getItem()).toString());
         var1.addProperty("name", var0.getName().getString());
         var1.addProperty("count", var0.getCount());
         if (var0.isDamageable()) {
            var1.addProperty("durability", var0.getMaxDamage() - var0.getDamage());
            var1.addProperty("maxDurability", var0.getMaxDamage());
         }

         return var1;
      } else {
         var1.addProperty("id", "minecraft:air");
         var1.addProperty("count", 0);
         return var1;
      }
   }

   private static JsonArray I_method_b84508d9(Collection<StatusEffectInstance> var0) {
      JsonArray var1 = new JsonArray();

      for (StatusEffectInstance var3 : var0) {
         JsonObject var4 = new JsonObject();
         var4.addProperty("name", ((StatusEffect)var3.getEffectType().value()).getName().getString());
         var4.addProperty("id", Registries.STATUS_EFFECT.getId((StatusEffect)var3.getEffectType().value()) + "");
         var4.addProperty("amplifier", var3.getAmplifier() + 1);
         var4.addProperty("ticks", var3.isInfinite() ? -1 : var3.getDuration());
         var1.add(var4);
      }

      return var1;
   }

   private static JsonObject I_method_53b80104(Vec3d var0) {
      JsonObject var1 = new JsonObject();
      var1.addProperty("x", I_method_2c1e18bf((float)var0.x, 3));
      var1.addProperty("y", I_method_2c1e18bf((float)var0.y, 3));
      var1.addProperty("z", I_method_2c1e18bf((float)var0.z, 3));
      return var1;
   }

   private static float I_method_2c1e18bf(float var0, int var1) {
      float var2 = (float)Math.pow(10.0, var1);
      return Math.round(var0 * var2) / var2;
   }

   static JsonElement I_method_cb9e432c(String var0, JsonElement var1) {
      JsonObject var2 = new JsonObject();
      var2.add(var0, var1);
      return var2;
   }
}
