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
import net.minecraft.client.gui.PlayerSkinDrawer;
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
import pyrock.utility.render.ColorRGBA;

public class AltManagerScreen extends ii_Class4 {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final List<String> ACCOUNTS = new ArrayList<>();
    private static final Map<String, CompletableFuture<SkinTextures>> SKIN_CACHE = new ConcurrentHashMap<>();
    private static PlayerEntityModel PLAYER_MODEL;
    private static boolean loaded = false;

    private final Screen parent;
    private String inputText = "";
    private boolean inputFocused = false;
    private String statusMessage = "";
    private long statusTime = 0L;
    private float scrollOffset = 0.0F;
    private float targetScroll = 0.0F;
    private String selectedAccount = "";

    // 3D Model rotation & drag
    private float modelRotationYaw = 0.0F;
    private float modelRotationVel = 0.0F;
    private boolean isDraggingModel = false;
    private double lastDragMouseX = 0;

    // Hover animation states
    private float pasteHoverAnim = 0.0F;
    private float addHoverAnim = 0.0F;
    private float rndHoverAnim = 0.0F;
    private float selectBtnHoverAnim = 0.0F;
    private float closeHoverAnim = 0.0F;

    public AltManagerScreen(Screen parent) {
        this.parent = parent;
        loadAlts();
        String current = MinecraftClient.getInstance().getSession().getUsername();
        this.selectedAccount = (current != null && !current.isBlank()) ? current : (!ACCOUNTS.isEmpty() ? ACCOUNTS.get(0) : "OfflinePlayer");
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
                // 1. Official Mojang / Microsoft skin fetch via SkullBlockEntity
                try {
                    SkinTextures official = IiIIIIiIi_Class134.I_method_de1d7e2b(name).get(2, java.util.concurrent.TimeUnit.SECONDS);
                    if (official != null) return official;
                } catch (Throwable ignored) {}

                // 2. Direct Minotar Minecraft skin proxy (official Mojang skin CDN fallback)
                try {
                    Identifier skinId = IiIIIIiIi_Class134.i_method_2cd18e4b("https://minotar.net/skin/" + name).get(3, java.util.concurrent.TimeUnit.SECONDS);
                    if (skinId != null) {
                        return new SkinTextures(skinId, null, null, null, SkinTextures.Model.WIDE, true);
                    }
                } catch (Throwable ignored) {}

                // 3. Cravatar mirror
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

    @Override
    public void render(III var1) {
        int mx = var1.I_method_b1c3e152();
        int my = var1.i_method_b1d26d32();
        float delta = var1.I_method_b1c3e14f();

        ColorRGBA themeAccent = IiiiiIIIi_Class242.I_method_7df8e08e();
        IIiIIi_Class10 font = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F);
        IIiIIi_Class10 titleFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(11.0F);
        IIiIIi_Class10 smallFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F);
        float timeSec = (System.currentTimeMillis() % 100000L) * 0.001F;

        // Backdrop Dim
        var1.drawRect(0.0F, 0.0F, (float)this.width, (float)this.height, new ColorRGBA(0.0F, 0.0F, 0.0F, 195.0F));

        // Master Window Layout
        float cardW = Math.min(640.0F, this.width - 24.0F);
        float cardH = Math.min(380.0F, this.height - 24.0F);
        float cardX = this.width / 2.0F - cardW / 2.0F;
        float cardY = this.height / 2.0F - cardH / 2.0F;

        IIiii_Class8 rad14 = IIiii_Class8.I_method_893b2757(14.0F);
        IIiii_Class8 rad10 = IIiii_Class8.I_method_893b2757(10.0F);
        IIiii_Class8 rad6 = IIiii_Class8.I_method_893b2757(6.0F);
        IIiii_Class8 rad4 = IIiii_Class8.I_method_893b2757(4.0F);

