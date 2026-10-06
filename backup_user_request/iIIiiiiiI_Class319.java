package rockstar.client;

import java.lang.reflect.Field;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import lombok.Generated;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.client.gui.hud.BossBarHud;
import net.minecraft.client.gui.hud.ClientBossBar;
import net.minecraft.entity.Entity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import ua.mintantileak.spk.Compile;

public final class iIIiiiiiI_Class319 implements iIIiIIiIi_Class294 {
   public static SecureRandom I_field_ec5bca73 = new SecureRandom();
   private static final int I_field_49 = 65536;
   private static final double I_field_44 = Math.PI * 2;
   private static final double[] I_field_b49 = new double[65536];
   private static final DecimalFormatSymbols I_field_61e75347;
   private static final DecimalFormat I_field_a8ff44b4;

   @Compile(
      obfuscation = 1
   )
   public static double I_method_a586e9cd(double var0) {
      int var2 = (int)(var0 * 10430.378350470453) & 65535;
      return I_field_b49[var2];
   }

   @Compile(
      obfuscation = 1
   )
   public static double i_method_a749d9ed(double var0) {
      int var2 = (int)(var0 * 10430.378350470453 + 16384.0) & 65535;
      return I_field_b49[var2];
   }

   @Compile(
      obfuscation = 1
   )
   public static float I_method_b57a26f(float var0, float var1) {
      float var2 = I_field_ec5bca73.nextFloat();
      float var3 = I_field_ec5bca73.nextFloat();
      return var0 + (var1 - var0) * ((var2 + var3) / 2.0F);
   }

   @Compile(
      obfuscation = 1
   )
   public static float i_method_41f2b64f(float var0, float var1) {
      double var2 = I_field_ec5bca73.nextDouble();
      double var4 = I_field_ec5bca73.nextDouble();
      double var6 = I_field_ec5bca73.nextGaussian() * 0.02F;
      double var8 = Math.pow(var2, 1.0 + I_field_ec5bca73.nextDouble() * 0.7);
      double var10 = (var4 * 0.8 + 0.1) * (Math.log1p(var2 * 3.0) * 0.5 + 0.5);
      return (float)(var0 + (var1 - var0) * var8 * var10 + var6);
   }

   @Compile(
      obfuscation = 1
   )
   public static float II_method_96464072(float var0, float var1) {
      return var0 + (var1 - var0) * (float)Math.random();
   }

   @Compile(
      obfuscation = 1
   )
   public static float Ii_method_cce15452(float var0, float var1) {
      return var0 + (var1 - var0) * I_field_ec5bca73.nextFloat();
   }

   @Compile(
      obfuscation = 1
   )
   public static float iI_method_330da892(float var0, float var1) {
      switch (I_field_ec5bca73.nextInt(4)) {
         case 0:
            return I_method_b57a26f(var0, var1);
         case 1:
            return i_method_41f2b64f(var0, var1);
         case 2:
            return II_method_96464072(var0, var1);
         default:
            return Ii_method_cce15452(var0, var1);
      }
   }

   @Compile(
      obfuscation = 1
   )
   public static float ii_method_69a8bc72(float var0, float var1) {
      float var2 = (float)I_field_ec5bca73.nextGaussian() * var1 + var0;
      float var3 = (float)I_field_ec5bca73.nextGaussian() * var1 + var0;
      return (var2 + var3) / 2.0F;
   }

   @Compile(
      obfuscation = 1
   )
   public static float III_method_692b62cf(float var0, float var1) {
      double var2 = I_field_ec5bca73.nextGaussian() * var1 + var0;
      double var4 = I_field_ec5bca73.nextGaussian();
      double var6 = I_field_ec5bca73.nextGaussian() * 0.02;
      double var8 = Math.pow(Math.abs(var4), 1.0 + I_field_ec5bca73.nextDouble() * 0.7);
      double var10 = (Math.abs(var4) * 0.8 + 0.1) * (Math.log1p(Math.abs(var2 - var0) * 3.0) * 0.5 + 0.5);
      return (float)(var0 + var1 * var8 * var10 + var6);
   }

   @Compile(
      obfuscation = 1
   )
   public static float IIi_method_9fc676af(float var0, float var1) {
      return (float)I_field_ec5bca73.nextGaussian() * var1 + var0;
   }

   @Compile(
      obfuscation = 1
   )
   public static float IiI_method_5f2caef(float var0, float var1) {
      return (float)I_field_ec5bca73.nextGaussian() * var1 + var0;
   }

