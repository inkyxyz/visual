package rockstar.client;

import java.util.function.Predicate;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import rockstar.client.IiIIIIii_Class68;
import rockstar.client.iIIiiiIi_Class158;

public class iIiIIIiI_Class163
implements iIIiiiIi_Class158 {
    private final Item I_field_3c05b08c;
    private final Predicate<ItemStack> I_field_93e25d0f;
    private boolean I_field_5a = false;

    public iIiIIIiI_Class163(Item item, Predicate<ItemStack> predicate) {
        this.I_field_3c05b08c = item;
        this.I_field_93e25d0f = predicate;
    }

    public iIiIIIiI_Class163(Item item) {
        this(item, null);
    }

    @Override
    public void I_method_4a82c8ac() {
        if (this.I_field_93e25d0f != null) {
            IiIIIIii_Class68.I_field_108dc26c.I_method_5bdc8a16(this.I_field_3c05b08c, this.I_field_93e25d0f);
        } else {
            IiIIIIii_Class68.I_field_108dc26c.I_method_ee61a647(this.I_field_3c05b08c);
        }
        this.I_field_5a = true;
    }

    @Override
    public boolean I_method_4a82c8b0() {
        return this.I_field_5a;
    }

    @Override
    public void i_method_4a91548c() {
        this.I_field_5a = false;
    }
}

