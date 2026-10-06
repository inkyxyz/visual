package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import pyrock.events.game.WorldChangeEvent;
import pyrock.events.render.Render3DEvent;

@ModuleInfo(
    name = "CardTrail",
    category = ModuleCategory.VISUALS,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.card_trail"
)
public class CardTrailModule extends Module {

    private SliderSetting densitySetting;
    private SliderSetting lifetimeSetting;
    private SliderSetting scaleSetting;
    private BooleanSetting flutterSetting;
    private BooleanSetting sprintOnlySetting;

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

    private static class TrailCard {
        double x, y, z;
        float baseYaw, basePitch, baseRoll;
        float tumbleYaw, tumblePitch, tumbleRoll;
        float flutterPhase;
        Identifier front;
        Identifier back;
        long spawnTime;
        long duration;

        TrailCard(double x, double y, double z, float yaw, Identifier front, Identifier back, long duration) {
            this.x = x;
            this.y = y;
            this.z = z;
            // 50% spawn facing backward towards camera, 50% forward + natural angle variance
            float facing = (Math.random() < 0.5) ? 180.0F : 0.0F;
            this.baseYaw = yaw + facing + (float)((Math.random() - 0.5) * 45.0);
            this.basePitch = (float)((Math.random() - 0.5) * 30.0);
            this.baseRoll = (float)((Math.random() - 0.5) * 30.0);
            // Dynamic tumble velocities so cards spin and flip gracefully in 3D
            this.tumbleYaw = (float)((Math.random() - 0.5) * 110.0);
            this.tumblePitch = (float)((Math.random() - 0.5) * 85.0);
            this.tumbleRoll = (float)((Math.random() - 0.5) * 85.0);
            this.flutterPhase = (float)(Math.random() * Math.PI * 2.0);
            this.front = front;
            this.back = back;
            this.duration = duration;
            this.spawnTime = System.currentTimeMillis();
        }

        boolean update(float dt, boolean flutter) {
            long elapsed = System.currentTimeMillis() - spawnTime;
            if (elapsed > duration) return false;

            // Gentle slow fall like paper in air
            y -= 0.35 * dt;

            // 3D tumble rotation
            baseYaw += tumbleYaw * dt;
            basePitch += tumblePitch * dt;
            baseRoll += tumbleRoll * dt;

            if (flutter) {
                float timeSec = elapsed * 0.001F;
                x += Math.sin(timeSec * 5.0 + flutterPhase) * 0.25 * dt;
                z += Math.cos(timeSec * 4.5 + flutterPhase) * 0.25 * dt;
                baseRoll += Math.cos(timeSec * 6.0) * 18.0F * dt;
            }
            return true;
        }

        float getAlpha() {
            long elapsed = System.currentTimeMillis() - spawnTime;
            float life = 1.0F - (float) elapsed / duration;
            return Math.max(0.0F, Math.min(1.0F, life));
        }
    }

    private final List<TrailCard> trailCards = new ArrayList<>();
    private Vec3d lastSpawnPos = null;
    private long lastFrameTime = 0;

    private final IiIIIiII_Class69<Render3DEvent> onRender = this::onRender3D;
    private final IiIIIiII_Class69<WorldChangeEvent> onWorld = e -> this.trailCards.clear();

