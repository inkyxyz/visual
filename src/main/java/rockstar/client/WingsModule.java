package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
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
    name = "Wings",
    category = ModuleCategory.PLAYER,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.wings"
)
public class WingsModule extends Module {

    private ModeSetting modeSetting;
    private ModeSetting.Nested1_42765c60 modeSeraphimAngel;
    private ModeSetting.Nested1_42765c60 modeSolarPhoenix;
    private ModeSetting.Nested1_42765c60 modeDragonSovereign;
    private ModeSetting.Nested1_42765c60 modeCyberMecha;
    private ModeSetting.Nested1_42765c60 modeArchdemon;
    private ModeSetting.Nested1_42765c60 modeTripleArchangel;
    private ModeSetting.Nested1_42765c60 modeCherubimDivine;
    private ModeSetting.Nested1_42765c60 modeOphanimSacred;
    private ModeSetting.Nested1_42765c60 modeVoidPhantom;
    private ModeSetting.Nested1_42765c60 modeMonarchFairy;
    private ModeSetting.Nested1_42765c60 modeNebulaAstral;
    private ModeSetting.Nested1_42765c60 modeCrystalliteFrost;
    private ModeSetting.Nested1_42765c60 modeDarkValkyrie;
    private ModeSetting.Nested1_42765c60 modePrismaticShard;
    private ModeSetting.Nested1_42765c60 modeCelestialDiamond;
    private ModeSetting.Nested1_42765c60 modeVoidCrystalline;

    private SliderSetting scaleSetting;
    private SliderSetting speedSetting;
    private SliderSetting angleSetting;
    private SliderSetting spreadSetting;
    private SliderSetting yOffset;
    private BooleanSetting glowEdges;
    private BooleanSetting themeSync;
    private ColorSetting primaryColor;
    private ColorSetting accentColor;
    private float smoothBankRoll = 0.0F;

    private final IiIIIiII_Class69<Render3DEvent> renderEvent = this::onRender3D;

    public WingsModule() {
        this.initSettings();
    }

    private void initSettings() {
        this.modeSetting = new ModeSetting(this, "Wing Model");
        this.modeSeraphimAngel = new ModeSetting.Nested1_42765c60(this.modeSetting, "Seraphim Angel").select();
        this.modeSolarPhoenix = new ModeSetting.Nested1_42765c60(this.modeSetting, "Solar Phoenix");
        this.modeDragonSovereign = new ModeSetting.Nested1_42765c60(this.modeSetting, "Dragon Sovereign");
        this.modeCyberMecha = new ModeSetting.Nested1_42765c60(this.modeSetting, "Cyber Mecha");
        this.modeArchdemon = new ModeSetting.Nested1_42765c60(this.modeSetting, "Archdemon");
        this.modeTripleArchangel = new ModeSetting.Nested1_42765c60(this.modeSetting, "Archangel Triple Wings");
        this.modeCherubimDivine = new ModeSetting.Nested1_42765c60(this.modeSetting, "Cherubim Divine Wings");
        this.modeOphanimSacred = new ModeSetting.Nested1_42765c60(this.modeSetting, "Ophanim Sacred Wings");
        this.modeVoidPhantom = new ModeSetting.Nested1_42765c60(this.modeSetting, "Void Phantom");
        this.modeMonarchFairy = new ModeSetting.Nested1_42765c60(this.modeSetting, "Monarch Fairy");
        this.modeNebulaAstral = new ModeSetting.Nested1_42765c60(this.modeSetting, "Nebula Astral Wings");
        this.modeCrystalliteFrost = new ModeSetting.Nested1_42765c60(this.modeSetting, "Crystallite Frost Wings");
        this.modeDarkValkyrie = new ModeSetting.Nested1_42765c60(this.modeSetting, "Dark Valkyrie Wings");
        this.modePrismaticShard = new ModeSetting.Nested1_42765c60(this.modeSetting, "Prismatic Shard Wings");
        this.modeCelestialDiamond = new ModeSetting.Nested1_42765c60(this.modeSetting, "Celestial Diamond Wings");
        this.modeVoidCrystalline = new ModeSetting.Nested1_42765c60(this.modeSetting, "Void Crystalline Wings");

        this.scaleSetting = new SliderSetting(this, "Scale")
            .I_method_c8c9a7d7(0.5F).i_method_65e2aff7(2.5F).II_method_b0f56334(0.05F).Ii_method_4e0e6b54(1.0F);

        this.speedSetting = new SliderSetting(this, "Flap Speed")
            .I_method_c8c9a7d7(0.2F).i_method_65e2aff7(3.0F).II_method_b0f56334(0.1F).Ii_method_4e0e6b54(1.0F);

        this.angleSetting = new SliderSetting(this, "Flap Angle")
            .I_method_c8c9a7d7(10.0F).i_method_65e2aff7(65.0F).II_method_b0f56334(2.0F).Ii_method_4e0e6b54(35.0F);

        this.spreadSetting = new SliderSetting(this, "Wing Spread")
            .I_method_c8c9a7d7(-25.0F).i_method_65e2aff7(45.0F).II_method_b0f56334(1.0F).Ii_method_4e0e6b54(12.0F);

        this.yOffset = new SliderSetting(this, "Height Offset")
            .I_method_c8c9a7d7(-0.5F).i_method_65e2aff7(0.5F).II_method_b0f56334(0.02F).Ii_method_4e0e6b54(0.0F);

        this.glowEdges = new BooleanSetting(this, "Emissive Glow").I_method_decd82b5();
        this.themeSync = new BooleanSetting(this, "Sync Theme").I_method_decd82b5();

        this.primaryColor = new ColorSetting(this, "Primary Color", this.themeSync::i_method_9b12da03)
            .I_method_a62f5dd6(new ColorRGBA(245.0F, 245.0F, 255.0F, 255.0F));

        this.accentColor = new ColorSetting(this, "Accent Color", this.themeSync::i_method_9b12da03)
            .I_method_a62f5dd6(new ColorRGBA(255.0F, 190.0F, 60.0F, 255.0F));
    }

    @Override
    public String i_method_bf522194() {
        return "Кастомизируемые 3D крылья с 6 уникальными моделями, тонкой настройкой физики взмахов, размера и цветов.";
    }

    private void onRender3D(Render3DEvent event) {
        MinecraftClient mc = MinecraftClient.getInstance();
        ClientPlayerEntity player = mc.player;
        if (player == null || mc.world == null) return;
        if (mc.options.getPerspective().isFirstPerson()) return;

        float tickDelta = mc.getRenderTickCounter().getTickDelta(false);
        Vec3d camPos = event.getCamera().getPos();

        double px = MathHelper.lerp(tickDelta, player.lastRenderX, player.getX());
        double py = MathHelper.lerp(tickDelta, player.lastRenderY, player.getY());
        double pz = MathHelper.lerp(tickDelta, player.lastRenderZ, player.getZ());
        float bodyYaw = MathHelper.lerpAngleDegrees(tickDelta, player.prevBodyYaw, player.bodyYaw);

        float speed = this.speedSetting.Ii_method_a20abcd2();
        float maxAngle = this.angleSetting.Ii_method_a20abcd2();
        float spread = this.spreadSetting.Ii_method_a20abcd2();
        float flyBoost = (player.isGliding() || !player.isOnGround()) ? 1.45F : 1.0F;
        float time = (player.age + tickDelta) * 0.16F * speed * flyBoost;

        float turnDiff = MathHelper.wrapDegrees(player.bodyYaw - player.prevBodyYaw);
        float targetBank = MathHelper.clamp(turnDiff * 0.8F, -14.0F, 14.0F);
        this.smoothBankRoll += (targetBank - this.smoothBankRoll) * 0.18F;

        boolean isFalling = player.getVelocity().y < -0.15 && !player.isOnGround();
        float fallFlapOffset = isFalling ? 18.0F : 0.0F;

        float flapProgress = (float)((Math.sin(time) + 1.0) * 0.5);
        float flapAngle = 12.0F + flapProgress * (maxAngle * 0.85F) + fallFlapOffset;
        float flapRoll = (float) Math.sin(time) * 5.0F + this.smoothBankRoll;

        ColorRGBA pCol = this.themeSync.i_method_9b12da03() ? IiiiiIIIi_Class242.I_method_7df8e08e() : this.primaryColor.I_method_bde5f08e();
        ColorRGBA aCol = this.themeSync.i_method_9b12da03() ? IiiiiIIIi_Class242.i_method_5dfec6e() : this.accentColor.I_method_bde5f08e();
        int prim = pCol.getRGB();
        int acc = aCol.getRGB();

        float scale = this.scaleSetting.Ii_method_a20abcd2() * 1.3F;
        float yOff = this.yOffset.Ii_method_a20abcd2();

        MatrixStack matrices = event.getMatrices();
        matrices.push();
        try {
            matrices.translate(px - camPos.x, py - camPos.y, pz - camPos.z);
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-bodyYaw + 180.0F));

