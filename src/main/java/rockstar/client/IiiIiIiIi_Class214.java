package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.IIIi_Class2;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiI_Class3;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIi_Class2;
import rockstar.client.IIii_Class4;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiiI_Class7;
import rockstar.client.Iii_Class4;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iIi_Class6;
import rockstar.client.iii_Class8;
import ua.mintantileak.spk.Compile;

public class IiiIiIiIi_Class214
extends IIiI_Class3 {
    private static final String[] I_field_6dccaaa5 = new String[]{"Combat", "Movement", "Visuals", "Misc"};
    private final IIiIIi_Class10 I_field_856d0221 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0f);
    private final IIiIIi_Class10 i_field_856d0221 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.0f);
    private String I_field_523beb0a = I_field_6dccaaa5[0];
    private iii_Class8 I_field_b584628c;

    @Override
    @Compile(obfuscation=4)
    public void init() {
        super.init();
        this.clearRoots();
        float f = 360.0f;
        float f2 = 252.0f;
        float f3 = 10.0f;
        float f4 = 22.0f;
        float f5 = 8.0f;
        iii_Class8 iii_Class83 = new iii_Class8().I_method_485bccf5().i_method_f6ad2537(f3).I_method_70a38517(f5).ii_method_94920434(6.0f).iI_method_e886414(10.0f).I_method_e53800a9(iii_Class82 -> IiiiiIIIi_Class242.II_method_190e6391().withAlpha(235.0f)).i_method_8c7d3515(f, f2).iII_method_d8ebd935().I_method_8361fbbd(iIi_Class6.i_field_b583ea6c);
        iii_Class8 iii_Class84 = new iii_Class8().i_method_c88da8d5().I_method_70a38517(6.0f).III_method_9dc17555().IiI_method_31d4c97(f4).I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1).I_method_8361fbbd(iIi_Class6.i_field_b583ea6c);
        for (String string : I_field_6dccaaa5) {
            iii_Class84.I_method_8939bffd(this.I_method_8ddd58bf(string));
        }
        this.I_field_b584628c = new iii_Class8().I_method_4f3850da(2).I_method_70a38517(6.0f).III_method_9dc17555().IiI_method_31d4c97(f2 - f3 * 2.0f - f4 - f5).Ii_method_bb38d618().Ii_method_5967a054(220.0f).I_method_ef221966(this.I_method_84993e(this.I_field_523beb0a));
        iii_Class83.I_method_8939bffd(iii_Class84);
        iii_Class83.I_method_8939bffd(this.I_field_b584628c);
        this.add(iii_Class83);
    }

    private Iii_Class4 I_method_8ddd58bf(String string) {
        float f = this.I_field_856d0221.I_method_2c375926(string) + 18.0f;
        return new Iii_Class4().height(22.0f).width(f).radius(6.0f).bind("sel", () -> this.I_field_523beb0a.equals(string)).background(iii_Class4 -> IiiiiIIIi_Class242.i_method_5dfec6e().mulAlpha(0.1f + 0.2f * iii_Class4.sig("sel") + 0.1f * iii_Class4.hover())).border(1.0f, iii_Class4 -> IiiiiIIIi_Class242.i_method_5dfec6e().mulAlpha(0.0f + 0.7f * iii_Class4.sig("sel"))).text(this.I_field_856d0221, string, iii_Class4 -> IiiiiIIIi_Class242.iI_method_8e08d3b1().mix(IiiiiIIIi_Class242.i_method_5dfec6e(), iii_Class4.sig("sel")).mulAlpha(0.6f + 0.4f * Math.max(iii_Class4.sig("sel"), iii_Class4.hover()))).textAlign(IIi_Class2.i_field_b5755e8c).cursor(iIIIiIIIi_Class274.i_field_aa52e62c).onClick(() -> this.I_method_de7109e9(string)).enter(IiiI_Class7.II_field_f94500c1).exit(IiiI_Class7.II_field_f94500c1);
    }

    private void I_method_de7109e9(String string) {
        if (this.I_field_523beb0a.equals(string)) {
            return;
        }
        this.I_field_523beb0a = string;
        this.I_field_b584628c.II_method_244860a9(this.I_method_84993e(this.I_field_523beb0a));
    }

    private List<Iii_Class4> I_method_84993e(String string) {
        ArrayList<Iii_Class4> arrayList = new ArrayList<Iii_Class4>(100);
        for (int i = 0; i < 100; ++i) {
            int n = i;
            ColorRGBA colorRGBA = ColorRGBA.fromHSB(((float)(string.hashCode() & 0xFF) / 255.0f + (float)i * 0.041f) % 1.0f, 0.55f, 0.95f);
            String string2 = string + " #" + (i + 1);
            arrayList.add(new Iii_Class4().fillWidth().height(34.0f).radius(6.0f).cursor(iIIIiIIIi_Class274.i_field_aa52e62c).background(iii_Class4 -> IiiiiIIIi_Class242.Ii_method_a0f56f71().mulAlpha(0.25f + 0.2f * iii_Class4.hover())).textInset(18.0f).text(this.I_field_856d0221, string2, iii_Class4 -> IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(0.85f)).paint((iII, iii_Class4) -> {
                iII.drawRoundedRect(iii_Class4.x() + 7.0f, iii_Class4.y() + iii_Class4.h() / 2.0f - 4.0f, 4.0f, 8.0f, IIiii_Class8.I_method_893b2757(2.0f), colorRGBA);
                iII.drawText(this.i_field_856d0221, "element index " + n, iii_Class4.x() + 18.0f, iii_Class4.y() + iii_Class4.h() / 2.0f + 1.5f, IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(0.4f));
            }).lifeMotion(IIii_Class4.I_method_3682ece9(500L, IiiiIiiII_Class237.I_field_dd60aac)).enter(IiiI_Class7.I_method_540512a3(-30.0f)).exit(IiiI_Class7.I_method_540512a3(-30.0f)));
        }
        return arrayList;
    }
}

