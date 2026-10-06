package rockstar.client;

import net.minecraft.util.math.Vec2f;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.Vector2Setting;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiiIiiIii_Class220;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iIIIiIIiI_Class275;
import rockstar.client.iIIiIIIiI_Class291;
import rockstar.client.iI_Class3;
import rockstar.client.iIiiiiIii_Class380;
import ua.mintantileak.spk.Compile;

public class IiiIiiiII_Class221
extends IiiIiiIii_Class220<Vector2Setting> {
    private final IiiiIiIii_Class236 i_field_dc7facc = new IiiiIiIii_Class236(500L, IiiiIiiII_Class237.II_field_dd60aac);
    private final IiiiIiIii_Class236 II_field_dc7facc = new IiiiIiIii_Class236(500L, IiiiIiiII_Class237.II_field_dd60aac);
    private final IiiiIiIii_Class236 Ii_field_dc7facc = new IiiiIiIii_Class236(500L, IiiiIiiII_Class237.II_field_dd60aac);
    private final IiiiIiIii_Class236 iI_field_dc7facc = new IiiiIiIii_Class236(500L, IiiiIiiII_Class237.II_field_dd60aac);
    private boolean I_field_5a;
    private boolean i_field_5a;

    public IiiIiiiII_Class221(Vector2Setting iIiiiIiII_Class117, iI_Class3 iI_Class32) {
        super(iIiiiIiII_Class117, iI_Class32);
    }

    @Override
    protected void i_method_bdd4e0ec(III iII) {
        float f = this.I_field_46 + 9.0f;
        float f2 = this.i_field_46 + 2.0f;
        float f3 = this.II_field_46 - 18.0f;
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f);
        float f4 = 10.0f;
        float f5 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f).I_method_a649725c();
        this.I_field_dc7facc.I_method_edd72835(this.I_method_a74dc6d0(iII.I_method_b1c3e152(), iII.i_method_b1d26d32()));
        float f6 = 3.0f;
        float f7 = f - 1.0f + f6;
        float f8 = f2 + 17.0f + f6;
        float f9 = f3 + 2.0f - f6 * 2.0f;
        float f10 = this.Ii_field_46 - 10.0f - 17.0f - f6 * 2.0f;
        iII.drawRoundedRect(f7 - f6, f8 - f6, f9 + f6 * 2.0f, f10 + f6 * 2.0f, IIiii_Class8.I_method_893b2757(6.0f), IiiiiIIIi_Class242.II_method_190e6391().withAlpha(76.5f));
        iII.drawRoundedRect(f7 + this.i_field_dc7facc.I_method_6ac4da6f() * f9 - 3.0f, f8 + this.II_field_dc7facc.I_method_6ac4da6f() * f10 - 3.0f, 6.0f, 6.0f, IIiii_Class8.I_method_893b2757(6.0f), IiiiiIIIi_Class242.Ii_field_d0c8ec5.withAlpha(255.0f));
        iII.drawRoundedRect(f7 + this.Ii_field_dc7facc.I_method_6ac4da6f() * f9 - 3.0f, f8 + this.iI_field_dc7facc.I_method_6ac4da6f() * f10 - 3.0f, 6.0f, 6.0f, IIiii_Class8.I_method_893b2757(6.0f), IiiiiIIIi_Class242.Ii_field_d0c8ec5.withAlpha(255.0f));
        iIiiiiIii_Class380.I_method_5f4b621f();
        Vec2f vec2f = new Vec2f(f7, f8 + f10);
        Vec2f vec2f2 = new Vec2f(f7 + this.i_field_dc7facc.I_method_6ac4da6f() * f9, f8 + this.II_field_dc7facc.I_method_6ac4da6f() * f10);
        Vec2f vec2f3 = new Vec2f(f7 + this.Ii_field_dc7facc.I_method_6ac4da6f() * f9, f8 + this.iI_field_dc7facc.I_method_6ac4da6f() * f10);
        Vec2f vec2f4 = new Vec2f(f7 + f9, f8);
        iII.drawBezier(vec2f, vec2f2, vec2f3, vec2f4, ColorRGBA.WHITE, 50);
        iII.drawLine(vec2f, vec2f2, IiiiiIIIi_Class242.Ii_field_d0c8ec5.mulAlpha(0.5f));
        iII.drawLine(vec2f4, vec2f3, IiiiiIIIi_Class242.Ii_field_d0c8ec5.mulAlpha(0.5f));
        this.I_method_2d447471(iII, iIiIIi_Class10, IiIiIIII_Class81.I_method_f25a980a(((Vector2Setting)this.I_field_ba11c26c).getName()), this.I_field_46 + f4, f2 + 11.0f - iIiIIi_Class10.I_method_a649725c(), this.I_method_c4c8e2f8().II_method_c7206932() - f4 - 10.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * (0.75f + 0.25f * this.I_field_dc7facc.I_method_6ac4da6f())), 0.8f, 1.0f);
        if (this.I_method_7ae26dde(iII) && (float)iII.i_method_b1d26d32() > this.III_method_f4aafe8f() && (float)iII.i_method_b1d26d32() < this.III_method_f4aafe8f() + this.IIi_method_f4b98a6f()) {
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
        }
        if (this.I_field_5a) {
            float f11 = iIIiIIIiI_Class291.I_method_a531f52f(0.0f, 1.0f, f7, f9, iII.I_method_b1c3e152());
            float f12 = iIIiIIIiI_Class291.i_method_2dbfd54f(0.0f, 1.0f, f8, f10, iII.i_method_b1d26d32());
            ((Vector2Setting)this.I_field_ba11c26c).I_method_f4aeac5e(new Vec2f(f11, Math.clamp(f12, -0.5f, 1.5f)));
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.ii_field_aa52e62c);
        } else if (this.i_field_5a) {
            float f13 = iIIiIIIiI_Class291.I_method_a531f52f(0.0f, 1.0f, f7, f9, iII.I_method_b1c3e152());
            float f14 = iIIiIIIiI_Class291.i_method_2dbfd54f(0.0f, 1.0f, f8, f10, iII.i_method_b1d26d32());
            ((Vector2Setting)this.I_field_ba11c26c).i_method_4362bc7e(new Vec2f(f13, Math.clamp(f14, -0.5f, 1.5f)));
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.ii_field_aa52e62c);
        }
        this.i_field_dc7facc.I_method_edd6dd21(((Vector2Setting)this.I_field_ba11c26c).I_method_7430e9b6().x);
        this.II_field_dc7facc.I_method_edd6dd21(((Vector2Setting)this.I_field_ba11c26c).I_method_7430e9b6().y);
        this.Ii_field_dc7facc.I_method_edd6dd21(((Vector2Setting)this.I_field_ba11c26c).i_method_18296d96().x);
        this.iI_field_dc7facc.I_method_edd6dd21(((Vector2Setting)this.I_field_ba11c26c).i_method_18296d96().y);
    }

    @Override
    public void iI_method_20338844(III iII) {
        float f = 0.5f;
        iII.drawRect(this.I_field_46, this.i_field_46 + this.Ii_field_46, this.II_field_46, f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(5.1f));
    }

    @Override
    @Compile
    public void I_method_400ceaa7(double d, double d2, IiIII_Class9 iiIII_Class9) {
        float f = this.I_field_46 + 9.0f;
        float f2 = this.i_field_46 + 2.0f;
        float f3 = this.II_field_46 - 18.0f;
        if (this.I_method_a74cd690(d, d2)) {
            float f4;
            float f5 = f - 1.0f;
            float f6 = f2 + 17.0f;
            float f7 = f3 + 2.0f;
            float f8 = this.Ii_field_46 - 10.0f - 17.0f;
            Vec2f vec2f = new Vec2f(iIIiIIIiI_Class291.I_method_fc7140f1((float)d, f5, f5 + f7), iIIiIIIiI_Class291.I_method_fc7140f1((float)d2, f6, f6 + f8));
            float f9 = this.I_method_dc0430ef(((Vector2Setting)this.I_field_ba11c26c).I_method_7430e9b6(), vec2f);
            if (f9 < (f4 = this.I_method_dc0430ef(((Vector2Setting)this.I_field_ba11c26c).i_method_18296d96(), vec2f))) {
                this.I_field_5a = true;
            } else {
                this.i_field_5a = true;
            }
        }
        super.I_method_400ceaa7(d, d2, iiIII_Class9);
    }

    public float I_method_dc0430ef(Vec2f vec2f, Vec2f vec2f2) {
        float f = vec2f.x - vec2f2.x;
        float f2 = vec2f.y - vec2f2.y;
        return (float)Math.sqrt(f * f + f2 * f2);
    }

    @Override
    public void i_method_6a097ac7(double d, double d2, IiIII_Class9 iiIII_Class9) {
        this.I_field_5a = false;
        this.i_field_5a = false;
        super.i_method_6a097ac7(d, d2, iiIII_Class9);
    }

    @Override
    public float Ii_method_2047ead7() {
        this.Ii_field_46 = this.II_field_46 - 14.0f;
        return this.Ii_field_46;
    }
}

