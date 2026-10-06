package rockstar.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.MenuModule;
import rockstar.client.IIiiIIiiI_Class103;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.Setting;
import rockstar.client.KeybindSetting;
import rockstar.client.BooleanSetting;
import rockstar.client.ButtonSetting;
import rockstar.client.ColorSetting;
import rockstar.client.ModeSetting;
import rockstar.client.IIiiiiiI_Class63;
import rockstar.client.RangeSetting;
import rockstar.client.MultiSelectSetting;
import rockstar.client.SliderSetting;
import rockstar.client.TextSetting;
import rockstar.client.IiIIiIII_Class73;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiIiIiII_Class85;
import rockstar.client.IiIiiIII_Class89;
import rockstar.client.IiIiiIIi_Class90;
import rockstar.client.ModuleEntry;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIIIIi_Class258;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iiIIIIIi_Class194;
import rockstar.client.iiIIIiii_Class200;
import rockstar.client.iiIIiIII_Class201;

public final class IiIiIiIi_Class86 {
    private IiIiIiIi_Class86() {
    }

    public static ModuleEntry I_method_b99c08a1(String string) {
        if (string == null || string.isBlank()) {
            throw new IiIiiIII_Class89.Nested1_426908f3("\u043d\u0435 \u0443\u043a\u0430\u0437\u0430\u043d \u043c\u043e\u0434\u0443\u043b\u044c");
        }
        String string2 = IiIiIiIi_Class86.I_method_2e8dd04a(string);
        for (ModuleEntry object : RockstarClient.getInstance().getModuleManager().getModules()) {
            if (!IiIiIiIi_Class86.I_method_2e8dd04a(object.getName()).equals(string2)) continue;
            return object;
        }
        ArrayList arrayList = new ArrayList();
        for (ModuleEntry iiIiiIii_Class92 : RockstarClient.getInstance().getModuleManager().getModules()) {
            String string3 = IiIiIiIi_Class86.I_method_2e8dd04a(iiIiiIii_Class92.getName());
            boolean bl = string3.contains(string2) || string2.contains(string3) || string2.length() >= 3 && string3.startsWith(string2.substring(0, 3));
            if (!bl) continue;
            arrayList.add(iiIiiIii_Class92.getName());
        }
        throw new IiIiiIII_Class89.Nested1_426908f3("\u043d\u0435\u0442 \u043c\u043e\u0434\u0443\u043b\u044f \"" + string + "\"" + (String)(arrayList.isEmpty() ? "" : ", \u043f\u043e\u0445\u043e\u0436\u0438\u0435: " + String.join((CharSequence)", ", arrayList)));
    }

    public static JsonObject I_method_6700b3e2(String string, String string2) {
        ModuleEntry iiIiiIii_Class92 = IiIiIiIi_Class86.I_method_b99c08a1(string);
        boolean bl = switch (string2 == null ? "toggle" : string2.toLowerCase(Locale.ROOT)) {
            case "enable", "on", "true" -> true;
            case "disable", "off", "false" -> false;
            default -> !iiIiiIii_Class92.isEnabled();
        };
        iiIiiIii_Class92.setEnabled(bl, false);
        IiIiIiIi_Class86.I_method_e7c8c44c();
        return IiIiiIIi_Class90.I_method_a29ebd5b(iiIiiIii_Class92, false);
    }

    public static JsonObject I_method_bbe7cc8f(String string, JsonElement jsonElement) {
        ModuleEntry iiIiiIii_Class92 = IiIiIiIi_Class86.I_method_b99c08a1(string);
        iiIiiIii_Class92.setKeybind(IiIiIiIi_Class86.I_method_9989d50(jsonElement));
        IiIiIiIi_Class86.I_method_e7c8c44c();
        return IiIiiIIi_Class90.I_method_a29ebd5b(iiIiiIii_Class92, false);
    }

