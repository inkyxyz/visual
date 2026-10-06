package rockstar.client;

import lombok.NonNull;
import net.minecraft.util.math.Vec3d;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;

public class IiiiiIIII_Class241 {
    private static final IiiiIiiII_Class237 I_field_dd60aac = IiiiIiiII_Class237.IIIi_field_dd60aac;
    private final long I_field_4a;
    private final IiiiIiIii_Class236 I_field_dc7facc;
    private final IiiiIiIii_Class236 i_field_dc7facc;
    private final IiiiIiIii_Class236 II_field_dc7facc;

    public IiiiiIIII_Class241(long l, IiiiIiiII_Class237 iiiiIiiII_Class237) {
        this.I_field_4a = l;
        this.I_field_dc7facc = new IiiiIiIii_Class236(l, iiiiIiiII_Class237);
        this.i_field_dc7facc = new IiiiIiIii_Class236(l, iiiiIiiII_Class237);
        this.II_field_dc7facc = new IiiiIiIii_Class236(l, iiiiIiiII_Class237);
    }

    public IiiiiIIII_Class241(long l) {
        this(l, I_field_dd60aac);
    }

    public IiiiiIIII_Class241(long l, Vec3d vec3d, IiiiIiiII_Class237 iiiiIiiII_Class237) {
        this.I_field_4a = l;
        this.I_field_dc7facc = new IiiiIiIii_Class236(l, (float)vec3d.getX(), iiiiIiiII_Class237);
        this.i_field_dc7facc = new IiiiIiIii_Class236(l, (float)vec3d.getY(), iiiiIiiII_Class237);
        this.II_field_dc7facc = new IiiiIiIii_Class236(l, (float)vec3d.getZ(), iiiiIiiII_Class237);
    }

    public IiiiiIIII_Class241(long l, Vec3d vec3d) {
        this(l, vec3d, I_field_dd60aac);
    }

    public void I_method_61b2436b(@NonNull Vec3d vec3d) {
        if (vec3d == null) {
            throw new NullPointerException("vec is marked non-null but is null");
        }
        this.I_field_dc7facc.I_method_edd6dd11((float)vec3d.getX());
        this.i_field_dc7facc.I_method_edd6dd11((float)vec3d.getY());
        this.II_field_dc7facc.I_method_edd6dd11((float)vec3d.getZ());
    }

    public Vec3d I_method_f20b3179() {
        return new Vec3d((double)this.I_field_dc7facc.I_method_6ac4da6f(), (double)this.i_field_dc7facc.I_method_6ac4da6f(), (double)this.II_field_dc7facc.I_method_6ac4da6f());
    }

    public void I_method_6d52f0c7(IiiiIiiII_Class237 iiiiIiiII_Class237) {
        this.I_field_dc7facc.I_method_df2f9087(iiiiIiiII_Class237);
        this.i_field_dc7facc.I_method_df2f9087(iiiiIiiII_Class237);
        this.II_field_dc7facc.I_method_df2f9087(iiiiIiiII_Class237);
    }

    public void I_method_68521c65(long l) {
        this.I_field_dc7facc.I_method_edd6ec25(l);
        this.i_field_dc7facc.I_method_edd6ec25(l);
        this.II_field_dc7facc.I_method_edd6ec25(l);
    }

    public void i_method_3cca3b8b(@NonNull Vec3d vec3d) {
        if (vec3d == null) {
            throw new NullPointerException("vec is marked non-null but is null");
        }
        this.I_field_dc7facc.I_method_edd6dd21((float)vec3d.getX());
        this.i_field_dc7facc.I_method_edd6dd21((float)vec3d.getY());
        this.II_field_dc7facc.I_method_edd6dd21((float)vec3d.getZ());
    }
}

