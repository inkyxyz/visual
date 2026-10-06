package rockstar.client;

import com.google.gson.JsonObject;
import java.time.Instant;
import lombok.Generated;
import org.jetbrains.annotations.ApiStatus;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIiiiI_Class79;

public final class iIIiIII_Class73
implements iIIiiiI_Class79 {
    private final long I_field_4a;
    private final String I_field_523beb0a;
    private final String i_field_523beb0a;
    private final String II_field_523beb0a;

    public static iIIiIII_Class73 I_method_73f0c861(JsonObject jsonObject) {
        return iIIiIII_Class73.I_method_b8f62dd6(new IiiiIi_Class30(jsonObject));
    }

    public static iIIiIII_Class73 I_method_b8f62dd6(IiiiIi_Class30 iiiiIi_Class30) {
        return new iIIiIII_Class73(iiiiIi_Class30.i_method_5239fcca("expireTimeMs"), iiiiIi_Class30.i_method_7caa7e8a("token"), iiiiIi_Class30.i_method_7caa7e8a("entityId"), iiiiIi_Class30.i_method_7caa7e8a("entityType"));
    }

    public static JsonObject I_method_637dffbb(iIIiIII_Class73 iIIiIII_Class732) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", (Number)1);
        jsonObject.addProperty("expireTimeMs", (Number)iIIiIII_Class732.I_field_4a);
        jsonObject.addProperty("token", iIIiIII_Class732.I_field_523beb0a);
        jsonObject.addProperty("entityId", iIIiIII_Class732.i_field_523beb0a);
        jsonObject.addProperty("entityType", iIIiIII_Class732.II_field_523beb0a);
        return jsonObject;
    }

    @ApiStatus.Internal
    public static iIIiIII_Class73 i_method_740979b6(IiiiIi_Class30 iiiiIi_Class30) {
        IiiiIi_Class30 iiiiIi_Class302 = iiiiIi_Class30.i_method_83289561("Entity");
        return new iIIiIII_Class73(Instant.parse(iiiiIi_Class30.i_method_7caa7e8a("TokenExpiration")).toEpochMilli(), iiiiIi_Class30.i_method_7caa7e8a("EntityToken"), iiiiIi_Class302.i_method_7caa7e8a("Id"), iiiiIi_Class302.i_method_7caa7e8a("Type"));
    }

    @Generated
    public iIIiIII_Class73(long l, String string, String string2, String string3) {
        this.I_field_4a = l;
        this.I_field_523beb0a = string;
        this.i_field_523beb0a = string2;
        this.II_field_523beb0a = string3;
    }

    @Override
    @Generated
    public long I_method_86254473() {
        return this.I_field_4a;
    }

    @Generated
    public String I_method_eac435e1() {
        return this.I_field_523beb0a;
    }

    @Generated
    public String i_method_7de2e601() {
        return this.i_field_523beb0a;
    }

    @Generated
    public String II_method_731c723e() {
        return this.II_field_523beb0a;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof iIIiIII_Class73)) {
            return false;
        }
        iIIiIII_Class73 iIIiIII_Class732 = (iIIiIII_Class73)object;
        if (this.I_method_86254473() != iIIiIII_Class732.I_method_86254473()) {
            return false;
        }
        String string = this.I_method_eac435e1();
        String string2 = iIIiIII_Class732.I_method_eac435e1();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.i_method_7de2e601();
        String string4 = iIIiIII_Class732.i_method_7de2e601();
        if (string3 == null ? string4 != null : !string3.equals(string4)) {
            return false;
        }
        String string5 = this.II_method_731c723e();
        String string6 = iIIiIII_Class732.II_method_731c723e();
        return !(string5 == null ? string6 != null : !string5.equals(string6));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        long l = this.I_method_86254473();
        n2 = n2 * 59 + (int)(l >>> 32 ^ l);
        String string = this.I_method_eac435e1();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.i_method_7de2e601();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        String string3 = this.II_method_731c723e();
        n2 = n2 * 59 + (string3 == null ? 43 : string3.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "PlayFabEntityToken(expireTimeMs=" + this.I_method_86254473() + ", token=" + this.I_method_eac435e1() + ", entityId=" + this.i_method_7de2e601() + ", entityType=" + this.II_method_731c723e() + ")";
    }
}

