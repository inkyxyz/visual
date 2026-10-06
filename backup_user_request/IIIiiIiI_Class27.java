package rockstar.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import ua.mintantileak.profile.Role;

public class IIIiiIiI_Class27 {
   private final List<String> I_field_7865b31 = new ArrayList<>();
   private String I_field_523beb0a = "";
   private final List<IIIiiiiI_Class31<?>> i_field_7865b31 = new ArrayList<>();
   private final List<IIIiiIIi_Class26> II_field_7865b31 = new ArrayList<>();
   private List<Role> Ii_field_7865b31 = new ArrayList<>();
   private IIIiiiII_Class29 I_field_79cbd761;

   private IIIiiIiI_Class27(String var1) {
      this.I_field_7865b31.add(var1);
   }

   public static IIIiiIiI_Class27 I_method_209cd841(String var0) {
      return new IIIiiIiI_Class27(var0);
   }

   public static IIIiiIiI_Class27 I_method_fa8865f9(String var0, Consumer<IIIiiIiI_Class27> var1) {
      IIIiiIiI_Class27 var2 = new IIIiiIiI_Class27(var0);
      var1.accept(var2);
      return var2;
   }

   public final IIIiiIiI_Class27 I_method_b3f941e4(String... var1) {
      this.I_field_7865b31.addAll(Arrays.asList(var1));
      return this;
   }

   public final IIIiiIiI_Class27 I_method_9449fb2d(IIIiiIIi_Class26... var1) {
      this.II_field_7865b31.addAll(Arrays.asList(var1));
      return this;
   }

   public final IIIiiIiI_Class27 i_method_cfe1a061(String var1) {
      this.I_field_523beb0a = var1;
      return this;
   }

   public final <T> IIIiiIiI_Class27 i_method_3d6e11d9(String var1, Consumer<IIIiiiii_Class32<T>> var2) {
      IIIiiiii_Class32 var3 = IIIiiiii_Class32.I_method_83426041(var1);
      var2.accept(var3);
      this.i_field_7865b31.add(var3.I_method_e930dbeb());
      return this;
   }

   public final IIIiiIiI_Class27 I_method_16f05c8a(IIIiiiII_Class29 var1) {
      this.I_field_79cbd761 = var1;
      return this;
   }

   public final IIIiiIiI_Class27 I_method_7b371d40(Role... var1) {
      this.Ii_field_7865b31 = Arrays.asList(var1);
      return this;
   }

   public final IIIiiIIi_Class26 I_method_9111538b() {
      boolean var1 = true;
      if (this.I_field_79cbd761 == null) {
         throw new IllegalStateException("Executable command requires handler");
      } else {
         return new IIIiiIiI_Class27.Nested1_b9e9b4b3(
            List.copyOf(this.I_field_7865b31),
            this.I_field_523beb0a,
            List.copyOf(this.i_field_7865b31),
            List.copyOf(this.II_field_7865b31),
            List.copyOf(this.Ii_field_7865b31),
            var1,
            this.I_field_79cbd761
         );
      }
   }

   static final class Nested1_b9e9b4b3 implements IIIiiIIi_Class26 {
      private final List<String> I_field_7865b31;
      private final String I_field_523beb0a;
      private final List<IIIiiiiI_Class31<?>> i_field_7865b31;
      private final List<IIIiiIIi_Class26> II_field_7865b31;
      private final List<Role> Ii_field_7865b31;
      private final boolean I_field_5a;
      private final IIIiiiII_Class29 I_field_79cbd761;

      Nested1_b9e9b4b3(
         List<String> var1, String var2, List<IIIiiiiI_Class31<?>> var3, List<IIIiiIIi_Class26> var4, List<Role> var5, boolean var6, IIIiiiII_Class29 var7
      ) {
         this.I_field_7865b31 = var1;
         this.I_field_523beb0a = var2;
         this.i_field_7865b31 = var3;
         this.II_field_7865b31 = var4;
         this.Ii_field_7865b31 = var5;
         this.I_field_5a = var6;
         this.I_field_79cbd761 = var7;
      }

      @Override
      public final String toString() {
         return "Nested1_b9e9b4b3[names=" + this.I_field_7865b31 + ", description=" + this.I_field_523beb0a + ", parameters=" + this.i_field_7865b31 + ", subcommands=" + this.II_field_7865b31 + ", roles=" + this.Ii_field_7865b31 + ", executable=" + this.I_field_5a + ", handler=" + this.I_field_79cbd761 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_7865b31);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_7865b31);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_7865b31);
         result = 31 * result + java.util.Objects.hashCode(this.Ii_field_7865b31);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_79cbd761);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IIIiiIiI_Class27.Nested1_b9e9b4b3 other = (IIIiiIiI_Class27.Nested1_b9e9b4b3) var1;
         return java.util.Objects.equals(this.I_field_7865b31, other.I_field_7865b31)
            && java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.i_field_7865b31, other.i_field_7865b31)
            && java.util.Objects.equals(this.II_field_7865b31, other.II_field_7865b31)
            && java.util.Objects.equals(this.Ii_field_7865b31, other.Ii_field_7865b31)
            && java.util.Objects.equals(this.I_field_5a, other.I_field_5a)
            && java.util.Objects.equals(this.I_field_79cbd761, other.I_field_79cbd761);
      }

      @Override
      public List<String> I_method_84c7081b() {
         return this.I_field_7865b31;
      }

      @Override
      public String I_method_82050574() {
         return this.I_field_523beb0a;
      }

      @Override
      public List<IIIiiiiI_Class31<?>> i_method_3a13403b() {
         return this.i_field_7865b31;
      }

      @Override
      public List<IIIiiIIi_Class26> II_method_dbf49172() {
         return this.II_field_7865b31;
      }

      @Override
      public List<Role> Ii_method_9140c992() {
         return this.Ii_field_7865b31;
      }

      @Override
      public boolean I_method_7dfc5cb0() {
         return this.I_field_5a;
      }

      @Override
      public IIIiiiII_Class29 I_method_2830e7cb() {
         return this.I_field_79cbd761;
      }
   }
}
