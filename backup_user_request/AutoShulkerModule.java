package rockstar.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MaceItem;
import net.minecraft.item.TridentItem;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ShulkerBoxScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.Hand;
import pyrock.events.game.PickupEvent;
import pyrock.events.window.KeyPressEvent;
import pyrock.events.window.MouseEvent;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Auto Shulker",
   category = ModuleCategory.PLAYER,
   III_method_a89e5834 = "modules.descriptions.auto_shulker"
)
public class AutoShulkerModule extends Module {
   private static final String I_field_523beb0a = "\u0440\u044e\u043a\u0437\u0430\u043a";
   private static final int I_field_49 = 8;
   private static final int i_field_49 = 44;
   private static final Set<Item> I_field_a56a8dc5 = Set.of(
      Items.GOLDEN_APPLE,
      Items.ENCHANTED_GOLDEN_APPLE,
      Items.GOLDEN_CARROT,
      Items.CHORUS_FRUIT,
      Items.ENDER_PEARL,
      Items.ENDER_EYE,
      Items.EXPERIENCE_BOTTLE,
      Items.POTION,
      Items.SPLASH_POTION,
      Items.LINGERING_POTION,
      Items.FIREWORK_ROCKET,
      Items.SNOWBALL
   );
   private static final Set<Item> i_field_a56a8dc5 = Set.of(
      Items.NETHERITE_INGOT,
      Items.NETHERITE_SCRAP,
      Items.NETHERITE_BLOCK,
      Items.ANCIENT_DEBRIS,
      Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE,
      Items.NETHER_STAR,
      Items.BEACON,
      Items.ELYTRA,
      Items.DIAMOND,
      Items.DIAMOND_BLOCK,
      Items.EMERALD,
      Items.EMERALD_BLOCK,
      Items.ECHO_SHARD,
      Items.HEAVY_CORE,
      Items.DRAGON_EGG,
      Items.DRAGON_BREATH,
      Items.ENDER_CHEST
   );
   private static final Set<Item> II_field_a56a8dc5 = Set.of(
      Items.NETHERITE_HELMET, Items.NETHERITE_CHESTPLATE, Items.NETHERITE_LEGGINGS, Items.NETHERITE_BOOTS
   );
   private static final Set<Item> Ii_field_a56a8dc5 = Set.of(Items.GOLDEN_HELMET, Items.GOLDEN_BOOTS);
   private static final Set<Item> iI_field_a56a8dc5 = Set.of(
      Items.PLAYER_HEAD, Items.WITHER_SKELETON_SKULL, Items.SKELETON_SKULL, Items.DRAGON_HEAD, Items.CREEPER_HEAD, Items.ZOMBIE_HEAD, Items.PIGLIN_HEAD
   );
   private ModeSetting I_field_bbe33e6c;
   private ModeSetting.Nested1_42765c60 I_field_500d0627;
   private ModeSetting.Nested1_42765c60 i_field_500d0627;
   private KeybindSetting I_field_ba20522c;
   private MultiSelectSetting I_field_bbe3ba6c;
   private MultiSelectSetting.Nested1_42856060 I_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 i_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 II_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 Ii_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 iI_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 ii_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 III_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 IIi_field_51de8227;
   private SliderSetting I_field_73178e8c;
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private final iiIiIIiii_Class424 i_field_991c1e8c = new iiIiIIiii_Class424();
   private final iiIiIIiii_Class424 II_field_991c1e8c = new iiIiIIiii_Class424();
   private final Map<Integer, ItemStack> I_field_a567c40b = new HashMap<>();
   private final List<ItemStack> I_field_7865b31 = new ArrayList<>();
   private final Set<Integer> ii_field_a56a8dc5 = new HashSet<>();
   private final ItemStack[] I_field_6132843d = new ItemStack[36];
   private final iiIiIIiii_Class424 Ii_field_991c1e8c = new iiIiIIiii_Class424();
   private boolean I_field_5a;
   private AutoShulkerModule.Nested1_e4c31020 I_field_f756ca67;
   private boolean i_field_5a;
   private int II_field_49;
   private int Ii_field_49;
   private int iI_field_49;
   private boolean II_field_5a;
   private final IiIIIiII_Class69<PickupEvent> I_field_3d936f41;
   private final IiIIIiII_Class69<KeyPressEvent> i_field_3d936f41;
   private final IiIIIiII_Class69<MouseEvent> II_field_3d936f41;

