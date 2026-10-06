package rockstar.client;

import java.util.function.Function;
import java.util.function.Supplier;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiIiIIIII_Class161;
import rockstar.client.iIIIIiIiI_Class267;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iiI_Class7;

public class iiii_Class16
extends iiI_Class7 {
    private final IIiIIi_Class10 I_field_856d0221;
    private final Nested1_5f3d21b3 I_field_58dd7f1c;
    private final Nested1_5f3d2193 I_field_58dd7b3c;
    private final float I_field_46;
    private final float i_field_46;
    private Supplier<String> I_field_11b14ee4;
    private Supplier<String> i_field_11b14ee4 = () -> "";
    private Function<iiii_Class16, ColorRGBA> I_field_aad1658 = iiii_Class162 -> ColorRGBA.WHITE;
    private Function<iiii_Class16, ColorRGBA> i_field_aad1658;
    private IiIiIIIII_Class161 I_field_fdef2cc;
    private boolean I_field_5a;
    private static iiii_Class16 I_field_fb07f4c1;
    private static final float II_field_46 = 40.0f;
    private static final float Ii_field_46 = 3.0f;

    public iiii_Class16(IIiIIi_Class10 iIiIIi_Class10, Nested1_5f3d21b3 nested1_5f3d21b3, Nested1_5f3d2193 nested1_5f3d2193, float f, float f2) {
        this.I_field_856d0221 = iIiIIi_Class10;
        this.I_field_58dd7f1c = nested1_5f3d21b3;
        this.I_field_58dd7b3c = nested1_5f3d2193;
        this.I_field_46 = f;
        this.i_field_46 = f2;
        this.I_field_11b14ee4 = () -> iIIIIiIiI_Class267.I_method_230e44c1(nested1_5f3d21b3.get());
        this.height(iIiIIi_Class10.I_method_a649725c());
        this.cursor(iIIIiIIIi_Class274.i_field_aa52e62c);
        this.snapPosition();
        this.snapSize();
    }

    public iiii_Class16 I_method_c389f5c5(Supplier<String> supplier) {
        if (supplier != null) {
            this.I_field_11b14ee4 = supplier;
        }
        return this;
    }

    public iiii_Class16 i_method_6f9c9a5(Supplier<String> supplier) {
        if (supplier != null) {
            this.i_field_11b14ee4 = supplier;
        }
        return this;
    }

    public iiii_Class16 I_method_b29dd144(ColorRGBA colorRGBA) {
        this.I_field_aad1658 = iiii_Class162 -> colorRGBA;
        return this;
    }

    public iiii_Class16 II_method_f81d1a4e(Supplier<ColorRGBA> supplier) {
        this.I_field_aad1658 = iiii_Class162 -> (ColorRGBA)supplier.get();
        return this;
    }

    public iiii_Class16 I_method_46f30bd1(Function<iiii_Class16, ColorRGBA> function) {
        this.I_field_aad1658 = function;
        return this;
    }

    public iiii_Class16 i_method_5040b524(ColorRGBA colorRGBA) {
        this.i_field_aad1658 = iiii_Class162 -> colorRGBA;
        return this;
    }

    public iiii_Class16 i_method_8a62dfb1(Function<iiii_Class16, ColorRGBA> function) {
        this.i_field_aad1658 = function;
        return this;
    }

    public iiii_Class16 I_method_d01faa3(float f) {
        super.width(f);
        return this;
    }

    public iiii_Class16 I_method_299b6acb() {
        super.fillWidth();
        return this;
    }

    public boolean I_method_b739810() {
        return this.I_field_5a;
    }

    private IiIiIIIII_Class161 I_method_7215b302() {
        if (this.I_field_fdef2cc == null) {
            this.I_field_fdef2cc = new IiIiIIIII_Class161(this.I_field_856d0221);
            this.I_field_fdef2cc.i_method_fd1e2055(true);
        }
        return this.I_field_fdef2cc;
    }

    public static void I_method_b289539a(iiI_Class7 iiI_Class72) {
        iiii_Class16 iiii_Class162 = I_field_fb07f4c1;
        if (iiii_Class162 != null && iiii_Class162 != iiI_Class72 && iiii_Class162.I_field_5a) {
            iiii_Class162.i_method_b8223ec();
        }
    }

    private void I_method_b73980c() {
        iiii_Class16.I_method_b289539a(this);
        String string = iIIIIiIiI_Class267.I_method_230e44c1(this.I_field_58dd7f1c.get());
        this.I_method_7215b302().I_method_1d5afa89(string);
        this.I_method_7215b302().II_method_e557b20c(string);
        this.I_method_7215b302().I_method_fb5b3035(true);
        this.I_method_7215b302().i_method_18ae5e5f();
        this.I_field_5a = true;
        I_field_fb07f4c1 = this;
    }

    private void i_method_b8223ec() {
        if (this.I_field_fdef2cc != null) {
            try {
                String string = this.I_field_fdef2cc.I_method_d2579001().replace(',', '.');
                if (!(string.isEmpty() || string.equals("-") || string.equals("."))) {
                    float f = Float.parseFloat(string);
                    f = Math.max(this.I_field_46, Math.min(this.i_field_46, f));
                    this.I_field_58dd7b3c.accept(f);
                }
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
            this.I_field_fdef2cc.I_method_fb5b3035(false);
        }
        this.I_field_5a = false;
        if (I_field_fb07f4c1 == this) {
            I_field_fb07f4c1 = null;
        }
    }

    private void II_method_630e60d5() {
        if (this.I_field_fdef2cc != null) {
            this.I_field_fdef2cc.I_method_fb5b3035(false);
        }
        this.I_field_5a = false;
        if (I_field_fb07f4c1 == this) {
            I_field_fb07f4c1 = null;
        }
    }

    @Override
    public boolean mouseClicked(float f, float f2, IiIII_Class9 iiIII_Class9) {
        if (this.contains(f, f2)) {
            if (iiIII_Class9 == IiIII_Class9.I_field_2f4c8d6c) {
                if (!this.I_field_5a) {
                    this.I_method_b73980c();
                } else {
                    this.I_method_7215b302().I_method_400ceaa7(f, f2, iiIII_Class9);
                }
            }
            return true;
        }
        if (this.I_field_5a) {
            this.i_method_b8223ec();
        }
        return false;
    }

    @Override
    public boolean keyPressed(int n, int n2, int n3) {
        if (!this.I_field_5a) {
            return false;
        }
        if (n == 257 || n == 335) {
            this.i_method_b8223ec();
            return true;
        }
        if (n == 256) {
            this.II_method_630e60d5();
            return true;
        }
        this.I_method_7215b302().I_method_c1acbc24(n, n2, n3);
        return true;
    }

    @Override
    public boolean charTyped(char c, int n) {
        if (!this.I_field_5a) {
            return false;
        }
        return this.I_method_7215b302().I_method_b71e84c9(c, n);
    }

    @Override
    protected void onTick(float f, float f2, float f3) {
        if (this.I_field_5a && this.I_field_fdef2cc != null && !this.I_field_fdef2cc.I_method_189fd283()) {
            this.i_method_b8223ec();
        }
    }

    private String I_method_73ff614() {
        String string = this.I_field_5a && this.I_field_fdef2cc != null ? this.I_field_fdef2cc.I_method_d2579001() : this.I_field_11b14ee4.get();
        return string == null ? "" : string;
    }

    @Override
    protected void measure() {
        if (!this.explicitW) {
            String string = this.i_field_11b14ee4.get();
            this.prefW = Math.max(6.0f, this.I_field_856d0221.I_method_2c375926(this.I_method_73ff614()) + this.I_field_856d0221.I_method_2c375926(string == null ? "" : string));
        }
        if (!this.explicitH) {
            this.prefH = this.I_field_856d0221.I_method_a649725c();
        }
    }

    @Override
    protected void drawSelf(III iII, float f) {
        Object object;
        float f2;
        float f3 = this.y() + this.h() / 2.0f - this.I_field_856d0221.I_method_a649725c() / 2.0f;
        ColorRGBA colorRGBA = this.I_field_aad1658.apply(this);
        String string = this.i_field_11b14ee4.get();
        if (this.I_field_5a && this.I_field_fdef2cc != null) {
            f2 = this.I_field_856d0221.I_method_2c375926(this.I_field_fdef2cc.I_method_d2579001());
            this.I_field_fdef2cc.I_method_b043bcc(this.x() - 3.0f, f3 - 3.0f, f2 + 40.0f, this.I_field_856d0221.I_method_a649725c() + 6.0f);
            this.I_field_fdef2cc.iI_method_a8609f1e(1.0f);
            this.I_field_fdef2cc.I_method_13a617e0(colorRGBA);
            this.I_field_fdef2cc.I_method_7ae26dda(iII);
        } else {
            object = this.I_method_73ff614();
            f2 = this.I_field_856d0221.I_method_2c375926((String)object);
            if (!((String)object).isEmpty()) {
                iII.drawText(this.I_field_856d0221, (String)object, this.x(), f3, colorRGBA);
            }
        }
        if (string != null && !string.isEmpty()) {
            object = this.i_field_aad1658 != null ? this.i_field_aad1658.apply(this) : colorRGBA;
            iII.drawText(this.I_field_856d0221, string, this.x() + f2, f3, (ColorRGBA)object);
        }
    }

    public static interface Nested1_5f3d21b3 {
        public float get();
    }

    public static interface Nested1_5f3d2193 {
        public void accept(float var1);
    }
}

