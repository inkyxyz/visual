package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import lombok.Generated;
import net.minecraft.client.gl.ShaderProgramKey;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.iIIiIIiIi_Class294;

public final class iIiiIIiIi_Class358
implements iIIiIIiIi_Class294 {
    public static void I_method_9a4e5799(MatrixStack matrixStack, BufferBuilder bufferBuilder, Box box, ColorRGBA colorRGBA) {
        float f = colorRGBA.getRed();
        float f2 = colorRGBA.getGreen();
        float f3 = colorRGBA.getBlue();
        float f4 = colorRGBA.getAlpha();
        RenderSystem.enableBlend();
        RenderSystem.disableDepthTest();
        RenderSystem.disableCull();
        RenderSystem.blendFunc((GlStateManager.SrcFactor)GlStateManager.SrcFactor.SRC_ALPHA, (GlStateManager.DstFactor)GlStateManager.DstFactor.ONE);
        RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_COLOR);
        int n = 3;
        float f5 = 0.1f;
        for (int i = n; i >= 1; --i) {
            float f6 = (float)i * f5;
            float f7 = f4 * (0.15f / (float)i);
            iIiiIIiIi_Class358.i_method_5e35f7b9(matrixStack, bufferBuilder, box.expand((double)f6), new ColorRGBA(f, f2, f3, f7));
        }
        iIiiIIiIi_Class358.i_method_5e35f7b9(matrixStack, bufferBuilder, box, new ColorRGBA(f, f2, f3, f4));
        RenderSystem.enableCull();
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
    }

    public static void i_method_5e35f7b9(MatrixStack matrixStack, BufferBuilder bufferBuilder, Box box, ColorRGBA colorRGBA) {
        float f = colorRGBA.getRed() / 255.0f;
        float f2 = colorRGBA.getGreen() / 255.0f;
        float f3 = colorRGBA.getBlue() / 255.0f;
        float f4 = colorRGBA.getAlpha() / 255.0f;
        iIiiIIiIi_Class358.I_method_724840a6(matrixStack, bufferBuilder, box, f, f2, f3, f4);
    }

    public static void II_method_fde357f6(MatrixStack matrixStack, BufferBuilder bufferBuilder, Box box, ColorRGBA colorRGBA) {
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
        bufferBuilder.vertex(matrix4f, f8, f9, f10).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f8, f6, f7).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f5, f9, f10).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f5, f6, f10).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f8, f9, f7).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f8, f6, f10).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f5, f9, f7).color(f, f2, f3, f4);
    }

    public static void I_method_724840a6(MatrixStack matrixStack, BufferBuilder bufferBuilder, Box box, float f, float f2, float f3, float f4) {
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

    public static void I_method_b5d61e06(MatrixStack matrixStack, BufferBuilder bufferBuilder, Box box, ColorRGBA colorRGBA, ColorRGBA colorRGBA2) {
        float f = colorRGBA.getRed() / 255.0f;
        float f2 = colorRGBA.getGreen() / 255.0f;
        float f3 = colorRGBA.getBlue() / 255.0f;
        float f4 = colorRGBA.getAlpha() / 255.0f;
        float f5 = colorRGBA2.getRed() / 255.0f;
        float f6 = colorRGBA2.getGreen() / 255.0f;
        float f7 = colorRGBA2.getBlue() / 255.0f;
        float f8 = colorRGBA2.getAlpha() / 255.0f;
        float f9 = (float)box.minX;
        float f10 = (float)box.minY;
        float f11 = (float)box.minZ;
        float f12 = (float)box.maxX;
        float f13 = (float)box.maxY;
        float f14 = (float)box.maxZ;
        Matrix4f matrix4f = matrixStack.peek().getPositionMatrix();
        bufferBuilder.vertex(matrix4f, f9, f10, f11).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f12, f10, f11).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f12, f10, f14).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f9, f10, f14).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f9, f13, f11).color(f5, f6, f7, f8);
        bufferBuilder.vertex(matrix4f, f12, f13, f11).color(f5, f6, f7, f8);
        bufferBuilder.vertex(matrix4f, f12, f13, f14).color(f5, f6, f7, f8);
        bufferBuilder.vertex(matrix4f, f9, f13, f14).color(f5, f6, f7, f8);
        bufferBuilder.vertex(matrix4f, f9, f10, f14).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f12, f10, f14).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f12, f13, f14).color(f5, f6, f7, f8);
        bufferBuilder.vertex(matrix4f, f9, f13, f14).color(f5, f6, f7, f8);
        bufferBuilder.vertex(matrix4f, f9, f10, f11).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f12, f10, f11).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f12, f13, f11).color(f5, f6, f7, f8);
        bufferBuilder.vertex(matrix4f, f9, f13, f11).color(f5, f6, f7, f8);
        bufferBuilder.vertex(matrix4f, f9, f10, f11).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f9, f10, f14).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f9, f13, f14).color(f5, f6, f7, f8);
        bufferBuilder.vertex(matrix4f, f9, f13, f11).color(f5, f6, f7, f8);
        bufferBuilder.vertex(matrix4f, f12, f10, f11).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f12, f10, f14).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f12, f13, f14).color(f5, f6, f7, f8);
        bufferBuilder.vertex(matrix4f, f12, f13, f11).color(f5, f6, f7, f8);
    }

    public static void i_method_c95b01e6(MatrixStack matrixStack, BufferBuilder bufferBuilder, Box box, ColorRGBA colorRGBA, ColorRGBA colorRGBA2) {
        float f = colorRGBA.getRed() / 255.0f;
        float f2 = colorRGBA.getGreen() / 255.0f;
        float f3 = colorRGBA.getBlue() / 255.0f;
        float f4 = colorRGBA.getAlpha() / 255.0f;
        float f5 = colorRGBA2.getRed() / 255.0f;
        float f6 = colorRGBA2.getGreen() / 255.0f;
        float f7 = colorRGBA2.getBlue() / 255.0f;
        float f8 = colorRGBA2.getAlpha() / 255.0f;
        float f9 = (float)box.minX;
        float f10 = (float)box.minY;
        float f11 = (float)box.minZ;
        float f12 = (float)box.maxX;
        float f13 = (float)box.maxY;
        float f14 = (float)box.maxZ;
        Matrix4f matrix4f = matrixStack.peek().getPositionMatrix();
        bufferBuilder.vertex(matrix4f, f9, f10, f11).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f12, f10, f11).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f12, f10, f11).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f12, f10, f14).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f12, f10, f14).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f9, f10, f14).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f9, f10, f14).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f9, f10, f11).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f9, f13, f11).color(f5, f6, f7, f8);
        bufferBuilder.vertex(matrix4f, f12, f13, f11).color(f5, f6, f7, f8);
        bufferBuilder.vertex(matrix4f, f12, f13, f11).color(f5, f6, f7, f8);
        bufferBuilder.vertex(matrix4f, f12, f13, f14).color(f5, f6, f7, f8);
        bufferBuilder.vertex(matrix4f, f12, f13, f14).color(f5, f6, f7, f8);
        bufferBuilder.vertex(matrix4f, f9, f13, f14).color(f5, f6, f7, f8);
        bufferBuilder.vertex(matrix4f, f9, f13, f14).color(f5, f6, f7, f8);
        bufferBuilder.vertex(matrix4f, f9, f13, f11).color(f5, f6, f7, f8);
        bufferBuilder.vertex(matrix4f, f9, f10, f11).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f9, f13, f11).color(f5, f6, f7, f8);
        bufferBuilder.vertex(matrix4f, f12, f10, f11).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f12, f13, f11).color(f5, f6, f7, f8);
        bufferBuilder.vertex(matrix4f, f12, f10, f14).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f12, f13, f14).color(f5, f6, f7, f8);
        bufferBuilder.vertex(matrix4f, f9, f10, f14).color(f, f2, f3, f4);
        bufferBuilder.vertex(matrix4f, f9, f13, f14).color(f5, f6, f7, f8);
    }

    public static void Ii_method_c1caf816(MatrixStack matrixStack, BufferBuilder bufferBuilder, Box box, ColorRGBA colorRGBA) {
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

    public static void I_method_e94f782(MatrixStack matrixStack, VertexConsumer vertexConsumer, Vec3d vec3d, Vec3d vec3d2, ColorRGBA colorRGBA) {
        MatrixStack.Entry entry = matrixStack.peek();
        Vec3d vec3d3 = vec3d2.subtract(vec3d).normalize();
        Vector3f vector3f = new Vector3f((float)vec3d.x, (float)vec3d.y, (float)vec3d.z);
        vertexConsumer.vertex(entry, vector3f).color(colorRGBA.getRGB()).normal(entry, (float)vec3d3.x, (float)vec3d3.y, (float)vec3d3.z);
        vertexConsumer.vertex(entry, (float)vec3d2.x, (float)vec3d2.y, (float)vec3d2.z).color(colorRGBA.getRGB()).normal(entry, (float)vec3d3.x, (float)vec3d3.y, (float)vec3d3.z);
    }

    public static void I_method_d5d64e01(MatrixStack matrixStack, BufferBuilder bufferBuilder, Vec3d vec3d, Vec3d vec3d2, ColorRGBA colorRGBA) {
        MatrixStack.Entry entry = matrixStack.peek();
        Matrix4f matrix4f = entry.getPositionMatrix();
        Vec3d vec3d3 = vec3d2.subtract(vec3d).normalize();
        bufferBuilder.vertex(matrix4f, (float)vec3d.x, (float)vec3d.y, (float)vec3d.z).color(colorRGBA.getRGB()).normal(entry, (float)vec3d3.x, (float)vec3d3.y, (float)vec3d3.z);
        bufferBuilder.vertex(matrix4f, (float)vec3d2.x, (float)vec3d2.y, (float)vec3d2.z).color(colorRGBA.getRGB()).normal(entry, (float)vec3d3.x, (float)vec3d3.y, (float)vec3d3.z);
    }

    public static void I_method_3f08a433(MatrixStack matrixStack, BufferBuilder bufferBuilder, Vec3d vec3d, ColorRGBA colorRGBA) {
        Camera camera = iIiiIIiIi_Class358.I_field_3a9bda27.gameRenderer.getCamera();
        Vec3d vec3d2 = camera.getPos();
        Vec3d vec3d3 = new Vec3d(0.0, 0.0, 27.0).rotateX((float)(-Math.toRadians(camera.getPitch()))).rotateY((float)(-Math.toRadians(camera.getYaw())));
        Vec3d vec3d4 = vec3d.subtract(vec3d2);
        Vec3d vec3d5 = new Vec3d(vec3d3.getX(), vec3d3.getY(), vec3d3.getZ());
        iIiiIIiIi_Class358.I_method_d5d64e01(matrixStack, bufferBuilder, vec3d5, vec3d4, colorRGBA);
    }

    @Generated
    private iIiiIIiIi_Class358() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

