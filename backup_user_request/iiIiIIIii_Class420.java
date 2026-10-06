package rockstar.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Generated;

public class iiIiIIIii_Class420 {
   private static final Pattern I_field_5fd3861f = Pattern.compile("\\[(\\d{1,3}):(\\d{2})[.,](\\d{2,3})]");
   private static final Pattern i_field_5fd3861f = Pattern.compile("<(\\d{1,3}):(\\d{2})[.,](\\d{2,3})>");
   private final List<iiIiIIIii_Class420.Nested1_a969040> I_field_7865b31;
   private final boolean I_field_5a;

   private iiIiIIIii_Class420(List<iiIiIIIii_Class420.Nested1_a969040> var1, boolean var2) {
      this.I_field_7865b31 = Collections.unmodifiableList(var1);
      this.I_field_5a = var2;
   }

   public static iiIiIIIii_Class420 I_method_33a5c2ff(String var0) {
      if (var0 != null && !var0.isBlank()) {
         ArrayList var1 = new ArrayList();

         for (String var5 : var0.split("\n")) {
            String var6 = var5.trim();
            Matcher var7 = I_field_5fd3861f.matcher(var6);
            ArrayList<Long> var8 = new ArrayList<>();

            int var9;
            for (var9 = 0; var7.find() && var7.start() == var9; var9 = var7.end()) {
               var8.add(I_method_cd061ec(var7));
            }

            if (!var8.isEmpty()) {
               String var10 = var6.substring(var9).strip();
               Matcher var11 = i_field_5fd3861f.matcher(var10);
               ArrayList var12 = new ArrayList();
               StringBuilder var13 = new StringBuilder();

               int var14;
               for (var14 = 0; var11.find(); var14 = var11.end()) {
                  var13.append(var10, var14, var11.start());
                  var12.add(new iiIiIIIii_Class420.Nested1_a969020(I_method_cd061ec(var11), Character.codePointCount(var13, 0, var13.length())));
               }

               var13.append(var10, var14, var10.length());
               String var15 = var13.toString().strip();
               if (!var15.isEmpty()) {
                   for (long var17 : var8) {
                     var1.add(new iiIiIIIii_Class420.Nested1_a969040(var17, var15, var12));
                  }
               }
            }
         }

         Collections.sort(var1);
         return new iiIiIIIii_Class420(var1, true);
      } else {
         return I_method_6b642b75();
      }
   }

   public static iiIiIIIii_Class420 i_method_6cf9fedf(String var0) {
      if (var0 != null && !var0.isBlank()) {
         ArrayList var1 = new ArrayList();

         for (String var5 : var0.split("\n")) {
            String var6 = var5.trim();
            if (!var6.isEmpty()) {
               var1.add(new iiIiIIIii_Class420.Nested1_a969040(-1L, var6, List.of()));
            }
         }

         return new iiIiIIIii_Class420(var1, false);
      } else {
         return I_method_6b642b75();
      }
   }

   public static iiIiIIIii_Class420 I_method_6b642b75() {
      return new iiIiIIIii_Class420(List.of(), false);
   }

   public boolean I_method_27bb8263() {
      return this.I_field_7865b31.isEmpty();
   }

   public int I_method_cfb54038(long var1) {
      if (this.I_field_5a && !this.I_field_7865b31.isEmpty()) {
         int var3 = 0;
         int var4 = this.I_field_7865b31.size() - 1;
         int var5 = -1;

         while (var3 <= var4) {
            int var6 = var3 + var4 >>> 1;
            if (this.I_field_7865b31.get(var6).I_method_4ce39b6e() <= var1) {
               var5 = var6;
               var3 = var6 + 1;
            } else {
               var4 = var6 - 1;
            }
         }

         return var5;
      } else {
         return -1;
      }
   }

   public int I_method_b7208e72(double var1, long var3, long var5) {
      int var7 = this.I_method_cfb54038((long)var1);
      if (var7 >= 0 && !I_method_299e726d(this.I_field_7865b31.get(var7).I_method_257c66())) {
         long var8 = this.i_method_5d8dde94(var7, var3);
         if (var1 <= var8) {
            return var7;
         } else {
            long var10 = this.I_method_cfb53c78(var7);
            if (var10 != Long.MAX_VALUE && var10 - var8 <= var5 * 2L) {
               return var7;
            } else {
               return var1 - var8 <= var5 ? var7 : -1;
            }
         }
      } else {
         return -1;
      }
   }

   public float I_method_b76449ba(int var1, double var2, long var4) {
      return this.I_field_5a && var1 >= 0 && var1 < this.I_field_7865b31.size()
         ? this.II_method_cec6d857(var1, var2, this.I_method_26f2cab4(var1, var4))
         : 0.0F;
   }

   public float i_method_542bb1da(int var1, double var2, long var4) {
      return this.I_field_5a && var1 >= 0 && var1 < this.I_field_7865b31.size()
         ? this.II_method_cec6d857(var1, var2, this.i_method_5d8dde94(var1, var4))
         : 0.0F;
   }

