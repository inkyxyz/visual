import os

# 3. MagicOrbitersModule.java
magic_code = '''package rockstar.client;

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
import net.minecraft.util.math.Vec3d;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;

@ModuleInfo(
    name = "MagicOrbiters",
    category = ModuleCategory.PLAYER,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.magic_orbiters"
)
public class MagicOrbitersModule extends Module {

    private MultiSelectSetting magicSetting;
    private MultiSelectSetting.Nested1_42856060 accShurikens;
    private MultiSelectSetting.Nested1_42856060 accFloatingCrystals;
    private MultiSelectSetting.Nested1_42856060 accFloatingSwords;
    private MultiSelectSetting.Nested1_42856060 accPortalRing;
    private MultiSelectSetting.Nested1_42856060 accHolyHalo;
    private MultiSelectSetting.Nested1_42856060 accAstralOrbs;
    private MultiSelectSetting.Nested1_42856060 accMagicCircleRing;
    private MultiSelectSetting.Nested1_42856060 accFloatingRunes;
    private MultiSelectSetting.Nested1_42856060 accFloatingDaggers;
    private MultiSelectSetting.Nested1_42856060 accChakraSpheres;
    private MultiSelectSetting.Nested1_42856060 accPlanetaryRings;
    private MultiSelectSetting.Nested1_42856060 accArchangelHalo;
    private MultiSelectSetting.Nested1_42856060 accBloodThornAura;
    private MultiSelectSetting.Nested1_42856060 accFloatingKunaiRing;
    private MultiSelectSetting.Nested1_42856060 accArcaneOrbitalShields;
    private MultiSelectSetting.Nested1_42856060 accTarotCardsOrbit;
    private MultiSelectSetting.Nested1_42856060 accQuantumCubes;
    private MultiSelectSetting.Nested1_42856060 accPhoenixFeathersOrbit;
    private MultiSelectSetting.Nested1_42856060 accDragonPearls;
    private MultiSelectSetting.Nested1_42856060 accArcanePentagram;
    private MultiSelectSetting.Nested1_42856060 accVoidRiftRing;

    private SliderSetting radiusSetting;
    private SliderSetting speedSetting;
    private SliderSetting yOffset;
    private SliderSetting scaleSetting;
    private BooleanSetting syncTheme;
    private ColorSetting primaryColor;
    private ColorSetting accentColor;

    private final IiIIIiII_Class69<Render3DEvent> renderEvent = this::onRender3D;

    public MagicOrbitersModule() {
        this.magicSetting = new MultiSelectSetting(this, "Orbiting Relics");
        this.accShurikens = new MultiSelectSetting.Nested1_42856060(this.magicSetting, "Shurikens").select();
        this.accFloatingCrystals = new MultiSelectSetting.Nested1_42856060(this.magicSetting, "FloatingCrystals");
        this.accFloatingSwords = new MultiSelectSetting.Nested1_42856060(this.magicSetting, "FloatingSwords");
        this.accPortalRing = new MultiSelectSetting.Nested1_42856060(this.magicSetting, "PortalRing");
        this.accHolyHalo = new MultiSelectSetting.Nested1_42856060(this.magicSetting, "HolyRelic");
        this.accAstralOrbs = new MultiSelectSetting.Nested1_42856060(this.magicSetting, "AstralOrbs");
        this.accMagicCircleRing = new MultiSelectSetting.Nested1_42856060(this.magicSetting, "MagicCircle");
        this.accFloatingRunes = new MultiSelectSetting.Nested1_42856060(this.magicSetting, "FloatingRunes");
        this.accFloatingDaggers = new MultiSelectSetting.Nested1_42856060(this.magicSetting, "FloatingDaggers");
        this.accChakraSpheres = new MultiSelectSetting.Nested1_42856060(this.magicSetting, "ChakraSpheres");
        this.accPlanetaryRings = new MultiSelectSetting.Nested1_42856060(this.magicSetting, "PlanetaryRings");
        this.accArchangelHalo = new MultiSelectSetting.Nested1_42856060(this.magicSetting, "ArchangelHalo");
        this.accBloodThornAura = new MultiSelectSetting.Nested1_42856060(this.magicSetting, "BloodThornAura");
        this.accFloatingKunaiRing = new MultiSelectSetting.Nested1_42856060(this.magicSetting, "FloatingKunaiRing");
        this.accArcaneOrbitalShields = new MultiSelectSetting.Nested1_42856060(this.magicSetting, "ArcaneOrbitalShields");
        this.accTarotCardsOrbit = new MultiSelectSetting.Nested1_42856060(this.magicSetting, "TarotCardsOrbit");
        this.accQuantumCubes = new MultiSelectSetting.Nested1_42856060(this.magicSetting, "QuantumCubes");
        this.accPhoenixFeathersOrbit = new MultiSelectSetting.Nested1_42856060(this.magicSetting, "PhoenixFeathersOrbit");
        this.accDragonPearls = new MultiSelectSetting.Nested1_42856060(this.magicSetting, "DragonPearls");
        this.accArcanePentagram = new MultiSelectSetting.Nested1_42856060(this.magicSetting, "ArcanePentagram");
        this.accVoidRiftRing = new MultiSelectSetting.Nested1_42856060(this.magicSetting, "VoidRiftRing");

        this.radiusSetting = new SliderSetting(this, "Orbit Radius")
            .I_method_c8c9a7d7(0.5F).i_method_65e2aff7(3.0F).II_method_b0f56334(0.1F).Ii_method_4e0e6b54(1.2F);

        this.speedSetting = new SliderSetting(this, "Orbit Speed")
            .I_method_c8c9a7d7(0.0F).i_method_65e2aff7(3.0F).II_method_b0f56334(0.1F).Ii_method_4e0e6b54(1.0F);

        this.yOffset = new SliderSetting(this, "Height Offset")
            .I_method_c8c9a7d7(-0.6F).i_method_65e2aff7(0.8F).II_method_b0f56334(0.02F).Ii_method_4e0e6b54(0.0F);

        this.scaleSetting = new SliderSetting(this, "Scale")
            .I_method_c8c9a7d7(0.4F).i_method_65e2aff7(2.5F).II_method_b0f56334(0.05F).Ii_method_4e0e6b54(1.0F);

        this.syncTheme = new BooleanSetting(this, "Sync Theme").I_method_decd82b5();
        this.primaryColor = new ColorSetting(this, "Primary Color").I_method_a62f5dd6(new ColorRGBA(245.0F, 185.0F, 70.0F, 255.0F));
        this.accentColor = new ColorSetting(this, "Accent Color").I_method_a62f5dd6(new ColorRGBA(255.0F, 70.0F, 110.0F, 255.0F));
    }

    @Override
    public String i_method_bf522194() {
        return "Magical rotating orbs, crystals, swords, runic seals, and geometric orbital rings.";
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
        float headYaw = MathHelper.lerp(td, player.prevHeadYaw, player.headYaw);
        float headPitch = MathHelper.lerp(td, player.prevPitch, player.getPitch());

        double ix = px - cam.x;
        double iy = py - cam.y;
        double iz = pz - cam.z;

        long now = System.currentTimeMillis();
        float time = (now % 100000L) * 0.001F * this.speedSetting.Ii_method_a20abcd2();

        ColorRGBA themeCol = this.syncTheme.i_method_9b12da03()
            ? IiiiiIIIi_Class242.I_method_7df8e08e()
            : this.primaryColor.I_method_bde5f08e();
        ColorRGBA accentCol = this.accentColor.I_method_bde5f08e();

        int mainCol = themeCol.getRGB();
        int accCol = accentCol.getRGB();
        float scale = this.scaleSetting.Ii_method_a20abcd2();
        float rad = this.radiusSetting.Ii_method_a20abcd2();
        float yOff = this.yOffset.Ii_method_a20abcd2();

        MatrixStack m = event.getMatrices();

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        RenderSystem.depthMask(true);
        RenderSystem.disableCull();

        // 1. Shuriken Texture pass
        if (this.accShurikens.isSelected()) {
            m.push();
            AccessoryRenderHelper.applyOrbitAnchor(m, player, ix, iy, iz, bodyYaw, scale, rad, yOff);
            RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
            RenderSystem.setShaderTexture(0, AccessoryRenderHelper.TEX_SHURIKEN);
            BufferBuilder texBuffer = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
            AccessoryRenderHelper.renderShurikens(m, texBuffer, mainCol, time);
            BuiltBuffer builtTex = texBuffer.endNullable();
            if (builtTex != null) {
                BufferRenderer.drawWithGlobalProgram(builtTex);
            }
            m.pop();
        }

        // 2. Solid volumetric pass
        RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
        BufferBuilder buffer = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);

        if (this.accFloatingCrystals.isSelected()) {
            m.push(); AccessoryRenderHelper.applyOrbitAnchor(m, player, ix, iy, iz, bodyYaw, scale, rad, yOff);
            AccessoryRenderHelper.renderFloatingCrystals(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accFloatingSwords.isSelected()) {
            m.push(); AccessoryRenderHelper.applyOrbitAnchor(m, player, ix, iy, iz, bodyYaw, scale, rad, yOff);
            AccessoryRenderHelper.renderFloatingSwords(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accPortalRing.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderPortalRing(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accHolyHalo.isSelected()) {
            m.push(); AccessoryRenderHelper.applyOrbitAnchor(m, player, ix, iy, iz, bodyYaw, scale, rad, yOff);
            AccessoryRenderHelper.renderHolyRelic(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accAstralOrbs.isSelected()) {
            m.push(); AccessoryRenderHelper.applyOrbitAnchor(m, player, ix, iy, iz, bodyYaw, scale, rad, yOff);
            AccessoryRenderHelper.renderAstralOrbs(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accMagicCircleRing.isSelected()) {
            m.push(); AccessoryRenderHelper.applyOrbitAnchor(m, player, ix, iy, iz, bodyYaw, scale, rad, yOff);
            AccessoryRenderHelper.renderMagicCircleRing(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accFloatingRunes.isSelected()) {
            m.push(); AccessoryRenderHelper.applyOrbitAnchor(m, player, ix, iy, iz, bodyYaw, scale, rad, yOff);
            AccessoryRenderHelper.renderFloatingRunes(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accFloatingDaggers.isSelected()) {
            m.push(); AccessoryRenderHelper.applyOrbitAnchor(m, player, ix, iy, iz, bodyYaw, scale, rad, yOff);
            AccessoryRenderHelper.renderFloatingDaggers(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accChakraSpheres.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderChakraSpheres(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accPlanetaryRings.isSelected()) {
            m.push(); AccessoryRenderHelper.applyOrbitAnchor(m, player, ix, iy, iz, bodyYaw, scale, rad, yOff);
            AccessoryRenderHelper.renderPlanetaryRings(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accArchangelHalo.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderArchangelHalo(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accBloodThornAura.isSelected()) {
            m.push(); AccessoryRenderHelper.applyOrbitAnchor(m, player, ix, iy, iz, bodyYaw, scale, rad, yOff);
            AccessoryRenderHelper.renderBloodThornAura(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accFloatingKunaiRing.isSelected()) {
            m.push(); AccessoryRenderHelper.applyOrbitAnchor(m, player, ix, iy, iz, bodyYaw, scale, rad, yOff);
            AccessoryRenderHelper.renderFloatingKunaiRing(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accArcaneOrbitalShields.isSelected()) {
            m.push(); AccessoryRenderHelper.applyOrbitAnchor(m, player, ix, iy, iz, bodyYaw, scale, rad, yOff);
            AccessoryRenderHelper.renderArcaneOrbitalShields(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accTarotCardsOrbit.isSelected()) {
            m.push(); AccessoryRenderHelper.applyOrbitAnchor(m, player, ix, iy, iz, bodyYaw, scale, rad, yOff);
            AccessoryRenderHelper.renderTarotCardsOrbit(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accQuantumCubes.isSelected()) {
            m.push(); AccessoryRenderHelper.applyOrbitAnchor(m, player, ix, iy, iz, bodyYaw, scale, rad, yOff);
            AccessoryRenderHelper.renderQuantumCubes(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accPhoenixFeathersOrbit.isSelected()) {
            m.push(); AccessoryRenderHelper.applyOrbitAnchor(m, player, ix, iy, iz, bodyYaw, scale, rad, yOff);
            AccessoryRenderHelper.renderPhoenixFeathersOrbit(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accDragonPearls.isSelected()) {
            m.push(); AccessoryRenderHelper.applyOrbitAnchor(m, player, ix, iy, iz, bodyYaw, scale, rad, yOff);
            AccessoryRenderHelper.renderDragonPearls(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accArcanePentagram.isSelected()) {
            m.push(); AccessoryRenderHelper.applyOrbitAnchor(m, player, ix, iy, iz, bodyYaw, scale, rad, yOff);
            AccessoryRenderHelper.renderArcanePentagram(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accVoidRiftRing.isSelected()) {
            m.push(); AccessoryRenderHelper.applyOrbitAnchor(m, player, ix, iy, iz, bodyYaw, scale, rad, yOff);
            AccessoryRenderHelper.renderVoidRiftRing(m, buffer, mainCol, accCol, time); m.pop();
        }

        BuiltBuffer built = buffer.endNullable();
        if (built != null) {
            BufferRenderer.drawWithGlobalProgram(built);
        }

        RenderSystem.depthMask(true);
        RenderSystem.enableCull();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableBlend();
    }
}
'''

