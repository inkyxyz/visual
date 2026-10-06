package rockstar.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import rockstar.client.iIiIiiiiI_Class351;
import rockstar.client.iiIiIIiIi_Class422;

public class iiIIiiiiI_Class415 {
    private static final String I_field_523beb0a = "https://api.deezer.com";

    public static float I_method_3ff8f7c3(String string, String string2) {
        return iiIIiiiiI_Class415.I_method_bf267941(string, string2, 0L);
    }

    public static float I_method_bf267941(String string, String string2, long l) {
        String string3;
        if (string == null || string2 == null || string.isBlank() || string2.isBlank()) {
            return 0.0f;
        }
        long l2 = iiIIiiiiI_Class415.I_method_f321df7b("artist:\"" + string + "\" track:\"" + string2 + "\"", string, string2, l);
        if (l2 == 0L) {
            l2 = iiIIiiiiI_Class415.I_method_f321df7b(string + " " + string2, string, string2, l);
        }
        if (l2 == 0L && !(string3 = iiIiIIiIi_Class422.I_method_216ab597(string)).isBlank() && !string3.equalsIgnoreCase(string.trim())) {
            l2 = iiIIiiiiI_Class415.I_method_f321df7b(string3 + " " + string2, string, string2, l);
        }
        if (l2 == 0L) {
            return 0.0f;
        }
        return iiIIiiiiI_Class415.I_method_eb0b8855(l2);
    }

    private static long I_method_f321df7b(String string, String string2, String string3, long l) {
        try {
            String string4 = iiIIiiiiI_Class415.I_method_fcbfc177("https://api.deezer.com/search?limit=10&q=" + iiIIiiiiI_Class415.i_method_1cdea997(string));
            if (string4 == null) {
                return 0L;
            }
            JsonArray jsonArray = JsonParser.parseString((String)string4).getAsJsonObject().getAsJsonArray("data");
            if (jsonArray == null || jsonArray.isEmpty()) {
                return 0L;
            }
            long l2 = 0L;
            double d = Double.NEGATIVE_INFINITY;
            for (JsonElement jsonElement : jsonArray) {
                double d2;
                JsonObject jsonObject;
                if (!jsonElement.isJsonObject() || !(jsonObject = jsonElement.getAsJsonObject()).has("id") || jsonObject.get("id").isJsonNull() || !((d2 = iiIiIIiIi_Class422.I_method_8a1cdb3(iiIIiiiiI_Class415.I_method_3dd8def7(jsonObject), string2, string3, l)) > d)) continue;
                d = d2;
                l2 = jsonObject.get("id").getAsLong();
            }
            return l2;
        }
        catch (Exception exception) {
            return 0L;
        }
    }

    private static JsonObject I_method_3dd8def7(JsonObject jsonObject) {
        JsonObject jsonObject2 = jsonObject.has("artist") && jsonObject.get("artist").isJsonObject() ? jsonObject.getAsJsonObject("artist") : null;
        double d = jsonObject.has("duration") && !jsonObject.get("duration").isJsonNull() ? jsonObject.get("duration").getAsDouble() : 0.0;
        return iiIiIIiIi_Class422.I_method_abd8c977(iiIiIIiIi_Class422.I_method_ea2da2eb(jsonObject, "title"), iiIiIIiIi_Class422.I_method_ea2da2eb(jsonObject2, "name"), d);
    }

    private static float I_method_eb0b8855(long l) {
        try {
            String string = iiIIiiiiI_Class415.I_method_fcbfc177("https://api.deezer.com/track/" + l);
            if (string == null) {
                return 0.0f;
            }
            JsonObject jsonObject = JsonParser.parseString((String)string).getAsJsonObject();
            if (!jsonObject.has("bpm") || jsonObject.get("bpm").isJsonNull()) {
                return 0.0f;
            }
            float f = jsonObject.get("bpm").getAsFloat();
            return f >= 40.0f && f <= 250.0f ? f : 0.0f;
        }
        catch (Exception exception) {
            return 0.0f;
        }
    }

    private static String I_method_fcbfc177(String string) {
        try {
            iIiIiiiiI_Class351.Nested1_e2f5a480 nested1_e2f5a480 = iIiIiiiiI_Class351.I_method_59510627(string, new String[0]);
            return nested1_e2f5a480.I_method_66072f3e() ? nested1_e2f5a480.I_method_23a3e0a6() : null;
        }
        catch (Exception exception) {
            return null;
        }
    }

    private static String i_method_1cdea997(String string) {
        return URLEncoder.encode(string, StandardCharsets.UTF_8);
    }
}

