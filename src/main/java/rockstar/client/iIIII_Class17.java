package rockstar.client;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gl.Framebuffer;
import org.lwjgl.opengl.GL11;
import rockstar.client.RockstarClient;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiIIiii_Class296;
import rockstar.client.iIiiIIiII_Class357;
import rockstar.client.iIiiIIiii_Class360;
import rockstar.client.iIiiiiIii_Class380;
import rockstar.client.iiIiIIiii_Class424;
import rockstar.client.iiiII_Class29;

public class iIIII_Class17
implements iIIiIIiIi_Class294,
iIIiIIiii_Class296 {
    private static final long I_field_4a = 25L;
    public static final int I_field_49 = 0;
    public static final int i_field_49 = 1;
    private final List<Nested1_4ffb07a0> I_field_7865b31 = new ArrayList<Nested1_4ffb07a0>();
    private iiiII_Class29 I_field_65f62d2c;
    private iiiII_Class29 i_field_65f62d2c;
    private float I_field_46 = 0.5f;

    public void I_method_6e29dadf() {
        this.I_field_65f62d2c = new iiiII_Class29(RockstarClient.id("kawase_down/data"));
        this.i_field_65f62d2c = new iiiII_Class29(RockstarClient.id("kawase_up/data"));
    }

    private Nested1_4ffb07a0 I_method_13ba1295(int n) {
        while (this.I_field_7865b31.size() <= n) {
            this.I_field_7865b31.add(new Nested1_4ffb07a0());
        }
        return this.I_field_7865b31.get(n);
    }

    public void i_method_6e3866bf() {
        for (Nested1_4ffb07a0 nested1_4ffb07a0 : this.I_field_7865b31) {
            nested1_4ffb07a0.I_field_5a = true;
        }
    }

    public void I_method_5711f404(int n) {
        this.I_method_13ba1295((int)n).I_field_5a = true;
    }

    public boolean I_method_6e29dae3() {
        return this.I_method_5711f408(0);
    }

    public boolean I_method_5711f408(int n) {
        return n >= 0 && n < this.I_field_7865b31.size() && this.I_field_7865b31.get((int)n).i_field_5a;
    }

    public void I_method_5711e8c1(float f) {
        this.I_method_8b2cf43c(0, f);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void I_method_8b2cf43c(int n, float f) {
        if (this.I_field_65f62d2c == null || RockstarClient.getInstance().i_method_e8604970()) {
            return;
        }
        if (iIiiiiIii_Class380.I_field_5a) {
            return;
        }
        Nested1_4ffb07a0 nested1_4ffb07a0 = this.I_method_13ba1295(n);
        if (!nested1_4ffb07a0.I_field_5a && !nested1_4ffb07a0.I_field_991c1e8c.I_method_58432069(25L)) {
            return;
        }
        nested1_4ffb07a0.I_field_5a = false;
        nested1_4ffb07a0.I_field_991c1e8c.I_method_23e11e3f();
        Framebuffer framebuffer = I_field_3a9bda27.getFramebuffer();
        iIiiIIiII_Class357 iIiiIIiII_Class3572 = (iIiiIIiII_Class357)nested1_4ffb07a0.I_field_4b431d79.get();
        iIiiIIiII_Class357 iIiiIIiII_Class3573 = (iIiiIIiII_Class357)nested1_4ffb07a0.i_field_4b431d79.get();
        iIiiIIiII_Class3572.I_method_7d3fafd7(this.I_field_46).I_method_cc37aab5();
        iIiiIIiII_Class3573.I_method_7d3fafd7(this.I_field_46).I_method_cc37aab5();
        boolean bl = GL11.glIsEnabled((int)3089);
        if (bl) {
            GL11.glDisable((int)3089);
        }
        try {
            int n2;
            int n3;
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            this.I_field_65f62d2c.I_method_33f6c16b();
            this.I_field_65f62d2c.I_method_6d1420e1(f, framebuffer.textureWidth, framebuffer.textureHeight);
            iIiiIIiII_Class3572.I_method_76527dff();
            framebuffer.beginRead();
            RenderSystem.setShaderTexture((int)0, (int)framebuffer.getColorAttachment());
            iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, I_field_587075c2.getScaledWidth(), I_field_587075c2.getScaledHeight());
            iIiiIIiII_Class3572.i_method_766109df();
            iIiiIIiII_Class357[] iIiiIIiII_Class357Array = new iIiiIIiII_Class357[]{iIiiIIiII_Class3572, iIiiIIiII_Class3573};
            int n4 = f > 5.0f ? 7 : (f > 3.0f ? 5 : 3);
            for (n3 = 1; n3 < n4; ++n3) {
                n2 = n3 % 2;
                iIiiIIiII_Class357Array[n2].I_method_76527dff();
                iIiiIIiII_Class357Array[(n2 + 1) % 2].beginRead();
                RenderSystem.setShaderTexture((int)0, (int)iIiiIIiII_Class357Array[(n2 + 1) % 2].getColorAttachment());
                this.I_field_65f62d2c.I_method_6d1420e1(f, iIiiIIiII_Class357Array[(n2 + 1) % 2].textureWidth, iIiiIIiII_Class357Array[(n2 + 1) % 2].textureHeight);
                iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, I_field_587075c2.getScaledWidth(), I_field_587075c2.getScaledHeight());
                iIiiIIiII_Class357Array[(n2 + 1) % 2].endRead();
                iIiiIIiII_Class357Array[n2].i_method_766109df();
            }
            this.i_field_65f62d2c.I_method_33f6c16b();
            for (n3 = 0; n3 < n4; ++n3) {
                n2 = n3 % 2;
                iIiiIIiII_Class357Array[(n2 + 1) % 2].I_method_76527dff();
                iIiiIIiII_Class357Array[n2].beginRead();
                RenderSystem.setShaderTexture((int)0, (int)iIiiIIiII_Class357Array[n2].getColorAttachment());
                this.i_field_65f62d2c.I_method_6d1420e1(f, iIiiIIiII_Class357Array[n2].textureWidth, iIiiIIiII_Class357Array[n2].textureHeight);
                iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, I_field_587075c2.getScaledWidth(), I_field_587075c2.getScaledHeight());
                iIiiIIiII_Class357Array[n2].endRead();
                iIiiIIiII_Class357Array[n2].i_method_766109df();
            }
            framebuffer.endRead();
            RenderSystem.setShaderTexture((int)0, (int)0);
            RenderSystem.disableBlend();
            nested1_4ffb07a0.i_field_5a = true;
        }
        finally {
            if (bl) {
                GL11.glEnable((int)3089);
            }
        }
    }

    public int I_method_6e29dad2() {
        return this.I_method_5711f3f7(0);
    }

    public int I_method_5711f3f7(int n) {
        return ((iIiiIIiII_Class357)this.I_method_13ba1295((int)n).i_field_4b431d79.get()).getColorAttachment();
    }

    static final class Nested1_4ffb07a0 {
        final Supplier<iIiiIIiII_Class357> I_field_4b431d79 = Suppliers.memoize(() -> new iIiiIIiII_Class357(false).I_method_cc37aab5());
        final Supplier<iIiiIIiII_Class357> i_field_4b431d79 = Suppliers.memoize(() -> new iIiiIIiII_Class357(false).I_method_cc37aab5());
        final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
        boolean I_field_5a = true;
        boolean i_field_5a = false;

        Nested1_4ffb07a0() {
        }
    }
}

