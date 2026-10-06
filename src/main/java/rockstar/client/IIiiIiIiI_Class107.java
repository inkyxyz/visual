package rockstar.client;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.time.Duration;
import java.util.Comparator;
import java.util.Locale;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.minecraft.text.Text;

public final class IIiiIiIiI_Class107 {
   private static final String I_field_523beb0a = ".rockstar-runtime";
   private static final Duration I_field_af06f406 = Duration.ofSeconds(15L);
   private static final Duration i_field_af06f406 = Duration.ofSeconds(20L);
   private static final Duration II_field_af06f406 = Duration.ofMinutes(10L);
   private static volatile boolean I_field_5a;

   private IIiiIiIiI_Class107() {
   }

   public static void I_method_46031e89(String var0) {
      if (var0 == null || var0.isBlank()) {
         iiiIiIii_Class236.I_method_f4c1750c();
      } else if (!I_field_5a) {
         I_field_5a = true;
         Thread var1 = new Thread(
            () -> {
               try {
                  i_method_16ba7269(var0);
               } catch (Throwable var5) {
                  RockstarClient.I_field_ab0f6068
                     .error(
                        "[Runtime] \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0430 \u043f\u0438\u0442\u043e\u043d-\u0440\u0430\u043d\u0442\u0430\u0439\u043c\u0430 \u0441\u043e\u0440\u0432\u0430\u043b\u0430\u0441\u044c",
                        var5
                     );
               } finally {
                  I_field_5a = false;
                  iiiIiIii_Class236.I_method_f4c1750c();
               }
            },
            "Python-Runtime-Installer"
         );
         var1.setDaemon(true);
         var1.start();
      }
   }

