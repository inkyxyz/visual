package rockstar.client;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import lombok.Generated;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public final class IiiiiiIII_Class249 implements iIIiIIiIi_Class294 {
   private static final Map<String, Integer> I_field_a567c40b = Map.of(
      "\u0410\u0440\u0435\u0441\u0430",
      1,
      "\u0425\u0430\u043e\u0441\u0430",
      2,
      "\u0422\u0438\u0442\u0430\u043d\u0430",
      3,
      "\u0413\u0438\u0434\u0440\u044b",
      4,
      "\u0411\u0435\u0441\u0442\u0438\u0438",
      5,
      "\u0418\u043a\u0430\u0440\u0430",
      6,
      "\u0421\u0430\u0442\u0438\u0440\u0430",
      7,
      "\u042d\u0440\u0438\u0434\u0430",
      8,
      "\u041c\u043e\u0440\u043e\u0437\u0430",
      9
   );
   private static final Map<String, Integer> i_field_a567c40b = Map.of(
      "\u041a\u0440\u0443\u0448\u0438\u0442\u0435\u043b\u044f",
      1,
      "\u041a\u0430\u0440\u0430\u0442\u0435\u043b\u044f",
      2,
      "\u042f\u0440\u043e\u0441\u0442\u0438",
      3,
      "\u0420\u0430\u0437\u0434\u043e\u0440\u0430",
      4,
      "\u0422\u0438\u0440\u0430\u043d\u0430",
      5,
      "\u0414\u0435\u043c\u043e\u043d\u0430",
      6,
      "\u0412\u0438\u0445\u0440\u044f",
      7,
      "\u041c\u0440\u0430\u043a\u0430",
      8,
      "\u0413\u0440\u0438\u043d\u0447\u0430",
      9
   );
   private static final Map<String, Integer> II_field_a567c40b = Map.of("Infinity", 1, "Eternity", 2, "Stinger", 3);
   private static final Map<String, Integer> Ii_field_a567c40b = Map.of("Armortality", 3, "Eternity", 4, "Immortal", 5, "Stinger", 6, "Flash", 7, "Cerber", 8);
   private static final Map<String, Integer> iI_field_a567c40b = Map.of(
      "\u041a\u0440\u0443\u0448\u0438\u0442\u0435\u043b\u044f",
      1,
      "\u041a\u0430\u0440\u0430\u0442\u0435\u043b\u044f",
      2,
      "\u042f\u0440\u043e\u0441\u0442\u0438",
      3,
      "\u0414\u0435\u0434\u0430\u043b\u0430",
      4,
      "\u0413\u0440\u0430\u043d\u0438",
      5,
      "\u0413\u0430\u0440\u043c\u043e\u043d\u0438\u0438",
      6,
      "\u0415\u0445\u0438\u0434\u043d\u044b",
      7,
      "\u0422\u0440\u0438\u0442\u043e\u043d\u0430",
      8,
      "\u0424\u0435\u043d\u0438\u043a\u0441\u0430",
      9
   );
   private static final Map<String, Integer> ii_field_a567c40b = Map.of(
      "\u0410\u043d\u0434\u0440\u043e\u043c\u0435\u0434\u044b",
      1,
      "\u0422\u0438\u0442\u0430\u043d\u0430",
      2,
      "\u0410\u043f\u043e\u043b\u043b\u043e\u043d\u0430",
      3,
      "\u0410\u0441\u0442\u0440\u0435\u044f",
      4,
      "\u041e\u0441\u0438\u0440\u0438\u0441\u0430",
      5,
      "\u041f\u0430\u043d\u0434\u043e\u0440\u044b",
      6,
      "\u0425\u0438\u043c\u0435\u0440\u044b",
      7
   );
   private static final Map<String, Integer> III_field_a567c40b = Map.of(
      "attribute-item-tkryshitela",
      1,
      "attribute-item-tkaratela",
      2,
      "attribute-item-tjarosti",
      3,
      "attribute-item-trazdora",
      4,
      "attribute-item-ttirana",
      5,
      "attribute-item-tdemona",
      6,
      "attribute-item-tvihra",
      7,
      "attribute-item-tmraka",
      8,
      "attribute-item-tgrincha",
      9
   );
   private static final Map<String, Integer> IIi_field_a567c40b = Map.of(
      "attribute-item-saresa",
      1,
      "attribute-item-shaosa",
      2,
      "attribute-item-stitana",
      3,
      "attribute-item-sgidri",
      4,
      "attribute-item-sbestii",
      5,
      "attribute-item-sikara",
      6,
      "attribute-item-ssatira",
      7,
      "attribute-item-serida",
      8,
      "attribute-item-smoroza",
      9
   );
   private static final int I_field_49 = 999;

   public static int I_method_9a86b74(ItemStack var0) {
      if (var0 != null && !var0.isEmpty() && var0.getItem() == Items.TOTEM_OF_UNDYING) {
         IiiiiIiii_Class248.Nested1_95187080 var1 = IiiiiIiii_Class248.I_method_7613ca72(var0);
         if (var1 == null) {
            return var0.hasEnchantments() ? 1 : 0;
         } else if (var1.iI_method_e48a6b8b()) {
            String var2 = var1.I_method_3665aca6();
            if (var2 != null && !var2.isEmpty()) {
               int var3 = I_method_6188c9b5(var1);
               return var3 == 999 ? 1000 : 100 - var3;
            } else {
               return var0.hasEnchantments() ? 1 : 0;
            }
         } else {
            return 50;
         }
      } else {
         return Integer.MAX_VALUE;
      }
   }

   public static int i_method_ada0ef54(ItemStack var0) {
      if (var0 != null && !var0.isEmpty()) {
         IiiiiIiii_Class248.Nested1_95187080 var1 = IiiiiIiii_Class248.I_method_7613ca72(var0);
         return var1 != null ? I_method_6188c9b5(var1) : 999;
      } else {
         return 999;
      }
   }

   public static int I_method_6188c9b5(IiiiiIiii_Class248.Nested1_95187080 var0) {
      if (var0 == null) {
         return 999;
      } else {
         return switch (var0.I_method_f2690c42()) {
            case II_field_e400d4a6 -> II_method_3371e12(var0);
            case Ii_field_e400d4a6 -> Ii_method_be2e9e32(var0);
            case I_field_e400d4a6, i_field_e400d4a6 -> i_method_1c8049d5(var0);
            case iI_field_e400d4a6 -> iI_method_a72fa1f2(var0);
            default -> 999;
         };
      }
   }

   private static int i_method_1c8049d5(IiiiiIiii_Class248.Nested1_95187080 var0) {
      String var1 = var0.I_method_3665aca6();
      if (var0.iI_method_e48a6b8b()) {
         if (var1 != null && II_field_a567c40b.containsKey(var1)) {
            return II_field_a567c40b.get(var1);
         } else {
            IiiiiIiii_Class248.Nested1_df59c09 var3 = var0.I_method_f2691022();
            if (var3 != null) {
               return switch (var3) {
                  case Ii_field_e400d886 -> 4;
                  case II_field_e400d886 -> 5;
                  case i_field_e400d886 -> 6;
                  case I_field_e400d886 -> 7;
                  default -> 999;
               };
            } else {
               return 999;
            }
         }
      } else if (var0.Ii_method_e2d6074b()) {
         if (var1 != null && Ii_field_a567c40b.containsKey(var1)) {
            return Ii_field_a567c40b.get(var1);
         } else {
            int var2 = var0.Ii_method_e2d6073a();
            return var2 > 0 ? 10 - var2 : 999;
         }
      } else {
         return 999;
      }
   }

   private static int II_method_3371e12(IiiiiIiii_Class248.Nested1_95187080 var0) {
      String var1 = var0.I_method_3665aca6();
      if (var1 == null) {
         return 999;
      } else if (var0.Ii_method_e2d6074b()) {
         return I_field_a567c40b.getOrDefault(var1, 999);
      } else {
         return var0.iI_method_e48a6b8b() ? i_field_a567c40b.getOrDefault(var1, 999) : 999;
      }
   }

   private static int Ii_method_be2e9e32(IiiiiIiii_Class248.Nested1_95187080 var0) {
      String var1 = var0.I_method_3665aca6();
      if (var1 == null) {
         return 999;
      } else if (var0.Ii_method_e2d6074b()) {
         return ii_field_a567c40b.getOrDefault(var1, 999);
      } else {
         return var0.iI_method_e48a6b8b() ? iI_field_a567c40b.getOrDefault(var1, 999) : 999;
      }
   }

   private static int iI_method_a72fa1f2(IiiiiIiii_Class248.Nested1_95187080 var0) {
      String var1 = var0.I_method_3665aca6();
      if (var1 == null) {
         return 999;
      } else if (var0.Ii_method_e2d6074b()) {
         return IIi_field_a567c40b.getOrDefault(var1, 999);
      } else {
         return var0.iI_method_e48a6b8b() ? III_field_a567c40b.getOrDefault(var1, 999) : 999;
      }
   }

   private static int ii_method_62272212(IiiiiIiii_Class248.Nested1_95187080 var0) {
      if (var0 == null) {
         return 999;
      } else if ("Cerber".equals(var0.I_method_3665aca6())) {
         return 200;
      } else {
         int var1 = var0.II_method_e2c77b5a();
         int var2 = var0.i_method_d5d26f0d();
         if (var1 >= 3) {
            return 10 - var1;
         } else if (var2 >= 3) {
            return 20 - var2;
         } else if (var0.II_method_e2c77b6b()) {
            return 30 + Ii_field_a567c40b.getOrDefault(var0.I_method_3665aca6(), 999);
         } else {
            return var1 == 2 ? 40 - var1 : 50 - var2;
         }
      }
   }

   public static ItemStack I_method_ff647e68(List<ItemStack> var0) {
      return I_method_321d3220(var0, IiiiiIiii_Class248.Nested1_95187080::Ii_method_e2d6074b, Comparator.comparingInt(IiiiiiIII_Class249::i_method_ada0ef54));
   }

   public static ItemStack i_method_f097be88(List<ItemStack> var0) {
      return i_method_5386a240(var0, IiiiiIiii_Class248.Nested1_95187080::Ii_method_e2d6074b, Comparator.comparingInt(IiiiiiIII_Class249::i_method_ada0ef54));
   }

   public static ItemStack II_method_8fa078c5(List<ItemStack> var0) {
      return I_method_321d3220(var0, IiiiiIiii_Class248.Nested1_95187080::iI_method_e48a6b8b, Comparator.comparingInt(IiiiiiIII_Class249::i_method_ada0ef54));
   }

   public static ItemStack Ii_method_80d3b8e5(List<ItemStack> var0) {
      return i_method_5386a240(var0, IiiiiIiii_Class248.Nested1_95187080::iI_method_e48a6b8b, Comparator.comparingInt(IiiiiiIII_Class249::i_method_ada0ef54));
   }

   public static ItemStack iI_method_c4d53ca5(List<ItemStack> var0) {
      boolean var1 = var0.stream().anyMatch(var0x -> var0x.getItem() == Items.TOTEM_OF_UNDYING && IiiiiIiii_Class248.I_method_7613ca72(var0x) == null);
      return var1 ? null : Ii_method_80d3b8e5(var0);
   }

   public static ItemStack ii_method_b6087cc5(List<ItemStack> var0) {
      return I_method_321d3220(
         var0,
         var0x -> var0x.Ii_method_e2d6074b() && var0x.I_method_d5c3e32d() >= 3,
         Comparator.comparingInt(var0x -> 10 - IiiiiIiii_Class248.I_method_7613ca72(var0x).I_method_d5c3e32d())
      );
   }

   public static ItemStack III_method_6e3ca08(List<ItemStack> var0) {
      return I_method_321d3220(
         var0,
         var0x -> var0x.Ii_method_e2d6074b() && var0x.I_method_d5c3e32d() < 3,
         Comparator.comparingInt(var0x -> ii_method_62272212(IiiiiIiii_Class248.I_method_7613ca72(var0x)))
      );
   }

   public static ItemStack IIi_method_f8170a28(List<ItemStack> var0) {
      return I_method_6a6c5fe(
         var0,
         var0x -> var0x.Ii_method_e2d6074b() && var0x.I_method_d5c3e32d() < 3,
         Comparator.comparingInt(var0x -> ii_method_62272212(IiiiiIiii_Class248.I_method_7613ca72(var0x))),
         III_method_6e3ca08(var0)
      );
   }

   private static ItemStack I_method_321d3220(List<ItemStack> var0, Predicate<IiiiiIiii_Class248.Nested1_95187080> var1, Comparator<ItemStack> var2) {
      return I_method_6a6c5fe(var0, var1, var2, null);
   }

   private static ItemStack I_method_6a6c5fe(
      List<ItemStack> var0, Predicate<IiiiiIiii_Class248.Nested1_95187080> var1, Comparator<ItemStack> var2, ItemStack var3
   ) {
      return var0.stream().filter(var2x -> {
         IiiiiIiii_Class248.Nested1_95187080 var3x = IiiiiIiii_Class248.I_method_7613ca72(var2x);
         return var3x != null && var1.test(var3x) && (var3 == null || !ItemStack.areEqual(var2x, var3));
      }).min(var2).orElse(null);
   }

   private static ItemStack i_method_5386a240(List<ItemStack> var0, Predicate<IiiiiIiii_Class248.Nested1_95187080> var1, Comparator<ItemStack> var2) {
      return var0.stream().filter(var1x -> {
         IiiiiIiii_Class248.Nested1_95187080 var2x = IiiiiIiii_Class248.I_method_7613ca72(var1x);
         return var2x != null && var1.test(var2x);
      }).max(var2).orElse(null);
   }

   @Generated
   private IiiiiiIII_Class249() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