   @Compile(
      obfuscation = 1
   )
   public static float Iii_method_3c8ddecf(float var0, float var1) {
      switch (I_field_ec5bca73.nextInt(4)) {
         case 0:
            return ii_method_69a8bc72(var0, var1);
         case 1:
            return III_method_692b62cf(var0, var1);
         case 2:
            return IIi_method_9fc676af(var0, var1);
         default:
            return IiI_method_5f2caef(var0, var1);
      }
   }

   @Compile(
      obfuscation = 1
   )
   public static float I_method_b56b22f(double var0, double var2) {
      return (float)(var0 + (var2 - var0) * Math.random());
   }

   @Compile(
      obfuscation = 1
   )
   public static double I_method_7f6601cd(double var0, double var2, double var4, double var6, double var8) {
      return Math.pow(1.0 - var0, 3.0) * var2
         + 3.0 * var0 * Math.pow(1.0 - var0, 2.0) * var4
         + 3.0 * Math.pow(var0, 2.0) * (1.0 - var0) * var6
         + Math.pow(var0, 3.0) * var8;
   }

   @Compile(
      obfuscation = 1
   )
   public static boolean I_method_de40276f(Vec3d var0) {
      return I_field_3a9bda27.world
            .raycast(new RaycastContext(I_field_3a9bda27.player.getEyePos(), var0, ShapeType.COLLIDER, FluidHandling.NONE, I_field_3a9bda27.player))
            .getType()
         == Type.MISS;
   }

   @Compile(
      obfuscation = 1
   )
   public static boolean i_method_b9581f8f(Vec3d var0) {
      Vec3d var1 = I_field_3a9bda27.player.getEyePos();
      Vec3d var2 = var0.subtract(var1);
      double var3 = var2.length();
      var2 = var2.normalize();
      HashSet var5 = new HashSet();
      int var6 = 0;
      double var7 = 0.25;

      for (double var9 = 0.0; var9 <= var3; var9 += var7) {
         Vec3d var11 = var1.add(var2.multiply(var9));
         BlockPos var12 = BlockPos.ofFloored(var11);
         if (!var5.contains(var12)) {
            var5.add(var12);
            BlockState var13 = I_field_3a9bda27.world.getBlockState(var12);
            if (!var13.isAir()) {
               Block var14 = var13.getBlock();
               if (!var13.isOf(Blocks.GLASS) && !var13.isOf(Blocks.GLASS_PANE) && !(var13.getBlock() instanceof TrapdoorBlock)) {
                  VoxelShape var15 = var13.getCollisionShape(I_field_3a9bda27.world, var12);
                  if (!var15.isEmpty()) {
                     var6++;
                  }
               }
            }
         }
      }

      AtomicBoolean var20 = new AtomicBoolean(false);
      BossBarHud var10 = I_field_3a9bda27.inGameHud.getBossBarHud();
      if (var10 != null) {
         Class<BossBarHud> var21 = BossBarHud.class;

         try {
            Field var22 = var21.getField("bossBars");
            Map var23 = (Map)var22.get(var10);

            for (UUID var25 : (Iterable<UUID>)(Iterable<?>)var23.keySet()) {
               ClientBossBar var16 = (ClientBossBar)var23.get(var25);
               List var17 = var16.getName().getSiblings();
               var17.stream().allMatch(var1x -> {
                  if (((net.minecraft.text.Text)var1x).getString().contains("\ub8f3\ua223\ua203\ub8f2\ua223\ua205")) {
                     var20.set(true);
                  }

                  return true;
               });
            }
         } catch (Exception var18) {
         }
      }

      return var6 <= (var20.get() ? 3 : (I_field_3a9bda27.player.getInventory().selectedSlot == 0 ? 2 : 1));
   }

   @Compile(
      obfuscation = 1
   )
   public static int I_method_fe0a7fc6(String var0, String var1) {
      int var2 = var0.length();
      int var3 = var1.length();
      int[] var4 = new int[var3 + 1];
      int var5 = 0;

      while (var5 <= var3) {
         var4[var5] = var5++;
      }

      for (int var10 = 1; var10 <= var2; var10++) {
         int var6 = var4[0];
         var4[0] = var10;

         for (int var7 = 1; var7 <= var3; var7++) {
            int var8 = var4[var7];
            int var9 = var0.charAt(var10 - 1) == var1.charAt(var7 - 1) ? 0 : 1;
            var4[var7] = Math.min(Math.min(var4[var7] + 1, var4[var7 - 1] + 1), var6 + var9);
            var6 = var8;
         }
      }

      return var4[var3];
   }

   @Compile(
      obfuscation = 1
   )
   public static float I_method_5f7ff5cf(double var0, double var2, double var4) {
      return (float)(var0 + (var2 - var0) * var4);
   }

