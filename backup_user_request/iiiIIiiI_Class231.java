package rockstar.client;

import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

public final class iiiIIiiI_Class231 {
   private final Vec3d I_field_5bba0d50;
   private final Vec3d i_field_5bba0d50;
   private final iiIIiIIii_Class404 I_field_32e13e6c;
   private final boolean I_field_5a;
   private final Box I_field_bdfefbea;

   public iiiIIiiI_Class231(Vec3d var1, Vec3d var2, iiIIiIIii_Class404 var3, boolean var4, Box var5) {
      this.I_field_5bba0d50 = var1;
      this.i_field_5bba0d50 = var2;
      this.I_field_32e13e6c = var3;
      this.I_field_5a = var4;
      this.I_field_bdfefbea = var5;
   }

   @Override
   public final String toString() {
      return "iiiIIiiI_Class231[pos=" + this.I_field_5bba0d50 + ", motion=" + this.i_field_5bba0d50 + ", rotation=" + this.I_field_32e13e6c + ", onGround=" + this.I_field_5a + ", box=" + this.I_field_bdfefbea + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.I_field_5bba0d50);
      result = 31 * result + java.util.Objects.hashCode(this.i_field_5bba0d50);
      result = 31 * result + java.util.Objects.hashCode(this.I_field_32e13e6c);
      result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
      result = 31 * result + java.util.Objects.hashCode(this.I_field_bdfefbea);
      return result;
   }

   @Override
   public final boolean equals(Object var1) {
      if (this == var1) return true;
      if (var1 == null || getClass() != var1.getClass()) return false;
      iiiIIiiI_Class231 other = (iiiIIiiI_Class231) var1;
      return java.util.Objects.equals(this.I_field_5bba0d50, other.I_field_5bba0d50)
         && java.util.Objects.equals(this.i_field_5bba0d50, other.i_field_5bba0d50)
         && java.util.Objects.equals(this.I_field_32e13e6c, other.I_field_32e13e6c)
         && java.util.Objects.equals(this.I_field_5a, other.I_field_5a)
         && java.util.Objects.equals(this.I_field_bdfefbea, other.I_field_bdfefbea);
   }

   public Vec3d I_method_23447f66() {
      return this.I_field_5bba0d50;
   }

   public Vec3d i_method_c73d0346() {
      return this.i_field_5bba0d50;
   }

   public iiIIiIIii_Class404 I_method_6742b82() {
      return this.I_field_32e13e6c;
   }

   public boolean I_method_31be1cf0() {
      return this.I_field_5a;
   }

   public Box I_method_f88afb80() {
      return this.I_field_bdfefbea;
   }
}
