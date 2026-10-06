package rockstar.client;

import java.util.List;

public final class iiiIIIiiI_Class455 {
   private final List<iiiIIiIIi_Class458> I_field_7865b31;
   private final List<iiiIiIIII_Class465> i_field_7865b31;

   public iiiIIIiiI_Class455(List<iiiIIiIIi_Class458> var1, List<iiiIiIIII_Class465> var2) {
      this.I_field_7865b31 = var1;
      this.i_field_7865b31 = var2;
   }

   public iiiIIiIIi_Class458 I_method_1fce82f5() {
      return this.I_field_7865b31.get(0);
   }

   public iiiIIiIIi_Class458 i_method_3563f6d5() {
      return this.I_field_7865b31.get(this.I_field_7865b31.size() - 1);
   }

   public int I_method_46e45e12() {
      return this.i_field_7865b31.size();
   }

   @Override
   public final String toString() {
      return "iiiIIIiiI_Class455[nodes=" + this.I_field_7865b31 + ", movements=" + this.i_field_7865b31 + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.I_field_7865b31);
      result = 31 * result + java.util.Objects.hashCode(this.i_field_7865b31);
      return result;
   }

   @Override
   public final boolean equals(Object var1) {
      if (this == var1) return true;
      if (var1 == null || getClass() != var1.getClass()) return false;
      iiiIIIiiI_Class455 other = (iiiIIIiiI_Class455) var1;
      return java.util.Objects.equals(this.I_field_7865b31, other.I_field_7865b31)
         && java.util.Objects.equals(this.i_field_7865b31, other.i_field_7865b31);
   }

   public List<iiiIIiIIi_Class458> I_method_b5439248() {
      return this.I_field_7865b31;
   }

   public List<iiiIiIIII_Class465> i_method_6a8fca68() {
      return this.i_field_7865b31;
   }
}
