package rockstar.client;

import java.util.function.Supplier;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iiI_Class7;

public class iIiI_Class11
extends iiI_Class7 {
    private final Supplier<ColorRGBA> I_field_11b14ee4;
    private float I_field_46 = 2.0f;

    public iIiI_Class11(Supplier<ColorRGBA> supplier) {
        this.I_field_11b14ee4 = supplier;
        this.I_method_cf493dcb(10.0f, 10.0f);
    }

    public iIiI_Class11 I_method_dd3d0b23(float f) {
        this.I_field_46 = f;
        return this;
    }

    public iIiI_Class11 i_method_18676f03(float f) {
        super.width(f);
        return this;
    }

    public iIiI_Class11 II_method_8ea3eeac(float f) {
        super.height(f);
        return this;
    }

    public iIiI_Class11 I_method_cf493dcb(float f, float f2) {
        super.size(f, f2);
        return this;
    }

    @Override
    protected void drawSelf(III iII, float f) {
        float f2 = this.x();
        float f3 = this.y();
        float f4 = this.w();
        float f5 = this.h();
        iII.drawRoundedRect(f2, f3, f4, f5, IIiii_Class8.I_method_893b2757(f4 / 2.0f), IiiiiIIIi_Class242.IiI_field_d0c8ec5);
        float f6 = f2 + this.I_field_46;
        float f7 = f3 + this.I_field_46;
        float f8 = f4 - this.I_field_46 * 2.0f;
        float f9 = f5 - this.I_field_46 * 2.0f;
        ColorRGBA colorRGBA = this.I_field_11b14ee4.get();
        if (f8 > 0.0f && f9 > 0.0f && colorRGBA != null) {
            iII.drawRoundedRect(f6, f7, f8, f9, IIiii_Class8.I_method_893b2757(f8 / 2.0f), colorRGBA);
        }
    }

}

