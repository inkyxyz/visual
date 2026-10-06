package rockstar.client;

import java.net.MalformedURLException;
import java.util.HashMap;
import rockstar.client.IIIIIii_Class4;
import rockstar.client.IiiIiiI_Class55;
import rockstar.client.IiiiIII_Class57;
import rockstar.client.IiiiIIi_Class58;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.IiiiiiI_Class63;
import rockstar.client.iIIIiI_Class35;
import rockstar.client.iIiiiI_Class47;

public class IiiiiII_Class61
extends IIIIIii_Class4
implements IiiiiiI_Class63<IiiiIIi_Class58> {
    public IiiiiII_Class61(IiiIiiI_Class55 iiiIiiI_Class55, IiiiIII_Class57 iiiiIII_Class57) throws MalformedURLException {
        this(iiiIiiI_Class55, iiiiIII_Class57.i_method_982959e1());
    }

    public IiiiiII_Class61(IiiIiiI_Class55 iiiIiiI_Class55, String string) throws MalformedURLException {
        super(iiiIiiI_Class55.I_method_37e8d915().II_method_b2acc61e());
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("client_id", iiiIiiI_Class55.I_method_d01bc1e1());
        hashMap.put("grant_type", "device_code");
        hashMap.put("device_code", string);
        this.I_method_ef32890a(new iIiiiI_Class47(hashMap));
    }

    @Override
    public IiiiIIi_Class58 I_method_b7becc11(iIIIiI_Class35 iIIIiI_Class352, IiiiIi_Class30 iiiiIi_Class30) {
        return new IiiiIIi_Class58(System.currentTimeMillis() + (long)iiiiIi_Class30.i_method_5239fcc9("expires_in") * 1000L, iiiiIi_Class30.i_method_7caa7e8a("access_token"), iiiiIi_Class30.I_method_3264db60("refresh_token", null));
    }
}

