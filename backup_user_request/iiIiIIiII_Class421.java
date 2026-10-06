package rockstar.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rockstar.client.iIiIiiiiI_Class351;
import rockstar.client.iiIiIIIIi_Class418;
import rockstar.client.iiIiIIIii_Class420;
import rockstar.client.iiIiIIiIi_Class422;

public class iiIiIIiII_Class421 {
    static final Logger I_field_ab0f6068 = LoggerFactory.getLogger((String)"rockstar-lyrics");
    private static final String I_field_523beb0a = "https://lrclib.net/api";
    private static final String i_field_523beb0a = "https://music.163.com/api";
    private static final String II_field_523beb0a = "Rockstar/2.0 (https://github.com/rockstar)";
    private static final String Ii_field_523beb0a = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36";
    private static final long I_field_4a = 8000L;
    private static final Nested1_c4a7c40 I_field_c0bce247 = new Nested1_c4a7c40("lrclib");
    private static final Nested1_c4a7c40 i_field_c0bce247 = new Nested1_c4a7c40("netease");

    public static iiIiIIIii_Class420 I_method_8f42e3e9(String string, String string2) {
        return iiIiIIiII_Class421.I_method_4e490be7(string, string2, 0L);
    }

    public static iiIiIIIii_Class420 I_method_4e490be7(String string, String string2, long l) {
        if (string == null || string2 == null || string.isBlank() || string2.isBlank()) {
            return iiIiIIIii_Class420.I_method_6b642b75();
        }
        long l2 = System.currentTimeMillis();
        I_field_ab0f6068.info("[lyrics] \u0438\u0449\u0443 \u00ab{} - {}\u00bb ({} \u0441)", new Object[]{string, string2, l});
        iiIiIIIii_Class420 iiIiIIIii_Class4202 = iiIiIIiII_Class421.i_method_fdc76f89(string, string2, l, iiIiIIiII_Class421.I_method_507ea233());
        if (iiIiIIIii_Class4202 != null && !iiIiIIIii_Class4202.I_method_27bb8263() && iiIiIIIii_Class4202.i_method_27ca0e43()) {
            return iiIiIIiII_Class421.I_method_5270d891("lrclib", string, string2, iiIiIIIii_Class4202, l2);
        }
        iiIiIIIii_Class420 iiIiIIIii_Class4203 = iiIiIIiII_Class421.I_method_7007e3a9(string, string2, l, iiIiIIiII_Class421.I_method_507ea233());
        if (iiIiIIIii_Class4203 != null && !iiIiIIIii_Class4203.I_method_27bb8263() && iiIiIIIii_Class4203.i_method_27ca0e43()) {
            return iiIiIIiII_Class421.I_method_5270d891("netease", string, string2, iiIiIIIii_Class4203, l2);
        }
        if (iiIiIIIii_Class4202 != null && !iiIiIIIii_Class4202.I_method_27bb8263()) {
            return iiIiIIiII_Class421.I_method_5270d891("lrclib (\u0431\u0435\u0437 \u0442\u0430\u0439\u043c\u043a\u043e\u0434\u043e\u0432)", string, string2, iiIiIIIii_Class4202, l2);
        }
        String string3 = iiIiIIIIi_Class418.I_method_9799592d(string, string2);
        if (string3 != null && !string3.isBlank()) {
            return iiIiIIiII_Class421.I_method_5270d891("genius (\u0431\u0435\u0437 \u0442\u0430\u0439\u043c\u043a\u043e\u0434\u043e\u0432)", string, string2, iiIiIIIii_Class420.i_method_6cf9fedf(string3), l2);
        }
        I_field_ab0f6068.info("[lyrics] {} - {}: \u043d\u0435 \u043d\u0430\u0448\u043b\u043e\u0441\u044c \u043d\u0438 \u0432 \u043e\u0434\u043d\u043e\u043c \u0438\u0441\u0442\u043e\u0447\u043d\u0438\u043a\u0435 ({} \u043c\u0441)", new Object[]{string, string2, System.currentTimeMillis() - l2});
        return iiIiIIIii_Class420.I_method_6b642b75();
    }

    private static iiIiIIIii_Class420 I_method_5270d891(String string, String string2, String string3, iiIiIIIii_Class420 iiIiIIIii_Class4202, long l) {
        I_field_ab0f6068.info("[lyrics] {} - {}: {} \u0441\u0442\u0440\u043e\u043a \u0438\u0437 {} ({} \u043c\u0441)", new Object[]{string2, string3, iiIiIIIii_Class4202.I_method_13376608().size(), string, System.currentTimeMillis() - l});
        return iiIiIIIii_Class4202;
    }

