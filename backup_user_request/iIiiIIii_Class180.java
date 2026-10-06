package rockstar.client;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import rockstar.client.iIIiIIii_Class148;
import rockstar.client.iIiIIIii_Class164;

public abstract class iIiiIIii_Class180
extends iIiIIIii_Class164 {
    private final Item I_field_3c05b08c;
    private final String[] I_field_6dccaaa5;

    protected iIiiIIii_Class180(String string, Item item, iIIiIIii_Class148 iIIiIIii_Class1482, String ... stringArray) {
        super(string, item.getDefaultStack(), iIIiIIii_Class1482);
        this.I_field_3c05b08c = item;
        this.I_field_6dccaaa5 = stringArray;
    }

    @Override
    public boolean I_method_b921bd52(ItemStack itemStack) {
        if (itemStack == null || itemStack.isEmpty() || itemStack.getItem() != this.I_field_3c05b08c) {
            return false;
        }
        String string = this.I_method_2c07c3aa(itemStack.getName().getString());
        for (String string2 : this.I_field_6dccaaa5) {
            if (string.contains(this.I_method_2c07c3aa(string2))) continue;
            return false;
        }
        return true;
    }

    protected Item I_method_7c1bdb22() {
        return this.I_field_3c05b08c;
    }

    private String I_method_2c07c3aa(String string) {
        return string == null ? "" : string.toLowerCase().replace('\u0451', '\u0435');
    }
}

