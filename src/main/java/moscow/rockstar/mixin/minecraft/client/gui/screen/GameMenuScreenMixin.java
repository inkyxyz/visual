package moscow.rockstar.mixin.minecraft.client.gui.screen;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import moscow.rockstar.mixin.accessors.ScreenAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.multiplayer.ConnectScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.network.ServerAddress;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.client.realms.gui.screen.RealmsMainScreen;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.AIAssistantService;
import rockstar.client.EscapeMenuConfig;
import rockstar.client.EscapeMenuCustomizerScreen;
import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiiIIiIii_Class204;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.MinesweeperScreen;
import rockstar.client.NotesManager;
import rockstar.client.RockstarClient;
import rockstar.client.SnakeScreen;
import rockstar.client.UISoundManager;
import rockstar.client.WeatherAlertModule;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iiIiIIIiI_Class419;

@Mixin(value={GameMenuScreen.class})
public class GameMenuScreenMixin
extends Screen
implements iIIiIIiIi_Class294 {

    @Shadow
    @Nullable
    private ButtonWidget field_40792;

    @Unique private static float rockstar$flashAlpha = 0.0F;

    // Interactive Equalizer Visualizer State
    @Unique private static final float[] rockstar$eqFrequencies = new float[]{0.45F, 0.72F, 0.90F, 0.55F, 0.82F, 0.38F};

    // Interactive iOS Calculator State
    @Unique private static String rockstar$calcDisplay = "0";
    @Unique private static double rockstar$calcStored = 0.0;
    @Unique private static String rockstar$calcOp = null;
    @Unique private static boolean rockstar$calcClearNext = false;

    // Volume Drag State
    @Unique private static boolean rockstar$isDraggingVolume = false;

    // Per-tile hover float animations (0: Media, 1: Weather, 2: Radar, 3: Vol, 4: Cam, 5: Fs, 6: Calc, 7: Notes, 8: RAM)
    @Unique private static final float[] rockstar$tileHoverAnim = new float[12];
    @Unique private static final float[] rockstar$dockBtnHover = new float[4];
    @Unique private static final float[] rockstar$actionBtnHover = new float[4];

    // Smooth Entrance Fly-in animation
    @Unique private static float rockstar$flyInAnim = 0.0F;

    // RAM Widget State & Usage History
    @Unique private static final float[] rockstar$ramHistory = new float[22];
    @Unique private static long rockstar$lastRamSample = 0L;
    @Unique private static long rockstar$ramGcFeedbackTimer = 0L;

    // Time & Date formatters for Control Center Status Bar
    @Unique private static final java.time.format.DateTimeFormatter rockstar$TIME_FMT = java.time.format.DateTimeFormatter.ofPattern("HH:mm");
    @Unique private static final java.time.format.DateTimeFormatter rockstar$DATE_FMT = java.time.format.DateTimeFormatter.ofPattern("EEEE, d MMMM", new java.util.Locale("ru", "RU"));

    // Embedded Notes State
    @Unique private static int rockstar$notesActiveIdx = 0;
    @Unique private static boolean rockstar$notesEditing = false;

    // Slide-in Right AI Assistant Drawer State
    @Unique private static boolean rockstar$aiDrawerOpen = false;
    @Unique private static float rockstar$aiDrawerAnim = 0.0F;
    @Unique private static String rockstar$aiInput = "";
    @Unique private static boolean rockstar$aiThinking = false;
    @Unique private static float rockstar$aiScroll = 0.0F;

    protected GameMenuScreenMixin(Text text) {
        super(text);
    }

    @Inject(method={"initWidgets"}, at={@At(value="TAIL")})
    private void rockstar$hideVanillaWidgets(CallbackInfo callbackInfo) {
        rockstar$flyInAnim = 0.0F; // Reset smooth entrance fly-in
        for (Element elem : ((ScreenAccessor)(Object)this).getChildren()) {
            if (elem instanceof ClickableWidget widget) {
                widget.visible = false;
            }
        }
    }

    @Inject(method={"render"}, at={@At(value="HEAD")}, cancellable=true)
    private void rockstar$renderControlCenter(DrawContext drawContext, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        ci.cancel();

        III custom = III.I_method_5728d20f(drawContext, mouseX, mouseY, delta);
        float cx = this.width / 2.0F;
        float cy = this.height / 2.0F;
        long now = System.currentTimeMillis();
        ColorRGBA theme = IiiiiIIIi_Class242.I_method_7df8e08e();

        // Update entrance fly-in animation lerp
        rockstar$flyInAnim += (1.0F - rockstar$flyInAnim) * 0.18F;

        // Update slide-in AI drawer animation lerp
        float targetDrawer = rockstar$aiDrawerOpen ? 1.0F : 0.0F;
        rockstar$aiDrawerAnim += (targetDrawer - rockstar$aiDrawerAnim) * 0.22F;

        // Subtle, beautiful translucent backdrop (no pitch black!)
        custom.drawRect(0.0F, 0.0F, (float)this.width, (float)this.height, new ColorRGBA(4.0F, 6.0F, 12.0F, 75.0F));

        IIiIIi_Class10 font = null;
        IIiIIi_Class10 boldFont = null;
        IIiIIi_Class10 subFont = null;
        IIiIIi_Class10 tinyFont = null;
        try {
            if (IIiIiI_Class11.i_field_857c0621 != null) {
                boldFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(13.0F);
                font = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(9.5F);
                subFont = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.5F);
                tinyFont = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.5F);
            }
        } catch (Throwable ignored) {}

        // Browser media playback status
        iiIiIIIiI_Class419 tracker = RockstarClient.getInstance().I_method_be969482();
        iiIiIIIiI_Class419.Nested1_a961800 snap = tracker != null ? tracker.I_method_7effc530() : null;
        boolean isBrowserPlaying = (snap != null && snap.I_method_1a22ebbe());

        // Animate Equalizer bars
        float timeF = (float)(now % 1000000L) / 1000.0F;
        for (int i = 0; i < rockstar$eqFrequencies.length; i++) {
            if (isBrowserPlaying) {
                float target = (float)(Math.sin(timeF * 8.5F + i * 1.5F) * 0.35F + 0.55F);
                rockstar$eqFrequencies[i] += (target - rockstar$eqFrequencies[i]) * 0.22F;
            } else {
                float idleTarget = (float)(Math.sin(timeF * 2.0F + i * 0.8F) * 0.08F + 0.16F);
                rockstar$eqFrequencies[i] += (idleTarget - rockstar$eqFrequencies[i]) * 0.12F;
            }
        }

        EscapeMenuConfig cfg = EscapeMenuConfig.getInstance();

        // ==========================================
        // 1. TOP ROW: 4 SEPARATE MODULAR IOS WIDGETS
        // Media (120x74) | Weather (120x74) | Drone Radar (120x74) | Free RAM (120x74)
        // ==========================================
        float topW = 120.0F;
        float topH = 74.0F;
        float topGap = 8.0F;

        int topCardCount = 0;
        if (cfg.showMediaPlayer) topCardCount++;
        if (cfg.showWeather) topCardCount++;
        if (cfg.showDroneAlerts) topCardCount++;
        if (cfg.showRamUsage) topCardCount++;
        topCardCount = Math.max(1, topCardCount);
        float topTotalW = topCardCount * topW + (topCardCount - 1) * topGap;
        float topStartX = cx - topTotalW / 2.0F;
        float topY = cy - 138.0F;

        // Fly-in offset for Top Row
        float topFlyY = (1.0F - rockstar$flyInAnim) * 26.0F;

        // ==========================================
        // 0. IOS STATUS BAR: TIME, DATE, FPS & NETWORK LATENCY
        // ==========================================
        float statusBarY = topY - 24.0F + topFlyY;
        try {
            java.time.LocalDateTime nowLdt = java.time.LocalDateTime.now();
            String timeStr = nowLdt.format(rockstar$TIME_FMT);
            String dateStr = nowLdt.format(rockstar$DATE_FMT);
            if (!dateStr.isEmpty()) {
                dateStr = Character.toUpperCase(dateStr.charAt(0)) + dateStr.substring(1);
            }

            if (boldFont != null) {
                custom.drawText(boldFont, timeStr, topStartX + 4.0F, statusBarY + 3.0F, ColorRGBA.WHITE);
            }
            if (subFont != null) {
                float tw = boldFont != null ? boldFont.I_method_2c375926(timeStr) : 34.0F;
                custom.drawText(subFont, "• " + dateStr, topStartX + tw + 10.0F, statusBarY + 5.5F, new ColorRGBA(210.0F, 225.0F, 245.0F, 200.0F));
            }

            MinecraftClient mc = MinecraftClient.getInstance();
            int fps = mc.getCurrentFps();
            int ping = 0;
            if (mc.player != null && mc.getNetworkHandler() != null) {
                var entry = mc.getNetworkHandler().getPlayerListEntry(mc.player.getUuid());
                if (entry != null) ping = entry.getLatency();
            }
            String statusBadge = fps + " FPS" + (ping > 0 ? " • " + ping + " ms" : "") + " • Agravity";
            if (tinyFont != null) {
                float badgeW = tinyFont.I_method_2c375926(statusBadge) + 16.0F;
                float badgeX = topStartX + topTotalW - badgeW - 2.0F;
                custom.drawRoundedRect(badgeX, statusBarY + 2.0F, badgeW, 16.0F, IIiii_Class8.I_method_893b2757(8.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, 12.0F));
                custom.drawRoundedBorder(badgeX, statusBarY + 2.0F, badgeW, 16.0F, 0.5F, IIiii_Class8.I_method_893b2757(8.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, 16.0F));
                custom.drawText(tinyFont, statusBadge, badgeX + 8.0F, statusBarY + 5.5F, new ColorRGBA(210.0F, 225.0F, 245.0F, 210.0F));
            }
        } catch (Throwable ignored) {}

        float curTopX = topStartX;

        // 0: Media Card
        if (cfg.showMediaPlayer) {
            float mX = curTopX;
            float mY = topY + topFlyY;
            boolean mHov = (mouseX >= mX && mouseX <= mX + topW && mouseY >= mY && mouseY <= mY + topH);
            rockstar$tileHoverAnim[0] += ((mHov ? 1.0F : 0.0F) - rockstar$tileHoverAnim[0]) * 0.20F;
            float dY = mY - rockstar$tileHoverAnim[0] * 3.0F;
            rockstar$renderMediaCard(custom, mX, dY, topW, topH, font, subFont, tinyFont, mouseX, mouseY, rockstar$tileHoverAnim[0], snap, tracker);
            curTopX += topW + topGap;
        }

        // 1: Separate iOS Weather Widget Card
        if (cfg.showWeather) {
            float wX = curTopX;
            float wY = topY + topFlyY;
            boolean wHov = (mouseX >= wX && mouseX <= wX + topW && mouseY >= wY && mouseY <= wY + topH);
            rockstar$tileHoverAnim[1] += ((wHov ? 1.0F : 0.0F) - rockstar$tileHoverAnim[1]) * 0.20F;
            float dY = wY - rockstar$tileHoverAnim[1] * 3.0F;
            rockstar$renderWeatherCard(custom, wX, dY, topW, topH, boldFont, font, subFont, tinyFont, mouseX, mouseY, rockstar$tileHoverAnim[1], cfg);
            curTopX += topW + topGap;
        }

        // 2: Separate iOS Drone Threat Radar Card
        if (cfg.showDroneAlerts) {
            float rX = curTopX;
            float rY = topY + topFlyY;
            boolean rHov = (mouseX >= rX && mouseX <= rX + topW && mouseY >= rY && mouseY <= rY + topH);
            rockstar$tileHoverAnim[2] += ((rHov ? 1.0F : 0.0F) - rockstar$tileHoverAnim[2]) * 0.20F;
            float dY = rY - rockstar$tileHoverAnim[2] * 3.0F;
            rockstar$renderDroneRadarCard(custom, rX, dY, topW, topH, boldFont, font, subFont, tinyFont, mouseX, mouseY, rockstar$tileHoverAnim[2], cfg, now);
            curTopX += topW + topGap;
        }

        // 3: Separate iOS Free RAM Card with real-time usage graph
        if (cfg.showRamUsage) {
            float ramX = curTopX;
            float ramY = topY + topFlyY;
            boolean ramHov = (mouseX >= ramX && mouseX <= ramX + topW && mouseY >= ramY && mouseY <= ramY + topH);
            rockstar$tileHoverAnim[8] += ((ramHov ? 1.0F : 0.0F) - rockstar$tileHoverAnim[8]) * 0.20F;
            float dY = ramY - rockstar$tileHoverAnim[8] * 3.0F;
            rockstar$renderRamCard(custom, ramX, dY, topW, topH, boldFont, font, subFont, tinyFont, mouseX, mouseY, rockstar$tileHoverAnim[8], now);
            curTopX += topW + topGap;
        }

        // ==========================================
        // 2. MAIN CONTENT ROW (Symmetric 504px Grid Layout):
        // Left (Volume & Toggles: 94w) | Center (Calc: 152w) | Right (Notes: 238w)
        // 94 + 10 + 152 + 10 + 238 = 504px (Exact Symmetry!)
        // ==========================================
        float mainTotalW = 504.0F;
        float gridStartX = cx - mainTotalW / 2.0F;
        float mainY = cy - 46.0F;
        float mainH = 165.0F;
        float mainFlyY = (1.0F - rockstar$flyInAnim) * 32.0F;

        // 1. Left Pod: Theme-Adapted Volume Pill (44w) + Quick Toggles (46w)
        float curX = gridStartX;
        float leftPodW = 94.0F;
        float vY = mainY + mainFlyY;

        if (cfg.showVolume) {
            float volW = 44.0F;
            boolean vHov = (mouseX >= curX && mouseX <= curX + volW && mouseY >= vY && mouseY <= vY + mainH);
            rockstar$tileHoverAnim[3] += ((vHov ? 1.0F : 0.0F) - rockstar$tileHoverAnim[3]) * 0.20F;
            float dY = vY - rockstar$tileHoverAnim[3] * 2.5F;
            rockstar$renderVolumePill(custom, curX, dY, volW, mainH, subFont, mouseX, mouseY, rockstar$tileHoverAnim[3]);
        }

        // Camera & Fullscreen stacked quick toggles
        float qX = curX + 48.0F;
        float qW = 46.0F;
        float qTileH = (mainH - 5.0F) / 2.0F;
        if (cfg.showCamera) {
            float camY = vY;
            boolean cHov = (mouseX >= qX && mouseX <= qX + qW && mouseY >= camY && mouseY <= camY + qTileH);
            rockstar$tileHoverAnim[4] += ((cHov ? 1.0F : 0.0F) - rockstar$tileHoverAnim[4]) * 0.20F;
            float dY = camY - rockstar$tileHoverAnim[4] * 2.5F;
            rockstar$renderCameraTile(custom, qX, dY, qW, qTileH, mouseX, mouseY, rockstar$tileHoverAnim[4]);

            float fsY = camY + qTileH + 5.0F;
            boolean fsHov = (mouseX >= qX && mouseX <= qX + qW && mouseY >= fsY && mouseY <= fsY + qTileH);
            rockstar$tileHoverAnim[5] += ((fsHov ? 1.0F : 0.0F) - rockstar$tileHoverAnim[5]) * 0.20F;
            float dFsY = fsY - rockstar$tileHoverAnim[5] * 2.5F;
            rockstar$renderFullscreenTile(custom, qX, dFsY, qW, qTileH, mouseX, mouseY, rockstar$tileHoverAnim[5]);
        }
        curX += leftPodW + 10.0F;

        // 2. Center Pod: iOS Calculator Card (152w x 165h)
        float calcW = 152.0F;
        if (cfg.showCalculator) {
            float cY = mainY + mainFlyY;
            boolean calcHov = (mouseX >= curX && mouseX <= curX + calcW && mouseY >= cY && mouseY <= cY + mainH);
            rockstar$tileHoverAnim[6] += ((calcHov ? 1.0F : 0.0F) - rockstar$tileHoverAnim[6]) * 0.20F;
            float dY = cY - rockstar$tileHoverAnim[6] * 2.5F;
            rockstar$renderCalculatorCard(custom, curX, dY, calcW, mainH, boldFont, font, mouseX, mouseY, rockstar$tileHoverAnim[6]);
            curX += calcW + 10.0F;
        }

        // 3. Right Pod: Embedded Notes & 1-Click Markers (238w x 165h)
        float notesW = (gridStartX + mainTotalW) - curX;
        if (cfg.showNotes && notesW > 60.0F) {
            float nY = mainY + mainFlyY;
            boolean nHov = (mouseX >= curX && mouseX <= curX + notesW && mouseY >= nY && mouseY <= nY + mainH);
            rockstar$tileHoverAnim[7] += ((nHov ? 1.0F : 0.0F) - rockstar$tileHoverAnim[7]) * 0.20F;
            float dY = nY - rockstar$tileHoverAnim[7] * 2.5F;
            rockstar$renderNotesCard(custom, curX, dY, notesW, mainH, boldFont, font, subFont, tinyFont, mouseX, mouseY, rockstar$tileHoverAnim[7]);
        }

        // ==========================================
        // 3. PRIMARY ACTION BUTTONS DOCK (Horizontal Hero Row):
        // [▶ В игру] (120w) | [⚙ Настройки] (120w) | [🎨 Кастомизация] (120w) | [✕ Выйти] (120w)
        // Perfectly aligned across the exact 504px grid!
        // ==========================================
        float actY = mainY + mainH + 10.0F + mainFlyY;
        float actBtnH = 38.0F;
        float actGap = 8.0F;
        float actBtnW = (mainTotalW - 3.0F * actGap) / 4.0F; // Exactly 120.0F!
        IIiii_Class8 aRad = IIiii_Class8.I_method_893b2757(11.0F);

        String[] actionLabels = { "В игру", "Настройки", "Кастомизация", "Выйти" };
        String[] actionIcons = { "play", "setting", "hud/target", "back" };
        ColorRGBA[] actionColors = {
            new ColorRGBA(34.0F, 197.0F, 94.0F, 240.0F),  // Green
            new ColorRGBA(59.0F, 130.0F, 246.0F, 240.0F), // Blue
            new ColorRGBA(168.0F, 85.0F, 247.0F, 240.0F), // Purple
            new ColorRGBA(239.0F, 68.0F, 68.0F, 240.0F)   // Red
        };

        for (int i = 0; i < 4; i++) {
            float bX = gridStartX + i * (actBtnW + actGap);
            boolean isHov = (mouseX >= bX && mouseX <= bX + actBtnW && mouseY >= actY && mouseY <= actY + actBtnH);
            rockstar$actionBtnHover[i] += ((isHov ? 1.0F : 0.0F) - rockstar$actionBtnHover[i]) * 0.22F;
            float hA = rockstar$actionBtnHover[i];
            float drawY = actY - hA * 2.0F;

            // Ultra-clean Apple Frosted Glass Button
            custom.drawShadow(bX, drawY, actBtnW, actBtnH, 10.0F, aRad, isHov ? actionColors[i].withAlpha(65.0F) : new ColorRGBA(0.0F, 0.0F, 0.0F, 45.0F));
            custom.drawBlurredRect(bX, drawY, actBtnW, actBtnH, 14.0F, 3.0F, aRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 10.0F));
            custom.drawRoundedRect(bX, drawY, actBtnW, actBtnH, aRad, new ColorRGBA(18.0F, 22.0F, 32.0F, 140.0F + 35.0F * hA));
            custom.drawRoundedBorder(bX, drawY, actBtnW, actBtnH, 0.6F, aRad, hA > 0.01F ? actionColors[i].withAlpha(140.0F * hA) : new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F));

            float iconSz = 14.0F;
            custom.drawIcon(actionIcons[i], bX + 14.0F, drawY + (actBtnH - iconSz) / 2.0F, iconSz, hA > 0.01F ? actionColors[i] : ColorRGBA.WHITE);
            if (font != null) {
                custom.drawText(font, actionLabels[i], bX + 34.0F, drawY + 14.0F, ColorRGBA.WHITE);
            }
        }

        // ==========================================
        // 4. BOTTOM MINI-APPS DOCK:
        // [ (✦) AI Помощник ] | [ (🐍) Змейка ] | [ (💣) Сапёр ]
        // ==========================================
        float bRowY = actY + actBtnH + 9.0F;
        float bRowH = 28.0F;
        float dockFlyY = (1.0F - rockstar$flyInAnim) * 40.0F;
        IIiii_Class8 sRad = IIiii_Class8.I_method_893b2757(8.0F);

        float dockAiW = 106.0F;
        float dockSnW = 82.0F;
        float dockMnW = 82.0F;
        float dockGap = 6.0F;
        float dockTotalW = dockAiW + dockSnW + dockMnW + dockGap * 2.0F;
        float bStartX = cx - dockTotalW / 2.0F;

        // 1. [ (✦) Agravity AI ] (Toggles Slide-in Drawer!)
        float aiX = bStartX;
        boolean aiHov = (mouseX >= aiX && mouseX <= aiX + dockAiW && mouseY >= bRowY + dockFlyY && mouseY <= bRowY + dockFlyY + bRowH);
        rockstar$dockBtnHover[0] += ((aiHov ? 1.0F : 0.0F) - rockstar$dockBtnHover[0]) * 0.22F;
        float hA0 = rockstar$dockBtnHover[0];
        float drawYAi = bRowY + dockFlyY - hA0 * 2.0F;
        boolean aiActive = rockstar$aiDrawerOpen;

        custom.drawShadow(aiX, drawYAi, dockAiW, bRowH, 8.0F, sRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 35.0F));
        custom.drawBlurredRect(aiX, drawYAi, dockAiW, bRowH, 12.0F, 3.0F, sRad, new ColorRGBA(theme.getRed(), theme.getGreen(), theme.getBlue(), aiActive ? 30.0F : 12.0F));
        custom.drawRoundedRect(aiX, drawYAi, dockAiW, bRowH, sRad, aiActive ? theme.withAlpha(150.0F) : new ColorRGBA(16.0F, 20.0F, 30.0F, 110.0F + 30.0F * hA0));
        custom.drawRoundedBorder(aiX, drawYAi, dockAiW, bRowH, 0.5F, sRad, aiActive ? theme.withAlpha(180.0F) : (hA0 > 0.01F ? theme.withAlpha(90.0F * hA0) : new ColorRGBA(255.0F, 255.0F, 255.0F, 15.0F)));

        float sqIconSz = 18.0F;
        custom.drawTexture(RockstarClient.id("icons/ai.png"), aiX + 6.0F, drawYAi + (bRowH - sqIconSz) / 2.0F, sqIconSz, sqIconSz, ColorRGBA.WHITE);
        if (subFont != null) {
            custom.drawText(subFont, "Agravity AI", aiX + 28.0F, drawYAi + 10.0F, ColorRGBA.WHITE);
        }

        // 2. [ (🐍) Змейка ] Mini-game
        float snakeX = aiX + dockAiW + dockGap;
        boolean snakeHov = (mouseX >= snakeX && mouseX <= snakeX + dockSnW && mouseY >= bRowY + dockFlyY && mouseY <= bRowY + dockFlyY + bRowH);
        rockstar$dockBtnHover[1] += ((snakeHov ? 1.0F : 0.0F) - rockstar$dockBtnHover[1]) * 0.22F;
        float hA1 = rockstar$dockBtnHover[1];
        float drawYSn = bRowY + dockFlyY - hA1 * 2.0F;

        custom.drawShadow(snakeX, drawYSn, dockSnW, bRowH, 8.0F, sRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 35.0F));
        custom.drawBlurredRect(snakeX, drawYSn, dockSnW, bRowH, 12.0F, 3.0F, sRad, new ColorRGBA(52.0F, 211.0F, 153.0F, 12.0F));
        custom.drawRoundedRect(snakeX, drawYSn, dockSnW, bRowH, sRad, new ColorRGBA(16.0F, 20.0F, 30.0F, 110.0F + 30.0F * hA1));
        custom.drawRoundedBorder(snakeX, drawYSn, dockSnW, bRowH, 0.5F, sRad, hA1 > 0.01F ? new ColorRGBA(52.0F, 211.0F, 153.0F, 90.0F * hA1) : new ColorRGBA(255.0F, 255.0F, 255.0F, 15.0F));

        custom.drawTexture(RockstarClient.id("icons/snake.png"), snakeX + 6.0F, drawYSn + (bRowH - sqIconSz) / 2.0F, sqIconSz, sqIconSz, ColorRGBA.WHITE);
        if (subFont != null) {
            custom.drawText(subFont, "Змейка", snakeX + 28.0F, drawYSn + 10.0F, ColorRGBA.WHITE);
        }

        // 3. [ (💣) Сапёр ] Mini-game
        float mineX = snakeX + dockSnW + dockGap;
        boolean mineHov = (mouseX >= mineX && mouseX <= mineX + dockMnW && mouseY >= bRowY + dockFlyY && mouseY <= bRowY + dockFlyY + bRowH);
        rockstar$dockBtnHover[2] += ((mineHov ? 1.0F : 0.0F) - rockstar$dockBtnHover[2]) * 0.22F;
        float hA2 = rockstar$dockBtnHover[2];
        float drawYMn = bRowY + dockFlyY - hA2 * 2.0F;

        custom.drawShadow(mineX, drawYMn, dockMnW, bRowH, 8.0F, sRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 35.0F));
        custom.drawBlurredRect(mineX, drawYMn, dockMnW, bRowH, 12.0F, 3.0F, sRad, new ColorRGBA(244.0F, 63.0F, 94.0F, 12.0F));
        custom.drawRoundedRect(mineX, drawYMn, dockMnW, bRowH, sRad, new ColorRGBA(16.0F, 20.0F, 30.0F, 110.0F + 30.0F * hA2));
        custom.drawRoundedBorder(mineX, drawYMn, dockMnW, bRowH, 0.5F, sRad, hA2 > 0.01F ? new ColorRGBA(244.0F, 63.0F, 94.0F, 90.0F * hA2) : new ColorRGBA(255.0F, 255.0F, 255.0F, 15.0F));

        custom.drawTexture(RockstarClient.id("icons/mine.png"), mineX + 6.0F, drawYMn + (bRowH - sqIconSz) / 2.0F, sqIconSz, sqIconSz, ColorRGBA.WHITE);
        if (subFont != null) {
            custom.drawText(subFont, "Сапёр", mineX + 28.0F, drawYMn + 10.0F, ColorRGBA.WHITE);
        }

        // ==========================================
        // 4. SLIDE-IN AI ASSISTANT DRAWER (from right edge)
        // ==========================================
        if (rockstar$aiDrawerAnim > 0.005F) {
            rockstar$renderSlideInAiDrawer(custom, boldFont, font, subFont, tinyFont, mouseX, mouseY);
        }

        // Fullscreen Shutter Flash on Screenshot
        if (rockstar$flashAlpha > 0.001F) {
            custom.drawRect(0.0F, 0.0F, (float)this.width, (float)this.height, new ColorRGBA(255.0F, 255.0F, 255.0F, 255.0F * rockstar$flashAlpha));
            rockstar$flashAlpha = Math.max(0.0F, rockstar$flashAlpha - delta * 0.16F);
        }
    }

    // Module 0: Real Browser Media Player Card
    @Unique
    private void rockstar$renderMediaCard(III custom, float x, float y, float w, float h, IIiIIi_Class10 font, IIiIIi_Class10 subFont, IIiIIi_Class10 tinyFont, int mx, int my, float hoverA, @Nullable iiIiIIIiI_Class419.Nested1_a961800 snap, @Nullable iiIiIIIiI_Class419 tracker) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(12.0F);
        ColorRGBA theme = IiiiiIIIi_Class242.I_method_7df8e08e();
        custom.drawShadow(x, y, w, h, 12.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 40.0F));
        custom.drawBlurredRect(x, y, w, h, 14.0F, 3.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 10.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(16.0F, 20.0F, 30.0F, 110.0F));
        custom.drawRoundedBorder(x, y, w, h, 0.5F, rad, hoverA > 0.01F ? theme.withAlpha(90.0F * hoverA) : new ColorRGBA(255.0F, 255.0F, 255.0F, 15.0F));

        boolean hasTrack = (snap != null);
        String trackTitle = hasTrack ? snap.I_method_33e8b426() : "Музыка";
        boolean isPlaying = hasTrack && snap.I_method_1a22ebbe();
        double posSec = hasTrack ? snap.I_method_1a22eba8() : 0.0;
        long durSec = hasTrack ? snap.I_method_1a22ebae() : 0L;
        Identifier artwork = hasTrack ? snap.I_method_77a14989() : null;

        // Album artwork thumbnail
        float thumbSz = 26.0F;
        custom.drawRoundedRect(x + 8.0F, y + 8.0F, thumbSz, thumbSz, IIiii_Class8.I_method_893b2757(6.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F));
        if (artwork != null) {
            custom.drawTexture(artwork, x + 8.0F, y + 8.0F, thumbSz, thumbSz, ColorRGBA.WHITE);
        } else {
            custom.drawIcon("music", x + 13.0F, y + 13.0F, 16.0F, ColorRGBA.WHITE.withAlpha(220.0F));
        }

        // Equalizer Bars
        float eqStartX = x + 38.0F;
        float eqBaseY = y + 28.0F;
        float barW = 2.0F;
        float barGap = 2.0F;
        for (int b = 0; b < rockstar$eqFrequencies.length; b++) {
            float bH = Math.max(3.0F, rockstar$eqFrequencies[b] * 16.0F);
            float bx = eqStartX + b * (barW + barGap);
            custom.drawRoundedRect(bx, eqBaseY - bH, barW, bH, IIiii_Class8.I_method_893b2757(1.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, isPlaying ? 220.0F : 70.0F));
        }

        // Web / Browser indicator icon in top right
        custom.drawIcon("language", x + w - 18.0F, y + 9.0F, 11.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 150.0F));

        // Track title
        if (font != null) {
            String shortTitle = trackTitle != null ? trackTitle : "Трек";
            if (shortTitle.length() > 16) shortTitle = shortTitle.substring(0, 15) + "…";
            custom.drawText(font, shortTitle, x + 8.0F, y + 38.0F, ColorRGBA.WHITE);
        }

        // Progress Scrubber Bar
        float scrubY = y + 51.0F;
        float scrubW = w - 16.0F;
        float scrubH = 2.5F;
        float scrubX = x + 8.0F;
        float progRatio = (durSec > 0) ? MathHelper.clamp((float)(posSec / (double)durSec), 0.0F, 1.0F) : 0.0F;

        custom.drawRoundedRect(scrubX, scrubY, scrubW, scrubH, IIiii_Class8.I_method_893b2757(1.5F), new ColorRGBA(255.0F, 255.0F, 255.0F, 30.0F));
        if (progRatio > 0.01F) {
            custom.drawRoundedRect(scrubX, scrubY, scrubW * progRatio, scrubH, IIiii_Class8.I_method_893b2757(1.5F), theme);
            custom.drawRoundedRect(scrubX + scrubW * progRatio - 2.5F, scrubY - 1.5F, 5.0F, 5.5F, IIiii_Class8.I_method_893b2757(2.5F), ColorRGBA.WHITE);
        }

        // Media controls row (⏮, ▶/⏸, ⏭)
        float ctrlY = y + 57.0F;
        if (subFont != null) {
            boolean prevHov = mx >= x + 12.0F && mx <= x + 28.0F && my >= ctrlY - 2.0F && my <= ctrlY + 12.0F;
            custom.drawText(subFont, "⏮", x + 14.0F, ctrlY, prevHov ? ColorRGBA.WHITE : new ColorRGBA(255.0F, 255.0F, 255.0F, 170.0F));

            boolean playHov = mx >= x + w / 2.0F - 10.0F && mx <= x + w / 2.0F + 10.0F && my >= ctrlY - 2.0F && my <= ctrlY + 12.0F;
            String playSym = isPlaying ? "⏸" : "▶";
            custom.drawText(subFont, playSym, x + w / 2.0F - 4.0F, ctrlY, playHov ? ColorRGBA.WHITE : new ColorRGBA(255.0F, 255.0F, 255.0F, 220.0F));

            boolean nextHov = mx >= x + w - 28.0F && mx <= x + w - 12.0F && my >= ctrlY - 2.0F && my <= ctrlY + 12.0F;
            custom.drawText(subFont, "⏭", x + w - 26.0F, ctrlY, nextHov ? ColorRGBA.WHITE : new ColorRGBA(255.0F, 255.0F, 255.0F, 170.0F));
        }
    }

    // Module 1: Separate iOS Weather Widget Card (NO overlap!)
    @Unique
    private void rockstar$renderWeatherCard(III custom, float x, float y, float w, float h, IIiIIi_Class10 boldFont, IIiIIi_Class10 font, IIiIIi_Class10 subFont, IIiIIi_Class10 tinyFont, int mx, int my, float hoverA, EscapeMenuConfig cfg) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(12.0F);
        custom.drawShadow(x, y, w, h, 12.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 40.0F));
        custom.drawBlurredRect(x, y, w, h, 14.0F, 3.0F, rad, new ColorRGBA(59.0F, 130.0F, 246.0F, 12.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(16.0F, 22.0F, 36.0F, 110.0F));
        custom.drawRoundedBorder(x, y, w, h, 0.5F, rad, hoverA > 0.01F ? new ColorRGBA(59.0F, 130.0F, 246.0F, 90.0F * hoverA) : new ColorRGBA(255.0F, 255.0F, 255.0F, 15.0F));

        WeatherAlertModule wMod = RockstarClient.getInstance().getModuleManager().getModule(WeatherAlertModule.class);
        int temp = (wMod != null) ? wMod.getCurrentWeatherTemp() : 16;
        String cond = (wMod != null) ? wMod.getWeatherCondition() : "Облачно ⛅";
        String city = (cfg.weatherCity != null) ? cfg.weatherCity : "Киев";

        // Top line: Header "Погода" + Emoji on far right
        if (subFont != null) {
            custom.drawText(subFont, "Погода", x + 10.0F, y + 8.5F, new ColorRGBA(190.0F, 210.0F, 240.0F, 210.0F));
        }
        if (font != null) {
            String emoji = cond.contains("☀️") ? "☀️" : (cond.contains("🌧️") ? "🌧️" : (cond.contains("🌤️") ? "🌤️" : "⛅"));
            custom.drawText(font, emoji, x + w - 22.0F, y + 7.5F, ColorRGBA.WHITE);
        }

        // Center line: Big Temperature
        if (boldFont != null) {
            String tempStr = (temp > 0 ? "+" : "") + temp + "°";
            custom.drawText(boldFont, tempStr, x + 10.0F, y + 26.0F, ColorRGBA.WHITE);
        }

        // Bottom line: City pill badge (click target!) + subtle condition
        float cityPillW = 50.0F;
        if (tinyFont != null) {
            cityPillW = tinyFont.I_method_2c375926(city + " ▾") + 10.0F;
        }
        custom.drawRoundedRect(x + 10.0F, y + 50.0F, cityPillW, 16.0F, IIiii_Class8.I_method_893b2757(5.0F), new ColorRGBA(59.0F, 130.0F, 246.0F, 40.0F));
        if (tinyFont != null) {
            custom.drawText(tinyFont, city + " ▾", x + 15.0F, y + 54.0F, ColorRGBA.WHITE);
            String shortCond = cond.split(" ")[0];
            custom.drawText(tinyFont, "• " + shortCond, x + 14.0F + cityPillW, y + 54.0F, new ColorRGBA(200.0F, 215.0F, 235.0F, 200.0F));
        }
    }

    // Module 2: Separate iOS Drone Threat Radar Card (NO text overlap!)
    @Unique
    private void rockstar$renderDroneRadarCard(III custom, float x, float y, float w, float h, IIiIIi_Class10 boldFont, IIiIIi_Class10 font, IIiIIi_Class10 subFont, IIiIIi_Class10 tinyFont, int mx, int my, float hoverA, EscapeMenuConfig cfg, long now) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(12.0F);
        custom.drawShadow(x, y, w, h, 12.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 40.0F));
        custom.drawBlurredRect(x, y, w, h, 14.0F, 3.0F, rad, new ColorRGBA(239.0F, 68.0F, 68.0F, 12.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(28.0F, 18.0F, 24.0F, 110.0F));
        custom.drawRoundedBorder(x, y, w, h, 0.5F, rad, hoverA > 0.01F ? new ColorRGBA(239.0F, 68.0F, 68.0F, 90.0F * hoverA) : new ColorRGBA(255.0F, 255.0F, 255.0F, 15.0F));

        // Top line: Pulsing dot + "Радар БПЛА" (NO badge collision!)
        float radarX = x + 14.0F;
        float radarY = y + 13.0F;
        float pulseScale = (float)(Math.sin(now / 200.0) * 0.35 + 0.65);
        ColorRGBA dotCol = new ColorRGBA(239.0F, 68.0F, 68.0F, 255.0F * pulseScale);
        custom.drawRoundedRect(radarX - 3.0F, radarY - 3.0F, 6.0F, 6.0F, IIiii_Class8.I_method_893b2757(3.0F), dotCol);

        if (subFont != null) {
            custom.drawText(subFont, "Радар БПЛА", radarX + 8.0F, y + 8.5F, new ColorRGBA(254.0F, 202.0F, 202.0F, 220.0F));
        }

        // Center line: Threat region text (neatly proportioned)
        String threatMsg = "Белгород, Курск";
        String threatLevel = "Тревога";
        if ("Украина".equals(cfg.alertScope)) {
            threatMsg = "Киев, Харьков";
            threatLevel = "Тревога";
        } else if ("Россия".equals(cfg.alertScope)) {
            threatMsg = "Белгород, Воронеж";
            threatLevel = "Угроза";
        }

        if (font != null) {
            custom.drawText(font, threatMsg, x + 10.0F, y + 28.0F, ColorRGBA.WHITE);
        }

        // Bottom line: Scope pill badge (click target!) + threat level
        float scopePillW = 52.0F;
        if (tinyFont != null) {
            scopePillW = tinyFont.I_method_2c375926(cfg.alertScope + " ▾") + 10.0F;
        }
        custom.drawRoundedRect(x + 10.0F, y + 50.0F, scopePillW, 16.0F, IIiii_Class8.I_method_893b2757(5.0F), new ColorRGBA(239.0F, 68.0F, 68.0F, 50.0F));
        if (tinyFont != null) {
            custom.drawText(tinyFont, cfg.alertScope + " ▾", x + 15.0F, y + 54.0F, ColorRGBA.WHITE);
            custom.drawText(tinyFont, "• " + threatLevel, x + 14.0F + scopePillW, y + 54.0F, new ColorRGBA(254.0F, 180.0F, 180.0F, 200.0F));
        }
    }

    // Module 2.5: Separate iOS Free RAM Card with Real-time Usage History Graph
    @Unique
    private void rockstar$renderRamCard(III custom, float x, float y, float w, float h, IIiIIi_Class10 boldFont, IIiIIi_Class10 font, IIiIIi_Class10 subFont, IIiIIi_Class10 tinyFont, int mx, int my, float hoverA, long now) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(12.0F);
        ColorRGBA theme = IiiiiIIIi_Class242.I_method_7df8e08e();
        custom.drawShadow(x, y, w, h, 12.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 40.0F));
        custom.drawBlurredRect(x, y, w, h, 14.0F, 3.0F, rad, new ColorRGBA(theme.getRed(), theme.getGreen(), theme.getBlue(), 12.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(18.0F, 22.0F, 32.0F, 110.0F));
        custom.drawRoundedBorder(x, y, w, h, 0.5F, rad, hoverA > 0.01F ? theme.withAlpha(90.0F * hoverA) : new ColorRGBA(255.0F, 255.0F, 255.0F, 15.0F));

        Runtime rt = Runtime.getRuntime();
        long maxMem = rt.maxMemory();
        long totalMem = rt.totalMemory();
        long freeMem = rt.freeMemory();
        long usedMem = totalMem - freeMem;
        long availableMem = maxMem - usedMem;
        double freeGB = (double)availableMem / 1073741824.0;
        double maxGB = (double)maxMem / 1073741824.0;
        float usageRatio = (float)usedMem / (float)maxMem;
        int freePct = (int)MathHelper.clamp((availableMem * 100.0) / maxMem, 0.0, 100.0);

        // Sample rolling RAM history every 350ms
        if (now - rockstar$lastRamSample > 350L) {
            rockstar$lastRamSample = now;
            System.arraycopy(rockstar$ramHistory, 1, rockstar$ramHistory, 0, rockstar$ramHistory.length - 1);
            rockstar$ramHistory[rockstar$ramHistory.length - 1] = MathHelper.clamp(usageRatio, 0.05F, 0.98F);
        }

        // Top line: Header "Свободно RAM" & Percentage chip / GC feedback
        if (subFont != null) {
            custom.drawText(subFont, "Свободно RAM", x + 10.0F, y + 8.5F, new ColorRGBA(210.0F, 225.0F, 250.0F, 220.0F));
        }

        boolean isGcFired = (now < rockstar$ramGcFeedbackTimer);
        if (isGcFired) {
            float badgeW = 54.0F;
            float badgeH = 14.0F;
            custom.drawRoundedRect(x + w - badgeW - 8.0F, y + 7.0F, badgeW, badgeH, IIiii_Class8.I_method_893b2757(4.0F), new ColorRGBA(16.0F, 185.0F, 129.0F, 180.0F));
            if (tinyFont != null) {
                custom.drawText(tinyFont, "✓ Очищено", x + w - badgeW - 4.0F, y + 10.0F, ColorRGBA.WHITE);
            }
        } else {
            // Free % badge
            float badgeW = 32.0F;
            float badgeH = 14.0F;
            ColorRGBA badgeCol = freePct > 35 ? new ColorRGBA(16.0F, 185.0F, 129.0F, 140.0F) : new ColorRGBA(245.0F, 158.0F, 11.0F, 140.0F);
            custom.drawRoundedRect(x + w - badgeW - 8.0F, y + 7.0F, badgeW, badgeH, IIiii_Class8.I_method_893b2757(4.0F), badgeCol);
            if (tinyFont != null) {
                String pctStr = freePct + "%";
                float tw = tinyFont.I_method_2c375926(pctStr);
                custom.drawText(tinyFont, pctStr, x + w - 8.0F - badgeW + (badgeW - tw) / 2.0F, y + 10.0F, ColorRGBA.WHITE);
            }
        }

        // Center line: e.g. "3.2 / 6.0 GB"
        if (font != null) {
            String gbStr = String.format(java.util.Locale.US, "%.1f / %.1f GB", freeGB, maxGB);
            custom.drawText(font, gbStr, x + 10.0F, y + 26.0F, ColorRGBA.WHITE);
        }

        // Bottom section: Real-time Area / Bar Graph
        float graphX = x + 10.0F;
        float graphY = y + 42.0F;
        float graphW = w - 20.0F;
        float graphH = 22.0F;

        // Baseline bar background
        custom.drawRoundedRect(graphX, graphY, graphW, graphH, IIiii_Class8.I_method_893b2757(4.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, 8.0F));

        int bars = rockstar$ramHistory.length;
        float barGap = 1.5F;
        float barW = (graphW - (bars - 1) * barGap) / bars;

        for (int i = 0; i < bars; i++) {
            float val = rockstar$ramHistory[i];
            if (val <= 0.01F) val = usageRatio;
            float bH = Math.max(2.0F, val * (graphH - 2.0F));
            float bx = graphX + i * (barW + barGap);
            float by = graphY + graphH - bH - 1.0F;

            // Gradient tint based on memory pressure
            ColorRGBA bCol;
            if (val > 0.85F) {
                bCol = new ColorRGBA(244.0F, 63.0F, 94.0F, 180.0F); // Rose red
            } else if (val > 0.70F) {
                bCol = new ColorRGBA(245.0F, 158.0F, 11.0F, 180.0F); // Amber
            } else {
                bCol = theme.withAlpha(160.0F + 50.0F * ((float)i / bars)); // Theme
            }

            custom.drawRoundedRect(bx, by, barW, bH, IIiii_Class8.I_method_893b2757(1.0F), bCol);
        }
    }

    // Module 3: Camera Tile
    @Unique
    private void rockstar$renderCameraTile(III custom, float x, float y, float w, float h, int mx, int my, float hoverA) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(12.0F);
        boolean hov = mx >= x && mx <= x + w && my >= y && my <= y + h;
        custom.drawShadow(x, y, w, h, 10.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 40.0F));
        custom.drawBlurredRect(x, y, w, h, 14.0F, 3.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 10.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(16.0F, 20.0F, 30.0F, 110.0F));
        custom.drawRoundedBorder(x, y, w, h, 0.5F, rad, hov ? new ColorRGBA(0.0F, 122.0F, 255.0F, 90.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 15.0F));

        float podSz = 28.0F;
        float px = x + (w - podSz) / 2.0F;
        float py = y + (h - podSz) / 2.0F;
        IIiii_Class8 pRad = IIiii_Class8.I_method_893b2757(8.0F);
        custom.drawRoundedRect(px, py, podSz, podSz, pRad, new ColorRGBA(0.0F, 122.0F, 255.0F, hov ? 220.0F : 170.0F));
        custom.drawIcon("hud/target", px + 6.0F, py + 6.0F, 16.0F, ColorRGBA.WHITE);
    }

    // Module 4: Fullscreen Tile
    @Unique
    private void rockstar$renderFullscreenTile(III custom, float x, float y, float w, float h, int mx, int my, float hoverA) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(12.0F);
        boolean hov = mx >= x && mx <= x + w && my >= y && my <= y + h;
        boolean isFs = (MinecraftClient.getInstance() != null && MinecraftClient.getInstance().getWindow().isFullscreen());

        custom.drawShadow(x, y, w, h, 10.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 40.0F));
        custom.drawBlurredRect(x, y, w, h, 14.0F, 3.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 10.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(16.0F, 20.0F, 30.0F, 110.0F));
        custom.drawRoundedBorder(x, y, w, h, 0.5F, rad, hov ? new ColorRGBA(52.0F, 199.0F, 89.0F, 90.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 15.0F));

        float podSz = 28.0F;
        float px = x + (w - podSz) / 2.0F;
        float py = y + (h - podSz) / 2.0F;
        IIiii_Class8 pRad = IIiii_Class8.I_method_893b2757(8.0F);
        custom.drawRoundedRect(px, py, podSz, podSz, pRad, isFs ? new ColorRGBA(52.0F, 199.0F, 89.0F, hov ? 220.0F : 170.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, hov ? 40.0F : 20.0F));
        custom.drawIcon("keyboard", px + 5.0F, py + 5.0F, 18.0F, ColorRGBA.WHITE);
    }

    // Module 5: Master Volume Vertical Slider Pill (Adapts to Active Client Theme!)
    @Unique
    private void rockstar$renderVolumePill(III custom, float x, float y, float w, float h, IIiIIi_Class10 subFont, int mx, int my, float hoverA) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(w / 2.0F);
        float currentVol = (float)MinecraftClient.getInstance().options.getSoundVolume(SoundCategory.MASTER);
        ColorRGBA theme = IiiiiIIIi_Class242.I_method_7df8e08e();

        // 1. Drop shadow & glass track
        custom.drawShadow(x, y, w, h, 12.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 45.0F));
        custom.drawBlurredRect(x, y, w, h, 14.0F, 3.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 10.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(16.0F, 20.0F, 30.0F, 125.0F));

        // 2. Dynamic theme-adapted fill track
        float fillH = h * MathHelper.clamp(currentVol, 0.0F, 1.0F);
        if (fillH > 4.0F) {
            float fillY = y + h - fillH;
            custom.drawShadow(x, fillY, w, fillH, 10.0F, rad, theme.withAlpha(85.0F));
            custom.drawBlurredRect(x, fillY, w, fillH, 12.0F, 2.0F, rad, theme.withAlpha(55.0F));
            custom.drawRoundedRect(x, fillY, w, fillH, rad, theme.withAlpha(225.0F));
        }

        // 3. Delicate rounded border with theme hover glow
        boolean active = hoverA > 0.05F || rockstar$isDraggingVolume;
        custom.drawRoundedBorder(x, y, w, h, 0.6F, rad, active ? theme.withAlpha(190.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F));

        // 4. Music note icon with high contrast
        boolean iconInFill = fillH > 32.0F;
        ColorRGBA iconCol = iconInFill ? ColorRGBA.WHITE : theme.withAlpha(240.0F);
        custom.drawIcon("music", x + (w - 18.0F) / 2.0F, y + h - 26.0F, 18.0F, iconCol);

        // 5. Volume percentage text
        if (subFont != null) {
            String pct = (int)(currentVol * 100.0F) + "%";
            float pw = subFont.I_method_2c375926(pct);
            boolean pctInFill = fillH >= h - 16.0F;
            custom.drawText(subFont, pct, x + (w - pw) / 2.0F, y + 10.0F, pctInFill ? new ColorRGBA(20.0F, 20.0F, 28.0F, 240.0F) : ColorRGBA.WHITE);
        }
    }

    // Module 6: Interactive iOS Calculator
    @Unique
    private void rockstar$renderCalculatorCard(III custom, float x, float y, float w, float h, IIiIIi_Class10 boldFont, IIiIIi_Class10 font, int mx, int my, float hoverA) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(12.0F);
        custom.drawShadow(x, y, w, h, 14.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 50.0F));
        custom.drawBlurredRect(x, y, w, h, 16.0F, 3.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 10.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(16.0F, 18.0F, 26.0F, 115.0F));
        custom.drawRoundedBorder(x, y, w, h, 0.5F, rad, hoverA > 0.01F ? new ColorRGBA(255.0F, 255.0F, 255.0F, 50.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 15.0F));

        // LCD Display Area
        float lcdH = 26.0F;
        float lcdY = y + 6.0F;
        String disp = rockstar$calcDisplay;
        if (disp.length() > 9) disp = disp.substring(0, 9);
        if (boldFont != null) {
            float txtW = boldFont.I_method_2c375926(disp);
            custom.drawText(boldFont, disp, x + w - txtW - 12.0F, lcdY + 7.0F, ColorRGBA.WHITE);
        }

        // Circular Button Grid (5 rows x 4 columns)
        String[][] btnGrid = new String[][]{
            { "C", "+/-", "%", "÷" },
            { "7", "8", "9", "×" },
            { "4", "5", "6", "-" },
            { "1", "2", "3", "+" },
            { "0", ".", "=" }
        };

        float gridStartY = lcdY + lcdH + 4.0F;
        float btnSz = 24.0F;
        float gap = 4.0F;

        for (int r = 0; r < 5; r++) {
            float rowY = gridStartY + r * (btnSz + gap);
            int cols = btnGrid[r].length;
            for (int c = 0; c < cols; c++) {
                String label = btnGrid[r][c];
                float bW = label.equals("0") ? (btnSz * 2.0F + gap) : btnSz;
                float bX = x + 8.0F + (c == 0 ? 0.0F : (r == 4 ? (btnSz * 2.0F + gap + gap + (c - 1) * (btnSz + gap)) : (c * (btnSz + gap))));
                boolean bHov = mx >= bX && mx <= bX + bW && my >= rowY && my <= rowY + btnSz;

                ColorRGBA bg;
                ColorRGBA fg = ColorRGBA.WHITE;
                if (r == 0 && c < 3) {
                    bg = new ColorRGBA(165.0F, 165.0F, 165.0F, bHov ? 220.0F : 160.0F);
                    fg = ColorRGBA.BLACK;
                } else if (c == 3 || label.equals("=")) {
                    bg = new ColorRGBA(255.0F, 159.0F, 10.0F, bHov ? 240.0F : 190.0F);
                } else {
                    bg = new ColorRGBA(255.0F, 255.0F, 255.0F, bHov ? 40.0F : 20.0F);
                }

                IIiii_Class8 bRad = IIiii_Class8.I_method_893b2757(btnSz / 2.0F);
                custom.drawRoundedRect(bX, rowY, bW, btnSz, bRad, bg);
                if (font != null) {
                    float lw = font.I_method_2c375926(label);
                    float lx = label.equals("0") ? (bX + 10.0F) : (bX + (bW - lw) / 2.0F);
                    custom.drawText(font, label, lx, rowY + 6.0F, fg);
                }
            }
        }
    }

    // Module 7: Streamlined Notes & Markers Widget (No pages, 1-click delete markers, coords, text pad)
    @Unique
    private void rockstar$renderNotesCard(III custom, float x, float y, float w, float h, IIiIIi_Class10 boldFont, IIiIIi_Class10 font, IIiIIi_Class10 subFont, IIiIIi_Class10 tinyFont, int mx, int my, float hoverA) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(12.0F);
        ColorRGBA theme = IiiiiIIIi_Class242.I_method_7df8e08e();
        custom.drawShadow(x, y, w, h, 14.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 40.0F));
        custom.drawBlurredRect(x, y, w, h, 16.0F, 3.0F, rad, new ColorRGBA(245.0F, 158.0F, 11.0F, 10.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(20.0F, 22.0F, 30.0F, 125.0F));
        custom.drawRoundedBorder(x, y, w, h, 0.6F, rad, rockstar$notesEditing ? new ColorRGBA(245.0F, 158.0F, 11.0F, 180.0F) : (hoverA > 0.01F ? theme.withAlpha(90.0F * hoverA) : new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F)));

        // Header Title: 📝 Блокнот
        float headerY = y + 7.0F;
        if (font != null) {
            custom.drawText(font, "📝 Блокнот", x + 10.0F, headerY + 1.0F, ColorRGBA.WHITE);
        }

        // Action button 1: [+ Метка]
        float btnMarkerW = 46.0F;
        float btnMarkerH = 15.0F;
        float btnMarkerX = x + w - btnMarkerW - 8.0F;
        float btnMarkerY = headerY;
        boolean markerHov = (mx >= btnMarkerX && mx <= btnMarkerX + btnMarkerW && my >= btnMarkerY && my <= btnMarkerY + btnMarkerH);
        IIiii_Class8 bRad = IIiii_Class8.I_method_893b2757(4.0F);
        custom.drawRoundedRect(btnMarkerX, btnMarkerY, btnMarkerW, btnMarkerH, bRad, markerHov ? new ColorRGBA(59.0F, 130.0F, 246.0F, 220.0F) : new ColorRGBA(59.0F, 130.0F, 246.0F, 140.0F));
        if (tinyFont != null) {
            float tw = tinyFont.I_method_2c375926("+ Метка");
            custom.drawText(tinyFont, "+ Метка", btnMarkerX + (btnMarkerW - tw) / 2.0F, btnMarkerY + (btnMarkerH - 6.5F) / 2.0F, ColorRGBA.WHITE);
        }

        // Action button 2: [+ Корды]
        float btnCoordW = 46.0F;
        float btnCoordX = btnMarkerX - btnCoordW - 4.0F;
        boolean coordHov = (mx >= btnCoordX && mx <= btnCoordX + btnCoordW && my >= btnMarkerY && my <= btnMarkerY + btnMarkerH);
        custom.drawRoundedRect(btnCoordX, btnMarkerY, btnCoordW, btnMarkerH, bRad, coordHov ? new ColorRGBA(16.0F, 185.0F, 129.0F, 220.0F) : new ColorRGBA(16.0F, 185.0F, 129.0F, 140.0F));
        if (tinyFont != null) {
            float tw = tinyFont.I_method_2c375926("+ Корды");
            custom.drawText(tinyFont, "+ Корды", btnCoordX + (btnCoordW - tw) / 2.0F, btnMarkerY + (btnMarkerH - 6.5F) / 2.0F, ColorRGBA.WHITE);
        }

        // Divider
        float divY = y + 26.0F;
        custom.drawRect(x + 10.0F, divY, w - 20.0F, 1.0F, new ColorRGBA(245.0F, 158.0F, 11.0F, 120.0F));

        // Markers Chips Row (if markers exist)
        List<NotesManager.Marker> markers = NotesManager.getMarkers();
        float curTopY = divY + 4.0F;
        if (!markers.isEmpty()) {
            float chipH = 15.0F;
            float chipY = curTopY;
            float maxShow = Math.min(3, markers.size());
            float chipGap = 3.0F;
            float chipW = (w - 20.0F - (maxShow - 1) * chipGap) / maxShow;

            for (int mi = 0; mi < maxShow; mi++) {
                NotesManager.Marker m = markers.get(mi);
                float chipX = x + 10.0F + mi * (chipW + chipGap);
                boolean chipHov = (mx >= chipX && mx <= chipX + chipW && my >= chipY && my <= chipY + chipH);
                IIiii_Class8 cRad = IIiii_Class8.I_method_893b2757(4.0F);

                custom.drawRoundedRect(chipX, chipY, chipW, chipH, cRad, chipHov ? new ColorRGBA(36.0F, 44.0F, 62.0F, 220.0F) : new ColorRGBA(28.0F, 32.0F, 46.0F, 180.0F));
                custom.drawRoundedBorder(chipX, chipY, chipW, chipH, 0.5F, cRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));

                // 1-Click Delete Button [✕] on right side of chip
                float delSz = 11.0F;
                float delX = chipX + chipW - delSz - 2.0F;
                float delY = chipY + (chipH - delSz) / 2.0F;
                boolean delHov = (mx >= delX && mx <= delX + delSz && my >= delY && my <= delY + delSz);

                custom.drawRoundedRect(delX, delY, delSz, delSz, IIiii_Class8.I_method_893b2757(2.0F), delHov ? new ColorRGBA(239.0F, 68.0F, 68.0F, 220.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 22.0F));
                if (tinyFont != null) {
                    float xTw = tinyFont.I_method_2c375926("×");
                    custom.drawText(tinyFont, "×", delX + (delSz - xTw) / 2.0F, delY + (delSz - 6.5F) / 2.0F, ColorRGBA.WHITE);
                }

                // Marker text
                if (tinyFont != null) {
                    String mTitle = "📍" + m.name;
                    float textMaxW = chipW - delSz - 6.0F;
                    if (tinyFont.I_method_2c375926(mTitle) > textMaxW) {
                        mTitle = m.name;
                    }
                    custom.drawText(tinyFont, mTitle, chipX + 3.0F, chipY + (chipH - 6.5F) / 2.0F, ColorRGBA.WHITE);
                }
            }
            curTopY += chipH + 4.0F;
        }

        // Text Input Area (No pages, continuous text input)
        float textPadX = x + 10.0F;
        float textPadY = curTopY;
        float textPadW = w - 20.0F;
        float textPadH = (y + h - 8.0F) - curTopY;

        IIiii_Class8 padRad = IIiii_Class8.I_method_893b2757(6.0F);
        custom.drawRoundedRect(textPadX, textPadY, textPadW, textPadH, padRad, new ColorRGBA(14.0F, 16.0F, 24.0F, 160.0F));
        custom.drawRoundedBorder(textPadX, textPadY, textPadW, textPadH, 0.5F, padRad, rockstar$notesEditing ? new ColorRGBA(245.0F, 158.0F, 11.0F, 140.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 16.0F));

        // Ruled notebook lines inside the text pad
        float lineSpacing = 14.0F;
        for (float ly = textPadY + lineSpacing; ly < textPadY + textPadH - 4.0F; ly += lineSpacing) {
            custom.drawRect(textPadX + 4.0F, ly, textPadW - 8.0F, 1.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 8.0F));
        }

        String noteContent = NotesManager.getQuickNote();
        if (subFont != null) {
            if (noteContent.isEmpty() && !rockstar$notesEditing) {
                custom.drawText(subFont, "Нажмите для ввода...", textPadX + 6.0F, textPadY + 4.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 80.0F));
            } else {
                String[] lines = noteContent.split("\n", -1);
                float lineY = textPadY + 3.0F;
                for (int li = 0; li < lines.length; li++) {
                    if (lineY + 10.0F > textPadY + textPadH - 2.0F) break;
                    String lStr = lines[li];
                    if (li == lines.length - 1 && rockstar$notesEditing && (System.currentTimeMillis() % 1000L < 500L)) {
                        lStr += "|";
                    }
                    custom.drawText(subFont, lStr, textPadX + 6.0F, lineY, ColorRGBA.WHITE);
                    lineY += lineSpacing;
                }
            }
        }
    }

    // Module 8: Slide-in AI Assistant Drawer (Fix icons, bubble wrapping, transparency)
    @Unique
    private void rockstar$renderSlideInAiDrawer(III custom, IIiIIi_Class10 boldFont, IIiIIi_Class10 font, IIiIIi_Class10 subFont, IIiIIi_Class10 tinyFont, int mx, int my) {
        float drawerW = 270.0F;
        float drawerH = Math.min(380.0F, this.height - 24.0F);
        float drawerY = this.height / 2.0F - drawerH / 2.0F;
        float drawerX = (float)this.width - rockstar$aiDrawerAnim * (drawerW + 12.0F);
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(14.0F);
        ColorRGBA theme = IiiiiIIIi_Class242.I_method_7df8e08e();

        custom.drawShadow(drawerX, drawerY, drawerW, drawerH, 18.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 55.0F));
        custom.drawBlurredRect(drawerX, drawerY, drawerW, drawerH, 20.0F, 3.5F, rad, new ColorRGBA(theme.getRed(), theme.getGreen(), theme.getBlue(), 12.0F));
        custom.drawRoundedRect(drawerX, drawerY, drawerW, drawerH, rad, new ColorRGBA(16.0F, 20.0F, 30.0F, 125.0F));
        custom.drawRoundedBorder(drawerX, drawerY, drawerW, drawerH, 0.5F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 16.0F));

        // Scrollable Chat Viewport Dimensions
        float chatX = drawerX + 10.0F;
        float chatY = drawerY + 38.0F;
        float chatW = drawerW - 20.0F;
        float chatH = drawerH - 76.0F;

        // Calculate total content height to properly clamp scroll
        List<AIAssistantService.ChatMessage> history = AIAssistantService.getHistory();
        float totalContentH = 8.0F;
        for (AIAssistantService.ChatMessage msg : history) {
            String fText = rockstar$formatAiText(msg.text());
            List<String> lines = rockstar$wrapLines(fText, chatW * 0.82F - 18.0F, subFont);
            float bH = Math.max(20.0F, lines.size() * 11.5F + 9.0F);
            totalContentH += bH + 5.0F;
        }
        if (rockstar$aiThinking) totalContentH += 24.0F;

        float maxScroll = Math.max(0.0F, totalContentH - chatH);
        rockstar$aiScroll = MathHelper.clamp(rockstar$aiScroll, 0.0F, maxScroll);

        float curY = chatY + 4.0F - rockstar$aiScroll;

        // SCISSOR CLIPPING: Completely prevents chat bubbles from rendering outside the chat viewport
        custom.enableScissor((int)chatX, (int)chatY, (int)(chatX + chatW), (int)(chatY + chatH));

        if (history.isEmpty()) {
            if (tinyFont != null) {
                String tip = "Задайте любой вопрос об игре,\nPvP или клиенте Agravity:";
                String[] tLines = tip.split("\n");
                custom.drawText(tinyFont, tLines[0], chatX + 12.0F, chatY + 24.0F, new ColorRGBA(180.0F, 195.0F, 220.0F, 180.0F));
                custom.drawText(tinyFont, tLines[1], chatX + 12.0F, chatY + 36.0F, new ColorRGBA(180.0F, 195.0F, 220.0F, 180.0F));
            }
        } else {
            for (AIAssistantService.ChatMessage msg : history) {
                boolean isUser = msg.isUser();
                float maxBubbleW = chatW * 0.82F;

                String fText = rockstar$formatAiText(msg.text());
                List<String> lines = rockstar$wrapLines(fText, maxBubbleW - 18.0F, subFont);
                float bH = Math.max(20.0F, lines.size() * 11.5F + 9.0F);

                float maxLineW = 0.0F;
                if (subFont != null) {
                    for (String l : lines) {
                        float lw = subFont.I_method_2c375926(l);
                        if (lw > maxLineW) maxLineW = lw;
                    }
                } else {
                    maxLineW = 70.0F;
                }
                float bW = Math.min(maxBubbleW, Math.max(28.0F, maxLineW + 18.0F));
                float bX = isUser ? (chatX + chatW - bW) : chatX;

                if (curY + bH >= chatY - 10.0F && curY <= chatY + chatH + 10.0F) {
                    IIiii_Class8 bubbleRad = IIiii_Class8.I_method_893b2757(9.0F);
                    if (isUser) {
                        custom.drawRoundedRect(bX, curY, bW, bH, bubbleRad, theme.withAlpha(200.0F));
                    } else {
                        custom.drawBlurredRect(bX, curY, bW, bH, 10.0F, 2.0F, bubbleRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 8.0F));
                        custom.drawRoundedRect(bX, curY, bW, bH, bubbleRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F));
                        custom.drawRoundedBorder(bX, curY, bW, bH, 0.5F, bubbleRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 12.0F));
                    }

                    if (subFont != null) {
                        float lineY = curY + 6.0F;
                        for (String l : lines) {
                            custom.drawText(subFont, l, bX + 9.0F, lineY, ColorRGBA.WHITE);
                            lineY += 11.5F;
                        }
                    }
                }
                curY += bH + 5.0F;
            }

            if (rockstar$aiThinking) {
                float thinkW = 90.0F;
                float thinkH = 18.0F;
                if (curY + thinkH >= chatY - 10.0F && curY <= chatY + chatH + 10.0F) {
                    custom.drawRoundedRect(chatX, curY, thinkW, thinkH, IIiii_Class8.I_method_893b2757(6.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F));
                    if (tinyFont != null) {
                        String dots = "...".substring(0, (int)(System.currentTimeMillis() / 350L % 4L));
                        custom.drawText(tinyFont, "ИИ думает" + dots, chatX + 8.0F, curY + 5.0F, theme.withAlpha(240.0F));
                    }
                }
            }
        }

        custom.disableScissor();

        // Render Header ON TOP so messages never overlap title or buttons
        float hY = drawerY + 10.0F;
        custom.drawRoundedRect(drawerX, drawerY, drawerW, 36.0F, new IIiii_Class8(14.0F, 14.0F, 0.0F, 0.0F), new ColorRGBA(16.0F, 20.0F, 30.0F, 230.0F));
        custom.drawTexture(RockstarClient.id("icons/ai.png"), drawerX + 12.0F, hY + 1.0F, 18.0F, 18.0F, ColorRGBA.WHITE);
        if (font != null) {
            custom.drawText(font, "Agravity AI", drawerX + 34.0F, hY + 4.5F, ColorRGBA.WHITE);
        }

        // Close button (xmark icon)
        float closeSz = 22.0F;
        float closeX = drawerX + drawerW - closeSz - 10.0F;
        float closeY = hY - 1.0F;
        boolean closeHov = (mx >= closeX && mx <= closeX + closeSz && my >= closeY && my <= closeY + closeSz);
        IIiii_Class8 cRad = IIiii_Class8.I_method_893b2757(closeSz / 2.0F);
        custom.drawRoundedRect(closeX, closeY, closeSz, closeSz, cRad, closeHov ? new ColorRGBA(239.0F, 68.0F, 68.0F, 180.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 16.0F));
        custom.drawIcon("xmark", closeX + (closeSz - 10.0F) / 2.0F, closeY + (closeSz - 10.0F) / 2.0F, 10.0F, ColorRGBA.WHITE);

        // Clear chat button (trash icon)
        float clrX = closeX - closeSz - 6.0F;
        boolean clrHov = (mx >= clrX && mx <= clrX + closeSz && my >= closeY && my <= closeY + closeSz);
        custom.drawRoundedRect(clrX, closeY, closeSz, closeSz, cRad, clrHov ? new ColorRGBA(255.0F, 255.0F, 255.0F, 35.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 16.0F));
        custom.drawIcon("trash", clrX + (closeSz - 10.0F) / 2.0F, closeY + (closeSz - 10.0F) / 2.0F, 10.0F, ColorRGBA.WHITE);

        // Header divider
        float divY = drawerY + 35.0F;
        custom.drawRect(drawerX + 10.0F, divY, drawerW - 20.0F, 1.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 14.0F));

        // Bottom Input Bar Container ON TOP
        float inBarAreaY = drawerY + drawerH - 38.0F;
        custom.drawRoundedRect(drawerX, inBarAreaY, drawerW, 38.0F, new IIiii_Class8(0.0F, 0.0F, 14.0F, 14.0F), new ColorRGBA(16.0F, 20.0F, 30.0F, 230.0F));
        custom.drawRect(drawerX + 10.0F, inBarAreaY, drawerW - 20.0F, 1.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 14.0F));

        float inY = drawerY + drawerH - 32.0F;
        float inH = 26.0F;
        float sendW = 54.0F;
        float inW = drawerW - 20.0F - sendW - 6.0F;
        float inX = drawerX + 10.0F;

        IIiii_Class8 inRad = IIiii_Class8.I_method_893b2757(inH / 2.0F);
        custom.drawRoundedRect(inX, inY, inW, inH, inRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 14.0F));
        custom.drawRoundedBorder(inX, inY, inW, inH, 0.5F, inRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F));

        if (subFont != null) {
            String promptDisp = rockstar$aiInput.isEmpty() ? "Спросить..." : rockstar$aiInput;
            if (System.currentTimeMillis() % 1000L < 500L && !rockstar$aiInput.isEmpty()) promptDisp += "|";
            ColorRGBA col = rockstar$aiInput.isEmpty() ? new ColorRGBA(255.0F, 255.0F, 255.0F, 110.0F) : ColorRGBA.WHITE;
            custom.drawText(subFont, promptDisp, inX + 10.0F, inY + 8.0F, col);
        }

        // Send Button [Отправить]
        float sendX = inX + inW + 6.0F;
        boolean sendHov = (mx >= sendX && mx <= sendX + sendW && my >= inY && my <= inY + inH);
        custom.drawRoundedRect(sendX, inY, sendW, inH, inRad, sendHov ? theme.withAlpha(235.0F) : theme.withAlpha(190.0F));
        custom.drawRoundedBorder(sendX, inY, sendW, inH, 0.5F, inRad, ColorRGBA.WHITE.withAlpha(sendHov ? 90.0F : 30.0F));
        if (tinyFont != null) {
            float sendTxtW = tinyFont.I_method_2c375926("Отправить");
            custom.drawText(tinyFont, "Отправить", sendX + (sendW - sendTxtW) / 2.0F, inY + 8.0F, ColorRGBA.WHITE);
        }
    }

    @Unique
    private static String rockstar$formatAiText(String text) {
        if (text == null) return "";
        String cleaned = text.replace("**", "").replace("__", "");
        String[] lines = cleaned.split("\n");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            String l = lines[i];
            if (l.trim().startsWith("* ") || l.trim().startsWith("- ")) {
                l = "• " + l.trim().substring(2);
            } else if (l.trim().startsWith("### ")) {
                l = l.trim().substring(4);
            } else if (l.trim().startsWith("## ")) {
                l = l.trim().substring(3);
            } else if (l.trim().startsWith("# ")) {
                l = l.trim().substring(2);
            }
            sb.append(l);
            if (i < lines.length - 1) sb.append("\n");
        }
        return sb.toString();
    }

    @Unique
    private static List<String> rockstar$wrapLines(String text, float maxW, IIiIIi_Class10 font) {
        List<String> res = new ArrayList<>();
        if (font == null || text == null) {
            res.add(text != null ? text : "");
            return res;
        }
        String[] paragraphs = text.split("\n");
        for (String p : paragraphs) {
            String[] words = p.split(" ");
            StringBuilder line = new StringBuilder();
            for (String w : words) {
                String candidate = line.isEmpty() ? w : (line + " " + w);
                if (font.I_method_2c375926(candidate) > maxW && !line.isEmpty()) {
                    res.add(line.toString());
                    line = new StringBuilder(w);
                } else {
                    line = new StringBuilder(candidate);
                }
            }
            if (!line.isEmpty()) res.add(line.toString());
        }
        return res;
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        float cx = this.width / 2.0F;
        float cy = this.height / 2.0F;
        EscapeMenuConfig cfg = EscapeMenuConfig.getInstance();

        // 1. Check Clicks on Slide-in AI Drawer (if open)
        if (rockstar$aiDrawerOpen && rockstar$aiDrawerAnim > 0.5F) {
            float drawerW = 270.0F;
            float drawerH = Math.min(380.0F, this.height - 24.0F);
            float drawerY = this.height / 2.0F - drawerH / 2.0F;
            float drawerX = (float)this.width - (drawerW + 12.0F);

            if (mouseX >= drawerX && mouseX <= drawerX + drawerW && mouseY >= drawerY && mouseY <= drawerY + drawerH) {
                // Close button [xmark]
                float closeSz = 22.0F;
                float closeX = drawerX + drawerW - closeSz - 10.0F;
                float closeY = drawerY + 9.0F;
                if (mouseX >= closeX && mouseX <= closeX + closeSz && mouseY >= closeY && mouseY <= closeY + closeSz) {
                    UISoundManager.playButtonClick();
                    rockstar$aiDrawerOpen = false;
                    return true;
                }

                // Clear button [trash]
                float clrX = closeX - closeSz - 6.0F;
                if (mouseX >= clrX && mouseX <= clrX + closeSz && mouseY >= closeY && mouseY <= closeY + closeSz) {
                    UISoundManager.playButtonClick();
                    AIAssistantService.clearHistory();
                    rockstar$aiScroll = 0.0F;
                    return true;
                }

                // Send button
                float inY = drawerY + drawerH - 34.0F;
                float inH = 26.0F;
                float sendW = 54.0F;
                float sendX = drawerX + drawerW - 10.0F - sendW;
                if (mouseX >= sendX && mouseX <= sendX + sendW && mouseY >= inY && mouseY <= inY + inH) {
                    if (!rockstar$aiInput.trim().isEmpty() && !rockstar$aiThinking) {
                        UISoundManager.playButtonClick();
                        rockstar$sendAiPrompt(rockstar$aiInput.trim());
                        rockstar$aiInput = "";
                    }
                    return true;
                }
                return true; // Consume click inside drawer
            }
        }

        // 2. Top Row Widget Clicks:
        float topW = 120.0F;
        float topH = 74.0F;
        float topGap = 8.0F;
        int topCardCount = 0;
        if (cfg.showMediaPlayer) topCardCount++;
        if (cfg.showWeather) topCardCount++;
        if (cfg.showDroneAlerts) topCardCount++;
        if (cfg.showRamUsage) topCardCount++;
        topCardCount = Math.max(1, topCardCount);
        float topTotalW = topCardCount * topW + (topCardCount - 1) * topGap;
        float topStartX = cx - topTotalW / 2.0F;
        float topY = cy - 138.0F;
        float curTopX = topStartX;

        // Media Player Click
        if (cfg.showMediaPlayer) {
            float mX = curTopX;
            curTopX += topW + topGap;
            if (mouseX >= mX && mouseX <= mX + topW && mouseY >= topY && mouseY <= topY + topH) {
                iiIiIIIiI_Class419 tracker = RockstarClient.getInstance().I_method_be969482();
                float ctrlY = topY + 54.0F;
                if (mouseY >= ctrlY && mouseY <= topY + topH) {
                    // Previous
                    if (mouseX >= mX + 10.0F && mouseX <= mX + 30.0F) {
                        if (tracker != null && tracker.I_method_9b92c97b() != null) tracker.I_method_9b92c97b().previous();
                        UISoundManager.playButtonClick();
                        return true;
                    }
                    // Play/Pause
                    if (mouseX >= mX + topW / 2.0F - 14.0F && mouseX <= mX + topW / 2.0F + 14.0F) {
                        if (tracker != null && tracker.I_method_9b92c97b() != null) tracker.I_method_9b92c97b().playPause();
                        UISoundManager.playButtonClick();
                        return true;
                    }
                    // Next
                    if (mouseX >= mX + topW - 30.0F && mouseX <= mX + topW - 10.0F) {
                        if (tracker != null && tracker.I_method_9b92c97b() != null) tracker.I_method_9b92c97b().next();
                        UISoundManager.playButtonClick();
                        return true;
                    }
                }
                if (tracker != null && tracker.I_method_9b92c97b() != null) tracker.I_method_9b92c97b().playPause();
                UISoundManager.playButtonClick();
                return true;
            }
        }

        // Weather Card Click (Cycles City!)
        if (cfg.showWeather) {
            float wX = curTopX;
            curTopX += topW + topGap;
            if (mouseX >= wX && mouseX <= wX + topW && mouseY >= topY && mouseY <= topY + topH) {
                String curCity = (cfg.weatherCity != null) ? cfg.weatherCity : "Киев";
                int nextIdx = 0;
                for (int i = 0; i < EscapeMenuCustomizerScreen.WEATHER_CITIES.length; i++) {
                    if (EscapeMenuCustomizerScreen.WEATHER_CITIES[i].equalsIgnoreCase(curCity)) {
                        nextIdx = (i + 1) % EscapeMenuCustomizerScreen.WEATHER_CITIES.length;
                        break;
                    }
                }
                String nextCity = EscapeMenuCustomizerScreen.WEATHER_CITIES[nextIdx];
                cfg.weatherCity = nextCity;
                cfg.save();
                WeatherAlertModule wMod = RockstarClient.getInstance().getModuleManager().getModule(WeatherAlertModule.class);
                if (wMod != null) {
                    wMod.setCity(nextCity);
                }
                UISoundManager.playButtonClick();
                return true;
            }
        }

        // Drone Radar Card Click (Cycles Scope!)
        if (cfg.showDroneAlerts) {
            float rX = curTopX;
            curTopX += topW + topGap;
            if (mouseX >= rX && mouseX <= rX + topW && mouseY >= topY && mouseY <= topY + topH) {
                if ("Все".equals(cfg.alertScope)) cfg.alertScope = "Украина";
                else if ("Украина".equals(cfg.alertScope)) cfg.alertScope = "Россия";
                else cfg.alertScope = "Все";
                cfg.save();
                UISoundManager.playButtonClick();
                return true;
            }
        }

        // Free RAM Card Click (Triggers Garbage Collection!)
        if (cfg.showRamUsage) {
            float ramX = curTopX;
            curTopX += topW + topGap;
            if (mouseX >= ramX && mouseX <= ramX + topW && mouseY >= topY && mouseY <= topY + topH) {
                System.gc();
                rockstar$ramGcFeedbackTimer = System.currentTimeMillis() + 1500L;
                UISoundManager.playButtonClick();
                return true;
            }
        }

        // 3. Main Content Row Widget Clicks:
        float mainTotalW = 504.0F;
        float gridStartX = cx - mainTotalW / 2.0F;
        float mainY = cy - 46.0F;
        float mainH = 165.0F;

        // Volume Pill Click (left edge of main content)
        float curX = gridStartX;
        float leftPodW = 94.0F;
        if (cfg.showVolume) {
            float volW = 44.0F;
            if (mouseX >= curX && mouseX <= curX + volW && mouseY >= mainY && mouseY <= mainY + mainH) {
                rockstar$isDraggingVolume = true;
                rockstar$updateVolume(mouseY, mainY, mainH);
                return true;
            }
        }

        // Camera / Fullscreen Tiles Click
        float qX = curX + 48.0F;
        float qW = 46.0F;
        float qTileH = (mainH - 5.0F) / 2.0F;
        if (cfg.showCamera) {
            // Camera
            if (mouseX >= qX && mouseX <= qX + qW && mouseY >= mainY && mouseY <= mainY + qTileH) {
                rockstar$flashAlpha = 1.0F;
                UISoundManager.playButtonClick();
                if (this.client != null && this.client.getFramebuffer() != null) {
                    ScreenshotRecorder.saveScreenshot(this.client.runDirectory, this.client.getFramebuffer(), msg -> {
                        if (this.client != null) this.client.execute(() -> this.client.inGameHud.getChatHud().addMessage(msg));
                    });
                }
                return true;
            }
            // Fullscreen
            float fsY = mainY + qTileH + 5.0F;
            if (mouseX >= qX && mouseX <= qX + qW && mouseY >= fsY && mouseY <= fsY + qTileH) {
                UISoundManager.playButtonClick();
                if (this.client != null) {
                    this.client.getWindow().toggleFullscreen();
                }
                return true;
            }
        }
        curX += leftPodW + 10.0F;

        // Calculator Card Click
        float calcW = 152.0F;
        if (cfg.showCalculator) {
            if (mouseX >= curX && mouseX <= curX + calcW && mouseY >= mainY && mouseY <= mainY + mainH) {
                if (rockstar$handleCalcClick(mouseX, mouseY, curX, mainY, calcW, mainH)) {
                    return true;
                }
            }
            curX += calcW + 10.0F;
        }

        // Embedded Notes Widget Click
        float notesW = (gridStartX + mainTotalW) - curX;
        if (cfg.showNotes && notesW > 60.0F && mouseX >= curX && mouseX <= curX + notesW && mouseY >= mainY && mouseY <= mainY + mainH) {
            float headerY = mainY + 7.0F;
            float btnMarkerW = 46.0F;
            float btnMarkerH = 15.0F;
            float btnMarkerX = curX + notesW - btnMarkerW - 8.0F;
            float btnMarkerY = headerY;

            // 1. [+ Метка] Click
            if (mouseX >= btnMarkerX && mouseX <= btnMarkerX + btnMarkerW && mouseY >= btnMarkerY && mouseY <= btnMarkerY + btnMarkerH) {
                UISoundManager.playButtonClick();
                rockstar$addPlayerMarker();
                return true;
            }

            // 2. [+ Корды] Click
            float btnCoordW = 46.0F;
            float btnCoordX = btnMarkerX - btnCoordW - 4.0F;
            if (mouseX >= btnCoordX && mouseX <= btnCoordX + btnCoordW && mouseY >= btnMarkerY && mouseY <= btnMarkerY + btnMarkerH) {
                UISoundManager.playButtonClick();
                rockstar$insertCoordinatesToActiveNote();
                return true;
            }

            // 3. Markers row clicks (1-click delete or paste)
            List<NotesManager.Marker> markers = NotesManager.getMarkers();
            float divY = mainY + 26.0F;
            float curTopY = divY + 4.0F;
            if (!markers.isEmpty()) {
                float chipH = 15.0F;
                float chipY = curTopY;
                float maxShow = Math.min(3, markers.size());
                float chipGap = 3.0F;
                float chipW = (notesW - 20.0F - (maxShow - 1) * chipGap) / maxShow;

                for (int mi = 0; mi < maxShow; mi++) {
                    NotesManager.Marker m = markers.get(mi);
                    float chipX = curX + 10.0F + mi * (chipW + chipGap);

                    // 1-Click Delete button [✕] on marker
                    float delSz = 11.0F;
                    float delX = chipX + chipW - delSz - 2.0F;
                    float delY = chipY + (chipH - delSz) / 2.0F;
                    if (mouseX >= delX && mouseX <= delX + delSz && mouseY >= delY && mouseY <= delY + delSz) {
                        UISoundManager.playButtonClick();
                        NotesManager.deleteMarker(m.id);
                        return true;
                    }

                    // Click on chip itself: copy cords & append to note!
                    if (mouseX >= chipX && mouseX <= chipX + chipW && mouseY >= chipY && mouseY <= chipY + chipH) {
                        UISoundManager.playButtonClick();
                        String cur = NotesManager.getQuickNote();
                        NotesManager.setQuickNote(cur + (cur.isEmpty() || cur.endsWith("\n") ? "" : "\n") + "[📍 " + m.name + ": " + m.cords + "]");
                        if (this.client != null && this.client.keyboard != null) {
                            this.client.keyboard.setClipboard(m.cords);
                        }
                        return true;
                    }
                }
            }

            // 4. Clicked inside text pad: focus and edit!
            rockstar$notesEditing = true;
            UISoundManager.playButtonClick();
            return true;
        } else {
            rockstar$notesEditing = false;
        }

        // 4. Primary Action Buttons Dock (Horizontal 4-Button Row)
        // [▶ В игру] | [⚙ Настройки] | [🎨 Кастомизация] | [✕ Выйти]
        float actY = mainY + mainH + 10.0F;
        float actBtnH = 38.0F;
        float actGap = 8.0F;
        float actBtnW = (mainTotalW - 3.0F * actGap) / 4.0F;

        if (mouseY >= actY && mouseY <= actY + actBtnH) {
            for (int i = 0; i < 4; i++) {
                float bX = gridStartX + i * (actBtnW + actGap);
                if (mouseX >= bX && mouseX <= bX + actBtnW) {
                    UISoundManager.playButtonClick();
                    switch (i) {
                        case 0 -> this.close(); // Resume
                        case 1 -> { // Options
                            if (this.client != null) this.client.setScreen(new OptionsScreen(this, this.client.options));
                        }
                        case 2 -> { // Customizer
                            if (this.client != null) this.client.setScreen(new EscapeMenuCustomizerScreen(this));
                        }
                        case 3 -> this.disconnect(); // Disconnect
                    }
                    return true;
                }
            }
        }

        // 5. Bottom Mini-Apps Dock Clicks: [AI] | [Змейка] | [Сапер]
        float bRowY = actY + actBtnH + 9.0F;
        float bRowH = 28.0F;
        float dockAiW = 106.0F;
        float dockSnW = 82.0F;
        float dockMnW = 82.0F;
        float dockGap = 6.0F;
        float dockTotalW = dockAiW + dockSnW + dockMnW + dockGap * 2.0F;
        float bStartX = cx - dockTotalW / 2.0F;

        // [ (✦) Agravity AI ] Click: Toggle Slide-in Drawer!
        float aiX = bStartX;
        if (mouseX >= aiX && mouseX <= aiX + dockAiW && mouseY >= bRowY && mouseY <= bRowY + bRowH) {
            UISoundManager.playButtonClick();
            rockstar$aiDrawerOpen = !rockstar$aiDrawerOpen;
            return true;
        }

        // [ (🐍) Змейка ] Click
        float snakeX = aiX + dockAiW + dockGap;
        if (cfg.showGames && mouseX >= snakeX && mouseX <= snakeX + dockSnW && mouseY >= bRowY && mouseY <= bRowY + bRowH) {
            UISoundManager.playButtonClick();
            if (this.client != null) {
                this.client.setScreen(new SnakeScreen(this));
            }
            return true;
        }

        // [ (💣) Сапёр ] Click
        float mineX = snakeX + dockSnW + dockGap;
        if (cfg.showGames && mouseX >= mineX && mouseX <= mineX + dockMnW && mouseY >= bRowY && mouseY <= bRowY + bRowH) {
            UISoundManager.playButtonClick();
            if (this.client != null) {
                this.client.setScreen(new MinesweeperScreen(this));
            }
            return true;
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Unique
    private static String rockstar$getCurrentCoordsString() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc != null && mc.player != null) {
            BlockPos pos = mc.player.getBlockPos();
            String dim = "Верхний";
            if (mc.world != null) {
                if (mc.world.getRegistryKey() == World.NETHER) dim = "Незер";
                else if (mc.world.getRegistryKey() == World.END) dim = "Энд";
            }
            return String.format("%d %d %d (%s)", pos.getX(), pos.getY(), pos.getZ(), dim);
        }
        return "0 0 0";
    }

    @Unique
    private static void rockstar$insertCoordinatesToActiveNote() {
        MinecraftClient mc = MinecraftClient.getInstance();
        String cordStr = rockstar$getCurrentCoordsString();
        String cur = NotesManager.getQuickNote();
        NotesManager.setQuickNote(cur + (cur.isEmpty() || cur.endsWith("\n") ? "" : "\n") + "[📍 " + cordStr + "]");
        if (mc != null && mc.keyboard != null) {
            mc.keyboard.setClipboard(cordStr);
        }
    }

    @Unique
    private static void rockstar$addPlayerMarker() {
        MinecraftClient mc = MinecraftClient.getInstance();
        String cordStr = rockstar$getCurrentCoordsString();
        int idx = NotesManager.getMarkers().size() + 1;
        NotesManager.addMarker("Метка " + idx, cordStr);
        if (mc != null && mc.keyboard != null) {
            mc.keyboard.setClipboard(cordStr);
        }
    }

    @Unique
    private static void rockstar$sendAiPrompt(String text) {
        rockstar$aiThinking = true;
        rockstar$aiScroll = Math.max(0.0F, rockstar$aiScroll + 50.0F);
        AIAssistantService.sendMessageAsync(text, reply -> {
            rockstar$aiThinking = false;
        });
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        if (rockstar$isDraggingVolume) {
            float cy = this.height / 2.0F;
            float volY = cy - 46.0F;
            rockstar$updateVolume(mouseY, volY, 165.0F);
            return true;
        }

        return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        rockstar$isDraggingVolume = false;
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        if (rockstar$aiDrawerOpen) {
            rockstar$aiScroll = Math.max(0.0F, rockstar$aiScroll - (float)verticalAmount * 18.0F);
            return true;
        }
        return super.mouseScrolled(mouseX, mouseY, horizontalAmount, verticalAmount);
    }

    @Unique
    private static void rockstar$updateVolume(double mouseY, float y, float h) {
        float rel = 1.0F - (float)((mouseY - y) / h);
        float newVol = MathHelper.clamp(rel, 0.0F, 1.0F);
        if (MinecraftClient.getInstance() != null) {
            MinecraftClient.getInstance().options.getSoundVolumeOption(SoundCategory.MASTER).setValue((double)newVol);
        }
    }

    @Unique
    private static boolean rockstar$handleCalcClick(double mx, double my, float x, float y, float w, float h) {
        float lcdH = 26.0F;
        float gridStartY = y + 6.0F + lcdH + 4.0F;
        float btnSz = 24.0F;
        float gap = 4.0F;

        String[][] btnGrid = new String[][]{
            { "C", "+/-", "%", "÷" },
            { "7", "8", "9", "×" },
            { "4", "5", "6", "-" },
            { "1", "2", "3", "+" },
            { "0", ".", "=" }
        };

        for (int r = 0; r < 5; r++) {
            float rowY = gridStartY + r * (btnSz + gap);
            int cols = btnGrid[r].length;
            for (int c = 0; c < cols; c++) {
                String label = btnGrid[r][c];
                float bW = label.equals("0") ? (btnSz * 2.0F + gap) : btnSz;
                float bX = x + 8.0F + (c == 0 ? 0.0F : (r == 4 ? (btnSz * 2.0F + gap + gap + (c - 1) * (btnSz + gap)) : (c * (btnSz + gap))));

                if (mx >= bX && mx <= bX + bW && my >= rowY && my <= rowY + btnSz) {
                    UISoundManager.playButtonClick();
                    rockstar$processCalcInput(label);
                    return true;
                }
            }
        }
        return false;
    }

    @Unique
    private static void rockstar$processCalcInput(String key) {
        try {
            switch (key) {
                case "C" -> {
                    rockstar$calcDisplay = "0";
                    rockstar$calcStored = 0.0;
                    rockstar$calcOp = null;
                    rockstar$calcClearNext = false;
                }
                case "+/-" -> {
                    if (rockstar$calcDisplay.startsWith("-")) {
                        rockstar$calcDisplay = rockstar$calcDisplay.substring(1);
                    } else if (!rockstar$calcDisplay.equals("0")) {
                        rockstar$calcDisplay = "-" + rockstar$calcDisplay;
                    }
                }
                case "%" -> {
                    double v = Double.parseDouble(rockstar$calcDisplay) / 100.0;
                    rockstar$calcDisplay = (v == (long)v) ? String.format("%d", (long)v) : String.valueOf(v);
                }
                case "+", "-", "×", "÷" -> {
                    rockstar$calcStored = Double.parseDouble(rockstar$calcDisplay);
                    rockstar$calcOp = key;
                    rockstar$calcClearNext = true;
                }
                case "=" -> {
                    if (rockstar$calcOp != null) {
                        double cur = Double.parseDouble(rockstar$calcDisplay);
                        double res = switch (rockstar$calcOp) {
                            case "+" -> rockstar$calcStored + cur;
                            case "-" -> rockstar$calcStored - cur;
                            case "×" -> rockstar$calcStored * cur;
                            case "÷" -> cur != 0 ? rockstar$calcStored / cur : 0;
                            default -> cur;
                        };
                        rockstar$calcDisplay = (res == (long)res) ? String.format("%d", (long)res) : String.valueOf(res);
                        rockstar$calcOp = null;
                        rockstar$calcClearNext = true;
                    }
                }
                case "." -> {
                    if (rockstar$calcClearNext) {
                        rockstar$calcDisplay = "0.";
                        rockstar$calcClearNext = false;
                    } else if (!rockstar$calcDisplay.contains(".")) {
                        rockstar$calcDisplay += ".";
                    }
                }
                default -> { // Numbers 0 - 9
                    if (rockstar$calcClearNext || rockstar$calcDisplay.equals("0")) {
                        rockstar$calcDisplay = key;
                        rockstar$calcClearNext = false;
                    } else {
                        rockstar$calcDisplay += key;
                    }
                }
            }
        } catch (Throwable ignored) {
            rockstar$calcDisplay = "Error";
            rockstar$calcClearNext = true;
        }
    }

    @Unique
    private void disconnect() {
        if (this.client == null) return;
        boolean singleplayer = this.client.isInSingleplayer();
        ServerInfo serverInfo = this.client.getCurrentServerEntry();
        
        // Hide escape screen so it is never captured in screenshots/framebuffer
        this.client.setScreen(null);
        if (this.client.gameRenderer != null && this.client.world != null) {
            try {
                this.client.gameRenderer.renderWorld(RenderTickCounter.ONE);
            } catch (Throwable ignored) {}
        }

        IiiIIiIii_Class204.captureLastGameFrame();
        IiiIIiIii_Class204.triggerReturnAnimation = true;
        if (this.client.world != null) {
            this.client.world.disconnect();
        }
        if (singleplayer) {
            this.client.disconnect(new IiiIIiIii_Class204());
        } else if (serverInfo != null && serverInfo.isRealm()) {
            this.client.disconnect(new RealmsMainScreen(new TitleScreen()));
        } else {
            this.client.disconnect(new IiiIIiIii_Class204());
        }
    }

    @Override
    public boolean charTyped(char chr, int modifiers) {
        if (rockstar$aiDrawerOpen && rockstar$aiDrawerAnim > 0.5F) {
            if (chr >= 32 && chr != 127) {
                rockstar$aiInput += chr;
                return true;
            }
        }
        if (rockstar$notesEditing) {
            if (chr >= 32 && chr != 127) {
                String cur = NotesManager.getQuickNote();
                NotesManager.setQuickNote(cur + chr);
                return true;
            }
        }
        return super.charTyped(chr, modifiers);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        boolean isCtrlDown = Screen.hasControlDown() || (modifiers & GLFW.GLFW_MOD_CONTROL) != 0;

        if (rockstar$aiDrawerOpen && rockstar$aiDrawerAnim > 0.5F) {
            if (isCtrlDown) {
                if (keyCode == GLFW.GLFW_KEY_V) {
                    MinecraftClient mc = MinecraftClient.getInstance();
                    if (mc != null && mc.keyboard != null) {
                        String clip = mc.keyboard.getClipboard();
                        if (clip != null && !clip.isEmpty()) {
                            rockstar$aiInput += clip.replace("\r", "").replace("\n", " ");
                            return true;
                        }
                    }
                } else if (keyCode == GLFW.GLFW_KEY_C) {
                    MinecraftClient mc = MinecraftClient.getInstance();
                    if (mc != null && mc.keyboard != null && !rockstar$aiInput.isEmpty()) {
                        mc.keyboard.setClipboard(rockstar$aiInput);
                        return true;
                    }
                }
            }

            if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
                rockstar$aiDrawerOpen = false;
                return true;
            }
            if (keyCode == GLFW.GLFW_KEY_BACKSPACE && !rockstar$aiInput.isEmpty()) {
                rockstar$aiInput = rockstar$aiInput.substring(0, rockstar$aiInput.length() - 1);
                return true;
            }
            if ((keyCode == GLFW.GLFW_KEY_ENTER || keyCode == GLFW.GLFW_KEY_KP_ENTER) && !rockstar$aiInput.trim().isEmpty() && !rockstar$aiThinking) {
                UISoundManager.playButtonClick();
                rockstar$sendAiPrompt(rockstar$aiInput.trim());
                rockstar$aiInput = "";
                return true;
            }
        }

        if (rockstar$notesEditing) {
            if (isCtrlDown) {
                if (keyCode == GLFW.GLFW_KEY_V) {
                    MinecraftClient mc = MinecraftClient.getInstance();
                    if (mc != null && mc.keyboard != null) {
                        String clip = mc.keyboard.getClipboard();
                        if (clip != null && !clip.isEmpty()) {
                            String cur = NotesManager.getQuickNote();
                            NotesManager.setQuickNote(cur + clip.replace("\r", ""));
                            return true;
                        }
                    }
                } else if (keyCode == GLFW.GLFW_KEY_C) {
                    MinecraftClient mc = MinecraftClient.getInstance();
                    if (mc != null && mc.keyboard != null) {
                        String cur = NotesManager.getQuickNote();
                        if (!cur.isEmpty()) {
                            mc.keyboard.setClipboard(cur);
                            return true;
                        }
                    }
                }
            }

            if (keyCode == GLFW.GLFW_KEY_BACKSPACE) {
                String cur = NotesManager.getQuickNote();
                if (!cur.isEmpty()) {
                    NotesManager.setQuickNote(cur.substring(0, cur.length() - 1));
                    return true;
                }
            }
            if (keyCode == GLFW.GLFW_KEY_ENTER || keyCode == GLFW.GLFW_KEY_KP_ENTER) {
                String cur = NotesManager.getQuickNote();
                NotesManager.setQuickNote(cur + "\n");
                return true;
            }
            if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
                rockstar$notesEditing = false;
                return true;
            }
        }

        return super.keyPressed(keyCode, scanCode, modifiers);
    }
}
