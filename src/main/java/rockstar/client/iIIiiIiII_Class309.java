package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import lombok.Generated;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class iIIiiIiII_Class309<T extends iIIiIiIii_Class300> {
   protected final List<T> I_field_7865b31;

   public iIIiiIiII_Class309(List<T> var1) {
      this.I_field_7865b31 = var1;
   }

   @Nullable
   public T I_method_5d34dd7d(Item var1) {
      return this.I_field_7865b31.stream().filter(var1x -> var1x.I_method_7a83ae0b(var1)).findFirst().orElse(null);
   }

   @Nullable
   public T I_method_77fa4424(Predicate<ItemStack> var1) {
      return this.I_field_7865b31.stream().filter(var1x -> var1x.I_method_ed513c32(var1)).findFirst().orElse(null);
   }

   public List<T> I_method_fe8cb900(Item var1) {
      return this.I_field_7865b31.stream().filter(var1x -> var1x.I_method_7a83ae0b(var1)).toList();
   }

   public List<T> I_method_144f4b9(Predicate<ItemStack> var1) {
      return this.I_field_7865b31.stream().filter(var1x -> var1x.I_method_ed513c32(var1)).toList();
   }

   @Nullable
   public T I_method_2f5a6715() {
      return this.I_field_7865b31.stream().filter(iIIiIiIii_Class300::I_method_dfe89263).findFirst().orElse(null);
   }

   public boolean I_method_c9799e6b(Item var1) {
      return this.I_field_7865b31.stream().anyMatch(var1x -> var1x.I_method_7a83ae0b(var1));
   }

   public int I_method_c9799e5a(Item var1) {
      return this.I_field_7865b31.stream().filter(var1x -> var1x.I_method_7a83ae0b(var1)).mapToInt(var0 -> var0.I_method_7b7e0bb9().getCount()).sum();
   }

   public iIIiiIiII_Class309<iIIiIiIii_Class300> I_method_fdeecb5d(iIIiiIiII_Class309<? extends iIIiIiIii_Class300> var1) {
      ArrayList var2 = new ArrayList(this.I_field_7865b31.size() + var1.I_field_7865b31.size());
      var2.addAll(this.I_field_7865b31);
      var2.addAll(var1.I_field_7865b31);
      return new iIIiiIiII_Class309<>(var2);
   }

   public iIIiiIiII_Class309<iIIiIiIii_Class300> I_method_c19447bd(iIIiIiIii_Class300 var1) {
      ArrayList var2 = new ArrayList<>(this.I_field_7865b31);
      var2.add(var1);
      return new iIIiiIiII_Class309<>(var2);
   }

   @Generated
   public List<T> I_method_617d3e68() {
      return this.I_field_7865b31;
   }
}
