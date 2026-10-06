package rockstar.client;

import java.util.List;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import rockstar.client.IiIIIIii_Class68;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.RockstarClient;
import rockstar.client.iIIiIIii_Class148;
import rockstar.client.iIIiIiIii_Class300;
import rockstar.client.iIIiiIiII_Class309;
import rockstar.client.iIIiiIiIi_Class310;
import rockstar.client.iIiIIIii_Class164;
import rockstar.client.iiiIIII_Class113;

public class iIiIiIIi_Class170
extends iIiIIIii_Class164 {
    private static final List<Item> I_field_7865b31 = List.of(Items.MAGENTA_SHULKER_BOX, Items.PURPLE_SHULKER_BOX, Items.RED_SHULKER_BOX, Items.PINK_SHULKER_BOX, Items.BLUE_SHULKER_BOX);

    public iIiIiIIi_Class170() {
        super("modules.settings.assist.backpack", Items.SHULKER_BOX.getDefaultStack(), iIIiIIii_Class148.Ii_field_88b781);
    }

    public void II_method_d6f5b7d5() {
        iIIiiIiII_Class309<iIIiIiIii_Class300> iIIiiIiII_Class3092 = iIIiiIiIi_Class310.I_method_6a489695().I_method_fdeecb5d(iIIiiIiIi_Class310.i_method_7fde0a75()).I_method_fdeecb5d(iIIiiIiIi_Class310.Ii_method_1c02fc38());
        boolean bl = I_field_7865b31.stream().anyMatch(item -> iIIiiIiII_Class3092.I_method_77fa4424(itemStack -> itemStack != null && !itemStack.isEmpty() && itemStack.getItem() == item) != null);
        if (!bl) {
            RockstarClient.getInstance().I_method_5cb1af22().I_method_20d0f49b(iiiIIII_Class113.i_field_c11fcfcc, IiIiIIII_Class81.I_method_f25a980a("swap.item_not_found"), IiIiIIII_Class81.I_method_1410d1e5("swap.item_required", IiIiIIII_Class81.I_method_f25a980a("modules.settings.assist.backpack").toLowerCase()));
            return;
        }
        for (Item item2 : I_field_7865b31) {
            IiIIIIii_Class68.I_field_108dc26c.I_method_ee61a647(item2);
        }
    }
}

