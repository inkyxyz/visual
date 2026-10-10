package rockstar.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mojang.blaze3d.systems.RenderSystem;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import moscow.rockstar.mixin.minecraft.client.IMinecraftClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.session.Session;
import net.minecraft.client.util.DefaultSkinHelper;
import net.minecraft.client.util.SkinTextures;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec2f;
import org.lwjgl.glfw.GLFW;
import pyrock.utility.render.ColorRGBA;

public class AltManagerScreen extends ii_Class4 {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final List<String> ACCOUNTS = new ArrayList<>();
    private static final Map<String, CompletableFuture<SkinTextures>> SKIN_CACHE = new ConcurrentHashMap<>();
    private static PlayerEntityModel PLAYER_MODEL;
    private static boolean loaded = false;

    public static PlayerEntityModel getPlayerModel() {
        if (PLAYER_MODEL == null) {
            PLAYER_MODEL = new PlayerEntityModel(MinecraftClient.getInstance().getLoadedEntityModels().getModelPart(EntityModelLayers.PLAYER), false);
        }
        return PLAYER_MODEL;
    }

    public static final String[] POSE_NAMES = {
        "Приветствие", "Уверенность", "Мыслитель", "Герой", "Чилл",
        "Присед", "Прицел", "Блок мечом", "Дэб", "Т-Поза"
    };
    public static int currentPoseIndex = 0;

    private final Screen parent;
    private String inputText = "";
    private boolean inputFocused = false;

    // Smooth Screen Open / Close Animation
    private float openProgress = 0.0F;
    private boolean isClosing = false;
    private long lastFrameTime = 0L;

    // Bedrock 3D Carousel state
    private int selectedIndex = 0;
    private float carouselAnim = 0.0F;

    // Center 3D model rotation & drag
    private float modelRotationYaw = 0.0F;
    private float modelRotationVel = 0.0F;
    private boolean isDraggingModel = false;
    private double lastDragMouseX = 0;

    // Smooth hover animations
    private float leftArrowHover = 0.0F;
    private float rightArrowHover = 0.0F;
    private boolean poseMenuOpen = false;
    private float poseMenuAnim = 0.0F;
    private float poseBtnHover = 0.0F;
    private float pasteHover = 0.0F;
    private float rndHover = 0.0F;
    private float delHover = 0.0F;
    private float closeHover = 0.0F;

    public AltManagerScreen(Screen parent) {
        this.parent = parent;
        loadAlts();
        String current = MinecraftClient.getInstance().getSession().getUsername();
        if (current != null && !current.isBlank()) {
            int idx = ACCOUNTS.indexOf(current);
            if (idx >= 0) {
                this.selectedIndex = idx;
            } else {
                ACCOUNTS.add(0, current);
                this.selectedIndex = 0;
                saveAlts();
            }
        }
        if (this.selectedIndex >= ACCOUNTS.size()) {
            this.selectedIndex = Math.max(0, ACCOUNTS.size() - 1);
        }
        this.carouselAnim = this.selectedIndex;
    }

    private static File getAltFile() {
        File agravityFile = new File(MinecraftClient.getInstance().runDirectory, "agravity_alts.json");
        if (!agravityFile.exists()) {
            File legacyFile = new File(MinecraftClient.getInstance().runDirectory, "rockstar_alts.json");
            if (legacyFile.exists()) {
                legacyFile.renameTo(agravityFile);
            }
        }
        return agravityFile;
    }

