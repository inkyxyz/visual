package pyrock.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;
import jep.python.PyCallable;
import net.funtimeevents.api.FunTimeEventsAPI;
import net.funtimeevents.model.BanResponse;
import net.funtimeevents.model.BansListResponse;
import net.funtimeevents.model.CaptchaResponse;
import net.funtimeevents.model.ChestResponse;
import net.funtimeevents.model.EventCoordinates;
import net.funtimeevents.model.EventResponse;
import net.funtimeevents.model.LootAreaResponse;
import net.funtimeevents.model.MineResponse;
import net.funtimeevents.model.ObservedPlayer;
import net.funtimeevents.model.PlayerDataResponse;
import net.funtimeevents.model.PlayerGearInfo;
import net.funtimeevents.model.PlayersListResponse;
import net.funtimeevents.model.SystemInfo;
import org.jetbrains.annotations.Nullable;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.IIiiIiIIi_Class106;
import rockstar.client.RockstarClient;
import rockstar.client.iIIiIIiIi_Class294;

public class PyFunTime {
   public boolean ready() {
      try {
         return FunTimeEventsAPI.getSystemInfo() != null
            ? true
            : !FunTimeEventsAPI.getEvents().isEmpty()
               || !FunTimeEventsAPI.getMines().isEmpty()
               || !FunTimeEventsAPI.getCopperDungeons().isEmpty()
               || !FunTimeEventsAPI.getWardenCities().isEmpty();
      } catch (Throwable var2) {
         return false;
      }
   }

   public List<Map<String, Object>> events() {
      return map(safe(FunTimeEventsAPI::getEvents), PyFunTime::event);
   }

   public List<Map<String, Object>> mines() {
      return map(safe(FunTimeEventsAPI::getMines), PyFunTime::mine);
   }

   public List<Map<String, Object>> copperDungeons() {
      return map(safe(FunTimeEventsAPI::getCopperDungeons), PyFunTime::lootArea);
   }

   public List<Map<String, Object>> wardenCities() {
      return map(safe(FunTimeEventsAPI::getWardenCities), PyFunTime::lootArea);
   }

   @Nullable
   public Map<String, Object> systemInfo() {
      SystemInfo var1;
      try {
         var1 = FunTimeEventsAPI.getSystemInfo();
      } catch (Throwable var3) {
         return null;
      }

      if (var1 == null) {
         return null;
      } else {
         LinkedHashMap var2 = new LinkedHashMap();
         var2.put("events", var1.events());
         var2.put("mines", var1.mines());
         var2.put("copper_dungeons", var1.copperDungeons());
         var2.put("warden_cities", var1.wardenCities());
         var2.put("clients_connected", var1.clientsConnected());
         var2.put("tracked_anarchies", var1.trackedAnarchies());
         return var2;
      }
   }

   public void fetchEvents(@Nullable Map<String, String> var1, PyCallable var2) {
      deliver(FunTimeEventsAPI.fetchEvents(params(var1)), var2, var0 -> var0);
   }

   public void fetchMines(@Nullable Map<String, String> var1, PyCallable var2) {
      deliver(FunTimeEventsAPI.fetchMines(params(var1)), var2, var0 -> var0);
   }

   public void fetchCopperDungeon(PyCallable var1) {
      deliver(FunTimeEventsAPI.fetchCopperDungeon(), var1, var0 -> var0);
   }

   public void fetchWardenCity(PyCallable var1) {
      deliver(FunTimeEventsAPI.fetchWardenCity(), var1, var0 -> var0);
   }

   public void fetchPlayers(@Nullable Map<String, String> var1, PyCallable var2) {
      deliver(FunTimeEventsAPI.fetchPlayers(params(var1)), var2, var0 -> {
         ArrayList var1x = new ArrayList();
         if (var0 instanceof PlayersListResponse && var0.data() != null) {
            for (PlayerDataResponse var4 : var0.data()) {
               var1x.add(player(var4));
            }
         }

         return var1x;
      });
   }

   public void fetchBans(@Nullable Map<String, String> var1, PyCallable var2) {
      deliver(FunTimeEventsAPI.fetchBans(params(var1)), var2, var0 -> {
         ArrayList var1x = new ArrayList();
         if (var0 instanceof BansListResponse && var0.data() != null) {
            for (BanResponse var4 : var0.data()) {
               var1x.add(ban(var4));
            }
         }

         return var1x;
      });
   }

   public void solveCaptcha(String var1, PyCallable var2) {
      deliver(FunTimeEventsAPI.solveCaptcha(var1), var2, var0 -> {
         if (var0 instanceof CaptchaResponse) {
            LinkedHashMap var2x = new LinkedHashMap();
            var2x.put("solved", var0.solved());
            var2x.put("text", var0.text());
            var2x.put("percent", var0.overallPercent());
            return var2x;
         } else {
            return null;
         }
      });
   }

