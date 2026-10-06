package rockstar.client;

import rockstar.client.RockstarClient;
import rockstar.client.iIIiiiIi_Class158;
import rockstar.client.iiIIiIIIi_Class402;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.iiIIiIiII_Class405;
import rockstar.client.iiIIiIiiI_Class407;

public class iIiIIIIi_Class162
implements iIIiiiIi_Class158 {
    private final Float I_field_5fa2c89f;
    private final Float i_field_5fa2c89f;
    private final boolean I_field_5a;
    private boolean i_field_5a = false;

    public iIiIIIIi_Class162(Float f, Float f2, boolean bl) {
        this.I_field_5fa2c89f = f;
        this.i_field_5fa2c89f = f2;
        this.I_field_5a = bl;
    }

    public static iIiIIIIi_Class162 I_method_bd4e99ab(Float f, Float f2) {
        return new iIiIIIIi_Class162(f, f2, true);
    }

    public static iIiIIIIi_Class162 I_method_4843c7cb() {
        return new iIiIIIIi_Class162(null, null, false);
    }

    @Override
    public void I_method_4a82c8ac() {
        if (!this.I_field_5a) {
            this.i_field_5a = true;
        }
    }

    @Override
    public boolean I_method_4a82c8b0() {
        if (this.I_field_5a) {
            iiIIiIiII_Class405 iiIIiIiII_Class4052 = RockstarClient.getInstance().I_method_58785402();
            float f = this.I_field_5fa2c89f != null ? this.I_field_5fa2c89f.floatValue() : iiIIiIiII_Class4052.i_method_10b2eeb5().I_method_14534e0f();
            float f2 = this.i_field_5fa2c89f != null ? this.i_field_5fa2c89f.floatValue() : iiIIiIiII_Class4052.i_method_10b2eeb5().i_method_1461d9ef();
            iiIIiIiII_Class4052.I_method_1acbf705(new iiIIiIIii_Class404(f, f2), iiIIiIIIi_Class402.Ii_field_32e0c64c, 180.0f, 180.0f, 180.0f, iiIIiIiiI_Class407.iI_field_32efc66c);
            return false;
        }
        return this.i_field_5a;
    }

    @Override
    public void i_method_4a91548c() {
        this.i_field_5a = false;
    }
}

