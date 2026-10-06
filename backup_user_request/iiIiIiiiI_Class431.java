package rockstar.client;


public final class iiIiIiiiI_Class431 implements iiIiIiiIi_Class430 {
   private final String I_field_523beb0a;
   private final int I_field_49;
   private final int i_field_49;
   private final int II_field_49;
   private final int Ii_field_49;
   private final int iI_field_49;

   public iiIiIiiiI_Class431(String var1, int var2, int var3, int var4, int var5, int var6) {
      this.I_field_523beb0a = var1;
      this.I_field_49 = var2;
      this.i_field_49 = var3;
      this.II_field_49 = var4;
      this.Ii_field_49 = var5;
      this.iI_field_49 = var6;
   }

   @Override
   public final String toString() {
      return "iiIiIiiiI_Class431[processName=" + this.I_field_523beb0a + ", x=" + this.I_field_49 + ", y=" + this.i_field_49 + ", z=" + this.II_field_49 + ", stepIndex=" + this.Ii_field_49 + ", totalSteps=" + this.iI_field_49 + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
      result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
      result = 31 * result + java.util.Objects.hashCode(this.i_field_49);
      result = 31 * result + java.util.Objects.hashCode(this.II_field_49);
      result = 31 * result + java.util.Objects.hashCode(this.Ii_field_49);
      result = 31 * result + java.util.Objects.hashCode(this.iI_field_49);
      return result;
   }

   @Override
   public final boolean equals(Object var1) {
      if (this == var1) return true;
      if (var1 == null || getClass() != var1.getClass()) return false;
      iiIiIiiiI_Class431 other = (iiIiIiiiI_Class431) var1;
      return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
         && java.util.Objects.equals(this.I_field_49, other.I_field_49)
         && java.util.Objects.equals(this.i_field_49, other.i_field_49)
         && java.util.Objects.equals(this.II_field_49, other.II_field_49)
         && java.util.Objects.equals(this.Ii_field_49, other.Ii_field_49)
         && java.util.Objects.equals(this.iI_field_49, other.iI_field_49);
   }

   public String I_method_b0d67801() {
      return this.I_field_523beb0a;
   }

   public int I_method_75d3ea72() {
      return this.I_field_49;
   }

   public int i_method_75e27652() {
      return this.i_field_49;
   }

   public int II_method_44b85cb5() {
      return this.II_field_49;
   }

   public int Ii_method_44c6e895() {
      return this.Ii_field_49;
   }

   public int iI_method_467b4cd5() {
      return this.iI_field_49;
   }
}
