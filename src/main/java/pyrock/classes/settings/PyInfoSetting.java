package pyrock.classes.settings;

import lombok.Generated;
import pyrock.classes.PyEspElement;
import pyrock.classes.PyHudElement;
import pyrock.classes.PyModule;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.SectionSetting;
import rockstar.client.IiIiiiiI_Class95;

public class PyInfoSetting {
    private final SectionSetting setting;

    public PyInfoSetting(PyModule pyModule, String string) {
        this.setting = new SectionSetting(pyModule.getModule(), string);
        if (!(pyModule.getModule() instanceof IiIiiiiI_Class95)) {
            IIiiIIiii_Class104.I_method_9fdd7f66(pyModule.getModule(), this.setting);
        }
    }

    public PyInfoSetting(PyHudElement pyHudElement, String string) {
        this.setting = new SectionSetting(pyHudElement, string);
    }

    public PyInfoSetting(PyEspElement pyEspElement, String string) {
        this.setting = new SectionSetting(pyEspElement.getElement(), string);
    }

    public PyInfoSetting(SectionSetting iIiiiiIii_Class124) {
        this.setting = iIiiiiIii_Class124;
    }

    public PyInfoSetting level(int n) {
        this.setting.I_method_9505555a(n);
        return this;
    }

    public PyInfoSetting splitted() {
        this.setting.I_method_17a15b35();
        return this;
    }

    public PyInfoSetting centered() {
        this.setting.i_method_2d36cf15();
        return this;
    }

    @Generated
    public SectionSetting getSetting() {
        return this.setting;
    }
}

