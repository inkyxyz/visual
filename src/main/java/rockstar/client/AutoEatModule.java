package rockstar.client;

import moscow.rockstar.mixin.minecraft.client.IMinecraftClient;
import net.minecraft.component.DataComponentTypes;
import pyrock.events.player.ClientPlayerTickEvent;
import rockstar.client.SliderSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.ModuleInfo;
import rockstar.client.iIIiIiIii_Class300;
import rockstar.client.iIIiiIiII_Class309;
import rockstar.client.iIIiiIiIi_Class310;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Auto Eat", category=ModuleCategory.PLAYER)
public class AutoEatModule
extends Module {
    private boolean I_field_5a;
    private SliderSetting I_field_73178e8c;
    private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = clientPlayerTickEvent -> {
        if ((float)AutoEatModule.I_field_3a9bda27.player.getHungerManager().getFoodLevel() <= this.I_field_73178e8c.Ii_method_a20abcd2()) {
            iIIiiIiII_Class309<iIIiIiIii_Class300> iIIiiIiII_Class3092 = iIIiiIiIi_Class310.i_method_7fde0a75().I_method_fdeecb5d(iIIiiIiIi_Class310.I_method_6a489695());
            iIIiIiIii_Class300 iIIiIiIii_Class3002 = iIIiiIiII_Class3092.I_method_77fa4424(itemStack -> itemStack.getItem().getDefaultStack().contains(DataComponentTypes.FOOD));
            if (!AutoEatModule.I_field_3a9bda27.player.getOffHandStack().contains(DataComponentTypes.FOOD) && iIIiIiIii_Class3002 != null) {
                iIIiIiIii_Class3002.I_method_dfe8925f();
            }
            this.I_field_5a = true;
            if (AutoEatModule.I_field_3a9bda27.currentScreen != null && !AutoEatModule.I_field_3a9bda27.player.isUsingItem()) {
                ((IMinecraftClient)I_field_3a9bda27).idoItemUse();
            } else {
                AutoEatModule.I_field_3a9bda27.options.useKey.setPressed(true);
            }
        } else if (this.I_field_5a) {
            this.I_field_5a = false;
            AutoEatModule.I_field_3a9bda27.options.useKey.setPressed(false);
        }
    };

    public AutoEatModule() {
        this.IiI_method_83c21a9f();
    }

    @Compile(obfuscation=4)
    private void IiI_method_83c21a9f() {
        this.I_field_73178e8c = new SliderSetting(this, "modules.settings.auto_eat.food").II_method_b0f56334(1.0f).I_method_c8c9a7d7(1.0f).i_method_65e2aff7(20.0f).Ii_method_4e0e6b54(15.0f);
    }
}

