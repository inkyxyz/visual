package rockstar.client;

import java.io.IOException;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.util.concurrent.CompletableFuture;
import lombok.SneakyThrows;
import rockstar.client.IIiiiII_Class29;
import rockstar.client.IIiiiIi_Class30;
import rockstar.client.IiIIIIi_Class34;
import rockstar.client.IiIIIiI_Class35;
import rockstar.client.IiIIiiI_Class39;
import rockstar.client.IiIiiIi_Class46;
import rockstar.client.IiIiiiI_Class47;
import rockstar.client.iIIIII_Class33;
import rockstar.client.iIiIIii_Class84;
import rockstar.client.iIiIiII_Class85;
import rockstar.client.iiiiii_Class64;

public class IiIiIII_Class41
extends IiIIiiI_Class39 {
    private final iIiIiII_Class85<IiIiiiI_Class47> I_field_2466f38c;
    private final iIiIiII_Class85<IiIiiIi_Class46> i_field_2466f38c;
    private final String i_field_523beb0a;

    public IiIiIII_Class41(iIIIII_Class33 iIIIII_Class332, String string, iIiIiII_Class85<IiIiiiI_Class47> iIiIiII_Class852, iIiIiII_Class85<IiIiiIi_Class46> iIiIiII_Class853) {
        super(iIIIII_Class332, "pc.realms.minecraft.net");
        this.I_field_2466f38c = iIiIiII_Class852;
        this.i_field_2466f38c = iIiIiII_Class853;
        this.i_field_523beb0a = string;
    }

    @Override
    public IIiiiII_Class29 I_method_66bc33d(IIiiiIi_Class30 iIiiiIi_Class30) throws IOException {
        return (IIiiiII_Class29)this.I_field_20717641.I_method_fc2df765(this.I_method_8fb10697(new IiIIIiI_Class35(iIiiiIi_Class30)));
    }

    public void I_method_4eb8dcdf() throws IOException {
        this.I_field_20717641.I_method_fc2df765(this.I_method_8fb10697(new IiIIIIi_Class34()));
    }

    @SneakyThrows(IOException.class)
    public void i_method_4ec768bf() {
        this.I_method_4eb8dcdf();
    }

    public CompletableFuture<Void> II_method_e17b93d2() {
        return CompletableFuture.runAsync(this::i_method_4ec768bf);
    }

    @Override
    protected <T extends iiiiii_Class64> T I_method_8fb10697(T t) throws IOException {
        CookieManager cookieManager = new CookieManager();
        IiIiiIi_Class46 iiIiiIi_Class46 = this.i_field_2466f38c.i_method_8c4658b5();
        cookieManager.getCookieStore().add(null, this.I_method_94ebb519("sid", "token:" + this.I_field_2466f38c.i_method_8c4658b5().II_method_48b7927e() + ':' + iIiIIii_Class84.I_method_380805cd(iiIiiIi_Class46.I_method_5d50ac6b())));
        cookieManager.getCookieStore().add(null, this.I_method_94ebb519("user", iiIiiIi_Class46.I_method_a72559e1()));
        cookieManager.getCookieStore().add(null, this.I_method_94ebb519("version", this.i_field_523beb0a));
        t.I_method_1877e926(cookieManager);
        t.i_method_33057dd7("Is-Prerelease", String.valueOf(!this.i_field_523beb0a.matches("\\d+\\.\\d+(\\.\\d+)?")));
        return t;
    }

    private HttpCookie I_method_94ebb519(String string, String string2) {
        HttpCookie httpCookie = new HttpCookie(string, string2);
        httpCookie.setDomain(this.I_field_523beb0a);
        httpCookie.setPath("/");
        return httpCookie;
    }
}
