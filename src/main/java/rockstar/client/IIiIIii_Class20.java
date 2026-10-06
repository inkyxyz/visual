package rockstar.client;

import com.google.gson.JsonObject;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import lombok.Generated;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIiiiI_Class79;
import rockstar.client.iIiiiIi_Class94;

public final class IIiIIii_Class20
implements iIIiiiI_Class79 {
    private final String I_field_523beb0a;
    private final String i_field_523beb0a;
    private final AtomicReference<Object> I_field_c74d0693 = new AtomicReference();
    private final AtomicReference<Object> i_field_c74d0693 = new AtomicReference();

    public static IIiIIii_Class20 I_method_cdf9b021(JsonObject jsonObject) {
        return IIiIIii_Class20.I_method_8a4c0596(new IiiiIi_Class30(jsonObject));
    }

    public static IIiIIii_Class20 I_method_8a4c0596(IiiiIi_Class30 iiiiIi_Class30) {
        return new IIiIIii_Class20(iiiiIi_Class30.i_method_7caa7e8a("mojangJwt"), iiiiIi_Class30.i_method_7caa7e8a("identityJwt"));
    }

    public static JsonObject I_method_ea19ebbb(IIiIIii_Class20 iIiIIii_Class20) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", (Number)1);
        jsonObject.addProperty("mojangJwt", iIiIIii_Class20.I_field_523beb0a);
        jsonObject.addProperty("identityJwt", iIiIIii_Class20.i_field_523beb0a);
        return jsonObject;
    }

    @Override
    public long I_method_86254473() {
        return Math.min(this.I_method_cd7f80b5().I_method_86254473(), this.i_method_e7a06c95().I_method_86254473());
    }

    public String I_method_76245e01() {
        return this.i_method_e7a06c95().i_method_754a5ff8().i_method_83289561("extraData").i_method_7caa7e8a("displayName");
    }

    public String i_method_9430e21() {
        return this.i_method_e7a06c95().i_method_754a5ff8().i_method_83289561("extraData").i_method_7caa7e8a("XUID");
    }

    public UUID I_method_b282388b() {
        return UUID.fromString(this.i_method_e7a06c95().i_method_754a5ff8().i_method_83289561("extraData").i_method_7caa7e8a("identity"));
    }

    @Generated
    public IIiIIii_Class20(String string, String string2) {
        this.I_field_523beb0a = string;
        this.i_field_523beb0a = string2;
    }

    @Generated
    public String II_method_53c14e1e() {
        return this.I_field_523beb0a;
    }

    @Generated
    public String Ii_method_e6dffe3e() {
        return this.i_field_523beb0a;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof IIiIIii_Class20)) {
            return false;
        }
        IIiIIii_Class20 iIiIIii_Class20 = (IIiIIii_Class20)object;
        String string = this.II_method_53c14e1e();
        String string2 = iIiIIii_Class20.II_method_53c14e1e();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.Ii_method_e6dffe3e();
        String string4 = iIiIIii_Class20.Ii_method_e6dffe3e();
        return !(string3 == null ? string4 != null : !string3.equals(string4));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        String string = this.II_method_53c14e1e();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.Ii_method_e6dffe3e();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "MinecraftCertificateChain(mojangJwt=" + this.II_method_53c14e1e() + ", identityJwt=" + this.Ii_method_e6dffe3e() + ")";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Generated
    public iIiiiIi_Class94 I_method_cd7f80b5() {
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Generated
    public iIiiiIi_Class94 i_method_e7a06c95() {
        Object object = this.i_field_c74d0693.get();
        if (object == null) {
            AtomicReference<Object> atomicReference = this.i_field_c74d0693;
            synchronized (atomicReference) {
                object = this.i_field_c74d0693.get();
                if (object == null) {
                    iIiiiIi_Class94 iIiiiIi_Class942 = iIiiiIi_Class94.I_method_a9c23a7f(this.i_field_523beb0a);
                    object = iIiiiIi_Class942 == null ? this.i_field_c74d0693 : iIiiiIi_Class942;
                    this.i_field_c74d0693.set(object);
                }
            }
        }
        return (iIiiiIi_Class94)(object == this.i_field_c74d0693 ? null : object);
    }
}

