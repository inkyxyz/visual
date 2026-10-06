package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Generated;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.TooltipContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

public final class IiiiiIIii_Class244 implements iIIiIIiIi_Class294 {
   private static final Pattern I_field_5fd3861f = Pattern.compile("^[^\\p{L}\\d]{0,3}\\d[\\d.,\\u00A0 ]*[^\\p{L}\\d]{0,3}$");
   private static final long I_field_4a = 100L;
   private static final Pattern i_field_5fd3861f = Pattern.compile("\\d[\\d.,\\u00A0 ]*\\d|\\d");
   private static final Pattern II_field_5fd3861f = Pattern.compile(
      "(?:^|\\s)(?:\u043f\u043e\u0438\u0441\u043a|\u043f\u043e\u0438\u0441|\u043f\u043e\u0438|\u043f\u043e|\u043f)\\s*:", 66
   );
   private static final Pattern Ii_field_5fd3861f = Pattern.compile("(?i)\u00a7[0-9a-fk-or]");
   private static final Pattern iI_field_5fd3861f = Pattern.compile("\\s+");

   public static IiiiiIIii_Class244.Nested1_93558060 I_method_d5e31775(HandledScreen<?> var0, boolean var1, Predicate<ItemStack> var2) {
      ArrayList var3 = new ArrayList();
      IiiiiIIii_Class244.Nested1_93558040 var4 = null;
      double var5 = 0.0;
      double var7 = Double.MAX_VALUE;

      for (int var9 = 0; var9 < var0.getScreenHandler().slots.size() - 36; var9++) {
         Slot var10 = var0.getScreenHandler().getSlot(var9);
         if (var10 != null && var10.hasStack()) {
            ItemStack var11 = var10.getStack();
            if (var2 == null || var2.test(var11)) {
               List var12 = var11.getTooltip(
                  TooltipContext.create(I_field_3a9bda27.world),
                  I_field_3a9bda27.player,
                  I_field_3a9bda27.options.advancedItemTooltips ? TooltipType.ADVANCED : TooltipType.BASIC
               );
               long var13 = I_method_6e254d24(var12);
               if (var13 > 0L) {
                  int var15 = Math.max(1, var11.getCount());
                  int var16 = var11.getMaxDamage();
                  int var17 = var16 - var11.getDamage();
                  double var18 = var1 ? (double)var13 / var15 : var13;
                  double var20 = var18 / I_method_26a4eacd(var16, var17);
                  IiiiiIIii_Class244.Nested1_93558040 var22 = new IiiiiIIii_Class244.Nested1_93558040(var10.id, var11, var13, var15, var16, var17, var20);
                  var3.add(var22);
                  var5 += var20;
                  if (var20 < var7) {
                     var7 = var20;
                     var4 = var22;
                  }
               }
            }
         }
      }

      double var23 = var3.isEmpty() ? 0.0 : var5 / var3.size();
      return new IiiiiIIii_Class244.Nested1_93558060(var3, var23, var7, var4);
   }

