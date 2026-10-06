package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import pyrock.events.game.AfterAttackEvent;
import pyrock.events.game.AttackEvent;
import pyrock.events.game.PostAttackEvent;
import pyrock.events.game.WorldChangeEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;

@ModuleInfo(
    name = "Hit Bubble",
    category = ModuleCategory.VISUALS,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.hit_bubble"
)
public class HitBubbleModule extends Module {
    static class Bubble {
        final Vec3d pos;
        final ColorRGBA col;
        final long startTime;
        final float seed;
        final float yaw;
        final float pitch;

        Bubble(Vec3d pos, ColorRGBA col, long startTime, float yaw, float pitch) {
            this.pos = pos;
            this.col = col;
            this.startTime = startTime;
            this.seed = (float)Math.random() * 100.0F;
            this.yaw = yaw;
            this.pitch = pitch;
        }
    }

    private final List<Bubble> bubbles = new CopyOnWriteArrayList<>();
    static final Random RANDOM = new Random();
    private long lastHitTime = 0L;

    private ModeSetting styleSetting;
    private ModeSetting.Nested1_42765c60 styleRings;
    private ModeSetting.Nested1_42765c60 styleHexShield;
    private ModeSetting.Nested1_42765c60 styleSonicWave;
    private ModeSetting.Nested1_42765c60 styleCardExplosion;
    private ModeSetting.Nested1_42765c60 styleAceBurst;
    private ModeSetting.Nested1_42765c60 styleCardVortex;
    private ModeSetting.Nested1_42765c60 styleVoidPulse;
    private ModeSetting.Nested1_42765c60 styleGlitchOrb;
    private ModeSetting.Nested1_42765c60 styleHolyAura;
    // NEW 10 styles
    private ModeSetting.Nested1_42765c60 styleCrossSlash;
    private ModeSetting.Nested1_42765c60 styleShatterGlass;
    private ModeSetting.Nested1_42765c60 stylePixelBurst;
    private ModeSetting.Nested1_42765c60 styleSpiralPulse;
    private ModeSetting.Nested1_42765c60 styleStarImpact;
    private ModeSetting.Nested1_42765c60 styleDiamondCrack;
    private ModeSetting.Nested1_42765c60 styleNeonFlash;
    private ModeSetting.Nested1_42765c60 styleVoidTear;
    private ModeSetting.Nested1_42765c60 stylePrismBurst;
    private ModeSetting.Nested1_42765c60 styleArcaneCircle;

    private SliderSetting maxSize;
    private SliderSetting duration;

    // Card Customization Settings
    private SliderSetting cardScale;
    private SliderSetting cardCount;
    private SliderSetting cardSpin;
    private BooleanSetting cardFoil;

    private ModeSetting cardDeckSetting;
    private ModeSetting.Nested1_42765c60 deckUnoCards;
    private ModeSetting.Nested1_42765c60 deckClassicPoker;
    private ModeSetting.Nested1_42765c60 deckRoyalFlush;
    private ModeSetting.Nested1_42765c60 deckAcesOnly;
    private ModeSetting.Nested1_42765c60 deckCourtCards;
    private ModeSetting.Nested1_42765c60 deckJokersWild;

    private ModeSetting cardBackSetting;
    private ModeSetting.Nested1_42765c60 backMeshRed;
    private ModeSetting.Nested1_42765c60 backMeshBlue;
    private ModeSetting.Nested1_42765c60 backUno;
    private ModeSetting.Nested1_42765c60 backBicycle;
    private ModeSetting.Nested1_42765c60 backRoyalGold;
    private ModeSetting.Nested1_42765c60 backCyberNeon;
    private ModeSetting.Nested1_42765c60 backDarkArcane;

    private BooleanSetting syncTheme;
    private BooleanSetting glowSetting;
    private ColorSetting colorSetting;

    private boolean isCardMode() {
        return (this.styleCardExplosion != null && this.styleCardExplosion.isSelected())
            || (this.styleAceBurst != null && this.styleAceBurst.isSelected())
            || (this.styleCardVortex != null && this.styleCardVortex.isSelected());
    }

    private Identifier[] getActiveDeck() {
        if (this.cardDeckSetting != null) {
            if (this.cardDeckSetting.isSelected("Uno Cards")) return CardRenderHelper.UNO_CARDS;
            if (this.cardDeckSetting.isSelected("Royal Flush")) return CardRenderHelper.ROYAL_FLUSH_CARDS;
            if (this.cardDeckSetting.isSelected("Aces Only")) return CardRenderHelper.ACES;
            if (this.cardDeckSetting.isSelected("Court Cards")) return CardRenderHelper.COURT_CARDS;
            if (this.cardDeckSetting.isSelected("Jokers Wild")) return CardRenderHelper.JOKERS;
            if (this.cardDeckSetting.isSelected("Classic Poker")) return CardRenderHelper.ALL_CARDS;
            if (this.cardDeckSetting.i_method_f85f3850() != null) {
                return CardRenderHelper.getDeckCards(this.cardDeckSetting.i_method_f85f3850().getName());
            }
        }
        return CardRenderHelper.ALL_CARDS;
    }

    private Identifier getActiveBack() {
        if (this.cardBackSetting != null) {
            if (this.cardBackSetting.isSelected("Uno Classic")) return CardRenderHelper.CARD_BACK_UNO;
            if (this.cardBackSetting.isSelected("Classic Mesh (Blue)")) return CardRenderHelper.CARD_BACK_MESH_BLUE;
            if (this.cardBackSetting.isSelected("Classic Mesh (Red)")) return CardRenderHelper.CARD_BACK_MESH;
            if (this.cardBackSetting.isSelected("Bicycle Classic")) return CardRenderHelper.CARD_BACK_BICYCLE;
            if (this.cardBackSetting.isSelected("Royal Gold")) return CardRenderHelper.CARD_BACK_ROYAL;
            if (this.cardBackSetting.isSelected("Cyber Neon")) return CardRenderHelper.CARD_BACK_CYBER;
            if (this.cardBackSetting.isSelected("Dark Arcane")) return CardRenderHelper.CARD_BACK_ARCANE;
            if (this.cardBackSetting.i_method_f85f3850() != null) {
                return CardRenderHelper.getDeckBack(this.cardBackSetting.i_method_f85f3850().getName());
            }
        }
        return CardRenderHelper.CARD_BACK_MESH;
    }

