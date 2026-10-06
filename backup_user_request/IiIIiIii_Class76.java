package rockstar.client;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import rockstar.client.IiIIIIiii_Class136;
import rockstar.client.IiIIIiii_Class72;
import rockstar.client.IiIIiIII_Class73;
import rockstar.client.IiIIiIIi_Class74;
import rockstar.client.RockstarClient;

@IiIIiIIi_Class74(I_method_81df7d74="staff", i_method_14fe2d94="txt")
public final class IiIIiIii_Class76
extends IiIIIiii_Class72 {
    @Override
    public void I_method_fb62088c() {
        try {
            List<String> list = RockstarClient.getInstance().I_method_98af9842().I_method_f4439a28().stream().map(nested1_739d8c40 -> "[" + nested1_739d8c40.i_method_a6a62886() + "] " + nested1_739d8c40.I_method_13877866()).toList();
            IiIIiIII_Class73.I_method_a06f044d(this.I_method_aa990001(), String.join((CharSequence)System.lineSeparator(), list));
        }
        catch (Exception exception) {
            RockstarClient.I_field_ab0f6068.error("Failed to save staff list", (Throwable)exception);
        }
    }

    @Override
    public void i_method_fb70946c() {
        try {
            ArrayList<IiIIIIiii_Class136.Nested1_739d8c40> arrayList = new ArrayList<IiIIIIiii_Class136.Nested1_739d8c40>();
            for (String string : Files.readAllLines(this.I_method_aa990001().toPath(), StandardCharsets.UTF_8)) {
                IiIIIIiii_Class136.Nested1_739d8c40 nested1_739d8c40 = this.I_method_77d8cd87(string);
                if (nested1_739d8c40 == null) continue;
                arrayList.add(nested1_739d8c40);
            }
            RockstarClient.getInstance().I_method_98af9842().i_method_74e1fa90(arrayList);
        }
        catch (Exception exception) {
            RockstarClient.I_field_ab0f6068.error("Failed to load staff list", (Throwable)exception);
        }
    }

    private IiIIIIiii_Class136.Nested1_739d8c40 I_method_77d8cd87(String string) {
        int n;
        if (string == null || string.isBlank()) {
            return null;
        }
        String string2 = string.trim();
        if (string2.startsWith("[") && (n = string2.indexOf(93)) > 1 && n + 1 < string2.length()) {
            return new IiIIIIiii_Class136.Nested1_739d8c40(string2.substring(n + 1).trim(), string2.substring(1, n).trim());
        }
        n = string2.indexOf(58);
        if (n > 0 && n + 1 < string2.length()) {
            return new IiIIIIiii_Class136.Nested1_739d8c40(string2.substring(n + 1).trim(), string2.substring(0, n).trim());
        }
        return new IiIIIIiii_Class136.Nested1_739d8c40(string2, "MODER");
    }
}

