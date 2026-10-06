package rockstar.client;

import java.util.Locale;
import lombok.Generated;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Item.TooltipContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;

public final class iIIIIIiIi_Class262 implements iIIiIIiIi_Class294 {
   public static boolean I_method_1a228de3() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null && I_field_3a9bda27.interactionManager != null) {
         iIIiiIiII_Class309 var0 = iIIiiIiIi_Class310.I_method_6a489695();
         iIIiiiIii_Class316 var1 = (iIIiiiIii_Class316)var0.I_method_5d34dd7d(Items.COMPASS);
         if (var1 == null) {
            return false;
         } else {
            int var2 = var1.II_method_b9cf08f5();
            I_field_3a9bda27.player.getInventory().selectedSlot = var2;
            I_field_3a9bda27.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(var2));
            I_field_3a9bda27.interactionManager
               .sendSequencedPacket(
                  I_field_3a9bda27.world,
                  var0x -> new PlayerInteractItemC2SPacket(Hand.MAIN_HAND, var0x, I_field_3a9bda27.player.getYaw(), I_field_3a9bda27.player.getPitch())
               );
            return true;
         }
      } else {
         return false;
      }
   }

   public static boolean I_method_17a99ded(String var0) {
      String var1 = I_method_b924c5d7(var0);
      return var1.contains("\u0432\u044b\u0431\u043e\u0440 \u0441\u0435\u0440\u0432\u0435\u0440\u0430")
         || var1.contains("\u0432\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0441\u0435\u0440\u0432\u0435\u0440");
   }

   public static boolean I_method_dd8ad20f(String var0, boolean var1) {
      String var2 = I_method_b924c5d7(var0);
      return !var2.contains("\u0432\u044b\u0431\u043e\u0440 \u043c\u0438\u0440\u0430") ? false : !var1 || var2.contains("\u0433\u0440\u0438\u0444");
   }

   public static int I_method_d70844be(GenericContainerScreenHandler var0, boolean var1) {
      int var2 = II_method_3fa9bf1f(var0);
      int var3 = -1;

      for (int var4 = 0; var4 < var2; var4++) {
         if (var0.getSlot(var4).hasStack()) {
            ItemStack var5 = var0.getSlot(var4).getStack();
            String var6 = I_method_b924c5d7(I_method_9e0b5fbf(var5));
            if (var1) {
               if (var5.getItem() == Items.CRAFTING_TABLE && (var6.contains("\u0433\u0440\u0438\u0444") || var6.contains("\u0432\u044b\u0436\u0438\u0432"))) {
                  return var4;
               }

               if (var3 == -1 && var6.contains("\u0433\u0440\u0438\u0444")) {
                  var3 = var4;
               }
            } else if (var6.contains("\u0430\u043d\u0430\u0440\u0445")) {
               return var4;
            }
         }
      }

      if (var1) {
         for (int var7 = 0; var7 < var2; var7++) {
            if (var0.getSlot(var7).hasStack() && var0.getSlot(var7).getStack().getItem() == Items.CRAFTING_TABLE) {
               return var7;
            }
         }
      }

      return var3;
   }

   public static iIIIIIiIi_Class262.Nested1_86f734a0 I_method_3309b8b5(GenericContainerScreenHandler var0, String var1, int var2, boolean var3) {
      if (var2 <= 0) {
         return iIIIIIiIi_Class262.Nested1_86f734a0.I_field_9ba735e7;
      } else {
         int var4 = I_method_9f94d0d(var0, var2, var3);
         if (var4 != -1) {
            I_method_d70804fa(var0, var4);
            return iIIIIIiIi_Class262.Nested1_86f734a0.II_field_9ba735e7;
         } else {
            int var5 = I_method_89ea24a3(var0, var1, var2);
            if (var5 != -1) {
               I_method_d70804fa(var0, var5);
               return iIIIIIiIi_Class262.Nested1_86f734a0.II_field_9ba735e7;
            } else {
               int var6 = Integer.MAX_VALUE;
               int var7 = -1;
               int var8 = II_method_3fa9bf1f(var0);

               for (int var9 = 0; var9 < var8; var9++) {
                  if (var0.getSlot(var9).hasStack()) {
                     int var10 = I_method_aa723be6(var0.getSlot(var9).getStack(), var3);
                     if (var10 > 0) {
                        var6 = Math.min(var6, var10);
                        var7 = Math.max(var7, var10);
                     }
                  }
               }

               if (var7 > 0) {
                  if (var2 < var6 && II_method_34dd7ab0(var1)) {
                     return I_method_d70844cf(var0, false)
                        ? iIIIIIiIi_Class262.Nested1_86f734a0.i_field_9ba735e7
                        : iIIIIIiIi_Class262.Nested1_86f734a0.I_field_9ba735e7;
                  } else if (var2 > var7 && i_method_e860f1cd(var1)) {
                     return I_method_d70844cf(var0, true)
                        ? iIIIIIiIi_Class262.Nested1_86f734a0.i_field_9ba735e7
                        : iIIIIIiIi_Class262.Nested1_86f734a0.I_field_9ba735e7;
                  } else {
                     return iIIIIIiIi_Class262.Nested1_86f734a0.I_field_9ba735e7;
                  }
               } else if (i_method_e860f1cd(var1)) {
                  return I_method_d70844cf(var0, true)
                     ? iIIIIIiIi_Class262.Nested1_86f734a0.i_field_9ba735e7
                     : iIIIIIiIi_Class262.Nested1_86f734a0.I_field_9ba735e7;
               } else {
                  return iIIIIIiIi_Class262.Nested1_86f734a0.I_field_9ba735e7;
               }
            }
         }
      }
   }

   public static void I_method_d70804fa(GenericContainerScreenHandler var0, int var1) {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.interactionManager != null && var1 >= 0 && var1 < var0.slots.size()) {
         I_field_3a9bda27.interactionManager.clickSlot(var0.syncId, var1, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
         I_field_3a9bda27.player.currentScreenHandler.onSlotClick(var1, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
      }
   }

   private static int I_method_9f94d0d(GenericContainerScreenHandler var0, int var1, boolean var2) {
      int var3 = II_method_3fa9bf1f(var0);

      for (int var4 = 0; var4 < var3; var4++) {
         if (var0.getSlot(var4).hasStack() && I_method_aa723be6(var0.getSlot(var4).getStack(), var2) == var1) {
            return var4;
         }
      }

      return -1;
   }

   private static int I_method_89ea24a3(GenericContainerScreenHandler var0, String var1, int var2) {
      int var3 = I_method_17a99ddc(var1);
      if (var3 <= 0) {
         return -1;
      } else {
         int var4 = var2 - (var3 - 1) * 32;
         if (var4 >= 1 && var4 <= 32) {
            int var5 = (var4 - 1) / 8;
            int var6 = (var4 - 1) % 8;
            if (var6 >= 4) {
               var6++;
            }

            int var7 = var5 * 9 + var6;
            if (var7 >= 0 && var7 < II_method_3fa9bf1f(var0) && var0.getSlot(var7).hasStack()) {
               return var0.getSlot(var7).getStack().getItem() == Items.ARROW ? -1 : var7;
            } else {
               return -1;
            }
         } else {
            return -1;
         }
      }
   }

   private static boolean I_method_d70844cf(GenericContainerScreenHandler var0, boolean var1) {
      int var2 = var1 ? I_method_9352d31c(var0) : i_method_ba1d2efc(var0);
      if (var2 == -1) {
         return false;
      } else {
         I_method_d70804fa(var0, var2);
         return true;
      }
   }

   private static int I_method_9352d31c(GenericContainerScreenHandler var0) {
      int var1 = II_method_3fa9bf1f(var0);
      int var2 = -1;

      for (int var3 = 0; var3 < var1; var3++) {
         if (var0.getSlot(var3).hasStack()) {
            ItemStack var4 = var0.getSlot(var3).getStack();
            if (var4.getItem() == Items.ARROW || var4.getItem() == Items.SPECTRAL_ARROW) {
               String var5 = I_method_b924c5d7(I_method_9e0b5fbf(var4));
               if (var5.contains("\u0441\u043b\u0435\u0434") || var5.contains("\u0434\u0430\u043b\u044c") || var5.contains("next")) {
                  return var3;
               }

               if (var3 % 9 >= 4) {
                  var2 = var3;
               }
            }
         }
      }

      return var2;
   }

   private static int i_method_ba1d2efc(GenericContainerScreenHandler var0) {
      int var1 = II_method_3fa9bf1f(var0);
      int var2 = -1;

      for (int var3 = 0; var3 < var1; var3++) {
         if (var0.getSlot(var3).hasStack()) {
            ItemStack var4 = var0.getSlot(var3).getStack();
            if (var4.getItem() == Items.ARROW || var4.getItem() == Items.SPECTRAL_ARROW) {
               String var5 = I_method_b924c5d7(I_method_9e0b5fbf(var4));
               if (var5.contains("\u043f\u0440\u0435\u0434")
                  || var5.contains("\u043d\u0430\u0437\u0430\u0434")
                  || var5.contains("previous")
                  || var5.contains("back")) {
                  return var3;
               }

               if (var3 % 9 <= 4 && var2 == -1) {
                  var2 = var3;
               }
            }
         }
      }

      return var2;
   }

   private static int I_method_aa723be6(ItemStack var0, boolean var1) {
      String var2 = I_method_b924c5d7(I_method_9e0b5fbf(var0));
      int var3 = I_method_dd8a922d(var2, var2.indexOf(35) + 1);
      if (var3 > 0 && var2.indexOf(35) >= 0) {
         return var3;
      } else {
         String var4 = var1 ? "\u0433\u0440\u0438\u0444" : "\u0430\u043d\u0430\u0440\u0445";
         int var5 = var2.indexOf(var4);
         if (var5 >= 0) {
            var3 = I_method_dd8a922d(var2, var5 + var4.length());
            if (var3 > 0) {
               return var3;
            }
         }

         String var6 = var1 ? "grief" : "anarchy";
         var5 = var2.indexOf(var6);
         if (var5 >= 0) {
            var3 = I_method_dd8a922d(var2, var5 + var6.length());
            if (var3 > 0) {
               return var3;
            }
         }

         return -1;
      }
   }

   private static boolean i_method_e860f1cd(String var0) {
      int var1 = I_method_17a99ddc(var0);
      int var2 = i_method_e860f1bc(var0);
      return var1 <= 0 || var2 <= 0 || var1 < var2;
   }

   private static boolean II_method_34dd7ab0(String var0) {
      return I_method_17a99ddc(var0) > 1;
   }

   private static int I_method_17a99ddc(String var0) {
      String var1 = I_method_b924c5d7(var0);
      int var2 = var1.indexOf(47);
      return var2 == -1 ? -1 : i_method_23bdba4d(var1, var2);
   }

   private static int i_method_e860f1bc(String var0) {
      String var1 = I_method_b924c5d7(var0);
      int var2 = var1.indexOf(47);
      return var2 == -1 ? -1 : I_method_dd8a922d(var1, var2 + 1);
   }

   private static int II_method_3fa9bf1f(GenericContainerScreenHandler var0) {
      return Math.max(0, var0.slots.size() - 36);
   }

   private static String I_method_9e0b5fbf(ItemStack var0) {
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
         I_method_c1263297(var1, var4, "minecraft:custom_name");
         I_method_c1263297(var1, var4, "minecraft:item_name");
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

   private static void I_method_c1263297(StringBuilder var0, NbtCompound var1, String var2) {
      if (var1.contains(var2, 8)) {
         var0.append(' ').append(var1.getString(var2));
      }
   }

   private static int I_method_dd8a922d(String var0, int var1) {
      if (var1 < 0) {
         return -1;
      } else {
         for (int var2 = var1; var2 < var0.length(); var2++) {
            if (Character.isDigit(var0.charAt(var2))) {
               int var3 = var2 + 1;

               while (var3 < var0.length() && Character.isDigit(var0.charAt(var3))) {
                  var3++;
               }

               return II_method_34dd7a9f(var0.substring(var2, var3));
            }
         }

         return -1;
      }
   }

   private static int i_method_23bdba4d(String var0, int var1) {
      int var2 = var1 - 1;

      while (var2 >= 0 && !Character.isDigit(var0.charAt(var2))) {
         var2--;
      }

      if (var2 < 0) {
         return -1;
      } else {
         int var3 = var2 + 1;

         while (var2 >= 0 && Character.isDigit(var0.charAt(var2))) {
            var2--;
         }

         return II_method_34dd7a9f(var0.substring(var2 + 1, var3));
      }
   }

   private static int II_method_34dd7a9f(String var0) {
      try {
         return Integer.parseInt(var0);
      } catch (NumberFormatException var2) {
         return -1;
      }
   }

   private static String I_method_b924c5d7(String var0) {
      return var0 == null ? "" : var0.replaceAll("\u00a7.", "").replace('\u0451', '\u0435').replace('\u0401', '\u0415').toLowerCase(Locale.ROOT);
   }

   @Generated
   private iIIIIIiIi_Class262() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }

   public static enum Nested1_86f734a0 {
      I_field_9ba735e7,
      i_field_9ba735e7,
      II_field_9ba735e7;
   }
}
