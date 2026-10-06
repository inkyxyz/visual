package rockstar.client;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import net.minecraft.block.entity.BrewingStandBlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.client.gui.screen.ingame.BrewingStandScreen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.screen.BrewingStandScreenHandler;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import pyrock.events.player.ClientPlayerTickEvent;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Auto Brew",
   category = ModuleCategory.PLAYER,
   III_method_a89e5834 = "modules.descriptions.auto_brew"
)
public class AutoBrewModule extends Module {
   private ModeSetting I_field_bbe33e6c;
   private ModeSetting.Nested1_42765c60 I_field_500d0627;
   private ModeSetting.Nested1_42765c60 i_field_500d0627;
   private ModeSetting.Nested1_42765c60 II_field_500d0627;
   private ModeSetting.Nested1_42765c60 Ii_field_500d0627;
   private BooleanSetting I_field_ba20ca4c;
   private SliderSetting I_field_73178e8c;
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private AutoBrewModule.Nested1_bc0ef440 I_field_9876a47;
   private final iiIiIIiii_Class424 i_field_991c1e8c;
   private BrewingStandBlockEntity I_field_c786becb;
   private ChestBlockEntity I_field_37892422;
   private final List<BlockPos> I_field_7865b31;
   private List<BrewingStandBlockEntity> i_field_7865b31;
   private static final Item[] I_field_e4463c91 = new Item[]{
      Items.NETHER_WART,
      Items.BLAZE_POWDER,
      Items.SUGAR,
      Items.MAGMA_CREAM,
      Items.GLOWSTONE_DUST,
      Items.REDSTONE,
      Items.GOLDEN_CARROT,
      Items.FERMENTED_SPIDER_EYE
   };
   private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41;

