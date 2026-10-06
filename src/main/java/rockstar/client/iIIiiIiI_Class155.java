package rockstar.client;

import net.minecraft.item.ItemStack;

public final class iIIiiIiI_Class155 {
   private final iIiIIiII_Class165 I_field_66c31ba1;
   private final String I_field_523beb0a;
   private final ItemStack I_field_f2735522;
   private final int I_field_49;

   public iIIiiIiI_Class155(iIiIIiII_Class165 var1, String var2, ItemStack var3, int var4) {
      this.I_field_66c31ba1 = var1;
      this.I_field_523beb0a = var2;
      this.I_field_f2735522 = var3;
      this.I_field_49 = var4;
   }

   @Override
   public final String toString() {
      return "iIIiiIiI_Class155[item=" + this.I_field_66c31ba1 + ", name=" + this.I_field_523beb0a + ", icon=" + this.I_field_f2735522 + ", defaultKey=" + this.I_field_49 + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.I_field_66c31ba1);
      result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
      result = 31 * result + java.util.Objects.hashCode(this.I_field_f2735522);
      result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
      return result;
   }

   @Override
   public final boolean equals(Object var1) {
      if (this == var1) return true;
      if (var1 == null || getClass() != var1.getClass()) return false;
      iIIiiIiI_Class155 other = (iIIiiIiI_Class155) var1;
      return java.util.Objects.equals(this.I_field_66c31ba1, other.I_field_66c31ba1)
         && java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
         && java.util.Objects.equals(this.I_field_f2735522, other.I_field_f2735522)
         && java.util.Objects.equals(this.I_field_49, other.I_field_49);
   }

   public iIiIIiII_Class165 I_method_a86ab3ab() {
      return this.I_field_66c31ba1;
   }

   public String I_method_d1992d14() {
      return this.I_field_523beb0a;
   }

   public ItemStack I_method_671bd82c() {
      return this.I_field_f2735522;
   }

   public int I_method_b48980ff() {
      return this.I_field_49;
   }
}
