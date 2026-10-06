package pyrock.classes.settings;

import lombok.Generated;
import pyrock.classes.PyEspElement;
import pyrock.classes.PyHudElement;
import pyrock.classes.PyModule;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.SliderSetting;
import rockstar.client.IiIiiiiI_Class95;

public class PySliderSetting {
    private final SliderSetting setting;

    public PySliderSetting(PyModule pyModule, String string) {
        this.setting = new SliderSetting(pyModule.getModule(), string);
        this.setting.I_method_c8c9a7d7(1.0f);
        this.setting.i_method_65e2aff7(10.0f);
        this.setting.Ii_method_4e0e6b54(5.0f);
        this.setting.II_method_b0f56334(1.0f);
        if (!(pyModule.getModule() instanceof IiIiiiiI_Class95)) {
            IIiiIIiii_Class104.I_method_9fdd7f66(pyModule.getModule(), this.setting);
        }
    }

    public PySliderSetting(PyHudElement pyHudElement, String string) {
        this.setting = new SliderSetting(pyHudElement, string);
        this.setting.I_method_c8c9a7d7(1.0f);
        this.setting.i_method_65e2aff7(10.0f);
        this.setting.Ii_method_4e0e6b54(5.0f);
        this.setting.II_method_b0f56334(1.0f);
    }

    public PySliderSetting(PyEspElement pyEspElement, String string) {
        this.setting = new SliderSetting(pyEspElement.getElement(), string);
        this.setting.I_method_c8c9a7d7(1.0f);
        this.setting.i_method_65e2aff7(10.0f);
        this.setting.Ii_method_4e0e6b54(5.0f);
        this.setting.II_method_b0f56334(1.0f);
    }

    public PySliderSetting(SliderSetting iiIIIIIIi_Class130) {
        this.setting = iiIIIIIIi_Class130;
    }

    public PySliderSetting min(double d) {
        this.setting.I_method_c8c9a7d7((float)d);
        return this;
    }

    public PySliderSetting max(double d) {
        this.setting.i_method_65e2aff7((float)d);
        return this;
    }

    public PySliderSetting step(double d) {
        this.setting.II_method_b0f56334((float)d);
        return this;
    }

    public PySliderSetting set(double d) {
        IIiiIIiii_Class104.I_method_dacf28a7(this.setting);
        this.setting.Ii_method_4e0e6b54((float)d);
        return this;
    }

    public PySliderSetting suffix(String string) {
        this.setting.I_method_d41e7abf(string);
        return this;
    }

    public float get() {
        return this.setting.Ii_method_a20abcd2();
    }

    public float getMin() {
        return this.setting.I_method_b2a48e2f();
    }

    public float getMax() {
        return this.setting.i_method_b2b31a0f();
    }

    public float getStep() {
        return this.setting.II_method_a1fc30f2();
    }

    @Generated
    public SliderSetting getSetting() {
        return this.setting;
    }
}

