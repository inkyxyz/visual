package rockstar.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.MathHelper;
import pyrock.utility.render.ColorRGBA;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;

/**
 * Centralized manager for Global Client Themes, Backgrounds/Wallpapers, and iOS Icon Styles.
 * Persists settings and coordinates instant live updates across ALL menus.
 */
public class ThemeAndBackgroundManager {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static ThemeAndBackgroundManager INSTANCE;

    // ==========================================
    // 1. THEMES DEFINITION (8 Handcrafted Apple/Cyber Themes)
    // ==========================================
    public record ThemePreset(String name, ColorRGBA color, ColorRGBA secondaryColor) {}

    public static final ThemePreset[] THEMES = new ThemePreset[]{
        new ThemePreset("Electric Purple", new ColorRGBA(168.0F, 85.0F, 247.0F, 255.0F), new ColorRGBA(192.0F, 132.0F, 252.0F, 255.0F)),
        new ThemePreset("Cyan Glow",       new ColorRGBA(6.0F, 182.0F, 212.0F, 255.0F),   new ColorRGBA(34.0F, 211.0F, 238.0F, 255.0F)),
        new ThemePreset("Sunset Orange",   new ColorRGBA(249.0F, 115.0F, 22.0F, 255.0F),  new ColorRGBA(251.0F, 146.0F, 60.0F, 255.0F)),
        new ThemePreset("Emerald Green",   new ColorRGBA(16.0F, 185.0F, 129.0F, 255.0F),  new ColorRGBA(52.0F, 211.0F, 153.0F, 255.0F)),
        new ThemePreset("Rose Pink",       new ColorRGBA(244.0F, 63.0F, 94.0F, 255.0F),   new ColorRGBA(251.0F, 113.0F, 133.0F, 255.0F)),
        new ThemePreset("Ice Blue",        new ColorRGBA(56.0F, 189.0F, 248.0F, 255.0F),  new ColorRGBA(125.0F, 211.0F, 252.0F, 255.0F)),
        new ThemePreset("Crimson Red",     new ColorRGBA(239.0F, 68.0F, 68.0F, 255.0F),   new ColorRGBA(248.0F, 113.0F, 113.0F, 255.0F)),
        new ThemePreset("Royal Gold",      new ColorRGBA(245.0F, 158.0F, 11.0F, 255.0F),  new ColorRGBA(251.0F, 191.0F, 36.0F, 255.0F))
    };

    // ==========================================
    // 2. BACKGROUNDS / WALLPAPERS
    // ==========================================
    public static final String[] BACKGROUND_NAMES = new String[]{
        "Размытый мир (Авто)",
        "Twilight Lagoon",
        "Creeper Hollow",
        "Amber Windmill",
        "Coral Abyss",
        "Ancient Nether",
        "Twilight Castle",
        "Sakura Grove",
        "Lush Caves",
        "Snowy Taiga",
        "Sunset Campfire",
        "Emerald Deep",
        "Crimson Forest",
        "End Void",
        "Glacial Highlands",
        "Autumn Sanctuary",
        "Abyssal Trench",
        "Starlight Blossom"
    };

    // ==========================================
    // 3. IOS ICON PACK STYLES
    // ==========================================
    public static final String[] ICON_STYLES = new String[]{
        "iOS Cupertino",
        "iOS Neon Glow",
        "iOS Minimal Glass"
    };

    // State
    private int themeIndex = 0;
    private int backgroundIndex = 0;
    private int iconStyleIndex = 0;

