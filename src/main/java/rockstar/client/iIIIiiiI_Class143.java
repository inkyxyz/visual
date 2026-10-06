package rockstar.client;

import java.util.function.Consumer;
import lombok.Generated;
import rockstar.client.III;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIiIII_Class137;
import rockstar.client.iIIIiiII_Class141;
import rockstar.client.iIIiIIIiI_Class291;

public class iIIIiiiI_Class143
implements iIIIiiII_Class141 {
    private final String I_field_523beb0a;
    private final int I_field_49;
    private final int i_field_49;
    private int II_field_49;
    private final Consumer<Integer> I_field_f9f609fa;
    private boolean I_field_5a;

    public iIIIiiiI_Class143(String string, int n, int n2, int n3, Consumer<Integer> consumer) {
        this.I_field_523beb0a = string;
        this.I_field_49 = n;
        this.i_field_49 = n2;
        this.II_field_49 = n3;
        this.I_field_f9f609fa = consumer;
    }

    @Override
    public float I_method_c52f08dc() {
        return 20.0f;
    }

    @Override
    public void I_method_bc6592c6(III iII, float f, float f2, float f3) {
        iII.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), this.I_field_523beb0a, f, f2 + 2.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1());
        iII.drawRightText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), String.valueOf(this.II_field_49), f + f3, f2 + 2.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(180.0f));
        float f4 = f2 + 14.0f;
        float f5 = (float)(this.II_field_49 - this.I_field_49) / (float)(this.i_field_49 - this.I_field_49);
        iII.drawRoundedRect(f, f4, f3, 2.0f, IIiii_Class8.I_method_893b2757(0.25f), IiiiiIIIi_Class242.Ii_method_a0f56f71());
        iII.drawRoundedRect(f, f4, f3 * f5, 2.0f, IIiii_Class8.I_method_893b2757(0.25f), IiiiiIIIi_Class242.i_method_5dfec6e());
        iII.drawRoundedRect(f + f3 * f5 - 3.0f, f4 - 2.0f, 6.0f, 6.0f, IIiii_Class8.I_method_893b2757(3.0f), IiiiiIIIi_Class242.i_method_5dfec6e());
        if (this.I_field_5a) {
            float f6 = iIIiIIIiI_Class291.I_method_a531f52f(this.I_field_49, this.i_field_49, f, f3, iII.I_method_b1c3e152());
            this.II_field_49 = Math.round(f6);
            this.I_field_f9f609fa.accept(this.II_field_49);
        }
    }

    @Override
    public boolean I_method_dd6e4c7a(iIIIiIII_Class137 iIIIiIII_Class1372, double d, double d2, int n) {
        this.I_field_5a = true;
        return true;
    }

    public void I_method_2780f90c() {
        this.I_field_5a = false;
    }

    @Generated
    public boolean I_method_2780f910() {
        return this.I_field_5a;
    }
}

