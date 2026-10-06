package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public final class iiIiiiIII_Class441 {
    private static final int I_field_49 = 50;

    private iiIiiiIII_Class441() {
    }

    public static List<String> I_method_d63beb71(String string, String ... stringArray) {
        String string2 = string.toLowerCase();
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string3 : stringArray) {
            if (!string3.toLowerCase().startsWith(string2)) continue;
            arrayList.add(string3);
        }
        for (Identifier identifier : Registries.BLOCK.getIds()) {
            String string4 = identifier.getNamespace().equals("minecraft") ? identifier.getPath() : identifier.toString();
            if (!string4.startsWith(string2)) continue;
            arrayList.add(string4);
            if (arrayList.size() < 50) continue;
            break;
        }
        return arrayList;
    }

    @Nullable
    public static Block I_method_b7c8d0a3(String string) {
        Block block;
        Identifier identifier;
        Identifier identifier2 = identifier = string.contains(":") ? Identifier.tryParse((String)string) : Identifier.tryParse((String)("minecraft:" + string));
        if (identifier == null) {
            return null;
        }
        Block block2 = (Block)Registries.BLOCK.get(identifier);
        if (block2 == (block = (Block)Registries.BLOCK.get(Identifier.of((String)"minecraft", (String)"air"))) && !identifier.toString().equals("minecraft:air")) {
            return null;
        }
        return block2;
    }
}

