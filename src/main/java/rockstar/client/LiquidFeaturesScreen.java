package rockstar.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.glfw.GLFW;
import pyrock.utility.render.ColorRGBA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * LiquidFeaturesScreen — 1-to-1 Recreation of the Liquid Client "Features" (ClickGUI) Glass Interface.
 * Features:
 * - Apple Liquid Glass floating window with specular highlight gleam
 * - Left Sidebar with Categories (Movement, Combat/Protect, Visuals, Misc, Interface)
 * - Animated category active indicators with glowing gradient and shine sweep
 * - 2-Column Module Grid with gradient icon badges, titles, descriptions, and iOS green switches
 * - Module Detail Settings View: Hero header, Sliders with value badges, Segmented mode pickers, Keybinds, and Switches
 * - Interface Settings View: Themes grid, Accent color dots, Blur/Opacity sliders, and toggles
 * - Integrated Search Bar with real-time filtering
 * - Smooth spring animations and mouse interactions
 */
public class LiquidFeaturesScreen extends IiiIIiiiI_Class207 {

    public enum NavCategory {
        MOVEMENT("Движение", "move", new ColorRGBA(0.0F, 134.0F, 255.0F, 255.0F), new ColorRGBA(0.0F, 122.0F, 255.0F, 255.0F)),
        COMBAT("Защита", "shield", new ColorRGBA(123.0F, 97.0F, 255.0F, 255.0F), new ColorRGBA(94.0F, 92.0F, 230.0F, 255.0F)),
        VISUALS("Визуал", "eye", new ColorRGBA(255.0F, 94.0F, 122.0F, 255.0F), new ColorRGBA(255.0F, 45.0F, 85.0F, 255.0F)),
        MISC("Разное", "grid", new ColorRGBA(76.0F, 217.0F, 100.0F, 255.0F), new ColorRGBA(48.0F, 209.0F, 88.0F, 255.0F)),
        INTERFACE("Интерфейс", "setting", new ColorRGBA(255.0F, 179.0F, 64.0F, 255.0F), new ColorRGBA(255.0F, 149.0F, 0.0F, 255.0F));

        public final String title;
        public final String icon;
        public final ColorRGBA color1;
        public final ColorRGBA color2;

        NavCategory(String title, String icon, ColorRGBA color1, ColorRGBA color2) {
            this.title = title;
            this.icon = icon;
            this.color1 = color1;
            this.color2 = color2;
        }
    }

    public enum ViewMode {
        LIST,
        DETAIL,
        INTERFACE
    }

    // State
    private NavCategory currentCategory = NavCategory.MOVEMENT;
    private ViewMode viewMode = ViewMode.LIST;
    private Module selectedModule = null;

    private final long screenOpenTime = System.currentTimeMillis();
    private float openAnim = 0.0F;

    // Smooth hover animations for categories
    private final float[] catHover = new float[NavCategory.values().length];

    // Search bar
    private String searchQuery = "";
    private boolean searchFocused = false;

    // Scrolling
    private float listScrollY = 0.0F;
    private float targetListScrollY = 0.0F;
    private float detailScrollY = 0.0F;
    private float targetDetailScrollY = 0.0F;

    // Slider dragging
    private SliderSetting draggingSlider = null;
    private float dragSliderX = 0.0F;
    private float dragSliderW = 0.0F;

    // Keybind listening
    private boolean listeningKeybind = false;
    private Setting listeningSetting = null;

    public LiquidFeaturesScreen() {
        this.closing = false;
        this.contentAlpha = 1.0F;
    }

    @Override
    public void init() {
        super.init();
        this.closing = false;
        this.contentAlpha = 1.0F;
    }

