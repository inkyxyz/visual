package rockstar.client;

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

public class iiiIII_Class57 {
    private final String I_field_523beb0a;
    private final Charset I_field_2bdd038e;
    private final String i_field_523beb0a;

    public static iiiIII_Class57 I_method_e6646141(String string) {
        if (!string.contains(";")) {
            return new iiiIII_Class57(string.toLowerCase(Locale.ROOT), null, null);
        }
        String[] stringArray = string.split(";");
        String string2 = stringArray[0].toLowerCase(Locale.ROOT);
        Charset charset = null;
        String string3 = null;
        for (int i = 1; i < stringArray.length; ++i) {
            String string4 = stringArray[i].trim();
            if (string4.startsWith("charset=")) {
                try {
                    charset = Charset.forName(string4.substring(8));
                }
                catch (UnsupportedCharsetException unsupportedCharsetException) {}
                continue;
            }
            if (!string4.startsWith("boundary=")) continue;
            string3 = string4.substring(9);
        }
        return new iiiIII_Class57(string2, charset, string3);
    }

    public iiiIII_Class57(String string) {
        this(string, null, null);
    }

    public iiiIII_Class57(String string, @Nullable Charset charset) {
        this(string, charset, null);
    }

    public iiiIII_Class57(String string, @Nullable String string2) {
        this(string, null, string2);
    }

    public iiiIII_Class57(String string, @Nullable Charset charset, @Nullable String string2) {
        this.I_field_523beb0a = string;
        this.I_field_2bdd038e = charset;
        this.i_field_523beb0a = string2;
    }

    public String I_method_c05e0394() {
        return this.I_field_523beb0a;
    }

    public Optional<Charset> I_method_b82cb9() {
        return Optional.ofNullable(this.I_field_2bdd038e);
    }

    public Optional<String> i_method_46eb54d9() {
        return Optional.ofNullable(this.i_field_523beb0a);
    }

    public String toString() {
        return this.I_field_523beb0a + (this.I_field_2bdd038e != null ? "; charset=" + this.I_field_2bdd038e.name() : "") + (this.i_field_523beb0a != null ? "; boundary=" + this.i_field_523beb0a : "");
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        iiiIII_Class57 iiiIII_Class572 = (iiiIII_Class57)object;
        return Objects.equals(this.I_field_523beb0a, iiiIII_Class572.I_field_523beb0a) && Objects.equals(this.I_field_2bdd038e, iiiIII_Class572.I_field_2bdd038e) && Objects.equals(this.i_field_523beb0a, iiiIII_Class572.i_field_523beb0a);
    }

    public int hashCode() {
        return Objects.hash(this.I_field_523beb0a, this.I_field_2bdd038e, this.i_field_523beb0a);
    }
}

