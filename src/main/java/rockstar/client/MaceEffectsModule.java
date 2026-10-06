package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
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
    name = "Mace Effects",
    category = ModuleCategory.VISUALS,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.mace_effects"
)
public class MaceEffectsModule extends Module {

    private static final Random RANDOM = new Random();

    static class RockDebris {
        double x, y, z;
        double vx, vy, vz;
        float pitch, yaw, roll;
        float vPitch, vYaw, vRoll;
        float size;
        int color;
        double groundY;

        RockDebris(double x, double y, double z, double vx, double vy, double vz, float size, int color, double groundY) {
            this.x = x; this.y = y; this.z = z;
            this.vx = vx; this.vy = vy; this.vz = vz;
            this.size = size;
            this.color = color;
            this.groundY = groundY;
            this.pitch = RANDOM.nextFloat() * 360.0F;
            this.yaw = RANDOM.nextFloat() * 360.0F;
            this.roll = RANDOM.nextFloat() * 360.0F;
            this.vPitch = (RANDOM.nextFloat() - 0.5F) * 35.0F;
            this.vYaw = (RANDOM.nextFloat() - 0.5F) * 35.0F;
            this.vRoll = (RANDOM.nextFloat() - 0.5F) * 35.0F;
        }

        void update() {
            if (this.y > this.groundY + 0.05 || this.vy > 0) {
                this.x += this.vx;
                this.y += this.vy;
                this.z += this.vz;
                this.vy -= 0.035;
                this.vx *= 0.94;
                this.vz *= 0.94;
                this.pitch += this.vPitch;
                this.yaw += this.vYaw;
                this.roll += this.vRoll;
            } else {
                this.y = this.groundY + 0.02;
                if (Math.abs(this.vy) > 0.08) {
                    this.vy = -this.vy * 0.35;
                } else {
                    this.vy = 0;
                    this.vx *= 0.7;
                    this.vz *= 0.7;
                    this.vPitch *= 0.7;
                    this.vYaw *= 0.7;
                    this.vRoll *= 0.7;
                }
            }
        }
    }

    static class FissureImpact {
        final Vec3d center;
        final long startTime;
        final float maxRadius;
        final ColorRGBA riftColor;
        final String pattern;
        final List<Vec3d[]> fractureLines = new ArrayList<>();
        final List<RockDebris> debrisList = new ArrayList<>();

        FissureImpact(Vec3d center, float maxRadius, int debrisCount, ColorRGBA riftColor, String pattern) {
            this.center = center;
            this.startTime = System.currentTimeMillis();
            this.maxRadius = maxRadius;
            this.riftColor = riftColor;
            this.pattern = pattern;

            this.generateFractures(pattern, maxRadius);
            this.spawnDebris(debrisCount);
        }

        private void generateFractures(String pattern, float maxRadius) {
            switch (pattern) {
                case "Celestial Nova" -> generateCelestialNova(maxRadius);
                case "Spiral Vortex" -> generateSpiralVortex(maxRadius);
                case "Runic Sigil" -> generateRunicSigil(maxRadius);
                case "Chaotic Cracks" -> generateChaoticCracks(maxRadius);
                case "Hexagonal Fracture" -> generateHexagonalFractures(maxRadius);
                case "Star Blast" -> generateStarBlast(maxRadius);
                case "Seismic Chasm" -> generateSeismicChasm(maxRadius);
                default -> generateRadialWeb(maxRadius);
            }
        }

