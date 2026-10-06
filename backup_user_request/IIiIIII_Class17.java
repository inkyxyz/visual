package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.security.KeyPair;
import java.util.UUID;
import java.util.concurrent.TimeoutException;
import lombok.Generated;
import rockstar.client.IIiIIii_Class20;
import rockstar.client.IIiIiII_Class21;
import rockstar.client.IIiIiIi_Class22;
import rockstar.client.IIiIiiI_Class23;
import rockstar.client.IIiIiii_Class24;
import rockstar.client.IIiiIII_Class25;
import rockstar.client.IiiIiiI_Class55;
import rockstar.client.IiiiIIi_Class58;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.IiiiiIi_Class62;
import rockstar.client.Iiiiiii_Class64;
import rockstar.client.iIIIII_Class33;
import rockstar.client.iIIIiII_Class69;
import rockstar.client.iIIIiIi_Class70;
import rockstar.client.iIIiIII_Class73;
import rockstar.client.iIIiIIi_Class74;
import rockstar.client.iIIiIiI_Class75;
import rockstar.client.iIIiIii_Class76;
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

public class IIiIIII_Class17 {
    private final iIIIII_Class33 I_field_20717641;
    private final String I_field_523beb0a;
    private final IiiIiiI_Class55 I_field_c50937ec;
    private final String i_field_523beb0a;
    private final KeyPair I_field_240b2c30;
    private final UUID I_field_7fb73d4;
    private final KeyPair i_field_240b2c30;
    private final iIiiIII_Class89 I_field_261b57cc = new iIiiIII_Class89();
    private final Object I_field_5f790d9c = new Object();
    private final iIiIiII_Class85<IiiiIIi_Class58> I_field_2466f38c = new iIiIiII_Class85<IiiiIIi_Class58>(this::I_method_bb644515);
    private final iIiIiII_Class85<iiIIIII_Class97> i_field_2466f38c = new iIiIiII_Class85<iiIIIII_Class97>(this::I_method_7f2bd915);
    private final iIiIiII_Class85<iiIIIii_Class100> II_field_2466f38c = new iIiIiII_Class85<iiIIIii_Class100>(this::I_method_7f2c5515, this.I_field_5f790d9c);
    private final iIiIiII_Class85<iiIIIiI_Class99> Ii_field_2466f38c = new iIiIiII_Class85<iiIIIiI_Class99>(this::I_method_7f2c5135, this.I_field_5f790d9c);
    private final iIiIiII_Class85<iiIIiII_Class101> iI_field_2466f38c = new iIiIiII_Class85<iiIIiII_Class101>(this::I_method_7f3a64f5, this.I_field_5f790d9c);
    private final iIiIiII_Class85<iiIIiII_Class101> ii_field_2466f38c = new iIiIiII_Class85<iiIIiII_Class101>(this::i_method_995b50d5);
    private final iIiIiII_Class85<iiIIiII_Class101> III_field_2466f38c = new iIiIiII_Class85<iiIIiII_Class101>(this::II_method_483f0238);
    private final iIiIiII_Class85<iiIIiII_Class101> IIi_field_2466f38c = new iIiIiII_Class85<iiIIiII_Class101>(this::Ii_method_625fee18);
    private final iIiIiII_Class85<iIIiIIi_Class74> IiI_field_2466f38c = new iIiIiII_Class85<iIIiIIi_Class74>(this::I_method_e42764f5);
    private final iIiIiII_Class85<iIIiIII_Class73> Iii_field_2466f38c = new iIiIiII_Class85<iIIiIII_Class73>(this::I_method_e4276115);
    private final iIiIiII_Class85<IIiIiIi_Class22> iII_field_2466f38c = new iIiIiII_Class85<IIiIiIi_Class22>(this::I_method_1ce878b5);
    private final iIiIiII_Class85<IIiIiII_Class21> iIi_field_2466f38c = new iIiIiII_Class85<IIiIiII_Class21>(this::I_method_1ce874d5);
    private final iIiIiII_Class85<IIiIIii_Class20> iiI_field_2466f38c = new iIiIiII_Class85<IIiIIii_Class20>(this::I_method_1cda64f5);

    public static IIiIIII_Class17 I_method_7a94f66c(iIIIII_Class33 iIIIII_Class332, String string, JsonObject jsonObject) {
        return IIiIIII_Class17.I_method_46222961(iIIIII_Class332, string, new IiiiIi_Class30(jsonObject));
    }

