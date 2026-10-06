package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;

@ModuleInfo(
    name = "Halo",
    category = ModuleCategory.PLAYER,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.halo"
)
public class HaloModule extends Module {
    private ModeSetting modeSetting;
    private ModeSetting.Nested1_42765c60 modeRing;
    private ModeSetting.Nested1_42765c60 modeStar;
    private ModeSetting.Nested1_42765c60 modeCrown;
    private ModeSetting.Nested1_42765c60 modeCyber;
    private ModeSetting.Nested1_42765c60 modeDual;
    private ModeSetting.Nested1_42765c60 modeWings;
    private ModeSetting.Nested1_42765c60 modeFire;
    private ModeSetting.Nested1_42765c60 modeFrost;
    private ModeSetting.Nested1_42765c60 modeRunic;
    private ModeSetting.Nested1_42765c60 modeDemon;
    private ModeSetting.Nested1_42765c60 modeLotus;
    private ModeSetting.Nested1_42765c60 modeGalaxy;
    private ModeSetting.Nested1_42765c60 modeThunder;
    private ModeSetting.Nested1_42765c60 modeHeart;
    private ModeSetting.Nested1_42765c60 modeSun;
    private ModeSetting.Nested1_42765c60 modeHexagon;
    private ModeSetting.Nested1_42765c60 modeBlades;
    private ModeSetting.Nested1_42765c60 modeDNA;
    private ModeSetting.Nested1_42765c60 modeChrono;
    private ModeSetting.Nested1_42765c60 modeVortex;
    // 15 NEW
    private ModeSetting.Nested1_42765c60 modeOrbital;
    private ModeSetting.Nested1_42765c60 modeAtomic;
    private ModeSetting.Nested1_42765c60 modePrism;
    private ModeSetting.Nested1_42765c60 modeMandala;
    private ModeSetting.Nested1_42765c60 modeEclipse;
    private ModeSetting.Nested1_42765c60 modeInfinity;
    private ModeSetting.Nested1_42765c60 modeNebula;
    private ModeSetting.Nested1_42765c60 modeClockwork;
    private ModeSetting.Nested1_42765c60 modeSpiral;
    private ModeSetting.Nested1_42765c60 modeCubes;
    private ModeSetting.Nested1_42765c60 modeCompass;
    private ModeSetting.Nested1_42765c60 modeEye;
    private ModeSetting.Nested1_42765c60 modeShield;
    private ModeSetting.Nested1_42765c60 modeWeb;
    private ModeSetting.Nested1_42765c60 modeChains;
    private ModeSetting.Nested1_42765c60 modeSupernova;
    private ModeSetting.Nested1_42765c60 modeQuantumRings;
    private ModeSetting.Nested1_42765c60 modeCyberMatrix;
    private ModeSetting.Nested1_42765c60 modeAngelTriple;
    private ModeSetting.Nested1_42765c60 modeBlackHole;
    private ModeSetting.Nested1_42765c60 modeRunestone;
    private ModeSetting.Nested1_42765c60 modeHydraSerpents;
    private ModeSetting.Nested1_42765c60 modePixelRetro;
    private ModeSetting.Nested1_42765c60 modeValkyrieFeathers;
    private ModeSetting.Nested1_42765c60 modeDarkMatter;
    private ModeSetting.Nested1_42765c60 modePlasmaCore;
    private ModeSetting.Nested1_42765c60 modeStarlightChime;
    private ModeSetting.Nested1_42765c60 modeSacredGeometry;
    private ModeSetting.Nested1_42765c60 modeSolarWheel;
    private ModeSetting.Nested1_42765c60 modeFrostLotus;
    private ModeSetting.Nested1_42765c60 modeThunderStorm;
    private ModeSetting.Nested1_42765c60 modeDemonSigil;
    private ModeSetting.Nested1_42765c60 modeChronoGears;
    private ModeSetting.Nested1_42765c60 modePrismCrown;
    private ModeSetting.Nested1_42765c60 modeCelestialOrb;


    private SliderSetting radiusSetting;
    private SliderSetting heightOffsetSetting;
    private SliderSetting tiltSetting;
    private SliderSetting speedSetting;
    private BooleanSetting syncTheme;
    private ColorSetting customColor;

    private final IiIIIiII_Class69<Render3DEvent> renderEvent = this::onRender3D;

    public HaloModule() {
        this.initSettings();
    }

    private void initSettings() {
        this.modeSetting = new ModeSetting(this, "modules.settings.halo.mode");
        this.modeRing = new ModeSetting.Nested1_42765c60(this.modeSetting, "Ring").select();
        this.modeStar = new ModeSetting.Nested1_42765c60(this.modeSetting, "Star");
        this.modeCrown = new ModeSetting.Nested1_42765c60(this.modeSetting, "Crown");
        this.modeCyber = new ModeSetting.Nested1_42765c60(this.modeSetting, "Cyber");
        this.modeDual = new ModeSetting.Nested1_42765c60(this.modeSetting, "Dual");
        this.modeWings = new ModeSetting.Nested1_42765c60(this.modeSetting, "Wings");
        this.modeFire = new ModeSetting.Nested1_42765c60(this.modeSetting, "Fire");
        this.modeFrost = new ModeSetting.Nested1_42765c60(this.modeSetting, "Frost");
        this.modeRunic = new ModeSetting.Nested1_42765c60(this.modeSetting, "Runic");
        this.modeDemon = new ModeSetting.Nested1_42765c60(this.modeSetting, "Demon");
        this.modeLotus = new ModeSetting.Nested1_42765c60(this.modeSetting, "Lotus");
        this.modeGalaxy = new ModeSetting.Nested1_42765c60(this.modeSetting, "Galaxy");
        this.modeThunder = new ModeSetting.Nested1_42765c60(this.modeSetting, "Thunder");
        this.modeHeart = new ModeSetting.Nested1_42765c60(this.modeSetting, "Heart");
        this.modeSun = new ModeSetting.Nested1_42765c60(this.modeSetting, "Sun");
        this.modeHexagon = new ModeSetting.Nested1_42765c60(this.modeSetting, "Hexagon");
        this.modeBlades = new ModeSetting.Nested1_42765c60(this.modeSetting, "Blades");
        this.modeDNA = new ModeSetting.Nested1_42765c60(this.modeSetting, "DNA");
        this.modeChrono = new ModeSetting.Nested1_42765c60(this.modeSetting, "Chrono");
        this.modeVortex = new ModeSetting.Nested1_42765c60(this.modeSetting, "Vortex");
        this.modeOrbital = new ModeSetting.Nested1_42765c60(this.modeSetting, "Orbital");
        this.modeAtomic = new ModeSetting.Nested1_42765c60(this.modeSetting, "Atomic");
        this.modePrism = new ModeSetting.Nested1_42765c60(this.modeSetting, "Prism");
        this.modeMandala = new ModeSetting.Nested1_42765c60(this.modeSetting, "Mandala");
        this.modeEclipse = new ModeSetting.Nested1_42765c60(this.modeSetting, "Eclipse");
        this.modeInfinity = new ModeSetting.Nested1_42765c60(this.modeSetting, "Infinity");
        this.modeNebula = new ModeSetting.Nested1_42765c60(this.modeSetting, "Nebula");
        this.modeClockwork = new ModeSetting.Nested1_42765c60(this.modeSetting, "Clockwork");
        this.modeSpiral = new ModeSetting.Nested1_42765c60(this.modeSetting, "Spiral");
        this.modeCubes = new ModeSetting.Nested1_42765c60(this.modeSetting, "Cubes");
        this.modeCompass = new ModeSetting.Nested1_42765c60(this.modeSetting, "Compass");
        this.modeEye = new ModeSetting.Nested1_42765c60(this.modeSetting, "Eye");
        this.modeShield = new ModeSetting.Nested1_42765c60(this.modeSetting, "Shield");
        this.modeWeb = new ModeSetting.Nested1_42765c60(this.modeSetting, "Web");
        this.modeChains = new ModeSetting.Nested1_42765c60(this.modeSetting, "Chains");
        this.modeSupernova = new ModeSetting.Nested1_42765c60(this.modeSetting, "Supernova");
        this.modeQuantumRings = new ModeSetting.Nested1_42765c60(this.modeSetting, "QuantumRings");
        this.modeCyberMatrix = new ModeSetting.Nested1_42765c60(this.modeSetting, "CyberMatrix");
        this.modeAngelTriple = new ModeSetting.Nested1_42765c60(this.modeSetting, "AngelTriple");
        this.modeBlackHole = new ModeSetting.Nested1_42765c60(this.modeSetting, "BlackHole");
        this.modeRunestone = new ModeSetting.Nested1_42765c60(this.modeSetting, "Runestone");
        this.modeHydraSerpents = new ModeSetting.Nested1_42765c60(this.modeSetting, "HydraSerpents");
        this.modePixelRetro = new ModeSetting.Nested1_42765c60(this.modeSetting, "PixelRetro");
        this.modeValkyrieFeathers = new ModeSetting.Nested1_42765c60(this.modeSetting, "ValkyrieFeathers");
        this.modeDarkMatter = new ModeSetting.Nested1_42765c60(this.modeSetting, "DarkMatter");
        this.modePlasmaCore = new ModeSetting.Nested1_42765c60(this.modeSetting, "PlasmaCore");
        this.modeStarlightChime = new ModeSetting.Nested1_42765c60(this.modeSetting, "StarlightChime");
        this.modeSacredGeometry = new ModeSetting.Nested1_42765c60(this.modeSetting, "SacredGeometry");
        this.modeSolarWheel = new ModeSetting.Nested1_42765c60(this.modeSetting, "SolarWheel");
        this.modeFrostLotus = new ModeSetting.Nested1_42765c60(this.modeSetting, "FrostLotus");
        this.modeThunderStorm = new ModeSetting.Nested1_42765c60(this.modeSetting, "ThunderStorm");
        this.modeDemonSigil = new ModeSetting.Nested1_42765c60(this.modeSetting, "DemonSigil");
        this.modeChronoGears = new ModeSetting.Nested1_42765c60(this.modeSetting, "ChronoGears");
        this.modePrismCrown = new ModeSetting.Nested1_42765c60(this.modeSetting, "PrismCrown");
        this.modeCelestialOrb = new ModeSetting.Nested1_42765c60(this.modeSetting, "CelestialOrb");

        this.radiusSetting = new SliderSetting(this, "Radius")
            .I_method_c8c9a7d7(0.2F)
            .i_method_65e2aff7(0.8F)
            .II_method_b0f56334(0.05F)
            .Ii_method_4e0e6b54(0.42F);

        this.heightOffsetSetting = new SliderSetting(this, "Height")
            .I_method_c8c9a7d7(0.1F)
            .i_method_65e2aff7(0.7F)
            .II_method_b0f56334(0.05F)
            .Ii_method_4e0e6b54(0.32F);

        this.tiltSetting = new SliderSetting(this, "Tilt")
            .I_method_c8c9a7d7(0.0F)
            .i_method_65e2aff7(45.0F)
            .II_method_b0f56334(1.0F)
            .Ii_method_4e0e6b54(0.0F);

        this.speedSetting = new SliderSetting(this, "Rotation Speed")
            .I_method_c8c9a7d7(0.2F)
            .i_method_65e2aff7(4.0F)
            .II_method_b0f56334(0.1F)
            .Ii_method_4e0e6b54(1.2F);

        this.syncTheme = new BooleanSetting(this, "Sync Theme").I_method_decd82b5();
        this.customColor = new ColorSetting(this, "Color").I_method_a62f5dd6(new ColorRGBA(180.0F, 240.0F, 255.0F, 240.0F));
    }

