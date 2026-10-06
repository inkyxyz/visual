package rockstar.client;

import net.minecraft.client.MinecraftClient;
import pyrock.events.render.MenuRenderEvent;
import pyrock.events.render.PostMenuRenderEvent;
import rockstar.client.III;
import rockstar.client.RockstarClient;
import rockstar.client.IiiIiIIiI_Class211;
import rockstar.client.iIiiiiIii_Class380;

public final class IiiIiIIIi_Class210 {
    private IiiIiIIIi_Class210() {
    }

    public static void I_method_bd87019f(IiiIiIIiI_Class211 iiiIiIIiI_Class211, III iII) {
        iIiiiiIii_Class380.I_method_5f4b621f();
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new MenuRenderEvent(iII, iII.I_method_b1c3e14f(), iiiIiIIiI_Class211.I_method_8c872841(), iiiIiIIiI_Class211.iI_method_70147d12(), IiiIiIIIi_Class210.I_method_9fef0ceb(iiiIiIIiI_Class211)));
        iIiiiiIii_Class380.I_method_5f4b621f();
    }

    public static void i_method_789a4d7f(IiiIiIIiI_Class211 iiiIiIIiI_Class211, III iII) {
        iIiiiiIii_Class380.I_method_5f4b621f();
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new PostMenuRenderEvent(iII, iII.I_method_b1c3e14f(), iiiIiIIiI_Class211.I_method_8c872841(), iiiIiIIiI_Class211.iI_method_70147d12(), IiiIiIIIi_Class210.I_method_9fef0ceb(iiiIiIIiI_Class211)));
        iIiiiiIii_Class380.I_method_5f4b621f();
    }

    private static boolean I_method_9fef0ceb(IiiIiIIiI_Class211 iiiIiIIiI_Class211) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        return iiiIiIIiI_Class211.I_method_9833b243() && (minecraftClient == null || minecraftClient.currentScreen == null);
    }
}

