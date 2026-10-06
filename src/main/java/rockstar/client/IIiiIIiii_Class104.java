package rockstar.client;

import com.google.gson.JsonElement;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import jep.SharedInterpreter;
import lombok.Generated;
import net.minecraft.text.Text;
import pyrock.Client;
import pyrock.GlobalVars;
import pyrock.classes.PyCommand;
import pyrock.classes.PyHudElement;
import pyrock.classes.PyIslandStatus;
import pyrock.classes.PyRotations;
import pyrock.classes.aura.PyAura;
import pyrock.events.PyEvents;
import pyrock.utility.render.PyShader;
import pyrock.utility.render.PyShaders;

public class IIiiIIiii_Class104 {
   private static final AtomicInteger I_field_bc9b37c0 = new AtomicInteger();
   private final File I_field_3a58077;
   private final String I_field_523beb0a;
   private final String i_field_523beb0a;
   private final byte[] I_field_b47;
   private volatile PyEvents I_field_22e69f98;
   private volatile boolean I_field_5a;
   private volatile String II_field_523beb0a;
   private WatchService I_field_17ee053e;
   private WatchKey I_field_c0216ed4;
   private volatile boolean i_field_5a;
   private long I_field_4a;
   private final List<IiIiiiiI_Class95> I_field_7865b31 = new ArrayList<>();
   private final List<PyHudElement> i_field_7865b31 = new ArrayList<>();
   private final List<PyCommand> II_field_7865b31 = new ArrayList<>();
   private final List<PyShader> Ii_field_7865b31 = new ArrayList<>();
   private final Map<ModuleEntry, List<Setting>> I_field_a567c40b = new HashMap<>();
   private final Map<Setting, JsonElement> i_field_a567c40b = new HashMap<>();
   private final Map<ModeSetting, List<ModeSetting.Nested1_42765c60>> II_field_a567c40b = new HashMap<>();
   private final Map<MultiSelectSetting, List<MultiSelectSetting.Nested1_42856060>> Ii_field_a567c40b = new HashMap<>();
   private static IIiiIIiii_Class104 I_field_8385b66c;

   public static AutoCloseable I_method_5edeb6c9(IIiiIIiii_Class104 var0) {
      IIiiIIiii_Class104 var1 = I_field_8385b66c;
      I_field_8385b66c = var0;
      return () -> I_field_8385b66c = var1;
   }

   public static IIiiIIiii_Class104 I_method_204b62f5() {
      return I_field_8385b66c;
   }

   public IIiiIIiii_Class104(String var1) {
      this.I_field_523beb0a = var1;
      this.I_field_b47 = null;
      this.i_field_523beb0a = I_method_92cea597(var1);
      File var2 = new File(IiIIiIII_Class73.I_field_3a58077, "scripts");
      if (!var2.exists()) {
         var2.mkdirs();
      }

      this.I_field_3a58077 = new File(var2, var1 + ".py");
   }

   public IIiiIIiii_Class104(String var1, byte[] var2) {
      this.I_field_523beb0a = var1;
      this.I_field_b47 = var2;
      this.i_field_523beb0a = I_method_92cea597(var1);
      this.I_field_3a58077 = null;
   }

   private static String I_method_92cea597(String var0) {
      return "__ns_" + var0.replaceAll("[^A-Za-z0-9_]", "_") + "_" + I_field_bc9b37c0.incrementAndGet();
   }

   public static void I_method_cc701ac0(IiIiiiiI_Class95 var0) {
      if (I_field_8385b66c != null) {
         I_field_8385b66c.I_method_3f6f2a48().add(var0);
      }
   }

   public static void I_method_cec5c0aa(PyHudElement var0) {
      if (I_field_8385b66c != null && var0 != null) {
         I_field_8385b66c.i_field_7865b31.add(var0);
      }
   }

