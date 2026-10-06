package rockstar.client;

import java.util.HashSet;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import org.jetbrains.annotations.Nullable;

public final class iiiiIIIIi_Class482 implements iiiiIIiII_Class485 {
   private static final Direction[] I_field_8d7cb6fb = new Direction[]{
      Direction.DOWN, Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST, Direction.UP
   };
   private final BlockPos I_field_670402ba;
   private final BlockPos i_field_670402ba;
   private final Block I_field_d9031850;
   private final Item I_field_3c05b08c;
   private final int I_field_49;
   private int i_field_49;
   @Nullable
   private BlockPos II_field_670402ba;
   @Nullable
   private iiiiIIIiI_Class483 I_field_95332aac;
   private final iiiIIIIIi_Class450 I_field_f86b4e4c = new iiiIIIIIi_Class450();
   private boolean I_field_5a;
   private boolean i_field_5a;
   @Nullable
   private String I_field_523beb0a;
   private int II_field_49;
   private final Set<BlockPos> I_field_a56a8dc5 = new HashSet<>();
   @Nullable
   private iiIIiIIii_Class404 I_field_32e13e6c;
   private int Ii_field_49;

   public iiiiIIIIi_Class482(BlockPos var1, BlockPos var2, Block var3) {
      this.I_field_670402ba = var1;
      this.i_field_670402ba = var2;
      this.I_field_d9031850 = var3;
      this.I_field_3c05b08c = var3.asItem();
      this.I_field_49 = this.I_method_8128c612();
   }

   private int I_method_8128c612() {
      MinecraftClient var1 = MinecraftClient.getInstance();
      if (var1.world == null) {
         return 0;
      } else {
         int var2 = 0;
         Mutable var3 = new Mutable();

         for (int var4 = this.I_field_670402ba.getY(); var4 <= this.i_field_670402ba.getY(); var4++) {
            for (int var5 = this.I_field_670402ba.getX(); var5 <= this.i_field_670402ba.getX(); var5++) {
               for (int var6 = this.I_field_670402ba.getZ(); var6 <= this.i_field_670402ba.getZ(); var6++) {
                  var3.set(var5, var4, var6);
                  if (var1.world.getBlockState(var3).getBlock() != this.I_field_d9031850) {
                     var2++;
                  }
               }
            }
         }

         return var2;
      }
   }

   private boolean I_method_801d84b9(MinecraftClient var1, BlockPos var2, BlockState var3) {
      if (var3.getBlock() == this.I_field_d9031850) {
         return false;
      } else {
         return !var3.isAir() && !var3.isReplaceable() ? var3.getHardness(var1.world, var2) >= 0.0F : false;
      }
   }

   private boolean I_method_b6029304(MinecraftClient var1, BlockPos var2) {
      BlockState var3 = var1.world.getBlockState(var2);
      if (var3.getBlock() == this.I_field_d9031850) {
         return false;
      } else {
         return this.I_method_801d84b9(var1, var2, var3) ? true : (var3.isAir() || var3.isReplaceable()) && !this.II_method_77657707(var1, var2);
      }
   }

   @Override
   public String I_method_31075c81() {
      return "fill";
   }

   @Override
   public String i_method_c4260ca1() {
      if (this.I_field_5a) {
         return "\u043f\u0430\u0443\u0437\u0430";
      } else if (this.i_field_5a) {
         return "\u0433\u043e\u0442\u043e\u0432\u043e";
      } else {
         String var1 = this.i_field_49 + "/" + this.I_field_49;
         if (this.II_field_670402ba != null && this.I_field_95332aac == null) {
            return "\u0440\u0430\u0431\u043e\u0442\u0430\u0435\u043c " + this.II_field_670402ba + " (" + var1 + ")";
         } else {
            return this.I_field_95332aac != null
               ? "\u0438\u0434\u0451\u043c \u043a " + this.II_field_670402ba + " (" + var1 + ")"
               : "\u0437\u0430\u043f\u043e\u043b\u043d\u0435\u043d\u0438\u0435 " + var1;
         }
      }
   }

