package rockstar.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class IiiIii_Class28 extends IiiiII_Class29 implements Iterable<IiiiII_Class29> {
   private final JsonArray I_field_6fe46b2;

   public IiiIii_Class28() {
      this(new JsonArray());
   }

   public IiiIii_Class28(JsonArray var1) {
      super(var1);
      this.I_field_6fe46b2 = var1;
   }

   public JsonArray I_method_3d533548() {
      return this.I_field_6fe46b2;
   }

   public IiiIii_Class28 I_method_e91da35a(@Nullable JsonElement var1) {
      this.I_field_6fe46b2.add(var1);
      return this;
   }

   public IiiIii_Class28 I_method_f292d96a(@Nullable IiiiII_Class29 var1) {
      this.I_field_6fe46b2.add(var1 == null ? null : var1.I_method_8ac2b365());
      return this;
   }

   public IiiIii_Class28 I_method_fd29684f(boolean var1) {
      this.I_field_6fe46b2.add(var1);
      return this;
   }

   public IiiIii_Class28 I_method_bdae9279(@Nullable Number var1) {
      this.I_field_6fe46b2.add(var1);
      return this;
   }

   public IiiIii_Class28 I_method_77232d41(@Nullable String var1) {
      this.I_field_6fe46b2.add(var1);
      return this;
   }

   public IiiIii_Class28 I_method_4ee47c37(JsonArray var1) {
      this.I_field_6fe46b2.addAll(var1);
      return this;
   }

   public IiiIii_Class28 I_method_cd94d4a(IiiIii_Class28 var1) {
      this.I_field_6fe46b2.addAll(var1.I_method_3d533548());
      return this;
   }

   public IiiiII_Class29 I_method_fe370765(int var1, JsonElement var2) {
      JsonElement var3 = this.I_field_6fe46b2.set(var1, var2);
      return var3 == null ? null : IiiiII_Class29.I_method_f548a31a(var3);
   }

   public IiiiII_Class29 I_method_bdb6663f(int var1, IiiiII_Class29 var2) {
      JsonElement var3 = this.I_field_6fe46b2.set(var1, var2.I_method_8ac2b365());
      return var3 == null ? null : IiiiII_Class29.I_method_f548a31a(var3);
   }

   public IiiiII_Class29 I_method_57042ada(int var1, boolean var2) {
      JsonElement var3 = this.I_field_6fe46b2.set(var1, new JsonPrimitive(var2));
      return var3 == null ? null : IiiiII_Class29.I_method_f548a31a(var3);
   }

   public IiiiII_Class29 I_method_721c3b0e(int var1, Number var2) {
      JsonElement var3 = this.I_field_6fe46b2.set(var1, new JsonPrimitive(var2));
      return var3 == null ? null : IiiiII_Class29.I_method_f548a31a(var3);
   }

   public IiiiII_Class29 I_method_2b90d5d6(int var1, String var2) {
      JsonElement var3 = this.I_field_6fe46b2.set(var1, new JsonPrimitive(var2));
      return var3 == null ? null : IiiiII_Class29.I_method_f548a31a(var3);
   }

   public IiiiII_Class29 I_method_ddc8f320(int var1) {
      return IiiiII_Class29.I_method_f548a31a(this.I_field_6fe46b2.get(var1));
   }

   public IiiiIi_Class30 I_method_ddc8f700(int var1) {
      return this.I_method_ddc8f320(var1).I_method_9b832f2b();
   }

   public IiiIii_Class28 I_method_ddbae340(int var1) {
      return this.I_method_ddc8f320(var1).i_method_c597338b();
   }

   public IiiiiI_Class31 I_method_ddc96b40(int var1) {
      return this.I_method_ddc8f320(var1).I_method_9b83a36b();
   }

   public boolean I_method_bba1421b(int var1) {
      return this.I_method_ddc8f320(var1).ii_method_ad221e99();
   }

   public byte I_method_bba14203(int var1) {
      return this.I_method_ddc8f320(var1).I_method_f5021e38();
   }

   public short I_method_bba14214(int var1) {
      return this.I_method_ddc8f320(var1).I_method_f5021e49();
   }

   public int I_method_bba1420a(int var1) {
      return this.I_method_ddc8f320(var1).i_method_f510aa1f();
   }

   public long I_method_bba1420b(int var1) {
      return this.I_method_ddc8f320(var1).I_method_f5021e40();
   }

   public float I_method_bba14207(int var1) {
      return this.I_method_ddc8f320(var1).I_method_f5021e3c();
   }

   public double I_method_bba14205(int var1) {
      return this.I_method_ddc8f320(var1).I_method_f5021e3a();
   }

   public Number I_method_620c2f31(int var1) {
      return this.I_method_ddc8f320(var1).I_method_2532a39c();
   }

   public String I_method_69204369(int var1) {
      return this.I_method_ddc8f320(var1).I_method_2c46b7d4();
   }

   public IiiiII_Class29 i_method_f7e9df00(int var1) {
      JsonElement var2 = this.I_field_6fe46b2.remove(var1);
      return var2 == null ? null : IiiiII_Class29.I_method_f548a31a(var2);
   }

   public boolean I_method_f55a1741(@Nullable JsonElement var1) {
      return this.I_field_6fe46b2.remove((JsonElement)(var1 == null ? JsonNull.INSTANCE : var1));
   }

   public boolean I_method_7fe47331(@Nullable IiiiII_Class29 var1) {
      return this.I_field_6fe46b2.remove((JsonElement)(var1 == null ? JsonNull.INSTANCE : var1.I_method_8ac2b365()));
   }

   public boolean I_method_bba181ec(boolean var1) {
      return this.I_method_f55a1741(new JsonPrimitive(var1));
   }

   public boolean I_method_3a01ff02(Number var1) {
      return this.I_method_f55a1741(new JsonPrimitive(var1));
   }

   public boolean I_method_cc61e53a(String var1) {
      return this.I_method_f55a1741(new JsonPrimitive(var1));
   }

   public boolean I_method_3704b304(JsonArray var1) {
      boolean var2 = false;

      for (JsonElement var4 : var1) {
         var2 |= this.I_field_6fe46b2.remove(var4);
      }

      return var2;
   }

   public boolean I_method_4b1adb51(IiiIii_Class28 var1) {
      return this.I_method_3704b304(var1.I_method_3d533548());
   }

   public IiiIii_Class28 I_method_3dee174b() {
      while (!this.I_field_6fe46b2.isEmpty()) {
         this.I_field_6fe46b2.remove(0);
      }

      return this;
   }

   public boolean i_method_bd64323b(int var1) {
      return var1 >= 0 && var1 < this.I_field_6fe46b2.size();
   }

   public boolean i_method_b0519761(@Nullable JsonElement var1) {
      return this.I_field_6fe46b2.contains((JsonElement)(var1 == null ? JsonNull.INSTANCE : var1));
   }

   public boolean i_method_9a055f11(@Nullable IiiiII_Class29 var1) {
      return this.I_field_6fe46b2.contains((JsonElement)(var1 == null ? JsonNull.INSTANCE : var1.I_method_8ac2b365()));
   }

   public int I_method_cc3efe5f() {
      return this.I_field_6fe46b2.size();
   }

   public boolean I_method_cc3efe70() {
      return this.I_field_6fe46b2.isEmpty();
   }

   @Nonnull
   @Override
   public Iterator<IiiiII_Class29> iterator() {
      return new IiiIii_Class28.Nested1_86b25733(this.I_field_6fe46b2.iterator());
   }

   public Stream<IiiiII_Class29> I_method_f80babae() {
      return StreamSupport.stream(this.spliterator(), false);
   }

   public List<IiiiII_Class29> I_method_9434ae5b() {
      ArrayList var1 = new ArrayList();

      for (JsonElement var3 : this.I_field_6fe46b2) {
         var1.add(IiiiII_Class29.I_method_f548a31a(var3));
      }

      return var1;
   }

   public <T> List<T> I_method_112754a1(Function<IiiiII_Class29, T> var1) {
      ArrayList var2 = new ArrayList();

      for (JsonElement var4 : this.I_field_6fe46b2) {
         var2.add(var1.apply(IiiiII_Class29.I_method_f548a31a(var4)));
      }

      return var2;
   }

   static class Nested1_86b25733 implements Iterator<IiiiII_Class29> {
      private final Iterator<JsonElement> I_field_adbff361;

      public Nested1_86b25733(Iterator<JsonElement> var1) {
         this.I_field_adbff361 = var1;
      }

      @Override
      public boolean hasNext() {
         return this.I_field_adbff361.hasNext();
      }

      @Override
      public IiiiII_Class29 next() {
         return IiiiII_Class29.I_method_f548a31a(this.I_field_adbff361.next());
      }

      @Override
      public void remove() {
         this.I_field_adbff361.remove();
      }
   }
}
