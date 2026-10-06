package rockstar.client;

import net.minecraft.client.network.ClientPlayerEntity;

public class iiiIiiIii_Class476 extends iiiIiIIII_Class465 {
   private static final int I_field_49 = 60;
   private static final int i_field_49 = 130;
   private static final double Ii_field_44 = 1.5;
   private final iiiIiiIii_Class476.Nested1_6a615060 I_field_25809227;

   public iiiIiiIii_Class476(iiiIIiIIi_Class458 var1, iiiIIiIIi_Class458 var2, iiiIiiIii_Class476.Nested1_6a615060 var3) {
      super(var1, var2);
      this.I_field_25809227 = var3;
   }

   public iiiIiiIii_Class476.Nested1_6a615060 I_method_1f815470() {
      return this.I_field_25809227;
   }

   @Override
   protected double i_method_373409cd() {
      return switch (this.I_field_25809227) {
         case I_field_25809227 -> 3.0 * Math.max(1.0, this.Ii_method_ada7c510());
         case i_field_25809227 -> 3.5;
         case II_field_25809227 -> 3.0;
         case Ii_field_25809227 -> 3.0;
         case iI_field_25809227 -> 3.5;
         case ii_field_25809227 -> 4.5;
      };
   }

   @Override
   public int I_method_37257df2() {
      return 120;
   }

   @Override
   public boolean I_method_37257e03() {
      return this.I_field_25809227 != iiiIiiIii_Class476.Nested1_6a615060.Ii_field_25809227;
   }

   @Override
   public boolean i_method_373409e3() {
      return false;
   }

   @Override
   public boolean I_method_a7f2ac8b(iiiIIIiIi_Class454 var1) {
      int var2 = this.i_field_fa2e3e6c.I_method_6d204e12() - this.I_field_fa2e3e6c.I_method_6d204e12();
      int var3 = this.i_field_fa2e3e6c.i_method_6d2ed9f2() - this.I_field_fa2e3e6c.i_method_6d2ed9f2();
      int var4 = this.i_field_fa2e3e6c.II_method_36f86d15() - this.I_field_fa2e3e6c.II_method_36f86d15();
      int var5 = Math.abs(var2) + Math.abs(var4);
      switch (this.I_field_25809227) {
         case I_field_25809227:
            boolean var12 = var5 == 1;
            boolean var7 = Math.abs(var2) == 1 && Math.abs(var4) == 1;
            if (var3 == 0 && (var12 || var7)) {
               if (!var1.Ii_method_bbfd4a25(
                  this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15()
               )) {
                  return false;
               }

               if (!var1.IIi_method_fdabf028(
                  this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2() + 1, this.i_field_fa2e3e6c.II_method_36f86d15()
               )) {
                  return false;
               }

               if (this.i_method_2be2c48b(var1)) {
                  this.I_method_ad8aa21f(1.5 * (var7 ? 1.41 : 1.0));
               }

               return var1.I_method_7085e723(
                  this.I_field_fa2e3e6c.I_method_6d204e12(),
                  this.I_field_fa2e3e6c.II_method_36f86d15(),
                  this.i_field_fa2e3e6c.I_method_6d204e12(),
                  this.i_field_fa2e3e6c.II_method_36f86d15(),
                  this.i_field_fa2e3e6c.i_method_6d2ed9f2() + 0.1,
                  this.i_field_fa2e3e6c.i_method_6d2ed9f2() + 1.7
               );
            }

            return false;
         case i_field_25809227:
            if (var5 == 0 && var3 == 1) {
               if (!var1.Ii_method_bbfd4a25(
                  this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15()
               )) {
                  return false;
               }

               return var1.IIi_method_fdabf028(
                  this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2() + 1, this.i_field_fa2e3e6c.II_method_36f86d15()
               );
            }

            return false;
         case II_field_25809227:
            if (var5 == 0 && var3 == -1) {
               if (!var1.Ii_method_bbfd4a25(
                  this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15()
               )) {
                  return false;
               }

               return !var1.ii_method_b822e605(
                  this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2() - 1, this.i_field_fa2e3e6c.II_method_36f86d15()
               );
            }

            return false;
         case Ii_field_25809227:
            if (var5 == 1 && var3 >= -1 && var3 <= 0) {
               if (!var1.Ii_method_bbfd4a25(
                  this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15()
               )) {
                  return false;
               }

               if (!var1.IIi_method_fdabf028(
                  this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2() + 1, this.i_field_fa2e3e6c.II_method_36f86d15()
               )) {
                  return false;
               }

               double var11 = var1.I_method_ca82d452(
                  this.I_field_fa2e3e6c.I_method_6d204e12(), this.I_field_fa2e3e6c.i_method_6d2ed9f2(), this.I_field_fa2e3e6c.II_method_36f86d15()
               );
               if (Double.isNaN(var11)) {
                  var11 = this.I_field_fa2e3e6c.i_method_6d2ed9f2();
               }

               this.I_method_3ca01ff(var11, this.i_field_fa2e3e6c.i_method_6d2ed9f2());
               return var1.I_method_7085e723(
                  this.I_field_fa2e3e6c.I_method_6d204e12(),
                  this.I_field_fa2e3e6c.II_method_36f86d15(),
                  this.i_field_fa2e3e6c.I_method_6d204e12(),
                  this.i_field_fa2e3e6c.II_method_36f86d15(),
                  var11 + 0.05,
                  var11 + 1.8
               );
            }

            return false;
         case iI_field_25809227:
            if (var5 == 1 && var3 == 0) {
               double var10 = var1.I_method_ca82d452(
                  this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15()
               );
               if (!Double.isNaN(var10) && !(Math.abs(var10 - this.I_field_fa2e3e6c.i_method_6d2ed9f2()) > 0.9)) {
                  this.I_method_3ca01ff(this.I_field_fa2e3e6c.i_method_6d2ed9f2(), var10);
                  return var1.I_method_7085e723(
                     this.I_field_fa2e3e6c.I_method_6d204e12(),
                     this.I_field_fa2e3e6c.II_method_36f86d15(),
                     this.i_field_fa2e3e6c.I_method_6d204e12(),
                     this.i_field_fa2e3e6c.II_method_36f86d15(),
                     var10 + 0.05,
                     var10 + 1.8
                  );
               }

               return false;
            }

            return false;
         case ii_field_25809227:
            if (var5 == 1 && var3 == 1) {
               double var6 = var1.I_method_ca82d452(
                  this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15()
               );
               if (Double.isNaN(var6)) {
                  return false;
               }

               double var8 = var6 - this.I_field_fa2e3e6c.i_method_6d2ed9f2();
               if (!(var8 < 0.4) && !(var8 > 1.4)) {
                  if (!var1.IIi_method_fdabf028(
                     this.I_field_fa2e3e6c.I_method_6d204e12(), this.I_field_fa2e3e6c.i_method_6d2ed9f2() + 1, this.I_field_fa2e3e6c.II_method_36f86d15()
                  )) {
                     return false;
                  }

                  this.I_method_3ca01ff(this.I_field_fa2e3e6c.i_method_6d2ed9f2(), var6);
                  return var1.I_method_7085e723(
                     this.I_field_fa2e3e6c.I_method_6d204e12(),
                     this.I_field_fa2e3e6c.II_method_36f86d15(),
                     this.i_field_fa2e3e6c.I_method_6d204e12(),
                     this.i_field_fa2e3e6c.II_method_36f86d15(),
                     var6 + 0.05,
                     var6 + 1.8
                  );
               }

               return false;
            }

            return false;
         default:
            return false;
      }
   }

