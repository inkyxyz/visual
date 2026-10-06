package rockstar.client;

import lombok.Generated;
import net.minecraft.util.Identifier;
import rockstar.client.iiIIIiIii_Class396;
import rockstar.client.iiIIIiiII_Class397;
import rockstar.client.iiIIIiiiI_Class399;
import rockstar.client.iiIiIIiii_Class424;

public class iiIIIiiIi_Class398 {
    private final iiIIIiIii_Class396.Nested1_450c0840 I_field_a02cd647;
    private final iiIiIIiii_Class424 I_field_991c1e8c;
    private int I_field_49 = 0;
    private boolean I_field_5a = true;
    private boolean i_field_5a = false;
    private boolean II_field_5a = false;

    public iiIIIiiIi_Class398(Identifier identifier) {
        this.I_field_a02cd647 = iiIIIiIii_Class396.I_method_f9a210d1(identifier);
        if (this.I_field_a02cd647 == null) {
            throw new RuntimeException("\u0410\u043d\u0438\u043c\u0430\u0446\u0438\u044f \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d\u0430 \u0432 \u0433\u043b\u043e\u0431\u0430\u043b\u044c\u043d\u043e\u043c \u0430\u0442\u043b\u0430\u0441\u0435: " + String.valueOf(identifier));
        }
        this.I_field_991c1e8c = new iiIiIIiii_Class424();
    }

    public void I_method_73113e1f() {
        this.I_field_49 = 0;
        this.I_field_5a = true;
        this.i_field_5a = false;
        this.II_field_5a = true;
        this.I_field_991c1e8c.I_method_23e11e3f();
    }

    public iiIIIiiiI_Class399 I_method_1f8cc735() {
        if (!this.I_field_5a || this.i_field_5a) {
            return this.I_field_a02cd647.I_method_2a3c675f(this.I_field_49);
        }
        this.i_method_731fc9ff();
        return this.I_field_a02cd647.I_method_2a3c675f(this.I_field_49);
    }

    public void i_method_731fc9ff() {
        if (!this.I_field_5a || this.i_field_5a) {
            return;
        }
        long l = this.I_field_a02cd647.I_field_fe172a8c.I_method_3c762a33();
        if (this.I_field_991c1e8c.I_method_58432069(l)) {
            this.ii_method_f0f6f922();
            this.I_field_991c1e8c.I_method_23e11e3f();
        }
    }

    private void ii_method_f0f6f922() {
        ++this.I_field_49;
        if (this.I_field_49 >= this.I_field_a02cd647.i_field_49) {
            if (this.II_field_5a) {
                this.I_field_49 = this.I_field_a02cd647.i_field_49 - 1;
                this.i_field_5a = true;
                this.II_field_5a = false;
            } else if (this.I_field_a02cd647.I_field_fe172a8c.I_method_3c762a43()) {
                this.I_field_49 = 0;
            } else {
                this.I_field_49 = this.I_field_a02cd647.i_field_49 - 1;
                this.i_field_5a = true;
            }
        }
    }

    public void II_method_ef257d22() {
        this.I_field_5a = true;
        this.i_field_5a = false;
        this.II_field_5a = false;
    }

    public void Ii_method_ef340902() {
        this.I_field_5a = false;
    }

    public void iI_method_f0e86d42() {
        this.I_field_5a = false;
        this.I_field_49 = 0;
        this.i_field_5a = false;
        this.II_field_5a = false;
        this.I_field_991c1e8c.I_method_23e11e3f();
    }

    public void I_method_ef16f8c4(int n) {
        if (n >= 0 && n < this.I_field_a02cd647.i_field_49) {
            this.I_field_49 = n;
            this.i_field_5a = false;
        }
    }

    public boolean I_method_73113e23() {
        return this.i_field_5a;
    }

    public iiIIIiiII_Class397 I_method_1f8c4f15() {
        return this.I_field_a02cd647.I_field_fe172a8c;
    }

    public Identifier I_method_cc0b1d2e() {
        return this.I_field_a02cd647.i_field_6a3d6525;
    }

    @Generated
    public int I_method_73113e12() {
        return this.I_field_49;
    }

    @Generated
    public boolean i_method_731fca03() {
        return this.I_field_5a;
    }
}

