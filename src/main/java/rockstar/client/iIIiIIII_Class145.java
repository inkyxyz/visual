package rockstar.client;

import java.util.function.IntConsumer;
import java.util.function.IntUnaryOperator;

public class iIIiIIII_Class145 {
   public static void I_method_cd62d617(iIIIIiii_Class136 var0, int var1, IntUnaryOperator var2, IntUnaryOperator var3, IntConsumer var4) {
      String var5 = var0.I_method_38897954().trim();
      if (var5.isEmpty()) {
         int var10 = var2.applyAsInt(0);
         int var12 = var3.applyAsInt(var10);
         var0.I_method_7d663b96(String.valueOf(var12));
         var4.accept(var10);
         iIIiIIII_Class145.Nested1_c6e38d3.I_method_9e7486c(var10, String.valueOf(var12));
      } else {
         try {
            int var6 = Integer.parseInt(var5);
            int var11 = var2.applyAsInt(var6);
            int var8 = var3.applyAsInt(var11);
            var0.I_method_7d663b96(String.valueOf(var8));
            var4.accept(var11);
            iIIiIIII_Class145.Nested1_c6e38d3.I_method_9e7486c(var11, String.valueOf(var8));
         } catch (NumberFormatException var9) {
            int var7 = var3.applyAsInt(var1);
            var0.I_method_7d663b96(String.valueOf(var7));
            iIIiIIII_Class145.Nested1_c6e38d3.i_method_3f1c0c4c(var1, String.valueOf(var7));
         }
      }
   }

   public static void I_method_38600fd1(iIIIIiii_Class136 var0, int var1, IntUnaryOperator var2, IntConsumer var3) {
      I_method_cd62d617(var0, var1, var2, var0x -> var0x, var3);
   }

   public static IntUnaryOperator I_method_b6bb3a42(int var0, int var1) {
      return var2 -> Math.clamp((long)var2, var0, var1);
   }

   public static IntUnaryOperator I_method_ccbc4e4d(int var0) {
      return var1 -> Math.max(var0, var1);
   }

   public static IntUnaryOperator i_method_60c1ae6d(int var0) {
      return var1 -> var1 + var0;
   }

   public static final class Nested1_c6e38d3 {
      private final int I_field_49;
      private final boolean I_field_5a;
      private final String I_field_523beb0a;

      public Nested1_c6e38d3(int var1, boolean var2, String var3) {
         this.I_field_49 = var1;
         this.I_field_5a = var2;
         this.I_field_523beb0a = var3;
      }

      public static iIIiIIII_Class145.Nested1_c6e38d3 I_method_92bc5176(int var0) {
         return new iIIiIIII_Class145.Nested1_c6e38d3(var0, true, String.valueOf(var0));
      }

      public static iIIiIIII_Class145.Nested1_c6e38d3 I_method_9e7486c(int var0, String var1) {
         return new iIIiIIII_Class145.Nested1_c6e38d3(var0, true, var1);
      }

      public static iIIiIIII_Class145.Nested1_c6e38d3 i_method_3f1c0c4c(int var0, String var1) {
         return new iIIiIIII_Class145.Nested1_c6e38d3(var0, false, var1);
      }

      @Override
      public final String toString() {
         return "Nested1_c6e38d3[value=" + this.I_field_49 + ", valid=" + this.I_field_5a + ", displayText=" + this.I_field_523beb0a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIIiIIII_Class145.Nested1_c6e38d3 other = (iIIiIIII_Class145.Nested1_c6e38d3) var1;
         return java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.I_field_5a, other.I_field_5a)
            && java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a);
      }

      public int I_method_826d56ba() {
         return this.I_field_49;
      }

      public boolean I_method_826d56cb() {
         return this.I_field_5a;
      }

      public String I_method_1dca24b9() {
         return this.I_field_523beb0a;
      }
   }
}
