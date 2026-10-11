package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.multiplayer.AddServerScreen;
import net.minecraft.client.gui.screen.multiplayer.ConnectScreen;
import net.minecraft.client.gui.screen.multiplayer.DirectConnectScreen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.network.MultiplayerServerListPinger;
import net.minecraft.client.network.ServerAddress;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.client.option.ServerList;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.level.storage.LevelStorage;
import net.minecraft.world.level.storage.LevelSummary;
import org.lwjgl.glfw.GLFW;
import pyrock.utility.render.ColorRGBA;

/**
 * iOS / iPadOS Desktop & Springboard Screen for Singleplayer Worlds & Multiplayer Servers.
 * Clean frosted-glass aesthetic, spotlight search, tab switching, and quick action dock.
 */
public class IOSDesktopScreen extends Screen {

    public enum Tab {
        ALL("Все"),
        WORLDS("Миры"),
        SERVERS("Серверы");

        public final String title;
        Tab(String title) {
            this.title = title;
        }
    }

    public static class WorldItem {
        public final LevelSummary summary;
        public final String name;
        public final String displayName;
        public final String details;
        public final long lastPlayed;
        public final boolean hardcore;
        public final String version;
        public Identifier iconTextureId = null;
        private NativeImageBackedTexture iconTexture = null;

        public WorldItem(LevelSummary summary) {
            this.summary = summary;
            this.name = summary.getName();
            this.displayName = summary.getDisplayName() != null && !summary.getDisplayName().isEmpty()
                ? summary.getDisplayName() : summary.getName();
            this.details = summary.getDetails() != null ? summary.getDetails().getString() : "";
            this.lastPlayed = summary.getLastPlayed();
            this.hardcore = summary.isHardcore();
            this.version = summary.getVersion() != null ? summary.getVersion().getString() : "1.21.4";
            this.loadIconTexture();
        }

        public void loadIconTexture() {
            if (this.iconTextureId != null || this.summary == null) return;
            try {
                Path iconPath = this.summary.getIconPath();
                if (iconPath != null && Files.isRegularFile(iconPath)) {
                    try (InputStream stream = Files.newInputStream(iconPath)) {
                        NativeImage img = NativeImage.read(stream);
                        if (img != null) {
                            this.iconTexture = new NativeImageBackedTexture(img);
                            Identifier id = Identifier.of("rockstar", "ios_wld_" + Math.abs(this.name.hashCode()));
                            MinecraftClient.getInstance().getTextureManager().registerTexture(id, this.iconTexture);
                            this.iconTextureId = id;
                        }
                    }
                }
            } catch (Throwable ignored) {}
        }

        public void destroy() {
            if (this.iconTexture != null) {
                try {
                    this.iconTexture.close();
                } catch (Throwable ignored) {}
                this.iconTexture = null;
            }
        }
    }

    public static class ServerItem {
        public final ServerInfo info;
        public final String name;
        public final String address;
        public String motd;
        public int ping = -1;
        public String playerCount = "";
        public boolean pinged = false;
        public boolean online = false;
        private byte[] lastFavicon = null;
        public Identifier faviconTextureId = null;
        private NativeImageBackedTexture faviconTexture = null;

        public ServerItem(ServerInfo info) {
            this.info = info;
            this.name = info.name != null && !info.name.isEmpty() ? info.name : "Minecraft Server";
            this.address = info.address != null ? info.address : "localhost";
            this.updateFromInfo();
            this.updateFaviconTexture();
        }

        public void updateFromInfo() {
            if (this.info == null) return;
            if (this.info.ping > 0) {
                this.ping = (int) this.info.ping;
                this.online = true;
                this.pinged = true;
            }
            if (this.info.label != null) {
                this.motd = this.info.label.getString();
            }
            if (this.info.players != null) {
                this.playerCount = this.info.players.online() + "/" + this.info.players.max();
                this.online = true;
                this.pinged = true;
            } else if (this.info.playerCountLabel != null && !this.info.playerCountLabel.getString().isEmpty()) {
                this.playerCount = this.info.playerCountLabel.getString();
                this.online = true;
                this.pinged = true;
            }
            if (this.info.getStatus() == ServerInfo.Status.SUCCESSFUL) {
                this.online = true;
                this.pinged = true;
            } else if (this.info.getStatus() == ServerInfo.Status.UNREACHABLE) {
                this.online = false;
                this.pinged = true;
                this.ping = -1;
            }
        }

