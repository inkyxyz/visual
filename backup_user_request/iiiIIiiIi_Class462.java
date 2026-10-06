package rockstar.client;

import net.minecraft.util.math.Vec3d;

public final class iiiIIiiIi_Class462 implements iiiIIiiii_Class464 {
   private final int I_field_49;
   private final int i_field_49;

   public iiiIIiiIi_Class462(int var1, int var2) {
      this.I_field_49 = var1;
      this.i_field_49 = var2;
   }

   @Override
   public boolean I_method_ad4f4c08(int var1, int var2, int var3) {
      return this.I_field_49 == var1 && this.i_field_49 == var3;
   }

   @Override
   public double I_method_ad4f4bf2(int var1, int var2, int var3) {
      double var4 = this.I_field_49 - var1;
      double var6 = this.i_field_49 - var3;
      double var8 = Math.abs(var4);
      double var10 = Math.abs(var6);
      double var12 = Math.min(var8, var10);
      double var14 = Math.abs(var8 - var10);
      return var12 * 1.41421356 + var14;
   }

   @Override
   public Vec3d I_method_f4d54579() {
      return new Vec3d(this.I_field_49 + 0.5, 64.0, this.i_field_49 + 0.5);
   }

   @Override
   public final String toString() {
      return "iiiIIiiIi_Class462[x=" + this.I_field_49 + ", z=" + this.i_field_49 + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
      result = 31 * result + java.util.Objects.hashCode(this.i_field_49);
      return result;
   }

   @Override
   public final boolean equals(Object var1) {
      if (this == var1) return true;
      if (var1 == null || getClass() != var1.getClass()) return false;
      iiiIIiiIi_Class462 other = (iiiIIiiIi_Class462) var1;
      return java.util.Objects.equals(this.I_field_49, other.I_field_49)
         && java.util.Objects.equals(this.i_field_49, other.i_field_49);
   }

   public int I_method_6945e9f2() {
      return this.I_field_49;
   }

   public int i_method_695475d2() {
      return this.i_field_49;
   }
}
