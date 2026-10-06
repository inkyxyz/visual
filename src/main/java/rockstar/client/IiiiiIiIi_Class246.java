package rockstar.client;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import rockstar.client.IiIIiiiI_Class79;
import rockstar.client.RockstarClient;

public class IiiiiIiIi_Class246 {
    private static final ResourceManager I_field_210493d = MinecraftClient.getInstance().getResourceManager();
    private static final Gson I_field_fbd77e28 = new Gson();

    public static Identifier I_method_745d4398(String string) {
        return RockstarClient.id("core/" + string);
    }

    public static <T> T I_method_47e943d5(Identifier identifier, Class<T> clazz) {
        try {
            return (T)I_field_fbd77e28.fromJson(IiiiiIiIi_Class246.I_method_33948db7(IiiiiIiIi_Class246.I_method_a1486a60(identifier)), clazz);
        }
        catch (Exception exception) {
            throw new RuntimeException("\u041d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u043f\u0440\u043e\u0447\u0438\u0442\u0430\u0442\u044c \u0440\u0435\u0441\u0443\u0440\u0441 " + String.valueOf(identifier) + ": " + exception.getMessage(), exception);
        }
    }

    public static String I_method_33948db7(String string) {
        return IiIIiiiI_Class79.I_method_90a3efca(string);
    }

    public static String I_method_a1486a60(Identifier identifier) {
        return IiiiiIiIi_Class246.I_method_506cddd6(identifier, "\n");
    }

    /*
     * Enabled aggressive exception aggregation
     */
    public static String I_method_506cddd6(Identifier identifier, String string) {
        try (InputStream inputStream = I_field_210493d.open(identifier);){
            String string2;
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));){
                string2 = bufferedReader.lines().collect(Collectors.joining(string));
            }
            return string2;
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }
}

