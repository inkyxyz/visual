package rockstar.client;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import globals.client.api.RockNetClient;
import globals.shared.proto.Packet;
import globals.shared.proto.Packets;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import net.minecraft.client.MinecraftClient;

public class IIiiIiiiI_Class111 {
   private static final String I_field_523beb0a = "python";
   private static final int I_field_49 = 4194304;
   private static final String i_field_523beb0a = ".py";
   private static final String II_field_523beb0a = ".sync.json";
   private static final long I_field_4a = 400L;
   private static final long i_field_4a = 400L;
   private final Path I_field_46b864df;
   private final Path i_field_46b864df;
   private final Object I_field_5f790d9c = new Object();
   private final Map<String, String> I_field_a567c40b = new HashMap<>();
   private final Map<String, byte[]> i_field_a567c40b = new ConcurrentHashMap<>();
   private volatile boolean I_field_5a = false;
   private volatile WatchService I_field_17ee053e;
   private volatile Thread I_field_72a5fc31;
   private volatile boolean i_field_5a = true;
   private final ScheduledExecutorService I_field_47254ffa = Executors.newSingleThreadScheduledExecutor(var0 -> {
      Thread var1 = new Thread(var0, "Script-Reload");
      var1.setDaemon(true);
      return var1;
   });
   private volatile ScheduledFuture<?> I_field_dd9473d7;

   public IIiiIiiiI_Class111() {
      this.I_field_46b864df = Path.of(IiIIiIII_Class73.I_field_3a58077.getPath(), "scripts");
      this.i_field_46b864df = this.I_field_46b864df.resolve(".sync.json");

      try {
         Files.createDirectories(this.I_field_46b864df);
      } catch (Exception var2) {
         RockstarClient.I_field_ab0f6068
            .error(
               "[Scripts] \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0441\u043e\u0437\u0434\u0430\u0442\u044c \u043f\u0430\u043f\u043a\u0443 \u0441\u043a\u0440\u0438\u043f\u0442\u043e\u0432",
               var2
            );
      }

      this.III_method_207262bf();
      this.Ii_method_9e013cc2();
   }

   public void I_method_5fee925f() {
      this.I_field_5a = false;
      this.I_method_bcdfc748(new Packets.Nested1_8f61585b());
   }

   public void i_method_5ffd1e3f() {
      this.I_field_5a = false;
   }

   public void I_method_3e828150(List<Packets.Nested1_8f5e2529> var1) {
      synchronized (this.I_field_5f790d9c) {
         try {
            this.i_method_32bd4d30(var1 == null ? List.of() : var1);
         } catch (Exception var9) {
            RockstarClient.I_field_ab0f6068.error("[Scripts] reconcile failed", var9);
         } finally {
            this.I_field_5a = true;
         }
      }

      if (var1 != null) {
         for (Packets.Nested1_8f5e2529 var3 : var1) {
            if (var3 != null) {
               IIiiIiIII_Class105.I_method_781d7d50(var3.libraries());
            }
         }
      }
   }

   public void I_method_147e8ae4(String var1, String var2, List<String> var3) {
      if (!I_method_812d826d(var1)) {
         synchronized (this.I_field_5f790d9c) {
            boolean var5 = this.I_method_f7713544(var1).exists();
            this.i_method_b6f65fd3(var1, var2 == null ? "" : var2);
            this.ii_method_9fc42ce2();
            if (!var5) {
               this.iI_method_9fb5a102();
            }
         }

         IIiiIiIII_Class105.I_method_781d7d50(var3);
      }
   }

   public void i_method_3b48e6c4(String var1, String var2, List<String> var3) {
      if (!I_method_812d826d(var1) && var2 != null) {
         synchronized (this.I_field_5f790d9c) {
            byte[] var5;
            try {
               var5 = Base64.getDecoder().decode(var2.trim());
            } catch (Exception var8) {
               RockstarClient.I_field_ab0f6068
                  .error(
                     "[Scripts] \u0431\u0438\u0442\u044b\u0439 \u0437\u0430\u0449\u0438\u0449\u0451\u043d\u043d\u044b\u0439 \u0441\u043a\u0440\u0438\u043f\u0442 {}",
                     var1,
                     var8
                  );
               return;
            }

            byte[] var6 = this.i_field_a567c40b.get(var1);
            if (var6 != null && Arrays.equals(var6, var5)) {
               IIiiIiIII_Class105.I_method_781d7d50(var3);
               return;
            }

            this.i_field_a567c40b.put(var1, var5);
            this.iI_method_9fb5a102();
         }

         IIiiIiIII_Class105.I_method_781d7d50(var3);
      }
   }