   public AutoBrewModule() {
      this.I_field_9876a47 = AutoBrewModule.Nested1_bc0ef440.I_field_9876a47;
      this.i_field_991c1e8c = new iiIiIIiii_Class424();
      this.I_field_7865b31 = new ArrayList<>();
      this.i_field_7865b31 = new ArrayList<>();
      this.I_field_3d936f41 = var1 -> {
         switch (this.I_field_9876a47) {
            case I_field_9876a47:
               this.iIi_method_b42e225f();
               break;
            case i_field_9876a47:
               this.Iii_method_7f55fe9f();
               break;
            case II_field_9876a47:
               this.iII_method_b41f967f();
               break;
            case Ii_field_9876a47:
               this.iiI_method_b5e2869f();
               break;
            case iI_field_9876a47:
               this.iii_method_b5f1127f();
         }
      };
      this.IiI_method_7f4772bf();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_7f4772bf() {
      this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.auto_brew.brew");
      this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.auto_brew.potion.strength").select();
      this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.auto_brew.potion.speed");
      this.II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.auto_brew.potion.fire_resistance");
      this.Ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.auto_brew.potion.invisibility");
      this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.auto_brew.enhance", () -> !this.Ii_field_500d0627.isSelected());
      this.I_field_73178e8c = new SliderSetting(this, "modules.settings.auto_brew.delay", "modules.settings.auto_brew.delay.description")
         .II_method_b0f56334(10.0F)
         .I_method_c8c9a7d7(100.0F)
         .i_method_65e2aff7(1000.0F)
         .Ii_method_4e0e6b54(100.0F);
   }

   private void Iii_method_7f55fe9f() {
      if (I_field_3a9bda27.currentScreen instanceof BrewingStandScreen) {
         this.I_field_9876a47 = AutoBrewModule.Nested1_bc0ef440.II_field_9876a47;
      } else {
         if (this.i_field_991c1e8c.I_method_58432069(500L)) {
            BlockPos var1 = this.I_field_c786becb.getPos();
            Vec3d var2 = new Vec3d(var1.getX() + 0.5, var1.getY() + 0.5, var1.getZ() + 0.5);
            BlockHitResult var3 = new BlockHitResult(var2, Direction.UP, var1, false);
            I_field_3a9bda27.interactionManager.interactBlock(I_field_3a9bda27.player, Hand.MAIN_HAND, var3);
            this.i_field_991c1e8c.I_method_23e11e3f();
         }
      }
   }

   private void iII_method_b41f967f() {
      if (!(I_field_3a9bda27.player.currentScreenHandler instanceof BrewingStandScreenHandler var1)) {
         this.I_field_9876a47 = AutoBrewModule.Nested1_bc0ef440.I_field_9876a47;
      } else if (var1.getFuel() <= 0 || var1.getSlot(3).getStack().getItem() == Items.AIR) {
         if (var1.getSlot(4).getStack().getItem() == Items.AIR && var1.getFuel() == 0) {
            if (this.I_method_ad95b21a(Items.BLAZE_POWDER) == -1) {
               return;
            }

            this.i_method_1ab6799c(Items.BLAZE_POWDER, 4);
         }

         for (int var3 = 0; var3 < 3; var3++) {
            if (var1.getSlot(var3).getStack().getItem() == Items.AIR) {
               if (this.I_method_ba2001a8(var1) == -1) {
                  return;
               }

               iIIiIiIiI_Class299.I_method_8062c464(this.I_method_ba2001a8(var1));
            }
         }

         if (var1.getSlot(3).getStack().getItem() == Items.AIR) {
            if (this.I_method_d4781675(var1, (Potion)Potions.WATER.value())) {
               if (this.I_method_ad95b21a(Items.NETHER_WART) == -1) {
                  RockstarClient.getInstance()
                     .I_method_5cb1af22()
                     .I_method_20d0f49b(
                        iiiIIII_Class113.i_field_c11fcfcc,
                        IiIiIIII_Class81.I_method_f25a980a("autobrew.item_not_found"),
                        IiIiIIII_Class81.I_method_1410d1e5("autobrew.need_item", Items.NETHER_WART.getName().getString())
                     );
               }

               this.I_method_52105bc(Items.NETHER_WART, 3);
            }

            if (this.I_field_500d0627.isSelected() && this.I_method_d4781675(var1, (Potion)Potions.AWKWARD.value())) {
               this.I_method_52105bc(Items.BLAZE_POWDER, 3);
            } else if (this.i_field_500d0627.isSelected() && this.I_method_d4781675(var1, (Potion)Potions.AWKWARD.value())) {
               this.I_method_52105bc(Items.SUGAR, 3);
            } else if (this.II_field_500d0627.isSelected() && this.I_method_d4781675(var1, (Potion)Potions.AWKWARD.value())) {
               this.I_method_52105bc(Items.MAGMA_CREAM, 3);
            } else if (this.Ii_field_500d0627.isSelected() && this.I_method_d4781675(var1, (Potion)Potions.AWKWARD.value())) {
               this.I_method_52105bc(Items.GOLDEN_CARROT, 3);
            }

            if (this.I_method_d4781675(var1, (Potion)Potions.STRENGTH.value()) || this.I_method_d4781675(var1, (Potion)Potions.SWIFTNESS.value())) {
               this.I_method_52105bc(Items.GLOWSTONE_DUST, 3);
            }

            if (this.I_method_d4781675(var1, (Potion)Potions.FIRE_RESISTANCE.value())) {
               this.I_method_52105bc(Items.REDSTONE, 3);
            }

            if (this.Ii_field_500d0627.isSelected() && this.I_method_d4781675(var1, (Potion)Potions.NIGHT_VISION.value())) {
               this.I_method_52105bc(Items.FERMENTED_SPIDER_EYE, 3);
            }

            if (this.Ii_field_500d0627.isSelected()
               && this.I_method_d4781675(var1, (Potion)Potions.INVISIBILITY.value())
               && this.I_field_ba20ca4c.i_method_9b12da03()) {
               this.I_method_52105bc(Items.REDSTONE, 3);
            }

            if (this.I_method_d4781675(var1, (Potion)Potions.STRONG_STRENGTH.value())
               || this.I_method_d4781675(var1, (Potion)Potions.STRONG_SWIFTNESS.value())
               || this.I_method_d4781675(var1, (Potion)Potions.LONG_FIRE_RESISTANCE.value())
               || this.Ii_field_500d0627.isSelected() && this.I_method_d4781675(var1, (Potion)Potions.INVISIBILITY.value())
               || this.Ii_field_500d0627.isSelected()
                  && this.I_method_d4781675(var1, (Potion)Potions.LONG_INVISIBILITY.value())
                  && this.I_field_ba20ca4c.i_method_9b12da03()) {
               this.I_method_ba2001b5(var1);
               this.I_field_9876a47 = AutoBrewModule.Nested1_bc0ef440.Ii_field_9876a47;
               this.i_field_991c1e8c.I_method_23e11e3f();
            }
         }
      }
   }

   private void iIi_method_b42e225f() {
      if (this.i_field_991c1e8c.I_method_58432069(1000L)) {
         if (this.i_field_7865b31.isEmpty()) {
            this.i_field_7865b31 = this.I_method_9a2b0228();
         }

         if (!this.i_field_7865b31.isEmpty()) {
            this.I_field_c786becb = this.i_field_7865b31.removeFirst();
            this.I_field_9876a47 = AutoBrewModule.Nested1_bc0ef440.i_field_9876a47;
            this.i_field_991c1e8c.I_method_23e11e3f();
         }
      }
   }

   private void I_method_52105bc(Item var1, int var2) {
      if (this.I_method_ad95b21a(var1) == -1) {
         RockstarClient.getInstance()
            .I_method_5cb1af22()
            .I_method_20d0f49b(
               iiiIIII_Class113.i_field_c11fcfcc,
               IiIiIIII_Class81.I_method_f25a980a("autobrew.item_not_found"),
               IiIiIIII_Class81.I_method_1410d1e5("autobrew.need_item", var1.getName().getString())
            );
         this.toggle();
      } else {
         this.i_method_1ab6799c(var1, var2);
         I_field_3a9bda27.player.closeHandledScreen();
      }
   }

   private void iiI_method_b5e2869f() {
      if (I_field_3a9bda27.player.currentScreenHandler instanceof BrewingStandScreenHandler) {
         if (this.i_field_991c1e8c.I_method_58432069(200L)) {
            I_field_3a9bda27.player.closeHandledScreen();
            this.i_field_991c1e8c.I_method_23e11e3f();
         }
      } else {
         if (this.I_field_37892422 == null) {
            List var1 = this.i_method_4f773a48();
            if (var1.isEmpty()) {
               this.I_field_9876a47 = AutoBrewModule.Nested1_bc0ef440.iI_field_9876a47;
               this.i_field_991c1e8c.I_method_23e11e3f();
               return;
            }

            this.I_field_37892422 = (ChestBlockEntity)var1.getFirst();
         }

         if (!(I_field_3a9bda27.player.currentScreenHandler instanceof GenericContainerScreenHandler)) {
            if (this.i_field_991c1e8c.I_method_58432069(500L)) {
               this.I_method_2357e53d(this.I_field_37892422);
               this.i_field_991c1e8c.I_method_23e11e3f();
            }
         } else if (this.i_field_991c1e8c.I_method_58432069(200L)) {
            this.IIII_method_331ac8a2();
            this.I_field_9876a47 = AutoBrewModule.Nested1_bc0ef440.iI_field_9876a47;
            this.i_field_991c1e8c.I_method_23e11e3f();
         }
      }
   }

   private void iii_method_b5f1127f() {
      if (this.i_field_991c1e8c.I_method_58432069(500L)) {
         I_field_3a9bda27.player.closeHandledScreen();
         if (this.I_field_c786becb != null) {
            this.I_field_7865b31.add(this.I_field_c786becb.getPos());
         }

         this.I_field_9876a47 = AutoBrewModule.Nested1_bc0ef440.I_field_9876a47;
         this.I_field_c786becb = null;
         this.I_field_37892422 = null;
         this.i_field_991c1e8c.I_method_23e11e3f();
      }
   }

   private List<BrewingStandBlockEntity> I_method_9a2b0228() {
      ArrayList<BrewingStandBlockEntity> var1 = new ArrayList<>();
      byte var2 = 10;
      BlockPos var3 = BlockPos.ofFloored(I_field_3a9bda27.player.getPos());

      for (int var4 = -var2; var4 <= var2; var4++) {
         for (int var5 = -var2; var5 <= var2; var5++) {
            for (int var6 = -var2; var6 <= var2; var6++) {
               BlockPos var7 = var3.add(var4, var5, var6);
               if (I_field_3a9bda27.world.getBlockEntity(var7) instanceof BrewingStandBlockEntity var8) {
                  var1.add(var8);
               }
            }
         }
      }

      return var1;
   }

   private List<ChestBlockEntity> i_method_4f773a48() {
      ArrayList<ChestBlockEntity> var1 = new ArrayList<>();
      byte var2 = 10;
      BlockPos var3 = BlockPos.ofFloored(I_field_3a9bda27.player.getPos());

      for (int var4 = -var2; var4 <= var2; var4++) {
         for (int var5 = -var2; var5 <= var2; var5++) {
            for (int var6 = -var2; var6 <= var2; var6++) {
               BlockPos var7 = var3.add(var4, var5, var6);
               if (I_field_3a9bda27.world.getBlockEntity(var7) instanceof ChestBlockEntity var8) {
                  var1.add(var8);
               }
            }
         }
      }

      var1.sort(Comparator.comparingDouble(var1x -> Vec3d.ofCenter(var1x.getPos()).squaredDistanceTo(Vec3d.ofCenter(var3))));
      return var1;
   }

   private void IIII_method_331ac8a2() {
      if (I_field_3a9bda27.player.currentScreenHandler instanceof GenericContainerScreenHandler var1) {
         DefaultedList var6 = var1.slots;

         for (int var3 = 0; var3 < var6.size(); var3++) {
            Slot var4 = (Slot)var6.get(var3);
            if (var4.inventory == I_field_3a9bda27.player.getInventory()) {
               ItemStack var5 = var4.getStack();
               if (!var5.isEmpty() && (this.I_method_ddb00b65(var5) || this.i_method_81a88f45(var5))) {
                  iIIiIiIiI_Class299.I_method_8062c464(var3);
               }
            }
         }
      }
   }

   private boolean I_method_ddb00b65(ItemStack var1) {
      return var1.getItem() == Items.POTION || var1.getItem() == Items.SPLASH_POTION || var1.getItem() == Items.LINGERING_POTION;
   }

   private boolean i_method_81a88f45(ItemStack var1) {
      Item var2 = var1.getItem();

      for (Item var6 : I_field_e4463c91) {
         if (var2 == var6) {
            return true;
         }
      }

      return false;
   }

   private void I_method_ba2001b5(BrewingStandScreenHandler var1) {
      for (int var2 = 0; var2 < 3; var2++) {
         if (!var1.getSlot(var2).getStack().isEmpty()) {
            iIIiIiIiI_Class299.I_method_8062c464(var2);
         }
      }
   }

   private void I_method_2357e53d(ChestBlockEntity var1) {
      BlockPos var2 = var1.getPos();
      Vec3d var3 = new Vec3d(var2.getX() + 0.5, var2.getY() + 0.5, var2.getZ() + 0.5);
      BlockHitResult var4 = new BlockHitResult(var3, Direction.UP, var2, false);
      I_field_3a9bda27.interactionManager.interactBlock(I_field_3a9bda27.player, Hand.MAIN_HAND, var4);
   }

   private void i_method_1ab6799c(Item var1, int var2) {
      int var3;
      if (this.I_field_991c1e8c.I_method_58432069((long)(this.I_field_73178e8c.Ii_method_a20abcd2() * 2.0F)) && (var3 = this.I_method_ad95b21a(var1)) != -1) {
         iIIiIiIiI_Class299.Ii_method_5feb9482(var3, var2);
         this.I_field_991c1e8c.I_method_23e11e3f();
      }
   }

   private int I_method_ad95b21a(Item var1) {
      for (int var2 = 5; var2 < 41; var2++) {
         if (((Slot)I_field_3a9bda27.player.currentScreenHandler.slots.get(var2)).getStack().getItem() == var1) {
            return var2;
         }
      }

      return -1;
   }

   private boolean I_method_d4781675(BrewingStandScreenHandler var1, Potion var2) {
      boolean var3 = true;

      for (int var4 = 0; var4 < 3; var4++) {
         ItemStack var5 = ((Slot)var1.slots.get(var4)).getStack();
         if (var5.getItem() == Items.POTION
            && ((RegistryEntry)((PotionContentsComponent)var5.get(DataComponentTypes.POTION_CONTENTS)).potion().get()).value() != var2) {
            var3 = false;
         }
      }

      return var3;
   }

   private int I_method_ba2001a8(BrewingStandScreenHandler var1) {
      for (int var2 = 5; var2 < 41; var2++) {
         ItemStack var3 = ((Slot)var1.slots.get(var2)).getStack();
         if (var3.getItem() == Items.POTION
            && ((PotionContentsComponent)var3.get(DataComponentTypes.POTION_CONTENTS)).potion().isPresent()
            && ((RegistryEntry)((PotionContentsComponent)var3.get(DataComponentTypes.POTION_CONTENTS)).potion().get()).value() == Potions.WATER.value()) {
            return var2;
         }
      }

      return -1;
   }

   static enum Nested1_bc0ef440 {
      I_field_9876a47,
      i_field_9876a47,
      II_field_9876a47,
      Ii_field_9876a47,
      iI_field_9876a47;
   }
}
