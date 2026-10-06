package rockstar.client;

import java.util.function.Consumer;
import lombok.Generated;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIIiii_Class136;
import rockstar.client.iIIIiIII_Class137;
import rockstar.client.iIIIiiII_Class141;
import rockstar.client.iIIIiiii_Class144;
import rockstar.client.iIIiIIII_Class145;

public class iIIIiIiI_Class139
implements iIIIiiII_Class141,
iIIIiiii_Class144 {
    private final String I_field_523beb0a;
    private final iIIIIiii_Class136 I_field_c9fc2f81;
    private final int I_field_49;
    private final Consumer<Integer> I_field_f9f609fa;
    private int i_field_49;

    public iIIIiIiI_Class139(String string, int n, int n2, Consumer<Integer> consumer) {
        this.I_field_523beb0a = string;
        this.I_field_49 = n;
        this.i_field_49 = n2;
        this.I_field_f9f609fa = consumer;
        this.I_field_c9fc2f81 = new iIIIIiii_Class136("");
        this.I_field_c9fc2f81.I_method_7d663b96(String.valueOf(n2));
    }

    @Override
    public float I_method_c52f08dc() {
        return 20.0f;
    }

    @Override
    public void I_method_bc6592c6(III iII, float f, float f2, float f3) {
        boolean bl = this.i_field_49 > 0;
        ColorRGBA colorRGBA = bl ? IiiiiIIIi_Class242.i_method_5dfec6e().withAlpha(50.0f) : IiiiiIIIi_Class242.Ii_method_a0f56f71();
        iII.drawRoundedRect(f, f2, f3, 17.0f, IIiii_Class8.I_method_893b2757(3.0f), colorRGBA);
        iII.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), this.I_field_523beb0a, f + 6.0f, f2 + 6.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1());
        if (bl) {
            float f4 = 18.0f;
            this.I_field_c9fc2f81.I_method_ed5425da(iII, f + f3 - f4 - 2.0f, f2 + 2.0f, f4, 14.0f);
        }
    }

    @Override
    public boolean I_method_dd6e4c7a(iIIIiIII_Class137 iIIIiIII_Class1372, double d, double d2, int n) {
        boolean bl;
        boolean bl2 = bl = this.i_field_49 > 0;
        if (bl && this.I_field_c9fc2f81.I_method_aac23190(d, d2)) {
            this.I_field_c9fc2f81.I_method_dc381f88(true);
            return true;
        }
        if (bl) {
            this.i_field_49 = 0;
            this.I_field_c9fc2f81.I_method_7d663b96("0");
            this.I_field_f9f609fa.accept(0);
        } else {
            this.i_field_49 = 1;
            this.I_field_c9fc2f81.I_method_7d663b96("1");
            this.I_field_f9f609fa.accept(1);
        }
        return true;
    }

    public void I_method_2b5b5d2c() {
        iIIiIIII_Class145.I_method_38600fd1(this.I_field_c9fc2f81, this.i_field_49, iIIiIIII_Class145.I_method_b6bb3a42(0, this.I_field_49), n -> {
            this.i_field_49 = n;
            this.I_field_f9f609fa.accept(n);
        });
    }

    @Override
    public boolean I_method_2b5b5d30() {
        return this.I_field_c9fc2f81.I_method_d58e2cd0();
    }

    @Override
    public void i_method_2b69e90c() {
        if (this.I_field_c9fc2f81.I_method_d58e2cd0()) {
            this.I_method_2b5b5d2c();
            this.I_field_c9fc2f81.I_method_dc381f88(false);
        }
    }

    @Generated
    public String I_method_a77714f4() {
        return this.I_field_523beb0a;
    }

    @Generated
    public iIIIIiii_Class136 I_method_308bcf6b() {
        return this.I_field_c9fc2f81;
    }

    @Generated
    public int I_method_2b5b5d1f() {
        return this.I_field_49;
    }

    @Generated
    public Consumer<Integer> I_method_1db869d0() {
        return this.I_field_f9f609fa;
    }

    @Generated
    public int i_method_2b69e8ff() {
        return this.i_field_49;
    }
}