   @Compile(
      obfuscation = 1
   )
   public static HitResult I_method_3191983(double var0, float var2, float var3, Entity var4) {
      Vec3d var5 = I_field_3a9bda27.player.getCameraPosVec(1.0F);
      Vec3d var6 = I_method_dcd241b9(var3, var2);
      Vec3d var7 = var5.add(var6.x * var0, var6.y * var0, var6.z * var0);
      return I_field_3a9bda27.world.raycast(new RaycastContext(var5, var7, ShapeType.OUTLINE, FluidHandling.NONE, var4));
   }

   @Compile(
      obfuscation = 1
   )
   private static boolean I_method_442f21c3(Vec3d var0, Vec3d var1, Entity var2, Entity var3) {
      Box var4 = var2.getBoundingBox().offset(-var2.getX(), -var2.getY(), -var2.getZ()).offset(IiiiiiIii_Class252.I_method_34ed4d41(var2));
      Box var5 = var2.getBoundingBox();
      return var4.raycast(var0, var1).isPresent()
            && RockstarClient.getInstance().getModuleManager().getModule(AuraModule.class).I_method_d798ad5d().isSelected()
         ? true
         : var5.raycast(var0, var1).isPresent();
   }

   @Compile(
      obfuscation = 1
   )
   public static BlockHitResult I_method_719d7aa1(Vec3d var0, Vec3d var1, Entity var2, iiiIIiII_Class229 var3) {
      if (I_field_3a9bda27.world != null && !var3.I_method_94f6b4d0()) {
         Vec3d var4 = var1.subtract(var0);
         double var5 = var4.lengthSquared();
         if (var5 < 1.0E-8) {
            return null;
         } else {
            BlockHitResult var7 = I_method_5241db75(var0, var2, var3);
            if (var7 != null) {
               return var7;
            } else {
               Vec3d var8 = var4.normalize().multiply(0.01);
               Vec3d var9 = var0;

               for (int var10 = 0; var10 < 40; var10++) {
                  BlockHitResult var11 = I_field_3a9bda27.world.raycast(new RaycastContext(var9, var1, var3.I_method_ff544d6b(), FluidHandling.NONE, var2));
                  if (var11 == null || var11.getType() != Type.BLOCK) {
                     return null;
                  }

                  BlockHitResult var12 = var11;
                  BlockPos var13 = var12.getBlockPos();
                  if (!var3.I_method_3b59c27(I_field_3a9bda27.world, var13, I_field_3a9bda27.world.getBlockState(var13))) {
                     return var12;
                  }

                  var9 = var12.getPos().add(var8);
                  if (var9.squaredDistanceTo(var0) >= var5) {
                     return null;
                  }
               }

               return null;
            }
         }
      } else {
         return null;
      }
   }

   private static BlockHitResult I_method_5241db75(Vec3d var0, Entity var1, iiiIIiII_Class229 var2) {
      if (var2.I_method_ff544d6b() != ShapeType.OUTLINE) {
         return null;
      } else {
         BlockPos var3 = BlockPos.ofFloored(var0);
         BlockState var4 = I_field_3a9bda27.world.getBlockState(var3);
         if (!var4.isAir() && !var2.I_method_3b59c27(I_field_3a9bda27.world, var3, var4)) {
            VoxelShape var5 = var4.getOutlineShape(I_field_3a9bda27.world, var3, ShapeContext.of(var1));
            return var5.isEmpty() ? null : new BlockHitResult(var0, Direction.UP, var3, true);
         } else {
            return null;
         }
      }
   }

   @Compile(
      obfuscation = 1
   )
   public static boolean I_method_85774c6c(Vec3d var0, Vec3d var1, Entity var2, iiiIIiII_Class229 var3) {
      return I_method_719d7aa1(var0, var1, var2, var3) == null;
   }

