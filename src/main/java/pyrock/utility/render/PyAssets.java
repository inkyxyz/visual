package pyrock.utility.render;

import com.google.gson.Gson;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.imageio.ImageIO;
import jep.python.PyCallable;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.client.texture.NativeImage.Format;
import net.minecraft.util.Identifier;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.IIiiIiIIi_Class106;
import rockstar.client.IIiiii_Class16;
import rockstar.client.IiIIiIII_Class73;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIiiII_Class269;
import rockstar.client.iiiiIIi_Class122;

public class PyAssets {
   private static final Gson GSON = new Gson();
   private static final Map<String, PyAssets.Nested1_5aeaf15a> TEXTURES = new ConcurrentHashMap<>();
   private static final Map<String, IIiiii_Class16> FONTS = new ConcurrentHashMap<>();
   private static final Map<String, Identifier> WEB_TEXTURES = new ConcurrentHashMap<>();

   public Identifier resource(String var1) {
      return RockstarClient.id(normalizeIdentifierPath(var1));
   }

   public Identifier image(String var1) {
      return this.image(null, var1);
   }

   public Identifier texture(String var1) {
      return this.image(var1);
   }

   public PyDynamicTexture dynamicTexture(String var1, int var2, int var3) {
      return new PyDynamicTexture(var1, var2, var3);
   }

   public PyPcmStream pcmStream(float var1, int var2) {
      return new PyPcmStream(var1, var2);
   }

   public Identifier image(String var1, String var2) {
      if (iiiiIIi_Class122.I_method_d6d2688d(var2)) {
         return this.webImage(var1, var2);
      } else {
         Path var3 = resolve(var2);
         if (!Files.isRegularFile(var3)) {
            throw new IllegalArgumentException("image file not found: " + var3);
         } else {
            try {
               Path var4 = var3.toAbsolutePath().normalize();
               long var5 = Files.getLastModifiedTime(var4).toMillis();
               String var7 = var4.toString();
               PyAssets.Nested1_5aeaf15a var8 = TEXTURES.get(var7);
               if (var8 != null && var8.modified == var5) {
                  return var8.id;
               } else {
                  BufferedImage var9 = ImageIO.read(var4.toFile());
                  if (var9 == null) {
                     throw new IllegalArgumentException("unsupported image file: " + var4);
                  } else {
                     NativeImage var10 = iIIIIiiII_Class269.I_method_97bf3255(var9, false);
                     Identifier var11 = RockstarClient.id("scripts/images/" + textureName(var1, var4));
                     MinecraftClient var12 = MinecraftClient.getInstance();
                     if (var8 != null && !var8.id.equals(var11)) {
                        var12.getTextureManager().destroyTexture(var8.id);
                     }

                     var12.getTextureManager().registerTexture(var11, new NativeImageBackedTexture(var10));
                     TEXTURES.put(var7, new PyAssets.Nested1_5aeaf15a(var11, var5));
                     return var11;
                  }
               }
            } catch (IOException var13) {
               throw new RuntimeException("failed to load image: " + var3, var13);
            }
         }
      }
   }

   private Identifier webImage(String var1, String var2) {
      Identifier var3 = WEB_TEXTURES.get(var2);
      if (var3 != null) {
         return var3;
      } else {
         Identifier var4 = RockstarClient.id(
            "scripts/web/" + sanitize(var1 != null && !var1.isBlank() ? var1 : "image") + "_" + Integer.toHexString(var2.hashCode()) + ".png"
         );
         Identifier var5 = WEB_TEXTURES.putIfAbsent(var2, var4);
         if (var5 != null) {
            return var5;
         } else {
            MinecraftClient var6 = MinecraftClient.getInstance();
            var6.getTextureManager().registerTexture(var4, new NativeImageBackedTexture(new NativeImage(Format.RGBA, 1, 1, false)));
            iiiiIIi_Class122.I_method_f5e02f0b(
               var2,
               var3x -> {
                  try {
                     BufferedImage var4x = ImageIO.read(var3x.toFile());
                     if (var4x == null) {
                        throw new IllegalArgumentException("\u044d\u0442\u043e \u043d\u0435 \u043a\u0430\u0440\u0442\u0438\u043d\u043a\u0430");
                     }

                     var6.getTextureManager().registerTexture(var4, new NativeImageBackedTexture(iIIIIiiII_Class269.I_method_97bf3255(var4x, false)));
                  } catch (Exception var5x) {
                     RockstarClient.I_field_ab0f6068
                        .warn(
                           "\u0410\u0441\u0441\u0435\u0442\u044b: \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u043f\u0440\u043e\u0447\u0438\u0442\u0430\u0442\u044c \u043a\u0430\u0440\u0442\u0438\u043d\u043a\u0443 {}: {}",
                           var2,
                           var5x.getMessage()
                        );
                  }
               }
            );
            return var4;
         }
      }
   }

