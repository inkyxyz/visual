package rockstar.client;

import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.Generated;
import net.minecraft.client.MinecraftClient;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;

public final class IiiIIiIi_Class102 {
   private static final List<IiiIIiIi_Class102.Nested1_6cef9133> I_field_7865b31 = new ArrayList<>();
   private static final Map<String, Integer> I_field_a567c40b = new HashMap<>();

   public static void I_method_d70ad618(ItemStack var0, long var1, String var3, String var4, IiiIIiIi_Class102.Nested1_6cef9113 var5, double var6) {
      I_method_5e18ace8(var0, var1, var3, var4, var5, var6, false, 0L, 1, 10);
   }

   public static void I_method_a509fbc(ItemStack var0, long var1, String var3, String var4, IiiIIiIi_Class102.Nested1_6cef9113 var5, double var6, boolean var8) {
      I_method_5e18ace8(var0, var1, var3, var4, var5, var6, var8, 0L, 1, 10);
   }

   public static void I_method_5e18ace8(
      ItemStack var0, long var1, String var3, String var4, IiiIIiIi_Class102.Nested1_6cef9113 var5, double var6, boolean var8, long var9, int var11, int var12
   ) {
      I_field_7865b31.removeIf(var1x -> var1x.i_method_29f1a539() != null && var1x.i_method_29f1a539().equals(var4));
      I_field_7865b31.add(
         new IiiIIiIi_Class102.Nested1_6cef9133(var0.copy(), var1, var3, var4, var5, var6, var8, Math.max(0L, var9), Math.max(1, var11), Math.max(1, var12))
      );
   }

   public static List<IiiIIiIi_Class102.Nested1_6cef9133> I_method_2a0b303b() {
      return List.copyOf(I_field_7865b31);
   }

   public static void I_method_fb30f88c() {
      I_field_7865b31.clear();
   }

   public static void I_method_99d59756(String var0) {
      I_field_7865b31.removeIf(var1 -> var1.i_method_29f1a539() != null && var1.i_method_29f1a539().equals(var0));
      I_field_a567c40b.remove(var0);
   }

   public static void I_method_a0ddc66d(String var0, int var1) {
      if (var0 != null && var1 > 0) {
         I_field_a567c40b.merge(var0, var1, Integer::sum);
      }
   }

   public static void i_method_e710ee8d(String var0, int var1) {
      if (var0 != null && var1 > 0) {
         I_field_a567c40b.merge(var0, -var1, Integer::sum);
         if (I_field_a567c40b.getOrDefault(var0, 0) <= 0) {
            I_field_a567c40b.remove(var0);
         }
      }
   }

   public static void i_method_fb3f846c() {
      I_field_a567c40b.clear();
   }

   public static int I_method_99d59749(String var0) {
      return var0 == null ? 0 : I_field_a567c40b.getOrDefault(var0, 0);
   }

   public static int I_method_81b5829b(IiiIIiIi_Class102.Nested1_6cef9133 var0) {
      MinecraftClient var1 = MinecraftClient.getInstance();
      if (var1.player == null) {
         return 0;
      } else {
         PlayerInventory var2 = var1.player.getInventory();
         int var3 = 0;

         for (int var4 = 0; var4 < var2.size(); var4++) {
            ItemStack var5 = var2.getStack(var4);
            if (I_method_f3d9980e(var5, var0)) {
               var3 += var5.getCount();
            }
         }

         return var3;
      }
   }

   public static boolean I_method_81b582ac(IiiIIiIi_Class102.Nested1_6cef9133 var0) {
      return I_method_99d59749(var0.i_method_29f1a539()) >= Math.max(1, var0.i_method_18e2c63a());
   }

   public static String I_method_dcb516f8(IiiIIiIi_Class102.Nested1_6cef9133 var0) {
      return var0.I_method_96d2f519() != null ? var0.I_method_96d2f519() : Iiiiiiiii_Class256.I_method_e0e8875f(var0.I_method_2478c0b1());
   }

