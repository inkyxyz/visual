package rockstar.client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import lombok.Generated;

public class IIiiIIiiI_Class103 {
   private final List<IIiiIIiii_Class104> I_field_7865b31 = new ArrayList<>();
   private final Set<String> I_field_a56a8dc5 = ConcurrentHashMap.newKeySet();
   private final AtomicInteger I_field_bc9b37c0 = new AtomicInteger();

   public IIiiIIiiI_Class103() {
      IIiiIiIIi_Class106.I_method_fd9ca23f();
      this.II_method_14c48d02();
   }

   void I_method_d760b23f() {
      this.I_field_bc9b37c0.incrementAndGet();
   }

   void i_method_d76f3e1f() {
      this.I_field_bc9b37c0.updateAndGet(var0 -> var0 > 0 ? var0 - 1 : 0);
   }

   public final void I_method_f52ba2c0(IiIIIIIi_Class66 var1) {
      if (this.I_field_bc9b37c0.get() != 0) {
         for (IIiiIIiii_Class104 var3 : this.I_field_7865b31) {
            if (var3.I_method_9ab667af() != null) {
               var3.I_method_9ab667af().fire(var1);
            }
         }
      }
   }

   public final void II_method_14c48d02() {
      this.I_field_7865b31.forEach(IIiiIIiii_Class104::I_method_dfbc623);
      this.I_field_7865b31.clear();
      Path var1 = Paths.get(IiIIiIII_Class73.I_field_3a58077.getPath(), "scripts");
      if (!Files.exists(var1)) {
         try {
            Files.createDirectories(var1);
         } catch (IOException var7) {
            RockstarClient.I_field_ab0f6068
               .error(
                  "\u041d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0441\u043e\u0437\u0434\u0430\u0442\u044c \u0434\u0438\u0440\u0435\u043a\u0442\u043e\u0440\u0438\u044e \u0441\u043a\u0440\u0438\u043f\u0442\u043e\u0432: {}",
                  var7.getMessage()
               );
         }
      } else {
         try (Stream<Path> var2 = Files.list(var1)) {
            var2.filter(var0 -> Files.isRegularFile(var0)).filter(var0 -> ((java.nio.file.Path)var0).getFileName().toString().endsWith(".py")).forEach(var1x -> {
               String var2x = ((java.nio.file.Path)var1x).getFileName().toString();
               this.I_field_7865b31.add(new IIiiIIiii_Class104(var2x.substring(0, var2x.length() - 3)));
            });
         } catch (IOException var9) {
            RockstarClient.I_field_ab0f6068
               .error(
                  "\u041e\u0448\u0438\u0431\u043a\u0430 \u043f\u0440\u0438 \u0441\u043a\u0430\u043d\u0438\u0440\u043e\u0432\u0430\u043d\u0438\u0438 \u0434\u0438\u0440\u0435\u043a\u0442\u043e\u0440\u0438\u0438 \u0441\u043a\u0440\u0438\u043f\u0442\u043e\u0432: {}",
                  var9.getMessage()
               );
         }
      }

      try {
         IIiiIiiiI_Class111 var10 = RockstarClient.getInstance().I_method_aad1a862();
         if (var10 != null) {
            var10.I_method_d8259254().forEach((var1x, var2x) -> this.I_field_7865b31.add(new IIiiIIiii_Class104(var1x, var2x)));
         }
      } catch (Exception var5) {
      }

      this.Ii_method_14d318e2();
   }

   public void I_method_8a6291ab(String var1, boolean var2) {
      String var3 = I_method_fec94577(var1);
      if (!var3.isEmpty()) {
         if (var2) {
            this.I_field_a56a8dc5.add(var3);
         } else {
            this.I_field_a56a8dc5.remove(var3);
         }

         IIiiIIiii_Class104 var4 = this.I_method_7aa2c69f(var1);
         if (var4 != null) {
            if (var2) {
               if (!var4.II_method_b18bf526()) {
                  var4.I_method_dfbc61f();
               }
            } else if (var4.II_method_b18bf526()) {
               var4.I_method_dfbc623();
            }
         }
      }
   }

   public List<String> I_method_ac507a28() {
      return new ArrayList<>(this.I_field_a56a8dc5);
   }

   public void I_method_a36eb6b0(Collection<String> var1) {
      this.I_field_a56a8dc5.clear();
      if (var1 != null) {
         for (String var3 : var1) {
            String var4 = I_method_fec94577(var3);
            if (!var4.isEmpty()) {
               this.I_field_a56a8dc5.add(var4);
            }
         }
      }

      for (IIiiIIiii_Class104 var6 : this.I_field_7865b31) {
         boolean var7 = this.I_field_a56a8dc5.contains(I_method_fec94577(var6.I_method_332d5061()));
         if (var7 && !var6.II_method_b18bf526()) {
            var6.I_method_dfbc61f();
         } else if (!var7 && var6.II_method_b18bf526()) {
            var6.I_method_dfbc623();
         }
      }
   }

   private void Ii_method_14d318e2() {
      if (!this.I_field_a56a8dc5.isEmpty()) {
         for (IIiiIIiii_Class104 var2 : this.I_field_7865b31) {
            if (!var2.II_method_b18bf526() && this.I_field_a56a8dc5.contains(I_method_fec94577(var2.I_method_332d5061()))) {
               var2.I_method_dfbc61f();
            }
         }
      }
   }

   private IIiiIIiii_Class104 I_method_7aa2c69f(String var1) {
      String var2 = I_method_fec94577(var1);

      for (IIiiIIiii_Class104 var4 : this.I_field_7865b31) {
         if (I_method_fec94577(var4.I_method_332d5061()).equals(var2)) {
            return var4;
         }
      }

      return null;
   }

   private static String I_method_fec94577(String var0) {
      return var0 == null ? "" : var0.trim().toLowerCase(Locale.ROOT);
   }

   @Generated
   public List<IIiiIIiii_Class104> i_method_619cb248() {
      return this.I_field_7865b31;
   }
}
