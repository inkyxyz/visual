package rockstar.client;

import java.util.concurrent.TimeUnit;
import lombok.Generated;

public class IIIIiIi_Class6 {
    public static final IIIIiIi_Class6 I_field_f1a647ac = new IIIIiIi_Class6(false, 0L);
    private final boolean I_field_5a;
    private final long I_field_4a;

    public static IIIIiIi_Class6 I_method_be1cd89b(long l) {
        return IIIIiIi_Class6.I_method_c5985a9(l, TimeUnit.MILLISECONDS);
    }

    public static IIIIiIi_Class6 I_method_c5985a9(long l, TimeUnit timeUnit) {
        return new IIIIiIi_Class6(true, timeUnit.toMillis(l));
    }

    public void I_method_5c55545f() throws InterruptedException {
        Thread.sleep(this.I_field_4a);
    }

    @Generated
    public boolean I_method_5c555463() {
        return this.I_field_5a;
    }

    @Generated
    public long I_method_5c555453() {
        return this.I_field_4a;
    }

    @Generated
    private IIIIiIi_Class6(boolean bl, long l) {
        this.I_field_5a = bl;
        this.I_field_4a = l;
    }
}

