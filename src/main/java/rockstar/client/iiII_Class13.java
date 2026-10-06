package rockstar.client;

import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.client.util.math.MatrixStack;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.Iii_Class4;
import rockstar.client.iIiiiIiII_Class373;
import rockstar.client.iiI_Class7;

public class iiII_Class13
extends Iii_Class4 {
    private final IIiIIi_Class10 I_field_856d0221;
    private final Supplier<String> I_field_11b14ee4;
    private Function<iiII_Class13, ColorRGBA> I_field_aad1658 = iiII_Class132 -> ColorRGBA.WHITE;
    private float I_field_46 = 8.0f;
    private float i_field_46 = 8.0f;
    private float II_field_46 = 35.0f;
    private float Ii_field_46 = 600.0f;
    private BooleanSupplier I_field_7bf34412;
    private boolean I_field_5a;
    private float iI_field_46;
    private boolean i_field_5a = true;
    private float ii_field_46;

    public iiII_Class13(IIiIIi_Class10 iIiIIi_Class10, String string) {
        this(iIiIIi_Class10, () -> string);
    }

    public iiII_Class13(IIiIIi_Class10 iIiIIi_Class10, Supplier<String> supplier) {
        this.I_field_856d0221 = iIiIIi_Class10;
        this.I_field_11b14ee4 = supplier;
        this.ii_method_7b8212ac(iIiIIi_Class10.I_method_a649725c());
    }

    public iiII_Class13 I_method_a36fd944(ColorRGBA colorRGBA) {
        this.I_field_aad1658 = iiII_Class132 -> colorRGBA;
        return this;
    }

    public iiII_Class13 I_method_ea3dfdc5(Supplier<ColorRGBA> supplier) {
        this.I_field_aad1658 = iiII_Class132 -> (ColorRGBA)supplier.get();
        return this;
    }

    public iiII_Class13 I_method_6da713d1(Function<iiII_Class13, ColorRGBA> function) {
        this.I_field_aad1658 = function;
        return this;
    }

    public iiII_Class13 I_method_56dae5cb(float f, float f2) {
        this.I_field_46 = f;
        this.i_field_46 = f2;
        return this;
    }

    public iiII_Class13 I_method_c8e402a3(float f) {
        this.I_field_46 = f;
        return this;
    }

    public iiII_Class13 i_method_40e6683(float f) {
        this.i_field_46 = f;
        return this;
    }

    public iiII_Class13 II_method_163596ac(float f) {
        this.II_field_46 = f;
        return this;
    }

    public iiII_Class13 Ii_method_515ffa8c(float f) {
        this.Ii_field_46 = f;
        return this;
    }

    public iiII_Class13 I_method_97a535f9(BooleanSupplier booleanSupplier) {
        this.I_field_7bf34412 = booleanSupplier;
        return this;
    }

    public iiII_Class13 I_method_e557eacb() {
        this.I_field_7bf34412 = () -> true;
        return this;
    }

    public iiII_Class13 i_method_6b618aeb() {
        this.I_field_5a = true;
        return this;
    }

    public iiII_Class13 iI_method_4057aecc(float f) {
        super.width(f);
        return this;
    }

    public iiII_Class13 ii_method_7b8212ac(float f) {
        super.height(f);
        return this;
    }

    public iiII_Class13 i_method_80fcfdeb(float f, float f2) {
        super.size(f, f2);
        return this;
    }

    public iiII_Class13 II_method_4aef31a2() {
        super.fillWidth();
        return this;
    }

    public iiII_Class13 Ii_method_d0f8d1c2() {
        super.fillHeight();
        return this;
    }

    @Override
    protected void onTick(float f, float f2, float f3) {
        if (!this.inFlow()) {
            return;
        }
        String string = this.I_field_11b14ee4.get();
        float f4 = Math.max(0.0f, (string == null ? 0.0f : this.I_field_856d0221.I_method_2c375926(string)) - this.w());
        if (f4 <= 0.0f) {
            this.iI_field_46 = 0.0f;
            this.i_field_5a = true;
            this.ii_field_46 = 0.0f;
            return;
        }
        this.iI_field_46 = Math.min(this.iI_field_46, f4);
        float f5 = this.II_field_46 * f / 1000.0f;
        if (!this.I_method_78474110(f2, f3)) {
            this.i_field_5a = true;
            this.ii_field_46 = 0.0f;
            this.iI_field_46 = Math.max(0.0f, this.iI_field_46 - f5);
            return;
        }
        if (this.ii_field_46 > 0.0f) {
            this.ii_field_46 -= f;
            return;
        }
        if (this.i_field_5a) {
            this.iI_field_46 = Math.min(this.iI_field_46 + f5, f4);
            if (this.iI_field_46 >= f4) {
                this.i_field_5a = false;
                this.ii_field_46 = this.Ii_field_46;
            }
        } else {
            this.iI_field_46 = Math.max(this.iI_field_46 - f5, 0.0f);
            if (this.iI_field_46 <= 0.0f) {
                this.i_field_5a = true;
                this.ii_field_46 = this.Ii_field_46;
            }
        }
    }

    private boolean I_method_78474110(float f, float f2) {
        if (this.I_field_7bf34412 != null) {
            return this.I_field_7bf34412.getAsBoolean();
        }
        iiI_Class7 iiI_Class72 = this.parent();
        return (iiI_Class72 != null ? iiI_Class72 : this).contains(f, f2);
    }

    @Override
    protected void drawSelf(III iII, float f) {
        String string = this.I_field_11b14ee4.get();
        if (string == null || string.isEmpty()) {
            return;
        }
        ColorRGBA colorRGBA = this.I_field_aad1658.apply(this);
        float f2 = this.x();
        float f3 = this.y();
        float f4 = this.w();
        float f5 = f3 + this.h() / 2.0f - this.I_field_856d0221.I_method_a649725c() / 2.0f;
        float f6 = Math.max(0.0f, this.I_field_856d0221.I_method_2c375926(string) - f4);
        if (this.I_field_5a) {
            iiI_Class7 iiI_Class72 = this.parent();
            float f7 = iiI_Class72 == null ? f3 - 3.0f : iiI_Class72.y() - 3.0f;
            float f8 = Math.max(iiI_Class72 == null ? this.h() : iiI_Class72.h(), this.I_field_856d0221.I_method_a649725c() + 4.0f) + 6.0f;
            iIiiiIiII_Class373.I_method_d5a5ee51(iII.getMatrices(), f2 - 3.0f, f7, f4 + 6.0f, f8);
            iII.pushMatrix();
            iII.getMatrices().translate(-this.iI_field_46, 0.0f, 0.0f);
            float f9 = Math.max(1.0f, f4 + this.iI_field_46);
            float f10 = (this.iI_field_46 + f4 * 0.95f) / f9;
            iII.drawFadeoutText(this.I_field_856d0221, string, f2, f5, colorRGBA, f10, 1.0f, f9);
            iII.popMatrix();
            iIiiiIiII_Class373.I_method_ff80a1df();
            return;
        }
        if (f6 <= 0.0f) {
            iII.drawText(this.I_field_856d0221, string, f2, f5, colorRGBA);
            return;
        }
        float f11 = Math.min(this.I_field_46, this.iI_field_46);
        float f12 = Math.min(this.i_field_46, f6 - this.iI_field_46);
        MatrixStack matrixStack = iII.getMatrices();
        iIiiiIiII_Class373.I_method_d5a5ee51(matrixStack, f2, f3 - 5.0f, f4, this.h() + 10.0f);
        matrixStack.push();
        matrixStack.translate(-this.iI_field_46 + 0.5f, 0.0f, 0.0f);
        iII.drawFadeText(this.I_field_856d0221, string, f2, f5, colorRGBA, f11, f12, f4);
        matrixStack.pop();
        iIiiiIiII_Class373.I_method_ff80a1df();
    }

}

