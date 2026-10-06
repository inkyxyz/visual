package rockstar.client;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import lombok.Generated;
import lombok.SneakyThrows;
import rockstar.client.IIiiiII_Class29;
import rockstar.client.IIiiiIi_Class30;
import rockstar.client.IiIIIii_Class36;
import rockstar.client.IiIIiII_Class37;
import rockstar.client.iIIIII_Class33;
import rockstar.client.iiiiii_Class64;

public abstract class IiIIiiI_Class39 {
    protected final iIIIII_Class33 I_field_20717641;
    protected final String I_field_523beb0a;

    public IiIIiiI_Class39(iIIIII_Class33 iIIIII_Class332, String string) {
        this.I_field_20717641 = iIIIII_Class332;
        this.I_field_523beb0a = string;
    }

    public boolean I_method_5f1800c3() throws IOException {
        String string = (String)this.I_field_20717641.I_method_fc2df765(this.I_method_8fb10697(new IiIIIii_Class36(this.I_field_523beb0a)));
        return string.equals("COMPATIBLE");
    }

    @SneakyThrows(IOException.class)
    public boolean i_method_5f268ca3() {
        return this.I_method_5f1800c3();
    }

    public CompletableFuture<Boolean> I_method_c9968ad5() {
        return CompletableFuture.supplyAsync(this::i_method_5f268ca3);
    }

    public List<IIiiiIi_Class30> I_method_1a425ba8() throws IOException {
        return (List)this.I_field_20717641.I_method_fc2df765(this.I_method_8fb10697(new IiIIiII_Class37(this.I_field_523beb0a)));
    }

    @SneakyThrows(IOException.class)
    public List<IIiiiIi_Class30> i_method_cf8e93c8() {
        return this.I_method_1a425ba8();
    }

    public CompletableFuture<List<IIiiiIi_Class30>> i_method_71c462f5() {
        return CompletableFuture.supplyAsync(this::i_method_cf8e93c8);
    }

    public abstract IIiiiII_Class29 I_method_66bc33d(IIiiiIi_Class30 var1) throws IOException;

    @SneakyThrows(IOException.class)
    public IIiiiII_Class29 i_method_adc1f35d(IIiiiIi_Class30 iIiiiIi_Class30) {
        return this.I_method_66bc33d(iIiiiIi_Class30);
    }

    public CompletableFuture<IIiiiII_Class29> I_method_481cd3cd(IIiiiIi_Class30 iIiiiIi_Class30) {
        return CompletableFuture.supplyAsync(() -> this.i_method_adc1f35d(iIiiiIi_Class30));
    }

    protected abstract <T extends iiiiii_Class64> T I_method_8fb10697(T var1) throws IOException;

    @Generated
    public iIIIII_Class33 I_method_a2fd0fb8() {
        return this.I_field_20717641;
    }

    @Generated
    public String I_method_a5f9a9c1() {
        return this.I_field_523beb0a;
    }
}
