package rockstar.client;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.iIIIIIIii_Class260;

public class IiIIiIIII_Class145 {
    private final Map<String, Vec3d> I_field_a567c40b = new HashMap<String, Vec3d>();

    public final void I_method_b71837ba(String string, int n, int n2, int n3) {
        Vec3d vec3d = new Vec3d((double)n, (double)n2, (double)n3);
        this.I_field_a567c40b.put(string, vec3d);
        iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_1410d1e5("modules.waypoints.added", string, n, n2, n3)));
    }

    public final void I_method_d7f5649(String string) {
        if (this.I_field_a567c40b.remove(string) != null) {
            iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_1410d1e5("modules.waypoints.deleted", string)));
        } else {
            iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_1410d1e5("modules.waypoints.not_found", string)));
        }
    }

    public final void I_method_5379e3f() {
        this.I_field_a567c40b.clear();
        iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("modules.waypoints.cleared")));
    }

    public final boolean I_method_d7f564d(String string) {
        return this.I_field_a567c40b.containsKey(string);
    }

    public final Set<Map.Entry<String, Vec3d>> I_method_173f1fee() {
        return this.I_field_a567c40b.entrySet();
    }

    public final void I_method_c8101766(Map<String, Vec3d> map) {
        this.I_field_a567c40b.clear();
        this.I_field_a567c40b.putAll(map);
    }
}

