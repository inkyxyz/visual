package rockstar.client;

import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

public class iiiIiIIii_Class468 extends iiiIiIIII_Class465 {
   private static final double Ii_field_44 = 1.5;
   private static final double iI_field_44 = 0.4;
   private double ii_field_44 = Double.POSITIVE_INFINITY;
   private int I_field_49;
   private boolean I_field_5a;
   private final iiiIIIIIi_Class450 I_field_f86b4e4c = new iiiIIIIIi_Class450();
   private BlockPos I_field_670402ba;

   public iiiIiIIii_Class468(iiiIIiIIi_Class458 var1, iiiIIiIIi_Class458 var2) {
      super(var1, var2);
   }

   @Override
   protected double i_method_373409cd() {
      return this.ii_field_44;
   }

   @Override
   public int I_method_37257df2() {
      return Math.min(600, this.I_field_49 * 2 + 120);
   }

   @Override
   public boolean I_method_a7f2ac8b(iiiIIIiIi_Class454 var1) {
      if (Math.abs(this.i_field_fa2e3e6c.I_method_6d204e12() - this.I_field_fa2e3e6c.I_method_6d204e12())
            + Math.abs(this.i_field_fa2e3e6c.II_method_36f86d15() - this.I_field_fa2e3e6c.II_method_36f86d15())
         != 1) {
         return false;
      } else if (this.i_field_fa2e3e6c.i_method_6d2ed9f2() != this.I_field_fa2e3e6c.i_method_6d2ed9f2() + 1) {
         return false;
      } else if (!var1.i_method_674a3c88(
         this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2() - 1, this.i_field_fa2e3e6c.II_method_36f86d15()
      )) {
         return false;
      } else if (var1.ii_method_b822e605(
         this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2() - 1, this.i_field_fa2e3e6c.II_method_36f86d15()
      )) {
         return false;
      } else {
         int[][] var2 = new int[][]{
            {this.I_field_fa2e3e6c.I_method_6d204e12(), this.I_field_fa2e3e6c.i_method_6d2ed9f2() + 2, this.I_field_fa2e3e6c.II_method_36f86d15()},
            {this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2() + 1, this.i_field_fa2e3e6c.II_method_36f86d15()},
            {this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15()}
         };
         int var3 = 0;
         int var4 = 0;

         for (int[] var8 : var2) {
            int var9 = var1.I_method_ca82d457(var8[0], var8[1], var8[2]);
            if (var9 == Integer.MAX_VALUE) {
               return false;
            }

            if (var9 > 0) {
               var3 += var9;
               var4++;
            }
         }

         this.I_field_49 = var3;
         if (var4 == 0) {
            return false;
         } else {
            double var10 = var3 / 20.0;
            this.ii_field_44 = 1.5 + var10 * 1.5 + var4 * 0.4;
            return true;
         }
      }
   }

   @Override
   public iiiIiIIII_Class465.Nested1_33b738a0 I_method_8cdd8810() {
      MinecraftClient var1 = MinecraftClient.getInstance();
      ClientPlayerEntity var2 = var1.player;
      if (var2 != null && var1.world != null && var1.interactionManager != null) {
         BlockPos[] var3 = new BlockPos[]{
            new BlockPos(this.I_field_fa2e3e6c.I_method_6d204e12(), this.I_field_fa2e3e6c.i_method_6d2ed9f2() + 2, this.I_field_fa2e3e6c.II_method_36f86d15()),
            new BlockPos(this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2() + 1, this.i_field_fa2e3e6c.II_method_36f86d15()),
            new BlockPos(this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15())
         };
         BlockPos var4 = null;
         BlockState var5 = null;

         for (BlockPos var9 : var3) {
            BlockState var10 = var1.world.getBlockState(var9);
            if (!iiiIiIIiI_Class467.I_method_a51b9bd8(var10)) {
               var4 = var9;
               var5 = var10;
               break;
            }
         }

         iiIiiiiii_Class448 var11 = iiIiiIiIi_Class438.I_method_12f562b5().I_method_14b8caf5();
         var11.I_method_359d223f();
         if (var4 == null) {
            if (this.I_field_5a) {
               var1.interactionManager.cancelBlockBreaking();
               this.I_field_5a = false;
               this.I_field_670402ba = null;
               this.I_field_f86b4e4c.I_method_e4926dff();
            }

            return this.i_method_11f5fff0();
         } else {
            var11.I_method_7e07d875(false);
            var11.i_method_7fcac895(false);
            var11.II_method_44ae3612(false);
            var11.Ii_method_46712632(false);
            var11.iI_method_7b4949f2(false);
            var11.ii_method_7d0c3a12(false);
            var11.III_method_52d38c15(false);
            double var12 = Math.hypot(
               var2.getX() - (this.I_field_fa2e3e6c.I_method_6d204e12() + 0.5), var2.getZ() - (this.I_field_fa2e3e6c.II_method_36f86d15() + 0.5)
            );
            if (var12 > 1.7) {
               return iiiIiIIII_Class465.Nested1_33b738a0.II_field_86e7b1e7;
            } else {
               iiiIIIIII_Class449.I_method_98560fd8(var5);
               if (this.I_field_670402ba != null && !this.I_field_670402ba.equals(var4)) {
                  var1.interactionManager.cancelBlockBreaking();
                  this.I_field_f86b4e4c.I_method_e4926dff();
               }

               this.I_field_670402ba = var4;
               this.I_field_5a = true;
               Direction var13 = I_method_80fed95c(var2, var4);
               if (!this.I_field_f86b4e4c.I_method_b97a0d1b(var4, var13)) {
                  return iiiIiIIII_Class465.Nested1_33b738a0.I_field_86e7b1e7;
               } else {
                  var1.interactionManager.updateBlockBreakingProgress(var4, var13);
                  var2.swingHand(var2.getActiveHand());
                  return iiiIiIIII_Class465.Nested1_33b738a0.I_field_86e7b1e7;
               }
            }
         }
      } else {
         return iiiIiIIII_Class465.Nested1_33b738a0.II_field_86e7b1e7;
      }
   }

