package rockstar.client;

import java.util.function.Supplier;
import net.minecraft.util.Identifier;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIII;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.iiI_Class7;
import rockstar.client.iii_Class8;

public final class IiIiiIiIi_Class182 {
    private IiIiiIiIi_Class182() {
    }

    public static iiI_Class7 I_method_76baf816(IIiIIi_Class10 iIiIIi_Class10, Supplier<String> supplier, Supplier<ColorRGBA> supplier2) {
        return IiIiiIiIi_Class182.I_method_923ba5d7(iIiIIi_Class10, supplier, supplier2, () -> 0.0f);
    }

    public static iiI_Class7 I_method_923ba5d7(IIiIIi_Class10 iIiIIi_Class10, Supplier<String> supplier, Supplier<ColorRGBA> supplier2, iiI_Class7.Nested1_b540d40 nested1_b540d40) {
        return new Nested1_83048809(iIiIIi_Class10, supplier, supplier2, nested1_b540d40);
    }

    public static iiI_Class7 I_method_8784ba99(final Identifier identifier, final float f, final float f2, final Supplier<ColorRGBA> supplier, final iiI_Class7.Nested1_b540d40 nested1_b540d40) {
        return new iiI_Class7(){
            {
                this.size(f, f2);
                this.interactive(false);
            }

            @Override
            protected void drawSelf(III iII, float f3) {
                ColorRGBA colorRGBA;
                ColorRGBA colorRGBA2 = colorRGBA = supplier == null ? ColorRGBA.WHITE : (ColorRGBA)supplier.get();
                if (colorRGBA != null) {
                    iII.drawTexture(identifier, this.x() + IiIiiIiIi_Class182.I_method_26ce3cb2(nested1_b540d40), this.y(), this.w(), this.h(), colorRGBA);
                }
            }
        };
    }

    public static iiI_Class7 I_method_5c799830(final String string, final float f, final Supplier<ColorRGBA> supplier, final iiI_Class7.Nested1_b540d40 nested1_b540d40) {
        return new iiI_Class7(){
            {
                this.size(f, f);
                this.interactive(false);
            }

            @Override
            protected void drawSelf(III iII, float f2) {
                ColorRGBA colorRGBA;
                ColorRGBA colorRGBA2 = colorRGBA = supplier == null ? ColorRGBA.WHITE : (ColorRGBA)supplier.get();
                if (colorRGBA != null) {
                    iII.drawIcon(string, this.x() + IiIiiIiIi_Class182.I_method_26ce3cb2(nested1_b540d40), this.y(), Math.min(this.w(), this.h()), colorRGBA);
                }
            }
        };
    }

    public static iiI_Class7 I_method_131f6edb(final float f, final float f2, final Nested1_830487e9 nested1_830487e9) {
        return new iiI_Class7(){
            {
                this.size(f, f2);
                this.interactive(false);
            }

            @Override
            protected void drawSelf(III iII, float f3) {
                if (nested1_830487e9 != null) {
                    nested1_830487e9.paint(iII, this, f3);
                }
            }
        };
    }

    public static iiI_Class7 I_method_9209ee95(final iiI_Class7.Nested1_b540d40 nested1_b540d40, final iiI_Class7.Nested1_b540d40 nested1_b540d402) {
        return new iiI_Class7(){
            {
                this.interactive(false);
            }

            @Override
            protected void measure() {
                this.prefW = Math.max(0.0f, IiIiiIiIi_Class182.I_method_26ce3cb2(nested1_b540d40));
                this.prefH = Math.max(0.0f, IiIiiIiIi_Class182.I_method_26ce3cb2(nested1_b540d402));
            }
        };
    }

    public static iii_Class8 I_method_936430f8(iiI_Class7.Nested1_b540d40 nested1_b540d40) {
        return new Nested1_c7c0460(nested1_b540d40);
    }

    public static iii_Class8 I_method_2eaf167b(Nested1_830487e9 nested1_830487e9) {
        return new Nested1_c7c0480(nested1_830487e9);
    }

