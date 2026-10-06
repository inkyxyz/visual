package pyrock.classes.settings;

import lombok.Generated;
import pyrock.classes.PyEspElement;
import pyrock.classes.PyHudElement;
import pyrock.classes.PyModule;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.ColorSetting;
import rockstar.client.IiIiiiiI_Class95;

public class PyColorSetting {
    private final ColorSetting setting;

    public PyColorSetting(PyModule pyModule, String string) {
        this.setting = new ColorSetting(pyModule.getModule(), string);
        this.setting.I_method_a62f5dd6(new ColorRGBA(255.0f, 255.0f, 255.0f, 255.0f));
        this.setting.I_method_af5a85eb(true);
        if (!(pyModule.getModule() instanceof IiIiiiiI_Class95)) {
            IIiiIIiii_Class104.I_method_9fdd7f66(pyModule.getModule(), this.setting);
        }
    }

    public PyColorSetting(PyHudElement pyHudElement, String string) {
        this.setting = new ColorSetting(pyHudElement, string);
        this.setting.I_method_a62f5dd6(new ColorRGBA(255.0f, 255.0f, 255.0f, 255.0f));
        this.setting.I_method_af5a85eb(true);
    }

    public PyColorSetting(PyEspElement pyEspElement, String string) {
        this.setting = new ColorSetting(pyEspElement.getElement(), string);
        this.setting.I_method_a62f5dd6(new ColorRGBA(255.0f, 255.0f, 255.0f, 255.0f));
        this.setting.I_method_af5a85eb(true);
    }

    public PyColorSetting(ColorSetting iIiiiiIIi_Class122) {
        this.setting = iIiiiiIIi_Class122;
    }

    public PyColorSetting color(ColorRGBA colorRGBA) {
        IIiiIIiii_Class104.I_method_dacf28a7(this.setting);
        this.setting.I_method_a62f5dd6(colorRGBA);
        return this;
    }

    public PyColorSetting color(int n, int n2, int n3, int n4) {
        IIiiIIiii_Class104.I_method_dacf28a7(this.setting);
        this.setting.I_method_a62f5dd6(new ColorRGBA(n, n2, n3, n4));
        return this;
    }

    public PyColorSetting color(int n, int n2, int n3) {
        IIiiIIiii_Class104.I_method_dacf28a7(this.setting);
        this.setting.I_method_a62f5dd6(new ColorRGBA(n, n2, n3, 255.0f));
        return this;
    }

    public PyColorSetting alpha(boolean bl) {
        this.setting.I_method_af5a85eb(bl);
        return this;
    }

    public ColorRGBA get() {
        return this.setting.I_method_bde5f08e();
    }

    public boolean hasAlpha() {
        return this.setting.i_method_9b12da03();
    }

    @Generated
    public ColorSetting getSetting() {
        return this.setting;
    }
}