   private static void i_method_16ba7269(String var0) throws Exception {
      I_method_9ef9129e(IIiiIiIIi_Class106.I_method_1233012e().toPath().resolveSibling("python.old"));
      HttpClient var1 = HttpClient.newBuilder().connectTimeout(I_field_af06f406).followRedirects(Redirect.NORMAL).build();
      JsonObject var2 = I_method_3e4bc0e5(var1, var0);
      if (var2 != null) {
         String var3 = var2.get("sha256").getAsString().toLowerCase(Locale.ROOT);
         long var4 = var2.has("size") ? var2.get("size").getAsLong() : -1L;
         if (IIiiIiIIi_Class106.I_method_fd9ca243() && var3.equals(I_method_a21aec01())) {
            RockstarClient.I_field_ab0f6068
               .info(
                  "[Runtime] \u043f\u0438\u0442\u043e\u043d-\u0440\u0430\u043d\u0442\u0430\u0439\u043c \u043d\u0430 \u043c\u0435\u0441\u0442\u0435 \u0438 \u0430\u043a\u0442\u0443\u0430\u043b\u0435\u043d"
               );
         } else {
            boolean var6 = IIiiIiIIi_Class106.I_method_fd9ca243();
            RockstarClient.I_field_ab0f6068
               .info(
                  "[Runtime] {} \u043f\u0438\u0442\u043e\u043d-\u0440\u0430\u043d\u0442\u0430\u0439\u043c ({} \u041c\u0411)...",
                  var6 ? "\u043e\u0431\u043d\u043e\u0432\u043b\u044f\u044e" : "\u043a\u0430\u0447\u0430\u044e",
                  Math.max(var4, 0L) / 1048576L
               );
            II_method_d1b40e0c(
               var6
                  ? "\u041e\u0431\u043d\u043e\u0432\u043b\u044f\u044e Python-\u0440\u0430\u043d\u0442\u0430\u0439\u043c \u0434\u043b\u044f \u0441\u043a\u0440\u0438\u043f\u0442\u043e\u0432, \u044d\u0442\u043e \u0437\u0430\u0439\u043c\u0451\u0442 \u043c\u0438\u043d\u0443\u0442\u0443..."
                  : "\u041a\u0430\u0447\u0430\u044e Python-\u0440\u0430\u043d\u0442\u0430\u0439\u043c \u0434\u043b\u044f \u0441\u043a\u0440\u0438\u043f\u0442\u043e\u0432 (~"
                     + Math.max(var4, 0L) / 1048576L
                     + " \u041c\u0411), \u044d\u0442\u043e \u0440\u0430\u0437\u043e\u0432\u0430\u044f \u043e\u043f\u0435\u0440\u0430\u0446\u0438\u044f..."
            );
            Path var7 = IIiiIiIIi_Class106.I_method_1233012e().toPath();
            Path var8 = var7.resolveSibling("python.download");
            Path var9 = var7.resolveSibling("python-runtime.zip.part");
            I_method_9ef9129e(var8);
            Files.createDirectories(var8);
            Files.createDirectories(var9.getParent());

            try {
               String var10 = I_method_9cfa24b8(var1, var0 + "/runtime/download?os=" + i_method_35399c21(), var9, var4);
               if (!var3.equals(var10)) {
                  RockstarClient.I_field_ab0f6068
                     .error(
                        "[Runtime] \u0430\u0440\u0445\u0438\u0432 \u043f\u043e\u0431\u0438\u043b\u0441\u044f: \u043e\u0436\u0438\u0434\u0430\u043b\u0438 sha256={}, \u043f\u043e\u043b\u0443\u0447\u0438\u043b\u0438 {}",
                        var3,
                        var10
                     );
                  II_method_d1b40e0c(
                     "\u041d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0441\u043a\u0430\u0447\u0430\u0442\u044c Python-\u0440\u0430\u043d\u0442\u0430\u0439\u043c: \u0430\u0440\u0445\u0438\u0432 \u043f\u043e\u0431\u0438\u043b\u0441\u044f. \u0421\u043a\u0440\u0438\u043f\u0442\u044b \u043f\u043e\u043a\u0430 \u043d\u0435\u0434\u043e\u0441\u0442\u0443\u043f\u043d\u044b."
                  );
                  return;
               }

               I_method_a388e93d(var9, var8);
               if (I_method_f1b65d97(var8) == null) {
                  RockstarClient.I_field_ab0f6068
                     .error(
                        "[Runtime] \u0432 \u0430\u0440\u0445\u0438\u0432\u0435 \u043d\u0435\u0442 jep \u2014 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0430 \u043e\u0442\u043c\u0435\u043d\u0435\u043d\u0430"
                     );
                  II_method_d1b40e0c(
                     "\u041d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u043f\u043e\u0441\u0442\u0430\u0432\u0438\u0442\u044c Python-\u0440\u0430\u043d\u0442\u0430\u0439\u043c: \u0430\u0440\u0445\u0438\u0432 \u043d\u0435\u043f\u043e\u043b\u043d\u044b\u0439. \u0421\u043a\u0440\u0438\u043f\u0442\u044b \u043f\u043e\u043a\u0430 \u043d\u0435\u0434\u043e\u0441\u0442\u0443\u043f\u043d\u044b."
                  );
                  return;
               }

               i_method_116151d(var8, var7);
               Files.writeString(var7.resolve(".rockstar-runtime"), var3, StandardCharsets.UTF_8);
               RockstarClient.I_field_ab0f6068
                  .info(
                     "[Runtime] \u043f\u0438\u0442\u043e\u043d-\u0440\u0430\u043d\u0442\u0430\u0439\u043c \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d: {}",
                     var7
                  );
               if (IIiiIiIIi_Class106.II_method_b6069d06()) {
                  RockstarClient.I_field_ab0f6068
                     .warn(
                        "[Runtime] \u043d\u0430\u0442\u0438\u0432\u043a\u0438 \u0441\u0442\u0430\u0440\u043e\u0433\u043e \u0440\u0430\u043d\u0442\u0430\u0439\u043c\u0430 \u0443\u0436\u0435 \u0432 \u043f\u0440\u043e\u0446\u0435\u0441\u0441\u0435 \u2014 \u043f\u0438\u0442\u043e\u043d \u043f\u043e\u0434\u043d\u0438\u043c\u0435\u0442\u0441\u044f \u0442\u043e\u043b\u044c\u043a\u043e \u043f\u043e\u0441\u043b\u0435 \u043f\u0435\u0440\u0435\u0437\u0430\u043f\u0443\u0441\u043a\u0430"
                     );
                  II_method_d1b40e0c(
                     "Python-\u0440\u0430\u043d\u0442\u0430\u0439\u043c \u043e\u0431\u043d\u043e\u0432\u043b\u0451\u043d. \u041f\u0435\u0440\u0435\u0437\u0430\u0439\u0434\u0438\u0442\u0435 \u0432 \u0438\u0433\u0440\u0443, \u0447\u0442\u043e\u0431\u044b \u0441\u043a\u0440\u0438\u043f\u0442\u044b \u0437\u0430\u0440\u0430\u0431\u043e\u0442\u0430\u043b\u0438."
                  );
               } else {
                  II_method_d1b40e0c(
                     "Python-\u0440\u0430\u043d\u0442\u0430\u0439\u043c \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d \u2014 \u0441\u043a\u0440\u0438\u043f\u0442\u044b \u0433\u043e\u0442\u043e\u0432\u044b \u043a \u0440\u0430\u0431\u043e\u0442\u0435."
                  );
                  iIIiIIiIi_Class294.I_field_3a9bda27.execute(IIiiIiIiI_Class107::I_method_63c8f67f);
               }
            } finally {
               Files.deleteIfExists(var9);
               I_method_9ef9129e(var8);
            }
         }
      }
   }