# 4. PetsModule.java
pets_code = '''package rockstar.client;

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
import net.minecraft.util.math.Vec3d;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;

@ModuleInfo(
    name = "Pets",
    category = ModuleCategory.PLAYER,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.pets"
)
public class PetsModule extends Module {

    private MultiSelectSetting petSetting;
    private MultiSelectSetting.Nested1_42856060 accDroidPet;
    private MultiSelectSetting.Nested1_42856060 accGhostPet;
    private MultiSelectSetting.Nested1_42856060 accButterfly;
    private MultiSelectSetting.Nested1_42856060 accCyberHoverDrone;
    private MultiSelectSetting.Nested1_42856060 accVoidSingularityPet;
    private MultiSelectSetting.Nested1_42856060 accChronoRelicClock;
    private MultiSelectSetting.Nested1_42856060 accCyberFoxPet;
    private MultiSelectSetting.Nested1_42856060 accDragonWhelpPet;
    private MultiSelectSetting.Nested1_42856060 accSpiritWispPet;
    private MultiSelectSetting.Nested1_42856060 accCyberSkullPet;
    private MultiSelectSetting.Nested1_42856060 accSlimeCompanion;
    private MultiSelectSetting.Nested1_42856060 accFloatingGrimoire;
    private MultiSelectSetting.Nested1_42856060 accSpiritFoxLantern;

    private SliderSetting distanceSetting;
    private SliderSetting yOffset;
    private SliderSetting speedSetting;
    private SliderSetting scaleSetting;
    private BooleanSetting syncTheme;
    private ColorSetting primaryColor;
    private ColorSetting accentColor;

    private final IiIIIiII_Class69<Render3DEvent> renderEvent = this::onRender3D;

    public PetsModule() {
        this.petSetting = new MultiSelectSetting(this, "Active Companions");
        this.accDroidPet = new MultiSelectSetting.Nested1_42856060(this.petSetting, "DroidPet").select();
        this.accGhostPet = new MultiSelectSetting.Nested1_42856060(this.petSetting, "GhostPet");
        this.accButterfly = new MultiSelectSetting.Nested1_42856060(this.petSetting, "Butterfly");
        this.accCyberHoverDrone = new MultiSelectSetting.Nested1_42856060(this.petSetting, "CyberHoverDrone");
        this.accVoidSingularityPet = new MultiSelectSetting.Nested1_42856060(this.petSetting, "VoidSingularityPet");
        this.accChronoRelicClock = new MultiSelectSetting.Nested1_42856060(this.petSetting, "ChronoRelic");
        this.accCyberFoxPet = new MultiSelectSetting.Nested1_42856060(this.petSetting, "CyberFoxPet");
        this.accDragonWhelpPet = new MultiSelectSetting.Nested1_42856060(this.petSetting, "DragonWhelpPet");
        this.accSpiritWispPet = new MultiSelectSetting.Nested1_42856060(this.petSetting, "SpiritWispPet");
        this.accCyberSkullPet = new MultiSelectSetting.Nested1_42856060(this.petSetting, "CyberSkullPet");
        this.accSlimeCompanion = new MultiSelectSetting.Nested1_42856060(this.petSetting, "SlimeCompanion");
        this.accFloatingGrimoire = new MultiSelectSetting.Nested1_42856060(this.petSetting, "FloatingGrimoire");
        this.accSpiritFoxLantern = new MultiSelectSetting.Nested1_42856060(this.petSetting, "SpiritFoxLantern");

        this.distanceSetting = new SliderSetting(this, "Distance")
            .I_method_c8c9a7d7(0.5F).i_method_65e2aff7(2.5F).II_method_b0f56334(0.1F).Ii_method_4e0e6b54(1.0F);

        this.yOffset = new SliderSetting(this, "Y Offset")
            .I_method_c8c9a7d7(-0.5F).i_method_65e2aff7(0.5F).II_method_b0f56334(0.02F).Ii_method_4e0e6b54(0.0F);

        this.speedSetting = new SliderSetting(this, "Speed")
            .I_method_c8c9a7d7(0.0F).i_method_65e2aff7(3.0F).II_method_b0f56334(0.1F).Ii_method_4e0e6b54(1.0F);

        this.scaleSetting = new SliderSetting(this, "Scale")
            .I_method_c8c9a7d7(0.4F).i_method_65e2aff7(2.5F).II_method_b0f56334(0.05F).Ii_method_4e0e6b54(1.0F);

        this.syncTheme = new BooleanSetting(this, "Sync Theme").I_method_decd82b5();
        this.primaryColor = new ColorSetting(this, "Primary Color").I_method_a62f5dd6(new ColorRGBA(245.0F, 185.0F, 70.0F, 255.0F));
        this.accentColor = new ColorSetting(this, "Accent Color").I_method_a62f5dd6(new ColorRGBA(255.0F, 70.0F, 110.0F, 255.0F));
    }

    @Override
    public String i_method_bf522194() {
        return "Loyal animated 3D pets, familiars, and hovering drones floating around the player.";
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

        long now = System.currentTimeMillis();
        float time = (now % 100000L) * 0.001F * this.speedSetting.Ii_method_a20abcd2();

        ColorRGBA themeCol = this.syncTheme.i_method_9b12da03()
            ? IiiiiIIIi_Class242.I_method_7df8e08e()
            : this.primaryColor.I_method_bde5f08e();
        ColorRGBA accentCol = this.accentColor.I_method_bde5f08e();

        int mainCol = themeCol.getRGB();
        int accCol = accentCol.getRGB();
        float scale = this.scaleSetting.Ii_method_a20abcd2();
        float dist = this.distanceSetting.Ii_method_a20abcd2();
        float yOff = this.yOffset.Ii_method_a20abcd2();

        MatrixStack m = event.getMatrices();

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        RenderSystem.depthMask(true);
        RenderSystem.disableCull();

        RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
        BufferBuilder buffer = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);

        if (this.accDroidPet.isSelected()) {
            m.push(); AccessoryRenderHelper.applyPetAnchor(m, player, ix, iy, iz, bodyYaw, scale, dist, yOff);
            AccessoryRenderHelper.renderDroidPet(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accGhostPet.isSelected()) {
            m.push(); AccessoryRenderHelper.applyPetAnchor(m, player, ix, iy, iz, bodyYaw, scale, dist, yOff);
            AccessoryRenderHelper.renderGhostPet(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accButterfly.isSelected()) {
            m.push(); AccessoryRenderHelper.applyPetAnchor(m, player, ix, iy, iz, bodyYaw, scale, dist, yOff);
            AccessoryRenderHelper.renderButterfly(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accCyberHoverDrone.isSelected()) {
            m.push(); AccessoryRenderHelper.applyPetAnchor(m, player, ix, iy, iz, bodyYaw, scale, dist, yOff);
            AccessoryRenderHelper.renderCyberHoverDrone(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accVoidSingularityPet.isSelected()) {
            m.push(); AccessoryRenderHelper.applyPetAnchor(m, player, ix, iy, iz, bodyYaw, scale, dist, yOff);
            AccessoryRenderHelper.renderVoidSingularityPet(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accChronoRelicClock.isSelected()) {
            m.push(); AccessoryRenderHelper.applyPetAnchor(m, player, ix, iy, iz, bodyYaw, scale, dist, yOff);
            AccessoryRenderHelper.renderChronoRelicClock(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accCyberFoxPet.isSelected()) {
            m.push(); AccessoryRenderHelper.applyPetAnchor(m, player, ix, iy, iz, bodyYaw, scale, dist, yOff);
            AccessoryRenderHelper.renderCyberFoxPet(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accDragonWhelpPet.isSelected()) {
            m.push(); AccessoryRenderHelper.applyPetAnchor(m, player, ix, iy, iz, bodyYaw, scale, dist, yOff);
            AccessoryRenderHelper.renderDragonWhelpPet(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accSpiritWispPet.isSelected()) {
            m.push(); AccessoryRenderHelper.applyPetAnchor(m, player, ix, iy, iz, bodyYaw, scale, dist, yOff);
            AccessoryRenderHelper.renderSpiritWispPet(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accCyberSkullPet.isSelected()) {
            m.push(); AccessoryRenderHelper.applyPetAnchor(m, player, ix, iy, iz, bodyYaw, scale, dist, yOff);
            AccessoryRenderHelper.renderCyberSkullPet(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accSlimeCompanion.isSelected()) {
            m.push(); AccessoryRenderHelper.applyPetAnchor(m, player, ix, iy, iz, bodyYaw, scale, dist, yOff);
            AccessoryRenderHelper.renderSlimeCompanion(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accFloatingGrimoire.isSelected()) {
            m.push(); AccessoryRenderHelper.applyPetAnchor(m, player, ix, iy, iz, bodyYaw, scale, dist, yOff);
            AccessoryRenderHelper.renderFloatingGrimoire(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accSpiritFoxLantern.isSelected()) {
            m.push(); AccessoryRenderHelper.applyPetAnchor(m, player, ix, iy, iz, bodyYaw, scale, dist, yOff);
            AccessoryRenderHelper.renderSpiritFoxLantern(m, buffer, mainCol, accCol, time); m.pop();
        }

        BuiltBuffer built = buffer.endNullable();
        if (built != null) {
            BufferRenderer.drawWithGlobalProgram(built);
        }

        RenderSystem.depthMask(true);
        RenderSystem.enableCull();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableBlend();
    }
}
'''

with open(r'c:\Users\Admin-HP\Desktop\rockstar-client-src\src\main\java\rockstar\client\MagicOrbitersModule.java', 'w', encoding='utf-8') as f:
    f.write(magic_code)

with open(r'c:\Users\Admin-HP\Desktop\rockstar-client-src\src\main\java\rockstar\client\PetsModule.java', 'w', encoding='utf-8') as f:
    f.write(pets_code)

print("MagicOrbitersModule.java & PetsModule.java created!")
