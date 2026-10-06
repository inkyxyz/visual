package rockstar.client;

import com.google.gson.JsonObject;
import lombok.Generated;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIiiiI_Class79;

public final class IiiiIIi_Class58
implements iIIiiiI_Class79 {
    private final long I_field_4a;
    private final String I_field_523beb0a;
    private final String i_field_523beb0a;

    public static IiiiIIi_Class58 I_method_166e9061(JsonObject jsonObject) {
        return IiiiIIi_Class58.I_method_c785f5d6(new IiiiIi_Class30(jsonObject));
    }

    public static IiiiIIi_Class58 I_method_c785f5d6(IiiiIi_Class30 iiiiIi_Class30) {
        return new IiiiIIi_Class58(iiiiIi_Class30.i_method_5239fcca("expireTimeMs"), iiiiIi_Class30.i_method_7caa7e8a("accessToken"), iiiiIi_Class30.I_method_3264db60("refreshToken", null));
    }

    public static JsonObject I_method_b9dc7fbb(IiiiIIi_Class58 iiiiIIi_Class58) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", (Number)1);
        jsonObject.addProperty("expireTimeMs", (Number)iiiiIIi_Class58.I_field_4a);
        jsonObject.addProperty("accessToken", iiiiIIi_Class58.I_field_523beb0a);
        jsonObject.addProperty("refreshToken", iiiiIIi_Class58.i_field_523beb0a);
        return jsonObject;
    }

    @Generated
    public IiiiIIi_Class58(long l, String string, String string2) {
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
    public String I_method_4b3dd1e1() {
        return this.I_field_523beb0a;
    }

    @Generated
    public String i_method_de5c8201() {
        return this.i_field_523beb0a;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof IiiiIIi_Class58)) {
            return false;
        }
        IiiiIIi_Class58 iiiiIIi_Class58 = (IiiiIIi_Class58)object;
        if (this.I_method_86254473() != iiiiIIi_Class58.I_method_86254473()) {
            return false;
        }
        String string = this.I_method_4b3dd1e1();
        String string2 = iiiiIIi_Class58.I_method_4b3dd1e1();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.i_method_de5c8201();
        String string4 = iiiiIIi_Class58.i_method_de5c8201();
        return !(string3 == null ? string4 != null : !string3.equals(string4));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        long l = this.I_method_86254473();
        n2 = n2 * 59 + (int)(l >>> 32 ^ l);
        String string = this.I_method_4b3dd1e1();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.i_method_de5c8201();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "MsaToken(expireTimeMs=" + this.I_method_86254473() + ", accessToken=" + this.I_method_4b3dd1e1() + ", refreshToken=" + this.i_method_de5c8201() + ")";
    }
}

