package rockstar.client;

import java.util.Comparator;
import java.util.List;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Item.TooltipContext;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.window.KeyPressEvent;
import pyrock.events.window.MouseEvent;
import pyrock.utility.render.ColorRGBA;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Boots Swap",
   category = ModuleCategory.PLAYER,
   III_method_a89e5834 = "modules.descriptions.boots_swap"
)
public class BootsSwapModule extends Module {
   private BooleanSetting I_field_ba20ca4c;
   private KeybindSetting I_field_ba20522c;
   private BootsSwapModule.Nested1_e4d21420 I_field_f9284667;
   private boolean I_field_5a = false;
   private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = var1 -> {
      if (this.I_field_ba20ca4c.i_method_9b12da03()) {
         ItemStack var2 = I_field_3a9bda27.player.getMainHandStack();
         boolean var3 = var2.getItem() == Items.MACE;
         if (var3 && !this.I_field_5a) {
            iIIiiiIiI_Class315 var6 = iIIiIiIiI_Class299.Ii_method_3e8d7ff8();
            if (!this.I_method_6dd86785(var6.I_method_7b7e0bb9())) {
               this.iII_method_f1b5629f();
            }
         } else if (!var3 && this.I_field_5a) {
            iIIiiiIiI_Class315 var4 = iIIiIiIiI_Class299.Ii_method_3e8d7ff8();
            if (this.I_method_6dd86785(var4.I_method_7b7e0bb9())) {
               this.iIi_method_f1c3ee7f();
            }
         }

         this.I_field_5a = var3;
      }

      GuiMoveModule var5 = RockstarClient.getInstance().getModuleManager().getModule(GuiMoveModule.class);
      if (this.I_field_f9284667 != null) {
         if (this.I_field_f9284667.I_field_1242a2ac.I_method_dfe89252() >= 36 && this.I_field_f9284667.I_field_1242a2ac.I_method_dfe89252() <= 44) {
            iIIiIiIiI_Class299.iI_method_c617e8c2(
               this.I_field_f9284667.i_field_1242a2ac.I_method_dfe89252(), this.I_field_f9284667.I_field_1242a2ac.I_method_dfe89252() - 36
            );
            this.I_field_f9284667 = null;
         } else if (this.I_field_f9284667.I_field_49 == 0 && var5.I_method_eb75c1e8().isEmpty()) {
            iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_f9284667.I_field_1242a2ac.I_method_dfe89252(), 8);
            this.I_field_f9284667.I_field_49++;
         } else if (this.I_field_f9284667.I_field_49 == 1 && var5.I_method_eb75c1e8().isEmpty()) {
            iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_f9284667.i_field_1242a2ac.I_method_dfe89252(), 8);
            this.I_field_f9284667.I_field_49++;
         } else if (this.I_field_f9284667.I_field_49 == 2 && var5.I_method_eb75c1e8().isEmpty()) {
            iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_f9284667.I_field_1242a2ac.I_method_dfe89252(), 8);
            this.I_field_f9284667.I_field_49++;
         }

         if (this.I_field_f9284667 != null && this.I_field_f9284667.I_field_49 >= 3) {
            this.I_field_f9284667 = null;
         }
      }
   };
   private final IiIIIiII_Class69<KeyPressEvent> i_field_3d936f41 = var1 -> {
      if (this.I_field_ba20522c.I_method_51ee2d08(var1.getKey()) && var1.getAction() == 1 && I_field_3a9bda27.currentScreen == null) {
         this.Iii_method_bcebcabf();
      }
   };
   private final IiIIIiII_Class69<MouseEvent> II_field_3d936f41 = var1 -> {
      if (this.I_field_ba20522c.I_method_51ee2d08(var1.getButton()) && var1.getAction() == 1 && I_field_3a9bda27.currentScreen == null) {
         this.Iii_method_bcebcabf();
      }
   };

   public BootsSwapModule() {
      this.IiI_method_bcdd3edf();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_bcdd3edf() {
      this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.boots_swap.automatic");
      this.I_field_ba20522c = new KeybindSetting(this, "modules.settings.boots_swap.swap_key", () -> this.I_field_ba20ca4c.i_method_9b12da03());
   }

   private void Iii_method_bcebcabf() {
      iIIiiiIiI_Class315 var1 = iIIiIiIiI_Class299.Ii_method_3e8d7ff8();
      iIIiiIiII_Class309 var2 = iIIiiIiIi_Class310.i_method_7fde0a75().I_method_fdeecb5d(iIIiiIiIi_Class310.I_method_6a489695());
      boolean var3 = this.I_method_6dd86785(var1.I_method_7b7e0bb9());
      iIIiIiIii_Class300 var4;
      if (var3) {
         var4 = this.I_method_db7fbb03(var2, false);
      } else {
         var4 = this.I_method_db7fbb03(var2, true);
      }

      if (this.I_field_f9284667 == null && var4 != null) {
         this.I_field_f9284667 = new BootsSwapModule.Nested1_e4d21420(var4, var1);
         boolean var5 = this.I_method_6dd86785(var4.I_method_7b7e0bb9());
         String var6 = var5
            ? "\u041f\u043e\u043f\u0440\u044b\u0433\u0443\u043d"
            : "\u041e\u0431\u044b\u0447\u043d\u044b\u0435 \u0431\u043e\u0442\u0438\u043d\u043a\u0438";
         ColorRGBA var7 = IiiiiIIIi_Class242.i_method_5dfec6e();
         RockstarClient.getInstance()
            .I_method_5cb1af22()
            .I_method_67864747(
               new iiiIiIi_Class118(IiIiIIII_Class81.I_method_1410d1e5("alerts.equipped", var6), var4.I_method_7b7e0bb9())
                  .I_method_7ab92a7f(var6)
                  .I_method_c9efc756(var7)
            );
      }
   }

   private void iII_method_f1b5629f() {
      iIIiiiIiI_Class315 var1 = iIIiIiIiI_Class299.Ii_method_3e8d7ff8();
      iIIiiIiII_Class309 var2 = iIIiiIiIi_Class310.i_method_7fde0a75().I_method_fdeecb5d(iIIiiIiIi_Class310.I_method_6a489695());
      iIIiIiIii_Class300 var3 = this.I_method_db7fbb03(var2, true);
      if (this.I_field_f9284667 == null && var3 != null) {
         this.I_field_f9284667 = new BootsSwapModule.Nested1_e4d21420(var3, var1);
         RockstarClient.getInstance()
            .I_method_5cb1af22()
            .I_method_67864747(
               new iiiIiIi_Class118(
                     IiIiIIII_Class81.I_method_1410d1e5("alerts.equipped", "\u041f\u043e\u043f\u0440\u044b\u0433\u0443\u043d"), var3.I_method_7b7e0bb9()
                  )
                  .I_method_7ab92a7f("\u041f\u043e\u043f\u0440\u044b\u0433\u0443\u043d")
                  .I_method_c9efc756(IiiiiIIIi_Class242.i_method_5dfec6e())
            );
      }
   }

   private void iIi_method_f1c3ee7f() {
      iIIiiiIiI_Class315 var1 = iIIiIiIiI_Class299.Ii_method_3e8d7ff8();
      iIIiiIiII_Class309 var2 = iIIiiIiIi_Class310.i_method_7fde0a75().I_method_fdeecb5d(iIIiiIiIi_Class310.I_method_6a489695());
      iIIiIiIii_Class300 var3 = this.I_method_db7fbb03(var2, false);
      if (this.I_field_f9284667 == null && var3 != null) {
         this.I_field_f9284667 = new BootsSwapModule.Nested1_e4d21420(var3, var1);
         RockstarClient.getInstance()
            .I_method_5cb1af22()
            .I_method_67864747(
               new iiiIiIi_Class118(
                     IiIiIIII_Class81.I_method_1410d1e5(
                        "alerts.equipped", "\u041e\u0431\u044b\u0447\u043d\u044b\u0435 \u0431\u043e\u0442\u0438\u043d\u043a\u0438"
                     ),
                     var3.I_method_7b7e0bb9()
                  )
                  .I_method_7ab92a7f("\u041e\u0431\u044b\u0447\u043d\u044b\u0435 \u0431\u043e\u0442\u0438\u043d\u043a\u0438")
                  .I_method_c9efc756(IiiiiIIIi_Class242.i_method_5dfec6e())
            );
      }
   }

   private iIIiIiIii_Class300 I_method_db7fbb03(iIIiiIiII_Class309<iIIiIiIii_Class300> var1, boolean var2) {
      List<iIIiIiIii_Class300> var3 = var1.I_method_144f4b9(
         var2x -> var2x.getItem() instanceof ArmorItem var3x
            && ((iIiIiiIIi_Class346)var3x).rockstar$getType() == EquipmentType.BOOTS
            && this.I_method_6dd86785(var2x) == var2
      );
      return var3.isEmpty() ? null : var3.stream().max(Comparator.comparingInt(var1x -> this.I_method_6dd86774(var1x.I_method_7b7e0bb9()))).orElse(null);
   }

   private int I_method_6dd86774(ItemStack var1) {
      if (var1.getItem() instanceof ArmorItem var2) {
         ArmorMaterial var8 = ((iIiIiiIIi_Class346)var2).rockstar$getMaterial();
         EquipmentType var4 = ((iIiIiiIIi_Class346)var2).rockstar$getType();
         int var5 = var8.defense().getOrDefault(var4, 0);
         int var6 = (int)var8.toughness();
         int var7 = iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.PROTECTION);
         return var5 * 5 + var7 * 3 + var6;
      } else {
         return 0;
      }
   }

   private boolean I_method_6dd86785(ItemStack var1) {
      if (var1 != null && !var1.isEmpty()) {
         String var2 = var1.getName().getString();
         if (var2.contains("\u041f\u043e\u043f\u0440\u044b\u0433\u0443\u043d")) {
            return true;
         } else {
            try {
               for (Text var5 : var1.getTooltip(TooltipContext.create(I_field_3a9bda27.world), I_field_3a9bda27.player, TooltipType.BASIC)) {
                  String var6 = var5.getString();
                  if (var6.contains("\u041f\u043e\u043f\u0440\u044b\u0433\u0443\u043d")) {
                     return true;
                  }
               }
            } catch (Exception var7) {
            }

            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   public void onDisable() {
      this.I_field_5a = false;
   }

   static class Nested1_e4d21420 {
      int I_field_49;
      final iIIiIiIii_Class300 I_field_1242a2ac;
      final iIIiIiIii_Class300 i_field_1242a2ac;

      Nested1_e4d21420(iIIiIiIii_Class300 var1, iIIiIiIii_Class300 var2) {
         this.I_field_1242a2ac = var1;
         this.i_field_1242a2ac = var2;
      }
   }
}
