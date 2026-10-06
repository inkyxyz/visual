package rockstar.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;
import lombok.Generated;

public class iiIIIiiII_Class397 {
    private final int I_field_49;
    private final int i_field_49;
    private final int II_field_49;
    private final boolean I_field_5a;
    private final List<String> I_field_7865b31;

    public static iiIIIiiII_Class397 I_method_29f5b2bf(String string) {
        JsonObject jsonObject = JsonParser.parseString((String)string).getAsJsonObject();
        int n = jsonObject.get("width").getAsInt();
        int n2 = jsonObject.get("height").getAsInt();
        int n3 = jsonObject.get("fps").getAsInt();
        boolean bl = jsonObject.get("loop_mode").getAsString().equals("loop");
        ArrayList<String> arrayList = new ArrayList<String>();
        JsonArray jsonArray = jsonObject.getAsJsonArray("frames");
        for (int i = 0; i < jsonArray.size(); ++i) {
            JsonObject jsonObject2 = jsonArray.get(i).getAsJsonObject();
            arrayList.add(jsonObject2.get("file").getAsString());
        }
        return new iiIIIiiII_Class397(n, n2, n3, bl, arrayList);
    }

    public long I_method_3c762a33() {
        return 1000L / (long)this.II_field_49;
    }

    public int I_method_3c762a32() {
        return this.I_field_7865b31.size();
    }

    @Generated
    public int i_method_3c84b612() {
        return this.I_field_49;
    }

    @Generated
    public int II_method_525e14f5() {
        return this.i_field_49;
    }

    @Generated
    public int Ii_method_526ca0d5() {
        return this.II_field_49;
    }

    @Generated
    public boolean I_method_3c762a43() {
        return this.I_field_5a;
    }

    @Generated
    public List<String> I_method_3a9c0228() {
        return this.I_field_7865b31;
    }

    @Generated
    public iiIIIiiII_Class397(int n, int n2, int n3, boolean bl, List<String> list) {
        this.I_field_49 = n;
        this.i_field_49 = n2;
        this.II_field_49 = n3;
        this.I_field_5a = bl;
        this.I_field_7865b31 = list;
    }
}

