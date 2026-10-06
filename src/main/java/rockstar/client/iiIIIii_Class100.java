package rockstar.client;

import com.google.gson.JsonObject;
import java.time.Instant;
import lombok.Generated;
import org.jetbrains.annotations.ApiStatus;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIiiiI_Class79;

public final class iiIIIii_Class100
implements iIIiiiI_Class79 {
    private final long I_field_4a;
    private final String I_field_523beb0a;
    private final String i_field_523beb0a;

    public static iiIIIii_Class100 I_method_e68eb061(JsonObject jsonObject) {
        return iiIIIii_Class100.I_method_262e15d6(new IiiiIi_Class30(jsonObject));
    }

    public static iiIIIii_Class100 I_method_262e15d6(IiiiIi_Class30 iiiiIi_Class30) {
        return new iiIIIii_Class100(iiiiIi_Class30.i_method_5239fcca("expireTimeMs"), iiiiIi_Class30.i_method_7caa7e8a("token"), iiiiIi_Class30.i_method_7caa7e8a("userHash"));
    }

    public static JsonObject I_method_c2267fbb(iiIIIii_Class100 iiIIIii_Class1002) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", (Number)1);
        jsonObject.addProperty("expireTimeMs", (Number)iiIIIii_Class1002.I_field_4a);
        jsonObject.addProperty("token", iiIIIii_Class1002.I_field_523beb0a);
        jsonObject.addProperty("userHash", iiIIIii_Class1002.i_field_523beb0a);
        return jsonObject;
    }

    @ApiStatus.Internal
    public static iiIIIii_Class100 i_method_e14161b6(IiiiIi_Class30 iiiiIi_Class30) {
        return new iiIIIii_Class100(Instant.parse(iiiiIi_Class30.i_method_7caa7e8a("NotAfter")).toEpochMilli(), iiiiIi_Class30.i_method_7caa7e8a("Token"), iiiiIi_Class30.i_method_83289561("DisplayClaims").i_method_831a81a1("xui").I_method_ddc8f320(0).I_method_9b832f2b().i_method_7caa7e8a("uhs"));
    }

    @Generated
    public iiIIIii_Class100(long l, String string, String string2) {
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
    public String I_method_901fc1e1() {
        return this.I_field_523beb0a;
    }

    @Generated
    public String i_method_233e7201() {
        return this.i_field_523beb0a;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof iiIIIii_Class100)) {
            return false;
        }
        iiIIIii_Class100 iiIIIii_Class1002 = (iiIIIii_Class100)object;
        if (this.I_method_86254473() != iiIIIii_Class1002.I_method_86254473()) {
            return false;
        }
        String string = this.I_method_901fc1e1();
        String string2 = iiIIIii_Class1002.I_method_901fc1e1();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.i_method_233e7201();
        String string4 = iiIIIii_Class1002.i_method_233e7201();
        return !(string3 == null ? string4 != null : !string3.equals(string4));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        long l = this.I_method_86254473();
        n2 = n2 * 59 + (int)(l >>> 32 ^ l);
        String string = this.I_method_901fc1e1();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.i_method_233e7201();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "XblUserToken(expireTimeMs=" + this.I_method_86254473() + ", token=" + this.I_method_901fc1e1() + ", userHash=" + this.i_method_233e7201() + ")";
    }
}

