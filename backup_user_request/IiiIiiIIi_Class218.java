package rockstar.client;

import rockstar.client.Setting;
import rockstar.client.BooleanSetting;
import rockstar.client.ModeSetting;
import rockstar.client.RangeSetting;
import rockstar.client.MultiSelectSetting;
import rockstar.client.SliderSetting;
import rockstar.client.IiiIiiIII_Class217;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.iii_Class8;

public final class IiiIiiIIi_Class218 {
    private IiiIiiIIi_Class218() {
    }

    public static boolean I_method_120ab0ab(Setting iIiiiIIII_Class113) {
        return iIiiiIIII_Class113 instanceof BooleanSetting || iIiiiIIII_Class113 instanceof SliderSetting || iIiiiIIII_Class113 instanceof RangeSetting || iIiiiIIII_Class113 instanceof MultiSelectSetting || iIiiiIIII_Class113 instanceof ModeSetting;
    }

    public static iii_Class8 I_method_83bcc05d(Setting iIiiiIIII_Class113) {
        return IiiIiiIIi_Class218.i_method_f520787d(iIiiiIIII_Class113).IIiI_method_185ffdf8().I_method_e16e9925(iIiiiIIII_Class113::isVisible, IiiiIiiII_Class237.IIii_field_dd60aac, 220L);
    }

    public static iii_Class8 i_method_f520787d(Setting iIiiiIIII_Class113) {
        iii_Class8 iii_Class82 = iIiiiIIII_Class113.createComponent();
        if (iii_Class82 == null) {
            return new IiiIiiIII_Class217(iIiiiIIII_Class113);
        }
        return iii_Class82.III_method_9dc17555().I_method_5152d135(0.0f, 9.0f);
    }
}

