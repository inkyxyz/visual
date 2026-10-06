package rockstar.client;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.util.math.MathHelper;
import rockstar.client.iiIIiIiIi_Class406;
import rockstar.client.iiiIiiII_Class237;

public final class iiiIiIIi_Class234 {
    private static final float I_field_46 = 20.0f;
    private float[] I_field_b4b;
    private float i_field_46 = 20.0f;
    private float II_field_46;
    private float Ii_field_46;
    private float iI_field_46;
    private float ii_field_46;
    private float III_field_46;
    private float IIi_field_46;
    private float IiI_field_46;
    private float Iii_field_46;
    private float iII_field_46;
    private float iIi_field_46;
    private float iiI_field_46;
    private float iii_field_46 = 5.0f;
    private float IIII_field_46 = 15.0f;
    private double I_field_44 = 3.0;
    private boolean I_field_5a;

    public boolean I_method_57fa0cf0() {
        return this.I_field_b4b != null;
    }

    public void I_method_e9d4590d(iiiIiiII_Class237 iiiIiiII_Class2372, float f, float f2, float f3, float f4) {
        this.I_field_b4b = iiiIiiII_Class2372.I_method_930e0975();
        this.Ii_field_46 = f3;
        this.iI_field_46 = f4;
        this.II_field_46 = 0.0f;
        this.iiI_field_46 = 0.0f;
        this.iIi_field_46 = 0.0f;
        this.iII_field_46 = 0.0f;
        this.Iii_field_46 = 0.0f;
        this.ii_field_46 = this.IIi_field_46 = MathHelper.wrapDegrees((float)(f3 - f));
        this.III_field_46 = this.IiI_field_46 = f4 - f2;
    }

    public void I_method_57fa0cec() {
        this.I_field_b4b = null;
        this.II_field_46 = 0.0f;
    }

    public void i_method_580898cc() {
        this.i_field_46 = 0.0f;
    }

    public void II_method_a75687f5() {
        this.i_field_46 = Math.min(this.i_field_46 + 1.0f, 20.0f);
    }

    public boolean i_method_580898d0() {
        return this.I_field_5a;
    }

