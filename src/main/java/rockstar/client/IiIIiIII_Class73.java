package rockstar.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import net.minecraft.client.MinecraftClient;
import rockstar.client.IiIIIiii_Class72;
import rockstar.client.IiIIiIiI_Class75;
import rockstar.client.IiIIiIii_Class76;
import rockstar.client.RockstarClient;
import ua.mintantileak.spk.Compile;

public class IiIIiIII_Class73 {
    public static final Gson I_field_fbd77e28 = new GsonBuilder().setPrettyPrinting().create();
    public static final File I_field_3a58077 = new File(MinecraftClient.getInstance().runDirectory, "Rockstar");
    public static final String I_field_523beb0a = "rock";
    private final List<IiIIIiii_Class72> I_field_7865b31 = new ArrayList<IiIIIiii_Class72>();

    public IiIIiIII_Class73() {
        try {
            if (!I_field_3a58077.exists()) {
                Files.createDirectories(Path.of(I_field_3a58077.toURI()), new FileAttribute[0]);
            }
        }
        catch (IOException iOException) {
            System.err.println("Error creating directory: " + iOException.getMessage());
        }
    }

    public static void I_method_3b2973c6(File file, JsonElement jsonElement) throws IOException {
        IiIIiIII_Class73.I_method_a06f044d(file, I_field_fbd77e28.toJson(jsonElement));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void I_method_a06f044d(File file, String string) throws IOException {
        Path path = file.toPath();
        Path path2 = path.getParent();
        if (path2 != null) {
            Files.createDirectories(path2, new FileAttribute[0]);
        }
        Path path3 = path2 == null ? Files.createTempFile(file.getName(), ".tmp", new FileAttribute[0]) : Files.createTempFile(path2, file.getName(), ".tmp", new FileAttribute[0]);
        try {
            Files.writeString(path3, (CharSequence)string, StandardCharsets.UTF_8, new OpenOption[0]);
            try {
                Files.move(path3, path, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
            }
            catch (AtomicMoveNotSupportedException atomicMoveNotSupportedException) {
                Files.move(path3, path, StandardCopyOption.REPLACE_EXISTING);
            }
        }
        finally {
            Files.deleteIfExists(path3);
        }
    }

    @Compile(obfuscation=4)
    public void I_method_b467d0cc() {
        this.I_field_7865b31.add(new IiIIiIiI_Class75());
        this.I_field_7865b31.add(new IiIIiIii_Class76());
    }

    public IiIIIiii_Class72 I_method_3272b401(String string) {
        return this.I_field_7865b31.stream().filter(iiIIIiii_Class72 -> iiIIIiii_Class72.I_method_a49657eb().I_method_81df7d74().equalsIgnoreCase(string)).findFirst().orElse(null);
    }

    public void I_method_516d7f0d(IiIIIiii_Class72 iiIIIiii_Class72) {
        try {
            if (iiIIIiii_Class72.I_method_aa990001().exists()) {
                iiIIIiii_Class72.i_method_fb70946c();
            }
        }
        catch (Exception exception) {
            System.err.println("Error reading file: " + exception.getMessage());
        }
    }

    public void I_method_de9edf96(String string) {
        IiIIIiii_Class72 iiIIIiii_Class72 = this.I_method_3272b401(string);
        if (iiIIIiii_Class72 != null) {
            this.I_method_516d7f0d(iiIIIiii_Class72);
        }
    }

    public void i_method_6702f2ed(IiIIIiii_Class72 iiIIIiii_Class72) {
        try {
            iiIIIiii_Class72.I_method_fb62088c();
        }
        catch (Exception exception) {
            System.err.println("Error saving file: " + exception.getMessage());
        }
    }

    public void i_method_af563376(String string) {
        IiIIIiii_Class72 iiIIIiii_Class72 = this.I_method_3272b401(string);
        if (iiIIIiii_Class72 != null) {
            if (iiIIIiii_Class72 instanceof IiIIiIiI_Class75 && RockstarClient.getInstance().I_method_789852eb() != null) {
                RockstarClient.getInstance().I_method_789852eb().II_method_d4269835();
            }
            this.i_method_6702f2ed(iiIIIiii_Class72);
        }
    }

    @Compile(obfuscation=4)
    public void i_method_b4765cac() {
        for (IiIIIiii_Class72 iiIIIiii_Class72 : this.I_field_7865b31) {
            this.I_method_516d7f0d(iiIIIiii_Class72);
        }
    }

    public void II_method_d8a14015() {
        for (IiIIIiii_Class72 iiIIIiii_Class72 : this.I_field_7865b31) {
            this.i_method_6702f2ed(iiIIIiii_Class72);
        }
    }

    @Generated
    public List<IiIIIiii_Class72> I_method_95c0cffb() {
        return this.I_field_7865b31;
    }
}