   public String download(String var1, PyCallable var2) {
      if (!iiiiIIi_Class122.I_method_d6d2688d(var1)) {
         Path var5 = resolve(var1);
         if (!Files.isRegularFile(var5)) {
            throw new IllegalArgumentException("file not found: " + var5);
         } else {
            String var6 = var5.toString();
            deliver(var2, var6);
            return var6;
         }
      } else {
         Path var3 = iiiiIIi_Class122.I_method_6efab1cc(var1);
         if (var3 != null) {
            String var4 = var3.toString();
            deliver(var2, var4);
            return var4;
         } else {
            iiiiIIi_Class122.I_method_f5e02f0b(var1, var1x -> deliver(var2, var1x.toString()));
            return null;
         }
      }
   }

   private static void deliver(PyCallable var0, String var1) {
      if (var0 != null) {
         IIiiIIiii_Class104 var2 = IIiiIIiii_Class104.I_method_204b62f5();
         MinecraftClient.getInstance().execute(() -> {
            if (var2 == null || var2.II_method_b18bf526()) {
               if (IIiiIiIIi_Class106.Ii_method_b61528e6()) {
                  try (AutoCloseable var3 = IIiiIIiii_Class104.I_method_5edeb6c9(var2)) {
                     var0.call(new Object[]{var1});
                  } catch (Exception var8) {
                     RockstarClient.I_field_ab0f6068.error("Python error in download callback:", var8);
                  }
               }
            }
         });
      }
   }

   public IIiIIi_Class10 font(String var1, float var2) {
      return slugFont(var1).I_method_3a2d5e3(var2);
   }

   public static IIiiii_Class16 slugFont(String var0) {
      IIiiii_Class16 var1 = FONTS.get(fontName(var0));
      return var1 != null ? var1 : IIiIiI_Class11.I_method_1fee2501(var0);
   }

   public IIiiii_Class16 ttfFamily(String var1, String var2) {
      String var3 = fontName(var1);
      IIiiii_Class16 var4 = FONTS.get(var3);
      if (var4 != null) {
         return var4;
      } else if (iiiiIIi_Class122.I_method_d6d2688d(var2)) {
         return this.webFont(var3, var2);
      } else {
         Path var5 = resolve(var2);
         if (!Files.isRegularFile(var5)) {
            throw new IllegalArgumentException("font file not found: " + var5);
         } else {
            try {
               Font var6 = Font.createFont(0, var5.toFile());
               IIiiii_Class16 var7 = IIiiii_Class16.I_method_9e671ab9(var3, var6);
               FONTS.put(var3, var7);
               return var7;
            } catch (Exception var8) {
               throw new RuntimeException("failed to load font: " + var1, var8);
            }
         }
      }
   }

