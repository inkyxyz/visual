package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MaceItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.TridentItem;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.screen.slot.SlotActionType;
import pyrock.events.player.ClientPlayerTickEvent;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Inventory Cleaner",
   category = ModuleCategory.OTHER,
   III_method_a89e5834 = "modules.descriptions.inventory_cleaner"
)
public class InventoryCleanerModule extends Module {
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private ModeSetting I_field_bbe33e6c;
   private ModeSetting.Nested1_42765c60 I_field_500d0627;
   private ModeSetting.Nested1_42765c60 i_field_500d0627;
   private RegistryListSetting I_field_ba20c66c;
   private final List<iIIiIiIii_Class300> I_field_7865b31 = new ArrayList<>();
   private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = var1 -> {
      if (this.isEnabled() && I_field_3a9bda27.player != null && I_field_3a9bda27.player.currentScreenHandler != null) {
         if (this.I_field_991c1e8c.I_method_58432069(150L)) {
            this.I_field_7865b31.clear();
            if (this.I_field_500d0627.isSelected()) {
               this.i_method_58fe5c87(iIIiiIiIi_Class310.i_method_7fde0a75().I_method_fdeecb5d(iIIiiIiIi_Class310.I_method_6a489695()));
            } else {
               this.I_method_bbe55467(iIIiiIiIi_Class310.i_method_7fde0a75().I_method_fdeecb5d(iIIiiIiIi_Class310.I_method_6a489695()));
            }

            if (this.I_field_7865b31.isEmpty()) {
               return;
            }

            iIIiIiIii_Class300 var2 = this.I_field_7865b31.removeFirst();
            I_field_3a9bda27.interactionManager
               .clickSlot(I_field_3a9bda27.player.currentScreenHandler.syncId, var2.I_method_dfe89252(), 1, SlotActionType.THROW, I_field_3a9bda27.player);
            this.I_field_991c1e8c.I_method_23e11e3f();
         }
      }
   };

