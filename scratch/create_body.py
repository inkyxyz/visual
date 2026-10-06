import os

# 2. BodyAccessoriesModule.java
body_code = '''package rockstar.client;

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
    name = "BodyAccessories",
    category = ModuleCategory.PLAYER,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.body_accessories"
)
public class BodyAccessoriesModule extends Module {

    private MultiSelectSetting bodySetting;
    private MultiSelectSetting.Nested1_42856060 accValkyrie;
    private MultiSelectSetting.Nested1_42856060 accDevilTail;
    private MultiSelectSetting.Nested1_42856060 accSusanooRibs;
    private MultiSelectSetting.Nested1_42856060 accCyberBlades;
    private MultiSelectSetting.Nested1_42856060 accPhoenixAura;
    private MultiSelectSetting.Nested1_42856060 accDemonWingsTail;
    private MultiSelectSetting.Nested1_42856060 accSamuraiKatanas;
    private MultiSelectSetting.Nested1_42856060 accReaperScythe;
    private MultiSelectSetting.Nested1_42856060 accSciFiShoulderCannons;
    private MultiSelectSetting.Nested1_42856060 accNebulaCape;
    private MultiSelectSetting.Nested1_42856060 accCyberTailMech;
    private MultiSelectSetting.Nested1_42856060 accTentaclePlumes;
    private MultiSelectSetting.Nested1_42856060 accSusanooArmor;
    private MultiSelectSetting.Nested1_42856060 accCyberKatanaBack;
    private MultiSelectSetting.Nested1_42856060 accKitsuneNineTails;
    private MultiSelectSetting.Nested1_42856060 accDragonSkullShoulder;
    private MultiSelectSetting.Nested1_42856060 accNeonCyberSpine;
    private MultiSelectSetting.Nested1_42856060 accDemonicGreatsword;
    private MultiSelectSetting.Nested1_42856060 accCelestialAegisBack;
    private MultiSelectSetting.Nested1_42856060 accArcaneRuneCloak;
    private MultiSelectSetting.Nested1_42856060 accCyberBatteryPack;
    private MultiSelectSetting.Nested1_42856060 accAstralConstellationRibs;
    private MultiSelectSetting.Nested1_42856060 accDragonBoneWings;
    private MultiSelectSetting.Nested1_42856060 accQuantumSingularityOrb;
    private MultiSelectSetting.Nested1_42856060 accPlasmaCannonBack;
    private MultiSelectSetting.Nested1_42856060 accCyberJetpack;
    private MultiSelectSetting.Nested1_42856060 accTitanPauldrons;
    private MultiSelectSetting.Nested1_42856060 accHolographicWingsMini;
    private MultiSelectSetting.Nested1_42856060 accSolarFlareHalo;

    private SliderSetting scaleSetting;
    private SliderSetting yOffset;
    private SliderSetting animSpeed;
    private BooleanSetting syncTheme;
    private ColorSetting primaryColor;
    private ColorSetting accentColor;

    private final IiIIIiII_Class69<Render3DEvent> renderEvent = this::onRender3D;

    public BodyAccessoriesModule() {
        this.bodySetting = new MultiSelectSetting(this, "Torso & Armor");
        this.accValkyrie = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "ValkyrieWings");
        this.accDevilTail = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "DevilTail");
        this.accSusanooRibs = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "SusanooRibs");
        this.accCyberBlades = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "CyberBlades");
        this.accPhoenixAura = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "PhoenixAura");
        this.accDemonWingsTail = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "DemonWingsTail");
        this.accSamuraiKatanas = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "SamuraiKatanas");
        this.accReaperScythe = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "ReaperScythe");
        this.accSciFiShoulderCannons = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "SciFiCannons");
        this.accNebulaCape = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "NebulaCape");
        this.accCyberTailMech = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "MechTail");
        this.accTentaclePlumes = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "Tentacles");
        this.accSusanooArmor = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "SusanooArmor");
        this.accCyberKatanaBack = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "CyberKatanaBack");
        this.accKitsuneNineTails = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "KitsuneNineTails");
        this.accDragonSkullShoulder = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "DragonSkullShoulder");
        this.accNeonCyberSpine = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "NeonCyberSpine");
        this.accDemonicGreatsword = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "DemonicGreatsword");
        this.accCelestialAegisBack = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "CelestialAegis");
        this.accArcaneRuneCloak = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "ArcaneRuneCloak");
        this.accCyberBatteryPack = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "CyberBatteryPack");
        this.accAstralConstellationRibs = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "AstralConstellationRibs");
        this.accDragonBoneWings = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "DragonBoneWings");
        this.accQuantumSingularityOrb = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "QuantumSingularityOrb");
        this.accPlasmaCannonBack = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "PlasmaCannonBack");
        this.accCyberJetpack = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "CyberJetpack");
        this.accTitanPauldrons = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "TitanPauldrons");
        this.accHolographicWingsMini = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "HolographicWingsMini");
        this.accSolarFlareHalo = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "SolarFlareHalo");

        this.scaleSetting = new SliderSetting(this, "Scale")
            .I_method_c8c9a7d7(0.4F).i_method_65e2aff7(2.5F).II_method_b0f56334(0.05F).Ii_method_4e0e6b54(1.0F);

        this.yOffset = new SliderSetting(this, "Y Offset")
            .I_method_c8c9a7d7(-0.5F).i_method_65e2aff7(0.5F).II_method_b0f56334(0.02F).Ii_method_4e0e6b54(0.0F);

        this.animSpeed = new SliderSetting(this, "Anim Speed")
            .I_method_c8c9a7d7(0.0F).i_method_65e2aff7(3.0F).II_method_b0f56334(0.1F).Ii_method_4e0e6b54(1.0F);

        this.syncTheme = new BooleanSetting(this, "Sync Theme").I_method_decd82b5();
        this.primaryColor = new ColorSetting(this, "Primary Color").I_method_a62f5dd6(new ColorRGBA(245.0F, 185.0F, 70.0F, 255.0F));
        this.accentColor = new ColorSetting(this, "Accent Color").I_method_a62f5dd6(new ColorRGBA(255.0F, 70.0F, 110.0F, 255.0F));
    }

    @Override
    public String i_method_bf522194() {
        return "Volumetric 3D armor pieces, katanas, tails, and pauldrons anchored to the player torso.";
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
        float time = (now % 100000L) * 0.001F * this.animSpeed.Ii_method_a20abcd2();

        ColorRGBA themeCol = this.syncTheme.i_method_9b12da03()
            ? IiiiiIIIi_Class242.I_method_7df8e08e()
            : this.primaryColor.I_method_bde5f08e();
        ColorRGBA accentCol = this.accentColor.I_method_bde5f08e();

        int mainCol = themeCol.getRGB();
        int accCol = accentCol.getRGB();
        float scale = this.scaleSetting.Ii_method_a20abcd2();
        float yOff = this.yOffset.Ii_method_a20abcd2();

        MatrixStack m = event.getMatrices();

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        RenderSystem.depthMask(true);
        RenderSystem.disableCull();

        RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
        BufferBuilder buffer = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);

        if (this.accValkyrie.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderValkyrieWings(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accDevilTail.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderDevilTail(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accSusanooRibs.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderSusanooRibs(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accCyberBlades.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderCyberBlades(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accPhoenixAura.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderPhoenixAura(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accDemonWingsTail.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderDemonWingsTail(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accSamuraiKatanas.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderSamuraiKatanas(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accReaperScythe.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderReaperScythe(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accSciFiShoulderCannons.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderSciFiShoulderCannons(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accNebulaCape.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderNebulaCape(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accCyberTailMech.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderCyberTailMech(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accTentaclePlumes.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderTentaclePlumes(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accSusanooArmor.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderSusanooArmor(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accCyberKatanaBack.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderCyberKatanaBack(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accKitsuneNineTails.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderKitsuneNineTails(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accDragonSkullShoulder.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderDragonSkullShoulder(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accNeonCyberSpine.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderNeonCyberSpine(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accDemonicGreatsword.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderDemonicGreatsword(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accCelestialAegisBack.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderCelestialAegisBack(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accArcaneRuneCloak.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderArcaneRuneCloak(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accCyberBatteryPack.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderCyberBatteryPack(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accAstralConstellationRibs.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderAstralConstellationRibs(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accDragonBoneWings.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderDragonBoneWings(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accQuantumSingularityOrb.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderQuantumSingularityOrb(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accPlasmaCannonBack.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderPlasmaCannonBack(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accCyberJetpack.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderCyberJetpack(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accTitanPauldrons.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderTitanPauldrons(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accHolographicWingsMini.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderHolographicWingsMini(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accSolarFlareHalo.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderSolarFlareHalo(m, buffer, mainCol, accCol, time); m.pop();
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

with open(r'c:\Users\Admin-HP\Desktop\rockstar-client-src\src\main\java\rockstar\client\BodyAccessoriesModule.java', 'w', encoding='utf-8') as f:
    f.write(body_code)

print("BodyAccessoriesModule.java created!")