        // 1. Radial Web: Concentric polygon rings + spoke fractures
        private void generateRadialWeb(float maxRadius) {
            int spokes = 10;
            double spokeAngleStep = (Math.PI * 2.0) / spokes;
            Vec3d[][] ringNodes = new Vec3d[3][spokes];
            float[] ringDistRatios = {0.35F, 0.68F, 1.0F};

            for (int s = 0; s < spokes; s++) {
                double baseAng = s * spokeAngleStep;
                Vec3d prev = center;
                for (int r = 0; r < 3; r++) {
                    double ang = baseAng + (RANDOM.nextDouble() - 0.5) * 0.18;
                    double dist = maxRadius * ringDistRatios[r] * (0.85 + RANDOM.nextDouble() * 0.3);
                    Vec3d node = center.add(Math.cos(ang) * dist, 0.02, Math.sin(ang) * dist);
                    fractureLines.add(new Vec3d[]{prev, node});
                    ringNodes[r][s] = node;
                    prev = node;
                }
            }
            for (int r = 0; r < 3; r++) {
                for (int s = 0; s < spokes; s++) {
                    Vec3d p1 = ringNodes[r][s];
                    Vec3d p2 = ringNodes[r][(s + 1) % spokes];
                    if (p1 != null && p2 != null) {
                        fractureLines.add(new Vec3d[]{p1, p2});
                    }
                }
            }
        }

        // 2. Chaotic Cracks
        private void generateChaoticCracks(float maxRadius) {
            int mainBranches = 7 + RANDOM.nextInt(3);
            double baseStep = (Math.PI * 2.0) / mainBranches;

            for (int b = 0; b < mainBranches; b++) {
                double ang = b * baseStep + (RANDOM.nextDouble() - 0.5) * 0.4;
                float branchLen = maxRadius * (0.75F + RANDOM.nextFloat() * 0.35F);
                int segs = 6 + RANDOM.nextInt(3);
                Vec3d prev = center;

                for (int s = 1; s <= segs; s++) {
                    float prog = (float) s / segs;
                    ang += (RANDOM.nextDouble() - 0.5) * 0.35;
                    double dist = branchLen * prog;
                    Vec3d next = center.add(Math.cos(ang) * dist, 0.02, Math.sin(ang) * dist);
                    fractureLines.add(new Vec3d[]{prev, next});

                    if (s == 3 && RANDOM.nextBoolean()) {
                        double subAng = ang + (RANDOM.nextBoolean() ? 0.65 : -0.65);
                        Vec3d subPrev = next;
                        for (int sub = 1; sub <= 3; sub++) {
                            double subDist = (branchLen * 0.35F) * ((float) sub / 3.0F);
                            Vec3d subNext = next.add(Math.cos(subAng) * subDist, 0.0, Math.sin(subAng) * subDist);
                            fractureLines.add(new Vec3d[]{subPrev, subNext});
                            subPrev = subNext;
                        }
                    }
                    prev = next;
                }
            }
        }

        // 3. Hexagonal Fracture
        private void generateHexagonalFractures(float maxRadius) {
            Vec3d[] innerHex = new Vec3d[6];
            float innerR = maxRadius * 0.42F;
            for (int i = 0; i < 6; i++) {
                double a = i * (Math.PI / 3.0) + 0.1;
                innerHex[i] = center.add(Math.cos(a) * innerR, 0.02, Math.sin(a) * innerR);
                fractureLines.add(new Vec3d[]{center, innerHex[i]});
            }
            for (int i = 0; i < 6; i++) {
                fractureLines.add(new Vec3d[]{innerHex[i], innerHex[(i + 1) % 6]});
            }
            for (int i = 0; i < 6; i++) {
                double a1 = i * (Math.PI / 3.0);
                double a2 = (i + 1) * (Math.PI / 3.0);
                double midAng = (a1 + a2) * 0.5;

                Vec3d outer1 = center.add(Math.cos(a1) * maxRadius, 0.02, Math.sin(a1) * maxRadius);
                Vec3d outer2 = center.add(Math.cos(midAng) * maxRadius * 0.95, 0.02, Math.sin(midAng) * maxRadius * 0.95);
                Vec3d outer3 = center.add(Math.cos(a2) * maxRadius, 0.02, Math.sin(a2) * maxRadius);

                fractureLines.add(new Vec3d[]{innerHex[i], outer1});
                fractureLines.add(new Vec3d[]{innerHex[i], outer2});
                fractureLines.add(new Vec3d[]{outer1, outer2});
                fractureLines.add(new Vec3d[]{outer2, outer3});
            }
        }

