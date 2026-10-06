package rockstar.client;

import it.unimi.dsi.fastutil.longs.Long2DoubleOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public final class iiiIIiIII_Class457 {
   private static final int I_field_49 = 60000;
   private static final long I_field_4a = 3000L;
   private static final double I_field_44 = 1.15;
   private static final ExecutorService I_field_331d0885 = Executors.newSingleThreadExecutor(var0 -> {
      Thread var1 = new Thread(var0, "Newton-Pathfinder");
      var1.setDaemon(true);
      return var1;
   });

   private iiiIIiIII_Class457() {
   }

   public static CompletableFuture<Optional<iiiIIIiiI_Class455>> I_method_7ef4ea55(iiiIIiIIi_Class458 var0, iiiIIiiii_Class464 var1) {
      return I_method_dc354dc8(var0, var1, 60000, null);
   }

   public static CompletableFuture<Optional<iiiIIIiiI_Class455>> I_method_35eb7a50(iiiIIiIIi_Class458 var0, iiiIIiiii_Class464 var1, int var2) {
      return I_method_dc354dc8(var0, var1, var2, null);
   }

   public static CompletableFuture<Optional<iiiIIIiiI_Class455>> I_method_e443eca3(iiiIIiIIi_Class458 var0, iiiIIiiii_Class464 var1, AtomicBoolean var2) {
      return I_method_dc354dc8(var0, var1, 60000, var2);
   }

   public static CompletableFuture<Optional<iiiIIIiiI_Class455>> I_method_dc354dc8(
      iiiIIiIIi_Class458 var0, iiiIIiiii_Class464 var1, int var2, @Nullable AtomicBoolean var3
   ) {
      return CompletableFuture.supplyAsync(() -> I_method_416c7619(var0, var1, var2, var3), I_field_331d0885);
   }

   public static Optional<iiiIIIiiI_Class455> I_method_594036a1(iiiIIiIIi_Class458 var0, iiiIIiiii_Class464 var1, int var2) {
      return I_method_416c7619(var0, var1, var2, (AtomicBoolean)null);
   }

   public static Optional<iiiIIIiiI_Class455> I_method_416c7619(iiiIIiIIi_Class458 var0, iiiIIiiii_Class464 var1, int var2, @Nullable AtomicBoolean var3) {
      iiiIIIiIi_Class454 var4;
      try {
         var4 = new iiiIIIiIi_Class454();
      } catch (IllegalStateException var6) {
         return Optional.empty();
      }

      return I_method_4624e93b(var0, var1, var2, 3000L, var4, var3);
   }

   public static Optional<iiiIIIiiI_Class455> I_method_5fe05cbf(iiiIIiIIi_Class458 var0, iiiIIiiii_Class464 var1, int var2, long var3, iiiIIIiIi_Class454 var5) {
      return I_method_4624e93b(var0, var1, var2, var3, var5, null);
   }

   public static Optional<iiiIIIiiI_Class455> I_method_4624e93b(
      iiiIIiIIi_Class458 var0, iiiIIiiii_Class464 var1, int var2, long var3, iiiIIIiIi_Class454 var5, @Nullable AtomicBoolean var6
   ) {
      long var7 = System.nanoTime() + var3 * 1000000L;
      Long2DoubleOpenHashMap var9 = new Long2DoubleOpenHashMap(4096);
      var9.defaultReturnValue(Double.POSITIVE_INFINITY);
      Long2ObjectOpenHashMap var10 = new Long2ObjectOpenHashMap(4096);
      PriorityQueue var11 = new PriorityQueue();
      long var12 = I_method_210b9c7b(var0);
      var9.put(var12, 0.0);
      double var14 = var1.I_method_ad4f4bf2(var0.I_method_6d204e12(), var0.i_method_6d2ed9f2(), var0.II_method_36f86d15());
      var11.add(new iiiIIiIII_Class457.Nested1_cd8ae440(var0, 0.0, var14 * 1.15));
      iiiIIiIIi_Class458 var16 = var0;
      double var17 = var14;
      double var19 = 0.0;
      int var21 = 0;

      while (!var11.isEmpty()) {
         iiiIIiIII_Class457.Nested1_cd8ae440 var22 = (iiiIIiIII_Class457.Nested1_cd8ae440)var11.poll();
         iiiIIiIIi_Class458 var23 = var22.I_field_fa2e3e6c;
         long var24 = I_method_210b9c7b(var23);
         double var26 = var9.get(var24);
         if (!(var22.I_field_44 > var26 + 1.0E-9)) {
            if (var1.I_method_ad4f4c08(var23.I_method_6d204e12(), var23.i_method_6d2ed9f2(), var23.II_method_36f86d15())) {
               return Optional.of(I_method_3824d148(var10, var0, var23));
            }

            var21++;
            if (var21 > var2 || (var21 & 0xFF) == 0 && (System.nanoTime() > var7 || var6 != null && var6.get())) {
               break;
            }

            for (iiiIiIIII_Class465 var29 : iiiIiiiIi_Class478.I_method_80268bc8(var23, var5)) {
               iiiIIiIIi_Class458 var30 = var29.i_method_5e5afeb5();
               long var31 = I_method_210b9c7b(var30);
               double var33 = var26 + var29.I_method_37257ded();
               if (var33 < var9.get(var31)) {
                  var9.put(var31, var33);
                  var10.put(var31, var29);
                  double var35 = var1.I_method_ad4f4bf2(var30.I_method_6d204e12(), var30.i_method_6d2ed9f2(), var30.II_method_36f86d15());
                  if (var35 < var17 - 1.0E-9 || var35 < var17 + 1.0E-9 && var33 < var19) {
                     var17 = var35;
                     var16 = var30;
                     var19 = var33;
                  }

                  var11.add(new iiiIIiIII_Class457.Nested1_cd8ae440(var30, var33, var33 + var35 * 1.15));
               }
            }
         }
      }

      return !var16.equals(var0) ? Optional.of(I_method_3824d148(var10, var0, var16)) : Optional.empty();
   }

   private static long I_method_210b9c7b(iiiIIiIIi_Class458 var0) {
      return BlockPos.asLong(var0.I_method_6d204e12(), var0.i_method_6d2ed9f2(), var0.II_method_36f86d15());
   }

   private static iiiIIIiiI_Class455 I_method_3824d148(Long2ObjectOpenHashMap<iiiIiIIII_Class465> var0, iiiIIiIIi_Class458 var1, iiiIIiIIi_Class458 var2) {
      ArrayList var3 = new ArrayList();
      ArrayList var4 = new ArrayList();
      iiiIIiIIi_Class458 var5 = var2;
      int var6 = 1048576;

      while (!var5.equals(var1)) {
         iiiIiIIII_Class465 var7 = (iiiIiIIII_Class465)var0.get(I_method_210b9c7b(var5));
         if (var7 == null || --var6 <= 0) {
            return new iiiIIIiiI_Class455(List.of(var1), List.of());
         }

         var3.add(var5);
         var4.add(var7);
         var5 = var7.I_method_48c58ad5();
      }

      var3.add(var1);
      Collections.reverse(var3);
      Collections.reverse(var4);
      return new iiiIIIiiI_Class455(var3, var4);
   }

   static final class Nested1_cd8ae440 implements Comparable<iiiIIiIII_Class457.Nested1_cd8ae440> {
      final iiiIIiIIi_Class458 I_field_fa2e3e6c;
      final double I_field_44;
      private final double i_field_44;

      Nested1_cd8ae440(iiiIIiIIi_Class458 var1, double var2, double var4) {
         this.I_field_fa2e3e6c = var1;
         this.I_field_44 = var2;
         this.i_field_44 = var4;
      }

      @Override
      public int compareTo(iiiIIiIII_Class457.Nested1_cd8ae440 var1) {
         int var2 = Double.compare(this.i_field_44, var1.i_field_44);
         return var2 != 0 ? var2 : Double.compare(var1.I_field_44, this.I_field_44);
      }

      @Override
      public final String toString() {
         return "Nested1_cd8ae440[node=" + this.I_field_fa2e3e6c + ", g=" + this.I_field_44 + ", f=" + this.i_field_44 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_fa2e3e6c);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_44);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_44);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iiiIIiIII_Class457.Nested1_cd8ae440 other = (iiiIIiIII_Class457.Nested1_cd8ae440) var1;
         return java.util.Objects.equals(this.I_field_fa2e3e6c, other.I_field_fa2e3e6c)
            && java.util.Objects.equals(this.I_field_44, other.I_field_44)
            && java.util.Objects.equals(this.i_field_44, other.i_field_44);
      }

      public iiiIIiIIi_Class458 I_method_f95da090() {
         return this.I_field_fa2e3e6c;
      }

      public double I_method_9983c768() {
         return this.I_field_44;
      }

      public double i_method_99925348() {
         return this.i_field_44;
      }
   }
}
