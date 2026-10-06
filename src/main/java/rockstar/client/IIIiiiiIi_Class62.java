package rockstar.client;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import pyrock.events.player.ClientPlayerTickEvent;

public class IIIiiiiIi_Class62 extends IIIiiiIii_Class60 {
   private static final int I_field_49 = 4;
   private static final int i_field_49 = 7;
   private static final int II_field_49 = 12;
   private static final int Ii_field_49 = 64;
   private static final int iI_field_49 = 20;
   private static final long I_field_4a = 30000L;
   private static final float I_field_46 = 1.0F;
   private static final int ii_field_49 = 20;
   private static final double I_field_44 = 1.9599999999999997;
   private static final long i_field_4a = 60L;
   private static final long II_field_4a = 50L;
   private final BooleanSetting I_field_ba20ca4c;
   private final BooleanSetting i_field_ba20ca4c;
   private final BooleanSetting II_field_ba20ca4c;
   private static final int III_field_49 = 192;
   private static final int IIi_field_49 = 16;
   BlockPos I_field_670402ba;
   private BlockPos i_field_670402ba;
   IIIiiiiIi_Class62.Nested1_b9e8f480 I_field_c6ed7207;
   private int IiI_field_49;
   private final List<ItemEntity> I_field_7865b31 = new ArrayList<>();
   private ItemEntity I_field_e08508f9;
   private final Set<BlockPos> I_field_a56a8dc5 = new HashSet<>();
   private BlockPos II_field_670402ba;
   private IIIiiiiIi_Class62.Nested1_b9e8f460 I_field_c6ed6e27;
   private int Iii_field_49;
   private int iII_field_49;
   private int iIi_field_49;
   private long Ii_field_4a;
   private boolean I_field_5a;
   private long iI_field_4a;
   private final iiIiIIiii_Class424 I_field_991c1e8c;
   private final iiIiIIiii_Class424 i_field_991c1e8c;
   private iiIIiIIii_Class404 I_field_32e13e6c;
   private int iiI_field_49;
   private int iii_field_49;
   private int IIII_field_49;
   private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41;

   public IIIiiiiIi_Class62(AutoFarmModule var1, ModeSetting var2) {
      super(var1, var2, "modules.settings.auto_farm.modes.mushroom");
      this.I_field_c6ed6e27 = IIIiiiiIi_Class62.Nested1_b9e8f460.I_field_c6ed6e27;
      this.Iii_field_49 = -1;
      this.iII_field_49 = -1;
      this.iIi_field_49 = Integer.MAX_VALUE;
      this.I_field_991c1e8c = new iiIiIIiii_Class424();
      this.i_field_991c1e8c = new iiIiIIiii_Class424();
      this.I_field_3d936f41 = new IiIIIiII_Class69<ClientPlayerTickEvent>() {
         public void onEvent(ClientPlayerTickEvent var1) {
            if (iIIiIIiIi_Class294.I_field_3a9bda27.player != null
               && iIIiIIiIi_Class294.I_field_3a9bda27.world != null
               && IIIiiiiIi_Class62.this.I_field_670402ba != null
               && IIIiiiiIi_Class62.this.I_field_c6ed7207 != null) {
               switch (IIIiiiiIi_Class62.this.I_field_c6ed7207) {
                  case I_field_c6ed7207:
                     IIIiiiiIi_Class62.this.II_method_aca0522();
                     break;
                  case i_field_c6ed7207:
                     IIIiiiiIi_Class62.this.ii_method_c9b8122();
                     break;
                  case II_field_c6ed7207:
                     IIIiiiiIi_Class62.this.III_method_4e85967f();
                     break;
                  case Ii_field_c6ed7207:
                     IIIiiiiIi_Class62.this.Iii_method_5057127f();
                     break;
                  case iI_field_c6ed7207:
                     IIIiiiiIi_Class62.this.IIII_method_823c30c2();
                     break;
                  case ii_field_c6ed7207:
                     IIIiiiiIi_Class62.this.IIIi_method_824abca2();
                     break;
                  case III_field_c6ed7207:
                     IIIiiiiIi_Class62.this.IIiI_method_83ff20e2();
                     break;
                  case IIi_field_c6ed7207:
                     IIIiiiiIi_Class62.this.IIii_method_840dacc2();
                     break;
                  case IiI_field_c6ed7207:
                     IIIiiiiIi_Class62.this.IiIi_method_b8e5d082();
               }
            }
         }

         @Override
         public int I_method_f12c6485() {
            return -1;
         }
      };
      this.I_field_ba20ca4c = new BooleanSetting(var1, "modules.settings.auto_farm.mushroom.pickup", () -> !this.isSelected()).I_method_decd82b5();
      this.i_field_ba20ca4c = new BooleanSetting(var1, "modules.settings.auto_farm.mushroom.auto_deposit", () -> !this.isSelected());
      this.II_field_ba20ca4c = new BooleanSetting(var1, "modules.settings.auto_farm.mushroom.auto_refill", () -> !this.isSelected()).I_method_decd82b5();
   }

