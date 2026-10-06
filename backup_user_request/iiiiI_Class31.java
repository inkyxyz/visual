package rockstar.client;

import com.mojang.blaze3d.systems.ProjectionType;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.List;
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
import rockstar.client.iiiii_Class32;

public class iiiiI_Class31
implements iIIiIIiIi_Class294,
iIIiIIiii_Class296 {
    private final iIiiIIiII_Class357 I_field_cb35e4c = new iIiiIIiII_Class357(false).I_method_cc37aab5();
    private iiiii_Class32 I_field_65f6a92c;

    public void I_method_8fa4beff() {
        if (this.I_field_65f6a92c != null) {
            return;
        }
        this.I_field_65f6a92c = new iiiii_Class32(RockstarClient.id("particle_light/data"));
    }

    public void I_method_6b5b11c2(Matrix4f matrix4f, float f, List<iiiii_Class32.Nested1_88680fa0> list) {
        if (this.I_field_65f6a92c == null || list == null || list.isEmpty()) {
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
        this.I_field_cb35e4c.I_method_53fdf4b5(false);
        this.I_field_65f6a92c.I_method_33f6c16b();
        this.I_field_65f6a92c.I_method_5801b5a2(matrix4f, f, list);
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
        matrix4fStack.popMatrix();
        RenderSystem.restoreProjectionMatrix();
        RenderSystem.depthMask((boolean)true);
        RenderSystem.enableBlend();
    }
}

