package rockstar.client;

import java.util.List;

public final class iIiIIIiii_Class328 {
   private final boolean I_field_5a;
   private final List<String> I_field_7865b31;
   public static final iIiIIIiii_Class328 I_field_6fec722c = new iIiIIIiii_Class328(true, null);

   public iIiIIIiii_Class328(boolean var1, List<String> var2) {
      this.I_field_5a = var1;
      this.I_field_7865b31 = var2;
   }

   @Override
   public final String toString() {
      return "iIiIIIiii_Class328[valid=" + this.I_field_5a + ", errors=" + this.I_field_7865b31 + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
      result = 31 * result + java.util.Objects.hashCode(this.I_field_7865b31);
      return result;
   }

   @Override
   public final boolean equals(Object var1) {
      if (this == var1) return true;
      if (var1 == null || getClass() != var1.getClass()) return false;
      iIiIIIiii_Class328 other = (iIiIIIiii_Class328) var1;
      return java.util.Objects.equals(this.I_field_5a, other.I_field_5a)
         && java.util.Objects.equals(this.I_field_7865b31, other.I_field_7865b31);
   }

   public boolean I_method_ad1ea1e3() {
      return this.I_field_5a;
   }

   public List<String> I_method_2e415688() {
      return this.I_field_7865b31;
   }
}
