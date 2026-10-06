package rockstar.client;

import pyrock.events.newton.NewtonFailedEvent;
import pyrock.events.newton.NewtonFinishedEvent;
import pyrock.events.newton.NewtonNodeEvent;
import pyrock.events.newton.NewtonPathEvent;
import pyrock.events.newton.NewtonStartedEvent;
import rockstar.client.IiIIIIIi_Class66;
import rockstar.client.RockstarClient;
import rockstar.client.iiIiIiiIi_Class430;
import rockstar.client.iiIiIiiiI_Class431;
import rockstar.client.iiIiIiiii_Class432;
import rockstar.client.iiIiiIIII_Class433;
import rockstar.client.iiIiiIIIi_Class434;
import rockstar.client.iiIiiIiIi_Class438;

public final class iiIiiIiiI_Class439 {
    private iiIiiIiiI_Class439() {
    }

    public static void I_method_feb7e649(String string) {
        iiIiiIiiI_Class439.I_method_569c1ec0(new NewtonStartedEvent(string));
    }

    public static void I_method_d84555da(String string, int n) {
        iiIiiIiiI_Class439.I_method_569c1ec0(new NewtonPathEvent(string, n));
        iiIiiIiiI_Class439.I_method_cd5ef8a7(new iiIiiIIIi_Class434(string, n));
    }

    public static void I_method_1d99019a(String string, int n, int n2, int n3, int n4, int n5) {
        iiIiiIiiI_Class439.I_method_569c1ec0(new NewtonNodeEvent(string, n, n2, n3, n4, n5));
        iiIiiIiiI_Class439.I_method_cd5ef8a7(new iiIiIiiiI_Class431(string, n, n2, n3, n4, n5));
    }

    public static void i_method_cf6f3a29(String string) {
        iiIiiIiiI_Class439.I_method_569c1ec0(new NewtonFinishedEvent(string));
        iiIiiIiiI_Class439.I_method_cd5ef8a7(new iiIiiIIII_Class433(string));
    }

    public static void I_method_9b256fd3(String string, String string2) {
        iiIiiIiiI_Class439.I_method_569c1ec0(new NewtonFailedEvent(string, string2));
        iiIiiIiiI_Class439.I_method_cd5ef8a7(new iiIiIiiii_Class432(string, string2));
    }

    private static void I_method_569c1ec0(IiIIIIIi_Class66 iiIIIIIi_Class66) {
        try {
            RockstarClient ii_Class2 = RockstarClient.getInstance();
            if (ii_Class2 != null && ii_Class2.I_method_7897deab() != null) {
                ii_Class2.I_method_7897deab().I_method_e7f802ad(iiIIIIIi_Class66);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static void I_method_cd5ef8a7(iiIiIiiIi_Class430 iiIiIiiIi_Class4302) {
        try {
            if (iiIiiIiIi_Class438.I_method_1047da03()) {
                iiIiiIiIi_Class438.I_method_12f562b5().I_method_12e74b15().I_method_f2470087(iiIiIiiIi_Class4302);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }
}