        // 4. Star Blast
        private void generateStarBlast(float maxRadius) {
            int rays = 8;
            double step = (Math.PI * 2.0) / rays;
            Vec3d[] rayTips = new Vec3d[rays];
            Vec3d[] innerMids = new Vec3d[rays];

            for (int i = 0; i < rays; i++) {
                double a = i * step;
                float rLen = (i % 2 == 0) ? maxRadius : (maxRadius * 0.65F);
                Vec3d tip = center.add(Math.cos(a) * rLen, 0.02, Math.sin(a) * rLen);
                rayTips[i] = tip;
                fractureLines.add(new Vec3d[]{center, tip});

                double midA = a + (step * 0.5);
                double midR = maxRadius * 0.38;
                innerMids[i] = center.add(Math.cos(midA) * midR, 0.02, Math.sin(midA) * midR);
                fractureLines.add(new Vec3d[]{center, innerMids[i]});
            }

            for (int i = 0; i < rays; i++) {
                fractureLines.add(new Vec3d[]{rayTips[i], innerMids[i]});
                fractureLines.add(new Vec3d[]{innerMids[i], rayTips[(i + 1) % rays]});
            }
        }

        // 5. Seismic Chasm
        private void generateSeismicChasm(float maxRadius) {
            double chasmAngle = RANDOM.nextDouble() * Math.PI;
            double cos = Math.cos(chasmAngle);
            double sin = Math.sin(chasmAngle);
            double perpCos = -sin;
            double perpSin = cos;

            int chasmSegs = 12;
            Vec3d prev = center.add(-cos * maxRadius * 1.25, 0.02, -sin * maxRadius * 1.25);

            for (int i = 1; i <= chasmSegs; i++) {
                double prog = -1.25 + (2.5 * i / chasmSegs);
                double jitterPerp = (RANDOM.nextDouble() - 0.5) * 0.25;
                Vec3d next = center.add(cos * (maxRadius * prog) + perpCos * jitterPerp, 0.02, sin * (maxRadius * prog) + perpSin * jitterPerp);
                fractureLines.add(new Vec3d[]{prev, next});

                if (i % 2 == 0) {
                    double sideDir = (i % 4 == 0) ? 1.0 : -1.0;
                    float ribLen = maxRadius * (0.35F + RANDOM.nextFloat() * 0.4F);
                    Vec3d ribEnd = next.add(perpCos * ribLen * sideDir, 0.0, perpSin * ribLen * sideDir);
                    fractureLines.add(new Vec3d[]{next, ribEnd});
                }
                prev = next;
            }
        }

        // 6. [NEW] Celestial Nova: 12-star rays + double orbital shock rings + radiating flares
        private void generateCelestialNova(float maxRadius) {
            int rays = 12;
            double step = (Math.PI * 2.0) / rays;
            Vec3d[] innerRing = new Vec3d[rays];
            Vec3d[] outerRing = new Vec3d[rays];

            for (int i = 0; i < rays; i++) {
                double a = i * step;
                float rInner = maxRadius * 0.32F;
                float rOuter = maxRadius * 0.75F;
                innerRing[i] = center.add(Math.cos(a) * rInner, 0.02, Math.sin(a) * rInner);
                outerRing[i] = center.add(Math.cos(a) * rOuter, 0.02, Math.sin(a) * rOuter);

                fractureLines.add(new Vec3d[]{center, innerRing[i]});
                fractureLines.add(new Vec3d[]{innerRing[i], outerRing[i]});

                // Long primary solar flare
                if (i % 2 == 0) {
                    Vec3d flareTip = center.add(Math.cos(a) * maxRadius * 1.15F, 0.02, Math.sin(a) * maxRadius * 1.15F);
                    fractureLines.add(new Vec3d[]{outerRing[i], flareTip});
                }
            }

            for (int i = 0; i < rays; i++) {
                int next = (i + 1) % rays;
                fractureLines.add(new Vec3d[]{innerRing[i], innerRing[next]});
                fractureLines.add(new Vec3d[]{outerRing[i], outerRing[next]});
                fractureLines.add(new Vec3d[]{innerRing[i], outerRing[next]});
            }
        }

