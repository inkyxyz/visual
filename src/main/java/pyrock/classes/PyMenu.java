package pyrock.classes;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import rockstar.client.IiiIiIIiI_Class211;

public class PyMenu {
    public boolean opened() {
        return IiiIiIIiI_Class211.I_method_cba96335() != null;
    }

    public String type() {
        IiiIiIIiI_Class211 iiiIiIIiI_Class211 = IiiIiIIiI_Class211.I_method_cba96335();
        return iiiIiIIiI_Class211 == null ? null : iiiIiIIiI_Class211.I_method_8c872841();
    }

    public float progress() {
        IiiIiIIiI_Class211 iiiIiIIiI_Class211 = IiiIiIIiI_Class211.I_method_cba96335();
        return iiiIiIIiI_Class211 == null ? 0.0f : iiiIiIIiI_Class211.iI_method_70147d12();
    }

    public float open() {
        IiiIiIIiI_Class211 iiiIiIIiI_Class211 = IiiIiIIiI_Class211.I_method_cba96335();
        return iiiIiIIiI_Class211 == null ? 0.0f : iiiIiIIiI_Class211.I_method_9833b22f();
    }

    public float close() {
        IiiIiIIiI_Class211 iiiIiIIiI_Class211 = IiiIiIIiI_Class211.I_method_cba96335();
        return iiiIiIIiI_Class211 == null ? 0.0f : iiiIiIIiI_Class211.i_method_98423e0f();
    }

    public boolean closing() {
        IiiIiIIiI_Class211 iiiIiIIiI_Class211 = IiiIiIIiI_Class211.I_method_cba96335();
        return iiiIiIIiI_Class211 != null && iiiIiIIiI_Class211.I_method_9833b243();
    }

    public float alpha() {
        IiiIiIIiI_Class211 iiiIiIIiI_Class211 = IiiIiIIiI_Class211.I_method_cba96335();
        return iiiIiIIiI_Class211 == null ? 0.0f : iiiIiIIiI_Class211.II_method_6e518cf2();
    }

    public float scale() {
        IiiIiIIiI_Class211 iiiIiIIiI_Class211 = IiiIiIIiI_Class211.I_method_cba96335();
        return iiiIiIIiI_Class211 == null ? 0.0f : iiiIiIIiI_Class211.Ii_method_6e6018d2();
    }

    public List<Map<String, Object>> panels() {
        IiiIiIIiI_Class211 iiiIiIIiI_Class211 = IiiIiIIiI_Class211.I_method_cba96335();
        if (iiiIiIIiI_Class211 == null) {
            return List.of();
        }
        List<IiiIiIIiI_Class211.Nested1_972f6c40> list = iiiIiIIiI_Class211.I_method_cb1d7a28();
        ArrayList<Map<String, Object>> arrayList = new ArrayList<Map<String, Object>>(list.size());
        for (IiiIiIIiI_Class211.Nested1_972f6c40 nested1_972f6c40 : list) {
            arrayList.add(PyMenu.panel(nested1_972f6c40));
        }
        return arrayList;
    }

    public Map<String, Object> panel(String string) {
        IiiIiIIiI_Class211 iiiIiIIiI_Class211 = IiiIiIIiI_Class211.I_method_cba96335();
        if (iiiIiIIiI_Class211 == null || string == null) {
            return null;
        }
        for (IiiIiIIiI_Class211.Nested1_972f6c40 nested1_972f6c40 : iiiIiIIiI_Class211.I_method_cb1d7a28()) {
            if (!nested1_972f6c40.I_method_2a715866().equalsIgnoreCase(string.trim())) continue;
            return PyMenu.panel(nested1_972f6c40);
        }
        return null;
    }

    public float x() {
        return PyMenu.bounds()[0];
    }

    public float y() {
        return PyMenu.bounds()[1];
    }

    public float width() {
        return PyMenu.bounds()[2];
    }

