package rockstar.client;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Predicate;
import lombok.Generated;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BundleContentsComponent;
import net.minecraft.item.BundleItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.BundleItemSelectedC2SPacket;
import net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.network.packet.s2c.play.CooldownUpdateS2CPacket;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.Hand;
import pyrock.events.network.ReceivePacketEvent;
import pyrock.events.network.SendPacketEvent;
import pyrock.events.player.ClientPlayerTickEvent;

public class iIIiIIiII_Class293 implements iIIiIIiIi_Class294 {
   private Item I_field_3c05b08c = null;
   private iIIiiiIii_Class316 I_field_48ddb68c = null;
   private boolean I_field_5a;
   private iIIiIiIii_Class300 I_field_1242a2ac = null;
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private iIIiIIiII_Class293.Nested1_e06eb3e9 I_field_60aabca6;
   private int I_field_49;
   private iIIiIiIii_Class300 i_field_1242a2ac;
   private iIIiiiIii_Class316 i_field_48ddb68c;
   private int i_field_49;
   private int II_field_49;
   private ItemStack I_field_f2735522;
   private ItemStack i_field_f2735522;
   private boolean i_field_5a;
   private Object I_field_5f790d9c;
   private iIIiiiIii_Class316 II_field_48ddb68c;
   private int Ii_field_49;
   private boolean II_field_5a;
   private static final int iI_field_49 = 5;
   private int ii_field_49;
   private int III_field_49;
   private Item i_field_3c05b08c;
   private int IIi_field_49;
   private final Map<Item, iIIiIIiII_Class293.Nested1_831c5880> I_field_a567c40b;
   private Item II_field_3c05b08c;
   private final IiIIIiII_Class69<ReceivePacketEvent> I_field_3d936f41;
   private final IiIIIiII_Class69<ClientPlayerTickEvent> i_field_3d936f41;
   private final IiIIIiII_Class69<SendPacketEvent> II_field_3d936f41;

   public iIIiIIiII_Class293() {
      this.I_field_60aabca6 = iIIiIIiII_Class293.Nested1_e06eb3e9.I_field_60aabca6;
      this.i_field_49 = -1;
      this.II_field_49 = 45;
      this.I_field_f2735522 = ItemStack.EMPTY;
      this.i_field_f2735522 = ItemStack.EMPTY;
      this.Ii_field_49 = -1;
      this.ii_field_49 = -1;
      this.III_field_49 = -1;
      this.I_field_a567c40b = new HashMap<>();
      this.II_field_3c05b08c = null;
      this.I_field_3d936f41 = var1 -> {
         if (var1.getPacket() instanceof CooldownUpdateS2CPacket var2 && this.II_field_3c05b08c != null) {
            this.I_field_a567c40b
               .put(this.II_field_3c05b08c, new iIIiIIiII_Class293.Nested1_831c5880(var2.cooldown() / 20.0F, System.currentTimeMillis(), false));
            this.II_field_3c05b08c = null;
         }
      };
      this.i_field_3d936f41 = var1 -> {
         this.ii_method_857ce522();
         if (this.I_field_5a) {
            this.I_method_801dd21f();
         }

         for (Entry var3 : this.I_field_a567c40b.entrySet()) {
            iIIiIIiII_Class293.Nested1_831c5880 var4 = (iIIiIIiII_Class293.Nested1_831c5880)var3.getValue();
            float var5 = this.I_method_ee61a637((Item)var3.getKey());
            if (var5 <= 0.0F && !var4.I_field_5a) {
               var3.setValue(new iIIiIIiII_Class293.Nested1_831c5880(var4.I_field_46, var4.I_field_4a, true));
               RockstarClient.getInstance()
                  .I_method_5cb1af22()
                  .I_method_67864747(
                     new iiiIiIi_Class118(IiIiIIII_Class81.I_method_f25a980a("alerts.cooldown_ready"), new ItemStack((ItemConvertible)var3.getKey()))
                  );
            }
         }

         if ((this.i_method_802c5e03() || I_field_3a9bda27.player.networkHandler.getServerInfo() == null)
            && this.i_field_1242a2ac != null
            && this.i_field_1242a2ac instanceof iIIiiiiII_Class317 var6) {
            this.I_field_49++;
            if (this.I_field_49 == 2) {
               I_field_3a9bda27.doItemUse();
            }

            if (this.I_field_49 == 2) {
               iIIiIiIiI_Class299.iI_method_c617e8c2(var6.I_method_dfe89252(), iIIiIiIiI_Class299.I_method_d0256375().II_method_b9cf08f5());
               iIIiIiIiI_Class299.I_method_4c2ca067(this.i_field_48ddb68c);
               this.i_field_1242a2ac = null;
               this.i_field_48ddb68c = null;
               this.I_field_49 = 0;
            }
         }

         this.i_method_802c5dff();
      };
      this.II_field_3d936f41 = var0 -> {
         if (var0.getPacket() instanceof PlayerInteractItemC2SPacket var1) {
            iiIIiIIii_Class404 var3 = RockstarClient.getInstance().I_method_58785402().i_method_10b2eeb5();
            var0.setPacket(new PlayerInteractItemC2SPacket(var1.getHand(), var1.getSequence(), var3.I_method_14534e0f(), var3.i_method_1461d9ef()));
         }
      };
      RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
   }

