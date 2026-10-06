package rockstar.client;

import lombok.Generated;
import net.minecraft.client.render.VertexFormats;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.InterfaceModule;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIiiiiiI_Class319;
import rockstar.client.iIiiiIIiI_Class371;
import rockstar.client.iIiiiiIiI_Class379;
import rockstar.client.iiIIIIIIi_Class386;
import rockstar.client.iiIiiiI_Class111;

public abstract class iiiIiiI_Class119
extends iiIiiiI_Class111 {
    protected final String I_field_523beb0a;
    protected String i_field_523beb0a;
    protected ColorRGBA I_field_d0c8ec5;

    protected iiiIiiI_Class119(String string, String string2, ColorRGBA colorRGBA) {
        super(2500L);
        this.I_field_523beb0a = string;
        this.i_field_523beb0a = string2;
        this.I_field_d0c8ec5 = colorRGBA;
    }

    protected abstract void I_method_3b7cb03(CustomDrawContext var1, float var2, float var3, float var4);

    @Override
    public float I_method_ddda8caf() {
        return 25.0f;
    }

    @Override
    public final void I_method_92bd6423(CustomDrawContext customDrawContext, float f) {
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0f);
        float f2 = iIiIIi_Class10.I_method_2c375926(this.I_field_523beb0a) + 26.0f;
        float f3 = 20.0f;
        float f4 = (this.I_method_ddda8caf() - f3) / 2.0f;
        this.II_field_dc7facc.I_method_df2f9087(IiiiIiiII_Class237.Ii_field_dd60aac);
        this.II_field_dc7facc.I_method_edd6ec25(300L);
        float f5 = (float)customDrawContext.getScaledWindowWidth() / 2.0f - f2 / 2.0f;
        float f6 = (float)customDrawContext.getScaledWindowHeight() - 87.0f - this.II_field_dc7facc.I_method_edd6dd11(f) + f4;
        float f7 = this.I_field_dc7facc.I_method_6ac4da6f();
        int n = (int)(255.0f * f7);
        iIiiiIIiI_Class371.II_method_e18635ac(customDrawContext.getMatrices(), f5 + f2 / 2.0f, f6 + 10.0f, 0.5f + 0.5f * f7);
        if (InterfaceModule.Iii_method_c4da86a3()) {
            customDrawContext.drawLiquidGlass(f5, f6, f2, 20.0f, 7.0f, 0.08f, IIiii_Class8.I_method_893b2757(7.0f), ColorRGBA.WHITE.withAlpha(255.0f * f7 * InterfaceModule.I_method_fdcdb22f()));
            customDrawContext.drawSquircle(f5, f6, f2, 20.0f, 7.0f, IIiii_Class8.I_method_893b2757(7.0f), IiiiiIIIi_Class242.II_method_190e6391().withAlpha(255.0f * iIIiiiiiI_Class319.I_method_5f7ff5cf(IiiiiIIIi_Class242.I_method_5ac4a715().II_method_b3b834f2(), IiiiiIIIi_Class242.I_method_5ac4a715().Ii_method_b3c6c0d2(), InterfaceModule.I_method_fdcdb22f()) * f7));
        } else {
            customDrawContext.drawBlurredRect(f5, f6, f2, 20.0f, 45.0f, 7.0f, IIiii_Class8.I_method_893b2757(7.0f), ColorRGBA.WHITE.withAlpha(255.0f * f7 * InterfaceModule.i_method_fddc3e0f()));
            customDrawContext.drawSquircle(f5, f6, f2, 20.0f, 7.0f, IIiii_Class8.I_method_893b2757(7.0f), new ColorRGBA(0.0f, 0.0f, 0.0f).withAlpha((int)(140.25f * f7)));
        }
        this.I_method_3b7cb03(customDrawContext, f5 + 5.0f, f6 + 5.0f, f7);
        float f8 = f5 + 20.0f;
        float f9 = f6 + (20.0f - iIiIIi_Class10.I_method_a649725c()) / 2.0f;
        iiIIIIIIi_Class386 iiIIIIIIi_Class3862 = new iiIIIIIIi_Class386(VertexFormats.POSITION_TEXTURE_COLOR, iIiIIi_Class10.I_method_36d49b4b());
        ColorRGBA colorRGBA = ColorRGBA.WHITE.withAlpha(n);
        if (this.i_field_523beb0a != null && this.I_field_d0c8ec5 != null && this.I_field_523beb0a.contains(this.i_field_523beb0a)) {
            int n2 = this.I_field_523beb0a.indexOf(this.i_field_523beb0a);
            String string = this.I_field_523beb0a.substring(0, n2);
            String string2 = this.I_field_523beb0a.substring(n2 + this.i_field_523beb0a.length());
            float f10 = f8;
            if (!string.isEmpty()) {
                customDrawContext.drawText(iIiIIi_Class10, string, f10, f9, colorRGBA);
                f10 += iIiIIi_Class10.I_method_2c375926(string);
            }
            customDrawContext.drawText(iIiIIi_Class10, this.i_field_523beb0a, f10, f9, this.I_field_d0c8ec5.withAlpha(n));
            f10 += iIiIIi_Class10.I_method_2c375926(this.i_field_523beb0a);
            if (!string2.isEmpty()) {
                customDrawContext.drawText(iIiIIi_Class10, string2, f10, f9, colorRGBA);
            }
        } else {
            customDrawContext.drawText(iIiIIi_Class10, this.I_field_523beb0a, f8, f9, colorRGBA);
        }
        ((iIiiiiIiI_Class379)iiIIIIIIi_Class3862).II_method_ed687102();
        iIiiiIIiI_Class371.I_method_10503b11(customDrawContext.getMatrices());
    }

    @Generated
    public String I_method_fa185201() {
        return this.I_field_523beb0a;
    }

    @Generated
    public String i_method_8d370221() {
        return this.i_field_523beb0a;
    }

    @Generated
    public ColorRGBA I_method_f3d47aee() {
        return this.I_field_d0c8ec5;
    }
}

