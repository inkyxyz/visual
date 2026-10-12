package rockstar.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import org.lwjgl.glfw.GLFW;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * LiquidHudRenderer — 1-to-1 Recreation of the Liquid Client HUD from HTML (.hud-root).
 * Components:
 * - Watermark (.wm glass) with animated gradient badge, version tag, live clock, and shine sweep
 * - Dynamic Island (#dynIsland) with bouncing green equalizer bars, "Playing", divider, and live FPS
 * - Stats Stack (.stats-stack) with FPS, Ping, RAM, and rolling 24-bar FPS history graph (.fps-chart)
 * - Active Mods Array (.mods) with category-colored glowing dots
 * - Coordinates Card (.coords) with XYZ, Biome, and Dimension
 * - Keystrokes (.keys) with LMB, W, A, S, SPACE live press highlights
 * - Bottom Hints (.hint) with [R Shift] Функции and [ESC] Меню
 */
public class LiquidHudRenderer {

    // Rolling FPS history bars
    private static final int FPS_BAR_COUNT = 20;
    private static final float[] fpsHistory = new float[FPS_BAR_COUNT];
    private static long lastFpsSampleTime = 0L;

    // Dynamic Island expanded state
    private static boolean islandExpanded = false;
    private static float islandAnim = 0.0F;

    public static void render(CustomDrawContext custom, float tickDelta) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc == null || mc.player == null || mc.options.hudHidden) {
            return;
        }

        int width = mc.getWindow().getScaledWidth();
        int height = mc.getWindow().getScaledHeight();

        // Sample rolling FPS
        long now = System.currentTimeMillis();
        if (now - lastFpsSampleTime > 250L) {
            lastFpsSampleTime = now;
            int curFps = mc.getCurrentFps();
            for (int i = 0; i < FPS_BAR_COUNT - 1; i++) {
                fpsHistory[i] = fpsHistory[i + 1];
            }
            fpsHistory[FPS_BAR_COUNT - 1] = (float) curFps;
        }

        IIiIIi_Class10 bold = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.5F);
        IIiIIi_Class10 sub = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.5F);
        IIiIIi_Class10 mono = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F);

        // 1. WATERMARK (.wm glass, top-left)
        renderWatermark(custom, bold, sub, now);

        // 2. DYNAMIC ISLAND (#dynIsland, top-center)
        renderDynamicIsland(custom, width, bold, mono, now, mc.getCurrentFps());

        // 3. STATS STACK (top-right)
        renderStatsStack(custom, width, bold, sub, mono, mc);

        // 4. ACTIVE MODS ARRAY (left-center)
        renderActiveMods(custom, height, bold);

        // 5. COORDINATES (bottom-left)
        renderCoordinates(custom, height, bold, sub, mc);

        // 6. KEYSTROKES (bottom-right)
        renderKeystrokes(custom, width, height, bold, mc);

        // 7. BOTTOM HINTS (.hint, bottom-center)
        if (mc.currentScreen == null) {
            renderBottomHints(custom, width, height, sub);
        }
    }

    // ==========================================
    // 1. WATERMARK (.wm glass)
    // ==========================================
    private static void renderWatermark(CustomDrawContext custom, IIiIIi_Class10 bold, IIiIIi_Class10 sub, long now) {
        float wmX = 14.0F;
        float wmY = 14.0F;
        float wmW = 185.0F;
        float wmH = 34.0F;
        IIiii_Class8 wmRad = IIiii_Class8.I_method_893b2757(12.0F);

        // Glass background
        custom.drawShadow(wmX, wmY, wmW, wmH, 12.0F, wmRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 40.0F));
        custom.drawBlurredRect(wmX, wmY, wmW, wmH, 14.0F, 2.0F, wmRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 12.0F));
        custom.drawRoundedRect(wmX, wmY, wmW, wmH, wmRad, new ColorRGBA(18.0F, 22.0F, 34.0F, 195.0F));
        custom.drawRoundedBorder(wmX, wmY, wmW, wmH, 0.7F, wmRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 35.0F));

        // Animated gradient mark (wm-mark: 24x24)
        float mSz = 22.0F;
        float mX = wmX + 6.0F;
        float mY = wmY + (wmH - mSz) / 2.0F;
        IIiii_Class8 mRad = IIiii_Class8.I_method_893b2757(7.0F);

        custom.drawShadow(mX, mY, mSz, mSz, 6.0F, mRad, new ColorRGBA(94.0F, 92.0F, 230.0F, 100.0F));
        custom.drawRoundedRect(mX, mY, mSz, mSz, mRad, new ColorRGBA(0.0F, 134.0F, 255.0F, 255.0F));
        custom.drawIcon("lightning", mX + (mSz - 12.0F) / 2.0F, mY + (mSz - 12.0F) / 2.0F, 12.0F, ColorRGBA.WHITE);

        // Text & Version
        float textX = mX + mSz + 8.0F;
        if (bold != null) {
            custom.drawText(bold, "Liquid Client", textX, wmY + 6.0F, ColorRGBA.WHITE);

            // Version pill
            float vX = textX + bold.I_method_2c375926("Liquid Client") + 5.0F;
            float vW = 28.0F;
            float vH = 10.0F;
            custom.drawRoundedRect(vX, wmY + 6.0F, vW, vH, IIiii_Class8.I_method_893b2757(3.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));
            if (sub != null) {
                custom.drawText(sub, "v2.4.1", vX + 3.0F, wmY + 7.5F, new ColorRGBA(255.0F, 255.0F, 255.0F, 170.0F));
            }
        }

        // Live clock
        if (sub != null) {
            String timeStr = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            String dateStr = new SimpleDateFormat("d MMM", new Locale("ru")).format(new Date());
            custom.drawText(sub, timeStr + " · " + dateStr, textX, wmY + 18.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 130.0F));
        }

        // Periodic shine sweep line
        float shineProgress = (now % 4500L) / 4500.0F;
        if (shineProgress < 0.35F) {
            float sRel = shineProgress / 0.35F;
            float sX = wmX + sRel * (wmW + 40.0F) - 20.0F;
            if (sX >= wmX && sX <= wmX + wmW - 10.0F) {
                custom.drawRoundedRect(sX, wmY + 1.0F, 14.0F, wmH - 2.0F, IIiii_Class8.I_method_893b2757(4.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));
            }
        }
    }

    // ==========================================
    // 2. DYNAMIC ISLAND (#dynIsland)
    // ==========================================
    private static void renderDynamicIsland(CustomDrawContext custom, int screenW, IIiIIi_Class10 bold, IIiIIi_Class10 mono, long now, int fps) {
        float isW = 165.0F;
        float isH = 26.0F;
        float isX = (screenW - isW) / 2.0F;
        float isY = 12.0F;
        IIiii_Class8 isRad = IIiii_Class8.I_method_893b2757(isH / 2.0F);

        // Island black pill
        custom.drawShadow(isX, isY, isW, isH, 12.0F, isRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 100.0F));
        custom.drawRoundedRect(isX, isY, isW, isH, isRad, new ColorRGBA(6.0F, 6.0F, 10.0F, 240.0F));
        custom.drawRoundedBorder(isX, isY, isW, isH, 0.6F, isRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 22.0F));

        // Animated bouncing equalizer bars (.di-eq)
        float eqX = isX + 12.0F;
        float eqBaseY = isY + isH - 8.0F;
        float[] delays = {0.0F, 0.15F, 0.3F, 0.1F};
        ColorRGBA green = new ColorRGBA(48.0F, 209.0F, 88.0F, 255.0F);

        for (int i = 0; i < 4; i++) {
            float phase = ((now % 1000L) / 1000.0F + delays[i]) % 1.0F;
            float barH = 4.0F + 7.0F * (float) Math.abs(Math.sin(phase * Math.PI));
            custom.drawRoundedRect(eqX + i * 4.0F, eqBaseY - barH, 2.0F, barH, IIiii_Class8.I_method_893b2757(1.0F), green);
        }

        if (bold != null) {
            custom.drawText(bold, "Playing", eqX + 20.0F, isY + 8.5F, ColorRGBA.WHITE);
        }

        // Divider
        custom.drawRect(isX + 85.0F, isY + 6.0F, 1.0F, isH - 12.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 35.0F));

        // Green live FPS
        if (mono != null) {
            custom.drawText(mono, fps + " FPS", isX + 96.0F, isY + 8.5F, green);
        }
    }

    // ==========================================
    // 3. STATS STACK & FPS CHART (.stats-stack)
    // ==========================================
    private static void renderStatsStack(CustomDrawContext custom, int screenW, IIiIIi_Class10 bold, IIiIIi_Class10 sub, IIiIIi_Class10 mono, MinecraftClient mc) {
        float stW = 105.0F;
        float stX = screenW - stW - 14.0F;
        float curY = 14.0F;
        float pillH = 21.0F;
        IIiii_Class8 pRad = IIiii_Class8.I_method_893b2757(7.0F);

        // FPS Pill
        renderStatPill(custom, stX, curY, stW, pillH, pRad, "FPS", String.valueOf(mc.getCurrentFps()), "", new ColorRGBA(48.0F, 209.0F, 88.0F, 255.0F), bold, mono);
        curY += pillH + 5.0F;

        // Ping Pill
        int ping = -1;
        if (mc.getNetworkHandler() != null && mc.player != null) {
            PlayerListEntry entry = mc.getNetworkHandler().getPlayerListEntry(mc.player.getUuid());
            if (entry != null) ping = entry.getLatency();
        }
        String pingStr = ping >= 0 ? String.valueOf(ping) : "0";
        renderStatPill(custom, stX, curY, stW, pillH, pRad, "PING", pingStr, "ms", new ColorRGBA(48.0F, 209.0F, 88.0F, 255.0F), bold, mono);
        curY += pillH + 5.0F;

        // RAM Pill
        long totalRam = Runtime.getRuntime().totalMemory() / (1024L * 1024L);
        long freeRam = Runtime.getRuntime().freeMemory() / (1024L * 1024L);
        long usedRam = totalRam - freeRam;
        String ramStr = String.format(Locale.ROOT, "%.1f", usedRam / 1024.0F);
        renderStatPill(custom, stX, curY, stW, pillH, pRad, "RAM", ramStr, "GB", new ColorRGBA(255.0F, 149.0F, 0.0F, 255.0F), bold, mono);
        curY += pillH + 5.0F;

        // FPS Chart (.fps-chart)
        float chartH = 26.0F;
        custom.drawRoundedRect(stX, curY, stW, chartH, pRad, new ColorRGBA(18.0F, 22.0F, 34.0F, 180.0F));
        custom.drawRoundedBorder(stX, curY, stW, chartH, 0.6F, pRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));

        float barW = (stW - 12.0F) / (float) FPS_BAR_COUNT;
        for (int i = 0; i < FPS_BAR_COUNT; i++) {
            float val = fpsHistory[i];
            float bH = MathHelper.clamp((val / 220.0F) * (chartH - 8.0F), 3.0F, chartH - 8.0F);
            float bx = stX + 6.0F + i * barW;
            float by = curY + chartH - 4.0F - bH;

            ColorRGBA bCol = val < 80.0F ? new ColorRGBA(255.0F, 59.0F, 48.0F, 230.0F) : (val < 110.0F ? new ColorRGBA(255.0F, 149.0F, 0.0F, 230.0F) : new ColorRGBA(48.0F, 209.0F, 88.0F, 230.0F));
            custom.drawRoundedRect(bx, by, barW - 1.5F, bH, IIiii_Class8.I_method_893b2757(1.0F), bCol);
        }
    }

    private static void renderStatPill(CustomDrawContext custom, float x, float y, float w, float h, IIiii_Class8 rad, String key, String val, String unit, ColorRGBA dotCol, IIiIIi_Class10 bold, IIiIIi_Class10 mono) {
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(18.0F, 22.0F, 34.0F, 180.0F));
        custom.drawRoundedBorder(x, y, w, h, 0.6F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));

        // Dot
        float dSz = 5.0F;
        float dx = x + 8.0F;
        float dy = y + (h - dSz) / 2.0F;
        custom.drawShadow(dx, dy, dSz, dSz, 4.0F, IIiii_Class8.I_method_893b2757(dSz / 2.0F), dotCol);
        custom.drawRoundedRect(dx, dy, dSz, dSz, IIiii_Class8.I_method_893b2757(dSz / 2.0F), dotCol);

        if (bold != null) {
            custom.drawText(bold, key, dx + dSz + 6.0F, y + (h - 7.5F) / 2.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 140.0F));
        }

        if (mono != null) {
            String fullVal = val + (unit.isEmpty() ? "" : " " + unit);
            float tw = mono.I_method_2c375926(fullVal);
            custom.drawText(mono, fullVal, x + w - tw - 8.0F, y + (h - 7.0F) / 2.0F, ColorRGBA.WHITE);
        }
    }

    // ==========================================
    // 4. ACTIVE MODS ARRAY (.mods)
    // ==========================================
    private static void renderActiveMods(CustomDrawContext custom, int screenH, IIiIIi_Class10 bold) {
        if (RockstarClient.getInstance() == null || RockstarClient.getInstance().getModuleManager() == null) {
            return;
        }

        List<ModuleEntry> active = RockstarClient.getInstance().getModuleManager().getModules().stream()
            .filter(ModuleEntry::isEnabled)
            .filter(m -> !m.getName().equalsIgnoreCase("menu"))
            .limit(9)
            .toList();

        if (active.isEmpty()) return;

        float modH = 20.0F;
        float gap = 4.0F;
        float totalH = active.size() * (modH + gap);
        float startY = (screenH - totalH) / 2.0F;
        float startX = 14.0F;
        IIiii_Class8 mRad = IIiii_Class8.I_method_893b2757(7.0F);

        for (int i = 0; i < active.size(); i++) {
            ModuleEntry m = active.get(i);
            float my = startY + i * (modH + gap);

            ColorRGBA dotCol = switch (m.getCategory()) {
                case MOVEMENT -> new ColorRGBA(0.0F, 122.0F, 255.0F, 255.0F);
                case COMBAT -> new ColorRGBA(94.0F, 92.0F, 230.0F, 255.0F);
                case VISUALS -> new ColorRGBA(255.0F, 45.0F, 85.0F, 255.0F);
                case PLAYER, UTILS, OTHER -> new ColorRGBA(255.0F, 149.0F, 0.0F, 255.0F);
                default -> new ColorRGBA(48.0F, 209.0F, 88.0F, 255.0F);
            };

            float nameW = bold != null ? bold.I_method_2c375926(m.getName()) : 50.0F;
            float pillW = nameW + 24.0F;

            custom.drawRoundedRect(startX, my, pillW, modH, mRad, new ColorRGBA(18.0F, 22.0F, 34.0F, 180.0F));
            custom.drawRoundedBorder(startX, my, pillW, modH, 0.6F, mRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));

            // Dot
            float dSz = 5.0F;
            float dx = startX + 7.0F;
            float dy = my + (modH - dSz) / 2.0F;
            custom.drawShadow(dx, dy, dSz, dSz, 4.0F, IIiii_Class8.I_method_893b2757(dSz / 2.0F), dotCol);
            custom.drawRoundedRect(dx, dy, dSz, dSz, IIiii_Class8.I_method_893b2757(dSz / 2.0F), dotCol);

            if (bold != null) {
                custom.drawText(bold, m.getName(), dx + dSz + 6.0F, my + (modH - 7.5F) / 2.0F, ColorRGBA.WHITE);
            }
        }
    }

    // ==========================================
    // 5. COORDINATES (.coords, bottom-left)
    // ==========================================
    private static void renderCoordinates(CustomDrawContext custom, int screenH, IIiIIi_Class10 bold, IIiIIi_Class10 sub, MinecraftClient mc) {
        if (mc.player == null || mc.world == null) return;

        float cW = 150.0F;
        float rowH = 19.0F;
        float gap = 4.0F;
        float totalH = 3 * rowH + 2 * gap;
        float cX = 14.0F;
        float cY = screenH - totalH - 14.0F;
        IIiii_Class8 rRad = IIiii_Class8.I_method_893b2757(7.0F);

        BlockPos pos = mc.player.getBlockPos();

        // Row 1: XYZ
        custom.drawRoundedRect(cX, cY, cW, rowH, rRad, new ColorRGBA(18.0F, 22.0F, 34.0F, 180.0F));
        custom.drawRoundedBorder(cX, cY, cW, rowH, 0.6F, rRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));
        custom.drawIcon("crosshair", cX + 6.0F, cY + 4.5F, 10.0F, new ColorRGBA(0.0F, 122.0F, 255.0F, 255.0F));
        if (sub != null) custom.drawText(sub, "XYZ", cX + 20.0F, cY + 5.5F, new ColorRGBA(255.0F, 255.0F, 255.0F, 140.0F));
        if (bold != null) {
            String coordStr = pos.getX() + " / " + pos.getY() + " / " + pos.getZ();
            float tw = bold.I_method_2c375926(coordStr);
            custom.drawText(bold, coordStr, cX + cW - tw - 8.0F, cY + 5.5F, ColorRGBA.WHITE);
        }

        // Row 2: Biome
        float y2 = cY + rowH + gap;
        custom.drawRoundedRect(cX, y2, cW, rowH, rRad, new ColorRGBA(18.0F, 22.0F, 34.0F, 180.0F));
        custom.drawRoundedBorder(cX, y2, cW, rowH, 0.6F, rRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));
        custom.drawIcon("shield", cX + 6.0F, y2 + 4.5F, 10.0F, new ColorRGBA(94.0F, 92.0F, 230.0F, 255.0F));
        if (sub != null) custom.drawText(sub, "BIOME", cX + 20.0F, y2 + 5.5F, new ColorRGBA(255.0F, 255.0F, 255.0F, 140.0F));
        String biomeName = mc.world.getBiome(pos).getKey().map(k -> k.getValue().getPath()).orElse("plains");
        if (bold != null) {
            float tw = bold.I_method_2c375926(biomeName);
            custom.drawText(bold, biomeName, cX + cW - tw - 8.0F, y2 + 5.5F, ColorRGBA.WHITE);
        }

        // Row 3: Dimension
        float y3 = y2 + rowH + gap;
        custom.drawRoundedRect(cX, y3, cW, rowH, rRad, new ColorRGBA(18.0F, 22.0F, 34.0F, 180.0F));
        custom.drawRoundedBorder(cX, y3, cW, rowH, 0.6F, rRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));
        custom.drawIcon("globe", cX + 6.0F, y3 + 4.5F, 10.0F, new ColorRGBA(48.0F, 209.0F, 88.0F, 255.0F));
        if (sub != null) custom.drawText(sub, "DIM", cX + 20.0F, y3 + 5.5F, new ColorRGBA(255.0F, 255.0F, 255.0F, 140.0F));
        String dimName = mc.world.getRegistryKey().getValue().getPath();
        if (bold != null) {
            float tw = bold.I_method_2c375926(dimName);
            custom.drawText(bold, dimName, cX + cW - tw - 8.0F, y3 + 5.5F, ColorRGBA.WHITE);
        }
    }

    // ==========================================
    // 6. KEYSTROKES (.keys, bottom-right)
    // ==========================================
    private static void renderKeystrokes(CustomDrawContext custom, int screenW, int screenH, IIiIIi_Class10 bold, MinecraftClient mc) {
        float btnSz = 22.0F;
        float gap = 4.0F;
        float gridW = btnSz * 3.0F + gap * 2.0F;
        float kX = screenW - gridW - 14.0F;
        float kY = screenH - (btnSz * 3.0F + gap * 2.0F + 18.0F) - 14.0F;

        long handle = mc.getWindow().getHandle();
        boolean wPress = GLFW.glfwGetKey(handle, GLFW.GLFW_KEY_W) == 1;
        boolean aPress = GLFW.glfwGetKey(handle, GLFW.GLFW_KEY_A) == 1;
        boolean sPress = GLFW.glfwGetKey(handle, GLFW.GLFW_KEY_S) == 1;
        boolean dPress = GLFW.glfwGetKey(handle, GLFW.GLFW_KEY_D) == 1;
        boolean spacePress = GLFW.glfwGetKey(handle, GLFW.GLFW_KEY_SPACE) == 1;
        boolean lmbPress = GLFW.glfwGetMouseButton(handle, 0) == 1;

        // [ LMB ] (Wide top)
        renderKeyButton(custom, kX, kY, gridW, 16.0F, "LMB", lmbPress, bold);

        // [ W ] (Center)
        renderKeyButton(custom, kX + btnSz + gap, kY + 16.0F + gap, btnSz, btnSz, "W", wPress, bold);

        // [ A ] [ S ] [ D ]
        float r2Y = kY + 16.0F + gap + btnSz + gap;
        renderKeyButton(custom, kX, r2Y, btnSz, btnSz, "A", aPress, bold);
        renderKeyButton(custom, kX + btnSz + gap, r2Y, btnSz, btnSz, "S", sPress, bold);
        renderKeyButton(custom, kX + (btnSz + gap) * 2.0F, r2Y, btnSz, btnSz, "D", dPress, bold);

        // [ SPACE ] (Wide bottom)
        renderKeyButton(custom, kX, r2Y + btnSz + gap, gridW, 14.0F, "SPACE", spacePress, bold);
    }

    private static void renderKeyButton(CustomDrawContext custom, float x, float y, float w, float h, String text, boolean pressed, IIiIIi_Class10 font) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(5.0F);
        if (pressed) {
            custom.drawShadow(x, y, w, h, 6.0F, rad, new ColorRGBA(0.0F, 122.0F, 255.0F, 140.0F));
            custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(0.0F, 122.0F, 255.0F, 240.0F));
        } else {
            custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(18.0F, 22.0F, 34.0F, 180.0F));
            custom.drawRoundedBorder(x, y, w, h, 0.6F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));
        }

        if (font != null) {
            float tw = font.I_method_2c375926(text);
            custom.drawText(font, text, x + (w - tw) / 2.0F, y + (h - 7.5F) / 2.0F, ColorRGBA.WHITE);
        }
    }

    // ==========================================
    // 7. BOTTOM HINTS (.hint)
    // ==========================================
    private static void renderBottomHints(CustomDrawContext custom, int screenW, int screenH, IIiIIi_Class10 font) {
        float hW = 160.0F;
        float hH = 18.0F;
        float hX = (screenW - hW) / 2.0F;
        float hY = screenH - hH - 10.0F;
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(hH / 2.0F);

        custom.drawRoundedRect(hX, hY, hW, hH, rad, new ColorRGBA(18.0F, 22.0F, 34.0F, 170.0F));
        custom.drawRoundedBorder(hX, hY, hW, hH, 0.6F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));

        if (font != null) {
            String text = "R Shift Функции  •  ESC Меню";
            float tw = font.I_method_2c375926(text);
            custom.drawText(font, text, hX + (hW - tw) / 2.0F, hY + 5.5F, new ColorRGBA(255.0F, 255.0F, 255.0F, 170.0F));
        }
    }
}
