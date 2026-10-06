package rockstar.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.screen.slot.SlotActionType;
import pyrock.events.player.ClientPlayerTickEvent;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Auto Armor",
   category = ModuleCategory.COMBAT,
   III_method_a89e5834 = "modules.descriptions.auto_armor"
)
public class AutoArmorModule extends Module {
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private SliderSetting I_field_73178e8c;
   private BooleanSetting I_field_ba20ca4c;
   private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = var1 -> {
      PlayerInventory var2 = I_field_3a9bda27.player.getInventory();
      int[] var3 = new int[4];
      int[] var4 = new int[4];
      this.I_method_a261490c(var2, var3, var4);
      ArrayList<Integer> var5 = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
      Collections.shuffle(var5);

      for (int var7 : var5) {
         int var8 = var3[var7];
         if (var8 != -1) {
            ItemStack var9 = var2.getArmorStack(var7);
            if ((var9.isEmpty() || var2.getEmptySlot() != -1)
               && (
                  !this.I_field_ba20ca4c.i_method_9b12da03()
                     || I_field_3a9bda27.player.getEquippedStack(EquipmentSlot.CHEST).getItem() != Items.ELYTRA
                     || var7 != 2
               )) {
               this.I_method_b104f2d0(var2, var8, var7);
               break;
            }
         }
      }
   };

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_5717c1ec() {
      this.I_field_73178e8c = new SliderSetting(this, "modules.settings.auto_armor.delay")
         .I_method_c8c9a7d7(50.0F)
         .i_method_65e2aff7(1000.0F)
         .II_method_b0f56334(1.0F)
         .Ii_method_4e0e6b54(250.0F)
         .I_method_d41e7abf(" ms");
      this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.auto_armor.elytra");
   }

   public AutoArmorModule() {
      this.IiI_method_5717c1ec();
   }

   private void I_method_a261490c(PlayerInventory var1, int[] var2, int[] var3) {
      for (int var4 = 0; var4 < 4; var4++) {
         var2[var4] = -1;
         ItemStack var5 = var1.getArmorStack(var4);
         if (!var5.isEmpty() && var5.getItem() instanceof ArmorItem var6) {
            var3[var4] = this.I_method_dc726fc6(var6, var5);
         }
      }

      for (int var10 = 0; var10 < 36; var10++) {
         ItemStack var11 = var1.getStack(var10);
         if (!var11.isEmpty() && var11.getItem() instanceof ArmorItem var12) {
            EquipmentSlot var14 = ((iIiIiiIIi_Class346)var12).rockstar$getType().getEquipmentSlot();
            byte var8;
            switch (var14) {
               case HEAD:
                  var8 = 3;
                  break;
               case CHEST:
                  var8 = 2;
                  break;
               case LEGS:
                  var8 = 1;
                  break;
               case FEET:
                  var8 = 0;
                  break;
               default:
                  continue;
            }

            int var9 = this.I_method_dc726fc6(var12, var11);
            if (var9 > var3[var8]) {
               var2[var8] = var10;
               var3[var8] = var9;
            }
         }
      }
   }

   private void I_method_b104f2d0(PlayerInventory var1, int var2, int var3) {
      if (var2 < 9) {
         var2 += 36;
      }

      if (this.I_field_991c1e8c.I_method_58432069((long)this.I_field_73178e8c.Ii_method_a20abcd2())) {
         ItemStack var4 = var1.getArmorStack(var3);
         if (!var4.isEmpty()) {
            I_field_3a9bda27.interactionManager.clickSlot(0, 8 - var3, 0, SlotActionType.QUICK_MOVE, I_field_3a9bda27.player);
         }

         I_field_3a9bda27.interactionManager.clickSlot(0, var2, 0, SlotActionType.QUICK_MOVE, I_field_3a9bda27.player);
         this.I_field_991c1e8c.I_method_23e11e3f();
      }
   }

   private int I_method_dc726fc6(ArmorItem var1, ItemStack var2) {
      IiiiiIiii_Class248.Nested1_95187080 var3 = IiiiiIiii_Class248.I_method_7613ca72(var2);
      if (var3 != null && "SunHelmet".equals(var3.I_method_3665aca6())) {
         return Integer.MAX_VALUE;
      } else {
         ArmorMaterial var4 = ((iIiIiiIIi_Class346)var1).rockstar$getMaterial();
         EquipmentType var5 = ((iIiIiiIIi_Class346)var1).rockstar$getType();
         int var6 = var4.defense().getOrDefault(var5, 0);
         int var7 = (int)var4.toughness();
         int var8 = iIIiIiIIi_Class298.I_method_7ea237bf(var2, Enchantments.PROTECTION);
         return var6 * 5 + var8 * 3 + var7;
      }
   }
}
