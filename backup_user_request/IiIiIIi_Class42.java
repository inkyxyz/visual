package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.security.KeyPair;
import java.util.UUID;
import java.util.concurrent.TimeoutException;
import lombok.Generated;
import rockstar.client.IiIiiII_Class45;
import rockstar.client.IiIiiIi_Class46;
import rockstar.client.IiIiiiI_Class47;
import rockstar.client.IiIiiii_Class48;
import rockstar.client.IiiIIII_Class49;
import rockstar.client.IiiIIIi_Class50;
import rockstar.client.IiiIiiI_Class55;
import rockstar.client.IiiiIIi_Class58;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.IiiiiIi_Class62;
import rockstar.client.Iiiiiii_Class64;
import rockstar.client.iIIIII_Class33;
import rockstar.client.iIIIiII_Class69;
import rockstar.client.iIIIiIi_Class70;
import rockstar.client.iIIiiIi_Class78;
import rockstar.client.iIIiiii_Class80;
import rockstar.client.iIiIiII_Class85;
import rockstar.client.iIiiIII_Class89;
import rockstar.client.iiIIIII_Class97;
import rockstar.client.iiIIIIi_Class98;
import rockstar.client.iiIIIiI_Class99;
import rockstar.client.iiIIIii_Class100;
import rockstar.client.iiIIiII_Class101;
import rockstar.client.iiIIiiI_Class103;
import rockstar.client.iiIIiii_Class104;
import rockstar.client.iiIiIII_Class105;
import rockstar.client.iiIiIIi_Class106;

public class IiIiIIi_Class42 {
    private final iIIIII_Class33 I_field_20717641;
    private final IiiIiiI_Class55 I_field_c50937ec;
    private final String I_field_523beb0a;
    private final KeyPair I_field_240b2c30;
    private final UUID I_field_7fb73d4;
    private final iIiiIII_Class89 I_field_261b57cc = new iIiiIII_Class89();
    private final Object I_field_5f790d9c = new Object();
    private final iIiIiII_Class85<IiiiIIi_Class58> I_field_2466f38c = new iIiIiII_Class85<IiiiIIi_Class58>(this::I_method_c310ad55);
    private final iIiIiII_Class85<iiIIIII_Class97> i_field_2466f38c = new iIiIiII_Class85<iiIIIII_Class97>(this::I_method_86d84155);
    private final iIiIiII_Class85<iiIIIii_Class100> II_field_2466f38c = new iIiIiII_Class85<iiIIIii_Class100>(this::I_method_86d8bd55, this.I_field_5f790d9c);
    private final iIiIiII_Class85<iiIIIiI_Class99> Ii_field_2466f38c = new iIiIiII_Class85<iiIIIiI_Class99>(this::I_method_86d8b975, this.I_field_5f790d9c);
    private final iIiIiII_Class85<iiIIiII_Class101> iI_field_2466f38c = new iIiIiII_Class85<iiIIiII_Class101>(this::I_method_86e6cd35, this.I_field_5f790d9c);
    private final iIiIiII_Class85<IiIiiiI_Class47> ii_field_2466f38c = new iIiIiII_Class85<IiIiiiI_Class47>(this::I_method_8c849995);
    private final iIiIiII_Class85<IiIiiIi_Class46> III_field_2466f38c = new iIiIiII_Class85<IiIiiIi_Class46>(this::I_method_8c842555);
    private final iIiIiII_Class85<IiIiiII_Class45> IIi_field_2466f38c = new iIiIiII_Class85<IiIiiII_Class45>(this::I_method_8c842175);

    public static IiIiIIi_Class42 I_method_136c6e22(iIIIII_Class33 iIIIII_Class332, JsonObject jsonObject) {
        return IiIiIIi_Class42.I_method_e737cc17(iIIIII_Class332, new IiiiIi_Class30(jsonObject));
    }

