package pyrock.classes;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jep.python.PyCallable;
import pyrock.classes.PyHudElement;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.IiIIIiii_Class72;
import rockstar.client.IiIIiIiI_Class75;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiIiIIiII_Class165;
import rockstar.client.RockstarClient;

public class PyHud {
    public PyHudElement add(String string, String string2, double d, double d2, double d3, double d4, boolean bl, PyCallable pyCallable, PyCallable pyCallable2) {
        String string3 = PyHud.normalizeName(string);
        IIiiIIiii_Class104 iIiiIIiii_Class104 = IIiiIIiii_Class104.I_method_204b62f5();
        PyHud.removeOwnedDuplicate(iIiiIIiii_Class104, string3);
        PyHudElement pyHudElement = new PyHudElement(iIiiIIiii_Class104, string3, PyHud.normalizeIcon(string2), Math.max(1.0f, (float)d), Math.max(1.0f, (float)d2), (float)d3, (float)d4);
        pyHudElement.setShowing(bl);
        if (pyCallable != null) {
            pyHudElement.renderer(pyCallable);
        }
        if (pyCallable2 != null) {
            pyHudElement.visibleWhen(pyCallable2);
        }
        RockstarClient.getInstance().I_method_35687482().III_method_812fc188().add(pyHudElement);
        IIiiIIiii_Class104.I_method_cec5c0aa(pyHudElement);
        PyHud.applySavedState(pyHudElement);
        return pyHudElement;
    }

    public PyHudElement find(String string) {
        String string2 = PyHud.normalizeName(string);
        for (IiIiIIiII_Class165 iiIiIIiII_Class165 : RockstarClient.getInstance().I_method_35687482().III_method_812fc188()) {
            PyHudElement pyHudElement;
            if (!(iiIiIIiII_Class165 instanceof PyHudElement) || !(pyHudElement = (PyHudElement)iiIiIIiII_Class165).getName().equalsIgnoreCase(string2)) continue;
            return pyHudElement;
        }
        return null;
    }

    public List<PyHudElement> all() {
        ArrayList<PyHudElement> arrayList = new ArrayList<PyHudElement>();
        for (IiIiIIiII_Class165 iiIiIIiII_Class165 : RockstarClient.getInstance().I_method_35687482().III_method_812fc188()) {
            if (!(iiIiIIiII_Class165 instanceof PyHudElement)) continue;
            PyHudElement pyHudElement = (PyHudElement)iiIiIIiII_Class165;
            arrayList.add(pyHudElement);
        }
        return arrayList;
    }

    public List<PyHudElement> mine() {
        IIiiIIiii_Class104 iIiiIIiii_Class104 = IIiiIIiii_Class104.I_method_204b62f5();
        ArrayList<PyHudElement> arrayList = new ArrayList<PyHudElement>();
        for (PyHudElement pyHudElement : this.all()) {
            if (!pyHudElement.ownedBy(iIiiIIiii_Class104)) continue;
            arrayList.add(pyHudElement);
        }
        return arrayList;
    }

    public List<Map<String, Object>> elements() {
        List<IiIiIIiII_Class165> list = RockstarClient.getInstance().I_method_35687482().III_method_812fc188();
        ArrayList<Map<String, Object>> arrayList = new ArrayList<Map<String, Object>>(list.size());
        for (IiIiIIiII_Class165 iiIiIIiII_Class165 : list) {
            arrayList.add(PyHud.describe(iiIiIIiII_Class165));
        }
        return arrayList;
    }

    public Map<String, Object> element(String string) {
        if (string == null || string.isBlank()) {
            return null;
        }
        for (IiIiIIiII_Class165 iiIiIIiII_Class165 : RockstarClient.getInstance().I_method_35687482().III_method_812fc188()) {
            if (!PyHud.matches(iiIiIIiII_Class165, string.trim())) continue;
            return PyHud.describe(iiIiIIiII_Class165);
        }
        return null;
    }

    private static boolean matches(IiIiIIiII_Class165 iiIiIIiII_Class165, String string) {
        String string2 = iiIiIIiII_Class165.getName();
        if (string2 == null) {
            return false;
        }
        if (string2.equalsIgnoreCase(string) || IiIiIIII_Class81.I_method_f25a980a(string2).equalsIgnoreCase(string)) {
            return true;
        }
        int n = string2.lastIndexOf(46);
        return n >= 0 && n < string2.length() - 1 && string2.substring(n + 1).equalsIgnoreCase(string);
    }

