package rockstar.client;

import java.util.List;

public final class IIIiiIii_Class28 {
   private final IIIiiIIi_Class26 I_field_79bd4f61;
   private final List<Object> I_field_7865b31;

   public IIIiiIii_Class28(IIIiiIIi_Class26 var1, List<Object> var2) {
      this.I_field_79bd4f61 = var1;
      this.I_field_7865b31 = var2;
   }

   @Override
   public final String toString() {
      return "IIIiiIii_Class28[command=" + this.I_field_79bd4f61 + ", arguments=" + this.I_field_7865b31 + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.I_field_79bd4f61);
      result = 31 * result + java.util.Objects.hashCode(this.I_field_7865b31);
      return result;
   }

   @Override
   public final boolean equals(Object var1) {
      if (this == var1) return true;
      if (var1 == null || getClass() != var1.getClass()) return false;
      IIIiiIii_Class28 other = (IIIiiIii_Class28) var1;
      return java.util.Objects.equals(this.I_field_79bd4f61, other.I_field_79bd4f61)
         && java.util.Objects.equals(this.I_field_7865b31, other.I_field_7865b31);
   }

   public IIIiiIIi_Class26 I_method_2e2a5bab() {
      return this.I_field_79bd4f61;
   }

   public List<Object> I_method_557e5bfb() {
      return this.I_field_7865b31;
   }
}