   public static void I_method_644776eb(PyShader var0) {
      if (I_field_8385b66c != null && var0 != null && !I_field_8385b66c.Ii_field_7865b31.contains(var0)) {
         if (I_field_8385b66c.Ii_field_7865b31.size() >= 32) {
            throw new IllegalStateException(
               "\u0441\u043a\u0440\u0438\u043f\u0442 \u0441\u043e\u0437\u0434\u0430\u043b \u0431\u043e\u043b\u044c\u0448\u0435 32 \u0448\u0435\u0439\u0434\u0435\u0440\u043e\u0432: \u0432\u0435\u0440\u043e\u044f\u0442\u043d\u043e, create() \u0437\u043e\u0432\u0451\u0442\u0441\u044f \u0432\u043d\u0443\u0442\u0440\u0438 \u043e\u0442\u0440\u0438\u0441\u043e\u0432\u043a\u0438"
            );
         } else {
            I_field_8385b66c.Ii_field_7865b31.add(var0);
         }
      }
   }

   public static void I_method_5edf8af6(PyCommand var0) {
      if (I_field_8385b66c != null && var0 != null && !I_field_8385b66c.II_field_7865b31.contains(var0)) {
         I_field_8385b66c.II_field_7865b31.add(var0);
      }
   }

   public static void I_method_9fdd7f66(ModuleEntry var0, Setting var1) {
      if (I_field_8385b66c != null) {
         I_field_8385b66c.I_field_a567c40b.computeIfAbsent(var0, var0x -> new ArrayList<>()).add(var1);
      }
   }

   public static void I_method_dacf28a7(Setting var0) {
      if (I_field_8385b66c != null && !I_field_8385b66c.i_field_a567c40b.containsKey(var0)) {
         I_field_8385b66c.i_field_a567c40b.put(var0, var0.toJson());
      }
   }

   public static void I_method_e79f349a(ModeSetting var0, ModeSetting.Nested1_42765c60 var1) {
      if (I_field_8385b66c != null) {
         I_field_8385b66c.II_field_a567c40b.computeIfAbsent(var0, var0x -> new ArrayList<>()).add(var1);
      }
   }

   public static boolean I_method_e79f349e(ModeSetting var0, ModeSetting.Nested1_42765c60 var1) {
      if (I_field_8385b66c != null && var0 != null && var1 != null) {
         List var2 = I_field_8385b66c.II_field_a567c40b.get(var0);
         return var2 != null && var2.contains(var1);
      } else {
         return false;
      }
   }

   public static void i_method_a818a07a(ModeSetting var0, ModeSetting.Nested1_42765c60 var1) {
      if (I_field_8385b66c != null && var0 != null && var1 != null) {
         List var2 = I_field_8385b66c.II_field_a567c40b.get(var0);
         if (var2 != null) {
            var2.remove(var1);
            if (var2.isEmpty()) {
               I_field_8385b66c.II_field_a567c40b.remove(var0);
            }
         }
      }
   }

   public static void I_method_19f1b49a(MultiSelectSetting var0, MultiSelectSetting.Nested1_42856060 var1) {
      if (I_field_8385b66c != null) {
         I_field_8385b66c.Ii_field_a567c40b.computeIfAbsent(var0, var0x -> new ArrayList<>()).add(var1);
      }
   }