   private static void I_method_63c8f67f() {
      try {
         if (RockstarClient.getInstance().I_method_a90eb842() != null) {
            RockstarClient.getInstance().I_method_a90eb842().II_method_14c48d02();
         }
      } catch (Exception var1) {
         RockstarClient.I_field_ab0f6068
            .error(
               "[Runtime] \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u043f\u0435\u0440\u0435\u0437\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044c \u0441\u043a\u0440\u0438\u043f\u0442\u044b \u043f\u043e\u0441\u043b\u0435 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0438 \u0440\u0430\u043d\u0442\u0430\u0439\u043c\u0430",
               var1
            );
      }
   }

   private static JsonObject I_method_3e4bc0e5(HttpClient var0, String var1) {
      String var2 = var1 + "/runtime/manifest?os=" + i_method_35399c21();

      try {
         HttpRequest var3 = HttpRequest.newBuilder(URI.create(var2)).timeout(i_field_af06f406).GET().build();
         HttpResponse var4 = var0.send(var3, BodyHandlers.ofString());
         if (var4.statusCode() != 200) {
            RockstarClient.I_field_ab0f6068
               .warn(
                  "[Runtime] \u043c\u0430\u043d\u0438\u0444\u0435\u0441\u0442 \u043d\u0435\u0434\u043e\u0441\u0442\u0443\u043f\u0435\u043d (HTTP {}) \u2014 \u0441\u043a\u0440\u0438\u043f\u0442\u044b \u043e\u0441\u0442\u0430\u043d\u0443\u0442\u0441\u044f \u0432\u044b\u043a\u043b\u044e\u0447\u0435\u043d\u043d\u044b\u043c\u0438",
                  var4.statusCode()
               );
            return null;
         } else {
            JsonObject var5 = JsonParser.parseString((String)var4.body()).getAsJsonObject();
            if (!var5.has("sha256")) {
               RockstarClient.I_field_ab0f6068
                  .warn(
                     "[Runtime] \u0432 \u043c\u0430\u043d\u0438\u0444\u0435\u0441\u0442\u0435 \u043d\u0435\u0442 sha256 \u2014 \u043f\u0440\u043e\u043f\u0443\u0441\u043a\u0430\u0435\u043c \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0443"
                  );
               return null;
            } else {
               return var5;
            }
         }
      } catch (Exception var6) {
         RockstarClient.I_field_ab0f6068
            .warn(
               "[Runtime] \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u043f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u043c\u0430\u043d\u0438\u0444\u0435\u0441\u0442 ({}): {}",
               var2,
               var6.getMessage()
            );
         return null;
      }
   }

   private static String I_method_9cfa24b8(HttpClient var0, String var1, Path var2, long var3) throws Exception {
      HttpRequest var5 = HttpRequest.newBuilder(URI.create(var1)).timeout(II_field_af06f406).GET().build();
      HttpResponse var6 = var0.send(var5, BodyHandlers.ofInputStream());
      if (var6.statusCode() != 200) {
         throw new IOException("\u0441\u0435\u0440\u0432\u0435\u0440 \u043e\u0442\u0432\u0435\u0442\u0438\u043b HTTP " + var6.statusCode());
      } else {
         MessageDigest var7 = MessageDigest.getInstance("SHA-256");
         byte[] var8 = new byte[65536];
         long var9 = 0L;
         int var11 = 0;

         int var14;
         try (
            InputStream var12 = (InputStream)var6.body();
            OutputStream var13 = Files.newOutputStream(var2);
         ) {
            while ((var14 = var12.read(var8)) != -1) {
               var13.write(var8, 0, var14);
               var7.update(var8, 0, var14);
               var9 += var14;
               if (var3 > 0L) {
                  int var15 = (int)(var9 * 100L / var3);
                  if (var15 >= var11 + 25 && var15 < 100) {
                     var11 = var15;
                     RockstarClient.I_field_ab0f6068.info("[Runtime] \u0437\u0430\u0433\u0440\u0443\u0437\u043a\u0430: {}%", var15);
                  }
               }
            }
         }

         return I_method_444169da(var7.digest());
      }
   }