   @Override
   public boolean I_method_8f3b7603() {
      if (this.I_field_5a) {
         return false;
      } else if (this.i_field_5a) {
         return true;
      } else {
         MinecraftClient var1 = MinecraftClient.getInstance();
         if (var1.player != null && var1.world != null && var1.interactionManager != null) {
            iiIiiIiII_Class437.I_method_d9acc61f();
            if (this.I_field_95332aac != null) {
               boolean var5 = this.I_field_95332aac.I_method_8f3b7603();
               if (var5) {
                  this.I_field_95332aac = null;
                  if (this.II_field_670402ba != null) {
                     double var3 = var1.player.getEyePos().distanceTo(Vec3d.ofCenter(this.II_field_670402ba));
                     if (var3 > 5.0) {
                        this.I_field_a56a8dc5.add(this.II_field_670402ba);
                        this.II_field_670402ba = null;
                     }
                  }
               }

               return false;
            } else if (this.II_field_670402ba != null) {
               return this.i_method_f8e83ee4(var1, this.II_field_670402ba);
            } else {
               BlockPos var2 = this.I_method_9da9d40a(var1);
               if (var2 == null) {
                  iiiIIIIii_Class452.I_method_15375629(
                     "\u0417\u0430\u043f\u043e\u043b\u043d\u0435\u043d\u0438\u0435 \u0437\u0430\u0432\u0435\u0440\u0448\u0435\u043d\u043e ("
                        + this.i_field_49
                        + " \u0431\u043b\u043e\u043a\u043e\u0432)"
                  );
                  this.I_method_8f3b75ff();
                  this.i_field_5a = true;
                  return true;
               } else {
                  this.II_field_670402ba = var2;
                  this.Ii_method_a40d8102();
                  return false;
               }
            }
         } else {
            return false;
         }
      }
   }

   private boolean i_method_f8e83ee4(MinecraftClient var1, BlockPos var2) {
      Vec3d var3 = Vec3d.ofCenter(var2);
      double var4 = var1.player.getEyePos().distanceTo(var3);
      if (var4 > 5.0) {
         this.iI_method_a5c1e542();
         this.Ii_method_a40d8102();
         this.I_method_b6029300(var1, var2);
         return false;
      } else {
         BlockState var6 = var1.world.getBlockState(var2);
         if (var6.getBlock() == this.I_field_d9031850) {
            this.i_field_49++;
            this.II_field_670402ba = null;
            this.iI_method_a5c1e542();
            this.Ii_method_a40d8102();
            return false;
         } else if (this.I_method_801d84b9(var1, var2, var6)) {
            return this.i_method_265bb099(var1, var2, var6);
         } else if (this.II_method_77657707(var1, var2)) {
            this.II_field_670402ba = null;
            this.iI_method_a5c1e542();
            this.Ii_method_a40d8102();
            return false;
         } else if (this.Ii_method_ba4b22e7(var1, var2)) {
            this.iI_method_a5c1e542();
            this.Ii_method_a40d8102();
            BlockPos var9 = this.I_method_ae33ed50(var1, var2);
            this.II_field_49++;
            if (var9 != null && this.II_field_49 < 4) {
               this.I_field_95332aac = new iiiiIIIiI_Class483(new iiiIIiIii_Class460(var9));
               return false;
            } else {
               this.I_field_a56a8dc5.add(var2);
               this.II_field_670402ba = null;
               this.II_field_49 = 0;
               return false;
            }
         } else {
            iiiiIIIIi_Class482.Nested1_9315e460 var7 = this.I_method_91bfcdd1(var1, var2);
            if (var7 == null) {
               this.II_field_49++;
               if (this.II_field_49 >= 3) {
                  this.I_field_a56a8dc5.add(var2);
                  this.II_field_670402ba = null;
                  this.II_field_49 = 0;
                  return false;
               } else {
                  this.I_field_95332aac = new iiiiIIIiI_Class483(new iiiIIiiII_Class461(var2, 1));
                  return false;
               }
            } else {
               this.II_field_49 = 0;
               if (!this.I_method_271850a(var1)) {
                  iiiIIIIii_Class452.i_method_e5eeaa09(
                     "\u041d\u0435\u0442 \u0431\u043b\u043e\u043a\u0430 "
                        + this.I_field_d9031850
                        + " \u0432 \u0438\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u0435"
                  );
                  this.I_field_523beb0a = "\u043d\u0435\u0442 \u0431\u043b\u043e\u043a\u0430 \u0432 \u0438\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u0435";
                  this.I_method_8f3b75ff();
                  this.i_field_5a = true;
                  return true;
               } else if (!this.I_method_96bfa38f(var7.I_field_5bba0d50)) {
                  return false;
               } else {
                  BlockHitResult var8 = new BlockHitResult(var7.I_field_5bba0d50, var7.I_field_3b03ad36, var7.I_field_670402ba, false);
                  var1.interactionManager.interactBlock(var1.player, Hand.MAIN_HAND, var8);
                  var1.player.swingHand(Hand.MAIN_HAND);
                  return false;
               }
            }
         }
      }
   }