        // 7. [NEW] Spiral Vortex: Dual counter-winding logarithmic spirals with tectonic interconnects
        private void generateSpiralVortex(float maxRadius) {
            int arms = 3;
            int segsPerArm = 18;
            double turns = 1.35 * Math.PI * 2.0;

            for (int a = 0; a < arms; a++) {
                double armOffset = a * (Math.PI * 2.0 / arms);
                Vec3d prev = center;
                for (int s = 1; s <= segsPerArm; s++) {
                    double t = (double)s / segsPerArm;
                    double dist = Math.pow(t, 0.85) * maxRadius;
                    double ang = armOffset + t * turns;
                    Vec3d next = center.add(Math.cos(ang) * dist, 0.02, Math.sin(ang) * dist);
                    fractureLines.add(new Vec3d[]{prev, next});

                    // Rib fracture branching inward
                    if (s % 3 == 0) {
                        double ribAng = ang + Math.PI * 0.55;
                        double ribDist = dist * 0.28;
                        Vec3d ribTip = next.add(Math.cos(ribAng) * ribDist, 0.0, Math.sin(ribAng) * ribDist);
                        fractureLines.add(new Vec3d[]{next, ribTip});
                    }
                    prev = next;
                }
            }
        }

        // 8. [NEW] Runic Sigil: Arcane pentagram star with outer sacred circle and mystic chords
        private void generateRunicSigil(float maxRadius) {
            int points = 5;
            double step = (Math.PI * 2.0) / points;
            Vec3d[] outerPoints = new Vec3d[points];
            Vec3d[] innerPoints = new Vec3d[points];

            for (int i = 0; i < points; i++) {
                double a = i * step - Math.PI * 0.5;
                outerPoints[i] = center.add(Math.cos(a) * maxRadius, 0.02, Math.sin(a) * maxRadius);
                double innerA = a + step * 0.5;
                double innerR = maxRadius * 0.40;
                innerPoints[i] = center.add(Math.cos(innerA) * innerR, 0.02, Math.sin(innerA) * innerR);
            }

            // Pentagram chords (0->2->4->1->3->0)
            for (int i = 0; i < points; i++) {
                fractureLines.add(new Vec3d[]{outerPoints[i], outerPoints[(i + 2) % points]});
                fractureLines.add(new Vec3d[]{outerPoints[i], center});
                fractureLines.add(new Vec3d[]{innerPoints[i], center});
            }

            // Inscribed outer ring segments
            int ringSegs = 20;
            for (int r = 0; r < ringSegs; r++) {
                double a1 = r * (Math.PI * 2.0 / ringSegs);
                double a2 = (r + 1) * (Math.PI * 2.0 / ringSegs);
                Vec3d p1 = center.add(Math.cos(a1) * maxRadius * 0.98, 0.02, Math.sin(a1) * maxRadius * 0.98);
                Vec3d p2 = center.add(Math.cos(a2) * maxRadius * 0.98, 0.02, Math.sin(a2) * maxRadius * 0.98);
                fractureLines.add(new Vec3d[]{p1, p2});
            }
        }

        private void spawnDebris(int count) {
            int[] stoneTints = {0xFF4A4A4A, 0xFF363636, 0xFF585858, 0xFF282828, 0xFF5E5448};
            for (int d = 0; d < count; d++) {
                double ang = RANDOM.nextDouble() * Math.PI * 2.0;
                double spd = 0.08 + RANDOM.nextDouble() * 0.20;
                double vx = Math.cos(ang) * spd;
                double vy = 0.22 + RANDOM.nextDouble() * 0.35;
                double vz = Math.sin(ang) * spd;
                float size = 0.045F + RANDOM.nextFloat() * 0.070F;
                int col = stoneTints[RANDOM.nextInt(stoneTints.length)];
                this.debrisList.add(new RockDebris(center.x, center.y + 0.1, center.z, vx, vy, vz, size, col, center.y));
            }
        }
    }