    public float height() {
        return PyMenu.bounds()[3];
    }

    private static Map<String, Object> panel(IiiIiIIiI_Class211.Nested1_972f6c40 nested1_972f6c40) {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<String, Object>();
        linkedHashMap.put("name", nested1_972f6c40.I_method_2a715866());
        linkedHashMap.put("x", Float.valueOf(nested1_972f6c40.I_method_49743f6a()));
        linkedHashMap.put("y", Float.valueOf(nested1_972f6c40.i_method_4982cb4a()));
        linkedHashMap.put("width", Float.valueOf(nested1_972f6c40.II_method_e522a717()));
        linkedHashMap.put("height", Float.valueOf(nested1_972f6c40.Ii_method_e53132f7()));
        linkedHashMap.put("right", Float.valueOf(nested1_972f6c40.I_method_49743f6a() + nested1_972f6c40.II_method_e522a717()));
        linkedHashMap.put("bottom", Float.valueOf(nested1_972f6c40.i_method_4982cb4a() + nested1_972f6c40.Ii_method_e53132f7()));
        linkedHashMap.put("center_x", Float.valueOf(nested1_972f6c40.I_method_49743f6a() + nested1_972f6c40.II_method_e522a717() / 2.0f));
        linkedHashMap.put("center_y", Float.valueOf(nested1_972f6c40.i_method_4982cb4a() + nested1_972f6c40.Ii_method_e53132f7() / 2.0f));
        return linkedHashMap;
    }

    private static float[] bounds() {
        IiiIiIIiI_Class211 iiiIiIIiI_Class211 = IiiIiIIiI_Class211.I_method_cba96335();
        if (iiiIiIIiI_Class211 == null) {
            return new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        }
        float f = Float.MAX_VALUE;
        float f2 = Float.MAX_VALUE;
        float f3 = -3.4028235E38f;
        float f4 = -3.4028235E38f;
        for (IiiIiIIiI_Class211.Nested1_972f6c40 nested1_972f6c40 : iiiIiIIiI_Class211.I_method_cb1d7a28()) {
            f = Math.min(f, nested1_972f6c40.I_method_49743f6a());
            f2 = Math.min(f2, nested1_972f6c40.i_method_4982cb4a());
            f3 = Math.max(f3, nested1_972f6c40.I_method_49743f6a() + nested1_972f6c40.II_method_e522a717());
            f4 = Math.max(f4, nested1_972f6c40.i_method_4982cb4a() + nested1_972f6c40.Ii_method_e53132f7());
        }
        if (f > f3) {
            return new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        }
        return new float[]{f, f2, f3 - f, f4 - f2};
    }

    public Map<String, Object> all() {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<String, Object>();
        IiiIiIIiI_Class211 iiiIiIIiI_Class211 = IiiIiIIiI_Class211.I_method_cba96335();
        linkedHashMap.put("opened", iiiIiIIiI_Class211 != null);
        linkedHashMap.put("type", iiiIiIIiI_Class211 == null ? null : iiiIiIIiI_Class211.I_method_8c872841());
        linkedHashMap.put("progress", Float.valueOf(this.progress()));
        linkedHashMap.put("open", Float.valueOf(this.open()));
        linkedHashMap.put("close", Float.valueOf(this.close()));
        linkedHashMap.put("closing", this.closing());
        linkedHashMap.put("alpha", Float.valueOf(this.alpha()));
        linkedHashMap.put("scale", Float.valueOf(this.scale()));
        float[] fArray = PyMenu.bounds();
        linkedHashMap.put("x", Float.valueOf(fArray[0]));
        linkedHashMap.put("y", Float.valueOf(fArray[1]));
        linkedHashMap.put("width", Float.valueOf(fArray[2]));
        linkedHashMap.put("height", Float.valueOf(fArray[3]));
        linkedHashMap.put("panels", this.panels());
        return linkedHashMap;
    }
}

