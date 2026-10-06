package rockstar.client;

import java.util.function.Function;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIii_Class4;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiI_Class3;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iiI_Class7;

public class IIIii_Class4
extends iiI_Class7 {
    private final Nested1_b342a3a0 I_field_f368ace7;
    private final Nested1_b342a380 I_field_f368a907;
    private final float I_field_46;
    private final float i_field_46;
    private float II_field_46;
    private Function<IIIii_Class4, ColorRGBA> I_field_aad1658 = iIIii_Class4 -> new ColorRGBA(35.0f, 32.0f, 50.0f);
    private Function<IIIii_Class4, ColorRGBA> i_field_aad1658 = iIIii_Class4 -> IiiiiIIIi_Class242.ii_field_d0c8ec5;
    private Function<IIIii_Class4, ColorRGBA> II_field_aad1658 = iIIii_Class4 -> IiiiiIIIi_Class242.ii_field_d0c8ec5;
    private Function<IIIii_Class4, ColorRGBA> Ii_field_aad1658;
    private float Ii_field_46 = 2.5f;
    private float iI_field_46 = 4.0f;
    private float ii_field_46 = 1.2f;
    private final IiI_Class3 I_field_b575d2cc = new IiI_Class3(IIii_Class4.I_field_f93678c1);
    private boolean I_field_5a;

    public IIIii_Class4(Nested1_b342a3a0 nested1_b342a3a0, Nested1_b342a380 nested1_b342a380, float f, float f2) {
        this.I_field_f368ace7 = nested1_b342a3a0;
        this.I_field_f368a907 = nested1_b342a380;
        this.I_field_46 = f;
        this.i_field_46 = f2;
        this.I_method_95e87b75(120.0f, 10.0f);
        this.cursor(iIIIiIIIi_Class274.i_field_aa52e62c);
        this.onClick(this::I_method_bc6b1407);
    }

    public IIIii_Class4 I_method_ec139357(float f) {
        this.II_field_46 = f;
        return this;
    }

    public IIIii_Class4 I_method_d0f09cd6(ColorRGBA colorRGBA) {
        this.I_field_aad1658 = iIIii_Class4 -> colorRGBA;
        return this;
    }

    public IIIii_Class4 I_method_1f4f9269(Function<IIIii_Class4, ColorRGBA> function) {
        this.I_field_aad1658 = function;
        return this;
    }

    public IIIii_Class4 i_method_e7aa34f6(ColorRGBA colorRGBA) {
        this.i_field_aad1658 = iIIii_Class4 -> colorRGBA;
        return this;
    }

    public IIIii_Class4 i_method_49da3a89(Function<IIIii_Class4, ColorRGBA> function) {
        this.i_field_aad1658 = function;
        return this;
    }

    public IIIii_Class4 II_method_10143c33(ColorRGBA colorRGBA) {
        this.II_field_aad1658 = iIIii_Class4 -> colorRGBA;
        return this;
    }

    public IIIii_Class4 II_method_63b6846(Function<IIIii_Class4, ColorRGBA> function) {
        this.II_field_aad1658 = function;
        return this;
    }

    public IIIii_Class4 Ii_method_26cdd453(ColorRGBA colorRGBA) {
        this.Ii_field_aad1658 = iIIii_Class4 -> colorRGBA;
        return this;
    }

    public IIIii_Class4 Ii_method_30c61066(Function<IIIii_Class4, ColorRGBA> function) {
        this.Ii_field_aad1658 = function;
        return this;
    }

    public IIIii_Class4 i_method_1635ab77(float f) {
        this.Ii_field_46 = f;
        return this;
    }

    public IIIii_Class4 II_method_c1e3e6b4(float f) {
        this.iI_field_46 = f;
        return this;
    }

    public IIIii_Class4 Ii_method_ec05fed4(float f) {
        this.ii_field_46 = f;
        return this;
    }

    public IIIii_Class4 I_method_f6d86b76(IIii_Class4 iIii_Class4) {
        if (iIii_Class4 != null) {
            this.I_field_b575d2cc.I_method_15cf9df6(iIii_Class4);
        }
        return this;
    }

    public IIIii_Class4 iI_method_dc04d294(float f) {
        super.width(f);
        return this;
    }

    public IIIii_Class4 ii_method_626eab4(float f) {
        super.height(f);
        return this;
    }

    public IIIii_Class4 I_method_95e87b75(float f, float f2) {
        super.size(f, f2);
        return this;
    }

    public IIIii_Class4 I_method_d614f735() {
        super.fillWidth();
        return this;
    }

    public IIIii_Class4 i_method_113f5b15() {
        super.fillHeight();
        return this;
    }

    private void I_method_bc6b1407(IiIII_Class9 iiIII_Class9, float f, float f2) {
        if (iiIII_Class9 != IiIII_Class9.I_field_2f4c8d6c) {
            return;
        }
        this.I_field_5a = true;
        this.I_method_536894a1(f);
    }

    private void I_method_536894a1(float f) {
        float f2 = (f - this.x()) / Math.max(1.0f, this.w());
        f2 = Math.max(0.0f, Math.min(1.0f, f2));
        float f3 = this.I_field_46 + (this.i_field_46 - this.I_field_46) * f2;
        if (this.II_field_46 > 0.0f) {
            f3 = (float)Math.round(f3 / this.II_field_46) * this.II_field_46;
        }
        this.I_field_f368a907.accept(f3);
    }

    @Override
    public void mouseReleased(float f, float f2, IiIII_Class9 iiIII_Class9) {
        this.I_field_5a = false;
        super.mouseReleased(f, f2, iiIII_Class9);
    }

    @Override
    protected void onTick(float f, float f2, float f3) {
        this.I_field_b575d2cc.I_method_82de4e21(this.I_field_f368ace7.get());
        this.I_field_b575d2cc.Ii_method_dc72325e(f);
        if (this.I_field_5a && !this.pressed()) {
            this.I_field_5a = false;
        }
        if (this.I_field_5a) {
            this.I_method_536894a1(f2);
        }
    }

    @Override
    protected void drawSelf(III iII, float f) {
        float f2;
        float f3 = this.x();
        float f4 = this.y();
        float f5 = this.w();
        float f6 = this.h();
        float f7 = this.i_field_46 - this.I_field_46;
        float f8 = this.I_field_b575d2cc.I_method_4e8b496f();
        float f9 = f7 <= 0.0f ? 0.0f : (f8 - this.I_field_46) / f7;
        f9 = Math.max(0.0f, Math.min(1.0f, f9));
        float f10 = f5 * f9;
        float f11 = f4 + f6 / 2.0f - this.Ii_field_46 / 2.0f;
        float f12 = this.Ii_field_46 / 2.0f - 1.0f;
        ColorRGBA colorRGBA = this.I_field_aad1658.apply(this);
        ColorRGBA colorRGBA2 = this.i_field_aad1658.apply(this);
        ColorRGBA colorRGBA3 = this.II_field_aad1658.apply(this);
        ColorRGBA colorRGBA4 = this.Ii_field_aad1658 != null ? this.Ii_field_aad1658.apply(this) : colorRGBA;
        float f13 = 2.5f;
        float f14 = Math.max(0.0f, f10 - f13);
        float f15 = f3 + Math.min(f5, f10 + f13);
        float f16 = Math.max(0.0f, f3 + f5 - f15);
        if (f16 > 0.0f && colorRGBA != null && colorRGBA.getAlpha() > 0.0f) {
            iII.drawRoundedRect(f15, f11, f16, this.Ii_field_46, IIiii_Class8.Ii_method_4f498b98(f12, f12), colorRGBA);
        }
        if (f14 > 0.0f && colorRGBA2 != null && colorRGBA2.getAlpha() > 0.0f) {
            iII.drawRoundedRect(f3, f11, f14, this.Ii_field_46, IIiii_Class8.II_method_35289fb8(f12, f12), colorRGBA2);
        }
        float f17 = f3 + f10;
        float f18 = f4 + f6 / 2.0f;
        if (colorRGBA3 != null && colorRGBA3.getAlpha() > 0.0f) {
            iII.drawRoundedBorder(f17 - this.iI_field_46, f18 - this.iI_field_46, this.iI_field_46 * 2.0f, this.iI_field_46 * 2.0f, this.ii_field_46 / 2.0f, IIiii_Class8.I_method_893b2757(this.iI_field_46), colorRGBA3);
        }
        if ((f2 = this.iI_field_46 - this.ii_field_46) > 0.0f && colorRGBA4 != null && colorRGBA4.getAlpha() > 0.0f) {
            iII.drawRoundedRect(f17 - f2, f18 - f2, f2 * 2.0f, f2 * 2.0f, IIiii_Class8.I_method_893b2757(f2), colorRGBA4);
        }
    }

    public static interface Nested1_b342a3a0 {
        public float get();
    }

    public static interface Nested1_b342a380 {
        public void accept(float var1);
    }
}