    private static synchronized void loadAlts() {
        if (loaded) return;
        try {
            File f = getAltFile();
            if (f.exists()) {
                try (FileReader reader = new FileReader(f, StandardCharsets.UTF_8)) {
                    List<String> list = GSON.fromJson(reader, new TypeToken<List<String>>(){}.getType());
                    if (list != null) {
                        ACCOUNTS.clear();
                        ACCOUNTS.addAll(list);
                    }
                }
            } else {
                String current = MinecraftClient.getInstance().getSession().getUsername();
                if (current != null && !current.isBlank()) {
                    ACCOUNTS.add(current);
                    saveAlts();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (ACCOUNTS.isEmpty()) {
            ACCOUNTS.add("Steve");
        }
        loaded = true;
    }

    private static synchronized void saveAlts() {
        try {
            File f = getAltFile();
            try (FileWriter writer = new FileWriter(f, StandardCharsets.UTF_8)) {
                GSON.toJson(ACCOUNTS, writer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean login(String username) {
        if (username == null || username.trim().isEmpty()) return false;
        username = username.trim();
        try {
            UUID offlineUuid = UUID.nameUUIDFromBytes(("OfflinePlayer:" + username).getBytes(StandardCharsets.UTF_8));
            Session newSession = new Session(
                username,
                offlineUuid,
                "",
                Optional.empty(),
                Optional.empty(),
                Session.AccountType.MOJANG
            );

            try {
                ((IMinecraftClient) MinecraftClient.getInstance()).setSession(newSession);
            } catch (Throwable t) {
                try {
                    java.lang.reflect.Field unsafeField = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
                    unsafeField.setAccessible(true);
                    sun.misc.Unsafe unsafe = (sun.misc.Unsafe) unsafeField.get(null);
                    java.lang.reflect.Field sessionField = MinecraftClient.class.getDeclaredField("session");
                    long offset = unsafe.objectFieldOffset(sessionField);
                    unsafe.putObject(MinecraftClient.getInstance(), offset, newSession);
                } catch (Throwable t2) {
                    try {
                        java.lang.reflect.Field sessionField = MinecraftClient.class.getDeclaredField("session");
                        sessionField.setAccessible(true);
                        sessionField.set(MinecraftClient.getInstance(), newSession);
                    } catch (Throwable t3) {
                        t3.printStackTrace();
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static SkinTextures getSkinTextures(String username) {
        if (username == null || username.isBlank()) {
            return DefaultSkinHelper.getSkinTextures(UUID.randomUUID());
        }
        CompletableFuture<SkinTextures> future = SKIN_CACHE.computeIfAbsent(username, name ->
            CompletableFuture.supplyAsync(() -> {
                try {
                    SkinTextures official = IiIIIIiIi_Class134.I_method_de1d7e2b(name).get(2, java.util.concurrent.TimeUnit.SECONDS);
                    if (official != null) return official;
                } catch (Throwable ignored) {}

                try {
                    Identifier skinId = IiIIIIiIi_Class134.i_method_2cd18e4b("https://minotar.net/skin/" + name).get(3, java.util.concurrent.TimeUnit.SECONDS);
                    if (skinId != null) {
                        return new SkinTextures(skinId, null, null, null, SkinTextures.Model.WIDE, true);
                    }
                } catch (Throwable ignored) {}

                try {
                    Identifier skinId = IiIIIIiIi_Class134.i_method_2cd18e4b("https://cravatar.eu/skin/" + name).get(3, java.util.concurrent.TimeUnit.SECONDS);
                    if (skinId != null) {
                        return new SkinTextures(skinId, null, null, null, SkinTextures.Model.WIDE, true);
                    }
                } catch (Throwable ignored) {}

                return DefaultSkinHelper.getSkinTextures(UUID.nameUUIDFromBytes(name.getBytes(StandardCharsets.UTF_8)));
            })
        );
        SkinTextures res = future.getNow(null);
        return res != null ? res : DefaultSkinHelper.getSkinTextures(UUID.nameUUIDFromBytes(username.getBytes(StandardCharsets.UTF_8)));
    }

    private static String generateRandomName() {
        String[] prefixes = {"Frost", "Cyber", "Void", "Shadow", "Aura", "Ghost", "Solar", "Storm", "Hyper", "Viper", "Echo", "Zenith", "Quantum", "Apex", "Nova"};
        String[] suffixes = {"Blade", "Knight", "Rider", "Hunter", "Lord", "X", "Pro", "Star", "Zero", "Wolf", "King", "Strike", "Valkyrie", "Pulse", "Edge"};
        return prefixes[ThreadLocalRandom.current().nextInt(prefixes.length)] +
               suffixes[ThreadLocalRandom.current().nextInt(suffixes.length)] +
               (ThreadLocalRandom.current().nextInt(89) + 10);
    }

    private void selectAccount(int index) {
        if (ACCOUNTS.isEmpty()) return;
        this.selectedIndex = MathHelper.clamp(index, 0, ACCOUNTS.size() - 1);
        String acc = ACCOUNTS.get(this.selectedIndex);
        login(acc);
    }

    private void closeScreen() {
        this.isClosing = true;
    }

    @Override
    public void render(III var1) {
        int mx = var1.I_method_b1c3e152();
        int my = var1.i_method_b1d26d32();
        long now = System.currentTimeMillis();

        if (this.lastFrameTime == 0L) {
            this.lastFrameTime = now;
        }
        float dt = Math.min(0.05F, (float)(now - this.lastFrameTime) / 1000.0F);
        this.lastFrameTime = now;

        // Smooth Open / Close Animation
        if (this.isClosing) {
            this.openProgress = Math.max(0.0F, this.openProgress - dt * 6.5F);
            if (this.openProgress <= 0.005F) {
                MinecraftClient.getInstance().setScreen(this.parent);
                return;
            }
        } else {
            this.openProgress = Math.min(1.0F, this.openProgress + dt * 6.0F);
        }

        float t = this.openProgress;
        float ease = 1.0F - (float) Math.pow(1.0F - t, 3.0);
        float screenAlpha = MathHelper.clamp(ease, 0.0F, 1.0F);
        float scale = 0.88F + 0.12F * ease;

        ColorRGBA themeAccent = IiiiiIIIi_Class242.I_method_7df8e08e();
        IIiIIi_Class10 font = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.5F);
        IIiIIi_Class10 boldFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(10.5F);
        IIiIIi_Class10 smallFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.5F);

        // 1. ACTIVE WALLPAPER BACKGROUND (WITH PARALLAX)
        IiiIIiIii_Class204.renderWallpaperBackground(var1, this.width, this.height, (float)mx, (float)my);
        // Translucent dark vignette tint
        var1.drawRect(0.0F, 0.0F, (float)this.width, (float)this.height, new ColorRGBA(6.0F, 8.0F, 14.0F, 115.0F * screenAlpha));

        // Master Window Layout: compact & minimalist
        float cardW = Math.min(500.0F, this.width - 24.0F);
        float cardH = Math.min(290.0F, this.height - 24.0F);
        float cardX = this.width / 2.0F - cardW / 2.0F;
        float cardY = this.height / 2.0F - cardH / 2.0F;

        IIiii_Class8 rad12 = IIiii_Class8.I_method_893b2757(12.0F);
        IIiii_Class8 rad5 = IIiii_Class8.I_method_893b2757(5.0F);

        MatrixStack matrices = var1.getMatrices();
        matrices.push();
        float cardCX = cardX + cardW / 2.0F;
        float cardCY = cardY + cardH / 2.0F;
        matrices.translate(cardCX, cardCY, 0.0F);
        matrices.scale(scale, scale, 1.0F);
        matrices.translate(-cardCX, -cardCY, 0.0F);

        // Translucent Frosted Glass Card (less matte, high clarity glass allowing wallpaper blur through)
        var1.drawShadow(cardX, cardY, cardW, cardH, 20.0F, rad12, ColorRGBA.BLACK.withAlpha(150.0F * screenAlpha));
        var1.drawBlurredRect(cardX, cardY, cardW, cardH, 18.0F, 2.5F, rad12, ColorRGBA.WHITE.withAlpha(160.0F * screenAlpha));
        var1.drawRoundedRect(cardX, cardY, cardW, cardH, rad12, new ColorRGBA(10.0F, 12.0F, 18.0F, 155.0F * screenAlpha));
        var1.drawRoundedBorder(cardX, cardY, cardW, cardH, 1.0F, rad12, new ColorRGBA(255.0F, 255.0F, 255.0F, 35.0F * screenAlpha));

        // Minimalist Header Bar
        var1.drawRoundedRect(cardX + 14.0F, cardY + 12.0F, 4.0F, 11.0F, IIiii_Class8.I_method_893b2757(2.0F), themeAccent.withAlpha(255.0F * screenAlpha));
        var1.drawText(boldFont, "ALT MANAGER", cardX + 23.0F, cardY + 13.0F, ColorRGBA.WHITE.withAlpha(255.0F * screenAlpha));

        String accCountText = (this.selectedIndex + 1) + " / " + Math.max(1, ACCOUNTS.size());
        var1.drawText(smallFont, accCountText, cardX + 112.0F, cardY + 15.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 110.0F * screenAlpha));

        // Close Button [✕] in top right
        float closeSize = 18.0F;
        float closeX = cardX + cardW - closeSize - 10.0F;
        float closeY = cardY + 9.0F;
        boolean closeHov = iIIiIIIiI_Class291.I_method_c3f86263(closeX, closeY, closeSize, closeSize, mx, my);
        this.closeHover += (closeHov ? 1.0F - this.closeHover : -this.closeHover) * 0.25F;

        ColorRGBA closeBg = closeHov ? new ColorRGBA(220.0F, 45.0F, 55.0F, 220.0F * screenAlpha) : new ColorRGBA(255.0F, 255.0F, 255.0F, 12.0F * screenAlpha);
        var1.drawRoundedRect(closeX, closeY, closeSize, closeSize, rad5, closeBg);
        float pad = 5.0F;
        ColorRGBA crossCol = closeHov ? ColorRGBA.WHITE : new ColorRGBA(220.0F, 225.0F, 240.0F, 180.0F * screenAlpha);
        var1.drawLine(new Vec2f(closeX + pad, closeY + pad), new Vec2f(closeX + closeSize - pad, closeY + closeSize - pad), crossCol);
        var1.drawLine(new Vec2f(closeX + closeSize - pad, closeY + pad), new Vec2f(closeX + pad, closeY + closeSize - pad), crossCol);

        // Pose Switcher Icon Button (Top right, next to close button)
        float poseBtnSize = 18.0F;
        float poseBtnX = closeX - poseBtnSize - 6.0F;
        float poseBtnY = cardY + 9.0F;
        boolean poseBtnHov = iIIiIIIiI_Class291.I_method_c3f86263(poseBtnX, poseBtnY, poseBtnSize, poseBtnSize, mx, my);
        this.poseBtnHover += (poseBtnHov ? 1.0F - this.poseBtnHover : -this.poseBtnHover) * 0.25F;
        IIiii_Class8 radPoseBtn = IIiii_Class8.I_method_893b2757(poseBtnSize / 2.0F);
        var1.drawRoundedRect(poseBtnX, poseBtnY, poseBtnSize, poseBtnSize, radPoseBtn, this.poseMenuOpen ? themeAccent.withAlpha(120.0F * screenAlpha) : (poseBtnHov ? themeAccent.withAlpha(70.0F * screenAlpha) : new ColorRGBA(255.0F, 255.0F, 255.0F, 14.0F * screenAlpha)));
        var1.drawRoundedBorder(poseBtnX, poseBtnY, poseBtnSize, poseBtnSize, 0.8F, radPoseBtn, this.poseMenuOpen ? themeAccent.withAlpha(220.0F * screenAlpha) : (poseBtnHov ? themeAccent.withAlpha(180.0F * screenAlpha) : new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F * screenAlpha)));
        var1.drawIcon("hud/player", poseBtnX + 3.0F, poseBtnY + 3.0F, 12.0F, ColorRGBA.WHITE.withAlpha((poseBtnHov || this.poseMenuOpen) ? 255.0F * screenAlpha : 190.0F * screenAlpha));

        // Clamp selectedIndex & smoothly animate carousel
        if (ACCOUNTS.isEmpty()) {
            ACCOUNTS.add("Steve");
        }
        this.selectedIndex = MathHelper.clamp(this.selectedIndex, 0, ACCOUNTS.size() - 1);
        this.carouselAnim += ((float)this.selectedIndex - this.carouselAnim) * 0.18F;
        if (Math.abs((float)this.selectedIndex - this.carouselAnim) < 0.002F) {
            this.carouselAnim = this.selectedIndex;
        }

        // ==========================================
        // BEDROCK 3D SKIN CAROUSEL STAGE
        // ==========================================
        float carouselCX = cardX + cardW / 2.0F;
        float carouselCY = cardY + 128.0F;
        float itemSpacing = 135.0F;
        float timeSec = (float)((now % 10000000L) / 1000.0);

        // Ensure 3D player model initialized
        if (PLAYER_MODEL == null) {
            PLAYER_MODEL = new PlayerEntityModel(MinecraftClient.getInstance().getLoadedEntityModels().getModelPart(EntityModelLayers.PLAYER), false);
        }

        // Handle center model idle rotation / drag
        if (!this.isDraggingModel) {
            this.modelRotationYaw += this.modelRotationVel;
            this.modelRotationVel *= 0.90F;
        }

        // Visible models (max 5: rel from -2.45 to +2.45)
        List<Integer> visibleIndices = new ArrayList<>();
        for (int i = 0; i < ACCOUNTS.size(); i++) {
            float rel = (float) i - this.carouselAnim;
            if (Math.abs(rel) <= 2.45F) {
                visibleIndices.add(i);
            }
        }

        // Sort painter's order: furthest models first, center model last
        visibleIndices.sort((a, b) -> Float.compare(Math.abs((float) b - this.carouselAnim), Math.abs((float) a - this.carouselAnim)));

        // Clip 3D skins to card area so the 2 outer edge skins are half cut-off cleanly
        double guiScale = MinecraftClient.getInstance().getWindow().getScaleFactor();
        int scissorX = (int)((cardX + 2.0F) * guiScale);
        int scissorY = (int)((this.height - (cardY + cardH - 2.0F)) * guiScale);
        int scissorW = (int)((cardW - 4.0F) * guiScale);
        int scissorH = (int)((cardH - 4.0F) * guiScale);
        RenderSystem.enableScissor(scissorX, scissorY, scissorW, scissorH);

        var1.draw(); // Flush 2D batch before 3D calls
        RenderSystem.enableDepthTest();
        RenderSystem.depthMask(true);
        RenderSystem.disableCull();

        VertexConsumerProvider.Immediate vertexConsumers = MinecraftClient.getInstance().getBufferBuilders().getEntityVertexConsumers();

        for (int idx : visibleIndices) {
            String acc = ACCOUNTS.get(idx);
            SkinTextures skin = getSkinTextures(acc);
            float rel = (float) idx - this.carouselAnim;
            float absRel = Math.abs(rel);
            boolean isSelected = (idx == this.selectedIndex);

            float posX = carouselCX + rel * itemSpacing;
            float baseScale = 72.0F;
            float mScale = baseScale * (1.0F - 0.22F * Math.min(2.0F, absRel));
            float alpha = MathHelper.clamp(1.0F - absRel * 0.35F, 0.22F, 1.0F) * screenAlpha;

            // Facing: 180° rotation so the model faces directly TOWARDS the user!
            float yawDeg = isSelected ? this.modelRotationYaw : (-rel * 24.0F);

            // Apply smooth, natural 3D character poses that look great from all 360°
            applySmoothPose(idx, isSelected, timeSec);

            MatrixStack m = var1.getMatrices();
            m.push();
            m.translate(posX, carouselCY - 16.0F, 120.0F - absRel * 40.0F);
            m.scale(mScale, mScale, mScale);
            // 180° ensures front face and eyes point straight at the camera
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F + yawDeg));

            int alphaInt = (int)(alpha * 255.0F);
            int colorTint = (alphaInt << 24) | 0x00FFFFFF;

            try {
                VertexConsumer vc = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(skin.texture()));
                PLAYER_MODEL.render(m, vc, 15728880, OverlayTexture.DEFAULT_UV, colorTint);
            } catch (Throwable ignored) {}

            m.pop();
        }

        vertexConsumers.draw();
        RenderSystem.enableCull();
        RenderSystem.disableDepthTest();
        RenderSystem.disableScissor();

        // ==========================================
        // BEDROCK NAVIGATION ARROWS [<] and [>]
        // ==========================================
        float arrowW = 22.0F;
        float arrowH = 34.0F;
        float arrowY = carouselCY - arrowH / 2.0F;

        // Left Arrow [<]
        float leftArrowX = cardX + 12.0F;
        boolean canGoLeft = this.selectedIndex > 0;
        boolean leftHov = canGoLeft && iIIiIIIiI_Class291.I_method_c3f86263(leftArrowX, arrowY, arrowW, arrowH, mx, my);
        this.leftArrowHover += (leftHov ? 1.0F - this.leftArrowHover : -this.leftArrowHover) * 0.25F;

        ColorRGBA lArrowBg = canGoLeft
            ? (leftHov ? themeAccent.withAlpha(90.0F * screenAlpha) : new ColorRGBA(255.0F, 255.0F, 255.0F, 14.0F * screenAlpha))
            : new ColorRGBA(255.0F, 255.0F, 255.0F, 6.0F * screenAlpha);
        var1.drawRoundedRect(leftArrowX, arrowY, arrowW, arrowH, rad5, lArrowBg);
        if (leftHov) {
            var1.drawRoundedBorder(leftArrowX, arrowY, arrowW, arrowH, 1.0F, rad5, themeAccent.withAlpha(200.0F * screenAlpha));
        }
        ColorRGBA lChevronCol = canGoLeft ? (leftHov ? ColorRGBA.WHITE : new ColorRGBA(210.0F, 215.0F, 230.0F, 180.0F * screenAlpha)) : new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F * screenAlpha);
        float lMidY = arrowY + arrowH / 2.0F;
        float lTipX = leftArrowX + 7.0F;
        float lBaseX = leftArrowX + 15.0F;
        var1.drawLine(new Vec2f(lBaseX, lMidY - 6.0F), new Vec2f(lTipX, lMidY), lChevronCol);
        var1.drawLine(new Vec2f(lTipX, lMidY), new Vec2f(lBaseX, lMidY + 6.0F), lChevronCol);

        // Right Arrow [>]
        float rightArrowX = cardX + cardW - arrowW - 12.0F;
        boolean canGoRight = this.selectedIndex < ACCOUNTS.size() - 1;
        boolean rightHov = canGoRight && iIIiIIIiI_Class291.I_method_c3f86263(rightArrowX, arrowY, arrowW, arrowH, mx, my);
        this.rightArrowHover += (rightHov ? 1.0F - this.rightArrowHover : -this.rightArrowHover) * 0.25F;

        ColorRGBA rArrowBg = canGoRight
            ? (rightHov ? themeAccent.withAlpha(90.0F * screenAlpha) : new ColorRGBA(255.0F, 255.0F, 255.0F, 14.0F * screenAlpha))
            : new ColorRGBA(255.0F, 255.0F, 255.0F, 6.0F * screenAlpha);
        var1.drawRoundedRect(rightArrowX, arrowY, arrowW, arrowH, rad5, rArrowBg);
        if (rightHov) {
            var1.drawRoundedBorder(rightArrowX, arrowY, arrowW, arrowH, 1.0F, rad5, themeAccent.withAlpha(200.0F * screenAlpha));
        }
        ColorRGBA rChevronCol = canGoRight ? (rightHov ? ColorRGBA.WHITE : new ColorRGBA(210.0F, 215.0F, 230.0F, 180.0F * screenAlpha)) : new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F * screenAlpha);
        float rMidY = arrowY + arrowH / 2.0F;
        float rTipX = rightArrowX + arrowW - 7.0F;
        float rBaseX = rightArrowX + arrowW - 15.0F;
        var1.drawLine(new Vec2f(rBaseX, rMidY - 6.0F), new Vec2f(rTipX, rMidY), rChevronCol);
        var1.drawLine(new Vec2f(rTipX, rMidY), new Vec2f(rBaseX, rMidY + 6.0F), rChevronCol);

        // ==========================================
        // SELECTED ACCOUNT INFO (ABOVE CENTER MODEL)
        // ==========================================
        String currentSession = MinecraftClient.getInstance().getSession().getUsername();
        String selNick = (!ACCOUNTS.isEmpty() && this.selectedIndex < ACCOUNTS.size()) ? ACCOUNTS.get(this.selectedIndex) : "Steve";
        boolean isCurrentActive = selNick.equalsIgnoreCase(currentSession);

        float nameY = cardY + 36.0F;
        var1.drawCenteredText(boldFont, selNick, carouselCX, nameY, ColorRGBA.WHITE.withAlpha(255.0F * screenAlpha));



        float dotsY = cardY + cardH - 58.0F;

        // Carousel Dots Indicator (below model)
        int dotCount = Math.min(10, ACCOUNTS.size());
        if (dotCount > 1) {
            float dotGap = 8.0F;
            float totalDotsW = (dotCount - 1) * dotGap;
            float startDotX = carouselCX - totalDotsW / 2.0F;
            for (int d = 0; d < dotCount; d++) {
                boolean activeDot = (d == this.selectedIndex);
                float dotSize = activeDot ? 4.5F : 3.0F;
                ColorRGBA dotCol = activeDot ? themeAccent.withAlpha(255.0F * screenAlpha) : new ColorRGBA(255.0F, 255.0F, 255.0F, 60.0F * screenAlpha);
                var1.drawRoundedRect(startDotX + d * dotGap - dotSize / 2.0F, dotsY - dotSize / 2.0F, dotSize, dotSize, IIiii_Class8.I_method_893b2757(dotSize / 2.0F), dotCol);
            }
        }

        // ==========================================
        // CENTERED INPUT & CONTROLS ROW AT BOTTOM
        // ("кнопку войти вырезали, кнопки матовое стекло, ввод по центру")
        // ==========================================
        float inBarY = cardY + cardH - 36.0F;
        float pasteBtnW = 48.0F;
        float inputW = 180.0F;
        float rndBtnW = 58.0F;
        float delBtnW = 24.0F;
        float gap = 6.0F;
        float totalControlsW = pasteBtnW + gap + inputW + gap + rndBtnW + gap + delBtnW;
        float startControlsX = cardX + (cardW - totalControlsW) / 2.0F;

        // 1. Frosted Glass Paste Button [Буфер]
        float pasteX = startControlsX;
        boolean pasteHov = iIIiIIIiI_Class291.I_method_c3f86263(pasteX, inBarY, pasteBtnW, 22.0F, mx, my);
        this.pasteHover += (pasteHov ? 1.0F - this.pasteHover : -this.pasteHover) * 0.25F;
        renderFrostedGlassButton(var1, pasteX, inBarY, pasteBtnW, 22.0F, "Буфер", font, pasteHov, this.pasteHover, themeAccent, screenAlpha);

        // 2. Centered Nickname Input Field
        float inFieldX = pasteX + pasteBtnW + gap;
        var1.drawBlurredRect(inFieldX, inBarY, inputW, 22.0F, 6.0F, rad5, ColorRGBA.WHITE.withAlpha(25.0F * screenAlpha));
        ColorRGBA inBorder = this.inputFocused ? themeAccent.withAlpha(220.0F * screenAlpha) : new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F * screenAlpha);
        var1.drawRoundedRect(inFieldX, inBarY, inputW, 22.0F, rad5, new ColorRGBA(12.0F, 14.0F, 20.0F, 190.0F * screenAlpha));
        var1.drawRoundedBorder(inFieldX, inBarY, inputW, 22.0F, 1.0F, rad5, inBorder);

        String displayInput = this.inputText.isEmpty() ? (this.inputFocused ? "" : "Введите ник...") : this.inputText;
        ColorRGBA inTextCol = this.inputText.isEmpty() ? ColorRGBA.WHITE.withAlpha(85.0F * screenAlpha) : ColorRGBA.WHITE.withAlpha(255.0F * screenAlpha);
        var1.drawText(font, displayInput, inFieldX + 7.0F, inBarY + 6.5F, inTextCol);

        if (this.inputFocused && (System.currentTimeMillis() % 1000L) < 500L) {
            float curX = inFieldX + 7.0F + font.I_method_2c375926(this.inputText);
            var1.drawRoundedRect(curX, inBarY + 4.5F, 1.2F, 13.0F, IIiii_Class8.I_method_893b2757(0.5F), themeAccent.withAlpha(255.0F * screenAlpha));
        }

        // 3. Frosted Glass Random Button [Рандом]
        float rndX = inFieldX + inputW + gap;
        boolean rndHov = iIIiIIIiI_Class291.I_method_c3f86263(rndX, inBarY, rndBtnW, 22.0F, mx, my);
        this.rndHover += (rndHov ? 1.0F - this.rndHover : -this.rndHover) * 0.25F;
        renderFrostedGlassButton(var1, rndX, inBarY, rndBtnW, 22.0F, "Рандом", font, rndHov, this.rndHover, themeAccent, screenAlpha);

        // 4. Frosted Glass Delete Button [✕]
        float delX = rndX + rndBtnW + gap;
        boolean delHov = iIIiIIIiI_Class291.I_method_c3f86263(delX, inBarY, delBtnW, 22.0F, mx, my);
        this.delHover += (delHov ? 1.0F - this.delHover : -this.delHover) * 0.25F;
        renderFrostedGlassDeleteButton(var1, delX, inBarY, delBtnW, 22.0F, delHov, this.delHover, screenAlpha);

        // ==========================================
        // FLOATING POSE DROPDOWN MENU OVERLAY
        // ==========================================
        if (this.poseMenuOpen) {
            float menuW = 152.0F;
            float rowH = 20.0F;
            float menuH = POSE_NAMES.length * rowH + 8.0F;
            float menuX = poseBtnX + poseBtnSize - menuW;
            float menuY = poseBtnY + poseBtnSize + 6.0F;
            IIiii_Class8 radMenu = IIiii_Class8.I_method_893b2757(8.0F);

            var1.drawShadow(menuX, menuY, menuW, menuH, 16.0F, radMenu, new ColorRGBA(0.0F, 0.0F, 0.0F, 180.0F * screenAlpha));
            var1.drawBlurredRect(menuX, menuY, menuW, menuH, 16.0F, 3.0F, radMenu, new ColorRGBA(20.0F, 24.0F, 36.0F, 200.0F * screenAlpha));
            var1.drawRoundedRect(menuX, menuY, menuW, menuH, radMenu, new ColorRGBA(12.0F, 15.0F, 24.0F, 245.0F * screenAlpha));
            var1.drawRoundedBorder(menuX, menuY, menuW, menuH, 1.0F, radMenu, new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F * screenAlpha));

            String currentNick = (!ACCOUNTS.isEmpty() && this.selectedIndex < ACCOUNTS.size()) ? ACCOUNTS.get(this.selectedIndex) : "Steve";
            SkinTextures previewSkin = getSkinTextures(currentNick);

            var1.draw(); // Flush 2D batch
            RenderSystem.enableDepthTest();
            RenderSystem.depthMask(true);
            RenderSystem.disableCull();

            float rowY = menuY + 4.0F;
            for (int p = 0; p < POSE_NAMES.length; p++) {
                boolean rowHov = mx >= menuX + 4.0F && mx <= menuX + menuW - 4.0F && my >= rowY && my <= rowY + rowH;
                boolean isCurrent = (p == currentPoseIndex % POSE_NAMES.length);

                if (rowHov || isCurrent) {
                    var1.drawRoundedRect(menuX + 4.0F, rowY, menuW - 8.0F, rowH, IIiii_Class8.I_method_893b2757(5.0F), isCurrent ? themeAccent.withAlpha(70.0F * screenAlpha) : new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F * screenAlpha));
                }

                // Mini preview for each pose
                applySmoothPose(p, true, 0.0F);
                MatrixStack mm = var1.getMatrices();
                mm.push();
                mm.translate(menuX + 15.0F, rowY + 3.0F, 260.0F);
                mm.scale(8.0F, 8.0F, 8.0F);
                mm.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F));

                try {
                    VertexConsumer vc = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(previewSkin.texture()));
                    PLAYER_MODEL.render(mm, vc, 15728880, OverlayTexture.DEFAULT_UV, 0xFFFFFFFF);
                } catch (Throwable ignored) {}
                mm.pop();

