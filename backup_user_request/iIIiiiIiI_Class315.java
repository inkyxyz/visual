package rockstar.client;

import lombok.Generated;
import net.minecraft.item.ItemStack;
import rockstar.client.iIIiIiIii_Class300;

public class iIIiiiIiI_Class315
extends iIIiIiIii_Class300 {
    private final int I_field_49;

    public iIIiiiIiI_Class315(int n) {
        if (n < 0 || n > 3) {
            throw new IllegalArgumentException("Armor Slot Index must be between 0 and 3");
        }
        this.I_field_49 = n;
    }

    @Override
    public ItemStack I_method_7b7e0bb9() {
        if (iIIiiiIiI_Class315.I_field_3a9bda27.player == null || iIIiiiIiI_Class315.I_field_3a9bda27.player.getInventory() == null) {
            return ItemStack.EMPTY;
        }
        return iIIiiiIiI_Class315.I_field_3a9bda27.player.getInventory().getArmorStack(this.I_field_49);
    }

    @Override
    public int I_method_dfe89252() {
        return 8 - this.I_field_49;
    }

    @Generated
    public int II_method_1d07a0d5() {
        return this.I_field_49;
    }
}

