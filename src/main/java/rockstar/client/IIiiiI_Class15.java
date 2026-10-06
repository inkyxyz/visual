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
import rockstar.client.RockstarClient;

public final class IIiiiI_Class15 {
    private static final ResourceManager I_field_210493d = MinecraftClient.getInstance().getResourceManager();
    private static final Gson I_field_fbd77e28 = new Gson();

    public static Identifier I_method_fa9f2625(String string) {
        return RockstarClient.id("core/" + string);
    }

    public static <T> T I_method_f9c12ce8(Identifier identifier, Class<T> clazz) {
        return (T)I_field_fbd77e28.fromJson(IIiiiI_Class15.I_method_278a4ced(identifier), clazz);
    }

    public static String I_method_278a4ced(Identifier identifier) {
        return IIiiiI_Class15.I_method_d9921723(identifier, "\n");
    }

    /*
     * Enabled aggressive exception aggregation
     */
    public static String I_method_d9921723(Identifier identifier, String string) {
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

