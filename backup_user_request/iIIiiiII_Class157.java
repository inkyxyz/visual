package rockstar.client;


public final class iIIiiiII_Class157 {
   private final iIIiiIiI_Class155 I_field_24ba3c1;

   public iIIiiiII_Class157(iIIiiIiI_Class155 var1) {
      this.I_field_24ba3c1 = var1;
   }

   @Override
   public final String toString() {
      return "iIIiiiII_Class157[template=" + this.I_field_24ba3c1 + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.I_field_24ba3c1);
      return result;
   }

   @Override
   public final boolean equals(Object var1) {
      if (this == var1) return true;
      if (var1 == null || getClass() != var1.getClass()) return false;
      iIIiiiII_Class157 other = (iIIiiiII_Class157) var1;
      return java.util.Objects.equals(this.I_field_24ba3c1, other.I_field_24ba3c1);
   }

   public iIIiiIiI_Class155 I_method_f8e2c00b() {
      return this.I_field_24ba3c1;
   }
}
