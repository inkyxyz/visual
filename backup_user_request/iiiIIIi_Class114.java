package rockstar.client;

import lombok.Generated;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.InterfaceModule;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIiiiiiI_Class319;
import rockstar.client.iIiiiIIiI_Class371;
import rockstar.client.iiIiiiI_Class111;
import rockstar.client.iiiIIII_Class113;

public class iiiIIIi_Class114
extends iiIiiiI_Class111 {
    private final iiiIIII_Class113 I_field_c11fcfcc;
    private final String I_field_523beb0a;
    private final String i_field_523beb0a;

    public iiiIIIi_Class114(iiiIIII_Class113 iiiIIII_Class1132, String string, String string2) {
        super(2500L);
        this.I_field_c11fcfcc = iiiIIII_Class1132;
        this.I_field_523beb0a = string;
        this.i_field_523beb0a = string2;
    }

    @Override
    public final void I_method_92bd6423(CustomDrawContext customDrawContext, float f) {
        float f2 = Math.max(IIiIiI_Class11.I_field_857c0621.I_method_3a2d5e3(7.0f).I_method_2c375926(this.I_field_523beb0a), IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.0f).I_method_2c375926(this.i_field_523beb0a));
        float f3 = f2 + 32.0f;
        this.II_field_dc7facc.I_method_df2f9087(IiiiIiiII_Class237.Ii_field_dd60aac);
        this.II_field_dc7facc.I_method_edd6ec25(300L);
        float f4 = (float)customDrawContext.getScaledWindowWidth() / 2.0f - f3 / 2.0f;
        float f5 = (float)customDrawContext.getScaledWindowHeight() - 90.0f - this.II_field_dc7facc.I_method_edd6dd11(f);
        float f6 = 26.0f;
        int n = (int)(255.0f * this.I_field_dc7facc.I_method_6ac4da6f());
        iIiiiIIiI_Class371.II_method_e18635ac(customDrawContext.getMatrices(), f4 + f3 / 2.0f, f5 + 12.0f + f6 / 2.0f, 0.5f + 0.5f * this.I_field_dc7facc.I_method_6ac4da6f());
        if (InterfaceModule.Iii_method_c4da86a3()) {
            customDrawContext.drawLiquidGlass(f4, f5, f3, f6, 7.0f, 0.08f, IIiii_Class8.I_method_893b2757(7.0f), ColorRGBA.WHITE.withAlpha(255.0f * this.I_field_dc7facc.I_method_6ac4da6f() * InterfaceModule.I_method_fdcdb22f()));
            customDrawContext.drawSquircle(f4, f5, f3, f6, 7.0f, IIiii_Class8.I_method_893b2757(7.0f), IiiiiIIIi_Class242.II_method_190e6391().withAlpha(255.0f * iIIiiiiiI_Class319.I_method_5f7ff5cf(IiiiiIIIi_Class242.I_method_5ac4a715().II_method_b3b834f2(), IiiiiIIIi_Class242.I_method_5ac4a715().Ii_method_b3c6c0d2(), InterfaceModule.I_method_fdcdb22f()) * this.I_field_dc7facc.I_method_6ac4da6f()));
        } else {
            customDrawContext.drawBlurredRect(f4, f5, f3, f6, 45.0f, 7.0f, IIiii_Class8.I_method_893b2757(7.0f), ColorRGBA.WHITE.withAlpha(255.0f * this.I_field_dc7facc.I_method_6ac4da6f() * InterfaceModule.i_method_fddc3e0f()));
            customDrawContext.drawSquircle(f4, f5, f3, f6, 7.0f, IIiii_Class8.I_method_893b2757(7.0f), new ColorRGBA(0.0f, 0.0f, 0.0f).withAlpha((int)(140.25f * this.I_field_dc7facc.I_method_6ac4da6f())));
            customDrawContext.drawRoundedRect(f4 + f6 / 2.0f - 9.0f, f5 + f6 / 2.0f - 9.0f, 18.0f, 18.0f, IIiii_Class8.I_method_893b2757(4.0f), new ColorRGBA(0.0f, 0.0f, 0.0f).withAlpha((int)(51.0f * this.I_field_dc7facc.I_method_6ac4da6f())));
        }
        customDrawContext.drawIcon(this.I_field_c11fcfcc.I_method_f3dcd601(), f4 + f6 / 2.0f - 5.0f, f5 + f6 / 2.0f - 5.0f, 10.0f, this.I_field_c11fcfcc.i_method_77de82ce().withAlpha((float)n * 0.8f));
        customDrawContext.drawText(IIiIiI_Class11.I_field_857c0621.I_method_3a2d5e3(7.0f), this.I_field_523beb0a, f4 + 27.0f, f5 + 7.0f, ColorRGBA.WHITE.withAlpha(n));
        customDrawContext.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.0f), this.i_field_523beb0a, f4 + 27.0f, f5 + 15.0f, ColorRGBA.WHITE.withAlpha(n));
        iIiiiIIiI_Class371.I_method_10503b11(customDrawContext.getMatrices());
    }

    @Generated
    public iiiIIII_Class113 I_method_2e5b64d5() {
        return this.I_field_c11fcfcc;
    }

    @Generated
    public String I_method_3a0ffe21() {
        return this.I_field_523beb0a;
    }

    @Generated
    public String i_method_cd2eae41() {
        return this.i_field_523beb0a;
    }
}

