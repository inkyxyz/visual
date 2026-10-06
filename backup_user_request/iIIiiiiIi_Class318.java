package rockstar.client;

import net.minecraft.item.ItemStack;
import rockstar.client.iIIiIiIii_Class300;

public class iIIiiiiIi_Class318
extends iIIiIiIii_Class300 {
    @Override
    public ItemStack I_method_7b7e0bb9() {
        if (iIIiiiiIi_Class318.I_field_3a9bda27.player == null || iIIiiiiIi_Class318.I_field_3a9bda27.player.getInventory() == null) {
            return ItemStack.EMPTY;
        }
        return (ItemStack)iIIiiiiIi_Class318.I_field_3a9bda27.player.getInventory().offHand.getFirst();
    }

    @Override
    public int I_method_dfe89252() {
        return 45;
    }
}