    public boolean I_method_5863bed8(iiiIiiII_Class237 iiiIiiII_Class2372, float f, float f2, float f3, float f4, float f5, float f6, double d, float f7, int n, float f8, int n2, float f9, float[] fArray) {
        float f10;
        boolean bl;
        if (iiiIiiII_Class2372 == null) {
            return false;
        }
        if (this.I_field_b4b == null) {
            this.I_method_e9d4590d(iiiIiiII_Class2372, f, f2, f3, f4);
        }
        this.iii_field_46 = f5;
        this.IIII_field_46 = f6;
        this.I_field_44 = d;
        float f11 = iiIIiIiIi_Class406.I_method_73b181cf();
        float f12 = MathHelper.wrapDegrees((float)(f3 - this.Ii_field_46));
        float f13 = f4 - this.iI_field_46;
        this.Ii_field_46 = f3;
        this.iI_field_46 = f4;
        float f14 = MathHelper.wrapDegrees((float)(f3 - f));
        float f15 = f4 - f2;
        float[] fArray2 = iiiIiiII_Class2372.I_method_13bc795f(this.I_method_a471ca34(iiiIiiII_Class2372, f12, f13), this.I_field_b4b);
        float f16 = 0.0f;
        float f17 = 0.0f;
        boolean bl2 = bl = this.II_field_46 >= (float)Math.min(n, iiiIiiII_Class2372.I_method_1d8494df());
        if (bl || ThreadLocalRandom.current().nextFloat() >= iiiIiiII_Class237.i_method_94d16064(fArray2[0])) {
            f10 = Float.MAX_VALUE;
            for (int i = n2; i > 0; --i) {
                int n3 = 1 + 6 * iiiIiiII_Class2372.I_method_a6890dc(fArray2, ThreadLocalRandom.current().nextFloat());
                float f18 = iiiIiiII_Class237.II_method_d083665b(fArray2[n3 + 5]);
                float f19 = (float)Math.sqrt(Math.max(0.0f, 1.0f - f18 * f18));
                float f20 = iiiIiIIi_Class234.I_method_57fa0cdc();
                float f21 = f18 * f20 + f19 * iiiIiIIi_Class234.I_method_57fa0cdc();
                float f22 = iiiIiIIi_Class234.I_method_41b779dc(f9 * iiiIiiII_Class2372.I_method_bccbec58(fArray2[n3 + 1], fArray2[n3 + 3], true, f20, f8), f11);
                float f23 = iiiIiIIi_Class234.I_method_41b779dc(f9 * iiiIiiII_Class2372.I_method_bccbec58(fArray2[n3 + 2], fArray2[n3 + 4], false, f21, f8), f11);
                float f24 = Math.abs((float)Math.hypot(MathHelper.wrapDegrees((float)(f14 - f22)) / this.iii_field_46, (f15 - f23) / this.IIII_field_46) - f7);
                if (!(f24 < f10)) continue;
                f10 = f24;
                f16 = f22;
                f17 = f23;
            }
        }
        if (bl && f16 == 0.0f && f17 == 0.0f) {
            if (Math.abs(f14) >= Math.abs(f15)) {
                f16 = Math.copySign(f11, f14);
            } else {
                f17 = Math.copySign(f11, f15);
            }
        }
        this.II_field_46 = f16 == 0.0f && f17 == 0.0f ? this.II_field_46 + 1.0f : 0.0f;
        f10 = MathHelper.clamp((float)(f2 + f17), (float)-90.0f, (float)90.0f);
        f17 = f10 - f2;
        this.iIi_field_46 = this.Iii_field_46;
        this.iiI_field_46 = this.iII_field_46;
        this.Iii_field_46 = f16;
        this.iII_field_46 = f17;
        this.IIi_field_46 = this.ii_field_46;
        this.IiI_field_46 = this.III_field_46;
        this.ii_field_46 = MathHelper.wrapDegrees((float)(f3 - (f + f16)));
        this.III_field_46 = f4 - f10;
        this.I_field_5a = Math.abs(this.ii_field_46) <= this.iii_field_46 && Math.abs(this.III_field_46) <= this.IIII_field_46;
        fArray[0] = f16;
        fArray[1] = f17;
        return true;
    }

    private float[] I_method_a471ca34(iiiIiiII_Class237 iiiIiiII_Class2372, float f, float f2) {
        return new float[]{iiiIiIIi_Class234.I_method_a747f844(this.ii_field_46), iiiIiIIi_Class234.I_method_a747f844(this.III_field_46), iiiIiIIi_Class234.I_method_a747f844(MathHelper.wrapDegrees((float)(this.ii_field_46 - this.IIi_field_46))), iiiIiIIi_Class234.I_method_a747f844(this.III_field_46 - this.IiI_field_46), iiiIiIIi_Class234.I_method_a747f844(f), iiiIiIIi_Class234.I_method_a747f844(f2), iiiIiIIi_Class234.I_method_a747f844(this.Iii_field_46), iiiIiIIi_Class234.I_method_a747f844(this.iII_field_46), iiiIiIIi_Class234.I_method_a747f844(this.iIi_field_46), iiiIiIIi_Class234.I_method_a747f844(this.iiI_field_46), iiiIiIIi_Class234.I_method_a747f844(this.ii_field_46 / this.iii_field_46), iiiIiIIi_Class234.I_method_a747f844(this.III_field_46 / this.IIII_field_46), (float)Math.log(Math.max(this.I_field_44, 0.05) + 0.5) / 2.0f, (float)Math.log(this.iii_field_46) / 3.0f, this.I_field_5a ? 1.0f : 0.0f, this.i_field_46 / 20.0f, this.II_field_46 / (float)iiiIiiII_Class2372.I_method_1d8494df()};
    }

    private static float I_method_a747f844(float f) {
        return (float)(Math.log((double)f + Math.sqrt((double)(f * f) + 1.0)) / 3.0);
    }

    private static float I_method_57fa0cdc() {
        return (float)ThreadLocalRandom.current().nextGaussian();
    }

    private static float I_method_41b779dc(float f, float f2) {
        return (float)Math.round(f / f2) * f2;
    }
}

