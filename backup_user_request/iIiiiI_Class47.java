package rockstar.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import lombok.Generated;
import rockstar.client.IIIiIii_Class12;
import rockstar.client.iIIIii_Class36;
import rockstar.client.iIiIII_Class41;

public class iIiiiI_Class47
extends iIiIII_Class41 {
    private final List<Nested1_e7d302f3> I_field_7865b31;
    private final Charset I_field_2bdd038e;

    public iIiiiI_Class47() {
        this(StandardCharsets.UTF_8);
    }

    public iIiiiI_Class47(Map<String, String> map) {
        this(map, StandardCharsets.UTF_8);
    }

    public iIiiiI_Class47(Charset charset) {
        super(iIIIii_Class36.II_field_58cf7a41);
        this.I_field_7865b31 = new ArrayList<Nested1_e7d302f3>();
        this.I_field_2bdd038e = charset;
    }

    public iIiiiI_Class47(Map<String, String> map, Charset charset) {
        super(iIIIii_Class36.II_field_58cf7a41);
        this.I_field_7865b31 = map.entrySet().stream().map(entry -> new Nested1_e7d302f3((String)entry.getKey(), (String)entry.getValue(), charset)).collect(Collectors.toList());
        this.I_field_2bdd038e = charset;
    }

    public iIiiiI_Class47 I_method_612c69b7(String string, String string2) {
        this.I_field_7865b31.add(new Nested1_e7d302f3(string, string2, this.I_field_2bdd038e));
        this.I_method_c44b6ac();
        return this;
    }

    @Override
    public boolean I_method_533eee70() {
        return true;
    }

    @Override
    public int I_method_533eee5f() {
        int n = this.I_field_7865b31.size() - 1;
        for (Nested1_e7d302f3 nested1_e7d302f3 : this.I_field_7865b31) {
            n += nested1_e7d302f3.I_method_f11e09a();
        }
        return n;
    }

    @Override
    @Nonnull
    protected InputStream I_method_23a0bb6f() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(this.I_method_533eee5f());
        for (int i = 0; i < this.I_field_7865b31.size(); ++i) {
            Nested1_e7d302f3 nested1_e7d302f3 = this.I_field_7865b31.get(i);
            byteArrayOutputStream.write(nested1_e7d302f3.I_method_d32a3516());
            byteArrayOutputStream.write(61);
            byteArrayOutputStream.write(nested1_e7d302f3.i_method_d4ed2536());
            if (i >= this.I_field_7865b31.size() - 1) continue;
            byteArrayOutputStream.write(38);
        }
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    static class Nested1_e7d302f3 {
        private final byte[] I_field_b47;
        private final byte[] i_field_b47;

        private Nested1_e7d302f3(String string, String string2, Charset charset) {
            this.I_field_b47 = IIIiIii_Class12.I_method_e0ee66f7(string).getBytes(charset);
            this.i_field_b47 = IIIiIii_Class12.I_method_e0ee66f7(string2).getBytes(charset);
        }

        public int I_method_f11e09a() {
            return this.I_field_b47.length + 1 + this.i_field_b47.length;
        }

        @Generated
        public byte[] I_method_d32a3516() {
            return this.I_field_b47;
        }

        @Generated
        public byte[] i_method_d4ed2536() {
            return this.i_field_b47;
        }
    }
}

