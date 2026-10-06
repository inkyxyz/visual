package rockstar.client;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Generated;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

public final class IiiiiiIii_Class252 {
    private static final Map<Integer, Vec3d> I_field_a567c40b = new ConcurrentHashMap<Integer, Vec3d>();
    private static final Set<Integer> I_field_a56a8dc5 = ConcurrentHashMap.newKeySet();

    public static Vec3d I_method_34ed4d41(Entity entity) {
        Vec3d vec3d = I_field_a567c40b.get(entity.getId());
        return vec3d != null ? vec3d : entity.getPos();
    }

    public static void I_method_7b13a0a3(Entity entity, Vec3d vec3d) {
        I_field_a567c40b.put(entity.getId(), vec3d);
    }

    public static boolean I_method_2a260c0b(Entity entity) {
        return I_field_a56a8dc5.contains(entity.getId());
    }

    public static boolean i_method_e51d8c2b(Entity entity) {
        return I_field_a56a8dc5.add(entity.getId());
    }

    public static void I_method_8a6d4084(int n) {
        I_field_a567c40b.remove(n);
    }

    public static void I_method_f3f2fe5f() {
        I_field_a567c40b.clear();
        I_field_a56a8dc5.clear();
    }

    @Generated
    private IiiiiiIii_Class252() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

