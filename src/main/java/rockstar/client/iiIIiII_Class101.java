package rockstar.client;

import com.google.gson.JsonObject;
import java.time.Instant;
import lombok.Generated;
import org.jetbrains.annotations.ApiStatus;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIiiiI_Class79;

public final class iiIIiII_Class101
implements iIIiiiI_Class79 {
    private final long I_field_4a;
    private final String I_field_523beb0a;
    private final String i_field_523beb0a;

    public static iiIIiII_Class101 I_method_f2b9b021(JsonObject jsonObject) {
        return iiIIiII_Class101.I_method_df0c0596(new IiiiIi_Class30(jsonObject));
    }

    public static iiIIiII_Class101 I_method_df0c0596(IiiiIi_Class30 iiiiIi_Class30) {
        return new iiIIiII_Class101(iiiiIi_Class30.i_method_5239fcca("expireTimeMs"), iiiiIi_Class30.i_method_7caa7e8a("token"), iiiiIi_Class30.i_method_7caa7e8a("userHash"));
    }

    public static JsonObject I_method_e619ebbb(iiIIiII_Class101 iiIIiII_Class1012) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", (Number)1);
        jsonObject.addProperty("expireTimeMs", (Number)iiIIiII_Class1012.I_field_4a);
        jsonObject.addProperty("token", iiIIiII_Class1012.I_field_523beb0a);
        jsonObject.addProperty("userHash", iiIIiII_Class1012.i_field_523beb0a);
        return jsonObject;
    }

    @ApiStatus.Internal
    public static iiIIiII_Class101 i_method_9a1f5176(IiiiIi_Class30 iiiiIi_Class30) {
        return new iiIIiII_Class101(Instant.parse(iiiiIi_Class30.i_method_7caa7e8a("NotAfter")).toEpochMilli(), iiiiIi_Class30.i_method_7caa7e8a("Token"), iiiiIi_Class30.i_method_83289561("DisplayClaims").i_method_831a81a1("xui").I_method_ddc8f320(0).I_method_9b832f2b().i_method_7caa7e8a("uhs"));
    }

    public String I_method_4fc45e01() {
        return "XBL3.0 x=" + this.i_field_523beb0a + ';' + this.I_field_523beb0a;
    }

    @Generated
    public iiIIiII_Class101(long l, String string, String string2) {
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
    public String i_method_e2e30e21() {
        return this.I_field_523beb0a;
    }

    @Generated
    public String II_method_ae214e1e() {
        return this.i_field_523beb0a;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof iiIIiII_Class101)) {
            return false;
        }
        iiIIiII_Class101 iiIIiII_Class1012 = (iiIIiII_Class101)object;
        if (this.I_method_86254473() != iiIIiII_Class1012.I_method_86254473()) {
            return false;
        }
        String string = this.i_method_e2e30e21();
        String string2 = iiIIiII_Class1012.i_method_e2e30e21();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.II_method_ae214e1e();
        String string4 = iiIIiII_Class1012.II_method_ae214e1e();
        return !(string3 == null ? string4 != null : !string3.equals(string4));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        long l = this.I_method_86254473();
        n2 = n2 * 59 + (int)(l >>> 32 ^ l);
        String string = this.i_method_e2e30e21();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.II_method_ae214e1e();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "XblXstsToken(expireTimeMs=" + this.I_method_86254473() + ", token=" + this.i_method_e2e30e21() + ", userHash=" + this.II_method_ae214e1e() + ")";
    }
}

