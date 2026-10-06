package rockstar.client;

import java.util.function.Predicate;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.recipebook.RecipeResultCollection;
import net.minecraft.client.recipebook.ClientRecipeBook;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.network.packet.c2s.play.CraftRequestC2SPacket;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.recipe.NetworkRecipeId;
import net.minecraft.recipe.RecipeDisplayEntry;
import net.minecraft.recipe.display.SlotDisplayContexts;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.Hand;
import net.minecraft.util.context.ContextParameterMap;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import pyrock.events.network.ReceivePacketEvent;
import pyrock.events.player.ClientPlayerTickEvent;

public class IIiIIIIII_Class65 extends IIIiiiIii_Class60 {
   private final TextSetting I_field_731802cc;
   private final SliderSetting I_field_73178e8c;
   private final BooleanSetting I_field_ba20ca4c;
   private static final int I_field_49 = 6;
   private static final long I_field_4a = 350L;
   private static final long i_field_4a = 5000L;
   private static final int i_field_49 = 4;
   private static final float I_field_46 = 1.5F;
   private static final String I_field_523beb0a = "\u0418\u0437\u0443\u043c\u0440\u0443\u0434\u043d\u044b\u0439 \u043c\u0435\u0447";
   private static final int II_field_49 = 3;
   private static final String i_field_523beb0a = "\u0425\u0440\u0430\u043d\u0438\u043b\u0438\u0449\u0435";
   private static final String II_field_523beb0a = "\u0423 \u0412\u0430\u0441 \u043a\u0443\u043f\u0438\u043b\u0438";
   private IIiIIIIII_Class65.Nested1_712b5460 I_field_f7f70e27;
   private final iiIiIIiii_Class424 I_field_991c1e8c;
   private final iiIiIIiii_Class424 i_field_991c1e8c;
   private final iiIiIIiii_Class424 II_field_991c1e8c;
   private BlockPos I_field_670402ba;
   private iiIIiIIii_Class404 I_field_32e13e6c;
   private int Ii_field_49;
   private boolean I_field_5a;
   private NetworkRecipeId I_field_add60ee5;
   private int iI_field_49;
   private int ii_field_49;
   private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41;
   private final IiIIIiII_Class69<ReceivePacketEvent> i_field_3d936f41;

