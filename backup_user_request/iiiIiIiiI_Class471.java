package rockstar.client;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LadderBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class iiiIiIiiI_Class471 extends iiiIiIIII_Class465 {
   private final iiiIiIiiI_Class471.Nested1_3588b480 I_field_bf45b207;

   public iiiIiIiiI_Class471(iiiIIiIIi_Class458 var1, iiiIIiIIi_Class458 var2, iiiIiIiiI_Class471.Nested1_3588b480 var3) {
      super(var1, var2);
      this.I_field_bf45b207 = var3;
   }

   public iiiIiIiiI_Class471.Nested1_3588b480 I_method_283a8c30() {
      return this.I_field_bf45b207;
   }

   @Override
   protected double i_method_373409cd() {
      return switch (this.I_field_bf45b207) {
         case I_field_bf45b207 -> 2.0;
         case i_field_bf45b207 -> 1.3;
         case II_field_bf45b207 -> 2.6;
      };
   }

   @Override
   public int I_method_37257df2() {
      return 100;
   }

   @Override
   public boolean I_method_a7f2ac8b(iiiIIIiIi_Class454 var1) {
      int var2 = this.i_field_fa2e3e6c.I_method_6d204e12() - this.I_field_fa2e3e6c.I_method_6d204e12();
      int var3 = this.i_field_fa2e3e6c.i_method_6d2ed9f2() - this.I_field_fa2e3e6c.i_method_6d2ed9f2();
      int var4 = this.i_field_fa2e3e6c.II_method_36f86d15() - this.I_field_fa2e3e6c.II_method_36f86d15();
      switch (this.I_field_bf45b207) {
         case I_field_bf45b207:
            if (var2 == 0 && var4 == 0 && var3 == 1) {
               return var1.Iii_method_f9d18c08(
                  this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15()
               );
            }

            return false;
         case i_field_bf45b207:
            if (var2 == 0 && var4 == 0 && var3 == -1) {
               if (var1.Iii_method_f9d18c08(
                  this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15()
               )) {
                  return true;
               }

               if (var1.IiI_method_5d0a23e8(
                  this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15()
               )) {
                  this.I_method_3ca01ff(
                     this.I_field_fa2e3e6c.i_method_6d2ed9f2(),
                     var1.I_method_ca82d452(
                        this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15()
                     )
                  );
                  return true;
               }

               return var1.Ii_method_bbfd4a25(
                  this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15()
               );
            }

            return false;
         case II_field_bf45b207:
            if (Math.abs(var2) + Math.abs(var4) == 1 && var3 == 1) {
               double var5 = var1.I_method_ca82d452(
                  this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15()
               );
               if (!Double.isNaN(var5) && !(var5 - this.i_field_fa2e3e6c.i_method_6d2ed9f2() > 0.4)) {
                  if (!var1.I_method_ca82d468(
                        this.I_field_fa2e3e6c.I_method_6d204e12(), this.I_field_fa2e3e6c.i_method_6d2ed9f2() + 1, this.I_field_fa2e3e6c.II_method_36f86d15()
                     )
                     && !var1.iI_method_1b5b7de5(
                        this.I_field_fa2e3e6c.I_method_6d204e12(), this.I_field_fa2e3e6c.i_method_6d2ed9f2() + 1, this.I_field_fa2e3e6c.II_method_36f86d15()
                     )) {
                     return false;
                  }

                  this.I_method_3ca01ff(this.I_field_fa2e3e6c.i_method_6d2ed9f2(), var5);
                  return var1.I_method_7085e723(
                     this.I_field_fa2e3e6c.I_method_6d204e12(),
                     this.I_field_fa2e3e6c.II_method_36f86d15(),
                     this.i_field_fa2e3e6c.I_method_6d204e12(),
                     this.i_field_fa2e3e6c.II_method_36f86d15(),
                     var5 + 0.05,
                     var5 + 1.8
                  );
               }

               return false;
            }

            return false;
         default:
            return false;
      }
   }

   @Override
   public iiiIiIIII_Class465.Nested1_33b738a0 I_method_8cdd8810() {
      ClientPlayerEntity var1 = I_method_855d7990();
      if (var1 == null) {
         return iiiIiIIII_Class465.Nested1_33b738a0.II_field_86e7b1e7;
      } else {
         double var2 = var1.getX();
         double var4 = var1.getY();
         double var6 = var1.getZ();
         iiIiiiiii_Class448 var8 = I_method_20116ef5();
         var8.i_method_7fcac895(false);
         var8.II_method_44ae3612(false);
         var8.Ii_method_46712632(false);
         var8.ii_method_7d0c3a12(false);
         var8.III_method_52d38c15(false);
         switch (this.I_field_bf45b207) {
            case I_field_bf45b207:
               if (var4 >= this.i_field_fa2e3e6c.i_method_6d2ed9f2() - 0.05) {
                  return iiiIiIIII_Class465.Nested1_33b738a0.i_field_86e7b1e7;
               } else if (var4 < this.I_field_fa2e3e6c.i_method_6d2ed9f2() - 1.3 && !var1.isClimbing() && !var1.isOnGround()) {
                  return iiiIiIIII_Class465.Nested1_33b738a0.II_field_86e7b1e7;
               } else {
                  double var17 = this.I_field_fa2e3e6c.I_method_6d204e12() + 0.5;
                  double var18 = this.I_field_fa2e3e6c.II_method_36f86d15() + 0.5;
                  double var13 = Math.hypot(var2 - var17, var6 - var18);
                  if (var13 > 0.3) {
                     I_method_3caf23f(I_method_3ca01ef(var17 - var2, var18 - var6), 0.0F);
                     var8.I_method_7e07d875(true);
                     var8.iI_method_7b4949f2(true);
                     return iiiIiIIII_Class465.Nested1_33b738a0.I_field_86e7b1e7;
                  }

                  Direction var15 = this.I_method_a44c849f();
                  if (var15 != null) {
                     I_method_3caf23f(I_method_3ca01ef(var15.getOffsetX(), var15.getOffsetZ()), 0.0F);
                     var8.I_method_7e07d875(true);
                  } else {
                     var8.I_method_7e07d875(false);
                  }

                  var8.iI_method_7b4949f2(true);
                  return iiiIiIIII_Class465.Nested1_33b738a0.I_field_86e7b1e7;
               }
            case i_field_bf45b207:
               boolean var16 = var4 <= this.i_field_fa2e3e6c.i_method_6d2ed9f2() + 0.35
                  || var1.isOnGround() && var4 <= this.I_field_fa2e3e6c.i_method_6d2ed9f2() + 0.05
                  || var1.isTouchingWater() && var4 <= this.i_field_fa2e3e6c.i_method_6d2ed9f2() + 1.0;
               if (var16) {
                  return iiiIiIIII_Class465.Nested1_33b738a0.i_field_86e7b1e7;
               } else {
                  var8.I_method_7e07d875(false);
                  var8.iI_method_7b4949f2(false);
                  return iiiIiIIII_Class465.Nested1_33b738a0.I_field_86e7b1e7;
               }
            case II_field_bf45b207:
               double var9 = var2 - (this.i_field_fa2e3e6c.I_method_6d204e12() + 0.5);
               double var11 = var6 - (this.i_field_fa2e3e6c.II_method_36f86d15() + 0.5);
               if (var1.isOnGround() && Math.abs(var4 - this.II_field_44) < 0.6 && Math.hypot(var9, var11) < 0.5) {
                  return iiiIiIIII_Class465.Nested1_33b738a0.i_field_86e7b1e7;
               } else {
                  if (var4 < this.I_field_fa2e3e6c.i_method_6d2ed9f2() - 1.5 && !var1.isClimbing()) {
                     return iiiIiIIII_Class465.Nested1_33b738a0.II_field_86e7b1e7;
                  }

                  this.i_method_3a6515df(this.i_field_fa2e3e6c.I_method_6d204e12() + 0.5, this.i_field_fa2e3e6c.II_method_36f86d15() + 0.5);
                  var8.I_method_7e07d875(true);
                  var8.iI_method_7b4949f2(true);
                  return iiiIiIIII_Class465.Nested1_33b738a0.I_field_86e7b1e7;
               }
            default:
               return iiiIiIIII_Class465.Nested1_33b738a0.II_field_86e7b1e7;
         }
      }
   }

   private Direction I_method_a44c849f() {
      ClientWorld var1 = MinecraftClient.getInstance().world;
      if (var1 == null) {
         return null;
      } else {
         BlockState var2 = var1.getBlockState(
            new BlockPos(this.I_field_fa2e3e6c.I_method_6d204e12(), this.I_field_fa2e3e6c.i_method_6d2ed9f2(), this.I_field_fa2e3e6c.II_method_36f86d15())
         );
         return var2.isOf(Blocks.LADDER) ? ((Direction)var2.get(LadderBlock.FACING)).getOpposite() : null;
      }
   }

   @Override
   public void I_method_37257dff() {
      iiIiiiiii_Class448 var1 = I_method_20116ef5();
      var1.I_method_7e07d875(false);
      var1.iI_method_7b4949f2(false);
   }

   public static enum Nested1_3588b480 {
      I_field_bf45b207,
      i_field_bf45b207,
      II_field_bf45b207;

      public static iiiIiIiiI_Class471.Nested1_3588b480[] I_method_226e2f28() {
         return values();
      }

      public static iiiIiIiiI_Class471.Nested1_3588b480 I_method_35036f35(String var0) {
         return Enum.valueOf(iiiIiIiiI_Class471.Nested1_3588b480.class, var0);
      }
   }
}
