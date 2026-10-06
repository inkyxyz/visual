package rockstar.client;

import lombok.Generated;
import net.minecraft.util.math.Vec3d;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiiiiiI_Class319;
import ua.mintantileak.spk.Compile;

public class iiIIiIIii_Class404
implements iIIiIIiIi_Class294 {
    public static final iiIIiIIii_Class404 I_field_32e13e6c = new iiIIiIIii_Class404(0.0f, 0.0f);
    private float I_field_46;
    private float i_field_46;

    public iiIIiIIii_Class404(double d, double d2) {
        this.I_field_46 = (float)d;
        this.i_field_46 = (float)d2;
    }

    @Compile(obfuscation=1)
    public final iiIIiIIii_Class404 I_method_327fa77d(iiIIiIIii_Class404 iiIIiIIii_Class4042) {
        float f = iIIiiiiiI_Class319.iII_method_6550feaf(this.I_field_46, iiIIiIIii_Class4042.I_field_46);
        float f2 = iIIiiiiiI_Class319.iII_method_6550feaf(this.i_field_46, iiIIiIIii_Class4042.i_field_46);
        return new iiIIiIIii_Class404(f, f2);
    }

    @Compile(obfuscation=1)
    public final float I_method_24e31c97(iiIIiIIii_Class404 iiIIiIIii_Class4042) {
        float f = iIIiiiiiI_Class319.iII_method_6550feaf(this.I_field_46, iiIIiIIii_Class4042.I_field_46);
        float f2 = iIIiiiiiI_Class319.iII_method_6550feaf(this.i_field_46, iiIIiIIii_Class4042.i_field_46);
        return Math.abs(f) + Math.abs(f2);
    }

    @Compile(obfuscation=1)
    public final Vec3d I_method_cbcdd559() {
        return iiIIiIIii_Class404.I_field_3a9bda27.player.getRotationVector(this.i_field_46, this.I_field_46);
    }

    @Compile(obfuscation=1)
    public final iiIIiIIii_Class404 I_method_c50b8f35(float f, float f2) {
        return new iiIIiIIii_Class404(this.I_field_46 + f, this.i_field_46 + f2);
    }

    @Generated
    public float I_method_14534e0f() {
        return this.I_field_46;
    }

    @Generated
    public float i_method_1461d9ef() {
        return this.i_field_46;
    }

    @Generated
    public void I_method_7616dd81(float f) {
        this.I_field_46 = f;
    }

    @Generated
    public void i_method_77d9cda1(float f) {
        this.i_field_46 = f;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof iiIIiIIii_Class404)) {
            return false;
        }
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = (iiIIiIIii_Class404)object;
        if (!iiIIiIIii_Class4042.I_method_cc41943f(this)) {
            return false;
        }
        if (Float.compare(this.I_method_14534e0f(), iiIIiIIii_Class4042.I_method_14534e0f()) != 0) {
            return false;
        }
        return Float.compare(this.i_method_1461d9ef(), iiIIiIIii_Class4042.i_method_1461d9ef()) == 0;
    }

    @Generated
    protected boolean I_method_cc41943f(Object object) {
        return object instanceof iiIIiIIii_Class404;
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        n2 = n2 * 59 + Float.floatToIntBits(this.I_method_14534e0f());
        n2 = n2 * 59 + Float.floatToIntBits(this.i_method_1461d9ef());
        return n2;
    }

    @Generated
    public String toString() {
        return "Rotation(yaw=" + this.I_method_14534e0f() + ", pitch=" + this.i_method_1461d9ef() + ")";
    }

    @Generated
    public iiIIiIIii_Class404(float f, float f2) {
        this.I_field_46 = f;
        this.i_field_46 = f2;
    }
}

