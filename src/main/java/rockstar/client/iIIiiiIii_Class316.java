package rockstar.client;

import lombok.Generated;
import net.minecraft.item.ItemStack;
import rockstar.client.iIIiIiIii_Class300;

public class iIIiiiIii_Class316
extends iIIiIiIii_Class300 {
    private final int I_field_49;

    public iIIiiiIii_Class316(int n) {
        if (n < 0 || n > 8) {
            throw new IllegalArgumentException("Hotbar Slot ID must be between 0 and 8");
        }
        this.I_field_49 = n;
    }

    @Override
    public ItemStack I_method_7b7e0bb9() {
        if (iIIiiiIii_Class316.I_field_3a9bda27.player == null || iIIiiiIii_Class316.I_field_3a9bda27.player.getInventory() == null) {
            return ItemStack.EMPTY;
        }
        return iIIiiiIii_Class316.I_field_3a9bda27.player.getInventory().getStack(this.I_field_49);
    }

    @Override
    public int I_method_dfe89252() {
        return 36 + this.I_field_49;
    }

    @Generated
    public int II_method_b9cf08f5() {
        return this.I_field_49;
    }
}

