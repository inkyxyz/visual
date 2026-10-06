package rockstar.client;

import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.ModuleCategory;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiIIiiI_Class295;
import rockstar.client.iIIiIiIII_Class297;

public interface ModuleEntry
extends IIiiiIIiI_Class115,
iIIiIIiIi_Class294,
iIIiIIiiI_Class295,
iIIiIiIII_Class297 {
    public void disable();

    public void enable();

    public void II_method_6642fd22();

    public boolean isEnabledByDefault();

    public String getName();

    default public String i_method_bf522194() {
        String string = "modules.descriptions.%s".formatted(this.getName().toLowerCase().replace(" ", "_"));
        return IiIiIIII_Class81.I_method_f25a980a(string);
    }

    public int getKeybind();

    public ModuleCategory getCategory();

    public boolean isEnabled();

    public boolean II_method_e249c39();

    default public boolean isAvailable() {
        return true;
    }

    public IiiiIiIii_Class236 I_method_11500ba2();

    public void setKeybind(int var1);

    public void setEnabled(boolean var1, boolean var2);
}

