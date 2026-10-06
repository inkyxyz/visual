package rockstar.client;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class IiIiIIIi_Class82 {
   private static final Map<IiIIiiii_Class80, Map<String, IiIiIIIi_Class82.Nested1_bce6d33>> I_field_a567c40b = new ConcurrentHashMap<>();

   private IiIiIIIi_Class82() {
   }

   public static void I_method_310c5d3d(Object var0, IiIIiiii_Class80 var1, String var2, String var3) {
      if (var1 != null && var2 != null && !var2.isBlank() && var3 != null) {
         I_field_a567c40b.computeIfAbsent(var1, var0x -> new ConcurrentHashMap<>()).put(var2, new IiIiIIIi_Class82.Nested1_bce6d33(var0, var3));
         IiIiIIII_Class81.i_method_b516a06c();
      }
   }

   public static String I_method_865ff82a(String var0) {
      if (!I_field_a567c40b.isEmpty() && var0 != null) {
         String var1 = I_method_8348c629(IiIiIIII_Class81.I_method_21a4cfeb(), var0);
         if (var1 != null) {
            return var1;
         } else {
            String var2 = I_method_8348c629(IiIIiiii_Class80.I_field_3f56db61, var0);
            if (var2 != null) {
               return var2;
            } else {
               String var3 = I_method_8348c629(IiIIiiii_Class80.i_field_3f56db61, var0);
               if (var3 != null) {
                  return var3;
               } else {
                  for (Map var5 : I_field_a567c40b.values()) {
                     IiIiIIIi_Class82.Nested1_bce6d33 var6 = (IiIiIIIi_Class82.Nested1_bce6d33)var5.get(var0);
                     if (var6 != null) {
                        return var6.I_method_3ae4d119();
                     }
                  }

                  return null;
               }
            }
         }
      } else {
         return null;
      }
   }

   public static boolean I_method_4ecf8f3a(String var0) {
      return I_method_865ff82a(var0) != null;
   }

   public static void I_method_14e5548(Object var0) {
      boolean var1 = false;

      for (Map<String, IiIiIIIi_Class82.Nested1_bce6d33> var3 : I_field_a567c40b.values()) {
         var1 |= var3.values().removeIf(var1x -> var1x.I_method_4821f3ab() == var0);
      }

      if (var1) {
         IiIiIIII_Class81.i_method_b516a06c();
      }
   }

   public static boolean I_method_eba32870() {
      return I_field_a567c40b.isEmpty();
   }

   public static IiIIiiii_Class80 I_method_11abc881(String var0) {
      if (var0 != null && !var0.isBlank()) {
         String var1 = var0.trim().toLowerCase(Locale.ROOT).replace('-', '_');

         for (IiIIiiii_Class80 var5 : IiIIiiii_Class80.values()) {
            if (var5.I_method_881af974().equalsIgnoreCase(var1) || var5.name().equalsIgnoreCase(var1)) {
               return var5;
            }
         }

         for (IiIIiiii_Class80 var9 : IiIIiiii_Class80.values()) {
            if (var9.I_method_881af974().startsWith(var1 + "_") || var9.I_method_881af974().equals(var1 + "_" + var1)) {
               return var9;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private static String I_method_8348c629(IiIIiiii_Class80 var0, String var1) {
      Map var2 = I_field_a567c40b.get(var0);
      if (var2 == null) {
         return null;
      } else {
         IiIiIIIi_Class82.Nested1_bce6d33 var3 = (IiIiIIIi_Class82.Nested1_bce6d33)var2.get(var1);
         return var3 == null ? null : var3.I_method_3ae4d119();
      }
   }

   static final class Nested1_bce6d33 {
      private final Object I_field_5f790d9c;
      private final String I_field_523beb0a;

      Nested1_bce6d33(Object var1, String var2) {
         this.I_field_5f790d9c = var1;
         this.I_field_523beb0a = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_bce6d33[owner=" + this.I_field_5f790d9c + ", value=" + this.I_field_523beb0a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5f790d9c);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiIiIIIi_Class82.Nested1_bce6d33 other = (IiIiIIIi_Class82.Nested1_bce6d33) var1;
         return java.util.Objects.equals(this.I_field_5f790d9c, other.I_field_5f790d9c)
            && java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a);
      }

      public Object I_method_4821f3ab() {
         return this.I_field_5f790d9c;
      }

      public String I_method_3ae4d119() {
         return this.I_field_523beb0a;
      }
   }
}
