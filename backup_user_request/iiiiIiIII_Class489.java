package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderProgramKey;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import pyrock.events.render.Render3DEvent;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.iiIiIiIII_Class425;
import rockstar.client.iiIiiIiIi_Class438;
import rockstar.client.iiiIIiIIi_Class458;
import rockstar.client.iiiIIiIiI_Class459;

public final class iiiiIiIII_Class489 {
    private static final int I_field_49 = 0x66FF66;
    private static final float I_field_46 = 0.9f;
    private static final float i_field_46 = 0.01f;
    private final IiIIIiII_Class69<Render3DEvent> I_field_3d936f41 = render3DEvent -> this.I_method_7a083ad2(render3DEvent.getMatrices(), render3DEvent.getCamera());

    public static iiiiIiIII_Class489 I_method_9d54db5d(iiIiiIiIi_Class438 iiIiiIiIi_Class4382) {
        iiiiIiIII_Class489 iiiiIiIII_Class4892 = new iiiiIiIII_Class489();
        iiIiiIiIi_Class4382.I_method_ab199998().I_method_2257cd48(iiiiIiIII_Class4892);
        return iiiiIiIII_Class4892;
    }

    private void I_method_7a083ad2(MatrixStack matrixStack, Camera camera) {
        if (!iiIiIiIII_Class425.i_field_5a) {
            return;
        }
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.player == null || minecraftClient.world == null) {
            return;
        }
        iiiIIiIIi_Class458 iiiIIiIIi_Class4582 = iiiIIiIiI_Class459.i_method_589faf3c(minecraftClient);
        if (iiiIIiIIi_Class4582 == null) {
            return;
        }
        Vec3d vec3d = camera.getPos();
        double d = (float)iiiIIiIIi_Class4582.I_method_6d204e12() + 0.01f;
        double d2 = (float)iiiIIiIIi_Class4582.i_method_6d2ed9f2() + 0.01f;
        double d3 = (float)iiiIIiIIi_Class4582.II_method_36f86d15() + 0.01f;
        double d4 = (float)(iiiIIiIIi_Class4582.I_method_6d204e12() + 1) - 0.01f;
        double d5 = (float)(iiiIIiIIi_Class4582.i_method_6d2ed9f2() + 1) - 0.01f;
        double d6 = (float)(iiiIIiIIi_Class4582.II_method_36f86d15() + 1) - 0.01f;
        RenderSystem.enableBlend();
        RenderSystem.disableDepthTest();
        RenderSystem.disableCull();
        RenderSystem.blendFunc((GlStateManager.SrcFactor)GlStateManager.SrcFactor.SRC_ALPHA, (GlStateManager.DstFactor)GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA);
        RenderSystem.lineWidth((float)2.0f);
        RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_COLOR);
        BufferBuilder bufferBuilder = RenderSystem.renderThreadTesselator().begin(VertexFormat.DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
        matrixStack.push();
        matrixStack.translate(-vec3d.x, -vec3d.y, -vec3d.z);
        Matrix4f matrix4f = matrixStack.peek().getPositionMatrix();
        int n = -446234778;
        iiiiIiIII_Class489.I_method_32060185(bufferBuilder, matrix4f, d, d2, d3, d4, d2, d3, n);
        iiiiIiIII_Class489.I_method_32060185(bufferBuilder, matrix4f, d4, d2, d3, d4, d2, d6, n);
        iiiiIiIII_Class489.I_method_32060185(bufferBuilder, matrix4f, d4, d2, d6, d, d2, d6, n);
        iiiiIiIII_Class489.I_method_32060185(bufferBuilder, matrix4f, d, d2, d6, d, d2, d3, n);
        iiiiIiIII_Class489.I_method_32060185(bufferBuilder, matrix4f, d, d5, d3, d4, d5, d3, n);
        iiiiIiIII_Class489.I_method_32060185(bufferBuilder, matrix4f, d4, d5, d3, d4, d5, d6, n);
        iiiiIiIII_Class489.I_method_32060185(bufferBuilder, matrix4f, d4, d5, d6, d, d5, d6, n);
        iiiiIiIII_Class489.I_method_32060185(bufferBuilder, matrix4f, d, d5, d6, d, d5, d3, n);
        iiiiIiIII_Class489.I_method_32060185(bufferBuilder, matrix4f, d, d2, d3, d, d5, d3, n);
        iiiiIiIII_Class489.I_method_32060185(bufferBuilder, matrix4f, d4, d2, d3, d4, d5, d3, n);
        iiiiIiIII_Class489.I_method_32060185(bufferBuilder, matrix4f, d4, d2, d6, d4, d5, d6, n);
        iiiiIiIII_Class489.I_method_32060185(bufferBuilder, matrix4f, d, d2, d6, d, d5, d6, n);
        matrixStack.pop();
        BufferRenderer.drawWithGlobalProgram((BuiltBuffer)bufferBuilder.end());
        RenderSystem.lineWidth((float)1.0f);
        RenderSystem.enableCull();
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
    }

    private static void I_method_32060185(BufferBuilder bufferBuilder, Matrix4f matrix4f, double d, double d2, double d3, double d4, double d5, double d6, int n) {
        bufferBuilder.vertex(matrix4f, (float)d, (float)d2, (float)d3).color(n);
        bufferBuilder.vertex(matrix4f, (float)d4, (float)d5, (float)d6).color(n);
    }
}

