package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import net.minecraft.client.util.math.MatrixStack;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIii_Class4;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiI_Class3;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iIiiiIiII_Class373;
import rockstar.client.iiI_Class7;

public class IIiIi_Class6
extends iiI_Class7 {
    static final IIii_Class4 I_field_f93678c1 = IIii_Class4.I_method_3682ece9(420L, IiiiIiiII_Class237.II_field_dd60aac);
    private static final float I_field_46 = 170.0f;
    private static final float i_field_46 = 14.0f;
    private final List<Nested1_b4f707c0> I_field_7865b31 = new ArrayList<Nested1_b4f707c0>();
    private IIiIIi_Class10 I_field_856d0221 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(9.0f);
    private IIiIIi_Class10 i_field_856d0221 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.5f);
    float II_field_46 = 12.5f;
    private int I_field_49 = 5;
    private float Ii_field_46 = 22.0f;
    private float iI_field_46 = 2.0f;
    private boolean I_field_5a;
    private Function<IIiIi_Class6, ColorRGBA> I_field_aad1658 = iIiIi_Class6 -> IiiiiIIIi_Class242.IIi_field_d0c8ec5.mulAlpha(0.75f + 0.25f * iIiIi_Class6.hover());
    private Function<IIiIi_Class6, ColorRGBA> i_field_aad1658 = iIiIi_Class6 -> IiiiiIIIi_Class242.iII_field_d0c8ec5;
    private Function<IIiIi_Class6, ColorRGBA> II_field_aad1658 = iIiIi_Class6 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.38f + 0.12f * iIiIi_Class6.hover());
    private Function<IIiIi_Class6, ColorRGBA> Ii_field_aad1658 = iIiIi_Class6 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.7f);

    public IIiIi_Class6() {
        this.cursor(iIIIiIIIi_Class274.i_field_aa52e62c);
        this.snapSize();
    }

    public IIiIi_Class6 I_method_cab8a7d6(IIiIIi_Class10 iIiIIi_Class10) {
        if (iIiIIi_Class10 != null) {
            this.I_field_856d0221 = iIiIIi_Class10;
        }
        return this;
    }

    public IIiIi_Class6 i_method_ffed6bb6(IIiIIi_Class10 iIiIIi_Class10) {
        if (iIiIIi_Class10 != null) {
            this.i_field_856d0221 = iIiIIi_Class10;
        }
        return this;
    }

    public IIiIi_Class6 I_method_73a53b57(float f) {
        this.II_field_46 = Math.max(4.0f, f);
        return this;
    }

    public IIiIi_Class6 I_method_36225a(int n) {
        this.I_field_49 = Math.max(3, n);
        return this;
    }

    public IIiIi_Class6 i_method_9dc75377(float f) {
        this.Ii_field_46 = Math.max(4.0f, Math.min(35.0f, f));
        return this;
    }

    public IIiIi_Class6 II_method_2ae0ee34(float f) {
        this.iI_field_46 = f;
        return this;
    }

    public IIiIi_Class6 I_method_c1bbeeb5() {
        this.I_field_5a = true;
        return this;
    }

    public IIiIi_Class6 I_method_c76b3f6b(boolean bl) {
        this.I_field_5a = bl;
        return this;
    }

    public IIiIi_Class6 I_method_bb2144d6(ColorRGBA colorRGBA) {
        this.I_field_aad1658 = iIiIi_Class6 -> colorRGBA;
        return this;
    }

    public IIiIi_Class6 I_method_98745a69(Function<IIiIi_Class6, ColorRGBA> function) {
        this.I_field_aad1658 = function;
        return this;
    }

    public IIiIi_Class6 i_method_d1dadcf6(ColorRGBA colorRGBA) {
        this.i_field_aad1658 = iIiIi_Class6 -> colorRGBA;
        return this;
    }

    public IIiIi_Class6 i_method_c2ff0289(Function<IIiIi_Class6, ColorRGBA> function) {
        this.i_field_aad1658 = function;
        return this;
    }

    public IIiIi_Class6 II_method_6a5243b3(ColorRGBA colorRGBA) {
        this.II_field_aad1658 = iIiIi_Class6 -> colorRGBA;
        return this;
    }

    public IIiIi_Class6 II_method_b0094fc6(Function<IIiIi_Class6, ColorRGBA> function) {
        this.II_field_aad1658 = function;
        return this;
    }

    public IIiIi_Class6 Ii_method_810bdbd3(ColorRGBA colorRGBA) {
        this.Ii_field_aad1658 = iIiIi_Class6 -> colorRGBA;
        return this;
    }

    public IIiIi_Class6 Ii_method_da93f7e6(Function<IIiIi_Class6, ColorRGBA> function) {
        this.Ii_field_aad1658 = function;
        return this;
    }

    public IIiIi_Class6 Ii_method_55030654(float f) {
        super.width(f);
        return this;
    }

    public IIiIi_Class6 iI_method_4501da14(float f) {
        super.height(f);
        return this;
    }

    public IIiIi_Class6 I_method_fee582f5(float f, float f2) {
        super.size(f, f2);
        return this;
    }

    public IIiIi_Class6 i_method_fce65295() {
        super.fillWidth();
        return this;
    }

    public IIiIi_Class6 II_method_32ffec38() {
        super.fillHeight();
        return this;
    }

    public IIiIi_Class6 I_method_b95e284(int n, IntSupplier intSupplier, IntConsumer intConsumer, Supplier<String> supplier) {
        if (n > 0) {
            this.I_field_7865b31.add(new Nested1_b4f707c0(n, intSupplier, intConsumer, supplier));
        }
        return this;
    }

    public IIiIi_Class6 Ii_method_6e2a5018() {
        this.I_field_7865b31.clear();
        return this;
    }

    public int I_method_17bc66b2() {
        return this.I_field_7865b31.size();
    }

    @Override
    protected void measure() {
        if (!this.explicitH) {
            this.prefH = this.II_field_46 * (float)this.I_field_49;
        }
    }

    @Override
    protected void onTick(float f, float f2, float f3) {
        for (Nested1_b4f707c0 nested1_b4f707c0 : this.I_field_7865b31) {
            nested1_b4f707c0.I_method_2889b57a(f, f3);
        }
    }

    @Override
    public boolean mouseClicked(float f, float f2, IiIII_Class9 iiIII_Class9) {
        if (!(this.interactive && this.inFlow() && this.contains(f, f2))) {
            return false;
        }
        if (iiIII_Class9 != IiIII_Class9.I_field_2f4c8d6c) {
            return true;
        }
        Nested1_b4f707c0 nested1_b4f707c0 = this.I_method_1f437452(f);
        if (nested1_b4f707c0 != null) {
            nested1_b4f707c0.I_method_2a991306(f2);
        }
        return true;
    }

    @Override
    public void mouseReleased(float f, float f2, IiIII_Class9 iiIII_Class9) {
        for (Nested1_b4f707c0 nested1_b4f707c0 : this.I_field_7865b31) {
            if (!nested1_b4f707c0.I_field_5a) continue;
            nested1_b4f707c0.i_method_2c5c0326(nested1_b4f707c0.i_field_5a ? 0.0f : this.I_method_dfd0d8d1(f2));
        }
        super.mouseReleased(f, f2, iiIII_Class9);
    }

    @Override
    public boolean mouseScrolled(float f, float f2, float f3, float f4) {
        if (!(this.interactive && this.inFlow() && this.contains(f, f2) && f4 != 0.0f)) {
            return false;
        }
        Nested1_b4f707c0 nested1_b4f707c0 = this.I_method_1f437452(f);
        if (nested1_b4f707c0 == null) {
            return false;
        }
        nested1_b4f707c0.I_method_2a991e49(f4 > 0.0f ? -1 : 1);
        return true;
    }

    private Nested1_b4f707c0 I_method_1f437452(float f) {
        if (this.I_field_7865b31.isEmpty() || this.w() <= 0.0f) {
            return null;
        }
        float f2 = this.w() / (float)this.I_field_7865b31.size();
        int n = (int)((f - this.x()) / f2);
        return this.I_field_7865b31.get(Math.max(0, Math.min(this.I_field_7865b31.size() - 1, n)));
    }

    private float I_method_dfd0d8d1(float f) {
        float f2 = (f - (this.y() + this.h() / 2.0f)) / this.I_method_17bc66af();
        f2 = Math.max(-0.999f, Math.min(0.999f, f2));
        return (float)(Math.asin(f2) / Math.toRadians(this.Ii_field_46));
    }

    private float I_method_17bc66af() {
        return this.II_field_46 / (float)Math.sin(Math.toRadians(this.Ii_field_46));
    }

    @Override
    protected void drawSelf(III iII, float f) {
        if (this.I_field_7865b31.isEmpty() || this.w() <= 0.0f || this.h() <= 0.0f) {
            return;
        }
        float f2 = this.II_field_46 * 1.5f;
        float f3 = this.y() + this.h() / 2.0f - f2 / 2.0f;
        ColorRGBA colorRGBA = this.I_field_aad1658.apply(this);
        if (colorRGBA != null && colorRGBA.getAlpha() > 0.0f) {
            iII.drawRoundedRect(this.x(), f3, this.w(), f2, IIiii_Class8.I_method_893b2757(Math.min(f2 / 2.0f, 8.0f)), colorRGBA);
        }
        MatrixStack matrixStack = iII.getMatrices();
        iIiiiIiII_Class373.I_method_d5a5ee51(matrixStack, this.x(), this.y(), this.w(), this.h());
        this.I_method_785c0698(iII, this.II_field_aad1658.apply(this), this.y(), this.y() + this.h());
        iIiiiIiII_Class373.I_method_ff80a1df();
        iIiiiIiII_Class373.I_method_d5a5ee51(matrixStack, this.x(), f3, this.w(), f2);
        this.I_method_785c0698(iII, this.i_field_aad1658.apply(this), f3, f3 + f2);
        iIiiiIiII_Class373.I_method_ff80a1df();
        this.I_method_1690bec7(iII);
    }

    private void I_method_785c0698(III iII, ColorRGBA colorRGBA, float f, float f2) {
        if (colorRGBA == null || colorRGBA.getAlpha() <= 0.0f) {
            return;
        }
        float f3 = this.w() / (float)this.I_field_7865b31.size();
        float f4 = this.y() + this.h() / 2.0f;
        float f5 = this.I_method_17bc66af();
        float f6 = (float)Math.toRadians(this.Ii_field_46);
        int n = Math.min(7, (int)Math.ceil(Math.toRadians(85.0) / (double)f6));
        float f7 = this.i_method_e193c8f1(f3);
        MatrixStack matrixStack = iII.getMatrices();
        for (int i = 0; i < this.I_field_7865b31.size(); ++i) {
            Nested1_b4f707c0 nested1_b4f707c0 = this.I_field_7865b31.get(i);
            float f8 = this.x() + (float)i * f3 + f7;
            float f9 = nested1_b4f707c0.I_field_b575d2cc.I_method_4e8b496f();
            int n2 = Math.round(f9);
            for (int j = -n; j <= n; ++j) {
                float f10;
                float f11;
                float f12;
                int n3 = n2 + j;
                float f13 = ((float)n3 - f9) * f6;
                float f14 = (float)Math.cos(f13);
                if (f14 <= 0.02f || (f12 = (float)Math.pow(f14, 2.2)) <= 0.02f || (f11 = f4 + f5 * (float)Math.sin(f13)) + (f10 = this.I_field_856d0221.iI_method_24b6c285() * 0.5f * f14) < f || f11 - f10 > f2) continue;
                IIiIIi_Class10 iIiIIi_Class10 = this.I_field_856d0221.I_method_36d49b4b().I_method_3a2d5e3(this.I_field_856d0221.iI_method_24b6c285() * (0.74f + 0.26f * f14));
                String string = nested1_b4f707c0.I_method_34a64255(Math.floorMod(n3, nested1_b4f707c0.I_field_49), this.I_field_5a);
                float f15 = this.I_field_856d0221.I_method_2c375926(string);
                float f16 = f8 - f15 + (f15 - iIiIIi_Class10.I_method_2c375926(string)) / 2.0f;
                float f17 = f11 - iIiIIi_Class10.I_method_a649725c() / 2.0f;
                matrixStack.push();
                matrixStack.translate(0.0f, f11, 0.0f);
                matrixStack.scale(1.0f, f14, 1.0f);
                matrixStack.translate(0.0f, -f11, 0.0f);
                iII.drawText(iIiIIi_Class10, string, f16, f17, colorRGBA.mulAlpha(f12));
                matrixStack.pop();
            }
        }
    }

    private void I_method_1690bec7(III iII) {
        ColorRGBA colorRGBA = this.Ii_field_aad1658.apply(this);
        if (colorRGBA == null || colorRGBA.getAlpha() <= 0.0f) {
            return;
        }
        float f = this.w() / (float)this.I_field_7865b31.size();
        float f2 = this.y() + this.h() / 2.0f;
        float f3 = this.i_method_e193c8f1(f);
        for (int i = 0; i < this.I_field_7865b31.size(); ++i) {
            String string;
            Nested1_b4f707c0 nested1_b4f707c0 = this.I_field_7865b31.get(i);
            String string2 = string = nested1_b4f707c0.I_field_11b14ee4 == null ? null : nested1_b4f707c0.I_field_11b14ee4.get();
            if (string == null || string.isEmpty()) continue;
            float f4 = this.x() + (float)i * f + f3 + this.iI_field_46;
            iII.drawText(this.i_field_856d0221, string, f4, f2 - this.i_field_856d0221.I_method_a649725c() / 2.0f, colorRGBA);
        }
    }

    private float i_method_e193c8f1(float f) {
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (Nested1_b4f707c0 nested1_b4f707c0 : this.I_field_7865b31) {
            f2 = Math.max(f2, this.I_field_856d0221.I_method_2c375926(nested1_b4f707c0.I_method_b994dc6(this.I_field_5a)));
            String string = nested1_b4f707c0.I_field_11b14ee4 == null ? null : nested1_b4f707c0.I_field_11b14ee4.get();
            if (string == null || string.isEmpty()) continue;
            f3 = Math.max(f3, this.i_field_856d0221.I_method_2c375926(string));
        }
        float f4 = f3 > 0.0f ? this.iI_field_46 + f3 : 0.0f;
        return (f - (f2 + f4)) / 2.0f + f2;
    }

    final class Nested1_b4f707c0 {
        final int I_field_49;
        private final IntSupplier I_field_ba7cd5ab;
        private final IntConsumer I_field_a2c190c1;
        final Supplier<String> I_field_11b14ee4;
        final IiI_Class3 I_field_b575d2cc = new IiI_Class3(I_field_f93678c1);
        private int i_field_49;
        boolean I_field_5a;
        boolean i_field_5a;
        private float I_field_46;
        private float i_field_46;
        private float II_field_46;

        Nested1_b4f707c0(int n, IntSupplier intSupplier, IntConsumer intConsumer, Supplier<String> supplier) {
            this.I_field_49 = n;
            this.I_field_ba7cd5ab = intSupplier;
            this.I_field_a2c190c1 = intConsumer;
            this.I_field_11b14ee4 = supplier;
            this.i_field_49 = this.I_method_9a1d3ed();
            this.I_field_b575d2cc.i_method_84a13e41(this.i_field_49);
        }

        private int I_method_9a1d3ed() {
            return Math.floorMod(this.I_field_ba7cd5ab.getAsInt(), this.I_field_49);
        }

        String I_method_34a64255(int n, boolean bl) {
            return bl && n < 10 ? "0" + n : String.valueOf(n);
        }

        String I_method_b994dc6(boolean bl) {
            return this.I_method_34a64255(this.I_field_49 - 1, bl);
        }

        void I_method_2a991306(float f) {
            this.I_field_5a = true;
            this.i_field_5a = false;
            this.I_field_46 = f;
            this.i_field_46 = this.I_field_b575d2cc.I_method_4e8b496f();
            this.II_field_46 = 0.0f;
        }

        void i_method_2c5c0326(float f) {
            this.I_field_5a = false;
            float f2 = this.I_field_b575d2cc.I_method_4e8b496f();
            float f3 = this.i_field_5a ? Math.max(-14.0f, Math.min(14.0f, this.II_field_46 * 170.0f)) : f;
            this.I_field_b575d2cc.I_method_82de4e21(Math.round(f2 + f3));
        }

        void I_method_2a991e49(int n) {
            this.I_field_5a = false;
            this.II_field_46 = 0.0f;
            this.I_field_b575d2cc.I_method_82de4e21(Math.round(this.I_field_b575d2cc.i_method_4e99d54f()) + n);
        }

        void I_method_2889b57a(float f, float f2) {
            this.I_method_9a1d3fa();
            if (this.I_field_5a) {
                float f3 = this.i_field_46 + (this.I_field_46 - f2) / IIiIi_Class6.this.II_field_46;
                if (Math.abs(f3 - this.i_field_46) > 0.12f) {
                    this.i_field_5a = true;
                }
                float f4 = (f3 - this.I_field_b575d2cc.I_method_4e8b496f()) / Math.max(1.0f, f);
                this.II_field_46 = this.II_field_46 * 0.65f + f4 * 0.35f;
                this.I_field_b575d2cc.i_method_84a13e41(f3);
            } else {
                int n;
                int n2;
                this.I_field_b575d2cc.Ii_method_dc72325e(f);
                if (this.I_field_b575d2cc.I_method_4e8b4983() && (n2 = Math.floorMod(n = Math.round(this.I_field_b575d2cc.I_method_4e8b496f()), this.I_field_49)) != n) {
                    this.I_field_b575d2cc.i_method_84a13e41(n2);
                }
            }
            this.i_method_9b05fda();
        }

        private void I_method_9a1d3fa() {
            int n = this.I_method_9a1d3ed();
            if (n == this.i_field_49 || this.I_field_5a) {
                return;
            }
            this.i_field_49 = n;
            int n2 = Math.round(this.I_field_b575d2cc.i_method_4e99d54f());
            int n3 = Math.floorMod(n - Math.floorMod(n2, this.I_field_49), this.I_field_49);
            if (n3 > this.I_field_49 / 2) {
                n3 -= this.I_field_49;
            }
            this.I_field_b575d2cc.I_method_82de4e21(n2 + n3);
        }

        private void i_method_9b05fda() {
            int n = Math.floorMod(Math.round(this.I_field_b575d2cc.I_method_4e8b496f()), this.I_field_49);
            if (n == this.i_field_49) {
                return;
            }
            this.i_field_49 = n;
            this.I_field_a2c190c1.accept(n);
        }
    }
}

