package rockstar.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.Generated;
import lombok.SneakyThrows;
import net.minecraft.client.resource.language.TranslationStorage;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BundleContentsComponent;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Language;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.IiiiiIiiI_Class247;
import rockstar.client.iIIIiiiII_Class285;
import rockstar.client.iIIiIIiIi_Class294;

public final class Iiiiiiiii_Class256
implements iIIiIIiIi_Class294 {
    private static Language I_field_65fad516;
    private static boolean I_field_5a;

    public static List<ItemStack> I_method_27e808c6(ItemStack itemStack) {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        ContainerComponent containerComponent = (ContainerComponent)itemStack.get(DataComponentTypes.CONTAINER);
        if (containerComponent == null) {
            BundleContentsComponent bundleContentsComponent = (BundleContentsComponent)itemStack.get(DataComponentTypes.BUNDLE_CONTENTS);
            if (bundleContentsComponent == null) {
                return arrayList;
            }
            for (ItemStack itemStack2 : bundleContentsComponent.iterate()) {
                arrayList.add(itemStack2);
            }
            return arrayList;
        }
        for (ItemStack itemStack3 : containerComponent.iterateNonEmpty()) {
            arrayList.add(itemStack3);
        }
        return arrayList;
    }

    public static NbtCompound I_method_a9db800a(ItemStack itemStack) {
        try {
            NbtCompound nbtCompound;
            NbtCompound nbtCompound2;
            DynamicRegistryManager dynamicRegistryManager = Iiiiiiiii_Class256.I_field_3a9bda27.world.getRegistryManager();
            NbtElement nbtElement = itemStack.toNbtAllowEmpty((RegistryWrapper.WrapperLookup)dynamicRegistryManager);
            if (itemStack.isEmpty()) {
                return null;
            }
            NbtComponent nbtComponent = (NbtComponent)itemStack.get(DataComponentTypes.CUSTOM_DATA);
            if (nbtComponent != null) {
                return nbtComponent.copyNbt();
            }
            if (nbtElement instanceof NbtCompound && (nbtCompound2 = (NbtCompound)nbtElement).contains("components", 10) && (nbtCompound = nbtCompound2.getCompound("components")).contains("minecraft:custom_data", 10)) {
                return nbtCompound.getCompound("minecraft:custom_data");
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return null;
    }

    public static boolean I_method_e0e8eeef(ItemStack itemStack, String string) {
        NbtCompound nbtCompound;
        NbtCompound nbtCompound2 = Iiiiiiiii_Class256.I_method_a9db800a(itemStack);
        if (nbtCompound2 == null) {
            return false;
        }
        if (nbtCompound2.contains("PublicBukkitValues", 10) && (nbtCompound = nbtCompound2.getCompound("PublicBukkitValues")).contains("minecraft:don-item", 8)) {
            return nbtCompound.getString("minecraft:don-item").contains(string);
        }
        if (nbtCompound2.contains("don-item")) {
            return nbtCompound2.getString("don-item").contains(string);
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @SneakyThrows(IOException.class)
    public static String I_method_7dc85d77(String string) {
        String string2;
        ResourceManager resourceManager = I_field_3a9bda27.getResourceManager();
        Identifier identifier = Identifier.of((String)"minecraft", (String)("models/item/" + string.replace("minecraft:", "") + ".json"));
        Optional optional = resourceManager.getResource(identifier);
        if (!optional.isPresent()) return null;
        BufferedReader bufferedReader = ((Resource)optional.get()).getReader();
        try {
            string2 = bufferedReader.lines().collect(Collectors.joining("\n"));
            if (bufferedReader == null) return string2;
        }
        catch (Throwable throwable) {
            try {
                if (bufferedReader == null) throw throwable;
                try {
                    bufferedReader.close();
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    throwable.addSuppressed(throwable2);
                }
                throw throwable;
            }
            catch (Exception exception) {
                System.err.println("\u041e\u0448\u0438\u0431\u043a\u0430 \u043f\u0440\u0438 \u043f\u043e\u043b\u0443\u0447\u0435\u043d\u0438\u0438 \u0441\u0435\u0440\u0432\u0435\u0440\u043d\u043e\u0439 \u043c\u043e\u0434\u0435\u043b\u0438: " + exception.getMessage());
                return null;
            }
        }
        bufferedReader.close();
        return string2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String I_method_e0e8875f(ItemStack itemStack) {
        Language language = Iiiiiiiii_Class256.I_method_1b5ae77f();
        if (language == null) {
            return Iiiiiiiii_Class256.i_method_524c3f7f(itemStack);
        }
        Language language2 = Language.getInstance();
        try {
            Language.setInstance((Language)language);
            String string = Iiiiiiiii_Class256.i_method_524c3f7f(itemStack);
            return string;
        }
        finally {
            Language.setInstance((Language)language2);
        }
    }

    private static Language I_method_1b5ae77f() {
        if (I_field_65fad516 == null && !I_field_5a) {
            try {
                I_field_65fad516 = TranslationStorage.load((ResourceManager)I_field_3a9bda27.getResourceManager(), List.of("en_us", "ru_ru"), (boolean)false);
            }
            catch (Exception exception) {
                I_field_5a = true;
            }
        }
        return I_field_65fad516;
    }

    public static String i_method_524c3f7f(ItemStack itemStack) {
        return itemStack.getName().getString().replace("[", "").replace("] ", "").replace("- ", "").replace(" -", "").replace("xxx ", "").replace(" xxx", "").replace("ggg ", "").replace(" ggg", "").replace("gg ", "").replace(" gg", "").replace("123 ", "").replace(" 123", "").replace("\u2605", "");
    }

    public static ColorRGBA I_method_81452456(Text text) {
        for (Text text2 : text.getSiblings()) {
            ColorRGBA colorRGBA = Iiiiiiiii_Class256.i_method_cff93476(text2);
            if (colorRGBA == null) continue;
            return colorRGBA.withAlpha(255.0f);
        }
        TextColor textColor = text.getStyle().getColor();
        if (textColor != null) {
            return ColorRGBA.fromInt(textColor.getRgb()).withAlpha(255.0f);
        }
        return IiiiiIIIi_Class242.i_method_5dfec6e();
    }

    private static ColorRGBA i_method_cff93476(Text text) {
        TextColor textColor = text.getStyle().getColor();
        if (textColor != null) {
            return ColorRGBA.fromInt(textColor.getRgb());
        }
        for (Text text2 : text.getSiblings()) {
            ColorRGBA colorRGBA = Iiiiiiiii_Class256.i_method_cff93476(text2);
            if (colorRGBA == null) continue;
            return colorRGBA;
        }
        return null;
    }

    public static boolean I_method_30dd7b65(ItemStack itemStack) {
        NbtCompound nbtCompound = Iiiiiiiii_Class256.I_method_a9db800a(itemStack);
        if (nbtCompound == null) {
            return false;
        }
        if (nbtCompound.contains("PublicBukkitValues", 10)) {
            NbtCompound nbtCompound2 = nbtCompound.getCompound("PublicBukkitValues");
            return nbtCompound2.contains("minecraft:don-item", 8);
        }
        if (nbtCompound.contains("sixitem", 8)) {
            return true;
        }
        return nbtCompound.contains("don-item");
    }

    public static String II_method_d1838a3c(ItemStack itemStack) {
        NbtCompound nbtCompound = Iiiiiiiii_Class256.I_method_a9db800a(itemStack);
        if (nbtCompound == null) {
            return "";
        }
        NbtCompound nbtCompound2 = nbtCompound.getCompound("sphereEffect");
        if (nbtCompound.contains("PublicBukkitValues", 10)) {
            NbtCompound nbtCompound3 = nbtCompound.getCompound("PublicBukkitValues");
            if (nbtCompound3.contains("minecraft:don-item", 8)) {
                return nbtCompound3.getString("minecraft:don-item");
            }
            if (nbtCompound3.contains("minecraft:spooky-item", 8)) {
                return nbtCompound3.getString("minecraft:spooky-item");
            }
        }
        if (nbtCompound.contains("don-item")) {
            return nbtCompound.getString("don-item");
        }
        if (nbtCompound.contains("spooky-item")) {
            return nbtCompound.getString("spooky-item");
        }
        if (iIIIiiiII_Class285.I_method_dbbac60d("holyworld") && nbtCompound.contains("sphereEffect", 10) && itemStack.getItem() == Items.TOTEM_OF_UNDYING && nbtCompound2.contains("rank")) {
            if (nbtCompound2.getString("rank").equals("ETERNITY")) {
                return nbtCompound2.getString("name");
            }
            return nbtCompound2.getString("rank");
        }
        return "";
    }

    public static IiiiiIiiI_Class247 I_method_52d419d7(ItemStack itemStack) {
        for (IiiiiIiiI_Class247 iiiiiIiiI_Class247 : IiiiiIiiI_Class247.values()) {
            for (String string : iiiiiIiiI_Class247.I_method_e210084e()) {
                if (!Iiiiiiiii_Class256.II_method_d1838a3c(itemStack).equals(string)) continue;
                return iiiiiIiiI_Class247;
            }
        }
        return null;
    }

    public static int I_method_30dd7b54(ItemStack itemStack) {
        if (itemStack.hasEnchantments()) {
            for (IiiiiIiiI_Class247 iiiiiIiiI_Class247 : IiiiiIiiI_Class247.values()) {
                for (String string : iiiiiIiiI_Class247.I_method_e210084e()) {
                    if (!Iiiiiiiii_Class256.II_method_d1838a3c(itemStack).equals(string)) continue;
                    return 12 - iiiiiIiiI_Class247.I_method_30efa632();
                }
            }
            return 0;
        }
        return -1;
    }

    public static int i_method_d4d5ff34(ItemStack itemStack) {
        if (itemStack.hasEnchantments() || Iiiiiiiii_Class256.I_method_30dd7b65(itemStack)) {
            for (IiiiiIiiI_Class247 iiiiiIiiI_Class247 : IiiiiIiiI_Class247.values()) {
                for (String string : iiiiiIiiI_Class247.I_method_e210084e()) {
                    if (!Iiiiiiiii_Class256.II_method_d1838a3c(itemStack).equals(string)) continue;
                    return 15 - iiiiiIiiI_Class247.i_method_30fe3212();
                }
            }
            return 16;
        }
        return 17;
    }

    @Generated
    private Iiiiiiiii_Class256() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
