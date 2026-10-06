package rockstar.client;

import com.google.gson.JsonObject;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.time.Instant;
import java.util.Base64;
import java.util.Optional;
import rockstar.client.IIIIIii_Class4;
import rockstar.client.iIIiiIi_Class78;
import rockstar.client.iIiIII_Class41;
import rockstar.client.iIiIIiI_Class83;
import rockstar.client.iiiiiI_Class63;

public abstract class iiIIiIi_Class102
extends IIIIIii_Class4 {
    public iiIIiIi_Class102(String string) throws MalformedURLException {
        super(string);
    }

    public iiIIiIi_Class102(URL uRL) {
        super(uRL);
    }

    protected void I_method_b2602175(ECPrivateKey eCPrivateKey) {
        long l = (Instant.now().plus(iIiIIiI_Class83.I_method_91aded3d()).getEpochSecond() + 11644473600L) * 10000000L;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            iIiIII_Class41 iIiIII_Class412;
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream2);
            dataOutputStream.writeInt(1);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeLong(l);
            dataOutputStream.writeByte(0);
            dataOutputStream.write(this.I_method_ccca7b4().getBytes(StandardCharsets.UTF_8));
            dataOutputStream.writeByte(0);
            dataOutputStream.write((this.I_method_816b7c29().getPath() + (this.I_method_816b7c29().getQuery() != null ? this.I_method_816b7c29().getQuery() : "")).getBytes(StandardCharsets.UTF_8));
            dataOutputStream.writeByte(0);
            Optional<String> optional = this.I_method_a5598def("Authorization");
            if (optional.isPresent()) {
                dataOutputStream.write(optional.get().getBytes(StandardCharsets.UTF_8));
            }
            dataOutputStream.writeByte(0);
            if (this instanceof iiiiiI_Class63 && (iIiIII_Class412 = this.I_method_bb2eeb6b()) != null) {
                dataOutputStream.write(iIiIII_Class412.I_method_7c521fb1());
            }
            dataOutputStream.writeByte(0);
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt(1);
            dataOutputStream.writeLong(l);
            dataOutputStream.write(iIIiiIi_Class78.I_method_8d9b1b61(eCPrivateKey, byteArrayOutputStream2.toByteArray()));
        }
        catch (Throwable throwable) {
            throw new RuntimeException("Failed to sign request", throwable);
        }
        this.I_method_c114f5b7("Signature", Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray()));
    }

    protected JsonObject I_method_c3d500f9(ECPublicKey eCPublicKey) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("kty", "EC");
        jsonObject.addProperty("alg", "ES256");
        jsonObject.addProperty("crv", "P-256");
        jsonObject.addProperty("use", "sig");
        jsonObject.addProperty("x", this.I_method_a73b81c5(eCPublicKey.getParams().getCurve().getField().getFieldSize(), eCPublicKey.getW().getAffineX()));
        jsonObject.addProperty("y", this.I_method_a73b81c5(eCPublicKey.getParams().getCurve().getField().getFieldSize(), eCPublicKey.getW().getAffineY()));
        return jsonObject;
    }

    private String I_method_a73b81c5(int n, BigInteger bigInteger) {
        int n2;
        byte[] byArray = this.I_method_bf1b5fc7(bigInteger);
        if (byArray.length >= (n2 = (n + 7) / 8)) {
            return Base64.getUrlEncoder().withoutPadding().encodeToString(byArray);
        }
        byte[] byArray2 = new byte[n2];
        System.arraycopy(byArray, 0, byArray2, n2 - byArray.length, byArray.length);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(byArray2);
    }

    private byte[] I_method_bf1b5fc7(BigInteger bigInteger) {
        int n = bigInteger.bitLength();
        n = n + 7 >> 3 << 3;
        byte[] byArray = bigInteger.toByteArray();
        if (bigInteger.bitLength() % 8 != 0 && bigInteger.bitLength() / 8 + 1 == n / 8) {
            return byArray;
        }
        int n2 = 0;
        int n3 = byArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            n2 = 1;
            --n3;
        }
        int n4 = n / 8 - n3;
        byte[] byArray2 = new byte[n / 8];
        System.arraycopy(byArray, n2, byArray2, n4, n3);
        return byArray2;
    }
}

