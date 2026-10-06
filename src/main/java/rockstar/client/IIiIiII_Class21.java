package rockstar.client;

import com.google.gson.JsonObject;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import lombok.Generated;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIiiiI_Class79;
import rockstar.client.iIiiiIi_Class94;

public final class IIiIiII_Class21
implements iIIiiiI_Class79 {
    private final long I_field_4a;
    private final String I_field_523beb0a;
    private final AtomicReference<Object> I_field_c74d0693 = new AtomicReference();

    public static IIiIiII_Class21 I_method_da24afe1(JsonObject jsonObject) {
        return IIiIiII_Class21.I_method_4329f556(new IiiiIi_Class30(jsonObject));
    }

    public static IIiIiII_Class21 I_method_4329f556(IiiiIi_Class30 iiiiIi_Class30) {
        return new IIiIiII_Class21(iiiiIi_Class30.i_method_5239fcca("expireTimeMs"), iiiiIi_Class30.i_method_7caa7e8a("token"));
    }

    public static JsonObject I_method_e0d57bb(IIiIiII_Class21 iIiIiII_Class21) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", (Number)1);
        jsonObject.addProperty("expireTimeMs", (Number)iIiIiII_Class21.I_field_4a);
        jsonObject.addProperty("token", iIiIiII_Class21.I_field_523beb0a);
        return jsonObject;
    }

    public String I_method_35c8fa21() {
        return this.I_method_20d90095().i_method_754a5ff8().i_method_7caa7e8a("xname");
    }

    public String i_method_c8e7aa41() {
        return this.I_method_20d90095().i_method_754a5ff8().i_method_7caa7e8a("xid");
    }

    public UUID I_method_94df5cab() {
        return UUID.nameUUIDFromBytes(("pocket-auth-1-xuid:" + this.i_method_c8e7aa41()).getBytes(StandardCharsets.UTF_8));
    }

    @Generated
    public IIiIiII_Class21(long l, String string) {
        this.I_field_4a = l;
        this.I_field_523beb0a = string;
    }

    @Override
    @Generated
    public long I_method_86254473() {
        return this.I_field_4a;
    }

    @Generated
    public String II_method_88b035fe() {
        return this.I_field_523beb0a;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof IIiIiII_Class21)) {
            return false;
        }
        IIiIiII_Class21 iIiIiII_Class21 = (IIiIiII_Class21)object;
        if (this.I_method_86254473() != iIiIiII_Class21.I_method_86254473()) {
            return false;
        }
        String string = this.II_method_88b035fe();
        String string2 = iIiIiII_Class21.II_method_88b035fe();
        return !(string == null ? string2 != null : !string.equals(string2));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        long l = this.I_method_86254473();
        n2 = n2 * 59 + (int)(l >>> 32 ^ l);
        String string = this.II_method_88b035fe();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "MinecraftMultiplayerToken(expireTimeMs=" + this.I_method_86254473() + ", token=" + this.II_method_88b035fe() + ")";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Generated
    public iIiiiIi_Class94 I_method_20d90095() {
        Object object = this.I_field_c74d0693.get();
        if (object == null) {
            AtomicReference<Object> atomicReference = this.I_field_c74d0693;
            synchronized (atomicReference) {
                object = this.I_field_c74d0693.get();
                if (object == null) {
                    iIiiiIi_Class94 iIiiiIi_Class942 = iIiiiIi_Class94.I_method_a9c23a7f(this.I_field_523beb0a);
                    object = iIiiiIi_Class942 == null ? this.I_field_c74d0693 : iIiiiIi_Class942;
                    this.I_field_c74d0693.set(object);
                }
            }
        }
        return (iIiiiIi_Class94)(object == this.I_field_c74d0693 ? null : object);
    }
}

