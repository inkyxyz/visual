package rockstar.client;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import moscow.rockstar.mixin.accessors.EntityAccessor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity.RemovalReason;
import net.minecraft.entity.player.PlayerEntity;
import pyrock.events.game.WorldChangeEvent;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Anti Bot",
   category = ModuleCategory.COMBAT,
   III_method_a89e5834 = "modules.descriptions.anti_bot"
)
public class AntiBotModule extends Module {
   public static List<Entity> I_field_7865b31 = new ArrayList<>();
   private BooleanSetting I_field_ba20ca4c;
   private final Map<Integer, PlayerEntity> I_field_a567c40b = new HashMap<>();
   private final Set<Integer> I_field_a56a8dc5 = new HashSet<>();
   private final IiIIIiII_Class69<WorldChangeEvent> I_field_3d936f41 = var1 -> this.iII_method_73c69ac();

   public AntiBotModule() {
      this.IiI_method_d26445ec();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_d26445ec() {
      this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.anti_bot.remove_from_world").I_method_decd82b5();
   }

   @Override
   public void II_method_6642fd22() {
      if (I_field_3a9bda27.world != null && I_field_3a9bda27.player != null) {
         this.Iii_method_d272d1cc();

         for (PlayerEntity var2 : (Iterable<PlayerEntity>)(Iterable<?>)new ArrayList(I_field_3a9bda27.world.getPlayers())) {
            if (I_field_3a9bda27.player != var2 && !(var2 instanceof IiiiiiiIi_Class254)) {
               boolean var3 = this.i_method_3da9c3e5(var2);
               boolean var4 = this.I_method_21ebb351(var2).I_method_be268aab();
               boolean var5 = this.I_method_eb81005(var2);
               if (!var3 && !var4 && !var5) {
                  I_field_7865b31.remove(var2);
               } else {
                  if (!I_field_7865b31.contains(var2)) {
                     I_field_7865b31.add(var2);
                  }

                  if (this.I_field_ba20ca4c.i_method_9b12da03() && !this.I_field_a567c40b.containsKey(var2.getId())) {
                     this.I_method_c84aa2f3(var2, var5);
                  }
               }
            }
         }
      }
   }

   private void I_method_c84aa2f3(PlayerEntity var1, boolean var2) {
      this.I_field_a567c40b.put(var1.getId(), var1);
      if (var2) {
         this.I_field_a56a8dc5.add(var1.getId());
      }

      assert I_field_3a9bda27.world != null;

      I_field_3a9bda27.world.removeEntity(var1.getId(), RemovalReason.DISCARDED);
   }

   private void Iii_method_d272d1cc() {
      Iterator var1 = this.I_field_a56a8dc5.iterator();

      while (var1.hasNext()) {
         int var2 = (Integer)var1.next();
         PlayerEntity var3 = this.I_field_a567c40b.get(var2);
         if (var3 == null) {
            var1.remove();
         } else if (!(IiiiiiiII_Class253.I_method_6c00a1c4(var3) <= 0.0F)) {
            ((EntityAccessor)(Object)var3).invokeUnsetRemoved();
            I_field_3a9bda27.world.addEntity(var3);
            I_field_7865b31.remove(var3);
            this.I_field_a567c40b.remove(var2);
            var1.remove();
         }
      }
   }

   private boolean I_method_eb81005(PlayerEntity var1) {
      return var1 == null ? false : !(IiiiiiiII_Class253.I_method_6c00a1c4(var1) > 0.0F);
   }

   private boolean i_method_3da9c3e5(PlayerEntity var1) {
      if (var1 == null) {
         return false;
      } else {
         String var2 = var1.getName().getString();
         UUID var3 = UUID.nameUUIDFromBytes(("OfflinePlayer:" + var2).getBytes(StandardCharsets.UTF_8));
         boolean var4 = !var1.getUuid().equals(var3);
         boolean var5 = !var2.contains("NPC") && !var2.startsWith("[ZNPC]");
         return var4 && var5;
      }
   }

   private AntiBotModule.Nested1_94fc18f3 I_method_21ebb351(PlayerEntity var1) {
      String var2 = var1.getName().getString();
      String var3 = var1.getDisplayName().getString();
      int var4 = var3.indexOf(var2);
      String var5 = var4 > 0 ? var3.substring(0, var4).trim() : "";
      return new AntiBotModule.Nested1_94fc18f3(var3, var5, var5.isBlank());
   }

   public static boolean I_method_fe179c75(LivingEntity var0) {
      return var0 instanceof PlayerEntity && I_field_7865b31.contains(var0);
   }

   @Override
   public void onDisable() {
      this.iII_method_73c69ac();
      super.onDisable();
   }

   private void iII_method_73c69ac() {
      I_field_7865b31.clear();
      this.I_field_a567c40b.clear();
      this.I_field_a56a8dc5.clear();
   }

   static final class Nested1_94fc18f3 {
      private final String I_field_523beb0a;
      private final String i_field_523beb0a;
      private final boolean I_field_5a;

      Nested1_94fc18f3(String var1, String var2, boolean var3) {
         this.I_field_523beb0a = var1;
         this.i_field_523beb0a = var2;
         this.I_field_5a = var3;
      }

      @Override
      public final String toString() {
         return "Nested1_94fc18f3[fullTag=" + this.I_field_523beb0a + ", prefix=" + this.i_field_523beb0a + ", noPrefix=" + this.I_field_5a + "]";
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
         AntiBotModule.Nested1_94fc18f3 other = (AntiBotModule.Nested1_94fc18f3) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.i_field_523beb0a, other.i_field_523beb0a)
            && java.util.Objects.equals(this.I_field_5a, other.I_field_5a);
      }

      public String I_method_bae32cd9() {
         return this.I_field_523beb0a;
      }

      public String i_method_4e01dcf9() {
         return this.i_field_523beb0a;
      }

      public boolean I_method_be268aab() {
         return this.I_field_5a;
      }
   }
}
