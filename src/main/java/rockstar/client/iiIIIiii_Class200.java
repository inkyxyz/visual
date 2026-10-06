package rockstar.client;

import lombok.Generated;
import net.minecraft.util.math.Vec2f;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.iiIIIiIi_Class198;

public final class iiIIIiii_Class200 {
    private final String I_field_523beb0a;
    private final Vec2f I_field_5bba09cd;
    private final Vec2f i_field_5bba09cd;
    private final boolean I_field_5a;
    private final float I_field_46;
    private final iiIIIiIi_Class198 I_field_c6215341;
    private final iiIIIiIi_Class198 i_field_c6215341;
    private final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.III_field_dd60aac);
    private final IiiiIiIii_Class236 i_field_dc7facc = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.III_field_dd60aac);

    @Generated
    public iiIIIiii_Class200(String string, Vec2f vec2f, Vec2f vec2f2, boolean bl, float f, iiIIIiIi_Class198 iiIIIiIi_Class1982, iiIIIiIi_Class198 iiIIIiIi_Class1983) {
        this.I_field_523beb0a = string;
        this.I_field_5bba09cd = vec2f;
        this.i_field_5bba09cd = vec2f2;
        this.I_field_5a = bl;
        this.I_field_46 = f;
        this.I_field_c6215341 = iiIIIiIi_Class1982;
        this.i_field_c6215341 = iiIIIiIi_Class1983;
    }

    @Generated
    public String I_method_62860974() {
        return this.I_field_523beb0a;
    }

    @Generated
    public Vec2f I_method_172627a3() {
        return this.I_field_5bba09cd;
    }

    @Generated
    public Vec2f i_method_bb1eab83() {
        return this.i_field_5bba09cd;
    }

    @Generated
    public boolean I_method_cbc2d8b0() {
        return this.I_field_5a;
    }

    @Generated
    public float I_method_cbc2d89c() {
        return this.I_field_46;
    }

    @Generated
    public iiIIIiIi_Class198 I_method_55c367ab() {
        return this.I_field_c6215341;
    }

    @Generated
    public iiIIIiIi_Class198 i_method_7fbff7cb() {
        return this.i_field_c6215341;
    }

    @Generated
    public IiiiIiIii_Class236 I_method_726873a2() {
        return this.I_field_dc7facc;
    }

    @Generated
    public IiiiIiIii_Class236 i_method_87fde782() {
        return this.i_field_dc7facc;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof iiIIIiii_Class200)) {
            return false;
        }
        iiIIIiii_Class200 iiIIIiii_Class2002 = (iiIIIiii_Class200)object;
        if (this.I_method_cbc2d8b0() != iiIIIiii_Class2002.I_method_cbc2d8b0()) {
            return false;
        }
        if (Float.compare(this.I_method_cbc2d89c(), iiIIIiii_Class2002.I_method_cbc2d89c()) != 0) {
            return false;
        }
        String string = this.I_method_62860974();
        String string2 = iiIIIiii_Class2002.I_method_62860974();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        Vec2f vec2f = this.I_method_172627a3();
        Vec2f vec2f2 = iiIIIiii_Class2002.I_method_172627a3();
        if (vec2f == null ? vec2f2 != null : !vec2f.equals(vec2f2)) {
            return false;
        }
        Vec2f vec2f3 = this.i_method_bb1eab83();
        Vec2f vec2f4 = iiIIIiii_Class2002.i_method_bb1eab83();
        if (vec2f3 == null ? vec2f4 != null : !vec2f3.equals(vec2f4)) {
            return false;
        }
        iiIIIiIi_Class198 iiIIIiIi_Class1982 = this.I_method_55c367ab();
        iiIIIiIi_Class198 iiIIIiIi_Class1983 = iiIIIiii_Class2002.I_method_55c367ab();
        if (iiIIIiIi_Class1982 == null ? iiIIIiIi_Class1983 != null : !((Object)iiIIIiIi_Class1982).equals(iiIIIiIi_Class1983)) {
            return false;
        }
        iiIIIiIi_Class198 iiIIIiIi_Class1984 = this.i_method_7fbff7cb();
        iiIIIiIi_Class198 iiIIIiIi_Class1985 = iiIIIiii_Class2002.i_method_7fbff7cb();
        if (iiIIIiIi_Class1984 == null ? iiIIIiIi_Class1985 != null : !((Object)iiIIIiIi_Class1984).equals(iiIIIiIi_Class1985)) {
            return false;
        }
        IiiiIiIii_Class236 iiiiIiIii_Class236 = this.I_method_726873a2();
        IiiiIiIii_Class236 iiiiIiIii_Class2362 = iiIIIiii_Class2002.I_method_726873a2();
        if (iiiiIiIii_Class236 == null ? iiiiIiIii_Class2362 != null : !iiiiIiIii_Class236.equals(iiiiIiIii_Class2362)) {
            return false;
        }
        IiiiIiIii_Class236 iiiiIiIii_Class2363 = this.i_method_87fde782();
        IiiiIiIii_Class236 iiiiIiIii_Class2364 = iiIIIiii_Class2002.i_method_87fde782();
        return !(iiiiIiIii_Class2363 == null ? iiiiIiIii_Class2364 != null : !iiiiIiIii_Class2363.equals(iiiiIiIii_Class2364));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        n2 = n2 * 59 + (this.I_method_cbc2d8b0() ? 79 : 97);
        n2 = n2 * 59 + Float.floatToIntBits(this.I_method_cbc2d89c());
        String string = this.I_method_62860974();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        Vec2f vec2f = this.I_method_172627a3();
        n2 = n2 * 59 + (vec2f == null ? 43 : vec2f.hashCode());
        Vec2f vec2f2 = this.i_method_bb1eab83();
        n2 = n2 * 59 + (vec2f2 == null ? 43 : vec2f2.hashCode());
        iiIIIiIi_Class198 iiIIIiIi_Class1982 = this.I_method_55c367ab();
        n2 = n2 * 59 + (iiIIIiIi_Class1982 == null ? 43 : ((Object)iiIIIiIi_Class1982).hashCode());
        iiIIIiIi_Class198 iiIIIiIi_Class1983 = this.i_method_7fbff7cb();
        n2 = n2 * 59 + (iiIIIiIi_Class1983 == null ? 43 : ((Object)iiIIIiIi_Class1983).hashCode());
        IiiiIiIii_Class236 iiiiIiIii_Class236 = this.I_method_726873a2();
        n2 = n2 * 59 + (iiiiIiIii_Class236 == null ? 43 : iiiiIiIii_Class236.hashCode());
        IiiiIiIii_Class236 iiiiIiIii_Class2362 = this.i_method_87fde782();
        n2 = n2 * 59 + (iiiiIiIii_Class2362 == null ? 43 : iiiiIiIii_Class2362.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "SwingPreset(name=" + this.I_method_62860974() + ", bezierStart=" + String.valueOf(this.I_method_172627a3()) + ", bezierEnd=" + String.valueOf(this.i_method_bb1eab83()) + ", swingBack=" + this.I_method_cbc2d8b0() + ", speed=" + this.I_method_cbc2d89c() + ", from=" + String.valueOf(this.I_method_55c367ab()) + ", to=" + String.valueOf(this.i_method_7fbff7cb()) + ", hoverAnimation=" + String.valueOf(this.I_method_726873a2()) + ", activeAnimation=" + String.valueOf(this.i_method_87fde782()) + ")";
    }
}

