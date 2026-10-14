package moscow.rockstar.mixin.minecraft.client.gui.screen;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import dev.redstones.mediaplayerinfo.IMediaSession;
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
import rockstar.client.TargetEspModule;
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
    @Unique private static final float[] rockstar$dockBtnHover = new float[10];
    @Unique private static final float[] rockstar$actionBtnHover = new float[10];

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
    @Unique private static boolean rockstar$showCalcInCol4 = false;

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

        // Frosted dark blur & veil over in-game world
        custom.drawBlurredRect(0.0F, 0.0F, (float)this.width, (float)this.height, 14.0F, 3.0F, IIiii_Class8.I_method_893b2757(0.0F), new ColorRGBA(4.0F, 6.0F, 12.0F, 100.0F * rockstar$flyInAnim));
        custom.drawRect(0.0F, 0.0F, (float)this.width, (float)this.height, new ColorRGBA(6.0F, 8.0F, 16.0F, 115.0F * rockstar$flyInAnim));

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

        // ==========================================
        // LIQUID GLASS IOS CONTROL CENTER GRID (Exact Mockup)
        // Col 1 (58px): Coral Volume Pod (172px)
        // Col 2 (62px): Quick Toggles (TargetESP 82px / ClickGUI 82px)
        // Col 3 (180px): Apple Glass Calculator (172px)
        // Col 4 (200px): Media Player (82px) & Notes/Markers (82px)
        // Total Width: 58 + 8 + 62 + 8 + 180 + 8 + 200 = 524px!
        // ==========================================
        float mainTotalW = 524.0F;
        float gridStartX = cx - mainTotalW / 2.0F;
        float mainH = 172.0F;
        float cardH = (mainH - 8.0F) / 2.0F; // 82px
        float mainY = cy - 116.0F;
        float mainFlyY = (1.0F - rockstar$flyInAnim) * 32.0F;
        float colGap = 8.0F;
        float curX = gridStartX;
        float rowY = mainY + mainFlyY;

        // Top Status Bar (Weather & System RAM above grid)
        float topBarY = rowY - 44.0F;
        float topBarH = 36.0F;
        EscapeMenuConfig cfg = EscapeMenuConfig.getInstance();
        rockstar$renderWeatherCard(custom, gridStartX, topBarY, (mainTotalW - colGap) / 2.0F, topBarH, boldFont, font, subFont, tinyFont, mouseX, mouseY, 0.0F, cfg);
        rockstar$renderRamCard(custom, gridStartX + (mainTotalW - colGap) / 2.0F + colGap, topBarY, (mainTotalW - colGap) / 2.0F, topBarH, boldFont, font, subFont, tinyFont, mouseX, mouseY, 0.0F, now);

        // 1. Col 1: Red Volume Pill (58x172)
        float volW = 58.0F;
        boolean vHov = (mouseX >= curX && mouseX <= curX + volW && mouseY >= rowY && mouseY <= rowY + mainH);
        rockstar$tileHoverAnim[3] += ((vHov ? 1.0F : 0.0F) - rockstar$tileHoverAnim[3]) * 0.20F;
        float dVolY = rowY - rockstar$tileHoverAnim[3] * 2.5F;
        rockstar$renderVolumePod(custom, curX, dVolY, volW, mainH, boldFont, subFont, mouseX, mouseY, rockstar$tileHoverAnim[3]);
        curX += volW + colGap;

        // 2. Col 2: Two Squircle Cards (Blue TargetESP / Green ClickGUI) (62x172)
        float midW = 62.0F;
        boolean midHov = (mouseX >= curX && mouseX <= curX + midW && mouseY >= rowY && mouseY <= rowY + mainH);
        rockstar$tileHoverAnim[4] += ((midHov ? 1.0F : 0.0F) - rockstar$tileHoverAnim[4]) * 0.20F;
        float dMidY = rowY - rockstar$tileHoverAnim[4] * 2.5F;
        rockstar$renderCenterTiles(custom, curX, dMidY, midW, mainH, mouseX, mouseY);
        curX += midW + colGap;

        // 3. Col 3: Apple Glass Calculator (180x172)
        float col3W = 180.0F;
        rockstar$renderCalculatorCard(custom, curX, rowY, col3W, mainH, boldFont, font, mouseX, mouseY, 0.0F);
        curX += col3W + colGap;

        // 4. Col 4: Media Player (Top 82px) & Notes/Markers (Bottom 82px) (200x172)
        float col4W = 200.0F;
        rockstar$renderMediaCard(custom, curX, rowY, col4W, cardH, font, subFont, tinyFont, mouseX, mouseY, 0.0F, snap, tracker);
        rockstar$renderNotesCard(custom, curX, rowY + cardH + 8.0F, col4W, cardH, boldFont, font, subFont, tinyFont, mouseX, mouseY, 0.0F);

        // ==========================================
        // 3. VISIONOS HERO DOCK (4 Primary Action Pills: Resume | Options | Stats | Disconnect)
        // ==========================================
        float dockW = 524.0F;
        float dockH = 46.0F;
        float dockX = cx - dockW / 2.0F;
        float dockY = mainY + mainH + 14.0F + mainFlyY;
        IIiii_Class8 dockRad = IIiii_Class8.I_method_893b2757(dockH / 2.0F);

        // 1. Apple Glass Dock Container
        custom.drawShadow(dockX, dockY, dockW, dockH, 16.0F, dockRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 40.0F));
        custom.drawBlurredRect(dockX, dockY, dockW, dockH, 16.0F, 3.0F, dockRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 12.0F));
        custom.drawRoundedRect(dockX, dockY, dockW, dockH, dockRad, new ColorRGBA(14.0F, 18.0F, 28.0F, 105.0F));
        custom.drawRoundedBorder(dockX, dockY, dockW, dockH, 0.6F, dockRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 28.0F));

        // 2. The 4 Primary VisionOS Action Buttons:
        // [ ▶ Resume ] | [ ⚙ Options ] | [ 📊 Stats ] | [ ⏻ Disconnect ]
        String[] heroLabels = { "Resume", "Options", "Stats", "Disconnect" };
        String[] heroIcons = { "play", "setting", "stat", "back" };
        ColorRGBA[] heroColors = {
            new ColorRGBA(34.0F, 197.0F, 94.0F, 255.0F),  // Emerald Green
            new ColorRGBA(59.0F, 130.0F, 246.0F, 255.0F), // Royal Blue
            new ColorRGBA(168.0F, 85.0F, 247.0F, 255.0F), // Purple
            new ColorRGBA(239.0F, 68.0F, 68.0F, 255.0F)   // Crimson Red
        };

        float padX = 8.0F;
        float accSize = 30.0F;
        float accGap = 6.0F;

        // Accessory 1: AI Assistant (Left side)
        float aiX = dockX + padX;
        float aiY = dockY + (dockH - accSize) / 2.0F;
        boolean aiHov = (mouseX >= aiX && mouseX <= aiX + accSize && mouseY >= aiY && mouseY <= aiY + accSize);
        IIiii_Class8 accRad = IIiii_Class8.I_method_893b2757(accSize / 2.0F);
        custom.drawRoundedRect(aiX, aiY, accSize, accSize, accRad, aiHov ? theme.withAlpha(180.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));
        custom.drawRoundedBorder(aiX, aiY, accSize, accSize, 0.6F, accRad, aiHov ? theme : new ColorRGBA(255.0F, 255.0F, 255.0F, 30.0F));
        custom.drawIcon("logo", aiX + 7.0F, aiY + 7.0F, 16.0F, ColorRGBA.WHITE);

        // Accessory 2: Themes / Customizer (Right side)
        float custX = dockX + dockW - padX - accSize;
        float custY = aiY;
        boolean custHov = (mouseX >= custX && mouseX <= custX + accSize && mouseY >= custY && mouseY <= custY + accSize);
        custom.drawRoundedRect(custX, custY, accSize, accSize, accRad, custHov ? new ColorRGBA(168.0F, 85.0F, 247.0F, 180.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));
        custom.drawRoundedBorder(custX, custY, accSize, accSize, 0.6F, accRad, custHov ? new ColorRGBA(168.0F, 85.0F, 247.0F, 255.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 30.0F));
        custom.drawIcon("setting", custX + 7.0F, custY + 7.0F, 16.0F, ColorRGBA.WHITE);

        // 4 Hero Buttons between accessories
        float heroAreaStartX = aiX + accSize + accGap;
        float heroAreaEndX = custX - accGap;
        float heroAreaW = heroAreaEndX - heroAreaStartX;
        float heroGap = 6.0F;
        float heroBtnW = (heroAreaW - 3 * heroGap) / 4.0F;
        float heroBtnH = 32.0F;
        float heroBtnY = dockY + (dockH - heroBtnH) / 2.0F;
        IIiii_Class8 heroBtnRad = IIiii_Class8.I_method_893b2757(heroBtnH / 2.0F);

        boolean isMouseDown = org.lwjgl.glfw.GLFW.glfwGetMouseButton(MinecraftClient.getInstance().getWindow().getHandle(), 0) == 1;

        for (int i = 0; i < 4; i++) {
            float bx = heroAreaStartX + i * (heroBtnW + heroGap);
            boolean isHov = (mouseX >= bx && mouseX <= bx + heroBtnW && mouseY >= heroBtnY && mouseY <= heroBtnY + heroBtnH);
            rockstar$actionBtnHover[i] += ((isHov ? 1.0F : 0.0F) - rockstar$actionBtnHover[i]) * 0.24F;
            float hA = rockstar$actionBtnHover[i];
            boolean pressed = isHov && isMouseDown;
            float scale = 1.0F + 0.06F * hA - (pressed ? 0.04F : 0.0F);

            if (hA > 0.01F) {
                custom.drawShadow(bx, heroBtnY, heroBtnW, heroBtnH, 10.0F, heroBtnRad, heroColors[i].withAlpha(90.0F * hA));
            }

            ColorRGBA bg = hA > 0.01F
                ? heroColors[i].withAlpha(pressed ? 240.0F : (90.0F + 120.0F * hA))
                : new ColorRGBA(255.0F, 255.0F, 255.0F, 16.0F);
            custom.drawRoundedRect(bx, heroBtnY, heroBtnW, heroBtnH, heroBtnRad, bg);
            custom.drawRoundedBorder(bx, heroBtnY, heroBtnW, heroBtnH, 0.7F, heroBtnRad, hA > 0.01F ? heroColors[i].withAlpha(190.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));

            // Icon + Label centered
            float iconSz = 14.0F;
            float textW = font != null ? font.I_method_2c375926(heroLabels[i]) : 50.0F;
            float contentW = iconSz + 5.0F + textW;
            float contentStartX = bx + (heroBtnW - contentW) / 2.0F;

            custom.drawIcon(heroIcons[i], contentStartX, heroBtnY + (heroBtnH - iconSz) / 2.0F, iconSz, ColorRGBA.WHITE);
            if (font != null) {
                custom.drawText(font, heroLabels[i], contentStartX + iconSz + 5.0F, heroBtnY + 11.0F, ColorRGBA.WHITE);
            }
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

    
    // Standalone Snake Game Widget Card (Launch minigame)
    @Unique
    private void rockstar$renderSnakeCard(III custom, float x, float y, float w, float h, IIiIIi_Class10 boldFont, IIiIIi_Class10 font, IIiIIi_Class10 subFont, IIiIIi_Class10 tinyFont, int mx, int my, float hoverA) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(12.0F);
        boolean hov = mx >= x && mx <= x + w && my >= y && my <= y + h;
        ColorRGBA greenAccent = new ColorRGBA(34.0F, 197.0F, 94.0F, 255.0F);

        custom.drawShadow(x, y, w, h, 10.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 30.0F));
        custom.drawBlurredRect(x, y, w, h, 14.0F, 3.0F, rad, new ColorRGBA(34.0F, 197.0F, 94.0F, 10.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(14.0F, 20.0F, 22.0F, 95.0F));
        custom.drawRoundedBorder(x, y, w, h, 0.6F, rad, hov ? greenAccent.withAlpha(140.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));

        if (subFont != null) {
            custom.drawText(subFont, "🐍 Змейка", x + 8.0F, y + 8.0F, ColorRGBA.WHITE);
        }
        if (tinyFont != null) {
            custom.drawText(tinyFont, "Рекорд: " + SnakeScreen.getHighScore(), x + 8.0F, y + 26.0F, new ColorRGBA(180.0F, 220.0F, 190.0F, 200.0F));
        }

        float btnH = 18.0F;
        float btnW = w - 16.0F;
        float btnX = x + 8.0F;
        float btnY = y + h - btnH - 8.0F;
        IIiii_Class8 bRad = IIiii_Class8.I_method_893b2757(btnH / 2.0F);
        boolean bHov = mx >= btnX && mx <= btnX + btnW && my >= btnY && my <= btnY + btnH;
        custom.drawRoundedRect(btnX, btnY, btnW, btnH, bRad, bHov ? greenAccent.withAlpha(220.0F) : greenAccent.withAlpha(160.0F));
        custom.drawRoundedBorder(btnX, btnY, btnW, btnH, 0.5F, bRad, ColorRGBA.WHITE.withAlpha(80.0F));
        if (tinyFont != null) {
            float tw = tinyFont.I_method_2c375926("▶ Играть");
            custom.drawText(tinyFont, "▶ Играть", btnX + (btnW - tw) / 2.0F, btnY + 5.0F, ColorRGBA.WHITE);
        }
    }

    // Standalone AI Assistant Card
    @Unique
    private void rockstar$renderAiCard(III custom, float x, float y, float w, float h, IIiIIi_Class10 boldFont, IIiIIi_Class10 font, IIiIIi_Class10 subFont, IIiIIi_Class10 tinyFont, int mx, int my, float hoverA) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(12.0F);
        boolean hov = mx >= x && mx <= x + w && my >= y && my <= y + h;
        ColorRGBA purpleAccent = new ColorRGBA(168.0F, 85.0F, 247.0F, 255.0F);

        custom.drawShadow(x, y, w, h, 12.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 30.0F));
        custom.drawBlurredRect(x, y, w, h, 14.0F, 3.0F, rad, new ColorRGBA(168.0F, 85.0F, 247.0F, 12.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(20.0F, 16.0F, 30.0F, 95.0F));
        custom.drawRoundedBorder(x, y, w, h, 0.6F, rad, hov ? purpleAccent.withAlpha(160.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));

        custom.drawIcon("logo", x + 10.0F, y + 9.0F, 14.0F, purpleAccent);
        if (subFont != null) {
            custom.drawText(subFont, "Agravity AI", x + 28.0F, y + 8.5F, ColorRGBA.WHITE);
        }
        custom.drawRoundedRect(x + w - 16.0F, y + 11.0F, 5.0F, 5.0F, IIiii_Class8.I_method_893b2757(2.5F), new ColorRGBA(74.0F, 222.0F, 128.0F, 240.0F));

        if (font != null) {
            custom.drawText(font, rockstar$aiThinking ? "AI думает..." : "Спроси меня о чём угодно", x + 10.0F, y + 27.0F, new ColorRGBA(220.0F, 225.0F, 240.0F, 220.0F));
        }

        float pillW = w - 20.0F;
        float pillH = 18.0F;
        float pillX = x + 10.0F;
        float pillY = y + h - pillH - 8.0F;
        IIiii_Class8 pRad = IIiii_Class8.I_method_893b2757(pillH / 2.0F);
        boolean pHov = mx >= pillX && mx <= pillX + pillW && my >= pillY && my <= pillY + pillH;
        custom.drawRoundedRect(pillX, pillY, pillW, pillH, pRad, pHov ? purpleAccent.withAlpha(200.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F));
        custom.drawRoundedBorder(pillX, pillY, pillW, pillH, 0.5F, pRad, pHov ? purpleAccent : new ColorRGBA(255.0F, 255.0F, 255.0F, 30.0F));
        if (tinyFont != null) {
            float tw = tinyFont.I_method_2c375926("Открыть чат 💬");
            custom.drawText(tinyFont, "Открыть чат 💬", pillX + (pillW - tw) / 2.0F, pillY + 5.0F, ColorRGBA.WHITE);
        }
    }

    // Module 0: Real Browser Media Player Card
    @Unique
    private void rockstar$renderMediaCard(III custom, float x, float y, float w, float h, IIiIIi_Class10 font, IIiIIi_Class10 subFont, IIiIIi_Class10 tinyFont, int mx, int my, float hoverA, @Nullable iiIiIIIiI_Class419.Nested1_a961800 snap, @Nullable iiIiIIIiI_Class419 tracker) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(12.0F);
        ColorRGBA theme = IiiiiIIIi_Class242.I_method_7df8e08e();
        custom.drawShadow(x, y, w, h, 12.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 40.0F));
        custom.drawBlurredRect(x, y, w, h, 14.0F, 3.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 10.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(14.0F, 18.0F, 28.0F, 95.0F));
        custom.drawRoundedBorder(x, y, w, h, 0.6F, rad, hoverA > 0.01F ? theme.withAlpha(110.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));

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
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(14.0F, 18.0F, 30.0F, 95.0F));
        custom.drawRoundedBorder(x, y, w, h, 0.6F, rad, hoverA > 0.01F ? new ColorRGBA(59.0F, 130.0F, 246.0F, 110.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));

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

    // Middle Column: Two Squircle Cards (Top: Blue TargetESP / Bottom: Green ClickGUI) - media_1791820306003.png
    @Unique
    private void rockstar$renderCenterTiles(III custom, float x, float y, float w, float h, int mx, int my) {
        float tileH = (h - 8.0F) / 2.0F;
        IIiii_Class8 cardRad = IIiii_Class8.I_method_893b2757(18.0F);

        // --- Top Card: TargetESP / TargetHUD Quick Toggle ---
        float topY = y;
        boolean topHov = mx >= x && mx <= x + w && my >= topY && my <= topY + tileH;
        custom.drawShadow(x, topY, w, tileH, 12.0F, cardRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 45.0F));
        custom.drawBlurredRect(x, topY, w, tileH, 14.0F, 3.0F, cardRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 10.0F));
        custom.drawRoundedRect(x, topY, w, tileH, cardRad, new ColorRGBA(14.0F, 18.0F, 28.0F, 95.0F));
        custom.drawRoundedBorder(x, topY, w, tileH, 0.6F, cardRad, topHov ? new ColorRGBA(29.0F, 100.0F, 236.0F, 160.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));

        // Centered Royal Blue Squircle Button (42x42px, radius 13px)
        float btnSz = 42.0F;
        float bx = x + (w - btnSz) / 2.0F;
        float by = topY + (tileH - btnSz) / 2.0F;
        IIiii_Class8 bRad = IIiii_Class8.I_method_893b2757(13.0F);
        custom.drawShadow(bx, by, btnSz, btnSz, 8.0F, bRad, new ColorRGBA(29.0F, 100.0F, 236.0F, 120.0F));
        custom.drawRoundedRect(bx, by, btnSz, btnSz, bRad, new ColorRGBA(29.0F, 100.0F, 236.0F, topHov ? 255.0F : 230.0F));
        custom.drawRoundedBorder(bx, by, btnSz, btnSz, 0.6F, bRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 60.0F));
        custom.drawIcon("hud/target", bx + (btnSz - 20.0F) / 2.0F, by + (btnSz - 20.0F) / 2.0F, 20.0F, ColorRGBA.WHITE);

        // --- Bottom Card: ClickGUI / Controls Quick Toggle ---
        float botY = topY + tileH + 8.0F;
        boolean botHov = mx >= x && mx <= x + w && my >= botY && my <= botY + tileH;
        custom.drawShadow(x, botY, w, tileH, 12.0F, cardRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 45.0F));
        custom.drawBlurredRect(x, botY, w, tileH, 14.0F, 3.0F, cardRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 10.0F));
        custom.drawRoundedRect(x, botY, w, tileH, cardRad, new ColorRGBA(14.0F, 18.0F, 28.0F, 95.0F));
        custom.drawRoundedBorder(x, botY, w, tileH, 0.6F, cardRad, botHov ? new ColorRGBA(22.0F, 163.0F, 74.0F, 160.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));

        // Centered Emerald Green Squircle Button (42x42px, radius 13px)
        float bby = botY + (tileH - btnSz) / 2.0F;
        custom.drawShadow(bx, bby, btnSz, btnSz, 8.0F, bRad, new ColorRGBA(22.0F, 163.0F, 74.0F, 120.0F));
        custom.drawRoundedRect(bx, bby, btnSz, btnSz, bRad, new ColorRGBA(22.0F, 163.0F, 74.0F, botHov ? 255.0F : 230.0F));
        custom.drawRoundedBorder(bx, bby, btnSz, btnSz, 0.6F, bRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 60.0F));
        custom.drawIcon("keyboard", bx + (btnSz - 20.0F) / 2.0F, bby + (btnSz - 20.0F) / 2.0F, 20.0F, ColorRGBA.WHITE);
    }

    // Module 5: Standalone Solid Coral-Red Apple Capsule Volume Pod (Exact media_1791820306003.png)
    @Unique
    private void rockstar$renderVolumePod(III custom, float x, float y, float w, float h, IIiIIi_Class10 boldFont, IIiIIi_Class10 subFont, int mx, int my, float hoverA) {
        float currentVol = (float)MinecraftClient.getInstance().options.getSoundVolume(SoundCategory.MASTER);
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(w / 2.0F); // Full pill (radius 31px)

        // 1. Soft atmospheric drop shadow
        custom.drawShadow(x, y, w, h, 14.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 40.0F));

        // 2. Base Dark Frosted Capsule (unfilled portion)
        custom.drawBlurredRect(x, y, w, h, 14.0F, 3.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 10.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(18.0F, 22.0F, 30.0F, 95.0F));

        // 3. Solid Coral-Red Volume Fill (from bottom up)
        float fillH = MathHelper.clamp(h * currentVol, 0.0F, h);
        if (fillH > 2.0F) {
            float fillY = y + h - fillH;
            custom.drawRoundedRect(x, fillY, w, fillH, rad, new ColorRGBA(225.0F, 50.0F, 58.0F, 220.0F));
            // line artifact removed
        }

        // 4. Subtle Outer Border
        custom.drawRoundedBorder(x, y, w, h, 0.7F, rad, (hoverA > 0.01F || rockstar$isDraggingVolume) ? new ColorRGBA(255.0F, 120.0F, 120.0F, 160.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));

        // 5. Top Percentage Text (Dark text as in media_1791820306003.png)
        String pctStr = (int)(currentVol * 100.0F) + "%";
        if (boldFont != null) {
            float tw = boldFont.I_method_2c375926(pctStr);
            ColorRGBA textCol = (currentVol > 0.85F) ? new ColorRGBA(28.0F, 14.0F, 16.0F, 240.0F) : ColorRGBA.WHITE;
            custom.drawText(boldFont, pctStr, x + (w - tw) / 2.0F, y + 14.0F, textCol);
        }

        // 6. Bottom White Music Note Icon (♪)
        custom.drawIcon("music", x + (w - 18.0F) / 2.0F, y + h - 28.0F, 18.0F, ColorRGBA.WHITE);
    }

    // Module 6: Apple Glass Calculator (.calc glass matching HTML mockup)
    @Unique
    private void rockstar$renderCalculatorCard(III custom, float x, float y, float w, float h, IIiIIi_Class10 boldFont, IIiIIi_Class10 font, int mx, int my, float hoverA) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(16.0F);
        ColorRGBA theme = IiiiiIIIi_Class242.I_method_7df8e08e();

        // 1. Apple Glass Container (.calc glass)
        custom.drawShadow(x, y, w, h, 14.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 45.0F));
        custom.drawBlurredRect(x, y, w, h, 16.0F, 3.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 10.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(14.0F, 18.0F, 28.0F, 95.0F));
        custom.drawRoundedBorder(x, y, w, h, 0.6F, rad, hoverA > 0.01F ? theme.withAlpha(120.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));

        // 2. Direct Display at Top-Right (as in media_1791820306003.png)
        String disp = rockstar$calcDisplay;
        if (disp.length() > 14) disp = disp.substring(0, 14);
        if (boldFont != null) {
            float tw = boldFont.I_method_2c375926(disp);
            custom.drawText(boldFont, disp, x + w - tw - 16.0F, y + 14.0F, ColorRGBA.WHITE);
        }

        // 3. Circular Button Grid (Exact media_1791820306003.png) — 4 columns x 5 rows of perfect circles
        float padX = 14.0F;
        float gap = 6.0F;
        float btnSz = 25.5F;
        float gridStartY = y + 36.0F;
        IIiii_Class8 btnRad = IIiii_Class8.I_method_893b2757(btnSz / 2.0F);

        boolean isMouseDown = org.lwjgl.glfw.GLFW.glfwGetMouseButton(MinecraftClient.getInstance().getWindow().getHandle(), 0) == 1;

        String[][] btnGrid = new String[][]{
            { "C", "+/-", "%", "÷" },
            { "7", "8", "9", "×" },
            { "4", "5", "6", "-" },
            { "1", "2", "3", "+" },
            { "0", "", ".", "=" }
        };

        for (int r = 0; r < 5; r++) {
            float rowY = gridStartY + r * (btnSz + gap);
            for (int c = 0; c < 4; c++) {
                String label = btnGrid[r][c];
                if (label.isEmpty()) continue; // Gap in row 5 under 8

                float bX = x + padX + c * (btnSz + gap + 3.0F);
                boolean bHov = mx >= bX && mx <= bX + btnSz && my >= rowY && my <= rowY + btnSz;
                boolean pressed = bHov && isMouseDown;
                float drawY = rowY + (pressed ? 1.0F : 0.0F);

                ColorRGBA bg;
                ColorRGBA border;
                ColorRGBA fg = ColorRGBA.WHITE;

                if (r == 0 && c < 3) {
                    // Function buttons (C, +/-, %): light grey circles (.calc-btn.fn)
                    bg = new ColorRGBA(210.0F, 215.0F, 225.0F, bHov ? 180.0F : 130.0F);
                    border = new ColorRGBA(255.0F, 255.0F, 255.0F, 60.0F);
                    fg = new ColorRGBA(20.0F, 24.0F, 35.0F, 255.0F);
                } else if (c == 3) {
                    // Operator buttons (÷, ×, -, +, =): vibrant amber/orange circles (.calc-btn.op)
                    bg = new ColorRGBA(245.0F, 158.0F, 11.0F, bHov ? 255.0F : 225.0F);
                    border = new ColorRGBA(255.0F, 200.0F, 80.0F, 180.0F);
                } else {
                    // Number buttons: frosted dark circles (.calc-btn)
                    bg = new ColorRGBA(255.0F, 255.0F, 255.0F, bHov ? 60.0F : 28.0F);
                    border = new ColorRGBA(255.0F, 255.0F, 255.0F, bHov ? 70.0F : 25.0F);
                }

                if (bHov) {
                    custom.drawShadow(bX, drawY, btnSz, btnSz, 8.0F, btnRad, bg.withAlpha(90.0F));
                }
                custom.drawRoundedRect(bX, drawY, btnSz, btnSz, btnRad, bg);
                custom.drawRoundedBorder(bX, drawY, btnSz, btnSz, 0.7F, btnRad, border);


                if (font != null) {
                    float lw = font.I_method_2c375926(label);
                    custom.drawText(font, label, bX + (btnSz - lw) / 2.0F, drawY + (btnSz - 7.5F) / 2.0F, fg);
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
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(16.0F, 18.0F, 28.0F, 95.0F));
        custom.drawRoundedBorder(x, y, w, h, 0.6F, rad, rockstar$notesEditing ? new ColorRGBA(245.0F, 158.0F, 11.0F, 180.0F) : (hoverA > 0.01F ? theme.withAlpha(90.0F * hoverA) : new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F)));

        // Header Title: 📝 Notes
        float headerY = y + 7.0F;
        if (font != null) {
            custom.drawText(font, "📝 Notes", x + 10.0F, headerY + 1.0F, ColorRGBA.WHITE);
        }

        // Action button 1: [+ Marker]
        float btnMarkerW = 46.0F;
        float btnMarkerH = 15.0F;
        float btnMarkerX = x + w - btnMarkerW - 8.0F;
        float btnMarkerY = headerY;
        boolean markerHov = (mx >= btnMarkerX && mx <= btnMarkerX + btnMarkerW && my >= btnMarkerY && my <= btnMarkerY + btnMarkerH);
        IIiii_Class8 bRad = IIiii_Class8.I_method_893b2757(4.0F);
        custom.drawRoundedRect(btnMarkerX, btnMarkerY, btnMarkerW, btnMarkerH, bRad, markerHov ? new ColorRGBA(59.0F, 130.0F, 246.0F, 220.0F) : new ColorRGBA(59.0F, 130.0F, 246.0F, 140.0F));
        if (tinyFont != null) {
            float tw = tinyFont.I_method_2c375926("+ Marker");
            custom.drawText(tinyFont, "+ Marker", btnMarkerX + (btnMarkerW - tw) / 2.0F, btnMarkerY + (btnMarkerH - 6.5F) / 2.0F, ColorRGBA.WHITE);
        }

        // Action button 2: [+ Coords]
        float btnCoordW = 46.0F;
        float btnCoordX = btnMarkerX - btnCoordW - 4.0F;
        boolean coordHov = (mx >= btnCoordX && mx <= btnCoordX + btnCoordW && my >= btnMarkerY && my <= btnMarkerY + btnMarkerH);
        custom.drawRoundedRect(btnCoordX, btnMarkerY, btnCoordW, btnMarkerH, bRad, coordHov ? new ColorRGBA(16.0F, 185.0F, 129.0F, 220.0F) : new ColorRGBA(16.0F, 185.0F, 129.0F, 140.0F));
        if (tinyFont != null) {
            float tw = tinyFont.I_method_2c375926("+ Coords");
            custom.drawText(tinyFont, "+ Coords", btnCoordX + (btnCoordW - tw) / 2.0F, btnMarkerY + (btnMarkerH - 6.5F) / 2.0F, ColorRGBA.WHITE);
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
                custom.drawText(subFont, "Click to write notes...", textPadX + 6.0F, textPadY + 4.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 80.0F));
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
                String tip = "Ask any question about Minecraft,\nPvP, or Agravity Client:";
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
            String promptDisp = rockstar$aiInput.isEmpty() ? "Ask AI..." : rockstar$aiInput;
            if (System.currentTimeMillis() % 1000L < 500L && !rockstar$aiInput.isEmpty()) promptDisp += "|";
            ColorRGBA col = rockstar$aiInput.isEmpty() ? new ColorRGBA(255.0F, 255.0F, 255.0F, 110.0F) : ColorRGBA.WHITE;
            custom.drawText(subFont, promptDisp, inX + 10.0F, inY + 8.0F, col);
        }

        // Send Button [Send]
        float sendX = inX + inW + 6.0F;
        boolean sendHov = (mx >= sendX && mx <= sendX + sendW && my >= inY && my <= inY + inH);
        custom.drawRoundedRect(sendX, inY, sendW, inH, inRad, sendHov ? theme.withAlpha(235.0F) : theme.withAlpha(190.0F));
        custom.drawRoundedBorder(sendX, inY, sendW, inH, 0.5F, inRad, ColorRGBA.WHITE.withAlpha(sendHov ? 90.0F : 30.0F));
        if (tinyFont != null) {
            float sendTxtW = tinyFont.I_method_2c375926("Send");
            custom.drawText(tinyFont, "Send", sendX + (sendW - sendTxtW) / 2.0F, inY + 8.0F, ColorRGBA.WHITE);
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

        // 2. Main Content Row Widget Clicks (iOS Control Center Grid):
        float mainTotalW = 524.0F;
        float gridStartX = cx - mainTotalW / 2.0F;
        float mainY = cy - 116.0F;
        float mainH = 172.0F;
        float cardH = (mainH - 8.0F) / 2.0F;
        float colGap = 8.0F;

        // Top Status Bar (Weather & System RAM above grid)
        float topBarY = mainY - 44.0F;
        float topBarH = 36.0F;
        float halfTopW = (mainTotalW - colGap) / 2.0F;
        if (mouseY >= topBarY && mouseY <= topBarY + topBarH) {
            if (mouseX >= gridStartX && mouseX <= gridStartX + halfTopW) {
                // Weather card click: cycle scope
                cfg.cycleScope();
                UISoundManager.playButtonClick();
                return true;
            } else if (mouseX >= gridStartX + halfTopW + colGap && mouseX <= gridStartX + mainTotalW) {
                // RAM card click: run system gc
                System.gc();
                rockstar$ramGcFeedbackTimer = System.currentTimeMillis();
                UISoundManager.playButtonClick();
                return true;
            }
        }

        // 1. Col 1: Red Volume Pill (58x172)
        float curX = gridStartX;
        float volW = 58.0F;
        if (mouseX >= curX && mouseX <= curX + volW && mouseY >= mainY && mouseY <= mainY + mainH) {
            rockstar$isDraggingVolume = true;
            rockstar$updateVolume(mouseY, mainY, mainH);
            return true;
        }
        curX += volW + colGap;

        // 2. Col 2: Two Squircle Cards (62x172)
        float midW = 62.0F;
        float tileH = (mainH - 8.0F) / 2.0F;
        if (mouseX >= curX && mouseX <= curX + midW) {
            // Top card: TargetESP
            if (mouseY >= mainY && mouseY <= mainY + tileH) {
                TargetEspModule esp = RockstarClient.getInstance().getModuleManager().getModule(TargetEspModule.class);
                if (esp != null) {
                    esp.toggle();
                }
                UISoundManager.playButtonClick();
                return true;
            }
            // Bottom card: ClickGUI
            float botY = mainY + tileH + 8.0F;
            if (mouseY >= botY && mouseY <= botY + tileH) {
                UISoundManager.playButtonClick();
                if (this.client != null) {
                    this.client.setScreen(new rockstar.client.IiiIiIiiI_Class215());
                }
                return true;
            }
        }
        curX += midW + colGap;

        // 3. Col 3: Apple Glass Calculator (180x172)
        float col3W = 180.0F;
        if (mouseX >= curX && mouseX <= curX + col3W && mouseY >= mainY && mouseY <= mainY + mainH) {
            if (rockstar$handleCalcClick(mouseX, mouseY, curX, mainY, col3W, mainH)) {
                return true;
            }
        }
        curX += col3W + colGap;

        // 4. Col 4: Media Player (Top 82px) & Notes/Markers (Bottom 82px) (200x172)
        float col4W = 200.0F;
        if (mouseX >= curX && mouseX <= curX + col4W) {
            // Top: Media player controls
            if (mouseY >= mainY && mouseY <= mainY + cardH) {
                iiIiIIIiI_Class419 tr = RockstarClient.getInstance().I_method_be969482();
                if (tr != null) {
                    IMediaSession session = tr.I_method_9b92c97b();
                    if (session != null) {
                        float ctrlY = mainY + 57.0F;
                        if (mouseY >= ctrlY - 4.0F && mouseY <= ctrlY + 14.0F) {
                            if (mouseX >= curX + 10.0F && mouseX <= curX + 32.0F) {
                                session.previous();
                                UISoundManager.playButtonClick();
                                return true;
                            }
                            if (mouseX >= curX + col4W / 2.0F - 14.0F && mouseX <= curX + col4W / 2.0F + 14.0F) {
                                session.playPause();
                                UISoundManager.playButtonClick();
                                return true;
                            }
                            if (mouseX >= curX + col4W - 32.0F && mouseX <= curX + col4W - 10.0F) {
                                session.next();
                                UISoundManager.playButtonClick();
                                return true;
                            }
                        }
                    }
                }
                return true;
            }
            // Bottom: Notes & Markers
            float botY = mainY + cardH + 8.0F;
            if (mouseY >= botY && mouseY <= botY + cardH) {
                float headerY = botY + 7.0F;
                float btnMarkerW = 46.0F;
                float btnMarkerH = 15.0F;
                float btnMarkerX = curX + col4W - btnMarkerW - 8.0F;
                if (mouseX >= btnMarkerX && mouseX <= btnMarkerX + btnMarkerW && mouseY >= headerY && mouseY <= headerY + btnMarkerH) {
                    UISoundManager.playButtonClick();
                    rockstar$addPlayerMarker();
                    return true;
                }
                float btnCoordW = 46.0F;
                float btnCoordX = btnMarkerX - btnCoordW - 4.0F;
                if (mouseX >= btnCoordX && mouseX <= btnCoordX + btnCoordW && mouseY >= headerY && mouseY <= headerY + btnMarkerH) {
                    UISoundManager.playButtonClick();
                    rockstar$insertCoordinatesToActiveNote();
                    return true;
                }

                // 1-Click Delete on Marker Chips
                List<NotesManager.Marker> markers = NotesManager.getMarkers();
                if (!markers.isEmpty()) {
                    float divY = botY + 26.0F;
                    float chipH = 15.0F;
                    float chipY = divY + 4.0F;
                    float maxShow = Math.min(3, markers.size());
                    float chipGap = 3.0F;
                    float chipW = (col4W - 20.0F - (maxShow - 1) * chipGap) / maxShow;
                    if (mouseY >= chipY && mouseY <= chipY + chipH) {
                        for (int mi = 0; mi < maxShow; mi++) {
                            float chipX = curX + 10.0F + mi * (chipW + chipGap);
                            float delSz = 11.0F;
                            float delX = chipX + chipW - delSz - 2.0F;
                            float delY = chipY + (chipH - delSz) / 2.0F;
                            if (mouseX >= delX && mouseX <= delX + delSz && mouseY >= delY && mouseY <= delY + delSz) {
                                NotesManager.deleteMarker(markers.get(mi).id);
                                UISoundManager.playButtonClick();
                                return true;
                            }
                        }
                    }
                }

                rockstar$notesEditing = true;
                UISoundManager.playButtonClick();
                return true;
            }
        }

        // 5. VisionOS Hero Dock Clicks (4 Primary Actions + Accessories)
        float dockW = 524.0F;
        float dockH = 46.0F;
        float dockX = cx - dockW / 2.0F;
        float dockY = mainY + mainH + 14.0F;
        float padX = 8.0F;
        float accSize = 30.0F;
        float accGap = 6.0F;

        if (mouseY >= dockY && mouseY <= dockY + dockH) {
            // Left accessory (AI Assistant)
            float aiX = dockX + padX;
            if (mouseX >= aiX && mouseX <= aiX + accSize) {
                rockstar$aiDrawerOpen = !rockstar$aiDrawerOpen;
                UISoundManager.playButtonClick();
                return true;
            }

            // Right accessory (Themes/Wallpapers)
            float custX = dockX + dockW - padX - accSize;
            if (mouseX >= custX && mouseX <= custX + accSize) {
                UISoundManager.playButtonClick();
                if (button == 1) {
                    rockstar.client.ThemeAndBackgroundManager.getInstance().nextBackground();
                } else {
                    rockstar.client.ThemeAndBackgroundManager.getInstance().nextTheme();
                }
                return true;
            }

            // 4 Hero Action Buttons: [Resume] [Options] [Stats] [Disconnect]
            float heroAreaStartX = aiX + accSize + accGap;
            float heroAreaEndX = custX - accGap;
            float heroAreaW = heroAreaEndX - heroAreaStartX;
            float heroGap = 6.0F;
            float heroBtnW = (heroAreaW - 3 * heroGap) / 4.0F;
            float heroBtnH = 32.0F;
            float heroBtnY = dockY + (dockH - heroBtnH) / 2.0F;

            for (int i = 0; i < 4; i++) {
                float bx = heroAreaStartX + i * (heroBtnW + heroGap);
                if (mouseX >= bx && mouseX <= bx + heroBtnW && mouseY >= heroBtnY && mouseY <= heroBtnY + heroBtnH) {
                    UISoundManager.playButtonClick();
                    switch (i) {
                        case 0 -> this.close(); // Resume
                        case 1 -> { // Options
                            if (this.client != null) this.client.setScreen(new OptionsScreen(this, this.client.options));
                        }
                        case 2 -> { // Stats
                            if (this.client != null && this.client.player != null) {
                                this.client.setScreen(new net.minecraft.client.gui.screen.StatsScreen(this, this.client.player.getStatHandler()));
                            }
                        }
                        case 3 -> {
                            if (this.client != null) {
                                this.client.setScreen(null);
                            }
                            this.disconnect();
                        }
                    }
                    return true;
                }
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        if (rockstar$isDraggingVolume) {
            float cy = this.height / 2.0F;
            float mainY = cy - 116.0F;
            float mainH = 172.0F;
            rockstar$updateVolume(mouseY, mainY, mainH);
            return true;
        }

        return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        rockstar$isDraggingVolume = false;
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Unique
    private static void rockstar$updateVolume(double mouseY, float mainY, float mainH) {
        float rel = 1.0F - (float)((mouseY - (mainY + 12.0F)) / (mainH - 24.0F));
        float newVol = MathHelper.clamp(rel, 0.0F, 1.0F);
        if (MinecraftClient.getInstance() != null) {
            MinecraftClient.getInstance().options.getSoundVolumeOption(SoundCategory.MASTER).setValue((double)newVol);
        }
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
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        if (rockstar$aiDrawerOpen) {
            rockstar$aiScroll = Math.max(0.0F, rockstar$aiScroll - (float)verticalAmount * 18.0F);
            return true;
        }
        return super.mouseScrolled(mouseX, mouseY, horizontalAmount, verticalAmount);
    }

    @Unique
    private static boolean rockstar$handleCalcClick(double mx, double my, float x, float y, float w, float h) {
        float padX = 14.0F;
        float gap = 6.0F;
        float btnSz = 25.5F;
        float gridStartY = y + 36.0F;

        String[][] btnGrid = new String[][]{
            { "C", "+/-", "%", "÷" },
            { "7", "8", "9", "×" },
            { "4", "5", "6", "-" },
            { "1", "2", "3", "+" },
            { "0", "", ".", "=" }
        };

        for (int r = 0; r < 5; r++) {
            float rowY = gridStartY + r * (btnSz + gap);
            for (int c = 0; c < 4; c++) {
                String label = btnGrid[r][c];
                if (label.isEmpty()) continue;

                float bX = x + padX + c * (btnSz + gap + 3.0F);
                if (mx >= bX && mx <= bX + btnSz && my >= rowY && my <= rowY + btnSz) {
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
