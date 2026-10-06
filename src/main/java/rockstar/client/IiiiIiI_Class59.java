package rockstar.client;

import java.net.MalformedURLException;
import java.util.HashMap;
import rockstar.client.IIIIIii_Class4;
import rockstar.client.IiiIiiI_Class55;
import rockstar.client.IiiiIIi_Class58;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.IiiiiiI_Class63;
import rockstar.client.iIIIiI_Class35;
import rockstar.client.iIiiiI_Class47;

public class IiiiIiI_Class59
extends IIIIIii_Class4
implements IiiiiiI_Class63<IiiiIIi_Class58> {
    public IiiiIiI_Class59(IiiIiiI_Class55 iiiIiiI_Class55, String string) throws MalformedURLException {
        super(iiiIiiI_Class55.I_method_37e8d915().II_method_b2acc61e());
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("client_id", iiiIiiI_Class55.I_method_d01bc1e1());
        hashMap.put("scope", iiiIiiI_Class55.i_method_633a7201());
        if (iiiIiiI_Class55.II_method_38b6663e() != null) {
            hashMap.put("client_secret", iiiIiiI_Class55.II_method_38b6663e());
        }
        if (iiiIiiI_Class55.Ii_method_cbd5165e() != null) {
            hashMap.put("redirect_uri", iiiIiiI_Class55.Ii_method_cbd5165e());
        }
        hashMap.put("grant_type", "authorization_code");
        hashMap.put("code", string);
        this.I_method_ef32890a(new iIiiiI_Class47(hashMap));
    }

    @Override
    public IiiiIIi_Class58 I_method_b7becc11(iIIIiI_Class35 iIIIiI_Class352, IiiiIi_Class30 iiiiIi_Class30) {
        return new IiiiIIi_Class58(System.currentTimeMillis() + (long)iiiiIi_Class30.i_method_5239fcc9("expires_in") * 1000L, iiiiIi_Class30.i_method_7caa7e8a("access_token"), iiiiIi_Class30.I_method_3264db60("refresh_token", null));
    }
}

