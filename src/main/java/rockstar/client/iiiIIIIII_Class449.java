package rockstar.client;

import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.screen.slot.SlotActionType;
import org.jetbrains.annotations.Nullable;

public final class iiiIIIIII_Class449 {
   private iiiIIIIII_Class449() {
   }

   @Nullable
   public static iiiIIIIII_Class449.Nested1_96efd060 I_method_e9ce18a5(BlockState var0) {
      MinecraftClient var1 = MinecraftClient.getInstance();
      ClientPlayerEntity var2 = var1.player;
      if (var2 == null) {
         return null;
      } else {
         PlayerInventory var3 = var2.getInventory();
         int var4 = -1;
         float var5 = 0.0F;
         boolean var6 = false;

         for (int var7 = 0; var7 < 9; var7++) {
            ItemStack var8 = var3.getStack(var7);
            if (!var8.isEmpty()) {
               float var9 = I_method_22b4e0e6(var8, var0);
               if (var9 > var5) {
                  var5 = var9;
                  var4 = var7;
                  var6 = true;
               }
            }
         }

         for (int var10 = 9; var10 < 36; var10++) {
            ItemStack var11 = var3.getStack(var10);
            if (!var11.isEmpty()) {
               float var12 = I_method_22b4e0e6(var11, var0);
               if (var12 > var5) {
                  var5 = var12;
                  var4 = var10;
                  var6 = false;
               }
            }
         }

         return var4 < 0 ? null : new iiiIIIIII_Class449.Nested1_96efd060(var4, var6, var5);
      }
   }

   public static float I_method_22b4e0e6(ItemStack var0, BlockState var1) {
      return var0 != null && !var0.isEmpty() ? var0.getMiningSpeedMultiplier(var1) : 1.0F;
   }

   public static boolean I_method_98560fd8(BlockState var0) {
      MinecraftClient var1 = MinecraftClient.getInstance();
      ClientPlayerEntity var2 = var1.player;
      if (var2 != null && var1.interactionManager != null) {
         iiiIIIIII_Class449.Nested1_96efd060 var3 = I_method_e9ce18a5(var0);
         if (var3 == null) {
            return false;
         } else {
            ItemStack var4 = var2.getMainHandStack();
            float var5 = I_method_22b4e0e6(var4, var0);
            if (var3.I_field_46 <= var5) {
               return false;
            } else if (var3.I_field_5a) {
               int var7 = var2.getInventory().selectedSlot;
               if (var3.I_field_49 == var7) {
                  return false;
               } else {
                  I_method_10f45cc4(var3.I_field_49);
                  return true;
               }
            } else {
               int var6 = var2.getInventory().selectedSlot;
               var1.interactionManager.clickSlot(var2.currentScreenHandler.syncId, var3.I_field_49, var6, SlotActionType.SWAP, var2);
               return true;
            }
         }
      } else {
         return false;
      }
   }

   public static void I_method_10f45cc4(int var0) {
      MinecraftClient var1 = MinecraftClient.getInstance();
      if (var1.player != null) {
         if (var0 >= 0 && var0 <= 8) {
            if (var1.player.getInventory().selectedSlot != var0) {
               var1.player.getInventory().selectedSlot = var0;
               var1.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(var0));
            }
         }
      }
   }

   public static final class Nested1_96efd060 {
      final int I_field_49;
      final boolean I_field_5a;
      final float I_field_46;

      public Nested1_96efd060(int var1, boolean var2, float var3) {
         this.I_field_49 = var1;
         this.I_field_5a = var2;
         this.I_field_46 = var3;
      }

      @Override
      public final String toString() {
         return "Nested1_96efd060[slotIdx=" + this.I_field_49 + ", inHotbar=" + this.I_field_5a + ", speed=" + this.I_field_46 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iiiIIIIII_Class449.Nested1_96efd060 other = (iiiIIIIII_Class449.Nested1_96efd060) var1;
         return java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.I_field_5a, other.I_field_5a)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46);
      }

      public int I_method_fced6f4d() {
         return this.I_field_49;
      }

      public boolean I_method_fced6f5e() {
         return this.I_field_5a;
      }

      public float I_method_fced6f4a() {
         return this.I_field_46;
      }
   }
}