   private static void I_method_a388e93d(Path var0, Path var1) throws IOException {
      String var2 = I_method_ef50b1c2(var0);

      ZipEntry var4;
      try (ZipInputStream var3 = new ZipInputStream(Files.newInputStream(var0))) {
         while ((var4 = var3.getNextEntry()) != null) {
            String var5 = var4.getName().replace('\\', '/');
            if (var5.startsWith(var2)) {
               String var6 = var5.substring(var2.length());
               if (!var6.isEmpty()) {
                  Path var7 = var1.resolve(var6).normalize();
                  if (!var7.startsWith(var1)) {
                     throw new IOException(
                        "\u0430\u0440\u0445\u0438\u0432 \u043f\u044b\u0442\u0430\u0435\u0442\u0441\u044f \u043f\u0438\u0441\u0430\u0442\u044c \u0437\u0430 \u043f\u0440\u0435\u0434\u0435\u043b\u044b \u043f\u0430\u043f\u043a\u0438: "
                           + var5
                     );
                  }

                  if (var4.isDirectory()) {
                     Files.createDirectories(var7);
                  } else {
                     Files.createDirectories(var7.getParent());
                     Files.copy(var3, var7, StandardCopyOption.REPLACE_EXISTING);
                  }
               }
            }
         }
      }
   }

   private static String I_method_ef50b1c2(Path var0) throws IOException {
      ZipEntry var2;
      try (ZipInputStream var1 = new ZipInputStream(Files.newInputStream(var0))) {
         while ((var2 = var1.getNextEntry()) != null) {
            String[] var3 = var2.getName().replace('\\', '/').split("/");

            for (int var4 = 0; var4 < var3.length; var4++) {
               if (var3[var4].equals("python")) {
                  StringBuilder var5 = new StringBuilder();

                  for (int var6 = 0; var6 <= var4; var6++) {
                     var5.append(var3[var6]).append('/');
                  }

                  return var5.toString();
               }
            }
         }
      }

      return "";
   }

   private static void i_method_116151d(Path var0, Path var1) throws IOException {
      Path var2 = var1.resolveSibling("python.old");
      I_method_9ef9129e(var2);
      if (Files.exists(var1)) {
         Files.move(var1, var2, StandardCopyOption.REPLACE_EXISTING);
      }

      try {
         Files.createDirectories(var1.getParent());
         Files.move(var0, var1, StandardCopyOption.REPLACE_EXISTING);
      } catch (IOException var4) {
         if (Files.exists(var2)) {
            Files.move(var2, var1, StandardCopyOption.REPLACE_EXISTING);
         }

         throw var4;
      }

      I_method_9ef9129e(var2);
   }

   private static String I_method_a21aec01() {
      Path var0 = IIiiIiIIi_Class106.I_method_1233012e().toPath().resolve(".rockstar-runtime");

      try {
         return Files.exists(var0) ? Files.readString(var0, StandardCharsets.UTF_8).trim().toLowerCase(Locale.ROOT) : "";
      } catch (IOException var2) {
         return "";
      }
   }

   private static Path I_method_f1b65d97(Path var0) {
      String var1 = System.getProperty("os.name", "").toLowerCase(Locale.ROOT);
      String var2 = var1.contains("win") ? "jep.dll" : (var1.contains("mac") ? "libjep.jnilib" : "libjep.so");
      Path var3 = var0.resolve(var2);
      if (Files.exists(var3)) {
         return var3;
      } else {
         Path var4 = var0.resolve("Lib/site-packages/jep/" + var2);
         return Files.exists(var4) ? var4 : null;
      }
   }

   private static String i_method_35399c21() {
      String var0 = System.getProperty("os.name", "").toLowerCase(Locale.ROOT);
      if (var0.contains("mac")) {
         return "macos";
      } else {
         return !var0.contains("nux") && !var0.contains("nix") ? "windows" : "linux";
      }
   }

   private static void I_method_9ef9129e(Path var0) throws IOException {
      if (Files.exists(var0)) {
         try (Stream<Path> var1 = Files.walk(var0)) {
            var1.sorted(Comparator.reverseOrder()).forEach(var0x -> {
               try {
                  Files.deleteIfExists(var0x);
               } catch (IOException var2) {
               }
            });
         }
      }
   }

   private static String I_method_444169da(byte[] var0) {
      StringBuilder var1 = new StringBuilder(var0.length * 2);

      for (byte var5 : var0) {
         var1.append(Character.forDigit(var5 >> 4 & 15, 16));
         var1.append(Character.forDigit(var5 & 15, 16));
      }

      return var1.toString();
   }

   private static void II_method_d1b40e0c(String var0) {
      iIIiIIiIi_Class294.I_field_3a9bda27.execute(() -> iIIIIIIii_Class260.I_method_468cf607(Text.of(var0)));
   }
}
