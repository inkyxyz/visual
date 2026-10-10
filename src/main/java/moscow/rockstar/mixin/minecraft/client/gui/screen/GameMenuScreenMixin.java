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
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
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
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.IiiIIiIii_Class204;
import rockstar.client.RockstarClient;
import rockstar.client.UISoundManager;
import rockstar.client.iIIIiiIii_Class284;
import rockstar.client.iIIIiiiII_Class285;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iiIiIIIiI_Class419;
import org.lwjgl.glfw.GLFW;
import rockstar.client.BrowserScreen;
import rockstar.client.SnakeScreen;
import rockstar.client.MinesweeperScreen;

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

    // Bottom Search & Mini-games State
    @Unique private static String rockstar$searchText = "";
    @Unique private static boolean rockstar$searchFocused = false;

    // Per-tile hover float animations ("что бы наводишься а оно выплывает")
    @Unique private static final float[] rockstar$tileHoverAnim = new float[6];

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

        // Dark frosted backdrop with Liquid Glass tint
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

        // 6 Frozen Layout Slots (Permanent and unmovable as requested: "запрети перемещать")
        // Balanced layout with proper heights:
        // Slot 0: Browser Media Player (114 x 74)
        // Slot 1: Camera Quick Tile (53 x 50)
        // Slot 2: Fullscreen Quick Tile (53 x 50)
        // Slot 3: Master Volume Slider Pill (53 x 108)
        // Slot 4: Interactive iOS Calculator (150 x 192) - completely contained!
        // Slot 5: Right Squircle Column (52 x 192) - Resume, Settings, Disconnect well separated!
        float[][] bounds = new float[][]{
            { cx - 180.0F, cy - 98.0F, 114.0F, 74.0F },  // 0: Media Player
            { cx - 180.0F, cy - 16.0F, 53.0F, 50.0F },   // 1: Camera
            { cx - 180.0F, cy + 42.0F, 53.0F, 50.0F },   // 2: Fullscreen
            { cx - 119.0F, cy - 16.0F, 53.0F, 108.0F },  // 3: Volume Pill
            { cx - 58.0F,  cy - 98.0F, 150.0F, 192.0F }, // 4: Calculator Card
            { cx + 100.0F, cy - 98.0F, 52.0F,  192.0F }  // 5: Right Column Squircles
        };

        // Smooth Floating Elevation Hover Animation for all cards
        for (int i = 0; i < 6; i++) {
            float[] b = bounds[i];
            boolean isHov = (mouseX >= b[0] && mouseX <= b[0] + b[2] && mouseY >= b[1] && mouseY <= b[1] + b[3]);
            float target = isHov ? 1.0F : 0.0F;
            rockstar$tileHoverAnim[i] += (target - rockstar$tileHoverAnim[i]) * 0.20F;
        }

        // Render each module in place with hover float offset
        for (int slotIdx = 0; slotIdx < 6; slotIdx++) {
            float[] b = bounds[slotIdx];
            float hoverA = rockstar$tileHoverAnim[slotIdx];
            float drawX = b[0];
            float drawY = b[1] - hoverA * 4.5F; // Physical float-up elevation on hover!

            drawContext.getMatrices().push();
            switch (slotIdx) {
                case 0 -> rockstar$renderMediaCard(custom, drawX, drawY, b[2], b[3], font, subFont, tinyFont, mouseX, mouseY, hoverA, snap, tracker);
                case 1 -> rockstar$renderCameraTile(custom, drawX, drawY, b[2], b[3], mouseX, mouseY, hoverA);
                case 2 -> rockstar$renderFullscreenTile(custom, drawX, drawY, b[2], b[3], mouseX, mouseY, hoverA);
                case 3 -> rockstar$renderVolumePill(custom, drawX, drawY, b[2], b[3], subFont, mouseX, mouseY, hoverA);
                case 4 -> rockstar$renderCalculatorCard(custom, drawX, drawY, b[2], b[3], boldFont, font, mouseX, mouseY, hoverA);
                case 5 -> rockstar$renderActionSquircles(custom, drawX, drawY, b[2], b[3], mouseX, mouseY, hoverA);
            }
            drawContext.getMatrices().pop();
        }

        // --- BOTTOM SEARCH BAR & MINI-GAMES BAR ---
        float bRowY = cy + 104.0F;
        float bRowH = 34.0F;
        float bStartX = cx - 180.0F;
        float sWidth = 220.0F;

        IIiii_Class8 sRad = IIiii_Class8.I_method_893b2757(10.0F);
        boolean sHover = mouseX >= bStartX && mouseX <= bStartX + sWidth && mouseY >= bRowY && mouseY <= bRowY + bRowH;
        custom.drawShadow(bStartX, bRowY, sWidth, bRowH, 12.0F, sRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 80.0F));
        custom.drawBlurredRect(bStartX, bRowY, sWidth, bRowH, 14.0F, 3.0F, sRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));
        custom.drawRoundedRect(bStartX, bRowY, sWidth, bRowH, sRad, new ColorRGBA(22.0F, 26.0F, 36.0F, 215.0F));
        custom.drawRoundedBorder(bStartX, bRowY, sWidth, bRowH, 1.2F, sRad, rockstar$searchFocused ? IiiiiIIIi_Class242.I_method_7df8e08e() : (sHover ? new ColorRGBA(255.0F, 255.0F, 255.0F, 80.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 38.0F)));

        if (font != null) {
            String sPrompt = rockstar$searchText.isEmpty() ? (rockstar$searchFocused ? "" : "🔍 Поиск в Google... (Enter)") : rockstar$searchText;
            if (rockstar$searchFocused && (System.currentTimeMillis() % 1000L < 500L)) sPrompt += "|";
            ColorRGBA sCol = rockstar$searchText.isEmpty() ? new ColorRGBA(255.0F, 255.0F, 255.0F, 140.0F) : ColorRGBA.WHITE;
            custom.drawText(font, sPrompt, bStartX + 12.0F, bRowY + 11.0F, sCol);
        }

        // Snake Button (Змейка)
        float snakeX = bStartX + sWidth + 8.0F;
        float gBtnW = 48.0F;
        boolean snakeHov = mouseX >= snakeX && mouseX <= snakeX + gBtnW && mouseY >= bRowY && mouseY <= bRowY + bRowH;
        custom.drawShadow(snakeX, bRowY, gBtnW, bRowH, 10.0F, sRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 70.0F));
        custom.drawRoundedRect(snakeX, bRowY, gBtnW, bRowH, sRad, new ColorRGBA(26.0F, 32.0F, 46.0F, snakeHov ? 255.0F : 210.0F));
        custom.drawRoundedBorder(snakeX, bRowY, gBtnW, bRowH, 1.2F, sRad, snakeHov ? new ColorRGBA(52.0F, 199.0F, 89.0F, 220.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F));
        float snIconSz = 22.0F;
        custom.drawTexture(RockstarClient.id("icons/snake.png"), snakeX + (gBtnW - snIconSz) / 2.0F, bRowY + (bRowH - snIconSz) / 2.0F, snIconSz, snIconSz, snakeHov ? ColorRGBA.WHITE : ColorRGBA.WHITE.withAlpha(220.0F));
        if (snakeHov && subFont != null) {
            float ttW = subFont.I_method_2c375926("Змейка") + 12.0F;
            float ttX = snakeX + (gBtnW - ttW) / 2.0F;
            float ttY = bRowY - 18.0F;
            custom.drawRoundedRect(ttX, ttY, ttW, 14.0F, IIiii_Class8.I_method_893b2757(4.0F), new ColorRGBA(18.0F, 20.0F, 28.0F, 230.0F));
            custom.drawRoundedBorder(ttX, ttY, ttW, 14.0F, 1.0F, IIiii_Class8.I_method_893b2757(4.0F), new ColorRGBA(52.0F, 199.0F, 89.0F, 180.0F));
            custom.drawText(subFont, "Змейка", ttX + 6.0F, ttY + 3.0F, ColorRGBA.WHITE);
        }

        // Minesweeper Button (Сапёр)
        float mineX = snakeX + gBtnW + 8.0F;
        float mBtnW = 48.0F;
        boolean mineHov = mouseX >= mineX && mouseX <= mineX + mBtnW && mouseY >= bRowY && mouseY <= bRowY + bRowH;
        custom.drawShadow(mineX, bRowY, mBtnW, bRowH, 10.0F, sRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 70.0F));
        custom.drawRoundedRect(mineX, bRowY, mBtnW, bRowH, sRad, new ColorRGBA(26.0F, 32.0F, 46.0F, mineHov ? 255.0F : 210.0F));
        custom.drawRoundedBorder(mineX, bRowY, mBtnW, bRowH, 1.2F, sRad, mineHov ? new ColorRGBA(255.0F, 59.0F, 48.0F, 220.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F));
        float mnIconSz = 22.0F;
        custom.drawTexture(RockstarClient.id("icons/mine.png"), mineX + (mBtnW - mnIconSz) / 2.0F, bRowY + (bRowH - mnIconSz) / 2.0F, mnIconSz, mnIconSz, mineHov ? ColorRGBA.WHITE : ColorRGBA.WHITE.withAlpha(220.0F));
        if (mineHov && subFont != null) {
            float ttW = subFont.I_method_2c375926("Сапёр") + 12.0F;
            float ttX = mineX + (mBtnW - ttW) / 2.0F;
            float ttY = bRowY - 18.0F;
            custom.drawRoundedRect(ttX, ttY, ttW, 14.0F, IIiii_Class8.I_method_893b2757(4.0F), new ColorRGBA(18.0F, 20.0F, 28.0F, 230.0F));
            custom.drawRoundedBorder(ttX, ttY, ttW, 14.0F, 1.0F, IIiii_Class8.I_method_893b2757(4.0F), new ColorRGBA(255.0F, 59.0F, 48.0F, 180.0F));
            custom.drawText(subFont, "Сапёр", ttX + 6.0F, ttY + 3.0F, ColorRGBA.WHITE);
        }

        // Fullscreen Shutter Flash on Screenshot
        if (rockstar$flashAlpha > 0.001F) {
            custom.drawRect(0.0F, 0.0F, (float)this.width, (float)this.height, new ColorRGBA(255.0F, 255.0F, 255.0F, 255.0F * rockstar$flashAlpha));
            rockstar$flashAlpha = Math.max(0.0F, rockstar$flashAlpha - delta * 0.16F);
        }
    }

    // Module 0: Functional Real Browser Media Player Card (Windows SMTC / Chrome / Spotify / VK)
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
        String artistName = hasTrack ? snap.i_method_c7076446() : "Включите трек в браузере";
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

        // Track title & Artist
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

        // Media controls row (Previous ⏮, Play/Pause ▶/⏸, Next ⏭)
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

    // Module 1: Camera Tile (Screenshot with Shutter Flash)
    @Unique
    private void rockstar$renderCameraTile(III custom, float x, float y, float w, float h, int mx, int my, float hoverA) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(14.0F);
        boolean hov = mx >= x && mx <= x + w && my >= y && my <= y + h;
        custom.drawShadow(x, y, w, h, 12.0F + 6.0F * hoverA, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 80.0F + 30.0F * hoverA));
        custom.drawBlurredRect(x, y, w, h, 14.0F, 3.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(22.0F, 26.0F, 36.0F, 195.0F));
        custom.drawRoundedBorder(x, y, w, h, 1.0F, rad, hov ? new ColorRGBA(0.0F, 122.0F, 255.0F, 220.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 35.0F));

        // Squircle center icon pod
        float podSz = 32.0F;
        float px = x + (w - podSz) / 2.0F;
        float py = y + (h - podSz) / 2.0F;
        IIiii_Class8 pRad = IIiii_Class8.I_method_893b2757(10.0F);
        custom.drawRoundedRect(px, py, podSz, podSz, pRad, new ColorRGBA(0.0F, 122.0F, 255.0F, hov ? 255.0F : 210.0F));
        custom.drawIcon("hud/target", px + 8.0F, py + 8.0F, 16.0F, ColorRGBA.WHITE);
    }

    // Module 2: Fullscreen Quick Tile
    @Unique
    private void rockstar$renderFullscreenTile(III custom, float x, float y, float w, float h, int mx, int my, float hoverA) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(14.0F);
        boolean hov = mx >= x && mx <= x + w && my >= y && my <= y + h;
        boolean isFs = (MinecraftClient.getInstance() != null && MinecraftClient.getInstance().getWindow().isFullscreen());

        custom.drawShadow(x, y, w, h, 12.0F + 6.0F * hoverA, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 80.0F + 30.0F * hoverA));
        custom.drawBlurredRect(x, y, w, h, 14.0F, 3.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(22.0F, 26.0F, 36.0F, 195.0F));
        custom.drawRoundedBorder(x, y, w, h, 1.0F, rad, hov ? new ColorRGBA(52.0F, 199.0F, 89.0F, 220.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 35.0F));

        float podSz = 32.0F;
        float px = x + (w - podSz) / 2.0F;
        float py = y + (h - podSz) / 2.0F;
        IIiii_Class8 pRad = IIiii_Class8.I_method_893b2757(10.0F);
        custom.drawRoundedRect(px, py, podSz, podSz, pRad, isFs ? new ColorRGBA(52.0F, 199.0F, 89.0F, hov ? 255.0F : 220.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, hov ? 40.0F : 20.0F));
        custom.drawIcon("keyboard", px + 6.0F, py + 6.0F, 20.0F, ColorRGBA.WHITE);
    }

    // Module 3: Master Volume Vertical Slider Pill
    @Unique
    private void rockstar$renderVolumePill(III custom, float x, float y, float w, float h, IIiIIi_Class10 subFont, int mx, int my, float hoverA) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(w / 2.0F);
        float currentVol = (float)MinecraftClient.getInstance().options.getSoundVolume(SoundCategory.MASTER);

        custom.drawShadow(x, y, w, h, 14.0F + 6.0F * hoverA, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 90.0F + 30.0F * hoverA));
        custom.drawBlurredRect(x, y, w, h, 16.0F, 3.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(22.0F, 26.0F, 36.0F, 195.0F));

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

    // Module 4: Interactive iOS Calculator - Clean layout with bottom row 100% inside card
    @Unique
    private void rockstar$renderCalculatorCard(III custom, float x, float y, float w, float h, IIiIIi_Class10 boldFont, IIiIIi_Class10 font, int mx, int my, float hoverA) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(16.0F);
        custom.drawShadow(x, y, w, h, 18.0F + 8.0F * hoverA, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 110.0F + 40.0F * hoverA));
        custom.drawBlurredRect(x, y, w, h, 18.0F, 4.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(18.0F, 20.0F, 28.0F, 220.0F));
        custom.drawRoundedBorder(x, y, w, h, 1.2F, rad, hoverA > 0.01F ? new ColorRGBA(255.0F, 255.0F, 255.0F, 140.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 45.0F));

        // LCD Display Area
        float lcdH = 28.0F;
        float lcdY = y + 8.0F;
        String disp = rockstar$calcDisplay;
        if (disp.length() > 9) disp = disp.substring(0, 9);
        if (boldFont != null) {
            float txtW = boldFont.I_method_2c375926(disp);
            custom.drawText(boldFont, disp, x + w - txtW - 14.0F, lcdY + 8.0F, ColorRGBA.WHITE);
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
        float btnSz = 25.0F;
        float gap = 4.5F;

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
                    custom.drawText(font, label, lx, rowY + 6.5F, fg);
                }
            }
        }
    }

    // Module 5: Right Column 3 Squircles (Resume, Settings, Disconnect - Separated & Rounded-Square!)
    @Unique
    private void rockstar$renderActionSquircles(III custom, float x, float y, float w, float h, int mx, int my, float hoverA) {
        float btnSz = 48.0F;
        float bx = x + (w - btnSz) / 2.0F;
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(12.0F); // Sleek rounded-square squircle!
        ColorRGBA theme = IiiiiIIIi_Class242.I_method_7df8e08e();

        // 1. Resume Game Button (Top Squircle: Dark Frosted + Play Icon)
        float y1 = y + 4.0F;
        boolean hov1 = mx >= bx && mx <= bx + btnSz && my >= y1 && my <= y1 + btnSz;
        custom.drawShadow(bx, y1, btnSz, btnSz, 10.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 80.0F));
        custom.drawRoundedRect(bx, y1, btnSz, btnSz, rad, new ColorRGBA(22.0F, 26.0F, 36.0F, hov1 ? 255.0F : 210.0F));
        custom.drawRoundedBorder(bx, y1, btnSz, btnSz, 1.2F, rad, hov1 ? theme : new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F));
        custom.drawIcon("play", bx + 17.0F, y1 + 17.0F, 14.0F, ColorRGBA.WHITE);

        // 2. Settings / Options Button (Middle Squircle: Frosted Accent + Clear Gear Icon)
        float y2 = y + h / 2.0F - btnSz / 2.0F;
        boolean hov2 = mx >= bx && mx <= bx + btnSz && my >= y2 && my <= y2 + btnSz;
        custom.drawShadow(bx, y2, btnSz, btnSz, 10.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 80.0F));
        custom.drawRoundedRect(bx, y2, btnSz, btnSz, rad, new ColorRGBA(36.0F, 42.0F, 56.0F, hov2 ? 255.0F : 210.0F));
        custom.drawRoundedBorder(bx, y2, btnSz, btnSz, 1.2F, rad, hov2 ? theme : new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F));
        custom.drawIcon("setting", bx + 16.0F, y2 + 16.0F, 16.0F, ColorRGBA.WHITE);

        // 3. Disconnect Button (Far Bottom Squircle: Alert Crimson Squircle + Distinct Exit Door)
        float y3 = y + h - btnSz - 4.0F;
        boolean hov3 = mx >= bx && mx <= bx + btnSz && my >= y3 && my <= y3 + btnSz;
        custom.drawShadow(bx, y3, btnSz, btnSz, 12.0F, rad, new ColorRGBA(255.0F, 59.0F, 48.0F, 80.0F));
        custom.drawRoundedRect(bx, y3, btnSz, btnSz, rad, new ColorRGBA(235.0F, 55.0F, 50.0F, hov3 ? 255.0F : 215.0F));
        custom.drawRoundedBorder(bx, y3, btnSz, btnSz, 1.2F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, hov3 ? 220.0F : 60.0F));
        custom.drawIcon("back", bx + 16.0F, y3 + 16.0F, 16.0F, ColorRGBA.WHITE);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        float cx = this.width / 2.0F;
        float cy = this.height / 2.0F;

        float[][] bounds = new float[][]{
            { cx - 180.0F, cy - 98.0F, 114.0F, 74.0F },  // 0: Media
            { cx - 180.0F, cy - 16.0F, 53.0F, 50.0F },   // 1: Camera
            { cx - 180.0F, cy + 42.0F, 53.0F, 50.0F },   // 2: Fullscreen
            { cx - 119.0F, cy - 16.0F, 53.0F, 108.0F },  // 3: Volume Pill
            { cx - 58.0F,  cy - 98.0F, 150.0F, 192.0F }, // 4: Calculator
            { cx + 100.0F, cy - 98.0F, 52.0F,  192.0F }  // 5: Right Squircles
        };

        // 0. Media Player Controls Click
        float[] b0 = bounds[0];
        if (mouseX >= b0[0] && mouseX <= b0[0] + b0[2] && mouseY >= b0[1] && mouseY <= b0[1] + b0[3]) {
            iiIiIIIiI_Class419 tracker = RockstarClient.getInstance().I_method_be969482();
            float ctrlY = b0[1] + 55.0F;
            if (mouseY >= ctrlY && mouseY <= b0[1] + b0[3]) {
                // Previous
                if (mouseX >= b0[0] + 10.0F && mouseX <= b0[0] + 32.0F) {
                    if (tracker != null && tracker.I_method_9b92c97b() != null) tracker.I_method_9b92c97b().previous();
                    UISoundManager.playButtonClick();
                    return true;
                }
                // Play / Pause
                if (mouseX >= b0[0] + b0[2] / 2.0F - 16.0F && mouseX <= b0[0] + b0[2] / 2.0F + 16.0F) {
                    if (tracker != null && tracker.I_method_9b92c97b() != null) tracker.I_method_9b92c97b().playPause();
                    UISoundManager.playButtonClick();
                    return true;
                }
                // Next
                if (mouseX >= b0[0] + b0[2] - 32.0F && mouseX <= b0[0] + b0[2] - 10.0F) {
                    if (tracker != null && tracker.I_method_9b92c97b() != null) tracker.I_method_9b92c97b().next();
                    UISoundManager.playButtonClick();
                    return true;
                }
            }

            // General click toggles play/pause on browser
            if (tracker != null && tracker.I_method_9b92c97b() != null) {
                tracker.I_method_9b92c97b().playPause();
            }
            UISoundManager.playButtonClick();
            return true;
        }

        // 1. Camera / Screenshot Click
        float[] b1 = bounds[1];
        if (mouseX >= b1[0] && mouseX <= b1[0] + b1[2] && mouseY >= b1[1] && mouseY <= b1[1] + b1[3]) {
            rockstar$flashAlpha = 1.0F;
            UISoundManager.playButtonClick();
            if (this.client != null && this.client.getFramebuffer() != null) {
                ScreenshotRecorder.saveScreenshot(this.client.runDirectory, this.client.getFramebuffer(), msg -> {
                    if (this.client != null) this.client.execute(() -> this.client.inGameHud.getChatHud().addMessage(msg));
                });
            }
            return true;
        }

        // 2. Fullscreen Quick Tile Click
        float[] b2 = bounds[2];
        if (mouseX >= b2[0] && mouseX <= b2[0] + b2[2] && mouseY >= b2[1] && mouseY <= b2[1] + b2[3]) {
            UISoundManager.playButtonClick();
            if (this.client != null) {
                this.client.getWindow().toggleFullscreen();
            }
            return true;
        }

        // 3. Volume Pill Drag Click
        float[] b3 = bounds[3];
        if (mouseX >= b3[0] && mouseX <= b3[0] + b3[2] && mouseY >= b3[1] && mouseY <= b3[1] + b3[3]) {
            rockstar$isDraggingVolume = true;
            rockstar$updateVolume(mouseY, b3[1], b3[3]);
            return true;
        }

        // 4. Calculator Click
        float[] b4 = bounds[4];
        if (mouseX >= b4[0] && mouseX <= b4[0] + b4[2] && mouseY >= b4[1] && mouseY <= b4[1] + b4[3]) {
            if (rockstar$handleCalcClick(mouseX, mouseY, b4[0], b4[1], b4[2], b4[3])) {
                return true;
            }
        }

        // 5. Right Action Squircles Click (Resume, Settings, Disconnect)
        float[] b5 = bounds[5];
        if (mouseX >= b5[0] - 4.0F && mouseX <= b5[0] + b5[2] + 4.0F) {
            float btnSz = 48.0F;
            float y1 = b5[1] + 4.0F;
            float y2 = b5[1] + b5[3] / 2.0F - btnSz / 2.0F;
            float y3 = b5[1] + b5[3] - btnSz - 4.0F;

            // Resume Game
            if (mouseY >= y1 && mouseY <= y1 + btnSz) {
                UISoundManager.playButtonClick();
                this.close();
                return true;
            }
            // Options / Settings
            if (mouseY >= y2 && mouseY <= y2 + btnSz) {
                UISoundManager.playButtonClick();
                if (this.client != null) {
                    this.client.setScreen(new OptionsScreen(this, this.client.options));
                }
                return true;
            }
            // Disconnect / Leave
            if (mouseY >= y3 && mouseY <= y3 + btnSz) {
                UISoundManager.playButtonClick();
                this.disconnect();
                return true;
            }
        }

        // 6. Bottom Row: Search Bar, Snake, Minesweeper Clicks
        float bRowY = cy + 104.0F;
        float bRowH = 34.0F;
        float bStartX = cx - 180.0F;
        float sWidth = 220.0F;
        float snakeX = bStartX + sWidth + 8.0F;
        float gBtnW = 48.0F;
        float mineX = snakeX + gBtnW + 8.0F;
        float mBtnW = 48.0F;

        // Search Bar click
        if (mouseX >= bStartX && mouseX <= bStartX + sWidth && mouseY >= bRowY && mouseY <= bRowY + bRowH) {
            rockstar$searchFocused = true;
            UISoundManager.playButtonClick();
            return true;
        } else {
            rockstar$searchFocused = false;
        }

        // Snake button click
        if (mouseX >= snakeX && mouseX <= snakeX + gBtnW && mouseY >= bRowY && mouseY <= bRowY + bRowH) {
            UISoundManager.playButtonClick();
            if (this.client != null) {
                this.client.setScreen(new SnakeScreen(this));
            }
            return true;
        }

        // Minesweeper button click
        if (mouseX >= mineX && mouseX <= mineX + mBtnW && mouseY >= bRowY && mouseY <= bRowY + bRowH) {
            UISoundManager.playButtonClick();
            if (this.client != null) {
                this.client.setScreen(new MinesweeperScreen(this));
            }
            return true;
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        if (rockstar$isDraggingVolume) {
            float cy = this.height / 2.0F;
            float volY = cy - 16.0F;
            rockstar$updateVolume(mouseY, volY, 108.0F);
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
    private static void rockstar$updateVolume(double mouseY, float y, float h) {
        float rel = 1.0F - (float)((mouseY - y) / h);
        float newVol = MathHelper.clamp(rel, 0.0F, 1.0F);
        if (MinecraftClient.getInstance() != null) {
            MinecraftClient.getInstance().options.getSoundVolumeOption(SoundCategory.MASTER).setValue((double)newVol);
        }
    }

    @Unique
    private static boolean rockstar$handleCalcClick(double mx, double my, float x, float y, float w, float h) {
        float lcdH = 28.0F;
        float gridStartY = y + 8.0F + lcdH + 4.0F;
        float btnSz = 25.0F;
        float gap = 4.5F;

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

    @Override
    public boolean charTyped(char chr, int modifiers) {
        if (rockstar$searchFocused) {
            if (chr >= 32 && chr != 127) {
                rockstar$searchText += chr;
                return true;
            }
        }
        return super.charTyped(chr, modifiers);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (rockstar$searchFocused) {
            if (keyCode == GLFW.GLFW_KEY_BACKSPACE && !rockstar$searchText.isEmpty()) {
                rockstar$searchText = rockstar$searchText.substring(0, rockstar$searchText.length() - 1);
                return true;
            }
            if (keyCode == GLFW.GLFW_KEY_ENTER || keyCode == GLFW.GLFW_KEY_KP_ENTER) {
                String q = rockstar$searchText;
                rockstar$searchFocused = false;
                UISoundManager.playButtonClick();
                if (this.client != null) {
                    this.client.setScreen(new BrowserScreen(this, q));
                }
                return true;
            }
            if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
                rockstar$searchFocused = false;
                return true;
            }
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }
}

