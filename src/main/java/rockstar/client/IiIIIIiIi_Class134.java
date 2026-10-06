package rockstar.client;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.block.entity.SkullBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.client.util.SkinTextures;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;

public final class IiIIIIiIi_Class134 {
   private static final Map<String, Identifier> I_field_a567c40b = new ConcurrentHashMap<>();
   private static final AtomicInteger I_field_bc9b37c0 = new AtomicInteger();
   private static final Executor I_field_54ff24dc = var0 -> {
      Thread var1 = new Thread(var0, "rockstar-skin");
      var1.setDaemon(true);
      var1.start();
   };

   private IiIIIIiIi_Class134() {
   }

   public static CompletableFuture<SkinTextures> I_method_de1d7e2b(String var0) {
      return SkullBlockEntity.fetchProfileByName(var0)
         .thenCompose(
            var0x -> var0x.<CompletionStage<SkinTextures>>map(
                  var0xx -> MinecraftClient.getInstance().getSkinProvider().fetchSkinTextures(var0xx).thenApply(var0xxx -> (SkinTextures)var0xxx.orElse(null))
               )
               .orElseGet(() -> CompletableFuture.completedFuture(null))
         );
   }

   public static CompletableFuture<Identifier> i_method_2cd18e4b(String var0) {
      return I_method_b7ed3ba6(var0, "skin", IiIIIIiIi_Class134::I_method_173ff377);
   }

   public static CompletableFuture<Identifier> II_method_99e2bc88(String var0) {
      return I_method_b7ed3ba6(var0, "cape", IiIIIIiIi_Class134::i_method_e8221b97);
   }

   public static CompletableFuture<Identifier> Ii_method_e896cca8(String var0) {
      return I_method_b7ed3ba6("http://s.optifine.net/capes/" + var0 + ".png", "cape", IiIIIIiIi_Class134::i_method_e8221b97);
   }

   private static CompletableFuture<Identifier> I_method_b7ed3ba6(String var0, String var1, IiIIIIiIi_Class134.Nested1_738f0060 var2) {
      if (var0 != null && !var0.isBlank()) {
         String var3 = var1 + ":" + var0;
         Identifier var4 = I_field_a567c40b.get(var3);
         return var4 != null
            ? CompletableFuture.completedFuture(var4)
            : CompletableFuture.<NativeImage>supplyAsync(() -> var2.apply(I_method_5ea1b1fc(var0)), I_field_54ff24dc)
               .thenCompose(var1x -> I_method_1899d0dc(var1x, var1))
               .thenApply(var1x -> {
                  I_field_a567c40b.put(var3, var1x);
                  return (Identifier)var1x;
               });
      } else {
         return CompletableFuture.completedFuture(null);
      }
   }

   private static NativeImage I_method_5ea1b1fc(String var0) {
      try {
         String var1 = var0.toLowerCase(Locale.ROOT);
         if (!var1.startsWith("http://") && !var1.startsWith("https://")) {
            Path var2 = Path.of(var0).toAbsolutePath().normalize();
            if (!Files.isRegularFile(var2)) {
               throw new IllegalArgumentException("\u0444\u0430\u0439\u043b\u0430 \u043d\u0435\u0442: " + var2);
            } else {
               return NativeImage.read(Files.readAllBytes(var2));
            }
         } else {
            return NativeImage.read(iIiIiiiiI_Class351.I_method_b8c2db27(var0));
         }
      } catch (Exception var3) {
         throw new RuntimeException(
            "\u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0437\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044c " + var0 + ": " + var3.getMessage(),
            var3
         );
      }
   }

   private static CompletableFuture<Identifier> I_method_1899d0dc(NativeImage var0, String var1) {
      CompletableFuture var2 = new CompletableFuture();
      Identifier var3 = RockstarClient.id("skins/" + var1 + "/" + I_field_bc9b37c0.incrementAndGet());
      MinecraftClient.getInstance().execute(() -> {
         try {
            MinecraftClient.getInstance().getTextureManager().registerTexture(var3, new NativeImageBackedTexture(var0));
            var2.complete(var3);
         } catch (Throwable var4) {
            var0.close();
            var2.completeExceptionally(var4);
         }
      });
      return var2;
   }

