package rockstar.client;

import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import rockstar.client.AutoFarmModule;
import rockstar.client.IIiIIIIIi_Class66;
import rockstar.client.IIiIIIIiI_Class67;
import rockstar.client.IIiIIIIii_Class68;
import rockstar.client.IIiIIIiII_Class69;
import rockstar.client.ModeSetting;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.iIIIIIIii_Class260;
import rockstar.client.iIIiIIiIi_Class294;

public abstract class IIIiiiIii_Class60
extends ModeSetting.Nested1_42765c60
implements iIIiIIiIi_Class294 {
    protected final AutoFarmModule I_field_22f63e4c;

    public IIIiiiIii_Class60(AutoFarmModule iIIIiiiIi_Class30, ModeSetting iIiiiiiII_Class125, String string) {
        super(iIiiiiiII_Class125, string);
        this.I_field_22f63e4c = iIIIiiiIi_Class30;
    }

    public void I_method_a0f53e1f() {
    }

    public void i_method_a103c9ff() {
    }

    public void Ii_method_7e704cc2() {
    }

    public IIiIIIIIi_Class66 I_method_57286715() {
        return IIiIIIIIi_Class66.i_field_e6af4a4c;
    }

    public String I_method_e8739c21() {
        return null;
    }

    public IIiIIIiII_Class69 I_method_5736ef15() {
        return IIiIIIiII_Class69.I_field_e6bdd24c;
    }

    public IIiIIIIii_Class68 I_method_18285b35() {
        return this.I_method_5736ef15() == IIiIIIiII_Class69.I_field_e6bdd24c ? IIiIIIIii_Class68.I_field_e6afc26c : IIiIIIIii_Class68.i_field_e6afc26c;
    }

    public ItemStack I_method_907017b9() {
        return new ItemStack((ItemConvertible)Items.WHEAT);
    }

    protected final IIiIIIIiI_Class67 I_method_18285755() {
        return this.I_field_22f63e4c.I_method_8c2eeaf5();
    }

    protected final void iI_method_8024b102() {
        this.I_field_22f63e4c.disable();
    }

    protected final void I_method_cac07269(String string) {
        iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)IiIiIIII_Class81.I_method_f25a980a(string)));
    }

    protected final void i_method_9b77c649(String string) {
        iIIIIIIii_Class260.i_method_70898627(Text.of((String)IiIiIIII_Class81.I_method_f25a980a(string)));
    }

    protected final void II_method_e4a1362c(String string) {
        iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_f25a980a(string)));
    }
}

