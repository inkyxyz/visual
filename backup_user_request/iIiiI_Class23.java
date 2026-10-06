package rockstar.client;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.mojang.blaze3d.systems.RenderSystem;
import lombok.Generated;
import rockstar.client.RockstarClient;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiIIiii_Class296;
import rockstar.client.iIiII_Class21;
import rockstar.client.iIiiIIiII_Class357;
import rockstar.client.iIiiIIiii_Class360;
import ua.mintantileak.spk.Compile;

public class iIiiI_Class23
implements iIIiIIiIi_Class294,
iIIiIIiii_Class296 {
    private static final float I_field_46 = 0.5f;
    public static final Supplier<iIiiIIiII_Class357> I_field_4b431d79 = Suppliers.memoize(() -> new iIiiIIiII_Class357(false).I_method_cc37aab5().I_method_7d3fafd7(0.5f));
    public static final Supplier<iIiiIIiII_Class357> i_field_4b431d79 = Suppliers.memoize(() -> new iIiiIIiII_Class357(false).I_method_cc37aab5().I_method_7d3fafd7(0.5f));
    public static final Supplier<iIiiIIiII_Class357> II_field_4b431d79 = Suppliers.memoize(() -> new iIiiIIiII_Class357(false).I_method_cc37aab5());
    private static iIiII_Class21 I_field_64333d0c;
    private static iIiII_Class21 i_field_64333d0c;
    private static iIiII_Class21 II_field_64333d0c;
    private final Supplier<iIiiIIiII_Class357> Ii_field_4b431d79;
    private final Supplier<iIiiIIiII_Class357> iI_field_4b431d79;
    private final Supplier<iIiiIIiII_Class357> ii_field_4b431d79;
    private float i_field_46 = 2.5f;
    private float II_field_46 = 7.0f;
    private int I_field_49 = 8;
    private int i_field_49 = 3;
    private float Ii_field_46 = 1.0f;
    private float iI_field_46 = 1.0f;
    private float ii_field_46 = 0.0f;
    private float III_field_46 = 0.0f;

    public iIiiI_Class23() {
        this(I_field_4b431d79, i_field_4b431d79, II_field_4b431d79);
    }

    public iIiiI_Class23(Supplier<iIiiIIiII_Class357> supplier, Supplier<iIiiIIiII_Class357> supplier2, Supplier<iIiiIIiII_Class357> supplier3) {
        this.Ii_field_4b431d79 = supplier;
        this.iI_field_4b431d79 = supplier2;
        this.ii_field_4b431d79 = supplier3;
    }

    public static iIiiI_Class23 I_method_e3b16f5() {
        Supplier supplier = Suppliers.memoize(() -> new iIiiIIiII_Class357(false).I_method_cc37aab5().I_method_7d3fafd7(0.5f));
        Supplier supplier2 = Suppliers.memoize(() -> new iIiiIIiII_Class357(false).I_method_cc37aab5().I_method_7d3fafd7(0.5f));
        Supplier supplier3 = Suppliers.memoize(() -> new iIiiIIiII_Class357(false).I_method_cc37aab5());
        return new iIiiI_Class23((Supplier<iIiiIIiII_Class357>)supplier, (Supplier<iIiiIIiII_Class357>)supplier2, (Supplier<iIiiIIiII_Class357>)supplier3);
    }

    @Compile
    public void I_method_716dedf() {
        if (I_field_64333d0c == null) {
            I_field_64333d0c = new iIiII_Class21(RockstarClient.id("glow/blur_h/data"));
            i_field_64333d0c = new iIiII_Class21(RockstarClient.id("glow/blur_v/data"));
            II_field_64333d0c = new iIiII_Class21(RockstarClient.id("glow/composite/data"));
        }
    }

    public void I_method_6ef4bbc7(iIiiIIiII_Class357 iIiiIIiII_Class3572) {
        this.I_method_6119a907(iIiiIIiII_Class3572, -1, -1, -1, -1);
    }

    public void I_method_6119a907(iIiiIIiII_Class357 iIiiIIiII_Class3572, int n, int n2, int n3, int n4) {
        int n5;
        iIiiIIiII_Class357 iIiiIIiII_Class3573 = (iIiiIIiII_Class357)this.Ii_field_4b431d79.get();
        iIiiIIiII_Class357 iIiiIIiII_Class3574 = (iIiiIIiII_Class357)this.iI_field_4b431d79.get();
        iIiiIIiII_Class357 iIiiIIiII_Class3575 = (iIiiIIiII_Class357)this.ii_field_4b431d79.get();
        int n6 = this.i_field_49;
        int n7 = I_field_587075c2.getScaledWidth();
        int n8 = I_field_587075c2.getScaledHeight();
        boolean bl = n >= 0;
        int n9 = I_field_3a9bda27.getWindow().getFramebufferWidth();
        int n10 = I_field_3a9bda27.getWindow().getFramebufferHeight();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        iIiiIIiII_Class3573.I_method_76527dff();
        if (bl) {
            iIiiI_Class23.I_method_8161e3a7(iIiiIIiII_Class3573, n, n2, n3, n4, n9, n10);
        }
        I_field_64333d0c.I_method_33f6c16b();
        I_field_64333d0c.I_method_76df7501(this.i_field_46, iIiiIIiII_Class3573.textureWidth, iIiiIIiII_Class3573.textureHeight);
        iIiiIIiII_Class3572.beginRead();
        RenderSystem.setShaderTexture((int)0, (int)iIiiIIiII_Class3572.getColorAttachment());
        for (n5 = 0; n5 < n6; ++n5) {
            iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, n7, n8);
        }
        iIiiIIiII_Class3572.endRead();
        if (bl) {
            RenderSystem.disableScissor();
        }
        iIiiIIiII_Class3573.i_method_766109df();
        iIiiIIiII_Class3574.I_method_76527dff();
        if (bl) {
            iIiiI_Class23.I_method_8161e3a7(iIiiIIiII_Class3574, n, n2, n3, n4, n9, n10);
        }
        i_field_64333d0c.I_method_33f6c16b();
        i_field_64333d0c.I_method_76df7501(this.i_field_46, iIiiIIiII_Class3573.textureWidth, iIiiIIiII_Class3573.textureHeight);
        iIiiIIiII_Class3573.beginRead();
        RenderSystem.setShaderTexture((int)0, (int)iIiiIIiII_Class3573.getColorAttachment());
        for (n5 = 0; n5 < n6; ++n5) {
            iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, n7, n8);
        }
        iIiiIIiII_Class3573.endRead();
        if (bl) {
            RenderSystem.disableScissor();
        }
        iIiiIIiII_Class3574.i_method_766109df();
        for (n5 = 1; n5 < this.I_field_49; ++n5) {
            int n11;
            iIiiIIiII_Class3573.I_method_76527dff();
            if (bl) {
                iIiiI_Class23.I_method_8161e3a7(iIiiIIiII_Class3573, n, n2, n3, n4, n9, n10);
            }
            I_field_64333d0c.I_method_33f6c16b();
            I_field_64333d0c.I_method_76df7501(this.i_field_46, iIiiIIiII_Class3573.textureWidth, iIiiIIiII_Class3573.textureHeight);
            iIiiIIiII_Class3574.beginRead();
            RenderSystem.setShaderTexture((int)0, (int)iIiiIIiII_Class3574.getColorAttachment());
            for (n11 = 0; n11 < n6; ++n11) {
                iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, n7, n8);
            }
            iIiiIIiII_Class3574.endRead();
            if (bl) {
                RenderSystem.disableScissor();
            }
            iIiiIIiII_Class3573.i_method_766109df();
            iIiiIIiII_Class3574.I_method_76527dff();
            if (bl) {
                iIiiI_Class23.I_method_8161e3a7(iIiiIIiII_Class3574, n, n2, n3, n4, n9, n10);
            }
            i_field_64333d0c.I_method_33f6c16b();
            i_field_64333d0c.I_method_76df7501(this.i_field_46, iIiiIIiII_Class3573.textureWidth, iIiiIIiII_Class3573.textureHeight);
            iIiiIIiII_Class3573.beginRead();
            RenderSystem.setShaderTexture((int)0, (int)iIiiIIiII_Class3573.getColorAttachment());
            for (n11 = 0; n11 < n6; ++n11) {
                iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, n7, n8);
            }
            iIiiIIiII_Class3573.endRead();
            if (bl) {
                RenderSystem.disableScissor();
            }
            iIiiIIiII_Class3574.i_method_766109df();
        }
        iIiiIIiII_Class3575.I_method_76527dff();
        if (bl) {
            iIiiI_Class23.I_method_8161e3a7(iIiiIIiII_Class3575, n, n2, n3, n4, n9, n10);
        }
        II_field_64333d0c.I_method_33f6c16b();
        II_field_64333d0c.I_method_90e6fc81(this.II_field_46, iIiiIIiII_Class3572.textureWidth, iIiiIIiII_Class3572.textureHeight, this.Ii_field_46, this.iI_field_46, this.ii_field_46, this.III_field_46);
        iIiiIIiII_Class3572.beginRead();
        RenderSystem.setShaderTexture((int)0, (int)iIiiIIiII_Class3572.getColorAttachment());
        RenderSystem.setShaderTexture((int)1, (int)iIiiIIiII_Class3574.getColorAttachment());
        iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, n7, n8);
        iIiiIIiII_Class3572.endRead();
        if (bl) {
            RenderSystem.disableScissor();
        }
        iIiiIIiII_Class3575.i_method_766109df();
        RenderSystem.setShaderTexture((int)0, (int)0);
        RenderSystem.setShaderTexture((int)1, (int)0);
        RenderSystem.disableBlend();
    }

    public void i_method_c0dc3e7(iIiiIIiII_Class357 iIiiIIiII_Class3572) {
        this.i_method_3c31a127(iIiiIIiII_Class3572, -1, -1, -1, -1);
    }

    public void i_method_3c31a127(iIiiIIiII_Class357 iIiiIIiII_Class3572, int n, int n2, int n3, int n4) {
        int n5;
        iIiiIIiII_Class357 iIiiIIiII_Class3573 = (iIiiIIiII_Class357)this.Ii_field_4b431d79.get();
        iIiiIIiII_Class357 iIiiIIiII_Class3574 = (iIiiIIiII_Class357)this.iI_field_4b431d79.get();
        int n6 = this.i_field_49;
        int n7 = I_field_587075c2.getScaledWidth();
        int n8 = I_field_587075c2.getScaledHeight();
        boolean bl = n >= 0;
        int n9 = I_field_3a9bda27.getWindow().getFramebufferWidth();
        int n10 = I_field_3a9bda27.getWindow().getFramebufferHeight();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        iIiiIIiII_Class3573.I_method_76527dff();
        if (bl) {
            iIiiI_Class23.I_method_8161e3a7(iIiiIIiII_Class3573, n, n2, n3, n4, n9, n10);
        }
        I_field_64333d0c.I_method_33f6c16b();
        I_field_64333d0c.I_method_76df7501(this.i_field_46, iIiiIIiII_Class3573.textureWidth, iIiiIIiII_Class3573.textureHeight);
        iIiiIIiII_Class3572.beginRead();
        RenderSystem.setShaderTexture((int)0, (int)iIiiIIiII_Class3572.getColorAttachment());
        for (n5 = 0; n5 < n6; ++n5) {
            iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, n7, n8);
        }
        iIiiIIiII_Class3572.endRead();
        if (bl) {
            RenderSystem.disableScissor();
        }
        iIiiIIiII_Class3573.i_method_766109df();
        iIiiIIiII_Class3574.I_method_76527dff();
        if (bl) {
            iIiiI_Class23.I_method_8161e3a7(iIiiIIiII_Class3574, n, n2, n3, n4, n9, n10);
        }
        i_field_64333d0c.I_method_33f6c16b();
        i_field_64333d0c.I_method_76df7501(this.i_field_46, iIiiIIiII_Class3573.textureWidth, iIiiIIiII_Class3573.textureHeight);
        iIiiIIiII_Class3573.beginRead();
        RenderSystem.setShaderTexture((int)0, (int)iIiiIIiII_Class3573.getColorAttachment());
        for (n5 = 0; n5 < n6; ++n5) {
            iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, n7, n8);
        }
        iIiiIIiII_Class3573.endRead();
        if (bl) {
            RenderSystem.disableScissor();
        }
        iIiiIIiII_Class3574.i_method_766109df();
        for (n5 = 1; n5 < this.I_field_49; ++n5) {
            int n11;
            iIiiIIiII_Class3573.I_method_76527dff();
            if (bl) {
                iIiiI_Class23.I_method_8161e3a7(iIiiIIiII_Class3573, n, n2, n3, n4, n9, n10);
            }
            I_field_64333d0c.I_method_33f6c16b();
            I_field_64333d0c.I_method_76df7501(this.i_field_46, iIiiIIiII_Class3573.textureWidth, iIiiIIiII_Class3573.textureHeight);
            iIiiIIiII_Class3574.beginRead();
            RenderSystem.setShaderTexture((int)0, (int)iIiiIIiII_Class3574.getColorAttachment());
            for (n11 = 0; n11 < n6; ++n11) {
                iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, n7, n8);
            }
            iIiiIIiII_Class3574.endRead();
            if (bl) {
                RenderSystem.disableScissor();
            }
            iIiiIIiII_Class3573.i_method_766109df();
            iIiiIIiII_Class3574.I_method_76527dff();
            if (bl) {
                iIiiI_Class23.I_method_8161e3a7(iIiiIIiII_Class3574, n, n2, n3, n4, n9, n10);
            }
            i_field_64333d0c.I_method_33f6c16b();
            i_field_64333d0c.I_method_76df7501(this.i_field_46, iIiiIIiII_Class3573.textureWidth, iIiiIIiII_Class3573.textureHeight);
            iIiiIIiII_Class3573.beginRead();
            RenderSystem.setShaderTexture((int)0, (int)iIiiIIiII_Class3573.getColorAttachment());
            for (n11 = 0; n11 < n6; ++n11) {
                iIiiIIiii_Class360.I_method_4355d27f(0.0f, 0.0f, n7, n8);
            }
            iIiiIIiII_Class3573.endRead();
            if (bl) {
                RenderSystem.disableScissor();
            }
            iIiiIIiII_Class3574.i_method_766109df();
        }
        RenderSystem.setShaderTexture((int)0, (int)0);
        RenderSystem.disableBlend();
    }

    private static void I_method_8161e3a7(iIiiIIiII_Class357 iIiiIIiII_Class3572, int n, int n2, int n3, int n4, int n5, int n6) {
        if (n5 <= 0 || n6 <= 0) {
            return;
        }
        float f = (float)iIiiIIiII_Class3572.textureWidth / (float)n5;
        float f2 = (float)iIiiIIiII_Class3572.textureHeight / (float)n6;
        int n7 = (int)Math.floor((float)n * f);
        int n8 = (int)Math.floor((float)n2 * f2);
        int n9 = (int)Math.ceil((float)n3 * f);
        int n10 = (int)Math.ceil((float)n4 * f2);
        if (n7 < 0) {
            n9 += n7;
            n7 = 0;
        }
        if (n8 < 0) {
            n10 += n8;
            n8 = 0;
        }
        if (n7 + n9 > iIiiIIiII_Class3572.textureWidth) {
            n9 = iIiiIIiII_Class3572.textureWidth - n7;
        }
        if (n8 + n10 > iIiiIIiII_Class3572.textureHeight) {
            n10 = iIiiIIiII_Class3572.textureHeight - n8;
        }
        if (n9 > 0 && n10 > 0) {
            RenderSystem.enableScissor((int)n7, (int)n8, (int)n9, (int)n10);
        }
    }

    public int I_method_716ded2() {
        return ((iIiiIIiII_Class357)this.ii_field_4b431d79.get()).getColorAttachment();
    }

    public int i_method_7256ab2() {
        return ((iIiiIIiII_Class357)this.iI_field_4b431d79.get()).getColorAttachment();
    }

    public iIiiIIiII_Class357 I_method_bd32b395() {
        return (iIiiIIiII_Class357)this.ii_field_4b431d79.get();
    }

    public iIiiIIiII_Class357 i_method_d2c82775() {
        return (iIiiIIiII_Class357)this.iI_field_4b431d79.get();
    }

    public static int II_method_dbd3f455() {
        return ((iIiiIIiII_Class357)II_field_4b431d79.get()).getColorAttachment();
    }

    @Generated
    public void I_method_dbc564c1(float f) {
        this.i_field_46 = f;
    }

    @Generated
    public void i_method_dd8854e1(float f) {
        this.II_field_46 = f;
    }

    @Generated
    public void I_method_dbc57004(int n) {
        this.I_field_49 = n;
    }

    @Generated
    public void i_method_dd886024(int n) {
        this.i_field_49 = n;
    }

    @Generated
    public void II_method_9eaaff9e(float f) {
        this.Ii_field_46 = f;
    }

    @Generated
    public void Ii_method_a06defbe(float f) {
        this.iI_field_46 = f;
    }

    @Generated
    public void iI_method_d546137e(float f) {
        this.ii_field_46 = f;
    }

    @Generated
    public void ii_method_d709039e(float f) {
        this.III_field_46 = f;
    }
}

