package pyrock.classes.settings;

import lombok.Generated;
import pyrock.classes.PyEspElement;
import pyrock.classes.PyHudElement;
import pyrock.classes.PyModule;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.GradientColorSetting;
import rockstar.client.IiIiiiiI_Class95;

public class PyGradientSetting {
    private final GradientColorSetting setting;

    public PyGradientSetting(PyModule pyModule, String string) {
        this.setting = new GradientColorSetting(pyModule.getModule(), string);
        this.defaults();
        if (!(pyModule.getModule() instanceof IiIiiiiI_Class95)) {
            IIiiIIiii_Class104.I_method_9fdd7f66(pyModule.getModule(), this.setting);
        }
    }

    public PyGradientSetting(PyHudElement pyHudElement, String string) {
        this.setting = new GradientColorSetting(pyHudElement, string);
        this.defaults();
    }

    public PyGradientSetting(PyEspElement pyEspElement, String string) {
        this.setting = new GradientColorSetting(pyEspElement.getElement(), string);
        this.defaults();
    }

    public PyGradientSetting(GradientColorSetting iIiiiiIiI_Class123) {
        this.setting = iIiiiiIiI_Class123;
    }

    private void defaults() {
        this.setting.I_method_1119eb95(new ColorRGBA(255.0f, 255.0f, 255.0f, 255.0f), new ColorRGBA(255.0f, 255.0f, 255.0f, 255.0f));
        this.setting.I_method_985bfdeb(true);
    }

    public PyGradientSetting set(ColorRGBA colorRGBA, ColorRGBA colorRGBA2) {
        IIiiIIiii_Class104.I_method_dacf28a7(this.setting);
        this.setting.I_method_1119eb95(colorRGBA, colorRGBA2);
        return this;
    }

    public PyGradientSetting first(ColorRGBA colorRGBA) {
        IIiiIIiii_Class104.I_method_dacf28a7(this.setting);
        this.setting.I_method_3431d5d6(colorRGBA);
        return this;
    }

    public PyGradientSetting second(ColorRGBA colorRGBA) {
        IIiiIIiii_Class104.I_method_dacf28a7(this.setting);
        this.setting.i_method_a6225df6(colorRGBA);
        return this;
    }

    public ColorRGBA getFirst() {
        return this.setting.I_method_b3b144ce();
    }

    public ColorRGBA getSecond() {
        return this.setting.i_method_3b9850ae();
    }

    public ColorRGBA at(double d) {
        float f = (float)Math.max(0.0, Math.min(1.0, d));
        return this.getFirst().mix(this.getSecond(), f);
    }

    public PyGradientSetting alpha(boolean bl) {
        this.setting.I_method_985bfdeb(bl);
        return this;
    }

    public boolean hasAlpha() {
        return this.setting.i_method_9b12da03();
    }

    @Generated
    public GradientColorSetting getSetting() {
        return this.setting;
    }
}

