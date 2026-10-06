package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import lombok.Generated;
import net.minecraft.text.Text;
import rockstar.client.Setting;
import rockstar.client.IiIIiIII_Class73;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.ModuleEntry;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.iIIIIIIii_Class260;
import rockstar.client.iIIiIIiIi_Class294;

public class iiIIiIII_Class201
implements iIIiIIiIi_Class294 {
    private final File I_field_3a58077;
    private final String I_field_523beb0a;
    private final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.III_field_dd60aac);
    private final IiiiIiIii_Class236 i_field_dc7facc = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.III_field_dd60aac);

    public iiIIiIII_Class201(String string) {
        this.I_field_523beb0a = string;
        File file = new File(String.valueOf(IiIIiIII_Class73.I_field_3a58077) + "/presets", "swing");
        if (!file.exists()) {
            file.mkdir();
        }
        this.I_field_3a58077 = new File(file, string + ".%s".formatted("rock"));
    }

    public void I_method_84c8a0ec() {
        if (!this.I_field_3a58077.exists()) {
            RockstarClient.I_field_ab0f6068.warn("Config file not found: {}", (Object)this.I_field_3a58077.getAbsolutePath());
            return;
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.I_field_3a58077));){
            JsonObject jsonObject = JsonParser.parseReader((Reader)bufferedReader).getAsJsonObject();
            JsonObject jsonObject2 = jsonObject.getAsJsonObject("animation");
            for (Setting object2 : RockstarClient.getInstance().I_method_11732eb().I_method_94c3e7cb().getSettings()) {
                if (!jsonObject2.has(object2.getName())) continue;
                object2.fromJson(jsonObject2.get(object2.getName()));
            }
            JsonObject jsonObject3 = jsonObject.getAsJsonObject("startPhase");
            for (Setting iIiiiIIII_Class113 : RockstarClient.getInstance().I_method_11732eb().I_method_94b5d40b().getSettings()) {
                if (!jsonObject3.has(iIiiiIIII_Class113.getName())) continue;
                iIiiiIIII_Class113.fromJson(jsonObject3.get(iIiiiIIII_Class113.getName()));
            }
            JsonObject jsonObject4 = jsonObject.getAsJsonObject("endPhase");
            for (Setting iIiiiIIII_Class113 : RockstarClient.getInstance().I_method_11732eb().i_method_beb2642b().getSettings()) {
                if (!jsonObject4.has(iIiiiIIII_Class113.getName())) continue;
                iIiiiIIII_Class113.fromJson(jsonObject4.get(iIiiiIIII_Class113.getName()));
            }
            if (!this.I_field_523beb0a.equals("autosave")) {
                RockstarClient.getInstance().I_method_2da230b().I_method_7885936d(this);
            }
        }
        catch (Exception exception) {
            RockstarClient.I_field_ab0f6068.error("Failed to load config file {}: {}", (Object)this.I_field_523beb0a, (Object)exception.getMessage());
        }
    }

    public void i_method_84d72ccc() {
        try {
            JsonObject jsonObject = new JsonObject();
            JsonObject jsonObject2 = new JsonObject();
            for (Setting object2 : RockstarClient.getInstance().I_method_11732eb().I_method_94c3e7cb().getSettings()) {
                jsonObject2.add(object2.getName(), object2.toJson());
            }
            jsonObject.add("animation", (JsonElement)jsonObject2);
            JsonObject jsonObject3 = new JsonObject();
            for (Setting iIiiiIIII_Class113 : RockstarClient.getInstance().I_method_11732eb().I_method_94b5d40b().getSettings()) {
                jsonObject3.add(iIiiiIIII_Class113.getName(), iIiiiIIII_Class113.toJson());
            }
            jsonObject.add("startPhase", (JsonElement)jsonObject3);
            JsonObject jsonObject4 = new JsonObject();
            for (Setting iIiiiIIII_Class113 : RockstarClient.getInstance().I_method_11732eb().i_method_beb2642b().getSettings()) {
                jsonObject4.add(iIiiiIIII_Class113.getName(), iIiiiIIII_Class113.toJson());
            }
            jsonObject.add("endPhase", (JsonElement)jsonObject4);
            IiIIiIII_Class73.I_method_3b2973c6(this.I_field_3a58077, (JsonElement)jsonObject);
            System.out.println("saved");
            if (!this.I_field_523beb0a.equals("autosave")) {
                RockstarClient.getInstance().I_method_2da230b().I_method_7885936d(this);
            }
        }
        catch (IOException iOException) {
            RockstarClient.I_field_ab0f6068.error("Failed to save config file", (Throwable)iOException);
        }
    }

    public void II_method_145a73f5() {
        Path path = this.I_field_3a58077.toPath();
        try {
            Files.delete(path);
            RockstarClient.getInstance().I_method_2da230b().I_method_43006bfb().remove(this);
            RockstarClient.I_field_ab0f6068.info("Config file deleted: {}", (Object)path);
        }
        catch (NoSuchFileException noSuchFileException) {
            RockstarClient.I_field_ab0f6068.warn("Tried to delete a file that does not exist: {}", (Object)path);
        }
        catch (IOException iOException) {
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("swing_anim.delete_error")));
            RockstarClient.I_field_ab0f6068.warn("Failed to delete config file: {}. Reason: {}", (Object)path, (Object)iOException.getMessage());
        }
    }

    private JsonObject I_method_e52f13d5(ModuleEntry iiIiiIii_Class92) {
        JsonObject jsonObject = new JsonObject();
        for (Setting iIiiiIIII_Class113 : iiIiiIii_Class92.getSettings()) {
            jsonObject.add(iIiiiIIII_Class113.getName(), iIiiiIIII_Class113.toJson());
        }
        return jsonObject;
    }

    @Generated
    public File I_method_79d503a1() {
        return this.I_field_3a58077;
    }

    @Generated
    public String I_method_5141c934() {
        return this.I_field_523beb0a;
    }

    @Generated
    public IiiiIiIii_Class236 I_method_e8886be2() {
        return this.I_field_dc7facc;
    }

    @Generated
    public IiiiIiIii_Class236 i_method_fe1ddfc2() {
        return this.i_field_dc7facc;
    }
}

