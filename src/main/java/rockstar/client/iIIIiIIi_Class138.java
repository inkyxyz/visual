package rockstar.client;

import java.util.function.Consumer;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIiIII_Class137;
import rockstar.client.iIIIiiII_Class141;

public class iIIIiIIi_Class138
implements iIIIiiII_Class141 {
    private final String I_field_523beb0a;
    private final ColorRGBA I_field_d0c8ec5;
    private final Consumer<iIIIiIII_Class137> I_field_f9f609fa;

    public iIIIiIIi_Class138(String string, ColorRGBA colorRGBA, Consumer<iIIIiIII_Class137> consumer) {
        this.I_field_523beb0a = string;
        this.I_field_d0c8ec5 = colorRGBA;
        this.I_field_f9f609fa = consumer;
    }

    @Override
    public float I_method_c52f08dc() {
        return 18.0f;
    }

    @Override
    public void I_method_bc6592c6(III iII, float f, float f2, float f3) {
        iII.drawRoundedRect(f, f2, f3, this.I_method_c52f08dc(), IIiii_Class8.I_method_893b2757(3.0f), IiiiiIIIi_Class242.Ii_method_a0f56f71());
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f);
        float f4 = f + (f3 - iIiIIi_Class10.I_method_2c375926(this.I_field_523beb0a)) / 2.0f;
        float f5 = f2 + (this.I_method_c52f08dc() - iIiIIi_Class10.I_method_a649725c()) / 2.0f;
        iII.drawText(iIiIIi_Class10, this.I_field_523beb0a, f4, f5, this.I_field_d0c8ec5);
    }

    @Override
    public boolean I_method_dd6e4c7a(iIIIiIII_Class137 iIIIiIII_Class1372, double d, double d2, int n) {
        this.I_field_f9f609fa.accept(iIIIiIII_Class1372);
        return true;
    }
}

