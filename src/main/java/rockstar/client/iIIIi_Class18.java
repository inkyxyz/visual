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
import rockstar.client.iiIiI_Class27;
import rockstar.client.iiIii_Class28;

public class iIIIi_Class18
implements iIIiIIiIi_Class294,
iIIiIIiii_Class296 {
    private final iIiiIIiII_Class357 I_field_cb35e4c = new iIiiIIiII_Class357(false).I_method_cc37aab5();
    private final iIiiIIiII_Class357 i_field_cb35e4c = new iIiiIIiII_Class357(false).I_method_cc37aab5();
    private iiIii_Class28 I_field_65e81d4c;

    public void I_method_a4c4eebf() {
        if (this.I_field_65e81d4c != null) {
            return;
        }
        this.I_field_65e81d4c = new iiIii_Class28(RockstarClient.id("blast_shockwave/data"));
    }

    public void I_method_7d5e4200(Matrix4f matrix4f, List<iiIiI_Class27.Nested1_86a4a760> list) {
        if (this.I_field_65e81d4c == null || list == null || list.isEmpty()) {
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
        int n4 = Math.min(list.size(), 12);
        RenderSystem.disableBlend();
        RenderSystem.depthMask((boolean)false);
        RenderSystem.backupProjectionMatrix();
        Matrix4f matrix4f2 = new Matrix4f().setOrtho(0.0f, (float)n, (float)n2, 0.0f, 1000.0f, 21000.0f);
        RenderSystem.setProjectionMatrix((Matrix4f)matrix4f2, (ProjectionType)ProjectionType.ORTHOGRAPHIC);
        Matrix4fStack matrix4fStack = RenderSystem.getModelViewStack();
        matrix4fStack.pushMatrix();
        matrix4fStack.identity().translate(0.0f, 0.0f, -11000.0f);
        iIiiIIiII_Class357[] iIiiIIiII_Class357Array = new iIiiIIiII_Class357[]{this.I_field_cb35e4c, this.i_field_cb35e4c};
        Framebuffer framebuffer2 = framebuffer;
        int n5 = 0;
        for (int i = 0; i < n4; ++i) {
            iIiiIIiII_Class357 iIiiIIiII_Class3572 = iIiiIIiII_Class357Array[n5];
            iIiiIIiII_Class3572.I_method_76527dff();
            this.I_field_65e81d4c.I_method_33f6c16b();
            this.I_field_65e81d4c.I_method_9a795172(matrix4f, list.get(i));
            framebuffer2.beginRead();
            RenderSystem.setShaderTexture((int)0, (int)framebuffer2.getColorAttachment());
            RenderSystem.setShaderTexture((int)1, (int)n3);
            iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, n, n2);
            framebuffer2.endRead();
            iIiiIIiII_Class3572.i_method_766109df();
            framebuffer2 = iIiiIIiII_Class3572;
            n5 ^= 1;
        }
        RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_TEX_COLOR);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        framebuffer2.beginRead();
        RenderSystem.setShaderTexture((int)0, (int)framebuffer2.getColorAttachment());
        iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, n, n2);
        framebuffer2.endRead();
        RenderSystem.setShaderTexture((int)1, (int)0);
        RenderSystem.setShaderTexture((int)0, (int)0);
        matrix4fStack.popMatrix();
        RenderSystem.restoreProjectionMatrix();
        RenderSystem.depthMask((boolean)true);
        RenderSystem.enableBlend();
    }
}