    public CardTrailModule() {
        this.densitySetting = new SliderSetting(this, "Spawn Rate")
            .I_method_c8c9a7d7(0.2F).i_method_65e2aff7(2.0F).II_method_b0f56334(0.1F).Ii_method_4e0e6b54(1.0F);

        this.lifetimeSetting = new SliderSetting(this, "Lifetime (s)")
            .I_method_c8c9a7d7(0.5F).i_method_65e2aff7(4.0F).II_method_b0f56334(0.1F).Ii_method_4e0e6b54(1.6F);

        this.scaleSetting = new SliderSetting(this, "Card Scale")
            .I_method_c8c9a7d7(0.3F).i_method_65e2aff7(1.5F).II_method_b0f56334(0.05F).Ii_method_4e0e6b54(0.60F);

        this.flutterSetting = new BooleanSetting(this, "Flutter Physics").I_method_decd82b5();
        this.sprintOnlySetting = new BooleanSetting(this, "Only Sprinting");

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

    private void onRender3D(Render3DEvent event) {
        MinecraftClient mc = MinecraftClient.getInstance();
        ClientPlayerEntity player = mc.player;
        if (player == null || mc.world == null) {
            this.trailCards.clear();
            return;
        }

        long now = System.currentTimeMillis();
        if (lastFrameTime == 0) lastFrameTime = now;
        float dt = Math.min(0.1F, (now - lastFrameTime) * 0.001F);
        lastFrameTime = now;

        Vec3d pPos = player.getPos().add(0, 0.45, 0);
        boolean sprinting = player.isSprinting();
        // Do not spawn during jumps or while airborne
        boolean onGround = player.isOnGround();
        boolean notJumping = onGround && Math.abs(player.getVelocity().y) < 0.15;
        boolean allowSpawn = (!this.sprintOnlySetting.i_method_9b12da03() || sprinting) && notJumping;

        if (allowSpawn) {
            double reqDist = 0.55 / Math.max(0.1, this.densitySetting.Ii_method_a20abcd2());
            if (lastSpawnPos == null || lastSpawnPos.distanceTo(pPos) >= reqDist) {
                lastSpawnPos = pPos;
                long dur = (long)(this.lifetimeSetting.Ii_method_a20abcd2() * 1000L);
                Identifier[] deck = getActiveDeck();
                Identifier card = deck[(int)(Math.random() * deck.length)];
                Identifier back = getActiveBack();

                // Spawn 1.8 blocks behind player so they don't appear in face/camera
                double rad = Math.toRadians(player.getYaw());
                double behindDist = 1.8;
                double spawnX = pPos.x + Math.sin(rad) * behindDist + (Math.random() - 0.5) * 0.25;
                double spawnY = pPos.y + (Math.random() - 0.5) * 0.15;
                double spawnZ = pPos.z - Math.cos(rad) * behindDist + (Math.random() - 0.5) * 0.25;

                trailCards.add(new TrailCard(
                    spawnX, spawnY, spawnZ,
                    player.getYaw(),
                    card, back, dur
                ));

                if (trailCards.size() > 90) {
                    trailCards.subList(0, trailCards.size() - 90).clear();
                }
            }
        }

        if (this.trailCards.isEmpty()) return;

        Vec3d cam = mc.gameRenderer.getCamera().getPos();
        float cardScale = this.scaleSetting.Ii_method_a20abcd2();
        boolean flutter = this.flutterSetting.i_method_9b12da03();
        boolean firstPerson = mc.options.getPerspective().isFirstPerson();
        MatrixStack m = event.getMatrices();

        List<TrailCard> alive = new ArrayList<>();
        for (TrailCard tc : this.trailCards) {
            if (tc.update(dt, flutter)) {
                alive.add(tc);
                float alpha = tc.getAlpha();
                if (alpha <= 0.01F) continue;

                // First person safe distance: never render cards closer than 2.2 blocks to camera
                if (firstPerson) {
                    double distSq = cam.squaredDistanceTo(tc.x, tc.y, tc.z);
                    if (distSq < 4.84) continue;
                }

                m.push();
                m.translate(tc.x - cam.x, tc.y - cam.y, tc.z - cam.z);
                m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(tc.baseYaw));
                m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(tc.basePitch));
                m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(tc.baseRoll));

                CardRenderHelper.renderCard(m, 0.36F * cardScale, 0.50F * cardScale, tc.front, tc.back, alpha, true);
                m.pop();
            }
        }
        this.trailCards.clear();
        this.trailCards.addAll(alive);
    }
}
