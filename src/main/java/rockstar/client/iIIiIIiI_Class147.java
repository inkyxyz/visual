package rockstar.client;

import net.minecraft.item.ItemStack;

public final class iIIiIIiI_Class147 {
   private final String I_field_523beb0a;
   private final int I_field_49;
   private final ItemStack I_field_f2735522;
   private final iIIiIIii_Class148 I_field_88b781;

   public iIIiIIiI_Class147(String var1, int var2, ItemStack var3, iIIiIIii_Class148 var4) {
      this.I_field_523beb0a = var1;
      this.I_field_49 = var2;
      this.I_field_f2735522 = var3;
      this.I_field_88b781 = var4;
   }

   @Override
   public final String toString() {
      return "iIIiIIiI_Class147[name=" + this.I_field_523beb0a + ", key=" + this.I_field_49 + ", icon=" + this.I_field_f2735522 + ", category=" + this.I_field_88b781 + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
      result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
      result = 31 * result + java.util.Objects.hashCode(this.I_field_f2735522);
      result = 31 * result + java.util.Objects.hashCode(this.I_field_88b781);
      return result;
   }

   @Override
   public final boolean equals(Object var1) {
      if (this == var1) return true;
      if (var1 == null || getClass() != var1.getClass()) return false;
      iIIiIIiI_Class147 other = (iIIiIIiI_Class147) var1;
      return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
         && java.util.Objects.equals(this.I_field_49, other.I_field_49)
         && java.util.Objects.equals(this.I_field_f2735522, other.I_field_f2735522)
         && java.util.Objects.equals(this.I_field_88b781, other.I_field_88b781);
   }

   public String I_method_966ec934() {
      return this.I_field_523beb0a;
   }

   public int I_method_2bfba0df() {
      return this.I_field_49;
   }

   public ItemStack I_method_3cc8444c() {
      return this.I_field_f2735522;
   }

   public iIIiIIii_Class148 I_method_9e37cbab() {
      return this.I_field_88b781;
   }
}
