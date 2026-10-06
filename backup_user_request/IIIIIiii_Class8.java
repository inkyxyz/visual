package rockstar.client;

import java.util.Locale;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class IIIIIiii_Class8 implements IIIIiIII_Class9 {
   private final int I_field_49;
   private final long I_field_4a;
   private final long i_field_4a;
   private long II_field_4a;
   private long Ii_field_4a;
   private long iI_field_4a;
   private long ii_field_4a;
   private boolean I_field_5a;

   public IIIIIiii_Class8(int var1, int var2) {
      this(var1, var2, 0L);
   }

   public IIIIIiii_Class8(int var1, int var2, long var3) {
      this.I_field_49 = var1;
      this.I_field_4a = Math.max(1, var2) * 1000L;
      this.i_field_4a = Math.max(0L, var3);
   }

   @Override
   public void I_method_f2de637a(iiiiiii_Class128 var1) {
      if (var1 != null && var1.Ii_method_16f24ea6()) {
         long var2 = System.currentTimeMillis();
         if (!this.I_field_5a) {
            this.I_field_5a = true;
            this.II_field_4a = var2;
            this.Ii_field_4a = var2 - this.I_field_4a + this.i_field_4a + this.I_method_8ff76b8e(var1);
         } else if (var2 - this.II_field_4a >= this.i_field_4a) {
            if (var1.I_method_e09ce338().I_method_6865f490()) {
               if (var2 - this.iI_field_4a >= var1.I_method_e08ecf78().IiI_method_e9bc9a00()) {
                  this.I_method_6ef67e6a(var1, var2);
                  this.iI_field_4a = var2;
               }
            } else if (var2 - this.Ii_field_4a >= this.I_field_4a) {
               if (var1.I_method_c28f1feb(Items.COMPASS)) {
                  var1.III_method_c5a38cdf();
               } else {
                  var1.I_method_98066c89(var1.I_method_e08ecf78().I_method_9cea6554() + this.I_field_49);
               }

               this.Ii_field_4a = var2;
            }
         }
      }
   }

   private void I_method_6ef67e6a(iiiiiii_Class128 var1, long var2) {
      if (var2 - this.ii_field_4a >= var1.I_method_e08ecf78().IIi_method_e80835c0()) {
         IIIIIiii_Class8.Nested1_e84aa0f3 var4 = this.I_method_225b5818(var1);
         int var5 = this.I_method_62de4efb(var4);
         if (var5 >= 0) {
            if (var1.I_method_16d53e68(var5)) {
               this.ii_field_4a = var2;
               if (var5 == var4.iI_method_78c539ad()) {
                  var1.I_method_b8ab1d60(new IIIIiiIi_Class14());
               }
            }
         }
      }
   }

   private int I_method_62de4efb(IIIIIiii_Class8.Nested1_e84aa0f3 var1) {
      if (var1.i_method_5ebb8e8b() && var1.I_method_5ead029a() >= 0 && var1.i_method_5ebb8e7a() < 0) {
         return var1.I_method_5ead029a();
      } else if (var1.i_method_5ebb8e7a() >= 0) {
         return var1.i_method_5ebb8e7a();
      } else {
         boolean var2 = this.I_field_49 > 36;
         if (var2 && !var1.I_method_5ead02ab()) {
            return var1.II_method_7702498d();
         } else {
            return !var2 && var1.I_method_5ead02ab() ? var1.Ii_method_7710d56d() : var1.iI_method_78c539ad();
         }
      }
   }

   private IIIIIiii_Class8.Nested1_e84aa0f3 I_method_225b5818(iiiiiii_Class128 var1) {
      boolean var2 = false;
      boolean var3 = false;
      int var4 = -1;
      int var5 = -1;
      int var6 = -1;
      int var7 = -1;
      int var8 = -1;
      ItemStack[] var9 = var1.I_method_e09ce338().II_method_16364ffc();

      for (int var10 = 0; var10 < var9.length; var10++) {
         ItemStack var11 = var9[var10];
         if (var11 != null && !var11.isEmpty()) {
            String var12 = this.I_method_17d75bea(var11.getName().getString());
            if (!var12.isBlank()) {
               if (var12.contains("\u0433\u0440\u0438\u0444\u0435\u0440\u0441\u043a\u043e\u0435 \u0432\u044b\u0436\u0438\u0432\u0430\u043d\u0438\u0435")
                  || var12.contains("grief survival")) {
                  var5 = this.I_method_6f5741ff(var5, var10);
               }

               if (var12.contains("\u043f\u043e\u0434\u0441\u043a\u0430\u0437") || var12.contains("hint")) {
                  var3 = true;
               }

               if (this.i_method_cd5b8f3c(var11, var12)) {
                  var4 = this.I_method_6f5741ff(var4, var10);
               }

               if (this.i_method_b104875a(var12)) {
                  var2 = true;
                  var7 = this.I_method_6f5741ff(var7, var10);
               }

               if (this.I_method_1248435c(var11, var12)) {
                  var6 = this.I_method_6f5741ff(var6, var10);
               }

               if (var8 < 0 && this.I_method_e04d337a(var12)) {
                  var8 = var10;
               }
            }
         }
      }

      return new IIIIIiii_Class8.Nested1_e84aa0f3(var2, var3, var4, var5, var6, var7, var8);
   }

   private boolean I_method_e04d337a(String var1) {
      String var2 = String.valueOf(this.I_field_49);
      return var1.contains("\u0433\u0440\u0438\u0444 #" + var2)
         || var1.contains("\u0433\u0440\u0438\u0444 \u2116" + var2)
         || var1.contains("\u0433\u0440\u0438\u0444 " + var2)
         || var1.contains("grief #" + var2)
         || var1.contains("grief " + var2);
   }

   private boolean I_method_1248435c(ItemStack var1, String var2) {
      return var2.contains("\u0441\u043b\u0435\u0434\u0443\u044e\u0449\u0430\u044f")
         || var2.contains("next")
         || var1.getItem() == Items.ARROW
            && !var2.contains("\u043f\u0440\u0435\u0434\u044b\u0434\u0443\u0449")
            && !var2.contains("\u043d\u0430\u0437\u0430\u0434")
            && !var2.contains("back");
   }

   private boolean i_method_b104875a(String var1) {
      return var1.contains("\u043f\u0440\u0435\u0434\u044b\u0434\u0443\u0449") || var1.contains("previous");
   }

   private boolean i_method_cd5b8f3c(ItemStack var1, String var2) {
      return var1.getItem() != Items.ARROW && var1.getItem() != Items.BARRIER
         ? false
         : var2.contains("\u043d\u0430\u0437\u0430\u0434")
            || var2.contains("back")
            || var2.contains("\u043c\u0435\u043d\u044e")
            || var2.contains("\u0432\u044b\u0445\u043e\u0434")
            || var2.contains("\u0437\u0430\u043a\u0440\u044b\u0442\u044c");
   }

   private int I_method_6f5741ff(int var1, int var2) {
      return var1 < 0 ? var2 : var1;
   }

   private String I_method_17d75bea(String var1) {
      return var1 == null ? "" : var1.replaceAll("\u00a7.", "").toLowerCase(Locale.ROOT);
   }

   private long I_method_8ff76b8e(iiiiiii_Class128 var1) {
      String var2 = var1.I_method_7b75de01();
      return var2 == null ? 0L : Math.floorMod((long)var2.hashCode(), Math.max(1L, this.I_field_4a));
   }

   @Override
   public String I_method_dcc0dd54() {
      return "AutoJoinGrief " + this.I_field_49;
   }

   static final class Nested1_e84aa0f3 {
      private final boolean I_field_5a;
      private final boolean i_field_5a;
      private final int I_field_49;
      private final int i_field_49;
      private final int II_field_49;
      private final int Ii_field_49;
      private final int iI_field_49;

      Nested1_e84aa0f3(boolean var1, boolean var2, int var3, int var4, int var5, int var6, int var7) {
         this.I_field_5a = var1;
         this.i_field_5a = var2;
         this.I_field_49 = var3;
         this.i_field_49 = var4;
         this.II_field_49 = var5;
         this.Ii_field_49 = var6;
         this.iI_field_49 = var7;
      }

      @Override
      public final String toString() {
         return "Nested1_e84aa0f3[onSecondPage=" + this.I_field_5a + ", hasHints=" + this.i_field_5a + ", backSlot=" + this.I_field_49 + ", mainMenuSlot=" + this.i_field_49 + ", nextPageSlot=" + this.II_field_49 + ", previousPageSlot=" + this.Ii_field_49 + ", targetGriefSlot=" + this.iI_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_5a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.Ii_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.iI_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IIIIIiii_Class8.Nested1_e84aa0f3 other = (IIIIIiii_Class8.Nested1_e84aa0f3) var1;
         return java.util.Objects.equals(this.I_field_5a, other.I_field_5a)
            && java.util.Objects.equals(this.i_field_5a, other.i_field_5a)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.i_field_49, other.i_field_49)
            && java.util.Objects.equals(this.II_field_49, other.II_field_49)
            && java.util.Objects.equals(this.Ii_field_49, other.Ii_field_49)
            && java.util.Objects.equals(this.iI_field_49, other.iI_field_49);
      }

      public boolean I_method_5ead02ab() {
         return this.I_field_5a;
      }

      public boolean i_method_5ebb8e8b() {
         return this.i_field_5a;
      }

      public int I_method_5ead029a() {
         return this.I_field_49;
      }

      public int i_method_5ebb8e7a() {
         return this.i_field_49;
      }

      public int II_method_7702498d() {
         return this.II_field_49;
      }

      public int Ii_method_7710d56d() {
         return this.Ii_field_49;
      }

      public int iI_method_78c539ad() {
         return this.iI_field_49;
      }
   }
}
