package pyrock.classes;

import java.util.ArrayList;
import java.util.List;
import jep.python.PyCallable;
import pyrock.classes.PyIslandStatus;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.IiIIIiii_Class72;
import rockstar.client.IiIIiIiI_Class75;
import rockstar.client.IiIiiIIII_Class177;
import rockstar.client.IiIiiIiii_Class184;
import rockstar.client.RockstarClient;

public class PyDynamicIsland {
    public PyIslandStatus add(String string, double d, double d2, double d3, boolean bl, PyCallable pyCallable, PyCallable pyCallable2, PyCallable pyCallable3, PyCallable pyCallable4) {
        IiIiiIIII_Class177 iiIiiIIII_Class177 = PyDynamicIsland.island();
        if (iiIiiIIII_Class177 == null) {
            return null;
        }
        String string2 = PyDynamicIsland.normalizeName(string);
        IIiiIIiii_Class104 iIiiIIiii_Class104 = IIiiIIiii_Class104.I_method_204b62f5();
        PyDynamicIsland.removeOwnedDuplicate(iIiiIIiii_Class104, string2);
        PyIslandStatus pyIslandStatus = new PyIslandStatus(iIiiIIiii_Class104, iiIiiIIII_Class177.I_method_7163c735(), string2, Math.max(1.0f, (float)d), Math.max(1.0f, (float)d2), Math.max(0.0f, (float)d3)).expandable(bl);
        if (pyCallable != null) {
            pyIslandStatus.render(pyCallable);
        }
        if (pyCallable2 != null) {
            pyIslandStatus.visibleWhen(pyCallable2);
        }
        if (pyCallable3 != null) {
            pyIslandStatus.measure(pyCallable3);
        }
        if (pyCallable4 != null) {
            pyIslandStatus.onClick(pyCallable4);
        }
        IIiiIIiii_Class104.I_method_19f1b49a(iiIiiIIII_Class177.I_method_7163c735(), pyIslandStatus);
        PyDynamicIsland.applySavedState(iiIiiIIII_Class177);
        return iiIiiIIII_Class177.I_method_79b1d77d(pyIslandStatus);
    }

    public PyIslandStatus add(String string, double d, double d2, double d3) {
        return this.add(string, d, d2, d3, false, null, null, null, null);
    }

    public PyIslandStatus add(String string, double d, double d2) {
        return this.add(string, d, d2, 7.0);
    }

    public PyIslandStatus add(String string) {
        return this.add(string, 48.0, 15.0, 7.0);
    }

    public PyIslandStatus find(String string) {
        IiIiiIIII_Class177 iiIiiIIII_Class177 = PyDynamicIsland.island();
        if (iiIiiIIII_Class177 == null) {
            return null;
        }
        String string2 = PyDynamicIsland.normalizeName(string);
        for (IiIiiIiii_Class184 iiIiiIiii_Class184 : iiIiiIIII_Class177.I_method_b6e7208()) {
            PyIslandStatus pyIslandStatus;
            if (!(iiIiiIiii_Class184 instanceof PyIslandStatus) || !(pyIslandStatus = (PyIslandStatus)iiIiiIiii_Class184).getName().equalsIgnoreCase(string2)) continue;
            return pyIslandStatus;
        }
        return null;
    }

    public List<PyIslandStatus> all() {
        IiIiiIIII_Class177 iiIiiIIII_Class177 = PyDynamicIsland.island();
        ArrayList<PyIslandStatus> arrayList = new ArrayList<PyIslandStatus>();
        if (iiIiiIIII_Class177 == null) {
            return arrayList;
        }
        for (IiIiiIiii_Class184 iiIiiIiii_Class184 : iiIiiIIII_Class177.I_method_b6e7208()) {
            if (!(iiIiiIiii_Class184 instanceof PyIslandStatus)) continue;
            PyIslandStatus pyIslandStatus = (PyIslandStatus)iiIiiIiii_Class184;
            arrayList.add(pyIslandStatus);
        }
        return arrayList;
    }

    public List<PyIslandStatus> mine() {
        IIiiIIiii_Class104 iIiiIIiii_Class104 = IIiiIIiii_Class104.I_method_204b62f5();
        ArrayList<PyIslandStatus> arrayList = new ArrayList<PyIslandStatus>();
        for (PyIslandStatus pyIslandStatus : this.all()) {
            if (!pyIslandStatus.ownedBy(iIiiIIiii_Class104)) continue;
            arrayList.add(pyIslandStatus);
        }
        return arrayList;
    }

    public boolean remove(PyIslandStatus pyIslandStatus) {
        return pyIslandStatus != null && pyIslandStatus.remove();
    }

    public boolean remove(String string) {
        PyIslandStatus pyIslandStatus = this.find(string);
        return pyIslandStatus != null && pyIslandStatus.remove();
    }

    private static IiIiiIIII_Class177 island() {
        return RockstarClient.getInstance().I_method_35687482() == null ? null : RockstarClient.getInstance().I_method_35687482().I_method_35128395();
    }

    private static void removeOwnedDuplicate(IIiiIIiii_Class104 iIiiIIiii_Class104, String string) {
        if (iIiiIIiii_Class104 == null) {
            return;
        }
        IiIiiIIII_Class177 iiIiiIIII_Class177 = PyDynamicIsland.island();
        if (iiIiiIIII_Class177 == null) {
            return;
        }
        for (IiIiiIiii_Class184 iiIiiIiii_Class184 : new ArrayList<IiIiiIiii_Class184>(iiIiiIIII_Class177.I_method_b6e7208())) {
            PyIslandStatus pyIslandStatus;
            if (!(iiIiiIiii_Class184 instanceof PyIslandStatus) || !(pyIslandStatus = (PyIslandStatus)iiIiiIiii_Class184).ownedBy(iIiiIIiii_Class104) || !pyIslandStatus.getName().equalsIgnoreCase(string)) continue;
            pyIslandStatus.dispose();
            iiIiiIIII_Class177.i_method_c24e9cab(pyIslandStatus);
        }
    }

    private static void applySavedState(IiIiiIIII_Class177 iiIiiIIII_Class177) {
        IiIIIiii_Class72 iiIIIiii_Class72 = RockstarClient.getInstance().I_method_7a4c3f0b().I_method_3272b401("client");
        if (iiIIIiii_Class72 instanceof IiIIiIiI_Class75) {
            IiIIiIiI_Class75 iiIIiIiI_Class75 = (IiIIiIiI_Class75)iiIIIiii_Class72;
            iiIIiIiI_Class75.I_method_6a4509fe(iiIiiIIII_Class177);
        }
    }

    private static String normalizeName(String string) {
        if (string == null || string.isBlank()) {
            return "Script Status";
        }
        return string.trim();
    }
}

