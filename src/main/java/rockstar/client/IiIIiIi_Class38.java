package rockstar.client;

import java.io.IOException;
import rockstar.client.IIiiIii_Class28;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIIiI_Class35;
import rockstar.client.iIiiiII_Class93;

public interface IiIIiIi_Class38<R>
extends iIiiiII_Class93<R> {
    @Override
    default public void I_method_c1534541(iIIIiI_Class35 iIIIiI_Class352, IiiiIi_Class30 iiiiIi_Class30) throws IOException {
        if (iiiiIi_Class30.ii_method_1d104d43("errorCode") && iiiiIi_Class30.III_method_15e7b21a("errorMsg")) {
            throw new IIiiIii_Class28(iIIIiI_Class352, iiiiIi_Class30.i_method_5239fcc9("errorCode"), iiiiIi_Class30.i_method_7caa7e8a("errorMsg"));
        }
    }
}