        // Frosted Glass Window background
        var1.drawShadow(cardX, cardY, cardW, cardH, 24.0F, rad14, ColorRGBA.BLACK.withAlpha(180.0F));
        var1.drawBlurredRect(cardX, cardY, cardW, cardH, 25.0F, 5.0F, rad14, ColorRGBA.WHITE.withAlpha(240.0F));
        var1.drawRoundedRect(cardX, cardY, cardW, cardH, rad14, new ColorRGBA(12.0F, 14.0F, 20.0F, 205.0F));
        var1.drawRoundedBorder(cardX, cardY, cardW, cardH, 1.2F, rad14, new ColorRGBA(255.0F, 255.0F, 255.0F, 35.0F));

        // CLOSE BUTTON [X] - Guaranteed 100% visible vector cross
        float closeSize = 22.0F;
        float closeX = cardX + cardW - closeSize - 12.0F;
        float closeY = cardY + 12.0F;
        boolean closeHov = iIIiIIIiI_Class291.I_method_c3f86263(closeX, closeY, closeSize, closeSize, mx, my);
        this.closeHoverAnim += (closeHov ? 1.0F - this.closeHoverAnim : -this.closeHoverAnim) * 0.25F;

        ColorRGBA closeBg = closeHov ? new ColorRGBA(220.0F, 45.0F, 55.0F, 240.0F) : new ColorRGBA(36.0F, 40.0F, 52.0F, 200.0F);
        ColorRGBA closeBorder = closeHov ? new ColorRGBA(255.0F, 110.0F, 110.0F, 255.0F) : new ColorRGBA(65.0F, 72.0F, 92.0F, 150.0F);
        var1.drawRoundedRect(closeX, closeY, closeSize, closeSize, rad6, closeBg);
        var1.drawRoundedBorder(closeX, closeY, closeSize, closeSize, 1.0F, rad6, closeBorder);

        float pad = 6.0F;
        ColorRGBA crossCol = closeHov ? ColorRGBA.WHITE : new ColorRGBA(210.0F, 215.0F, 230.0F, 230.0F);
        var1.drawLine(new Vec2f(closeX + pad, closeY + pad), new Vec2f(closeX + closeSize - pad, closeY + closeSize - pad), crossCol);
        var1.drawLine(new Vec2f(closeX + closeSize - pad, closeY + pad), new Vec2f(closeX + pad, closeY + closeSize - pad), crossCol);

        // ==========================================
        // RIGHT SECTION: 3D PLAYER SHOWCASE STAGE
        // "игрока в право макимально, без лишних надписей, просто ник на голове"
        // ==========================================
        float showW = 215.0F;
        float showX = cardX + cardW - showW - 14.0F;
        float showY = cardY + 12.0F;
        float showH = cardH - 24.0F;
        float showCenterX = showX + showW / 2.0F;

        String currentSession = MinecraftClient.getInstance().getSession().getUsername();
        String selNick = (this.selectedAccount != null && !this.selectedAccount.isBlank()) ? this.selectedAccount : currentSession;
        boolean isCurrentActive = selNick.equalsIgnoreCase(currentSession);

        SkinTextures showcaseSkin = getSkinTextures(selNick);

        // Massive standing player model (~9x bigger, filling vertical space from head to feet)
        float modelScale = 105.0F;

        // Nickname directly above head - clean, no extra labels
        var1.drawCenteredText(titleFont, selNick, showCenterX, showY + 8.0F, ColorRGBA.WHITE);

        try {
            if (PLAYER_MODEL == null) {
                PLAYER_MODEL = new PlayerEntityModel(MinecraftClient.getInstance().getLoadedEntityModels().getModelPart(EntityModelLayers.PLAYER), false);
            }

            var1.draw(); // Flush 2D UI batch before 3D model render
            RenderSystem.enableDepthTest();
            RenderSystem.depthMask(true);
            RenderSystem.disableCull();

            MatrixStack matrices = var1.getMatrices();
            matrices.push();

            // Center vertically and render upright in GUI coordinates
            matrices.translate(showCenterX, showY + showH / 2.0F - 52.0F, 150.0F);
            matrices.scale(modelScale, modelScale, modelScale);

            if (!this.isDraggingModel) {
                this.modelRotationYaw += this.modelRotationVel;
                this.modelRotationVel *= 0.92F;
                if (Math.abs(this.modelRotationVel) < 0.05F) {
                    this.modelRotationYaw += 0.35F;
                }
            }
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(this.modelRotationYaw));

