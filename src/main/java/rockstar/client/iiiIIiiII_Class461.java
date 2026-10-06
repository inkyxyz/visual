package rockstar.client;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public final class iiiIIiiII_Class461 implements iiiIIiiii_Class464 {
   private final int I_field_49;
   private final int i_field_49;
   private final int II_field_49;
   private final int Ii_field_49;

   public iiiIIiiII_Class461(BlockPos var1, int var2) {
      this(var1.getX(), var1.getY(), var1.getZ(), var2);
   }

   public iiiIIiiII_Class461(int var1, int var2, int var3, int var4) {
      this.I_field_49 = var1;
      this.i_field_49 = var2;
      this.II_field_49 = var3;
      this.Ii_field_49 = var4;
   }

   @Override
   public boolean I_method_ad4f4c08(int var1, int var2, int var3) {
      long var4 = this.I_field_49 - var1;
      long var6 = this.i_field_49 - var2;
      long var8 = this.II_field_49 - var3;
      return var4 * var4 + var6 * var6 + var8 * var8 <= (long)this.Ii_field_49 * this.Ii_field_49;
   }

   @Override
   public double I_method_ad4f4bf2(int var1, int var2, int var3) {
      double var4 = this.I_field_49 - var1;
      double var6 = this.i_field_49 - var2;
      double var8 = this.II_field_49 - var3;
      double var10 = Math.sqrt(var4 * var4 + var6 * var6 + var8 * var8);
      return Math.max(0.0, var10 - this.Ii_field_49);
   }

   @Override
   public Vec3d I_method_f4d54579() {
      return new Vec3d(this.I_field_49 + 0.5, this.i_field_49, this.II_field_49 + 0.5);
   }

   @Override
   public final String toString() {
      return "iiiIIiiII_Class461[x=" + this.I_field_49 + ", y=" + this.i_field_49 + ", z=" + this.II_field_49 + ", radius=" + this.Ii_field_49 + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
      result = 31 * result + java.util.Objects.hashCode(this.i_field_49);
      result = 31 * result + java.util.Objects.hashCode(this.II_field_49);
      result = 31 * result + java.util.Objects.hashCode(this.Ii_field_49);
      return result;
   }

   @Override
   public final boolean equals(Object var1) {
      if (this == var1) return true;
      if (var1 == null || getClass() != var1.getClass()) return false;
      iiiIIiiII_Class461 other = (iiiIIiiII_Class461) var1;
      return java.util.Objects.equals(this.I_field_49, other.I_field_49)
         && java.util.Objects.equals(this.i_field_49, other.i_field_49)
         && java.util.Objects.equals(this.II_field_49, other.II_field_49)
         && java.util.Objects.equals(this.Ii_field_49, other.Ii_field_49);
   }

   public int I_method_32aad612() {
      return this.I_field_49;
   }

   public int i_method_32b961f2() {
      return this.i_field_49;
   }

   public int II_method_22bee515() {
      return this.II_field_49;
   }

   public int Ii_method_22cd70f5() {
      return this.Ii_field_49;
   }
}
