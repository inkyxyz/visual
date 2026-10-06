package rockstar.client;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import rockstar.client.iiIIiIIIi_Class402;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.iiIIiIiII_Class405;
import rockstar.client.iiIIiIiIi_Class406;
import rockstar.client.iiIIiIiiI_Class407;
import rockstar.client.iiIiiIiIi_Class438;

public final class iiiIIIIIi_Class450 {
    private static final int I_field_49 = 2;
    private iiIIiIIii_Class404 I_field_32e13e6c;
    private int i_field_49;

    public boolean I_method_b97a0d1b(BlockPos blockPos, Direction direction) {
        Vec3d vec3d = Vec3d.ofCenter((Vec3i)blockPos).add((double)direction.getOffsetX() * 0.5, (double)direction.getOffsetY() * 0.5, (double)direction.getOffsetZ() * 0.5);
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = iiIIiIiIi_Class406.I_method_bc8095a1(vec3d);
        if (this.I_field_32e13e6c == null || this.I_field_32e13e6c.I_method_24e31c97(iiIIiIIii_Class4042) > 0.5f) {
            this.I_field_32e13e6c = iiIIiIIii_Class4042;
            this.i_field_49 = 0;
        }
        iiIIiIiII_Class405 iiIIiIiII_Class4052 = iiIiiIiIi_Class438.I_method_12f562b5().I_method_762df6b5();
        iiIIiIiII_Class4052.I_method_1acbf705(iiIIiIIii_Class4042, iiIIiIIIi_Class402.Ii_field_32e0c64c, 180.0f, 180.0f, 180.0f, iiIIiIiiI_Class407.i_field_32efc66c);
        if (iiIIiIiII_Class4052.Ii_method_62e6c38().I_method_24e31c97(iiIIiIIii_Class4042) <= 1.5f) {
            ++this.i_field_49;
            return this.i_field_49 >= 2;
        }
        return false;
    }

    public void I_method_e4926dff() {
        this.I_field_32e13e6c = null;
        this.i_field_49 = 0;
    }
}

