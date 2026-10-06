package rockstar.client;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import rockstar.client.iIIiIIii_Class148;
import rockstar.client.iIiIIIii_Class164;
import rockstar.client.iIiIIiIi_Class166;

public class iIiiIIIi_Class178
extends iIiIIIii_Class164 {
    public iIiiIIIi_Class178() {
        super("modules.settings.assist.hlopushka", Items.SPLASH_POTION.getDefaultStack(), iIIiIIii_Class148.II_field_88b781);
    }

    @Override
    public boolean I_method_75fee910() {
        return iIiIIiIi_Class166.i_method_d56ba8b0();
    }

    @Override
    public boolean I_method_b921bd52(ItemStack itemStack) {
        if (itemStack == null || itemStack.isEmpty()) {
            return false;
        }
        if (itemStack.getItem() != Items.SPLASH_POTION) {
            return false;
        }
        String string = itemStack.getName().getString();
        return string.contains("\u0425\u043b\u043e\u043f\u0443\u0448\u043a\u0430");
    }
}