    private void onHitEntity(Entity entity) {
        if (entity instanceof LivingEntity living) {
            MinecraftClient mc = MinecraftClient.getInstance();
            if (mc.player != null && living == mc.player) return;
            long now = System.currentTimeMillis();
            if (now - this.lastHitTime < 40L) return;
            this.lastHitTime = now;

            float yaw = mc.player != null ? mc.player.getYaw() : 0.0F;
            float pitch = mc.player != null ? mc.player.getPitch() : 0.0F;

            Vec3d hitPos = new Vec3d(living.getX(), living.getY() + living.getHeight() * 0.5, living.getZ());
            ColorRGBA col = this.syncTheme.i_method_9b12da03() ? IiiiiIIIi_Class242.I_method_7df8e08e() : this.colorSetting.I_method_bde5f08e();
            this.bubbles.add(new Bubble(hitPos, col, now, yaw, pitch));
        }
    }

    private final IiIIIiII_Class69<AfterAttackEvent> afterAttackListener = var1 -> {
        this.onHitEntity(var1.getEntity());
    };

    private final IiIIIiII_Class69<PostAttackEvent> postAttackListener = var1 -> {
        this.onHitEntity(var1.getEntity());
    };

    private final IiIIIiII_Class69<AttackEvent> attackListener = var1 -> {
        this.onHitEntity(var1.getEntity());
    };

    private final IiIIIiII_Class69<Render3DEvent> renderListener = this::onRender3D;

    private final IiIIIiII_Class69<WorldChangeEvent> worldChangeListener = var1 -> {
        this.bubbles.clear();
    };

    public HitBubbleModule() {
        this.initSettings();
    }

    private void initSettings() {
        this.styleSetting = new ModeSetting(this, "Style");
        this.styleRings = new ModeSetting.Nested1_42765c60(this.styleSetting, "Rings").select();
        this.styleHexShield = new ModeSetting.Nested1_42765c60(this.styleSetting, "HexShield");
        this.styleSonicWave = new ModeSetting.Nested1_42765c60(this.styleSetting, "SonicWave");
        this.styleCardExplosion = new ModeSetting.Nested1_42765c60(this.styleSetting, "Card Explosion");
        this.styleAceBurst = new ModeSetting.Nested1_42765c60(this.styleSetting, "Ace Burst");
        this.styleCardVortex = new ModeSetting.Nested1_42765c60(this.styleSetting, "Card Vortex");
        this.styleVoidPulse = new ModeSetting.Nested1_42765c60(this.styleSetting, "VoidPulse");
        this.styleGlitchOrb = new ModeSetting.Nested1_42765c60(this.styleSetting, "GlitchOrb");
        this.styleHolyAura = new ModeSetting.Nested1_42765c60(this.styleSetting, "HolyAura");
        this.styleCrossSlash = new ModeSetting.Nested1_42765c60(this.styleSetting, "CrossSlash");
        this.styleShatterGlass = new ModeSetting.Nested1_42765c60(this.styleSetting, "ShatterGlass");
        this.stylePixelBurst = new ModeSetting.Nested1_42765c60(this.styleSetting, "PixelBurst");
        this.styleSpiralPulse = new ModeSetting.Nested1_42765c60(this.styleSetting, "SpiralPulse");
        this.styleStarImpact = new ModeSetting.Nested1_42765c60(this.styleSetting, "StarImpact");
        this.styleDiamondCrack = new ModeSetting.Nested1_42765c60(this.styleSetting, "DiamondCrack");
        this.styleNeonFlash = new ModeSetting.Nested1_42765c60(this.styleSetting, "NeonFlash");
        this.styleVoidTear = new ModeSetting.Nested1_42765c60(this.styleSetting, "VoidTear");
        this.stylePrismBurst = new ModeSetting.Nested1_42765c60(this.styleSetting, "PrismBurst");
        this.styleArcaneCircle = new ModeSetting.Nested1_42765c60(this.styleSetting, "ArcaneCircle");

        this.maxSize = new SliderSetting(this, "Size")
            .I_method_c8c9a7d7(0.5F)
            .i_method_65e2aff7(3.5F)
            .II_method_b0f56334(0.1F)
            .Ii_method_4e0e6b54(1.8F);

        this.duration = new SliderSetting(this, "Duration (ms)")
            .I_method_c8c9a7d7(200.0F)
            .i_method_65e2aff7(1500.0F)
            .II_method_b0f56334(50.0F)
            .Ii_method_4e0e6b54(650.0F);

        this.cardScale = new SliderSetting(this, "Card Scale", () -> !this.isCardMode())
            .I_method_c8c9a7d7(0.4F)
            .i_method_65e2aff7(2.5F)
            .II_method_b0f56334(0.1F)
            .Ii_method_4e0e6b54(1.0F);

        this.cardCount = new SliderSetting(this, "Card Count", () -> !this.isCardMode())
            .I_method_c8c9a7d7(3.0F)
            .i_method_65e2aff7(16.0F)
            .II_method_b0f56334(1.0F)
            .Ii_method_4e0e6b54(8.0F);

        this.cardSpin = new SliderSetting(this, "Card Spin", () -> !this.isCardMode())
            .I_method_c8c9a7d7(0.2F)
            .i_method_65e2aff7(4.0F)
            .II_method_b0f56334(0.1F)
            .Ii_method_4e0e6b54(1.0F);

        this.cardFoil = new BooleanSetting(this, "Card Foil Glow", () -> !this.isCardMode()).I_method_decd82b5();

        this.cardDeckSetting = new ModeSetting(this, "Card Deck", () -> !this.isCardMode());
        this.deckUnoCards = new ModeSetting.Nested1_42765c60(this.cardDeckSetting, "Uno Cards");
        this.deckClassicPoker = new ModeSetting.Nested1_42765c60(this.cardDeckSetting, "Classic Poker").select();
        this.deckRoyalFlush = new ModeSetting.Nested1_42765c60(this.cardDeckSetting, "Royal Flush");
        this.deckAcesOnly = new ModeSetting.Nested1_42765c60(this.cardDeckSetting, "Aces Only");
        this.deckCourtCards = new ModeSetting.Nested1_42765c60(this.cardDeckSetting, "Court Cards");
        this.deckJokersWild = new ModeSetting.Nested1_42765c60(this.cardDeckSetting, "Jokers Wild");

        this.cardBackSetting = new ModeSetting(this, "Card Back", () -> !this.isCardMode());
        this.backMeshRed = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Classic Mesh (Red)").select();
        this.backMeshBlue = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Classic Mesh (Blue)");
        this.backUno = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Uno Classic");
        this.backBicycle = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Bicycle Classic");
        this.backRoyalGold = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Royal Gold");
        this.backCyberNeon = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Cyber Neon");
        this.backDarkArcane = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Dark Arcane");

        this.glowSetting = new BooleanSetting(this, "Glow");
        this.syncTheme = new BooleanSetting(this, "Sync Theme").I_method_decd82b5();
        this.colorSetting = new ColorSetting(this, "Color").I_method_a62f5dd6(new ColorRGBA(120.0F, 220.0F, 255.0F, 240.0F));
    }

