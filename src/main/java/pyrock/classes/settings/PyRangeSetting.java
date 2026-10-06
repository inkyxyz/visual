package pyrock.classes.settings;

import java.util.List;
import lombok.Generated;
import pyrock.classes.PyEspElement;
import pyrock.classes.PyHudElement;
import pyrock.classes.PyModule;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.RangeSetting;
import rockstar.client.IiIiiiiI_Class95;

public class PyRangeSetting {
    private final RangeSetting setting;

    public PyRangeSetting(PyModule pyModule, String string) {
        this.setting = new RangeSetting(pyModule.getModule(), string);
        this.setting.II_method_c7edb334(1.0f);
        this.setting.Ii_method_6506bb54(10.0f);
        this.setting.I_method_3944a7d7(3.0f);
        this.setting.i_method_d65daff7(7.0f);
        this.setting.iI_method_cdf5af14(1.0f);
        if (!(pyModule.getModule() instanceof IiIiiiiI_Class95)) {
            IIiiIIiii_Class104.I_method_9fdd7f66(pyModule.getModule(), this.setting);
        }
    }

    public PyRangeSetting(PyHudElement pyHudElement, String string) {
        this.setting = new RangeSetting(pyHudElement, string);
        this.setting.II_method_c7edb334(1.0f);
        this.setting.Ii_method_6506bb54(10.0f);
        this.setting.I_method_3944a7d7(3.0f);
        this.setting.i_method_d65daff7(7.0f);
        this.setting.iI_method_cdf5af14(1.0f);
    }

    public PyRangeSetting(PyEspElement pyEspElement, String string) {
        this.setting = new RangeSetting(pyEspElement.getElement(), string);
        this.setting.II_method_c7edb334(1.0f);
        this.setting.Ii_method_6506bb54(10.0f);
        this.setting.I_method_3944a7d7(3.0f);
        this.setting.i_method_d65daff7(7.0f);
        this.setting.iI_method_cdf5af14(1.0f);
    }

    public PyRangeSetting(RangeSetting iIiiiiiiI_Class127) {
        this.setting = iIiiiiiiI_Class127;
    }

    public PyRangeSetting min(double d) {
        this.setting.II_method_c7edb334((float)d);
        return this;
    }

    public PyRangeSetting max(double d) {
        this.setting.Ii_method_6506bb54((float)d);
        return this;
    }

    public PyRangeSetting step(double d) {
        this.setting.iI_method_cdf5af14((float)d);
        return this;
    }

    public PyRangeSetting first(double d) {
        IIiiIIiii_Class104.I_method_dacf28a7(this.setting);
        this.setting.I_method_3944a7d7((float)d);
        return this;
    }

    public PyRangeSetting second(double d) {
        IIiiIIiii_Class104.I_method_dacf28a7(this.setting);
        this.setting.i_method_d65daff7((float)d);
        return this;
    }

    public float getFirst() {
        return this.setting.i_method_e92b420f();
    }

    public float getSecond() {
        return this.setting.II_method_3a8908f2();
    }

    public float getMin() {
        return this.setting.Ii_method_3a9794d2();
    }

    public float getMax() {
        return this.setting.iI_method_3c4bf912();
    }

    public float getStep() {
        return this.setting.ii_method_3c5a84f2();
    }

    public List<Float> get() {
        return List.of(Float.valueOf(this.setting.i_method_e92b420f()), Float.valueOf(this.setting.II_method_3a8908f2()));
    }

    @Generated
    public RangeSetting getSetting() {
        return this.setting;
    }
}

