package rockstar.client;

import com.mojang.blaze3d.systems.ProjectionType;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.ShaderProgramKey;
import net.minecraft.client.gl.ShaderProgramKeys;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;
import rockstar.client.RockstarClient;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiIIiii_Class296;
import rockstar.client.iIiiIIiII_Class357;
import rockstar.client.iIiiIIiii_Class360;
import rockstar.client.iiIII_Class25;

public class iIiii_Class24
implements iIIiIIiIi_Class294,
iIIiIIiii_Class296 {
    private final iIiiIIiII_Class357 I_field_cb35e4c = new iIiiIIiII_Class357(false).I_method_cc37aab5();
    private final iIiiIIiII_Class357 i_field_cb35e4c = new iIiiIIiII_Class357(false).I_method_cc37aab5();
    private iiIII_Class25 I_field_65e7a14c;

    public void I_method_3db1f2bf() {
        if (this.I_field_65e7a14c != null) {
            return;
        }
        this.I_field_65e7a14c = new iiIII_Class25(RockstarClient.id("heat_haze/data"));
    }

    public void I_method_8fc6f51c(int n, float f, float f2, float f3) {
        if (this.I_field_65e7a14c == null || n == 0 || f2 <= 0.001f) {
            return;
        }
        Framebuffer framebuffer = I_field_3a9bda27.getFramebuffer();
        if (framebuffer == null) {
            return;
        }
        int n2 = I_field_587075c2.getScaledWidth();
        int n3 = I_field_587075c2.getScaledHeight();
        if (n2 <= 0 || n3 <= 0) {
            return;
        }
        RenderSystem.disableBlend();
        RenderSystem.depthMask((boolean)false);
        RenderSystem.backupProjectionMatrix();
        Matrix4f matrix4f = new Matrix4f().setOrtho(0.0f, (float)n2, (float)n3, 0.0f, 1000.0f, 21000.0f);
        RenderSystem.setProjectionMatrix((Matrix4f)matrix4f, (ProjectionType)ProjectionType.ORTHOGRAPHIC);
        Matrix4fStack matrix4fStack = RenderSystem.getModelViewStack();
        matrix4fStack.pushMatrix();
        matrix4fStack.identity().translate(0.0f, 0.0f, -11000.0f);
        this.I_field_cb35e4c.I_method_76527dff();
        RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_TEX_COLOR);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        framebuffer.beginRead();
        RenderSystem.setShaderTexture((int)0, (int)framebuffer.getColorAttachment());
        iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, n2, n3);
        framebuffer.endRead();
        this.I_field_cb35e4c.i_method_766109df();
        this.i_field_cb35e4c.I_method_76527dff();
        this.I_field_65e7a14c.I_method_33f6c16b();
        this.I_field_65e7a14c.I_method_d07c6061(f3, f2, f);
        this.I_field_cb35e4c.beginRead();
        RenderSystem.setShaderTexture((int)0, (int)this.I_field_cb35e4c.getColorAttachment());
        RenderSystem.setShaderTexture((int)1, (int)n);
        iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, n2, n3);
        this.I_field_cb35e4c.endRead();
        this.i_field_cb35e4c.i_method_766109df();
        RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_TEX_COLOR);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.i_field_cb35e4c.beginRead();
        RenderSystem.setShaderTexture((int)0, (int)this.i_field_cb35e4c.getColorAttachment());
        iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, n2, n3);
        this.i_field_cb35e4c.endRead();
        RenderSystem.setShaderTexture((int)1, (int)0);
        RenderSystem.setShaderTexture((int)0, (int)0);
        matrix4fStack.popMatrix();
        RenderSystem.restoreProjectionMatrix();
        RenderSystem.depthMask((boolean)true);
    }
}

