package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.net.MalformedURLException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import rockstar.client.IiiIiiI_Class55;
import rockstar.client.IiiiIIi_Class58;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIIiI_Class35;
import rockstar.client.iIiiIIi_Class90;
import rockstar.client.iiIIIII_Class97;
import rockstar.client.iiIIIIi_Class98;
import rockstar.client.iiIIIiI_Class99;
import rockstar.client.iiIIIii_Class100;
import rockstar.client.iiIIiII_Class101;
import rockstar.client.iiIIiIi_Class102;
import rockstar.client.iiIiIiI_Class107;

public class iiIIiii_Class104
extends iiIIiIi_Class102
implements iiIiIiI_Class107<iiIIIIi_Class98> {
    public iiIIiii_Class104(IiiIiiI_Class55 iiiIiiI_Class55, IiiiIIi_Class58 iiiiIIi_Class58, iiIIIII_Class97 iiIIIII_Class972, KeyPair keyPair, String string) throws MalformedURLException {
        super("https://sisu.xboxlive.com/authorize");
        if (!iiiIiiI_Class55.I_method_e84624a3()) {
            throw new IllegalArgumentException("Client id must be a title client id for XBL SISU authentication");
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Sandbox", "RETAIL");
        jsonObject.addProperty("UseModernGamertag", Boolean.valueOf(true));
        jsonObject.addProperty("AppId", iiiIiiI_Class55.I_method_d01bc1e1());
        jsonObject.addProperty("AccessToken", "t=" + iiiiIIi_Class58.I_method_4b3dd1e1());
        jsonObject.addProperty("DeviceToken", iiIIIII_Class972.I_method_c9babde1());
        jsonObject.add("ProofKey", (JsonElement)this.I_method_c3d500f9((ECPublicKey)keyPair.getPublic()));
        jsonObject.addProperty("RelyingParty", string);
        this.I_method_ef32890a(new iIiiIIi_Class90(jsonObject));
        this.I_method_b2602175((ECPrivateKey)keyPair.getPrivate());
    }

    @Override
    public iiIIIIi_Class98 I_method_b7becc11(iIIIiI_Class35 iIIIiI_Class352, IiiiIi_Class30 iiiiIi_Class30) {
        return new iiIIIIi_Class98(iiIIIii_Class100.i_method_e14161b6(iiiiIi_Class30.i_method_83289561("UserToken")), iiIIIiI_Class99.i_method_9dd189f6(iiiiIi_Class30.i_method_83289561("TitleToken")), iiIIiII_Class101.i_method_9a1f5176(iiiiIi_Class30.i_method_83289561("AuthorizationToken")));
    }
}

