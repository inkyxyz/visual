package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.math.Vec3d;
import rockstar.client.IIIIiIII_Class9;
import rockstar.client.iiiiiii_Class128;

public class IIIiIIII_Class17
implements IIIIiIII_Class9 {
    private final List<Vec3d> I_field_7865b31 = new ArrayList<Vec3d>();
    private int I_field_49;

    public void I_method_aed3ef5e(Vec3d vec3d) {
        if (vec3d != null) {
            this.I_field_7865b31.add(vec3d);
        }
    }

    public void I_method_bed368ac() {
        this.I_field_7865b31.clear();
        this.I_field_49 = 0;
    }

    public boolean I_method_bed368b0() {
        return this.I_field_7865b31.isEmpty();
    }

    @Override
    public void I_method_f2de637a(iiiiiii_Class128 iiiiiii_Class1282) {
        if (iiiiiii_Class1282 == null || this.I_field_7865b31.isEmpty()) {
            return;
        }
        Vec3d vec3d = this.I_field_7865b31.get(this.I_field_49);
        if (iiiiiii_Class1282.I_method_5c7cd919(vec3d) <= iiiiiii_Class1282.I_method_e08ecf78().IiI_method_e9bc99fa()) {
            this.I_field_49 = (this.I_field_49 + 1) % this.I_field_7865b31.size();
            vec3d = this.I_field_7865b31.get(this.I_field_49);
        }
        iiiiiii_Class1282.I_method_331eac73(vec3d, iiiiiii_Class1282.I_method_e08ecf78().IiI_method_e9bc99fa());
    }

    @Override
    public String I_method_dcc0dd54() {
        return "Patrol " + this.I_field_7865b31.size();
    }
}