   private static NativeImage I_method_173ff377(NativeImage var0) {
      if (var0.getWidth() == var0.getHeight() && var0.getWidth() != 64) {
         return var0;
      } else if (var0.getWidth() == 64 && (var0.getHeight() == 32 || var0.getHeight() == 64)) {
         boolean var1 = var0.getHeight() == 32;
         NativeImage var2 = var0;
         if (var1) {
            var2 = new NativeImage(64, 64, true);
            var2.copyFrom(var0);
            var0.close();
            var2.fillRect(0, 32, 64, 32, 0);
            var2.copyRect(4, 16, 16, 32, 4, 4, true, false);
            var2.copyRect(8, 16, 16, 32, 4, 4, true, false);
            var2.copyRect(0, 20, 24, 32, 4, 12, true, false);
            var2.copyRect(4, 20, 16, 32, 4, 12, true, false);
            var2.copyRect(8, 20, 8, 32, 4, 12, true, false);
            var2.copyRect(12, 20, 16, 32, 4, 12, true, false);
            var2.copyRect(44, 16, -8, 32, 4, 4, true, false);
            var2.copyRect(48, 16, -8, 32, 4, 4, true, false);
            var2.copyRect(40, 20, 0, 32, 4, 12, true, false);
            var2.copyRect(44, 20, -8, 32, 4, 12, true, false);
            var2.copyRect(48, 20, -16, 32, 4, 12, true, false);
            var2.copyRect(52, 20, -8, 32, 4, 12, true, false);
         }

         I_method_382ce80e(var2, 0, 0, 32, 16);
         if (var1) {
            i_method_6d61abee(var2, 32, 0, 64, 32);
         }

         I_method_382ce80e(var2, 0, 16, 64, 32);
         I_method_382ce80e(var2, 16, 48, 48, 64);
         return var2;
      } else {
         throw new IllegalArgumentException(
            "\u0441\u043a\u0438\u043d \u0434\u043e\u043b\u0436\u0435\u043d \u0431\u044b\u0442\u044c 64x64 \u0438\u043b\u0438 64x32, \u0430 \u043d\u0435 "
               + var0.getWidth()
               + "x"
               + var0.getHeight()
         );
      }
   }

   private static NativeImage i_method_e8221b97(NativeImage var0) {
      if (var0.getWidth() == var0.getHeight() * 2) {
         return var0;
      } else {
         int var1 = Math.max(64, I_method_2a7b8cb7(var0.getWidth()));
         int var2 = var1 / 2;
         NativeImage var3 = new NativeImage(var1, var2, true);
         var3.fillRect(0, 0, var1, var2, 0);
         var3.copyFrom(var0);
         var0.close();
         return var3;
      }
   }

   private static void I_method_382ce80e(NativeImage var0, int var1, int var2, int var3, int var4) {
      for (int var5 = var1; var5 < var3; var5++) {
         for (int var6 = var2; var6 < var4; var6++) {
            var0.setColorArgb(var5, var6, var0.getColorArgb(var5, var6) | 0xFF000000);
         }
      }
   }

   private static void i_method_6d61abee(NativeImage var0, int var1, int var2, int var3, int var4) {
      for (int var5 = var1; var5 < var3; var5++) {
         for (int var6 = var2; var6 < var4; var6++) {
            if (ColorHelper.getAlpha(var0.getColorArgb(var5, var6)) < 128) {
               return;
            }
         }
      }

      for (int var7 = var1; var7 < var3; var7++) {
         for (int var8 = var2; var8 < var4; var8++) {
            var0.setColorArgb(var7, var8, var0.getColorArgb(var7, var8) & 16777215);
         }
      }
   }

   private static int I_method_2a7b8cb7(int var0) {
      byte var1 = 1;

      while (var1 < var0) {
         var1 <<= 1;
      }

      return var1;
   }

   interface Nested1_738f0060 {
      NativeImage apply(NativeImage var1);
   }
}
