package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.net.MalformedURLException;
import rockstar.client.IIIIIii_Class4;
import rockstar.client.IiiIiiI_Class55;
import rockstar.client.IiiiIIi_Class58;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIIiI_Class35;
import rockstar.client.iIiiIIi_Class90;
import rockstar.client.iiIIIii_Class100;
import rockstar.client.iiIiIiI_Class107;

public class iiIiIII_Class105
extends IIIIIii_Class4
implements iiIiIiI_Class107<iiIIIii_Class100> {
    public iiIiIII_Class105(IiiIiiI_Class55 iiiIiiI_Class55, IiiiIIi_Class58 iiiiIIi_Class58) throws MalformedURLException {
        super("https://user.auth.xboxlive.com/user/authenticate");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("SiteName", "user.auth.xboxlive.com");
        jsonObject.addProperty("AuthMethod", "RPS");
        jsonObject.addProperty("RpsTicket", (iiiIiiI_Class55.I_method_e84624a3() ? "t=" : "d=") + iiiiIIi_Class58.I_method_4b3dd1e1());
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.add("Properties", (JsonElement)jsonObject);
        jsonObject2.addProperty("RelyingParty", "http://auth.xboxlive.com");
        jsonObject2.addProperty("TokenType", "JWT");
        this.I_method_ef32890a(new iIiiIIi_Class90(jsonObject2));
        this.i_method_33057dd7("x-xbl-contract-version", "1");
    }

    @Override
    public iiIIIii_Class100 I_method_b7becc11(iIIIiI_Class35 iIIIiI_Class352, IiiiIi_Class30 iiiiIi_Class30) {
        return iiIIIii_Class100.i_method_e14161b6(iiiiIi_Class30);
    }
}

