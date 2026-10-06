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

public class IIIiI_Class3
extends iiI_Class7 {
    private final Nested1_b3422b80 I_field_f35a2107;
    private final Nested1_b3422b80 i_field_f35a2107;
    private final Nested1_b3422b60 I_field_f35a1d27;
    private final Nested1_b3422b60 i_field_f35a1d27;
    private final float I_field_46;
    private final float i_field_46;
    private float II_field_46;
    private Function<IIIiI_Class3, ColorRGBA> I_field_aad1658 = iIIiI_Class3 -> new ColorRGBA(35.0f, 32.0f, 50.0f);
    private Function<IIIiI_Class3, ColorRGBA> i_field_aad1658 = iIIiI_Class3 -> IiiiiIIIi_Class242.ii_field_d0c8ec5;
    private float Ii_field_46 = 2.5f;
    private float iI_field_46 = 4.0f;
    private float ii_field_46 = 1.2f;
    private final IiI_Class3 I_field_b575d2cc = new IiI_Class3(IIii_Class4.I_field_f93678c1);
    private final IiI_Class3 i_field_b575d2cc = new IiI_Class3(IIii_Class4.I_field_f93678c1);
    private int I_field_49;

    public IIIiI_Class3(Nested1_b3422b80 nested1_b3422b80, Nested1_b3422b60 nested1_b3422b60, Nested1_b3422b80 nested1_b3422b802, Nested1_b3422b60 nested1_b3422b602, float f, float f2) {
        this.I_field_f35a2107 = nested1_b3422b80;
        this.I_field_f35a1d27 = nested1_b3422b60;
        this.i_field_f35a2107 = nested1_b3422b802;
        this.i_field_f35a1d27 = nested1_b3422b602;
        this.I_field_46 = f;
        this.i_field_46 = f2;
        this.I_method_805303b5(120.0f, 10.0f);
        this.cursor(iIIIiIIIi_Class274.i_field_aa52e62c);
        this.onClick(this::I_method_1f520be7);
    }

    public IIIiI_Class3 I_method_c216ff57(float f) {
        this.II_field_46 = f;
        return this;
    }

    public IIIiI_Class3 I_method_823c88d6(ColorRGBA colorRGBA) {
        this.I_field_aad1658 = iIIiI_Class3 -> colorRGBA;
        return this;
    }

    public IIIiI_Class3 I_method_6cce6e69(Function<IIIiI_Class3, ColorRGBA> function) {
        this.I_field_aad1658 = function;
        return this;
    }

    public IIIiI_Class3 i_method_98f620f6(ColorRGBA colorRGBA) {
        this.i_field_aad1658 = iIIiI_Class3 -> colorRGBA;
        return this;
    }

    public IIIiI_Class3 i_method_97591689(Function<IIIiI_Class3, ColorRGBA> function) {
        this.i_field_aad1658 = function;
        return this;
    }

    public IIIiI_Class3 i_method_ec391777(float f) {
        this.Ii_field_46 = f;
        return this;
    }

    public IIIiI_Class3 II_method_ac4e6ef4(float f) {
        this.iI_field_46 = f;
        return this;
    }

    public IIIiI_Class3 Ii_method_d6708714(float f) {
        this.ii_field_46 = f;
        return this;
    }

    public IIIiI_Class3 I_method_c1a3a3b6(IIii_Class4 iIii_Class4) {
        if (iIii_Class4 != null) {
            this.I_field_b575d2cc.I_method_15cf9df6(iIii_Class4);
            this.i_field_b575d2cc.I_method_15cf9df6(iIii_Class4);
        }
        return this;
    }

    public IIIiI_Class3 iI_method_c66f5ad4(float f) {
        super.width(f);
        return this;
    }

    public IIIiI_Class3 ii_method_f09172f4(float f) {
        super.height(f);
        return this;
    }

    public IIIiI_Class3 I_method_805303b5(float f, float f2) {
        super.size(f, f2);
        return this;
    }

    public IIIiI_Class3 I_method_bbf40775() {
        super.fillWidth();
        return this;
    }

    public IIIiI_Class3 i_method_f71e6b55() {
        super.fillHeight();
        return this;
    }

    private void I_method_1f520be7(IiIII_Class9 iiIII_Class9, float f, float f2) {
        float f3;
        if (iiIII_Class9 != IiIII_Class9.I_field_2f4c8d6c) {
            return;
        }
        float f4 = this.I_method_b6a12c71(this.I_field_f35a2107.get());
        float f5 = this.I_method_b6a12c71(this.i_field_f35a2107.get());
        float f6 = Math.abs(f - f4);
        this.I_field_49 = f6 < (f3 = Math.abs(f - f5)) ? 1 : (f3 < f6 ? 2 : (f >= f4 ? 2 : 1));
        this.I_method_b6a12c81(f);
    }

    private float I_method_b6a12c71(float f) {
        float f2 = this.i_field_46 - this.I_field_46;
        return this.x() + this.w() * IIIiI_Class3.i_method_b8641c91(f2 <= 0.0f ? 0.0f : (f - this.I_field_46) / f2);
    }

    private void I_method_b6a12c81(float f) {
        float f2 = IIIiI_Class3.i_method_b8641c91((f - this.x()) / Math.max(1.0f, this.w()));
        float f3 = this.I_field_46 + (this.i_field_46 - this.I_field_46) * f2;
        if (this.II_field_46 > 0.0f) {
            f3 = (float)Math.round(f3 / this.II_field_46) * this.II_field_46;
        }
        if (this.I_field_49 == 1) {
            this.I_field_f35a1d27.accept(Math.min(f3, this.i_field_f35a2107.get()));
        } else if (this.I_field_49 == 2) {
            this.i_field_f35a1d27.accept(Math.max(f3, this.I_field_f35a2107.get()));
        }
    }

    @Override
    public void mouseReleased(float f, float f2, IiIII_Class9 iiIII_Class9) {
        this.I_field_49 = 0;
        super.mouseReleased(f, f2, iiIII_Class9);
    }

    @Override
    protected void onTick(float f, float f2, float f3) {
        this.I_field_b575d2cc.I_method_82de4e21(this.I_field_f35a2107.get());
        this.i_field_b575d2cc.I_method_82de4e21(this.i_field_f35a2107.get());
        this.I_field_b575d2cc.Ii_method_dc72325e(f);
        this.i_field_b575d2cc.Ii_method_dc72325e(f);
        if (this.I_field_49 != 0 && !this.pressed()) {
            this.I_field_49 = 0;
        }
        if (this.I_field_49 != 0) {
            this.I_method_b6a12c81(f2);
        }
    }

    private static float i_method_b8641c91(float f) {
        return f < 0.0f ? 0.0f : (f > 1.0f ? 1.0f : f);
    }

    @Override
    protected void drawSelf(III iII, float f) {
        float f2;
        float f3 = this.x();
        float f4 = this.y();
        float f5 = this.w();
        float f6 = this.h();
        float f7 = this.i_field_46 - this.I_field_46;
        float f8 = IIIiI_Class3.i_method_b8641c91(f7 <= 0.0f ? 0.0f : (this.I_field_b575d2cc.I_method_4e8b496f() - this.I_field_46) / f7);
        float f9 = IIIiI_Class3.i_method_b8641c91(f7 <= 0.0f ? 0.0f : (this.i_field_b575d2cc.I_method_4e8b496f() - this.I_field_46) / f7);
        float f10 = f3 + f5 * Math.min(f8, f9);
        float f11 = f3 + f5 * Math.max(f8, f9);
        float f12 = f4 + f6 / 2.0f - this.Ii_field_46 / 2.0f;
        float f13 = this.Ii_field_46 / 2.0f;
        ColorRGBA colorRGBA = this.I_field_aad1658.apply(this);
        ColorRGBA colorRGBA2 = this.i_field_aad1658.apply(this);
        if (colorRGBA != null && colorRGBA.getAlpha() > 0.0f) {
            iII.drawRoundedRect(f3, f12, f5, this.Ii_field_46, IIiii_Class8.I_method_893b2757(f13), colorRGBA);
        }
        if ((f2 = Math.max(0.0f, f11 - f10 - 5.0f)) > 0.0f && colorRGBA2 != null && colorRGBA2.getAlpha() > 0.0f) {
            iII.drawRect(f10 + 2.5f, f12, f2, this.Ii_field_46, colorRGBA2);
        }
        float f14 = f4 + f6 / 2.0f;
        this.I_method_53d7c2c7(iII, f3 + f5 * f8, f14, colorRGBA2, colorRGBA);
        this.I_method_53d7c2c7(iII, f3 + f5 * f9, f14, colorRGBA2, colorRGBA);
    }

    private void I_method_53d7c2c7(III iII, float f, float f2, ColorRGBA colorRGBA, ColorRGBA colorRGBA2) {
        float f3;
        if (colorRGBA != null && colorRGBA.getAlpha() > 0.0f) {
            iII.drawRoundedBorder(f - this.iI_field_46, f2 - this.iI_field_46, this.iI_field_46 * 2.0f, this.iI_field_46 * 2.0f, this.ii_field_46 / 2.0f, IIiii_Class8.I_method_893b2757(this.iI_field_46), colorRGBA);
        }
        if ((f3 = this.iI_field_46 - this.ii_field_46) > 0.0f && colorRGBA2 != null && colorRGBA2.getAlpha() > 0.0f) {
            iII.drawRoundedRect(f - f3, f2 - f3, f3 * 2.0f, f3 * 2.0f, IIiii_Class8.I_method_893b2757(f3), colorRGBA2);
        }
    }

    public static interface Nested1_b3422b80 {
        public float get();
    }

    public static interface Nested1_b3422b60 {
        public void accept(float var1);
    }
}

