package rockstar.client;

import lombok.Generated;
import rockstar.client.iIIiiiiiI_Class319;

public interface IiiiIiiII_Class237 {
    public static final IiiiIiiII_Class237 I_field_dd60aac = IiiiIiiII_Class237.I_method_ae57f375(0.45f, 1.45f, 0.49f, 1.15f);
    public static final IiiiIiiII_Class237 i_field_dd60aac = IiiiIiiII_Class237.I_method_ae57f375(0.45f, 1.45f, 0.43f, 0.91f);
    public static final IiiiIiiII_Class237 II_field_dd60aac = IiiiIiiII_Class237.I_method_ae57f375(0.1f, 1.07f, 0.34f, 1.04f);
    public static final IiiiIiiII_Class237 Ii_field_dd60aac = IiiiIiiII_Class237.I_method_ae57f375(0.27f, 1.09f, 0.49f, 1.06f);
    public static final IiiiIiiII_Class237 iI_field_dd60aac = IiiiIiiII_Class237.I_method_ae57f375(0.62, -0.16, 0.8, 0.37);
    public static final IiiiIiiII_Class237 ii_field_dd60aac = IiiiIiiII_Class237.I_method_ae57f375(0.25, 1.07, 0.11, 1.1);
    public static final IiiiIiiII_Class237 III_field_dd60aac = IiiiIiiII_Class237.I_method_ae57f375(0.42, 0.0, 0.58, 1.0);
    public static final IiiiIiiII_Class237 IIi_field_dd60aac = (f, f2, f3, f4) -> {
        float f5 = f3 * f / f4 + f2;
        return (float)(-2.0 * Math.pow(f5, 3.0) + 3.0 * Math.pow(f5, 2.0));
    };
    public static final IiiiIiiII_Class237 IiI_field_dd60aac = (f, f2, f3, f4) -> {
        float f5 = f3 * f / f4 + f2;
        return (double)f5 < 0.5 ? 4.0f * f5 * f5 * f5 : (float)(1.0 - Math.pow(-2.0f * f5 + 2.0f, 3.0) / 2.0);
    };
    public static final IiiiIiiII_Class237 Iii_field_dd60aac = (f, f2, f3, f4) -> f3 * f / f4 + f2;
    public static final IiiiIiiII_Class237 iII_field_dd60aac = (f, f2, f3, f4) -> f3 * (f /= f4) * f + f2;
    public static final IiiiIiiII_Class237 iIi_field_dd60aac = (f, f2, f3, f4) -> -f3 * (f /= f4) * (f - 2.0f) + f2;
    public static final IiiiIiiII_Class237 iiI_field_dd60aac = (f, f2, f3, f4) -> {
        float f5;
        f /= f4 / 2.0f;
        if (f < 1.0f) {
            return f3 / 2.0f * f * f + f2;
        }
        return -f3 / 2.0f * ((f -= 1.0f) * (f - 2.0f) - 1.0f) + f2;
    };
    public static final IiiiIiiII_Class237 iii_field_dd60aac = (f, f2, f3, f4) -> f3 * (f /= f4) * f * f + f2;
    public static final IiiiIiiII_Class237 IIII_field_dd60aac = (f, f2, f3, f4) -> {
        f = f / f4 - 1.0f;
        return f3 * (f * f * f + 1.0f) + f2;
    };
    public static final IiiiIiiII_Class237 IIIi_field_dd60aac = (f, f2, f3, f4) -> {
        float f5;
        f /= f4 / 2.0f;
        if (f < 1.0f) {
            return f3 / 2.0f * f * f * f + f2;
        }
        return f3 / 2.0f * ((f -= 2.0f) * f * f + 2.0f) + f2;
    };
    public static final IiiiIiiII_Class237 IIiI_field_dd60aac = (f, f2, f3, f4) -> f3 * (f /= f4) * f * f * f + f2;
    public static final IiiiIiiII_Class237 IIii_field_dd60aac = (f, f2, f3, f4) -> {
        f = f / f4 - 1.0f;
        return -f3 * (f * f * f * f - 1.0f) + f2;
    };
    public static final IiiiIiiII_Class237 IiII_field_dd60aac = (f, f2, f3, f4) -> {
        float f5;
        f /= f4 / 2.0f;
        if (f < 1.0f) {
            return f3 / 2.0f * f * f * f * f + f2;
        }
        return -f3 / 2.0f * ((f -= 2.0f) * f * f * f - 2.0f) + f2;
    };
    public static final IiiiIiiII_Class237 IiIi_field_dd60aac = (f, f2, f3, f4) -> f3 * (f /= f4) * f * f * f * f + f2;
    public static final IiiiIiiII_Class237 IiiI_field_dd60aac = (f, f2, f3, f4) -> {
        f = f / f4 - 1.0f;
        return f3 * (f * f * f * f * f + 1.0f) + f2;
    };
    public static final IiiiIiiII_Class237 Iiii_field_dd60aac = (f, f2, f3, f4) -> {
        float f5;
        f /= f4 / 2.0f;
        if (f < 1.0f) {
            return f3 / 2.0f * f * f * f * f * f + f2;
        }
        return f3 / 2.0f * ((f -= 2.0f) * f * f * f * f + 2.0f) + f2;
    };
    public static final IiiiIiiII_Class237 iIII_field_dd60aac = (f, f2, f3, f4) -> -f3 * (float)iIIiiiiiI_Class319.i_method_a749d9ed((double)(f / f4) * 1.5707963267948966) + f3 + f2;
    public static final IiiiIiiII_Class237 iIIi_field_dd60aac = (f, f2, f3, f4) -> f3 * (float)iIIiiiiiI_Class319.I_method_a586e9cd((double)(f / f4) * 1.5707963267948966) + f2;
    public static final IiiiIiiII_Class237 iIiI_field_dd60aac = (f, f2, f3, f4) -> -f3 / 2.0f * ((float)iIIiiiiiI_Class319.i_method_a749d9ed(Math.PI * (double)f / (double)f4) - 1.0f) + f2;
    public static final IiiiIiiII_Class237 iIii_field_dd60aac = (f, f2, f3, f4) -> f == 0.0f ? f2 : f3 * (float)Math.pow(2.0, 10.0f * (f / f4 - 1.0f)) + f2;
    public static final IiiiIiiII_Class237 iiII_field_dd60aac = (f, f2, f3, f4) -> f == f4 ? f2 + f3 : f3 * (-((float)Math.pow(2.0, -10.0f * f / f4)) + 1.0f) + f2;
    public static final IiiiIiiII_Class237 iiIi_field_dd60aac = (f, f2, f3, f4) -> {
        float f5;
        if (f == 0.0f) {
            return f2;
        }
        if (f == f4) {
            return f2 + f3;
        }
        f /= f4 / 2.0f;
        if (f < 1.0f) {
            return f3 / 2.0f * (float)Math.pow(2.0, 10.0f * (f - 1.0f)) + f2;
        }
        return f3 / 2.0f * (-((float)Math.pow(2.0, -10.0f * (f -= 1.0f))) + 2.0f) + f2;
    };
    public static final IiiiIiiII_Class237 iiiI_field_dd60aac = (f, f2, f3, f4) -> -f3 * ((float)Math.sqrt(1.0f - (f /= f4) * f) - 1.0f) + f2;
    public static final IiiiIiiII_Class237 iiii_field_dd60aac = (f, f2, f3, f4) -> {
        f = f / f4 - 1.0f;
        return f3 * (float)Math.sqrt(1.0f - f * f) + f2;
    };
    public static final IiiiIiiII_Class237 IIIII_field_dd60aac = (f, f2, f3, f4) -> {
        float f5;
        f /= f4 / 2.0f;
        if (f < 1.0f) {
            return -f3 / 2.0f * ((float)Math.sqrt(1.0f - f * f) - 1.0f) + f2;
        }
        return f3 / 2.0f * ((float)Math.sqrt(1.0f - (f -= 2.0f) * f) + 1.0f) + f2;
    };
    public static final Nested1_acc5f009 I_field_1f3b0486 = new Nested1_acc5f029();
    public static final Nested1_acc5f009 i_field_1f3b0486 = new Nested1_ebf79960();
    public static final Nested1_acc5f009 II_field_1f3b0486 = new Nested1_ebf79940();
    public static final Nested1_2edd1820 I_field_f07dc267 = new Nested1_2edd1840();
    public static final Nested1_2edd1820 i_field_f07dc267 = new Nested1_acc5ec49();
    public static final Nested1_2edd1820 II_field_f07dc267 = new Nested1_acc5ec29();
    public static final IiiiIiiII_Class237 IIIIi_field_dd60aac = (f, f2, f3, f4) -> {
        float f5;
        f /= f4;
        if (f < 0.36363637f) {
            return f3 * (7.5625f * f * f) + f2;
        }
        if (f < 0.72727275f) {
            return f3 * (7.5625f * (f -= 0.54545456f) * f + 0.75f) + f2;
        }
        if (f < 0.90909094f) {
            return f3 * (7.5625f * (f -= 0.8181818f) * f + 0.9375f) + f2;
        }
        return f3 * (7.5625f * (f -= 0.95454544f) * f + 0.984375f) + f2;
    };
    public static final IiiiIiiII_Class237 IIIiI_field_dd60aac = (f, f2, f3, f4) -> f3 - IIIIi_field_dd60aac.ease(f4 - f, 0.0f, f3, f4) + f2;
    public static final IiiiIiiII_Class237 IIIii_field_dd60aac = (f, f2, f3, f4) -> {
        if (f < f4 / 2.0f) {
            return IIIiI_field_dd60aac.ease(f * 2.0f, 0.0f, f3, f4) * 0.5f + f2;
        }
        return IIIIi_field_dd60aac.ease(f * 2.0f - f4, 0.0f, f3, f4) * 0.5f + f3 * 0.5f + f2;
    };