    public static Setting I_method_538b60d(ModuleEntry iiIiiIii_Class92, String string) {
        if (string == null || string.isBlank()) {
            throw new IiIiiIII_Class89.Nested1_426908f3("\u043d\u0435 \u0443\u043a\u0430\u0437\u0430\u043d\u0430 \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0430");
        }
        String string2 = IiIiIiIi_Class86.I_method_2e8dd04a(string);
        for (Setting iIiiiIIII_Class1132 : iiIiiIii_Class92.getSettings()) {
            if (!IiIiIiIi_Class86.I_method_2e8dd04a(iIiiiIIII_Class1132.getName()).equals(string2) && !IiIiIiIi_Class86.I_method_2e8dd04a(IiIiIIII_Class81.I_method_f25a980a(iIiiiIIII_Class1132.getName())).equals(string2)) continue;
            return iIiiiIIII_Class1132;
        }
        for (Setting iIiiiIIII_Class1132 : iiIiiIii_Class92.getSettings()) {
            if (!IiIiIiIi_Class86.I_method_2e8dd04a(iIiiiIIII_Class1132.getName()).endsWith("." + string2)) continue;
            return iIiiiIIII_Class1132;
        }
        ArrayList arrayList = new ArrayList();
        iiIiiIii_Class92.getSettings().forEach(iIiiiIIII_Class113 -> arrayList.add(iIiiiIIII_Class113.getName()));
        throw new IiIiiIII_Class89.Nested1_426908f3("\u0443 \u043c\u043e\u0434\u0443\u043b\u044f " + iiIiiIii_Class92.getName() + " \u043d\u0435\u0442 \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \"" + string + "\"; \u0435\u0441\u0442\u044c: " + String.join((CharSequence)", ", arrayList));
    }

    public static JsonObject I_method_1ff536d9(String string, String string2, JsonElement jsonElement) {
        ModuleEntry iiIiiIii_Class92 = IiIiIiIi_Class86.I_method_b99c08a1(string);
        Setting iIiiiIIII_Class113 = IiIiIiIi_Class86.I_method_538b60d(iiIiiIii_Class92, string2);
        IiIiIiIi_Class86.I_method_2e7e4e0f(iIiiiIIII_Class113, jsonElement);
        IiIiIiIi_Class86.I_method_e7c8c44c();
        return IiIiiIIi_Class90.I_method_3c1848e8(iIiiiIIII_Class113);
    }

