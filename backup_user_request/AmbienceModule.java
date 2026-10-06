package rockstar.client;

import java.util.HashSet;
import java.util.Set;
import lombok.Generated;
import net.minecraft.block.enums.CameraSubmersionType;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.network.packet.s2c.play.WorldTimeUpdateS2CPacket;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkSectionPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.LightType;
import net.minecraft.world.biome.Biome;
import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.render.VertexFormats;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import pyrock.events.network.ReceivePacketEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.IIIIiI_Class3;
import rockstar.client.IIiIII_Class9;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.BooleanSetting;
import rockstar.client.ColorSetting;
import rockstar.client.SectionSetting;
import rockstar.client.ModeSetting;
import rockstar.client.MultiSelectSetting;
import rockstar.client.SliderSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.ModuleInfo;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.IiiiiiiII_Class253;
import rockstar.client.iIIii_Class20;
import rockstar.client.iIiiIIiii_Class360;
import rockstar.client.iIiiIiIII_Class361;
import rockstar.client.iIiiiIIIi_Class370;
import rockstar.client.iIiiiiIIi_Class378;
import rockstar.client.Module;
import rockstar.client.iiiIiii_Class120;
import ua.mintantileak.spk.Compile;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import pyrock.events.render.HudRenderEvent;

@ModuleInfo(name="Ambience", category=ModuleCategory.VISUALS, iI_method_476ab839=true, III_method_a89e5834="modules.descriptions.ambience")
public class AmbienceModule
extends Module {
    private ModeSetting atmospherePreset;
    private ModeSetting.Nested1_42765c60 presetCustom;
    private ModeSetting.Nested1_42765c60 presetWinter;
    private ModeSetting.Nested1_42765c60 presetFlame;
    private ModeSetting.Nested1_42765c60 presetDawn;
    private ModeSetting.Nested1_42765c60 presetSunset;

    private BooleanSetting blockSnowCover;
    private BooleanSetting screenAtmosphere;
    private ColorSetting compositionColor;
    private SliderSetting compositionStrength;
    private SliderSetting particleCount;
    private SliderSetting particleSpeed;
    private SliderSetting particleSize;
    private SliderSetting screenIntensity;
    private SliderSetting screenBorderSize;

    private MultiSelectSetting I_field_bbe3ba6c;
    private MultiSelectSetting.Nested1_42856060 I_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 i_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 II_field_51de8227;
    private BooleanSetting II_field_ba20ca4c;
    private ColorSetting I_field_bbd4b66c;
    private ColorSetting i_field_bbd4b66c;
    private ColorSetting II_field_bbd4b66c;
    private ModeSetting I_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 I_field_500d0627;
    private ModeSetting.Nested1_42765c60 i_field_500d0627;
    private ModeSetting.Nested1_42765c60 II_field_500d0627;
    private ModeSetting.Nested1_42765c60 Ii_field_500d0627;
    private ModeSetting.Nested1_42765c60 iI_field_500d0627;
    private ModeSetting.Nested1_42765c60 ii_field_500d0627;
    private BooleanSetting Ii_field_ba20ca4c;
    private ModeSetting i_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 III_field_500d0627;
    private ModeSetting.Nested1_42765c60 IIi_field_500d0627;
    private ModeSetting.Nested1_42765c60 IiI_field_500d0627;
    private ModeSetting.Nested1_42765c60 Iii_field_500d0627;
    private SliderSetting I_field_73178e8c;
    private BooleanSetting iI_field_ba20ca4c;
    private SliderSetting i_field_73178e8c;
    private SliderSetting II_field_73178e8c;
    private SliderSetting Ii_field_73178e8c;
    private SliderSetting iI_field_73178e8c;
    private BooleanSetting ii_field_ba20ca4c;
    private ModeSetting II_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 iII_field_500d0627;
    private ModeSetting.Nested1_42765c60 iIi_field_500d0627;
    private ModeSetting.Nested1_42765c60 iiI_field_500d0627;
    private ColorSetting Ii_field_bbd4b66c;
    private SliderSetting ii_field_73178e8c;
    private SliderSetting III_field_73178e8c;
    private SliderSetting IIi_field_73178e8c;
    private SliderSetting IiI_field_73178e8c;
    private ModeSetting Ii_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 iii_field_500d0627;
    private ModeSetting.Nested1_42765c60 IIII_field_500d0627;
    private BooleanSetting III_field_ba20ca4c;
    private SliderSetting Iii_field_73178e8c;
    private SliderSetting iII_field_73178e8c;
    private ModeSetting iI_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 IIIi_field_500d0627;
    private ModeSetting.Nested1_42765c60 IIiI_field_500d0627;
    private ModeSetting.Nested1_42765c60 IIii_field_500d0627;
    private BooleanSetting IIi_field_ba20ca4c;
    private ColorSetting iI_field_bbd4b66c;
    private ModeSetting ii_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 IiII_field_500d0627;
    private ModeSetting.Nested1_42765c60 IiIi_field_500d0627;
    private ModeSetting.Nested1_42765c60 IiiI_field_500d0627;
    private ModeSetting.Nested1_42765c60 Iiii_field_500d0627;
    private SliderSetting iIi_field_73178e8c;
    private SliderSetting iiI_field_73178e8c;
    private BooleanSetting IiI_field_ba20ca4c;
    private SliderSetting iii_field_73178e8c;
    public BooleanSetting I_field_ba20ca4c;
    public BooleanSetting i_field_ba20ca4c;
    private ModeSetting III_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 iIII_field_500d0627;
    private ModeSetting.Nested1_42765c60 iIIi_field_500d0627;
    private ModeSetting.Nested1_42765c60 iIiI_field_500d0627;
    private SliderSetting IIII_field_73178e8c;
    private SliderSetting IIIi_field_73178e8c;
    private BooleanSetting Iii_field_ba20ca4c;
    private BooleanSetting iII_field_ba20ca4c;
    private ColorSetting ii_field_bbd4b66c;
    private SliderSetting IIiI_field_73178e8c;
    private static final float I_field_46 = 0.35f;
    private static final float i_field_46 = 0.45f;
    private static final float II_field_46 = 24.0f;
    private final IIiIII_Class9.Nested1_e9dbeb13 I_field_de2624bc = new IIiIII_Class9.Nested1_e9dbeb13();
    private final iIiiiIIIi_Class370 I_field_433fea2c = new iIiiiIIIi_Class370();
    private final iIiiiiIIi_Class378 I_field_4502da4c = new iIiiiiIIi_Class378();
    private long I_field_4a;
    private boolean I_field_5a;
    private BlockPos I_field_670402ba;
    private float Ii_field_46 = -1.0f;
    private int I_field_49 = -1;
    private boolean i_field_5a;
    private final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(450L, IiiiIiiII_Class237.iIiI_field_dd60aac);
    private final IiIIIiII_Class69<ReceivePacketEvent> I_field_3d936f41 = receivePacketEvent -> {
        if (receivePacketEvent.getPacket() instanceof WorldTimeUpdateS2CPacket && (this.IiI_field_ba20ca4c.i_method_9b12da03() || this.isPresetActive())) {
            receivePacketEvent.cancel();
        }
    };
    private final IiIIIiII_Class69<Render3DEvent> i_field_3d936f41 = render3DEvent -> {
        if (AmbienceModule.I_field_3a9bda27.world == null || AmbienceModule.I_field_3a9bda27.player == null) {
            this.I_field_5a = false;
            this.iII_method_5dae0a1f();
            return;
        }
        this.ii_method_5f62b5b2(this.IIii_method_bd2c4506());
        Camera camera = render3DEvent.getCamera();
        if (camera == null || !camera.isReady()) {
            return;
        }
        if (camera.getSubmersionType() != CameraSubmersionType.NONE) {
            return;
        }
        if (this.iI_field_ba20ca4c.i_method_9b12da03()) {
            this.I_field_433fea2c.I_method_c1ac83a0(camera, render3DEvent.getPositionMatrix(), render3DEvent.getProjectionMatrix(), this.i_field_73178e8c.Ii_method_a20abcd2() / 100.0f, this.II_field_73178e8c.Ii_method_a20abcd2() / 100.0f, this.Ii_field_73178e8c.Ii_method_a20abcd2() / 100.0f, this.iI_field_73178e8c.Ii_method_a20abcd2() / 100.0f);
        }
        if (this.ii_field_ba20ca4c.i_method_9b12da03()) {
            this.I_field_4502da4c.I_method_a0d76775(camera, render3DEvent.getPositionMatrix(), render3DEvent.getProjectionMatrix(), this.I_method_ccbe63a(camera.getPos()), this.ii_field_73178e8c.Ii_method_a20abcd2() / 100.0f, this.III_field_73178e8c.Ii_method_a20abcd2() / 100.0f, this.IIi_field_73178e8c.Ii_method_a20abcd2(), this.IiI_field_73178e8c.Ii_method_a20abcd2(), this.IIII_field_500d0627.isSelected());
        }
        this.renderAtmosphericParticles(render3DEvent, camera);
        if (this.blockSnowCover != null && this.blockSnowCover.i_method_9b12da03() && (this.presetWinter.isSelected() || this.isPresetActive())) {
            this.renderBlockSnowCover(render3DEvent, camera);
        }
    };

    private final IiIIIiII_Class69<HudRenderEvent> hudAtmosphereListener = this::onRenderHud;

    private void onRenderHud(HudRenderEvent event) {
        if (!this.isEnabled()) return;
        if (this.screenAtmosphere != null && this.screenAtmosphere.i_method_9b12da03() && this.isPresetActive()) {
            this.renderAtmosphericScreenEffects(event);
        }
    };

    private static class AtmoParticle {
        double x, y, z;
        float size;
        float phase;
        float speed;
        boolean init = false;
    }

    private final AtmoParticle[] atmoParticles = new AtmoParticle[300];
    {
        for (int i = 0; i < atmoParticles.length; i++) {
            atmoParticles[i] = new AtmoParticle();
        }
    }

    private void renderAtmosphericParticles(Render3DEvent event, Camera camera) {
        if (!this.isPresetActive() && (!this.isCompositionActive() || (this.compositionStrength != null && this.compositionStrength.Ii_method_a20abcd2() <= 0.0F))) return;

        boolean isWinter = this.presetWinter.isSelected();
        boolean isFlame = this.presetFlame.isSelected();
        boolean isDawn = this.presetDawn.isSelected();
        boolean isSunset = this.presetSunset.isSelected();

        int targetCount = this.particleCount != null ? Math.min(this.atmoParticles.length, (int)this.particleCount.Ii_method_a20abcd2()) : 160;
        float speedMul = this.particleSpeed != null ? this.particleSpeed.Ii_method_a20abcd2() : 1.0F;
        float sizeMul = this.particleSize != null ? this.particleSize.Ii_method_a20abcd2() : 1.0F;

        Vec3d camPos = camera.getPos();
        float timeSec = (float)((System.currentTimeMillis() % 10000000L) / 1000.0);

        Quaternionf camRot = camera.getRotation();
        Vector3f right = new Vector3f(1.0F, 0.0F, 0.0F).rotate(camRot);
        Vector3f up = new Vector3f(0.0F, 1.0F, 0.0F).rotate(camRot);

        RenderSystem.enableBlend();
        if (isFlame) {
            RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE);
        } else {
            RenderSystem.defaultBlendFunc();
        }
        RenderSystem.disableCull();
        RenderSystem.depthMask(false);
        RenderSystem.enableDepthTest();
        RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);

        Matrix4f posMat = event.getPositionMatrix();
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);

        for (int i = 0; i < targetCount; i++) {
            AtmoParticle p = this.atmoParticles[i];
            if (!p.init) {
                double ang = Math.random() * Math.PI * 2.0;
                double dist = 2.0 + Math.random() * 16.0;
                p.x = camPos.x + Math.cos(ang) * dist;
                p.z = camPos.z + Math.sin(ang) * dist;
                p.y = camPos.y - 3.0 + Math.random() * 14.0;
                p.phase = (float)(Math.random() * Math.PI * 2.0);
                p.size = (float)(0.045 + Math.random() * 0.045);
                p.speed = (float)(0.06 + Math.random() * 0.06);
                p.init = true;
            }

            if (isWinter) {
                p.y -= p.speed * speedMul;
                p.x += Math.sin(timeSec * 1.5F + p.phase) * 0.02F * speedMul;
                p.z += Math.cos(timeSec * 1.2F + p.phase) * 0.02F * speedMul;
                if (p.y < camPos.y - 3.5) {
                    p.y = camPos.y + 11.0 + Math.random() * 3.0;
                    double ang = Math.random() * Math.PI * 2.0;
                    double dist = 2.0 + Math.random() * 16.0;
                    p.x = camPos.x + Math.cos(ang) * dist;
                    p.z = camPos.z + Math.sin(ang) * dist;
                }
            } else if (isFlame) {
                p.y += p.speed * 1.2F * speedMul;
                p.x += Math.sin(timeSec * 2.5F + p.phase) * 0.035F * speedMul;
                p.z += Math.cos(timeSec * 2.5F + p.phase) * 0.035F * speedMul;
                if (p.y > camPos.y + 11.0) {
                    p.y = camPos.y - 3.5 - Math.random() * 2.0;
                    double ang = Math.random() * Math.PI * 2.0;
                    double dist = 2.0 + Math.random() * 16.0;
                    p.x = camPos.x + Math.cos(ang) * dist;
                    p.z = camPos.z + Math.sin(ang) * dist;
                }
            } else {
                p.y += Math.sin(timeSec * 0.8F + p.phase) * 0.012F * speedMul;
                p.x += Math.cos(timeSec * 0.7F + p.phase) * 0.018F * speedMul;
                p.z += Math.sin(timeSec * 0.6F + p.phase) * 0.018F * speedMul;
                double dx = p.x - camPos.x;
                double dz = p.z - camPos.z;
                if (dx * dx + dz * dz > 18.0 * 18.0 || Math.abs(p.y - camPos.y) > 8.0) {
                    p.init = false;
                    continue;
                }
            }

            float rx = (float)(p.x - camPos.x);
            float ry = (float)(p.y - camPos.y);
            float rz = (float)(p.z - camPos.z);

            int color;
            if (isWinter) {
                float alpha = (float)(0.75 + 0.25 * Math.sin(p.phase + timeSec * 3.0F));
                color = new ColorRGBA(225.0F, 245.0F, 255.0F, 240.0F * alpha).getRGB();
            } else if (isFlame) {
                float pulse = (float)Math.sin(p.phase + timeSec * 4.0F) * 0.5F + 0.5F;
                float r = 255.0F;
                float g = 80.0F + pulse * 140.0F;
                float b = 20.0F;
                color = new ColorRGBA(r, g, b, 230.0F).getRGB();
            } else if (isDawn) {
                color = new ColorRGBA(255.0F, 220.0F, 160.0F, 180.0F).getRGB();
            } else if (isSunset) {
                color = new ColorRGBA(255.0F, 120.0F, 180.0F, 180.0F).getRGB();
            } else {
                ColorRGBA comp = this.getCompositionColor();
                color = comp.withAlpha(200.0F).getRGB();
            }

            float hs = p.size * sizeMul;
            float rX = right.x * hs, rY = right.y * hs, rZ = right.z * hs;
            float uX = up.x * hs, uY = up.y * hs, uZ = up.z * hs;

            bb.vertex(posMat, rx - rX - uX, ry - rY - uY, rz - rZ - uZ).color(color);
            bb.vertex(posMat, rx + rX - uX, ry + rY - uY, rz + rZ - uZ).color(color);
            bb.vertex(posMat, rx + rX + uX, ry + rY + uY, rz + rZ + uZ).color(color);
            bb.vertex(posMat, rx - rX + uX, ry - rY + uY, rz - rZ + uZ).color(color);
        }

        BuiltBuffer built = bb.endNullable();
        if (built != null) BufferRenderer.drawWithGlobalProgram(built);

        RenderSystem.depthMask(true);
        RenderSystem.enableCull();
        RenderSystem.defaultBlendFunc();
    }

    private void renderBlockSnowCover(Render3DEvent event, Camera camera) {
        if (AmbienceModule.I_field_3a9bda27.world == null || AmbienceModule.I_field_3a9bda27.player == null) return;
        Vec3d camPos = camera.getPos();
        BlockPos playerPos = BlockPos.ofFloored(camPos);
        int radius = 12;
        int minY = Math.max(AmbienceModule.I_field_3a9bda27.world.getBottomY(), playerPos.getY() - 5);
        int maxY = playerPos.getY() + 5;

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.disableCull();
        RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);

        Matrix4f posMat = event.getPositionMatrix();
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
        boolean hasVertices = false;

        BlockPos.Mutable mut = new BlockPos.Mutable();
        BlockPos.Mutable upMut = new BlockPos.Mutable();

        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {
                double distSq = dx * dx + dz * dz;
                if (distSq > radius * radius) continue;
                double dist = Math.sqrt(distSq);

                for (int dy = minY; dy <= maxY; dy++) {
                    int bx = playerPos.getX() + dx;
                    int bz = playerPos.getZ() + dz;
                    mut.set(bx, dy, bz);
                    upMut.set(bx, dy + 1, bz);

                    BlockState state = AmbienceModule.I_field_3a9bda27.world.getBlockState(mut);
                    if (!state.isAir() && state.isOpaqueFullCube() && !state.isOf(Blocks.SNOW) && !state.isOf(Blocks.SNOW_BLOCK)) {
                        BlockState upState = AmbienceModule.I_field_3a9bda27.world.getBlockState(upMut);
                        if (upState.isAir()) {
                            float rx = (float)(bx - camPos.x);
                            float ry = (float)(dy + 1.003 - camPos.y);
                            float rz = (float)(bz - camPos.z);

                            float fade = (float)MathHelper.clamp((radius - dist) / (double)radius, 0.0, 1.0);
                            int alpha = (int)(150.0F * fade);
                            if (alpha <= 5) continue;
                            int col = new ColorRGBA(242.0F, 248.0F, 255.0F, (float)alpha).getRGB();

                            bb.vertex(posMat, rx, ry, rz).color(col);
                            bb.vertex(posMat, rx, ry, rz + 1.0F).color(col);
                            bb.vertex(posMat, rx + 1.0F, ry, rz + 1.0F).color(col);
                            bb.vertex(posMat, rx + 1.0F, ry, rz).color(col);
                            hasVertices = true;
                        }
                    }
                }
            }
        }

        if (hasVertices) {
            BuiltBuffer built = bb.endNullable();
            if (built != null) BufferRenderer.drawWithGlobalProgram(built);
        }

        RenderSystem.depthMask(true);
        RenderSystem.enableCull();
    }

    private void renderAtmosphericScreenEffects(HudRenderEvent event) {
        MinecraftClient mc = AmbienceModule.I_field_3a9bda27;
        if (mc.getWindow() == null) return;
        int screenW = mc.getWindow().getScaledWidth();
        int screenH = mc.getWindow().getScaledHeight();
        float timeSec = (float)((System.currentTimeMillis() % 10000000L) / 1000.0);

        boolean isWinter = this.presetWinter.isSelected();
        boolean isFlame = this.presetFlame.isSelected();
        boolean isDawn = this.presetDawn.isSelected();
        boolean isSunset = this.presetSunset.isSelected();

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableDepthTest();
        RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);

        Matrix4f posMat = event.getContext().getMatrices().peek().getPositionMatrix();
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);

        float borderPct = this.screenBorderSize != null ? (this.screenBorderSize.Ii_method_a20abcd2() / 100.0F) : 0.16F;
        int borderSize = (int)(Math.min(screenW, screenH) * borderPct);
        float userIntensity = this.screenIntensity != null ? (this.screenIntensity.Ii_method_a20abcd2() / 100.0F) : 0.75F;
        float pulse = (0.75F + 0.25F * (float)Math.sin(timeSec * 1.5F)) * userIntensity;

        ColorRGBA edgeCol;
        if (isWinter) {
            edgeCol = new ColorRGBA(190.0F, 230.0F, 255.0F, 120.0F * pulse);
        } else if (isFlame) {
            edgeCol = new ColorRGBA(255.0F, 70.0F, 20.0F, 110.0F * pulse);
        } else if (isDawn) {
            edgeCol = new ColorRGBA(255.0F, 210.0F, 140.0F, 85.0F * pulse);
        } else if (isSunset) {
            edgeCol = new ColorRGBA(245.0F, 90.0F, 130.0F, 95.0F * pulse);
        } else {
            edgeCol = this.getCompositionColor().withAlpha(90.0F * pulse);
        }
        int cEdge = edgeCol.getRGB();
        int cTrans = edgeCol.withAlpha(0.0F).getRGB();

        bb.vertex(posMat, 0, 0, 0).color(cEdge);
        bb.vertex(posMat, 0, borderSize, 0).color(cTrans);
        bb.vertex(posMat, screenW, borderSize, 0).color(cTrans);
        bb.vertex(posMat, screenW, 0, 0).color(cEdge);

        bb.vertex(posMat, 0, screenH - borderSize, 0).color(cTrans);
        bb.vertex(posMat, 0, screenH, 0).color(cEdge);
        bb.vertex(posMat, screenW, screenH, 0).color(cEdge);
        bb.vertex(posMat, screenW, screenH - borderSize, 0).color(cTrans);

        bb.vertex(posMat, 0, 0, 0).color(cEdge);
        bb.vertex(posMat, 0, screenH, 0).color(cEdge);
        bb.vertex(posMat, borderSize, screenH, 0).color(cTrans);
        bb.vertex(posMat, borderSize, 0, 0).color(cTrans);

        bb.vertex(posMat, screenW - borderSize, 0, 0).color(cTrans);
        bb.vertex(posMat, screenW - borderSize, screenH, 0).color(cTrans);
        bb.vertex(posMat, screenW, screenH, 0).color(cEdge);
        bb.vertex(posMat, screenW, 0, 0).color(cEdge);

        BuiltBuffer built = bb.endNullable();
        if (built != null) BufferRenderer.drawWithGlobalProgram(built);

        RenderSystem.enableDepthTest();
    }

    public boolean isCompositionActive() {
        return this.isEnabled() && (this.isPresetActive() || this.Iii_method_28e47243() || (this.compositionStrength != null && this.compositionStrength.Ii_method_a20abcd2() > 0.0F));
    }

    public ColorRGBA getCompositionColor() {
        if (this.isPresetActive()) {
            if (this.presetWinter.isSelected()) return new ColorRGBA(170.0F, 210.0F, 255.0F, 255.0F);
            if (this.presetFlame.isSelected()) return new ColorRGBA(255.0F, 110.0F, 40.0F, 255.0F);
            if (this.presetDawn.isSelected()) return new ColorRGBA(255.0F, 210.0F, 150.0F, 255.0F);
            if (this.presetSunset.isSelected()) return new ColorRGBA(225.0F, 95.0F, 175.0F, 255.0F);
        }
        if (this.Iii_method_28e47243()) {
            return this.iII_field_ba20ca4c.i_method_9b12da03() ? IiiiiIIIi_Class242.i_method_5dfec6e() : this.ii_field_bbd4b66c.I_method_bde5f08e();
        }
        return this.compositionColor != null ? this.compositionColor.I_method_bde5f08e() : new ColorRGBA(180.0F, 200.0F, 255.0F, 255.0F);
    }

    public Vector3f getCompositionVector3f() {
        ColorRGBA col = this.getCompositionColor();
        return new Vector3f(col.getRed() / 255.0F, col.getGreen() / 255.0F, col.getBlue() / 255.0F);
    }

    public float getCompositionStrength() {
        if (this.isPresetActive()) {
            return this.compositionStrength != null ? (this.compositionStrength.Ii_method_a20abcd2() / 100.0F) : 0.65F;
        }
        if (this.Iii_method_28e47243()) {
            return this.I_method_d49e05cf();
        }
        return this.compositionStrength != null ? (this.compositionStrength.Ii_method_a20abcd2() / 100.0F) : 0.0F;
    }

    public AmbienceModule() {
        this.IiI_method_28d5e65f();
    }

    @Compile(obfuscation=4)
    private void IiI_method_28d5e65f() {
        this.atmospherePreset = new ModeSetting(this, "Пресет атмосферы");
        this.presetCustom = new ModeSetting.Nested1_42765c60(this.atmospherePreset, "Кастом").select();
        this.presetWinter = new ModeSetting.Nested1_42765c60(this.atmospherePreset, "Зима");
        this.presetFlame = new ModeSetting.Nested1_42765c60(this.atmospherePreset, "Пламя");
        this.presetDawn = new ModeSetting.Nested1_42765c60(this.atmospherePreset, "Рассвет");
        this.presetSunset = new ModeSetting.Nested1_42765c60(this.atmospherePreset, "Закат");

        this.compositionColor = new ColorSetting(this, "Цвет композиции", () -> !this.presetCustom.isSelected()).I_method_a62f5dd6(new ColorRGBA(160.0F, 195.0F, 255.0F, 255.0F));
        this.compositionStrength = new SliderSetting(this, "Интенсивность композиции").I_method_c8c9a7d7(0.0F).i_method_65e2aff7(100.0F).II_method_b0f56334(1.0F).Ii_method_4e0e6b54(65.0F).I_method_d41e7abf("%");

        this.blockSnowCover = new BooleanSetting(this, "Снег на блоках").I_method_decd82b5();
        this.screenAtmosphere = new BooleanSetting(this, "Эффекты на экран").I_method_decd82b5();
        this.screenIntensity = new SliderSetting(this, "Яркость эффектов экрана", () -> !this.screenAtmosphere.i_method_9b12da03()).I_method_c8c9a7d7(10.0F).i_method_65e2aff7(100.0F).II_method_b0f56334(5.0F).Ii_method_4e0e6b54(75.0F).I_method_d41e7abf("%");
        this.screenBorderSize = new SliderSetting(this, "Рамка экрана", () -> !this.screenAtmosphere.i_method_9b12da03()).I_method_c8c9a7d7(5.0F).i_method_65e2aff7(35.0F).II_method_b0f56334(1.0F).Ii_method_4e0e6b54(16.0F).I_method_d41e7abf("%");

        this.particleCount = new SliderSetting(this, "Количество партиклов").I_method_c8c9a7d7(30.0F).i_method_65e2aff7(300.0F).II_method_b0f56334(10.0F).Ii_method_4e0e6b54(160.0F);
        this.particleSpeed = new SliderSetting(this, "Скорость партиклов").I_method_c8c9a7d7(0.2F).i_method_65e2aff7(3.0F).II_method_b0f56334(0.1F).Ii_method_4e0e6b54(1.0F);
        this.particleSize = new SliderSetting(this, "Размер партиклов").I_method_c8c9a7d7(0.5F).i_method_65e2aff7(2.5F).II_method_b0f56334(0.1F).Ii_method_4e0e6b54(1.0F);

        this.IiI_field_ba20ca4c = new BooleanSetting(this, "modules.settings.ambience.custom_time").I_method_decd82b5();
        this.iii_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.ambience.time", () -> !this.IiI_field_ba20ca4c.i_method_9b12da03()).II_method_b0f56334(500.0f).I_method_c8c9a7d7(0.0f).i_method_65e2aff7(24000.0f).Ii_method_4e0e6b54(17000.0f);
        this.i_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "modules.settings.ambience.bright", () -> this.I_field_ba20ca4c.i_method_9b12da03()).I_method_decd82b5();
        this.III_field_bbe33e6c = new ModeSetting((IIiiiIIiI_Class115)this, "modules.settings.ambience.mode", () -> !this.IiI_method_28d5e663());
        this.iIII_field_500d0627 = new ModeSetting.Nested1_42765c60(this.III_field_bbe33e6c, "modules.settings.ambience.mode.gamma");
        this.iIIi_field_500d0627 = new ModeSetting.Nested1_42765c60(this.III_field_bbe33e6c, "modules.settings.ambience.mode.effect");
        this.iIiI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.III_field_bbe33e6c, "modules.settings.ambience.mode.dynamic").select();
        this.IIII_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.ambience.dynamic.radius", () -> !this.IiI_method_28d5e663() || !this.iIiI_field_500d0627.isSelected()).I_method_c8c9a7d7(4.0f).i_method_65e2aff7(12.0f).II_method_b0f56334(0.5f).Ii_method_4e0e6b54(12.0f);
        this.IIIi_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.ambience.dynamic.light", () -> !this.IiI_method_28d5e663() || !this.iIiI_field_500d0627.isSelected()).I_method_c8c9a7d7(8.0f).i_method_65e2aff7(15.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(15.0f);
        this.Iii_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "modules.settings.ambience.dynamic.only_in_cave", () -> !this.IiI_method_28d5e663() || !this.iIiI_field_500d0627.isSelected()).I_method_decd82b5();
        new SectionSetting(this, "modules.settings.ambience.section.color").i_method_2d36cf15().I_method_9505555a(2);
        this.I_field_bbe3ba6c = new MultiSelectSetting(this, "modules.settings.ambience.change_color");
        this.I_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.ambience.change_color.sky").select();
        this.i_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.ambience.change_color.clouds").select();
        this.II_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.ambience.change_color.stars").select();
        this.II_field_ba20ca4c = new BooleanSetting(this, "theme.sync").I_method_decd82b5();
        this.I_field_bbd4b66c = new ColorSetting(this, "modules.settings.ambience.sky_color", () -> this.II_field_ba20ca4c.i_method_9b12da03() || !this.I_field_51de8227.isSelected()).I_method_a62f5dd6(IiiiiIIIi_Class242.i_method_5dfec6e()).I_method_af5a85eb(false);
        this.i_field_bbd4b66c = new ColorSetting(this, "modules.settings.ambience.cloud_color", () -> this.II_field_ba20ca4c.i_method_9b12da03() || !this.i_field_51de8227.isSelected()).I_method_a62f5dd6(IiiiiIIIi_Class242.i_method_5dfec6e()).I_method_af5a85eb(false);
        this.II_field_bbd4b66c = new ColorSetting(this, "modules.settings.ambience.stars_color", () -> this.II_field_ba20ca4c.i_method_9b12da03() || !this.II_field_51de8227.isSelected()).I_method_a62f5dd6(IiiiiIIIi_Class242.i_method_5dfec6e());
        this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.ambience.night_mode");
        this.iII_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "modules.settings.ambience.night_mode.sync", () -> !this.I_field_ba20ca4c.i_method_9b12da03()).I_method_decd82b5();
        this.ii_field_bbd4b66c = new ColorSetting(this, "modules.settings.ambience.night_mode.color", () -> !this.I_field_ba20ca4c.i_method_9b12da03() || this.iII_field_ba20ca4c.i_method_9b12da03()).I_method_a62f5dd6(new ColorRGBA(80.0f, 120.0f, 220.0f, 255.0f)).I_method_af5a85eb(false);
        this.IIiI_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.ambience.night_mode.strength", () -> !this.I_field_ba20ca4c.i_method_9b12da03()).I_method_c8c9a7d7(0.0f).i_method_65e2aff7(100.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(70.0f);
        this.IIi_field_ba20ca4c = new BooleanSetting(this, "modules.settings.ambience.color_isolation");
        this.iI_field_bbd4b66c = new ColorSetting(this, "modules.settings.ambience.color_isolation.color", () -> !this.IIi_field_ba20ca4c.i_method_9b12da03()).I_method_a62f5dd6(new ColorRGBA(0.0f, 122.0f, 255.0f, 255.0f)).I_method_af5a85eb(false);
        this.ii_field_bbe33e6c = new ModeSetting((IIiiiIIiI_Class115)this, "modules.settings.ambience.color_isolation.mode", () -> !this.IIi_field_ba20ca4c.i_method_9b12da03());
        this.IiII_field_500d0627 = new ModeSetting.Nested1_42765c60(this.ii_field_bbe33e6c, "modules.settings.ambience.color_isolation.mode.strict");
        this.IiIi_field_500d0627 = new ModeSetting.Nested1_42765c60(this.ii_field_bbe33e6c, "modules.settings.ambience.color_isolation.mode.balanced").select();
        this.IiiI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.ii_field_bbe33e6c, "modules.settings.ambience.color_isolation.mode.loose");
        this.Iiii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.ii_field_bbe33e6c, "modules.settings.ambience.color_isolation.mode.custom");
        this.iIi_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.ambience.color_isolation.sensitivity", () -> !this.IIi_field_ba20ca4c.i_method_9b12da03() || !this.Iiii_field_500d0627.isSelected()).I_method_c8c9a7d7(0.0f).i_method_65e2aff7(100.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(50.0f);
        this.iiI_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.ambience.color_isolation.background", () -> !this.IIi_field_ba20ca4c.i_method_9b12da03()).I_method_c8c9a7d7(0.0f).i_method_65e2aff7(100.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(0.0f);
        this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.ambience.skybox");
        this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.ambience.skybox.default");
        this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.ambience.skybox.bright_clouds").select();
        this.II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.ambience.skybox.lake");
        this.Ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.ambience.skybox.cloud_space");
        this.iI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.ambience.skybox.clear_evening");
        this.ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.ambience.skybox.underwater");
        this.Ii_field_ba20ca4c = new BooleanSetting(this, "modules.settings.ambience.shader");
        this.i_field_bbe33e6c = new ModeSetting((IIiiiIIiI_Class115)this, "modules.settings.ambience.shader_type", () -> !this.Ii_field_ba20ca4c.i_method_9b12da03());
        this.III_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.ambience.shader_type.nebula").select();
        this.IIi_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.ambience.shader_type.caustic");
        this.IiI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.ambience.shader_type.galaxy");
        this.Iii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.ambience.shader_type.space");
        this.I_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.ambience.shader_opacity", () -> !this.Ii_field_ba20ca4c.i_method_9b12da03()).I_method_c8c9a7d7(0.0f).i_method_65e2aff7(100.0f).II_method_b0f56334(5.0f).Ii_method_4e0e6b54(70.0f);
        new SectionSetting(this, "modules.settings.ambience.section.fog").i_method_2d36cf15().I_method_9505555a(2);
        this.ii_field_ba20ca4c = new BooleanSetting(this, "modules.settings.ambience.fog");
        this.II_field_bbe33e6c = new ModeSetting((IIiiiIIiI_Class115)this, "modules.settings.ambience.fog.color_mode", () -> !this.ii_field_ba20ca4c.i_method_9b12da03());
        this.iII_field_500d0627 = new ModeSetting.Nested1_42765c60(this.II_field_bbe33e6c, "modules.settings.ambience.fog.color_mode.biome").select();
        this.iIi_field_500d0627 = new ModeSetting.Nested1_42765c60(this.II_field_bbe33e6c, "modules.settings.ambience.fog.color_mode.theme");
        this.iiI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.II_field_bbe33e6c, "modules.settings.ambience.fog.color_mode.custom");
        this.Ii_field_bbd4b66c = new ColorSetting(this, "modules.settings.ambience.fog.color", () -> !this.ii_field_ba20ca4c.i_method_9b12da03() || !this.iiI_field_500d0627.isSelected()).I_method_a62f5dd6(new ColorRGBA(205.0f, 210.0f, 220.0f, 255.0f)).I_method_af5a85eb(false);
        this.ii_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.ambience.fog.density", () -> !this.ii_field_ba20ca4c.i_method_9b12da03()).I_method_c8c9a7d7(10.0f).i_method_65e2aff7(250.0f).II_method_b0f56334(5.0f).Ii_method_4e0e6b54(90.0f).I_method_d41e7abf("%");
        this.III_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.ambience.fog.coverage", () -> !this.ii_field_ba20ca4c.i_method_9b12da03()).I_method_c8c9a7d7(0.0f).i_method_65e2aff7(100.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(55.0f).I_method_d41e7abf("%");
        this.IIi_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.ambience.fog.level", () -> !this.ii_field_ba20ca4c.i_method_9b12da03()).I_method_c8c9a7d7(-64.0f).i_method_65e2aff7(320.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(66.0f);
        this.IiI_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.ambience.fog.thickness", () -> !this.ii_field_ba20ca4c.i_method_9b12da03()).I_method_c8c9a7d7(2.0f).i_method_65e2aff7(48.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(6.0f);
        this.Ii_field_bbe33e6c = new ModeSetting((IIiiiIIiI_Class115)this, "modules.settings.ambience.fog.quality", () -> !this.ii_field_ba20ca4c.i_method_9b12da03());
        this.iii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.Ii_field_bbe33e6c, "modules.settings.ambience.fog.quality.low");
        this.IIII_field_500d0627 = new ModeSetting.Nested1_42765c60(this.Ii_field_bbe33e6c, "modules.settings.ambience.fog.quality.high").select();
        new SectionSetting(this, "modules.settings.ambience.section.wet_world").i_method_2d36cf15().I_method_9505555a(2);
        this.III_field_ba20ca4c = new BooleanSetting(this, "modules.settings.ambience.wet_world");
        this.Iii_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.ambience.wet_world.reflection", () -> !this.III_field_ba20ca4c.i_method_9b12da03()).I_method_c8c9a7d7(0.0f).i_method_65e2aff7(100.0f).II_method_b0f56334(5.0f).Ii_method_4e0e6b54(70.0f).I_method_d41e7abf("%");
        this.iII_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.ambience.wet_world.amount", () -> !this.III_field_ba20ca4c.i_method_9b12da03()).I_method_c8c9a7d7(0.0f).i_method_65e2aff7(100.0f).II_method_b0f56334(5.0f).Ii_method_4e0e6b54(60.0f).I_method_d41e7abf("%");
        this.iI_field_bbe33e6c = new ModeSetting((IIiiiIIiI_Class115)this, "modules.settings.ambience.wet_world.quality", () -> !this.III_field_ba20ca4c.i_method_9b12da03());
        this.IIIi_field_500d0627 = new ModeSetting.Nested1_42765c60(this.iI_field_bbe33e6c, "modules.settings.ambience.wet_world.quality.low");
        this.IIiI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.iI_field_bbe33e6c, "modules.settings.ambience.wet_world.quality.medium").select();
        this.IIii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.iI_field_bbe33e6c, "modules.settings.ambience.wet_world.quality.high");
        new SectionSetting(this, "modules.settings.ambience.section.rain").i_method_2d36cf15().I_method_9505555a(2);
        this.iI_field_ba20ca4c = new BooleanSetting(this, "modules.settings.ambience.rain");
        this.i_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.ambience.rain.density", () -> !this.iI_field_ba20ca4c.i_method_9b12da03()).I_method_c8c9a7d7(10.0f).i_method_65e2aff7(200.0f).II_method_b0f56334(5.0f).Ii_method_4e0e6b54(100.0f).I_method_d41e7abf("%");
        this.II_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.ambience.rain.opacity", () -> !this.iI_field_ba20ca4c.i_method_9b12da03()).I_method_c8c9a7d7(5.0f).i_method_65e2aff7(100.0f).II_method_b0f56334(5.0f).Ii_method_4e0e6b54(45.0f).I_method_d41e7abf("%");
        this.Ii_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.ambience.rain.drops", () -> !this.iI_field_ba20ca4c.i_method_9b12da03()).I_method_c8c9a7d7(0.0f).i_method_65e2aff7(100.0f).II_method_b0f56334(5.0f).Ii_method_4e0e6b54(60.0f).I_method_d41e7abf("%");
        this.iI_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.ambience.rain.splashes", () -> !this.iI_field_ba20ca4c.i_method_9b12da03()).I_method_c8c9a7d7(0.0f).i_method_65e2aff7(100.0f).II_method_b0f56334(5.0f).Ii_method_4e0e6b54(60.0f).I_method_d41e7abf("%");
    }

    public boolean IiI_method_28d5e663() {
        return this.i_field_ba20ca4c.i_method_9b12da03() && !this.I_field_ba20ca4c.i_method_9b12da03();
    }

    public boolean isPresetActive() {
        return this.isEnabled() && this.atmospherePreset != null && !this.presetCustom.isSelected();
    }

    public ColorRGBA getPresetSkyColor() {
        if (this.isPresetActive()) {
            if (this.presetWinter.isSelected()) return new ColorRGBA(180.0f, 215.0f, 255.0f, 255.0f);
            if (this.presetFlame.isSelected()) return new ColorRGBA(255.0f, 65.0f, 25.0f, 255.0f);
            if (this.presetDawn.isSelected()) return new ColorRGBA(255.0f, 215.0f, 140.0f, 255.0f);
            if (this.presetSunset.isSelected()) return new ColorRGBA(245.0f, 90.0f, 140.0f, 255.0f);
        }
        return this.II_field_ba20ca4c.i_method_9b12da03() ? IiiiiIIIi_Class242.i_method_5dfec6e() : this.I_field_bbd4b66c.I_method_bde5f08e();
    }

    public ColorRGBA getPresetCloudColor() {
        if (this.isPresetActive()) {
            if (this.presetWinter.isSelected()) return new ColorRGBA(225.0f, 240.0f, 255.0f, 255.0f);
            if (this.presetFlame.isSelected()) return new ColorRGBA(255.0f, 130.0f, 30.0f, 255.0f);
            if (this.presetDawn.isSelected()) return new ColorRGBA(255.0f, 180.0f, 150.0f, 255.0f);
            if (this.presetSunset.isSelected()) return new ColorRGBA(255.0f, 120.0f, 70.0f, 255.0f);
        }
        return this.II_field_ba20ca4c.i_method_9b12da03() ? IiiiiIIIi_Class242.i_method_5dfec6e() : this.i_field_bbd4b66c.I_method_bde5f08e();
    }

    public ColorRGBA getPresetFogColor() {
        if (this.isPresetActive()) {
            if (this.presetWinter.isSelected()) return new ColorRGBA(195.0f, 225.0f, 255.0f, 255.0f);
            if (this.presetFlame.isSelected()) return new ColorRGBA(255.0f, 75.0f, 30.0f, 255.0f);
            if (this.presetDawn.isSelected()) return new ColorRGBA(255.0f, 220.0f, 160.0f, 255.0f);
            if (this.presetSunset.isSelected()) return new ColorRGBA(180.0f, 70.0f, 160.0f, 255.0f);
        }
        return this.Ii_field_bbd4b66c.I_method_bde5f08e();
    }

    public boolean isFogEnabled() {
        return this.isEnabled() && (this.ii_field_ba20ca4c.i_method_9b12da03() || this.isPresetActive());
    }

    public boolean Iii_method_28e47243() {
        return this.isEnabled() && this.I_field_ba20ca4c.i_method_9b12da03();
    }

    public Vector3f I_method_f1088e3a() {
        ColorRGBA colorRGBA = this.iII_field_ba20ca4c.i_method_9b12da03() ? IiiiiIIIi_Class242.i_method_5dfec6e() : this.ii_field_bbd4b66c.I_method_bde5f08e();
        return new Vector3f(colorRGBA.getRed() / 255.0f, colorRGBA.getGreen() / 255.0f, colorRGBA.getBlue() / 255.0f);
    }

    public float I_method_d49e05cf() {
        return this.IIiI_field_73178e8c.Ii_method_a20abcd2() / 100.0f;
    }

    private ColorRGBA I_method_ccbe63a(Vec3d vec3d) {
        if (this.iIi_field_500d0627.isSelected()) {
            return IiiiiIIIi_Class242.i_method_5dfec6e();
        }
        if (this.iiI_field_500d0627.isSelected()) {
            return this.Ii_field_bbd4b66c.I_method_bde5f08e();
        }
        int n = ((Biome)AmbienceModule.I_field_3a9bda27.world.getBiome(BlockPos.ofFloored((Position)vec3d)).value()).getFogColor();
        return new ColorRGBA(this.I_method_bf2328f7(n >> 16 & 0xFF), this.I_method_bf2328f7(n >> 8 & 0xFF), this.I_method_bf2328f7(n & 0xFF), 255.0f);
    }

    private int I_method_bf2328f7(int n) {
        return MathHelper.clamp((int)Math.round((float)n + (float)(255 - n) * 0.55f), (int)0, (int)255);
    }

    @Override
    public void II_method_6642fd22() {
        if (AmbienceModule.I_field_3a9bda27.world == null) {
            this.I_field_5a = false;
            this.iII_method_5dae0a1f();
            this.iii_method_5f7f861f();
            return;
        }
        if (this.atmospherePreset != null) {
            if (this.presetWinter.isSelected()) {
                this.I_field_bbd4b66c.I_method_a62f5dd6(new ColorRGBA(195.0f, 225.0f, 255.0f, 255.0f));
                this.i_field_bbd4b66c.I_method_a62f5dd6(new ColorRGBA(230.0f, 240.0f, 255.0f, 255.0f));
                this.II_field_bbd4b66c.I_method_a62f5dd6(new ColorRGBA(220.0f, 240.0f, 255.0f, 255.0f));
                this.Ii_field_bbd4b66c.I_method_a62f5dd6(new ColorRGBA(200.0f, 230.0f, 255.0f, 255.0f));
                AmbienceModule.I_field_3a9bda27.world.getLevelProperties().setTimeOfDay(14000L);
            } else if (this.presetFlame.isSelected()) {
                this.I_field_bbd4b66c.I_method_a62f5dd6(new ColorRGBA(255.0f, 65.0f, 25.0f, 255.0f));
                this.i_field_bbd4b66c.I_method_a62f5dd6(new ColorRGBA(255.0f, 130.0f, 30.0f, 255.0f));
                this.II_field_bbd4b66c.I_method_a62f5dd6(new ColorRGBA(255.0f, 160.0f, 40.0f, 255.0f));
                this.Ii_field_bbd4b66c.I_method_a62f5dd6(new ColorRGBA(255.0f, 75.0f, 30.0f, 255.0f));
                AmbienceModule.I_field_3a9bda27.world.getLevelProperties().setTimeOfDay(18000L);
            } else if (this.presetDawn.isSelected()) {
                this.I_field_bbd4b66c.I_method_a62f5dd6(new ColorRGBA(255.0f, 215.0f, 140.0f, 255.0f));
                this.i_field_bbd4b66c.I_method_a62f5dd6(new ColorRGBA(255.0f, 180.0f, 150.0f, 255.0f));
                this.II_field_bbd4b66c.I_method_a62f5dd6(new ColorRGBA(255.0f, 230.0f, 180.0f, 255.0f));
                this.Ii_field_bbd4b66c.I_method_a62f5dd6(new ColorRGBA(255.0f, 220.0f, 160.0f, 255.0f));
                AmbienceModule.I_field_3a9bda27.world.getLevelProperties().setTimeOfDay(23200L);
            } else if (this.presetSunset.isSelected()) {
                this.I_field_bbd4b66c.I_method_a62f5dd6(new ColorRGBA(245.0f, 90.0f, 140.0f, 255.0f));
                this.i_field_bbd4b66c.I_method_a62f5dd6(new ColorRGBA(255.0f, 120.0f, 70.0f, 255.0f));
                this.II_field_bbd4b66c.I_method_a62f5dd6(new ColorRGBA(255.0f, 150.0f, 100.0f, 255.0f));
                this.Ii_field_bbd4b66c.I_method_a62f5dd6(new ColorRGBA(180.0f, 70.0f, 160.0f, 255.0f));
                AmbienceModule.I_field_3a9bda27.world.getLevelProperties().setTimeOfDay(12800L);
            }
        }
        if (this.IiI_field_ba20ca4c.i_method_9b12da03() && this.presetCustom.isSelected()) {
            AmbienceModule.I_field_3a9bda27.world.getLevelProperties().setTimeOfDay((long)this.iii_field_73178e8c.Ii_method_a20abcd2());
        }
        if (this.iIIi_field_500d0627.isSelected() && this.IiI_method_28d5e663()) {
            this.iiI_method_5f70fa3f();
        } else {
            this.iii_method_5f7f861f();
        }
        super.II_method_6642fd22();
    }

    @Override
    public void onEnable() {
        if (!IiiiiiiII_Class253.i_method_1cc4aa23() || AmbienceModule.I_field_3a9bda27.world == null) {
            return;
        }
        this.I_field_4a = AmbienceModule.I_field_3a9bda27.world.getTime();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        this.I_field_433fea2c.I_method_39f619df();
        this.iii_method_5f7f861f();
        this.iII_method_5dae0a1f();
        this.I_field_5a = false;
        if (!IiiiiiiII_Class253.i_method_1cc4aa23() || AmbienceModule.I_field_3a9bda27.world == null) {
            return;
        }
        AmbienceModule.I_field_3a9bda27.world.getLevelProperties().setTimeOfDay(this.I_field_4a);
        super.onDisable();
    }

    private boolean IIii_method_bd2c4506() {
        return this.isEnabled() && this.IiI_method_28d5e663() && this.iIiI_field_500d0627.isSelected() && (!this.Iii_field_ba20ca4c.i_method_9b12da03() || this.IiII_method_f1f5dce6());
    }

    private void ii_method_5f62b5b2(boolean bl) {
        float f = this.I_field_dc7facc.I_method_edd6dd11(bl ? 1.0f : 0.0f);
        int n = MathHelper.clamp((int)Math.round(this.IIIi_field_73178e8c.Ii_method_a20abcd2() * f), (int)0, (int)15);
        if (n <= 0) {
            this.Iii_method_28e4723f();
            return;
        }
        BlockPos blockPos = BlockPos.ofFloored((Position)AmbienceModule.I_field_3a9bda27.gameRenderer.getCamera().getPos());
        float f2 = this.IIII_field_73178e8c.Ii_method_a20abcd2();
        if (this.i_field_5a && blockPos.equals((Object)this.I_field_670402ba) && Float.compare(f2, this.Ii_field_46) == 0 && n == this.I_field_49) {
            return;
        }
        BlockPos blockPos2 = this.I_field_670402ba;
        int n2 = MathHelper.ceil((float)this.Ii_field_46);
        iIiiIiIII_Class361.I_method_813de9e8((BlockRenderView)AmbienceModule.I_field_3a9bda27.world, blockPos, f2, n);
        this.I_method_e1f96dff(blockPos2, n2, blockPos, MathHelper.ceil((float)f2));
        this.I_field_670402ba = blockPos;
        this.Ii_field_46 = f2;
        this.I_field_49 = n;
        this.i_field_5a = true;
    }

    private boolean IiII_method_f1f5dce6() {
        if (AmbienceModule.I_field_3a9bda27.player == null || AmbienceModule.I_field_3a9bda27.world == null) {
            this.I_field_5a = false;
            return false;
        }
        BlockPos blockPos = BlockPos.ofFloored((Position)AmbienceModule.I_field_3a9bda27.player.getEyePos());
        int n = AmbienceModule.I_field_3a9bda27.world.getLightLevel(LightType.SKY, blockPos);
        if (AmbienceModule.I_field_3a9bda27.world.isSkyVisible(blockPos) || n >= 8) {
            this.I_field_5a = false;
        } else if (n <= 4) {
            this.I_field_5a = true;
        }
        return this.I_field_5a;
    }

    private void Iii_method_28e4723f() {
        if (!this.i_field_5a) {
            return;
        }
        iIiiIiIII_Class361.I_method_2bac23f();
        this.I_method_e1f96dff(this.I_field_670402ba, MathHelper.ceil((float)this.Ii_field_46), null, 0);
        this.iIi_method_5dbc95ff();
    }

    private void iII_method_5dae0a1f() {
        this.I_field_dc7facc.I_method_6ac4da7f();
        if (!this.i_field_5a) {
            iIiiIiIII_Class361.I_method_2bac23f();
            return;
        }
        iIiiIiIII_Class361.I_method_2bac23f();
        this.I_method_e1f96dff(this.I_field_670402ba, MathHelper.ceil((float)this.Ii_field_46), null, 0);
        this.iIi_method_5dbc95ff();
    }

    private void iIi_method_5dbc95ff() {
        this.I_field_670402ba = null;
        this.Ii_field_46 = -1.0f;
        this.I_field_49 = -1;
        this.i_field_5a = false;
    }

    private void I_method_e1f96dff(BlockPos blockPos, int n, BlockPos blockPos2, int n2) {
        if (AmbienceModule.I_field_3a9bda27.worldRenderer == null) {
            return;
        }
        HashSet<BlockPos> hashSet = new HashSet<BlockPos>();
        this.I_method_7bdb73c9(hashSet, blockPos, n);
        this.I_method_7bdb73c9(hashSet, blockPos2, n2);
        for (BlockPos blockPos3 : hashSet) {
            AmbienceModule.I_field_3a9bda27.worldRenderer.scheduleChunkRender(blockPos3.getX(), blockPos3.getY(), blockPos3.getZ());
        }
    }

    private void I_method_7bdb73c9(Set<BlockPos> set, BlockPos blockPos, int n) {
        if (blockPos == null || n <= 0) {
            return;
        }
        int n2 = n + 1;
        int n3 = ChunkSectionPos.getSectionCoord((int)(blockPos.getX() - n2));
        int n4 = ChunkSectionPos.getSectionCoord((int)(blockPos.getY() - n2));
        int n5 = ChunkSectionPos.getSectionCoord((int)(blockPos.getZ() - n2));
        int n6 = ChunkSectionPos.getSectionCoord((int)(blockPos.getX() + n2));
        int n7 = ChunkSectionPos.getSectionCoord((int)(blockPos.getY() + n2));
        int n8 = ChunkSectionPos.getSectionCoord((int)(blockPos.getZ() + n2));
        for (int i = n3; i <= n6; ++i) {
            for (int j = n4; j <= n7; ++j) {
                for (int k = n5; k <= n8; ++k) {
                    int n9;
                    int n10;
                    int n11 = MathHelper.clamp((int)blockPos.getX(), (int)(i << 4), (int)((i << 4) + 15));
                    if (!(blockPos.getSquaredDistance((double)n11, (double)(n10 = MathHelper.clamp((int)blockPos.getY(), (int)(j << 4), (int)((j << 4) + 15))), (double)(n9 = MathHelper.clamp((int)blockPos.getZ(), (int)(k << 4), (int)((k << 4) + 15)))) <= (double)(n2 * n2))) continue;
                    set.add(new BlockPos(i, j, k));
                }
            }
        }
    }

    private void iiI_method_5f70fa3f() {
        if (AmbienceModule.I_field_3a9bda27.player == null) {
            return;
        }
        StatusEffectInstance statusEffectInstance = AmbienceModule.I_field_3a9bda27.player.getStatusEffect(StatusEffects.NIGHT_VISION);
        if (statusEffectInstance == null) {
            AmbienceModule.I_field_3a9bda27.player.addStatusEffect(this.I_method_ea86c868());
            return;
        }
        if (this.I_method_63dad3f4(statusEffectInstance) && statusEffectInstance.getDuration() <= 220) {
            AmbienceModule.I_field_3a9bda27.player.addStatusEffect(this.I_method_ea86c868());
        }
    }

    private void iii_method_5f7f861f() {
        if (AmbienceModule.I_field_3a9bda27.player == null) {
            return;
        }
        StatusEffectInstance statusEffectInstance = AmbienceModule.I_field_3a9bda27.player.getStatusEffect(StatusEffects.NIGHT_VISION);
        if (this.I_method_63dad3f4(statusEffectInstance)) {
            AmbienceModule.I_field_3a9bda27.player.removeStatusEffect(StatusEffects.NIGHT_VISION);
        }
    }

    private StatusEffectInstance I_method_ea86c868() {
        return IiiiiiiII_Class253.I_method_a2497e13((RegistryEntry<StatusEffect>)StatusEffects.NIGHT_VISION, 400, 0);
    }

    private boolean I_method_63dad3f4(StatusEffectInstance statusEffectInstance) {
        return statusEffectInstance != null && statusEffectInstance.getEffectType() == StatusEffects.NIGHT_VISION && statusEffectInstance.getAmplifier() == 0 && IiiiiiiII_Class253.I_method_d4e81454(statusEffectInstance);
    }

    public boolean iII_method_5dae0a23() {
        return !this.I_field_bbe33e6c.I_method_ce989e26(this.I_field_500d0627) && iiiIiii_Class120.I_method_6de4546d(this.II_method_87d0777e());
    }

    public boolean iIi_method_5dbc9603() {
        return this.Ii_field_ba20ca4c.i_method_9b12da03();
    }

    public boolean iiI_method_5f70fa43() {
        return this.isEnabled() && (this.iII_method_5dae0a23() || this.iIi_method_5dbc9603());
    }

    public IIIIiI_Class3 I_method_41ec5698() {
        if (this.i_field_bbe33e6c.I_method_ce989e26(this.IIi_field_500d0627)) {
            return iIiiIIiii_Class360.Ii_field_83aa8641;
        }
        return iIiiIIiii_Class360.I_field_83aa8641;
    }

    public iIIii_Class20 I_method_7acc75f5() {
        if (this.i_field_bbe33e6c.I_method_ce989e26(this.IiI_field_500d0627)) {
            return iIiiIIiii_Class360.I_field_64252d2c;
        }
        if (this.i_field_bbe33e6c.I_method_ce989e26(this.Iii_field_500d0627)) {
            return iIiiIIiii_Class360.i_field_64252d2c;
        }
        return null;
    }

    public boolean iii_method_5f7f8623() {
        return this.isEnabled() && this.IIIi_method_bb6954e6();
    }

    public boolean IIII_method_bb5ac906() {
        return this.isEnabled() && this.III_field_ba20ca4c.i_method_9b12da03();
    }

    public IIiIII_Class9.Nested1_e9dbeb13 I_method_7a5208f2(Matrix4f matrix4f, Matrix4f matrix4f2, Camera camera, float f) {
        this.I_field_de2624bc.I_field_d754d74.set((Matrix4fc)matrix4f2).mul((Matrix4fc)matrix4f);
        this.I_field_de2624bc.i_field_d754d74.set((Matrix4fc)this.I_field_de2624bc.I_field_d754d74).invert();
        Vec3d vec3d = camera.getPos();
        this.I_field_de2624bc.I_field_46 = (float)vec3d.x;
        this.I_field_de2624bc.i_field_46 = (float)vec3d.y;
        this.I_field_de2624bc.II_field_46 = (float)vec3d.z;
        int n = AmbienceModule.I_field_3a9bda27.world.getSkyColor(vec3d, f);
        this.I_field_de2624bc.Ii_field_46 = (float)(n >> 16 & 0xFF) / 255.0f;
        this.I_field_de2624bc.iI_field_46 = (float)(n >> 8 & 0xFF) / 255.0f;
        this.I_field_de2624bc.ii_field_46 = (float)(n & 0xFF) / 255.0f;
        boolean bl = AmbienceModule.I_field_3a9bda27.world.getDimension().hasSkyLight();
        float f2 = AmbienceModule.I_field_3a9bda27.world.getSkyAngleRadians(f);
        this.I_field_de2624bc.III_field_46 = -MathHelper.sin((float)f2);
        this.I_field_de2624bc.IIi_field_46 = MathHelper.cos((float)f2);
        this.I_field_de2624bc.IiI_field_46 = 0.0f;
        this.I_field_de2624bc.Iii_field_46 = this.Iii_field_73178e8c.Ii_method_a20abcd2() / 100.0f;
        this.I_field_de2624bc.iII_field_46 = this.iII_field_73178e8c.Ii_method_a20abcd2() / 100.0f;
        this.I_field_de2624bc.iIi_field_46 = 0.35f;
        this.I_field_de2624bc.iiI_field_46 = bl ? 0.45f : 0.0f;
        this.I_field_de2624bc.IIIi_field_46 = 24.0f;
        this.I_field_de2624bc.IIII_field_46 = 0.98f;
        this.I_field_de2624bc.IIiI_field_46 = 1.0f;
        this.I_field_de2624bc.IIii_field_46 = (float)(System.currentTimeMillis() % 3600000L) / 1000.0f;
        this.I_field_de2624bc.iii_field_46 = this.IIIi_field_500d0627.isSelected() ? 14.0f : (this.IIii_field_500d0627.isSelected() ? 40.0f : 24.0f);
        return this.I_field_de2624bc;
    }

    public boolean IIIi_method_bb6954e6() {
        return this.IIi_field_ba20ca4c.i_method_9b12da03();
    }

    public float i_method_d4ac91af() {
        return this.IIi_field_ba20ca4c.i_method_9b12da03() ? 1.0f : 0.0f;
    }

    public Vector3f i_method_c1bfe21a() {
        ColorRGBA colorRGBA = this.iI_field_bbd4b66c.I_method_bde5f08e();
        return new Vector3f(colorRGBA.getRed() / 255.0f, colorRGBA.getGreen() / 255.0f, colorRGBA.getBlue() / 255.0f);
    }

    private float IiI_method_28d5e64f() {
        if (this.Iiii_field_500d0627.isSelected()) {
            return this.iIi_field_73178e8c.Ii_method_a20abcd2() / 100.0f;
        }
        if (this.IiII_field_500d0627.isSelected()) {
            return 0.15f;
        }
        if (this.IiiI_field_500d0627.isSelected()) {
            return 0.85f;
        }
        return 0.5f;
    }

    public float II_method_bf31ad52() {
        return (8.0f + this.IiI_method_28d5e64f() * 47.0f) / 360.0f;
    }

    public float Ii_method_bf403932() {
        return 0.55f - this.IiI_method_28d5e64f() * 0.43f;
    }

    public float iI_method_c0f49d72() {
        return 0.45f - this.IiI_method_28d5e64f() * 0.37f;
    }

    public float ii_method_c1032952() {
        return this.iiI_field_73178e8c.Ii_method_a20abcd2() / 100.0f;
    }

    public Identifier I_method_92d7d4ee() {
        return iiiIiii_Class120.I_method_601d95f8(this.II_method_87d0777e());
    }

    private String II_method_87d0777e() {
        return "sky/" + Math.max(this.I_field_bbe33e6c.I_method_e1d4a248().indexOf(this.I_field_bbe33e6c.i_method_f85f3850()), 1);
    }

    public float III_method_2712f62f() {
        return this.I_field_73178e8c.Ii_method_a20abcd2() / 100.0f;
    }

    @Generated
    public MultiSelectSetting I_method_28b776b5() {
        return this.I_field_bbe3ba6c;
    }

    @Generated
    public MultiSelectSetting.Nested1_42856060 I_method_d8b45030() {
        return this.I_field_51de8227;
    }

    @Generated
    public MultiSelectSetting.Nested1_42856060 i_method_debc4c10() {
        return this.i_field_51de8227;
    }

    @Generated
    public MultiSelectSetting.Nested1_42856060 II_method_3ab96533() {
        return this.II_field_51de8227;
    }

    @Generated
    public BooleanSetting I_method_26f48695() {
        return this.II_field_ba20ca4c;
    }

    @Generated
    public ColorSetting I_method_28a872b5() {
        return this.I_field_bbd4b66c;
    }

    @Generated
    public ColorSetting i_method_3e3de695() {
        return this.i_field_bbd4b66c;
    }

    @Generated
    public ColorSetting II_method_67e4ec78() {
        return this.II_field_bbd4b66c;
    }

    @Generated
    public ModeSetting I_method_28b6fab5() {
        return this.I_field_bbe33e6c;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 I_method_d6e2d430() {
        return this.I_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 i_method_dcead010() {
        return this.i_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 II_method_38e7e933() {
        return this.II_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 Ii_method_3eefe513() {
        return this.Ii_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 iI_method_f3df6953() {
        return this.iI_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 ii_method_f9e76533() {
        return this.ii_field_500d0627;
    }

    @Generated
    public BooleanSetting i_method_3c89fa75() {
        return this.Ii_field_ba20ca4c;
    }

    @Generated
    public ModeSetting i_method_3e4c6e95() {
        return this.i_field_bbe33e6c;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 III_method_17857490() {
        return this.III_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 IIi_method_1d8d7070() {
        return this.IIi_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 IiI_method_d27cf4b0() {
        return this.IiI_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 Iii_method_d884f090() {
        return this.Iii_field_500d0627;
    }

    @Generated
    public SliderSetting I_method_dfeb4ad5() {
        return this.I_field_73178e8c;
    }

    @Generated
    public BooleanSetting II_method_66310058() {
        return this.iI_field_ba20ca4c;
    }

    @Generated
    public SliderSetting i_method_f580beb5() {
        return this.i_field_73178e8c;
    }

    @Generated
    public SliderSetting II_method_1f27c498() {
        return this.II_field_73178e8c;
    }

    @Generated
    public SliderSetting Ii_method_34bd3878() {
        return this.Ii_field_73178e8c;
    }

    @Generated
    public SliderSetting iI_method_bc40ccb8() {
        return this.iI_field_73178e8c;
    }

    @Generated
    public BooleanSetting Ii_method_7bc67438() {
        return this.ii_field_ba20ca4c;
    }

    @Generated
    public ModeSetting II_method_67f37478() {
        return this.II_field_bbe33e6c;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 iII_method_bb7df870() {
        return this.iII_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 iIi_method_c185f450() {
        return this.iIi_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 iiI_method_76757890() {
        return this.iiI_field_500d0627;
    }

    @Generated
    public ColorSetting Ii_method_7d7a6058() {
        return this.Ii_field_bbd4b66c;
    }

    @Generated
    public SliderSetting ii_method_d1d64098() {
        return this.ii_field_73178e8c;
    }

    @Generated
    public SliderSetting III_method_c77a8335() {
        return this.III_field_73178e8c;
    }

    @Generated
    public SliderSetting IIi_method_dd0ff715() {
        return this.IIi_field_73178e8c;
    }

    @Generated
    public SliderSetting IiI_method_64938b55() {
        return this.IiI_field_73178e8c;
    }

    @Generated
    public ModeSetting Ii_method_7d88e858() {
        return this.Ii_field_bbe33e6c;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 iii_method_7c7d7470() {
        return this.iii_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 IIII_method_c9954d3() {
        return this.IIII_field_500d0627;
    }

    @Generated
    public BooleanSetting iI_method_34a0878() {
        return this.III_field_ba20ca4c;
    }

    @Generated
    public SliderSetting Iii_method_7a28ff35() {
        return this.Iii_field_73178e8c;
    }

    @Generated
    public SliderSetting iII_method_cd827f15() {
        return this.iII_field_73178e8c;
    }

    @Generated
    public ModeSetting iI_method_50c7c98() {
        return this.iI_field_bbe33e6c;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 IIIi_method_12a150b3() {
        return this.IIIi_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 IIiI_method_c790d4f3() {
        return this.IIiI_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 IIii_method_cd98d0d3() {
        return this.IIii_field_500d0627;
    }

    @Generated
    public BooleanSetting ii_method_18df7c58() {
        return this.IIi_field_ba20ca4c;
    }

    @Generated
    public ColorSetting iI_method_4fdf498() {
        return this.iI_field_bbd4b66c;
    }

    @Generated
    public ModeSetting ii_method_1aa1f078() {
        return this.ii_field_bbe33e6c;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 IiII_method_b091d8b3() {
        return this.IiII_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 IiIi_method_b699d493() {
        return this.IiIi_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 IiiI_method_6b8958d3() {
        return this.IiiI_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 Iiii_method_719154b3() {
        return this.Iiii_field_500d0627;
    }

    @Generated
    public BooleanSetting III_method_e83bef5() {
        return this.IiI_field_ba20ca4c;
    }

    @Generated
    public SliderSetting iIi_method_e317f2f5() {
        return this.iii_field_73178e8c;
    }

    @Generated
    public BooleanSetting IIi_method_241932d5() {
        return this.I_field_ba20ca4c;
    }

    @Generated
    public BooleanSetting IiI_method_ab9cc715() {
        return this.i_field_ba20ca4c;
    }

    @Generated
    public ModeSetting III_method_10463315() {
        return this.III_field_bbe33e6c;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 iIII_method_e7b14cf3() {
        return this.iIII_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 iIIi_method_edb948d3() {
        return this.iIIi_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 iIiI_method_a2a8cd13() {
        return this.iIiI_field_500d0627;
    }

    @Generated
    public SliderSetting iiI_method_6a9b8735() {
        return this.IIII_field_73178e8c;
    }

    @Generated
    public SliderSetting iii_method_8030fb15() {
        return this.IIIi_field_73178e8c;
    }

    @Generated
    public BooleanSetting Iii_method_c1323af5() {
        return this.Iii_field_ba20ca4c;
    }

    @Generated
    public BooleanSetting iII_method_148bbad5() {
        return this.iII_field_ba20ca4c;
    }

    @Generated
    public ColorSetting ii_method_1a936878() {
        return this.ii_field_bbd4b66c;
    }

    @Generated
    public IIiIII_Class9.Nested1_e9dbeb13 I_method_13353b53() {
        return this.I_field_de2624bc;
    }

    @Generated
    public iIiiiIIIi_Class370 I_method_b013a675() {
        return this.I_field_433fea2c;
    }

    @Generated
    public iIiiiiIIi_Class378 I_method_b1d69695() {
        return this.I_field_4502da4c;
    }

    @Generated
    public long I_method_d49e05d3() {
        return this.I_field_4a;
    }

    @Generated
    public BlockPos I_method_72fa9251() {
        return this.I_field_670402ba;
    }

    @Generated
    public float IIi_method_2721820f() {
        return this.Ii_field_46;
    }

    @Generated
    public int II_method_bf31ad55() {
        return this.I_field_49;
    }

    @Generated
    public boolean IIiI_method_bd1db926() {
        return this.i_field_5a;
    }

    @Generated
    public IiiiIiIii_Class236 i_method_90312af5() {
        return this.I_field_dc7facc;
    }

    @Generated
    public IiIIIiII_Class69<ReceivePacketEvent> I_method_72a285d8() {
        return this.I_field_3d936f41;
    }

    @Generated
    public IiIIIiII_Class69<Render3DEvent> i_method_9c9f15f8() {
        return this.i_field_3d936f41;
    }
}