   public void I_method_812d8269(String var1) {
      if (!I_method_812d826d(var1)) {
         synchronized (this.I_field_5f790d9c) {
            this.II_method_fbd6262c(var1);
            this.i_field_a567c40b.remove(var1);
            this.ii_method_9fc42ce2();
            this.iI_method_9fb5a102();
         }
      }
   }

   public void I_method_d33843f3(String var1, String var2) {
      if (!I_method_812d826d(var1) && !I_method_812d826d(var2)) {
         synchronized (this.I_field_5f790d9c) {
            this.II_method_18e69cf6(var1, var2);
            byte[] var4 = this.i_field_a567c40b.remove(var1);
            if (var4 != null) {
               this.i_field_a567c40b.put(var2, var4);
            }

            this.ii_method_9fc42ce2();
            this.iI_method_9fb5a102();
         }
      }
   }

   private void i_method_32bd4d30(List<Packets.Nested1_8f5e2529> var1) {
      Map var2 = this.i_method_6a61d634();
      HashMap var3 = new HashMap();

      for (Packets.Nested1_8f5e2529 var5 : var1) {
         if (var5 != null && !I_method_812d826d(var5.name())) {
            var3.put(i_method_7c755977(var5.name()), var5);
         }
      }

      HashSet var15 = new HashSet();
      var15.addAll(var2.keySet());
      var15.addAll(var3.keySet());
      boolean var16 = false;

      for (String var7 : (Iterable<String>)(Iterable<?>)var15) {
         IIiiIiiiI_Class111.Nested1_a5bd8020 var8 = (IIiiIiiiI_Class111.Nested1_a5bd8020)var2.get(var7);
         Packets.Nested1_8f5e2529 var9 = (Packets.Nested1_8f5e2529)var3.get(var7);
         String var10 = this.I_field_a567c40b.get(var7);
         if (var8 != null && var8.I_field_5a) {
            RockstarClient.I_field_ab0f6068
               .warn(
                  "[Scripts] '{}' \u0431\u043e\u043b\u044c\u0448\u0435 {} \u041c\u0411 \u2014 \u0441\u0438\u043d\u0445\u0440\u043e\u043d\u0438\u0437\u0430\u0446\u0438\u044f \u044d\u0442\u043e\u0433\u043e \u0444\u0430\u0439\u043b\u0430 \u043f\u0440\u043e\u043f\u0443\u0449\u0435\u043d\u0430",
                  var8.I_field_523beb0a,
                  4
               );
         } else if (var9 != null && var8 != null) {
            String var17 = II_method_24c76bf4(var8.i_field_523beb0a);
            String var12 = II_method_24c76bf4(var9.source());
            if (var17.equals(var12)) {
               this.I_field_a567c40b.put(var7, var17);
            } else {
               boolean var13 = var10 == null || !var17.equals(var10);
               boolean var14 = var10 == null || !var12.equals(var10);
               if (var13 && !var14) {
                  this.Ii_method_fca4b8d6(var8.I_field_523beb0a, var8.i_field_523beb0a);
               } else {
                  this.i_method_b6f65fd3(var9.name(), var9.source());
               }
            }
         } else if (var9 != null) {
            if (var10 != null && II_method_24c76bf4(var9.source()).equals(var10)) {
               this.Ii_method_cc8d7a0c(var9.name());
            } else {
               this.i_method_b6f65fd3(var9.name(), var9.source());
               var16 = true;
            }
         } else {
            String var11 = II_method_24c76bf4(var8.i_field_523beb0a);
            if (var10 != null && var11.equals(var10)) {
               this.II_method_fbd6262c(var8.I_field_523beb0a);
               var16 = true;
            } else {
               this.Ii_method_fca4b8d6(var8.I_field_523beb0a, var8.i_field_523beb0a);
            }
         }
      }

      this.ii_method_9fc42ce2();
      if (var16) {
         this.iI_method_9fb5a102();
      }
   }