    private static Map<String, Object> describe(IiIiIIiII_Class165 iiIiIIiII_Class165) {
        float f = iiIiIIiII_Class165.getAnimation().I_method_6ac4da6f();
        float f2 = iiIiIIiII_Class165.getVisible().I_method_6ac4da6f();
        float f3 = iiIiIIiII_Class165.getSelecting().I_method_6ac4da6f();
        float f4 = f * f2;
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<String, Object>();
        linkedHashMap.put("name", iiIiIIiII_Class165.getName());
        linkedHashMap.put("title", IiIiIIII_Class81.I_method_f25a980a(iiIiIIiII_Class165.getName()));
        linkedHashMap.put("icon", iiIiIIiII_Class165.getIcon());
        linkedHashMap.put("x", Float.valueOf(iiIiIIiII_Class165.getX()));
        linkedHashMap.put("y", Float.valueOf(iiIiIIiII_Class165.getY()));
        linkedHashMap.put("width", Float.valueOf(iiIiIIiII_Class165.getWidth()));
        linkedHashMap.put("height", Float.valueOf(iiIiIIiII_Class165.getHeight()));
        linkedHashMap.put("right", Float.valueOf(iiIiIIiII_Class165.getX() + iiIiIIiII_Class165.getWidth()));
        linkedHashMap.put("bottom", Float.valueOf(iiIiIIiII_Class165.getY() + iiIiIIiII_Class165.getHeight()));
        linkedHashMap.put("center_x", Float.valueOf(iiIiIIiII_Class165.getX() + iiIiIIiII_Class165.getWidth() / 2.0f));
        linkedHashMap.put("center_y", Float.valueOf(iiIiIIiII_Class165.getY() + iiIiIIiII_Class165.getHeight() / 2.0f));
        linkedHashMap.put("alpha", Float.valueOf(f4));
        linkedHashMap.put("appear", Float.valueOf(f));
        linkedHashMap.put("visible", Float.valueOf(f2));
        linkedHashMap.put("select", Float.valueOf(f3));
        linkedHashMap.put("drag", Float.valueOf(iiIiIIiII_Class165.getDragAnim().I_method_6ac4da6f()));
        linkedHashMap.put("scale", Float.valueOf(0.5f + f4 * 0.5f - 0.05f * f3));
        linkedHashMap.put("showing", iiIiIIiII_Class165.isShowing());
        linkedHashMap.put("dragging", iiIiIIiII_Class165.isDragging());
        linkedHashMap.put("script", iiIiIIiII_Class165 instanceof PyHudElement);
        return linkedHashMap;
    }

    public boolean remove(PyHudElement pyHudElement) {
        return pyHudElement != null && pyHudElement.remove();
    }

    public boolean remove(String string) {
        PyHudElement pyHudElement = this.find(string);
        return pyHudElement != null && pyHudElement.remove();
    }

    private static void removeOwnedDuplicate(IIiiIIiii_Class104 iIiiIIiii_Class104, String string) {
        if (iIiiIIiii_Class104 == null) {
            return;
        }
        RockstarClient.getInstance().I_method_35687482().III_method_812fc188().removeIf(iiIiIIiII_Class165 -> {
            PyHudElement pyHudElement;
            if (iiIiIIiII_Class165 instanceof PyHudElement && (pyHudElement = (PyHudElement)iiIiIIiII_Class165).ownedBy(iIiiIIiii_Class104) && pyHudElement.getName().equalsIgnoreCase(string)) {
                pyHudElement.dispose();
                return true;
            }
            return false;
        });
    }

    private static void applySavedState(PyHudElement pyHudElement) {
        IiIIIiii_Class72 iiIIIiii_Class72 = RockstarClient.getInstance().I_method_7a4c3f0b().I_method_3272b401("client");
        if (iiIIIiii_Class72 instanceof IiIIiIiI_Class75) {
            IiIIiIiI_Class75 iiIIiIiI_Class75 = (IiIIiIiI_Class75)iiIIIiii_Class72;
            iiIIiIiI_Class75.I_method_6a4509fe(pyHudElement);
        }
    }

    private static String normalizeName(String string) {
        if (string == null || string.isBlank()) {
            return "Script HUD";
        }
        return string.trim();
    }

    private static String normalizeIcon(String string) {
        if (string == null || string.isBlank()) {
            return "hud/player";
        }
        return string.trim();
    }
}

