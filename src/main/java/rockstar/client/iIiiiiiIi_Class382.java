package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gl.ShaderProgram;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import org.joml.Matrix4f;
import rockstar.client.IIiiii_Class16;
import rockstar.client.IiIIIi_Class18;

public final class iIiiiiiIi_Class382 {
    private static BufferBuilder I_field_152af1f5;
    private static boolean I_field_5a;

    public static void I_method_bea995df() {
        if (I_field_5a) {
            return;
        }
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableCull();
        I_field_5a = true;
    }

    private static BufferBuilder I_method_cccd89a0(float f) {
        if (I_field_152af1f5 == null) {
            ShaderProgram shaderProgram = IiIIIi_Class18.I_method_fb4921e0(f);
            shaderProgram.getUniform("EnableFadeout").set(0);
            I_field_152af1f5 = Tessellator.getInstance().begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR_LIGHT);
        }
        return I_field_152af1f5;
    }

    public static void I_method_fe3d219f(IIiiii_Class16 iIiiii_Class16, String string, float f, int n, Matrix4f matrix4f, float f2, float f3, float f4, float f5, float f6) {
        if (!I_field_5a) {
            iIiiiiiIi_Class382.I_method_bea995df();
        }
        iIiiii_Class16.I_method_5811d2b(matrix4f, (VertexConsumer)iIiiiiiIi_Class382.I_method_cccd89a0(f5), string, f, f2, f3, f4, n);
    }

    public static void I_method_a2412a1f(IIiiii_Class16 iIiiii_Class16, String string, float f, int n, Matrix4f matrix4f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        if (!I_field_5a) {
            iIiiiiiIi_Class382.I_method_bea995df();
        }
        BufferBuilder bufferBuilder = iIiiiiiIi_Class382.I_method_cccd89a0(f5);
        ShaderProgram shaderProgram = RenderSystem.getShader();
        shaderProgram.getUniform("EnableFadeout").set(1);
        shaderProgram.getUniform("FadeoutStart").set(f7);
        shaderProgram.getUniform("FadeoutEnd").set(f8);
        shaderProgram.getUniform("MaxWidth").set(f9);
        shaderProgram.getUniform("TextPosX").set(f10);
        iIiiii_Class16.I_method_5811d2b(matrix4f, (VertexConsumer)bufferBuilder, string, f, f2, f3, f4, n);
    }

    public static void i_method_beb821bf() {
        if (!I_field_5a) {
            return;
        }
        if (I_field_152af1f5 != null) {
            BuiltBuffer builtBuffer = I_field_152af1f5.endNullable();
            if (builtBuffer != null) {
                BufferRenderer.drawWithGlobalProgram((BuiltBuffer)builtBuffer);
            }
            I_field_152af1f5 = null;
        }
        IiIIIi_Class18.I_method_a6e9b62c();
        RenderSystem.enableCull();
        RenderSystem.disableBlend();
        I_field_5a = false;
    }

    static {
        I_field_5a = false;
    }
}

