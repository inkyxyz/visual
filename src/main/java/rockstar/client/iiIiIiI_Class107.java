package rockstar.client;

import java.io.IOException;
import java.util.Optional;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIIiI_Class35;
import rockstar.client.iIiiiII_Class93;
import rockstar.client.iIiiiii_Class96;

public interface iiIiIiI_Class107<R>
extends iIiiiII_Class93<R> {
    @Override
    default public R handle(iIIIiI_Class35 iIIIiI_Class352) throws IOException {
        Optional<String> optional;
        if (iIIIiI_Class352.I_method_207e3e9f() >= 300 && (optional = iIIIiI_Class352.I_method_a5598def("X-Err")).isPresent()) {
            throw new iIiiiii_Class96(iIIIiI_Class352, Long.parseLong(optional.get()));
        }
        return iIiiiII_Class93.super.handle(iIIIiI_Class352);
    }

    @Override
    default public void I_method_c1534541(iIIIiI_Class35 iIIIiI_Class352, IiiiIi_Class30 iiiiIi_Class30) throws IOException {
        if (iiiiIi_Class30.ii_method_1d104d43("XErr")) {
            throw new iIiiiii_Class96(iIIIiI_Class352, iiiiIi_Class30.i_method_5239fcca("XErr"));
        }
    }
}