    private static void I_method_80e07ef6(String string, String string2, int n, Exception exception) {
        if (exception != null) {
            I_field_ab0f6068.warn("[lyrics] {} \u043d\u0435\u0434\u043e\u0441\u0442\u0443\u043f\u0435\u043d ({}): {}", new Object[]{string, string2, exception.toString()});
        } else {
            I_field_ab0f6068.warn("[lyrics] {} \u043e\u0442\u0432\u0435\u0442\u0438\u043b {} ({})", new Object[]{string, n, string2});
        }
    }

    private static long I_method_507ea233() {
        return System.currentTimeMillis() + 8000L;
    }

    private static boolean I_method_bf561c69(long l) {
        return System.currentTimeMillis() >= l;
    }

    private static iiIiIIIii_Class420 I_method_7007e3a9(String string, String string2, long l, long l2) {
        if (!i_field_c0bce247.I_method_1ac32f7e()) {
            return null;
        }
        JsonArray jsonArray = iiIiIIiII_Class421.I_method_1f11efb7(string + " " + string2, l2);
        String string3 = iiIiIIiII_Class421.I_method_8d655577(string);
        if (!(jsonArray != null && !jsonArray.isEmpty() || string3.isBlank() || string3.equalsIgnoreCase(string.trim()))) {
            jsonArray = iiIiIIiII_Class421.I_method_1f11efb7(string3 + " " + string2, l2);
        }
        if (jsonArray == null) {
            return null;
        }
        long l3 = -1L;
        double d = Double.NEGATIVE_INFINITY;
        for (JsonElement jsonElement : jsonArray) {
            double d2;
            JsonObject jsonObject;
            if (!jsonElement.isJsonObject() || !(jsonObject = jsonElement.getAsJsonObject()).has("id") || jsonObject.get("id").isJsonNull() || !((d2 = iiIiIIiII_Class421.I_method_a32b6593(iiIiIIiII_Class421.I_method_77ec72f7(jsonObject), string, string2, l)) > d)) continue;
            d = d2;
            l3 = jsonObject.get("id").getAsLong();
        }
        return l3 < 0L ? null : iiIiIIiII_Class421.I_method_d1cc0815(l3, l2);
    }

    private static JsonArray I_method_1f11efb7(String string, long l) {
        JsonObject jsonObject = iiIiIIiII_Class421.I_method_8c0684c7("https://music.163.com/api/search/get?type=1&limit=10&s=" + iiIiIIiII_Class421.i_method_ad843d97(string), l);
        if (jsonObject == null || !jsonObject.has("result") || !jsonObject.get("result").isJsonObject()) {
            return null;
        }
        JsonObject jsonObject2 = jsonObject.getAsJsonObject("result");
        return jsonObject2.has("songs") && jsonObject2.get("songs").isJsonArray() ? jsonObject2.getAsJsonArray("songs") : null;
    }

    private static iiIiIIIii_Class420 I_method_d1cc0815(long l, long l2) {
        JsonObject jsonObject = iiIiIIiII_Class421.I_method_8c0684c7("https://music.163.com/api/song/lyric?lv=1&kv=1&tv=-1&id=" + l, l2);
        if (jsonObject == null || !jsonObject.has("lrc") || !jsonObject.get("lrc").isJsonObject()) {
            return null;
        }
        String string = iiIiIIiII_Class421.I_method_bffbb2cb(jsonObject.getAsJsonObject("lrc"), "lyric");
        if (string.isBlank()) {
            return null;
        }
        iiIiIIIii_Class420 iiIiIIIii_Class4202 = iiIiIIIii_Class420.I_method_33a5c2ff(string);
        return iiIiIIIii_Class4202.I_method_27bb8263() ? null : iiIiIIIii_Class4202;
    }

    private static JsonObject I_method_77ec72f7(JsonObject jsonObject) {
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("trackName", iiIiIIiII_Class421.I_method_bffbb2cb(jsonObject, "name"));
        StringBuilder stringBuilder = new StringBuilder();
        if (jsonObject.has("artists") && jsonObject.get("artists").isJsonArray()) {
            for (JsonElement jsonElement : jsonObject.getAsJsonArray("artists")) {
                String string;
                if (!jsonElement.isJsonObject() || (string = iiIiIIiII_Class421.I_method_bffbb2cb(jsonElement.getAsJsonObject(), "name")).isBlank()) continue;
                if (!stringBuilder.isEmpty()) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(string);
            }
        }
        jsonObject2.addProperty("artistName", stringBuilder.toString());
        if (jsonObject.has("duration") && !jsonObject.get("duration").isJsonNull()) {
            jsonObject2.addProperty("duration", (Number)((double)jsonObject.get("duration").getAsLong() / 1000.0));
        }
        return jsonObject2;
    }

