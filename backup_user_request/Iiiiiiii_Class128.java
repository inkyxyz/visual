package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.ProjectionType;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.Arrays;
import lombok.Generated;
import net.minecraft.block.BlockState;
import net.minecraft.client.gl.Framebuffer;
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
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;
import org.joml.Matrix4fc;
import org.joml.Vector4f;
import pyrock.events.render.PreHudRenderEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.BooleanSetting;
import rockstar.client.ColorSetting;
import rockstar.client.ModeSetting;
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
import rockstar.client.iiIIi_Class26;

public class Iiiiiiii_Class128
extends IiiiIiiI_Class119
implements iIIiIIiii_Class296 {
    public static boolean I_field_5a;
    private static final int I_field_49 = 0xF000F0;
    private static final float I_field_46 = 2.4f;
    private final BooleanSetting I_field_ba20ca4c = this.I_method_5436696c("esp.fill");
    private final ModeSetting I_field_bbe33e6c = new ModeSetting(this, "esp.fill.mode");
    private final ModeSetting.Nested1_42765c60 I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "esp.fill.mode.mirror");
    private final ModeSetting.Nested1_42765c60 i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "esp.fill.mode.shader");
    private final BooleanSetting i_field_ba20ca4c = new BooleanSetting(this, "theme.sync");
    private final ColorSetting I_field_bbd4b66c = new ColorSetting(this, "esp.fill.color", this.i_field_ba20ca4c::i_method_9b12da03).I_method_a62f5dd6(new ColorRGBA(255.0f, 60.0f, 60.0f, 255.0f));
    private final BooleanSetting II_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "esp.fill.mirror_flat", () -> this.I_field_bbe33e6c.i_method_f85f3850() != this.I_field_500d0627);
    private final SliderSetting I_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "esp.fill.mirror_alpha", () -> this.I_field_bbe33e6c.i_method_f85f3850() != this.I_field_500d0627).I_method_c8c9a7d7(0.0f).i_method_65e2aff7(100.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(100.0f);
    private final SliderSetting i_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "esp.fill.mirror_blur", () -> this.I_field_bbe33e6c.i_method_f85f3850() != this.I_field_500d0627).I_method_c8c9a7d7(0.0f).i_method_65e2aff7(10.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(0.0f);
    private final SliderSetting II_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "esp.fill.mirror_ambient", () -> this.I_field_bbe33e6c.i_method_f85f3850() != this.I_field_500d0627 || this.II_field_ba20ca4c.i_method_9b12da03()).I_method_c8c9a7d7(0.0f).i_method_65e2aff7(100.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(35.0f);
    private final ModeSetting i_field_bbe33e6c = new ModeSetting((IIiiiIIiI_Class115)this, "esp.fill.shader", () -> this.I_field_bbe33e6c.i_method_f85f3850() != this.i_field_500d0627);
    private final ModeSetting.Nested1_42765c60 II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "esp.fill.shader.caustic");
    private final ModeSetting.Nested1_42765c60 Ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "esp.fill.shader.plasma");
    private final ModeSetting.Nested1_42765c60 iI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "esp.fill.shader.lava");
    private final SliderSetting Ii_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "esp.fill.shader_speed", () -> this.I_field_bbe33e6c.i_method_f85f3850() != this.i_field_500d0627).I_method_c8c9a7d7(0.0f).i_method_65e2aff7(0.5f).II_method_b0f56334(0.01f).Ii_method_4e0e6b54(0.25f);
    private final SliderSetting iI_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "esp.fill.shader_alpha", () -> this.I_field_bbe33e6c.i_method_f85f3850() != this.i_field_500d0627).I_method_c8c9a7d7(0.0f).i_method_65e2aff7(100.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(100.0f);
    private static final int i_field_49 = 2;
    private final iIiiIIiII_Class357[] I_field_a700fd11 = new iIiiIIiII_Class357[]{new iIiiIIiII_Class357(true).I_method_cc37aab5().I_method_7d3fafd7(1.0f), new iIiiIIiII_Class357(true).I_method_cc37aab5().I_method_7d3fafd7(1.0f)};
    private final iIiiIIiII_Class357 I_field_cb35e4c = new iIiiIIiII_Class357(false).I_method_cc37aab5().I_method_7d3fafd7(0.5f);
    private final iIiiIIiII_Class357 i_field_cb35e4c = new iIiiIIiII_Class357(false).I_method_cc37aab5().I_method_7d3fafd7(1.0f);
    private boolean i_field_5a = false;
    private final iIiiI_Class23 I_field_6433b52c = iIiiI_Class23.I_method_e3b16f5();
    private final boolean[] I_field_b5f = new boolean[2];
    private final boolean[] i_field_b5f = new boolean[2];
    private final float[] I_field_b4b = new float[]{0.5f, 0.5f};
    private final float[] i_field_b4b = new float[]{0.5f, 0.5f};
    private final IiIIIiII_Class69<Render3DEvent> I_field_3d936f41 = render3DEvent -> {
        boolean bl;
        Arrays.fill(this.I_field_b5f, false);
        Arrays.fill(this.i_field_b5f, false);
        this.i_field_5a = false;
        boolean bl2 = bl = Iiiiiiii_Class128.I_field_3a9bda27.options != null && Iiiiiiii_Class128.I_field_3a9bda27.options.getPerspective() != null && Iiiiiiii_Class128.I_field_3a9bda27.options.getPerspective().isFirstPerson();
        if (!this.i_method_6c6ff6d1(IiiiIiii_Class120.I_field_10f66741) || !bl) {
            return;
        }
        if (this.I_field_bbe33e6c.i_method_f85f3850() == this.I_field_500d0627) {
            this.i_method_a9c2f08c();
        }
    };
    private final IiIIIiII_Class69<PreHudRenderEvent> i_field_3d936f41 = preHudRenderEvent -> {
        if (!this.i_method_6c6ff6d1(IiiiIiii_Class120.I_field_10f66741)) {
            return;
        }
        boolean bl = this.I_field_bbe33e6c.i_method_f85f3850() == this.i_field_500d0627;
        for (int i = 0; i < 2; ++i) {
            if (!this.I_field_b5f[i]) continue;
            IiiiiIii_Class124.I_method_a75705ba(this.I_field_a700fd11[i]);
            if (bl) {
                this.i_method_8e9b93f7(i);
                continue;
            }
            this.I_method_8cd8a3d7(i);
        }
    };

    public Iiiiiiii_Class128() {
        super("fill", new IiiiIiii_Class120[]{IiiiIiii_Class120.I_field_10f66741}, IiiiiIiI_Class123.Ii_field_12aac7a1);
        this.I_field_500d0627.select();
        this.II_field_500d0627.select();
        for (iIiiIIiII_Class357 iIiiIIiII_Class3572 : this.I_field_a700fd11) {
            iIiiIIiII_Class3572.setClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        }
        this.I_field_6433b52c.I_method_716dedf();
        this.I_field_6433b52c.i_method_dd886024(1);
        this.I_field_6433b52c.I_method_dbc564c1(2.0f);
    }

    public ColorRGBA I_method_72aa1b1b() {
        return this.i_field_ba20ca4c.i_method_9b12da03() ? IiiiiIIIi_Class242.i_method_5dfec6e() : this.I_field_bbd4b66c.I_method_bde5f08e();
    }

    public boolean i_method_a9c2f090() {
        return false;
    }

    public void I_method_38a5a769(HeldItemRenderer heldItemRenderer, AbstractClientPlayerEntity abstractClientPlayerEntity, ItemStack itemStack, ModelTransformationMode modelTransformationMode, boolean bl, MatrixStack matrixStack, int n) {
        if (!this.i_method_6c6ff6d1(IiiiIiii_Class120.I_field_10f66741)) {
            return;
        }
        if (itemStack == null || itemStack.isEmpty()) {
            return;
        }
        int n2 = this.I_method_8cd8e39b(bl);
        this.I_method_afd6bcc9(n2, matrixStack);
        I_field_5a = true;
        iIiiIIiII_Class357 iIiiIIiII_Class3572 = this.I_method_3b0fb28d(n2);
        VertexConsumerProvider.Immediate immediate = I_field_3a9bda27.getBufferBuilders().getEntityVertexConsumers();
        try {
            heldItemRenderer.renderItem((LivingEntity)abstractClientPlayerEntity, itemStack, modelTransformationMode, bl, matrixStack, (VertexConsumerProvider)immediate, 0xF000F0);
            immediate.draw();
            this.I_field_b5f[n2] = true;
        }
        catch (Exception exception) {
            // empty catch block
        }
        iIiiIIiII_Class3572.i_method_766109df();
        I_field_5a = false;
    }

    public void I_method_e9752c76(BlockRenderManager blockRenderManager, BlockState blockState, MatrixStack matrixStack, int n) {
        if (!this.i_method_6c6ff6d1(IiiiIiii_Class120.I_field_10f66741)) {
            return;
        }
        if (blockState == null) {
            return;
        }
        int n2 = this.I_method_8cd8e39b(IiiiiIii_Class124.II_field_5a);
        this.I_method_afd6bcc9(n2, matrixStack);
        I_field_5a = true;
        iIiiIIiII_Class357 iIiiIIiII_Class3572 = this.I_method_3b0fb28d(n2);
        VertexConsumerProvider.Immediate immediate = I_field_3a9bda27.getBufferBuilders().getEntityVertexConsumers();
        try {
            blockRenderManager.renderBlockAsEntity(blockState, matrixStack, (VertexConsumerProvider)immediate, 0xF000F0, n);
            immediate.draw();
            this.I_field_b5f[n2] = true;
        }
        catch (Exception exception) {
            // empty catch block
        }
        iIiiIIiII_Class3572.i_method_766109df();
        I_field_5a = false;
    }

    private int I_method_8cd8e39b(boolean bl) {
        return this.I_field_bbe33e6c.i_method_f85f3850() == this.i_field_500d0627 && bl ? 1 : 0;
    }

    private iIiiIIiII_Class357 I_method_3b0fb28d(int n) {
        iIiiIIiII_Class357 iIiiIIiII_Class3572 = this.I_field_a700fd11[n];
        iIiiIIiII_Class3572.I_method_53fdf4b5(!this.i_field_b5f[n]);
        this.i_field_b5f[n] = true;
        return iIiiIIiII_Class3572;
    }

    private void I_method_afd6bcc9(int n, MatrixStack matrixStack) {
        try {
            Matrix4f matrix4f = new Matrix4f((Matrix4fc)RenderSystem.getProjectionMatrix()).mul((Matrix4fc)RenderSystem.getModelViewMatrix()).mul((Matrix4fc)matrixStack.peek().getPositionMatrix());
            Vector4f vector4f = new Vector4f(0.0f, 0.0f, 0.0f, 1.0f);
            matrix4f.transform(vector4f);
            if (vector4f.w > 1.0E-4f) {
                this.I_field_b4b[n] = vector4f.x / vector4f.w * 0.5f + 0.5f;
                this.i_field_b4b[n] = vector4f.y / vector4f.w * 0.5f + 0.5f;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private void I_method_8cd8a3d7(int n) {
        int n2;
        float f = Iiiiiiii_Class128.I_method_8cd89884(this.I_field_73178e8c.Ii_method_a20abcd2() / 100.0f);
        if (f <= 0.001f) {
            return;
        }
        int n3 = this.i_field_5a ? this.i_field_cb35e4c.getColorAttachment() : I_field_3a9bda27.getFramebuffer().getColorAttachment();
        int n4 = (int)this.i_field_73178e8c.Ii_method_a20abcd2();
        if (n4 > 0) {
            this.II_method_ffe516e(n3);
            this.I_field_6433b52c.I_method_dbc57004(n4);
            this.I_field_6433b52c.i_method_c0dc3e7(this.I_field_cb35e4c);
            n2 = this.I_field_6433b52c.i_method_7256ab2();
            if (n2 == 0) {
                n2 = n3;
            }
        } else {
            n2 = n3;
        }
        this.I_method_e3c4a0c(n, n2);
        ColorRGBA colorRGBA = this.I_method_72aa1b1b();
        float f2 = colorRGBA.getRed() / 255.0f * 2.4f;
        float f3 = colorRGBA.getGreen() / 255.0f * 2.4f;
        float f4 = colorRGBA.getBlue() / 255.0f * 2.4f;
        this.I_method_9660d057(this.I_field_a700fd11[n].getColorAttachment(), f2, f3, f4, f);
    }

    private void i_method_8e9b93f7(int n) {
        float f = Iiiiiiii_Class128.I_method_8cd89884(this.iI_field_73178e8c.Ii_method_a20abcd2() / 100.0f);
        if (f <= 0.001f) {
            return;
        }
        ModeSetting.Nested1_42765c60 nested1_42765c60 = this.i_field_bbe33e6c.i_method_f85f3850();
        iiIIi_Class26 iiIRockstarClient62 = nested1_42765c60 == this.Ii_field_500d0627 ? iIiiIIiii_Class360.i_field_65e7a52c : (nested1_42765c60 == this.iI_field_500d0627 ? iIiiIIiii_Class360.II_field_65e7a52c : iIiiIIiii_Class360.I_field_65e7a52c);
        if (iiIRockstarClient62 == null) {
            return;
        }
        float f2 = this.Ii_field_73178e8c.Ii_method_a20abcd2();
        float f3 = (float)((double)(System.currentTimeMillis() % 1000000L) / 1000.0 * (double)f2);
        ColorRGBA colorRGBA = this.I_method_72aa1b1b();
        iiIRockstarClient62.I_method_33f6c16b();
        iiIRockstarClient62.I_method_86be3e5e(f3, colorRGBA, this.I_field_b4b[n], this.i_field_b4b[n]);
        RenderSystem.disableDepthTest();
        RenderSystem.disableCull();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderTexture((int)0, (int)this.I_field_a700fd11[n].getColorAttachment());
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)f);
        iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, I_field_587075c2.getScaledWidth(), I_field_587075c2.getScaledHeight());
        RenderSystem.setShaderTexture((int)0, (int)0);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderSystem.disableBlend();
        RenderSystem.enableCull();
    }

    private void I_method_9660d057(int n, float f, float f2, float f3, float f4) {
        RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_TEX_COLOR);
        RenderSystem.disableDepthTest();
        RenderSystem.disableCull();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderTexture((int)0, (int)n);
        RenderSystem.setShaderColor((float)f, (float)f2, (float)f3, (float)f4);
        iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, I_field_587075c2.getScaledWidth(), I_field_587075c2.getScaledHeight());
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderSystem.setShaderTexture((int)0, (int)0);
        RenderSystem.disableBlend();
        RenderSystem.enableCull();
    }

    private void II_method_ffe516e(int n) {
        this.I_field_cb35e4c.I_method_53fdf4b5(true);
        RenderSystem.disableBlend();
        RenderSystem.disableDepthTest();
        RenderSystem.disableCull();
        RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_TEX_COLOR);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderSystem.setShaderTexture((int)0, (int)n);
        iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, I_field_587075c2.getScaledWidth(), I_field_587075c2.getScaledHeight());
        RenderSystem.setShaderTexture((int)0, (int)0);
        this.I_field_cb35e4c.i_method_766109df();
    }

    private void i_method_a9c2f08c() {
        Framebuffer framebuffer = I_field_3a9bda27.getFramebuffer();
        if (framebuffer == null) {
            return;
        }
        int n = I_field_587075c2.getScaledWidth();
        int n2 = I_field_587075c2.getScaledHeight();
        RenderSystem.backupProjectionMatrix();
        Matrix4f matrix4f = new Matrix4f().setOrtho(0.0f, (float)n, (float)n2, 0.0f, 1000.0f, 21000.0f);
        RenderSystem.setProjectionMatrix((Matrix4f)matrix4f, (ProjectionType)ProjectionType.ORTHOGRAPHIC);
        Matrix4fStack matrix4fStack = RenderSystem.getModelViewStack();
        matrix4fStack.pushMatrix();
        matrix4fStack.identity().translate(0.0f, 0.0f, -11000.0f);
        this.i_field_cb35e4c.I_method_53fdf4b5(true);
        RenderSystem.disableBlend();
        RenderSystem.disableDepthTest();
        RenderSystem.disableCull();
        RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_TEX_COLOR);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderSystem.setShaderTexture((int)0, (int)framebuffer.getColorAttachment());
        iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, n, n2);
        RenderSystem.setShaderTexture((int)0, (int)0);
        this.i_field_cb35e4c.i_method_766109df();
        matrix4fStack.popMatrix();
        RenderSystem.restoreProjectionMatrix();
        this.i_field_5a = true;
    }

    private void I_method_e3c4a0c(int n, int n2) {
        this.I_field_a700fd11[n].beginWrite(true);
        RenderSystem.enableBlend();
        boolean bl = this.II_field_ba20ca4c.i_method_9b12da03();
        if (bl) {
            GlStateManager._blendFuncSeparate((int)772, (int)0, (int)0, (int)1);
        } else {
            GlStateManager._blendFuncSeparate((int)774, (int)0, (int)0, (int)1);
        }
        RenderSystem.disableDepthTest();
        RenderSystem.disableCull();
        if (!bl && iIiiIIiii_Class360.I_field_65f6310c != null) {
            iIiiIIiii_Class360.I_field_65f6310c.I_method_33f6c16b();
            iIiiIIiii_Class360.I_field_65f6310c.I_method_59554e1(Iiiiiiii_Class128.I_method_8cd89884(this.II_field_73178e8c.Ii_method_a20abcd2() / 100.0f));
        } else {
            RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_TEX_COLOR);
        }
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderSystem.setShaderTexture((int)0, (int)n2);
        float f = I_field_587075c2.getScaledWidth();
        float f2 = I_field_587075c2.getScaledHeight();
        BufferBuilder bufferBuilder = Tessellator.getInstance().begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
        bufferBuilder.vertex(0.0f, 0.0f, 0.0f).texture(1.0f, 1.0f).color(-1);
        bufferBuilder.vertex(0.0f, f2, 0.0f).texture(1.0f, 0.0f).color(-1);
        bufferBuilder.vertex(f, f2, 0.0f).texture(0.0f, 0.0f).color(-1);
        bufferBuilder.vertex(f, 0.0f, 0.0f).texture(0.0f, 1.0f).color(-1);
        BufferRenderer.drawWithGlobalProgram((BuiltBuffer)bufferBuilder.end());
        RenderSystem.setShaderTexture((int)0, (int)0);
        RenderSystem.defaultBlendFunc();
        I_field_3a9bda27.getFramebuffer().beginWrite(true);
    }

    private static float I_method_8cd89884(float f) {
        return f < 0.0f ? 0.0f : (f > 1.0f ? 1.0f : f);
    }

    @Generated
    public BooleanSetting I_method_d69bcf22() {
        return this.I_field_ba20ca4c;
    }

    @Generated
    public ModeSetting I_method_d85e4342() {
        return this.I_field_bbe33e6c;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 I_method_39da2d7d() {
        return this.I_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 i_method_3fe2295d() {
        return this.i_field_500d0627;
    }

    @Generated
    public BooleanSetting i_method_ec314302() {
        return this.i_field_ba20ca4c;
    }

    @Generated
    public ColorSetting I_method_d84fbb42() {
        return this.I_field_bbd4b66c;
    }

    @Generated
    public BooleanSetting II_method_ab72c96b() {
        return this.II_field_ba20ca4c;
    }

    @Generated
    public SliderSetting I_method_8f929362() {
        return this.I_field_73178e8c;
    }

    @Generated
    public SliderSetting i_method_a5280742() {
        return this.i_field_73178e8c;
    }

    @Generated
    public SliderSetting II_method_64698dab() {
        return this.II_field_73178e8c;
    }

    @Generated
    public ModeSetting i_method_edf3b722() {
        return this.i_field_bbe33e6c;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 II_method_34dbb986() {
        return this.II_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 Ii_method_3ae3b566() {
        return this.Ii_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 iI_method_efd339a6() {
        return this.iI_field_500d0627;
    }

    @Generated
    public SliderSetting Ii_method_79ff018b() {
        return this.Ii_field_73178e8c;
    }

    @Generated
    public SliderSetting iI_method_18295cb() {
        return this.iI_field_73178e8c;
    }

    @Generated
    public iIiiIIiII_Class357[] I_method_19e692fb() {
        return this.I_field_a700fd11;
    }

    @Generated
    public iIiiIIiII_Class357 I_method_292e6322() {
        return this.I_field_cb35e4c;
    }

    @Generated
    public iIiiIIiII_Class357 i_method_3ec3d702() {
        return this.i_field_cb35e4c;
    }

    @Generated
    public boolean II_method_8ce72839() {
        return this.i_field_5a;
    }

    @Generated
    public iIiiI_Class23 I_method_5b6e9502() {
        return this.I_field_6433b52c;
    }

    @Generated
    public boolean[] I_method_8cd831c9() {
        return this.I_field_b5f;
    }

    @Generated
    public boolean[] i_method_8e9b21e9() {
        return this.i_field_b5f;
    }

    @Generated
    public float[] I_method_8cd831b5() {
        return this.I_field_b4b;
    }

    @Generated
    public float[] i_method_8e9b21d5() {
        return this.i_field_b4b;
    }

    @Generated
    public IiIIIiII_Class69<Render3DEvent> I_method_a9d977ab() {
        return this.I_field_3d936f41;
    }

    @Generated
    public IiIIIiII_Class69<PreHudRenderEvent> i_method_d3d607cb() {
        return this.i_field_3d936f41;
    }
}

