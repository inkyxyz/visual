package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.Generated;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIiIII_Class73;
import rockstar.client.iIIiiiI_Class79;

public final class iIIiIIi_Class74
implements iIIiiiI_Class79 {
    private final iIIiIII_Class73 I_field_ef8043ec;
    private final String I_field_523beb0a;
    private final String i_field_523beb0a;

    public static iIIiIIi_Class74 I_method_1193b021(JsonObject jsonObject) {
        return iIIiIIi_Class74.I_method_fc660596(new IiiiIi_Class30(jsonObject));
    }

    public static iIIiIIi_Class74 I_method_fc660596(IiiiIi_Class30 iiiiIi_Class30) {
        if (iiiiIi_Class30.i_method_5239fcc9("_saveVersion") == 1) {
            iIIiIII_Class73 iIIiIII_Class732 = new iIIiIII_Class73(iiiiIi_Class30.i_method_5239fcca("expireTimeMs"), iiiiIi_Class30.i_method_7caa7e8a("entityToken"), iiiiIi_Class30.i_method_7caa7e8a("entityId"), "title_player_account");
            return new iIIiIIi_Class74(iIIiIII_Class732, iiiiIi_Class30.i_method_7caa7e8a("playFabId"), iiiiIi_Class30.i_method_7caa7e8a("sessionTicket"));
        }
        return new iIIiIIi_Class74(iIIiIII_Class73.I_method_b8f62dd6(iiiiIi_Class30.I_method_2f104541("entityToken")), iiiiIi_Class30.i_method_7caa7e8a("playFabId"), iiiiIi_Class30.i_method_7caa7e8a("sessionTicket"));
    }

    public static JsonObject I_method_9e39ebbb(iIIiIIi_Class74 iIIiIIi_Class742) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", (Number)2);
        jsonObject.add("entityToken", (JsonElement)iIIiIII_Class73.I_method_637dffbb(iIIiIIi_Class742.I_field_ef8043ec));
        jsonObject.addProperty("playFabId", iIIiIIi_Class742.I_field_523beb0a);
        jsonObject.addProperty("sessionTicket", iIIiIIi_Class742.i_field_523beb0a);
        return jsonObject;
    }

    @Override
    public long I_method_86254473() {
        return this.I_field_ef8043ec.I_method_86254473();
    }

    @Deprecated
    public String I_method_30f75e01() {
        return this.I_field_ef8043ec.i_method_7de2e601();
    }

    @Generated
    public iIIiIIi_Class74(iIIiIII_Class73 iIIiIII_Class732, String string, String string2) {
        this.I_field_ef8043ec = iIIiIII_Class732;
        this.I_field_523beb0a = string;
        this.i_field_523beb0a = string2;
    }

    @Generated
    public iIIiIII_Class73 I_method_98a2dd15() {
        return this.I_field_ef8043ec;
    }

    @Generated
    public String i_method_c4160e21() {
        return this.I_field_523beb0a;
    }

    @Generated
    public String II_method_f34e4e1e() {
        return this.i_field_523beb0a;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof iIIiIIi_Class74)) {
            return false;
        }
        iIIiIIi_Class74 iIIiIIi_Class742 = (iIIiIIi_Class74)object;
        iIIiIII_Class73 iIIiIII_Class732 = this.I_method_98a2dd15();
        iIIiIII_Class73 iIIiIII_Class733 = iIIiIIi_Class742.I_method_98a2dd15();
        if (iIIiIII_Class732 == null ? iIIiIII_Class733 != null : !((Object)iIIiIII_Class732).equals(iIIiIII_Class733)) {
            return false;
        }
        String string = this.i_method_c4160e21();
        String string2 = iIIiIIi_Class742.i_method_c4160e21();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.II_method_f34e4e1e();
        String string4 = iIIiIIi_Class742.II_method_f34e4e1e();
        return !(string3 == null ? string4 != null : !string3.equals(string4));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        iIIiIII_Class73 iIIiIII_Class732 = this.I_method_98a2dd15();
        n2 = n2 * 59 + (iIIiIII_Class732 == null ? 43 : ((Object)iIIiIII_Class732).hashCode());
        String string = this.i_method_c4160e21();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.II_method_f34e4e1e();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "PlayFabToken(entityToken=" + this.I_method_98a2dd15() + ", playFabId=" + this.i_method_c4160e21() + ", sessionTicket=" + this.II_method_f34e4e1e() + ")";
    }
}

