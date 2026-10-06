package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import lombok.Generated;
import net.minecraft.client.gl.Defines;
import net.minecraft.client.gl.ShaderProgram;
import net.minecraft.client.gl.ShaderProgramKey;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.text.Text;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import rockstar.client.IIIiIiIi_Class22;
import rockstar.client.IIiIii_Class12;
import rockstar.client.IIiiiI_Class15;
import rockstar.client.IIiiii_Class16;
import rockstar.client.IiIIII_Class17;
import rockstar.client.IiIiIi_Class22;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIiiiiIiI_Class379;
import rockstar.client.iIiiiiIii_Class380;

public final class IiIIIi_Class18 {
    public static final ShaderProgramKey I_field_bb992b15 = new ShaderProgramKey(IIiiiI_Class15.I_method_fa9f2625("slug_font/data"), VertexFormats.POSITION_TEXTURE_COLOR_LIGHT, Defines.EMPTY);
    private static boolean I_field_5a;

    public static ShaderProgram I_method_fb4921e0(float f) {
        return IiIIIi_Class18.I_method_1a4fabf8(f, 1.0f);
    }

    public static ShaderProgram I_method_1a4fabf8(float f, float f2) {
        IiIiIi_Class22 iiIiRockstarClient2 = IiIiIi_Class22.I_method_bdb4d34b();
        iiIiRockstarClient2.I_method_a30f520c();
        RenderSystem.setShaderTexture((int)0, (int)iiIiRockstarClient2.I_method_a30f51ff());
        RenderSystem.setShaderTexture((int)1, (int)iiIiRockstarClient2.i_method_a31ddddf());
        RenderSystem.setShaderTexture((int)2, (int)iiIiRockstarClient2.II_method_bee9e6c8());
        ShaderProgram shaderProgram = RenderSystem.setShader((ShaderProgramKey)I_field_bb992b15);
        shaderProgram.getUniform("Weight").set(f);
        shaderProgram.getUniform("Softness").set(f2);
        return shaderProgram;
    }

    public static void I_method_d904a8f7(int n, int n2, int n3) {
        IiIiIi_Class22 iiIiRockstarClient2 = IiIiIi_Class22.I_method_bdb4d34b();
        iiIiRockstarClient2.I_method_a30f520c();
        RenderSystem.setShaderTexture((int)n, (int)iiIiRockstarClient2.I_method_a30f51ff());
        RenderSystem.setShaderTexture((int)n2, (int)iiIiRockstarClient2.i_method_a31ddddf());
        RenderSystem.setShaderTexture((int)n3, (int)iiIiRockstarClient2.II_method_bee9e6c8());
    }

    public static void I_method_a6e9b62c() {
        RenderSystem.setShaderTexture((int)0, (int)0);
        RenderSystem.setShaderTexture((int)1, (int)0);
        RenderSystem.setShaderTexture((int)2, (int)0);
    }

    private static boolean I_method_364d825b(int n) {
        return (n >>> 24 & 0xFF) == 0;
    }

    private static boolean I_method_a1dbcbd3(IIiiii_Class16 iIiiii_Class16, String string, float f, Matrix4f matrix4f, float f2, float f3, Consumer<Matrix4f> consumer) {
        if (I_field_5a || !IIIiIiIi_Class22.II_method_40fdec79()) {
            return false;
        }
        String string2 = IIIiIiIi_Class22.I_method_7f49082a(string);
        if (string2 == string) {
            return false;
        }
        return IiIIIi_Class18.I_method_ac55d4b6(matrix4f, f2, f3, f, Math.max(iIiiii_Class16.I_method_c000b13a(string, f), iIiiii_Class16.I_method_c000b13a(string2, f)), consumer);
    }

