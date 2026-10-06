package rockstar.client;

import net.minecraft.util.math.BlockPos;

public final class iiiIIiIIi_Class458 {
   private final int I_field_49;
   private final int i_field_49;
   private final int II_field_49;

   public iiiIIiIIi_Class458(int var1, int var2, int var3) {
      this.I_field_49 = var1;
      this.i_field_49 = var2;
      this.II_field_49 = var3;
   }

   public BlockPos I_method_a9d25211() {
      return new BlockPos(this.I_field_49, this.i_field_49, this.II_field_49);
   }

   public static iiiIIiIIi_Class458 I_method_af43662f(BlockPos var0) {
      return new iiiIIiIIi_Class458(var0.getX(), var0.getY(), var0.getZ());
   }

   @Override
   public final String toString() {
      return "iiiIIiIIi_Class458[x=" + this.I_field_49 + ", y=" + this.i_field_49 + ", z=" + this.II_field_49 + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
      result = 31 * result + java.util.Objects.hashCode(this.i_field_49);
      result = 31 * result + java.util.Objects.hashCode(this.II_field_49);
      return result;
   }

   @Override
   public final boolean equals(Object var1) {
      if (this == var1) return true;
      if (var1 == null || getClass() != var1.getClass()) return false;
      iiiIIiIIi_Class458 other = (iiiIIiIIi_Class458) var1;
      return java.util.Objects.equals(this.I_field_49, other.I_field_49)
         && java.util.Objects.equals(this.i_field_49, other.i_field_49)
         && java.util.Objects.equals(this.II_field_49, other.II_field_49);
   }

   public int I_method_6d204e12() {
      return this.I_field_49;
   }

   public int i_method_6d2ed9f2() {
      return this.i_field_49;
   }

   public int II_method_36f86d15() {
      return this.II_field_49;
   }
}
