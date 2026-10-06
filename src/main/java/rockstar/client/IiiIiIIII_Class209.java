package rockstar.client;

import net.minecraft.client.MinecraftClient;
import pyrock.events.render.HudRenderEvent;
import rockstar.client.III;
import rockstar.client.MenuModule;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.RockstarClient;
import rockstar.client.IiiIIiiiI_Class207;
import rockstar.client.IiiIiIiiI_Class215;
import rockstar.client.IiiIiIiii_Class216;
import rockstar.client.iIIiIIiIi_Class294;

public class IiiIiIIII_Class209
implements iIIiIIiIi_Class294 {
    private final IiIIIiII_Class69<HudRenderEvent> I_field_3d936f41 = hudRenderEvent -> {
        boolean bl;
        IiiIIiiiI_Class207 iiiIIiiiI_Class207 = RockstarClient.getInstance().I_method_96982062();
        if (IiiIiIIII_Class209.I_field_3a9bda27.currentScreen == null && !(iiiIIiiiI_Class207 instanceof IiiIiIiiI_Class215)) {
            RockstarClient.getInstance().I_method_577f3d5a(new IiiIiIiiI_Class215());
        }
        boolean bl2 = bl = IiiIiIIII_Class209.I_field_3a9bda27.currentScreen instanceof IiiIIiiiI_Class207 || IiiIiIIII_Class209.I_field_3a9bda27.currentScreen instanceof IiiIiIiii_Class216;
        if (!bl && RockstarClient.getInstance().getModuleManager().getModule(MenuModule.class).isEnabled()) {
            RockstarClient.getInstance().getModuleManager().getModule(MenuModule.class).I_method_ad393368(false);
        }
        if (iiiIIiiiI_Class207 == null) {
            return;
        }
        iiiIIiiiI_Class207.getMenuAnimation().I_method_edd6dd11(iiiIIiiiI_Class207.isClosing() ? 0.0f : 1.0f);
        if (!(iiiIIiiiI_Class207 instanceof IiiIiIiiI_Class215) && iiiIIiiiI_Class207.getMenuAnimation().I_method_6ac4da6f() > 0.1f && !(IiiIiIIII_Class209.I_field_3a9bda27.currentScreen instanceof IiiIIiiiI_Class207) && iiiIIiiiI_Class207.isClosing()) {
            III iII = III.I_method_5728d20f(hudRenderEvent.getContext(), -1, -1, MinecraftClient.getInstance().getRenderTickCounter().getTickDelta(false));
            iiiIIiiiI_Class207.render(iII);
        }
    };

    public IiiIiIIII_Class209() {
        RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
    }
}

