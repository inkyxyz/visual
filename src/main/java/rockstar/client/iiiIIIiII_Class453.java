package rockstar.client;

import it.unimi.dsi.fastutil.longs.Long2ByteOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2DoubleOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2LongOpenHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.world.World;

public final class iiiIIIiII_Class453 {
   private static final int I_field_49 = 2;
   private static final int i_field_49 = 40000;
   private static final long I_field_4a = 800L;
   private static final double I_field_44 = 1.2;
   private static final double i_field_44 = 2.5;
   private static final byte I_field_42 = 1;
   private static final byte i_field_42 = 2;
   private static final ExecutorService I_field_331d0885 = Executors.newSingleThreadExecutor(var0x -> {
      Thread var1x = new Thread(var0x, "Newton-AirPlanner");
      var1x.setDaemon(true);
      return var1x;
   });
   private static final int[][] I_field_160e9;

   private iiiIIIiII_Class453() {
   }

   public static CompletableFuture<List<Vec3d>> I_method_4b273f33(World var0, Vec3d var1, Vec3d var2) {
      return CompletableFuture.supplyAsync(() -> I_method_2b00ca06(var0, var1, var2), I_field_331d0885);
   }

   static List<Vec3d> I_method_2b00ca06(World var0, Vec3d var1, Vec3d var2) {
      long var3 = System.nanoTime() + 800000000L;
      Long2ByteOpenHashMap var5 = new Long2ByteOpenHashMap(8192);
      Mutable var6 = new Mutable();
      int var7 = MathHelper.floor(var1.x) >> 1;
      int var8 = MathHelper.floor(var1.y) >> 1;
      int var9 = MathHelper.floor(var1.z) >> 1;
      int var10 = MathHelper.floor(var2.x) >> 1;
      int var11 = MathHelper.floor(var2.y) >> 1;
      int var12 = MathHelper.floor(var2.z) >> 1;
      int var13 = -1;

      for (int var14 = 0; var14 <= 2; var14++) {
         if (I_method_11eccd52(var0, var5, var6, var7, var8 + var14, var9)) {
            var13 = var8 + var14;
            break;
         }
      }

      if (var13 < 0) {
         return List.of();
      } else {
         long var49 = I_method_41f4f438(var7, var13, var9);
         Long2DoubleOpenHashMap var16 = new Long2DoubleOpenHashMap(4096);
         var16.defaultReturnValue(Double.POSITIVE_INFINITY);
         Long2LongOpenHashMap var17 = new Long2LongOpenHashMap(4096);
         var17.defaultReturnValue(Long.MIN_VALUE);
         PriorityQueue<double[]> var18 = new PriorityQueue<>((var0x, var1x) -> Double.compare(var0x[0], var1x[0]));
         var16.put(var49, 0.0);
         var18.add(new double[]{I_method_7a5393cd(var7, var13, var9, var10, var11, var12) * 1.2, 0.0, var7, var13, var9});
         long var19 = var49;
         double var21 = I_method_7a5393cd(var7, var13, var9, var10, var11, var12);
         int var23 = 0;

         while (!var18.isEmpty()) {
            double[] var24 = (double[])var18.poll();
            int var25 = (int)var24[2];
            int var26 = (int)var24[3];
            int var27 = (int)var24[4];
            long var28 = I_method_41f4f438(var25, var26, var27);
            double var30 = var16.get(var28);
            if (!(var24[1] > var30 + 1.0E-9)) {
               if (Math.max(Math.abs(var25 - var10), Math.max(Math.abs(var26 - var11), Math.abs(var27 - var12))) <= 1) {
                  var19 = var28;
                  break;
               }

               var23++;
               if (var23 > 40000 || (var23 & 127) == 0 && System.nanoTime() > var3) {
                  break;
               }

               for (int[] var35 : I_field_160e9) {
                  int var36 = var25 + var35[0];
                  int var37 = var26 + var35[1];
                  int var38 = var27 + var35[2];
                  if (I_method_11eccd52(var0, var5, var6, var36, var37, var38)) {
                     double var39 = Math.sqrt(var35[0] * var35[0] + var35[1] * var35[1] + var35[2] * var35[2]);
                     double var41 = var35[1] > 0 ? var39 * 2.5 : var39;
                     double var43 = var30 + var41;
                     long var45 = I_method_41f4f438(var36, var37, var38);
                     if (var43 < var16.get(var45)) {
                        var16.put(var45, var43);
                        var17.put(var45, var28);
                        double var47 = I_method_7a5393cd(var36, var37, var38, var10, var11, var12);
                        if (var47 < var21 - 1.0E-9) {
                           var21 = var47;
                           var19 = var45;
                        }

                        var18.add(new double[]{var43 + var47 * 1.2, var43, var36, var37, var38});
                     }
                  }
               }
            }
         }

         return var19 == var49 ? List.of() : I_method_564bde38(var17, var49, var19);
      }
   }

