package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import globals.client.api.RockNetClient;
import globals.shared.proto.Packet;
import globals.shared.proto.Packets;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.HoverEvent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.text.ClickEvent.Action;
import net.minecraft.util.Formatting;

public class IIiiiiiI_Class63 {
   private static final long I_field_4a = 1500L;
   private static final String I_field_523beb0a = "default";
   private static final File I_CONFIGS_DIR = new File(IiIIiIII_Class73.I_field_3a58077, "configs");
   private volatile List<Packets.Nested1_f320330b> I_field_7865b31 = List.of();
   private volatile Map<String, Long> I_field_a567c40b = Map.of();
   private volatile Long I_field_6ec681ff;
   private volatile String i_field_523beb0a;
   private final AtomicBoolean I_field_1232aa16 = new AtomicBoolean(false);
   private final AtomicBoolean i_field_1232aa16 = new AtomicBoolean(false);
   private final AtomicBoolean II_field_1232aa16 = new AtomicBoolean(false);
   private volatile boolean I_field_5a = true;
   private final ScheduledExecutorService I_field_47254ffa = Executors.newSingleThreadScheduledExecutor(var0 -> {
      Thread var1 = new Thread(var0, "Config-Autosave");
      var1.setDaemon(true);
      return var1;
   });
   private volatile ScheduledFuture<?> I_field_dd9473d7;
   private volatile ScheduledFuture<?> i_field_dd9473d7;

   public void I_method_7ce4a4ec() {
      this.refreshConfigList();
      if (this.I_field_7865b31.isEmpty()) {
         try {
            if (!I_CONFIGS_DIR.exists()) {
               I_CONFIGS_DIR.mkdirs();
            }
            File defaultFile = new File(I_CONFIGS_DIR, "default.json");
            JsonObject json = IIiiiiIi_Class62.I_method_50733716();
            IiIIiIII_Class73.I_method_3b2973c6(defaultFile, json);
            this.i_field_523beb0a = "default";
            this.I_field_6ec681ff = (long) Math.abs("default".hashCode());
            this.refreshConfigList();
         } catch (Exception var2) {
            RockstarClient.I_field_ab0f6068.error("Config: failed to create initial default config", var2);
         }
      }
   }

