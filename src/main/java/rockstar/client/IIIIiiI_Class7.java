package rockstar.client;

import javax.annotation.Nonnull;
import lombok.Generated;
import rockstar.client.IIIIiii_Class8;
import rockstar.client.IIIiIII_Class9;

public class IIIIiiI_Class7 {
    private int I_field_49;
    private int i_field_49;
    @Nonnull
    private IIIIiii_Class8 I_field_f1a6bfcc;

    public IIIIiiI_Class7() {
        this(0, 0);
    }

    public IIIIiiI_Class7(int n, int n2) {
        this(n, n2, new IIIiIII_Class9());
    }

    public IIIIiiI_Class7(int n, int n2, @Nonnull IIIIiii_Class8 iIIIiii_Class8) {
        this.I_field_49 = n;
        this.i_field_49 = n2;
        this.I_field_f1a6bfcc = iIIIiii_Class8;
    }

    @Generated
    public int I_method_c281a892() {
        return this.I_field_49;
    }

    @Generated
    public int i_method_c2903472() {
        return this.i_field_49;
    }

    @Nonnull
    @Generated
    public IIIIiii_Class8 I_method_e5765d15() {
        return this.I_field_f1a6bfcc;
    }

    @Generated
    public IIIIiiI_Class7 I_method_edbb2fda(int n) {
        this.I_field_49 = n;
        return this;
    }

    @Generated
    public IIIIiiI_Class7 i_method_17b7bffa(int n) {
        this.i_field_49 = n;
        return this;
    }

    @Generated
    public IIIIiiI_Class7 I_method_9470579d(@Nonnull IIIIiii_Class8 iIIIiii_Class8) {
        if (iIIIiii_Class8 == null) {
            throw new NullPointerException("retryHandler is marked non-null but is null");
        }
        this.I_field_f1a6bfcc = iIIIiii_Class8;
        return this;
    }
}