   public AutoShulkerModule() {
      this.I_field_f756ca67 = AutoShulkerModule.Nested1_e4c31020.I_field_f756ca67;
      this.II_field_49 = -1;
      this.Ii_field_49 = -1;
      this.I_field_3d936f41 = var1 -> {
         if (I_field_3a9bda27.player != null && var1.getEntity() == I_field_3a9bda27.player) {
            if (this.Ii_method_c43ea6a8(var1.getItemStack())) {
               this.I_method_70f6eb81(var1.getItemStack());
               this.I_field_5a = true;
               this.Ii_field_991c1e8c.I_method_23e11e3f();
               if (this.I_field_bbe33e6c.I_method_ce989e26(this.I_field_500d0627)) {
                  this.i_field_5a = true;
                  this.I_field_991c1e8c.I_method_23e11e3f();
               }
            }
         }
      };
      this.i_field_3d936f41 = var1 -> {
         if (this.I_field_ba20522c.I_method_51ee2d08(var1.getKey()) && var1.getAction() == 1) {
            this.Iii_method_38384ebf();
         }
      };
      this.II_field_3d936f41 = var1 -> {
         if (this.I_field_ba20522c.I_method_51ee2d08(var1.getButton()) && var1.getAction() == 1) {
            this.Iii_method_38384ebf();
         }
      };
      this.IiI_method_3829c2df();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_3829c2df() {
      this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.auto_shulker.mode");
      this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.auto_shulker.mode.auto").select();
      this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.auto_shulker.mode.bind");
      this.I_field_ba20522c = new KeybindSetting(
         this, "modules.settings.auto_shulker.bind", () -> !this.I_field_bbe33e6c.I_method_ce989e26(this.i_field_500d0627)
      );
      this.I_field_bbe3ba6c = new MultiSelectSetting(this, "modules.settings.auto_shulker.valuables");
      this.I_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.auto_shulker.valuables.armor").select();
      this.i_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.auto_shulker.valuables.weapons").select();
      this.II_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.auto_shulker.valuables.enchants").select();
      this.Ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.auto_shulker.valuables.totems").select();
      this.iI_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.auto_shulker.valuables.heads").select();
      this.ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.auto_shulker.valuables.consumables").select();
      this.III_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.auto_shulker.valuables.resources").select();
      this.IIi_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.auto_shulker.valuables.donate").select();
      this.I_field_73178e8c = new SliderSetting(
            this, "modules.settings.auto_shulker.delay", () -> !this.I_field_bbe33e6c.I_method_ce989e26(this.I_field_500d0627)
         )
         .I_method_c8c9a7d7(0.0F)
         .i_method_65e2aff7(2000.0F)
         .II_method_b0f56334(50.0F)
         .Ii_method_4e0e6b54(300.0F);
   }

   private void Iii_method_38384ebf() {
      if (this.I_field_f756ca67 == AutoShulkerModule.Nested1_e4c31020.I_field_f756ca67 && I_field_3a9bda27.currentScreen == null) {
         this.i_field_5a = true;
         this.I_field_991c1e8c.I_method_23e11e3f();
      }
   }

   private void I_method_70f6eb81(ItemStack var1) {
      if (var1 != null && !var1.isEmpty()) {
         if (!this.I_method_70f6eb85(var1)) {
            if (this.I_field_7865b31.size() >= 64) {
               this.I_field_7865b31.remove(0);
            }

            this.I_field_7865b31.add(var1.copy());
         }
      }
   }

   private boolean I_method_70f6eb85(ItemStack var1) {
      if (var1 != null && !var1.isEmpty()) {
         for (ItemStack var3 : this.I_field_7865b31) {
            if (ItemStack.areItemsAndComponentsEqual(var3, var1)) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   @Override
   public void II_method_6642fd22() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null && I_field_3a9bda27.interactionManager != null) {
         this.iII_method_6d01e69f();
         switch (this.I_field_f756ca67) {
            case I_field_f756ca67:
               this.iIi_method_6d10727f();
               break;
            case i_field_f756ca67:
               this.iiI_method_6ec4d6bf();
               break;
            case II_field_f756ca67:
               this.iii_method_6ed3629f();
               break;
            case Ii_field_f756ca67:
               this.IIII_method_96827c82();
               break;
            case iI_field_f756ca67:
               this.IIIi_method_96910862();
               break;
            case ii_field_f756ca67:
               this.IIiI_method_98456ca2();
               break;
            case III_field_f756ca67:
               this.IIii_method_9853f882();
         }

         PlayerInventory var1 = I_field_3a9bda27.player.getInventory();

         for (int var2 = 0; var2 < this.I_field_6132843d.length; var2++) {
            this.I_field_6132843d[var2] = var1.getStack(var2).copy();
         }
      } else {
         this.i_field_5a = false;
         this.IiIi_method_cd2c1c42();
         this.IiiI_method_cee08082();
      }
   }

   private void iII_method_6d01e69f() {
      PlayerInventory var1 = I_field_3a9bda27.player.getInventory();
      boolean var2 = this.I_field_5a && !this.Ii_field_991c1e8c.I_method_58432069(1000L);

      for (int var3 = 0; var3 < this.I_field_6132843d.length; var3++) {
         if (var3 != 8) {
            ItemStack var4 = var1.getStack(var3);
            if (!var4.isEmpty() && this.I_method_70f6eb85(var4)) {
               ItemStack var5 = this.I_field_6132843d[var3];
               boolean var6 = var5 == null || var5.isEmpty() || !ItemStack.areItemsAndComponentsEqual(var5, var4);
               if (var6 && var2) {
                  this.ii_field_a56a8dc5.add(var3);
               }
            } else {
               this.ii_field_a56a8dc5.remove(var3);
            }
         }
      }
   }

   private void iIi_method_6d10727f() {
      if (this.i_field_5a && I_field_3a9bda27.currentScreen == null) {
         if (!this.I_field_bbe33e6c.I_method_ce989e26(this.I_field_500d0627)
            || this.I_field_991c1e8c.I_method_58432069((long)this.I_field_73178e8c.Ii_method_a20abcd2())) {
            if (!this.Iii_method_38384ec3()) {
               this.i_field_5a = false;
            } else {
               iIIiIiIii_Class300 var1 = this.I_method_1fbcbb75();
               if (var1 == null) {
                  this.i_field_5a = false;
               } else if (this.IiI_method_3829c2e3()) {
                  this.i_field_5a = false;
                  this.Ii_field_49 = iIIiIiIiI_Class299.I_method_d0256375().II_method_b9cf08f5();
                  int var2 = var1.I_method_dfe89252();
                  if (var2 == 44) {
                     this.II_field_49 = -1;
                  } else {
                     this.II_field_49 = var2;
                     iIIiIiIiI_Class299.iI_method_c617e8c2(var2, 8);
                  }

                  this.I_field_f756ca67 = AutoShulkerModule.Nested1_e4c31020.i_field_f756ca67;
                  this.i_field_991c1e8c.I_method_23e11e3f();
               }
            }
         }
      }
   }

   private void iiI_method_6ec4d6bf() {
      if (!this.IiI_method_3829c2e3()) {
         if (this.i_field_991c1e8c.I_method_58432069(3000L)) {
            this.IiII_method_cd1d9062();
         }
      } else if (this.i_field_991c1e8c.I_method_58432069(150L)) {
         if (!this.i_method_14ef6f65(iIIiIiIiI_Class299.I_method_6602651a(8).I_method_7b7e0bb9())) {
            this.IiII_method_cd1d9062();
         } else {
            iIIiIiIiI_Class299.i_method_8225b484(8);
            I_field_3a9bda27.interactionManager.interactItem(I_field_3a9bda27.player, Hand.MAIN_HAND);
            this.I_field_f756ca67 = AutoShulkerModule.Nested1_e4c31020.II_field_f756ca67;
            this.i_field_991c1e8c.I_method_23e11e3f();
         }
      }
   }

   private void iii_method_6ed3629f() {
      if (this.iII_method_6d01e6a3()) {
         this.I_field_a567c40b.clear();
         this.II_field_5a = false;
         this.I_field_f756ca67 = AutoShulkerModule.Nested1_e4c31020.Ii_field_f756ca67;
         this.i_field_991c1e8c.I_method_23e11e3f();
      } else {
         if (this.i_field_991c1e8c.I_method_58432069(3000L)) {
            this.I_field_f756ca67 = AutoShulkerModule.Nested1_e4c31020.ii_field_f756ca67;
            this.i_field_991c1e8c.I_method_23e11e3f();
         }
      }
   }

   private void IIII_method_96827c82() {
      if (!this.iII_method_6d01e6a3()) {
         this.I_field_f756ca67 = AutoShulkerModule.Nested1_e4c31020.ii_field_f756ca67;
         this.i_field_991c1e8c.I_method_23e11e3f();
      } else {
         ScreenHandler var1 = I_field_3a9bda27.player.currentScreenHandler;
         int var2 = this.I_method_904a9d12(var1);
         if (var2 == -1 && !this.i_field_991c1e8c.I_method_58432069(15000L)) {
            if (!this.II_field_5a) {
               this.II_field_5a = true;
               this.II_field_991c1e8c.I_method_23e11e3f();
               return;
            }

            if (!this.II_field_991c1e8c.I_method_58432069(500L)) {
               return;
            }
         }

         if (var2 != -1 && !this.i_field_991c1e8c.I_method_58432069(15000L)) {
            this.II_field_5a = false;
            Slot var3 = var1.getSlot(var2);
            ItemStack var4 = var3.getStack().copy();
            I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var2, 0, SlotActionType.QUICK_MOVE, I_field_3a9bda27.player);
            if (ItemStack.areEqual(var3.getStack(), var4)) {
               this.I_field_a567c40b.put(var2, var4);
            }
         } else {
            this.ii_field_a56a8dc5.clear();
            this.I_field_f756ca67 = AutoShulkerModule.Nested1_e4c31020.iI_field_f756ca67;
            this.i_field_991c1e8c.I_method_23e11e3f();
         }
      }
   }

   private void IIIi_method_96910862() {
      if (this.iII_method_6d01e6a3()) {
         I_field_3a9bda27.player.closeHandledScreen();
         this.i_field_991c1e8c.I_method_23e11e3f();
      } else if (I_field_3a9bda27.currentScreen != null) {
         if (this.i_field_991c1e8c.I_method_58432069(3000L)) {
            this.IiII_method_cd1d9062();
         }
      } else {
         this.I_field_f756ca67 = AutoShulkerModule.Nested1_e4c31020.ii_field_f756ca67;
         this.i_field_991c1e8c.I_method_23e11e3f();
      }
   }

   private void IIiI_method_98456ca2() {
      if (I_field_3a9bda27.currentScreen == null && this.IiI_method_3829c2e3()) {
         if (this.i_field_991c1e8c.I_method_58432069(150L)) {
            if (this.II_field_49 != -1 && this.iI_field_49 < 3) {
               this.iI_field_49++;
               iIIiIiIiI_Class299.iI_method_c617e8c2(this.II_field_49, 8);
               this.I_field_f756ca67 = AutoShulkerModule.Nested1_e4c31020.III_field_f756ca67;
               this.i_field_991c1e8c.I_method_23e11e3f();
            } else {
               this.IiII_method_cd1d9062();
            }
         }
      } else {
         if (this.i_field_991c1e8c.I_method_58432069(3000L)) {
            this.IiII_method_cd1d9062();
         }
      }
   }

   private void IIii_method_9853f882() {
      if (this.IiI_method_3829c2e3() && this.i_field_991c1e8c.I_method_58432069(500L)) {
         boolean var1 = this.i_method_14ef6f65(I_field_3a9bda27.player.playerScreenHandler.getSlot(this.II_field_49).getStack());
         boolean var2 = this.i_method_14ef6f65(iIIiIiIiI_Class299.I_method_6602651a(8).I_method_7b7e0bb9());
         if (!var1 && var2) {
            this.I_field_f756ca67 = AutoShulkerModule.Nested1_e4c31020.ii_field_f756ca67;
            this.i_field_991c1e8c.I_method_23e11e3f();
         } else {
            this.IiII_method_cd1d9062();
         }
      }
   }

   private void IiII_method_cd1d9062() {
      if (this.Ii_field_49 != -1) {
         iIIiIiIiI_Class299.i_method_8225b484(this.Ii_field_49);
      }

      this.IiiI_method_cee08082();
   }

   private void IiIi_method_cd2c1c42() {
      this.I_field_7865b31.clear();
      this.ii_field_a56a8dc5.clear();
      Arrays.fill(this.I_field_6132843d, null);
      this.I_field_5a = false;
   }

   private void IiiI_method_cee08082() {
      this.I_field_f756ca67 = AutoShulkerModule.Nested1_e4c31020.I_field_f756ca67;
      this.II_field_5a = false;
      this.II_field_49 = -1;
      this.Ii_field_49 = -1;
      this.iI_field_49 = 0;
      this.I_field_a567c40b.clear();
   }

   private boolean IiI_method_3829c2e3() {
      GuiMoveModule var1 = RockstarClient.getInstance().getModuleManager().getModule(GuiMoveModule.class);
      return var1 == null || var1.I_method_eb75c1e8().isEmpty();
   }

   private iIIiIiIii_Class300 I_method_1fbcbb75() {
      iIIiiIiII_Class309<iIIiIiIii_Class300> var1 = iIIiiIiIi_Class310.I_method_6a489695()
         .I_method_fdeecb5d(iIIiiIiIi_Class310.i_method_7fde0a75())
         .I_method_fdeecb5d(iIIiiIiIi_Class310.Ii_method_1c02fc38());
      return var1.I_method_77fa4424(stack -> this.i_method_14ef6f65(stack));
   }

   private boolean Iii_method_38384ec3() {
      for (int var2 : this.ii_field_a56a8dc5) {
         if (!I_field_3a9bda27.player.getInventory().getStack(var2).isEmpty()) {
            return true;
         }
      }

      return false;
   }

   private boolean i_method_14ef6f65(ItemStack var1) {
      return var1 != null && !var1.isEmpty() && this.II_method_204622c8(var1)
         ? var1.getName().getString().toLowerCase().contains("\u0440\u044e\u043a\u0437\u0430\u043a")
         : false;
   }

   private boolean II_method_204622c8(ItemStack var1) {
      return var1.getItem() instanceof BlockItem var2 && var2.getBlock() instanceof ShulkerBoxBlock;
   }

   private boolean iII_method_6d01e6a3() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.currentScreen instanceof HandledScreen) {
         ScreenHandler var1 = I_field_3a9bda27.player.currentScreenHandler;
         return var1 instanceof GenericContainerScreenHandler || var1 instanceof ShulkerBoxScreenHandler;
      } else {
         return false;
      }
   }

   private int I_method_904a9d12(ScreenHandler var1) {
      int var2 = 0;

      while (true) {
         if (var2 >= var1.slots.size()) {
            return -1;
         }

         Slot var3 = var1.getSlot(var2);
         if (var3.inventory == I_field_3a9bda27.player.getInventory() && this.ii_field_a56a8dc5.contains(var3.getIndex())) {
            ItemStack var4 = var3.getStack();
            if (!var4.isEmpty()) {
               ItemStack var5 = this.I_field_a567c40b.get(var2);
               if (var5 == null) {
                  break;
               }

               if (!ItemStack.areEqual(var5, var4)) {
                  this.I_field_a567c40b.remove(var2);
                  break;
               }
            }
         }

         var2++;
      }

      return var2;
   }

   private boolean Ii_method_c43ea6a8(ItemStack var1) {
      if (var1 != null && !var1.isEmpty() && !this.i_method_14ef6f65(var1)) {
         Item var2 = var1.getItem();
         if (!this.IIi_field_51de8227.isSelected() || IiiiiIiii_Class248.I_method_7613ca72(var1) == null && !Iiiiiiiii_Class256.I_method_30dd7b65(var1)) {
            if (this.II_field_51de8227.isSelected() && var2 == Items.ENCHANTED_BOOK) {
               return true;
            } else if (!this.I_field_51de8227.isSelected()
               || !II_field_a56a8dc5.contains(var2) && (!Ii_field_a56a8dc5.contains(var2) || !var1.hasEnchantments())) {
               if (!this.i_field_51de8227.isSelected()
                  || var2 != Items.NETHERITE_SWORD
                     && !(var2 instanceof AxeItem)
                     && !(var2 instanceof MaceItem)
                     && !(var2 instanceof TridentItem)
                     && !(var2 instanceof BowItem)
                     && !(var2 instanceof CrossbowItem)) {
                  if (this.Ii_field_51de8227.isSelected() && var2 == Items.TOTEM_OF_UNDYING) {
                     return true;
                  } else if (this.iI_field_51de8227.isSelected() && iI_field_a56a8dc5.contains(var2)) {
                     return true;
                  } else {
                     return this.ii_field_51de8227.isSelected() && I_field_a56a8dc5.contains(var2)
                        ? true
                        : this.III_field_51de8227.isSelected() && (i_field_a56a8dc5.contains(var2) || this.II_method_204622c8(var1));
                  }
               } else {
                  return true;
               }
            } else {
               return true;
            }
         } else {
            return true;
         }
      } else {
         return false;
      }
   }

   @Override
   public void onEnable() {
      super.onEnable();
      this.i_field_5a = false;
      this.IiIi_method_cd2c1c42();
      this.IiiI_method_cee08082();
   }

   @Override
   public void onDisable() {
      super.onDisable();
      if (this.I_field_f756ca67 != AutoShulkerModule.Nested1_e4c31020.I_field_f756ca67
         && I_field_3a9bda27.player != null
         && I_field_3a9bda27.interactionManager != null) {
         if (this.iII_method_6d01e6a3()) {
            I_field_3a9bda27.player.closeHandledScreen();
         }

         if (this.II_field_49 != -1) {
            iIIiIiIiI_Class299.iI_method_c617e8c2(this.II_field_49, 8);
         }

         if (this.Ii_field_49 != -1) {
            iIIiIiIiI_Class299.i_method_8225b484(this.Ii_field_49);
         }
      }

      this.i_field_5a = false;
      this.IiIi_method_cd2c1c42();
      this.IiiI_method_cee08082();
   }

   static enum Nested1_e4c31020 {
      I_field_f756ca67,
      i_field_f756ca67,
      II_field_f756ca67,
      Ii_field_f756ca67,
      iI_field_f756ca67,
      ii_field_f756ca67,
      III_field_f756ca67;
   }
}
