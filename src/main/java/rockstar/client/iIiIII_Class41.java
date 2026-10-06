package rockstar.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.WillNotClose;
import org.jetbrains.annotations.ApiStatus;
import rockstar.client.iIiIIi_Class42;
import rockstar.client.iIiIiI_Class43;
import rockstar.client.iIiIii_Class44;
import rockstar.client.iIiiII_Class45;
import rockstar.client.iIiiIi_Class46;
import rockstar.client.iIiiiI_Class47;
import rockstar.client.iiiIII_Class57;

public abstract class iIiIII_Class41 {
    private final iiiIII_Class57 I_field_58cf7a41;
    private int I_field_49 = 1024;
    private boolean I_field_5a = false;
    private byte[] I_field_b47;

    public static iIiIII_Class41 I_method_a22365a4(byte[] byArray) {
        return new iIiIIi_Class42(byArray);
    }

    public static iIiIII_Class41 I_method_3f37c204(byte[] byArray, int n, int n2) {
        return new iIiIIi_Class42(byArray, n, n2);
    }

    public static iIiIII_Class41 I_method_3e659541(String string) {
        return new iIiiIi_Class46(string);
    }

    public static iIiIII_Class41 I_method_ed3c6b3(String string, Charset charset) {
        return new iIiiIi_Class46(string, charset);
    }

    public static iIiIII_Class41 I_method_daeecf4(File file) {
        return new iIiIiI_Class43(file);
    }

    public static iIiIII_Class41 I_method_a2fce9b7(String string, String string2) {
        return new iIiiiI_Class47().I_method_612c69b7(string, string2);
    }

    public static iIiIII_Class41 I_method_2df7bbfe(Map<String, String> map) {
        return new iIiiiI_Class47(map);
    }

    public static iIiiII_Class45 I_method_4d977b2b() {
        return new iIiiII_Class45();
    }

    public static iIiIii_Class44 I_method_e8559c1a(iiiIII_Class57 iiiIII_Class572, InputStream inputStream, int n) {
        return new iIiIii_Class44(iiiIII_Class572, inputStream, n);
    }

    public iIiIII_Class41(iiiIII_Class57 iiiIII_Class572) {
        this.I_field_58cf7a41 = iiiIII_Class572;
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public final iiiIII_Class57 I_method_8424032b() {
        return this.i_method_ae461b4b();
    }

    public final iiiIII_Class57 i_method_ae461b4b() {
        return this.I_field_58cf7a41;
    }

    public final int i_method_c53427f() {
        return this.I_field_49;
    }

    public final iIiIII_Class41 I_method_c857b3c0(int n) {
        this.I_field_49 = n;
        return this;
    }

    public final void I_method_f7462b9e(@WillNotClose OutputStream outputStream) throws IOException {
        try (InputStream inputStream = this.i_method_4e61bf8f();){
            int n;
            byte[] byArray = new byte[this.I_field_49];
            while ((n = inputStream.read(byArray)) >= 0) {
                outputStream.write(byArray, 0, n);
            }
        }
    }

    public final InputStream i_method_4e61bf8f() throws IOException {
        if (this.I_field_b47 != null) {
            return new ByteArrayInputStream(this.I_field_b47);
        }
        if (!this.I_field_5a || this.I_method_533eee70()) {
            this.I_field_5a = true;
            return this.I_method_97542b37(this.I_method_23a0bb6f());
        }
        throw new IOException("This content cannot be streamed multiple times");
    }

    @Nonnull
    public final byte[] I_method_7c521fb1() throws IOException {
        if (this.I_field_b47 == null) {
            int n = this.I_method_533eee5f() > 0 ? this.I_method_533eee5f() : this.I_field_49;
            try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(n);){
                this.I_method_f7462b9e(byteArrayOutputStream);
                this.I_field_b47 = byteArrayOutputStream.toByteArray();
            }
        }
        return this.I_field_b47;
    }

    @Nonnull
    public final String I_method_963beb74() throws IOException {
        return this.I_method_e4a261e6(StandardCharsets.UTF_8);
    }

    @Nonnull
    public final String I_method_e4a261e6(Charset charset) throws IOException {
        return new String(this.I_method_7c521fb1(), charset);
    }

    protected final void I_method_c44b6ac() {
        this.I_field_b47 = null;
        this.I_field_5a = false;
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public final int II_method_7c611628() {
        return this.I_method_533eee5f();
    }

    public abstract boolean I_method_533eee70();

    public abstract int I_method_533eee5f();

    @Nonnull
    protected abstract InputStream I_method_23a0bb6f() throws IOException;

    protected InputStream I_method_97542b37(InputStream inputStream) throws IOException {
        return inputStream;
    }
}

