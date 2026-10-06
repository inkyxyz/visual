package rockstar.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Generated;
import net.minecraft.client.MinecraftClient;
import pyrock.events.window.KeyPressEvent;
import pyrock.events.window.MouseEvent;
import rockstar.client.EspModule;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiIiiI_Class119;
import rockstar.client.IiiiiiII_Class125;
import rockstar.client.IiiiiiIi_Class126;
import rockstar.client.Iiiiiiii_Class128;
import rockstar.client.iIIIIIII_Class129;
import rockstar.client.iIIIIIIi_Class130;
import rockstar.client.iIIIIIiI_Class131;
import rockstar.client.iIIIIIii_Class132;
import rockstar.client.iIIIIiII_Class133;
import rockstar.client.iIIIIiIi_Class134;
import rockstar.client.iIIIIiiI_Class135;

public class IiiiiiiI_Class127 {
    private static final IiiiiiiI_Class127 I_field_12b95381 = new IiiiiiiI_Class127();
    private final List<IiiiIiiI_Class119> I_field_7865b31 = new ArrayList<IiiiIiiI_Class119>();
    private final Map<String, JsonObject> I_field_a567c40b = new ConcurrentHashMap<String, JsonObject>();
    private boolean I_field_5a;
    private final IiIIIiII_Class69<KeyPressEvent> I_field_3d936f41 = keyPressEvent -> {
        if (keyPressEvent.getAction() == 1) {
            this.I_method_f0113bb7(keyPressEvent.getKey());
        }
    };
    private final IiIIIiII_Class69<MouseEvent> i_field_3d936f41 = mouseEvent -> {
        if (mouseEvent.getAction() == 1) {
            this.I_method_f0113bb7(mouseEvent.getButton());
        }
    };

    private IiiiiiiI_Class127() {
    }

    public static boolean I_method_731950d0() {
        EspModule iIiIIiIiI_Class75 = RockstarClient.getInstance().getModuleManager().getModule(EspModule.class);
        return iIiIIiIiI_Class75 != null && iIiIIiIiI_Class75.isEnabled();
    }

    public void I_method_731950cc() {
        if (!this.I_field_5a) {
            RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
            this.I_field_5a = true;
        }
        this.II_method_51cb6536(new iIIIIIiI_Class131());
        this.II_method_51cb6536(new iIIIIIII_Class129());
        this.II_method_51cb6536(new Iiiiiiii_Class128());
        this.II_method_51cb6536(new iIIIIiII_Class133());
        this.II_method_51cb6536(new IiiiiiII_Class125());
        this.II_method_51cb6536(new iIIIIIIi_Class130());
        this.II_method_51cb6536(new iIIIIiiI_Class135());
        this.II_method_51cb6536(new IiiiiiIi_Class126());
        this.II_method_51cb6536(new iIIIIIii_Class132());
    }

    private void I_method_f0113bb7(int n) {
        if (n == -1) {
            return;
        }
        if (MinecraftClient.getInstance().currentScreen != null) {
            return;
        }
        if (!IiiiiiiI_Class127.I_method_731950d0()) {
            return;
        }
        for (IiiiIiiI_Class119 iiiiIiiI_Class119 : this.I_field_7865b31) {
            iiiiIiiI_Class119.I_method_66e317db(n);
        }
    }

    private void II_method_51cb6536(IiiiIiiI_Class119 iiiiIiiI_Class119) {
        this.I_field_7865b31.add(iiiiIiiI_Class119);
        iiiiIiiI_Class119.I_method_ea8b70ac();
        this.Ii_method_6760d916(iiiiIiiI_Class119);
    }

    public void I_method_31e3ef2d(IiiiIiiI_Class119 iiiiIiiI_Class119) {
        if (iiiiIiiI_Class119 == null || this.I_field_7865b31.contains(iiiiIiiI_Class119)) {
            return;
        }
        this.II_method_51cb6536(iiiiIiiI_Class119);
    }