   public final void I_method_dfbc61f() {
      if (this.I_field_5a) {
         this.I_method_dfbc623();
      }

      if (!IIiiIiIIi_Class106.I_method_fd9ca243()) {
         iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("python.runtime_missing")));
      } else {
         IIiiIiIIi_Class106.I_method_430af73d(this::i_method_e0a51ff);
      }
   }

   private void i_method_e0a51ff() {
      try {
         try (AutoCloseable var1 = I_method_5edeb6c9(this)) {
            boolean var14 = this.I_field_b47 != null;
            if (!var14 && !this.I_field_3a58077.exists()) {
               RockstarClient.I_field_ab0f6068.warn(IiIiIIII_Class81.I_method_1410d1e5("lua.script.file_missing", this.I_field_523beb0a));
               this.i_method_35e0d6d5();
            }

            this.II_field_523beb0a = null;
            PyEvents var3 = new PyEvents(this);
            var3.setErrorHandler(var1x -> {
               this.II_field_523beb0a = var1x.getMessage() != null ? var1x.getMessage() : var1x.getClass().getSimpleName();
               iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_1410d1e5("lua.script_error", this.I_field_523beb0a)));
               this.I_method_dfbc623();
            });
            this.I_field_22e69f98 = var3;
            RockstarClient.I_field_ab0f6068.info(IiIiIIII_Class81.I_method_1410d1e5("lua.script.execution.running", this.I_field_523beb0a));
            SharedInterpreter var4 = IIiiIiIIi_Class106.I_method_f423a055();
            if (var4 != null && IIiiIiIIi_Class106.i_method_fdab2e23()) {
               var4.set("__ev", var3);
               var4.set("__cl", new Client());
               var4.set("__mc", iIIiIIiIi_Class294.I_field_3a9bda27);
               var4.set("__gv", new GlobalVars());
               var4.set("__pa", new PyAura());
               var4.set("__pr", new PyRotations());
               var4.exec(this.i_field_523beb0a + " = __rockstar_make_ns(__ev, __cl, __mc, __gv, __pa, __pr)");
               if (var14) {
                  var4.set("__b64", Base64.getEncoder().encodeToString(this.I_field_b47));
                  var4.exec("import marshal, base64");
                  var4.exec("exec(marshal.loads(base64.b64decode(__b64)), " + this.i_field_523beb0a + ")");
                  var4.exec("del __ev, __cl, __mc, __gv, __pa, __pr, __b64");
               } else {
                  String var5 = Files.readString(this.I_field_3a58077.toPath());
                  var4.set("__code", var5);
                  var4.exec("exec(compile(__code, " + i_method_b2ed8db7(this.I_field_523beb0a) + ", 'exec'), " + this.i_field_523beb0a + ")");
                  var4.exec("del __ev, __cl, __mc, __gv, __pa, __pr, __code");
               }

               this.II_method_b18bf522();

               for (IiIiiiiI_Class95 var6 : this.I_field_7865b31) {
                  var6.III_method_fbb67e0c();
                  IIiiiiIi_Class62.I_method_304dd711(var6);
               }

               for (Entry var17 : this.I_field_a567c40b.entrySet()) {
                  for (Setting var8 : (Iterable<Setting>)(Iterable<?>)(List)var17.getValue()) {
                     IIiiiiIi_Class62.I_method_c807f2fd((ModuleEntry)var17.getKey(), var8);
                  }
               }

               IiiiiiiI_Class127.I_method_e1e653cb().i_method_67267988(this);
               this.I_field_5a = true;
               RockstarClient.getInstance().I_method_a90eb842().I_method_d760b23f();
               if (!var14) {
                  this.I_field_4a = this.I_field_3a58077.lastModified();
                  this.IiI_method_81c4969f();
               }

               RockstarClient.I_field_ab0f6068.info(IiIiIIII_Class81.I_method_1410d1e5("lua.script.load.success_log", this.I_field_523beb0a));
               iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("lua.script.load.success", this.I_field_523beb0a)));
               return;
            }

            iIIIIIIii_Class260.II_method_e8fd4864(
               Text.of(IiIiIIII_Class81.I_method_1410d1e5("python.init_failed", String.valueOf(IIiiIiIIi_Class106.I_method_681c3841())))
            );
            this.I_method_dfbc623();
         }

         return;
      } catch (Exception var11) {
         String var13 = var11.getMessage() != null ? var11.getMessage() : var11.getClass().getSimpleName();
         this.II_field_523beb0a = var13;
         iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_1410d1e5("lua.script.load.error", this.I_field_523beb0a, var13)));
         RockstarClient.I_field_ab0f6068.error(IiIiIIII_Class81.I_method_1410d1e5("lua.script.load.error_log", this.I_field_523beb0a), var11);
         this.I_method_dfbc623();
      } catch (Throwable var12) {
         String var2 = var12.getMessage() != null ? var12.getMessage() : var12.getClass().getSimpleName();
         this.II_field_523beb0a = var2;
         iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_1410d1e5("lua.script.load.error", this.I_field_523beb0a, var2)));
         RockstarClient.I_field_ab0f6068.error(IiIiIIII_Class81.I_method_1410d1e5("lua.script.load.error_log", this.I_field_523beb0a), var12);
         this.I_method_dfbc623();
      }
   }

   private void II_method_b18bf522() {
      if (!this.i_field_7865b31.isEmpty() && RockstarClient.getInstance().I_method_35687482() != null) {
         if (RockstarClient.getInstance().I_method_7a4c3f0b().I_method_3272b401("client") instanceof IiIIiIiI_Class75 var1) {
            var1.I_method_759d87f5(this.i_field_7865b31);
         }
      }
   }

   public final boolean I_method_dfbc623() {
      if (!this.I_field_5a && this.I_field_22e69f98 == null) {
         return false;
      } else {
         boolean var1 = this.I_field_5a;
         this.I_field_5a = false;
         if (var1) {
            RockstarClient.getInstance().I_method_a90eb842().i_method_d76f3e1f();
         }

         for (ModuleEntry var3 : this.I_field_7865b31) {
            IIiiiiIi_Class62.I_method_304dd70d(var3);
         }

         for (ModuleEntry var9 : this.I_field_7865b31) {
            if (var9.isEnabled()) {
               var9.setEnabled(false, true);
            }
         }

         if (RockstarClient.getInstance().getModuleManager().getModules().removeAll(this.I_field_7865b31)) {
            ModuleManager.I_method_7056a46c();
         }

         this.I_field_7865b31.clear();
         this.III_method_8001a67f();
         this.iI_method_b34ee542();
         this.ii_method_b35d7122();
         IiIIIIiiI_Class135.I_method_6711347b(this);
         IiIiIIIi_Class82.I_method_14e5548(this);
         IiiiiiiI_Class127.I_method_e1e653cb().I_method_966f25a8(this);

         for (Entry var10 : this.I_field_a567c40b.entrySet()) {
            for (Setting var5 : (Iterable<Setting>)(Iterable<?>)(List)var10.getValue()) {
               IIiiiiIi_Class62.I_method_c807f2f9((ModuleEntry)var10.getKey(), var5);
            }

            ((ModuleEntry)var10.getKey()).getSettings().removeAll((Collection<?>)var10.getValue());
         }

         this.I_field_a567c40b.clear();
         this.Ii_method_b19a8102();
         this.II_field_a567c40b.clear();
         this.IIi_method_8010325f();
         this.Ii_field_a567c40b.clear();

         for (Entry var11 : this.i_field_a567c40b.entrySet()) {
            ((Setting)var11.getKey()).fromJson((JsonElement)var11.getValue());
         }

         this.i_field_a567c40b.clear();
         if (this.I_field_22e69f98 != null) {
            this.I_field_22e69f98.dispose();
         }

         this.I_field_22e69f98 = null;
         this.Iii_method_81d3227f();
         if (IIiiIiIIi_Class106.i_method_fdab2e23()) {
            IIiiIiIIi_Class106.I_method_430af73d(() -> {
               try {
                  IIiiIiIIi_Class106.I_method_f423a055().exec("globals().pop('" + this.i_field_523beb0a + "', None)");
               } catch (Exception var2) {
               }
            });
         }

         RockstarClient.I_field_ab0f6068.info(IiIiIIII_Class81.I_method_1410d1e5("lua.script.unload", this.I_field_523beb0a));
         return true;
      }
   }

   private void Ii_method_b19a8102() {
      for (Entry var2 : this.II_field_a567c40b.entrySet()) {
         ModeSetting var3 = (ModeSetting)var2.getKey();
         List var4 = (List)var2.getValue();
         ModeSetting.Nested1_42765c60 var5 = var3.i_method_f85f3850();
         boolean var6 = var5 != null && var4.contains(var5);
         var3.I_method_e1d4a248().removeIf(var4::contains);
         if (var6) {
            var3.i_method_89901e42(var3.I_method_e1d4a248().isEmpty() ? null : var3.I_method_e1d4a248().getFirst());
         }
      }
   }

   private void iI_method_b34ee542() {
      for (PyCommand var2 : new ArrayList<>(this.II_field_7865b31)) {
         try {
            var2.remove();
         } catch (Throwable var4) {
         }
      }

      this.II_field_7865b31.clear();
   }

   private void ii_method_b35d7122() {
      for (PyShader var2 : new ArrayList<>(this.Ii_field_7865b31)) {
         try {
            PyShaders.release(var2);
         } catch (Throwable var4) {
         }
      }

      this.Ii_field_7865b31.clear();
   }

   private void III_method_8001a67f() {
      if (!this.i_field_7865b31.isEmpty() && RockstarClient.getInstance().I_method_35687482() != null) {
         for (PyHudElement var2 : new ArrayList<>(this.i_field_7865b31)) {
            IiIIiIiI_Class75.I_method_6a4509fa(var2);
            var2.dispose();
            RockstarClient.getInstance().I_method_35687482().III_method_812fc188().remove(var2);
         }

         this.i_field_7865b31.clear();
      } else {
         this.i_field_7865b31.clear();
      }
   }

   private void IIi_method_8010325f() {
      for (Entry var2 : this.Ii_field_a567c40b.entrySet()) {
         MultiSelectSetting var3 = (MultiSelectSetting)var2.getKey();
         List var4 = (List)var2.getValue();

         for (MultiSelectSetting.Nested1_42856060 var6 : (Iterable<MultiSelectSetting.Nested1_42856060>)(Iterable<?>)var4) {
            if (var6 instanceof PyIslandStatus var7) {
               if (RockstarClient.getInstance().I_method_35687482() != null && RockstarClient.getInstance().I_method_35687482().I_method_35128395() != null) {
                  RockstarClient.getInstance().I_method_35687482().I_method_35128395().i_method_c24e9cab(var7);
               }

               var7.dispose();
            }
         }

         var3.i_method_faf6de68().removeIf(var4::contains);
         var3.I_method_45aaa648().removeIf(var4::contains);
      }
   }

   public final IIiiIIiii_Class104 i_method_35e0d6d5() {
      if (this.I_field_3a58077 != null && !this.I_field_3a58077.exists()) {
         try {
            if (!this.I_field_3a58077.createNewFile()) {
               throw new IOException(IiIiIIII_Class81.I_method_1410d1e5("lua.script.create_file_error", this.I_field_3a58077.getAbsolutePath()));
            }

            try (FileWriter var1 = new FileWriter(this.I_field_3a58077)) {
               var1.write(IiIiIIII_Class81.I_method_f25a980a("lua.script.template"));
            }
         } catch (IOException var6) {
            RockstarClient.I_field_ab0f6068.error(IiIiIIII_Class81.I_method_f25a980a("lua.script.save_error"), var6);
         }

         return this;
      } else {
         return this;
      }
   }

   public final boolean i_method_e0a5203() {
      this.I_method_dfbc623();
      if (this.I_field_3a58077 == null) {
         RockstarClient.getInstance().I_method_a90eb842().i_method_619cb248().remove(this);
         return true;
      } else if (this.I_field_3a58077.exists() && this.I_field_3a58077.delete()) {
         RockstarClient.getInstance().I_method_a90eb842().i_method_619cb248().remove(this);
         RockstarClient.I_field_ab0f6068.info(IiIiIIII_Class81.I_method_1410d1e5("lua.script.delete.success", this.I_field_3a58077.getAbsolutePath()));
         return true;
      } else {
         RockstarClient.I_field_ab0f6068.warn(IiIiIIII_Class81.I_method_1410d1e5("lua.script.delete.error", this.I_field_3a58077.getAbsolutePath()));
         return false;
      }
   }

   private static String i_method_b2ed8db7(String var0) {
      return "'" + var0.replace("\\", "\\\\").replace("'", "\\'") + "'";
   }

   private void IiI_method_81c4969f() {
      try {
         this.I_field_17ee053e = FileSystems.getDefault().newWatchService();
         Path var1 = this.I_field_3a58077.toPath().getParent();
         this.I_field_c0216ed4 = var1.register(this.I_field_17ee053e, StandardWatchEventKinds.ENTRY_MODIFY);
         this.i_field_5a = true;
         Thread var2 = new Thread(() -> {
            try {
               while (this.i_field_5a) {
                  WatchKey var1x = this.I_field_17ee053e.poll(500L, TimeUnit.MILLISECONDS);
                  if (var1x != null) {
                     for (WatchEvent var3x : var1x.pollEvents()) {
                        Path var4 = (Path)var3x.context();
                        if (var4.toString().equals(this.I_field_3a58077.getName())) {
                           long var5 = this.I_field_3a58077.lastModified();
                           if (var5 != this.I_field_4a) {
                              this.I_field_4a = var5;
                              Thread.sleep(100L);
                              iIIiIIiIi_Class294.I_field_3a9bda27.execute(this::iII_method_b69cba5f);
                           }
                        }
                     }

                     var1x.reset();
                  }
               }
            } catch (Exception var7) {
               if (this.i_field_5a) {
                  RockstarClient.I_field_ab0f6068.error("File watcher error: {}", var7.getMessage());
               }
            }
         }, "Python-Watcher-" + this.I_field_523beb0a);
         var2.setDaemon(true);
         var2.start();
      } catch (Exception var3) {
         RockstarClient.I_field_ab0f6068.error("Failed to start file watcher: {}", var3.getMessage());
      }
   }

   private void Iii_method_81d3227f() {
      this.i_field_5a = false;

      try {
         if (this.I_field_c0216ed4 != null) {
            this.I_field_c0216ed4.cancel();
            this.I_field_c0216ed4 = null;
         }

         if (this.I_field_17ee053e != null) {
            this.I_field_17ee053e.close();
            this.I_field_17ee053e = null;
         }
      } catch (Exception var2) {
         RockstarClient.I_field_ab0f6068.error("Failed to stop file watcher: {}", var2.getMessage());
      }
   }

   private void iII_method_b69cba5f() {
      this.I_method_dfbc623();
      this.I_method_dfbc61f();
   }

   @Generated
   public File I_method_c8d5294e() {
      return this.I_field_3a58077;
   }

   @Generated
   public String I_method_332d5061() {
      return this.I_field_523beb0a;
   }

   @Generated
   public String i_method_c64c0081() {
      return this.i_field_523beb0a;
   }

   @Generated
   public byte[] I_method_b17cfe9e() {
      return this.I_field_b47;
   }

   @Generated
   public PyEvents I_method_9ab667af() {
      return this.I_field_22e69f98;
   }

   @Generated
   public boolean II_method_b18bf526() {
      return this.I_field_5a;
   }

   @Generated
   public String II_method_37d6a7be() {
      return this.II_field_523beb0a;
   }

   @Generated
   public WatchService I_method_13dde9d5() {
      return this.I_field_17ee053e;
   }

   @Generated
   public WatchKey I_method_37f136eb() {
      return this.I_field_c0216ed4;
   }

   @Generated
   public boolean Ii_method_b19a8106() {
      return this.i_field_5a;
   }

   @Generated
   public long I_method_dfbc613() {
      return this.I_field_4a;
   }

   @Generated
   public List<IiIiiiiI_Class95> I_method_3f6f2a48() {
      return this.I_field_7865b31;
   }

   @Generated
   public List<PyHudElement> i_method_f4bb6268() {
      return this.i_field_7865b31;
   }

   @Generated
   public List<PyCommand> II_method_7650b4e5() {
      return this.II_field_7865b31;
   }

   @Generated
   public List<PyShader> Ii_method_2b9ced05() {
      return this.Ii_field_7865b31;
   }

   @Generated
   public Map<ModuleEntry, List<Setting>> I_method_862d3614() {
      return this.I_field_a567c40b;
   }

   @Generated
   public Map<Setting, JsonElement> i_method_186979f4() {
      return this.i_field_a567c40b;
   }

   @Generated
   public Map<ModeSetting, List<ModeSetting.Nested1_42765c60>> II_method_3d163d7() {
      return this.II_field_a567c40b;
   }

   @Generated
   public Map<MultiSelectSetting, List<MultiSelectSetting.Nested1_42856060>> Ii_method_960da7b7() {
      return this.Ii_field_a567c40b;
   }
}