            boolean hasChestplate = !player.getEquippedStack(net.minecraft.entity.EquipmentSlot.CHEST).isEmpty();
            float armorOffset = hasChestplate ? 0.045F : 0.0F;

            float torsoHeight = player.getHeight() * 0.65F + yOff;
            if (player.isGliding()) {
                float glidePitch = MathHelper.lerp(tickDelta, player.prevPitch, player.getPitch());
                matrices.translate(0.0, torsoHeight - 0.45, 0.16 + armorOffset);
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(glidePitch + 85.0F));
            } else if (player.isSwimming()) {
                float lean = player.getLeaningPitch(tickDelta);
                matrices.translate(0.0, torsoHeight - lean * 0.40, 0.16 + armorOffset);
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(lean * 85.0F));
            } else if (player.isInSneakingPose() || player.isSneaking()) {
                matrices.translate(0.0, torsoHeight - 0.20, 0.18 + armorOffset);
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(28.0F));
            } else {
                matrices.translate(0.0, torsoHeight, 0.155 + armorOffset);
            }

            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.disableCull();
            RenderSystem.enableDepthTest();
            RenderSystem.depthMask(true);
            RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);

            BufferBuilder buf = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);

            // Render harness
            renderHarness(matrices, buf, prim, acc);

            String mode = this.modeSetting.i_method_f85f3850().getName();

            // Right Wing (+X)
            matrices.push();
            matrices.translate(0.12, 0.0, 0.05);
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-flapAngle + spread));
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(10.0F + flapRoll));
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(6.0F));
            matrices.scale(scale, scale, scale);
            renderSpecificWing(matrices, buf, mode, 1.0F, flapAngle, time, prim, acc);
            matrices.pop();

            // Left Wing (-X)
            matrices.push();
            matrices.translate(-0.12, 0.0, 0.05);
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(flapAngle - spread));
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-10.0F - flapRoll));
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(6.0F));
            matrices.scale(-scale, scale, scale);
            renderSpecificWing(matrices, buf, mode, -1.0F, flapAngle, time, prim, acc);
            matrices.pop();

            BuiltBuffer built = buf.endNullable();
            if (built != null) BufferRenderer.drawWithGlobalProgram(built);

            // Optional Emissive Glow Pass
            if (this.glowEdges.i_method_9b12da03()) {
                RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE);
                RenderSystem.depthMask(false);
                BufferBuilder glowBuf = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);

                // Right Wing Glow
                matrices.push();
                matrices.translate(0.12, 0.0, 0.05);
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-flapAngle + spread));
                matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(10.0F + flapRoll));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(6.0F));
                matrices.scale(scale * 1.03F, scale * 1.03F, scale * 1.03F);
                renderSpecificWingGlow(matrices, glowBuf, mode, time, acc);
                matrices.pop();

                // Left Wing Glow
                matrices.push();
                matrices.translate(-0.12, 0.0, 0.05);
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(flapAngle - spread));
                matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-10.0F - flapRoll));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(6.0F));
                matrices.scale(-scale * 1.03F, scale * 1.03F, scale * 1.03F);
                renderSpecificWingGlow(matrices, glowBuf, mode, time, acc);
                matrices.pop();

                BuiltBuffer glowBuilt = glowBuf.endNullable();
                if (glowBuilt != null) BufferRenderer.drawWithGlobalProgram(glowBuilt);
            }

        } finally {
            RenderSystem.depthMask(true);
            RenderSystem.enableCull();
            RenderSystem.defaultBlendFunc();
            RenderSystem.disableBlend();
            matrices.pop();
        }
    }

    private void renderSpecificWing(MatrixStack m, BufferBuilder buf, String mode, float side, float flapAngle, float time, int prim, int acc) {
        switch (mode) {
            case "Solar Phoenix" -> renderSolarPhoenixWing(m, buf, time, prim, acc);
            case "Dragon Sovereign" -> renderDragonSovereignWing(m, buf, time, prim, acc);
            case "Cyber Mecha" -> renderCyberMechaWing(m, buf, time, prim, acc);
            case "Archdemon" -> renderArchdemonWing(m, buf, time, prim, acc);
            case "Archangel Triple Wings" -> renderArchangelTripleWings(m, buf, time, prim, acc);
            case "Cherubim Divine Wings" -> renderCherubimDivineWings(m, buf, time, prim, acc);
            case "Ophanim Sacred Wings" -> renderOphanimSacredWings(m, buf, time, prim, acc);
            case "Void Phantom" -> renderVoidPhantomWing(m, buf, time, prim, acc);
            case "Monarch Fairy" -> renderMonarchFairyWing(m, buf, time, prim, acc);
            case "Nebula Astral Wings" -> renderNebulaAstralWings(m, buf, time, prim, acc);
            case "Crystallite Frost Wings" -> renderCrystalliteFrostWings(m, buf, time, prim, acc);
            case "Dark Valkyrie Wings" -> renderDarkValkyrieWings(m, buf, time, prim, acc);
            case "Prismatic Shard Wings" -> renderPrismaticShardWings(m, buf, time, prim, acc);
            case "Celestial Diamond Wings" -> renderCelestialDiamondWings(m, buf, time, prim, acc);
            case "Void Crystalline Wings" -> renderVoidCrystallineWings(m, buf, time, prim, acc);
            default -> renderSeraphimAngelWing(m, buf, time, prim, acc);
        }
    }

    private void renderSpecificWingGlow(MatrixStack m, BufferBuilder buf, String mode, float time, int acc) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int glowColor = (acc & 0x00FFFFFF) | 0xAA000000;
        int glowCore = 0xEEFFFFFF;

        switch (mode) {
            case "Cyber Mecha" -> {
                // High-intensity laser edge highlights & thruster flare
                drawBox(buf, mat, 0.35F, 0.20F, 0.04F, 0.14F, 0.16F, 0.10F, glowColor);
                drawCyberBlade(buf, mat, 0.55F, 0.30F, 0.0F, 1.25F, 0.65F, -0.01F, 0.08F, glowColor, glowCore);
                drawCyberBlade(buf, mat, 0.48F, 0.24F, 0.0F, 1.30F, 0.25F, -0.01F, 0.09F, glowColor, glowCore);
                drawCyberBlade(buf, mat, 0.38F, 0.16F, 0.0F, 1.10F, -0.15F, -0.01F, 0.08F, glowColor, glowCore);
                drawCyberBlade(buf, mat, 0.25F, 0.08F, 0.0F, 0.75F, -0.40F, -0.01F, 0.07F, glowColor, glowCore);
            }
            case "Archdemon" -> {
                // Blazing demonic claws and bone struts
                float[][] struts = {{1.30F, 0.72F}, {1.35F, 0.24F}, {1.10F, -0.22F}, {0.68F, -0.55F}};
                for (float[] s : struts) {
                    drawOctahedron(buf, mat, s[0], s[1], -0.015F, 0.04F, 0.04F, 0.04F, glowCore);
                    drawTapered(buf, mat, 0.72F, 0.45F, 0.0F, 0.008F, s[0], s[1], -0.015F, 0.003F, glowColor);
                }
            }
            case "Archangel Triple Wings", "Cherubim Divine Wings", "Ophanim Sacred Wings" -> {
                drawTapered(buf, mat, 0.0F, 0.0F, 0.0F, 0.018F, 0.75F, 0.48F, 0.0F, 0.008F, glowColor);
                drawOctahedron(buf, mat, 0.95F, 0.92F, 0.0F, 0.03F, 0.03F, 0.03F, glowCore);
                drawOctahedron(buf, mat, 1.20F, 0.75F, 0.0F, 0.03F, 0.03F, 0.03F, glowCore);
                drawOctahedron(buf, mat, 1.28F, 0.48F, 0.0F, 0.03F, 0.03F, 0.03F, glowCore);
            }
            case "Solar Phoenix" -> {
                // Blazing solar fire edges & shoulder orb
                drawOctahedron(buf, mat, 0.38F, 0.22F, 0.0F, 0.07F, 0.07F, 0.07F, glowCore);
                float[][] plumes = {
                    {0.80F, 0.54F, 1.05F, 1.02F}, {0.72F, 0.46F, 1.32F, 0.82F},
                    {0.62F, 0.36F, 1.38F, 0.52F}, {0.50F, 0.26F, 1.25F, 0.18F}
                };
                for (int i = 0; i < plumes.length; i++) {
                    float[] p = plumes[i];
                    float wave = (float) Math.sin(time * 3.0F + i * 0.9F) * 0.04F;
                    drawFeatherBlade(buf, mat, p[0], p[1], 0.0F, p[2], p[3] + wave, -0.01F, 0.12F, glowColor, glowCore);
                }
            }
            case "Dragon Sovereign" -> {
                // Molten magma fissures along dragon spine and talons
                drawOctahedron(buf, mat, 0.85F, 0.52F, 0.0F, 0.05F, 0.05F, 0.05F, glowCore);
                drawTapered(buf, mat, 0.0F, 0.0F, 0.0F, 0.015F, 0.42F, 0.24F, 0.0F, 0.010F, glowColor);
                drawTapered(buf, mat, 0.42F, 0.24F, 0.0F, 0.010F, 0.85F, 0.52F, 0.0F, 0.006F, glowColor);
            }
            case "Void Phantom" -> {
                // Cosmic stardust tips
                for (int r = 0; r < 5; r++) {
                    float rAngle = 0.2F + r * 0.22F;
                    float rLen = 0.9F + r * 0.18F;
                    float tipX = (float) Math.cos(rAngle) * rLen;
                    float tipY = (float) Math.sin(rAngle) * rLen;
                    drawOctahedron(buf, mat, tipX, tipY, 0.0F, 0.035F, 0.035F, 0.035F, glowCore);
                }
            }
            case "Monarch Fairy" -> {
                // Glittering fairy dust nodes
                drawOctahedron(buf, mat, 1.20F, 0.85F, 0.0F, 0.035F, 0.035F, 0.035F, glowCore);
                drawOctahedron(buf, mat, 1.35F, 0.35F, 0.0F, 0.035F, 0.035F, 0.035F, glowCore);
                drawOctahedron(buf, mat, 0.85F, -0.58F, 0.0F, 0.032F, 0.032F, 0.032F, glowCore);
            }
            case "Nebula Astral Wings" -> {
                drawOctahedron(buf, mat, 0.28F, 0.16F, 0.02F, 0.06F, 0.06F, 0.06F, glowCore);
                float[][] stars = {{0.90F, 0.96F}, {1.22F, 0.72F}, {1.36F, 0.38F}, {1.24F, 0.02F}, {0.88F, -0.32F}};
                for (int i = 0; i < stars.length; i++) {
                    float orbit = (float) Math.sin(time * 2.8F + i * 1.2F) * 0.05F;
                    drawOctahedron(buf, mat, stars[i][0], stars[i][1] + orbit, 0.0F, 0.04F, 0.04F, 0.04F, glowCore);
                }
            }
            case "Crystallite Frost Wings" -> {
                drawDiamondCrystal(buf, mat, 0.30F, 0.15F, 0.0F, 0.10F, 0.18F, 0.05F, glowColor, glowCore);
                float[][] tips = {{0.85F, 0.95F}, {1.25F, 0.78F}, {1.42F, 0.45F}, {1.35F, 0.12F}, {1.10F, -0.22F}, {0.72F, -0.48F}};
                for (float[] tip : tips) {
                    drawOctahedron(buf, mat, tip[0], tip[1], 0.0F, 0.035F, 0.035F, 0.035F, glowCore);
                }
            }
            case "Dark Valkyrie Wings" -> {
                drawCyberBlade(buf, mat, 0.90F, 0.65F, 0.0F, 0.98F, 0.92F, 0.0F, 0.09F, glowColor, glowCore);
                drawCyberBlade(buf, mat, 0.90F, 0.65F, 0.0F, 1.48F, 0.68F, -0.01F, 0.11F, glowColor, glowCore);
                drawCyberBlade(buf, mat, 0.78F, 0.52F, 0.0F, 1.54F, 0.32F, -0.01F, 0.11F, glowColor, glowCore);
                drawCyberBlade(buf, mat, 0.62F, 0.38F, 0.0F, 1.42F, -0.04F, -0.01F, 0.10F, glowColor, glowCore);
                drawCyberBlade(buf, mat, 0.46F, 0.24F, 0.0F, 1.18F, -0.34F, -0.01F, 0.09F, glowColor, glowCore);
                drawCyberBlade(buf, mat, 0.30F, 0.12F, 0.0F, 0.82F, -0.54F, -0.01F, 0.08F, glowColor, glowCore);
            }
            case "Prismatic Shard Wings", "Celestial Diamond Wings", "Void Crystalline Wings" -> {
                drawDiamondCrystal(buf, mat, 0.35F, 0.18F, 0.0F, 0.12F, 0.22F, 0.06F, glowColor, glowCore);
                float[][] gemNodes = {{0.92F, 0.98F}, {1.35F, 0.82F}, {1.55F, 0.46F}, {1.44F, 0.10F}, {1.15F, -0.28F}, {0.75F, -0.52F}};
                for (float[] node : gemNodes) {
                    drawOctahedron(buf, mat, node[0], node[1], 0.0F, 0.04F, 0.04F, 0.04F, glowCore);
                }
            }
            default -> {
                // Seraphim divine feather halos
                drawTapered(buf, mat, 0.0F, 0.0F, 0.0F, 0.018F, 0.75F, 0.48F, 0.0F, 0.008F, glowColor);
                drawOctahedron(buf, mat, 0.95F, 0.92F, 0.0F, 0.03F, 0.03F, 0.03F, glowCore);
                drawOctahedron(buf, mat, 1.20F, 0.75F, 0.0F, 0.03F, 0.03F, 0.03F, glowCore);
                drawOctahedron(buf, mat, 1.28F, 0.48F, 0.0F, 0.03F, 0.03F, 0.03F, glowCore);
            }
        }
    }

    // --- 1. SERAPHIM ANGEL (Multi-tiered divine feathered wings) ---
    private void renderSeraphimAngelWing(MatrixStack m, BufferBuilder buf, float time, int prim, int acc) {
        Matrix4f mat = m.peek().getPositionMatrix();
        // Golden Bone Framework
        int bone = shade(acc, 0.9F);
        drawTapered(buf, mat, 0.0F, 0.0F, 0.0F, 0.035F, 0.35F, 0.18F, 0.0F, 0.022F, bone);
        drawTapered(buf, mat, 0.35F, 0.18F, 0.0F, 0.022F, 0.75F, 0.48F, 0.0F, 0.015F, bone);

        // 3 tiers of feathers
        // Upper Primaries (Long upward arching feathers)
        float[][] upperFeathers = {
            {0.75F, 0.48F, 0.95F, 0.92F},
            {0.68F, 0.42F, 1.20F, 0.75F},
            {0.58F, 0.34F, 1.28F, 0.48F},
            {0.48F, 0.26F, 1.18F, 0.18F}
        };
        for (int i = 0; i < upperFeathers.length; i++) {
            float[] f = upperFeathers[i];
            drawFeatherBlade(buf, mat, f[0], f[1], 0.0F, f[2], f[3], -0.02F, 0.09F, prim, acc);
        }

        // Mid Secondaries (Sweeping outward)
        float[][] midFeathers = {
            {0.38F, 0.18F, 0.98F, -0.08F},
            {0.28F, 0.10F, 0.76F, -0.28F},
            {0.18F, 0.04F, 0.52F, -0.42F}
        };
        for (int i = 0; i < midFeathers.length; i++) {
            float[] f = midFeathers[i];
            drawFeatherBlade(buf, mat, f[0], f[1], 0.01F, f[2], f[3], -0.01F, 0.08F, shade(prim, 0.92F), acc);
        }

        // Lower Covert Feathers (Soft base layer)
        drawFeatherBlade(buf, mat, 0.10F, 0.0F, 0.015F, 0.30F, -0.22F, 0.0F, 0.07F, shade(prim, 0.85F), acc);
    }

    // --- 2. CYBER MECHA (Sci-Fi angular armor, thrusters & neon blades) ---
    private void renderCyberMechaWing(MatrixStack m, BufferBuilder buf, float time, int prim, int acc) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int darkArmor = 0xFF1E232E;
        int chrome = 0xFF8A95A5;

        // Armored hydraulic arm
        drawBox(buf, mat, 0.18F, 0.08F, 0.0F, 0.22F, 0.05F, 0.05F, darkArmor);
        drawBox(buf, mat, 0.32F, 0.14F, 0.0F, 0.06F, 0.06F, 0.06F, chrome); // elbow servo
        drawBox(buf, mat, 0.52F, 0.28F, 0.0F, 0.26F, 0.04F, 0.04F, darkArmor);

        // Rocket Thruster Housing
        drawBox(buf, mat, 0.35F, 0.20F, 0.04F, 0.12F, 0.14F, 0.08F, darkArmor);
        // Neon exhaust plume flickering with time
        float plumePulse = 0.20F + (float) Math.sin(time * 3.5F) * 0.05F;
        int plumeCol = (acc & 0x00FFFFFF) | 0xDD000000;
        drawTapered(buf, mat, 0.35F, 0.12F, 0.04F, 0.035F, 0.35F, 0.12F - plumePulse, 0.04F, 0.005F, plumeCol);

        // 4 Rigid Articulated Cyber Blades with glowing edges
        float[][] blades = {
            {0.55F, 0.30F, 1.25F, 0.65F, 0.06F},
            {0.48F, 0.24F, 1.30F, 0.25F, 0.07F},
            {0.38F, 0.16F, 1.10F, -0.15F, 0.06F},
            {0.25F, 0.08F, 0.75F, -0.40F, 0.05F}
        };
        for (float[] b : blades) {
            drawCyberBlade(buf, mat, b[0], b[1], 0.0F, b[2], b[3], -0.01F, b[4], prim, acc);
        }
    }

    // --- 3. ARCHDEMON (Gothic bat bone talons & leathery torn membrane) ---
    private void renderArchdemonWing(MatrixStack m, BufferBuilder buf, float time, int prim, int acc) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int boneCol = 0xFFECE0D0;
        int leatherCol = shade(prim, 0.5F);

        // Main skeletal limb
        drawTapered(buf, mat, 0.0F, 0.0F, 0.0F, 0.04F, 0.36F, 0.20F, 0.0F, 0.026F, boneCol);
        drawTapered(buf, mat, 0.36F, 0.20F, 0.0F, 0.026F, 0.72F, 0.45F, 0.0F, 0.018F, boneCol);

        // Thumb Talon Hook at apex
        drawTapered(buf, mat, 0.72F, 0.45F, 0.0F, 0.018F, 0.75F, 0.54F, 0.0F, 0.004F, 0xFFFFFFFF);

        // 4 Elongated Bat Finger Struts
        float[][] struts = {
            {1.30F, 0.72F},
            {1.35F, 0.24F},
            {1.10F, -0.22F},
            {0.68F, -0.55F}
        };
        for (float[] s : struts) {
            drawTapered(buf, mat, 0.72F, 0.45F, 0.0F, 0.016F, s[0], s[1], -0.015F, 0.006F, boneCol);
            // Sharp claw at tip
            drawOctahedron(buf, mat, s[0], s[1], -0.015F, 0.025F, 0.025F, 0.025F, acc);
        }

        // Scalloped Webbed Leather Membrane
        for (int i = 0; i < struts.length - 1; i++) {
            float[] s1 = struts[i];
            float[] s2 = struts[i + 1];
            // Web scallop arch dip
            float midX = (s1[0] + s2[0]) * 0.45F;
            float midY = (s1[1] + s2[1]) * 0.45F;

            drawMembraneTri(buf, mat, 0.72F, 0.45F, 0.0F, s1[0], s1[1], -0.015F, midX, midY, -0.015F, leatherCol);
            drawMembraneTri(buf, mat, 0.72F, 0.45F, 0.0F, midX, midY, -0.015F, s2[0], s2[1], -0.015F, leatherCol);
        }
        // Inner web connecting to body
        drawMembraneTri(buf, mat, 0.0F, 0.0F, 0.0F, 0.72F, 0.45F, 0.0F, struts[3][0], struts[3][1], -0.015F, leatherCol);
    }

    // --- 4. ARCHANGEL TRIPLE WINGS (6 divine wings with tiered flutter) ---
    private void renderArchangelTripleWings(MatrixStack m, BufferBuilder buf, float time, int prim, int acc) {
        // Tier 1: High arching wing
        m.push();
        m.translate(0.02F, 0.16F, 0.02F);
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(14.0F));
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((float)Math.sin(time * 3.2F) * 8.0F));
        m.scale(1.18F, 1.18F, 1.18F);
        renderSeraphimAngelWing(m, buf, time, prim, acc);
        m.pop();

        // Tier 2: Mid spreading wing
        m.push();
        m.translate(0.04F, -0.12F, -0.04F);
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-8.0F));
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((float)Math.sin(time * 3.2F - 0.7F) * 11.0F));
        m.scale(0.92F, 0.92F, 0.92F);
        renderSeraphimAngelWing(m, buf, time, acc, prim);
        m.pop();

        // Tier 3: Lower downward sweeping wing
        m.push();
        m.translate(0.02F, -0.38F, -0.07F);
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-30.0F));
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((float)Math.sin(time * 3.2F - 1.4F) * 14.0F));
        m.scale(0.70F, 0.70F, 0.70F);
        renderSeraphimAngelWing(m, buf, time, prim, acc);
        m.pop();
    }

    // --- 5. CHERUBIM DIVINE WINGS (Dense sculpted golden feathers with runes) ---
    private void renderCherubimDivineWings(MatrixStack m, BufferBuilder buf, float time, int prim, int acc) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int divineGold = 0xFFFFE87C;
        int holyWhite = 0xFFFFFFFF;
        int runeCol = acc;

        drawTapered(buf, mat, 0.0F, 0.0F, 0.0F, 0.042F, 0.38F, 0.22F, 0.0F, 0.026F, divineGold);
        drawTapered(buf, mat, 0.38F, 0.22F, 0.0F, 0.026F, 0.82F, 0.54F, 0.0F, 0.016F, divineGold);
        drawOctahedron(buf, mat, 0.38F, 0.22F, 0.02F, 0.035F, 0.035F, 0.035F, runeCol);

        float[][] feathers = {
            {0.82F, 0.54F, 1.15F, 1.12F, 0.11F},
            {0.78F, 0.48F, 1.38F, 0.92F, 0.11F},
            {0.70F, 0.40F, 1.48F, 0.62F, 0.10F},
            {0.58F, 0.30F, 1.42F, 0.30F, 0.10F},
            {0.44F, 0.20F, 1.25F, -0.02F, 0.09F},
            {0.32F, 0.12F, 1.02F, -0.28F, 0.08F},
            {0.20F, 0.05F, 0.74F, -0.48F, 0.07F}
        };

        for (int i = 0; i < feathers.length; i++) {
            float[] f = feathers[i];
            float flutter = (float)Math.sin(time * 3.5F + i * 0.6F) * 0.03F;
            int fPrim = (i % 2 == 0) ? holyWhite : divineGold;
            drawFeatherBlade(buf, mat, f[0], f[1], 0.0F, f[2], f[3] + flutter, -0.015F, f[4], fPrim, acc);
        }
    }

    // --- 6. OPHANIM SACRED WINGS (Holy flame feathers with revolving ocular core) ---
    private void renderOphanimSacredWings(MatrixStack m, BufferBuilder buf, float time, int prim, int acc) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int holyFlame = 0xFFFF7A18;
        int sacredGold = 0xFFFFDF00;
        int coreLight = 0xFFFFFFFF;

        drawOctahedron(buf, mat, 0.35F, 0.18F, 0.0F, 0.06F, 0.06F, 0.06F, sacredGold);
        drawOctahedron(buf, mat, 0.35F, 0.18F, 0.0F, 0.03F, 0.03F, 0.03F, coreLight);

        float[][] flameFeathers = {
            {0.35F, 0.18F, 0.95F, 1.10F},
            {0.35F, 0.18F, 1.25F, 0.82F},
            {0.35F, 0.18F, 1.35F, 0.45F},
            {0.35F, 0.18F, 1.28F, 0.08F},
            {0.35F, 0.18F, 1.05F, -0.28F},
            {0.35F, 0.18F, 0.72F, -0.55F}
        };

        for (int i = 0; i < flameFeathers.length; i++) {
            float[] f = flameFeathers[i];
            float wave = (float)Math.sin(time * 4.0F + i * 0.8F) * 0.05F;
            drawFeatherBlade(buf, mat, f[0], f[1], 0.0F, f[2], f[3] + wave, -0.02F, 0.12F, sacredGold, holyFlame);
        }
    }

    // --- 5. VOID PHANTOM (Ethereal undulating shadow tendrils) ---
    private void renderVoidPhantomWing(MatrixStack m, BufferBuilder buf, float time, int prim, int acc) {
        Matrix4f mat = m.peek().getPositionMatrix();

        int darkVoid = 0xDD0D0518;
        int voidGlow = (acc & 0x00FFFFFF) | 0xAA000000;

        int ribbons = 5;
        for (int r = 0; r < ribbons; r++) {
            float rAngle = 0.2F + r * 0.22F;
            float rLen = 0.9F + r * 0.18F;
            int segs = 6;
            float px = 0.0F, py = 0.0F;

            for (int s = 1; s <= segs; s++) {
                float prog = (float) s / segs;
                float wave = (float) Math.sin(time * 2.5F - prog * 4.0F + r) * 0.08F * prog;
                float nx = (float) Math.cos(rAngle) * (rLen * prog);
                float ny = (float) Math.sin(rAngle) * (rLen * prog) + wave;

                float thick = (1.0F - prog * 0.7F) * 0.045F;
                int col = (s > segs - 2) ? voidGlow : darkVoid;
                drawTapered(buf, mat, px, py, 0.0F, thick, nx, ny, 0.0F, thick * 0.6F, col);
                px = nx;
                py = ny;
            }
        }
    }

    // --- 6. MONARCH FAIRY (Stained-glass intricate butterfly wings) ---
    private void renderMonarchFairyWing(MatrixStack m, BufferBuilder buf, float time, int prim, int acc) {
        Matrix4f mat = m.peek().getPositionMatrix();

        int veinCol = 0xFF1A1A1A;
        int membraneCol = (prim & 0x00FFFFFF) | 0xCC000000;
        int edgeDust = acc;

        // Forewing (Upper Large Lobe)
        float[] fwApex = {1.20F, 0.85F};
        float[] fwMid = {1.35F, 0.35F};
        float[] fwBase = {0.70F, 0.15F};

        drawMembraneTri(buf, mat, 0.0F, 0.0F, 0.0F, fwApex[0], fwApex[1], 0.0F, fwMid[0], fwMid[1], 0.0F, membraneCol);
        drawMembraneTri(buf, mat, 0.0F, 0.0F, 0.0F, fwMid[0], fwMid[1], 0.0F, fwBase[0], fwBase[1], 0.0F, membraneCol);

        // Hindwing (Lower Lobe with tail)
        float[] hwApex = {1.15F, -0.15F};
        float[] hwTail = {0.85F, -0.58F};
        float[] hwInner = {0.40F, -0.45F};

        drawMembraneTri(buf, mat, 0.0F, 0.0F, 0.0F, hwApex[0], hwApex[1], 0.0F, hwTail[0], hwTail[1], 0.0F, membraneCol);
        drawMembraneTri(buf, mat, 0.0F, 0.0F, 0.0F, hwTail[0], hwTail[1], 0.0F, hwInner[0], hwInner[1], 0.0F, membraneCol);

        // Structural Vein Lattice
        drawTapered(buf, mat, 0.0F, 0.0F, 0.0F, 0.02F, fwApex[0], fwApex[1], 0.0F, 0.008F, veinCol);
        drawTapered(buf, mat, 0.0F, 0.0F, 0.0F, 0.02F, fwMid[0], fwMid[1], 0.0F, 0.008F, veinCol);
        drawTapered(buf, mat, 0.0F, 0.0F, 0.0F, 0.016F, hwApex[0], hwApex[1], 0.0F, 0.008F, veinCol);
        drawTapered(buf, mat, 0.0F, 0.0F, 0.0F, 0.016F, hwTail[0], hwTail[1], 0.0F, 0.006F, veinCol);

        // Edge spots
        drawOctahedron(buf, mat, fwApex[0], fwApex[1], 0.0F, 0.025F, 0.025F, 0.025F, edgeDust);
        drawOctahedron(buf, mat, fwMid[0], fwMid[1], 0.0F, 0.025F, 0.025F, 0.025F, edgeDust);
        drawOctahedron(buf, mat, hwTail[0], hwTail[1], 0.0F, 0.022F, 0.022F, 0.022F, edgeDust);
    }

    // --- 7. SOLAR PHOENIX (Blazing incandescent flame wings) ---
    private void renderSolarPhoenixWing(MatrixStack m, BufferBuilder buf, float time, int prim, int acc) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int goldSpine = 0xFFFFD700;
        int flameCore = 0xFFFF4500;
        int flameTip = 0xFFFFAA00;

        // Blazing arched spine
        drawTapered(buf, mat, 0.0F, 0.0F, 0.0F, 0.038F, 0.38F, 0.22F, 0.0F, 0.025F, goldSpine);
        drawTapered(buf, mat, 0.38F, 0.22F, 0.0F, 0.025F, 0.80F, 0.54F, 0.0F, 0.016F, goldSpine);

        // Core solar flame orb at shoulder
        drawOctahedron(buf, mat, 0.38F, 0.22F, 0.0F, 0.05F, 0.05F, 0.05F, 0xFFFFFFFF);

        // Radiant fire plume feathers
        float[][] plumes = {
            {0.80F, 0.54F, 1.05F, 1.02F},
            {0.72F, 0.46F, 1.32F, 0.82F},
            {0.62F, 0.36F, 1.38F, 0.52F},
            {0.50F, 0.26F, 1.25F, 0.18F},
            {0.38F, 0.16F, 1.02F, -0.12F},
            {0.25F, 0.06F, 0.72F, -0.36F}
        };

        for (int i = 0; i < plumes.length; i++) {
            float[] p = plumes[i];
            float wave = (float) Math.sin(time * 3.0F + i * 0.9F) * 0.04F;
            drawFeatherBlade(buf, mat, p[0], p[1], 0.0F, p[2], p[3] + wave, -0.01F, 0.11F, flameCore, flameTip);
        }
    }

    // --- 8. DRAGON SOVEREIGN (Massive armored obsidian spines & draconic talons) ---
    private void renderDragonSovereignWing(MatrixStack m, BufferBuilder buf, float time, int prim, int acc) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int obsidian = 0xFF141318;
        int magmaGlow = acc;
        int darkLeather = 0xFF201824;

        // Heavy armored bone arm
        drawTapered(buf, mat, 0.0F, 0.0F, 0.0F, 0.048F, 0.42F, 0.24F, 0.0F, 0.032F, obsidian);
        drawTapered(buf, mat, 0.42F, 0.24F, 0.0F, 0.032F, 0.85F, 0.52F, 0.0F, 0.020F, obsidian);

        // Elbow obsidian horn
        drawTapered(buf, mat, 0.42F, 0.24F, 0.0F, 0.025F, 0.38F, 0.38F, 0.0F, 0.005F, obsidian);

        // Huge apex dragon claw
        drawTapered(buf, mat, 0.85F, 0.52F, 0.0F, 0.020F, 0.92F, 0.68F, 0.0F, 0.004F, 0xFFE0E0E0);

        // 4 massive spiked finger bones
        float[][] ribs = {
            {1.45F, 0.82F},
            {1.52F, 0.30F},
            {1.24F, -0.24F},
            {0.78F, -0.62F}
        };

        for (float[] r : ribs) {
            drawTapered(buf, mat, 0.85F, 0.52F, 0.0F, 0.018F, r[0], r[1], -0.015F, 0.006F, obsidian);
            drawOctahedron(buf, mat, r[0], r[1], -0.015F, 0.03F, 0.03F, 0.03F, magmaGlow);
        }

        // Magma webbed membrane
        for (int i = 0; i < ribs.length - 1; i++) {
            float[] r1 = ribs[i];
            float[] r2 = ribs[i + 1];
            float midX = (r1[0] + r2[0]) * 0.46F;
            float midY = (r1[1] + r2[1]) * 0.46F;
            drawMembraneTri(buf, mat, 0.85F, 0.52F, 0.0F, r1[0], r1[1], -0.015F, midX, midY, -0.015F, darkLeather);
            drawMembraneTri(buf, mat, 0.85F, 0.52F, 0.0F, midX, midY, -0.015F, r2[0], r2[1], -0.015F, darkLeather);
        }
        drawMembraneTri(buf, mat, 0.0F, 0.0F, 0.0F, 0.85F, 0.52F, 0.0F, ribs[3][0], ribs[3][1], -0.015F, darkLeather);
    }

    // --- 9. NEBULA ASTRAL WINGS (Interstellar gradient feathers, cosmic dust & orbiting starlight) ---
    private void renderNebulaAstralWings(MatrixStack m, BufferBuilder buf, float time, int prim, int acc) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int starCore = 0xFFFFFFFF;
        int nebulaViolet = 0xFF240046;
        int cosmicPurple = 0xFF7209B7;
        int starlightCyan = 0xFF4CC9F0;
        int neonPink = 0xFFF72585;

        // Shoulder astral anchor star
        drawOctahedron(buf, mat, 0.28F, 0.16F, 0.02F, 0.05F, 0.05F, 0.05F, starCore);
        drawTapered(buf, mat, 0.0F, 0.0F, 0.0F, 0.032F, 0.28F, 0.16F, 0.0F, 0.020F, cosmicPurple);

        // 5 Sweeping astral plumes with cosmic color shifts
        float[][] plumes = {
            {0.28F, 0.16F, 0.90F, 0.96F, 0.11F},
            {0.32F, 0.14F, 1.22F, 0.72F, 0.11F},
            {0.30F, 0.10F, 1.36F, 0.38F, 0.10F},
            {0.25F, 0.06F, 1.24F, 0.02F, 0.09F},
            {0.20F, 0.02F, 0.88F, -0.32F, 0.08F}
        };

        int[] colors = {nebulaViolet, cosmicPurple, neonPink, starlightCyan, 0xFF06D6A0};
        for (int i = 0; i < plumes.length; i++) {
            float[] p = plumes[i];
            float wave = (float) Math.sin(time * 3.0F + i * 0.8F) * 0.04F;
            drawFeatherBlade(buf, mat, p[0], p[1], 0.0F, p[2], p[3] + wave, -0.015F, p[4], colors[i], starCore);

            // Orbiting stardust mote at tip
            float orbit = (float) Math.sin(time * 2.8F + i * 1.2F) * 0.04F;
            drawOctahedron(buf, mat, p[2], p[3] + wave + orbit, 0.0F, 0.025F, 0.025F, 0.025F, starCore);
        }

        // Translucent astral connective haze
        drawMembraneTri(buf, mat, 0.0F, 0.0F, 0.0F, plumes[0][2], plumes[0][3], 0.0F, plumes[1][2], plumes[1][3], 0.0F, 0x777209B7);
        drawMembraneTri(buf, mat, 0.0F, 0.0F, 0.0F, plumes[1][2], plumes[1][3], 0.0F, plumes[2][2], plumes[2][3], 0.0F, 0x664361EE);
        drawMembraneTri(buf, mat, 0.0F, 0.0F, 0.0F, plumes[2][2], plumes[2][3], 0.0F, plumes[3][2], plumes[3][3], 0.0F, 0x55F72585);
    }

    // --- 10. CRYSTALLITE FROST WINGS (Multi-faceted glacial diamond crystal shards) ---
    private void renderCrystalliteFrostWings(MatrixStack m, BufferBuilder buf, float time, int prim, int acc) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int frostWhite = 0xFFFFFFFF;
        int glacialCyan = 0xFF4DD0E1;
        int deepGlacier = 0xFF00838F;
        int iceCore = 0xFFE0F7FA;

        // Central frost diamond cluster
        drawDiamondCrystal(buf, mat, 0.30F, 0.15F, 0.0F, 0.08F, 0.15F, 0.04F, glacialCyan, frostWhite);
        drawTapered(buf, mat, 0.0F, 0.0F, 0.0F, 0.030F, 0.30F, 0.15F, 0.0F, 0.020F, deepGlacier);

        // 6 Diamond-cut crystal stalactites angling outwards
        float[][] crystals = {
            {0.30F, 0.15F, 0.85F, 0.95F, 0.09F},
            {0.30F, 0.15F, 1.25F, 0.78F, 0.10F},
            {0.30F, 0.15F, 1.42F, 0.45F, 0.11F},
            {0.30F, 0.15F, 1.35F, 0.12F, 0.09F},
            {0.30F, 0.15F, 1.10F, -0.22F, 0.08F},
            {0.30F, 0.15F, 0.72F, -0.48F, 0.07F}
        };

        for (int i = 0; i < crystals.length; i++) {
            float[] c = crystals[i];
            float flutter = (float) Math.sin(time * 3.4F + i * 0.7F) * 0.03F;
            float midX = (c[0] + c[2]) * 0.5F;
            float midY = (c[1] + c[3] + flutter) * 0.5F;

            // Diamond crystal segment
            drawDiamondCrystal(buf, mat, midX, midY, 0.0F, c[4], 0.22F, 0.035F, glacialCyan, frostWhite);
            drawTapered(buf, mat, c[0], c[1], 0.0F, 0.016F, c[2], c[3] + flutter, 0.0F, 0.005F, iceCore);

            // Shimmering frost point
            drawOctahedron(buf, mat, c[2], c[3] + flutter, 0.0F, 0.025F, 0.025F, 0.025F, frostWhite);
        }
    }

    // --- 11. DARK VALKYRIE WINGS (Obsidian warblades, blood runes & gold valkyrie seals) ---
    private void renderDarkValkyrieWings(MatrixStack m, BufferBuilder buf, float time, int prim, int acc) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int darkSteel = 0xFF181820;
        int gunmetal = 0xFF2C2F38;
        int bloodRune = 0xFFFF1744;
        int valkyrieGold = 0xFFFFB703;

        // Gothic armature spine
        drawTapered(buf, mat, 0.0F, 0.0F, 0.0F, 0.040F, 0.38F, 0.24F, 0.0F, 0.028F, darkSteel);
        drawTapered(buf, mat, 0.38F, 0.24F, 0.0F, 0.028F, 0.90F, 0.65F, 0.0F, 0.018F, gunmetal);

        // Golden valkyrie seal at apex
        drawOctahedron(buf, mat, 0.90F, 0.65F, 0.01F, 0.045F, 0.045F, 0.045F, valkyrieGold);

        // Forward apex crest horn
        drawCyberBlade(buf, mat, 0.90F, 0.65F, 0.0F, 0.98F, 0.92F, 0.0F, 0.07F, darkSteel, bloodRune);

        // 5 Razor warblades with glowing crimson edges
        float[][] blades = {
            {0.90F, 0.65F, 1.48F, 0.68F, 0.09F},
            {0.78F, 0.52F, 1.54F, 0.32F, 0.09F},
            {0.62F, 0.38F, 1.42F, -0.04F, 0.08F},
            {0.46F, 0.24F, 1.18F, -0.34F, 0.07F},
            {0.30F, 0.12F, 0.82F, -0.54F, 0.06F}
        };

        for (int i = 0; i < blades.length; i++) {
            float[] b = blades[i];
            float wave = (float) Math.sin(time * 3.2F + i * 0.6F) * 0.025F;
            int runeEdge = (i == 4) ? valkyrieGold : bloodRune;
            drawCyberBlade(buf, mat, b[0], b[1], 0.0F, b[2], b[3] + wave, -0.01F, b[4], darkSteel, runeEdge);
        }
    }

    // --- 12. PRISMATIC SHARD WINGS (Iridescent rainbow crystal facets & floating refraction shards) ---
    private void renderPrismaticShardWings(MatrixStack m, BufferBuilder buf, float time, int prim, int acc) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int diamondWhite = 0xFFFFFFFF;
        int prismCyan = 0xFF00F5D4;
        int prismEmerald = 0xFF06D6A0;
        int prismAmber = 0xFFFFD166;
        int prismRose = 0xFFEF476F;
        int prismPurple = 0xFF7B2CBF;

        // Central diamond prism cluster
        drawDiamondCrystal(buf, mat, 0.35F, 0.18F, 0.0F, 0.12F, 0.22F, 0.05F, prismCyan, diamondWhite);
        drawTapered(buf, mat, 0.0F, 0.0F, 0.0F, 0.034F, 0.35F, 0.18F, 0.0F, 0.022F, 0xFF1B2A4A);

        float[][] shards = {
            {0.35F, 0.18F, 0.95F, 1.05F, 0.12F},
            {0.35F, 0.18F, 1.38F, 0.82F, 0.13F},
            {0.35F, 0.18F, 1.58F, 0.46F, 0.14F},
            {0.35F, 0.18F, 1.48F, 0.08F, 0.12F},
            {0.35F, 0.18F, 1.20F, -0.28F, 0.10F},
            {0.35F, 0.18F, 0.78F, -0.52F, 0.09F}
        };

        int[] colors = {prismPurple, prismRose, prismAmber, prismEmerald, prismCyan, diamondWhite};
        for (int i = 0; i < shards.length; i++) {
            float[] s = shards[i];
            float flutter = (float) Math.sin(time * 3.6F + i * 0.75F) * 0.035F;
            float midX = (s[0] + s[2]) * 0.52F;
            float midY = (s[1] + s[3] + flutter) * 0.52F;

            // Main crystal shard
            drawDiamondCrystal(buf, mat, midX, midY, 0.0F, s[4], 0.26F, 0.045F, colors[i], diamondWhite);
            drawTapered(buf, mat, s[0], s[1], 0.0F, 0.018F, s[2], s[3] + flutter, 0.0F, 0.006F, colors[i]);

            // Detached floating satellite crystal
            float satOrbit = (float) Math.sin(time * 2.8F + i * 1.1F) * 0.06F;
            drawDiamondCrystal(buf, mat, s[2] + 0.08F, s[3] + flutter + satOrbit, 0.0F, 0.05F, 0.10F, 0.025F, colors[(i + 1) % colors.length], diamondWhite);
        }
    }

    // --- 13. CELESTIAL DIAMOND WINGS (Pure brilliant-cut geometric diamond blades & starlight lattice) ---
    private void renderCelestialDiamondWings(MatrixStack m, BufferBuilder buf, float time, int prim, int acc) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int diamondBrilliant = 0xFFFFFFFF;
        int diamondIce = 0xFFD8F3DC;
        int diamondAzure = 0xFF90E0EF;
        int diamondDeep = 0xFF0077B6;

        // Spine diamond backbone
        drawDiamondCrystal(buf, mat, 0.40F, 0.22F, 0.0F, 0.14F, 0.26F, 0.06F, diamondAzure, diamondBrilliant);
        drawTapered(buf, mat, 0.0F, 0.0F, 0.0F, 0.036F, 0.40F, 0.22F, 0.0F, 0.024F, diamondDeep);

        float[][] facets = {
            {0.40F, 0.22F, 0.90F, 1.10F, 0.13F},
            {0.40F, 0.22F, 1.34F, 0.88F, 0.14F},
            {0.40F, 0.22F, 1.62F, 0.52F, 0.15F},
            {0.40F, 0.22F, 1.52F, 0.12F, 0.13F},
            {0.40F, 0.22F, 1.25F, -0.25F, 0.11F},
            {0.40F, 0.22F, 0.82F, -0.55F, 0.09F}
        };

        for (int i = 0; i < facets.length; i++) {
            float[] f = facets[i];
            float flutter = (float) Math.sin(time * 3.2F + i * 0.8F) * 0.03F;
            float midX = (f[0] + f[2]) * 0.5F;
            float midY = (f[1] + f[3] + flutter) * 0.5F;

            // Dual interlocking diamond facets
            drawDiamondCrystal(buf, mat, midX, midY, 0.015F, f[4], 0.28F, 0.045F, diamondAzure, diamondBrilliant);
            drawDiamondCrystal(buf, mat, midX + 0.04F, midY - 0.03F, -0.015F, f[4] * 0.8F, 0.22F, 0.035F, diamondIce, diamondBrilliant);
            drawTapered(buf, mat, f[0], f[1], 0.0F, 0.020F, f[2], f[3] + flutter, 0.0F, 0.007F, diamondDeep);

            // Glowing diamond point tip
            drawOctahedron(buf, mat, f[2], f[3] + flutter, 0.0F, 0.035F, 0.035F, 0.035F, diamondBrilliant);
        }

        // Diamond lattice connector
        for (int i = 0; i < facets.length - 1; i++) {
            float[] f1 = facets[i];
            float[] f2 = facets[i + 1];
            drawTapered(buf, mat, f1[2], f1[3], 0.0F, 0.008F, f2[2], f2[3], 0.0F, 0.008F, diamondAzure);
        }
    }

    // --- 14. VOID CRYSTALLINE WINGS (Dark obsidian-amethyst cosmic geometric crystals) ---
    private void renderVoidCrystallineWings(MatrixStack m, BufferBuilder buf, float time, int prim, int acc) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int voidObsidian = 0xFF10002B;
        int voidAmethyst = 0xFF3C096C;
        int voidMagenta = 0xFF9D4EDD;
        int voidNeonPink = 0xFFFF5400;
        int voidCoreGlow = 0xFFE0AAFF;

        // Dark obsidian root crystal
        drawDiamondCrystal(buf, mat, 0.36F, 0.20F, 0.0F, 0.13F, 0.24F, 0.055F, voidAmethyst, voidNeonPink);
        drawTapered(buf, mat, 0.0F, 0.0F, 0.0F, 0.038F, 0.36F, 0.20F, 0.0F, 0.024F, voidObsidian);

        float[][] voidSpikes = {
            {0.36F, 0.20F, 0.92F, 1.02F, 0.12F},
            {0.36F, 0.20F, 1.36F, 0.84F, 0.13F},
            {0.36F, 0.20F, 1.60F, 0.48F, 0.15F},
            {0.36F, 0.20F, 1.46F, 0.10F, 0.13F},
            {0.36F, 0.20F, 1.18F, -0.26F, 0.11F},
            {0.36F, 0.20F, 0.76F, -0.50F, 0.09F}
        };

        for (int i = 0; i < voidSpikes.length; i++) {
            float[] s = voidSpikes[i];
            float flutter = (float) Math.sin(time * 3.0F + i * 0.85F) * 0.03F;
            float midX = (s[0] + s[2]) * 0.5F;
            float midY = (s[1] + s[3] + flutter) * 0.5F;

            // Obsidian crystal core with bright magenta edge
            drawDiamondCrystal(buf, mat, midX, midY, 0.0F, s[4], 0.28F, 0.045F, voidObsidian, voidMagenta);
            drawTapered(buf, mat, s[0], s[1], 0.0F, 0.022F, s[2], s[3] + flutter, 0.0F, 0.007F, voidAmethyst);

            // Floating void ember crystal
            float floatPulse = (float) Math.sin(time * 4.0F + i * 1.5F) * 0.05F;
            drawOctahedron(buf, mat, s[2] + 0.07F, s[3] + flutter + floatPulse, 0.0F, 0.032F, 0.032F, 0.032F, voidCoreGlow);
        }
    }

    // --- SHARED 3D PRIMITIVE HELPERS ---
    private static void renderHarness(MatrixStack m, BufferBuilder buf, int prim, int acc) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int darkMetal = 0xFF2B2E38;
        // Central back plate
        drawBox(buf, mat, 0.0F, 0.0F, 0.01F, 0.16F, 0.28F, 0.04F, darkMetal);
        // Central core crystal
        drawOctahedron(buf, mat, 0.0F, 0.0F, 0.03F, 0.04F, 0.06F, 0.04F, acc);
    }

    private static void drawBox(BufferBuilder b, Matrix4f m, float cx, float cy, float cz, float sx, float sy, float sz, int col) {
        float hx = sx * 0.5F, hy = sy * 0.5F, hz = sz * 0.5F;
        // Front
        b.vertex(m, cx - hx, cy - hy, cz + hz).color(col);
        b.vertex(m, cx + hx, cy - hy, cz + hz).color(col);
        b.vertex(m, cx + hx, cy + hy, cz + hz).color(col);
        b.vertex(m, cx - hx, cy + hy, cz + hz).color(col);
        // Back
        b.vertex(m, cx - hx, cy - hy, cz - hz).color(col);
        b.vertex(m, cx - hx, cy + hy, cz - hz).color(col);
        b.vertex(m, cx + hx, cy + hy, cz - hz).color(col);
        b.vertex(m, cx + hx, cy - hy, cz - hz).color(col);
        // Top
        b.vertex(m, cx - hx, cy + hy, cz - hz).color(col);
        b.vertex(m, cx - hx, cy + hy, cz + hz).color(col);
        b.vertex(m, cx + hx, cy + hy, cz + hz).color(col);
        b.vertex(m, cx + hx, cy + hy, cz - hz).color(col);
        // Bottom
        b.vertex(m, cx - hx, cy - hy, cz - hz).color(col);
        b.vertex(m, cx + hx, cy - hy, cz - hz).color(col);
        b.vertex(m, cx + hx, cy - hy, cz + hz).color(col);
        b.vertex(m, cx - hx, cy - hy, cz + hz).color(col);
        // Left
        b.vertex(m, cx - hx, cy - hy, cz - hz).color(col);
        b.vertex(m, cx - hx, cy - hy, cz + hz).color(col);
        b.vertex(m, cx - hx, cy + hy, cz + hz).color(col);
        b.vertex(m, cx - hx, cy + hy, cz - hz).color(col);
        // Right
        b.vertex(m, cx + hx, cy - hy, cz - hz).color(col);
        b.vertex(m, cx + hx, cy + hy, cz - hz).color(col);
        b.vertex(m, cx + hx, cy + hy, cz + hz).color(col);
        b.vertex(m, cx + hx, cy - hy, cz + hz).color(col);
    }

    private static void drawTapered(BufferBuilder b, Matrix4f m, float x1, float y1, float z1, float r1, float x2, float y2, float z2, float r2, int col) {
        float dx = x2 - x1, dy = y2 - y1, dz = z2 - z1;
        float len = (float) Math.sqrt(dx * dx + dy * dy + dz * dz);
        if (len < 0.001F) return;

        float nx = -dy / len, ny = dx / len;
        // Top/Bottom faces
        b.vertex(m, x1 - nx * r1, y1 - ny * r1, z1).color(col);
        b.vertex(m, x1 + nx * r1, y1 + ny * r1, z1).color(col);
        b.vertex(m, x2 + nx * r2, y2 + ny * r2, z2).color(col);
        b.vertex(m, x2 - nx * r2, y2 - ny * r2, z2).color(col);
        // Side faces
        b.vertex(m, x1, y1, z1 - r1).color(col);
        b.vertex(m, x1, y1, z1 + r1).color(col);
        b.vertex(m, x2, y2, z2 + r2).color(col);
        b.vertex(m, x2, y2, z2 - r2).color(col);
    }

    private static void drawFeatherBlade(BufferBuilder b, Matrix4f m, float x1, float y1, float z1, float x2, float y2, float z2, float width, int bodyCol, int tipCol) {
        float dx = x2 - x1, dy = y2 - y1;
        float len = (float) Math.sqrt(dx * dx + dy * dy);
        if (len < 0.001F) return;
        float nx = -dy / len * width;
        float ny = dx / len * width;
        float depth = 0.012F;

        // Front Face (+Z)
        b.vertex(m, x1, y1, z1 + depth).color(bodyCol);
        b.vertex(m, x1 + nx, y1 + ny, z1 + depth * 0.5F).color(bodyCol);
        b.vertex(m, x2 + nx * 0.35F, y2 + ny * 0.35F, z2 + depth * 0.2F).color(tipCol);
        b.vertex(m, x2, y2, z2).color(tipCol);

        b.vertex(m, x1, y1, z1 + depth).color(bodyCol);
        b.vertex(m, x2, y2, z2).color(tipCol);
        b.vertex(m, x2 - nx * 0.35F, y2 - ny * 0.35F, z2 + depth * 0.2F).color(tipCol);
        b.vertex(m, x1 - nx, y1 - ny, z1 + depth * 0.5F).color(bodyCol);

        // Back Face (-Z)
        int backBody = shade(bodyCol, 0.85F);
        int backTip = shade(tipCol, 0.85F);
        b.vertex(m, x1, y1, z1 - depth).color(backBody);
        b.vertex(m, x2, y2, z2).color(backTip);
        b.vertex(m, x2 + nx * 0.35F, y2 + ny * 0.35F, z2 - depth * 0.2F).color(backTip);
        b.vertex(m, x1 + nx, y1 + ny, z1 - depth * 0.5F).color(backBody);

        b.vertex(m, x1, y1, z1 - depth).color(backBody);
        b.vertex(m, x1 - nx, y1 - ny, z1 - depth * 0.5F).color(backBody);
        b.vertex(m, x2 - nx * 0.35F, y2 - ny * 0.35F, z2 - depth * 0.2F).color(backTip);
        b.vertex(m, x2, y2, z2).color(backTip);
    }

    private static void drawCyberBlade(BufferBuilder b, Matrix4f m, float x1, float y1, float z1, float x2, float y2, float z2, float width, int bodyCol, int edgeCol) {
        float dx = x2 - x1, dy = y2 - y1;
        float len = (float) Math.sqrt(dx * dx + dy * dy);
        if (len < 0.001F) return;
        float nx = -dy / len * width;
        float ny = dx / len * width;

        // Solid blade body
        b.vertex(m, x1, y1, z1).color(bodyCol);
        b.vertex(m, x1 + nx, y1 + ny, z1).color(bodyCol);
        b.vertex(m, x2, y2, z2).color(bodyCol);
        b.vertex(m, x1 - nx * 0.3F, y1 - ny * 0.3F, z1).color(bodyCol);

        // Glowing edge strip
        b.vertex(m, x1 + nx, y1 + ny, z1).color(edgeCol);
        b.vertex(m, x1 + nx * 1.15F, y1 + ny * 1.15F, z1).color(edgeCol);
        b.vertex(m, x2 + nx * 0.15F, y2 + ny * 0.15F, z2).color(edgeCol);
        b.vertex(m, x2, y2, z2).color(edgeCol);
    }

    private static void drawDiamondCrystal(BufferBuilder b, Matrix4f m, float cx, float cy, float cz, float w, float h, float d, int bodyCol, int edgeCol) {
        float hw = w * 0.5F, hh = h * 0.5F;
        // Upper Diamond Half
        b.vertex(m, cx, cy + hh, cz).color(edgeCol);
        b.vertex(m, cx - hw, cy, cz).color(bodyCol);
        b.vertex(m, cx, cy, cz + d).color(bodyCol);
        b.vertex(m, cx + hw, cy, cz).color(bodyCol);

        // Lower Diamond Half
        b.vertex(m, cx, cy - hh, cz).color(edgeCol);
        b.vertex(m, cx - hw, cy, cz).color(bodyCol);
        b.vertex(m, cx, cy, cz + d).color(bodyCol);
        b.vertex(m, cx + hw, cy, cz).color(bodyCol);

        // Back Facets
        b.vertex(m, cx, cy + hh, cz).color(edgeCol);
        b.vertex(m, cx - hw, cy, cz).color(bodyCol);
        b.vertex(m, cx, cy, cz - d).color(bodyCol);
        b.vertex(m, cx + hw, cy, cz).color(bodyCol);

        b.vertex(m, cx, cy - hh, cz).color(edgeCol);
        b.vertex(m, cx - hw, cy, cz).color(bodyCol);
        b.vertex(m, cx, cy, cz - d).color(bodyCol);
        b.vertex(m, cx + hw, cy, cz).color(bodyCol);
    }

    private static void drawMembraneTri(BufferBuilder b, Matrix4f m, float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3, int col) {
        b.vertex(m, x1, y1, z1).color(col);
        b.vertex(m, x2, y2, z2).color(col);
        b.vertex(m, x3, y3, z3).color(col);
        b.vertex(m, x1, y1, z1).color(col);
    }

    private static void drawOctahedron(BufferBuilder b, Matrix4f m, float x, float y, float z, float rx, float ry, float rz, int col) {
        b.vertex(m, x, y + ry, z).color(col);
        b.vertex(m, x - rx, y, z).color(col);
        b.vertex(m, x, y, z + rz).color(col);
        b.vertex(m, x + rx, y, z).color(col);

        b.vertex(m, x, y - ry, z).color(col);
        b.vertex(m, x - rx, y, z).color(col);
        b.vertex(m, x, y, z + rz).color(col);
        b.vertex(m, x + rx, y, z).color(col);
    }

    private static int shade(int col, float factor) {
        int a = (col >> 24) & 0xFF;
        int r = MathHelper.clamp((int)(((col >> 16) & 0xFF) * factor), 0, 255);
        int g = MathHelper.clamp((int)(((col >> 8) & 0xFF) * factor), 0, 255);
        int b = MathHelper.clamp((int)((col & 0xFF) * factor), 0, 255);
        return (a << 24) | (r << 16) | (g << 8) | b;
    }
}
