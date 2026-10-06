package rockstar.client;


public final class iiIiiIIIi_Class434 implements iiIiIiiIi_Class430 {
   private final String I_field_523beb0a;
   private final int I_field_49;

   public iiIiiIIIi_Class434(String var1, int var2) {
      this.I_field_523beb0a = var1;
      this.I_field_49 = var2;
   }

   @Override
   public final String toString() {
      return "iiIiiIIIi_Class434[processName=" + this.I_field_523beb0a + ", totalSteps=" + this.I_field_49 + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
      result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
      return result;
   }

   @Override
   public final boolean equals(Object var1) {
      if (this == var1) return true;
      if (var1 == null || getClass() != var1.getClass()) return false;
      iiIiiIIIi_Class434 other = (iiIiiIIIi_Class434) var1;
      return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
         && java.util.Objects.equals(this.I_field_49, other.I_field_49);
   }

   public String I_method_dfc5d861() {
      return this.I_field_523beb0a;
   }

   public int I_method_14223e12() {
      return this.I_field_49;
   }
}
