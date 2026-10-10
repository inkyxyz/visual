package moscow.rockstar.mixin.minecraft.client.gui.screen;

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
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiiIIiIii_Class204;
import rockstar.client.RockstarClient;
import rockstar.client.UISoundManager;
import rockstar.client.iIIIiiIii_Class284;
import rockstar.client.iIIIiiiII_Class285;
import rockstar.client.iIIiIIiIi_Class294;

@Mixin(value={GameMenuScreen.class})
public class GameMenuScreenMixin
extends Screen
implements iIIiIIiIi_Class294 {
    @Shadow
    @Nullable
    private ButtonWidget field_40792;

    @Unique private static float rockstar$flashAlpha = 0.0F;
    @Unique private static boolean rockstar$isPlaying = true;

    // Interactive Media Player State
    @Unique private static final String[] rockstar$playlistTitles = new String[]{
        "Midnight Drive",
        "Aria Math (Cyber Mix)",
        "Pigstep (Lo-Fi)",
        "Neon Dreams",
        "Subwoofer Lullaby"
    };
    @Unique private static final String[] rockstar$playlistArtists = new String[]{
        "Rockstar Sound Team",
        "C418 & SynthLab",
        "Lena Raine (Chillwave)",
        "Antigravity Studio",
        "Daniel Rosenfeld"
    };
    @Unique private static final int[] rockstar$playlistDurations = new int[]{
        214, 310, 148, 195, 208
    };
    @Unique private static int rockstar$currentTrack = 0;
    @Unique private static float rockstar$trackElapsedSec = 42.0F;
    @Unique private static boolean rockstar$isScrubbing = false;
    @Unique private static float[] rockstar$eqFrequencies = new float[]{0.45F, 0.72F, 0.90F, 0.55F, 0.82F, 0.38F};

    // Interactive iOS Calculator State
    @Unique private static String rockstar$calcDisplay = "0";
    @Unique private static double rockstar$calcStored = 0.0;
    @Unique private static String rockstar$calcOp = null;
    @Unique private static boolean rockstar$calcClearNext = false;

    // Volume Drag State
    @Unique private static boolean rockstar$isDraggingVolume = false;

    // Tile Reordering State (Intentional Long Press Hold required: ~480ms)
    @Unique private static int[] rockstar$tileSlots = new int[]{0, 1, 2, 3, 4, 5};
    @Unique private static int rockstar$draggedSlot = -1;
    @Unique private static long rockstar$pressStartTime = 0L;
    @Unique private static int rockstar$pressedCandidateSlot = -1;
    @Unique private static double rockstar$dragOffsetX = 0;
    @Unique private static double rockstar$dragOffsetY = 0;

    protected GameMenuScreenMixin(Text text) {
        super(text);
    }

    @Inject(method={"initWidgets"}, at={@At(value="TAIL")})
    private void rockstar$hideVanillaWidgets(CallbackInfo callbackInfo) {
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

        // Dark frosted backdrop
        custom.drawRect(0.0F, 0.0F, (float)this.width, (float)this.height, new ColorRGBA(0.0F, 0.0F, 0.0F, 125.0F));

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

        // Advance music playback track time and animate equalizer
        if (rockstar$isPlaying && !rockstar$isScrubbing) {
            rockstar$trackElapsedSec += delta * 0.05F;
            int maxDur = rockstar$playlistDurations[rockstar$currentTrack % rockstar$playlistDurations.length];
            if (rockstar$trackElapsedSec >= maxDur) {
                rockstar$trackElapsedSec = 0.0F;
                rockstar$currentTrack = (rockstar$currentTrack + 1) % rockstar$playlistTitles.length;
            }
        }

        // Animate Equalizer bars
        float timeF = (float)(now % 1000000L) / 1000.0F;
        for (int i = 0; i < rockstar$eqFrequencies.length; i++) {
            if (rockstar$isPlaying) {
                float target = (float)(Math.sin(timeF * 8.0F + i * 1.5F) * 0.35F + 0.55F);
                rockstar$eqFrequencies[i] += (target - rockstar$eqFrequencies[i]) * 0.22F;
            } else {
                rockstar$eqFrequencies[i] += (0.15F - rockstar$eqFrequencies[i]) * 0.15F;
            }
        }

        // 6 Blueprint Slot Base Layout Coordinates (Uniform iOS Grid)
        // Slot 0: Media Player Card (112 x 70)
        // Slot 1: Camera Tile (52 x 50)
        // Slot 2: Fullscreen Quick Tile (52 x 50)
        // Slot 3: Master Volume Slider Pill (52 x 108)
        // Slot 4: Large Interactive Calculator (148 x 186)
        // Slot 5: Right 3-Circle Column (48 x 186)
        float[][] defaultBounds = new float[][]{
            { cx - 175.0F, cy - 93.0F, 112.0F, 70.0F },  // 0: Media Player
            { cx - 175.0F, cy - 15.0F, 52.0F, 50.0F },   // 1: Camera
            { cx - 175.0F, cy + 43.0F, 52.0F, 50.0F },   // 2: Fullscreen
            { cx - 115.0F, cy - 15.0F, 52.0F, 108.0F },  // 3: Volume Pill
            { cx - 55.0F, cy - 93.0F, 148.0F, 186.0F },  // 4: Calculator Card
            { cx + 101.0F, cy - 93.0F, 48.0F, 186.0F }   // 5: Right Circles
        };

        // Long-press detection: user MUST hold down for >480ms to enter edit mode!
        boolean inEditMode = rockstar$draggedSlot >= 0;
        if (rockstar$pressedCandidateSlot >= 0 && rockstar$draggedSlot < 0 && (now - rockstar$pressStartTime) > 480L) {
            rockstar$draggedSlot = rockstar$pressedCandidateSlot;
            rockstar$pressedCandidateSlot = -1;
            inEditMode = true;
            UISoundManager.playButtonClick();
        }

        // Draw Slot Blueprint outlines with soft glowing highlight when dragging
        if (inEditMode) {
            for (int s = 0; s < 6; s++) {
                float[] b = defaultBounds[s];
                IIiii_Class8 slotRad = IIiii_Class8.I_method_893b2757(14.0F);
                custom.drawRoundedBorder(b[0], b[1], b[2], b[3], 1.2F, slotRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 55.0F));
            }
        }

        // Render each placed module according to rockstar$tileSlots
        for (int slotIdx = 0; slotIdx < 6; slotIdx++) {
            int moduleType = rockstar$tileSlots[slotIdx];
            float[] b = defaultBounds[slotIdx];
            float drawX = b[0];
            float drawY = b[1];

            boolean isBeingDragged = (rockstar$draggedSlot == slotIdx);
            if (isBeingDragged) {
                drawX = (float)(mouseX - rockstar$dragOffsetX);
                drawY = (float)(mouseY - rockstar$dragOffsetY);
            }

            // Apple iOS Jiggle wiggle animation when in edit mode
            float wiggleAngle = 0.0F;
            if (inEditMode && !isBeingDragged) {
                wiggleAngle = (float) Math.sin((now + slotIdx * 135L) * 0.018) * 1.6F;
            }

            drawContext.getMatrices().push();
            if (Math.abs(wiggleAngle) > 0.01F) {
                float midX = drawX + b[2] / 2.0F;
                float midY = drawY + b[3] / 2.0F;
                drawContext.getMatrices().translate(midX, midY, 0.0F);
                drawContext.getMatrices().multiply(net.minecraft.util.math.RotationAxis.POSITIVE_Z.rotationDegrees(wiggleAngle));
                drawContext.getMatrices().translate(-midX, -midY, 0.0F);
            }

            switch (moduleType) {
                case 0 -> rockstar$renderMediaCard(custom, drawX, drawY, b[2], b[3], font, subFont, tinyFont, mouseX, mouseY);
                case 1 -> rockstar$renderCameraTile(custom, drawX, drawY, b[2], b[3], mouseX, mouseY);
                case 2 -> rockstar$renderFullscreenTile(custom, drawX, drawY, b[2], b[3], mouseX, mouseY);
                case 3 -> rockstar$renderVolumePill(custom, drawX, drawY, b[2], b[3], subFont, mouseX, mouseY);
                case 4 -> rockstar$renderCalculatorCard(custom, drawX, drawY, b[2], b[3], boldFont, font, mouseX, mouseY);
                case 5 -> rockstar$renderActionCircles(custom, drawX, drawY, b[2], b[3], mouseX, mouseY);
            }

            drawContext.getMatrices().pop();
        }

        // Fullscreen Shutter Flash on Screenshot
        if (rockstar$flashAlpha > 0.001F) {
            custom.drawRect(0.0F, 0.0F, (float)this.width, (float)this.height, new ColorRGBA(255.0F, 255.0F, 255.0F, 255.0F * rockstar$flashAlpha));
            rockstar$flashAlpha = Math.max(0.0F, rockstar$flashAlpha - delta * 0.16F);
        }
    }

    // Module 0: Functional Media Player Card with Interactive Scrubber & Animated Equalizer
    @Unique
    private void rockstar$renderMediaCard(III custom, float x, float y, float w, float h, IIiIIi_Class10 font, IIiIIi_Class10 subFont, IIiIIi_Class10 tinyFont, int mx, int my) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(14.0F);
        custom.drawShadow(x, y, w, h, 14.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 90.0F));
        custom.drawBlurredRect(x, y, w, h, 16.0F, 3.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(25.0F, 28.0F, 38.0F, 195.0F));
        custom.drawRoundedBorder(x, y, w, h, 1.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 38.0F));

        int curIdx = rockstar$currentTrack % rockstar$playlistTitles.length;
        String trackTitle = rockstar$playlistTitles[curIdx];
        String artistName = rockstar$playlistArtists[curIdx];
        int totalSec = rockstar$playlistDurations[curIdx];

        // Album artwork thumbnail
        float thumbSz = 24.0F;
        custom.drawRoundedRect(x + 8.0F, y + 8.0F, thumbSz, thumbSz, IIiii_Class8.I_method_893b2757(6.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, 28.0F));
        custom.drawIcon("music", x + 13.0F, y + 13.0F, 14.0F, ColorRGBA.WHITE.withAlpha(220.0F));

        // Animated Equalizer Visualizer Bars next to album art
        float eqStartX = x + 36.0F;
        float eqBaseY = y + 26.0F;
        float barW = 2.0F;
        float barGap = 2.0F;
        for (int b = 0; b < rockstar$eqFrequencies.length; b++) {
            float bH = Math.max(3.0F, rockstar$eqFrequencies[b] * 16.0F);
            float bx = eqStartX + b * (barW + barGap);
            custom.drawRoundedRect(bx, eqBaseY - bH, barW, bH, IIiii_Class8.I_method_893b2757(1.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, rockstar$isPlaying ? 230.0F : 90.0F));
        }

        // AirPlay / WiFi indicator icon in top right
        custom.drawIcon("wifi", x + w - 18.0F, y + 9.0F, 11.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 160.0F));

        // Track title & Artist
        if (font != null) {
            String shortTitle = trackTitle;
            if (shortTitle.length() > 16) shortTitle = shortTitle.substring(0, 15) + "…";
            custom.drawText(font, shortTitle, x + 8.0F, y + 36.0F, ColorRGBA.WHITE);
        }

        // Interactive Progress Scrubber Bar
        float scrubY = y + 49.0F;
        float scrubW = w - 16.0F;
        float scrubH = 3.0F;
        float scrubX = x + 8.0F;
        float progRatio = MathHelper.clamp(rockstar$trackElapsedSec / (float)totalSec, 0.0F, 1.0F);

        custom.drawRoundedRect(scrubX, scrubY, scrubW, scrubH, IIiii_Class8.I_method_893b2757(1.5F), new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F));
        if (progRatio > 0.01F) {
            custom.drawRoundedRect(scrubX, scrubY, scrubW * progRatio, scrubH, IIiii_Class8.I_method_893b2757(1.5F), ColorRGBA.WHITE);
            custom.drawRoundedRect(scrubX + scrubW * progRatio - 2.5F, scrubY - 1.5F, 5.0F, 6.0F, IIiii_Class8.I_method_893b2757(2.5F), ColorRGBA.WHITE);
        }

        // Media controls row (Previous ⏮, Play/Pause ▶/⏸, Next ⏭)
        float ctrlY = y + 55.0F;
        if (subFont != null) {
            // Previous Button
            boolean prevHov = mx >= x + 12.0F && mx <= x + 28.0F && my >= ctrlY - 2.0F && my <= ctrlY + 12.0F;
            custom.drawText(subFont, "⏮", x + 14.0F, ctrlY, prevHov ? ColorRGBA.WHITE : new ColorRGBA(255.0F, 255.0F, 255.0F, 180.0F));

            // Play / Pause Button
            boolean playHov = mx >= x + w / 2.0F - 10.0F && mx <= x + w / 2.0F + 10.0F && my >= ctrlY - 2.0F && my <= ctrlY + 12.0F;
            String playSym = rockstar$isPlaying ? "⏸" : "▶";
            custom.drawText(subFont, playSym, x + w / 2.0F - 4.0F, ctrlY, playHov ? ColorRGBA.WHITE : new ColorRGBA(255.0F, 255.0F, 255.0F, 230.0F));

            // Next Button
            boolean nextHov = mx >= x + w - 28.0F && mx <= x + w - 12.0F && my >= ctrlY - 2.0F && my <= ctrlY + 12.0F;
            custom.drawText(subFont, "⏭", x + w - 26.0F, ctrlY, nextHov ? ColorRGBA.WHITE : new ColorRGBA(255.0F, 255.0F, 255.0F, 180.0F));
        }
    }

    // Module 1: Camera Tile (Screenshot with Shutter Flash)
    @Unique
    private void rockstar$renderCameraTile(III custom, float x, float y, float w, float h, int mx, int my) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(14.0F);
        boolean hov = mx >= x && mx <= x + w && my >= y && my <= y + h;
        custom.drawShadow(x, y, w, h, 12.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 80.0F));
        custom.drawBlurredRect(x, y, w, h, 14.0F, 3.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(25.0F, 28.0F, 38.0F, 190.0F));
        custom.drawRoundedBorder(x, y, w, h, 1.0F, rad, hov ? new ColorRGBA(0.0F, 122.0F, 255.0F, 220.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 35.0F));

        // Circular center pod
        float cirSz = 34.0F;
        float cx = x + (w - cirSz) / 2.0F;
        float cy = y + (h - cirSz) / 2.0F;
        IIiii_Class8 cRad = IIiii_Class8.I_method_893b2757(cirSz / 2.0F);
        custom.drawRoundedRect(cx, cy, cirSz, cirSz, cRad, new ColorRGBA(0.0F, 122.0F, 255.0F, hov ? 255.0F : 210.0F));
        custom.drawIcon("hud/target", cx + 9.0F, cy + 9.0F, 16.0F, ColorRGBA.WHITE);
    }

    // Module 2: Fullscreen Quick Tile
    @Unique
    private void rockstar$renderFullscreenTile(III custom, float x, float y, float w, float h, int mx, int my) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(14.0F);
        boolean hov = mx >= x && mx <= x + w && my >= y && my <= y + h;
        boolean isFs = (MinecraftClient.getInstance() != null && MinecraftClient.getInstance().getWindow().isFullscreen());

        custom.drawShadow(x, y, w, h, 12.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 80.0F));
        custom.drawBlurredRect(x, y, w, h, 14.0F, 3.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(25.0F, 28.0F, 38.0F, 190.0F));
        custom.drawRoundedBorder(x, y, w, h, 1.0F, rad, hov ? new ColorRGBA(52.0F, 199.0F, 89.0F, 220.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 35.0F));

        float cirSz = 34.0F;
        float cx = x + (w - cirSz) / 2.0F;
        float cy = y + (h - cirSz) / 2.0F;
        IIiii_Class8 cRad = IIiii_Class8.I_method_893b2757(cirSz / 2.0F);
        custom.drawRoundedRect(cx, cy, cirSz, cirSz, cRad, isFs ? new ColorRGBA(52.0F, 199.0F, 89.0F, hov ? 255.0F : 220.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, hov ? 40.0F : 20.0F));
        custom.drawIcon("keyboard", cx + 7.0F, cy + 7.0F, 20.0F, ColorRGBA.WHITE);
    }

    // Module 3: Master Volume Vertical Slider Pill
    @Unique
    private void rockstar$renderVolumePill(III custom, float x, float y, float w, float h, IIiIIi_Class10 subFont, int mx, int my) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(w / 2.0F);
        float currentVol = (float)MinecraftClient.getInstance().options.getSoundVolume(SoundCategory.MASTER);

        custom.drawShadow(x, y, w, h, 14.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 90.0F));
        custom.drawBlurredRect(x, y, w, h, 16.0F, 3.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(25.0F, 28.0F, 38.0F, 190.0F));

        // Filled white volume bar rising from bottom
        float fillH = h * MathHelper.clamp(currentVol, 0.0F, 1.0F);
        if (fillH > 4.0F) {
            float fillY = y + h - fillH;
            custom.drawRoundedRect(x, fillY, w, fillH, rad, new ColorRGBA(245.0F, 248.0F, 255.0F, 240.0F));
        }

        custom.drawRoundedBorder(x, y, w, h, 1.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F));

        // Speaker icon at bottom of pill
        ColorRGBA iconCol = (currentVol > 0.25F) ? new ColorRGBA(0.0F, 122.0F, 255.0F, 255.0F) : ColorRGBA.WHITE;
        custom.drawIcon("music", x + (w - 18.0F) / 2.0F, y + h - 26.0F, 18.0F, iconCol);

        // Volume percentage readout at top of pill
        if (subFont != null) {
            String pct = (int)(currentVol * 100.0F) + "%";
            float pw = subFont.I_method_2c375926(pct);
            custom.drawText(subFont, pct, x + (w - pw) / 2.0F, y + 10.0F, (currentVol > 0.85F) ? new ColorRGBA(30.0F, 30.0F, 36.0F, 240.0F) : ColorRGBA.WHITE);
        }
    }

    // Module 4: Interactive iOS Calculator
    @Unique
    private void rockstar$renderCalculatorCard(III custom, float x, float y, float w, float h, IIiIIi_Class10 boldFont, IIiIIi_Class10 font, int mx, int my) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(16.0F);
        custom.drawShadow(x, y, w, h, 18.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 110.0F));
        custom.drawBlurredRect(x, y, w, h, 18.0F, 4.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(18.0F, 20.0F, 28.0F, 220.0F));
        custom.drawRoundedBorder(x, y, w, h, 1.2F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 45.0F));

        // LCD Display Area
        float lcdH = 34.0F;
        float lcdY = y + 8.0F;
        String disp = rockstar$calcDisplay;
        if (disp.length() > 9) disp = disp.substring(0, 9);
        if (boldFont != null) {
            float txtW = boldFont.I_method_2c375926(disp);
            custom.drawText(boldFont, disp, x + w - txtW - 14.0F, lcdY + 10.0F, ColorRGBA.WHITE);
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
        float btnSz = 26.0F;
        float gap = 6.0F;

        for (int r = 0; r < 5; r++) {
            float rowY = gridStartY + r * (btnSz + gap);
            int cols = btnGrid[r].length;
            for (int c = 0; c < cols; c++) {
                String label = btnGrid[r][c];
                float bW = label.equals("0") ? (btnSz * 2.0F + gap) : btnSz;
                float bX = x + 10.0F + (c == 0 ? 0.0F : (r == 4 ? (btnSz * 2.0F + gap + gap + (c - 1) * (btnSz + gap)) : (c * (btnSz + gap))));
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
                    custom.drawText(font, label, lx, rowY + 7.0F, fg);
                }
            }
        }
    }

    // Module 5: Right Column 3 Action Circles (Resume, Settings, Disconnect)
    @Unique
    private void rockstar$renderActionCircles(III custom, float x, float y, float w, float h, int mx, int my) {
        float circleSz = 40.0F;
        float cx = x + (w - circleSz) / 2.0F;
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(circleSz / 2.0F);

        // 1. Resume Game Button (Top: Black circle + White Play)
        float y1 = y + 16.0F;
        boolean hov1 = mx >= cx && mx <= cx + circleSz && my >= y1 && my <= y1 + circleSz;
        custom.drawShadow(cx, y1, circleSz, circleSz, 10.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 80.0F));
        custom.drawRoundedRect(cx, y1, circleSz, circleSz, rad, new ColorRGBA(18.0F, 20.0F, 28.0F, hov1 ? 255.0F : 210.0F));
        custom.drawRoundedBorder(cx, y1, circleSz, circleSz, 1.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, hov1 ? 160.0F : 40.0F));
        custom.drawIcon("play", cx + 13.0F, y1 + 13.0F, 14.0F, ColorRGBA.WHITE);

        // 2. Settings / Options Button (Middle: Frosted circle + Gear)
        float y2 = y + h / 2.0F - circleSz / 2.0F;
        boolean hov2 = mx >= cx && mx <= cx + circleSz && my >= y2 && my <= y2 + circleSz;
        custom.drawShadow(cx, y2, circleSz, circleSz, 10.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 80.0F));
        custom.drawRoundedRect(cx, y2, circleSz, circleSz, rad, new ColorRGBA(40.0F, 44.0F, 56.0F, hov2 ? 255.0F : 210.0F));
        custom.drawRoundedBorder(cx, y2, circleSz, circleSz, 1.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, hov2 ? 160.0F : 40.0F));
        custom.drawIcon("setting", cx + 12.0F, y2 + 12.0F, 16.0F, ColorRGBA.WHITE);

        // 3. Disconnect Button (Bottom: Red circle + Exit door icon)
        float y3 = y + h - circleSz - 16.0F;
        boolean hov3 = mx >= cx && mx <= cx + circleSz && my >= y3 && my <= y3 + circleSz;
        custom.drawShadow(cx, y3, circleSz, circleSz, 12.0F, rad, new ColorRGBA(255.0F, 59.0F, 48.0F, 80.0F));
        custom.drawRoundedRect(cx, y3, circleSz, circleSz, rad, new ColorRGBA(255.0F, 59.0F, 48.0F, hov3 ? 255.0F : 220.0F));
        custom.drawRoundedBorder(cx, y3, circleSz, circleSz, 1.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, hov3 ? 200.0F : 50.0F));
        custom.drawIcon("back", cx + 12.0F, y3 + 12.0F, 16.0F, ColorRGBA.WHITE);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        float cx = this.width / 2.0F;
        float cy = this.height / 2.0F;

        float[][] defaultBounds = new float[][]{
            { cx - 175.0F, cy - 93.0F, 112.0F, 70.0F },  // 0: Media
            { cx - 175.0F, cy - 15.0F, 52.0F, 50.0F },   // 1: Camera
            { cx - 175.0F, cy + 43.0F, 52.0F, 50.0F },   // 2: Fullscreen
            { cx - 115.0F, cy - 15.0F, 52.0F, 108.0F },  // 3: Volume Pill
            { cx - 55.0F, cy - 93.0F, 148.0F, 186.0F },  // 4: Calculator
            { cx + 101.0F, cy - 93.0F, 48.0F, 186.0F }   // 5: Right Circles
        };

        // Check which slot was clicked for intentional long-press drag
        for (int s = 0; s < 6; s++) {
            float[] b = defaultBounds[s];
            if (mouseX >= b[0] && mouseX <= b[0] + b[2] && mouseY >= b[1] && mouseY <= b[1] + b[3]) {
                rockstar$pressedCandidateSlot = s;
                rockstar$pressStartTime = System.currentTimeMillis();
                rockstar$dragOffsetX = mouseX - b[0];
                rockstar$dragOffsetY = mouseY - b[1];
                break;
            }
        }

        // Direct Clicks for Modules
        for (int slotIdx = 0; slotIdx < 6; slotIdx++) {
            int moduleType = rockstar$tileSlots[slotIdx];
            float[] b = defaultBounds[slotIdx];

            // 0. Media Player Controls & Scrubber Click
            if (moduleType == 0 && mouseX >= b[0] && mouseX <= b[0] + b[2] && mouseY >= b[1] && mouseY <= b[1] + b[3]) {
                float scrubY = b[1] + 47.0F;
                float scrubH = 10.0F;
                float scrubX = b[0] + 8.0F;
                float scrubW = b[2] - 16.0F;

                // Scrub Bar Click
                if (mouseY >= scrubY - 3.0F && mouseY <= scrubY + scrubH && mouseX >= scrubX && mouseX <= scrubX + scrubW) {
                    float rel = MathHelper.clamp((float)((mouseX - scrubX) / scrubW), 0.0F, 1.0F);
                    int maxDur = rockstar$playlistDurations[rockstar$currentTrack % rockstar$playlistDurations.length];
                    rockstar$trackElapsedSec = rel * maxDur;
                    rockstar$isScrubbing = true;
                    UISoundManager.playButtonClick();
                    rockstar$pressedCandidateSlot = -1;
                    return true;
                }

                // Previous Button Click
                float ctrlY = b[1] + 53.0F;
                if (mouseY >= ctrlY && mouseY <= b[1] + b[3]) {
                    if (mouseX >= b[0] + 10.0F && mouseX <= b[0] + 32.0F) {
                        rockstar$currentTrack = (rockstar$currentTrack - 1 + rockstar$playlistTitles.length) % rockstar$playlistTitles.length;
                        rockstar$trackElapsedSec = 0.0F;
                        UISoundManager.playButtonClick();
                        rockstar$pressedCandidateSlot = -1;
                        return true;
                    }
                    // Play/Pause Button Click
                    if (mouseX >= b[0] + b[2] / 2.0F - 16.0F && mouseX <= b[0] + b[2] / 2.0F + 16.0F) {
                        rockstar$isPlaying = !rockstar$isPlaying;
                        UISoundManager.playButtonClick();
                        rockstar$pressedCandidateSlot = -1;
                        return true;
                    }
                    // Next Button Click
                    if (mouseX >= b[0] + b[2] - 32.0F && mouseX <= b[0] + b[2] - 10.0F) {
                        rockstar$currentTrack = (rockstar$currentTrack + 1) % rockstar$playlistTitles.length;
                        rockstar$trackElapsedSec = 0.0F;
                        UISoundManager.playButtonClick();
                        rockstar$pressedCandidateSlot = -1;
                        return true;
                    }
                }

                // General card click toggles play/pause
                rockstar$isPlaying = !rockstar$isPlaying;
                UISoundManager.playButtonClick();
                rockstar$pressedCandidateSlot = -1;
                return true;
            }

            // 1. Camera / Screenshot Click
            if (moduleType == 1 && mouseX >= b[0] && mouseX <= b[0] + b[2] && mouseY >= b[1] && mouseY <= b[1] + b[3]) {
                rockstar$flashAlpha = 1.0F;
                UISoundManager.playButtonClick();
                rockstar$pressedCandidateSlot = -1;
                if (this.client != null && this.client.getFramebuffer() != null) {
                    ScreenshotRecorder.saveScreenshot(this.client.runDirectory, this.client.getFramebuffer(), msg -> {
                        if (this.client != null) this.client.execute(() -> this.client.inGameHud.getChatHud().addMessage(msg));
                    });
                }
                return true;
            }

            // 2. Fullscreen Quick Tile Click
            if (moduleType == 2 && mouseX >= b[0] && mouseX <= b[0] + b[2] && mouseY >= b[1] && mouseY <= b[1] + b[3]) {
                UISoundManager.playButtonClick();
                rockstar$pressedCandidateSlot = -1;
                if (this.client != null) {
                    this.client.getWindow().toggleFullscreen();
                }
                return true;
            }

            // 3. Volume Pill Drag
            if (moduleType == 3 && mouseX >= b[0] && mouseX <= b[0] + b[2] && mouseY >= b[1] && mouseY <= b[1] + b[3]) {
                rockstar$isDraggingVolume = true;
                rockstar$pressedCandidateSlot = -1;
                rockstar$updateVolume(mouseY, b[1], b[3]);
                return true;
            }

            // 4. Calculator Click
            if (moduleType == 4 && mouseX >= b[0] && mouseX <= b[0] + b[2] && mouseY >= b[1] && mouseY <= b[1] + b[3]) {
                if (rockstar$handleCalcClick(mouseX, mouseY, b[0], b[1], b[2], b[3])) {
                    rockstar$pressedCandidateSlot = -1;
                    return true;
                }
            }

            // 5. Right Action Circles Click (Resume, Settings, Disconnect / Leave)
            if (moduleType == 5 && mouseX >= b[0] - 4.0F && mouseX <= b[0] + b[2] + 4.0F) {
                float circleSz = 40.0F;
                float y1 = b[1] + 16.0F;
                float y2 = b[1] + b[3] / 2.0F - circleSz / 2.0F;
                float y3 = b[1] + b[3] - circleSz - 16.0F;

                // Resume Game
                if (mouseY >= b[1] && mouseY <= y1 + circleSz + 8.0F) {
                    UISoundManager.playButtonClick();
                    rockstar$pressedCandidateSlot = -1;
                    this.close();
                    return true;
                }
                // Options / Settings
                if (mouseY >= y2 - 8.0F && mouseY <= y2 + circleSz + 8.0F) {
                    UISoundManager.playButtonClick();
                    rockstar$pressedCandidateSlot = -1;
                    if (this.client != null) {
                        this.client.setScreen(new OptionsScreen(this, this.client.options));
                    }
                    return true;
                }
                // Disconnect / Leave (Clean Singleplayer + Multiplayer support)
                if (mouseY >= y3 - 8.0F && mouseY <= b[1] + b[3] + 8.0F) {
                    UISoundManager.playButtonClick();
                    rockstar$pressedCandidateSlot = -1;
                    this.disconnect();
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
            float volY = cy - 15.0F;
            rockstar$updateVolume(mouseY, volY, 108.0F);
            return true;
        }

        if (rockstar$isScrubbing) {
            float cx = this.width / 2.0F;
            float cy = this.height / 2.0F;
            float mediaX = cx - 175.0F + 8.0F;
            float scrubW = 112.0F - 16.0F;
            float rel = MathHelper.clamp((float)((mouseX - mediaX) / scrubW), 0.0F, 1.0F);
            int maxDur = rockstar$playlistDurations[rockstar$currentTrack % rockstar$playlistDurations.length];
            rockstar$trackElapsedSec = rel * maxDur;
            return true;
        }

        return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        rockstar$isDraggingVolume = false;
        rockstar$isScrubbing = false;
        rockstar$pressedCandidateSlot = -1;

        if (rockstar$draggedSlot >= 0) {
            float cx = this.width / 2.0F;
            float cy = this.height / 2.0F;
            float[][] defaultBounds = new float[][]{
                { cx - 175.0F, cy - 93.0F, 112.0F, 70.0F },
                { cx - 175.0F, cy - 15.0F, 52.0F, 50.0F },
                { cx - 175.0F, cy + 43.0F, 52.0F, 50.0F },
                { cx - 115.0F, cy - 15.0F, 52.0F, 108.0F },
                { cx - 55.0F, cy - 93.0F, 148.0F, 186.0F },
                { cx + 101.0F, cy - 93.0F, 48.0F, 186.0F }
            };

            // Find closest slot
            int closestSlot = 0;
            double minDist = Double.MAX_VALUE;
            for (int s = 0; s < 6; s++) {
                double dx = mouseX - (defaultBounds[s][0] + defaultBounds[s][2] / 2.0F);
                double dy = mouseY - (defaultBounds[s][1] + defaultBounds[s][3] / 2.0F);
                double d = dx * dx + dy * dy;
                if (d < minDist) {
                    minDist = d;
                    closestSlot = s;
                }
            }

            // Swap positions
            int temp = rockstar$tileSlots[rockstar$draggedSlot];
            rockstar$tileSlots[rockstar$draggedSlot] = rockstar$tileSlots[closestSlot];
            rockstar$tileSlots[closestSlot] = temp;

            rockstar$draggedSlot = -1;
            UISoundManager.playButtonClick();
            return true;
        }

        return super.mouseReleased(mouseX, mouseY, button);
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
        float lcdH = 34.0F;
        float gridStartY = y + 8.0F + lcdH + 4.0F;
        float btnSz = 26.0F;
        float gap = 6.0F;

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
                float bX = x + 10.0F + (c == 0 ? 0.0F : (r == 4 ? (btnSz * 2.0F + gap + gap + (c - 1) * (btnSz + gap)) : (c * (btnSz + gap))));

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
    private void reconnect() {
        ServerInfo serverInfo;
        if (iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c) && GameMenuScreenMixin.I_field_3a9bda27.world.getDifficulty() == Difficulty.HARD) {
            try {
                GameMenuScreenMixin.I_field_3a9bda27.player.networkHandler.sendChatCommand(".rct");
            } catch (Exception ignored) {}
        }
        if ((serverInfo = I_field_3a9bda27.getCurrentServerEntry()) == null) {
            return;
        }
        ServerAddress serverAddress = ServerAddress.parse((String)serverInfo.address);
        I_field_3a9bda27.getAbuseReportContext().tryShowDraftScreen(I_field_3a9bda27, (Screen)(Object)this, this::disconnect, true);
        new Thread(() -> {
            try {
                Thread.sleep(1200L);
            } catch (Exception ignored) {}
            I_field_3a9bda27.execute(() -> ConnectScreen.connect((Screen)new MultiplayerScreen((Screen)new TitleScreen()), (MinecraftClient)I_field_3a9bda27, (ServerAddress)serverAddress, (ServerInfo)serverInfo, (boolean)false, null));
        }).start();
    }

    // Clean, reliable Disconnect supporting singleplayer integrated server & multiplayer realms/servers
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
}
