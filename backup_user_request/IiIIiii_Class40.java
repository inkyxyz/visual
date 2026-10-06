package rockstar.client;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import lombok.SneakyThrows;
import rockstar.client.IIiiiII_Class29;
import rockstar.client.IIiiiIi_Class30;
import rockstar.client.IIiiiiI_Class31;
import rockstar.client.IIiiiii_Class32;
import rockstar.client.IiIIIII_Class33;
import rockstar.client.IiIIiiI_Class39;
import rockstar.client.iIIIII_Class33;
import rockstar.client.iIiIiII_Class85;
import rockstar.client.iiIIiII_Class101;
import rockstar.client.iiiiii_Class64;

public class IiIIiii_Class40
extends IiIIiiI_Class39 {
    private final iIiIiII_Class85<iiIIiII_Class101> I_field_2466f38c;
    private final String i_field_523beb0a;

    public IiIIiii_Class40(iIIIII_Class33 iIIIII_Class332, String string, iIiIiII_Class85<iiIIiII_Class101> iIiIiII_Class852) {
        super(iIIIII_Class332, "pocket.realms.minecraft.net");
        this.I_field_2466f38c = iIiIiII_Class852;
        this.i_field_523beb0a = string;
    }

    public IIiiiIi_Class30 I_method_d63f36ff(String string) throws IOException {
        return (IIiiiIi_Class30)this.I_field_20717641.I_method_fc2df765(this.I_method_8fb10697(new IIiiiii_Class32(string)));
    }

    @SneakyThrows(IOException.class)
    public IIiiiIi_Class30 i_method_530eadf(String string) {
        return this.I_method_d63f36ff(string);
    }

    public CompletableFuture<IIiiiIi_Class30> I_method_d9e363ab(String string) {
        return CompletableFuture.supplyAsync(() -> this.i_method_530eadf(string));
    }

    public void I_method_374886e7(IIiiiIi_Class30 iIiiiIi_Class30) throws IOException {
        this.I_field_20717641.I_method_fc2df765(this.I_method_8fb10697(new IIiiiiI_Class31(iIiiiIi_Class30)));
    }

    @SneakyThrows(IOException.class)
    public void i_method_61451707(IIiiiIi_Class30 iIiiiIi_Class30) {
        this.I_method_374886e7(iIiiiIi_Class30);
    }

    public CompletableFuture<Void> i_method_f1e8738d(IIiiiIi_Class30 iIiiiIi_Class30) {
        return CompletableFuture.runAsync(() -> this.i_method_61451707(iIiiiIi_Class30));
    }

    @Override
    public IIiiiII_Class29 I_method_66bc33d(IIiiiIi_Class30 iIiiiIi_Class30) throws IOException {
        return (IIiiiII_Class29)this.I_field_20717641.I_method_fc2df765(this.I_method_8fb10697(new IiIIIII_Class33(iIiiiIi_Class30)));
    }

    @Override
    protected <T extends iiiiii_Class64> T I_method_8fb10697(T t) throws IOException {
        t.i_method_33057dd7("Authorization", this.I_field_2466f38c.i_method_8c4658b5().I_method_4fc45e01());
        t.i_method_33057dd7("Client-Version", this.i_field_523beb0a);
        return t;
    }
}