   public InventoryCleanerModule() {
      this.IiI_method_1240eabf();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_1240eabf() {
      this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.inventory_cleaner.mode");
      this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.inventory_cleaner.mode.1_8");
      this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.inventory_cleaner.mode.custom").select();
      this.I_field_ba20c66c = new RegistryListSetting(this, "modules.settings.inventory_cleaner.blocks", () -> !this.i_field_500d0627.isSelected())
         .I_method_d8c582f5();
   }

   private void I_method_bbe55467(iIIiiIiII_Class309<iIIiIiIii_Class300> var1) {
      Set var2 = this.I_field_ba20c66c.II_method_f6bf1d91();
      if (!var2.isEmpty()) {
         for (iIIiIiIii_Class300 var4 : var1.I_method_617d3e68()) {
            if (!var4.I_method_dfe89263() && var2.contains(var4.I_method_158af795())) {
               this.I_field_7865b31.add(var4);
            }
         }
      }
   }

   private void i_method_58fe5c87(iIIiiIiII_Class309<iIIiIiIii_Class300> var1) {
      for (iIIiIiIii_Class300 var3 : var1.I_method_617d3e68()) {
         ItemStack var4 = var3.I_method_7b7e0bb9();
         if (!var4.isEmpty() && !this.I_method_27bd88cb(var3) && (this.I_method_2adcce09(var4, var1) || this.i_method_7990de29(var4, var1))) {
            this.I_field_7865b31.add(var3);
         }
      }
   }

   private boolean I_method_27bd88cb(iIIiIiIii_Class300 var1) {
      return I_field_3a9bda27.player != null && var1.I_method_dfe89252() == 36 + I_field_3a9bda27.player.getInventory().selectedSlot;
   }

   private boolean I_method_2adcce09(ItemStack var1, iIIiiIiII_Class309<iIIiIiIii_Class300> var2) {
      if (var1.getItem() instanceof ArmorItem var3) {
         EquipmentSlot var12 = ((iIiIiiIIi_Class346)var3).rockstar$getType().getEquipmentSlot();
         ItemStack var5 = I_field_3a9bda27.player.getEquippedStack(var12);
         int var6 = this.I_method_24458354(var1);
         if (!var5.isEmpty() && var5.getItem() instanceof ArmorItem) {
            var6 = Math.max(var6, this.I_method_24458354(var5));
         }

         for (iIIiIiIii_Class300 var8 : var2.I_method_617d3e68()) {
            ItemStack var9 = var8.I_method_7b7e0bb9();
            if (var9 != var1 && var9.getItem() instanceof ArmorItem var10 && ((iIiIiiIIi_Class346)var10).rockstar$getType().getEquipmentSlot() == var12) {
               var6 = Math.max(var6, this.I_method_24458354(var9));
            }
         }

         return this.I_method_24458354(var1) < var6;
      } else {
         return false;
      }
   }

   private boolean i_method_7990de29(ItemStack var1, iIIiiIiII_Class309<iIIiIiIii_Class300> var2) {
      String var3 = this.I_method_b9917f5f(var1);
      if (var3 == null) {
         return false;
      } else {
         int var4 = this.i_method_c83e0734(var1);
         int var5 = var4;
         ItemStack var6 = I_field_3a9bda27.player.getMainHandStack();
         if (var3.equals(this.I_method_b9917f5f(var6))) {
            var5 = Math.max(var4, this.i_method_c83e0734(var6));
         }

         ItemStack var7 = I_field_3a9bda27.player.getOffHandStack();
         if (var3.equals(this.I_method_b9917f5f(var7))) {
            var5 = Math.max(var5, this.i_method_c83e0734(var7));
         }

         for (iIIiIiIii_Class300 var9 : var2.I_method_617d3e68()) {
            ItemStack var10 = var9.I_method_7b7e0bb9();
            if (var10 != var1 && var3.equals(this.I_method_b9917f5f(var10))) {
               var5 = Math.max(var5, this.i_method_c83e0734(var10));
            }
         }

         return var4 < var5;
      }
   }

   private String I_method_b9917f5f(ItemStack var1) {
      if (var1.isEmpty()) {
         return null;
      } else {
         Item var2 = var1.getItem();
         if (var2 instanceof SwordItem) {
            return "sword";
         } else if (var2 instanceof AxeItem) {
            return "axe";
         } else if (var2 instanceof BowItem) {
            return "bow";
         } else if (var2 instanceof CrossbowItem) {
            return "crossbow";
         } else if (var2 instanceof TridentItem) {
            return "trident";
         } else {
            return var2 instanceof MaceItem ? "mace" : null;
         }
      }
   }

   private int I_method_24458354(ItemStack var1) {
      if (var1.getItem() instanceof ArmorItem var2) {
         IiiiiIiii_Class248.Nested1_95187080 var11 = IiiiiIiii_Class248.I_method_7613ca72(var1);
         if (var11 != null && "SunHelmet".equals(var11.I_method_3665aca6())) {
            return Integer.MAX_VALUE;
         } else {
            ArmorMaterial var4 = ((iIiIiiIIi_Class346)var2).rockstar$getMaterial();
            EquipmentType var5 = ((iIiIiiIIi_Class346)var2).rockstar$getType();
            int var6 = var4.defense().getOrDefault(var5, 0);
            int var7 = (int)var4.toughness();
            int var8 = iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.PROTECTION);
            int var9 = iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.FIRE_PROTECTION)
               + iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.BLAST_PROTECTION)
               + iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.PROJECTILE_PROTECTION);
            int var10 = iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.FEATHER_FALLING)
               + iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.RESPIRATION)
               + iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.AQUA_AFFINITY)
               + iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.DEPTH_STRIDER)
               + iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.THORNS)
               + iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.UNBREAKING)
               + iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.MENDING);
            return var6 * 50 + var8 * 30 + var7 * 10 + var9 * 12 + var10 * 4 + this.II_method_d6ca86d7(var1);
         }
      } else {
         return 0;
      }
   }

   private int i_method_c83e0734(ItemStack var1) {
      Item var2 = var1.getItem();
      int var3 = this.I_method_8d753a1a(var2);
      if (IiiiiIiii_Class248.I_method_7613ca72(var1) != null) {
         var3 += 1000;
      }

      var3 += iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.SHARPNESS) * 30;
      var3 += iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.POWER) * 30;
      var3 += iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.DENSITY) * 30;
      var3 += iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.BREACH) * 24;
      var3 += iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.SMITE) * 12;
      var3 += iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.BANE_OF_ARTHROPODS) * 12;
      var3 += iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.IMPALING) * 18;
      var3 += iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.FIRE_ASPECT) * 14;
      var3 += iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.KNOCKBACK) * 8;
      var3 += iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.LOOTING) * 10;
      var3 += iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.SWEEPING_EDGE) * 8;
      var3 += iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.PUNCH) * 8;
      var3 += iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.FLAME) * 12;
      var3 += iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.INFINITY) * 16;
      var3 += iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.MULTISHOT) * 16;
      var3 += iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.QUICK_CHARGE) * 14;
      var3 += iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.PIERCING) * 10;
      var3 += iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.LOYALTY) * 8;
      var3 += iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.RIPTIDE) * 10;
      var3 += iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.WIND_BURST) * 18;
      var3 += iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.UNBREAKING) * 4;
      var3 += iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.MENDING) * 6;
      return var3 + this.II_method_d6ca86d7(var1);
   }

   private int I_method_8d753a1a(Item var1) {
      if (var1 == Items.NETHERITE_SWORD || var1 == Items.NETHERITE_AXE || var1 == Items.MACE) {
         return 90;
      } else if (var1 == Items.DIAMOND_SWORD || var1 == Items.DIAMOND_AXE || var1 == Items.TRIDENT) {
         return 80;
      } else if (var1 == Items.IRON_SWORD || var1 == Items.IRON_AXE || var1 == Items.CROSSBOW) {
         return 70;
      } else if (var1 == Items.STONE_SWORD || var1 == Items.STONE_AXE || var1 == Items.BOW) {
         return 60;
      } else if (var1 == Items.GOLDEN_SWORD || var1 == Items.GOLDEN_AXE) {
         return 50;
      } else {
         return var1 != Items.WOODEN_SWORD && var1 != Items.WOODEN_AXE ? 0 : 40;
      }
   }

   private int II_method_d6ca86d7(ItemStack var1) {
      return !var1.isDamageable() ? 0 : (int)((double)(var1.getMaxDamage() - var1.getDamage()) / var1.getMaxDamage() * 10.0);
   }
}
