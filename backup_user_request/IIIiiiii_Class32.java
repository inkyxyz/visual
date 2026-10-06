package rockstar.client;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IIIiiiii_Class32<T> {
   private final String I_field_523beb0a;
   private boolean I_field_5a = true;
   private boolean i_field_5a = false;
   private IIiIIIII_Class33 i_field_de26afa1 = IIiIIIIi_Class34::I_method_12fc454a;
   private List<String> I_field_7865b31;
   public static final IIiIIIII_Class33 I_field_de26afa1 = var0 -> {
      try {
         ModuleEntry var1 = RockstarClient.getInstance().getModuleManager().getModuleByName(var0);
         return (IIiIIIIi_Class34)(!var1.isAvailable()
            ? IIiIIIIi_Class34.I_method_c9d442bc("Module with name '%s' was not found".formatted(var0))
            : IIiIIIIi_Class34.I_method_12fc454a(var1));
      } catch (iiIIiIiI_Class203 var2) {
         return IIiIIIIi_Class34.I_method_c9d442bc("Module with name '%s' was not found".formatted(var0));
      }
   };

   private IIIiiiii_Class32(String var1) {
      this.I_field_523beb0a = var1;
   }

   public static <T> IIIiiiii_Class32<T> I_method_83426041(String var0) {
      return new IIIiiiii_Class32<>(var0);
   }

   public final IIIiiiii_Class32<T> I_method_e930dfcb() {
      this.I_field_5a = false;
      return this;
   }

   public final IIIiiiii_Class32<T> i_method_132d6feb() {
      this.i_field_5a = true;
      return this;
   }

   public final IIIiiiii_Class32<T> I_method_2619a44a(IIiIIIII_Class33 var1) {
      this.i_field_de26afa1 = var1;
      return this;
   }

   public final void I_method_f005ecf3(String... var1) {
      if (var1 != null && var1.length != 0) {
         this.I_field_7865b31 = List.of(var1);
      } else {
         this.I_field_7865b31 = List.of();
      }
   }

   public final void I_method_b539159d(List<String> var1) {
      this.I_field_7865b31 = var1 == null ? List.of() : List.copyOf(var1);
   }

   public IIIiiiii_Class32<T> I_method_a44fe164(final String... var1) {
      final String var2 = Arrays.stream(var1).map(var0 -> "'" + var0 + "'").collect(Collectors.joining(", "));
      this.i_field_de26afa1 = new IIiIIIII_Class33() {
         @Override
         public IIiIIIIi_Class34 validate(String var1x) {
            for (String var5 : var1) {
               if (var5.equalsIgnoreCase(var1x)) {
                  return IIiIIIIi_Class34.I_method_12fc454a(var1x);
               }
            }

            return IIiIIIIi_Class34.I_method_c9d442bc("Expected one of: " + var2);
         }

         @Override
         public List<String> suggestions(String var1x) {
            return Arrays.stream(var1).filter(var1xxx -> var1xxx.toLowerCase().startsWith(var1x.toLowerCase())).toList();
         }
      };
      this.I_field_7865b31 = List.of(var1);
      return this;
   }

   public final IIIiiiiI_Class31<T> I_method_e930dbeb() {
      IIiIIIII_Class33 var1 = this.i_field_de26afa1 != null ? this.i_field_de26afa1 : IIiIIIIi_Class34::I_method_12fc454a;
      if (this.I_field_7865b31 != null && !this.I_field_7865b31.isEmpty()) {
         var1 = new IIIiiiii_Class32.Nested1_bbad1cf3(var1, this.I_field_7865b31);
      }

      return new IIIiiiiI_Class31<>(this.I_field_523beb0a, this.I_field_5a, this.i_field_5a, var1);
   }

   static final class Nested1_bbad1cf3 implements IIiIIIII_Class33 {
      private final IIiIIIII_Class33 I_field_de26afa1;
      private final List<String> I_field_7865b31;

      Nested1_bbad1cf3(IIiIIIII_Class33 var1, List<String> var2) {
         this.I_field_de26afa1 = var1;
         this.I_field_7865b31 = var2;
      }

      @Override
      public final IIiIIIIi_Class34 validate(String var1) {
         return this.I_field_de26afa1.validate(var1);
      }

      @Override
      public final List<String> suggestions(String var1) {
         String var2 = var1.toLowerCase();
         return this.I_field_7865b31.stream().filter(var1x -> var1x.toLowerCase().startsWith(var2)).toList();
      }
   }
}