   public static IiiiiIIii_Class244.Nested1_d75a8809 I_method_bd70b2ae(HandledScreen<?> var0, Predicate<ItemStack> var1) {
      long var2 = -1L;
      long var4 = -1L;
      long var6 = -1L;
      int var8 = -1;
      ArrayList var9 = new ArrayList();

      for (int var10 = 0; var10 < var0.getScreenHandler().slots.size() - 36; var10++) {
         Slot var11 = var0.getScreenHandler().getSlot(var10);
         if (var11 != null && var11.hasStack()) {
            ItemStack var12 = var11.getStack();
            if (var1 == null || var1.test(var12)) {
               List var13 = var12.getTooltip(
                  TooltipContext.create(I_field_3a9bda27.world),
                  I_field_3a9bda27.player,
                  I_field_3a9bda27.options.advancedItemTooltips ? TooltipType.ADVANCED : TooltipType.BASIC
               );
               long var14 = -1L;
               long var16 = -1L;
               long var18 = -1L;

               for (Text var21 : (Iterable<Text>)(Iterable<?>)var13) {
                  String var22 = var21.getString();
                  String var23 = var22.toLowerCase(Locale.ROOT);
                  if (var23.contains("\u0431\u0438\u0440\u0436\u0430 \u0431\u0430\u043b\u0430\u043d\u0441")) {
                     var16 = i_method_24042a1d(var22);
                  }

                  if (var23.contains("\u043c\u043e\u043d\u0435\u0442")) {
                     var18 = i_method_24042a1d(var22);
                  }

                  if (var23.contains("\u043a\u0443\u0440\u0441")) {
                     var14 = i_method_24042a1d(var22);
                  }
               }

               if (var16 != -1L) {
                  var2 = var16;
               }

               if (var18 != -1L) {
                  var4 = var18;
               }

               if (var14 > 0L) {
                  var9.add(new IiiiiIIii_Class244.Nested1_d75a8829(var11.id, var14));
                  if (var14 > var6) {
                     var6 = var14;
                     var8 = var11.id;
                  }
               }
            }
         }
      }

      return new IiiiiIIii_Class244.Nested1_d75a8809(var2, var4, var6, var8, var9);
   }

   public static long I_method_6e254d24(List<Text> var0) {
      long var1 = -1L;

      for (Text var4 : var0) {
         String var5 = i_method_982c4197(var4.getString());
         if (!var5.isEmpty() && !var5.contains("%")) {
            if (I_method_2e5e5fd7(var5.toLowerCase(Locale.ROOT), var5)) {
               long var6 = i_method_24042a1d(var5);
               if (var6 > 0L) {
                  return var6;
               }
            } else if (I_field_5fd3861f.matcher(var5).matches()) {
               long var8 = i_method_24042a1d(var5);
               if (var8 >= 100L) {
                  var1 = Math.max(var1, var8);
               }
            }
         }
      }

      return var1;
   }

   private static boolean I_method_2e5e5fd7(String var0, String var1) {
      boolean var2 = var0.contains("\u0446\u0435\u043d\u0430")
         || var0.contains("\u0446e\u043d\u0430")
         || var0.contains("\u0446\u0435\u043da")
         || var0.contains("\u0446e\u043da")
         || var0.contains("$")
         || var0.contains("price")
         || var0.contains("\u0441\u0442\u043e\u0438\u043c");
      return var2 && !var1.contains("%");
   }

   public static long I_method_534cd63d(String var0) {
      return i_method_24042a1d(i_method_982c4197(var0));
   }

   private static long i_method_24042a1d(String var0) {
      Matcher var1 = i_field_5fd3861f.matcher(var0);
      long var2 = -1L;

      while (var1.find()) {
         String var4 = var1.group().replaceAll("[^\\d]", "");
         if (!var4.isEmpty()) {
            try {
               var2 = Math.max(var2, Long.parseLong(var4));
            } catch (NumberFormatException var6) {
            }
         }
      }

      return var2;
   }

   private static double I_method_26a4eacd(int var0, int var1) {
      return var0 <= 0 ? 1.0 : Math.max(0.1, (double)var1 / var0);
   }

   public static String I_method_780d5977(String var0) {
      return i_method_982c4197(var0).toLowerCase(Locale.ROOT);
   }