    private static boolean I_method_4fb7360c(IIiiii_Class16 iIiiii_Class16, List<IIiIii_Class12.Nested1_e9eaef13> list, float f, Matrix4f matrix4f, float f2, float f3, Consumer<Matrix4f> consumer) {
        if (I_field_5a || !IIIiIiIi_Class22.II_method_40fdec79()) {
            return false;
        }
        List<IIiIii_Class12.Nested1_e9eaef13> list2 = IiIIIi_Class18.I_method_2d2a298a(list);
        if (list2 == list) {
            return false;
        }
        float f4 = 0.0f;
        float f5 = 0.0f;
        for (int i = 0; i < list.size(); ++i) {
            f4 += iIiiii_Class16.I_method_c000b13a(list.get((int)i).I_field_523beb0a, f);
            f5 += iIiiii_Class16.I_method_c000b13a(list2.get((int)i).I_field_523beb0a, f);
        }
        return IiIIIi_Class18.I_method_ac55d4b6(matrix4f, f2, f3, f, Math.max(f4, f5), consumer);
    }

    private static boolean I_method_ac55d4b6(Matrix4f matrix4f, final float f, final float f2, final float f3, final float f4, final Consumer<Matrix4f> consumer) {
        final Matrix4f matrix4f2 = new Matrix4f((Matrix4fc)matrix4f);
        return IIIiIiIi_Class22.I_method_9e8f326c(new IIIiIiIi_Class22.Nested1_85037d53(){

            @Override
            public int[] I_method_5aed677d() {
                return IIIiIiIi_Class22.I_method_a0f921e2(matrix4f2, f - 1.0f, f2 - f3 * 0.35f, f + f4 + 2.0f, f2 + f3 * 1.45f);
            }

            @Override
            public void I_method_2eee247() {
                IiIIIi_Class18.I_method_47abd2aa(() -> consumer.accept(matrix4f2));
            }

            @Override
            public void i_method_2fd6e27() {
                IiIIIi_Class18.I_method_47abd2aa(() -> consumer.accept(matrix4f2));
            }
        });
    }

    static void I_method_47abd2aa(Runnable runnable) {
        I_field_5a = true;
        try {
            runnable.run();
        }
        finally {
            I_field_5a = false;
        }
    }

    private static List<IIiIii_Class12.Nested1_e9eaef13> I_method_2d2a298a(List<IIiIii_Class12.Nested1_e9eaef13> list) {
        ArrayList<IIiIii_Class12.Nested1_e9eaef13> arrayList = null;
        for (int i = 0; i < list.size(); ++i) {
            IIiIii_Class12.Nested1_e9eaef13 nested1_e9eaef13 = list.get(i);
            String string = IIIiIiIi_Class22.I_method_7f49082a(nested1_e9eaef13.I_field_523beb0a);
            if (string == nested1_e9eaef13.I_field_523beb0a) continue;
            if (arrayList == null) {
                arrayList = new ArrayList<IIiIii_Class12.Nested1_e9eaef13>(list);
            }
            arrayList.set(i, new IIiIii_Class12.Nested1_e9eaef13(string, nested1_e9eaef13.I_field_49, nested1_e9eaef13.I_field_5a, nested1_e9eaef13.i_field_5a, nested1_e9eaef13.II_field_5a, nested1_e9eaef13.Ii_field_5a));
        }
        return arrayList == null ? list : arrayList;
    }

    public static void I_method_f6065e6c(IIiiii_Class16 iIiiii_Class16, String string, float f, int n, Matrix4f matrix4f, float f2, float f3, float f4) {
        if (IiIIIi_Class18.I_method_364d825b(n)) {
            return;
        }
        IiIIIi_Class18.I_method_87624d8(iIiiii_Class16, string, f, n, matrix4f, f2, f3, f4, false, 0.0f, 1.0f, 0.0f);
    }

    public static void I_method_87624d8(IIiiii_Class16 iIiiii_Class16, String string, float f, int n, Matrix4f matrix4f, float f2, float f3, float f4, boolean bl, float f5, float f6, float f7) {
        IiIIIi_Class18.I_method_c38d46d8(iIiiii_Class16, string, f, n, matrix4f, f2, f3, f4, bl, f5, f6, f7, 0.0f, 0.0f);
    }