   @Compile(
      obfuscation = 1
   )
   public static boolean I_method_9b00cfe4(double var0, float var2, float var3, Entity var4, Entity var5, iiiIIiII_Class229 var6) {
      if (var5 != null && var4 != null && I_field_3a9bda27.world != null) {
         float var7 = I_field_3a9bda27.getRenderTickCounter().getTickDelta(false);
         Vec3d var8 = var4.getCameraPosVec(var7);
         Vec3d var9 = I_method_dcd241b9(var3, var2);
         Vec3d var10 = var8.add(var9.multiply(var0));
         if (!var6.I_method_94f6b4d0()) {
            Box var11 = var5.getBoundingBox().offset(-var5.getX(), -var5.getY(), -var5.getZ()).offset(IiiiiiIii_Class252.I_method_34ed4d41(var5));
            Box var12 = var5.getBoundingBox();
            if (var12.contains(I_field_3a9bda27.player.getEyePos())) {
               return true;
            }

            if (var11.contains(I_field_3a9bda27.player.getEyePos())
               && RockstarClient.getInstance().getModuleManager().getModule(AuraModule.class).I_method_d798ad5d().isSelected()) {
               return true;
            }

            BlockHitResult var13 = I_method_719d7aa1(var8, var10, var4, var6);
            if (var13 != null) {
               double var14 = var13.getPos().distanceTo(var8);
               double var16 = var5.getEyePos().distanceTo(var8);
               if (var14 < var16) {
                  return false;
               }
            }
         } else {
            BlockHitResult var18 = I_field_3a9bda27.world.raycast(new RaycastContext(var8, var10, ShapeType.COLLIDER, FluidHandling.NONE, var4));
            if (var18 != null && var18.getType() == Type.BLOCK) {
               double var19 = var18.getPos().distanceTo(var8);
               double var20 = var5.getEyePos().distanceTo(var8);
               if (var19 < var20) {
               }
            }
         }

         return I_method_442f21c3(var8, var10, var5, I_field_3a9bda27.player);
      } else {
         return false;
      }
   }

   @Compile(
      obfuscation = 1
   )
   public static Vec3d I_method_dcd241b9(float var0, float var1) {
      float var2 = -var1 * (float) (Math.PI / 180.0) - (float) Math.PI;
      float var3 = -var0 * (float) (Math.PI / 180.0);
      float var4 = MathHelper.cos(var2);
      float var5 = MathHelper.sin(var2);
      float var6 = -MathHelper.cos(var3);
      float var7 = MathHelper.sin(var3);
      return new Vec3d(var5 * var6, var7, var4 * var6);
   }

   @Compile(
      obfuscation = 1
   )
   public static float iII_method_6550feaf(float var0, float var1) {
      float var2 = (var0 - var1) % 360.0F;
      if (var2 < -180.0F) {
         var2 += 360.0F;
      } else if (var2 > 180.0F) {
         var2 -= 360.0F;
      }

      return var2;
   }

   @Compile(
      obfuscation = 1
   )
   public static String I_method_f25d3977(String var0) {
      var0 = var0.replaceAll("\\s+", "");
      if (var0.isEmpty()) {
         return "";
      } else {
         try {
            double var1 = new iIiIIIiIi_Class326(var0).I_method_c07dce55().I_method_d9bc25cd();
            return String.valueOf(var1);
         } catch (IllegalArgumentException var3) {
            var3.printStackTrace();
            return var0;
         }
      }
   }

   @Compile(
      obfuscation = 1
   )
   public static float I_method_a586f151(float var0) {
      int var1 = (int)Math.floor(var0) & 0xFF;
      float var2 = var0 - (float)Math.floor(var0);
      float var3 = i_method_a749e171(var2);
      float var4 = I_method_a586fc94(var1);
      float var5 = I_method_a586fc94(var1 + 1);
      return I_method_5f9d1511(var4, var5, var3);
   }

   @Compile(
      obfuscation = 1
   )
   public static int I_method_b590ad2(int var0, int var1) {
      if (var0 > var1) {
         throw new IllegalArgumentException("min must be less than or equal to max");
      } else {
         return var0 + I_field_ec5bca73.nextInt(var1 - var0 + 1);
      }
   }

   @Compile(
      obfuscation = 1
   )
   private static float i_method_a749e171(float var0) {
      return var0 * var0 * var0 * (var0 * (var0 * 6.0F - 15.0F) + 10.0F);
   }

   @Compile(
      obfuscation = 1
   )
   public static float I_method_5f9d1511(float var0, float var1, float var2) {
      return var0 + (var1 - var0) * var2;
   }

   @Compile(
      obfuscation = 1
   )
   private static float I_method_a586fc94(int var0) {
      var0 = var0 ^ 61 ^ var0 >> 16;
      var0 += var0 << 3;
      var0 ^= var0 >> 4;
      var0 *= 668265261;
      var0 ^= var0 >> 15;
      return (var0 & 2147483647) / 2.1474836E9F * 2.0F - 1.0F;
   }

   @Compile(
      obfuscation = 1
   )
   public static String I_method_10212adb(long var0) {
      return I_field_a8ff44b4.format(var0) + "$";
   }

   @Generated
   private iIIiiiiiI_Class319() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }

   static {
      for (int var0 = 0; var0 < 65536; var0++) {
         I_field_b49[var0] = Math.sin(var0 * (Math.PI * 2) / 65536.0);
      }

      I_field_61e75347 = new DecimalFormatSymbols(Locale.US);
      I_field_a8ff44b4 = new DecimalFormat("#,###", I_field_61e75347);
   }
}