    public static IiiiIiiII_Class237 I_method_ae57f375(final double d, final double d2, final double d3, final double d4) {
        return new IiiiIiiII_Class237(){

            @Override
            public float ease(float f, float f2, float f3, float f4) {
                if (f4 <= 0.0f || f <= 0.0f) {
                    return f2;
                }
                if (f >= f4) {
                    return f2 + f3;
                }
                float f5 = f / f4;
                float f6 = this.I_method_16c2a9be((float)d, (float)d3, f5);
                float f7 = this.Ii_method_fcd6a081(f6, (float)d2, (float)d4);
                return f2 + f3 * f7;
            }

            private float I_method_16c2a9be(float f, float f2, float f3) {
                float f4 = f3;
                int n = 8;
                float f5 = 1.0E-5f;
                for (int i = 0; i < 8; ++i) {
                    float f6 = this.i_method_b38a11de(f4, f, f2);
                    float f7 = this.II_method_600f3861(f4, f, f2);
                    if (Math.abs(f6 - f3) < 1.0E-5f || Math.abs(f7) < 1.0E-6f) break;
                    f4 -= (f6 - f3) / f7;
                    f4 = Math.max(0.0f, Math.min(1.0f, f4));
                }
                return f4;
            }

            private float i_method_b38a11de(float f, float f2, float f3) {
                return 3.0f * (1.0f - f) * (1.0f - f) * f * f2 + 3.0f * (1.0f - f) * f * f * f3 + f * f * f;
            }

            private float II_method_600f3861(float f, float f2, float f3) {
                return 3.0f * ((1.0f - f) * (1.0f - 3.0f * f) * f2 + (2.0f * f - 3.0f * f * f) * f3) + 3.0f * f * f;
            }

            private float Ii_method_fcd6a081(float f, float f2, float f3) {
                return 3.0f * (1.0f - f) * (1.0f - f) * f * f2 + 3.0f * (1.0f - f) * f * f * f3 + f * f * f;
            }
        };
    }

