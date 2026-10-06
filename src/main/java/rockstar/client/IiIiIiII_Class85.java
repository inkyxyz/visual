package rockstar.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pyrock.events.window.KeyPressEvent;
import rockstar.client.IIIiiiIi_Class30;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.IiIiIIii_Class84;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIIIII_Class257;
import rockstar.client.iIIiIIiIi_Class294;

public class IiIiIiII_Class85
implements iIIiIIiIi_Class294 {
    private final List<IiIiIIii_Class84> I_field_7865b31 = new ArrayList<IiIiIIii_Class84>();
    private final IiIIIiII_Class69<KeyPressEvent> I_field_3d936f41 = keyPressEvent -> {
        if (IiIiIiII_Class85.I_field_3a9bda27.player == null || I_field_3a9bda27.getNetworkHandler() == null) {
            return;
        }
        if (IiIiIiII_Class85.I_field_3a9bda27.currentScreen != null) {
            return;
        }
        if (keyPressEvent.getAction() != 1) {
            return;
        }
        for (IiIiIIii_Class84 iiIiIIii_Class84 : this.I_field_7865b31) {
            if (!iIIIIIIII_Class257.I_method_967132c3(iiIiIIii_Class84.I_method_886a907f(), keyPressEvent.getKey())) continue;
            this.I_method_67bf9ead(iiIiIIii_Class84);
        }
    };

    public IiIiIiII_Class85() {
        RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
    }

    public final void I_method_2f3b428d(String string, int n) {
        this.I_field_7865b31.add(new IiIiIIii_Class84(n, string));
    }

    public final boolean I_method_7488d01b(int n) {
        return this.I_field_7865b31.removeIf(iiIiIIii_Class84 -> iiIiIIii_Class84.I_method_886a907f() == n);
    }

    public final boolean I_method_9c8173a(String string) {
        return this.I_field_7865b31.removeIf(iiIiIIii_Class84 -> iiIiIIii_Class84.I_method_f1090d94().equalsIgnoreCase(string));
    }

    public final boolean I_method_2f3b4291(String string, int n) {
        return this.I_field_7865b31.removeIf(iiIiIIii_Class84 -> iiIiIIii_Class84.I_method_886a907f() == n && iiIiIIii_Class84.I_method_f1090d94().equalsIgnoreCase(string));
    }

    public final void I_method_b12db06c() {
        this.I_field_7865b31.clear();
    }

    public final void I_method_3265e55d(List<IiIiIIii_Class84> list) {
        this.I_field_7865b31.clear();
        this.I_field_7865b31.addAll(list);
    }

    public final List<IiIiIIii_Class84> I_method_e1cbbc5b() {
        return Collections.unmodifiableList(this.I_field_7865b31);
    }

    private void I_method_67bf9ead(IiIiIIii_Class84 iiIiIIii_Class84) {
        String string = iiIiIIii_Class84.I_method_f1090d94();
        if (string == null || string.isBlank() || IiIiIiII_Class85.I_field_3a9bda27.player == null || I_field_3a9bda27.getNetworkHandler() == null) {
            return;
        }
        IIIiiiIi_Class30 iIIiiiIi_Class30 = RockstarClient.getInstance().I_method_b4d046cb();
        if (iIIiiiIi_Class30 != null) {
            String string2 = iIIiiiIi_Class30.I_method_80ea594();
            if (!string2.isEmpty() && string.startsWith(string2 + string2)) {
                IiIiIiII_Class85.I_field_3a9bda27.player.networkHandler.sendChatMessage(string.substring(string2.length()));
                return;
            }
            if (!string2.isEmpty() && string.startsWith(string2)) {
                iIIiiiIi_Class30.I_method_9e86975a(string);
                return;
            }
        }
        if (string.startsWith("/")) {
            IiIiIiII_Class85.I_field_3a9bda27.player.networkHandler.sendChatCommand(string.substring(1));
        } else {
            IiIiIiII_Class85.I_field_3a9bda27.player.networkHandler.sendChatMessage(string);
        }
    }
}

