package rockstar.client;

import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntMaps;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import java.util.List;
import lombok.Generated;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;

public final class iIIiIiIIi_Class298 {
   public static void I_method_7db6f5f0(ItemStack var0, Object2IntMap<RegistryEntry<Enchantment>> var1) {
      var1.clear();
      if (!var0.isEmpty()) {
         for (Entry var4 : var0.getItem() == Items.ENCHANTED_BOOK
            ? ((ItemEnchantmentsComponent)var0.get(DataComponentTypes.STORED_ENCHANTMENTS)).getEnchantmentEntries()
            : var0.getEnchantments().getEnchantmentEntries()) {
            var1.put((RegistryEntry)var4.getKey(), var4.getIntValue());
         }
      }
   }

   @SafeVarargs
   public static boolean I_method_42348643(ItemStack var0, RegistryKey<Enchantment>... var1) {
      if (var0.isEmpty()) {
         return false;
      } else {
         Object2IntArrayMap var2 = new Object2IntArrayMap();
         I_method_7db6f5f0(var0, var2);

         for (RegistryKey var6 : var1) {
            if (!I_method_5673efc1(var2, var6)) {
               return false;
            }
         }

         return true;
      }
   }

   public static boolean I_method_72bc96fe(List<Text> var0, String var1) {
      for (Text var3 : var0) {
         String var4 = var3.getString().toLowerCase();
         if (var4.contains(var1.toLowerCase())) {
            return true;
         }
      }

      return false;
   }

   public static boolean I_method_e4d6bb4d(List<Text> var0, String var1, int var2) {
      for (Text var4 : var0) {
         String var5 = var4.getString().toLowerCase();
         if (var5.contains(var1.toLowerCase())) {
            if (var2 <= 1) {
               return true;
            }

            if (var2 != 2 || !var5.contains("ii") && !var5.contains(" 2")) {
               if (var2 != 3 || !var5.contains("iii") && !var5.contains(" 3")) {
                  if (var2 != 4 || !var5.contains("iv") && !var5.contains(" 4")) {
                     if (var2 != 5 || !var5.contains("v") && !var5.contains(" 5")) {
                        String var6 = String.valueOf(var2);
                        if (!var5.contains(" " + var6) && !var5.contains(var6 + " ")) {
                           continue;
                        }

                        return true;
                     }

                     return true;
                  }

                  return true;
               }

               return true;
            }

            return true;
         }
      }

      return false;
   }

   public static int I_method_7ea237bf(ItemStack var0, RegistryKey<Enchantment> var1) {
      if (var0.isEmpty()) {
         return 0;
      } else {
         Object2IntArrayMap var2 = new Object2IntArrayMap();
         I_method_7db6f5f0(var0, var2);
         return I_method_5673efb0(var2, var1);
      }
   }

   public static int I_method_5673efb0(Object2IntMap<RegistryEntry<Enchantment>> var0, RegistryKey<Enchantment> var1) {
      ObjectIterator var2 = Object2IntMaps.fastIterable(var0).iterator();

      while (var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if (((RegistryEntry)var3.getKey()).matchesKey(var1)) {
            return var3.getIntValue();
         }
      }

      return 0;
   }

   private static boolean I_method_5673efc1(Object2IntMap<RegistryEntry<Enchantment>> var0, RegistryKey<Enchantment> var1) {
      ObjectIterator var2 = var0.keySet().iterator();

      while (var2.hasNext()) {
         RegistryEntry var3 = (RegistryEntry)var2.next();
         if (var3.matchesKey(var1)) {
            return true;
         }
      }

      return false;
   }

   @Generated
   private iIIiIiIIi_Class298() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
