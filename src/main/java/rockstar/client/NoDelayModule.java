package rockstar.client;

import lombok.Generated;
import moscow.rockstar.mixin.minecraft.client.IMinecraftClient;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.BooleanSetting;
import rockstar.client.SliderSetting;
import rockstar.client.ModuleCategory;
import rockstar.client.ModuleInfo;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="No Delay", category=ModuleCategory.PLAYER, III_method_a89e5834="modules.descriptions.no_delay")
public class NoDelayModule
extends Module {
    private BooleanSetting I_field_ba20ca4c;
    private BooleanSetting i_field_ba20ca4c;
    private SliderSetting I_field_73178e8c;
    private BooleanSetting II_field_ba20ca4c;
    private BooleanSetting Ii_field_ba20ca4c;

    public NoDelayModule() {
        this.IiI_method_5dee3edf();
    }

    @Compile(obfuscation=4)
    private void IiI_method_5dee3edf() {
        this.I_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "modules.settings.no_delay.jump", "modules.settings.no_delay.jump.description").I_method_decd82b5();
        this.i_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "modules.settings.no_delay.right_click", "modules.settings.no_delay.right_click.description");
        this.I_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.no_delay.right_click_delay", () -> !this.i_field_ba20ca4c.i_method_9b12da03()).I_method_c8c9a7d7(1.0f).i_method_65e2aff7(100.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(1.0f).I_method_d41e7abf(" ms");
        this.II_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "modules.settings.no_delay.exp", this.i_field_ba20ca4c::i_method_9b12da03);
        this.Ii_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "modules.settings.no_delay.potions", this.i_field_ba20ca4c::i_method_9b12da03);
    }

    @Override
    public void II_method_6642fd22() {
        if (this.i_field_ba20ca4c.i_method_9b12da03()) {
            IMinecraftClient iMinecraftClient = (IMinecraftClient)I_field_3a9bda27;
            int n = this.II_method_d16c44d5();
            if (iMinecraftClient.getUseCooldown() > n) {
                iMinecraftClient.setUseCooldown(n);
            }
        }
        if (this.II_field_ba20ca4c.i_method_9b12da03() && (NoDelayModule.I_field_3a9bda27.player.getMainHandStack().getItem() == Items.EXPERIENCE_BOTTLE || NoDelayModule.I_field_3a9bda27.player.getOffHandStack().getItem() == Items.EXPERIENCE_BOTTLE)) {
            ((IMinecraftClient)I_field_3a9bda27).setUseCooldown(0);
        }
        if (this.Ii_field_ba20ca4c.i_method_9b12da03() && (this.I_method_723b420b(NoDelayModule.I_field_3a9bda27.player.getMainHandStack().getItem()) || this.I_method_723b420b(NoDelayModule.I_field_3a9bda27.player.getOffHandStack().getItem()))) {
            ((IMinecraftClient)I_field_3a9bda27).setUseCooldown(0);
        }
        super.II_method_6642fd22();
    }

    private boolean I_method_723b420b(Item item) {
        return item == Items.POTION || item == Items.GLASS_BOTTLE;
    }

    public int II_method_d16c44d5() {
        return Math.max(1, (int)Math.ceil(this.I_field_73178e8c.Ii_method_a20abcd2() / 50.0f));
    }

    @Generated
    public BooleanSetting I_method_46ab5f15() {
        return this.I_field_ba20ca4c;
    }

    @Generated
    public BooleanSetting i_method_5c40d2f5() {
        return this.i_field_ba20ca4c;
    }

    @Generated
    public SliderSetting I_method_ffa22355() {
        return this.I_field_73178e8c;
    }

    @Generated
    public BooleanSetting II_method_3d5537d8() {
        return this.II_field_ba20ca4c;
    }

    @Generated
    public BooleanSetting Ii_method_52eaabb8() {
        return this.Ii_field_ba20ca4c;
    }
}

