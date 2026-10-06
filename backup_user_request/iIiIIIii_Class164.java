package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import net.minecraft.item.ItemStack;
import rockstar.client.Setting;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.iIIiIIii_Class148;
import rockstar.client.iIiIIiII_Class165;

public abstract class iIiIIIii_Class164
implements IIiiiIIiI_Class115,
iIiIIiII_Class165 {
    private final String I_field_523beb0a;
    private final ItemStack I_field_f2735522;
    private final iIIiIIii_Class148 I_field_88b781;
    private int I_field_49 = -1;
    private final List<Setting> I_field_7865b31 = new ArrayList<Setting>();

    protected iIiIIIii_Class164(String string, ItemStack itemStack, iIIiIIii_Class148 iIIiIIii_Class1482) {
        this.I_field_523beb0a = string;
        this.I_field_f2735522 = itemStack;
        this.I_field_88b781 = iIIiIIii_Class1482;
    }

    @Override
    public void I_method_75fee90c() {
    }

    @Override
    public boolean I_method_75fee910() {
        return true;
    }

    @Override
    @Generated
    public String I_method_cca0c514() {
        return this.I_field_523beb0a;
    }

    @Override
    @Generated
    public ItemStack I_method_db7f702c() {
        return this.I_field_f2735522;
    }

    @Override
    @Generated
    public iIIiIIii_Class148 I_method_e81fe78b() {
        return this.I_field_88b781;
    }

    @Override
    @Generated
    public int I_method_75fee8ff() {
        return this.I_field_49;
    }

    @Override
    @Generated
    public void I_method_49deab77(int n) {
        this.I_field_49 = n;
    }

    @Override
    @Generated
    public List<Setting> getSettings() {
        return this.I_field_7865b31;
    }
}

