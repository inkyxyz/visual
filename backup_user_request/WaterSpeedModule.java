package rockstar.client;

import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

@ModuleInfo(
   name = "Water Speed",
   category = ModuleCategory.MOVEMENT
)
public class WaterSpeedModule extends Module {
   private int I_field_49 = -1;
   private int i_field_49 = -1;
   private int II_field_49 = -1;
   private int Ii_field_49;

   @Override
   public void II_method_6642fd22() {
      if (I_field_3a9bda27.player != null
         && I_field_3a9bda27.world != null
         && I_field_3a9bda27.interactionManager != null
         && I_field_3a9bda27.player.isTouchingWater()) {
         BlockPos var1 = I_field_3a9bda27.player.getBlockPos().up();
         if (this.I_method_baf2cd4a(var1)) {
            I_field_3a9bda27.player
               .setVelocity(
                  I_field_3a9bda27.player.getVelocity().x * 1.05, I_field_3a9bda27.player.getVelocity().y, I_field_3a9bda27.player.getVelocity().z * 1.05
               );
            this.IiI_method_3b810a0c();
         } else {
            this.I_method_baf2cd46(var1);
         }
      } else {
         this.IiI_method_3b810a0c();
      }

      super.II_method_6642fd22();
   }

   @Override
   public void onDisable() {
      this.IiI_method_3b810a0c();
   }

   private void I_method_baf2cd46(BlockPos var1) {
      if (!I_field_3a9bda27.world.getBlockState(var1).isReplaceable()) {
         this.IiI_method_3b810a0c();
      } else {
         WaterSpeedModule.Nested1_c7bd40d3 var2 = this.I_method_19da70c(var1);
         if (var2 == null) {
            this.IiI_method_3b810a0c();
         } else if (this.I_method_738dd32(I_field_3a9bda27.player.getOffHandStack())) {
            this.I_method_74e66451(var2, Hand.OFF_HAND);
         } else {
            iIIiiiIii_Class316 var3 = iIIiiIiIi_Class310.I_method_6a489695().I_method_77fa4424(this::I_method_738dd32);
            if (var3 == null) {
               this.IiI_method_3b810a0c();
            } else if (this.I_method_c211e5fe(var3)) {
               this.I_method_74e66451(var2, Hand.MAIN_HAND);
            }
         }
      }
   }

   private WaterSpeedModule.Nested1_c7bd40d3 I_method_19da70c(BlockPos var1) {
      Vec3d var2 = I_field_3a9bda27.player.getEyePos();
      double var3 = I_field_3a9bda27.player.getBlockInteractionRange();
      WaterSpeedModule.Nested1_c7bd40d3 var5 = null;
      double var6 = Double.MAX_VALUE;

      for (Direction var11 : Direction.values()) {
         BlockPos var12 = var1.offset(var11);
         Direction var13 = var11.getOpposite();
         BlockState var14 = I_field_3a9bda27.world.getBlockState(var12);
         if (var14.isSideSolidFullSquare(I_field_3a9bda27.world, var12, var13)) {
            Vec3d var15 = var12.toCenterPos().add(var13.getOffsetX() * 0.5, var13.getOffsetY() * 0.5, var13.getOffsetZ() * 0.5);
            double var16 = var2.squaredDistanceTo(var15);
            if (!(var16 > var3 * var3) && !(var16 >= var6)) {
               var6 = var16;
               var5 = new WaterSpeedModule.Nested1_c7bd40d3(var12, var13, var15);
            }
         }
      }

      return var5;
   }

   private boolean I_method_c211e5fe(iIIiiiIii_Class316 var1) {
      int var2 = I_field_3a9bda27.player.getInventory().selectedSlot;
      if (this.i_field_49 == var1.II_method_b9cf08f5() && var2 == var1.II_method_b9cf08f5()) {
         return I_field_3a9bda27.player.age > this.II_field_49;
      } else {
         if (this.I_field_49 == -1) {
            this.I_field_49 = var2;
         }

         this.i_field_49 = var1.II_method_b9cf08f5();
         this.II_field_49 = I_field_3a9bda27.player.age;
         this.Ii_field_49 = 0;
         iIIiIiIiI_Class299.i_method_8225b484(this.i_field_49);
         return false;
      }
   }

