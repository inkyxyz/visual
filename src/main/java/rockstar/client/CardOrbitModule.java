package rockstar.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import pyrock.events.render.Render3DEvent;

@ModuleInfo(
    name = "CardOrbit",
    category = ModuleCategory.PLAYER,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.card_orbit"
)
public class CardOrbitModule extends Module {

    private ModeSetting shapeMode;
    private ModeSetting.Nested1_42765c60 modeRing;
    private ModeSetting.Nested1_42765c60 modeShield;
    private ModeSetting.Nested1_42765c60 modeHelix;
    private ModeSetting.Nested1_42765c60 modePokerFan;

    private ModeSetting deckStyle;
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

    private SliderSetting countSetting;
    private SliderSetting radiusSetting;
    private SliderSetting speedSetting;
    private SliderSetting bobSetting;
    private SliderSetting scaleSetting;
    private BooleanSetting spinCardsSetting;
    private BooleanSetting cardGlowSetting;
    private SliderSetting glowIntensity;
    private SliderSetting glowSpread;

    private final IiIIIiII_Class69<Render3DEvent> renderEvent = this::onRender3D;

    public CardOrbitModule() {
        this.shapeMode = new ModeSetting(this, "Orbit Shape");
        this.modeRing = new ModeSetting.Nested1_42765c60(this.shapeMode, "Ring of Fortune").select();
        this.modeShield = new ModeSetting.Nested1_42765c60(this.shapeMode, "Gambit Shield");
        this.modeHelix = new ModeSetting.Nested1_42765c60(this.shapeMode, "Dual Helix");
        this.modePokerFan = new ModeSetting.Nested1_42765c60(this.shapeMode, "Twisted Fan");

        this.deckStyle = new ModeSetting(this, "Card Deck");
        this.deckUnoCards = new ModeSetting.Nested1_42765c60(this.deckStyle, "Uno Cards");
        this.deckClassicPoker = new ModeSetting.Nested1_42765c60(this.deckStyle, "Classic Poker").select();
        this.deckRoyalFlush = new ModeSetting.Nested1_42765c60(this.deckStyle, "Royal Flush");
        this.deckAcesOnly = new ModeSetting.Nested1_42765c60(this.deckStyle, "Aces Only");
        this.deckCourtCards = new ModeSetting.Nested1_42765c60(this.deckStyle, "Court Cards");
        this.deckJokersWild = new ModeSetting.Nested1_42765c60(this.deckStyle, "Jokers Wild");

        this.cardBackSetting = new ModeSetting(this, "Card Back");
        this.backMeshRed = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Classic Mesh (Red)").select();
        this.backMeshBlue = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Classic Mesh (Blue)");
        this.backUno = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Uno Classic");
        this.backBicycle = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Bicycle Classic");
        this.backRoyalGold = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Royal Gold");
        this.backCyberNeon = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Cyber Neon");
        this.backDarkArcane = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Dark Arcane");

        this.countSetting = new SliderSetting(this, "Card Count")
            .I_method_c8c9a7d7(3.0F).i_method_65e2aff7(16.0F).II_method_b0f56334(1.0F).Ii_method_4e0e6b54(6.0F);

        this.radiusSetting = new SliderSetting(this, "Orbit Radius")
            .I_method_c8c9a7d7(0.8F).i_method_65e2aff7(3.2F).II_method_b0f56334(0.1F).Ii_method_4e0e6b54(1.4F);

        this.speedSetting = new SliderSetting(this, "Orbit Speed")
            .I_method_c8c9a7d7(0.2F).i_method_65e2aff7(3.5F).II_method_b0f56334(0.1F).Ii_method_4e0e6b54(1.2F);

        this.bobSetting = new SliderSetting(this, "Vertical Bob")
            .I_method_c8c9a7d7(0.0F).i_method_65e2aff7(0.8F).II_method_b0f56334(0.05F).Ii_method_4e0e6b54(0.25F);

        this.scaleSetting = new SliderSetting(this, "Card Scale")
            .I_method_c8c9a7d7(0.4F).i_method_65e2aff7(2.0F).II_method_b0f56334(0.05F).Ii_method_4e0e6b54(0.85F);

        this.spinCardsSetting = new BooleanSetting(this, "Spin Cards").I_method_decd82b5();
        this.cardGlowSetting = new BooleanSetting(this, "Card Glow").I_method_decd82b5();
        this.glowIntensity = new SliderSetting(this, "Glow Intensity")
            .I_method_c8c9a7d7(0.2F).i_method_65e2aff7(2.0F).II_method_b0f56334(0.05F).Ii_method_4e0e6b54(1.0F);
        this.glowSpread = new SliderSetting(this, "Glow Radius")
            .I_method_c8c9a7d7(0.1F).i_method_65e2aff7(0.6F).II_method_b0f56334(0.05F).Ii_method_4e0e6b54(0.25F);
    }

