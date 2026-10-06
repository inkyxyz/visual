package rockstar.client;

import com.google.gson.JsonObject;
import java.util.UUID;
import lombok.Generated;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIiiiI_Class79;

public final class IiIiiIi_Class46
implements iIIiiiI_Class79 {
    private final UUID I_field_7fb73d4;
    private final String I_field_523beb0a;

    public static IiIiiIi_Class46 I_method_188d8061(JsonObject jsonObject) {
        return IiIiiIi_Class46.I_method_1a20e5d6(new IiiiIi_Class30(jsonObject));
    }

    public static IiIiiIi_Class46 I_method_1a20e5d6(IiiiIi_Class30 iiiiIi_Class30) {
        return new IiIiiIi_Class46(UUID.fromString(iiiiIi_Class30.i_method_7caa7e8a("id")), iiiiIi_Class30.i_method_7caa7e8a("name"));
    }

    public static JsonObject I_method_d2677fbb(IiIiiIi_Class46 iiIiiIi_Class46) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", (Number)1);
        jsonObject.addProperty("id", iiIiiIi_Class46.I_field_7fb73d4.toString());
        jsonObject.addProperty("name", iiIiiIi_Class46.I_field_523beb0a);
        return jsonObject;
    }

    @Override
    public long I_method_86254473() {
        return Long.MAX_VALUE;
    }

    @Generated
    public IiIiiIi_Class46(UUID uUID, String string) {
        this.I_field_7fb73d4 = uUID;
        this.I_field_523beb0a = string;
    }

    @Generated
    public UUID I_method_5d50ac6b() {
        return this.I_field_7fb73d4;
    }

    @Generated
    public String I_method_a72559e1() {
        return this.I_field_523beb0a;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof IiIiiIi_Class46)) {
            return false;
        }
        IiIiiIi_Class46 iiIiiIi_Class46 = (IiIiiIi_Class46)object;
        UUID uUID = this.I_method_5d50ac6b();
        UUID uUID2 = iiIiiIi_Class46.I_method_5d50ac6b();
        if (uUID == null ? uUID2 != null : !((Object)uUID).equals(uUID2)) {
            return false;
        }
        String string = this.I_method_a72559e1();
        String string2 = iiIiiIi_Class46.I_method_a72559e1();
        return !(string == null ? string2 != null : !string.equals(string2));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        UUID uUID = this.I_method_5d50ac6b();
        n2 = n2 * 59 + (uUID == null ? 43 : ((Object)uUID).hashCode());
        String string = this.I_method_a72559e1();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "MinecraftProfile(id=" + this.I_method_5d50ac6b() + ", name=" + this.I_method_a72559e1() + ")";
    }
}