    public static IiIiIIi_Class42 I_method_e737cc17(iIIIII_Class33 iIIIII_Class332, IiiiIi_Class30 iiiiIi_Class30) {
        return new IiIiIIi_Class42(iIIIII_Class332, IiiIiiI_Class55.I_method_213615d6(iiiiIi_Class30.i_method_83289561("msaApplicationConfig")), iiiiIi_Class30.i_method_7caa7e8a("deviceType"), iIIiiii_Class80.I_method_dcbfd87a(iiiiIi_Class30.i_method_83289561("deviceKeyPair")), UUID.fromString(iiiiIi_Class30.i_method_7caa7e8a("deviceId")), IiiiIIi_Class58.I_method_c785f5d6(iiiiIi_Class30.i_method_83289561("msaToken")), iiiiIi_Class30.i_method_dbd1c22f("xblDeviceToken").map(iiIIIII_Class97::I_method_b8331dd6).orElse(null), iiiiIi_Class30.i_method_dbd1c22f("xblUserToken").map(iiIIIii_Class100::I_method_262e15d6).orElse(null), iiiiIi_Class30.i_method_dbd1c22f("xblTitleToken").map(iiIIIiI_Class99::I_method_e2be3e16).orElse(null), iiiiIi_Class30.i_method_dbd1c22f("javaXstsToken").map(iiIIiII_Class101::I_method_df0c0596).orElse(null), iiiiIi_Class30.i_method_dbd1c22f("minecraftToken").map(IiIiiiI_Class47::I_method_13c2e56).orElse(null), iiiiIi_Class30.i_method_dbd1c22f("minecraftProfile").map(IiIiiIi_Class46::I_method_1a20e5d6).orElse(null), iiiiIi_Class30.i_method_dbd1c22f("minecraftPlayerCertificates").map(IiIiiII_Class45::I_method_d6b10e16).orElse(null));
    }