        public void updateFaviconTexture() {
            if (this.info == null) return;
            try {
                byte[] fav = this.info.getFavicon();
                if (fav != null && fav.length > 0 && !Arrays.equals(fav, this.lastFavicon)) {
                    this.lastFavicon = fav;
                    NativeImage img = NativeImage.read(fav);
                    if (img != null) {
                        if (this.faviconTexture != null) {
                            try { this.faviconTexture.close(); } catch (Throwable ignored) {}
                        }
                        this.faviconTexture = new NativeImageBackedTexture(img);
                        Identifier id = Identifier.of("rockstar", "ios_srv_" + Math.abs(this.address.hashCode()));
                        MinecraftClient.getInstance().getTextureManager().registerTexture(id, this.faviconTexture);
                        this.faviconTextureId = id;
                    }
                }
            } catch (Throwable ignored) {}
        }

        public void destroy() {
            if (this.faviconTexture != null) {
                try {
                    this.faviconTexture.close();
                } catch (Throwable ignored) {}
                this.faviconTexture = null;
            }
        }
    }

    private final Screen parent;
    private Tab currentTab = Tab.ALL;
    private String searchQuery = "";
    private boolean searchFocused = false;

    private float scrollY = 0.0F;
    private float targetScrollY = 0.0F;
    private float maxScroll = 0.0F;

    private final List<WorldItem> worlds = new ArrayList<>();
    private final List<ServerItem> servers = new ArrayList<>();

    private ServerList serverList;
    private MultiplayerServerListPinger pinger;

    private long screenOpenTime = 0L;
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd MMM, HH:mm", new Locale("ru"));

    public IOSDesktopScreen(Screen parent) {
        super(Text.literal("Agravity Desktop"));
        this.parent = parent;
    }

    public IOSDesktopScreen(Screen parent, Tab initialTab) {
        super(Text.literal("Agravity Desktop"));
        this.parent = parent;
        this.currentTab = initialTab != null ? initialTab : Tab.ALL;
    }

    @Override
    protected void init() {
        super.init();
        this.screenOpenTime = System.currentTimeMillis();
        this.loadData();
    }

