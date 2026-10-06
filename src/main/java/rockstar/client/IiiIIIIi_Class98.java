package rockstar.client;


public final class IiiIIIIi_Class98 {
   private final String I_field_523beb0a;
   private final ModuleCategory I_field_75f1ef41;
   private final int I_field_49;
   private final boolean I_field_5a;
   private final boolean i_field_5a;
   private final String i_field_523beb0a;

   public IiiIIIIi_Class98(String var1, ModuleCategory var2, int var3, boolean var4, boolean var5, String var6) {
      this.I_field_523beb0a = var1;
      this.I_field_75f1ef41 = var2;
      this.I_field_49 = var3;
      this.I_field_5a = var4;
      this.i_field_5a = var5;
      this.i_field_523beb0a = var6;
   }

   @Override
   public final String toString() {
      return "IiiIIIIi_Class98[name=" + this.I_field_523beb0a + ", category=" + this.I_field_75f1ef41 + ", key=" + this.I_field_49 + ", disableOnQuit=" + this.I_field_5a + ", enabledByDefault=" + this.i_field_5a + ", desc=" + this.i_field_523beb0a + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
      result = 31 * result + java.util.Objects.hashCode(this.I_field_75f1ef41);
      result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
      result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
      result = 31 * result + java.util.Objects.hashCode(this.i_field_5a);
      result = 31 * result + java.util.Objects.hashCode(this.i_field_523beb0a);
      return result;
   }

   @Override
   public final boolean equals(Object var1) {
      if (this == var1) return true;
      if (var1 == null || getClass() != var1.getClass()) return false;
      IiiIIIIi_Class98 other = (IiiIIIIi_Class98) var1;
      return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
         && java.util.Objects.equals(this.I_field_75f1ef41, other.I_field_75f1ef41)
         && java.util.Objects.equals(this.I_field_49, other.I_field_49)
         && java.util.Objects.equals(this.I_field_5a, other.I_field_5a)
         && java.util.Objects.equals(this.i_field_5a, other.i_field_5a)
         && java.util.Objects.equals(this.i_field_523beb0a, other.i_field_523beb0a);
   }

   public String I_method_60d60574() {
      return this.I_field_523beb0a;
   }

   public ModuleCategory I_method_a227ffab() {
      return this.I_field_75f1ef41;
   }

   public int I_method_ff0b5c9f() {
      return this.I_field_49;
   }

   public boolean I_method_ff0b5cb0() {
      return this.I_field_5a;
   }

   public boolean i_method_ff19e890() {
      return this.i_field_5a;
   }

   public String i_method_f3f4b594() {
      return this.i_field_523beb0a;
   }
}
