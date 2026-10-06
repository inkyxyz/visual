package rockstar.client;

import com.mojang.blaze3d.systems.ProjectionType;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.GlUniform;
import net.minecraft.client.gl.ShaderProgramKey;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;
import rockstar.client.IiiIi_Class14;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiIIiii_Class296;
import rockstar.client.iIiiIIiII_Class357;
import rockstar.client.iIiiIIiii_Class360;

public class IIIIIi_Class2
extends IiiIi_Class14
implements iIIiIIiIi_Class294,
iIIiIIiii_Class296 {
    private final iIiiIIiII_Class357 I_field_cb35e4c = new iIiiIIiII_Class357(false).I_method_cc37aab5();
    private GlUniform I_field_e7180c72;
    private GlUniform i_field_e7180c72;
    private GlUniform II_field_e7180c72;
    private GlUniform Ii_field_e7180c72;
    private GlUniform iI_field_e7180c72;
    private GlUniform ii_field_e7180c72;

    public IIIIIi_Class2(Identifier identifier) {
        super(identifier, VertexFormats.POSITION_TEXTURE_COLOR);
    }

    @Override
    protected void I_method_e7207e6c() {
        this.I_field_e7180c72 = this.I_method_cb7dbe45("IsolationStrength");
        this.i_field_e7180c72 = this.I_method_cb7dbe45("IsolationColor");
        this.II_field_e7180c72 = this.I_method_cb7dbe45("HueTolerance");
        this.Ii_field_e7180c72 = this.I_method_cb7dbe45("MinSat");
        this.iI_field_e7180c72 = this.I_method_cb7dbe45("MinVal");
        this.ii_field_e7180c72 = this.I_method_cb7dbe45("BackgroundSat");
        super.I_method_e7207e6c();
    }

    public void I_method_5a664c(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        Framebuffer framebuffer = I_field_3a9bda27.getFramebuffer();
        if (framebuffer == null) {
            return;
        }
        int n = I_field_587075c2.getScaledWidth();
        int n2 = I_field_587075c2.getScaledHeight();
        RenderSystem.disableBlend();
        RenderSystem.depthMask((boolean)false);
        RenderSystem.backupProjectionMatrix();
        Matrix4f matrix4f = new Matrix4f().setOrtho(0.0f, (float)n, (float)n2, 0.0f, 1000.0f, 21000.0f);
        RenderSystem.setProjectionMatrix((Matrix4f)matrix4f, (ProjectionType)ProjectionType.ORTHOGRAPHIC);
        Matrix4fStack matrix4fStack = RenderSystem.getModelViewStack();
        matrix4fStack.pushMatrix();
        matrix4fStack.identity().translate(0.0f, 0.0f, -11000.0f);
        this.I_field_cb35e4c.I_method_76527dff();
        RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_TEX_COLOR);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        framebuffer.beginRead();
        RenderSystem.setShaderTexture((int)0, (int)framebuffer.getColorAttachment());
        iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, n, n2);
        framebuffer.endRead();
        this.I_field_cb35e4c.i_method_766109df();
        this.I_method_33f6c16b();
        if (this.I_field_e7180c72 != null) {
            this.I_field_e7180c72.set(f);
        }
        if (this.i_field_e7180c72 != null) {
            this.i_field_e7180c72.set(f2, f3, f4);
        }
        if (this.II_field_e7180c72 != null) {
            this.II_field_e7180c72.set(f5);
        }
        if (this.Ii_field_e7180c72 != null) {
            this.Ii_field_e7180c72.set(f6);
        }
        if (this.iI_field_e7180c72 != null) {
            this.iI_field_e7180c72.set(f7);
        }
        if (this.ii_field_e7180c72 != null) {
            this.ii_field_e7180c72.set(f8);
        }
        this.I_field_cb35e4c.beginRead();
        RenderSystem.setShaderTexture((int)0, (int)this.I_field_cb35e4c.getColorAttachment());
        iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, n, n2);
        this.I_field_cb35e4c.endRead();
        RenderSystem.setShaderTexture((int)0, (int)0);
        matrix4fStack.popMatrix();
        RenderSystem.restoreProjectionMatrix();
        RenderSystem.depthMask((boolean)true);
    }
}

