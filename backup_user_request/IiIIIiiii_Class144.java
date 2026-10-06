package rockstar.client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import pyrock.events.window.KeyPressEvent;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.IiIIiIIII_Class145;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIIIii_Class260;
import rockstar.client.iIIiIIiIi_Class294;

public class IiIIIiiii_Class144
implements iIIiIIiIi_Class294 {
    private static final Pattern I_field_5fd3861f = Pattern.compile("(-?\\d{1,8})(?:\\s*,\\s*|\\s+)(-?\\d{1,8})(?:\\s*,\\s*|\\s+)(-?\\d{1,8})");
    private static final Pattern i_field_5fd3861f = Pattern.compile("(-?\\d{1,8})(?:\\s*,\\s*|\\s+)(-?\\d{1,8})");
    private static final int I_field_49 = 70;
    private static final String I_field_523beb0a = "ClipboardWaypoint";
    private final IiIIIiII_Class69<KeyPressEvent> I_field_3d936f41 = this::I_method_36f0a522;

    public IiIIIiiii_Class144() {
        RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
    }

    private void I_method_36f0a522(KeyPressEvent keyPressEvent) {
        if (keyPressEvent.getAction() != 1) {
            return;
        }
        if (keyPressEvent.getKey() != 86) {
            return;
        }
        if (IiIIIiiii_Class144.I_field_3a9bda27.currentScreen != null || !Screen.hasControlDown()) {
            return;
        }
        String string = IiIIIiiii_Class144.I_field_3a9bda27.keyboard.getClipboard();
        if (string == null || string.isBlank()) {
            return;
        }
        Matcher matcher = I_field_5fd3861f.matcher(string);
        if (matcher.find()) {
            this.I_method_31656fd(matcher.group(1), matcher.group(2), matcher.group(3));
            return;
        }
        Matcher matcher2 = i_field_5fd3861f.matcher(string);
        if (matcher2.find()) {
            this.I_method_31656fd(matcher2.group(1), String.valueOf(70), matcher2.group(2));
        }
    }

    private void I_method_31656fd(String string, String string2, String string3) {
        int n;
        int n2;
        int n3;
        try {
            n3 = Integer.parseInt(string);
            n2 = Integer.parseInt(string2);
            n = Integer.parseInt(string3);
        }
        catch (NumberFormatException numberFormatException) {
            n = 0;
            n2 = 0;
            n3 = 0;
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("waypoints.error_coords")));
        }
        IiIIiIIII_Class145 iiIIiIIII_Class145 = RockstarClient.getInstance().I_method_cf3ba442();
        if (iiIIiIIII_Class145.I_method_d7f564d(I_field_523beb0a)) {
            iiIIiIIII_Class145.I_method_d7f5649(I_field_523beb0a);
        }
        iiIIiIIII_Class145.I_method_b71837ba(I_field_523beb0a, n3, n2, n);
    }
}

