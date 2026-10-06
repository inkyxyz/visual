package pyrock.classes.settings;

import lombok.Generated;
import pyrock.classes.PyEspElement;
import pyrock.classes.PyHudElement;
import pyrock.classes.PyModule;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.KeybindSetting;
import rockstar.client.IiIiiiiI_Class95;
import rockstar.client.iIIIIIIIi_Class258;
import rockstar.client.iIIIIiIiI_Class267;

public class PyBindSetting {
    private final KeybindSetting setting;

    public PyBindSetting(PyModule pyModule, String string) {
        this.setting = new KeybindSetting(pyModule.getModule(), string);
        if (!(pyModule.getModule() instanceof IiIiiiiI_Class95)) {
            IIiiIIiii_Class104.I_method_9fdd7f66(pyModule.getModule(), this.setting);
        }
    }

    public PyBindSetting(PyHudElement pyHudElement, String string) {
        this.setting = new KeybindSetting(pyHudElement, string);
    }

    public PyBindSetting(PyEspElement pyEspElement, String string) {
        this.setting = new KeybindSetting(pyEspElement.getElement(), string);
    }

    public PyBindSetting(KeybindSetting iIiiiIiIi_Class118) {
        this.setting = iIiiiIiIi_Class118;
    }

    public PyBindSetting set(Object object) {
        IIiiIIiii_Class104.I_method_dacf28a7(this.setting);
        this.setting.I_method_51ee2d04(PyBindSetting.toCode(object));
        return this;
    }

    public PyBindSetting clear() {
        return this.set(-1);
    }

    public int get() {
        return this.setting.I_method_fa6281d2();
    }

    public String name() {
        return iIIIIiIiI_Class267.I_method_a937749c(this.setting.I_method_fa6281d2());
    }

    public boolean isSet() {
        return this.setting.I_method_fa6281d2() != -1;
    }

    public boolean isKey(Object object) {
        return this.setting.I_method_51ee2d08(PyBindSetting.toCode(object));
    }

    public boolean matches(Object object) {
        return this.isKey(object);
    }

    static int toCode(Object object) {
        if (object instanceof Number) {
            Number number = (Number)object;
            return number.intValue();
        }
        if (object == null) {
            return -1;
        }
        return iIIIIIIIi_Class258.I_method_dc7f39fc(object.toString());
    }

    @Generated
    public KeybindSetting getSetting() {
        return this.setting;
    }
}

