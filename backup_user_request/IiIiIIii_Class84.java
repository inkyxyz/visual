package rockstar.client;


public final class IiIiIIii_Class84 {
   private final int I_field_49;
   private final String I_field_523beb0a;

   public IiIiIIii_Class84(int var1, String var2) {
      this.I_field_49 = var1;
      this.I_field_523beb0a = var2;
   }

   @Override
   public final String toString() {
      return "IiIiIIii_Class84[keyCode=" + this.I_field_49 + ", command=" + this.I_field_523beb0a + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
      result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
      return result;
   }

   @Override
   public final boolean equals(Object var1) {
      if (this == var1) return true;
      if (var1 == null || getClass() != var1.getClass()) return false;
      IiIiIIii_Class84 other = (IiIiIIii_Class84) var1;
      return java.util.Objects.equals(this.I_field_49, other.I_field_49)
         && java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a);
   }

   public int I_method_886a907f() {
      return this.I_field_49;
   }

   public String I_method_f1090d94() {
      return this.I_field_523beb0a;
   }
}
