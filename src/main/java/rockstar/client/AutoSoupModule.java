package rockstar.client;

import java.util.List;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import rockstar.client.SliderSetting;
import rockstar.client.ModuleCategory;
import rockstar.client.ModuleInfo;
import rockstar.client.iIIiIiIiI_Class299;
import rockstar.client.iIIiiIiIi_Class310;
import rockstar.client.iIIiiiIii_Class316;
import rockstar.client.iIIiiiiII_Class317;
import rockstar.client.Module;
import rockstar.client.iiIiIIiii_Class424;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Auto Soup", category=ModuleCategory.COMBAT)
public class AutoSoupModule
extends Module {
    int I_field_49 = -1;
    int i_field_49 = -1;
    int II_field_49 = -1;
    private SliderSetting I_field_73178e8c;
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();

    public AutoSoupModule() {
        this.IiI_method_e42049ec();
    }

    @Compile(obfuscation=4)
    private void IiI_method_e42049ec() {
        this.I_field_73178e8c = new SliderSetting(this, "modules.settings.auto_soup.health").II_method_b0f56334(1.0f).I_method_c8c9a7d7(1.0f).i_method_65e2aff7(20.0f).Ii_method_4e0e6b54(10.0f);
    }

    @Override
    public void II_method_6642fd22() {
        if (this.II_field_49 >= 0) {
            if (this.II_field_49 == 2) {
                AutoSoupModule.I_field_3a9bda27.player.getInventory().selectedSlot = this.i_field_49;
            } else if (this.II_field_49 == 1) {
                AutoSoupModule.I_field_3a9bda27.interactionManager.interactItem((PlayerEntity)AutoSoupModule.I_field_3a9bda27.player, Hand.MAIN_HAND);
            } else if (this.II_field_49 == 0) {
                AutoSoupModule.I_field_3a9bda27.player.dropSelectedItem(true);
                AutoSoupModule.I_field_3a9bda27.player.getInventory().selectedSlot = this.I_field_49;
            }
            --this.II_field_49;
            return;
        }
        if (AutoSoupModule.I_field_3a9bda27.player.getHealth() >= this.I_field_73178e8c.Ii_method_a20abcd2() || !this.I_field_991c1e8c.I_method_58432069(300L)) {
            return;
        }
        iIIiiiIii_Class316 iIIiiiIii_Class3162 = iIIiiIiIi_Class310.I_method_6a489695().I_method_5d34dd7d(Items.MUSHROOM_STEW);
        if (iIIiiiIii_Class3162 != null) {
            this.I_field_49 = AutoSoupModule.I_field_3a9bda27.player.getInventory().selectedSlot;
            AutoSoupModule.I_field_3a9bda27.player.getInventory().selectedSlot = this.i_field_49 = iIIiiiIii_Class3162.II_method_b9cf08f5();
            this.II_field_49 = 1;
        } else {
            List<iIIiiiiII_Class317> list = iIIiiIiIi_Class310.i_method_7fde0a75().I_method_fe8cb900(Items.MUSHROOM_STEW);
            List<iIIiiiIii_Class316> list2 = iIIiiIiIi_Class310.I_method_6a489695().I_method_144f4b9(ItemStack::isEmpty);
            if (!list.isEmpty() && !list2.isEmpty()) {
                int n = Math.min(list.size(), list2.size());
                n = Math.min(n, 8);
                for (int i = 0; i < n; ++i) {
                    iIIiiiiII_Class317 iIIiiiiII_Class3172 = list.get(i);
                    iIIiiiIii_Class316 iIIiiiIii_Class3163 = list2.get(i);
                    iIIiIiIiI_Class299.iI_method_c617e8c2(iIIiiiiII_Class3172.I_method_dfe89252(), iIIiiiIii_Class3163.II_method_b9cf08f5());
                }
                this.I_field_49 = AutoSoupModule.I_field_3a9bda27.player.getInventory().selectedSlot;
                this.i_field_49 = list2.get(0).II_method_b9cf08f5();
                this.II_field_49 = 2;
            }
        }
        this.I_field_991c1e8c.I_method_23e11e3f();
    }
}

