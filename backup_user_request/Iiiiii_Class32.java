package rockstar.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public abstract class Iiiiii_Class32<T extends Iiiiii_Class32<T>> {
   private final Map<String, List<String>> I_field_a567c40b = new HashMap<>();

   public Iiiiii_Class32() {
   }

   public Iiiiii_Class32(Map<String, List<String>> var1) {
      var1.forEach((var1x, var2) -> this.I_field_a567c40b.put(var1x.toLowerCase(Locale.ROOT), new ArrayList<>(var2)));
   }

   public Map<String, List<String>> I_method_6a24b781() {
      return Collections.unmodifiableMap(
         this.I_field_a567c40b.entrySet().stream().collect(Collectors.toMap(Entry::getKey, var0 -> new ArrayList<>(var0.getValue())))
      );
   }

   public List<String> I_method_aa477a71(String var1) {
      return this.I_field_a567c40b.get(var1.toLowerCase());
   }

   public Optional<String> I_method_a5598def(String var1) {
      List var2 = this.I_field_a567c40b.get(var1.toLowerCase(Locale.ROOT));
      return var2 != null && !var2.isEmpty() ? Optional.of((String)var2.get(0)) : Optional.empty();
   }

   public Optional<String> i_method_395eee0f(String var1) {
      List var2 = this.I_field_a567c40b.get(var1.toLowerCase(Locale.ROOT));
      return var2 != null && !var2.isEmpty() ? Optional.of((String)var2.get(var2.size() - 1)) : Optional.empty();
   }

   public T I_method_c114f5b7(String var1, String var2) {
      this.I_field_a567c40b.computeIfAbsent(var1.toLowerCase(Locale.ROOT), var0 -> new ArrayList<>()).add(var2);
      return (T)this;
   }

   public T I_method_e89c702d(iiiIIi_Class58... var1) {
      for (iiiIIi_Class58 var5 : var1) {
         this.I_method_c114f5b7(var5.I_method_6912bb4(), var5.i_method_99afdbd4());
      }

      return (T)this;
   }

   public T I_method_ec4f277a(Collection<iiiIIi_Class58> var1) {
      for (iiiIIi_Class58 var3 : var1) {
         this.I_method_c114f5b7(var3.I_method_6912bb4(), var3.i_method_99afdbd4());
      }

      return (T)this;
   }

   public T i_method_33057dd7(String var1, String var2) {
      ArrayList var3 = new ArrayList();
      var3.add(var2);
      this.I_field_a567c40b.put(var1.toLowerCase(Locale.ROOT), var3);
      return (T)this;
   }

   public T i_method_a3afbc0d(iiiIIi_Class58... var1) {
      for (iiiIIi_Class58 var5 : var1) {
         this.i_method_33057dd7(var5.I_method_6912bb4(), var5.i_method_99afdbd4());
      }

      return (T)this;
   }

   public T i_method_dd82679a(Collection<iiiIIi_Class58> var1) {
      for (iiiIIi_Class58 var3 : var1) {
         this.i_method_33057dd7(var3.I_method_6912bb4(), var3.i_method_99afdbd4());
      }

      return (T)this;
   }

   public T I_method_6864f941(String var1) {
      this.I_field_a567c40b.remove(var1.toLowerCase(Locale.ROOT));
      return (T)this;
   }

   public T I_method_db15ab4b() {
      this.I_field_a567c40b.clear();
      return (T)this;
   }

   public boolean I_method_78c491a(String var1) {
      return this.I_field_a567c40b.containsKey(var1.toLowerCase(Locale.ROOT));
   }

   public boolean I_method_81d59964(String var1, String var2) {
      return this.I_field_a567c40b.get(var1.toLowerCase(Locale.ROOT)).contains(var2);
   }

   public boolean I_method_d7edc731(iiiIIi_Class58 var1) {
      return this.I_method_81d59964(var1.I_method_6912bb4(), var1.i_method_99afdbd4());
   }

   public T I_method_47ffea16(BiConsumer<String, String> var1) {
      for (Entry var3 : this.I_field_a567c40b.entrySet()) {
         for (String var5 : (Iterable<String>)(Iterable<?>)(List)var3.getValue()) {
            var1.accept((String)var3.getKey(), var5);
         }
      }

      return (T)this;
   }
}
