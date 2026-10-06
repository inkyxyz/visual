package rockstar.client;

import lombok.Generated;

public class iiIiIIiii_Class424 {
    private long I_field_4a;

    public iiIiIIiii_Class424() {
        this.I_method_23e11e3f();
    }

    public boolean I_method_58432069(long l) {
        return System.currentTimeMillis() - l >= this.I_field_4a;
    }

    public void I_method_23e11e3f() {
        this.I_field_4a = System.currentTimeMillis();
    }

    public long I_method_23e11e33() {
        return System.currentTimeMillis() - this.I_field_4a;
    }

    @Generated
    public long i_method_23efaa13() {
        return this.I_field_4a;
    }

    @Generated
    public void I_method_58432065(long l) {
        this.I_field_4a = l;
    }
}

