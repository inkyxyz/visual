package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import pyrock.events.player.ClientPlayerTickEvent;

public class IIIiiIiii_Class56 extends IIIiiiIii_Class60 {
   private static final int I_field_49 = 4;
   private static final int i_field_49 = 5;
   private static final float I_field_46 = 0.1F;
   private static final int II_field_49 = 2;
   private final SliderSetting I_field_73178e8c;
   BlockPos I_field_670402ba;
   IIIiiIiii_Class56.Nested1_835c6c60 I_field_2be8f627;
   private int Ii_field_49;
   private int iI_field_49;
   private iiIIiIIii_Class404 I_field_32e13e6c;
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private final iiIiIIiii_Class424 i_field_991c1e8c = new iiIiIIiii_Class424();
   private boolean I_field_5a;
   private static final long I_field_4a = 30000L;
   private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = new IiIIIiII_Class69<ClientPlayerTickEvent>() {
      public void onEvent(ClientPlayerTickEvent var1) {
         if (iIIiIIiIi_Class294.I_field_3a9bda27.player != null
            && iIIiIIiIi_Class294.I_field_3a9bda27.world != null
            && IIIiiIiii_Class56.this.I_field_670402ba != null
            && IIIiiIiii_Class56.this.I_field_2be8f627 != null) {
            if (IIIiiIiii_Class56.this.I_method_a0f53e23()) {
               switch (IIIiiIiii_Class56.this.I_field_2be8f627) {
                  case I_field_2be8f627:
                     IIIiiIiii_Class56.this.II_method_7dc17d22();
                     break;
                  case i_field_2be8f627:
                     IIIiiIiii_Class56.this.ii_method_7f92f922();
                     break;
                  case II_field_2be8f627:
                     IIIiiIiii_Class56.this.I_method_7db33895(true);
                     break;
                  case Ii_field_2be8f627:
                     IIIiiIiii_Class56.this.I_method_7db33895(false);
               }
            }
         }
      }

      @Override
      public int I_method_f12c6485() {
         return -1;
      }
   };

   public IIIiiIiii_Class56(AutoFarmModule var1, ModeSetting var2) {
      super(var1, var2, "modules.settings.auto_farm.modes.apple");
      this.I_field_73178e8c = new SliderSetting(var1, "modules.settings.auto_farm.apple.bonemeal_delay", () -> !this.isSelected())
         .II_method_b0f56334(10.0F)
         .I_method_c8c9a7d7(0.0F)
         .i_method_65e2aff7(1000.0F)
         .Ii_method_4e0e6b54(150.0F)
         .I_method_d41e7abf("ms");
   }