    public void loadData() {
        this.worlds.clear();
        this.servers.clear();

        // 1. Load Singleplayer Worlds
        if (this.client != null) {
            try {
                LevelStorage storage = this.client.getLevelStorage();
                LevelStorage.LevelList levelList = storage.getLevelList();
                List<LevelSummary> summaries = storage.loadSummaries(levelList).join();
                if (summaries != null) {
                    for (LevelSummary s : summaries) {
                        this.worlds.add(new WorldItem(s));
                    }
                    this.worlds.sort((a, b) -> Long.compare(b.lastPlayed, a.lastPlayed));
                }
            } catch (Throwable t) {
                // Ignore level loading errors
            }
        }

        // 2. Load Multiplayer Servers
        if (this.client != null) {
            try {
                if (this.serverList == null) {
                    this.serverList = new ServerList(this.client);
                    this.serverList.loadFile();
                }
                if (this.pinger == null) {
                    this.pinger = new MultiplayerServerListPinger();
                }

                for (int i = 0; i < this.serverList.size(); i++) {
                    ServerInfo info = this.serverList.get(i);
                    ServerItem item = new ServerItem(info);
                    this.servers.add(item);

                    // Ping server asynchronously
                    try {
                        this.pinger.add(info, () -> {
                            if (this.client != null) {
                                this.client.execute(() -> {
                                    item.updateFromInfo();
                                    item.updateFaviconTexture();
                                });
                            }
                        }, () -> {
                            if (this.client != null) {
                                this.client.execute(() -> {
                                    item.updateFromInfo();
                                    item.updateFaviconTexture();
                                });
                            }
                        });
                    } catch (Throwable ignored) {}
                }
            } catch (Throwable t) {
                // Ignore server loading errors
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (this.pinger != null) {
            try {
                this.pinger.tick();
            } catch (Throwable ignored) {}
        }
        for (ServerItem s : this.servers) {
            if (s.info != null) {
                s.updateFromInfo();
                s.updateFaviconTexture();
            }
        }
    }

    @Override
    public void removed() {
        if (this.pinger != null) {
            try {
                this.pinger.cancel();
            } catch (Throwable ignored) {}
        }
        for (ServerItem s : this.servers) {
            s.destroy();
        }
        for (WorldItem w : this.worlds) {
            w.destroy();
        }
        super.removed();
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        this.targetScrollY -= (float) (verticalAmount * 38.0);
        this.targetScrollY = Math.max(0.0F, Math.min(this.maxScroll, this.targetScrollY));
        return true;
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (this.searchFocused) {
            if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
                this.searchFocused = false;
                return true;
            }
            if (keyCode == GLFW.GLFW_KEY_BACKSPACE) {
                if (!this.searchQuery.isEmpty()) {
                    this.searchQuery = this.searchQuery.substring(0, this.searchQuery.length() - 1);
                    this.targetScrollY = 0.0F;
                }
                return true;
            }
            if (keyCode == GLFW.GLFW_KEY_ENTER || keyCode == GLFW.GLFW_KEY_KP_ENTER) {
                this.searchFocused = false;
                return true;
            }
            return true;
        }

        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            this.close();
            return true;
        }

        if (keyCode == GLFW.GLFW_KEY_F && (modifiers & GLFW.GLFW_MOD_CONTROL) != 0) {
            this.searchFocused = true;
            return true;
        }

        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean charTyped(char chr, int modifiers) {
        if (this.searchFocused) {
            if (Character.isDefined(chr) && chr >= 32) {
                this.searchQuery += chr;
                this.targetScrollY = 0.0F;
                return true;
            }
        }
        return super.charTyped(chr, modifiers);
    }

    @Override
    public void close() {
        if (this.client != null) {
            this.client.setScreen(this.parent);
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        III custom = III.I_method_5728d20f(context, mouseX, mouseY, delta);

        // 1. Wallpaper background & dark iOS backdrop
        IiiIIiIii_Class204.renderWallpaperBackground(custom, this.width, this.height, (float) mouseX, (float) mouseY);
        custom.drawRect(0.0F, 0.0F, (float) this.width, (float) this.height, new ColorRGBA(10.0F, 12.0F, 18.0F, 145.0F));

        // Smooth scroll interpolation
        this.scrollY += (this.targetScrollY - this.scrollY) * Math.min(1.0F, delta * 12.0F);

        float topBarH = 46.0F;
        float dockH = 50.0F;
        float contentTop = topBarH + 12.0F;
        float contentBot = this.height - dockH - 12.0F;
        float contentH = contentBot - contentTop;

        // 2. Render Cards Grid (Singleplayer Worlds & Servers)
        this.renderDesktopCards(custom, mouseX, mouseY, contentTop, contentH);

        // 3. Render Top iOS Navigation Bar (Status, Search, Tabs)
        this.renderTopBar(custom, mouseX, mouseY, topBarH);

        // 4. Render Bottom Floating Action Dock
        this.renderDock(custom, mouseX, mouseY);
    }

    private void renderTopBar(III custom, int mx, int my, float h) {
        float barX = 16.0F;
        float barY = 8.0F;
        float barW = this.width - 32.0F;
        float barH = h - 10.0F;
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(barH / 2.0F);

        // Glass banner background
        custom.drawRoundedRect(barX, barY, barW, barH, rad, new ColorRGBA(20.0F, 24.0F, 34.0F, 185.0F));
        custom.drawRoundedBorder(barX, barY, barW, barH, 0.8F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 32.0F));

        // Left: Logo & Clock
        custom.drawIcon("logo", barX + 14.0F, barY + (barH - 14.0F) / 2.0F, 13.0F, ColorRGBA.WHITE);
        custom.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.5F), "Desktop", barX + 32.0F, barY + (barH - 8.5F) / 2.0F, ColorRGBA.WHITE);

