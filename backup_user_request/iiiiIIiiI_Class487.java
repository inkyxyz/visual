package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import lombok.Generated;
import net.minecraft.client.gl.ShaderProgramKey;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import pyrock.utility.render.ColorRGBA;

public final class iiiiIIiiI_Class487 {
    private static void I_method_e37ab63f() {
        RenderSystem.enableBlend();
        RenderSystem.disableDepthTest();
        RenderSystem.disableCull();
        RenderSystem.blendFunc((GlStateManager.SrcFactor)GlStateManager.SrcFactor.SRC_ALPHA, (GlStateManager.DstFactor)GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA);
        RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_COLOR);
    }

    private static void i_method_e389421f() {
        RenderSystem.enableCull();
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
    }

    public static void I_method_cba2798c(MatrixStack matrixStack, Box box, ColorRGBA colorRGBA) {
        iiiiIIiiI_Class487.I_method_e37ab63f();
        BufferBuilder bufferBuilder = Tessellator.getInstance().begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR);
        iiiiIIiiI_Class487.I_method_f92baf39(matrixStack, bufferBuilder, box, colorRGBA);
        BufferRenderer.drawWithGlobalProgram((BuiltBuffer)bufferBuilder.end());
        iiiiIIiiI_Class487.i_method_e389421f();
    }

    public static void i_method_db052d6c(MatrixStack matrixStack, Box box, ColorRGBA colorRGBA) {
        iiiiIIiiI_Class487.I_method_e37ab63f();
        BufferBuilder bufferBuilder = Tessellator.getInstance().begin(VertexFormat.DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
        iiiiIIiiI_Class487.i_method_bd134f59(matrixStack, bufferBuilder, box, colorRGBA);
        BufferRenderer.drawWithGlobalProgram((BuiltBuffer)bufferBuilder.end());
        iiiiIIiiI_Class487.i_method_e389421f();
    }

    public static void I_method_3c71766e(MatrixStack matrixStack, Vec3d vec3d, Vec3d vec3d2, ColorRGBA colorRGBA) {
        iiiiIIiiI_Class487.I_method_e37ab63f();
        BufferBuilder bufferBuilder = Tessellator.getInstance().begin(VertexFormat.DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
        Matrix4f matrix4f = matrixStack.peek().getPositionMatrix();
        float f = colorRGBA.getRed() / 255.0f;
        float f2 = colorRGBA.getGreen() / 255.0f;
        float f3 = colorRGBA.getBlue() / 255.0f;
        float f4 = colorRGBA.getAlpha() / 255.0f;
        bufferBuilder.vertex(matrix4f, (float)vec3d.x, (float)vec3d.y, (float)vec3d.z).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, (float)vec3d2.x, (float)vec3d2.y, (float)vec3d2.z).color(f, f2, f3, f4);
        BufferRenderer.drawWithGlobalProgram((BuiltBuffer)bufferBuilder.end());
        iiiiIIiiI_Class487.i_method_e389421f();
    }

    private static void I_method_f92baf39(MatrixStack matrixStack, BufferBuilder bufferBuilder, Box box, ColorRGBA colorRGBA) {
        float f = colorRGBA.getRed() / 255.0f;
        float f2 = colorRGBA.getGreen() / 255.0f;
        float f3 = colorRGBA.getBlue() / 255.0f;
        float f4 = colorRGBA.getAlpha() / 255.0f;
        float f5 = (float)box.minX;
        float f6 = (float)box.minY;
        float f7 = (float)box.minZ;
        float f8 = (float)box.maxX;
        float f9 = (float)box.maxY;
        float f10 = (float)box.maxZ;
        Matrix4f matrix4f = matrixStack.peek().getPositionMatrix();
        bufferBuilder.vertex(matrix4f, f5, f6, f7).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f8, f6, f7).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f8, f6, f10).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f5, f6, f10).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f5, f9, f7).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f8, f9, f7).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f8, f9, f10).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f5, f9, f10).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f5, f6, f10).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f8, f6, f10).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f8, f9, f10).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f5, f9, f10).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f5, f6, f7).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f8, f6, f7).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f8, f9, f7).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f5, f9, f7).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f5, f6, f7).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f5, f6, f10).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f5, f9, f10).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f5, f9, f7).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f8, f6, f7).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f8, f6, f10).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f8, f9, f10).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f8, f9, f7).color(f, f2, f3, f4);
    }

    private static void i_method_bd134f59(MatrixStack matrixStack, BufferBuilder bufferBuilder, Box box, ColorRGBA colorRGBA) {
        float f = colorRGBA.getRed() / 255.0f;
        float f2 = colorRGBA.getGreen() / 255.0f;
        float f3 = colorRGBA.getBlue() / 255.0f;
        float f4 = colorRGBA.getAlpha() / 255.0f;
        float f5 = (float)box.minX;
        float f6 = (float)box.minY;
        float f7 = (float)box.minZ;
        float f8 = (float)box.maxX;
        float f9 = (float)box.maxY;
        float f10 = (float)box.maxZ;
        Matrix4f matrix4f = matrixStack.peek().getPositionMatrix();
        bufferBuilder.vertex(matrix4f, f5, f6, f7).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f8, f6, f7).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f8, f6, f7).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f8, f6, f10).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f8, f6, f10).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f5, f6, f10).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f5, f6, f10).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f5, f6, f7).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f5, f9, f7).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f8, f9, f7).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f8, f9, f7).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f8, f9, f10).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f8, f9, f10).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f5, f9, f10).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f5, f9, f10).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f5, f9, f7).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f5, f6, f7).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f5, f9, f7).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f8, f6, f7).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f8, f9, f7).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f8, f6, f10).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f8, f9, f10).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f5, f6, f10).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f5, f9, f10).color(f, f2, f3, f4);
    }

    @Generated
    private iiiiIIiiI_Class487() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