    public static iii_Class8 I_method_4b294f34(float f, IIII iIII, float f2) {
        return new iii_Class8().i_method_c88da8d5().IiI_method_31d4c97(f).I_method_7e2bb176(iIII).I_method_70a38517(f2).Ii_method_25479968(false);
    }

    static float I_method_26ce3cb2(iiI_Class7.Nested1_b540d40 nested1_b540d40) {
        return nested1_b540d40 == null ? 0.0f : nested1_b540d40.get();
    }

    static final class Nested1_83048809
    extends iiI_Class7 {
        private final IIiIIi_Class10 I_field_856d0221;
        private final Supplier<String> I_field_11b14ee4;
        private final Supplier<ColorRGBA> i_field_11b14ee4;
        private final iiI_Class7.Nested1_b540d40 I_field_65e71a47;

        Nested1_83048809(IIiIIi_Class10 iIiIIi_Class10, Supplier<String> supplier, Supplier<ColorRGBA> supplier2, iiI_Class7.Nested1_b540d40 nested1_b540d40) {
            this.I_field_856d0221 = iIiIIi_Class10;
            this.I_field_11b14ee4 = supplier;
            this.i_field_11b14ee4 = supplier2;
            this.I_field_65e71a47 = nested1_b540d40;
            this.interactive(false);
        }

        @Override
        protected void measure() {
            String string = this.I_method_d4a1876f();
            if (!this.explicitW) {
                float f = this.prefW = string.isEmpty() ? 0.0f : this.I_field_856d0221.I_method_2c375926(string);
            }
            if (!this.explicitH) {
                this.prefH = this.I_field_856d0221.I_method_a649725c();
            }
        }

        @Override
        protected void drawSelf(III iII, float f) {
            ColorRGBA colorRGBA;
            String string = this.I_method_d4a1876f();
            if (string.isEmpty()) {
                return;
            }
            ColorRGBA colorRGBA2 = colorRGBA = this.i_field_11b14ee4 == null ? ColorRGBA.WHITE : this.i_field_11b14ee4.get();
            if (colorRGBA != null) {
                iII.drawText(this.I_field_856d0221, string, this.x() + IiIiiIiIi_Class182.I_method_26ce3cb2(this.I_field_65e71a47), this.y(), colorRGBA);
            }
        }

        private String I_method_d4a1876f() {
            String string = this.I_field_11b14ee4 == null ? "" : this.I_field_11b14ee4.get();
            return string == null ? "" : string;
        }
    }

    public static interface Nested1_830487e9 {
        public void paint(III var1, iiI_Class7 var2, float var3);
    }

    static final class Nested1_c7c0460
    extends iii_Class8 {
        private final iiI_Class7.Nested1_b540d40 I_field_65e71a47;

        Nested1_c7c0460(iiI_Class7.Nested1_b540d40 nested1_b540d40) {
            this.I_field_65e71a47 = nested1_b540d40;
            this.Ii_method_25479968(false);
        }

        @Override
        protected void drawSelf(III iII, float f) {
            iII.getMatrices().push();
            iII.getMatrices().translate(IiIiiIiIi_Class182.I_method_26ce3cb2(this.I_field_65e71a47), 0.0f, 0.0f);
            super.drawSelf(iII, f);
        }

        @Override
        protected void drawChildren(III iII, float f) {
            super.drawChildren(iII, f);
            iII.getMatrices().pop();
        }
    }

    static final class Nested1_c7c0480
    extends iii_Class8 {
        private final Nested1_830487e9 I_field_10cf68a6;

        Nested1_c7c0480(Nested1_830487e9 nested1_830487e9) {
            this.I_field_10cf68a6 = nested1_830487e9;
            this.Ii_method_25479968(false);
        }

        @Override
        protected void drawSelf(III iII, float f) {
            if (this.I_field_10cf68a6 != null) {
                this.I_field_10cf68a6.paint(iII, this, f);
            }
        }

        @Override
        protected void drawChildren(III iII, float f) {
        }
    }
}

