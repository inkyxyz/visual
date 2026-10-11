package rockstar.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.client.MinecraftClient;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;

public class EscapeMenuConfig {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static EscapeMenuConfig INSTANCE;

    public boolean showMediaPlayer = true;
    public boolean showCamera = true;
    public boolean showFullscreen = true;
    public boolean showVolume = true;
    public boolean showCalculator = true;
    public boolean showWeatherAlerts = true;
    public boolean showAIChat = true;
    public boolean showNotes = true;
    public boolean showGames = true;
    public String weatherCity = "Киев"; // Киев, Москва, Харьков, СПб, Одесса, Львов
    public String alertScope = "Все";   // Все, Украина, Россия
    public boolean dimBackground = true;

    public static synchronized EscapeMenuConfig getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EscapeMenuConfig();
            INSTANCE.load();
        }
        return INSTANCE;
    }

    private static File getConfigFile() {
        MinecraftClient mc = MinecraftClient.getInstance();
        File dir = new File(mc.runDirectory, "rockstar");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return new File(dir, "escape_menu.json");
    }

    public synchronized void load() {
        File file = getConfigFile();
        if (file.exists()) {
            try (FileReader reader = new FileReader(file, StandardCharsets.UTF_8)) {
                EscapeMenuConfig loaded = GSON.fromJson(reader, EscapeMenuConfig.class);
                if (loaded != null) {
                    this.showMediaPlayer = loaded.showMediaPlayer;
                    this.showCamera = loaded.showCamera;
                    this.showFullscreen = loaded.showFullscreen;
                    this.showVolume = loaded.showVolume;
                    this.showCalculator = loaded.showCalculator;
                    this.showWeatherAlerts = loaded.showWeatherAlerts;
                    this.showAIChat = loaded.showAIChat;
                    this.showNotes = loaded.showNotes;
                    this.showGames = loaded.showGames;
                    if (loaded.weatherCity != null) this.weatherCity = loaded.weatherCity;
                    if (loaded.alertScope != null) this.alertScope = loaded.alertScope;
                    this.dimBackground = loaded.dimBackground;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void save() {
        File file = getConfigFile();
        try (FileWriter writer = new FileWriter(file, StandardCharsets.UTF_8)) {
            GSON.toJson(this, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
