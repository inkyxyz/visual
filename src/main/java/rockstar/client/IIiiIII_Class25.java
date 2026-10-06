package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Instant;
import java.util.UUID;
import rockstar.client.IIIIIii_Class4;
import rockstar.client.IIiIiIi_Class22;
import rockstar.client.IIiiIiI_Class27;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIIiI_Class35;
import rockstar.client.iIIiIIi_Class74;
import rockstar.client.iIiIIii_Class84;
import rockstar.client.iIiiIIi_Class90;
import rockstar.client.iiIIiII_Class101;

public class IIiiIII_Class25
extends IIIIIii_Class4
implements IIiiIiI_Class27<IIiIiIi_Class22> {
    @Deprecated
    public IIiiIII_Class25(iiIIiII_Class101 iiIIiII_Class1012, iIIiIIi_Class74 iIIiIIi_Class742, String string, UUID uUID) throws MalformedURLException {
        this(iIIiIIi_Class742, string, uUID);
    }

    public IIiiIII_Class25(iIIiIIi_Class74 iIIiIIi_Class742, String string, UUID uUID) throws MalformedURLException {
        super("https://authorization.franchise.minecraft-services.net/api/v1.0/session/start");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("applicationType", "MinecraftPE");
        jsonObject.addProperty("gameVersion", string);
        jsonObject.addProperty("id", iIiIIii_Class84.I_method_380805cd(uUID));
        jsonObject.addProperty("memory", (Number)0x800000000L);
        jsonObject.addProperty("hardwareMemoryTier", (Number)5);
        jsonObject.addProperty("platform", "Windows10");
        jsonObject.addProperty("playFabTitleId", "20CA2");
        jsonObject.addProperty("storePlatform", "uwp.store");
        jsonObject.addProperty("type", "Windows10");
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("language", "en");
        jsonObject2.addProperty("regionCode", "US");
        jsonObject2.addProperty("languageCode", "en-US");
        jsonObject2.addProperty("tokenType", "PlayFab");
        jsonObject2.addProperty("token", iIIiIIi_Class742.II_method_f34e4e1e());
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.add("device", (JsonElement)jsonObject);
        jsonObject3.add("user", (JsonElement)jsonObject2);
        this.I_method_ef32890a(new iIiiIIi_Class90(jsonObject3));
    }

    @Override
    public IIiIiIi_Class22 I_method_b7becc11(iIIIiI_Class35 iIIIiI_Class352, IiiiIi_Class30 iiiiIi_Class30) throws IOException {
        IiiiIi_Class30 iiiiIi_Class302 = iiiiIi_Class30.i_method_83289561("result");
        return new IIiIiIi_Class22(Instant.parse(iiiiIi_Class302.i_method_7caa7e8a("validUntil")).toEpochMilli(), iiiiIi_Class302.i_method_7caa7e8a("authorizationHeader"));
    }
}

