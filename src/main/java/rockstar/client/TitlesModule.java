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
import net.minecraft.block.BlockState;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.RaycastContext;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
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
    private BooleanSetting syncThemeSetting;
    private ColorSetting textColorSetting;
    private ColorSetting highlightColorSetting;
    private BooleanSetting demoModeSetting;

    private static class ActiveLyricsChunk {
        String[] words;
        float[] wordWidths;
        float spaceWidth;
        float totalTextWidth;
        Vec3d worldPos;
        Quaternionf rotation;
        long startTime;
        long duration;
        boolean rightSide;
        boolean isExpiring = false;
        long expireStartTime = 0L;
        String exitAnimation = "Smooth Fade";
    }

    private final List<ActiveLyricsChunk> activeChunks = new ArrayList<>();
    private final List<String[]> currentLineChunks = new ArrayList<>();
    private final List<String[]> pendingDemoChunks = new ArrayList<>();
    private String lastRawLyricsLine = "";
    private String lastAnnouncedTrack = "";
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
        this.styleKaraoke = new ModeSetting.Nested1_42765c60(this.styleSetting, "Karaoke");
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
            .I_method_c8c9a7d7(0.006F).i_method_65e2aff7(0.075F).II_method_b0f56334(0.002F).Ii_method_4e0e6b54(0.020F);

        this.syncThemeSetting = new BooleanSetting(this, "Sync Theme").I_method_decd82b5();
        this.textColorSetting = new ColorSetting(this, "Default Text Color").I_method_a62f5dd6(new ColorRGBA(220.0F, 225.0F, 240.0F, 255.0F));
        this.highlightColorSetting = new ColorSetting(this, "Highlight Color").I_method_a62f5dd6(new ColorRGBA(0.0F, 230.0F, 255.0F, 255.0F));
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

        double dist = Math.max(3.0, (double)this.distanceSetting.Ii_method_a20abcd2());
        // Keep strictly in player's direct field of view (tight horizontal/vertical cone)
        double sideDist = (0.40 + Math.random() * 0.30) * sideSign;
        double hOff = MathHelper.clamp(this.heightSetting.Ii_method_a20abcd2() + (float)(Math.random() - 0.5) * 0.15F, -0.45F, 0.45F);

        Vec3d targetPos = camPos.add(forward.multiply(dist)).add(right.multiply(sideDist)).add(0.0, hOff, 0.0);
        Vec3d spawnPos = targetPos;

        // Line-of-sight collider raycast: never spawn behind walls or obstacles
        if (mc.world != null && mc.player != null) {
            Vec3d rayDir = targetPos.subtract(camPos);
            double totalRayDist = rayDir.length();
            if (totalRayDist > 0.2) {
                BlockHitResult hit = mc.world.raycast(new RaycastContext(
                    camPos,
                    targetPos,
                    RaycastContext.ShapeType.COLLIDER,
                    RaycastContext.FluidHandling.NONE,
                    mc.player
                ));
                if (hit.getType() != HitResult.Type.MISS) {
                    double hitDist = hit.getPos().distanceTo(camPos);
                    // Place safely in front of the wall/obstacle with 0.55m clearance
                    double safeDist = Math.max(1.0, hitDist - 0.55);
                    spawnPos = camPos.add(rayDir.normalize().multiply(safeDist));
                }
            }

            // Never spawn inside solid blocks
            BlockPos bpos = BlockPos.ofFloored(spawnPos);
            BlockState state = mc.world.getBlockState(bpos);
            if (!state.isAir() && state.isOpaqueFullCube()) {
                Vec3d toCam = camPos.subtract(spawnPos).normalize();
                for (int step = 0; step < 8; step++) {
                    spawnPos = spawnPos.add(toCam.multiply(0.35));
                    bpos = BlockPos.ofFloored(spawnPos);
                    state = mc.world.getBlockState(bpos);
                    if (state.isAir() || !state.isOpaqueFullCube()) {
                        break;
                    }
                }
            }

            // Never spawn inside other players or mobs (entity collision evasion)
            net.minecraft.util.math.Box spawnCheck = new net.minecraft.util.math.Box(
                spawnPos.x - 1.5, spawnPos.y - 1.5, spawnPos.z - 1.5,
                spawnPos.x + 1.5, spawnPos.y + 1.5, spawnPos.z + 1.5
            );
            for (net.minecraft.entity.Entity ent : mc.world.getOtherEntities(mc.player, spawnCheck)) {
                if (ent instanceof net.minecraft.entity.LivingEntity living) {
                    net.minecraft.util.math.Box b = living.getBoundingBox().expand(0.4);
                    if (b.contains(spawnPos)) {
                        spawnPos = new Vec3d(spawnPos.x, b.maxY + 0.65, spawnPos.z);
                    }
                }
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

        // Fixed orientation locked to face player at spawn time using camera rotation snapshot
        // Guaranteed 100% upright, readable left-to-right, and never inverted or upside down
        c.rotation = new Quaternionf(camera.getRotation());

        // Trigger smooth disappearance animation on previous non-expiring chunks
        for (ActiveLyricsChunk prev : this.activeChunks) {
            if (!prev.isExpiring) {
                prev.isExpiring = true;
                prev.expireStartTime = now;
                prev.exitAnimation = (this.fadeAnimSetting != null && this.fadeAnimSetting.i_method_f85f3850() != null)
                    ? this.fadeAnimSetting.i_method_f85f3850().getName()
                    : "Smooth Fade";
            }
        }

        this.activeChunks.add(c);
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
            if (snap != null && snap.I_method_1a22ebbe()) {
                hasMediaLyrics = true;
                iiIiIIIii_Class420 lyrics = snap.I_method_3abb4910();
                double posSec = snap.I_method_1a22eba8();
                long posMs = (long)(posSec * 1000.0);
                String activeLine = null;
                long lineStart = 0L;
                long lineDur = 3000L;

                if (lyrics != null && !lyrics.I_method_27bb8263()) {
                    int idx = lyrics.I_method_cfb54038(posMs);
                    if (idx >= 0 && idx < lyrics.I_method_13376608().size()) {
                        iiIiIIIii_Class420.Nested1_a969040 lineObj = lyrics.I_method_13376608().get(idx);
                        activeLine = lineObj.I_method_257c66();
                        lineStart = lineObj.I_method_4ce39b6e();
                        long nextStart = (idx + 1 < lyrics.I_method_13376608().size())
                            ? lyrics.I_method_13376608().get(idx + 1).I_method_4ce39b6e()
                            : lineStart + 3600L;
                        lineDur = Math.max(1200L, nextStart - lineStart);
                    } else if (idx < 0 && posMs < 10000L) {
                        String t = snap.I_method_33e8b426();
                        String a = snap.i_method_c7076446();
                        if (t != null && !t.isBlank()) {
                            String fullTrack = (a != null && !a.isBlank()) ? (a + " - " + t) : t;
                            if (!fullTrack.equals(this.lastAnnouncedTrack)) {
                                this.lastAnnouncedTrack = fullTrack;
                                activeLine = fullTrack;
                                lineStart = 0L;
                                lineDur = 4500L;
                            }
                        }
                    }
                } else if (posMs < 10000L) {
                    String t = snap.I_method_33e8b426();
                    String a = snap.i_method_c7076446();
                    if (t != null && !t.isBlank()) {
                        String fullTrack = (a != null && !a.isBlank()) ? (a + " - " + t) : t;
                        if (!fullTrack.equals(this.lastAnnouncedTrack)) {
                            this.lastAnnouncedTrack = fullTrack;
                            activeLine = fullTrack;
                            lineStart = 0L;
                            lineDur = 4500L;
                        }
                    }
                }

                if (activeLine != null && !activeLine.isBlank()) {
                    hasMediaLyrics = true;
                    if (!activeLine.equals(this.lastRawLyricsLine)) {
                        this.lastRawLyricsLine = activeLine;
                        this.currentLineChunks.clear();
                        this.currentLineChunks.addAll(splitIntoChunks(activeLine));
                        this.lastActiveChunkIndex = -1;
                    }

                    if (!this.currentLineChunks.isEmpty()) {
                        int totalChunks = this.currentLineChunks.size();
                        long chunkDur = Math.max(500L, lineDur / totalChunks);
                        long lineElapsed = Math.max(0L, posMs - lineStart);
                        int chunkIdx = MathHelper.clamp((int)(lineElapsed / chunkDur), 0, totalChunks - 1);

                        if (chunkIdx != this.lastActiveChunkIndex || this.activeChunks.isEmpty()) {
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

        // Demo fallback when no media lyrics are active
        if (!hasMediaLyrics && this.demoModeSetting.i_method_9b12da03()) {
            boolean hasNonExpiring = false;
            for (ActiveLyricsChunk chk : this.activeChunks) {
                if (!chk.isExpiring && now < chk.startTime + chk.duration) {
                    hasNonExpiring = true;
                    break;
                }
            }
            if (!hasNonExpiring) {
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

        if (this.activeChunks.isEmpty()) return;

        // Render ON TOP of all players and mobs (disabled depth test)
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableCull();
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);

        List<ActiveLyricsChunk> toRemove = new ArrayList<>();

        for (ActiveLyricsChunk chunk : this.activeChunks) {
            long elapsed = now - chunk.startTime;

            if (!chunk.isExpiring && elapsed > chunk.duration) {
                chunk.isExpiring = true;
                chunk.expireStartTime = chunk.startTime + chunk.duration;
                chunk.exitAnimation = (this.fadeAnimSetting != null && this.fadeAnimSetting.i_method_f85f3850() != null)
                    ? this.fadeAnimSetting.i_method_f85f3850().getName()
                    : "Smooth Fade";
            }

            float curAlpha = 1.0F;
            float animOffsetY = 0.0F;
            float animOffsetX = 0.0F;
            float animScaleMod = 1.0F;

            // Entrance animation: smooth ease-out (first 180ms)
            float enterProgress = MathHelper.clamp((float)elapsed / 180.0F, 0.0F, 1.0F);
            float enterEase = 1.0F - (float)Math.pow(1.0F - enterProgress, 3.0);
            curAlpha = enterEase;
            float scalePop = 0.85F + 0.15F * enterEase;

            // Disappearance animation
            if (chunk.isExpiring) {
                long expElapsed = Math.max(0L, now - chunk.expireStartTime);
                float fadeDur = 320.0F;
                float fadeProgress = MathHelper.clamp((float)expElapsed / fadeDur, 0.0F, 1.0F);

                if (fadeProgress >= 1.0F) {
                    toRemove.add(chunk);
                    continue;
                }

                switch (chunk.exitAnimation) {
                    case "Slide Down" -> {
                        float dropEase = (float)Math.pow(fadeProgress, 1.8);
                        animOffsetY = -dropEase * 22.0F;
                        curAlpha *= Math.max(0.0F, 1.0F - fadeProgress);
                        animScaleMod = 1.0F - fadeProgress * 0.12F;
                    }
                    case "Scale Pop" -> {
                        float popEase = (float)Math.pow(1.0F - fadeProgress, 2.5);
                        animScaleMod = Math.max(0.001F, popEase);
                        curAlpha *= Math.max(0.0F, 1.0F - fadeProgress);
                    }
                    case "Glitch Scan" -> {
                        animOffsetX = (float)Math.sin(expElapsed * 0.40) * 10.0F * (1.0F - fadeProgress);
                        animOffsetY = ((expElapsed / 30L) % 3 - 1) * 3.0F;
                        curAlpha *= ((expElapsed / 40L) % 2 == 0) ? 0.20F : 0.90F;
                        curAlpha *= Math.max(0.0F, 1.0F - fadeProgress);
                    }
                    default -> { // "Smooth Fade"
                        float fadeEase = 1.0F - (float)Math.pow(fadeProgress, 2.0);
                        curAlpha *= fadeEase;
                        animOffsetY = -fadeProgress * 6.0F;
                    }
                }
            }

            if (curAlpha <= 0.01F) continue;

            float progress = MathHelper.clamp((float)elapsed / (float)chunk.duration, 0.0F, 1.0F);
            double driftUp = elapsed * 0.00010;
            double bobY = Math.sin((now % 1000000L) / 400.0) * 0.015;

            Vec3d camPos = camera.getPos();
            MatrixStack matrices = event.getMatrices();
            matrices.push();
            matrices.translate(
                chunk.worldPos.x - camPos.x,
                chunk.worldPos.y + driftUp + bobY - camPos.y,
                chunk.worldPos.z - camPos.z
            );
            if (chunk.rotation != null) {
                matrices.multiply(chunk.rotation);
            } else {
                matrices.multiply(camera.getRotation());
            }

            float sc = this.scaleSetting.Ii_method_a20abcd2() * scalePop * animScaleMod;
            matrices.translate(animOffsetX, animOffsetY, 0.0F);
            matrices.scale(sc, -sc, sc);

            int activeWordIdx = Math.min(chunk.words.length - 1, (int)(progress * chunk.words.length));

            ColorRGBA themeAccent = IiiiiIIIi_Class242.I_method_7df8e08e();
            ColorRGBA defaultText = this.syncThemeSetting.i_method_9b12da03() ? new ColorRGBA(225.0F, 230.0F, 245.0F, 255.0F) : this.textColorSetting.I_method_bde5f08e();
            ColorRGBA activeHighlight = this.syncThemeSetting.i_method_9b12da03() ? themeAccent : this.highlightColorSetting.I_method_bde5f08e();

            float padX = 14.0F;
            float padY = 7.0F;
            float cardW = chunk.totalTextWidth + padX * 2.0F + 14.0F;
            float cardH = fontHeight + padY * 2.0F + 2.0F;
            float cardX = -cardW / 2.0F;
            float cardY = -cardH / 2.0F;

            Matrix4f posMat = matrices.peek().getPositionMatrix();

            boolean isClean = (this.styleClean != null && this.styleClean.isSelected()) || (this.styleSetting != null && this.styleSetting.isSelected("Clean (No Box)"));
            boolean isHolo = (this.styleHolo != null && this.styleHolo.isSelected()) || (this.styleSetting != null && this.styleSetting.isSelected("Cyber Holo"));

            RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);

            if (!isClean) {
                BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);

                int bodyCol = isHolo
                    ? new ColorRGBA(8.0F, 12.0F, 22.0F, 195.0F * curAlpha).getRGB()
                    : new ColorRGBA(10.0F, 12.0F, 18.0F, 215.0F * curAlpha).getRGB();

                bb.vertex(posMat, cardX, cardY, 0.0F).color(bodyCol);
                bb.vertex(posMat, cardX, cardY + cardH, 0.0F).color(bodyCol);
                bb.vertex(posMat, cardX + cardW, cardY + cardH, 0.0F).color(bodyCol);
                bb.vertex(posMat, cardX + cardW, cardY, 0.0F).color(bodyCol);

                float barW = (cardW - 4.0F) * progress;
                int barCol = activeHighlight.withAlpha((int)(220.0F * curAlpha)).getRGB();
                bb.vertex(posMat, cardX + 2.0F, cardY + cardH - 1.8F, 0.0F).color(barCol);
                bb.vertex(posMat, cardX + 2.0F, cardY + cardH - 0.4F, 0.0F).color(barCol);
                bb.vertex(posMat, cardX + 2.0F + barW, cardY + cardH - 0.4F, 0.0F).color(barCol);
                bb.vertex(posMat, cardX + 2.0F + barW, cardY + cardH - 1.8F, 0.0F).color(barCol);

                float dotX = chunk.rightSide ? cardX + cardW - 7.0F : cardX + 7.0F;
                float dotY = cardY + 5.0F;
                float dotR = 2.0F;
                int dotCol = activeHighlight.withAlpha((int)(190.0F * curAlpha)).getRGB();
                bb.vertex(posMat, dotX - dotR, dotY - dotR, 0.0F).color(dotCol);
                bb.vertex(posMat, dotX - dotR, dotY + dotR, 0.0F).color(dotCol);
                bb.vertex(posMat, dotX + dotR, dotY + dotR, 0.0F).color(dotCol);
                bb.vertex(posMat, dotX + dotR, dotY - dotR, 0.0F).color(dotCol);

                BuiltBuffer built = bb.endNullable();
                if (built != null) BufferRenderer.drawWithGlobalProgram(built);
            }

            float startX = cardX + padX + (isClean ? 0.0F : 4.0F);
            float textY = cardY + (cardH - fontHeight) / 2.0F - 0.5F;
            float currentX = startX;

            for (int w = 0; w < chunk.words.length; w++) {
                String word = chunk.words[w];
                float wWidth = chunk.wordWidths[w];

                ColorRGBA wordCol;
                if (w < activeWordIdx) {
                    wordCol = activeHighlight.withAlpha((int)(245.0F * curAlpha));
                } else if (w == activeWordIdx) {
                    wordCol = activeHighlight.withAlpha((int)(255.0F * curAlpha));
                } else {
                    wordCol = defaultText.withAlpha((int)(110.0F * curAlpha));
                }

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

                currentX += wWidth + chunk.spaceWidth;
            }

            matrices.pop();
        }

        this.activeChunks.removeAll(toRemove);
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
    }
}
