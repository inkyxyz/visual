package rockstar.client;

import java.util.Optional;
import rockstar.client.IIIiiIIi_Class26;
import rockstar.client.IIIiiIiI_Class27;
import rockstar.client.IIIiiIii_Class28;
import rockstar.client.iiIiIiIII_Class425;
import rockstar.client.iiIiiIiIi_Class438;
import rockstar.client.iiIiiIiii_Class440;
import rockstar.client.iiIiiiIIi_Class442;
import rockstar.client.iiIiiiIiI_Class443;
import rockstar.client.iiIiiiIii_Class444;
import rockstar.client.iiIiiiiII_Class445;
import rockstar.client.iiIiiiiiI_Class447;
import rockstar.client.iiiIIIIii_Class452;
import rockstar.client.iiiiIIiII_Class485;

public final class iiIiiiiIi_Class446 {
    public IIIiiIIi_Class26 I_method_8b3bf9b8() {
        return IIIiiIiI_Class27.I_method_fa8865f9("newton", iIIiiIiI_Class27 -> iIIiiIiI_Class27.i_method_cfe1a061("commands.newton.description").I_method_b3f941e4("nt").I_method_9449fb2d(new iiIiiiIii_Class444().I_method_d64c7578(), new iiIiiiiII_Class445().I_method_ee22f198(), new iiIiiiiiI_Class447().I_method_f42aed78(), new iiIiiiIIi_Class442().I_method_d0447998(), new iiIiiiIiI_Class443().I_method_39336d58(), this.i_method_b53889d8(), this.II_method_288b0c15(), this.Ii_method_52879c35(), this.iI_method_3e207ff5(), this.ii_method_681d1015()).I_method_16f05c8a(this::I_method_8e4662e0)).I_method_9111538b();
    }

    private IIIiiIIi_Class26 i_method_b53889d8() {
        return IIIiiIiI_Class27.I_method_fa8865f9("stop", iIIiiIiI_Class27 -> iIIiiIiI_Class27.i_method_cfe1a061("commands.newton.stop").I_method_b3f941e4("cancel", "\u0441\u0442\u043e\u043f").I_method_16f05c8a(iIIiiIii_Class28 -> {
            iiIiiIiIi_Class438 iiIiiIiIi_Class4382 = iiIiiIiIi_Class438.I_method_12f562b5();
            boolean bl = iiIiiIiIi_Class4382.I_method_d87feab5().I_method_7d4e6203();
            iiIiiIiIi_Class4382.I_method_d87feab5().I_method_7d4e61ff();
            iiIiiIiIi_Class4382.I_method_14b8caf5().i_method_35abae1f();
            iiiIIIIii_Class452.I_method_15375629(bl ? "\u041f\u0440\u043e\u0446\u0435\u0441\u0441 \u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d" : "\u041d\u0435\u0442 \u0430\u043a\u0442\u0438\u0432\u043d\u043e\u0433\u043e \u043f\u0440\u043e\u0446\u0435\u0441\u0441\u0430");
        })).I_method_9111538b();
    }

    private IIIiiIIi_Class26 II_method_288b0c15() {
        return IIIiiIiI_Class27.I_method_fa8865f9("pause", iIIiiIiI_Class27 -> iIIiiIiI_Class27.i_method_cfe1a061("commands.newton.pause").I_method_b3f941e4("\u043f\u0430\u0443\u0437\u0430").I_method_16f05c8a(iIIiiIii_Class28 -> iiIiiiiIi_Class446.I_method_29c10646().ifPresentOrElse(iiiiIIiII_Class4852 -> {
            iiiiIIiII_Class4852.i_method_8f4a01df();
            iiiIIIIii_Class452.I_method_15375629("\u041f\u0430\u0443\u0437\u0430");
        }, () -> iiiIIIIii_Class452.i_method_e5eeaa09("\u041d\u0435\u0442 \u0430\u043a\u0442\u0438\u0432\u043d\u043e\u0433\u043e \u043f\u0440\u043e\u0446\u0435\u0441\u0441\u0430")))).I_method_9111538b();
    }

    private IIIiiIIi_Class26 Ii_method_52879c35() {
        return IIIiiIiI_Class27.I_method_fa8865f9("resume", iIIiiIiI_Class27 -> iIIiiIiI_Class27.i_method_cfe1a061("commands.newton.resume").I_method_b3f941e4("\u043f\u0440\u043e\u0434\u043e\u043b\u0436\u0438\u0442\u044c").I_method_16f05c8a(iIIiiIii_Class28 -> iiIiiiiIi_Class446.I_method_29c10646().ifPresentOrElse(iiiiIIiII_Class4852 -> {
            iiiiIIiII_Class4852.II_method_58424142();
            iiiIIIIii_Class452.I_method_15375629("\u041f\u0440\u043e\u0434\u043e\u043b\u0436\u0430\u0435\u043c");
        }, () -> iiiIIIIii_Class452.i_method_e5eeaa09("\u041d\u0435\u0442 \u0430\u043a\u0442\u0438\u0432\u043d\u043e\u0433\u043e \u043f\u0440\u043e\u0446\u0435\u0441\u0441\u0430")))).I_method_9111538b();
    }

