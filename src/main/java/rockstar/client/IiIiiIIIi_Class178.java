package rockstar.client;

import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.util.Identifier;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiiIiIi_Class246;

final class IiIiiIIIi_Class178 {
    private static final Identifier I_field_6a3d6525 = RockstarClient.id("textures/emoji/emoji_atlas.png");
    private static Map<String, Integer> I_field_a567c40b;

    private IiIiiIIIi_Class178() {
    }

    static Integer I_method_5f18c130(String string) {
        if (I_field_a567c40b == null) {
            JsonObject jsonObject = IiiiiIiIi_Class246.I_method_47e943d5(RockstarClient.id("emoji/emoji_atlas.json"), JsonObject.class);
            I_field_a567c40b = new HashMap<String, Integer>(jsonObject.size());
            for (String string2 : jsonObject.keySet()) {
                I_field_a567c40b.put(string2, jsonObject.get(string2).getAsInt());
            }
        }
        return I_field_a567c40b.get(string);
    }

    static void I_method_529619e6(CustomDrawContext customDrawContext, int n, float f, float f2, float f3, float f4) {
        float f5 = 0.015625f;
        float f6 = (float)(n % 64) * f5;
        float f7 = (float)(n / 64) * f5;
        customDrawContext.drawTexture(I_field_6a3d6525, f, f2, f3, f3, f6, f6 + f5, f7, f7 + f5, ColorRGBA.WHITE.withAlpha(f4));
    }
}

