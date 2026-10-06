package rockstar.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BooleanSupplier;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;
import lombok.Generated;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class RegistryListSetting extends AbstractSetting {
   private final List<RegistryListSetting.Nested1_be9d460> I_field_7865b31 = new ArrayList<>();
   private final Map<Identifier, RegistryListSetting.Nested1_be9d460> I_field_a567c40b = new ConcurrentHashMap<>();
   private final LinkedHashSet<Identifier> I_field_9573462c = new LinkedHashSet<>();
   private final List<RegistryListSetting.Nested1_be9d460> i_field_7865b31 = new ArrayList<>();
   private String i_field_523beb0a = "";
   private String II_field_523beb0a = "";
   private Set<Identifier> I_field_a56a8dc5 = null;
   private final Map<Identifier, Item> i_field_a567c40b = new LinkedHashMap<>();
   private boolean I_field_5a;
   private Predicate<Block> I_field_93e25d0f = null;

   public RegistryListSetting(@NotNull IIiiiIIiI_Class115 var1, String var2, String var3, @NotNull BooleanSupplier var4) {
      super(var1, var2, var4);
      this.i_method_609d61ff();
   }

   public RegistryListSetting(@NotNull IIiiiIIiI_Class115 var1, String var2, @NotNull BooleanSupplier var3) {
      super(var1, var2, var3);
      this.i_method_609d61ff();
   }

   public RegistryListSetting(@NotNull IIiiiIIiI_Class115 var1, String var2, String var3) {
      super(var1, var2);
      this.i_method_609d61ff();
   }

   public RegistryListSetting(@NotNull IIiiiIIiI_Class115 var1, String var2) {
      super(var1, var2);
      this.i_method_609d61ff();
   }

   public RegistryListSetting I_method_3d51a98a(Block... var1) {
      if (var1 != null && var1.length != 0) {
         this.I_field_a56a8dc5 = Arrays.stream(var1).<Identifier>map(Registries.BLOCK::getId).collect(Collectors.toCollection(LinkedHashSet::new));
      } else {
         this.I_field_a56a8dc5 = null;
      }

      this.I_field_93e25d0f = null;
      this.i_method_609d61ff();
      return this;
   }

   public RegistryListSetting I_method_37c6804(Predicate<Block> var1) {
      this.I_field_93e25d0f = var1;
      this.I_field_a56a8dc5 = null;
      this.i_method_609d61ff();
      return this;
   }

   public RegistryListSetting I_method_56228361(Block var1) {
      if (var1 == null) {
         return this;
      } else {
         if (this.I_field_a56a8dc5 == null) {
            this.I_field_a56a8dc5 = new LinkedHashSet<>();
         }

         this.I_field_a56a8dc5.add(Registries.BLOCK.getId(var1));
         this.I_field_93e25d0f = null;
         this.i_method_609d61ff();
         return this;
      }
   }

   public RegistryListSetting I_method_5cb76d1d(Item var1) {
      if (var1 == null) {
         return this;
      } else {
         this.i_field_a567c40b.put(Registries.ITEM.getId(var1), var1);
         this.i_method_609d61ff();
         return this;
      }
   }

   public RegistryListSetting I_method_d8c582f5() {
      this.I_field_5a = true;
      this.i_method_609d61ff();
      return this;
   }

   private void i_method_609d61ff() {
      this.I_field_7865b31.clear();
      this.I_field_a567c40b.clear();

      for (Block var2 : Registries.BLOCK) {
         Identifier var3 = Registries.BLOCK.getId(var2);
         if ((this.I_field_a56a8dc5 == null || this.I_field_a56a8dc5.contains(var3)) && (this.I_field_93e25d0f == null || this.I_field_93e25d0f.test(var2))) {
            RegistryListSetting.Nested1_be9d460 var4 = RegistryListSetting.Nested1_be9d460.I_method_70f94641(var2);
            if (var4 != null) {
               this.I_field_7865b31.add(var4);
               this.I_field_a567c40b.put(var4.I_method_22893129(), var4);
            }
         }
      }

      for (Item var7 : this.I_field_5a ? Registries.ITEM : this.i_field_a567c40b.values()) {
         RegistryListSetting.Nested1_be9d460 var8 = RegistryListSetting.Nested1_be9d460.I_method_21a2863d(var7);
         if (var8 != null && !this.I_field_a567c40b.containsKey(var8.I_method_22893129())) {
            this.I_field_7865b31.add(var8);
            this.I_field_a567c40b.put(var8.I_method_22893129(), var8);
         }
      }

      this.I_field_7865b31.sort(Comparator.comparing(RegistryListSetting.Nested1_be9d460::I_method_6420e886, String.CASE_INSENSITIVE_ORDER));
      this.I_field_9573462c.retainAll(this.I_field_a567c40b.keySet());
      this.II_method_b15ae522();
   }

   public final void I_method_712c5629(String var1) {
      String var2 = var1 == null ? "" : var1;
      if (!Objects.equals(this.i_field_523beb0a, var2)) {
         this.i_field_523beb0a = var2;
         this.II_field_523beb0a = var2.trim().toLowerCase(Locale.ROOT);
         this.II_method_b15ae522();
      }
   }

   public final List<RegistryListSetting.Nested1_be9d460> I_method_325a1a48() {
      this.II_method_b15ae522();
      return Collections.unmodifiableList(this.i_field_7865b31);
   }

   private void II_method_b15ae522() {
      this.i_field_7865b31.clear();
      if (this.II_field_523beb0a.isEmpty()) {
         this.i_field_7865b31.addAll(this.I_field_7865b31);
      } else {
         for (RegistryListSetting.Nested1_be9d460 var2 : this.I_field_7865b31) {
            if (var2.I_method_6420e886().toLowerCase(Locale.ROOT).contains(this.II_field_523beb0a)
               || var2.I_method_22893129().toString().toLowerCase(Locale.ROOT).contains(this.II_field_523beb0a)) {
               this.i_field_7865b31.add(var2);
            }
         }
      }

      this.i_field_7865b31.sort(Comparator.comparing(var1 -> !this.I_method_40659e26(var1)));
   }

   public final void I_method_40659e22(RegistryListSetting.Nested1_be9d460 var1) {
      if (var1 != null) {
         Identifier var2 = var1.I_method_22893129();
         if (this.I_field_a567c40b.containsKey(var2)) {
            this.notifyChanged();
            if (!this.I_field_9573462c.remove(var2)) {
               this.I_field_9573462c.add(var2);
            }
         }
      }
   }

   public final void I_method_bcc5858b(Block var1) {
      if (var1 != null) {
         Identifier var2 = Registries.BLOCK.getId(var1);
         if (this.I_field_a567c40b.containsKey(var2)) {
            this.notifyChanged();
            if (!this.I_field_9573462c.remove(var2)) {
               this.I_field_9573462c.add(var2);
            }
         }
      }
   }

   public final RegistryListSetting i_method_8a3a381(Block var1) {
      if (var1 == null) {
         return this;
      } else {
         Identifier var2 = Registries.BLOCK.getId(var1);
         if (this.I_field_a567c40b.containsKey(var2)) {
            if (this.I_field_9573462c.contains(var2)) {
               return this;
            }

            this.notifyChanged();
            this.I_field_9573462c.add(var2);
         }

         return this;
      }
   }

   public final RegistryListSetting I_method_568307b6(Identifier var1) {
      if (var1 != null && this.I_field_a567c40b.containsKey(var1)) {
         if (this.I_field_9573462c.contains(var1)) {
            return this;
         }

         this.notifyChanged();
         this.I_field_9573462c.add(var1);
      }

      return this;
   }

   public final boolean I_method_40659e26(RegistryListSetting.Nested1_be9d460 var1) {
      return var1 != null && this.I_field_9573462c.contains(var1.I_method_22893129());
   }

   public final boolean I_method_bcc5858f(Block var1) {
      return var1 == null ? false : this.I_field_9573462c.contains(Registries.BLOCK.getId(var1));
   }

   public final boolean I_method_c9a44a24(Identifier var1) {
      return var1 != null && this.I_field_9573462c.contains(var1);
   }

   public final Set<Identifier> I_method_12270fce() {
      return Collections.unmodifiableSet(this.I_field_9573462c);
   }

   public final List<RegistryListSetting.Nested1_be9d460> i_method_e7a65268() {
      return this.I_field_9573462c.stream().map(this.I_field_a567c40b::get).filter(Objects::nonNull).collect(Collectors.toList());
   }

   public final Set<Block> i_method_a46353ae() {
      return this.I_field_9573462c
         .stream()
         .map(this.I_field_a567c40b::get)
         .filter(var0 -> var0 != null && var0.I_method_8ffd8654() != null)
         .map(RegistryListSetting.Nested1_be9d460::I_method_8ffd8654)
         .collect(Collectors.toCollection(LinkedHashSet::new));
   }

   public final Set<Item> II_method_f6bf1d91() {
      return this.I_field_9573462c
         .stream()
         .map(this.I_field_a567c40b::get)
         .filter(Objects::nonNull)
         .map(RegistryListSetting.Nested1_be9d460::I_method_dc0bcf90)
         .filter(Objects::nonNull)
         .collect(Collectors.toCollection(LinkedHashSet::new));
   }

   public final int I_method_608ed612() {
      return this.I_field_9573462c.size();
   }

   @Override
   public final JsonElement toJson() {
      JsonArray var1 = new JsonArray();

      for (Identifier var3 : this.I_field_9573462c) {
         var1.add(new JsonPrimitive(var3.toString()));
      }

      return var1;
   }

   @Override
   public final void fromJson(JsonElement var1) {
      if (var1 != null) {
         if (var1.isJsonArray()) {
            for (JsonElement var3 : var1.getAsJsonArray()) {
               if (!var3.isJsonPrimitive() || !var3.getAsJsonPrimitive().isString()) {
                  return;
               }
            }
         } else if (!var1.isJsonPrimitive() || !var1.getAsJsonPrimitive().isString()) {
            return;
         }

         this.I_field_9573462c.clear();
         if (var1.isJsonArray()) {
            for (JsonElement var4 : var1.getAsJsonArray()) {
               this.i_method_41e3aa09(var4.getAsString());
            }
         } else if (var1.isJsonPrimitive()) {
            this.i_method_41e3aa09(var1.getAsString());
         }
      }
   }

   @Override
   public boolean isValidJson(JsonElement var1) {
      if (var1 == null) {
         return false;
      } else if (var1.isJsonPrimitive()) {
         return this.i_method_f41208e(var1);
      } else if (!var1.isJsonArray()) {
         return false;
      } else {
         for (JsonElement var3 : var1.getAsJsonArray()) {
            if (!this.i_method_f41208e(var3)) {
               return false;
            }
         }

         return true;
      }
   }

   private boolean i_method_f41208e(JsonElement var1) {
      if (var1.isJsonPrimitive() && var1.getAsJsonPrimitive().isString()) {
         Identifier var2 = Identifier.tryParse(var1.getAsString());
         return var2 != null && this.I_field_a567c40b.containsKey(var2);
      } else {
         return false;
      }
   }

   private void i_method_41e3aa09(String var1) {
      Identifier var2 = Identifier.tryParse(var1);
      if (var2 != null && this.I_field_a567c40b.containsKey(var2)) {
         this.I_field_9573462c.add(var2);
      }
   }

   @Override
   public iii_Class8 createComponent() {
      IIiIIi_Class10 var1 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F);
      IIiIIi_Class10 var2 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F);
      IIiIIi_Class10 var3 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F);
      iii_Class8 var4 = new iii_Class8()
         .I_method_8939bffd(
            new iiII_Class13(var1, () -> IiIiIIII_Class81.I_method_f25a980a(this.I_field_523beb0a))
               .I_method_6da713d1(var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.75F + 0.25F * var0.hover()))
               .i_method_6b618aeb()
               .fill()
         )
         .I_method_8939bffd(
            new Iii_Class4()
               .text(
                  var2,
                  () -> this.I_method_608ed612() + "/" + this.I_field_7865b31.size(),
                  var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.6F + 0.4F * var0.hover())
               )
               .textAlign(IIi_Class2.II_field_b5755e8c)
         )
         .I_method_3301fdd(iII_Class5.II_field_b583e68c)
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(6.0F)
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(6.0F, 0.0F, 0.0F, 0.0F))
         .III_method_9dc17555();
      iii_Class8 var5 = new iii_Class8()
         .I_method_8939bffd(
            new IIiII_Class5(var3, this.i_field_523beb0a, this::I_method_712c5629)
               .I_method_fc398af5(() -> IiIiIIII_Class81.I_method_f25a980a("search"))
               .I_method_e5f33669(var0 -> IiiiiIIIi_Class242.IIi_field_d0c8ec5)
               .I_method_49a8a757(4.0F)
               .i_method_e2c562d5()
               .Ii_method_3f6d8e94(15.0F)
         )
         .I_method_8939bffd(
            new iIIi_Class10<>(this::I_method_325a1a48, RegistryListSetting.Nested1_be9d460::I_method_533bf89e, this::I_method_40659e26, this::I_method_40659e22)
               .I_method_cd60f2a3(18.0F)
               .I_method_e56eeacb()
         )
         .I_method_3301fdd(iII_Class5.I_field_b583e68c)
         .I_method_70a38517(3.0F)
         .III_method_9dc17555();
      return new iii_Class8().I_method_3301fdd(iII_Class5.I_field_b583e68c).I_method_70a38517(4.0F).I_method_8939bffd(var4).I_method_8939bffd(var5);
   }

   @Generated
   public List<RegistryListSetting.Nested1_be9d460> II_method_e0c3c4e5() {
      return this.I_field_7865b31;
   }

   @Generated
   public Map<Identifier, RegistryListSetting.Nested1_be9d460> I_method_12244614() {
      return this.I_field_a567c40b;
   }

   @Generated
   public String II_method_d1c5b7be() {
      return this.i_field_523beb0a;
   }

   @Generated
   public String Ii_method_64e467de() {
      return this.II_field_523beb0a;
   }

   @Generated
   public Set<Identifier> Ii_method_88fb6171() {
      return this.I_field_a56a8dc5;
   }

   @Generated
   public Map<Identifier, Item> i_method_a46089f4() {
      return this.i_field_a567c40b;
   }

   @Generated
   public boolean i_method_9b12da03() {
      return this.I_field_5a;
   }

   @Generated
   public Predicate<Block> I_method_987267e6() {
      return this.I_field_93e25d0f;
   }

   public static final class Nested1_be9d460 {
      private final Block I_field_d9031850;
      private final Item I_field_3c05b08c;
      private final Identifier I_field_6a3d6525;
      private final ItemStack I_field_f2735522;
      private final IiiiIiiIi_Class238 I_field_dd60e8c;
      private final IiiiIiIii_Class236 I_field_dc7facc;

      public Nested1_be9d460(Block var1, Item var2, Identifier var3, ItemStack var4) {
         this.I_field_d9031850 = var1;
         this.I_field_3c05b08c = var2;
         this.I_field_6a3d6525 = var3;
         this.I_field_f2735522 = var4;
         this.I_field_dd60e8c = new IiiiIiiIi_Class238(300L);
         this.I_field_dc7facc = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.iIiI_field_dd60aac);
      }

      public String I_method_6420e886() {
         return Text.translatable(this.I_field_d9031850 != null ? this.I_field_d9031850.getTranslationKey() : this.I_field_3c05b08c.getTranslationKey())
            .getString();
      }

      static RegistryListSetting.Nested1_be9d460 I_method_70f94641(Block var0) {
         if (var0 == null) {
            return null;
         } else {
            Identifier var1 = Registries.BLOCK.getId(var0);
            ItemStack var2 = var0.asItem().getDefaultStack();
            return var2.isEmpty() ? null : new RegistryListSetting.Nested1_be9d460(var0, var2.getItem(), var1, var2);
         }
      }

      static RegistryListSetting.Nested1_be9d460 I_method_21a2863d(Item var0) {
         if (var0 == null) {
            return null;
         } else {
            Identifier var1 = Registries.ITEM.getId(var0);
            ItemStack var2 = var0.getDefaultStack();
            return var2.isEmpty() ? null : new RegistryListSetting.Nested1_be9d460(null, var0, var1, var2);
         }
      }

      @Generated
      public Block I_method_8ffd8654() {
         return this.I_field_d9031850;
      }

      @Generated
      public Item I_method_dc0bcf90() {
         return this.I_field_3c05b08c;
      }

      @Generated
      public Identifier I_method_22893129() {
         return this.I_field_6a3d6525;
      }

      @Generated
      public ItemStack I_method_533bf89e() {
         return this.I_field_f2735522;
      }

      @Generated
      public IiiiIiiIi_Class238 I_method_c4d07c90() {
         return this.I_field_dd60e8c;
      }

      @Generated
      public IiiiIiIii_Class236 I_method_c4c268d0() {
         return this.I_field_dc7facc;
      }
   }
}