   private boolean i_method_2be2c48b(iiiIIIiIi_Class454 var1) {
      return var1.II_method_1f35e205(
            this.I_field_fa2e3e6c.I_method_6d204e12(), this.I_field_fa2e3e6c.i_method_6d2ed9f2() + 1, this.I_field_fa2e3e6c.II_method_36f86d15()
         )
         && var1.II_method_1f35e205(
            this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2() + 1, this.i_field_fa2e3e6c.II_method_36f86d15()
         );
   }

   @Override
   public iiiIiIIII_Class465.Nested1_33b738a0 I_method_8cdd8810() {
      ClientPlayerEntity var1 = I_method_855d7990();
      if (var1 == null) {
         return iiiIiIIII_Class465.Nested1_33b738a0.II_field_86e7b1e7;
      } else if (var1.isSubmergedInWater() && var1.getAir() < 60) {
         return iiiIiIIII_Class465.Nested1_33b738a0.II_field_86e7b1e7;
      } else {
         double var2 = var1.getX();
         double var4 = var1.getY();
         double var6 = var1.getZ();
         double var8 = var2 - (this.i_field_fa2e3e6c.I_method_6d204e12() + 0.5);
         double var10 = var6 - (this.i_field_fa2e3e6c.II_method_36f86d15() + 0.5);
         double var12 = Math.hypot(var8, var10);
         boolean var14 = this.I_field_25809227 == iiiIiiIii_Class476.Nested1_6a615060.iI_field_25809227
            || this.I_field_25809227 == iiiIiiIii_Class476.Nested1_6a615060.ii_field_25809227;
         if (var14) {
            if (var1.isOnGround() && Math.abs(var4 - this.II_field_44) < 0.5 && var12 < 0.6) {
               return iiiIiIIII_Class465.Nested1_33b738a0.i_field_86e7b1e7;
            }
         } else if (var12 < 0.5 && Math.abs(var4 - (this.i_field_fa2e3e6c.i_method_6d2ed9f2() + 0.2)) < 0.8) {
            return iiiIiIIII_Class465.Nested1_33b738a0.i_field_86e7b1e7;
         }

         if (var4 < this.i_field_fa2e3e6c.i_method_6d2ed9f2() - 2.5 && !var1.isTouchingWater()) {
            return iiiIiIIII_Class465.Nested1_33b738a0.II_field_86e7b1e7;
         } else {
            iiIiiiiii_Class448 var15 = I_method_20116ef5();
            var15.i_method_7fcac895(false);
            var15.II_method_44ae3612(false);
            var15.Ii_method_46712632(false);
            var15.ii_method_7d0c3a12(false);
            if (this.I_field_25809227 != iiiIiiIii_Class476.Nested1_6a615060.i_field_25809227
               && this.I_field_25809227 != iiiIiiIii_Class476.Nested1_6a615060.II_field_25809227) {
               double var16 = var14 ? this.II_field_44 + 0.3 : this.i_field_fa2e3e6c.i_method_6d2ed9f2() + 0.6;
               double var18 = this.i_field_fa2e3e6c.I_method_6d204e12() + 0.5 - var2;
               double var20 = this.i_field_fa2e3e6c.II_method_36f86d15() + 0.5 - var6;
               float var22;
               if (Math.hypot(var18, var20) < 0.3) {
                  float var23 = this.i_method_373409cf();
                  var22 = Float.isNaN(var23) ? var1.getYaw() : var23;
               } else {
                  var22 = I_method_3ca01ef(var18, var20);
               }

               boolean var30 = !var14
                  && this.I_field_2f065e4c instanceof iiiIiiIii_Class476 var24
                  && var24.I_method_1f815470() == iiiIiiIii_Class476.Nested1_6a615060.I_field_25809227;
               float var31 = 0.0F;
               boolean var33;
               if (var14) {
                  var33 = true;
               } else if (var30) {
                  if (var1.getAir() < 130) {
                     var31 = -25.0F;
                     var33 = true;
                  } else if (!var1.isSubmergedInWater()) {
                     var31 = 25.0F;
                     var33 = false;
                  } else {
                     double var26 = this.i_field_fa2e3e6c.i_method_6d2ed9f2() + 0.45;
                     var31 = var4 > var26 + 0.15 ? 8.0F : (var4 < var26 - 0.15 ? -10.0F : 0.0F);
                     var33 = false;
                  }
               } else {
                  if (var1.isSubmergedInWater()) {
                     double var34 = var16 - var1.getEyeY();
                     double var28 = Math.max(0.05, Math.hypot(var18, var20));
                     var31 = (float)(-Math.toDegrees(Math.atan2(var34, var28)));
                     var31 = Math.max(-75.0F, Math.min(75.0F, var31));
                  }

                  var33 = var4 < this.i_field_fa2e3e6c.i_method_6d2ed9f2() + 0.1;
               }

               I_method_3caf23f(var22, var31);
               var15.I_method_7e07d875(true);
               var15.III_method_52d38c15(!var14);
               var15.iI_method_7b4949f2(var33);
               return iiiIiIIII_Class465.Nested1_33b738a0.I_field_86e7b1e7;
            } else {
               var15.I_method_7e07d875(false);
               var15.III_method_52d38c15(false);
               var15.iI_method_7b4949f2(this.I_field_25809227 == iiiIiiIii_Class476.Nested1_6a615060.i_field_25809227);
               var15.ii_method_7d0c3a12(this.I_field_25809227 == iiiIiiIii_Class476.Nested1_6a615060.II_field_25809227);
               return iiiIiIIII_Class465.Nested1_33b738a0.I_field_86e7b1e7;
            }
         }
      }
   }

   @Override
   public void I_method_37257dff() {
      iiIiiiiii_Class448 var1 = I_method_20116ef5();
      var1.I_method_7e07d875(false);
      var1.III_method_52d38c15(false);
      var1.iI_method_7b4949f2(false);
   }

   public static enum Nested1_6a615060 {
      I_field_25809227,
      i_field_25809227,
      II_field_25809227,
      Ii_field_25809227,
      iI_field_25809227,
      ii_field_25809227;

      public static iiiIiiIii_Class476.Nested1_6a615060[] I_method_c142b328() {
         return values();
      }

      public static iiiIiiIii_Class476.Nested1_6a615060 I_method_6a64e775(String var0) {
         return Enum.valueOf(iiiIiiIii_Class476.Nested1_6a615060.class, var0);
      }
   }
}
