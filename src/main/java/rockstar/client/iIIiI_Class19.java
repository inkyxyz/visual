package rockstar.client;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.mojang.blaze3d.systems.RenderSystem;
import lombok.Generated;
import net.minecraft.client.gl.Framebuffer;
import rockstar.client.InterfaceModule;
import rockstar.client.RockstarClient;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiIIiii_Class296;
import rockstar.client.iIiiIIiII_Class357;
import rockstar.client.iIiiIIiii_Class360;
import rockstar.client.iiIiIIiii_Class424;
import rockstar.client.iiiII_Class29;

public class iIIiI_Class19
implements iIIiIIiIi_Class294,
iIIiIIiii_Class296 {
    public static final Supplier<iIiiIIiII_Class357> I_field_4b431d79 = Suppliers.memoize(() -> new iIiiIIiII_Class357(false).I_method_cc37aab5());
    public static final Supplier<iIiiIIiII_Class357> i_field_4b431d79 = Suppliers.memoize(() -> new iIiiIIiII_Class357(false).I_method_cc37aab5());
    public static Framebuffer I_field_6c91f7d4;
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
    private static iiiII_Class29 I_field_65f62d2c;
    private static iiiII_Class29 i_field_65f62d2c;
    private float I_field_46 = 1.0f;
    private float i_field_46 = 0.5f;

    public void I_method_af142ff() {
        I_field_65f62d2c = new iiiII_Class29(RockstarClient.id("kawase_down/data"));
        i_field_65f62d2c = new iiiII_Class29(RockstarClient.id("kawase_up/data"));
    }

    public void i_method_affcedf() {
        this.I_method_533784a1(InterfaceModule.Iii_method_c4da86a3() ? 0.1f : 4.0f);
    }

    public void I_method_533784a1(float f) {
        int n;
        int n2;
        if (!this.I_field_991c1e8c.I_method_58432069(25L) || RockstarClient.getInstance().i_method_e8604970()) {
            return;
        }
        I_field_6c91f7d4 = I_field_3a9bda27.getFramebuffer();
        this.I_field_46 = f;
        iIiiIIiII_Class357 iIiiIIiII_Class3572 = (iIiiIIiII_Class357)I_field_4b431d79.get();
        iIiiIIiII_Class357 iIiiIIiII_Class3573 = (iIiiIIiII_Class357)i_field_4b431d79.get();
        iIiiIIiII_Class3572.I_method_7d3fafd7(this.i_field_46).I_method_cc37aab5();
        iIiiIIiII_Class3573.I_method_7d3fafd7(this.i_field_46).I_method_cc37aab5();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        I_field_65f62d2c.I_method_33f6c16b();
        I_field_65f62d2c.I_method_6d1420e1(this.I_field_46, iIIiI_Class19.I_field_6c91f7d4.textureWidth, iIIiI_Class19.I_field_6c91f7d4.textureHeight);
        iIiiIIiII_Class3572.I_method_76527dff();
        I_field_6c91f7d4.beginRead();
        RenderSystem.setShaderTexture((int)0, (int)I_field_6c91f7d4.getColorAttachment());
        iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, I_field_587075c2.getScaledWidth(), I_field_587075c2.getScaledHeight());
        iIiiIIiII_Class3572.i_method_766109df();
        iIiiIIiII_Class357[] iIiiIIiII_Class357Array = new iIiiIIiII_Class357[]{iIiiIIiII_Class3572, iIiiIIiII_Class3573};
        int n3 = this.I_field_46 > 5.0f ? 7 : (this.I_field_46 > 3.0f ? 5 : 3);
        for (n2 = 1; n2 < n3; ++n2) {
            n = n2 % 2;
            iIiiIIiII_Class357Array[n].I_method_76527dff();
            iIiiIIiII_Class357Array[(n + 1) % 2].beginRead();
            RenderSystem.setShaderTexture((int)0, (int)iIiiIIiII_Class357Array[(n + 1) % 2].getColorAttachment());
            I_field_65f62d2c.I_method_6d1420e1(this.I_field_46, iIiiIIiII_Class357Array[(n + 1) % 2].textureWidth, iIiiIIiII_Class357Array[(n + 1) % 2].textureHeight);
            iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, I_field_587075c2.getScaledWidth(), I_field_587075c2.getScaledHeight());
            iIiiIIiII_Class357Array[(n + 1) % 2].endRead();
            iIiiIIiII_Class357Array[n].i_method_766109df();
        }
        i_field_65f62d2c.I_method_33f6c16b();
        for (n2 = 0; n2 < n3; ++n2) {
            n = n2 % 2;
            iIiiIIiII_Class357Array[(n + 1) % 2].I_method_76527dff();
            iIiiIIiII_Class357Array[n].beginRead();
            RenderSystem.setShaderTexture((int)0, (int)iIiiIIiII_Class357Array[n].getColorAttachment());
            i_field_65f62d2c.I_method_6d1420e1(this.I_field_46, iIiiIIiII_Class357Array[n].textureWidth, iIiiIIiII_Class357Array[n].textureHeight);
            iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, I_field_587075c2.getScaledWidth(), I_field_587075c2.getScaledHeight());
            iIiiIIiII_Class357Array[n].endRead();
            iIiiIIiII_Class357Array[n].i_method_766109df();
        }
        I_field_6c91f7d4.endRead();
        RenderSystem.setShaderTexture((int)0, (int)0);
        RenderSystem.disableBlend();
        this.I_field_991c1e8c.I_method_23e11e3f();
    }

    public static int I_method_af142f2() {
        return ((iIiiIIiII_Class357)i_field_4b431d79.get()).getColorAttachment();
    }

    @Generated
    public void i_method_54fa74c1(float f) {
        this.I_field_46 = f;
    }

    @Generated
    public void II_method_157cdbbe(float f) {
        this.i_field_46 = f;
    }
}

