package rockstar.client;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.CookieManager;
import java.net.MalformedURLException;
import java.net.URL;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import rockstar.client.IIIIiiI_Class7;
import rockstar.client.IIIiIiI_Class11;
import rockstar.client.Iiiiii_Class32;
import rockstar.client.iIIIII_Class33;
import rockstar.client.iIIIiI_Class35;
import rockstar.client.iiIiiI_Class55;

public class iiiiii_Class64
extends Iiiiii_Class32<iiiiii_Class64> {
    private final String I_field_523beb0a;
    private final URL I_field_6e7dda7f;
    private boolean I_field_5a;
    private boolean i_field_5a;
    private Nested1_849ae333 I_field_9b46309c = Nested1_849ae333.I_field_9b46309c;
    private final IIIiIiI_Class11<CookieManager> I_field_f35b202c = new IIIiIiI_Class11();
    private final IIIiIiI_Class11<IIIIiiI_Class7> i_field_f35b202c = new IIIiIiI_Class11();
    private final IIIiIiI_Class11<Boolean> II_field_f35b202c = new IIIiIiI_Class11();
    private WeakReference<iIIIII_Class33> I_field_112e3024;

    public iiiiii_Class64(String string, String string2) throws MalformedURLException {
        this(string, new URL(string2));
    }

    public iiiiii_Class64(String string, URL uRL) {
        this.I_field_523beb0a = string;
        this.I_field_6e7dda7f = uRL;
    }

    public String I_method_ccca7b4() {
        return this.I_field_523beb0a;
    }

    public URL I_method_816b7c29() {
        return this.I_field_6e7dda7f;
    }

    public boolean i_method_65097e50() {
        return this.I_field_5a;
    }

    public iiiiii_Class64 I_method_7b1f504f(boolean bl) {
        this.I_field_5a = bl;
        return this;
    }

    public boolean II_method_3a725279() {
        return this.i_field_5a;
    }

    public iiiiii_Class64 i_method_95403c2f(boolean bl) {
        this.i_field_5a = bl;
        return this;
    }

    public Nested1_849ae333 I_method_7ccca346() {
        return this.I_field_9b46309c;
    }

    public iiiiii_Class64 II_method_de296558(boolean bl) {
        return this.I_method_8cb51eef(bl ? Nested1_849ae333.i_field_9b46309c : Nested1_849ae333.II_field_9b46309c);
    }

    public iiiiii_Class64 I_method_8cb51eef(@Nonnull Nested1_849ae333 nested1_849ae333) {
        this.I_field_9b46309c = nested1_849ae333;
        return this;
    }

    public boolean Ii_method_3a80de59() {
        return this.I_field_f35b202c.I_method_4ee9ece3();
    }

    public iiiiii_Class64 I_method_1bd5974b() {
        this.I_field_f35b202c.I_method_4ee9ecdf();
        return this;
    }

    @Nullable
    public CookieManager I_method_6e9e47ef() {
        return this.I_field_f35b202c.I_method_4e36a433();
    }

    public iiiiii_Class64 I_method_1877e926(@Nullable CookieManager cookieManager) {
        this.I_field_f35b202c.I_method_357602fb(cookieManager);
        return this;
    }

    public boolean iI_method_3c354299() {
        return this.i_field_f35b202c.I_method_4ee9ece3();
    }

    public iiiiii_Class64 i_method_45f7af6b() {
        this.i_field_f35b202c.I_method_4ee9ecdf();
        return this;
    }

    @Nonnull
    public IIIIiiI_Class7 I_method_8d924c02() {
        return this.i_field_f35b202c.I_method_4e36a433();
    }

    public iiiiii_Class64 I_method_2bfbaffd(@Nonnull IIIIiiI_Class7 iIIIiiI_Class7) {
        this.i_field_f35b202c.I_method_357602fb(iIIIiiI_Class7);
        return this;
    }

    public boolean ii_method_3c43ce79() {
        return this.II_field_f35b202c.I_method_4ee9ece3();
    }

    public iiiiii_Class64 II_method_82203d22() {
        this.II_field_f35b202c.I_method_4ee9ecdf();
        return this;
    }

    public boolean III_method_13e6f390() {
        return this.II_field_f35b202c.I_method_4e36a433();
    }

    public iiiiii_Class64 Ii_method_f84a5138(boolean bl) {
        this.II_field_f35b202c.I_method_357602fb(bl);
        return this;
    }

    public iiiiii_Class64 I_method_80f3492a(@Nullable iIIIII_Class33 iIIIII_Class332) {
        this.I_field_112e3024 = iIIIII_Class332 == null ? null : new WeakReference<iIIIII_Class33>(iIIIII_Class332);
        return this;
    }

    public iIIIiI_Class35 I_method_e369038b() throws IOException {
        iIIIII_Class33 iIIIII_Class332 = null;
        if (this.I_field_112e3024 != null) {
            iIIIII_Class332 = (iIIIII_Class33)this.I_field_112e3024.get();
        }
        if (iIIIII_Class332 == null) {
            iIIIII_Class332 = new iIIIII_Class33();
        }
        return iIIIII_Class332.I_method_7ad89d6a(this);
    }

    public <R> R I_method_69422b85(iiIiiI_Class55<R> iiIiiI_Class552) throws IOException {
        iIIIII_Class33 iIIIII_Class332 = null;
        if (this.I_field_112e3024 != null) {
            iIIIII_Class332 = (iIIIII_Class33)this.I_field_112e3024.get();
        }
        if (iIIIII_Class332 == null) {
            iIIIII_Class332 = new iIIIII_Class33();
        }
        return iIIIII_Class332.I_method_9ec8aba4(this, iiIiiI_Class552);
    }

    public static enum Nested1_849ae333 {
        I_field_9b46309c,
        i_field_9b46309c,
        II_field_9b46309c;

    }
}