        String timeStr = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        String dateStr = new SimpleDateFormat("E, d MMM", new Locale("ru")).format(new Date());
        custom.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.5F), timeStr + "  •  " + dateStr, barX + 80.0F, barY + (barH - 7.5F) / 2.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 170.0F));

        // Center: Spotlight Search Bar
        float searchW = Math.min(260.0F, barW * 0.32F);
        float searchX = barX + (barW - searchW) / 2.0F;
        float searchY = barY + 4.0F;
        float searchH = barH - 8.0F;
        IIiii_Class8 sRad = IIiii_Class8.I_method_893b2757(searchH / 2.0F);

        boolean sHov = mx >= searchX && mx <= searchX + searchW && my >= searchY && my <= searchY + searchH;
        ColorRGBA sBg = this.searchFocused
            ? new ColorRGBA(40.0F, 46.0F, 65.0F, 230.0F)
            : (sHov ? new ColorRGBA(32.0F, 38.0F, 52.0F, 200.0F) : new ColorRGBA(26.0F, 30.0F, 42.0F, 180.0F));
        custom.drawRoundedRect(searchX, searchY, searchW, searchH, sRad, sBg);
        custom.drawRoundedBorder(searchX, searchY, searchW, searchH, 0.8F, sRad, this.searchFocused ? IiiiiIIIi_Class242.I_method_7df8e08e() : new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));

        custom.drawIcon("search", searchX + 8.0F, searchY + (searchH - 10.0F) / 2.0F, 10.0F, this.searchFocused ? IiiiiIIIi_Class242.I_method_7df8e08e() : new ColorRGBA(255.0F, 255.0F, 255.0F, 140.0F));

        if (this.searchQuery.isEmpty()) {
            custom.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F), "Поиск миров и серверов...", searchX + 22.0F, searchY + (searchH - 7.0F) / 2.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 110.0F));
        } else {
            String cursor = this.searchFocused && (System.currentTimeMillis() % 1000L < 500L) ? "|" : "";
            custom.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.5F), this.searchQuery + cursor, searchX + 22.0F, searchY + (searchH - 7.5F) / 2.0F, ColorRGBA.WHITE);

            // Clear search (✕)
            float clrX = searchX + searchW - 16.0F;
            float clrY = searchY + (searchH - 8.0F) / 2.0F;
            custom.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F), "✕", clrX, clrY, new ColorRGBA(255.0F, 255.0F, 255.0F, 160.0F));
        }

        // Right: Segmented Control Tabs [Все] [Миры] [Серверы]
        float tabW = 60.0F;
        float tabsTotalW = tabW * 3.0F + 8.0F;
        float tabsX = barX + barW - tabsTotalW - 36.0F;
        float tabsY = barY + 4.0F;
        float tabsH = barH - 8.0F;
        IIiii_Class8 tRad = IIiii_Class8.I_method_893b2757(tabsH / 2.0F);

        custom.drawRoundedRect(tabsX, tabsY, tabsTotalW, tabsH, tRad, new ColorRGBA(16.0F, 18.0F, 26.0F, 180.0F));

        Tab[] tabs = Tab.values();
        for (int i = 0; i < tabs.length; i++) {
            Tab t = tabs[i];
            float tx = tabsX + 2.0F + i * tabW;
            float ty = tabsY + 2.0F;
            float tw = tabW;
            float th = tabsH - 4.0F;
            boolean selected = this.currentTab == t;
            boolean tHov = mx >= tx && mx <= tx + tw && my >= ty && my <= ty + th;

            if (selected) {
                custom.drawRoundedRect(tx, ty, tw, th, IIiii_Class8.I_method_893b2757(th / 2.0F), IiiiiIIIi_Class242.I_method_7df8e08e());
            } else if (tHov) {
                custom.drawRoundedRect(tx, ty, tw, th, IIiii_Class8.I_method_893b2757(th / 2.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));
            }

            float titleW = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F).I_method_2c375926(t.title);
            custom.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F), t.title, tx + (tw - titleW) / 2.0F, ty + (th - 7.0F) / 2.0F, selected ? ColorRGBA.WHITE : new ColorRGBA(255.0F, 255.0F, 255.0F, 160.0F));
        }

        // Close Button ✕
        float closeX = barX + barW - 26.0F;
        float closeY = barY + (barH - 18.0F) / 2.0F;
        boolean closeHov = mx >= closeX && mx <= closeX + 18.0F && my >= closeY && my <= closeY + 18.0F;
        custom.drawRoundedRect(closeX, closeY, 18.0F, 18.0F, IIiii_Class8.I_method_893b2757(9.0F), closeHov ? new ColorRGBA(220.0F, 60.0F, 60.0F, 180.0F) : new ColorRGBA(40.0F, 44.0F, 60.0F, 160.0F));
        custom.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F), "✕", closeX + 5.5F, closeY + 4.5F, ColorRGBA.WHITE);
    }

    private void renderDesktopCards(III custom, int mx, int my, float top, float h) {
        // Collect filtered items
        String filter = this.searchQuery.toLowerCase().trim();
        List<Object> items = new ArrayList<>();

        if (this.currentTab == Tab.ALL || this.currentTab == Tab.WORLDS) {
            for (WorldItem w : this.worlds) {
                if (filter.isEmpty() || w.displayName.toLowerCase().contains(filter) || w.details.toLowerCase().contains(filter)) {
                    items.add(w);
                }
            }
        }

        if (this.currentTab == Tab.ALL || this.currentTab == Tab.SERVERS) {
            for (ServerItem s : this.servers) {
                if (filter.isEmpty() || s.name.toLowerCase().contains(filter) || s.address.toLowerCase().contains(filter) || s.motd.toLowerCase().contains(filter)) {
                    items.add(s);
                }
            }
        }

        // Layout parameters
        float padX = 24.0F;
        float totalW = this.width - padX * 2.0F;
        int cols = Math.max(2, Math.min(4, (int) (totalW / 260.0F)));
        float gap = 14.0F;
        float cardW = (totalW - gap * (cols - 1)) / cols;
        float cardH = 82.0F;

        int totalRows = (items.size() + cols - 1) / cols;
        float totalGridH = totalRows * (cardH + gap);
        this.maxScroll = Math.max(0.0F, totalGridH - h + 20.0F);

        // Hardware Scissor Viewport
        iIiiiIiII_Class373.I_method_d5a5ee51(custom.getMatrices(), padX - 4.0F, top, totalW + 8.0F, h);

        if (items.isEmpty()) {
            float emptyW = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(10.0F).I_method_2c375926("Нет доступных миров или серверов");
            custom.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(10.0F), "Нет доступных миров или серверов", (this.width - emptyW) / 2.0F, top + h / 2.0F - 10.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 120.0F));
            custom.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.5F), "Используйте нижнюю панель для создания мира или добавления сервера", (this.width - 240.0F) / 2.0F, top + h / 2.0F + 8.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 85.0F));
        } else {
            for (int i = 0; i < items.size(); i++) {
                int col = i % cols;
                int row = i / cols;
                float cx = padX + col * (cardW + gap);
                float cy = top - this.scrollY + row * (cardH + gap);

                if (cy + cardH < top || cy > top + h) {
                    continue; // Culled
                }

                Object obj = items.get(i);
                if (obj instanceof WorldItem w) {
                    this.renderWorldCard(custom, w, cx, cy, cardW, cardH, mx, my);
                } else if (obj instanceof ServerItem s) {
                    this.renderServerCard(custom, s, cx, cy, cardW, cardH, mx, my);
                }
            }
        }

        iIiiiIiII_Class373.I_method_ff80a1df();
    }

    private void renderWorldCard(III custom, WorldItem w, float x, float y, float wCard, float hCard, int mx, int my) {
        boolean hov = mx >= x && mx <= x + wCard && my >= y && my <= y + hCard;
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(12.0F);

        // Card glass background
        ColorRGBA bg = hov ? new ColorRGBA(28.0F, 34.0F, 48.0F, 205.0F) : new ColorRGBA(18.0F, 22.0F, 32.0F, 175.0F);
        custom.drawRoundedRect(x, y, wCard, hCard, rad, bg);
        custom.drawRoundedBorder(x, y, wCard, hCard, 0.8F, rad, hov ? IiiiiIIIi_Class242.I_method_7df8e08e().withAlpha(160.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));

        // Squircle Icon (Singleplayer Earth / World Screenshot Icon)
        float iconSize = 46.0F;
        float iconX = x + 10.0F;
        float iconY = y + (hCard - iconSize) / 2.0F;
        IIiii_Class8 iconRad = IIiii_Class8.I_method_893b2757(12.0F);

        w.loadIconTexture();
        if (w.iconTextureId != null) {
            custom.drawRoundedTexture(w.iconTextureId, iconX, iconY, iconSize, iconSize, iconRad, ColorRGBA.WHITE);
            custom.drawRoundedBorder(iconX, iconY, iconSize, iconSize, 1.0F, iconRad, hov ? IiiiiIIIi_Class242.I_method_7df8e08e() : new ColorRGBA(255.0F, 255.0F, 255.0F, 30.0F));
        } else {
            // Vibrant grass green gradient for worlds without screenshot
            custom.drawRoundedRect(iconX, iconY, iconSize, iconSize, iconRad, new ColorRGBA(40.0F, 120.0F, 70.0F, 220.0F));
            custom.drawRoundedBorder(iconX, iconY, iconSize, iconSize, 0.8F, iconRad, new ColorRGBA(120.0F, 240.0F, 160.0F, 180.0F));
            custom.drawIcon("world", iconX + (iconSize - 22.0F) / 2.0F, iconY + (iconSize - 22.0F) / 2.0F, 22.0F, ColorRGBA.WHITE);
        }

        // World Info Text
        float textX = iconX + iconSize + 10.0F;
        float titleMaxW = wCard - iconSize - 75.0F;
        String title = w.displayName;
        custom.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.5F), title, textX, y + 10.0F, ColorRGBA.WHITE);

        // Subtitle & Mode Badge
        ColorRGBA modeColor = w.hardcore ? new ColorRGBA(240.0F, 70.0F, 70.0F, 255.0F) : new ColorRGBA(90.0F, 210.0F, 140.0F, 255.0F);
        String modeName = w.hardcore ? "Хардкор" : "Одиночный мир";
        custom.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.5F), modeName, textX, y + 26.0F, modeColor);

        // Last played date
        String dateStr = w.lastPlayed > 0 ? DATE_FORMAT.format(new Date(w.lastPlayed)) : "Никогда";
        custom.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.5F), dateStr + " • " + w.version, textX, y + 39.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 125.0F));

        // Quick Launch Action Pill (Play)
        float btnW = 52.0F;
        float btnH = 22.0F;
        float btnX = x + wCard - btnW - 10.0F;
        float btnY = y + (hCard - btnH) / 2.0F;
        IIiii_Class8 bRad = IIiii_Class8.I_method_893b2757(btnH / 2.0F);

        boolean bHov = mx >= btnX && mx <= btnX + btnW && my >= btnY && my <= btnY + btnH;
        ColorRGBA btnBg = bHov ? IiiiiIIIi_Class242.I_method_7df8e08e() : IiiiiIIIi_Class242.I_method_7df8e08e().withAlpha(180.0F);
        custom.drawRoundedRect(btnX, btnY, btnW, btnH, bRad, btnBg);
        custom.drawRoundedBorder(btnX, btnY, btnW, btnH, 0.8F, bRad, ColorRGBA.WHITE.withAlpha(140.0F));

        float playTextW = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.5F).I_method_2c375926("Играть");
        custom.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.5F), "Играть", btnX + (btnW - playTextW) / 2.0F, btnY + (btnH - 7.5F) / 2.0F, ColorRGBA.WHITE);
    }

    private void renderServerCard(III custom, ServerItem s, float x, float y, float wCard, float hCard, int mx, int my) {
        boolean hov = mx >= x && mx <= x + wCard && my >= y && my <= y + hCard;
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(12.0F);

        // Card glass background
        ColorRGBA bg = hov ? new ColorRGBA(28.0F, 34.0F, 48.0F, 205.0F) : new ColorRGBA(18.0F, 22.0F, 32.0F, 175.0F);
        custom.drawRoundedRect(x, y, wCard, hCard, rad, bg);
        custom.drawRoundedBorder(x, y, wCard, hCard, 0.8F, rad, hov ? IiiiiIIIi_Class242.I_method_7df8e08e().withAlpha(160.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));

        // Squircle Icon (Multiplayer Server / Network Favicon)
        float iconSize = 46.0F;
        float iconX = x + 10.0F;
        float iconY = y + (hCard - iconSize) / 2.0F;
        IIiii_Class8 iconRad = IIiii_Class8.I_method_893b2757(12.0F);

        // Update / register dynamic favicon if server provided one
        s.updateFaviconTexture();

        if (s.faviconTextureId != null) {
            // Fill the rounded squircle with the real server favicon
            custom.drawRoundedTexture(s.faviconTextureId, iconX, iconY, iconSize, iconSize, iconRad, ColorRGBA.WHITE);
            custom.drawRoundedBorder(iconX, iconY, iconSize, iconSize, 1.0F, iconRad, hov ? IiiiiIIIi_Class242.I_method_7df8e08e() : new ColorRGBA(255.0F, 255.0F, 255.0F, 30.0F));
        } else {
            // Beautiful fallback monogram initial letter
            custom.drawRoundedRect(iconX, iconY, iconSize, iconSize, iconRad, new ColorRGBA(32.0F, 42.0F, 64.0F, 220.0F));
            custom.drawRoundedBorder(iconX, iconY, iconSize, iconSize, 0.8F, iconRad, hov ? IiiiiIIIi_Class242.I_method_7df8e08e() : new ColorRGBA(90.0F, 190.0F, 255.0F, 140.0F));
            String initial = s.name.trim().isEmpty() ? "S" : s.name.trim().substring(0, 1).toUpperCase();
            IIiIIi_Class10 letterFont = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(16.0F);
            float lw = letterFont.I_method_2c375926(initial);
            custom.drawText(letterFont, initial, iconX + (iconSize - lw) / 2.0F, iconY + (iconSize - 16.0F) / 2.0F + 1.0F, ColorRGBA.WHITE);
        }

        // Server Info Text
        float textX = iconX + iconSize + 10.0F;
        custom.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.5F), s.name, textX, y + 10.0F, ColorRGBA.WHITE);

        // Server Address
        custom.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.5F), s.address, textX, y + 26.0F, new ColorRGBA(180.0F, 210.0F, 255.0F, 200.0F));

        // Ping badge & players count
        String statusText;
        ColorRGBA statusCol;
        if (!s.pinged) {
            statusText = "Подключение...";
            statusCol = new ColorRGBA(255.0F, 255.0F, 255.0F, 140.0F);
        } else if (s.online) {
            statusCol = new ColorRGBA(80.0F, 225.0F, 130.0F, 255.0F);
            if (!s.playerCount.isEmpty()) {
                statusText = s.playerCount + " игроков" + (s.ping > 0 ? " • " + s.ping + " ms" : "");
            } else if (s.ping > 0) {
                statusText = s.ping + " ms • Онлайн";
            } else {
                statusText = "Онлайн";
            }
        } else {
            statusText = "Офлайн";
            statusCol = new ColorRGBA(240.0F, 70.0F, 70.0F, 255.0F);
        }

        custom.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.5F), statusText, textX, y + 39.0F, statusCol);

        // Quick Launch Action Pill (Connect)
        float btnW = 54.0F;
        float btnH = 22.0F;
        float btnX = x + wCard - btnW - 10.0F;
        float btnY = y + (hCard - btnH) / 2.0F;
        IIiii_Class8 bRad = IIiii_Class8.I_method_893b2757(btnH / 2.0F);

        boolean bHov = mx >= btnX && mx <= btnX + btnW && my >= btnY && my <= btnY + btnH;
        ColorRGBA btnBg = bHov ? new ColorRGBA(40.0F, 140.0F, 250.0F, 240.0F) : new ColorRGBA(30.0F, 110.0F, 210.0F, 190.0F);
        custom.drawRoundedRect(btnX, btnY, btnW, btnH, bRad, btnBg);
        custom.drawRoundedBorder(btnX, btnY, btnW, btnH, 0.8F, bRad, ColorRGBA.WHITE.withAlpha(140.0F));

        float joinTextW = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F).I_method_2c375926("Войти");
        custom.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F), "Войти", btnX + (btnW - joinTextW) / 2.0F, btnY + (btnH - 7.0F) / 2.0F, ColorRGBA.WHITE);
    }

    private void renderDock(III custom, int mx, int my) {
        float dockW = Math.min(480.0F, this.width - 40.0F);
        float dockH = 40.0F;
        float dockX = (this.width - dockW) / 2.0F;
        float dockY = this.height - dockH - 12.0F;
        IIiii_Class8 dRad = IIiii_Class8.I_method_893b2757(dockH / 2.0F);

        // Glass Dock Container
        custom.drawRoundedRect(dockX, dockY, dockW, dockH, dRad, new ColorRGBA(18.0F, 22.0F, 32.0F, 210.0F));
        custom.drawRoundedBorder(dockX, dockY, dockW, dockH, 0.8F, dRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 36.0F));

        // 5 Action Pills
        String[] actions = {"+ Создать мир", "+ Сервер", "Прямое подключение", "Обновить", "Назад"};
        float pillW = (dockW - 16.0F) / actions.length;

        for (int i = 0; i < actions.length; i++) {
            float px = dockX + 8.0F + i * pillW;
            float py = dockY + 4.0F;
            float pw = pillW - 4.0F;
            float ph = dockH - 8.0F;
            IIiii_Class8 pRad = IIiii_Class8.I_method_893b2757(ph / 2.0F);

            boolean pHov = mx >= px && mx <= px + pw && my >= py && my <= py + ph;
            ColorRGBA pBg = pHov ? new ColorRGBA(55.0F, 64.0F, 90.0F, 220.0F) : new ColorRGBA(28.0F, 32.0F, 46.0F, 160.0F);
            custom.drawRoundedRect(px, py, pw, ph, pRad, pBg);
            if (pHov) {
                custom.drawRoundedBorder(px, py, pw, ph, 0.8F, pRad, IiiiiIIIi_Class242.I_method_7df8e08e());
            }

            float tw = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.5F).I_method_2c375926(actions[i]);
            custom.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.5F), actions[i], px + (pw - tw) / 2.0F, py + (ph - 6.5F) / 2.0F, pHov ? ColorRGBA.WHITE : new ColorRGBA(255.0F, 255.0F, 255.0F, 185.0F));
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int mx = (int) mouseX;
        int my = (int) mouseY;

        float topBarH = 46.0F;
        float barX = 16.0F;
        float barY = 8.0F;
        float barW = this.width - 32.0F;
        float barH = topBarH - 10.0F;

        // 1. Check Close button
        float closeX = barX + barW - 26.0F;
        float closeY = barY + (barH - 18.0F) / 2.0F;
        if (mx >= closeX && mx <= closeX + 18.0F && my >= closeY && my <= closeY + 18.0F) {
            this.close();
            return true;
        }

        // 2. Check Search Bar
        float searchW = Math.min(260.0F, barW * 0.32F);
        float searchX = barX + (barW - searchW) / 2.0F;
        float searchY = barY + 4.0F;
        float searchH = barH - 8.0F;
        if (mx >= searchX && mx <= searchX + searchW && my >= searchY && my <= searchY + searchH) {
            // Check clear button ✕
            float clrX = searchX + searchW - 18.0F;
            if (!this.searchQuery.isEmpty() && mx >= clrX) {
                this.searchQuery = "";
            } else {
                this.searchFocused = true;
            }
            return true;
        } else {
            this.searchFocused = false;
        }

        // 3. Check Tabs
        float tabW = 60.0F;
        float tabsTotalW = tabW * 3.0F + 8.0F;
        float tabsX = barX + barW - tabsTotalW - 36.0F;
        float tabsY = barY + 4.0F;
        float tabsH = barH - 8.0F;
        Tab[] tabs = Tab.values();
        for (int i = 0; i < tabs.length; i++) {
            float tx = tabsX + 2.0F + i * tabW;
            float ty = tabsY + 2.0F;
            float tw = tabW;
            float th = tabsH - 4.0F;
            if (mx >= tx && mx <= tx + tw && my >= ty && my <= ty + th) {
                this.currentTab = tabs[i];
                this.targetScrollY = 0.0F;
                return true;
            }
        }

        // 4. Check Dock Actions
        float dockW = Math.min(480.0F, this.width - 40.0F);
        float dockH = 40.0F;
        float dockX = (this.width - dockW) / 2.0F;
        float dockY = this.height - dockH - 12.0F;
        if (my >= dockY && my <= dockY + dockH && mx >= dockX && mx <= dockX + dockW) {
            float pillW = (dockW - 16.0F) / 5.0F;
            int idx = (int) ((mx - (dockX + 8.0F)) / pillW);
            if (idx == 0) {
                // Создать новый мир / Выбор миров
                if (this.client != null) {
                    this.client.setScreen(new SelectWorldScreen(this));
                }
                return true;
            } else if (idx == 1) {
                // Добавить сервер
                if (this.client != null) {
                    ServerInfo newInfo = new ServerInfo("Minecraft Server", "", ServerInfo.ServerType.OTHER);
                    this.client.setScreen(new AddServerScreen(this, confirmed -> {
                        if (confirmed && this.serverList != null) {
                            this.serverList.add(newInfo, false);
                            this.serverList.saveFile();
                            this.loadData();
                        }
                        this.client.setScreen(this);
                    }, newInfo));
                }
                return true;
            } else if (idx == 2) {
                // Прямое подключение
                if (this.client != null) {
                    ServerInfo directInfo = new ServerInfo("Direct Server", "", ServerInfo.ServerType.OTHER);
                    this.client.setScreen(new DirectConnectScreen(this, confirmed -> {
                        if (confirmed) {
                            ConnectScreen.connect(this, this.client, ServerAddress.parse(directInfo.address), directInfo, false, null);
                        } else {
                            this.client.setScreen(this);
                        }
                    }, directInfo));
                }
                return true;
            } else if (idx == 3) {
                // Обновить
                this.loadData();
                return true;
            } else if (idx == 4) {
                // Назад
                this.close();
                return true;
            }
        }

        // 5. Check Card Clicks (Play / Connect)
        float dockTop = this.height - dockH - 12.0F;
        float contentTop = topBarH + 12.0F;
        if (my >= contentTop && my <= dockTop) {
            String filter = this.searchQuery.toLowerCase().trim();
            List<Object> items = new ArrayList<>();
            if (this.currentTab == Tab.ALL || this.currentTab == Tab.WORLDS) {
                for (WorldItem w : this.worlds) {
                    if (filter.isEmpty() || w.displayName.toLowerCase().contains(filter) || w.details.toLowerCase().contains(filter)) {
                        items.add(w);
                    }
                }
            }
            if (this.currentTab == Tab.ALL || this.currentTab == Tab.SERVERS) {
                for (ServerItem s : this.servers) {
                    if (filter.isEmpty() || s.name.toLowerCase().contains(filter) || s.address.toLowerCase().contains(filter) || s.motd.toLowerCase().contains(filter)) {
                        items.add(s);
                    }
                }
            }

            float padX = 24.0F;
            float totalW = this.width - padX * 2.0F;
            int cols = Math.max(2, Math.min(4, (int) (totalW / 260.0F)));
            float gap = 14.0F;
            float cardW = (totalW - gap * (cols - 1)) / cols;
            float cardH = 82.0F;

            for (int i = 0; i < items.size(); i++) {
                int col = i % cols;
                int row = i / cols;
                float cx = padX + col * (cardW + gap);
                float cy = contentTop - this.scrollY + row * (cardH + gap);

                if (mx >= cx && mx <= cx + cardW && my >= cy && my <= cy + cardH) {
                    Object obj = items.get(i);
                    if (obj instanceof WorldItem w) {
                        this.playWorld(w);
                        return true;
                    } else if (obj instanceof ServerItem s) {
                        this.connectServer(s);
                        return true;
                    }
                }
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    private void playWorld(WorldItem w) {
        if (this.client != null) {
            try {
                this.client.createIntegratedServerLoader().start(w.name, () -> this.client.setScreen(this));
            } catch (Throwable t) {
                // Fallback to select world screen if needed
                this.client.setScreen(new SelectWorldScreen(this));
            }
        }
    }

    private void connectServer(ServerItem s) {
        if (this.client != null) {
            ConnectScreen.connect(this, this.client, ServerAddress.parse(s.address), s.info, false, null);
        }
    }
}