    private static JsonObject I_method_8c0684c7(String string, long l) {
        if (iiIiIIiII_Class421.I_method_bf561c69(l)) {
            return null;
        }
        try {
            iIiIiiiiI_Class351.Nested1_e2f5a480 nested1_e2f5a480 = iIiIiiiiI_Class351.I_method_59510627(string, "User-Agent", Ii_field_523beb0a, "Referer", "https://music.163.com");
            if (!nested1_e2f5a480.I_method_66072f3e()) {
                iiIiIIiII_Class421.I_method_80e07ef6("netease", string, nested1_e2f5a480.I_method_66072f2d(), null);
                i_field_c0bce247.i_method_1ad1bb5a();
                return null;
            }
            i_field_c0bce247.I_method_1ac32f7a();
            JsonElement jsonElement = JsonParser.parseString((String)nested1_e2f5a480.I_method_23a3e0a6());
            return jsonElement.isJsonObject() ? jsonElement.getAsJsonObject() : null;
        }
        catch (Exception exception) {
            iiIiIIiII_Class421.I_method_80e07ef6("netease", string, 0, exception);
            i_field_c0bce247.i_method_1ad1bb5a();
            return null;
        }
    }

    private static iiIiIIIii_Class420 i_method_fdc76f89(String string, String string2, long l, long l2) {
        if (!I_field_c0bce247.I_method_1ac32f7e()) {
            return null;
        }
        ArrayList<JsonArray> arrayList = new ArrayList<JsonArray>();
        if (!iiIiIIiII_Class421.I_method_d4c6470e(arrayList, "track_name=" + iiIiIIiII_Class421.i_method_ad843d97(string2) + "&artist_name=" + iiIiIIiII_Class421.i_method_ad843d97(string), l2)) {
            return null;
        }
        JsonObject jsonObject = iiIiIIiII_Class421.I_method_85338671((JsonArray)arrayList.getFirst(), string, string2, l, true);
        if (jsonObject != null) {
            return iiIiIIiII_Class421.I_method_e919e35f(jsonObject, true);
        }
        String string3 = iiIiIIiII_Class421.I_method_8d655577(string);
        if (!string3.isBlank() && !string3.equalsIgnoreCase(string.trim())) {
            if (!iiIiIIiII_Class421.I_method_d4c6470e(arrayList, "track_name=" + iiIiIIiII_Class421.i_method_ad843d97(string2) + "&artist_name=" + iiIiIIiII_Class421.i_method_ad843d97(string3), l2)) {
                return null;
            }
            jsonObject = iiIiIIiII_Class421.I_method_85338671((JsonArray)arrayList.getLast(), string, string2, l, true);
            if (jsonObject != null) {
                return iiIiIIiII_Class421.I_method_e919e35f(jsonObject, true);
            }
        }
        if (!iiIiIIiII_Class421.I_method_d4c6470e(arrayList, "track_name=" + iiIiIIiII_Class421.i_method_ad843d97(string2), l2)) {
            return null;
        }
        jsonObject = iiIiIIiII_Class421.I_method_85338671((JsonArray)arrayList.getLast(), string, string2, l, true);
        if (jsonObject != null) {
            return iiIiIIiII_Class421.I_method_e919e35f(jsonObject, true);
        }
        if (!iiIiIIiII_Class421.I_method_d4c6470e(arrayList, "q=" + iiIiIIiII_Class421.i_method_ad843d97((string3.isBlank() ? string : string3) + " " + string2), l2)) {
            return null;
        }
        jsonObject = iiIiIIiII_Class421.I_method_85338671((JsonArray)arrayList.getLast(), string, string2, l, true);
        if (jsonObject != null) {
            return iiIiIIiII_Class421.I_method_e919e35f(jsonObject, true);
        }
        JsonObject jsonObject2 = null;
        double d = Double.NEGATIVE_INFINITY;
        for (JsonArray jsonArray : arrayList) {
            double d2;
            JsonObject jsonObject3 = iiIiIIiII_Class421.I_method_85338671(jsonArray, string, string2, l, false);
            if (jsonObject3 == null || !((d2 = iiIiIIiII_Class421.I_method_a32b6593(jsonObject3, string, string2, l)) > d)) continue;
            d = d2;
            jsonObject2 = jsonObject3;
        }
        return jsonObject2 == null ? null : iiIiIIiII_Class421.I_method_e919e35f(jsonObject2, false);
    }

    private static boolean I_method_d4c6470e(List<JsonArray> list, String string, long l) {
        JsonArray jsonArray = iiIiIIiII_Class421.i_method_10452fd7(string, l);
        if (jsonArray == null) {
            return false;
        }
        list.add(jsonArray);
        return true;
    }

