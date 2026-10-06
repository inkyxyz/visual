package rockstar.client;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import lombok.Generated;
import rockstar.client.IiiIiI_Class27;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIiiiI_Class79;

public final class iIiiiIi_Class94
implements iIIiiiI_Class79 {
    private final IiiiIi_Class30 I_field_bc16a1e1;
    private final IiiiIi_Class30 i_field_bc16a1e1;
    private final byte[] I_field_b47;

    public static iIiiiIi_Class94 I_method_a9c23a7f(String string) {
        if (string == null) {
            throw new IllegalArgumentException("JWT string is null");
        }
        String[] stringArray = string.split("\\.");
        if (stringArray.length < 2) {
            throw new IllegalArgumentException("JWT must have at least header and payload");
        }
        IiiiIi_Class30 iiiiIi_Class30 = IiiIiI_Class27.I_method_c7ec7501(new String(Base64.getUrlDecoder().decode(stringArray[0]), StandardCharsets.UTF_8)).I_method_9b832f2b();
        IiiiIi_Class30 iiiiIi_Class302 = IiiIiI_Class27.I_method_c7ec7501(new String(Base64.getUrlDecoder().decode(stringArray[1]), StandardCharsets.UTF_8)).I_method_9b832f2b();
        byte[] byArray = stringArray.length > 2 ? Base64.getUrlDecoder().decode(stringArray[2]) : null;
        return new iIiiiIi_Class94(iiiiIi_Class30, iiiiIi_Class302, byArray);
    }

    @Override
    public long I_method_86254473() {
        if (this.i_field_bc16a1e1.ii_method_1d104d43("exp")) {
            return this.i_field_bc16a1e1.i_method_5239fcca("exp") * 1000L;
        }
        return Long.MAX_VALUE;
    }

    @Generated
    public iIiiiIi_Class94(IiiiIi_Class30 iiiiIi_Class30, IiiiIi_Class30 iiiiIi_Class302, byte[] byArray) {
        this.I_field_bc16a1e1 = iiiiIi_Class30;
        this.i_field_bc16a1e1 = iiiiIi_Class302;
        this.I_field_b47 = byArray;
    }

    @Generated
    public IiiiIi_Class30 I_method_4b2847d8() {
        return this.I_field_bc16a1e1;
    }

    @Generated
    public IiiiIi_Class30 i_method_754a5ff8() {
        return this.i_field_bc16a1e1;
    }

    @Generated
    public byte[] I_method_247a847e() {
        return this.I_field_b47;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof iIiiiIi_Class94)) {
            return false;
        }
        iIiiiIi_Class94 iIiiiIi_Class942 = (iIiiiIi_Class94)object;
        IiiiIi_Class30 iiiiIi_Class30 = this.I_method_4b2847d8();
        IiiiIi_Class30 iiiiIi_Class302 = iIiiiIi_Class942.I_method_4b2847d8();
        if (iiiiIi_Class30 == null ? iiiiIi_Class302 != null : !((Object)iiiiIi_Class30).equals(iiiiIi_Class302)) {
            return false;
        }
        IiiiIi_Class30 iiiiIi_Class303 = this.i_method_754a5ff8();
        IiiiIi_Class30 iiiiIi_Class304 = iIiiiIi_Class942.i_method_754a5ff8();
        if (iiiiIi_Class303 == null ? iiiiIi_Class304 != null : !((Object)iiiiIi_Class303).equals(iiiiIi_Class304)) {
            return false;
        }
        return Arrays.equals(this.I_method_247a847e(), iIiiiIi_Class942.I_method_247a847e());
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        IiiiIi_Class30 iiiiIi_Class30 = this.I_method_4b2847d8();
        n2 = n2 * 59 + (iiiiIi_Class30 == null ? 43 : ((Object)iiiiIi_Class30).hashCode());
        IiiiIi_Class30 iiiiIi_Class302 = this.i_method_754a5ff8();
        n2 = n2 * 59 + (iiiiIi_Class302 == null ? 43 : ((Object)iiiiIi_Class302).hashCode());
        n2 = n2 * 59 + Arrays.hashCode(this.I_method_247a847e());
        return n2;
    }

    @Generated
    public String toString() {
        return "Jwt(header=" + this.I_method_4b2847d8() + ", payload=" + this.i_method_754a5ff8() + ", signature=" + Arrays.toString(this.I_method_247a847e()) + ")";
    }
}

