package rockstar.client;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.util.HexFormat;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import net.minecraft.client.MinecraftClient;

public final class iiiiIIi_Class122 {
   private static final long I_field_4a = 30000L;
   private static final Set<String> I_field_a56a8dc5 = ConcurrentHashMap.newKeySet();
   private static final Map<String, Long> I_field_a567c40b = new ConcurrentHashMap<>();

   private iiiiIIi_Class122() {
   }

   public static boolean I_method_d6d2688d(String var0) {
      if (var0 == null) {
         return false;
      } else {
         String var1 = var0.toLowerCase(Locale.ROOT);
         return var1.startsWith("http://") || var1.startsWith("https://");
      }
   }

   public static Path I_method_6efab1cc(String var0) {
      Path var1 = i_method_30011ec(var0);
      return Files.isRegularFile(var1) ? var1 : null;
   }

   public static void I_method_f5e02f0b(String var0, Consumer<Path> var1) {
      Path var2 = I_method_6efab1cc(var0);
      if (var2 != null) {
         var1.accept(var2);
      } else {
         Long var3 = I_field_a567c40b.get(var0);
         if (var3 == null || System.currentTimeMillis() >= var3) {
            if (I_field_a56a8dc5.add(var0)) {
               Thread var4 = new Thread(
                  () -> {
                     try {
                        byte[] var2x = iIiIiiiiI_Class351.I_method_b8c2db27(var0);
                        Path var3x = i_method_30011ec(var0);
                        Files.createDirectories(var3x.getParent());
                        Path var4x = var3x.resolveSibling(var3x.getFileName() + ".part");
                        Files.write(var4x, var2x);
                        Files.move(var4x, var3x, StandardCopyOption.REPLACE_EXISTING);
                        I_field_a567c40b.remove(var0);
                        MinecraftClient.getInstance().execute(() -> var1.accept(var3x));
                     } catch (Exception var8) {
                        I_field_a567c40b.put(var0, System.currentTimeMillis() + 30000L);
                        RockstarClient.I_field_ab0f6068
                           .warn(
                              "\u0410\u0441\u0441\u0435\u0442\u044b: \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0441\u043a\u0430\u0447\u0430\u0442\u044c {}: {}",
                              var0,
                              var8.getMessage()
                           );
                     } finally {
                        I_field_a56a8dc5.remove(var0);
                     }
                  },
                  "rockstar-web-asset"
               );
               var4.setDaemon(true);
               var4.start();
            }
         }
      }
   }

   public static Path I_method_a3f4fa16() {
      return Path.of(IiIIiIII_Class73.I_field_3a58077.toURI()).resolve("cache").resolve("web");
   }

   private static Path i_method_30011ec(String var0) {
      return I_method_a3f4fa16().resolve(I_method_26968f37(var0) + i_method_46b57757(var0));
   }

   private static String I_method_26968f37(String var0) {
      try {
         MessageDigest var1 = MessageDigest.getInstance("SHA-1");
         return HexFormat.of().formatHex(var1.digest(var0.getBytes(StandardCharsets.UTF_8)));
      } catch (Exception var2) {
         return Integer.toHexString(var0.hashCode());
      }
   }

   private static String i_method_46b57757(String var0) {
      String var1 = var0;
      int var2 = var0.indexOf(63);
      if (var2 >= 0) {
         var1 = var0.substring(0, var2);
      }

      int var3 = var1.lastIndexOf(47);
      int var4 = var1.lastIndexOf(46);
      if (var4 > var3 && var4 != var1.length() - 1) {
         String var5 = var1.substring(var4).toLowerCase(Locale.ROOT);
         return var5.matches("\\.[a-z0-9]{1,8}") ? var5 : "";
      } else {
         return "";
      }
   }
}
