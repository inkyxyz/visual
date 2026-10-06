package rockstar.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
import javax.annotation.Nonnull;
import lombok.Generated;

public class IIIiiiI_Class15
extends InputStream {
    private final Queue<InputStream> I_field_f2700bf6;

    @Override
    public int read() throws IOException {
        if (this.I_field_f2700bf6.isEmpty()) {
            return -1;
        }
        int n = this.I_field_f2700bf6.peek().read();
        if (n == -1) {
            this.I_field_f2700bf6.poll().close();
            return this.read();
        }
        return n;
    }

    @Override
    public int read(@Nonnull byte[] byArray, int n, int n2) throws IOException {
        if (this.I_field_f2700bf6.isEmpty()) {
            return -1;
        }
        int n3 = this.I_field_f2700bf6.peek().read(byArray, n, n2);
        if (n3 == -1) {
            this.I_field_f2700bf6.poll().close();
            return this.read(byArray, n, n2);
        }
        return n3;
    }

    @Override
    public void close() throws IOException {
        while (!this.I_field_f2700bf6.isEmpty()) {
            this.I_field_f2700bf6.poll().close();
        }
    }

    @Generated
    public IIIiiiI_Class15(Queue<InputStream> queue) {
        this.I_field_f2700bf6 = queue;
    }
}

