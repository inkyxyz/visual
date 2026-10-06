package pyrock.classes.settings;

import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import pyrock.classes.PyEspElement;
import pyrock.classes.PyHudElement;
import pyrock.classes.PyModule;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.MultiSelectSetting;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiIiiiiI_Class95;

public class PySelectSetting {
    private final MultiSelectSetting setting;

    public PySelectSetting(PyModule pyModule, String string) {
        this.setting = new MultiSelectSetting(pyModule.getModule(), string);
        if (!(pyModule.getModule() instanceof IiIiiiiI_Class95)) {
            IIiiIIiii_Class104.I_method_9fdd7f66(pyModule.getModule(), this.setting);
        }
    }

    public PySelectSetting(PyHudElement pyHudElement, String string) {
        this.setting = new MultiSelectSetting(pyHudElement, string);
    }

    public PySelectSetting(PyEspElement pyEspElement, String string) {
        this.setting = new MultiSelectSetting(pyEspElement.getElement(), string);
    }

    public PySelectSetting(MultiSelectSetting iIiiiiiii_Class128) {
        this.setting = iIiiiiiii_Class128;
    }

    public PySelectSetting add(String string) {
        if (this.has(string)) {
            return this;
        }
        IIiiIIiii_Class104.I_method_dacf28a7(this.setting);
        MultiSelectSetting.Nested1_42856060 nested1_42856060 = new MultiSelectSetting.Nested1_42856060(this.setting, string);
        IIiiIIiii_Class104.I_method_19f1b49a(this.setting, nested1_42856060);
        return this;
    }

    public boolean has(String string) {
        if (string == null) {
            return false;
        }
        for (MultiSelectSetting.Nested1_42856060 nested1_42856060 : this.setting.I_method_45aaa648()) {
            if (!string.equalsIgnoreCase(nested1_42856060.getName()) && !string.equalsIgnoreCase(IiIiIIII_Class81.I_method_f25a980a(nested1_42856060.getName()))) continue;
            return true;
        }
        return false;
    }

    public List<String> getValueLabels() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (MultiSelectSetting.Nested1_42856060 nested1_42856060 : this.setting.I_method_45aaa648()) {
            arrayList.add(IiIiIIII_Class81.I_method_f25a980a(nested1_42856060.getName()));
        }
        return arrayList;
    }

    public PySelectSetting select(String string) {
        IIiiIIiii_Class104.I_method_dacf28a7(this.setting);
        for (MultiSelectSetting.Nested1_42856060 nested1_42856060 : this.setting.I_method_45aaa648()) {
            if (!nested1_42856060.getName().equals(string)) continue;
            this.setting.i_method_bff19e42(nested1_42856060);
            break;
        }
        return this;
    }

    public PySelectSetting min(int n) {
        this.setting.I_method_702bd95a(n);
        return this;
    }

    public PySelectSetting draggable() {
        this.setting.I_method_bba86af5();
        return this;
    }

    public boolean isSelected(String string) {
        for (MultiSelectSetting.Nested1_42856060 nested1_42856060 : this.setting.i_method_faf6de68()) {
            if (!nested1_42856060.getName().equals(string)) continue;
            return true;
        }
        return false;
    }

    public List<String> getSelected() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (MultiSelectSetting.Nested1_42856060 nested1_42856060 : this.setting.i_method_faf6de68()) {
            arrayList.add(nested1_42856060.getName());
        }
        return arrayList;
    }

    public List<String> getValues() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (MultiSelectSetting.Nested1_42856060 nested1_42856060 : this.setting.I_method_45aaa648()) {
            arrayList.add(nested1_42856060.getName());
        }
        return arrayList;
    }

    @Generated
    public MultiSelectSetting getSetting() {
        return this.setting;
    }
}

