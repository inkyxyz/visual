package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiiiIIii_Class116;
import rockstar.client.IiiiiIIIi_Class242;

public class IiiIiiii_Class112 {
    public static void I_method_24761bd(III iII, IIiIIi_Class10 iIiIIi_Class10, IiiiIIii_Class116.Nested1_8029513 nested1_8029513, float f, float f2, float f3, float f4, boolean bl) {
        Object object;
        ColorRGBA colorRGBA = IiiiiIIIi_Class242.Ii_method_a0f56f71().withAlpha(191.25f);
        iII.drawRoundedRect(f, f2, f3, f4, IIiii_Class8.I_method_893b2757(2.0f), colorRGBA);
        if (bl) {
            object = IiiiiIIIi_Class242.i_method_5dfec6e().withAlpha(110.0f);
            iII.drawRoundedRect(f, f2, f3, f4, IIiii_Class8.I_method_893b2757(2.0f), (ColorRGBA)object);
            colorRGBA = colorRGBA.mix(((ColorRGBA)object).withAlpha(255.0f), ((ColorRGBA)object).getAlpha() / 255.0f);
        }
        iII.drawItem(nested1_8029513.I_method_c2b2cc91(), f + (f3 - 16.0f) / 2.0f, f2 + (f4 - 16.0f) / 2.0f - 6.0f, 1.0f);
        object = (nested1_8029513.I_method_d1d7d0f9() != null ? nested1_8029513.I_method_d1d7d0f9() : nested1_8029513.I_method_c2b2cc91().getName().getString()).trim();
        if (!((String)object).isEmpty()) {
            IiiIiiii_Class112.I_method_b493ff04(iII, iIiIIi_Class10, (String)object, f, f2 + f4 - 10.0f, f3, IiiiiIIIi_Class242.I_method_35ed8eaf(colorRGBA));
        }
    }

    private static void I_method_b493ff04(III iII, IIiIIi_Class10 iIiIIi_Class10, String string, float f, float f2, float f3, ColorRGBA colorRGBA) {
        List<String> list = IiiIiiii_Class112.I_method_e51b0ebe(iIiIIi_Class10, string, f3);
        if (list.size() == 1) {
            IiiIiiii_Class112.i_method_2161e724(iII, iIiIIi_Class10, list.getFirst(), f, f2, f3, colorRGBA);
        } else {
            IiiIiiii_Class112.i_method_2161e724(iII, iIiIIi_Class10, list.getFirst(), f, f2 - 2.0f, f3, colorRGBA);
            IiiIiiii_Class112.i_method_2161e724(iII, iIiIIi_Class10, list.get(1), f, f2 + iIiIIi_Class10.I_method_a649725c() - 1.0f, f3, colorRGBA);
        }
    }

    private static void i_method_2161e724(III iII, IIiIIi_Class10 iIiIIi_Class10, String string, float f, float f2, float f3, ColorRGBA colorRGBA) {
        float f4 = iIiIIi_Class10.I_method_2c375926(string);
        if (f4 <= f3) {
            iII.drawText(iIiIIi_Class10, string, f + (f3 - f4) / 2.0f + 1.0f, f2, colorRGBA);
        } else {
            iII.drawFadeoutText(iIiIIi_Class10, string, f + 2.0f, f2, colorRGBA, 0.8f, 1.0f, f3 - 4.0f);
        }
    }

    private static List<String> I_method_e51b0ebe(IIiIIi_Class10 iIiIIi_Class10, String string, float f) {
        String[] stringArray = string.split("\\s+");
        if (stringArray.length <= 1) {
            return List.of(string);
        }
        ArrayList<String> arrayList = new ArrayList<String>(2);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringArray.length; ++i) {
            String string2;
            if (stringArray[i].isEmpty()) continue;
            String string3 = string2 = stringBuilder.isEmpty() ? stringArray[i] : String.valueOf(stringBuilder) + " " + stringArray[i];
            if (iIiIIi_Class10.I_method_2c375926(string2) <= f || stringBuilder.isEmpty()) {
                stringBuilder.setLength(0);
                stringBuilder.append(string2);
                continue;
            }
            arrayList.add(stringBuilder.toString());
            stringBuilder.setLength(0);
            for (int j = i; j < stringArray.length; ++j) {
                if (stringArray[j].isEmpty()) continue;
                if (!stringBuilder.isEmpty()) {
                    stringBuilder.append(' ');
                }
                stringBuilder.append(stringArray[j]);
            }
            arrayList.add(stringBuilder.toString());
            return arrayList;
        }
        if (!stringBuilder.isEmpty()) {
            arrayList.add(stringBuilder.toString());
        }
        return arrayList.isEmpty() ? List.of(string) : arrayList;
    }
}

