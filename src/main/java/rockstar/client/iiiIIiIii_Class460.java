package rockstar.client;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public final class iiiIIiIii_Class460 implements iiiIIiiii_Class464 {
   private final int I_field_49;
   private final int i_field_49;
   private final int II_field_49;

   public iiiIIiIii_Class460(BlockPos var1) {
      this(var1.getX(), var1.getY(), var1.getZ());
   }

   public iiiIIiIii_Class460(int var1, int var2, int var3) {
      this.I_field_49 = var1;
      this.i_field_49 = var2;
      this.II_field_49 = var3;
   }

   @Override
   public boolean I_method_ad4f4c08(int var1, int var2, int var3) {
      return this.I_field_49 == var1 && this.i_field_49 == var2 && this.II_field_49 == var3;
   }

   @Override
   public double I_method_ad4f4bf2(int var1, int var2, int var3) {
      double var4 = this.I_field_49 - var1;
      double var6 = this.i_field_49 - var2;
      double var8 = this.II_field_49 - var3;
      double var10 = Math.abs(var4);
      double var12 = Math.abs(var8);
      double var14 = Math.min(var10, var12);
      double var16 = Math.abs(var10 - var12);
      return var14 * 1.41421356 + var16 + Math.abs(var6);
   }

   @Override
   public Vec3d I_method_f4d54579() {
      return new Vec3d(this.I_field_49 + 0.5, this.i_field_49, this.II_field_49 + 0.5);
   }

   @Override
   public final String toString() {
      return "iiiIIiIii_Class460[x=" + this.I_field_49 + ", y=" + this.i_field_49 + ", z=" + this.II_field_49 + "]";
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
      iiiIIiIii_Class460 other = (iiiIIiIii_Class460) var1;
      return java.util.Objects.equals(this.I_field_49, other.I_field_49)
         && java.util.Objects.equals(this.i_field_49, other.i_field_49)
         && java.util.Objects.equals(this.II_field_49, other.II_field_49);
   }

   public int I_method_9e7b632() {
      return this.I_field_49;
   }

   public int i_method_9f64212() {
      return this.i_field_49;
   }

   public int II_method_331e08f5() {
      return this.II_field_49;
   }
}
