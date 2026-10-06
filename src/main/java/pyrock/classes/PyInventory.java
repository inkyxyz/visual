package pyrock.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry.Reference;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiIiIiI_Class299;
import rockstar.client.iIIiIiIii_Class300;
import rockstar.client.iIIiIiiIi_Class302;
import rockstar.client.iIIiiiIii_Class316;

public class PyInventory {
   public int selected() {
      return iIIiIIiIi_Class294.I_field_3a9bda27.player == null ? 0 : iIIiIIiIi_Class294.I_field_3a9bda27.player.getInventory().selectedSlot;
   }

   public boolean select(int var1) {
      if (var1 < 0 || var1 > 8 || iIIiIIiIi_Class294.I_field_3a9bda27.player == null || iIIiIIiIi_Class294.I_field_3a9bda27.getNetworkHandler() == null) {
         return false;
      } else if (iIIiIIiIi_Class294.I_field_3a9bda27.player.getInventory().selectedSlot == var1) {
         return true;
      } else {
         iIIiIIiIi_Class294.I_field_3a9bda27.player.getInventory().selectedSlot = var1;
         iIIiIIiIi_Class294.I_field_3a9bda27.getNetworkHandler().sendPacket(new UpdateSelectedSlotC2SPacket(var1));
         return true;
      }
   }

   @Nullable
   public ItemStack stack(int var1) {
      iIIiIiIii_Class300 var2 = slot(var1);
      if (var2 == null) {
         return null;
      } else {
         ItemStack var3 = var2.I_method_7b7e0bb9();
         return var3 != null && !var3.isEmpty() ? var3 : null;
      }
   }

   @Nullable
   public String id(int var1) {
      ItemStack var2 = this.stack(var1);
      return var2 == null ? null : Registries.ITEM.getId(var2.getItem()).toString();
   }

   @Nullable
   public String label(int var1) {
      ItemStack var2 = this.stack(var1);
      return var2 == null ? null : var2.getName().getString();
   }

   public int count(int var1) {
      ItemStack var2 = this.stack(var1);
      return var2 == null ? 0 : var2.getCount();
   }

   public int find(String var1, String var2) {
      Item var3 = item(var1);
      if (var3 == null) {
         return -1;
      } else {
         for (int var7 : range(var2)) {
            ItemStack var8 = this.stack(var7);
            if (var8 != null && var8.getItem() == var3) {
               return var7;
            }
         }

         return -1;
      }
   }

   public List<Integer> findAll(String var1, String var2) {
      ArrayList var3 = new ArrayList();
      Item var4 = item(var1);
      if (var4 == null) {
         return var3;
      } else {
         for (int var8 : range(var2)) {
            ItemStack var9 = this.stack(var8);
            if (var9 != null && var9.getItem() == var4) {
               var3.add(var8);
            }
         }

         return var3;
      }
   }

   public int total(String var1, String var2) {
      Item var3 = item(var1);
      if (var3 == null) {
         return 0;
      } else {
         int var4 = 0;

         for (int var8 : range(var2)) {
            ItemStack var9 = this.stack(var8);
            if (var9 != null && var9.getItem() == var3) {
               var4 += var9.getCount();
            }
         }

         return var4;
      }
   }

   public int empty(String var1) {
      for (int var5 : range(var1)) {
         if (this.stack(var5) == null) {
            return var5;
         }
      }

      return -1;
   }

   public int hold(String var1) {
      int var2 = this.find(var1, "hotbar");
      return var2 >= 0 && this.select(var2) ? var2 : -1;
   }

   public boolean swap(int var1, int var2) {
      if (slot(var1) != null && slot(var2) != null && iIIiIIiIi_Class294.I_field_3a9bda27.player != null) {
         iIIiIiIiI_Class299.i_method_c2914eff(var1, var2);
         return true;
      } else {
         return false;
      }
   }

   public boolean move(int var1, int var2) {
      iIIiIiIii_Class300 var3 = slot(var1);
      iIIiIiIii_Class300 var4 = slot(var2);
      if (var3 != null && var4 != null) {
         iIIiIiIiI_Class299.I_method_2e11f97f(var3, var4);
         return true;
      } else {
         return false;
      }
   }

   public boolean quickMove(int var1) {
      iIIiIiIii_Class300 var2 = slot(var1);
      if (var2 != null && iIIiIIiIi_Class294.I_field_3a9bda27.player != null) {
         iIIiIiIiI_Class299.I_method_8062c464(var2.I_method_dfe89252());
         return true;
      } else {
         return false;
      }
   }

   public boolean toOffhand(int var1) {
      iIIiIiIii_Class300 var2 = slot(var1);
      if (var2 == null) {
         return false;
      } else {
         iIIiIiIiI_Class299.I_method_50070487(var2);
         return true;
      }
   }

   public boolean toArmor(int var1, String var2) {
      iIIiIiIii_Class300 var3 = slot(var1);
      int var4 = armorIndex(var2);
      return var3 != null && var4 >= 0 ? iIIiIiIiI_Class299.i_method_b6e1fb40(var3, var4) : false;
   }

