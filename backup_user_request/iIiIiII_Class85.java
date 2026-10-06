package rockstar.client;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import lombok.Generated;
import lombok.SneakyThrows;
import org.jetbrains.annotations.ApiStatus.Internal;

public class iIiIiII_Class85<T extends iIIiiiI_Class79> {
   private final iIiiIII_Class89 I_field_261b57cc = new iIiiIII_Class89();
   private final iIiIiIi_Class86<T> I_field_2466f76c;
   private final Object I_field_5f790d9c;
   private T I_field_ef8f47ec;

   public iIiIiII_Class85(iIiIiIi_Class86<T> var1) {
      this(var1, new Object());
   }

   public iIiIiII_Class85(iIiIiIi_Class86<T> var1, Object var2) {
      this.I_field_2466f76c = var1;
      this.I_field_5f790d9c = var2;
   }

   public T I_method_72256cd5() {
      return this.I_field_ef8f47ec;
   }

   public boolean I_method_a51d1043() {
      return this.I_field_ef8f47ec != null;
   }

   public boolean i_method_a52b9c23() {
      return this.I_field_ef8f47ec == null || this.I_field_ef8f47ec.I_method_414434a3();
   }

   public T i_method_8c4658b5() throws IOException {
      this.II_method_fe93ef06();
      return this.I_field_ef8f47ec;
   }

   @SneakyThrows(IOException.class)
   public T II_method_dd2cf298() {
      return this.i_method_8c4658b5();
   }

   public CompletableFuture<T> I_method_c8070b55() {
      return CompletableFuture.supplyAsync(this::II_method_dd2cf298);
   }

   public boolean II_method_fe93ef06() throws IOException {
      synchronized (this.I_field_5f790d9c) {
         if (this.i_method_a52b9c23()) {
            this.Ii_method_f74dde78();
            return true;
         } else {
            return false;
         }
      }
   }

   @SneakyThrows(IOException.class)
   public boolean Ii_method_fea27ae6() {
      return this.II_method_fe93ef06();
   }

   public CompletableFuture<Boolean> i_method_7034e375() {
      return CompletableFuture.supplyAsync(this::Ii_method_fea27ae6);
   }

   public T Ii_method_f74dde78() throws IOException {
      synchronized (this.I_field_5f790d9c) {
         this.I_method_eb0fcb87(this.I_field_2466f76c.get());
         return this.I_field_ef8f47ec;
      }
   }

   @SneakyThrows(IOException.class)
   public T iI_method_72982b8() {
      return this.Ii_method_f74dde78();
   }

   public CompletableFuture<T> II_method_a880e732() {
      return CompletableFuture.supplyAsync(this::iI_method_72982b8);
   }

   @Internal
   public void I_method_eb0fcb87(T var1) {
      synchronized (this.I_field_5f790d9c) {
         iIIiiiI_Class79 var3 = this.I_field_ef8f47ec;
         this.I_field_ef8f47ec = (T)var1;
         this.I_field_261b57cc.I_method_f42361b7(var3, var1);
      }
   }

   @Generated
   public iIiiIII_Class89 I_method_a8b17cb5() {
      return this.I_field_261b57cc;
   }
}