    private final List<FissureImpact> impacts = new CopyOnWriteArrayList<>();
    private long lastTriggerTime = 0L;

    private SliderSetting radiusSetting;
    private SliderSetting debrisCountSetting;
    private SliderSetting durationSetting;
    private BooleanSetting lavaGlowSetting;
    private BooleanSetting syncTheme;
    private ColorSetting riftColorSetting;

    // Pattern Settings: 8 Patterns
    private ModeSetting riftPatternSetting;
    private ModeSetting.Nested1_42765c60 patCelestialNova;
    private ModeSetting.Nested1_42765c60 patSpiralVortex;
    private ModeSetting.Nested1_42765c60 patRunicSigil;
    private ModeSetting.Nested1_42765c60 patRadialWeb;
    private ModeSetting.Nested1_42765c60 patChaoticCracks;
    private ModeSetting.Nested1_42765c60 patHexagonalFracture;
    private ModeSetting.Nested1_42765c60 patStarBlast;
    private ModeSetting.Nested1_42765c60 patSeismicChasm;

    private ModeSetting weaponFilter;
    private ModeSetting.Nested1_42765c60 filterAllWeapons;
    private ModeSetting.Nested1_42765c60 filterMaceOnly;

    private ModeSetting triggerMode;
    private ModeSetting.Nested1_42765c60 triggerEveryHit;
    private ModeSetting.Nested1_42765c60 triggerMaceSmashOnly;

    private BooleanSetting cancelVanillaSmash;

    private final IiIIIiII_Class69<AttackEvent> attackListener = e -> onHitEntity(e.getEntity());
    private final IiIIIiII_Class69<PostAttackEvent> postAttackListener = e -> onHitEntity(e.getEntity());
    private final IiIIIiII_Class69<AfterAttackEvent> afterAttackListener = e -> onHitEntity(e.getEntity());
    private final IiIIIiII_Class69<Render3DEvent> renderListener = this::onRender3D;
    private final IiIIIiII_Class69<WorldChangeEvent> worldChangeListener = var1 -> this.impacts.clear();

    public MaceEffectsModule() {
        this.initSettings();
    }

