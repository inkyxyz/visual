package rockstar.client;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.text.Text;

public class IiIIIIiii_Class136 {
   public static final String I_field_523beb0a = "MODER";
   public static final int I_field_49 = 16;
   private final Set<IiIIIIiii_Class136.Nested1_739d8c40> I_field_a56a8dc5 = new LinkedHashSet<>();

   public final void I_method_7460d3d3(String var1, String var2) {
      if (var1 != null && !var1.isBlank()) {
         String var3 = var1.trim();
         if (I_method_34c44a3c(var3) > 16) {
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.staff.name_too_long", 16)));
         } else {
            String var4 = var2 != null && !var2.isBlank() ? var2.trim() : "MODER";
            if (I_method_34c44a3c(var4) > 16) {
               iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.staff.prefix_too_long", 16)));
            } else {
               IiIIIIiii_Class136.Nested1_739d8c40 var5 = new IiIIIIiii_Class136.Nested1_739d8c40(var3, var4);
               if (this.I_field_a56a8dc5.stream().anyMatch(var1x -> var1x.I_method_13877866().equalsIgnoreCase(var3))) {
                  iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.staff.exists", var3)));
               } else {
                  this.I_field_a56a8dc5.add(var5);
                  iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.staff.added", var4, var3)));
                  this.i_method_4ba01e1f();
               }
            }
         }
      } else {
         iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.staff.empty_name")));
      }
   }

   public final void I_method_34c44a49(String var1) {
      if (var1 != null && !var1.isBlank()) {
         String var2 = var1.trim();
         boolean var3 = this.I_field_a56a8dc5.removeIf(var1x -> var1x.I_method_13877866().equalsIgnoreCase(var2));
         if (var3) {
            iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.staff.removed", var2)));
            this.i_method_4ba01e1f();
         } else {
            iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.staff.not_exists", var2)));
         }
      } else {
         iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.staff.empty_name")));
      }
   }

   public final void I_method_4b91923f() {
      if (this.I_field_a56a8dc5.isEmpty()) {
         iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.staff.empty")));
      } else {
         this.I_field_a56a8dc5.clear();
         iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.staff.cleared")));
         this.i_method_4ba01e1f();
      }
   }

   public final void I_method_39b796b0(Collection<IiIIIIiii_Class136.Nested1_739d8c40> var1) {
      this.I_field_a56a8dc5.clear();
      if (var1 != null) {
         for (IiIIIIiii_Class136.Nested1_739d8c40 var3 : var1) {
            if (var3 != null && !var3.I_method_13877866().isBlank()) {
               this.I_field_a56a8dc5.add(var3);
            }
         }
      }
   }

   public final List<IiIIIIiii_Class136.Nested1_739d8c40> I_method_f4439a28() {
      return List.copyOf(this.I_field_a56a8dc5);
   }

   public final void i_method_74e1fa90(Collection<IiIIIIiii_Class136.Nested1_739d8c40> var1) {
      this.I_field_a56a8dc5.clear();
      if (var1 != null) {
         for (IiIIIIiii_Class136.Nested1_739d8c40 var3 : var1) {
            if (var3 != null
               && !var3.I_method_13877866().isBlank()
               && I_method_34c44a3c(var3.I_method_13877866()) <= 16
               && I_method_34c44a3c(var3.i_method_a6a62886()) <= 16
               && !this.I_field_a56a8dc5.stream().anyMatch(var1x -> var1x.I_method_13877866().equalsIgnoreCase(var3.I_method_13877866()))) {
               this.I_field_a56a8dc5.add(new IiIIIIiii_Class136.Nested1_739d8c40(var3.I_method_13877866(), var3.i_method_a6a62886()));
            }
         }
      }
   }

   private static int I_method_34c44a3c(String var0) {
      return var0.codePointCount(0, var0.length());
   }

   private void i_method_4ba01e1f() {
      if (RockstarClient.getInstance().I_method_7a4c3f0b() != null) {
         RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("staff");
         RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
      }
   }

   public static final class Nested1_739d8c40 {
      private final String I_field_523beb0a;
      private final String i_field_523beb0a;

      public Nested1_739d8c40(String var1, String var2) {
         var1 = var1 == null ? "" : var1.trim();
         var2 = var2 != null && !var2.isBlank() ? var2.trim() : "MODER";
         this.I_field_523beb0a = var1;
         this.i_field_523beb0a = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_739d8c40[name=" + this.I_field_523beb0a + ", prefix=" + this.i_field_523beb0a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_523beb0a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiIIIIiii_Class136.Nested1_739d8c40 other = (IiIIIIiii_Class136.Nested1_739d8c40) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.i_field_523beb0a, other.i_field_523beb0a);
      }

      public String I_method_13877866() {
         return this.I_field_523beb0a;
      }

      public String i_method_a6a62886() {
         return this.i_field_523beb0a;
      }
   }
}
