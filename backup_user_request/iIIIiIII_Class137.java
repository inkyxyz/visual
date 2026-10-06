package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import lombok.Generated;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.component.type.ItemEnchantmentsComponent.Builder;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntry.Reference;
import pyrock.utility.render.ColorRGBA;

public class iIIIiIII_Class137 {
   private final List<iIIIiiII_Class141> I_field_7865b31;
   private final ItemStack I_field_f2735522;
   private float I_field_46;
   private float i_field_46;
   private float II_field_46 = 120.0F;
   private boolean I_field_5a;

   public static iIIIiIII_Class137.Nested1_a641e493 I_method_fd37a7c6() {
      return new iIIIiIII_Class137.Nested1_a641e493();
   }

   public void I_method_3977da0c(float var1, float var2) {
      this.I_field_46 = var1;
      this.i_field_46 = var2;
      this.II_field_46 = this.iI_method_45bc93e5();
      this.I_field_5a = true;
   }

   public void I_method_8e93f50c() {
      this.I_field_5a = false;
   }

   public void I_method_bfd7129a(III var1) {
      if (this.I_field_5a) {
         this.I_method_3334259a(var1, this.I_field_46, this.i_field_46, this.II_field_46, this.Ii_method_44082fa5());
         float var2 = this.i_field_46 + 6.0F;
         var1.drawText(
            IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F),
            "\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0430 \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u0430",
            this.I_field_46 + 6.0F,
            var2,
            ColorRGBA.WHITE
         );
         var2 += 12.0F;
         if (this.I_field_f2735522 != null && !this.I_field_f2735522.isEmpty()) {
            this.I_method_a6d01ee6(var1, this.I_field_46 + 4.0F, var2, this.II_field_46 - 8.0F);
            var2 += 24.0F;
         }

         for (iIIIiiII_Class141 var4 : this.I_field_7865b31) {
            var4.I_method_bc6592c6(var1, this.I_field_46 + 6.0F, var2, this.II_field_46 - 12.0F);
            var2 += var4.I_method_c52f08dc() + 4.0F;
         }
      }
   }

   private void I_method_a6d01ee6(III var1, float var2, float var3, float var4) {
      var1.drawRoundedRect(var2, var3, var4, 20.0F, IIiii_Class8.I_method_893b2757(4.0F), IiiiiIIIi_Class242.Ii_method_a0f56f71());
      var1.getMatrices().push();
      var1.getMatrices().translate(0.0F, 0.0F, 200.0F);
      var1.drawBatchItem(this.I_field_f2735522, var2 + 4.0F, var3 + 4.0F, 0.75F);
      var1.getMatrices().pop();
      var1.drawText(
         IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F),
         Iiiiiiiii_Class256.i_method_524c3f7f(this.I_field_f2735522),
         var2 + 22.0F,
         var3 + 8.0F,
         IiiiiIIIi_Class242.iI_method_8e08d3b1()
      );
   }

   public boolean I_method_f566c2bb(double var1, double var3, int var5) {
      if (!this.I_field_5a) {
         return false;
      } else if (!(var1 < this.I_field_46)
         && !(var1 > this.I_field_46 + this.II_field_46)
         && !(var3 < this.i_field_46)
         && !(var3 > this.i_field_46 + this.Ii_method_44082fa5())) {
         float var6 = this.i_field_46 + 6.0F + 12.0F;
         if (this.I_field_f2735522 != null && !this.I_field_f2735522.isEmpty()) {
            var6 += 24.0F;
         }

         for (iIIIiiII_Class141 var8 : this.I_field_7865b31) {
            if (var3 >= var6 && var3 < var6 + var8.I_method_c52f08dc()) {
               return var8.I_method_dd6e4c7a(this, var1, var3, var5);
            }

            var6 += var8.I_method_c52f08dc() + 4.0F;
         }

         return true;
      } else {
         this.I_method_8e93f50c();
         return true;
      }
   }

   public void i_method_8ea280ec() {
      for (iIIIiiII_Class141 var2 : this.I_field_7865b31) {
         if (var2 instanceof iIIIiiiI_Class143 var3) {
            var3.I_method_2780f90c();
         }
      }
   }

   public void I_method_43eb0cb2(double var1) {
      for (iIIIiiII_Class141 var4 : this.I_field_7865b31) {
         if (var4 instanceof iIIIiIii_Class140 var5 && var5.I_method_61f67110()) {
            var5.I_method_dcd810b2(var1);
         }
      }
   }

   public void II_method_43f9a3d5() {
      for (iIIIiiII_Class141 var2 : this.I_field_7865b31) {
         if (var2 instanceof iIIIiIii_Class140 var3) {
            for (iIIIiiII_Class141 var5 : var3.I_method_e995a7bb()) {
               if (var5 instanceof iIIIiIiI_Class139 var6) {
                  var6.i_method_2b69e90c();
               }

               if (var5 instanceof iIIIiiIi_Class142 var7) {
                  var7.i_method_2b69e90c();
               }
            }
         }
      }
   }

   private float Ii_method_44082fa5() {
      float var1 = 24.0F;
      if (this.I_field_f2735522 != null && !this.I_field_f2735522.isEmpty()) {
         var1 += 24.0F;
      }

      for (iIIIiiII_Class141 var3 : this.I_field_7865b31) {
         var1 += var3.I_method_c52f08dc() + 4.0F;
      }

      return var1 - 4.0F;
   }

   private float iI_method_45bc93e5() {
      float var1 = IIiIiI_Class11.i_field_857c0621
            .I_method_3a2d5e3(7.0F)
            .I_method_2c375926("\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0430 \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u0430")
         + 8.0F;
      float var2 = 0.0F;
      if (this.I_field_f2735522 != null && !this.I_field_f2735522.isEmpty()) {
         var2 = 22.0F
            + IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F).I_method_2c375926(Iiiiiiiii_Class256.i_method_524c3f7f(this.I_field_f2735522))
            + 14.0F;
      }

      return Math.max(120.0F, Math.max(var1, var2));
   }

   public List<iIIIIiii_Class136> I_method_85bfa3bb() {
      ArrayList var1 = new ArrayList();

      for (iIIIiiII_Class141 var3 : this.I_field_7865b31) {
         if (var3 instanceof iIIIiIiI_Class139 var4) {
            var1.add(var4.I_method_308bcf6b());
         }

         if (var3 instanceof iIIIiIii_Class140 var8) {
            for (iIIIiiII_Class141 var6 : var8.I_method_e995a7bb()) {
               if (var6 instanceof iIIIiIiI_Class139 var7) {
                  var1.add(var7.I_method_308bcf6b());
               }

               if (var6 instanceof iIIIiiIi_Class142 var9) {
                  var1.add(var9.I_method_82945bcb());
                  var1.add(var9.i_method_ac90ebeb());
               }
            }
         }
      }

      return var1;
   }

   private void I_method_3334259a(III var1, float var2, float var3, float var4, float var5) {
      var1.drawBlurredRect(var2, var3, var4, var5, 45.0F, 5.0F, IIiii_Class8.I_method_893b2757(6.0F), ColorRGBA.WHITE.withAlpha(255.0F));
      var1.drawSquircle(
         var2,
         var3,
         var4,
         var5,
         2.0F,
         IIiii_Class8.I_method_893b2757(6.0F),
         IiiiiIIIi_Class242.II_method_190e6391().withAlpha(255.0F * IiiiiIIIi_Class242.I_method_5ac4a715().II_method_b3b834f2())
      );
   }

   @Generated
   public List<iIIIiiII_Class141> i_method_3b0bdbdb() {
      return this.I_field_7865b31;
   }

   @Generated
   public ItemStack I_method_bf15e42c() {
      return this.I_field_f2735522;
   }

   @Generated
   public float I_method_8e93f4fc() {
      return this.I_field_46;
   }

   @Generated
   public float i_method_8ea280dc() {
      return this.i_field_46;
   }

   @Generated
   public float II_method_43f9a3c5() {
      return this.II_field_46;
   }

   @Generated
   public boolean I_method_8e93f510() {
      return this.I_field_5a;
   }

   @Generated
   public iIIIiIII_Class137(List<iIIIiiII_Class141> var1, ItemStack var2) {
      this.I_field_7865b31 = var1;
      this.I_field_f2735522 = var2;
   }

   public static class Nested1_21faae16 implements iIIiIIiIi_Class294 {
      private final ItemStack I_field_f2735522;

      public Optional<iIIIiIii_Class140> I_method_910234e1() {
         List var1 = this.I_method_5b2d6a63();
         if (var1.isEmpty()) {
            return Optional.empty();
         } else {
            iIIIiIii_Class140 var2 = new iIIIiIii_Class140("\u0417\u0430\u0447\u0430\u0440\u043e\u0432\u0430\u043d\u0438\u044f");

            for (RegistryEntry var4 : (Iterable<RegistryEntry>)(Iterable<?>)var1) {
               String var5 = ((Enchantment)var4.value()).description().getString();
               int var6 = ((Enchantment)var4.value()).getMaxLevel();
               int var7 = iIIiIiIIi_Class298.I_method_7ea237bf(this.I_field_f2735522, (RegistryKey<Enchantment>)var4.getKey().get());
               var2.I_method_b6966fad(new iIIIiIiI_Class139(var5, var6, var7, var2x -> this.I_method_d3066b0a(var4, var2x)));
            }

            return Optional.of(var2);
         }
      }

      private List<Reference<Enchantment>> I_method_5b2d6a63() {
         return I_field_3a9bda27.world
            .getRegistryManager()
            .getOrThrow(RegistryKeys.ENCHANTMENT)
            .streamEntries()
            .filter(var1 -> ((Enchantment)var1.value()).isAcceptableItem(this.I_field_f2735522))
            .toList();
      }

      private void I_method_d3066b0a(RegistryEntry<Enchantment> var1, int var2) {
         Builder var3 = new Builder(
            (ItemEnchantmentsComponent)this.I_field_f2735522.getOrDefault(DataComponentTypes.ENCHANTMENTS, ItemEnchantmentsComponent.DEFAULT)
         );
         if (var2 <= 0) {
            var3.remove(var1x -> var1x.equals(var1));
         } else {
            var3.set(var1, var2);
         }

         this.I_field_f2735522.set(DataComponentTypes.ENCHANTMENTS, var3.build());
      }

      @Generated
      public Nested1_21faae16(ItemStack var1) {
         this.I_field_f2735522 = var1;
      }
   }

   public static class Nested1_a641e493 implements iIIiIIiIi_Class294 {
      private final List<iIIIiiII_Class141> I_field_7865b31 = new ArrayList<>();
      private ItemStack I_field_f2735522;

      public iIIIiIII_Class137.Nested1_a641e493 I_method_373a7c89(ItemStack var1) {
         this.I_field_f2735522 = var1;
         return this;
      }

      public iIIIiIII_Class137.Nested1_a641e493 I_method_52ea9eef(String var1, Consumer<iIIIiIII_Class137> var2) {
         this.I_field_7865b31.add(new iIIIiIIi_Class138(var1, IiiiiIIIi_Class242.iI_method_8e08d3b1(), var2));
         return this;
      }

      public iIIIiIII_Class137.Nested1_a641e493 I_method_2e15566c(String var1, ColorRGBA var2, Consumer<iIIIiIII_Class137> var3) {
         this.I_field_7865b31.add(new iIIIiIIi_Class138(var1, var2, var3));
         return this;
      }

      public iIIIiIII_Class137.Nested1_a641e493 i_method_85ee8ca9(ItemStack var1) {
         new iIIIiIII_Class137.Nested1_21faae16(var1).I_method_910234e1().ifPresent(this.I_field_7865b31::add);
         return this;
      }

      public iIIIiIII_Class137.Nested1_a641e493 II_method_c4ad05b6(ItemStack var1) {
         new iIIIiIII_Class137.Nested1_a641e4b3(var1).I_method_b226a47e().ifPresent(this.I_field_7865b31::add);
         return this;
      }

      public iIIIiIII_Class137.Nested1_a641e493 I_method_f1db8ed0(String var1, int var2, int var3, int var4, Consumer<Integer> var5) {
         this.I_field_7865b31.add(new iIIIiiiI_Class143(var1, var2, var3, var4, var5));
         return this;
      }

      public iIIIiIII_Class137 I_method_d3a9ce30() {
         return new iIIIiIII_Class137(new ArrayList<>(this.I_field_7865b31), this.I_field_f2735522);
      }
   }

   public static class Nested1_a641e4b3 implements iIIiIIiIi_Class294 {
      private final ItemStack I_field_f2735522;

      public Optional<iIIIiIii_Class140> I_method_b226a47e() {
         if (!this.I_method_5f6a16eb()) {
            return Optional.empty();
         } else {
            iIIIiIii_Class140 var1 = new iIIIiIii_Class140("\u042d\u0444\u0444\u0435\u043a\u0442\u044b", new ItemStack(Items.POTION));
            PotionContentsComponent var2 = (PotionContentsComponent)this.I_field_f2735522
               .getOrDefault(DataComponentTypes.POTION_CONTENTS, PotionContentsComponent.DEFAULT);

            for (RegistryEntry var4 : Registries.STATUS_EFFECT.getIndexedEntries()) {
               String var5 = ((StatusEffect)var4.value()).getName().getString();
               StatusEffectInstance var6 = this.I_method_82f1225d(var2, var4);
               int var7 = var6 != null ? var6.getAmplifier() : -1;
               int var8 = var6 != null ? var6.getDuration() : 0;
               var1.I_method_b6966fad(new iIIIiiIi_Class142(var5, var4, var7, var8, (var2x, var3) -> this.I_method_28871f7c(var4, var2x, var3)));
            }

            return Optional.of(var1);
         }
      }

      private StatusEffectInstance I_method_82f1225d(PotionContentsComponent var1, RegistryEntry<StatusEffect> var2) {
         for (StatusEffectInstance var4 : var1.getEffects()) {
            if (var4.getEffectType().equals(var2)) {
               return var4;
            }
         }

         return null;
      }

      private boolean I_method_5f6a16eb() {
         return this.I_field_f2735522.isOf(Items.POTION)
            || this.I_field_f2735522.isOf(Items.SPLASH_POTION)
            || this.I_field_f2735522.isOf(Items.LINGERING_POTION)
            || this.I_field_f2735522.isOf(Items.TIPPED_ARROW);
      }

      private void I_method_28871f7c(RegistryEntry<StatusEffect> var1, int var2, int var3) {
         PotionContentsComponent var4 = (PotionContentsComponent)this.I_field_f2735522
            .getOrDefault(DataComponentTypes.POTION_CONTENTS, PotionContentsComponent.DEFAULT);
         ArrayList var5 = new ArrayList();

         for (StatusEffectInstance var7 : var4.getEffects()) {
            if (!var7.getEffectType().equals(var1)) {
               var5.add(var7);
            }
         }

         if (var2 >= 0 && var3 > 0) {
            var5.add(new StatusEffectInstance(var1, var3, var2));
         }

         PotionContentsComponent var9 = PotionContentsComponent.DEFAULT;

         for (StatusEffectInstance var8 : (Iterable<StatusEffectInstance>)(Iterable<?>)var5) {
            var9 = var9.with(var8);
         }

         this.I_field_f2735522.set(DataComponentTypes.POTION_CONTENTS, var9);
      }

      @Generated
      public Nested1_a641e4b3(ItemStack var1) {
         this.I_field_f2735522 = var1;
      }
   }
}
