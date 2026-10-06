package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import lombok.Generated;
import net.minecraft.block.BlockState;
import net.minecraft.client.gl.ShaderProgramKey;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;
import pyrock.events.render.PreHudRenderEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.BooleanSetting;
import rockstar.client.ColorSetting;
import rockstar.client.GradientColorSetting;
import rockstar.client.SliderSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.IiiiIiiI_Class119;
import rockstar.client.IiiiIiii_Class120;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.IiiiiIiI_Class123;
import rockstar.client.IiiiiIii_Class124;
import rockstar.client.iIIiIIiii_Class296;
import rockstar.client.iIiiIIiII_Class357;
import rockstar.client.iIiiIIiii_Class360;
import rockstar.client.iIiiI_Class23;
import rockstar.client.iIiii_Class24;

public class iIIIIIII_Class129
extends IiiiIiiI_Class119
implements iIIiIIiii_Class296 {
    public static boolean I_field_5a;
    private static final int I_field_49 = 0xF000F0;
    private static final int i_field_49 = 24;
    private static final ColorRGBA I_field_d0c8ec5;
    private final BooleanSetting I_field_ba20ca4c = this.I_method_5436696c("esp.flame");
    private final SliderSetting I_field_73178e8c = new SliderSetting(this, "esp.flame.strength").I_method_c8c9a7d7(1.0f).i_method_65e2aff7(5.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(3.0f);
    private final SliderSetting i_field_73178e8c = new SliderSetting(this, "esp.flame.rise_speed").I_method_c8c9a7d7(0.5f).i_method_65e2aff7(4.0f).II_method_b0f56334(0.1f).Ii_method_4e0e6b54(2.5f);
    private final SliderSetting II_field_73178e8c = new SliderSetting(this, "esp.flame.wobble").I_method_c8c9a7d7(0.0f).i_method_65e2aff7(2.0f).II_method_b0f56334(0.1f).Ii_method_4e0e6b54(2.5f);
    private final SliderSetting Ii_field_73178e8c = new SliderSetting(this, "esp.flame.fade_rate").I_method_c8c9a7d7(0.0f).i_method_65e2aff7(80.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(50.0f);
    private final SliderSetting iI_field_73178e8c = new SliderSetting(this, "esp.flame.intensity").I_method_c8c9a7d7(0.5f).i_method_65e2aff7(4.0f).II_method_b0f56334(0.1f).Ii_method_4e0e6b54(2.0f);
    private final BooleanSetting i_field_ba20ca4c = new BooleanSetting(this, "esp.flame.distortion");
    private final SliderSetting ii_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "esp.flame.distortion_strength", () -> !this.i_field_ba20ca4c.i_method_9b12da03()).I_method_c8c9a7d7(0.1f).i_method_65e2aff7(3.0f).II_method_b0f56334(0.1f).Ii_method_4e0e6b54(1.0f);
    private final BooleanSetting II_field_ba20ca4c = new BooleanSetting(this, "esp.flame.item_color");
    private final BooleanSetting Ii_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "theme.sync", this.II_field_ba20ca4c::i_method_9b12da03);
    private final BooleanSetting iI_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "esp.flame.gradient", () -> this.II_field_ba20ca4c.i_method_9b12da03() || this.Ii_field_ba20ca4c.i_method_9b12da03());
    private final GradientColorSetting I_field_bbd52aac = new GradientColorSetting(this, "esp.flame.gradient_color", () -> this.II_field_ba20ca4c.i_method_9b12da03() || this.Ii_field_ba20ca4c.i_method_9b12da03() || !this.iI_field_ba20ca4c.i_method_9b12da03()).I_method_1119eb95(new ColorRGBA(255.0f, 220.0f, 60.0f, 255.0f), new ColorRGBA(255.0f, 60.0f, 0.0f, 255.0f));
    private final ColorSetting I_field_bbd4b66c = new ColorSetting(this, "esp.flame.color", () -> this.II_field_ba20ca4c.i_method_9b12da03() || this.Ii_field_ba20ca4c.i_method_9b12da03() || this.iI_field_ba20ca4c.i_method_9b12da03()).I_method_a62f5dd6(new ColorRGBA(255.0f, 110.0f, 30.0f, 255.0f));
    private final iIiiIIiII_Class357 I_field_cb35e4c = new iIiiIIiII_Class357(true).I_method_cc37aab5().I_method_7d3fafd7(1.0f);
    private final iIiiIIiII_Class357 i_field_cb35e4c = new iIiiIIiII_Class357(true).I_method_cc37aab5().I_method_7d3fafd7(1.0f);
    private final iIiiIIiII_Class357 II_field_cb35e4c = new iIiiIIiII_Class357(true).I_method_cc37aab5().I_method_7d3fafd7(1.0f);
    private final iIiiIIiII_Class357 Ii_field_cb35e4c = new iIiiIIiII_Class357(true).I_method_cc37aab5().I_method_7d3fafd7(1.0f);
    private final iIiiI_Class23 I_field_6433b52c = iIiiI_Class23.I_method_e3b16f5();
    private final iIiii_Class24 I_field_6433b90c = new iIiii_Class24();
    private boolean i_field_5a = false;
    private boolean II_field_5a = false;
    private final IiIIIiII_Class69<Render3DEvent> I_field_3d936f41 = render3DEvent -> {
        boolean bl;
        this.i_field_5a = false;
        boolean bl2 = bl = iIIIIIII_Class129.I_field_3a9bda27.options != null && iIIIIIII_Class129.I_field_3a9bda27.options.getPerspective() != null && iIIIIIII_Class129.I_field_3a9bda27.options.getPerspective().isFirstPerson();
        if (!this.i_method_6c6ff6d1(IiiiIiii_Class120.I_field_10f66741) || !bl) {
            if (this.II_field_5a) {
                this.i_field_cb35e4c.I_method_53fdf4b5(true);
                this.i_field_cb35e4c.i_method_766109df();
                this.II_field_5a = false;
            }
            return;
        }
        this.I_field_cb35e4c.I_method_53fdf4b5(true);
        this.I_field_cb35e4c.i_method_766109df();
    };
    private final IiIIIiII_Class69<PreHudRenderEvent> i_field_3d936f41 = preHudRenderEvent -> {
        iIiiIIiII_Class357 iIiiIIiII_Class3572;
        int n;
        float f;
        float f2;
        if (!this.i_method_6c6ff6d1(IiiiIiii_Class120.I_field_10f66741)) {
            return;
        }
        if (this.II_field_5a) {
            this.i_method_614a0cc();
            f2 = Math.max(0.0f, Math.min(1.0f, this.Ii_field_73178e8c.Ii_method_a20abcd2() / 100.0f));
            f = 0.94f + f2 * 0.055f;
            if (!this.i_field_5a) {
                f += (1.0f - f) * 0.5f;
            }
            this.I_method_babcf054(f);
        }
        if (this.i_field_5a) {
            if (this.iI_field_ba20ca4c.i_method_9b12da03() && !this.II_field_ba20ca4c.i_method_9b12da03() && !this.Ii_field_ba20ca4c.i_method_9b12da03()) {
                this.I_method_22169713(I_field_d0c8ec5);
            } else {
                ColorRGBA colorRGBA = this.I_method_122acb5b();
                if (colorRGBA != null) {
                    this.I_method_22169713(colorRGBA);
                }
            }
            this.II_method_bacb7ff5();
            this.II_field_5a = true;
        }
        if (!this.II_field_5a) {
            return;
        }
        if (this.i_field_ba20ca4c.i_method_9b12da03() && (n = this.i_field_cb35e4c.getColorAttachment()) != 0) {
            f = (float)I_field_587075c2.getScaledWidth() / (float)Math.max(1, I_field_587075c2.getScaledHeight());
            float f3 = (float)(System.currentTimeMillis() % 100000L) / 1000.0f;
            this.I_field_6433b90c.I_method_8fc6f51c(n, f, this.ii_field_73178e8c.Ii_method_a20abcd2(), f3);
        }
        f2 = this.iI_field_73178e8c.Ii_method_a20abcd2();
        if (this.i_field_5a) {
            this.Ii_method_bada0bd5();
            iIiiIIiII_Class3572 = this.Ii_field_cb35e4c;
        } else {
            iIiiIIiII_Class3572 = this.i_field_cb35e4c;
        }
        if (f2 <= 0.01f) {
            return;
        }
        this.I_field_6433b52c.i_method_dd886024(Math.max(1, (int)(this.I_field_73178e8c.Ii_method_a20abcd2() / 2.0f)));
        this.I_field_6433b52c.i_method_c0dc3e7(iIiiIIiII_Class3572);
        IiiiiIii_Class124.I_method_a75705ba(this.I_field_6433b52c.i_method_d2c82775());
        int n2 = this.I_field_6433b52c.i_method_7256ab2();
        if (n2 != 0) {
            RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_TEX_COLOR);
            RenderSystem.disableDepthTest();
            RenderSystem.disableCull();
            RenderSystem.enableBlend();
            RenderSystem.blendFunc((GlStateManager.SrcFactor)GlStateManager.SrcFactor.SRC_ALPHA, (GlStateManager.DstFactor)GlStateManager.DstFactor.ONE);
            RenderSystem.setShaderTexture((int)0, (int)n2);
            RenderSystem.setShaderColor((float)f2, (float)f2, (float)f2, (float)1.0f);
            ColorRGBA colorRGBA = this.I_field_bbd52aac.I_method_b3b144ce();
            ColorRGBA colorRGBA2 = this.I_field_bbd52aac.i_method_3b9850ae();
            if (this.iI_field_ba20ca4c.i_method_9b12da03() && !this.II_field_ba20ca4c.i_method_9b12da03() && !this.Ii_field_ba20ca4c.i_method_9b12da03() && colorRGBA != null && colorRGBA2 != null) {
                iIIIIIII_Class129.I_method_9bf4044c(0.0f, 0.0f, I_field_587075c2.getScaledWidth(), I_field_587075c2.getScaledHeight(), iIIIIIII_Class129.i_method_97110726(colorRGBA), iIIIIIII_Class129.i_method_97110726(colorRGBA2));
            } else {
                iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, I_field_587075c2.getScaledWidth(), I_field_587075c2.getScaledHeight());
            }
        }
        RenderSystem.depthMask((boolean)true);
        RenderSystem.setShaderTexture((int)0, (int)0);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderSystem.disableBlend();
        RenderSystem.enableCull();
        RenderSystem.disableDepthTest();
        RenderSystem.defaultBlendFunc();
    };
    private static final int II_field_49 = 4;
    private static final float I_field_46 = 80.0f;

    public iIIIIIII_Class129() {
        super("flame", new IiiiIiii_Class120[]{IiiiIiii_Class120.I_field_10f66741}, IiiiiIiI_Class123.Ii_field_12aac7a1);
        this.I_field_6433b52c.I_method_716dedf();
        this.I_field_6433b52c.I_method_dbc57004(3);
        this.I_field_6433b52c.I_method_dbc564c1(2.2f);
        this.I_field_6433b90c.I_method_3db1f2bf();
    }

    public ColorRGBA I_method_122acb5b() {
        if (this.II_field_ba20ca4c.i_method_9b12da03()) {
            return null;
        }
        return this.Ii_field_ba20ca4c.i_method_9b12da03() ? IiiiiIIIi_Class242.i_method_5dfec6e() : this.I_field_bbd4b66c.I_method_bde5f08e();
    }

    public void I_method_15ee37a9(HeldItemRenderer heldItemRenderer, AbstractClientPlayerEntity abstractClientPlayerEntity, ItemStack itemStack, ModelTransformationMode modelTransformationMode, boolean bl, MatrixStack matrixStack, int n) {
        if (!this.i_method_6c6ff6d1(IiiiIiii_Class120.I_field_10f66741)) {
            return;
        }
        if (itemStack == null || itemStack.isEmpty()) {
            return;
        }
        I_field_5a = true;
        this.I_field_cb35e4c.I_method_53fdf4b5(false);
        VertexConsumerProvider.Immediate immediate = I_field_3a9bda27.getBufferBuilders().getEntityVertexConsumers();
        try {
            heldItemRenderer.renderItem((LivingEntity)abstractClientPlayerEntity, itemStack, modelTransformationMode, bl, matrixStack, (VertexConsumerProvider)immediate, 0xF000F0);
            immediate.draw();
            this.i_field_5a = true;
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.I_field_cb35e4c.i_method_766109df();
        I_field_5a = false;
    }

    public void I_method_1669436(BlockRenderManager blockRenderManager, BlockState blockState, MatrixStack matrixStack, int n) {
        if (!this.i_method_6c6ff6d1(IiiiIiii_Class120.I_field_10f66741)) {
            return;
        }
        if (blockState == null) {
            return;
        }
        I_field_5a = true;
        this.I_field_cb35e4c.I_method_53fdf4b5(false);
        VertexConsumerProvider.Immediate immediate = I_field_3a9bda27.getBufferBuilders().getEntityVertexConsumers();
        try {
            blockRenderManager.renderBlockAsEntity(blockState, matrixStack, (VertexConsumerProvider)immediate, 0xF000F0, n);
            immediate.draw();
            this.i_field_5a = true;
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.I_field_cb35e4c.i_method_766109df();
        I_field_5a = false;
    }

    private void i_method_614a0cc() {
        float f = I_field_587075c2.getScaledWidth();
        float f2 = I_field_587075c2.getScaledHeight();
        float f3 = this.i_field_73178e8c.Ii_method_a20abcd2();
        float f4 = this.II_field_73178e8c.Ii_method_a20abcd2();
        float f5 = (float)(System.currentTimeMillis() % 100000L) / 1000.0f;
        this.II_field_cb35e4c.I_method_53fdf4b5(true);
        RenderSystem.disableBlend();
        RenderSystem.disableDepthTest();
        RenderSystem.disableCull();
        RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_TEX_COLOR);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderSystem.setShaderTexture((int)0, (int)this.i_field_cb35e4c.getColorAttachment());
        for (int i = 0; i < 24; ++i) {
            float f6 = (float)i / 24.0f;
            float f7 = (float)(i + 1) / 24.0f;
            float f8 = f6 * f2 - f3;
            float f9 = f7 * f2 - f3;
            float f10 = 1.0f - f6;
            float f11 = 1.0f - f7;
            float f12 = (float)i * 0.45f;
            float f13 = (float)Math.sin(f5 * 4.5f + f12) * f4 + (float)Math.sin(f5 * 1.7f + f12 * 2.1f) * (f4 * 0.5f) + (float)Math.sin(f5 * 7.3f + f12 * 3.7f) * (f4 * 0.32f) + (float)Math.sin(f5 * 2.3f + f12 * 1.3f) * (f4 * 0.45f) + (float)Math.sin(f5 * 0.61f + f12 * 0.7f) * (f4 * 0.35f);
            BufferBuilder bufferBuilder = RenderSystem.renderThreadTesselator().begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
            bufferBuilder.vertex(f13, f8, 0.0f).texture(0.0f, f10).color(-1);
            bufferBuilder.vertex(f13, f9, 0.0f).texture(0.0f, f11).color(-1);
            bufferBuilder.vertex(f + f13, f9, 0.0f).texture(1.0f, f11).color(-1);
            bufferBuilder.vertex(f + f13, f8, 0.0f).texture(1.0f, f10).color(-1);
            BufferRenderer.drawWithGlobalProgram((BuiltBuffer)bufferBuilder.end());
        }
        RenderSystem.setShaderTexture((int)0, (int)0);
        this.i_field_cb35e4c.I_method_53fdf4b5(true);
        RenderSystem.disableBlend();
        RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_TEX_COLOR);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderSystem.setShaderTexture((int)0, (int)this.II_field_cb35e4c.getColorAttachment());
        iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, f, f2);
        RenderSystem.setShaderTexture((int)0, (int)0);
        I_field_3a9bda27.getFramebuffer().beginWrite(true);
    }

    private void I_method_babcf054(float f) {
        this.i_field_cb35e4c.I_method_53fdf4b5(false);
        RenderSystem.enableBlend();
        RenderSystem.blendFunc((GlStateManager.SrcFactor)GlStateManager.SrcFactor.ZERO, (GlStateManager.DstFactor)GlStateManager.DstFactor.SRC_ALPHA);
        RenderSystem.disableDepthTest();
        RenderSystem.disableCull();
        RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_COLOR);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        int n = Math.round(f * 255.0f) & 0xFF;
        int n2 = n << 24;
        float f2 = I_field_587075c2.getScaledWidth();
        float f3 = I_field_587075c2.getScaledHeight();
        BufferBuilder bufferBuilder = Tessellator.getInstance().begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR);
        bufferBuilder.vertex(0.0f, 0.0f, 0.0f).color(n2);
        bufferBuilder.vertex(0.0f, f3, 0.0f).color(n2);
        bufferBuilder.vertex(f2, f3, 0.0f).color(n2);
        bufferBuilder.vertex(f2, 0.0f, 0.0f).color(n2);
        BufferRenderer.drawWithGlobalProgram((BuiltBuffer)bufferBuilder.end());
        RenderSystem.defaultBlendFunc();
        I_field_3a9bda27.getFramebuffer().beginWrite(true);
    }

    private void II_method_bacb7ff5() {
        this.i_field_cb35e4c.I_method_53fdf4b5(false);
        RenderSystem.enableBlend();
        GlStateManager._blendFuncSeparate((int)770, (int)771, (int)1, (int)771);
        RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_TEX_COLOR);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderSystem.setShaderTexture((int)0, (int)this.I_field_cb35e4c.getColorAttachment());
        iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, I_field_587075c2.getScaledWidth(), I_field_587075c2.getScaledHeight());
        RenderSystem.setShaderTexture((int)0, (int)0);
        RenderSystem.defaultBlendFunc();
        I_field_3a9bda27.getFramebuffer().beginWrite(true);
    }

    private void Ii_method_bada0bd5() {
        this.Ii_field_cb35e4c.I_method_53fdf4b5(true);
        RenderSystem.disableBlend();
        RenderSystem.disableDepthTest();
        RenderSystem.disableCull();
        RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_TEX_COLOR);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderSystem.setShaderTexture((int)0, (int)this.i_field_cb35e4c.getColorAttachment());
        iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, I_field_587075c2.getScaledWidth(), I_field_587075c2.getScaledHeight());
        if (this.i_field_5a) {
            RenderSystem.enableBlend();
            RenderSystem.blendFuncSeparate((GlStateManager.SrcFactor)GlStateManager.SrcFactor.ZERO, (GlStateManager.DstFactor)GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SrcFactor)GlStateManager.SrcFactor.ZERO, (GlStateManager.DstFactor)GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA);
            RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_TEX_COLOR);
            RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)0.45f);
            RenderSystem.setShaderTexture((int)0, (int)this.I_field_cb35e4c.getColorAttachment());
            iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, I_field_587075c2.getScaledWidth(), I_field_587075c2.getScaledHeight());
            RenderSystem.defaultBlendFunc();
        }
        RenderSystem.setShaderTexture((int)0, (int)0);
        I_field_3a9bda27.getFramebuffer().beginWrite(true);
    }

    private void I_method_22169713(ColorRGBA colorRGBA) {
        this.I_field_cb35e4c.beginWrite(true);
        RenderSystem.enableBlend();
        GlStateManager._blendFuncSeparate((int)772, (int)0, (int)0, (int)1);
        RenderSystem.disableDepthTest();
        RenderSystem.disableCull();
        RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_COLOR);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        int n = iIIIIIII_Class129.I_method_22169706(colorRGBA);
        float f = I_field_587075c2.getScaledWidth();
        float f2 = I_field_587075c2.getScaledHeight();
        BufferBuilder bufferBuilder = Tessellator.getInstance().begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR);
        bufferBuilder.vertex(0.0f, 0.0f, 0.0f).color(n);
        bufferBuilder.vertex(0.0f, f2, 0.0f).color(n);
        bufferBuilder.vertex(f, f2, 0.0f).color(n);
        bufferBuilder.vertex(f, 0.0f, 0.0f).color(n);
        BufferRenderer.drawWithGlobalProgram((BuiltBuffer)bufferBuilder.end());
        RenderSystem.defaultBlendFunc();
        I_field_3a9bda27.getFramebuffer().beginWrite(true);
    }

    private static void I_method_9bf4044c(float f, float f2, float f3, float f4, int n, int n2) {
        float f5 = f4 / 4.0f;
        float f6 = 2.0f * f5;
        float f7 = (float)(System.currentTimeMillis() % 1000000L) / 1000.0f;
        float f8 = f7 * 80.0f % f6;
        int n3 = 2;
        BufferBuilder bufferBuilder = RenderSystem.renderThreadTesselator().begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
        for (int i = -n3; i < 4 + n3; ++i) {
            boolean bl = Math.floorMod(i, 2) == 0;
            int n4 = bl ? n : n2;
            int n5 = bl ? n2 : n;
            float f9 = f2 + (float)i * f5 - f8;
            float f10 = f9 + f5;
            float f11 = 1.0f - (f9 - f2) / f4;
            float f12 = 1.0f - (f10 - f2) / f4;
            bufferBuilder.vertex(f, f9, 0.0f).texture(0.0f, f11).color(n4);
            bufferBuilder.vertex(f, f10, 0.0f).texture(0.0f, f12).color(n5);
            bufferBuilder.vertex(f + f3, f10, 0.0f).texture(1.0f, f12).color(n5);
            bufferBuilder.vertex(f + f3, f9, 0.0f).texture(1.0f, f11).color(n4);
        }
        BufferRenderer.drawWithGlobalProgram((BuiltBuffer)bufferBuilder.end());
    }

    private static int I_method_22169706(ColorRGBA colorRGBA) {
        float f = Math.max(0.0f, Math.min(1.0f, colorRGBA.getAlpha() / 255.0f));
        int n = Math.round(colorRGBA.getRed() * f) & 0xFF;
        int n2 = Math.round(colorRGBA.getGreen() * f) & 0xFF;
        int n3 = Math.round(colorRGBA.getBlue() * f) & 0xFF;
        return 0xFF000000 | n << 16 | n2 << 8 | n3;
    }

    private static int i_method_97110726(ColorRGBA colorRGBA) {
        int n = Math.round(colorRGBA.getRed()) & 0xFF;
        int n2 = Math.round(colorRGBA.getGreen()) & 0xFF;
        int n3 = Math.round(colorRGBA.getBlue()) & 0xFF;
        return 0xFF000000 | n << 16 | n2 << 8 | n3;
    }

    @Generated
    public BooleanSetting I_method_8f75af62() {
        return this.I_field_ba20ca4c;
    }

    @Generated
    public SliderSetting I_method_486c73a2() {
        return this.I_field_73178e8c;
    }

    @Generated
    public SliderSetting i_method_5e01e782() {
        return this.i_field_73178e8c;
    }

    @Generated
    public SliderSetting II_method_c6cbb56b() {
        return this.II_field_73178e8c;
    }

    @Generated
    public SliderSetting Ii_method_dc61294b() {
        return this.Ii_field_73178e8c;
    }

    @Generated
    public SliderSetting iI_method_63e4bd8b() {
        return this.iI_field_73178e8c;
    }

    @Generated
    public BooleanSetting i_method_a50b2342() {
        return this.i_field_ba20ca4c;
    }

    @Generated
    public SliderSetting ii_method_797a316b() {
        return this.ii_field_73178e8c;
    }

    @Generated
    public BooleanSetting II_method_dd4f12b() {
        return this.II_field_ba20ca4c;
    }

    @Generated
    public BooleanSetting Ii_method_236a650b() {
        return this.Ii_field_ba20ca4c;
    }

    @Generated
    public BooleanSetting iI_method_aaedf94b() {
        return this.iI_field_ba20ca4c;
    }

    @Generated
    public GradientColorSetting I_method_912a0fc2() {
        return this.I_field_bbd52aac;
    }

    @Generated
    public ColorSetting I_method_91299b82() {
        return this.I_field_bbd4b66c;
    }

    @Generated
    public iIiiIIiII_Class357 I_method_e2084362() {
        return this.I_field_cb35e4c;
    }

    @Generated
    public iIiiIIiII_Class357 i_method_f79db742() {
        return this.i_field_cb35e4c;
    }

    @Generated
    public iIiiIIiII_Class357 II_method_6067852b() {
        return this.II_field_cb35e4c;
    }

    @Generated
    public iIiiIIiII_Class357 Ii_method_75fcf90b() {
        return this.Ii_field_cb35e4c;
    }

    @Generated
    public iIiiI_Class23 I_method_dac29542() {
        return this.I_field_6433b52c;
    }

    @Generated
    public iIiii_Class24 I_method_dac29922() {
        return this.I_field_6433b90c;
    }

    @Generated
    public boolean i_method_614a0d0() {
        return this.i_field_5a;
    }

    @Generated
    public boolean II_method_bacb7ff9() {
        return this.II_field_5a;
    }

    @Generated
    public IiIIIiII_Class69<Render3DEvent> I_method_fa228f6b() {
        return this.I_field_3d936f41;
    }

    @Generated
    public IiIIIiII_Class69<PreHudRenderEvent> i_method_241f1f8b() {
        return this.i_field_3d936f41;
    }

    static {
        I_field_d0c8ec5 = new ColorRGBA(255.0f, 255.0f, 255.0f, 255.0f);
    }
}

