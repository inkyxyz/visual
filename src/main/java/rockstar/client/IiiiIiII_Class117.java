package rockstar.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import rockstar.client.IiiiIIii_Class116;
import rockstar.client.IiiiiIiii_Class248;
import rockstar.client.Iiiiiiiii_Class256;
import rockstar.client.iIIIIIIii_Class260;

public final class IiiiIiII_Class117 {
    private static final String I_field_523beb0a = "PublicBukkitValues";
    private static final String i_field_523beb0a = "minecraft:don-item";
    private static final String II_field_523beb0a = "minecraft:ftid";
    private static final long I_field_4a = 60000L;
    private static final Map<String, Long> I_field_a567c40b = new HashMap<String, Long>();
    private static Map<String, String> i_field_a567c40b;
    private static Map<String, String> II_field_a567c40b;

    private IiiiIiII_Class117() {
    }

    public static String I_method_775e0972(ItemStack itemStack) {
        if (itemStack == null || itemStack.isEmpty()) {
            return null;
        }
        NbtComponent nbtComponent = (NbtComponent)itemStack.get(DataComponentTypes.CUSTOM_DATA);
        if (nbtComponent == null) {
            return null;
        }
        NbtCompound nbtCompound = nbtComponent.copyNbt();
        if (nbtCompound.contains(I_field_523beb0a, 10)) {
            NbtCompound nbtCompound2 = nbtCompound.getCompound(I_field_523beb0a);
            if (nbtCompound2.contains(i_field_523beb0a, 8)) {
                return nbtCompound2.getString(i_field_523beb0a);
            }
            if (nbtCompound2.contains(II_field_523beb0a, 8)) {
                return nbtCompound2.getString(II_field_523beb0a);
            }
        }
        if (nbtCompound.contains(i_field_523beb0a, 8)) {
            return nbtCompound.getString(i_field_523beb0a);
        }
        if (nbtCompound.contains("don-item", 8)) {
            return nbtCompound.getString("don-item");
        }
        return null;
    }

    public static boolean I_method_e158a4f2(ItemStack itemStack) {
        return IiiiIiII_Class117.I_method_775e0972(itemStack) != null;
    }

    public static boolean I_method_bab8569e(ItemStack itemStack, String string, ItemStack itemStack2) {
        String string2;
        String string3 = string2 = string != null && !string.isBlank() ? string : IiiiIiII_Class117.i_method_e8c1c192(itemStack);
        if (string2 == null) {
            return false;
        }
        String string4 = IiiiIiII_Class117.I_method_c97a240a(IiiiIiII_Class117.I_method_775e0972(itemStack));
        String string5 = IiiiIiII_Class117.I_method_c97a240a(IiiiIiII_Class117.I_method_775e0972(itemStack2));
        if (string4 != null && string4.equals(string5)) {
            return true;
        }
        String string6 = IiiiIiII_Class117.i_method_e8c1c192(itemStack2);
        if (string6 != null) {
            return string6.equalsIgnoreCase(string2);
        }
        if (IiiiIiII_Class117.I_method_5bc635c1().containsKey(string2)) {
            return false;
        }
        return Iiiiiiiii_Class256.i_method_524c3f7f(itemStack2).equalsIgnoreCase(string2);
    }

    public static String i_method_e8c1c192(ItemStack itemStack) {
        String string;
        for (String object2 : IiiiIiII_Class117.I_method_abecf399(itemStack)) {
            String string2 = object2.toLowerCase(Locale.ROOT);
            for (Map.Entry<String, String> entry : IiiiIiII_Class117.I_method_5bc635c1().entrySet()) {
                if (!string2.contains(entry.getValue().toLowerCase(Locale.ROOT))) continue;
                return entry.getKey();
            }
        }
        String string3 = IiiiIiII_Class117.I_method_c97a240a(IiiiIiII_Class117.I_method_775e0972(itemStack));
        if (string3 != null && (string = IiiiIiII_Class117.i_method_ee0279a1().get(string3)) != null) {
            return string;
        }
        IiiiiIiii_Class248.Nested1_95187080 nested1_95187080 = IiiiiIiii_Class248.I_method_7613ca72(itemStack);
        if (nested1_95187080 != null && nested1_95187080.I_method_f2690c42() == IiiiiIiii_Class248.Nested1_df59be9.II_field_e400d4a6) {
            return nested1_95187080.I_method_3665aca6();
        }
        return null;
    }

