package rockstar.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import net.minecraft.client.MinecraftClient;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class NotesManager {

    public static class Note {
        public String id;
        public String title;
        public String content;
        public String cords;
        public long timestamp;

        public Note(String title, String content, String cords) {
            this.id = UUID.randomUUID().toString();
            this.title = title;
            this.content = content;
            this.cords = cords;
            this.timestamp = System.currentTimeMillis();
        }

        public String getFormattedDate() {
            return new SimpleDateFormat("dd.MM.yy HH:mm").format(new Date(this.timestamp));
        }
    }

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final List<Note> NOTES = new ArrayList<>();
    private static boolean loaded = false;

    private static File getStorageFile() {
        MinecraftClient mc = MinecraftClient.getInstance();
        File dir = new File(mc.runDirectory, "rockstar");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return new File(dir, "notes.json");
    }

    public static synchronized List<Note> getNotes() {
        if (!loaded) {
            load();
        }
        return NOTES;
    }

    public static synchronized Note createNote(String title, String content, String cords) {
        Note note = new Note(title, content, cords);
        NOTES.add(0, note);
        save();
        return note;
    }

    public static synchronized void deleteNote(String id) {
        NOTES.removeIf(n -> n.id.equals(id));
        save();
    }

    public static synchronized void updateNote(String id, String title, String content, String cords) {
        for (Note n : NOTES) {
            if (n.id.equals(id)) {
                n.title = title;
                n.content = content;
                if (cords != null && !cords.isEmpty()) {
                    n.cords = cords;
                }
                n.timestamp = System.currentTimeMillis();
                break;
            }
        }
        save();
    }

    public static synchronized void load() {
        loaded = true;
        File file = getStorageFile();
        if (!file.exists()) {
            // Initial default notes
            NOTES.clear();
            NOTES.add(new Note("Координаты базы", "Основной бункер и сундуки с ресурсами.\nНезерит в нижнем сундуке.", "X: 124, Y: 68, Z: -312 | Верхний мир"));
            NOTES.add(new Note("Список для крафта", "1. Тотемы бессмертия\n2. Золотые яблоки (чарки)\n3. Стрелы урона II\n4. Зелья скорости II и огнестойкости", ""));
            save();
            return;
        }

        try (FileReader reader = new FileReader(file, StandardCharsets.UTF_8)) {
            Type listType = new TypeToken<ArrayList<Note>>(){}.getType();
            List<Note> loadedList = GSON.fromJson(reader, listType);
            NOTES.clear();
            if (loadedList != null) {
                NOTES.addAll(loadedList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized void save() {
        File file = getStorageFile();
        try (FileWriter writer = new FileWriter(file, StandardCharsets.UTF_8)) {
            GSON.toJson(NOTES, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
