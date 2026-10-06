package rockstar.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.annotation.Nullable;
import rockstar.client.iIiIII_Class41;
import rockstar.client.iiiiii_Class64;

public class iiiiiI_Class63
extends iiiiii_Class64 {
    @Nullable
    private iIiIII_Class41 I_field_22346661;

    public iiiiiI_Class63(String string, String string2) throws MalformedURLException {
        super(string, string2);
    }

    public iiiiiI_Class63(String string, URL uRL) {
        super(string, uRL);
    }

    public boolean I_method_2e5fde90() {
        return this.I_field_22346661 != null;
    }

    @Nullable
    public iIiIII_Class41 I_method_bb2eeb6b() {
        return this.I_field_22346661;
    }

    public iiiiiI_Class63 I_method_ef32890a(@Nullable iIiIII_Class41 iIiIII_Class412) {
        this.I_field_22346661 = iIiIII_Class412;
        return this;
    }
}

