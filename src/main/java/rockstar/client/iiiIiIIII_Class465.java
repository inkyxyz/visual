package rockstar.client;

import net.minecraft.block.BlockState;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class iiiIiIIII_Class465 {
   protected final iiiIIiIIi_Class458 I_field_fa2e3e6c;
   protected final iiiIIiIIi_Class458 i_field_fa2e3e6c;
   @Nullable
   protected iiiIiIIII_Class465 I_field_2f065e4c;
   protected double I_field_44;
   protected double i_field_44;
   protected double II_field_44;

   protected iiiIiIIII_Class465(iiiIIiIIi_Class458 var1, iiiIIiIIi_Class458 var2) {
      this.I_field_fa2e3e6c = var1;
      this.i_field_fa2e3e6c = var2;
      this.i_field_44 = var1.i_method_6d2ed9f2();
      this.II_field_44 = var2.i_method_6d2ed9f2();
   }

   public iiiIIiIIi_Class458 I_method_48c58ad5() {
      return this.I_field_fa2e3e6c;
   }

   public iiiIIiIIi_Class458 i_method_5e5afeb5() {
      return this.i_field_fa2e3e6c;
   }

   public void I_method_6d6ea8a7(@Nullable iiiIiIIII_Class465 var1) {
      this.I_field_2f065e4c = var1;
   }

   @Nullable
   public iiiIiIIII_Class465 I_method_7d9daab5() {
      return this.I_field_2f065e4c;
   }

   public boolean I_method_ad8aa223(double var1) {
      ClientPlayerEntity var3 = I_method_855d7990();
      if (var3 == null) {
         return false;
      } else {
         double var4 = var3.getX() - (this.i_field_fa2e3e6c.I_method_6d204e12() + 0.5);
         double var6 = var3.getZ() - (this.i_field_fa2e3e6c.II_method_36f86d15() + 0.5);
         return var4 * var4 + var6 * var6 < var1 * var1;
      }
   }

   public void I_method_ad8aa21f(double var1) {
      this.I_field_44 += var1;
   }

   public void I_method_3ca01ff(double var1, double var3) {
      this.i_field_44 = var1;
      this.II_field_44 = var3;
   }

   public boolean I_method_37257e03() {
      return true;
   }

   public boolean i_method_373409e3() {
      return true;
   }

   public final double I_method_37257ded() {
      return this.i_method_373409cd() + this.I_field_44;
   }

   protected abstract double i_method_373409cd();

   public int I_method_37257df2() {
      return 60;
   }

   public abstract boolean I_method_a7f2ac8b(iiiIIIiIi_Class454 var1);

   public abstract iiiIiIIII_Class465.Nested1_33b738a0 I_method_8cdd8810();

   public void I_method_37257dff() {
   }

   @Nullable
   protected static ClientPlayerEntity I_method_855d7990() {
      return MinecraftClient.getInstance().player;
   }

   protected static iiIiiiiii_Class448 I_method_20116ef5() {
      iiIiiiiii_Class448 var0 = iiIiiIiIi_Class438.I_method_12f562b5().I_method_14b8caf5();
      var0.I_method_359d223f();
      return var0;
   }

   protected static void I_method_3caf23f(float var0, float var1) {
      iiIiiIiII_Class437.I_method_cb5ea4a7(new iiIIiIIii_Class404(var0, var1));
   }

   protected static float I_method_37257def() {
      iiIIiIiII_Class405 var0 = iiIiiIiIi_Class438.I_method_12f562b5().I_method_762df6b5();
      ClientPlayerEntity var1 = I_method_855d7990();
      if (!var0.I_method_3d166e03() && var1 != null) {
         return var0.II_method_f098f858().I_method_14534e0f();
      } else {
         return var1 != null ? var1.getYaw() : 0.0F;
      }
   }

   protected static float I_method_3ca01ef(double var0, double var2) {
      return (float)Math.toDegrees(Math.atan2(var2, var0)) - 90.0F;
   }

   protected void i_method_3a6515df(double var1, double var3) {
      ClientPlayerEntity var5 = I_method_855d7990();
      if (var5 != null) {
         double var6 = var1 - var5.getX();
         double var8 = var3 - var5.getZ();
         if (Math.hypot(var6, var8) < 0.3) {
            float var10 = this.i_method_373409cf();
            if (!Float.isNaN(var10)) {
               I_method_3caf23f(var10, 0.0F);
            }
         } else {
            I_method_3caf23f(I_method_3ca01ef(var6, var8), 0.0F);
         }
      }
   }

   protected void i_method_af4d923f(double var1) {
      ClientPlayerEntity var3 = I_method_855d7990();
      if (var3 != null) {
         double var4 = this.I_field_fa2e3e6c.I_method_6d204e12() + 0.5;
         double var6 = this.I_field_fa2e3e6c.II_method_36f86d15() + 0.5;
         double var8 = this.i_field_fa2e3e6c.I_method_6d204e12() + 0.5 - var4;
         double var10 = this.i_field_fa2e3e6c.II_method_36f86d15() + 0.5 - var6;
         double var12 = Math.sqrt(var8 * var8 + var10 * var10);
         if (var12 < 1.0E-6) {
            this.i_method_3a6515df(this.i_field_fa2e3e6c.I_method_6d204e12() + 0.5, this.i_field_fa2e3e6c.II_method_36f86d15() + 0.5);
         } else {
            double var14 = var8 / var12;
            double var16 = var10 / var12;
            double var18 = Math.min(var12, Math.max(0.0, this.i_method_3a6515cd(var3.getX(), var3.getZ())) + var1);
            this.i_method_3a6515df(var4 + var14 * var18, var6 + var16 * var18);
         }
      }
   }

   protected Vec3d I_method_bb92fd39() {
      return new Vec3d(this.i_field_fa2e3e6c.I_method_6d204e12() + 0.5, this.II_field_44, this.i_field_fa2e3e6c.II_method_36f86d15() + 0.5);
   }

   protected boolean i_method_af4d9243(double var1) {
      ClientPlayerEntity var3 = I_method_855d7990();
      if (var3 == null) {
         return false;
      } else {
         double var4 = this.I_field_fa2e3e6c.I_method_6d204e12() + 0.5;
         double var6 = this.I_field_fa2e3e6c.II_method_36f86d15() + 0.5;
         double var8 = this.i_field_fa2e3e6c.I_method_6d204e12() + 0.5 - var4;
         double var10 = this.i_field_fa2e3e6c.II_method_36f86d15() + 0.5 - var6;
         double var12 = Math.sqrt(var8 * var8 + var10 * var10);
         if (var12 < 1.0E-6) {
            double var24 = var3.getX() - (this.i_field_fa2e3e6c.I_method_6d204e12() + 0.5);
            double var25 = var3.getZ() - (this.i_field_fa2e3e6c.II_method_36f86d15() + 0.5);
            return var24 * var24 + var25 * var25 < var1 * var1;
         } else {
            double var14 = var8 / var12;
            double var16 = var10 / var12;
            double var18 = var3.getX() - var4;
            double var20 = var3.getZ() - var6;
            double var22 = var18 * var14 + var20 * var16;
            return var22 >= var12 - var1;
         }
      }
   }

   protected float i_method_373409cf() {
      double var1 = this.i_field_fa2e3e6c.I_method_6d204e12() + 0.5 - (this.I_field_fa2e3e6c.I_method_6d204e12() + 0.5);
      double var3 = this.i_field_fa2e3e6c.II_method_36f86d15() + 0.5 - (this.I_field_fa2e3e6c.II_method_36f86d15() + 0.5);
      return var1 == 0.0 && var3 == 0.0 ? Float.NaN : I_method_3ca01ef(var1, var3);
   }

   protected boolean II_method_58e4f40(double var1) {
      if (this.I_field_2f065e4c == null) {
         return false;
      } else {
         float var3 = this.i_method_373409cf();
         float var4 = this.I_field_2f065e4c.i_method_373409cf();
         if (!Float.isNaN(var3) && !Float.isNaN(var4)) {
            float var5 = var4 - var3;

            while (var5 > 180.0F) {
               var5 -= 360.0F;
            }

            while (var5 < -180.0F) {
               var5 += 360.0F;
            }

            return Math.abs(var5) >= var1;
         } else {
            return false;
         }
      }
   }

   protected double[] I_method_3cbe87b(int var1) {
      ClientPlayerEntity var2 = I_method_855d7990();
      if (var2 == null) {
         return new double[]{0.0, 0.0};
      } else {
         Vec3d var3 = var2.getVelocity();
         double var4 = var2.getX();
         double var6 = var2.getZ();
         double var8 = var3.x;
         double var10 = var3.z;

         for (int var12 = 0; var12 < var1; var12++) {
            var4 += var8;
            var6 += var10;
            var8 *= 0.91;
            var10 *= 0.91;
         }

         return new double[]{var4, var6};
      }
   }

   protected double I_method_3ca01ed(double var1, double var3) {
      double var5 = this.I_field_fa2e3e6c.I_method_6d204e12() + 0.5;
      double var7 = this.I_field_fa2e3e6c.II_method_36f86d15() + 0.5;
      double var9 = this.i_field_fa2e3e6c.I_method_6d204e12() + 0.5 - var5;
      double var11 = this.i_field_fa2e3e6c.II_method_36f86d15() + 0.5 - var7;
      double var13 = Math.sqrt(var9 * var9 + var11 * var11);
      double var15 = var1 - var5;
      double var17 = var3 - var7;
      if (var13 < 1.0E-6) {
         return Math.sqrt(var15 * var15 + var17 * var17);
      } else {
         double var19 = (var15 * var9 + var17 * var11) / var13;
         double var21 = var15 * var15 + var17 * var17;
         return Math.sqrt(Math.max(0.0, var21 - var19 * var19));
      }
   }

   protected double i_method_3a6515cd(double var1, double var3) {
      double var5 = this.I_field_fa2e3e6c.I_method_6d204e12() + 0.5;
      double var7 = this.I_field_fa2e3e6c.II_method_36f86d15() + 0.5;
      double var9 = this.i_field_fa2e3e6c.I_method_6d204e12() + 0.5 - var5;
      double var11 = this.i_field_fa2e3e6c.II_method_36f86d15() + 0.5 - var7;
      double var13 = Math.sqrt(var9 * var9 + var11 * var11);
      if (var13 < 1.0E-6) {
         return 0.0;
      } else {
         double var15 = var9 / var13;
         double var17 = var11 / var13;
         return (var1 - var5) * var15 + (var3 - var7) * var17;
      }
   }

   protected double II_method_ad993930() {
      ClientPlayerEntity var1 = I_method_855d7990();
      if (var1 == null) {
         return 0.0;
      } else {
         double var2 = this.i_field_fa2e3e6c.I_method_6d204e12() + 0.5 - (this.I_field_fa2e3e6c.I_method_6d204e12() + 0.5);
         double var4 = this.i_field_fa2e3e6c.II_method_36f86d15() + 0.5 - (this.I_field_fa2e3e6c.II_method_36f86d15() + 0.5);
         double var6 = Math.sqrt(var2 * var2 + var4 * var4);
         if (var6 < 1.0E-6) {
            return 0.0;
         } else {
            Vec3d var8 = var1.getVelocity();
            return (var8.x * var2 + var8.z * var4) / var6;
         }
      }
   }

   protected double Ii_method_ada7c510() {
      double var1 = this.i_field_fa2e3e6c.I_method_6d204e12() - this.I_field_fa2e3e6c.I_method_6d204e12();
      double var3 = this.i_field_fa2e3e6c.II_method_36f86d15() - this.I_field_fa2e3e6c.II_method_36f86d15();
      return Math.sqrt(var1 * var1 + var3 * var3);
   }

   protected void I_method_42025ce7(iiIiiiiii_Class448 var1) {
      ClientPlayerEntity var2 = I_method_855d7990();
      if (var2 != null && this.I_field_2f065e4c != null) {
         if (this.II_method_58e4f40(60.0)) {
            double[] var3 = this.I_method_3cbe87b(6);
            double var4 = this.i_method_3a6515cd(var3[0], var3[1]);
            double var6 = this.Ii_method_ada7c510();
            if (var4 > var6 + 0.05) {
               var1.III_method_52d38c15(false);
               var1.I_method_7e07d875(false);
               var1.i_method_7fcac895(true);
            } else if (var4 > var6 - 0.25) {
               var1.III_method_52d38c15(false);
               if (var2.isSprinting()) {
                  var1.I_method_7e07d875(false);
               }
            }
         }
      }
   }

   protected void I_method_d724943a(iiIiiiiii_Class448 var1, iiiIiIIII_Class465.Nested1_33b73880 var2) {
      var1.II_method_44ae3612(false);
      var1.Ii_method_46712632(false);
      var1.ii_method_7d0c3a12(false);
      switch (var2) {
         case I_field_86e7ae07:
            var1.I_method_7e07d875(true);
            var1.i_method_7fcac895(false);
            var1.III_method_52d38c15(true);
            break;
         case i_field_86e7ae07:
            var1.I_method_7e07d875(true);
            var1.i_method_7fcac895(false);
            var1.III_method_52d38c15(false);
            break;
         case II_field_86e7ae07:
            var1.I_method_7e07d875(false);
            var1.i_method_7fcac895(false);
            var1.III_method_52d38c15(false);
            break;
         case Ii_field_86e7ae07:
            var1.I_method_7e07d875(false);
            var1.i_method_7fcac895(true);
            var1.III_method_52d38c15(false);
      }
   }

   protected void i_method_df1b6507(iiIiiiiii_Class448 var1) {
      ClientPlayerEntity var2 = I_method_855d7990();
      if (var2 != null) {
         double var3 = this.I_field_fa2e3e6c.I_method_6d204e12() + 0.5;
         double var5 = this.I_field_fa2e3e6c.II_method_36f86d15() + 0.5;
         double var7 = this.i_field_fa2e3e6c.I_method_6d204e12() + 0.5 - var3;
         double var9 = this.i_field_fa2e3e6c.II_method_36f86d15() + 0.5 - var5;
         double var11 = Math.sqrt(var7 * var7 + var9 * var9);
         if (!(var11 < 1.0E-6)) {
            double var13 = var7 / var11;
            double var15 = var9 / var11;
            double var17 = var2.getX() - var3;
            double var19 = var2.getZ() - var5;
            double var21 = var17 * var13 + var19 * var15;
            double var23 = var17 - var21 * var13;
            double var25 = var19 - var21 * var15;
            if (!(var23 * var23 + var25 * var25 < 0.0025000000000000005)) {
               double var27 = Math.toRadians(I_method_37257def());
               double var29 = Math.cos(var27);
               double var31 = Math.sin(var27);
               boolean var33 = -var23 * var29 + -var25 * var31 > 0.0;
               var1.II_method_44ae3612(var33);
               var1.Ii_method_46712632(!var33);
            }
         }
      }
   }

   protected boolean II_method_ad993946() {
      MinecraftClient var1 = MinecraftClient.getInstance();
      ClientPlayerEntity var2 = var1.player;
      ClientWorld var3 = var1.world;
      if (var2 == null || var3 == null) {
         return false;
      } else if (!var2.isTouchingWater() && !var2.isClimbing()) {
         BlockPos var4 = BlockPos.ofFloored(var2.getX(), var2.getBoundingBox().minY + 1.0E-4, var2.getZ());
         return I_method_226e7fe6(var3, var4.getX(), var4.getY(), var4.getZ())
            || I_method_226e7fe6(
               var3, this.I_field_fa2e3e6c.I_method_6d204e12(), this.I_field_fa2e3e6c.i_method_6d2ed9f2(), this.I_field_fa2e3e6c.II_method_36f86d15()
            )
            || I_method_226e7fe6(
               var3, this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15()
            );
      } else {
         return false;
      }
   }

   private static boolean I_method_226e7fe6(World var0, int var1, int var2, int var3) {
      return I_method_8880b66c(var0, new BlockPos(var1, var2 + 1, var3), var1, var2, var3)
         || I_method_8880b66c(var0, new BlockPos(var1, var2 + 2, var3), var1, var2, var3);
   }

   private static boolean I_method_8880b66c(World var0, BlockPos var1, int var2, int var3, int var4) {
      BlockState var5 = var0.getBlockState(var1);
      return var5.getBlock() instanceof TrapdoorBlock && iiiIIIiIi_Class454.I_method_c621a877(var0, var5, var1, var2, var3, var4);
   }

   protected static enum Nested1_33b73880 {
      I_field_86e7ae07,
      i_field_86e7ae07,
      II_field_86e7ae07,
      Ii_field_86e7ae07;

      public static iiiIiIIII_Class465.Nested1_33b73880[] I_method_9f9daf28() {
         return values();
      }

      public static iiiIiIIII_Class465.Nested1_33b73880 I_method_ab506735(String var0) {
         return Enum.valueOf(iiiIiIIII_Class465.Nested1_33b73880.class, var0);
      }
   }

   public static enum Nested1_33b738a0 {
      I_field_86e7b1e7,
      i_field_86e7b1e7,
      II_field_86e7b1e7;

      public static iiiIiIIII_Class465.Nested1_33b738a0[] I_method_7ab5ab28() {
         return values();
      }

      public static iiiIiIIII_Class465.Nested1_33b738a0 I_method_6663b6f5(String var0) {
         return Enum.valueOf(iiiIiIIII_Class465.Nested1_33b738a0.class, var0);
      }
   }
}