    public float ease(float var1, float var2, float var3, float var4);

    public static class Nested1_acc5f029
    extends Nested1_acc5f009 {
        public Nested1_acc5f029(float f, float f2) {
            super(f, f2);
        }

        public Nested1_acc5f029() {
        }

        @Override
        public float ease(float f, float f2, float f3, float f4) {
            float f5 = this.I_method_2375b141();
            float f6 = this.i_method_23843d21();
            if (f == 0.0f) {
                return f2;
            }
            if ((f /= f4) == 1.0f) {
                return f2 + f3;
            }
            if (f6 == 0.0f) {
                f6 = f4 * 0.3f;
            }
            float f7 = 0.0f;
            if (f5 < Math.abs(f3)) {
                f5 = f3;
                f7 = f6 / 4.0f;
            } else {
                f7 = f6 / ((float)Math.PI * 2) * (float)Math.asin(f3 / f5);
            }
            return -(f5 * (float)Math.pow(2.0, 10.0f * (f -= 1.0f)) * (float)iIIiiiiiI_Class319.I_method_a586e9cd((double)(f * f4 - f7) * (Math.PI * 2) / (double)f6)) + f2;
        }
    }

    public static abstract class Nested1_acc5f009
    implements IiiiIiiII_Class237 {
        private float I_field_46;
        private float i_field_46;

        public Nested1_acc5f009(float f, float f2) {
            this.I_field_46 = f;
            this.i_field_46 = f2;
        }

        public Nested1_acc5f009() {
            this(-1.0f, 0.0f);
        }

        @Generated
        public void I_method_4b40e08f(float f) {
            this.I_field_46 = f;
        }

        @Generated
        public void i_method_4d03d0af(float f) {
            this.i_field_46 = f;
        }

        @Generated
        public float I_method_2375b141() {
            return this.I_field_46;
        }

        @Generated
        public float i_method_23843d21() {
            return this.i_field_46;
        }
    }