    private static JsonArray i_method_10452fd7(String string, long l) {
        if (iiIiIIiII_Class421.I_method_bf561c69(l)) {
            return null;
        }
        try {
            iIiIiiiiI_Class351.Nested1_e2f5a480 nested1_e2f5a480 = iIiIiiiiI_Class351.I_method_59510627("https://lrclib.net/api/search?" + string, "User-Agent", II_field_523beb0a);
            if (!nested1_e2f5a480.I_method_66072f3e()) {
                iiIiIIiII_Class421.I_method_80e07ef6("lrclib", "https://lrclib.net/api/search?" + string, nested1_e2f5a480.I_method_66072f2d(), null);
                I_field_c0bce247.i_method_1ad1bb5a();
                return null;
            }
            I_field_c0bce247.I_method_1ac32f7a();
            return JsonParser.parseString((String)nested1_e2f5a480.I_method_23a3e0a6()).getAsJsonArray();
        }
        catch (Exception exception) {
            iiIiIIiII_Class421.I_method_80e07ef6("lrclib", "https://lrclib.net/api/search?" + string, 0, exception);
            I_field_c0bce247.i_method_1ad1bb5a();
            return null;
        }
    }

    static JsonObject I_method_85338671(JsonArray jsonArray, String string, String string2, long l, boolean bl) {
        JsonObject jsonObject = null;
        double d = Double.NEGATIVE_INFINITY;
        String string3 = bl ? "syncedLyrics" : "plainLyrics";
        for (JsonElement jsonElement : jsonArray) {
            double d2;
            JsonObject jsonObject2;
            if (!jsonElement.isJsonObject() || !iiIiIIiII_Class421.I_method_9f99da79(jsonObject2 = jsonElement.getAsJsonObject(), string3) || !((d2 = iiIiIIiII_Class421.I_method_a32b6593(jsonObject2, string, string2, l)) > d)) continue;
            d = d2;
            jsonObject = jsonObject2;
        }
        return jsonObject;
    }

    private static double I_method_a32b6593(JsonObject jsonObject, String string, String string2, long l) {
        return iiIiIIiIi_Class422.I_method_8a1cdb3(jsonObject, string, string2, l);
    }

    private static String I_method_8d655577(String string) {
        return iiIiIIiIi_Class422.I_method_216ab597(string);
    }

    private static iiIiIIIii_Class420 I_method_e919e35f(JsonObject jsonObject, boolean bl) {
        String string = jsonObject.get(bl ? "syncedLyrics" : "plainLyrics").getAsString();
        return bl ? iiIiIIIii_Class420.I_method_33a5c2ff(string) : iiIiIIIii_Class420.i_method_6cf9fedf(string);
    }

    private static boolean I_method_9f99da79(JsonObject jsonObject, String string) {
        return jsonObject.has(string) && !jsonObject.get(string).isJsonNull() && !jsonObject.get(string).getAsString().isBlank();
    }

    private static String I_method_bffbb2cb(JsonObject jsonObject, String string) {
        return iiIiIIiIi_Class422.I_method_ea2da2eb(jsonObject, string);
    }

    private static String i_method_ad843d97(String string) {
        return URLEncoder.encode(string, StandardCharsets.UTF_8);
    }

    static final class Nested1_c4a7c40 {
        private static final int I_field_49 = 3;
        private static final long I_field_4a = 300000L;
        private final String I_field_523beb0a;
        private int i_field_49;
        private long i_field_4a;

        Nested1_c4a7c40(String string) {
            this.I_field_523beb0a = string;
        }

        synchronized boolean I_method_1ac32f7e() {
            if (System.currentTimeMillis() < this.i_field_4a) {
                return false;
            }
            this.i_field_4a = 0L;
            return true;
        }

        synchronized void I_method_1ac32f7a() {
            this.i_field_49 = 0;
            this.i_field_4a = 0L;
        }

        synchronized void i_method_1ad1bb5a() {
            if (++this.i_field_49 < 3) {
                return;
            }
            this.i_field_49 = 0;
            this.i_field_4a = System.currentTimeMillis() + 300000L;
            I_field_ab0f6068.warn("[lyrics] {} \u043e\u0431\u043e\u0440\u0432\u0430\u043b \u0441\u043e\u0435\u0434\u0438\u043d\u0435\u043d\u0438\u0435 {} \u0440\u0430\u0437\u0430 \u043f\u043e\u0434\u0440\u044f\u0434 \u2014 \u043f\u0440\u043e\u043f\u0443\u0441\u043a\u0430\u0435\u043c \u0435\u0433\u043e {} \u043c\u0438\u043d\u0443\u0442", new Object[]{this.I_field_523beb0a, 3, 5L});
        }
    }
}