    public static synchronized ThemeAndBackgroundManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ThemeAndBackgroundManager();
            INSTANCE.load();
        }
        return INSTANCE;
    }

    public ThemeAndBackgroundManager() {
        // Default to Electric Purple
        this.themeIndex = 0;
        this.backgroundIndex = 0;
        this.iconStyleIndex = 0;
    }

    public int getThemeIndex() {
        return this.themeIndex;
    }

    public ThemePreset getCurrentTheme() {
        return THEMES[MathHelper.clamp(this.themeIndex, 0, THEMES.length - 1)];
    }

    public ColorRGBA getThemeColor() {
        return getCurrentTheme().color();
    }

    public ColorRGBA getThemeSecondaryColor() {
        return getCurrentTheme().secondaryColor();
    }

    public void setThemeIndex(int index) {
        this.themeIndex = MathHelper.clamp(index, 0, THEMES.length - 1);
        ColorRGBA col = getCurrentTheme().color();
        IiiiiIIIi_Class242.I_method_300b2840(col);
        this.save();
    }

    public void nextTheme() {
        setThemeIndex((this.themeIndex + 1) % THEMES.length);
    }

    public int getBackgroundIndex() {
        return this.backgroundIndex;
    }

    public String getCurrentBackgroundName() {
        return BACKGROUND_NAMES[MathHelper.clamp(this.backgroundIndex, 0, BACKGROUND_NAMES.length - 1)];
    }

    public void setBackgroundIndex(int index) {
        this.backgroundIndex = MathHelper.clamp(index, 0, BACKGROUND_NAMES.length - 1);
        IiiIIiiIi_Class206 wp = IiiIIiIii_Class204.getWallpaperManager();
        if (wp != null && this.backgroundIndex > 0) {
            wp.setWallpaperIndex(this.backgroundIndex - 1);
        }
        this.save();
    }

    public void nextBackground() {
        setBackgroundIndex((this.backgroundIndex + 1) % BACKGROUND_NAMES.length);
    }

    public int getIconStyleIndex() {
        return this.iconStyleIndex;
    }

    public String getCurrentIconStyleName() {
        return ICON_STYLES[MathHelper.clamp(this.iconStyleIndex, 0, ICON_STYLES.length - 1)];
    }

    public void setIconStyleIndex(int index) {
        this.iconStyleIndex = MathHelper.clamp(index, 0, ICON_STYLES.length - 1);
        this.save();
    }

    public void nextIconStyle() {
        setIconStyleIndex((this.iconStyleIndex + 1) % ICON_STYLES.length);
    }

    /**
     * Renders the unified active background across any screen (Escape, Options, Loading, etc.)
     */
    public void renderActiveBackground(III custom, int width, int height, float mouseX, float mouseY) {
        MinecraftClient mc = MinecraftClient.getInstance();
        boolean inWorld = mc != null && mc.world != null;

        if (this.backgroundIndex == 0) {
            // Dynamic: in game world draw subtle frosted blur, otherwise wallpaper
            if (inWorld) {
                custom.drawRect(0.0F, 0.0F, (float)width, (float)height, new ColorRGBA(4.0F, 6.0F, 12.0F, 85.0F));
            } else {
                IiiIIiIii_Class204.renderWallpaperBackground(custom, width, height, mouseX, mouseY);
                custom.drawRect(0.0F, 0.0F, (float)width, (float)height, new ColorRGBA(4.0F, 6.0F, 12.0F, 100.0F));
            }
        } else {
            // Explicit Wallpaper selected by user
            IiiIIiiIi_Class206 wp = IiiIIiIii_Class204.getWallpaperManager();
            if (wp != null) {
                wp.setWallpaperIndex(this.backgroundIndex - 1);
            }
            IiiIIiIii_Class204.renderWallpaperBackground(custom, width, height, mouseX, mouseY);
            custom.drawRect(0.0F, 0.0F, (float)width, (float)height, new ColorRGBA(4.0F, 6.0F, 12.0F, 80.0F));
        }
    }

    // ==========================================
    // PERSISTENCE
    // ==========================================
    private static class DataHolder {
        int theme = 0;
        int background = 0;
        int iconStyle = 0;
    }

    private static File getConfigFile() {
        MinecraftClient mc = MinecraftClient.getInstance();
        File dir = new File(mc != null ? mc.runDirectory : new File("."), "rockstar");
        if (!dir.exists()) dir.mkdirs();
        return new File(dir, "theme_settings.json");
    }

    public synchronized void load() {
        try {
            File file = getConfigFile();
            if (file.exists()) {
                try (FileReader reader = new FileReader(file, StandardCharsets.UTF_8)) {
                    DataHolder data = GSON.fromJson(reader, DataHolder.class);
                    if (data != null) {
                        this.themeIndex = MathHelper.clamp(data.theme, 0, THEMES.length - 1);
                        this.backgroundIndex = MathHelper.clamp(data.background, 0, BACKGROUND_NAMES.length - 1);
                        this.iconStyleIndex = MathHelper.clamp(data.iconStyle, 0, ICON_STYLES.length - 1);
                    }
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        // Apply theme color on load
        IiiiiIIIi_Class242.I_method_300b2840(getCurrentTheme().color());
    }

    public synchronized void save() {
        try {
            File file = getConfigFile();
            try (FileWriter writer = new FileWriter(file, StandardCharsets.UTF_8)) {
                DataHolder data = new DataHolder();
                data.theme = this.themeIndex;
                data.background = this.backgroundIndex;
                data.iconStyle = this.iconStyleIndex;
                GSON.toJson(data, writer);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
