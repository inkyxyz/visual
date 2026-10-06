package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;

@ModuleInfo(
    name = "Titles",
    category = ModuleCategory.INTERFACE,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.titles"
)
public class TitlesModule extends Module {

    private ModeSetting styleSetting;
    private ModeSetting.Nested1_42765c60 styleClean;
    private ModeSetting.Nested1_42765c60 styleKaraoke;
    private ModeSetting.Nested1_42765c60 stylePill;
    private ModeSetting.Nested1_42765c60 styleHolo;

    private ModeSetting fadeAnimSetting;
    private ModeSetting.Nested1_42765c60 fadeAnimSmooth;
    private ModeSetting.Nested1_42765c60 fadeAnimSlideDown;
    private ModeSetting.Nested1_42765c60 fadeAnimScalePop;
    private ModeSetting.Nested1_42765c60 fadeAnimGlitch;

    private ModeSetting fontSetting;
    private ModeSetting.Nested1_42765c60 fontSemiBold;
    private ModeSetting.Nested1_42765c60 fontMedium;
    private ModeSetting.Nested1_42765c60 fontBold;
    private ModeSetting.Nested1_42765c60 fontRegular;
    private ModeSetting.Nested1_42765c60 fontRound;
    private ModeSetting.Nested1_42765c60 fontJetBrains;

    private SliderSetting distanceSetting;
    private SliderSetting heightSetting;
    private SliderSetting scaleSetting;
    private BooleanSetting glowSetting;
    private BooleanSetting syncThemeSetting;
    private ColorSetting textColorSetting;
    private ColorSetting highlightColorSetting;
    private ColorSetting glowColorSetting;
    private BooleanSetting demoModeSetting;

    private static class ActiveLyricsChunk {
        String[] words;
        float[] wordWidths;
        float spaceWidth;
        float totalTextWidth;
        Vec3d worldPos;
        long startTime;
        long duration;
        boolean rightSide;
    }

    private ActiveLyricsChunk currentChunk = null;
    private final List<String[]> currentLineChunks = new ArrayList<>();
    private final List<String[]> pendingDemoChunks = new ArrayList<>();
    private String lastRawLyricsLine = "";
    private int lastActiveChunkIndex = -1;
    private int chunkSpawnCounter = 0;
    private int demoLyricIndex = 0;

    private final IiIIIiII_Class69<Render3DEvent> render3DListener = this::onRender3D;

    public TitlesModule() {
        this.initSettings();
    }

