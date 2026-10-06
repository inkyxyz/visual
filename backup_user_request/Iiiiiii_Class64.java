package rockstar.client;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeoutException;
import lombok.Generated;
import lombok.SneakyThrows;
import rockstar.client.IiiIiiI_Class55;
import rockstar.client.IiiiIIi_Class58;
import rockstar.client.iIIIII_Class33;

public abstract class Iiiiiii_Class64 {
    protected final iIIIII_Class33 I_field_20717641;
    protected final IiiIiiI_Class55 I_field_c50937ec;

    public Iiiiiii_Class64(iIIIII_Class33 iIIIII_Class332, IiiIiiI_Class55 iiiIiiI_Class55) {
        this.I_field_20717641 = iIIIII_Class332;
        this.I_field_c50937ec = iiiIiiI_Class55;
    }

    public abstract IiiiIIi_Class58 I_method_a2a3535() throws IOException, InterruptedException, TimeoutException;

    @SneakyThrows({IOException.class, InterruptedException.class, TimeoutException.class})
    public IiiiIIi_Class58 i_method_244b2115() {
        return this.I_method_a2a3535();
    }

    public CompletableFuture<IiiiIIi_Class58> I_method_483656f5() {
        return CompletableFuture.supplyAsync(this::i_method_244b2115);
    }

    @Generated
    public iIIIII_Class33 I_method_8df91bd8() {
        return this.I_field_20717641;
    }

    @Generated
    public IiiIiiI_Class55 I_method_8764535() {
        return this.I_field_c50937ec;
    }
}
