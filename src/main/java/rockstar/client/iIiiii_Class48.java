package rockstar.client;

import java.io.IOException;
import rockstar.client.iIIIiI_Class35;

public class iIiiii_Class48
extends IOException {
    private final iIIIiI_Class35 I_field_2071ee61;

    public iIiiii_Class48(iIIIiI_Class35 iIIIiI_Class352) {
        this(iIIIiI_Class352, "Request failed: " + iIIIiI_Class352.I_method_207e3e9f() + " " + iIIIiI_Class352.I_method_db436374());
    }

    public iIiiii_Class48(iIIIiI_Class35 iIIIiI_Class352, String string) {
        super(string);
        this.I_field_2071ee61 = iIIIiI_Class352;
    }

    public iIIIiI_Class35 I_method_2871836b() {
        return this.I_field_2071ee61;
    }
}