   public IIiIIIIII_Class65(AutoFarmModule var1, ModeSetting var2) {
      super(var1, var2, "modules.settings.auto_farm.modes.sword");
      this.I_field_f7f70e27 = IIiIIIIII_Class65.Nested1_712b5460.I_field_f7f70e27;
      this.I_field_991c1e8c = new iiIiIIiii_Class424();
      this.i_field_991c1e8c = new iiIiIIiii_Class424();
      this.II_field_991c1e8c = new iiIiIIiii_Class424();
      this.iI_field_49 = -1;
      this.ii_field_49 = 0;
      this.I_field_3d936f41 = var1x -> {
         if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
            if (this.I_field_f7f70e27 == IIiIIIIII_Class65.Nested1_712b5460.I_field_f7f70e27 && !this.I_method_5ea24b(Items.STICK)) {
               this.I_method_cac07269("modules.sword_farm.no_sticks");
               this.iI_method_8024b102();
            } else {
               switch (this.I_field_f7f70e27) {
                  case I_field_f7f70e27:
                     this.II_method_99dc6522();
                     break;
                  case i_field_f7f70e27:
                     this.ii_method_9bade122();
                     break;
                  case II_field_f7f70e27:
                     this.III_method_a1bf367f();
                     break;
                  case Ii_field_f7f70e27:
                     this.IIi_method_a1cdc25f();
                     break;
                  case iI_field_f7f70e27:
                     this.IiI_method_a382269f();
                     break;
                  case ii_field_f7f70e27:
                     this.I_method_80f59e22(IIiIIIIII_Class65.Nested1_712b5460.I_field_f7f70e27);
                     break;
                  case III_field_f7f70e27:
                     this.Iii_method_a390b27f();
                     break;
                  case IIi_field_f7f70e27:
                     this.iII_method_d85a4a5f();
                     break;
                  case IiI_field_f7f70e27:
                     this.iIi_method_d868d63f();
                     break;
                  case Iii_field_f7f70e27:
                     this.I_method_80f59e22(IIiIIIIII_Class65.Nested1_712b5460.I_field_f7f70e27);
                     break;
                  case iII_field_f7f70e27:
                     this.iiI_method_da1d3a7f();
                     break;
                  case iIi_field_f7f70e27:
                     this.iii_method_da2bc65f();
                     break;
                  case iiI_field_f7f70e27:
                     this.IIII_method_963690c2();
                     break;
                  case iii_field_f7f70e27:
                     this.IIIi_method_96451ca2();
                     break;
                  case IIII_field_f7f70e27:
                     this.IIiI_method_97f980e2();
                     break;
                  case IIIi_field_f7f70e27:
                     this.IIii_method_98080cc2();
                     break;
                  case IIiI_field_f7f70e27:
                     this.IiII_method_ccd1a4a2();
                     break;
                  case IIii_field_f7f70e27:
                     this.I_method_80f59e22(IIiIIIIII_Class65.Nested1_712b5460.iII_field_f7f70e27);
               }
            }
         }
      };
      this.i_field_3d936f41 = var1x -> {
         if (var1x.getPacket() instanceof GameMessageS2CPacket var2x) {
            String var4 = var2x.content().getString();
            if (var4.contains("\u0423 \u0412\u0430\u0441 \u043a\u0443\u043f\u0438\u043b\u0438")) {
               this.I_field_5a = true;
               this.I_method_18285755().Ii_method_96108ce2();
            }
         }
      };
      this.I_field_731802cc = new TextSetting(var1, "modules.settings.auto_farm.sword.price", () -> !this.isSelected())
         .I_method_104de33f("15000")
         .I_method_ec08f9eb(true);
      this.I_field_73178e8c = new SliderSetting(var1, "modules.settings.auto_farm.sword.relist_cooldown", () -> !this.isSelected())
         .II_method_b0f56334(5.0F)
         .I_method_c8c9a7d7(5.0F)
         .i_method_65e2aff7(300.0F)
         .Ii_method_4e0e6b54(60.0F)
         .I_method_d41e7abf("sec");
      this.I_field_ba20ca4c = new BooleanSetting(var1, "modules.settings.auto_farm.sword.craft_all", () -> !this.isSelected());
   }

   @Override
   public void I_method_a0f53e1f() {
      if (I_field_3a9bda27.player == null || I_field_3a9bda27.world == null) {
         this.iI_method_8024b102();
      } else if (!this.I_method_5ea24b(Items.STICK)) {
         this.I_method_cac07269("modules.sword_farm.no_sticks");
         this.iI_method_8024b102();
      } else {
         this.I_field_f7f70e27 = IIiIIIIII_Class65.Nested1_712b5460.I_field_f7f70e27;
         this.I_field_670402ba = null;
         this.I_field_32e13e6c = null;
         this.Ii_field_49 = 0;
         this.I_field_5a = false;
         this.I_field_add60ee5 = null;
         this.I_field_991c1e8c.I_method_23e11e3f();
      }
   }

   @Override
   public void i_method_a103c9ff() {
      this.I_field_f7f70e27 = IIiIIIIII_Class65.Nested1_712b5460.I_field_f7f70e27;
      this.I_field_670402ba = null;
      this.I_field_32e13e6c = null;
      this.Ii_field_49 = 0;
      this.I_field_add60ee5 = null;
   }

   @Override
   public IIiIIIIIi_Class66 I_method_57286715() {
      return switch (this.I_field_f7f70e27) {
         case I_field_f7f70e27 -> IIiIIIIIi_Class66.I_field_e6af4a4c;
         case i_field_f7f70e27, II_field_f7f70e27, Ii_field_f7f70e27, iI_field_f7f70e27, ii_field_f7f70e27 -> IIiIIIIIi_Class66.IiI_field_e6af4a4c;
         case III_field_f7f70e27, IIi_field_f7f70e27, IiI_field_f7f70e27, Iii_field_f7f70e27 -> IIiIIIIIi_Class66.Iii_field_e6af4a4c;
         case iII_field_f7f70e27, iIi_field_f7f70e27, iiI_field_f7f70e27, iii_field_f7f70e27, IIII_field_f7f70e27, IIIi_field_f7f70e27, IIiI_field_f7f70e27, IIii_field_f7f70e27 -> IIiIIIIIi_Class66.IIi_field_e6af4a4c;
      };
   }

   @Override
   public IIiIIIiII_Class69 I_method_5736ef15() {
      return IIiIIIiII_Class69.II_field_e6bdd24c;
   }

   @Override
   public ItemStack I_method_907017b9() {
      return new ItemStack(Items.DIAMOND_SWORD);
   }

   private void II_method_99dc6522() {
      if (this.I_field_991c1e8c.I_method_58432069(350L)) {
         boolean var1 = this.i_method_a1ebe1f2() > 0;
         if (!var1 || this.I_method_5ea24b(Items.EMERALD) && this.I_method_a1dd5612() > 4) {
            if (!this.I_method_5ea24b(Items.EMERALD)) {
               this.i_method_3bed1e42(IIiIIIIII_Class65.Nested1_712b5460.i_field_f7f70e27);
            } else {
               this.i_method_3bed1e42(IIiIIIIII_Class65.Nested1_712b5460.III_field_f7f70e27);
            }
         } else {
            this.i_method_3bed1e42(IIiIIIIII_Class65.Nested1_712b5460.iII_field_f7f70e27);
         }
      }
   }

   private void ii_method_9bade122() {
      if (this.I_field_991c1e8c.I_method_58432069(350L)) {
         I_field_3a9bda27.player.networkHandler.sendChatCommand("shop");
         this.i_method_3bed1e42(IIiIIIIII_Class65.Nested1_712b5460.II_field_f7f70e27);
      }
   }

   private void III_method_a1bf367f() {
      if (this.I_field_991c1e8c.I_method_58432069(600L)) {
         ScreenHandler var1 = this.I_method_9e32f957();
         if (var1 != null) {
            int var2 = I_method_12f65aa1(var1, var0 -> var0.getItem() == Items.GOLD_INGOT);
            if (var2 == -1) {
               if (this.i_field_991c1e8c.I_method_58432069(5000L)) {
                  this.I_method_cac07269("modules.sword_farm.shop_no_gold");
                  this.iI_method_8024b102();
               }
            } else {
               I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var2, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
               this.i_method_3bed1e42(IIiIIIIII_Class65.Nested1_712b5460.Ii_field_f7f70e27);
            }
         }
      }
   }

   private void IIi_method_a1cdc25f() {
      if (this.I_field_991c1e8c.I_method_58432069(600L)) {
         ScreenHandler var1 = this.I_method_9e32f957();
         if (var1 != null) {
            int var2 = I_method_12f65aa1(var1, var0 -> var0.getItem() == Items.EMERALD);
            if (var2 == -1) {
               if (this.i_field_991c1e8c.I_method_58432069(5000L)) {
                  this.I_method_cac07269("modules.sword_farm.shop_no_emerald");
                  this.iI_method_8024b102();
               }
            } else {
               I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var2, 1, SlotActionType.PICKUP, I_field_3a9bda27.player);
               this.i_method_3bed1e42(IIiIIIIII_Class65.Nested1_712b5460.iI_field_f7f70e27);
            }
         }
      }
   }

   private void IiI_method_a382269f() {
      if (this.I_field_991c1e8c.I_method_58432069(600L)) {
         ScreenHandler var1 = this.I_method_9e32f957();
         if (var1 != null) {
            int var2 = I_method_12f65aa1(var1, var0 -> var0.getItem() == Items.LIME_STAINED_GLASS_PANE);
            if (var2 == -1) {
               if (this.i_field_991c1e8c.I_method_58432069(5000L)) {
                  this.I_method_cac07269("modules.sword_farm.shop_no_confirm");
                  this.iI_method_8024b102();
               }
            } else {
               I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var2, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
               this.i_method_3bed1e42(IIiIIIIII_Class65.Nested1_712b5460.ii_field_f7f70e27);
            }
         }
      }
   }

   private void Iii_method_a390b27f() {
      if (this.I_field_670402ba == null || !this.I_method_ba64dddd(this.I_field_670402ba) || !this.i_method_e4b871bd(this.I_field_670402ba)) {
         this.I_field_670402ba = this.I_method_bed64a11();
      }

      if (this.I_field_670402ba == null) {
         this.I_method_cac07269("modules.sword_farm.no_crafting_table");
         this.iI_method_8024b102();
      } else {
         this.i_method_3bed1e42(IIiIIIIII_Class65.Nested1_712b5460.IIi_field_f7f70e27);
      }
   }

   private void iII_method_d85a4a5f() {
      if (I_field_3a9bda27.currentScreen instanceof HandledScreen) {
         this.i_method_3bed1e42(IIiIIIIII_Class65.Nested1_712b5460.IiI_field_f7f70e27);
      } else if (this.I_field_670402ba != null && this.I_method_ba64dddd(this.I_field_670402ba)) {
         Vec3d var1 = Vec3d.ofCenter(this.I_field_670402ba);
         if (this.I_method_8379138f(var1)) {
            if (this.I_field_991c1e8c.I_method_58432069(350L)) {
               BlockHitResult var2 = new BlockHitResult(var1, Direction.UP, this.I_field_670402ba, false);
               I_field_3a9bda27.interactionManager.interactBlock(I_field_3a9bda27.player, Hand.MAIN_HAND, var2);
               I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
               this.I_field_991c1e8c.I_method_23e11e3f();
            }
         }
      } else {
         this.i_method_3bed1e42(IIiIIIIII_Class65.Nested1_712b5460.III_field_f7f70e27);
      }
   }

   private void iIi_method_d868d63f() {
      if (this.I_field_991c1e8c.I_method_58432069(350L)) {
         if (I_field_3a9bda27.player.currentScreenHandler instanceof CraftingScreenHandler var1) {
            if (!this.I_method_5ea24b(Items.STICK)) {
               this.I_method_cac07269("modules.sword_farm.no_sticks");
               this.iI_method_8024b102();
            } else {
               boolean var6 = this.I_method_504c2dc5(var1);
               boolean var3 = var1.getSlot(0).getStack().isEmpty();
               int var4 = this.I_method_a1dd5612();
               boolean var5 = !this.I_method_5ea24b(Items.EMERALD) || this.i_method_a1ebe1f2() > 0 && var4 <= 4;
               if (var5) {
                  if (!var3 && var4 > 0) {
                     I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, 0, 0, SlotActionType.QUICK_MOVE, I_field_3a9bda27.player);
                     this.I_field_991c1e8c.I_method_23e11e3f();
                  } else if (!var6 && var4 > 0) {
                     this.I_method_504c2dc1(var1);
                     this.I_field_991c1e8c.I_method_23e11e3f();
                  } else {
                     this.i_method_3bed1e42(IIiIIIIII_Class65.Nested1_712b5460.Iii_field_f7f70e27);
                  }
               } else if (!var3) {
                  I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, 0, 0, SlotActionType.QUICK_MOVE, I_field_3a9bda27.player);
                  this.I_field_991c1e8c.I_method_23e11e3f();
               } else {
                  if (this.I_field_add60ee5 == null) {
                     this.I_field_add60ee5 = this.I_method_b9f6d2bc();
                  }

                  if (this.I_field_add60ee5 == null) {
                     if (this.i_field_991c1e8c.I_method_58432069(5000L)) {
                        this.I_method_cac07269("modules.sword_farm.recipe_not_found");
                        this.iI_method_8024b102();
                     }
                  } else {
                     I_field_3a9bda27.player
                        .networkHandler
                        .sendPacket(new CraftRequestC2SPacket(var1.syncId, this.I_field_add60ee5, this.I_field_ba20ca4c.i_method_9b12da03()));
                     this.I_field_991c1e8c.I_method_23e11e3f();
                  }
               }
            }
         } else {
            this.i_method_3bed1e42(IIiIIIIII_Class65.Nested1_712b5460.IIi_field_f7f70e27);
         }
      }
   }

   private void I_method_504c2dc1(CraftingScreenHandler var1) {
      for (int var2 = 1; var2 <= 9 && var2 < var1.slots.size(); var2++) {
         if (!var1.getSlot(var2).getStack().isEmpty()) {
            I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var2, 0, SlotActionType.QUICK_MOVE, I_field_3a9bda27.player);
         }
      }
   }

   private int I_method_a1dd5612() {
      int var1 = 0;

      for (iIIiiiiII_Class317 var3 : iIIiiIiIi_Class310.i_method_7fde0a75().I_method_617d3e68()) {
         if (var3.I_method_dfe89263()) {
            var1++;
         }
      }

      for (iIIiiiIii_Class316 var5 : iIIiiIiIi_Class310.I_method_6a489695().I_method_617d3e68()) {
         if (var5.I_method_dfe89263()) {
            var1++;
         }
      }

      return var1;
   }

   private NetworkRecipeId I_method_b9f6d2bc() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         ClientRecipeBook var1 = I_field_3a9bda27.player.getRecipeBook();
         if (var1 == null) {
            return null;
         } else {
            ContextParameterMap var2 = SlotDisplayContexts.createParameters(I_field_3a9bda27.world);
            NetworkRecipeId var3 = null;

            for (RecipeResultCollection var5 : var1.getOrderedResults()) {
               for (RecipeDisplayEntry var7 : var5.getAllRecipes()) {
                  for (ItemStack var9 : var7.getStacks(var2)) {
                     if (!var9.isEmpty()) {
                        if (i_method_6d90b325(var9)) {
                           return var7.id();
                        }

                        if (var3 == null && II_method_dbcd5708(var9)) {
                           var3 = var7.id();
                        }
                     }
                  }
               }
            }

            return var3;
         }
      } else {
         return null;
      }
   }

   private boolean I_method_504c2dc5(CraftingScreenHandler var1) {
      for (int var2 = 1; var2 <= 9 && var2 < var1.slots.size(); var2++) {
         if (!var1.getSlot(var2).getStack().isEmpty()) {
            return false;
         }
      }

      return true;
   }

   private void iiI_method_da1d3a7f() {
      if (this.I_field_991c1e8c.I_method_58432069(350L)) {
         if (this.i_method_a1ebe1f2() == 0) {
            this.i_method_3bed1e42(IIiIIIIII_Class65.Nested1_712b5460.I_field_f7f70e27);
         } else {
            String var1 = this.I_field_731802cc.II_method_da016c1e() != null && !this.I_field_731802cc.II_method_da016c1e().isBlank()
               ? this.I_field_731802cc.II_method_da016c1e().trim()
               : "15000";
            I_field_3a9bda27.player.networkHandler.sendChatCommand("ah sellgui " + var1);
            this.i_method_3bed1e42(IIiIIIIII_Class65.Nested1_712b5460.iIi_field_f7f70e27);
         }
      }
   }

   private void iii_method_da2bc65f() {
      if (this.I_field_991c1e8c.I_method_58432069(350L)) {
         ScreenHandler var1 = this.I_method_9e32f957();
         if (var1 != null) {
            if (this.i_method_fe182cb2(var1) == 0) {
               this.i_method_3bed1e42(IIiIIIIII_Class65.Nested1_712b5460.iiI_field_f7f70e27);
            } else {
               int var2 = this.I_method_1a5a10d2(var1);
               if (var2 == 0) {
                  this.i_method_3bed1e42(IIiIIIIII_Class65.Nested1_712b5460.iiI_field_f7f70e27);
               } else {
                  if (this.iI_field_49 != -1 && var2 >= this.iI_field_49) {
                     this.ii_field_49++;
                     if (this.ii_field_49 >= 3) {
                        this.i_method_3bed1e42(IIiIIIIII_Class65.Nested1_712b5460.iiI_field_f7f70e27);
                        return;
                     }
                  } else {
                     this.ii_field_49 = 0;
                  }

                  this.iI_field_49 = var2;

                  for (int var3 = 0; var3 < var1.slots.size(); var3++) {
                     Slot var4 = (Slot)var1.slots.get(var3);
                     if (var4.inventory == I_field_3a9bda27.player.getInventory() && I_method_c9982f45(var4.getStack())) {
                        I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var3, 0, SlotActionType.QUICK_MOVE, I_field_3a9bda27.player);
                        break;
                     }
                  }

                  this.I_field_991c1e8c.I_method_23e11e3f();
               }
            }
         }
      }
   }

   private int I_method_1a5a10d2(ScreenHandler var1) {
      int var2 = 0;

      for (Slot var4 : var1.slots) {
         if (var4.inventory == I_field_3a9bda27.player.getInventory() && I_method_c9982f45(var4.getStack())) {
            var2 += var4.getStack().getCount();
         }
      }

      return var2;
   }

   private int i_method_fe182cb2(ScreenHandler var1) {
      int var2 = 0;

      for (Slot var4 : var1.slots) {
         if (var4.inventory != I_field_3a9bda27.player.getInventory() && var4.getStack().isEmpty()) {
            var2++;
         }
      }

      return var2;
   }

   private void IIII_method_963690c2() {
      if (this.I_field_991c1e8c.I_method_58432069(350L)) {
         ScreenHandler var1 = this.I_method_9e32f957();
         if (var1 == null) {
            this.i_method_3bed1e42(IIiIIIIII_Class65.Nested1_712b5460.iII_field_f7f70e27);
         } else {
            int var2 = I_method_12f65aa1(var1, var0 -> var0.getItem() == Items.LIME_DYE);
            if (var2 == -1) {
               if (this.i_field_991c1e8c.I_method_58432069(5000L)) {
                  this.I_method_cac07269("modules.sword_farm.no_lime_dye");
                  this.iI_method_8024b102();
               }
            } else {
               I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var2, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
               this.I_field_5a = false;
               this.II_field_991c1e8c.I_method_23e11e3f();
               this.IiIi_method_cce03082();
               this.i_method_3bed1e42(IIiIIIIII_Class65.Nested1_712b5460.iii_field_f7f70e27);
            }
         }
      }
   }

   private void IIIi_method_96451ca2() {
      if (this.I_field_5a) {
         this.I_field_5a = false;
         this.i_method_3bed1e42(IIiIIIIII_Class65.Nested1_712b5460.I_field_f7f70e27);
      } else {
         if (this.II_field_991c1e8c.I_method_58432069((long)this.I_field_73178e8c.Ii_method_a20abcd2() * 1000L)) {
            this.i_method_3bed1e42(IIiIIIIII_Class65.Nested1_712b5460.IIII_field_f7f70e27);
         }
      }
   }

   private void IIiI_method_97f980e2() {
      if (this.I_field_991c1e8c.I_method_58432069(350L)) {
         this.IiIi_method_cce03082();
         I_field_3a9bda27.player.networkHandler.sendChatCommand("ah");
         this.i_method_3bed1e42(IIiIIIIII_Class65.Nested1_712b5460.IIIi_field_f7f70e27);
      }
   }

   private void IIii_method_98080cc2() {
      if (this.I_field_991c1e8c.I_method_58432069(650L)) {
         ScreenHandler var1 = this.I_method_9e32f957();
         if (var1 != null) {
            int var2 = I_method_482660dc(var1, "\u0425\u0440\u0430\u043d\u0438\u043b\u0438\u0449\u0435");
            if (var2 == -1) {
               if (this.i_field_991c1e8c.I_method_58432069(5000L)) {
                  this.I_method_cac07269("modules.sword_farm.no_storage");
                  this.iI_method_8024b102();
               }
            } else {
               I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var2, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
               this.i_method_3bed1e42(IIiIIIIII_Class65.Nested1_712b5460.IIiI_field_f7f70e27);
            }
         }
      }
   }

   private void IiII_method_ccd1a4a2() {
      if (this.I_field_991c1e8c.I_method_58432069(350L)) {
         ScreenHandler var1 = this.I_method_9e32f957();
         if (var1 != null) {
            int var2 = this.II_method_4f351a55(var1);
            if (var2 == 0) {
               this.i_method_3bed1e42(IIiIIIIII_Class65.Nested1_712b5460.IIii_field_f7f70e27);
            } else {
               if (this.iI_field_49 != -1 && var2 >= this.iI_field_49) {
                  this.ii_field_49++;
                  if (this.ii_field_49 >= 3) {
                     this.i_method_3bed1e42(IIiIIIIII_Class65.Nested1_712b5460.IIii_field_f7f70e27);
                     return;
                  }
               } else {
                  this.ii_field_49 = 0;
               }

               this.iI_field_49 = var2;

               for (int var3 = 0; var3 < var1.slots.size(); var3++) {
                  Slot var4 = (Slot)var1.slots.get(var3);
                  if (var4.inventory != I_field_3a9bda27.player.getInventory() && I_method_c9982f45(var4.getStack())) {
                     I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var3, 0, SlotActionType.QUICK_MOVE, I_field_3a9bda27.player);
                     break;
                  }
               }

               this.I_field_991c1e8c.I_method_23e11e3f();
            }
         }
      }
   }

   private int II_method_4f351a55(ScreenHandler var1) {
      int var2 = 0;

      for (Slot var4 : var1.slots) {
         if (var4.inventory != I_field_3a9bda27.player.getInventory() && I_method_c9982f45(var4.getStack())) {
            var2 += var4.getStack().getCount();
         }
      }

      return var2;
   }

   private void I_method_80f59e22(IIiIIIIII_Class65.Nested1_712b5460 var1) {
      if (this.I_field_991c1e8c.I_method_58432069(350L)) {
         this.IiIi_method_cce03082();
         this.i_method_3bed1e42(var1);
      }
   }

   private void IiIi_method_cce03082() {
      if (I_field_3a9bda27.player != null) {
         if (I_field_3a9bda27.player.currentScreenHandler != null
            && I_field_3a9bda27.player.currentScreenHandler != I_field_3a9bda27.player.playerScreenHandler) {
            I_field_3a9bda27.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(I_field_3a9bda27.player.currentScreenHandler.syncId));
         }

         I_field_3a9bda27.player.closeHandledScreen();
      }
   }

   private ScreenHandler I_method_9e32f957() {
      if (!(I_field_3a9bda27.currentScreen instanceof HandledScreen)) {
         return null;
      } else if (I_field_3a9bda27.player == null) {
         return null;
      } else {
         ScreenHandler var1 = I_field_3a9bda27.player.currentScreenHandler;
         return var1 == I_field_3a9bda27.player.playerScreenHandler ? null : var1;
      }
   }

   private boolean I_method_8379138f(Vec3d var1) {
      iiIIiIIii_Class404 var2 = iiIIiIiIi_Class406.I_method_bc8095a1(var1);
      if (this.I_field_32e13e6c == null || this.I_field_32e13e6c.I_method_24e31c97(var2) > 0.5F) {
         this.I_field_32e13e6c = var2;
         this.Ii_field_49 = 0;
      }

      RockstarClient.getInstance()
         .I_method_58785402()
         .I_method_1acbf705(var2, iiIIiIIIi_Class402.Ii_field_32e0c64c, 180.0F, 180.0F, 180.0F, iiIIiIiiI_Class407.iI_field_32efc66c);
      iiIIiIIii_Class404 var3 = RockstarClient.getInstance().I_method_58785402().II_method_f098f858();
      if (var3 != null && var3.I_method_24e31c97(var2) <= 1.5F) {
         this.Ii_field_49++;
         return this.Ii_field_49 >= 1;
      } else {
         return false;
      }
   }

   private void i_method_3bed1e42(IIiIIIIII_Class65.Nested1_712b5460 var1) {
      this.I_field_f7f70e27 = var1;
      this.I_field_991c1e8c.I_method_23e11e3f();
      this.i_field_991c1e8c.I_method_23e11e3f();
      this.I_field_32e13e6c = null;
      this.Ii_field_49 = 0;
      this.iI_field_49 = -1;
      this.ii_field_49 = 0;
   }

   private boolean I_method_5ea24b(Item var1) {
      return iIIiiIiIi_Class310.I_method_6a489695().I_method_c9799e6b(var1) || iIIiiIiIi_Class310.i_method_7fde0a75().I_method_c9799e6b(var1);
   }

   private int i_method_a1ebe1f2() {
      int var1 = 0;

      for (iIIiiiiII_Class317 var3 : iIIiiIiIi_Class310.i_method_7fde0a75().I_method_617d3e68()) {
         if (I_method_c9982f45(var3.I_method_7b7e0bb9())) {
            var1++;
         }
      }

      for (iIIiiiIii_Class316 var5 : iIIiiIiIi_Class310.I_method_6a489695().I_method_617d3e68()) {
         if (I_method_c9982f45(var5.I_method_7b7e0bb9())) {
            var1++;
         }
      }

      return var1;
   }

   private static boolean I_method_c9982f45(ItemStack var0) {
      return var0.isEmpty() ? false : i_method_6d90b325(var0) || II_method_dbcd5708(var0);
   }

   private static boolean i_method_6d90b325(ItemStack var0) {
      return var0.getName().getString().contains("\u0418\u0437\u0443\u043c\u0440\u0443\u0434\u043d\u044b\u0439 \u043c\u0435\u0447");
   }

   private static boolean II_method_dbcd5708(ItemStack var0) {
      return var0.getItem() == Items.DIAMOND_SWORD && iIIiIiIIi_Class298.I_method_7ea237bf(var0, Enchantments.SHARPNESS) == 3;
   }

   private static int I_method_12f65aa1(ScreenHandler var0, Predicate<ItemStack> var1) {
      for (int var2 = 0; var2 < var0.slots.size(); var2++) {
         Slot var3 = (Slot)var0.slots.get(var2);
         if (var3.inventory != MinecraftClient.getInstance().player.getInventory() && var1.test(var3.getStack())) {
            return var2;
         }
      }

      return -1;
   }

   private static int I_method_482660dc(ScreenHandler var0, String var1) {
      for (int var2 = 0; var2 < var0.slots.size(); var2++) {
         Slot var3 = (Slot)var0.slots.get(var2);
         if (var3.inventory != MinecraftClient.getInstance().player.getInventory()) {
            ItemStack var4 = var3.getStack();
            if (!var4.isEmpty() && var4.getName().getString().contains(var1)) {
               return var2;
            }
         }
      }

      return -1;
   }

   private boolean I_method_ba64dddd(BlockPos var1) {
      return I_field_3a9bda27.world.getBlockState(var1).getBlock() == Blocks.CRAFTING_TABLE;
   }

   private boolean i_method_e4b871bd(BlockPos var1) {
      double var2 = I_field_3a9bda27.player.getBlockInteractionRange() + 0.5;
      return I_field_3a9bda27.player.getEyePos().squaredDistanceTo(Vec3d.ofCenter(var1)) <= var2 * var2;
   }

   private BlockPos I_method_bed64a11() {
      BlockPos var1 = I_field_3a9bda27.player.getBlockPos();
      Vec3d var2 = I_field_3a9bda27.player.getEyePos();
      double var3 = I_field_3a9bda27.player.getBlockInteractionRange();
      double var5 = var3 * var3;
      BlockPos var7 = null;
      double var8 = Double.MAX_VALUE;

      for (int var10 = -6; var10 <= 6; var10++) {
         for (int var11 = -6; var11 <= 6; var11++) {
            for (int var12 = -6; var12 <= 6; var12++) {
               BlockPos var13 = var1.add(var10, var11, var12);
               if (I_field_3a9bda27.world.getBlockState(var13).getBlock() == Blocks.CRAFTING_TABLE) {
                  double var14 = var2.squaredDistanceTo(Vec3d.ofCenter(var13));
                  if (!(var14 > var5) && var14 < var8) {
                     var8 = var14;
                     var7 = var13;
                  }
               }
            }
         }
      }

      return var7;
   }

   static enum Nested1_712b5460 {
      I_field_f7f70e27,
      i_field_f7f70e27,
      II_field_f7f70e27,
      Ii_field_f7f70e27,
      iI_field_f7f70e27,
      ii_field_f7f70e27,
      III_field_f7f70e27,
      IIi_field_f7f70e27,
      IiI_field_f7f70e27,
      Iii_field_f7f70e27,
      iII_field_f7f70e27,
      iIi_field_f7f70e27,
      iiI_field_f7f70e27,
      iii_field_f7f70e27,
      IIII_field_f7f70e27,
      IIIi_field_f7f70e27,
      IIiI_field_f7f70e27,
      IIii_field_f7f70e27;
   }
}