    public static void I_method_2e7e4e0f(Setting iIiiiIIII_Class113, JsonElement jsonElement) {
        if (jsonElement == null || jsonElement.isJsonNull()) {
            throw new IiIiiIII_Class89.Nested1_426908f3("\u043d\u0435 \u043f\u0435\u0440\u0435\u0434\u0430\u043d\u043e \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u0435");
        }
        if (iIiiiIIII_Class113 instanceof BooleanSetting) {
            BooleanSetting iIiiiIiii_Class120 = (BooleanSetting)iIiiiIIII_Class113;
            if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isString() && "toggle".equalsIgnoreCase(jsonElement.getAsString())) {
                iIiiiIiii_Class120.I_method_4e1408b5(!iIiiiIiii_Class120.i_method_9b12da03());
            } else {
                iIiiiIiii_Class120.I_method_4e1408b5(IiIiIiIi_Class86.I_method_9989d61(jsonElement));
            }
            return;
        }
        if (iIiiiIIII_Class113 instanceof SliderSetting) {
            SliderSetting iiIIIIIIi_Class130 = (SliderSetting)iIiiiIIII_Class113;
            iiIIIIIIi_Class130.I_method_a1eda161(IiIiIiIi_Class86.I_method_9989d4d(jsonElement));
            return;
        }
        if (iIiiiIIII_Class113 instanceof RangeSetting) {
            RangeSetting iIiiiiiiI_Class127 = (RangeSetting)iIiiiIIII_Class113;
            if (jsonElement.isJsonArray() && jsonElement.getAsJsonArray().size() == 2) {
                iIiiiiiiI_Class127.I_method_3a7a7961(jsonElement.getAsJsonArray().get(0).getAsFloat());
                iIiiiiiiI_Class127.i_method_3c3d6981(jsonElement.getAsJsonArray().get(1).getAsFloat());
                return;
            }
            if (jsonElement.isJsonObject()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                if (jsonObject.has("first")) {
                    iIiiiiiiI_Class127.I_method_3a7a7961(jsonObject.get("first").getAsFloat());
                }
                if (jsonObject.has("second")) {
                    iIiiiiiiI_Class127.i_method_3c3d6981(jsonObject.get("second").getAsFloat());
                }
                return;
            }
            throw new IiIiiIII_Class89.Nested1_426908f3("\u0434\u043b\u044f range \u043d\u0443\u0436\u0435\u043d [min, max] \u0438\u043b\u0438 {\"first\":.., \"second\":..}");
        }
        if (iIiiiIIII_Class113 instanceof ModeSetting) {
            ModeSetting iIiiiiiII_Class125 = (ModeSetting)iIiiiIIII_Class113;
            ModeSetting.Nested1_42765c60 nested1_42765c60 = null;
            if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber()) {
                int n = jsonElement.getAsInt();
                if (n < 0 || n >= iIiiiiiII_Class125.I_method_e1d4a248().size()) {
                    throw new IiIiiIII_Class89.Nested1_426908f3("\u0440\u0435\u0436\u0438\u043c \u2116" + n + " \u0432\u043d\u0435 \u0441\u043f\u0438\u0441\u043a\u0430");
                }
                nested1_42765c60 = iIiiiiiII_Class125.I_method_e1d4a248().get(n);
            } else {
                String string = IiIiIiIi_Class86.I_method_2e8dd04a(jsonElement.getAsString());
                for (ModeSetting.Nested1_42765c60 nested1_42765c602 : iIiiiiiII_Class125.I_method_e1d4a248()) {
                    if (!IiIiIiIi_Class86.I_method_2e8dd04a(nested1_42765c602.getName()).equals(string) && !IiIiIiIi_Class86.I_method_2e8dd04a(IiIiIIII_Class81.I_method_f25a980a(nested1_42765c602.getName())).equals(string) && !IiIiIiIi_Class86.I_method_2e8dd04a(nested1_42765c602.getName()).endsWith("." + string)) continue;
                    nested1_42765c60 = nested1_42765c602;
                    break;
                }
            }
            if (nested1_42765c60 == null) {
                throw new IiIiiIII_Class89.Nested1_426908f3("\u043d\u0435\u0442 \u0442\u0430\u043a\u043e\u0433\u043e \u0440\u0435\u0436\u0438\u043c\u0430; \u0435\u0441\u0442\u044c: " + IiIiIiIi_Class86.I_method_5a398186(iIiiiiiII_Class125));
            }
            nested1_42765c60.select();
            return;
        }
        if (iIiiiIIII_Class113 instanceof MultiSelectSetting) {
            MultiSelectSetting iIiiiiiii_Class128 = (MultiSelectSetting)iIiiiIIII_Class113;
            JsonArray jsonArray = new JsonArray();
            if (jsonElement.isJsonArray()) {
                jsonArray = jsonElement.getAsJsonArray();
            } else {
                jsonArray.add(jsonElement.getAsString());
            }
            ArrayList<MultiSelectSetting.Nested1_42856060> arrayList = new ArrayList<MultiSelectSetting.Nested1_42856060>();
            for (JsonElement object : jsonArray) {
                String string = IiIiIiIi_Class86.I_method_2e8dd04a(object.getAsString());
                MultiSelectSetting.Nested1_42856060 nested1_42856060 = null;
                for (MultiSelectSetting.Nested1_42856060 nested1_428560602 : iIiiiiiii_Class128.I_method_45aaa648()) {
                    if (!IiIiIiIi_Class86.I_method_2e8dd04a(nested1_428560602.getName()).equals(string) && !IiIiIiIi_Class86.I_method_2e8dd04a(IiIiIIII_Class81.I_method_f25a980a(nested1_428560602.getName())).equals(string) && !IiIiIiIi_Class86.I_method_2e8dd04a(nested1_428560602.getName()).endsWith("." + string)) continue;
                    nested1_42856060 = nested1_428560602;
                    break;
                }
                if (nested1_42856060 == null) {
                    throw new IiIiiIII_Class89.Nested1_426908f3("\u043d\u0435\u0442 \u043f\u0443\u043d\u043a\u0442\u0430 \"" + object.getAsString() + "\"; \u0435\u0441\u0442\u044c: " + IiIiIiIi_Class86.I_method_be0f8586(iIiiiiiii_Class128));
                }
                arrayList.add(nested1_42856060);
            }
            for (MultiSelectSetting.Nested1_42856060 nested1_42856060 : new ArrayList<MultiSelectSetting.Nested1_42856060>(iIiiiiiii_Class128.I_method_45aaa648())) {
                if (arrayList.contains(nested1_42856060)) continue;
                nested1_42856060.deselect();
            }
            arrayList.forEach(MultiSelectSetting.Nested1_42856060::select);
            return;
        }
        if (iIiiiIIII_Class113 instanceof ColorSetting) {
            ColorSetting iIiiiiIIi_Class122 = (ColorSetting)iIiiiIIII_Class113;
            iIiiiiIIi_Class122.I_method_a62f5dd6(ColorRGBA.fromHex(jsonElement.getAsString()));
            return;
        }
        if (iIiiiIIII_Class113 instanceof KeybindSetting) {
            KeybindSetting iIiiiIiIi_Class118 = (KeybindSetting)iIiiiIIII_Class113;
            iIiiiIiIi_Class118.I_method_51ee2d04(IiIiIiIi_Class86.I_method_9989d50(jsonElement));
            return;
        }
        if (iIiiiIIII_Class113 instanceof TextSetting) {
            TextSetting iiIIIIIiI_Class131 = (TextSetting)iIiiiIIII_Class113;
            iiIIIIIiI_Class131.I_method_104de33f(jsonElement.getAsString());
            return;
        }
        if (iIiiiIIII_Class113 instanceof ButtonSetting) {
            ButtonSetting iIiiiiIII_Class121 = (ButtonSetting)iIiiiIIII_Class113;
            Runnable runnable = iIiiiiIII_Class121.I_method_7db574f5();
            if (runnable == null) {
                throw new IiIiiIII_Class89.Nested1_426908f3("\u0443 \u043a\u043d\u043e\u043f\u043a\u0438 \u043d\u0435\u0442 \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u044f");
            }
            runnable.run();
            return;
        }
        iIiiiIIII_Class113.fromJson(jsonElement);
    }

    public static JsonArray I_method_bd848eef(String string, JsonElement jsonElement) {
        if (string == null || string.isBlank()) {
            throw new IiIiiIII_Class89.Nested1_426908f3("\u043d\u0435 \u0443\u043a\u0430\u0437\u0430\u043d\u0430 \u043a\u043e\u043c\u0430\u043d\u0434\u0430 \u043c\u0430\u043a\u0440\u043e\u0441\u0430");
        }
        int n = IiIiIiIi_Class86.I_method_9989d50(jsonElement);
        if (n <= 0) {
            throw new IiIiiIII_Class89.Nested1_426908f3("\u043d\u0435 \u0440\u0430\u0437\u043e\u0431\u0440\u0430\u043b \u043a\u043b\u0430\u0432\u0438\u0448\u0443 \u043c\u0430\u043a\u0440\u043e\u0441\u0430");
        }
        IiIiIiII_Class85 iiIiIiII_Class85 = RockstarClient.getInstance().I_method_af32eeab();
        iiIiIiII_Class85.I_method_2f3b428d(string.trim(), n);
        RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
        return IiIiiIIi_Class90.I_method_4f8ed768();
    }

    public static JsonArray i_method_d7545f0f(String string, JsonElement jsonElement) {
        boolean bl;
        IiIiIiII_Class85 iiIiIiII_Class85 = RockstarClient.getInstance().I_method_af32eeab();
        if (string != null && !string.isBlank() && jsonElement != null && !jsonElement.isJsonNull()) {
            bl = iiIiIiII_Class85.I_method_2f3b4291(string.trim(), IiIiIiIi_Class86.I_method_9989d50(jsonElement));
        } else if (string != null && !string.isBlank()) {
            bl = iiIiIiII_Class85.I_method_9c8173a(string.trim());
        } else if (jsonElement != null && !jsonElement.isJsonNull()) {
            bl = iiIiIiII_Class85.I_method_7488d01b(IiIiIiIi_Class86.I_method_9989d50(jsonElement));
        } else {
            throw new IiIiiIII_Class89.Nested1_426908f3("\u043d\u0443\u0436\u043d\u0430 \u043a\u043e\u043c\u0430\u043d\u0434\u0430 \u0438\u043b\u0438 \u043a\u043b\u0430\u0432\u0438\u0448\u0430 \u043c\u0430\u043a\u0440\u043e\u0441\u0430");
        }
        if (!bl) {
            throw new IiIiiIII_Class89.Nested1_426908f3("\u0442\u0430\u043a\u043e\u0433\u043e \u043c\u0430\u043a\u0440\u043e\u0441\u0430 \u043d\u0435\u0442");
        }
        RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
        return IiIiiIIi_Class90.I_method_4f8ed768();
    }

    public static JsonObject I_method_69eed3d8(String string, String string2, String string3) {
        IIiiiiiI_Class63 iIiiiiiI_Class63 = RockstarClient.getInstance().I_method_5198232b();
        switch (string == null ? "list" : string.toLowerCase(Locale.ROOT)) {
            case "list": {
                break;
            }
            case "save": {
                iIiiiiiI_Class63.I_method_ce5aebb6(IiIiIiIi_Class86.I_method_2cc05d40(string2, "\u0438\u043c\u044f \u043a\u043e\u043d\u0444\u0438\u0433\u0430"));
                break;
            }
            case "load": {
                IiIiIiIi_Class86.I_method_b7f76f77(iIiiiiiI_Class63, string2);
                iIiiiiiI_Class63.i_method_9f123f96(string2);
                break;
            }
            case "delete": {
                IiIiIiIi_Class86.I_method_b7f76f77(iIiiiiiI_Class63, string2);
                iIiiiiiI_Class63.Ii_method_250d3a5f(string2);
                break;
            }
            case "rename": {
                IiIiIiIi_Class86.I_method_b7f76f77(iIiiiiiI_Class63, string2);
                iIiiiiiI_Class63.I_method_cd7cd400(string2, IiIiIiIi_Class86.I_method_2cc05d40(string3, "\u043d\u043e\u0432\u043e\u0435 \u0438\u043c\u044f"));
                break;
            }
            case "duplicate": {
                IiIiIiIi_Class86.I_method_b7f76f77(iIiiiiiI_Class63, string2);
                iIiiiiiI_Class63.iI_method_9a890e9f(string2);
                break;
            }
            case "reset": {
                iIiiiiiI_Class63.iI_method_2181e015();
                break;
            }
            default: {
                throw new IiIiiIII_Class89.Nested1_426908f3("\u043d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u043e\u0435 \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0435: " + string);
            }
        }
        return IiIiiIIi_Class90.III_method_f4f4e616();
    }

    public static JsonObject i_method_677c83f8(String string, String string2, String string3) {
        IIiiIIiiI_Class103 iIiiIIiiI_Class103 = RockstarClient.getInstance().I_method_a90eb842();
        JsonObject jsonObject = new JsonObject();
        switch (string == null ? "list" : string.toLowerCase(Locale.ROOT)) {
            case "list": {
                break;
            }
            case "read": {
                jsonObject.addProperty("content", IiIiIiIi_Class86.I_method_b7d40986(IiIiIiIi_Class86.I_method_b6e1b92c(IiIiIiIi_Class86.I_method_2cc05d40(string2, "\u0438\u043c\u044f \u0441\u043a\u0440\u0438\u043f\u0442\u0430"))));
                break;
            }
            case "write": 
            case "create": {
                String string4 = IiIiIiIi_Class86.I_method_2cc05d40(string2, "\u0438\u043c\u044f \u0441\u043a\u0440\u0438\u043f\u0442\u0430");
                boolean bl = IiIiIiIi_Class86.i_method_f035f50c(string4) == null;
                IiIiIiIi_Class86.I_method_47ecc360(string4, string3 == null ? "" : string3);
                iIiiIIiiI_Class103.II_method_14c48d02();
                if (bl) {
                    iIiiIIiiI_Class103.I_method_8a6291ab(string4, true);
                }
                jsonObject.addProperty("written", string4);
                IIiiIIiii_Class104 iIiiIIiii_Class104 = IiIiIiIi_Class86.i_method_f035f50c(string4);
                if (iIiiIIiii_Class104 == null) break;
                jsonObject.addProperty("loaded", Boolean.valueOf(iIiiIIiii_Class104.II_method_b18bf526()));
                if (iIiiIIiii_Class104.II_method_37d6a7be() == null) break;
                jsonObject.addProperty("error", iIiiIIiii_Class104.II_method_37d6a7be());
                break;
            }
            case "delete": {
                IIiiIIiii_Class104 iIiiIIiii_Class104 = IiIiIiIi_Class86.I_method_b6e1b92c(IiIiIiIi_Class86.I_method_2cc05d40(string2, "\u0438\u043c\u044f \u0441\u043a\u0440\u0438\u043f\u0442\u0430"));
                if (!iIiiIIiii_Class104.i_method_e0a5203()) {
                    throw new IiIiiIII_Class89.Nested1_426908f3("\u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0443\u0434\u0430\u043b\u0438\u0442\u044c \u0441\u043a\u0440\u0438\u043f\u0442 " + string2);
                }
                jsonObject.addProperty("deleted", string2);
                break;
            }
            case "enable": 
            case "load": {
                iIiiIIiiI_Class103.I_method_8a6291ab(IiIiIiIi_Class86.I_method_2cc05d40(string2, "\u0438\u043c\u044f \u0441\u043a\u0440\u0438\u043f\u0442\u0430"), true);
                break;
            }
            case "disable": 
            case "unload": {
                iIiiIIiiI_Class103.I_method_8a6291ab(IiIiIiIi_Class86.I_method_2cc05d40(string2, "\u0438\u043c\u044f \u0441\u043a\u0440\u0438\u043f\u0442\u0430"), false);
                break;
            }
            case "reload": {
                iIiiIIiiI_Class103.II_method_14c48d02();
                break;
            }
            default: {
                throw new IiIiiIII_Class89.Nested1_426908f3("\u043d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u043e\u0435 \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0435: " + string);
            }
        }
        jsonObject.add("scripts", (JsonElement)IiIiiIIi_Class90.i_method_65244b48());
        return jsonObject;
    }

    private static IIiiIIiii_Class104 I_method_b6e1b92c(String string) {
        IIiiIIiii_Class104 iIiiIIiii_Class104 = IiIiIiIi_Class86.i_method_f035f50c(string);
        if (iIiiIIiii_Class104 == null) {
            throw new IiIiiIII_Class89.Nested1_426908f3("\u043d\u0435\u0442 \u0441\u043a\u0440\u0438\u043f\u0442\u0430 \"" + string + "\"");
        }
        return iIiiIIiii_Class104;
    }

    private static IIiiIIiii_Class104 i_method_f035f50c(String string) {
        for (IIiiIIiii_Class104 iIiiIIiii_Class104 : RockstarClient.getInstance().I_method_a90eb842().i_method_619cb248()) {
            if (!IiIiIiIi_Class86.I_method_2e8dd04a(iIiiIIiii_Class104.I_method_332d5061()).equals(IiIiIiIi_Class86.I_method_2e8dd04a(string))) continue;
            return iIiiIIiii_Class104;
        }
        return null;
    }

    private static String I_method_b7d40986(IIiiIIiii_Class104 iIiiIIiii_Class104) {
        if (iIiiIIiii_Class104.I_method_c8d5294e() == null) {
            throw new IiIiiIII_Class89.Nested1_426908f3("\u0441\u043a\u0440\u0438\u043f\u0442 " + iIiiIIiii_Class104.I_method_332d5061() + " \u0437\u0430\u0449\u0438\u0449\u0451\u043d\u043d\u044b\u0439 (\u043a\u0443\u043f\u043b\u0435\u043d \u043d\u0430 \u0441\u0430\u0439\u0442\u0435) \u2014 \u0438\u0441\u0445\u043e\u0434\u043d\u0438\u043a\u0430 \u043d\u0435\u0442");
        }
        try {
            return Files.readString(iIiiIIiii_Class104.I_method_c8d5294e().toPath(), StandardCharsets.UTF_8);
        }
        catch (IOException iOException) {
            throw new IiIiiIII_Class89.Nested1_426908f3("\u043d\u0435 \u043f\u0440\u043e\u0447\u0438\u0442\u0430\u043b \u0441\u043a\u0440\u0438\u043f\u0442: " + iOException.getMessage());
        }
    }

    private static void I_method_47ecc360(String string, String string2) {
        File file = new File(IiIIiIII_Class73.I_field_3a58077, "scripts");
        if (!file.exists() && !file.mkdirs()) {
            throw new IiIiiIII_Class89.Nested1_426908f3("\u043d\u0435 \u0441\u043e\u0437\u0434\u0430\u043b \u043f\u0430\u043f\u043a\u0443 \u0441\u043a\u0440\u0438\u043f\u0442\u043e\u0432");
        }
        Object object = string.endsWith(".py") ? string : string + ".py";
        try {
            Files.writeString(new File(file, (String)object).toPath(), (CharSequence)string2, StandardCharsets.UTF_8, new OpenOption[0]);
        }
        catch (IOException iOException) {
            throw new IiIiiIII_Class89.Nested1_426908f3("\u043d\u0435 \u0437\u0430\u043f\u0438\u0441\u0430\u043b \u0441\u043a\u0440\u0438\u043f\u0442: " + iOException.getMessage());
        }
    }

    public static JsonObject I_method_c81fefed(String string, String string2, String string3, String string4, JsonElement jsonElement) {
        iiIIIIIi_Class194 iiIIIIIi_Class1942 = RockstarClient.getInstance().I_method_11732eb();
        switch (string == null ? "state" : string.toLowerCase(Locale.ROOT)) {
            case "state": 
            case "list": {
                break;
            }
            case "apply": {
                IiIiIiIi_Class86.I_method_1b111f37(iiIIIIIi_Class1942, IiIiIiIi_Class86.I_method_2cc05d40(string2, "\u0438\u043c\u044f \u043f\u0440\u0435\u0441\u0435\u0442\u0430"));
                break;
            }
            case "set": {
                List<Setting> list = switch (string3 == null ? "shared" : string3.toLowerCase(Locale.ROOT)) {
                    case "start" -> iiIIIIIi_Class1942.I_method_94b5d40b().getSettings();
                    case "end" -> iiIIIIIi_Class1942.i_method_beb2642b().getSettings();
                    case "shared" -> iiIIIIIi_Class1942.I_method_94c3e7cb().getSettings();
                    default -> throw new IiIiiIII_Class89.Nested1_426908f3("phase \u0431\u044b\u0432\u0430\u0435\u0442 shared, start \u0438\u043b\u0438 end");
                };
                Object object = null;
                String string5 = IiIiIiIi_Class86.I_method_2e8dd04a(IiIiIiIi_Class86.I_method_2cc05d40(string4, "\u0438\u043c\u044f \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438"));
                for (Setting iIiiiIIII_Class113 : list) {
                    if (!IiIiIiIi_Class86.I_method_2e8dd04a(iIiiiIIII_Class113.getName()).equals(string5) && !IiIiIiIi_Class86.I_method_2e8dd04a(iIiiiIIII_Class113.getName()).endsWith("." + string5)) continue;
                    object = iIiiiIIII_Class113;
                    break;
                }
                if (object == null) {
                    throw new IiIiiIII_Class89.Nested1_426908f3("\u0432 \u0444\u0430\u0437\u0435 \u043d\u0435\u0442 \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \"" + string4 + "\"");
                }
                IiIiIiIi_Class86.I_method_2e7e4e0f((Setting)object, jsonElement);
                RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
                break;
            }
            default: {
                throw new IiIiiIII_Class89.Nested1_426908f3("\u043d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u043e\u0435 \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0435: " + string);
            }
        }
        return IiIiiIIi_Class90.IIi_method_920dee36();
    }

    private static void I_method_1b111f37(iiIIIIIi_Class194 iiIIIIIi_Class1942, String string) {
        String string2 = IiIiIiIi_Class86.I_method_2e8dd04a(string);
        for (iiIIIiii_Class200 object : iiIIIIIi_Class1942.I_method_c2ce901b()) {
            if (!IiIiIiIi_Class86.I_method_2e8dd04a(object.I_method_62860974()).equals(string2) && !IiIiIiIi_Class86.I_method_2e8dd04a(IiIiIIII_Class81.I_method_f25a980a(object.I_method_62860974())).equals(string2) && !IiIiIiIi_Class86.I_method_2e8dd04a(object.I_method_62860974()).endsWith("." + string2)) continue;
            iiIIIIIi_Class1942.I_method_3912c30d(object);
            RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
            return;
        }
        for (iiIIiIII_Class201 iiIIiIII_Class2012 : RockstarClient.getInstance().I_method_2da230b().I_method_43006bfb()) {
            if (!IiIiIiIi_Class86.I_method_2e8dd04a(iiIIiIII_Class2012.I_method_5141c934()).equals(string2)) continue;
            iiIIiIII_Class2012.I_method_84c8a0ec();
            RockstarClient.getInstance().I_method_2da230b().I_method_7885936d(iiIIiIII_Class2012);
            RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
            return;
        }
        throw new IiIiiIII_Class89.Nested1_426908f3("\u043d\u0435\u0442 \u043f\u0440\u0435\u0441\u0435\u0442\u0430 \u0441\u0432\u0438\u043d\u0433\u0430 \"" + string + "\"");
    }

    public static JsonObject I_method_d9c9626c(String string) {
        if (string == null || string.isBlank()) {
            throw new IiIiiIII_Class89.Nested1_426908f3("\u043f\u0443\u0441\u0442\u043e\u0435 \u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435");
        }
        if (iIIiIIiIi_Class294.I_field_3a9bda27.player == null || iIIiIIiIi_Class294.I_field_3a9bda27.getNetworkHandler() == null) {
            throw new IiIiiIII_Class89.Nested1_426908f3("\u0438\u0433\u0440\u043e\u043a \u043d\u0435 \u0432 \u0438\u0433\u0440\u0435 \u2014 \u043f\u0438\u0441\u0430\u0442\u044c \u043d\u0435\u043a\u0443\u0434\u0430");
        }
        String string2 = string.trim();
        JsonObject jsonObject = new JsonObject();
        String string3 = RockstarClient.getInstance().I_method_b4d046cb().I_method_80ea594();
        if (!string3.isEmpty() && string2.startsWith(string3 + string3)) {
            iIIiIIiIi_Class294.I_field_3a9bda27.getNetworkHandler().sendChatMessage(string2.substring(string3.length()));
            jsonObject.addProperty("sent", "\u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435 \u0432 \u0447\u0430\u0442");
        } else if (!string3.isEmpty() && string2.startsWith(string3)) {
            RockstarClient.getInstance().I_method_b4d046cb().I_method_9e86975a(string2);
            jsonObject.addProperty("sent", "\u043a\u043b\u0438\u0435\u043d\u0442\u0441\u043a\u0430\u044f \u043a\u043e\u043c\u0430\u043d\u0434\u0430");
        } else if (string2.startsWith("/")) {
            iIIiIIiIi_Class294.I_field_3a9bda27.getNetworkHandler().sendChatCommand(string2.substring(1));
            jsonObject.addProperty("sent", "\u043a\u043e\u043c\u0430\u043d\u0434\u0430 \u0441\u0435\u0440\u0432\u0435\u0440\u0430");
        } else {
            iIIiIIiIi_Class294.I_field_3a9bda27.getNetworkHandler().sendChatMessage(string2);
            jsonObject.addProperty("sent", "\u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435 \u0432 \u0447\u0430\u0442");
        }
        jsonObject.addProperty("text", string2);
        return jsonObject;
    }

    public static JsonObject i_method_cafca28c(String string) {
        MenuModule iIiIIiiIi_Class78 = RockstarClient.getInstance().getModuleManager().getModule(MenuModule.class);
        switch (string == null ? "open" : string.toLowerCase(Locale.ROOT)) {
            case "open": {
                if (iIiIIiiIi_Class78.isEnabled()) break;
                iIiIIiiIi_Class78.setEnabled(true, true);
                break;
            }
            case "close": {
                if (iIiIIiiIi_Class78.isEnabled()) {
                    iIiIIiiIi_Class78.setEnabled(false, true);
                }
                iIIiIIiIi_Class294.I_field_3a9bda27.setScreen(null);
                break;
            }
            case "toggle": {
                iIiIIiiIi_Class78.toggle();
                break;
            }
            default: {
                throw new IiIiiIII_Class89.Nested1_426908f3("\u043d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u043e\u0435 \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0435: " + string);
            }
        }
        return IiIiiIIi_Class90.iI_method_5d7d01ad();
    }

    public static int I_method_9989d50(JsonElement jsonElement) {
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return 0;
        }
        if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber()) {
            return jsonElement.getAsInt();
        }
        String string = jsonElement.getAsString().trim();
        if (string.isEmpty() || string.equalsIgnoreCase("none") || string.equalsIgnoreCase("\u043d\u0435\u0442")) {
            return 0;
        }
        int n = iIIIIIIIi_Class258.I_method_dc7f39fc(string);
        if (n == -1) {
            throw new IiIiiIII_Class89.Nested1_426908f3("\u043d\u0435 \u0437\u043d\u0430\u044e \u043a\u043b\u0430\u0432\u0438\u0448\u0443 \"" + string + "\"");
        }
        return n;
    }

    private static boolean I_method_9989d61(JsonElement jsonElement) {
        if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isBoolean()) {
            return jsonElement.getAsBoolean();
        }
        String string = jsonElement.getAsString().trim().toLowerCase(Locale.ROOT);
        return string.equals("true") || string.equals("on") || string.equals("1") || string.equals("\u0434\u0430");
    }

    private static float I_method_9989d4d(JsonElement jsonElement) {
        try {
            return jsonElement.getAsFloat();
        }
        catch (Exception exception) {
            throw new IiIiiIII_Class89.Nested1_426908f3("\u043e\u0436\u0438\u0434\u0430\u043b\u043e\u0441\u044c \u0447\u0438\u0441\u043b\u043e, \u043f\u0440\u0438\u0448\u043b\u043e " + String.valueOf(jsonElement));
        }
    }

    private static String I_method_5a398186(ModeSetting iIiiiiiII_Class125) {
        ArrayList arrayList = new ArrayList();
        iIiiiiiII_Class125.I_method_e1d4a248().forEach(nested1_42765c60 -> arrayList.add(nested1_42765c60.getName()));
        return String.join((CharSequence)", ", arrayList);
    }

    private static String I_method_be0f8586(MultiSelectSetting iIiiiiiii_Class128) {
        ArrayList arrayList = new ArrayList();
        iIiiiiiii_Class128.I_method_45aaa648().forEach(nested1_42856060 -> arrayList.add(nested1_42856060.getName()));
        return String.join((CharSequence)", ", arrayList);
    }

    private static String I_method_2cc05d40(String string, String string2) {
        if (string == null || string.isBlank()) {
            throw new IiIiiIII_Class89.Nested1_426908f3("\u043d\u0435 \u0443\u043a\u0430\u0437\u0430\u043d\u043e: " + string2);
        }
        return string.trim();
    }

    private static void I_method_b7f76f77(IIiiiiiI_Class63 iIiiiiiI_Class63, String string) {
        if (string == null || !iIiiiiiI_Class63.I_method_ce5aebba(string)) {
            throw new IiIiiIII_Class89.Nested1_426908f3("\u043d\u0435\u0442 \u043a\u043e\u043d\u0444\u0438\u0433\u0430 \"" + string + "\"; \u0435\u0441\u0442\u044c: " + String.join((CharSequence)", ", iIiiiiiI_Class63.i_method_f9096ffb()));
        }
    }

    private static void I_method_e7c8c44c() {
        RockstarClient.getInstance().I_method_5198232b().II_method_1fbeeff5();
    }

    static String I_method_2e8dd04a(String string) {
        return string == null ? "" : string.toLowerCase(Locale.ROOT).replace(" ", "").replace("_", "");
    }
}

