package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gl.Framebuffer;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiIIiii_Class296;

public class iIiiIIiII_Class357
extends Framebuffer
implements iIIiIIiIi_Class294,
iIIiIIiii_Class296 {
    private boolean I_field_5a;
    private float I_field_46 = 1.0f;

    public iIiiIIiII_Class357(boolean bl) {
        super(bl);
    }

    public iIiiIIiII_Class357(int n, int n2, boolean bl) {
        super(bl);
        this.resize(n, n2);
    }

    public iIiiIIiII_Class357 I_method_cc37aab5() {
        this.I_field_5a = true;
        if (this.colorAttachment > 0) {
            RenderSystem.recordRenderCall(() -> {
                if (this.colorAttachment > 0) {
                    this.setTexFilter(9729);
                }
            });
        }
        return this;
    }

    public void initFbo(int width, int height) {
        super.initFbo(width, height);
        if (this.I_field_5a) {
            super.setTexFilter(9729);
        }
    }

    public iIiiIIiII_Class357 I_method_7d3fafd7(float f) {
        this.I_field_46 = Math.max(0.1f, Math.min(1.0f, f));
        return this;
    }

    public void setTexFilter(int texFilter) {
        super.setTexFilter(this.I_field_5a ? 9729 : texFilter);
    }

    public void I_method_53fdf4b5(boolean bl) {
        this.II_method_540c3942();
        if (bl) {
            this.clear();
            this.setClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        }
        this.beginWrite(false);
    }

    public void I_method_76527dff() {
        this.I_method_53fdf4b5(true);
    }

    public void i_method_766109df() {
        this.endWrite();
        I_field_3a9bda27.getFramebuffer().beginWrite(true);
    }

    private void II_method_540c3942() {
        if (this.I_method_76527e03()) {
            int n = Math.max((int)Math.floor((float)I_field_3a9bda27.getWindow().getFramebufferWidth() * this.I_field_46), 1);
            int n2 = Math.max((int)Math.floor((float)I_field_3a9bda27.getWindow().getFramebufferHeight() * this.I_field_46), 1);
            if (this.fbo >= 0) {
                this.delete();
            }
            this.initFbo(n, n2);
        }
    }

    private boolean I_method_76527e03() {
        int n = Math.max((int)Math.floor((float)I_field_3a9bda27.getWindow().getFramebufferWidth() * this.I_field_46), 1);
        int n2 = Math.max((int)Math.floor((float)I_field_3a9bda27.getWindow().getFramebufferHeight() * this.I_field_46), 1);
        return this.textureWidth != n || this.textureHeight != n2;
    }
}

