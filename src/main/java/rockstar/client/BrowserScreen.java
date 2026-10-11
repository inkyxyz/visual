package rockstar.client;

import java.awt.GraphicsEnvironment;
import java.io.File;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.Util;
import org.lwjgl.glfw.GLFW;
import pyrock.utility.render.ColorRGBA;

public class BrowserScreen extends ii_Class4 {
    private final Screen parentScreen;
    private String currentUrl;
    private String searchQuery;
    private boolean isEditingUrl = false;

    private static class WebShortcut {
        final String name;
        final String url;
        final String desc;
        final String iconName;
        final ColorRGBA accent;

        WebShortcut(String name, String url, String desc, String iconName, ColorRGBA accent) {
            this.name = name;
            this.url = url;
            this.desc = desc;
            this.iconName = iconName;
            this.accent = accent;
        }
    }

    private final List<WebShortcut> shortcuts = new ArrayList<>();

    public BrowserScreen(Screen parentScreen, String query) {
        this.parentScreen = parentScreen;
        this.searchQuery = (query != null && !query.trim().isEmpty()) ? query.trim() : "";
        this.currentUrl = resolveUrl(this.searchQuery);

        initShortcuts();

        // If a query was passed, launch real browser in app-mode immediately
        if (!this.searchQuery.isEmpty()) {
            openInRealBrowser(this.currentUrl);
        }
    }

    private void initShortcuts() {
        this.shortcuts.clear();
        this.shortcuts.add(new WebShortcut("YouTube", "https://youtube.com", "Смотрите видео, стримы и музыку", "play", new ColorRGBA(239.0F, 68.0F, 68.0F, 255.0F)));
        this.shortcuts.add(new WebShortcut("Google", "https://google.com", "Поиск по всей всемирной сети", "search", new ColorRGBA(59.0F, 130.0F, 246.0F, 255.0F)));
        this.shortcuts.add(new WebShortcut("ВКонтакте", "https://vk.com", "Сообщения, треки и сообщества", "language", new ColorRGBA(6.0F, 182.0F, 212.0F, 255.0F)));
        this.shortcuts.add(new WebShortcut("Twitch", "https://twitch.tv", "Прямые эфиры и киберспорт", "play", new ColorRGBA(168.0F, 85.0F, 247.0F, 255.0F)));
        this.shortcuts.add(new WebShortcut("Minecraft Wiki", "https://minecraft.wiki", "База знаний, рецепты и механики", "info", new ColorRGBA(16.0F, 185.0F, 129.0F, 255.0F)));
        this.shortcuts.add(new WebShortcut("GitHub", "https://github.com", "Платформа проектов и исходного кода", "cube", new ColorRGBA(148.0F, 163.0F, 184.0F, 255.0F)));
        this.shortcuts.add(new WebShortcut("Discord", "https://discord.com/channels/@me", "Голосовые каналы и чаты", "language", new ColorRGBA(99.0F, 102.0F, 241.0F, 255.0F)));
        this.shortcuts.add(new WebShortcut("FunTime", "https://funtime.su", "Анархия, донат и аукционы сервера", "setting", new ColorRGBA(245.0F, 158.0F, 11.0F, 255.0F)));
    }

