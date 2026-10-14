package rockstar.client;

import net.minecraft.client.MinecraftClient;
import pyrock.events.player.ClientPlayerTickEvent;

@ModuleInfo(
    name = "No Jump Delay",
    category = ModuleCategory.MOVEMENT,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.nojumpdelay"
)
public class NoJumpDelayModule extends Module {
    private final SliderSetting delayTicks = new SliderSetting(this, "modules.settings.delay_ticks")
        .I_method_c8c9a7d7(0.0F)
        .i_method_65e2aff7(5.0F)
        .II_method_b0f56334(1.0F)
        .Ii_method_4e0e6b54(0.0F);

    private final IiIIIiII_Class69<ClientPlayerTickEvent> onTick = event -> {
        // In vanilla Minecraft, living entity jump delay is handled by jumpingCooldown
        // Handled via mixin or tick resets
    };

    public NoJumpDelayModule() {
    }

    public int getDelay() {
        return (int) this.delayTicks.Ii_method_a20abcd2();
    }

    @Override
    public String i_method_bf522194() {
        return "Убирает задержку между прыжками для непрерывного и скоростного банихопа.";
    }
}
