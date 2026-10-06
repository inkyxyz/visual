package rockstar.client;

import lombok.Generated;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.iiIiIIiii_Class424;

public abstract class IIiIiiiiI_Class95 {
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
    public final IiiiIiIii_Class236 I_field_dc7facc;
    public final IiiiIiIii_Class236 i_field_dc7facc;
    public final IiiiIiIii_Class236 II_field_dc7facc;
    public final long I_field_4a;

    public IIiIiiiiI_Class95(long l) {
        this.I_field_4a = l;
        this.I_field_dc7facc = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.I_field_dd60aac);
        this.II_field_dc7facc = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.i_field_dd60aac);
        this.i_field_dc7facc = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.Ii_field_dd60aac);
    }

    public abstract void I_method_df9d7d83(CustomDrawContext var1, float var2);

    public final void I_method_4c865e1f() {
        this.I_field_dc7facc.I_method_edd6dd11(this.I_field_991c1e8c.I_method_58432069(this.I_field_4a) ? 0.0f : 1.0f);
    }

    public final boolean I_method_4c865e23() {
        return this.I_field_dc7facc.I_method_6ac4da6f() == 0.0f && this.I_field_991c1e8c.I_method_58432069(this.I_field_4a);
    }

    @Generated
    public iiIiIIiii_Class424 I_method_1dde6315() {
        return this.I_field_991c1e8c;
    }

    @Generated
    public IiiiIiIii_Class236 I_method_928a3f55() {
        return this.I_field_dc7facc;
    }

    @Generated
    public IiiiIiIii_Class236 i_method_a81fb335() {
        return this.i_field_dc7facc;
    }

    @Generated
    public IiiiIiIii_Class236 II_method_9fbab098() {
        return this.II_field_dc7facc;
    }

    @Generated
    public long I_method_4c865e13() {
        return this.I_field_4a;
    }
}

