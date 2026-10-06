package rockstar.client;

import net.minecraft.item.Items;
import rockstar.client.IiIIIIii_Class68;
import rockstar.client.iIIIIIIII_Class257;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiIIii_Class148;
import rockstar.client.iIiIIiIi_Class166;
import rockstar.client.iIiiIIii_Class180;
import rockstar.client.iiIiIIiii_Class424;

public class iIiiIIII_Class177
extends iIiiIIii_Class180
implements iIIiIIiIi_Class294 {
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
    private boolean I_field_5a;

    public iIiiIIII_Class177() {
        super("modules.settings.assist.experience_scroll", Items.FLOWER_BANNER_PATTERN, iIIiIIii_Class148.i_field_88b781, "\u0441\u0432\u0438\u0442", "\u043e\u043f\u044b\u0442");
    }

    @Override
    public void I_method_75fee90c() {
        this.I_field_5a = true;
        this.I_field_991c1e8c.I_method_23e11e3f();
        this.II_method_4d9683f5();
    }

    @Override
    public boolean II_method_398e0bf9() {
        return true;
    }

    @Override
    public boolean I_method_75fee910() {
        return iIiIIiIi_Class166.II_method_d6557419();
    }

    @Override
    public boolean i_method_9ed094d0() {
        return this.I_field_5a;
    }

    @Override
    public void i_method_9ed094cc() {
        if (!this.I_field_5a) {
            return;
        }
        if (iIiiIIII_Class177.I_field_3a9bda27.player == null || iIiiIIII_Class177.I_field_3a9bda27.world == null || iIiiIIII_Class177.I_field_3a9bda27.currentScreen != null || !this.Ii_method_4da50fd9()) {
            this.I_field_5a = false;
            return;
        }
        if (this.I_field_991c1e8c.I_method_58432069(50L)) {
            this.I_field_991c1e8c.I_method_23e11e3f();
            this.II_method_4d9683f5();
        }
    }

    private void II_method_4d9683f5() {
        if (!IiIIIIii_Class68.I_field_108dc26c.I_method_801dd223()) {
            IiIIIIii_Class68.I_field_108dc26c.I_method_a4f79a60(this.I_method_7c1bdb22(), this::I_method_b921bd52, this.i_method_1f641154());
        }
    }

    private boolean Ii_method_4da50fd9() {
        return iIIIIIIII_Class257.II_method_98333a25(this.I_method_75fee8ff());
    }
}

