package rockstar.client;

import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.Supplier;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIii_Class4;
import rockstar.client.IIiii_Class8;
import rockstar.client.Iii_Class4;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIiIIIi_Class274;

public class IIiiI_Class7
extends Iii_Class4 {
    private Function<IIiiI_Class7, ColorRGBA> I_field_aad1658 = iIiiI_Class7 -> IiiiiIIIi_Class242.ii_field_d0c8ec5;
    private Function<IIiiI_Class7, ColorRGBA> i_field_aad1658 = iIiiI_Class7 -> new ColorRGBA(78.0f, 74.0f, 90.0f);
    private Function<IIiiI_Class7, ColorRGBA> II_field_aad1658 = null;

    public IIiiI_Class7(BooleanSupplier booleanSupplier) {
        this.size(13.0f, 8.0f);
        this.cursor(iIIIiIIIi_Class274.i_field_aa52e62c);
        this.bind("on", booleanSupplier, IIii_Class4.I_field_f93678c1);
    }

    public IIiiI_Class7 I_method_f43b9cd6(ColorRGBA colorRGBA) {
        this.I_field_aad1658 = iIiiI_Class7 -> colorRGBA;
        return this;
    }

    public IIiiI_Class7 I_method_99dce6f5(Supplier<ColorRGBA> supplier) {
        this.I_field_aad1658 = iIiiI_Class7 -> (ColorRGBA)supplier.get();
        return this;
    }

    public IIiiI_Class7 I_method_83969269(Function<IIiiI_Class7, ColorRGBA> function) {
        this.I_field_aad1658 = function;
        return this;
    }

    public IIiiI_Class7 i_method_af534f6(ColorRGBA colorRGBA) {
        this.i_field_aad1658 = iIiiI_Class7 -> colorRGBA;
        return this;
    }

    public IIiiI_Class7 i_method_c4678f15(Supplier<ColorRGBA> supplier) {
        this.i_field_aad1658 = iIiiI_Class7 -> (ColorRGBA)supplier.get();
        return this;
    }

    public IIiiI_Class7 i_method_ae213a89(Function<IIiiI_Class7, ColorRGBA> function) {
        this.i_field_aad1658 = function;
        return this;
    }

    public IIiiI_Class7 II_method_54754c33(ColorRGBA colorRGBA) {
        this.II_field_aad1658 = iIiiI_Class7 -> colorRGBA;
        return this;
    }

    public IIiiI_Class7 II_method_3f66ccd2(Supplier<ColorRGBA> supplier) {
        this.II_field_aad1658 = iIiiI_Class7 -> (ColorRGBA)supplier.get();
        return this;
    }

    public IIiiI_Class7 II_method_29207846(Function<IIiiI_Class7, ColorRGBA> function) {
        this.II_field_aad1658 = function;
        return this;
    }

    @Override
    protected void drawSelf(III iII, float f) {
        float f2 = this.sig("on");
        float f3 = this.x();
        float f4 = this.y();
        float f5 = this.w();
        float f6 = this.h();
        float f7 = 1.5f;
        float f8 = f6 - f7 * 2.0f;
        ColorRGBA colorRGBA = this.I_field_aad1658.apply(this).mix(this.i_field_aad1658.apply(this), 1.0f - f2);
        ColorRGBA colorRGBA2 = this.II_field_aad1658 == null ? IiiiiIIIi_Class242.I_method_35ed8eaf(colorRGBA) : this.II_field_aad1658.apply(this);
        iII.drawRoundedRect(f3, f4, f5, f6, IIiii_Class8.I_method_893b2757(f6 / 2.0f - 0.5f), colorRGBA);
        iII.drawRoundedRect(f3 + f7 + (f5 - f8 - f7 * 2.0f) * f2, f4 + f7, f8, f8, IIiii_Class8.I_method_893b2757(f8 / 2.0f - 0.5f), colorRGBA2);
    }
}

