package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import pyrock.events.game.AfterAttackEvent;
import pyrock.events.game.AttackEvent;
import pyrock.events.game.PostAttackEvent;
import pyrock.events.game.WorldChangeEvent;
import pyrock.events.render.Render3DEvent;

@ModuleInfo(
    name = "CardHitEffect",
    category = ModuleCategory.VISUALS,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.card_hit_effect"
)
public class CardHitEffectModule extends Module {

    private SliderSetting cardCountSetting;
    private SliderSetting burstForceSetting;
    private SliderSetting gravitySetting;
    private SliderSetting cardScaleSetting;
    private SliderSetting lifetimeSetting;
    private BooleanSetting cardGlowSetting;

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

    private static class CardPhysicsParticle {
        double x, y, z;
        double vx, vy, vz;
        float pitch, yaw, roll;
        float dPitch, dYaw, dRoll;
        Identifier front;
        Identifier back;
        long spawnTime;
        long duration;

        CardPhysicsParticle(double x, double y, double z, double vx, double vy, double vz,
                            Identifier front, Identifier back, long duration) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.vx = vx;
            this.vy = vy;
            this.vz = vz;
            this.front = front;
            this.back = back;
            this.duration = duration;
            this.spawnTime = System.currentTimeMillis();
            this.pitch = (float)(Math.random() * 360.0);
            this.yaw = (float)(Math.random() * 360.0);
            this.roll = (float)(Math.random() * 360.0);
            this.dPitch = (float)((Math.random() - 0.5) * 480.0);
            this.dYaw = (float)((Math.random() - 0.5) * 540.0);
            this.dRoll = (float)((Math.random() - 0.5) * 360.0);
        }

        boolean update(float dt, double gravity) {
            long elapsed = System.currentTimeMillis() - spawnTime;
            if (elapsed > duration) return false;

            x += vx * dt;
            y += vy * dt;
            z += vz * dt;

            // Air friction & gravity
            vx *= (1.0 - 0.4 * dt);
            vz *= (1.0 - 0.4 * dt);
            vy -= gravity * 4.5 * dt;

            pitch += dPitch * dt;
            yaw += dYaw * dt;
            roll += dRoll * dt;

            return true;
        }

        float getAlpha() {
            long elapsed = System.currentTimeMillis() - spawnTime;
            float life = 1.0F - (float) elapsed / duration;
            return Math.max(0.0F, Math.min(1.0F, life));
        }
    }

    private final List<CardPhysicsParticle> activeCards = new ArrayList<>();
    private long lastFrameTime = 0;
    private long lastHitTime = 0;

    private final IiIIIiII_Class69<AfterAttackEvent> afterAttack = e -> this.spawnHitCards(e.getEntity());
    private final IiIIIiII_Class69<PostAttackEvent> postAttack = e -> this.spawnHitCards(e.getEntity());
    private final IiIIIiII_Class69<AttackEvent> onAttack = e -> this.spawnHitCards(e.getEntity());
    private final IiIIIiII_Class69<WorldChangeEvent> onWorld = e -> this.activeCards.clear();
    private final IiIIIiII_Class69<Render3DEvent> onRender = this::onRender3D;

    public CardHitEffectModule() {
        this.cardCountSetting = new SliderSetting(this, "Burst Count")
            .I_method_c8c9a7d7(3.0F).i_method_65e2aff7(20.0F).II_method_b0f56334(1.0F).Ii_method_4e0e6b54(8.0F);

        this.burstForceSetting = new SliderSetting(this, "Explosion Force")
            .I_method_c8c9a7d7(0.5F).i_method_65e2aff7(3.0F).II_method_b0f56334(0.1F).Ii_method_4e0e6b54(1.3F);

        this.gravitySetting = new SliderSetting(this, "Gravity")
            .I_method_c8c9a7d7(0.2F).i_method_65e2aff7(2.5F).II_method_b0f56334(0.1F).Ii_method_4e0e6b54(0.8F);

        this.cardScaleSetting = new SliderSetting(this, "Card Scale")
            .I_method_c8c9a7d7(0.3F).i_method_65e2aff7(1.8F).II_method_b0f56334(0.05F).Ii_method_4e0e6b54(0.65F);

        this.lifetimeSetting = new SliderSetting(this, "Lifetime (s)")
            .I_method_c8c9a7d7(0.5F).i_method_65e2aff7(3.0F).II_method_b0f56334(0.1F).Ii_method_4e0e6b54(1.2F);
        this.cardGlowSetting = new BooleanSetting(this, "Card Glow").I_method_decd82b5();

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

    private void spawnHitCards(Entity target) {
        if (target == null || !(target instanceof LivingEntity)) return;
        long now = System.currentTimeMillis();
        // Cooldown between multi-events on single attack
        if (now - lastHitTime < 50L) return;
        lastHitTime = now;

        Vec3d origin = target.getPos().add(0, target.getHeight() * 0.55, 0);
        int count = (int) this.cardCountSetting.Ii_method_a20abcd2();
        float force = this.burstForceSetting.Ii_method_a20abcd2();
        long dur = (long)(this.lifetimeSetting.Ii_method_a20abcd2() * 1000L);

        Identifier[] deck = getActiveDeck();
        Identifier back = getActiveBack();

        for (int i = 0; i < count; i++) {
            double angle = (2.0 * Math.PI * i / count) + (Math.random() - 0.5) * 0.5;
            double speedH = (0.6 + Math.random() * 0.8) * force;
            double vx = Math.cos(angle) * speedH;
            double vz = Math.sin(angle) * speedH;
            double vy = (0.8 + Math.random() * 1.2) * force;

            Identifier card = deck[(int)(Math.random() * deck.length)];
            activeCards.add(new CardPhysicsParticle(origin.x, origin.y, origin.z, vx, vy, vz, card, back, dur));
        }

        // Cap list size
        if (activeCards.size() > 120) {
            activeCards.subList(0, activeCards.size() - 120).clear();
        }
    }

    private void onRender3D(Render3DEvent event) {
        if (this.activeCards.isEmpty()) return;

        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.world == null) {
            this.activeCards.clear();
            return;
        }

        long now = System.currentTimeMillis();
        if (lastFrameTime == 0) lastFrameTime = now;
        float dt = Math.min(0.1F, (now - lastFrameTime) * 0.001F);
        lastFrameTime = now;

        Vec3d cam = mc.gameRenderer.getCamera().getPos();
        double gravity = this.gravitySetting.Ii_method_a20abcd2();
        float cardScale = this.cardScaleSetting.Ii_method_a20abcd2();
        MatrixStack m = event.getMatrices();

        List<CardPhysicsParticle> alive = new ArrayList<>();
        for (CardPhysicsParticle card : this.activeCards) {
            if (card.update(dt, gravity)) {
                alive.add(card);
                float alpha = card.getAlpha();
                if (alpha <= 0.01F) continue;

                m.push();
                m.translate(card.x - cam.x, card.y - cam.y, card.z - cam.z);
                m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(card.yaw));
                m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(card.pitch));
                m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(card.roll));

                boolean glow = this.cardGlowSetting != null && this.cardGlowSetting.i_method_9b12da03();
                CardRenderHelper.renderCard(m, 0.38F * cardScale, 0.54F * cardScale, card.front, card.back, alpha, true, glow, null);
                m.pop();
            }
        }
        this.activeCards.clear();
        this.activeCards.addAll(alive);
    }
}
