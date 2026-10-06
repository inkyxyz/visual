package rockstar.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import rockstar.client.IIIiiiI_Class15;
import rockstar.client.Iiiiii_Class32;
import rockstar.client.iIiIII_Class41;
import rockstar.client.iiiIII_Class57;

public class iIiiII_Class45
extends iIiIII_Class41 {
    private final String I_field_523beb0a;
    private final List<Nested1_e7c47713> I_field_7865b31 = new ArrayList<Nested1_e7c47713>();
    private boolean I_field_5a = false;

    public iIiiII_Class45() {
        this("---" + UUID.randomUUID() + "---");
    }

    public iIiiII_Class45(String string) {
        super(new iiiIII_Class57("multipart/form-data; boundary=" + string));
        this.I_field_523beb0a = string;
    }

    public iIiiII_Class45 I_method_be7fe500(String string, iIiIII_Class41 iIiIII_Class412) {
        if (iIiIII_Class412.I_method_533eee5f() < 0) {
            this.I_field_5a = true;
        }
        return this.I_method_f3816ecf(new Nested1_e7c47713(string, iIiIII_Class412));
    }

    public iIiiII_Class45 I_method_46379fb6(String string, iIiIII_Class41 iIiIII_Class412, @Nullable String string2) {
        if (iIiIII_Class412.I_method_533eee5f() < 0) {
            this.I_field_5a = true;
        }
        return this.I_method_f3816ecf(new Nested1_e7c47713(string, iIiIII_Class412, string2));
    }

    public iIiiII_Class45 I_method_f3816ecf(Nested1_e7c47713 nested1_e7c47713) {
        if (nested1_e7c47713.I_method_c37cbf10().I_method_533eee5f() < 0) {
            this.I_field_5a = true;
        }
        this.I_field_7865b31.add(nested1_e7c47713);
        return this;
    }

    @Override
    public boolean I_method_533eee70() {
        return false;
    }

    @Override
    public int I_method_533eee5f() {
        if (this.I_field_5a) {
            return -1;
        }
        int n = ("--" + this.I_field_523beb0a + "\r\n").getBytes().length;
        int[] nArray = new int[]{0};
        for (Nested1_e7c47713 nested1_e7c47713 : this.I_field_7865b31) {
            nArray[0] = nArray[0] + n;
            nested1_e7c47713.I_method_d45c3fcd(string -> {
                nArray[0] = nArray[0] + string.getBytes().length;
            });
            nArray[0] = nArray[0] + 2;
            nArray[0] = nArray[0] + nested1_e7c47713.I_method_c37cbf10().I_method_533eee5f();
            nArray[0] = nArray[0] + 2;
        }
        return nArray[0] + n;
    }

    @Override
    @Nonnull
    protected InputStream I_method_23a0bb6f() throws IOException {
        ArrayDeque<InputStream> arrayDeque = new ArrayDeque<InputStream>(this.I_field_7865b31.size() * 4 + 1);
        byte[] byArray = "\r\n".getBytes();
        byte[] byArray2 = ("--" + this.I_field_523beb0a + "\r\n").getBytes();
        byte[] byArray3 = ("--" + this.I_field_523beb0a + "--").getBytes();
        for (Nested1_e7c47713 nested1_e7c47713 : this.I_field_7865b31) {
            arrayDeque.add(new ByteArrayInputStream(byArray2));
            nested1_e7c47713.I_method_d45c3fcd(string -> arrayDeque.add(new ByteArrayInputStream(string.getBytes())));
            arrayDeque.add(new ByteArrayInputStream(byArray));
            arrayDeque.add(nested1_e7c47713.I_method_c37cbf10().i_method_4e61bf8f());
            arrayDeque.add(new ByteArrayInputStream(byArray));
        }
        arrayDeque.add(new ByteArrayInputStream(byArray3));
        return new IIIiiiI_Class15(arrayDeque);
    }

    public static class Nested1_e7c47713
    extends Iiiiii_Class32<Nested1_e7c47713> {
        private final iIiIII_Class41 I_field_22346661;

        public Nested1_e7c47713(String string, iIiIII_Class41 iIiIII_Class412) {
            this(string, iIiIII_Class412, null);
        }

        public Nested1_e7c47713(String string, iIiIII_Class41 iIiIII_Class412, @Nullable String string2) {
            this.I_field_22346661 = iIiIII_Class412;
            this.i_method_33057dd7("Content-Disposition", "form-data; name=\"" + string + "\"" + (string2 == null ? "" : "; filename=\"" + string2 + "\""));
            this.i_method_33057dd7("Content-Type", iIiIII_Class412.i_method_ae461b4b().toString());
        }

        public iIiIII_Class41 I_method_c37cbf10() {
            return this.I_field_22346661;
        }

        private void I_method_d45c3fcd(Consumer<String> consumer) {
            this.I_method_47ffea16((string, string2) -> consumer.accept(string + ": " + string2 + "\r\n"));
        }
    }
}

