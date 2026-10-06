package rockstar.client;

import pyrock.utility.render.ColorRGBA;
import rockstar.client.IIII;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIi_Class2;
import rockstar.client.IIiii_Class8;
import rockstar.client.MultiSelectSetting;
import rockstar.client.IiIiiIIII_Class177;
import rockstar.client.IiIiiIiIi_Class182;
import rockstar.client.IiIiiIiii_Class184;
import rockstar.client.Iiii_Class8;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIiiiII_Class285;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iiI_Class7;
import rockstar.client.iii_Class8;

public class IiIiiiIiI_Class187
extends IiIiiIiii_Class184
implements iIIiIIiIi_Class294 {
    private String I_field_523beb0a = "";
    private String i_field_523beb0a = "";
    private int I_field_49 = -1;
    private String II_field_523beb0a = "text";
    private ColorRGBA I_field_d0c8ec5 = IiiiiIIIi_Class242.i_method_5dfec6e();
    private iiI_Class7 I_field_b5845eac;

    public IiIiiiIiI_Class187(MultiSelectSetting iIiiiiiii_Class128, String string) {
        super(iIiiiiiii_Class128, string);
    }

    @Override
    public iiI_Class7 content(IiIiiIIII_Class177 iiIiiIIII_Class177) {
        if (this.I_field_b5845eac == null) {
            iii_Class8 iii_Class83 = IiIiiIiIi_Class182.I_method_4b294f34(15.0f, IIII.I_method_12c9a0cb(0.0f, 4.0f, 0.0f, 4.0f), 3.5f).I_method_483797dd(IIi_Class2.i_field_b5755e8c);
            iii_Class8 iii_Class84 = IiIiiIiIi_Class182.I_method_936430f8(() -> -20.0f * (1.0f - this.animation.I_method_6ac4da6f())).i_method_c88da8d5().IiI_method_31d4c97(8.0f).I_method_7e2bb176(IIII.I_method_12c9a0cb(0.0f, 2.5f, 0.0f, 3.0f)).I_method_483797dd(IIi_Class2.i_field_b5755e8c).I_method_f136b1d8((iII, iii_Class82) -> iII.drawRoundedRect(iii_Class82.x(), iii_Class82.y(), iii_Class82.w(), iii_Class82.h(), IIiii_Class8.I_method_893b2757(3.0f), this.I_field_d0c8ec5.withAlpha(255.0f * this.animation.I_method_6ac4da6f())));
            iii_Class84.I_method_8939bffd(IiIiiIiIi_Class182.I_method_76baf816(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.0f), () -> this.I_field_523beb0a, () -> IiiiiIIIi_Class242.I_method_35ed8eaf(this.I_field_d0c8ec5).withAlpha(255.0f * this.animation.I_method_6ac4da6f())));
            iii_Class84.I_method_8939bffd(new Iiii_Class8(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.0f), () -> this.I_field_49).I_method_6e260263(5.0f).I_method_124306cb().I_method_ab0d6d85(() -> IiiiiIIIi_Class242.I_method_35ed8eaf(this.I_field_d0c8ec5).withAlpha(255.0f * this.animation.I_method_6ac4da6f())).interactive(false));
            iii_Class84.I_method_8939bffd(IiIiiIiIi_Class182.I_method_76baf816(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.0f), () -> this.i_field_523beb0a, () -> IiiiiIIIi_Class242.I_method_35ed8eaf(this.I_field_d0c8ec5).withAlpha(255.0f * this.animation.I_method_6ac4da6f())));
            iii_Class83.I_method_8939bffd(iii_Class84);
            iii_Class83.I_method_8939bffd(IiIiiIiIi_Class182.I_method_923ba5d7(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0f), () -> this.II_field_523beb0a, () -> IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * this.animation.I_method_6ac4da6f()), () -> 10.0f * (1.0f - this.animation.I_method_6ac4da6f())));
            this.I_field_b5845eac = iii_Class83;
        }
        return this.I_field_b5845eac;
    }

    public void I_method_746c5e3b(String string, int n, String string2, ColorRGBA colorRGBA) {
        this.I_method_44ddbec5("", string, n, string2, colorRGBA);
    }

    public void I_method_44ddbec5(String string, String string2, int n, String string3, ColorRGBA colorRGBA) {
        this.I_field_523beb0a = string;
        this.i_field_523beb0a = string2;
        this.I_field_49 = n;
        this.II_field_523beb0a = string3;
        this.I_field_d0c8ec5 = colorRGBA;
    }

    @Override
    public boolean canShow() {
        return iIIIiiiII_Class285.I_field_5a;
    }
}