   private boolean i_method_265bb099(MinecraftClient var1, BlockPos var2, BlockState var3) {
      if (!III_method_e25f1364(var1, var2)) {
         this.iI_method_a5c1e542();
         this.II_field_49++;
         if (this.II_field_49 >= 3) {
            this.I_field_a56a8dc5.add(var2);
            this.II_field_670402ba = null;
            this.II_field_49 = 0;
            return false;
         } else {
            this.I_field_95332aac = new iiiiIIIiI_Class483(new iiiIIiiII_Class461(var2, 1));
            return false;
         }
      } else {
         this.II_field_49 = 0;
         iiiIIIIII_Class449.I_method_98560fd8(var3);
         Direction var4 = this.I_method_d9d11560(var1, var2);
         if (!this.I_field_f86b4e4c.I_method_b97a0d1b(var2, var4)) {
            return false;
         } else {
            var1.interactionManager.updateBlockBreakingProgress(var2, var4);
            var1.player.swingHand(var1.player.getActiveHand());
            return false;
         }
      }
   }

   @Nullable
   private BlockPos I_method_9da9d40a(MinecraftClient var1) {
      if (var1.player == null) {
         return null;
      } else {
         double var2 = var1.player.getX();
         double var4 = var1.player.getZ();
         Mutable var6 = new Mutable();

         for (int var7 = this.I_field_670402ba.getY(); var7 <= this.i_field_670402ba.getY(); var7++) {
            BlockPos var8 = null;
            double var9 = Double.MAX_VALUE;

            for (int var11 = this.I_field_670402ba.getX(); var11 <= this.i_field_670402ba.getX(); var11++) {
               for (int var12 = this.I_field_670402ba.getZ(); var12 <= this.i_field_670402ba.getZ(); var12++) {
                  var6.set(var11, var7, var12);
                  if (!this.I_field_a56a8dc5.contains(var6) && this.I_method_b6029304(var1, var6)) {
                     double var13 = var11 + 0.5 - var2;
                     double var15 = var12 + 0.5 - var4;
                     double var17 = var13 * var13 + var15 * var15;
                     if (var17 < var9) {
                        var9 = var17;
                        var8 = var6.toImmutable();
                     }
                  }
               }
            }

            if (var8 != null) {
               return var8;
            }
         }

         return null;
      }
   }