    public void i_method_4779630d(IiiiIiiI_Class119 iiiiIiiI_Class119) {
        if (iiiiIiiI_Class119 == null || !this.I_field_7865b31.remove(iiiiIiiI_Class119)) {
            return;
        }
        try {
            this.I_field_a567c40b.put(iiiiIiiI_Class119.I_method_4b007174(), iiiiIiiI_Class119.I_method_d1ac1716());
        }
        catch (Exception exception) {
            RockstarClient.I_field_ab0f6068.warn("Config: \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0441\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c \u044d\u043b\u0435\u043c\u0435\u043d\u0442 ESP {}", (Object)iiiiIiiI_Class119.I_method_4b007174(), (Object)exception);
        }
        RockstarClient.getInstance().I_method_7897deab().i_method_f30f2128(iiiiIiiI_Class119);
    }

    public void I_method_966f25a8(Object object) {
        for (IiiiIiiI_Class119 iiiiIiiI_Class119 : new ArrayList<IiiiIiiI_Class119>(this.I_field_7865b31)) {
            iIIIIiIi_Class134 iIIIIiIi_Class1342;
            if (!(iiiiIiiI_Class119 instanceof iIIIIiIi_Class134) || (iIIIIiIi_Class1342 = (iIIIIiIi_Class134)iiiiIiiI_Class119).I_method_c594c006() != object) continue;
            this.i_method_4779630d(iiiiIiiI_Class119);
        }
    }

    private void Ii_method_6760d916(IiiiIiiI_Class119 iiiiIiiI_Class119) {
        JsonObject jsonObject = this.I_field_a567c40b.remove(iiiiIiiI_Class119.I_method_4b007174());
        if (jsonObject != null) {
            iiiiIiiI_Class119.I_method_81c92e58(jsonObject);
        }
    }

    public void i_method_67267988(Object object) {
        for (IiiiIiiI_Class119 iiiiIiiI_Class119 : new ArrayList<IiiiIiiI_Class119>(this.I_field_7865b31)) {
            iIIIIiIi_Class134 iIIIIiIi_Class1342;
            if (!(iiiiIiiI_Class119 instanceof iIIIIiIi_Class134) || (iIIIIiIi_Class1342 = (iIIIIiIi_Class134)iiiiIiiI_Class119).I_method_c594c006() != object) continue;
            this.Ii_method_6760d916(iiiiIiiI_Class119);
        }
    }

    public <T extends IiiiIiiI_Class119> T I_method_b8f96026(Class<T> clazz) {
        for (IiiiIiiI_Class119 iiiiIiiI_Class119 : this.I_field_7865b31) {
            if (!clazz.isInstance(iiiiIiiI_Class119)) continue;
            return (T)iiiiIiiI_Class119;
        }
        return null;
    }

    public IiiiIiiI_Class119 I_method_9733ac21(String string) {
        for (IiiiIiiI_Class119 iiiiIiiI_Class119 : this.I_field_7865b31) {
            if (!iiiiIiiI_Class119.I_method_4b007174().equals(string)) continue;
            return iiiiIiiI_Class119;
        }
        return null;
    }

    public JsonArray I_method_1d714fa8() {
        JsonArray jsonArray = new JsonArray();
        HashSet<String> hashSet = new HashSet<String>();
        for (IiiiIiiI_Class119 object : this.I_field_7865b31) {
            hashSet.add(object.I_method_4b007174());
            jsonArray.add((JsonElement)object.I_method_d1ac1716());
        }
        for (Map.Entry entry : this.I_field_a567c40b.entrySet()) {
            if (hashSet.contains(entry.getKey())) continue;
            jsonArray.add((JsonElement)((JsonObject)entry.getValue()).deepCopy());
        }
        return jsonArray;
    }

    public void I_method_5aa9e4a0(JsonArray jsonArray) {
        for (JsonElement jsonElement : jsonArray) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            if (!jsonObject.has("name")) continue;
            String string = jsonObject.get("name").getAsString();
            IiiiIiiI_Class119 iiiiIiiI_Class119 = this.I_method_9733ac21(string);
            if (iiiiIiiI_Class119 != null) {
                iiiiIiiI_Class119.I_method_81c92e58(jsonObject);
                continue;
            }
            this.I_field_a567c40b.put(string, jsonObject.deepCopy());
        }
    }

    @Generated
    public static IiiiiiiI_Class127 I_method_e1e653cb() {
        return I_field_12b95381;
    }

    @Generated
    public List<IiiiIiiI_Class119> I_method_6ddf4ffb() {
        return this.I_field_7865b31;
    }
}

