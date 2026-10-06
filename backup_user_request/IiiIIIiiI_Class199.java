package rockstar.client;

import lombok.Generated;
import rockstar.client.MultiSelectSetting;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.iiIiIIiii_Class424;

public class IiiIIIiiI_Class199
extends MultiSelectSetting.Nested1_42856060 {
    private String I_field_523beb0a = "?";
    private String i_field_523beb0a = "";
    private final String II_field_523beb0a;
    private boolean I_field_5a;
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
    private final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0f, IiiiIiiII_Class237.I_field_dd60aac);
    private final IiiiIiIii_Class236 i_field_dc7facc = new IiiiIiIii_Class236(500L, 0.0f, IiiiIiiII_Class237.Ii_field_dd60aac);

    public IiiIIIiiI_Class199(MultiSelectSetting iIiiiiiii_Class128, String string, String string2) {
        super(iIiiiiiii_Class128, string);
        this.select();
        this.II_field_523beb0a = " " + string2;
    }

    public IiiIIIiiI_Class199(MultiSelectSetting iIiiiiiii_Class128, String string) {
        super(iIiiiiiii_Class128, string);
        this.select();
        this.II_field_523beb0a = "";
    }

    public void I_method_c10e6bd3(String string, String string2) {
        if (!this.isSelected()) {
            return;
        }
        this.I_field_523beb0a = string;
        this.i_field_523beb0a = string2;
    }

    public void I_method_ca27e249(String string) {
        if (!this.isSelected()) {
            return;
        }
        this.I_field_523beb0a = string;
    }

    @Generated
    public String I_method_e86eb041() {
        return this.I_field_523beb0a;
    }

    @Generated
    public String i_method_7b8d6061() {
        return this.i_field_523beb0a;
    }

    @Generated
    public String II_method_2ac143de() {
        return this.II_field_523beb0a;
    }

    @Generated
    public boolean I_method_b2b2a43() {
        return this.I_field_5a;
    }

    @Generated
    public iiIiIIiii_Class424 I_method_dafe4735() {
        return this.I_field_991c1e8c;
    }

    @Generated
    public IiiiIiIii_Class236 I_method_4faa2375() {
        return this.I_field_dc7facc;
    }

    @Generated
    public IiiiIiIii_Class236 i_method_653f9755() {
        return this.i_field_dc7facc;
    }

    @Generated
    public IiiIIIiiI_Class199 I_method_e37401eb(boolean bl) {
        this.I_field_5a = bl;
        return this;
    }
}