   private void I_method_74e66451(WaterSpeedModule.Nested1_c7bd40d3 var1, Hand var2) {
      iiIIiIIii_Class404 var3 = this.I_method_c94aa922(I_field_3a9bda27.player.getEyePos(), var1.I_method_d3814001());
      RockstarClient.getInstance()
         .I_method_58785402()
         .I_method_1acbf705(var3, iiIIiIIIi_Class402.Ii_field_32e0c64c, 100.0F, 100.0F, 100.0F, iiIIiIiiI_Class407.iI_field_32efc66c);
      iiIIiIIii_Class404 var4 = RockstarClient.getInstance().I_method_58785402().II_method_f098f858();
      if (Math.abs(MathHelper.wrapDegrees(var4.I_method_14534e0f() - var3.I_method_14534e0f())) > 3.0F
         || Math.abs(var4.i_method_1461d9ef() - var3.i_method_1461d9ef()) > 3.0F) {
         this.Ii_field_49 = 0;
      } else if (++this.Ii_field_49 >= 2) {
         I_field_3a9bda27.interactionManager
            .interactBlock(
               I_field_3a9bda27.player, var2, new BlockHitResult(var1.I_method_d3814001(), var1.I_method_41a01f67(), var1.I_method_1ce80669(), false)
            );
         I_field_3a9bda27.player.swingHand(var2);
         this.Ii_field_49 = 0;
      }
   }

   private boolean I_method_baf2cd4a(BlockPos var1) {
      return I_field_3a9bda27.world.getBlockState(var1).isFullCube(I_field_3a9bda27.world, var1);
   }

   private boolean I_method_738dd32(ItemStack var1) {
      if (!var1.isEmpty() && var1.getItem() instanceof BlockItem var2) {
         BlockState var4 = var2.getBlock().getDefaultState();
         return var4.isFullCube(I_field_3a9bda27.world, BlockPos.ORIGIN);
      } else {
         return false;
      }
   }

   private iiIIiIIii_Class404 I_method_c94aa922(Vec3d var1, Vec3d var2) {
      double var3 = var2.x - var1.x;
      double var5 = var2.y - var1.y;
      double var7 = var2.z - var1.z;
      double var9 = Math.sqrt(var3 * var3 + var7 * var7);
      return new iiIIiIIii_Class404((float)Math.toDegrees(Math.atan2(var7, var3)) - 90.0F, (float)(-Math.toDegrees(Math.atan2(var5, var9))));
   }

   private void IiI_method_3b810a0c() {
      if (I_field_3a9bda27.player != null && this.I_field_49 != -1 && I_field_3a9bda27.player.getInventory().selectedSlot != this.I_field_49) {
         iIIiIiIiI_Class299.i_method_8225b484(this.I_field_49);
      }

      this.I_field_49 = -1;
      this.i_field_49 = -1;
      this.II_field_49 = -1;
      this.Ii_field_49 = 0;
   }

   static final class Nested1_c7bd40d3 {
      private final BlockPos I_field_670402ba;
      private final Direction I_field_3b03ad36;
      private final Vec3d I_field_5bba0d50;

      Nested1_c7bd40d3(BlockPos var1, Direction var2, Vec3d var3) {
         this.I_field_670402ba = var1;
         this.I_field_3b03ad36 = var2;
         this.I_field_5bba0d50 = var3;
      }

      @Override
      public final String toString() {
         return "Nested1_c7bd40d3[support=" + this.I_field_670402ba + ", side=" + this.I_field_3b03ad36 + ", hitPos=" + this.I_field_5bba0d50 + "]";
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
         WaterSpeedModule.Nested1_c7bd40d3 other = (WaterSpeedModule.Nested1_c7bd40d3) var1;
         return java.util.Objects.equals(this.I_field_670402ba, other.I_field_670402ba)
            && java.util.Objects.equals(this.I_field_3b03ad36, other.I_field_3b03ad36)
            && java.util.Objects.equals(this.I_field_5bba0d50, other.I_field_5bba0d50);
      }

      public BlockPos I_method_1ce80669() {
         return this.I_field_670402ba;
      }

      public Direction I_method_41a01f67() {
         return this.I_field_3b03ad36;
      }

      public Vec3d I_method_d3814001() {
         return this.I_field_5bba0d50;
      }
   }
}
