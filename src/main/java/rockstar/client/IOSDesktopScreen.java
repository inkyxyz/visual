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
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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
import net.minecraft.util.math.MathHelper;
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
        ALL("All"),
        WORLDS("Worlds"),
        SERVERS("Servers");

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
    private float animatedTabIndicatorX = -1.0F;
    private String searchQuery = "";
    private boolean searchFocused = false;

    private float scrollY = 0.0F;
    private float targetScrollY = 0.0F;
    private float maxScroll = 0.0F;

    private final Map<Integer, Float> cardHoverAnim = new HashMap<>();
    private final float[] dockPillHover = new float[5];

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

        // 1. Unified Background (Wallpaper or ambient with subtle mouse parallax)
        float parallaxX = ((float)mouseX - this.width / 2.0F) * 0.018F;
        float parallaxY = ((float)mouseY - this.height / 2.0F) * 0.018F;
        ThemeAndBackgroundManager.getInstance().renderActiveBackground(custom, this.width, this.height, (float) mouseX + parallaxX, (float) mouseY + parallaxY);

        // Smooth scroll interpolation
        this.scrollY += (this.targetScrollY - this.scrollY) * Math.min(1.0F, delta * 12.0F);

        float topBarH = 46.0F;
        float dockH = 50.0F;
        float contentTop = 72.0F;
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
        long elapsed = System.currentTimeMillis() - this.screenOpenTime;
        float topEnter = MathHelper.clamp(elapsed / 320.0F, 0.0F, 1.0F);
        float topEase = springEase(topEnter, 0.65F);

        float barX = 16.0F;
        float barY = 8.0F + (1.0F - topEase) * -38.0F;
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
        String dateStr = new SimpleDateFormat("E, d MMM", Locale.ENGLISH).format(new Date());
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
            custom.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F), "Search worlds and servers...", searchX + 22.0F, searchY + (searchH - 7.0F) / 2.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 110.0F));
        } else {
            String cursor = this.searchFocused && (System.currentTimeMillis() % 1000L < 500L) ? "|" : "";
            custom.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.5F), this.searchQuery + cursor, searchX + 22.0F, searchY + (searchH - 7.5F) / 2.0F, ColorRGBA.WHITE);

            // Clear search (xmark)
            float clrSize = 14.0F;
            float clrX = searchX + searchW - clrSize - 6.0F;
            float clrY = searchY + (searchH - clrSize) / 2.0F;
            boolean clrHov = mx >= clrX && mx <= clrX + clrSize && my >= clrY && my <= clrY + clrSize;
            IIiii_Class8 clrRad = IIiii_Class8.I_method_893b2757(clrSize / 2.0F);

            ColorRGBA clrBg = clrHov ? new ColorRGBA(255.0F, 255.0F, 255.0F, 36.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 16.0F);
            custom.drawRoundedRect(clrX, clrY, clrSize, clrSize, clrRad, clrBg);
            custom.drawIcon("xmark", clrX + (clrSize - 8.0F) / 2.0F, clrY + (clrSize - 8.0F) / 2.0F, 8.0F, clrHov ? ColorRGBA.WHITE : new ColorRGBA(255.0F, 255.0F, 255.0F, 180.0F));
        }

        // Right: Segmented Control Tabs [Все] [Миры] [Серверы] with Smooth Sliding Indicator!
        float tabW = 64.0F;
        float tabsTotalW = tabW * 3.0F + 8.0F;
        float tabsX = barX + barW - tabsTotalW - 38.0F;
        float tabsY = barY + 4.0F;
        float tabsH = barH - 8.0F;
        IIiii_Class8 tRad = IIiii_Class8.I_method_893b2757(tabsH / 2.0F);

        custom.drawRoundedRect(tabsX, tabsY, tabsTotalW, tabsH, tRad, new ColorRGBA(16.0F, 18.0F, 26.0F, 190.0F));

        // Smooth sliding active tab pill
        Tab[] tabs = Tab.values();
        int activeIdx = this.currentTab.ordinal();
        float targetIndicatorX = tabsX + 2.0F + activeIdx * tabW;
        if (this.animatedTabIndicatorX < 0.0F) {
            this.animatedTabIndicatorX = targetIndicatorX;
        } else {
            this.animatedTabIndicatorX += (targetIndicatorX - this.animatedTabIndicatorX) * 0.24F;
        }

        // Draw smooth sliding active pill
        float th = tabsH - 4.0F;
        IIiii_Class8 pillRad = IIiii_Class8.I_method_893b2757(th / 2.0F);
        ColorRGBA theme = IiiiiIIIi_Class242.I_method_7df8e08e();
        custom.drawShadow(this.animatedTabIndicatorX, tabsY + 2.0F, tabW, th, 8.0F, pillRad, theme.withAlpha(90.0F));
        custom.drawRoundedRect(this.animatedTabIndicatorX, tabsY + 2.0F, tabW, th, pillRad, theme);
        custom.drawRoundedBorder(this.animatedTabIndicatorX, tabsY + 2.0F, tabW, th, 0.7F, pillRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 75.0F));

        for (int i = 0; i < tabs.length; i++) {
            Tab t = tabs[i];
            float tx = tabsX + 2.0F + i * tabW;
            float ty = tabsY + 2.0F;
            float tw = tabW;
            boolean selected = this.currentTab == t;
            boolean tHov = mx >= tx && mx <= tx + tw && my >= ty && my <= ty + th;

            if (tHov && !selected) {
                custom.drawRoundedRect(tx, ty, tw, th, pillRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 22.0F));
            }

            float titleW = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.2F).I_method_2c375926(t.title);
            custom.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.2F), t.title, tx + (tw - titleW) / 2.0F, ty + (th - 7.2F) / 2.0F, selected ? ColorRGBA.WHITE : new ColorRGBA(255.0F, 255.0F, 255.0F, 160.0F));
        }

        // Close Button (Apple-style Circular Close Button)
        float closeSize = 22.0F;
        float closeX = barX + barW - closeSize - 8.0F;
        float closeY = barY + (barH - closeSize) / 2.0F;
        boolean closeHov = mx >= closeX && mx <= closeX + closeSize && my >= closeY && my <= closeY + closeSize;
        IIiii_Class8 cRad = IIiii_Class8.I_method_893b2757(closeSize / 2.0F);

        ColorRGBA cBg = closeHov
            ? new ColorRGBA(239.0F, 68.0F, 68.0F, 220.0F)
            : new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F);
        ColorRGBA cBorder = closeHov
            ? new ColorRGBA(254.0F, 160.0F, 160.0F, 180.0F)
            : new ColorRGBA(255.0F, 255.0F, 255.0F, 28.0F);
        ColorRGBA iconCol = closeHov ? ColorRGBA.WHITE : new ColorRGBA(225.0F, 230.0F, 245.0F, 200.0F);

        if (closeHov) {
            custom.drawShadow(closeX, closeY, closeSize, closeSize, 6.0F, cRad, new ColorRGBA(239.0F, 68.0F, 68.0F, 90.0F));
        }
        custom.drawRoundedRect(closeX, closeY, closeSize, closeSize, cRad, cBg);
        custom.drawRoundedBorder(closeX, closeY, closeSize, closeSize, 0.7F, cRad, cBorder);
        custom.drawIcon("xmark", closeX + (closeSize - 10.0F) / 2.0F, closeY + (closeSize - 10.0F) / 2.0F, 10.0F, iconCol);
    }

    private void renderActionButton(III custom, float btnX, float btnY, float btnW, float btnH, String text, boolean hov, ColorRGBA accentColor) {
        IIiii_Class8 bRad = IIiii_Class8.I_method_893b2757(btnH / 2.0F);

        boolean isMouseDown = GLFW.glfwGetMouseButton(MinecraftClient.getInstance().getWindow().getHandle(), 0) == 1;
        boolean pressed = hov && isMouseDown;

        // 1. Atmospheric soft glow shadow
        float shadowAlpha = pressed ? 150.0F : (hov ? 120.0F : 45.0F);
        custom.drawShadow(btnX, btnY, btnW, btnH, hov ? 10.0F : 5.0F, bRad, accentColor.withAlpha(shadowAlpha));

        // 2. Vibrant Theme Color Background
        ColorRGBA bg = hov
            ? (pressed ? accentColor.withAlpha(255.0F) : accentColor.withAlpha(240.0F))
            : accentColor.withAlpha(195.0F);
        custom.drawRoundedRect(btnX, btnY, btnW, btnH, bRad, bg);

        // 3. Delicate gleam border
        ColorRGBA border = hov
            ? new ColorRGBA(255.0F, 255.0F, 255.0F, pressed ? 180.0F : 140.0F)
            : new ColorRGBA(255.0F, 255.0F, 255.0F, 50.0F);
        custom.drawRoundedBorder(btnX, btnY, btnW, btnH, 0.7F, bRad, border);

        // 4. Crisp Bold typography (white text)
        IIiIIi_Class10 font = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.5F);
        float tw = font.I_method_2c375926(text);
        custom.drawText(font, text, btnX + (btnW - tw) / 2.0F, btnY + (btnH - 7.5F) / 2.0F, ColorRGBA.WHITE);
    }

    public static float springEase(float t, float overshoot) {
        t = MathHelper.clamp(t, 0.0F, 1.0F) - 1.0F;
        return t * t * ((overshoot + 1.0F) * t + overshoot) + 1.0F;
    }

    public void setTab(Tab tab) {
        if (this.currentTab != tab) {
            this.currentTab = tab;
            this.screenOpenTime = System.currentTimeMillis();
            this.targetScrollY = 0.0F;
            this.cardHoverAnim.clear();
        }
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
        float cardW = 340.0F;
        float cardH = 76.0F;
        float gap = 16.0F;
        float padX = 24.0F;
        float availW = this.width - padX * 2.0F;
        int cols = Math.max(1, Math.min(3, (int) ((availW + gap) / (cardW + gap))));
        float gridW = cols * cardW + (cols - 1) * gap;
        float startX = (this.width - gridW) / 2.0F;

        int totalRows = (items.size() + cols - 1) / cols;
        float totalGridH = totalRows * (cardH + gap);
        this.maxScroll = Math.max(0.0F, totalGridH - h + 20.0F);

        // Hardware Scissor Viewport
        iIiiiIiII_Class373.I_method_d5a5ee51(custom.getMatrices(), padX - 4.0F, top, availW + 8.0F, h);

        if (items.isEmpty()) {
            float emptyW = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(10.0F).I_method_2c375926("No worlds or servers available");
            custom.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(10.0F), "No worlds or servers available", (this.width - emptyW) / 2.0F, top + h / 2.0F - 10.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 120.0F));
            custom.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.5F), "Use the bottom dock to create a world or add a server", (this.width - 240.0F) / 2.0F, top + h / 2.0F + 8.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 85.0F));
        } else {
            long elapsed = System.currentTimeMillis() - this.screenOpenTime;
            for (int i = 0; i < items.size(); i++) {
                int col = i % cols;
                int row = i / cols;
                float cx = startX + col * (cardW + gap);
                float baseCy = top - this.scrollY + row * (cardH + gap);

                // Cascade spring pop-in animation per card with stagger
                long delay = 35L + (long)(i * 26L);
                float cardProgress = MathHelper.clamp((elapsed - delay) / 320.0F, 0.0F, 1.0F);
                if (cardProgress <= 0.0F) continue; // Waiting for stagger delay

                float cardSpring = springEase(cardProgress, 0.82F);
                float cardAlpha = MathHelper.clamp(cardProgress * 1.6F, 0.0F, 1.0F);
                float cy = baseCy + (1.0F - cardSpring) * 26.0F;

                if (cy + cardH < top || cy > top + h) {
                    continue; // Culled
                }

                boolean isCardHov = (mx >= cx && mx <= cx + cardW && my >= cy && my <= cy + cardH);
                float prevHov = this.cardHoverAnim.getOrDefault(i, 0.0F);
                float curHov = prevHov + ((isCardHov ? 1.0F : 0.0F) - prevHov) * 0.22F;
                this.cardHoverAnim.put(i, curHov);

                Object obj = items.get(i);
                if (obj instanceof WorldItem w) {
                    this.renderWorldCard(custom, w, cx, cy, cardW, cardH, mx, my, curHov, cardSpring, cardAlpha);
                } else if (obj instanceof ServerItem s) {
                    this.renderServerCard(custom, s, cx, cy, cardW, cardH, mx, my, curHov, cardSpring, cardAlpha);
                }
            }
        }

        iIiiiIiII_Class373.I_method_ff80a1df();
    }

    private void renderWorldCard(III custom, WorldItem w, float x, float y, float wCard, float hCard, int mx, int my, float curHov, float cardSpring, float cardAlpha) {
        boolean hov = curHov > 0.05F;
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(16.0F);
        ColorRGBA theme = IiiiiIIIi_Class242.I_method_7df8e08e();

        float drawY = y - 5.5F * curHov;

        custom.getMatrices().push();
        float midX = x + wCard / 2.0F;
        float midY = drawY + hCard / 2.0F;
        float cardScale = (0.92F + 0.08F * cardSpring) * (1.0F + 0.034F * curHov);
        custom.getMatrices().translate(midX, midY, 0.0F);
        custom.getMatrices().scale(cardScale, cardScale, 1.0F);
        custom.getMatrices().translate(-midX, -midY, 0.0F);

        // Atmospheric drop shadow & hover glow with smooth expansion
        custom.drawShadow(x, drawY, wCard, hCard, 10.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 35.0F * cardAlpha));

        // Card glass background: rgba(20, 24, 35, 0.7)
        ColorRGBA bg = new ColorRGBA(
            (int) (20.0F + 10.0F * curHov),
            (int) (24.0F + 12.0F * curHov),
            (int) (35.0F + 18.0F * curHov),
            (int) ((180.0F + 45.0F * curHov) * cardAlpha)
        );
        custom.drawRoundedRect(x, drawY, wCard, hCard, rad, bg);
        // Dynamic glowing border on hover
        ColorRGBA border = new ColorRGBA(255.0F, 255.0F, 255.0F, (20.0F + 35.0F * curHov) * cardAlpha);
        custom.drawRoundedBorder(x, drawY, wCard, hCard, 0.6F, rad, border);

        // Squircle Icon: 52x52px with 12px rounding
        float iconSize = 52.0F;
        float iconX = x + 12.0F;
        float iconY = drawY + (hCard - iconSize) / 2.0F;
        IIiii_Class8 iconRad = IIiii_Class8.I_method_893b2757(12.0F);

        w.loadIconTexture();
        if (w.iconTextureId != null) {
            custom.drawRoundedTexture(w.iconTextureId, iconX, iconY, iconSize, iconSize, iconRad, ColorRGBA.WHITE.withAlpha(255.0F * cardAlpha));
            custom.drawRoundedBorder(iconX, iconY, iconSize, iconSize, 0.8F, iconRad, hov ? theme.withAlpha(255.0F * cardAlpha) : new ColorRGBA(255.0F, 255.0F, 255.0F, 30.0F * cardAlpha));
        } else {
            // Vibrant grass green gradient for worlds without screenshot
            custom.drawRoundedRect(iconX, iconY, iconSize, iconSize, iconRad, new ColorRGBA(40.0F, 120.0F, 70.0F, 220.0F * cardAlpha));
            custom.drawRoundedBorder(iconX, iconY, iconSize, iconSize, 0.8F, iconRad, new ColorRGBA(120.0F, 240.0F, 160.0F, 180.0F * cardAlpha));
            custom.drawIcon("logo", iconX + (iconSize - 20.0F) / 2.0F, iconY + (iconSize - 20.0F) / 2.0F, 20.0F, ColorRGBA.WHITE.withAlpha(255.0F * cardAlpha));
        }

        // World Info Text
        float textX = iconX + iconSize + 12.0F;
        String title = w.displayName;
        custom.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(9.0F), title, textX, drawY + 13.0F, ColorRGBA.WHITE.withAlpha(255.0F * cardAlpha));

        // Subtitle & Mode (#8E95A5)
        String dateStr = w.lastPlayed > 0 ? DATE_FORMAT.format(new Date(w.lastPlayed)) : "Never";
        custom.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F), dateStr + " • " + w.version, textX, drawY + 30.0F, new ColorRGBA(142.0F, 149.0F, 165.0F, 255.0F * cardAlpha));

        // Subtle muted mode info (#8E95A5)
        float statusY = drawY + 47.0F;
        ColorRGBA mutedCol = new ColorRGBA(142.0F, 149.0F, 165.0F, 200.0F * cardAlpha);
        String modeName = w.hardcore ? "Hardcore" : "Singleplayer";
        custom.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.5F), modeName, textX, statusY, mutedCol);

        // Quick Launch Capsule Button: 64x26px, cleanly inside card
        float btnW = 64.0F;
        float btnH = 26.0F;
        float btnX = x + wCard - btnW - 18.0F;
        float btnY = drawY + (hCard - btnH) / 2.0F;
        boolean bHov = mx >= btnX && mx <= btnX + btnW && my >= btnY && my <= btnY + btnH;
        boolean isRu = IiIiIIII_Class81.I_method_21a4cfeb() == IiIIiiii_Class80.i_field_3f56db61;
        this.renderActionButton(custom, btnX, btnY, btnW, btnH, isRu ? "Играть" : "Play", bHov, theme.withAlpha(255.0F * cardAlpha));

        custom.getMatrices().pop();
    }

    private void renderServerCard(III custom, ServerItem s, float x, float y, float wCard, float hCard, int mx, int my, float curHov, float cardSpring, float cardAlpha) {
        boolean hov = curHov > 0.05F;
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(16.0F);
        ColorRGBA theme = IiiiiIIIi_Class242.I_method_7df8e08e();

        float drawY = y - 5.5F * curHov;

        custom.getMatrices().push();
        float midX = x + wCard / 2.0F;
        float midY = drawY + hCard / 2.0F;
        float cardScale = (0.92F + 0.08F * cardSpring) * (1.0F + 0.034F * curHov);
        custom.getMatrices().translate(midX, midY, 0.0F);
        custom.getMatrices().scale(cardScale, cardScale, 1.0F);
        custom.getMatrices().translate(-midX, -midY, 0.0F);

        // Atmospheric drop shadow & hover glow with smooth expansion
        custom.drawShadow(x, drawY, wCard, hCard, 10.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 35.0F * cardAlpha));

        // Card glass background: rgba(20, 24, 35, 0.7)
        ColorRGBA bg = new ColorRGBA(
            (int) (20.0F + 10.0F * curHov),
            (int) (24.0F + 12.0F * curHov),
            (int) (35.0F + 18.0F * curHov),
            (int) ((180.0F + 45.0F * curHov) * cardAlpha)
        );
        custom.drawRoundedRect(x, drawY, wCard, hCard, rad, bg);
        // Dynamic glowing border on hover
        ColorRGBA border = new ColorRGBA(255.0F, 255.0F, 255.0F, (20.0F + 35.0F * curHov) * cardAlpha);
        custom.drawRoundedBorder(x, drawY, wCard, hCard, 0.6F, rad, border);

        // Squircle Icon: 52x52px with 12px rounding
        float iconSize = 52.0F;
        float iconX = x + 12.0F;
        float iconY = drawY + (hCard - iconSize) / 2.0F;
        IIiii_Class8 iconRad = IIiii_Class8.I_method_893b2757(12.0F);

        // Update / register dynamic favicon if server provided one
        s.updateFaviconTexture();

        if (s.faviconTextureId != null) {
            // Fill the rounded squircle with the real server favicon
            custom.drawRoundedTexture(s.faviconTextureId, iconX, iconY, iconSize, iconSize, iconRad, ColorRGBA.WHITE.withAlpha(255.0F * cardAlpha));
            custom.drawRoundedBorder(iconX, iconY, iconSize, iconSize, 0.8F, iconRad, hov ? theme.withAlpha(255.0F * cardAlpha) : new ColorRGBA(255.0F, 255.0F, 255.0F, 30.0F * cardAlpha));
        } else {
            // Beautiful fallback monogram initial letter
            custom.drawRoundedRect(iconX, iconY, iconSize, iconSize, iconRad, new ColorRGBA(32.0F, 42.0F, 64.0F, 220.0F * cardAlpha));
            custom.drawRoundedBorder(iconX, iconY, iconSize, iconSize, 0.8F, iconRad, hov ? theme.withAlpha(255.0F * cardAlpha) : new ColorRGBA(90.0F, 190.0F, 255.0F, 140.0F * cardAlpha));
            String initial = s.name.trim().isEmpty() ? "S" : s.name.trim().substring(0, 1).toUpperCase();
            IIiIIi_Class10 letterFont = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(16.0F);
            float lw = letterFont.I_method_2c375926(initial);
            custom.drawText(letterFont, initial, iconX + (iconSize - lw) / 2.0F, iconY + (iconSize - 16.0F) / 2.0F + 1.0F, ColorRGBA.WHITE.withAlpha(255.0F * cardAlpha));
        }

        // Server Info Text
        float textX = iconX + iconSize + 12.0F;
        custom.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(9.0F), s.name, textX, drawY + 13.0F, ColorRGBA.WHITE.withAlpha(255.0F * cardAlpha));

        // Server Address (#8E95A5)
        custom.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F), s.address, textX, drawY + 30.0F, new ColorRGBA(142.0F, 149.0F, 165.0F, 255.0F * cardAlpha));

        // Ping badge & players count with indicator dot
        String statusText;
        ColorRGBA statusCol;
        if (!s.pinged) {
            statusText = "Connecting...";
            statusCol = new ColorRGBA(255.0F, 255.0F, 255.0F, 140.0F);
        } else if (s.online) {
            statusCol = new ColorRGBA(74.0F, 222.0F, 128.0F, 255.0F);
            if (!s.playerCount.isEmpty()) {
                statusText = s.playerCount + " players" + (s.ping > 0 ? " • " + s.ping + " ms" : "");
            } else if (s.ping > 0) {
                statusText = s.ping + " ms • Online";
            } else {
                statusText = "Online";
            }
        } else {
            statusText = "Offline";
            statusCol = new ColorRGBA(248.0F, 113.0F, 113.0F, 255.0F);
        }

        float statusY = drawY + 47.0F;
        ColorRGBA mutedSrvCol = new ColorRGBA(142.0F, 149.0F, 165.0F, 200.0F * cardAlpha);
        custom.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.5F), statusText, textX, statusY, mutedSrvCol);

        // Quick Launch Capsule Button: 64x26px, cleanly inside card
        float btnW = 64.0F;
        float btnH = 26.0F;
        float btnX = x + wCard - btnW - 18.0F;
        float btnY = drawY + (hCard - btnH) / 2.0F;
        boolean bHov = mx >= btnX && mx <= btnX + btnW && my >= btnY && my <= btnY + btnH;
        boolean isRu = IiIiIIII_Class81.I_method_21a4cfeb() == IiIIiiii_Class80.i_field_3f56db61;
        this.renderActionButton(custom, btnX, btnY, btnW, btnH, isRu ? "Войти" : "Connect", bHov, theme.withAlpha(255.0F * cardAlpha));

        custom.getMatrices().pop();
    }

    private void renderDock(III custom, int mx, int my) {
        long elapsed = System.currentTimeMillis() - this.screenOpenTime;
        float dockEnter = MathHelper.clamp((elapsed - 50L) / 360.0F, 0.0F, 1.0F);
        float dockEase = springEase(dockEnter, 0.70F);

        float dockW = Math.min(480.0F, this.width - 40.0F);
        float dockH = 40.0F;
        float dockX = (this.width - dockW) / 2.0F;
        float dockY = (this.height - dockH - 12.0F) + (1.0F - dockEase) * 55.0F;
        IIiii_Class8 dRad = IIiii_Class8.I_method_893b2757(dockH / 2.0F);

        // Glass Dock Container
        custom.drawRoundedRect(dockX, dockY, dockW, dockH, dRad, new ColorRGBA(18.0F, 22.0F, 32.0F, 210.0F));
        custom.drawRoundedBorder(dockX, dockY, dockW, dockH, 0.8F, dRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 36.0F));

        // 5 Action Pills
        String[] actions = {"+ New World", "+ Add Server", "Direct Connect", "Refresh", "Back"};
        float pillW = (dockW - 16.0F) / actions.length;

        for (int i = 0; i < actions.length; i++) {
            float px = dockX + 8.0F + i * pillW;
            float py = dockY + 4.0F;
            float pw = pillW - 4.0F;
            float ph = dockH - 8.0F;
            IIiii_Class8 pRad = IIiii_Class8.I_method_893b2757(ph / 2.0F);

            float pcx = px + pw / 2.0F;
            float pcy = py + ph / 2.0F;
            float dist = (float)Math.hypot(mx - pcx, my - pcy);
            float proximity = (my >= dockY - 12.0F && my <= dockY + dockH + 12.0F)
                ? Math.max(0.0F, 1.0F - dist / 85.0F)
                : 0.0F;

            boolean pHov = mx >= px && mx <= px + pw && my >= py && my <= py + ph;
            boolean isMouseDown = GLFW.glfwGetMouseButton(MinecraftClient.getInstance().getWindow().getHandle(), 0) == 1;
            boolean pressed = pHov && isMouseDown;

            float targetHov = pHov ? 1.0F : (proximity * 0.42F);
            this.dockPillHover[i] += (targetHov - this.dockPillHover[i]) * 0.25F;
            float hAnim = this.dockPillHover[i];

            float scale = pressed ? 0.92F : (1.0F + 0.10F * hAnim);
            float drawPy = py - 6.0F * hAnim;

            custom.getMatrices().push();
            custom.getMatrices().translate(pcx, drawPy + ph / 2.0F, 0.0F);
            custom.getMatrices().scale(scale, scale, 1.0F);
            custom.getMatrices().translate(-pcx, -(drawPy + ph / 2.0F), 0.0F);

            if (hAnim > 0.01F) {
                custom.drawShadow(px, drawPy, pw, ph, 10.0F, pRad, IiiiiIIIi_Class242.I_method_7df8e08e().withAlpha(95.0F * hAnim));
            }

            ColorRGBA pBg = new ColorRGBA(
                (int) (28.0F + 28.0F * hAnim),
                (int) (32.0F + 32.0F * hAnim),
                (int) (46.0F + 44.0F * hAnim),
                (int) (165.0F + 65.0F * hAnim)
            );
            custom.drawRoundedRect(px, drawPy, pw, ph, pRad, pBg);
            custom.drawRoundedBorder(px, drawPy, pw, ph, 0.7F, pRad, IiiiiIIIi_Class242.I_method_7df8e08e().withAlpha(25.0F + 180.0F * hAnim));

            String[] pillIcons = {"hud/world", "hud/player", "play", "search", "back"};
            float iconSz = 11.0F;
            float tw = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.5F).I_method_2c375926(actions[i]);
            float totalW = iconSz + 4.0F + tw;
            float startContentX = px + (pw - totalW) / 2.0F;
            custom.drawIcon(pillIcons[i], startContentX, drawPy + (ph - iconSz) / 2.0F, iconSz, ColorRGBA.WHITE);
            custom.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.5F), actions[i], startContentX + iconSz + 4.0F, drawPy + (ph - 6.5F) / 2.0F, hAnim > 0.5F ? ColorRGBA.WHITE : new ColorRGBA(255.0F, 255.0F, 255.0F, 185.0F));

            custom.getMatrices().pop();
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
        float closeSize = 22.0F;
        float closeX = barX + barW - closeSize - 8.0F;
        float closeY = barY + (barH - closeSize) / 2.0F;
        if (mx >= closeX && mx <= closeX + closeSize && my >= closeY && my <= closeY + closeSize) {
            this.close();
            return true;
        }

        // 2. Check Search Bar
        float searchW = Math.min(260.0F, barW * 0.32F);
        float searchX = barX + (barW - searchW) / 2.0F;
        float searchY = barY + 4.0F;
        float searchH = barH - 8.0F;
        if (mx >= searchX && mx <= searchX + searchW && my >= searchY && my <= searchY + searchH) {
            // Check clear button xmark
            float clrSize = 14.0F;
            float clrX = searchX + searchW - clrSize - 6.0F;
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

            float cardW = 340.0F;
            float cardH = 76.0F;
            float gap = 16.0F;
            float padX = 24.0F;
            float availW = this.width - padX * 2.0F;
            int cols = Math.max(1, Math.min(3, (int) ((availW + gap) / (cardW + gap))));
            float gridW = cols * cardW + (cols - 1) * gap;
            float startX = (this.width - gridW) / 2.0F;

            for (int i = 0; i < items.size(); i++) {
                int col = i % cols;
                int row = i / cols;
                float cx = startX + col * (cardW + gap);
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
