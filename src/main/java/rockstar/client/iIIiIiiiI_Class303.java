package rockstar.client;

import java.util.Comparator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.jetbrains.annotations.Nullable;
import rockstar.client.IiiiiiIII_Class249;
import rockstar.client.iIIiIiIii_Class300;
import rockstar.client.iIIiiIIIi_Class306;
import rockstar.client.iIIiiIiII_Class309;
import rockstar.client.iIIiiIiIi_Class310;

public class iIIiIiiiI_Class303
implements iIIiiIIIi_Class306 {
    private static final iIIiiIiII_Class309<iIIiIiIii_Class300> I_field_4728d64c = iIIiiIiIi_Class310.Ii_method_1c02fc38().I_method_fdeecb5d(iIIiiIiIi_Class310.i_method_7fde0a75()).I_method_fdeecb5d(iIIiiIiIi_Class310.I_method_6a489695());
    private static final iIIiiIiII_Class309<iIIiIiIii_Class300> i_field_4728d64c = iIIiiIiIi_Class310.i_method_7fde0a75().I_method_fdeecb5d(iIIiiIiIi_Class310.I_method_6a489695()).I_method_fdeecb5d(iIIiiIiIi_Class310.Ii_method_1c02fc38());
    private static final iIIiiIiII_Class309<iIIiIiIii_Class300> II_field_4728d64c = iIIiiIiIi_Class310.i_method_7fde0a75().I_method_fdeecb5d(iIIiiIiIi_Class310.I_method_6a489695());
    private static final Comparator<iIIiIiIii_Class300> I_field_c8f916f9 = Comparator.comparingInt(iIIiIiIii_Class3002 -> IiiiiiIII_Class249.I_method_9a86b74(iIIiIiIii_Class3002.I_method_7b7e0bb9()));

    @Override
    @Nullable
    public iIIiIiIii_Class300 I_method_6c9d1d1d(Item item) {
        if (item == Items.TOTEM_OF_UNDYING) {
            return II_field_4728d64c.I_method_fe8cb900(item).stream().max(I_field_c8f916f9).orElse(null);
        }
        return I_field_4728d64c.I_method_fe8cb900(item).stream().findFirst().orElse(null);
    }

    @Override
    @Nullable
    public iIIiIiIii_Class300 i_method_9727c53d(Item item) {
        if (item == Items.TOTEM_OF_UNDYING) {
            return II_field_4728d64c.I_method_fe8cb900(item).stream().min(I_field_c8f916f9).orElse(null);
        }
        return II_field_4728d64c.I_method_fe8cb900(item).stream().findFirst().orElse(null);
    }

    @Override
    @Nullable
    public iIIiIiIii_Class300 I_method_b8c3b617(ItemStack itemStack) {
        return i_field_4728d64c.I_method_617d3e68().stream().filter(iIIiIiIii_Class3002 -> ItemStack.areEqual((ItemStack)iIIiIiIii_Class3002.I_method_7b7e0bb9(), (ItemStack)itemStack)).findFirst().orElse(null);
    }

    @Override
    @Nullable
    public iIIiIiIii_Class300 I_method_a7f495a(int n) {
        return I_field_4728d64c.I_method_617d3e68().stream().filter(iIIiIiIii_Class3002 -> iIIiIiIii_Class3002.I_method_dfe89252() == n).findFirst().orElse(null);
    }

    @Override
    public int I_method_986225fa(Item item) {
        return iIIiiIiIi_Class310.i_method_7fde0a75().I_method_fdeecb5d(iIIiiIiIi_Class310.I_method_6a489695()).I_method_fdeecb5d(iIIiiIiIi_Class310.Ii_method_1c02fc38()).I_method_fe8cb900(item).size();
    }
}

