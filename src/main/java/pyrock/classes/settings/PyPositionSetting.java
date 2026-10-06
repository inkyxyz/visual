package pyrock.classes.settings;

import java.util.List;
import lombok.Generated;
import pyrock.classes.PyEspElement;
import pyrock.classes.PyHudElement;
import pyrock.classes.PyModule;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.VectorRangeSetting;
import rockstar.client.IiIiiiiI_Class95;

public class PyPositionSetting {
    private final VectorRangeSetting setting;

    public PyPositionSetting(PyModule pyModule, String string) {
        this.setting = new VectorRangeSetting(pyModule.getModule(), string);
        if (!(pyModule.getModule() instanceof IiIiiiiI_Class95)) {
            IIiiIIiii_Class104.I_method_9fdd7f66(pyModule.getModule(), this.setting);
        }
    }

    public PyPositionSetting(PyHudElement pyHudElement, String string) {
        this.setting = new VectorRangeSetting(pyHudElement, string);
    }

    public PyPositionSetting(PyEspElement pyEspElement, String string) {
        this.setting = new VectorRangeSetting(pyEspElement.getElement(), string);
    }

    public PyPositionSetting(VectorRangeSetting iIiiiiiIi_Class126) {
        this.setting = iIiiiiiIi_Class126;
    }

    public PyPositionSetting set(double d, double d2) {
        IIiiIIiii_Class104.I_method_dacf28a7(this.setting);
        this.setting.I_method_f30816f5((float)d, (float)d2);
        return this;
    }

    public PyPositionSetting x(double d) {
        IIiiIIiii_Class104.I_method_dacf28a7(this.setting);
        this.setting.I_method_50432fd7((float)d);
        return this;
    }

    public PyPositionSetting y(double d) {
        IIiiIIiii_Class104.I_method_dacf28a7(this.setting);
        this.setting.i_method_ed5c37f7((float)d);
        return this;
    }

    public float getX() {
        return this.setting.I_method_82f061ef();
    }

    public float getY() {
        return this.setting.i_method_82feedcf();
    }

    public List<Float> get() {
        return List.of(Float.valueOf(this.setting.I_method_82f061ef()), Float.valueOf(this.setting.i_method_82feedcf()));
    }

    public PyPositionSetting bounds(double d, double d2, double d3, double d4) {
        this.setting.II_method_90cdcab4((float)d).iI_method_96d5c694((float)d2).Ii_method_2de6d2d4((float)d3).ii_method_33eeceb4((float)d4);
        return this;
    }

    public float getMinX() {
        return this.setting.II_method_db2ad532();
    }

    public float getMaxX() {
        return this.setting.Ii_method_db396112();
    }

    public float getMinY() {
        return this.setting.iI_method_dcedc552();
    }

    public float getMaxY() {
        return this.setting.ii_method_dcfc5132();
    }

    @Generated
    public VectorRangeSetting getSetting() {
        return this.setting;
    }
}

