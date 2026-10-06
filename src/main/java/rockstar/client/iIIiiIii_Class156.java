package rockstar.client;

import java.util.List;

public final class iIIiiIii_Class156 {
   private final String I_field_523beb0a;
   private final List<iIIiiIiI_Class155> I_field_7865b31;

   public iIIiiIii_Class156(String var1, List<iIIiiIiI_Class155> var2) {
      this.I_field_523beb0a = var1;
      this.I_field_7865b31 = var2;
   }

   @Override
   public final String toString() {
      return "iIIiiIii_Class156[title=" + this.I_field_523beb0a + ", items=" + this.I_field_7865b31 + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
      result = 31 * result + java.util.Objects.hashCode(this.I_field_7865b31);
      return result;
   }

   @Override
   public final boolean equals(Object var1) {
      if (this == var1) return true;
      if (var1 == null || getClass() != var1.getClass()) return false;
      iIIiiIii_Class156 other = (iIIiiIii_Class156) var1;
      return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
         && java.util.Objects.equals(this.I_field_7865b31, other.I_field_7865b31);
   }

   public String I_method_17cc5534() {
      return this.I_field_523beb0a;
   }

   public List<iIIiiIiI_Class155> I_method_6f9f47db() {
      return this.I_field_7865b31;
   }
}
