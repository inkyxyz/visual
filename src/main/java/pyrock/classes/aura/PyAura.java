package pyrock.classes.aura;

import java.util.ArrayList;
import jep.python.PyCallable;
import net.minecraft.entity.Entity;
import pyrock.classes.aura.PyRotationMode;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.ModeSetting;
import rockstar.client.RockstarClient;
import rockstar.client.AuraModule;

public class PyAura {
    private AuraModule aura() {
        return RockstarClient.getInstance().getModuleManager().getModule(AuraModule.class);
    }

    private ModeSetting rotationMode() {
        return this.aura().I_method_497abf22();
    }

    public PyRotationMode addRotation(String string, PyCallable pyCallable, PyCallable pyCallable2, PyCallable pyCallable3, PyCallable pyCallable4, PyCallable pyCallable5) {
        ModeSetting iIiiiiiII_Class125 = this.rotationMode();
        IIiiIIiii_Class104.I_method_dacf28a7(iIiiiiiII_Class125);
        PyRotationMode pyRotationMode = new PyRotationMode(iIiiiiiII_Class125, string, pyCallable, pyCallable2, pyCallable3, pyCallable4, pyCallable5);
        IIiiIIiii_Class104.I_method_e79f349a(iIiiiiiII_Class125, pyRotationMode);
        return pyRotationMode;
    }

    public void selectRotation(String string) {
        ModeSetting iIiiiiiII_Class125 = this.rotationMode();
        for (ModeSetting.Nested1_42765c60 nested1_42765c60 : iIiiiiiII_Class125.I_method_e1d4a248()) {
            if (!nested1_42765c60.getName().equals(string)) continue;
            iIiiiiiII_Class125.i_method_89901e42(nested1_42765c60);
            return;
        }
    }

    public void removeRotation(String string) {
        ModeSetting iIiiiiiII_Class125 = this.rotationMode();
        ArrayList<PyRotationMode> arrayList = new ArrayList<PyRotationMode>();
        for (ModeSetting.Nested1_42765c60 nested1_42765c60 : iIiiiiiII_Class125.I_method_e1d4a248()) {
            if (!(nested1_42765c60 instanceof PyRotationMode)) continue;
            PyRotationMode pyRotationMode = (PyRotationMode)nested1_42765c60;
            if (!nested1_42765c60.getName().equals(string) || !IIiiIIiii_Class104.I_method_e79f349e(iIiiiiiII_Class125, nested1_42765c60)) continue;
            arrayList.add(pyRotationMode);
        }
        for (PyRotationMode pyRotationMode : arrayList) {
            this.removeRotation(pyRotationMode);
        }
    }

    public void removeRotation(PyRotationMode pyRotationMode) {
        if (pyRotationMode == null) {
            return;
        }
        ModeSetting iIiiiiiII_Class125 = this.rotationMode();
        if (!IIiiIIiii_Class104.I_method_e79f349e(iIiiiiiII_Class125, pyRotationMode)) {
            return;
        }
        boolean bl = iIiiiiiII_Class125.i_method_f85f3850() == pyRotationMode;
        iIiiiiiII_Class125.I_method_e1d4a248().remove(pyRotationMode);
        IIiiIIiii_Class104.i_method_a818a07a(iIiiiiiII_Class125, pyRotationMode);
        if (bl) {
            iIiiiiiII_Class125.i_method_89901e42(iIiiiiiII_Class125.I_method_e1d4a248().isEmpty() ? null : iIiiiiiII_Class125.I_method_e1d4a248().getFirst());
        }
    }

    public boolean hasRotation(String string) {
        for (ModeSetting.Nested1_42765c60 nested1_42765c60 : this.rotationMode().I_method_e1d4a248()) {
            if (!nested1_42765c60.getName().equals(string)) continue;
            return true;
        }
        return false;
    }

    public String currentRotation() {
        ModeSetting.Nested1_42765c60 nested1_42765c60 = this.rotationMode().i_method_f85f3850();
        return nested1_42765c60 == null ? null : nested1_42765c60.getName();
    }

    public boolean isEnabled() {
        return this.aura().isEnabled();
    }

    public void setEnabled(boolean bl) {
        this.aura().setEnabled(bl, false);
    }

    public Entity target() {
        return RockstarClient.getInstance().I_method_9a638462().I_method_9c10f815();
    }

    public float attackDistance() {
        return this.aura().I_method_af0f42().Ii_method_a20abcd2();
    }
}

