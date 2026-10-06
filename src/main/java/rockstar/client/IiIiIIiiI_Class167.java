package rockstar.client;

import java.util.Stack;

public class IiIiIIiiI_Class167 {
   private final Stack<IiIiIIiiI_Class167.Nested1_6fc2b000> I_field_f5c9915f = new Stack<>();
   private final Stack<IiIiIIiiI_Class167.Nested1_6fc2b000> i_field_f5c9915f = new Stack<>();

   public void I_method_1bfadd07(IiIiIIiII_Class165 var1, float var2, float var3, float var4, float var5) {
      this.I_field_f5c9915f.push(new IiIiIIiiI_Class167.Nested1_6fc2b000(var1, var2, var3, var4, var5, System.currentTimeMillis()));
      this.i_field_f5c9915f.clear();
   }

   public void I_method_b18cd67f() {
      if (!this.I_field_f5c9915f.isEmpty()) {
         IiIiIIiiI_Class167.Nested1_6fc2b000 var1 = this.I_field_f5c9915f.pop();
         var1.I_method_4cdb9d10().pos(var1.I_method_711553aa(), var1.i_method_7123df8a());
         this.i_field_f5c9915f.push(var1);
      }
   }

   public void i_method_b19b625f() {
      if (!this.i_field_f5c9915f.isEmpty()) {
         IiIiIIiiI_Class167.Nested1_6fc2b000 var1 = this.i_field_f5c9915f.pop();
         var1.I_method_4cdb9d10().pos(var1.II_method_b1a41ad7(), var1.Ii_method_b1b2a6b7());
         this.I_field_f5c9915f.push(var1);
      }
   }

   public boolean I_method_b18cd683() {
      return !this.I_field_f5c9915f.isEmpty();
   }

   public boolean i_method_b19b6263() {
      return !this.i_field_f5c9915f.isEmpty();
   }

   public long I_method_b18cd673() {
      return this.I_field_f5c9915f.isEmpty() ? Long.MIN_VALUE : this.I_field_f5c9915f.peek().I_method_711553ae();
   }

   public long i_method_b19b6253() {
      return this.i_field_f5c9915f.isEmpty() ? Long.MIN_VALUE : this.i_field_f5c9915f.peek().I_method_711553ae();
   }

   static final class Nested1_6fc2b000 {
      private final IiIiIIiII_Class165 I_field_fed7eac;
      private final float I_field_46;
      private final float i_field_46;
      private final float II_field_46;
      private final float Ii_field_46;
      private final long I_field_4a;

      Nested1_6fc2b000(IiIiIIiII_Class165 var1, float var2, float var3, float var4, float var5, long var6) {
         this.I_field_fed7eac = var1;
         this.I_field_46 = var2;
         this.i_field_46 = var3;
         this.II_field_46 = var4;
         this.Ii_field_46 = var5;
         this.I_field_4a = var6;
      }

      @Override
      public final String toString() {
         return "Nested1_6fc2b000[element=" + this.I_field_fed7eac + ", fromX=" + this.I_field_46 + ", fromY=" + this.i_field_46 + ", toX=" + this.II_field_46 + ", toY=" + this.Ii_field_46 + ", time=" + this.I_field_4a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_fed7eac);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.Ii_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_4a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiIiIIiiI_Class167.Nested1_6fc2b000 other = (IiIiIIiiI_Class167.Nested1_6fc2b000) var1;
         return java.util.Objects.equals(this.I_field_fed7eac, other.I_field_fed7eac)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46)
            && java.util.Objects.equals(this.I_field_4a, other.I_field_4a);
      }

      public IiIiIIiII_Class165 I_method_4cdb9d10() {
         return this.I_field_fed7eac;
      }

      public float I_method_711553aa() {
         return this.I_field_46;
      }

      public float i_method_7123df8a() {
         return this.i_field_46;
      }

      public float II_method_b1a41ad7() {
         return this.II_field_46;
      }

      public float Ii_method_b1b2a6b7() {
         return this.Ii_field_46;
      }

      public long I_method_711553ae() {
         return this.I_field_4a;
      }
   }
}
