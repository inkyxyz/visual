package rockstar.client;

import java.util.List;
import net.minecraft.util.math.MathHelper;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIII;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIi_Class2;
import rockstar.client.IIiii_Class8;
import rockstar.client.MultiSelectSetting;
import rockstar.client.IiIIi_Class10;
import rockstar.client.IiIiiIIII_Class177;
import rockstar.client.IiIiiIiIi_Class182;
import rockstar.client.IiIiiIiii_Class184;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iiI_Class7;
import rockstar.client.iiiIIII_Class113;
import rockstar.client.iiiIIiI_Class115;
import rockstar.client.iii_Class8;

public class IiiIIIIiI_Class195
extends IiIiiIiii_Class184 {
    private static final ColorRGBA I_field_d0c8ec5 = new ColorRGBA(74.0f, 222.0f, 128.0f);
    private static final ColorRGBA i_field_d0c8ec5 = new ColorRGBA(239.0f, 68.0f, 68.0f);
    private static final float I_field_46 = 6.0f;
    private static final float i_field_46 = 1.2f;
    iiiIIiI_Class115 I_field_c12047ec;
    private iiI_Class7 I_field_b5845eac;

    public IiiIIIIiI_Class195(MultiSelectSetting iIiiiiiii_Class128) {
        super(iIiiiiiii_Class128, "alerts");
    }

    @Override
    public void prepare(IiIiiIIII_Class177 iiIiiIIII_Class177) {
        this.I_field_c12047ec = this.I_method_c18e8af5();
    }

    @Override
    public iiI_Class7 content(IiIiiIIII_Class177 iiIiiIIII_Class177) {
        if (this.I_field_b5845eac == null) {
            iii_Class8 iii_Class83 = IiIiiIiIi_Class182.I_method_4b294f34(15.0f, IIII.I_method_12c9a0cb(0.0f, 5.0f, 0.0f, 4.5f), 4.0f).I_method_483797dd(IIi_Class2.i_field_b5755e8c).I_method_f136b1d8((iII, iii_Class82) -> {
                if (this.I_field_c12047ec == null) {
                    return;
                }
                float f = this.animation.I_method_6ac4da6f() * this.I_field_c12047ec.i_method_dc20d9d5().I_method_6ac4da6f();
                if (f <= 0.0f) {
                    return;
                }
                ColorRGBA colorRGBA = this.I_method_deefb8ce();
                ColorRGBA colorRGBA2 = colorRGBA.withAlpha(71.4f * f);
                ColorRGBA colorRGBA3 = colorRGBA.withAlpha(0.0f);
                float f2 = iiIiiIIII_Class177.i_method_d8dd7b75().I_method_6ac4da6f();
                iII.drawSquircle(iii_Class82.x(), iii_Class82.y(), iii_Class82.w() * 0.69f, iii_Class82.h(), 2.0f, IIiii_Class8.II_method_35289fb8(f2, f2), new IiIIi_Class10(colorRGBA2, colorRGBA2, colorRGBA3, colorRGBA3));
            });
            iii_Class83.I_method_8939bffd(new Nested1_fa680420());
            iii_Class83.I_method_8939bffd(new Nested1_fa680440());
            this.I_field_b5845eac = iii_Class83;
        }
        return this.I_field_b5845eac;
    }

    @Override
    public boolean canShow() {
        List<iiiIIiI_Class115> list = this.I_method_4513da08();
        if (list.isEmpty()) {
            return false;
        }
        iiiIIiI_Class115 iiiIIiI_Class1152 = list.getLast();
        return !iiiIIiI_Class1152.I_method_51df89b5().I_method_58432069(iiiIIiI_Class1152.I_method_ddda8cb3());
    }

    private iiiIIiI_Class115 I_method_c18e8af5() {
        List<iiiIIiI_Class115> list = this.I_method_4513da08();
        return list.isEmpty() ? null : list.getLast();
    }

    List<iiiIIiI_Class115> I_method_4513da08() {
        return RockstarClient.getInstance().I_method_5cb1af22().I_method_57b4ffc8().stream().filter(iiIiiiI_Class1112 -> iiIiiiI_Class1112 instanceof iiiIIiI_Class115).map(iiIiiiI_Class1112 -> (iiiIIiI_Class115)iiIiiiI_Class1112).toList();
    }

    ColorRGBA I_method_deefb8ce() {
        if (this.I_field_c12047ec == null) {
            return I_field_d0c8ec5;
        }
        return switch (this.I_field_c12047ec.I_method_b5def915()) {
            case iiiIIII_Class113.I_field_c11fcfcc -> I_field_d0c8ec5;
            case iiiIIII_Class113.i_field_c11fcfcc -> i_field_d0c8ec5;
            default -> this.I_field_c12047ec.I_method_b5def915().i_method_77de82ce();
        };
    }

    final class Nested1_fa680420
    extends iiI_Class7 {
        Nested1_fa680420() {
            this.size(6.0f, 6.0f);
            this.interactive(false);
        }

        @Override
        protected void drawSelf(III iII, float f) {
            if (IiiIIIIiI_Class195.this.I_field_c12047ec == null) {
                return;
            }
            for (iiiIIiI_Class115 iiiIIiI_Class1152 : IiiIIIIiI_Class195.this.I_method_4513da08()) {
                iiiIIiI_Class1152.i_method_dc20d9d5().I_method_edd6ec25(500L);
                iiiIIiI_Class1152.i_method_dc20d9d5().I_method_edd72835(IiiIIIIiI_Class195.this.I_field_c12047ec == iiiIIiI_Class1152);
            }
            float f2 = IiiIIIIiI_Class195.this.animation.I_method_6ac4da6f() * IiiIIIIiI_Class195.this.I_field_c12047ec.i_method_dc20d9d5().I_method_6ac4da6f();
            if (f2 <= 0.0f) {
                return;
            }
            long l = IiiIIIIiI_Class195.this.I_field_c12047ec.I_method_ddda8cb3();
            float f3 = l <= 0L ? 0.0f : MathHelper.clamp((float)(1.0f - (float)IiiIIIIiI_Class195.this.I_field_c12047ec.I_method_51df89b5().I_method_23e11e33() / (float)l), (float)0.0f, (float)1.0f);
            float f4 = this.x() + this.w() / 2.0f - 6.0f * (1.0f - f2);
            float f5 = this.y() + this.h() / 2.0f;
            float f6 = Math.min(this.w(), this.h()) / 2.0f + 0.5f;
            ColorRGBA colorRGBA = IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(40.8f * f2);
            ColorRGBA colorRGBA2 = IiiIIIIiI_Class195.this.I_method_deefb8ce().withAlpha(255.0f * f2);
            iII.drawCircleProgress(f4, f5, f6, 1.2f, 1.0f, colorRGBA);
            iII.drawCircleProgress(f4, f5, f6, 1.2f, f3, colorRGBA2);
        }
    }

    final class Nested1_fa680440
    extends iiI_Class7 {
        Nested1_fa680440() {
            this.interactive(false);
        }

        @Override
        protected void measure() {
            String string = IiiIIIIiI_Class195.this.I_field_c12047ec == null ? "" : IiiIIIIiI_Class195.this.I_field_c12047ec.I_method_740eb1e1();
            this.prefW = string.isEmpty() ? 0.0f : IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0f).I_method_2c375926(string);
            this.prefH = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0f).I_method_a649725c();
        }

        @Override
        protected void drawSelf(III iII, float f) {
            if (IiiIIIIiI_Class195.this.I_field_c12047ec == null) {
                return;
            }
            String string = IiiIIIIiI_Class195.this.I_field_c12047ec.I_method_740eb1e1();
            float f2 = IiiIIIIiI_Class195.this.animation.I_method_6ac4da6f();
            float f3 = IiiIIIIiI_Class195.this.I_field_c12047ec.i_method_dc20d9d5().I_method_6ac4da6f();
            iII.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0f), string, this.x() + 6.0f * (1.0f - f2 * f3), this.y(), IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * f3));
        }
    }
}

