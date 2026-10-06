package pyrock.classes.settings;

import java.util.List;
import lombok.Generated;
import net.minecraft.util.math.Vec2f;
import pyrock.classes.PyEspElement;
import pyrock.classes.PyHudElement;
import pyrock.classes.PyModule;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.Vector2Setting;
import rockstar.client.IiIiiiiI_Class95;
import rockstar.client.IiiiIiiII_Class237;

public class PyBezierSetting {
    private final Vector2Setting setting;

    public PyBezierSetting(PyModule pyModule, String string) {
        this.setting = new Vector2Setting(pyModule.getModule(), string);
        if (!(pyModule.getModule() instanceof IiIiiiiI_Class95)) {
            IIiiIIiii_Class104.I_method_9fdd7f66(pyModule.getModule(), this.setting);
        }
    }

    public PyBezierSetting(PyHudElement pyHudElement, String string) {
        this.setting = new Vector2Setting(pyHudElement, string);
    }

    public PyBezierSetting(PyEspElement pyEspElement, String string) {
        this.setting = new Vector2Setting(pyEspElement.getElement(), string);
    }

    public PyBezierSetting(Vector2Setting iIiiiIiII_Class117) {
        this.setting = iIiiiIiII_Class117;
    }

    public PyBezierSetting start(double d, double d2) {
        IIiiIIiii_Class104.I_method_dacf28a7(this.setting);
        this.setting.I_method_d8522ef5((float)d, (float)d2);
        return this;
    }

    public PyBezierSetting end(double d, double d2) {
        IIiiIIiii_Class104.I_method_dacf28a7(this.setting);
        this.setting.i_method_de5a2ad5((float)d, (float)d2);
        return this;
    }

    public List<Float> getStart() {
        Vec2f vec2f = this.setting.I_method_7430e9b6();
        return List.of(Float.valueOf(vec2f.x), Float.valueOf(vec2f.y));
    }

    public List<Float> getEnd() {
        Vec2f vec2f = this.setting.i_method_18296d96();
        return List.of(Float.valueOf(vec2f.x), Float.valueOf(vec2f.y));
    }

    public float ease(double d) {
        float f = (float)Math.max(0.0, Math.min(1.0, d));
        IiiiIiiII_Class237 iiiiIiiII_Class237 = this.setting.I_method_71834715();
        return iiiiIiiII_Class237 == null ? f : iiiiIiiII_Class237.ease(f, 0.0f, 1.0f, 1.0f);
    }

    public float interpolate(double d, double d2, double d3) {
        return (float)(d + (d2 - d) * (double)this.ease(d3));
    }

    @Generated
    public Vector2Setting getSetting() {
        return this.setting;
    }
}

