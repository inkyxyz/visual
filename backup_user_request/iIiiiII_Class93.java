package rockstar.client;

import java.io.IOException;
import rockstar.client.IiiIiI_Class27;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIIiI_Class35;
import rockstar.client.iIIIii_Class36;
import rockstar.client.iIiiIii_Class92;
import rockstar.client.iiIiiI_Class55;

public interface iIiiiII_Class93<R>
extends iiIiiI_Class55<R> {
    @Override
    default public R handle(iIIIiI_Class35 iIIIiI_Class352) throws IOException {
        String string = iIIIiI_Class352.I_method_5d16674b().I_method_963beb74();
        if (string.isEmpty() && iIIIiI_Class352.I_method_207e3e9f() == 204) {
            return null;
        }
        if (string.isEmpty() && iIIIiI_Class352.I_method_207e3e9f() >= 300) {
            throw new iIiiIii_Class92(iIIIiI_Class352, "Empty response");
        }
        if (!iIIIiI_Class352.I_method_5d16674b().i_method_ae461b4b().I_method_c05e0394().equals(iIIIii_Class36.Ii_field_58cf7a41.I_method_c05e0394())) {
            throw new iIiiIii_Class92(iIIIiI_Class352, "Wrong content type");
        }
        IiiiIi_Class30 iiiiIi_Class30 = IiiIiI_Class27.I_method_c7ec7501(string).I_method_9b832f2b();
        if (iIIIiI_Class352.I_method_207e3e9f() >= 300) {
            this.I_method_c1534541(iIIIiI_Class352, iiiiIi_Class30);
            throw new iIiiIii_Class92(iIIIiI_Class352, string);
        }
        return this.I_method_b7becc11(iIIIiI_Class352, iiiiIi_Class30);
    }

    public R I_method_b7becc11(iIIIiI_Class35 var1, IiiiIi_Class30 var2) throws IOException;

    public void I_method_c1534541(iIIIiI_Class35 var1, IiiiIi_Class30 var2) throws IOException;
}

