package rockstar.client;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.MalformedURLException;
import java.security.KeyPair;
import java.util.Base64;
import rockstar.client.IIIIIii_Class4;
import rockstar.client.IIiIIii_Class20;
import rockstar.client.IIiiIIi_Class26;
import rockstar.client.IiiIii_Class28;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIIiI_Class35;
import rockstar.client.iIiiIIi_Class90;
import rockstar.client.iiIIiII_Class101;

public class IIiIiiI_Class23
extends IIIIIii_Class4
implements IIiiIIi_Class26<IIiIIii_Class20> {
    public IIiIiiI_Class23(iiIIiII_Class101 iiIIiII_Class1012, KeyPair keyPair) throws MalformedURLException {
        super("https://multiplayer.minecraft.net/authentication");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("identityPublicKey", Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded()));
        this.I_method_ef32890a(new iIiiIIi_Class90(jsonObject));
        this.i_method_33057dd7("Authorization", iiIIiII_Class1012.I_method_4fc45e01());
    }

    @Override
    public IIiIIii_Class20 I_method_b7becc11(iIIIiI_Class35 iIIIiI_Class352, IiiiIi_Class30 iiiiIi_Class30) throws IOException {
        IiiIii_Class28 iiiIii_Class28 = iiiiIi_Class30.i_method_831a81a1("chain");
        if (iiiIii_Class28.I_method_cc3efe5f() != 2) {
            throw new IllegalStateException("Invalid certificate chain length: " + iiiIii_Class28.I_method_cc3efe5f());
        }
        return new IIiIIii_Class20(iiiIii_Class28.I_method_ddc8f320(0).I_method_2c46b7d4(), iiiIii_Class28.I_method_ddc8f320(1).I_method_2c46b7d4());
    }
}

