package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import rockstar.client.iIIiiiIi_Class158;

public class iIIiiiiI_Class159 {
    private final List<iIIiiiIi_Class158> I_field_7865b31 = new ArrayList<iIIiiiIi_Class158>();
    private int I_field_49 = 0;
    private boolean I_field_5a = false;
    private boolean i_field_5a = false;

    public iIIiiiiI_Class159 I_method_344a788a(iIIiiiIi_Class158 iIIiiiIi_Class1582) {
        this.I_field_7865b31.add(iIIiiiIi_Class1582);
        return this;
    }

    public void I_method_b0af1cec() {
        if (this.I_field_7865b31.isEmpty()) {
            return;
        }
        this.I_field_5a = true;
        this.I_field_49 = 0;
        this.i_field_5a = false;
        for (iIIiiiIi_Class158 iIIiiiIi_Class1582 : this.I_field_7865b31) {
            iIIiiiIi_Class1582.i_method_4a91548c();
        }
        this.I_field_7865b31.get(0).I_method_4a82c8ac();
        this.i_field_5a = true;
    }

    public void i_method_b0bda8cc() {
        if (!this.I_field_5a || this.I_field_7865b31.isEmpty()) {
            return;
        }
        iIIiiiIi_Class158 iIIiiiIi_Class1582 = this.I_field_7865b31.get(this.I_field_49);
        if (!this.i_field_5a) {
            iIIiiiIi_Class1582.I_method_4a82c8ac();
            this.i_field_5a = true;
        }
        if (iIIiiiIi_Class1582.I_method_4a82c8b0()) {
            ++this.I_field_49;
            this.i_field_5a = false;
            if (this.I_field_49 >= this.I_field_7865b31.size()) {
                this.II_method_654377f5();
                return;
            }
            this.I_field_7865b31.get(this.I_field_49).I_method_4a82c8ac();
            this.i_field_5a = true;
        }
    }

    public void II_method_654377f5() {
        this.I_field_5a = false;
        this.I_field_49 = 0;
        this.i_field_5a = false;
        this.I_field_7865b31.clear();
    }

    public boolean I_method_b0af1cf0() {
        return this.I_field_5a;
    }

    @Generated
    public int I_method_b0af1cdf() {
        return this.I_field_49;
    }

    @Generated
    public boolean i_method_b0bda8d0() {
        return this.I_field_5a;
    }
}

