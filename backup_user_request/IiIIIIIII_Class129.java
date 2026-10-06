package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.BooleanSetting;

public class IiIIIIIII_Class129
extends BooleanSetting {
    private static final Map<String, boolean[]> I_field_a567c40b = new HashMap<String, boolean[]>();
    private final boolean[] I_field_b5f;

    public IiIIIIIII_Class129(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string2) {
        super(iIiiiIIiI_Class115, string2);
        this.I_field_b5f = I_field_a567c40b.computeIfAbsent(string2, string -> new boolean[1]);
    }

    @Override
    public boolean i_method_9b12da03() {
        return this.I_field_b5f[0];
    }

    @Override
    public void I_method_4e1408b5(boolean bl) {
        if (this.I_field_b5f[0] == bl) {
            return;
        }
        this.notifyChanged();
        this.I_field_b5f[0] = bl;
    }

    @Override
    public void toggle() {
        this.I_method_4e1408b5(!this.I_field_b5f[0]);
    }

    @Override
    public JsonElement toJson() {
        return new JsonPrimitive(Boolean.valueOf(this.I_field_b5f[0]));
    }
}

