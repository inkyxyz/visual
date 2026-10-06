package rockstar.client;

import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import rockstar.client.iiiIii_Class60;
import rockstar.client.iiiiII_Class61;
import rockstar.client.iiiiIi_Class62;

public class iiiIiI_Class59 {
    private iiiIii_Class60 I_field_58cff641;
    private SocketAddress I_field_fc0fc56d;
    private String I_field_523beb0a;
    private String i_field_523beb0a;

    public iiiIiI_Class59() {
    }

    public iiiIiI_Class59(iiiIii_Class60 iiiIii_Class602, String string, int n) {
        this(iiiIii_Class602, string, n, null, null);
    }

    public iiiIiI_Class59(iiiIii_Class60 iiiIii_Class602, String string, int n, @Nullable String string2, @Nullable String string3) {
        this(iiiIii_Class602, new InetSocketAddress(string, n), string2, string3);
    }

    public iiiIiI_Class59(iiiIii_Class60 iiiIii_Class602, SocketAddress socketAddress) {
        this(iiiIii_Class602, socketAddress, null, null);
    }

    public iiiIiI_Class59(iiiIii_Class60 iiiIii_Class602, SocketAddress socketAddress, @Nullable String string, @Nullable String string2) {
        this.I_field_58cff641 = iiiIii_Class602;
        this.I_field_fc0fc56d = socketAddress;
        this.I_field_523beb0a = string;
        this.i_field_523beb0a = string2;
    }

    public iiiIiI_Class59 I_method_2098104b(iiiIii_Class60 iiiIii_Class602, String string, int n) {
        return this.I_method_f9fac05d(iiiIii_Class602, new InetSocketAddress(string, n));
    }

    public iiiIiI_Class59 I_method_f9fac05d(iiiIii_Class60 iiiIii_Class602, SocketAddress socketAddress) {
        this.I_field_58cff641 = iiiIii_Class602;
        this.I_field_fc0fc56d = socketAddress;
        return this;
    }

    public iiiIiI_Class59 I_method_54b16f4b() {
        this.I_field_58cff641 = null;
        this.I_field_fc0fc56d = null;
        return this;
    }

    public boolean I_method_323a42b0() {
        return this.I_field_58cff641 != null && this.I_field_fc0fc56d != null;
    }

    @Nullable
    public iiiIii_Class60 I_method_54b1732b() {
        return this.I_field_58cff641;
    }

    public iiiIiI_Class59 I_method_a5f5612a(@Nonnull iiiIii_Class60 iiiIii_Class602) {
        this.I_field_58cff641 = iiiIii_Class602;
        return this;
    }

    @Nullable
    public SocketAddress I_method_f7f14257() {
        return this.I_field_fc0fc56d;
    }

    public iiiIiI_Class59 I_method_e326bb7e(@Nonnull SocketAddress socketAddress) {
        this.I_field_fc0fc56d = socketAddress;
        return this;
    }

    public boolean i_method_3248ce90() {
        return this.I_field_523beb0a != null && this.i_field_523beb0a != null;
    }

    @Nullable
    public String I_method_408fdf74() {
        return this.I_field_523beb0a;
    }

    public iiiIiI_Class59 I_method_1fb91541(@Nullable String string) {
        this.I_field_523beb0a = string;
        return this;
    }

    @Nullable
    public String i_method_d3ae8f94() {
        return this.i_field_523beb0a;
    }

    public iiiIiI_Class59 i_method_73d16561(@Nullable String string) {
        this.i_field_523beb0a = string;
        return this;
    }

    public iiiiIi_Class62 I_method_54bf86eb() {
        if (!this.I_method_323a42b0()) {
            throw new IllegalStateException("Proxy is not set");
        }
        return new iiiiIi_Class62(this.I_method_f476cf8a(), this.I_field_523beb0a, this.i_field_523beb0a);
    }

    public iiiiII_Class61 I_method_54bf830b() {
        if (!this.I_method_323a42b0()) {
            throw new IllegalStateException("Proxy is not set");
        }
        if (!this.i_method_3248ce90()) {
            throw new IllegalStateException("Username or password is not set");
        }
        return new iiiiII_Class61(this.I_field_523beb0a, this.i_field_523beb0a);
    }

    public Proxy I_method_f476cf8a() {
        switch (this.I_field_58cff641) {
            case I_field_58cff641: {
                return new Proxy(Proxy.Type.HTTP, this.I_field_fc0fc56d);
            }
            case i_field_58cff641: {
                try {
                    Class<?> clazz = Class.forName("sun.net.SocksProxy");
                    Method method = clazz.getDeclaredMethod("create", SocketAddress.class, Integer.TYPE);
                    return (Proxy)method.invoke(null, this.I_field_fc0fc56d, 4);
                }
                catch (Throwable throwable) {
                    throw new UnsupportedOperationException("SOCKS4 proxy type is not supported", throwable);
                }
            }
            case II_field_58cff641: {
                return new Proxy(Proxy.Type.SOCKS, this.I_field_fc0fc56d);
            }
        }
        throw new IllegalStateException("Unknown proxy type: " + this.I_field_58cff641.name());
    }
}

