package rockstar.client;

import rockstar.client.IiI_Class3;
import rockstar.client.IiiiIiiII_Class237;

public abstract class IIii_Class4 {
    public static final IIii_Class4 I_field_f93678c1 = IIii_Class4.I_method_3682ece9(300L, IiiiIiiII_Class237.I_field_dd60aac);
    public static final IIii_Class4 i_field_f93678c1 = IIii_Class4.I_method_3682ece9(450L, IiiiIiiII_Class237.i_field_dd60aac);
    public static final IIii_Class4 II_field_f93678c1 = IIii_Class4.I_method_3682ece9(250L, IiiiIiiII_Class237.III_field_dd60aac);
    public static final IIii_Class4 Ii_field_f93678c1 = IIii_Class4.I_method_3682ece9(150L, IiiiIiiII_Class237.IIii_field_dd60aac);
    public static final IIii_Class4 iI_field_f93678c1 = IIii_Class4.I_method_3682ece9(200L, IiiiIiiII_Class237.IIii_field_dd60aac);
    public static final IIii_Class4 ii_field_f93678c1 = IIii_Class4.I_method_f17ae5cb(220.0f, 24.0f);
    public static final IIii_Class4 III_field_f93678c1 = IIii_Class4.I_method_f17ae5cb(380.0f, 30.0f);

    public abstract void I_method_ecef089f(IiI_Class3 var1);

    public abstract void I_method_b0f27301(IiI_Class3 var1, float var2);

    public boolean I_method_171120c3(IiI_Class3 iiI_Class3) {
        return Math.abs(iiI_Class3.I_field_46 - iiI_Class3.i_field_46) < 0.01f && Math.abs(iiI_Class3.II_field_46) < 0.01f;
    }

    public static IIii_Class4 I_method_3682ece9(long l, IiiiIiiII_Class237 iiiiIiiII_Class237) {
        return new Nested1_26df1db3(l, iiiiIiiII_Class237);
    }

    public static IIii_Class4 I_method_48883e1f(long l) {
        return IIii_Class4.I_method_3682ece9(l, IiiiIiiII_Class237.Iii_field_dd60aac);
    }

    public static IIii_Class4 I_method_f17ae5cb(float f, float f2) {
        return new Nested1_26df1d93(f, f2);
    }

    static final class Nested1_26df1db3
    extends IIii_Class4 {
        private final long I_field_4a;
        private final IiiiIiiII_Class237 I_field_dd60aac;

        Nested1_26df1db3(long l, IiiiIiiII_Class237 iiiiIiiII_Class237) {
            this.I_field_4a = Math.max(1L, l);
            this.I_field_dd60aac = iiiiIiiII_Class237;
        }

        @Override
        public void I_method_ecef089f(IiI_Class3 iiI_Class3) {
            iiI_Class3.Ii_field_46 = iiI_Class3.I_field_46;
            iiI_Class3.iI_field_46 = 0.0f;
        }

        @Override
        public void I_method_b0f27301(IiI_Class3 iiI_Class3, float f) {
            if (iiI_Class3.I_field_46 == iiI_Class3.i_field_46) {
                return;
            }
            iiI_Class3.iI_field_46 += f;
            float f2 = Math.min(1.0f, iiI_Class3.iI_field_46 / (float)this.I_field_4a);
            float f3 = this.I_field_dd60aac.ease(f2, 0.0f, 1.0f, 1.0f);
            iiI_Class3.I_field_46 = iiI_Class3.Ii_field_46 + (iiI_Class3.i_field_46 - iiI_Class3.Ii_field_46) * f3;
            if (f2 >= 1.0f) {
                iiI_Class3.I_field_46 = iiI_Class3.i_field_46;
                iiI_Class3.II_field_46 = 0.0f;
            }
        }

        @Override
        public boolean I_method_171120c3(IiI_Class3 iiI_Class3) {
            return iiI_Class3.I_field_46 == iiI_Class3.i_field_46;
        }
    }

    static final class Nested1_26df1d93
    extends IIii_Class4 {
        private final float I_field_46;
        private final float i_field_46;

        Nested1_26df1d93(float f, float f2) {
            this.I_field_46 = f;
            this.i_field_46 = f2;
        }

        @Override
        public void I_method_ecef089f(IiI_Class3 iiI_Class3) {
        }

        @Override
        public void I_method_b0f27301(IiI_Class3 iiI_Class3, float f) {
            float f2 = Math.min(0.05f, f / 1000.0f);
            if (f2 <= 0.0f) {
                return;
            }
            float f3 = iiI_Class3.I_field_46 - iiI_Class3.i_field_46;
            float f4 = -this.I_field_46 * f3 - this.i_field_46 * iiI_Class3.II_field_46;
            iiI_Class3.II_field_46 += f4 * f2;
            iiI_Class3.I_field_46 += iiI_Class3.II_field_46 * f2;
            if (Math.abs(f3) < 0.05f && Math.abs(iiI_Class3.II_field_46) < 0.05f) {
                iiI_Class3.I_field_46 = iiI_Class3.i_field_46;
                iiI_Class3.II_field_46 = 0.0f;
            }
        }
    }
}

