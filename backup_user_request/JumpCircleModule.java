package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;

@ModuleInfo(
    name = "Jump Circle",
    category = ModuleCategory.VISUALS,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.jump_circle"
)
public class JumpCircleModule extends Module {
    private static class Circle {
        final double x, y, z;
        final long startTime;

        Circle(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.startTime = System.currentTimeMillis();
        }
    }

    private final List<Circle> circles = new ArrayList<>();
    private boolean wasOnGround = true;

    // 10 Modes (including 2 with cards)
    private ModeSetting modeSetting;
    private ModeSetting.Nested1_42765c60 modeRing;
    private ModeSetting.Nested1_42765c60 modeStar;
    private ModeSetting.Nested1_42765c60 modeCyber;
    private ModeSetting.Nested1_42765c60 modeRunic;
    private ModeSetting.Nested1_42765c60 modeShockwave;
    private ModeSetting.Nested1_42765c60 modeLotus;
    private ModeSetting.Nested1_42765c60 modeVortex;
    private ModeSetting.Nested1_42765c60 modeFire;
    private ModeSetting.Nested1_42765c60 modeCardRing;
    private ModeSetting.Nested1_42765c60 modeRoyalFlush;

    private SliderSetting maxRadius;
    private SliderSetting durationSetting;
    private SliderSetting thickness;

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
    private ColorSetting customColor;

    private final IiIIIiII_Class69<ClientPlayerTickEvent> tickEvent = this::onTick;
    private final IiIIIiII_Class69<Render3DEvent> renderEvent = this::onRender3D;

    public JumpCircleModule() {
        this.initSettings();
    }