                rowY += rowH;
            }

            vertexConsumers.draw();
            RenderSystem.enableCull();
            RenderSystem.disableDepthTest();

            // Restore center model pose
            applySmoothPose(this.selectedIndex, true, timeSec);

            // Draw pose names over rows
            rowY = menuY + 4.0F;
            for (int p = 0; p < POSE_NAMES.length; p++) {
                boolean isCurrent = (p == currentPoseIndex % POSE_NAMES.length);
                ColorRGBA textColor = isCurrent ? themeAccent : ColorRGBA.WHITE.withAlpha(220.0F * screenAlpha);
                var1.drawText(smallFont, POSE_NAMES[p], menuX + 30.0F, rowY + 5.5F, textColor);
                if (isCurrent) {
                    var1.drawText(smallFont, "✓", menuX + menuW - 16.0F, rowY + 5.5F, themeAccent);
                }
                rowY += rowH;
            }
        }

        matrices.pop();
    }

    private void renderFrostedGlassButton(III var1, float x, float y, float w, float h, String text, IIiIIi_Class10 font, boolean hov, float hovAnim, ColorRGBA accentCol, float screenAlpha) {
        float lift = -1.2F * hovAnim;
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(5.0F);

        // Soft frosted blur behind button
        var1.drawBlurredRect(x, y + lift, w, h, 6.0F, rad, ColorRGBA.WHITE.withAlpha(25.0F * screenAlpha));

        // Translucent glass fill with accent tint on hover
        ColorRGBA baseGlass = new ColorRGBA(255.0F, 255.0F, 255.0F, (14.0F + 16.0F * hovAnim) * screenAlpha);
        ColorRGBA fillCol = baseGlass.mix(accentCol.withAlpha(70.0F * screenAlpha), 0.35F * hovAnim);
        var1.drawRoundedRect(x, y + lift, w, h, rad, fillCol);

        // Specular glass border
        ColorRGBA borderCol = hov
            ? accentCol.withAlpha(210.0F * screenAlpha)
            : new ColorRGBA(255.0F, 255.0F, 255.0F, (28.0F + 20.0F * hovAnim) * screenAlpha);
        var1.drawRoundedBorder(x, y + lift, w, h, 0.9F, rad, borderCol);

        // Subtle top specular gleam
        var1.drawRoundedRect(x + 2.0F, y + lift + 1.0F, w - 4.0F, 1.0F, IIiii_Class8.I_method_893b2757(0.5F), new ColorRGBA(255.0F, 255.0F, 255.0F, (40.0F + 30.0F * hovAnim) * screenAlpha));

        // Text
        ColorRGBA textCol = hov ? ColorRGBA.WHITE : new ColorRGBA(225.0F, 230.0F, 245.0F, 230.0F * screenAlpha);
        var1.drawCenteredText(font, text, x + w / 2.0F, y + lift + (h - 7.0F) / 2.0F, textCol);
    }

    private void renderFrostedGlassDeleteButton(III var1, float x, float y, float w, float h, boolean hov, float hovAnim, float screenAlpha) {
        float lift = -1.2F * hovAnim;
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(5.0F);

        var1.drawBlurredRect(x, y + lift, w, h, 6.0F, rad, ColorRGBA.WHITE.withAlpha(25.0F * screenAlpha));

        ColorRGBA fillCol = hov
            ? new ColorRGBA(220.0F, 45.0F, 55.0F, (160.0F + 50.0F * hovAnim) * screenAlpha)
            : new ColorRGBA(255.0F, 255.0F, 255.0F, 14.0F * screenAlpha);
        var1.drawRoundedRect(x, y + lift, w, h, rad, fillCol);

        ColorRGBA borderCol = hov
            ? new ColorRGBA(255.0F, 90.0F, 100.0F, 220.0F * screenAlpha)
            : new ColorRGBA(255.0F, 255.0F, 255.0F, 28.0F * screenAlpha);
        var1.drawRoundedBorder(x, y + lift, w, h, 0.9F, rad, borderCol);

        float dPad = 6.5F;
        ColorRGBA dCrossCol = hov ? ColorRGBA.WHITE : new ColorRGBA(220.0F, 225.0F, 240.0F, 170.0F * screenAlpha);
        var1.drawLine(new Vec2f(x + dPad, y + lift + dPad), new Vec2f(x + w - dPad, y + lift + h - dPad), dCrossCol);
        var1.drawLine(new Vec2f(x + w - dPad, y + lift + dPad), new Vec2f(x + dPad, y + lift + h - dPad), dCrossCol);
    }

    private void resetModelRotations() {
        if (PLAYER_MODEL == null) return;
        PLAYER_MODEL.head.pitch = 0.0F;
        PLAYER_MODEL.head.yaw = 0.0F;
        PLAYER_MODEL.head.roll = 0.0F;
        PLAYER_MODEL.body.pitch = 0.0F;
        PLAYER_MODEL.body.yaw = 0.0F;
        PLAYER_MODEL.body.roll = 0.0F;
        PLAYER_MODEL.leftArm.pitch = 0.0F;
        PLAYER_MODEL.leftArm.yaw = 0.0F;
        PLAYER_MODEL.leftArm.roll = 0.0F;
        PLAYER_MODEL.rightArm.pitch = 0.0F;
        PLAYER_MODEL.rightArm.yaw = 0.0F;
        PLAYER_MODEL.rightArm.roll = 0.0F;
        PLAYER_MODEL.leftLeg.pitch = 0.0F;
        PLAYER_MODEL.leftLeg.yaw = 0.0F;
        PLAYER_MODEL.leftLeg.roll = 0.0F;
        PLAYER_MODEL.rightLeg.pitch = 0.0F;
        PLAYER_MODEL.rightLeg.yaw = 0.0F;
        PLAYER_MODEL.rightLeg.roll = 0.0F;
    }

    // Smooth, organic 3D character poses looking great from all 360°
    private void applySmoothPose(int accountIdx, boolean isSelected, float timeSec) {
        resetModelRotations();

        int pose = isSelected ? (currentPoseIndex % POSE_NAMES.length) : (Math.abs(accountIdx) % POSE_NAMES.length);
        float breath = (float) Math.sin(timeSec * 2.2F) * 0.03F;

        if (isSelected) {
            switch (pose) {
                case 0 -> { // Friendly Wave
                    float wave = (float) Math.sin(timeSec * 4.2F) * 0.22F;
                    PLAYER_MODEL.rightArm.pitch = -2.35F;
                    PLAYER_MODEL.rightArm.yaw = -0.15F;
                    PLAYER_MODEL.rightArm.roll = 0.45F + wave;
                    PLAYER_MODEL.head.pitch = -0.06F + breath;
                    PLAYER_MODEL.head.roll = 0.08F;
                    PLAYER_MODEL.head.yaw = wave * 0.20F;
                    PLAYER_MODEL.leftArm.pitch = 0.15F + breath;
                    PLAYER_MODEL.leftArm.roll = -0.20F;
                    PLAYER_MODEL.leftLeg.pitch = 0.05F;
                    PLAYER_MODEL.rightLeg.pitch = -0.05F;
                    PLAYER_MODEL.leftLeg.roll = -0.05F;
                    PLAYER_MODEL.rightLeg.roll = 0.05F;
                }
                case 1 -> { // Confident Stance
                    float sway = (float) Math.sin(timeSec * 1.8F) * 0.04F;
                    PLAYER_MODEL.body.roll = sway;
                    PLAYER_MODEL.head.yaw = -sway * 1.5F;
                    PLAYER_MODEL.head.pitch = -0.04F + breath;
                    PLAYER_MODEL.rightArm.pitch = 0.25F;
                    PLAYER_MODEL.rightArm.roll = 0.40F;
                    PLAYER_MODEL.rightArm.yaw = 0.12F;
                    PLAYER_MODEL.leftArm.pitch = 0.25F;
                    PLAYER_MODEL.leftArm.roll = -0.40F;
                    PLAYER_MODEL.leftArm.yaw = -0.12F;
                    PLAYER_MODEL.leftLeg.roll = -0.08F;
                    PLAYER_MODEL.rightLeg.roll = 0.08F;
                }
                case 2 -> { // The Thinker
                    float thinkBob = (float) Math.sin(timeSec * 1.5F) * 0.03F;
                    PLAYER_MODEL.head.pitch = 0.12F + thinkBob;
                    PLAYER_MODEL.head.yaw = -0.16F;
                    PLAYER_MODEL.head.roll = 0.06F;
                    PLAYER_MODEL.rightArm.pitch = -1.75F;
                    PLAYER_MODEL.rightArm.roll = -0.20F;
                    PLAYER_MODEL.rightArm.yaw = -0.32F;
                    PLAYER_MODEL.leftArm.pitch = 0.35F;
                    PLAYER_MODEL.leftArm.roll = -0.38F;
                    PLAYER_MODEL.leftArm.yaw = -0.15F;
                    PLAYER_MODEL.leftLeg.roll = -0.06F;
                    PLAYER_MODEL.rightLeg.roll = 0.06F;
                }
                case 3 -> { // Heroic Champion
                    float victoryBob = (float) Math.sin(timeSec * 2.0F) * 0.06F;
                    PLAYER_MODEL.rightArm.pitch = -2.60F + victoryBob;
                    PLAYER_MODEL.rightArm.roll = 0.18F;
                    PLAYER_MODEL.head.pitch = -0.18F;
                    PLAYER_MODEL.leftArm.pitch = 0.25F;
                    PLAYER_MODEL.leftArm.roll = -0.22F;
                    PLAYER_MODEL.body.pitch = -0.04F;
                    PLAYER_MODEL.leftLeg.roll = -0.07F;
                    PLAYER_MODEL.rightLeg.roll = 0.07F;
                }
                case 4 -> { // Relaxed Swagger
                    float swing = (float) Math.sin(timeSec * 2.2F) * 0.22F;
                    PLAYER_MODEL.rightArm.pitch = swing;
                    PLAYER_MODEL.leftArm.pitch = -swing;
                    PLAYER_MODEL.rightArm.roll = 0.10F;
                    PLAYER_MODEL.leftArm.roll = -0.10F;
                    PLAYER_MODEL.head.roll = (float) Math.sin(timeSec * 1.1F) * 0.06F;
                    PLAYER_MODEL.head.pitch = -0.04F + breath;
                    PLAYER_MODEL.leftLeg.roll = -0.06F;
                    PLAYER_MODEL.rightLeg.roll = 0.06F;
                }
                case 5 -> { // Sneaking Combat Stance
                    PLAYER_MODEL.body.pitch = 0.45F;
                    PLAYER_MODEL.head.pitch = -0.40F + breath;
                    PLAYER_MODEL.rightArm.pitch = -0.35F;
                    PLAYER_MODEL.rightArm.roll = 0.25F;
                    PLAYER_MODEL.leftArm.pitch = 0.35F;
                    PLAYER_MODEL.leftArm.roll = -0.25F;
                    PLAYER_MODEL.leftLeg.pitch = -0.45F;
                    PLAYER_MODEL.rightLeg.pitch = 0.45F;
                }
                case 6 -> { // Bow Aim
                    PLAYER_MODEL.head.yaw = -0.45F;
                    PLAYER_MODEL.head.pitch = -0.10F;
                    PLAYER_MODEL.rightArm.pitch = -1.55F;
                    PLAYER_MODEL.rightArm.yaw = -0.45F;
                    PLAYER_MODEL.rightArm.roll = 0.10F;
                    PLAYER_MODEL.leftArm.pitch = -1.55F;
                    PLAYER_MODEL.leftArm.yaw = 0.45F;
                    PLAYER_MODEL.leftArm.roll = -0.10F;
                }
                case 7 -> { // Sword Guard
                    PLAYER_MODEL.rightArm.pitch = -0.90F;
                    PLAYER_MODEL.rightArm.yaw = -0.35F;
                    PLAYER_MODEL.rightArm.roll = -0.35F;
                    PLAYER_MODEL.leftArm.pitch = -0.45F;
                    PLAYER_MODEL.leftArm.roll = 0.35F;
                    PLAYER_MODEL.head.pitch = 0.08F;
                    PLAYER_MODEL.leftLeg.pitch = 0.15F;
                    PLAYER_MODEL.rightLeg.pitch = -0.15F;
                }
                case 8 -> { // Dab
                    PLAYER_MODEL.head.pitch = 0.45F;
                    PLAYER_MODEL.head.yaw = 0.65F;
                    PLAYER_MODEL.leftArm.pitch = -1.45F;
                    PLAYER_MODEL.leftArm.roll = -1.25F;
                    PLAYER_MODEL.rightArm.pitch = -1.55F;
                    PLAYER_MODEL.rightArm.roll = -1.55F;
                }
                case 9 -> { // T-Pose
                    PLAYER_MODEL.rightArm.pitch = 0.0F;
                    PLAYER_MODEL.rightArm.roll = 1.57F;
                    PLAYER_MODEL.leftArm.pitch = 0.0F;
                    PLAYER_MODEL.leftArm.roll = -1.57F;
                    PLAYER_MODEL.head.pitch = breath;
                }
            }
        } else {
            // Subtle breathing idle rhythm for flanking puppets
            float puppetSway = (float) Math.sin(timeSec * 2.0F + accountIdx) * 0.05F;
            PLAYER_MODEL.head.pitch = puppetSway * 0.5F;
            PLAYER_MODEL.leftArm.pitch = puppetSway;
            PLAYER_MODEL.rightArm.pitch = -puppetSway;
            PLAYER_MODEL.leftArm.roll = 0.08F;
            PLAYER_MODEL.rightArm.roll = -0.08F;
        }
    }

    @Override
    public void onMouseClicked(double mouseX, double mouseY, IiIII_Class9 button) {
        if (button != IiIII_Class9.I_field_2f4c8d6c) return;

        float cardW = Math.min(500.0F, this.width - 24.0F);
        float cardH = Math.min(290.0F, this.height - 24.0F);
        float cardX = this.width / 2.0F - cardW / 2.0F;
        float cardY = this.height / 2.0F - cardH / 2.0F;

        // Close Button [✕]
        float closeSize = 18.0F;
        float closeX = cardX + cardW - closeSize - 10.0F;
        float closeY = cardY + 9.0F;
        if (iIIiIIIiI_Class291.I_method_c3f86263(closeX, closeY, closeSize, closeSize, mouseX, mouseY)) {
            closeScreen();
            return;
        }

        // Pose Switcher Icon Button (Top right, next to close button)
        float poseBtnSize = 18.0F;
        float poseBtnX = closeX - poseBtnSize - 6.0F;
        float poseBtnY = cardY + 9.0F;
        if (iIIiIIIiI_Class291.I_method_c3f86263(poseBtnX, poseBtnY, poseBtnSize, poseBtnSize, mouseX, mouseY)) {
            this.poseMenuOpen = !this.poseMenuOpen;
            UISoundManager.playButtonClick();
            return;
        }

        // Handle Pose Dropdown Selection if open
        if (this.poseMenuOpen) {
            float menuW = 152.0F;
            float rowH = 20.0F;
            float menuH = POSE_NAMES.length * rowH + 8.0F;
            float menuX = poseBtnX + poseBtnSize - menuW;
            float menuY = poseBtnY + poseBtnSize + 6.0F;

            if (mouseX >= menuX && mouseX <= menuX + menuW && mouseY >= menuY && mouseY <= menuY + menuH) {
                float rowY = menuY + 4.0F;
                for (int p = 0; p < POSE_NAMES.length; p++) {
                    if (mouseY >= rowY && mouseY <= rowY + rowH) {
                        currentPoseIndex = p;
                        this.poseMenuOpen = false;
                        UISoundManager.playButtonClick();
                        return;
                    }
                    rowY += rowH;
                }
                return;
            } else {
                this.poseMenuOpen = false;
                return;
            }
        }

        // Navigation Arrows [<] and [>]
        float carouselCY = cardY + 128.0F;
        float arrowW = 22.0F;
        float arrowH = 34.0F;
        float arrowY = carouselCY - arrowH / 2.0F;

        // Left Arrow
        float leftArrowX = cardX + 12.0F;
        if (iIIiIIIiI_Class291.I_method_c3f86263(leftArrowX, arrowY, arrowW, arrowH, mouseX, mouseY)) {
            if (this.selectedIndex > 0) {
                selectAccount(this.selectedIndex - 1);
            }
            return;
        }

        // Right Arrow
        float rightArrowX = cardX + cardW - arrowW - 12.0F;
        if (iIIiIIIiI_Class291.I_method_c3f86263(rightArrowX, arrowY, arrowW, arrowH, mouseX, mouseY)) {
            if (this.selectedIndex < ACCOUNTS.size() - 1) {
                selectAccount(this.selectedIndex + 1);
            }
            return;
        }

        // Click on Carousel 3D models area
        float carouselCX = cardX + cardW / 2.0F;
        if (mouseY >= cardY + 45.0F && mouseY <= cardY + cardH - 50.0F) {
            // Click on Center Model: start dragging rotation
            if (Math.abs(mouseX - carouselCX) < 45.0F) {
                this.isDraggingModel = true;
                this.lastDragMouseX = mouseX;
                return;
            }
            // Click on Left Model (sel - 1)
            if (mouseX >= carouselCX - 180.0F && mouseX < carouselCX - 45.0F) {
                if (this.selectedIndex > 0) {
                    selectAccount(this.selectedIndex - 1);
                }
                return;
            }
            // Click on Right Model (sel + 1)
            if (mouseX > carouselCX + 45.0F && mouseX <= carouselCX + 180.0F) {
                if (this.selectedIndex < ACCOUNTS.size() - 1) {
                    selectAccount(this.selectedIndex + 1);
                }
                return;
            }
        }

        // Centered Bottom Controls
        float inBarY = cardY + cardH - 36.0F;
        float pasteBtnW = 48.0F;
        float inputW = 180.0F;
        float rndBtnW = 58.0F;
        float delBtnW = 24.0F;
        float gap = 6.0F;
        float totalControlsW = pasteBtnW + gap + inputW + gap + rndBtnW + gap + delBtnW;
        float startControlsX = cardX + (cardW - totalControlsW) / 2.0F;

        // 1. Paste Button
        float pasteX = startControlsX;
        if (iIIiIIIiI_Class291.I_method_c3f86263(pasteX, inBarY, pasteBtnW, 22.0F, mouseX, mouseY)) {
            try {
                String clip = MinecraftClient.getInstance().keyboard.getClipboard();
                if (clip != null && !clip.trim().isEmpty()) {
                    this.inputText = clip.trim().replaceAll("[^a-zA-Z0-9_]", "");
                    this.inputFocused = true;
                }
            } catch (Throwable ignored) {}
            return;
        }

        // 2. Input Field Focus
        float inFieldX = pasteX + pasteBtnW + gap;
        if (iIIiIIIiI_Class291.I_method_c3f86263(inFieldX, inBarY, inputW, 22.0F, mouseX, mouseY)) {
            this.inputFocused = true;
            return;
        } else {
            this.inputFocused = false;
        }

        // 3. Random Button
        float rndX = inFieldX + inputW + gap;
        if (iIIiIIIiI_Class291.I_method_c3f86263(rndX, inBarY, rndBtnW, 22.0F, mouseX, mouseY)) {
            String name = generateRandomName();
            if (!ACCOUNTS.contains(name)) {
                ACCOUNTS.add(name);
                saveAlts();
            }
            selectAccount(ACCOUNTS.indexOf(name));
            return;
        }

        // 4. Delete Button
        float delX = rndX + rndBtnW + gap;
        if (iIIiIIIiI_Class291.I_method_c3f86263(delX, inBarY, delBtnW, 22.0F, mouseX, mouseY)) {
            if (!ACCOUNTS.isEmpty() && this.selectedIndex < ACCOUNTS.size()) {
                ACCOUNTS.remove(this.selectedIndex);
                if (ACCOUNTS.isEmpty()) {
                    ACCOUNTS.add("Steve");
                }
                saveAlts();
                selectAccount(MathHelper.clamp(this.selectedIndex, 0, ACCOUNTS.size() - 1));
            }
            return;
        }
    }

    @Override
    public void onMouseDragged(double mouseX, double mouseY, IiIII_Class9 button, double deltaX, double deltaY) {
        if (this.isDraggingModel) {
            float delta = (float)(mouseX - this.lastDragMouseX);
            this.modelRotationYaw += delta * 1.5F;
            this.modelRotationVel = delta * 0.35F;
            this.lastDragMouseX = mouseX;
        }
    }

    @Override
    public void onMouseReleased(double mouseX, double mouseY, IiIII_Class9 button) {
        this.isDraggingModel = false;
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        if (verticalAmount > 0) {
            if (this.selectedIndex > 0) {
                selectAccount(this.selectedIndex - 1);
            }
        } else if (verticalAmount < 0) {
            if (this.selectedIndex < ACCOUNTS.size() - 1) {
                selectAccount(this.selectedIndex + 1);
            }
        }
        return true;
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            closeScreen();
            return true;
        }

        if (this.inputFocused) {
            if (keyCode == GLFW.GLFW_KEY_BACKSPACE) {
                if (!this.inputText.isEmpty()) {
                    this.inputText = this.inputText.substring(0, this.inputText.length() - 1);
                }
                return true;
            }
            if (keyCode == GLFW.GLFW_KEY_ENTER || keyCode == GLFW.GLFW_KEY_KP_ENTER) {
                submitInput();
                return true;
            }
        } else {
            // Arrow navigation
            if (keyCode == GLFW.GLFW_KEY_LEFT) {
                if (this.selectedIndex > 0) {
                    selectAccount(this.selectedIndex - 1);
                }
                return true;
            }
            if (keyCode == GLFW.GLFW_KEY_RIGHT) {
                if (this.selectedIndex < ACCOUNTS.size() - 1) {
                    selectAccount(this.selectedIndex + 1);
                }
                return true;
            }
        }

        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean charTyped(char chr, int modifiers) {
        if (this.inputFocused) {
            if (Character.isLetterOrDigit(chr) || chr == '_') {
                if (this.inputText.length() < 16) {
                    this.inputText += chr;
                }
                return true;
            }
        }
        return super.charTyped(chr, modifiers);
    }

    private void submitInput() {
        if (this.inputText != null && !this.inputText.trim().isEmpty()) {
            String clean = this.inputText.trim();
            if (!ACCOUNTS.contains(clean)) {
                ACCOUNTS.add(clean);
                saveAlts();
            }
            selectAccount(ACCOUNTS.indexOf(clean));
            this.inputText = "";
            this.inputFocused = false;
        }
    }
}
