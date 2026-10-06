package pyrock.classes;

import dev.redstones.mediaplayerinfo.IMediaSession;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.RockstarClient;
import rockstar.client.iiIiIIIiI_Class419;
import rockstar.client.iiIiIIIii_Class420;

public class PyMusic {
    public boolean active() {
        return PyMusic.snapshot() != null;
    }

    public boolean playing() {
        iiIiIIIiI_Class419.Nested1_a961800 nested1_a961800 = PyMusic.snapshot();
        return nested1_a961800 != null && nested1_a961800.I_method_1a22ebbe();
    }

    public double position() {
        iiIiIIIiI_Class419.Nested1_a961800 nested1_a961800 = PyMusic.snapshot();
        return nested1_a961800 == null ? 0.0 : nested1_a961800.I_method_1a22eba8();
    }

    public long positionMs() {
        return Math.round(this.position() * 1000.0);
    }

    public long duration() {
        iiIiIIIiI_Class419.Nested1_a961800 nested1_a961800 = PyMusic.snapshot();
        return nested1_a961800 == null ? 0L : nested1_a961800.I_method_1a22ebae();
    }

    public long durationMs() {
        return this.duration() * 1000L;
    }

    public double progress() {
        iiIiIIIiI_Class419.Nested1_a961800 nested1_a961800 = PyMusic.snapshot();
        if (nested1_a961800 == null || nested1_a961800.I_method_1a22ebae() <= 0L) {
            return 0.0;
        }
        return Math.clamp(nested1_a961800.I_method_1a22eba8() / (double)nested1_a961800.I_method_1a22ebae(), 0.0, 1.0);
    }

    public float bpm() {
        iiIiIIIiI_Class419.Nested1_a961800 nested1_a961800 = PyMusic.snapshot();
        return nested1_a961800 == null ? 0.0f : nested1_a961800.I_method_1a22ebaa();
    }

    public boolean lyricsSynced() {
        iiIiIIIiI_Class419.Nested1_a961800 nested1_a961800 = PyMusic.snapshot();
        return nested1_a961800 != null && nested1_a961800.I_method_3abb4910().i_method_27ca0e43();
    }

    @Nullable
    public ColorRGBA color() {
        iiIiIIIiI_Class419.Nested1_a961800 nested1_a961800 = PyMusic.snapshot();
        return nested1_a961800 == null ? null : nested1_a961800.I_method_5108ea29();
    }

    @Nullable
    public Identifier artwork() {
        iiIiIIIiI_Class419.Nested1_a961800 nested1_a961800 = PyMusic.snapshot();
        return nested1_a961800 == null ? null : nested1_a961800.I_method_77a14989();
    }

    @Nullable
    public Map<String, Object> current() {
        iiIiIIIiI_Class419.Nested1_a961800 nested1_a961800 = PyMusic.snapshot();
        return nested1_a961800 == null ? null : PyMusic.track(nested1_a961800);
    }

    public List<Map<String, Object>> lyrics() {
        iiIiIIIiI_Class419.Nested1_a961800 nested1_a961800 = PyMusic.snapshot();
        if (nested1_a961800 == null) {
            return List.of();
        }
        ArrayList<Map<String, Object>> arrayList = new ArrayList<Map<String, Object>>();
        for (iiIiIIIii_Class420.Nested1_a969040 nested1_a969040 : nested1_a961800.I_method_3abb4910().I_method_13376608()) {
            arrayList.add(PyMusic.line(nested1_a969040));
        }
        return arrayList;
    }

    @Nullable
    public Map<String, Object> lyricAt(double d) {
        long l;
        iiIiIIIiI_Class419.Nested1_a961800 nested1_a961800 = PyMusic.snapshot();
        if (nested1_a961800 == null || !nested1_a961800.I_method_3abb4910().i_method_27ca0e43()) {
            return null;
        }
        iiIiIIIii_Class420 iiIiIIIii_Class4202 = nested1_a961800.I_method_3abb4910();
        int n = iiIiIIIii_Class4202.I_method_cfb54038(l = Math.max(0L, Math.round(d)));
        if (n < 0) {
            return null;
        }
        Map<String, Object> map = PyMusic.line(iiIiIIIii_Class4202.I_method_13376608().get(n));
        long l2 = nested1_a961800.I_method_1a22ebae() * 1000L;
        map.put("index", n);
        map.put("progress", Float.valueOf(iiIiIIIii_Class4202.I_method_b76449ba(n, l, l2)));
        map.put("singing_progress", Float.valueOf(iiIiIIIii_Class4202.i_method_542bb1da(n, l, l2)));
        map.put("active", n == iiIiIIIii_Class4202.I_method_b7208e72(l, l2, 1000L));
        return map;
    }

