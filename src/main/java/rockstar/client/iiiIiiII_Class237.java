package rockstar.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import net.minecraft.client.MinecraftClient;
import rockstar.client.RockstarClient;

public final class iiiIiiII_Class237 {
    public static final int I_field_49 = 17;
    public static final String I_field_523beb0a = "default";
    private static final float I_field_46 = 0.95f;
    private static iiiIiiII_Class237 I_field_64aba7a1;
    private static boolean I_field_5a;
    private static String i_field_523beb0a;
    private final float[][] I_field_160e6;
    private final float[][] i_field_160e6;
    private final float[][] II_field_160e6;
    private final float[] I_field_b4b;
    private final float[] i_field_b4b;
    private final float[] II_field_b4b;
    private final float[] Ii_field_b4b;
    private final int i_field_49;
    private final int II_field_49;
    private final int Ii_field_49;
    private final float i_field_46;
    private final float II_field_46;

    private iiiIiiII_Class237(JsonObject jsonObject) {
        this.i_field_49 = jsonObject.get("hidden").getAsInt();
        this.II_field_49 = jsonObject.get("mix").getAsInt();
        this.Ii_field_49 = jsonObject.has("freezeCut") ? jsonObject.get("freezeCut").getAsInt() : 12;
        JsonArray jsonArray = jsonObject.getAsJsonArray("limits");
        this.i_field_46 = jsonArray.get(0).getAsFloat();
        this.II_field_46 = jsonArray.get(1).getAsFloat();
        this.Ii_field_b4b = jsonObject.has("error") ? iiiIiiII_Class237.I_method_892c8461(jsonObject.getAsJsonArray("error")) : new float[]{};
        JsonObject jsonObject2 = jsonObject.getAsJsonObject("gru");
        this.I_field_160e6 = iiiIiiII_Class237.I_method_9c640a90(jsonObject2.getAsJsonArray("wi"));
        this.i_field_160e6 = iiiIiiII_Class237.I_method_9c640a90(jsonObject2.getAsJsonArray("wh"));
        this.I_field_b4b = iiiIiiII_Class237.I_method_892c8461(jsonObject2.getAsJsonArray("bi"));
        this.i_field_b4b = iiiIiiII_Class237.I_method_892c8461(jsonObject2.getAsJsonArray("bh"));
        JsonObject jsonObject3 = jsonObject.getAsJsonObject("out");
        this.II_field_160e6 = iiiIiiII_Class237.I_method_9c640a90(jsonObject3.getAsJsonArray("w"));
        this.II_field_b4b = iiiIiiII_Class237.I_method_892c8461(jsonObject3.getAsJsonArray("b"));
    }

    private static float[][] I_method_9c640a90(JsonArray jsonArray) {
        float[][] fArrayArray = new float[jsonArray.size()][];
        for (int i = 0; i < jsonArray.size(); ++i) {
            fArrayArray[i] = iiiIiiII_Class237.I_method_892c8461(jsonArray.get(i).getAsJsonArray());
        }
        return fArrayArray;
    }

