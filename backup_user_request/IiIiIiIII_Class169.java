package rockstar.client;

import net.minecraft.item.Item;

public final class IiIiIiIII_Class169 {
   private final Item I_field_3c05b08c;
   private final int I_field_49;

   public IiIiIiIII_Class169(Item var1, int var2) {
      this.I_field_3c05b08c = var1;
      this.I_field_49 = var2;
   }

   @Override
   public final String toString() {
      return "IiIiIiIII_Class169[item=" + this.I_field_3c05b08c + ", key=" + this.I_field_49 + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.I_field_3c05b08c);
      result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
      return result;
   }

   @Override
   public final boolean equals(Object var1) {
      if (this == var1) return true;
      if (var1 == null || getClass() != var1.getClass()) return false;
      IiIiIiIII_Class169 other = (IiIiIiIII_Class169) var1;
      return java.util.Objects.equals(this.I_field_3c05b08c, other.I_field_3c05b08c)
         && java.util.Objects.equals(this.I_field_49, other.I_field_49);
   }

   public Item I_method_ad8357d5() {
      return this.I_field_3c05b08c;
   }

   public int I_method_a12db292() {
      return this.I_field_49;
   }
}
