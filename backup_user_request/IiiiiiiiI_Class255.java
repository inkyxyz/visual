package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import lombok.Generated;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.TooltipContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;

public final class IiiiiiiiI_Class255 implements iIIiIIiIi_Class294 {
   public static void I_method_cc575c7a(GenericContainerScreenHandler var0, int var1) {
      if (I_field_3a9bda27.interactionManager != null && var1 >= 0 && var1 < var0.slots.size()) {
         I_field_3a9bda27.interactionManager.clickSlot(var0.syncId, var1, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
         I_field_3a9bda27.player.currentScreenHandler.onSlotClick(var1, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
      }
   }

   public static int I_method_7633b877(int var0) {
      return switch (var0) {
         case 1 -> 20;
         case 2 -> 21;
         case 3 -> 22;
         case 4 -> 29;
         case 5 -> 30;
         case 6 -> 31;
         case 7 -> 38;
         case 8 -> 39;
         case 9 -> 40;
         default -> -1;
      };
   }

   public static int i_method_77f6a897(int var0) {
      return switch (var0) {
         case 1 -> 11;
         case 2 -> 12;
         case 3 -> 13;
         default -> 10;
      };
   }

   public static int I_method_53cd7d26(GenericContainerScreenHandler var0, String var1) {
      String var2 = I_method_e9c2fd57(var1);
      if (var2.isBlank()) {
         return -1;
      } else {
         for (int var3 = 0; var3 < var0.slots.size(); var3++) {
            if (var0.getSlot(var3).hasStack()) {
               String var4 = I_method_3992573f(var0.getSlot(var3).getStack());
               String var5 = I_method_e9c2fd57(var4);
               if (var5.contains(var2) && var5.contains("\u043b\u0430\u0439\u0442") && !var5.contains("#")) {
                  return var3;
               }
            }
         }

         return -1;
      }
   }

   public static List<Integer> I_method_370f5f7e(GenericContainerScreenHandler var0) {
      ArrayList var1 = new ArrayList();

      for (int var2 = 0; var2 < var0.slots.size(); var2++) {
         if (var0.getSlot(var2).hasStack()) {
            String var3 = I_method_e9c2fd57(I_method_3992573f(var0.getSlot(var2).getStack()));
            if (!var3.contains("#")
               && var3.contains("\u043b\u0430\u0439\u0442")
               && (
                  var3.contains("\u0441\u043e\u043b\u043e")
                     || var3.contains("\u0434\u0443\u043e")
                     || var3.contains("\u0442\u0440\u0438\u043e")
                     || var3.contains("\u043a\u043b\u0430\u043d")
               )) {
               var1.add(var2);
            }
         }
      }

      return var1;
   }

   public static int I_method_ba23e03a(iIIIiiiii_Class288 var0) {
      return switch (var0) {
         case I_field_ac24da4c -> 0;
         case i_field_ac24da4c -> 1;
         case II_field_ac24da4c -> 2;
         case Ii_field_ac24da4c -> 3;
         default -> -1;
      };
   }

   public static int I_method_25e29c23(GenericContainerScreenHandler var0, String var1, int var2) {
      if (var2 <= 0) {
         return -1;
      } else {
         String var3 = I_method_e9c2fd57(var1);

         for (int var4 = 0; var4 < var0.slots.size(); var4++) {
            if (var0.getSlot(var4).hasStack()) {
               String var5 = I_method_e9c2fd57(I_method_3992573f(var0.getSlot(var4).getStack()));
               if (I_method_d487c9be(var5, var2) && var5.contains("\u043b\u0430\u0439\u0442") && (var3.isBlank() || var5.contains(var3))) {
                  return var4;
               }
            }
         }

         return -1;
      }
   }

   public static int I_method_8a589b8f(iIIIiiiii_Class288 var0, int var1) {
      byte var2 = switch (var0) {
         case I_field_ac24da4c -> 1;
         case i_field_ac24da4c -> 13;
         case II_field_ac24da4c -> 27;
         case Ii_field_ac24da4c -> 40;
         default -> -1;
      };
      return var2 >= 0 && I_method_893394fa(var1) == var0 ? 18 + (var1 - var2) : -1;
   }

   public static iIIIiiiii_Class288 I_method_893394fa(int var0) {
      if (var0 >= 1 && var0 <= 12) {
         return iIIIiiiii_Class288.I_field_ac24da4c;
      } else if (var0 >= 13 && var0 <= 26) {
         return iIIIiiiii_Class288.i_field_ac24da4c;
      } else if (var0 >= 27 && var0 <= 39) {
         return iIIIiiiii_Class288.II_field_ac24da4c;
      } else {
         return var0 >= 40 ? iIIIiiiii_Class288.Ii_field_ac24da4c : iIIIiiiii_Class288.iI_field_ac24da4c;
      }
   }

   private static boolean I_method_d487c9be(String var0, int var1) {
      String var2 = "#" + var1;
      int var3 = 0;

      while (var3 < var0.length()) {
         int var4 = var0.indexOf(var2, var3);
         if (var4 < 0) {
            return false;
         }

         int var5 = var4 + var2.length();
         if (var5 == var0.length() || !Character.isDigit(var0.charAt(var5))) {
            return true;
         }

         var3 = var5;
      }

      return false;
   }

   private static String I_method_3992573f(ItemStack var0) {
      StringBuilder var1 = new StringBuilder(var0.getName().getString());

      try {
         if (I_field_3a9bda27.world == null) {
            return var1.toString();
         }

         for (Text var3 : var0.getTooltip(TooltipContext.create(I_field_3a9bda27.world), I_field_3a9bda27.player, TooltipType.BASIC)) {
            var1.append(' ').append(var3.getString());
         }

         if (!(var0.toNbt(I_field_3a9bda27.world.getRegistryManager()) instanceof NbtCompound var9 && var9.contains("components", 10))) {
            return var1.toString();
         }

         NbtCompound var4 = var9.getCompound("components");
         I_method_38808b17(var1, var4, "minecraft:custom_name");
         I_method_38808b17(var1, var4, "minecraft:item_name");
         if (var4.contains("minecraft:lore", 9)) {
            NbtList var5 = var4.getList("minecraft:lore", 8);

            for (int var6 = 0; var6 < var5.size(); var6++) {
               var1.append(' ').append(var5.getString(var6));
            }
         }
      } catch (Exception var7) {
      }

      return var1.toString();
   }

   private static void I_method_38808b17(StringBuilder var0, NbtCompound var1, String var2) {
      if (var1.contains(var2, 8)) {
         var0.append(' ').append(var1.getString(var2));
      }
   }

   private static String I_method_e9c2fd57(String var0) {
      return var0 == null ? "" : var0.replaceAll("\u00a7.", "").replace('\u0451', '\u0435').replace('\u0401', '\u0415').toLowerCase(Locale.ROOT);
   }

   @Generated
   private IiiiiiiiI_Class255() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
