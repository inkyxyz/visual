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
import rockstar.client.AIAssistantScreen;
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
import rockstar.client.NotesScreen;
import rockstar.client.RockstarClient;
import rockstar.client.SnakeScreen;
import rockstar.client.UISoundManager;
import rockstar.client.WeatherAlertModule;
import rockstar.client.iIIIiiIii_Class284;
import rockstar.client.iIIIiiiII_Class285;
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

    // Per-tile hover float animations
    @Unique private static final float[] rockstar$tileHoverAnim = new float[8];
    @Unique private static final float[] rockstar$dockBtnHover = new float[4];
    @Unique private static final float[] rockstar$actionBtnHover = new float[4];

    // Smooth Entrance Fly-in animation
    @Unique private static float rockstar$flyInAnim = 0.0F;

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

        // Update entrance fly-in animation lerp
        rockstar$flyInAnim += (1.0F - rockstar$flyInAnim) * 0.18F;

        // Update slide-in AI drawer animation lerp
        float targetDrawer = rockstar$aiDrawerOpen ? 1.0F : 0.0F;
        rockstar$aiDrawerAnim += (targetDrawer - rockstar$aiDrawerAnim) * 0.22F;

        // Dark frosted backdrop with Liquid Glass tint
        custom.drawRect(0.0F, 0.0F, (float)this.width, (float)this.height, new ColorRGBA(8.0F, 12.0F, 20.0F, 135.0F));

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
        // 1. TOP ROW: 3 SEPARATE MODULAR IOS WIDGETS
        // Media (116x74) | Weather (116x74) | Drone Threat Radar (116x74)
        // ==========================================
        float topStartX = cx - 180.0F;
        float topY = cy - 138.0F;
        float topW = 116.0F;
        float topH = 74.0F;
        float topGap = 6.0F;

        // Fly-in offset for Top Row
        float topFlyY = (1.0F - rockstar$flyInAnim) * 26.0F;

        // 0: Media Card
        if (cfg.showMediaPlayer) {
            float mX = topStartX;
            float mY = topY + topFlyY;
            boolean mHov = (mouseX >= mX && mouseX <= mX + topW && mouseY >= mY && mouseY <= mY + topH);
            rockstar$tileHoverAnim[0] += ((mHov ? 1.0F : 0.0F) - rockstar$tileHoverAnim[0]) * 0.20F;
            float dY = mY - rockstar$tileHoverAnim[0] * 3.5F;
            rockstar$renderMediaCard(custom, mX, dY, topW, topH, font, subFont, tinyFont, mouseX, mouseY, rockstar$tileHoverAnim[0], snap, tracker);
        }

        // 1: Separate iOS Weather Widget Card
        if (cfg.showWeatherAlerts) {
            float wX = topStartX + topW + topGap;
            float wY = topY + topFlyY;
            boolean wHov = (mouseX >= wX && mouseX <= wX + topW && mouseY >= wY && mouseY <= wY + topH);
            rockstar$tileHoverAnim[1] += ((wHov ? 1.0F : 0.0F) - rockstar$tileHoverAnim[1]) * 0.20F;
            float dY = wY - rockstar$tileHoverAnim[1] * 3.5F;
            rockstar$renderWeatherCard(custom, wX, dY, topW, topH, boldFont, font, subFont, tinyFont, mouseX, mouseY, rockstar$tileHoverAnim[1], cfg);
        }

        // 2: Separate iOS Drone Threat Radar Card
        if (cfg.showWeatherAlerts) {
            float rX = topStartX + (topW + topGap) * 2.0F;
            float rY = topY + topFlyY;
            boolean rHov = (mouseX >= rX && mouseX <= rX + topW && mouseY >= rY && mouseY <= rY + topH);
            rockstar$tileHoverAnim[2] += ((rHov ? 1.0F : 0.0F) - rockstar$tileHoverAnim[2]) * 0.20F;
            float dY = rY - rockstar$tileHoverAnim[2] * 3.5F;
            rockstar$renderDroneRadarCard(custom, rX, dY, topW, topH, boldFont, font, subFont, tinyFont, mouseX, mouseY, rockstar$tileHoverAnim[2], cfg, now);
        }

        // ==========================================
        // 2. MAIN ROW:
        // Left Pod (Volume & Camera) | Calculator | Embedded Notes | Action Rectangles
        // ==========================================
        float mainY = cy - 54.0F;
        float mainH = 186.0F;
        float mainFlyY = (1.0F - rockstar$flyInAnim) * 36.0F;

        // 3: Left Pod: Volume Pill (50w x 186h) + Quick Camera/Fullscreen Pod (50w)
        float leftPodX = cx - 275.0F;
        float vY = mainY + mainFlyY;

        // Volume Pill
        if (cfg.showVolume) {
            float volW = 50.0F;
            boolean vHov = (mouseX >= leftPodX && mouseX <= leftPodX + volW && mouseY >= vY && mouseY <= vY + mainH);
            rockstar$tileHoverAnim[3] += ((vHov ? 1.0F : 0.0F) - rockstar$tileHoverAnim[3]) * 0.20F;
            float dY = vY - rockstar$tileHoverAnim[3] * 3.5F;
            rockstar$renderVolumePill(custom, leftPodX, dY, volW, mainH, subFont, mouseX, mouseY, rockstar$tileHoverAnim[3]);
        }

        // Camera & Fullscreen stacked tiles
        float qX = leftPodX + 54.0F;
        float qW = 50.0F;
        float qTileH = (mainH - 6.0F) / 2.0F;
        if (cfg.showCamera) {
            float camY = vY;
            boolean cHov = (mouseX >= qX && mouseX <= qX + qW && mouseY >= camY && mouseY <= camY + qTileH);
            rockstar$tileHoverAnim[4] += ((cHov ? 1.0F : 0.0F) - rockstar$tileHoverAnim[4]) * 0.20F;
            float dY = camY - rockstar$tileHoverAnim[4] * 3.5F;
            rockstar$renderCameraTile(custom, qX, dY, qW, qTileH, mouseX, mouseY, rockstar$tileHoverAnim[4]);

            float fsY = camY + qTileH + 6.0F;
            boolean fsHov = (mouseX >= qX && mouseX <= qX + qW && mouseY >= fsY && mouseY <= fsY + qTileH);
            rockstar$tileHoverAnim[5] += ((fsHov ? 1.0F : 0.0F) - rockstar$tileHoverAnim[5]) * 0.20F;
            float dFsY = fsY - rockstar$tileHoverAnim[5] * 3.5F;
            rockstar$renderFullscreenTile(custom, qX, dFsY, qW, qTileH, mouseX, mouseY, rockstar$tileHoverAnim[5]);
        }

        // 4: iOS Calculator Card
        float calcX = cx - 163.0F;
        float calcW = 142.0F;
        if (cfg.showCalculator) {
            float cY = mainY + mainFlyY;
            boolean calcHov = (mouseX >= calcX && mouseX <= calcX + calcW && mouseY >= cY && mouseY <= cY + mainH);
            rockstar$tileHoverAnim[6] += ((calcHov ? 1.0F : 0.0F) - rockstar$tileHoverAnim[6]) * 0.20F;
            float dY = cY - rockstar$tileHoverAnim[6] * 3.5F;
            rockstar$renderCalculatorCard(custom, calcX, dY, calcW, mainH, boldFont, font, mouseX, mouseY, rockstar$tileHoverAnim[6]);
        }

        // 5: Embedded Notes Widget ("чуть больше калькулятора, справа, строчный фон тетради")
        float notesX = cx - 13.0F;
        float notesW = 172.0F;
        if (cfg.showNotes) {
            float nY = mainY + mainFlyY;
            boolean nHov = (mouseX >= notesX && mouseX <= notesX + notesW && mouseY >= nY && mouseY <= nY + mainH);
            rockstar$tileHoverAnim[7] += ((nHov ? 1.0F : 0.0F) - rockstar$tileHoverAnim[7]) * 0.20F;
            float dY = nY - rockstar$tileHoverAnim[7] * 3.5F;
            rockstar$renderNotesCard(custom, notesX, dY, notesW, mainH, boldFont, font, subFont, tinyFont, mouseX, mouseY, rockstar$tileHoverAnim[7]);
        }

        // 6: Right Action Rectangular Frosted Glass Buttons (В игру, Настройки, Меню, Выход)
        float actX = cx + 167.0F;
        float actW = 108.0F;
        float actBtnH = 40.0F;
        float actGap = 8.0F;
        float actY = mainY + mainFlyY + 3.0F;
        IIiii_Class8 aRad = IIiii_Class8.I_method_893b2757(8.0F);

        String[] actionLabels = { "▶ В игру", "⚙ Опции", "🛠 Меню", "🚪 Выйти" };
        String[] actionIcons = { "play", "setting", "hud/target", "back" };
        ColorRGBA[] actionColors = {
            new ColorRGBA(34.0F, 197.0F, 94.0F, 220.0F),
            new ColorRGBA(59.0F, 130.0F, 246.0F, 220.0F),
            new ColorRGBA(168.0F, 85.0F, 247.0F, 220.0F),
            new ColorRGBA(239.0F, 68.0F, 68.0F, 220.0F)
        };

        for (int i = 0; i < 4; i++) {
            float bY = actY + i * (actBtnH + actGap);
            boolean isHov = (mouseX >= actX && mouseX <= actX + actW && mouseY >= bY && mouseY <= bY + actBtnH);
            rockstar$actionBtnHover[i] += ((isHov ? 1.0F : 0.0F) - rockstar$actionBtnHover[i]) * 0.22F;
            float hA = rockstar$actionBtnHover[i];
            float drawY = bY - hA * 2.5F;

            custom.drawShadow(actX, drawY, actW, actBtnH, 10.0F + 4.0F * hA, aRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 70.0F + 30.0F * hA));
            custom.drawBlurredRect(actX, drawY, actW, actBtnH, 12.0F, 3.0F, aRad, actionColors[i].withAlpha(18.0F));
            custom.drawRoundedRect(actX, drawY, actW, actBtnH, aRad, new ColorRGBA(22.0F, 26.0F, 36.0F, 205.0F + 40.0F * hA));
            custom.drawRoundedBorder(actX, drawY, actW, actBtnH, 1.0F, aRad, hA > 0.01F ? actionColors[i].withAlpha(140.0F + 115.0F * hA) : new ColorRGBA(255.0F, 255.0F, 255.0F, 35.0F));

            if (font != null) {
                float tw = font.I_method_2c375926(actionLabels[i]);
                custom.drawText(font, actionLabels[i], actX + 12.0F, drawY + 14.5F, ColorRGBA.WHITE);
            }
        }

        // ==========================================
        // 3. BOTTOM QUICK CONTROL DOCK (Rectangular Frosted Glass Buttons)
        // [ ✦ Agravity AI ] [ 🐍 Змейка ] [ 💣 Сапёр ] [ 🛠 Меню ]
        // ==========================================
        float bRowY = cy + 140.0F;
        float bRowH = 34.0F;
        float bStartX = cx - 160.0F;
        IIiii_Class8 sRad = IIiii_Class8.I_method_893b2757(8.0F);

        float dockFlyY = (1.0F - rockstar$flyInAnim) * 44.0F;

        // 1. [ ✦ Agravity AI ] (Toggles Slide-in Drawer!)
        float aiX = bStartX;
        float aiW = 100.0F;
        boolean aiHov = (mouseX >= aiX && mouseX <= aiX + aiW && mouseY >= bRowY + dockFlyY && mouseY <= bRowY + dockFlyY + bRowH);
        rockstar$dockBtnHover[0] += ((aiHov ? 1.0F : 0.0F) - rockstar$dockBtnHover[0]) * 0.22F;
        float hA0 = rockstar$dockBtnHover[0];
        float drawYAi = bRowY + dockFlyY - hA0 * 2.5F;
        boolean aiActive = rockstar$aiDrawerOpen;
        custom.drawShadow(aiX, drawYAi, aiW, bRowH, 10.0F + 4.0F * hA0, sRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 70.0F));
        custom.drawBlurredRect(aiX, drawYAi, aiW, bRowH, 12.0F, 3.0F, sRad, new ColorRGBA(59.0F, 130.0F, 246.0F, aiActive ? 50.0F : 24.0F));
        custom.drawRoundedRect(aiX, drawYAi, aiW, bRowH, sRad, aiActive ? new ColorRGBA(37.0F, 99.0F, 235.0F, 220.0F) : new ColorRGBA(22.0F, 26.0F, 36.0F, 205.0F + 40.0F * hA0));
        custom.drawRoundedBorder(aiX, drawYAi, aiW, bRowH, 1.0F, sRad, aiActive ? new ColorRGBA(255.0F, 255.0F, 255.0F, 160.0F) : (hA0 > 0.01F ? new ColorRGBA(59.0F, 130.0F, 246.0F, 140.0F + 115.0F * hA0) : new ColorRGBA(255.0F, 255.0F, 255.0F, 38.0F)));
        if (subFont != null) {
            float tw = subFont.I_method_2c375926("✦ Agravity AI");
            custom.drawText(subFont, "✦ Agravity AI", aiX + (aiW - tw) / 2.0F, drawYAi + 11.5F, ColorRGBA.WHITE);
        }

        // 2. [ 🐍 Змейка ] Mini-game
        float snakeX = aiX + aiW + 6.0F;
        float gBtnW = 60.0F;
        boolean snakeHov = (mouseX >= snakeX && mouseX <= snakeX + gBtnW && mouseY >= bRowY + dockFlyY && mouseY <= bRowY + dockFlyY + bRowH);
        rockstar$dockBtnHover[1] += ((snakeHov ? 1.0F : 0.0F) - rockstar$dockBtnHover[1]) * 0.22F;
        float hA1 = rockstar$dockBtnHover[1];
        float drawYSn = bRowY + dockFlyY - hA1 * 2.5F;
        custom.drawShadow(snakeX, drawYSn, gBtnW, bRowH, 10.0F + 4.0F * hA1, sRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 70.0F));
        custom.drawBlurredRect(snakeX, drawYSn, gBtnW, bRowH, 12.0F, 3.0F, sRad, new ColorRGBA(52.0F, 211.0F, 153.0F, 24.0F));
        custom.drawRoundedRect(snakeX, drawYSn, gBtnW, bRowH, sRad, new ColorRGBA(22.0F, 26.0F, 36.0F, 205.0F + 40.0F * hA1));
        custom.drawRoundedBorder(snakeX, drawYSn, gBtnW, bRowH, 1.0F, sRad, hA1 > 0.01F ? new ColorRGBA(52.0F, 211.0F, 153.0F, 140.0F + 115.0F * hA1) : new ColorRGBA(255.0F, 255.0F, 255.0F, 38.0F));
        float snSz = 22.0F;
        custom.drawTexture(RockstarClient.id("icons/snake.png"), snakeX + 6.0F, drawYSn + (bRowH - snSz) / 2.0F, snSz, snSz, ColorRGBA.WHITE);
        if (tinyFont != null) {
            custom.drawText(tinyFont, "Змейка", snakeX + 32.0F, drawYSn + 12.5F, ColorRGBA.WHITE);
        }

        // 3. [ 💣 Сапёр ] Mini-game
        float mineX = snakeX + gBtnW + 6.0F;
        boolean mineHov = (mouseX >= mineX && mouseX <= mineX + gBtnW && mouseY >= bRowY + dockFlyY && mouseY <= bRowY + dockFlyY + bRowH);
        rockstar$dockBtnHover[2] += ((mineHov ? 1.0F : 0.0F) - rockstar$dockBtnHover[2]) * 0.22F;
        float hA2 = rockstar$dockBtnHover[2];
        float drawYMn = bRowY + dockFlyY - hA2 * 2.5F;
        custom.drawShadow(mineX, drawYMn, gBtnW, bRowH, 10.0F + 4.0F * hA2, sRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 70.0F));
        custom.drawBlurredRect(mineX, drawYMn, gBtnW, bRowH, 12.0F, 3.0F, sRad, new ColorRGBA(244.0F, 63.0F, 94.0F, 24.0F));
        custom.drawRoundedRect(mineX, drawYMn, gBtnW, bRowH, sRad, new ColorRGBA(22.0F, 26.0F, 36.0F, 205.0F + 40.0F * hA2));
        custom.drawRoundedBorder(mineX, drawYMn, gBtnW, bRowH, 1.0F, sRad, hA2 > 0.01F ? new ColorRGBA(244.0F, 63.0F, 94.0F, 140.0F + 115.0F * hA2) : new ColorRGBA(255.0F, 255.0F, 255.0F, 38.0F));
        custom.drawTexture(RockstarClient.id("icons/mine.png"), mineX + 6.0F, drawYMn + (bRowH - snSz) / 2.0F, snSz, snSz, ColorRGBA.WHITE);
        if (tinyFont != null) {
            custom.drawText(tinyFont, "Сапёр", mineX + 32.0F, drawYMn + 12.5F, ColorRGBA.WHITE);
        }

        // 4. [ 🛠 Настройка ] Quick Customizer Button
        float setX = mineX + gBtnW + 6.0F;
        float setW = 82.0F;
        boolean setHov = (mouseX >= setX && mouseX <= setX + setW && mouseY >= bRowY + dockFlyY && mouseY <= bRowY + dockFlyY + bRowH);
        rockstar$dockBtnHover[3] += ((setHov ? 1.0F : 0.0F) - rockstar$dockBtnHover[3]) * 0.22F;
        float hA3 = rockstar$dockBtnHover[3];
        float drawYSet = bRowY + dockFlyY - hA3 * 2.5F;
        custom.drawShadow(setX, drawYSet, setW, bRowH, 10.0F + 4.0F * hA3, sRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 70.0F));
        custom.drawBlurredRect(setX, drawYSet, setW, bRowH, 12.0F, 3.0F, sRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));
        custom.drawRoundedRect(setX, drawYSet, setW, bRowH, sRad, new ColorRGBA(22.0F, 26.0F, 36.0F, 205.0F + 40.0F * hA3));
        custom.drawRoundedBorder(setX, drawYSet, setW, bRowH, 1.0F, sRad, hA3 > 0.01F ? new ColorRGBA(255.0F, 255.0F, 255.0F, 120.0F + 135.0F * hA3) : new ColorRGBA(255.0F, 255.0F, 255.0F, 38.0F));
        if (subFont != null) {
            float tw = subFont.I_method_2c375926("🛠 Настройка");
            custom.drawText(subFont, "🛠 Настройка", setX + (setW - tw) / 2.0F, drawYSet + 11.5F, ColorRGBA.WHITE);
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
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(14.0F);
        ColorRGBA theme = IiiiiIIIi_Class242.I_method_7df8e08e();
        custom.drawShadow(x, y, w, h, 14.0F + 8.0F * hoverA, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 90.0F + 40.0F * hoverA));
        custom.drawBlurredRect(x, y, w, h, 16.0F, 3.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(22.0F, 26.0F, 36.0F, 205.0F));
        custom.drawRoundedBorder(x, y, w, h, 1.0F, rad, hoverA > 0.01F ? theme.withAlpha(220.0F * hoverA) : new ColorRGBA(255.0F, 255.0F, 255.0F, 38.0F));

        boolean hasTrack = (snap != null);
        String trackTitle = hasTrack ? snap.I_method_33e8b426() : "Музыка в браузере";
        boolean isPlaying = hasTrack && snap.I_method_1a22ebbe();
        double posSec = hasTrack ? snap.I_method_1a22eba8() : 0.0;
        long durSec = hasTrack ? snap.I_method_1a22ebae() : 0L;
        Identifier artwork = hasTrack ? snap.I_method_77a14989() : null;

        // Album artwork thumbnail
        float thumbSz = 26.0F;
        custom.drawRoundedRect(x + 8.0F, y + 8.0F, thumbSz, thumbSz, IIiii_Class8.I_method_893b2757(6.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));
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
            custom.drawRoundedRect(bx, eqBaseY - bH, barW, bH, IIiii_Class8.I_method_893b2757(1.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, isPlaying ? 235.0F : 80.0F));
        }

        // Web / Browser indicator icon in top right
        custom.drawIcon("language", x + w - 18.0F, y + 9.0F, 11.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 170.0F));

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

        custom.drawRoundedRect(scrubX, scrubY, scrubW, scrubH, IIiii_Class8.I_method_893b2757(1.5F), new ColorRGBA(255.0F, 255.0F, 255.0F, 35.0F));
        if (progRatio > 0.01F) {
            custom.drawRoundedRect(scrubX, scrubY, scrubW * progRatio, scrubH, IIiii_Class8.I_method_893b2757(1.5F), theme);
            custom.drawRoundedRect(scrubX + scrubW * progRatio - 2.5F, scrubY - 1.5F, 5.0F, 5.5F, IIiii_Class8.I_method_893b2757(2.5F), ColorRGBA.WHITE);
        }

        // Media controls row (⏮, ▶/⏸, ⏭)
        float ctrlY = y + 57.0F;
        if (subFont != null) {
            boolean prevHov = mx >= x + 12.0F && mx <= x + 28.0F && my >= ctrlY - 2.0F && my <= ctrlY + 12.0F;
            custom.drawText(subFont, "⏮", x + 14.0F, ctrlY, prevHov ? ColorRGBA.WHITE : new ColorRGBA(255.0F, 255.0F, 255.0F, 180.0F));

            boolean playHov = mx >= x + w / 2.0F - 10.0F && mx <= x + w / 2.0F + 10.0F && my >= ctrlY - 2.0F && my <= ctrlY + 12.0F;
            String playSym = isPlaying ? "⏸" : "▶";
            custom.drawText(subFont, playSym, x + w / 2.0F - 4.0F, ctrlY, playHov ? ColorRGBA.WHITE : new ColorRGBA(255.0F, 255.0F, 255.0F, 230.0F));

            boolean nextHov = mx >= x + w - 28.0F && mx <= x + w - 12.0F && my >= ctrlY - 2.0F && my <= ctrlY + 12.0F;
            custom.drawText(subFont, "⏭", x + w - 26.0F, ctrlY, nextHov ? ColorRGBA.WHITE : new ColorRGBA(255.0F, 255.0F, 255.0F, 180.0F));
        }
    }

    // Module 1: Separate iOS Weather Widget Card
    @Unique
    private void rockstar$renderWeatherCard(III custom, float x, float y, float w, float h, IIiIIi_Class10 boldFont, IIiIIi_Class10 font, IIiIIi_Class10 subFont, IIiIIi_Class10 tinyFont, int mx, int my, float hoverA, EscapeMenuConfig cfg) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(14.0F);
        custom.drawShadow(x, y, w, h, 14.0F + 8.0F * hoverA, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 90.0F + 30.0F * hoverA));
        custom.drawBlurredRect(x, y, w, h, 16.0F, 3.0F, rad, new ColorRGBA(59.0F, 130.0F, 246.0F, 22.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(18.0F, 26.0F, 40.0F, 210.0F));
        custom.drawRoundedBorder(x, y, w, h, 1.0F, rad, hoverA > 0.01F ? new ColorRGBA(59.0F, 130.0F, 246.0F, 220.0F * hoverA) : new ColorRGBA(255.0F, 255.0F, 255.0F, 38.0F));

        WeatherAlertModule wMod = RockstarClient.getInstance().getModuleManager().getModule(WeatherAlertModule.class);
        int temp = (wMod != null) ? wMod.getCurrentWeatherTemp() : 16;
        String cond = (wMod != null) ? wMod.getWeatherCondition() : "Облачно ⛅";
        String city = (cfg.weatherCity != null) ? cfg.weatherCity : "Киев";
        float wind = (wMod != null) ? wMod.getWindSpeed() : 3.8F;

        // Top Row: City + Chevron
        if (font != null) {
            custom.drawText(font, city + " ▾", x + 10.0F, y + 10.0F, ColorRGBA.WHITE);
        }

        // Weather Icon / Emoji top right
        if (boldFont != null) {
            String emoji = cond.contains("☀️") ? "☀️" : (cond.contains("🌧️") ? "🌧️" : (cond.contains("🌤️") ? "🌤️" : "⛅"));
            custom.drawText(boldFont, emoji, x + w - 24.0F, y + 8.0F, ColorRGBA.WHITE);
        }

        // Center Big Temp
        if (boldFont != null) {
            String tempStr = (temp > 0 ? "+" : "") + temp + "°";
            custom.drawText(boldFont, tempStr, x + 10.0F, y + 30.0F, ColorRGBA.WHITE);
        }

        // Bottom condition & wind speed
        if (tinyFont != null) {
            String subStr = cond + " • " + String.format("%.1f м/с", wind);
            if (subStr.length() > 20) subStr = subStr.substring(0, 19) + "…";
            custom.drawText(tinyFont, subStr, x + 10.0F, y + 54.0F, new ColorRGBA(190.0F, 210.0F, 240.0F, 210.0F));
        }
    }

    // Module 2: Separate iOS Drone Threat / Tactical Radar Card
    @Unique
    private void rockstar$renderDroneRadarCard(III custom, float x, float y, float w, float h, IIiIIi_Class10 boldFont, IIiIIi_Class10 font, IIiIIi_Class10 subFont, IIiIIi_Class10 tinyFont, int mx, int my, float hoverA, EscapeMenuConfig cfg, long now) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(14.0F);
        custom.drawShadow(x, y, w, h, 14.0F + 8.0F * hoverA, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 90.0F + 30.0F * hoverA));
        custom.drawBlurredRect(x, y, w, h, 16.0F, 3.0F, rad, new ColorRGBA(239.0F, 68.0F, 68.0F, 20.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(34.0F, 20.0F, 26.0F, 210.0F));
        custom.drawRoundedBorder(x, y, w, h, 1.0F, rad, hoverA > 0.01F ? new ColorRGBA(239.0F, 68.0F, 68.0F, 220.0F * hoverA) : new ColorRGBA(255.0F, 255.0F, 255.0F, 38.0F));

        // Pulsing radar dot
        float radarX = x + 14.0F;
        float radarY = y + 14.0F;
        float pulseScale = (float)(Math.sin(now / 200.0) * 0.35 + 0.65);
        ColorRGBA dotCol = new ColorRGBA(239.0F, 68.0F, 68.0F, 255.0F * pulseScale);
        custom.drawRoundedRect(radarX - 3.0F, radarY - 3.0F, 6.0F, 6.0F, IIiii_Class8.I_method_893b2757(3.0F), dotCol);

        // Header Title
        if (font != null) {
            custom.drawText(font, "БПЛА Радар", radarX + 8.0F, y + 9.5F, ColorRGBA.WHITE);
        }

        // Scope badge top right
        float badgeW = 44.0F;
        float badgeH = 15.0F;
        float badgeX = x + w - badgeW - 8.0F;
        float badgeY = y + 8.5F;
        custom.drawRoundedRect(badgeX, badgeY, badgeW, badgeH, IIiii_Class8.I_method_893b2757(4.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));
        if (tinyFont != null) {
            float tw = tinyFont.I_method_2c375926(cfg.alertScope + " ▾");
            custom.drawText(tinyFont, cfg.alertScope + " ▾", badgeX + (badgeW - tw) / 2.0F, badgeY + 4.0F, ColorRGBA.WHITE);
        }

        // Active threat readout in center
        String threatMsg = "Белгород, Курск";
        String threatLevel = "🔴 Опасность атаки";
        if ("Украина".equals(cfg.alertScope)) {
            threatMsg = "Киев, Харьков";
            threatLevel = "🔴 Воздушная тревога";
        } else if ("Россия".equals(cfg.alertScope)) {
            threatMsg = "Белгород, Воронеж";
            threatLevel = "🟡 Угроза БПЛА";
        }

        if (boldFont != null) {
            custom.drawText(boldFont, threatMsg, x + 10.0F, y + 30.0F, new ColorRGBA(254.0F, 202.0F, 202.0F, 245.0F));
        }

        // Subtitle status
        if (tinyFont != null) {
            custom.drawText(tinyFont, threatLevel, x + 10.0F, y + 54.0F, new ColorRGBA(252.0F, 165.0F, 165.0F, 210.0F));
        }
    }

    // Module 3: Camera Tile
    @Unique
    private void rockstar$renderCameraTile(III custom, float x, float y, float w, float h, int mx, int my, float hoverA) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(12.0F);
        boolean hov = mx >= x && mx <= x + w && my >= y && my <= y + h;
        custom.drawShadow(x, y, w, h, 12.0F + 6.0F * hoverA, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 80.0F + 30.0F * hoverA));
        custom.drawBlurredRect(x, y, w, h, 14.0F, 3.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(22.0F, 26.0F, 36.0F, 195.0F));
        custom.drawRoundedBorder(x, y, w, h, 1.0F, rad, hov ? new ColorRGBA(0.0F, 122.0F, 255.0F, 220.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 35.0F));

        float podSz = 28.0F;
        float px = x + (w - podSz) / 2.0F;
        float py = y + (h - podSz) / 2.0F;
        IIiii_Class8 pRad = IIiii_Class8.I_method_893b2757(8.0F);
        custom.drawRoundedRect(px, py, podSz, podSz, pRad, new ColorRGBA(0.0F, 122.0F, 255.0F, hov ? 255.0F : 210.0F));
        custom.drawIcon("hud/target", px + 6.0F, py + 6.0F, 16.0F, ColorRGBA.WHITE);
    }

    // Module 4: Fullscreen Tile
    @Unique
    private void rockstar$renderFullscreenTile(III custom, float x, float y, float w, float h, int mx, int my, float hoverA) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(12.0F);
        boolean hov = mx >= x && mx <= x + w && my >= y && my <= y + h;
        boolean isFs = (MinecraftClient.getInstance() != null && MinecraftClient.getInstance().getWindow().isFullscreen());

        custom.drawShadow(x, y, w, h, 12.0F + 6.0F * hoverA, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 80.0F + 30.0F * hoverA));
        custom.drawBlurredRect(x, y, w, h, 14.0F, 3.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(22.0F, 26.0F, 36.0F, 195.0F));
        custom.drawRoundedBorder(x, y, w, h, 1.0F, rad, hov ? new ColorRGBA(52.0F, 199.0F, 89.0F, 220.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 35.0F));

        float podSz = 28.0F;
        float px = x + (w - podSz) / 2.0F;
        float py = y + (h - podSz) / 2.0F;
        IIiii_Class8 pRad = IIiii_Class8.I_method_893b2757(8.0F);
        custom.drawRoundedRect(px, py, podSz, podSz, pRad, isFs ? new ColorRGBA(52.0F, 199.0F, 89.0F, hov ? 255.0F : 220.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, hov ? 40.0F : 20.0F));
        custom.drawIcon("keyboard", px + 5.0F, py + 5.0F, 18.0F, ColorRGBA.WHITE);
    }

    // Module 5: Master Volume Vertical Slider Pill
    @Unique
    private void rockstar$renderVolumePill(III custom, float x, float y, float w, float h, IIiIIi_Class10 subFont, int mx, int my, float hoverA) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(w / 2.0F);
        float currentVol = (float)MinecraftClient.getInstance().options.getSoundVolume(SoundCategory.MASTER);

        custom.drawShadow(x, y, w, h, 14.0F + 6.0F * hoverA, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 90.0F + 30.0F * hoverA));
        custom.drawBlurredRect(x, y, w, h, 16.0F, 3.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(22.0F, 26.0F, 36.0F, 195.0F));

        float fillH = h * MathHelper.clamp(currentVol, 0.0F, 1.0F);
        if (fillH > 4.0F) {
            float fillY = y + h - fillH;
            custom.drawRoundedRect(x, fillY, w, fillH, rad, new ColorRGBA(245.0F, 248.0F, 255.0F, 240.0F));
        }

        custom.drawRoundedBorder(x, y, w, h, 1.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F));

        ColorRGBA iconCol = (currentVol > 0.25F) ? new ColorRGBA(0.0F, 122.0F, 255.0F, 255.0F) : ColorRGBA.WHITE;
        custom.drawIcon("music", x + (w - 18.0F) / 2.0F, y + h - 26.0F, 18.0F, iconCol);

        if (subFont != null) {
            String pct = (int)(currentVol * 100.0F) + "%";
            float pw = subFont.I_method_2c375926(pct);
            custom.drawText(subFont, pct, x + (w - pw) / 2.0F, y + 10.0F, (currentVol > 0.85F) ? new ColorRGBA(30.0F, 30.0F, 36.0F, 240.0F) : ColorRGBA.WHITE);
        }
    }

    // Module 6: Interactive iOS Calculator
    @Unique
    private void rockstar$renderCalculatorCard(III custom, float x, float y, float w, float h, IIiIIi_Class10 boldFont, IIiIIi_Class10 font, int mx, int my, float hoverA) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(14.0F);
        custom.drawShadow(x, y, w, h, 16.0F + 8.0F * hoverA, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 110.0F + 40.0F * hoverA));
        custom.drawBlurredRect(x, y, w, h, 18.0F, 3.5F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(18.0F, 20.0F, 28.0F, 220.0F));
        custom.drawRoundedBorder(x, y, w, h, 1.0F, rad, hoverA > 0.01F ? new ColorRGBA(255.0F, 255.0F, 255.0F, 140.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 45.0F));

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
                    bg = new ColorRGBA(165.0F, 165.0F, 165.0F, bHov ? 255.0F : 210.0F);
                    fg = ColorRGBA.BLACK;
                } else if (c == 3 || label.equals("=")) {
                    bg = new ColorRGBA(255.0F, 159.0F, 10.0F, bHov ? 255.0F : 225.0F);
                } else {
                    bg = new ColorRGBA(55.0F, 58.0F, 68.0F, bHov ? 255.0F : 200.0F);
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

    // Module 7: Embedded Notes Widget with Ruled Notebook Paper Background ("строчный фон как у любого приложения заметок")
    @Unique
    private void rockstar$renderNotesCard(III custom, float x, float y, float w, float h, IIiIIi_Class10 boldFont, IIiIIi_Class10 font, IIiIIi_Class10 subFont, IIiIIi_Class10 tinyFont, int mx, int my, float hoverA) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(14.0F);
        ColorRGBA theme = IiiiiIIIi_Class242.I_method_7df8e08e();
        custom.drawShadow(x, y, w, h, 16.0F + 8.0F * hoverA, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 90.0F + 30.0F * hoverA));
        custom.drawBlurredRect(x, y, w, h, 18.0F, 3.5F, rad, new ColorRGBA(245.0F, 158.0F, 11.0F, 16.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(24.0F, 26.0F, 34.0F, 220.0F));
        custom.drawRoundedBorder(x, y, w, h, 1.0F, rad, rockstar$notesEditing ? new ColorRGBA(245.0F, 158.0F, 11.0F, 220.0F) : (hoverA > 0.01F ? theme.withAlpha(200.0F * hoverA) : new ColorRGBA(255.0F, 255.0F, 255.0F, 38.0F)));

        // Header Title: 📝 Заметки
        if (font != null) {
            custom.drawText(font, "📝 Заметки", x + 10.0F, y + 8.0F, ColorRGBA.WHITE);
        }

        List<NotesManager.Note> notes = NotesManager.getNotes();
        int noteCount = notes.size();
        int activeIdx = MathHelper.clamp(rockstar$notesActiveIdx, 0, Math.max(0, noteCount - 1));
        NotesManager.Note currentNote = (!notes.isEmpty() && activeIdx < notes.size()) ? notes.get(activeIdx) : null;

        // Note Pager: < 1/3 >
        if (tinyFont != null && noteCount > 0) {
            String pageStr = (activeIdx + 1) + "/" + noteCount;
            float pw = tinyFont.I_method_2c375926(pageStr);
            custom.drawText(tinyFont, "‹", x + 72.0F, y + 9.5F, activeIdx > 0 ? ColorRGBA.WHITE : new ColorRGBA(255.0F, 255.0F, 255.0F, 90.0F));
            custom.drawText(tinyFont, pageStr, x + 80.0F, y + 9.5F, new ColorRGBA(245.0F, 158.0F, 11.0F, 220.0F));
            custom.drawText(tinyFont, "›", x + 80.0F + pw + 3.0F, y + 9.5F, activeIdx < noteCount - 1 ? ColorRGBA.WHITE : new ColorRGBA(255.0F, 255.0F, 255.0F, 90.0F));
        }

        // Action button 1: [+] New Note
        float btnPlusX = x + w - 42.0F;
        float btnY = y + 6.0F;
        float btnSz = 16.0F;
        boolean plusHov = (mx >= btnPlusX && mx <= btnPlusX + btnSz && my >= btnY && my <= btnY + btnSz);
        custom.drawRoundedRect(btnPlusX, btnY, btnSz, btnSz, IIiii_Class8.I_method_893b2757(4.0F), plusHov ? new ColorRGBA(59.0F, 130.0F, 246.0F, 200.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));
        if (tinyFont != null) {
            custom.drawText(tinyFont, "+", btnPlusX + 5.0F, btnY + 4.5F, ColorRGBA.WHITE);
        }

        // Action button 2: [📍] Insert Player Coordinates
        float btnCoordX = x + w - 22.0F;
        boolean coordHov = (mx >= btnCoordX && mx <= btnCoordX + btnSz && my >= btnY && my <= btnY + btnSz);
        custom.drawRoundedRect(btnCoordX, btnY, btnSz, btnSz, IIiii_Class8.I_method_893b2757(4.0F), coordHov ? new ColorRGBA(16.0F, 185.0F, 129.0F, 200.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));
        if (tinyFont != null) {
            custom.drawText(tinyFont, "📍", btnCoordX + 2.0F, btnY + 4.0F, ColorRGBA.WHITE);
        }

        // Apple Notes yellow top divider line
        custom.drawRect(x + 10.0F, y + 25.0F, w - 20.0F, 1.0F, new ColorRGBA(245.0F, 158.0F, 11.0F, 150.0F));

        // Vertical margin guide line (like real lined notebook)
        custom.drawRect(x + 22.0F, y + 26.0F, 1.0F, h - 34.0F, new ColorRGBA(245.0F, 158.0F, 11.0F, 45.0F));

        // Notebook Ruled Horizontal Lines (строчный фон тетради / Apple Notes)
        float lineStartY = y + 42.0F;
        float lineSpacing = 16.0F;
        for (float ly = lineStartY; ly < y + h - 8.0F; ly += lineSpacing) {
            custom.drawRect(x + 10.0F, ly, w - 20.0F, 1.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 12.0F));
        }

        // Render current note content on the ruled lines
        if (currentNote != null) {
            // Title on first ruled line
            if (subFont != null) {
                String t = currentNote.title.isEmpty() ? "Заметка" : currentNote.title;
                if (t.length() > 18) t = t.substring(0, 17) + "…";
                custom.drawText(subFont, t, x + 26.0F, y + 29.0F, new ColorRGBA(254.0F, 240.0F, 138.0F, 240.0F));
            }

            // Coordinates tag if present
            if (currentNote.cords != null && !currentNote.cords.isEmpty() && tinyFont != null) {
                String cDisp = "📍 " + currentNote.cords;
                if (cDisp.length() > 22) cDisp = cDisp.substring(0, 21) + "…";
                custom.drawText(tinyFont, cDisp, x + 26.0F, y + 44.5F, new ColorRGBA(52.0F, 211.0F, 153.0F, 220.0F));
            }

            // Note Content lines on the ruled lines
            if (subFont != null) {
                String[] lines = currentNote.content.split("\n");
                float textY = (currentNote.cords != null && !currentNote.cords.isEmpty()) ? (lineStartY + lineSpacing + 2.5F) : (lineStartY + 2.5F);
                for (int li = 0; li < lines.length; li++) {
                    if (textY + 12.0F > y + h - 6.0F) break;
                    String lineTxt = lines[li];
                    if (li == lines.length - 1 && rockstar$notesEditing && (System.currentTimeMillis() % 1000L < 500L)) {
                        lineTxt += "|";
                    }
                    custom.drawText(subFont, lineTxt, x + 26.0F, textY, ColorRGBA.WHITE);
                    textY += lineSpacing;
                }

                if (lines.length == 0 || currentNote.content.isEmpty()) {
                    String emptyMsg = rockstar$notesEditing ? "|" : "Кликните для ввода...";
                    custom.drawText(subFont, emptyMsg, x + 26.0F, textY, new ColorRGBA(255.0F, 255.0F, 255.0F, 90.0F));
                }
            }
        } else {
            if (subFont != null) {
                custom.drawText(subFont, "Нажмите + чтобы создать заметку", x + 16.0F, y + 46.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 120.0F));
            }
        }
    }

    // Module 8: Slide-in AI Assistant Drawer ("ai чатом сделай его меньше и размети с правой стороны по кнопке что бы оно выплывало")
    @Unique
    private void rockstar$renderSlideInAiDrawer(III custom, IIiIIi_Class10 boldFont, IIiIIi_Class10 font, IIiIIi_Class10 subFont, IIiIIi_Class10 tinyFont, int mx, int my) {
        float drawerW = 260.0F;
        float drawerH = Math.min(370.0F, this.height - 30.0F);
        float drawerY = this.height / 2.0F - drawerH / 2.0F;
        float drawerX = (float)this.width - rockstar$aiDrawerAnim * (drawerW + 12.0F);
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(14.0F);

        custom.drawShadow(drawerX, drawerY, drawerW, drawerH, 20.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 110.0F));
        custom.drawBlurredRect(drawerX, drawerY, drawerW, drawerH, 22.0F, 3.5F, rad, new ColorRGBA(59.0F, 130.0F, 246.0F, 24.0F));
        custom.drawRoundedRect(drawerX, drawerY, drawerW, drawerH, rad, new ColorRGBA(18.0F, 22.0F, 32.0F, 230.0F));
        custom.drawRoundedBorder(drawerX, drawerY, drawerW, drawerH, 1.1F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 42.0F));

        // Header: ✦ Agravity AI + Gemini badge
        float hY = drawerY + 10.0F;
        if (font != null) {
            custom.drawText(font, "✦ Agravity AI", drawerX + 12.0F, hY + 1.0F, ColorRGBA.WHITE);
        }

        // Close button (✕)
        float closeSz = 20.0F;
        float closeX = drawerX + drawerW - closeSz - 10.0F;
        float closeY = hY - 1.0F;
        boolean closeHov = (mx >= closeX && mx <= closeX + closeSz && my >= closeY && my <= closeY + closeSz);
        IIiii_Class8 cRad = IIiii_Class8.I_method_893b2757(closeSz / 2.0F);
        custom.drawRoundedRect(closeX, closeY, closeSz, closeSz, cRad, closeHov ? new ColorRGBA(239.0F, 68.0F, 68.0F, 240.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 30.0F));
        if (font != null) {
            custom.drawText(font, "✕", closeX + 5.5F, closeY + 5.0F, ColorRGBA.WHITE);
        }

        // Clear chat button [🗑]
        float clrSz = 20.0F;
        float clrX = closeX - clrSz - 6.0F;
        boolean clrHov = (mx >= clrX && mx <= clrX + clrSz && my >= closeY && my <= closeY + clrSz);
        custom.drawRoundedRect(clrX, closeY, clrSz, clrSz, cRad, clrHov ? new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));
        if (tinyFont != null) {
            custom.drawText(tinyFont, "🗑", clrX + 4.5F, closeY + 5.5F, ColorRGBA.WHITE);
        }

        // Header divider
        float divY = drawerY + 32.0F;
        custom.drawRect(drawerX + 10.0F, divY, drawerW - 20.0F, 1.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));

        // Scrollable Chat Message Bubbles
        float chatX = drawerX + 10.0F;
        float chatY = divY + 6.0F;
        float chatW = drawerW - 20.0F;
        float chatH = drawerH - 74.0F;

        List<AIAssistantService.ChatMessage> history = AIAssistantService.getHistory();
        float curY = chatY + 4.0F - rockstar$aiScroll;

        if (history.isEmpty()) {
            if (tinyFont != null) {
                String tip = "Задайте любой вопрос об игре,\nPvP или клиенте Agravity:";
                String[] tLines = tip.split("\n");
                custom.drawText(tinyFont, tLines[0], chatX + 12.0F, chatY + 24.0F, new ColorRGBA(180.0F, 195.0F, 220.0F, 200.0F));
                custom.drawText(tinyFont, tLines[1], chatX + 12.0F, chatY + 36.0F, new ColorRGBA(180.0F, 195.0F, 220.0F, 200.0F));
            }
        } else {
            for (AIAssistantService.ChatMessage msg : history) {
                boolean isUser = msg.isUser();
                float bW = chatW * 0.78F;
                float bX = isUser ? (chatX + chatW - bW) : chatX;

                List<String> lines = rockstar$wrapLines(msg.text(), bW - 18.0F, subFont);
                float bH = Math.max(20.0F, lines.size() * 10.5F + 10.0F);

                if (curY + bH >= chatY && curY <= chatY + chatH) {
                    ColorRGBA bgCol = isUser ? new ColorRGBA(0.0F, 122.0F, 255.0F, 225.0F) : new ColorRGBA(32.0F, 40.0F, 56.0F, 210.0F);
                    IIiii_Class8 bubbleRad = IIiii_Class8.I_method_893b2757(8.0F);
                    custom.drawRoundedRect(bX, curY, bW, bH, bubbleRad, bgCol);
                    custom.drawRoundedBorder(bX, curY, bW, bH, 1.0F, bubbleRad, isUser ? new ColorRGBA(255.0F, 255.0F, 255.0F, 70.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 30.0F));

                    if (subFont != null) {
                        float lineY = curY + 5.5F;
                        for (String l : lines) {
                            custom.drawText(subFont, l, bX + 8.0F, lineY, ColorRGBA.WHITE);
                            lineY += 10.5F;
                        }
                    }
                }
                curY += bH + 5.0F;
            }

            if (rockstar$aiThinking) {
                float thinkW = 100.0F;
                float thinkH = 18.0F;
                if (curY + thinkH >= chatY && curY <= chatY + chatH) {
                    custom.drawRoundedRect(chatX, curY, thinkW, thinkH, IIiii_Class8.I_method_893b2757(6.0F), new ColorRGBA(32.0F, 40.0F, 56.0F, 210.0F));
                    if (tinyFont != null) {
                        String dots = "...".substring(0, (int)(System.currentTimeMillis() / 350L % 4L));
                        custom.drawText(tinyFont, "ИИ думает" + dots, chatX + 8.0F, curY + 5.0F, new ColorRGBA(59.0F, 130.0F, 246.0F, 255.0F));
                    }
                }
            }
        }

        // Bottom Input Bar (iOS pill style)
        float inY = drawerY + drawerH - 34.0F;
        float inH = 26.0F;
        float sendW = 54.0F;
        float inW = drawerW - 20.0F - sendW - 6.0F;
        float inX = drawerX + 10.0F;

        IIiii_Class8 inRad = IIiii_Class8.I_method_893b2757(inH / 2.0F);
        custom.drawRoundedRect(inX, inY, inW, inH, inRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 15.0F));
        custom.drawRoundedBorder(inX, inY, inW, inH, 1.0F, inRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F));

        if (subFont != null) {
            String promptDisp = rockstar$aiInput.isEmpty() ? "Спросить..." : rockstar$aiInput;
            if (System.currentTimeMillis() % 1000L < 500L && !rockstar$aiInput.isEmpty()) promptDisp += "|";
            ColorRGBA col = rockstar$aiInput.isEmpty() ? new ColorRGBA(255.0F, 255.0F, 255.0F, 120.0F) : ColorRGBA.WHITE;
            custom.drawText(subFont, promptDisp, inX + 10.0F, inY + 8.0F, col);
        }

        // Send Button [Отправить]
        float sendX = inX + inW + 6.0F;
        boolean sendHov = (mx >= sendX && mx <= sendX + sendW && my >= inY && my <= inY + inH);
        custom.drawRoundedRect(sendX, inY, sendW, inH, inRad, new ColorRGBA(0.0F, 122.0F, 255.0F, sendHov ? 255.0F : 210.0F));
        custom.drawRoundedBorder(sendX, inY, sendW, inH, 1.0F, inRad, ColorRGBA.WHITE.withAlpha(sendHov ? 255.0F : 110.0F));
        if (tinyFont != null) {
            float sendTxtW = tinyFont.I_method_2c375926("Отправить");
            custom.drawText(tinyFont, "Отправить", sendX + (sendW - sendTxtW) / 2.0F, inY + 8.0F, ColorRGBA.WHITE);
        }
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
            float drawerW = 260.0F;
            float drawerH = Math.min(370.0F, this.height - 30.0F);
            float drawerY = this.height / 2.0F - drawerH / 2.0F;
            float drawerX = (float)this.width - (drawerW + 12.0F);

            if (mouseX >= drawerX && mouseX <= drawerX + drawerW && mouseY >= drawerY && mouseY <= drawerY + drawerH) {
                // Close button [✕]
                float closeSz = 20.0F;
                float closeX = drawerX + drawerW - closeSz - 10.0F;
                float closeY = drawerY + 9.0F;
                if (mouseX >= closeX && mouseX <= closeX + closeSz && mouseY >= closeY && mouseY <= closeY + closeSz) {
                    UISoundManager.playButtonClick();
                    rockstar$aiDrawerOpen = false;
                    return true;
                }

                // Clear button [🗑]
                float clrSz = 20.0F;
                float clrX = closeX - clrSz - 6.0F;
                if (mouseX >= clrX && mouseX <= clrX + clrSz && mouseY >= closeY && mouseY <= closeY + closeSz) {
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
        float topStartX = cx - 180.0F;
        float topY = cy - 138.0F;
        float topW = 116.0F;
        float topH = 74.0F;
        float topGap = 6.0F;

        // Media Player Click
        if (cfg.showMediaPlayer) {
            float mX = topStartX;
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
        if (cfg.showWeatherAlerts) {
            float wX = topStartX + topW + topGap;
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
        if (cfg.showWeatherAlerts) {
            float rX = topStartX + (topW + topGap) * 2.0F;
            if (mouseX >= rX && mouseX <= rX + topW && mouseY >= topY && mouseY <= topY + topH) {
                if ("Все".equals(cfg.alertScope)) cfg.alertScope = "Украина";
                else if ("Украина".equals(cfg.alertScope)) cfg.alertScope = "Россия";
                else cfg.alertScope = "Все";
                cfg.save();
                UISoundManager.playButtonClick();
                return true;
            }
        }

        // 3. Main Row Widget Clicks:
        float mainY = cy - 54.0F;
        float mainH = 186.0F;
        float leftPodX = cx - 275.0F;

        // Volume Pill Click
        if (cfg.showVolume) {
            float volW = 50.0F;
            if (mouseX >= leftPodX && mouseX <= leftPodX + volW && mouseY >= mainY && mouseY <= mainY + mainH) {
                rockstar$isDraggingVolume = true;
                rockstar$updateVolume(mouseY, mainY, mainH);
                return true;
            }
        }

        // Camera / Fullscreen Tiles Click
        float qX = leftPodX + 54.0F;
        float qW = 50.0F;
        float qTileH = (mainH - 6.0F) / 2.0F;
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
            float fsY = mainY + qTileH + 6.0F;
            if (mouseX >= qX && mouseX <= qX + qW && mouseY >= fsY && mouseY <= fsY + qTileH) {
                UISoundManager.playButtonClick();
                if (this.client != null) {
                    this.client.getWindow().toggleFullscreen();
                }
                return true;
            }
        }

        // Calculator Card Click
        float calcX = cx - 163.0F;
        float calcW = 142.0F;
        if (cfg.showCalculator && mouseX >= calcX && mouseX <= calcX + calcW && mouseY >= mainY && mouseY <= mainY + mainH) {
            if (rockstar$handleCalcClick(mouseX, mouseY, calcX, mainY, calcW, mainH)) {
                return true;
            }
        }

        // Embedded Notes Widget Click ("чуть больше калькулятора, справа, строчный фон тетради")
        float notesX = cx - 13.0F;
        float notesW = 172.0F;
        if (cfg.showNotes && mouseX >= notesX && mouseX <= notesX + notesW && mouseY >= mainY && mouseY <= mainY + mainH) {
            // New Note button [+]
            float btnPlusX = notesX + notesW - 42.0F;
            float btnY = mainY + 6.0F;
            float btnSz = 16.0F;
            if (mouseX >= btnPlusX && mouseX <= btnPlusX + btnSz && mouseY >= btnY && mouseY <= btnY + btnSz) {
                UISoundManager.playButtonClick();
                NotesManager.createNote("Заметка " + (NotesManager.getNotes().size() + 1), "", "");
                rockstar$notesActiveIdx = 0;
                rockstar$notesEditing = true;
                return true;
            }

            // Insert coordinates button [📍]
            float btnCoordX = notesX + notesW - 22.0F;
            if (mouseX >= btnCoordX && mouseX <= btnCoordX + btnSz && mouseY >= btnY && mouseY <= btnY + btnSz) {
                UISoundManager.playButtonClick();
                rockstar$insertCoordinatesToActiveNote();
                return true;
            }

            // Pager < and >
            List<NotesManager.Note> nList = NotesManager.getNotes();
            if (!nList.isEmpty()) {
                if (mouseX >= notesX + 70.0F && mouseX <= notesX + 79.0F && mouseY >= mainY + 6.0F && mouseY <= mainY + 22.0F) {
                    if (rockstar$notesActiveIdx > 0) {
                        rockstar$notesActiveIdx--;
                        UISoundManager.playButtonClick();
                    }
                    return true;
                }
                if (mouseX >= notesX + 96.0F && mouseX <= notesX + 110.0F && mouseY >= mainY + 6.0F && mouseY <= mainY + 22.0F) {
                    if (rockstar$notesActiveIdx < nList.size() - 1) {
                        rockstar$notesActiveIdx++;
                        UISoundManager.playButtonClick();
                    }
                    return true;
                }
            }

            // Clicked inside content area: enable editing!
            rockstar$notesEditing = true;
            UISoundManager.playButtonClick();
            return true;
        } else {
            rockstar$notesEditing = false;
        }

        // Right Action Buttons Pod (В игру, Настройки, Меню, Выход)
        float actX = cx + 167.0F;
        float actW = 108.0F;
        float actBtnH = 40.0F;
        float actGap = 8.0F;
        float actY = mainY + 3.0F;

        if (mouseX >= actX && mouseX <= actX + actW) {
            for (int i = 0; i < 4; i++) {
                float bY = actY + i * (actBtnH + actGap);
                if (mouseY >= bY && mouseY <= bY + actBtnH) {
                    UISoundManager.playButtonClick();
                    switch (i) {
                        case 0 -> this.close(); // Resume
                        case 1 -> { // Options
                            if (this.client != null) this.client.setScreen(new OptionsScreen(this, this.client.options));
                        }
                        case 2 -> { // Customizer ("меню перенеси в настройки")
                            if (this.client != null) this.client.setScreen(new EscapeMenuCustomizerScreen(this));
                        }
                        case 3 -> this.disconnect(); // Disconnect
                    }
                    return true;
                }
            }
        }

        // 4. Bottom Dock Buttons Clicks
        float bRowY = cy + 140.0F;
        float bRowH = 34.0F;
        float bStartX = cx - 160.0F;

        // [ ✦ Agravity AI ] Click: Toggle Slide-in Drawer!
        float aiX = bStartX;
        float aiW = 100.0F;
        if (mouseX >= aiX && mouseX <= aiX + aiW && mouseY >= bRowY && mouseY <= bRowY + bRowH) {
            UISoundManager.playButtonClick();
            rockstar$aiDrawerOpen = !rockstar$aiDrawerOpen;
            return true;
        }

        // [ 🐍 Змейка ] Click
        float snakeX = aiX + aiW + 6.0F;
        float gBtnW = 60.0F;
        if (cfg.showGames && mouseX >= snakeX && mouseX <= snakeX + gBtnW && mouseY >= bRowY && mouseY <= bRowY + bRowH) {
            UISoundManager.playButtonClick();
            if (this.client != null) {
                this.client.setScreen(new SnakeScreen(this));
            }
            return true;
        }

        // [ 💣 Сапёр ] Click
        float mineX = snakeX + gBtnW + 6.0F;
        if (cfg.showGames && mouseX >= mineX && mouseX <= mineX + gBtnW && mouseY >= bRowY && mouseY <= bRowY + bRowH) {
            UISoundManager.playButtonClick();
            if (this.client != null) {
                this.client.setScreen(new MinesweeperScreen(this));
            }
            return true;
        }

        // [ 🛠 Меню ] Click
        float setX = mineX + gBtnW + 6.0F;
        float setW = 82.0F;
        if (mouseX >= setX && mouseX <= setX + setW && mouseY >= bRowY && mouseY <= bRowY + bRowH) {
            UISoundManager.playButtonClick();
            if (this.client != null) {
                this.client.setScreen(new EscapeMenuCustomizerScreen(this));
            }
            return true;
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Unique
    private static void rockstar$insertCoordinatesToActiveNote() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player != null) {
            BlockPos pos = mc.player.getBlockPos();
            String dim = "Верхний мир";
            if (mc.world != null) {
                if (mc.world.getRegistryKey() == World.NETHER) dim = "Незер";
                else if (mc.world.getRegistryKey() == World.END) dim = "Энд";
            }
            String cordStr = String.format("X: %d, Y: %d, Z: %d | %s", pos.getX(), pos.getY(), pos.getZ(), dim);

            List<NotesManager.Note> list = NotesManager.getNotes();
            if (list.isEmpty()) {
                NotesManager.createNote("Координаты", cordStr, cordStr);
            } else {
                NotesManager.Note n = list.get(MathHelper.clamp(rockstar$notesActiveIdx, 0, list.size() - 1));
                n.cords = cordStr;
                n.content += (n.content.isEmpty() ? "" : "\n") + "[📍 " + cordStr + "]";
                NotesManager.updateNote(n.id, n.title, n.content, n.cords);
            }
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
            float volY = cy - 54.0F;
            rockstar$updateVolume(mouseY, volY, 186.0F);
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
                List<NotesManager.Note> list = NotesManager.getNotes();
                if (!list.isEmpty()) {
                    NotesManager.Note n = list.get(MathHelper.clamp(rockstar$notesActiveIdx, 0, list.size() - 1));
                    n.content += chr;
                    NotesManager.updateNote(n.id, n.title, n.content, n.cords);
                    return true;
                }
            }
        }
        return super.charTyped(chr, modifiers);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (rockstar$aiDrawerOpen && rockstar$aiDrawerAnim > 0.5F) {
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
            List<NotesManager.Note> list = NotesManager.getNotes();
            if (!list.isEmpty()) {
                NotesManager.Note n = list.get(MathHelper.clamp(rockstar$notesActiveIdx, 0, list.size() - 1));
                if (keyCode == GLFW.GLFW_KEY_BACKSPACE && !n.content.isEmpty()) {
                    n.content = n.content.substring(0, n.content.length() - 1);
                    NotesManager.updateNote(n.id, n.title, n.content, n.cords);
                    return true;
                }
                if (keyCode == GLFW.GLFW_KEY_ENTER || keyCode == GLFW.GLFW_KEY_KP_ENTER) {
                    n.content += "\n";
                    NotesManager.updateNote(n.id, n.title, n.content, n.cords);
                    return true;
                }
                if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
                    rockstar$notesEditing = false;
                    return true;
                }
            }
        }

        return super.keyPressed(keyCode, scanCode, modifiers);
    }
}
