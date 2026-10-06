package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class IiiiIi_Class30 extends IiiiII_Class29 implements Iterable<Entry<String, IiiiII_Class29>> {
   private final JsonObject I_field_a1a50d2c;

   public IiiiIi_Class30() {
      this(new JsonObject());
   }

   public IiiiIi_Class30(JsonObject var1) {
      super(var1);
      this.I_field_a1a50d2c = var1;
   }

   public JsonObject I_method_6d0d6596() {
      return this.I_field_a1a50d2c;
   }

   public IiiiIi_Class30 I_method_ae7210a4(String var1, @Nullable JsonElement var2) {
      this.I_field_a1a50d2c.add(var1, var2);
      return this;
   }

   public IiiiIi_Class30 I_method_b1b74560(String var1, @Nullable IiiiII_Class29 var2) {
      this.I_field_a1a50d2c.add(var1, var2 == null ? null : var2.I_method_8ac2b365());
      return this;
   }

   public IiiiIi_Class30 I_method_2ea6a899(String var1, boolean var2) {
      this.I_field_a1a50d2c.addProperty(var1, var2);
      return this;
   }

   public IiiiIi_Class30 I_method_c1aedeef(String var1, @Nullable Number var2) {
      this.I_field_a1a50d2c.addProperty(var1, var2);
      return this;
   }

   public IiiiIi_Class30 I_method_7b2379b7(String var1, @Nullable String var2) {
      this.I_field_a1a50d2c.addProperty(var1, var2);
      return this;
   }

   public IiiiIi_Class30 I_method_1fdaa01f(JsonObject var1) {
      var1.asMap().forEach(this.I_field_a1a50d2c::add);
      return this;
   }

   public IiiiIi_Class30 I_method_3ddd98a(IiiiIi_Class30 var1) {
      var1.I_method_6d0d6596().asMap().forEach(this.I_field_a1a50d2c::add);
      return this;
   }

   public IiiiII_Class29 I_method_2f104161(String var1) {
      JsonElement var2 = this.I_field_a1a50d2c.remove(var1);
      return var2 == null ? null : IiiiII_Class29.I_method_f548a31a(var2);
   }

   public IiiiIi_Class30 i_method_efa1d76b() {
      this.I_field_a1a50d2c.asMap().clear();
      return this;
   }

   public boolean I_method_8182a8fa(String var1) {
      return this.I_field_a1a50d2c.has(var1);
   }

   public boolean i_method_5239fcda(String var1) {
      return this.I_field_a1a50d2c.has(var1) && this.I_field_a1a50d2c.get(var1).isJsonObject();
   }

   public boolean II_method_625d143(String var1) {
      return this.I_field_a1a50d2c.has(var1) && this.I_field_a1a50d2c.get(var1).isJsonArray();
   }

   public boolean Ii_method_d6dd2523(String var1) {
      return this.I_field_a1a50d2c.has(var1) && this.I_field_a1a50d2c.get(var1).isJsonPrimitive();
   }

   public boolean iI_method_4c58f963(String var1) {
      return this.I_field_a1a50d2c.has(var1)
         && this.I_field_a1a50d2c.get(var1).isJsonPrimitive()
         && this.I_field_a1a50d2c.get(var1).getAsJsonPrimitive().isBoolean();
   }

   public boolean ii_method_1d104d43(String var1) {
      return this.I_field_a1a50d2c.has(var1)
         && this.I_field_a1a50d2c.get(var1).isJsonPrimitive()
         && this.I_field_a1a50d2c.get(var1).getAsJsonPrimitive().isNumber();
   }

   public boolean III_method_15e7b21a(String var1) {
      return this.I_field_a1a50d2c.has(var1)
         && this.I_field_a1a50d2c.get(var1).isJsonPrimitive()
         && this.I_field_a1a50d2c.get(var1).getAsJsonPrimitive().isString();
   }

   public IiiiII_Class29 i_method_83289181(String var1) {
      return this.I_method_b1b74180(var1, null);
   }

   public IiiiII_Class29 I_method_b1b74180(String var1, @Nullable IiiiII_Class29 var2) {
      return this.I_method_8182a8fa(var1) ? IiiiII_Class29.I_method_f548a31a(this.I_field_a1a50d2c.get(var1)) : var2;
   }

   public Optional<IiiiII_Class29> I_method_47cc620f(String var1) {
      return Optional.ofNullable(this.I_method_b1b74180(var1, null));
   }

   @Nonnull
   public IiiiII_Class29 II_method_3dd1d6f8(String var1) {
      IiiiII_Class29 var2 = this.I_method_b1b74180(var1, null);
      if (var2 == null) {
         throw new NoSuchElementException("No element found for key: " + var1);
      } else {
         return var2;
      }
   }

   public IiiiIi_Class30 I_method_2f104541(String var1) {
      return this.I_method_dbd95d80(var1, null);
   }

   public IiiiIi_Class30 I_method_dbd95d80(String var1, @Nullable IiiiIi_Class30 var2) {
      return this.i_method_5239fcda(var1) ? this.I_method_b1b74180(var1, var2).I_method_9b832f2b() : var2;
   }

   public Optional<IiiiIi_Class30> i_method_dbd1c22f(String var1) {
      return Optional.ofNullable(this.I_method_dbd95d80(var1, null));
   }

   @Nonnull
   public IiiiIi_Class30 i_method_83289561(String var1) {
      IiiiIi_Class30 var2 = this.I_method_dbd95d80(var1, null);
      if (var2 == null) {
         throw new NoSuchElementException("No object found for key: " + var1);
      } else {
         return var2;
      }
   }

   public IiiIii_Class28 I_method_2f023181(String var1) {
      return this.I_method_cbefa580(var1, null);
   }

   public IiiIii_Class28 I_method_cbefa580(String var1, @Nullable IiiIii_Class28 var2) {
      return this.II_method_625d143(var1) ? this.I_method_b1b74180(var1, var2).i_method_c597338b() : var2;
   }

   public Optional<IiiIii_Class28> II_method_18ee5b26(String var1) {
      return Optional.ofNullable(this.I_method_cbefa580(var1, null));
   }

   @Nonnull
   public IiiIii_Class28 i_method_831a81a1(String var1) {
      IiiIii_Class28 var2 = this.I_method_cbefa580(var1, null);
      if (var2 == null) {
         throw new NoSuchElementException("No array found for key: " + var1);
      } else {
         return var2;
      }
   }

   public IiiiiI_Class31 I_method_2f10b981(String var1) {
      return this.I_method_cbd8a580(var1, null);
   }

   public IiiiiI_Class31 I_method_cbd8a580(String var1, @Nullable IiiiiI_Class31 var2) {
      return this.Ii_method_d6dd2523(var1) ? this.I_method_b1b74180(var1, var2).I_method_9b83a36b() : var2;
   }

   public Optional<IiiiiI_Class31> Ii_method_acf3bb46(String var1) {
      return Optional.ofNullable(this.I_method_cbd8a580(var1, null));
   }

   @Nonnull
   public IiiiiI_Class31 i_method_832909a1(String var1) {
      IiiiiI_Class31 var2 = this.I_method_cbd8a580(var1, null);
      if (var2 == null) {
         throw new NoSuchElementException("No primitive found for key: " + var1);
      } else {
         return var2;
      }
   }

   public boolean IIi_method_e69f05fa(String var1) {
      return this.I_method_aed328a2(var1, false);
   }

   public boolean I_method_aed328a2(String var1, boolean var2) {
      return this.iI_method_4c58f963(var1) ? this.I_field_a1a50d2c.get(var1).getAsBoolean() : var2;
   }

   public boolean IiI_method_5c1ada3a(String var1) {
      if (!this.iI_method_4c58f963(var1)) {
         throw new NoSuchElementException("No boolean found for key: " + var1);
      } else {
         return this.IIi_method_e69f05fa(var1);
      }
   }

   public byte I_method_8182a8e2(String var1) {
      return this.I_method_aed2ce72(var1, (byte)0);
   }

   public byte I_method_aed2ce72(String var1, byte var2) {
      return this.ii_method_1d104d43(var1) ? this.I_field_a1a50d2c.get(var1).getAsByte() : var2;
   }

   public byte i_method_5239fcc2(String var1) {
      if (!this.ii_method_1d104d43(var1)) {
         throw new NoSuchElementException("No byte found for key: " + var1);
      } else {
         return this.I_method_8182a8e2(var1);
      }
   }

   public short I_method_8182a8f3(String var1) {
      return this.I_method_aed30e54(var1, (short)0);
   }

   public short I_method_aed30e54(String var1, short var2) {
      return this.ii_method_1d104d43(var1) ? this.I_field_a1a50d2c.get(var1).getAsShort() : var2;
   }

   public short i_method_5239fcd3(String var1) {
      if (!this.ii_method_1d104d43(var1)) {
         throw new NoSuchElementException("No short found for key: " + var1);
      } else {
         return this.I_method_8182a8f3(var1);
      }
   }

   public int I_method_8182a8e9(String var1) {
      return this.I_method_aed2e8c0(var1, 0);
   }

   public int I_method_aed2e8c0(String var1, int var2) {
      return this.ii_method_1d104d43(var1) ? this.I_field_a1a50d2c.get(var1).getAsInt() : var2;
   }

   public OptionalInt I_method_414f37f8(String var1) {
      return this.ii_method_1d104d43(var1) ? OptionalInt.of(this.I_field_a1a50d2c.get(var1).getAsInt()) : OptionalInt.empty();
   }

   public int i_method_5239fcc9(String var1) {
      if (!this.ii_method_1d104d43(var1)) {
         throw new NoSuchElementException("No int found for key: " + var1);
      } else {
         return this.I_method_8182a8e9(var1);
      }
   }

   public long I_method_8182a8ea(String var1) {
      return this.I_method_aed2ec82(var1, 0L);
   }

   public long I_method_aed2ec82(String var1, long var2) {
      return this.ii_method_1d104d43(var1) ? this.I_field_a1a50d2c.get(var1).getAsLong() : var2;
   }

   public OptionalLong I_method_e8c270f3(String var1) {
      return this.ii_method_1d104d43(var1) ? OptionalLong.of(this.I_field_a1a50d2c.get(var1).getAsLong()) : OptionalLong.empty();
   }

   public long i_method_5239fcca(String var1) {
      if (!this.ii_method_1d104d43(var1)) {
         throw new NoSuchElementException("No long found for key: " + var1);
      } else {
         return this.I_method_8182a8ea(var1);
      }
   }

   public float I_method_8182a8e6(String var1) {
      return this.I_method_aed2dd7a(var1, 0.0F);
   }

   public float I_method_aed2dd7a(String var1, float var2) {
      return this.ii_method_1d104d43(var1) ? this.I_field_a1a50d2c.get(var1).getAsFloat() : var2;
   }

   public float i_method_5239fcc6(String var1) {
      if (!this.ii_method_1d104d43(var1)) {
         throw new NoSuchElementException("No float found for key: " + var1);
      } else {
         return this.I_method_8182a8e6(var1);
      }
   }

   public double I_method_8182a8e4(String var1) {
      return this.I_method_aed2d5f6(var1, 0.0);
   }

   public double I_method_aed2d5f6(String var1, double var2) {
      return this.ii_method_1d104d43(var1) ? this.I_field_a1a50d2c.get(var1).getAsDouble() : var2;
   }

   public OptionalDouble I_method_1b19493e(String var1) {
      return this.ii_method_1d104d43(var1) ? OptionalDouble.of(this.I_field_a1a50d2c.get(var1).getAsDouble()) : OptionalDouble.empty();
   }

   public double i_method_5239fcc4(String var1) {
      if (!this.ii_method_1d104d43(var1)) {
         throw new NoSuchElementException("No double found for key: " + var1);
      } else {
         return this.I_method_8182a8e4(var1);
      }
   }

   public Number I_method_55778232(String var1) {
      return this.I_method_82be7660(var1, null);
   }

   public Number I_method_82be7660(String var1, @Nullable Number var2) {
      return this.ii_method_1d104d43(var1) ? this.I_field_a1a50d2c.get(var1).getAsNumber() : var2;
   }

   public Optional<Number> iI_method_594ff06(String var1) {
      return Optional.ofNullable(this.I_method_82be7660(var1, null));
   }

   @Nonnull
   public Number i_method_75966a52(String var1) {
      if (!this.ii_method_1d104d43(var1)) {
         throw new NoSuchElementException("No number found for key: " + var1);
      } else {
         return this.I_method_55778232(var1);
      }
   }

   public String I_method_5c8b966a(String var1) {
      return this.I_method_3264db60(var1, null);
   }

   public String I_method_3264db60(String var1, @Nullable String var2) {
      return this.III_method_15e7b21a(var1) ? this.I_field_a1a50d2c.get(var1).getAsString() : var2;
   }

   public Optional<String> ii_method_999a5f26(String var1) {
      return Optional.ofNullable(this.I_method_3264db60(var1, null));
   }

   @Nonnull
   public String i_method_7caa7e8a(String var1) {
      String var2 = this.I_method_3264db60(var1, null);
      if (var2 == null) {
         throw new NoSuchElementException("No string found for key: " + var1);
      } else {
         return var2;
      }
   }

   public int I_method_2b9d321f() {
      return this.I_field_a1a50d2c.size();
   }

   public boolean I_method_2b9d3230() {
      return this.I_field_a1a50d2c.isEmpty();
   }

   public Set<String> I_method_d708d11b() {
      return this.I_field_a1a50d2c.keySet();
   }

   public Set<Entry<String, IiiiII_Class29>> i_method_694514fb() {
      return this.I_field_a1a50d2c.entrySet().stream().map(IiiiIi_Class30.Nested1_8866bb93::new).collect(Collectors.toSet());
   }

   @Nonnull
   @Override
   public Iterator<Entry<String, IiiiII_Class29>> iterator() {
      return new IiiiIi_Class30.Nested1_8866bb73(this.I_field_a1a50d2c.entrySet().iterator());
   }

   public Stream<Entry<String, IiiiII_Class29>> I_method_60fa9f6e() {
      return StreamSupport.stream(this.spliterator(), false);
   }

   public Map<String, IiiiII_Class29> I_method_d7060761() {
      HashMap var1 = new HashMap();

      for (Entry var3 : this.I_field_a1a50d2c.entrySet()) {
         var1.put(var3.getKey(), IiiiII_Class29.I_method_f548a31a((JsonElement)var3.getValue()));
      }

      return var1;
   }

   public <T> Map<String, T> I_method_2c38d0db(Function<IiiiII_Class29, T> var1) {
      HashMap var2 = new HashMap();

      for (Entry var4 : this.I_field_a1a50d2c.entrySet()) {
         var2.put(var4.getKey(), var1.apply(IiiiII_Class29.I_method_f548a31a((JsonElement)var4.getValue())));
      }

      return var2;
   }

   static class Nested1_8866bb73 implements Iterator<Entry<String, IiiiII_Class29>> {
      private final Iterator<Entry<String, JsonElement>> I_field_adbff361;

      public Nested1_8866bb73(Iterator<Entry<String, JsonElement>> var1) {
         this.I_field_adbff361 = var1;
      }

      @Override
      public boolean hasNext() {
         return this.I_field_adbff361.hasNext();
      }

      @Override
      public Entry<String, IiiiII_Class29> next() {
         return new IiiiIi_Class30.Nested1_8866bb93(this.I_field_adbff361.next());
      }

      @Override
      public void remove() {
         this.I_field_adbff361.remove();
      }
   }

   static class Nested1_8866bb93 implements Entry<String, IiiiII_Class29> {
      private final Entry<String, JsonElement> I_field_2bcef1d;

      public Nested1_8866bb93(Entry<String, JsonElement> var1) {
         this.I_field_2bcef1d = var1;
      }

      @Override
      public String getKey() {
         return this.I_field_2bcef1d.getKey();
      }

      @Override
      public IiiiII_Class29 getValue() {
         return IiiiII_Class29.I_method_f548a31a(this.I_field_2bcef1d.getValue());
      }

      @Override
      public IiiiII_Class29 setValue(IiiiII_Class29 var1) {
         JsonElement var2 = this.I_field_2bcef1d.setValue(var1.I_method_8ac2b365());
         return var2 == null ? null : IiiiII_Class29.I_method_f548a31a(var2);
      }
   }
}
