package pyrock.classes.settings;

import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import pyrock.classes.PyEspElement;
import pyrock.classes.PyHudElement;
import pyrock.classes.PyModule;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.RegistryListSetting;
import rockstar.client.IiIiiiiI_Class95;

public class PyBlockSetting {
    private final RegistryListSetting setting;

    public PyBlockSetting(PyModule pyModule, String string) {
        this.setting = new RegistryListSetting(pyModule.getModule(), string);
        if (!(pyModule.getModule() instanceof IiIiiiiI_Class95)) {
            IIiiIIiii_Class104.I_method_9fdd7f66(pyModule.getModule(), this.setting);
        }
    }

    public PyBlockSetting(PyHudElement pyHudElement, String string) {
        this.setting = new RegistryListSetting(pyHudElement, string);
    }

    public PyBlockSetting(PyEspElement pyEspElement, String string) {
        this.setting = new RegistryListSetting(pyEspElement.getElement(), string);
    }

    public PyBlockSetting(RegistryListSetting iIiiiIiiI_Class119) {
        this.setting = iIiiiIiiI_Class119;
    }

    public PyBlockSetting select(String string) {
        IIiiIIiii_Class104.I_method_dacf28a7(this.setting);
        this.setting.I_method_568307b6(PyBlockSetting.parse(string));
        return this;
    }

    public PyBlockSetting toggle(String string) {
        Block block = PyBlockSetting.block(string);
        if (block != null) {
            IIiiIIiii_Class104.I_method_dacf28a7(this.setting);
            this.setting.I_method_bcc5858b(block);
        }
        return this;
    }

    public boolean isSelected(String string) {
        return this.setting.I_method_c9a44a24(PyBlockSetting.parse(string));
    }

    public List<String> getSelected() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (Identifier identifier : this.setting.I_method_12270fce()) {
            arrayList.add(identifier.toString());
        }
        return arrayList;
    }

    public int count() {
        return this.setting.I_method_608ed612();
    }

    public PyBlockSetting allow(String string) {
        Block block = PyBlockSetting.block(string);
        if (block != null) {
            this.setting.I_method_56228361(block);
        }
        return this;
    }

    public PyBlockSetting allowAll() {
        this.setting.I_method_3d51a98a(new Block[0]);
        return this;
    }

    public PyBlockSetting allowItem(String string) {
        Item item;
        Identifier identifier = PyBlockSetting.parse(string);
        Item item2 = item = identifier == null ? null : (Item)Registries.ITEM.get(identifier);
        if (item != null) {
            this.setting.I_method_5cb76d1d(item);
        }
        return this;
    }

    public PyBlockSetting allowAllItems() {
        this.setting.I_method_d8c582f5();
        return this;
    }

    private static Identifier parse(String string) {
        if (string == null || string.isBlank()) {
            return null;
        }
        String string2 = string.trim();
        return Identifier.tryParse((String)(string2.indexOf(58) < 0 ? "minecraft:" + string2 : string2));
    }

    private static Block block(String string) {
        Identifier identifier = PyBlockSetting.parse(string);
        return identifier == null ? null : (Block)Registries.BLOCK.get(identifier);
    }

    @Generated
    public RegistryListSetting getSetting() {
        return this.setting;
    }
}

