package rockstar.client;


public final class iiIiIiiii_Class432 implements iiIiIiiIi_Class430 {
   private final String I_field_523beb0a;
   private final String i_field_523beb0a;

   public iiIiIiiii_Class432(String var1, String var2) {
      this.I_field_523beb0a = var1;
      this.i_field_523beb0a = var2;
   }

   @Override
   public final String toString() {
      return "iiIiIiiii_Class432[processName=" + this.I_field_523beb0a + ", reason=" + this.i_field_523beb0a + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
      result = 31 * result + java.util.Objects.hashCode(this.i_field_523beb0a);
      return result;
   }

   @Override
   public final boolean equals(Object var1) {
      if (this == var1) return true;
      if (var1 == null || getClass() != var1.getClass()) return false;
      iiIiIiiii_Class432 other = (iiIiIiiii_Class432) var1;
      return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
         && java.util.Objects.equals(this.i_field_523beb0a, other.i_field_523beb0a);
   }

   public String I_method_f709a021() {
      return this.I_field_523beb0a;
   }

   public String i_method_8a285041() {
      return this.i_field_523beb0a;
   }
}