   private static List<Vec3d> I_method_564bde38(Long2LongOpenHashMap var0, long var1, long var3) {
      ArrayList var5 = new ArrayList();
      long var6 = var3;
      int var8 = 262144;

      while (var6 != var1) {
         if (--var8 <= 0) {
            break;
         }

         var5.add(I_method_8ba2195f(var6));
         var6 = var0.get(var6);
         if (var6 == Long.MIN_VALUE) {
            return List.of();
         }
      }

      Collections.reverse(var5);
      return I_method_a313af57(var5);
   }

   private static List<Vec3d> I_method_a313af57(List<Vec3d> var0) {
      if (var0.size() <= 2) {
         return var0;
      } else {
         ArrayList var1 = new ArrayList(var0.size() / 2 + 2);
         var1.add((Vec3d)var0.get(0));

         for (int var2 = 1; var2 < var0.size() - 1; var2++) {
            Vec3d var3 = (Vec3d)var1.get(var1.size() - 1);
            Vec3d var4 = (Vec3d)var0.get(var2);
            Vec3d var5 = (Vec3d)var0.get(var2 + 1);
            Vec3d var6 = var4.subtract(var3).normalize();
            Vec3d var7 = var5.subtract(var4).normalize();
            if (var6.dotProduct(var7) < 0.999 || var4.subtract(var3).length() > 14.0) {
               var1.add(var4);
            }
         }

         var1.add((Vec3d)var0.get(var0.size() - 1));
         return var1;
      }
   }

   private static boolean I_method_11eccd52(World var0, Long2ByteOpenHashMap var1, Mutable var2, int var3, int var4, int var5) {
      long var6 = I_method_41f4f438(var3, var4, var5);
      byte var8 = var1.get(var6);
      if (var8 != 0) {
         return var8 == 1;
      } else {
         boolean var9 = I_method_1577de4e(var0, var2, var3, var4, var5);
         var1.put(var6, (byte)(var9 ? 1 : 2));
         return var9;
      }
   }

   private static boolean I_method_1577de4e(World var0, Mutable var1, int var2, int var3, int var4) {
      int var5 = var2 * 2;
      int var6 = var3 * 2;
      int var7 = var4 * 2;
      if (var6 > var0.getBottomY() + 1 && var6 + 2 < var0.getTopYInclusive()) {
         if (var0.isPosLoaded(var5, var7) && var0.isPosLoaded(var5 + 2 - 1, var7 + 2 - 1)) {
            for (int var8 = var5; var8 < var5 + 2; var8++) {
               for (int var9 = var6; var9 < var6 + 2; var9++) {
                  for (int var10 = var7; var10 < var7 + 2; var10++) {
                     var1.set(var8, var9, var10);
                     BlockState var11 = var0.getBlockState(var1);
                     if (!var11.getFluidState().isEmpty()) {
                        return false;
                     }

                     if (var11.isOf(Blocks.FIRE) || var11.isOf(Blocks.SOUL_FIRE) || var11.isOf(Blocks.MAGMA_BLOCK)) {
                        return false;
                     }

                     if (!var11.isAir() && !var11.isReplaceable() && !var11.getCollisionShape(var0, var1).isEmpty()) {
                        return false;
                     }
                  }
               }
            }

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private static long I_method_41f4f438(int var0, int var1, int var2) {
      return BlockPos.asLong(var0, var1, var2);
   }

   private static Vec3d I_method_8ba2195f(long var0) {
      int var2 = BlockPos.unpackLongX(var0);
      int var3 = BlockPos.unpackLongY(var0);
      int var4 = BlockPos.unpackLongZ(var0);
      return new Vec3d(var2 * 2 + 1.0, var3 * 2 + 1.0, var4 * 2 + 1.0);
   }

   private static double I_method_7a5393cd(int var0, int var1, int var2, int var3, int var4, int var5) {
      double var6 = var0 - var3;
      double var8 = var1 - var4;
      double var10 = var2 - var5;
      return Math.sqrt(var6 * var6 + var8 * var8 + var10 * var10);
   }

   static {
      ArrayList<int[]> var0 = new ArrayList<>(24);

      for (int var1 = -1; var1 <= 1; var1++) {
         for (int var2 = -1; var2 <= 1; var2++) {
            for (int var3 = -1; var3 <= 1; var3++) {
               if (var1 != 0 || var3 != 0) {
                  var0.add(new int[]{var1, var2, var3});
               }
            }
         }
      }

      I_field_160e9 = var0.toArray(new int[0][]);
   }
}
