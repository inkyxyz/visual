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

    public static class Marker {
        public String id;
        public String name;
        public String cords;
        public long timestamp;

        public Marker(String name, String cords) {
            this.id = UUID.randomUUID().toString();
            this.name = name;
            this.cords = cords;
            this.timestamp = System.currentTimeMillis();
        }

        public String getFormattedDate() {
            return new SimpleDateFormat("dd.MM HH:mm").format(new Date(this.timestamp));
        }
    }

    private static class StorageData {
        public List<Note> notes = new ArrayList<>();
        public List<Marker> markers = new ArrayList<>();
        public String quickNote = "";
    }

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final List<Note> NOTES = new ArrayList<>();
    private static final List<Marker> MARKERS = new ArrayList<>();
    private static String quickNote = "Заметки:\n- ";
    private static boolean loaded = false;

    private static File getStorageFile() {
        MinecraftClient mc = MinecraftClient.getInstance();
        File dir = new File(mc.runDirectory, "rockstar");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return new File(dir, "notes_v2.json");
    }

    public static synchronized List<Note> getNotes() {
        if (!loaded) {
            load();
        }
        return NOTES;
    }

    public static synchronized List<Marker> getMarkers() {
        if (!loaded) {
            load();
        }
        return MARKERS;
    }

    public static synchronized Marker addMarker(String name, String cords) {
        if (!loaded) load();
        Marker marker = new Marker(name, cords);
        MARKERS.add(0, marker);
        save();
        return marker;
    }

    public static synchronized void deleteMarker(String id) {
        if (!loaded) load();
        MARKERS.removeIf(m -> m.id.equals(id));
        save();
    }

    public static synchronized String getQuickNote() {
        if (!loaded) load();
        return quickNote;
    }

    public static synchronized void setQuickNote(String text) {
        if (!loaded) load();
        quickNote = text != null ? text : "";
        save();
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
            // Default initial content
            MARKERS.clear();
            MARKERS.add(new Marker("База", "X: 124, Y: 68, Z: -312 | Верхний мир"));
            quickNote = "Быстрые заметки:\n- Проверить сундуки на базе\n- Зачаровать новую кирку";
            save();
            return;
        }

        try (FileReader reader = new FileReader(file, StandardCharsets.UTF_8)) {
            StorageData data = GSON.fromJson(reader, StorageData.class);
            if (data != null) {
                NOTES.clear();
                if (data.notes != null) NOTES.addAll(data.notes);
                MARKERS.clear();
                if (data.markers != null) MARKERS.addAll(data.markers);
                if (data.quickNote != null) quickNote = data.quickNote;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized void save() {
        File file = getStorageFile();
        try (FileWriter writer = new FileWriter(file, StandardCharsets.UTF_8)) {
            StorageData data = new StorageData();
            data.notes.addAll(NOTES);
            data.markers.addAll(MARKERS);
            data.quickNote = quickNote;
            GSON.toJson(data, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