    public static IIiIIII_Class17 I_method_46222961(iIIIII_Class33 iIIIII_Class332, String string, IiiiIi_Class30 iiiiIi_Class30) {
        return new IIiIIII_Class17(iIIIII_Class332, string, IiiIiiI_Class55.I_method_213615d6(iiiiIi_Class30.i_method_83289561("msaApplicationConfig")), iiiiIi_Class30.i_method_7caa7e8a("deviceType"), iIIiiii_Class80.I_method_dcbfd87a(iiiiIi_Class30.i_method_83289561("deviceKeyPair")), UUID.fromString(iiiiIi_Class30.i_method_7caa7e8a("deviceId")), iIIiiii_Class80.I_method_dcbfd87a(iiiiIi_Class30.i_method_83289561("sessionKeyPair")), IiiiIIi_Class58.I_method_c785f5d6(iiiiIi_Class30.i_method_83289561("msaToken")), iiiiIi_Class30.i_method_dbd1c22f("xblDeviceToken").map(iiIIIII_Class97::I_method_b8331dd6).orElse(null), iiiiIi_Class30.i_method_dbd1c22f("xblUserToken").map(iiIIIii_Class100::I_method_262e15d6).orElse(null), iiiiIi_Class30.i_method_dbd1c22f("xblTitleToken").map(iiIIIiI_Class99::I_method_e2be3e16).orElse(null), iiiiIi_Class30.i_method_dbd1c22f("bedrockXstsToken").map(iiIIiII_Class101::I_method_df0c0596).orElse(null), iiiiIi_Class30.i_method_dbd1c22f("playFabXstsToken").map(iiIIiII_Class101::I_method_df0c0596).orElse(null), iiiiIi_Class30.i_method_dbd1c22f("realmsXstsToken").map(iiIIiII_Class101::I_method_df0c0596).orElse(null), iiiiIi_Class30.i_method_dbd1c22f("xboxLiveXstsToken").map(iiIIiII_Class101::I_method_df0c0596).orElse(null), iiiiIi_Class30.i_method_dbd1c22f("playFabToken").map(iIIiIIi_Class74::I_method_fc660596).orElse(null), iiiiIi_Class30.i_method_dbd1c22f("playFabMasterToken").map(iIIiIII_Class73::I_method_b8f62dd6).orElse(null), iiiiIi_Class30.i_method_dbd1c22f("minecraftSession").map(IIiIiIi_Class22::I_method_8699cd16).orElse(null), iiiiIi_Class30.i_method_dbd1c22f("minecraftMultiplayerToken").map(IIiIiII_Class21::I_method_4329f556).orElse(null), iiiiIi_Class30.i_method_dbd1c22f("minecraftCertificateChain").map(IIiIIii_Class20::I_method_8a4c0596).orElse(null));
    }

