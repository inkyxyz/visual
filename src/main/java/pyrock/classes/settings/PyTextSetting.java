package pyrock.classes.settings;

import lombok.Generated;
import pyrock.classes.PyEspElement;
import pyrock.classes.PyHudElement;
import pyrock.classes.PyModule;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.TextSetting;
import rockstar.client.IiIiiiiI_Class95;

public class PyTextSetting {
    private final TextSetting setting;

    public PyTextSetting(PyModule pyModule, String string) {
        this.setting = new TextSetting(pyModule.getModule(), string);
        this.setting.I_method_104de33f("");
        if (!(pyModule.getModule() instanceof IiIiiiiI_Class95)) {
            IIiiIIiii_Class104.I_method_9fdd7f66(pyModule.getModule(), this.setting);
        }
    }

    public PyTextSetting(PyHudElement pyHudElement, String string) {
        this.setting = new TextSetting(pyHudElement, string);
        this.setting.I_method_104de33f("");
    }

    public PyTextSetting(PyEspElement pyEspElement, String string) {
        this.setting = new TextSetting(pyEspElement.getElement(), string);
        this.setting.I_method_104de33f("");
    }

    public PyTextSetting(TextSetting iiIIIIIiI_Class131) {
        this.setting = iiIIIIIiI_Class131;
    }

    public PyTextSetting set(String string) {
        IIiiIIiii_Class104.I_method_dacf28a7(this.setting);
        this.setting.I_method_104de33f(string == null ? "" : string);
        return this;
    }

    public String get() {
        String string = this.setting.II_method_da016c1e();
        return string == null ? "" : string;
    }

    public PyTextSetting maxLength(int n) {
        this.setting.I_method_2dbacd5a(n);
        return this;
    }

    public PyTextSetting numberOnly(boolean bl) {
        this.setting.I_method_ec08f9eb(bl);
        return this;
    }

    public boolean isEmpty() {
        return this.get().isEmpty();
    }

    @Generated
    public TextSetting getSetting() {
        return this.setting;
    }
}

