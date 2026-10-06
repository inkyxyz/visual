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
    private MultiSelectSetting.Nested1_42856060 accCyberWings;
    private MultiSelectSetting.Nested1_42856060 accSamuraiKatanas;
    private MultiSelectSetting.Nested1_42856060 accReaperScythe;
    private MultiSelectSetting.Nested1_42856060 accSusanooRibs;
    private MultiSelectSetting.Nested1_42856060 accDevilTail;
    private MultiSelectSetting.Nested1_42856060 accCyberTail;
    private MultiSelectSetting.Nested1_42856060 accShoulderCannons;

    private SliderSetting scaleSetting;
    private SliderSetting yOffset;
    private SliderSetting animSpeed;
    private BooleanSetting syncTheme;
    private ColorSetting primaryColor;
    private ColorSetting accentColor;

    private final IiIIIiII_Class69<Render3DEvent> renderEvent = this::onRender3D;

    public BodyAccessoriesModule() {
        this.bodySetting = new MultiSelectSetting(this, "Body Accessories");
        this.accValkyrie = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "Valkyrie Wings");
        this.accCyberWings = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "Cyber Blades Wings");
        this.accSamuraiKatanas = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "Samurai Katanas");
        this.accReaperScythe = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "Reaper Scythe");
        this.accSusanooRibs = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "Susanoo Ribcage");
        this.accDevilTail = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "Devil Tail");
        this.accCyberTail = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "Cyber Mech Tail");
        this.accShoulderCannons = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "Shoulder Cannons");

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
        return "Эксклюзивная 3D броня, хвосты, катаны и аксессуары для тела персонажа.";
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
        if (this.accCyberWings.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderCyberBlades(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accSamuraiKatanas.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderSamuraiKatanas(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accReaperScythe.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderReaperScythe(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accSusanooRibs.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderSusanooRibs(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accDevilTail.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderDevilTail(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accCyberTail.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderCyberTailMech(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accShoulderCannons.isSelected()) {
            m.push(); AccessoryRenderHelper.applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale, yOff);
            AccessoryRenderHelper.renderSciFiShoulderCannons(m, buffer, mainCol, accCol, time); m.pop();
        }

        BuiltBuffer built = buffer.endNullable();
        if (built != null) {
            BufferRenderer.drawWithGlobalProgram(built);
        }

        RenderSystem.enableCull();
        RenderSystem.disableBlend();
    }
}
