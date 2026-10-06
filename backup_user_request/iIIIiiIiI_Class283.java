package rockstar.client;

import com.mojang.logging.LogUtils;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.client.network.ServerInfo.ServerType;
import net.minecraft.client.option.ServerList;
import net.minecraft.util.Util;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

public final class iIIIiiIiI_Class283 {
   private static final Logger I_field_ab0f6068 = LogUtils.getLogger();
   private static final HttpClient I_field_d877234 = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(3L)).build();
   private static volatile boolean I_field_5a;
   private static volatile List<iIIIiiIiI_Class283.Nested1_58a4d460> I_field_7865b31 = List.of();

   private iIIIiiIiI_Class283() {
   }

   public static void I_method_35a51568(MinecraftClient var0, ServerList var1, Runnable var2) {
      List var3 = I_method_d922b061(var0);
      if (I_method_1cce1be9(var1, var3, var3)) {
         var2.run();
      }

      CompletableFuture.supplyAsync(iIIIiiIiI_Class283::I_method_3108e228, Util.getIoWorkerExecutor()).thenAccept(var3x -> {
         if (!var3x.isEmpty()) {
            var0.execute(() -> {
               List var4 = I_field_7865b31;
               I_method_25ed7217(var0, var3x);
               if (I_method_1cce1be9(var1, var3x, var4)) {
                  var2.run();
               }
            });
         }
      });
   }

   public static boolean I_method_8f9b3f84(@Nullable ServerInfo var0) {
      if (var0 == null) {
         return false;
      } else {
         for (iIIIiiIiI_Class283.Nested1_58a4d460 var2 : I_field_7865b31) {
            if (var2.I_method_f7b58c9(var0)) {
               return true;
            }
         }

         return false;
      }
   }

   private static List<iIIIiiIiI_Class283.Nested1_58a4d460> I_method_3108e228() {
      try {
         HttpRequest var0 = HttpRequest.newBuilder(URI.create("https://vontam.su/minecraft/ips.php"))
            .timeout(Duration.ofSeconds(3L))
            .header("User-Agent", "Rockstar/1.0")
            .GET()
            .build();
         HttpResponse var1 = I_field_d877234.send(var0, BodyHandlers.ofString());
         return var1.statusCode() >= 200 && var1.statusCode() < 300 ? I_method_48ffd4de((String)var1.body()) : List.of();
      } catch (Exception var2) {
         I_field_ab0f6068.debug("Failed to fetch pinned multiplayer server", var2);
         return List.of();
      }
   }

   private static List<iIIIiiIiI_Class283.Nested1_58a4d460> I_method_d922b061(MinecraftClient var0) {
      if (I_field_5a) {
         return I_field_7865b31;
      } else {
         synchronized (iIIIiiIiI_Class283.class) {
            if (I_field_5a) {
               return I_field_7865b31;
            } else {
               I_field_5a = true;

               try {
                  Path var2 = I_method_9ac6a20f(var0);
                  if (!Files.exists(var2)) {
                     return I_field_7865b31;
                  }

                  I_field_7865b31 = I_method_48ffd4de(Files.readString(var2));
               } catch (Exception var4) {
                  I_field_ab0f6068.debug("Failed to load pinned multiplayer server cache", var4);
               }

               return I_field_7865b31;
            }
         }
      }
   }

   private static void I_method_25ed7217(MinecraftClient var0, List<iIIIiiIiI_Class283.Nested1_58a4d460> var1) {
      I_field_7865b31 = List.copyOf(var1);
      I_field_5a = true;

      try {
         Files.writeString(
            I_method_9ac6a20f(var0),
            var1.stream().map(iIIIiiIiI_Class283.Nested1_58a4d460::II_method_b63b1439).collect(Collectors.joining(System.lineSeparator()))
         );
      } catch (IOException var3) {
         I_field_ab0f6068.debug("Failed to store pinned multiplayer server cache", var3);
      }
   }

   private static boolean I_method_1cce1be9(ServerList var0, List<iIIIiiIiI_Class283.Nested1_58a4d460> var1, List<iIIIiiIiI_Class283.Nested1_58a4d460> var2) {
      if (var1.isEmpty()) {
         return false;
      } else {
         boolean var3 = false;
         ArrayList var4 = new ArrayList(var1.size());

         for (iIIIiiIiI_Class283.Nested1_58a4d460 var6 : var1) {
            iIIIiiIiI_Class283.Nested1_58a4d460 var7 = I_method_ee3e0802(var2, var6);
            ServerInfo var8 = I_method_ed01fb63(var0, var4, var6, var7);
            if (var8 == null) {
               var8 = new ServerInfo(var6.I_method_a29be886(), var6.i_method_35ba98a6(), ServerType.OTHER);
               var0.add(var8, false);
               var3 = true;
            }

            if (!Objects.equals(var8.name, var6.I_method_a29be886())) {
               var8.name = var6.I_method_a29be886();
               var3 = true;
            }

            if (!Objects.equals(var8.address, var6.i_method_35ba98a6())) {
               var8.address = var6.i_method_35ba98a6();
               var3 = true;
            }

            var4.add(new iIIIiiIiI_Class283.Nested1_58a4d440(var6, var7, var8));
         }

         for (int var9 = var0.size() - 1; var9 >= 0; var9--) {
            ServerInfo var11 = var0.get(var9);
            if (!i_method_7439e3d3(var4, var11) && I_method_2585d3b3(var4, var11)) {
               var0.remove(var11);
               var3 = true;
            }
         }

         for (int var10 = 0; var10 < var4.size(); var10++) {
            ServerInfo var12 = ((iIIIiiIiI_Class283.Nested1_58a4d440)var4.get(var10)).I_method_95791f49();

            for (int var13 = I_method_447f062f(var0, var12); var13 > var10; var3 = true) {
               var0.swapEntries(var13, var13 - 1);
               var13--;
            }
         }

         if (var3) {
            var0.saveFile();
         }

         return var3;
      }
   }

   private static int I_method_447f062f(ServerList var0, ServerInfo var1) {
      for (int var2 = 0; var2 < var0.size(); var2++) {
         if (var0.get(var2) == var1) {
            return var2;
         }
      }

      return -1;
   }

   @Nullable
   private static iIIIiiIiI_Class283.Nested1_58a4d460 I_method_ee3e0802(
      List<iIIIiiIiI_Class283.Nested1_58a4d460> var0, iIIIiiIiI_Class283.Nested1_58a4d460 var1
   ) {
      for (iIIIiiIiI_Class283.Nested1_58a4d460 var3 : var0) {
         if (var3.i_field_523beb0a.equalsIgnoreCase(var1.i_field_523beb0a)) {
            return var3;
         }
      }

      for (iIIIiiIiI_Class283.Nested1_58a4d460 var5 : var0) {
         if (var5.I_field_523beb0a.equalsIgnoreCase(var1.I_field_523beb0a)) {
            return var5;
         }
      }

      return null;
   }

   @Nullable
   private static ServerInfo I_method_ed01fb63(
      ServerList var0,
      List<iIIIiiIiI_Class283.Nested1_58a4d440> var1,
      iIIIiiIiI_Class283.Nested1_58a4d460 var2,
      @Nullable iIIIiiIiI_Class283.Nested1_58a4d460 var3
   ) {
      for (int var4 = 0; var4 < var0.size(); var4++) {
         ServerInfo var5 = var0.get(var4);
         if (!i_method_7439e3d3(var1, var5)) {
            if (var2.I_method_f7b58c9(var5)) {
               return var5;
            }

            if (var3 != null && var3.I_method_f7b58c9(var5)) {
               return var5;
            }
         }
      }

      return null;
   }

   private static boolean I_method_2585d3b3(List<iIIIiiIiI_Class283.Nested1_58a4d440> var0, ServerInfo var1) {
      for (iIIIiiIiI_Class283.Nested1_58a4d440 var3 : var0) {
         if (var3.I_method_603690a9(var1)) {
            return true;
         }
      }

      return false;
   }

   private static boolean i_method_7439e3d3(List<iIIIiiIiI_Class283.Nested1_58a4d440> var0, ServerInfo var1) {
      for (iIIIiiIiI_Class283.Nested1_58a4d440 var3 : var0) {
         if (var3.I_method_95791f49() == var1) {
            return true;
         }
      }

      return false;
   }

   private static Path I_method_9ac6a20f(MinecraftClient var0) {
      return var0.runDirectory.toPath().resolve("rockstar-pinned-multiplayer.txt");
   }

   private static List<iIIIiiIiI_Class283.Nested1_58a4d460> I_method_48ffd4de(String var0) {
      if (var0 != null && !var0.isBlank()) {
         ArrayList var1 = new ArrayList();

         for (String var5 : var0.split("\\R")) {
            String var6 = var5.trim();
            if (!var6.isEmpty()) {
               int var7 = var6.indexOf(36);
               if (var7 > 0 && var7 < var6.length() - 1) {
                  String var8 = var6.substring(0, var7).trim();
                  String var9 = var6.substring(var7 + 1).trim();
                  if (!var8.isEmpty() && !var9.isEmpty()) {
                     var1.add(new iIIIiiIiI_Class283.Nested1_58a4d460(var8, var9));
                  }
               }
            }
         }

         return List.copyOf(var1);
      } else {
         return List.of();
      }
   }

   static final class Nested1_58a4d440 {
      private final iIIIiiIiI_Class283.Nested1_58a4d460 I_field_ffad8e27;
      @Nullable
      private final iIIIiiIiI_Class283.Nested1_58a4d460 i_field_ffad8e27;
      private final ServerInfo I_field_74b63c25;

      Nested1_58a4d440(iIIIiiIiI_Class283.Nested1_58a4d460 var1, @Nullable iIIIiiIiI_Class283.Nested1_58a4d460 var2, ServerInfo var3) {
         this.I_field_ffad8e27 = var1;
         this.i_field_ffad8e27 = var2;
         this.I_field_74b63c25 = var3;
      }

      boolean I_method_603690a9(ServerInfo var1) {
         return this.I_field_ffad8e27.I_method_f7b58c9(var1) ? true : this.i_field_ffad8e27 != null && this.i_field_ffad8e27.I_method_f7b58c9(var1);
      }

      @Override
      public final String toString() {
         return "Nested1_58a4d440[definition=" + this.I_field_ffad8e27 + ", previousDefinition=" + this.i_field_ffad8e27 + ", serverInfo=" + this.I_field_74b63c25 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_ffad8e27);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_ffad8e27);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_74b63c25);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIIIiiIiI_Class283.Nested1_58a4d440 other = (iIIIiiIiI_Class283.Nested1_58a4d440) var1;
         return java.util.Objects.equals(this.I_field_ffad8e27, other.I_field_ffad8e27)
            && java.util.Objects.equals(this.i_field_ffad8e27, other.i_field_ffad8e27)
            && java.util.Objects.equals(this.I_field_74b63c25, other.I_field_74b63c25);
      }

      public iIIIiiIiI_Class283.Nested1_58a4d460 I_method_b471074b() {
         return this.I_field_ffad8e27;
      }

      @Nullable
      public iIIIiiIiI_Class283.Nested1_58a4d460 i_method_ba79032b() {
         return this.i_field_ffad8e27;
      }

      public ServerInfo I_method_95791f49() {
         return this.I_field_74b63c25;
      }
   }

   static final class Nested1_58a4d460 {
      final String I_field_523beb0a;
      final String i_field_523beb0a;

      Nested1_58a4d460(String var1, String var2) {
         this.I_field_523beb0a = var1;
         this.i_field_523beb0a = var2;
      }

      boolean I_method_f7b58c9(@Nullable ServerInfo var1) {
         return var1 != null && this.i_field_523beb0a.equalsIgnoreCase(var1.address);
      }

      private String II_method_b63b1439() {
         return this.I_field_523beb0a + "$" + this.i_field_523beb0a;
      }

      @Override
      public final String toString() {
         return "Nested1_58a4d460[name=" + this.I_field_523beb0a + ", address=" + this.i_field_523beb0a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_523beb0a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIIIiiIiI_Class283.Nested1_58a4d460 other = (iIIIiiIiI_Class283.Nested1_58a4d460) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.i_field_523beb0a, other.i_field_523beb0a);
      }

      public String I_method_a29be886() {
         return this.I_field_523beb0a;
      }

      public String i_method_35ba98a6() {
         return this.i_field_523beb0a;
      }
   }
}
