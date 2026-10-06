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

public class IIIIII
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
    private GlUniform III_field_e7180c72;
    private GlUniform IIi_field_e7180c72;
    private GlUniform IiI_field_e7180c72;

    public IIIIII(Identifier identifier) {
        super(identifier, VertexFormats.POSITION_TEXTURE_COLOR);
    }

    @Override
    protected void I_method_e7207e6c() {
        this.I_field_e7180c72 = this.I_method_cb7dbe45("InvViewProj");
        this.i_field_e7180c72 = this.I_method_cb7dbe45("CamPos");
        this.II_field_e7180c72 = this.I_method_cb7dbe45("Tint");
        this.Ii_field_e7180c72 = this.I_method_cb7dbe45("Time");
        this.iI_field_e7180c72 = this.I_method_cb7dbe45("Drops");
        this.ii_field_e7180c72 = this.I_method_cb7dbe45("Splashes");
        this.III_field_e7180c72 = this.I_method_cb7dbe45("Aspect");
        this.IIi_field_e7180c72 = this.I_method_cb7dbe45("Roof");
        this.IiI_field_e7180c72 = this.I_method_cb7dbe45("RoofSpan");
        super.I_method_e7207e6c();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void I_method_44cfaf9e(Matrix4f matrix4f, Nested1_b340d733 nested1_b340d733) {
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
            this.I_field_cb35e4c.I_method_53fdf4b5(false);
            this.I_method_33f6c16b();
            this.I_method_5526abe2(matrix4f, nested1_b340d733, (float)n / (float)n2);
            framebuffer.beginRead();
            RenderSystem.setShaderTexture((int)0, (int)framebuffer.getColorAttachment());
            RenderSystem.setShaderTexture((int)1, (int)n3);
            RenderSystem.setShaderTexture((int)2, (int)nested1_b340d733.I_field_49);
            iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, n, n2);
            framebuffer.endRead();
            this.I_field_cb35e4c.i_method_766109df();
            RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_TEX_COLOR);
            RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            this.I_field_cb35e4c.beginRead();
            RenderSystem.setShaderTexture((int)0, (int)this.I_field_cb35e4c.getColorAttachment());
            iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, n, n2);
            this.I_field_cb35e4c.endRead();
            RenderSystem.setShaderTexture((int)2, (int)0);
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

    private void I_method_5526abe2(Matrix4f matrix4f, Nested1_b340d733 nested1_b340d733, float f) {
        if (this.I_field_e7180c72 != null) {
            this.I_field_e7180c72.set(matrix4f);
        }
        if (this.i_field_e7180c72 != null) {
            this.i_field_e7180c72.set(nested1_b340d733.I_field_46, nested1_b340d733.i_field_46, nested1_b340d733.II_field_46);
        }
        if (this.II_field_e7180c72 != null) {
            this.II_field_e7180c72.set(nested1_b340d733.Ii_field_46, nested1_b340d733.iI_field_46, nested1_b340d733.ii_field_46);
        }
        if (this.Ii_field_e7180c72 != null) {
            this.Ii_field_e7180c72.set(nested1_b340d733.III_field_46);
        }
        if (this.iI_field_e7180c72 != null) {
            this.iI_field_e7180c72.set(nested1_b340d733.IIi_field_46);
        }
        if (this.ii_field_e7180c72 != null) {
            this.ii_field_e7180c72.set(nested1_b340d733.IiI_field_46);
        }
        if (this.III_field_e7180c72 != null) {
            this.III_field_e7180c72.set(f);
        }
        if (this.IIi_field_e7180c72 != null) {
            this.IIi_field_e7180c72.set(nested1_b340d733.Iii_field_46, nested1_b340d733.iII_field_46, nested1_b340d733.iIi_field_46, nested1_b340d733.iiI_field_46);
        }
        if (this.IiI_field_e7180c72 != null) {
            this.IiI_field_e7180c72.set(nested1_b340d733.iii_field_46);
        }
    }

    public static final class Nested1_b340d733 {
        public float I_field_46;
        public float i_field_46;
        public float II_field_46;
        public float Ii_field_46 = 0.7f;
        public float iI_field_46 = 0.78f;
        public float ii_field_46 = 0.85f;
        public float III_field_46;
        public float IIi_field_46 = 0.6f;
        public float IiI_field_46 = 0.6f;
        public float Iii_field_46;
        public float iII_field_46;
        public float iIi_field_46;
        public float iiI_field_46;
        public float iii_field_46 = 192.0f;
        public int I_field_49;
    }
}

