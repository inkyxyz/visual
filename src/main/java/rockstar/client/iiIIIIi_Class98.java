package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.Generated;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iiIIIiI_Class99;
import rockstar.client.iiIIIii_Class100;
import rockstar.client.iiIIiII_Class101;

public final class iiIIIIi_Class98 {
    private final iiIIIii_Class100 I_field_8a8537ec;
    private final iiIIIiI_Class99 I_field_8a85340c;
    private final iiIIiII_Class101 I_field_8a9347cc;

    public static iiIIIIi_Class98 I_method_cfd4a021(JsonObject jsonObject) {
        return iiIIIIi_Class98.I_method_fba2f596(new IiiiIi_Class30(jsonObject));
    }

    public static iiIIIIi_Class98 I_method_fba2f596(IiiiIi_Class30 iiiiIi_Class30) {
        return new iiIIIIi_Class98(iiIIIii_Class100.I_method_262e15d6(iiiiIi_Class30.I_method_2f104541("userToken")), iiIIIiI_Class99.I_method_e2be3e16(iiiiIi_Class30.I_method_2f104541("titleToken")), iiIIiII_Class101.I_method_df0c0596(iiiiIi_Class30.I_method_2f104541("xstsToken")));
    }

    public static JsonObject I_method_a564ebbb(iiIIIIi_Class98 iiIIIIi_Class982) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", (Number)1);
        jsonObject.add("userToken", (JsonElement)iiIIIii_Class100.I_method_c2267fbb(iiIIIIi_Class982.I_field_8a8537ec));
        jsonObject.add("titleToken", (JsonElement)iiIIIiI_Class99.I_method_876a93bb(iiIIIIi_Class982.I_field_8a85340c));
        jsonObject.add("xstsToken", (JsonElement)iiIIiII_Class101.I_method_e619ebbb(iiIIIIi_Class982.I_field_8a9347cc));
        return jsonObject;
    }

    @Generated
    public iiIIIIi_Class98(iiIIIii_Class100 iiIIIii_Class1002, iiIIIiI_Class99 iiIIIiI_Class992, iiIIiII_Class101 iiIIiII_Class1012) {
        this.I_field_8a8537ec = iiIIIii_Class1002;
        this.I_field_8a85340c = iiIIIiI_Class992;
        this.I_field_8a9347cc = iiIIiII_Class1012;
    }

    @Generated
    public iiIIIii_Class100 I_method_53c84915() {
        return this.I_field_8a8537ec;
    }

    @Generated
    public iiIIIiI_Class99 I_method_53c84535() {
        return this.I_field_8a85340c;
    }

    @Generated
    public iiIIiII_Class101 I_method_53d658f5() {
        return this.I_field_8a9347cc;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof iiIIIIi_Class98)) {
            return false;
        }
        iiIIIIi_Class98 iiIIIIi_Class982 = (iiIIIIi_Class98)object;
        iiIIIii_Class100 iiIIIii_Class1002 = this.I_method_53c84915();
        iiIIIii_Class100 iiIIIii_Class1003 = iiIIIIi_Class982.I_method_53c84915();
        if (iiIIIii_Class1002 == null ? iiIIIii_Class1003 != null : !((Object)iiIIIii_Class1002).equals(iiIIIii_Class1003)) {
            return false;
        }
        iiIIIiI_Class99 iiIIIiI_Class992 = this.I_method_53c84535();
        iiIIIiI_Class99 iiIIIiI_Class993 = iiIIIIi_Class982.I_method_53c84535();
        if (iiIIIiI_Class992 == null ? iiIIIiI_Class993 != null : !((Object)iiIIIiI_Class992).equals(iiIIIiI_Class993)) {
            return false;
        }
        iiIIiII_Class101 iiIIiII_Class1012 = this.I_method_53d658f5();
        iiIIiII_Class101 iiIIiII_Class1013 = iiIIIIi_Class982.I_method_53d658f5();
        return !(iiIIiII_Class1012 == null ? iiIIiII_Class1013 != null : !((Object)iiIIiII_Class1012).equals(iiIIiII_Class1013));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        iiIIIii_Class100 iiIIIii_Class1002 = this.I_method_53c84915();
        n2 = n2 * 59 + (iiIIIii_Class1002 == null ? 43 : ((Object)iiIIIii_Class1002).hashCode());
        iiIIIiI_Class99 iiIIIiI_Class992 = this.I_method_53c84535();
        n2 = n2 * 59 + (iiIIIiI_Class992 == null ? 43 : ((Object)iiIIIiI_Class992).hashCode());
        iiIIiII_Class101 iiIIiII_Class1012 = this.I_method_53d658f5();
        n2 = n2 * 59 + (iiIIiII_Class1012 == null ? 43 : ((Object)iiIIiII_Class1012).hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "XblSisuTokens(userToken=" + this.I_method_53c84915() + ", titleToken=" + this.I_method_53c84535() + ", xstsToken=" + this.I_method_53d658f5() + ")";
    }
}

