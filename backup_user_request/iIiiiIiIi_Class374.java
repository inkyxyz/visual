package rockstar.client;

import com.mojang.blaze3d.systems.ProjectionType;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.VertexBuffer;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import net.minecraft.util.TriState;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.IIIIiI_Class3;
import rockstar.client.iIIii_Class20;
import rockstar.client.iIiiIIiII_Class357;

public class iIiiiIiIi_Class374 {
    private static final float I_field_46 = 100.0f;
    private static final int I_field_49 = 3;
    private static final int i_field_49 = 2;
    private static final int II_field_49 = 2048;
    private static final int Ii_field_49 = 1024;
    private static final int iI_field_49 = 12;
    private static final long I_field_4a = 1000L;
    private static VertexBuffer I_field_b81f0491;
    private static iIiiIIiII_Class357 I_field_cb35e4c;
    private static iIIii_Class20 I_field_64252d2c;
    private static int ii_field_49;
    private static long i_field_4a;
    private static final Map<Identifier, RenderLayer> I_field_a567c40b;
    private static final Map<IIIIiI_Class3, RenderLayer> i_field_a567c40b;

    public static void I_method_9f06b7ff(Identifier identifier, ColorRGBA colorRGBA) {
        if (identifier == null || colorRGBA == null) {
            return;
        }
        iIiiiIiIi_Class374.i_method_362a419f();
        RenderSystem.setShaderColor((float)(colorRGBA.getRed() / 255.0f), (float)(colorRGBA.getGreen() / 255.0f), (float)(colorRGBA.getBlue() / 255.0f), (float)(colorRGBA.getAlpha() / 255.0f));
        I_field_b81f0491.draw(I_field_a567c40b.computeIfAbsent(identifier, iIiiiIiIi_Class374::I_method_1a37153f));
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    public static void I_method_9c2060ff(IIIIiI_Class3 iIIIiI_Class3, ColorRGBA colorRGBA, float f, float f2) {
        if (iIIIiI_Class3 == null || colorRGBA == null) {
            return;
        }
        iIiiiIiIi_Class374.i_method_362a419f();
        iIIIiI_Class3.I_method_5f74324b(f, colorRGBA);
        float f3 = Math.max(0.0f, Math.min(1.0f, f2));
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)f3);
        I_field_b81f0491.draw(i_field_a567c40b.computeIfAbsent(iIIIiI_Class3, iIiiiIiIi_Class374::I_method_3e8f587f));
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    public static void I_method_3dd93e98(iIIii_Class20 iIIii_Class202, ColorRGBA colorRGBA, float f, float f2) {
        if (iIIii_Class202 == null || colorRGBA == null) {
            return;
        }
        iIiiiIiIi_Class374.i_method_362a419f();
        iIiiIIiII_Class357 iIiiIIiII_Class3572 = iIiiiIiIi_Class374.I_method_5a26b275();
        long l = System.currentTimeMillis();
        if (I_field_64252d2c != iIIii_Class202 || l - i_field_4a > 1000L) {
            iIiiiIiIi_Class374.I_method_d3bb14a0(iIIii_Class202, iIiiIIiII_Class3572, colorRGBA, f, 0, 12);
            I_field_64252d2c = iIIii_Class202;
            ii_field_49 = 0;
        } else {
            iIiiiIiIi_Class374.I_method_d3bb14a0(iIIii_Class202, iIiiIIiII_Class3572, colorRGBA, f, ii_field_49, ii_field_49 + 1);
            ii_field_49 = (ii_field_49 + 1) % 12;
        }
        i_field_4a = l;
        float f3 = Math.max(0.0f, Math.min(1.0f, f2));
        iIIii_Class202.i_method_d194fdb8().I_method_5f74324b(f, colorRGBA);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)f3);
        RenderSystem.setShaderTexture((int)0, (int)iIiiIIiII_Class3572.getColorAttachment());
        I_field_b81f0491.draw(i_field_a567c40b.computeIfAbsent(iIIii_Class202.i_method_d194fdb8(), iIiiiIiIi_Class374::I_method_3e8f587f));
        RenderSystem.setShaderTexture((int)0, (int)0);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    public static void I_method_aaaff9c0(IIIIiI_Class3 iIIIiI_Class3) {
        if (iIIIiI_Class3 == null) {
            return;
        }
        i_field_a567c40b.put(iIIIiI_Class3, iIiiiIiIi_Class374.I_method_3e8f587f(iIIIiI_Class3));
    }

    public static void I_method_55fe86c7(iIIii_Class20 iIIii_Class202) {
        if (iIIii_Class202 == null) {
            return;
        }
        iIiiiIiIi_Class374.I_method_aaaff9c0(iIIii_Class202.i_method_d194fdb8());
    }

    public static void I_method_361bb5bf() {
        if (I_field_b81f0491 != null && !I_field_b81f0491.isClosed()) {
            I_field_b81f0491.close();
        }
        I_field_b81f0491 = null;
        if (I_field_cb35e4c != null) {
            I_field_cb35e4c.delete();
            I_field_cb35e4c = null;
        }
        I_field_64252d2c = null;
        ii_field_49 = 0;
        i_field_4a = 0L;
        I_field_a567c40b.clear();
        i_field_a567c40b.clear();
    }

    private static iIiiIIiII_Class357 I_method_5a26b275() {
        if (I_field_cb35e4c == null) {
            iIiiIIiII_Class357 iIiiIIiII_Class3572 = new iIiiIIiII_Class357(false);
            iIiiIIiII_Class3572.I_method_cc37aab5();
            iIiiIIiII_Class3572.setClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            iIiiIIiII_Class3572.resize(2048, 1024);
            I_field_cb35e4c = iIiiIIiII_Class3572;
            I_field_64252d2c = null;
        }
        return I_field_cb35e4c;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void I_method_d3bb14a0(iIIii_Class20 iIIii_Class202, iIiiIIiII_Class357 iIiiIIiII_Class3572, ColorRGBA colorRGBA, float f, int n, int n2) {
        iIiiIIiII_Class3572.beginWrite(true);
        RenderSystem.backupProjectionMatrix();
        RenderSystem.setProjectionMatrix((Matrix4f)new Matrix4f().setOrtho(0.0f, (float)iIiiIIiII_Class3572.textureWidth, (float)iIiiIIiII_Class3572.textureHeight, 0.0f, 1000.0f, 21000.0f), (ProjectionType)ProjectionType.ORTHOGRAPHIC);
        Matrix4fStack matrix4fStack = RenderSystem.getModelViewStack();
        matrix4fStack.pushMatrix();
        matrix4fStack.identity().translate(0.0f, 0.0f, -11000.0f);
        try {
            RenderSystem.disableBlend();
            RenderSystem.disableDepthTest();
            RenderSystem.depthMask((boolean)false);
            RenderSystem.disableCull();
            iIIii_Class202.I_method_a772e598().I_method_33f6c16b();
            iIIii_Class202.I_method_a772e598().I_method_5f74324b(f, colorRGBA);
            iIiiiIiIi_Class374.I_method_e27a169f(iIiiIIiII_Class3572.textureWidth, iIiiIIiII_Class3572.textureHeight, n, n2);
        }
        finally {
            iIiiIIiII_Class3572.endWrite();
            MinecraftClient.getInstance().getFramebuffer().beginWrite(true);
            RenderSystem.depthMask((boolean)true);
            RenderSystem.enableDepthTest();
            RenderSystem.enableCull();
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            matrix4fStack.popMatrix();
            RenderSystem.restoreProjectionMatrix();
        }
    }

    private static void I_method_e27a169f(float f, float f2, int n, int n2) {
        float f3 = (float)n / 12.0f;
        float f4 = (float)n2 / 12.0f;
        float f5 = (1.0f - f3) * f2;
        float f6 = (1.0f - f4) * f2;
        BufferBuilder bufferBuilder = Tessellator.getInstance().begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
        bufferBuilder.vertex(0.0f, f5, 0.0f).texture(0.0f, f3).color(-1);
        bufferBuilder.vertex(0.0f, f6, 0.0f).texture(0.0f, f4).color(-1);
        bufferBuilder.vertex(f, f6, 0.0f).texture(1.0f, f4).color(-1);
        bufferBuilder.vertex(f, f5, 0.0f).texture(1.0f, f3).color(-1);
        BufferRenderer.drawWithGlobalProgram((BuiltBuffer)bufferBuilder.end());
    }

    private static void i_method_362a419f() {
        if (I_field_b81f0491 == null || I_field_b81f0491.isClosed()) {
            I_field_b81f0491 = VertexBuffer.createAndUpload((VertexFormat.DrawMode)VertexFormat.DrawMode.QUADS, (VertexFormat)VertexFormats.POSITION_TEXTURE_COLOR, iIiiiIiIi_Class374::I_method_86364e8b);
        }
    }

    private static RenderLayer I_method_1a37153f(Identifier identifier) {
        return RenderLayer.of((String)"rockstar_skybox", (VertexFormat)VertexFormats.POSITION_TEXTURE_COLOR, (VertexFormat.DrawMode)VertexFormat.DrawMode.QUADS, (int)1536, (boolean)false, (boolean)false, (RenderLayer.MultiPhaseParameters)RenderLayer.MultiPhaseParameters.builder().program(RenderPhase.POSITION_TEXTURE_COLOR_PROGRAM).texture((RenderPhase.TextureBase)new RenderPhase.Texture(identifier, TriState.FALSE, false)).transparency(RenderPhase.TRANSLUCENT_TRANSPARENCY).cull(RenderPhase.DISABLE_CULLING).writeMaskState(RenderPhase.COLOR_MASK).build(false));
    }

    private static RenderLayer I_method_3e8f587f(IIIIiI_Class3 iIIIiI_Class3) {
        return RenderLayer.of((String)"rockstar_skybox_shader", (VertexFormat)VertexFormats.POSITION_TEXTURE_COLOR, (VertexFormat.DrawMode)VertexFormat.DrawMode.QUADS, (int)1536, (boolean)false, (boolean)false, (RenderLayer.MultiPhaseParameters)RenderLayer.MultiPhaseParameters.builder().program(iIIIiI_Class3.I_method_bbcba39()).transparency(RenderPhase.TRANSLUCENT_TRANSPARENCY).cull(RenderPhase.DISABLE_CULLING).writeMaskState(RenderPhase.COLOR_MASK).build(false));
    }

    private static void I_method_86364e8b(VertexConsumer vertexConsumer) {
        float f = 100.0f;
        iIiiiIiIi_Class374.I_method_cfa5c1d8(vertexConsumer, 1, -f, f, -f, -f, f, f, f, f, f, f, f, -f);
        iIiiiIiIi_Class374.I_method_cfa5c1d8(vertexConsumer, 0, -f, -f, f, -f, -f, -f, f, -f, -f, f, -f, f);
        iIiiiIiIi_Class374.I_method_cfa5c1d8(vertexConsumer, 2, f, f, -f, f, -f, -f, -f, -f, -f, -f, f, -f);
        iIiiiIiIi_Class374.I_method_cfa5c1d8(vertexConsumer, 4, -f, f, f, -f, -f, f, f, -f, f, f, f, f);
        iIiiiIiIi_Class374.I_method_cfa5c1d8(vertexConsumer, 3, -f, f, -f, -f, -f, -f, -f, -f, f, -f, f, f);
        iIiiiIiIi_Class374.I_method_cfa5c1d8(vertexConsumer, 5, f, f, f, f, -f, f, f, -f, -f, f, f, -f);
    }

    private static void I_method_cfa5c1d8(VertexConsumer vertexConsumer, int n, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
        int n2 = n % 3;
        int n3 = n / 3;
        float f13 = (float)n2 / 3.0f;
        float f14 = (float)(n2 + 1) / 3.0f;
        float f15 = (float)n3 / 2.0f;
        float f16 = (float)(n3 + 1) / 2.0f;
        Matrix4f matrix4f = new Matrix4f();
        vertexConsumer.vertex(matrix4f, f, f2, f3).texture(f13, f15).color(-1);
        vertexConsumer.vertex(matrix4f, f4, f5, f6).texture(f13, f16).color(-1);
        vertexConsumer.vertex(matrix4f, f7, f8, f9).texture(f14, f16).color(-1);
        vertexConsumer.vertex(matrix4f, f10, f11, f12).texture(f14, f15).color(-1);
    }

    static {
        I_field_a567c40b = new HashMap<Identifier, RenderLayer>();
        i_field_a567c40b = new IdentityHashMap<IIIIiI_Class3, RenderLayer>();
    }
}

