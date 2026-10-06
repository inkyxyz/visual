package rockstar.client;

import globals.shared.proto.Packets;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import lombok.Generated;
import pyrock.events.client.NotificationEvent;
import pyrock.events.render.HudRenderEvent;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.RockstarClient;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iiIiIIIII_Class417;
import rockstar.client.iiIiiiI_Class111;
import rockstar.client.iiiIIII_Class113;
import rockstar.client.iiiIIIi_Class114;
import rockstar.client.iiiIIiI_Class115;
import rockstar.client.iiiIIii_Class116;
import rockstar.client.iiiIiiI_Class119;

public class iiIiiii_Class112 {
    private final List<iiIiiiI_Class111> I_field_7865b31 = new CopyOnWriteArrayList<iiIiiiI_Class111>();
    private final IiIIIiII_Class69<HudRenderEvent> I_field_3d936f41 = hudRenderEvent -> {
        float f = 0.0f;
        float f2 = 0.0f;
        for (iiIiiiI_Class111 iiIiiiI_Class1112 : this.I_field_7865b31) {
            iiIiiiI_Class1112.I_method_ddda8cbf();
            if (iiIiiiI_Class1112 instanceof iiiIIiI_Class115) {
                iiIiiiI_Class1112.I_method_92bd6423(hudRenderEvent.getContext(), 0.0f);
                continue;
            }
            if (iiIiiiI_Class1112 instanceof iiiIIii_Class116) {
                iiIiiiI_Class1112.I_method_92bd6423(hudRenderEvent.getContext(), f);
                if (!(iiIiiiI_Class1112.I_field_dc7facc.I_method_6ac4da6f() >= 0.5f)) continue;
                f += 30.0f;
                continue;
            }
            if (!(iiIiiiI_Class1112 instanceof iiiIiiI_Class119) && !(iiIiiiI_Class1112 instanceof iiiIIIi_Class114)) continue;
            iiIiiiI_Class1112.I_method_92bd6423(hudRenderEvent.getContext(), f2);
            if (!(iiIiiiI_Class1112.I_field_dc7facc.I_method_6ac4da6f() >= 0.5f)) continue;
            f2 += iiIiiiI_Class1112.I_method_ddda8caf();
        }
        this.I_field_7865b31.removeIf(iiIiiiI_Class111::I_method_ddda8cc3);
    };

    public iiIiiii_Class112() {
        RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
    }

    public void I_method_67864747(iiIiiiI_Class111 iiIiiiI_Class1112) {
        this.I_method_fad5059d(() -> {
            this.I_field_7865b31.add(iiIiiiI_Class1112);
            this.i_method_9182d767(iiIiiiI_Class1112);
        });
    }

    public void I_method_8ee48d11(iiiIIII_Class113 iiiIIII_Class1132, String string) {
        this.I_method_67864747(new iiiIIiI_Class115(iiiIIII_Class1132, string));
    }

    public void I_method_20d0f49b(iiiIIII_Class113 iiiIIII_Class1132, String string, String string2) {
        this.I_method_67864747(new iiiIIIi_Class114(iiiIIII_Class1132, string, string2));
    }

    public void I_method_1b4230d6(Packets.Nested1_e38dcab6 nested1_e38dcab6, String string) {
        this.I_method_fad5059d(() -> {
            if (iIIiIIiIi_Class294.I_field_3a9bda27.player == null) {
                return;
            }
            this.I_method_67864747(new iiiIIii_Class116(nested1_e38dcab6, string));
            iiIiIIIII_Class417.Ii_field_34b2ba6c.I_method_87d2e181(1.0f);
        });
    }

    public void i_method_cdc350f6(Packets.Nested1_e38dcab6 nested1_e38dcab6, String string) {
        this.I_method_fad5059d(() -> {
            if (iIIiIIiIi_Class294.I_field_3a9bda27.player == null) {
                return;
            }
            this.I_method_67864747(new iiiIIii_Class116(nested1_e38dcab6, string, true));
            iiIiIIIII_Class417.Ii_field_34b2ba6c.I_method_87d2e181(1.0f);
        });
    }

    private void I_method_fad5059d(Runnable runnable) {
        if (iIIiIIiIi_Class294.I_field_3a9bda27.isOnThread()) {
            runnable.run();
            return;
        }
        iIIiIIiIi_Class294.I_field_3a9bda27.execute(runnable);
    }

    private void i_method_9182d767(iiIiiiI_Class111 iiIiiiI_Class1112) {
        String string;
        String string2 = "info";
        String string3 = "";
        String string4 = "";
        if (iiIiiiI_Class1112 instanceof iiiIIiI_Class115) {
            iiiIIiI_Class115 iiiIIiI_Class1152 = (iiiIIiI_Class115)iiIiiiI_Class1112;
            string = "island";
            string2 = iiiIIiI_Class1152.I_method_b5def915().I_method_f3dcd601();
            string4 = iiiIIiI_Class1152.I_method_740eb1e1();
        } else if (iiIiiiI_Class1112 instanceof iiiIIIi_Class114) {
            iiiIIIi_Class114 iiiIIIi_Class1142 = (iiiIIIi_Class114)iiIiiiI_Class1112;
            string = "crosshair";
            string2 = iiiIIIi_Class1142.I_method_2e5b64d5().I_method_f3dcd601();
            string3 = iiiIIIi_Class1142.I_method_3a0ffe21();
            string4 = iiiIIIi_Class1142.i_method_cd2eae41();
        } else if (iiIiiiI_Class1112 instanceof iiiIIii_Class116) {
            iiiIIii_Class116 iiiIIii_Class1162 = (iiiIIii_Class116)iiIiiiI_Class1112;
            string = "irc";
            string3 = iiiIIii_Class1162.I_method_ba41da01();
            string4 = iiiIIii_Class1162.i_method_4d608a21();
        } else if (iiIiiiI_Class1112 instanceof iiiIiiI_Class119) {
            iiiIiiI_Class119 iiiIiiI_Class1192 = (iiiIiiI_Class119)iiIiiiI_Class1112;
            string = "mini";
            string4 = iiiIiiI_Class1192.I_method_fa185201();
            string3 = iiiIiiI_Class1192.i_method_8d370221() == null ? "" : iiiIiiI_Class1192.i_method_8d370221();
        } else {
            string = "other";
        }
        try {
            RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new NotificationEvent(string, string2, string3 == null ? "" : string3, string4 == null ? "" : string4));
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Generated
    public List<iiIiiiI_Class111> I_method_57b4ffc8() {
        return this.I_field_7865b31;
    }

    @Generated
    public IiIIIiII_Class69<HudRenderEvent> I_method_1aa8318() {
        return this.I_field_3d936f41;
    }
}

