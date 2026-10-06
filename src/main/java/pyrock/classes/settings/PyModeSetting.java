package pyrock.classes.settings;

import java.util.List;
import lombok.Generated;
import pyrock.classes.PyEspElement;
import pyrock.classes.PyHudElement;
import pyrock.classes.PyModule;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.ModeSetting;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiIiiiiI_Class95;

public class PyModeSetting {
    private final ModeSetting setting;

    public PyModeSetting(PyModule pyModule, String string) {
        this.setting = new ModeSetting(pyModule.getModule(), string);
        if (!(pyModule.getModule() instanceof IiIiiiiI_Class95)) {
            IIiiIIiii_Class104.I_method_9fdd7f66(pyModule.getModule(), this.setting);
        }
    }

    public PyModeSetting(PyHudElement pyHudElement, String string) {
        this.setting = new ModeSetting(pyHudElement, string);
    }

    public PyModeSetting(PyEspElement pyEspElement, String string) {
        this.setting = new ModeSetting(pyEspElement.getElement(), string);
    }

    public PyModeSetting(ModeSetting iIiiiiiII_Class125) {
        this.setting = iIiiiiiII_Class125;
    }

    public PyModeSetting add(String string) {
        if (this.has(string)) {
            return this;
        }
        IIiiIIiii_Class104.I_method_dacf28a7(this.setting);
        ModeSetting.Nested1_42765c60 nested1_42765c60 = new ModeSetting.Nested1_42765c60(this.setting, string);
        IIiiIIiii_Class104.I_method_e79f349a(this.setting, nested1_42765c60);
        return this;
    }

    public boolean has(String string) {
        if (string == null) {
            return false;
        }
        for (ModeSetting.Nested1_42765c60 nested1_42765c60 : this.setting.I_method_e1d4a248()) {
            if (!string.equalsIgnoreCase(nested1_42765c60.getName()) && !string.equalsIgnoreCase(IiIiIIII_Class81.I_method_f25a980a(nested1_42765c60.getName()))) continue;
            return true;
        }
        return false;
    }

    public String[] options() {
        List<ModeSetting.Nested1_42765c60> list = this.setting.I_method_e1d4a248();
        String[] stringArray = new String[list.size()];
        for (int i = 0; i < stringArray.length; ++i) {
            stringArray[i] = list.get(i).getName();
        }
        return stringArray;
    }

    public String[] optionLabels() {
        String[] stringArray = this.options();
        String[] stringArray2 = new String[stringArray.length];
        for (int i = 0; i < stringArray.length; ++i) {
            stringArray2[i] = IiIiIIII_Class81.I_method_f25a980a(stringArray[i]);
        }
        return stringArray2;
    }

    public int modeIndex() {
        List<ModeSetting.Nested1_42765c60> list = this.setting.I_method_e1d4a248();
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) != this.setting.i_method_f85f3850()) continue;
            return i;
        }
        return -1;
    }

    public boolean isKey(String string) {
        ModeSetting.Nested1_42765c60 nested1_42765c60 = this.setting.i_method_f85f3850();
        if (nested1_42765c60 == null || string == null) {
            return false;
        }
        return string.equalsIgnoreCase(nested1_42765c60.getName()) || string.equalsIgnoreCase(IiIiIIII_Class81.I_method_f25a980a(nested1_42765c60.getName()));
    }

    public int count() {
        return this.setting.I_method_e1d4a248().size();
    }

    public PyModeSetting select(String string) {
        IIiiIIiii_Class104.I_method_dacf28a7(this.setting);
        for (ModeSetting.Nested1_42765c60 nested1_42765c60 : this.setting.I_method_e1d4a248()) {
            if (!nested1_42765c60.getName().equals(string)) continue;
            this.setting.i_method_89901e42(nested1_42765c60);
            break;
        }
        return this;
    }

    public String get() {
        return this.setting.i_method_f85f3850() != null ? this.setting.i_method_f85f3850().getName() : null;
    }

    public boolean is(String string) {
        return this.setting.i_method_f85f3850() != null && this.setting.i_method_f85f3850().getName().equals(string);
    }

    @Generated
    public ModeSetting getSetting() {
        return this.setting;
    }
}