   public void refreshConfigList() {
      try {
         if (!I_CONFIGS_DIR.exists()) {
            I_CONFIGS_DIR.mkdirs();
         }
         File[] files = I_CONFIGS_DIR.listFiles((dir, fName) -> fName.endsWith(".json") || fName.endsWith(".rock"));
         List<Packets.Nested1_f320330b> list = new ArrayList<>();
         Map<String, Long> map = new HashMap<>();
         if (files != null) {
            Arrays.sort(files, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));
            for (File f : files) {
               String fName = f.getName();
               String clean = fName.endsWith(".json") ? fName.substring(0, fName.length() - 5) : (fName.endsWith(".rock") ? fName.substring(0, fName.length() - 5) : fName);
               long id = (long) Math.abs(clean.hashCode());
               boolean active = clean.equalsIgnoreCase(this.i_field_523beb0a);
               list.add(new Packets.Nested1_f320330b(id, clean, active));
               map.put(clean.toLowerCase(Locale.ROOT), id);
            }
         }
         this.I_field_7865b31 = List.copyOf(list);
         this.I_field_a567c40b = Map.copyOf(map);
      } catch (Exception e) {
         RockstarClient.I_field_ab0f6068.error("Config: failed to refresh local config list", e);
      }
   }

   private File findConfigFile(String name) {
      if (name == null || name.isBlank()) return null;
      String clean = name.trim();
      File direct = new File(I_CONFIGS_DIR, clean);
      if (direct.exists() && direct.isFile()) return direct;
      File json = new File(I_CONFIGS_DIR, clean + ".json");
      if (json.exists() && json.isFile()) return json;
      File rock = new File(I_CONFIGS_DIR, clean + ".rock");
      if (rock.exists() && rock.isFile()) return rock;

      File[] files = I_CONFIGS_DIR.listFiles();
      if (files != null) {
         for (File f : files) {
            if (!f.isFile()) continue;
            String fn = f.getName();
            String stem = fn.endsWith(".json") ? fn.substring(0, fn.length() - 5) : (fn.endsWith(".rock") ? fn.substring(0, fn.length() - 5) : fn);
            if (stem.equalsIgnoreCase(clean)) {
               return f;
            }
         }
      }
      return null;
   }

   public void i_method_7cf330cc() {
      this.I_method_8ed57bdb(new Packets.Nested1_f32063a8());
   }

   public void I_method_ea3d9dd(List<Packets.Nested1_f320330b> var1) {
      List var2 = var1 == null ? List.of() : List.copyOf(var1);
      HashMap var3 = new HashMap();
      Long var4 = null;
      String var5 = null;

      for (Packets.Nested1_f320330b var7 : (Iterable<Packets.Nested1_f320330b>)(Iterable<?>)var2) {
         var3.put(var7.name().toLowerCase(Locale.ROOT), var7.id());
         if (var7.active()) {
            var4 = var7.id();
            var5 = var7.name();
         }
      }

      this.I_field_7865b31 = var2;
      this.I_field_a567c40b = Map.copyOf(var3);
      this.I_field_6ec681ff = var4;
      this.i_field_523beb0a = var5;
      if (var2.isEmpty() && this.II_field_1232aa16.compareAndSet(false, true)) {
         this.I_method_8ed57bdb(new Packets.Nested1_f3200a8a(null, "default", IIiiiiIi_Class62.I_method_50733716()));
      } else if (!var2.isEmpty()) {
         this.II_field_1232aa16.set(true);
      }
   }

   public void I_method_7af2fb3e(Packets.Nested1_f31938b7 var1) {
      if (var1 != null && var1.data() != null) {
         if (var1.active()) {
            this.I_field_6ec681ff = var1.id();
            this.i_field_523beb0a = var1.name();
         }

         this.I_method_13058298(var1.data());
      }
   }

   private void I_method_13058298(JsonObject var1) {
      this.i_field_1232aa16.set(true);
      this.Iii_method_d9ff820c();
      ScheduledFuture var2 = this.i_field_dd9473d7;
      if (var2 != null) {
         var2.cancel(false);
         this.i_field_dd9473d7 = null;
      }

      MinecraftClient.getInstance()
         .execute(
            () -> {
               this.I_field_1232aa16.set(true);
               IIiiiiIi_Class62.Nested1_b7c42cf3 var2x = IIiiiiIi_Class62.Nested1_b7c42cf3.II_field_becfa1dc;
               JsonObject var3 = null;

               try {
                  var3 = IIiiiiIi_Class62.I_method_50733716();
                  var2x = IIiiiiIi_Class62.I_method_f332e29a(var1);
                  if (var2x == IIiiiiIi_Class62.Nested1_b7c42cf3.II_field_becfa1dc && var3 != null) {
                     IIiiiiIi_Class62.I_method_f332e29a(var3);
                  }
               } catch (Exception var8) {
                  RockstarClient.I_field_ab0f6068
                     .error(
                        "Config: \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u043f\u0440\u0438\u043c\u0435\u043d\u0438\u0442\u044c \u043f\u043e\u043b\u0443\u0447\u0435\u043d\u043d\u044b\u0439 \u043a\u043e\u043d\u0444\u0438\u0433",
                        var8
                     );
                  var2x = IIiiiiIi_Class62.Nested1_b7c42cf3.II_field_becfa1dc;
                  if (var3 != null) {
                     IIiiiiIi_Class62.I_method_f332e29a(var3);
                  }
               } finally {
                  this.I_field_1232aa16.set(false);
               }

               if (var2x == IIiiiiIi_Class62.Nested1_b7c42cf3.II_field_becfa1dc) {
                  RockstarClient.I_field_ab0f6068
                     .warn(
                        "Config: \u043a\u043e\u043d\u0444\u0438\u0433 \u043d\u0435 \u043f\u0440\u0438\u043c\u0435\u043d\u0451\u043d, \u0430\u0432\u0442\u043e\u0441\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u0435 \u043f\u0440\u0438\u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d\u043e \u0434\u043e \u0441\u043b\u0435\u0434\u0443\u044e\u0449\u0435\u0439 \u0443\u0441\u043f\u0435\u0448\u043d\u043e\u0439 \u0437\u0430\u0433\u0440\u0443\u0437\u043a\u0438 \u0438\u043b\u0438 \u0440\u0443\u0447\u043d\u043e\u0433\u043e \u0441\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u044f"
                     );
               } else {
                  if (var2x == IIiiiiIi_Class62.Nested1_b7c42cf3.i_field_becfa1dc) {
                     List var4 = IIiiiiIi_Class62.I_method_624941b();
                     if (var4.isEmpty()) {
                        RockstarClient.I_field_ab0f6068
                           .warn(
                              "Config: \u043a\u043e\u043d\u0444\u0438\u0433 \u043f\u0440\u0438\u043c\u0435\u043d\u0451\u043d \u0447\u0430\u0441\u0442\u0438\u0447\u043d\u043e \u2014 \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u0434\u0440\u0443\u0433\u043e\u0433\u043e \u0444\u043e\u0440\u043c\u0430\u0442\u0430 \u043f\u0440\u043e\u043f\u0443\u0449\u0435\u043d\u044b"
                           );
                     } else {
                        RockstarClient.I_field_ab0f6068
                           .warn(
                              "Config: \u043a\u043e\u043d\u0444\u0438\u0433 \u043f\u0440\u0438\u043c\u0435\u043d\u0451\u043d \u0447\u0430\u0441\u0442\u0438\u0447\u043d\u043e, \u0441\u0435\u043a\u0446\u0438\u0438 \u043c\u043e\u0434\u0443\u043b\u0435\u0439 \u043d\u0435 \u0438\u0437 \u044d\u0442\u043e\u0439 \u0441\u0431\u043e\u0440\u043a\u0438 \u0441\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u044b \u043a\u0430\u043a \u0435\u0441\u0442\u044c: {}",
                              String.join(", ", var4)
                           );
                     }
                  }

                  this.i_field_1232aa16.set(false);
                  this.IIi_method_d83c91ec();
               }
            }
         );
   }

   private void IIi_method_d83c91ec() {
      try {
         SoundsModule var1 = RockstarClient.getInstance().getModuleManager().getModule(SoundsModule.class);
         if (var1 != null) {
            iiIiIIIII_Class417.i_field_34b2ba6c.I_method_7289b65f(var1.I_method_45ee5ef(), 1.0F);
         }

         RockstarClient.getInstance()
            .I_method_5cb1af22()
            .I_method_8ee48d11(iiiIIII_Class113.I_field_c11fcfcc, IiIiIIII_Class81.I_method_f25a980a("configs.loaded"));
      } catch (Exception var2) {
      }
   }

   public boolean I_method_7ce4a4f0() {
      return this.I_field_5a;
   }

   public void I_method_1fb0ab68(boolean var1) {
      this.I_field_5a = var1;
      if (!var1) {
         ScheduledFuture var2 = this.I_field_dd9473d7;
         if (var2 != null) {
            var2.cancel(false);
         }

         this.I_field_dd9473d7 = null;
      }
   }

   public void II_method_1fbeeff5() {
      if (this.I_field_5a) {
         if (!this.I_field_1232aa16.get() && !this.i_field_1232aa16.get()) {
            this.Iii_method_d9ff820c();
            this.I_field_dd9473d7 = this.I_field_47254ffa.schedule(this::IiI_method_d9f0f62c, 1500L, TimeUnit.MILLISECONDS);
         }
      }
   }

   public void Ii_method_1fcd7bd5() {
      if (this.I_field_5a) {
         this.Iii_method_d9ff820c();
         this.IiI_method_d9f0f62c();
      }
   }

   private void IiI_method_d9f0f62c() {
      if (!this.I_field_1232aa16.get() && !this.i_field_1232aa16.get()) {
         String currentName = this.i_field_523beb0a;
         if (currentName != null && !currentName.isBlank()) {
            try {
               if (!I_CONFIGS_DIR.exists()) {
                  I_CONFIGS_DIR.mkdirs();
               }
               File file = new File(I_CONFIGS_DIR, currentName + ".json");
               JsonObject json = IIiiiiIi_Class62.I_method_50733716();
               IiIIiIII_Class73.I_method_3b2973c6(file, json);
            } catch (Exception e) {
               RockstarClient.I_field_ab0f6068.error("Config: autosave failed for " + currentName, e);
            }
         }
         Long var1 = this.I_field_6ec681ff;
         if (var1 != null) {
            this.I_method_8ed57bdb(new Packets.Nested1_f3200a8a(var1, null, IIiiiiIi_Class62.I_method_50733716()));
         }
      }
   }

   public void I_method_ce5aebb6(String var1) {
      if (!i_method_9f123f9a(var1)) {
         this.i_field_1232aa16.set(false);
         String name = var1.trim();
         try {
            if (!I_CONFIGS_DIR.exists()) {
               I_CONFIGS_DIR.mkdirs();
            }
            File file = new File(I_CONFIGS_DIR, name + ".json");
            JsonObject json = IIiiiiIi_Class62.I_method_50733716();
            IiIIiIII_Class73.I_method_3b2973c6(file, json);
            this.i_field_523beb0a = name;
            this.I_field_6ec681ff = (long) Math.abs(name.hashCode());
            this.refreshConfigList();
            try {
               RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
            } catch (Exception ignored) {}
         } catch (Exception e) {
            RockstarClient.I_field_ab0f6068.error("Config: error saving local config " + name, e);
         }

         Long var2 = this.I_method_5e8b6a9f(var1);
         if (var2 != null) {
            this.I_method_8ed57bdb(new Packets.Nested1_f3200a8a(var2, null, IIiiiiIi_Class62.I_method_50733716()));
         } else {
            this.I_method_8ed57bdb(new Packets.Nested1_f3200a8a(null, name, IIiiiiIi_Class62.I_method_50733716()));
         }

         iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.config.saved", name)));
      }
   }

   public void i_method_9f123f96(String var1) {
      if (i_method_9f123f9a(var1)) {
         this.ii_method_6b40627f(var1);
         return;
      }
      String name = var1.trim();
      File target = findConfigFile(name);
      if (target != null && target.exists()) {
         try {
            String content = Files.readString(target.toPath(), StandardCharsets.UTF_8);
            JsonElement el = JsonParser.parseString(content);
            if (el != null && el.isJsonObject()) {
               String actualName = target.getName();
               if (actualName.endsWith(".json")) actualName = actualName.substring(0, actualName.length() - 5);
               else if (actualName.endsWith(".rock")) actualName = actualName.substring(0, actualName.length() - 5);
               this.i_field_523beb0a = actualName;
               this.I_field_6ec681ff = (long) Math.abs(actualName.hashCode());
               this.refreshConfigList();
               this.I_method_13058298(el.getAsJsonObject());
               try {
                  RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
               } catch (Exception ignored) {}
               iIIIIIIii_Class260.I_method_468cf607(Text.literal("§aКонфиг §f" + actualName + " §aуспешно загружен!"));
               return;
            }
         } catch (Exception e) {
            RockstarClient.I_field_ab0f6068.error("Config: error loading local config " + name, e);
         }
      }

      Long var2 = this.I_method_5e8b6a9f(var1);
      if (var2 == null) {
         this.ii_method_6b40627f(var1);
      } else {
         this.I_method_8ed57bdb(new Packets.Nested1_fac62d1b(var2));
      }
   }

   public void II_method_5455e67f(String var1) {
      Long var2 = i_method_9f123f9a(var1) ? this.I_field_6ec681ff : this.I_method_5e8b6a9f(var1);
      if (var2 == null) {
         this.ii_method_6b40627f(var1);
      } else {
         iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_f25a980a("config.undo.sent")));
         if (!var2.equals(this.I_field_6ec681ff)) {
            this.I_method_8ed57bdb(new Packets.Nested1_f32121f1(var2));
         } else {
            this.i_field_1232aa16.set(true);
            this.Iii_method_d9ff820c();
            this.I_method_8ed57bdb(new Packets.Nested1_f32121f1(var2));
            ScheduledFuture var3 = this.i_field_dd9473d7;
            if (var3 != null) {
               var3.cancel(false);
            }

            this.i_field_dd9473d7 = this.I_field_47254ffa
               .schedule(
                  () -> {
                     if (this.i_field_1232aa16.compareAndSet(true, false)) {
                        MinecraftClient.getInstance()
                           .execute(() -> iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("config.undo.empty"))));
                     }
                  },
                  5L,
                  TimeUnit.SECONDS
               );
         }
      }
   }

   public void Ii_method_250d3a5f(String var1) {
      if (i_method_9f123f9a(var1)) {
         this.ii_method_6b40627f(var1);
         return;
      }
      String name = var1.trim();
      File target = findConfigFile(name);
      boolean deleted = false;
      if (target != null && target.exists()) {
         deleted = target.delete();
      }
      if (deleted) {
         if (name.equalsIgnoreCase(this.i_field_523beb0a)) {
            this.i_field_523beb0a = null;
            this.I_field_6ec681ff = null;
         }
         this.refreshConfigList();
         iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("config.deleted", name)));
      } else {
         Long var2 = this.I_method_5e8b6a9f(var1);
         if (var2 == null) {
            this.ii_method_6b40627f(var1);
         } else {
            this.I_method_8ed57bdb(new Packets.Nested1_91e2bf78(var2));
            iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("config.deleted", name)));
         }
      }
   }

   public void I_method_cd7cd400(String var1, String var2) {
      if (i_method_9f123f9a(var1) || i_method_9f123f9a(var2)) {
         this.ii_method_6b40627f(var1);
         return;
      }
      String oldName = var1.trim();
      String newName = var2.trim();
      File target = findConfigFile(oldName);
      if (target != null && target.exists()) {
         File dest = new File(I_CONFIGS_DIR, newName + ".json");
         target.renameTo(dest);
         if (oldName.equalsIgnoreCase(this.i_field_523beb0a)) {
            this.i_field_523beb0a = newName;
            this.I_field_6ec681ff = (long) Math.abs(newName.hashCode());
         }
         this.refreshConfigList();
         iIIIIIIii_Class260.I_method_468cf607(Text.literal("§aКонфиг §f" + oldName + " §aпереименован в §f" + newName));
         return;
      }
      Long var3 = this.I_method_5e8b6a9f(var1);
      if (var3 != null && !i_method_9f123f9a(var2)) {
         this.I_method_8ed57bdb(new Packets.Nested1_a9c7710b(var3, newName));
      } else {
         this.ii_method_6b40627f(var1);
      }
   }

   public void iI_method_9a890e9f(String var1) {
      if (i_method_9f123f9a(var1)) {
         this.ii_method_6b40627f(var1);
         return;
      }
      String name = var1.trim();
      File target = findConfigFile(name);
      if (target != null && target.exists()) {
         try {
            String content = Files.readString(target.toPath(), StandardCharsets.UTF_8);
            String copyName = name + "_copy";
            File dest = new File(I_CONFIGS_DIR, copyName + ".json");
            int i = 1;
            while (dest.exists()) {
               copyName = name + "_copy" + i++;
               dest = new File(I_CONFIGS_DIR, copyName + ".json");
            }
            Files.writeString(dest.toPath(), content, StandardCharsets.UTF_8);
            this.refreshConfigList();
            iIIIIIIii_Class260.I_method_468cf607(Text.literal("§aКонфиг скопирован как §f" + copyName));
            return;
         } catch (Exception var5) {
            RockstarClient.I_field_ab0f6068.error("Config: error duplicating " + name, var5);
         }
      }
      Long var2 = this.I_method_5e8b6a9f(var1);
      if (var2 == null) {
         this.ii_method_6b40627f(var1);
      } else {
         this.I_method_8ed57bdb(new Packets.Nested1_3eeaa41e(var2));
      }
   }

   public void I_method_a9011662(String var1, JsonObject var2) {
      if (!i_method_9f123f9a(var1) && var2 != null) {
         String name = var1.trim();
         try {
            if (!I_CONFIGS_DIR.exists()) {
               I_CONFIGS_DIR.mkdirs();
            }
            File file = new File(I_CONFIGS_DIR, name + ".json");
            IiIIiIII_Class73.I_method_3b2973c6(file, var2);
            this.i_field_523beb0a = name;
            this.I_field_6ec681ff = (long) Math.abs(name.hashCode());
            this.refreshConfigList();
            this.I_method_13058298(var2);
         } catch (Exception var3) {
            RockstarClient.I_field_ab0f6068.error("Config: error saving imported config " + name, var3);
         }
         this.I_method_8ed57bdb(new Packets.Nested1_9addad72(name, var2));
      }
   }

   public void iI_method_2181e015() {
      this.I_field_1232aa16.set(true);

      try {
         IIiiiiIi_Class62.I_method_16b850ac();

         for (ModuleEntry var2 : RockstarClient.getInstance().getModuleManager().getModules()) {
            var2.setEnabled(var2.isEnabledByDefault(), true);
         }
      } finally {
         this.I_field_1232aa16.set(false);
      }

      this.i_field_1232aa16.set(false);
      this.IiI_method_d9f0f62c();
      iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.config.reset")));
   }

   public void ii_method_21906bf5() {
      this.refreshConfigList();
      List var1 = this.I_field_7865b31;
      if (var1.isEmpty()) {
         iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_f25a980a("config.not_found")));
      } else {
         iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_f25a980a("config.list")));
         int var2 = 1;

         for (Packets.Nested1_f320330b var4 : (Iterable<Packets.Nested1_f320330b>)(Iterable<?>)var1) {
            String var5 = var4.name();
            String var6 = ".cfg load \"" + var5.replace("\"", "\\\"") + "\"";
            MutableText var7 = Text.literal("[" + var2++ + "] ")
               .setStyle(Style.EMPTY.withColor(TextColor.fromFormatting(Formatting.GRAY)))
               .append(
                  Text.literal(var5)
                     .setStyle(
                        Style.EMPTY
                           .withColor(TextColor.fromFormatting(var4.active() ? Formatting.GREEN : Formatting.AQUA))
                           .withClickEvent(new ClickEvent(Action.RUN_COMMAND, var6))
                           .withHoverEvent(
                              new HoverEvent(
                                 net.minecraft.text.HoverEvent.Action.SHOW_TEXT, Text.literal(IiIiIIII_Class81.I_method_f25a980a("config.hover_load"))
                              )
                           )
                     )
               );
            if (var4.active()) {
               var7.append(Text.literal(" \u2714").setStyle(Style.EMPTY.withColor(TextColor.fromFormatting(Formatting.GREEN))));
            }

            iIIIIIIii_Class260.Ii_method_12f9d884(var7);
         }
      }
   }

   public List<Packets.Nested1_f320330b> I_method_43bd37db() {
      return this.I_field_7865b31;
   }

   public List<String> i_method_f9096ffb() {
      this.refreshConfigList();
      ArrayList var1 = new ArrayList();

      for (Packets.Nested1_f320330b var3 : this.I_field_7865b31) {
         var1.add(var3.name());
      }

      return var1;
   }

   public String I_method_5c2e4534() {
      return this.i_field_523beb0a;
   }

   public boolean I_method_ce5aebba(String var1) {
      if (this.I_method_5e8b6a9f(var1) != null) return true;
      File f = findConfigFile(var1);
      return f != null && f.exists();
   }

   public void III_method_d82e060c() {
      if (this.i_method_7cf330d0()) {
         this.I_method_8ed57bdb(new Packets.Nested1_f32063a8());
      }
   }

   private Long I_method_5e8b6a9f(String var1) {
      return i_method_9f123f9a(var1) ? null : this.I_field_a567c40b.get(var1.trim().toLowerCase(Locale.ROOT));
   }

   private void Iii_method_d9ff820c() {
      ScheduledFuture var1 = this.I_field_dd9473d7;
      if (var1 != null) {
         var1.cancel(false);
      }

      this.I_field_dd9473d7 = null;
   }

   private static boolean i_method_9f123f9a(String var0) {
      return var0 == null || var0.isBlank();
   }

   private void ii_method_6b40627f(String var1) {
      iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("config.not_found")));
   }

   private boolean i_method_7cf330d0() {
      return RockstarClient.getInstance().I_method_cd3d46d0() != null;
   }

   private void I_method_8ed57bdb(Packet var1) {
      RockNetClient var2 = RockstarClient.getInstance().I_method_cd3d46d0();
      if (var2 != null) {
         var2.send(var1);
      }
   }
}
