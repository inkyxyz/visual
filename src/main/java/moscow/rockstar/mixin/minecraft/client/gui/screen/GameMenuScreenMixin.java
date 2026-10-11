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
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.BrowserScreen;
import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiiIIiIii_Class204;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.MinesweeperScreen;
import rockstar.client.RockstarClient;
import rockstar.client.SnakeScreen;
import rockstar.client.UISoundManager;
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

    // Bottom Search & Mini-games State
    @Unique private static String rockstar$searchText = "";
    @Unique private static boolean rockstar$searchFocused = false;

    // Per-tile hover animations
    @Unique private static final float[] rockstar$tileHoverAnim = new float[7];

    // Draggable Widgets Offsets & Drag State
    // Slots: 0: Погода, 1: Радар, 2: Арт/Картинка, 3: Медиаплеер, 4: Калькулятор, 5: Кнопки управления, 6: Поиск/Игры
    @Unique private static final float[][] rockstar$widgetOffsets = new float[7][2];
    @Unique private static int rockstar$draggedWidget = -1;
    @Unique private static float rockstar$dragMouseStartX = 0.0F;
    @Unique private static float rockstar$dragMouseStartY = 0.0F;
    @Unique private static float rockstar$dragOrigX = 0.0F;
    @Unique private static float rockstar$dragOrigY = 0.0F;

    // Weather Cities State (Клик переключает города)
    @Unique private static int rockstar$weatherCityIdx = 0;
    @Unique private static final String[] rockstar$cities = new String[]{ "Москва", "Санкт-Петербург", "Киев", "Сочи", "Казань" };
    @Unique private static final String[] rockstar$cityTemps = new String[]{ "+18°C", "+14°C", "+21°C", "+24°C", "+16°C" };
    @Unique private static final String[] rockstar$cityConds = new String[]{ "Ясно ☀️", "Дождь 🌧️", "Малооблачно 🌤️", "Тепло ☀️", "Облачно ⛅" };

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
        custom.drawRect(0.0F, 0.0F, (float)this.width, (float)this.height, new ColorRGBA(0.0F, 0.0F, 0.0F, 135.0F));

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

        // Media tracker
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

        // --- 7 ADAPTABLE DRAGGABLE WIDGET CARDS ---
        // 0: Погода (134 x 88)
        // 1: Радар тревог (134 x 92)
        // 2: Арт / Картинка (154 x 186) - без квадратных краев!
        // 3: Медиаплеер (142 x 88)
        // 4: Калькулятор (142 x 92)
        // 5: Кнопки управления (52 x 186)
        // 6: Нижняя панель поиска и мини-игр (420 x 36)
        float[][] baseBounds = new float[][]{
            { cx - 245.0F, cy - 98.0F, 134.0F, 88.0F },  // 0: Погода
            { cx - 245.0F, cy - 4.0F,  134.0F, 92.0F },  // 1: Радар
            { cx - 105.0F, cy - 98.0F, 154.0F, 186.0F }, // 2: Арт / Картинка дня
            { cx + 55.0F,  cy - 98.0F, 142.0F, 88.0F },  // 3: Медиаплеер
            { cx + 55.0F,  cy - 4.0F,  142.0F, 92.0F },  // 4: Калькулятор
            { cx + 203.0F, cy - 98.0F, 52.0F,  186.0F }, // 5: Кнопки управления
            { cx - 210.0F, cy + 96.0F, 420.0F, 36.0F }   // 6: Поиск и игры
        };

        // Render each widget card with its custom drag offset & marching dashed border on hover
        for (int i = 0; i < 7; i++) {
            float bx = baseBounds[i][0] + rockstar$widgetOffsets[i][0];
            float by = baseBounds[i][1] + rockstar$widgetOffsets[i][1];
            float bw = baseBounds[i][2];
            float bh = baseBounds[i][3];

            boolean isHov = (mouseX >= bx && mouseX <= bx + bw && mouseY >= by && mouseY <= by + bh);
            float target = isHov ? 1.0F : 0.0F;
            rockstar$tileHoverAnim[i] += (target - rockstar$tileHoverAnim[i]) * 0.20F;
            float hoverA = rockstar$tileHoverAnim[i];

            drawContext.getMatrices().push();
            switch (i) {
                case 0 -> rockstar$renderWeatherCard(custom, bx, by, bw, bh, font, subFont, boldFont, mouseX, mouseY, hoverA);
                case 1 -> rockstar$renderRadarCard(custom, bx, by, bw, bh, font, subFont, tinyFont, mouseX, mouseY, hoverA);
                case 2 -> rockstar$renderPictureCard(custom, bx, by, bw, bh, font, subFont, boldFont, mouseX, mouseY, hoverA);
                case 3 -> rockstar$renderMediaCard(custom, bx, by, bw, bh, font, subFont, tinyFont, mouseX, mouseY, hoverA, snap, tracker);
                case 4 -> rockstar$renderCalculatorCard(custom, bx, by, bw, bh, boldFont, font, hoverA);
                case 5 -> rockstar$renderActionSquircles(custom, bx, by, bw, bh, mouseX, mouseY, hoverA);
                case 6 -> rockstar$renderBottomBar(custom, bx, by, bw, bh, font, subFont, mouseX, mouseY, hoverA);
            }

            // Marching dashed border highlight on hover ("выделялись движущимся пунктиром")
            if (hoverA > 0.05F) {
                ColorRGBA dashCol = new ColorRGBA(52.0F, 199.0F, 245.0F, 220.0F * hoverA);
                rockstar$drawMarchingDashedBorder(custom, bx, by, bw, bh, 12.0F, dashCol);
            }
            drawContext.getMatrices().pop();
        }

        // Fullscreen Shutter Flash on Screenshot
        if (rockstar$flashAlpha > 0.001F) {
            custom.drawRect(0.0F, 0.0F, (float)this.width, (float)this.height, new ColorRGBA(255.0F, 255.0F, 255.0F, 255.0F * rockstar$flashAlpha));
            rockstar$flashAlpha = Math.max(0.0F, rockstar$flashAlpha - delta * 0.16F);
        }
    }

    // --- 1. ВИДЖЕТ ПОГОДЫ (WEATHER CARD - MATTE FROSTED SEMI-GLASS) ---
    @Unique
    private void rockstar$renderWeatherCard(III custom, float x, float y, float w, float h, IIiIIi_Class10 font, IIiIIi_Class10 subFont, IIiIIi_Class10 boldFont, int mx, int my, float hoverA) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(14.0F);
        custom.drawShadow(x, y, w, h, 14.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 90.0F));
        custom.drawBlurredRect(x, y, w, h, 16.0F, 3.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(20.0F, 24.0F, 36.0F, 215.0F));
        custom.drawRoundedBorder(x, y, w, h, 1.1F, rad, hoverA > 0.01F ? new ColorRGBA(52.0F, 199.0F, 245.0F, 210.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 38.0F));

        // City & Status Pill (Clickable)
        String city = rockstar$cities[rockstar$weatherCityIdx];
        String temp = rockstar$cityTemps[rockstar$weatherCityIdx];
        String cond = rockstar$cityConds[rockstar$weatherCityIdx];

        if (subFont != null) {
            custom.drawRoundedRect(x + 8.0F, y + 8.0F, subFont.I_method_2c375926(city) + 12.0F, 14.0F, IIiii_Class8.I_method_893b2757(4.0F), new ColorRGBA(52.0F, 199.0F, 245.0F, 50.0F));
            custom.drawText(subFont, city, x + 14.0F, y + 11.5F, new ColorRGBA(52.0F, 199.0F, 245.0F, 255.0F));
            custom.drawText(subFont, "Погода", x + w - 38.0F, y + 11.5F, new ColorRGBA(160.0F, 175.0F, 200.0F, 190.0F));
        }

        // Large Temperature
        if (boldFont != null) {
            custom.drawText(boldFont, temp, x + 10.0F, y + 27.0F, ColorRGBA.WHITE);
        }

        // Condition & Stats
        if (font != null) {
            custom.drawText(font, cond, x + 10.0F, y + 46.0F, new ColorRGBA(210.0F, 225.0F, 245.0F, 230.0F));
        }
        if (subFont != null) {
            custom.drawText(subFont, "Ветер 3.8 м/с • Влажн. 64%", x + 10.0F, y + 62.0F, new ColorRGBA(150.0F, 165.0F, 190.0F, 190.0F));
            custom.drawText(subFont, "Завтра: +19° ☀️  Сб: +16° ⛅", x + 10.0F, y + 74.0F, new ColorRGBA(130.0F, 145.0F, 175.0F, 170.0F));
        }
    }

    // --- 2. ВИДЖЕТ РАДАРА ТРЕВОГ (AIR RAID RADAR WIDGET - ANIMATED SWEEP) ---
    @Unique
    private void rockstar$renderRadarCard(III custom, float x, float y, float w, float h, IIiIIi_Class10 font, IIiIIi_Class10 subFont, IIiIIi_Class10 tinyFont, int mx, int my, float hoverA) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(14.0F);
        custom.drawShadow(x, y, w, h, 14.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 90.0F));
        custom.drawBlurredRect(x, y, w, h, 16.0F, 3.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(20.0F, 24.0F, 36.0F, 215.0F));
        custom.drawRoundedBorder(x, y, w, h, 1.1F, rad, hoverA > 0.01F ? new ColorRGBA(255.0F, 69.0F, 58.0F, 210.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 38.0F));

        // Radar Title & Alarm Beacon
        long now = System.currentTimeMillis();
        boolean blink = (now % 1000L) > 500L;
        ColorRGBA alarmCol = blink ? new ColorRGBA(255.0F, 59.0F, 48.0F, 255.0F) : new ColorRGBA(200.0F, 30.0F, 20.0F, 200.0F);

        if (subFont != null) {
            custom.drawRoundedRect(x + 8.0F, y + 8.0F, 6.0F, 6.0F, IIiii_Class8.I_method_893b2757(3.0F), alarmCol);
            custom.drawText(subFont, "Радар тревог", x + 18.0F, y + 8.5F, ColorRGBA.WHITE);
            custom.drawText(subFont, "ЭФИР", x + w - 32.0F, y + 8.5F, alarmCol);
        }

        // Circular Animated Radar Screen
        float rcx = x + 28.0F;
        float rcy = y + 48.0F;
        float rr = 20.0F;

        custom.drawRoundedRect(rcx - rr, rcy - rr, rr * 2.0F, rr * 2.0F, IIiii_Class8.I_method_893b2757(rr), new ColorRGBA(10.0F, 14.0F, 22.0F, 240.0F));
        custom.drawRoundedBorder(rcx - rr, rcy - rr, rr * 2.0F, rr * 2.0F, 1.0F, IIiii_Class8.I_method_893b2757(rr), new ColorRGBA(255.0F, 69.0F, 58.0F, 100.0F));

        // Crosshairs
        custom.drawRect(rcx - rr + 2.0F, rcy, rr * 2.0F - 4.0F, 0.8F, new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F));
        custom.drawRect(rcx, rcy - rr + 2.0F, 0.8F, rr * 2.0F - 4.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F));

        // Rotating Sweep Beam
        float sweepAngle = ((now % 3000L) / 3000.0F) * (float)Math.PI * 2.0F;
        float sx = rcx + (float)Math.cos(sweepAngle) * (rr - 2.0F);
        float sy = rcy + (float)Math.sin(sweepAngle) * (rr - 2.0F);
        custom.drawRect(rcx, rcy, sx - rcx, 1.2F, new ColorRGBA(255.0F, 69.0F, 58.0F, 220.0F));

        // Right Threat Stats
        if (subFont != null) {
            custom.drawText(subFont, "Украина: 3 акт.", x + 56.0F, y + 34.0F, new ColorRGBA(255.0F, 80.0F, 70.0F, 230.0F));
            custom.drawText(subFont, "РФ: 2 тревоги", x + 56.0F, y + 46.0F, new ColorRGBA(255.0F, 180.0F, 60.0F, 230.0F));
            custom.drawText(subFont, "ПВО активно", x + 56.0F, y + 58.0F, new ColorRGBA(52.0F, 199.0F, 89.0F, 220.0F));
        }
        if (tinyFont != null) {
            custom.drawText(tinyFont, "Мониторинг ракетных угроз", x + 10.0F, y + 76.0F, new ColorRGBA(150.0F, 165.0F, 190.0F, 180.0F));
        }
    }

    // --- 3. АТМОСФЕРНЫЙ АРТ / КАРТИНКА ДНЯ (COVER ART PICTURE - NO SQUARE HARSH EDGES!) ---
    @Unique
    private void rockstar$renderPictureCard(III custom, float x, float y, float w, float h, IIiIIi_Class10 font, IIiIIi_Class10 subFont, IIiIIi_Class10 boldFont, int mx, int my, float hoverA) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(14.0F);
        custom.drawShadow(x, y, w, h, 18.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 110.0F));
        custom.drawBlurredRect(x, y, w, h, 16.0F, 3.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(18.0F, 22.0F, 32.0F, 230.0F));

        // Draw Big Wallpaper Texture without harsh square edges (Smooth Mask & Gradient Blend)
        Identifier wallTex = RockstarClient.id("image/mainmenu/wallpaper1.jpg");
        float imgPad = 2.0F;
        float imgX = x + imgPad;
        float imgY = y + imgPad;
        float imgW = w - imgPad * 2.0F;
        float imgH = h - imgPad * 2.0F;

        custom.drawTexture(wallTex, imgX, imgY, imgW, imgH, ColorRGBA.WHITE);

        // Soft Gradient Overlay from top and bottom to seamlessly merge with matte glass body
        custom.drawRoundedRect(imgX, imgY, imgW, imgH, rad, new ColorRGBA(12.0F, 16.0F, 26.0F, 90.0F));
        // Deep bottom gradient vignette
        float botFadeH = 68.0F;
        custom.drawRoundedRect(imgX, y + h - botFadeH, imgW, botFadeH, rad, new ColorRGBA(14.0F, 18.0F, 28.0F, 180.0F));

        // Specular Frosted Border
        custom.drawRoundedBorder(x, y, w, h, 1.2F, rad, hoverA > 0.01F ? new ColorRGBA(168.0F, 85.0F, 247.0F, 220.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F));

        // Top Brand Pill
        if (subFont != null) {
            custom.drawRoundedRect(x + 10.0F, y + 10.0F, 78.0F, 15.0F, IIiii_Class8.I_method_893b2757(5.0F), new ColorRGBA(16.0F, 20.0F, 30.0F, 200.0F));
            custom.drawText(subFont, "🌌 Атмосфера дня", x + 15.0F, y + 13.5F, ColorRGBA.WHITE);
        }

        // Bottom Title and Description
        if (boldFont != null) {
            custom.drawText(boldFont, "Agravity Sanctuary", x + 10.0F, y + h - 36.0F, ColorRGBA.WHITE);
        }
        if (subFont != null) {
            custom.drawText(subFont, "Сезонное обновление визуалов", x + 10.0F, y + h - 20.0F, new ColorRGBA(200.0F, 215.0F, 240.0F, 210.0F));
        }
    }

    // --- 4. МЕДИАПЛЕЕР БРАУЗЕРА (BROWSER MEDIA PLAYER) ---
    @Unique
    private void rockstar$renderMediaCard(III custom, float x, float y, float w, float h, IIiIIi_Class10 font, IIiIIi_Class10 subFont, IIiIIi_Class10 tinyFont, int mx, int my, float hoverA, @Nullable iiIiIIIiI_Class419.Nested1_a961800 snap, @Nullable iiIiIIIiI_Class419 tracker) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(14.0F);
        custom.drawShadow(x, y, w, h, 14.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 90.0F));
        custom.drawBlurredRect(x, y, w, h, 16.0F, 3.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(20.0F, 24.0F, 36.0F, 215.0F));
        custom.drawRoundedBorder(x, y, w, h, 1.1F, rad, hoverA > 0.01F ? new ColorRGBA(168.0F, 85.0F, 247.0F, 210.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 38.0F));

        boolean hasTrack = (snap != null);
        String trackTitle = hasTrack ? snap.I_method_33e8b426() : "Музыка в браузере";
        String artistName = hasTrack ? snap.i_method_c7076446() : "Включите трек в сети";
        boolean isPlaying = hasTrack && snap.I_method_1a22ebbe();

        // Thumbnail
        float thumbSz = 26.0F;
        custom.drawRoundedRect(x + 8.0F, y + 8.0F, thumbSz, thumbSz, IIiii_Class8.I_method_893b2757(6.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));
        custom.drawIcon("music", x + 13.0F, y + 13.0F, 16.0F, ColorRGBA.WHITE.withAlpha(220.0F));

        // Equalizer Bars
        float eqStartX = x + 38.0F;
        float eqBaseY = y + 28.0F;
        float barW = 2.0F;
        float barGap = 2.0F;
        for (int b = 0; b < rockstar$eqFrequencies.length; b++) {
            float bH = Math.max(3.0F, rockstar$eqFrequencies[b] * 16.0F);
            float bx = eqStartX + b * (barW + barGap);
            custom.drawRoundedRect(bx, eqBaseY - bH, barW, bH, IIiii_Class8.I_method_893b2757(1.0F), new ColorRGBA(168.0F, 85.0F, 247.0F, isPlaying ? 245.0F : 80.0F));
        }

        // Title and Artist
        if (font != null) {
            String shortTitle = trackTitle != null ? trackTitle : "Трек";
            if (shortTitle.length() > 18) shortTitle = shortTitle.substring(0, 17) + "…";
            custom.drawText(font, shortTitle, x + 8.0F, y + 38.0F, ColorRGBA.WHITE);
        }
        if (subFont != null) {
            String shortArtist = artistName != null ? artistName : "";
            if (shortArtist.length() > 20) shortArtist = shortArtist.substring(0, 19) + "…";
            custom.drawText(subFont, shortArtist, x + 8.0F, y + 51.0F, new ColorRGBA(160.0F, 175.0F, 200.0F, 190.0F));
        }

        // Play / Pause Indicator
        if (subFont != null) {
            String stateStr = isPlaying ? "▶ Играет" : "⏸ Пауза";
            custom.drawText(subFont, stateStr, x + w - 46.0F, y + 70.0F, isPlaying ? new ColorRGBA(52.0F, 199.0F, 89.0F, 220.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 140.0F));
        }
    }

    // --- 5. МАТОВЫЙ КАЛЬКУЛЯТОР (MATTE GLASS CALCULATOR) ---
    @Unique
    private void rockstar$renderCalculatorCard(III custom, float x, float y, float w, float h, IIiIIi_Class10 boldFont, IIiIIi_Class10 font, float hoverA) {
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(14.0F);
        custom.drawShadow(x, y, w, h, 14.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 90.0F));
        custom.drawBlurredRect(x, y, w, h, 16.0F, 3.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));
        custom.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(20.0F, 24.0F, 36.0F, 215.0F));
        custom.drawRoundedBorder(x, y, w, h, 1.1F, rad, hoverA > 0.01F ? new ColorRGBA(255.0F, 159.0F, 10.0F, 210.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 38.0F));

        // LCD Display
        String disp = rockstar$calcDisplay;
        if (disp.length() > 10) disp = disp.substring(0, 10);
        if (boldFont != null) {
            float tw = boldFont.I_method_2c375926(disp);
            custom.drawText(boldFont, disp, x + w - tw - 12.0F, y + 10.0F, ColorRGBA.WHITE);
        }

        // Circular Button Grid (3 rows compact)
        String[][] grid = new String[][]{
            { "7", "8", "9", "÷" },
            { "4", "5", "6", "×" },
            { "1", "2", "3", "=" }
        };
        float btnSz = 20.0F;
        float gap = 5.0F;
        float startY = y + 26.0F;

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 4; c++) {
                String lbl = grid[r][c];
                float bx = x + 10.0F + c * (btnSz + gap + 3.0F);
                float by = startY + r * (btnSz + gap);

                ColorRGBA bg = (c == 3) ? new ColorRGBA(255.0F, 159.0F, 10.0F, 220.0F) : new ColorRGBA(55.0F, 62.0F, 78.0F, 200.0F);
                custom.drawRoundedRect(bx, by, btnSz, btnSz, IIiii_Class8.I_method_893b2757(6.0F), bg);
                if (font != null) {
                    float lw = font.I_method_2c375926(lbl);
                    custom.drawText(font, lbl, bx + (btnSz - lw) / 2.0F, by + 5.0F, ColorRGBA.WHITE);
                }
            }
        }
    }

    // --- 6. КНОПКИ УПРАВЛЕНИЯ ИГРОЙ (ACTION SQUIRCLES: ПРОДОЛЖИТЬ, НАСТРОЙКИ, ОТКЛЮЧИТЬСЯ) ---
    @Unique
    private void rockstar$renderActionSquircles(III custom, float x, float y, float w, float h, int mx, int my, float hoverA) {
        float btnSz = 48.0F;
        float bx = x + (w - btnSz) / 2.0F;
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(12.0F);

        // 1. Продолжить (Play)
        float y1 = y + 4.0F;
        boolean hov1 = mx >= bx && mx <= bx + btnSz && my >= y1 && my <= y1 + btnSz;
        custom.drawShadow(bx, y1, btnSz, btnSz, 10.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 80.0F));
        custom.drawRoundedRect(bx, y1, btnSz, btnSz, rad, new ColorRGBA(24.0F, 28.0F, 40.0F, hov1 ? 255.0F : 210.0F));
        custom.drawRoundedBorder(bx, y1, btnSz, btnSz, 1.2F, rad, hov1 ? new ColorRGBA(52.0F, 199.0F, 89.0F, 240.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F));
        custom.drawIcon("play", bx + 17.0F, y1 + 17.0F, 14.0F, ColorRGBA.WHITE);

        // 2. Настройки (Gear)
        float y2 = y + h / 2.0F - btnSz / 2.0F;
        boolean hov2 = mx >= bx && mx <= bx + btnSz && my >= y2 && my <= y2 + btnSz;
        custom.drawShadow(bx, y2, btnSz, btnSz, 10.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 80.0F));
        custom.drawRoundedRect(bx, y2, btnSz, btnSz, rad, new ColorRGBA(24.0F, 28.0F, 40.0F, hov2 ? 255.0F : 210.0F));
        custom.drawRoundedBorder(bx, y2, btnSz, btnSz, 1.2F, rad, hov2 ? new ColorRGBA(0.0F, 122.0F, 255.0F, 240.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F));
        custom.drawIcon("setting", bx + 16.0F, y2 + 16.0F, 16.0F, ColorRGBA.WHITE);

        // 3. Отключиться (Power / Leave)
        float y3 = y + h - btnSz - 4.0F;
        boolean hov3 = mx >= bx && mx <= bx + btnSz && my >= y3 && my <= y3 + btnSz;
        custom.drawShadow(bx, y3, btnSz, btnSz, 10.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 80.0F));
        custom.drawRoundedRect(bx, y3, btnSz, btnSz, rad, new ColorRGBA(24.0F, 28.0F, 40.0F, hov3 ? 255.0F : 210.0F));
        custom.drawRoundedBorder(bx, y3, btnSz, btnSz, 1.2F, rad, hov3 ? new ColorRGBA(255.0F, 59.0F, 48.0F, 240.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F));
        custom.drawIcon("xmark", bx + 17.0F, y3 + 17.0F, 14.0F, hov3 ? new ColorRGBA(255.0F, 59.0F, 48.0F, 255.0F) : ColorRGBA.WHITE);
    }

    // --- 7. НИЖНЯЯ ПАНЕЛЬ: ПОИСК GOOGLE + 3D ЛОГОТИПЫ ЗМЕЙКИ И САПЁРА ---
    @Unique
    private void rockstar$renderBottomBar(III custom, float x, float y, float w, float h, IIiIIi_Class10 font, IIiIIi_Class10 subFont, int mx, int my, float hoverA) {
        IIiii_Class8 sRad = IIiii_Class8.I_method_893b2757(10.0F);

        // Search Bar (Left 280px)
        float sW = 280.0F;
        boolean sHover = mx >= x && mx <= x + sW && my >= y && my <= y + h;
        custom.drawShadow(x, y, sW, h, 12.0F, sRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 80.0F));
        custom.drawBlurredRect(x, y, sW, h, 14.0F, 3.0F, sRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 22.0F));
        custom.drawRoundedRect(x, y, sW, h, sRad, new ColorRGBA(22.0F, 26.0F, 36.0F, 215.0F));
        custom.drawRoundedBorder(x, y, sW, h, 1.2F, sRad, rockstar$searchFocused ? new ColorRGBA(168.0F, 85.0F, 247.0F, 230.0F) : (sHover ? new ColorRGBA(255.0F, 255.0F, 255.0F, 80.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 38.0F)));

        if (font != null) {
            String sPrompt = rockstar$searchText.isEmpty() ? (rockstar$searchFocused ? "" : "🔍 Поиск в Google... (Enter)") : rockstar$searchText;
            if (rockstar$searchFocused && (System.currentTimeMillis() % 1000L < 500L)) sPrompt += "|";
            ColorRGBA sCol = rockstar$searchText.isEmpty() ? new ColorRGBA(255.0F, 255.0F, 255.0F, 140.0F) : ColorRGBA.WHITE;
            custom.drawText(font, sPrompt, x + 12.0F, y + 12.0F, sCol);
        }

        // --- 3D BRAND LOGO EMBLEM: ЗМЕЙКА (SNAKE LOGO EMBLEM) ---
        float snX = x + sW + 10.0F;
        float gBtnW = 58.0F;
        boolean snHov = mx >= snX && mx <= snX + gBtnW && my >= y && my <= y + h;

        custom.drawShadow(snX, y, gBtnW, h, 12.0F, sRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 80.0F));
        custom.drawBlurredRect(snX, y, gBtnW, h, 14.0F, 3.0F, sRad, new ColorRGBA(52.0F, 199.0F, 89.0F, 30.0F));
        custom.drawRoundedRect(snX, y, gBtnW, h, sRad, new ColorRGBA(18.0F, 28.0F, 24.0F, snHov ? 255.0F : 215.0F));
        custom.drawRoundedBorder(snX, y, gBtnW, h, 1.3F, sRad, snHov ? new ColorRGBA(52.0F, 199.0F, 89.0F, 245.0F) : new ColorRGBA(52.0F, 199.0F, 89.0F, 120.0F));

        // Draw 3D Snake Logo Emblem
        custom.drawTexture(RockstarClient.id("icons/snake.png"), snX + 7.0F, y + 6.0F, 24.0F, 24.0F, ColorRGBA.WHITE);
        if (subFont != null) {
            custom.drawText(subFont, "Змейка", snX + 33.0F, y + 13.5F, snHov ? ColorRGBA.WHITE : new ColorRGBA(180.0F, 240.0F, 200.0F, 220.0F));
        }

        // --- 3D BRAND LOGO EMBLEM: САПЁР (MINESWEEPER LOGO EMBLEM) ---
        float mnX = snX + gBtnW + 10.0F;
        float mBtnW = 58.0F;
        boolean mnHov = mx >= mnX && mx <= mnX + mBtnW && my >= y && my <= y + h;

        custom.drawShadow(mnX, y, mBtnW, h, 12.0F, sRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 80.0F));
        custom.drawBlurredRect(mnX, y, mBtnW, h, 14.0F, 3.0F, sRad, new ColorRGBA(255.0F, 59.0F, 48.0F, 30.0F));
        custom.drawRoundedRect(mnX, y, mBtnW, h, sRad, new ColorRGBA(28.0F, 20.0F, 24.0F, mnHov ? 255.0F : 215.0F));
        custom.drawRoundedBorder(mnX, y, mBtnW, h, 1.3F, sRad, mnHov ? new ColorRGBA(255.0F, 59.0F, 48.0F, 245.0F) : new ColorRGBA(255.0F, 59.0F, 48.0F, 120.0F));

        // Draw 3D Mine Logo Emblem
        custom.drawTexture(RockstarClient.id("icons/mine.png"), mnX + 7.0F, y + 6.0F, 24.0F, 24.0F, ColorRGBA.WHITE);
        if (subFont != null) {
            custom.drawText(subFont, "Сапёр", mnX + 33.0F, y + 13.5F, mnHov ? ColorRGBA.WHITE : new ColorRGBA(255.0F, 200.0F, 190.0F, 220.0F));
        }
    }

    // --- ANIMATED MARCHING DASHED BORDER RENDERER ("ДВИЖУЩИЙСЯ ПУНКТИР") ---
    @Unique
    private static void rockstar$drawMarchingDashedBorder(III custom, float x, float y, float w, float h, float rad, ColorRGBA col) {
        long time = System.currentTimeMillis();
        float dash = 8.0F;
        float gap = 5.0F;
        float period = dash + gap;
        float speed = 32.0F; // pixels per second
        float offset = ((time / 1000.0F) * speed) % period;

        // Top edge
        rockstar$drawDashedHLine(custom, x + rad, x + w - rad, y, offset, dash, gap, col);
        // Right edge
        rockstar$drawDashedVLine(custom, x + w, y + rad, y + h - rad, offset, dash, gap, col);
        // Bottom edge
        rockstar$drawDashedHLine(custom, x + rad, x + w - rad, y + h, offset + period / 2.0F, dash, gap, col);
        // Left edge
        rockstar$drawDashedVLine(custom, x, y + rad, y + h - rad, offset + period / 2.0F, dash, gap, col);
    }

    @Unique
    private static void rockstar$drawDashedHLine(III custom, float x1, float x2, float y, float offset, float dash, float gap, ColorRGBA col) {
        float total = x2 - x1;
        float period = dash + gap;
        float cur = -offset;
        while (cur < total) {
            float s = Math.max(0.0F, cur);
            float e = Math.min(total, cur + dash);
            if (e > s) {
                custom.drawRect(x1 + s, y - 0.75F, e - s, 1.5F, col);
            }
            cur += period;
        }
    }

    @Unique
    private static void rockstar$drawDashedVLine(III custom, float x, float y1, float y2, float offset, float dash, float gap, ColorRGBA col) {
        float total = y2 - y1;
        float period = dash + gap;
        float cur = -offset;
        while (cur < total) {
            float s = Math.max(0.0F, cur);
            float e = Math.min(total, cur + dash);
            if (e > s) {
                custom.drawRect(x - 0.75F, y1 + s, 1.5F, e - s, col);
            }
            cur += period;
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        float cx = this.width / 2.0F;
        float cy = this.height / 2.0F;

        float[][] baseBounds = new float[][]{
            { cx - 245.0F, cy - 98.0F, 134.0F, 88.0F },  // 0: Погода
            { cx - 245.0F, cy - 4.0F,  134.0F, 92.0F },  // 1: Радар
            { cx - 105.0F, cy - 98.0F, 154.0F, 186.0F }, // 2: Арт / Картинка
            { cx + 55.0F,  cy - 98.0F, 142.0F, 88.0F },  // 3: Медиаплеер
            { cx + 55.0F,  cy - 4.0F,  142.0F, 92.0F },  // 4: Калькулятор
            { cx + 203.0F, cy - 98.0F, 52.0F,  186.0F }, // 5: Кнопки управления
            { cx - 210.0F, cy + 96.0F, 420.0F, 36.0F }   // 6: Поиск и игры
        };

        // Check Card 0: Weather City Cycle Click
        float w0x = baseBounds[0][0] + rockstar$widgetOffsets[0][0];
        float w0y = baseBounds[0][1] + rockstar$widgetOffsets[0][1];
        if (mouseX >= w0x && mouseX <= w0x + 134.0F && mouseY >= w0y && mouseY <= w0y + 24.0F) {
            rockstar$weatherCityIdx = (rockstar$weatherCityIdx + 1) % rockstar$cities.length;
            UISoundManager.playButtonClick();
            return true;
        }

        // Check Card 5: Action Squircles Clicks (Продолжить, Настройки, Отключиться)
        float b5x = baseBounds[5][0] + rockstar$widgetOffsets[5][0];
        float b5y = baseBounds[5][1] + rockstar$widgetOffsets[5][1];
        float btnSz = 48.0F;
        float bx = b5x + (52.0F - btnSz) / 2.0F;
        if (mouseX >= bx && mouseX <= bx + btnSz) {
            float y1 = b5y + 4.0F;
            float y2 = b5y + 186.0F / 2.0F - btnSz / 2.0F;
            float y3 = b5y + 186.0F - btnSz - 4.0F;

            // 1. Продолжить (Resume)
            if (mouseY >= y1 && mouseY <= y1 + btnSz) {
                UISoundManager.playButtonClick();
                this.close();
                return true;
            }
            // 2. Настройки (Options)
            if (mouseY >= y2 && mouseY <= y2 + btnSz) {
                UISoundManager.playButtonClick();
                if (this.client != null) {
                    this.client.setScreen(new OptionsScreen(this, this.client.options));
                }
                return true;
            }
            // 3. Отключиться (Disconnect)
            if (mouseY >= y3 && mouseY <= y3 + btnSz) {
                UISoundManager.playButtonClick();
                this.disconnect();
                return true;
            }
        }

        // Check Card 6: Bottom Search, Snake & Minesweeper
        float b6x = baseBounds[6][0] + rockstar$widgetOffsets[6][0];
        float b6y = baseBounds[6][1] + rockstar$widgetOffsets[6][1];
        float sW = 280.0F;
        float snX = b6x + sW + 10.0F;
        float mnX = snX + 58.0F + 10.0F;

        // Search bar click
        if (mouseX >= b6x && mouseX <= b6x + sW && mouseY >= b6y && mouseY <= b6y + 36.0F) {
            rockstar$searchFocused = true;
            UISoundManager.playButtonClick();
            return true;
        } else {
            rockstar$searchFocused = false;
        }

        // Snake button click
        if (mouseX >= snX && mouseX <= snX + 58.0F && mouseY >= b6y && mouseY <= b6y + 36.0F) {
            UISoundManager.playButtonClick();
            if (this.client != null) {
                this.client.setScreen(new SnakeScreen(this));
            }
            return true;
        }

        // Minesweeper button click
        if (mouseX >= mnX && mouseX <= mnX + 58.0F && mouseY >= b6y && mouseY <= b6y + 36.0F) {
            UISoundManager.playButtonClick();
            if (this.client != null) {
                this.client.setScreen(new MinesweeperScreen(this));
            }
            return true;
        }

        // Check Draggable Card Grab (Зажатие для перемещения любого виджета!)
        for (int i = 0; i < 7; i++) {
            float bxCur = baseBounds[i][0] + rockstar$widgetOffsets[i][0];
            float byCur = baseBounds[i][1] + rockstar$widgetOffsets[i][1];
            float bwCur = baseBounds[i][2];
            float bhCur = baseBounds[i][3];

            if (mouseX >= bxCur && mouseX <= bxCur + bwCur && mouseY >= byCur && mouseY <= byCur + bhCur) {
                rockstar$draggedWidget = i;
                rockstar$dragMouseStartX = (float)mouseX;
                rockstar$dragMouseStartY = (float)mouseY;
                rockstar$dragOrigX = rockstar$widgetOffsets[i][0];
                rockstar$dragOrigY = rockstar$widgetOffsets[i][1];
                return true;
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        if (rockstar$draggedWidget >= 0 && rockstar$draggedWidget < 7) {
            float dx = (float)mouseX - rockstar$dragMouseStartX;
            float dy = (float)mouseY - rockstar$dragMouseStartY;
            rockstar$widgetOffsets[rockstar$draggedWidget][0] = rockstar$dragOrigX + dx;
            rockstar$widgetOffsets[rockstar$draggedWidget][1] = rockstar$dragOrigY + dy;
            return true;
        }
        return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        rockstar$draggedWidget = -1;
        rockstar$isDraggingVolume = false;
        return super.mouseReleased(mouseX, mouseY, button);
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
