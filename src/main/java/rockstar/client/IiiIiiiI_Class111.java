package rockstar.client;

import lombok.Generated;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiiiIIii_Class116;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIiIIIiI_Class291;

public class IiiIiiiI_Class111 {
    private final float I_field_46 = 16.0f;
    private final float i_field_46 = 4.0f;
    private final float II_field_46 = 10.0f;
    private IiiiIIii_Class116.Nested1_80294f3 I_field_765e39dc = IiiiIIii_Class116.Nested1_80294f3.I_field_765e39dc;
    private final IiiiIIii_Class116.Nested1_80294f3[] I_field_25c473b7 = IiiiIIii_Class116.Nested1_80294f3.values();

    public void I_method_37f5b6c6(III iII, float f, float f2, float f3) {
        float f4 = this.I_method_537ad844(f3);
        for (int i = 0; i < this.I_field_25c473b7.length; ++i) {
            this.I_method_60626bea(iII, this.I_field_25c473b7[i], f + 10.0f + (float)i * (f4 + 4.0f), f2, f4);
        }
    }

    public boolean I_method_b2745698(double d, double d2, float f, float f2, float f3) {
        float f4 = this.I_method_537ad844(f3);
        for (int i = 0; i < this.I_field_25c473b7.length; ++i) {
            float f5 = f + 10.0f + (float)i * (f4 + 4.0f);
            if (!iIIiIIIiI_Class291.I_method_c3f86263(f5, f2, f4, 16.0, d, d2)) continue;
            if (this.I_field_765e39dc != this.I_field_25c473b7[i]) {
                this.I_field_765e39dc = this.I_field_25c473b7[i];
                return true;
            }
            return false;
        }
        return false;
    }

    private void I_method_60626bea(III iII, IiiiIIii_Class116.Nested1_80294f3 nested1_80294f3, float f, float f2, float f3) {
        boolean bl = nested1_80294f3 == this.I_field_765e39dc;
        ColorRGBA colorRGBA = bl ? IiiiiIIIi_Class242.i_method_5dfec6e().withAlpha(180.0f) : IiiiiIIIi_Class242.Ii_method_a0f56f71().withAlpha(153.0f);
        iII.drawRoundedRect(f, f2, f3, 16.0f, IIiii_Class8.I_method_893b2757(3.0f), colorRGBA);
        iII.drawCenteredText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), nested1_80294f3.i_method_1ec358f9(), f + f3 / 2.0f, f2 + (16.0f - IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f).I_method_a649725c()) / 2.0f, bl ? IiiiiIIIi_Class242.I_method_35ed8eaf(colorRGBA) : IiiiiIIIi_Class242.iI_method_8e08d3b1());
    }

    private float I_method_537ad844(float f) {
        return (f - 20.0f - 4.0f * (float)(this.I_field_25c473b7.length - 1)) / (float)this.I_field_25c473b7.length;
    }

    @Generated
    public float I_method_e9eb2cdc() {
        return this.I_field_46;
    }

    @Generated
    public IiiiIIii_Class116.Nested1_80294f3 I_method_b951df86() {
        return this.I_field_765e39dc;
    }
}