   private static Map<String, Object> event(EventResponse var0) {
      LinkedHashMap var1 = new LinkedHashMap();
      var1.put("server_id", var0.serverId());
      var1.put("server_type", var0.serverType());
      var1.put("name", var0.name());
      var1.put("status", var0.status());
      var1.put("time_left", var0.timeLeft());
      var1.put("level", var0.level());
      var1.put("message", var0.message());
      var1.put("updated_at", var0.updatedAt());
      EventCoordinates var2 = var0.coordinates();
      if (var2 != null) {
         LinkedHashMap var3 = new LinkedHashMap();
         var3.put("x", var2.x());
         var3.put("y", var2.y());
         var3.put("z", var2.z());
         var1.put("coordinates", var3);
      }

      if (var0.eventInfo() != null) {
         var1.put("mobs", var0.eventInfo().mobsCount());
      }

      return var1;
   }

   private static Map<String, Object> mine(MineResponse var0) {
      LinkedHashMap var1 = new LinkedHashMap();
      var1.put("server_id", var0.serverId());
      var1.put("server_type", var0.serverType());
      var1.put("rarity", var0.rarity());
      var1.put("time_left", var0.timeLeft());
      var1.put("updated_at", var0.updatedAt());
      if (var0.mineInfo() != null && var0.mineInfo().playersAround() != null) {
         ArrayList var2 = new ArrayList();

         for (ObservedPlayer var4 : var0.mineInfo().playersAround()) {
            LinkedHashMap var5 = new LinkedHashMap();
            var5.put("name", String.valueOf(var4));
            var2.add(var5);
         }

         var1.put("players_around", var2);
      }

      return var1;
   }

   private static Map<String, Object> lootArea(LootAreaResponse var0) {
      LinkedHashMap var1 = new LinkedHashMap();
      var1.put("server_id", var0.serverId());
      var1.put("server_type", var0.serverType());
      ArrayList<Map<String, Object>> var2 = new ArrayList<>();
      if (var0.chests() != null) {
         for (ChestResponse var4 : var0.chests()) {
            LinkedHashMap var5 = new LinkedHashMap();
            var5.put("x", var4.x());
            var5.put("y", var4.y());
            var5.put("z", var4.z());
            var5.put("time_left", var4.timeLeft());
            var5.put("created_at", var4.createdAt());
            var2.add(var5);
         }
      }

      var1.put("chests", var2);
      ArrayList var7 = new ArrayList();
      if (var0.players() != null) {
         for (PlayerGearInfo var9 : var0.players()) {
            LinkedHashMap var6 = new LinkedHashMap();
            var6.put("name", var9.playerName());
            var6.put("donate", var9.donate());
            var6.put("helmet", var9.helmet());
            var6.put("chestplate", var9.chestplate());
            var6.put("leggings", var9.leggings());
            var6.put("boots", var9.boots());
            var6.put("invisible", var9.isInvisible());
            var7.add(var6);
         }
      }

      var1.put("players", var7);
      return var1;
   }

   private static Map<String, Object> player(PlayerDataResponse var0) {
      LinkedHashMap var1 = new LinkedHashMap();
      var1.put("name", var0.playerName());
      var1.put("donate", var0.donate());
      var1.put("active", var0.active());
      var1.put("server_id", var0.serverId());
      var1.put("server_type", var0.serverType());
      return var1;
   }

   private static Map<String, Object> ban(BanResponse var0) {
      LinkedHashMap var1 = new LinkedHashMap();
      var1.put("server_id", var0.serverId());
      var1.put("server_type", var0.serverType());
      var1.put("name", var0.playerName());
      var1.put("reason", var0.reason());
      var1.put("end", var0.end());
      var1.put("banned_at", var0.bannedAt());
      return var1;
   }

   private static Map<String, String> params(@Nullable Map<String, String> var0) {
      return var0 == null ? new HashMap<>() : new HashMap<>(var0);
   }

   private static <T> List<T> safe(Supplier<List<T>> var0) {
      try {
         List var1 = (List)var0.get();
         return var1 == null ? List.of() : var1;
      } catch (Throwable var2) {
         return List.of();
      }
   }

   private static <T> List<Map<String, Object>> map(List<T> var0, Function<T, Map<String, Object>> var1) {
      ArrayList var2 = new ArrayList();

      for (T var4 : var0) {
         if (var4 != null) {
            try {
               var2.add(var1.apply(var4));
            } catch (Throwable var6) {
            }
         }
      }

      return var2;
   }

   private static <T> void deliver(CompletableFuture<T> var0, PyCallable var1, Function<T, Object> var2) {
      if (var1 != null) {
         IIiiIIiii_Class104 var3 = IIiiIIiii_Class104.I_method_204b62f5();
         var0.whenComplete((var3x, var4) -> {
            Object var5;
            try {
               var5 = var4 == null && var3x != null ? var2.apply(var3x) : null;
            } catch (Throwable var7) {
               var5 = null;
            }

            Object var6 = var5;
            iIIiIIiIi_Class294.I_field_3a9bda27.execute(() -> {
               if (var3 == null || var3.II_method_b18bf526()) {
                  if (IIiiIiIIi_Class106.Ii_method_b61528e6()) {
                     try (AutoCloseable var3xx = IIiiIIiii_Class104.I_method_5edeb6c9(var3)) {
                        var1.call(new Object[]{var6});
                     } catch (Exception var8) {
                        RockstarClient.I_field_ab0f6068.error("Python error in funtime callback:", var8);
                     }
                  }
               }
            });
         });
      }
   }
}
