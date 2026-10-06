package rockstar.client;

import java.util.function.Predicate;
import net.minecraft.block.AnvilBlock;
import net.minecraft.client.gui.screen.ingame.AnvilScreen;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PotionItem;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.network.packet.c2s.play.RenameItemC2SPacket;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.screen.AnvilScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

public class IIIiiiiiI_Class63 extends IIIiiiIii_Class60 {
   private final ModeSetting I_field_bbe33e6c;
   private final ModeSetting.Nested1_42765c60 I_field_500d0627;
   private final ModeSetting.Nested1_42765c60 i_field_500d0627;
   private final ModeSetting.Nested1_42765c60 II_field_500d0627;
   private final BooleanSetting I_field_ba20ca4c;
   private final BooleanSetting i_field_ba20ca4c;
   private final SliderSetting I_field_73178e8c;
   private static final int I_field_49 = 50;
   private static final int i_field_49 = 5;
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private final iiIiIIiii_Class424 i_field_991c1e8c = new iiIiIIiii_Class424();
   private final iiIiIIiii_Class424 II_field_991c1e8c = new iiIiIIiii_Class424();
   private String I_field_523beb0a = "";
   private boolean I_field_5a;
   private int II_field_49;

   public IIIiiiiiI_Class63(AutoFarmModule var1, ModeSetting var2) {
      super(var1, var2, "modules.settings.auto_farm.modes.potion_combiner");
      this.I_field_bbe33e6c = new ModeSetting(var1, "modules.settings.potion_combiner.potions", () -> !this.isSelected());
      this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.potion_combiner.potion.strength").select();
      this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.potion_combiner.potion.speed");
      this.II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.potion_combiner.potion.strength_speed");
      this.I_field_ba20ca4c = new BooleanSetting(var1, "modules.settings.potion_combiner.auto_open", () -> !this.isSelected()).I_method_decd82b5();
      this.i_field_ba20ca4c = new BooleanSetting(var1, "modules.settings.potion_combiner.auto_exp", () -> !this.isSelected());
      this.I_field_73178e8c = new SliderSetting(
            var1, "modules.settings.potion_combiner.refill_to", () -> !this.isSelected() || !this.i_field_ba20ca4c.i_method_9b12da03()
         )
         .I_method_c8c9a7d7(5.0F)
         .i_method_65e2aff7(100.0F)
         .II_method_b0f56334(1.0F)
         .Ii_method_4e0e6b54(40.0F);
   }

   @Override
   public void i_method_a103c9ff() {
      this.I_field_523beb0a = "";
      this.I_field_5a = false;
      this.II_field_49 = 0;
   }

