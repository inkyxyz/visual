package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Locale;
import rockstar.client.IIIIIii_Class4;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIIiI_Class35;
import rockstar.client.iIIiIII_Class73;
import rockstar.client.iIIiIIi_Class74;
import rockstar.client.iIIiiII_Class77;
import rockstar.client.iIiiIIi_Class90;
import rockstar.client.iiIIiII_Class101;

public class iIIiIii_Class76
extends IIIIIii_Class4
implements iIIiiII_Class77<iIIiIIi_Class74> {
    public iIIiIii_Class76(iiIIiII_Class101 iiIIiII_Class1012, String string) throws MalformedURLException {
        super("https://" + string.toLowerCase(Locale.ROOT) + ".playfabapi.com/Client/LoginWithXbox");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("GetPlayerProfile", Boolean.valueOf(true));
        jsonObject.addProperty("GetUserAccountInfo", Boolean.valueOf(true));
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("CreateAccount", Boolean.valueOf(true));
        jsonObject2.add("InfoRequestParameters", (JsonElement)jsonObject);
        jsonObject2.addProperty("TitleId", string.toUpperCase(Locale.ROOT));
        jsonObject2.addProperty("XboxToken", iiIIiII_Class1012.I_method_4fc45e01());
        this.I_method_ef32890a(new iIiiIIi_Class90(jsonObject2));
    }

    @Override
    public iIIiIIi_Class74 I_method_b7becc11(iIIIiI_Class35 iIIIiI_Class352, IiiiIi_Class30 iiiiIi_Class30) throws IOException {
        IiiiIi_Class30 iiiiIi_Class302 = iiiiIi_Class30.i_method_83289561("data");
        return new iIIiIIi_Class74(iIIiIII_Class73.i_method_740979b6(iiiiIi_Class302.i_method_83289561("EntityToken")), iiiiIi_Class302.i_method_7caa7e8a("PlayFabId"), iiiiIi_Class302.i_method_7caa7e8a("SessionTicket"));
    }
}