   public static String i_method_982c4197(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         String var1 = Ii_field_5fd3861f.matcher(var0).replaceAll("");
         StringBuilder var2 = new StringBuilder(var1.length());
         var1.codePoints().forEach(var1x -> {
            if (!I_method_13f1ca8(var1x)) {
               var2.appendCodePoint(var1x);
            }
         });
         return iI_field_5fd3861f.matcher(var2).replaceAll(" ").trim();
      } else {
         return "";
      }
   }

   private static boolean I_method_13f1ca8(int var0) {
      int var1 = Character.getType(var0);
      return var1 == 18 || var1 == 15 || var1 == 16 || var1 == 19 || var1 == 0;
   }

   public static boolean I_method_534cd64d(@NotNull String var0) {
      return var0.contains("\u0430\u0443\u043a\u0446\u0438\u043e\u043d")
         || var0.contains("\u043f\u043e\u0438\u0441\u043a")
         || i_method_24042a2d(var0)
         || II_field_5fd3861f.matcher(var0).find();
   }

   public static boolean i_method_24042a2d(@NotNull String var0) {
      return var0.contains("\u0434\u043e\u043d\u043c\u0430\u0440\u043a\u0435\u0442")
         || var0.contains("\u0434\u043e\u043d \u043c\u0430\u0440\u043a\u0435\u0442");
   }

   public static boolean II_method_6da14e50(@NotNull String var0) {
      String var1 = I_method_780d5977(var0);
      return I_method_534cd64d(var1) || IiiiiIIiI_Class243.I_method_d31afa6d(var1);
   }

   public static boolean I_method_ee529f63(HandledScreen<?> var0) {
      return var0 != null && IiiiiIIiI_Class243.I_method_2dd93383(var0);
   }

   public static boolean Ii_method_3e58a230(@NotNull String var0) {
      String var1 = I_method_780d5977(var0);
      return i_method_24042a2d(var1) ? true : IiiiiIIiI_Class243.I_method_34ca0a63();
   }

   @Generated
   private IiiiiIIii_Class244() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }

   public static final class Nested1_93558040 {
      private final int I_field_49;
      private final ItemStack I_field_f2735522;
      private final long I_field_4a;
      private final int i_field_49;
      private final int II_field_49;
      private final int Ii_field_49;
      private final double I_field_44;

      public Nested1_93558040(int var1, ItemStack var2, long var3, int var5, int var6, int var7, double var8) {
         this.I_field_49 = var1;
         this.I_field_f2735522 = var2;
         this.I_field_4a = var3;
         this.i_field_49 = var5;
         this.II_field_49 = var6;
         this.Ii_field_49 = var7;
         this.I_field_44 = var8;
      }

      @Override
      public final String toString() {
         return "Nested1_93558040[slot=" + this.I_field_49 + ", stack=" + this.I_field_f2735522 + ", price=" + this.I_field_4a + ", count=" + this.i_field_49 + ", maxDurability=" + this.II_field_49 + ", curDurability=" + this.Ii_field_49 + ", effPrice=" + this.I_field_44 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_f2735522);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_4a);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.Ii_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_44);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiiiiIIii_Class244.Nested1_93558040 other = (IiiiiIIii_Class244.Nested1_93558040) var1;
         return java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.I_field_f2735522, other.I_field_f2735522)
            && java.util.Objects.equals(this.I_field_4a, other.I_field_4a)
            && java.util.Objects.equals(this.i_field_49, other.i_field_49)
            && java.util.Objects.equals(this.II_field_49, other.II_field_49)
            && java.util.Objects.equals(this.Ii_field_49, other.Ii_field_49)
            && java.util.Objects.equals(this.I_field_44, other.I_field_44);
      }

      public int I_method_15faab6d() {
         return this.I_field_49;
      }

      public ItemStack I_method_5a4ac7e() {
         return this.I_field_f2735522;
      }

      public long I_method_15faab6e() {
         return this.I_field_4a;
      }

      public int i_method_1609374d() {
         return this.i_field_49;
      }

      public int II_method_a969bb1a() {
         return this.II_field_49;
      }

      public int Ii_method_a97846fa() {
         return this.Ii_field_49;
      }

      public double I_method_15faab68() {
         return this.I_field_44;
      }
   }

   public static final class Nested1_93558060 {
      private final List<IiiiiIIii_Class244.Nested1_93558040> I_field_7865b31;
      private final double I_field_44;
      private final double i_field_44;
      private final IiiiiIIii_Class244.Nested1_93558040 I_field_1b125e47;

      public Nested1_93558060(List<IiiiiIIii_Class244.Nested1_93558040> var1, double var2, double var4, IiiiiIIii_Class244.Nested1_93558040 var6) {
         this.I_field_7865b31 = var1;
         this.I_field_44 = var2;
         this.i_field_44 = var4;
         this.I_field_1b125e47 = var6;
      }

      @Override
      public final String toString() {
         return "Nested1_93558060[items=" + this.I_field_7865b31 + ", avgEffPrice=" + this.I_field_44 + ", minEffPrice=" + this.i_field_44 + ", cheapest=" + this.I_field_1b125e47 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_7865b31);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_44);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_44);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_1b125e47);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiiiiIIii_Class244.Nested1_93558060 other = (IiiiiIIii_Class244.Nested1_93558060) var1;
         return java.util.Objects.equals(this.I_field_7865b31, other.I_field_7865b31)
            && java.util.Objects.equals(this.I_field_44, other.I_field_44)
            && java.util.Objects.equals(this.i_field_44, other.i_field_44)
            && java.util.Objects.equals(this.I_field_1b125e47, other.I_field_1b125e47);
      }

      public List<IiiiiIIii_Class244.Nested1_93558040> I_method_b92233ad() {
         return this.I_field_7865b31;
      }

      public double I_method_4c95bf48() {
         return this.I_field_44;
      }

      public double i_method_4ca44b28() {
         return this.i_field_44;
      }

      public IiiiiIIii_Class244.Nested1_93558040 I_method_a6e32f4b() {
         return this.I_field_1b125e47;
      }
   }

   public static final class Nested1_d75a8809 {
      private final long I_field_4a;
      private final long i_field_4a;
      private final long II_field_4a;
      private final int I_field_49;
      private final List<IiiiiIIii_Class244.Nested1_d75a8829> I_field_7865b31;

      public Nested1_d75a8809(long var1, long var3, long var5, int var7, List<IiiiiIIii_Class244.Nested1_d75a8829> var8) {
         this.I_field_4a = var1;
         this.i_field_4a = var3;
         this.II_field_4a = var5;
         this.I_field_49 = var7;
         this.I_field_7865b31 = var8;
      }

      @Override
      public final String toString() {
         return "Nested1_d75a8809[exchangeBalance=" + this.I_field_4a + ", balance=" + this.i_field_4a + ", bestRate=" + this.II_field_4a + ", bestSlot=" + this.I_field_49 + ", allOffers=" + this.I_field_7865b31 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_4a);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_4a);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_4a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_7865b31);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiiiiIIii_Class244.Nested1_d75a8809 other = (IiiiiIIii_Class244.Nested1_d75a8809) var1;
         return java.util.Objects.equals(this.I_field_4a, other.I_field_4a)
            && java.util.Objects.equals(this.i_field_4a, other.i_field_4a)
            && java.util.Objects.equals(this.II_field_4a, other.II_field_4a)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.I_field_7865b31, other.I_field_7865b31);
      }

      public long I_method_d6001945() {
         return this.I_field_4a;
      }

      public long i_method_d60ea525() {
         return this.i_field_4a;
      }

      public long II_method_ea120824() {
         return this.II_field_4a;
      }

      public int I_method_d6001944() {
         return this.I_field_49;
      }

      public List<IiiiiIIii_Class244.Nested1_d75a8829> I_method_4857ccd6() {
         return this.I_field_7865b31;
      }
   }

   public static final class Nested1_d75a8829 {
      private final int I_field_49;
      private final long I_field_4a;

      public Nested1_d75a8829(int var1, long var2) {
         this.I_field_49 = var1;
         this.I_field_4a = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_d75a8829[slot=" + this.I_field_49 + ", rate=" + this.I_field_4a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_4a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiiiiIIii_Class244.Nested1_d75a8829 other = (IiiiiIIii_Class244.Nested1_d75a8829) var1;
         return java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.I_field_4a, other.I_field_4a);
      }

      public int I_method_c9b2d24() {
         return this.I_field_49;
      }

      public long I_method_c9b2d25() {
         return this.I_field_4a;
      }
   }
}
