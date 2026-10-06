package rockstar.client;

import java.io.IOException;
import rockstar.client.IIiIIiI_Class19;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIIiI_Class35;
import rockstar.client.iIiiiII_Class93;

public interface IIiiIiI_Class27<R>
extends iIiiiII_Class93<R> {
    @Override
    default public void I_method_c1534541(iIIIiI_Class35 iIIIiI_Class352, IiiiIi_Class30 iiiiIi_Class30) throws IOException {
        IIiIIiI_Class19 iIiIIiI_Class19 = null;
        Throwable throwable = null;
        IiiiIi_Class30 iiiiIi_Class302 = iiiiIi_Class30;
        do {
            if (!iiiiIi_Class302.III_method_15e7b21a("namespace") || !iiiiIi_Class302.III_method_15e7b21a("code") || !iiiiIi_Class302.III_method_15e7b21a("message")) continue;
            IIiIIiI_Class19 iIiIIiI_Class192 = new IIiIIiI_Class19(iIIIiI_Class352, iiiiIi_Class302.I_method_5c8b966a("namespace"), iiiiIi_Class302.i_method_7caa7e8a("code"), iiiiIi_Class302.i_method_7caa7e8a("message"));
            if (iIiIIiI_Class19 == null) {
                iIiIIiI_Class19 = iIiIIiI_Class192;
            } else {
                throwable.addSuppressed(iIiIIiI_Class192);
            }
            throwable = iIiIIiI_Class192;
        } while ((iiiiIi_Class302 = iiiiIi_Class302.i_method_5239fcda("innerError") ? iiiiIi_Class302.i_method_83289561("innerError") : null) != null);
        if (iIiIIiI_Class19 != null) {
            throw iIiIIiI_Class19;
        }
    }
}

