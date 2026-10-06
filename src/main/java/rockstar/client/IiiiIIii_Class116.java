package rockstar.client;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import lombok.Generated;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.component.type.ProfileComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public final class IiiiIIii_Class116 {
   private static final String[] I_field_6dccaaa5 = new String[]{"consumable", "talisman", "sphere", "tools", "armor", "potions", "other"};
   private static JsonObject I_field_a1a50d2c;

   public static void I_method_2500e8ac() {
      try {
         InputStream var0 = IiiiIIii_Class116.class.getResourceAsStream("/assets/rockstar/donate_items.json");
         if (var0 == null) {
            return;
         }

         InputStreamReader var1 = new InputStreamReader(var0, StandardCharsets.UTF_8);
         I_field_a1a50d2c = (JsonObject)new Gson().fromJson(var1, JsonObject.class);
         var1.close();
      } catch (Exception var2) {
      }
   }

   public static List<IiiiIIii_Class116.Nested1_f85009b6> I_method_5efe7a3f(IiiiIIii_Class116.Nested1_80294f3 var0) {
      if (var0 == IiiiIIii_Class116.Nested1_80294f3.I_field_765e39dc) {
         return i_method_efe5343b();
      } else {
         if (I_field_a1a50d2c == null) {
            I_method_2500e8ac();
         }

         if (I_field_a1a50d2c != null && I_field_a1a50d2c.has(var0.I_method_8ba4a8d9())) {
            ArrayList var1 = new ArrayList();
            JsonObject var2 = I_field_a1a50d2c.getAsJsonObject(var0.I_method_8ba4a8d9());

            for (String var6 : I_field_6dccaaa5) {
               if (var2.has(var6)) {
                  List var7 = I_method_6f6d6b09(var2, var6, var0);
                  if (!var7.isEmpty()) {
                     var1.add(new IiiiIIii_Class116.Nested1_f85009b6(var6, I_method_a1f84fea(var6), var7));
                  }
               }
            }

            return var1;
         } else {
            return List.of();
         }
      }
   }

   public static Map<String, String> I_method_e2088b3d(IiiiIIii_Class116.Nested1_80294f3 var0) {
      if (I_field_a1a50d2c == null) {
         I_method_2500e8ac();
      }

      LinkedHashMap var1 = new LinkedHashMap();
      if (I_field_a1a50d2c != null && I_field_a1a50d2c.has(var0.I_method_8ba4a8d9())) {
         JsonObject var2 = I_field_a1a50d2c.getAsJsonObject(var0.I_method_8ba4a8d9());

         for (String var6 : I_field_6dccaaa5) {
            if (var2.has(var6)) {
               for (JsonElement var8 : var2.getAsJsonArray(var6)) {
                  JsonObject var9 = var8.getAsJsonObject();
                  if (var9.has("name") && var9.has("lore")) {
                     var1.put(var9.get("name").getAsString(), var9.get("lore").getAsString());
                  }
               }
            }
         }

         return var1;
      } else {
         return var1;
      }
   }

   public static List<IiiiIIii_Class116.Nested1_8029513> I_method_3a98fc1b() {
      ArrayList<IiiiIIii_Class116.Nested1_8029513> var0 = new ArrayList<>();
      HashSet<String> var1 = new HashSet<>();

      for (IiiiIIii_Class116.Nested1_80294f3 var5 : new IiiiIIii_Class116.Nested1_80294f3[]{IiiiIIii_Class116.Nested1_80294f3.i_field_765e39dc}) {
         for (IiiiIIii_Class116.Nested1_f85009b6 var7 : I_method_5efe7a3f(var5)) {
            for (IiiiIIii_Class116.Nested1_8029513 var9 : var7.I_method_f3e0b603()) {
               String var10 = var9.I_method_d1d7d0f9();
               if (var10 != null && !var10.isBlank() && var1.add(var10.toLowerCase())) {
                  var0.add(var9);
               }
            }
         }
      }

      var0.sort((var0x, var1x) -> var0x.I_method_d1d7d0f9().compareToIgnoreCase(var1x.I_method_d1d7d0f9()));
      return var0;
   }

   private static List<IiiiIIii_Class116.Nested1_8029513> I_method_6f6d6b09(JsonObject var0, String var1, IiiiIIii_Class116.Nested1_80294f3 var2) {
      ArrayList var3 = new ArrayList();
      var0.getAsJsonArray(var1).forEach(var3x -> {
         JsonObject var4 = var3x.getAsJsonObject();
         String var5 = var4.get("item").getAsString();
         String var6 = var4.has("name") ? var4.get("name").getAsString() : null;
         String var7 = var4.has("id") ? var4.get("id").getAsString() : null;
         String var8 = var4.has("nbtKey") ? var4.get("nbtKey").getAsString() : null;
         String var9 = var4.has("texture") ? var4.get("texture").getAsString() : null;
         String var10 = var2.I_method_8ba4a8d9() + "_" + var1 + "_" + var7;

         try {
            Identifier var11 = Identifier.tryParse(var5);
            if (var11 != null) {
               Item var12 = (Item)Registries.ITEM.get(var11);
               if (var12 != Items.AIR) {
                  ItemStack var13 = var12.getDefaultStack();
                  if (var8 != null) {
                     I_method_9e46d3b4(var13, var8, var2);
                  }

                  if (var9 != null && !var9.isBlank()) {
                     I_method_6053cf58(var13, var9);
                  }

                  var3.add(new IiiiIIii_Class116.Nested1_8029513(var13, var6, var10));
               }
            }
         } catch (Exception var14) {
         }
      });
      return var3;
   }

   private static String I_method_a1f84fea(String var0) {
      return switch (var0) {
         case "consumable" -> "\u0420\u0430\u0441\u0445\u043e\u0434\u043d\u0438\u043a\u0438";
         case "talisman" -> "\u0422\u0430\u043b\u0438\u0441\u043c\u0430\u043d\u044b";
         case "sphere" -> "\u0421\u0444\u0435\u0440\u044b";
         case "tools" -> "\u0418\u043d\u0441\u0442\u0440\u0443\u043c\u0435\u043d\u0442\u044b";
         case "armor" -> "\u0411\u0440\u043e\u043d\u044f";
         case "potions" -> "\u0417\u0435\u043b\u044c\u044f";
         case "other" -> "\u0414\u0440\u0443\u0433\u043e\u0435";
         default -> var0;
      };
   }

   private static List<IiiiIIii_Class116.Nested1_f85009b6> i_method_efe5343b() {
      ArrayList var0 = new ArrayList();
      Registries.ITEM.stream().filter(var0x -> var0x != Items.AIR).forEach(var1 -> {
         if (I_method_30b6185e(var1)) {
            I_method_f82cb14b(var1, var0);
         } else {
            i_method_4c45016b(var1, var0);
         }
      });
      return List.of(new IiiiIIii_Class116.Nested1_f85009b6("all", "\u0412\u0441\u0435 \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u044b", var0));
   }

   private static boolean I_method_30b6185e(Item var0) {
      return var0 == Items.POTION || var0 == Items.SPLASH_POTION || var0 == Items.LINGERING_POTION;
   }

   private static void I_method_f82cb14b(Item var0, List<IiiiIIii_Class116.Nested1_8029513> var1) {
      Registries.POTION.streamEntries().forEach(var2 -> {
         try {
            ItemStack var3 = var0.getDefaultStack();
            var3.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(var2));
            String var4 = Registries.ITEM.getId(var0).toString() + "_" + var2.getIdAsString();
            var1.add(new IiiiIIii_Class116.Nested1_8029513(var3, null, var4));
         } catch (Exception var5) {
         }
      });
   }

   private static void i_method_4c45016b(Item var0, List<IiiiIIii_Class116.Nested1_8029513> var1) {
      try {
         var1.add(new IiiiIIii_Class116.Nested1_8029513(var0.getDefaultStack(), null, Registries.ITEM.getId(var0).toString()));
      } catch (Exception var3) {
      }
   }

   private static void I_method_9e46d3b4(ItemStack var0, String var1, IiiiIIii_Class116.Nested1_80294f3 var2) {
      try {
         NbtCompound var3 = new NbtCompound();
         if (var2 == IiiiIIii_Class116.Nested1_80294f3.i_field_765e39dc) {
            NbtCompound var4 = new NbtCompound();
            var4.putString("minecraft:don-item", var1);
            if (var1.startsWith("potion-")) {
               var4.putBoolean("minecraft:is-tshop", true);
            }

            var3.put("PublicBukkitValues", var4);
         }

         var0.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(var3));
      } catch (Exception var5) {
      }
   }

   private static void I_method_6053cf58(ItemStack var0, String var1) {
      try {
         PropertyMap var2 = new PropertyMap();
         var2.put("textures", new Property("textures", var1));
         var0.set(
            DataComponentTypes.PROFILE,
            new ProfileComponent(Optional.empty(), Optional.of(UUID.nameUUIDFromBytes(var1.getBytes(StandardCharsets.UTF_8))), var2)
         );
      } catch (Exception var3) {
      }
   }

   @Generated
   private IiiiIIii_Class116() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }

   public static enum Nested1_80294f3 {
      I_field_765e39dc("all", "\u0412\u0441\u0435"),
      i_field_765e39dc("funtime", "Funtime");

      private final String I_field_523beb0a;
      private final String i_field_523beb0a;

      private Nested1_80294f3(String var3, String var4) {
         this.I_field_523beb0a = var3;
         this.i_field_523beb0a = var4;
      }

      @Generated
      public String I_method_8ba4a8d9() {
         return this.I_field_523beb0a;
      }

      @Generated
      public String i_method_1ec358f9() {
         return this.i_field_523beb0a;
      }
   }

   public static final class Nested1_8029513 {
      private final ItemStack I_field_f2735522;
      private final String I_field_523beb0a;
      private final String i_field_523beb0a;

      public Nested1_8029513(ItemStack var1, String var2, String var3) {
         this.I_field_f2735522 = var1;
         this.I_field_523beb0a = var2;
         this.i_field_523beb0a = var3;
      }

      @Override
      public final String toString() {
         return "Nested1_8029513[stack=" + this.I_field_f2735522 + ", customName=" + this.I_field_523beb0a + ", id=" + this.i_field_523beb0a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_f2735522);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_523beb0a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiiiIIii_Class116.Nested1_8029513 other = (IiiiIIii_Class116.Nested1_8029513) var1;
         return java.util.Objects.equals(this.I_field_f2735522, other.I_field_f2735522)
            && java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.i_field_523beb0a, other.i_field_523beb0a);
      }

      public ItemStack I_method_c2b2cc91() {
         return this.I_field_f2735522;
      }

      public String I_method_d1d7d0f9() {
         return this.I_field_523beb0a;
      }

      public String i_method_64f68119() {
         return this.i_field_523beb0a;
      }
   }

   public static final class Nested1_f85009b6 {
      private final String I_field_523beb0a;
      private final String i_field_523beb0a;
      private final List<IiiiIIii_Class116.Nested1_8029513> I_field_7865b31;

      public Nested1_f85009b6(String var1, String var2, List<IiiiIIii_Class116.Nested1_8029513> var3) {
         this.I_field_523beb0a = var1;
         this.i_field_523beb0a = var2;
         this.I_field_7865b31 = var3;
      }

      @Override
      public final String toString() {
         return "Nested1_f85009b6[type=" + this.I_field_523beb0a + ", displayName=" + this.i_field_523beb0a + ", items=" + this.I_field_7865b31 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_7865b31);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiiiIIii_Class116.Nested1_f85009b6 other = (IiiiIIii_Class116.Nested1_f85009b6) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.i_field_523beb0a, other.i_field_523beb0a)
            && java.util.Objects.equals(this.I_field_7865b31, other.I_field_7865b31);
      }

      public String I_method_916ad95c() {
         return this.I_field_523beb0a;
      }

      public String i_method_2489897c() {
         return this.i_field_523beb0a;
      }

      public List<IiiiIIii_Class116.Nested1_8029513> I_method_f3e0b603() {
         return this.I_field_7865b31;
      }
   }
}