    @Override
    public void render(III custom) {
        // 1. Entrance animation
        long elapsed = System.currentTimeMillis() - this.screenOpenTime;
        float enterT = MathHelper.clamp(elapsed / 260.0F, 0.0F, 1.0F);
        this.openAnim = 1.0F - (float) Math.pow(1.0F - enterT, 3);

        // Smooth scroll interpolation
        this.listScrollY += (this.targetListScrollY - this.listScrollY) * 0.28F;
        this.detailScrollY += (this.targetDetailScrollY - this.detailScrollY) * 0.28F;

        // 2. Full background (wallpaper with dark tinted frosted veil)
        ThemeAndBackgroundManager.getInstance().renderActiveBackground(custom, this.width, this.height, custom.I_method_b1c3e152(), custom.i_method_b1d26d32());
        custom.drawRect(0, 0, this.width, this.height, new ColorRGBA(6.0F, 6.0F, 10.0F, 130.0F * this.openAnim));

        // 3. Center Window dimensions (.menu-feat in HTML: 1180 x 700 ratio)
        float winW = Math.min(620.0F, this.width - 32.0F);
        float winH = Math.min(390.0F, this.height - 32.0F);
        float winX = (this.width - winW) / 2.0F;
        float winY = (this.height - winH) / 2.0F;
        IIiii_Class8 winRad = IIiii_Class8.I_method_893b2757(20.0F);

        float scale = 0.94F + 0.06F * this.openAnim;
        float cx = this.width / 2.0F;
        float cy = this.height / 2.0F;

        custom.getMatrices().push();
        custom.getMatrices().translate(cx, cy, 0.0F);
        custom.getMatrices().scale(scale, scale, 1.0F);
        custom.getMatrices().translate(-cx, -cy, 0.0F);

        // 4. Apple Liquid Glass Container
        ColorRGBA theme = IiiiiIIIi_Class242.I_method_7df8e08e();
        custom.drawShadow(winX, winY, winW, winH, 24.0F, winRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 75.0F));
        custom.drawBlurredRect(winX, winY, winW, winH, 20.0F, 3.0F, winRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 12.0F));
        custom.drawRoundedRect(winX, winY, winW, winH, winRad, new ColorRGBA(18.0F, 22.0F, 34.0F, 230.0F));
        custom.drawRoundedBorder(winX, winY, winW, winH, 1.0F, winRad, theme.withAlpha(120.0F));
        custom.drawRoundedRect(winX + 16.0F, winY + 1.2F, winW - 32.0F, 1.0F, IIiii_Class8.I_method_893b2757(0.5F), new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F));

        int mx = custom.I_method_b1c3e152();
        int my = custom.i_method_b1d26d32();

        // 5. Left Sidebar (.feat-side)
        float sideW = 146.0F;
        this.renderSidebar(custom, winX, winY, sideW, winH, mx, my);

        // Divider
        custom.drawRect(winX + sideW, winY + 6.0F, 1.0F, winH - 12.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F));

        // 6. Right Content Area (.feat-content-wrap)
        float contentX = winX + sideW + 12.0F;
        float contentY = winY + 12.0F;
        float contentW = winW - sideW - 24.0F;
        float contentH = winH - 24.0F;

        if (this.viewMode == ViewMode.LIST) {
            this.renderModuleList(custom, contentX, contentY, contentW, contentH, mx, my);
        } else if (this.viewMode == ViewMode.DETAIL) {
            this.renderModuleDetail(custom, contentX, contentY, contentW, contentH, mx, my);
        } else if (this.viewMode == ViewMode.INTERFACE) {
            this.renderInterfaceView(custom, contentX, contentY, contentW, contentH, mx, my);
        }

        // Close button at top right [✕]
        float closeSz = 22.0F;
        float closeX = winX + winW - closeSz - 12.0F;
        float closeY = winY + 12.0F;
        boolean closeHov = mx >= closeX && mx <= closeX + closeSz && my >= closeY && my <= closeY + closeSz;
        IIiii_Class8 cRad = IIiii_Class8.I_method_893b2757(closeSz / 2.0F);

        custom.drawRoundedRect(closeX, closeY, closeSz, closeSz, cRad, closeHov ? new ColorRGBA(239.0F, 68.0F, 68.0F, 200.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));
        custom.drawRoundedBorder(closeX, closeY, closeSz, closeSz, 0.6F, cRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 30.0F));
        IIiIIi_Class10 font = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.5F);
        if (font != null) {
            float tw = font.I_method_2c375926("×");
            custom.drawText(font, "×", closeX + (closeSz - tw) / 2.0F, closeY + (closeSz - 7.5F) / 2.0F, ColorRGBA.WHITE);
        }

        custom.getMatrices().pop();
    }

    // ==========================================
    // SIDEBAR RENDERING (.feat-side)
    // ==========================================
    private void renderSidebar(III custom, float x, float y, float w, float h, int mx, int my) {
        IIiIIi_Class10 bold = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F);
        IIiIIi_Class10 sub = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F);

        // Logo
        float markSz = 24.0F;
        float markX = x + 14.0F;
        float markY = y + 14.0F;
        IIiii_Class8 mRad = IIiii_Class8.I_method_893b2757(7.0F);

        custom.drawShadow(markX, markY, markSz, markSz, 8.0F, mRad, new ColorRGBA(94.0F, 92.0F, 230.0F, 120.0F));
        custom.drawRoundedRect(markX, markY, markSz, markSz, mRad, new ColorRGBA(0.0F, 134.0F, 255.0F, 255.0F));
        custom.drawIcon("lightning", markX + (markSz - 12.0F) / 2.0F, markY + (markSz - 12.0F) / 2.0F, 12.0F, ColorRGBA.WHITE);

        if (bold != null) {
            custom.drawText(bold, "Liquid Client", markX + markSz + 8.0F, markY + 4.0F, ColorRGBA.WHITE);
        }
        if (sub != null) {
            custom.drawText(sub, "v2.4.1", markX + markSz + 8.0F, markY + 14.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 120.0F));
        }

        // Categories List
        NavCategory[] cats = NavCategory.values();
        float tabStartY = y + 52.0F;
        float tabH = 30.0F;
        float tabW = w - 20.0F;
        float tabX = x + 10.0F;
        IIiii_Class8 tRad = IIiii_Class8.I_method_893b2757(9.0F);

        for (int i = 0; i < cats.length; i++) {
            NavCategory cat = cats[i];
            float tabY = tabStartY + i * (tabH + 5.0F);
            boolean isCur = (cat == this.currentCategory);
            boolean isHov = mx >= tabX && mx <= tabX + tabW && my >= tabY && my <= tabY + tabH;

            this.catHover[i] += ((isHov ? 1.0F : 0.0F) - this.catHover[i]) * 0.25F;
            float hA = this.catHover[i];

            if (isCur) {
                // Active category: Glowing gradient pill (#0086ff -> #5e5ce6) + shine
                custom.drawShadow(tabX, tabY, tabW, tabH, 10.0F, tRad, cat.color2.withAlpha(120.0F));
                custom.drawRoundedRect(tabX, tabY, tabW, tabH, tRad, cat.color1);
                custom.drawRoundedBorder(tabX, tabY, tabW, tabH, 0.7F, tRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 70.0F));
                custom.drawRoundedRect(tabX + 4.0F, tabY + 1.0F, tabW - 8.0F, 1.0F, IIiii_Class8.I_method_893b2757(0.5F), new ColorRGBA(255.0F, 255.0F, 255.0F, 85.0F));
            } else if (hA > 0.01F) {
                custom.drawRoundedRect(tabX, tabY, tabW, tabH, tRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F * hA));
            }

            // Icon + Label
            float iconSz = 14.0F;
            float iconX = tabX + 10.0F;
            float iconY = tabY + (tabH - iconSz) / 2.0F;

            custom.drawIcon(cat.icon, iconX, iconY, iconSz, isCur ? ColorRGBA.WHITE : new ColorRGBA(255.0F, 255.0F, 255.0F, 160.0F + 80.0F * hA));
            if (bold != null) {
                ColorRGBA textCol = isCur ? ColorRGBA.WHITE : new ColorRGBA(255.0F, 255.0F, 255.0F, 150.0F + 80.0F * hA);
                custom.drawText(bold, cat.title, iconX + iconSz + 8.0F, tabY + (tabH - 8.0F) / 2.0F, textCol);
            }
        }
    }

    // ==========================================
    // VIEW 1: MODULE LIST GRID (.feature-grid)
    // ==========================================
    private void renderModuleList(III custom, float x, float y, float w, float h, int mx, int my) {
        IIiIIi_Class10 bold = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(10.0F);
        IIiIIi_Class10 sub = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F);
        IIiIIi_Class10 cardFont = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F);

        // Header Title
        if (bold != null) {
            custom.drawText(bold, this.currentCategory.title, x + 4.0F, y + 2.0F, ColorRGBA.WHITE);
        }
        if (sub != null) {
            custom.drawText(sub, "Нажми на модуль, чтобы открыть его настройки", x + 4.0F, y + 16.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 130.0F));
        }

        // Search Bar in Header
        float sW = 120.0F;
        float sH = 20.0F;
        float sX = x + w - sW - 28.0F;
        float sY = y + 2.0F;
        IIiii_Class8 sRad = IIiii_Class8.I_method_893b2757(sH / 2.0F);

        boolean sHov = mx >= sX && mx <= sX + sW && my >= sY && my <= sY + sH;
        custom.drawRoundedRect(sX, sY, sW, sH, sRad, this.searchFocused ? new ColorRGBA(36.0F, 44.0F, 64.0F, 220.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, sHov ? 35.0F : 20.0F));
        custom.drawRoundedBorder(sX, sY, sW, sH, 0.6F, sRad, this.searchFocused ? IiiiiIIIi_Class242.I_method_7df8e08e() : new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));
        custom.drawIcon("search", sX + 7.0F, sY + 5.0F, 10.0F, ColorRGBA.WHITE);

        if (sub != null) {
            if (this.searchQuery.isEmpty()) {
                custom.drawText(sub, "Поиск...", sX + 20.0F, sY + 6.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 100.0F));
            } else {
                String cur = this.searchFocused && (System.currentTimeMillis() % 1000L < 500L) ? "|" : "";
                custom.drawText(sub, this.searchQuery + cur, sX + 20.0F, sY + 6.0F, ColorRGBA.WHITE);
            }
        }

        // Modules List
        List<Module> mods = this.getModulesForCategory(this.currentCategory);
        if (!this.searchQuery.isEmpty()) {
            String q = this.searchQuery.toLowerCase();
            mods = mods.stream().filter(m -> m.getName().toLowerCase().contains(q) || this.getModuleDesc(m).toLowerCase().contains(q)).toList();
        }

        float gridTop = y + 36.0F;
        float gridH = h - 36.0F;
        float gap = 8.0F;
        float cardW = (w - gap) / 2.0F;
        float cardH = 42.0F;

        int rows = (mods.size() + 1) / 2;
        float maxScroll = Math.max(0.0F, rows * (cardH + gap) - gridH);
        this.targetListScrollY = MathHelper.clamp(this.targetListScrollY, 0.0F, maxScroll);

        // Scissor for smooth scrolling
        custom.enableScissor((int) x, (int) gridTop, (int) (x + w), (int) (gridTop + gridH));

        IIiii_Class8 cRad = IIiii_Class8.I_method_893b2757(11.0F);

        for (int i = 0; i < mods.size(); i++) {
            Module mod = mods.get(i);
            int r = i / 2;
            int c = i % 2;

            float cx = x + c * (cardW + gap);
            float cy = gridTop + r * (cardH + gap) - this.listScrollY;

            if (cy + cardH < gridTop || cy > gridTop + gridH) continue;

            boolean cardHov = mx >= cx && mx <= cx + cardW && my >= cy && my <= cy + cardH;

            // Glass Card
            custom.drawRoundedRect(cx, cy, cardW, cardH, cRad, cardHov ? new ColorRGBA(255.0F, 255.0F, 255.0F, 36.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F));
            custom.drawRoundedBorder(cx, cy, cardW, cardH, 0.7F, cRad, cardHov ? this.currentCategory.color2.withAlpha(140.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 22.0F));

            // Left: Icon Badge (28x28 with category gradient)
            float bSz = 26.0F;
            float bX = cx + 8.0F;
            float bY = cy + (cardH - bSz) / 2.0F;
            IIiii_Class8 bRad = IIiii_Class8.I_method_893b2757(8.0F);

            custom.drawShadow(bX, bY, bSz, bSz, 6.0F, bRad, this.currentCategory.color2.withAlpha(90.0F));
            custom.drawRoundedRect(bX, bY, bSz, bSz, bRad, this.currentCategory.color1);
            custom.drawIcon(this.currentCategory.icon, bX + (bSz - 14.0F) / 2.0F, bY + (bSz - 14.0F) / 2.0F, 14.0F, ColorRGBA.WHITE);

            // Center: Module Name & Description
            if (cardFont != null) {
                custom.drawText(cardFont, mod.getName(), bX + bSz + 8.0F, cy + 9.0F, ColorRGBA.WHITE);
            }
            if (sub != null) {
                String desc = this.getModuleDesc(mod);
                custom.drawText(sub, desc, bX + bSz + 8.0F, cy + 22.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 120.0F));
            }

            // Right: iOS Green Toggle Switch (.switch)
            float swW = 34.0F;
            float swH = 20.0F;
            float swX = cx + cardW - swW - 8.0F;
            float swY = cy + (cardH - swH) / 2.0F;

            this.renderIOSSwitch(custom, swX, swY, swW, swH, mod.isEnabled(), mx, my);
        }

        custom.disableScissor();
    }

    // ==========================================
    // VIEW 2: MODULE DETAIL VIEW (.feat-view#viewDetail)
    // ==========================================
    private void renderModuleDetail(III custom, float x, float y, float w, float h, int mx, int my) {
        if (this.selectedModule == null) {
            this.viewMode = ViewMode.LIST;
            return;
        }

        IIiIIi_Class10 bold = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(10.0F);
        IIiIIi_Class10 sub = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F);
        IIiIIi_Class10 heroFont = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(12.0F);

        // 1. Back button (.back-btn)
        float bkW = 110.0F;
        float bkH = 20.0F;
        float bkX = x + 4.0F;
        float bkY = y + 2.0F;
        IIiii_Class8 bkRad = IIiii_Class8.I_method_893b2757(6.0F);

        boolean bkHov = mx >= bkX && mx <= bkX + bkW && my >= bkY && my <= bkY + bkH;
        custom.drawRoundedRect(bkX, bkY, bkW, bkH, bkRad, bkHov ? new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));
        custom.drawRoundedBorder(bkX, bkY, bkW, bkH, 0.6F, bkRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));
        custom.drawIcon("back", bkX + 6.0F, bkY + 5.0F, 10.0F, ColorRGBA.WHITE);

        if (sub != null) {
            custom.drawText(sub, "Назад к функциям", bkX + 20.0F, bkY + 6.0F, ColorRGBA.WHITE);
        }

        // 2. Hero Card (.fd-hero)
        float heroY = y + 28.0F;
        float heroH = 50.0F;
        IIiii_Class8 hRad = IIiii_Class8.I_method_893b2757(12.0F);

        custom.drawRoundedRect(x, heroY, w, heroH, hRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));
        custom.drawRoundedBorder(x, heroY, w, heroH, 0.7F, hRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));

        // Big Icon Badge
        float iconSz = 34.0F;
        float iconX = x + 10.0F;
        float iconY = heroY + (heroH - iconSz) / 2.0F;
        IIiii_Class8 biRad = IIiii_Class8.I_method_893b2757(10.0F);

        custom.drawShadow(iconX, iconY, iconSz, iconSz, 10.0F, biRad, this.currentCategory.color2.withAlpha(120.0F));
        custom.drawRoundedRect(iconX, iconY, iconSz, iconSz, biRad, this.currentCategory.color1);
        custom.drawIcon(this.currentCategory.icon, iconX + (iconSz - 18.0F) / 2.0F, iconY + (iconSz - 18.0F) / 2.0F, 18.0F, ColorRGBA.WHITE);

        // Name & Description
        if (heroFont != null) {
            custom.drawText(heroFont, this.selectedModule.getName(), iconX + iconSz + 10.0F, heroY + 10.0F, ColorRGBA.WHITE);
        }
        if (sub != null) {
            custom.drawText(sub, this.getModuleDesc(this.selectedModule), iconX + iconSz + 10.0F, heroY + 28.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 140.0F));
        }

        // Master Switch on right
        float mSwW = 38.0F;
        float mSwH = 22.0F;
        float mSwX = x + w - mSwW - 14.0F;
        float mSwY = heroY + (heroH - mSwH) / 2.0F;
        this.renderIOSSwitch(custom, mSwX, mSwY, mSwW, mSwH, this.selectedModule.isEnabled(), mx, my);

        // 3. Settings List
        float setTop = heroY + heroH + 10.0F;
        float setH = h - (setTop - y);

        List<Setting> settings = this.selectedModule.getSettings();
        float contentTotalH = 34.0F + settings.size() * 40.0F;
        float maxScroll = Math.max(0.0F, contentTotalH - setH);
        this.targetDetailScrollY = MathHelper.clamp(this.targetDetailScrollY, 0.0F, maxScroll);

        custom.enableScissor((int) x, (int) setTop, (int) (x + w), (int) (setTop + setH));

        float curY = setTop - this.detailScrollY;

        // Keybind Row
        float kbH = 32.0F;
        if (curY + kbH >= setTop && curY <= setTop + setH) {
            custom.drawRoundedRect(x, curY, w, kbH, IIiii_Class8.I_method_893b2757(8.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, 15.0F));
            if (bold != null) {
                custom.drawText(bold, "Клавиша активации", x + 10.0F, curY + 6.0F, ColorRGBA.WHITE);
            }
            if (sub != null) {
                custom.drawText(sub, "Нажми, чтобы переназначить клавишу", x + 10.0F, curY + 18.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 110.0F));
            }

            // Keybind Button
            float kbW = 60.0F;
            float kbBtnH = 20.0F;
            float kbX = x + w - kbW - 10.0F;
            float kbY = curY + (kbH - kbBtnH) / 2.0F;

            String keyStr = this.listeningKeybind ? "..." : (this.selectedModule.getKeybind() == -1 ? "—" : InputUtil.fromKeyCode(this.selectedModule.getKeybind(), 0).getLocalizedText().getString().toUpperCase());

            boolean kbHov = mx >= kbX && mx <= kbX + kbW && my >= kbY && my <= kbY + kbBtnH;
            custom.drawRoundedRect(kbX, kbY, kbW, kbBtnH, IIiii_Class8.I_method_893b2757(6.0F), this.listeningKeybind ? new ColorRGBA(0.0F, 122.0F, 255.0F, 220.0F) : (kbHov ? new ColorRGBA(255.0F, 255.0F, 255.0F, 45.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F)));
            custom.drawRoundedBorder(kbX, kbY, kbW, kbBtnH, 0.6F, IIiii_Class8.I_method_893b2757(6.0F), this.listeningKeybind ? ColorRGBA.WHITE : new ColorRGBA(255.0F, 255.0F, 255.0F, 35.0F));
            if (bold != null) {
                float kw = bold.I_method_2c375926(keyStr);
                custom.drawText(bold, keyStr, kbX + (kbW - kw) / 2.0F, kbY + 6.0F, ColorRGBA.WHITE);
            }
        }
        curY += kbH + 6.0F;

        // Render each Setting
        for (Setting s : settings) {
            if (s instanceof SliderSetting slider) {
                float rowH = 38.0F;
                if (curY + rowH >= setTop && curY <= setTop + setH) {
                    this.renderSliderSetting(custom, slider, x, curY, w, rowH, mx, my);
                }
                curY += rowH + 6.0F;
            } else if (s instanceof ModeSetting mode) {
                float rowH = 42.0F;
                if (curY + rowH >= setTop && curY <= setTop + setH) {
                    this.renderModeSetting(custom, mode, x, curY, w, rowH, mx, my);
                }
                curY += rowH + 6.0F;
            } else if (s instanceof BooleanSetting bool) {
                float rowH = 30.0F;
                if (curY + rowH >= setTop && curY <= setTop + setH) {
                    this.renderBooleanSetting(custom, bool, x, curY, w, rowH, mx, my);
                }
                curY += rowH + 6.0F;
            }
        }

        custom.disableScissor();
    }

    // ==========================================
    // VIEW 3: INTERFACE SETTINGS VIEW (.feat-view#viewInterface)
    // ==========================================
    private void renderInterfaceView(III custom, float x, float y, float w, float h, int mx, int my) {
        IIiIIi_Class10 bold = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(10.0F);
        IIiIIi_Class10 sub = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F);

        // Header Title
        if (bold != null) {
            custom.drawText(bold, "Интерфейс", x + 4.0F, y + 2.0F, ColorRGBA.WHITE);
        }
        if (sub != null) {
            custom.drawText(sub, "Темы оформления и внешний вид клиента", x + 4.0F, y + 16.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 130.0F));
        }

        float curY = y + 36.0F;

        // Section: Темы оформления (Themes Grid: 6 cards)
        if (bold != null) {
            custom.drawText(bold, "ТЕМЫ ОФОРМЛЕНИЯ", x + 4.0F, curY, new ColorRGBA(255.0F, 255.0F, 255.0F, 120.0F));
        }
        curY += 14.0F;

        ThemeAndBackgroundManager.ThemePreset[] presets = ThemeAndBackgroundManager.THEMES;
        int count = Math.min(6, presets.length);
        float tGap = 6.0F;
        float tCardW = (w - tGap * 2.0F) / 3.0F;
        float tCardH = 46.0F;

        String curThemeName = ThemeAndBackgroundManager.getInstance().getCurrentTheme().name();

        for (int i = 0; i < count; i++) {
            ThemeAndBackgroundManager.ThemePreset p = presets[i];
            int r = i / 3;
            int c = i % 3;

            float tx = x + c * (tCardW + tGap);
            float ty = curY + r * (tCardH + tGap);

            boolean isCur = p.name().equalsIgnoreCase(curThemeName);
            boolean isHov = mx >= tx && mx <= tx + tCardW && my >= ty && my <= ty + tCardH;
            IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(8.0F);

            custom.drawRoundedRect(tx, ty, tCardW, tCardH, rad, isCur ? new ColorRGBA(36.0F, 44.0F, 64.0F, 220.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, isHov ? 35.0F : 18.0F));
            custom.drawRoundedBorder(tx, ty, tCardW, tCardH, 0.7F, rad, isCur ? p.color() : new ColorRGBA(255.0F, 255.0F, 255.0F, 22.0F));

            // Mini gradient bar
            custom.drawRoundedRect(tx + 6.0F, ty + 6.0F, tCardW - 12.0F, 16.0F, IIiii_Class8.I_method_893b2757(4.0F), p.color());
            if (isCur) {
                custom.drawIcon("check", tx + tCardW - 18.0F, ty + 9.0F, 10.0F, ColorRGBA.WHITE);
            }

            if (sub != null) {
                custom.drawText(sub, p.name(), tx + 8.0F, ty + 28.0F, ColorRGBA.WHITE);
            }
        }

        curY += 2 * (tCardH + tGap) + 14.0F;

        // Section: Акцентный цвет (6 Accent Dots)
        if (bold != null) {
            custom.drawText(bold, "АКЦЕНТНЫЙ ЦВЕТ", x + 4.0F, curY, new ColorRGBA(255.0F, 255.0F, 255.0F, 120.0F));
        }
        curY += 14.0F;

        ColorRGBA[] accents = new ColorRGBA[]{
            new ColorRGBA(0.0F, 122.0F, 255.0F, 255.0F),
            new ColorRGBA(94.0F, 92.0F, 230.0F, 255.0F),
            new ColorRGBA(255.0F, 45.0F, 85.0F, 255.0F),
            new ColorRGBA(48.0F, 209.0F, 88.0F, 255.0F),
            new ColorRGBA(255.0F, 149.0F, 0.0F, 255.0F),
            new ColorRGBA(255.0F, 59.0F, 48.0F, 255.0F)
        };

        float dotSz = 22.0F;
        float dotGap = 12.0F;
        for (int i = 0; i < accents.length; i++) {
            float dx = x + 8.0F + i * (dotSz + dotGap);
            float dy = curY;
            boolean dHov = mx >= dx && mx <= dx + dotSz && my >= dy && my <= dy + dotSz;
            IIiii_Class8 dRad = IIiii_Class8.I_method_893b2757(dotSz / 2.0F);

            custom.drawShadow(dx, dy, dotSz, dotSz, 6.0F, dRad, accents[i].withAlpha(120.0F));
            custom.drawRoundedRect(dx, dy, dotSz, dotSz, dRad, accents[i]);
            if (dHov) {
                custom.drawRoundedBorder(dx, dy, dotSz, dotSz, 1.2F, dRad, ColorRGBA.WHITE);
            }
        }

        curY += dotSz + 18.0F;

        // Section: Дополнительно
        if (bold != null) {
            custom.drawText(bold, "ДОПОЛНИТЕЛЬНО", x + 4.0F, curY, new ColorRGBA(255.0F, 255.0F, 255.0F, 120.0F));
        }
        curY += 14.0F;

        this.renderInterfaceToggle(custom, "Показывать анимации", "Плавные переходы при открытии меню", true, x, curY, w, 28.0F, mx, my);
        curY += 34.0F;
        this.renderInterfaceToggle(custom, "Стеклянные иконки", "Использовать liquid glass для всех иконок", true, x, curY, w, 28.0F, mx, my);
    }

    private void renderInterfaceToggle(III custom, String title, String subTitle, boolean on, float x, float y, float w, float h, int mx, int my) {
        IIiIIi_Class10 bold = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F);
        IIiIIi_Class10 sub = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F);

        custom.drawRoundedRect(x, y, w, h, IIiii_Class8.I_method_893b2757(8.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, 15.0F));
        if (bold != null) custom.drawText(bold, title, x + 8.0F, y + 5.0F, ColorRGBA.WHITE);
        if (sub != null) custom.drawText(sub, subTitle, x + 8.0F, y + 16.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 120.0F));

        this.renderIOSSwitch(custom, x + w - 34.0F - 8.0F, y + (h - 20.0F) / 2.0F, 34.0F, 20.0F, on, mx, my);
    }

    // ==========================================
    // SETTINGS COMPONENT RENDERERS
    // ==========================================
    private void renderSliderSetting(III custom, SliderSetting slider, float x, float y, float w, float h, int mx, int my) {
        IIiIIi_Class10 bold = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F);
        IIiIIi_Class10 sub = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F);

        custom.drawRoundedRect(x, y, w, h, IIiii_Class8.I_method_893b2757(8.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, 15.0F));

        float val = slider.Ii_method_a20abcd2();
        float min = slider.I_method_b2a48e2f();
        float max = slider.i_method_b2b31a0f();
        float pct = MathHelper.clamp((val - min) / (max - min), 0.0F, 1.0F);

        if (bold != null) {
            custom.drawText(bold, slider.getName(), x + 10.0F, y + 6.0F, ColorRGBA.WHITE);
        }

        // Value Badge
        String valStr = String.format("%.1f", val) + slider.II_method_d429a7de();
        float vW = 44.0F;
        float vH = 14.0F;
        float vX = x + w - vW - 10.0F;
        float vY = y + 5.0F;
        IIiii_Class8 vRad = IIiii_Class8.I_method_893b2757(4.0F);

        custom.drawRoundedRect(vX, vY, vW, vH, vRad, new ColorRGBA(0.0F, 122.0F, 255.0F, 40.0F));
        if (sub != null) {
            float tw = sub.I_method_2c375926(valStr);
            custom.drawText(sub, valStr, vX + (vW - tw) / 2.0F, vY + 3.0F, new ColorRGBA(0.0F, 122.0F, 255.0F, 255.0F));
        }

        // Track & Fill
        float tX = x + 10.0F;
        float tY = y + 24.0F;
        float tW = w - 20.0F;
        float tH = 5.0F;
        IIiii_Class8 tRad = IIiii_Class8.I_method_893b2757(tH / 2.0F);

        custom.drawRoundedRect(tX, tY, tW, tH, tRad, new ColorRGBA(120.0F, 120.0F, 128.0F, 50.0F));

        float fillW = tW * pct;
        if (fillW > 2.0F) {
            custom.drawRoundedRect(tX, tY, fillW, tH, tRad, new ColorRGBA(0.0F, 122.0F, 255.0F, 255.0F));
        }

        // Draggable Knob
        float knobSz = 12.0F;
        float knobX = tX + fillW - knobSz / 2.0F;
        float knobY = tY + (tH - knobSz) / 2.0F;
        IIiii_Class8 kRad = IIiii_Class8.I_method_893b2757(knobSz / 2.0F);

        custom.drawShadow(knobX, knobY, knobSz, knobSz, 5.0F, kRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 60.0F));
        custom.drawRoundedRect(knobX, knobY, knobSz, knobSz, kRad, ColorRGBA.WHITE);

        // Update if dragging
        if (this.draggingSlider == slider) {
            float newPct = MathHelper.clamp((mx - tX) / tW, 0.0F, 1.0F);
            slider.I_method_a1eda161(min + newPct * (max - min));
        }
    }

    private void renderModeSetting(III custom, ModeSetting mode, float x, float y, float w, float h, int mx, int my) {
        IIiIIi_Class10 bold = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F);
        IIiIIi_Class10 sub = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F);

        custom.drawRoundedRect(x, y, w, h, IIiii_Class8.I_method_893b2757(8.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, 15.0F));

        if (bold != null) {
            custom.drawText(bold, mode.getName(), x + 10.0F, y + 6.0F, ColorRGBA.WHITE);
        }

        // Segmented pill row (.fd-segment)
        List<ModeSetting.Nested1_42765c60> modes = mode.I_field_7865b31;
        if (modes.isEmpty()) return;

        float pGap = 4.0F;
        float pW = 54.0F;
        float pH = 18.0F;
        float pTotalW = modes.size() * pW + (modes.size() - 1) * pGap;
        float pStartX = x + w - pTotalW - 10.0F;
        float pY = y + (h - pH) / 2.0F;

        for (int i = 0; i < modes.size(); i++) {
            ModeSetting.Nested1_42765c60 m = modes.get(i);
            float px = pStartX + i * (pW + pGap);
            boolean isCur = mode.I_method_ce989e26(m);
            boolean pHov = mx >= px && mx <= px + pW && my >= pY && my <= pY + pH;
            IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(6.0F);

            if (isCur) {
                custom.drawShadow(px, pY, pW, pH, 6.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 50.0F));
                custom.drawRoundedRect(px, pY, pW, pH, rad, ColorRGBA.WHITE);
                if (bold != null) {
                    float tw = bold.I_method_2c375926(m.getName());
                    custom.drawText(bold, m.getName(), px + (pW - tw) / 2.0F, pY + 5.0F, new ColorRGBA(6.0F, 6.0F, 10.0F, 255.0F));
                }
            } else {
                custom.drawRoundedRect(px, pY, pW, pH, rad, pHov ? new ColorRGBA(255.0F, 255.0F, 255.0F, 35.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F));
                if (sub != null) {
                    float tw = sub.I_method_2c375926(m.getName());
                    custom.drawText(sub, m.getName(), px + (pW - tw) / 2.0F, pY + 5.0F, ColorRGBA.WHITE);
                }
            }
        }
    }

    private void renderBooleanSetting(III custom, BooleanSetting bool, float x, float y, float w, float h, int mx, int my) {
        IIiIIi_Class10 bold = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F);

        custom.drawRoundedRect(x, y, w, h, IIiii_Class8.I_method_893b2757(8.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, 15.0F));
        if (bold != null) {
            custom.drawText(bold, bool.getName(), x + 10.0F, y + (h - 8.0F) / 2.0F, ColorRGBA.WHITE);
        }

        this.renderIOSSwitch(custom, x + w - 34.0F - 10.0F, y + (h - 20.0F) / 2.0F, 34.0F, 20.0F, bool.i_method_9b12da03(), mx, my);
    }

    // ==========================================
    // REUSABLE IOS TOGGLE SWITCH (.switch)
    // ==========================================
    private void renderIOSSwitch(III custom, float x, float y, float w, float h, boolean on, int mx, int my) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(h / 2.0F);
        ColorRGBA green = new ColorRGBA(48.0F, 209.0F, 88.0F, 255.0F);

        if (on) {
            custom.drawShadow(x, y, w, h, 8.0F, rad, green.withAlpha(100.0F));
            custom.drawRoundedRect(x, y, w, h, rad, green);
        } else {
            custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(120.0F, 120.0F, 128.0F, 80.0F));
        }

        // Sliding white thumb
        float thumbSz = h - 4.0F;
        float thumbX = on ? (x + w - thumbSz - 2.0F) : (x + 2.0F);
        float thumbY = y + 2.0F;
        IIiii_Class8 tr = IIiii_Class8.I_method_893b2757(thumbSz / 2.0F);

        custom.drawShadow(thumbX, thumbY, thumbSz, thumbSz, 4.0F, tr, new ColorRGBA(0.0F, 0.0F, 0.0F, 70.0F));
        custom.drawRoundedRect(thumbX, thumbY, thumbSz, thumbSz, tr, ColorRGBA.WHITE);
    }

    // ==========================================
    // INPUT HANDLING
    // ==========================================
    @Override
    public void onMouseClicked(double d, double d2, IiIII_Class9 button) {
        int mx = (int) d;
        int my = (int) d2;

        float winW = Math.min(620.0F, this.width - 32.0F);
        float winH = Math.min(390.0F, this.height - 32.0F);
        float winX = (this.width - winW) / 2.0F;
        float winY = (this.height - winH) / 2.0F;

        // Close Button [✕]
        float closeSz = 22.0F;
        float closeX = winX + winW - closeSz - 12.0F;
        float closeY = winY + 12.0F;
        if (mx >= closeX && mx <= closeX + closeSz && my >= closeY && my <= closeY + closeSz) {
            UISoundManager.playButtonClick();
            this.close();
            return;
        }

        // Sidebar Navigation
        float sideW = 146.0F;
        float tabStartY = winY + 52.0F;
        float tabH = 30.0F;
        float tabW = sideW - 20.0F;
        float tabX = winX + 10.0F;

        for (int i = 0; i < NavCategory.values().length; i++) {
            float tabY = tabStartY + i * (tabH + 5.0F);
            if (mx >= tabX && mx <= tabX + tabW && my >= tabY && my <= tabY + tabH) {
                UISoundManager.playButtonClick();
                this.currentCategory = NavCategory.values()[i];
                if (this.currentCategory == NavCategory.INTERFACE) {
                    this.viewMode = ViewMode.INTERFACE;
                } else {
                    this.viewMode = ViewMode.LIST;
                }
                this.listScrollY = 0.0F;
                this.targetListScrollY = 0.0F;
                return;
            }
        }

        float contentX = winX + sideW + 12.0F;
        float contentY = winY + 12.0F;
        float contentW = winW - sideW - 24.0F;
        float contentH = winH - 24.0F;

        // Search Bar Focus
        float sW = 120.0F;
        float sH = 20.0F;
        float sX = contentX + contentW - sW - 28.0F;
        float sY = contentY + 2.0F;
        if (mx >= sX && mx <= sX + sW && my >= sY && my <= sY + sH) {
            this.searchFocused = true;
            return;
        } else {
            this.searchFocused = false;
        }

        // View 1 Clicks
        if (this.viewMode == ViewMode.LIST) {
            List<Module> mods = this.getModulesForCategory(this.currentCategory);
            if (!this.searchQuery.isEmpty()) {
                String q = this.searchQuery.toLowerCase();
                mods = mods.stream().filter(m -> m.getName().toLowerCase().contains(q) || this.getModuleDesc(m).toLowerCase().contains(q)).toList();
            }

            float gridTop = contentY + 36.0F;
            float gap = 8.0F;
            float cardW = (contentW - gap) / 2.0F;
            float cardH = 42.0F;

            for (int i = 0; i < mods.size(); i++) {
                Module mod = mods.get(i);
                int r = i / 2;
                int c = i % 2;

                float cx = contentX + c * (cardW + gap);
                float cy = gridTop + r * (cardH + gap) - this.listScrollY;

                if (mx >= cx && mx <= cx + cardW && my >= cy && my <= cy + cardH) {
                    float swW = 34.0F;
                    float swH = 20.0F;
                    float swX = cx + cardW - swW - 8.0F;
                    float swY = cy + (cardH - swH) / 2.0F;

                    if (mx >= swX && mx <= swX + swW && my >= swY && my <= swY + swH) {
                        UISoundManager.playButtonClick();
                        mod.toggle();
                    } else {
                        UISoundManager.playButtonClick();
                        this.selectedModule = mod;
                        this.viewMode = ViewMode.DETAIL;
                        this.detailScrollY = 0.0F;
                        this.targetDetailScrollY = 0.0F;
                    }
                    return;
                }
            }
        } else if (this.viewMode == ViewMode.DETAIL && this.selectedModule != null) {
            // Back Button
            float bkW = 110.0F;
            float bkH = 20.0F;
            float bkX = contentX + 4.0F;
            float bkY = contentY + 2.0F;
            if (mx >= bkX && mx <= bkX + bkW && my >= bkY && my <= bkY + bkH) {
                UISoundManager.playButtonClick();
                this.viewMode = ViewMode.LIST;
                return;
            }

            // Hero Master Switch
            float heroY = contentY + 28.0F;
            float heroH = 50.0F;
            float mSwW = 38.0F;
            float mSwH = 22.0F;
            float mSwX = contentX + contentW - mSwW - 14.0F;
            float mSwY = heroY + (heroH - mSwH) / 2.0F;
            if (mx >= mSwX && mx <= mSwX + mSwW && my >= mSwY && my <= mSwY + mSwH) {
                UISoundManager.playButtonClick();
                this.selectedModule.toggle();
                return;
            }

            // Settings clicks
            float setTop = heroY + heroH + 10.0F;
            float curY = setTop - this.detailScrollY;

            // Keybind Button Click
            float kbH = 32.0F;
            float kbW = 60.0F;
            float kbBtnH = 20.0F;
            float kbX = contentX + contentW - kbW - 10.0F;
            float kbY = curY + (kbH - kbBtnH) / 2.0F;
            if (mx >= kbX && mx <= kbX + kbW && my >= kbY && my <= kbY + kbBtnH) {
                UISoundManager.playButtonClick();
                this.listeningKeybind = !this.listeningKeybind;
                return;
            }
            curY += kbH + 6.0F;

            for (Setting s : this.selectedModule.getSettings()) {
                if (s instanceof SliderSetting slider) {
                    float rowH = 38.0F;
                    float tX = contentX + 10.0F;
                    float tY = curY + 20.0F;
                    float tW = contentW - 20.0F;
                    float tH = 12.0F;

                    if (mx >= tX && mx <= tX + tW && my >= tY && my <= tY + tH) {
                        this.draggingSlider = slider;
                        float min = slider.I_method_b2a48e2f();
                        float max = slider.i_method_b2b31a0f();
                        float newPct = MathHelper.clamp((mx - tX) / tW, 0.0F, 1.0F);
                        slider.I_method_a1eda161(min + newPct * (max - min));
                        return;
                    }
                    curY += rowH + 6.0F;
                } else if (s instanceof ModeSetting mode) {
                    float rowH = 42.0F;
                    List<ModeSetting.Nested1_42765c60> modes = mode.I_field_7865b31;
                    float pGap = 4.0F;
                    float pW = 54.0F;
                    float pH = 18.0F;
                    float pTotalW = modes.size() * pW + (modes.size() - 1) * pGap;
                    float pStartX = contentX + contentW - pTotalW - 10.0F;
                    float pY = curY + (rowH - pH) / 2.0F;

                    for (int mIdx = 0; mIdx < modes.size(); mIdx++) {
                        float px = pStartX + mIdx * (pW + pGap);
                        if (mx >= px && mx <= px + pW && my >= pY && my <= pY + pH) {
                            UISoundManager.playButtonClick();
                            mode.i_method_89901e42(modes.get(mIdx));
                            return;
                        }
                    }
                    curY += rowH + 6.0F;
                } else if (s instanceof BooleanSetting bool) {
                    float rowH = 30.0F;
                    float swW = 34.0F;
                    float swH = 20.0F;
                    float swX = contentX + contentW - swW - 10.0F;
                    float swY = curY + (rowH - swH) / 2.0F;

                    if (mx >= swX && mx <= swX + swW && my >= swY && my <= swY + swH) {
                        UISoundManager.playButtonClick();
                        bool.toggle();
                        return;
                    }
                    curY += rowH + 6.0F;
                }
            }
        } else if (this.viewMode == ViewMode.INTERFACE) {
            float curY = contentY + 36.0F + 14.0F;
            ThemeAndBackgroundManager.ThemePreset[] presets = ThemeAndBackgroundManager.THEMES;
            int count = Math.min(6, presets.length);
            float tGap = 6.0F;
            float tCardW = (contentW - tGap * 2.0F) / 3.0F;
            float tCardH = 46.0F;

            for (int i = 0; i < count; i++) {
                int r = i / 3;
                int c = i % 3;
                float tx = contentX + c * (tCardW + tGap);
                float ty = curY + r * (tCardH + tGap);

                if (mx >= tx && mx <= tx + tCardW && my >= ty && my <= ty + tCardH) {
                    UISoundManager.playButtonClick();
                    ThemeAndBackgroundManager.getInstance().setThemeIndex(i);
                    return;
                }
            }
        }
    }

    @Override
    public void onMouseReleased(double d, double d2, IiIII_Class9 button) {
        this.draggingSlider = null;
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        if (this.viewMode == ViewMode.LIST) {
            this.targetListScrollY -= (float) verticalAmount * 24.0F;
            return true;
        } else if (this.viewMode == ViewMode.DETAIL) {
            this.targetDetailScrollY -= (float) verticalAmount * 24.0F;
            return true;
        }
        return super.mouseScrolled(mouseX, mouseY, horizontalAmount, verticalAmount);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (this.listeningKeybind) {
            if (keyCode == GLFW.GLFW_KEY_ESCAPE || keyCode == GLFW.GLFW_KEY_BACKSPACE) {
                if (this.selectedModule != null) this.selectedModule.setKeybind(-1);
            } else {
                if (this.selectedModule != null) this.selectedModule.setKeybind(keyCode);
            }
            this.listeningKeybind = false;
            UISoundManager.playButtonClick();
            return true;
        }

        if (this.searchFocused) {
            if (keyCode == GLFW.GLFW_KEY_BACKSPACE) {
                if (!this.searchQuery.isEmpty()) {
                    this.searchQuery = this.searchQuery.substring(0, this.searchQuery.length() - 1);
                    this.targetListScrollY = 0.0F;
                }
                return true;
            } else if (keyCode == GLFW.GLFW_KEY_ESCAPE || keyCode == GLFW.GLFW_KEY_ENTER) {
                this.searchFocused = false;
                return true;
            }
        }

        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            if (this.viewMode == ViewMode.DETAIL) {
                this.viewMode = ViewMode.LIST;
                return true;
            }
            this.close();
            return true;
        }

        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean charTyped(char chr, int modifiers) {
        if (this.searchFocused && Character.isDefined(chr) && chr >= 32) {
            this.searchQuery += chr;
            this.targetListScrollY = 0.0F;
            return true;
        }
        return super.charTyped(chr, modifiers);
    }

    @Override
    public void close() {
        if (this.client != null) {
            this.client.setScreen(null);
        }
    }

    // ==========================================
    // MODULE CATEGORY HELPERS
    // ==========================================
    private List<Module> getModulesForCategory(NavCategory cat) {
        List<Module> result = new ArrayList<>();
        if (RockstarClient.getInstance() == null || RockstarClient.getInstance().getModuleManager() == null) {
            return result;
        }

        for (ModuleEntry entry : RockstarClient.getInstance().getModuleManager().getModules()) {
            if (!(entry instanceof Module m) || !m.isAvailable()) continue;
            ModuleCategory mc = m.getCategory();

            switch (cat) {
                case MOVEMENT -> {
                    if (mc == ModuleCategory.MOVEMENT) result.add(m);
                }
                case COMBAT -> {
                    if (mc == ModuleCategory.COMBAT) result.add(m);
                }
                case VISUALS -> {
                    if (mc == ModuleCategory.VISUALS) result.add(m);
                }
                case MISC -> {
                    if (mc == ModuleCategory.PLAYER || mc == ModuleCategory.UTILS || mc == ModuleCategory.OTHER) result.add(m);
                }
                default -> {}
            }
        }

        result.sort(Comparator.comparing(Module::getName));
        return result;
    }

    private String getModuleDesc(Module mod) {
        String n = mod.getName().toLowerCase();
        if (n.contains("speed") || n.contains("ускор")) return "Увеличивает скорость передвижения";
        if (n.contains("sprint") || n.contains("бег")) return "Автоматический постоянный спринт";
        if (n.contains("shield") || n.contains("защит") || n.contains("nofall")) return "Блокировка урона от падения";
        if (n.contains("antikb") || n.contains("velocity") || n.contains("knockback")) return "Снижение и отключение отбрасывания";
        if (n.contains("bright") || n.contains("яркост")) return "Максимальная яркость и видимость мира";
        if (n.contains("esp") || n.contains("glow") || n.contains("box")) return "Подсветка игроков, лута и сундуков";
        if (n.contains("aura") || n.contains("trigger") || n.contains("attack")) return "Автоматическая атака целей вокруг";
        if (n.contains("strafe")) return "Контроль движения в воздухе";
        if (n.contains("noslow")) return "Убирает замедление при еде и паутине";
        if (n.contains("scaffold")) return "Автоматическая стройка блоков под ноги";
        return "Модуль " + mod.getName();
    }
}