    private void initSettings() {
        this.styleSetting = new ModeSetting(this, "Style");
        this.styleClean = new ModeSetting.Nested1_42765c60(this.styleSetting, "Clean (No Box)").select();
        this.styleKaraoke = new ModeSetting.Nested1_42765c60(this.styleSetting, "Karaoke Glow");
        this.stylePill = new ModeSetting.Nested1_42765c60(this.styleSetting, "Floating Capsule");
        this.styleHolo = new ModeSetting.Nested1_42765c60(this.styleSetting, "Cyber Holo");

        this.fadeAnimSetting = new ModeSetting(this, "Disappear Animation");
        this.fadeAnimSmooth = new ModeSetting.Nested1_42765c60(this.fadeAnimSetting, "Smooth Fade").select();
        this.fadeAnimSlideDown = new ModeSetting.Nested1_42765c60(this.fadeAnimSetting, "Slide Down");
        this.fadeAnimScalePop = new ModeSetting.Nested1_42765c60(this.fadeAnimSetting, "Scale Pop");
        this.fadeAnimGlitch = new ModeSetting.Nested1_42765c60(this.fadeAnimSetting, "Glitch Scan");

        this.fontSetting = new ModeSetting(this, "Font");
        this.fontSemiBold = new ModeSetting.Nested1_42765c60(this.fontSetting, "SemiBold").select();
        this.fontMedium = new ModeSetting.Nested1_42765c60(this.fontSetting, "Medium");
        this.fontBold = new ModeSetting.Nested1_42765c60(this.fontSetting, "Bold");
        this.fontRegular = new ModeSetting.Nested1_42765c60(this.fontSetting, "Regular");
        this.fontRound = new ModeSetting.Nested1_42765c60(this.fontSetting, "Round");
        this.fontJetBrains = new ModeSetting.Nested1_42765c60(this.fontSetting, "JetBrains");

        this.distanceSetting = new SliderSetting(this, "Distance")
            .I_method_c8c9a7d7(3.5F).i_method_65e2aff7(16.0F).II_method_b0f56334(0.2F).Ii_method_4e0e6b54(6.0F);

        this.heightSetting = new SliderSetting(this, "Height Offset")
            .I_method_c8c9a7d7(-1.2F).i_method_65e2aff7(1.2F).II_method_b0f56334(0.05F).Ii_method_4e0e6b54(-0.10F);

        this.scaleSetting = new SliderSetting(this, "Scale")
            .I_method_c8c9a7d7(0.008F).i_method_65e2aff7(0.024F).II_method_b0f56334(0.001F).Ii_method_4e0e6b54(0.015F);

        this.glowSetting = new BooleanSetting(this, "Text Glow").I_method_decd82b5();
        this.syncThemeSetting = new BooleanSetting(this, "Sync Theme").I_method_decd82b5();
        this.textColorSetting = new ColorSetting(this, "Default Text Color").I_method_a62f5dd6(new ColorRGBA(220.0F, 225.0F, 240.0F, 255.0F));
        this.highlightColorSetting = new ColorSetting(this, "Highlight Color").I_method_a62f5dd6(new ColorRGBA(0.0F, 230.0F, 255.0F, 255.0F));
        this.glowColorSetting = new ColorSetting(this, "Glow Halo Color").I_method_a62f5dd6(new ColorRGBA(120.0F, 180.0F, 255.0F, 200.0F));
        this.demoModeSetting = new BooleanSetting(this, "Demo Song Lyrics").I_method_decd82b5();
    }

    private IIiIIi_Class10 getSelectedFont(float size) {
        if (this.fontSetting != null) {
            if (this.fontSetting.isSelected("Medium")) return IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(size);
            if (this.fontSetting.isSelected("Bold")) return IIiIiI_Class11.I_field_857c0621.I_method_3a2d5e3(size);
            if (this.fontSetting.isSelected("Regular")) return IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(size);
            if (this.fontSetting.isSelected("Round")) return IIiIiI_Class11.ii_field_857c0621.I_method_3a2d5e3(size);
            if (this.fontSetting.isSelected("JetBrains")) return IIiIiI_Class11.JETBRAINS.I_method_3a2d5e3(size);
        }
        return IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(size);
    }

    private static final String[] DEMO_LYRICS = {
        "I found a love to carry more than just my secrets",
        "You were the shadow to my light did you feel us",
        "Another start you fade away afraid our aim is out of sight",
        "Where are you now was it all in my fantasy",
        "Under the bright but faded lights you set my heart on fire",
        "Where are you now Atlantis under the deep sea",
        "Let the sky fall when it crumbles we will stand tall",
        "Face it all together right at Skyfall"
    };

    private static List<String[]> splitIntoChunks(String line) {
        List<String[]> chunks = new ArrayList<>();
        if (line == null || line.isBlank()) return chunks;
        String[] words = line.trim().split("\\s+");
        if (words.length == 0) return chunks;

        int idx = 0;
        while (idx < words.length) {
            int rem = words.length - idx;
            int take;
            if (rem <= 4) {
                take = rem;
            } else if (rem == 5) {
                take = 3;
            } else {
                take = 3;
            }
            String[] chunkWords = new String[take];
            System.arraycopy(words, idx, chunkWords, 0, take);
            chunks.add(chunkWords);
            idx += take;
        }
        return chunks;
    }