    public static void I_method_c38d46d8(IIiiii_Class16 iIiiii_Class16, String string, float f, int n, Matrix4f matrix4f, float f2, float f3, float f4, boolean bl, float f5, float f6, float f7, float f8, float f9) {
        iIiiiiIii_Class380 iIiiiiIii_Class3802;
        if (IiIIIi_Class18.I_method_364d825b(n)) {
            return;
        }
        if (string == null) {
            string = "";
        }
        final String originalText = string;
        if (IiIIIi_Class18.I_method_a1dbcbd3(iIiiii_Class16, originalText, f, matrix4f, f2, f3, arg_0 -> IiIIIi_Class18.I_method_8d43f99c(iIiiii_Class16, originalText, f, n, f2, f3, f4, bl, f5, f6, f7, f8, f9, arg_0))) {
            return;
        }
        string = IIIiIiIi_Class22.I_method_7f49082a(string);
        float f10 = 0.0f;
        float f11 = 0.5f;
        if (!I_field_5a && iIiiiiIiI_Class379.i_method_941b0f15() != null) {
            iIiiii_Class16.I_method_5811d2b(matrix4f, (VertexConsumer)iIiiiiIiI_Class379.i_method_941b0f15().I_method_b8b8cc9e(), string, f, f2, f3, f4, n);
            return;
        }
        iIiiiiIii_Class380 iIiiiiIii_Class3803 = iIiiiiIii_Class3802 = I_field_5a ? null : iIiiiiIii_Class380.II_method_752e8438();
        if (iIiiiiIii_Class3802 != null) {
            if (!bl && f8 == 0.0f && f9 == 0.0f) {
                iIiiiiIii_Class3802.I_method_893c7e7b(iIiiii_Class16, string, f, matrix4f, f2, f3, f4, n);
                return;
            }
            if (iIiiiiIii_Class3802.I_method_b28fcfbd(iIiiii_Class16, string, f, matrix4f, f2, f3, f4, n, f10, f11, bl, f2, f7, f5, f6, f8, f9)) {
                return;
            }
            iIiiiiIii_Class380.I_method_5f4b621f();
        }
        iIiiiiIii_Class380.Ii_method_8a3e6502();
        RenderSystem.disableCull();
        ShaderProgram shaderProgram = IiIIIi_Class18.I_method_1a4fabf8(f10, f11);
        shaderProgram.getUniform("EnableFadeout").set(bl ? 1 : 0);
        shaderProgram.getUniform("FadeoutStart").set(f5);
        shaderProgram.getUniform("FadeoutEnd").set(f6);
        shaderProgram.getUniform("FadeinStart").set(f8);
        shaderProgram.getUniform("FadeinEnd").set(f9);
        shaderProgram.getUniform("MaxWidth").set(f7);
        shaderProgram.getUniform("TextPosX").set(f2);
        BufferBuilder bufferBuilder = Tessellator.getInstance().begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR_LIGHT);
        iIiiii_Class16.I_method_aaa2eff5(matrix4f, (VertexConsumer)bufferBuilder, string, f, f2, f3, f4, n, f11);
        BuiltBuffer builtBuffer = bufferBuilder.endNullable();
        if (builtBuffer != null) {
            BufferRenderer.drawWithGlobalProgram((BuiltBuffer)builtBuffer);
        }
        IiIIIi_Class18.I_method_a6e9b62c();
        RenderSystem.enableCull();
        RenderSystem.disableBlend();
    }

    public static void I_method_31d23fe8(IIiiii_Class16 iIiiii_Class16, String string, float f, int n, Matrix4f matrix4f, float f2, float f3, float f4, boolean bl, float f5, float f6) {
        float f7 = iIiiii_Class16.I_method_c000b13a(string, f) * 2.0f;
        IiIIIi_Class18.I_method_87624d8(iIiiii_Class16, string, f, n, matrix4f, f2, f3, f4, bl, f5, f6, f7);
    }

    public static void I_method_8df56b6c(IIiiii_Class16 iIiiii_Class16, String string, float f, int n, Matrix4f matrix4f, float f2, float f3, float f4, float f5, float f6) {
        iIiiiiIii_Class380 iIiiiiIii_Class3802;
        if (IiIIIi_Class18.I_method_364d825b(n)) {
            return;
        }
        if (string == null) {
            string = "";
        }
        final String originalText = string;
        if (IiIIIi_Class18.I_method_a1dbcbd3(iIiiii_Class16, originalText, f, matrix4f, f2, f3, arg_0 -> IiIIIi_Class18.I_method_20a7d788(iIiiii_Class16, originalText, f, n, f2, f3, f4, f5, f6, arg_0))) {
            return;
        }
        string = IIIiIiIi_Class22.I_method_7f49082a(string);
        if (!I_field_5a && iIiiiiIiI_Class379.i_method_941b0f15() != null) {
            iIiiii_Class16.I_method_5811d2b(matrix4f, (VertexConsumer)iIiiiiIiI_Class379.i_method_941b0f15().I_method_b8b8cc9e(), string, f, f2, f3, f4, n);
            return;
        }
        iIiiiiIii_Class380 iIiiiiIii_Class3803 = iIiiiiIii_Class3802 = I_field_5a ? null : iIiiiiIii_Class380.II_method_752e8438();
        if (iIiiiiIii_Class3802 != null) {
            if (iIiiiiIii_Class3802.I_method_b28fcfbd(iIiiii_Class16, string, f, matrix4f, f2, f3, f4, n, f5, f6, false, f2, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f)) {
                return;
            }
            iIiiiiIii_Class380.I_method_5f4b621f();
        }
        iIiiiiIii_Class380.Ii_method_8a3e6502();
        RenderSystem.disableCull();
        ShaderProgram shaderProgram = IiIIIi_Class18.I_method_1a4fabf8(f5, f6);
        shaderProgram.getUniform("EnableFadeout").set(0);
        shaderProgram.getUniform("FadeoutStart").set(0.0f);
        shaderProgram.getUniform("FadeoutEnd").set(1.0f);
        shaderProgram.getUniform("MaxWidth").set(0.0f);
        shaderProgram.getUniform("TextPosX").set(f2);
        BufferBuilder bufferBuilder = Tessellator.getInstance().begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR_LIGHT);
        iIiiii_Class16.I_method_aaa2eff5(matrix4f, (VertexConsumer)bufferBuilder, string, f, f2, f3, f4, n, f6);
        BuiltBuffer builtBuffer = bufferBuilder.endNullable();
        if (builtBuffer != null) {
            BufferRenderer.drawWithGlobalProgram((BuiltBuffer)builtBuffer);
        }
        IiIIIi_Class18.I_method_a6e9b62c();
        RenderSystem.enableCull();
        RenderSystem.disableBlend();
    }

    public static void I_method_c904cf99(IIiiii_Class16 iIiiii_Class16, Text text, float f, Matrix4f matrix4f, float f2, float f3, float f4) {
        IiIIIi_Class18.I_method_674e3785(iIiiii_Class16, text, f, matrix4f, f2, f3, f4, false, 0.0f, 1.0f, 0.0f);
    }

    public static void I_method_674e3785(IIiiii_Class16 iIiiii_Class16, Text text, float f, Matrix4f matrix4f2, float f2, float f3, float f4, boolean bl, float f5, float f6, float f7) {
        iIiiiiIii_Class380 iIiiiiIii_Class3802;
        float f8 = 0.0f;
        float f9 = 0.5f;
        List<IIiIii_Class12.Nested1_e9eaef13> list = IIiIii_Class12.I_method_8847bf1e(text, IiiiiIIIi_Class242.Ii_field_d0c8ec5.getRGB());
        if (IiIIIi_Class18.I_method_4fb7360c(iIiiii_Class16, list, f, matrix4f2, f2, f3, matrix4f -> IiIIIi_Class18.I_method_674e3785(iIiiii_Class16, text, f, matrix4f, f2, f3, f4, bl, f5, f6, f7))) {
            return;
        }
        list = IiIIIi_Class18.I_method_2d2a298a(list);
        float f10 = f2;
        if (!I_field_5a && iIiiiiIiI_Class379.i_method_941b0f15() != null) {
            for (IIiIii_Class12.Nested1_e9eaef13 nested1_e9eaef13 : list) {
                if (!IiIIIi_Class18.I_method_364d825b(nested1_e9eaef13.I_field_49)) {
                    iIiiii_Class16.I_method_5811d2b(matrix4f2, (VertexConsumer)iIiiiiIiI_Class379.i_method_941b0f15().I_method_b8b8cc9e(), nested1_e9eaef13.I_field_523beb0a, f, f10, f3, f4, nested1_e9eaef13.I_field_49);
                }
                f10 += iIiiii_Class16.I_method_c000b13a(nested1_e9eaef13.I_field_523beb0a, f);
            }
            return;
        }
        iIiiiiIii_Class380 iIiiiiIii_Class3803 = iIiiiiIii_Class3802 = I_field_5a ? null : iIiiiiIii_Class380.II_method_752e8438();
        if (iIiiiiIii_Class3802 != null) {
            if (!bl) {
                for (IIiIii_Class12.Nested1_e9eaef13 nested1_e9eaef13 : list) {
                    if (!IiIIIi_Class18.I_method_364d825b(nested1_e9eaef13.I_field_49)) {
                        iIiiiiIii_Class3802.I_method_893c7e7b(iIiiii_Class16, nested1_e9eaef13.I_field_523beb0a, f, matrix4f2, f10, f3, f4, nested1_e9eaef13.I_field_49);
                    }
                    f10 += iIiiii_Class16.I_method_c000b13a(nested1_e9eaef13.I_field_523beb0a, f);
                }
                return;
            }
            if (iIiiiiIii_Class3802.II_method_8a2fd926()) {
                for (IIiIii_Class12.Nested1_e9eaef13 nested1_e9eaef13 : list) {
                    if (!IiIIIi_Class18.I_method_364d825b(nested1_e9eaef13.I_field_49)) {
                        iIiiiiIii_Class3802.I_method_b28fcfbd(iIiiii_Class16, nested1_e9eaef13.I_field_523beb0a, f, matrix4f2, f10, f3, f4, nested1_e9eaef13.I_field_49, f8, f9, true, f2, f7, f5, f6, 0.0f, 0.0f);
                    }
                    f10 += iIiiii_Class16.I_method_c000b13a(nested1_e9eaef13.I_field_523beb0a, f);
                }
                return;
            }
            iIiiiiIii_Class380.I_method_5f4b621f();
        }
        iIiiiiIii_Class380.Ii_method_8a3e6502();
        RenderSystem.disableCull();
        ShaderProgram shaderProgram = IiIIIi_Class18.I_method_1a4fabf8(f8, f9);
        shaderProgram.getUniform("EnableFadeout").set(bl ? 1 : 0);
        shaderProgram.getUniform("FadeoutStart").set(f5);
        shaderProgram.getUniform("FadeoutEnd").set(f6);
        shaderProgram.getUniform("FadeinStart").set(0.0f);
        shaderProgram.getUniform("FadeinEnd").set(0.0f);
        shaderProgram.getUniform("MaxWidth").set(f7);
        shaderProgram.getUniform("TextPosX").set(f2);
        BufferBuilder bufferBuilder = Tessellator.getInstance().begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR_LIGHT);
        for (IIiIii_Class12.Nested1_e9eaef13 nested1_e9eaef13 : list) {
            iIiiii_Class16.I_method_aaa2eff5(matrix4f2, (VertexConsumer)bufferBuilder, nested1_e9eaef13.I_field_523beb0a, f, f10, f3, f4, nested1_e9eaef13.I_field_49, f9);
            f10 += iIiiii_Class16.I_method_c000b13a(nested1_e9eaef13.I_field_523beb0a, f);
        }
        BuiltBuffer builtBuffer = bufferBuilder.endNullable();
        if (builtBuffer != null) {
            BufferRenderer.drawWithGlobalProgram((BuiltBuffer)builtBuffer);
        }
        IiIIIi_Class18.I_method_a6e9b62c();
        RenderSystem.enableCull();
        RenderSystem.disableBlend();
    }

    public static void I_method_c986a39b(IIiiii_Class16 iIiiii_Class16, Text text, float f, Matrix4f matrix4f, float f2, float f3, float f4, boolean bl, float f5, float f6) {
        float f7 = iIiiii_Class16.I_method_a03b5896(text, f) * 2.0f;
        IiIIIi_Class18.I_method_674e3785(iIiiii_Class16, text, f, matrix4f, f2, f3, f4, bl, f5, f6, f7);
    }

    public static void I_method_6f9f3db5(IIiiii_Class16 iIiiii_Class16, int n, float f, float f2, float f3, int n2, Matrix4f matrix4f) {
        iIiiiiIii_Class380 iIiiiiIii_Class3802;
        if (IiIIIi_Class18.I_method_364d825b(n2)) {
            return;
        }
        if (iIiiii_Class16 == null) {
            return;
        }
        IiIIII_Class17 iiIIII_Class17 = iIiiii_Class16.I_method_3e06ef20(n);
        if (iiIIII_Class17 == null) {
            return;
        }
        iIiiiiIii_Class380 iIiiiiIii_Class3803 = iIiiiiIii_Class3802 = I_field_5a ? null : iIiiiiIii_Class380.II_method_752e8438();
        if (iIiiiiIii_Class3802 != null) {
            iIiiiiIii_Class3802.I_method_3fa37ff2(iIiiii_Class16, n, f, f2, f3, matrix4f, n2);
            return;
        }
        float f4 = 0.0f;
        float f5 = 0.5f;
        iIiiiiIii_Class380.Ii_method_8a3e6502();
        RenderSystem.disableCull();
        ShaderProgram shaderProgram = IiIIIi_Class18.I_method_1a4fabf8(f4, f5);
        shaderProgram.getUniform("EnableFadeout").set(0);
        shaderProgram.getUniform("FadeoutStart").set(0.0f);
        shaderProgram.getUniform("FadeoutEnd").set(1.0f);
        shaderProgram.getUniform("MaxWidth").set(0.0f);
        shaderProgram.getUniform("TextPosX").set(f);
        BufferBuilder bufferBuilder = Tessellator.getInstance().begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR_LIGHT);
        iiIIII_Class17.I_method_4afb96f1(matrix4f, (VertexConsumer)bufferBuilder, f, f2, f3, n2);
        BuiltBuffer builtBuffer = bufferBuilder.endNullable();
        if (builtBuffer != null) {
            BufferRenderer.drawWithGlobalProgram((BuiltBuffer)builtBuffer);
        }
        IiIIIi_Class18.I_method_a6e9b62c();
        RenderSystem.enableCull();
        RenderSystem.disableBlend();
    }

    @Generated
    private IiIIIi_Class18() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    private static /* synthetic */ void I_method_20a7d788(IIiiii_Class16 iIiiii_Class16, String string, float f, int n, float f2, float f3, float f4, float f5, float f6, Matrix4f matrix4f) {
        IiIIIi_Class18.I_method_8df56b6c(iIiiii_Class16, string, f, n, matrix4f, f2, f3, f4, f5, f6);
    }

    private static /* synthetic */ void I_method_8d43f99c(IIiiii_Class16 iIiiii_Class16, String string, float f, int n, float f2, float f3, float f4, boolean bl, float f5, float f6, float f7, float f8, float f9, Matrix4f matrix4f) {
        IiIIIi_Class18.I_method_c38d46d8(iIiiii_Class16, string, f, n, matrix4f, f2, f3, f4, bl, f5, f6, f7, f8, f9);
    }
}
