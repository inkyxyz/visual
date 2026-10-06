package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
import net.minecraft.client.gl.ShaderProgram;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import org.joml.Matrix4f;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import rockstar.client.IIiii_Class8;
import rockstar.client.IIiiii_Class16;
import rockstar.client.IiIIII_Class17;
import rockstar.client.IiIIIi_Class18;
import rockstar.client.IiIiIi_Class22;
import rockstar.client.iIiiIIiii_Class360;
import rockstar.client.iIiiIiiII_Class365;
import rockstar.client.iIiiiIiII_Class373;
import rockstar.client.iIiiiiIii_Class380;

final class iIiiiiiII_Class381
implements IIiiii_Class16.Nested1_8a0e0776 {
    private static final int I_field_49 = 48;
    private static final int i_field_49 = 12;
    private static final int II_field_49 = 12;
    private static final int Ii_field_49 = 4;
    private static final int iI_field_49 = 8;
    private static final int ii_field_49 = 3;
    private static final float I_field_46 = -4096.0f;
    private static final float i_field_46 = 4096.0f;
    private static final float II_field_46 = 0.0f;
    private static final float Ii_field_46 = 1.0f;
    private static final float iI_field_46 = 2.0f;
    private static final float ii_field_46 = 3.0f;
    private static final float III_field_46 = 4.0f;
    private static final float IIi_field_46 = 5.0f;
    private static final float[] I_field_b4b = new float[]{0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -4096.0f, -4096.0f, -4096.0f, -4096.0f, -2.0f, -2.0f, -2.0f, -2.0f, 0.0f, -4096.0f, 0.0f, -16.0f, -16.0f, -16.0f, -16.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    private static final float[] i_field_b4b = new float[]{8.0f, 16.0f, 32768.0f, 1.0f, 4096.0f, 4096.0f, 64.0f, 64.0f, 512.0f, 512.0f, 512.0f, 512.0f, 64.0f, 64.0f, 64.0f, 1.0f, 4096.0f, 4096.0f, 4096.0f, 4096.0f, 2.0f, 2.0f, 2.0f, 2.0f, 1.0f, 4096.0f, 4096.0f, 16.0f, 16.0f, 16.0f, 16.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
    private float[] II_field_b4b = new float[12288];
    private float[] Ii_field_b4b = new float[3072];
    private int[] I_field_b4e = new int[1024];
    private int III_field_49;
    private final int[] i_field_b4e = new int[8];
    private int IIi_field_49;
    private float[] iI_field_b4b = new float[32];
    private int IiI_field_49;
    private float IiI_field_46 = -4096.0f;
    private float Iii_field_46 = -4096.0f;
    private float iII_field_46 = 4096.0f;
    private float iIi_field_46 = 4096.0f;
    private final int[] II_field_b4e = new int[3];
    private int Iii_field_49 = -1;
    private int iII_field_49;
    private ShortBuffer I_field_f3e9e79b;
    private boolean I_field_5a = true;
    private Matrix4f I_field_d754d74;
    private float iiI_field_46 = 1.0f;
    private float iii_field_46;
    private float IIII_field_46;
    private float IIIi_field_46;
    private float IIiI_field_46;
    private float IIii_field_46;
    private float IiII_field_46;
    private float IiIi_field_46;
    private float IiiI_field_46;
    private float Iiii_field_46;

    iIiiiiiII_Class381() {
    }

    boolean I_method_880e8203() {
        return this.III_field_49 > 0;
    }

    boolean i_method_881d0de3() {
        if (!this.I_field_5a) {
            return false;
        }
        RenderSystem.assertOnRenderThread();
        if (iIiiIIiii_Class360.iI_field_2f5b1d2c == null || iIiiIIiii_Class360.iI_field_2f5b1d2c.I_method_33f6c16b() == null) {
            return false;
        }
        return this.I_method_79c230e8(1);
    }

    void I_method_880e81ff() {
        this.III_field_49 = 0;
        this.IIi_field_49 = 0;
        this.IiI_field_49 = 0;
        this.IiI_field_46 = -4096.0f;
        this.Iii_field_46 = -4096.0f;
        this.iII_field_46 = 4096.0f;
        this.iIi_field_46 = 4096.0f;
    }

    void I_method_29ab5a7f(float f, float f2, float f3, float f4) {
        this.i_method_7b852104((this.IiI_field_49 + 1) * 4);
        int n = this.IiI_field_49++ * 4;
        this.iI_field_b4b[n] = this.IiI_field_46;
        this.iI_field_b4b[n + 1] = this.Iii_field_46;
        this.iI_field_b4b[n + 2] = this.iII_field_46;
        this.iI_field_b4b[n + 3] = this.iIi_field_46;
        this.IiI_field_46 = f;
        this.Iii_field_46 = f2;
        this.iII_field_46 = f + f3;
        this.iIi_field_46 = f2 + f4;
    }

    void i_method_881d0ddf() {
        if (this.IiI_field_49 <= 0) {
            return;
        }
        int n = --this.IiI_field_49 * 4;
        this.IiI_field_46 = this.iI_field_b4b[n];
        this.Iii_field_46 = this.iI_field_b4b[n + 1];
        this.iII_field_46 = this.iI_field_b4b[n + 2];
        this.iIi_field_46 = this.iI_field_b4b[n + 3];
    }

    void I_method_6bfb18f(Matrix4f matrix4f, float f, float f2, float f3, float f4, int n, int n2, int n3, int n4) {
        int n5 = this.I_method_6bfb182(matrix4f, f, f2, f3, f4, n, n2, n3, n4);
        this.I_method_1207dd01(n5, 0, 0.0f);
    }

    void I_method_ad25e5b7(Matrix4f matrix4f, float f, float f2, float f3, float f4, IIiii_Class8 iIiii_Class8, float f5, float f6, int n, int n2, int n3, int n4) {
        float f7 = f5 * 1.5f;
        int n5 = this.I_method_6bfb182(matrix4f, f - f7 * 0.5f, f2 - f7 * 0.5f, f3 + f7, f4 + f7, n, n2, n3, n4);
        this.I_method_f9c5ed0a(n5, 1.0f, f3, f4, iIiii_Class8, f5, f6);
    }

    void I_method_f79783fd(Matrix4f matrix4f, float f, float f2, float f3, float f4, IIiii_Class8 iIiii_Class8, float f5, float f6, int n, int n2, int n3, int n4, boolean bl) {
        this.I_method_ad25e5b7(matrix4f, f, f2, f3, f4, iIiii_Class8, f5, f6, n, n2, n3, n4);
        int n5 = this.III_field_49 - 1;
        if (bl) {
            this.I_method_1207dd01(n5, 15, 1.0f);
            this.I_method_1207e844(n5, 32, n);
            this.I_method_1207e844(n5, 36, n2);
            this.I_method_1207e844(n5, 40, n3);
            this.I_method_1207e844(n5, 44, n4);
        }
    }

    void I_method_cb9bc32c(Matrix4f matrix4f, float f, float f2, float f3, float f4, IIiii_Class8 iIiii_Class8, float f5, float f6, float f7, float f8, int n) {
        float f9 = f7 * 1.5f;
        int n2 = this.I_method_6bfb182(matrix4f, f - f9 * 0.5f, f2 - f9 * 0.5f, f3 + f9, f4 + f9, n, n, n, n);
        this.I_method_f9c5ed0a(n2, 2.0f, f3, f4, iIiii_Class8, f7, f8);
        this.I_method_1207dd01(n2, 12, f5);
        this.I_method_1207dd01(n2, 13, f6);
        this.I_method_1207dd01(n2, 14, f7);
    }

    void I_method_e9dfd3f1(Matrix4f matrix4f, int n, float f, float f2, float f3, float f4, float f5, float f6, IIiii_Class8 iIiii_Class8, float f7, float f8, float f9, float f10, float f11, float f12, int n2) {
        int n3 = this.I_method_79c230d7(n);
        int n4 = this.I_method_6bfb182(matrix4f, f, f2, f3, f4, n2, n2, n2, n2);
        this.I_method_f9c5ed0a(n4, 4.0f, f5, f6, iIiii_Class8, f7, f8);
        this.I_method_1207dd01(n4, 1, n3);
        this.I_method_aa730ee4(n4, f9, f10, f11, f12);
    }

    void I_method_911c746f(Matrix4f matrix4f, int n, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n2) {
        int n3 = this.I_method_79c230d7(n);
        int n4 = this.I_method_6bfb182(matrix4f, f, f2, f3, f4, n2, n2, n2, n2);
        this.I_method_1207dd01(n4, 0, 5.0f);
        this.I_method_1207dd01(n4, 1, n3);
        this.I_method_aa730ee4(n4, f5, f6, f7, f8);
    }

    void I_method_3aadd82b(Matrix4f matrix4f, IIiiii_Class16 iIiiii_Class16, String string, float f, float f2, float f3, float f4, int n, float f5, float f6, boolean bl, float f7, float f8, float f9, float f10, float f11, float f12) {
        this.I_field_d754d74 = matrix4f;
        this.iiI_field_46 = IiIIII_Class17.I_method_bf203252(matrix4f);
        this.iii_field_46 = f5;
        this.IIII_field_46 = f6;
        this.IIIi_field_46 = bl ? 1.0f : 0.0f;
        this.IIiI_field_46 = this.I_method_c9065181(matrix4f, f7, f3, f4);
        this.IIii_field_46 = f8;
        this.IiII_field_46 = f9;
        this.IiIi_field_46 = f10;
        boolean bl2 = f12 > 0.001f;
        this.IiiI_field_46 = bl2 ? f11 : -1.0f;
        this.Iiii_field_46 = bl2 ? f12 : -1.0f;
        iIiiii_Class16.I_method_7bba9b9e(string, f, f2, f3, f4, n, this);
    }

    void I_method_d87f0f16(Matrix4f matrix4f, IIiiii_Class16 iIiiii_Class16, int n, float f, float f2, float f3, int n2) {
        IiIIII_Class17 iiIIII_Class17 = iIiiii_Class16.i_method_5827db00(n);
        if (iiIIII_Class17 == null || iiIIII_Class17.I_method_704ea250()) {
            return;
        }
        float f4 = IiIIII_Class17.I_method_bf203252(matrix4f);
        float f5 = iiIIII_Class17.i_method_cdd74b1c(f3, f4);
        float f6 = iiIIII_Class17.II_method_86f44545(f3, f4);
        float f7 = iiIIII_Class17.Ii_method_bd8f5925(f3, f4);
        float f8 = iiIIII_Class17.iI_method_23bbad65(f3, f4);
        float f9 = f + f5 * f3;
        float f10 = f2 + (1.0f - f8) * f3;
        int n3 = this.I_method_6bfb182(matrix4f, f9, f10, (f6 - f5) * f3, (f8 - f7) * f3, n2, n2, n2, n2);
        this.I_method_1207dd01(n3, 0, 3.0f);
        this.I_method_1207dd01(n3, 2, iiIIII_Class17.i_method_705d2e1f() + 1);
        this.I_method_1207dd01(n3, 3, 0.0f);
        this.I_method_1207dd01(n3, 7, 0.5f);
        this.I_method_aa730ee4(n3, f5, f8, f6, f7);
    }

    @Override
    public void I_method_61cd0f5e(IiIIII_Class17 iiIIII_Class17, float f, float f2, float f3, float f4, int n) {
        if (iiIIII_Class17.I_method_704ea250()) {
            return;
        }
        float f5 = iiIIII_Class17.I_method_504b19e4(f2, f, this.iiI_field_46);
        float f6 = iiIIII_Class17.i_method_ed128204(f3, f, this.iiI_field_46);
        int n2 = this.I_method_6bfb182(this.I_field_d754d74, f5, f6, iiIIII_Class17.ii_method_5a56c145(f, this.iiI_field_46), iiIIII_Class17.III_method_8e3df85c(f, this.iiI_field_46), n, n, n, n);
        this.I_method_1207dd01(n2, 0, 3.0f);
        this.I_method_1207dd01(n2, 2, iiIIII_Class17.i_method_705d2e1f() + 1);
        this.I_method_1207dd01(n2, 3, this.iii_field_46);
        this.I_method_1207dd01(n2, 7, this.IIII_field_46);
        this.I_method_aa730ee4(n2, iiIIII_Class17.i_method_cdd74b1c(f, this.iiI_field_46), iiIIII_Class17.iI_method_23bbad65(f, this.iiI_field_46), iiIIII_Class17.II_method_86f44545(f, this.iiI_field_46), iiIIII_Class17.Ii_method_bd8f5925(f, this.iiI_field_46));
        this.I_method_1207dd01(n2, 24, this.IIIi_field_46);
        this.I_method_1207dd01(n2, 25, this.IIiI_field_46);
        this.I_method_1207dd01(n2, 26, this.IIii_field_46);
        this.I_method_1207dd01(n2, 27, this.IiII_field_46);
        this.I_method_1207dd01(n2, 28, this.IiIi_field_46);
        this.I_method_1207dd01(n2, 29, this.IiiI_field_46);
        this.I_method_1207dd01(n2, 30, this.Iiii_field_46);
    }

    void II_method_79d0b542() {
        int n;
        ShaderProgram shaderProgram;
        int n2;
        int n3;
        if (this.III_field_49 == 0) {
            return;
        }
        RenderSystem.assertOnRenderThread();
        iIiiiIiII_Class373.II_method_f0a29162();
        if (!this.I_method_79c230e8(this.III_field_49)) {
            this.III_field_49 = 0;
            this.IIi_field_49 = 0;
            return;
        }
        this.I_field_f3e9e79b.clear();
        int n4 = this.III_field_49 * 48;
        for (n3 = 0; n3 < n4; ++n3) {
            n2 = n3 % 48;
            this.I_field_f3e9e79b.put(this.I_method_11dc395e(this.II_field_b4b[n3], I_field_b4b[n2], i_field_b4b[n2]));
        }
        this.I_field_f3e9e79b.flip();
        n3 = this.I_method_880e81f2();
        GlStateManager._activeTexture((int)33984);
        GlStateManager._bindTexture((int)n3);
        this.iI_method_7b93a562();
        this.Ii_method_79df4122();
        GL11.glTexSubImage2D((int)3553, (int)0, (int)0, (int)0, (int)12, (int)this.III_field_49, (int)6408, (int)5123, (ShortBuffer)this.I_field_f3e9e79b);
        n2 = GL11.glGetError();
        if (n2 != 0) {
            this.I_method_4e4cea1a("upload", n2);
            this.III_field_49 = 0;
            this.IIi_field_49 = 0;
            return;
        }
        float[] fArray = (float[])RenderSystem.getShaderColor().clone();
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        iIiiiiIii_Class380.Ii_method_8a3e6502();
        RenderSystem.disableCull();
        RenderSystem.setShaderTexture((int)0, (int)n3);
        IiIIIi_Class18.I_method_d904a8f7(9, 10, 11);
        for (int i = 0; i < 8; ++i) {
            RenderSystem.setShaderTexture((int)(i + 1), (int)(i < this.IIi_field_49 ? this.i_field_b4e[i] : 0));
        }
        ShaderProgram shaderProgram2 = shaderProgram = iIiiIIiii_Class360.iI_field_2f5b1d2c == null ? null : iIiiIIiii_Class360.iI_field_2f5b1d2c.I_method_33f6c16b();
        if (shaderProgram == null) {
            this.I_method_4e4cea1a("shader", 0);
            this.III_field_49 = 0;
            this.IIi_field_49 = 0;
            for (int i = 0; i <= 11; ++i) {
                RenderSystem.setShaderTexture((int)i, (int)0);
            }
            RenderSystem.enableCull();
            RenderSystem.disableBlend();
            RenderSystem.setShaderColor((float)fArray[0], (float)fArray[1], (float)fArray[2], (float)fArray[3]);
            return;
        }
        shaderProgram.addSamplerTexture("Sampler0", n3);
        IiIiIi_Class22 iiIiRockstarClient2 = IiIiIi_Class22.I_method_bdb4d34b();
        shaderProgram.addSamplerTexture("Sampler9", iiIiRockstarClient2.I_method_a30f51ff());
        shaderProgram.addSamplerTexture("Sampler10", iiIiRockstarClient2.i_method_a31ddddf());
        shaderProgram.addSamplerTexture("Sampler11", iiIiRockstarClient2.II_method_bee9e6c8());
        for (int i = 0; i < 8; ++i) {
            shaderProgram.addSamplerTexture("Sampler" + (i + 1), i < this.IIi_field_49 ? this.i_field_b4e[i] : 0);
        }
        BufferBuilder bufferBuilder = Tessellator.getInstance().begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
        for (int i = 0; i < this.III_field_49; ++i) {
            n = i * 12;
            int n5 = i * 4;
            float f = i;
            bufferBuilder.vertex(this.Ii_field_b4b[n], this.Ii_field_b4b[n + 1], this.Ii_field_b4b[n + 2]).texture(f, 0.0f).color(this.I_field_b4e[n5]);
            bufferBuilder.vertex(this.Ii_field_b4b[n + 3], this.Ii_field_b4b[n + 4], this.Ii_field_b4b[n + 5]).texture(f, 1.0f).color(this.I_field_b4e[n5 + 1]);
            bufferBuilder.vertex(this.Ii_field_b4b[n + 6], this.Ii_field_b4b[n + 7], this.Ii_field_b4b[n + 8]).texture(f, 2.0f).color(this.I_field_b4e[n5 + 2]);
            bufferBuilder.vertex(this.Ii_field_b4b[n + 9], this.Ii_field_b4b[n + 10], this.Ii_field_b4b[n + 11]).texture(f, 3.0f).color(this.I_field_b4e[n5 + 3]);
        }
        BuiltBuffer builtBuffer = bufferBuilder.endNullable();
        if (builtBuffer != null) {
            BufferRenderer.drawWithGlobalProgram((BuiltBuffer)builtBuffer);
        }
        for (n = 0; n <= 11; ++n) {
            RenderSystem.setShaderTexture((int)n, (int)0);
        }
        RenderSystem.enableCull();
        RenderSystem.disableBlend();
        RenderSystem.setShaderColor((float)fArray[0], (float)fArray[1], (float)fArray[2], (float)fArray[3]);
        this.III_field_49 = 0;
        this.IIi_field_49 = 0;
    }

    private int I_method_6bfb182(Matrix4f matrix4f, float f, float f2, float f3, float f4, int n, int n2, int n3, int n4) {
        this.I_method_79c230e4(this.III_field_49 + 1);
        int n5 = this.III_field_49++;
        int n6 = n5 * 12;
        this.I_method_57c45392(matrix4f, f, f2, 0.0f, n6);
        this.I_method_57c45392(matrix4f, f, f2 + f4, 0.0f, n6 + 3);
        this.I_method_57c45392(matrix4f, f + f3, f2 + f4, 0.0f, n6 + 6);
        this.I_method_57c45392(matrix4f, f + f3, f2, 0.0f, n6 + 9);
        int n7 = n5 * 4;
        this.I_field_b4e[n7] = n;
        this.I_field_b4e[n7 + 1] = n2;
        this.I_field_b4e[n7 + 2] = n3;
        this.I_field_b4e[n7 + 3] = n4;
        int n8 = n5 * 48;
        Arrays.fill(this.II_field_b4b, n8, n8 + 48, 0.0f);
        this.I_method_1207dd01(n5, 16, this.IiI_field_46);
        this.I_method_1207dd01(n5, 17, this.Iii_field_46);
        this.I_method_1207dd01(n5, 18, this.iII_field_46);
        this.I_method_1207dd01(n5, 19, this.iIi_field_46);
        return n5;
    }

    private void I_method_f9c5ed0a(int n, float f, float f2, float f3, IIiii_Class8 iIiii_Class8, float f4, float f5) {
        this.I_method_1207dd01(n, 0, f);
        this.I_method_1207dd01(n, 4, f2);
        this.I_method_1207dd01(n, 5, f3);
        this.I_method_1207dd01(n, 6, f5);
        this.I_method_1207dd01(n, 7, f4);
        this.I_method_1207dd01(n, 8, iIiii_Class8.I_method_b483cecf());
        this.I_method_1207dd01(n, 9, iIiii_Class8.Ii_method_dc139032());
        this.I_method_1207dd01(n, 10, iIiii_Class8.i_method_b4925aaf());
        this.I_method_1207dd01(n, 11, iIiii_Class8.II_method_dc050452());
    }

    private void I_method_aa730ee4(int n, float f, float f2, float f3, float f4) {
        this.I_method_1207dd01(n, 20, f);
        this.I_method_1207dd01(n, 21, f2);
        this.I_method_1207dd01(n, 22, f3);
        this.I_method_1207dd01(n, 23, f4);
    }

    private void I_method_1207e844(int n, int n2, int n3) {
        this.I_method_1207dd01(n, n2, (float)(n3 >>> 16 & 0xFF) / 255.0f);
        this.I_method_1207dd01(n, n2 + 1, (float)(n3 >>> 8 & 0xFF) / 255.0f);
        this.I_method_1207dd01(n, n2 + 2, (float)(n3 & 0xFF) / 255.0f);
        this.I_method_1207dd01(n, n2 + 3, (float)(n3 >>> 24 & 0xFF) / 255.0f);
    }

    private int I_method_79c230d7(int n) {
        for (int i = 0; i < this.IIi_field_49; ++i) {
            if (this.i_field_b4e[i] != n) continue;
            return i;
        }
        if (this.IIi_field_49 == 8) {
            this.II_method_79d0b542();
        }
        this.i_field_b4e[this.IIi_field_49] = n;
        return this.IIi_field_49++;
    }

    private void I_method_1207dd01(int n, int n2, float f) {
        this.II_field_b4b[n * 48 + n2] = f;
    }

    private short I_method_11dc395e(float f, float f2, float f3) {
        float f4 = (f - f2) / (f3 - f2);
        int n = Math.round(Math.max(0.0f, Math.min(1.0f, f4)) * 65535.0f);
        return (short)n;
    }

    private void I_method_57c45392(Matrix4f matrix4f, float f, float f2, float f3, int n) {
        this.Ii_field_b4b[n] = matrix4f.m00() * f + matrix4f.m10() * f2 + matrix4f.m20() * f3 + matrix4f.m30();
        this.Ii_field_b4b[n + 1] = matrix4f.m01() * f + matrix4f.m11() * f2 + matrix4f.m21() * f3 + matrix4f.m31();
        this.Ii_field_b4b[n + 2] = matrix4f.m02() * f + matrix4f.m12() * f2 + matrix4f.m22() * f3 + matrix4f.m32();
    }

    private float I_method_c9065181(Matrix4f matrix4f, float f, float f2, float f3) {
        return matrix4f.m00() * f + matrix4f.m10() * f2 + matrix4f.m20() * f3 + matrix4f.m30();
    }

    private void I_method_79c230e4(int n) {
        int n2 = this.II_field_b4b.length / 48;
        if (n <= n2) {
            return;
        }
        int n3 = Integer.highestOneBit(n - 1) << 1;
        this.II_field_b4b = Arrays.copyOf(this.II_field_b4b, n3 * 48);
        this.Ii_field_b4b = Arrays.copyOf(this.Ii_field_b4b, n3 * 12);
        this.I_field_b4e = Arrays.copyOf(this.I_field_b4e, n3 * 4);
    }

    private void i_method_7b852104(int n) {
        if (n <= this.iI_field_b4b.length) {
            return;
        }
        this.iI_field_b4b = Arrays.copyOf(this.iI_field_b4b, Integer.highestOneBit(n - 1) << 1);
    }

    private boolean I_method_79c230e8(int n) {
        if (!this.I_field_5a) {
            return false;
        }
        if (this.II_field_b4e[0] == 0) {
            for (int i = 0; i < this.II_field_b4e.length; ++i) {
                this.II_field_b4e[i] = GL11.glGenTextures();
                this.II_method_c0466601(this.II_field_b4e[i]);
            }
        }
        if (n > this.iII_field_49) {
            this.Ii_method_79df4122();
            this.iII_field_49 = Integer.highestOneBit(n - 1) << 1;
            if (this.iII_field_49 < 256) {
                this.iII_field_49 = 256;
            }
            for (int n2 : this.II_field_b4e) {
                int n3;
                GlStateManager._activeTexture((int)33984);
                GlStateManager._bindTexture((int)n2);
                this.iI_method_7b93a562();
                GL11.glTexImage2D((int)3553, (int)0, (int)32859, (int)12, (int)this.iII_field_49, (int)0, (int)6408, (int)5123, (ByteBuffer)null);
                int n4 = GL11.glGetError();
                int n5 = n4 == 0 ? GL11.glGetTexLevelParameteri((int)3553, (int)0, (int)4096) : 0;
                int n6 = n3 = n4 == 0 ? GL11.glGetTexLevelParameteri((int)3553, (int)0, (int)4097) : 0;
                if (n4 == 0 && n5 == 12 && n3 == this.iII_field_49) continue;
                this.I_method_4e4cea1a("allocation", n4);
                return false;
            }
            this.I_field_f3e9e79b = BufferUtils.createShortBuffer((int)(this.iII_field_49 * 48));
        }
        return true;
    }

    private void II_method_c0466601(int n) {
        GlStateManager._activeTexture((int)33984);
        GlStateManager._bindTexture((int)n);
        GL11.glTexParameteri((int)3553, (int)10241, (int)9728);
        GL11.glTexParameteri((int)3553, (int)10240, (int)9728);
        GL11.glTexParameteri((int)3553, (int)10242, (int)33071);
        GL11.glTexParameteri((int)3553, (int)10243, (int)33071);
        GL11.glTexParameteri((int)3553, (int)33084, (int)0);
        GL11.glTexParameteri((int)3553, (int)33085, (int)0);
    }

    private int I_method_880e81f2() {
        this.Iii_field_49 = (this.Iii_field_49 + 1) % this.II_field_b4e.length;
        return this.II_field_b4e[this.Iii_field_49];
    }

    private void I_method_4e4cea1a(String string, int n) {
        this.I_field_5a = false;
        System.err.println("[Rockstar] Low-draw UI batching disabled after command texture " + string + " failure (OpenGL error " + n + ").");
    }

    private void Ii_method_79df4122() {
        while (GL11.glGetError() != 0) {
        }
    }

    private void iI_method_7b93a562() {
        iIiiIiiII_Class365.i_method_feeee9ff();
    }
}