    private void spawnChunkAtCamera(String[] words, Camera camera, IIiIIi_Class10 font, float spaceWidth, long now, long duration, boolean rightSide) {
        MinecraftClient mc = MinecraftClient.getInstance();
        Vec3d camPos = camera.getPos();
        float pitch = camera.getPitch();
        float yaw = camera.getYaw();

        float sideSign = rightSide ? 1.0F : -1.0F;

        float f = MathHelper.cos(-yaw * 0.017453292F - (float)Math.PI);
        float g = MathHelper.sin(-yaw * 0.017453292F - (float)Math.PI);
        float h = -MathHelper.cos(-pitch * 0.017453292F);
        float i = MathHelper.sin(-pitch * 0.017453292F);

        Vec3d forward = new Vec3d((double)(g * h), (double)i, (double)(f * h)).normalize();
        Vec3d right = forward.crossProduct(new Vec3d(0.0, 1.0, 0.0)).normalize();

        double dist = Math.max(3.5, (double)this.distanceSetting.Ii_method_a20abcd2());
        double sideDist = (1.30 + Math.random() * 0.40) * sideSign;
        double hOff = this.heightSetting.Ii_method_a20abcd2() + (Math.random() - 0.5) * 0.20;

        Vec3d spawnPos = camPos.add(forward.multiply(dist)).add(right.multiply(sideDist)).add(0.0, hOff, 0.0);

        // Prevent spawning inside blocks or underground
        if (mc.world != null) {
            int floorX = MathHelper.floor(spawnPos.x);
            int floorZ = MathHelper.floor(spawnPos.z);
            int topY = mc.world.getTopY(net.minecraft.world.Heightmap.Type.MOTION_BLOCKING, floorX, floorZ);
            if (spawnPos.y < (double)topY + 1.2) {
                spawnPos = new Vec3d(spawnPos.x, (double)topY + 1.2, spawnPos.z);
            }
        }

        ActiveLyricsChunk c = new ActiveLyricsChunk();
        c.words = words;
        c.wordWidths = new float[words.length];
        c.spaceWidth = spaceWidth;
        c.totalTextWidth = 0.0F;
        for (int w = 0; w < words.length; w++) {
            c.wordWidths[w] = font.I_method_2c375926(words[w]);
            c.totalTextWidth += c.wordWidths[w];
            if (w < words.length - 1) {
                c.totalTextWidth += spaceWidth;
            }
        }
        c.worldPos = spawnPos;
        c.startTime = now;
        c.duration = duration;
        c.rightSide = rightSide;
        this.currentChunk = c;
    }

