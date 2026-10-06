package rockstar.client;

import java.io.InputStream;
import javax.annotation.Nonnull;
import rockstar.client.iIiIII_Class41;
import rockstar.client.iiiIII_Class57;

public class iIiIii_Class44
extends iIiIII_Class41 {
    private final InputStream I_field_91ffb459;
    private final int I_field_49;

    public iIiIii_Class44(iiiIII_Class57 iiiIII_Class572, InputStream inputStream, int n) {
        super(iiiIII_Class572);
        this.I_field_91ffb459 = inputStream;
        this.I_field_49 = n;
    }

    @Override
    public boolean I_method_533eee70() {
        return false;
    }

    @Override
    public int I_method_533eee5f() {
        return this.I_field_49;
    }

    @Override
    @Nonnull
    protected InputStream I_method_23a0bb6f() {
        return this.I_field_91ffb459;
    }
}

