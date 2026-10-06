package rockstar.client;

import lombok.Generated;
import net.minecraft.item.ItemStack;
import rockstar.client.IiiIIiIi_Class102;
import rockstar.client.IiiiIIii_Class116;

public class IiiiIIiI_Class115 {
    private ItemStack I_field_f2735522;
    private IiiiIIii_Class116.Nested1_8029513 I_field_765e3dbc;

    public void I_method_85116f08(IiiiIIii_Class116.Nested1_8029513 nested1_8029513) {
        this.I_field_f2735522 = nested1_8029513.I_method_c2b2cc91();
        this.I_field_765e3dbc = nested1_8029513;
    }

    public void I_method_ee65d4cc() {
        this.I_field_f2735522 = null;
        this.I_field_765e3dbc = null;
    }

    public void I_method_2bff812e(ItemStack itemStack) {
        if (this.I_field_f2735522 != null && ItemStack.areItemsAndComponentsEqual((ItemStack)this.I_field_f2735522, (ItemStack)itemStack)) {
            this.I_method_ee65d4cc();
        }
    }

    public String I_method_c4f6d154() {
        return this.I_field_765e3dbc != null ? this.I_field_765e3dbc.I_method_d1d7d0f9() : null;
    }

    public String i_method_58158174() {
        return this.I_field_765e3dbc != null ? this.I_field_765e3dbc.i_method_64f68119() : null;
    }

    public boolean I_method_85116f0c(IiiiIIii_Class116.Nested1_8029513 nested1_8029513) {
        return this.I_field_765e3dbc != null && this.I_field_765e3dbc.i_method_64f68119() != null && this.I_field_765e3dbc.i_method_64f68119().equals(nested1_8029513.i_method_64f68119());
    }

    public boolean i_method_8b196aec(IiiiIIii_Class116.Nested1_8029513 nested1_8029513) {
        for (IiiIIiIi_Class102.Nested1_6cef9133 nested1_6cef9133 : IiiIIiIi_Class102.I_method_2a0b303b()) {
            if (nested1_6cef9133.i_method_29f1a539() == null || !nested1_6cef9133.i_method_29f1a539().equals(nested1_8029513.i_method_64f68119())) continue;
            return true;
        }
        return false;
    }

    @Generated
    public ItemStack I_method_c7e51c6c() {
        return this.I_field_f2735522;
    }

    @Generated
    public IiiiIIii_Class116.Nested1_8029513 I_method_cb4d4f86() {
        return this.I_field_765e3dbc;
    }
}

