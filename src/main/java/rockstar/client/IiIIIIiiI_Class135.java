package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.client.util.SkinTextures;
import net.minecraft.util.Identifier;

public final class IiIIIIiiI_Class135 {
    public static final String I_field_523beb0a = "*";
    private static final Map<String, Nested1_739d1420> I_field_a567c40b = new ConcurrentHashMap<String, Nested1_739d1420>();

    private IiIIIIiiI_Class135() {
    }

    public static Nested1_739d1420 I_method_13950f16(Object object, String string2) {
        return I_field_a567c40b.compute(IiIIIIiiI_Class135.I_method_59e70557(string2), (string, nested1_739d1420) -> nested1_739d1420 != null && nested1_739d1420.I_field_5f790d9c == object ? nested1_739d1420 : new Nested1_739d1420(object));
    }

    public static Nested1_739d1420 I_method_ae6ca9fa(String string) {
        if (I_field_a567c40b.isEmpty() || string == null || string.isEmpty()) {
            return null;
        }
        Nested1_739d1420 nested1_739d1420 = I_field_a567c40b.get(IiIIIIiiI_Class135.I_method_59e70557(string));
        return nested1_739d1420 != null ? nested1_739d1420 : I_field_a567c40b.get(I_field_523beb0a);
    }

    public static void I_method_b4926e69(String string2) {
        I_field_a567c40b.computeIfPresent(IiIIIIiiI_Class135.I_method_59e70557(string2), (string, nested1_739d1420) -> nested1_739d1420.i_method_a0c30f7e() ? null : nested1_739d1420);
    }

    public static void i_method_8549c249(String string) {
        I_field_a567c40b.remove(IiIIIIiiI_Class135.I_method_59e70557(string));
    }

    public static void I_method_6711347b(Object object) {
        I_field_a567c40b.values().removeIf(nested1_739d1420 -> nested1_739d1420.I_field_5f790d9c == object);
    }

    public static void I_method_14f67e5f() {
        I_field_a567c40b.clear();
    }

    public static boolean I_method_14f67e63() {
        return I_field_a567c40b.isEmpty();
    }

    public static List<String> I_method_6124ea08() {
        return new ArrayList<String>(I_field_a567c40b.keySet());
    }

    public static SkinTextures I_method_9cfd572d(String string, SkinTextures skinTextures) {
        if (skinTextures == null) {
            return null;
        }
        Nested1_739d1420 nested1_739d1420 = IiIIIIiiI_Class135.I_method_ae6ca9fa(string);
        if (nested1_739d1420 == null || nested1_739d1420.i_method_a0c30f7e()) {
            return skinTextures;
        }
        return new SkinTextures(nested1_739d1420.I_field_6a3d6525 != null ? nested1_739d1420.I_field_6a3d6525 : skinTextures.texture(), skinTextures.textureUrl(), nested1_739d1420.I_field_5a ? null : (nested1_739d1420.i_field_6a3d6525 != null ? nested1_739d1420.i_field_6a3d6525 : skinTextures.capeTexture()), nested1_739d1420.II_field_6a3d6525 != null ? nested1_739d1420.II_field_6a3d6525 : skinTextures.elytraTexture(), nested1_739d1420.I_field_4efc3f78 != null ? nested1_739d1420.I_field_4efc3f78 : skinTextures.model(), skinTextures.secure());
    }

    public static boolean I_method_b4926e6d(String string) {
        Nested1_739d1420 nested1_739d1420 = IiIIIIiiI_Class135.I_method_ae6ca9fa(string);
        return nested1_739d1420 != null && nested1_739d1420.i_field_6a3d6525 != null;
    }

    private static String I_method_59e70557(String string) {
        if (string == null) {
            return I_field_523beb0a;
        }
        String string2 = string.trim();
        return string2.isEmpty() ? I_field_523beb0a : string2.toLowerCase(Locale.ROOT);
    }

    public static final class Nested1_739d1420 {
        final Object I_field_5f790d9c;
        volatile Identifier I_field_6a3d6525;
        volatile SkinTextures.Model I_field_4efc3f78;
        volatile Identifier i_field_6a3d6525;
        volatile Identifier II_field_6a3d6525;
        volatile boolean I_field_5a;

        Nested1_739d1420(Object object) {
            this.I_field_5f790d9c = object;
        }

        public void I_method_cf37ad45(Identifier identifier) {
            this.I_field_6a3d6525 = identifier;
        }

        public void I_method_7b2fc652(SkinTextures.Model model) {
            this.I_field_4efc3f78 = model;
        }

        public void i_method_aa4fa565(Identifier identifier) {
            this.i_field_6a3d6525 = identifier;
            if (identifier != null) {
                this.I_field_5a = false;
            }
        }

        public void II_method_78801c38(Identifier identifier) {
            this.II_field_6a3d6525 = identifier;
        }

        public void I_method_75dca27a(boolean bl) {
            this.I_field_5a = bl;
            if (bl) {
                this.i_field_6a3d6525 = null;
            }
        }

        public Identifier I_method_843fd969() {
            return this.I_field_6a3d6525;
        }

        public Identifier i_method_28385d49() {
            return this.i_field_6a3d6525;
        }

        public Identifier II_method_c3844016() {
            return this.II_field_6a3d6525;
        }

        public SkinTextures.Model I_method_b4023ab4() {
            return this.I_field_4efc3f78;
        }

        public boolean I_method_a0b4839e() {
            return this.I_field_5a;
        }

        public boolean i_method_a0c30f7e() {
            return this.I_field_6a3d6525 == null && this.I_field_4efc3f78 == null && this.i_field_6a3d6525 == null && this.II_field_6a3d6525 == null && !this.I_field_5a;
        }
    }
}

