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

public class IIiIII_Class9
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
    private GlUniform Iii_field_e7180c72;
    private GlUniform iII_field_e7180c72;
    private GlUniform iIi_field_e7180c72;
    private GlUniform iiI_field_e7180c72;
    private GlUniform iii_field_e7180c72;

    public IIiIII_Class9(Identifier identifier) {
        super(identifier, VertexFormats.POSITION_TEXTURE_COLOR);
    }

    @Override
    protected void I_method_e7207e6c() {
        this.I_field_e7180c72 = this.I_method_cb7dbe45("ViewProj");
        this.i_field_e7180c72 = this.I_method_cb7dbe45("InvViewProj");
        this.II_field_e7180c72 = this.I_method_cb7dbe45("CamPos");
        this.Ii_field_e7180c72 = this.I_method_cb7dbe45("SkyTint");
        this.iI_field_e7180c72 = this.I_method_cb7dbe45("SunDir");
        this.ii_field_e7180c72 = this.I_method_cb7dbe45("Reflectivity");
        this.III_field_e7180c72 = this.I_method_cb7dbe45("Wetness");
        this.IIi_field_e7180c72 = this.I_method_cb7dbe45("Ripple");
        this.IiI_field_e7180c72 = this.I_method_cb7dbe45("Gloss");
        this.Iii_field_e7180c72 = this.I_method_cb7dbe45("Steps");
        this.iII_field_e7180c72 = this.I_method_cb7dbe45("HitThickness");
        this.iIi_field_e7180c72 = this.I_method_cb7dbe45("MaxDistance");
        this.iiI_field_e7180c72 = this.I_method_cb7dbe45("UpOnly");
        this.iii_field_e7180c72 = this.I_method_cb7dbe45("Time");
        super.I_method_e7207e6c();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void I_method_49242388(Nested1_e9dbeb13 nested1_e9dbeb13) {
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
        Matrix4f matrix4f = new Matrix4f().setOrtho(0.0f, (float)n, (float)n2, 0.0f, 1000.0f, 21000.0f);
        RenderSystem.setProjectionMatrix((Matrix4f)matrix4f, (ProjectionType)ProjectionType.ORTHOGRAPHIC);
        Matrix4fStack matrix4fStack = RenderSystem.getModelViewStack();
        matrix4fStack.pushMatrix();
        matrix4fStack.identity().translate(0.0f, 0.0f, -11000.0f);
        try {
            this.I_field_cb35e4c.I_method_53fdf4b5(false);
            this.I_method_33f6c16b();
            this.i_method_5eb99768(nested1_e9dbeb13);
            framebuffer.beginRead();
            RenderSystem.setShaderTexture((int)0, (int)framebuffer.getColorAttachment());
            RenderSystem.setShaderTexture((int)1, (int)n3);
            iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, n, n2);
            framebuffer.endRead();
            this.I_field_cb35e4c.i_method_766109df();
            RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_TEX_COLOR);
            RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            this.I_field_cb35e4c.beginRead();
            RenderSystem.setShaderTexture((int)0, (int)this.I_field_cb35e4c.getColorAttachment());
            iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, n, n2);
            this.I_field_cb35e4c.endRead();
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

    private void i_method_5eb99768(Nested1_e9dbeb13 nested1_e9dbeb13) {
        if (this.I_field_e7180c72 != null) {
            this.I_field_e7180c72.set(nested1_e9dbeb13.I_field_d754d74);
        }
        if (this.i_field_e7180c72 != null) {
            this.i_field_e7180c72.set(nested1_e9dbeb13.i_field_d754d74);
        }
        if (this.II_field_e7180c72 != null) {
            this.II_field_e7180c72.set(nested1_e9dbeb13.I_field_46, nested1_e9dbeb13.i_field_46, nested1_e9dbeb13.II_field_46);
        }
        if (this.Ii_field_e7180c72 != null) {
            this.Ii_field_e7180c72.set(nested1_e9dbeb13.Ii_field_46, nested1_e9dbeb13.iI_field_46, nested1_e9dbeb13.ii_field_46);
        }
        if (this.iI_field_e7180c72 != null) {
            this.iI_field_e7180c72.set(nested1_e9dbeb13.III_field_46, nested1_e9dbeb13.IIi_field_46, nested1_e9dbeb13.IiI_field_46);
        }
        if (this.ii_field_e7180c72 != null) {
            this.ii_field_e7180c72.set(nested1_e9dbeb13.Iii_field_46);
        }
        if (this.III_field_e7180c72 != null) {
            this.III_field_e7180c72.set(nested1_e9dbeb13.iII_field_46);
        }
        if (this.IIi_field_e7180c72 != null) {
            this.IIi_field_e7180c72.set(nested1_e9dbeb13.iIi_field_46);
        }
        if (this.IiI_field_e7180c72 != null) {
            this.IiI_field_e7180c72.set(nested1_e9dbeb13.iiI_field_46);
        }
        if (this.Iii_field_e7180c72 != null) {
            this.Iii_field_e7180c72.set(nested1_e9dbeb13.iii_field_46);
        }
        if (this.iII_field_e7180c72 != null) {
            this.iII_field_e7180c72.set(nested1_e9dbeb13.IIII_field_46);
        }
        if (this.iIi_field_e7180c72 != null) {
            this.iIi_field_e7180c72.set(nested1_e9dbeb13.IIIi_field_46);
        }
        if (this.iiI_field_e7180c72 != null) {
            this.iiI_field_e7180c72.set(nested1_e9dbeb13.IIiI_field_46);
        }
        if (this.iii_field_e7180c72 != null) {
            this.iii_field_e7180c72.set(nested1_e9dbeb13.IIii_field_46);
        }
    }

    public static final class Nested1_e9dbeb13 {
        public final Matrix4f I_field_d754d74 = new Matrix4f();
        public final Matrix4f i_field_d754d74 = new Matrix4f();
        public float I_field_46;
        public float i_field_46;
        public float II_field_46;
        public float Ii_field_46 = 0.45f;
        public float iI_field_46 = 0.6f;
        public float ii_field_46 = 0.9f;
        public float III_field_46;
        public float IIi_field_46 = 1.0f;
        public float IiI_field_46;
        public float Iii_field_46 = 0.7f;
        public float iII_field_46 = 0.6f;
        public float iIi_field_46 = 0.35f;
        public float iiI_field_46 = 0.5f;
        public float iii_field_46 = 24.0f;
        public float IIII_field_46 = 0.6f;
        public float IIIi_field_46 = 24.0f;
        public float IIiI_field_46 = 1.0f;
        public float IIii_field_46;
    }
}