   private void Ii_method_9e013cc2() {
      try {
         WatchService var1 = this.I_field_46b864df.getFileSystem().newWatchService();
         this.I_field_46b864df.register(var1, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);
         this.I_field_17ee053e = var1;
         Thread var2 = new Thread(() -> this.I_method_be8d11d(var1), "Script-Watch");
         var2.setDaemon(true);
         var2.start();
         this.I_field_72a5fc31 = var2;
      } catch (Exception var3) {
         RockstarClient.I_field_ab0f6068
            .error(
               "[Scripts] \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0437\u0430\u043f\u0443\u0441\u0442\u0438\u0442\u044c watcher \u043f\u0430\u043f\u043a\u0438 \u0441\u043a\u0440\u0438\u043f\u0442\u043e\u0432",
               var3
            );
      }
   }

   private void I_method_be8d11d(WatchService var1) {
      while (this.i_field_5a) {
         WatchKey var2;
         try {
            var2 = var1.poll(400L, TimeUnit.MILLISECONDS);
         } catch (InterruptedException var9) {
            Thread.currentThread().interrupt();
            return;
         } catch (Exception var10) {
            return;
         }

         if (var2 != null) {
            HashSet var3 = new HashSet();

            for (WatchEvent var5 : var2.pollEvents()) {
               if (var5.context() instanceof Path var7) {
                  String var8 = var7.getFileName().toString();
                  if (var8.endsWith(".py")) {
                     var3.add(var8);
                  }
               }
            }

            boolean var11 = var2.reset();

            for (String var13 : (Iterable<String>)(Iterable<?>)var3) {
               this.i_method_51e4d649(var13);
            }

            if (!var11) {
               return;
            }
         }
      }
   }

   private void i_method_51e4d649(String var1) {
      synchronized (this.I_field_5f790d9c) {
         if (this.I_field_5a) {
            String var3 = I_method_5c567157(var1);
            String var4 = i_method_7c755977(var3);
            File var5 = this.I_field_46b864df.resolve(var1).toFile();
            if (var5.exists()) {
               if (var5.length() > 4194304L) {
                  RockstarClient.I_field_ab0f6068
                     .warn(
                        "[Scripts] '{}' \u0431\u043e\u043b\u044c\u0448\u0435 {} \u041c\u0411 \u2014 \u043d\u0430 \u0441\u0435\u0440\u0432\u0435\u0440 \u043d\u0435 \u043e\u0442\u043f\u0440\u0430\u0432\u043b\u044f\u0435\u043c",
                        var3,
                        4
                     );
                  return;
               }

               String var6 = I_method_6b0f09ca(var5);
               if (var6 == null) {
                  return;
               }

               String var7 = II_method_24c76bf4(var6);
               if (var7.equals(this.I_field_a567c40b.get(var4))) {
                  return;
               }

               this.I_field_a567c40b.put(var4, var7);
               this.ii_method_9fc42ce2();
               this.I_method_bcdfc748(new Packets.Nested1_8f626b93(var3, "python", var6));
            } else {
               if (!this.I_field_a567c40b.containsKey(var4)) {
                  return;
               }

               this.I_field_a567c40b.remove(var4);
               this.ii_method_9fc42ce2();
               this.I_method_bcdfc748(new Packets.Nested1_27110241(var3));
            }
         }
      }
   }

   private void i_method_b6f65fd3(String var1, String var2) {
      String var3 = var2 == null ? "" : var2;
      this.I_field_a567c40b.put(i_method_7c755977(var1), II_method_24c76bf4(var3));

      try {
         IiIIiIII_Class73.I_method_a06f044d(this.I_method_f7713544(var1), var3);
      } catch (Exception var5) {
         RockstarClient.I_field_ab0f6068
            .error(
               "[Scripts] \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0437\u0430\u043f\u0438\u0441\u0430\u0442\u044c \u0441\u043a\u0440\u0438\u043f\u0442 {}",
               var1,
               var5
            );
      }
   }

   private void II_method_fbd6262c(String var1) {
      this.I_field_a567c40b.remove(i_method_7c755977(var1));

      try {
         Files.deleteIfExists(this.I_method_f7713544(var1).toPath());
      } catch (Exception var3) {
         RockstarClient.I_field_ab0f6068
            .error(
               "[Scripts] \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0443\u0434\u0430\u043b\u0438\u0442\u044c \u0441\u043a\u0440\u0438\u043f\u0442 {}",
               var1,
               var3
            );
      }
   }

