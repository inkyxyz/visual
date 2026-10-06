package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.net.MalformedURLException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.time.Instant;
import java.util.UUID;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIIiI_Class35;
import rockstar.client.iIiiIIi_Class90;
import rockstar.client.iiIIIII_Class97;
import rockstar.client.iiIIiIi_Class102;
import rockstar.client.iiIiIiI_Class107;

public class iiIIiiI_Class103
extends iiIIiIi_Class102
implements iiIiIiI_Class107<iiIIIII_Class97> {
    public iiIIiiI_Class103(String string, UUID uUID, KeyPair keyPair) throws MalformedURLException {
        super("https://device.auth.xboxlive.com/device/authenticate");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("DeviceType", string);
        jsonObject.addProperty("Id", "{" + uUID + "}");
        jsonObject.addProperty("AuthMethod", "ProofOfPossession");
        jsonObject.add("ProofKey", (JsonElement)this.I_method_c3d500f9((ECPublicKey)keyPair.getPublic()));
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.add("Properties", (JsonElement)jsonObject);
        jsonObject2.addProperty("RelyingParty", "http://auth.xboxlive.com");
        jsonObject2.addProperty("TokenType", "JWT");
        this.I_method_ef32890a(new iIiiIIi_Class90(jsonObject2));
        this.i_method_33057dd7("x-xbl-contract-version", "1");
        this.I_method_b2602175((ECPrivateKey)keyPair.getPrivate());
    }

    @Override
    public iiIIIII_Class97 I_method_b7becc11(iIIIiI_Class35 iIIIiI_Class352, IiiiIi_Class30 iiiiIi_Class30) {
        return new iiIIIII_Class97(Instant.parse(iiiiIi_Class30.i_method_7caa7e8a("NotAfter")).toEpochMilli(), iiiiIi_Class30.i_method_7caa7e8a("Token"), iiiiIi_Class30.i_method_83289561("DisplayClaims").i_method_83289561("xdi").i_method_7caa7e8a("did"));
    }
}

