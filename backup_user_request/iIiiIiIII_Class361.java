package rockstar.client;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.world.BlockRenderView;

public final class iIiiIiIII_Class361 {
   private static final Direction[] I_field_8d7cb6fb = Direction.values();
   private static final iIiiIiIII_Class361.Nested1_40825c40 I_field_13810247 = new iIiiIiIII_Class361.Nested1_40825c40(0, 0, 0, 0, new byte[0]);
   private static volatile iIiiIiIII_Class361.Nested1_40825c40 i_field_13810247 = I_field_13810247;

   private iIiiIiIII_Class361() {
   }

   public static void I_method_813de9e8(BlockRenderView var0, BlockPos var1, float var2, int var3) {
      int var4 = MathHelper.ceil(var2);
      if (var4 > 0 && var3 > 0) {
         int var5 = var4 * 2 + 1;
         int var6 = var5 * var5 * var5;
         int var7 = var1.getX() - var4;
         int var8 = var1.getY() - var4;
         int var9 = var1.getZ() - var4;
         byte[] var10 = new byte[var6];
         byte[] var11 = new byte[var6];
         boolean[] var12 = new boolean[var6];
         int[] var13 = new int[var6];
         int var14 = I_method_fd07b372(var4, var4, var4, var5);
         int var15 = 0;
         int var16 = 1;
         Mutable var17 = new Mutable();
         var13[0] = var14;
         var12[var14] = true;

         while (var15 < var16) {
            int var18 = var13[var15++];
            int var19 = var18 % var5;
            int var20 = var18 / var5 % var5;
            int var21 = var18 / (var5 * var5);
            int var22 = Byte.toUnsignedInt(var11[var18]);
            var10[var18] = (byte)MathHelper.clamp(Math.round(var3 * Math.max(0.0F, var2 + 1.0F - var22) / (var2 + 1.0F)), 0, 15);
            if (var22 < var4) {
               for (Direction var26 : I_field_8d7cb6fb) {
                  int var27 = var19 + var26.getOffsetX();
                  int var28 = var20 + var26.getOffsetY();
                  int var29 = var21 + var26.getOffsetZ();
                  if (var27 >= 0 && var28 >= 0 && var29 >= 0 && var27 < var5 && var28 < var5 && var29 < var5) {
                     int var30 = I_method_fd07b372(var27, var28, var29, var5);
                     if (!var12[var30]) {
                        int var31 = var22 + 1;
                        if (!(var31 > var2)) {
                           var12[var30] = true;
                           var11[var30] = (byte)var31;
                           var10[var30] = (byte)MathHelper.clamp(Math.round(var3 * (var2 + 1.0F - var31) / (var2 + 1.0F)), 0, 15);
                           var17.set(var7 + var27, var8 + var28, var9 + var29);
                           if (!var0.getBlockState(var17).isOpaqueFullCube()) {
                              var13[var16++] = var30;
                           }
                        }
                     }
                  }
               }
            }
         }

         i_field_13810247 = new iIiiIiIII_Class361.Nested1_40825c40(var7, var8, var9, var5, var10);
      } else {
         I_method_2bac23f();
      }
   }

   public static void I_method_2bac23f() {
      i_field_13810247 = I_field_13810247;
   }

   public static int I_method_fe9701d(BlockPos var0, int var1) {
      int var2 = var1 >> 4 & 15;
      int var3 = i_field_13810247.I_method_424cc067(var0);
      return var3 <= var2 ? var1 : var1 & -241 | var3 << 4;
   }

   public static int i_method_3008583d(BlockPos var0, int var1) {
      return Math.max(var1, i_field_13810247.I_method_424cc067(var0));
   }

   static int I_method_fd07b372(int var0, int var1, int var2, int var3) {
      return (var2 * var3 + var1) * var3 + var0;
   }

   static final class Nested1_40825c40 {
      private final int I_field_49;
      private final int i_field_49;
      private final int II_field_49;
      private final int Ii_field_49;
      private final byte[] I_field_b47;

      Nested1_40825c40(int var1, int var2, int var3, int var4, byte[] var5) {
         this.I_field_49 = var1;
         this.i_field_49 = var2;
         this.II_field_49 = var3;
         this.Ii_field_49 = var4;
         this.I_field_b47 = var5;
      }

      int I_method_424cc067(BlockPos var1) {
         int var2 = var1.getX() - this.I_field_49;
         int var3 = var1.getY() - this.i_field_49;
         int var4 = var1.getZ() - this.II_field_49;
         return var2 >= 0 && var3 >= 0 && var4 >= 0 && var2 < this.Ii_field_49 && var3 < this.Ii_field_49 && var4 < this.Ii_field_49
            ? Byte.toUnsignedInt(this.I_field_b47[iIiiIiIII_Class361.I_method_fd07b372(var2, var3, var4, this.Ii_field_49)])
            : 0;
      }

      @Override
      public final String toString() {
         return "Nested1_40825c40[minX=" + this.I_field_49 + ", minY=" + this.i_field_49 + ", minZ=" + this.II_field_49 + ", size=" + this.Ii_field_49 + ", levels=" + this.I_field_b47 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.Ii_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_b47);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIiiIiIII_Class361.Nested1_40825c40 other = (iIiiIiIII_Class361.Nested1_40825c40) var1;
         return java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.i_field_49, other.i_field_49)
            && java.util.Objects.equals(this.II_field_49, other.II_field_49)
            && java.util.Objects.equals(this.Ii_field_49, other.Ii_field_49)
            && java.util.Objects.equals(this.I_field_b47, other.I_field_b47);
      }

      public int I_method_2e774f6d() {
         return this.I_field_49;
      }

      public int i_method_2e85db4d() {
         return this.i_field_49;
      }

      public int II_method_a081971a() {
         return this.II_field_49;
      }

      public int Ii_method_a09022fa() {
         return this.Ii_field_49;
      }

      public byte[] I_method_a072a0a3() {
         return this.I_field_b47;
      }
   }
}
