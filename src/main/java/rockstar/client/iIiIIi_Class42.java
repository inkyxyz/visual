package rockstar.client;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.annotation.Nonnull;
import rockstar.client.iIIIii_Class36;
import rockstar.client.iIiIII_Class41;
import rockstar.client.iiiIII_Class57;

public class iIiIIi_Class42
extends iIiIII_Class41 {
    private final byte[] I_field_b47;
    private final int I_field_49;
    private final int i_field_49;

    public iIiIIi_Class42(byte[] byArray) {
        this(byArray, 0, byArray.length);
    }

    public iIiIIi_Class42(byte[] byArray, int n, int n2) {
        super(iIIIii_Class36.iI_field_58cf7a41);
        this.I_field_b47 = byArray;
        this.I_field_49 = n;
        this.i_field_49 = n2;
    }

    public iIiIIi_Class42(iiiIII_Class57 iiiIII_Class572, byte[] byArray) {
        this(iiiIII_Class572, byArray, 0, byArray.length);
    }

    public iIiIIi_Class42(iiiIII_Class57 iiiIII_Class572, byte[] byArray, int n, int n2) {
        super(iiiIII_Class572);
        this.I_field_b47 = byArray;
        this.I_field_49 = n;
        this.i_field_49 = n2;
    }

    @Override
    public boolean I_method_533eee70() {
        return true;
    }

    @Override
    public int I_method_533eee5f() {
        return this.I_field_b47.length;
    }

    @Override
    @Nonnull
    protected InputStream I_method_23a0bb6f() {
        return new ByteArrayInputStream(this.I_field_b47, this.I_field_49, this.i_field_49);
    }
}