   private void I_method_801dd21f() {
      if (I_field_3a9bda27.player != null
         && I_field_3a9bda27.world != null
         && I_field_3a9bda27.interactionManager != null
         && I_field_3a9bda27.player.getItemCooldownManager() != null) {
         if (this.I_field_1242a2ac != null && !(this.I_field_1242a2ac instanceof iIIiiiIii_Class316)) {
         }

         if (this.I_field_60aabca6 == iIIiIIiII_Class293.Nested1_e06eb3e9.i_field_60aabca6) {
            if (this.I_field_1242a2ac instanceof iIIiiiIii_Class316) {
               I_field_3a9bda27.interactionManager.interactItem(I_field_3a9bda27.player, Hand.MAIN_HAND);
               this.I_field_60aabca6 = iIIiIIiII_Class293.Nested1_e06eb3e9.II_field_60aabca6;
            } else if (this.II_method_83ab6926()) {
               I_field_3a9bda27.interactionManager.interactItem(I_field_3a9bda27.player, this.I_method_8be62328());
               this.I_field_60aabca6 = iIIiIIiII_Class293.Nested1_e06eb3e9.II_field_60aabca6;
            }
         } else if (this.I_field_60aabca6 == iIIiIIiII_Class293.Nested1_e06eb3e9.Ii_field_60aabca6) {
            if (this.II_method_83ab6926()) {
               this.I_method_32bf295a(this.II_field_49 == 45 ? Hand.OFF_HAND : Hand.MAIN_HAND);
               if (this.i_field_49 != this.II_field_49) {
                  this.I_method_fbca11cc(this.i_field_49, this.I_field_f2735522, this.i_field_f2735522, true);
                  this.Ii_method_83b9f502();
               }

               this.iI_method_856e5942();
            }
         } else if (this.I_field_60aabca6 == iIIiIIiII_Class293.Nested1_e06eb3e9.II_field_60aabca6) {
            if (this.I_field_1242a2ac instanceof iIIiiiIii_Class316) {
               iIIiIiIiI_Class299.I_method_4c2ca067(this.I_field_48ddb68c);
               this.iI_method_856e5942();
            } else if (this.I_field_1242a2ac instanceof iIIiiiiII_Class317) {
               iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_1242a2ac.I_method_dfe89252(), this.I_method_801dd212());
               this.iI_method_856e5942();
            } else {
               this.iI_method_856e5942();
            }
         } else {
            this.I_field_5a = false;
            this.I_field_60aabca6 = iIIiIIiII_Class293.Nested1_e06eb3e9.I_field_60aabca6;
         }
      } else {
         this.I_field_5a = false;
         this.I_field_60aabca6 = iIIiIIiII_Class293.Nested1_e06eb3e9.I_field_60aabca6;
      }
   }

   public void I_method_ee61a647(Item var1) {
      this.I_method_a4f79a60(var1, var0 -> true, null);
   }

   public void I_method_5bdc8a16(Item var1, Predicate<ItemStack> var2) {
      this.I_method_a4f79a60(var1, var2, null);
   }

   public void I_method_a4f79a60(Item var1, Predicate<ItemStack> var2, String var3) {
      if (I_field_3a9bda27.player != null
         && I_field_3a9bda27.world != null
         && I_field_3a9bda27.interactionManager != null
         && I_field_3a9bda27.currentScreen == null) {
         if (!this.I_field_5a && this.I_field_5f790d9c == null) {
            iIIiiIiII_Class309<iIIiIiIii_Class300> var4 = iIIiiIiIi_Class310.I_method_6a489695()
               .I_method_fdeecb5d(iIIiiIiIi_Class310.i_method_7fde0a75())
               .I_method_fdeecb5d(iIIiiIiIi_Class310.Ii_method_1c02fc38());
            Predicate<ItemStack> var5 = var2x -> var2x != null && !var2x.isEmpty() && var2x.getItem() == var1 && var2.test(var2x);
            iIIiIiIii_Class300 var6 = var4.I_method_77fa4424(var3x -> var5.test(var3x) && this.I_method_fe1af769(var3x, var1));
            if (var6 == null) {
               var6 = var4.I_method_77fa4424(var5);
            }

            iIIiIIiII_Class293.Nested1_831c5860 var7 = var6 == null ? this.I_method_971666c1(var4, var5, var1) : null;
            String var8 = var3 != null && !var3.isBlank() ? var3 : IiiiiIiii_Class248.I_field_a567c40b.getOrDefault(var1, var1.getName().getString());
            if (var8 == null) {
               var8 = var1.getName().getString();
            }

            if (var6 == null && var7 == null) {
               RockstarClient.getInstance()
                  .I_method_5cb1af22()
                  .I_method_20d0f49b(
                     iiiIIII_Class113.i_field_c11fcfcc,
                     IiIiIIII_Class81.I_method_f25a980a("swap.item_not_found"),
                     IiIiIIII_Class81.I_method_1410d1e5("swap.item_required", var8)
                  );
            } else {
               ItemStack var9 = var6 != null ? var6.I_method_7b7e0bb9() : var7.I_method_40cd7c9e();
               if (I_field_3a9bda27.player.getItemCooldownManager().isCoolingDown(var9)) {
                  iIIiIIiII_Class293.Nested1_831c5880 var13 = this.I_field_a567c40b.get(var1);
                  if (var13 != null) {
                     float var14 = Math.max(0.0F, var13.I_field_46 - (float)(System.currentTimeMillis() - var13.I_field_4a) / 1000.0F);
                     if (var14 > 0.01F) {
                        RockstarClient.getInstance()
                           .I_method_5cb1af22()
                           .I_method_67864747(new iiiIiIi_Class118(IiIiIIII_Class81.I_method_1410d1e5("alerts.cooldown", var14), var9));
                     }
                  }
               } else {
                  if (var7 != null) {
                     var6 = this.I_method_3b18d978(var7);
                     if (var6 == null) {
                        RockstarClient.getInstance()
                           .I_method_5cb1af22()
                           .I_method_20d0f49b(
                              iiiIIII_Class113.i_field_c11fcfcc,
                              IiIiIIII_Class81.I_method_f25a980a("swap.bundle_no_space"),
                              IiIiIIII_Class81.I_method_1410d1e5("swap.bundle_no_space.description", var8)
                           );
                        return;
                     }
                  }

                  this.II_field_3c05b08c = var1;
                  this.i_field_5a = this.Ii_method_83b9f506();
                  AssistModule var10 = RockstarClient.getInstance().getModuleManager().getModule(AssistModule.class);
                  if (var10 != null && var10.Iii_method_63fd1a83()) {
                     this.I_method_ff3f6ce7(var6);
                  } else if (this.i_method_802c5e03() && !var6.I_method_7b7e0bb9().isOf(Items.SPLASH_POTION)) {
                     this.i_method_9c587507(var6);
                  } else {
                     this.I_field_3c05b08c = var1;
                     this.I_field_48ddb68c = iIIiIiIiI_Class299.I_method_d0256375();
                     this.I_field_1242a2ac = var6;
                     this.I_field_5a = true;
                     this.I_field_60aabca6 = iIIiIIiII_Class293.Nested1_e06eb3e9.i_field_60aabca6;
                     this.I_field_991c1e8c.I_method_23e11e3f();
                     if (var6 instanceof iIIiiiIii_Class316 var11) {
                        iIIiIiIiI_Class299.I_method_4c2ca067(var11);
                     } else if (var6 instanceof iIIiiiiII_Class317 var12) {
                        iIIiIiIiI_Class299.iI_method_c617e8c2(var12.I_method_dfe89252(), this.I_method_801dd212());
                        this.I_field_60aabca6 = iIIiIIiII_Class293.Nested1_e06eb3e9.i_field_60aabca6;
                     }
                  }
               }
            }
         }
      }
   }

   private iIIiIIiII_Class293.Nested1_831c5860 I_method_971666c1(iIIiiIiII_Class309<iIIiIiIii_Class300> var1, Predicate<ItemStack> var2, Item var3) {
      iIIiIIiII_Class293.Nested1_831c5860 var4 = null;

      for (iIIiIiIii_Class300 var6 : var1.I_method_617d3e68()) {
         BundleContentsComponent var7 = (BundleContentsComponent)var6.I_method_7b7e0bb9().get(DataComponentTypes.BUNDLE_CONTENTS);
         if (var7 != null && !var7.isEmpty()) {
            for (int var8 = 0; var8 < var7.size(); var8++) {
               ItemStack var9 = var7.get(var8);
               if (!var9.contains(DataComponentTypes.BUNDLE_CONTENTS) && var2.test(var9)) {
                  if (this.I_method_fe1af769(var9, var3)) {
                     return new iIIiIIiII_Class293.Nested1_831c5860(var6, var8, var9);
                  }

                  if (var4 == null) {
                     var4 = new iIIiIIiII_Class293.Nested1_831c5860(var6, var8, var9);
                  }
               }
            }
         }
      }

      return var4;
   }

   private iIIiIiIii_Class300 I_method_3b18d978(iIIiIIiII_Class293.Nested1_831c5860 var1) {
      ScreenHandler var2 = I_field_3a9bda27.player.currentScreenHandler;
      if (var2 != null && I_field_3a9bda27.getNetworkHandler() != null && var2.getCursorStack().isEmpty()) {
         iIIiiiiII_Class317 var3 = iIIiiIiIi_Class310.i_method_7fde0a75().I_method_2f5a6715();
         if (var3 == null) {
            return null;
         } else {
            int var4 = var1.I_method_ccba0cb0().I_method_dfe89252();
            ItemStack var5 = var1.I_method_ccba0cb0().I_method_7b7e0bb9();
            this.I_method_9a56089d(var4, var5, -1);
            if (var1.I_method_df55e74d() > 0) {
               this.I_method_9a56089d(var4, var5, var1.I_method_df55e74d());
            }

            this.I_method_f00026bf(var4, 1);
            this.I_method_f00026bf(var3.I_method_dfe89252(), 1);
            if (!var2.getCursorStack().isEmpty()) {
               this.I_method_f00026bf(var4, 0);
            }

            if (!var2.getCursorStack().isEmpty()) {
               this.I_method_f00026bf(var3.I_method_dfe89252(), 0);
            }

            if (var3.I_method_dfe89263()) {
               return null;
            } else {
               this.ii_field_49 = var4;
               this.III_field_49 = var3.I_method_dfe89252();
               this.i_field_3c05b08c = var1.I_method_40cd7c9e().getItem();
               this.IIi_field_49 = 0;
               return var3;
            }
         }
      } else {
         return null;
      }
   }

   private void i_method_802c5dff() {
      if (this.III_field_49 >= 0) {
         if (!this.I_field_5a
            && this.i_field_1242a2ac == null
            && I_field_3a9bda27.currentScreen == null
            && I_field_3a9bda27.player != null
            && I_field_3a9bda27.player.currentScreenHandler == I_field_3a9bda27.player.playerScreenHandler) {
            if (++this.IIi_field_49 >= 5) {
               this.II_method_83ab6922();
               this.ii_field_49 = -1;
               this.III_field_49 = -1;
               this.i_field_3c05b08c = null;
               this.IIi_field_49 = 0;
            }
         } else {
            this.IIi_field_49 = 0;
         }
      }
   }

   private void II_method_83ab6922() {
      ScreenHandler var1 = I_field_3a9bda27.player.currentScreenHandler;
      if (var1 != null && var1.getCursorStack().isEmpty()) {
         if (this.III_field_49 < var1.slots.size() && this.ii_field_49 < var1.slots.size()) {
            ItemStack var2 = var1.getSlot(this.III_field_49).getStack();
            if (!var2.isEmpty() && var2.getItem() == this.i_field_3c05b08c) {
               if (var1.getSlot(this.ii_field_49).getStack().contains(DataComponentTypes.BUNDLE_CONTENTS)) {
                  this.I_method_f00026bf(this.III_field_49, 0);
                  this.I_method_f00026bf(this.ii_field_49, 0);
                  if (!var1.getCursorStack().isEmpty()) {
                     this.I_method_f00026bf(this.III_field_49, 0);
                  }
               }
            }
         }
      }
   }

   private void I_method_9a56089d(int var1, ItemStack var2, int var3) {
      BundleItem.setSelectedStackIndex(var2, var3);
      I_field_3a9bda27.getNetworkHandler().sendPacket(new BundleItemSelectedC2SPacket(var1, var3));
   }

   private void I_method_f00026bf(int var1, int var2) {
      I_field_3a9bda27.interactionManager
         .clickSlot(I_field_3a9bda27.player.currentScreenHandler.syncId, var1, var2, SlotActionType.PICKUP, I_field_3a9bda27.player);
   }

   private void I_method_ff3f6ce7(iIIiIiIii_Class300 var1) {
      if (I_field_3a9bda27.player != null
         && I_field_3a9bda27.world != null
         && I_field_3a9bda27.interactionManager != null
         && I_field_3a9bda27.player.networkHandler != null) {
         if (var1 instanceof iIIiiiIii_Class316 var2) {
            this.I_method_fb6508c7(var2);
            this.iI_method_856e5942();
         } else {
            this.i_field_49 = var1.I_method_dfe89252();
            this.II_field_49 = this.i_field_49 != 45 && this.iI_method_856e5946() ? 36 + I_field_3a9bda27.player.getInventory().selectedSlot : 45;
            this.I_field_f2735522 = var1.I_method_7b7e0bb9().copy();
            this.i_field_f2735522 = this.I_method_f762af74(this.II_field_49).copy();
            this.I_field_1242a2ac = var1;
            this.I_field_5a = true;
            this.I_field_60aabca6 = iIIiIIiII_Class293.Nested1_e06eb3e9.Ii_field_60aabca6;
            this.I_field_991c1e8c.I_method_23e11e3f();
            if (this.i_field_49 != this.II_field_49) {
               this.I_method_fbca11cc(this.i_field_49, this.i_field_f2735522, this.I_field_f2735522, false);
            }
         }
      }
   }

   private ItemStack I_method_f762af74(int var1) {
      ScreenHandler var2 = I_field_3a9bda27.player.currentScreenHandler;
      return var2 != null && var1 >= 0 && var1 < var2.slots.size() ? var2.getSlot(var1).getStack() : ItemStack.EMPTY;
   }

   private void I_method_fb6508c7(iIIiiiIii_Class316 var1) {
      int var2 = I_field_3a9bda27.player.getInventory().selectedSlot;
      iiIIiIIii_Class404 var3 = RockstarClient.getInstance().I_method_58785402().i_method_10b2eeb5();
      if (var1.II_method_b9cf08f5() != var2) {
         I_field_3a9bda27.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(var1.II_method_b9cf08f5()));
      }

      I_field_3a9bda27.interactionManager
         .sendSequencedPacket(
            I_field_3a9bda27.world, var1x -> new PlayerInteractItemC2SPacket(Hand.MAIN_HAND, var1x, var3.I_method_14534e0f(), var3.i_method_1461d9ef())
         );
      if (var1.II_method_b9cf08f5() != var2) {
         I_field_3a9bda27.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(var2));
      }
   }

   private void I_method_32bf295a(Hand var1) {
      iiIIiIIii_Class404 var2 = RockstarClient.getInstance().I_method_58785402().i_method_10b2eeb5();
      I_field_3a9bda27.interactionManager
         .sendSequencedPacket(I_field_3a9bda27.world, var2x -> new PlayerInteractItemC2SPacket(var1, var2x, var2.I_method_14534e0f(), var2.i_method_1461d9ef()));
   }

   private void I_method_fbca11cc(int var1, ItemStack var2, ItemStack var3, boolean var4) {
      ScreenHandler var5 = I_field_3a9bda27.player.currentScreenHandler;
      Int2ObjectOpenHashMap var6 = new Int2ObjectOpenHashMap();
      var6.put(var1, var2.copy());
      var6.put(this.II_field_49, var3.copy());
      ClickSlotC2SPacket var7 = new ClickSlotC2SPacket(
         var5.syncId, var5.getRevision(), var1, this.II_field_49 == 45 ? 40 : this.II_field_49 - 36, SlotActionType.SWAP, ItemStack.EMPTY, var6
      );
      if (var4) {
         this.I_method_b73baaea(var7);
      } else {
         I_field_3a9bda27.player.networkHandler.sendPacket(var7);
      }
   }

   private void I_method_b73baaea(ClickSlotC2SPacket var1) {
      GuiMoveModule var2 = RockstarClient.getInstance().getModuleManager().getModule(GuiMoveModule.class);
      boolean var3 = var2 != null && var2.I_field_5a;
      if (var2 != null) {
         var2.I_field_5a = true;
      }

      try {
         I_field_3a9bda27.player.networkHandler.sendPacket(var1);
      } finally {
         if (var2 != null) {
            var2.I_field_5a = var3;
         }
      }
   }

   private void Ii_method_83b9f502() {
      ScreenHandler var1 = I_field_3a9bda27.player.currentScreenHandler;
      if (var1 != null && this.i_field_49 >= 0 && this.i_field_49 < var1.slots.size() && this.II_field_49 >= 0 && this.II_field_49 < var1.slots.size()) {
         var1.getSlot(this.i_field_49).setStack(this.I_field_f2735522.copy());
         var1.getSlot(this.II_field_49).setStack(this.i_field_f2735522.copy());
      }
   }

   private boolean I_method_fe1af769(ItemStack var1, Item var2) {
      if (var1 != null && !var1.isEmpty()) {
         if (var1.getItem() != var2) {
            return false;
         } else {
            IiiiiIiii_Class248.Nested1_95187080 var3 = IiiiiIiii_Class248.I_method_7613ca72(var1);
            return var3 != null && var3.ii_method_e498f76b();
         }
      } else {
         return false;
      }
   }

   private void iI_method_856e5942() {
      this.I_field_5a = false;
      this.I_field_60aabca6 = iIIiIIiII_Class293.Nested1_e06eb3e9.I_field_60aabca6;
      this.I_field_3c05b08c = null;
      this.I_field_48ddb68c = null;
      this.I_field_1242a2ac = null;
      this.i_field_49 = -1;
      this.II_field_49 = 45;
      this.I_field_f2735522 = ItemStack.EMPTY;
      this.i_field_f2735522 = ItemStack.EMPTY;
      this.i_field_5a = false;
   }

   public boolean I_method_c950d12f(Object var1, iIIiiiIii_Class316 var2) {
      if (var1 == null || var2 == null || I_field_3a9bda27.player == null || I_field_3a9bda27.getNetworkHandler() == null || this.I_field_5a) {
         return false;
      } else if (this.I_field_5f790d9c == null) {
         this.I_field_5f790d9c = var1;
         this.II_field_48ddb68c = iIIiIiIiI_Class299.I_method_d0256375();
         this.Ii_field_49 = var2.II_method_b9cf08f5();
         this.II_field_5a = false;
         this.I_method_839ce4c4(var2.II_method_b9cf08f5());
         return true;
      } else {
         return this.I_field_5f790d9c == var1 && this.Ii_field_49 == var2.II_method_b9cf08f5();
      }
   }

   public boolean I_method_73f3183f(Object var1) {
      return this.I_field_5f790d9c == var1;
   }

   public void I_method_73f3183b(Object var1) {
      if (this.I_field_5f790d9c == var1) {
         this.II_field_5a = true;
      }
   }

   public void i_method_44aa6c1b(Object var1) {
      if (this.I_field_5f790d9c == var1) {
         this.III_method_f1d0b27f();
      }
   }

   private void ii_method_857ce522() {
      if (this.I_field_5f790d9c != null) {
         if (I_field_3a9bda27.player == null || I_field_3a9bda27.getNetworkHandler() == null) {
            this.IIi_method_f1df3e5f();
         } else if (this.II_field_5a) {
            this.III_method_f1d0b27f();
         } else {
            if (I_field_3a9bda27.player.getInventory().selectedSlot != this.Ii_field_49) {
               this.I_method_839ce4c4(this.Ii_field_49);
            }
         }
      }
   }

   private void III_method_f1d0b27f() {
      if (this.II_field_48ddb68c != null && I_field_3a9bda27.player != null && I_field_3a9bda27.getNetworkHandler() != null) {
         this.I_method_839ce4c4(this.II_field_48ddb68c.II_method_b9cf08f5());
      }

      this.IIi_method_f1df3e5f();
   }

   private void IIi_method_f1df3e5f() {
      this.I_field_5f790d9c = null;
      this.II_field_48ddb68c = null;
      this.Ii_field_49 = -1;
      this.II_field_5a = false;
   }

   private void I_method_839ce4c4(int var1) {
      I_field_3a9bda27.player.getInventory().selectedSlot = var1;
      I_field_3a9bda27.getNetworkHandler().sendPacket(new UpdateSelectedSlotC2SPacket(var1));
   }

   private void i_method_9c587507(iIIiIiIii_Class300 var1) {
      iIIiiiIii_Class316 var2 = iIIiIiIiI_Class299.I_method_d0256375();
      if (var1 instanceof iIIiiiIii_Class316 var4) {
         iIIiIiIiI_Class299.I_method_4c2ca067(var4);
         I_field_3a9bda27.doItemUse();
         iIIiIiIiI_Class299.I_method_4c2ca067(var2);
      } else {
         if (var1 instanceof iIIiiiiII_Class317 var3) {
            iIIiIiIiI_Class299.iI_method_c617e8c2(var3.I_method_dfe89252(), iIIiIiIiI_Class299.I_method_d0256375().II_method_b9cf08f5());
            this.i_field_1242a2ac = var3;
            this.i_field_48ddb68c = var2;
            this.I_field_49 = 0;
         }
      }
   }

   public float I_method_ee61a637(Item var1) {
      iIIiIIiII_Class293.Nested1_831c5880 var2 = this.I_field_a567c40b.get(var1);
      if (var2 == null) {
         return 0.0F;
      } else {
         float var3 = var2.I_field_46 - (float)(System.currentTimeMillis() - var2.I_field_4a) / 1000.0F;
         return Math.max(0.0F, var3);
      }
   }

   public Set<Item> I_method_ddcd0bce() {
      return this.I_field_a567c40b.keySet();
   }

   private boolean i_method_802c5e03() {
      GuiMoveModule var1 = RockstarClient.getInstance().getModuleManager().getModule(GuiMoveModule.class);
      return iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c) && var1 != null && var1.IiI_method_d4c01b03();
   }

   private boolean II_method_83ab6926() {
      GuiMoveModule var1 = RockstarClient.getInstance().getModuleManager().getModule(GuiMoveModule.class);
      if (var1 == null) {
         return true;
      } else {
         return var1.Iii_method_d4cea6e3()
            ? !var1.iIi_method_9a6caa3() && !var1.IIiI_method_8e7a1886() && var1.iII_method_9983ec3()
            : var1.I_method_eb75c1e8().isEmpty() && !var1.IIiI_method_8e7a1886();
      }
   }

   private boolean Ii_method_83b9f506() {
      if (iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c)) {
         return false;
      } else {
         AssistModule var1 = RockstarClient.getInstance().getModuleManager().getModule(AssistModule.class);
         return var1 != null && var1.IiI_method_63ee8ea3() && !this.iI_method_856e5946();
      }
   }

   private boolean iI_method_856e5946() {
      AutoTotemModule var1 = RockstarClient.getInstance().getModuleManager().getModule(AutoTotemModule.class);
      if (var1 != null && var1.IiI_method_6efa9e10()) {
         return true;
      } else {
         AutoSwapModule var2 = RockstarClient.getInstance().getModuleManager().getModule(AutoSwapModule.class);
         return var2 != null && var2.IiI_method_344f5ec3();
      }
   }

   private Hand I_method_8be62328() {
      if (this.I_field_1242a2ac instanceof iIIiiiiIi_Class318) {
         return Hand.OFF_HAND;
      } else {
         return this.i_field_5a ? Hand.OFF_HAND : Hand.MAIN_HAND;
      }
   }

   private int I_method_801dd212() {
      if (this.i_field_5a) {
         return 40;
      } else {
         return this.I_field_60aabca6 == iIIiIIiII_Class293.Nested1_e06eb3e9.II_field_60aabca6
            ? this.I_field_48ddb68c.II_method_b9cf08f5()
            : iIIiIiIiI_Class299.I_method_d0256375().II_method_b9cf08f5();
      }
   }

   @Generated
   public boolean I_method_801dd223() {
      return this.I_field_5a;
   }

   static final class Nested1_831c5860 {
      private final iIIiIiIii_Class300 I_field_1242a2ac;
      private final int I_field_49;
      private final ItemStack I_field_f2735522;

      Nested1_831c5860(iIIiIiIii_Class300 var1, int var2, ItemStack var3) {
         this.I_field_1242a2ac = var1;
         this.I_field_49 = var2;
         this.I_field_f2735522 = var3;
      }

      @Override
      public final String toString() {
         return "Nested1_831c5860[slot=" + this.I_field_1242a2ac + ", index=" + this.I_field_49 + ", stack=" + this.I_field_f2735522 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_1242a2ac);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_f2735522);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIIiIIiII_Class293.Nested1_831c5860 other = (iIIiIIiII_Class293.Nested1_831c5860) var1;
         return java.util.Objects.equals(this.I_field_1242a2ac, other.I_field_1242a2ac)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.I_field_f2735522, other.I_field_f2735522);
      }

      public iIIiIiIii_Class300 I_method_ccba0cb0() {
         return this.I_field_1242a2ac;
      }

      public int I_method_df55e74d() {
         return this.I_field_49;
      }

      public ItemStack I_method_40cd7c9e() {
         return this.I_field_f2735522;
      }
   }

   static final class Nested1_831c5880 {
      final float I_field_46;
      final long I_field_4a;
      final boolean I_field_5a;

      Nested1_831c5880(float var1, long var2, boolean var4) {
         this.I_field_46 = var1;
         this.I_field_4a = var2;
         this.I_field_5a = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_831c5880[durationSeconds=" + this.I_field_46 + ", startTime=" + this.I_field_4a + ", notified=" + this.I_field_5a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_4a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIIiIIiII_Class293.Nested1_831c5880 other = (iIIiIIiII_Class293.Nested1_831c5880) var1;
         return java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.I_field_4a, other.I_field_4a)
            && java.util.Objects.equals(this.I_field_5a, other.I_field_5a);
      }

      public float I_method_15f0fb2a() {
         return this.I_field_46;
      }

      public long I_method_15f0fb2e() {
         return this.I_field_4a;
      }

      public boolean I_method_15f0fb3e() {
         return this.I_field_5a;
      }
   }

   static enum Nested1_e06eb3e9 {
      I_field_60aabca6,
      i_field_60aabca6,
      II_field_60aabca6,
      Ii_field_60aabca6;
   }
}
