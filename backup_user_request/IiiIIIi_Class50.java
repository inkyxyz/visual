package rockstar.client;

import java.io.IOException;
import java.net.MalformedURLException;
import rockstar.client.IIIIIIi_Class2;
import rockstar.client.IiIiIiI_Class43;
import rockstar.client.IiIiIii_Class44;
import rockstar.client.IiIiiIi_Class46;
import rockstar.client.IiIiiiI_Class47;
import rockstar.client.IiiIIiI_Class51;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIIiI_Class35;
import rockstar.client.iIiIIii_Class84;

public class IiiIIIi_Class50
extends IIIIIIi_Class2
implements IiiIIiI_Class51<IiIiiIi_Class46> {
    public IiiIIIi_Class50(IiIiiiI_Class47 iiIiiiI_Class47) throws MalformedURLException {
        super("https://api.minecraftservices.com/minecraft/profile");
        this.i_method_33057dd7("Authorization", iiIiiiI_Class47.I_method_e1240da1());
    }

    @Override
    public IiIiiIi_Class46 I_method_b7becc11(iIIIiI_Class35 iIIIiI_Class352, IiiiIi_Class30 iiiiIi_Class30) throws IOException {
        return new IiIiiIi_Class46(iIiIIii_Class84.I_method_3ea58b61(iiiiIi_Class30.i_method_7caa7e8a("id")), iiiiIi_Class30.i_method_7caa7e8a("name"));
    }

    @Override
    public void I_method_c1534541(iIIIiI_Class35 iIIIiI_Class352, IiiiIi_Class30 iiiiIi_Class30) throws IOException {
        try {
            IiiIIiI_Class51.super.I_method_c1534541(iIIIiI_Class352, iiiiIi_Class30);
        }
        catch (IiIiIii_Class44 iiIiIii_Class44) {
            if (iiIiIii_Class44.I_method_2871836b().I_method_207e3e9f() == 404) {
                throw new IiIiIiI_Class43(iiIiIii_Class44);
            }
            throw iiIiIii_Class44;
        }
    }
}

