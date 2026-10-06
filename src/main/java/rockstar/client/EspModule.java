package rockstar.client;

import net.minecraft.client.gui.screen.Screen;
import rockstar.client.ButtonSetting;
import rockstar.client.ModuleCategory;
import rockstar.client.ModuleInfo;
import rockstar.client.IiiiiIIi_Class122;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="ESP", category=ModuleCategory.VISUALS, iI_method_476ab839=true, III_method_a89e5834="modules.descriptions.esp")
public class EspModule
extends Module {
    private ButtonSetting I_field_bbd4b28c;

    public EspModule() {
        this.IiI_method_c8a65edf();
    }

    @Compile(obfuscation=4)
    private void IiI_method_c8a65edf() {
        this.I_field_bbd4b28c = new ButtonSetting(this, "modules.settings.esp.open_menu").I_method_f05556b3(() -> I_field_3a9bda27.setScreen((Screen)new IiiiiIIi_Class122()));
    }
}