   @Override
   public void I_method_a0f53e1f() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         List var1 = this.I_method_9b56b248();
         if (var1.isEmpty()) {
            this.I_method_cac07269("modules.apple_farm.no_dirt");
            this.iI_method_8024b102();
         } else {
            if (var1.size() > 1) {
               this.i_method_9b77c649("modules.apple_farm.multiple_dirt");
            }

            if (!this.i_method_76784a6b(Items.OAK_SAPLING)) {
               this.I_method_cac07269("modules.apple_farm.no_sapling");
               this.iI_method_8024b102();
            } else if (!this.i_method_76784a6b(Items.BONE_MEAL)) {
               this.I_method_cac07269("modules.apple_farm.no_bonemeal");
               this.iI_method_8024b102();
            } else {
               if (!this.II_method_75852fb5(var0 -> var0.getItem() instanceof HoeItem)) {
                  this.i_method_9b77c649("modules.apple_farm.no_hoe_recommend");
               }

               this.I_field_670402ba = this.I_method_68c45540(var1);
               this.I_method_c7de9e22(IIIiiIiii_Class56.Nested1_835c6c60.I_field_2be8f627);
               this.Ii_field_49 = 0;
            }
         }
      } else {
         this.iI_method_8024b102();
      }
   }

   private BlockPos I_method_68c45540(List<BlockPos> var1) {
      Vec3d var2 = I_field_3a9bda27.player.getEyePos();
      BlockPos var3 = (BlockPos)var1.getFirst();
      double var4 = Double.MAX_VALUE;

      for (BlockPos var7 : var1) {
         double var8 = var2.squaredDistanceTo(Vec3d.ofCenter(var7));
         if (var8 < var4) {
            var4 = var8;
            var3 = var7;
         }
      }

      return var3;
   }

   @Override
   public void i_method_a103c9ff() {
      this.I_field_670402ba = null;
      this.I_field_2be8f627 = null;
      this.I_field_32e13e6c = null;
      this.iI_field_49 = 0;
   }

   boolean I_method_a0f53e23() {
      BlockState var1 = I_field_3a9bda27.world.getBlockState(this.I_field_670402ba);
      Block var2 = var1.getBlock();
      if (var2 != Blocks.GRASS_BLOCK && var2 != Blocks.DIRT) {
         if (!var1.isAir()) {
            return true;
         } else {
            Predicate<ItemStack> var3 = var0 -> var0.getItem() == Items.DIRT || var0.getItem() == Items.GRASS_BLOCK;
            if (!this.I_method_7db6d7f2(var3)) {
               this.I_method_cac07269("modules.apple_farm.no_dirt_item");
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
                        if (!this.I_method_1b642b8f(var16)) {
                           return false;
                        }

                        BlockHitResult var17 = new BlockHitResult(var16, var14, var13, false);
                        I_field_3a9bda27.interactionManager.interactBlock(I_field_3a9bda27.player, Hand.MAIN_HAND, var17);
                        I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
                        return false;
                     }
                  }
               }

               this.I_method_cac07269("modules.apple_farm.no_dirt_support");
               this.iI_method_8024b102();
               return false;
            }
         }
      } else {
         return true;
      }
   }

   void II_method_7dc17d22() {
      BlockPos var1 = this.I_field_670402ba.up();
      Block var2 = I_field_3a9bda27.world.getBlockState(var1).getBlock();
      if (var2 == Blocks.OAK_SAPLING) {
         this.I_method_c7de9e22(IIIiiIiii_Class56.Nested1_835c6c60.i_field_2be8f627);
         this.Ii_field_49 = 0;
      } else if (!I_field_3a9bda27.world.getBlockState(var1).isAir()) {
         this.I_method_c7de9e22(IIIiiIiii_Class56.Nested1_835c6c60.Ii_field_2be8f627);
      } else if (!this.I_method_4c7bba4b(Items.OAK_SAPLING)) {
         this.I_method_cac07269("modules.apple_farm.no_sapling");
         this.iI_method_8024b102();
      } else {
         Vec3d var3 = new Vec3d(this.I_field_670402ba.getX() + 0.5, this.I_field_670402ba.getY() + 1.0, this.I_field_670402ba.getZ() + 0.5);
         if (this.I_method_1b642b8f(var3)) {
            BlockHitResult var4 = new BlockHitResult(var3, Direction.UP, this.I_field_670402ba, false);
            I_field_3a9bda27.interactionManager.interactBlock(I_field_3a9bda27.player, Hand.MAIN_HAND, var4);
            I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
         }
      }
   }

   void ii_method_7f92f922() {
      BlockPos var1 = this.I_field_670402ba.up();
      BlockState var2 = I_field_3a9bda27.world.getBlockState(var1);
      Block var3 = var2.getBlock();
      if (this.i_method_cbd659bd(var1)) {
         this.I_method_c7de9e22(IIIiiIiii_Class56.Nested1_835c6c60.Ii_field_2be8f627);
      } else if (var3 != Blocks.OAK_SAPLING) {
         this.I_method_c7de9e22(IIIiiIiii_Class56.Nested1_835c6c60.I_field_2be8f627);
      } else if (this.Ii_field_49 >= 40) {
         this.I_method_cac07269("modules.apple_farm.no_grow_space");
         this.iI_method_8024b102();
      } else if (!this.I_method_4c7bba4b(Items.BONE_MEAL)) {
         this.I_method_cac07269("modules.apple_farm.no_bonemeal");
         this.iI_method_8024b102();
      } else {
         Vec3d var4 = new Vec3d(var1.getX() + 0.5, var1.getY() + 1.0, var1.getZ() + 0.5);
         if (this.I_method_1b642b8f(var4)) {
            if (this.I_field_991c1e8c.I_method_58432069((long)this.I_field_73178e8c.Ii_method_a20abcd2())) {
               BlockHitResult var5 = new BlockHitResult(var4, Direction.UP, var1, false);
               I_field_3a9bda27.interactionManager.interactBlock(I_field_3a9bda27.player, Hand.MAIN_HAND, var5);
               I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
               this.Ii_field_49++;
               this.I_field_991c1e8c.I_method_23e11e3f();
            }
         }
      }
   }

   void I_method_7db33895(boolean var1) {
      Predicate<Block> var2 = var1 ? IIIiiIiii_Class56::i_method_f4b725af : IIIiiIiii_Class56::I_method_579e1d8f;
      BlockPos var3 = this.I_method_f0a07e22(var2);
      if (var3 == null) {
         if (var1) {
            if (this.I_method_f0a07e22(IIIiiIiii_Class56::I_method_579e1d8f) != null) {
               this.I_method_c7de9e22(IIIiiIiii_Class56.Nested1_835c6c60.Ii_field_2be8f627);
               return;
            }

            if (this.i_method_21af5bd2(IIIiiIiii_Class56::i_method_f4b725af)) {
               if (!this.I_field_5a) {
                  this.I_field_5a = true;
                  this.i_field_991c1e8c.I_method_23e11e3f();
                  return;
               }

               if (!this.i_field_991c1e8c.I_method_58432069(30000L)) {
                  return;
               }
            }

            this.I_field_5a = false;
            this.I_method_c7de9e22(IIIiiIiii_Class56.Nested1_835c6c60.I_field_2be8f627);
         } else {
            this.I_method_c7de9e22(IIIiiIiii_Class56.Nested1_835c6c60.II_field_2be8f627);
         }
      } else {
         this.I_field_5a = false;
         BlockState var4 = I_field_3a9bda27.world.getBlockState(var3);
         if (var1) {
            if (!this.I_method_7ac3f3d8(var4)) {
               return;
            }
         } else {
            this.I_method_193062e3(var4, var0 -> var0.getItem() instanceof AxeItem);
         }

         Direction var5 = this.I_method_687f51f9(var3);
         Vec3d var6 = this.I_method_46d94e31(var3, var5);
         if (this.I_method_1b642b8f(var6)) {
            I_field_3a9bda27.interactionManager.updateBlockBreakingProgress(var3, var5);
            I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
         }
      }
   }

   private boolean I_method_1b642b8f(Vec3d var1) {
      iiIIiIIii_Class404 var2 = iiIIiIiIi_Class406.I_method_bc8095a1(var1);
      if (this.I_field_32e13e6c == null || this.I_field_32e13e6c.I_method_24e31c97(var2) > 0.5F) {
         this.I_field_32e13e6c = var2;
         this.iI_field_49 = 0;
      }

      RockstarClient.getInstance()
         .I_method_58785402()
         .I_method_1acbf705(var2, iiIIiIIIi_Class402.Ii_field_32e0c64c, 180.0F, 180.0F, 180.0F, iiIIiIiiI_Class407.iI_field_32efc66c);
      iiIIiIIii_Class404 var3 = RockstarClient.getInstance().I_method_58785402().Ii_method_62e6c38();
      if (var3.I_method_24e31c97(var2) <= 1.0F) {
         this.iI_field_49++;
         return this.iI_field_49 >= 2;
      } else {
         return false;
      }
   }

   private void I_method_c7de9e22(IIIiiIiii_Class56.Nested1_835c6c60 var1) {
      this.I_field_2be8f627 = var1;
      this.I_field_32e13e6c = null;
      this.iI_field_49 = 0;
      this.I_field_5a = false;
   }

   private boolean I_method_4c7bba4b(Item var1) {
      return this.I_method_7db6d7f2(var1x -> var1x.getItem() == var1);
   }

   private boolean I_method_7db6d7f2(Predicate<ItemStack> var1) {
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

   private boolean I_method_7ac3f3d8(BlockState var1) {
      Predicate<ItemStack> var2 = var0 -> var0.getItem() instanceof HoeItem;
      Predicate<ItemStack> var3 = var2.and(IIIiiIiii_Class56::I_method_7bea1745);
      if (this.I_method_cdcac55(var1, var3, true)) {
         return true;
      } else {
         boolean var4 = iIIiiIiIi_Class310.I_method_6a489695().I_method_77fa4424(var2) != null
            || iIIiiIiIi_Class310.i_method_7fde0a75().I_method_77fa4424(var2) != null;
         if (var4) {
            this.I_method_cac07269("modules.apple_farm.no_fresh_hoe");
            this.iI_method_8024b102();
            return false;
         } else {
            return true;
         }
      }
   }

   private static boolean I_method_7bea1745(ItemStack var0) {
      if (!var0.isEmpty() && var0.isDamageable()) {
         int var1 = var0.getMaxDamage();
         if (var1 <= 0) {
            return true;
         } else {
            float var2 = (float)(var1 - var0.getDamage()) / var1;
            return var2 > 0.1F;
         }
      } else {
         return true;
      }
   }

   private void I_method_193062e3(BlockState var1, Predicate<ItemStack> var2) {
      this.I_method_cdcac55(var1, var2, false);
   }

   private boolean I_method_cdcac55(BlockState var1, Predicate<ItemStack> var2, boolean var3) {
      ItemStack var4 = I_field_3a9bda27.player.getMainHandStack();
      IIIiiIiii_Class56.Nested1_835c6c80 var5 = this.I_method_94eec120(var4, var1, var2, var3);
      iIIiIiIii_Class300 var6 = null;

      for (iIIiIiIii_Class300 var8 : iIIiiIiIi_Class310.I_method_6a489695().I_method_fdeecb5d(iIIiiIiIi_Class310.i_method_7fde0a75()).I_method_617d3e68()) {
         ItemStack var9 = var8.I_method_7b7e0bb9();
         IIIiiIiii_Class56.Nested1_835c6c80 var10 = this.I_method_94eec120(var9, var1, var2, var3);
         if (var10.I_method_84f7bacb(var5)) {
            var5 = var10;
            var6 = var8;
         }
      }

      if (!var5.I_method_5e9d673e()) {
         return false;
      } else {
         if (var6 instanceof iIIiiiIii_Class316 var11) {
            iIIiIiIiI_Class299.I_method_4c2ca067(var11);
         } else if (var6 instanceof iIIiiiiII_Class317 var12) {
            int var13 = I_field_3a9bda27.player.getInventory().selectedSlot;
            iIIiIiIiI_Class299.iI_method_c617e8c2(var12.I_method_dfe89252(), var13);
         }

         return true;
      }
   }

   private IIIiiIiii_Class56.Nested1_835c6c80 I_method_94eec120(ItemStack var1, BlockState var2, Predicate<ItemStack> var3, boolean var4) {
      if (var1 != null && !var1.isEmpty() && var3.test(var1)) {
         float var5 = var1.getMiningSpeedMultiplier(var2);
         int var6 = iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.EFFICIENCY);
         if (var5 > 1.0F && var6 > 0) {
            var5 += var6 * var6 + 1.0F;
         }

         int var7 = var4 ? iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.FORTUNE) : 0;
         float var8 = this.I_method_7bea1731(var1);
         return new IIIiiIiii_Class56.Nested1_835c6c80(var5, var6, var7, var8);
      } else {
         return new IIIiiIiii_Class56.Nested1_835c6c80(-1.0F, -1, -1, -1.0F);
      }
   }

   private float I_method_7bea1731(ItemStack var1) {
      if (!var1.isEmpty() && var1.isDamageable()) {
         int var2 = var1.getMaxDamage();
         return var2 <= 0 ? 1.0F : (float)(var2 - var1.getDamage()) / var2;
      } else {
         return 1.0F;
      }
   }

   private List<BlockPos> I_method_9b56b248() {
      ArrayList var1 = new ArrayList();
      BlockPos var2 = I_field_3a9bda27.player.getBlockPos();
      Vec3d var3 = I_field_3a9bda27.player.getEyePos();
      double var4 = 16.0;

      for (int var6 = -4; var6 <= 4; var6++) {
         for (int var7 = -4; var7 <= 4; var7++) {
            for (int var8 = -4; var8 <= 4; var8++) {
               BlockPos var9 = var2.add(var6, var7, var8);
               if (this.I_method_a182c5dd(var9)
                  && !(var3.squaredDistanceTo(Vec3d.ofCenter(var9.up())) > var4 * 4.0)
                  && !(Vec3d.ofCenter(var9).squaredDistanceTo(I_field_3a9bda27.player.getPos()) > var4 * 4.0)) {
                  var1.add(var9);
               }
            }
         }
      }

      return var1;
   }

   private boolean I_method_a182c5dd(BlockPos var1) {
      Block var2 = I_field_3a9bda27.world.getBlockState(var1).getBlock();
      return var2 != Blocks.GRASS_BLOCK && var2 != Blocks.DIRT ? false : I_field_3a9bda27.world.getBlockState(var1.up()).isAir();
   }

   private boolean i_method_cbd659bd(BlockPos var1) {
      for (int var2 = -1; var2 <= 1; var2++) {
         for (int var3 = -1; var3 <= 1; var3++) {
            for (int var4 = 0; var4 <= 12; var4++) {
               if (I_method_579e1d8f(I_field_3a9bda27.world.getBlockState(var1.add(var2, var4, var3)).getBlock())) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   private boolean i_method_21af5bd2(Predicate<Block> var1) {
      BlockPos var2 = this.I_field_670402ba.up();

      for (int var3 = 0; var3 <= 12; var3++) {
         for (int var4 = -5; var4 <= 5; var4++) {
            for (int var5 = -5; var5 <= 5; var5++) {
               if (var1.test(I_field_3a9bda27.world.getBlockState(var2.add(var4, var3, var5)).getBlock())) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   private BlockPos I_method_f0a07e22(Predicate<Block> var1) {
      BlockPos var2 = this.I_field_670402ba.up();
      Vec3d var3 = I_field_3a9bda27.player.getEyePos();
      double var4 = I_field_3a9bda27.player.getBlockInteractionRange();
      double var6 = var4 * var4;
      BlockPos var8 = null;
      int var9 = Integer.MAX_VALUE;
      double var10 = Double.MAX_VALUE;

      for (int var12 = 0; var12 <= 12; var12++) {
         for (int var13 = -5; var13 <= 5; var13++) {
            for (int var14 = -5; var14 <= 5; var14++) {
               BlockPos var15 = var2.add(var13, var12, var14);
               if (var1.test(I_field_3a9bda27.world.getBlockState(var15).getBlock())) {
                  Direction var16 = this.I_method_687f51f9(var15);
                  Vec3d var17 = this.I_method_46d94e31(var15, var16);
                  double var18 = var3.squaredDistanceTo(var17);
                  if (!(var18 > var6) && this.I_method_1dcb785d(var3, var17, var15)) {
                     int var20 = var15.getY();
                     if (var20 < var9 || var20 == var9 && var18 < var10) {
                        var9 = var20;
                        var10 = var18;
                        var8 = var15;
                     }
                  }
               }
            }
         }
      }

      return var8;
   }

   private boolean I_method_1dcb785d(Vec3d var1, Vec3d var2, BlockPos var3) {
      BlockHitResult var4 = I_field_3a9bda27.world.raycast(new RaycastContext(var1, var2, ShapeType.OUTLINE, FluidHandling.NONE, I_field_3a9bda27.player));
      return var4.getType() != Type.BLOCK ? true : var4.getBlockPos().equals(var3);
   }

   private Direction I_method_687f51f9(BlockPos var1) {
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

   private Vec3d I_method_46d94e31(BlockPos var1, Direction var2) {
      return Vec3d.ofCenter(var1).add(var2.getOffsetX() * 0.5, var2.getOffsetY() * 0.5, var2.getOffsetZ() * 0.5);
   }

   private boolean i_method_76784a6b(Item var1) {
      return iIIiiIiIi_Class310.I_method_6a489695().I_method_c9799e6b(var1) || iIIiiIiIi_Class310.i_method_7fde0a75().I_method_c9799e6b(var1);
   }

   private boolean II_method_75852fb5(Predicate<ItemStack> var1) {
      return iIIiiIiIi_Class310.I_method_6a489695().I_method_77fa4424(var1) != null || iIIiiIiIi_Class310.i_method_7fde0a75().I_method_77fa4424(var1) != null;
   }

   private static boolean I_method_579e1d8f(Block var0) {
      return var0 == Blocks.OAK_LOG;
   }

   private static boolean i_method_f4b725af(Block var0) {
      return var0 == Blocks.OAK_LEAVES;
   }

   static enum Nested1_835c6c60 {
      I_field_2be8f627,
      i_field_2be8f627,
      II_field_2be8f627,
      Ii_field_2be8f627;
   }

   static final class Nested1_835c6c80 {
      private final float I_field_46;
      private final int I_field_49;
      private final int i_field_49;
      private final float i_field_46;

      Nested1_835c6c80(float var1, int var2, int var3, float var4) {
         this.I_field_46 = var1;
         this.I_field_49 = var2;
         this.i_field_49 = var3;
         this.i_field_46 = var4;
      }

      boolean I_method_5e9d673e() {
         return this.I_field_46 >= 0.0F;
      }

      boolean I_method_84f7bacb(IIIiiIiii_Class56.Nested1_835c6c80 var1) {
         if (this.I_field_46 != var1.I_field_46) {
            return this.I_field_46 > var1.I_field_46;
         } else if (this.I_field_49 != var1.I_field_49) {
            return this.I_field_49 > var1.I_field_49;
         } else {
            return this.i_field_49 != var1.i_field_49 ? this.i_field_49 > var1.i_field_49 : this.i_field_46 > var1.i_field_46;
         }
      }

      @Override
      public final String toString() {
         return "Nested1_835c6c80[miningSpeed=" + this.I_field_46 + ", efficiency=" + this.I_field_49 + ", fortune=" + this.i_field_49 + ", durability=" + this.i_field_46 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_46);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IIIiiIiii_Class56.Nested1_835c6c80 other = (IIIiiIiii_Class56.Nested1_835c6c80) var1;
         return java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.i_field_49, other.i_field_49)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46);
      }

      public float I_method_5e9d672a() {
         return this.I_field_46;
      }

      public int I_method_5e9d672d() {
         return this.I_field_49;
      }

      public int i_method_5eabf30d() {
         return this.i_field_49;
      }

      public float i_method_5eabf30a() {
         return this.i_field_46;
      }
   }
}