    private static float[] I_method_892c8461(JsonArray jsonArray) {
        float[] fArray = new float[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); ++i) {
            fArray[i] = jsonArray.get(i).getAsFloat();
        }
        return fArray;
    }

    public static Path I_method_db76ec89() {
        return MinecraftClient.getInstance().runDirectory.toPath().resolve("Rockstar").resolve("neuro");
    }

    public static Path i_method_21aa14a9() {
        return iiiIiiII_Class237.I_method_db76ec89().resolve("data");
    }

    public static Path I_method_9c2e0d7f(String string) {
        return iiiIiiII_Class237.I_method_db76ec89().resolve(string + ".json");
    }

    public static String I_method_f16c5534() {
        if (i_field_523beb0a == null) {
            try {
                Path path = iiiIiiII_Class237.I_method_db76ec89().resolve("active.txt");
                i_field_523beb0a = Files.isRegularFile(path, new LinkOption[0]) ? Files.readString(path).trim() : I_field_523beb0a;
            }
            catch (Exception exception) {
                i_field_523beb0a = I_field_523beb0a;
            }
            if (i_field_523beb0a.isEmpty()) {
                i_field_523beb0a = I_field_523beb0a;
            }
        }
        return i_field_523beb0a;
    }

    public static List<String> I_method_313f47db() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(I_field_523beb0a);
        try (Stream<Path> stream = Files.list(iiiIiiII_Class237.I_method_db76ec89());){
            stream.filter(path -> path.getFileName().toString().endsWith(".json")).map(path -> path.getFileName().toString().replaceFirst("\\.json$", "")).filter(string -> !arrayList.contains(string)).sorted().forEach(arrayList::add);
        }
        catch (Exception exception) {
            // empty catch block
        }
        return arrayList;
    }

    public static boolean I_method_e0dedbba(String string) {
        return I_field_523beb0a.equals(string) || Files.isRegularFile(iiiIiiII_Class237.I_method_9c2e0d7f(string), new LinkOption[0]);
    }

    public static boolean i_method_b1962f9a(String string) {
        if (!iiiIiiII_Class237.I_method_e0dedbba(string)) {
            return false;
        }
        i_field_523beb0a = string;
        try {
            Files.createDirectories(iiiIiiII_Class237.I_method_db76ec89(), new FileAttribute[0]);
            Files.writeString(iiiIiiII_Class237.I_method_db76ec89().resolve("active.txt"), (CharSequence)string, new OpenOption[0]);
        }
        catch (Exception exception) {
            RockstarClient.I_field_ab0f6068.error("[Neuro] \u043d\u0435 \u0437\u0430\u043f\u0438\u0441\u0430\u0442\u044c \u0430\u043a\u0442\u0438\u0432\u043d\u0443\u044e \u043c\u043e\u0434\u0435\u043b\u044c", (Throwable)exception);
        }
        iiiIiiII_Class237.I_method_1d8494ec();
        return true;
    }

    public static iiiIiiII_Class237 I_method_7d0c47cb() {
        if (!I_field_5a) {
            I_field_5a = true;
            I_field_64aba7a1 = iiiIiiII_Class237.I_method_35285841(iiiIiiII_Class237.I_method_f16c5534());
        }
        return I_field_64aba7a1;
    }

    public static void I_method_1d8494ec() {
        I_field_5a = false;
        I_field_64aba7a1 = null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static iiiIiiII_Class237 I_method_35285841(String string) {
        try {
            JsonObject jsonObject;
            Path path = iiiIiiII_Class237.I_method_9c2e0d7f(string);
            if (Files.isRegularFile(path, new LinkOption[0])) {
                jsonObject = JsonParser.parseString((String)Files.readString(path)).getAsJsonObject();
            } else {
                if (!I_field_523beb0a.equals(string)) return null;
                try (InputStream inputStream = iiiIiiII_Class237.class.getClassLoader().getResourceAsStream("assets/rockstar/neuro/default.json");){
                    if (inputStream == null) {
                        iiiIiiII_Class237 iiiIiiII_Class2372 = null;
                        return iiiIiiII_Class2372;
                    }
                    jsonObject = JsonParser.parseReader((Reader)new InputStreamReader(inputStream, StandardCharsets.UTF_8)).getAsJsonObject();
                }
            }
            if (jsonObject.get("features").getAsInt() != 17) return null;
            if (!jsonObject.has("mix")) {
                return null;
            }
            if (!jsonObject.has("units")) return null;
            if ("deg".equals(jsonObject.get("units").getAsString())) return new iiiIiiII_Class237(jsonObject);
            return null;
        }
        catch (Exception exception) {
            RockstarClient.I_field_ab0f6068.error("[Neuro] \u043c\u043e\u0434\u0435\u043b\u044c " + string + " \u043d\u0435 \u0447\u0438\u0442\u0430\u0435\u0442\u0441\u044f", (Throwable)exception);
            return null;
        }
    }

    public int I_method_1d8494df() {
        return this.Ii_field_49;
    }

    public float[] I_method_930e0975() {
        return new float[this.i_field_49];
    }

    public float[] I_method_13bc795f(float[] fArray, float[] fArray2) {
        float f;
        int n;
        float[] fArray3 = new float[3 * this.i_field_49];
        float[] fArray4 = new float[3 * this.i_field_49];
        for (n = 0; n < 3 * this.i_field_49; ++n) {
            int n2;
            f = this.I_field_b4b[n];
            float[] fArray5 = this.I_field_160e6[n];
            for (n2 = 0; n2 < fArray5.length; ++n2) {
                f += fArray5[n2] * fArray[n2];
            }
            fArray3[n] = f;
            f = this.i_field_b4b[n];
            fArray5 = this.i_field_160e6[n];
            for (n2 = 0; n2 < fArray5.length; ++n2) {
                f += fArray5[n2] * fArray2[n2];
            }
            fArray4[n] = f;
        }
        for (n = 0; n < this.i_field_49; ++n) {
            f = iiiIiiII_Class237.Ii_method_d246567b(fArray3[n] + fArray4[n]);
            float f2 = iiiIiiII_Class237.Ii_method_d246567b(fArray3[this.i_field_49 + n] + fArray4[this.i_field_49 + n]);
            float f3 = (float)Math.tanh(fArray3[2 * this.i_field_49 + n] + f * fArray4[2 * this.i_field_49 + n]);
            fArray2[n] = (1.0f - f2) * f3 + f2 * fArray2[n];
        }
        float[] fArray6 = new float[this.II_field_160e6.length];
        for (int i = 0; i < this.II_field_160e6.length; ++i) {
            float f4 = this.II_field_b4b[i];
            float[] fArray7 = this.II_field_160e6[i];
            for (int j = 0; j < fArray7.length; ++j) {
                f4 += fArray7[j] * fArray2[j];
            }
            fArray6[i] = f4;
        }
        return fArray6;
    }

    public int I_method_a6890dc(float[] fArray, float f) {
        float f2 = fArray[1];
        for (int i = 1; i < this.II_field_49; ++i) {
            f2 = Math.max(f2, fArray[1 + 6 * i]);
        }
        float f3 = 0.0f;
        for (int i = 0; i < this.II_field_49; ++i) {
            f3 += (float)Math.exp(fArray[1 + 6 * i] - f2);
        }
        float f4 = f * f3;
        for (int i = 0; i < this.II_field_49; ++i) {
            if (!((f4 -= (float)Math.exp(fArray[1 + 6 * i] - f2)) <= 0.0f)) continue;
            return i;
        }
        return this.II_field_49 - 1;
    }

    public float I_method_930e7044(float f) {
        if (this.Ii_field_b4b.length == 0) {
            return 0.0f;
        }
        float f2 = Math.max(0.0f, Math.min(1.0f, f)) * (float)(this.Ii_field_b4b.length - 1);
        int n = (int)f2;
        return n >= this.Ii_field_b4b.length - 1 ? this.Ii_field_b4b[this.Ii_field_b4b.length - 1] : this.Ii_field_b4b[n] + (this.Ii_field_b4b[n + 1] - this.Ii_field_b4b[n]) * (f2 - (float)n);
    }

    public float I_method_bccbec58(float f, float f2, boolean bl, float f3, float f4) {
        float f5 = (float)Math.exp(Math.max(-4.0f, Math.min(1.5f, f2)));
        float f6 = Math.max(-8.0f, Math.min(8.0f, f + f4 * f5 * f3));
        float f7 = bl ? this.i_field_46 : this.II_field_46;
        return Math.max(-f7, Math.min(f7, (float)Math.sinh(f6)));
    }

    public static float i_method_94d16064(float f) {
        return iiiIiiII_Class237.Ii_method_d246567b(f);
    }

    public static float II_method_d083665b(float f) {
        return (float)Math.tanh(f) * 0.95f;
    }

    private static float Ii_method_d246567b(float f) {
        return 1.0f / (1.0f + (float)Math.exp(-f));
    }
}