    @Nullable
    public Map<String, Object> currentLyric() {
        return this.lyricAt(this.positionMs());
    }

    public boolean play() {
        return PyMusic.control(IMediaSession::play);
    }

    public boolean pause() {
        return PyMusic.control(IMediaSession::pause);
    }

    public boolean toggle() {
        return PyMusic.control(IMediaSession::playPause);
    }

    public boolean next() {
        return PyMusic.control(IMediaSession::next);
    }

    public boolean previous() {
        return PyMusic.control(IMediaSession::previous);
    }

    public boolean stop() {
        return PyMusic.control(IMediaSession::stop);
    }

    private static Map<String, Object> track(iiIiIIIiI_Class419.Nested1_a961800 nested1_a961800) {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<String, Object>();
        linkedHashMap.put("title", nested1_a961800.I_method_33e8b426());
        linkedHashMap.put("artist", nested1_a961800.i_method_c7076446());
        linkedHashMap.put("owner", nested1_a961800.II_method_4e87bc99());
        linkedHashMap.put("playing", nested1_a961800.I_method_1a22ebbe());
        linkedHashMap.put("position", nested1_a961800.I_method_1a22eba8());
        linkedHashMap.put("position_ms", Math.round(nested1_a961800.I_method_1a22eba8() * 1000.0));
        linkedHashMap.put("duration", nested1_a961800.I_method_1a22ebae());
        linkedHashMap.put("duration_ms", nested1_a961800.I_method_1a22ebae() * 1000L);
        linkedHashMap.put("progress", nested1_a961800.I_method_1a22ebae() <= 0L ? 0.0 : Math.clamp(nested1_a961800.I_method_1a22eba8() / (double)nested1_a961800.I_method_1a22ebae(), 0.0, 1.0));
        linkedHashMap.put("bpm", Float.valueOf(nested1_a961800.I_method_1a22ebaa()));
        linkedHashMap.put("color", nested1_a961800.I_method_5108ea29());
        linkedHashMap.put("artwork", nested1_a961800.I_method_77a14989());
        linkedHashMap.put("lyrics_synced", nested1_a961800.I_method_3abb4910().i_method_27ca0e43());
        linkedHashMap.put("has_lyrics", !nested1_a961800.I_method_3abb4910().I_method_27bb8263());
        return linkedHashMap;
    }

    private static Map<String, Object> line(iiIiIIIii_Class420.Nested1_a969040 nested1_a969040) {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<String, Object>();
        ArrayList arrayList = new ArrayList();
        for (iiIiIIIii_Class420.Nested1_a969020 nested1_a969020 : nested1_a969040.I_method_21c938d()) {
            LinkedHashMap<String, Number> linkedHashMap2 = new LinkedHashMap<String, Number>();
            linkedHashMap2.put("time_ms", nested1_a969020.I_method_1648878e());
            linkedHashMap2.put("char_index", nested1_a969020.I_method_1648878d());
            arrayList.add(linkedHashMap2);
        }
        linkedHashMap.put("time_ms", nested1_a969040.I_method_4ce39b6e());
        linkedHashMap.put("text", nested1_a969040.I_method_257c66());
        linkedHashMap.put("cues", arrayList);
        return linkedHashMap;
    }

    private static boolean control(Consumer<IMediaSession> consumer) {
        IMediaSession iMediaSession;
        iiIiIIIiI_Class419 iiIiIIIiI_Class4192 = PyMusic.tracker();
        IMediaSession iMediaSession2 = iMediaSession = iiIiIIIiI_Class4192 == null ? null : iiIiIIIiI_Class4192.I_method_9b92c97b();
        if (iMediaSession == null) {
            return false;
        }
        try {
            consumer.accept(iMediaSession);
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }

    @Nullable
    private static iiIiIIIiI_Class419 tracker() {
        return RockstarClient.getInstance().I_method_be969482();
    }

    @Nullable
    private static iiIiIIIiI_Class419.Nested1_a961800 snapshot() {
        iiIiIIIiI_Class419 iiIiIIIiI_Class4192 = PyMusic.tracker();
        return iiIiIIIiI_Class4192 == null ? null : iiIiIIIiI_Class4192.I_method_7effc530();
    }
}

