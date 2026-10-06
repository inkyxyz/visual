package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.Locale;
import net.minecraft.client.render.VertexFormats;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.VectorRangeSetting;
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
import rockstar.client.iIiiiiIiI_Class379;
import rockstar.client.iiIIIIIii_Class388;
import ua.mintantileak.spk.Compile;

public class IiiiIIiIi_Class230
extends IiiIiiIii_Class220<VectorRangeSetting> {
    private final IiiiIiIii_Class236 i_field_dc7facc = new IiiiIiIii_Class236(400L, IiiiIiiII_Class237.II_field_dd60aac);
    private final IiiiIiIii_Class236 II_field_dc7facc = new IiiiIiIii_Class236(400L, IiiiIiiII_Class237.II_field_dd60aac);
    private boolean I_field_5a;

    public IiiiIIiIi_Class230(VectorRangeSetting iIiiiiiIi_Class126, iI_Class3 iI_Class32) {
        super(iIiiiiiIi_Class126, iI_Class32);
    }

    @Override
    protected void i_method_bdd4e0ec(III iII) {
        Object object;
        float f;
        float f2;
        float f3;
        float f4 = this.I_field_46 + 9.0f;
        float f5 = this.i_field_46 + 2.0f;
        float f6 = this.II_field_46 - 18.0f;
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f);
        IIiIIi_Class10 iIiIIi_Class102 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f);
        float f7 = 10.0f;
        this.I_field_dc7facc.I_method_edd72835(this.I_method_a74dc6d0(iII.I_method_b1c3e152(), iII.i_method_b1d26d32()));
        float f8 = f4;
        float f9 = f5 + 17.0f;
        float f10 = f6;
        iII.drawRoundedRect(f8 - 1.0f, f9 - 1.0f, f10 + 2.0f, f10 + 2.0f, IIiii_Class8.I_method_893b2757(3.0f), IiiiiIIIi_Class242.II_method_190e6391().withAlpha(89.25f));
        iII.drawRoundedRect(f8, f9, f10, f10, IIiii_Class8.I_method_893b2757(2.0f), IiiiiIIIi_Class242.II_method_190e6391().withAlpha(140.25f));
        iiIIIIIii_Class388 iiIIIIIii_Class3882 = new iiIIIIIii_Class388(VertexFormats.POSITION_COLOR, iII.getMatrices());
        for (int i = 1; i < 10; ++i) {
            f3 = (float)i / 10.0f;
            f2 = f8 + f10 * f3;
            f = f9 + f10 * f3;
            object = IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(0.08f);
            iII.drawRect(f2, f9, 1.0f, f10, (ColorRGBA)object);
            iII.drawRect(f8, f, f10, 1.0f, (ColorRGBA)object);
        }
        this.i_field_dc7facc.I_method_edd6dd11(((VectorRangeSetting)this.I_field_ba11c26c).I_method_82f061ef());
        this.II_field_dc7facc.I_method_edd6dd11(((VectorRangeSetting)this.I_field_ba11c26c).i_method_82feedcf());
        float f11 = iIIiIIIiI_Class291.I_method_fc7140f1(this.i_field_dc7facc.I_method_6ac4da6f(), ((VectorRangeSetting)this.I_field_ba11c26c).II_method_db2ad532(), ((VectorRangeSetting)this.I_field_ba11c26c).Ii_method_db396112());
        f3 = iIIiIIIiI_Class291.I_method_fc7140f1(this.II_field_dc7facc.I_method_6ac4da6f(), ((VectorRangeSetting)this.I_field_ba11c26c).iI_method_dcedc552(), ((VectorRangeSetting)this.I_field_ba11c26c).ii_method_dcfc5132());
        f2 = f8 + f10 * f11;
        f = f9 + f10 * f3;
        iII.drawRect(f2 - 0.5f, f9, 1.0f, f10, IiiiiIIIi_Class242.i_method_5dfec6e());
        iII.drawRect(f8, f - 0.5f, f10, 1.0f, IiiiiIIIi_Class242.i_method_5dfec6e());
        ((iIiiiiIiI_Class379)iiIIIIIii_Class3882).II_method_ed687102();
        object = String.format(Locale.ROOT, "%.1f : %.1f", Float.valueOf(this.i_field_dc7facc.I_method_6ac4da6f()), Float.valueOf(this.II_field_dc7facc.I_method_6ac4da6f()));
        float f12 = iIiIIi_Class102.I_method_2c375926((String)object);
        float f13 = iIiIIi_Class102.I_method_a649725c();
        float f14 = f12 + 6.0f;
        float f15 = f13 + 4.0f;
        float f16 = f4 + f6 - f14;
        float f17 = f5 + 11.0f - iIiIIi_Class102.I_method_a649725c() - 2.0f;
        iII.drawRoundedRect(f16, f17, f14, f15, IIiii_Class8.I_method_893b2757(3.0f), IiiiiIIIi_Class242.II_method_190e6391().withAlpha(153.0f));
        this.I_method_2d447471(iII, iIiIIi_Class10, IiIiIIII_Class81.I_method_f25a980a(((VectorRangeSetting)this.I_field_ba11c26c).getName()), this.I_field_46 + f7, f5 + 11.0f - iIiIIi_Class10.I_method_a649725c(), this.I_method_c4c8e2f8().II_method_c7206932() - f7 - f14 - 10.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * (0.75f + 0.25f * this.I_field_dc7facc.I_method_6ac4da6f())), 0.8f, 1.0f);
        boolean bl = iIIiIIIiI_Class291.I_method_da20b32b(f8, f9, f10, f10, iII);
        if (bl || this.I_field_5a) {
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.ii_field_aa52e62c);
        } else if (this.I_method_7ae26dde(iII) && (float)iII.i_method_b1d26d32() > this.III_method_f4aafe8f() && (float)iII.i_method_b1d26d32() < this.III_method_f4aafe8f() + this.IIi_method_f4b98a6f()) {
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
        }
        if (this.I_field_5a) {
            float f18 = iIIiIIIiI_Class291.I_method_a531f52f(((VectorRangeSetting)this.I_field_ba11c26c).II_method_db2ad532(), ((VectorRangeSetting)this.I_field_ba11c26c).Ii_method_db396112(), f8, f10, iII.I_method_b1c3e152());
            float f19 = iIIiIIIiI_Class291.I_method_a531f52f(((VectorRangeSetting)this.I_field_ba11c26c).iI_method_dcedc552(), ((VectorRangeSetting)this.I_field_ba11c26c).ii_method_dcfc5132(), f9, f10, iII.i_method_b1d26d32());
            ((VectorRangeSetting)this.I_field_ba11c26c).I_method_886cd63f(f18, f19);
        }
    }

    @Override
    public void Ii_method_6b12c484(III iII) {
        float f = this.I_field_46 + 9.0f;
        float f2 = this.i_field_46 + 2.0f;
        float f3 = this.II_field_46 - 18.0f;
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f);
        String string = String.format(Locale.ROOT, "%.1f : %.1f", Float.valueOf(this.i_field_dc7facc.I_method_6ac4da6f()), Float.valueOf(this.II_field_dc7facc.I_method_6ac4da6f()));
        float f4 = iIiIIi_Class10.I_method_2c375926(string);
        float f5 = iIiIIi_Class10.I_method_a649725c();
        float f6 = f4 + 6.0f;
        float f7 = f5 + 4.0f;
        float f8 = f + f3 - f6;
        float f9 = f2 + 11.0f - iIiIIi_Class10.I_method_a649725c() - 2.0f;
        iII.drawText(iIiIIi_Class10, string, f8 + 3.0f, f9 + iIIiIIIiI_Class291.I_method_ef5e7a8f(f5, f7), IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * (0.75f + 0.25f * this.I_field_dc7facc.I_method_6ac4da6f()) * RenderSystem.getShaderColor()[3]));
    }

    @Override
    @Compile
    public void I_method_400ceaa7(double d, double d2, IiIII_Class9 iiIII_Class9) {
        float f = this.I_field_46 + 9.0f;
        float f2 = this.i_field_46 + 2.0f;
        float f3 = this.II_field_46 - 18.0f;
        float f4 = f;
        float f5 = f2 + 17.0f;
        float f6 = f3;
        if (iiIII_Class9 == IiIII_Class9.I_field_2f4c8d6c && iIIiIIIiI_Class291.I_method_c3f86263(f4, f5, f6, f6, d, d2)) {
            this.I_field_5a = true;
            float f7 = iIIiIIIiI_Class291.I_method_a531f52f(((VectorRangeSetting)this.I_field_ba11c26c).II_method_db2ad532(), ((VectorRangeSetting)this.I_field_ba11c26c).Ii_method_db396112(), f4, f6, d);
            float f8 = iIIiIIIiI_Class291.I_method_a531f52f(((VectorRangeSetting)this.I_field_ba11c26c).iI_method_dcedc552(), ((VectorRangeSetting)this.I_field_ba11c26c).ii_method_dcfc5132(), f5, f6, d2);
            ((VectorRangeSetting)this.I_field_ba11c26c).I_method_886cd63f(f7, f8);
        }
        super.I_method_400ceaa7(d, d2, iiIII_Class9);
    }

    @Override
    public void i_method_6a097ac7(double d, double d2, IiIII_Class9 iiIII_Class9) {
        this.I_field_5a = false;
        super.i_method_6a097ac7(d, d2, iiIII_Class9);
    }

    @Override
    public void iI_method_20338844(III iII) {
        iII.drawRect(this.I_field_46, this.i_field_46 + this.Ii_field_46, this.II_field_46, 0.5f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(5.1f));
    }

    @Override
    public float Ii_method_2047ead7() {
        float f = this.II_field_46 - 18.0f;
        this.Ii_field_46 = Math.max(48.0f, f + 24.0f);
        return this.Ii_field_46;
    }
}

