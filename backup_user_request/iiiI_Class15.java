package rockstar.client;

import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import net.minecraft.client.util.math.MatrixStack;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIii_Class4;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiI_Class3;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIIIIII_Class257;
import rockstar.client.iIIIIiIiI_Class267;
import rockstar.client.iIiiiIiII_Class373;
import rockstar.client.iiI_Class7;

public class iiiI_Class15
extends iiI_Class7 {
    private final IIiIIi_Class10 I_field_856d0221;
    private final IntSupplier I_field_ba7cd5ab;
    private final IntConsumer I_field_a2c190c1;
    private boolean I_field_5a;
    private int I_field_49 = -1;
    private static iiiI_Class15 I_field_fb07f0e1;
    private final IiI_Class3 I_field_b575d2cc = new IiI_Class3(1.0f, IIii_Class4.I_method_3682ece9(380L, IiiiIiiII_Class237.IIii_field_dd60aac));
    private final IiI_Class3 i_field_b575d2cc = new IiI_Class3(0.0f, IIii_Class4.iI_field_f93678c1);
    private final IiI_Class3 II_field_b575d2cc = new IiI_Class3(IIii_Class4.I_method_3682ece9(300L, IiiiIiiII_Class237.IIii_field_dd60aac));
    private Function<iiiI_Class15, ColorRGBA> I_field_aad1658 = iiiI_Class152 -> IiiiiIIIi_Class242.IIi_field_d0c8ec5;
    private ColorRGBA I_field_d0c8ec5 = IiiiiIIIi_Class242.iII_field_d0c8ec5;
    private ColorRGBA i_field_d0c8ec5 = IiiiiIIIi_Class242.ii_field_d0c8ec5;
    private float I_field_46 = 3.0f;
    private float i_field_46 = 4.0f;
    private float II_field_46 = 8.0f;
    private IntFunction<String> I_field_b3789d1f = iIIIIiIiI_Class267::I_method_a937749c;
    private String I_field_523beb0a;

    public iiiI_Class15(IIiIIi_Class10 iIiIIi_Class10, IntSupplier intSupplier, IntConsumer intConsumer) {
        this.I_field_856d0221 = iIiIIi_Class10;
        this.I_field_ba7cd5ab = intSupplier;
        this.I_field_a2c190c1 = intConsumer;
        this.Ii_method_66f5e68c(11.0f);
        this.snapSize();
        this.II_field_b575d2cc.i_method_84a13e41(this.I_method_d4d8841c());
    }

    public iiiI_Class15 I_method_f2246184(ColorRGBA colorRGBA) {
        this.I_field_aad1658 = iiiI_Class152 -> colorRGBA;
        return this;
    }

    public iiiI_Class15 I_method_2028ac11(Function<iiiI_Class15, ColorRGBA> function) {
        this.I_field_aad1658 = function;
        return this;
    }

    public iiiI_Class15 i_method_8fc74564(ColorRGBA colorRGBA) {
        this.I_field_d0c8ec5 = colorRGBA;
        return this;
    }

    public iiiI_Class15 II_method_19d5754d(ColorRGBA colorRGBA) {
        this.i_field_d0c8ec5 = colorRGBA;
        return this;
    }

    public iiiI_Class15 I_method_f2e10ae3(float f) {
        this.I_field_46 = f;
        return this;
    }

    public iiiI_Class15 i_method_2e0b6ec3(float f) {
        this.i_field_46 = f;
        return this;
    }

    public iiiI_Class15 II_method_2bcb82ac(float f) {
        this.II_field_46 = f;
        return this;
    }

    public iiiI_Class15 I_method_3be1acc(IntFunction<String> intFunction) {
        if (intFunction != null) {
            this.I_field_b3789d1f = intFunction;
        }
        return this;
    }

    public iiiI_Class15 I_method_65f5a41(String string) {
        this.I_field_523beb0a = string;
        return this;
    }

    public iiiI_Class15 I_method_5b1d462a(IIii_Class4 iIii_Class4) {
        if (iIii_Class4 != null) {
            this.I_field_b575d2cc.I_method_15cf9df6(iIii_Class4);
        }
        return this;
    }

    public iiiI_Class15 i_method_a620e4a(IIii_Class4 iIii_Class4) {
        if (iIii_Class4 != null) {
            this.II_field_b575d2cc.I_method_15cf9df6(iIii_Class4);
        }
        return this;
    }

    public boolean I_method_d4d88430() {
        return this.I_field_5a;
    }

    public static boolean i_method_d4e71010() {
        return I_field_fb07f0e1 != null && iiiI_Class15.I_field_fb07f0e1.I_field_5a;
    }

    public void I_method_d4d8842c() {
        this.I_field_5a = false;
        if (I_field_fb07f0e1 == this) {
            I_field_fb07f0e1 = null;
        }
    }

    public boolean I_method_10341dfe(IiIII_Class9 iiIII_Class9) {
        if (!this.I_field_5a || iiIII_Class9 == null) {
            return false;
        }
        this.I_method_c6387457(iIIIIIIII_Class257.Ii_method_99f62a34(iiIII_Class9.I_method_6d899712()));
        return true;
    }

    public static boolean i_method_3a56361e(IiIII_Class9 iiIII_Class9) {
        iiiI_Class15 iiiI_Class152 = I_field_fb07f0e1;
        if (iiiI_Class152 == null) {
            return false;
        }
        if (!iiiI_Class152.I_field_5a) {
            I_field_fb07f0e1 = null;
            return false;
        }
        return iiiI_Class152.I_method_10341dfe(iiIII_Class9);
    }

    public static void i_method_d4e7100c() {
        if (I_field_fb07f0e1 != null) {
            I_field_fb07f0e1.I_method_d4d8842c();
        }
    }

    public iiiI_Class15 Ii_method_66f5e68c(float f) {
        super.height(f);
        return this;
    }

    public iiiI_Class15 iI_method_55ed9acc(float f) {
        super.width(f);
        return this;
    }

    public iiiI_Class15 I_method_6c70d1cb(float f, float f2) {
        super.size(f, f2);
        return this;
    }

    public void I_method_10341dfa(IiIII_Class9 iiIII_Class9) {
        if (!this.I_field_5a && iiIII_Class9 == IiIII_Class9.I_field_2f4c8d6c) {
            this.I_field_5a = true;
            I_field_fb07f0e1 = this;
        } else if (this.I_field_5a) {
            this.I_method_c6387457(iIIIIIIII_Class257.Ii_method_99f62a34(iiIII_Class9.I_method_6d899712()));
        }
    }

    @Override
    public boolean keyPressed(int n, int n2, int n3) {
        if (!this.I_field_5a) {
            return false;
        }
        if (n == 256 || n == 261) {
            this.I_method_c6387457(-1);
            return true;
        }
        int n4 = iIIIIIIII_Class257.i_method_cd0c4692(n, n3);
        if (n4 == Integer.MIN_VALUE) {
            return true;
        }
        this.I_method_c6387457(n4);
        return true;
    }

    @Override
    public boolean keyReleased(int n, int n2, int n3) {
        if (!this.I_field_5a) {
            return false;
        }
        int n4 = iIIIIIIII_Class257.II_method_6e347cf5(n, n3);
        if (n4 == Integer.MIN_VALUE) {
            return false;
        }
        this.I_method_c6387457(n4);
        return true;
    }

    private void I_method_c6387457(int n) {
        this.I_field_49 = this.I_field_ba7cd5ab.getAsInt();
        this.I_field_a2c190c1.accept(n);
        this.I_field_b575d2cc.i_method_84a13e41(0.0f);
        this.I_field_b575d2cc.I_method_82de4e21(1.0f);
        this.I_field_5a = false;
        if (I_field_fb07f0e1 == this) {
            I_field_fb07f0e1 = null;
        }
    }

    @Override
    protected void measure() {
        if (!this.explicitW) {
            this.prefW = this.II_field_b575d2cc.I_method_4e8b496f();
        }
    }

    @Override
    protected void onTick(float f, float f2, float f3) {
        this.II_field_b575d2cc.I_method_82de4e21(this.I_method_d4d8841c());
        this.II_field_b575d2cc.Ii_method_dc72325e(f);
        this.i_field_b575d2cc.I_method_82de4e21(this.I_field_5a ? 1.0f : 0.0f);
        this.i_field_b575d2cc.Ii_method_dc72325e(f);
        this.I_field_b575d2cc.Ii_method_dc72325e(f);
    }

    private float I_method_d4d8841c() {
        return this.I_field_856d0221.I_method_2c375926(this.I_method_c10ccdf4()) + this.i_field_46 * 2.0f;
    }

    private String I_method_c10ccdf4() {
        if (this.I_field_5a) {
            int n = iIIIIIIII_Class257.I_method_e761de12();
            String string = n != 0 ? "..." : (this.I_field_523beb0a != null ? this.I_field_523beb0a : this.I_field_b3789d1f.apply(this.I_field_ba7cd5ab.getAsInt()));
            return iIIIIIIII_Class257.I_method_f90bbc5c(n) + (string == null ? "" : string);
        }
        String string = this.I_field_b3789d1f.apply(this.I_field_ba7cd5ab.getAsInt());
        return string == null ? "" : string;
    }

    @Override
    protected void drawSelf(III iII, float f) {
        String string;
        float f2 = this.x();
        float f3 = this.y();
        float f4 = this.w();
        float f5 = this.h();
        ColorRGBA colorRGBA = this.I_field_aad1658.apply(this);
        if (colorRGBA != null && colorRGBA.getAlpha() > 0.0f) {
            iII.drawRoundedRect(f2, f3, f4, f5, IIiii_Class8.I_method_893b2757(this.I_field_46), colorRGBA);
        }
        float f6 = this.I_field_b575d2cc.I_method_4e8b496f();
        float f7 = f3 + f5 / 2.0f - this.I_field_856d0221.I_method_a649725c() / 2.0f;
        float f8 = f2 + this.i_field_46;
        ColorRGBA colorRGBA2 = this.I_field_d0c8ec5.mix(this.i_field_d0c8ec5, this.i_field_b575d2cc.I_method_4e8b496f()).mulAlpha(0.75f + 0.25f * Math.max(this.hover(), this.i_field_b575d2cc.I_method_4e8b496f()));
        MatrixStack matrixStack = iII.getMatrices();
        iIiiiIiII_Class373.I_method_d5a5ee51(matrixStack, f2, f3, f4, f5);
        iII.drawText(this.I_field_856d0221, this.I_method_c10ccdf4(), f8 + (f6 - 1.0f) * this.w(), f7, colorRGBA2.mulAlpha(f6));
        if (f6 < 0.999f && (string = this.I_field_b3789d1f.apply(this.I_field_49)) != null) {
            iII.drawText(this.I_field_856d0221, string, f8 + f6 * this.w(), f7, colorRGBA2.mulAlpha(1.0f - f6));
        }
        iIiiiIiII_Class373.I_method_ff80a1df();
    }

}

