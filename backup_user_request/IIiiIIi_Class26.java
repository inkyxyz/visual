package rockstar.client;

import java.io.IOException;
import rockstar.client.IIiIIIi_Class18;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIIiI_Class35;
import rockstar.client.iIiiIii_Class92;
import rockstar.client.iIiiiII_Class93;

public interface IIiiIIi_Class26<R>
extends iIiiiII_Class93<R> {
    @Override
    default public void I_method_c1534541(iIIIiI_Class35 iIIIiI_Class352, IiiiIi_Class30 iiiiIi_Class30) throws IOException {
        if (iiiiIi_Class30.III_method_15e7b21a("error") && iiiiIi_Class30.III_method_15e7b21a("errorMessage")) {
            throw new IIiIIIi_Class18(iIIIiI_Class352, iiiiIi_Class30.i_method_7caa7e8a("error"), iiiiIi_Class30.i_method_7caa7e8a("errorMessage"));
        }
        if (iiiiIi_Class30.III_method_15e7b21a("errorMessage")) {
            throw new iIiiIii_Class92(iIIIiI_Class352, iiiiIi_Class30.i_method_7caa7e8a("errorMessage"));
        }
    }
}