    private static String resolveUrl(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "https://www.google.com";
        }
        String s = input.trim();
        if (s.startsWith("http://") || s.startsWith("https://")) {
            return s;
        }
        if (!s.contains(" ") && (s.contains(".com") || s.contains(".ru") || s.contains(".net") ||
            s.contains(".org") || s.contains(".io") || s.contains(".gg") || s.contains(".su") ||
            s.contains(".tv") || s.contains(".wiki") || s.contains(".dev") || s.contains(".pub"))) {
            return "https://" + s;
        }
        return "https://www.google.com/search?q=" + URLEncoder.encode(s, StandardCharsets.UTF_8);
    }

    public static void openInRealBrowser(String targetUrl) {
        String cleanUrl = resolveUrl(targetUrl);

        // 1. Try launching Edge in dedicated App-Window mode (Chromium window without browser clutter)
        try {
            String os = System.getProperty("os.name", "").toLowerCase();
            if (os.contains("win")) {
                File edge1 = new File("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
                File edge2 = new File("C:\\Program Files\\Microsoft\\Edge\\Application\\msedge.exe");
                String edgePath = edge1.exists() ? edge1.getAbsolutePath() : (edge2.exists() ? edge2.getAbsolutePath() : null);

                if (edgePath != null) {
                    new ProcessBuilder(edgePath, "--app=" + cleanUrl).start();
                    return;
                }
            }
        } catch (Throwable ignored) {}

        // 2. Try launching Chrome in App-Window mode
        try {
            String os = System.getProperty("os.name", "").toLowerCase();
            if (os.contains("win")) {
                File chrome1 = new File("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
                File chrome2 = new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
                String chromePath = chrome1.exists() ? chrome1.getAbsolutePath() : (chrome2.exists() ? chrome2.getAbsolutePath() : null);

                if (chromePath != null) {
                    new ProcessBuilder(chromePath, "--app=" + cleanUrl).start();
                    return;
                }
            }
        } catch (Throwable ignored) {}

        // 3. Fallback to OS default browser via Minecraft's native URI handler
        try {
            Util.getOperatingSystem().open(URI.create(cleanUrl));
        } catch (Throwable ignored) {}
    }

    @Override
    public void render(III custom) {
        // Dark frosted backdrop
        custom.drawRect(0.0F, 0.0F, (float)this.width, (float)this.height, new ColorRGBA(12.0F, 16.0F, 24.0F, 245.0F));

        IIiIIi_Class10 headerFont = null;
        IIiIIi_Class10 titleFont = null;
        IIiIIi_Class10 font = null;
        IIiIIi_Class10 subFont = null;
        try {
            if (IIiIiI_Class11.i_field_857c0621 != null) {
                headerFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(16.0F);
                titleFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(12.0F);
                font = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(9.5F);
                subFont = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.5F);
            }
        } catch (Throwable ignored) {}

        float cx = this.width / 2.0F;

        // --- 1. TOP MATTE FROSTED HEADER ---
        float topH = 46.0F;
        custom.drawShadow(0.0F, 0.0F, (float)this.width, topH, 14.0F, IIiii_Class8.I_method_893b2757(0.0F), new ColorRGBA(0.0F, 0.0F, 0.0F, 80.0F));
        custom.drawBlurredRect(0.0F, 0.0F, (float)this.width, topH, 16.0F, 2.0F, IIiii_Class8.I_method_893b2757(0.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F));
        custom.drawRect(0.0F, 0.0F, (float)this.width, topH, new ColorRGBA(18.0F, 22.0F, 34.0F, 230.0F));
        custom.drawRect(0.0F, topH - 1.0F, (float)this.width, 1.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 35.0F));

        // Brand Pill
        if (headerFont != null) {
            custom.drawText(headerFont, "🌐 Agravity Браузер", 16.0F, 14.0F, ColorRGBA.WHITE);
        }

        // Search Input Box in Center of Top Bar
        float inW = Math.min(380.0F, (float)this.width - 240.0F);
        float inX = cx - inW / 2.0F;
        float inY = 9.0F;
        float inH = 28.0F;
        IIiii_Class8 inRad = IIiii_Class8.I_method_893b2757(8.0F);

        custom.drawRoundedRect(inX, inY, inW, inH, inRad, new ColorRGBA(26.0F, 32.0F, 48.0F, 220.0F));
        custom.drawRoundedBorder(inX, inY, inW, inH, 1.0F, inRad, this.isEditingUrl ? new ColorRGBA(168.0F, 85.0F, 247.0F, 230.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F));

        if (font != null) {
            String prompt = this.searchQuery.isEmpty() ? (this.isEditingUrl ? "" : "🔍 Введите запрос или сайт (Enter)...") : this.searchQuery;
            if (this.isEditingUrl && (System.currentTimeMillis() % 1000L < 500L)) prompt += "|";
            ColorRGBA col = this.searchQuery.isEmpty() ? new ColorRGBA(255.0F, 255.0F, 255.0F, 140.0F) : ColorRGBA.WHITE;
            custom.drawText(font, prompt, inX + 10.0F, inY + 8.5F, col);
        }

        // Close / Return to Game Button [ ✕ Назад ]
        float closeW = 74.0F;
        float closeX = (float)this.width - closeW - 14.0F;
        float closeY = 10.0F;
        float closeH = 26.0F;
        IIiii_Class8 cRad = IIiii_Class8.I_method_893b2757(6.0F);

        boolean cHov = (custom.I_method_b1c3e152() >= closeX && custom.I_method_b1c3e152() <= closeX + closeW && custom.i_method_b1d26d32() >= closeY && custom.i_method_b1d26d32() <= closeY + closeH);
        custom.drawRoundedRect(closeX, closeY, closeW, closeH, cRad, new ColorRGBA(235.0F, 55.0F, 50.0F, cHov ? 240.0F : 190.0F));
        custom.drawRoundedBorder(closeX, closeY, closeW, closeH, 1.0F, cRad, new ColorRGBA(255.0F, 255.0F, 255.0F, cHov ? 220.0F : 80.0F));
        if (font != null) {
            custom.drawText(font, "✕ Закрыть", closeX + 11.0F, closeY + 7.5F, ColorRGBA.WHITE);
        }

        // --- 2. MAIN CENTER DASHBOARD: QUICK SHORTCUT TILES ---
        if (titleFont != null) {
            custom.drawText(titleFont, "Быстрый переход и популярные сервисы", cx - titleFont.I_method_2c375926("Быстрый переход и популярные сервисы") / 2.0F, 66.0F, ColorRGBA.WHITE);
        }
        if (subFont != null) {
            String hint = "Нажмите на любой сервис или введите адрес вверху — сайт откроется прямо в окне";
            custom.drawText(subFont, hint, cx - subFont.I_method_2c375926(hint) / 2.0F, 82.0F, new ColorRGBA(160.0F, 175.0F, 205.0F, 190.0F));
        }

        // 8 Matte Frosted Grid Cards (2 rows x 4 cols)
        float gridStartX = cx - 290.0F;
        float gridStartY = 106.0F;
        float cardW = 138.0F;
        float cardH = 68.0F;
        float gapX = 12.0F;
        float gapY = 12.0F;

        for (int i = 0; i < this.shortcuts.size(); i++) {
            WebShortcut sc = this.shortcuts.get(i);
            int row = i / 4;
            int col = i % 4;
            float kx = gridStartX + col * (cardW + gapX);
            float ky = gridStartY + row * (cardH + gapY);

            boolean kHov = (custom.I_method_b1c3e152() >= kx && custom.I_method_b1c3e152() <= kx + cardW && custom.i_method_b1d26d32() >= ky && custom.i_method_b1d26d32() <= ky + cardH);
            IIiii_Class8 kRad = IIiii_Class8.I_method_893b2757(12.0F);

            custom.drawShadow(kx, ky, cardW, cardH, 14.0F, kRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 80.0F));
            custom.drawBlurredRect(kx, ky, cardW, cardH, 12.0F, 2.0F, kRad, sc.accent.withAlpha(25.0F));
            custom.drawRoundedRect(kx, ky, cardW, cardH, kRad, new ColorRGBA(18.0F, 24.0F, 36.0F, kHov ? 250.0F : 210.0F));
            custom.drawRoundedBorder(kx, ky, cardW, cardH, 1.2F, kRad, kHov ? sc.accent : new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F));

            // Accent Pill on left
            custom.drawRoundedRect(kx + 8.0F, ky + 8.0F, 26.0F, 26.0F, IIiii_Class8.I_method_893b2757(7.0F), sc.accent.withAlpha(40.0F));
            custom.drawIcon(sc.iconName, kx + 13.0F, ky + 13.0F, 16.0F, sc.accent);

            // Title and Description
            if (titleFont != null) {
                custom.drawText(titleFont, sc.name, kx + 40.0F, ky + 13.0F, ColorRGBA.WHITE);
            }
            if (subFont != null) {
                String desc = sc.desc;
                if (desc.length() > 20) desc = desc.substring(0, 19) + "…";
                custom.drawText(subFont, desc, kx + 10.0F, ky + 44.0F, new ColorRGBA(160.0F, 175.0F, 200.0F, 190.0F));
            }
        }

        // --- 3. BOTTOM GOOGLE SEARCH ACTION CARD ---
        float gCardW = 588.0F;
        float gCardH = 54.0F;
        float gCardX = cx - gCardW / 2.0F;
        float gCardY = gridStartY + 2 * (cardH + gapY) + 12.0F;
        IIiii_Class8 gRad = IIiii_Class8.I_method_893b2757(12.0F);

        custom.drawShadow(gCardX, gCardY, gCardW, gCardH, 14.0F, gRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 90.0F));
        custom.drawBlurredRect(gCardX, gCardY, gCardW, gCardH, 14.0F, 2.0F, gRad, new ColorRGBA(59.0F, 130.0F, 246.0F, 30.0F));
        custom.drawRoundedRect(gCardX, gCardY, gCardW, gCardH, gRad, new ColorRGBA(20.0F, 26.0F, 40.0F, 220.0F));
        custom.drawRoundedBorder(gCardX, gCardY, gCardW, gCardH, 1.2F, gRad, new ColorRGBA(59.0F, 130.0F, 246.0F, 160.0F));

        if (titleFont != null) {
            String actText = this.searchQuery.isEmpty() ? "Нажмите Enter для поиска в Google" : ("Открыть поиск по запросу «" + this.searchQuery + "»");
            custom.drawText(titleFont, actText, gCardX + 16.0F, gCardY + 14.0F, ColorRGBA.WHITE);
        }
        if (subFont != null) {
            custom.drawText(subFont, "Открывает полноценный браузер без лагов прямо поверх игры", gCardX + 16.0F, gCardY + 32.0F, new ColorRGBA(160.0F, 185.0F, 220.0F, 200.0F));
        }

        // Blue Open Button on right
        float opW = 100.0F;
        float opH = 28.0F;
        float opX = gCardX + gCardW - opW - 14.0F;
        float opY = gCardY + 13.0F;
        boolean opHov = (custom.I_method_b1c3e152() >= opX && custom.I_method_b1c3e152() <= opX + opW && custom.i_method_b1d26d32() >= opY && custom.i_method_b1d26d32() <= opY + opH);

        custom.drawRoundedRect(opX, opY, opW, opH, IIiii_Class8.I_method_893b2757(6.0F), new ColorRGBA(0.0F, 122.0F, 255.0F, opHov ? 255.0F : 210.0F));
        custom.drawRoundedBorder(opX, opY, opW, opH, 1.0F, IIiii_Class8.I_method_893b2757(6.0F), ColorRGBA.WHITE.withAlpha(opHov ? 255.0F : 120.0F));
        if (font != null) {
            custom.drawText(font, "▶ Открыть", opX + 22.0F, opY + 8.5F, ColorRGBA.WHITE);
        }
    }

    @Override
    public void onMouseClicked(double mouseX, double mouseY, IiIII_Class9 button) {
        if (button != IiIII_Class9.I_field_2f4c8d6c) return;
        float cx = this.width / 2.0F;

        // 1. Close Button
        float closeW = 74.0F;
        float closeX = (float)this.width - closeW - 14.0F;
        float closeY = 10.0F;
        float closeH = 26.0F;
        if (mouseX >= closeX && mouseX <= closeX + closeW && mouseY >= closeY && mouseY <= closeY + closeH) {
            UISoundManager.playButtonClick();
            this.close();
            return;
        }

        // 2. URL / Search Input Focus
        float inW = Math.min(380.0F, (float)this.width - 240.0F);
        float inX = cx - inW / 2.0F;
        float inY = 9.0F;
        float inH = 28.0F;
        if (mouseX >= inX && mouseX <= inX + inW && mouseY >= inY && mouseY <= inY + inH) {
            this.isEditingUrl = true;
            UISoundManager.playButtonClick();
            return;
        } else {
            this.isEditingUrl = false;
        }

        // 3. Shortcuts Click
        float gridStartX = cx - 290.0F;
        float gridStartY = 106.0F;
        float cardW = 138.0F;
        float cardH = 68.0F;
        float gapX = 12.0F;
        float gapY = 12.0F;

        for (int i = 0; i < this.shortcuts.size(); i++) {
            WebShortcut sc = this.shortcuts.get(i);
            int row = i / 4;
            int col = i % 4;
            float kx = gridStartX + col * (cardW + gapX);
            float ky = gridStartY + row * (cardH + gapY);

            if (mouseX >= kx && mouseX <= kx + cardW && mouseY >= ky && mouseY <= ky + cardH) {
                UISoundManager.playButtonClick();
                openInRealBrowser(sc.url);
                return;
            }
        }

        // 4. Bottom Search Action Card Click
        float gCardW = 588.0F;
        float gCardH = 54.0F;
        float gCardX = cx - gCardW / 2.0F;
        float gCardY = gridStartY + 2 * (cardH + gapY) + 12.0F;
        if (mouseX >= gCardX && mouseX <= gCardX + gCardW && mouseY >= gCardY && mouseY <= gCardY + gCardH) {
            UISoundManager.playButtonClick();
            openInRealBrowser(this.searchQuery);
            return;
        }
    }

    @Override
    public boolean charTyped(char chr, int modifiers) {
        if (this.isEditingUrl) {
            if (chr >= 32 && chr != 127) {
                this.searchQuery += chr;
                return true;
            }
        }
        return super.charTyped(chr, modifiers);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (this.isEditingUrl) {
            if (keyCode == GLFW.GLFW_KEY_BACKSPACE && !this.searchQuery.isEmpty()) {
                this.searchQuery = this.searchQuery.substring(0, this.searchQuery.length() - 1);
                return true;
            }
            if (keyCode == GLFW.GLFW_KEY_ENTER || keyCode == GLFW.GLFW_KEY_KP_ENTER) {
                this.isEditingUrl = false;
                UISoundManager.playButtonClick();
                openInRealBrowser(this.searchQuery);
                return true;
            }
            if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
                this.isEditingUrl = false;
                return true;
            }
        }

        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            this.close();
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public void close() {
        if (this.client != null) {
            this.client.setScreen(this.parentScreen);
        }
    }
}
