package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.net.MalformedURLException;
import java.util.Locale;
import rockstar.client.IIIIIii_Class4;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIIiI_Class35;
import rockstar.client.iIIiIII_Class73;
import rockstar.client.iIIiiII_Class77;
import rockstar.client.iIiiIIi_Class90;

public class iIIiIiI_Class75
extends IIIIIii_Class4
implements iIIiiII_Class77<iIIiIII_Class73> {
    public iIIiIiI_Class75(iIIiIII_Class73 iIIiIII_Class732, String string, String string2, String string3) throws MalformedURLException {
        super("https://" + string.toLowerCase(Locale.ROOT) + ".playfabapi.com/Authentication/GetEntityToken");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Id", string2);
        jsonObject.addProperty("Type", string3);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.add("Entity", (JsonElement)jsonObject);
        this.I_method_ef32890a(new iIiiIIi_Class90(jsonObject2));
        this.i_method_33057dd7("X-EntityToken", iIIiIII_Class732.I_method_eac435e1());
    }

    @Override
    public iIIiIII_Class73 I_method_b7becc11(iIIIiI_Class35 iIIIiI_Class352, IiiiIi_Class30 iiiiIi_Class30) {
        return iIIiIII_Class73.i_method_740979b6(iiiiIi_Class30.i_method_83289561("data"));
    }
}

