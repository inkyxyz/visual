package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.ProjectionType;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.GlUniform;
import net.minecraft.client.gl.ShaderProgramKey;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.VertexFormats;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;
import rockstar.client.IIIiii_Class8;
import rockstar.client.RockstarClient;
import rockstar.client.IiiIi_Class14;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiIIiii_Class296;
import rockstar.client.iIiiIIiII_Class357;
import rockstar.client.iIiiIIiii_Class360;

public class IIIiiI_Class7
implements iIIiIIiIi_Class294,
iIIiIIiii_Class296 {
    private static final float I_field_46 = 0.5f;
    private final iIiiIIiII_Class357 I_field_cb35e4c = new iIiiIIiII_Class357(false).I_method_cc37aab5();
    private final iIiiIIiII_Class357 i_field_cb35e4c = new iIiiIIiII_Class357(false).I_method_cc37aab5().I_method_7d3fafd7(0.5f);
    private IIIiii_Class8 I_field_83b91601;
    private IiiIi_Class14 I_field_2f5b1d2c;

    public void I_method_800d826c() {
        if (this.I_field_83b91601 != null) {
            return;
        }
        this.I_field_83b91601 = new IIIiii_Class8(RockstarClient.id("volumetric_fog/data"));
        this.I_field_2f5b1d2c = new IiiIi_Class14(RockstarClient.id("volumetric_fog/tent/data"), VertexFormats.POSITION_TEXTURE_COLOR);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void I_method_76c1437e(Matrix4f matrix4f, IIIiii_Class8.Nested1_b512cb53 nested1_b512cb53) {
        if (this.I_field_83b91601 == null || this.I_field_2f5b1d2c == null || nested1_b512cb53.I_field_49 == 0) {
            return;
        }
        Framebuffer framebuffer = I_field_3a9bda27.getFramebuffer();
        if (framebuffer == null || framebuffer.getDepthAttachment() == 0) {
            return;
        }
        int n = I_field_587075c2.getScaledWidth();
        int n2 = I_field_587075c2.getScaledHeight();
        if (n <= 0 || n2 <= 0) {
            return;
        }
        int n3 = framebuffer.getDepthAttachment();
        RenderSystem.disableBlend();
        RenderSystem.depthMask((boolean)false);
        RenderSystem.backupProjectionMatrix();
        Matrix4f matrix4f2 = new Matrix4f().setOrtho(0.0f, (float)n, (float)n2, 0.0f, 1000.0f, 21000.0f);
        RenderSystem.setProjectionMatrix((Matrix4f)matrix4f2, (ProjectionType)ProjectionType.ORTHOGRAPHIC);
        Matrix4fStack matrix4fStack = RenderSystem.getModelViewStack();
        matrix4fStack.pushMatrix();
        matrix4fStack.identity().translate(0.0f, 0.0f, -11000.0f);
        try {
            this.I_field_cb35e4c.I_method_7d3fafd7(nested1_b512cb53.I_field_5a ? 1.0f : 0.5f);
            this.I_field_cb35e4c.I_method_53fdf4b5(true);
            this.I_field_83b91601.I_method_33f6c16b();
            this.I_field_83b91601.I_method_e824fb9e(matrix4f, nested1_b512cb53);
            RenderSystem.setShaderTexture((int)0, (int)n3);
            RenderSystem.setShaderTexture((int)1, (int)nested1_b512cb53.I_field_49);
            iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, n, n2);
            this.I_field_cb35e4c.i_method_766109df();
            iIiiIIiII_Class357 iIiiIIiII_Class3572 = this.I_field_cb35e4c;
            if (!nested1_b512cb53.I_field_5a) {
                this.i_field_cb35e4c.I_method_53fdf4b5(true);
                this.I_field_2f5b1d2c.I_method_33f6c16b();
                GlUniform glUniform = this.I_field_2f5b1d2c.I_method_cb7dbe45("TexelSize");
                if (glUniform != null) {
                    glUniform.set(1.0f / (float)Math.max(this.I_field_cb35e4c.textureWidth, 1), 1.0f / (float)Math.max(this.I_field_cb35e4c.textureHeight, 1));
                }
                this.I_field_cb35e4c.beginRead();
                RenderSystem.setShaderTexture((int)0, (int)this.I_field_cb35e4c.getColorAttachment());
                iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, n, n2);
                this.I_field_cb35e4c.endRead();
                this.i_field_cb35e4c.i_method_766109df();
                iIiiIIiII_Class3572 = this.i_field_cb35e4c;
            }
            RenderSystem.enableBlend();
            RenderSystem.blendFunc((GlStateManager.SrcFactor)GlStateManager.SrcFactor.ONE, (GlStateManager.DstFactor)GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA);
            RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_TEX_COLOR);
            RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            iIiiIIiII_Class3572.beginRead();
            RenderSystem.setShaderTexture((int)0, (int)iIiiIIiII_Class3572.getColorAttachment());
            iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, n, n2);
            iIiiIIiII_Class3572.endRead();
            RenderSystem.setShaderTexture((int)1, (int)0);
            RenderSystem.setShaderTexture((int)0, (int)0);
        }
        finally {
            matrix4fStack.popMatrix();
            RenderSystem.restoreProjectionMatrix();
            RenderSystem.depthMask((boolean)true);
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
        }
    }
}