    private void onRender3D(Render3DEvent event) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.world == null || mc.player == null) return;
        if (mc.options.hudHidden) return;

        Camera camera = event.getCamera();
        if (camera == null || !camera.isReady()) return;

        long now = System.currentTimeMillis();

        // Dynamic Font selection
        IIiIIi_Class10 font = this.getSelectedFont(9.5F);
        float spaceWidth = font.I_method_2c375926(" ");
        float fontHeight = font.I_method_a649725c();

        // 1. Fetch live media player lyrics (frame-accurate synchronization, zero lagging)
        boolean hasMediaLyrics = false;
        iiIiIIIiI_Class419 mediaSession = RockstarClient.getInstance().I_method_be969482();
        if (mediaSession != null && mediaSession.I_method_f1206e83()) {
            iiIiIIIiI_Class419.Nested1_a961800 snap = mediaSession.I_method_7effc530();
            if (snap != null) {
                iiIiIIIii_Class420 lyrics = snap.I_method_3abb4910();
                double posSec = snap.I_method_1a22eba8();
                if (lyrics != null && !lyrics.I_method_27bb8263()) {
                    long posMs = (long)(posSec * 1000.0);
                    int idx = lyrics.I_method_cfb54038(posMs);
                    if (idx >= 0 && idx < lyrics.I_method_13376608().size()) {
                        iiIiIIIii_Class420.Nested1_a969040 lineObj = lyrics.I_method_13376608().get(idx);
                        String lineText = lineObj.I_method_257c66();
                        if (lineText != null && !lineText.isBlank()) {
                            hasMediaLyrics = true;
                            long lineStart = lineObj.I_method_4ce39b6e();
                            long nextStart = (idx + 1 < lyrics.I_method_13376608().size())
                                ? lyrics.I_method_13376608().get(idx + 1).I_method_4ce39b6e()
                                : lineStart + 3600L;
                            long lineDur = Math.max(1200L, nextStart - lineStart);

                            if (!lineText.equals(this.lastRawLyricsLine)) {
                                this.lastRawLyricsLine = lineText;
                                this.currentLineChunks.clear();
                                this.currentLineChunks.addAll(splitIntoChunks(lineText));
                                this.lastActiveChunkIndex = -1;
                            }

                            if (!this.currentLineChunks.isEmpty()) {
                                int totalChunks = this.currentLineChunks.size();
                                long chunkDur = Math.max(500L, lineDur / totalChunks);
                                long lineElapsed = Math.max(0L, posMs - lineStart);
                                int chunkIdx = MathHelper.clamp((int)(lineElapsed / chunkDur), 0, totalChunks - 1);

                                if (chunkIdx != this.lastActiveChunkIndex || this.currentChunk == null) {
                                    this.lastActiveChunkIndex = chunkIdx;
                                    this.chunkSpawnCounter++;
                                    boolean rightSide = (this.chunkSpawnCounter % 2 == 1);
                                    String[] words = this.currentLineChunks.get(chunkIdx);
                                    spawnChunkAtCamera(words, camera, font, spaceWidth, now, chunkDur, rightSide);
                                }
                            }
                        }
                    }
                }
            }
        }

        // Demo fallback when no media lyrics are active
        if (!hasMediaLyrics && this.demoModeSetting.i_method_9b12da03()) {
            if (this.currentChunk == null || now >= this.currentChunk.startTime + this.currentChunk.duration + 300L) {
                if (this.pendingDemoChunks.isEmpty()) {
                    String demoLine = DEMO_LYRICS[this.demoLyricIndex % DEMO_LYRICS.length];
                    this.demoLyricIndex++;
                    this.pendingDemoChunks.addAll(splitIntoChunks(demoLine));
                }
                if (!this.pendingDemoChunks.isEmpty()) {
                    String[] words = this.pendingDemoChunks.remove(0);
                    this.chunkSpawnCounter++;
                    boolean rightSide = (this.chunkSpawnCounter % 2 == 1);
                    long dur = Math.max(1600L, words.length * 600L);
                    spawnChunkAtCamera(words, camera, font, spaceWidth, now, dur, rightSide);
                }
            }
        }

        if (this.currentChunk == null) return;

        // 3. Timing and Animation
        long elapsed = now - this.currentChunk.startTime;
        float progress = MathHelper.clamp((float)elapsed / (float)this.currentChunk.duration, 0.0F, 1.0F);

        // Smooth fade-in (first 180ms) and selectable disappearance animation
        float curAlpha = 1.0F;
        float animOffsetY = 0.0F;
        float animScaleMod = 1.0F;
        float animOffsetX = 0.0F;

        if (elapsed < 180L) {
            curAlpha = elapsed / 180.0F;
        } else if (elapsed > this.currentChunk.duration) {
            float fadeProgress = MathHelper.clamp((float)(elapsed - this.currentChunk.duration) / 280.0F, 0.0F, 1.0F);
            curAlpha = Math.max(0.0F, 1.0F - fadeProgress);

            String animMode = (this.fadeAnimSetting != null && this.fadeAnimSetting.i_method_f85f3850() != null)
                ? this.fadeAnimSetting.i_method_f85f3850().getName()
                : "Smooth Fade";

            switch (animMode) {
                case "Slide Down" -> {
                    animOffsetY = -fadeProgress * 14.0F;
                }
                case "Scale Pop" -> {
                    animScaleMod = Math.max(0.01F, 1.0F - (float)Math.pow(fadeProgress, 1.8) * 0.9F);
                }
                case "Glitch Scan" -> {
                    animOffsetX = (float)Math.sin(elapsed * 0.20) * 10.0F * fadeProgress;
                    curAlpha *= ((int)(elapsed / 40L) % 2 == 0) ? 0.25F : 1.0F;
                }
                default -> { // Smooth Fade
                }
            }
        }
        if (curAlpha <= 0.01F) return;

        // Scale pop on spawn
        float scalePop = 0.90F + 0.10F * Math.min(1.0F, elapsed / 160.0F);

        // Gentle floating upward in the 3D world (drifting lyrics aura)
        double driftUp = elapsed * 0.00010;
        double bobY = Math.sin((now % 1000000L) / 400.0) * 0.015;

        // 4. Matrix setup: billboard at world position facing camera
        // Using positive X, negative Y scale (sc, -sc, sc) to match PyRender3D and eliminate upside down / mirrored text
        Vec3d camPos = camera.getPos();
        MatrixStack matrices = event.getMatrices();
        matrices.push();
        matrices.translate(
            this.currentChunk.worldPos.x - camPos.x,
            this.currentChunk.worldPos.y + driftUp + bobY - camPos.y,
            this.currentChunk.worldPos.z - camPos.z
        );
        matrices.multiply(camera.getRotation());

        float sc = this.scaleSetting.Ii_method_a20abcd2() * scalePop * animScaleMod;
        matrices.translate(animOffsetX, animOffsetY, 0.0F);
        matrices.scale(sc, -sc, sc);

        // Word index currently being sung (karaoke timing)
        int activeWordIdx = Math.min(this.currentChunk.words.length - 1, (int)(progress * this.currentChunk.words.length));

        // Colors
        ColorRGBA themeAccent = IiiiiIIIi_Class242.I_method_7df8e08e();
        ColorRGBA defaultText = this.syncThemeSetting.i_method_9b12da03() ? new ColorRGBA(225.0F, 230.0F, 245.0F, 255.0F) : this.textColorSetting.I_method_bde5f08e();
        ColorRGBA activeHighlight = this.syncThemeSetting.i_method_9b12da03() ? themeAccent : this.highlightColorSetting.I_method_bde5f08e();
        ColorRGBA glowColor = this.syncThemeSetting.i_method_9b12da03() ? themeAccent : this.glowColorSetting.I_method_bde5f08e();

        float padX = 14.0F;
        float padY = 7.0F;
        float cardW = this.currentChunk.totalTextWidth + padX * 2.0F + 14.0F;
        float cardH = fontHeight + padY * 2.0F + 2.0F;
        float cardX = -cardW / 2.0F;
        float cardY = -cardH / 2.0F;

        Matrix4f posMat = matrices.peek().getPositionMatrix();

        boolean isClean = (this.styleClean != null && this.styleClean.isSelected()) || (this.styleSetting != null && this.styleSetting.isSelected("Clean (No Box)"));
        boolean isHolo = (this.styleHolo != null && this.styleHolo.isSelected()) || (this.styleSetting != null && this.styleSetting.isSelected("Cyber Holo"));

        // 5. Render 3D Backdrop Quad & Glow (omitted completely if "Clean / Без рамки" is active!)
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableCull();
        RenderSystem.enableDepthTest();
        RenderSystem.depthFunc(515); // GL_LEQUAL prevents clipping over first-person hands
        RenderSystem.depthMask(false);
        RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);

        if (!isClean) {
            BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);

            // Ambient outer glow
            if (this.glowSetting.i_method_9b12da03()) {
                int glowCol = glowColor.withAlpha((int)(45.0F * curAlpha)).getRGB();
                float gSpread = 4.5F;
                bb.vertex(posMat, cardX - gSpread, cardY - gSpread, 0.0F).color(glowCol);
                bb.vertex(posMat, cardX - gSpread, cardY + cardH + gSpread, 0.0F).color(glowCol);
                bb.vertex(posMat, cardX + cardW + gSpread, cardY + cardH + gSpread, 0.0F).color(glowCol);
                bb.vertex(posMat, cardX + cardW + gSpread, cardY - gSpread, 0.0F).color(glowCol);
            }

            // Frosted dark pill body / Cyber Holo
            int bodyCol = isHolo
                ? new ColorRGBA(8.0F, 12.0F, 22.0F, 195.0F * curAlpha).getRGB()
                : new ColorRGBA(10.0F, 12.0F, 18.0F, 215.0F * curAlpha).getRGB();

            bb.vertex(posMat, cardX, cardY, 0.0F).color(bodyCol);
            bb.vertex(posMat, cardX, cardY + cardH, 0.0F).color(bodyCol);
            bb.vertex(posMat, cardX + cardW, cardY + cardH, 0.0F).color(bodyCol);
            bb.vertex(posMat, cardX + cardW, cardY, 0.0F).color(bodyCol);

            // Dynamic Karaoke Progress Bar (fills across words)
            float barW = (cardW - 4.0F) * progress;
            int barCol = activeHighlight.withAlpha((int)(220.0F * curAlpha)).getRGB();
            bb.vertex(posMat, cardX + 2.0F, cardY + cardH - 1.8F, 0.0F).color(barCol);
            bb.vertex(posMat, cardX + 2.0F, cardY + cardH - 0.4F, 0.0F).color(barCol);
            bb.vertex(posMat, cardX + 2.0F + barW, cardY + cardH - 0.4F, 0.0F).color(barCol);
            bb.vertex(posMat, cardX + 2.0F + barW, cardY + cardH - 1.8F, 0.0F).color(barCol);

            // Floating side indicator dot
            float dotX = this.currentChunk.rightSide ? cardX + cardW - 7.0F : cardX + 7.0F;
            float dotY = cardY + 5.0F;
            float dotR = 2.0F;
            int dotCol = activeHighlight.withAlpha((int)(190.0F * curAlpha)).getRGB();
            bb.vertex(posMat, dotX - dotR, dotY - dotR, 0.0F).color(dotCol);
            bb.vertex(posMat, dotX - dotR, dotY + dotR, 0.0F).color(dotCol);
            bb.vertex(posMat, dotX + dotR, dotY + dotR, 0.0F).color(dotCol);
            bb.vertex(posMat, dotX + dotR, dotY - dotR, 0.0F).color(dotCol);

            BuiltBuffer built = bb.endNullable();
            if (built != null) BufferRenderer.drawWithGlobalProgram(built);
        } else if (this.glowSetting.i_method_9b12da03()) {
            // Clean style: subtle ambient text halo with zero box frame
            BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
            int glowCol = glowColor.withAlpha((int)(30.0F * curAlpha)).getRGB();
            float textGlowW = this.currentChunk.totalTextWidth + 24.0F;
            float textGlowH = fontHeight + 12.0F;
            float tgX = -textGlowW / 2.0F;
            float tgY = -textGlowH / 2.0F;
            bb.vertex(posMat, tgX, tgY, 0.0F).color(glowCol);
            bb.vertex(posMat, tgX, tgY + textGlowH, 0.0F).color(glowCol);
            bb.vertex(posMat, tgX + textGlowW, tgY + textGlowH, 0.0F).color(glowCol);
            bb.vertex(posMat, tgX + textGlowW, tgY, 0.0F).color(glowCol);
            BuiltBuffer built = bb.endNullable();
            if (built != null) BufferRenderer.drawWithGlobalProgram(built);
        }

        // 6. Render Custom OTF Words (Karaoke Coloring)
        float startX = cardX + padX + (isClean ? 0.0F : 4.0F);
        float textY = cardY + (cardH - fontHeight) / 2.0F - 0.5F;
        float currentX = startX;

        for (int w = 0; w < this.currentChunk.words.length; w++) {
            String word = this.currentChunk.words[w];
            float wWidth = this.currentChunk.wordWidths[w];

            ColorRGBA wordCol;
            if (w < activeWordIdx) {
                // Already sung words: fully highlighted
                wordCol = activeHighlight.withAlpha((int)(245.0F * curAlpha));
            } else if (w == activeWordIdx) {
                // Active word: glowing highlight
                wordCol = activeHighlight.withAlpha((int)(255.0F * curAlpha));
            } else {
                // Upcoming words: soft translucent white
                wordCol = defaultText.withAlpha((int)(110.0F * curAlpha));
            }

            // Draw word using client custom OTF font
            IiIIIi_Class18.I_method_f6065e6c(
                font.I_method_36d49b4b(),
                word,
                font.iI_method_24b6c285(),
                wordCol.getRGB(),
                matrices.peek().getPositionMatrix(),
                currentX,
                textY,
                0.0F
            );

            currentX += wWidth + this.currentChunk.spaceWidth;
        }

        matrices.pop();
        RenderSystem.depthMask(true);
    }
}
