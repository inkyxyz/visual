package rockstar.client;

import java.util.Objects;
import javax.annotation.Nonnull;

public class iiiIIi_Class58 {
    @Nonnull
    private final String I_field_523beb0a;
    @Nonnull
    private final String i_field_523beb0a;

    public iiiIIi_Class58(@Nonnull String string, @Nonnull String string2) {
        this.I_field_523beb0a = string;
        this.i_field_523beb0a = string2;
    }

    @Nonnull
    public String I_method_6912bb4() {
        return this.I_field_523beb0a;
    }

    @Nonnull
    public String i_method_99afdbd4() {
        return this.i_field_523beb0a;
    }

    public String toString() {
        return "HttpHeader{name='" + this.I_field_523beb0a + '\'' + ", value='" + this.i_field_523beb0a + '\'' + '}';
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        iiiIIi_Class58 iiiIIi_Class582 = (iiiIIi_Class58)object;
        return Objects.equals(this.I_field_523beb0a, iiiIIi_Class582.I_field_523beb0a) && Objects.equals(this.i_field_523beb0a, iiiIIi_Class582.i_field_523beb0a);
    }

    public int hashCode() {
        return Objects.hash(this.I_field_523beb0a, this.i_field_523beb0a);
    }
}