    public static void I_method_729ec638(String string, ItemStack itemStack) {
        if (string == null || string.isBlank()) {
            return;
        }
        String string2 = Iiiiiiiii_Class256.i_method_524c3f7f(itemStack);
        if (!string2.toLowerCase(Locale.ROOT).contains(string.toLowerCase(Locale.ROOT))) {
            return;
        }
        long l = System.currentTimeMillis();
        Long l2 = I_field_a567c40b.get(string);
        if (l2 != null && l - l2 < 60000L) {
            return;
        }
        I_field_a567c40b.put(string, l);
        String string3 = IiiiIiII_Class117.i_method_e8c1c192(itemStack);
        Object object = string3 != null ? "\u044d\u0442\u043e " + string3 : "\u043d\u0435\u0442 \u0441\u0435\u0440\u0432\u0435\u0440\u043d\u043e\u0433\u043e \u043e\u043f\u0438\u0441\u0430\u043d\u0438\u044f";
        iIIIIIIii_Class260.i_method_70898627(Text.of((String)(string + ": \u043b\u043e\u0442 \u00ab" + string2 + "\u00bb \u043d\u0435 \u0442\u043e\u0442 \u043f\u0440\u0435\u0434\u043c\u0435\u0442 (" + (String)object + ") \u2014 \u043f\u0440\u043e\u043f\u0443\u0441\u043a\u0430\u044e")));
    }

    private static String I_method_c97a240a(String string) {
        return string == null || string.isBlank() ? null : IiiiiIiii_Class248.I_method_203b3197(string);
    }

    private static List<String> I_method_abecf399(ItemStack itemStack) {
        if (itemStack == null || itemStack.isEmpty()) {
            return List.of();
        }
        LoreComponent loreComponent = (LoreComponent)itemStack.get(DataComponentTypes.LORE);
        if (loreComponent == null) {
            return List.of();
        }
        ArrayList<String> arrayList = new ArrayList<String>(loreComponent.lines().size());
        for (Text text : loreComponent.lines()) {
            arrayList.add(text.getString());
        }
        return arrayList;
    }

    private static Map<String, String> I_method_5bc635c1() {
        if (i_field_a567c40b == null) {
            i_field_a567c40b = IiiiIIii_Class116.I_method_e2088b3d(IiiiIIii_Class116.Nested1_80294f3.i_field_765e39dc);
        }
        return i_field_a567c40b;
    }

    private static Map<String, String> i_method_ee0279a1() {
        if (II_field_a567c40b != null) {
            return II_field_a567c40b;
        }
        HashMap<String, String> hashMap = new HashMap<String, String>();
        for (IiiiIIii_Class116.Nested1_f85009b6 nested1_f85009b6 : IiiiIIii_Class116.I_method_5efe7a3f(IiiiIIii_Class116.Nested1_80294f3.i_field_765e39dc)) {
            for (IiiiIIii_Class116.Nested1_8029513 nested1_8029513 : nested1_f85009b6.I_method_f3e0b603()) {
                String string = IiiiIiII_Class117.I_method_c97a240a(IiiiIiII_Class117.I_method_775e0972(nested1_8029513.I_method_c2b2cc91()));
                if (string == null || nested1_8029513.I_method_d1d7d0f9() == null) continue;
                hashMap.put(string, nested1_8029513.I_method_d1d7d0f9());
            }
        }
        II_field_a567c40b = hashMap;
        return II_field_a567c40b;
    }
}

