package pyrock.classes;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Map;
import pyrock.utility.render.PyAssets;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.IiIIiiii_Class80;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiIiIIIi_Class82;
import rockstar.client.RockstarClient;
import rockstar.client.iiiiIIi_Class122;

public class PyLang {
    private static final Gson GSON = new Gson();

    public void add(String string, Map<String, String> map) {
        IiIIiiii_Class80 iiIIiiii_Class80 = IiIiIIIi_Class82.I_method_11abc881(string);
        if (iiIIiiii_Class80 == null) {
            throw new IllegalArgumentException("\u043d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u044b\u0439 \u044f\u0437\u044b\u043a: " + string + " (\u0431\u044b\u0432\u0430\u044e\u0442 ru_ru, en_us, uk_ua, pl_pl)");
        }
        if (map == null) {
            return;
        }
        Object object = this.owner();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            IiIiIIIi_Class82.I_method_310c5d3d(object, iiIIiiii_Class80, entry.getKey(), String.valueOf(entry.getValue()));
        }
    }

    public void loadFile(String string) {
        if (iiiiIIi_Class122.I_method_d6d2688d(string)) {
            Path path2 = iiiiIIi_Class122.I_method_6efab1cc(string);
            if (path2 != null) {
                this.apply(this.read(path2), string);
                return;
            }
            Object object = this.owner();
            iiiiIIi_Class122.I_method_f5e02f0b(string, path -> {
                try {
                    this.apply(this.read((Path)path), string, object);
                }
                catch (Exception exception) {
                    RockstarClient.I_field_ab0f6068.warn("\u041f\u0435\u0440\u0435\u0432\u043e\u0434\u044b: {}", (Object)exception.getMessage());
                }
            });
            return;
        }
        Path path3 = PyAssets.resolve(string);
        if (!Files.isRegularFile(path3, new LinkOption[0])) {
            throw new IllegalArgumentException("\u0444\u0430\u0439\u043b\u0430 \u0441 \u043f\u0435\u0440\u0435\u0432\u043e\u0434\u0430\u043c\u0438 \u043d\u0435\u0442: " + String.valueOf(path3));
        }
        this.apply(this.read(path3), string);
    }

    public String get(String string) {
        return IiIiIIII_Class81.I_method_f25a980a(string);
    }

    public String current() {
        return IiIiIIII_Class81.I_method_21a4cfeb().I_method_881af974();
    }

    public boolean has(String string) {
        return IiIiIIIi_Class82.I_method_4ecf8f3a(string) || !IiIiIIII_Class81.I_method_f25a980a(string).equals(string);
    }

    public void clear() {
        IiIiIIIi_Class82.I_method_14e5548(this.owner());
    }

    public String plural(double d, String string, String string2, String string3) {
        long l = Math.abs(Math.round(d));
        if (this.current().startsWith("en")) {
            return l == 1L ? string : string2;
        }
        long l2 = l % 100L;
        long l3 = l % 10L;
        if (l2 >= 11L && l2 <= 14L) {
            return string3;
        }
        if (l3 == 1L) {
            return string;
        }
        if (l3 >= 2L && l3 <= 4L) {
            return string2;
        }
        return string3;
    }

    private void apply(JsonObject jsonObject, String string) {
        this.apply(jsonObject, string, this.owner());
    }

    private void apply(JsonObject jsonObject, String string, Object object) {
        if (jsonObject == null) {
            return;
        }
        for (Map.Entry entry : jsonObject.entrySet()) {
            IiIIiiii_Class80 iiIIiiii_Class80 = IiIiIIIi_Class82.I_method_11abc881((String)entry.getKey());
            if (iiIIiiii_Class80 == null || !((JsonElement)entry.getValue()).isJsonObject()) {
                RockstarClient.I_field_ab0f6068.warn("\u041f\u0435\u0440\u0435\u0432\u043e\u0434\u044b: \u043d\u0435\u043f\u043e\u043d\u044f\u0442\u043d\u044b\u0439 \u044f\u0437\u044b\u043a {} \u0432 {}", entry.getKey(), (Object)string);
                continue;
            }
            for (Map.Entry entry2 : ((JsonElement)entry.getValue()).getAsJsonObject().entrySet()) {
                if (!((JsonElement)entry2.getValue()).isJsonPrimitive()) continue;
                IiIiIIIi_Class82.I_method_310c5d3d(object, iiIIiiii_Class80, (String)entry2.getKey(), ((JsonElement)entry2.getValue()).getAsString());
            }
        }
    }

    private JsonObject read(Path path) {
        try {
            return (JsonObject)GSON.fromJson(Files.readString(path), JsonObject.class);
        }
        catch (Exception exception) {
            throw new IllegalArgumentException("\u043d\u0435 \u0447\u0438\u0442\u0430\u0435\u0442\u0441\u044f \u0444\u0430\u0439\u043b \u043f\u0435\u0440\u0435\u0432\u043e\u0434\u043e\u0432 " + String.valueOf(path) + ": " + exception.getMessage(), exception);
        }
    }

    private Object owner() {
        IIiiIIiii_Class104 iIiiIIiii_Class104 = IIiiIIiii_Class104.I_method_204b62f5();
        return iIiiIIiii_Class104 != null ? iIiiIIiii_Class104 : this;
    }
}