   @Override
   public void Ii_method_7e704cc2() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null && I_field_3a9bda27.interactionManager != null) {
         this.II_method_6a2838e2();
         this.ii_method_6bf9b4e2();
         this.III_method_daeddabf();
      }
   }

   @Override
   public IIiIIIIIi_Class66 I_method_57286715() {
      if (this.I_field_5a) {
         return IIiIIIIIi_Class66.iII_field_e6af4a4c;
      } else {
         return I_field_3a9bda27.currentScreen instanceof AnvilScreen ? IIiIIIIIi_Class66.Iii_field_e6af4a4c : IIiIIIIIi_Class66.I_field_e6af4a4c;
      }
   }

   @Override
   public IIiIIIiII_Class69 I_method_5736ef15() {
      return IIiIIIiII_Class69.i_field_e6bdd24c;
   }

   @Override
   public ItemStack I_method_907017b9() {
      return new ItemStack(Items.ANVIL);
   }

   private void II_method_6a2838e2() {
      if (!this.I_field_5a) {
         if (I_field_3a9bda27.currentScreen instanceof AnvilScreen var1) {
            AnvilScreenHandler var4 = (AnvilScreenHandler)var1.getScreenHandler();
            this.I_method_9357ce81(var4);
            if (this.I_method_9357ce85(var4)) {
               int var3 = var4.getLevelCost();
               this.II_field_49 = var3;
               this.IIi_method_dafc669f();
               if (var3 > 0 && I_field_3a9bda27.player.experienceLevel >= var3 && !var4.getSlot(2).getStack().isEmpty()) {
                  this.i_method_e7701ea1(var4);
               }
            }
         } else {
            this.I_field_523beb0a = "";
         }
      }
   }

   private void ii_method_6bf9b4e2() {
      if (this.I_field_ba20ca4c.i_method_9b12da03()) {
         if (!this.I_field_5a) {
            if (I_field_3a9bda27.currentScreen == null) {
               if (this.II_field_991c1e8c.I_method_58432069(500L)) {
                  if (this.I_method_f2e80a63()) {
                     BlockPos var1 = this.I_method_d4e31dd1();
                     if (var1 != null) {
                        Vec3d var2 = new Vec3d(var1.getX() + 0.5, var1.getY() + 0.5, var1.getZ() + 0.5);
                        BlockHitResult var3 = new BlockHitResult(var2, Direction.UP, var1, false);
                        I_field_3a9bda27.interactionManager.interactBlock(I_field_3a9bda27.player, Hand.MAIN_HAND, var3);
                        this.II_field_991c1e8c.I_method_23e11e3f();
                     }
                  }
               }
            }
         }
      }
   }

   private boolean I_method_f2e80a63() {
      if (this.II_field_500d0627.isSelected()) {
         boolean var5 = false;
         boolean var2 = false;

         for (int var3 = 0; var3 < I_field_3a9bda27.player.getInventory().size(); var3++) {
            ItemStack var4 = I_field_3a9bda27.player.getInventory().getStack(var3);
            if (this.I_method_701cefa6(var4, 0)) {
               var5 = true;
            }

            if (this.I_method_701cefa6(var4, 1)) {
               var2 = true;
            }

            if (var5 && var2) {
               return true;
            }
         }

         return false;
      } else {
         for (int var1 = 0; var1 < I_field_3a9bda27.player.getInventory().size(); var1++) {
            if (this.I_method_701cefa6(I_field_3a9bda27.player.getInventory().getStack(var1), 0)) {
               return true;
            }
         }

         return false;
      }
   }

   private BlockPos I_method_d4e31dd1() {
      BlockPos var1 = BlockPos.ofFloored(I_field_3a9bda27.player.getPos());
      BlockPos var2 = null;
      double var3 = Double.MAX_VALUE;
      double var5 = I_field_3a9bda27.player.getBlockInteractionRange();

      for (int var7 = -5; var7 <= 5; var7++) {
         for (int var8 = -5; var8 <= 5; var8++) {
            for (int var9 = -5; var9 <= 5; var9++) {
               BlockPos var10 = var1.add(var7, var8, var9);
               if (I_field_3a9bda27.world.getBlockState(var10).getBlock() instanceof AnvilBlock) {
                  double var11 = I_field_3a9bda27.player.getEyePos().squaredDistanceTo(var10.getX() + 0.5, var10.getY() + 0.5, var10.getZ() + 0.5);
                  if (!(var11 > var5 * var5) && var11 < var3) {
                     var3 = var11;
                     var2 = var10;
                  }
               }
            }
         }
      }

      return var2;
   }

   private void III_method_daeddabf() {
      if (!this.i_field_ba20ca4c.i_method_9b12da03()) {
         this.I_field_5a = false;
      } else {
         int var1 = Math.max((int)this.I_field_73178e8c.Ii_method_a20abcd2(), this.II_field_49);
         int var2 = Math.max(5, this.II_field_49);
         if (!this.I_field_5a && I_field_3a9bda27.player.experienceLevel < var2 && this.I_method_e1abc375() != null) {
            this.I_field_5a = true;
         }

         if (this.I_field_5a) {
            if (I_field_3a9bda27.currentScreen instanceof AnvilScreen) {
               I_field_3a9bda27.player.closeHandledScreen();
            } else if (I_field_3a9bda27.player.getMainHandStack().getItem() != Items.EXPERIENCE_BOTTLE) {
               iIIiIiIii_Class300 var3 = this.I_method_e1abc375();
               if (var3 == null) {
                  this.I_field_5a = false;
               } else {
                  int var4 = I_field_3a9bda27.player.getInventory().selectedSlot;
                  if (var3 instanceof iIIiiiIii_Class316 var5) {
                     if (var5.II_method_b9cf08f5() != var4) {
                        iIIiIiIiI_Class299.i_method_8225b484(var5.II_method_b9cf08f5());
                     }
                  } else {
                     iIIiIiIiI_Class299.iI_method_c617e8c2(var3.I_method_dfe89252(), var4);
                  }
               }
            } else {
               RockstarClient.getInstance()
                  .I_method_58785402()
                  .I_method_1acbf705(
                     new iiIIiIIii_Class404(I_field_3a9bda27.player.getYaw(), 87.0F),
                     iiIIiIIIi_Class402.i_field_32e0c64c,
                     180.0F,
                     180.0F,
                     180.0F,
                     iiIIiIiiI_Class407.i_field_32efc66c
                  );
               if (this.i_field_991c1e8c.I_method_58432069(100L)) {
                  I_field_3a9bda27.interactionManager
                     .sendSequencedPacket(
                        I_field_3a9bda27.world, var0 -> new PlayerInteractItemC2SPacket(Hand.MAIN_HAND, var0, I_field_3a9bda27.player.getYaw(), 87.0F)
                     );
                  I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
                  this.i_field_991c1e8c.I_method_23e11e3f();
                  if (I_field_3a9bda27.player.experienceLevel >= var1) {
                     this.I_field_5a = false;
                  }
               }
            }
         }
      }
   }

   private boolean I_method_9357ce85(AnvilScreenHandler var1) {
      return this.I_method_701cefa6(var1.getSlot(0).getStack(), 0) && this.I_method_701cefa6(var1.getSlot(1).getStack(), 1);
   }

   private void I_method_9357ce81(AnvilScreenHandler var1) {
      if (this.I_field_991c1e8c.I_method_58432069(300L)) {
         for (int var2 = 0; var2 < 2; var2++) {
            if (!this.I_method_701cefa6(var1.getSlot(var2).getStack(), var2)) {
               if (!var1.getSlot(var2).getStack().isEmpty()) {
                  I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var2, 0, SlotActionType.QUICK_MOVE, I_field_3a9bda27.player);
                  this.I_field_991c1e8c.I_method_23e11e3f();
                  return;
               }

               int var3 = this.I_method_8e571b7(var1, var2);
               if (var3 == -1) {
                  return;
               }

               this.I_method_13c939bf(var1, var3, var2);
               this.I_field_991c1e8c.I_method_23e11e3f();
               return;
            }
         }
      }
   }

   private int I_method_8e571b7(ScreenHandler var1, int var2) {
      for (int var3 = 3; var3 < var1.slots.size(); var3++) {
         ItemStack var4 = var1.getSlot(var3).getStack();
         if (this.I_method_701cefa6(var4, var2)) {
            return var3;
         }
      }

      return -1;
   }

   private void I_method_13c939bf(ScreenHandler var1, int var2, int var3) {
      I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var2, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
      I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var3, 1, SlotActionType.PICKUP, I_field_3a9bda27.player);
      if (!I_field_3a9bda27.player.currentScreenHandler.getCursorStack().isEmpty()) {
         I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var2, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
      }
   }

   private void i_method_e7701ea1(AnvilScreenHandler var1) {
      if (this.I_field_991c1e8c.I_method_58432069(120L)) {
         if (!var1.getSlot(2).getStack().isEmpty()) {
            int var2 = Math.max(1, var1.getSlot(2).getStack().getCount());
            I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, 2, 0, SlotActionType.QUICK_MOVE, I_field_3a9bda27.player);
            this.I_method_18285755().I_method_95f37ca4(var2);
            this.I_field_523beb0a = "";
            this.I_field_991c1e8c.I_method_23e11e3f();
         }
      }
   }

   private void IIi_method_dafc669f() {
      if (this.I_field_523beb0a.length() >= 50) {
         this.I_field_523beb0a = "";
      }

      this.I_field_523beb0a = this.I_field_523beb0a + "!";
      if (I_field_3a9bda27.getNetworkHandler() != null) {
         I_field_3a9bda27.getNetworkHandler().sendPacket(new RenameItemC2SPacket(this.I_field_523beb0a));
      }
   }

   private boolean I_method_701cefa6(ItemStack var1, int var2) {
      if (!var1.isEmpty() && var1.getItem() instanceof PotionItem) {
         for (StatusEffectInstance var4 : iIIIIIiII_Class261.I_method_2d41c106(var1)) {
            RegistryEntry var5 = var4.getEffectType();
            int var6 = var4.getAmplifier();
            if (this.II_field_500d0627.isSelected()) {
               if (var6 == 2) {
                  if (var2 == 0 && var5 == StatusEffects.STRENGTH) {
                     return true;
                  }

                  if (var2 == 1 && var5 == StatusEffects.SPEED) {
                     return true;
                  }
               }
            } else if (var6 < 2) {
               if (this.I_field_500d0627.isSelected() && var5 == StatusEffects.STRENGTH) {
                  return true;
               }

               if (this.i_field_500d0627.isSelected() && var5 == StatusEffects.SPEED) {
                  return true;
               }
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private iIIiIiIii_Class300 I_method_e1abc375() {
      Predicate var1 = var0 -> ((net.minecraft.item.ItemStack)var0).getItem() == Items.EXPERIENCE_BOTTLE;
      iIIiIiIii_Class300 var2 = iIIiiIiIi_Class310.I_method_6a489695().I_method_77fa4424(var1);
      return (iIIiIiIii_Class300)(var2 != null ? var2 : iIIiiIiIi_Class310.i_method_7fde0a75().I_method_77fa4424(var1));
   }
}
