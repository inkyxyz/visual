package rockstar.client;


public final class iIIiIIIIi_Class290 {
   private final int I_field_49;
   private final iIIIiiiii_Class288 I_field_ac24da4c;
   private final int i_field_49;
   private final int II_field_49;

   public iIIiIIIIi_Class290(int var1, iIIIiiiii_Class288 var2, int var3, int var4) {
      this.I_field_49 = var1;
      this.I_field_ac24da4c = var2;
      this.i_field_49 = var3;
      this.II_field_49 = var4;
   }

   @Override
   public final String toString() {
      return "iIIiIIIIi_Class290[number=" + this.I_field_49 + ", category=" + this.I_field_ac24da4c + ", categorySlot=" + this.i_field_49 + ", serverSlot=" + this.II_field_49 + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
      result = 31 * result + java.util.Objects.hashCode(this.I_field_ac24da4c);
      result = 31 * result + java.util.Objects.hashCode(this.i_field_49);
      result = 31 * result + java.util.Objects.hashCode(this.II_field_49);
      return result;
   }

   @Override
   public final boolean equals(Object var1) {
      if (this == var1) return true;
      if (var1 == null || getClass() != var1.getClass()) return false;
      iIIiIIIIi_Class290 other = (iIIiIIIIi_Class290) var1;
      return java.util.Objects.equals(this.I_field_49, other.I_field_49)
         && java.util.Objects.equals(this.I_field_ac24da4c, other.I_field_ac24da4c)
         && java.util.Objects.equals(this.i_field_49, other.i_field_49)
         && java.util.Objects.equals(this.II_field_49, other.II_field_49);
   }

   public int I_method_ba934a12() {
      return this.I_field_49;
   }

   public iIIIiiiii_Class288 I_method_a3650ad5() {
      return this.I_field_ac24da4c;
   }

   public int i_method_baa1d5f2() {
      return this.i_field_49;
   }

   public int II_method_97e4f115() {
      return this.II_field_49;
   }
}
