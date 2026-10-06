package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import rockstar.client.IIIiiIIi_Class26;
import rockstar.client.IIIiiIiI_Class27;
import rockstar.client.IIIiiIii_Class28;
import rockstar.client.IIiIIIIi_Class34;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.iIIIIIIii_Class260;
import rockstar.client.iIIiIIiIi_Class294;
import ua.mintantileak.spk.Compile;

public class IIiIiiii_Class48
implements iIIiIIiIi_Class294 {
    private final Map<String, Map<Integer, Integer>> I_field_a567c40b = new HashMap<String, Map<Integer, Integer>>();

    @Compile
    public IIIiiIIi_Class26 I_method_95f0ef8b() {
        return IIIiiIiI_Class27.I_method_209cd841("inv").I_method_b3f941e4("inventory", "slot", "\u0438\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044c").i_method_cfe1a061("commands.inventory.description").i_method_3d6e11d9("action", iIIiiiii_Class32 -> {
            iIIiiiii_Class32.I_method_a44fe164("save", "create", "add", "\u0441\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c", "load", "use", "\u0437\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044c");
            iIIiiiii_Class32.I_method_f005ecf3("save", "load");
        }).i_method_3d6e11d9("name", iIIiiiii_Class32 -> iIIiiiii_Class32.I_method_e930dfcb().I_method_2619a44a(string -> string.length() < 2 ? IIiIIIIi_Class34.I_method_c9d442bc("commands.prefix.invalid_length") : IIiIIIIi_Class34.I_method_12fc454a(string))).I_method_16f05c8a(this::I_method_da30276d).I_method_9111538b();
    }

    @Compile
    private void I_method_da30276d(IIIiiIii_Class28 iIIiiIii_Class28) {
        String string = (String)iIIiiIii_Class28.I_method_557e5bfb().get(0);
        String string2 = (String)iIIiiIii_Class28.I_method_557e5bfb().get(1);
        switch (string.toLowerCase(Locale.ROOT)) {
            case "save": 
            case "create": 
            case "add": 
            case "\u0441\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c": {
                this.I_method_346bdbb6(string2);
                iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_1410d1e5("commands.inventory.saved", string2)));
                break;
            }
            case "load": 
            case "use": 
            case "\u0437\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044c": {
                this.i_method_5232f96(string2);
                break;
            }
            default: {
                iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.inventory.invalid_action")));
            }
        }
    }

    @Compile
    private void I_method_346bdbb6(String string) {
        if (IIiIiiii_Class48.I_field_3a9bda27.player == null) {
            return;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i <= 45; ++i) {
            ItemStack itemStack = IIiIiiii_Class48.I_field_3a9bda27.player.currentScreenHandler.getSlot(i).getStack();
            if (itemStack.isEmpty()) continue;
            hashMap.put(i, Item.getRawId((Item)itemStack.getItem()));
        }
        this.I_field_a567c40b.put(string, hashMap);
    }

    private void i_method_5232f96(String string) {
        if (!this.I_field_a567c40b.containsKey(string)) {
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)IiIiIIII_Class81.I_method_1410d1e5("commands.inventory.not_found", string)));
            return;
        }
        Map<Integer, Integer> map = this.I_field_a567c40b.get(string);
        boolean bl = false;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int n = entry.getKey();
            Item item = Item.byRawId((int)entry.getValue());
            ItemStack itemStack = new ItemStack((ItemConvertible)item);
            itemStack.setCount(1);
            IIiIiiii_Class48.I_field_3a9bda27.player.currentScreenHandler.getSlot(n).setStack(itemStack);
            bl = true;
        }
        if (bl) {
            iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.inventory.loaded")));
        } else {
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.inventory.empty")));
        }
    }

    @Compile
    public JsonObject I_method_7f714ad6() {
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry<String, Map<Integer, Integer>> entry : this.I_field_a567c40b.entrySet()) {
            JsonObject jsonObject2 = new JsonObject();
            for (Map.Entry<Integer, Integer> entry2 : entry.getValue().entrySet()) {
                jsonObject2.addProperty(entry2.getKey().toString(), (Number)entry2.getValue());
            }
            jsonObject.add(entry.getKey(), (JsonElement)jsonObject2);
        }
        return jsonObject;
    }

    @Compile
    public void I_method_eb6d10bd(JsonElement jsonElement) {
        this.I_field_a567c40b.clear();
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        for (Map.Entry entry : jsonObject.entrySet()) {
            JsonObject jsonObject2 = ((JsonElement)entry.getValue()).getAsJsonObject();
            HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
            for (Map.Entry entry2 : jsonObject2.entrySet()) {
                Integer n = Integer.valueOf((String)entry2.getKey());
                Integer n2 = ((JsonElement)entry2.getValue()).getAsInt();
                hashMap.put(n, n2);
            }
            this.I_field_a567c40b.put((String)entry.getKey(), hashMap);
        }
    }
}