   @Nullable
   private iiiiIIIIi_Class482.Nested1_9315e460 I_method_91bfcdd1(MinecraftClient var1, BlockPos var2) {
      if (var1.world != null && var1.player != null) {
         Vec3d var3 = var1.player.getEyePos();

         for (Direction var7 : I_field_8d7cb6fb) {
            BlockPos var8 = var2.offset(var7);
            Direction var9 = var7.getOpposite();
            BlockState var10 = var1.world.getBlockState(var8);
            if (var10.isSideSolidFullSquare(var1.world, var8, var9)) {
               Vec3d var11 = Vec3d.ofCenter(var8).add(var9.getOffsetX() * 0.5, var9.getOffsetY() * 0.5, var9.getOffsetZ() * 0.5);
               if (!(var3.distanceTo(var11) > 5.0) && I_method_8b87a642(var1, var11, var8)) {
                  return new iiiiIIIIi_Class482.Nested1_9315e460(var8, var9, var11);
               }
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private void I_method_b6029300(MinecraftClient var1, BlockPos var2) {
      BlockPos var3 = this.I_method_ae33ed50(var1, var2);
      this.I_field_95332aac = var3 != null ? new iiiiIIIiI_Class483(new iiiIIiIii_Class460(var3)) : new iiiiIIIiI_Class483(new iiiIIiiII_Class461(var2, 2));
   }

   private boolean II_method_77657707(MinecraftClient var1, BlockPos var2) {
      if (var1.world == null) {
         return false;
      } else {
         Box var3 = new Box(var2);

         for (Entity var5 : var1.world.getOtherEntities(var1.player, var3)) {
            if (var5.isAlive() && !var5.isSpectator() && !(var5 instanceof ItemEntity) && !(var5 instanceof ExperienceOrbEntity)) {
               return true;
            }
         }

         return false;
      }
   }

   private boolean Ii_method_ba4b22e7(MinecraftClient var1, BlockPos var2) {
      return var1.player == null ? false : var1.player.getBoundingBox().intersects(new Box(var2));
   }

   @Nullable
   private BlockPos I_method_ae33ed50(MinecraftClient var1, BlockPos var2) {
      if (var1.player != null && var1.world != null) {
         Vec3d var3 = var1.player.getPos();
         BlockPos var4 = null;
         double var5 = Double.MAX_VALUE;
         Direction[] var7 = new Direction[]{Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST};

         for (Direction var11 : var7) {
            BlockPos var12 = var2.offset(var11);

            for (BlockPos var16 : new BlockPos[]{var12, var12.up()}) {
               if (this.iI_method_91354727(var1, var16)) {
                  double var17 = var16.getSquaredDistance(var3.x, var3.y, var3.z);
                  if (var17 < var5) {
                     var5 = var17;
                     var4 = var16;
                  }
               }
            }
         }

         return var4;
      } else {
         return null;
      }
   }

   private boolean iI_method_91354727(MinecraftClient var1, BlockPos var2) {
      if (var1.world == null) {
         return false;
      } else if (this.ii_method_d41af307(var1, var2) && this.ii_method_d41af307(var1, var2.up())) {
         BlockPos var3 = var2.down();
         return var1.world.getBlockState(var3).isSideSolidFullSquare(var1.world, var3, Direction.UP);
      } else {
         return false;
      }
   }

   private boolean ii_method_d41af307(MinecraftClient var1, BlockPos var2) {
      return var1.world.getBlockState(var2).getCollisionShape(var1.world, var2).isEmpty();
   }

   private static boolean I_method_8b87a642(MinecraftClient var0, Vec3d var1, BlockPos var2) {
      if (var0.world != null && var0.player != null) {
         RaycastContext var3 = new RaycastContext(var0.player.getEyePos(), var1, ShapeType.COLLIDER, FluidHandling.NONE, var0.player);
         BlockHitResult var4 = var0.world.raycast(var3);
         return var4.getType() != Type.BLOCK || var4.getBlockPos().equals(var2);
      } else {
         return false;
      }
   }

   private static boolean III_method_e25f1364(MinecraftClient var0, BlockPos var1) {
      if (var0.world != null && var0.player != null) {
         Vec3d var2 = var0.player.getEyePos();
         Vec3d var3 = Vec3d.ofCenter(var1);
         Vec3d[] var4 = new Vec3d[]{
            var3,
            var3.add(0.49, 0.0, 0.0),
            var3.add(-0.49, 0.0, 0.0),
            var3.add(0.0, 0.49, 0.0),
            var3.add(0.0, -0.49, 0.0),
            var3.add(0.0, 0.0, 0.49),
            var3.add(0.0, 0.0, -0.49)
         };

         for (Vec3d var8 : var4) {
            RaycastContext var9 = new RaycastContext(var2, var8, ShapeType.COLLIDER, FluidHandling.NONE, var0.player);
            BlockHitResult var10 = var0.world.raycast(var9);
            if (var10.getType() != Type.BLOCK) {
               return true;
            }

            if (var10.getBlockPos().equals(var1)) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private Direction I_method_d9d11560(MinecraftClient var1, BlockPos var2) {
      Vec3d var3 = var1.player.getEyePos();
      Direction var4 = Direction.UP;
      double var5 = -1.0;

      for (Direction var10 : Direction.values()) {
         Vec3d var11 = Vec3d.ofCenter(var2).add(var10.getOffsetX() * 0.5, var10.getOffsetY() * 0.5, var10.getOffsetZ() * 0.5);
         Vec3d var12 = var11.subtract(var3).normalize();
         double var13 = var12.x * var10.getOffsetX() + var12.y * var10.getOffsetY() + var12.z * var10.getOffsetZ();
         double var15 = -var13;
         if (var15 > var5) {
            var5 = var15;
            var4 = var10;
         }
      }

      return var4;
   }

   private boolean I_method_96bfa38f(Vec3d var1) {
      iiIIiIIii_Class404 var2 = iiIIiIiIi_Class406.I_method_bc8095a1(var1);
      if (this.I_field_32e13e6c == null || this.I_field_32e13e6c.I_method_24e31c97(var2) > 0.5F) {
         this.I_field_32e13e6c = var2;
         this.Ii_field_49 = 0;
      }

      iiIiiIiIi_Class438.I_method_12f562b5()
         .I_method_762df6b5()
         .I_method_1acbf705(var2, iiIIiIIIi_Class402.Ii_field_32e0c64c, 180.0F, 180.0F, 180.0F, iiIIiIiiI_Class407.iI_field_32efc66c);
      iiIIiIIii_Class404 var3 = iiIiiIiIi_Class438.I_method_12f562b5().I_method_762df6b5().II_method_f098f858();
      if (var3.I_method_24e31c97(var2) <= 1.0F) {
         this.Ii_field_49++;
         return this.Ii_field_49 >= 1;
      } else {
         return false;
      }
   }

   private void Ii_method_a40d8102() {
      this.I_field_32e13e6c = null;
      this.Ii_field_49 = 0;
   }

   private void iI_method_a5c1e542() {
      MinecraftClient var1 = MinecraftClient.getInstance();
      if (var1.interactionManager != null) {
         var1.interactionManager.cancelBlockBreaking();
      }
   }

   private boolean I_method_271850a(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.player;
      if (var2 != null && this.I_field_3c05b08c != Items.AIR) {
         PlayerInventory var3 = var2.getInventory();
         if (var3.getStack(var3.selectedSlot).getItem() == this.I_field_3c05b08c) {
            return true;
         } else {
            for (int var4 = 0; var4 < 9; var4++) {
               if (var3.getStack(var4).getItem() == this.I_field_3c05b08c) {
                  iiiIIIIII_Class449.I_method_10f45cc4(var4);
                  return true;
               }
            }

            for (int var5 = 9; var5 < 36; var5++) {
               if (var3.getStack(var5).getItem() == this.I_field_3c05b08c) {
                  var1.interactionManager.clickSlot(var2.currentScreenHandler.syncId, var5, var3.selectedSlot, SlotActionType.SWAP, var2);
                  return true;
               }
            }

            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   public void I_method_8f3b75ff() {
      if (this.I_field_95332aac != null) {
         this.I_field_95332aac.I_method_8f3b75ff();
         this.I_field_95332aac = null;
      }

      this.iI_method_a5c1e542();
      iiIiiiiii_Class448 var1 = iiIiiIiIi_Class438.I_method_12f562b5().I_method_14b8caf5();
      var1.i_method_35abae1f();
      this.II_field_670402ba = null;
      this.Ii_method_a40d8102();
   }

   @Override
   public void i_method_8f4a01df() {
      this.I_field_5a = true;
      if (this.I_field_95332aac != null) {
         this.I_field_95332aac.i_method_8f4a01df();
      }

      this.iI_method_a5c1e542();
      iiIiiIiIi_Class438.I_method_12f562b5().I_method_14b8caf5().i_method_35abae1f();
   }

   @Override
   public void II_method_58424142() {
      this.I_field_5a = false;
      if (this.I_field_95332aac != null) {
         this.I_field_95332aac.II_method_58424142();
      }
   }

   @Override
   public boolean i_method_8f4a01e3() {
      return this.I_field_5a;
   }

   @Override
   public boolean II_method_58424146() {
      return this.i_field_5a && this.I_field_523beb0a == null;
   }

   @Nullable
   @Override
   public String II_method_f53e1f9e() {
      return this.I_field_523beb0a;
   }

   static final class Nested1_9315e460 {
      final BlockPos I_field_670402ba;
      final Direction I_field_3b03ad36;
      final Vec3d I_field_5bba0d50;

      Nested1_9315e460(BlockPos var1, Direction var2, Vec3d var3) {
         this.I_field_670402ba = var1;
         this.I_field_3b03ad36 = var2;
         this.I_field_5bba0d50 = var3;
      }

      @Override
      public final String toString() {
         return "Nested1_9315e460[support=" + this.I_field_670402ba + ", clickFace=" + this.I_field_3b03ad36 + ", hitVec=" + this.I_field_5bba0d50 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_670402ba);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_3b03ad36);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5bba0d50);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iiiiIIIIi_Class482.Nested1_9315e460 other = (iiiiIIIIi_Class482.Nested1_9315e460) var1;
         return java.util.Objects.equals(this.I_field_670402ba, other.I_field_670402ba)
            && java.util.Objects.equals(this.I_field_3b03ad36, other.I_field_3b03ad36)
            && java.util.Objects.equals(this.I_field_5bba0d50, other.I_field_5bba0d50);
      }

      public BlockPos I_method_f9369836() {
         return this.I_field_670402ba;
      }

      public Direction I_method_ef23c73a() {
         return this.I_field_3b03ad36;
      }

      public Vec3d I_method_d0dfc954() {
         return this.I_field_5bba0d50;
      }
   }
}
