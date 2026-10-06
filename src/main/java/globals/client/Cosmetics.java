package globals.client;

import globals.client.api.RockNetClient;
import globals.shared.proto.Packets;
import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.imageio.ImageIO;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.util.Identifier;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIiiII_Class269;
import rockstar.client.iIIiIIiIi_Class294;

public final class Cosmetics {
   public static final String NICK_PLAIN = "plain";
   private static final Map<String, Packets.Nested1_d6cfc997> nickStyles = new ConcurrentHashMap<>();
   private static final Map<String, Identifier> badges = new ConcurrentHashMap<>();
   private static final Map<String, Boolean> badgeLoading = new ConcurrentHashMap<>();
   private static final Map<String, Long> badgeRetryAt = new ConcurrentHashMap<>();
   private static final long RETRY_MS = 30000L;
   private static volatile String selfBadge = "";
   private static volatile String selfNick = "plain";

   private Cosmetics() {
   }

   public static void applySelf(String var0, String var1) {
      selfBadge = var0 == null ? "" : var0;
      selfNick = var1 != null && !var1.isEmpty() ? var1 : "plain";
   }

   public static String selfBadge() {
      return selfBadge;
   }

   public static String selfNick() {
      return selfNick;
   }

   public static void apply(List<Packets.Nested1_d6cfc997> var0) {
      if (var0 != null) {
         nickStyles.clear();

         for (Packets.Nested1_d6cfc997 var2 : var0) {
            if ("NICK".equals(var2.type()) && var2.key() != null) {
               nickStyles.put(var2.key(), var2);
            }
         }
      }
   }

   public static Packets.Nested1_d6cfc997 nick(String var0) {
      if (var0 != null && !var0.isEmpty() && !"plain".equals(var0)) {
         Packets.Nested1_d6cfc997 var1 = nickStyles.get(var0);
         return var1 != null && var1.stops() != null && var1.stops().size() >= 2 ? var1 : null;
      } else {
         return null;
      }
   }

   public static Identifier badge(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         Identifier var1 = badges.get(var0);
         if (var1 != null) {
            return var1;
         } else {
            long var2 = System.currentTimeMillis();
            Long var4 = badgeRetryAt.get(var0);
            if (var4 != null && var2 < var4) {
               return null;
            } else if (badgeLoading.putIfAbsent(var0, Boolean.TRUE) != null) {
               return null;
            } else {
               new Thread(() -> {
                  try {
                     RockNetClient var1x = RockstarClient.getInstance().I_method_cd3d46d0();
                     String var2x = var1x.getHttpBase() + "/cosmetics/badge/" + var0 + ".png";
                     BufferedImage var3 = ImageIO.read(URI.create(var2x).toURL());
                     if (var3 == null) {
                        throw new IllegalStateException("\u043f\u0443\u0441\u0442\u043e\u0439 \u043e\u0442\u0432\u0435\u0442");
                     }

                     NativeImage var4x = iIIIIiiII_Class269.I_method_97bf3255(var3, false);
                     Identifier var5 = RockstarClient.id("temp/badge/" + UUID.randomUUID());
                     iIIiIIiIi_Class294.I_field_3a9bda27.getTextureManager().registerTexture(var5, new NativeImageBackedTexture(var4x));
                     badges.put(var0, var5);
                     badgeRetryAt.remove(var0);
                  } catch (Exception var9) {
                     badgeRetryAt.put(var0, System.currentTimeMillis() + 30000L);
                  } finally {
                     badgeLoading.remove(var0);
                  }
               }, "rockstar-badge-" + var0).start();
               return null;
            }
         }
      } else {
         return null;
      }
   }
}
