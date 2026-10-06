package rockstar.client;

import java.util.function.Predicate;
import rockstar.client.MultiSelectSetting;

public class IiIIIIiII_Class133<T>
extends MultiSelectSetting.Nested1_42856060 {
    private final Predicate<T> I_field_93e25d0f;

    public IiIIIIiII_Class133(MultiSelectSetting iIiiiiiii_Class128, String string, Predicate<T> predicate) {
        super(iIiiiiiii_Class128, string);
        this.I_field_93e25d0f = predicate;
    }

    public IiIIIIiII_Class133(MultiSelectSetting iIiiiiiii_Class128, String string, String string2, Predicate<T> predicate) {
        super(iIiiiiiii_Class128, string, string2);
        this.I_field_93e25d0f = predicate;
    }

    public boolean I_method_e107945f(T t) {
        return this.I_field_93e25d0f.test(t) && this.isSelected();
    }
}

