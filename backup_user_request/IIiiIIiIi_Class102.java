package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.Identifier;
import pyrock.events.render.PreHudRenderEvent;
import pyrock.events.window.KeyPressEvent;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIiIIiIi_Class294;

public class IIiiIIiIi_Class102
implements iIIiIIiIi_Class294 {
    private static final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(1000L, IiiiIiiII_Class237.IIIi_field_dd60aac);
    private static boolean I_field_5a = true;
    private static final List<Integer> I_field_7865b31 = new ArrayList<Integer>();
    private static boolean i_field_5a = false;
    private static boolean II_field_5a = false;
    private static final int[] I_field_b4e = new int[]{67, 68, 74};
    private final IiIIIiII_Class69<KeyPressEvent> I_field_3d936f41 = keyPressEvent -> {
        int n = keyPressEvent.getKey();
        int n2 = keyPressEvent.getAction();
        if (n == 90) {
            i_field_5a = n2 != 0;
        } else if (n == 86) {
            boolean bl = II_field_5a = n2 != 0;
        }
        if (i_field_5a && II_field_5a) {
            this.I_method_71345dff();
        }
    };
    private final IiIIIiII_Class69<PreHudRenderEvent> i_field_3d936f41 = preHudRenderEvent -> {
        if ((double)I_field_dc7facc.I_method_6ac4da6f() == 1.0 && !I_field_5a) {
            I_field_5a = true;
        }
        I_field_dc7facc.I_method_edd6dd11(I_field_5a ? 0.0f : 1.0f);
        if (I_field_dc7facc.I_method_6ac4da6f() == 0.0f && I_field_5a) {
            return;
        }
        float f = 200.0f;
        float f2 = ((float)I_field_3a9bda27.getWindow().getScaledWidth() - f) / 2.0f;
        float f3 = ((float)I_field_3a9bda27.getWindow().getScaledHeight() - f) / 2.0f;
        Identifier identifier = RockstarClient.id("icons/poshalko.png");
        preHudRenderEvent.getContext().drawTexture(identifier, f2, f3, f, f, IiiiiIIIi_Class242.Ii_field_d0c8ec5.withAlpha(255.0f * I_field_dc7facc.I_method_6ac4da6f()));
    };

    public IIiiIIiIi_Class102() {
        RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
    }

    private void I_method_71345dff() {
        I_field_5a = false;
        I_field_dc7facc.I_method_edd6dd11(1.0f);
    }
}

