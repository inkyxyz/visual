package rockstar.client;

import com.google.gson.JsonObject;
import lombok.Generated;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIiiiI_Class79;

public final class IiiiIII_Class57
implements iIIiiiI_Class79 {
    private final long I_field_4a;
    private final long i_field_4a;
    private final String I_field_523beb0a;
    private final String i_field_523beb0a;
    private final String II_field_523beb0a;

    public static IiiiIII_Class57 I_method_78cba8a1(JsonObject jsonObject) {
        return IiiiIII_Class57.I_method_84161e16(new IiiiIi_Class30(jsonObject));
    }

    public static IiiiIII_Class57 I_method_84161e16(IiiiIi_Class30 iiiiIi_Class30) {
        return new IiiiIII_Class57(iiiiIi_Class30.i_method_5239fcca("expireTimeMs"), iiiiIi_Class30.i_method_5239fcca("intervalMs"), iiiiIi_Class30.i_method_7caa7e8a("deviceCode"), iiiiIi_Class30.i_method_7caa7e8a("userCode"), iiiiIi_Class30.i_method_7caa7e8a("verificationUri"));
    }

    public static JsonObject I_method_7f2093bb(IiiiIII_Class57 iiiiIII_Class57) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", (Number)1);
        jsonObject.addProperty("expireTimeMs", (Number)iiiiIII_Class57.I_field_4a);
        jsonObject.addProperty("intervalMs", (Number)iiiiIII_Class57.i_field_4a);
        jsonObject.addProperty("deviceCode", iiiiIII_Class57.I_field_523beb0a);
        jsonObject.addProperty("userCode", iiiiIII_Class57.i_field_523beb0a);
        jsonObject.addProperty("verificationUri", iiiiIII_Class57.II_field_523beb0a);
        return jsonObject;
    }

    public String I_method_50aa9c1() {
        return this.II_field_523beb0a + "?otc=" + this.i_field_523beb0a;
    }

    @Generated
    public IiiiIII_Class57(long l, long l2, String string, String string2, String string3) {
        this.I_field_4a = l;
        this.i_field_4a = l2;
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
    public long i_method_d7f58c93() {
        return this.i_field_4a;
    }

    @Generated
    public String i_method_982959e1() {
        return this.I_field_523beb0a;
    }

    @Generated
    public String II_method_a1a47a5e() {
        return this.i_field_523beb0a;
    }

    @Generated
    public String Ii_method_34c32a7e() {
        return this.II_field_523beb0a;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof IiiiIII_Class57)) {
            return false;
        }
        IiiiIII_Class57 iiiiIII_Class57 = (IiiiIII_Class57)object;
        if (this.I_method_86254473() != iiiiIII_Class57.I_method_86254473()) {
            return false;
        }
        if (this.i_method_d7f58c93() != iiiiIII_Class57.i_method_d7f58c93()) {
            return false;
        }
        String string = this.i_method_982959e1();
        String string2 = iiiiIII_Class57.i_method_982959e1();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.II_method_a1a47a5e();
        String string4 = iiiiIII_Class57.II_method_a1a47a5e();
        if (string3 == null ? string4 != null : !string3.equals(string4)) {
            return false;
        }
        String string5 = this.Ii_method_34c32a7e();
        String string6 = iiiiIII_Class57.Ii_method_34c32a7e();
        return !(string5 == null ? string6 != null : !string5.equals(string6));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        long l = this.I_method_86254473();
        n2 = n2 * 59 + (int)(l >>> 32 ^ l);
        long l2 = this.i_method_d7f58c93();
        n2 = n2 * 59 + (int)(l2 >>> 32 ^ l2);
        String string = this.i_method_982959e1();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.II_method_a1a47a5e();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        String string3 = this.Ii_method_34c32a7e();
        n2 = n2 * 59 + (string3 == null ? 43 : string3.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "MsaDeviceCode(expireTimeMs=" + this.I_method_86254473() + ", intervalMs=" + this.i_method_d7f58c93() + ", deviceCode=" + this.i_method_982959e1() + ", userCode=" + this.II_method_a1a47a5e() + ", verificationUri=" + this.Ii_method_34c32a7e() + ")";
    }
}

