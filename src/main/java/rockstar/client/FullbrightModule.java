package rockstar.client;

import net.minecraft.client.MinecraftClient;
import pyrock.events.player.ClientPlayerTickEvent;

@ModuleInfo(
    name = "Fullbright",
    category = ModuleCategory.VISUALS,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.fullbright"
)
public class FullbrightModule extends Module {
    private double previousGamma = 1.0;

    private final IiIIIiII_Class69<ClientPlayerTickEvent> onTick = event -> {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.options != null && mc.options.getGamma().getValue() < 16.0) {
            mc.options.getGamma().setValue(16.0);
        }
    };

    public FullbrightModule() {
    }

    @Override
    public void onEnable() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.options != null) {
            this.previousGamma = mc.options.getGamma().getValue();
            mc.options.getGamma().setValue(16.0);
        }
    }

    @Override
    public void onDisable() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.options != null) {
            mc.options.getGamma().setValue(this.previousGamma);
        }
    }
}
