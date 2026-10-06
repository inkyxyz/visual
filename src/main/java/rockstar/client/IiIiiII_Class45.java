package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.security.KeyPair;
import java.util.Arrays;
import java.util.Base64;
import lombok.Generated;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIiiiI_Class79;
import rockstar.client.iIIiiii_Class80;

public final class IiIiiII_Class45
implements iIIiiiI_Class79 {
    private final long I_field_4a;
    private final KeyPair I_field_240b2c30;
    private final byte[] I_field_b47;
    private final byte[] i_field_b47;

    public static IiIiiII_Class45 I_method_7aea98a1(JsonObject jsonObject) {
        return IiIiiII_Class45.I_method_d6b10e16(new IiiiIi_Class30(jsonObject));
    }

    public static IiIiiII_Class45 I_method_d6b10e16(IiiiIi_Class30 iiiiIi_Class30) {
        return new IiIiiII_Class45(iiiiIi_Class30.i_method_5239fcca("expireTimeMs"), iIIiiii_Class80.I_method_dcbfd87a(iiiiIi_Class30.i_method_83289561("keyPair")), Base64.getDecoder().decode(iiiiIi_Class30.i_method_7caa7e8a("publicKeySignature")), iiiiIi_Class30.ii_method_999a5f26("legacyPublicKeySignature").map(Base64.getDecoder()::decode).orElse(null));
    }

    public static JsonObject I_method_97ab93bb(IiIiiII_Class45 iiIiiII_Class45) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", (Number)1);
        jsonObject.addProperty("expireTimeMs", (Number)iiIiiII_Class45.I_field_4a);
        jsonObject.add("keyPair", (JsonElement)iIIiiii_Class80.I_method_5397a57(iiIiiII_Class45.I_field_240b2c30));
        jsonObject.addProperty("publicKeySignature", Base64.getEncoder().encodeToString(iiIiiII_Class45.I_field_b47));
        if (iiIiiII_Class45.i_field_b47 != null) {
            jsonObject.addProperty("legacyPublicKeySignature", Base64.getEncoder().encodeToString(iiIiiII_Class45.i_field_b47));
        }
        return jsonObject;
    }

    @Generated
    public IiIiiII_Class45(long l, KeyPair keyPair, byte[] byArray, byte[] byArray2) {
        this.I_field_4a = l;
        this.I_field_240b2c30 = keyPair;
        this.I_field_b47 = byArray;
        this.i_field_b47 = byArray2;
    }

    @Override
    @Generated
    public long I_method_86254473() {
        return this.I_field_4a;
    }

    @Generated
    public KeyPair I_method_82977fd9() {
        return this.I_field_240b2c30;
    }

    @Generated
    public byte[] I_method_10f09ffe() {
        return this.I_field_b47;
    }

    @Generated
    public byte[] i_method_12b3901e() {
        return this.i_field_b47;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof IiIiiII_Class45)) {
            return false;
        }
        IiIiiII_Class45 iiIiiII_Class45 = (IiIiiII_Class45)object;
        if (this.I_method_86254473() != iiIiiII_Class45.I_method_86254473()) {
            return false;
        }
        KeyPair keyPair = this.I_method_82977fd9();
        KeyPair keyPair2 = iiIiiII_Class45.I_method_82977fd9();
        if (keyPair == null ? keyPair2 != null : !keyPair.equals(keyPair2)) {
            return false;
        }
        if (!Arrays.equals(this.I_method_10f09ffe(), iiIiiII_Class45.I_method_10f09ffe())) {
            return false;
        }
        return Arrays.equals(this.i_method_12b3901e(), iiIiiII_Class45.i_method_12b3901e());
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        long l = this.I_method_86254473();
        n2 = n2 * 59 + (int)(l >>> 32 ^ l);
        KeyPair keyPair = this.I_method_82977fd9();
        n2 = n2 * 59 + (keyPair == null ? 43 : keyPair.hashCode());
        n2 = n2 * 59 + Arrays.hashCode(this.I_method_10f09ffe());
        n2 = n2 * 59 + Arrays.hashCode(this.i_method_12b3901e());
        return n2;
    }

    @Generated
    public String toString() {
        return "MinecraftPlayerCertificates(expireTimeMs=" + this.I_method_86254473() + ", keyPair=" + this.I_method_82977fd9() + ", publicKeySignature=" + Arrays.toString(this.I_method_10f09ffe()) + ", legacyPublicKeySignature=" + Arrays.toString(this.i_method_12b3901e()) + ")";
    }
}

