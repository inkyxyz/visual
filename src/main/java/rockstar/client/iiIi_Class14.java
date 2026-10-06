package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.iiI_Class7;

public class iiIi_Class14
extends iiI_Class7 {
    private final IIiIIi_Class10 I_field_856d0221;
    private final Supplier<String> I_field_11b14ee4;
    private Function<iiIi_Class14, ColorRGBA> I_field_aad1658 = iiIi_Class142 -> ColorRGBA.WHITE;
    private boolean I_field_5a;
    private float I_field_46 = 3.0f;
    private final List<String> I_field_7865b31 = new ArrayList<String>();
    private String I_field_523beb0a;
    private float i_field_46 = -1.0f;

    public iiIi_Class14(IIiIIi_Class10 iIiIIi_Class10, String string) {
        this(iIiIIi_Class10, () -> string);
    }

    public iiIi_Class14(IIiIIi_Class10 iIiIIi_Class10, Supplier<String> supplier) {
        this.I_field_856d0221 = iIiIIi_Class10;
        this.I_field_11b14ee4 = supplier;
    }

    public iiIi_Class14 I_method_63e94904(ColorRGBA colorRGBA) {
        this.I_field_aad1658 = iiIi_Class142 -> colorRGBA;
        return this;
    }

    public iiIi_Class14 I_method_94717391(Function<iiIi_Class14, ColorRGBA> function) {
        this.I_field_aad1658 = function;
        return this;
    }

    public iiIi_Class14 I_method_93241bcf(boolean bl) {
        this.I_field_5a = bl;
        return this;
    }

    public iiIi_Class14 I_method_f7a06cb() {
        this.I_field_5a = true;
        return this;
    }

    public iiIi_Class14 I_method_e304f263(float f) {
        this.I_field_46 = f;
        return this;
    }

    public iiIi_Class14 i_method_1e2f5643(float f) {
        super.width(f);
        return this;
    }

    public iiIi_Class14 II_method_40322aac(float f) {
        super.height(f);
        return this;
    }

    public iiIi_Class14 i_method_9583a6eb() {
        super.fillWidth();
        return this;
    }

    public iiIi_Class14 II_method_65102162() {
        super.fillHeight();
        return this;
    }

    @Override
    protected void measure() {
        this.I_method_6eac2fec();
        if (!this.explicitH) {
            int n = Math.max(1, this.I_field_7865b31.size());
            this.prefH = (float)n * this.I_field_856d0221.I_method_a649725c() + (float)(n - 1) * this.I_field_46;
        }
    }

    private void I_method_6eac2fec() {
        String string = this.I_field_11b14ee4.get();
        float f = this.w();
        boolean bl = string == null ? this.I_field_523beb0a == null : string.equals(this.I_field_523beb0a);
        if (bl && Math.abs(f - this.i_field_46) < 0.5f) {
            return;
        }
        this.I_field_523beb0a = string;
        this.i_field_46 = f;
        this.I_field_7865b31.clear();
        if (string == null || string.isEmpty()) {
            return;
        }
        if (f < 8.0f) {
            this.I_field_7865b31.add(string);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String string2 : string.split(" ")) {
            if (stringBuilder.length() == 0) {
                stringBuilder.append(string2);
                continue;
            }
            if (this.I_field_856d0221.I_method_2c375926(String.valueOf(stringBuilder) + " " + string2) > f) {
                this.I_field_7865b31.add(stringBuilder.toString());
                stringBuilder = new StringBuilder(string2);
                continue;
            }
            stringBuilder.append(' ').append(string2);
        }
        if (stringBuilder.length() > 0) {
            this.I_field_7865b31.add(stringBuilder.toString());
        }
    }

    @Override
    protected void drawSelf(III iII, float f) {
        if (this.I_field_7865b31.isEmpty()) {
            return;
        }
        ColorRGBA colorRGBA = this.I_field_aad1658.apply(this);
        if (colorRGBA == null || colorRGBA.getAlpha() <= 0.0f) {
            return;
        }
        float f2 = this.x();
        float f3 = this.y();
        float f4 = this.w();
        float f5 = f3;
        for (String string : this.I_field_7865b31) {
            if (this.I_field_5a) {
                iII.drawCenteredText(this.I_field_856d0221, string, f2 + f4 / 2.0f, f5, colorRGBA);
            } else {
                iII.drawText(this.I_field_856d0221, string, f2, f5, colorRGBA);
            }
            f5 += this.I_field_856d0221.I_method_a649725c() + this.I_field_46;
        }
    }

}
