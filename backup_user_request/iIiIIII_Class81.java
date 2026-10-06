package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;
import java.util.UUID;
import rockstar.client.IiiIiiI_Class55;
import rockstar.client.IiiiII_Class29;
import rockstar.client.IiiiIIi_Class58;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIiiIi_Class78;
import rockstar.client.iIIiiii_Class80;

public class iIiIIII_Class81 {
    public static JsonObject I_method_af39bcd7(JsonObject jsonObject) {
        return iIiIIII_Class81.I_method_999674a7(jsonObject, new IiiIiiI_Class55("00000000402b5328", "service::user.auth.xboxlive.com::MBI_SSL"));
    }

    public static JsonObject I_method_999674a7(JsonObject jsonObject, IiiIiiI_Class55 iiiIiiI_Class55) {
        String string = iIiIIII_Class81.I_method_cfcde8a0(new IiiiIi_Class30(jsonObject));
        if (string == null) {
            throw new IllegalArgumentException("Failed to find refresh token in the provided save data");
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("_saveVersion", (Number)1);
        jsonObject2.add("msaApplicationConfig", (JsonElement)IiiIiiI_Class55.I_method_24a67fbb(iiiIiiI_Class55));
        jsonObject2.addProperty("deviceType", "Win32");
        jsonObject2.add("deviceKeyPair", (JsonElement)iIIiiii_Class80.I_method_5397a57(iIIiiIi_Class78.I_method_85b96f79()));
        jsonObject2.addProperty("deviceId", UUID.randomUUID().toString());
        jsonObject2.add("msaToken", (JsonElement)IiiiIIi_Class58.I_method_b9dc7fbb(new IiiiIIi_Class58(0L, "", string)));
        return jsonObject2;
    }

    public static JsonObject i_method_c5f354f7(JsonObject jsonObject) {
        return iIiIIII_Class81.i_method_99824087(jsonObject, new IiiIiiI_Class55("0000000048183522", "service::user.auth.xboxlive.com::MBI_SSL"));
    }

    public static JsonObject i_method_99824087(JsonObject jsonObject, IiiIiiI_Class55 iiiIiiI_Class55) {
        String string = iIiIIII_Class81.I_method_cfcde8a0(new IiiiIi_Class30(jsonObject));
        if (string == null) {
            throw new IllegalArgumentException("Failed to find refresh token in the provided save data");
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("_saveVersion", (Number)1);
        jsonObject2.add("msaApplicationConfig", (JsonElement)IiiIiiI_Class55.I_method_24a67fbb(iiiIiiI_Class55));
        jsonObject2.addProperty("deviceType", "Android");
        jsonObject2.add("deviceKeyPair", (JsonElement)iIIiiii_Class80.I_method_5397a57(iIIiiIi_Class78.I_method_85b96f79()));
        jsonObject2.addProperty("deviceId", UUID.randomUUID().toString());
        jsonObject2.add("sessionKeyPair", (JsonElement)iIIiiii_Class80.I_method_5397a57(iIIiiIi_Class78.i_method_c0e3d359()));
        jsonObject2.add("msaToken", (JsonElement)IiiiIIi_Class58.I_method_b9dc7fbb(new IiiiIIi_Class58(0L, "", string)));
        return jsonObject2;
    }

    public static String I_method_cfcde8a0(IiiiIi_Class30 iiiiIi_Class30) {
        if (iiiiIi_Class30.III_method_15e7b21a("refreshToken")) {
            return iiiiIi_Class30.i_method_7caa7e8a("refreshToken");
        }
        for (Map.Entry<String, IiiiII_Class29> entry : iiiiIi_Class30.i_method_694514fb()) {
            String string;
            if (!entry.getValue().i_method_f510aa30() || (string = iIiIIII_Class81.I_method_cfcde8a0(entry.getValue().I_method_9b832f2b())) == null) continue;
            return string;
        }
        return null;
    }
}

