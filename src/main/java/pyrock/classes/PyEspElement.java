package pyrock.classes;

import java.util.ArrayList;
import java.util.Locale;
import jep.python.PyCallable;
import lombok.Generated;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.IIiiIiIIi_Class106;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiiIII_Class121;
import rockstar.client.IiiiiIiI_Class123;
import rockstar.client.IiiiiiiI_Class127;
import rockstar.client.iIIIIiIi_Class134;
import rockstar.client.iIIiIIiIi_Class294;

public class PyEspElement
implements iIIiIIiIi_Class294 {
    private final iIIIIiIi_Class134 element;
    private final IIiiIIiii_Class104 creator = IIiiIIiii_Class104.I_method_204b62f5();

    public PyEspElement(String string, String string2) {
        this.element = new iIIIIiIi_Class134(this.owner(), string, this.types(string2));
        IiiiiiiI_Class127.I_method_e1e653cb().I_method_31e3ef2d(this.element);
    }

    public PyEspElement onRender(PyCallable pyCallable) {
        this.element.I_method_4f73aae8(pyCallable == null ? null : (entity, render3DEvent) -> this.call(pyCallable, entity, render3DEvent));
        return this;
    }

    public PyEspElement onRenderAll(PyCallable pyCallable) {
        this.element.I_method_4f651f08(pyCallable == null ? null : (list, render3DEvent) -> this.call(pyCallable, list, render3DEvent));
        return this;
    }

    public PyEspElement onFilter(PyCallable pyCallable) {
        this.element.I_method_aed029bb(pyCallable == null ? null : entity -> {
            Boolean bl;
            Object object = this.call(pyCallable, entity, null);
            return !(object instanceof Boolean) || (bl = (Boolean)object) != false;
        });
        return this;
    }

    public PyEspElement enableFor(String string) {
        IiiiiIiI_Class123 iiiiiIiI_Class123 = PyEspElement.type(string);
        if (iiiiiIiI_Class123 != null) {
            this.element.I_method_f29f4d(iiiiiIiI_Class123);
            return this;
        }
        IiiiiIII_Class121 iiiiiIII_Class121 = PyEspElement.subType(string);
        if (iiiiiIII_Class121 != null) {
            this.element.I_method_ff2faf2d(iiiiiIII_Class121);
            return this;
        }
        throw new IllegalArgumentException("\u043d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u0430\u044f \u0446\u0435\u043b\u044c: " + string);
    }

    public boolean isEnabled() {
        return IiiiiiiI_Class127.I_method_731950d0() && this.element.I_method_ea8b70b0();
    }

    public String getName() {
        return this.element.I_method_4b007174();
    }

    public void remove() {
        IiiiiiiI_Class127.I_method_e1e653cb().i_method_4779630d(this.element);
    }

    private Object call(PyCallable pyCallable, Object object, Object object2) {
        if (!IIiiIiIIi_Class106.Ii_method_b61528e6()) {
            return null;
        }
        IIiiIIiii_Class104 owner = this.creator != null ? this.creator : IIiiIIiii_Class104.I_method_204b62f5();
        if (owner != null && !owner.II_method_b18bf526()) {
            return null;
        }
        try (AutoCloseable ignored = IIiiIIiii_Class104.I_method_5edeb6c9(owner)) {
            return object2 == null ? pyCallable.call(new Object[]{object}) : pyCallable.call(new Object[]{object, object2});
        } catch (Exception exception) {
            this.element.I_method_4f73aae8(null);
            this.element.I_method_4f651f08(null);
            this.element.I_method_aed029bb(null);
            RockstarClient.I_field_ab0f6068.error("Python error in esp element '" + this.element.I_method_4b007174() + "':", exception);
            return null;
        }
    }

    private IiiiiIiI_Class123[] types(String string) {
        ArrayList<IiiiiIiI_Class123> arrayList = new ArrayList<IiiiiIiI_Class123>();
        if (string == null || string.isBlank()) {
            return new IiiiiIiI_Class123[0];
        }
        for (String string2 : string.split(",")) {
            if (string2.isBlank()) continue;
            IiiiiIiI_Class123 iiiiiIiI_Class123 = PyEspElement.type(string2);
            if (iiiiiIiI_Class123 == null) {
                throw new IllegalArgumentException("\u043d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u0430\u044f \u0446\u0435\u043b\u044c: " + string2.trim());
            }
            arrayList.add(iiiiiIiI_Class123);
        }
        return arrayList.toArray(new IiiiiIiI_Class123[0]);
    }

    private static IiiiiIiI_Class123 type(String string) {
        String string2 = string.trim().toLowerCase(Locale.ROOT);
        for (IiiiiIiI_Class123 iiiiiIiI_Class123 : IiiiiIiI_Class123.values()) {
            if (!iiiiiIiI_Class123.I_method_213534().equals(string2)) continue;
            return iiiiiIiI_Class123;
        }
        return null;
    }

    private static IiiiiIII_Class121 subType(String string) {
        String string2 = string.trim().toLowerCase(Locale.ROOT);
        for (IiiiiIII_Class121 iiiiiIII_Class121 : IiiiiIII_Class121.values()) {
            if (!iiiiiIII_Class121.I_method_7fef5954().equals(string2)) continue;
            return iiiiiIII_Class121;
        }
        return null;
    }

    private Object owner() {
        IIiiIIiii_Class104 iIiiIIiii_Class104 = IIiiIIiii_Class104.I_method_204b62f5();
        return iIiiIIiii_Class104 != null ? iIiiIIiii_Class104 : this;
    }

    @Generated
    public iIIIIiIi_Class134 getElement() {
        return this.element;
    }

    @Generated
    public IIiiIIiii_Class104 getCreator() {
        return this.creator;
    }
}
