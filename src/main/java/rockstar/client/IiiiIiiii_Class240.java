package rockstar.client;

import lombok.NonNull;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.iiIIiIIii_Class404;

public class IiiiIiiii_Class240 {
    private static final IiiiIiiII_Class237 I_field_dd60aac = IiiiIiiII_Class237.Iii_field_dd60aac;
    private final IiiiIiIii_Class236 I_field_dc7facc;
    private final IiiiIiIii_Class236 i_field_dc7facc;

    public IiiiIiiii_Class240(long l, long l2, IiiiIiiII_Class237 iiiiIiiII_Class237) {
        this.I_field_dc7facc = new IiiiIiIii_Class236(l, iiiiIiiII_Class237);
        this.i_field_dc7facc = new IiiiIiIii_Class236(l2, iiiiIiiII_Class237);
    }

    public IiiiIiiii_Class240(long l) {
        this(l, l, I_field_dd60aac);
    }

    public IiiiIiiii_Class240(long l, long l2, iiIIiIIii_Class404 iiIIiIIii_Class4042, IiiiIiiII_Class237 iiiiIiiII_Class237) {
        this.I_field_dc7facc = new IiiiIiIii_Class236(l, iiIIiIIii_Class4042.I_method_14534e0f(), iiiiIiiII_Class237);
        this.i_field_dc7facc = new IiiiIiIii_Class236(l2, iiIIiIIii_Class4042.i_method_1461d9ef(), iiiiIiiII_Class237);
    }

    public IiiiIiiii_Class240(long l, iiIIiIIii_Class404 iiIIiIIii_Class4042) {
        this(l, l, iiIIiIIii_Class4042, I_field_dd60aac);
    }

    public void I_method_c954cc67(@NonNull iiIIiIIii_Class404 iiIIiIIii_Class4042) {
        if (iiIIiIIii_Class4042 == null) {
            throw new NullPointerException("rotation is marked non-null but is null");
        }
        this.I_field_dc7facc.I_method_edd6dd11(iiIIiIIii_Class4042.I_method_14534e0f());
        this.i_field_dc7facc.I_method_edd6dd11(iiIIiIIii_Class4042.i_method_1461d9ef());
    }

    public iiIIiIIii_Class404 I_method_caddcb35() {
        return new iiIIiIIii_Class404(this.I_field_dc7facc.I_method_6ac4da6f(), this.i_field_dc7facc.I_method_6ac4da6f());
    }

    public void I_method_7664cc45(long l) {
        this.I_field_dc7facc.I_method_edd6ec25(l);
    }

    public void i_method_7827bc65(long l) {
        this.i_field_dc7facc.I_method_edd6ec25(l);
    }

    public void I_method_ba4788a7(IiiiIiiII_Class237 iiiiIiiII_Class237) {
        this.I_field_dc7facc.I_method_df2f9087(iiiiIiiII_Class237);
        this.i_field_dc7facc.I_method_df2f9087(iiiiIiiII_Class237);
    }

    public void i_method_666dd487(@NonNull iiIIiIIii_Class404 iiIIiIIii_Class4042) {
        if (iiIIiIIii_Class4042 == null) {
            throw new NullPointerException("rotation is marked non-null but is null");
        }
        this.I_field_dc7facc.I_method_edd6dd21(iiIIiIIii_Class4042.I_method_14534e0f());
        this.i_field_dc7facc.I_method_edd6dd21(iiIIiIIii_Class4042.i_method_1461d9ef());
    }
}

