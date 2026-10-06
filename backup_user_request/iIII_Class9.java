package rockstar.client;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec2f;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIii_Class4;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiI_Class3;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iIIIiIIiI_Class275;
import rockstar.client.iIiiiIiII_Class373;
import rockstar.client.iiI_Class7;

public class iIII_Class9
extends iiI_Class7 {
    private final Supplier<Vec2f> I_field_11b14ee4;
    private final Supplier<Vec2f> i_field_11b14ee4;
    private final Consumer<Vec2f> I_field_f9f609fa;
    private final Consumer<Vec2f> i_field_f9f609fa;
    private final IiI_Class3 I_field_b575d2cc = new IiI_Class3(IIii_Class4.I_method_3682ece9(500L, IiiiIiiII_Class237.II_field_dd60aac));
    private final IiI_Class3 i_field_b575d2cc = new IiI_Class3(IIii_Class4.I_method_3682ece9(500L, IiiiIiiII_Class237.II_field_dd60aac));
    private final IiI_Class3 II_field_b575d2cc = new IiI_Class3(IIii_Class4.I_method_3682ece9(500L, IiiiIiiII_Class237.II_field_dd60aac));
    private final IiI_Class3 Ii_field_b575d2cc = new IiI_Class3(IIii_Class4.I_method_3682ece9(500L, IiiiIiiII_Class237.II_field_dd60aac));
    private boolean I_field_5a;
    private boolean i_field_5a;
    private Function<iIII_Class9, ColorRGBA> I_field_aad1658 = iIII_Class92 -> IiiiiIIIi_Class242.IIi_field_d0c8ec5;
    private Function<iIII_Class9, ColorRGBA> i_field_aad1658 = iIII_Class92 -> IiiiiIIIi_Class242.IiI_field_d0c8ec5;
    private Function<iIII_Class9, ColorRGBA> II_field_aad1658 = iIII_Class92 -> ColorRGBA.WHITE.mulAlpha(0.55f + 0.15f * iIII_Class92.hover());
    private Function<iIII_Class9, ColorRGBA> Ii_field_aad1658 = iIII_Class92 -> ColorRGBA.WHITE;
    private Function<iIII_Class9, ColorRGBA> iI_field_aad1658 = iIII_Class92 -> ColorRGBA.WHITE.mulAlpha(0.45f);
    private Function<iIII_Class9, ColorRGBA> ii_field_aad1658 = iIII_Class92 -> ColorRGBA.WHITE;
    private float I_field_46 = 6.0f;
    private float i_field_46 = 4.0f;
    private float II_field_46 = 0.17f;
    private float Ii_field_46 = 3.0f;
    private float iI_field_46 = 2.0f;
    private float ii_field_46 = 3.0f;
    private float III_field_46 = 3.0f;
    private float IIi_field_46 = 1.5f;
    private float IiI_field_46 = 1.0f;

    public iIII_Class9(Supplier<Vec2f> supplier, Supplier<Vec2f> supplier2, Consumer<Vec2f> consumer, Consumer<Vec2f> consumer2) {
        this.I_field_11b14ee4 = supplier;
        this.i_field_11b14ee4 = supplier2;
        this.I_field_f9f609fa = consumer;
        this.i_field_f9f609fa = consumer2;
        Vec2f vec2f = supplier.get();
        Vec2f vec2f2 = supplier2.get();
        this.I_field_b575d2cc.i_method_84a13e41(vec2f.x);
        this.i_field_b575d2cc.i_method_84a13e41(vec2f.y);
        this.II_field_b575d2cc.i_method_84a13e41(vec2f2.x);
        this.Ii_field_b575d2cc.i_method_84a13e41(vec2f2.y);
        this.snapSize();
        this.cursor(iIIIiIIIi_Class274.i_field_aa52e62c);
        this.onClick(this::I_method_12b2037a);
    }

    public iIII_Class9 I_method_1b935984(ColorRGBA colorRGBA) {
        this.I_field_aad1658 = iIII_Class92 -> colorRGBA;
        return this;
    }

    public iIII_Class9 i_method_b9363d64(ColorRGBA colorRGBA) {
        this.i_field_aad1658 = iIII_Class92 -> colorRGBA;
        return this;
    }

    public iIII_Class9 II_method_2007f54d(ColorRGBA colorRGBA) {
        this.II_field_aad1658 = iIII_Class92 -> colorRGBA;
        return this;
    }

    public iIII_Class9 I_method_cff5a411(Function<iIII_Class9, ColorRGBA> function) {
        this.II_field_aad1658 = function;
        return this;
    }

    public iIII_Class9 Ii_method_bdaad92d(ColorRGBA colorRGBA) {
        this.Ii_field_aad1658 = iIII_Class92 -> colorRGBA;
        return this;
    }

    public iIII_Class9 iI_method_36c18d6d(ColorRGBA colorRGBA) {
        this.iI_field_aad1658 = iIII_Class92 -> colorRGBA;
        return this;
    }

    public iIII_Class9 ii_method_d464714d(ColorRGBA colorRGBA) {
        this.ii_field_aad1658 = iIII_Class92 -> colorRGBA;
        return this;
    }

    public iIII_Class9 I_method_b34002e3(float f) {
        this.I_field_46 = f;
        return this;
    }

    public iIII_Class9 i_method_ee6a66c3(float f) {
        this.i_field_46 = f;
        return this;
    }

    public iIII_Class9 II_method_790e02ac(float f) {
        this.II_field_46 = f;
        return this;
    }

    public iIII_Class9 Ii_method_b438668c(float f) {
        this.Ii_field_46 = f;
        return this;
    }

    public iIII_Class9 iI_method_a3301acc(float f) {
        this.iI_field_46 = f;
        return this;
    }

    public iIII_Class9 I_method_b9b351cb(float f, float f2) {
        this.ii_field_46 = f;
        this.III_field_46 = f2;
        return this;
    }

    public iIII_Class9 ii_method_de5a7eac(float f) {
        this.IIi_field_46 = f;
        return this;
    }

    public iIII_Class9 III_method_6cfffc03(float f) {
        this.IiI_field_46 = f;
        return this;
    }

    public iIII_Class9 I_method_b475c62a(IIii_Class4 iIii_Class4) {
        if (iIii_Class4 != null) {
            this.I_field_b575d2cc.I_method_15cf9df6(iIii_Class4);
            this.i_field_b575d2cc.I_method_15cf9df6(iIii_Class4);
            this.II_field_b575d2cc.I_method_15cf9df6(iIii_Class4);
            this.Ii_field_b575d2cc.I_method_15cf9df6(iIii_Class4);
        }
        return this;
    }

    public iIII_Class9 IIi_method_a82a5fe3(float f) {
        super.width(f);
        return this;
    }

    public iIII_Class9 IiI_method_97221423(float f) {
        super.height(f);
        return this;
    }

    public iIII_Class9 i_method_e3d569eb(float f, float f2) {
        super.size(f, f2);
        return this;
    }

    public iIII_Class9 I_method_bb4ccecb() {
        super.fillWidth();
        return this;
    }

    public iIII_Class9 i_method_41566eeb() {
        super.fillHeight();
        return this;
    }

    private float I_method_3beb801c() {
        return Math.min(this.w(), this.h()) * this.II_field_46;
    }

    private float i_method_3bfa0bfc() {
        return this.x() + this.I_method_3beb801c();
    }

    private float II_method_41937ca5() {
        return this.y() + this.I_method_3beb801c();
    }

    private float Ii_method_41a20885() {
        return Math.max(1.0f, this.w() - this.I_method_3beb801c() * 2.0f);
    }

    private float iI_method_43566cc5() {
        return Math.max(1.0f, this.h() - this.I_method_3beb801c() * 2.0f);
    }

    private float I_method_4184ed04(float f) {
        return this.i_method_3bfa0bfc() + f * this.Ii_method_41a20885();
    }

    private float i_method_4347dd24(float f) {
        return this.II_method_41937ca5() + f * this.iI_method_43566cc5();
    }

    private float II_method_f0dc819b(float f) {
        return (f - this.i_method_3bfa0bfc()) / this.Ii_method_41a20885();
    }

    private float Ii_method_f29f71bb(float f) {
        return (f - this.II_method_41937ca5()) / this.iI_method_43566cc5();
    }

    private void I_method_12b2037a(IiIII_Class9 iiIII_Class9, float f, float f2) {
        float f3;
        if (iiIII_Class9 != IiIII_Class9.I_field_2f4c8d6c) {
            return;
        }
        float f4 = iIII_Class9.I_method_8d537a1c(f, f2, this.I_method_4184ed04(this.I_field_b575d2cc.I_method_4e8b496f()), this.i_method_4347dd24(this.i_field_b575d2cc.I_method_4e8b496f()));
        if (f4 <= (f3 = iIII_Class9.I_method_8d537a1c(f, f2, this.I_method_4184ed04(this.II_field_b575d2cc.I_method_4e8b496f()), this.i_method_4347dd24(this.Ii_field_b575d2cc.I_method_4e8b496f())))) {
            this.I_field_5a = true;
            this.I_method_ef191d2c(f, f2);
        } else {
            this.i_field_5a = true;
            this.i_method_25b4310c(f, f2);
        }
    }

    private void I_method_ef191d2c(float f, float f2) {
        this.I_field_f9f609fa.accept(this.I_method_89918c23(f, f2));
    }

    private void i_method_25b4310c(float f, float f2) {
        this.i_field_f9f609fa.accept(this.I_method_89918c23(f, f2));
    }

    private Vec2f I_method_89918c23(float f, float f2) {
        float f3 = this.Ii_field_46 + 1.0f;
        float f4 = iIII_Class9.I_method_f40af004(f, this.x() + f3, this.x() + this.w() - f3);
        float f5 = iIII_Class9.I_method_f40af004(f2, this.y() + f3, this.y() + this.h() - f3);
        return new Vec2f(this.II_method_f0dc819b(f4), this.Ii_method_f29f71bb(f5));
    }

    @Override
    public void mouseReleased(float f, float f2, IiIII_Class9 iiIII_Class9) {
        this.I_field_5a = false;
        this.i_field_5a = false;
        super.mouseReleased(f, f2, iiIII_Class9);
    }

    @Override
    protected void measure() {
        if (!this.explicitH) {
            this.prefH = this.w();
        }
    }

    @Override
    protected void onTick(float f, float f2, float f3) {
        if (this.I_field_5a) {
            this.I_method_ef191d2c(f2, f3);
        } else if (this.i_field_5a) {
            this.i_method_25b4310c(f2, f3);
        }
        Vec2f vec2f = this.I_field_11b14ee4.get();
        Vec2f vec2f2 = this.i_field_11b14ee4.get();
        this.I_field_b575d2cc.I_method_82de4e21(vec2f.x);
        this.I_field_b575d2cc.Ii_method_dc72325e(f);
        this.i_field_b575d2cc.I_method_82de4e21(vec2f.y);
        this.i_field_b575d2cc.Ii_method_dc72325e(f);
        this.II_field_b575d2cc.I_method_82de4e21(vec2f2.x);
        this.II_field_b575d2cc.Ii_method_dc72325e(f);
        this.Ii_field_b575d2cc.I_method_82de4e21(vec2f2.y);
        this.Ii_field_b575d2cc.Ii_method_dc72325e(f);
        if (this.I_field_5a || this.i_field_5a) {
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.ii_field_aa52e62c);
        }
    }

    @Override
    protected void drawSelf(III iII, float f) {
        float f2 = this.x();
        float f3 = this.y();
        float f4 = this.w();
        float f5 = this.h();
        IIiii_Class8 iIiii_Class8 = IIiii_Class8.I_method_893b2757(this.I_field_46);
        ColorRGBA colorRGBA = this.I_field_aad1658.apply(this);
        if (colorRGBA != null && colorRGBA.getAlpha() > 0.0f) {
            iII.drawRoundedRect(f2, f3, f4, f5, iIiii_Class8, colorRGBA);
        }
        MatrixStack matrixStack = iII.getMatrices();
        iIiiiIiII_Class373.I_method_d5a5ee51(matrixStack, f2, f3, f4, f5);
        float f6 = this.i_method_3bfa0bfc();
        float f7 = this.II_method_41937ca5();
        float f8 = this.Ii_method_41a20885();
        float f9 = this.iI_method_43566cc5();
        iII.drawDashedBorder(f6, f7, f8, f9, 0.5f, IIiii_Class8.I_method_893b2757(this.i_field_46), this.ii_field_46, this.III_field_46, this.II_field_aad1658.apply(this), 0.0f, 1.0f, 1.0f, 0.0f);
        Vec2f vec2f = new Vec2f(this.I_method_4184ed04(0.0f), this.i_method_4347dd24(1.0f));
        Vec2f vec2f2 = new Vec2f(this.I_method_4184ed04(1.0f), this.i_method_4347dd24(0.0f));
        Vec2f vec2f3 = new Vec2f(this.I_method_4184ed04(this.I_field_b575d2cc.I_method_4e8b496f()), this.i_method_4347dd24(this.i_field_b575d2cc.I_method_4e8b496f()));
        Vec2f vec2f4 = new Vec2f(this.I_method_4184ed04(this.II_field_b575d2cc.I_method_4e8b496f()), this.i_method_4347dd24(this.Ii_field_b575d2cc.I_method_4e8b496f()));
        ColorRGBA colorRGBA2 = this.iI_field_aad1658.apply(this);
        iII.drawSmoothBezier(f2, f3, f4, f5, vec2f, vec2f, vec2f3, vec2f3, this.IiI_field_46, colorRGBA2);
        iII.drawSmoothBezier(f2, f3, f4, f5, vec2f2, vec2f2, vec2f4, vec2f4, this.IiI_field_46, colorRGBA2);
        iII.drawSmoothBezier(f2, f3, f4, f5, vec2f, vec2f3, vec2f4, vec2f2, this.IIi_field_46, this.Ii_field_aad1658.apply(this));
        ColorRGBA colorRGBA3 = this.ii_field_aad1658.apply(this);
        iIII_Class9.I_method_ae913f8c(iII, vec2f, this.Ii_field_46, colorRGBA3);
        iIII_Class9.i_method_acaca36c(iII, vec2f2, this.iI_field_46, colorRGBA3);
        iIII_Class9.i_method_acaca36c(iII, vec2f3, this.Ii_field_46, colorRGBA3);
        iIII_Class9.i_method_acaca36c(iII, vec2f4, this.Ii_field_46, colorRGBA3);
        iIiiiIiII_Class373.I_method_ff80a1df();
        ColorRGBA colorRGBA4 = this.i_field_aad1658.apply(this);
        if (colorRGBA4 != null && colorRGBA4.getAlpha() > 0.0f) {
            iII.drawRoundedBorder(f2, f3, f4, f5, 0.5f, iIiii_Class8, colorRGBA4);
        }
    }

    private static void I_method_ae913f8c(III iII, Vec2f vec2f, float f, ColorRGBA colorRGBA) {
        iII.drawRoundedBorder(vec2f.x - f, vec2f.y - f, f * 2.0f, f * 2.0f, 1.0f, IIiii_Class8.I_method_893b2757(f), colorRGBA);
    }

    private static void i_method_acaca36c(III iII, Vec2f vec2f, float f, ColorRGBA colorRGBA) {
        iII.drawRoundedRect(vec2f.x - f, vec2f.y - f, f * 2.0f, f * 2.0f, IIiii_Class8.I_method_893b2757(f), colorRGBA);
    }

    private static float I_method_8d537a1c(float f, float f2, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        return (float)Math.sqrt(f5 * f5 + f6 * f6);
    }

    private static float I_method_f40af004(float f, float f2, float f3) {
        return f < f2 ? f2 : (f > f3 ? f3 : f);
    }

}