    @Override
    public String i_method_bf522194() {
        return "Анимированный парящий нимб над головой игрока с 20 настраиваемыми стилями и свечением (не мешает в PvP).";
    }

    private void onRender3D(Render3DEvent event) {
        MinecraftClient mc = MinecraftClient.getInstance();
        ClientPlayerEntity player = mc.player;
        if (player == null || mc.world == null) return;
        if (mc.options.getPerspective().isFirstPerson()) return;

        float tickDelta = mc.getRenderTickCounter().getTickDelta(false);
        Vec3d cameraPos = mc.gameRenderer.getCamera().getPos();

        double interpX = MathHelper.lerp((double)tickDelta, player.prevX, player.getX()) - cameraPos.x;
        double interpY = MathHelper.lerp((double)tickDelta, player.prevY, player.getY()) - cameraPos.y;
        double interpZ = MathHelper.lerp((double)tickDelta, player.prevZ, player.getZ()) - cameraPos.z;

        float headPitch = MathHelper.lerp(tickDelta, player.prevPitch, player.getPitch());
        float headYaw = MathHelper.lerp(tickDelta, player.prevHeadYaw, player.headYaw);
        float bodyYaw = MathHelper.lerp(tickDelta, player.prevBodyYaw, player.bodyYaw);

        MatrixStack matrices = event.getMatrices();
        matrices.push();
        try {

        // Head anchor with sneak compensation
        double headX = interpX;
        double headY = interpY + player.getEyeHeight(player.getPose()) - 0.10;
        double headZ = interpZ;
        if (player.isSneaking()) {
            headX -= Math.sin(Math.toRadians(bodyYaw)) * 0.16;
            headZ += Math.cos(Math.toRadians(bodyYaw)) * 0.16;
            headY -= 0.04;
        }

        matrices.translate(headX, headY, headZ);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F - headYaw));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-headPitch));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(this.tiltSetting.Ii_method_a20abcd2()));

        // Offset above skull along the head's local upward vector
        matrices.translate(0.0F, 0.28F + this.heightOffsetSetting.Ii_method_a20abcd2(), 0.0F);

        long time = System.currentTimeMillis();
        float rot = (float)((time * 0.08 * this.speedSetting.Ii_method_a20abcd2()) % 360.0);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rot));

        ColorRGBA haloColor = this.syncTheme.i_method_9b12da03()
            ? IiiiiIIIi_Class242.I_method_7df8e08e()
            : this.customColor.I_method_bde5f08e();

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableCull();
        RenderSystem.disableDepthTest();
        RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);

        Matrix4f mat = matrices.peek().getPositionMatrix();
        float r = this.radiusSetting.Ii_method_a20abcd2();

        if (this.modeDNA.isSelected()) {
            drawDNAHelix(mat, r, haloColor, rot);
        } else if (this.modeRing.isSelected()) {
            drawCelestialGyro(matrices, r, haloColor, rot);
        } else if (this.modeDual.isSelected()) {
            drawDysonMobius(matrices, r, haloColor, rot);
        } else if (this.modeStar.isSelected()) {
            drawMerkabahStar(mat, r, haloColor, rot);
        } else if (this.modeCrown.isSelected()) {
            drawImperialCrown(mat, r, haloColor, rot);
        } else if (this.modeCyber.isSelected()) {
            drawCyberHUD3D(mat, r, haloColor, rot);
        } else if (this.modeWings.isSelected()) {
            drawValkyrieWingRing(mat, r, haloColor, rot);
        } else if (this.modeFire.isSelected()) {
            drawSolarisTornado(mat, r, haloColor, rot);
        } else if (this.modeFrost.isSelected()) {
            drawGlacialSnowflake(mat, r, haloColor, rot);
        } else if (this.modeRunic.isSelected()) {
            drawRunicAstrolabe(mat, r, haloColor, rot);
        } else if (this.modeDemon.isSelected()) {
            drawAbyssalHorns(mat, r, haloColor, rot);
        } else if (this.modeLotus.isSelected()) {
            drawAstralLotus(mat, r, haloColor, rot);
        } else if (this.modeGalaxy.isSelected()) {
            drawCosmicGalaxy(mat, r, haloColor, rot);
        } else if (this.modeThunder.isSelected()) {
            drawTeslaPlasmaCage(mat, r, haloColor, time);
        } else if (this.modeHeart.isSelected()) {
            drawCrystalHeart3D(mat, r, haloColor, time, rot);
        } else if (this.modeSun.isSelected()) {
            drawSolarisProminence(mat, r, haloColor, rot);
        } else if (this.modeHexagon.isSelected()) {
            drawHexMatrix3D(mat, r, haloColor, rot);
        } else if (this.modeBlades.isSelected()) {
            drawFloatingSwordRing(mat, r, haloColor, rot);
        } else if (this.modeChrono.isSelected()) {
            drawChronoAstrolabe(mat, r, haloColor, rot);
        } else if (this.modeVortex.isSelected()) {
            drawSingularityFunnel(mat, r, haloColor, rot);
        } else if (this.modeOrbital.isSelected()) {
            drawOrbital(mat, r, haloColor, rot);
        } else if (this.modeAtomic.isSelected()) {
            drawAtomic(matrices, r, haloColor, rot);
        } else if (this.modePrism.isSelected()) {
            drawPrism(mat, r, haloColor, rot);
        } else if (this.modeMandala.isSelected()) {
            drawMandala(mat, r, haloColor, rot);
        } else if (this.modeEclipse.isSelected()) {
            drawEclipse(mat, r, haloColor, rot);
        } else if (this.modeInfinity.isSelected()) {
            drawInfinity(mat, r, haloColor, rot);
        } else if (this.modeNebula.isSelected()) {
            drawNebula(mat, r, haloColor, rot);
        } else if (this.modeClockwork.isSelected()) {
            drawClockwork(mat, r, haloColor, rot);
        } else if (this.modeSpiral.isSelected()) {
            drawSpiral(mat, r, haloColor, rot);
        } else if (this.modeCubes.isSelected()) {
            drawCubes(mat, r, haloColor, rot);
        } else if (this.modeCompass.isSelected()) {
            drawCompass(mat, r, haloColor, rot);
        } else if (this.modeEye.isSelected()) {
            drawEye(mat, r, haloColor, rot);
        } else if (this.modeShield.isSelected()) {
            drawShield(mat, r, haloColor, rot);
        } else if (this.modeWeb.isSelected()) {
            drawWeb(mat, r, haloColor, rot);
        } else if (this.modeChains.isSelected()) {
            drawChains(mat, r, haloColor, rot);
        } else if (this.modeSupernova != null && this.modeSupernova.isSelected()) {
            drawSupernova(mat, r, haloColor, rot);
        } else if (this.modeQuantumRings != null && this.modeQuantumRings.isSelected()) {
            drawQuantumRings(matrices, r, haloColor, rot);
        } else if (this.modeCyberMatrix != null && this.modeCyberMatrix.isSelected()) {
            drawCyberMatrix(mat, r, haloColor, rot);
        } else if (this.modeAngelTriple != null && this.modeAngelTriple.isSelected()) {
            drawAngelTriple(mat, r, haloColor, rot);
        } else if (this.modeBlackHole != null && this.modeBlackHole.isSelected()) {
            drawBlackHole(mat, r, haloColor, rot);
        } else if (this.modeRunestone != null && this.modeRunestone.isSelected()) {
            drawRunestone(mat, r, haloColor, rot);
        } else if (this.modeHydraSerpents != null && this.modeHydraSerpents.isSelected()) {
            drawHydraSerpents(mat, r, haloColor, rot);
        } else if (this.modePixelRetro != null && this.modePixelRetro.isSelected()) {
            drawPixelRetro(mat, r, haloColor, rot);
        } else if (this.modeValkyrieFeathers != null && this.modeValkyrieFeathers.isSelected()) {
            drawValkyrieFeathers(mat, r, haloColor, rot);
        } else if (this.modeDarkMatter != null && this.modeDarkMatter.isSelected()) {
            drawDarkMatter(mat, r, haloColor, rot);
        } else if (this.modePlasmaCore != null && this.modePlasmaCore.isSelected()) {
            drawPlasmaCore(mat, r, haloColor, rot);
        } else if (this.modeStarlightChime != null && this.modeStarlightChime.isSelected()) {
            drawStarlightChime(mat, r, haloColor, rot);
        } else if (this.modeSacredGeometry != null && this.modeSacredGeometry.isSelected()) {
            drawSacredGeometry(mat, r, haloColor, rot);
        } else if (this.modeSolarWheel != null && this.modeSolarWheel.isSelected()) {
            drawSolarWheel(mat, r, haloColor, rot);
        } else if (this.modeFrostLotus != null && this.modeFrostLotus.isSelected()) {
            drawFrostLotus(mat, r, haloColor, rot);
        } else if (this.modeThunderStorm != null && this.modeThunderStorm.isSelected()) {
            drawThunderStorm(mat, r, haloColor, rot);
        } else if (this.modeDemonSigil != null && this.modeDemonSigil.isSelected()) {
            drawDemonSigil(mat, r, haloColor, rot);
        } else if (this.modeChronoGears != null && this.modeChronoGears.isSelected()) {
            drawChronoGears(mat, r, haloColor, rot);
        } else if (this.modePrismCrown != null && this.modePrismCrown.isSelected()) {
            drawPrismCrown(mat, r, haloColor, rot);
        } else if (this.modeCelestialOrb != null && this.modeCelestialOrb.isSelected()) {
            drawCelestialOrb(matrices, r, haloColor, rot);
        }

                } finally {
            RenderSystem.enableDepthTest();
            RenderSystem.enableCull();
            RenderSystem.defaultBlendFunc();
            RenderSystem.disableBlend();
            matrices.pop();
        }
    }

    // ---------------------------------------------------------
    // 3D GEOMETRIC PRIMITIVE HELPERS
    // ---------------------------------------------------------

    private static void safeDraw(BufferBuilder bb) {
        BuiltBuffer built = bb.endNullable();
        if (built != null) {
            BufferRenderer.drawWithGlobalProgram(built);
        }
    }

    private void drawWaveRibbon(Matrix4f mat, float radius, float thickness, float heightAmp, int waveFreq, float phaseRad, ColorRGBA color, int steps) {
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
        int c1 = color.getRGB();
        int c2 = color.withAlpha(color.getAlpha() * 0.45F).getRGB();
        for (int i = 0; i <= steps; i++) {
            double a = (Math.PI * 2.0 * i) / steps;
            float y = (float)Math.sin(a * waveFreq + phaseRad) * heightAmp;
            float cos = (float)Math.cos(a);
            float sin = (float)Math.sin(a);
            bb.vertex(mat, cos * (radius - thickness), y - 0.012F, sin * (radius - thickness)).color(c1);
            bb.vertex(mat, cos * (radius + thickness), y + 0.012F, sin * (radius + thickness)).color(c2);
        }
        safeDraw(bb);
    }

    private void drawSolidRing(Matrix4f mat, float radius, float thickness, ColorRGBA color, int steps) {
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
        int c1 = color.getRGB();
        int c2 = color.withAlpha(color.getAlpha() * 0.70F).getRGB();
        for (int i = 0; i <= steps; i++) {
            double a = (Math.PI * 2.0 * i) / steps;
            float cos = (float)Math.cos(a);
            float sin = (float)Math.sin(a);
            bb.vertex(mat, cos * (radius - thickness), -0.005F, sin * (radius - thickness)).color(c1);
            bb.vertex(mat, cos * (radius + thickness), 0.005F, sin * (radius + thickness)).color(c2);
        }
        safeDraw(bb);
    }

    private void drawDiamondJewel(Matrix4f mat, float cx, float cy, float cz, float size, ColorRGBA color) {
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
        int cApex = color.withAlpha(255.0F).getRGB();
        int cMid = color.withAlpha(color.getAlpha() * 0.70F).getRGB();
        float r = size * 0.65F;
        float h = size;
        float[] dx = {r, 0, -r, 0};
        float[] dz = {0, r, 0, -r};
        for (int i = 0; i < 4; i++) {
            int next = (i + 1) % 4;
            // Top pyramid
            bb.vertex(mat, cx, cy + h, cz).color(cApex);
            bb.vertex(mat, cx + dx[i], cy, cz + dz[i]).color(cMid);
            bb.vertex(mat, cx + dx[next], cy, cz + dz[next]).color(cMid);
            // Bottom pyramid
            bb.vertex(mat, cx, cy - h, cz).color(cApex);
            bb.vertex(mat, cx + dx[next], cy, cz + dz[next]).color(cMid);
            bb.vertex(mat, cx + dx[i], cy, cz + dz[i]).color(cMid);
        }
        safeDraw(bb);
    }

    private void drawBeam(Matrix4f mat, float x1, float y1, float z1, float x2, float y2, float z2, float width, ColorRGBA color) {
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
        int c = color.getRGB();
        bb.vertex(mat, x1, y1 - width, z1).color(c);
        bb.vertex(mat, x1, y1 + width, z1).color(c);
        bb.vertex(mat, x2, y2 - width, z2).color(c);
        bb.vertex(mat, x2, y2 + width, z2).color(c);
        safeDraw(bb);
    }

    // ---------------------------------------------------------
    // 20 ENHANCED 3D HALO MODES
    // ---------------------------------------------------------

    // 1. DNA HELIX (The Crown Jewel): Double-strand 3D wave with 16 nucleotide rungs & diamond nodes
    private void drawDNAHelix(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        float rotRad = (float)Math.toRadians(rot * 2.0);
        // Strand 1 & 2 wave ribbons
        drawWaveRibbon(mat, radius - 0.02F, 0.015F, 0.07F, 4, rotRad, color, 48);
        drawWaveRibbon(mat, radius + 0.02F, 0.015F, 0.07F, 4, rotRad + (float)Math.PI, color.withAlpha(color.getAlpha() * 0.85F), 48);

        // 16 Hydrogen bond rungs connecting strand 1 to strand 2
        int rungs = 16;
        for (int i = 0; i < rungs; i++) {
            double a = (Math.PI * 2.0 * i) / rungs;
            float cos = (float)Math.cos(a);
            float sin = (float)Math.sin(a);
            float y1 = (float)Math.sin(a * 4.0 + rotRad) * 0.07F;
            float y2 = -y1;
            float x1 = cos * (radius - 0.02F);
            float z1 = sin * (radius - 0.02F);
            float x2 = cos * (radius + 0.02F);
            float z2 = sin * (radius + 0.02F);

            drawBeam(mat, x1, y1, z1, x2, y2, z2, 0.006F, color.withAlpha(color.getAlpha() * 0.9F));
            drawDiamondJewel(mat, x1, y1, z1, 0.018F, color);
            drawDiamondJewel(mat, x2, y2, z2, 0.018F, color);
        }
    }

    // 2. RING -> Celestial 3-Axis Gyroscope Astrolabe
    private void drawCelestialGyro(MatrixStack matrices, float radius, ColorRGBA color, float rot) {
        // Equatorial undulating wave ring
        drawWaveRibbon(matrices.peek().getPositionMatrix(), radius, 0.025F, 0.035F, 4, (float)Math.toRadians(rot), color, 36);

        // Meridian Ring tilted at +55° around X
        matrices.push();
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(55.0F));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rot * 1.5F));
        drawWaveRibbon(matrices.peek().getPositionMatrix(), radius * 0.88F, 0.018F, 0.025F, 3, 0.0F, color.withAlpha(color.getAlpha() * 0.75F), 32);
        matrices.pop();

        // Precession Ring tilted at -55° around Z
        matrices.push();
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(55.0F));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-rot * 1.5F));
        drawWaveRibbon(matrices.peek().getPositionMatrix(), radius * 0.76F, 0.015F, 0.020F, 3, 0.0F, color.withAlpha(color.getAlpha() * 0.60F), 28);
        matrices.pop();

        // 4 Floating celestial diamond satellites
        Matrix4f m = matrices.peek().getPositionMatrix();
        for (int i = 0; i < 4; i++) {
            double a = (Math.PI * 2.0 * i) / 4.0 + Math.toRadians(rot);
            float sx = (float)Math.cos(a) * (radius * 1.12F);
            float sz = (float)Math.sin(a) * (radius * 1.12F);
            float sy = (float)Math.sin(a * 2.0) * 0.04F;
            drawDiamondJewel(m, sx, sy, sz, 0.028F, color);
        }
    }

    // 3. DUAL -> Orbital Dyson Möbius Rings
    private void drawDysonMobius(MatrixStack matrices, float radius, ColorRGBA color, float rot) {
        matrices.push();
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(32.0F));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rot));
        drawWaveRibbon(matrices.peek().getPositionMatrix(), radius, 0.022F, 0.04F, 3, 0.0F, color, 36);
        matrices.pop();

        matrices.push();
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-32.0F));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-rot));
        drawWaveRibbon(matrices.peek().getPositionMatrix(), radius, 0.022F, 0.04F, 3, (float)Math.PI, color.withAlpha(color.getAlpha() * 0.85F), 36);
        matrices.pop();

        Matrix4f m = matrices.peek().getPositionMatrix();
        drawDiamondJewel(m, 0.0F, 0.0F, 0.0F, 0.05F, color);
    }

    // 4. STAR -> 3D Stellated Merkabah
    private void drawMerkabahStar(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        drawWaveRibbon(mat, radius * 0.85F, 0.015F, 0.035F, 8, (float)Math.toRadians(rot * 2), color.withAlpha(color.getAlpha() * 0.6F), 32);

        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
        int cTip = color.withAlpha(255.0F).getRGB();
        int cBase = color.withAlpha(color.getAlpha() * 0.5F).getRGB();
        int points = 8;
        for (int i = 0; i < points; i++) {
            double a = (Math.PI * 2.0 * i) / points;
            double aNext = (Math.PI * 2.0 * (i + 1)) / points;
            float x1 = (float)Math.cos(a) * radius * 0.5F;
            float z1 = (float)Math.sin(a) * radius * 0.5F;
            float x2 = (float)Math.cos(aNext) * radius * 0.5F;
            float z2 = (float)Math.sin(aNext) * radius * 0.5F;
            float aMid = (float)((a + aNext) / 2.0);
            float xTip = (float)Math.cos(aMid) * radius * 1.25F;
            float zTip = (float)Math.sin(aMid) * radius * 1.25F;
            float yTip = (i % 2 == 0) ? 0.08F : -0.08F;

            bb.vertex(mat, x1, 0.0F, z1).color(cBase);
            bb.vertex(mat, xTip, yTip, zTip).color(cTip);
            bb.vertex(mat, x2, 0.0F, z2).color(cBase);
        }
        safeDraw(bb);
        drawDiamondJewel(mat, 0.0F, 0.0F, 0.0F, 0.045F, color);
    }

    // 5. CROWN -> Sovereign Imperial Astral Diadem with hovering diamond prisms
    private void drawImperialCrown(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        drawWaveRibbon(mat, radius * 0.90F, 0.02F, 0.02F, 8, 0.0F, color, 32);

        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
        int cTip = color.withAlpha(255.0F).getRGB();
        int cBase = color.getRGB();
        int spires = 8;
        for (int i = 0; i < spires; i++) {
            double a1 = (Math.PI * 2.0 * i) / spires;
            double a2 = (Math.PI * 2.0 * (i + 1)) / spires;
            double aMid = (a1 + a2) / 2.0;
            float x1 = (float)Math.cos(a1) * radius * 0.90F;
            float z1 = (float)Math.sin(a1) * radius * 0.90F;
            float x2 = (float)Math.cos(a2) * radius * 0.90F;
            float z2 = (float)Math.sin(a2) * radius * 0.90F;
            float xMid = (float)Math.cos(aMid) * (radius * 1.15F);
            float zMid = (float)Math.sin(aMid) * (radius * 1.15F);
            float tipH = 0.16F;

            bb.vertex(mat, x1, 0.0F, z1).color(cBase);
            bb.vertex(mat, xMid, tipH, zMid).color(cTip);
            bb.vertex(mat, x2, 0.0F, z2).color(cBase);
        }
        safeDraw(bb);

        // 8 Floating diamond jewels bobbing harmonically above spires
        for (int i = 0; i < spires; i++) {
            double aMid = (Math.PI * 2.0 * (i + 0.5)) / spires;
            float x = (float)Math.cos(aMid) * (radius * 1.15F);
            float z = (float)Math.sin(aMid) * (radius * 1.15F);
            float y = 0.22F + (float)Math.sin(Math.toRadians(rot * 3.0 + i * 45)) * 0.025F;
            drawDiamondJewel(mat, x, y, z, 0.022F, color);
        }
    }

    // 6. CYBER -> 3D Quantum Holographic HUD Array
    private void drawCyberHUD3D(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        // Upper & lower HUD arc brackets
        drawWaveRibbon(mat, radius, 0.015F, 0.01F, 4, 0.0F, color, 32);
        drawWaveRibbon(mat, radius * 0.85F, 0.012F, 0.05F, 6, (float)Math.toRadians(rot * 2), color.withAlpha(color.getAlpha() * 0.6F), 32);

        // 6 Vertical holographic equalizer laser beams
        int pillars = 6;
        for (int i = 0; i < pillars; i++) {
            double a = (Math.PI * 2.0 * i) / pillars + Math.toRadians(rot);
            float x = (float)Math.cos(a) * radius;
            float z = (float)Math.sin(a) * radius;
            float h = 0.08F + 0.05F * (float)Math.sin(a * 3.0 + Math.toRadians(rot * 4));
            drawBeam(mat, x, -h, z, x, h, z, 0.008F, color);
            drawDiamondJewel(mat, x, h, z, 0.018F, color);
        }
    }

    // 7. WINGS -> Seraphim Blade-Feather Halo (Curved 3D feathers)
    private void drawValkyrieWingRing(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        drawWaveRibbon(mat, radius * 0.75F, 0.015F, 0.03F, 4, (float)Math.toRadians(rot), color.withAlpha(color.getAlpha() * 0.7F), 32);

        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
        int cTip = color.withAlpha(255.0F).getRGB();
        int cBase = color.withAlpha(color.getAlpha() * 0.4F).getRGB();
        int feathers = 8;
        for (int i = 0; i < feathers; i++) {
            double a = (Math.PI * 2.0 * i) / feathers;
            float x1 = (float)Math.cos(a) * radius * 0.75F;
            float z1 = (float)Math.sin(a) * radius * 0.75F;
            float x2 = (float)Math.cos(a + 0.28) * radius * 1.35F;
            float z2 = (float)Math.sin(a + 0.28) * radius * 1.35F;
            float x3 = (float)Math.cos(a + 0.12) * radius * 0.95F;
            float z3 = (float)Math.sin(a + 0.12) * radius * 0.95F;
            float flapY = 0.15F + (float)Math.sin(Math.toRadians(rot * 3.0 + i * 45)) * 0.04F;

            bb.vertex(mat, x1, 0.0F, z1).color(cBase);
            bb.vertex(mat, x2, flapY, z2).color(cTip);
            bb.vertex(mat, x3, flapY * 0.5F, z3).color(cBase);
        }
        safeDraw(bb);
    }

    // 8. FIRE -> 3D Solaris Flame Tornado Vortex
    private void drawSolarisTornado(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        int flames = 12;
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
        int cBase = color.getRGB();
        int cTip = new ColorRGBA(255.0F, 220.0F, 80.0F, color.getAlpha()).getRGB();
        for (int i = 0; i < flames; i++) {
            double a = (Math.PI * 2.0 * i) / flames;
            float x1 = (float)Math.cos(a) * radius * 0.9F;
            float z1 = (float)Math.sin(a) * radius * 0.9F;
            float x2 = (float)Math.cos(a + 0.35) * radius * 0.9F;
            float z2 = (float)Math.sin(a + 0.35) * radius * 0.9F;
            // Spirals inward and upward into a 3D flame cone
            float tipR = radius * 0.7F;
            float xTip = (float)Math.cos(a + 0.5) * tipR;
            float zTip = (float)Math.sin(a + 0.5) * tipR;
            float tipH = 0.18F + 0.06F * (float)Math.sin(Math.toRadians(rot * 4.0 + i * 30));

            bb.vertex(mat, x1, -0.04F, z1).color(cBase);
            bb.vertex(mat, xTip, tipH, zTip).color(cTip);
            bb.vertex(mat, x2, -0.04F, z2).color(cBase);
        }
        safeDraw(bb);

        // Rising core embers
        for (int i = 0; i < 6; i++) {
            double a = (Math.PI * 2.0 * i) / 6.0 + Math.toRadians(rot * 2.0);
            float r = radius * 0.45F;
            float y = (float)Math.sin(a * 2.0) * 0.08F;
            drawDiamondJewel(mat, (float)Math.cos(a) * r, y, (float)Math.sin(a) * r, 0.016F, new ColorRGBA(255.0F, 240.0F, 120.0F, 255.0F));
        }
    }

    // 9. FROST -> 3D Hyperborean Glacial Snowflake with 3D prism depth
    private void drawGlacialSnowflake(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        drawWaveRibbon(mat, radius * 0.70F, 0.018F, 0.03F, 6, (float)Math.toRadians(rot), color, 36);

        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
        int cCore = color.getRGB();
        int cIce = new ColorRGBA(225.0F, 250.0F, 255.0F, 255.0F).getRGB();
        for (int i = 0; i < 6; i++) {
            double a = (Math.PI * 2.0 * i) / 6.0;
            float x1 = (float)Math.cos(a - 0.14) * radius * 0.65F;
            float z1 = (float)Math.sin(a - 0.14) * radius * 0.65F;
            float x2 = (float)Math.cos(a + 0.14) * radius * 0.65F;
            float z2 = (float)Math.sin(a + 0.14) * radius * 0.65F;
            float xTip = (float)Math.cos(a) * radius * 1.35F;
            float zTip = (float)Math.sin(a) * radius * 1.35F;

            // Upper crystal facet
            bb.vertex(mat, x1, 0.0F, z1).color(cCore);
            bb.vertex(mat, xTip, 0.06F, zTip).color(cIce);
            bb.vertex(mat, x2, 0.0F, z2).color(cCore);
            // Lower crystal facet
            bb.vertex(mat, x1, 0.0F, z1).color(cCore);
            bb.vertex(mat, x2, 0.0F, z2).color(cCore);
            bb.vertex(mat, xTip, -0.06F, zTip).color(cIce);
        }
        safeDraw(bb);

        // 6 Floating ice jewels at tips
        for (int i = 0; i < 6; i++) {
            double a = (Math.PI * 2.0 * i) / 6.0;
            float x = (float)Math.cos(a) * radius * 1.35F;
            float z = (float)Math.sin(a) * radius * 1.35F;
            float y = (float)Math.sin(Math.toRadians(rot * 2.0 + i * 60)) * 0.03F;
            drawDiamondJewel(mat, x, y, z, 0.024F, color);
        }
    }

    // 10. RUNIC -> Eldritch 3D Astrolabe & Floating Obelisks
    private void drawRunicAstrolabe(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        drawWaveRibbon(mat, radius, 0.015F, 0.04F, 6, (float)Math.toRadians(rot), color, 36);
        drawWaveRibbon(mat, radius * 0.75F, 0.012F, 0.04F, 6, (float)Math.toRadians(-rot), color.withAlpha(color.getAlpha() * 0.6F), 36);

        // 6 Floating 3D runic obelisks between rings
        int obelisks = 6;
        for (int i = 0; i < obelisks; i++) {
            double a = (Math.PI * 2.0 * i) / obelisks + Math.toRadians(rot * 0.8);
            float cx = (float)Math.cos(a) * (radius * 0.88F);
            float cz = (float)Math.sin(a) * (radius * 0.88F);
            float cy = (float)Math.sin(a * 3.0 + Math.toRadians(rot * 2.0)) * 0.05F;
            drawDiamondJewel(mat, cx, cy, cz, 0.032F, color);

            // Sacred hexagram connecting beam to next obelisk
            int next = (i + 2) % obelisks;
            double aNext = (Math.PI * 2.0 * next) / obelisks + Math.toRadians(rot * 0.8);
            float nx = (float)Math.cos(aNext) * (radius * 0.88F);
            float nz = (float)Math.sin(aNext) * (radius * 0.88F);
            float ny = (float)Math.sin(aNext * 3.0 + Math.toRadians(rot * 2.0)) * 0.05F;
            drawBeam(mat, cx, cy, cz, nx, ny, nz, 0.005F, color.withAlpha(color.getAlpha() * 0.45F));
        }
    }

    // 11. DEMON -> Abyssal Horned Sovereign Crown
    private void drawAbyssalHorns(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        drawWaveRibbon(mat, radius * 0.88F, 0.02F, 0.025F, 6, 0.0F, color, 32);

        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
        int cDark = new ColorRGBA(40.0F, 10.0F, 15.0F, color.getAlpha()).getRGB();
        int cBlood = color.getRGB();

        // 2 Grand 3D horns arching upwards and backwards
        for (int side = -1; side <= 1; side += 2) {
            float xBase1 = side * radius * 0.4F;
            float zBase1 = -radius * 0.3F;
            float xBase2 = side * radius * 0.8F;
            float zBase2 = -radius * 0.1F;
            float xTip = side * (radius * 1.35F);
            float zTip = radius * 0.6F;
            float yTip = 0.26F;

            bb.vertex(mat, xBase1, 0.0F, zBase1).color(cDark);
            bb.vertex(mat, xTip, yTip, zTip).color(cBlood);
            bb.vertex(mat, xBase2, 0.0F, zBase2).color(cDark);
        }
        safeDraw(bb);

        // Soul orbs orbiting horn tips
        for (int side = -1; side <= 1; side += 2) {
            float hx = side * (radius * 1.35F);
            float hz = radius * 0.6F;
            float hy = 0.28F + (float)Math.sin(Math.toRadians(rot * 3.0)) * 0.025F;
            drawDiamondJewel(mat, hx, hy, hz, 0.026F, new ColorRGBA(255.0F, 40.0F, 80.0F, 255.0F));
        }
    }

    // 12. LOTUS -> 3D Thousand-Petal Astral Blossom
    private void drawAstralLotus(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        // Inner tier: 6 petals arched upwards
        drawWaveRibbon(mat, radius * 0.50F, 0.015F, 0.06F, 6, (float)Math.toRadians(rot), color, 36);
        // Outer tier: 12 petals fanning wide
        drawWaveRibbon(mat, radius * 1.10F, 0.020F, 0.03F, 12, (float)Math.toRadians(-rot), color.withAlpha(color.getAlpha() * 0.75F), 48);

        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
        int cCenter = color.withAlpha(color.getAlpha() * 0.4F).getRGB();
        int cTip = color.getRGB();
        int petals = 8;
        for (int i = 0; i < petals; i++) {
            double a = (Math.PI * 2.0 * i) / petals;
            double aNext = (Math.PI * 2.0 * (i + 1)) / petals;
            float x1 = (float)Math.cos(a) * radius * 0.45F;
            float z1 = (float)Math.sin(a) * radius * 0.45F;
            float x2 = (float)Math.cos(aNext) * radius * 0.45F;
            float z2 = (float)Math.sin(aNext) * radius * 0.45F;
            double aMid = (a + aNext) / 2.0;
            float xTip = (float)Math.cos(aMid) * radius * 0.95F;
            float zTip = (float)Math.sin(aMid) * radius * 0.95F;

            bb.vertex(mat, x1, 0.0F, z1).color(cCenter);
            bb.vertex(mat, xTip, 0.09F, zTip).color(cTip);
            bb.vertex(mat, x2, 0.0F, z2).color(cCenter);
        }
        safeDraw(bb);
        drawDiamondJewel(mat, 0.0F, 0.05F, 0.0F, 0.038F, color);
    }

    // 13. GALAXY -> 3D Cosmic Spiral Nebula & Accretion Funnel
    private void drawCosmicGalaxy(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        drawWaveRibbon(mat, radius, 0.025F, 0.06F, 2, (float)Math.toRadians(rot * 2), color, 40);
        drawWaveRibbon(mat, radius * 0.65F, 0.020F, 0.04F, 2, (float)Math.toRadians(rot * 2 + 180), color.withAlpha(color.getAlpha() * 0.8F), 32);

        // 12 Orbiting Keplerian stardust jewels
        int stars = 12;
        for (int i = 0; i < stars; i++) {
            double a = (Math.PI * 2.0 * i) / stars + Math.toRadians(rot * (1.0 + (i % 3) * 0.5));
            float r = radius * (0.35F + 0.65F * (i / (float)stars));
            float x = (float)Math.cos(a) * r;
            float z = (float)Math.sin(a) * r;
            float y = (float)Math.sin(a * 2.0) * 0.04F;
            drawDiamondJewel(mat, x, y, z, 0.016F, color);
        }
        drawDiamondJewel(mat, 0.0F, -0.04F, 0.0F, 0.045F, color);
    }

    // 14. THUNDER -> 3D Tesla Coil & Arc Plasma Cage
    private void drawTeslaPlasmaCage(Matrix4f mat, float radius, ColorRGBA color, long time) {
        // Upper & lower electrode rings
        drawWaveRibbon(mat, radius * 0.9F, 0.015F, 0.02F, 4, 0.0F, color.withAlpha(color.getAlpha() * 0.6F), 32);

        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
        int cBolt = new ColorRGBA(240.0F, 255.0F, 255.0F, 255.0F).getRGB();
        int bolts = 10;
        for (int i = 0; i < bolts; i++) {
            double a = (Math.PI * 2.0 * i) / bolts;
            float x = (float)Math.cos(a) * radius;
            float z = (float)Math.sin(a) * radius;
            float j1 = (float)Math.sin(time * 0.03 + i * 7) * 0.035F;
            float j2 = (float)Math.cos(time * 0.03 + i * 5) * 0.035F;
            // Zigzagging arc in 3D
            bb.vertex(mat, x, -0.06F, z).color(cBolt);
            bb.vertex(mat, x + j1, 0.0F, z + j2).color(cBolt);
            bb.vertex(mat, x + j1, 0.0F, z + j2).color(cBolt);
            bb.vertex(mat, x, 0.06F, z).color(cBolt);
        }
        safeDraw(bb);
        drawDiamondJewel(mat, 0.0F, 0.0F, 0.0F, 0.04F, color);
    }

    // 15. HEART -> 3D Faceted Crystal Heart
    private void drawCrystalHeart3D(Matrix4f mat, float radius, ColorRGBA color, long time, float rot) {
        // Double-beat heartbeat pulse: 1.0 -> 1.18 -> 1.05 -> 1.25 -> 1.0
        float t = (time % 1000) / 1000.0F;
        float beat = (float)(Math.sin(t * Math.PI * 2.0) * Math.exp(-t * 3.0));
        float scale = 1.0F + Math.max(0.0F, beat) * 0.22F;

        drawWaveRibbon(mat, radius * 0.9F * scale, 0.015F, 0.04F, 2, (float)Math.toRadians(rot), color.withAlpha(color.getAlpha() * 0.65F), 32);

        // 3D Faceted crystal heart in center
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
        int cTip = color.withAlpha(255.0F).getRGB();
        int cBase = color.withAlpha(color.getAlpha() * 0.7F).getRGB();
        float s = 0.07F * scale;

        // Front facets
        bb.vertex(mat, 0.0F, -s * 1.2F, 0.0F).color(cTip);
        bb.vertex(mat, -s, 0.0F, s * 0.5F).color(cBase);
        bb.vertex(mat, 0.0F, s * 0.4F, s * 0.8F).color(cTip);

        bb.vertex(mat, 0.0F, -s * 1.2F, 0.0F).color(cTip);
        bb.vertex(mat, 0.0F, s * 0.4F, s * 0.8F).color(cTip);
        bb.vertex(mat, s, 0.0F, s * 0.5F).color(cBase);

        // Back facets
        bb.vertex(mat, 0.0F, -s * 1.2F, 0.0F).color(cTip);
        bb.vertex(mat, 0.0F, s * 0.4F, -s * 0.8F).color(cTip);
        bb.vertex(mat, -s, 0.0F, -s * 0.5F).color(cBase);

        bb.vertex(mat, 0.0F, -s * 1.2F, 0.0F).color(cTip);
        bb.vertex(mat, s, 0.0F, -s * 0.5F).color(cBase);
        bb.vertex(mat, 0.0F, s * 0.4F, -s * 0.8F).color(cTip);

        safeDraw(bb);
    }

    // 16. SUN -> 3D Solaris Prominence Corona
    private void drawSolarisProminence(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        drawWaveRibbon(mat, radius * 0.70F, 0.025F, 0.03F, 8, (float)Math.toRadians(rot), color, 36);

        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
        int cCore = color.getRGB();
        int cFlare = new ColorRGBA(255.0F, 235.0F, 100.0F, 255.0F).getRGB();
        int prominences = 8;
        for (int i = 0; i < prominences; i++) {
            double a = (Math.PI * 2.0 * i) / prominences;
            float x1 = (float)Math.cos(a - 0.15) * radius * 0.70F;
            float z1 = (float)Math.sin(a - 0.15) * radius * 0.70F;
            float x2 = (float)Math.cos(a + 0.15) * radius * 0.70F;
            float z2 = (float)Math.sin(a + 0.15) * radius * 0.70F;
            float xLoop = (float)Math.cos(a) * radius * 1.40F;
            float zLoop = (float)Math.sin(a) * radius * 1.40F;
            float yLoop = 0.14F + (float)Math.sin(Math.toRadians(rot * 3.0 + i * 45)) * 0.04F;

            bb.vertex(mat, x1, 0.0F, z1).color(cCore);
            bb.vertex(mat, xLoop, yLoop, zLoop).color(cFlare);
            bb.vertex(mat, x2, 0.0F, z2).color(cCore);
        }
        safeDraw(bb);
        drawDiamondJewel(mat, 0.0F, 0.0F, 0.0F, 0.05F, color);
    }

    // 17. HEXAGON -> 3D Tiered Honeycomb Matrix
    private void drawHexMatrix3D(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        drawWaveRibbon(mat, radius, 0.02F, 0.035F, 6, 0.0F, color, 36);
        drawWaveRibbon(mat, radius * 0.65F, 0.015F, 0.035F, 6, (float)Math.PI, color.withAlpha(color.getAlpha() * 0.75F), 36);

        // 6 Hexagonal vertical pillars rising and falling
        for (int i = 0; i < 6; i++) {
            double a = (Math.PI * 2.0 * i) / 6.0;
            float x = (float)Math.cos(a) * radius;
            float z = (float)Math.sin(a) * radius;
            float y = (float)Math.sin(a * 2.0 + Math.toRadians(rot * 2.0)) * 0.06F;
            drawDiamondJewel(mat, x, y, z, 0.032F, color);
        }
    }

    // 18. BLADES -> 3D Gate of Babylon Flying Sword Array
    private void drawFloatingSwordRing(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        drawWaveRibbon(mat, radius * 0.75F, 0.012F, 0.025F, 8, (float)Math.toRadians(rot), color.withAlpha(color.getAlpha() * 0.6F), 32);

        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
        int cTip = color.withAlpha(255.0F).getRGB();
        int cBase = color.withAlpha(color.getAlpha() * 0.5F).getRGB();
        int swords = 8;
        for (int i = 0; i < swords; i++) {
            double a = (Math.PI * 2.0 * i) / swords + Math.toRadians(rot * 0.5);
            float cx = (float)Math.cos(a) * radius;
            float cz = (float)Math.sin(a) * radius;
            float bobY = (float)Math.sin(a * 2.0 + Math.toRadians(rot * 2.5)) * 0.04F;

            // Sword blade pointing downwards
            float tipY = bobY - 0.16F;
            float hiltY = bobY + 0.06F;
            float guardR = 0.035F;
            float gx = (float)Math.cos(a + Math.PI / 2.0) * guardR;
            float gz = (float)Math.sin(a + Math.PI / 2.0) * guardR;

            // Blade triangle
            bb.vertex(mat, cx - gx, bobY, cz - gz).color(cBase);
            bb.vertex(mat, cx, tipY, cz).color(cTip);
            bb.vertex(mat, cx + gx, bobY, cz + gz).color(cBase);

            // Crossguard & hilt
            bb.vertex(mat, cx - gx * 1.5F, bobY, cz - gz * 1.5F).color(cTip);
            bb.vertex(mat, cx, hiltY, cz).color(cBase);
            bb.vertex(mat, cx + gx * 1.5F, bobY, cz + gz * 1.5F).color(cTip);
        }
        safeDraw(bb);
    }

    // 19. CHRONO -> 3D Steampunk Clockwork Astrolabe
    private void drawChronoAstrolabe(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        // Lower gear ring
        drawWaveRibbon(mat, radius * 0.90F, 0.02F, 0.02F, 16, (float)Math.toRadians(rot), color, 48);
        // Upper counter-rotating gear
        drawWaveRibbon(mat, radius * 0.65F, 0.016F, 0.03F, 10, (float)Math.toRadians(-rot * 1.5), color.withAlpha(color.getAlpha() * 0.75F), 36);

        // 3D Clock hands sweeping at different rates
        float hourA = (float)Math.toRadians(rot * 0.5);
        float minA = (float)Math.toRadians(rot * 2.5);
        drawBeam(mat, 0.0F, 0.03F, 0.0F, (float)Math.cos(hourA) * radius * 0.55F, 0.03F, (float)Math.sin(hourA) * radius * 0.55F, 0.01F, color);
        drawBeam(mat, 0.0F, 0.04F, 0.0F, (float)Math.cos(minA) * radius * 0.85F, 0.04F, (float)Math.sin(minA) * radius * 0.85F, 0.007F, color);

        // 4 Pendulum bob jewels below
        for (int i = 0; i < 4; i++) {
            double a = (Math.PI * 2.0 * i) / 4.0;
            float px = (float)Math.cos(a) * radius * 0.90F;
            float pz = (float)Math.sin(a) * radius * 0.90F;
            float py = -0.06F + (float)Math.sin(Math.toRadians(rot * 3.0 + i * 90)) * 0.03F;
            drawDiamondJewel(mat, px, py, pz, 0.022F, color);
        }
        drawDiamondJewel(mat, 0.0F, 0.035F, 0.0F, 0.035F, color);
    }

    // 20. VORTEX -> 3D Gravitational Event Horizon Funnel
    private void drawSingularityFunnel(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        // Curving downward funnel ribbon
        drawWaveRibbon(mat, radius, 0.02F, -0.04F, 4, (float)Math.toRadians(rot * 2), color.withAlpha(color.getAlpha() * 0.6F), 36);
        drawWaveRibbon(mat, radius * 0.6F, 0.018F, -0.09F, 4, (float)Math.toRadians(rot * 3), color.withAlpha(color.getAlpha() * 0.85F), 32);

        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
        int cOuter = color.withAlpha(color.getAlpha() * 0.3F).getRGB();
        int cSingularity = color.withAlpha(255.0F).getRGB();
        int swirls = 8;
        for (int i = 0; i < swirls; i++) {
            double a = (Math.PI * 2.0 * i) / swirls;
            float x1 = (float)Math.cos(a) * radius;
            float z1 = (float)Math.sin(a) * radius;
            float x2 = (float)Math.cos(a + 0.45) * radius;
            float z2 = (float)Math.sin(a + 0.45) * radius;
            // Funnel plunges down to singularity at -0.16F
            float xCore = (float)Math.cos(a + 1.2) * radius * 0.15F;
            float zCore = (float)Math.sin(a + 1.2) * radius * 0.15F;

            bb.vertex(mat, x1, 0.0F, z1).color(cOuter);
            bb.vertex(mat, xCore, -0.16F, zCore).color(cSingularity);
            bb.vertex(mat, x2, 0.0F, z2).color(cOuter);
        }
        safeDraw(bb);

        // Relativistic plasma jet beam shooting vertically up from singularity
        drawBeam(mat, 0.0F, -0.16F, 0.0F, 0.0F, 0.18F, 0.0F, 0.012F, new ColorRGBA(255.0F, 255.0F, 255.0F, 255.0F));
        drawDiamondJewel(mat, 0.0F, -0.16F, 0.0F, 0.03F, color);
    }

    // ============ 15 NEW HALO STYLES ============

    // 21. ORBITAL: 3 orbiting spheres on elliptical paths
    private void drawOrbital(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        drawWaveRibbon(mat, radius, 0.015F, 0.0F, 0, 0.0F, color.withAlpha(color.getAlpha() * 0.3F), 36);
        int orbs = 3;
        for (int i = 0; i < orbs; i++) {
            double a = Math.toRadians(rot * 2.0 + (360.0 * i) / orbs);
            float ox = (float)Math.cos(a) * radius;
            float oz = (float)Math.sin(a) * radius;
            float oy = (float)Math.sin(a * 2.0) * 0.04F;
            drawDiamondJewel(mat, ox, oy, oz, 0.045F, color);
        }
    }

    // 22. ATOMIC: Nucleus + 3 tilted electron paths
    private void drawAtomic(MatrixStack m, float radius, ColorRGBA color, float rot) {
        Matrix4f mat = m.peek().getPositionMatrix();
        drawDiamondJewel(mat, 0.0F, 0.0F, 0.0F, 0.04F, color);
        float[] tilts = {0.0F, 60.0F, -60.0F};
        for (int i = 0; i < 3; i++) {
            m.push();
            m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(tilts[i]));
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rot + i * 40));
            drawWaveRibbon(m.peek().getPositionMatrix(), radius * 0.85F, 0.01F, 0.0F, 0, 0.0F, color.withAlpha(color.getAlpha() * 0.5F), 28);
            double eAng = Math.toRadians(rot * 3.0 + i * 120);
            float ex = (float)Math.cos(eAng) * radius * 0.85F;
            float ez = (float)Math.sin(eAng) * radius * 0.85F;
            drawDiamondJewel(m.peek().getPositionMatrix(), ex, 0.0F, ez, 0.02F, new ColorRGBA(255, 255, 255, color.getAlpha()));
            m.pop();
        }
    }

    // 23. PRISM: Rotating triangular prism wireframe
    private void drawPrism(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        float h = radius * 0.5F;
        int c = color.getRGB();
        for (float y : new float[]{h, -h}) {
            BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.LINES, VertexFormats.POSITION_COLOR);
            for (int i = 0; i < 3; i++) {
                double a1 = Math.toRadians(120.0 * i);
                double a2 = Math.toRadians(120.0 * (i + 1));
                bb.vertex(mat, (float)Math.cos(a1) * radius, y, (float)Math.sin(a1) * radius).color(c);
                bb.vertex(mat, (float)Math.cos(a2) * radius, y, (float)Math.sin(a2) * radius).color(c);
            }
            safeDraw(bb);
        }
        BufferBuilder vb = RenderSystem.renderThreadTesselator().begin(DrawMode.LINES, VertexFormats.POSITION_COLOR);
        for (int i = 0; i < 3; i++) {
            double a = Math.toRadians(120.0 * i);
            float x = (float)Math.cos(a) * radius;
            float z = (float)Math.sin(a) * radius;
            vb.vertex(mat, x, h, z).color(c);
            vb.vertex(mat, x, -h, z).color(c);
        }
        safeDraw(vb);
        drawDiamondJewel(mat, 0.0F, 0.0F, 0.0F, 0.025F, color);
    }

    // 24. MANDALA: Layered concentric petal rings
    private void drawMandala(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        int[] petals = {6, 12, 18};
        for (int l = 0; l < 3; l++) {
            float lr = radius * (0.4F + l * 0.3F);
            float petalLen = lr * 0.25F;
            BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
            int c = color.withAlpha(color.getAlpha() * (1.0F - l * 0.2F)).getRGB();
            for (int i = 0; i < petals[l]; i++) {
                double a = Math.toRadians((360.0 * i) / petals[l] + rot * (1 + l));
                float cx = (float)Math.cos(a) * lr;
                float cz = (float)Math.sin(a) * lr;
                float tx = (float)Math.cos(a) * (lr + petalLen);
                float tz = (float)Math.sin(a) * (lr + petalLen);
                float nx = (float)(-Math.sin(a)) * petalLen * 0.35F;
                float nz = (float)(Math.cos(a)) * petalLen * 0.35F;
                bb.vertex(mat, tx, 0.0F, tz).color(c);
                bb.vertex(mat, cx + nx, 0.0F, cz + nz).color(c);
                bb.vertex(mat, cx - nx, 0.0F, cz - nz).color(c);
            }
            safeDraw(bb);
        }
    }

    // 25. ECLIPSE: Moon disc occluding sun ring with corona
    private void drawEclipse(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        drawWaveRibbon(mat, radius, 0.025F, 0.01F, 6, (float)Math.toRadians(rot), color, 36);
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_FAN, VertexFormats.POSITION_COLOR);
        int dark = new ColorRGBA(10, 5, 20, color.getAlpha()).getRGB();
        int edge = color.withAlpha(color.getAlpha() * 0.3F).getRGB();
        bb.vertex(mat, 0.0F, 0.0F, 0.0F).color(dark);
        for (int i = 0; i <= 24; i++) {
            double a = (Math.PI * 2.0 * i) / 24;
            bb.vertex(mat, (float)Math.cos(a) * radius * 0.6F, 0.0F, (float)Math.sin(a) * radius * 0.6F).color(edge);
        }
        safeDraw(bb);
        BufferBuilder rays = RenderSystem.renderThreadTesselator().begin(DrawMode.LINES, VertexFormats.POSITION_COLOR);
        int rc = color.getRGB();
        for (int i = 0; i < 12; i++) {
            double a = Math.toRadians(30.0 * i + rot * 0.5);
            rays.vertex(mat, (float)Math.cos(a) * radius * 0.65F, 0.0F, (float)Math.sin(a) * radius * 0.65F).color(rc);
            rays.vertex(mat, (float)Math.cos(a) * radius * 1.1F, 0.0F, (float)Math.sin(a) * radius * 1.1F).color(rc);
        }
        safeDraw(rays);
    }

    // 26. INFINITY: Lemniscate (figure-8) loop
    private void drawInfinity(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
        int c = color.getRGB();
        int segs = 64;
        float thick = 0.02F;
        for (int i = 0; i <= segs; i++) {
            double t = (Math.PI * 2.0 * i) / segs;
            float denom = 1.0F + (float)(Math.sin(t) * Math.sin(t));
            float x = (float)(Math.cos(t) / denom) * radius;
            float z = (float)(Math.sin(t) * Math.cos(t) / denom) * radius;
            float nx = (float)(-Math.sin(t));
            float nz = (float)(Math.cos(t));
            float len = (float)Math.sqrt(nx * nx + nz * nz);
            if (len > 0.001F) { nx /= len; nz /= len; }
            bb.vertex(mat, x + nx * thick, 0.0F, z + nz * thick).color(c);
            bb.vertex(mat, x - nx * thick, 0.0F, z - nz * thick).color(c);
        }
        safeDraw(bb);
    }

    // 27. NEBULA: Scattered gas cloud particles
    private void drawNebula(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
        float radR = (float)Math.toRadians(rot);
        for (int i = 0; i < 30; i++) {
            float seed = i * 1.618F;
            float a = seed * 2.4F + radR * (0.5F + (i % 3) * 0.3F);
            float dist = radius * (0.3F + 0.7F * ((float)Math.sin(seed * 3.1F) * 0.5F + 0.5F));
            float x = (float)Math.cos(a) * dist;
            float z = (float)Math.sin(a) * dist;
            float y = (float)Math.sin(seed * 2.0F + radR) * 0.04F;
            float s = 0.015F + 0.01F * ((float)Math.sin(seed * 4.0F) * 0.5F + 0.5F);
            float al = 0.3F + 0.5F * ((float)Math.cos(seed * 5.0F) * 0.5F + 0.5F);
            int c = color.withAlpha(color.getAlpha() * al).getRGB();
            bb.vertex(mat, x, y + s, z).color(c);
            bb.vertex(mat, x - s, y - s * 0.5F, z).color(c);
            bb.vertex(mat, x + s, y - s * 0.5F, z).color(c);
        }
        safeDraw(bb);
        drawWaveRibbon(mat, radius, 0.01F, 0.02F, 3, radR, color.withAlpha(color.getAlpha() * 0.25F), 28);
    }

    // 28. CLOCKWORK: Gear with teeth
    private void drawClockwork(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        int teeth = 12;
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
        int c = color.getRGB();
        int cInner = color.withAlpha(color.getAlpha() * 0.5F).getRGB();
        float innerR = radius * 0.7F;
        float toothH = radius * 0.15F;
        for (int i = 0; i <= teeth * 2; i++) {
            double a = (Math.PI * 2.0 * i) / (teeth * 2);
            boolean isTooth = (i % 2 == 0);
            float r = isTooth ? radius + toothH : radius;
            bb.vertex(mat, (float)Math.cos(a) * r, 0.0F, (float)Math.sin(a) * r).color(c);
            bb.vertex(mat, (float)Math.cos(a) * innerR, 0.0F, (float)Math.sin(a) * innerR).color(cInner);
        }
        safeDraw(bb);
        drawDiamondJewel(mat, 0.0F, 0.0F, 0.0F, 0.03F, color);
        BufferBuilder sp = RenderSystem.renderThreadTesselator().begin(DrawMode.LINES, VertexFormats.POSITION_COLOR);
        for (int i = 0; i < 4; i++) {
            double a = Math.toRadians(90.0 * i + rot);
            sp.vertex(mat, 0.0F, 0.0F, 0.0F).color(c);
            sp.vertex(mat, (float)Math.cos(a) * innerR, 0.0F, (float)Math.sin(a) * innerR).color(c);
        }
        safeDraw(sp);
    }

    // 29. SPIRAL: Nautilus spiral arm
    private void drawSpiral(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
        int segs = 80;
        float thick = 0.015F;
        for (int i = 0; i <= segs; i++) {
            float t = (float) i / segs;
            float spiralR = radius * 0.1F + radius * 0.9F * t;
            double a = t * Math.PI * 6.0 + Math.toRadians(rot);
            float x = (float)Math.cos(a) * spiralR;
            float z = (float)Math.sin(a) * spiralR;
            float al = 0.2F + 0.8F * t;
            int c = color.withAlpha(color.getAlpha() * al).getRGB();
            bb.vertex(mat, x, thick, z).color(c);
            bb.vertex(mat, x, -thick, z).color(c);
        }
        safeDraw(bb);
    }

    // 30. CUBES: Orbiting small wireframe cubes
    private void drawCubes(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        drawWaveRibbon(mat, radius, 0.008F, 0.0F, 0, 0.0F, color.withAlpha(color.getAlpha() * 0.2F), 28);
        int cubes = 6;
        float cubeSize = 0.035F;
        for (int ci = 0; ci < cubes; ci++) {
            double a = Math.toRadians((360.0 * ci) / cubes + rot * 1.5);
            float cx = (float)Math.cos(a) * radius;
            float cz = (float)Math.sin(a) * radius;
            float cy = (float)Math.sin(a * 2.0 + rot * 0.02) * 0.03F;
            BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.LINES, VertexFormats.POSITION_COLOR);
            int c = color.getRGB();
            float s = cubeSize;
            float[][] corners = {
                {cx-s,cy-s,cz-s},{cx+s,cy-s,cz-s},{cx+s,cy+s,cz-s},{cx-s,cy+s,cz-s},
                {cx-s,cy-s,cz+s},{cx+s,cy-s,cz+s},{cx+s,cy+s,cz+s},{cx-s,cy+s,cz+s}
            };
            int[][] edges = {{0,1},{1,2},{2,3},{3,0},{4,5},{5,6},{6,7},{7,4},{0,4},{1,5},{2,6},{3,7}};
            for (int[] e : edges) {
                bb.vertex(mat, corners[e[0]][0], corners[e[0]][1], corners[e[0]][2]).color(c);
                bb.vertex(mat, corners[e[1]][0], corners[e[1]][1], corners[e[1]][2]).color(c);
            }
            safeDraw(bb);
        }
    }

    // 31. COMPASS: Cardinal direction points
    private void drawCompass(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        drawWaveRibbon(mat, radius, 0.015F, 0.0F, 0, 0.0F, color, 36);
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
        int c = color.getRGB();
        int cDark = color.withAlpha(color.getAlpha() * 0.5F).getRGB();
        float tipR = radius * 1.25F;
        float baseW = radius * 0.12F;
        for (int i = 0; i < 4; i++) {
            double a = Math.toRadians(90.0 * i);
            float tx = (float)Math.cos(a) * tipR;
            float tz = (float)Math.sin(a) * tipR;
            float nx = (float)(-Math.sin(a)) * baseW;
            float nz = (float)(Math.cos(a)) * baseW;
            int cc = (i == 0) ? c : cDark;
            bb.vertex(mat, tx, 0.0F, tz).color(cc);
            bb.vertex(mat, nx, 0.0F, nz).color(cc);
            bb.vertex(mat, -nx, 0.0F, -nz).color(cc);
        }
        safeDraw(bb);
        drawDiamondJewel(mat, 0.0F, 0.0F, 0.0F, 0.025F, color);
    }

    // 32. EYE: All-seeing eye shape
    private void drawEye(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
        int c = color.withAlpha(color.getAlpha() * 0.6F).getRGB();
        int segs = 24;
        for (int i = 0; i <= segs; i++) {
            float t = (float) i / segs;
            double a = Math.PI * t;
            float x = (float)Math.cos(a) * radius;
            float zTop = (float)Math.sin(a) * radius * 0.4F;
            float zBot = -(float)Math.sin(a) * radius * 0.4F;
            bb.vertex(mat, x, 0.0F, zTop).color(c);
            bb.vertex(mat, x, 0.0F, zBot).color(c);
        }
        safeDraw(bb);
        drawWaveRibbon(mat, radius * 0.3F, 0.015F, 0.0F, 0, 0.0F, color, 20);
        drawDiamondJewel(mat, 0.0F, 0.0F, 0.0F, 0.04F, new ColorRGBA(10, 0, 30, color.getAlpha()));
    }

    // 33. SHIELD: Layered hexagonal shield panels
    private void drawShield(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        for (int l = 0; l < 2; l++) {
            float lr = radius * (0.6F + l * 0.4F);
            float yOff = l * 0.03F;
            BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_FAN, VertexFormats.POSITION_COLOR);
            int ci = color.withAlpha(color.getAlpha() * (0.3F - l * 0.1F)).getRGB();
            int ce = color.withAlpha(color.getAlpha() * (0.6F - l * 0.15F)).getRGB();
            bb.vertex(mat, 0.0F, yOff, 0.0F).color(ci);
            for (int i = 0; i <= 6; i++) {
                double a = (Math.PI * 2.0 * i) / 6 + Math.toRadians(rot * (l + 1));
                bb.vertex(mat, (float)Math.cos(a) * lr, yOff, (float)Math.sin(a) * lr).color(ce);
            }
            safeDraw(bb);
        }
        drawWaveRibbon(mat, radius, 0.02F, 0.0F, 0, 0.0F, color, 6);
    }

    // 34. WEB: Spider web radial + concentric pattern
    private void drawWeb(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        int spokes = 8;
        int c = color.getRGB();
        BufferBuilder sb = RenderSystem.renderThreadTesselator().begin(DrawMode.LINES, VertexFormats.POSITION_COLOR);
        for (int i = 0; i < spokes; i++) {
            double a = (Math.PI * 2.0 * i) / spokes;
            sb.vertex(mat, 0.0F, 0.0F, 0.0F).color(c);
            sb.vertex(mat, (float)Math.cos(a) * radius, 0.0F, (float)Math.sin(a) * radius).color(c);
        }
        safeDraw(sb);
        for (int r = 1; r <= 4; r++) {
            float rr = radius * r / 4;
            drawWaveRibbon(mat, rr, 0.008F, 0.0F, 0, 0.0F, color.withAlpha(color.getAlpha() * (0.3F + 0.2F * r)), spokes);
        }
    }

    // 35. CHAINS: Linked chain loops
    private void drawChains(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        int links = 16;
        float linkW = 0.035F;
        float linkH = 0.02F;
        int c = color.getRGB();
        for (int i = 0; i < links; i++) {
            double a = (Math.PI * 2.0 * i) / links + Math.toRadians(rot);
            float cx = (float)Math.cos(a) * radius;
            float cz = (float)Math.sin(a) * radius;
            BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
            for (int j = 0; j <= 12; j++) {
                double la = (Math.PI * 2.0 * j) / 12;
                float lx = cx + (float)Math.cos(la) * linkW * (float)Math.cos(a);
                float ly = (float)Math.sin(la) * linkH;
                float lz = cz + (float)Math.cos(la) * linkW * (float)Math.sin(a);
                float thick = 0.006F;
                bb.vertex(mat, lx, ly + thick, lz).color(c);
                bb.vertex(mat, lx, ly - thick, lz).color(c);
            }
            safeDraw(bb);
        }
    }

    // 36. SUPERNOVA: Exploding starburst with corona rays
    private void drawSupernova(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        drawSolidRing(mat, radius * 0.4F, 0.015F, color, 32);
        int rays = 16;
        for (int i = 0; i < rays; i++) {
            double a = (Math.PI * 2.0 * i / rays) + Math.toRadians(rot);
            float rOuter = (i % 2 == 0) ? radius * 1.25F : radius * 0.85F;
            float x1 = (float)Math.cos(a) * (radius * 0.4F), z1 = (float)Math.sin(a) * (radius * 0.4F);
            float x2 = (float)Math.cos(a) * rOuter, z2 = (float)Math.sin(a) * rOuter;
            drawBeam(mat, x1, 0.0F, z1, x2, 0.0F, z2, 0.018F, color);
        }
        drawDiamondJewel(mat, 0.0F, 0.0F, 0.0F, 0.06F, color);
    }

    // 37. QUANTUM RINGS: 3 orthogonal gyroscope gyro rings
    private void drawQuantumRings(MatrixStack matrices, float radius, ColorRGBA color, float rot) {
        matrices.push();
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rot));
        drawSolidRing(matrices.peek().getPositionMatrix(), radius, 0.012F, color, 36);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(60.0F + rot * 0.5F));
        drawSolidRing(matrices.peek().getPositionMatrix(), radius * 0.88F, 0.010F, color.mulAlpha(0.85F), 32);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(60.0F + rot * 0.5F));
        drawSolidRing(matrices.peek().getPositionMatrix(), radius * 0.76F, 0.008F, color.mulAlpha(0.70F), 28);
        matrices.pop();
    }

    // 38. CYBER MATRIX: Holographic digital cube cage
    private void drawCyberMatrix(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        float s = radius * 0.70F;
        int c = color.getRGB();
        int cEdge = color.mulAlpha(0.5F).getRGB();
        // 12 edges of a cube
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.LINES, VertexFormats.POSITION_COLOR);
        float[] corners = {-s, s};
        for (float x : corners) {
            for (float y : corners) {
                bb.vertex(mat, x, y, -s).color(c);
                bb.vertex(mat, x, y, s).color(c);
            }
        }
        for (float x : corners) {
            for (float z : corners) {
                bb.vertex(mat, x, -s, z).color(cEdge);
                bb.vertex(mat, x, s, z).color(cEdge);
            }
        }
        for (float y : corners) {
            for (float z : corners) {
                bb.vertex(mat, -s, y, z).color(c);
                bb.vertex(mat, s, y, z).color(c);
            }
        }
        safeDraw(bb);
        drawSolidRing(mat, radius, 0.008F, color, 32);
    }

    // 39. ANGEL TRIPLE: Triple tiered cascading celestial rings
    private void drawAngelTriple(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        drawSolidRing(mat, radius, 0.012F, color, 36);
        drawWaveRibbon(mat, radius * 0.75F, 0.010F, 0.04F, 6, (float)Math.toRadians(rot), color.mulAlpha(0.85F), 32);
        drawSolidRing(mat, radius * 0.50F, 0.008F, color.mulAlpha(0.65F), 24);
    }

    // 40. BLACK HOLE: Accretion disk with singularity
    private void drawBlackHole(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        drawSolidRing(mat, radius, 0.025F, color, 36);
        drawSolidRing(mat, radius * 0.7F, 0.018F, color.mulAlpha(0.6F), 32);
        drawDiamondJewel(mat, 0.0F, 0.0F, 0.0F, 0.05F, new ColorRGBA(10, 10, 15, 255));
    }

    // 41. RUNESTONE: 8 floating ancient rune monoliths
    private void drawRunestone(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        int stones = 8;
        for (int i = 0; i < stones; i++) {
            double a = (Math.PI * 2.0 * i / stones) + Math.toRadians(rot);
            float cx = (float)Math.cos(a) * radius;
            float cz = (float)Math.sin(a) * radius;
            float cy = (float)Math.sin(rot * 0.05F + i) * 0.03F;
            drawDiamondJewel(mat, cx, cy, cz, 0.035F, color);
            drawDiamondJewel(mat, cx, cy + 0.06F, cz, 0.02F, color.mulAlpha(0.8F));
        }
        drawSolidRing(mat, radius * 0.85F, 0.006F, color.mulAlpha(0.5F), 32);
    }

    // 42. HYDRA SERPENTS: Twin spectral dragons encircling
    private void drawHydraSerpents(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        drawWaveRibbon(mat, radius, 0.016F, 0.06F, 3, (float)Math.toRadians(rot), color, 40);
        drawWaveRibbon(mat, radius, 0.016F, 0.06F, 3, (float)Math.toRadians(rot + 180.0F), color.mulAlpha(0.7F), 40);
    }

    // 43. PIXEL RETRO: 8-bit arcade diamond pixels orbiting
    private void drawPixelRetro(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        int pixels = 12;
        for (int i = 0; i < pixels; i++) {
            double a = (Math.PI * 2.0 * i / pixels) + Math.toRadians(rot);
            float px = (float)Math.cos(a) * radius;
            float pz = (float)Math.sin(a) * radius;
            drawDiamondJewel(mat, px, 0.0F, pz, 0.025F, (i % 2 == 0) ? color : color.mulAlpha(0.5F));
        }
    }

    // 44. VALKYRIE FEATHERS: Arched golden valkyrie wings halo
    private void drawValkyrieFeathers(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        drawSolidRing(mat, radius * 0.8F, 0.008F, color, 32);
        int feathers = 10;
        for (int i = 0; i < feathers; i++) {
            double a = (Math.PI * 2.0 * i / feathers) + Math.toRadians(rot);
            float x1 = (float)Math.cos(a) * (radius * 0.8F);
            float z1 = (float)Math.sin(a) * (radius * 0.8F);
            float x2 = (float)Math.cos(a + 0.3) * (radius * 1.2F);
            float z2 = (float)Math.sin(a + 0.3) * (radius * 1.2F);
            drawBeam(mat, x1, 0.0F, z1, x2, 0.05F, z2, 0.015F, color);
        }
    }

    // 45. DARK MATTER: Pulsing dark energy spikes
    private void drawDarkMatter(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        ColorRGBA dark = new ColorRGBA(30, 10, 50, color.getAlpha());
        drawSolidRing(mat, radius, 0.02F, dark, 32);
        int spikes = 14;
        for (int i = 0; i < spikes; i++) {
            double a = (Math.PI * 2.0 * i / spikes) + Math.toRadians(rot);
            float rOut = (i % 2 == 0) ? radius * 1.3F : radius * 0.9F;
            float x2 = (float)Math.cos(a) * rOut, z2 = (float)Math.sin(a) * rOut;
            drawBeam(mat, 0.0F, 0.0F, 0.0F, x2, 0.0F, z2, 0.012F, color);
        }
    }

    // 46. PLASMA CORE: High energy plasma reactor coils
    private void drawPlasmaCore(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        drawWaveRibbon(mat, radius, 0.014F, 0.08F, 8, (float)Math.toRadians(rot * 2.0F), color, 48);
        drawSolidRing(mat, radius * 0.6F, 0.015F, color.mulAlpha(0.9F), 32);
    }

    // 47. STARLIGHT CHIME: Dangling crystal shards
    private void drawStarlightChime(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        drawSolidRing(mat, radius, 0.008F, color, 36);
        int chimes = 8;
        for (int i = 0; i < chimes; i++) {
            double a = (Math.PI * 2.0 * i / chimes) + Math.toRadians(rot);
            float cx = (float)Math.cos(a) * radius;
            float cz = (float)Math.sin(a) * radius;
            float drop = 0.08F + (float)Math.sin(rot * 0.08F + i) * 0.02F;
            drawBeam(mat, cx, 0.0F, cz, cx, -drop, cz, 0.004F, color);
            drawDiamondJewel(mat, cx, -drop, cz, 0.022F, color);
        }
    }

    // 48. SACRED GEOMETRY: Metatron's cube interlocking triangles
    private void drawSacredGeometry(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        drawSolidRing(mat, radius, 0.008F, color, 36);
        for (int tri = 0; tri < 2; tri++) {
            float offA = tri * 60.0F + rot;
            for (int i = 0; i < 3; i++) {
                double a1 = Math.toRadians(offA + i * 120.0F);
                double a2 = Math.toRadians(offA + ((i + 1) % 3) * 120.0F);
                drawBeam(mat, (float)Math.cos(a1) * radius, 0.0F, (float)Math.sin(a1) * radius,
                              (float)Math.cos(a2) * radius, 0.0F, (float)Math.sin(a2) * radius, 0.010F, color);
            }
        }
    }

    // 49. SOLAR WHEEL: Ancient sun chariot wheel
    private void drawSolarWheel(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        drawSolidRing(mat, radius, 0.014F, color, 36);
        drawSolidRing(mat, radius * 0.3F, 0.010F, color, 24);
        int spokes = 8;
        for (int i = 0; i < spokes; i++) {
            double a = (Math.PI * 2.0 * i / spokes) + Math.toRadians(rot);
            drawBeam(mat, 0.0F, 0.0F, 0.0F, (float)Math.cos(a) * radius, 0.0F, (float)Math.sin(a) * radius, 0.010F, color);
        }
    }

    // 50. FROST LOTUS: Crystalline 8-petal ice blossom
    private void drawFrostLotus(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        int petals = 8;
        for (int i = 0; i < petals; i++) {
            double a = (Math.PI * 2.0 * i / petals) + Math.toRadians(rot);
            float px = (float)Math.cos(a) * radius;
            float pz = (float)Math.sin(a) * radius;
            drawDiamondJewel(mat, px, 0.04F, pz, 0.038F, color);
            drawDiamondJewel(mat, px * 0.55F, 0.02F, pz * 0.55F, 0.025F, color.mulAlpha(0.7F));
        }
        drawDiamondJewel(mat, 0.0F, 0.05F, 0.0F, 0.04F, color);
    }

    // 51. THUNDER STORM: Jagged electric lightning arcs
    private void drawThunderStorm(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        drawSolidRing(mat, radius, 0.008F, color.mulAlpha(0.4F), 32);
        int arcs = 8;
        for (int i = 0; i < arcs; i++) {
            double a1 = (Math.PI * 2.0 * i / arcs) + Math.toRadians(rot);
            double a2 = (Math.PI * 2.0 * ((i + 1) % arcs) / arcs) + Math.toRadians(rot);
            float midA = (float)((a1 + a2) * 0.5);
            float midR = radius + ((i % 2 == 0) ? 0.06F : -0.06F);
            float x1 = (float)Math.cos(a1) * radius, z1 = (float)Math.sin(a1) * radius;
            float mx = (float)Math.cos(midA) * midR, mz = (float)Math.sin(midA) * midR;
            float x2 = (float)Math.cos(a2) * radius, z2 = (float)Math.sin(a2) * radius;
            drawBeam(mat, x1, 0.0F, z1, mx, 0.02F, mz, 0.012F, color);
            drawBeam(mat, mx, 0.02F, mz, x2, 0.0F, z2, 0.012F, color);
        }
    }

    // 52. DEMON SIGIL: Demonic summoning seal
    private void drawDemonSigil(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        ColorRGBA demonRed = new ColorRGBA(220, 20, 50, color.getAlpha());
        drawSolidRing(mat, radius, 0.012F, demonRed, 36);
        drawSolidRing(mat, radius * 0.6F, 0.008F, demonRed.mulAlpha(0.7F), 28);
        int points = 5;
        for (int i = 0; i < points; i++) {
            double a1 = (Math.PI * 2.0 * i / points) + Math.toRadians(rot);
            double a2 = (Math.PI * 2.0 * ((i + 2) % points) / points) + Math.toRadians(rot);
            drawBeam(mat, (float)Math.cos(a1) * radius, 0.0F, (float)Math.sin(a1) * radius,
                          (float)Math.cos(a2) * radius, 0.0F, (float)Math.sin(a2) * radius, 0.010F, demonRed);
        }
    }

    // 53. CHRONO GEARS: Interlocking clockwork brass gears
    private void drawChronoGears(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        drawSolidRing(mat, radius * 0.85F, 0.012F, color, 32);
        int teeth = 12;
        for (int i = 0; i < teeth; i++) {
            double a = (Math.PI * 2.0 * i / teeth) + Math.toRadians(rot);
            float x1 = (float)Math.cos(a) * (radius * 0.82F), z1 = (float)Math.sin(a) * (radius * 0.82F);
            float x2 = (float)Math.cos(a) * (radius * 1.05F), z2 = (float)Math.sin(a) * (radius * 1.05F);
            drawBeam(mat, x1, 0.0F, z1, x2, 0.0F, z2, 0.018F, color);
        }
        drawSolidRing(mat, radius * 0.35F, 0.010F, color.mulAlpha(0.8F), 20);
    }

    // 54. PRISM CROWN: Refracting multifaceted crystal tiara halo
    private void drawPrismCrown(Matrix4f mat, float radius, ColorRGBA color, float rot) {
        int gems = 7;
        for (int i = 0; i < gems; i++) {
            float progress = (float)i / (gems - 1);
            double a = Math.toRadians(-60.0F + progress * 120.0F + rot * 0.3F);
            float gx = (float)Math.cos(a) * radius;
            float gz = (float)Math.sin(a) * radius;
            float gh = 0.04F + (float)Math.sin(progress * Math.PI) * 0.08F;
            drawDiamondJewel(mat, gx, gh, gz, 0.035F, color);
        }
        drawSolidRing(mat, radius, 0.008F, color.mulAlpha(0.6F), 32);
    }

    // 55. CELESTIAL ORB: Planetary moon system with satellite orbs
    private void drawCelestialOrb(MatrixStack matrices, float radius, ColorRGBA color, float rot) {
        Matrix4f mat = matrices.peek().getPositionMatrix();
        drawDiamondJewel(mat, 0.0F, 0.0F, 0.0F, 0.06F, color);
        drawSolidRing(mat, radius, 0.006F, color.mulAlpha(0.5F), 36);
        int moons = 3;
        for (int i = 0; i < moons; i++) {
            matrices.push();
            float planeTilt = i * 45.0F;
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(planeTilt));
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rot * (1.2F + i * 0.4F)));
            Matrix4f mMat = matrices.peek().getPositionMatrix();
            drawDiamondJewel(mMat, radius * (0.6F + i * 0.25F), 0.0F, 0.0F, 0.022F, color);
            matrices.pop();
        }
    }

    public ModeSetting getModeSetting() { return this.modeSetting; }
    public SliderSetting getRadiusSetting() { return this.radiusSetting; }
    public SliderSetting getHeightOffsetSetting() { return this.heightOffsetSetting; }
    public SliderSetting getTiltSetting() { return this.tiltSetting; }
    public SliderSetting getSpeedSetting() { return this.speedSetting; }
    public BooleanSetting getSyncTheme() { return this.syncTheme; }
    public ColorSetting getCustomColor() { return this.customColor; }
}


