package rockstar.client;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import rockstar.client.iIIiIIii_Class148;
import rockstar.client.iIiIIIii_Class164;
import rockstar.client.iIiIIiIi_Class166;

public class iIiIiIII_Class169
extends iIiIIIii_Class164 {
    public iIiIiIII_Class169() {
        super("modules.settings.assist.assassin_potion", Items.SPLASH_POTION.getDefaultStack(), iIIiIIii_Class148.II_field_88b781);
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
        return itemStack.getName().getString().contains("\u0417\u0435\u043b\u044c\u0435 \u0430\u0441\u0441\u0430\u0441\u0438\u043d\u0430");
    }
}

