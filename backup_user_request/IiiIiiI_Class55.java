package rockstar.client;

import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import lombok.Generated;
import rockstar.client.IiiIiII_Class53;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIiIIii_Class84;

public final class IiiIiiI_Class55 {
    private final String I_field_523beb0a;
    private final String i_field_523beb0a;
    private final String II_field_523beb0a;
    private final String Ii_field_523beb0a;
    private final IiiIiII_Class53 I_field_c508bfcc;

    public static IiiIiiI_Class55 I_method_ff96b061(JsonObject jsonObject) {
        return IiiIiiI_Class55.I_method_213615d6(new IiiiIi_Class30(jsonObject));
    }

    public static IiiIiiI_Class55 I_method_213615d6(IiiiIi_Class30 iiiiIi_Class30) {
        return new IiiIiiI_Class55(iiiiIi_Class30.i_method_7caa7e8a("clientId"), iiiiIi_Class30.i_method_7caa7e8a("scope"), iiiiIi_Class30.I_method_3264db60("clientSecret", null), iiiiIi_Class30.I_method_3264db60("redirectUri", null), IiiIiII_Class53.valueOf(iiiiIi_Class30.I_method_3264db60("environment", IiiIiII_Class53.I_field_c508bfcc.name())));
    }

    public static JsonObject I_method_24a67fbb(IiiIiiI_Class55 iiiIiiI_Class55) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", (Number)1);
        jsonObject.addProperty("clientId", iiiIiiI_Class55.I_field_523beb0a);
        jsonObject.addProperty("scope", iiiIiiI_Class55.i_field_523beb0a);
        jsonObject.addProperty("clientSecret", iiiIiiI_Class55.II_field_523beb0a);
        jsonObject.addProperty("redirectUri", iiiIiiI_Class55.Ii_field_523beb0a);
        jsonObject.addProperty("environment", iiiIiiI_Class55.I_field_c508bfcc.name());
        return jsonObject;
    }

    public IiiIiiI_Class55(String string, String string2) {
        this(string, string2, null, null, IiiIiII_Class53.I_field_c508bfcc);
    }

    public boolean I_method_e84624a3() {
        return !iIiIIii_Class84.i_method_d974b44d(this.I_field_523beb0a);
    }

    public Map<String, String> I_method_15b03494() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("client_id", this.I_field_523beb0a);
        hashMap.put("scope", this.i_field_523beb0a);
        if (this.Ii_field_523beb0a != null) {
            hashMap.put("redirect_uri", this.Ii_field_523beb0a);
        }
        hashMap.put("response_type", "code");
        hashMap.put("response_mode", "query");
        return hashMap;
    }

    @Generated
    public String I_method_d01bc1e1() {
        return this.I_field_523beb0a;
    }

    @Generated
    public String i_method_633a7201() {
        return this.i_field_523beb0a;
    }

    @Generated
    public String II_method_38b6663e() {
        return this.II_field_523beb0a;
    }

    @Generated
    public String Ii_method_cbd5165e() {
        return this.Ii_field_523beb0a;
    }

    @Generated
    public IiiIiII_Class53 I_method_37e8d915() {
        return this.I_field_c508bfcc;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof IiiIiiI_Class55)) {
            return false;
        }
        IiiIiiI_Class55 iiiIiiI_Class55 = (IiiIiiI_Class55)object;
        String string = this.I_method_d01bc1e1();
        String string2 = iiiIiiI_Class55.I_method_d01bc1e1();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.i_method_633a7201();
        String string4 = iiiIiiI_Class55.i_method_633a7201();
        if (string3 == null ? string4 != null : !string3.equals(string4)) {
            return false;
        }
        String string5 = this.II_method_38b6663e();
        String string6 = iiiIiiI_Class55.II_method_38b6663e();
        if (string5 == null ? string6 != null : !string5.equals(string6)) {
            return false;
        }
        String string7 = this.Ii_method_cbd5165e();
        String string8 = iiiIiiI_Class55.Ii_method_cbd5165e();
        if (string7 == null ? string8 != null : !string7.equals(string8)) {
            return false;
        }
        IiiIiII_Class53 iiiIiII_Class53 = this.I_method_37e8d915();
        IiiIiII_Class53 iiiIiII_Class532 = iiiIiiI_Class55.I_method_37e8d915();
        return !(iiiIiII_Class53 == null ? iiiIiII_Class532 != null : !((Object)((Object)iiiIiII_Class53)).equals((Object)iiiIiII_Class532));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        String string = this.I_method_d01bc1e1();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.i_method_633a7201();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        String string3 = this.II_method_38b6663e();
        n2 = n2 * 59 + (string3 == null ? 43 : string3.hashCode());
        String string4 = this.Ii_method_cbd5165e();
        n2 = n2 * 59 + (string4 == null ? 43 : string4.hashCode());
        IiiIiII_Class53 iiiIiII_Class53 = this.I_method_37e8d915();
        n2 = n2 * 59 + (iiiIiII_Class53 == null ? 43 : ((Object)((Object)iiiIiII_Class53)).hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "MsaApplicationConfig(clientId=" + this.I_method_d01bc1e1() + ", scope=" + this.i_method_633a7201() + ", clientSecret=" + this.II_method_38b6663e() + ", redirectUri=" + this.Ii_method_cbd5165e() + ", environment=" + (Object)((Object)this.I_method_37e8d915()) + ")";
    }

    @Generated
    public IiiIiiI_Class55 I_method_f303333f(String string) {
        return this.I_field_523beb0a == string ? this : new IiiIiiI_Class55(string, this.i_field_523beb0a, this.II_field_523beb0a, this.Ii_field_523beb0a, this.I_field_c508bfcc);
    }

    @Generated
    public IiiIiiI_Class55 i_method_21f4e71f(String string) {
        return this.i_field_523beb0a == string ? this : new IiiIiiI_Class55(this.I_field_523beb0a, string, this.II_field_523beb0a, this.Ii_field_523beb0a, this.I_field_c508bfcc);
    }

    @Generated
    public IiiIiiI_Class55 II_method_70dc4182(String string) {
        return this.II_field_523beb0a == string ? this : new IiiIiiI_Class55(this.I_field_523beb0a, this.i_field_523beb0a, string, this.Ii_field_523beb0a, this.I_field_c508bfcc);
    }

    @Generated
    public IiiIiiI_Class55 Ii_method_9fcdf562(String string) {
        return this.Ii_field_523beb0a == string ? this : new IiiIiiI_Class55(this.I_field_523beb0a, this.i_field_523beb0a, this.II_field_523beb0a, string, this.I_field_c508bfcc);
    }

    @Generated
    public IiiIiiI_Class55 I_method_bbe7d79d(IiiIiII_Class53 iiiIiII_Class53) {
        return this.I_field_c508bfcc == iiiIiII_Class53 ? this : new IiiIiiI_Class55(this.I_field_523beb0a, this.i_field_523beb0a, this.II_field_523beb0a, this.Ii_field_523beb0a, iiiIiII_Class53);
    }

    @Generated
    public IiiIiiI_Class55(String string, String string2, String string3, String string4, IiiIiII_Class53 iiiIiII_Class53) {
        this.I_field_523beb0a = string;
        this.i_field_523beb0a = string2;
        this.II_field_523beb0a = string3;
        this.Ii_field_523beb0a = string4;
        this.I_field_c508bfcc = iiiIiII_Class53;
    }
}