   private float II_method_cec6d857(int var1, double var2, long var4) {
      iiIiIIIii_Class420.Nested1_a969040 var6 = this.I_field_7865b31.get(var1);
      long var7 = var6.I_method_4ce39b6e();
      if (var2 <= var7) {
         return 0.0F;
      } else if (var2 >= var4) {
         return 1.0F;
      } else if (var6.I_method_21c938d().isEmpty()) {
         return (float)((var2 - var7) / ((double)var4 - var7));
      } else {
         long var9 = var7;
         int var11 = 0;
         int var12 = var6.I_method_257c66().codePointCount(0, var6.I_method_257c66().length());

         for (iiIiIIIii_Class420.Nested1_a969020 var14 : var6.I_method_21c938d()) {
            if (var14.I_method_1648878e() > var2) {
               return I_method_8173200a(var12, var2, var9, var14.I_method_1648878e(), var11, var14.I_method_1648878d());
            }

            var9 = Math.max(var7, var14.I_method_1648878e());
            var11 = Math.clamp((long)var14.I_method_1648878d(), 0, var12);
         }

         return I_method_8173200a(var12, var2, var9, var4, var11, var12);
      }
   }

   private long I_method_26f2cab4(int var1, long var2) {
      long var4 = this.I_field_7865b31.get(var1).I_method_4ce39b6e();
      long var6 = this.I_method_cfb53c78(var1);
      if (var6 != Long.MAX_VALUE) {
         return var6;
      } else {
         long var8 = var4 + this.i_method_d1782c98(var1);
         return var2 > var4 ? Math.min(var2, var8) : var8;
      }
   }

   private long i_method_5d8dde94(int var1, long var2) {
      long var4 = this.I_field_7865b31.get(var1).I_method_4ce39b6e();
      long var6 = Math.min(this.I_method_cfb53c78(var1), var4 + this.i_method_d1782c98(var1));
      return var2 > var4 ? Math.min(var2, var6) : var6;
   }

   private long I_method_cfb53c78(int var1) {
      long var2 = this.I_field_7865b31.get(var1).I_method_4ce39b6e();

      for (int var4 = var1 + 1; var4 < this.I_field_7865b31.size(); var4++) {
         if (this.I_field_7865b31.get(var4).I_method_4ce39b6e() > var2) {
            return this.I_field_7865b31.get(var4).I_method_4ce39b6e();
         }
      }

      return Long.MAX_VALUE;
   }

   private long i_method_d1782c98(int var1) {
      String var2 = this.I_field_7865b31.get(var1).I_method_257c66();
      return Math.clamp(var2.codePointCount(0, var2.length()) * 150L, 1500L, 8000L);
   }

   private static boolean I_method_299e726d(String var0) {
      for (int var1 = 0; var1 < var0.length(); var1++) {
         if (Character.isLetterOrDigit(var0.charAt(var1))) {
            return false;
         }
      }

      return true;
   }

   private static float I_method_8173200a(int var0, double var1, long var3, long var5, int var7, int var8) {
      if (var5 > var3 && var0 != 0) {
         double var9 = Math.clamp((var1 - var3) / ((double)var5 - var3), 0.0, 1.0);
         return (float)((var7 + (var8 - var7) * var9) / var0);
      } else {
         return (float)var8 / Math.max(1, var0);
      }
   }

   private static long I_method_cd061ec(Matcher var0) {
      int var1 = Integer.parseInt(var0.group(3));
      if (var0.group(3).length() == 2) {
         var1 *= 10;
      }

      return Integer.parseInt(var0.group(1)) * 60000L + Integer.parseInt(var0.group(2)) * 1000L + var1;
   }

   @Generated
   public List<iiIiIIIii_Class420.Nested1_a969040> I_method_13376608() {
      return this.I_field_7865b31;
   }

   @Generated
   public boolean i_method_27ca0e43() {
      return this.I_field_5a;
   }

   public static final class Nested1_a969020 {
      private final long I_field_4a;
      private final int I_field_49;

      public Nested1_a969020(long var1, int var3) {
         this.I_field_4a = var1;
         this.I_field_49 = var3;
      }

      @Override
      public final String toString() {
         return "Nested1_a969020[timeMs=" + this.I_field_4a + ", charIndex=" + this.I_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_4a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iiIiIIIii_Class420.Nested1_a969020 other = (iiIiIIIii_Class420.Nested1_a969020) var1;
         return java.util.Objects.equals(this.I_field_4a, other.I_field_4a)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49);
      }

      public long I_method_1648878e() {
         return this.I_field_4a;
      }

      public int I_method_1648878d() {
         return this.I_field_49;
      }
   }

   public static final class Nested1_a969040 implements Comparable<iiIiIIIii_Class420.Nested1_a969040> {
      private final long I_field_4a;
      private final String I_field_523beb0a;
      private final List<iiIiIIIii_Class420.Nested1_a969020> I_field_7865b31;

      public Nested1_a969040(long var1, String var3, List<iiIiIIIii_Class420.Nested1_a969020> var4) {
         var4 = List.copyOf(var4);
         this.I_field_4a = var1;
         this.I_field_523beb0a = var3;
         this.I_field_7865b31 = var4;
      }

      @Override
      public int compareTo(iiIiIIIii_Class420.Nested1_a969040 var1) {
         return Long.compare(this.I_field_4a, var1.I_field_4a);
      }

      @Override
      public final String toString() {
         return "Nested1_a969040[timeMs=" + this.I_field_4a + ", text=" + this.I_field_523beb0a + ", cues=" + this.I_field_7865b31 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_4a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_7865b31);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iiIiIIIii_Class420.Nested1_a969040 other = (iiIiIIIii_Class420.Nested1_a969040) var1;
         return java.util.Objects.equals(this.I_field_4a, other.I_field_4a)
            && java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.I_field_7865b31, other.I_field_7865b31);
      }

      public long I_method_4ce39b6e() {
         return this.I_field_4a;
      }

      public String I_method_257c66() {
         return this.I_field_523beb0a;
      }

      public List<iiIiIIIii_Class420.Nested1_a969020> I_method_21c938d() {
         return this.I_field_7865b31;
      }
   }
}