    private IIIiiIIi_Class26 iI_method_3e207ff5() {
        return IIIiiIiI_Class27.I_method_fa8865f9("status", iIIiiIiI_Class27 -> iIIiiIiI_Class27.i_method_cfe1a061("commands.newton.status").I_method_b3f941e4("info", "\u0441\u0442\u0430\u0442\u0443\u0441").I_method_16f05c8a(iIIiiIii_Class28 -> iiIiiiiIi_Class446.I_method_29c10646().ifPresentOrElse(iiiiIIiII_Class4852 -> iiiIIIIii_Class452.I_method_15375629(iiiiIIiII_Class4852.I_method_31075c81() + ": " + iiiiIIiII_Class4852.i_method_c4260ca1()), () -> iiiIIIIii_Class452.i_method_e5eeaa09("\u041d\u0435\u0442 \u0430\u043a\u0442\u0438\u0432\u043d\u043e\u0433\u043e \u043f\u0440\u043e\u0446\u0435\u0441\u0441\u0430")))).I_method_9111538b();
    }

    private IIIiiIIi_Class26 ii_method_681d1015() {
        return IIIiiIiI_Class27.I_method_fa8865f9("neuro", iIIiiIiI_Class27 -> iIIiiIiI_Class27.i_method_cfe1a061("commands.newton.neuro").I_method_b3f941e4("\u043d\u0435\u0439\u0440\u043e").I_method_16f05c8a(iIIiiIii_Class28 -> {
            if (iiIiIiIII_Class425.Ii_field_5a) {
                iiIiIiIII_Class425.Ii_field_5a = false;
                iiiIIIIii_Class452.I_method_15375629("\u041d\u0435\u0439\u0440\u043e-\u0440\u043e\u0442\u0430\u0446\u0438\u044f \u0432\u044b\u043a\u043b\u044e\u0447\u0435\u043d\u0430 \u2014 \u043f\u043e\u0432\u043e\u0440\u043e\u0442\u044b \u043b\u0438\u043d\u0435\u0439\u043d\u044b\u0435");
                return;
            }
            if (!iiIiiIiii_Class440.I_method_ad0f4223()) {
                iiiIIIIii_Class452.i_method_e5eeaa09("\u041c\u043e\u0434\u0435\u043b\u044c \u043d\u0435 \u0437\u0430\u0433\u0440\u0443\u0436\u0435\u043d\u0430 \u2014 \u0441\u043d\u0430\u0447\u0430\u043b\u0430 .neuro load <\u0438\u043c\u044f> (\u0438\u043b\u0438 .neuro train)");
                return;
            }
            iiIiIiIII_Class425.Ii_field_5a = true;
            iiiIIIIii_Class452.I_method_15375629("\u041d\u0435\u0439\u0440\u043e-\u0440\u043e\u0442\u0430\u0446\u0438\u044f \u0432\u043a\u043b\u044e\u0447\u0435\u043d\u0430 \u2014 \u043c\u043e\u0434\u0435\u043b\u044c \u00ab" + iiIiiIiii_Class440.I_method_e6015461() + "\u00bb");
        })).I_method_9111538b();
    }

    private static Optional<iiiiIIiII_Class485> I_method_29c10646() {
        return iiIiiIiIi_Class438.I_method_12f562b5().I_method_d87feab5().I_method_82bc9266();
    }

    private void I_method_8e4662e0(IIIiiIii_Class28 iIIiiIii_Class28) {
        iiiIIIIii_Class452.I_method_15375629("Newton \u2014 \u043a\u043e\u043c\u0430\u043d\u0434\u044b:");
        iiiIIIIii_Class452.I_method_15375629(" .newton goto <x> [y] <z> [elytra] \u2014 \u0438\u0434\u0442\u0438 \u043a \u043a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u0430\u043c");
        iiiIIIIii_Class452.I_method_15375629(" .newton mine <block> \u2014 \u043a\u043e\u043f\u0430\u0442\u044c \u0431\u043b\u043e\u043a\u0438 \u044d\u0442\u043e\u0433\u043e \u0442\u0438\u043f\u0430");
        iiiIIIIii_Class452.I_method_15375629(" .newton sel \u2014 \u0432\u044b\u0434\u0435\u043b\u0438\u0442\u044c \u0443\u0433\u043e\u043b \u043e\u0431\u043b\u0430\u0441\u0442\u0438 (\u0441\u043c\u043e\u0442\u0440\u044f \u043d\u0430 \u0431\u043b\u043e\u043a), 2 \u0440\u0430\u0437\u0430");
        iiiIIIIii_Class452.I_method_15375629(" .newton cleararea [block|stop] \u2014 \u0440\u0430\u0441\u043a\u043e\u043f\u0430\u0442\u044c \u0432\u044b\u0434\u0435\u043b\u0435\u043d\u043d\u0443\u044e \u043e\u0431\u043b\u0430\u0441\u0442\u044c");
        iiiIIIIii_Class452.I_method_15375629(" .newton fill <block|stop> \u2014 \u0437\u0430\u043f\u043e\u043b\u043d\u0438\u0442\u044c \u0432\u044b\u0434\u0435\u043b\u0435\u043d\u043d\u0443\u044e \u043e\u0431\u043b\u0430\u0441\u0442\u044c");
        iiiIIIIii_Class452.I_method_15375629(" .newton stop / pause / resume / status \u2014 \u0443\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435 \u043f\u0440\u043e\u0446\u0435\u0441\u0441\u043e\u043c");
        iiiIIIIii_Class452.I_method_15375629(" .newton neuro \u2014 \u0432\u043a\u043b/\u0432\u044b\u043a\u043b \u043d\u0435\u0439\u0440\u043e-\u0440\u043e\u0442\u0430\u0446\u0438\u044e (\u043d\u0443\u0436\u043d\u0430 \u043c\u043e\u0434\u0435\u043b\u044c \u0438\u0437 .neuro load)");
    }
}

