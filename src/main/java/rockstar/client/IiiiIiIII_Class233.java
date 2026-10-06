package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.util.math.Vector2f;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.InterfaceModule;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.SliderSetting;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiIiIIIII_Class161;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiiIiiIii_Class220;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIIiIiI_Class267;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iIIIiIIiI_Class275;
import rockstar.client.iIIiIIIiI_Class291;
import rockstar.client.iI_Class3;
import rockstar.client.iIiiIIiii_Class360;
import rockstar.client.iiIiIIiii_Class424;
import ua.mintantileak.spk.Compile;

public class IiiiIiIII_Class233
extends IiiIiiIii_Class220<SliderSetting> {
    private final IiiiIiIii_Class236 i_field_dc7facc = new IiiiIiIii_Class236(500L, IiiiIiiII_Class237.II_field_dd60aac);
    private final IiiiIiIii_Class236 II_field_dc7facc = new IiiiIiIii_Class236(500L, IiiiIiiII_Class237.III_field_dd60aac);
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
    private boolean I_field_5a;
    private int I_field_49;
    private boolean i_field_5a;
    private IiIiIIIII_Class161 I_field_fdef2cc;
    private static IiiiIiIII_Class233 I_field_dc77ecc;
    private static IiiiIiIII_Class233 i_field_dc77ecc;

    public IiiiIiIII_Class233(SliderSetting iiIIIIIIi_Class130, iI_Class3 iI_Class32) {
        super(iiIIIIIIi_Class130, iI_Class32);
    }

    @Override
    public void I_method_575ca63f() {
        this.I_field_fdef2cc = new IiIiIIIII_Class161(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f));
        this.I_field_fdef2cc.i_method_fd1e2055(true);
        this.ii_method_56c9e4c2();
        this.i_field_dc7facc.I_method_edd6dd21(((SliderSetting)this.I_field_ba11c26c).Ii_method_a20abcd2());
        super.I_method_575ca63f();
    }

    @Override
    public void II_method_b98d0c44(III iII) {
        if (this.I_method_a74dc6d0(iII.I_method_b1c3e152(), iII.i_method_b1d26d32())) {
            i_field_dc77ecc = this;
        }
        if (this.i_field_5a && this.I_field_fdef2cc != null) {
            this.I_field_fdef2cc.II_method_b98d0c44(iII);
            if (!this.I_field_fdef2cc.I_method_189fd283()) {
                this.II_method_54f868c2();
            }
        } else {
            this.III_method_4a23a6df();
        }
        super.II_method_b98d0c44(iII);
    }

    @Override
    protected void i_method_bdd4e0ec(III iII) {
        float f;
        float f2 = this.I_field_46 + 9.0f;
        float f3 = this.i_field_46 + 2.0f;
        if (i_field_dc77ecc == this && (float)iII.i_method_b1d26d32() > this.III_method_f4aafe8f() && (float)iII.i_method_b1d26d32() < this.III_method_f4aafe8f() + this.IIi_method_f4b98a6f()) {
            i_field_dc77ecc = null;
        }
        float f4 = this.II_field_46 - 18.0f;
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f);
        float f5 = 10.0f;
        float f6 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f).I_method_a649725c();
        this.i_field_dc7facc.I_method_edd6dd11(((SliderSetting)this.I_field_ba11c26c).Ii_method_a20abcd2());
        this.I_field_dc7facc.I_method_edd72835(this.I_method_a74dc6d0(iII.I_method_b1c3e152(), iII.i_method_b1d26d32()));
        iII.drawRoundedRect(f2, f3 + this.Ii_field_46 - 12.0f, f4, 2.0f, IIiii_Class8.I_method_893b2757(0.25f), IiiiiIIIi_Class242.Ii_method_a0f56f71().withAlpha((255.0f - 100.0f * InterfaceModule.I_method_fdcdb22f()) * 0.7f));
        iII.drawRoundedRect(f2, f3 + this.Ii_field_46 - 12.0f, f4 * iIIiIIIiI_Class291.I_method_fc7140f1(this.i_field_dc7facc.I_method_6ac4da6f(), ((SliderSetting)this.I_field_ba11c26c).I_method_b2a48e2f(), ((SliderSetting)this.I_field_ba11c26c).i_method_b2b31a0f()), 2.0f, IIiii_Class8.I_method_893b2757(0.25f), IiiiiIIIi_Class242.i_method_5dfec6e());
        if (this.I_field_991c1e8c.I_method_58432069(50L)) {
            iIiiIIiii_Class360.II_method_ecf93d42();
            this.I_field_991c1e8c.I_method_23e11e3f();
        }
        if (InterfaceModule.Iii_method_c4da86a3()) {
            iII.drawShadow(f2 + f4 * iIIiIIIiI_Class291.I_method_fc7140f1(this.i_field_dc7facc.I_method_6ac4da6f(), ((SliderSetting)this.I_field_ba11c26c).I_method_b2a48e2f(), ((SliderSetting)this.I_field_ba11c26c).i_method_b2b31a0f()) - 4.5f - 3.0f * this.II_field_dc7facc.I_method_6ac4da6f(), f3 + this.Ii_field_46 - 11.0f - 3.0f - 2.0f * this.II_field_dc7facc.I_method_6ac4da6f(), 9.0f + 6.0f * this.II_field_dc7facc.I_method_6ac4da6f(), 6.0f + 4.0f * this.II_field_dc7facc.I_method_6ac4da6f(), 10.0f, IIiii_Class8.I_method_893b2757(3.0f + this.II_field_dc7facc.I_method_6ac4da6f() * 2.0f), ColorRGBA.BLACK.withAlpha(255.0f * (0.25f + 0.2f * this.II_field_dc7facc.I_method_6ac4da6f()) * InterfaceModule.I_method_fdcdb22f()));
            iII.drawSquircle(f2 + f4 * iIIiIIIiI_Class291.I_method_fc7140f1(this.i_field_dc7facc.I_method_6ac4da6f(), ((SliderSetting)this.I_field_ba11c26c).I_method_b2a48e2f(), ((SliderSetting)this.I_field_ba11c26c).i_method_b2b31a0f()) - 4.5f - 3.0f * this.II_field_dc7facc.I_method_6ac4da6f(), f3 + this.Ii_field_46 - 11.0f - 3.0f - 2.0f * this.II_field_dc7facc.I_method_6ac4da6f(), 9.0f + 6.0f * this.II_field_dc7facc.I_method_6ac4da6f(), 6.0f + 4.0f * this.II_field_dc7facc.I_method_6ac4da6f(), 7.0f, IIiii_Class8.I_method_893b2757(3.0f + this.II_field_dc7facc.I_method_6ac4da6f()), ColorRGBA.WHITE.withAlpha(255.0f * (1.0f - this.II_field_dc7facc.I_method_6ac4da6f()) * InterfaceModule.I_method_fdcdb22f()));
            iII.drawLiquidGlass(f2 + f4 * iIIiIIIiI_Class291.I_method_fc7140f1(this.i_field_dc7facc.I_method_6ac4da6f(), ((SliderSetting)this.I_field_ba11c26c).I_method_b2a48e2f(), ((SliderSetting)this.I_field_ba11c26c).i_method_b2b31a0f()) - 4.5f - 3.0f * this.II_field_dc7facc.I_method_6ac4da6f(), f3 + this.Ii_field_46 - 11.0f - 3.0f - 2.0f * this.II_field_dc7facc.I_method_6ac4da6f(), 9.0f + 6.0f * this.II_field_dc7facc.I_method_6ac4da6f(), 6.0f + 4.0f * this.II_field_dc7facc.I_method_6ac4da6f(), 7.0f, IIiii_Class8.I_method_893b2757(3.0f + this.II_field_dc7facc.I_method_6ac4da6f()), ColorRGBA.WHITE.withAlpha(255.0f * this.II_field_dc7facc.I_method_6ac4da6f() * InterfaceModule.I_method_fdcdb22f()), false);
        }
        if (InterfaceModule.iII_method_f9a41e83()) {
            iII.drawShadow(f2 + f4 * iIIiIIIiI_Class291.I_method_fc7140f1(this.i_field_dc7facc.I_method_6ac4da6f(), ((SliderSetting)this.I_field_ba11c26c).I_method_b2a48e2f(), ((SliderSetting)this.I_field_ba11c26c).i_method_b2b31a0f()) - 3.0f, f3 + this.Ii_field_46 - 14.0f + this.II_field_dc7facc.I_method_6ac4da6f(), 6.0f, 6.0f - this.II_field_dc7facc.I_method_6ac4da6f() * 2.0f, 10.0f, IIiii_Class8.I_method_893b2757(3.0f - this.II_field_dc7facc.I_method_6ac4da6f() * 2.0f), ColorRGBA.BLACK.withAlpha(63.75f * InterfaceModule.i_method_fddc3e0f()));
            iII.drawRoundedRect(f2 + f4 * iIIiIIIiI_Class291.I_method_fc7140f1(this.i_field_dc7facc.I_method_6ac4da6f(), ((SliderSetting)this.I_field_ba11c26c).I_method_b2a48e2f(), ((SliderSetting)this.I_field_ba11c26c).i_method_b2b31a0f()) - 3.0f, f3 + this.Ii_field_46 - 14.0f + this.II_field_dc7facc.I_method_6ac4da6f(), 6.0f, 6.0f - this.II_field_dc7facc.I_method_6ac4da6f() * 2.0f, IIiii_Class8.I_method_893b2757(3.0f - this.II_field_dc7facc.I_method_6ac4da6f() * 2.0f), ColorRGBA.WHITE.withAlpha(255.0f * InterfaceModule.i_method_fddc3e0f()));
        }
        String string = iIIIIiIiI_Class267.I_method_230e44c1(Math.clamp(this.i_field_dc7facc.I_method_6ac4da6f(), ((SliderSetting)this.I_field_ba11c26c).I_method_b2a48e2f(), ((SliderSetting)this.I_field_ba11c26c).i_method_b2b31a0f())) + ((SliderSetting)this.I_field_ba11c26c).II_method_d429a7de();
        float f7 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f).I_method_2c375926(string);
        float f8 = f2 + f4 - f7;
        float f9 = f3 + 11.0f - f6;
        float f10 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f).I_method_a649725c();
        this.I_method_2d447471(iII, iIiIIi_Class10, IiIiIIII_Class81.I_method_f25a980a(((SliderSetting)this.I_field_ba11c26c).getName()), this.I_field_46 + f5, f3 + 11.0f - iIiIIi_Class10.I_method_a649725c(), this.I_method_c4c8e2f8().II_method_c7206932() - f5 - IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f).I_method_2c375926(string) - 10.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * (0.75f + 0.25f * this.I_field_dc7facc.I_method_6ac4da6f())), 0.8f, 1.0f);
        if (this.i_field_5a && this.I_field_fdef2cc != null) {
            f = f9 - 1.0f;
            float f11 = f7 + 5.0f;
            float f12 = f10 + 2.0f;
            this.I_field_fdef2cc.I_method_b043bcc(f8, f, f11, f12);
            this.I_field_fdef2cc.iI_method_a8609f1e(1.0f);
            this.I_field_fdef2cc.I_method_13a617e0(IiiiiIIIi_Class242.iI_method_8e08d3b1());
            this.I_field_fdef2cc.I_method_7ae26dda(iII);
        }
        if (this.I_method_7ae26dde(iII) && (float)iII.i_method_b1d26d32() > this.III_method_f4aafe8f() && (float)iII.i_method_b1d26d32() < this.III_method_f4aafe8f() + this.IIi_method_f4b98a6f()) {
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
        }
        if (this.I_field_5a && !iIIiIIIiI_Class291.I_method_f734a088(this.I_field_49)) {
            this.I_field_5a = false;
        }
        this.II_field_dc7facc.I_method_edd6ec25(200L);
        this.II_field_dc7facc.I_method_edd6dd11(this.I_field_5a ? 1.0f : 0.0f);
        if (this.I_field_5a) {
            f = iIIiIIIiI_Class291.I_method_a531f52f(((SliderSetting)this.I_field_ba11c26c).I_method_b2a48e2f(), ((SliderSetting)this.I_field_ba11c26c).i_method_b2b31a0f(), f2, f4, iII.I_method_b1c3e152());
            ((SliderSetting)this.I_field_ba11c26c).I_method_a1eda161(f);
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.II_field_aa52e62c);
            I_field_dc77ecc = this;
        }
    }

    @Override
    public void Ii_method_6b12c484(III iII) {
        if (this.i_field_5a && this.I_field_fdef2cc != null) {
            return;
        }
        float f = this.I_field_46 + 9.0f;
        float f2 = this.i_field_46 + 2.0f;
        float f3 = this.II_field_46 - 18.0f;
        float f4 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f).I_method_a649725c();
        String string = iIIIIiIiI_Class267.I_method_230e44c1(Math.clamp(this.i_field_dc7facc.I_method_6ac4da6f(), ((SliderSetting)this.I_field_ba11c26c).I_method_b2a48e2f(), ((SliderSetting)this.I_field_ba11c26c).i_method_b2b31a0f())) + ((SliderSetting)this.I_field_ba11c26c).II_method_d429a7de();
        iII.drawRightText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), string, f + f3, f2 + 11.0f - f4, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * (0.75f + 0.25f * this.I_field_dc7facc.I_method_6ac4da6f()) * RenderSystem.getShaderColor()[3]));
    }

    @Override
    public void iI_method_20338844(III iII) {
        float f = 0.5f;
        iII.drawRect(this.I_field_46, this.i_field_46 + this.Ii_field_46, this.II_field_46, f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(5.1f));
    }

    @Override
    @Compile
    public void I_method_400ceaa7(double d, double d2, IiIII_Class9 iiIII_Class9) {
        boolean bl = this.i_field_5a;
        if (this.I_method_a74cd690(d, d2)) {
            String string = iIIIIiIiI_Class267.I_method_230e44c1(((SliderSetting)this.I_field_ba11c26c).Ii_method_a20abcd2()) + ((SliderSetting)this.I_field_ba11c26c).II_method_d429a7de();
            float f = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f).I_method_2c375926(string);
            float f2 = this.I_field_46 + 9.0f + (this.II_field_46 - 18.0f) - f;
            float f3 = this.i_field_46 + 2.0f + 11.0f - IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f).I_method_a649725c();
            float f4 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f).I_method_a649725c();
            if (d >= (double)f2 && d <= (double)(f2 + f) && d2 >= (double)f3 && d2 <= (double)(f3 + f4)) {
                this.Ii_method_5506f4a2();
            } else {
                if (this.i_field_5a) {
                    this.II_method_54f868c2();
                }
                this.I_field_5a = true;
                this.I_field_49 = iiIII_Class9.I_method_6d899712();
            }
        }
        if (this.i_field_5a && this.I_field_fdef2cc != null && bl) {
            this.I_field_fdef2cc.I_method_400ceaa7(d, d2, iiIII_Class9);
            if (iiIII_Class9 == IiIII_Class9.I_field_2f4c8d6c && !this.I_field_fdef2cc.I_method_a74cd690(d, d2) && !this.I_method_a74cd690(d, d2)) {
                this.II_method_54f868c2();
            }
        }
        super.I_method_400ceaa7(d, d2, iiIII_Class9);
    }

    @Override
    @Compile
    public void i_method_6a097ac7(double d, double d2, IiIII_Class9 iiIII_Class9) {
        this.I_field_5a = false;
        if (this.i_field_5a && this.I_field_fdef2cc != null) {
            this.I_field_fdef2cc.i_method_6a097ac7(d, d2, iiIII_Class9);
        }
        super.i_method_6a097ac7(d, d2, iiIII_Class9);
    }

    @Override
    @Compile
    public void I_method_c1acbc24(int n, int n2, int n3) {
        if (this.i_field_5a && this.I_field_fdef2cc != null) {
            this.I_field_fdef2cc.I_method_c1acbc24(n, n2, n3);
            if (n == 257 || n == 335) {
                this.II_method_54f868c2();
            } else if (n == 256) {
                this.iI_method_56bb58e2();
            }
        } else if (n == 262 || n == 263) {
            Vector2f vector2f = iIIiIIIiI_Class291.I_method_81637b4f();
            if (i_field_dc77ecc == this && this.I_method_a74dc6d0(vector2f.getX(), vector2f.getY())) {
                ((SliderSetting)this.I_method_c1026715()).I_method_a1eda161(((SliderSetting)this.I_method_c1026715()).Ii_method_a20abcd2() + ((SliderSetting)this.I_method_c1026715()).II_method_a1fc30f2() * 0.7f * (float)(n == 262 ? 1 : -1));
            } else if (i_field_dc77ecc == null && I_field_dc77ecc == this) {
                ((SliderSetting)I_field_dc77ecc.I_method_c1026715()).I_method_a1eda161(((SliderSetting)I_field_dc77ecc.I_method_c1026715()).Ii_method_a20abcd2() + ((SliderSetting)I_field_dc77ecc.I_method_c1026715()).II_method_a1fc30f2() * 0.7f * (float)(n == 262 ? 1 : -1));
            }
        }
    }

    @Override
    public boolean I_method_b71e84c9(char c, int n) {
        if (this.i_field_5a && this.I_field_fdef2cc != null) {
            return this.I_field_fdef2cc.I_method_b71e84c9(c, n);
        }
        return false;
    }

    @Override
    public void I_method_6b0ad25f(double d, double d2, double d3, double d4) {
        if (this.i_field_5a || d4 == 0.0) {
            return;
        }
        if (this.I_method_a74cd690(d, d2)) {
            // empty if block
        }
    }

    private void II_method_54f868c2() {
        if (this.I_field_fdef2cc != null) {
            try {
                String string = this.I_field_fdef2cc.I_method_d2579001().replace(',', '.');
                if (!(string.isEmpty() || string.equals("-") || string.equals("."))) {
                    float f = Float.parseFloat(string);
                    f = Math.max(((SliderSetting)this.I_field_ba11c26c).I_method_b2a48e2f(), Math.min(((SliderSetting)this.I_field_ba11c26c).i_method_b2b31a0f(), f));
                    ((SliderSetting)this.I_field_ba11c26c).I_method_a1eda161(f);
                }
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
            this.i_field_5a = false;
            this.I_field_fdef2cc.I_method_fb5b3035(false);
            this.ii_method_56c9e4c2();
        }
    }

    @Compile
    private void Ii_method_5506f4a2() {
        this.i_field_5a = true;
        if (this.I_field_fdef2cc != null) {
            String string = iIIIIiIiI_Class267.I_method_230e44c1(((SliderSetting)this.I_field_ba11c26c).Ii_method_a20abcd2());
            this.I_field_fdef2cc.I_method_1d5afa89(string);
            this.I_field_fdef2cc.II_method_e557b20c(string);
            this.I_field_fdef2cc.I_method_fb5b3035(true);
            this.I_field_fdef2cc.i_method_18ae5e5f();
        }
    }

    @Compile
    private void iI_method_56bb58e2() {
        this.i_field_5a = false;
        if (this.I_field_fdef2cc != null) {
            this.I_field_fdef2cc.I_method_fb5b3035(false);
            this.ii_method_56c9e4c2();
        }
    }

    @Compile
    private void ii_method_56c9e4c2() {
        if (this.I_field_fdef2cc == null) {
            return;
        }
        String string = iIIIIiIiI_Class267.I_method_230e44c1(((SliderSetting)this.I_field_ba11c26c).Ii_method_a20abcd2());
        this.I_field_fdef2cc.II_method_e557b20c(string);
        if (!this.i_field_5a) {
            this.I_field_fdef2cc.I_method_1d5afa89(string);
        }
    }

    @Compile
    private void III_method_4a23a6df() {
        if (this.I_field_fdef2cc != null && !this.i_field_5a) {
            this.I_field_fdef2cc.II_method_e557b20c(iIIIIiIiI_Class267.I_method_230e44c1(((SliderSetting)this.I_field_ba11c26c).Ii_method_a20abcd2()));
        }
    }

    public static void i_method_9770ea5f() {
        if (I_field_dc77ecc != null) {
            IiiiIiIII_Class233.I_field_dc77ecc.I_field_5a = false;
            I_field_dc77ecc = null;
        }
        i_field_dc77ecc = null;
    }

    @Override
    public float Ii_method_2047ead7() {
        this.Ii_field_46 = 29.0f;
        return 29.0f;
    }
}

