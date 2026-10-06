package rockstar.client;


public final class IiIIiiiii_Class160 {
   private final Runnable I_field_bac0a97e;
   private final Runnable i_field_bac0a97e;

   public IiIIiiiii_Class160(Runnable var1, Runnable var2) {
      this.I_field_bac0a97e = var1;
      this.i_field_bac0a97e = var2;
   }

   @Override
   public final String toString() {
      return "IiIIiiiii_Class160[enter=" + this.I_field_bac0a97e + ", tab=" + this.i_field_bac0a97e + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.I_field_bac0a97e);
      result = 31 * result + java.util.Objects.hashCode(this.i_field_bac0a97e);
      return result;
   }

   @Override
   public final boolean equals(Object var1) {
      if (this == var1) return true;
      if (var1 == null || getClass() != var1.getClass()) return false;
      IiIIiiiii_Class160 other = (IiIIiiiii_Class160) var1;
      return java.util.Objects.equals(this.I_field_bac0a97e, other.I_field_bac0a97e)
         && java.util.Objects.equals(this.i_field_bac0a97e, other.i_field_bac0a97e);
   }

   public Runnable I_method_bc6510f5() {
      return this.I_field_bac0a97e;
   }

   public Runnable i_method_2983915() {
      return this.i_field_bac0a97e;
   }
}
