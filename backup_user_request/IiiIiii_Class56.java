package rockstar.client;

import com.google.gson.JsonObject;
import lombok.Generated;
import rockstar.client.IiiiIi_Class30;

public final class IiiIiii_Class56 {
    private final String I_field_523beb0a;
    private final String i_field_523beb0a;

    public static IiiIiii_Class56 I_method_9d399821(JsonObject jsonObject) {
        return IiiIiii_Class56.I_method_64a5ed96(new IiiiIi_Class30(jsonObject));
    }

    public static IiiIiii_Class56 I_method_64a5ed96(IiiiIi_Class30 iiiiIi_Class30) {
        return new IiiIiii_Class56(iiiiIi_Class30.i_method_7caa7e8a("email"), iiiiIi_Class30.i_method_7caa7e8a("password"));
    }

    public static JsonObject I_method_5f626bbb(IiiIiii_Class56 iiiIiii_Class56) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", (Number)1);
        jsonObject.addProperty("email", iiiIiii_Class56.I_field_523beb0a);
        jsonObject.addProperty("password", iiiIiii_Class56.i_field_523beb0a);
        return jsonObject;
    }

    @Generated
    public IiiIiii_Class56(String string, String string2) {
        this.I_field_523beb0a = string;
        this.i_field_523beb0a = string2;
    }

    @Generated
    public String I_method_164eea01() {
        return this.I_field_523beb0a;
    }

    @Generated
    public String i_method_a96d9a21() {
        return this.i_field_523beb0a;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof IiiIiii_Class56)) {
            return false;
        }
        IiiIiii_Class56 iiiIiii_Class56 = (IiiIiii_Class56)object;
        String string = this.I_method_164eea01();
        String string2 = iiiIiii_Class56.I_method_164eea01();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.i_method_a96d9a21();
        String string4 = iiiIiii_Class56.i_method_a96d9a21();
        return !(string3 == null ? string4 != null : !string3.equals(string4));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        String string = this.I_method_164eea01();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.i_method_a96d9a21();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "MsaCredentials(email=" + this.I_method_164eea01() + ", password=" + this.i_method_a96d9a21() + ")";
    }
}