   private void II_method_18e69cf6(String var1, String var2) {
      File var3 = this.I_method_f7713544(var1);
      File var4 = this.I_method_f7713544(var2);
      String var5 = this.I_field_a567c40b.get(i_method_7c755977(var1));
      this.I_field_a567c40b.remove(i_method_7c755977(var1));
      if (var5 != null) {
         this.I_field_a567c40b.put(i_method_7c755977(var2), var5);
      }

      try {
         if (var3.exists()) {
            Files.deleteIfExists(var4.toPath());
            Files.move(var3.toPath(), var4.toPath());
         }
      } catch (Exception var7) {
         RockstarClient.I_field_ab0f6068
            .error(
               "[Scripts] \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u043f\u0435\u0440\u0435\u0438\u043c\u0435\u043d\u043e\u0432\u0430\u0442\u044c \u0441\u043a\u0440\u0438\u043f\u0442 {} -> {}",
               new Object[]{var1, var2, var7}
            );
      }
   }

   private Map<String, IIiiIiiiI_Class111.Nested1_a5bd8020> i_method_6a61d634() {
      HashMap var1 = new HashMap();
      if (!Files.exists(this.I_field_46b864df)) {
         return var1;
      } else {
         try (Stream<Path> var2 = Files.list(this.I_field_46b864df)) {
            var2.filter(var0 -> Files.isRegularFile(var0)).filter(var0 -> ((java.nio.file.Path)var0).getFileName().toString().endsWith(".py")).forEach(var1x -> {
               String var2x = I_method_5c567157(((java.nio.file.Path)var1x).getFileName().toString());
               File var3 = ((java.nio.file.Path)var1x).toFile();
               if (var3.length() > 4194304L) {
                  var1.put(i_method_7c755977(var2x), new IIiiIiiiI_Class111.Nested1_a5bd8020(var2x, "", true));
               } else {
                  String var4 = I_method_6b0f09ca(var3);
                  if (var4 != null) {
                     var1.put(i_method_7c755977(var2x), new IIiiIiiiI_Class111.Nested1_a5bd8020(var2x, var4, false));
                  }
               }
            });
         } catch (Exception var7) {
            RockstarClient.I_field_ab0f6068
               .error(
                  "[Scripts] \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u043f\u0440\u043e\u0447\u0438\u0442\u0430\u0442\u044c \u043f\u0430\u043f\u043a\u0443 \u0441\u043a\u0440\u0438\u043f\u0442\u043e\u0432",
                  var7
               );
         }

         return var1;
      }
   }

   private void Ii_method_fca4b8d6(String var1, String var2) {
      this.I_field_a567c40b.put(i_method_7c755977(var1), II_method_24c76bf4(var2 == null ? "" : var2));
      this.I_method_bcdfc748(new Packets.Nested1_8f626b93(var1, "python", var2 == null ? "" : var2));
   }

   private void Ii_method_cc8d7a0c(String var1) {
      this.I_field_a567c40b.remove(i_method_7c755977(var1));
      this.I_method_bcdfc748(new Packets.Nested1_27110241(var1));
   }

   private void iI_method_9fb5a102() {
      ScheduledFuture var1 = this.I_field_dd9473d7;
      if (var1 != null) {
         var1.cancel(false);
      }

      this.I_field_dd9473d7 = this.I_field_47254ffa.schedule(() -> MinecraftClient.getInstance().execute(() -> {
         try {
            IIiiIIiiI_Class103 var0 = RockstarClient.getInstance().I_method_a90eb842();
            if (var0 != null) {
               var0.II_method_14c48d02();
            }
         } catch (Exception var1x) {
            RockstarClient.I_field_ab0f6068.error("[Scripts] py.reload failed", var1x);
         }
      }), 400L, TimeUnit.MILLISECONDS);
   }