   private IIiiii_Class16 webFont(String var1, String var2) {
      Path var3 = iiiiIIi_Class122.I_method_6efab1cc(var2);
      if (var3 != null) {
         IIiiii_Class16 var4 = this.readFont(var1, var3);
         if (var4 != null) {
            FONTS.put(var1, var4);
            return var4;
         }
      }

      IIiiii_Class16 var5 = IIiiii_Class16.i_method_147e7d61(var1);
      FONTS.put(var1, var5);
      iiiiIIi_Class122.I_method_f5e02f0b(
         var2,
         var2x -> {
            try {
               var5.I_method_20decac8(Font.createFont(0, var2x.toFile()));
            } catch (Exception var4x) {
               RockstarClient.I_field_ab0f6068
                  .warn(
                     "\u0410\u0441\u0441\u0435\u0442\u044b: \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u043f\u0440\u043e\u0447\u0438\u0442\u0430\u0442\u044c \u0448\u0440\u0438\u0444\u0442 {}: {}",
                     var2,
                     var4x.getMessage()
                  );
            }
         }
      );
      return var5;
   }

   private IIiiii_Class16 readFont(String var1, Path var2) {
      try {
         return IIiiii_Class16.I_method_9e671ab9(var1, Font.createFont(0, var2.toFile()));
      } catch (Exception var4) {
         RockstarClient.I_field_ab0f6068
            .warn(
               "\u0410\u0441\u0441\u0435\u0442\u044b: \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u043f\u0440\u043e\u0447\u0438\u0442\u0430\u0442\u044c \u0448\u0440\u0438\u0444\u0442 {}: {}",
               var2,
               var4.getMessage()
            );
         return null;
      }
   }

   public String scriptsDir() {
      return scriptsRoot().toString();
   }

   public String assetsDir() {
      return scriptsRoot().toString();
   }

   public static Path resolve(String var0) {
      Path var1 = Path.of(var0);
      if (var1.isAbsolute()) {
         return var1.normalize();
      } else {
         Path var2 = scriptsRoot().resolve(var1).normalize();
         return Files.exists(var2) ? var2 : Path.of(IiIIiIII_Class73.I_field_3a58077.toURI()).resolve(var1).normalize();
      }
   }

   private static Path scriptsRoot() {
      return Path.of(IiIIiIII_Class73.I_field_3a58077.toURI()).resolve("scripts");
   }

   private static String fontName(String var0) {
      return sanitize(var0 != null && !var0.isBlank() ? var0 : "custom");
   }

   private static String textureName(String var0, Path var1) {
      String var2 = var0 != null && !var0.isBlank() ? var0 : stripExtension(var1.getFileName().toString());
      String var3 = extension(var1.getFileName().toString());
      String var4 = Integer.toHexString(var1.toString().hashCode());
      return sanitize(var2) + "_" + var4 + (var3.isBlank() ? ".png" : var3);
   }

   private static String stripExtension(String var0) {
      int var1 = var0.lastIndexOf(46);
      return var1 <= 0 ? var0 : var0.substring(0, var1);
   }

   private static String extension(String var0) {
      int var1 = var0.lastIndexOf(46);
      return var1 <= 0 ? "" : var0.substring(var1).toLowerCase(Locale.ROOT);
   }

   private static String normalizeIdentifierPath(String var0) {
      return var0.replace('\\', '/').replaceAll("^/+", "");
   }

   private static String sanitize(String var0) {
      String var1 = var0.toLowerCase(Locale.ROOT).replace('\\', '/').replaceAll("[^a-z0-9/._-]", "_").replaceAll("_+", "_").replaceAll("^_+|_+$", "");
      return var1.isBlank() ? "asset" : var1;
   }

   static final class Nested1_5aeaf15a {
      final Identifier id;
      final long modified;

      Nested1_5aeaf15a(Identifier var1, long var2) {
         this.id = var1;
         this.modified = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_5aeaf15a[id=" + this.id() + ", modified=" + this.modified() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.id());
         result = 31 * result + java.util.Objects.hashCode(this.modified());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         PyAssets.Nested1_5aeaf15a other = (PyAssets.Nested1_5aeaf15a) var1;
         return java.util.Objects.equals(this.id(), other.id())
            && java.util.Objects.equals(this.modified(), other.modified());
      }

      public Identifier id() {
         return this.id;
      }

      public long modified() {
         return this.modified;
      }
   }
}
