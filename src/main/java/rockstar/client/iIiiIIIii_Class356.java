package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import lombok.Generated;
import net.minecraft.client.gl.ShaderProgramKey;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import pyrock.utility.render.ColorRGBA;

public final class iIiiIIIii_Class356 {
    private static final Vector3f[] I_field_ba5aacb6 = new Vector3f[]{new Vector3f(0.0f, 1.5f, 0.0f), new Vector3f(0.0f, -1.5f, 0.0f), new Vector3f(1.0f, 0.0f, 0.0f), new Vector3f(-1.0f, 0.0f, 0.0f), new Vector3f(0.0f, 0.0f, 1.0f), new Vector3f(0.0f, 0.0f, -1.0f)};
    private static final int[][] I_field_160e9 = new int[][]{{0, 2, 4}, {0, 4, 3}, {0, 3, 5}, {0, 5, 2}, {1, 4, 2}, {1, 3, 4}, {1, 5, 3}, {1, 2, 5}};
    private static final float[] I_field_b4b = new float[]{1.0f, 0.8f, 0.6f, 0.9f, 0.7f, 0.5f, 0.4f, 0.6f};

    public static void I_method_8d941781(MatrixStack matrixStack, BufferBuilder bufferBuilder, float f, float f2, float f3, float f4, ColorRGBA colorRGBA) {
        matrixStack.push();
        matrixStack.translate(f, f2, f3);
        matrixStack.scale(f4, f4, f4);
        Matrix4f matrix4f = matrixStack.peek().getPositionMatrix();
        for (int i = 0; i < I_field_160e9.length; ++i) {
            int[] nArray = I_field_160e9[i];
            float f5 = I_field_b4b[i];
            Vector3f vector3f = I_field_ba5aacb6[nArray[0]];
            Vector3f vector3f2 = I_field_ba5aacb6[nArray[1]];
            Vector3f vector3f3 = I_field_ba5aacb6[nArray[2]];
            int n = iIiiIIIii_Class356.I_method_273ea76f(colorRGBA.getRGB(), f5);
            bufferBuilder.vertex(matrix4f, vector3f.x, vector3f.y, vector3f.z).color(n);
            bufferBuilder.vertex(matrix4f, vector3f2.x, vector3f2.y, vector3f2.z).color(n);
            bufferBuilder.vertex(matrix4f, vector3f3.x, vector3f3.y, vector3f3.z).color(n);
        }
        matrixStack.pop();
    }

    public static BufferBuilder I_method_c596047e() {
        iIiiIIIii_Class356.I_method_4d8f5e1f();
        return Tessellator.getInstance().begin(VertexFormat.DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
    }

    private static void I_method_4d8f5e1f() {
        RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_COLOR);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    private static int I_method_273ea76f(int n, float f) {
        int n2 = n >> 24 & 0xFF;
        int n3 = (int)((float)(n >> 16 & 0xFF) * f);
        int n4 = (int)((float)(n >> 8 & 0xFF) * f);
        int n5 = (int)((float)(n & 0xFF) * f);
        n3 = Math.min(255, Math.max(0, n3));
        n4 = Math.min(255, Math.max(0, n4));
        n5 = Math.min(255, Math.max(0, n5));
        return n2 << 24 | n3 << 16 | n4 << 8 | n5;
    }

    @Generated
    private iIiiIIIii_Class356() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

