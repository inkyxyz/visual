package rockstar.client;


public final class iiIiiIIII_Class433 implements iiIiIiiIi_Class430 {
   private final String I_field_523beb0a;

   public iiIiiIIII_Class433(String var1) {
      this.I_field_523beb0a = var1;
   }

   @Override
   public final String toString() {
      return "iiIiiIIII_Class433[processName=" + this.I_field_523beb0a + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
      return result;
   }

   @Override
   public final boolean equals(Object var1) {
      if (this == var1) return true;
      if (var1 == null || getClass() != var1.getClass()) return false;
      iiIiiIIII_Class433 other = (iiIiiIIII_Class433) var1;
      return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a);
   }

   public String I_method_9992b041() {
      return this.I_field_523beb0a;
   }
}