    private Identifier[] getActiveDeck() {
        if (this.deckStyle != null) {
            if (this.deckStyle.isSelected("Uno Cards")) return CardRenderHelper.UNO_CARDS;
            if (this.deckStyle.isSelected("Royal Flush")) return CardRenderHelper.ROYAL_FLUSH_CARDS;
            if (this.deckStyle.isSelected("Aces Only")) return CardRenderHelper.ACES;
            if (this.deckStyle.isSelected("Court Cards")) return CardRenderHelper.COURT_CARDS;
            if (this.deckStyle.isSelected("Jokers Wild")) return CardRenderHelper.JOKERS;
            if (this.deckStyle.isSelected("Classic Poker")) return CardRenderHelper.ALL_CARDS;
            if (this.deckStyle.i_method_f85f3850() != null) {
                return CardRenderHelper.getDeckCards(this.deckStyle.i_method_f85f3850().getName());
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

    private void onRender3D(Render3DEvent event) {
        MinecraftClient mc = MinecraftClient.getInstance();
        ClientPlayerEntity player = mc.player;
        if (player == null || mc.world == null) return;
        if (mc.options.getPerspective().isFirstPerson()) return;

        float td = mc.getRenderTickCounter().getTickDelta(false);
        Vec3d cam = mc.gameRenderer.getCamera().getPos();
        double px = MathHelper.lerp(td, player.prevX, player.getX());
        double py = MathHelper.lerp(td, player.prevY, player.getY());
        double pz = MathHelper.lerp(td, player.prevZ, player.getZ());
        float bodyYaw = MathHelper.lerp(td, player.prevBodyYaw, player.bodyYaw);

        double ix = px - cam.x;
        double iy = py - cam.y;
        double iz = pz - cam.z;

        float speed = this.speedSetting.Ii_method_a20abcd2();
        float radius = this.radiusSetting.Ii_method_a20abcd2();
        float cardScale = this.scaleSetting.Ii_method_a20abcd2();
        float bobAmt = this.bobSetting.Ii_method_a20abcd2();
        int cardCount = Math.max(2, (int) this.countSetting.Ii_method_a20abcd2());
        boolean spin = this.spinCardsSetting.i_method_9b12da03();

        long now = System.currentTimeMillis();
        float time = (now % 1000000L) * 0.002F * speed;

        Identifier[] deck = getActiveDeck();
        Identifier back = getActiveBack();
        boolean oldGlow = CardRenderHelper.globalCardGlow;
        float oldAlpha = CardRenderHelper.globalGlowAlpha;
        float oldSpread = CardRenderHelper.globalGlowSpread;
        CardRenderHelper.globalCardGlow = this.cardGlowSetting != null && this.cardGlowSetting.i_method_9b12da03();
        if (this.glowIntensity != null) CardRenderHelper.globalGlowAlpha = this.glowIntensity.Ii_method_a20abcd2();
        if (this.glowSpread != null) CardRenderHelper.globalGlowSpread = this.glowSpread.Ii_method_a20abcd2();

        MatrixStack m = event.getMatrices();
        m.push();
        m.translate(ix, iy, iz);

        if (this.modeRing.isSelected()) {
            float waistY = player.getHeight() * 0.50F;
            for (int i = 0; i < cardCount; i++) {
                double angle = time + (i * 2.0 * Math.PI / cardCount);
                float cx = (float)(Math.cos(angle) * radius);
                float cz = (float)(Math.sin(angle) * radius);
                float cy = waistY + (float)Math.sin(time * 2.5 + i * 1.5) * bobAmt;

                m.push();
                m.translate(cx, cy, cz);
                float cardYaw = (float)Math.toDegrees(-angle) + 90.0F;
                m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(cardYaw));
                if (spin) {
                    m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees((float)Math.sin(time * 3.0 + i) * 15.0F));
                }
                CardRenderHelper.renderCard(m, 0.42F * cardScale, 0.60F * cardScale, deck[i % deck.length], back, 1.0F, true);
                m.pop();
            }

        } else if (this.modeShield.isSelected()) {
            float torsoY = player.getHeight() * 0.55F;
            for (int i = 0; i < cardCount; i++) {
                // Spherical orbit
                double u = (double) i / cardCount;
                double phi = Math.acos(2.0 * u - 1.0) - Math.PI / 2.0;
                double theta = time * 0.8 + i * (Math.PI * (3.0 - Math.sqrt(5.0))); // Golden spiral

                float cx = (float)(Math.cos(theta) * Math.cos(phi) * radius);
                float cy = torsoY + (float)(Math.sin(phi) * (radius * 0.8F)) + (float)Math.sin(time * 2.0 + i) * (bobAmt * 0.5F);
                float cz = (float)(Math.sin(theta) * Math.cos(phi) * radius);

                m.push();
                m.translate(cx, cy, cz);
                float cardYaw = (float)Math.toDegrees(-theta) + 90.0F;
                m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(cardYaw));
                m.multiply(RotationAxis.POSITIVE_X.rotationDegrees((float)Math.toDegrees(phi) * 0.8F));
                if (spin) {
                    m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(time * 45.0F + i * 30.0F));
                }
                CardRenderHelper.renderCard(m, 0.38F * cardScale, 0.54F * cardScale, deck[i % deck.length], back, 1.0F, true);
                m.pop();
            }

        } else if (this.modeHelix.isSelected()) {
            float baseH = player.getHeight() * 0.15F;
            float maxH = player.getHeight() * 0.85F;
            int half = cardCount / 2;
            for (int strand = 0; strand < 2; strand++) {
                float strandOffset = strand * (float)Math.PI;
                for (int i = 0; i < half; i++) {
                    float prog = (float) i / Math.max(1, half - 1);
                    float curY = baseH + prog * (maxH - baseH);
                    double angle = time * (strand == 0 ? 1.0 : -1.0) + strandOffset + prog * Math.PI * 2.5;

                    float cx = (float)(Math.cos(angle) * radius);
                    float cz = (float)(Math.sin(angle) * radius);

                    m.push();
                    m.translate(cx, curY, cz);
                    float cardYaw = (float)Math.toDegrees(-angle) + 90.0F;
                    m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(cardYaw));
                    m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(strand == 0 ? 18.0F : -18.0F));
                    CardRenderHelper.renderCard(m, 0.36F * cardScale, 0.52F * cardScale, deck[(strand * half + i) % deck.length], back, 1.0F, true);
                    m.pop();
                }
            }

        } else if (this.modePokerFan.isSelected()) {
            // Twisted Fate Fanned Hand floating above head
            float headY = player.getHeight() * 1.05F + (float)Math.sin(time * 2.0) * bobAmt;
            m.translate(0.0, headY, 0.0);
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-bodyYaw + 180.0F));

            int fanCards = Math.min(7, cardCount);
            float spread = 70.0F;
            float step = fanCards > 1 ? spread / (fanCards - 1) : 0;
            float startAngle = -spread / 2.0F;

            for (int i = 0; i < fanCards; i++) {
                float ang = startAngle + i * step;
                m.push();
                m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-ang));
                m.translate(0.0, 0.45 * radius, (i - fanCards / 2.0F) * 0.015);
                m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(12.0F));
                CardRenderHelper.renderCard(m, 0.40F * cardScale, 0.58F * cardScale, deck[i % deck.length], back, 1.0F, true);
                m.pop();
            }
        }

        m.pop();
        CardRenderHelper.globalGlowAlpha = oldAlpha;
        CardRenderHelper.globalGlowSpread = oldSpread;
        CardRenderHelper.globalCardGlow = oldGlow;
    }
}
