package globals.client;

import globals.shared.proto.Packets;
import moscow.rockstar.mixin.accessors.BiomeAccesAccessor;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import rockstar.client.iIIIiiiII_Class285;
import rockstar.client.iIIiIIiIi_Class294;

public final class WorldKey implements iIIiIIiIi_Class294 {
   private final String server;
   private final int anarchy;
   private final String world;
   private final boolean single;
   private static final WorldKey NONE = new WorldKey("", -1, "none", true);
   private static final String PREFIX = "w1;";
   private static final String UNKNOWN = ";?";
   private static final String MASKED = "???";

   public WorldKey(String var1, int var2, String var3, boolean var4) {
      this.server = var1;
      this.anarchy = var2;
      this.world = var3;
      this.single = var4;
   }

   public static WorldKey local() {
      ClientWorld var0 = I_field_3a9bda27.world;
      if (var0 == null) {
         return NONE;
      } else {
         try {
            return new WorldKey(iIIIiiiII_Class285.I_method_da38608b(false), localAnarchy(), token(var0), I_field_3a9bda27.isInSingleplayer());
         } catch (Exception var2) {
            return NONE;
         }
      }
   }

   public static WorldKey of(Packets.Nested1_242f4d2b var0) {
      return var0 == null ? NONE : new WorldKey(nz(var0.server()), anarchy(var0.anarchy()), nz(var0.hash()), "single".equals(var0.ip()));
   }

   public static boolean sameWorld(Packets.Nested1_242f4d2b var0) {
      if (var0 == null) {
         return false;
      } else {
         WorldKey var1 = local();
         WorldKey var2 = of(var0);
         if (!var1.sameServer(var2)) {
            return false;
         } else {
            return var1.identified() && var2.identified() ? var1.world.equals(var2.world) : inTab(var0.nickname());
         }
      }
   }

   public boolean identified() {
      return this.world.startsWith("w1;") && !this.world.endsWith(";?");
   }

   public String stamp() {
      return this.server + "|" + this.anarchy + "|" + this.world;
   }

   private boolean sameServer(WorldKey var1) {
      if (!this.single && !var1.single) {
         boolean var2 = "???".equals(this.server) || "???".equals(var1.server);
         return var2 || !this.server.isBlank() && this.server.equals(var1.server)
            ? this.anarchy < 0 || var1.anarchy < 0 || this.anarchy == var1.anarchy
            : false;
      } else {
         return false;
      }
   }

   private static String token(ClientWorld var0) {
      String var1 = var0.getRegistryKey().getValue().toString();
      long var2 = ((BiomeAccesAccessor)(Object)var0.getBiomeAccess()).rockstar$getSeed();
      if (var2 != 0L) {
         return "w1;" + var1 + ";s" + Long.toUnsignedString(var2, 36);
      } else {
         BlockPos var4 = var0.getLevelProperties().getSpawnPos();
         return var4 != null && !BlockPos.ORIGIN.equals(var4) ? "w1;" + var1 + ";p" + var4.getX() + "," + var4.getY() + "," + var4.getZ() : "w1;" + var1 + ";?";
      }
   }

   private static boolean inTab(String var0) {
      ClientPlayerEntity var1 = I_field_3a9bda27.player;
      if (var0 != null && !var0.isBlank() && var1 != null && var1.networkHandler != null) {
         for (PlayerListEntry var3 : var1.networkHandler.getPlayerList()) {
            if (var0.equals(var3.getProfile().getName())) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private static int localAnarchy() {
      try {
         return iIIIiiiII_Class285.I_method_f5437df2();
      } catch (Exception var1) {
         return -1;
      }
   }

   private static int anarchy(String var0) {
      try {
         return Integer.parseInt(var0.trim());
      } catch (Exception var2) {
         return -1;
      }
   }

   private static String nz(String var0) {
      return var0 == null ? "" : var0;
   }

   @Override
   public final String toString() {
      return "WorldKey[server=" + this.server() + ", anarchy=" + this.anarchy() + ", world=" + this.world() + ", single=" + this.single() + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.server());
      result = 31 * result + java.util.Objects.hashCode(this.anarchy());
      result = 31 * result + java.util.Objects.hashCode(this.world());
      result = 31 * result + java.util.Objects.hashCode(this.single());
      return result;
   }

   @Override
   public final boolean equals(Object var1) {
      if (this == var1) return true;
      if (var1 == null || getClass() != var1.getClass()) return false;
      WorldKey other = (WorldKey) var1;
      return java.util.Objects.equals(this.server(), other.server())
         && java.util.Objects.equals(this.anarchy(), other.anarchy())
         && java.util.Objects.equals(this.world(), other.world())
         && java.util.Objects.equals(this.single(), other.single());
   }

   public String server() {
      return this.server;
   }

   public int anarchy() {
      return this.anarchy;
   }

   public String world() {
      return this.world;
   }

   public boolean single() {
      return this.single;
   }
}
