package rockstar.client;

import java.util.List;
import net.minecraft.item.ItemStack;
import rockstar.client.Setting;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.iIIiIIii_Class148;

public interface iIiIIiII_Class165 {
    public String I_method_cca0c514();

    public ItemStack I_method_db7f702c();

    public iIIiIIii_Class148 I_method_e81fe78b();

    public int I_method_75fee8ff();

    public void I_method_49deab77(int var1);

    public void I_method_75fee90c();

    public boolean I_method_75fee910();

    default public boolean i_method_9ed094d0() {
        return false;
    }

    default public void i_method_9ed094cc() {
    }

    default public boolean II_method_398e0bf9() {
        return false;
    }

    default public String i_method_1f641154() {
        return IiIiIIII_Class81.I_method_f25a980a(this.I_method_cca0c514());
    }

    default public boolean I_method_b921bd52(ItemStack itemStack) {
        return itemStack != null && !itemStack.isEmpty() && itemStack.getItem() == this.I_method_db7f702c().getItem();
    }

    public List<Setting> getSettings();
}