    private void initSettings() {
        this.riftPatternSetting = new ModeSetting(this, "Rift Pattern");
        this.patCelestialNova = new ModeSetting.Nested1_42765c60(this.riftPatternSetting, "Celestial Nova").select();
        this.patSpiralVortex = new ModeSetting.Nested1_42765c60(this.riftPatternSetting, "Spiral Vortex");
        this.patRunicSigil = new ModeSetting.Nested1_42765c60(this.riftPatternSetting, "Runic Sigil");
        this.patRadialWeb = new ModeSetting.Nested1_42765c60(this.riftPatternSetting, "Radial Web");
        this.patChaoticCracks = new ModeSetting.Nested1_42765c60(this.riftPatternSetting, "Chaotic Cracks");
        this.patHexagonalFracture = new ModeSetting.Nested1_42765c60(this.riftPatternSetting, "Hexagonal Fracture");
        this.patStarBlast = new ModeSetting.Nested1_42765c60(this.riftPatternSetting, "Star Blast");
        this.patSeismicChasm = new ModeSetting.Nested1_42765c60(this.riftPatternSetting, "Seismic Chasm");

        this.syncTheme = new BooleanSetting(this, "Sync Theme");
        this.riftColorSetting = new ColorSetting(this, "Rift Color", this.syncTheme::i_method_9b12da03)
            .I_method_a62f5dd6(new ColorRGBA(255.0F, 120.0F, 30.0F, 255.0F));

        this.radiusSetting = new SliderSetting(this, "Impact Radius")
            .I_method_c8c9a7d7(1.5F).i_method_65e2aff7(6.0F).II_method_b0f56334(0.25F).Ii_method_4e0e6b54(3.2F);

        this.debrisCountSetting = new SliderSetting(this, "Debris Count")
            .I_method_c8c9a7d7(10.0F).i_method_65e2aff7(60.0F).II_method_b0f56334(5.0F).Ii_method_4e0e6b54(28.0F);

        this.durationSetting = new SliderSetting(this, "Duration (ms)")
            .I_method_c8c9a7d7(600.0F).i_method_65e2aff7(3000.0F).II_method_b0f56334(100.0F).Ii_method_4e0e6b54(1600.0F);

        this.lavaGlowSetting = new BooleanSetting(this, "Glow Bloom").I_method_decd82b5();

        this.weaponFilter = new ModeSetting(this, "Weapon Filter");
        this.filterAllWeapons = new ModeSetting.Nested1_42765c60(this.weaponFilter, "All Weapons").select();
        this.filterMaceOnly = new ModeSetting.Nested1_42765c60(this.weaponFilter, "Mace Only");

        this.triggerMode = new ModeSetting(this, "Trigger Mode");
        this.triggerEveryHit = new ModeSetting.Nested1_42765c60(this.triggerMode, "Every Hit").select();
        this.triggerMaceSmashOnly = new ModeSetting.Nested1_42765c60(this.triggerMode, "Smash Jump Only");

        this.cancelVanillaSmash = new BooleanSetting(this, "Убрать ванильный эффект").I_method_decd82b5();
    }

    public boolean shouldCancelVanillaParticles() {
        return this.isEnabled() && this.cancelVanillaSmash.i_method_9b12da03();
    }

    private boolean isHoldingMace(ClientPlayerEntity player) {
        if (player == null) return false;
        ItemStack main = player.getMainHandStack();
        if (main != null && !main.isEmpty()) {
            if (main.isOf(net.minecraft.item.Items.MACE)) return true;
            String name = main.getItem().toString().toLowerCase();
            String id = String.valueOf(net.minecraft.registry.Registries.ITEM.getId(main.getItem())).toLowerCase();
            return name.contains("mace") || name.contains("bulava") || name.contains("булав") || id.contains("mace") || id.contains("bulava");
        }
        return false;
    }

    private void onHitEntity(Entity target) {
        if (target == null) return;
        MinecraftClient mc = MinecraftClient.getInstance();
        ClientPlayerEntity player = mc.player;
        if (player == null) return;

        // STRICT MACE CHECK: Absolutely never trigger for swords, axes, or anything else
        if (!isHoldingMace(player)) {
            return;
        }

        if (this.triggerMaceSmashOnly.isSelected()) {
            boolean isSmash = player.fallDistance > 0.4F || !player.isOnGround();
            if (!isSmash) return;
        }

        triggerImpactAt(target.getPos());
    }

    public void triggerImpactAt(Vec3d pos) {
        long now = System.currentTimeMillis();
        if (now - this.lastTriggerTime < 200L) return;
        this.lastTriggerTime = now;

        ColorRGBA col;
        if (this.syncTheme.i_method_9b12da03()) {
            col = IiiiiIIIi_Class242.I_method_7df8e08e();
        } else {
            col = this.riftColorSetting.I_method_bde5f08e();
        }

        String pattern = "Celestial Nova";
        if (this.patSpiralVortex.isSelected()) pattern = "Spiral Vortex";
        else if (this.patRunicSigil.isSelected()) pattern = "Runic Sigil";
        else if (this.patRadialWeb.isSelected()) pattern = "Radial Web";
        else if (this.patChaoticCracks.isSelected()) pattern = "Chaotic Cracks";
        else if (this.patHexagonalFracture.isSelected()) pattern = "Hexagonal Fracture";
        else if (this.patStarBlast.isSelected()) pattern = "Star Blast";
        else if (this.patSeismicChasm.isSelected()) pattern = "Seismic Chasm";

        float radius = this.radiusSetting.Ii_method_a20abcd2();
        int debris = (int) this.debrisCountSetting.Ii_method_a20abcd2();

        this.impacts.add(new FissureImpact(pos, radius, debris, col, pattern));
    }