   public boolean withSlot(int var1, Runnable var2) {
      if (var1 >= 0 && var1 <= 8 && var2 != null) {
         iIIiiiIii_Class316 var3 = iIIiIiIiI_Class299.I_method_6602651a(var1);
         iIIiIiiIi_Class302.I_method_fe0755c5(var3, var2);
         return true;
      } else {
         return false;
      }
   }

   public double durability(int var1) {
      ItemStack var2 = this.stack(var1);
      if (var2 != null && var2.isDamageable()) {
         int var3 = var2.getMaxDamage();
         return var3 <= 0 ? -1.0 : 100.0 * (var3 - var2.getDamage()) / var3;
      } else {
         return -1.0;
      }
   }

   public int enchant(int var1, String var2) {
      ItemStack var3 = this.stack(var1);
      if (var3 != null && iIIiIIiIi_Class294.I_field_3a9bda27.world != null && var2 != null) {
         Identifier var4 = identifier(var2);
         if (var4 == null) {
            return 0;
         } else {
            try {
               Registry var5 = iIIiIIiIi_Class294.I_field_3a9bda27.world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
               Reference var6 = (Reference)var5.getEntry(var4).orElse(null);
               return var6 == null ? 0 : EnchantmentHelper.getLevel(var6, var3);
            } catch (Throwable var7) {
               return 0;
            }
         }
      } else {
         return 0;
      }
   }

   public List<Integer> slots(String var1) {
      ArrayList var2 = new ArrayList();

      for (int var6 : range(var1)) {
         var2.add(var6);
      }

      return var2;
   }

   public boolean offhandIs(String var1) {
      Item var2 = item(var1);
      return var2 != null && iIIiIiIiI_Class299.I_method_dd6aa5eb(var2);
   }

   public boolean containerOpen() {
      return iIIiIIiIi_Class294.I_field_3a9bda27.player != null
         && iIIiIIiIi_Class294.I_field_3a9bda27.currentScreen != null
         && iIIiIIiIi_Class294.I_field_3a9bda27.player.currentScreenHandler != iIIiIIiIi_Class294.I_field_3a9bda27.player.playerScreenHandler;
   }

   @Nullable
   private static iIIiIiIii_Class300 slot(int var0) {
      if (iIIiIIiIi_Class294.I_field_3a9bda27.player == null) {
         return null;
      } else if (var0 >= 0 && var0 <= 8) {
         return iIIiIiIiI_Class299.I_method_6602651a(var0);
      } else if (var0 >= 9 && var0 <= 35) {
         return iIIiIiIiI_Class299.I_method_661074fa(var0 - 9);
      } else if (var0 >= 36 && var0 <= 39) {
         return iIIiIiIiI_Class299.I_method_6602613a(39 - var0);
      } else {
         return var0 == 40 ? iIIiIiIiI_Class299.I_method_d0337735() : null;
      }
   }

   private static int armorIndex(String var0) {
      if (var0 == null) {
         return -1;
      } else {
         String var1 = var0.toLowerCase(Locale.ROOT);

         return switch (var1) {
            case "boots", "\u0431\u043e\u0442\u0438\u043d\u043a\u0438" -> 0;
            case "leggings", "\u043f\u043e\u043d\u043e\u0436\u0438", "\u0448\u0442\u0430\u043d\u044b" -> 1;
            case "chestplate", "\u043d\u0430\u0433\u0440\u0443\u0434\u043d\u0438\u043a" -> 2;
            case "helmet", "\u0448\u043b\u0435\u043c" -> 3;
            default -> -1;
         };
      }
   }

   private static int[] range(String var0) {
      String var1 = var0 == null ? "all" : var0.toLowerCase(Locale.ROOT);

      return switch (var1) {
         case "hotbar" -> ints(0, 8);
         case "main", "inventory", "backpack" -> ints(9, 35);
         case "armor" -> ints(36, 39);
         case "offhand" -> new int[]{40};
         default -> ints(0, 40);
      };
   }

   private static int[] ints(int var0, int var1) {
      int[] var2 = new int[var1 - var0 + 1];

      for (int var3 = 0; var3 < var2.length; var3++) {
         var2[var3] = var0 + var3;
      }

      return var2;
   }

   @Nullable
   private static Identifier identifier(String var0) {
      if (var0 != null && !var0.isBlank()) {
         return var0.contains(":") ? Identifier.tryParse(var0) : Identifier.tryParse("minecraft:" + var0);
      } else {
         return null;
      }
   }

   @Nullable
   private static Item item(String var0) {
      Identifier var1 = identifier(var0);
      if (var1 == null) {
         return null;
      } else {
         Item var2 = (Item)Registries.ITEM.get(var1);
         return var2 == Items.AIR && !"minecraft:air".equals(var1.toString()) ? null : var2;
      }
   }
}