    public static class Nested1_ebf79960
    extends Nested1_acc5f009 {
        public Nested1_ebf79960(float f, float f2) {
            super(f, f2);
        }

        public Nested1_ebf79960() {
        }

        @Override
        public float ease(float f, float f2, float f3, float f4) {
            float f5 = this.I_method_2375b141();
            float f6 = this.i_method_23843d21();
            if (f == 0.0f) {
                return f2;
            }
            if ((f /= f4) == 1.0f) {
                return f2 + f3;
            }
            if (f6 == 0.0f) {
                f6 = f4 * 0.3f;
            }
            float f7 = 0.0f;
            if (f5 < Math.abs(f3)) {
                f5 = f3;
                f7 = f6 / 4.0f;
            } else {
                f7 = f6 / ((float)Math.PI * 2) * (float)Math.asin(f3 / f5);
            }
            return f5 * (float)Math.pow(2.0, -10.0f * f) * (float)iIIiiiiiI_Class319.I_method_a586e9cd((double)(f * f4 - f7) * (Math.PI * 2) / (double)f6) + f3 + f2;
        }
    }

    public static class Nested1_ebf79940
    extends Nested1_acc5f009 {
        public Nested1_ebf79940(float f, float f2) {
            super(f, f2);
        }

        public Nested1_ebf79940() {
        }

        @Override
        public float ease(float f, float f2, float f3, float f4) {
            float f5 = this.I_method_2375b141();
            float f6 = this.i_method_23843d21();
            if (f == 0.0f) {
                return f2;
            }
            if ((f /= f4 / 2.0f) == 2.0f) {
                return f2 + f3;
            }
            if (f6 == 0.0f) {
                f6 = f4 * 0.45000002f;
            }
            float f7 = 0.0f;
            if (f5 < Math.abs(f3)) {
                f5 = f3;
                f7 = f6 / 4.0f;
            } else {
                f7 = f6 / ((float)Math.PI * 2) * (float)Math.asin(f3 / f5);
            }
            if (f < 1.0f) {
                return -0.5f * (f5 * (float)Math.pow(2.0, 10.0f * (f -= 1.0f)) * (float)iIIiiiiiI_Class319.I_method_a586e9cd((double)(f * f4 - f7) * (Math.PI * 2) / (double)f6)) + f2;
            }
            return f5 * (float)Math.pow(2.0, -10.0f * (f -= 1.0f)) * (float)iIIiiiiiI_Class319.I_method_a586e9cd((double)(f * f4 - f7) * (Math.PI * 2) / (double)f6) * 0.5f + f3 + f2;
        }
    }

    public static class Nested1_2edd1840
    extends Nested1_2edd1820 {
        public Nested1_2edd1840() {
        }

        public Nested1_2edd1840(float f) {
            super(f);
        }

        @Override
        public float ease(float f, float f2, float f3, float f4) {
            float f5 = this.I_method_c0d6ff8a();
            return f3 * (f /= f4) * f * ((f5 + 1.0f) * f - f5) + f2;
        }
    }

    public static abstract class Nested1_2edd1820
    implements IiiiIiiII_Class237 {
        public static final float I_field_46 = 1.70158f;
        private float i_field_46;

        public Nested1_2edd1820() {
            this(1.70158f);
        }

        public Nested1_2edd1820(float f) {
            this.i_field_46 = f;
        }

        @Generated
        public void I_method_5a095b66(float f) {
            this.i_field_46 = f;
        }

        @Generated
        public float I_method_c0d6ff8a() {
            return this.i_field_46;
        }
    }

    public static class Nested1_acc5ec49
    extends Nested1_2edd1820 {
        public Nested1_acc5ec49() {
        }

        public Nested1_acc5ec49(float f) {
            super(f);
        }

        @Override
        public float ease(float f, float f2, float f3, float f4) {
            float f5 = this.I_method_c0d6ff8a();
            f = f / f4 - 1.0f;
            return f3 * (f * f * ((f5 + 1.0f) * f + f5) + 1.0f) + f2;
        }
    }

    public static class Nested1_acc5ec29
    extends Nested1_2edd1820 {
        public Nested1_acc5ec29() {
        }

        public Nested1_acc5ec29(float f) {
            super(f);
        }

        @Override
        public float ease(float f, float f2, float f3, float f4) {
            float f5;
            float f6 = this.I_method_c0d6ff8a();
            f /= f4 / 2.0f;
            if (f < 1.0f) {
                return f3 / 2.0f * (f * f * (((f6 *= 1.525f) + 1.0f) * f - f6)) + f2;
            }
            return f3 / 2.0f * ((f -= 2.0f) * f * (((f6 *= 1.525f) + 1.0f) * f + f6) + 2.0f) + f2;
        }
    }
}
