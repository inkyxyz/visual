package rockstar.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;
import pyrock.events.render.HudLayerRenderEvent;
import pyrock.events.render.PostHudLayerRenderEvent;
import rockstar.client.III;
import rockstar.client.RockstarClient;
import rockstar.client.iIiiiiIii_Class380;

public final class IiIiIIiIi_Class166 {
    private IiIiIIiIi_Class166() {
    }

    public static void I_method_3022089c(III iII, int n) {
        iIiiiiIii_Class380.I_method_5f4b621f();
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new HudLayerRenderEvent(iII, iII.I_method_b1c3e14f(), n, IiIiIIiIi_Class166.I_method_4b608243()));
        iIiiiiIii_Class380.I_method_5f4b621f();
    }

    public static void i_method_6b4c6c7c(III iII, int n) {
        iIiiiiIii_Class380.I_method_5f4b621f();
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new PostHudLayerRenderEvent(iII, iII.I_method_b1c3e14f(), n, IiIiIIiIi_Class166.I_method_4b608243()));
        iIiiiiIii_Class380.I_method_5f4b621f();
    }

    private static boolean I_method_4b608243() {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        return minecraftClient != null && minecraftClient.currentScreen instanceof ChatScreen;
    }
}

