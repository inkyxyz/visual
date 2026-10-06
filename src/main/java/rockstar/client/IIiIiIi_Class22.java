package rockstar.client;

import com.google.gson.JsonObject;
import java.util.concurrent.atomic.AtomicReference;
import lombok.Generated;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIiiiI_Class79;
import rockstar.client.iIiiiIi_Class94;

public final class IIiIiIi_Class22
implements iIIiiiI_Class79 {
    private final long I_field_4a;
    private final String I_field_523beb0a;
    private final AtomicReference<Object> I_field_c74d0693 = new AtomicReference();

    public static IIiIiIi_Class22 I_method_77c797a1(JsonObject jsonObject) {
        return IIiIiIi_Class22.I_method_8699cd16(new IiiiIi_Class30(jsonObject));
    }

    public static IIiIiIi_Class22 I_method_8699cd16(IiiiIi_Class30 iiiiIi_Class30) {
        return new IIiIiIi_Class22(iiiiIi_Class30.i_method_5239fcca("expireTimeMs"), iiiiIi_Class30.i_method_7caa7e8a("authorizationHeader"));
    }

    public static JsonObject I_method_48c943bb(IIiIiIi_Class22 iIiIiRockstarClient2) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", (Number)1);
        jsonObject.addProperty("expireTimeMs", (Number)iIiIiRockstarClient2.I_field_4a);
        jsonObject.addProperty("authorizationHeader", iIiIiRockstarClient2.I_field_523beb0a);
        return jsonObject;
    }

    @Generated
    public IIiIiIi_Class22(long l, String string) {
        this.I_field_4a = l;
        this.I_field_523beb0a = string;
    }

    @Override
    @Generated
    public long I_method_86254473() {
        return this.I_field_4a;
    }

    @Generated
    public String I_method_7bfc2241() {
        return this.I_field_523beb0a;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof IIiIiIi_Class22)) {
            return false;
        }
        IIiIiIi_Class22 iIiIiRockstarClient2 = (IIiIiIi_Class22)object;
        if (this.I_method_86254473() != iIiIiRockstarClient2.I_method_86254473()) {
            return false;
        }
        String string = this.I_method_7bfc2241();
        String string2 = iIiIiRockstarClient2.I_method_7bfc2241();
        return !(string == null ? string2 != null : !string.equals(string2));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        long l = this.I_method_86254473();
        n2 = n2 * 59 + (int)(l >>> 32 ^ l);
        String string = this.I_method_7bfc2241();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "MinecraftSession(expireTimeMs=" + this.I_method_86254473() + ", authorizationHeader=" + this.I_method_7bfc2241() + ")";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Generated
    public iIiiiIi_Class94 I_method_366e7475() {
        Object object = this.I_field_c74d0693.get();
        if (object == null) {
            AtomicReference<Object> atomicReference = this.I_field_c74d0693;
            synchronized (atomicReference) {
                object = this.I_field_c74d0693.get();
                if (object == null) {
                    iIiiiIi_Class94 iIiiiIi_Class942 = iIiiiIi_Class94.I_method_a9c23a7f(this.I_field_523beb0a.split(" ", 2)[1]);
                    object = iIiiiIi_Class942 == null ? this.I_field_c74d0693 : iIiiiIi_Class942;
                    this.I_field_c74d0693.set(object);
                }
            }
        }
        return (iIiiiIi_Class94)(object == this.I_field_c74d0693 ? null : object);
    }
}