   private void ii_method_9fc42ce2() {
      try {
         JsonObject var1 = new JsonObject();

         for (Entry var3 : this.I_field_a567c40b.entrySet()) {
            var1.addProperty((String)var3.getKey(), (String)var3.getValue());
         }

         IiIIiIII_Class73.I_method_a06f044d(this.i_field_46b864df.toFile(), var1.toString());
      } catch (Exception var4) {
         RockstarClient.I_field_ab0f6068
            .error(
               "[Scripts] \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0441\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c baseline \u0441\u0438\u043d\u043a\u0430",
               var4
            );
      }
   }

   private void III_method_207262bf() {
      try {
         if (!Files.exists(this.i_field_46b864df)) {
            return;
         }

         String var1 = Files.readString(this.i_field_46b864df, StandardCharsets.UTF_8);
         JsonObject var2 = JsonParser.parseString(var1).getAsJsonObject();

         for (String var4 : var2.keySet()) {
            this.I_field_a567c40b.put(var4, var2.get(var4).getAsString());
         }
      } catch (Exception var5) {
         RockstarClient.I_field_ab0f6068
            .error(
               "[Scripts] \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u043f\u0440\u043e\u0447\u0438\u0442\u0430\u0442\u044c baseline \u0441\u0438\u043d\u043a\u0430",
               var5
            );
      }
   }

   public void II_method_9df2b0e2() {
      this.i_field_5a = false;

      try {
         WatchService var1 = this.I_field_17ee053e;
         if (var1 != null) {
            var1.close();
         }
      } catch (Exception var2) {
      }

      Thread var3 = this.I_field_72a5fc31;
      if (var3 != null) {
         var3.interrupt();
      }

      this.I_field_47254ffa.shutdownNow();
   }

   private File I_method_f7713544(String var1) {
      return this.I_field_46b864df.resolve(var1 + ".py").toFile();
   }

   public Map<String, byte[]> I_method_d8259254() {
      return new HashMap<>(this.i_field_a567c40b);
   }

   private static String I_method_5c567157(String var0) {
      int var1 = var0.lastIndexOf(46);
      return var1 > 0 ? var0.substring(0, var1) : var0;
   }

   private static String i_method_7c755977(String var0) {
      return var0.trim().toLowerCase(Locale.ROOT);
   }

   private static boolean I_method_812d826d(String var0) {
      return var0 == null || var0.isBlank();
   }

   private static String I_method_6b0f09ca(File var0) {
      try {
         return Files.readString(var0.toPath(), StandardCharsets.UTF_8);
      } catch (Exception var2) {
         return null;
      }
   }

   private static String II_method_24c76bf4(String var0) {
      try {
         MessageDigest var1 = MessageDigest.getInstance("SHA-256");
         byte[] var2 = var1.digest((var0 == null ? "" : var0).getBytes(StandardCharsets.UTF_8));
         StringBuilder var3 = new StringBuilder(var2.length * 2);

         for (byte var7 : var2) {
            var3.append(Character.forDigit(var7 >> 4 & 15, 16)).append(Character.forDigit(var7 & 15, 16));
         }

         return var3.toString();
      } catch (Exception var8) {
         return Integer.toHexString((var0 == null ? "" : var0).hashCode());
      }
   }

   private void I_method_bcdfc748(Packet var1) {
      RockNetClient var2 = RockstarClient.getInstance().I_method_cd3d46d0();
      if (var2 != null) {
         var2.send(var1);
      }
   }

   static final class Nested1_a5bd8020 {
      final String I_field_523beb0a;
      final String i_field_523beb0a;
      final boolean I_field_5a;

      Nested1_a5bd8020(String var1, String var2, boolean var3) {
         this.I_field_523beb0a = var1;
         this.i_field_523beb0a = var2;
         this.I_field_5a = var3;
      }

      @Override
      public final String toString() {
         return "Nested1_a5bd8020[name=" + this.I_field_523beb0a + ", source=" + this.i_field_523beb0a + ", oversize=" + this.I_field_5a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IIiiIiiiI_Class111.Nested1_a5bd8020 other = (IIiiIiiiI_Class111.Nested1_a5bd8020) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.i_field_523beb0a, other.i_field_523beb0a)
            && java.util.Objects.equals(this.I_field_5a, other.I_field_5a);
      }

      public String I_method_54454446() {
         return this.I_field_523beb0a;
      }

      public String i_method_e763f466() {
         return this.i_field_523beb0a;
      }

      public boolean I_method_df7979e() {
         return this.I_field_5a;
      }
   }
}