   public static IiiIIiIi_Class102.Nested1_6cef9133 I_method_954f1204(ItemStack var0) {
      if (var0 != null && !var0.isEmpty()) {
         for (IiiIIiIi_Class102.Nested1_6cef9133 var2 : I_field_7865b31) {
            if (I_method_f3d9980e(var0, var2)) {
               return var2;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   public static boolean I_method_c11927ed(IiiiiIIii_Class244.Nested1_93558040 var0, double var1) {
      ItemStack var3 = var0.I_method_5a4ac7e();
      if (var3 != null && !var3.isEmpty()) {
         Iterator var4 = I_field_7865b31.iterator();

         while (true) {
            if (!var4.hasNext()) {
               return false;
            }

            IiiIIiIi_Class102.Nested1_6cef9133 var5 = (IiiIIiIi_Class102.Nested1_6cef9133)var4.next();
            if (I_method_f3d9980e(var3, var5) && !I_method_81b582ac(var5)) {
               if (var5.I_method_b49c50b() == IiiIIiIi_Class102.Nested1_6cef9113.I_field_af10c1bc) {
                  if (var0.I_method_15faab6e() > var5.I_method_18d43a5b()) {
                     continue;
                  }
                  break;
               } else {
                  if (var5.I_method_b49c50b() != IiiIIiIi_Class102.Nested1_6cef9113.i_field_af10c1bc) {
                     break;
                  }

                  if (!(var1 <= 0.0)) {
                     double var6 = var1 * (1.0 - var5.I_method_18d43a55() / 100.0);
                     if (var0.I_method_15faab68() > var6) {
                        continue;
                     }
                     break;
                  }
               }
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public static boolean I_method_f3d9980e(ItemStack var0, IiiIIiIi_Class102.Nested1_6cef9133 var1) {
      if (var0 != null && !var0.isEmpty()) {
         ItemStack var2 = var1.I_method_2478c0b1();
         if (var2 == null || var2.isEmpty()) {
            return false;
         } else if (!var2.isOf(var0.getItem())) {
            return false;
         } else if (var2.getItem() instanceof PotionItem) {
            return iIIIIIiII_Class261.I_method_db03f4c7(var2, var0);
         } else {
            Object2IntArrayMap var3 = new Object2IntArrayMap();
            iIIiIiIIi_Class298.I_method_7db6f5f0(var2, var3);
            boolean var4 = var1.I_method_18d43a6b() || !var3.isEmpty();
            if (var4 && !I_method_c29f55b5(var0, var3, var1.I_method_18d43a6b())) {
               return false;
            } else if (IiiiIiII_Class117.I_method_e158a4f2(var2)) {
               if (IiiiIiII_Class117.I_method_bab8569e(var2, var1.I_method_96d2f519(), var0)) {
                  return true;
               } else {
                  IiiiIiII_Class117.I_method_729ec638(I_method_dcb516f8(var1), var0);
                  return false;
               }
            } else {
               IiiiiIiii_Class248.Nested1_95187080 var5 = IiiiiIiii_Class248.I_method_7613ca72(var2);
               if (var5 == null && var4) {
                  return true;
               } else {
                  IiiiiIiii_Class248.Nested1_95187080 var6 = IiiiiIiii_Class248.I_method_7613ca72(var0);
                  return var5 != null && var6 != null && var5.I_method_51483acb(var6) ? true : i_method_7ba78bee(var0, var1);
               }
            }
         }
      } else {
         return false;
      }
   }

   private static boolean i_method_7ba78bee(ItemStack var0, IiiIIiIi_Class102.Nested1_6cef9133 var1) {
      String var2 = Iiiiiiiii_Class256.i_method_524c3f7f(var0);
      return var1.I_method_96d2f519() != null
         ? var2.contains(var1.I_method_96d2f519())
         : var2.contains(Iiiiiiiii_Class256.i_method_524c3f7f(var1.I_method_2478c0b1()))
            || var2.contains(Iiiiiiiii_Class256.I_method_e0e8875f(var1.I_method_2478c0b1()));
   }

   private static boolean I_method_c29f55b5(ItemStack var0, Object2IntMap<RegistryEntry<Enchantment>> var1, boolean var2) {
      Object2IntArrayMap var3 = new Object2IntArrayMap();
      iIIiIiIIi_Class298.I_method_7db6f5f0(var0, var3);
      if (var2 && var1.size() != var3.size()) {
         return false;
      } else {
         ObjectIterator var4 = var1.object2IntEntrySet().iterator();

         while (var4.hasNext()) {
            Entry var5 = (Entry)var4.next();
            int var6 = I_method_3e618ccd(var3, (RegistryEntry<Enchantment>)var5.getKey());
            if (var2 ? var6 != var5.getIntValue() : var6 < var5.getIntValue()) {
               return false;
            }
         }

         return true;
      }
   }

   private static int I_method_3e618ccd(Object2IntMap<RegistryEntry<Enchantment>> var0, RegistryEntry<Enchantment> var1) {
      ObjectIterator var2 = var0.object2IntEntrySet().iterator();

      while (var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if (I_method_ad95347a((RegistryEntry<Enchantment>)var3.getKey(), var1)) {
            return var3.getIntValue();
         }
      }

      return 0;
   }

   private static boolean I_method_ad95347a(RegistryEntry<Enchantment> var0, RegistryEntry<Enchantment> var1) {
      if (var0.equals(var1)) {
         return true;
      } else {
         Optional var2 = var0.getKey();
         Optional var3 = var1.getKey();
         return var2.isPresent() && var3.isPresent() && ((RegistryKey)var2.get()).equals(var3.get());
      }
   }

   @Generated
   private IiiIIiIi_Class102() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }

   public static enum Nested1_6cef9113 {
      I_field_af10c1bc,
      i_field_af10c1bc;
   }

   public static final class Nested1_6cef9133 {
      private final ItemStack I_field_f2735522;
      private final long I_field_4a;
      private final String I_field_523beb0a;
      private final String i_field_523beb0a;
      private final IiiIIiIi_Class102.Nested1_6cef9113 I_field_af10c1bc;
      private final double I_field_44;
      private final boolean I_field_5a;
      private final long i_field_4a;
      private final int I_field_49;
      private final int i_field_49;

      public Nested1_6cef9133(
         ItemStack var1,
         long var2,
         String var4,
         String var5,
         IiiIIiIi_Class102.Nested1_6cef9113 var6,
         double var7,
         boolean var9,
         long var10,
         int var12,
         int var13
      ) {
         this.I_field_f2735522 = var1;
         this.I_field_4a = var2;
         this.I_field_523beb0a = var4;
         this.i_field_523beb0a = var5;
         this.I_field_af10c1bc = var6;
         this.I_field_44 = var7;
         this.I_field_5a = var9;
         this.i_field_4a = var10;
         this.I_field_49 = var12;
         this.i_field_49 = var13;
      }

      @Override
      public final String toString() {
         return "Nested1_6cef9133[stack=" + this.I_field_f2735522 + ", maxPrice=" + this.I_field_4a + ", customName=" + this.I_field_523beb0a + ", id=" + this.i_field_523beb0a + ", mode=" + this.I_field_af10c1bc + ", percentage=" + this.I_field_44 + ", strictEnchants=" + this.I_field_5a + ", sellPrice=" + this.i_field_4a + ", sellQty=" + this.I_field_49 + ", resellThreshold=" + this.i_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_f2735522);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_4a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_af10c1bc);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_44);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_4a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiiIIiIi_Class102.Nested1_6cef9133 other = (IiiIIiIi_Class102.Nested1_6cef9133) var1;
         return java.util.Objects.equals(this.I_field_f2735522, other.I_field_f2735522)
            && java.util.Objects.equals(this.I_field_4a, other.I_field_4a)
            && java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.i_field_523beb0a, other.i_field_523beb0a)
            && java.util.Objects.equals(this.I_field_af10c1bc, other.I_field_af10c1bc)
            && java.util.Objects.equals(this.I_field_44, other.I_field_44)
            && java.util.Objects.equals(this.I_field_5a, other.I_field_5a)
            && java.util.Objects.equals(this.i_field_4a, other.i_field_4a)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.i_field_49, other.i_field_49);
      }

      public ItemStack I_method_2478c0b1() {
         return this.I_field_f2735522;
      }

      public long I_method_18d43a5b() {
         return this.I_field_4a;
      }

      public String I_method_96d2f519() {
         return this.I_field_523beb0a;
      }

      public String i_method_29f1a539() {
         return this.i_field_523beb0a;
      }

      public IiiIIiIi_Class102.Nested1_6cef9113 I_method_b49c50b() {
         return this.I_field_af10c1bc;
      }

      public double I_method_18d43a55() {
         return this.I_field_44;
      }

      public boolean I_method_18d43a6b() {
         return this.I_field_5a;
      }

      public long i_method_18e2c63b() {
         return this.i_field_4a;
      }

      public int I_method_18d43a5a() {
         return this.I_field_49;
      }

      public int i_method_18e2c63a() {
         return this.i_field_49;
      }
   }
}