   @Override
   public void I_method_a0f53e1f() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         BlockPos var1 = this.i_method_863e5a31();
         if (var1 == null) {
            this.I_method_cac07269("modules.mushroom_farm.no_dirt");
            this.iI_method_8024b102();
         } else if (!this.i_method_1468d26b(Items.BROWN_MUSHROOM)) {
            this.I_method_cac07269("modules.mushroom_farm.no_mushroom");
            this.iI_method_8024b102();
         } else if (!this.i_method_1468d26b(Items.BONE_MEAL)) {
            this.I_method_cac07269("modules.mushroom_farm.no_bonemeal");
            this.iI_method_8024b102();
         } else {
            if (!this.i_method_ccd3d3d2(var0 -> var0.getItem() instanceof AxeItem)) {
               this.i_method_9b77c649("modules.mushroom_farm.no_axe_recommend");
            }

            this.I_field_670402ba = var1;
            this.i_field_670402ba = I_field_3a9bda27.player.getBlockPos();
            this.IiI_field_49 = 0;
            this.IIII_field_49 = 0;
            this.iIi_field_49 = Integer.MAX_VALUE;
            this.I_field_a56a8dc5.clear();
            this.I_method_56202a02(IIIiiiiIi_Class62.Nested1_b9e8f480.I_field_c6ed7207);
         }
      } else {
         this.iI_method_8024b102();
      }
   }

   @Override
   public void i_method_a103c9ff() {
      this.Iiii_method_baa8c0a2();
      this.I_field_7865b31.clear();
      this.I_field_a56a8dc5.clear();
      this.I_field_e08508f9 = null;
      this.II_field_670402ba = null;
      this.I_field_670402ba = null;
      this.i_field_670402ba = null;
      this.I_field_c6ed7207 = null;
      this.IiiI_method_ba9a34c2();
   }

   @Override
   public IIiIIIIIi_Class66 I_method_57286715() {
      if (this.I_field_c6ed7207 == null) {
         return IIiIIIIIi_Class66.I_field_e6af4a4c;
      } else {
         return switch (this.I_field_c6ed7207) {
            case I_field_c6ed7207 -> IIiIIIIIi_Class66.Ii_field_e6af4a4c;
            case i_field_c6ed7207 -> IIiIIIIIi_Class66.iI_field_e6af4a4c;
            case II_field_c6ed7207 -> IIiIIIIIi_Class66.i_field_e6af4a4c;
            case Ii_field_c6ed7207 -> IIiIIIIIi_Class66.ii_field_e6af4a4c;
            case iI_field_c6ed7207, IiI_field_c6ed7207 -> IIiIIIIIi_Class66.II_field_e6af4a4c;
            case ii_field_c6ed7207, III_field_c6ed7207 -> IIiIIIIIi_Class66.III_field_e6af4a4c;
            case IIi_field_c6ed7207 -> IIiIIIIIi_Class66.iIi_field_e6af4a4c;
         };
      }
   }

   @Override
   public ItemStack I_method_907017b9() {
      return new ItemStack(Items.BROWN_MUSHROOM);
   }

   void II_method_aca0522() {
      if (this.Ii_method_ad89106()) {
         BlockPos var1 = this.I_field_670402ba.up();
         if (this.iI_method_c8cf546()) {
            this.iIi_field_49 = Integer.MAX_VALUE;
            this.I_method_56202a02(IIIiiiiIi_Class62.Nested1_b9e8f480.II_field_c6ed7207);
         } else {
            Block var2 = I_field_3a9bda27.world.getBlockState(var1).getBlock();
            if (var2 == Blocks.BROWN_MUSHROOM) {
               this.IiI_field_49 = 0;
               this.IIII_field_49 = 0;
               this.I_method_56202a02(IIIiiiiIi_Class62.Nested1_b9e8f480.i_field_c6ed7207);
            } else if (!I_field_3a9bda27.world.getBlockState(var1).isAir()) {
               this.I_method_56202a02(IIIiiiiIi_Class62.Nested1_b9e8f480.II_field_c6ed7207);
            } else if (!this.i_method_1468d26b(Items.BROWN_MUSHROOM)) {
               if (!this.II_method_aca0526()) {
                  this.I_method_cac07269("modules.mushroom_farm.no_mushroom");
                  this.iI_method_8024b102();
               }
            } else if (!this.I_method_ea6c424b(Items.BROWN_MUSHROOM)) {
               this.I_method_cac07269("modules.mushroom_farm.no_mushroom");
               this.iI_method_8024b102();
            } else if (this.IIII_field_49 >= 20) {
               this.I_method_cac07269("modules.mushroom_farm.cant_place");
               this.iI_method_8024b102();
            } else {
               Vec3d var3 = new Vec3d(this.I_field_670402ba.getX() + 0.5, this.I_field_670402ba.getY() + 1.0, this.I_field_670402ba.getZ() + 0.5);
               if (this.I_method_d4ceb38f(var3)) {
                  if (this.i_field_991c1e8c.I_method_58432069(50L)) {
                     BlockHitResult var4 = new BlockHitResult(var3, Direction.UP, this.I_field_670402ba, false);
                     I_field_3a9bda27.interactionManager.interactBlock(I_field_3a9bda27.player, Hand.MAIN_HAND, var4);
                     I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
                     this.i_field_991c1e8c.I_method_23e11e3f();
                     this.IIII_field_49++;
                  }
               }
            }
         }
      }
   }

   void ii_method_c9b8122() {
      if (this.Ii_method_ad89106()) {
         if (this.iI_method_c8cf546()) {
            this.iIi_field_49 = Integer.MAX_VALUE;
            this.I_method_56202a02(IIIiiiiIi_Class62.Nested1_b9e8f480.II_field_c6ed7207);
         } else {
            BlockPos var1 = this.I_field_670402ba.up();
            if (I_field_3a9bda27.world.getBlockState(var1).getBlock() != Blocks.BROWN_MUSHROOM) {
               this.I_method_56202a02(IIIiiiiIi_Class62.Nested1_b9e8f480.I_field_c6ed7207);
            } else if (this.IiI_field_49 >= 64) {
               this.I_method_cac07269("modules.mushroom_farm.no_grow_space");
               this.iI_method_8024b102();
            } else if (!this.i_method_1468d26b(Items.BONE_MEAL)) {
               if (!this.II_method_aca0526()) {
                  this.I_method_cac07269("modules.mushroom_farm.no_bonemeal");
                  this.iI_method_8024b102();
               }
            } else if (!this.I_method_ea6c424b(Items.BONE_MEAL)) {
               this.I_method_cac07269("modules.mushroom_farm.no_bonemeal");
               this.iI_method_8024b102();
            } else {
               Vec3d var2 = new Vec3d(var1.getX() + 0.5, var1.getY() + 0.5, var1.getZ() + 0.5);
               if (this.I_method_d4ceb38f(var2)) {
                  if (this.I_field_991c1e8c.I_method_58432069(60L)) {
                     BlockHitResult var3 = new BlockHitResult(var2, Direction.UP, var1, false);
                     I_field_3a9bda27.interactionManager.interactBlock(I_field_3a9bda27.player, Hand.MAIN_HAND, var3);
                     I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
                     this.IiI_field_49++;
                     this.I_field_991c1e8c.I_method_23e11e3f();
                  }
               }
            }
         }
      }
   }

   void III_method_4e85967f() {
      int var1 = this.i_method_8cca41f2();
      if (var1 == 0) {
         this.Iiii_method_baa8c0a2();
         this.IIi_method_4e94225f();
      } else {
         if (this.iIi_field_49 == Integer.MAX_VALUE || var1 < this.iIi_field_49) {
            this.iIi_field_49 = var1;
            this.Ii_field_4a = System.currentTimeMillis();
         }

         BlockPos var2 = this.II_method_91dac76e();
         if (var2 != null) {
            this.Iiii_method_baa8c0a2();
            this.I_method_eeaa6bd4(I_field_3a9bda27.world.getBlockState(var2));
            Direction var5 = this.I_method_c89c9f9(var2);
            Vec3d var6 = this.I_method_3f7fd631(var2, var5);
            if (this.I_method_d4ceb38f(var6)) {
               if (this.i_field_991c1e8c.I_method_58432069(50L)) {
                  I_field_3a9bda27.interactionManager.attackBlock(var2, var5);
                  I_field_3a9bda27.interactionManager.updateBlockBreakingProgress(var2, var5);
                  I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
                  this.i_field_991c1e8c.I_method_23e11e3f();
               }
            }
         } else if (!this.ii_method_c9b8126()) {
            this.i_method_9b77c649("modules.mushroom_farm.unreachable");
            this.iI_method_8024b102();
         } else if (System.currentTimeMillis() - this.Ii_field_4a > 30000L) {
            this.Iiii_method_baa8c0a2();
            this.i_method_9b77c649("modules.mushroom_farm.unreachable");
            this.iI_method_8024b102();
         } else {
            BlockPos var3 = this.Ii_method_6d5378e();
            if (var3 == null) {
               this.IIi_method_4e94225f();
            } else {
               BlockPos var4 = new BlockPos(var3.getX(), this.i_field_670402ba.getY(), var3.getZ());
               if (!this.I_field_5a) {
                  iiIiIiIii_Class428.I_method_483e9b95().I_method_1e95cc67(new iiiIIiiII_Class461(var4, 1));
                  this.I_field_5a = true;
                  this.iI_field_4a = System.currentTimeMillis();
               } else if (!iiIiIiIii_Class428.I_method_483e9b95().I_method_1381fa63()) {
                  this.I_field_5a = false;
               }
            }
         }
      }
   }

   private void IIi_method_4e94225f() {
      this.Iiii_method_baa8c0a2();
      this.IiiI_method_ba9a34c2();
      this.IiI_field_49 = 0;
      this.iIi_field_49 = Integer.MAX_VALUE;
      if (this.I_field_ba20ca4c.i_method_9b12da03() && this.ii_method_c9b8126()) {
         this.iII_method_8520aa5f();
         this.I_method_56202a02(IIIiiiiIi_Class62.Nested1_b9e8f480.Ii_field_c6ed7207);
         this.IiI_method_5048869f();
      } else {
         this.iIi_method_852f363f();
      }
   }

   private void IiI_method_5048869f() {
      this.I_field_e08508f9 = null;
      this.I_field_5a = false;

      while (!this.I_field_7865b31.isEmpty()) {
         ItemEntity var1 = this.I_field_7865b31.removeFirst();
         if (var1 != null && !var1.isRemoved() && var1.isAlive()) {
            this.I_field_e08508f9 = var1;
            return;
         }
      }

      this.iIi_method_852f363f();
   }

   void Iii_method_5057127f() {
      if (this.I_field_e08508f9 == null) {
         this.IiI_method_5048869f();
      } else if (!this.I_field_e08508f9.isRemoved() && this.I_field_e08508f9.isAlive()) {
         Vec3d var1 = this.I_field_e08508f9.getPos();
         if (I_field_3a9bda27.player.getPos().squaredDistanceTo(var1) <= 1.9599999999999997) {
            this.Iiii_method_baa8c0a2();
            this.IiI_method_5048869f();
         } else if (!this.I_field_5a) {
            BlockPos var2 = BlockPos.ofFloored(var1);
            iiIiIiIii_Class428.I_method_483e9b95().I_method_1e95cc67(new iiiIIiiIi_Class462(var2.getX(), var2.getZ()));
            this.I_field_5a = true;
            this.iI_field_4a = System.currentTimeMillis();
         } else if (!iiIiIiIii_Class428.I_method_483e9b95().I_method_1381fa63()) {
            this.I_field_5a = false;
         } else {
            if (System.currentTimeMillis() - this.iI_field_4a > 10000L) {
               this.Iiii_method_baa8c0a2();
               this.IiI_method_5048869f();
            }
         }
      } else {
         this.Iiii_method_baa8c0a2();
         this.IiI_method_5048869f();
      }
   }

   private void iII_method_8520aa5f() {
      this.I_field_7865b31.clear();
      Vec3d var1 = I_field_3a9bda27.player.getPos();
      double var2 = 15.0;
      double var4 = var2 * var2;
      ArrayList var6 = new ArrayList();

      for (Entity var8 : I_field_3a9bda27.world.getEntities()) {
         if (var8 instanceof ItemEntity var9
            && !var9.isRemoved()
            && var9.isAlive()
            && !(var1.squaredDistanceTo(var9.getPos()) > var4)
            && this.i_method_cb071325(var9.getStack())) {
            var6.add(var9);
         }
      }

      var6.sort(Comparator.comparingDouble(var1x -> var1.squaredDistanceTo(((net.minecraft.entity.Entity)var1x).getPos())));
      this.I_field_7865b31.addAll(var6);
   }

   private void iIi_method_852f363f() {
      if (this.I_method_8cbbb623()) {
         this.iiI_method_86e39a7f();
      } else {
         this.IiII_method_b8d744a2();
      }
   }

   private boolean I_method_8cbbb623() {
      if (!this.i_field_ba20ca4c.i_method_9b12da03()) {
         return false;
      } else {
         PlayerInventory var1 = I_field_3a9bda27.player.getInventory();
         return var1.getEmptySlot() != -1 ? false : this.i_method_8cca4203();
      }
   }

   private boolean i_method_8cca4203() {
      PlayerInventory var1 = I_field_3a9bda27.player.getInventory();
      int var2 = 0;

      for (int var3 = 0; var3 < var1.size(); var3++) {
         ItemStack var4 = var1.getStack(var3);
         if (var4.getItem() == Items.BROWN_MUSHROOM) {
            var2 += var4.getCount();
         }
      }

      return var2 > Items.BROWN_MUSHROOM.getDefaultStack().getMaxCount();
   }

   private void iiI_method_86e39a7f() {
      this.Iiii_method_baa8c0a2();
      this.IiiI_method_ba9a34c2();
      this.I_field_5a = false;
      this.Iii_field_49 = -1;
      this.iII_field_49 = -1;
      this.I_field_c6ed6e27 = IIIiiiiIi_Class62.Nested1_b9e8f460.I_field_c6ed6e27;
      BlockPos var1 = this.I_method_1143ea11();
      if (var1 == null) {
         this.i_method_9b77c649("modules.mushroom_farm.no_chest");
         this.IiII_method_b8d744a2();
      } else {
         this.II_field_670402ba = var1;
         if (this.i_method_dffed1bd(var1)) {
            this.I_method_56202a02(IIIiiiiIi_Class62.Nested1_b9e8f480.ii_field_c6ed7207);
            this.i_field_991c1e8c.I_method_23e11e3f();
         } else if (this.ii_method_c9b8126()) {
            this.I_method_56202a02(IIIiiiiIi_Class62.Nested1_b9e8f480.iI_field_c6ed7207);
         } else {
            this.i_method_9b77c649("modules.mushroom_farm.no_chest");
            this.IiII_method_b8d744a2();
         }
      }
   }

   private boolean II_method_aca0526() {
      if (!this.II_field_ba20ca4c.i_method_9b12da03()) {
         return false;
      } else {
         BlockPos var1 = this.I_method_1143ea11();
         if (var1 == null) {
            return false;
         } else if (!this.i_method_dffed1bd(var1) && !this.ii_method_c9b8126()) {
            return false;
         } else {
            this.Iiii_method_baa8c0a2();
            this.IiiI_method_ba9a34c2();
            this.I_field_5a = false;
            this.Iii_field_49 = -1;
            this.iII_field_49 = -1;
            this.I_field_c6ed6e27 = IIIiiiiIi_Class62.Nested1_b9e8f460.i_field_c6ed6e27;
            this.II_field_670402ba = var1;
            if (this.i_method_dffed1bd(var1)) {
               this.I_method_56202a02(IIIiiiiIi_Class62.Nested1_b9e8f480.ii_field_c6ed7207);
               this.i_field_991c1e8c.I_method_23e11e3f();
            } else {
               this.I_method_56202a02(IIIiiiiIi_Class62.Nested1_b9e8f480.iI_field_c6ed7207);
            }

            return true;
         }
      }
   }

   private void iii_method_86f2265f() {
      if (this.I_field_c6ed6e27 == IIIiiiiIi_Class62.Nested1_b9e8f460.i_field_c6ed6e27) {
         if (!this.II_method_aca0526()) {
            this.i_method_9b77c649("modules.mushroom_farm.no_chest");
            this.IiII_method_b8d744a2();
         }
      } else {
         this.iiI_method_86e39a7f();
      }
   }

   private BlockPos I_method_1143ea11() {
      BlockPos var1 = I_field_3a9bda27.player.getBlockPos();
      byte var2 = 15;
      BlockPos var3 = null;
      double var4 = Double.MAX_VALUE;

      for (BlockPos var7 : BlockPos.iterateOutwards(var1, var2, var2, var2)) {
         BlockPos var8 = var7.toImmutable();
         if (!this.I_field_a56a8dc5.contains(var8) && I_field_3a9bda27.world.getBlockEntity(var8) instanceof ChestBlockEntity) {
            double var9 = var7.getSquaredDistance(I_field_3a9bda27.player.getPos());
            if (var9 < var4) {
               var4 = var9;
               var3 = var8;
            }
         }
      }

      return var3;
   }

   void IIII_method_823c30c2() {
      if (this.II_field_670402ba == null) {
         this.IiII_method_b8d744a2();
      } else if (this.i_method_dffed1bd(this.II_field_670402ba)) {
         this.Iiii_method_baa8c0a2();
         this.I_method_56202a02(IIIiiiiIi_Class62.Nested1_b9e8f480.ii_field_c6ed7207);
         this.i_field_991c1e8c.I_method_23e11e3f();
      } else if (!this.I_field_5a) {
         iiIiIiIii_Class428.I_method_483e9b95().I_method_1e95cc67(new iiiIIiiII_Class461(this.II_field_670402ba, 2));
         this.I_field_5a = true;
         this.iI_field_4a = System.currentTimeMillis();
      } else if (!iiIiIiIii_Class428.I_method_483e9b95().I_method_1381fa63()) {
         this.I_field_5a = false;
      } else {
         if (System.currentTimeMillis() - this.iI_field_4a > 20000L) {
            this.Iiii_method_baa8c0a2();
            this.I_field_a56a8dc5.add(this.II_field_670402ba);
            this.II_field_670402ba = null;
            this.iii_method_86f2265f();
         }
      }
   }

   void IIIi_method_824abca2() {
      if (this.II_field_670402ba == null) {
         this.IiII_method_b8d744a2();
      } else if (I_field_3a9bda27.player.currentScreenHandler instanceof GenericContainerScreenHandler) {
         this.Iii_field_49 = -1;
         this.iII_field_49 = -1;
         this.i_field_991c1e8c.I_method_23e11e3f();
         this.I_method_56202a02(
            this.I_field_c6ed6e27 == IIIiiiiIi_Class62.Nested1_b9e8f460.i_field_c6ed6e27
               ? IIIiiiiIi_Class62.Nested1_b9e8f480.IIi_field_c6ed7207
               : IIIiiiiIi_Class62.Nested1_b9e8f480.III_field_c6ed7207
         );
      } else if (!this.i_method_dffed1bd(this.II_field_670402ba)) {
         this.I_field_5a = false;
         if (this.ii_method_c9b8126()) {
            this.I_method_56202a02(IIIiiiiIi_Class62.Nested1_b9e8f480.iI_field_c6ed7207);
         } else {
            this.IiII_method_b8d744a2();
         }
      } else {
         Vec3d var1 = Vec3d.ofCenter(this.II_field_670402ba);
         if (this.I_method_d4ceb38f(var1)) {
            if (this.i_field_991c1e8c.I_method_58432069(50L)) {
               BlockHitResult var2 = new BlockHitResult(var1, Direction.UP, this.II_field_670402ba, false);
               I_field_3a9bda27.interactionManager.interactBlock(I_field_3a9bda27.player, Hand.MAIN_HAND, var2);
               I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
               this.i_field_991c1e8c.I_method_23e11e3f();
            }
         }
      }
   }

   void IIiI_method_83ff20e2() {
      if (I_field_3a9bda27.player.currentScreenHandler instanceof GenericContainerScreenHandler var1) {
         if (this.i_field_991c1e8c.I_method_58432069(50L)) {
            if (this.Iii_field_49 != -1) {
               ItemStack var7 = ((Slot)var1.slots.get(this.Iii_field_49)).getStack();
               if (!var7.isEmpty() && var7.getCount() >= this.iII_field_49 && var7.getItem() == Items.BROWN_MUSHROOM) {
                  if (this.II_field_670402ba != null) {
                     this.I_field_a56a8dc5.add(this.II_field_670402ba);
                  }

                  I_field_3a9bda27.player.closeHandledScreen();
                  this.II_field_670402ba = null;
                  this.Iii_field_49 = -1;
                  this.iII_field_49 = -1;
                  this.iiI_method_86e39a7f();
                  return;
               }
            }

            int var8 = this.I_method_8cbbb612();
            DefaultedList var3 = var1.slots;

            for (int var4 = 0; var4 < var3.size(); var4++) {
               Slot var5 = (Slot)var3.get(var4);
               if (var5.inventory == I_field_3a9bda27.player.getInventory() && var5.getIndex() != var8) {
                  ItemStack var6 = var5.getStack();
                  if (var6.getItem() == Items.BROWN_MUSHROOM) {
                     iIIiIiIiI_Class299.I_method_8062c464(var4);
                     this.Iii_field_49 = var4;
                     this.iII_field_49 = var6.getCount();
                     this.i_field_991c1e8c.I_method_23e11e3f();
                     return;
                  }
               }
            }

            this.I_method_abbc095(true);
         }
      } else {
         this.I_method_abbc095(false);
      }
   }

   private int I_method_8cbbb612() {
      PlayerInventory var1 = I_field_3a9bda27.player.getInventory();
      int var2 = -1;
      int var3 = -1;

      for (int var4 = 0; var4 < var1.size(); var4++) {
         ItemStack var5 = var1.getStack(var4);
         if (var5.getItem() == Items.BROWN_MUSHROOM && var5.getCount() > var3) {
            var3 = var5.getCount();
            var2 = var4;
         }
      }

      return var2;
   }

   private void I_method_abbc095(boolean var1) {
      if (var1 && I_field_3a9bda27.currentScreen != null) {
         I_field_3a9bda27.player.closeHandledScreen();
      }

      this.II_field_670402ba = null;
      this.Iii_field_49 = -1;
      this.iII_field_49 = -1;
      this.IiII_method_b8d744a2();
   }

   void IIii_method_840dacc2() {
      if (I_field_3a9bda27.player.currentScreenHandler instanceof GenericContainerScreenHandler var1) {
         if (this.i_field_991c1e8c.I_method_58432069(50L)) {
            if (this.Iii_field_49 != -1) {
               ItemStack var6 = ((Slot)var1.slots.get(this.Iii_field_49)).getStack();
               if (!var6.isEmpty() && var6.getCount() >= this.iII_field_49 && this.I_method_270e8f45(var6)) {
                  this.i_method_c7eb0b5(true);
                  return;
               }
            }

            DefaultedList var7 = var1.slots;

            for (int var3 = 0; var3 < var7.size(); var3++) {
               Slot var4 = (Slot)var7.get(var3);
               if (var4.inventory != I_field_3a9bda27.player.getInventory()) {
                  ItemStack var5 = var4.getStack();
                  if (this.I_method_270e8f45(var5)) {
                     iIIiIiIiI_Class299.I_method_8062c464(var3);
                     this.Iii_field_49 = var3;
                     this.iII_field_49 = var5.getCount();
                     this.i_field_991c1e8c.I_method_23e11e3f();
                     return;
                  }
               }
            }

            this.i_method_c7eb0b5(true);
         }
      } else {
         this.i_method_c7eb0b5(false);
      }
   }

   private boolean I_method_270e8f45(ItemStack var1) {
      if (var1.isEmpty()) {
         return false;
      } else if (var1.getItem() == Items.BONE_MEAL) {
         return this.I_method_ea6c423a(Items.BONE_MEAL) < 192;
      } else {
         return var1.getItem() == Items.BROWN_MUSHROOM ? this.I_method_ea6c423a(Items.BROWN_MUSHROOM) < 16 : false;
      }
   }

   private void i_method_c7eb0b5(boolean var1) {
      if (var1 && I_field_3a9bda27.currentScreen != null) {
         I_field_3a9bda27.player.closeHandledScreen();
      }

      this.II_field_670402ba = null;
      this.Iii_field_49 = -1;
      this.iII_field_49 = -1;
      if (this.I_method_ea6c423a(Items.BONE_MEAL) == 0) {
         this.I_method_cac07269("modules.mushroom_farm.no_bonemeal");
         this.iI_method_8024b102();
      } else {
         this.IiII_method_b8d744a2();
      }
   }

   private int I_method_ea6c423a(Item var1) {
      PlayerInventory var2 = I_field_3a9bda27.player.getInventory();
      int var3 = 0;

      for (int var4 = 0; var4 < var2.size(); var4++) {
         ItemStack var5 = var2.getStack(var4);
         if (var5.getItem() == var1) {
            var3 += var5.getCount();
         }
      }

      return var3;
   }

   private void IiII_method_b8d744a2() {
      this.Iiii_method_baa8c0a2();
      this.IiiI_method_ba9a34c2();
      this.I_field_5a = false;
      if (this.ii_method_c9b8126() && !this.i_method_dffed1bd(this.I_field_670402ba)) {
         this.I_method_56202a02(IIIiiiiIi_Class62.Nested1_b9e8f480.IiI_field_c6ed7207);
      } else {
         this.i_field_991c1e8c.I_method_23e11e3f();
         this.I_method_56202a02(IIIiiiiIi_Class62.Nested1_b9e8f480.I_field_c6ed7207);
      }
   }

   void IiIi_method_b8e5d082() {
      if (this.i_method_dffed1bd(this.I_field_670402ba) || !this.ii_method_c9b8126()) {
         this.Iiii_method_baa8c0a2();
         this.i_field_991c1e8c.I_method_23e11e3f();
         this.I_method_56202a02(IIIiiiiIi_Class62.Nested1_b9e8f480.I_field_c6ed7207);
      } else if (!this.I_field_5a) {
         iiIiIiIii_Class428.I_method_483e9b95().I_method_1e95cc67(new iiiIIiiII_Class461(this.i_field_670402ba, 1));
         this.I_field_5a = true;
         this.iI_field_4a = System.currentTimeMillis();
      } else if (!iiIiIiIii_Class428.I_method_483e9b95().I_method_1381fa63()) {
         this.I_field_5a = false;
      } else {
         if (System.currentTimeMillis() - this.iI_field_4a > 20000L) {
            this.Iiii_method_baa8c0a2();
            this.I_method_56202a02(IIIiiiiIi_Class62.Nested1_b9e8f480.I_field_c6ed7207);
         }
      }
   }

   private boolean Ii_method_ad89106() {
      BlockState var1 = I_field_3a9bda27.world.getBlockState(this.I_field_670402ba);
      Block var2 = var1.getBlock();
      if (I_method_3b8ca58f(var2)) {
         return true;
      } else if (!var1.isAir()) {
         return true;
      } else {
         Predicate var3 = var0 -> ((net.minecraft.item.ItemStack)var0).getItem() == Items.DIRT || ((net.minecraft.item.ItemStack)var0).getItem() == Items.GRASS_BLOCK;
         if (!this.I_method_28db4ff2(var3)) {
            this.I_method_cac07269("modules.mushroom_farm.no_dirt_item");
            this.iI_method_8024b102();
            return false;
         } else {
            Direction[] var4 = new Direction[]{Direction.DOWN, Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST, Direction.UP};
            double var5 = I_field_3a9bda27.player.getBlockInteractionRange();
            double var7 = var5 * var5;

            for (Direction var12 : var4) {
               BlockPos var13 = this.I_field_670402ba.offset(var12);
               Direction var14 = var12.getOpposite();
               BlockState var15 = I_field_3a9bda27.world.getBlockState(var13);
               if (var15.isSideSolidFullSquare(I_field_3a9bda27.world, var13, var14)) {
                  Vec3d var16 = Vec3d.ofCenter(var13).add(var14.getOffsetX() * 0.5, var14.getOffsetY() * 0.5, var14.getOffsetZ() * 0.5);
                  if (!(I_field_3a9bda27.player.getEyePos().squaredDistanceTo(var16) > var7)) {
                     if (!this.I_method_d4ceb38f(var16)) {
                        return false;
                     }

                     BlockHitResult var17 = new BlockHitResult(var16, var14, var13, false);
                     I_field_3a9bda27.interactionManager.interactBlock(I_field_3a9bda27.player, Hand.MAIN_HAND, var17);
                     I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
                     return false;
                  }
               }
            }

            this.I_method_cac07269("modules.mushroom_farm.no_dirt_support");
            this.iI_method_8024b102();
            return false;
         }
      }
   }

   private BlockPos i_method_863e5a31() {
      BlockPos var1 = I_field_3a9bda27.player.getBlockPos();
      Vec3d var2 = I_field_3a9bda27.player.getEyePos();
      double var3 = I_field_3a9bda27.player.getBlockInteractionRange();
      double var5 = var3 * var3;
      BlockPos var7 = null;
      double var8 = Double.MAX_VALUE;

      for (int var10 = -4; var10 <= 4; var10++) {
         for (int var11 = -4; var11 <= 4; var11++) {
            for (int var12 = -4; var12 <= 4; var12++) {
               BlockPos var13 = var1.add(var10, var11, var12);
               if (this.I_method_b5ab3ddd(var13)) {
                  double var14 = var2.squaredDistanceTo(Vec3d.ofCenter(var13.up()));
                  if (!(var14 > var5) && var14 < var8) {
                     var8 = var14;
                     var7 = var13.toImmutable();
                  }
               }
            }
         }
      }

      return var7;
   }

   private boolean I_method_b5ab3ddd(BlockPos var1) {
      return !I_method_3b8ca58f(I_field_3a9bda27.world.getBlockState(var1).getBlock()) ? false : I_field_3a9bda27.world.getBlockState(var1.up()).isAir();
   }

   private boolean iI_method_c8cf546() {
      BlockPos var1 = this.I_field_670402ba.up();

      for (int var2 = -1; var2 <= 12; var2++) {
         for (int var3 = -7; var3 <= 7; var3++) {
            for (int var4 = -7; var4 <= 7; var4++) {
               if (i_method_d8a5adaf(I_field_3a9bda27.world.getBlockState(var1.add(var3, var2, var4)).getBlock())) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   private int i_method_8cca41f2() {
      BlockPos var1 = this.I_field_670402ba.up();
      int var2 = 0;

      for (int var3 = -1; var3 <= 12; var3++) {
         for (int var4 = -7; var4 <= 7; var4++) {
            for (int var5 = -7; var5 <= 7; var5++) {
               if (i_method_d8a5adaf(I_field_3a9bda27.world.getBlockState(var1.add(var4, var3, var5)).getBlock())) {
                  var2++;
               }
            }
         }
      }

      return var2;
   }

   private BlockPos II_method_91dac76e() {
      BlockPos var1 = this.I_field_670402ba.up();
      Vec3d var2 = I_field_3a9bda27.player.getEyePos();
      double var3 = I_field_3a9bda27.player.getBlockInteractionRange();
      double var5 = var3 * var3;
      BlockPos var7 = null;
      int var8 = Integer.MAX_VALUE;
      double var9 = Double.MAX_VALUE;

      for (int var11 = -1; var11 <= 12; var11++) {
         for (int var12 = -7; var12 <= 7; var12++) {
            for (int var13 = -7; var13 <= 7; var13++) {
               BlockPos var14 = var1.add(var12, var11, var13);
               if (i_method_d8a5adaf(I_field_3a9bda27.world.getBlockState(var14).getBlock())) {
                  double var15 = var2.squaredDistanceTo(Vec3d.ofCenter(var14));
                  if (!(var15 > var5)) {
                     int var17 = var14.getY();
                     if (var17 < var8 || var17 == var8 && var15 < var9) {
                        var8 = var17;
                        var9 = var15;
                        var7 = var14.toImmutable();
                     }
                  }
               }
            }
         }
      }

      return var7;
   }

   private BlockPos Ii_method_6d5378e() {
      BlockPos var1 = this.I_field_670402ba.up();
      Vec3d var2 = I_field_3a9bda27.player.getPos();
      BlockPos var3 = null;
      int var4 = Integer.MAX_VALUE;
      double var5 = Double.MAX_VALUE;

      for (int var7 = -1; var7 <= 12; var7++) {
         for (int var8 = -7; var8 <= 7; var8++) {
            for (int var9 = -7; var9 <= 7; var9++) {
               BlockPos var10 = var1.add(var8, var7, var9);
               if (i_method_d8a5adaf(I_field_3a9bda27.world.getBlockState(var10).getBlock())) {
                  double var11 = Vec3d.ofCenter(var10).squaredDistanceTo(var2);
                  int var13 = var10.getY();
                  if (var13 < var4 || var13 == var4 && var11 < var5) {
                     var4 = var13;
                     var5 = var11;
                     var3 = var10.toImmutable();
                  }
               }
            }
         }
      }

      return var3;
   }

   private void I_method_eeaa6bd4(BlockState var1) {
      Predicate var2 = var0 -> ((net.minecraft.item.ItemStack)var0).getItem() instanceof AxeItem;
      ItemStack var3 = I_field_3a9bda27.player.getMainHandStack();
      IIIiiiiIi_Class62.Nested1_833597e9 var4 = this.I_method_1520d6d7(var3, var1, var2);
      iIIiIiIii_Class300 var5 = null;

      for (iIIiIiIii_Class300 var7 : iIIiiIiIi_Class310.I_method_6a489695().I_method_fdeecb5d(iIIiiIiIi_Class310.i_method_7fde0a75()).I_method_617d3e68()) {
         ItemStack var8 = var7.I_method_7b7e0bb9();
         IIIiiiiIi_Class62.Nested1_833597e9 var9 = this.I_method_1520d6d7(var8, var1, var2);
         if (var9.I_method_5b38e59b(var4)) {
            var4 = var9;
            var5 = var7;
         }
      }

      if (var4.I_method_71f3f575()) {
         if (var5 instanceof iIIiiiIii_Class316 var10) {
            iIIiIiIiI_Class299.I_method_4c2ca067(var10);
         } else if (var5 instanceof iIIiiiiII_Class317 var11) {
            int var12 = I_field_3a9bda27.player.getInventory().selectedSlot;
            iIIiIiIiI_Class299.iI_method_c617e8c2(var11.I_method_dfe89252(), var12);
         }
      }
   }

   private IIIiiiiIi_Class62.Nested1_833597e9 I_method_1520d6d7(ItemStack var1, BlockState var2, Predicate<ItemStack> var3) {
      if (var1 != null && !var1.isEmpty() && var3.test(var1)) {
         float var4 = var1.getMiningSpeedMultiplier(var2);
         int var5 = iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.EFFICIENCY);
         if (var4 > 1.0F && var5 > 0) {
            var4 += var5 * var5 + 1.0F;
         }

         return new IIIiiiiIi_Class62.Nested1_833597e9(var4, var5, I_method_270e8f31(var1));
      } else {
         return new IIIiiiiIi_Class62.Nested1_833597e9(-1.0F, -1, -1.0F);
      }
   }

   private static float I_method_270e8f31(ItemStack var0) {
      if (!var0.isEmpty() && var0.isDamageable()) {
         int var1 = var0.getMaxDamage();
         return var1 <= 0 ? 1.0F : (float)(var1 - var0.getDamage()) / var1;
      } else {
         return 1.0F;
      }
   }

   private boolean I_method_ea6c424b(Item var1) {
      return this.I_method_28db4ff2(var1x -> var1x.getItem() == var1);
   }

   private boolean I_method_28db4ff2(Predicate<ItemStack> var1) {
      if (var1.test(I_field_3a9bda27.player.getMainHandStack())) {
         return true;
      } else {
         iIIiiiIii_Class316 var2 = iIIiiIiIi_Class310.I_method_6a489695().I_method_77fa4424(var1);
         if (var2 != null) {
            iIIiIiIiI_Class299.I_method_4c2ca067(var2);
            return true;
         } else {
            iIIiiiiII_Class317 var3 = iIIiiIiIi_Class310.i_method_7fde0a75().I_method_77fa4424(var1);
            if (var3 != null) {
               int var4 = I_field_3a9bda27.player.getInventory().selectedSlot;
               iIIiIiIiI_Class299.iI_method_c617e8c2(var3.I_method_dfe89252(), var4);
               return true;
            } else {
               return false;
            }
         }
      }
   }

   private boolean i_method_cb071325(ItemStack var1) {
      return var1.getItem() == Items.BROWN_MUSHROOM;
   }

   private boolean i_method_1468d26b(Item var1) {
      return iIIiiIiIi_Class310.I_method_6a489695().I_method_c9799e6b(var1) || iIIiiIiIi_Class310.i_method_7fde0a75().I_method_c9799e6b(var1);
   }

   private boolean i_method_ccd3d3d2(Predicate<ItemStack> var1) {
      return iIIiiIiIi_Class310.I_method_6a489695().I_method_77fa4424(var1) != null || iIIiiIiIi_Class310.i_method_7fde0a75().I_method_77fa4424(var1) != null;
   }

   private boolean I_method_d4ceb38f(Vec3d var1) {
      iiIIiIIii_Class404 var2 = iiIIiIiIi_Class406.I_method_bc8095a1(var1);
      if (this.I_field_32e13e6c == null || this.I_field_32e13e6c.I_method_24e31c97(var2) > 0.5F) {
         this.I_field_32e13e6c = var2;
         this.iiI_field_49 = 0;
         this.iii_field_49 = 0;
      }

      RockstarClient.getInstance()
         .I_method_58785402()
         .I_method_1acbf705(var2, iiIIiIIIi_Class402.Ii_field_32e0c64c, 180.0F, 180.0F, 180.0F, iiIIiIiiI_Class407.iI_field_32efc66c);
      this.iii_field_49++;
      iiIIiIIii_Class404 var3 = RockstarClient.getInstance().I_method_58785402().II_method_f098f858();
      if (var3 != null && var3.I_method_24e31c97(var2) <= 1.0F) {
         this.iiI_field_49++;
         return this.iiI_field_49 >= 1;
      } else {
         return this.iii_field_49 > 20;
      }
   }

   private void IiiI_method_ba9a34c2() {
      this.I_field_32e13e6c = null;
      this.iiI_field_49 = 0;
      this.iii_field_49 = 0;
   }

   private boolean i_method_dffed1bd(BlockPos var1) {
      double var2 = I_field_3a9bda27.player.getBlockInteractionRange();
      return I_field_3a9bda27.player.getEyePos().squaredDistanceTo(Vec3d.ofCenter(var1)) <= var2 * var2;
   }

   private Direction I_method_c89c9f9(BlockPos var1) {
      Vec3d var2 = I_field_3a9bda27.player.getEyePos();
      Vec3d var3 = Vec3d.ofCenter(var1);
      double var4 = var2.x - var3.x;
      double var6 = var2.y - var3.y;
      double var8 = var2.z - var3.z;
      double var10 = Math.abs(var4);
      double var12 = Math.abs(var6);
      double var14 = Math.abs(var8);
      if (var12 >= var10 && var12 >= var14) {
         return var6 >= 0.0 ? Direction.UP : Direction.DOWN;
      } else if (var10 >= var14) {
         return var4 >= 0.0 ? Direction.EAST : Direction.WEST;
      } else {
         return var8 >= 0.0 ? Direction.SOUTH : Direction.NORTH;
      }
   }

   private Vec3d I_method_3f7fd631(BlockPos var1, Direction var2) {
      return Vec3d.ofCenter(var1).add(var2.getOffsetX() * 0.5, var2.getOffsetY() * 0.5, var2.getOffsetZ() * 0.5);
   }

   private void Iiii_method_baa8c0a2() {
      if (iiIiIiIii_Class428.I_method_b0496283() && iiIiIiIii_Class428.I_method_483e9b95().I_method_1381fa63()) {
         iiIiIiIii_Class428.I_method_483e9b95().I_method_1381fa5f();
      }

      this.I_field_5a = false;
   }

   private boolean ii_method_c9b8126() {
      return iiIiIiIii_Class428.I_method_b0496283();
   }

   private void I_method_56202a02(IIIiiiiIi_Class62.Nested1_b9e8f480 var1) {
      this.I_field_c6ed7207 = var1;
      this.IiiI_method_ba9a34c2();
   }

   private static boolean I_method_3b8ca58f(Block var0) {
      return var0 == Blocks.GRASS_BLOCK || var0 == Blocks.DIRT;
   }

   private static boolean i_method_d8a5adaf(Block var0) {
      return var0 == Blocks.BROWN_MUSHROOM_BLOCK || var0 == Blocks.MUSHROOM_STEM;
   }

   static final class Nested1_833597e9 {
      private final float I_field_46;
      private final int I_field_49;
      private final float i_field_46;

      Nested1_833597e9(float var1, int var2, float var3) {
         this.I_field_46 = var1;
         this.I_field_49 = var2;
         this.i_field_46 = var3;
      }

      boolean I_method_71f3f575() {
         return this.I_field_46 >= 0.0F;
      }

      boolean I_method_5b38e59b(IIIiiiiIi_Class62.Nested1_833597e9 var1) {
         if (this.I_field_46 != var1.I_field_46) {
            return this.I_field_46 > var1.I_field_46;
         } else {
            return this.I_field_49 != var1.I_field_49 ? this.I_field_49 > var1.I_field_49 : this.i_field_46 > var1.i_field_46;
         }
      }

      @Override
      public final String toString() {
         return "Nested1_833597e9[miningSpeed=" + this.I_field_46 + ", efficiency=" + this.I_field_49 + ", durability=" + this.i_field_46 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_46);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IIIiiiiIi_Class62.Nested1_833597e9 other = (IIIiiiiIi_Class62.Nested1_833597e9) var1;
         return java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46);
      }

      public float I_method_71f3f561() {
         return this.I_field_46;
      }

      public int I_method_71f3f564() {
         return this.I_field_49;
      }

      public float i_method_72028141() {
         return this.i_field_46;
      }
   }

   static enum Nested1_b9e8f460 {
      I_field_c6ed6e27,
      i_field_c6ed6e27;
   }

   static enum Nested1_b9e8f480 {
      I_field_c6ed7207,
      i_field_c6ed7207,
      II_field_c6ed7207,
      Ii_field_c6ed7207,
      iI_field_c6ed7207,
      ii_field_c6ed7207,
      III_field_c6ed7207,
      IIi_field_c6ed7207,
      IiI_field_c6ed7207;
   }
}
