package rockstar.client;

import com.google.gson.JsonObject;
import lombok.Generated;
import org.jetbrains.annotations.ApiStatus;
import rockstar.client.IiiiIi_Class30;

public final class IIiiiII_Class29 {
    public static final String I_field_523beb0a = "DEFAULT";
    public static final String i_field_523beb0a = "NETHERNET";
    public static final String II_field_523beb0a = "NETHERNET_JSONRPC";
    private final String Ii_field_523beb0a;
    private final String iI_field_523beb0a;
    private final JsonObject I_field_a1a50d2c;

    @ApiStatus.Internal
    public static IIiiiII_Class29 I_method_f76e0596(IiiiIi_Class30 iiiiIi_Class30) {
        return new IIiiiII_Class29(iiiiIi_Class30.i_method_7caa7e8a("address"), iiiiIi_Class30.I_method_3264db60("networkProtocol", I_field_523beb0a), iiiiIi_Class30.I_method_6d0d6596());
    }

    @Generated
    public IIiiiII_Class29(String string, String string2, JsonObject jsonObject) {
        this.Ii_field_523beb0a = string;
        this.iI_field_523beb0a = string2;
        this.I_field_a1a50d2c = jsonObject;
    }

    @Generated
    public String I_method_70f35e01() {
        return this.Ii_field_523beb0a;
    }

    @Generated
    public String i_method_4120e21() {
        return this.iI_field_523beb0a;
    }

    @Generated
    public JsonObject I_method_87de7763() {
        return this.I_field_a1a50d2c;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof IIiiiII_Class29)) {
            return false;
        }
        IIiiiII_Class29 iIiiiII_Class29 = (IIiiiII_Class29)object;
        String string = this.I_method_70f35e01();
        String string2 = iIiiiII_Class29.I_method_70f35e01();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.i_method_4120e21();
        String string4 = iIiiiII_Class29.i_method_4120e21();
        if (string3 == null ? string4 != null : !string3.equals(string4)) {
            return false;
        }
        JsonObject jsonObject = this.I_method_87de7763();
        JsonObject jsonObject2 = iIiiiII_Class29.I_method_87de7763();
        return !(jsonObject == null ? jsonObject2 != null : !jsonObject.equals(jsonObject2));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        String string = this.I_method_70f35e01();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.i_method_4120e21();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        JsonObject jsonObject = this.I_method_87de7763();
        n2 = n2 * 59 + (jsonObject == null ? 43 : jsonObject.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "RealmsJoinInformation(address=" + this.I_method_70f35e01() + ", networkProtocol=" + this.i_method_4120e21() + ", rawResponse=" + this.I_method_87de7763() + ")";
    }
}

