package rockstar.client;

import lombok.Generated;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import org.joml.Vector3f;

public class iiIIIiIIi_Class394
extends Vec3d {
    private final Vec3d I_field_5bba0d50;

    public iiIIIiIIi_Class394(double d, double d2, double d3, Vec3d vec3d) {
        super(d, d2, d3);
        this.I_field_5bba0d50 = vec3d;
    }

    public iiIIIiIIi_Class394(Vector3f vector3f, Vec3d vec3d) {
        super(vector3f);
        this.I_field_5bba0d50 = vec3d;
    }

    public iiIIIiIIi_Class394(Vec3i vec3i, Vec3d vec3d) {
        super(vec3i);
        this.I_field_5bba0d50 = vec3d;
    }

    @Generated
    public Vec3d I_method_93343179() {
        return this.I_field_5bba0d50;
    }
}