    public static JsonObject I_method_56f693bb(IiIiIIi_Class42 iiIiIIi_Class42) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", (Number)1);
        jsonObject.add("msaApplicationConfig", (JsonElement)IiiIiiI_Class55.I_method_24a67fbb(iiIiIIi_Class42.I_field_c50937ec));
        jsonObject.addProperty("deviceType", iiIiIIi_Class42.I_field_523beb0a);
        jsonObject.add("deviceKeyPair", (JsonElement)iIIiiii_Class80.I_method_5397a57(iiIiIIi_Class42.I_field_240b2c30));
        jsonObject.addProperty("deviceId", iiIiIIi_Class42.I_field_7fb73d4.toString());
        jsonObject.add("msaToken", (JsonElement)IiiiIIi_Class58.I_method_b9dc7fbb(iiIiIIi_Class42.I_field_2466f38c.I_method_72256cd5()));
        if (iiIiIIi_Class42.i_field_2466f38c.I_method_a51d1043()) {
            jsonObject.add("xblDeviceToken", (JsonElement)iiIIIII_Class97.I_method_6aa8ffbb(iiIiIIi_Class42.i_field_2466f38c.I_method_72256cd5()));
        }
        if (iiIiIIi_Class42.II_field_2466f38c.I_method_a51d1043()) {
            jsonObject.add("xblUserToken", (JsonElement)iiIIIii_Class100.I_method_c2267fbb(iiIiIIi_Class42.II_field_2466f38c.I_method_72256cd5()));
        }
        if (iiIiIIi_Class42.Ii_field_2466f38c.I_method_a51d1043()) {
            jsonObject.add("xblTitleToken", (JsonElement)iiIIIiI_Class99.I_method_876a93bb(iiIiIIi_Class42.Ii_field_2466f38c.I_method_72256cd5()));
        }
        if (iiIiIIi_Class42.iI_field_2466f38c.I_method_a51d1043()) {
            jsonObject.add("javaXstsToken", (JsonElement)iiIIiII_Class101.I_method_e619ebbb(iiIiIIi_Class42.iI_field_2466f38c.I_method_72256cd5()));
        }
        if (iiIiIIi_Class42.ii_field_2466f38c.I_method_a51d1043()) {
            jsonObject.add("minecraftToken", (JsonElement)IiIiiiI_Class47.I_method_b46d27bb(iiIiIIi_Class42.ii_field_2466f38c.I_method_72256cd5()));
        }
        if (iiIiIIi_Class42.III_field_2466f38c.I_method_a51d1043()) {
            jsonObject.add("minecraftProfile", (JsonElement)IiIiiIi_Class46.I_method_d2677fbb(iiIiIIi_Class42.III_field_2466f38c.I_method_72256cd5()));
        }
        if (iiIiIIi_Class42.IIi_field_2466f38c.I_method_a51d1043()) {
            jsonObject.add("minecraftPlayerCertificates", (JsonElement)IiIiiII_Class45.I_method_97ab93bb(iiIiIIi_Class42.IIi_field_2466f38c.I_method_72256cd5()));
        }
        return jsonObject;
    }

    public static Nested1_e79bbdc0 I_method_a1cb07b1(iIIIII_Class33 iIIIII_Class332) {
        return new Nested1_e79bbdc0(iIIIII_Class332);
    }

    private IiIiIIi_Class42(iIIIII_Class33 iIIIII_Class332, IiiIiiI_Class55 iiiIiiI_Class55, String string, KeyPair keyPair, UUID uUID, IiiiIIi_Class58 iiiiIIi_Class58) {
        this.I_field_20717641 = iIIIII_Class332;
        this.I_field_c50937ec = iiiIiiI_Class55;
        this.I_field_523beb0a = string;
        this.I_field_240b2c30 = keyPair;
        this.I_field_7fb73d4 = uUID;
        this.I_field_2466f38c.I_method_eb0fcb87(iiiiIIi_Class58);
        this.i_method_85627c9f();
    }

    private IiIiIIi_Class42(iIIIII_Class33 iIIIII_Class332, IiiIiiI_Class55 iiiIiiI_Class55, String string, KeyPair keyPair, UUID uUID, IiiiIIi_Class58 iiiiIIi_Class58, iiIIIII_Class97 iiIIIII_Class972, iiIIIii_Class100 iiIIIii_Class1002, iiIIIiI_Class99 iiIIIiI_Class992, iiIIiII_Class101 iiIIiII_Class1012, IiIiiiI_Class47 iiIiiiI_Class47, IiIiiIi_Class46 iiIiiIi_Class46, IiIiiII_Class45 iiIiiII_Class45) {
        this.I_field_20717641 = iIIIII_Class332;
        this.I_field_c50937ec = iiiIiiI_Class55;
        this.I_field_523beb0a = string;
        this.I_field_240b2c30 = keyPair;
        this.I_field_7fb73d4 = uUID;
        this.I_field_2466f38c.I_method_eb0fcb87(iiiiIIi_Class58);
        this.i_field_2466f38c.I_method_eb0fcb87(iiIIIII_Class972);
        this.II_field_2466f38c.I_method_eb0fcb87(iiIIIii_Class1002);
        this.Ii_field_2466f38c.I_method_eb0fcb87(iiIIIiI_Class992);
        this.iI_field_2466f38c.I_method_eb0fcb87(iiIIiII_Class1012);
        this.ii_field_2466f38c.I_method_eb0fcb87(iiIiiiI_Class47);
        this.III_field_2466f38c.I_method_eb0fcb87(iiIiiIi_Class46);
        this.IIi_field_2466f38c.I_method_eb0fcb87(iiIiiII_Class45);
        this.i_method_85627c9f();
    }

    private IiiiIIi_Class58 I_method_c310ad55() throws IOException {
        if (this.I_field_2466f38c.I_method_72256cd5().i_method_de5c8201() == null) {
            throw new IllegalStateException("Can't refresh MSA token, because it was created without a refresh token. The user has to sign in again.");
        }
        return (IiiiIIi_Class58)this.I_field_20717641.I_method_fc2df765(new IiiiiIi_Class62(this.I_field_c50937ec, this.I_field_2466f38c.I_method_72256cd5()));
    }

    private iiIIIII_Class97 I_method_86d84155() throws IOException {
        return (iiIIIII_Class97)this.I_field_20717641.I_method_fc2df765(new iiIIiiI_Class103(this.I_field_523beb0a, this.I_field_7fb73d4, this.I_field_240b2c30));
    }

    private iiIIIii_Class100 I_method_86d8bd55() throws IOException {
        if (this.I_field_c50937ec.I_method_e84624a3()) {
            this.I_method_8553f0bf();
            return this.II_field_2466f38c.I_method_72256cd5();
        }
        return (iiIIIii_Class100)this.I_field_20717641.I_method_fc2df765(new iiIiIII_Class105(this.I_field_c50937ec, this.I_field_2466f38c.i_method_8c4658b5()));
    }

    private iiIIIiI_Class99 I_method_86d8b975() throws IOException {
        if (!this.I_field_c50937ec.I_method_e84624a3()) {
            throw new UnsupportedOperationException("Can't refresh XBL title token, because the MSA application client ID is not a title client ID");
        }
        this.I_method_8553f0bf();
        return this.Ii_field_2466f38c.I_method_72256cd5();
    }

    private iiIIiII_Class101 I_method_86e6cd35() throws IOException {
        if (this.I_field_c50937ec.I_method_e84624a3()) {
            this.I_method_8553f0bf();
            return this.iI_field_2466f38c.I_method_72256cd5();
        }
        return (iiIIiII_Class101)this.I_field_20717641.I_method_fc2df765(new iiIiIIi_Class106(this.i_field_2466f38c.i_method_8c4658b5(), this.II_field_2466f38c.i_method_8c4658b5(), null, "rp://api.minecraftservices.com/"));
    }

    private IiIiiiI_Class47 I_method_8c849995() throws IOException {
        return (IiIiiiI_Class47)this.I_field_20717641.I_method_fc2df765(new IiIiiii_Class48(this.iI_field_2466f38c.i_method_8c4658b5()));
    }

    private IiIiiIi_Class46 I_method_8c842555() throws IOException {
        return (IiIiiIi_Class46)this.I_field_20717641.I_method_fc2df765(new IiiIIIi_Class50(this.ii_field_2466f38c.i_method_8c4658b5()));
    }

    private IiIiiII_Class45 I_method_8c842175() throws IOException {
        return (IiIiiII_Class45)this.I_field_20717641.I_method_fc2df765(new IiiIIII_Class49(this.ii_field_2466f38c.i_method_8c4658b5()));
    }

    private void I_method_8553f0bf() throws IOException {
        iiIIIIi_Class98 iiIIIIi_Class982 = (iiIIIIi_Class98)this.I_field_20717641.I_method_fc2df765(new iiIIiii_Class104(this.I_field_c50937ec, this.I_field_2466f38c.i_method_8c4658b5(), this.i_field_2466f38c.i_method_8c4658b5(), this.I_field_240b2c30, "rp://api.minecraftservices.com/"));
        this.II_field_2466f38c.I_method_eb0fcb87(iiIIIIi_Class982.I_method_53c84915());
        this.Ii_field_2466f38c.I_method_eb0fcb87(iiIIIIi_Class982.I_method_53c84535());
        this.iI_field_2466f38c.I_method_eb0fcb87(iiIIIIi_Class982.I_method_53d658f5());
    }

    private void i_method_85627c9f() {
        this.I_field_2466f38c.I_method_a8b17cb5().I_method_337d8ee7(this.I_field_261b57cc::I_method_f42361b7);
        this.i_field_2466f38c.I_method_a8b17cb5().I_method_337d8ee7(this.I_field_261b57cc::I_method_f42361b7);
        this.II_field_2466f38c.I_method_a8b17cb5().I_method_337d8ee7(this.I_field_261b57cc::I_method_f42361b7);
        this.Ii_field_2466f38c.I_method_a8b17cb5().I_method_337d8ee7(this.I_field_261b57cc::I_method_f42361b7);
        this.iI_field_2466f38c.I_method_a8b17cb5().I_method_337d8ee7(this.I_field_261b57cc::I_method_f42361b7);
        this.ii_field_2466f38c.I_method_a8b17cb5().I_method_337d8ee7(this.I_field_261b57cc::I_method_f42361b7);
        this.III_field_2466f38c.I_method_a8b17cb5().I_method_337d8ee7(this.I_field_261b57cc::I_method_f42361b7);
        this.IIi_field_2466f38c.I_method_a8b17cb5().I_method_337d8ee7(this.I_field_261b57cc::I_method_f42361b7);
    }

    @Generated
    public iIIIII_Class33 I_method_20531fb8() {
        return this.I_field_20717641;
    }

    @Generated
    public IiiIiiI_Class55 I_method_c15cbd55() {
        return this.I_field_c50937ec;
    }

    @Generated
    public String I_method_211bb9c1() {
        return this.I_field_523beb0a;
    }

    @Generated
    public KeyPair I_method_8722f7d9() {
        return this.I_field_240b2c30;
    }

    @Generated
    public UUID I_method_171d844b() {
        return this.I_field_7fb73d4;
    }

    @Generated
    public iIiiIII_Class89 I_method_226edd35() {
        return this.I_field_261b57cc;
    }

    @Generated
    public iIiIiII_Class85<IiiiIIi_Class58> I_method_20ba78f5() {
        return this.I_field_2466f38c;
    }

    @Generated
    public iIiIiII_Class85<iiIIIII_Class97> i_method_3adb64d5() {
        return this.i_field_2466f38c;
    }

    @Generated
    public iIiIiII_Class85<iiIIIii_Class100> II_method_cff34db8() {
        return this.II_field_2466f38c;
    }

    @Generated
    public iIiIiII_Class85<iiIIIiI_Class99> Ii_method_ea143998() {
        return this.Ii_field_2466f38c;
    }

    @Generated
    public iIiIiII_Class85<iiIIiII_Class101> iI_method_f9efddd8() {
        return this.iI_field_2466f38c;
    }

    @Generated
    public iIiIiII_Class85<IiIiiiI_Class47> ii_method_1410c9b8() {
        return this.ii_field_2466f38c;
    }

    @Generated
    public iIiIiII_Class85<IiIiiIi_Class46> III_method_7d51155() {
        return this.III_field_2466f38c;
    }

    @Generated
    public iIiIiII_Class85<IiIiiII_Class45> IIi_method_21f5fd35() {
        return this.IIi_field_2466f38c;
    }

    public static class Nested1_e79bbdc0 {
        private final iIIIII_Class33 I_field_20717641;
        private IiiIiiI_Class55 I_field_c50937ec = new IiiIiiI_Class55("00000000402b5328", "service::user.auth.xboxlive.com::MBI_SSL");
        private String I_field_523beb0a = "Win32";
        private KeyPair I_field_240b2c30;
        private UUID I_field_7fb73d4;

        public IiIiIIi_Class42 I_method_9a1c2fa2(iIIIiII_Class69 iIIIiII_Class692) throws IOException, InterruptedException, TimeoutException {
            Iiiiiii_Class64 iiiiiii_Class64 = iIIIiII_Class692.I_method_9b5cde1c(this.I_field_20717641, this.I_field_c50937ec);
            return this.I_method_58c7a7e2(iiiiiii_Class64.I_method_a2a3535());
        }

        public <T> IiIiIIi_Class42 I_method_221cdc5e(iIIIiIi_Class70<T> iIIIiIi_Class702, T t) throws IOException, InterruptedException, TimeoutException {
            Iiiiiii_Class64 iiiiiii_Class64 = iIIIiIi_Class702.I_method_3f97a498(this.I_field_20717641, this.I_field_c50937ec, t);
            return this.I_method_58c7a7e2(iiiiiii_Class64.I_method_a2a3535());
        }

        public IiIiIIi_Class42 I_method_869fe6fa(String string) throws IOException {
            return this.I_method_58c7a7e2((IiiiIIi_Class58)this.I_field_20717641.I_method_fc2df765(new IiiiiIi_Class62(this.I_field_c50937ec, string)));
        }

        public IiIiIIi_Class42 I_method_58c7a7e2(IiiiIIi_Class58 iiiiIIi_Class58) {
            return new IiIiIIi_Class42(this.I_field_20717641, this.I_field_c50937ec, this.I_field_523beb0a, this.I_field_240b2c30 != null ? this.I_field_240b2c30 : iIIiiIi_Class78.I_method_85b96f79(), this.I_field_7fb73d4 != null ? this.I_field_7fb73d4 : UUID.randomUUID(), iiiiIIi_Class58);
        }

        @Generated
        public Nested1_e79bbdc0 I_method_1810fa1d(IiiIiiI_Class55 iiiIiiI_Class55) {
            this.I_field_c50937ec = iiiIiiI_Class55;
            return this;
        }

        @Generated
        public Nested1_e79bbdc0 I_method_5e41c335(String string) {
            this.I_field_523beb0a = string;
            return this;
        }

        @Generated
        public Nested1_e79bbdc0 I_method_b9449121(KeyPair keyPair) {
            this.I_field_240b2c30 = keyPair;
            return this;
        }

        @Generated
        public Nested1_e79bbdc0 I_method_a15a003f(UUID uUID) {
            this.I_field_7fb73d4 = uUID;
            return this;
        }

        @Generated
        private Nested1_e79bbdc0(iIIIII_Class33 iIIIII_Class332) {
            this.I_field_20717641 = iIIIII_Class332;
        }
    }
}

