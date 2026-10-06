package rockstar.client;

import lombok.Generated;
import net.minecraft.item.ItemStack;
import rockstar.client.iIIiIiIii_Class300;

public class iIIiiiiII_Class317
extends iIIiIiIii_Class300 {
    private final int I_field_49;

    public iIIiiiiII_Class317(int n) {
        if (n < 0 || n > 26) {
            throw new IllegalArgumentException("Inventory Slot ID must be between 0 and 26");
        }
        this.I_field_49 = n;
    }

    @Override
    public ItemStack I_method_7b7e0bb9() {
        if (iIIiiiiII_Class317.I_field_3a9bda27.player == null || iIIiiiiII_Class317.I_field_3a9bda27.player.getInventory() == null) {
            return ItemStack.EMPTY;
        }
        return iIIiiiiII_Class317.I_field_3a9bda27.player.getInventory().getStack(this.I_field_49 + 9);
    }

    @Override
    public int I_method_dfe89252() {
        return this.I_field_49 + 9;
    }

    @Generated
    public int II_method_a96fe515() {
        return this.I_field_49;
    }
}