    private boolean isCardMode() {
        return (this.modeCardRing != null && this.modeCardRing.isSelected())
            || (this.modeRoyalFlush != null && this.modeRoyalFlush.isSelected());
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

    private void initSettings() {
        this.modeSetting = new ModeSetting(this, "Mode");
        this.modeRing = new ModeSetting.Nested1_42765c60(this.modeSetting, "Ring").select();
        this.modeStar = new ModeSetting.Nested1_42765c60(this.modeSetting, "Star");
        this.modeCyber = new ModeSetting.Nested1_42765c60(this.modeSetting, "Cyber");
        this.modeRunic = new ModeSetting.Nested1_42765c60(this.modeSetting, "Runic");
        this.modeShockwave = new ModeSetting.Nested1_42765c60(this.modeSetting, "Shockwave");
        this.modeLotus = new ModeSetting.Nested1_42765c60(this.modeSetting, "Lotus");
        this.modeVortex = new ModeSetting.Nested1_42765c60(this.modeSetting, "Vortex");
        this.modeFire = new ModeSetting.Nested1_42765c60(this.modeSetting, "Fire");
        this.modeCardRing = new ModeSetting.Nested1_42765c60(this.modeSetting, "Card Ring");
        this.modeRoyalFlush = new ModeSetting.Nested1_42765c60(this.modeSetting, "Royal Flush");

        this.maxRadius = new SliderSetting(this, "Max Radius")
            .I_method_c8c9a7d7(0.8F)
            .i_method_65e2aff7(4.0F)
            .II_method_b0f56334(0.1F)
            .Ii_method_4e0e6b54(2.0F);

        this.durationSetting = new SliderSetting(this, "Duration (ms)")
            .I_method_c8c9a7d7(300.0F)
            .i_method_65e2aff7(2000.0F)
            .II_method_b0f56334(50.0F)
            .Ii_method_4e0e6b54(800.0F);

        this.thickness = new SliderSetting(this, "Thickness")
            .I_method_c8c9a7d7(0.02F)
            .i_method_65e2aff7(0.25F)
            .II_method_b0f56334(0.01F)
            .Ii_method_4e0e6b54(0.07F);

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
            .I_method_c8c9a7d7(0.0F)
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

        this.syncTheme = new BooleanSetting(this, "Sync Theme").I_method_decd82b5();
        this.glowSetting = new BooleanSetting(this, "Glow");
        this.customColor = new ColorSetting(this, "Color").I_method_a62f5dd6(new ColorRGBA(160.0F, 245.0F, 255.0F, 240.0F));
    }

    @Override
    public String i_method_bf522194() {
        return "Красивые расширяющиеся неоновые круги на земле при прыжке игрока (9 уникальных стилей).";
    }

    private void onTick(ClientPlayerTickEvent event) {
        MinecraftClient mc = MinecraftClient.getInstance();
        ClientPlayerEntity player = mc.player;
        if (player == null) return;

        boolean onGround = player.isOnGround();
        if (this.wasOnGround && !onGround && player.getVelocity().y > 0.05) {
            this.circles.add(new Circle(player.getX(), player.getY() + 0.02, player.getZ()));
        }
        this.wasOnGround = onGround;
    }

    private void onRender3D(Render3DEvent event) {
        if (this.circles.isEmpty()) return;
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.world == null) return;

        long now = System.currentTimeMillis();
        float dur = this.durationSetting.Ii_method_a20abcd2();
        Vec3d cam = mc.gameRenderer.getCamera().getPos();

        ColorRGBA baseColor = this.syncTheme.i_method_9b12da03()
            ? IiiiiIIIi_Class242.I_method_7df8e08e()
            : this.customColor.I_method_bde5f08e();

        RenderSystem.enableBlend();
        try {
        if (this.glowSetting.i_method_9b12da03()) {
            RenderSystem.blendFunc(com.mojang.blaze3d.platform.GlStateManager.SrcFactor.SRC_ALPHA, com.mojang.blaze3d.platform.GlStateManager.DstFactor.ONE);
        } else {
            RenderSystem.defaultBlendFunc();
        }
        RenderSystem.disableCull();
        RenderSystem.disableDepthTest();
        RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);

        MatrixStack matrices = event.getMatrices();
        float maxR = this.maxRadius.Ii_method_a20abcd2();
        float th = this.thickness.Ii_method_a20abcd2();

        Iterator<Circle> it = this.circles.iterator();
        while (it.hasNext()) {
            Circle c = it.next();
            float progress = (float)(now - c.startTime) / dur;
            if (progress >= 1.0F) {
                it.remove();
                continue;
            }

            float inv = 1.0F - progress;
            float ease = 1.0F - inv * inv * inv;
            float r = maxR * ease;
            float alpha = (1.0F - progress) * (1.0F - progress);
            ColorRGBA col = baseColor.withAlpha(baseColor.getAlpha() * alpha);

            matrices.push();
            try {
                matrices.translate(c.x - cam.x, c.y - cam.y, c.z - cam.z);
            Matrix4f mat = matrices.peek().getPositionMatrix();

            if (this.glowSetting.i_method_9b12da03()) {
                drawGroundBloomQuad(mat, r, col);
                drawGroundGlowHalo(mat, r, th * 2.5F, col, 36);
            }

            float t1 = Math.min(th, r * 0.18F);

            if (this.modeRing != null && this.modeRing.isSelected()) {
                // 1. Ring: Double neon ring with guaranteed non-touching clearance
                drawGroundRing(mat, r, t1, col, 40);
                float gap = Math.max(0.09F, r * 0.22F);
                float r2 = (r - t1) - gap - (t1 * 0.5F);
                if (r2 > 0.08F) {
                    drawGroundRing(mat, r2, t1 * 0.5F, col.mulAlpha(0.6F), 32);
                    float r3 = (r2 - t1 * 0.5F) - gap * 0.9F - (t1 * 0.3F);
                    if (r3 > 0.06F) {
                        drawGroundRing(mat, r3, t1 * 0.3F, col.mulAlpha(0.35F), 24);
                    }
                }
            } else if (this.modeStar != null && this.modeStar.isSelected()) {
                // 2. Star: 5-pointed star mandala strictly separated from outer ring
                drawGroundRing(mat, r, t1 * 0.7F, col.mulAlpha(0.7F), 36);
                float gap = Math.max(0.10F, r * 0.22F);
                float starOuter = (r - t1 * 0.7F) - gap;
                if (starOuter > 0.15F) {
                    float starInner = starOuter * 0.42F;
                    drawGroundStar(mat, starOuter, starInner, t1 * 0.5F, col, 5, progress * 1.5F);
                    float coreR = (starInner - t1 * 0.5F) - gap * 0.7F;
                    if (coreR > 0.05F) {
                        drawGroundRing(mat, coreR, t1 * 0.35F, col.mulAlpha(0.5F), 20);
                    }
                }
            } else if (this.modeCyber != null && this.modeCyber.isSelected()) {
                // 3. Cyber: Hexagon tech ring strictly separated from inner elements
                drawGroundPolygon(mat, r, t1, col, 6, progress * 0.5F);
                float gap = Math.max(0.11F, r * 0.24F);
                float r2 = (r - t1) - gap;
                if (r2 > 0.12F) {
                    drawGroundPolygon(mat, r2, t1 * 0.6F, col.mulAlpha(0.6F), 6, -progress * 0.8F);
                    float r3 = (r2 - t1 * 0.6F) - gap * 0.8F;
                    if (r3 > 0.06F) {
                        drawGroundRing(mat, r3, t1 * 0.35F, col.mulAlpha(0.4F), 24);
                    }
                }
            } else if (this.modeRunic != null && this.modeRunic.isSelected()) {
                // 4. Runic: Arcane glyph ground ring with guaranteed gaps
                drawGroundRing(mat, r, t1, col, 36);
                float gap = Math.max(0.10F, r * 0.22F);
                float r2 = (r - t1) - gap;
                if (r2 > 0.12F) {
                    drawGroundPolygon(mat, r2, t1 * 0.55F, col.mulAlpha(0.7F), 8, progress * 2.0F);
                    float r3 = (r2 - t1 * 0.55F) - gap;
                    if (r3 > 0.06F) {
                        drawGroundRing(mat, r3, t1 * 0.4F, col.mulAlpha(0.45F), 24);
                    }
                }
            } else if (this.modeShockwave != null && this.modeShockwave.isSelected()) {
                // 5. Shockwave: Multi-band non-touching ripple shockwaves
                drawGroundRing(mat, r, t1 * 1.1F, col, 40);
                float gap1 = Math.max(0.11F, r * 0.22F);
                float r2 = (r - t1 * 1.1F) - gap1 - (t1 * 0.7F);
                if (r2 > 0.12F) {
                    drawGroundRing(mat, r2, t1 * 0.7F, col.mulAlpha(0.7F), 36);
                    float gap2 = Math.max(0.10F, r2 * 0.24F);
                    float r3 = (r2 - t1 * 0.7F) - gap2 - (t1 * 0.45F);
                    if (r3 > 0.06F) {
                        drawGroundRing(mat, r3, t1 * 0.45F, col.mulAlpha(0.4F), 28);
                    }
                }
            } else if (this.modeLotus != null && this.modeLotus.isSelected()) {
                // 6. Lotus: Unfolding sacred 8-petal geometry with clean ring gap
                drawGroundRing(mat, r, t1 * 0.6F, col.mulAlpha(0.6F), 36);
                float gap = Math.max(0.09F, r * 0.20F);
                float rLotus = (r - t1 * 0.6F) - gap;
                if (rLotus > 0.12F) {
                    drawGroundLotus(mat, rLotus, t1 * 0.5F, col, 8, progress * 0.8F);
                    float rCenter = rLotus * 0.35F - t1 * 0.5F - gap * 0.5F;
                    if (rCenter > 0.05F) {
                        drawGroundRing(mat, rCenter, t1 * 0.35F, col.mulAlpha(0.5F), 24);
                    }
                }
            } else if (this.modeVortex != null && this.modeVortex.isSelected()) {
                // 7. Vortex: Spiral arms contained strictly inside outer perimeter
                drawGroundRing(mat, r, t1 * 0.7F, col.mulAlpha(0.7F), 36);
                float rVortex = (r - t1 * 0.7F) - Math.max(0.09F, r * 0.18F);
                if (rVortex > 0.10F) {
                    drawGroundVortex(mat, rVortex, t1 * 0.4F, col, 4, progress * 3.0F);
                }
            } else if (this.modeFire != null && this.modeFire.isSelected()) {
                // 8. Fire: Blazing flame perimeter with strict inner gap
                ColorRGBA fireCol = new ColorRGBA(255.0F, 100.0F, 30.0F, col.getAlpha());
                drawGroundFire(mat, r, t1, fireCol, progress);
                float gap = Math.max(0.12F, r * 0.26F);
                float rIn = (r - t1) - gap;
                if (rIn > 0.08F) {
                    drawGroundRing(mat, rIn, t1 * 0.5F, new ColorRGBA(255.0F, 220.0F, 50.0F, col.getAlpha() * 0.8F), 32);
                }
            } else if (this.modeCardRing != null && this.modeCardRing.isSelected()) {
                // 9. Card Ring: 8 playing cards smoothly spinning along the expanding perimeter
                drawGroundRing(mat, r, t1 * 0.7F, col.mulAlpha(0.6F), 36);
                drawGroundCardRing(matrices, r, col, progress);
            } else if (this.modeRoyalFlush != null && this.modeRoyalFlush.isSelected()) {
                // 10. Royal Flush: 5 giant golden playing cards fanning out in a majestic arc
                drawGroundRing(mat, r * 0.5F, t1 * 0.5F, new ColorRGBA(255.0F, 215.0F, 0.0F, col.getAlpha() * 0.8F), 32);
                drawGroundRoyalFlush(matrices, r, col, progress);
            } else {
                drawGroundRing(mat, r, t1, col, 36);
            }

            } finally {
                matrices.pop();
            }
        }

                } finally {
            RenderSystem.enableDepthTest();
            RenderSystem.enableCull();
            RenderSystem.defaultBlendFunc();
            RenderSystem.disableBlend();
            RenderSystem.setShaderTexture(0, 0);
        }
    }

    private static void safeDraw(BufferBuilder bb) {
        BuiltBuffer built = bb.endNullable();
        if (built != null) {
            BufferRenderer.drawWithGlobalProgram(built);
        }
    }

    private void drawGroundBloomQuad(Matrix4f mat, float radius, ColorRGBA col) {
        RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
        RenderSystem.setShaderTexture(0, RockstarClient.id("textures/bloom.png"));
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
        int c = col.withAlpha(Math.min(255, (int)(col.getAlpha() * 0.9F))).getRGB();
        float r = radius * 1.35F;
        bb.vertex(mat, -r, 0.003F, -r).texture(0.0F, 0.0F).color(c);
        bb.vertex(mat, -r, 0.003F, r).texture(0.0F, 1.0F).color(c);
        bb.vertex(mat, r, 0.003F, r).texture(1.0F, 1.0F).color(c);
        bb.vertex(mat, r, 0.003F, -r).texture(1.0F, 0.0F).color(c);
        safeDraw(bb);
        RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
    }

    private void drawGroundGlowHalo(Matrix4f mat, float radius, float glowWidth, ColorRGBA col, int segs) {
        RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
        int innerCol = col.withAlpha(Math.min(255, (int)(col.getAlpha() * 0.70F))).getRGB();
        int outerCol = col.withAlpha(0).getRGB();
        for (int i = 0; i <= segs; i++) {
            double angle = (Math.PI * 2.0 * i) / segs;
            float cos = (float)Math.cos(angle);
            float sin = (float)Math.sin(angle);
            bb.vertex(mat, cos * (radius - glowWidth * 0.5F), 0.004F, sin * (radius - glowWidth * 0.5F)).color(outerCol);
            bb.vertex(mat, cos * radius, 0.005F, sin * radius).color(innerCol);
        }
        safeDraw(bb);

        BufferBuilder bbOuter = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
        for (int i = 0; i <= segs; i++) {
            double angle = (Math.PI * 2.0 * i) / segs;
            float cos = (float)Math.cos(angle);
            float sin = (float)Math.sin(angle);
            bbOuter.vertex(mat, cos * radius, 0.005F, sin * radius).color(innerCol);
            bbOuter.vertex(mat, cos * (radius + glowWidth * 1.8F), 0.004F, sin * (radius + glowWidth * 1.8F)).color(outerCol);
        }
        safeDraw(bbOuter);
    }

    private void drawGroundRing(Matrix4f mat, float radius, float thick, ColorRGBA col, int segs) {
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
        int c = col.getRGB();
        for (int i = 0; i <= segs; i++) {
            double angle = (Math.PI * 2.0 * i) / segs;
            float cos = (float)Math.cos(angle);
            float sin = (float)Math.sin(angle);
            bb.vertex(mat, cos * (radius - thick), 0.0F, sin * (radius - thick)).color(c);
            bb.vertex(mat, cos * (radius + thick), 0.0F, sin * (radius + thick)).color(c);
        }
        safeDraw(bb);
    }

    private void drawGroundPolygon(Matrix4f mat, float radius, float thick, ColorRGBA col, int sides, float rot) {
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
        int c = col.getRGB();
        for (int i = 0; i <= sides; i++) {
            double angle = (Math.PI * 2.0 * i) / sides + rot;
            float cos = (float)Math.cos(angle);
            float sin = (float)Math.sin(angle);
            bb.vertex(mat, cos * (radius - thick), 0.0F, sin * (radius - thick)).color(c);
            bb.vertex(mat, cos * (radius + thick), 0.0F, sin * (radius + thick)).color(c);
        }
        safeDraw(bb);
    }

    private void drawGroundStar(Matrix4f mat, float rOuter, float rInner, float thick, ColorRGBA col, int points, float rot) {
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
        int c = col.getRGB();
        int total = points * 2;
        for (int i = 0; i <= total; i++) {
            double angle = (Math.PI * 2.0 * i) / total + rot;
            float rad = (i % 2 == 0) ? rOuter : rInner;
            float cos = (float)Math.cos(angle);
            float sin = (float)Math.sin(angle);
            bb.vertex(mat, cos * (rad - thick), 0.0F, sin * (rad - thick)).color(c);
            bb.vertex(mat, cos * (rad + thick), 0.0F, sin * (rad + thick)).color(c);
        }
        safeDraw(bb);
    }

    private void drawGroundLotus(Matrix4f mat, float radius, float thick, ColorRGBA col, int petals, float rot) {
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
        int c = col.getRGB();
        int segs = petals * 12;
        for (int i = 0; i <= segs; i++) {
            double angle = (Math.PI * 2.0 * i) / segs + rot;
            float mod = (float)Math.abs(Math.sin(angle * petals * 0.5));
            float r = radius * (0.5F + 0.5F * mod);
            float cos = (float)Math.cos(angle);
            float sin = (float)Math.sin(angle);
            bb.vertex(mat, cos * (r - thick), 0.0F, sin * (r - thick)).color(c);
            bb.vertex(mat, cos * (r + thick), 0.0F, sin * (r + thick)).color(c);
        }
        safeDraw(bb);
    }

    private void drawGroundVortex(Matrix4f mat, float radius, float thick, ColorRGBA col, int arms, float rot) {
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
        int c = col.getRGB();
        for (int a = 0; a < arms; a++) {
            double baseA = (Math.PI * 2.0 * a) / arms + rot;
            for (int s = 0; s < 12; s++) {
                float t1 = s / 12.0F;
                float t2 = (s + 1) / 12.0F;
                double a1 = baseA + t1 * 1.5;
                double a2 = baseA + t2 * 1.5;
                float r1 = radius * t1;
                float r2 = radius * t2;
                bb.vertex(mat, (float)Math.cos(a1) * r1, 0.0F, (float)Math.sin(a1) * r1).color(c);
                bb.vertex(mat, (float)Math.cos(a2) * r2, 0.0F, (float)Math.sin(a2) * r2).color(c);
                bb.vertex(mat, (float)Math.cos(a2) * (r2 + thick * 2), 0.0F, (float)Math.sin(a2) * (r2 + thick * 2)).color(c);
            }
        }
        safeDraw(bb);
    }

    private void drawGroundFire(Matrix4f mat, float radius, float thick, ColorRGBA col, float prog) {
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
        int c = col.getRGB();
        int segs = 36;
        for (int i = 0; i <= segs; i++) {
            double angle = (Math.PI * 2.0 * i) / segs;
            float jitter = (float)Math.sin(i * 5.0 + prog * 20.0) * thick * 1.5F;
            float cos = (float)Math.cos(angle);
            float sin = (float)Math.sin(angle);
            bb.vertex(mat, cos * (radius - thick), 0.0F, sin * (radius - thick)).color(c);
            bb.vertex(mat, cos * (radius + thick + jitter), 0.0F, sin * (radius + thick + jitter)).color(c);
        }
        safeDraw(bb);
    }

    private void drawGroundSnowflake(Matrix4f mat, float radius, float thick, ColorRGBA col, float rot) {
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
        int c = col.getRGB();
        for (int i = 0; i < 6; i++) {
            double angle = (Math.PI * 2.0 * i) / 6 + rot;
            float cos = (float)Math.cos(angle);
            float sin = (float)Math.sin(angle);
            float pCos = -sin;
            float pSin = cos;

            // Main arm
            bb.vertex(mat, -pCos * thick, 0.0F, -pSin * thick).color(c);
            bb.vertex(mat, pCos * thick, 0.0F, pSin * thick).color(c);
            bb.vertex(mat, cos * radius, 0.0F, sin * radius).color(c);

            // Side barbs
            float midR = radius * 0.6F;
            float bx = cos * midR;
            float bz = sin * midR;
            bb.vertex(mat, bx, 0.0F, bz).color(c);
            bb.vertex(mat, bx + (cos + pCos) * (radius * 0.25F), 0.0F, bz + (sin + pSin) * (radius * 0.25F)).color(c);
            bb.vertex(mat, bx + (cos + pCos) * (radius * 0.25F) + pCos * thick, 0.0F, bz + (sin + pSin) * (radius * 0.25F) + pSin * thick).color(c);

            bb.vertex(mat, bx, 0.0F, bz).color(c);
            bb.vertex(mat, bx + (cos - pCos) * (radius * 0.25F), 0.0F, bz + (sin - pSin) * (radius * 0.25F)).color(c);
            bb.vertex(mat, bx + (cos - pCos) * (radius * 0.25F) - pCos * thick, 0.0F, bz + (sin - pSin) * (radius * 0.25F) - pSin * thick).color(c);
        }
        safeDraw(bb);
    }

    // 10. TorusRing: Volumetric 3D torus ring that rises above ground
    private void drawTorusRing(Matrix4f mat, float radius, float thick, ColorRGBA col, float progress) {
        int majorSegs = 36;
        int minorSegs = 8;
        float tubeR = thick * 2.0F;
        float riseY = 0.15F * progress; // Slight rise
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
        int c = col.getRGB();
        int cDark = col.mulAlpha(0.5F).getRGB();
        for (int i = 0; i <= majorSegs; i++) {
            double majorAngle = (Math.PI * 2.0 * i) / majorSegs;
            float majorCos = (float)Math.cos(majorAngle);
            float majorSin = (float)Math.sin(majorAngle);
            for (int j = 0; j <= minorSegs; j++) {
                double minorAngle = (Math.PI * 2.0 * j) / minorSegs;
                float minorCos = (float)Math.cos(minorAngle);
                float minorSin = (float)Math.sin(minorAngle);
                float x = (radius + tubeR * minorCos) * majorCos;
                float y = riseY + tubeR * minorSin;
                float z = (radius + tubeR * minorCos) * majorSin;
                int cc = (minorSin > 0) ? c : cDark; // top lit, bottom dark
                bb.vertex(mat, x, y, z).color(cc);
            }
        }
        safeDraw(bb);
    }

    // 11. OvalRing: Tilted elliptical ring
    private void drawOvalRing(Matrix4f mat, float radius, float thick, ColorRGBA col, float progress) {
        float scaleX = 1.0F;
        float scaleZ = 0.6F;
        float tilt = 0.2F * (1.0F - progress); // Tilt fades as it expands
        int segs = 40;
        // Draw 2 rings for volume
        for (float yOff : new float[]{0.0F, thick * 2.0F}) {
            BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
            int c = col.mulAlpha(yOff == 0.0F ? 1.0F : 0.5F).getRGB();
            for (int i = 0; i <= segs; i++) {
                double a = (Math.PI * 2.0 * i) / segs;
                float cx = (float)Math.cos(a) * radius * scaleX;
                float cz = (float)Math.sin(a) * radius * scaleZ;
                float cy = yOff + tilt * cx;
                bb.vertex(mat, cx, cy + thick, cz).color(c);
                bb.vertex(mat, cx, cy - thick, cz).color(c);
            }
            safeDraw(bb);
        }
    }

    // 12. HexRing: Hexagonal tube ring (6-sided cross section)
    private void drawHexRing(Matrix4f mat, float radius, float thick, ColorRGBA col, float progress) {
        int majorSegs = 36;
        int hexSides = 6;
        float tubeR = thick * 1.5F;
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
        int c = col.getRGB();
        int cDim = col.mulAlpha(0.4F).getRGB();
        for (int i = 0; i <= majorSegs; i++) {
            double majorAngle = (Math.PI * 2.0 * i) / majorSegs;
            float majorCos = (float)Math.cos(majorAngle);
            float majorSin = (float)Math.sin(majorAngle);
            for (int j = 0; j <= hexSides; j++) {
                double minorAngle = (Math.PI * 2.0 * j) / hexSides;
                float minorCos = (float)Math.cos(minorAngle);
                float minorSin = (float)Math.sin(minorAngle);
                float x = (radius + tubeR * minorCos) * majorCos;
                float y = tubeR * minorSin;
                float z = (radius + tubeR * minorCos) * majorSin;
                int cc = (j % 2 == 0) ? c : cDim;
                bb.vertex(mat, x, y, z).color(cc);
            }
        }
        safeDraw(bb);
    }

    // 13. Card Ring: playing cards spinning along expanding perimeter
    private void drawGroundCardRing(MatrixStack matrices, float radius, ColorRGBA col, float progress) {
        int count = this.cardCount != null ? Math.max(3, (int)this.cardCount.Ii_method_a20abcd2()) : 8;
        float scale = this.cardScale != null ? this.cardScale.Ii_method_a20abcd2() : 1.0F;
        float spinMult = this.cardSpin != null ? this.cardSpin.Ii_method_a20abcd2() : 1.0F;
        float alpha = col.getAlpha() / 255.0F;
        Identifier[] deck = getActiveDeck();
        Identifier back = getActiveBack();

        for (int i = 0; i < count; i++) {
            double angle = progress * (3.0F * spinMult) + (i * Math.PI * 2.0 / count);
            float cx = (float)Math.cos(angle) * radius;
            float cz = (float)Math.sin(angle) * radius;
            float cy = 0.05F + (float)Math.sin(progress * 6.0F + i) * 0.06F;

            matrices.push();
            matrices.translate(cx, cy, cz);
            float cardYaw = (float)Math.toDegrees(-angle) + 90.0F;
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(cardYaw));
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-55.0F));
            float s = 0.38F * scale;
            matrices.scale(s, s, s);
            CardRenderHelper.renderCard(matrices, 0.70F, 1.0F, deck[i % deck.length], back, alpha, true);
            matrices.pop();
        }
    }

    // 14. Royal Flush: 5 giant golden cards (10, J, Q, K, A) fanning out in a majestic arc
    private void drawGroundRoyalFlush(MatrixStack matrices, float radius, ColorRGBA col, float progress) {
        float scale = this.cardScale != null ? this.cardScale.Ii_method_a20abcd2() : 1.0F;
        float spinMult = this.cardSpin != null ? this.cardSpin.Ii_method_a20abcd2() : 1.0F;
        Identifier[] deck = getActiveDeck();
        Identifier back = getActiveBack();
        int count = deck.length;
        float fanStep = 16.0F;
        float alpha = col.getAlpha() / 255.0F;
        float expand = Math.min(1.0F, progress * 2.2F);

        for (int i = 0; i < count; i++) {
            float fanAngle = (i - count / 2) * fanStep * expand;
            double rad = Math.toRadians(fanAngle);
            float rDist = radius * 0.90F;
            float cx = (float)Math.sin(rad) * rDist;
            float cz = (float)Math.cos(rad) * rDist * 0.55F;
            float cy = 0.08F + i * 0.035F + (float)Math.sin(progress * 4.0F * spinMult + i * 0.5F) * 0.04F;

            matrices.push();
            matrices.translate(cx, cy, cz);
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-fanAngle));
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-55.0F * (1.0F - progress * 0.25F)));
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-fanAngle * 0.4F));
            float s = 0.48F * scale;
            matrices.scale(s, s, s);

            CardRenderHelper.renderCard(matrices, 0.85F, 1.20F, deck[i], back, alpha, true);
            matrices.pop();
        }
    }

    private static void drawCardGeometry(BufferBuilder buf, Matrix4f mat, float w, float h, int suit, int alpha) {
        float hw = w * 0.5F;
        float hh = h * 0.5F;
        int a = Math.max(0, Math.min(255, alpha));
        int cardWhite = (a << 24) | 0x00F8F8F8;
        int cardBorder = (a << 24) | 0x00222222;
        int suitColor = (suit == 0 || suit == 3) ? ((a << 24) | 0x001A1A1A) : ((a << 24) | 0x00DC143C);

        // Front Face
        buf.vertex(mat, -hw, -hh, 0.0F).color(cardWhite);
        buf.vertex(mat, hw, -hh, 0.0F).color(cardWhite);
        buf.vertex(mat, hw, hh, 0.0F).color(cardWhite);
        buf.vertex(mat, -hw, hh, 0.0F).color(cardWhite);

        // Border
        float bw = 0.012F;
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

        // Back Face
        int backRed = (a << 24) | 0x008B0000;
        int backGold = (a << 24) | 0x00FFD700;
        buf.vertex(mat, -hw, -hh, -0.001F).color(backRed);
        buf.vertex(mat, hw, -hh, -0.001F).color(backRed);
        buf.vertex(mat, hw, hh, -0.001F).color(backRed);
        buf.vertex(mat, -hw, hh, -0.001F).color(backRed);

        buf.vertex(mat, 0.0F, hh * 0.65F, -0.002F).color(backGold);
        buf.vertex(mat, hw * 0.65F, 0.0F, -0.002F).color(backGold);
        buf.vertex(mat, 0.0F, -hh * 0.65F, -0.002F).color(backGold);
        buf.vertex(mat, -hw * 0.65F, 0.0F, -0.002F).color(backGold);
    }
}

