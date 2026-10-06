package pyrock.classes.settings;

import java.util.Locale;
import lombok.Generated;
import pyrock.classes.PyEspElement;
import pyrock.classes.PyHudElement;
import pyrock.classes.PyModule;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.TimeSetting;
import rockstar.client.IiIiiiiI_Class95;

public class PyTimeSetting {
    private final TimeSetting setting;

    public PyTimeSetting(PyModule pyModule, String string) {
        this.setting = new TimeSetting(pyModule.getModule(), string);
        if (!(pyModule.getModule() instanceof IiIiiiiI_Class95)) {
            IIiiIIiii_Class104.I_method_9fdd7f66(pyModule.getModule(), this.setting);
        }
    }

    public PyTimeSetting(PyHudElement pyHudElement, String string) {
        this.setting = new TimeSetting(pyHudElement, string);
    }

    public PyTimeSetting(PyEspElement pyEspElement, String string) {
        this.setting = new TimeSetting(pyEspElement.getElement(), string);
    }

    public PyTimeSetting(TimeSetting iiIIIIIii_Class132) {
        this.setting = iiIIIIIii_Class132;
    }

    public PyTimeSetting set(int n) {
        IIiiIIiii_Class104.I_method_dacf28a7(this.setting);
        this.setting.I_method_9e134884(n);
        return this;
    }

    public int get() {
        return this.setting.III_method_2626c6b2();
    }

    public long millis() {
        return this.setting.I_method_4f6bf653();
    }

    public int ticks() {
        return this.setting.Ii_method_9e3058b5();
    }

    public String formatted() {
        return this.setting.II_method_5a3347fe();
    }

    public int hours() {
        return this.setting.I_method_4f6bf652();
    }

    public int minutes() {
        return this.setting.i_method_4f7a8232();
    }

    public int seconds() {
        return this.setting.II_method_9e21ccd5();
    }

    public PyTimeSetting units(String string) {
        this.setting.I_method_8013ade1(PyTimeSetting.unit(string));
        return this;
    }

    public PyTimeSetting units(String string, String string2) {
        this.setting.I_method_8013ade1(PyTimeSetting.unit(string), PyTimeSetting.unit(string2));
        return this;
    }

    public PyTimeSetting units(String string, String string2, String string3) {
        this.setting.I_method_8013ade1(PyTimeSetting.unit(string), PyTimeSetting.unit(string2), PyTimeSetting.unit(string3));
        return this;
    }

    public PyTimeSetting unit(String string, boolean bl) {
        switch (PyTimeSetting.unit(string)) {
            case I_field_d30be67: {
                this.setting.I_method_a7007deb(bl);
                break;
            }
            case i_field_d30be67: {
                this.setting.i_method_4419860b(bl);
                break;
            }
            case II_field_d30be67: {
                this.setting.II_method_c64bad88(bl);
            }
        }
        return this;
    }

    public PyTimeSetting maxHours(int n) {
        this.setting.I_method_e8b2515a(n);
        return this;
    }

    public PyTimeSetting maxMinutes(int n) {
        this.setting.i_method_85cb597a(n);
        return this;
    }

    private static TimeSetting.Nested1_71da9c20 unit(String string) {
        String string2;
        return switch (string2 = string == null ? "" : string.trim().toLowerCase(Locale.ROOT)) {
            case "h", "hour", "hours", "\u0447\u0430\u0441", "\u0447\u0430\u0441\u044b" -> TimeSetting.Nested1_71da9c20.I_field_d30be67;
            case "s", "sec", "second", "seconds", "\u0441\u0435\u043a", "\u0441\u0435\u043a\u0443\u043d\u0434\u044b" -> TimeSetting.Nested1_71da9c20.II_field_d30be67;
            default -> TimeSetting.Nested1_71da9c20.i_field_d30be67;
        };
    }

    @Generated
    public TimeSetting getSetting() {
        return this.setting;
    }
}

