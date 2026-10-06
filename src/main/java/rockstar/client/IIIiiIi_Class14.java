package rockstar.client;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nonnull;

public class IIIiiIi_Class14
extends InputStream {
    private final InputStream I_field_91ffb459;
    private final Nested1_ed391200 I_field_bdfa2787;

    public IIIiiIi_Class14(InputStream inputStream, Nested1_ed391200 nested1_ed391200) {
        this.I_field_91ffb459 = inputStream;
        this.I_field_bdfa2787 = nested1_ed391200;
    }

    @Override
    public int read() throws IOException {
        return this.I_field_91ffb459.read();
    }

    @Override
    public int read(@Nonnull byte[] byArray) throws IOException {
        return this.I_field_91ffb459.read(byArray);
    }

    @Override
    public int read(@Nonnull byte[] byArray, int n, int n2) throws IOException {
        return this.I_field_91ffb459.read(byArray, n, n2);
    }

    @Override
    public long skip(long l) throws IOException {
        return this.I_field_91ffb459.skip(l);
    }

    @Override
    public int available() throws IOException {
        return this.I_field_91ffb459.available();
    }

    @Override
    public void close() throws IOException {
        this.I_field_91ffb459.close();
        this.I_field_bdfa2787.close();
    }

    @FunctionalInterface
    public static interface Nested1_ed391200 {
        public void close() throws IOException;
    }
}

