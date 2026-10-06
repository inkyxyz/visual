package rockstar.client;

import net.minecraft.item.Items;
import rockstar.client.RockstarClient;
import rockstar.client.iIIiIIii_Class148;
import rockstar.client.iIIiiiiI_Class159;
import rockstar.client.iIIiiiii_Class160;
import rockstar.client.iIiIIIiI_Class163;
import rockstar.client.iIiIIIii_Class164;
import rockstar.client.iiIIiIIIi_Class402;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.iiIIiIiiI_Class407;

public class iIiIiiIi_Class174
extends iIiIIIii_Class164 {
    private final iIIiiiiI_Class159 I_field_25a2fa1 = new iIIiiiiI_Class159();
    private boolean I_field_5a = false;

    public iIiIiiIi_Class174() {
        super("modules.settings.assist.wind_charge", Items.WIND_CHARGE.getDefaultStack(), iIIiIIii_Class148.Ii_field_88b781);
    }

    @Override
    public void I_method_75fee90c() {
        float f = RockstarClient.getInstance().I_method_58785402().i_method_10b2eeb5().I_method_14534e0f();
        this.I_field_5a = true;
        this.I_field_25a2fa1.I_method_344a788a(new iIIiiiii_Class160(100L)).I_method_344a788a(new iIiIIIiI_Class163(Items.WIND_CHARGE)).I_method_344a788a(new iIIiiiii_Class160(100L)).I_method_b0af1cec();
    }

    @Override
    public boolean II_method_398e0bf9() {
        return true;
    }

    @Override
    public boolean i_method_9ed094d0() {
        return this.I_field_25a2fa1.I_method_b0af1cf0() || this.I_field_5a;
    }

    @Override
    public void i_method_9ed094cc() {
        if (this.I_field_5a && !this.I_field_25a2fa1.I_method_b0af1cf0()) {
            this.I_field_5a = false;
        }
        if (this.I_field_5a) {
            float f = RockstarClient.getInstance().I_method_58785402().i_method_10b2eeb5().I_method_14534e0f();
            RockstarClient.getInstance().I_method_58785402().I_method_1acbf705(new iiIIiIIii_Class404(f, 90.0f), iiIIiIIIi_Class402.Ii_field_32e0c64c, 180.0f, 180.0f, 180.0f, iiIIiIiiI_Class407.iI_field_32efc66c);
        }
        this.I_field_25a2fa1.i_method_b0bda8cc();
    }
}

