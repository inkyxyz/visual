package rockstar.client;

import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIii_Class4;
import rockstar.client.IiI_Class3;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.iiI_Class7;

public class Iiii_Class8
extends iiI_Class7 {
    private final IIiIIi_Class10 I_field_856d0221;
    private final IntSupplier I_field_ba7cd5ab;
    private float I_field_46 = 5.0f;
    private boolean I_field_5a;
    private Function<Iiii_Class8, ColorRGBA> I_field_aad1658 = iiii_Class8 -> ColorRGBA.WHITE;
    private final String[] I_field_6dccaaa5 = new String[]{"", ""};
    private final String[] i_field_6dccaaa5 = new String[]{"", ""};
    private final IiI_Class3[] I_field_86ff2951 = new IiI_Class3[]{new IiI_Class3(1.0f, IIii_Class4.I_method_3682ece9(500L, IiiiIiiII_Class237.I_field_dd60aac)), new IiI_Class3(1.0f, IIii_Class4.I_method_3682ece9(500L, IiiiIiiII_Class237.I_field_dd60aac))};
    private int I_field_49 = Integer.MIN_VALUE;

    public Iiii_Class8(IIiIIi_Class10 iIiIIi_Class10, IntSupplier intSupplier) {
        this.I_field_856d0221 = iIiIIi_Class10;
        this.I_field_ba7cd5ab = intSupplier;
        this.II_method_4dfd2aac(iIiIIi_Class10.I_method_a649725c());
    }

    public Iiii_Class8 I_method_6e260263(float f) {
        this.I_field_46 = f;
        return this;
    }

    public Iiii_Class8 I_method_124306cb() {
        this.I_field_5a = true;
        return this;
    }

    public Iiii_Class8 I_method_1e452bcf(boolean bl) {
        this.I_field_5a = bl;
        return this;
    }

    public Iiii_Class8 I_method_3eea5904(ColorRGBA colorRGBA) {
        this.I_field_aad1658 = iiii_Class8 -> colorRGBA;
        return this;
    }

    public Iiii_Class8 I_method_ab0d6d85(Supplier<ColorRGBA> supplier) {
        this.I_field_aad1658 = iiii_Class8 -> (ColorRGBA)supplier.get();
        return this;
    }

    public Iiii_Class8 I_method_2e768391(Function<Iiii_Class8, ColorRGBA> function) {
        this.I_field_aad1658 = function;
        return this;
    }

    public Iiii_Class8 I_method_8f7a4e2a(IIii_Class4 iIii_Class4) {
        if (iIii_Class4 != null) {
            this.I_field_86ff2951[0].I_method_15cf9df6(iIii_Class4);
            this.I_field_86ff2951[1].I_method_15cf9df6(iIii_Class4);
        }
        return this;
    }

    public Iiii_Class8 i_method_a9506643(float f) {
        super.width(f);
        return this;
    }

    public Iiii_Class8 II_method_4dfd2aac(float f) {
        super.height(f);
        return this;
    }

    public Iiii_Class8 I_method_8ea279cb(float f, float f2) {
        super.size(f, f2);
        return this;
    }

    public Iiii_Class8 i_method_984ca6eb() {
        super.fillWidth();
        return this;
    }

    public Iiii_Class8 II_method_f0313162() {
        super.fillHeight();
        return this;
    }

    private void I_method_82e5b7ec() {
        int n = this.I_field_ba7cd5ab.getAsInt();
        if (n == this.I_field_49) {
            return;
        }
        this.I_field_49 = n;
        int n2 = Math.max(0, Math.min(99, n));
        String string = String.valueOf(n2 / 10);
        String string2 = this.I_field_5a ? string : (string.equals("0") ? "" : string);
        String string3 = String.valueOf(n2 % 10);
        if (!string2.equals(this.i_field_6dccaaa5[0])) {
            this.I_field_6dccaaa5[0] = this.i_field_6dccaaa5[0];
            this.i_field_6dccaaa5[0] = string2;
            this.I_field_86ff2951[0].i_method_84a13e41(0.0f);
            this.I_field_86ff2951[0].I_method_82de4e21(1.0f);
        }
        if (!string3.equals(this.i_field_6dccaaa5[1])) {
            this.I_field_6dccaaa5[1] = this.i_field_6dccaaa5[1];
            this.i_field_6dccaaa5[1] = string3;
            this.I_field_86ff2951[1].i_method_84a13e41(0.0f);
            this.I_field_86ff2951[1].I_method_82de4e21(1.0f);
        }
    }

    @Override
    protected void measure() {
        this.I_method_82e5b7ec();
        if (!this.explicitW) {
            this.prefW = this.I_field_856d0221.I_method_2c375926(this.i_field_6dccaaa5[0] + this.i_field_6dccaaa5[1]);
        }
        if (!this.explicitH) {
            this.prefH = this.I_field_856d0221.I_method_a649725c();
        }
    }

    @Override
    protected void onTick(float f, float f2, float f3) {
        this.I_method_82e5b7ec();
        this.I_field_86ff2951[0].Ii_method_dc72325e(f);
        this.I_field_86ff2951[1].Ii_method_dc72325e(f);
    }

    @Override
    protected void drawSelf(III iII, float f) {
        ColorRGBA colorRGBA = this.I_field_aad1658.apply(this);
        if (colorRGBA == null) {
            return;
        }
        float f2 = this.x();
        float f3 = this.y();
        float f4 = f3 + this.h() / 2.0f - this.I_field_856d0221.I_method_a649725c() / 2.0f;
        float f5 = this.I_field_86ff2951[0].I_method_4e8b496f();
        float f6 = this.I_field_86ff2951[1].I_method_4e8b496f();
        float f7 = this.I_field_856d0221.I_method_2c375926(this.i_field_6dccaaa5[0]);
        float f8 = this.I_field_856d0221.I_method_2c375926(this.I_field_6dccaaa5[0]);
        this.I_method_2fc90d4f(iII, this.I_field_6dccaaa5[0], f2, f4, colorRGBA, f5, true);
        this.I_method_2fc90d4f(iII, this.i_field_6dccaaa5[0], f2, f4, colorRGBA, f5, false);
        this.I_method_2fc90d4f(iII, this.I_field_6dccaaa5[1], f2 + f8, f4, colorRGBA, f6, true);
        this.I_method_2fc90d4f(iII, this.i_field_6dccaaa5[1], f2 + f7, f4, colorRGBA, f6, false);
    }

    private void I_method_2fc90d4f(III iII, String string, float f, float f2, ColorRGBA colorRGBA, float f3, boolean bl) {
        float f4;
        if (string == null || string.isEmpty()) {
            return;
        }
        float f5 = f4 = bl ? 1.0f - f3 : f3;
        if (f4 <= 0.001f) {
            return;
        }
        float f6 = bl ? this.I_field_46 * f3 : -this.I_field_46 + this.I_field_46 * f3;
        iII.drawText(this.I_field_856d0221, string, f, f2 + f6, colorRGBA.withAlpha(colorRGBA.getAlpha() * f4));
    }

}

