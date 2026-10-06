package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import rockstar.client.IiiiII_Class29;

public class IiiiiI_Class31
extends IiiiII_Class29 {
    private final JsonPrimitive I_field_486ca5e4;

    public IiiiiI_Class31(String string) {
        this(new JsonPrimitive(string));
    }

    public IiiiiI_Class31(boolean bl) {
        this(new JsonPrimitive(Boolean.valueOf(bl)));
    }

    public IiiiiI_Class31(Number number) {
        this(new JsonPrimitive(number));
    }

    public IiiiiI_Class31(JsonPrimitive jsonPrimitive) {
        super((JsonElement)jsonPrimitive);
        this.I_field_486ca5e4 = jsonPrimitive;
    }

    public JsonPrimitive I_method_f948e17a() {
        return this.I_field_486ca5e4;
    }

    public boolean I_method_91c98670() {
        return this.I_field_486ca5e4.isBoolean();
    }

    public boolean III_method_47608790() {
        return this.I_field_486ca5e4.isNumber();
    }

    public boolean IIi_method_476f1370() {
        return this.I_field_486ca5e4.isString();
    }
}

