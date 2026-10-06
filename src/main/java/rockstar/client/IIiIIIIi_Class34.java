package rockstar.client;

import net.minecraft.text.Text;

public sealed interface IIiIIIIi_Class34 permits IIiIIIIi_Class34.Nested1_e29ec0f3, IIiIIIIi_Class34.Nested1_e29ec0d3 {
   static <T> IIiIIIIi_Class34.Nested1_e29ec0f3<T> I_method_12fc454a(T var0) {
      return new IIiIIIIi_Class34.Nested1_e29ec0f3<>((T)var0);
   }

   static IIiIIIIi_Class34.Nested1_e29ec0d3 I_method_c9d442bc(String var0) {
      iIIIIIIii_Class260.II_method_e8fd4864(Text.of(var0));
      return new IIiIIIIi_Class34.Nested1_e29ec0d3(var0);
   }

   public static final class Nested1_e29ec0d3 implements IIiIIIIi_Class34 {
      private final String I_field_523beb0a;

      public Nested1_e29ec0d3(String var1) {
         this.I_field_523beb0a = var1;
      }

      @Override
      public final String toString() {
         return "Nested1_e29ec0d3[message=" + this.I_field_523beb0a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IIiIIIIi_Class34.Nested1_e29ec0d3 other = (IIiIIIIi_Class34.Nested1_e29ec0d3) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a);
      }

      public String I_method_8964acb9() {
         return this.I_field_523beb0a;
      }
   }

   public static final class Nested1_e29ec0f3<T> implements IIiIIIIi_Class34 {
      private final T I_field_5f790d9c;

      public Nested1_e29ec0f3(T var1) {
         this.I_field_5f790d9c = (T)var1;
      }

      @Override
      public final String toString() {
         return "Nested1_e29ec0f3[value=" + this.I_field_5f790d9c + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5f790d9c);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IIiIIIIi_Class34.Nested1_e29ec0f3 other = (IIiIIIIi_Class34.Nested1_e29ec0f3) var1;
         return java.util.Objects.equals(this.I_field_5f790d9c, other.I_field_5f790d9c);
      }

      public T I_method_dcd4f76b() {
         return this.I_field_5f790d9c;
      }
   }
}
