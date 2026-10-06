package rockstar.client;

import com.google.gson.JsonObject;
import lombok.Generated;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIiiiI_Class79;

public final class iiIIIII_Class97
implements iIIiiiI_Class79 {
    private final long I_field_4a;
    private final String I_field_523beb0a;
    private final String i_field_523beb0a;

    public static iiIIIII_Class97 I_method_3231b861(JsonObject jsonObject) {
        return iiIIIII_Class97.I_method_b8331dd6(new IiiiIi_Class30(jsonObject));
    }

    public static iiIIIII_Class97 I_method_b8331dd6(IiiiIi_Class30 iiiiIi_Class30) {
        return new iiIIIII_Class97(iiiiIi_Class30.i_method_5239fcca("expireTimeMs"), iiiiIi_Class30.i_method_7caa7e8a("token"), iiiiIi_Class30.i_method_7caa7e8a("deviceId"));
    }

    public static JsonObject I_method_6aa8ffbb(iiIIIII_Class97 iiIIIII_Class972) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", (Number)1);
        jsonObject.addProperty("expireTimeMs", (Number)iiIIIII_Class972.I_field_4a);
        jsonObject.addProperty("token", iiIIIII_Class972.I_field_523beb0a);
        jsonObject.addProperty("deviceId", iiIIIII_Class972.i_field_523beb0a);
        return jsonObject;
    }

    @Generated
    public iiIIIII_Class97(long l, String string, String string2) {
        this.I_field_4a = l;
        this.I_field_523beb0a = string;
        this.i_field_523beb0a = string2;
    }

    @Override
    @Generated
    public long I_method_86254473() {
        return this.I_field_4a;
    }

    @Generated
    public String I_method_c9babde1() {
        return this.I_field_523beb0a;
    }

    @Generated
    public String i_method_5cd96e01() {
        return this.i_field_523beb0a;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof iiIIIII_Class97)) {
            return false;
        }
        iiIIIII_Class97 iiIIIII_Class972 = (iiIIIII_Class97)object;
        if (this.I_method_86254473() != iiIIIII_Class972.I_method_86254473()) {
            return false;
        }
        String string = this.I_method_c9babde1();
        String string2 = iiIIIII_Class972.I_method_c9babde1();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.i_method_5cd96e01();
        String string4 = iiIIIII_Class972.i_method_5cd96e01();
        return !(string3 == null ? string4 != null : !string3.equals(string4));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        long l = this.I_method_86254473();
        n2 = n2 * 59 + (int)(l >>> 32 ^ l);
        String string = this.I_method_c9babde1();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.i_method_5cd96e01();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "XblDeviceToken(expireTimeMs=" + this.I_method_86254473() + ", token=" + this.I_method_c9babde1() + ", deviceId=" + this.i_method_5cd96e01() + ")";
    }
}

