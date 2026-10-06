package rockstar.client;


public final class IIIiiiiI_Class31<T> {
   private final String I_field_523beb0a;
   private final boolean I_field_5a;
   private final boolean i_field_5a;
   private final IIiIIIII_Class33 I_field_de26afa1;

   public IIIiiiiI_Class31(String var1, boolean var2, boolean var3, IIiIIIII_Class33 var4) {
      this.I_field_523beb0a = var1;
      this.I_field_5a = var2;
      this.i_field_5a = var3;
      this.I_field_de26afa1 = var4;
   }

   @Override
   public final String toString() {
      return "IIIiiiiI_Class31[name=" + this.I_field_523beb0a + ", required=" + this.I_field_5a + ", vararg=" + this.i_field_5a + ", validator=" + this.I_field_de26afa1 + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
      result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
      result = 31 * result + java.util.Objects.hashCode(this.i_field_5a);
      result = 31 * result + java.util.Objects.hashCode(this.I_field_de26afa1);
      return result;
   }

   @Override
   public final boolean equals(Object var1) {
      if (this == var1) return true;
      if (var1 == null || getClass() != var1.getClass()) return false;
      IIIiiiiI_Class31 other = (IIIiiiiI_Class31) var1;
      return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
         && java.util.Objects.equals(this.I_field_5a, other.I_field_5a)
         && java.util.Objects.equals(this.i_field_5a, other.i_field_5a)
         && java.util.Objects.equals(this.I_field_de26afa1, other.I_field_de26afa1);
   }

   public String I_method_420d5954() {
      return this.I_field_523beb0a;
   }

   public boolean I_method_e04e4cd0() {
      return this.I_field_5a;
   }

   public boolean i_method_e05cd8b0() {
      return this.i_field_5a;
   }

   public IIiIIIII_Class33 I_method_b07233eb() {
      return this.I_field_de26afa1;
   }
}
