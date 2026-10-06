package rockstar.client;

import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

public final class iiiIIiiiI_Class463 implements iiiIIiiii_Class464 {
   private final int I_field_49;

   public iiiIIiiiI_Class463(int var1) {
      this.I_field_49 = var1;
   }

   @Override
   public boolean I_method_ad4f4c08(int var1, int var2, int var3) {
      return this.I_field_49 == var2;
   }

   @Override
   public double I_method_ad4f4bf2(int var1, int var2, int var3) {
      return Math.abs(this.I_field_49 - var2);
   }

   @Nullable
   @Override
   public Vec3d I_method_f4d54579() {
      return null;
   }

   @Override
   public final String toString() {
      return "iiiIIiiiI_Class463[y=" + this.I_field_49 + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
      return result;
   }

   @Override
   public final boolean equals(Object var1) {
      if (this == var1) return true;
      if (var1 == null || getClass() != var1.getClass()) return false;
      iiiIIiiiI_Class463 other = (iiiIIiiiI_Class463) var1;
      return java.util.Objects.equals(this.I_field_49, other.I_field_49);
   }

   public int I_method_cf723e32() {
      return this.I_field_49;
   }
}
