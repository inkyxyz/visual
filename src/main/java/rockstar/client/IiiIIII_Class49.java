package rockstar.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.KeyPair;
import java.time.Instant;
import java.util.Base64;
import rockstar.client.IIIIIii_Class4;
import rockstar.client.IiIiiII_Class45;
import rockstar.client.IiIiiiI_Class47;
import rockstar.client.IiiIIiI_Class51;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIIiI_Class35;
import rockstar.client.iIIiiIi_Class78;

public class IiiIIII_Class49
extends IIIIIii_Class4
implements IiiIIiI_Class51<IiIiiII_Class45> {
    public IiiIIII_Class49(IiIiiiI_Class47 iiIiiiI_Class47) throws MalformedURLException {
        super("https://api.minecraftservices.com/player/certificates");
        this.i_method_33057dd7("Authorization", iiIiiiI_Class47.I_method_e1240da1());
    }

    @Override
    public IiIiiII_Class45 I_method_b7becc11(iIIIiI_Class35 iIIIiI_Class352, IiiiIi_Class30 iiiiIi_Class30) throws IOException {
        IiiiIi_Class30 iiiiIi_Class302 = iiiiIi_Class30.i_method_83289561("keyPair");
        return new IiIiiII_Class45(Instant.parse(iiiiIi_Class30.i_method_7caa7e8a("expiresAt")).toEpochMilli(), new KeyPair(iIIiiIi_Class78.I_method_f681ceae(Base64.getMimeDecoder().decode(iiiiIi_Class302.i_method_7caa7e8a("publicKey").replace("-----BEGIN RSA PUBLIC KEY-----", "").replace("-----END RSA PUBLIC KEY-----", ""))), iIIiiIi_Class78.I_method_90b95416(Base64.getMimeDecoder().decode(iiiiIi_Class302.i_method_7caa7e8a("privateKey").replace("-----BEGIN RSA PRIVATE KEY-----", "").replace("-----END RSA PRIVATE KEY-----", "")))), Base64.getDecoder().decode(iiiiIi_Class30.i_method_7caa7e8a("publicKeySignatureV2")), iiiiIi_Class30.ii_method_999a5f26("publicKeySignature").map(Base64.getDecoder()::decode).orElse(null));
    }
}

