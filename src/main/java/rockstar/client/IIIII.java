package rockstar.client;

import java.util.function.Function;
import java.util.function.Supplier;
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
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iIiiiIiII_Class373;
import rockstar.client.iiI_Class7;

public class IIIII
extends iiI_Class7 {
    private final Nested1_b3339f80 I_field_f1972d07;
    private final Nested1_b3339f80 i_field_f1972d07;
    private final Nested1_b3339fa0 I_field_f19730e7;
    private final float I_field_46;
    private final float i_field_46;
    private final float II_field_46;
    private final float Ii_field_46;
    private final IiI_Class3 I_field_b575d2cc = new IiI_Class3(IIii_Class4.I_method_3682ece9(400L, IiiiIiiII_Class237.II_field_dd60aac));
    private final IiI_Class3 i_field_b575d2cc = new IiI_Class3(IIii_Class4.I_method_3682ece9(400L, IiiiIiiII_Class237.II_field_dd60aac));
    private boolean I_field_5a;
    private Function<IIIII, ColorRGBA> I_field_aad1658 = iIIII -> IiiiiIIIi_Class242.IIi_field_d0c8ec5;
    private Function<IIIII, ColorRGBA> i_field_aad1658 = iIIII -> IiiiiIIIi_Class242.IiI_field_d0c8ec5;
    private Function<IIIII, ColorRGBA> II_field_aad1658 = iIIII -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.05f + 0.03f * iIIII.hover());
    private Function<IIIII, ColorRGBA> Ii_field_aad1658 = iIIII -> IiiiiIIIi_Class242.ii_field_d0c8ec5.mulAlpha(0.85f + 0.15f * iIIII.hover());
    private float iI_field_46 = 3.0f;
    private int I_field_49 = 10;
    private float ii_field_46 = 3.0f;
    private float III_field_46 = 1.5f;
    private Supplier<String> I_field_11b14ee4;
    private IIiIIi_Class10 I_field_856d0221;
    private Function<IIIII, ColorRGBA> iI_field_aad1658 = iIIII -> IiiiiIIIi_Class242.ii_field_d0c8ec5;

    public IIIII(Nested1_b3339f80 nested1_b3339f80, Nested1_b3339f80 nested1_b3339f802, Nested1_b3339fa0 nested1_b3339fa0, float f, float f2, float f3, float f4) {
        this.I_field_f1972d07 = nested1_b3339f80;
        this.i_field_f1972d07 = nested1_b3339f802;
        this.I_field_f19730e7 = nested1_b3339fa0;
        this.I_field_46 = f;
        this.i_field_46 = f2;
        this.II_field_46 = f3;
        this.Ii_field_46 = f4;
        this.I_field_b575d2cc.i_method_84a13e41(nested1_b3339f80.get());
        this.i_field_b575d2cc.i_method_84a13e41(nested1_b3339f802.get());
        this.snapSize();
        this.cursor(iIIIiIIIi_Class274.ii_field_aa52e62c);
        this.onClick(this::I_method_194a1007);
    }

    public IIIII I_method_fa6e1cd6(ColorRGBA colorRGBA) {
        this.I_field_aad1658 = iIIII -> colorRGBA;
        return this;
    }

    public IIIII I_method_cf2b1269(Function<IIIII, ColorRGBA> function) {
        this.I_field_aad1658 = function;
        return this;
    }

    public IIIII i_method_1127b4f6(ColorRGBA colorRGBA) {
        this.i_field_aad1658 = iIIII -> colorRGBA;
        return this;
    }

    public IIIII i_method_f9b5ba89(Function<IIIII, ColorRGBA> function) {
        this.i_field_aad1658 = function;
        return this;
    }

    public IIIII II_method_16554433(ColorRGBA colorRGBA) {
        this.II_field_aad1658 = iIIII -> colorRGBA;
        return this;
    }

    public IIIII II_method_51de7046(Function<IIIII, ColorRGBA> function) {
        this.II_field_aad1658 = function;
        return this;
    }

    public IIIII Ii_method_2d0edc53(ColorRGBA colorRGBA) {
        this.Ii_field_aad1658 = iIIII -> colorRGBA;
        return this;
    }

    public IIIII Ii_method_7c691866(Function<IIIII, ColorRGBA> function) {
        this.Ii_field_aad1658 = function;
        return this;
    }

    public IIIII I_method_ac811357(float f) {
        this.iI_field_46 = f;
        return this;
    }

    public IIIII I_method_3911fa5a(int n) {
        this.I_field_49 = Math.max(1, n);
        return this;
    }

    public IIIII i_method_d6a32b77(float f) {
        this.ii_field_46 = f;
        return this;
    }

    public IIIII II_method_f34eeb4(float f) {
        this.III_field_46 = f;
        return this;
    }

    public IIIII I_method_76d22d74(IIiIIi_Class10 iIiIIi_Class10, Supplier<String> supplier) {
        this.I_field_856d0221 = iIiIIi_Class10;
        this.I_field_11b14ee4 = supplier;
        return this;
    }

    public IIIII iI_method_d6ceb013(ColorRGBA colorRGBA) {
        this.iI_field_aad1658 = iIIII -> colorRGBA;
        return this;
    }

    public IIIII iI_method_78a8cc26(Function<IIIII, ColorRGBA> function) {
        this.iI_field_aad1658 = function;
        return this;
    }

    public IIIII I_method_503f7376(IIii_Class4 iIii_Class4) {
        if (iIii_Class4 != null) {
            this.I_field_b575d2cc.I_method_15cf9df6(iIii_Class4);
            this.i_field_b575d2cc.I_method_15cf9df6(iIii_Class4);
        }
        return this;
    }

    public IIIII Ii_method_395706d4(float f) {
        super.width(f);
        return this;
    }

    public IIIII iI_method_2955da94(float f) {
        super.height(f);
        return this;
    }

    public IIIII I_method_e3398375(float f, float f2) {
        super.size(f, f2);
        return this;
    }

    public IIIII I_method_91f6ff35() {
        super.fillWidth();
        return this;
    }

    public IIIII i_method_cd216315() {
        super.fillHeight();
        return this;
    }

    private void I_method_194a1007(IiIII_Class9 iiIII_Class9, float f, float f2) {
        if (iiIII_Class9 != IiIII_Class9.I_field_2f4c8d6c) {
            return;
        }
        this.I_field_5a = true;
        this.I_method_94f6eb3f(f, f2);
    }

    private void I_method_94f6eb3f(float f, float f2) {
        float f3 = IIIII.I_method_ba7b9091((f - this.x()) / Math.max(1.0f, this.w()));
        float f4 = IIIII.I_method_ba7b9091((f2 - this.y()) / Math.max(1.0f, this.h()));
        this.I_field_f19730e7.accept(this.I_field_46 + (this.i_field_46 - this.I_field_46) * f3, this.II_field_46 + (this.Ii_field_46 - this.II_field_46) * f4);
    }

    @Override
    public void mouseReleased(float f, float f2, IiIII_Class9 iiIII_Class9) {
        this.I_field_5a = false;
        super.mouseReleased(f, f2, iiIII_Class9);
    }

    @Override
    protected void measure() {
        if (!this.explicitH) {
            this.prefH = this.w();
        }
    }

    @Override
    protected void onTick(float f, float f2, float f3) {
        this.I_field_b575d2cc.I_method_82de4e21(this.I_field_f1972d07.get());
        this.I_field_b575d2cc.Ii_method_dc72325e(f);
        this.i_field_b575d2cc.I_method_82de4e21(this.i_field_f1972d07.get());
        this.i_field_b575d2cc.Ii_method_dc72325e(f);
        if (this.I_field_5a) {
            this.I_method_94f6eb3f(f2, f3);
        }
    }

    @Override
    protected void drawSelf(III iII, float f) {
        Object object;
        float f2;
        float f3 = this.x();
        float f4 = this.y();
        float f5 = this.w();
        float f6 = this.h();
        IIiii_Class8 iIiii_Class8 = IIiii_Class8.I_method_893b2757(this.iI_field_46);
        ColorRGBA colorRGBA = this.I_field_aad1658.apply(this);
        if (colorRGBA != null && colorRGBA.getAlpha() > 0.0f) {
            iII.drawRoundedRect(f3, f4, f5, f6, iIiii_Class8, colorRGBA);
        }
        MatrixStack matrixStack = iII.getMatrices();
        iIiiiIiII_Class373.I_method_d5a5ee51(matrixStack, f3, f4, f5, f6);
        ColorRGBA colorRGBA2 = this.II_field_aad1658.apply(this);
        if (colorRGBA2 != null && colorRGBA2.getAlpha() > 0.0f) {
            for (int i = 1; i < this.I_field_49; ++i) {
                f2 = (float)i / (float)this.I_field_49;
                iII.drawRect(f3 + f5 * f2, f4, 1.0f, f6, colorRGBA2);
                iII.drawRect(f3, f4 + f6 * f2, f5, 1.0f, colorRGBA2);
            }
        }
        float f7 = IIIII.I_method_ba7b9091(IIIII.I_method_9e6e451(this.I_field_b575d2cc.I_method_4e8b496f(), this.I_field_46, this.i_field_46));
        f2 = IIIII.I_method_ba7b9091(IIIII.I_method_9e6e451(this.i_field_b575d2cc.I_method_4e8b496f(), this.II_field_46, this.Ii_field_46));
        float f8 = f3 + f5 * f7;
        float f9 = f4 + f6 * f2;
        ColorRGBA colorRGBA3 = this.Ii_field_aad1658.apply(this);
        float f10 = this.ii_field_46;
        IIIII.I_method_7e17b058(iII, f8 - 0.5f, f4, 1.0f, f9 - f10 - f4, colorRGBA3);
        IIIII.I_method_7e17b058(iII, f8 - 0.5f, f9 + f10, 1.0f, f4 + f6 - (f9 + f10), colorRGBA3);
        IIIII.I_method_7e17b058(iII, f3, f9 - 0.5f, f8 - f10 - f3, 1.0f, colorRGBA3);
        IIIII.I_method_7e17b058(iII, f8 + f10, f9 - 0.5f, f3 + f5 - (f8 + f10), 1.0f, colorRGBA3);
        iII.drawRoundedBorder(f8 - this.ii_field_46, f9 - this.ii_field_46, this.ii_field_46 * 2.0f, this.ii_field_46 * 2.0f, this.III_field_46 / 2.0f, IIiii_Class8.I_method_893b2757(this.ii_field_46), colorRGBA3);
        if (this.I_field_11b14ee4 != null && this.I_field_856d0221 != null && (object = this.I_field_11b14ee4.get()) != null && !((String)object).isEmpty()) {
            float f11 = 3.0f;
            float f12 = this.I_field_856d0221.I_method_2c375926((String)object) + f11 * 2.0f;
            float f13 = this.I_field_856d0221.I_method_a649725c() + f11 * 1.4f;
            float f14 = f3 + f5 - f12 - 2.0f;
            float f15 = f4 + 2.0f;
            iII.drawRoundedRect(f14, f15, f12, f13, IIiii_Class8.I_method_893b2757(2.5f), IiiiiIIIi_Class242.III_field_d0c8ec5.mulAlpha(0.65f));
            iII.drawText(this.I_field_856d0221, (String)object, f14 + f11, f15 + f13 / 2.0f - this.I_field_856d0221.I_method_a649725c() / 2.0f, this.iI_field_aad1658.apply(this));
        }
        iIiiiIiII_Class373.I_method_ff80a1df();
        object = this.i_field_aad1658.apply(this);
        if (object != null && ((ColorRGBA)object).getAlpha() > 0.0f) {
            iII.drawRoundedBorder(f3, f4, f5, f6, 0.5f, iIiii_Class8, (ColorRGBA)object);
        }
    }

    private static void I_method_7e17b058(III iII, float f, float f2, float f3, float f4, ColorRGBA colorRGBA) {
        if (f3 > 0.0f && f4 > 0.0f) {
            iII.drawRect(f, f2, f3, f4, colorRGBA);
        }
    }

    private static float I_method_9e6e451(float f, float f2, float f3) {
        return f3 - f2 == 0.0f ? 0.0f : (f - f2) / (f3 - f2);
    }

    private static float I_method_ba7b9091(float f) {
        return f < 0.0f ? 0.0f : (f > 1.0f ? 1.0f : f);
    }

    public static interface Nested1_b3339f80 {
        public float get();
    }

    public static interface Nested1_b3339fa0 {
        public void accept(float var1, float var2);
    }
}

