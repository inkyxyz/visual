package rockstar.client;

import java.net.MalformedURLException;
import java.util.HashMap;
import rockstar.client.IIIIIii_Class4;
import rockstar.client.IiiIiII_Class53;
import rockstar.client.IiiIiiI_Class55;
import rockstar.client.IiiiIII_Class57;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.IiiiiiI_Class63;
import rockstar.client.iIIIiI_Class35;
import rockstar.client.iIiiiI_Class47;

public class IiiiIii_Class60
extends IIIIIii_Class4
implements IiiiiiI_Class63<IiiiIII_Class57> {
    public IiiiIii_Class60(IiiIiiI_Class55 iiiIiiI_Class55) throws MalformedURLException {
        super(iiiIiiI_Class55.I_method_37e8d915().I_method_4fe9e601());
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("client_id", iiiIiiI_Class55.I_method_d01bc1e1());
        hashMap.put("scope", iiiIiiI_Class55.i_method_633a7201());
        if (iiiIiiI_Class55.I_method_37e8d915() == IiiIiII_Class53.I_field_c508bfcc) {
            hashMap.put("response_type", "device_code");
        }
        this.I_method_ef32890a(new iIiiiI_Class47(hashMap));
    }

    @Override
    public IiiiIII_Class57 I_method_b7becc11(iIIIiI_Class35 iIIIiI_Class352, IiiiIi_Class30 iiiiIi_Class30) {
        return new IiiiIII_Class57(System.currentTimeMillis() + (long)iiiiIi_Class30.i_method_5239fcc9("expires_in") * 1000L, (long)iiiiIi_Class30.i_method_5239fcc9("interval") * 1000L, iiiiIi_Class30.i_method_7caa7e8a("device_code"), iiiiIi_Class30.i_method_7caa7e8a("user_code"), iiiiIi_Class30.i_method_7caa7e8a("verification_uri"));
    }
}