            PLAYER_MODEL.head.yaw = 0.0F;
            PLAYER_MODEL.head.pitch = 0.0F;
            PLAYER_MODEL.leftArm.pitch = (float) Math.sin(timeSec * 2.2F) * 0.05F;
            PLAYER_MODEL.rightArm.pitch = -(float) Math.sin(timeSec * 2.2F) * 0.05F;
            PLAYER_MODEL.leftArm.roll = 0.04F;
            PLAYER_MODEL.rightArm.roll = -0.04F;
            PLAYER_MODEL.leftLeg.pitch = 0.0F;
            PLAYER_MODEL.rightLeg.pitch = 0.0F;
            PLAYER_MODEL.body.yaw = 0.0F;

            VertexConsumerProvider.Immediate vertexConsumers = MinecraftClient.getInstance().getBufferBuilders().getEntityVertexConsumers();
            VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(showcaseSkin.texture()));
            PLAYER_MODEL.render(matrices, vertexConsumer, 15728880, OverlayTexture.DEFAULT_UV, -1);
            vertexConsumers.draw();
            matrices.pop();

            RenderSystem.enableCull();
            RenderSystem.disableDepthTest();
        } catch (Throwable t) {
            if (showcaseSkin != null) {
                // Large fallback avatar (160px)
                PlayerSkinDrawer.draw(var1, showcaseSkin, (int)(showCenterX - 80.0F), (int)(showY + showH / 2.0F - 80.0F), 160);
            }
        }

        // ==========================================
        // LEFT & CENTER: ACCOUNTS SELECTION AT TOP, BUTTONS AT BOTTOM
        // "кнопки перемести вниз а выбор вверх и выровни по центру"
        // ==========================================
        float leftX = cardX + 16.0F;
        float leftW = (showX - 14.0F) - leftX;

        // Top Header (centered)
        var1.drawCenteredText(titleFont, "Выбор аккаунта", leftX + leftW / 2.0F, cardY + 15.0F, ColorRGBA.WHITE);
        var1.drawText(smallFont, "Всего: " + ACCOUNTS.size(), leftX + 10.0F, cardY + 17.0F, ColorRGBA.WHITE.withAlpha(120.0F));

        // Accounts List (Selection at the top, centered)
        float listY = cardY + 36.0F;
        float listH = cardH - 96.0F;
        float itemH = 34.0F;
        float itemGap = 4.0F;

        var1.drawBlurredRect(leftX, listY, leftW, listH, 16.0F, 3.0F, rad10, ColorRGBA.WHITE.withAlpha(200.0F));
        var1.drawRoundedRect(leftX, listY, leftW, listH, rad10, new ColorRGBA(10.0F, 12.0F, 18.0F, 200.0F));
        var1.drawRoundedBorder(leftX, listY, leftW, listH, 1.0F, rad10, new ColorRGBA(38.0F, 44.0F, 60.0F, 150.0F));

        float contentH = ACCOUNTS.size() * (itemH + itemGap);
        float maxScroll = Math.max(0.0F, contentH - listH + 8.0F);

        this.scrollOffset += (this.targetScroll - this.scrollOffset) * 0.35F;
        if (Math.abs(this.targetScroll - this.scrollOffset) < 0.1F) {
            this.scrollOffset = this.targetScroll;
        }

        if (ACCOUNTS.isEmpty()) {
            var1.drawCenteredText(font, "Список пуст. Введите ник или нажмите «Рандом»!", leftX + leftW / 2.0F, listY + listH / 2.0F - 5.0F, ColorRGBA.WHITE.withAlpha(100.0F));
        } else {
            for (int i = 0; i < ACCOUNTS.size(); i++) {
                String acc = ACCOUNTS.get(i);
                float iy = listY + 5.0F + i * (itemH + itemGap) - this.scrollOffset;
                if (iy < listY || iy + itemH > listY + listH) continue;

                boolean active = acc.equalsIgnoreCase(currentSession);
                boolean selected = acc.equalsIgnoreCase(this.selectedAccount);
                boolean accHov = iIIiIIIiI_Class291.I_method_c3f86263(leftX + 5.0F, iy, leftW - 10.0F, itemH, mx, my)
                    && my >= listY && my <= listY + listH;

                float slideX = accHov ? 2.0F : 0.0F;
                ColorRGBA rowBg = selected
                    ? themeAccent.withAlpha(50.0F)
                    : (active ? new ColorRGBA(20.0F, 46.0F, 32.0F, 220.0F)
                        : (accHov ? new ColorRGBA(28.0F, 34.0F, 48.0F, 220.0F) : new ColorRGBA(15.0F, 17.0F, 24.0F, 180.0F)));

                var1.drawRoundedRect(leftX + 5.0F + slideX, iy, leftW - 10.0F - slideX, itemH, rad6, rowBg);

                if (selected) {
                    var1.drawRoundedBorder(leftX + 5.0F + slideX, iy, leftW - 10.0F - slideX, itemH, 1.2F, rad6, themeAccent);
                    var1.drawRect(leftX + 5.0F + slideX, iy + 5.0F, 2.5F, itemH - 10.0F, themeAccent);
                } else if (active) {
                    var1.drawRoundedBorder(leftX + 5.0F + slideX, iy, leftW - 10.0F - slideX, itemH, 1.0F, rad6, new ColorRGBA(80.0F, 255.0F, 140.0F, 170.0F));
                } else if (accHov) {
                    var1.drawRoundedBorder(leftX + 5.0F + slideX, iy, leftW - 10.0F - slideX, itemH, 0.8F, rad6, new ColorRGBA(255.0F, 255.0F, 255.0F, 50.0F));
                }

                // Avatar Icon
                SkinTextures skin = getSkinTextures(acc);
                float headBoxX = leftX + 10.0F + slideX;
                float headBoxY = iy + 5.0F;
                var1.drawRoundedRect(headBoxX, headBoxY, 24.0F, 24.0F, rad6, new ColorRGBA(18.0F, 22.0F, 32.0F, 240.0F));
                if (skin != null) {
                    PlayerSkinDrawer.draw(var1, skin, (int)(headBoxX + 2.0F), (int)(headBoxY + 2.0F), 20);
                }

                // Nickname & Status Text
                float textX = headBoxX + 30.0F;
                ColorRGBA nickCol = active ? new ColorRGBA(120.0F, 255.0F, 170.0F) : (selected ? ColorRGBA.WHITE : new ColorRGBA(220.0F, 225.0F, 235.0F));
                var1.drawText(font, acc, textX, iy + 7.0F, nickCol);
                String sub = active ? "Текущий аккаунт" : "Оффлайн профиль";
                ColorRGBA subCol = active ? new ColorRGBA(90.0F, 230.0F, 140.0F, 190.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 95.0F);
                var1.drawText(smallFont, sub, textX, iy + 19.0F, subCol);

                // Delete Button [X]
                float delX = leftX + leftW - 28.0F;
                float delY = iy + 8.0F;
                boolean delHov = iIIiIIIiI_Class291.I_method_c3f86263(delX, delY, 18.0F, 18.0F, mx, my);
                var1.drawRoundedRect(delX, delY, 18.0F, 18.0F, rad4, delHov ? new ColorRGBA(220.0F, 45.0F, 55.0F, 220.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 14.0F));
                float dPad = 5.0F;
                ColorRGBA dCol = delHov ? ColorRGBA.WHITE : new ColorRGBA(255.0F, 255.0F, 255.0F, 130.0F);
                var1.drawLine(new Vec2f(delX + dPad, delY + dPad), new Vec2f(delX + 18.0F - dPad, delY + 18.0F - dPad), dCol);
                var1.drawLine(new Vec2f(delX + 18.0F - dPad, delY + dPad), new Vec2f(delX + dPad, delY + 18.0F - dPad), dCol);
            }

            // Scrollbar
            if (maxScroll > 0.0F) {
                float sbW = 3.0F;
                float sbH = Math.max(16.0F, (listH / contentH) * listH);
                float sbX = leftX + leftW - sbW - 2.0F;
                float sbY = listY + (this.scrollOffset / maxScroll) * (listH - sbH);
                var1.drawRoundedRect(sbX, sbY, sbW, sbH, IIiii_Class8.I_method_893b2757(1.5F), themeAccent.withAlpha(170.0F));
            }
        }

        // ==========================================
        // ACTION CONTROLS AT BOTTOM (CENTERED)
        // ==========================================
        float inBarY = cardY + cardH - 46.0F;
        float playBtnW = 68.0F;
        float actionBtnW = 46.0F;
        float actionBtnGap = 5.0F;
        float inFieldW = leftW - (playBtnW + actionBtnW * 3.0F + actionBtnGap * 4.0F);

        ColorRGBA inBorder = this.inputFocused ? themeAccent : new ColorRGBA(45.0F, 52.0F, 68.0F, 170.0F);
        var1.drawRoundedRect(leftX, inBarY, inFieldW, 24.0F, rad6, new ColorRGBA(12.0F, 14.0F, 20.0F, 240.0F));
        var1.drawRoundedBorder(leftX, inBarY, inFieldW, 24.0F, 1.0F, rad6, inBorder);

        String displayInput = this.inputText.isEmpty() ? (this.inputFocused ? "" : "Введите ник...") : this.inputText;
        ColorRGBA inTextCol = this.inputText.isEmpty() ? ColorRGBA.WHITE.withAlpha(95.0F) : ColorRGBA.WHITE;
        var1.drawText(font, displayInput, leftX + 7.0F, inBarY + 7.0F, inTextCol);

        if (this.inputFocused && (System.currentTimeMillis() % 1000L) < 500L) {
            float curX = leftX + 7.0F + font.I_method_2c375926(this.inputText);
            var1.drawRoundedRect(curX, inBarY + 5.0F, 1.5F, 13.0F, IIiii_Class8.I_method_893b2757(0.5F), themeAccent);
        }

        // 1. Play / Select Button
        float playX = leftX + inFieldW + actionBtnGap;
        boolean playHov = iIIiIIIiI_Class291.I_method_c3f86263(playX, inBarY, playBtnW, 24.0F, mx, my);
        this.selectBtnHoverAnim += (playHov ? 1.0F - this.selectBtnHoverAnim : -this.selectBtnHoverAnim) * 0.25F;
        String playText = isCurrentActive ? "Активен" : "Войти";
        ColorRGBA playBase = isCurrentActive ? new ColorRGBA(22.0F, 50.0F, 34.0F, 220.0F) : new ColorRGBA(35.0F, 90.0F, 210.0F, 230.0F);
        ColorRGBA playTextCol = isCurrentActive ? new ColorRGBA(140.0F, 255.0F, 180.0F) : ColorRGBA.WHITE;
        render3DButton(var1, playX, inBarY, playBtnW, 24.0F, playText, smallFont, playHov, this.selectBtnHoverAnim, playBase, themeAccent, playTextCol);

        // 2. Paste Button
        float pasteX = playX + playBtnW + actionBtnGap;
        boolean pasteHov = iIIiIIIiI_Class291.I_method_c3f86263(pasteX, inBarY, actionBtnW, 24.0F, mx, my);
        this.pasteHoverAnim += (pasteHov ? 1.0F - this.pasteHoverAnim : -this.pasteHoverAnim) * 0.25F;
        render3DButton(var1, pasteX, inBarY, actionBtnW, 24.0F, "Буфер", smallFont, pasteHov, this.pasteHoverAnim, new ColorRGBA(28.0F, 32.0F, 44.0F, 220.0F), new ColorRGBA(55.0F, 65.0F, 90.0F, 240.0F), ColorRGBA.WHITE);

        // 3. Add Button
        float addX = pasteX + actionBtnW + actionBtnGap;
        boolean addHov = iIIiIIIiI_Class291.I_method_c3f86263(addX, inBarY, actionBtnW, 24.0F, mx, my);
        this.addHoverAnim += (addHov ? 1.0F - this.addHoverAnim : -this.addHoverAnim) * 0.25F;
        render3DButton(var1, addX, inBarY, actionBtnW, 24.0F, "+ Ник", smallFont, addHov, this.addHoverAnim, new ColorRGBA(35.0F, 90.0F, 200.0F, 220.0F), themeAccent, ColorRGBA.WHITE);

        // 4. Random Button
        float rndX = addX + actionBtnW + actionBtnGap;
        boolean rndHov = iIIiIIIiI_Class291.I_method_c3f86263(rndX, inBarY, actionBtnW, 24.0F, mx, my);
        this.rndHoverAnim += (rndHov ? 1.0F - this.rndHoverAnim : -this.rndHoverAnim) * 0.25F;
        render3DButton(var1, rndX, inBarY, actionBtnW, 24.0F, "Рандом", smallFont, rndHov, this.rndHoverAnim, new ColorRGBA(28.0F, 32.0F, 44.0F, 220.0F), new ColorRGBA(55.0F, 65.0F, 90.0F, 240.0F), ColorRGBA.WHITE);
    }

    private void render3DButton(III var1, float x, float y, float w, float h, String text, IIiIIi_Class10 font, boolean hov, float hovAnim, ColorRGBA baseCol, ColorRGBA accentCol, ColorRGBA textCol) {
        float lift = -1.5F * hovAnim;
        ColorRGBA bg = baseCol.mix(accentCol, 0.35F * hovAnim);
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(5.0F);

        if (hovAnim > 0.05F) {
            var1.drawShadow(x, y + lift, w, h, 8.0F * hovAnim, rad, accentCol.withAlpha(45.0F * hovAnim));
        }
        var1.drawRoundedRect(x, y + lift, w, h, rad, bg);
        var1.drawRoundedBorder(x, y + lift, w, h, 1.0F, rad, hov ? accentCol : new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));
        var1.drawCenteredText(font, text, x + w / 2.0F, y + lift + (h - 7.0F) / 2.0F, textCol);
    }

    @Override
    public void onMouseClicked(double mouseX, double mouseY, IiIII_Class9 button) {
        if (button != IiIII_Class9.I_field_2f4c8d6c) return;

        float cardW = Math.min(640.0F, this.width - 24.0F);
        float cardH = Math.min(380.0F, this.height - 24.0F);
        float cardX = this.width / 2.0F - cardW / 2.0F;
        float cardY = this.height / 2.0F - cardH / 2.0F;

        // Close Button [X] in top-right corner
        float closeSize = 22.0F;
        float closeX = cardX + cardW - closeSize - 12.0F;
        float closeY = cardY + 12.0F;
        if (iIIiIIIiI_Class291.I_method_c3f86263(closeX, closeY, closeSize, closeSize, mouseX, mouseY)) {
            MinecraftClient.getInstance().setScreen(this.parent);
            return;
        }

        // Right Section: 3D Player showcase drag
        float showW = 215.0F;
        float showX = cardX + cardW - showW - 14.0F;
        float showY = cardY + 12.0F;
        float showH = cardH - 24.0F;

        if (iIIiIIIiI_Class291.I_method_c3f86263(showX, showY, showW, showH, mouseX, mouseY)) {
            this.isDraggingModel = true;
            this.lastDragMouseX = mouseX;
            return;
        }

        // Left Section: Accounts List & Controls
        float leftX = cardX + 16.0F;
        float leftW = (showX - 14.0F) - leftX;
        float listY = cardY + 36.0F;
        float listH = cardH - 96.0F;
        float itemH = 34.0F;
        float itemGap = 4.0F;

        // Accounts list clicks
        if (mouseX >= leftX && mouseX <= leftX + leftW && mouseY >= listY && mouseY <= listY + listH) {
            for (int i = 0; i < ACCOUNTS.size(); i++) {
                String acc = ACCOUNTS.get(i);
                float iy = listY + 5.0F + i * (itemH + itemGap) - this.scrollOffset;
                if (iy < listY || iy + itemH > listY + listH) continue;

                // Delete button
                float delX = leftX + leftW - 28.0F;
                float delY = iy + 8.0F;
                if (iIIiIIIiI_Class291.I_method_c3f86263(delX, delY, 18.0F, 18.0F, mouseX, mouseY)) {
                    ACCOUNTS.remove(i);
                    saveAlts();
                    if (this.selectedAccount.equalsIgnoreCase(acc)) {
                        this.selectedAccount = !ACCOUNTS.isEmpty() ? ACCOUNTS.get(0) : "";
                    }
                    return;
                }

                // Select account
                if (iIIiIIIiI_Class291.I_method_c3f86263(leftX + 5.0F, iy, leftW - 10.0F, itemH, mouseX, mouseY)) {
                    this.selectedAccount = acc;
                    return;
                }
            }
        }

        // Bottom Controls
        float inBarY = cardY + cardH - 46.0F;
        float playBtnW = 68.0F;
        float actionBtnW = 46.0F;
        float actionBtnGap = 5.0F;
        float inFieldW = leftW - (playBtnW + actionBtnW * 3.0F + actionBtnGap * 4.0F);

        // Input field click
        if (iIIiIIIiI_Class291.I_method_c3f86263(leftX, inBarY, inFieldW, 24.0F, mouseX, mouseY)) {
            this.inputFocused = true;
            return;
        } else {
            this.inputFocused = false;
        }

        // 1. Play / Select Button
        float playX = leftX + inFieldW + actionBtnGap;
        if (iIIiIIIiI_Class291.I_method_c3f86263(playX, inBarY, playBtnW, 24.0F, mouseX, mouseY)) {
            if (this.selectedAccount != null && !this.selectedAccount.isBlank()) {
                login(this.selectedAccount);
                this.statusMessage = "Активен: " + this.selectedAccount;
                this.statusTime = System.currentTimeMillis();
                return;
            }
        }

        // 2. Paste Button
        float pasteX = playX + playBtnW + actionBtnGap;
        if (iIIiIIIiI_Class291.I_method_c3f86263(pasteX, inBarY, actionBtnW, 24.0F, mouseX, mouseY)) {
            try {
                String clip = MinecraftClient.getInstance().keyboard.getClipboard();
                if (clip != null && !clip.trim().isEmpty()) {
                    this.inputText = clip.trim().replaceAll("[^a-zA-Z0-9_]", "");
                    this.inputFocused = true;
                }
            } catch (Throwable ignored) {}
            return;
        }

        // 3. Add Button
        float addX = pasteX + actionBtnW + actionBtnGap;
        if (iIIiIIIiI_Class291.I_method_c3f86263(addX, inBarY, actionBtnW, 24.0F, mouseX, mouseY)) {
            submitInput();
            return;
        }

        // 4. Random Button
        float rndX = addX + actionBtnW + actionBtnGap;
        if (iIIiIIIiI_Class291.I_method_c3f86263(rndX, inBarY, actionBtnW, 24.0F, mouseX, mouseY)) {
            String name = generateRandomName();
            if (!ACCOUNTS.contains(name)) {
                ACCOUNTS.add(name);
                saveAlts();
            }
            this.selectedAccount = name;
            login(name);
            this.statusMessage = "Активен: " + name;
            this.statusTime = System.currentTimeMillis();
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
        float cardH = Math.min(380.0F, this.height - 24.0F);
        float listH = cardH - 96.0F;
        float itemH = 34.0F;
        float itemGap = 4.0F;
        float contentH = ACCOUNTS.size() * (itemH + itemGap);
        float maxScroll = Math.max(0.0F, contentH - listH + 8.0F);

        this.targetScroll = MathHelper.clamp(this.targetScroll - (float) verticalAmount * 24.0F, 0.0F, maxScroll);
        return true;
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 256) { // ESC
            MinecraftClient.getInstance().setScreen(this.parent);
            return true;
        }

        if (this.inputFocused) {
            if (keyCode == 259) { // Backspace
                if (!this.inputText.isEmpty()) {
                    this.inputText = this.inputText.substring(0, this.inputText.length() - 1);
                }
                return true;
            }
            if (keyCode == 257 || keyCode == 335) { // Enter
                submitInput();
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
            this.selectedAccount = clean;
            login(clean);
            this.statusMessage = "Активен: " + clean;
            this.statusTime = System.currentTimeMillis();
            this.inputText = "";
            this.inputFocused = false;
        }
    }
}