    @Override
    public String i_method_bf522194() {
        return "3D impact waves at hit angle (16 styles + glow).";
    }

    private void onRender3D(Render3DEvent event) {
        if (this.bubbles.isEmpty()) return;
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.world == null) return;

        long now = System.currentTimeMillis();
        float dur = this.duration.Ii_method_a20abcd2();
        float targetSize = this.maxSize.Ii_method_a20abcd2();
        Vec3d cam = mc.gameRenderer.getCamera().getPos();

        RenderSystem.enableBlend();
        if (this.glowSetting.i_method_9b12da03()) {
            RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE);
        } else {
            RenderSystem.blendFuncSeparate(SrcFactor.SRC_ALPHA, DstFactor.ONE_MINUS_SRC_ALPHA, SrcFactor.ONE, DstFactor.ONE_MINUS_SRC_ALPHA);
        }
        RenderSystem.disableCull();
        RenderSystem.depthMask(false);
        RenderSystem.enableDepthTest();
        RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);

        MatrixStack matrices = event.getMatrices();

        this.bubbles.removeIf(b -> (float)(now - b.startTime) / dur >= 1.0F);
        for (Bubble b : this.bubbles) {
            float prog = (float)(now - b.startTime) / dur;
            float ease = 1.0F - (float)Math.pow(1.0F - prog, 3);
            float r = targetSize * ease;
            float alpha = (1.0F - prog);
            ColorRGBA col = b.col.withAlpha(b.col.getAlpha() * alpha);

            matrices.push();
            matrices.translate(b.pos.x - cam.x, b.pos.y - cam.y, b.pos.z - cam.z);
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-b.yaw));
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(b.pitch));

            if (this.styleHexShield.isSelected()) {
                renderHexShield(matrices, r, col, prog);
            } else if (this.styleSonicWave.isSelected()) {
                renderSonicWave(matrices, r, col, prog);
            } else if (this.styleCardExplosion != null && this.styleCardExplosion.isSelected()) {
                renderCardExplosion(matrices, r, col, prog, b.seed);
            } else if (this.styleAceBurst != null && this.styleAceBurst.isSelected()) {
                renderAceBurst(matrices, r, col, prog, b.seed);
            } else if (this.styleCardVortex != null && this.styleCardVortex.isSelected()) {
                renderCardVortex(matrices, r, col, prog, b.seed);
            } else if (this.styleVoidPulse.isSelected()) {
                renderVoidPulse(matrices, r, col, prog);
            } else if (this.styleGlitchOrb.isSelected()) {
                renderGlitchOrb(matrices, r, col, prog, b.seed);
            } else if (this.styleHolyAura.isSelected()) {
                renderHolyAura(matrices, r, col, prog);
            } else if (this.styleCrossSlash.isSelected()) {
                renderCrossSlash(matrices, r, col, prog);
            } else if (this.styleShatterGlass.isSelected()) {
                renderShatterGlass(matrices, r, col, prog, b.seed);
            } else if (this.stylePixelBurst.isSelected()) {
                renderPixelBurst(matrices, r, col, prog, b.seed);
            } else if (this.styleSpiralPulse.isSelected()) {
                renderSpiralPulse(matrices, r, col, prog);
            } else if (this.styleStarImpact.isSelected()) {
                renderStarImpact(matrices, r, col, prog);
            } else if (this.styleDiamondCrack.isSelected()) {
                renderDiamondCrack(matrices, r, col, prog, b.seed);
            } else if (this.styleNeonFlash.isSelected()) {
                renderNeonFlash(matrices, r, col, prog);
            } else if (this.styleVoidTear.isSelected()) {
                renderVoidTear(matrices, r, col, prog);
            } else if (this.stylePrismBurst.isSelected()) {
                renderPrismBurst(matrices, r, col, prog);
            } else if (this.styleArcaneCircle.isSelected()) {
                renderArcaneCircle(matrices, r, col, prog);
            } else {
                renderRings(matrices, r, col, prog);
            }

            matrices.pop();
        }

        RenderSystem.depthMask(true);
        RenderSystem.enableCull();
        RenderSystem.disableBlend();
    }

    // ============ ORIGINAL 6 STYLES ============

    private static void safeDraw(BufferBuilder bb) {
        BuiltBuffer built = bb.endNullable();
        if (built != null) {
            BufferRenderer.drawWithGlobalProgram(built);
        }
    }

    private void renderHexShield(MatrixStack m, float r, ColorRGBA col, float prog) {
        Matrix4f mat = m.peek().getPositionMatrix();
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_FAN, VertexFormats.POSITION_COLOR);
        int centerC = col.mulAlpha(0.25F * (1.0F - prog)).getRGB();
        int edgeC = col.mulAlpha(0.9F * (1.0F - prog)).getRGB();
        bb.vertex(mat, 0.0F, 0.0F, 0.0F).color(centerC);
        for (int i = 0; i <= 6; i++) {
            double ang = (Math.PI / 3.0) * i;
            bb.vertex(mat, (float)Math.cos(ang) * (r * 0.72F), (float)Math.sin(ang) * (r * 0.72F), 0.0F).color(edgeC);
        }
        safeDraw(bb);
        float t = Math.max(0.015F, r * 0.035F);
        draw3DRing(mat, r, t, col, 0.0F, 0.0F, 0.0F);
        draw3DRing(mat, r * 0.44F, t * 0.7F, col.mulAlpha(0.7F), 0.0F, 0.0F, 0.0F);
    }

    private void renderRings(MatrixStack m, float r, ColorRGBA col, float prog) {
        Matrix4f mat = m.peek().getPositionMatrix();
        float t1 = Math.max(0.015F, r * 0.035F);
        draw3DRing(mat, r, t1, col, 0.0F, 0.0F, 0.0F);
        float gap1 = Math.max(0.06F, r * 0.22F);
        float r2 = (r - t1) - gap1 - t1 * 0.8F;
        if (r2 > 0.06F) {
            draw3DRing(mat, r2, t1 * 0.8F, col.mulAlpha(0.8F), 0.0F, 0.0F, 0.0F);
            float gap2 = Math.max(0.05F, r2 * 0.22F);
            float r3 = (r2 - t1 * 0.8F) - gap2 - t1 * 0.6F;
            if (r3 > 0.05F) {
                draw3DRing(mat, r3, t1 * 0.6F, col.mulAlpha(0.6F), 0.0F, 0.0F, 0.0F);
                float gap3 = Math.max(0.04F, r3 * 0.22F);
                float r4 = (r3 - t1 * 0.6F) - gap3 - t1 * 0.4F;
                if (r4 > 0.04F) {
                    draw3DRing(mat, r4, t1 * 0.4F, col.mulAlpha(0.4F), 0.0F, 0.0F, 0.0F);
                }
            }
        }
    }

    private void renderSonicWave(MatrixStack m, float r, ColorRGBA col, float prog) {
        Matrix4f mat = m.peek().getPositionMatrix();
        for (int i = 0; i < 4; i++) {
            float p = (prog + i * 0.25F) % 1.0F;
            float ringR = Math.max(0.05F, r * (0.2F + p * 0.8F));
            float zOffset = (1.0F - p) * 0.6F;
            draw3DRing(mat, ringR, Math.max(0.012F, ringR * 0.03F), col.mulAlpha(1.0F - p), 0.0F, 0.0F, zOffset);
        }
    }

    private void renderVoidPulse(MatrixStack m, float r, ColorRGBA col, float prog) {
        Matrix4f mat = m.peek().getPositionMatrix();
        ColorRGBA voidCol = new ColorRGBA(180, 50, 255, col.getAlpha());
        float t = Math.max(0.015F, r * 0.035F);
        draw3DRing(mat, r, t, voidCol, 0.0F, 0.0F, 0.0F);
        float gap = Math.max(0.08F, r * 0.25F);
        float rInner = (r - t) - gap;
        if (rInner > 0.08F) {
            m.push();
            m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(prog * 180.0F));
            draw3DRing(m.peek().getPositionMatrix(), rInner, t * 0.7F, col.mulAlpha(0.85F), 0.0F, 0.0F, 0.0F);
            m.pop();
        }
    }

    private void renderGlitchOrb(MatrixStack m, float r, ColorRGBA col, float prog, float seed) {
        Matrix4f mat = m.peek().getPositionMatrix();
        draw3DRing(mat, r, 0.04F, col, 0.0F, 0.0F, 0.0F);
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.LINES, VertexFormats.POSITION_COLOR);
        int c = col.getRGB();
        int spikes = 12;
        for (int i = 0; i < spikes; i++) {
            double ang = (Math.PI * 2.0 * i) / spikes + seed;
            float jitter = ((float)Math.sin(seed + i * 1.5F + prog * 10.0F)) * 0.2F * r;
            float x1 = (float)Math.cos(ang) * (r * 0.6F);
            float y1 = (float)Math.sin(ang) * (r * 0.6F);
            float x2 = (float)Math.cos(ang) * (r + jitter);
            float y2 = (float)Math.sin(ang) * (r + jitter);
            bb.vertex(mat, x1, y1, 0.0F).color(c);
            bb.vertex(mat, x2, y2, 0.0F).color(c);
        }
        BufferRenderer.drawWithGlobalProgram(bb.end());
    }

    private void renderHolyAura(MatrixStack m, float r, ColorRGBA col, float prog) {
        Matrix4f mat = m.peek().getPositionMatrix();
        ColorRGBA gold = new ColorRGBA(255, 230, 100, col.getAlpha());
        draw3DRing(mat, r, 0.05F, gold, 0.0F, 0.0F, 0.0F);
        draw3DRing(mat, r * 0.6F, 0.03F, col, 0.0F, 0.0F, 0.0F);
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
        int c = gold.mulAlpha(0.8F).getRGB();
        int rays = 8;
        for (int i = 0; i < rays; i++) {
            double ang = (Math.PI * 2.0 * i) / rays + (prog * Math.PI * 0.5);
            float cos = (float)Math.cos(ang);
            float sin = (float)Math.sin(ang);
            float tipR = r * 1.35F;
            float baseR = r * 0.9F;
            float halfW = 0.08F * r;
            bb.vertex(mat, cos * tipR, sin * tipR, 0.0F).color(c);
            bb.vertex(mat, cos * baseR - sin * halfW, sin * baseR + cos * halfW, 0.0F).color(c);
            bb.vertex(mat, cos * baseR + sin * halfW, sin * baseR - cos * halfW, 0.0F).color(c);
        }
        BufferRenderer.drawWithGlobalProgram(bb.end());
    }

    // ============ 10 NEW STYLES ============

    // 7. CrossSlash: Two crossing diagonal slashes like an X
    private void renderCrossSlash(MatrixStack m, float r, ColorRGBA col, float prog) {
        Matrix4f mat = m.peek().getPositionMatrix();
        float len = r * 1.2F;
        float thick = 0.06F * r;
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
        int c = col.getRGB();
        float cos1 = (float)Math.cos(Math.PI * 0.25);
        float sin1 = (float)Math.sin(Math.PI * 0.25);
        drawSlashQuad(bb, mat, -cos1 * len, -sin1 * len, cos1 * len, sin1 * len, thick, c);
        drawSlashQuad(bb, mat, cos1 * len, -sin1 * len, -cos1 * len, sin1 * len, thick, c);
        BufferRenderer.drawWithGlobalProgram(bb.end());
        draw3DRing(mat, r * 0.3F, 0.04F, col.mulAlpha(0.6F), 0.0F, 0.0F, 0.0F);
    }

    private void drawSlashQuad(BufferBuilder bb, Matrix4f mat, float x1, float y1, float x2, float y2, float thick, int c) {
        float dx = x2 - x1;
        float dy = y2 - y1;
        float len = (float)Math.sqrt(dx * dx + dy * dy);
        if (len < 0.001F) return;
        float nx = -dy / len * thick;
        float ny = dx / len * thick;
        bb.vertex(mat, x1 + nx, y1 + ny, 0.0F).color(c);
        bb.vertex(mat, x1 - nx, y1 - ny, 0.0F).color(c);
        bb.vertex(mat, x2 - nx, y2 - ny, 0.0F).color(c);
        bb.vertex(mat, x2 + nx, y2 + ny, 0.0F).color(c);
    }

    // 8. ShatterGlass: Triangular shards flying outward
    private void renderShatterGlass(MatrixStack m, float r, ColorRGBA col, float prog, float seed) {
        Matrix4f mat = m.peek().getPositionMatrix();
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
        int shards = 14;
        for (int i = 0; i < shards; i++) {
            double baseAng = (Math.PI * 2.0 * i) / shards + seed * 0.1;
            float dist = r * (0.3F + prog * 0.7F);
            float shardSize = r * 0.18F * (1.0F - prog * 0.6F);
            float cx = (float)Math.cos(baseAng) * dist;
            float cy = (float)Math.sin(baseAng) * dist;
            float rotOff = seed + i * 1.3F + prog * 5.0F;
            int c = col.mulAlpha(1.0F - prog * 0.8F).getRGB();
            for (int j = 0; j < 3; j++) {
                double a = rotOff + (Math.PI * 2.0 * j) / 3.0;
                bb.vertex(mat, cx + (float)Math.cos(a) * shardSize, cy + (float)Math.sin(a) * shardSize, 0.0F).color(c);
            }
        }
        BufferRenderer.drawWithGlobalProgram(bb.end());
    }

    // 9. PixelBurst: Minecraft-style blocky pixel explosion
    private void renderPixelBurst(MatrixStack m, float r, ColorRGBA col, float prog, float seed) {
        Matrix4f mat = m.peek().getPositionMatrix();
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
        int pixels = 20;
        float pixSize = r * 0.12F * (1.0F - prog * 0.5F);
        for (int i = 0; i < pixels; i++) {
            float ang = (float)(seed * 0.3 + i * 1.7);
            float dist = r * (0.15F + prog * 0.85F) * (0.6F + 0.4F * (float)Math.sin(ang * 2.3));
            float px = (float)Math.cos(ang) * dist;
            float py = (float)Math.sin(ang) * dist;
            int c = col.mulAlpha(1.0F - prog).getRGB();
            bb.vertex(mat, px - pixSize, py - pixSize, 0.0F).color(c);
            bb.vertex(mat, px - pixSize, py + pixSize, 0.0F).color(c);
            bb.vertex(mat, px + pixSize, py + pixSize, 0.0F).color(c);
            bb.vertex(mat, px + pixSize, py - pixSize, 0.0F).color(c);
        }
        BufferRenderer.drawWithGlobalProgram(bb.end());
    }

    // 10. SpiralPulse: Rotating spiral arms expanding outward
    private void renderSpiralPulse(MatrixStack m, float r, ColorRGBA col, float prog) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int arms = 3;
        int segs = 24;
        float rotSpeed = prog * (float)Math.PI * 4.0F;
        for (int arm = 0; arm < arms; arm++) {
            BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
            float armOff = (float)(Math.PI * 2.0 * arm) / arms;
            for (int i = 0; i <= segs; i++) {
                float t = (float) i / segs;
                float dist = r * t * (0.3F + prog * 0.7F);
                float ang = armOff + t * (float)Math.PI * 2.5F + rotSpeed;
                float thick = 0.04F * r * (1.0F - t * 0.7F);
                float x = (float)Math.cos(ang) * dist;
                float y = (float)Math.sin(ang) * dist;
                int c = col.mulAlpha((1.0F - prog) * (1.0F - t * 0.5F)).getRGB();
                bb.vertex(mat, x - thick, y, 0.0F).color(c);
                bb.vertex(mat, x + thick, y, 0.0F).color(c);
            }
            BufferRenderer.drawWithGlobalProgram(bb.end());
        }
    }

    // 11. StarImpact: 5-pointed star burst with inner ring
    private void renderStarImpact(MatrixStack m, float r, ColorRGBA col, float prog) {
        Matrix4f mat = m.peek().getPositionMatrix();
        draw3DRing(mat, r * 0.4F, 0.03F, col.mulAlpha(0.7F), 0.0F, 0.0F, 0.0F);
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
        int points = 5;
        int cTip = col.getRGB();
        int cBase = col.mulAlpha(0.4F).getRGB();
        for (int i = 0; i < points; i++) {
            double aOuter = (Math.PI * 2.0 * i) / points - Math.PI / 2.0;
            double aInner1 = (Math.PI * 2.0 * (i - 0.5)) / points - Math.PI / 2.0;
            double aInner2 = (Math.PI * 2.0 * (i + 0.5)) / points - Math.PI / 2.0;
            float outerR = r * 1.1F;
            float innerR = r * 0.4F;
            bb.vertex(mat, (float)Math.cos(aOuter) * outerR, (float)Math.sin(aOuter) * outerR, 0.0F).color(cTip);
            bb.vertex(mat, (float)Math.cos(aInner1) * innerR, (float)Math.sin(aInner1) * innerR, 0.0F).color(cBase);
            bb.vertex(mat, (float)Math.cos(aInner2) * innerR, (float)Math.sin(aInner2) * innerR, 0.0F).color(cBase);
        }
        BufferRenderer.drawWithGlobalProgram(bb.end());
    }

    // 12. DiamondCrack: Expanding diamond shape with crack lines
    private void renderDiamondCrack(MatrixStack m, float r, ColorRGBA col, float prog, float seed) {
        Matrix4f mat = m.peek().getPositionMatrix();
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_FAN, VertexFormats.POSITION_COLOR);
        int cCenter = col.mulAlpha(0.15F).getRGB();
        int cEdge = col.mulAlpha(0.9F * (1.0F - prog)).getRGB();
        bb.vertex(mat, 0.0F, 0.0F, 0.0F).color(cCenter);
        bb.vertex(mat, 0.0F, r, 0.0F).color(cEdge);
        bb.vertex(mat, r * 0.7F, 0.0F, 0.0F).color(cEdge);
        bb.vertex(mat, 0.0F, -r, 0.0F).color(cEdge);
        bb.vertex(mat, -r * 0.7F, 0.0F, 0.0F).color(cEdge);
        bb.vertex(mat, 0.0F, r, 0.0F).color(cEdge);
        BufferRenderer.drawWithGlobalProgram(bb.end());
        BufferBuilder bl = RenderSystem.renderThreadTesselator().begin(DrawMode.LINES, VertexFormats.POSITION_COLOR);
        int cl = col.getRGB();
        int cracks = 8;
        for (int i = 0; i < cracks; i++) {
            float ang = seed + (float)(Math.PI * 2.0 * i) / cracks;
            float dist = r * (0.5F + prog * 0.5F);
            bl.vertex(mat, 0.0F, 0.0F, 0.0F).color(cl);
            float jx = (float)Math.sin(ang * 3.0F + seed) * r * 0.15F;
            float jy = (float)Math.cos(ang * 2.7F + seed) * r * 0.15F;
            bl.vertex(mat, (float)Math.cos(ang) * dist + jx, (float)Math.sin(ang) * dist + jy, 0.0F).color(cl);
        }
        BufferRenderer.drawWithGlobalProgram(bl.end());
    }

    // 13. NeonFlash: Bright instant flash circle that fades
    private void renderNeonFlash(MatrixStack m, float r, ColorRGBA col, float prog) {
        Matrix4f mat = m.peek().getPositionMatrix();
        float flash = (1.0F - prog);
        flash = flash * flash;
        ColorRGBA bright = col.withAlpha(col.getAlpha() * flash);
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_FAN, VertexFormats.POSITION_COLOR);
        int cCenter = bright.getRGB();
        int cEdge = bright.mulAlpha(0.1F).getRGB();
        bb.vertex(mat, 0.0F, 0.0F, 0.0F).color(cCenter);
        int segs = 24;
        for (int i = 0; i <= segs; i++) {
            double a = (Math.PI * 2.0 * i) / segs;
            bb.vertex(mat, (float)Math.cos(a) * r, (float)Math.sin(a) * r, 0.0F).color(cEdge);
        }
        BufferRenderer.drawWithGlobalProgram(bb.end());
        draw3DRing(mat, r * 0.6F, r * 0.15F, bright, 0.0F, 0.0F, 0.0F);
    }

    // 14. VoidTear: Dark portal-like tear in space
    private void renderVoidTear(MatrixStack m, float r, ColorRGBA col, float prog) {
        Matrix4f mat = m.peek().getPositionMatrix();
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_FAN, VertexFormats.POSITION_COLOR);
        ColorRGBA voidCore = new ColorRGBA(20, 0, 40, col.getAlpha());
        int cCenter = voidCore.mulAlpha(0.9F * (1.0F - prog)).getRGB();
        int cEdge = col.mulAlpha(0.7F * (1.0F - prog)).getRGB();
        bb.vertex(mat, 0.0F, 0.0F, 0.0F).color(cCenter);
        int segs = 28;
        float scaleX = 0.5F;
        float scaleY = 1.2F;
        for (int i = 0; i <= segs; i++) {
            double a = (Math.PI * 2.0 * i) / segs;
            bb.vertex(mat, (float)Math.cos(a) * r * scaleX, (float)Math.sin(a) * r * scaleY, 0.0F).color(cEdge);
        }
        BufferRenderer.drawWithGlobalProgram(bb.end());
        draw3DRing(mat, r * 0.6F, 0.04F, col, 0.0F, 0.0F, 0.0F);
    }

    // 15. PrismBurst: Triangular prism fragments radiating out
    private void renderPrismBurst(MatrixStack m, float r, ColorRGBA col, float prog) {
        Matrix4f mat = m.peek().getPositionMatrix();
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
        int prisms = 10;
        for (int i = 0; i < prisms; i++) {
            double ang = (Math.PI * 2.0 * i) / prisms;
            float dist = r * (0.2F + prog * 0.8F);
            float size = r * 0.15F * (1.0F - prog * 0.6F);
            float cx = (float)Math.cos(ang) * dist;
            float cy = (float)Math.sin(ang) * dist;
            int c = col.mulAlpha(1.0F - prog * 0.7F).getRGB();
            for (int j = 0; j < 3; j++) {
                double ta = ang + (Math.PI * 2.0 * j) / 3.0 + prog * 2.0;
                bb.vertex(mat, cx + (float)Math.cos(ta) * size, cy + (float)Math.sin(ta) * size, 0.0F).color(c);
            }
        }
        safeDraw(bb);
        draw3DRing(mat, r * 0.5F, 0.025F, col.mulAlpha(0.5F), 0.0F, 0.0F, 0.0F);
    }

    // 16. ArcaneCircle: Magical rune circle with inner hexagram
    private void renderArcaneCircle(MatrixStack m, float r, ColorRGBA col, float prog) {
        Matrix4f mat = m.peek().getPositionMatrix();
        float t = Math.max(0.015F, r * 0.035F);
        draw3DRing(mat, r, t, col, 0.0F, 0.0F, 0.0F);
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.LINES, VertexFormats.POSITION_COLOR);
        int c = col.mulAlpha(0.8F * (1.0F - prog)).getRGB();
        float innerR = r * 0.65F;
        for (int i = 0; i < 3; i++) {
            double a1 = (Math.PI * 2.0 * i) / 3.0 - Math.PI / 2.0;
            double a2 = (Math.PI * 2.0 * ((i + 1) % 3)) / 3.0 - Math.PI / 2.0;
            bb.vertex(mat, (float)Math.cos(a1) * innerR, (float)Math.sin(a1) * innerR, 0.0F).color(c);
            bb.vertex(mat, (float)Math.cos(a2) * innerR, (float)Math.sin(a2) * innerR, 0.0F).color(c);
        }
        for (int i = 0; i < 3; i++) {
            double a1 = (Math.PI * 2.0 * i) / 3.0 + Math.PI / 6.0;
            double a2 = (Math.PI * 2.0 * ((i + 1) % 3)) / 3.0 + Math.PI / 6.0;
            bb.vertex(mat, (float)Math.cos(a1) * innerR, (float)Math.sin(a1) * innerR, 0.0F).color(c);
            bb.vertex(mat, (float)Math.cos(a2) * innerR, (float)Math.sin(a2) * innerR, 0.0F).color(c);
        }
        safeDraw(bb);
        draw3DRing(mat, r * 0.35F, t * 0.6F, col.mulAlpha(0.5F), 0.0F, 0.0F, 0.0F);
        BufferBuilder ticks = RenderSystem.renderThreadTesselator().begin(DrawMode.LINES, VertexFormats.POSITION_COLOR);
        int tc = col.mulAlpha(0.6F).getRGB();
        for (int i = 0; i < 12; i++) {
            double a = (Math.PI * 2.0 * i) / 12.0;
            float r1 = r * 0.88F;
            float r2 = r * 1.05F;
            ticks.vertex(mat, (float)Math.cos(a) * r1, (float)Math.sin(a) * r1, 0.0F).color(tc);
            ticks.vertex(mat, (float)Math.cos(a) * r2, (float)Math.sin(a) * r2, 0.0F).color(tc);
        }
        safeDraw(ticks);
    }

    // ============ HELPERS ============

    private void draw3DRing(Matrix4f mat, float radius, float thick, ColorRGBA col, float ox, float oy, float oz) {
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
        int c = col.getRGB();
        int segs = 36;
        for (int i = 0; i <= segs; i++) {
            double angle = (Math.PI * 2.0 * i) / segs;
            float cos = (float)Math.cos(angle);
            float sin = (float)Math.sin(angle);
            bb.vertex(mat, ox + cos * (radius - thick), oy + sin * (radius - thick), oz).color(c);
            bb.vertex(mat, ox + cos * (radius + thick), oy + sin * (radius + thick), oz).color(c);
        }
        safeDraw(bb);
    }

    private void renderCardExplosion(MatrixStack m, float r, ColorRGBA col, float prog, float seed) {
        int count = this.cardCount != null ? Math.max(3, (int)this.cardCount.Ii_method_a20abcd2()) : 8;
        float scale = this.cardScale != null ? this.cardScale.Ii_method_a20abcd2() : 1.0F;
        float spinMult = this.cardSpin != null ? this.cardSpin.Ii_method_a20abcd2() : 1.0F;
        float alpha = (1.0F - prog) * (col.getAlpha() / 255.0F);
        Identifier[] deck = getActiveDeck();
        Identifier back = getActiveBack();

        for (int i = 0; i < count; i++) {
            double ang = (Math.PI * 2.0 * i) / count + (seed * 0.1);
            float dist = r * (0.35F + prog * 0.85F);
            float cx = (float)Math.cos(ang) * dist;
            float cy = (float)Math.sin(ang) * dist;
            float cz = (float)Math.sin(seed + i * 2.0) * 0.25F * prog;

            m.push();
            m.translate(cx, cy, cz);
            m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees((float)Math.toDegrees(ang) + prog * 360.0F * spinMult));
            m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(prog * 240.0F * spinMult + i * 45.0F));
            float s = 0.35F * scale;
            m.scale(s, s, s);
            CardRenderHelper.renderCard(m, 0.65F, 0.95F, deck[i % deck.length], back, alpha, true);
            m.pop();
        }
    }

    private void renderAceBurst(MatrixStack m, float r, ColorRGBA col, float prog, float seed) {
        float scale = this.cardScale != null ? this.cardScale.Ii_method_a20abcd2() : 1.0F;
        float spinMult = this.cardSpin != null ? this.cardSpin.Ii_method_a20abcd2() : 1.0F;
        int count = 4;
        float dist = r * 0.65F;
        float alpha = (1.0F - prog) * (col.getAlpha() / 255.0F);
        Identifier[] deck = getActiveDeck();
        Identifier back = getActiveBack();

        for (int i = 0; i < count; i++) {
            double ang = (Math.PI * 0.5 * i) + (prog * 0.5 * spinMult);
            float cx = (float)Math.cos(ang) * dist;
            float cy = (float)Math.sin(ang) * dist;

            m.push();
            m.translate(cx, cy, 0.0F);
            m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees((float)Math.toDegrees(ang) - 90.0F + (float)Math.sin(prog * 4.0F * spinMult) * 15.0F));
            float s = 0.42F * scale;
            m.scale(s, s, s);
            CardRenderHelper.renderCard(m, 0.72F, 1.05F, deck[i % deck.length], back, alpha, true);
            m.pop();
        }

        Matrix4f mat = m.peek().getPositionMatrix();
        draw3DRing(mat, r * 0.3F, Math.max(0.012F, r * 0.025F), col.mulAlpha(0.8F), 0.0F, 0.0F, 0.0F);
    }

    private void renderCardVortex(MatrixStack m, float r, ColorRGBA col, float prog, float seed) {
        int count = this.cardCount != null ? Math.max(3, (int)this.cardCount.Ii_method_a20abcd2()) : 10;
        float scale = this.cardScale != null ? this.cardScale.Ii_method_a20abcd2() : 1.0F;
        float spinMult = this.cardSpin != null ? this.cardSpin.Ii_method_a20abcd2() : 1.0F;
        float alpha = (1.0F - prog) * (col.getAlpha() / 255.0F);
        Identifier[] deck = getActiveDeck();
        Identifier back = getActiveBack();

        for (int i = 0; i < count; i++) {
            float t = (float) i / count;
            double ang = prog * 8.0F * spinMult + t * Math.PI * 4.0;
            float dist = r * (0.25F + t * 0.85F);
            float cx = (float)Math.cos(ang) * dist;
            float cy = (float)Math.sin(ang) * dist;
            float cz = (t - 0.5F) * 0.6F * r;

            m.push();
            m.translate(cx, cy, cz);
            m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees((float)Math.toDegrees(ang) + 90.0F));
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(prog * 360.0F * spinMult + i * 30.0F));
            float s = 0.30F * scale;
            m.scale(s, s, s);
            CardRenderHelper.renderCard(m, 0.65F, 0.95F, deck[i % deck.length], back, alpha, true);
            m.pop();
        }
        Matrix4f mat = m.peek().getPositionMatrix();
        draw3DRing(mat, r * 0.45F, 0.025F, col.mulAlpha(0.7F), 0.0F, 0.0F, 0.0F);
    }

    private static void drawHitCard(BufferBuilder buf, Matrix4f mat, float w, float h, int suit, int alpha) {
        float hw = w * 0.5F;
        float hh = h * 0.5F;
        int a = Math.max(0, Math.min(255, alpha));
        int cardWhite = (a << 24) | 0x00F8F8F8;
        int cardBorder = (a << 24) | 0x00202020;
        int suitColor = (suit == 0 || suit == 3) ? ((a << 24) | 0x00151515) : ((a << 24) | 0x00DC143C);

        // Front Face
        buf.vertex(mat, -hw, -hh, 0.0F).color(cardWhite);
        buf.vertex(mat, hw, -hh, 0.0F).color(cardWhite);
        buf.vertex(mat, hw, hh, 0.0F).color(cardWhite);
        buf.vertex(mat, -hw, hh, 0.0F).color(cardWhite);

        // Border
        float bw = 0.01F;
        buf.vertex(mat, -hw, -hh, 0.001F).color(cardBorder);
        buf.vertex(mat, hw, -hh, 0.001F).color(cardBorder);
        buf.vertex(mat, hw, -hh + bw, 0.001F).color(cardBorder);
        buf.vertex(mat, -hw, -hh + bw, 0.001F).color(cardBorder);

        buf.vertex(mat, -hw, hh - bw, 0.001F).color(cardBorder);
        buf.vertex(mat, hw, hh - bw, 0.001F).color(cardBorder);
        buf.vertex(mat, hw, hh, 0.001F).color(cardBorder);
        buf.vertex(mat, -hw, hh, 0.001F).color(cardBorder);

        // Suit symbol
        float sw = hw * 0.45F;
        float sh = hh * 0.45F;
        buf.vertex(mat, 0.0F, sh, 0.002F).color(suitColor);
        buf.vertex(mat, sw, 0.0F, 0.002F).color(suitColor);
        buf.vertex(mat, 0.0F, -sh, 0.002F).color(suitColor);
        buf.vertex(mat, -sw, 0.0F, 0.002F).color(suitColor);

        // Back face
        int backRed = (a << 24) | 0x00900C3F;
        int backGold = (a << 24) | 0x00FFD700;
        buf.vertex(mat, -hw, -hh, -0.001F).color(backRed);
        buf.vertex(mat, hw, -hh, -0.001F).color(backRed);
        buf.vertex(mat, hw, hh, -0.001F).color(backRed);
        buf.vertex(mat, -hw, hh, -0.001F).color(backRed);

        buf.vertex(mat, 0.0F, hh * 0.6F, -0.002F).color(backGold);
        buf.vertex(mat, hw * 0.6F, 0.0F, -0.002F).color(backGold);
        buf.vertex(mat, 0.0F, -hh * 0.6F, -0.002F).color(backGold);
        buf.vertex(mat, -hw * 0.6F, 0.0F, -0.002F).color(backGold);
    }
}