   private iiiIiIIII_Class465.Nested1_33b738a0 i_method_11f5fff0() {
      MinecraftClient var1 = MinecraftClient.getInstance();
      ClientPlayerEntity var2 = var1.player;
      if (var2 == null) {
         return iiiIiIIII_Class465.Nested1_33b738a0.II_field_86e7b1e7;
      } else if (this.i_method_af4d9243(0.4) && var2.getY() >= this.i_field_fa2e3e6c.i_method_6d2ed9f2() - 0.05) {
         return iiiIiIIII_Class465.Nested1_33b738a0.i_field_86e7b1e7;
      } else {
         Vec3d var3 = new Vec3d(
            this.i_field_fa2e3e6c.I_method_6d204e12() + 0.5, this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15() + 0.5
         );
         double var4 = var3.x - var2.getX();
         double var6 = var3.z - var2.getZ();
         float var8 = (float)Math.toDegrees(Math.atan2(var6, var4)) - 90.0F;
         iiIiiIiII_Class437.I_method_cb5ea4a7(new iiIIiIIii_Class404(var8, 0.0F));
         iiIiiiiii_Class448 var9 = iiIiiIiIi_Class438.I_method_12f562b5().I_method_14b8caf5();
         var9.I_method_359d223f();
         var9.I_method_7e07d875(true);
         var9.i_method_7fcac895(false);
         var9.II_method_44ae3612(false);
         var9.Ii_method_46712632(false);
         var9.ii_method_7d0c3a12(false);
         var9.III_method_52d38c15(false);
         boolean var10 = var2.getY() < this.i_field_fa2e3e6c.i_method_6d2ed9f2() - 0.05;
         boolean var11 = var2.horizontalCollision || Math.hypot(var4, var6) < 0.6;
         var9.iI_method_7b4949f2(var10 && var2.isOnGround() && var11);
         return iiiIiIIII_Class465.Nested1_33b738a0.I_field_86e7b1e7;
      }
   }

   private static Direction I_method_80fed95c(ClientPlayerEntity var0, BlockPos var1) {
      Vec3d var2 = var0.getEyePos();
      Direction var3 = Direction.UP;
      double var4 = -Double.MAX_VALUE;

      for (Direction var9 : Direction.values()) {
         Vec3d var10 = Vec3d.ofCenter(var1).add(var9.getOffsetX() * 0.5, var9.getOffsetY() * 0.5, var9.getOffsetZ() * 0.5);
         Vec3d var11 = var10.subtract(var2).normalize();
         double var12 = var11.x * var9.getOffsetX() + var11.y * var9.getOffsetY() + var11.z * var9.getOffsetZ();
         double var14 = -var12;
         if (var14 > var4) {
            var4 = var14;
            var3 = var9;
         }
      }

      return var3;
   }

   @Override
   public void I_method_37257dff() {
      MinecraftClient var1 = MinecraftClient.getInstance();
      if (var1.interactionManager != null && this.I_field_5a) {
         var1.interactionManager.cancelBlockBreaking();
      }

      this.I_field_5a = false;
      this.I_field_670402ba = null;
      this.I_field_f86b4e4c.I_method_e4926dff();
      iiIiiiiii_Class448 var2 = iiIiiIiIi_Class438.I_method_12f562b5().I_method_14b8caf5();
      var2.I_method_7e07d875(false);
      var2.iI_method_7b4949f2(false);
      var2.III_method_52d38c15(false);
   }
}
