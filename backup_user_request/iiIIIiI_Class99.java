package rockstar.client;

import com.google.gson.JsonObject;
import java.time.Instant;
import lombok.Generated;
import org.jetbrains.annotations.ApiStatus;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIiiiI_Class79;

public final class iiIIIiI_Class99
implements iIIiiiI_Class79 {
    private final long I_field_4a;
    private final String I_field_523beb0a;
    private final String i_field_523beb0a;

    public static iiIIIiI_Class99 I_method_48ebc8a1(JsonObject jsonObject) {
        return iiIIIiI_Class99.I_method_e2be3e16(new IiiiIi_Class30(jsonObject));
    }

    public static iiIIIiI_Class99 I_method_e2be3e16(IiiiIi_Class30 iiiiIi_Class30) {
        return new iiIIIiI_Class99(iiiiIi_Class30.i_method_5239fcca("expireTimeMs"), iiiiIi_Class30.i_method_7caa7e8a("token"), iiiiIi_Class30.i_method_7caa7e8a("titleId"));
    }

    public static JsonObject I_method_876a93bb(iiIIIiI_Class99 iiIIIiI_Class992) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", (Number)1);
        jsonObject.addProperty("expireTimeMs", (Number)iiIIIiI_Class992.I_field_4a);
        jsonObject.addProperty("token", iiIIIiI_Class992.I_field_523beb0a);
        jsonObject.addProperty("titleId", iiIIIiI_Class992.i_field_523beb0a);
        return jsonObject;
    }

    @ApiStatus.Internal
    public static iiIIIiI_Class99 i_method_9dd189f6(IiiiIi_Class30 iiiiIi_Class30) {
        return new iiIIIiI_Class99(Instant.parse(iiiiIi_Class30.i_method_7caa7e8a("NotAfter")).toEpochMilli(), iiiiIi_Class30.i_method_7caa7e8a("Token"), iiiiIi_Class30.i_method_83289561("DisplayClaims").i_method_83289561("xti").i_method_7caa7e8a("tid"));
    }

    @Generated
    public iiIIIiI_Class99(long l, String string, String string2) {
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
    public String I_method_49ec99c1() {
        return this.I_field_523beb0a;
    }

    @Generated
    public String i_method_dd0b49e1() {
        return this.i_field_523beb0a;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof iiIIIiI_Class99)) {
            return false;
        }
        iiIIIiI_Class99 iiIIIiI_Class992 = (iiIIIiI_Class99)object;
        if (this.I_method_86254473() != iiIIIiI_Class992.I_method_86254473()) {
            return false;
        }
        String string = this.I_method_49ec99c1();
        String string2 = iiIIIiI_Class992.I_method_49ec99c1();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.i_method_dd0b49e1();
        String string4 = iiIIIiI_Class992.i_method_dd0b49e1();
        return !(string3 == null ? string4 != null : !string3.equals(string4));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        long l = this.I_method_86254473();
        n2 = n2 * 59 + (int)(l >>> 32 ^ l);
        String string = this.I_method_49ec99c1();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.i_method_dd0b49e1();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "XblTitleToken(expireTimeMs=" + this.I_method_86254473() + ", token=" + this.I_method_49ec99c1() + ", titleId=" + this.i_method_dd0b49e1() + ")";
    }
}

