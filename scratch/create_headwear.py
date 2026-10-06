import os

# 1. HeadwearModule.java
headwear_code = '''package rockstar.client;

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
    name = "Headwear",
    category = ModuleCategory.PLAYER,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.headwear"
)
public class HeadwearModule extends Module {

    private MultiSelectSetting headSetting;
    private MultiSelectSetting.Nested1_42856060 accCatEars;
    private MultiSelectSetting.Nested1_42856060 accFoxEars;
    private MultiSelectSetting.Nested1_42856060 accBunnyEars;
    private MultiSelectSetting.Nested1_42856060 accHorns;
    private MultiSelectSetting.Nested1_42856060 accCrown;
    private MultiSelectSetting.Nested1_42856060 accTopHat;
    private MultiSelectSetting.Nested1_42856060 accCyberVisor;
    private MultiSelectSetting.Nested1_42856060 accHeadphones;
    private MultiSelectSetting.Nested1_42856060 accTacticalMask;
    private MultiSelectSetting.Nested1_42856060 accWizardHat;
    private MultiSelectSetting.Nested1_42856060 accSamuraiKasa;
    private MultiSelectSetting.Nested1_42856060 accDragonHorns;
    private MultiSelectSetting.Nested1_42856060 accKitsuneMask;
    private MultiSelectSetting.Nested1_42856060 accGlitchCrown;
    private MultiSelectSetting.Nested1_42856060 accCrownOfThorns;
    private MultiSelectSetting.Nested1_42856060 accValkyrieTiara;
    private MultiSelectSetting.Nested1_42856060 accShogunMask;
    private MultiSelectSetting.Nested1_42856060 accCyberVisorV2;
    private MultiSelectSetting.Nested1_42856060 accAnimeAhoge;
    private MultiSelectSetting.Nested1_42856060 accHaloCross;
    private MultiSelectSetting.Nested1_42856060 accAngelHaloTwin;
    private MultiSelectSetting.Nested1_42856060 accSteampunkGoggles;
    private MultiSelectSetting.Nested1_42856060 accShinigamiMask;
    private MultiSelectSetting.Nested1_42856060 accSamuraiKabuto;
    private MultiSelectSetting.Nested1_42856060 accFrostbiteHorns;
    private MultiSelectSetting.Nested1_42856060 accSolarEclipseCrown;
    private MultiSelectSetting.Nested1_42856060 accLuckyDice;
    private MultiSelectSetting.Nested1_42856060 accCyberHorns;
    private MultiSelectSetting.Nested1_42856060 accOniMask;
    private MultiSelectSetting.Nested1_42856060 accCyberGogglesHUD;
    private MultiSelectSetting.Nested1_42856060 accStarCirclet;
    private MultiSelectSetting.Nested1_42856060 accPhantomCrown;
    private MultiSelectSetting.Nested1_42856060 accDragonEyesBand;
    private MultiSelectSetting.Nested1_42856060 accChronoMonocle;
    private MultiSelectSetting.Nested1_42856060 accFlowerWreath;
    private MultiSelectSetting.Nested1_42856060 accNinjaBandana;
    private MultiSelectSetting.Nested1_42856060 accPhoenixCrestCrown;

    private SliderSetting scaleSetting;
    private SliderSetting yOffset;
    private SliderSetting animSpeed;
    private BooleanSetting syncTheme;
    private ColorSetting primaryColor;
    private ColorSetting accentColor;

    private final IiIIIiII_Class69<Render3DEvent> renderEvent = this::onRender3D;

    public HeadwearModule() {
        this.headSetting = new MultiSelectSetting(this, "Headwear & Face");
        this.accCatEars = new MultiSelectSetting.Nested1_42856060(this.headSetting, "CatEars").select();
        this.accFoxEars = new MultiSelectSetting.Nested1_42856060(this.headSetting, "FoxEars");
        this.accBunnyEars = new MultiSelectSetting.Nested1_42856060(this.headSetting, "BunnyEars");
        this.accHorns = new MultiSelectSetting.Nested1_42856060(this.headSetting, "DemonHorns");
        this.accCrown = new MultiSelectSetting.Nested1_42856060(this.headSetting, "RoyalCrown");
        this.accTopHat = new MultiSelectSetting.Nested1_42856060(this.headSetting, "TopHat");
        this.accCyberVisor = new MultiSelectSetting.Nested1_42856060(this.headSetting, "CyberVisor");
        this.accHeadphones = new MultiSelectSetting.Nested1_42856060(this.headSetting, "Headphones");
        this.accTacticalMask = new MultiSelectSetting.Nested1_42856060(this.headSetting, "TacticalMask");
        this.accWizardHat = new MultiSelectSetting.Nested1_42856060(this.headSetting, "WizardHat");
        this.accSamuraiKasa = new MultiSelectSetting.Nested1_42856060(this.headSetting, "SamuraiKasa");
        this.accDragonHorns = new MultiSelectSetting.Nested1_42856060(this.headSetting, "DragonHorns");
        this.accKitsuneMask = new MultiSelectSetting.Nested1_42856060(this.headSetting, "KitsuneMask");
        this.accGlitchCrown = new MultiSelectSetting.Nested1_42856060(this.headSetting, "GlitchCrown");
        this.accCrownOfThorns = new MultiSelectSetting.Nested1_42856060(this.headSetting, "CrownOfThorns");
        this.accValkyrieTiara = new MultiSelectSetting.Nested1_42856060(this.headSetting, "ValkyrieTiara");
        this.accShogunMask = new MultiSelectSetting.Nested1_42856060(this.headSetting, "ShogunMask");
        this.accCyberVisorV2 = new MultiSelectSetting.Nested1_42856060(this.headSetting, "CyberVisorV2");
        this.accAnimeAhoge = new MultiSelectSetting.Nested1_42856060(this.headSetting, "AnimeAhoge");
        this.accHaloCross = new MultiSelectSetting.Nested1_42856060(this.headSetting, "HaloCross");
        this.accAngelHaloTwin = new MultiSelectSetting.Nested1_42856060(this.headSetting, "AngelHaloTwin");
        this.accSteampunkGoggles = new MultiSelectSetting.Nested1_42856060(this.headSetting, "SteampunkGoggles");
        this.accShinigamiMask = new MultiSelectSetting.Nested1_42856060(this.headSetting, "ShinigamiMask");
        this.accSamuraiKabuto = new MultiSelectSetting.Nested1_42856060(this.headSetting, "SamuraiKabuto");
        this.accFrostbiteHorns = new MultiSelectSetting.Nested1_42856060(this.headSetting, "FrostbiteHorns");
        this.accSolarEclipseCrown = new MultiSelectSetting.Nested1_42856060(this.headSetting, "SolarEclipseCrown");
        this.accLuckyDice = new MultiSelectSetting.Nested1_42856060(this.headSetting, "LuckyDice");
        this.accCyberHorns = new MultiSelectSetting.Nested1_42856060(this.headSetting, "CyberHorns");
        this.accOniMask = new MultiSelectSetting.Nested1_42856060(this.headSetting, "OniMask");
        this.accCyberGogglesHUD = new MultiSelectSetting.Nested1_42856060(this.headSetting, "CyberGogglesHUD");
        this.accStarCirclet = new MultiSelectSetting.Nested1_42856060(this.headSetting, "StarCirclet");
        this.accPhantomCrown = new MultiSelectSetting.Nested1_42856060(this.headSetting, "PhantomCrown");
        this.accDragonEyesBand = new MultiSelectSetting.Nested1_42856060(this.headSetting, "DragonEyesBand");
        this.accChronoMonocle = new MultiSelectSetting.Nested1_42856060(this.headSetting, "ChronoMonocle");
        this.accFlowerWreath = new MultiSelectSetting.Nested1_42856060(this.headSetting, "FlowerWreath");
        this.accNinjaBandana = new MultiSelectSetting.Nested1_42856060(this.headSetting, "NinjaBandana");
        this.accPhoenixCrestCrown = new MultiSelectSetting.Nested1_42856060(this.headSetting, "PhoenixCrest");

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
        return "Volumetric 3D headwear, masks, horns, and crowns with realistic lighting and full head tracking.";
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
        float headYaw = MathHelper.lerp(td, player.prevHeadYaw, player.headYaw);
        float headPitch = MathHelper.lerp(td, player.prevPitch, player.getPitch());
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

        if (this.accCatEars.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderCatEars(m, buffer, mainCol, time); m.pop();
        }
        if (this.accFoxEars.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderFoxEars(m, buffer, mainCol, time); m.pop();
        }
        if (this.accBunnyEars.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderBunnyEars(m, buffer, mainCol, time); m.pop();
        }
        if (this.accHorns.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderDemonHorns(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accCrown.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderRoyalCrown(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accTopHat.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderTopHat(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accCyberVisor.isSelected()) {
            m.push(); AccessoryRenderHelper.applyFaceAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderCyberVisor(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accHeadphones.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderHeadphones(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accTacticalMask.isSelected()) {
            m.push(); AccessoryRenderHelper.applyFaceAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderTacticalMask(m, buffer, mainCol, accCol); m.pop();
        }
        if (this.accWizardHat.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderWizardHat(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accSamuraiKasa.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderSamuraiKasa(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accDragonHorns.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderDragonHorns(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accKitsuneMask.isSelected()) {
            m.push(); AccessoryRenderHelper.applyFaceAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderKitsuneMask(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accGlitchCrown.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderGlitchCrown(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accCrownOfThorns.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderCrownOfThorns(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accValkyrieTiara.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderValkyrieTiara(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accShogunMask.isSelected()) {
            m.push(); AccessoryRenderHelper.applyFaceAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderShogunMask(m, buffer, mainCol, accCol); m.pop();
        }
        if (this.accCyberVisorV2.isSelected()) {
            m.push(); AccessoryRenderHelper.applyFaceAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderCyberVisorV2(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accAnimeAhoge.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderAnimeAhoge(m, buffer, mainCol, time); m.pop();
        }
        if (this.accHaloCross.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderHaloCross(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accAngelHaloTwin.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderAngelHaloTwin(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accSteampunkGoggles.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderSteampunkGoggles(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accShinigamiMask.isSelected()) {
            m.push(); AccessoryRenderHelper.applyFaceAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderShinigamiMask(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accSamuraiKabuto.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderSamuraiKabuto(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accFrostbiteHorns.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderFrostbiteHorns(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accSolarEclipseCrown.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderSolarEclipseCrown(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accLuckyDice.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderLuckyDice(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accCyberHorns.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderCyberHorns(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accOniMask.isSelected()) {
            m.push(); AccessoryRenderHelper.applyFaceAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderOniMask(m, buffer, mainCol, accCol); m.pop();
        }
        if (this.accCyberGogglesHUD.isSelected()) {
            m.push(); AccessoryRenderHelper.applyFaceAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderCyberGogglesHUD(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accStarCirclet.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderStarCirclet(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accPhantomCrown.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderPhantomCrown(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accDragonEyesBand.isSelected()) {
            m.push(); AccessoryRenderHelper.applyFaceAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderDragonEyesBand(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accChronoMonocle.isSelected()) {
            m.push(); AccessoryRenderHelper.applyFaceAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderChronoMonocle(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accFlowerWreath.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderFlowerWreath(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accNinjaBandana.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderNinjaBandana(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accPhoenixCrestCrown.isSelected()) {
            m.push(); AccessoryRenderHelper.applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderPhoenixCrestCrown(m, buffer, mainCol, accCol, time); m.pop();
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

with open(r'c:\Users\Admin-HP\Desktop\rockstar-client-src\src\main\java\rockstar\client\HeadwearModule.java', 'w', encoding='utf-8') as f:
    f.write(headwear_code)

print("HeadwearModule.java created!")
