package globals.client.ui;

import globals.client.GlobalsUser;
import globals.client.Information;
import globals.client.ui.RocknetMenu;
import globals.shared.proto.Packets;
import java.util.List;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.Rect;
import rockstar.client.III;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiIiIIIII_Class161;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iIIIiIIiI_Class275;
import rockstar.client.iIIiIIIiI_Class291;
import rockstar.client.iiIiIIiii_Class424;

public class AuthForm
extends Rect {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(AuthForm.class);
    private static final float RADIUS_CARD = 10.0f;
    private static final float RADIUS_INPUT = 6.0f;
    private boolean login;
    private final IiIiIIIII_Class161 loginField = new IiIiIIIII_Class161(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f));
    private final IiIiIIIII_Class161 emailField;
    private final IiIiIIIII_Class161 passwordField;
    public static final iiIiIIiii_Class424 REGISTER_TIMER = new iiIiIIiii_Class424();

    public AuthForm() {
        this.loginField.II_method_e557b20c(IiIiIIII_Class81.I_method_f25a980a("rocknet.auth.login_placeholder"));
        this.emailField = new IiIiIIIII_Class161(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f));
        this.emailField.II_method_e557b20c(IiIiIIII_Class81.I_method_f25a980a("rocknet.auth.email_placeholder"));
        this.passwordField = new IiIiIIIII_Class161(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f)).I_method_3d77f3b5();
        this.passwordField.II_method_e557b20c(IiIiIIII_Class81.I_method_f25a980a("rocknet.auth.password_placeholder"));
    }

    public void render(III iII) {
        String string;
        iII.drawRoundedRect(this.x, this.y, this.width, this.height, IIiii_Class8.I_method_893b2757(10.0f), RocknetMenu.card());
        float f = 10.0f;
        boolean bl = this.login;
        iII.drawCenteredText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(10.0f), IiIiIIII_Class81.I_method_f25a980a(bl ? "rocknet.auth.login_title" : "rocknet.auth.register_title"), this.x + this.width / 2.0f, this.y + f, RocknetMenu.text());
        f += 14.0f;
        this.loginField.I_method_fb5af064(16);
        f = this.field(iII, this.loginField, f);
        if (bl) {
            this.emailField.I_method_b043bcc(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            this.emailField.I_method_fb5af064(100);
            f = this.field(iII, this.emailField, f);
        }
        this.passwordField.I_method_fb5af064(100);
        f = this.field(iII, this.passwordField, f);
        boolean bl2 = iIIiIIIiI_Class291.I_method_da20b32b(this.x + 10.0f, this.y + f, this.width - 20.0f, 18.0, iII);
        iII.drawRoundedRect(this.x + 10.0f, this.y + f, this.width - 20.0f, 18.0f, IIiii_Class8.I_method_893b2757(6.0f), RocknetMenu.accent().mix(ColorRGBA.WHITE, bl2 ? 0.12f : 0.0f));
        iII.drawCenteredText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0f), IiIiIIII_Class81.I_method_f25a980a(bl ? "rocknet.auth.login_button" : "rocknet.auth.register_button"), this.x + this.width / 2.0f, this.y + f + 6.0f, RocknetMenu.onAccent());
        if (bl2) {
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
        }
        boolean bl3 = iIIiIIIiI_Class291.I_method_da20b32b(this.x + 10.0f, this.y + (f += 24.0f), this.width - 20.0f, 18.0, iII);
        String string2 = IiIiIIII_Class81.I_method_f25a980a("rocknet.auth.have_account") + " ";
        String string3 = IiIiIIII_Class81.I_method_f25a980a(bl ? "rocknet.auth.register" : "rocknet.auth.login_action");
        float f2 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f).I_method_2c375926(string2 + string3);
        float f3 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f).I_method_2c375926(string2);
        iII.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f), string2, this.x + this.width / 2.0f - f2 / 2.0f, this.y + f, RocknetMenu.second());
        iII.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f), string3, this.x + this.width / 2.0f - f2 / 2.0f + f3, this.y + f, RocknetMenu.accent().mulAlpha(bl3 ? 0.7f : 1.0f));
        if (bl3) {
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
        }
        if ((string = Information.getResult()) == null || string.isBlank()) {
            string = IiIiIIII_Class81.I_method_f25a980a("rocknet.auth.independent_account");
        }
        List<String> list = RocknetMenu.wrapText(string, 150.0f);
        float f4 = 0.0f;
        for (String string4 : list) {
            iII.drawCenteredText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f), string4, this.x + this.width / 2.0f, this.y + this.height + 8.0f + f4, RocknetMenu.second());
            f4 += IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f).I_method_a649725c() + 2.0f;
        }
    }

    private float field(III iII, IiIiIIIII_Class161 iiIiIIIII_Class161, float f) {
        iII.drawRoundedRect(this.x + 10.0f, this.y + f, this.width - 20.0f, 18.0f, IIiii_Class8.I_method_893b2757(6.0f), RocknetMenu.inset());
        iiIiIIIII_Class161.I_method_b043bcc(this.x + 10.0f, this.y + f, this.width - 20.0f, 18.0f);
        iiIiIIIII_Class161.I_method_13a617e0(RocknetMenu.text());
        iiIiIIIII_Class161.I_method_7ae26dda(iII);
        return f + 23.0f;
    }

    public void onMouseClicked(double d, double d2, IiIII_Class9 iiIII_Class9) {
        if (iiIII_Class9 != IiIII_Class9.II_field_2f4c8d6c) {
            this.loginField.I_method_400ceaa7(d, d2, iiIII_Class9);
            this.emailField.I_method_400ceaa7(d, d2, iiIII_Class9);
            this.passwordField.I_method_400ceaa7(d, d2, iiIII_Class9);
        }
        if (this.login) {
            boolean bl;
            boolean bl2 = iIIiIIIiI_Class291.I_method_c3f86263(this.x + 10.0f, this.y + 70.0f, this.width - 20.0f, 18.0, d, d2);
            String string = this.loginField.I_method_d2579001().trim();
            String string2 = this.passwordField.I_method_d2579001().trim();
            if (bl2 && !string.isBlank() && !string2.isBlank()) {
                RockstarClient.getInstance().I_method_cd3d46d0().send(new Packets.Nested1_8daaedde(string, string2, "Rockstar".toLowerCase()));
                Information.setPreferUser(new GlobalsUser(string, string2, "Rockstar".toLowerCase()));
            }
            if (bl = iIIiIIIiI_Class291.I_method_c3f86263(this.x + 10.0f, this.y + 94.0f, this.width - 20.0f, 18.0, d, d2)) {
                this.login = false;
            }
        } else {
            boolean bl;
            boolean bl3 = iIIiIIIiI_Class291.I_method_c3f86263(this.x + 10.0f, this.y + 93.0f, this.width - 20.0f, 18.0, d, d2);
            String string = this.loginField.I_method_d2579001().trim();
            String string3 = this.emailField.I_method_d2579001().trim();
            String string4 = this.passwordField.I_method_d2579001().trim();
            if (bl3 && !string.isBlank() && !string3.isBlank() && !string4.isBlank()) {
                RockstarClient.getInstance().I_method_cd3d46d0().send(new Packets.Nested1_6483a00e(string, string3, string4, "Rockstar".toLowerCase()));
                Information.setPreferUser(new GlobalsUser(string, string4, "Rockstar".toLowerCase()));
                REGISTER_TIMER.I_method_23e11e3f();
            }
            if (bl = iIIiIIIiI_Class291.I_method_c3f86263(this.x + 10.0f, this.y + 117.0f, this.width - 20.0f, 18.0, d, d2)) {
                this.login = true;
            }
        }
    }

    public void onMouseReleased(double d, double d2, IiIII_Class9 iiIII_Class9) {
        if (this.loginField.I_method_189fd283()) {
            this.loginField.i_method_6a097ac7(d, d2, iiIII_Class9);
        }
        if (this.emailField.I_method_189fd283()) {
            this.emailField.i_method_6a097ac7(d, d2, iiIII_Class9);
        }
        if (this.passwordField.I_method_189fd283()) {
            this.passwordField.i_method_6a097ac7(d, d2, iiIII_Class9);
        }
    }

    public void keyPressed(int n, int n2, int n3) {
        this.loginField.I_method_c1acbc24(n, n2, n3);
        this.emailField.I_method_c1acbc24(n, n2, n3);
        this.passwordField.I_method_c1acbc24(n, n2, n3);
    }

    public void charTyped(char c, int n) {
        if (this.loginField.I_method_189fd283()) {
            this.loginField.I_method_b71e84c9(c, n);
        }
        if (this.emailField.I_method_189fd283()) {
            this.emailField.I_method_b71e84c9(c, n);
        }
        if (this.passwordField.I_method_189fd283()) {
            this.passwordField.I_method_b71e84c9(c, n);
        }
    }

    @Generated
    public boolean isLogin() {
        return this.login;
    }
}

