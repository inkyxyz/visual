package rockstar.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lombok.Generated;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.registry.entry.RegistryEntry;

public final class iIIIIIiII_Class261 {
   public static boolean I_method_afec1b5a(ItemStack var0, RegistryEntry<StatusEffect> var1) {
      if (var0 != null && !var0.isEmpty()) {
         if (!(var0.getItem() instanceof PotionItem)) {
            return false;
         } else {
            PotionContentsComponent var2 = (PotionContentsComponent)var0.get(DataComponentTypes.POTION_CONTENTS);
            if (var2 == null) {
               return false;
            } else {
               for (StatusEffectInstance var4 : var2.getEffects()) {
                  if (var4.getEffectType() == var1) {
                     return true;
                  }
               }

               return false;
            }
         }
      } else {
         return false;
      }
   }

   public static List<StatusEffectInstance> I_method_2d41c106(ItemStack var0) {
      ArrayList var1 = new ArrayList();
      if (var0 == null || var0.isEmpty()) {
         return var1;
      } else if (!(var0.getItem() instanceof PotionItem)) {
         return var1;
      } else {
         PotionContentsComponent var2 = (PotionContentsComponent)var0.get(DataComponentTypes.POTION_CONTENTS);
         if (var2 == null) {
            return var1;
         } else {
            var2.getEffects().forEach(var1::add);
            return var1;
         }
      }
   }

   public static ItemStack I_method_d98ef8f6(ItemStack var0, int var1) {
      if (!(var0.getItem() instanceof PotionItem)) {
         return var0;
      } else {
         PotionContentsComponent var2 = (PotionContentsComponent)var0.get(DataComponentTypes.POTION_CONTENTS);
         if (var2 == null) {
            return var0;
         } else {
            ArrayList var3 = new ArrayList();

            for (StatusEffectInstance var5 : var2.getEffects()) {
               var3.add(
                  new StatusEffectInstance(var5.getEffectType(), var5.getDuration(), var1, var5.isAmbient(), var5.shouldShowParticles(), var5.shouldShowIcon())
               );
            }

            ItemStack var6 = var0.copy();
            var6.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(var2.potion(), var2.customColor(), var3, var2.customName()));
            return var6;
         }
      }
   }

   public static int I_method_64d24b14(ItemStack var0) {
      if (!(var0.getItem() instanceof PotionItem)) {
         return 0;
      } else {
         PotionContentsComponent var1 = (PotionContentsComponent)var0.get(DataComponentTypes.POTION_CONTENTS);
         if (var1 == null) {
            return 0;
         } else {
            Iterator var2 = var1.getEffects().iterator();
            if (var2.hasNext()) {
               StatusEffectInstance var3 = (StatusEffectInstance)var2.next();
               return var3.getAmplifier();
            } else {
               return 0;
            }
         }
      }
   }

   public static boolean I_method_db03f4c7(ItemStack var0, ItemStack var1) {
      PotionContentsComponent var2 = (PotionContentsComponent)var0.get(DataComponentTypes.POTION_CONTENTS);
      PotionContentsComponent var3 = (PotionContentsComponent)var1.get(DataComponentTypes.POTION_CONTENTS);
      if (var2 != null && var3 != null) {
         Map var4 = I_method_a05469a2(var2);
         Map var5 = I_method_a05469a2(var3);

         for (Entry var7 : (Iterable<Entry>)(Iterable<?>)var4.entrySet()) {
            if (!var5.containsKey(var7.getKey())) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   private static Map<iIIIIIiII_Class261.Nested1_86f6bc80, Integer> I_method_a05469a2(PotionContentsComponent var0) {
      HashMap var1 = new HashMap();

      for (StatusEffectInstance var3 : var0.getEffects()) {
         var1.merge(iIIIIIiII_Class261.Nested1_86f6bc80.I_method_a87e30bc(var3), 1, (left, right) -> (Integer)left + (Integer)right);
      }

      return var1;
   }

   public static boolean I_method_64d24b25(ItemStack var0) {
      if (!(var0.getItem() instanceof PotionItem)) {
         return false;
      } else {
         PotionContentsComponent var1 = (PotionContentsComponent)var0.get(DataComponentTypes.POTION_CONTENTS);
         if (var1 == null) {
            return false;
         } else {
            for (StatusEffectInstance var3 : var1.getEffects()) {
               RegistryEntry var4 = var3.getEffectType();
               if (!var4.equals(StatusEffects.INVISIBILITY)
                  && !var4.equals(StatusEffects.NIGHT_VISION)
                  && !var4.equals(StatusEffects.WATER_BREATHING)
                  && !var4.equals(StatusEffects.FIRE_RESISTANCE)
                  && !var4.equals(StatusEffects.SLOW_FALLING)
                  && !var4.equals(StatusEffects.LUCK)) {
                  return true;
               }
            }

            return false;
         }
      }
   }

   @Generated
   private iIIIIIiII_Class261() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }

   static final class Nested1_86f6bc80 {
      private final RegistryEntry<StatusEffect> I_field_3b804775;
      private final int I_field_49;

      private Nested1_86f6bc80(RegistryEntry<StatusEffect> var1, int var2) {
         this.I_field_3b804775 = var1;
         this.I_field_49 = var2;
      }

      static iIIIIIiII_Class261.Nested1_86f6bc80 I_method_a87e30bc(StatusEffectInstance var0) {
         return new iIIIIIiII_Class261.Nested1_86f6bc80(var0.getEffectType(), var0.getAmplifier());
      }

      @Override
      public final String toString() {
         return "Nested1_86f6bc80[type=" + this.I_field_3b804775 + ", amplifier=" + this.I_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_3b804775);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIIIIIiII_Class261.Nested1_86f6bc80 other = (iIIIIIiII_Class261.Nested1_86f6bc80) var1;
         return java.util.Objects.equals(this.I_field_3b804775, other.I_field_3b804775)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49);
      }

      public RegistryEntry<StatusEffect> I_method_31074a11() {
         return this.I_field_3b804775;
      }

      public int I_method_ef5172d() {
         return this.I_field_49;
      }
   }
}
