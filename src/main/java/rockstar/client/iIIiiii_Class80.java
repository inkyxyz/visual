package rockstar.client;

import com.google.gson.JsonObject;
import java.security.KeyPair;
import java.util.Base64;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIiiIi_Class78;

public class iIIiiii_Class80 {
    public static JsonObject I_method_5397a57(KeyPair keyPair) {
        if (keyPair.getPublic() == null || keyPair.getPrivate() == null) {
            throw new IllegalArgumentException("KeyPair must contain both public and private key");
        }
        if (!keyPair.getPublic().getAlgorithm().equals(keyPair.getPrivate().getAlgorithm())) {
            throw new IllegalArgumentException("Public and private key must use the same algorithm");
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("algorithm", keyPair.getPublic().getAlgorithm());
        jsonObject.addProperty("publicKey", Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded()));
        jsonObject.addProperty("privateKey", Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded()));
        return jsonObject;
    }

    public static KeyPair I_method_dcbfd87a(IiiiIi_Class30 iiiiIi_Class30) {
        String string;
        switch (string = iiiiIi_Class30.i_method_7caa7e8a("algorithm")) {
            case "RSA": {
                return new KeyPair(iIIiiIi_Class78.I_method_27430b71(iiiiIi_Class30.i_method_7caa7e8a("publicKey")), iIIiiIi_Class78.I_method_781fafb3(iiiiIi_Class30.i_method_7caa7e8a("privateKey")));
            }
            case "EC": {
                return new KeyPair(iIIiiIi_Class78.I_method_20df3017(iiiiIi_Class30.i_method_7caa7e8a("publicKey")), iIIiiIi_Class78.I_method_b2081fcd(iiiiIi_Class30.i_method_7caa7e8a("privateKey")));
            }
        }
        throw new IllegalArgumentException("Unsupported key algorithm: " + string);
    }
}