    private void onRender3D(Render3DEvent event) {
        if (this.impacts.isEmpty()) return;

        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.world == null) return;

        long now = System.currentTimeMillis();
        float dur = this.durationSetting.Ii_method_a20abcd2();
        Vec3d cam = mc.gameRenderer.getCamera().getPos();

        RenderSystem.enableBlend();
        if (this.lavaGlowSetting.i_method_9b12da03()) {
            RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE);
        } else {
            RenderSystem.defaultBlendFunc();
        }
        RenderSystem.disableCull();
        RenderSystem.depthMask(false);
        RenderSystem.enableDepthTest();
        RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);

        MatrixStack matrices = event.getMatrices();
        this.impacts.removeIf(imp -> (float)(now - imp.startTime) / dur >= 1.0F);

        for (FissureImpact imp : this.impacts) {
            float progress = (float)(now - imp.startTime) / dur;
            float alpha = (1.0F - progress);
            ColorRGBA cCore = imp.riftColor.withAlpha((int)(255 * alpha));
            ColorRGBA cMid = imp.riftColor.withAlpha((int)(160 * alpha));
            ColorRGBA cOuter = imp.riftColor.withAlpha((int)(65 * alpha));

            matrices.push();
            matrices.translate(imp.center.x - cam.x, imp.center.y - cam.y, imp.center.z - cam.z);
            Matrix4f groundMat = matrices.peek().getPositionMatrix();

            // Multi-pass Bloom Glow along fracture lines
            if (this.lavaGlowSetting.i_method_9b12da03()) {
                // Pass 1: Broad soft outer bloom
                renderFractureStripPass(groundMat, imp.fractureLines, imp.center, 0.12F * (1.0F - progress * 0.3F), cOuter.getRGB());
                // Pass 2: Medium inner emissive aura
                renderFractureStripPass(groundMat, imp.fractureLines, imp.center, 0.06F * (1.0F - progress * 0.4F), cMid.getRGB());
            }
            // Pass 3: Core laser/plasma fissure
            renderFractureStripPass(groundMat, imp.fractureLines, imp.center, 0.025F * (1.0F - progress * 0.5F), cCore.getRGB());

            // Expanding central shockwave fissure ring
            float ringR = imp.maxRadius * (float)Math.sin(progress * Math.PI * 0.5);
            drawFissureShockwave(groundMat, ringR, 0.05F * alpha, cCore);

            // Volumetric 3D rock debris
            for (RockDebris d : imp.debrisList) {
                d.update();
                matrices.push();
                matrices.translate(d.x - imp.center.x, d.y - imp.center.y, d.z - imp.center.z);
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(d.yaw));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(d.pitch));
                matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(d.roll));
                Matrix4f dMat = matrices.peek().getPositionMatrix();
                drawDebrisCube(dMat, d.size, d.color);
                matrices.pop();
            }

            matrices.pop();
        }

        RenderSystem.depthMask(true);
        RenderSystem.enableCull();
        RenderSystem.defaultBlendFunc();
    }

    private void renderFractureStripPass(Matrix4f groundMat, List<Vec3d[]> fractureLines, Vec3d center, float halfWidth, int color) {
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
        for (Vec3d[] line : fractureLines) {
            float x1 = (float)(line[0].x - center.x);
            float z1 = (float)(line[0].z - center.z);
            float x2 = (float)(line[1].x - center.x);
            float z2 = (float)(line[1].z - center.z);

            float dx = x2 - x1, dz = z2 - z1;
            float len = (float)Math.sqrt(dx * dx + dz * dz);
            if (len < 0.001F) continue;
            float nx = -dz / len * halfWidth;
            float nz = dx / len * halfWidth;

            // Two triangles for quad
            bb.vertex(groundMat, x1 - nx, 0.02F, z1 - nz).color(color);
            bb.vertex(groundMat, x1 + nx, 0.02F, z1 + nz).color(color);
            bb.vertex(groundMat, x2 + nx, 0.02F, z2 + nz).color(color);

            bb.vertex(groundMat, x1 - nx, 0.02F, z1 - nz).color(color);
            bb.vertex(groundMat, x2 + nx, 0.02F, z2 + nz).color(color);
            bb.vertex(groundMat, x2 - nx, 0.02F, z2 - nz).color(color);
        }
        BuiltBuffer built = bb.endNullable();
        if (built != null) BufferRenderer.drawWithGlobalProgram(built);
    }

    private void drawFissureShockwave(Matrix4f m, float r, float width, ColorRGBA col) {
        if (r <= 0.05F) return;
        int segs = 36;
        BufferBuilder b = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
        int c = col.getRGB();
        int cFade = (c & 0x00FFFFFF);

        float rInner = Math.max(0.0F, r - width);
        float rOuter = r + width;

        for (int i = 0; i <= segs; i++) {
            double a = (Math.PI * 2.0 * i) / segs;
            float cos = (float)Math.cos(a);
            float sin = (float)Math.sin(a);

            b.vertex(m, cos * rInner, 0.02F, sin * rInner).color(cFade);
            b.vertex(m, cos * rOuter, 0.02F, sin * rOuter).color(c);
        }
        BuiltBuffer built = b.endNullable();
        if (built != null) BufferRenderer.drawWithGlobalProgram(built);
    }

    private void drawDebrisCube(Matrix4f m, float s, int col) {
        float h = s * 0.5F;
        BufferBuilder b = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);

        int top = col;
        int side = shade(col, 0.8F);
        int bot = shade(col, 0.55F);

        // Top
        b.vertex(m, -h, h, -h).color(top);
        b.vertex(m, -h, h,  h).color(top);
        b.vertex(m,  h, h,  h).color(top);
        b.vertex(m,  h, h, -h).color(top);

        // Bottom
        b.vertex(m, -h, -h, -h).color(bot);
        b.vertex(m,  h, -h, -h).color(bot);
        b.vertex(m,  h, -h,  h).color(bot);
        b.vertex(m, -h, -h,  h).color(bot);

        // Front / Back / Left / Right
        b.vertex(m, -h, -h,  h).color(side);
        b.vertex(m,  h, -h,  h).color(side);
        b.vertex(m,  h,  h,  h).color(side);
        b.vertex(m, -h,  h,  h).color(side);

        b.vertex(m, -h, -h, -h).color(side);
        b.vertex(m, -h,  h, -h).color(side);
        b.vertex(m,  h,  h, -h).color(side);
        b.vertex(m,  h, -h, -h).color(side);

        b.vertex(m, -h, -h, -h).color(side);
        b.vertex(m, -h, -h,  h).color(side);
        b.vertex(m, -h,  h,  h).color(side);
        b.vertex(m, -h,  h, -h).color(side);

        b.vertex(m,  h, -h, -h).color(side);
        b.vertex(m,  h,  h, -h).color(side);
        b.vertex(m,  h,  h,  h).color(side);
        b.vertex(m,  h, -h,  h).color(side);

        BuiltBuffer built = b.endNullable();
        if (built != null) BufferRenderer.drawWithGlobalProgram(built);
    }

    private static int shade(int argb, float factor) {
        int a = (argb >> 24) & 0xFF;
        int r = Math.min(255, (int)(((argb >> 16) & 0xFF) * factor));
        int g = Math.min(255, (int)(((argb >> 8) & 0xFF) * factor));
        int b = Math.min(255, (int)((argb & 0xFF) * factor));
        return (a << 24) | (r << 16) | (g << 8) | b;
    }
}