    public static JsonObject I_method_929c6bbb(IIiIIII_Class17 iIiIIII_Class17) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", (Number)1);
        jsonObject.add("msaApplicationConfig", (JsonElement)IiiIiiI_Class55.I_method_24a67fbb(iIiIIII_Class17.I_field_c50937ec));
        jsonObject.addProperty("deviceType", iIiIIII_Class17.i_field_523beb0a);
        jsonObject.add("deviceKeyPair", (JsonElement)iIIiiii_Class80.I_method_5397a57(iIiIIII_Class17.I_field_240b2c30));
        jsonObject.addProperty("deviceId", iIiIIII_Class17.I_field_7fb73d4.toString());
        jsonObject.add("sessionKeyPair", (JsonElement)iIIiiii_Class80.I_method_5397a57(iIiIIII_Class17.i_field_240b2c30));
        jsonObject.add("msaToken", (JsonElement)IiiiIIi_Class58.I_method_b9dc7fbb(iIiIIII_Class17.I_field_2466f38c.I_method_72256cd5()));
        if (iIiIIII_Class17.i_field_2466f38c.I_method_a51d1043()) {
            jsonObject.add("xblDeviceToken", (JsonElement)iiIIIII_Class97.I_method_6aa8ffbb(iIiIIII_Class17.i_field_2466f38c.I_method_72256cd5()));
        }
        if (iIiIIII_Class17.II_field_2466f38c.I_method_a51d1043()) {
            jsonObject.add("xblUserToken", (JsonElement)iiIIIii_Class100.I_method_c2267fbb(iIiIIII_Class17.II_field_2466f38c.I_method_72256cd5()));
        }
        if (iIiIIII_Class17.Ii_field_2466f38c.I_method_a51d1043()) {
            jsonObject.add("xblTitleToken", (JsonElement)iiIIIiI_Class99.I_method_876a93bb(iIiIIII_Class17.Ii_field_2466f38c.I_method_72256cd5()));
        }
        if (iIiIIII_Class17.iI_field_2466f38c.I_method_a51d1043()) {
            jsonObject.add("bedrockXstsToken", (JsonElement)iiIIiII_Class101.I_method_e619ebbb(iIiIIII_Class17.iI_field_2466f38c.I_method_72256cd5()));
        }
        if (iIiIIII_Class17.ii_field_2466f38c.I_method_a51d1043()) {
            jsonObject.add("playFabXstsToken", (JsonElement)iiIIiII_Class101.I_method_e619ebbb(iIiIIII_Class17.ii_field_2466f38c.I_method_72256cd5()));
        }
        if (iIiIIII_Class17.III_field_2466f38c.I_method_a51d1043()) {
            jsonObject.add("realmsXstsToken", (JsonElement)iiIIiII_Class101.I_method_e619ebbb(iIiIIII_Class17.III_field_2466f38c.I_method_72256cd5()));
        }
        if (iIiIIII_Class17.IIi_field_2466f38c.I_method_a51d1043()) {
            jsonObject.add("xboxLiveXstsToken", (JsonElement)iiIIiII_Class101.I_method_e619ebbb(iIiIIII_Class17.IIi_field_2466f38c.I_method_72256cd5()));
        }
        if (iIiIIII_Class17.IiI_field_2466f38c.I_method_a51d1043()) {
            jsonObject.add("playFabToken", (JsonElement)iIIiIIi_Class74.I_method_9e39ebbb(iIiIIII_Class17.IiI_field_2466f38c.I_method_72256cd5()));
        }
        if (iIiIIII_Class17.Iii_field_2466f38c.I_method_a51d1043()) {
            jsonObject.add("playFabMasterToken", (JsonElement)iIIiIII_Class73.I_method_637dffbb(iIiIIII_Class17.Iii_field_2466f38c.I_method_72256cd5()));
        }
        if (iIiIIII_Class17.iII_field_2466f38c.I_method_a51d1043()) {
            jsonObject.add("minecraftSession", (JsonElement)IIiIiIi_Class22.I_method_48c943bb(iIiIIII_Class17.iII_field_2466f38c.I_method_72256cd5()));
        }
        if (iIiIIII_Class17.iIi_field_2466f38c.I_method_a51d1043()) {
            jsonObject.add("minecraftMultiplayerToken", (JsonElement)IIiIiII_Class21.I_method_e0d57bb(iIiIIII_Class17.iIi_field_2466f38c.I_method_72256cd5()));
        }
        if (iIiIIII_Class17.iiI_field_2466f38c.I_method_a51d1043()) {
            jsonObject.add("minecraftCertificateChain", (JsonElement)IIiIIii_Class20.I_method_ea19ebbb(iIiIIII_Class17.iiI_field_2466f38c.I_method_72256cd5()));
        }
        return jsonObject;
    }

    public static Nested1_51a1fe00 I_method_401b387b(iIIIII_Class33 iIIIII_Class332, String string) {
        return new Nested1_51a1fe00(iIIIII_Class332, string);
    }

    private IIiIIII_Class17(iIIIII_Class33 iIIIII_Class332, String string, IiiIiiI_Class55 iiiIiiI_Class55, String string2, KeyPair keyPair, UUID uUID, KeyPair keyPair2, IiiiIIi_Class58 iiiiIIi_Class58) {
        this.I_field_20717641 = iIIIII_Class332;
        this.I_field_523beb0a = string;
        this.I_field_c50937ec = iiiIiiI_Class55;
        this.i_field_523beb0a = string2;
        this.I_field_240b2c30 = keyPair;
        this.I_field_7fb73d4 = uUID;
        this.i_field_240b2c30 = keyPair2;
        this.I_field_2466f38c.I_method_eb0fcb87(iiiiIIi_Class58);
        this.i_method_b2d1545f();
    }

    private IIiIIII_Class17(iIIIII_Class33 iIIIII_Class332, String string, IiiIiiI_Class55 iiiIiiI_Class55, String string2, KeyPair keyPair, UUID uUID, KeyPair keyPair2, IiiiIIi_Class58 iiiiIIi_Class58, iiIIIII_Class97 iiIIIII_Class972, iiIIIii_Class100 iiIIIii_Class1002, iiIIIiI_Class99 iiIIIiI_Class992, iiIIiII_Class101 iiIIiII_Class1012, iiIIiII_Class101 iiIIiII_Class1013, iiIIiII_Class101 iiIIiII_Class1014, iiIIiII_Class101 iiIIiII_Class1015, iIIiIIi_Class74 iIIiIIi_Class742, iIIiIII_Class73 iIIiIII_Class732, IIiIiIi_Class22 iIiIiRockstarClient2, IIiIiII_Class21 iIiIiII_Class21, IIiIIii_Class20 iIiIIii_Class20) {
        this.I_field_20717641 = iIIIII_Class332;
        this.I_field_523beb0a = string;
        this.I_field_c50937ec = iiiIiiI_Class55;
        this.i_field_523beb0a = string2;
        this.I_field_240b2c30 = keyPair;
        this.I_field_7fb73d4 = uUID;
        this.i_field_240b2c30 = keyPair2;
        this.I_field_2466f38c.I_method_eb0fcb87(iiiiIIi_Class58);
        this.i_field_2466f38c.I_method_eb0fcb87(iiIIIII_Class972);
        this.II_field_2466f38c.I_method_eb0fcb87(iiIIIii_Class1002);
        this.Ii_field_2466f38c.I_method_eb0fcb87(iiIIIiI_Class992);
        this.iI_field_2466f38c.I_method_eb0fcb87(iiIIiII_Class1012);
        this.ii_field_2466f38c.I_method_eb0fcb87(iiIIiII_Class1013);
        this.III_field_2466f38c.I_method_eb0fcb87(iiIIiII_Class1014);
        this.IIi_field_2466f38c.I_method_eb0fcb87(iiIIiII_Class1015);
        this.IiI_field_2466f38c.I_method_eb0fcb87(iIIiIIi_Class742);
        this.Iii_field_2466f38c.I_method_eb0fcb87(iIIiIII_Class732);
        this.iII_field_2466f38c.I_method_eb0fcb87(iIiIiRockstarClient2);
        this.iIi_field_2466f38c.I_method_eb0fcb87(iIiIiII_Class21);
        this.iiI_field_2466f38c.I_method_eb0fcb87(iIiIIii_Class20);
        this.i_method_b2d1545f();
    }

    private IiiiIIi_Class58 I_method_bb644515() throws IOException {
        if (this.I_field_2466f38c.I_method_72256cd5().i_method_de5c8201() == null) {
            throw new IllegalStateException("Can't refresh MSA token, because it was created without a refresh token. The user has to sign in again.");
        }
        return (IiiiIIi_Class58)this.I_field_20717641.I_method_fc2df765(new IiiiiIi_Class62(this.I_field_c50937ec, this.I_field_2466f38c.I_method_72256cd5()));
    }

    private iiIIIII_Class97 I_method_7f2bd915() throws IOException {
        return (iiIIIII_Class97)this.I_field_20717641.I_method_fc2df765(new iiIIiiI_Class103(this.i_field_523beb0a, this.I_field_7fb73d4, this.I_field_240b2c30));
    }

    private iiIIIii_Class100 I_method_7f2c5515() throws IOException {
        if (this.I_field_c50937ec.I_method_e84624a3()) {
            this.I_method_b2c2c87f();
            return this.II_field_2466f38c.I_method_72256cd5();
        }
        return (iiIIIii_Class100)this.I_field_20717641.I_method_fc2df765(new iiIiIII_Class105(this.I_field_c50937ec, this.I_field_2466f38c.i_method_8c4658b5()));
    }

    private iiIIIiI_Class99 I_method_7f2c5135() throws IOException {
        if (!this.I_field_c50937ec.I_method_e84624a3()) {
            throw new UnsupportedOperationException("Can't refresh XBL title token, because the MSA application client ID is not a title client ID");
        }
        this.I_method_b2c2c87f();
        return this.Ii_field_2466f38c.I_method_72256cd5();
    }

    private iiIIiII_Class101 I_method_7f3a64f5() throws IOException {
        if (this.I_field_c50937ec.I_method_e84624a3()) {
            this.I_method_b2c2c87f();
            return this.iI_field_2466f38c.I_method_72256cd5();
        }
        return (iiIIiII_Class101)this.I_field_20717641.I_method_fc2df765(new iiIiIIi_Class106(this.i_field_2466f38c.i_method_8c4658b5(), this.II_field_2466f38c.i_method_8c4658b5(), null, "https://multiplayer.minecraft.net/"));
    }

    private iiIIiII_Class101 i_method_995b50d5() throws IOException {
        iiIIIiI_Class99 iiIIIiI_Class992 = this.I_field_c50937ec.I_method_e84624a3() ? this.Ii_field_2466f38c.i_method_8c4658b5() : null;
        return (iiIIiII_Class101)this.I_field_20717641.I_method_fc2df765(new iiIiIIi_Class106(this.i_field_2466f38c.i_method_8c4658b5(), this.II_field_2466f38c.i_method_8c4658b5(), iiIIIiI_Class992, "https://b980a380.minecraft.playfabapi.com/"));
    }

    private iiIIiII_Class101 II_method_483f0238() throws IOException {
        iiIIIiI_Class99 iiIIIiI_Class992 = this.I_field_c50937ec.I_method_e84624a3() ? this.Ii_field_2466f38c.i_method_8c4658b5() : null;
        return (iiIIiII_Class101)this.I_field_20717641.I_method_fc2df765(new iiIiIIi_Class106(this.i_field_2466f38c.i_method_8c4658b5(), this.II_field_2466f38c.i_method_8c4658b5(), iiIIIiI_Class992, "https://pocket.realms.minecraft.net/"));
    }

    private iiIIiII_Class101 Ii_method_625fee18() throws IOException {
        iiIIIiI_Class99 iiIIIiI_Class992 = this.I_field_c50937ec.I_method_e84624a3() ? this.Ii_field_2466f38c.i_method_8c4658b5() : null;
        return (iiIIiII_Class101)this.I_field_20717641.I_method_fc2df765(new iiIiIIi_Class106(this.i_field_2466f38c.i_method_8c4658b5(), this.II_field_2466f38c.i_method_8c4658b5(), iiIIIiI_Class992, "http://xboxlive.com"));
    }

    private iIIiIIi_Class74 I_method_e42764f5() throws IOException {
        return (iIIiIIi_Class74)this.I_field_20717641.I_method_fc2df765(new iIIiIii_Class76(this.ii_field_2466f38c.i_method_8c4658b5(), "20CA2"));
    }

    private iIIiIII_Class73 I_method_e4276115() throws IOException {
        iIIiIIi_Class74 iIIiIIi_Class742 = this.IiI_field_2466f38c.i_method_8c4658b5();
        return (iIIiIII_Class73)this.I_field_20717641.I_method_fc2df765(new iIIiIiI_Class75(iIIiIIi_Class742.I_method_98a2dd15(), "20CA2", iIIiIIi_Class742.i_method_c4160e21(), "master_player_account"));
    }

    private IIiIiIi_Class22 I_method_1ce878b5() throws IOException {
        return (IIiIiIi_Class22)this.I_field_20717641.I_method_fc2df765(new IIiiIII_Class25(this.IiI_field_2466f38c.i_method_8c4658b5(), this.I_field_523beb0a, this.I_field_7fb73d4));
    }

    private IIiIiII_Class21 I_method_1ce874d5() throws IOException {
        return (IIiIiII_Class21)this.I_field_20717641.I_method_fc2df765(new IIiIiii_Class24(this.iII_field_2466f38c.i_method_8c4658b5(), this.i_field_240b2c30));
    }

    private IIiIIii_Class20 I_method_1cda64f5() throws IOException {
        return (IIiIIii_Class20)this.I_field_20717641.I_method_fc2df765(new IIiIiiI_Class23(this.iI_field_2466f38c.i_method_8c4658b5(), this.i_field_240b2c30));
    }

    private void I_method_b2c2c87f() throws IOException {
        iiIIIIi_Class98 iiIIIIi_Class982 = (iiIIIIi_Class98)this.I_field_20717641.I_method_fc2df765(new iiIIiii_Class104(this.I_field_c50937ec, this.I_field_2466f38c.i_method_8c4658b5(), this.i_field_2466f38c.i_method_8c4658b5(), this.I_field_240b2c30, "https://multiplayer.minecraft.net/"));
        this.II_field_2466f38c.I_method_eb0fcb87(iiIIIIi_Class982.I_method_53c84915());
        this.Ii_field_2466f38c.I_method_eb0fcb87(iiIIIIi_Class982.I_method_53c84535());
        this.iI_field_2466f38c.I_method_eb0fcb87(iiIIIIi_Class982.I_method_53d658f5());
    }

    private void i_method_b2d1545f() {
        this.I_field_2466f38c.I_method_a8b17cb5().I_method_337d8ee7(this.I_field_261b57cc::I_method_f42361b7);
        this.i_field_2466f38c.I_method_a8b17cb5().I_method_337d8ee7(this.I_field_261b57cc::I_method_f42361b7);
        this.II_field_2466f38c.I_method_a8b17cb5().I_method_337d8ee7(this.I_field_261b57cc::I_method_f42361b7);
        this.Ii_field_2466f38c.I_method_a8b17cb5().I_method_337d8ee7(this.I_field_261b57cc::I_method_f42361b7);
        this.iI_field_2466f38c.I_method_a8b17cb5().I_method_337d8ee7(this.I_field_261b57cc::I_method_f42361b7);
        this.ii_field_2466f38c.I_method_a8b17cb5().I_method_337d8ee7(this.I_field_261b57cc::I_method_f42361b7);
        this.III_field_2466f38c.I_method_a8b17cb5().I_method_337d8ee7(this.I_field_261b57cc::I_method_f42361b7);
        this.IIi_field_2466f38c.I_method_a8b17cb5().I_method_337d8ee7(this.I_field_261b57cc::I_method_f42361b7);
        this.IiI_field_2466f38c.I_method_a8b17cb5().I_method_337d8ee7(this.I_field_261b57cc::I_method_f42361b7);
        this.Iii_field_2466f38c.I_method_a8b17cb5().I_method_337d8ee7(this.I_field_261b57cc::I_method_f42361b7);
        this.iII_field_2466f38c.I_method_a8b17cb5().I_method_337d8ee7(this.I_field_261b57cc::I_method_f42361b7);
        this.iIi_field_2466f38c.I_method_a8b17cb5().I_method_337d8ee7(this.I_field_261b57cc::I_method_f42361b7);
        this.iiI_field_2466f38c.I_method_a8b17cb5().I_method_337d8ee7(this.I_field_261b57cc::I_method_f42361b7);
    }

    @Generated
    public iIIIII_Class33 I_method_74d8ff8() {
        return this.I_field_20717641;
    }

    @Generated
    public String I_method_afbf5a01() {
        return this.I_field_523beb0a;
    }

    @Generated
    public IiiIiiI_Class55 I_method_b9b05515() {
        return this.I_field_c50937ec;
    }

    @Generated
    public String i_method_42de0a21() {
        return this.i_field_523beb0a;
    }

    @Generated
    public KeyPair I_method_1af97f99() {
        return this.I_field_240b2c30;
    }

    @Generated
    public UUID I_method_4eac348b() {
        return this.I_field_7fb73d4;
    }

    @Generated
    public KeyPair i_method_5623e379() {
        return this.i_field_240b2c30;
    }

    @Generated
    public iIiiIII_Class89 I_method_1ac274f5() {
        return this.I_field_261b57cc;
    }

    @Generated
    public iIiIiII_Class85<IiiiIIi_Class58> I_method_190e10b5() {
        return this.I_field_2466f38c;
    }

    @Generated
    public iIiIiII_Class85<iiIIIII_Class97> i_method_332efc95() {
        return this.i_field_2466f38c;
    }

    @Generated
    public iIiIiII_Class85<iiIIIii_Class100> II_method_e212adf8() {
        return this.II_field_2466f38c;
    }

    @Generated
    public iIiIiII_Class85<iiIIIiI_Class99> Ii_method_fc3399d8() {
        return this.Ii_field_2466f38c;
    }

    @Generated
    public iIiIiII_Class85<iiIIiII_Class101> iI_method_c0f3e18() {
        return this.iI_field_2466f38c;
    }

    @Generated
    public iIiIiII_Class85<iiIIiII_Class101> ii_method_263029f8() {
        return this.ii_field_2466f38c;
    }

    @Generated
    public iIiIiII_Class85<iiIIiII_Class101> III_method_39a1b915() {
        return this.III_field_2466f38c;
    }

    @Generated
    public iIiIiII_Class85<iiIIiII_Class101> IIi_method_53c2a4f5() {
        return this.IIi_field_2466f38c;
    }

    @Generated
    public iIiIiII_Class85<iIIiIIi_Class74> IiI_method_639e4935() {
        return this.IiI_field_2466f38c;
    }

    @Generated
    public iIiIiII_Class85<iIIiIII_Class73> Iii_method_7dbf3515() {
        return this.Iii_field_2466f38c;
    }

    @Generated
    public iIiIiII_Class85<IIiIiIi_Class22> iII_method_4f372cf5() {
        return this.iII_field_2466f38c;
    }

    @Generated
    public iIiIiII_Class85<IIiIiII_Class21> iIi_method_695818d5() {
        return this.iIi_field_2466f38c;
    }

    @Generated
    public iIiIiII_Class85<IIiIIii_Class20> iiI_method_7933bd15() {
        return this.iiI_field_2466f38c;
    }

    public static class Nested1_51a1fe00 {
        private final iIIIII_Class33 I_field_20717641;
        private final String I_field_523beb0a;
        private IiiIiiI_Class55 I_field_c50937ec = new IiiIiiI_Class55("0000000048183522", "service::user.auth.xboxlive.com::MBI_SSL");
        private String i_field_523beb0a = "Android";
        private KeyPair I_field_240b2c30;
        private UUID I_field_7fb73d4;
        private KeyPair i_field_240b2c30;

        public IIiIIII_Class17 I_method_861877a2(iIIIiII_Class69 iIIIiII_Class692) throws IOException, InterruptedException, TimeoutException {
            Iiiiiii_Class64 iiiiiii_Class64 = iIIIiII_Class692.I_method_9b5cde1c(this.I_field_20717641, this.I_field_c50937ec);
            return this.I_method_44c3efe2(iiiiiii_Class64.I_method_a2a3535());
        }

        public <T> IIiIIII_Class17 I_method_4aed945e(iIIIiIi_Class70<T> iIIIiIi_Class702, T t) throws IOException, InterruptedException, TimeoutException {
            Iiiiiii_Class64 iiiiiii_Class64 = iIIIiIi_Class702.I_method_3f97a498(this.I_field_20717641, this.I_field_c50937ec, t);
            return this.I_method_44c3efe2(iiiiiii_Class64.I_method_a2a3535());
        }

        public IIiIIII_Class17 I_method_5b0ad67a(String string) throws IOException {
            return this.I_method_44c3efe2((IiiiIIi_Class58)this.I_field_20717641.I_method_fc2df765(new IiiiiIi_Class62(this.I_field_c50937ec, string)));
        }

        public IIiIIII_Class17 I_method_44c3efe2(IiiiIIi_Class58 iiiiIIi_Class58) {
            return new IIiIIII_Class17(this.I_field_20717641, this.I_field_523beb0a, this.I_field_c50937ec, this.i_field_523beb0a, this.I_field_240b2c30 != null ? this.I_field_240b2c30 : iIIiiIi_Class78.I_method_85b96f79(), this.I_field_7fb73d4 != null ? this.I_field_7fb73d4 : UUID.randomUUID(), this.i_field_240b2c30 != null ? this.i_field_240b2c30 : iIIiiIi_Class78.i_method_c0e3d359(), iiiiIIi_Class58);
        }

        @Generated
        public Nested1_51a1fe00 I_method_f61b421d(IiiIiiI_Class55 iiiIiiI_Class55) {
            this.I_field_c50937ec = iiiIiiI_Class55;
            return this;
        }

        @Generated
        public Nested1_51a1fe00 I_method_c3aed2b5(String string) {
            this.i_field_523beb0a = string;
            return this;
        }

        @Generated
        public Nested1_51a1fe00 I_method_e3f1e921(KeyPair keyPair) {
            this.I_field_240b2c30 = keyPair;
            return this;
        }

        @Generated
        public Nested1_51a1fe00 I_method_b475ffbf(UUID uUID) {
            this.I_field_7fb73d4 = uUID;
            return this;
        }

        @Generated
        public Nested1_51a1fe00 i_method_8b481941(KeyPair keyPair) {
            this.i_field_240b2c30 = keyPair;
            return this;
        }

        @Generated
        private Nested1_51a1fe00(iIIIII_Class33 iIIIII_Class332, String string) {
            this.I_field_20717641 = iIIIII_Class332;
            this.I_field_523beb0a = string;
        }
    }
}

