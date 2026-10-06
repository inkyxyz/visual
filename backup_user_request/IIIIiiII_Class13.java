package rockstar.client;

import lombok.Generated;
import net.minecraft.util.math.Vec3d;
import rockstar.client.IIIIiIII_Class9;
import rockstar.client.IIIIiiIi_Class14;
import rockstar.client.iiiiiii_Class128;

public class IIIIiiII_Class13
implements IIIIiIII_Class9 {
    private final Vec3d I_field_5bba0d50;
    private final double I_field_44;

    public IIIIiiII_Class13(Vec3d vec3d, double d) {
        this.I_field_5bba0d50 = vec3d;
        this.I_field_44 = d;
    }

    public IIIIiiII_Class13(double d, double d2, double d3) {
        this(new Vec3d(d + 0.5, d2, d3 + 0.5), 0.35);
    }

    @Override
    public void I_method_f2de637a(iiiiiii_Class128 iiiiiii_Class1282) {
        if (iiiiiii_Class1282 == null || this.I_field_5bba0d50 == null) {
            return;
        }
        if (iiiiiii_Class1282.I_method_5c7cd919(this.I_field_5bba0d50) <= this.I_field_44) {
            iiiiiii_Class1282.I_method_b8ab1d60(new IIIIiiIi_Class14());
            return;
        }
        iiiiiii_Class1282.I_method_331eac73(this.I_field_5bba0d50, this.I_field_44);
    }

    @Override
    public String I_method_dcc0dd54() {
        return "Goto " + Math.round(this.I_field_5bba0d50.x) + " " + Math.round(this.I_field_5bba0d50.y) + " " + Math.round(this.I_field_5bba0d50.z);
    }

    @Generated
    public Vec3d I_method_a58f1b46() {
        return this.I_field_5bba0d50;
    }

    @Generated
    public double I_method_ba58c0ba() {
        return this.I_field_44;
    }
}

