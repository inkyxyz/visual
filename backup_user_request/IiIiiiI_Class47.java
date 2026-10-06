package rockstar.client;

import com.google.gson.JsonObject;
import lombok.Generated;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIiiiI_Class79;

public final class IiIiiiI_Class47
implements iIIiiiI_Class79 {
    private final long I_field_4a;
    private final String I_field_523beb0a;
    private final String i_field_523beb0a;

    public static IiIiiiI_Class47 I_method_91a4a8e1(JsonObject jsonObject) {
        return IiIiiiI_Class47.I_method_13c2e56(new IiiiIi_Class30(jsonObject));
    }

    public static IiIiiiI_Class47 I_method_13c2e56(IiiiIi_Class30 iiiiIi_Class30) {
        return new IiIiiiI_Class47(iiiiIi_Class30.i_method_5239fcca("expireTimeMs"), iiiiIi_Class30.i_method_7caa7e8a("type"), iiiiIi_Class30.i_method_7caa7e8a("token"));
    }

    public static JsonObject I_method_b46d27bb(IiIiiiI_Class47 iiIiiiI_Class47) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", (Number)1);
        jsonObject.addProperty("expireTimeMs", (Number)iiIiiiI_Class47.I_field_4a);
        jsonObject.addProperty("type", iiIiiiI_Class47.I_field_523beb0a);
        jsonObject.addProperty("token", iiIiiiI_Class47.i_field_523beb0a);
        return jsonObject;
    }

    public String I_method_e1240da1() {
        return this.I_field_523beb0a + ' ' + this.i_field_523beb0a;
    }

    @Generated
    public IiIiiiI_Class47(long l, String string, String string2) {
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
    public String i_method_7442bdc1() {
        return this.I_field_523beb0a;
    }

    @Generated
    public String II_method_48b7927e() {
        return this.i_field_523beb0a;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof IiIiiiI_Class47)) {
            return false;
        }
        IiIiiiI_Class47 iiIiiiI_Class47 = (IiIiiiI_Class47)object;
        if (this.I_method_86254473() != iiIiiiI_Class47.I_method_86254473()) {
            return false;
        }
        String string = this.i_method_7442bdc1();
        String string2 = iiIiiiI_Class47.i_method_7442bdc1();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.II_method_48b7927e();
        String string4 = iiIiiiI_Class47.II_method_48b7927e();
        return !(string3 == null ? string4 != null : !string3.equals(string4));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        long l = this.I_method_86254473();
        n2 = n2 * 59 + (int)(l >>> 32 ^ l);
        String string = this.i_method_7442bdc1();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.II_method_48b7927e();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "MinecraftToken(expireTimeMs=" + this.I_method_86254473() + ", type=" + this.i_method_7442bdc1() + ", token=" + this.II_method_48b7927e() + ")";
    }
}

