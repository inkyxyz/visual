package pyrock.classes;

import java.util.List;
import lombok.Generated;
import pyrock.classes.PySetting;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.Setting;
import rockstar.client.ModuleEntry;
import rockstar.client.ModuleManager;
import rockstar.client.IiIiiiiI_Class95;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIiIiI_Class267;

public class PyModule {
    private final ModuleEntry module;
    private final String name;
    private final String category;

    public PyModule(String string, String string2) {
        this.name = string.trim();
        this.category = string2.trim();
        ModuleCategory iiIiiiii_Class96 = ModuleCategory.I_method_a9f2a441(this.category);
        if (iiIiiiii_Class96 == null) {
            iiIiiiii_Class96 = ModuleCategory.OTHER;
        }
        IiIiiiiI_Class95 iiIiiiiI_Class95 = new IiIiiiiI_Class95(this.name, iiIiiiii_Class96, -1);
        RockstarClient.getInstance().getModuleManager().getModules().add(iiIiiiiI_Class95);
        ModuleManager.I_method_7056a46c();
        IIiiIIiii_Class104.I_method_cc701ac0(iiIiiiiI_Class95);
        this.module = iiIiiiiI_Class95;
    }

    public PyModule(ModuleEntry iiIiiIii_Class92) {
        this.module = iiIiiIii_Class92;
        this.name = iiIiiIii_Class92.getName();
        this.category = iiIiiIii_Class92.getCategory().name();
    }

    public PySetting[] settings() {
        List<Setting> list = this.module.getSettings();
        PySetting[] pySettingArray = new PySetting[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            pySettingArray[i] = new PySetting(list.get(i));
        }
        return pySettingArray;
    }

    public PySetting[] settingsApi() {
        return this.settings();
    }

    public boolean isEnabled() {
        return this.module.isEnabled();
    }

    public PyModule setEnabled(boolean bl) {
        this.module.setEnabled(bl, false);
        return this;
    }

    public PyModule toggle() {
        this.module.toggle();
        return this;
    }

    public int getKey() {
        return this.module.getKeybind();
    }

    public String getKeyName() {
        return iIIIIiIiI_Class267.I_method_a937749c(this.module.getKeybind());
    }

    public PyModule setKey(int n) {
        this.module.setKeybind(n);
        return this;
    }

    public String getDesc() {
        return this.module.i_method_bf522194();
    }

    public PyModule setDesc(String string) {
        ModuleEntry iiIiiIii_Class92 = this.module;
        if (iiIiiIii_Class92 instanceof IiIiiiiI_Class95) {
            IiIiiiiI_Class95 iiIiiiiI_Class95 = (IiIiiiiI_Class95)iiIiiIii_Class92;
            iiIiiiiI_Class95.I_method_b9f3cf76(string);
        }
        return this;
    }

    @Generated
    public ModuleEntry getModule() {
        return this.module;
    }

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public String getCategory() {
        return this.category;
    }
}
