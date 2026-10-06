package rockstar.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import lombok.Generated;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class iIiIIIIII_Class321 {
   private static final double I_field_44 = Math.PI * 2;
   private static final Random I_field_6ece06ac = new Random();
   private final List<iIiIIIIII_Class321.Nested1_aa73e3e9> I_field_7865b31 = new ArrayList<>();
   private int I_field_49 = 0;
   private long I_field_4a = 0L;
   private float I_field_46 = 0.12F;
   private iIiIIIIII_Class321.Nested1_dc1aca0 I_field_ee2bbde7;
   private iIiIIIIII_Class321.Nested1_aa73e3c9 I_field_d74b88c6;
   private iIiIIIIII_Class321.Nested1_dc1ac80 I_field_ee2bba07;
   private final Vec3d[] I_field_c4e0c195;
   private int i_field_49;
   private int II_field_49;
   private int Ii_field_49;
   private float i_field_46;
   private boolean I_field_5a;
   private int iI_field_49;
   private float II_field_46;
   private float Ii_field_46;

   public iIiIIIIII_Class321() {
      this.I_field_ee2bbde7 = iIiIIIIII_Class321.Nested1_dc1aca0.I_field_ee2bbde7;
      this.I_field_d74b88c6 = iIiIIIIII_Class321.Nested1_aa73e3c9.I_field_d74b88c6;
      this.I_field_ee2bba07 = iIiIIIIII_Class321.Nested1_dc1ac80.i_field_ee2bba07;
      this.I_field_c4e0c195 = new Vec3d[15];
      this.i_field_49 = 0;
      this.II_field_49 = 0;
      this.Ii_field_49 = 8;
      this.i_field_46 = 0.6F;
      this.I_field_5a = true;
      this.iI_field_49 = 8;
      this.II_field_46 = 0.6F;
      this.Ii_field_46 = 0.12F;
   }

   public void I_method_7321c2f8(int var1, float var2, boolean var3) {
      this.Ii_field_49 = var1;
      this.i_field_46 = var2;
      this.I_field_5a = var3;
   }

   public void I_method_d53b1da1(float var1) {
      this.I_field_46 = MathHelper.clamp(var1, 0.05F, 0.5F);
   }

   public void I_method_fd036888(Vec3d var1, LivingEntity var2, Vec3d var3, float var4) {
      if (var2 != null && var1 != null) {
         this.I_field_ee2bbde7 = this.I_method_959b781d(var2, var3);
         this.I_method_d79163ab(var2.getPos());
         this.I_field_d74b88c6 = this.i_method_3e426bdd();
         this.I_field_ee2bba07 = this.I_method_143148d2(var4);
         this.i_method_dda515df();
         this.I_field_7865b31.clear();
         this.I_field_49 = 0;
         this.I_field_4a = System.currentTimeMillis();
         this.I_method_514984ee(var1, var2, var4);
         this.I_field_7865b31.sort((var0, var1x) -> Float.compare(var1x.I_field_46, var0.I_field_46));
      } else {
         this.I_field_7865b31.clear();
         this.iI_field_49 = 0;
      }
   }

   private iIiIIIIII_Class321.Nested1_dc1aca0 I_method_959b781d(LivingEntity var1, Vec3d var2) {
      if (var1 == null || var1.getWorld() == null) {
         return iIiIIIIII_Class321.Nested1_dc1aca0.I_field_ee2bbde7;
      } else if (var1.isTouchingWater() || var1.isInsideWaterOrBubbleColumn()) {
         return iIiIIIIII_Class321.Nested1_dc1aca0.II_field_ee2bbde7;
      } else if (var1.isInLava() || var1.isInLava()) {
         return iIiIIIIII_Class321.Nested1_dc1aca0.Ii_field_ee2bbde7;
      } else if (var1.isOnGround()) {
         return iIiIIIIII_Class321.Nested1_dc1aca0.I_field_ee2bbde7;
      } else {
         return var1 instanceof PlayerEntity var3 && var3.isClimbing()
            ? iIiIIIIII_Class321.Nested1_dc1aca0.iI_field_ee2bbde7
            : iIiIIIIII_Class321.Nested1_dc1aca0.i_field_ee2bbde7;
      }
   }

   private void I_method_d79163ab(Vec3d var1) {
      this.I_field_c4e0c195[this.i_field_49] = var1;
      this.i_field_49 = (this.i_field_49 + 1) % this.I_field_c4e0c195.length;
      if (this.II_field_49 < this.I_field_c4e0c195.length) {
         this.II_field_49++;
      }
   }

   private iIiIIIIII_Class321.Nested1_aa73e3c9 i_method_3e426bdd() {
      if (this.II_field_49 < 5) {
         return iIiIIIIII_Class321.Nested1_aa73e3c9.I_field_d74b88c6;
      } else {
         ArrayList var1 = new ArrayList();
         ArrayList var2 = new ArrayList();

         for (int var3 = 1; var3 < Math.min(10, this.II_field_49); var3++) {
            int var4 = (this.i_field_49 - var3 + this.I_field_c4e0c195.length) % this.I_field_c4e0c195.length;
            int var5 = (this.i_field_49 - var3 - 1 + this.I_field_c4e0c195.length) % this.I_field_c4e0c195.length;
            if (this.I_field_c4e0c195[var4] != null && this.I_field_c4e0c195[var5] != null) {
               double var6 = this.I_field_c4e0c195[var4].distanceTo(this.I_field_c4e0c195[var5]);
               var1.add(var6);
               if (var3 >= 2) {
                  int var8 = (this.i_field_49 - var3 - 2 + this.I_field_c4e0c195.length) % this.I_field_c4e0c195.length;
                  if (this.I_field_c4e0c195[var8] != null) {
                     Vec3d var9 = this.I_field_c4e0c195[var5].subtract(this.I_field_c4e0c195[var8]);
                     Vec3d var10 = this.I_field_c4e0c195[var4].subtract(this.I_field_c4e0c195[var5]);
                     double var11 = Math.atan2(var10.z, var10.x) - Math.atan2(var9.z, var9.x);
                     var11 = I_method_d53b160d(var11);
                     var2.add(Math.abs(var11));
                  }
               }
            }
         }

         if (var1.isEmpty()) {
            return iIiIIIIII_Class321.Nested1_aa73e3c9.I_field_d74b88c6;
         } else {
            double var13 = var1.stream().mapToDouble(value -> ((Double)value).doubleValue()).average().orElse(0.0);
            if (var13 < 0.01) {
               return iIiIIIIII_Class321.Nested1_aa73e3c9.I_field_d74b88c6;
            } else {
               if (var2.size() >= 3) {
                  double var14 = var2.stream().mapToDouble(value -> ((Double)value).doubleValue()).average().orElse(0.0);
                  double var7 = var2.stream().mapToDouble(var2x -> Math.pow((Double)var2x - var14, 2.0)).average().orElse(1.0);
                  if (var7 < 0.15 && var14 > 0.05 && var14 < 0.5) {
                     return iIiIIIIII_Class321.Nested1_aa73e3c9.II_field_d74b88c6;
                  }
               }

               if (var2.size() >= 3) {
                  double var15 = var2.stream().mapToDouble(value -> ((Double)value).doubleValue()).average().orElse(0.0);
                  if (var15 < 0.1) {
                     return iIiIIIIII_Class321.Nested1_aa73e3c9.i_field_d74b88c6;
                  }
               }

               double var16 = var1.stream().mapToDouble(var2x -> Math.pow((Double)var2x - var13, 2.0)).average().orElse(1.0);
               return var16 < 0.05 ? iIiIIIIII_Class321.Nested1_aa73e3c9.iI_field_d74b88c6 : iIiIIIIII_Class321.Nested1_aa73e3c9.Ii_field_d74b88c6;
            }
         }
      }
   }

   private iIiIIIIII_Class321.Nested1_dc1ac80 I_method_143148d2(float var1) {
      if (var1 < 3.0F) {
         return iIiIIIIII_Class321.Nested1_dc1ac80.I_field_ee2bba07;
      } else {
         return var1 < 6.0F ? iIiIIIIII_Class321.Nested1_dc1ac80.i_field_ee2bba07 : iIiIIIIII_Class321.Nested1_dc1ac80.II_field_ee2bba07;
      }
   }

   private void i_method_dda515df() {
      if (!this.I_field_5a) {
         this.iI_field_49 = this.Ii_field_49;
         this.II_field_46 = this.i_field_46;
         this.Ii_field_46 = this.I_field_46;
      } else {
         int var1 = this.Ii_field_49;
         float var2 = this.i_field_46;
         float var3 = this.I_field_46;
         switch (this.I_field_ee2bbde7) {
            case i_field_ee2bbde7:
               var1 = (int)(var1 * 1.2);
               var2 *= 1.1F;
               var3 *= 0.9F;
               break;
            case II_field_ee2bbde7:
               var1 = (int)(var1 * 0.7);
               var2 *= 0.6F;
               var3 *= 1.3F;
               break;
            case Ii_field_ee2bbde7:
               var1 = (int)(var1 * 0.6);
               var2 *= 0.5F;
               var3 *= 1.5F;
               break;
            case iI_field_ee2bbde7:
               var1 = (int)(var1 * 0.8);
               var2 *= 0.7F;
               var3 *= 1.2F;
         }

         switch (this.I_field_d74b88c6) {
            case i_field_d74b88c6:
               var1 = (int)(var1 * 1.1);
               var2 *= 0.9F;
               var3 *= 0.9F;
               break;
            case II_field_d74b88c6:
               var1 = (int)(var1 * 1.4);
               var2 *= 1.2F;
               var3 *= 0.8F;
               break;
            case Ii_field_d74b88c6:
               var1 = (int)(var1 * 1.3);
               var2 *= 1.3F;
               var3 *= 0.7F;
               break;
            case iI_field_d74b88c6:
               var1 = (int)(var1 * 0.8);
               var2 *= 0.8F;
               var3 *= 1.1F;
         }

         switch (this.I_field_ee2bba07) {
            case I_field_ee2bba07:
               var1 = (int)(var1 * 1.3);
               var2 *= 0.7F;
               var3 *= 0.8F;
            case i_field_ee2bba07:
            default:
               break;
            case II_field_ee2bba07:
               var1 = (int)(var1 * 0.7);
               var2 *= 1.4F;
               var3 *= 1.2F;
         }

         this.iI_field_49 = MathHelper.clamp(var1, 3, 50);
         this.II_field_46 = MathHelper.clamp(var2, 0.2F, 2.0F);
         this.Ii_field_46 = MathHelper.clamp(var3, 0.05F, 0.5F);
      }
   }

   private void I_method_514984ee(Vec3d var1, LivingEntity var2, float var3) {
      double var4 = var2.getWidth() / 2.0;
      double var6 = var2.getHeight();
      float var8;
      float var9;
      float var10;
      float var11;
      float var12;
      float var13;
      switch (this.I_field_ee2bbde7) {
         case i_field_ee2bbde7:
            var8 = 0.6F;
            var9 = 0.8F;
            var10 = 0.4F;
            var11 = 0.3F;
            var12 = 0.5F;
            var13 = 0.2F;
            break;
         case II_field_ee2bbde7:
            var8 = 0.9F;
            var9 = 0.5F;
            var10 = 0.2F;
            var11 = 0.5F;
            var12 = 0.35F;
            var13 = 0.15F;
            break;
         case Ii_field_ee2bbde7:
         default:
            var8 = 0.95F;
            var9 = 0.7F;
            var10 = 0.35F;
            var11 = 0.4F;
            var12 = 0.4F;
            var13 = 0.2F;
            break;
         case iI_field_ee2bbde7:
            var8 = 0.85F;
            var9 = 0.6F;
            var10 = 0.3F;
            var11 = 0.45F;
            var12 = 0.4F;
            var13 = 0.15F;
      }

      switch (this.I_field_d74b88c6) {
         case i_field_d74b88c6:
            this.i_method_5582cece(var1, var4, var6, this.II_field_46, this.iI_field_49, var8, var9, var10, var11, var12, var13);
            break;
         case II_field_d74b88c6:
            this.I_method_16a7eae(var1, var4, var6, this.II_field_46, this.iI_field_49, var8, var9, var10, var11, var12, var13);
            break;
         case Ii_field_d74b88c6:
            this.II_method_d4d7a2cb(var1, var4, var6, this.II_field_46, this.iI_field_49, var8, var9, var10, var11, var12, var13);
            break;
         default:
            this.Ii_method_28eff2eb(var1, var4, var6, this.II_field_46, this.iI_field_49, var8, var9, var10, var11, var12, var13);
      }
   }

   private void I_method_16a7eae(
      Vec3d var1, double var2, double var4, float var6, int var7, float var8, float var9, float var10, float var11, float var12, float var13
   ) {
      Vec3d var14 = this.I_method_2fa70939();
      int var15 = (int)(var7 * var11);
      int var16 = (int)(var7 * var12);
      int var17 = var7 - var15 - var16;

      for (int var18 = 0; var18 < var15; var18++) {
         float var19;
         if (var14 != null && var18 < var15 * 0.7) {
            float var20 = (float)Math.atan2(var14.z, var14.x);
            var19 = var20 + (float)((I_field_6ece06ac.nextDouble() - 0.5) * 0.6);
         } else {
            var19 = (float)(I_field_6ece06ac.nextDouble() * (Math.PI * 2));
         }

         float var25 = (float)(var2 * var6 * (0.3 + I_field_6ece06ac.nextDouble() * 0.4));
         this.I_field_7865b31
            .add(
               new iIiIIIIII_Class321.Nested1_aa73e3e9(
                  var1.x + Math.cos(var19) * var25,
                  var1.y + var4 * (0.75 + I_field_6ece06ac.nextDouble() * 0.2),
                  var1.z + Math.sin(var19) * var25,
                  var8,
                  0.85F,
                  this.I_field_ee2bbde7
               )
            );
      }

      for (int var21 = 0; var21 < var16; var21++) {
         float var23;
         if (var14 != null && var21 < var16 * 0.6) {
            float var26 = (float)Math.atan2(var14.z, var14.x);
            var23 = var26 + (float)((I_field_6ece06ac.nextDouble() - 0.5) * 0.8);
         } else {
            var23 = (float)(I_field_6ece06ac.nextDouble() * (Math.PI * 2));
         }

         float var27 = (float)(var2 * var6 * (0.4 + I_field_6ece06ac.nextDouble() * 0.4));
         this.I_field_7865b31
            .add(
               new iIiIIIIII_Class321.Nested1_aa73e3e9(
                  var1.x + Math.cos(var23) * var27,
                  var1.y + var4 * (0.45 + I_field_6ece06ac.nextDouble() * 0.25),
                  var1.z + Math.sin(var23) * var27,
                  var9,
                  0.7F,
                  this.I_field_ee2bbde7
               )
            );
      }

      for (int var22 = 0; var22 < var17; var22++) {
         float var24 = (float)(I_field_6ece06ac.nextDouble() * (Math.PI * 2));
         float var28 = (float)(var2 * var6 * I_field_6ece06ac.nextDouble());
         this.I_field_7865b31
            .add(
               new iIiIIIIII_Class321.Nested1_aa73e3e9(
                  var1.x + Math.cos(var24) * var28,
                  var1.y + var4 * (0.15 + I_field_6ece06ac.nextDouble() * 0.25),
                  var1.z + Math.sin(var24) * var28,
                  var10,
                  0.4F,
                  this.I_field_ee2bbde7
               )
            );
      }
   }

   private void i_method_5582cece(
      Vec3d var1, double var2, double var4, float var6, int var7, float var8, float var9, float var10, float var11, float var12, float var13
   ) {
      Vec3d var14 = this.I_method_2fa70939();
      if (var14 == null) {
         var14 = new Vec3d(1.0, 0.0, 0.0);
      }

      var14 = var14.normalize();
      int var15 = (int)(var7 * var11);
      int var16 = (int)(var7 * var12);

      for (int var17 = 0; var17 < var7; var17++) {
         float var18 = (float)var17 / var7;
         float var19;
         float var20;
         float var21;
         if (var17 < var15) {
            var19 = 0.75F + (float)(I_field_6ece06ac.nextDouble() * 0.2);
            var20 = var8;
            var21 = 0.85F;
         } else if (var17 < var15 + var16) {
            var19 = 0.45F + (float)(I_field_6ece06ac.nextDouble() * 0.25);
            var20 = var9;
            var21 = 0.7F;
         } else {
            var19 = 0.15F + (float)(I_field_6ece06ac.nextDouble() * 0.25);
            var20 = var10;
            var21 = 0.4F;
         }

         float var22 = (float)((var18 - 0.5F) * var2 * var6 * 0.5);
         float var23 = (float)((I_field_6ece06ac.nextDouble() - 0.5) * var2 * var6 * 0.6);
         double var24 = var1.x + var14.x * var22 - var14.z * var23;
         double var26 = var1.z + var14.z * var22 + var14.x * var23;
         this.I_field_7865b31.add(new iIiIIIIII_Class321.Nested1_aa73e3e9(var24, var1.y + var4 * var19, var26, var20, var21, this.I_field_ee2bbde7));
      }
   }

   private void II_method_d4d7a2cb(
      Vec3d var1, double var2, double var4, float var6, int var7, float var8, float var9, float var10, float var11, float var12, float var13
   ) {
      int var14 = (int)(var7 * var11);
      int var15 = (int)(var7 * var12);
      int var16 = var7 - var14 - var15;

      for (int var17 = 0; var17 < var14; var17++) {
         float var18 = (float)(I_field_6ece06ac.nextDouble() * (Math.PI * 2));
         float var19 = (float)(var2 * var6 * (0.2 + I_field_6ece06ac.nextDouble() * 0.5));
         this.I_field_7865b31
            .add(
               new iIiIIIIII_Class321.Nested1_aa73e3e9(
                  var1.x + Math.cos(var18) * var19,
                  var1.y + var4 * (0.7 + I_field_6ece06ac.nextDouble() * 0.25),
                  var1.z + Math.sin(var18) * var19,
                  var8,
                  0.8F,
                  this.I_field_ee2bbde7
               )
            );
      }

      for (int var20 = 0; var20 < var15; var20++) {
         float var22 = (float)(I_field_6ece06ac.nextDouble() * (Math.PI * 2));
         float var24 = (float)(var2 * var6 * (0.3 + I_field_6ece06ac.nextDouble() * 0.5));
         this.I_field_7865b31
            .add(
               new iIiIIIIII_Class321.Nested1_aa73e3e9(
                  var1.x + Math.cos(var22) * var24,
                  var1.y + var4 * (0.4 + I_field_6ece06ac.nextDouble() * 0.3),
                  var1.z + Math.sin(var22) * var24,
                  var9,
                  0.65F,
                  this.I_field_ee2bbde7
               )
            );
      }

      for (int var21 = 0; var21 < var16; var21++) {
         float var23 = (float)(I_field_6ece06ac.nextDouble() * (Math.PI * 2));
         float var25 = (float)(var2 * var6 * I_field_6ece06ac.nextDouble());
         this.I_field_7865b31
            .add(
               new iIiIIIIII_Class321.Nested1_aa73e3e9(
                  var1.x + Math.cos(var23) * var25,
                  var1.y + var4 * (0.1 + I_field_6ece06ac.nextDouble() * 0.3),
                  var1.z + Math.sin(var23) * var25,
                  var10,
                  0.35F,
                  this.I_field_ee2bbde7
               )
            );
      }
   }

   private void Ii_method_28eff2eb(
      Vec3d var1, double var2, double var4, float var6, int var7, float var8, float var9, float var10, float var11, float var12, float var13
   ) {
      int var14 = (int)(var7 * var11);
      int var15 = (int)(var7 * var12);
      int var16 = var7 - var14 - var15;

      for (int var17 = 0; var17 < var14; var17++) {
         float var18 = (float)(I_field_6ece06ac.nextDouble() * (Math.PI * 2));
         float var19 = (float)(var2 * var6 * (0.15 + I_field_6ece06ac.nextDouble() * 0.35));
         this.I_field_7865b31
            .add(
               new iIiIIIIII_Class321.Nested1_aa73e3e9(
                  var1.x + Math.cos(var18) * var19,
                  var1.y + var4 * (0.78 + I_field_6ece06ac.nextDouble() * 0.18),
                  var1.z + Math.sin(var18) * var19,
                  var8,
                  0.9F,
                  this.I_field_ee2bbde7
               )
            );
      }

      for (int var20 = 0; var20 < var15; var20++) {
         float var22 = (float)(I_field_6ece06ac.nextDouble() * (Math.PI * 2));
         float var24 = (float)(var2 * var6 * (0.3 + I_field_6ece06ac.nextDouble() * 0.5));
         this.I_field_7865b31
            .add(
               new iIiIIIIII_Class321.Nested1_aa73e3e9(
                  var1.x + Math.cos(var22) * var24,
                  var1.y + var4 * (0.42 + I_field_6ece06ac.nextDouble() * 0.28),
                  var1.z + Math.sin(var22) * var24,
                  var9,
                  0.7F,
                  this.I_field_ee2bbde7
               )
            );
      }

      for (int var21 = 0; var21 < var16; var21++) {
         float var23 = (float)(I_field_6ece06ac.nextDouble() * (Math.PI * 2));
         float var25 = (float)(var2 * var6 * (0.2 + I_field_6ece06ac.nextDouble() * 0.6));
         this.I_field_7865b31
            .add(
               new iIiIIIIII_Class321.Nested1_aa73e3e9(
                  var1.x + Math.cos(var23) * var25,
                  var1.y + var4 * (0.12 + I_field_6ece06ac.nextDouble() * 0.28),
                  var1.z + Math.sin(var23) * var25,
                  var10,
                  0.35F,
                  this.I_field_ee2bbde7
               )
            );
      }
   }

   private Vec3d I_method_2fa70939() {
      if (this.II_field_49 < 2) {
         return null;
      } else {
         Vec3d var1 = this.I_field_c4e0c195[(this.i_field_49 + 1) % this.II_field_49];
         Vec3d var2 = this.I_field_c4e0c195[(this.i_field_49 + this.II_field_49 - 1) % this.II_field_49];
         if (var1 != null && var2 != null) {
            Vec3d var3 = var2.subtract(var1);
            if (var3.lengthSquared() > 0.001) {
               return var3.normalize();
            }
         }

         return null;
      }
   }

   public iIiIIIIII_Class321.Nested1_aa73e3e9 I_method_834aef9d() {
      if (this.I_field_7865b31.isEmpty()) {
         return null;
      } else {
         long var1 = System.currentTimeMillis();
         if ((float)(var1 - this.I_field_4a) < this.Ii_field_46 * 1000.0F) {
            return this.I_field_49 < this.I_field_7865b31.size() ? this.I_field_7865b31.get(this.I_field_49) : this.I_field_7865b31.get(0);
         } else {
            this.I_field_4a = var1;
            if (this.I_field_7865b31.size() > 1) {
               this.I_field_49 = this.i_method_dda515d2();
            } else {
               this.I_field_49 = 0;
            }

            iIiIIIIII_Class321.Nested1_aa73e3e9 var3 = this.I_field_7865b31.get(this.I_field_49);
            var3.I_field_49++;
            var3.I_field_4a = var1;
            return var3;
         }
      }
   }

   private int i_method_dda515d2() {
      float var1 = 0.0F;

      for (iIiIIIIII_Class321.Nested1_aa73e3e9 var3 : this.I_field_7865b31) {
         var1 += var3.I_field_46 * var3.i_field_46;
      }

      if (var1 <= 0.0F) {
         return I_field_6ece06ac.nextInt(this.I_field_7865b31.size());
      } else {
         float var6 = I_field_6ece06ac.nextFloat() * var1;
         float var7 = 0.0F;

         for (int var4 = 0; var4 < this.I_field_7865b31.size(); var4++) {
            iIiIIIIII_Class321.Nested1_aa73e3e9 var5 = this.I_field_7865b31.get(var4);
            var7 += var5.I_field_46 * var5.i_field_46;
            if (var6 <= var7) {
               return var4;
            }
         }

         return this.I_field_7865b31.size() - 1;
      }
   }

   public double[] I_method_d53ab6c0() {
      iIiIIIIII_Class321.Nested1_aa73e3e9 var1 = this.I_method_834aef9d();
      return var1 == null ? null : new double[]{var1.I_field_44, var1.i_field_44, var1.II_field_44};
   }

   public List<iIiIIIIII_Class321.Nested1_aa73e3e9> I_method_84382a68() {
      return new ArrayList<>(this.I_field_7865b31);
   }

   private static double I_method_d53b160d(double var0) {
      var0 %= Math.PI * 2;
      if (var0 < -Math.PI) {
         var0 += Math.PI * 2;
      }

      if (var0 > Math.PI) {
         var0 -= Math.PI * 2;
      }

      return var0;
   }

   public void I_method_dd9689ff() {
      this.I_field_7865b31.clear();
      this.I_field_49 = 0;
      this.I_field_4a = 0L;
      this.i_field_49 = 0;
      this.II_field_49 = 0;
      Arrays.fill(this.I_field_c4e0c195, null);
      this.I_field_ee2bbde7 = iIiIIIIII_Class321.Nested1_dc1aca0.I_field_ee2bbde7;
      this.I_field_d74b88c6 = iIiIIIIII_Class321.Nested1_aa73e3c9.I_field_d74b88c6;
      this.I_field_ee2bba07 = iIiIIIIII_Class321.Nested1_dc1ac80.i_field_ee2bba07;
      this.iI_field_49 = this.Ii_field_49;
      this.II_field_46 = this.i_field_46;
      this.Ii_field_46 = this.I_field_46;
   }

   @Generated
   public iIiIIIIII_Class321.Nested1_aa73e3c9 I_method_834aebbd() {
      return this.I_field_d74b88c6;
   }

   @Generated
   public iIiIIIIII_Class321.Nested1_dc1ac80 I_method_35c89c30() {
      return this.I_field_ee2bba07;
   }

   @Generated
   public int I_method_dd9689f2() {
      return this.iI_field_49;
   }

   @Generated
   public float I_method_dd9689ef() {
      return this.II_field_46;
   }

   public static enum Nested1_aa73e3c9 {
      I_field_d74b88c6,
      i_field_d74b88c6,
      II_field_d74b88c6,
      Ii_field_d74b88c6,
      iI_field_d74b88c6;
   }

   public static class Nested1_aa73e3e9 {
      public final double I_field_44;
      public final double i_field_44;
      public final double II_field_44;
      public final float I_field_46;
      public final float i_field_46;
      public final iIiIIIIII_Class321.Nested1_dc1aca0 I_field_ee2bbde7;
      public int I_field_49 = 0;
      public long I_field_4a = 0L;

      public Nested1_aa73e3e9(double var1, double var3, double var5, float var7, float var8, iIiIIIIII_Class321.Nested1_dc1aca0 var9) {
         this.I_field_44 = var1;
         this.i_field_44 = var3;
         this.II_field_44 = var5;
         this.I_field_46 = var7;
         this.i_field_46 = var8;
         this.I_field_ee2bbde7 = var9;
      }

      public Vec3d I_method_35e952b() {
         return new Vec3d(this.I_field_44, this.i_field_44, this.II_field_44);
      }
   }

   public static enum Nested1_dc1ac80 {
      I_field_ee2bba07,
      i_field_ee2bba07,
      II_field_ee2bba07,
      Ii_field_ee2bba07,
      iI_field_ee2bba07;
   }

   public static enum Nested1_dc1aca0 {
      I_field_ee2bbde7,
      i_field_ee2bbde7,
      II_field_ee2bbde7,
      Ii_field_ee2bbde7,
      iI_field_ee2bbde7;
   }
}
