package pyrock.classes;

import java.util.Locale;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.RockstarClient;
import rockstar.client.iiIiIIIII_Class417;
import rockstar.client.iiIiiii_Class112;
import rockstar.client.iiiIIII_Class113;
import rockstar.client.iiiIiIi_Class118;

public class PyNotify {
    public void island(String string, String string2) {
        PyNotify.manager().I_method_8ee48d11(PyNotify.type(string2), string == null ? "" : string);
    }

    public void crosshair(String string, String string2, String string3) {
        PyNotify.manager().I_method_20d0f49b(PyNotify.type(string3), string == null ? "" : string, string2 == null ? "" : string2);
    }

    public void item(String string, String string2, String string3, @Nullable ColorRGBA colorRGBA) {
        Item item = PyNotify.item(string2);
        iiiIiIi_Class118 iiiIiIi_Class1182 = new iiiIiIi_Class118(string == null ? "" : string, item);
        if (string3 != null && !string3.isEmpty()) {
            iiiIiIi_Class1182.I_method_7ab92a7f(string3);
            if (colorRGBA != null) {
                iiiIiIi_Class1182.I_method_c9efc756(colorRGBA);
            }
        }
        PyNotify.manager().I_method_67864747(iiiIiIi_Class1182);
    }

    public void sound() {
        try {
            iiIiIIIII_Class417.Ii_field_34b2ba6c.I_method_87d2e181(1.0f);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public int count() {
        return PyNotify.manager().I_method_57b4ffc8().size();
    }

    private static iiiIIII_Class113 type(String string) {
        if (string == null) {
            return iiiIIII_Class113.II_field_c11fcfcc;
        }
        return switch (string.toLowerCase(Locale.ROOT)) {
            case "success", "ok", "good" -> iiiIIII_Class113.I_field_c11fcfcc;
            case "error", "fail", "bad" -> iiiIIII_Class113.i_field_c11fcfcc;
            default -> iiiIIII_Class113.II_field_c11fcfcc;
        };
    }

    private static Item item(String string) {
        Identifier identifier;
        if (string == null || string.isBlank()) {
            return Items.PAPER;
        }
        Identifier identifier2 = identifier = string.contains(":") ? Identifier.tryParse((String)string) : Identifier.tryParse((String)("minecraft:" + string));
        if (identifier == null) {
            return Items.PAPER;
        }
        Item item = (Item)Registries.ITEM.get(identifier);
        return item == Items.AIR ? Items.PAPER : item;
    }

    private static iiIiiii_Class112 manager() {
        return RockstarClient.getInstance().I_method_5cb1af22();
    }
}

