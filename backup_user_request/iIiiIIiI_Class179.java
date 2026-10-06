package rockstar.client;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import rockstar.client.iIIiIIii_Class148;
import rockstar.client.iIiIIIii_Class164;
import rockstar.client.iIiIIiIi_Class166;

public class iIiiIIiI_Class179
extends iIiIIIii_Class164 {
    public iIiiIIiI_Class179() {
        super("modules.settings.assist.holy_water", Items.SPLASH_POTION.getDefaultStack(), iIIiIIii_Class148.II_field_88b781);
    }

    @Override
    public boolean I_method_75fee910() {
        return iIiIIiIi_Class166.i_method_d56ba8b0();
    }

    @Override
    public boolean I_method_b921bd52(ItemStack itemStack) {
        if (itemStack == null || itemStack.isEmpty() || itemStack.getItem() != Items.SPLASH_POTION) {
            return false;
        }
        return itemStack.getName().getString().contains("\u0421\u0432\u044f\u0442\u0430\u044f \u0432\u043e\u0434\u0430");
    }
}

